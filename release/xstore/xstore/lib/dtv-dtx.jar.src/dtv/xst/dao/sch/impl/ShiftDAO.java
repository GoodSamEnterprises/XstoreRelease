/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sch.ShiftId;
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
/*     */ public class ShiftDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 79854690L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShiftDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _shiftId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _name;
/*     */   private String _description;
/*     */   private String _workCode;
/*     */   private DtvDate _startTime;
/*     */   private DtvDate _endTime;
/*  38 */   private Boolean _void = Boolean.FALSE;
/*     */   private Long _breakDuration;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getShiftId() {
/*  52 */     return this._shiftId;
/*     */   }
/*     */   
/*     */   public void setShiftId(Long argShiftId) {
/*  56 */     if (changed(argShiftId, this._shiftId, "shiftId")) {
/*  57 */       this._shiftId = argShiftId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  62 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  66 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  67 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  72 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  76 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  77 */       this._orgValue = argOrgValue;
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
/*     */   public String getName() {
/* 124 */     return this._name;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 128 */     if (changed(argName, this._name, "name")) {
/* 129 */       this._name = argName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 134 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 138 */     if (changed(argDescription, this._description, "description")) {
/* 139 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkCode() {
/* 144 */     return this._workCode;
/*     */   }
/*     */   
/*     */   public void setWorkCode(String argWorkCode) {
/* 148 */     if (changed(argWorkCode, this._workCode, "workCode")) {
/* 149 */       this._workCode = argWorkCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/* 154 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 158 */     if (changed(argStartTime, this._startTime, "startTime")) {
/* 159 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 165 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 169 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 170 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getVoid() {
/* 176 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 180 */     if (changed(argVoid, this._void, "void")) {
/* 181 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getBreakDuration() {
/* 186 */     return this._breakDuration;
/*     */   }
/*     */   
/*     */   public void setBreakDuration(Long argBreakDuration) {
/* 190 */     if (changed(argBreakDuration, this._breakDuration, "breakDuration")) {
/* 191 */       this._breakDuration = argBreakDuration;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buf = new StringBuilder(512);
/* 199 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 200 */     if (getOrganizationId() != null) {
/* 201 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 203 */     if (getShiftId() != null) {
/* 204 */       buf.append("shiftId").append("=").append(getShiftId()).append(" ");
/*     */     }
/* 206 */     if (getOrgCode() != null) {
/* 207 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 209 */     if (getOrgValue() != null) {
/* 210 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 212 */     if (getCreateDate() != null) {
/* 213 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 215 */     if (getCreateUserId() != null) {
/* 216 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 218 */     if (getUpdateDate() != null) {
/* 219 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 221 */     if (getUpdateUserId() != null) {
/* 222 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 224 */     if (getName() != null) {
/* 225 */       buf.append("name").append("=").append(getName()).append(" ");
/*     */     }
/* 227 */     if (getDescription() != null) {
/* 228 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 230 */     if (getWorkCode() != null) {
/* 231 */       buf.append("workCode").append("=").append(getWorkCode()).append(" ");
/*     */     }
/* 233 */     if (getStartTime() != null) {
/* 234 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 236 */     if (getEndTime() != null) {
/* 237 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/* 239 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 240 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/* 242 */     if (getBreakDuration() != null) {
/* 243 */       buf.append("breakDuration").append("=").append(getBreakDuration()).append(" ");
/*     */     }
/*     */     
/* 246 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     ShiftId id = new ShiftId();
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setShiftId(getShiftId());
/* 253 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 257 */     setOrganizationId(((ShiftId)argObjectId).getOrganizationId());
/* 258 */     setShiftId(((ShiftId)argObjectId).getShiftId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 262 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 266 */     StringBuilder buf = new StringBuilder(750);
/* 267 */     buf.append("<").append("dao").append(" name=\"Shift\" cmd=\"" + getObjectStateString() + "\">");
/* 268 */     getFieldsAsXml(buf);
/* 269 */     buf.append("</").append("dao").append(">");
/*     */     
/* 271 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 275 */     Map<String, String> values = super.getValues();
/* 276 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 277 */     if (this._shiftId != null) values.put("ShiftId", DaoUtils.getXmlSafeFieldValue(-5, this._shiftId)); 
/* 278 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 279 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 280 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 281 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 282 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 283 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 284 */     if (this._name != null) values.put("Name", DaoUtils.getXmlSafeFieldValue(12, this._name)); 
/* 285 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 286 */     if (this._workCode != null) values.put("WorkCode", DaoUtils.getXmlSafeFieldValue(12, this._workCode)); 
/* 287 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 288 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
/* 289 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 290 */     if (this._breakDuration != null) values.put("BreakDuration", DaoUtils.getXmlSafeFieldValue(-5, this._breakDuration)); 
/* 291 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 296 */     super.setValues(argValues);
/* 297 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 299 */       String fieldName = field.getKey();
/* 300 */       String fieldValue = field.getValue();
/* 301 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 306 */             setOrganizationId((Long)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShiftId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 315 */             setShiftId((Long)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setShiftId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setOrgCode((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setOrgValue((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 342 */             setCreateDate((Date)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setCreateUserId((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 360 */             setUpdateDate((Date)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setUpdateUserId((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Name":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setName((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 387 */             setDescription((String)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkCode":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 396 */             setWorkCode((String)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setWorkCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 405 */             setStartTime((Date)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 414 */             setEndTime((Date)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 423 */             setVoid((Boolean)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BreakDuration":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 432 */             setBreakDuration((Long)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setBreakDuration() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\ShiftDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */