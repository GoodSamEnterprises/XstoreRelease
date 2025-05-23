/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.hrs.EmployeeId;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XenvPasswdResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 3528227731915840616L;
/*     */   private long organizationId_;
/*     */   private String employeeId_;
/*     */   private String loginId_;
/*     */   private String password_;
/*     */   private Date effectiveDate_;
/*     */   private boolean lockedOut;
/*     */   
/*     */   public Date getEffectiveDate() {
/*  36 */     return this.effectiveDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  45 */     return this.employeeId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLoginId() {
/*  54 */     return this.loginId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  63 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/*  72 */     return this.password_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedOut() {
/*  81 */     return this.lockedOut;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  90 */     this.effectiveDate_ = argEffectiveDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  99 */     this.employeeId_ = argEmployeeId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLockedOut(boolean argLockedOut) {
/* 108 */     this.lockedOut = argLockedOut;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginId(String argLoginId) {
/* 117 */     this.loginId_ = argLoginId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 126 */     this.organizationId_ = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(String argHashedPassword) {
/* 135 */     this.password_ = argHashedPassword;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 141 */     EmployeeId id = new EmployeeId();
/* 142 */     id.setOrganizationId(Long.valueOf(this.organizationId_));
/* 143 */     id.setEmployeeId(this.employeeId_);
/* 144 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\XenvPasswdResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */