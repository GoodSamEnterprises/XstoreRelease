/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ReportLookupId;
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
/*     */ public class ReportLookupDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 562595822L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ReportLookupDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _ownerId;
/*     */   private String _ownerType;
/*     */   private String _reportId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _reportUrl;
/*     */   private String _description;
/*     */   private String _recordType;
/*     */   private DtvDate _recordCreationDate;
/*     */   private String _recordLevel;
/*     */   private String _parentReportId;
/*  41 */   private Boolean _delete = Boolean.FALSE;
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
/*     */   public String getOwnerId() {
/*  54 */     return this._ownerId;
/*     */   }
/*     */   
/*     */   public void setOwnerId(String argOwnerId) {
/*  58 */     if (changed(argOwnerId, this._ownerId, "ownerId")) {
/*  59 */       this._ownerId = (argOwnerId != null && MANAGE_CASE) ? argOwnerId.toUpperCase() : argOwnerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOwnerType() {
/*  64 */     return this._ownerType;
/*     */   }
/*     */   
/*     */   public void setOwnerType(String argOwnerType) {
/*  68 */     if (changed(argOwnerType, this._ownerType, "ownerType")) {
/*  69 */       this._ownerType = (argOwnerType != null && MANAGE_CASE) ? argOwnerType.toUpperCase() : argOwnerType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReportId() {
/*  74 */     return this._reportId;
/*     */   }
/*     */   
/*     */   public void setReportId(String argReportId) {
/*  78 */     if (changed(argReportId, this._reportId, "reportId")) {
/*  79 */       this._reportId = (argReportId != null && MANAGE_CASE) ? argReportId.toUpperCase() : argReportId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  84 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  88 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  89 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  95 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  99 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 100 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 105 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 109 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 110 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 116 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 120 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 121 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 126 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 130 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 131 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 136 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 140 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 141 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReportUrl() {
/* 146 */     return this._reportUrl;
/*     */   }
/*     */   
/*     */   public void setReportUrl(String argReportUrl) {
/* 150 */     if (changed(argReportUrl, this._reportUrl, "reportUrl")) {
/* 151 */       this._reportUrl = argReportUrl;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 156 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 160 */     if (changed(argDescription, this._description, "description")) {
/* 161 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordType() {
/* 166 */     return this._recordType;
/*     */   }
/*     */   
/*     */   public void setRecordType(String argRecordType) {
/* 170 */     if (changed(argRecordType, this._recordType, "recordType")) {
/* 171 */       this._recordType = argRecordType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getRecordCreationDate() {
/* 176 */     return (Date)this._recordCreationDate;
/*     */   }
/*     */   
/*     */   public void setRecordCreationDate(Date argRecordCreationDate) {
/* 180 */     if (changed(argRecordCreationDate, this._recordCreationDate, "recordCreationDate")) {
/* 181 */       this._recordCreationDate = (argRecordCreationDate == null || argRecordCreationDate instanceof DtvDate) ? (DtvDate)argRecordCreationDate : new DtvDate(argRecordCreationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordLevel() {
/* 187 */     return this._recordLevel;
/*     */   }
/*     */   
/*     */   public void setRecordLevel(String argRecordLevel) {
/* 191 */     if (changed(argRecordLevel, this._recordLevel, "recordLevel")) {
/* 192 */       this._recordLevel = argRecordLevel;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getParentReportId() {
/* 197 */     return this._parentReportId;
/*     */   }
/*     */   
/*     */   public void setParentReportId(String argParentReportId) {
/* 201 */     if (changed(argParentReportId, this._parentReportId, "parentReportId")) {
/* 202 */       this._parentReportId = argParentReportId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDelete() {
/* 207 */     return this._delete;
/*     */   }
/*     */   
/*     */   public void setDelete(Boolean argDelete) {
/* 211 */     if (changed(argDelete, this._delete, "delete")) {
/* 212 */       this._delete = argDelete;
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
/* 224 */     if (getOwnerId() != null) {
/* 225 */       buf.append("ownerId").append("=").append(getOwnerId()).append(" ");
/*     */     }
/* 227 */     if (getOwnerType() != null) {
/* 228 */       buf.append("ownerType").append("=").append(getOwnerType()).append(" ");
/*     */     }
/* 230 */     if (getReportId() != null) {
/* 231 */       buf.append("reportId").append("=").append(getReportId()).append(" ");
/*     */     }
/* 233 */     if (getCreateDate() != null) {
/* 234 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 236 */     if (getCreateUserId() != null) {
/* 237 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 239 */     if (getUpdateDate() != null) {
/* 240 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 242 */     if (getUpdateUserId() != null) {
/* 243 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 245 */     if (getOrgCode() != null) {
/* 246 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 248 */     if (getOrgValue() != null) {
/* 249 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 251 */     if (getReportUrl() != null) {
/* 252 */       buf.append("reportUrl").append("=").append(getReportUrl()).append(" ");
/*     */     }
/* 254 */     if (getDescription() != null) {
/* 255 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 257 */     if (getRecordType() != null) {
/* 258 */       buf.append("recordType").append("=").append(getRecordType()).append(" ");
/*     */     }
/* 260 */     if (getRecordCreationDate() != null) {
/* 261 */       buf.append("recordCreationDate").append("=").append(getRecordCreationDate()).append(" ");
/*     */     }
/* 263 */     if (getRecordLevel() != null) {
/* 264 */       buf.append("recordLevel").append("=").append(getRecordLevel()).append(" ");
/*     */     }
/* 266 */     if (getParentReportId() != null) {
/* 267 */       buf.append("parentReportId").append("=").append(getParentReportId()).append(" ");
/*     */     }
/* 269 */     if (getDelete() != null && getDelete().booleanValue()) {
/* 270 */       buf.append("delete").append("=").append(getDelete()).append(" ");
/*     */     }
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 277 */     ReportLookupId id = new ReportLookupId();
/* 278 */     id.setOrganizationId(getOrganizationId());
/* 279 */     id.setOwnerId(getOwnerId());
/* 280 */     id.setOwnerType(getOwnerType());
/* 281 */     id.setReportId(getReportId());
/* 282 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 286 */     setOrganizationId(((ReportLookupId)argObjectId).getOrganizationId());
/* 287 */     setOwnerId(((ReportLookupId)argObjectId).getOwnerId());
/* 288 */     setOwnerType(((ReportLookupId)argObjectId).getOwnerType());
/* 289 */     setReportId(((ReportLookupId)argObjectId).getReportId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 293 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 297 */     StringBuilder buf = new StringBuilder(850);
/* 298 */     buf.append("<").append("dao").append(" name=\"ReportLookup\" cmd=\"" + getObjectStateString() + "\">");
/* 299 */     getFieldsAsXml(buf);
/* 300 */     buf.append("</").append("dao").append(">");
/*     */     
/* 302 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 306 */     Map<String, String> values = super.getValues();
/* 307 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 308 */     if (this._ownerId != null) values.put("OwnerId", DaoUtils.getXmlSafeFieldValue(12, this._ownerId)); 
/* 309 */     if (this._ownerType != null) values.put("OwnerType", DaoUtils.getXmlSafeFieldValue(12, this._ownerType)); 
/* 310 */     if (this._reportId != null) values.put("ReportId", DaoUtils.getXmlSafeFieldValue(12, this._reportId)); 
/* 311 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 312 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 313 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 314 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 315 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 316 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 317 */     if (this._reportUrl != null) values.put("ReportUrl", DaoUtils.getXmlSafeFieldValue(12, this._reportUrl)); 
/* 318 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 319 */     if (this._recordType != null) values.put("RecordType", DaoUtils.getXmlSafeFieldValue(12, this._recordType)); 
/* 320 */     if (this._recordCreationDate != null) values.put("RecordCreationDate", DaoUtils.getXmlSafeFieldValue(91, this._recordCreationDate)); 
/* 321 */     if (this._recordLevel != null) values.put("RecordLevel", DaoUtils.getXmlSafeFieldValue(12, this._recordLevel)); 
/* 322 */     if (this._parentReportId != null) values.put("ParentReportId", DaoUtils.getXmlSafeFieldValue(12, this._parentReportId)); 
/* 323 */     if (this._delete != null) values.put("Delete", DaoUtils.getXmlSafeFieldValue(-7, this._delete)); 
/* 324 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 329 */     super.setValues(argValues);
/* 330 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 332 */       String fieldName = field.getKey();
/* 333 */       String fieldValue = field.getValue();
/* 334 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 339 */             setOrganizationId((Long)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OwnerId":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 348 */             setOwnerId((String)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setOwnerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OwnerType":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 357 */             setOwnerType((String)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setOwnerType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportId":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 366 */             setReportId((String)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setReportId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 375 */             setCreateDate((Date)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setCreateUserId((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 393 */             setUpdateDate((Date)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 402 */             setUpdateUserId((String)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 411 */             setOrgCode((String)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 420 */             setOrgValue((String)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportUrl":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 429 */             setReportUrl((String)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setReportUrl() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 438 */             setDescription((String)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordType":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 447 */             setRecordType((String)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setRecordType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordCreationDate":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 456 */             setRecordCreationDate((Date)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setRecordCreationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordLevel":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 465 */             setRecordLevel((String)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setRecordLevel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ParentReportId":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 474 */             setParentReportId((String)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setParentReportId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Delete":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 483 */             setDelete((Boolean)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReportLookupDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */