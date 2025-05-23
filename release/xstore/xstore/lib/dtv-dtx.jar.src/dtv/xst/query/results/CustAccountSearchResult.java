/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectNotFoundException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustAccountSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   protected long _organizationId;
/*     */   protected String _firstName;
/*     */   protected String _lastName;
/*     */   protected String _accountId;
/*     */   protected Date _accountSetupDate;
/*     */   protected String _accountStateCode;
/*     */   protected BigDecimal _accountBalanceDue;
/*     */   protected String _accountCode;
/*     */   protected BigDecimal _activeAccountTotal;
/*     */   protected BigDecimal _accountTotalDeposits;
/*     */   protected Date _psBeginDate;
/*     */   protected String _psIntervalType;
/*     */   protected Integer _psIntervalCount;
/*     */   protected Integer _psPaymentCount;
/*     */   protected String _originatingRetailLocationId;
/*     */   protected String _originatingStoreName;
/*     */   protected String _fulfillingRetailLocationId;
/*     */   protected String _fulfillingStoreName;
/*  78 */   protected transient IDataModel _populatedObject = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountBalanceDue() {
/*  86 */     return this._accountBalanceDue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountCode() {
/*  95 */     return this._accountCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountId() {
/* 104 */     return this._accountId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getAccountSetupDate() {
/* 113 */     return this._accountSetupDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountStateCode() {
/* 122 */     return this._accountStateCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountTotalDeposits() {
/* 131 */     return this._accountTotalDeposits;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getActiveAccountTotal() {
/* 140 */     return this._activeAccountTotal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstName() {
/* 149 */     return this._firstName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFulfillingRetailLocationId() {
/* 158 */     return this._fulfillingRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFulfillingStoreName() {
/* 167 */     return this._fulfillingStoreName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFullName() {
/* 176 */     String fn = (this._firstName == null) ? "" : this._firstName;
/* 177 */     String ln = (this._lastName == null) ? "" : this._lastName;
/* 178 */     return fn + " " + ln;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastName() {
/* 187 */     return this._lastName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 196 */     return this._organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginatingRetailLocationId() {
/* 205 */     return this._originatingRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginatingStoreName() {
/* 214 */     return this._originatingStoreName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedObject() {
/* 223 */     if (this._populatedObject != null) {
/* 224 */       return this._populatedObject;
/*     */     }
/*     */     
/*     */     try {
/* 228 */       Object obj = DataFactory.getObjectById(getObjectId());
/* 229 */       if (obj != null && obj instanceof IDataModel) {
/* 230 */         this._populatedObject = (IDataModel)obj;
/*     */       }
/*     */       
/* 233 */       return (obj != null) ? (IDataModel)obj : null;
/*     */     }
/* 235 */     catch (ObjectNotFoundException ex) {
/* 236 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getPsBeginDate() {
/* 246 */     return this._psBeginDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getPsIntervalCount() {
/* 255 */     return this._psIntervalCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPsIntervalType() {
/* 264 */     return this._psIntervalType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getPsPaymentCount() {
/* 273 */     return this._psPaymentCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountBalanceDue(BigDecimal accountBalanceDue) {
/* 282 */     this._accountBalanceDue = accountBalanceDue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountCode(String argAaccountCode) {
/* 291 */     this._accountCode = argAaccountCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountId(String accountId) {
/* 300 */     this._accountId = accountId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountSetupDate(Date accountSetupDate) {
/* 309 */     this._accountSetupDate = accountSetupDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountStateCode(String argAccountStateCode) {
/* 318 */     this._accountStateCode = argAccountStateCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountTotalDeposits(BigDecimal argAccountTotalDeposits) {
/* 327 */     this._accountTotalDeposits = argAccountTotalDeposits;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveAccountTotal(BigDecimal argActiveAccountTotal) {
/* 336 */     this._activeAccountTotal = argActiveAccountTotal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstName(String argFirstName) {
/* 345 */     this._firstName = argFirstName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFulfillingRetailLocationId(String argFulfillingRetailLocationId) {
/* 354 */     this._fulfillingRetailLocationId = argFulfillingRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFulfillingStoreName(String argFulfillingStoreName) {
/* 363 */     this._fulfillingStoreName = argFulfillingStoreName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastName(String argLastName) {
/* 372 */     this._lastName = argLastName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 381 */     this._organizationId = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginatingRetailLocationId(String argOriginatingRetailLocationId) {
/* 390 */     this._originatingRetailLocationId = argOriginatingRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginatingStoreName(String argOriginatingStoreName) {
/* 399 */     this._originatingStoreName = argOriginatingStoreName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPsBeginDate(Date psBeginDate) {
/* 408 */     this._psBeginDate = psBeginDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPsIntervalCount(Integer psIntervalCount) {
/* 417 */     this._psIntervalCount = psIntervalCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPsIntervalType(String argPsIntervalType) {
/* 426 */     this._psIntervalType = argPsIntervalType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPsPaymentCount(Integer argPsPaymentCount) {
/* 435 */     this._psPaymentCount = argPsPaymentCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 441 */     CustomerAccountId id = new CustomerAccountId();
/* 442 */     id.setOrganizationId(Long.valueOf(this._organizationId));
/* 443 */     id.setCustAccountCode(this._accountCode);
/* 444 */     id.setCustAccountId(this._accountId);
/* 445 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\CustAccountSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */