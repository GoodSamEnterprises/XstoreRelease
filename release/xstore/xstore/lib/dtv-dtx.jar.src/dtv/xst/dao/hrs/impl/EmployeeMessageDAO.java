/*     */ package dtv.xst.dao.hrs.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.hrs.EmployeeMessageId;
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
/*     */ public class EmployeeMessageDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 414263641L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeeMessageDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _messageId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _startDate;
/*     */   private DtvDate _endDate;
/*     */   private String _priority;
/*  32 */   private Boolean _storeCreated = Boolean.FALSE;
/*  33 */   private Boolean _workstationSpecific = Boolean.FALSE;
/*     */   private Integer _workstationId;
/*     */   private String _description;
/*  36 */   private Boolean _void = Boolean.FALSE;
/*     */   private String _messageURL;
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
/*     */   public Long getMessageId() {
/*  54 */     return this._messageId;
/*     */   }
/*     */   
/*     */   public void setMessageId(Long argMessageId) {
/*  58 */     if (changed(argMessageId, this._messageId, "messageId")) {
/*  59 */       this._messageId = argMessageId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  64 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  68 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  69 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  74 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  78 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  79 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartDate() {
/*  84 */     return (Date)this._startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(Date argStartDate) {
/*  88 */     if (changed(argStartDate, this._startDate, "startDate")) {
/*  89 */       this._startDate = (argStartDate == null || argStartDate instanceof DtvDate) ? (DtvDate)argStartDate : new DtvDate(argStartDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/*  95 */     return (Date)this._endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argEndDate) {
/*  99 */     if (changed(argEndDate, this._endDate, "endDate")) {
/* 100 */       this._endDate = (argEndDate == null || argEndDate instanceof DtvDate) ? (DtvDate)argEndDate : new DtvDate(argEndDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPriority() {
/* 106 */     return this._priority;
/*     */   }
/*     */   
/*     */   public void setPriority(String argPriority) {
/* 110 */     if (changed(argPriority, this._priority, "priority")) {
/* 111 */       this._priority = argPriority;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getStoreCreated() {
/* 116 */     return this._storeCreated;
/*     */   }
/*     */   
/*     */   public void setStoreCreated(Boolean argStoreCreated) {
/* 120 */     if (changed(argStoreCreated, this._storeCreated, "storeCreated")) {
/* 121 */       this._storeCreated = argStoreCreated;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getWorkstationSpecific() {
/* 126 */     return this._workstationSpecific;
/*     */   }
/*     */   
/*     */   public void setWorkstationSpecific(Boolean argWorkstationSpecific) {
/* 130 */     if (changed(argWorkstationSpecific, this._workstationSpecific, "workstationSpecific")) {
/* 131 */       this._workstationSpecific = argWorkstationSpecific;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getWorkstationId() {
/* 136 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Integer argWorkstationId) {
/* 140 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 141 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 146 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 150 */     if (changed(argDescription, this._description, "description")) {
/* 151 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 156 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 160 */     if (changed(argVoid, this._void, "void")) {
/* 161 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMessageURL() {
/* 166 */     return this._messageURL;
/*     */   }
/*     */   
/*     */   public void setMessageURL(String argMessageURL) {
/* 170 */     if (changed(argMessageURL, this._messageURL, "messageURL")) {
/* 171 */       this._messageURL = argMessageURL;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 176 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 180 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 181 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 187 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 191 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 192 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 197 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 201 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 202 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 208 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 212 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 213 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     StringBuilder buf = new StringBuilder(512);
/* 221 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 222 */     if (getOrganizationId() != null) {
/* 223 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 225 */     if (getMessageId() != null) {
/* 226 */       buf.append("messageId").append("=").append(getMessageId()).append(" ");
/*     */     }
/* 228 */     if (getOrgCode() != null) {
/* 229 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 231 */     if (getOrgValue() != null) {
/* 232 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 234 */     if (getStartDate() != null) {
/* 235 */       buf.append("startDate").append("=").append(getStartDate()).append(" ");
/*     */     }
/* 237 */     if (getEndDate() != null) {
/* 238 */       buf.append("endDate").append("=").append(getEndDate()).append(" ");
/*     */     }
/* 240 */     if (getPriority() != null) {
/* 241 */       buf.append("priority").append("=").append(getPriority()).append(" ");
/*     */     }
/* 243 */     if (getStoreCreated() != null && getStoreCreated().booleanValue()) {
/* 244 */       buf.append("storeCreated").append("=").append(getStoreCreated()).append(" ");
/*     */     }
/* 246 */     if (getWorkstationSpecific() != null && getWorkstationSpecific().booleanValue()) {
/* 247 */       buf.append("workstationSpecific").append("=").append(getWorkstationSpecific()).append(" ");
/*     */     }
/* 249 */     if (getWorkstationId() != null) {
/* 250 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 252 */     if (getDescription() != null) {
/* 253 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 255 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 256 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 258 */     if (getMessageURL() != null) {
/* 259 */       buf.append("messageURL").append("=").append(getMessageURL()).append(" ");
/*     */     }
/* 261 */     if (getCreateDate() != null) {
/* 262 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 264 */     if (getCreateUserId() != null) {
/* 265 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 267 */     if (getUpdateDate() != null) {
/* 268 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 270 */     if (getUpdateUserId() != null) {
/* 271 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 274 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 278 */     EmployeeMessageId id = new EmployeeMessageId();
/* 279 */     id.setOrganizationId(getOrganizationId());
/* 280 */     id.setMessageId(getMessageId());
/* 281 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 285 */     setOrganizationId(((EmployeeMessageId)argObjectId).getOrganizationId());
/* 286 */     setMessageId(((EmployeeMessageId)argObjectId).getMessageId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 290 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 294 */     StringBuilder buf = new StringBuilder(850);
/* 295 */     buf.append("<").append("dao").append(" name=\"EmployeeMessage\" cmd=\"" + getObjectStateString() + "\">");
/* 296 */     getFieldsAsXml(buf);
/* 297 */     buf.append("</").append("dao").append(">");
/*     */     
/* 299 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 303 */     Map<String, String> values = super.getValues();
/* 304 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 305 */     if (this._messageId != null) values.put("MessageId", DaoUtils.getXmlSafeFieldValue(-5, this._messageId)); 
/* 306 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 307 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 308 */     if (this._startDate != null) values.put("StartDate", DaoUtils.getXmlSafeFieldValue(91, this._startDate)); 
/* 309 */     if (this._endDate != null) values.put("EndDate", DaoUtils.getXmlSafeFieldValue(91, this._endDate)); 
/* 310 */     if (this._priority != null) values.put("Priority", DaoUtils.getXmlSafeFieldValue(12, this._priority)); 
/* 311 */     if (this._storeCreated != null) values.put("StoreCreated", DaoUtils.getXmlSafeFieldValue(-7, this._storeCreated)); 
/* 312 */     if (this._workstationSpecific != null) values.put("WorkstationSpecific", DaoUtils.getXmlSafeFieldValue(-7, this._workstationSpecific)); 
/* 313 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(4, this._workstationId)); 
/* 314 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 315 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 316 */     if (this._messageURL != null) values.put("MessageURL", DaoUtils.getXmlSafeFieldValue(12, this._messageURL)); 
/* 317 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 318 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 319 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 320 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 321 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 326 */     super.setValues(argValues);
/* 327 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 329 */       String fieldName = field.getKey();
/* 330 */       String fieldValue = field.getValue();
/* 331 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setOrganizationId((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MessageId":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 345 */             setMessageId((Long)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setMessageId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setOrgCode((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setOrgValue((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartDate":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 372 */             setStartDate((Date)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setStartDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndDate":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 381 */             setEndDate((Date)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setEndDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Priority":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setPriority((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setPriority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StoreCreated":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 399 */             setStoreCreated((Boolean)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setStoreCreated() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationSpecific":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 408 */             setWorkstationSpecific((Boolean)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setWorkstationSpecific() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 417 */             setWorkstationId((Integer)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 426 */             setDescription((String)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 435 */             setVoid((Boolean)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MessageURL":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 444 */             setMessageURL((String)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setMessageURL() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 453 */             setCreateDate((Date)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 462 */             setCreateUserId((String)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 471 */             setUpdateDate((Date)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 480 */             setUpdateUserId((String)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeeMessageDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */