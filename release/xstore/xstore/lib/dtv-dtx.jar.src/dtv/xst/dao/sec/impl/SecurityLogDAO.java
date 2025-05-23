/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.SecurityLogId;
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
/*     */ public class SecurityLogDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1077013564L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SecurityLogDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private String _activityType;
/*  35 */   private Boolean _success = Boolean.FALSE;
/*     */   private String _employeeId;
/*     */   private String _overridingEmployeeId;
/*     */   private String _privilegeType;
/*     */   private DtvDate _systemDateTime;
/*     */   
/*     */   public Date getCreateDate() {
/*  42 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  46 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  47 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  53 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  57 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  58 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  63 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  67 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  68 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  74 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  78 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  79 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  84 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  88 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  89 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  94 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  98 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  99 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 104 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 108 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 109 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/* 114 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 118 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 119 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/* 125 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/* 129 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/* 130 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getActivityType() {
/* 135 */     return this._activityType;
/*     */   }
/*     */   
/*     */   public void setActivityType(String argActivityType) {
/* 139 */     if (changed(argActivityType, this._activityType, "activityType")) {
/* 140 */       this._activityType = argActivityType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSuccess() {
/* 145 */     return this._success;
/*     */   }
/*     */   
/*     */   public void setSuccess(Boolean argSuccess) {
/* 149 */     if (changed(argSuccess, this._success, "success")) {
/* 150 */       this._success = argSuccess;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmployeeId() {
/* 155 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(String argEmployeeId) {
/* 159 */     if (changed(argEmployeeId, this._employeeId, "employeeId")) {
/* 160 */       this._employeeId = argEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOverridingEmployeeId() {
/* 165 */     return this._overridingEmployeeId;
/*     */   }
/*     */   
/*     */   public void setOverridingEmployeeId(String argOverridingEmployeeId) {
/* 169 */     if (changed(argOverridingEmployeeId, this._overridingEmployeeId, "overridingEmployeeId")) {
/* 170 */       this._overridingEmployeeId = argOverridingEmployeeId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPrivilegeType() {
/* 175 */     return this._privilegeType;
/*     */   }
/*     */   
/*     */   public void setPrivilegeType(String argPrivilegeType) {
/* 179 */     if (changed(argPrivilegeType, this._privilegeType, "privilegeType")) {
/* 180 */       this._privilegeType = argPrivilegeType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getSystemDateTime() {
/* 185 */     return (Date)this._systemDateTime;
/*     */   }
/*     */   
/*     */   public void setSystemDateTime(Date argSystemDateTime) {
/* 189 */     if (changed(argSystemDateTime, this._systemDateTime, "systemDateTime")) {
/* 190 */       this._systemDateTime = (argSystemDateTime == null || argSystemDateTime instanceof DtvDate) ? (DtvDate)argSystemDateTime : new DtvDate(argSystemDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 198 */     StringBuilder buf = new StringBuilder(512);
/* 199 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 200 */     if (getCreateDate() != null) {
/* 201 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 203 */     if (getCreateUserId() != null) {
/* 204 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 206 */     if (getUpdateDate() != null) {
/* 207 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 209 */     if (getUpdateUserId() != null) {
/* 210 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 212 */     if (getOrganizationId() != null) {
/* 213 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 215 */     if (getRetailLocationId() != null) {
/* 216 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 218 */     if (getWorkstationId() != null) {
/* 219 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 221 */     if (getBusinessDate() != null) {
/* 222 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 224 */     if (getTransactionSequence() != null) {
/* 225 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 227 */     if (getActivityType() != null) {
/* 228 */       buf.append("activityType").append("=").append(getActivityType()).append(" ");
/*     */     }
/* 230 */     if (getSuccess() != null && getSuccess().booleanValue()) {
/* 231 */       buf.append("success").append("=").append(getSuccess()).append(" ");
/*     */     }
/* 233 */     if (getEmployeeId() != null) {
/* 234 */       buf.append("employeeId").append("=").append(getEmployeeId()).append(" ");
/*     */     }
/* 236 */     if (getOverridingEmployeeId() != null) {
/* 237 */       buf.append("overridingEmployeeId").append("=").append(getOverridingEmployeeId()).append(" ");
/*     */     }
/* 239 */     if (getPrivilegeType() != null) {
/* 240 */       buf.append("privilegeType").append("=").append(getPrivilegeType()).append(" ");
/*     */     }
/* 242 */     if (getSystemDateTime() != null) {
/* 243 */       buf.append("systemDateTime").append("=").append(getSystemDateTime()).append(" ");
/*     */     }
/*     */     
/* 246 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     SecurityLogId id = new SecurityLogId();
/* 251 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {}
/*     */ 
/*     */   
/*     */   public String getImplementingClass() {
/* 259 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 263 */     StringBuilder buf = new StringBuilder(750);
/* 264 */     buf.append("<").append("dao").append(" name=\"SecurityLog\" cmd=\"" + getObjectStateString() + "\">");
/* 265 */     getFieldsAsXml(buf);
/* 266 */     buf.append("</").append("dao").append(">");
/*     */     
/* 268 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 272 */     Map<String, String> values = super.getValues();
/* 273 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 274 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 275 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 276 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 277 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 278 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 279 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 280 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 281 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 282 */     if (this._activityType != null) values.put("ActivityType", DaoUtils.getXmlSafeFieldValue(12, this._activityType)); 
/* 283 */     if (this._success != null) values.put("Success", DaoUtils.getXmlSafeFieldValue(-7, this._success)); 
/* 284 */     if (this._employeeId != null) values.put("EmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._employeeId)); 
/* 285 */     if (this._overridingEmployeeId != null) values.put("OverridingEmployeeId", DaoUtils.getXmlSafeFieldValue(12, this._overridingEmployeeId)); 
/* 286 */     if (this._privilegeType != null) values.put("PrivilegeType", DaoUtils.getXmlSafeFieldValue(12, this._privilegeType)); 
/* 287 */     if (this._systemDateTime != null) values.put("SystemDateTime", DaoUtils.getXmlSafeFieldValue(91, this._systemDateTime)); 
/* 288 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 293 */     super.setValues(argValues);
/* 294 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 296 */       String fieldName = field.getKey();
/* 297 */       String fieldValue = field.getValue();
/* 298 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 303 */             setCreateDate((Date)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setCreateUserId((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 321 */             setUpdateDate((Date)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 330 */             setUpdateUserId((String)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 339 */             setOrganizationId((Long)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 348 */             setRetailLocationId((Long)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 357 */             setWorkstationId((Long)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 366 */             setBusinessDate((Date)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 375 */             setTransactionSequence((Long)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivityType":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setActivityType((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setActivityType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Success":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 393 */             setSuccess((Boolean)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setSuccess() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmployeeId":
/*     */           try {
/* 401 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 402 */             setEmployeeId((String)value);
/* 403 */           } catch (Exception ee) {
/* 404 */             throw new DtxException("An exception occurred while calling setEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OverridingEmployeeId":
/*     */           try {
/* 410 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 411 */             setOverridingEmployeeId((String)value);
/* 412 */           } catch (Exception ee) {
/* 413 */             throw new DtxException("An exception occurred while calling setOverridingEmployeeId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PrivilegeType":
/*     */           try {
/* 419 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 420 */             setPrivilegeType((String)value);
/* 421 */           } catch (Exception ee) {
/* 422 */             throw new DtxException("An exception occurred while calling setPrivilegeType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SystemDateTime":
/*     */           try {
/* 428 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 429 */             setSystemDateTime((Date)value);
/* 430 */           } catch (Exception ee) {
/* 431 */             throw new DtxException("An exception occurred while calling setSystemDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\SecurityLogDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */