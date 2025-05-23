/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemPricesId;
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
/*     */ public class ItemPricesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -389226147L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemPricesDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _itemPricePropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private BigDecimal _pricingQuantity;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _expirationDate;
/*     */   private BigDecimal _price;
/*     */   private String _externalId;
/*     */   private String _externalSystem;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  52 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  56 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  57 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  62 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  66 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  67 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  72 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  76 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  77 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemPricePropertyCode() {
/*  82 */     return this._itemPricePropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemPricePropertyCode(String argItemPricePropertyCode) {
/*  86 */     if (changed(argItemPricePropertyCode, this._itemPricePropertyCode, "itemPricePropertyCode")) {
/*  87 */       this._itemPricePropertyCode = (argItemPricePropertyCode != null && MANAGE_CASE) ? argItemPricePropertyCode.toUpperCase() : argItemPricePropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  92 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  96 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  97 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPricingQuantity() {
/* 103 */     return this._pricingQuantity;
/*     */   }
/*     */   
/*     */   public void setPricingQuantity(BigDecimal argPricingQuantity) {
/* 107 */     if (changed(argPricingQuantity, this._pricingQuantity, "pricingQuantity")) {
/* 108 */       this._pricingQuantity = argPricingQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 113 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 117 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 118 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 124 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 128 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 129 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 134 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 138 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 139 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 145 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 149 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 150 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 155 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 159 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 160 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPrice() {
/* 166 */     return this._price;
/*     */   }
/*     */   
/*     */   public void setPrice(BigDecimal argPrice) {
/* 170 */     if (changed(argPrice, this._price, "price")) {
/* 171 */       this._price = argPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalId() {
/* 176 */     return this._externalId;
/*     */   }
/*     */   
/*     */   public void setExternalId(String argExternalId) {
/* 180 */     if (changed(argExternalId, this._externalId, "externalId")) {
/* 181 */       this._externalId = argExternalId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getExternalSystem() {
/* 186 */     return this._externalSystem;
/*     */   }
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 190 */     if (changed(argExternalSystem, this._externalSystem, "externalSystem")) {
/* 191 */       this._externalSystem = argExternalSystem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buf = new StringBuilder(512);
/* 199 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 200 */     if (getOrganizationId() != null) {
/* 201 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 203 */     if (getItemId() != null) {
/* 204 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 206 */     if (getLevelCode() != null) {
/* 207 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 209 */     if (getLevelValue() != null) {
/* 210 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 212 */     if (getItemPricePropertyCode() != null) {
/* 213 */       buf.append("itemPricePropertyCode").append("=").append(getItemPricePropertyCode()).append(" ");
/*     */     }
/* 215 */     if (getEffectiveDate() != null) {
/* 216 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 218 */     if (getPricingQuantity() != null) {
/* 219 */       buf.append("pricingQuantity").append("=").append(getPricingQuantity()).append(" ");
/*     */     }
/* 221 */     if (getCreateDate() != null) {
/* 222 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 224 */     if (getCreateUserId() != null) {
/* 225 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 227 */     if (getUpdateDate() != null) {
/* 228 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 230 */     if (getUpdateUserId() != null) {
/* 231 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 233 */     if (getExpirationDate() != null) {
/* 234 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 236 */     if (getPrice() != null) {
/* 237 */       buf.append("price").append("=").append(getPrice()).append(" ");
/*     */     }
/* 239 */     if (getExternalId() != null) {
/* 240 */       buf.append("externalId").append("=").append(getExternalId()).append(" ");
/*     */     }
/* 242 */     if (getExternalSystem() != null) {
/* 243 */       buf.append("externalSystem").append("=").append(getExternalSystem()).append(" ");
/*     */     }
/*     */     
/* 246 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     ItemPricesId id = new ItemPricesId();
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setItemId(getItemId());
/* 253 */     id.setLevelCode(getLevelCode());
/* 254 */     id.setLevelValue(getLevelValue());
/* 255 */     id.setItemPricePropertyCode(getItemPricePropertyCode());
/* 256 */     id.setEffectiveDate(getEffectiveDate());
/* 257 */     id.setPricingQuantity(getPricingQuantity());
/* 258 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 262 */     setOrganizationId(((ItemPricesId)argObjectId).getOrganizationId());
/* 263 */     setItemId(((ItemPricesId)argObjectId).getItemId());
/* 264 */     setLevelCode(((ItemPricesId)argObjectId).getLevelCode());
/* 265 */     setLevelValue(((ItemPricesId)argObjectId).getLevelValue());
/* 266 */     setItemPricePropertyCode(((ItemPricesId)argObjectId).getItemPricePropertyCode());
/* 267 */     setEffectiveDate(((ItemPricesId)argObjectId).getEffectiveDate());
/* 268 */     setPricingQuantity(((ItemPricesId)argObjectId).getPricingQuantity());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 272 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 276 */     StringBuilder buf = new StringBuilder(750);
/* 277 */     buf.append("<").append("dao").append(" name=\"ItemPrices\" cmd=\"" + getObjectStateString() + "\">");
/* 278 */     getFieldsAsXml(buf);
/* 279 */     buf.append("</").append("dao").append(">");
/*     */     
/* 281 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 285 */     Map<String, String> values = super.getValues();
/* 286 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 287 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 288 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 289 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 290 */     if (this._itemPricePropertyCode != null) values.put("ItemPricePropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._itemPricePropertyCode)); 
/* 291 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 292 */     if (this._pricingQuantity != null) values.put("PricingQuantity", DaoUtils.getXmlSafeFieldValue(3, this._pricingQuantity)); 
/* 293 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 294 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 295 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 296 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 297 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 298 */     if (this._price != null) values.put("Price", DaoUtils.getXmlSafeFieldValue(3, this._price)); 
/* 299 */     if (this._externalId != null) values.put("ExternalId", DaoUtils.getXmlSafeFieldValue(12, this._externalId)); 
/* 300 */     if (this._externalSystem != null) values.put("ExternalSystem", DaoUtils.getXmlSafeFieldValue(12, this._externalSystem)); 
/* 301 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 306 */     super.setValues(argValues);
/* 307 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 309 */       String fieldName = field.getKey();
/* 310 */       String fieldValue = field.getValue();
/* 311 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 316 */             setOrganizationId((Long)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setItemId((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setLevelCode((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setLevelValue((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemPricePropertyCode":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 352 */             setItemPricePropertyCode((String)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setItemPricePropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 361 */             setEffectiveDate((Date)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PricingQuantity":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 370 */             setPricingQuantity((BigDecimal)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setPricingQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 379 */             setCreateDate((Date)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setCreateUserId((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 397 */             setUpdateDate((Date)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setUpdateUserId((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 415 */             setExpirationDate((Date)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Price":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 424 */             setPrice((BigDecimal)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalId":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setExternalId((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setExternalId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExternalSystem":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setExternalSystem((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setExternalSystem() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPricesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */