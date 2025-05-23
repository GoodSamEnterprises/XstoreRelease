/*     */ package dtv.xst.dao.doc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.doc.DocumentId;
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
/*     */ public class DocumentDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 926364987L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DocumentDAO.class);
/*     */   
/*     */   private String _documentId;
/*     */   private Long _organizationId;
/*     */   private String _documentType;
/*     */   private String _seriesId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _documentStatus;
/*     */   private DtvDate _issueDate;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private BigDecimal _amount;
/*     */   private BigDecimal _maxAmount;
/*     */   private BigDecimal _percent;
/*     */   
/*     */   public String getDocumentId() {
/*  44 */     return this._documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/*  48 */     if (changed(argDocumentId, this._documentId, "documentId")) {
/*  49 */       this._documentId = (argDocumentId != null && MANAGE_CASE) ? argDocumentId.toUpperCase() : argDocumentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  54 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  58 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  59 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  64 */     return this._documentType;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/*  68 */     if (changed(argDocumentType, this._documentType, "documentType")) {
/*  69 */       this._documentType = (argDocumentType != null && MANAGE_CASE) ? argDocumentType.toUpperCase() : argDocumentType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSeriesId() {
/*  74 */     return this._seriesId;
/*     */   }
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/*  78 */     if (changed(argSeriesId, this._seriesId, "seriesId")) {
/*  79 */       this._seriesId = (argSeriesId != null && MANAGE_CASE) ? argSeriesId.toUpperCase() : argSeriesId;
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
/*     */   public String getDocumentStatus() {
/* 146 */     return this._documentStatus;
/*     */   }
/*     */   
/*     */   public void setDocumentStatus(String argDocumentStatus) {
/* 150 */     if (changed(argDocumentStatus, this._documentStatus, "documentStatus")) {
/* 151 */       this._documentStatus = argDocumentStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getIssueDate() {
/* 156 */     return (Date)this._issueDate;
/*     */   }
/*     */   
/*     */   public void setIssueDate(Date argIssueDate) {
/* 160 */     if (changed(argIssueDate, this._issueDate, "issueDate")) {
/* 161 */       this._issueDate = (argIssueDate == null || argIssueDate instanceof DtvDate) ? (DtvDate)argIssueDate : new DtvDate(argIssueDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 167 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 171 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 172 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 178 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 182 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 183 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 189 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 193 */     if (changed(argAmount, this._amount, "amount")) {
/* 194 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxAmount() {
/* 199 */     return this._maxAmount;
/*     */   }
/*     */   
/*     */   public void setMaxAmount(BigDecimal argMaxAmount) {
/* 203 */     if (changed(argMaxAmount, this._maxAmount, "maxAmount")) {
/* 204 */       this._maxAmount = argMaxAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPercent() {
/* 209 */     return this._percent;
/*     */   }
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 213 */     if (changed(argPercent, this._percent, "percent")) {
/* 214 */       this._percent = argPercent;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 221 */     StringBuilder buf = new StringBuilder(512);
/* 222 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 223 */     if (getDocumentId() != null) {
/* 224 */       buf.append("documentId").append("=").append(getDocumentId()).append(" ");
/*     */     }
/* 226 */     if (getOrganizationId() != null) {
/* 227 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 229 */     if (getDocumentType() != null) {
/* 230 */       buf.append("documentType").append("=").append(getDocumentType()).append(" ");
/*     */     }
/* 232 */     if (getSeriesId() != null) {
/* 233 */       buf.append("seriesId").append("=").append(getSeriesId()).append(" ");
/*     */     }
/* 235 */     if (getCreateDate() != null) {
/* 236 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 238 */     if (getCreateUserId() != null) {
/* 239 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 241 */     if (getUpdateDate() != null) {
/* 242 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 244 */     if (getUpdateUserId() != null) {
/* 245 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 247 */     if (getOrgCode() != null) {
/* 248 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 250 */     if (getOrgValue() != null) {
/* 251 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 253 */     if (getDocumentStatus() != null) {
/* 254 */       buf.append("documentStatus").append("=").append(getDocumentStatus()).append(" ");
/*     */     }
/* 256 */     if (getIssueDate() != null) {
/* 257 */       buf.append("issueDate").append("=").append(getIssueDate()).append(" ");
/*     */     }
/* 259 */     if (getEffectiveDate() != null) {
/* 260 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 262 */     if (getExpirationDate() != null) {
/* 263 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 265 */     if (getAmount() != null) {
/* 266 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 268 */     if (getMaxAmount() != null) {
/* 269 */       buf.append("maxAmount").append("=").append(getMaxAmount()).append(" ");
/*     */     }
/* 271 */     if (getPercent() != null) {
/* 272 */       buf.append("percent").append("=").append(getPercent()).append(" ");
/*     */     }
/*     */     
/* 275 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 279 */     DocumentId id = new DocumentId();
/* 280 */     id.setDocumentId(getDocumentId());
/* 281 */     id.setOrganizationId(getOrganizationId());
/* 282 */     id.setDocumentType(getDocumentType());
/* 283 */     id.setSeriesId(getSeriesId());
/* 284 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 288 */     setDocumentId(((DocumentId)argObjectId).getDocumentId());
/* 289 */     setOrganizationId(((DocumentId)argObjectId).getOrganizationId());
/* 290 */     setDocumentType(((DocumentId)argObjectId).getDocumentType());
/* 291 */     setSeriesId(((DocumentId)argObjectId).getSeriesId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 295 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 299 */     StringBuilder buf = new StringBuilder(850);
/* 300 */     buf.append("<").append("dao").append(" name=\"Document\" cmd=\"" + getObjectStateString() + "\">");
/* 301 */     getFieldsAsXml(buf);
/* 302 */     buf.append("</").append("dao").append(">");
/*     */     
/* 304 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 308 */     Map<String, String> values = super.getValues();
/* 309 */     if (this._documentId != null) values.put("DocumentId", DaoUtils.getXmlSafeFieldValue(12, this._documentId)); 
/* 310 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 311 */     if (this._documentType != null) values.put("DocumentType", DaoUtils.getXmlSafeFieldValue(12, this._documentType)); 
/* 312 */     if (this._seriesId != null) values.put("SeriesId", DaoUtils.getXmlSafeFieldValue(12, this._seriesId)); 
/* 313 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 314 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 315 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 316 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 317 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 318 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 319 */     if (this._documentStatus != null) values.put("DocumentStatus", DaoUtils.getXmlSafeFieldValue(12, this._documentStatus)); 
/* 320 */     if (this._issueDate != null) values.put("IssueDate", DaoUtils.getXmlSafeFieldValue(91, this._issueDate)); 
/* 321 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 322 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 323 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 324 */     if (this._maxAmount != null) values.put("MaxAmount", DaoUtils.getXmlSafeFieldValue(3, this._maxAmount)); 
/* 325 */     if (this._percent != null) values.put("Percent", DaoUtils.getXmlSafeFieldValue(3, this._percent)); 
/* 326 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 331 */     super.setValues(argValues);
/* 332 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 334 */       String fieldName = field.getKey();
/* 335 */       String fieldValue = field.getValue();
/* 336 */       switch (fieldName) {
/*     */         
/*     */         case "DocumentId":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setDocumentId((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setDocumentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 350 */             setOrganizationId((Long)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentType":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setDocumentType((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setDocumentType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SeriesId":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 368 */             setSeriesId((String)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setSeriesId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 377 */             setCreateDate((Date)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 386 */             setCreateUserId((String)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 395 */             setUpdateDate((Date)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 404 */             setUpdateUserId((String)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 413 */             setOrgCode((String)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 422 */             setOrgValue((String)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DocumentStatus":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 431 */             setDocumentStatus((String)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setDocumentStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IssueDate":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 440 */             setIssueDate((Date)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setIssueDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 449 */             setEffectiveDate((Date)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 458 */             setExpirationDate((Date)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 466 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 467 */             setAmount((BigDecimal)value);
/* 468 */           } catch (Exception ee) {
/* 469 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxAmount":
/*     */           try {
/* 475 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 476 */             setMaxAmount((BigDecimal)value);
/* 477 */           } catch (Exception ee) {
/* 478 */             throw new DtxException("An exception occurred while calling setMaxAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Percent":
/*     */           try {
/* 484 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 485 */             setPercent((BigDecimal)value);
/* 486 */           } catch (Exception ee) {
/* 487 */             throw new DtxException("An exception occurred while calling setPercent() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */