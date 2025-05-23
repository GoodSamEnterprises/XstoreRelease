/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionId;
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
/*     */ public class DocumentDefinitionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1031194386L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentDefinitionDAO.class);
/*     */   
/*     */   private String _seriesId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _startIssueDate;
/*     */   private DtvDate _endIssueDate;
/*     */   private DtvDate _startRedeemDate;
/*     */   private DtvDate _endRedeemDate;
/*     */   private String _vendorId;
/*     */   private String _description;
/*     */   private String _receiptType;
/*     */   private String _segmentType;
/*     */   private String _textCodeValue;
/*     */   private String _fileName;
/*     */   
/*     */   public String getSeriesId() {
/*  46 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  50 */     if (changed(argSeriesId, this._seriesId, "seriesId")) {
/*  51 */       this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  56 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  60 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  61 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  66 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  70 */     if (changed(argDocumentType, this._documentType, "documentType")) {
/*  71 */       this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  76 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  80 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  81 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  87 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  91 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  92 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  97 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 101 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 102 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 108 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 112 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 113 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 118 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 122 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 123 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 128 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 132 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 133 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartIssueDate() {
/* 138 */     return (Date)this._startIssueDate;
/*     */   }
/*     */   
/*     */   public void setStartIssueDate(Date argStartIssueDate) {
/* 142 */     if (changed(argStartIssueDate, this._startIssueDate, "startIssueDate")) {
/* 143 */       this._startIssueDate = (argStartIssueDate == null || argStartIssueDate instanceof DtvDate) ? (DtvDate)argStartIssueDate : new DtvDate(argStartIssueDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndIssueDate() {
/* 149 */     return (Date)this._endIssueDate;
/*     */   }
/*     */   
/*     */   public void setEndIssueDate(Date argEndIssueDate) {
/* 153 */     if (changed(argEndIssueDate, this._endIssueDate, "endIssueDate")) {
/* 154 */       this._endIssueDate = (argEndIssueDate == null || argEndIssueDate instanceof DtvDate) ? (DtvDate)argEndIssueDate : new DtvDate(argEndIssueDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getStartRedeemDate() {
/* 160 */     return (Date)this._startRedeemDate;
/*     */   }
/*     */   
/*     */   public void setStartRedeemDate(Date argStartRedeemDate) {
/* 164 */     if (changed(argStartRedeemDate, this._startRedeemDate, "startRedeemDate")) {
/* 165 */       this._startRedeemDate = (argStartRedeemDate == null || argStartRedeemDate instanceof DtvDate) ? (DtvDate)argStartRedeemDate : new DtvDate(argStartRedeemDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndRedeemDate() {
/* 171 */     return (Date)this._endRedeemDate;
/*     */   }
/*     */   
/*     */   public void setEndRedeemDate(Date argEndRedeemDate) {
/* 175 */     if (changed(argEndRedeemDate, this._endRedeemDate, "endRedeemDate")) {
/* 176 */       this._endRedeemDate = (argEndRedeemDate == null || argEndRedeemDate instanceof DtvDate) ? (DtvDate)argEndRedeemDate : new DtvDate(argEndRedeemDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVendorId() {
/* 182 */     return this._vendorId;
/*     */   }
/*     */   
/*     */   public void setVendorId(String argVendorId) {
/* 186 */     if (changed(argVendorId, this._vendorId, "vendorId")) {
/* 187 */       this._vendorId = argVendorId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 192 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 196 */     if (changed(argDescription, this._description, "description")) {
/* 197 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReceiptType() {
/* 202 */     return this._receiptType;
/*     */   }
/*     */   
/*     */   public void setReceiptType(String argReceiptType) {
/* 206 */     if (changed(argReceiptType, this._receiptType, "receiptType")) {
/* 207 */       this._receiptType = argReceiptType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSegmentType() {
/* 212 */     return this._segmentType;
/*     */   }
/*     */   
/*     */   public void setSegmentType(String argSegmentType) {
/* 216 */     if (changed(argSegmentType, this._segmentType, "segmentType")) {
/* 217 */       this._segmentType = argSegmentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTextCodeValue() {
/* 222 */     return this._textCodeValue;
/*     */   }
/*     */   
/*     */   public void setTextCodeValue(String argTextCodeValue) {
/* 226 */     if (changed(argTextCodeValue, this._textCodeValue, "textCodeValue")) {
/* 227 */       this._textCodeValue = argTextCodeValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFileName() {
/* 232 */     return this._fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String argFileName) {
/* 236 */     if (changed(argFileName, this._fileName, "fileName")) {
/* 237 */       this._fileName = argFileName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 244 */     StringBuilder buf = new StringBuilder(512);
/* 245 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 246 */     if (getSeriesId() != null) {
/* 247 */       buf.append("seriesId").append("=").append(getSeriesId()).append(" ");
/*     */     }
/* 249 */     if (getOrganizationId() != null) {
/* 250 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 252 */     if (getDocumentType() != null) {
/* 253 */       buf.append("documentType").append("=").append(getDocumentType()).append(" ");
/*     */     }
/* 255 */     if (getCreateDate() != null) {
/* 256 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 258 */     if (getCreateUserId() != null) {
/* 259 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 261 */     if (getUpdateDate() != null) {
/* 262 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 264 */     if (getUpdateUserId() != null) {
/* 265 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 267 */     if (getOrgCode() != null) {
/* 268 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 270 */     if (getOrgValue() != null) {
/* 271 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 273 */     if (getStartIssueDate() != null) {
/* 274 */       buf.append("startIssueDate").append("=").append(getStartIssueDate()).append(" ");
/*     */     }
/* 276 */     if (getEndIssueDate() != null) {
/* 277 */       buf.append("endIssueDate").append("=").append(getEndIssueDate()).append(" ");
/*     */     }
/* 279 */     if (getStartRedeemDate() != null) {
/* 280 */       buf.append("startRedeemDate").append("=").append(getStartRedeemDate()).append(" ");
/*     */     }
/* 282 */     if (getEndRedeemDate() != null) {
/* 283 */       buf.append("endRedeemDate").append("=").append(getEndRedeemDate()).append(" ");
/*     */     }
/* 285 */     if (getVendorId() != null) {
/* 286 */       buf.append("vendorId").append("=").append(getVendorId()).append(" ");
/*     */     }
/* 288 */     if (getDescription() != null) {
/* 289 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 291 */     if (getReceiptType() != null) {
/* 292 */       buf.append("receiptType").append("=").append(getReceiptType()).append(" ");
/*     */     }
/* 294 */     if (getSegmentType() != null) {
/* 295 */       buf.append("segmentType").append("=").append(getSegmentType()).append(" ");
/*     */     }
/* 297 */     if (getTextCodeValue() != null) {
/* 298 */       buf.append("textCodeValue").append("=").append(getTextCodeValue()).append(" ");
/*     */     }
/* 300 */     if (getFileName() != null) {
/* 301 */       buf.append("fileName").append("=").append(getFileName()).append(" ");
/*     */     }
/*     */     
/* 304 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 308 */     DocumentDefinitionId id = new DocumentDefinitionId();
/* 309 */     id.setSeriesId(getSeriesId());
/* 310 */     id.setOrganizationId(getOrganizationId());
/* 311 */     id.setDocumentType(getDocumentType());
/* 312 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 316 */     setSeriesId(((DocumentDefinitionId)argObjectId).getSeriesId());
/* 317 */     setOrganizationId(((DocumentDefinitionId)argObjectId).getOrganizationId());
/* 318 */     setDocumentType(((DocumentDefinitionId)argObjectId).getDocumentType());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 322 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 326 */     StringBuilder buf = new StringBuilder(950);
/* 327 */     buf.append("<").append("dao").append(" name=\"DocumentDefinition\" cmd=\"" + getObjectStateString() + "\">");
/* 328 */     getFieldsAsXml(buf);
/* 329 */     buf.append("</").append("dao").append(">");
/*     */     
/* 331 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 335 */     Map<String, String> values = super.getValues();
/* 336 */     if (this._seriesId != null) values.put("SeriesId", DaoUtils.getXmlSafeFieldValue(12, this._seriesId)); 
/* 337 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 338 */     if (this._documentType != null) values.put("DocumentType", DaoUtils.getXmlSafeFieldValue(12, this._documentType)); 
/* 339 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 340 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 341 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 342 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 343 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 344 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 345 */     if (this._startIssueDate != null) values.put("StartIssueDate", DaoUtils.getXmlSafeFieldValue(91, this._startIssueDate)); 
/* 346 */     if (this._endIssueDate != null) values.put("EndIssueDate", DaoUtils.getXmlSafeFieldValue(91, this._endIssueDate)); 
/* 347 */     if (this._startRedeemDate != null) values.put("StartRedeemDate", DaoUtils.getXmlSafeFieldValue(91, this._startRedeemDate)); 
/* 348 */     if (this._endRedeemDate != null) values.put("EndRedeemDate", DaoUtils.getXmlSafeFieldValue(91, this._endRedeemDate)); 
/* 349 */     if (this._vendorId != null) values.put("VendorId", DaoUtils.getXmlSafeFieldValue(12, this._vendorId)); 
/* 350 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 351 */     if (this._receiptType != null) values.put("ReceiptType", DaoUtils.getXmlSafeFieldValue(12, this._receiptType)); 
/* 352 */     if (this._segmentType != null) values.put("SegmentType", DaoUtils.getXmlSafeFieldValue(12, this._segmentType)); 
/* 353 */     if (this._textCodeValue != null) values.put("TextCodeValue", DaoUtils.getXmlSafeFieldValue(12, this._textCodeValue)); 
/* 354 */     if (this._fileName != null) values.put("FileName", DaoUtils.getXmlSafeFieldValue(12, this._fileName)); 
/* 355 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 360 */     super.setValues(argValues);
/* 361 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 363 */       String fieldName = field.getKey();
/* 364 */       String fieldValue = field.getValue();
/* 365 */       switch (fieldName) {
/*     */         
/*     */         case "SeriesId":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 370 */             setSeriesId((String)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setSeriesId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 379 */             setOrganizationId((Long)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentType":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setDocumentType((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setDocumentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 397 */             setCreateDate((Date)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setCreateUserId((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 415 */             setUpdateDate((Date)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setUpdateUserId((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setOrgCode((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setOrgValue((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartIssueDate":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 451 */             setStartIssueDate((Date)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setStartIssueDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndIssueDate":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 460 */             setEndIssueDate((Date)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setEndIssueDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartRedeemDate":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 469 */             setStartRedeemDate((Date)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setStartRedeemDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndRedeemDate":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 478 */             setEndRedeemDate((Date)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setEndRedeemDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VendorId":
/*     */           try {
/* 486 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 487 */             setVendorId((String)value);
/* 488 */           } catch (Exception ee) {
/* 489 */             throw new DtxException("An exception occurred while calling setVendorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 495 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 496 */             setDescription((String)value);
/* 497 */           } catch (Exception ee) {
/* 498 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReceiptType":
/*     */           try {
/* 504 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 505 */             setReceiptType((String)value);
/* 506 */           } catch (Exception ee) {
/* 507 */             throw new DtxException("An exception occurred while calling setReceiptType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SegmentType":
/*     */           try {
/* 513 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 514 */             setSegmentType((String)value);
/* 515 */           } catch (Exception ee) {
/* 516 */             throw new DtxException("An exception occurred while calling setSegmentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TextCodeValue":
/*     */           try {
/* 522 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 523 */             setTextCodeValue((String)value);
/* 524 */           } catch (Exception ee) {
/* 525 */             throw new DtxException("An exception occurred while calling setTextCodeValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FileName":
/*     */           try {
/* 531 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 532 */             setFileName((String)value);
/* 533 */           } catch (Exception ee) {
/* 534 */             throw new DtxException("An exception occurred while calling setFileName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */