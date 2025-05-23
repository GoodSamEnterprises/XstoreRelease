/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HouseAccountSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private long organizationId_;
/*     */   private String custAcctId_;
/*     */   private String custAcctCode_;
/*     */   private BigDecimal creditLimit_;
/*     */   private BigDecimal acctBalance_;
/*     */   private long customerPartyId_;
/*     */   private long accountPartyId_;
/*     */   private String organizationName_;
/*     */   private String custFirstName_;
/*     */   private String custLastName_;
/*     */   private String custId_;
/*     */   private String custAcctStatus_;
/*     */   private String telephone1_;
/*     */   private String telephone2_;
/*     */   private String telephone3_;
/*     */   private String telephone4_;
/*     */   private Date accountSetupDate_;
/*     */   
/*     */   public long getAccountPartyId() {
/*  54 */     return this.accountPartyId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getAccountSetupDate() {
/*  63 */     return this.accountSetupDate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAcctBalance() {
/*  72 */     return this.acctBalance_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCreditLimit() {
/*  81 */     return this.creditLimit_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAcctCode() {
/*  90 */     return this.custAcctCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAcctId() {
/*  99 */     return this.custAcctId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAcctStatus() {
/* 108 */     return this.custAcctStatus_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustFirstName() {
/* 117 */     return this.custFirstName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustId() {
/* 126 */     return this.custId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustLastName() {
/* 135 */     return this.custLastName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCustomerPartyId() {
/* 144 */     return this.customerPartyId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 153 */     return this.organizationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrganizationName() {
/* 162 */     return this.organizationName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedObject() {
/* 170 */     CustomerAccountId id = (CustomerAccountId)getObjectId();
/* 171 */     Object obj = DataFactory.getObjectById((IObjectId)id);
/* 172 */     return (obj != null) ? (IDataModel)obj : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone1() {
/* 181 */     return this.telephone1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone2() {
/* 190 */     return this.telephone2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone3() {
/* 199 */     return this.telephone3_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTelephone4() {
/* 208 */     return this.telephone4_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountPartyId(Long argPartyId) {
/* 217 */     this.accountPartyId_ = argPartyId.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountSetupDate(Date accountSetupDate) {
/* 226 */     this.accountSetupDate_ = accountSetupDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAcctBalance(BigDecimal argAmt) {
/* 235 */     this.acctBalance_ = argAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreditLimit(BigDecimal argAmt) {
/* 244 */     this.creditLimit_ = argAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAcctCode(String argId) {
/* 253 */     this.custAcctCode_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAcctId(String argId) {
/* 262 */     this.custAcctId_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAcctStatus(String argId) {
/* 271 */     this.custAcctStatus_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustFirstName(String argFirstName) {
/* 280 */     this.custFirstName_ = argFirstName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustId(String argId) {
/* 289 */     this.custId_ = argId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustLastName(String argLastName) {
/* 298 */     this.custLastName_ = argLastName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerPartyId(Long argPartyId) {
/* 307 */     this.customerPartyId_ = argPartyId.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 316 */     this.organizationId_ = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationName(String argName) {
/* 325 */     this.organizationName_ = argName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone1(String argValue) {
/* 334 */     this.telephone1_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone2(String argValue) {
/* 343 */     this.telephone2_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone3(String argValue) {
/* 352 */     this.telephone3_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTelephone4(String argValue) {
/* 361 */     this.telephone4_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 367 */     CustomerAccountId id = new CustomerAccountId();
/* 368 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 369 */     id.setCustAccountCode(getCustAcctCode());
/* 370 */     id.setCustAccountId(getCustAcctId());
/* 371 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\HouseAccountSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */