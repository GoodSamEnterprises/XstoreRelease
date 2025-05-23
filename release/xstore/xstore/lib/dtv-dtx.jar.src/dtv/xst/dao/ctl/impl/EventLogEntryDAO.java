/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.EventLogEntryId;
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
/*     */ public class EventLogEntryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 879668264L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EventLogEntryDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _operatorPartyId;
/*     */   private String _logLevel;
/*     */   private DtvDate _logTimestamp;
/*     */   private String _source;
/*     */   private String _threadName;
/*  38 */   private Boolean _criticalToDeliver = Boolean.FALSE;
/*     */   private String _loggerCategory;
/*     */   private String _logMessage;
/*     */   private DtvDate _arrivalTimestamp;
/*     */   
/*     */   public Date getCreateDate() {
/*  44 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  48 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  49 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  55 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  59 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  60 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  65 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  69 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  70 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  76 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  80 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  81 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  86 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  90 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  91 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  96 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 100 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 101 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 106 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 110 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 111 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 116 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 120 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 121 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOperatorPartyId() {
/* 127 */     return this._operatorPartyId;
/*     */   }
/*     */   
/*     */   public void setOperatorPartyId(Long argOperatorPartyId) {
/* 131 */     if (changed(argOperatorPartyId, this._operatorPartyId, "operatorPartyId")) {
/* 132 */       this._operatorPartyId = argOperatorPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLogLevel() {
/* 137 */     return this._logLevel;
/*     */   }
/*     */   
/*     */   public void setLogLevel(String argLogLevel) {
/* 141 */     if (changed(argLogLevel, this._logLevel, "logLevel")) {
/* 142 */       this._logLevel = argLogLevel;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getLogTimestamp() {
/* 147 */     return (Date)this._logTimestamp;
/*     */   }
/*     */   
/*     */   public void setLogTimestamp(Date argLogTimestamp) {
/* 151 */     if (changed(argLogTimestamp, this._logTimestamp, "logTimestamp")) {
/* 152 */       this._logTimestamp = (argLogTimestamp == null || argLogTimestamp instanceof DtvDate) ? (DtvDate)argLogTimestamp : new DtvDate(argLogTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSource() {
/* 158 */     return this._source;
/*     */   }
/*     */   
/*     */   public void setSource(String argSource) {
/* 162 */     if (changed(argSource, this._source, "source")) {
/* 163 */       this._source = argSource;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getThreadName() {
/* 168 */     return this._threadName;
/*     */   }
/*     */   
/*     */   public void setThreadName(String argThreadName) {
/* 172 */     if (changed(argThreadName, this._threadName, "threadName")) {
/* 173 */       this._threadName = argThreadName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCriticalToDeliver() {
/* 178 */     return this._criticalToDeliver;
/*     */   }
/*     */   
/*     */   public void setCriticalToDeliver(Boolean argCriticalToDeliver) {
/* 182 */     if (changed(argCriticalToDeliver, this._criticalToDeliver, "criticalToDeliver")) {
/* 183 */       this._criticalToDeliver = argCriticalToDeliver;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLoggerCategory() {
/* 188 */     return this._loggerCategory;
/*     */   }
/*     */   
/*     */   public void setLoggerCategory(String argLoggerCategory) {
/* 192 */     if (changed(argLoggerCategory, this._loggerCategory, "loggerCategory")) {
/* 193 */       this._loggerCategory = argLoggerCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLogMessage() {
/* 198 */     return this._logMessage;
/*     */   }
/*     */   
/*     */   public void setLogMessage(String argLogMessage) {
/* 202 */     if (changed(argLogMessage, this._logMessage, "logMessage")) {
/* 203 */       this._logMessage = argLogMessage;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getArrivalTimestamp() {
/* 208 */     return (Date)this._arrivalTimestamp;
/*     */   }
/*     */   
/*     */   public void setArrivalTimestamp(Date argArrivalTimestamp) {
/* 212 */     if (changed(argArrivalTimestamp, this._arrivalTimestamp, "arrivalTimestamp")) {
/* 213 */       this._arrivalTimestamp = (argArrivalTimestamp == null || argArrivalTimestamp instanceof DtvDate) ? (DtvDate)argArrivalTimestamp : new DtvDate(argArrivalTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 221 */     StringBuilder buf = new StringBuilder(512);
/* 222 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 223 */     if (getCreateDate() != null) {
/* 224 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 226 */     if (getCreateUserId() != null) {
/* 227 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 229 */     if (getUpdateDate() != null) {
/* 230 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 232 */     if (getUpdateUserId() != null) {
/* 233 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 235 */     if (getOrganizationId() != null) {
/* 236 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 238 */     if (getRetailLocationId() != null) {
/* 239 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 241 */     if (getWorkstationId() != null) {
/* 242 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 244 */     if (getBusinessDate() != null) {
/* 245 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 247 */     if (getOperatorPartyId() != null) {
/* 248 */       buf.append("operatorPartyId").append("=").append(getOperatorPartyId()).append(" ");
/*     */     }
/* 250 */     if (getLogLevel() != null) {
/* 251 */       buf.append("logLevel").append("=").append(getLogLevel()).append(" ");
/*     */     }
/* 253 */     if (getLogTimestamp() != null) {
/* 254 */       buf.append("logTimestamp").append("=").append(getLogTimestamp()).append(" ");
/*     */     }
/* 256 */     if (getSource() != null) {
/* 257 */       buf.append("source").append("=").append(getSource()).append(" ");
/*     */     }
/* 259 */     if (getThreadName() != null) {
/* 260 */       buf.append("threadName").append("=").append(getThreadName()).append(" ");
/*     */     }
/* 262 */     if (getCriticalToDeliver() != null && getCriticalToDeliver().booleanValue()) {
/* 263 */       buf.append("criticalToDeliver").append("=").append(getCriticalToDeliver()).append(" ");
/*     */     }
/* 265 */     if (getLoggerCategory() != null) {
/* 266 */       buf.append("loggerCategory").append("=").append(getLoggerCategory()).append(" ");
/*     */     }
/* 268 */     if (getLogMessage() != null) {
/* 269 */       buf.append("logMessage").append("=").append(getLogMessage()).append(" ");
/*     */     }
/* 271 */     if (getArrivalTimestamp() != null) {
/* 272 */       buf.append("arrivalTimestamp").append("=").append(getArrivalTimestamp()).append(" ");
/*     */     }
/*     */     
/* 275 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 279 */     EventLogEntryId id = new EventLogEntryId();
/* 280 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {}
/*     */ 
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 292 */     StringBuilder buf = new StringBuilder(850);
/* 293 */     buf.append("<").append("dao").append(" name=\"EventLogEntry\" cmd=\"" + getObjectStateString() + "\">");
/* 294 */     getFieldsAsXml(buf);
/* 295 */     buf.append("</").append("dao").append(">");
/*     */     
/* 297 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 301 */     Map<String, String> values = super.getValues();
/* 302 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 303 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 304 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 305 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 306 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 307 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 308 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 309 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 310 */     if (this._operatorPartyId != null) values.put("OperatorPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._operatorPartyId)); 
/* 311 */     if (this._logLevel != null) values.put("LogLevel", DaoUtils.getXmlSafeFieldValue(12, this._logLevel)); 
/* 312 */     if (this._logTimestamp != null) values.put("LogTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._logTimestamp)); 
/* 313 */     if (this._source != null) values.put("Source", DaoUtils.getXmlSafeFieldValue(12, this._source)); 
/* 314 */     if (this._threadName != null) values.put("ThreadName", DaoUtils.getXmlSafeFieldValue(12, this._threadName)); 
/* 315 */     if (this._criticalToDeliver != null) values.put("CriticalToDeliver", DaoUtils.getXmlSafeFieldValue(-7, this._criticalToDeliver)); 
/* 316 */     if (this._loggerCategory != null) values.put("LoggerCategory", DaoUtils.getXmlSafeFieldValue(12, this._loggerCategory)); 
/* 317 */     if (this._logMessage != null) values.put("LogMessage", DaoUtils.getXmlSafeFieldValue(12, this._logMessage)); 
/* 318 */     if (this._arrivalTimestamp != null) values.put("ArrivalTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._arrivalTimestamp)); 
/* 319 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 324 */     super.setValues(argValues);
/* 325 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 327 */       String fieldName = field.getKey();
/* 328 */       String fieldValue = field.getValue();
/* 329 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 334 */             setCreateDate((Date)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setCreateUserId((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setUpdateDate((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setUpdateUserId((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 370 */             setOrganizationId((Long)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 379 */             setRetailLocationId((Long)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 388 */             setWorkstationId((Long)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 397 */             setBusinessDate((Date)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OperatorPartyId":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 406 */             setOperatorPartyId((Long)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setOperatorPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LogLevel":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setLogLevel((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setLogLevel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LogTimestamp":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 424 */             setLogTimestamp((Date)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setLogTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Source":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setSource((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setSource() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ThreadName":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setThreadName((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setThreadName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CriticalToDeliver":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 451 */             setCriticalToDeliver((Boolean)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setCriticalToDeliver() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LoggerCategory":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 460 */             setLoggerCategory((String)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setLoggerCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LogMessage":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 469 */             setLogMessage((String)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setLogMessage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ArrivalTimestamp":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 478 */             setArrivalTimestamp((Date)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setArrivalTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\EventLogEntryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */