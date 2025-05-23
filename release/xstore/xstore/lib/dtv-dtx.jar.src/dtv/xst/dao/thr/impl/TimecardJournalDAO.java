/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.TimecardJournalId;
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
/*     */ public class TimecardJournalDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -2077766406L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TimecardJournalDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _retailLocationId;
/*     */   private Long _partyId;
/*     */   private Long _timecardEntryId;
/*     */   private Long _workstationId;
/*     */   private Long _timecardEntrySeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _clockInDateTime;
/*     */   private DtvDate _clockOutDateTime;
/*     */   private String _entryType;
/*  39 */   private Boolean _delete = Boolean.FALSE;
/*     */   private String _workCodeString;
/*     */   
/*     */   public Long getOrganizationId() {
/*  43 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  47 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  48 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  53 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  57 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  58 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  64 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  68 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  69 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  74 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  78 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  79 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTimecardEntryId() {
/*  84 */     return this._timecardEntryId;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryId(Long argTimecardEntryId) {
/*  88 */     if (changed(argTimecardEntryId, this._timecardEntryId, "timecardEntryId")) {
/*  89 */       this._timecardEntryId = argTimecardEntryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  94 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  98 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  99 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTimecardEntrySeq() {
/* 104 */     return this._timecardEntrySeq;
/*     */   }
/*     */   
/*     */   public void setTimecardEntrySeq(Long argTimecardEntrySeq) {
/* 108 */     if (changed(argTimecardEntrySeq, this._timecardEntrySeq, "timecardEntrySeq")) {
/* 109 */       this._timecardEntrySeq = argTimecardEntrySeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 114 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 118 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 119 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 125 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 129 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 130 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 135 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 139 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 140 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 146 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 150 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 151 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getClockInDateTime() {
/* 156 */     return (Date)this._clockInDateTime;
/*     */   }
/*     */   
/*     */   public void setClockInDateTime(Date argClockInDateTime) {
/* 160 */     if (changed(argClockInDateTime, this._clockInDateTime, "clockInDateTime")) {
/* 161 */       this._clockInDateTime = (argClockInDateTime == null || argClockInDateTime instanceof DtvDate) ? (DtvDate)argClockInDateTime : new DtvDate(argClockInDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getClockOutDateTime() {
/* 167 */     return (Date)this._clockOutDateTime;
/*     */   }
/*     */   
/*     */   public void setClockOutDateTime(Date argClockOutDateTime) {
/* 171 */     if (changed(argClockOutDateTime, this._clockOutDateTime, "clockOutDateTime")) {
/* 172 */       this._clockOutDateTime = (argClockOutDateTime == null || argClockOutDateTime instanceof DtvDate) ? (DtvDate)argClockOutDateTime : new DtvDate(argClockOutDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEntryType() {
/* 178 */     return this._entryType;
/*     */   }
/*     */   
/*     */   public void setEntryType(String argEntryType) {
/* 182 */     if (changed(argEntryType, this._entryType, "entryType")) {
/* 183 */       this._entryType = argEntryType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDelete() {
/* 188 */     return this._delete;
/*     */   }
/*     */   
/*     */   public void setDelete(Boolean argDelete) {
/* 192 */     if (changed(argDelete, this._delete, "delete")) {
/* 193 */       this._delete = argDelete;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkCodeString() {
/* 198 */     return this._workCodeString;
/*     */   }
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 202 */     if (changed(argWorkCodeString, this._workCodeString, "workCodeString")) {
/* 203 */       this._workCodeString = argWorkCodeString;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 210 */     StringBuilder buf = new StringBuilder(512);
/* 211 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 212 */     if (getOrganizationId() != null) {
/* 213 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 215 */     if (getBusinessDate() != null) {
/* 216 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 218 */     if (getRetailLocationId() != null) {
/* 219 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 221 */     if (getPartyId() != null) {
/* 222 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 224 */     if (getTimecardEntryId() != null) {
/* 225 */       buf.append("timecardEntryId").append("=").append(getTimecardEntryId()).append(" ");
/*     */     }
/* 227 */     if (getWorkstationId() != null) {
/* 228 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 230 */     if (getTimecardEntrySeq() != null) {
/* 231 */       buf.append("timecardEntrySeq").append("=").append(getTimecardEntrySeq()).append(" ");
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
/* 245 */     if (getClockInDateTime() != null) {
/* 246 */       buf.append("clockInDateTime").append("=").append(getClockInDateTime()).append(" ");
/*     */     }
/* 248 */     if (getClockOutDateTime() != null) {
/* 249 */       buf.append("clockOutDateTime").append("=").append(getClockOutDateTime()).append(" ");
/*     */     }
/* 251 */     if (getEntryType() != null) {
/* 252 */       buf.append("entryType").append("=").append(getEntryType()).append(" ");
/*     */     }
/* 254 */     if (getDelete() != null && getDelete().booleanValue()) {
/* 255 */       buf.append("delete").append("=").append(getDelete()).append(" ");
/*     */     }
/* 257 */     if (getWorkCodeString() != null) {
/* 258 */       buf.append("workCodeString").append("=").append(getWorkCodeString()).append(" ");
/*     */     }
/*     */     
/* 261 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 265 */     TimecardJournalId id = new TimecardJournalId();
/* 266 */     id.setOrganizationId(getOrganizationId());
/* 267 */     id.setBusinessDate(getBusinessDate());
/* 268 */     id.setRetailLocationId(getRetailLocationId());
/* 269 */     id.setPartyId(getPartyId());
/* 270 */     id.setTimecardEntryId(getTimecardEntryId());
/* 271 */     id.setWorkstationId(getWorkstationId());
/* 272 */     id.setTimecardEntrySeq(getTimecardEntrySeq());
/* 273 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 277 */     setOrganizationId(((TimecardJournalId)argObjectId).getOrganizationId());
/* 278 */     setBusinessDate(((TimecardJournalId)argObjectId).getBusinessDate());
/* 279 */     setRetailLocationId(((TimecardJournalId)argObjectId).getRetailLocationId());
/* 280 */     setPartyId(((TimecardJournalId)argObjectId).getPartyId());
/* 281 */     setTimecardEntryId(((TimecardJournalId)argObjectId).getTimecardEntryId());
/* 282 */     setWorkstationId(((TimecardJournalId)argObjectId).getWorkstationId());
/* 283 */     setTimecardEntrySeq(((TimecardJournalId)argObjectId).getTimecardEntrySeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 287 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 291 */     StringBuilder buf = new StringBuilder(800);
/* 292 */     buf.append("<").append("dao").append(" name=\"TimecardJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 293 */     getFieldsAsXml(buf);
/* 294 */     buf.append("</").append("dao").append(">");
/*     */     
/* 296 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 300 */     Map<String, String> values = super.getValues();
/* 301 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 302 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 303 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 304 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 305 */     if (this._timecardEntryId != null) values.put("TimecardEntryId", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntryId)); 
/* 306 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 307 */     if (this._timecardEntrySeq != null) values.put("TimecardEntrySeq", DaoUtils.getXmlSafeFieldValue(-5, this._timecardEntrySeq)); 
/* 308 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 309 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 310 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 311 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 312 */     if (this._clockInDateTime != null) values.put("ClockInDateTime", DaoUtils.getXmlSafeFieldValue(91, this._clockInDateTime)); 
/* 313 */     if (this._clockOutDateTime != null) values.put("ClockOutDateTime", DaoUtils.getXmlSafeFieldValue(91, this._clockOutDateTime)); 
/* 314 */     if (this._entryType != null) values.put("EntryType", DaoUtils.getXmlSafeFieldValue(12, this._entryType)); 
/* 315 */     if (this._delete != null) values.put("Delete", DaoUtils.getXmlSafeFieldValue(-7, this._delete)); 
/* 316 */     if (this._workCodeString != null) values.put("WorkCodeString", DaoUtils.getXmlSafeFieldValue(12, this._workCodeString)); 
/* 317 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 322 */     super.setValues(argValues);
/* 323 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 325 */       String fieldName = field.getKey();
/* 326 */       String fieldValue = field.getValue();
/* 327 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 332 */             setOrganizationId((Long)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 341 */             setBusinessDate((Date)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 350 */             setRetailLocationId((Long)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 359 */             setPartyId((Long)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntryId":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 368 */             setTimecardEntryId((Long)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setTimecardEntryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 377 */             setWorkstationId((Long)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimecardEntrySeq":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 386 */             setTimecardEntrySeq((Long)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setTimecardEntrySeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 395 */             setCreateDate((Date)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 404 */             setCreateUserId((String)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 413 */             setUpdateDate((Date)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 421 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 422 */             setUpdateUserId((String)value);
/* 423 */           } catch (Exception ee) {
/* 424 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClockInDateTime":
/*     */           try {
/* 430 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 431 */             setClockInDateTime((Date)value);
/* 432 */           } catch (Exception ee) {
/* 433 */             throw new DtxException("An exception occurred while calling setClockInDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ClockOutDateTime":
/*     */           try {
/* 439 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 440 */             setClockOutDateTime((Date)value);
/* 441 */           } catch (Exception ee) {
/* 442 */             throw new DtxException("An exception occurred while calling setClockOutDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryType":
/*     */           try {
/* 448 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 449 */             setEntryType((String)value);
/* 450 */           } catch (Exception ee) {
/* 451 */             throw new DtxException("An exception occurred while calling setEntryType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Delete":
/*     */           try {
/* 457 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 458 */             setDelete((Boolean)value);
/* 459 */           } catch (Exception ee) {
/* 460 */             throw new DtxException("An exception occurred while calling setDelete() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkCodeString":
/*     */           try {
/* 466 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 467 */             setWorkCodeString((String)value);
/* 468 */           } catch (Exception ee) {
/* 469 */             throw new DtxException("An exception occurred while calling setWorkCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */