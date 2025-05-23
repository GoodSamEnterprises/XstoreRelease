/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.Base64;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.hrs.EmployeePasswordId;
/*     */ import dtv.xst.dao.hrs.IEmployee;
/*     */ import dtv.xst.dao.hrs.IEmployeeModel;
/*     */ import dtv.xst.dao.hrs.IEmployeePassword;
/*     */ import dtv.xst.dao.hrs.IEmployeeProperty;
/*     */ import dtv.xst.dao.hrs.IEmployeeStore;
/*     */ import dtv.xst.daocommon.EmployeeStatus;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EmployeeBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IEmployeeProperty>
/*     */   implements IEmployeeModel, IEmployee
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  29 */   private static final IQueryKey<IEmployeePassword> EMPLOYEE_PASSWORD = (IQueryKey<IEmployeePassword>)new QueryKey("EMPLOYEE_PASSWORD", IEmployeePassword.class);
/*     */   
/*     */   private transient byte[] groupMembershipCache_;
/*     */   
/*     */   private transient String lastMembership_;
/*  34 */   private List<IEmployeePassword> _employeePasswords = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEmployeePassword(IEmployeePassword argEmployeePwd) {
/*  39 */     this._employeePasswords.add(argEmployeePwd);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEmployeeStore(IEmployeeStore argEmployeeStore) {
/*  45 */     synchronized (this) {
/*  46 */       argEmployeeStore.setEmployeeStoreSequence(getEmployeeStores().size() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEmployeePassword getCurrentPassword() {
/*  53 */     IEmployeePassword currentPassword = null;
/*     */     
/*  55 */     for (IEmployeePassword password : getEmployeePasswords()) {
/*  56 */       if (password.getCurrent()) {
/*  57 */         currentPassword = password;
/*     */       }
/*     */     } 
/*     */     
/*  61 */     return currentPassword;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IEmployeePassword> getEmployeePasswords() {
/*  67 */     if (this._employeePasswords.isEmpty()) {
/*  68 */       Map<String, Object> params = new HashMap<>();
/*  69 */       params.put("argEmployeeId", getEmployeeId());
/*  70 */       this._employeePasswords = (List<IEmployeePassword>)DataFactory.getObjectByQueryNoThrow(EMPLOYEE_PASSWORD, params);
/*     */ 
/*     */ 
/*     */       
/*  74 */       DataFactory.makePersistent(this._employeePasswords);
/*     */     } 
/*  76 */     return this._employeePasswords;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getGroupMembership() {
/*  82 */     String groupMembership = getDAO_().getGroupMembershipRaw();
/*     */     
/*  84 */     if (this.groupMembershipCache_ == null || this.lastMembership_ != groupMembership) {
/*     */       try {
/*  86 */         this.groupMembershipCache_ = Base64.base64ToByteArray(groupMembership);
/*  87 */         this.lastMembership_ = groupMembership;
/*     */       }
/*  89 */       catch (Exception ex) {
/*  90 */         this.groupMembershipCache_ = null;
/*     */       } 
/*     */     }
/*     */     
/*  94 */     return this.groupMembershipCache_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOperatorId() {
/* 101 */     return getParty().getPartyId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IParty getOperatorParty() {
/* 107 */     return getParty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EmployeePasswordId getPasswordId() {
/* 113 */     IEmployeePassword password = getCurrentPassword();
/* 114 */     EmployeePasswordId id = (EmployeePasswordId)password.getObjectId();
/* 115 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPreferredLocale() {
/* 121 */     return (getParty() == null) ? null : getParty().getPreferredLocale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isActiveForStore(long argRetailLocationId, Date argDate) {
/* 128 */     List<IEmployeeStore> allEmpStores = getEmployeeStores();
/* 129 */     boolean activeForStore = false;
/*     */     
/* 131 */     for (IEmployeeStore es : allEmpStores) {
/* 132 */       Date endDate = es.getEndDate();
/* 133 */       Date beginDate = es.getBeginDate();
/*     */       
/* 135 */       if (es.getRetailLocationId() != argRetailLocationId) {
/*     */         continue;
/*     */       }
/*     */       
/* 139 */       if (endDate != null && endDate.before(argDate)) {
/*     */         continue;
/*     */       }
/*     */       
/* 143 */       if (beginDate != null && beginDate.after(argDate)) {
/*     */         continue;
/*     */       }
/*     */       
/* 147 */       activeForStore = true;
/*     */     } 
/*     */ 
/*     */     
/* 151 */     return activeForStore;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClockedIn() {
/* 157 */     return getClockedIn();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInactive() {
/* 163 */     boolean inactive = EmployeeStatus.INACTIVE.getShortCode().equals(getEmployeeStatusCode());
/* 164 */     return inactive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedOut() {
/* 171 */     return getLockedOut();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTerminated(Date argDate) {
/* 177 */     boolean terminated = false;
/*     */ 
/*     */ 
/*     */     
/* 181 */     terminated = EmployeeStatus.TERMINATED.getShortCode().equals(getEmployeeStatusCode());
/*     */     
/* 183 */     if (terminated && getTerminatedDate() != null) {
/* 184 */       terminated = !getTerminatedDate().after(argDate);
/*     */     }
/*     */     
/* 187 */     return terminated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupMembership(byte[] argGroupMembership) {
/* 195 */     this.groupMembershipCache_ = argGroupMembership;
/* 196 */     String groupMembership = Base64.byteArrayToBase64(argGroupMembership);
/* 197 */     this.lastMembership_ = getDAO_().getGroupMembershipRaw();
/*     */     
/* 199 */     getDAO_().setGroupMembershipRaw(groupMembership);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPreferredLocale(String argLocale) {
/* 205 */     if (getParty() != null) {
/* 206 */       getParty().setPreferredLocale(argLocale);
/*     */     }
/*     */   }
/*     */   
/*     */   private EmployeeDAO getDAO_() {
/* 211 */     return (EmployeeDAO)this._daoImpl;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */