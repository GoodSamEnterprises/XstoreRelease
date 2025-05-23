/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemPricesPropertyId;
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
/*     */ public class ItemPricesPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 669021778L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemPricesPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _itemPricePropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private BigDecimal _pricingQuantity;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
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
/*     */   public String getItemId() {
/*  53 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  57 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  58 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  63 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  67 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  68 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  73 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  77 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  78 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemPricePropertyCode() {
/*  83 */     return this._itemPricePropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemPricePropertyCode(String argItemPricePropertyCode) {
/*  87 */     if (changed(argItemPricePropertyCode, this._itemPricePropertyCode, "itemPricePropertyCode")) {
/*  88 */       this._itemPricePropertyCode = (argItemPricePropertyCode != null && MANAGE_CASE) ? argItemPricePropertyCode.toUpperCase() : argItemPricePropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  93 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  97 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  98 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getPricingQuantity() {
/* 104 */     return this._pricingQuantity;
/*     */   }
/*     */   
/*     */   public void setPricingQuantity(BigDecimal argPricingQuantity) {
/* 108 */     if (changed(argPricingQuantity, this._pricingQuantity, "pricingQuantity")) {
/* 109 */       this._pricingQuantity = argPricingQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 114 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 118 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 119 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 124 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 128 */     if (changed(argType, this._type, "type")) {
/* 129 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 134 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 138 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 139 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 144 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 148 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 149 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 155 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 159 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 160 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 165 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 169 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 170 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 176 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 180 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 181 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 186 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 190 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 191 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 197 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 201 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 202 */       this._updateUserId = argUpdateUserId;
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
/* 214 */     if (getItemId() != null) {
/* 215 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 217 */     if (getLevelCode() != null) {
/* 218 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 220 */     if (getLevelValue() != null) {
/* 221 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 223 */     if (getItemPricePropertyCode() != null) {
/* 224 */       buf.append("itemPricePropertyCode").append("=").append(getItemPricePropertyCode()).append(" ");
/*     */     }
/* 226 */     if (getEffectiveDate() != null) {
/* 227 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 229 */     if (getPricingQuantity() != null) {
/* 230 */       buf.append("pricingQuantity").append("=").append(getPricingQuantity()).append(" ");
/*     */     }
/* 232 */     if (getPropertyCode() != null) {
/* 233 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 235 */     if (getType() != null) {
/* 236 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 238 */     if (getStringValue() != null) {
/* 239 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 241 */     if (getDateValue() != null) {
/* 242 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 244 */     if (getDecimalValue() != null) {
/* 245 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 247 */     if (getCreateDate() != null) {
/* 248 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 250 */     if (getCreateUserId() != null) {
/* 251 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 253 */     if (getUpdateDate() != null) {
/* 254 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 256 */     if (getUpdateUserId() != null) {
/* 257 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 260 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 264 */     ItemPricesPropertyId id = new ItemPricesPropertyId();
/* 265 */     id.setOrganizationId(getOrganizationId());
/* 266 */     id.setItemId(getItemId());
/* 267 */     id.setLevelCode(getLevelCode());
/* 268 */     id.setLevelValue(getLevelValue());
/* 269 */     id.setItemPricePropertyCode(getItemPricePropertyCode());
/* 270 */     id.setEffectiveDate(getEffectiveDate());
/* 271 */     id.setPricingQuantity(getPricingQuantity());
/* 272 */     id.setPropertyCode(getPropertyCode());
/* 273 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 277 */     setOrganizationId(((ItemPricesPropertyId)argObjectId).getOrganizationId());
/* 278 */     setItemId(((ItemPricesPropertyId)argObjectId).getItemId());
/* 279 */     setLevelCode(((ItemPricesPropertyId)argObjectId).getLevelCode());
/* 280 */     setLevelValue(((ItemPricesPropertyId)argObjectId).getLevelValue());
/* 281 */     setItemPricePropertyCode(((ItemPricesPropertyId)argObjectId).getItemPricePropertyCode());
/* 282 */     setEffectiveDate(((ItemPricesPropertyId)argObjectId).getEffectiveDate());
/* 283 */     setPricingQuantity(((ItemPricesPropertyId)argObjectId).getPricingQuantity());
/* 284 */     setPropertyCode(((ItemPricesPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 292 */     StringBuilder buf = new StringBuilder(800);
/* 293 */     buf.append("<").append("dao").append(" name=\"ItemPricesProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 294 */     getFieldsAsXml(buf);
/* 295 */     buf.append("</").append("dao").append(">");
/*     */     
/* 297 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 301 */     Map<String, String> values = super.getValues();
/* 302 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 303 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 304 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 305 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 306 */     if (this._itemPricePropertyCode != null) values.put("ItemPricePropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._itemPricePropertyCode)); 
/* 307 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 308 */     if (this._pricingQuantity != null) values.put("PricingQuantity", DaoUtils.getXmlSafeFieldValue(3, this._pricingQuantity)); 
/* 309 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 310 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 311 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 312 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 313 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 314 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 315 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 316 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 317 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 318 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 323 */     super.setValues(argValues);
/* 324 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 326 */       String fieldName = field.getKey();
/* 327 */       String fieldValue = field.getValue();
/* 328 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 333 */             setOrganizationId((Long)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setItemId((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setLevelCode((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setLevelValue((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemPricePropertyCode":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setItemPricePropertyCode((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setItemPricePropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 378 */             setEffectiveDate((Date)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PricingQuantity":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 387 */             setPricingQuantity((BigDecimal)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setPricingQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 396 */             setPropertyCode((String)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setType((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 414 */             setStringValue((String)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 423 */             setDateValue((Date)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 432 */             setDecimalValue((BigDecimal)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 441 */             setCreateDate((Date)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 450 */             setCreateUserId((String)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 459 */             setUpdateDate((Date)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 468 */             setUpdateUserId((String)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPricesPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */