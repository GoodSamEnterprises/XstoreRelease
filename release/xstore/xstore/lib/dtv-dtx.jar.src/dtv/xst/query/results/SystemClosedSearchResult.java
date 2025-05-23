/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
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
/*     */ public class SystemClosedSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private Date businessDate_;
/*     */   private Long transSeq_;
/*     */   private Long workstationId_;
/*     */   private Long retailLocationId_;
/*     */   private Long organizationId_;
/*     */   private Date startingTime_;
/*     */   
/*     */   public Date getBusinessDate() {
/*  35 */     return this.businessDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  44 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedObject() {
/*  52 */     PosTransactionId id = (PosTransactionId)getObjectId();
/*  53 */     return DataFactory.getObjectById((IObjectId)id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  62 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  71 */     return this.transSeq_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTransStartTime() {
/*  80 */     return this.startingTime_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/*  89 */     return this.workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date businessDate) {
/*  98 */     this.businessDate_ = businessDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(Long orgId) {
/* 107 */     this.organizationId_ = orgId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(Long retailLocId) {
/* 116 */     this.retailLocationId_ = retailLocId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(Long transSeq) {
/* 125 */     this.transSeq_ = transSeq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransStartTime(Date startTime) {
/* 134 */     this.startingTime_ = startTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(Long wkstnId) {
/* 143 */     this.workstationId_ = wkstnId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 149 */     PosTransactionId id = new PosTransactionId();
/* 150 */     id.setOrganizationId(this.organizationId_);
/* 151 */     id.setBusinessDate(this.businessDate_);
/* 152 */     id.setRetailLocationId(this.retailLocationId_);
/* 153 */     id.setTransactionSequence(this.transSeq_);
/* 154 */     id.setWorkstationId(this.workstationId_);
/* 155 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\SystemClosedSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */