/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ButtonGridPropertyId;
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
/*     */ public class ButtonGridPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 970597293L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ButtonGridPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _gridId;
/*     */   private Integer _rowId;
/*     */   private Integer _columnId;
/*     */   private String _componentId;
/*     */   private Integer _sortOrder;
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
/*  44 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  48 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  49 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  54 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  58 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  59 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  64 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  68 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  69 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGridId() {
/*  74 */     return this._gridId;
/*     */   }
/*     */   
/*     */   public void setGridId(String argGridId) {
/*  78 */     if (changed(argGridId, this._gridId, "gridId")) {
/*  79 */       this._gridId = (argGridId != null && MANAGE_CASE) ? argGridId.toUpperCase() : argGridId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRowId() {
/*  84 */     return this._rowId;
/*     */   }
/*     */   
/*     */   public void setRowId(Integer argRowId) {
/*  88 */     if (changed(argRowId, this._rowId, "rowId")) {
/*  89 */       this._rowId = argRowId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getColumnId() {
/*  94 */     return this._columnId;
/*     */   }
/*     */   
/*     */   public void setColumnId(Integer argColumnId) {
/*  98 */     if (changed(argColumnId, this._columnId, "columnId")) {
/*  99 */       this._columnId = argColumnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getComponentId() {
/* 104 */     return this._componentId;
/*     */   }
/*     */   
/*     */   public void setComponentId(String argComponentId) {
/* 108 */     if (changed(argComponentId, this._componentId, "componentId")) {
/* 109 */       this._componentId = (argComponentId != null && MANAGE_CASE) ? argComponentId.toUpperCase() : argComponentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 114 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 118 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 119 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/* 124 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 128 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/* 129 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/* 134 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/* 138 */     if (changed(argType, this._type, "type")) {
/* 139 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 144 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 148 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/* 149 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/* 154 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 158 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 159 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 165 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 169 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 170 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 175 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 179 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 180 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 186 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 190 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 191 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 196 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 200 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 201 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 207 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 211 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 212 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     StringBuilder buf = new StringBuilder(512);
/* 220 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 221 */     if (getOrganizationId() != null) {
/* 222 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 224 */     if (getLevelCode() != null) {
/* 225 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 227 */     if (getLevelValue() != null) {
/* 228 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 230 */     if (getGridId() != null) {
/* 231 */       buf.append("gridId").append("=").append(getGridId()).append(" ");
/*     */     }
/* 233 */     if (getRowId() != null) {
/* 234 */       buf.append("rowId").append("=").append(getRowId()).append(" ");
/*     */     }
/* 236 */     if (getColumnId() != null) {
/* 237 */       buf.append("columnId").append("=").append(getColumnId()).append(" ");
/*     */     }
/* 239 */     if (getComponentId() != null) {
/* 240 */       buf.append("componentId").append("=").append(getComponentId()).append(" ");
/*     */     }
/* 242 */     if (getSortOrder() != null) {
/* 243 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 245 */     if (getPropertyCode() != null) {
/* 246 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 248 */     if (getType() != null) {
/* 249 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 251 */     if (getStringValue() != null) {
/* 252 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 254 */     if (getDateValue() != null) {
/* 255 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 257 */     if (getDecimalValue() != null) {
/* 258 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 260 */     if (getCreateDate() != null) {
/* 261 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 263 */     if (getCreateUserId() != null) {
/* 264 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 266 */     if (getUpdateDate() != null) {
/* 267 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 269 */     if (getUpdateUserId() != null) {
/* 270 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     ButtonGridPropertyId id = new ButtonGridPropertyId();
/* 278 */     id.setOrganizationId(getOrganizationId());
/* 279 */     id.setLevelCode(getLevelCode());
/* 280 */     id.setLevelValue(getLevelValue());
/* 281 */     id.setGridId(getGridId());
/* 282 */     id.setRowId(getRowId());
/* 283 */     id.setColumnId(getColumnId());
/* 284 */     id.setComponentId(getComponentId());
/* 285 */     id.setSortOrder(getSortOrder());
/* 286 */     id.setPropertyCode(getPropertyCode());
/* 287 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 291 */     setOrganizationId(((ButtonGridPropertyId)argObjectId).getOrganizationId());
/* 292 */     setLevelCode(((ButtonGridPropertyId)argObjectId).getLevelCode());
/* 293 */     setLevelValue(((ButtonGridPropertyId)argObjectId).getLevelValue());
/* 294 */     setGridId(((ButtonGridPropertyId)argObjectId).getGridId());
/* 295 */     setRowId(((ButtonGridPropertyId)argObjectId).getRowId());
/* 296 */     setColumnId(((ButtonGridPropertyId)argObjectId).getColumnId());
/* 297 */     setComponentId(((ButtonGridPropertyId)argObjectId).getComponentId());
/* 298 */     setSortOrder(((ButtonGridPropertyId)argObjectId).getSortOrder());
/* 299 */     setPropertyCode(((ButtonGridPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 303 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 307 */     StringBuilder buf = new StringBuilder(850);
/* 308 */     buf.append("<").append("dao").append(" name=\"ButtonGridProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 309 */     getFieldsAsXml(buf);
/* 310 */     buf.append("</").append("dao").append(">");
/*     */     
/* 312 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 316 */     Map<String, String> values = super.getValues();
/* 317 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 318 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 319 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 320 */     if (this._gridId != null) values.put("GridId", DaoUtils.getXmlSafeFieldValue(12, this._gridId)); 
/* 321 */     if (this._rowId != null) values.put("RowId", DaoUtils.getXmlSafeFieldValue(4, this._rowId)); 
/* 322 */     if (this._columnId != null) values.put("ColumnId", DaoUtils.getXmlSafeFieldValue(4, this._columnId)); 
/* 323 */     if (this._componentId != null) values.put("ComponentId", DaoUtils.getXmlSafeFieldValue(12, this._componentId)); 
/* 324 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 325 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 326 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 327 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 328 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 329 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 330 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 331 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 332 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 333 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 334 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 339 */     super.setValues(argValues);
/* 340 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 342 */       String fieldName = field.getKey();
/* 343 */       String fieldValue = field.getValue();
/* 344 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 349 */             setOrganizationId((Long)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 358 */             setLevelCode((String)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setLevelValue((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GridId":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setGridId((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setGridId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RowId":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 385 */             setRowId((Integer)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setRowId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ColumnId":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 394 */             setColumnId((Integer)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setColumnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ComponentId":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 403 */             setComponentId((String)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setComponentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 412 */             setSortOrder((Integer)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 420 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 421 */             setPropertyCode((String)value);
/* 422 */           } catch (Exception ee) {
/* 423 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 429 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 430 */             setType((String)value);
/* 431 */           } catch (Exception ee) {
/* 432 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 438 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 439 */             setStringValue((String)value);
/* 440 */           } catch (Exception ee) {
/* 441 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 447 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 448 */             setDateValue((Date)value);
/* 449 */           } catch (Exception ee) {
/* 450 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 456 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 457 */             setDecimalValue((BigDecimal)value);
/* 458 */           } catch (Exception ee) {
/* 459 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 465 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 466 */             setCreateDate((Date)value);
/* 467 */           } catch (Exception ee) {
/* 468 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 474 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 475 */             setCreateUserId((String)value);
/* 476 */           } catch (Exception ee) {
/* 477 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 483 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 484 */             setUpdateDate((Date)value);
/* 485 */           } catch (Exception ee) {
/* 486 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 492 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 493 */             setUpdateUserId((String)value);
/* 494 */           } catch (Exception ee) {
/* 495 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ButtonGridPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */