/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sch.ScheduleId;
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
/*     */ public class ScheduleDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -633276745L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ScheduleDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _scheduleSeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _startTime;
/*     */   private DtvDate _endTime;
/*  35 */   private Boolean _void = Boolean.FALSE;
/*     */   private String _workCodeString;
/*     */   private Long _scheduleDuration;
/*     */   private Long _breakDuration;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmployeeId() {
/*  51 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  55 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/*  56 */       this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  61 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  65 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  66 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getScheduleSeq() {
/*  72 */     return this._scheduleSeq;
/*     */   }
/*     */   
/*     */   public void setScheduleSeq(Long argScheduleSeq) {
/*  76 */     if (changed(argScheduleSeq, this._scheduleSeq, "scheduleSeq")) {
/*  77 */       this._scheduleSeq = argScheduleSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  82 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  86 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  87 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  93 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  97 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  98 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 103 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 107 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 108 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 114 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 118 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 119 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/* 124 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 128 */     if (changed(argStartTime, this._startTime, "startTime")) {
/* 129 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 135 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 139 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 140 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getVoid() {
/* 146 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 150 */     if (changed(argVoid, this._void, "void")) {
/* 151 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkCodeString() {
/* 156 */     return this._workCodeString;
/*     */   }
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 160 */     if (changed(argWorkCodeString, this._workCodeString, "workCodeString")) {
/* 161 */       this._workCodeString = argWorkCodeString;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getScheduleDuration() {
/* 166 */     return this._scheduleDuration;
/*     */   }
/*     */   
/*     */   public void setScheduleDuration(Long argScheduleDuration) {
/* 170 */     if (changed(argScheduleDuration, this._scheduleDuration, "scheduleDuration")) {
/* 171 */       this._scheduleDuration = argScheduleDuration;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getBreakDuration() {
/* 176 */     return this._breakDuration;
/*     */   }
/*     */   
/*     */   public void setBreakDuration(Long argBreakDuration) {
/* 180 */     if (changed(argBreakDuration, this._breakDuration, "breakDuration")) {
/* 181 */       this._breakDuration = argBreakDuration;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 188 */     StringBuilder buf = new StringBuilder(512);
/* 189 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 190 */     if (getOrganizationId() != null) {
/* 191 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 193 */     if (getEmployeeId() != null) {
/* 194 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 196 */     if (getBusinessDate() != null) {
/* 197 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 199 */     if (getScheduleSeq() != null) {
/* 200 */       buf.append("scheduleSeq").append("=").append(getScheduleSeq()).append(" ");
/*     */     }
/* 202 */     if (getCreateDate() != null) {
/* 203 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 205 */     if (getCreateUserId() != null) {
/* 206 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 208 */     if (getUpdateDate() != null) {
/* 209 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 211 */     if (getUpdateUserId() != null) {
/* 212 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 214 */     if (getStartTime() != null) {
/* 215 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 217 */     if (getEndTime() != null) {
/* 218 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/* 220 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 221 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 223 */     if (getWorkCodeString() != null) {
/* 224 */       buf.append("workCodeString").append("=").append(getWorkCodeString()).append(" ");
/*     */     }
/* 226 */     if (getScheduleDuration() != null) {
/* 227 */       buf.append("scheduleDuration").append("=").append(getScheduleDuration()).append(" ");
/*     */     }
/* 229 */     if (getBreakDuration() != null) {
/* 230 */       buf.append("breakDuration").append("=").append(getBreakDuration()).append(" ");
/*     */     }
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 237 */     ScheduleId id = new ScheduleId();
/* 238 */     id.setOrganizationId(getOrganizationId());
/* 239 */     id.setEmployeeId(getEmployeeId());
/* 240 */     id.setBusinessDate(getBusinessDate());
/* 241 */     id.setScheduleSeq(getScheduleSeq());
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 246 */     setOrganizationId(((ScheduleId)argObjectId).getOrganizationId());
/* 247 */     setEmployeeId(((ScheduleId)argObjectId).getEmployeeId());
/* 248 */     setBusinessDate(((ScheduleId)argObjectId).getBusinessDate());
/* 249 */     setScheduleSeq(((ScheduleId)argObjectId).getScheduleSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 253 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 257 */     StringBuilder buf = new StringBuilder(700);
/* 258 */     buf.append("<").append("dao").append(" name=\"Schedule\" cmd=\"" + getObjectStateString() + "\">");
/* 259 */     getFieldsAsXml(buf);
/* 260 */     buf.append("</").append("dao").append(">");
/*     */     
/* 262 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 266 */     Map<String, String> values = super.getValues();
/* 267 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 268 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 269 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 270 */     if (this._scheduleSeq != null) values.put("ScheduleSeq", DaoUtils.getXmlSafeFieldValue(-5, this._scheduleSeq)); 
/* 271 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 272 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 273 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 274 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 275 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 276 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
/* 277 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 278 */     if (this._workCodeString != null) values.put("WorkCodeString", DaoUtils.getXmlSafeFieldValue(12, this._workCodeString)); 
/* 279 */     if (this._scheduleDuration != null) values.put("ScheduleDuration", DaoUtils.getXmlSafeFieldValue(-5, this._scheduleDuration)); 
/* 280 */     if (this._breakDuration != null) values.put("BreakDuration", DaoUtils.getXmlSafeFieldValue(-5, this._breakDuration)); 
/* 281 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 286 */     super.setValues(argValues);
/* 287 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 289 */       String fieldName = field.getKey();
/* 290 */       String fieldValue = field.getValue();
/* 291 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 296 */             setOrganizationId((Long)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 305 */             setEmployeeId((String)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 314 */             setBusinessDate((Date)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ScheduleSeq":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 323 */             setScheduleSeq((Long)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setScheduleSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 332 */             setCreateDate((Date)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setCreateUserId((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 350 */             setUpdateDate((Date)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setUpdateUserId((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setStartTime((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 377 */             setEndTime((Date)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 386 */             setVoid((Boolean)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkCodeString":
/*     */           try {
/* 394 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 395 */             setWorkCodeString((String)value);
/* 396 */           } catch (Exception ee) {
/* 397 */             throw new DtxException("An exception occurred while calling setWorkCodeString() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ScheduleDuration":
/*     */           try {
/* 403 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 404 */             setScheduleDuration((Long)value);
/* 405 */           } catch (Exception ee) {
/* 406 */             throw new DtxException("An exception occurred while calling setScheduleDuration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BreakDuration":
/*     */           try {
/* 412 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 413 */             setBreakDuration((Long)value);
/* 414 */           } catch (Exception ee) {
/* 415 */             throw new DtxException("An exception occurred while calling setBreakDuration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\ScheduleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */