/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.hrs.EmployeeId;
/*     */ import dtv.xst.dao.hrs.IEmployee;
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
/*     */ public class CommAssocSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private long _organizationId;
/*     */   private String _employeeId;
/*     */   private String _lastName;
/*     */   private String _firstName;
/*     */   private Boolean _clockInFlag;
/*     */   
/*     */   public Boolean getClockInFlag() {
/*  33 */     return this._clockInFlag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeId() {
/*  42 */     return this._employeeId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstName() {
/*  51 */     return this._firstName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastName() {
/*  60 */     return this._lastName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  69 */     return this._organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IEmployee getPopulatedObject() {
/*  77 */     return (IEmployee)DataFactory.getObjectById(getObjectId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean isClockedIn() {
/*  86 */     if (getClockInFlag() == null) {
/*  87 */       return Boolean.FALSE;
/*     */     }
/*  89 */     return getClockInFlag();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClockInFlag(Boolean argClockInFlag) {
/*  98 */     this._clockInFlag = argClockInFlag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 107 */     this._employeeId = argEmployeeId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 116 */     this._firstName = argFirstName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 125 */     this._lastName = argLastName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 134 */     this._organizationId = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 140 */     EmployeeId id = new EmployeeId();
/* 141 */     id.setOrganizationId(Long.valueOf(this._organizationId));
/* 142 */     id.setEmployeeId(this._employeeId);
/* 143 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CommAssocSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */