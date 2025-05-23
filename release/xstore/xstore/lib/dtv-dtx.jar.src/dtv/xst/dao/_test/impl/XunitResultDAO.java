/*     */ package dtv.xst.dao._test.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao._test.XunitResultId;
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
/*     */ public class XunitResultDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1359557351L;
/*  23 */   private static final Logger _logger = Logger.getLogger(XunitResultDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _ipAddress;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _workstationId;
/*     */   private String _xstoreVersion;
/*     */   private String _status;
/*     */   private DtvDate _beginDatetimestamp;
/*     */   private DtvDate _endDatetimestamp;
/*     */   private Long _totalCount;
/*     */   private Long _completedCount;
/*     */   private Long _failedCount;
/*     */   
/*     */   public Long getOrganizationId() {
/*  45 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  49 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  50 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getHostname() {
/*  55 */     return this._hostname;
/*     */   }
/*     */   
/*     */   public void setHostname(String argHostname) {
/*  59 */     if (changed(argHostname, this._hostname, "hostname")) {
/*  60 */       this._hostname = (argHostname != null && MANAGE_CASE) ? argHostname.toUpperCase() : argHostname;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getResultTimestamp() {
/*  65 */     return this._resultTimestamp;
/*     */   }
/*     */   
/*     */   public void setResultTimestamp(Long argResultTimestamp) {
/*  69 */     if (changed(argResultTimestamp, this._resultTimestamp, "resultTimestamp")) {
/*  70 */       this._resultTimestamp = argResultTimestamp;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  75 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  79 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  80 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  86 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  90 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  91 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  96 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 100 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 101 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 107 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 111 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 112 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIpAddress() {
/* 117 */     return this._ipAddress;
/*     */   }
/*     */   
/*     */   public void setIpAddress(String argIpAddress) {
/* 121 */     if (changed(argIpAddress, this._ipAddress, "ipAddress")) {
/* 122 */       this._ipAddress = argIpAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 127 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 131 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 132 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 137 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 141 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 142 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getWorkstationId() {
/* 148 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 152 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 153 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getXstoreVersion() {
/* 158 */     return this._xstoreVersion;
/*     */   }
/*     */   
/*     */   public void setXstoreVersion(String argXstoreVersion) {
/* 162 */     if (changed(argXstoreVersion, this._xstoreVersion, "xstoreVersion")) {
/* 163 */       this._xstoreVersion = argXstoreVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 168 */     return this._status;
/*     */   }
/*     */   
/*     */   public void setStatus(String argStatus) {
/* 172 */     if (changed(argStatus, this._status, "status")) {
/* 173 */       this._status = argStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBeginDatetimestamp() {
/* 178 */     return (Date)this._beginDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/* 182 */     if (changed(argBeginDatetimestamp, this._beginDatetimestamp, "beginDatetimestamp")) {
/* 183 */       this._beginDatetimestamp = (argBeginDatetimestamp == null || argBeginDatetimestamp instanceof DtvDate) ? (DtvDate)argBeginDatetimestamp : new DtvDate(argBeginDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDatetimestamp() {
/* 189 */     return (Date)this._endDatetimestamp;
/*     */   }
/*     */   
/*     */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/* 193 */     if (changed(argEndDatetimestamp, this._endDatetimestamp, "endDatetimestamp")) {
/* 194 */       this._endDatetimestamp = (argEndDatetimestamp == null || argEndDatetimestamp instanceof DtvDate) ? (DtvDate)argEndDatetimestamp : new DtvDate(argEndDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTotalCount() {
/* 200 */     return this._totalCount;
/*     */   }
/*     */   
/*     */   public void setTotalCount(Long argTotalCount) {
/* 204 */     if (changed(argTotalCount, this._totalCount, "totalCount")) {
/* 205 */       this._totalCount = argTotalCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCompletedCount() {
/* 210 */     return this._completedCount;
/*     */   }
/*     */   
/*     */   public void setCompletedCount(Long argCompletedCount) {
/* 214 */     if (changed(argCompletedCount, this._completedCount, "completedCount")) {
/* 215 */       this._completedCount = argCompletedCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getFailedCount() {
/* 220 */     return this._failedCount;
/*     */   }
/*     */   
/*     */   public void setFailedCount(Long argFailedCount) {
/* 224 */     if (changed(argFailedCount, this._failedCount, "failedCount")) {
/* 225 */       this._failedCount = argFailedCount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 232 */     StringBuilder buf = new StringBuilder(512);
/* 233 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 234 */     if (getOrganizationId() != null) {
/* 235 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 237 */     if (getHostname() != null) {
/* 238 */       buf.append("hostname").append("=").append(getHostname()).append(" ");
/*     */     }
/* 240 */     if (getResultTimestamp() != null) {
/* 241 */       buf.append("resultTimestamp").append("=").append(getResultTimestamp()).append(" ");
/*     */     }
/* 243 */     if (getCreateDate() != null) {
/* 244 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 246 */     if (getCreateUserId() != null) {
/* 247 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 249 */     if (getUpdateDate() != null) {
/* 250 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 252 */     if (getUpdateUserId() != null) {
/* 253 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 255 */     if (getIpAddress() != null) {
/* 256 */       buf.append("ipAddress").append("=").append(getIpAddress()).append(" ");
/*     */     }
/* 258 */     if (getRetailLocationId() != null) {
/* 259 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 261 */     if (getBusinessDate() != null) {
/* 262 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 264 */     if (getWorkstationId() != null) {
/* 265 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 267 */     if (getXstoreVersion() != null) {
/* 268 */       buf.append("xstoreVersion").append("=").append(getXstoreVersion()).append(" ");
/*     */     }
/* 270 */     if (getStatus() != null) {
/* 271 */       buf.append("status").append("=").append(getStatus()).append(" ");
/*     */     }
/* 273 */     if (getBeginDatetimestamp() != null) {
/* 274 */       buf.append("beginDatetimestamp").append("=").append(getBeginDatetimestamp()).append(" ");
/*     */     }
/* 276 */     if (getEndDatetimestamp() != null) {
/* 277 */       buf.append("endDatetimestamp").append("=").append(getEndDatetimestamp()).append(" ");
/*     */     }
/* 279 */     if (getTotalCount() != null) {
/* 280 */       buf.append("totalCount").append("=").append(getTotalCount()).append(" ");
/*     */     }
/* 282 */     if (getCompletedCount() != null) {
/* 283 */       buf.append("completedCount").append("=").append(getCompletedCount()).append(" ");
/*     */     }
/* 285 */     if (getFailedCount() != null) {
/* 286 */       buf.append("failedCount").append("=").append(getFailedCount()).append(" ");
/*     */     }
/*     */     
/* 289 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 293 */     XunitResultId id = new XunitResultId();
/* 294 */     id.setOrganizationId(getOrganizationId());
/* 295 */     id.setHostname(getHostname());
/* 296 */     id.setResultTimestamp(getResultTimestamp());
/* 297 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 301 */     setOrganizationId(((XunitResultId)argObjectId).getOrganizationId());
/* 302 */     setHostname(((XunitResultId)argObjectId).getHostname());
/* 303 */     setResultTimestamp(((XunitResultId)argObjectId).getResultTimestamp());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 307 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 311 */     StringBuilder buf = new StringBuilder(900);
/* 312 */     buf.append("<").append("dao").append(" name=\"XunitResult\" cmd=\"" + getObjectStateString() + "\">");
/* 313 */     getFieldsAsXml(buf);
/* 314 */     buf.append("</").append("dao").append(">");
/*     */     
/* 316 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 320 */     Map<String, String> values = super.getValues();
/* 321 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 322 */     if (this._hostname != null) values.put("Hostname", DaoUtils.getXmlSafeFieldValue(12, this._hostname)); 
/* 323 */     if (this._resultTimestamp != null) values.put("ResultTimestamp", DaoUtils.getXmlSafeFieldValue(-5, this._resultTimestamp)); 
/* 324 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 325 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 326 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 327 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 328 */     if (this._ipAddress != null) values.put("IpAddress", DaoUtils.getXmlSafeFieldValue(12, this._ipAddress)); 
/* 329 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 330 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 331 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 332 */     if (this._xstoreVersion != null) values.put("XstoreVersion", DaoUtils.getXmlSafeFieldValue(12, this._xstoreVersion)); 
/* 333 */     if (this._status != null) values.put("Status", DaoUtils.getXmlSafeFieldValue(12, this._status)); 
/* 334 */     if (this._beginDatetimestamp != null) values.put("BeginDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._beginDatetimestamp)); 
/* 335 */     if (this._endDatetimestamp != null) values.put("EndDatetimestamp", DaoUtils.getXmlSafeFieldValue(91, this._endDatetimestamp)); 
/* 336 */     if (this._totalCount != null) values.put("TotalCount", DaoUtils.getXmlSafeFieldValue(-5, this._totalCount)); 
/* 337 */     if (this._completedCount != null) values.put("CompletedCount", DaoUtils.getXmlSafeFieldValue(-5, this._completedCount)); 
/* 338 */     if (this._failedCount != null) values.put("FailedCount", DaoUtils.getXmlSafeFieldValue(-5, this._failedCount)); 
/* 339 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 344 */     super.setValues(argValues);
/* 345 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 347 */       String fieldName = field.getKey();
/* 348 */       String fieldValue = field.getValue();
/* 349 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 354 */             setOrganizationId((Long)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hostname":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setHostname((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setHostname() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ResultTimestamp":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 372 */             setResultTimestamp((Long)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setResultTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 381 */             setCreateDate((Date)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setCreateUserId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 399 */             setUpdateDate((Date)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setUpdateUserId((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IpAddress":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setIpAddress((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setIpAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 426 */             setRetailLocationId((Long)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 435 */             setBusinessDate((Date)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 444 */             setWorkstationId((Long)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "XstoreVersion":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 453 */             setXstoreVersion((String)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setXstoreVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Status":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 462 */             setStatus((String)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDatetimestamp":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 471 */             setBeginDatetimestamp((Date)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setBeginDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDatetimestamp":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 480 */             setEndDatetimestamp((Date)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setEndDatetimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TotalCount":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 489 */             setTotalCount((Long)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setTotalCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CompletedCount":
/*     */           try {
/* 497 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 498 */             setCompletedCount((Long)value);
/* 499 */           } catch (Exception ee) {
/* 500 */             throw new DtxException("An exception occurred while calling setCompletedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FailedCount":
/*     */           try {
/* 506 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 507 */             setFailedCount((Long)value);
/* 508 */           } catch (Exception ee) {
/* 509 */             throw new DtxException("An exception occurred while calling setFailedCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\impl\XunitResultDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */