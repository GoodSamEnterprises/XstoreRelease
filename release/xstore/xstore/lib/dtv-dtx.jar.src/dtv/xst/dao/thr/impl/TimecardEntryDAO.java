/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardEntryId;
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
/*     */ public class TimecardEntryDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 556317429L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TimecardEntryDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _clockInDateTime;
/*     */   private DtvDate _clockOutDateTime;
/*     */   private String _entryType;
/*  38 */   private Boolean _delete = Boolean.FALSE;
/*  39 */   private Boolean _openRecord = Boolean.FALSE;
/*     */   private Long _duration;
/*  41 */   private Boolean _payrollUpdateRequired = Boolean.FALSE;
/*     */   private String _workCodeString;
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
/*     */   public Date getBusinessDate() {
/*  55 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  59 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  60 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  66 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  70 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  71 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  76 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  80 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  81 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTimecardEntryId() {
/*  86 */     return this._timecardEntryId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryId(Long argTimecardEntryId) {
/*  90 */     if (changed(argTimecardEntryId, this._timecardEntryId, "timecardEntryId")) {
/*  91 */       this._timecardEntryId = argTimecardEntryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  96 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 100 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 101 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 106 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 110 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 111 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 117 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 121 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 122 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 127 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 131 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 132 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 138 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 142 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 143 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getClockInDateTime() {
/* 148 */     return (Date)this._clockInDateTime;
/*     */   }
/*     */   
/*     */   public void setClockInDateTime(Date argClockInDateTime) {
/* 152 */     if (changed(argClockInDateTime, this._clockInDateTime, "clockInDateTime")) {
/* 153 */       this._clockInDateTime = (argClockInDateTime == null || argClockInDateTime instanceof DtvDate) ? (DtvDate)argClockInDateTime : new DtvDate(argClockInDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getClockOutDateTime() {
/* 159 */     return (Date)this._clockOutDateTime;
/*     */   }
/*     */   
/*     */   public void setClockOutDateTime(Date argClockOutDateTime) {
/* 163 */     if (changed(argClockOutDateTime, this._clockOutDateTime, "clockOutDateTime")) {
/* 164 */       this._clockOutDateTime = (argClockOutDateTime == null || argClockOutDateTime instanceof DtvDate) ? (DtvDate)argClockOutDateTime : new DtvDate(argClockOutDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEntryType() {
/* 170 */     return this._entryType;
/*     */   }
/*     */   
/*     */   public void setEntryType(String argEntryType) {
/* 174 */     if (changed(argEntryType, this._entryType, "entryType")) {
/* 175 */       this._entryType = argEntryType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDelete() {
/* 180 */     return this._delete;
/*     */   }
/*     */   
/*     */   public void setDelete(Boolean argDelete) {
/* 184 */     if (changed(argDelete, this._delete, "delete")) {
/* 185 */       this._delete = argDelete;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getOpenRecord() {
/* 190 */     return this._openRecord;
/*     */   }
/*     */   
/*     */   public void setOpenRecord(Boolean argOpenRecord) {
/* 194 */     if (changed(argOpenRecord, this._openRecord, "openRecord")) {
/* 195 */       this._openRecord = argOpenRecord;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getDuration() {
/* 200 */     return this._duration;
/*     */   }
/*     */   
/*     */   public void setDuration(Long argDuration) {
/* 204 */     if (changed(argDuration, this._duration, "duration")) {
/* 205 */       this._duration = argDuration;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPayrollUpdateRequired() {
/* 210 */     return this._payrollUpdateRequired;
/*     */   }
/*     */   
/*     */   public void setPayrollUpdateRequired(Boolean argPayrollUpdateRequired) {
/* 214 */     if (changed(argPayrollUpdateRequired, this._payrollUpdateRequired, "payrollUpdateRequired")) {
/* 215 */       this._payrollUpdateRequired = argPayrollUpdateRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkCodeString() {
/* 220 */     return this._workCodeString;
/*     */   }
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 224 */     if (changed(argWorkCodeString, this._workCodeString, "workCodeString")) {
/* 225 */       this._workCodeString = argWorkCodeString;
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
/* 237 */     if (getBusinessDate() != null) {
/* 238 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 240 */     if (getRetailLocationId() != null) {
/* 241 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 243 */     if (getPartyId() != null) {
/* 244 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 246 */     if (getTimecardEntryId() != null) {
/* 247 */       buf.append("timecardEntryId").append("=").append(getTimecardEntryId()).append(" ");
/*     */     }
/* 249 */     if (getWorkstationId() != null) {
/* 250 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 252 */     if (getCreateDate() != null) {
/* 253 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 255 */     if (getCreateUserId() != null) {
/* 256 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 258 */     if (getUpdateDate() != null) {
/* 259 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 261 */     if (getUpdateUserId() != null) {
/* 262 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 264 */     if (getClockInDateTime() != null) {
/* 265 */       buf.append("clockInDateTime").append("=").append(getClockInDateTime()).append(" ");
/*     */     }
/* 267 */     if (getClockOutDateTime() != null) {
/* 268 */       buf.append("clockOutDateTime").append("=").append(getClockOutDateTime()).append(" ");
/*     */     }
/* 270 */     if (getEntryType() != null) {
/* 271 */       buf.append("entryType").append("=").append(getEntryType()).append(" ");
/*     */     }
/* 273 */     if (getDelete() != null && getDelete().booleanValue()) {
/* 274 */       buf.append("delete").append("=").append(getDelete()).append(" ");
/*     */     }
/* 276 */     if (getOpenRecord() != null && getOpenRecord().booleanValue()) {
/* 277 */       buf.append("openRecord").append("=").append(getOpenRecord()).append(" ");
/*     */     }
/* 279 */     if (getDuration() != null) {
/* 280 */       buf.append("duration").append("=").append(getDuration()).append(" ");
/*     */     }
/* 282 */     if (getPayrollUpdateRequired() != null && getPayrollUpdateRequired().booleanValue()) {
/* 283 */       buf.append("payrollUpdateRequired").append("=").append(getPayrollUpdateRequired()).append(" ");
/*     */     }
/* 285 */     if (getWorkCodeString() != null) {
/* 286 */       buf.append("workCodeString").append("=").append(getWorkCodeString()).append(" ");
/*     */     }
/*     */     
/* 289 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 293 */     TimecardEntryId id = new TimecardEntryId();
/* 294 */     id.setOrganizationId(getOrganizationId());
/* 295 */     id.setBusinessDate(getBusinessDate());
/* 296 */     id.setRetailLocationId(getRetailLocationId());
/* 297 */     id.setPartyId(getPartyId());
/* 298 */     id.setTimecardEntryId(getTimecardEntryId());
/* 299 */     id.setWorkstationId(getWorkstationId());
/* 300 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 304 */     setOrganizationId(((TimecardEntryId)argObjectId).getOrganizationId());
/* 305 */     setBusinessDate(((TimecardEntryId)argObjectId).getBusinessDate());
/* 306 */     setRetailLocationId(((TimecardEntryId)argObjectId).getRetailLocationId());
/* 307 */     setPartyId(((TimecardEntryId)argObjectId).getPartyId());
/* 308 */     setTimecardEntryId(((TimecardEntryId)argObjectId).getTimecardEntryId());
/* 309 */     setWorkstationId(((TimecardEntryId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 313 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 317 */     StringBuilder buf = new StringBuilder(900);
/* 318 */     buf.append("<").append("dao").append(" name=\"TimecardEntry\" cmd=\"" + getObjectStateString() + "\">");
/* 319 */     getFieldsAsXml(buf);
/* 320 */     buf.append("</").append("dao").append(">");
/*     */     
/* 322 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 326 */     Map<String, String> values = super.getValues();
/* 327 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 328 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 329 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 330 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 331 */     if (this._timecardEntryId != null) values.put("TimecardEntryId", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntryId)); 
/* 332 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 333 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 334 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 335 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 336 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 337 */     if (this._clockInDateTime != null) values.put("ClockInDateTime", DaoUtils.getXmlSafeFieldValue(91, this._clockInDateTime)); 
/* 338 */     if (this._clockOutDateTime != null) values.put("ClockOutDateTime", DaoUtils.getXmlSafeFieldValue(91, this._clockOutDateTime)); 
/* 339 */     if (this._entryType != null) values.put("EntryType", DaoUtils.getXmlSafeFieldValue(12, this._entryType)); 
/* 340 */     if (this._delete != null) values.put("Delete", DaoUtils.getXmlSafeFieldValue(-7, this._delete)); 
/* 341 */     if (this._openRecord != null) values.put("OpenRecord", DaoUtils.getXmlSafeFieldValue(-7, this._openRecord)); 
/* 342 */     if (this._duration != null) values.put("Duration", DaoUtils.getXmlSafeFieldValue(-5, this._duration)); 
/* 343 */     if (this._payrollUpdateRequired != null) values.put("PayrollUpdateRequired", DaoUtils.getXmlSafeFieldValue(-7, this._payrollUpdateRequired)); 
/* 344 */     if (this._workCodeString != null) values.put("WorkCodeString", DaoUtils.getXmlSafeFieldValue(12, this._workCodeString)); 
/* 345 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 350 */     super.setValues(argValues);
/* 351 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 353 */       String fieldName = field.getKey();
/* 354 */       String fieldValue = field.getValue();
/* 355 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 360 */             setOrganizationId((Long)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 369 */             setBusinessDate((Date)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 378 */             setRetailLocationId((Long)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 387 */             setPartyId((Long)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntryId":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 396 */             setTimecardEntryId((Long)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setTimecardEntryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 405 */             setWorkstationId((Long)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 414 */             setCreateDate((Date)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setCreateUserId((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 432 */             setUpdateDate((Date)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 441 */             setUpdateUserId((String)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClockInDateTime":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 450 */             setClockInDateTime((Date)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setClockInDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClockOutDateTime":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 459 */             setClockOutDateTime((Date)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setClockOutDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryType":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 468 */             setEntryType((String)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setEntryType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Delete":
/*     */           try {
/* 476 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 477 */             setDelete((Boolean)value);
/* 478 */           } catch (Exception ee) {
/* 479 */             throw new DtxException("An exception occurred while calling setDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OpenRecord":
/*     */           try {
/* 485 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 486 */             setOpenRecord((Boolean)value);
/* 487 */           } catch (Exception ee) {
/* 488 */             throw new DtxException("An exception occurred while calling setOpenRecord() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Duration":
/*     */           try {
/* 494 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 495 */             setDuration((Long)value);
/* 496 */           } catch (Exception ee) {
/* 497 */             throw new DtxException("An exception occurred while calling setDuration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayrollUpdateRequired":
/*     */           try {
/* 503 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 504 */             setPayrollUpdateRequired((Boolean)value);
/* 505 */           } catch (Exception ee) {
/* 506 */             throw new DtxException("An exception occurred while calling setPayrollUpdateRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkCodeString":
/*     */           try {
/* 512 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 513 */             setWorkCodeString((String)value);
/* 514 */           } catch (Exception ee) {
/* 515 */             throw new DtxException("An exception occurred while calling setWorkCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */