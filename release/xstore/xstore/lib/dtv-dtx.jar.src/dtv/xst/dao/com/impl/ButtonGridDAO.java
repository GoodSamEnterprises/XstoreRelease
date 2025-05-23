/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ButtonGridId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ButtonGridDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1943332424L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ButtonGridDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _gridId;
/*     */   private Integer _rowId;
/*     */   private Integer _columnId;
/*     */   private String _componentId;
/*     */   private Integer _sortOrder;
/*     */   private String _childId;
/*     */   private String _keyName;
/*     */   private String _data;
/*     */   private String _text;
/*     */   private Integer _textX;
/*     */   private Integer _textY;
/*     */   private String _imageFilename;
/*     */   private Integer _imageX;
/*     */   private Integer _imageY;
/*     */   private String _visibilityRule;
/*     */   private Integer _heightSpan;
/*     */   private Integer _widthSpan;
/*     */   private String _backgroundRgb;
/*     */   private String _foregroundRgb;
/*     */   private String _buttonStyle;
/*     */   private Integer _actionIdx;
/*     */   private Integer _animationIdx;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _recordState;
/*     */   
/*     */   public Long getOrganizationId() {
/*  57 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  61 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  62 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  67 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  71 */     if (changed(argLevelCode, this._levelCode, "levelCode")) {
/*  72 */       this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  77 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  81 */     if (changed(argLevelValue, this._levelValue, "levelValue")) {
/*  82 */       this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGridId() {
/*  87 */     return this._gridId;
/*     */   }
/*     */   
/*     */   public void setGridId(String argGridId) {
/*  91 */     if (changed(argGridId, this._gridId, "gridId")) {
/*  92 */       this._gridId = (argGridId != null && MANAGE_CASE) ? argGridId.toUpperCase() : argGridId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRowId() {
/*  97 */     return this._rowId;
/*     */   }
/*     */   
/*     */   public void setRowId(Integer argRowId) {
/* 101 */     if (changed(argRowId, this._rowId, "rowId")) {
/* 102 */       this._rowId = argRowId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getColumnId() {
/* 107 */     return this._columnId;
/*     */   }
/*     */   
/*     */   public void setColumnId(Integer argColumnId) {
/* 111 */     if (changed(argColumnId, this._columnId, "columnId")) {
/* 112 */       this._columnId = argColumnId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getComponentId() {
/* 117 */     return this._componentId;
/*     */   }
/*     */   
/*     */   public void setComponentId(String argComponentId) {
/* 121 */     if (changed(argComponentId, this._componentId, "componentId")) {
/* 122 */       this._componentId = (argComponentId != null && MANAGE_CASE) ? argComponentId.toUpperCase() : argComponentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 127 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 131 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 132 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getChildId() {
/* 137 */     return this._childId;
/*     */   }
/*     */   
/*     */   public void setChildId(String argChildId) {
/* 141 */     if (changed(argChildId, this._childId, "childId")) {
/* 142 */       this._childId = argChildId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getKeyName() {
/* 147 */     return this._keyName;
/*     */   }
/*     */   
/*     */   public void setKeyName(String argKeyName) {
/* 151 */     if (changed(argKeyName, this._keyName, "keyName")) {
/* 152 */       this._keyName = argKeyName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getData() {
/* 157 */     return this._data;
/*     */   }
/*     */   
/*     */   public void setData(String argData) {
/* 161 */     if (changed(argData, this._data, "data")) {
/* 162 */       this._data = argData;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getText() {
/* 167 */     return this._text;
/*     */   }
/*     */   
/*     */   public void setText(String argText) {
/* 171 */     if (changed(argText, this._text, "text")) {
/* 172 */       this._text = argText;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTextX() {
/* 177 */     return this._textX;
/*     */   }
/*     */   
/*     */   public void setTextX(Integer argTextX) {
/* 181 */     if (changed(argTextX, this._textX, "textX")) {
/* 182 */       this._textX = argTextX;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getTextY() {
/* 187 */     return this._textY;
/*     */   }
/*     */   
/*     */   public void setTextY(Integer argTextY) {
/* 191 */     if (changed(argTextY, this._textY, "textY")) {
/* 192 */       this._textY = argTextY;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getImageFilename() {
/* 197 */     return this._imageFilename;
/*     */   }
/*     */   
/*     */   public void setImageFilename(String argImageFilename) {
/* 201 */     if (changed(argImageFilename, this._imageFilename, "imageFilename")) {
/* 202 */       this._imageFilename = argImageFilename;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getImageX() {
/* 207 */     return this._imageX;
/*     */   }
/*     */   
/*     */   public void setImageX(Integer argImageX) {
/* 211 */     if (changed(argImageX, this._imageX, "imageX")) {
/* 212 */       this._imageX = argImageX;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getImageY() {
/* 217 */     return this._imageY;
/*     */   }
/*     */   
/*     */   public void setImageY(Integer argImageY) {
/* 221 */     if (changed(argImageY, this._imageY, "imageY")) {
/* 222 */       this._imageY = argImageY;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVisibilityRule() {
/* 227 */     return this._visibilityRule;
/*     */   }
/*     */   
/*     */   public void setVisibilityRule(String argVisibilityRule) {
/* 231 */     if (changed(argVisibilityRule, this._visibilityRule, "visibilityRule")) {
/* 232 */       this._visibilityRule = argVisibilityRule;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getHeightSpan() {
/* 237 */     return this._heightSpan;
/*     */   }
/*     */   
/*     */   public void setHeightSpan(Integer argHeightSpan) {
/* 241 */     if (changed(argHeightSpan, this._heightSpan, "heightSpan")) {
/* 242 */       this._heightSpan = argHeightSpan;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getWidthSpan() {
/* 247 */     return this._widthSpan;
/*     */   }
/*     */   
/*     */   public void setWidthSpan(Integer argWidthSpan) {
/* 251 */     if (changed(argWidthSpan, this._widthSpan, "widthSpan")) {
/* 252 */       this._widthSpan = argWidthSpan;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBackgroundRgb() {
/* 257 */     return this._backgroundRgb;
/*     */   }
/*     */   
/*     */   public void setBackgroundRgb(String argBackgroundRgb) {
/* 261 */     if (changed(argBackgroundRgb, this._backgroundRgb, "backgroundRgb")) {
/* 262 */       this._backgroundRgb = argBackgroundRgb;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getForegroundRgb() {
/* 267 */     return this._foregroundRgb;
/*     */   }
/*     */   
/*     */   public void setForegroundRgb(String argForegroundRgb) {
/* 271 */     if (changed(argForegroundRgb, this._foregroundRgb, "foregroundRgb")) {
/* 272 */       this._foregroundRgb = argForegroundRgb;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getButtonStyle() {
/* 277 */     return this._buttonStyle;
/*     */   }
/*     */   
/*     */   public void setButtonStyle(String argButtonStyle) {
/* 281 */     if (changed(argButtonStyle, this._buttonStyle, "buttonStyle")) {
/* 282 */       this._buttonStyle = argButtonStyle;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getActionIdx() {
/* 287 */     return this._actionIdx;
/*     */   }
/*     */   
/*     */   public void setActionIdx(Integer argActionIdx) {
/* 291 */     if (changed(argActionIdx, this._actionIdx, "actionIdx")) {
/* 292 */       this._actionIdx = argActionIdx;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getAnimationIdx() {
/* 297 */     return this._animationIdx;
/*     */   }
/*     */   
/*     */   public void setAnimationIdx(Integer argAnimationIdx) {
/* 301 */     if (changed(argAnimationIdx, this._animationIdx, "animationIdx")) {
/* 302 */       this._animationIdx = argAnimationIdx;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 307 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 311 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 312 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 318 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 322 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 323 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 328 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 332 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 333 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 339 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 343 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 344 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordState() {
/* 349 */     return this._recordState;
/*     */   }
/*     */   
/*     */   public void setRecordState(String argRecordState) {
/* 353 */     if (changed(argRecordState, this._recordState, "recordState")) {
/* 354 */       this._recordState = argRecordState;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 361 */     StringBuilder buf = new StringBuilder(512);
/* 362 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 363 */     if (getOrganizationId() != null) {
/* 364 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 366 */     if (getLevelCode() != null) {
/* 367 */       buf.append("levelCode").append("=").append(getLevelCode()).append(" ");
/*     */     }
/* 369 */     if (getLevelValue() != null) {
/* 370 */       buf.append("levelValue").append("=").append(getLevelValue()).append(" ");
/*     */     }
/* 372 */     if (getGridId() != null) {
/* 373 */       buf.append("gridId").append("=").append(getGridId()).append(" ");
/*     */     }
/* 375 */     if (getRowId() != null) {
/* 376 */       buf.append("rowId").append("=").append(getRowId()).append(" ");
/*     */     }
/* 378 */     if (getColumnId() != null) {
/* 379 */       buf.append("columnId").append("=").append(getColumnId()).append(" ");
/*     */     }
/* 381 */     if (getComponentId() != null) {
/* 382 */       buf.append("componentId").append("=").append(getComponentId()).append(" ");
/*     */     }
/* 384 */     if (getSortOrder() != null) {
/* 385 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 387 */     if (getChildId() != null) {
/* 388 */       buf.append("childId").append("=").append(getChildId()).append(" ");
/*     */     }
/* 390 */     if (getKeyName() != null) {
/* 391 */       buf.append("keyName").append("=").append(getKeyName()).append(" ");
/*     */     }
/* 393 */     if (getData() != null) {
/* 394 */       buf.append("data").append("=").append(getData()).append(" ");
/*     */     }
/* 396 */     if (getText() != null) {
/* 397 */       buf.append("text").append("=").append(getText()).append(" ");
/*     */     }
/* 399 */     if (getTextX() != null) {
/* 400 */       buf.append("textX").append("=").append(getTextX()).append(" ");
/*     */     }
/* 402 */     if (getTextY() != null) {
/* 403 */       buf.append("textY").append("=").append(getTextY()).append(" ");
/*     */     }
/* 405 */     if (getImageFilename() != null) {
/* 406 */       buf.append("imageFilename").append("=").append(getImageFilename()).append(" ");
/*     */     }
/* 408 */     if (getImageX() != null) {
/* 409 */       buf.append("imageX").append("=").append(getImageX()).append(" ");
/*     */     }
/* 411 */     if (getImageY() != null) {
/* 412 */       buf.append("imageY").append("=").append(getImageY()).append(" ");
/*     */     }
/* 414 */     if (getVisibilityRule() != null) {
/* 415 */       buf.append("visibilityRule").append("=").append(getVisibilityRule()).append(" ");
/*     */     }
/* 417 */     if (getHeightSpan() != null) {
/* 418 */       buf.append("heightSpan").append("=").append(getHeightSpan()).append(" ");
/*     */     }
/* 420 */     if (getWidthSpan() != null) {
/* 421 */       buf.append("widthSpan").append("=").append(getWidthSpan()).append(" ");
/*     */     }
/* 423 */     if (getBackgroundRgb() != null) {
/* 424 */       buf.append("backgroundRgb").append("=").append(getBackgroundRgb()).append(" ");
/*     */     }
/* 426 */     if (getForegroundRgb() != null) {
/* 427 */       buf.append("foregroundRgb").append("=").append(getForegroundRgb()).append(" ");
/*     */     }
/* 429 */     if (getButtonStyle() != null) {
/* 430 */       buf.append("buttonStyle").append("=").append(getButtonStyle()).append(" ");
/*     */     }
/* 432 */     if (getActionIdx() != null) {
/* 433 */       buf.append("actionIdx").append("=").append(getActionIdx()).append(" ");
/*     */     }
/* 435 */     if (getAnimationIdx() != null) {
/* 436 */       buf.append("animationIdx").append("=").append(getAnimationIdx()).append(" ");
/*     */     }
/* 438 */     if (getCreateDate() != null) {
/* 439 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 441 */     if (getCreateUserId() != null) {
/* 442 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 444 */     if (getUpdateDate() != null) {
/* 445 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 447 */     if (getUpdateUserId() != null) {
/* 448 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 450 */     if (getRecordState() != null) {
/* 451 */       buf.append("recordState").append("=").append(getRecordState()).append(" ");
/*     */     }
/*     */     
/* 454 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 458 */     ButtonGridId id = new ButtonGridId();
/* 459 */     id.setOrganizationId(getOrganizationId());
/* 460 */     id.setLevelCode(getLevelCode());
/* 461 */     id.setLevelValue(getLevelValue());
/* 462 */     id.setGridId(getGridId());
/* 463 */     id.setRowId(getRowId());
/* 464 */     id.setColumnId(getColumnId());
/* 465 */     id.setComponentId(getComponentId());
/* 466 */     id.setSortOrder(getSortOrder());
/* 467 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 471 */     setOrganizationId(((ButtonGridId)argObjectId).getOrganizationId());
/* 472 */     setLevelCode(((ButtonGridId)argObjectId).getLevelCode());
/* 473 */     setLevelValue(((ButtonGridId)argObjectId).getLevelValue());
/* 474 */     setGridId(((ButtonGridId)argObjectId).getGridId());
/* 475 */     setRowId(((ButtonGridId)argObjectId).getRowId());
/* 476 */     setColumnId(((ButtonGridId)argObjectId).getColumnId());
/* 477 */     setComponentId(((ButtonGridId)argObjectId).getComponentId());
/* 478 */     setSortOrder(((ButtonGridId)argObjectId).getSortOrder());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 482 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 486 */     StringBuilder buf = new StringBuilder(1500);
/* 487 */     buf.append("<").append("dao").append(" name=\"ButtonGrid\" cmd=\"" + getObjectStateString() + "\">");
/* 488 */     getFieldsAsXml(buf);
/* 489 */     buf.append("</").append("dao").append(">");
/*     */     
/* 491 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 495 */     Map<String, String> values = super.getValues();
/* 496 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 497 */     if (this._levelCode != null) values.put("LevelCode", DaoUtils.getXmlSafeFieldValue(12, this._levelCode)); 
/* 498 */     if (this._levelValue != null) values.put("LevelValue", DaoUtils.getXmlSafeFieldValue(12, this._levelValue)); 
/* 499 */     if (this._gridId != null) values.put("GridId", DaoUtils.getXmlSafeFieldValue(12, this._gridId)); 
/* 500 */     if (this._rowId != null) values.put("RowId", DaoUtils.getXmlSafeFieldValue(4, this._rowId)); 
/* 501 */     if (this._columnId != null) values.put("ColumnId", DaoUtils.getXmlSafeFieldValue(4, this._columnId)); 
/* 502 */     if (this._componentId != null) values.put("ComponentId", DaoUtils.getXmlSafeFieldValue(12, this._componentId)); 
/* 503 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 504 */     if (this._childId != null) values.put("ChildId", DaoUtils.getXmlSafeFieldValue(12, this._childId)); 
/* 505 */     if (this._keyName != null) values.put("KeyName", DaoUtils.getXmlSafeFieldValue(12, this._keyName)); 
/* 506 */     if (this._data != null) values.put("Data", DaoUtils.getXmlSafeFieldValue(12, this._data)); 
/* 507 */     if (this._text != null) values.put("Text", DaoUtils.getXmlSafeFieldValue(12, this._text)); 
/* 508 */     if (this._textX != null) values.put("TextX", DaoUtils.getXmlSafeFieldValue(4, this._textX)); 
/* 509 */     if (this._textY != null) values.put("TextY", DaoUtils.getXmlSafeFieldValue(4, this._textY)); 
/* 510 */     if (this._imageFilename != null) values.put("ImageFilename", DaoUtils.getXmlSafeFieldValue(12, this._imageFilename)); 
/* 511 */     if (this._imageX != null) values.put("ImageX", DaoUtils.getXmlSafeFieldValue(4, this._imageX)); 
/* 512 */     if (this._imageY != null) values.put("ImageY", DaoUtils.getXmlSafeFieldValue(4, this._imageY)); 
/* 513 */     if (this._visibilityRule != null) values.put("VisibilityRule", DaoUtils.getXmlSafeFieldValue(12, this._visibilityRule)); 
/* 514 */     if (this._heightSpan != null) values.put("HeightSpan", DaoUtils.getXmlSafeFieldValue(4, this._heightSpan)); 
/* 515 */     if (this._widthSpan != null) values.put("WidthSpan", DaoUtils.getXmlSafeFieldValue(4, this._widthSpan)); 
/* 516 */     if (this._backgroundRgb != null) values.put("BackgroundRgb", DaoUtils.getXmlSafeFieldValue(12, this._backgroundRgb)); 
/* 517 */     if (this._foregroundRgb != null) values.put("ForegroundRgb", DaoUtils.getXmlSafeFieldValue(12, this._foregroundRgb)); 
/* 518 */     if (this._buttonStyle != null) values.put("ButtonStyle", DaoUtils.getXmlSafeFieldValue(12, this._buttonStyle)); 
/* 519 */     if (this._actionIdx != null) values.put("ActionIdx", DaoUtils.getXmlSafeFieldValue(4, this._actionIdx)); 
/* 520 */     if (this._animationIdx != null) values.put("AnimationIdx", DaoUtils.getXmlSafeFieldValue(4, this._animationIdx)); 
/* 521 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 522 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 523 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 524 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 525 */     if (this._recordState != null) values.put("RecordState", DaoUtils.getXmlSafeFieldValue(12, this._recordState)); 
/* 526 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 531 */     super.setValues(argValues);
/* 532 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 534 */       String fieldName = field.getKey();
/* 535 */       String fieldValue = field.getValue();
/* 536 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 540 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 541 */             setOrganizationId((Long)value);
/* 542 */           } catch (Exception ee) {
/* 543 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelCode":
/*     */           try {
/* 549 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 550 */             setLevelCode((String)value);
/* 551 */           } catch (Exception ee) {
/* 552 */             throw new DtxException("An exception occurred while calling setLevelCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LevelValue":
/*     */           try {
/* 558 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 559 */             setLevelValue((String)value);
/* 560 */           } catch (Exception ee) {
/* 561 */             throw new DtxException("An exception occurred while calling setLevelValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GridId":
/*     */           try {
/* 567 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 568 */             setGridId((String)value);
/* 569 */           } catch (Exception ee) {
/* 570 */             throw new DtxException("An exception occurred while calling setGridId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RowId":
/*     */           try {
/* 576 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 577 */             setRowId((Integer)value);
/* 578 */           } catch (Exception ee) {
/* 579 */             throw new DtxException("An exception occurred while calling setRowId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ColumnId":
/*     */           try {
/* 585 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 586 */             setColumnId((Integer)value);
/* 587 */           } catch (Exception ee) {
/* 588 */             throw new DtxException("An exception occurred while calling setColumnId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ComponentId":
/*     */           try {
/* 594 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 595 */             setComponentId((String)value);
/* 596 */           } catch (Exception ee) {
/* 597 */             throw new DtxException("An exception occurred while calling setComponentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 603 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 604 */             setSortOrder((Integer)value);
/* 605 */           } catch (Exception ee) {
/* 606 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildId":
/*     */           try {
/* 612 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 613 */             setChildId((String)value);
/* 614 */           } catch (Exception ee) {
/* 615 */             throw new DtxException("An exception occurred while calling setChildId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "KeyName":
/*     */           try {
/* 621 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 622 */             setKeyName((String)value);
/* 623 */           } catch (Exception ee) {
/* 624 */             throw new DtxException("An exception occurred while calling setKeyName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Data":
/*     */           try {
/* 630 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 631 */             setData((String)value);
/* 632 */           } catch (Exception ee) {
/* 633 */             throw new DtxException("An exception occurred while calling setData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Text":
/*     */           try {
/* 639 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 640 */             setText((String)value);
/* 641 */           } catch (Exception ee) {
/* 642 */             throw new DtxException("An exception occurred while calling setText() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextX":
/*     */           try {
/* 648 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 649 */             setTextX((Integer)value);
/* 650 */           } catch (Exception ee) {
/* 651 */             throw new DtxException("An exception occurred while calling setTextX() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextY":
/*     */           try {
/* 657 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 658 */             setTextY((Integer)value);
/* 659 */           } catch (Exception ee) {
/* 660 */             throw new DtxException("An exception occurred while calling setTextY() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ImageFilename":
/*     */           try {
/* 666 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 667 */             setImageFilename((String)value);
/* 668 */           } catch (Exception ee) {
/* 669 */             throw new DtxException("An exception occurred while calling setImageFilename() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ImageX":
/*     */           try {
/* 675 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 676 */             setImageX((Integer)value);
/* 677 */           } catch (Exception ee) {
/* 678 */             throw new DtxException("An exception occurred while calling setImageX() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ImageY":
/*     */           try {
/* 684 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 685 */             setImageY((Integer)value);
/* 686 */           } catch (Exception ee) {
/* 687 */             throw new DtxException("An exception occurred while calling setImageY() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VisibilityRule":
/*     */           try {
/* 693 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 694 */             setVisibilityRule((String)value);
/* 695 */           } catch (Exception ee) {
/* 696 */             throw new DtxException("An exception occurred while calling setVisibilityRule() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "HeightSpan":
/*     */           try {
/* 702 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 703 */             setHeightSpan((Integer)value);
/* 704 */           } catch (Exception ee) {
/* 705 */             throw new DtxException("An exception occurred while calling setHeightSpan() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WidthSpan":
/*     */           try {
/* 711 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 712 */             setWidthSpan((Integer)value);
/* 713 */           } catch (Exception ee) {
/* 714 */             throw new DtxException("An exception occurred while calling setWidthSpan() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BackgroundRgb":
/*     */           try {
/* 720 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 721 */             setBackgroundRgb((String)value);
/* 722 */           } catch (Exception ee) {
/* 723 */             throw new DtxException("An exception occurred while calling setBackgroundRgb() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ForegroundRgb":
/*     */           try {
/* 729 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 730 */             setForegroundRgb((String)value);
/* 731 */           } catch (Exception ee) {
/* 732 */             throw new DtxException("An exception occurred while calling setForegroundRgb() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ButtonStyle":
/*     */           try {
/* 738 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 739 */             setButtonStyle((String)value);
/* 740 */           } catch (Exception ee) {
/* 741 */             throw new DtxException("An exception occurred while calling setButtonStyle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActionIdx":
/*     */           try {
/* 747 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 748 */             setActionIdx((Integer)value);
/* 749 */           } catch (Exception ee) {
/* 750 */             throw new DtxException("An exception occurred while calling setActionIdx() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AnimationIdx":
/*     */           try {
/* 756 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 757 */             setAnimationIdx((Integer)value);
/* 758 */           } catch (Exception ee) {
/* 759 */             throw new DtxException("An exception occurred while calling setAnimationIdx() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 765 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 766 */             setCreateDate((Date)value);
/* 767 */           } catch (Exception ee) {
/* 768 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 774 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 775 */             setCreateUserId((String)value);
/* 776 */           } catch (Exception ee) {
/* 777 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 783 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 784 */             setUpdateDate((Date)value);
/* 785 */           } catch (Exception ee) {
/* 786 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 792 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 793 */             setUpdateUserId((String)value);
/* 794 */           } catch (Exception ee) {
/* 795 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordState":
/*     */           try {
/* 801 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 802 */             setRecordState((String)value);
/* 803 */           } catch (Exception ee) {
/* 804 */             throw new DtxException("An exception occurred while calling setRecordState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ButtonGridDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */