/*     */ package dtv.xst.dao.sch.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sch.EmployeeTimeOffId;
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
/*     */ public class EmployeeTimeOffDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1854604108L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EmployeeTimeOffDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _employeeId;
/*     */   private Long _timeOffSeq;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _startTime;
/*     */   private DtvDate _endTime;
/*     */   private String _reasonCode;
/*     */   private String _typeCode;
/*  36 */   private Boolean _void = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmployeeId() {
/*  49 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/*  53 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/*  54 */       this._employeeId = (argEmployeeId != null && MANAGE_CASE) ? argEmployeeId.toUpperCase() : argEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTimeOffSeq() {
/*  59 */     return this._timeOffSeq;
/*     */   }
/*     */   
/*     */   public void setTimeOffSeq(Long argTimeOffSeq) {
/*  63 */     if (changed(argTimeOffSeq, this._timeOffSeq, "timeOffSeq")) {
/*  64 */       this._timeOffSeq = argTimeOffSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  69 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  73 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  74 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  84 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  85 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  90 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  94 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  95 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 101 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 105 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 106 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getStartTime() {
/* 111 */     return (Date)this._startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 115 */     if (changed(argStartTime, this._startTime, "startTime")) {
/* 116 */       this._startTime = (argStartTime == null || argStartTime instanceof DtvDate) ? (DtvDate)argStartTime : new DtvDate(argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 122 */     return (Date)this._endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 126 */     if (changed(argEndTime, this._endTime, "endTime")) {
/* 127 */       this._endTime = (argEndTime == null || argEndTime instanceof DtvDate) ? (DtvDate)argEndTime : new DtvDate(argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getReasonCode() {
/* 133 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 137 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 138 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 143 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 147 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 148 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 153 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 157 */     if (changed(argVoid, this._void, "void")) {
/* 158 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     StringBuilder buf = new StringBuilder(512);
/* 166 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 167 */     if (getOrganizationId() != null) {
/* 168 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 170 */     if (getEmployeeId() != null) {
/* 171 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 173 */     if (getTimeOffSeq() != null) {
/* 174 */       buf.append("timeOffSeq").append("=").append(getTimeOffSeq()).append(" ");
/*     */     }
/* 176 */     if (getCreateDate() != null) {
/* 177 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 179 */     if (getCreateUserId() != null) {
/* 180 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 182 */     if (getUpdateDate() != null) {
/* 183 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 185 */     if (getUpdateUserId() != null) {
/* 186 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 188 */     if (getStartTime() != null) {
/* 189 */       buf.append("startTime").append("=").append(getStartTime()).append(" ");
/*     */     }
/* 191 */     if (getEndTime() != null) {
/* 192 */       buf.append("endTime").append("=").append(getEndTime()).append(" ");
/*     */     }
/* 194 */     if (getReasonCode() != null) {
/* 195 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/* 197 */     if (getTypeCode() != null) {
/* 198 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 200 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 201 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/*     */     
/* 204 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     EmployeeTimeOffId id = new EmployeeTimeOffId();
/* 209 */     id.setOrganizationId(getOrganizationId());
/* 210 */     id.setEmployeeId(getEmployeeId());
/* 211 */     id.setTimeOffSeq(getTimeOffSeq());
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 216 */     setOrganizationId(((EmployeeTimeOffId)argObjectId).getOrganizationId());
/* 217 */     setEmployeeId(((EmployeeTimeOffId)argObjectId).getEmployeeId());
/* 218 */     setTimeOffSeq(((EmployeeTimeOffId)argObjectId).getTimeOffSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 226 */     StringBuilder buf = new StringBuilder(600);
/* 227 */     buf.append("<").append("dao").append(" name=\"EmployeeTimeOff\" cmd=\"" + getObjectStateString() + "\">");
/* 228 */     getFieldsAsXml(buf);
/* 229 */     buf.append("</").append("dao").append(">");
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 235 */     Map<String, String> values = super.getValues();
/* 236 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 237 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 238 */     if (this._timeOffSeq != null) values.put("TimeOffSeq", DaoUtils.getXmlSafeFieldValue(-5, this._timeOffSeq)); 
/* 239 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 240 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 241 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 242 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 243 */     if (this._startTime != null) values.put("StartTime", DaoUtils.getXmlSafeFieldValue(91, this._startTime)); 
/* 244 */     if (this._endTime != null) values.put("EndTime", DaoUtils.getXmlSafeFieldValue(91, this._endTime)); 
/* 245 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 246 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 247 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 248 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 253 */     super.setValues(argValues);
/* 254 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 256 */       String fieldName = field.getKey();
/* 257 */       String fieldValue = field.getValue();
/* 258 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 263 */             setOrganizationId((Long)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 272 */             setEmployeeId((String)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TimeOffSeq":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 281 */             setTimeOffSeq((Long)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setTimeOffSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 290 */             setCreateDate((Date)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 299 */             setCreateUserId((String)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 308 */             setUpdateDate((Date)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 317 */             setUpdateUserId((String)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartTime":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 326 */             setStartTime((Date)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setStartTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndTime":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 335 */             setEndTime((Date)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setEndTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 344 */             setReasonCode((String)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 353 */             setTypeCode((String)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 362 */             setVoid((Boolean)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\EmployeeTimeOffDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */