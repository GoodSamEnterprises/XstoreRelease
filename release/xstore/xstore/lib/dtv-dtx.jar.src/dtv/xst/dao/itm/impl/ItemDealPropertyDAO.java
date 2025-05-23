/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemDealPropertyId;
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
/*     */ public class ItemDealPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1662263604L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemDealPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _itemDealPropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _expirationDate;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
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
/*     */   public String getItemDealPropertyCode() {
/*  62 */     return this._itemDealPropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemDealPropertyCode(String argItemDealPropertyCode) {
/*  66 */     if (changed(argItemDealPropertyCode, this._itemDealPropertyCode, "itemDealPropertyCode")) {
/*  67 */       this._itemDealPropertyCode = (argItemDealPropertyCode != null && MANAGE_CASE) ? argItemDealPropertyCode.toUpperCase() : argItemDealPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  72 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  76 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  77 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  83 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  87 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  88 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  94 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  98 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  99 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 104 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 108 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 109 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 115 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 119 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 120 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 125 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 129 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 130 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 135 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 139 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 140 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 145 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 149 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 150 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/* 156 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 160 */     if (changed(argType, this._type, "type")) {
/* 161 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 166 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 170 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 171 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 176 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 180 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 181 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 187 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 191 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 192 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 199 */     StringBuilder buf = new StringBuilder(512);
/* 200 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 201 */     if (getOrganizationId() != null) {
/* 202 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 204 */     if (getItemId() != null) {
/* 205 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 207 */     if (getItemDealPropertyCode() != null) {
/* 208 */       buf.append("itemDealPropertyCode").append("=").append(getItemDealPropertyCode()).append(" ");
/*     */     }
/* 210 */     if (getEffectiveDate() != null) {
/* 211 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 213 */     if (getCreateDate() != null) {
/* 214 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 216 */     if (getCreateUserId() != null) {
/* 217 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 219 */     if (getUpdateDate() != null) {
/* 220 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 222 */     if (getUpdateUserId() != null) {
/* 223 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 225 */     if (getOrgCode() != null) {
/* 226 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 228 */     if (getOrgValue() != null) {
/* 229 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 231 */     if (getExpirationDate() != null) {
/* 232 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 234 */     if (getType() != null) {
/* 235 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 237 */     if (getStringValue() != null) {
/* 238 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 240 */     if (getDateValue() != null) {
/* 241 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 243 */     if (getDecimalValue() != null) {
/* 244 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/*     */     
/* 247 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 251 */     ItemDealPropertyId id = new ItemDealPropertyId();
/* 252 */     id.setOrganizationId(getOrganizationId());
/* 253 */     id.setItemId(getItemId());
/* 254 */     id.setItemDealPropertyCode(getItemDealPropertyCode());
/* 255 */     id.setEffectiveDate(getEffectiveDate());
/* 256 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 260 */     setOrganizationId(((ItemDealPropertyId)argObjectId).getOrganizationId());
/* 261 */     setItemId(((ItemDealPropertyId)argObjectId).getItemId());
/* 262 */     setItemDealPropertyCode(((ItemDealPropertyId)argObjectId).getItemDealPropertyCode());
/* 263 */     setEffectiveDate(((ItemDealPropertyId)argObjectId).getEffectiveDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 267 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 271 */     StringBuilder buf = new StringBuilder(750);
/* 272 */     buf.append("<").append("dao").append(" name=\"ItemDealProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 273 */     getFieldsAsXml(buf);
/* 274 */     buf.append("</").append("dao").append(">");
/*     */     
/* 276 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 280 */     Map<String, String> values = super.getValues();
/* 281 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 282 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 283 */     if (this._itemDealPropertyCode != null) values.put("ItemDealPropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._itemDealPropertyCode)); 
/* 284 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 285 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 286 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 287 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 288 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 289 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 290 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 291 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 292 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 293 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 294 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 295 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 296 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 301 */     super.setValues(argValues);
/* 302 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 304 */       String fieldName = field.getKey();
/* 305 */       String fieldValue = field.getValue();
/* 306 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 311 */             setOrganizationId((Long)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 320 */             setItemId((String)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemDealPropertyCode":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setItemDealPropertyCode((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setItemDealPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 338 */             setEffectiveDate((Date)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 347 */             setCreateDate((Date)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 356 */             setCreateUserId((String)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 365 */             setUpdateDate((Date)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 374 */             setUpdateUserId((String)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 383 */             setOrgCode((String)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setOrgValue((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 401 */             setExpirationDate((Date)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 410 */             setType((String)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 418 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 419 */             setStringValue((String)value);
/* 420 */           } catch (Exception ee) {
/* 421 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 427 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 428 */             setDateValue((Date)value);
/* 429 */           } catch (Exception ee) {
/* 430 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 436 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 437 */             setDecimalValue((BigDecimal)value);
/* 438 */           } catch (Exception ee) {
/* 439 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDealPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */