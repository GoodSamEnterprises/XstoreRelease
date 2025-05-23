/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.DeviceRegistrationId;
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
/*     */ public class DeviceRegistrationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 163923535L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DeviceRegistrationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _ipAddress;
/*     */   private DtvDate _dateTimestamp;
/*     */   private DtvDate _businessDate;
/*     */   private String _xtoreVersion;
/*     */   private String _envVersion;
/*  37 */   private Boolean _activeFlag = Boolean.FALSE;
/*     */   private String _configVersion;
/*  39 */   private Boolean _primaryRegister = Boolean.FALSE;
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
/*     */   public Long getRetailLocationId() {
/*  52 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  56 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  57 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  62 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  66 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  67 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  72 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  76 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  77 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  83 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  87 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  88 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  93 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  97 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  98 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 104 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 108 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 109 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIpAddress() {
/* 114 */     return this._ipAddress;
/*     */   }
/*     */   
/*     */   public void setIpAddress(String argIpAddress) {
/* 118 */     if (changed(argIpAddress, this._ipAddress, "ipAddress")) {
/* 119 */       this._ipAddress = argIpAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateTimestamp() {
/* 124 */     return (Date)this._dateTimestamp;
/*     */   }
/*     */   
/*     */   public void setDateTimestamp(Date argDateTimestamp) {
/* 128 */     if (changed(argDateTimestamp, this._dateTimestamp, "dateTimestamp")) {
/* 129 */       this._dateTimestamp = (argDateTimestamp == null || argDateTimestamp instanceof DtvDate) ? (DtvDate)argDateTimestamp : new DtvDate(argDateTimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 135 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 139 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/* 140 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getXtoreVersion() {
/* 146 */     return this._xtoreVersion;
/*     */   }
/*     */   
/*     */   public void setXtoreVersion(String argXtoreVersion) {
/* 150 */     if (changed(argXtoreVersion, this._xtoreVersion, "xtoreVersion")) {
/* 151 */       this._xtoreVersion = argXtoreVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEnvVersion() {
/* 156 */     return this._envVersion;
/*     */   }
/*     */   
/*     */   public void setEnvVersion(String argEnvVersion) {
/* 160 */     if (changed(argEnvVersion, this._envVersion, "envVersion")) {
/* 161 */       this._envVersion = argEnvVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getActiveFlag() {
/* 166 */     return this._activeFlag;
/*     */   }
/*     */   
/*     */   public void setActiveFlag(Boolean argActiveFlag) {
/* 170 */     if (changed(argActiveFlag, this._activeFlag, "activeFlag")) {
/* 171 */       this._activeFlag = argActiveFlag;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigVersion() {
/* 176 */     return this._configVersion;
/*     */   }
/*     */   
/*     */   public void setConfigVersion(String argConfigVersion) {
/* 180 */     if (changed(argConfigVersion, this._configVersion, "configVersion")) {
/* 181 */       this._configVersion = argConfigVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPrimaryRegister() {
/* 186 */     return this._primaryRegister;
/*     */   }
/*     */   
/*     */   public void setPrimaryRegister(Boolean argPrimaryRegister) {
/* 190 */     if (changed(argPrimaryRegister, this._primaryRegister, "primaryRegister")) {
/* 191 */       this._primaryRegister = argPrimaryRegister;
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
/* 203 */     if (getRetailLocationId() != null) {
/* 204 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 206 */     if (getWorkstationId() != null) {
/* 207 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 209 */     if (getCreateDate() != null) {
/* 210 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 212 */     if (getCreateUserId() != null) {
/* 213 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 215 */     if (getUpdateDate() != null) {
/* 216 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 218 */     if (getUpdateUserId() != null) {
/* 219 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 221 */     if (getIpAddress() != null) {
/* 222 */       buf.append("ipAddress").append("=").append(getIpAddress()).append(" ");
/*     */     }
/* 224 */     if (getDateTimestamp() != null) {
/* 225 */       buf.append("dateTimestamp").append("=").append(getDateTimestamp()).append(" ");
/*     */     }
/* 227 */     if (getBusinessDate() != null) {
/* 228 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 230 */     if (getXtoreVersion() != null) {
/* 231 */       buf.append("xtoreVersion").append("=").append(getXtoreVersion()).append(" ");
/*     */     }
/* 233 */     if (getEnvVersion() != null) {
/* 234 */       buf.append("envVersion").append("=").append(getEnvVersion()).append(" ");
/*     */     }
/* 236 */     if (getActiveFlag() != null && getActiveFlag().booleanValue()) {
/* 237 */       buf.append("activeFlag").append("=").append(getActiveFlag()).append(" ");
/*     */     }
/* 239 */     if (getConfigVersion() != null) {
/* 240 */       buf.append("configVersion").append("=").append(getConfigVersion()).append(" ");
/*     */     }
/* 242 */     if (getPrimaryRegister() != null && getPrimaryRegister().booleanValue()) {
/* 243 */       buf.append("primaryRegister").append("=").append(getPrimaryRegister()).append(" ");
/*     */     }
/*     */     
/* 246 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 250 */     DeviceRegistrationId id = new DeviceRegistrationId();
/* 251 */     id.setOrganizationId(getOrganizationId());
/* 252 */     id.setRetailLocationId(getRetailLocationId());
/* 253 */     id.setWorkstationId(getWorkstationId());
/* 254 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 258 */     setOrganizationId(((DeviceRegistrationId)argObjectId).getOrganizationId());
/* 259 */     setRetailLocationId(((DeviceRegistrationId)argObjectId).getRetailLocationId());
/* 260 */     setWorkstationId(((DeviceRegistrationId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 264 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 268 */     StringBuilder buf = new StringBuilder(750);
/* 269 */     buf.append("<").append("dao").append(" name=\"DeviceRegistration\" cmd=\"" + getObjectStateString() + "\">");
/* 270 */     getFieldsAsXml(buf);
/* 271 */     buf.append("</").append("dao").append(">");
/*     */     
/* 273 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 277 */     Map<String, String> values = super.getValues();
/* 278 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 279 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 280 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 281 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 282 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 283 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 284 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 285 */     if (this._ipAddress != null) values.put("IpAddress", DaoUtils.getXmlSafeFieldValue(12, this._ipAddress)); 
/* 286 */     if (this._dateTimestamp != null) values.put("DateTimestamp", DaoUtils.getXmlSafeFieldValue(91, this._dateTimestamp)); 
/* 287 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 288 */     if (this._xtoreVersion != null) values.put("XtoreVersion", DaoUtils.getXmlSafeFieldValue(12, this._xtoreVersion)); 
/* 289 */     if (this._envVersion != null) values.put("EnvVersion", DaoUtils.getXmlSafeFieldValue(12, this._envVersion)); 
/* 290 */     if (this._activeFlag != null) values.put("ActiveFlag", DaoUtils.getXmlSafeFieldValue(-7, this._activeFlag)); 
/* 291 */     if (this._configVersion != null) values.put("ConfigVersion", DaoUtils.getXmlSafeFieldValue(12, this._configVersion)); 
/* 292 */     if (this._primaryRegister != null) values.put("PrimaryRegister", DaoUtils.getXmlSafeFieldValue(-7, this._primaryRegister)); 
/* 293 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 298 */     super.setValues(argValues);
/* 299 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 301 */       String fieldName = field.getKey();
/* 302 */       String fieldValue = field.getValue();
/* 303 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 308 */             setOrganizationId((Long)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 317 */             setRetailLocationId((Long)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 326 */             setWorkstationId((Long)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 335 */             setCreateDate((Date)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 344 */             setCreateUserId((String)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 353 */             setUpdateDate((Date)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 362 */             setUpdateUserId((String)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IpAddress":
/*     */           try {
/* 370 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 371 */             setIpAddress((String)value);
/* 372 */           } catch (Exception ee) {
/* 373 */             throw new DtxException("An exception occurred while calling setIpAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateTimestamp":
/*     */           try {
/* 379 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 380 */             setDateTimestamp((Date)value);
/* 381 */           } catch (Exception ee) {
/* 382 */             throw new DtxException("An exception occurred while calling setDateTimestamp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 388 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 389 */             setBusinessDate((Date)value);
/* 390 */           } catch (Exception ee) {
/* 391 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "XtoreVersion":
/*     */           try {
/* 397 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 398 */             setXtoreVersion((String)value);
/* 399 */           } catch (Exception ee) {
/* 400 */             throw new DtxException("An exception occurred while calling setXtoreVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EnvVersion":
/*     */           try {
/* 406 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 407 */             setEnvVersion((String)value);
/* 408 */           } catch (Exception ee) {
/* 409 */             throw new DtxException("An exception occurred while calling setEnvVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActiveFlag":
/*     */           try {
/* 415 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 416 */             setActiveFlag((Boolean)value);
/* 417 */           } catch (Exception ee) {
/* 418 */             throw new DtxException("An exception occurred while calling setActiveFlag() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigVersion":
/*     */           try {
/* 424 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 425 */             setConfigVersion((String)value);
/* 426 */           } catch (Exception ee) {
/* 427 */             throw new DtxException("An exception occurred while calling setConfigVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PrimaryRegister":
/*     */           try {
/* 433 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 434 */             setPrimaryRegister((Boolean)value);
/* 435 */           } catch (Exception ee) {
/* 436 */             throw new DtxException("An exception occurred while calling setPrimaryRegister() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\DeviceRegistrationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */