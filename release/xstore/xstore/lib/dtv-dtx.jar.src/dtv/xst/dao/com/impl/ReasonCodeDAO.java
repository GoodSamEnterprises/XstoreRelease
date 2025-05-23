/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ReasonCodeId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReasonCodeDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -1579364751L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReasonCodeDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _reasonTypeCode;
/*     */   private String _reasonCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private String _description;
/*     */   private String _commentRequired;
/*     */   private Integer _sortOrder;
/*     */   private String _parentCode;
/*     */   private String _glAccountNumber;
/*     */   private BigDecimal _minimumAmt;
/*     */   private BigDecimal _maximumAmt;
/*     */   private String _customerMessage;
/*     */   private String _inventoryActionCode;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*  44 */   private Boolean _hidden = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  47 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  51 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  52 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonTypeCode() {
/*  57 */     return this._reasonTypeCode;
/*     */   }
/*     */   
/*     */   public void setReasonTypeCode(String argReasonTypeCode) {
/*  61 */     if (changed(argReasonTypeCode, this._reasonTypeCode, "reasonTypeCode")) {
/*  62 */       this._reasonTypeCode = (argReasonTypeCode != null && MANAGE_CASE) ? argReasonTypeCode.toUpperCase() : argReasonTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/*  67 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/*  71 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/*  72 */       this._reasonCode = (argReasonCode != null && MANAGE_CASE) ? argReasonCode.toUpperCase() : argReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/* 119 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 123 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 124 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 129 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 133 */     if (changed(argDescription, this._description, "description")) {
/* 134 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCommentRequired() {
/* 139 */     return this._commentRequired;
/*     */   }
/*     */   
/*     */   public void setCommentRequired(String argCommentRequired) {
/* 143 */     if (changed(argCommentRequired, this._commentRequired, "commentRequired")) {
/* 144 */       this._commentRequired = argCommentRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 149 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 153 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 154 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentCode() {
/* 159 */     return this._parentCode;
/*     */   }
/*     */   
/*     */   public void setParentCode(String argParentCode) {
/* 163 */     if (changed(argParentCode, this._parentCode, "parentCode")) {
/* 164 */       this._parentCode = argParentCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGlAccountNumber() {
/* 169 */     return this._glAccountNumber;
/*     */   }
/*     */   
/*     */   public void setGlAccountNumber(String argGlAccountNumber) {
/* 173 */     if (changed(argGlAccountNumber, this._glAccountNumber, "glAccountNumber")) {
/* 174 */       this._glAccountNumber = argGlAccountNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinimumAmt() {
/* 179 */     return this._minimumAmt;
/*     */   }
/*     */   
/*     */   public void setMinimumAmt(BigDecimal argMinimumAmt) {
/* 183 */     if (changed(argMinimumAmt, this._minimumAmt, "minimumAmt")) {
/* 184 */       this._minimumAmt = argMinimumAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaximumAmt() {
/* 189 */     return this._maximumAmt;
/*     */   }
/*     */   
/*     */   public void setMaximumAmt(BigDecimal argMaximumAmt) {
/* 193 */     if (changed(argMaximumAmt, this._maximumAmt, "maximumAmt")) {
/* 194 */       this._maximumAmt = argMaximumAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerMessage() {
/* 199 */     return this._customerMessage;
/*     */   }
/*     */   
/*     */   public void setCustomerMessage(String argCustomerMessage) {
/* 203 */     if (changed(argCustomerMessage, this._customerMessage, "customerMessage")) {
/* 204 */       this._customerMessage = argCustomerMessage;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryActionCode() {
/* 209 */     return this._inventoryActionCode;
/*     */   }
/*     */   
/*     */   public void setInventoryActionCode(String argInventoryActionCode) {
/* 213 */     if (changed(argInventoryActionCode, this._inventoryActionCode, "inventoryActionCode")) {
/* 214 */       this._inventoryActionCode = argInventoryActionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryLocationId() {
/* 219 */     return this._inventoryLocationId;
/*     */   }
/*     */   
/*     */   public void setInventoryLocationId(String argInventoryLocationId) {
/* 223 */     if (changed(argInventoryLocationId, this._inventoryLocationId, "inventoryLocationId")) {
/* 224 */       this._inventoryLocationId = argInventoryLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/* 229 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 233 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/* 234 */       this._inventoryBucketId = argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHidden() {
/* 239 */     return this._hidden;
/*     */   }
/*     */   
/*     */   public void setHidden(Boolean argHidden) {
/* 243 */     if (changed(argHidden, this._hidden, "hidden")) {
/* 244 */       this._hidden = argHidden;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 251 */     StringBuilder buf = new StringBuilder(512);
/* 252 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 253 */     if (getOrganizationId() != null) {
/* 254 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 256 */     if (getReasonTypeCode() != null) {
/* 257 */       buf.append("reasonTypeCode").append("=").append(getReasonTypeCode()).append(" ");
/*     */     }
/* 259 */     if (getReasonCode() != null) {
/* 260 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/* 262 */     if (getCreateDate() != null) {
/* 263 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 265 */     if (getCreateUserId() != null) {
/* 266 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 268 */     if (getUpdateDate() != null) {
/* 269 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 271 */     if (getUpdateUserId() != null) {
/* 272 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 274 */     if (getConfigElement() != null) {
/* 275 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 277 */     if (getDescription() != null) {
/* 278 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 280 */     if (getCommentRequired() != null) {
/* 281 */       buf.append("commentRequired").append("=").append(getCommentRequired()).append(" ");
/*     */     }
/* 283 */     if (getSortOrder() != null) {
/* 284 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 286 */     if (getParentCode() != null) {
/* 287 */       buf.append("parentCode").append("=").append(getParentCode()).append(" ");
/*     */     }
/* 289 */     if (getGlAccountNumber() != null) {
/* 290 */       buf.append("glAccountNumber").append("=").append(getGlAccountNumber()).append(" ");
/*     */     }
/* 292 */     if (getMinimumAmt() != null) {
/* 293 */       buf.append("minimumAmt").append("=").append(getMinimumAmt()).append(" ");
/*     */     }
/* 295 */     if (getMaximumAmt() != null) {
/* 296 */       buf.append("maximumAmt").append("=").append(getMaximumAmt()).append(" ");
/*     */     }
/* 298 */     if (getCustomerMessage() != null) {
/* 299 */       buf.append("customerMessage").append("=").append(getCustomerMessage()).append(" ");
/*     */     }
/* 301 */     if (getInventoryActionCode() != null) {
/* 302 */       buf.append("inventoryActionCode").append("=").append(getInventoryActionCode()).append(" ");
/*     */     }
/* 304 */     if (getInventoryLocationId() != null) {
/* 305 */       buf.append("inventoryLocationId").append("=").append(getInventoryLocationId()).append(" ");
/*     */     }
/* 307 */     if (getInventoryBucketId() != null) {
/* 308 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 310 */     if (getHidden() != null && getHidden().booleanValue()) {
/* 311 */       buf.append("hidden").append("=").append(getHidden()).append(" ");
/*     */     }
/*     */     
/* 314 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 318 */     ReasonCodeId id = new ReasonCodeId();
/* 319 */     id.setOrganizationId(getOrganizationId());
/* 320 */     id.setReasonTypeCode(getReasonTypeCode());
/* 321 */     id.setReasonCode(getReasonCode());
/* 322 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 326 */     setOrganizationId(((ReasonCodeId)argObjectId).getOrganizationId());
/* 327 */     setReasonTypeCode(((ReasonCodeId)argObjectId).getReasonTypeCode());
/* 328 */     setReasonCode(((ReasonCodeId)argObjectId).getReasonCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 332 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 336 */     StringBuilder buf = new StringBuilder(1000);
/* 337 */     buf.append("<").append("dao").append(" name=\"ReasonCode\" cmd=\"" + getObjectStateString() + "\">");
/* 338 */     getFieldsAsXml(buf);
/* 339 */     buf.append("</").append("dao").append(">");
/*     */     
/* 341 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 345 */     Map<String, String> values = super.getValues();
/* 346 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 347 */     if (this._reasonTypeCode != null) values.put("ReasonTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonTypeCode)); 
/* 348 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 349 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 350 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 351 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 352 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 353 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 354 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 355 */     if (this._commentRequired != null) values.put("CommentRequired", DaoUtils.getXmlSafeFieldValue(12, this._commentRequired)); 
/* 356 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 357 */     if (this._parentCode != null) values.put("ParentCode", DaoUtils.getXmlSafeFieldValue(12, this._parentCode)); 
/* 358 */     if (this._glAccountNumber != null) values.put("GlAccountNumber", DaoUtils.getXmlSafeFieldValue(12, this._glAccountNumber)); 
/* 359 */     if (this._minimumAmt != null) values.put("MinimumAmt", DaoUtils.getXmlSafeFieldValue(3, this._minimumAmt)); 
/* 360 */     if (this._maximumAmt != null) values.put("MaximumAmt", DaoUtils.getXmlSafeFieldValue(3, this._maximumAmt)); 
/* 361 */     if (this._customerMessage != null) values.put("CustomerMessage", DaoUtils.getXmlSafeFieldValue(12, this._customerMessage)); 
/* 362 */     if (this._inventoryActionCode != null) values.put("InventoryActionCode", DaoUtils.getXmlSafeFieldValue(12, this._inventoryActionCode)); 
/* 363 */     if (this._inventoryLocationId != null) values.put("InventoryLocationId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryLocationId)); 
/* 364 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 365 */     if (this._hidden != null) values.put("Hidden", DaoUtils.getXmlSafeFieldValue(-7, this._hidden)); 
/* 366 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 371 */     super.setValues(argValues);
/* 372 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 374 */       String fieldName = field.getKey();
/* 375 */       String fieldValue = field.getValue();
/* 376 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 381 */             setOrganizationId((Long)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonTypeCode":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setReasonTypeCode((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setReasonTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setReasonCode((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 408 */             setCreateDate((Date)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setCreateUserId((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setUpdateDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setUpdateUserId((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 444 */             setConfigElement((String)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 453 */             setDescription((String)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CommentRequired":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 462 */             setCommentRequired((String)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setCommentRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 471 */             setSortOrder((Integer)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentCode":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setParentCode((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setParentCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GlAccountNumber":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 489 */             setGlAccountNumber((String)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setGlAccountNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumAmt":
/*     */           try {
/* 497 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 498 */             setMinimumAmt((BigDecimal)value);
/* 499 */           } catch (Exception ee) {
/* 500 */             throw new DtxException("An exception occurred while calling setMinimumAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumAmt":
/*     */           try {
/* 506 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 507 */             setMaximumAmt((BigDecimal)value);
/* 508 */           } catch (Exception ee) {
/* 509 */             throw new DtxException("An exception occurred while calling setMaximumAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerMessage":
/*     */           try {
/* 515 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 516 */             setCustomerMessage((String)value);
/* 517 */           } catch (Exception ee) {
/* 518 */             throw new DtxException("An exception occurred while calling setCustomerMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryActionCode":
/*     */           try {
/* 524 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 525 */             setInventoryActionCode((String)value);
/* 526 */           } catch (Exception ee) {
/* 527 */             throw new DtxException("An exception occurred while calling setInventoryActionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryLocationId":
/*     */           try {
/* 533 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 534 */             setInventoryLocationId((String)value);
/* 535 */           } catch (Exception ee) {
/* 536 */             throw new DtxException("An exception occurred while calling setInventoryLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 542 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 543 */             setInventoryBucketId((String)value);
/* 544 */           } catch (Exception ee) {
/* 545 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hidden":
/*     */           try {
/* 551 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 552 */             setHidden((Boolean)value);
/* 553 */           } catch (Exception ee) {
/* 554 */             throw new DtxException("An exception occurred while calling setHidden() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReasonCodeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */