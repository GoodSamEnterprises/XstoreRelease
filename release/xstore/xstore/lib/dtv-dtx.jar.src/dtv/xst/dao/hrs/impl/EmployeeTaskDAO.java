/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeTaskId;
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
/*     */ public class EmployeeTaskDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1564025485L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeeTaskDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _taskId;
/*     */   private DtvDate _startDate;
/*     */   private DtvDate _endDate;
/*     */   private DtvDate _completeDate;
/*     */   private String _typeCode;
/*     */   private String _visibility;
/*     */   private String _assignmentId;
/*  34 */   private Boolean _storeCreated = Boolean.FALSE;
/*     */   private String _title;
/*     */   private String _description;
/*     */   private String _priority;
/*     */   private String _statusCode;
/*  39 */   private Boolean _void = Boolean.FALSE;
/*     */   private Long _partyId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
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
/*     */   public Long getRetailLocationId() {
/*  57 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  61 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  62 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTaskId() {
/*  67 */     return this._taskId;
/*     */   }
/*     */   
/*     */   public void setTaskId(Long argTaskId) {
/*  71 */     if (changed(argTaskId, this._taskId, "taskId")) {
/*  72 */       this._taskId = argTaskId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartDate() {
/*  77 */     return (Date)this._startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(Date argStartDate) {
/*  81 */     if (changed(argStartDate, this._startDate, "startDate")) {
/*  82 */       this._startDate = (argStartDate == null || argStartDate instanceof DtvDate) ? (DtvDate)argStartDate : new DtvDate(argStartDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/*  88 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/*  92 */     if (changed(argEndDate, this._endDate, "endDate")) {
/*  93 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCompleteDate() {
/*  99 */     return (Date)this._completeDate;
/*     */   }
/*     */   
/*     */   public void setCompleteDate(Date argCompleteDate) {
/* 103 */     if (changed(argCompleteDate, this._completeDate, "completeDate")) {
/* 104 */       this._completeDate = (argCompleteDate == null || argCompleteDate instanceof DtvDate) ? (DtvDate)argCompleteDate : new DtvDate(argCompleteDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTypeCode() {
/* 110 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 114 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 115 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVisibility() {
/* 120 */     return this._visibility;
/*     */   }
/*     */   
/*     */   public void setVisibility(String argVisibility) {
/* 124 */     if (changed(argVisibility, this._visibility, "visibility")) {
/* 125 */       this._visibility = argVisibility;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAssignmentId() {
/* 130 */     return this._assignmentId;
/*     */   }
/*     */   
/*     */   public void setAssignmentId(String argAssignmentId) {
/* 134 */     if (changed(argAssignmentId, this._assignmentId, "assignmentId")) {
/* 135 */       this._assignmentId = argAssignmentId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getStoreCreated() {
/* 140 */     return this._storeCreated;
/*     */   }
/*     */   
/*     */   public void setStoreCreated(Boolean argStoreCreated) {
/* 144 */     if (changed(argStoreCreated, this._storeCreated, "storeCreated")) {
/* 145 */       this._storeCreated = argStoreCreated;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 150 */     return this._title;
/*     */   }
/*     */   
/*     */   public void setTitle(String argTitle) {
/* 154 */     if (changed(argTitle, this._title, "title")) {
/* 155 */       this._title = argTitle;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 160 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 164 */     if (changed(argDescription, this._description, "description")) {
/* 165 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriority() {
/* 170 */     return this._priority;
/*     */   }
/*     */   
/*     */   public void setPriority(String argPriority) {
/* 174 */     if (changed(argPriority, this._priority, "priority")) {
/* 175 */       this._priority = argPriority;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatusCode() {
/* 180 */     return this._statusCode;
/*     */   }
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 184 */     if (changed(argStatusCode, this._statusCode, "statusCode")) {
/* 185 */       this._statusCode = argStatusCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 190 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 194 */     if (changed(argVoid, this._void, "void")) {
/* 195 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/* 200 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 204 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 205 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 210 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 214 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 215 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 221 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 225 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 226 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 231 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 235 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 236 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 242 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 246 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 247 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 254 */     StringBuilder buf = new StringBuilder(512);
/* 255 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 256 */     if (getOrganizationId() != null) {
/* 257 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 259 */     if (getRetailLocationId() != null) {
/* 260 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 262 */     if (getTaskId() != null) {
/* 263 */       buf.append("taskId").append("=").append(getTaskId()).append(" ");
/*     */     }
/* 265 */     if (getStartDate() != null) {
/* 266 */       buf.append("startDate").append("=").append(getStartDate()).append(" ");
/*     */     }
/* 268 */     if (getEndDate() != null) {
/* 269 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/* 271 */     if (getCompleteDate() != null) {
/* 272 */       buf.append("completeDate").append("=").append(getCompleteDate()).append(" ");
/*     */     }
/* 274 */     if (getTypeCode() != null) {
/* 275 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 277 */     if (getVisibility() != null) {
/* 278 */       buf.append("visibility").append("=").append(getVisibility()).append(" ");
/*     */     }
/* 280 */     if (getAssignmentId() != null) {
/* 281 */       buf.append("assignmentId").append("=").append(getAssignmentId()).append(" ");
/*     */     }
/* 283 */     if (getStoreCreated() != null && getStoreCreated().booleanValue()) {
/* 284 */       buf.append("storeCreated").append("=").append(getStoreCreated()).append(" ");
/*     */     }
/* 286 */     if (getTitle() != null) {
/* 287 */       buf.append("title").append("=").append(getTitle()).append(" ");
/*     */     }
/* 289 */     if (getDescription() != null) {
/* 290 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 292 */     if (getPriority() != null) {
/* 293 */       buf.append("priority").append("=").append(getPriority()).append(" ");
/*     */     }
/* 295 */     if (getStatusCode() != null) {
/* 296 */       buf.append("statusCode").append("=").append(getStatusCode()).append(" ");
/*     */     }
/* 298 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 299 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 301 */     if (getPartyId() != null) {
/* 302 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 304 */     if (getCreateDate() != null) {
/* 305 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 307 */     if (getCreateUserId() != null) {
/* 308 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 310 */     if (getUpdateDate() != null) {
/* 311 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 313 */     if (getUpdateUserId() != null) {
/* 314 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 317 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 321 */     EmployeeTaskId id = new EmployeeTaskId();
/* 322 */     id.setOrganizationId(getOrganizationId());
/* 323 */     id.setRetailLocationId(getRetailLocationId());
/* 324 */     id.setTaskId(getTaskId());
/* 325 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 329 */     setOrganizationId(((EmployeeTaskId)argObjectId).getOrganizationId());
/* 330 */     setRetailLocationId(((EmployeeTaskId)argObjectId).getRetailLocationId());
/* 331 */     setTaskId(((EmployeeTaskId)argObjectId).getTaskId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 335 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 339 */     StringBuilder buf = new StringBuilder(1000);
/* 340 */     buf.append("<").append("dao").append(" name=\"EmployeeTask\" cmd=\"" + getObjectStateString() + "\">");
/* 341 */     getFieldsAsXml(buf);
/* 342 */     buf.append("</").append("dao").append(">");
/*     */     
/* 344 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 348 */     Map<String, String> values = super.getValues();
/* 349 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 350 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 351 */     if (this._taskId != null) values.put("TaskId", DaoUtils.getXmlSafeFieldValue(-5, this._taskId)); 
/* 352 */     if (this._startDate != null) values.put("StartDate", DaoUtils.getXmlSafeFieldValue(91, this._startDate)); 
/* 353 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 354 */     if (this._completeDate != null) values.put("CompleteDate", DaoUtils.getXmlSafeFieldValue(91, this._completeDate)); 
/* 355 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 356 */     if (this._visibility != null) values.put("Visibility", DaoUtils.getXmlSafeFieldValue(12, this._visibility)); 
/* 357 */     if (this._assignmentId != null) values.put("AssignmentId", DaoUtils.getXmlSafeFieldValue(12, this._assignmentId)); 
/* 358 */     if (this._storeCreated != null) values.put("StoreCreated", DaoUtils.getXmlSafeFieldValue(-7, this._storeCreated)); 
/* 359 */     if (this._title != null) values.put("Title", DaoUtils.getXmlSafeFieldValue(12, this._title)); 
/* 360 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 361 */     if (this._priority != null) values.put("Priority", DaoUtils.getXmlSafeFieldValue(12, this._priority)); 
/* 362 */     if (this._statusCode != null) values.put("StatusCode", DaoUtils.getXmlSafeFieldValue(12, this._statusCode)); 
/* 363 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 364 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 365 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 366 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 367 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 368 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 369 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 374 */     super.setValues(argValues);
/* 375 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 377 */       String fieldName = field.getKey();
/* 378 */       String fieldValue = field.getValue();
/* 379 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 384 */             setOrganizationId((Long)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 393 */             setRetailLocationId((Long)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaskId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 402 */             setTaskId((Long)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setTaskId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartDate":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 411 */             setStartDate((Date)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setStartDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 420 */             setEndDate((Date)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CompleteDate":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 429 */             setCompleteDate((Date)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setCompleteDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 437 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 438 */             setTypeCode((String)value);
/* 439 */           } catch (Exception ee) {
/* 440 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Visibility":
/*     */           try {
/* 446 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 447 */             setVisibility((String)value);
/* 448 */           } catch (Exception ee) {
/* 449 */             throw new DtxException("An exception occurred while calling setVisibility() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AssignmentId":
/*     */           try {
/* 455 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 456 */             setAssignmentId((String)value);
/* 457 */           } catch (Exception ee) {
/* 458 */             throw new DtxException("An exception occurred while calling setAssignmentId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StoreCreated":
/*     */           try {
/* 464 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 465 */             setStoreCreated((Boolean)value);
/* 466 */           } catch (Exception ee) {
/* 467 */             throw new DtxException("An exception occurred while calling setStoreCreated() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Title":
/*     */           try {
/* 473 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 474 */             setTitle((String)value);
/* 475 */           } catch (Exception ee) {
/* 476 */             throw new DtxException("An exception occurred while calling setTitle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 482 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 483 */             setDescription((String)value);
/* 484 */           } catch (Exception ee) {
/* 485 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Priority":
/*     */           try {
/* 491 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 492 */             setPriority((String)value);
/* 493 */           } catch (Exception ee) {
/* 494 */             throw new DtxException("An exception occurred while calling setPriority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StatusCode":
/*     */           try {
/* 500 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 501 */             setStatusCode((String)value);
/* 502 */           } catch (Exception ee) {
/* 503 */             throw new DtxException("An exception occurred while calling setStatusCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 509 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 510 */             setVoid((Boolean)value);
/* 511 */           } catch (Exception ee) {
/* 512 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 518 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 519 */             setPartyId((Long)value);
/* 520 */           } catch (Exception ee) {
/* 521 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 527 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 528 */             setCreateDate((Date)value);
/* 529 */           } catch (Exception ee) {
/* 530 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 536 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 537 */             setCreateUserId((String)value);
/* 538 */           } catch (Exception ee) {
/* 539 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 545 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 546 */             setUpdateDate((Date)value);
/* 547 */           } catch (Exception ee) {
/* 548 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 554 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 555 */             setUpdateUserId((String)value);
/* 556 */           } catch (Exception ee) {
/* 557 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeTaskDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */