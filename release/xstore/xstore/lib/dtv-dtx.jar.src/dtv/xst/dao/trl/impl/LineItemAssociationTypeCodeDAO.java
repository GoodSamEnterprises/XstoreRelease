/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.LineItemAssociationTypeCodeId;
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
/*     */ public class LineItemAssociationTypeCodeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 326133537L;
/*  23 */   private static final Logger _logger = Logger.getLogger(LineItemAssociationTypeCodeDAO.class);
/*     */   
/*     */   private String _lineItemAssociationTypeCode;
/*     */   private Long _organizationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*  31 */   private Boolean _cascadeDelete = Boolean.FALSE;
/*  32 */   private Boolean _cascadeQuantity = Boolean.FALSE;
/*  33 */   private Boolean _childRestrictDelete = Boolean.FALSE;
/*  34 */   private Boolean _childRestrictPrice = Boolean.FALSE;
/*  35 */   private Boolean _childRestrictQuantity = Boolean.FALSE;
/*     */   private String _description;
/*  37 */   private Boolean _parentRestrictDelete = Boolean.FALSE;
/*  38 */   private Boolean _parentRestrictPrice = Boolean.FALSE;
/*  39 */   private Boolean _parentRestrictQuantity = Boolean.FALSE;
/*     */   private Integer _sortOrder;
/*     */   
/*     */   public String getLineItemAssociationTypeCode() {
/*  43 */     return this._lineItemAssociationTypeCode;
/*     */   }
/*     */   
/*     */   public void setLineItemAssociationTypeCode(String argLineItemAssociationTypeCode) {
/*  47 */     if (changed(argLineItemAssociationTypeCode, this._lineItemAssociationTypeCode, "lineItemAssociationTypeCode")) {
/*  48 */       this._lineItemAssociationTypeCode = (argLineItemAssociationTypeCode != null && MANAGE_CASE) ? argLineItemAssociationTypeCode.toUpperCase() : argLineItemAssociationTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  53 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  57 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  58 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  63 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  67 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  68 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  74 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  78 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  79 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  84 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  88 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  89 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  95 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  99 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 100 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCascadeDelete() {
/* 105 */     return this._cascadeDelete;
/*     */   }
/*     */   
/*     */   public void setCascadeDelete(Boolean argCascadeDelete) {
/* 109 */     if (changed(argCascadeDelete, this._cascadeDelete, "cascadeDelete")) {
/* 110 */       this._cascadeDelete = argCascadeDelete;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCascadeQuantity() {
/* 115 */     return this._cascadeQuantity;
/*     */   }
/*     */   
/*     */   public void setCascadeQuantity(Boolean argCascadeQuantity) {
/* 119 */     if (changed(argCascadeQuantity, this._cascadeQuantity, "cascadeQuantity")) {
/* 120 */       this._cascadeQuantity = argCascadeQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getChildRestrictDelete() {
/* 125 */     return this._childRestrictDelete;
/*     */   }
/*     */   
/*     */   public void setChildRestrictDelete(Boolean argChildRestrictDelete) {
/* 129 */     if (changed(argChildRestrictDelete, this._childRestrictDelete, "childRestrictDelete")) {
/* 130 */       this._childRestrictDelete = argChildRestrictDelete;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getChildRestrictPrice() {
/* 135 */     return this._childRestrictPrice;
/*     */   }
/*     */   
/*     */   public void setChildRestrictPrice(Boolean argChildRestrictPrice) {
/* 139 */     if (changed(argChildRestrictPrice, this._childRestrictPrice, "childRestrictPrice")) {
/* 140 */       this._childRestrictPrice = argChildRestrictPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getChildRestrictQuantity() {
/* 145 */     return this._childRestrictQuantity;
/*     */   }
/*     */   
/*     */   public void setChildRestrictQuantity(Boolean argChildRestrictQuantity) {
/* 149 */     if (changed(argChildRestrictQuantity, this._childRestrictQuantity, "childRestrictQuantity")) {
/* 150 */       this._childRestrictQuantity = argChildRestrictQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 155 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 159 */     if (changed(argDescription, this._description, "description")) {
/* 160 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getParentRestrictDelete() {
/* 165 */     return this._parentRestrictDelete;
/*     */   }
/*     */   
/*     */   public void setParentRestrictDelete(Boolean argParentRestrictDelete) {
/* 169 */     if (changed(argParentRestrictDelete, this._parentRestrictDelete, "parentRestrictDelete")) {
/* 170 */       this._parentRestrictDelete = argParentRestrictDelete;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getParentRestrictPrice() {
/* 175 */     return this._parentRestrictPrice;
/*     */   }
/*     */   
/*     */   public void setParentRestrictPrice(Boolean argParentRestrictPrice) {
/* 179 */     if (changed(argParentRestrictPrice, this._parentRestrictPrice, "parentRestrictPrice")) {
/* 180 */       this._parentRestrictPrice = argParentRestrictPrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getParentRestrictQuantity() {
/* 185 */     return this._parentRestrictQuantity;
/*     */   }
/*     */   
/*     */   public void setParentRestrictQuantity(Boolean argParentRestrictQuantity) {
/* 189 */     if (changed(argParentRestrictQuantity, this._parentRestrictQuantity, "parentRestrictQuantity")) {
/* 190 */       this._parentRestrictQuantity = argParentRestrictQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 195 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 199 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 200 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 207 */     StringBuilder buf = new StringBuilder(512);
/* 208 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 209 */     if (getLineItemAssociationTypeCode() != null) {
/* 210 */       buf.append("lineItemAssociationTypeCode").append("=").append(getLineItemAssociationTypeCode()).append(" ");
/*     */     }
/* 212 */     if (getOrganizationId() != null) {
/* 213 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 215 */     if (getCreateDate() != null) {
/* 216 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 218 */     if (getCreateUserId() != null) {
/* 219 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 221 */     if (getUpdateDate() != null) {
/* 222 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 224 */     if (getUpdateUserId() != null) {
/* 225 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 227 */     if (getCascadeDelete() != null && getCascadeDelete().booleanValue()) {
/* 228 */       buf.append("cascadeDelete").append("=").append(getCascadeDelete()).append(" ");
/*     */     }
/* 230 */     if (getCascadeQuantity() != null && getCascadeQuantity().booleanValue()) {
/* 231 */       buf.append("cascadeQuantity").append("=").append(getCascadeQuantity()).append(" ");
/*     */     }
/* 233 */     if (getChildRestrictDelete() != null && getChildRestrictDelete().booleanValue()) {
/* 234 */       buf.append("childRestrictDelete").append("=").append(getChildRestrictDelete()).append(" ");
/*     */     }
/* 236 */     if (getChildRestrictPrice() != null && getChildRestrictPrice().booleanValue()) {
/* 237 */       buf.append("childRestrictPrice").append("=").append(getChildRestrictPrice()).append(" ");
/*     */     }
/* 239 */     if (getChildRestrictQuantity() != null && getChildRestrictQuantity().booleanValue()) {
/* 240 */       buf.append("childRestrictQuantity").append("=").append(getChildRestrictQuantity()).append(" ");
/*     */     }
/* 242 */     if (getDescription() != null) {
/* 243 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 245 */     if (getParentRestrictDelete() != null && getParentRestrictDelete().booleanValue()) {
/* 246 */       buf.append("parentRestrictDelete").append("=").append(getParentRestrictDelete()).append(" ");
/*     */     }
/* 248 */     if (getParentRestrictPrice() != null && getParentRestrictPrice().booleanValue()) {
/* 249 */       buf.append("parentRestrictPrice").append("=").append(getParentRestrictPrice()).append(" ");
/*     */     }
/* 251 */     if (getParentRestrictQuantity() != null && getParentRestrictQuantity().booleanValue()) {
/* 252 */       buf.append("parentRestrictQuantity").append("=").append(getParentRestrictQuantity()).append(" ");
/*     */     }
/* 254 */     if (getSortOrder() != null) {
/* 255 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/*     */     
/* 258 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 262 */     LineItemAssociationTypeCodeId id = new LineItemAssociationTypeCodeId();
/* 263 */     id.setLineItemAssociationTypeCode(getLineItemAssociationTypeCode());
/* 264 */     id.setOrganizationId(getOrganizationId());
/* 265 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 269 */     setLineItemAssociationTypeCode(((LineItemAssociationTypeCodeId)argObjectId).getLineItemAssociationTypeCode());
/* 270 */     setOrganizationId(((LineItemAssociationTypeCodeId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 274 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 278 */     StringBuilder buf = new StringBuilder(800);
/* 279 */     buf.append("<").append("dao").append(" name=\"LineItemAssociationTypeCode\" cmd=\"" + getObjectStateString() + "\">");
/* 280 */     getFieldsAsXml(buf);
/* 281 */     buf.append("</").append("dao").append(">");
/*     */     
/* 283 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 287 */     Map<String, String> values = super.getValues();
/* 288 */     if (this._lineItemAssociationTypeCode != null) values.put("LineItemAssociationTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._lineItemAssociationTypeCode)); 
/* 289 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 290 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 291 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 292 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 293 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 294 */     if (this._cascadeDelete != null) values.put("CascadeDelete", DaoUtils.getXmlSafeFieldValue(-7, this._cascadeDelete)); 
/* 295 */     if (this._cascadeQuantity != null) values.put("CascadeQuantity", DaoUtils.getXmlSafeFieldValue(-7, this._cascadeQuantity)); 
/* 296 */     if (this._childRestrictDelete != null) values.put("ChildRestrictDelete", DaoUtils.getXmlSafeFieldValue(-7, this._childRestrictDelete)); 
/* 297 */     if (this._childRestrictPrice != null) values.put("ChildRestrictPrice", DaoUtils.getXmlSafeFieldValue(-7, this._childRestrictPrice)); 
/* 298 */     if (this._childRestrictQuantity != null) values.put("ChildRestrictQuantity", DaoUtils.getXmlSafeFieldValue(-7, this._childRestrictQuantity)); 
/* 299 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 300 */     if (this._parentRestrictDelete != null) values.put("ParentRestrictDelete", DaoUtils.getXmlSafeFieldValue(-7, this._parentRestrictDelete)); 
/* 301 */     if (this._parentRestrictPrice != null) values.put("ParentRestrictPrice", DaoUtils.getXmlSafeFieldValue(-7, this._parentRestrictPrice)); 
/* 302 */     if (this._parentRestrictQuantity != null) values.put("ParentRestrictQuantity", DaoUtils.getXmlSafeFieldValue(-7, this._parentRestrictQuantity)); 
/* 303 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 304 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 309 */     super.setValues(argValues);
/* 310 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 312 */       String fieldName = field.getKey();
/* 313 */       String fieldValue = field.getValue();
/* 314 */       switch (fieldName) {
/*     */         
/*     */         case "LineItemAssociationTypeCode":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 319 */             setLineItemAssociationTypeCode((String)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setLineItemAssociationTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 328 */             setOrganizationId((Long)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 337 */             setCreateDate((Date)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 346 */             setCreateUserId((String)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 355 */             setUpdateDate((Date)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setUpdateUserId((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CascadeDelete":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 373 */             setCascadeDelete((Boolean)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setCascadeDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CascadeQuantity":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 382 */             setCascadeQuantity((Boolean)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setCascadeQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildRestrictDelete":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 391 */             setChildRestrictDelete((Boolean)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setChildRestrictDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildRestrictPrice":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 400 */             setChildRestrictPrice((Boolean)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setChildRestrictPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ChildRestrictQuantity":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 409 */             setChildRestrictQuantity((Boolean)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setChildRestrictQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setDescription((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentRestrictDelete":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 427 */             setParentRestrictDelete((Boolean)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setParentRestrictDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentRestrictPrice":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 436 */             setParentRestrictPrice((Boolean)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setParentRestrictPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentRestrictQuantity":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 445 */             setParentRestrictQuantity((Boolean)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setParentRestrictQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 454 */             setSortOrder((Integer)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\LineItemAssociationTypeCodeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */