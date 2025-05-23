/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerLoyaltyAccountId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerLoyaltyAccountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -966459739L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerLoyaltyAccountDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _loyaltyProgramId;
/*     */   private String _loyaltyProgramName;
/*     */   private String _loyaltyProgramLevelId;
/*     */   private String _loyaltyProgramLevelName;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private BigDecimal _accountBalance;
/*     */   private BigDecimal _escrowBalance;
/*     */   private BigDecimal _bonusBalance;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCardNumber() {
/*  53 */     return this._cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/*  57 */     if (changed(argCardNumber, this._cardNumber, "cardNumber")) {
/*  58 */       this._cardNumber = (argCardNumber != null && MANAGE_CASE) ? argCardNumber.toUpperCase() : argCardNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountId() {
/*  63 */     return this._accountId;
/*     */   }
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/*  67 */     if (changed(argAccountId, this._accountId, "accountId")) {
/*  68 */       this._accountId = (argAccountId != null && MANAGE_CASE) ? argAccountId.toUpperCase() : argAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  73 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  77 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  78 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  84 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  89 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  94 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  98 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  99 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 105 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 109 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 110 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLoyaltyProgramId() {
/* 115 */     return this._loyaltyProgramId;
/*     */   }
/*     */   
/*     */   public void setLoyaltyProgramId(String argLoyaltyProgramId) {
/* 119 */     if (changed(argLoyaltyProgramId, this._loyaltyProgramId, "loyaltyProgramId")) {
/* 120 */       this._loyaltyProgramId = argLoyaltyProgramId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLoyaltyProgramName() {
/* 125 */     return this._loyaltyProgramName;
/*     */   }
/*     */   
/*     */   public void setLoyaltyProgramName(String argLoyaltyProgramName) {
/* 129 */     if (changed(argLoyaltyProgramName, this._loyaltyProgramName, "loyaltyProgramName")) {
/* 130 */       this._loyaltyProgramName = argLoyaltyProgramName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLoyaltyProgramLevelId() {
/* 135 */     return this._loyaltyProgramLevelId;
/*     */   }
/*     */   
/*     */   public void setLoyaltyProgramLevelId(String argLoyaltyProgramLevelId) {
/* 139 */     if (changed(argLoyaltyProgramLevelId, this._loyaltyProgramLevelId, "loyaltyProgramLevelId")) {
/* 140 */       this._loyaltyProgramLevelId = argLoyaltyProgramLevelId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLoyaltyProgramLevelName() {
/* 145 */     return this._loyaltyProgramLevelName;
/*     */   }
/*     */   
/*     */   public void setLoyaltyProgramLevelName(String argLoyaltyProgramLevelName) {
/* 149 */     if (changed(argLoyaltyProgramLevelName, this._loyaltyProgramLevelName, "loyaltyProgramLevelName")) {
/* 150 */       this._loyaltyProgramLevelName = argLoyaltyProgramLevelName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 155 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 159 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 160 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 166 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 170 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 171 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 177 */     return this._accountBalance;
/*     */   }
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 181 */     if (changed(argAccountBalance, this._accountBalance, "accountBalance")) {
/* 182 */       this._accountBalance = argAccountBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getEscrowBalance() {
/* 187 */     return this._escrowBalance;
/*     */   }
/*     */   
/*     */   public void setEscrowBalance(BigDecimal argEscrowBalance) {
/* 191 */     if (changed(argEscrowBalance, this._escrowBalance, "escrowBalance")) {
/* 192 */       this._escrowBalance = argEscrowBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getBonusBalance() {
/* 197 */     return this._bonusBalance;
/*     */   }
/*     */   
/*     */   public void setBonusBalance(BigDecimal argBonusBalance) {
/* 201 */     if (changed(argBonusBalance, this._bonusBalance, "bonusBalance")) {
/* 202 */       this._bonusBalance = argBonusBalance;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 209 */     StringBuilder buf = new StringBuilder(512);
/* 210 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 211 */     if (getOrganizationId() != null) {
/* 212 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 214 */     if (getCardNumber() != null) {
/* 215 */       buf.append("cardNumber").append("=").append(getCardNumber()).append(" ");
/*     */     }
/* 217 */     if (getAccountId() != null) {
/* 218 */       buf.append("accountId").append("=").append(getAccountId()).append(" ");
/*     */     }
/* 220 */     if (getCreateDate() != null) {
/* 221 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 223 */     if (getCreateUserId() != null) {
/* 224 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 226 */     if (getUpdateDate() != null) {
/* 227 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 229 */     if (getUpdateUserId() != null) {
/* 230 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 232 */     if (getLoyaltyProgramId() != null) {
/* 233 */       buf.append("loyaltyProgramId").append("=").append(getLoyaltyProgramId()).append(" ");
/*     */     }
/* 235 */     if (getLoyaltyProgramName() != null) {
/* 236 */       buf.append("loyaltyProgramName").append("=").append(getLoyaltyProgramName()).append(" ");
/*     */     }
/* 238 */     if (getLoyaltyProgramLevelId() != null) {
/* 239 */       buf.append("loyaltyProgramLevelId").append("=").append(getLoyaltyProgramLevelId()).append(" ");
/*     */     }
/* 241 */     if (getLoyaltyProgramLevelName() != null) {
/* 242 */       buf.append("loyaltyProgramLevelName").append("=").append(getLoyaltyProgramLevelName()).append(" ");
/*     */     }
/* 244 */     if (getEffectiveDate() != null) {
/* 245 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 247 */     if (getExpirationDate() != null) {
/* 248 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 250 */     if (getAccountBalance() != null) {
/* 251 */       buf.append("accountBalance").append("=").append(getAccountBalance()).append(" ");
/*     */     }
/* 253 */     if (getEscrowBalance() != null) {
/* 254 */       buf.append("escrowBalance").append("=").append(getEscrowBalance()).append(" ");
/*     */     }
/* 256 */     if (getBonusBalance() != null) {
/* 257 */       buf.append("bonusBalance").append("=").append(getBonusBalance()).append(" ");
/*     */     }
/*     */     
/* 260 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     CustomerLoyaltyAccountId id = new CustomerLoyaltyAccountId();
/* 265 */     id.setOrganizationId(getOrganizationId());
/* 266 */     id.setCardNumber(getCardNumber());
/* 267 */     id.setAccountId(getAccountId());
/* 268 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 272 */     setOrganizationId(((CustomerLoyaltyAccountId)argObjectId).getOrganizationId());
/* 273 */     setCardNumber(((CustomerLoyaltyAccountId)argObjectId).getCardNumber());
/* 274 */     setAccountId(((CustomerLoyaltyAccountId)argObjectId).getAccountId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 278 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 282 */     StringBuilder buf = new StringBuilder(800);
/* 283 */     buf.append("<").append("dao").append(" name=\"CustomerLoyaltyAccount\" cmd=\"" + getObjectStateString() + "\">");
/* 284 */     getFieldsAsXml(buf);
/* 285 */     buf.append("</").append("dao").append(">");
/*     */     
/* 287 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 291 */     Map<String, String> values = super.getValues();
/* 292 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 293 */     if (this._cardNumber != null) values.put("CardNumber", DaoUtils.getXmlSafeFieldValue(12, this._cardNumber)); 
/* 294 */     if (this._accountId != null) values.put("AccountId", DaoUtils.getXmlSafeFieldValue(12, this._accountId)); 
/* 295 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 296 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 297 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 298 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 299 */     if (this._loyaltyProgramId != null) values.put("LoyaltyProgramId", DaoUtils.getXmlSafeFieldValue(12, this._loyaltyProgramId)); 
/* 300 */     if (this._loyaltyProgramName != null) values.put("LoyaltyProgramName", DaoUtils.getXmlSafeFieldValue(12, this._loyaltyProgramName)); 
/* 301 */     if (this._loyaltyProgramLevelId != null) values.put("LoyaltyProgramLevelId", DaoUtils.getXmlSafeFieldValue(12, this._loyaltyProgramLevelId)); 
/* 302 */     if (this._loyaltyProgramLevelName != null) values.put("LoyaltyProgramLevelName", DaoUtils.getXmlSafeFieldValue(12, this._loyaltyProgramLevelName)); 
/* 303 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 304 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 305 */     if (this._accountBalance != null) values.put("AccountBalance", DaoUtils.getXmlSafeFieldValue(3, this._accountBalance)); 
/* 306 */     if (this._escrowBalance != null) values.put("EscrowBalance", DaoUtils.getXmlSafeFieldValue(3, this._escrowBalance)); 
/* 307 */     if (this._bonusBalance != null) values.put("BonusBalance", DaoUtils.getXmlSafeFieldValue(3, this._bonusBalance)); 
/* 308 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 313 */     super.setValues(argValues);
/* 314 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 316 */       String fieldName = field.getKey();
/* 317 */       String fieldValue = field.getValue();
/* 318 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 323 */             setOrganizationId((Long)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CardNumber":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setCardNumber((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setCardNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountId":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setAccountId((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 350 */             setCreateDate((Date)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setCreateUserId((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setUpdateDate((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 377 */             setUpdateUserId((String)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LoyaltyProgramId":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 386 */             setLoyaltyProgramId((String)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setLoyaltyProgramId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LoyaltyProgramName":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 395 */             setLoyaltyProgramName((String)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setLoyaltyProgramName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LoyaltyProgramLevelId":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 404 */             setLoyaltyProgramLevelId((String)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setLoyaltyProgramLevelId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LoyaltyProgramLevelName":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 413 */             setLoyaltyProgramLevelName((String)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setLoyaltyProgramLevelName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 422 */             setEffectiveDate((Date)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 431 */             setExpirationDate((Date)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountBalance":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 440 */             setAccountBalance((BigDecimal)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setAccountBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EscrowBalance":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 449 */             setEscrowBalance((BigDecimal)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setEscrowBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BonusBalance":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 458 */             setBonusBalance((BigDecimal)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setBonusBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */