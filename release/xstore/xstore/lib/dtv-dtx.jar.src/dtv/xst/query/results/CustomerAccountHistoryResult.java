/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.cat.CustomerAccountId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class CustomerAccountHistoryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private String _custAccountCode;
/*     */   private String _custAccountId;
/*     */   private Date _activityDate;
/*     */   private String _activityCode;
/*     */   private String _lineTypeCode;
/*     */   private BigDecimal _activityAmount;
/*     */   private BigDecimal _activityQuantity;
/*     */   
/*     */   public BigDecimal getActivityAmount() {
/*  38 */     return this._activityAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActivityCode() {
/*  47 */     return this._activityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getActivityDate() {
/*  56 */     return this._activityDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getActivityQuantity() {
/*  65 */     return this._activityQuantity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/*  74 */     return this._custAccountCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  83 */     return this._custAccountId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineTypeCode() {
/*  92 */     return this._lineTypeCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityAmount(BigDecimal argActivityAmount) {
/* 101 */     this._activityAmount = argActivityAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 110 */     this._activityCode = argActivityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityDate(Date argActivityDate) {
/* 119 */     this._activityDate = argActivityDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityQuantity(BigDecimal argActivityQuantity) {
/* 128 */     this._activityQuantity = argActivityQuantity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 137 */     this._custAccountCode = argCustAccountCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 146 */     this._custAccountId = argCustAccountId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineTypeCode(String argLineTypeCode) {
/* 155 */     this._lineTypeCode = argLineTypeCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 161 */     CustomerAccountId id = new CustomerAccountId();
/* 162 */     id.setCustAccountId(this._custAccountId);
/* 163 */     id.setCustAccountCode(this._custAccountCode);
/* 164 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CustomerAccountHistoryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */