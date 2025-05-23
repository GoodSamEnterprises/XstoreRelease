/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
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
/*     */ public class SuspendedTransSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private Date businessDate_;
/*     */   private Long transSeq_;
/*     */   private Long workstationId_;
/*     */   private Long retailLocationId_;
/*     */   private Long organizationId_;
/*     */   private Date startingTime_;
/*     */   private String cashierId_;
/*     */   private String customerFirstName_;
/*     */   private String customerLastName_;
/*     */   private String customerOtherName_;
/*     */   
/*     */   public Date getBusinessDate() {
/*  40 */     return this.businessDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCashierId() {
/*  49 */     return this.cashierId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerDisplayName() {
/*  60 */     String name = (StringUtils.nonNull(this.customerFirstName_) + " " + StringUtils.nonNull(this.customerLastName_)).trim();
/*  61 */     return !StringUtils.isEmpty(name) ? name : this.customerOtherName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerFirstName() {
/*  70 */     return this.customerFirstName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerLastName() {
/*  79 */     return this.customerLastName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerOtherName() {
/*  88 */     return this.customerOtherName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  97 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedObject() {
/* 106 */     PosTransactionId id = (PosTransactionId)getObjectId();
/*     */     
/* 108 */     return DataFactory.getObjectById((IObjectId)id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/* 117 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/* 126 */     return this.transSeq_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransStartTime() {
/* 135 */     return this.startingTime_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/* 144 */     return this.workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date businessDate) {
/* 153 */     this.businessDate_ = businessDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCashierId(String cashierId) {
/* 162 */     this.cashierId_ = cashierId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerFirstName(String firstName) {
/* 171 */     this.customerFirstName_ = firstName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerLastName(String lastName) {
/* 180 */     this.customerLastName_ = lastName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerOtherName(String argName) {
/* 189 */     this.customerOtherName_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(Long orgId) {
/* 198 */     this.organizationId_ = orgId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(Long retailLocId) {
/* 207 */     this.retailLocationId_ = retailLocId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(Long transSeq) {
/* 216 */     this.transSeq_ = transSeq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransStartTime(Date startTime) {
/* 225 */     this.startingTime_ = startTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(Long wkstnId) {
/* 234 */     this.workstationId_ = wkstnId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 240 */     PosTransactionId id = new PosTransactionId();
/* 241 */     id.setOrganizationId(this.organizationId_);
/* 242 */     id.setBusinessDate(this.businessDate_);
/* 243 */     id.setRetailLocationId(this.retailLocationId_);
/* 244 */     id.setTransactionSequence(this.transSeq_);
/* 245 */     id.setWorkstationId(this.workstationId_);
/* 246 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\SuspendedTransSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */