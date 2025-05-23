/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.cwo.InvoiceId;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InvoiceSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private long organizationId_;
/*     */   private String description_;
/*     */   private String invoiceNumber_;
/*     */   private Date invoiceDate_;
/*     */   private BigDecimal totalAmountDue_;
/*     */   private Integer invoiceLineItemSeq_;
/*     */   private String glAccount_;
/*     */   private BigDecimal lineItemAmount_;
/*     */   private String custAccountId_;
/*     */   private String serviceLocationId_;
/*     */   
/*     */   public String getCustAccountId() {
/*  47 */     return this.custAccountId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  56 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGlAccount() {
/*  65 */     return this.glAccount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getInvoiceDate() {
/*  74 */     return this.invoiceDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getInvoiceLineItemSeq() {
/*  83 */     return this.invoiceLineItemSeq_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInvoiceNumber() {
/*  92 */     return this.invoiceNumber_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getLineItemAmount() {
/* 101 */     return this.lineItemAmount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 110 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedObject() {
/* 119 */     InvoiceId id = new InvoiceId();
/* 120 */     id.setInvoiceNumber(getInvoiceNumber());
/* 121 */     id.setServiceLocationId(getServiceLocationId());
/*     */     
/* 123 */     Object obj = DataFactory.getObjectById((IObjectId)id);
/* 124 */     return (obj != null) ? (IDataModel)obj : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceLocationId() {
/* 133 */     return this.serviceLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getTotalAmountDue() {
/* 142 */     return this.totalAmountDue_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 151 */     this.custAccountId_ = argCustAccountId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 160 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGlAccount(String argGlAccount) {
/* 169 */     this.glAccount_ = argGlAccount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceDate(Date argInvoiceDate) {
/* 178 */     this.invoiceDate_ = argInvoiceDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceLineItemSeq(Integer argInvoiceLineItemSeq) {
/* 187 */     this.invoiceLineItemSeq_ = argInvoiceLineItemSeq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/* 196 */     this.invoiceNumber_ = argInvoiceNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemAmount(BigDecimal argLineItemAmount) {
/* 205 */     this.lineItemAmount_ = argLineItemAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 214 */     this.organizationId_ = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 223 */     this.serviceLocationId_ = argServiceLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTotalAmountDue(BigDecimal argTotalAmountDue) {
/* 232 */     this.totalAmountDue_ = argTotalAmountDue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 238 */     InvoiceId id = new InvoiceId();
/* 239 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 240 */     id.setServiceLocationId(getServiceLocationId());
/* 241 */     id.setInvoiceNumber(getInvoiceNumber());
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\InvoiceSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */