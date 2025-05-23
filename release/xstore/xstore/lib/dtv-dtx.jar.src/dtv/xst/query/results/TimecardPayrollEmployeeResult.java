/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.hrs.EmployeeId;
/*     */ import dtv.xst.dao.hrs.IEmployee;
/*     */ import java.math.BigDecimal;
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
/*     */ public class TimecardPayrollEmployeeResult
/*     */   extends EmployeeSearchResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private String department_;
/*     */   private Long partyId_;
/*     */   private String payStatus_;
/*     */   private String phoneNumber_;
/*     */   private String workStatus_;
/*     */   private BigDecimal basePay_;
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  34 */     boolean result = false;
/*     */     
/*  36 */     if (argObj instanceof TimecardPayrollEmployeeResult) {
/*  37 */       TimecardPayrollEmployeeResult obj = (TimecardPayrollEmployeeResult)argObj;
/*     */       
/*  39 */       if (obj.getEmployeeId().equalsIgnoreCase(getEmployeeId())) {
/*  40 */         result = true;
/*     */       }
/*     */     } 
/*  43 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBasePay() {
/*  52 */     return this.basePay_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEmployeeDepartmentId() {
/*  61 */     return this.department_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/*  70 */     return this.partyId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayStatus() {
/*  79 */     return this.payStatus_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPhoneNumber() {
/*  88 */     return this.phoneNumber_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IEmployee getPopulatedObjectParty() {
/*  96 */     EmployeeId id = (EmployeeId)getObjectId();
/*     */ 
/*     */     
/*  99 */     return (IEmployee)DataFactory.getObjectById((IObjectId)id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkStatus() {
/* 108 */     return this.workStatus_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     return getEmployeeId().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBasePay(BigDecimal argPay) {
/* 123 */     this.basePay_ = argPay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeDepartmentId(String department) {
/* 132 */     this.department_ = department;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(Long id) {
/* 141 */     this.partyId_ = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayStatus(String argStatus) {
/* 150 */     this.payStatus_ = argStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPhoneNumber(String argNbr) {
/* 159 */     this.phoneNumber_ = argNbr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkStatus(String argStatus) {
/* 168 */     this.workStatus_ = argStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     return getLastName();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\TimecardPayrollEmployeeResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */