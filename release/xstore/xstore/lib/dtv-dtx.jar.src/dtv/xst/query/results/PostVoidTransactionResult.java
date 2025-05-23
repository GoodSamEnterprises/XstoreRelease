/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
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
/*     */ public class PostVoidTransactionResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1816971010290386569L;
/*     */   private long organizationId_;
/*     */   private long rtlLocId_;
/*     */   private Date businessDate_;
/*     */   private long workstationId_;
/*     */   private long transactionSequence_;
/*     */   private long voided_organizationId_;
/*     */   private long voided_rtlLocId_;
/*     */   private Date voided_businessDate_;
/*     */   private long voided_workstationId_;
/*     */   private long voided_transactionSequence_;
/*     */   private String postVoidReasonCode_;
/*     */   private String voidedTransEntryCode_;
/*     */   
/*     */   public Date getBusinessDate() {
/*  41 */     return this.businessDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  50 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostVoidReasonCode() {
/*  59 */     return this.postVoidReasonCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRtlLocId() {
/*  68 */     return this.rtlLocId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/*  77 */     return this.transactionSequence_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getVoidedBusinessDate() {
/*  86 */     return this.voided_businessDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedOrganizationId() {
/*  95 */     return this.voided_organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedRtlLocId() {
/* 104 */     return this.voided_rtlLocId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedTransactionSequence() {
/* 113 */     return this.voided_transactionSequence_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVoidedTransEntryCode() {
/* 122 */     return this.voidedTransEntryCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getVoidedWorkstationId() {
/* 131 */     return this.voided_workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 140 */     return this.workstationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 149 */     this.businessDate_ = argBusinessDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 158 */     this.organizationId_ = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostVoidReasonCode(String argPostVoidReasonCode) {
/* 167 */     this.postVoidReasonCode_ = argPostVoidReasonCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRtlLocId(long argRtlLocId) {
/* 176 */     this.rtlLocId_ = argRtlLocId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 185 */     this.transactionSequence_ = argTransactionSequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedBusinessDate(Date argVoided_businessDate) {
/* 194 */     this.voided_businessDate_ = argVoided_businessDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedOrganizationId(long argVoided_organizationId) {
/* 203 */     this.voided_organizationId_ = argVoided_organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedRtlLocId(long argVoided_rtlLocId) {
/* 212 */     this.voided_rtlLocId_ = argVoided_rtlLocId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedTransactionSequence(long argVoided_transactionSequence) {
/* 221 */     this.voided_transactionSequence_ = argVoided_transactionSequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedTransEntryCode(String argVoidedTransEntryCode) {
/* 230 */     this.voidedTransEntryCode_ = argVoidedTransEntryCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoidedWorkstationId(long argVoided_workstationId) {
/* 239 */     this.voided_workstationId_ = argVoided_workstationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 248 */     this.workstationId_ = argWorkstationId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 254 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\PostVoidTransactionResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */