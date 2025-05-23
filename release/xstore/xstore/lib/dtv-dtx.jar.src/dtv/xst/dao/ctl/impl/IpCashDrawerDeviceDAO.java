/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.IpCashDrawerDeviceId;
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
/*     */ public class IpCashDrawerDeviceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1578154783L;
/*  23 */   private static final Logger _logger = Logger.getLogger(IpCashDrawerDeviceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _cashDrawerId;
/*     */   private String _drawerStatus;
/*     */   private String _productName;
/*     */   private String _description;
/*     */   private String _serialNumber;
/*     */   private String _ipAddress;
/*     */   private Long _tcpPort;
/*     */   private String _macAddress;
/*     */   private String _subnetMask;
/*     */   private String _gateway;
/*     */   private String _dnsHostName;
/*  38 */   private Boolean _dhcp = Boolean.FALSE;
/*     */   private String _firmwareVersion;
/*     */   private String _kup;
/*     */   private DtvDate _kupUpdateDate;
/*  42 */   private Boolean _beepOnOpen = Boolean.FALSE;
/*  43 */   private Boolean _beepLongOpen = Boolean.FALSE;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  50 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  54 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  55 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  60 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  64 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  65 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCashDrawerId() {
/*  70 */     return this._cashDrawerId;
/*     */   }
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/*  74 */     if (changed(argCashDrawerId, this._cashDrawerId, "cashDrawerId")) {
/*  75 */       this._cashDrawerId = (argCashDrawerId != null && MANAGE_CASE) ? argCashDrawerId.toUpperCase() : argCashDrawerId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDrawerStatus() {
/*  80 */     return this._drawerStatus;
/*     */   }
/*     */   
/*     */   public void setDrawerStatus(String argDrawerStatus) {
/*  84 */     if (changed(argDrawerStatus, this._drawerStatus, "drawerStatus")) {
/*  85 */       this._drawerStatus = argDrawerStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getProductName() {
/*  90 */     return this._productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String argProductName) {
/*  94 */     if (changed(argProductName, this._productName, "productName")) {
/*  95 */       this._productName = argProductName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 100 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 104 */     if (changed(argDescription, this._description, "description")) {
/* 105 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/* 110 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 114 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/* 115 */       this._serialNumber = argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIpAddress() {
/* 120 */     return this._ipAddress;
/*     */   }
/*     */   
/*     */   public void setIpAddress(String argIpAddress) {
/* 124 */     if (changed(argIpAddress, this._ipAddress, "ipAddress")) {
/* 125 */       this._ipAddress = argIpAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTcpPort() {
/* 130 */     return this._tcpPort;
/*     */   }
/*     */   
/*     */   public void setTcpPort(Long argTcpPort) {
/* 134 */     if (changed(argTcpPort, this._tcpPort, "tcpPort")) {
/* 135 */       this._tcpPort = argTcpPort;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMacAddress() {
/* 140 */     return this._macAddress;
/*     */   }
/*     */   
/*     */   public void setMacAddress(String argMacAddress) {
/* 144 */     if (changed(argMacAddress, this._macAddress, "macAddress")) {
/* 145 */       this._macAddress = argMacAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSubnetMask() {
/* 150 */     return this._subnetMask;
/*     */   }
/*     */   
/*     */   public void setSubnetMask(String argSubnetMask) {
/* 154 */     if (changed(argSubnetMask, this._subnetMask, "subnetMask")) {
/* 155 */       this._subnetMask = argSubnetMask;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getGateway() {
/* 160 */     return this._gateway;
/*     */   }
/*     */   
/*     */   public void setGateway(String argGateway) {
/* 164 */     if (changed(argGateway, this._gateway, "gateway")) {
/* 165 */       this._gateway = argGateway;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDnsHostName() {
/* 170 */     return this._dnsHostName;
/*     */   }
/*     */   
/*     */   public void setDnsHostName(String argDnsHostName) {
/* 174 */     if (changed(argDnsHostName, this._dnsHostName, "dnsHostName")) {
/* 175 */       this._dnsHostName = argDnsHostName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDhcp() {
/* 180 */     return this._dhcp;
/*     */   }
/*     */   
/*     */   public void setDhcp(Boolean argDhcp) {
/* 184 */     if (changed(argDhcp, this._dhcp, "dhcp")) {
/* 185 */       this._dhcp = argDhcp;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFirmwareVersion() {
/* 190 */     return this._firmwareVersion;
/*     */   }
/*     */   
/*     */   public void setFirmwareVersion(String argFirmwareVersion) {
/* 194 */     if (changed(argFirmwareVersion, this._firmwareVersion, "firmwareVersion")) {
/* 195 */       this._firmwareVersion = argFirmwareVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getKup() {
/* 200 */     return this._kup;
/*     */   }
/*     */   
/*     */   public void setKup(String argKup) {
/* 204 */     if (changed(argKup, this._kup, "kup")) {
/* 205 */       this._kup = argKup;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getKupUpdateDate() {
/* 210 */     return (Date)this._kupUpdateDate;
/*     */   }
/*     */   
/*     */   public void setKupUpdateDate(Date argKupUpdateDate) {
/* 214 */     if (changed(argKupUpdateDate, this._kupUpdateDate, "kupUpdateDate")) {
/* 215 */       this._kupUpdateDate = (argKupUpdateDate == null || argKupUpdateDate instanceof DtvDate) ? (DtvDate)argKupUpdateDate : new DtvDate(argKupUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getBeepOnOpen() {
/* 221 */     return this._beepOnOpen;
/*     */   }
/*     */   
/*     */   public void setBeepOnOpen(Boolean argBeepOnOpen) {
/* 225 */     if (changed(argBeepOnOpen, this._beepOnOpen, "beepOnOpen")) {
/* 226 */       this._beepOnOpen = argBeepOnOpen;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getBeepLongOpen() {
/* 231 */     return this._beepLongOpen;
/*     */   }
/*     */   
/*     */   public void setBeepLongOpen(Boolean argBeepLongOpen) {
/* 235 */     if (changed(argBeepLongOpen, this._beepLongOpen, "beepLongOpen")) {
/* 236 */       this._beepLongOpen = argBeepLongOpen;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 241 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 245 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 246 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 252 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 256 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 257 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 262 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 267 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 273 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 277 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 278 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 285 */     StringBuilder buf = new StringBuilder(512);
/* 286 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 287 */     if (getOrganizationId() != null) {
/* 288 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 290 */     if (getRetailLocationId() != null) {
/* 291 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 293 */     if (getCashDrawerId() != null) {
/* 294 */       buf.append("cashDrawerId").append("=").append(getCashDrawerId()).append(" ");
/*     */     }
/* 296 */     if (getDrawerStatus() != null) {
/* 297 */       buf.append("drawerStatus").append("=").append(getDrawerStatus()).append(" ");
/*     */     }
/* 299 */     if (getProductName() != null) {
/* 300 */       buf.append("productName").append("=").append(getProductName()).append(" ");
/*     */     }
/* 302 */     if (getDescription() != null) {
/* 303 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 305 */     if (getSerialNumber() != null) {
/* 306 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 308 */     if (getIpAddress() != null) {
/* 309 */       buf.append("ipAddress").append("=").append(getIpAddress()).append(" ");
/*     */     }
/* 311 */     if (getTcpPort() != null) {
/* 312 */       buf.append("tcpPort").append("=").append(getTcpPort()).append(" ");
/*     */     }
/* 314 */     if (getMacAddress() != null) {
/* 315 */       buf.append("macAddress").append("=").append(getMacAddress()).append(" ");
/*     */     }
/* 317 */     if (getSubnetMask() != null) {
/* 318 */       buf.append("subnetMask").append("=").append(getSubnetMask()).append(" ");
/*     */     }
/* 320 */     if (getGateway() != null) {
/* 321 */       buf.append("gateway").append("=").append(getGateway()).append(" ");
/*     */     }
/* 323 */     if (getDnsHostName() != null) {
/* 324 */       buf.append("dnsHostName").append("=").append(getDnsHostName()).append(" ");
/*     */     }
/* 326 */     if (getDhcp() != null && getDhcp().booleanValue()) {
/* 327 */       buf.append("dhcp").append("=").append(getDhcp()).append(" ");
/*     */     }
/* 329 */     if (getFirmwareVersion() != null) {
/* 330 */       buf.append("firmwareVersion").append("=").append(getFirmwareVersion()).append(" ");
/*     */     }
/* 332 */     if (getKup() != null) {
/* 333 */       buf.append("kup").append("=").append(getKup()).append(" ");
/*     */     }
/* 335 */     if (getKupUpdateDate() != null) {
/* 336 */       buf.append("kupUpdateDate").append("=").append(getKupUpdateDate()).append(" ");
/*     */     }
/* 338 */     if (getBeepOnOpen() != null && getBeepOnOpen().booleanValue()) {
/* 339 */       buf.append("beepOnOpen").append("=").append(getBeepOnOpen()).append(" ");
/*     */     }
/* 341 */     if (getBeepLongOpen() != null && getBeepLongOpen().booleanValue()) {
/* 342 */       buf.append("beepLongOpen").append("=").append(getBeepLongOpen()).append(" ");
/*     */     }
/* 344 */     if (getCreateDate() != null) {
/* 345 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 347 */     if (getCreateUserId() != null) {
/* 348 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 350 */     if (getUpdateDate() != null) {
/* 351 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 353 */     if (getUpdateUserId() != null) {
/* 354 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 357 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 361 */     IpCashDrawerDeviceId id = new IpCashDrawerDeviceId();
/* 362 */     id.setOrganizationId(getOrganizationId());
/* 363 */     id.setRetailLocationId(getRetailLocationId());
/* 364 */     id.setCashDrawerId(getCashDrawerId());
/* 365 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 369 */     setOrganizationId(((IpCashDrawerDeviceId)argObjectId).getOrganizationId());
/* 370 */     setRetailLocationId(((IpCashDrawerDeviceId)argObjectId).getRetailLocationId());
/* 371 */     setCashDrawerId(((IpCashDrawerDeviceId)argObjectId).getCashDrawerId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 375 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 379 */     StringBuilder buf = new StringBuilder(1150);
/* 380 */     buf.append("<").append("dao").append(" name=\"IpCashDrawerDevice\" cmd=\"" + getObjectStateString() + "\">");
/* 381 */     getFieldsAsXml(buf);
/* 382 */     buf.append("</").append("dao").append(">");
/*     */     
/* 384 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 388 */     Map<String, String> values = super.getValues();
/* 389 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 390 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 391 */     if (this._cashDrawerId != null) values.put("CashDrawerId", DaoUtils.getXmlSafeFieldValue(12, this._cashDrawerId)); 
/* 392 */     if (this._drawerStatus != null) values.put("DrawerStatus", DaoUtils.getXmlSafeFieldValue(12, this._drawerStatus)); 
/* 393 */     if (this._productName != null) values.put("ProductName", DaoUtils.getXmlSafeFieldValue(12, this._productName)); 
/* 394 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 395 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 396 */     if (this._ipAddress != null) values.put("IpAddress", DaoUtils.getXmlSafeFieldValue(12, this._ipAddress)); 
/* 397 */     if (this._tcpPort != null) values.put("TcpPort", DaoUtils.getXmlSafeFieldValue(-5, this._tcpPort)); 
/* 398 */     if (this._macAddress != null) values.put("MacAddress", DaoUtils.getXmlSafeFieldValue(12, this._macAddress)); 
/* 399 */     if (this._subnetMask != null) values.put("SubnetMask", DaoUtils.getXmlSafeFieldValue(12, this._subnetMask)); 
/* 400 */     if (this._gateway != null) values.put("Gateway", DaoUtils.getXmlSafeFieldValue(12, this._gateway)); 
/* 401 */     if (this._dnsHostName != null) values.put("DnsHostName", DaoUtils.getXmlSafeFieldValue(12, this._dnsHostName)); 
/* 402 */     if (this._dhcp != null) values.put("Dhcp", DaoUtils.getXmlSafeFieldValue(-7, this._dhcp)); 
/* 403 */     if (this._firmwareVersion != null) values.put("FirmwareVersion", DaoUtils.getXmlSafeFieldValue(12, this._firmwareVersion)); 
/* 404 */     if (this._kup != null) values.put("Kup", DaoUtils.getXmlSafeFieldValue(12, this._kup)); 
/* 405 */     if (this._kupUpdateDate != null) values.put("KupUpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._kupUpdateDate)); 
/* 406 */     if (this._beepOnOpen != null) values.put("BeepOnOpen", DaoUtils.getXmlSafeFieldValue(-7, this._beepOnOpen)); 
/* 407 */     if (this._beepLongOpen != null) values.put("BeepLongOpen", DaoUtils.getXmlSafeFieldValue(-7, this._beepLongOpen)); 
/* 408 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 409 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 410 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 411 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 412 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 417 */     super.setValues(argValues);
/* 418 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 420 */       String fieldName = field.getKey();
/* 421 */       String fieldValue = field.getValue();
/* 422 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 427 */             setOrganizationId((Long)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 436 */             setRetailLocationId((Long)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CashDrawerId":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 445 */             setCashDrawerId((String)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setCashDrawerId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DrawerStatus":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 454 */             setDrawerStatus((String)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setDrawerStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ProductName":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 463 */             setProductName((String)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setProductName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 471 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 472 */             setDescription((String)value);
/* 473 */           } catch (Exception ee) {
/* 474 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 480 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 481 */             setSerialNumber((String)value);
/* 482 */           } catch (Exception ee) {
/* 483 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IpAddress":
/*     */           try {
/* 489 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 490 */             setIpAddress((String)value);
/* 491 */           } catch (Exception ee) {
/* 492 */             throw new DtxException("An exception occurred while calling setIpAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TcpPort":
/*     */           try {
/* 498 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 499 */             setTcpPort((Long)value);
/* 500 */           } catch (Exception ee) {
/* 501 */             throw new DtxException("An exception occurred while calling setTcpPort() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MacAddress":
/*     */           try {
/* 507 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 508 */             setMacAddress((String)value);
/* 509 */           } catch (Exception ee) {
/* 510 */             throw new DtxException("An exception occurred while calling setMacAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SubnetMask":
/*     */           try {
/* 516 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 517 */             setSubnetMask((String)value);
/* 518 */           } catch (Exception ee) {
/* 519 */             throw new DtxException("An exception occurred while calling setSubnetMask() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Gateway":
/*     */           try {
/* 525 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 526 */             setGateway((String)value);
/* 527 */           } catch (Exception ee) {
/* 528 */             throw new DtxException("An exception occurred while calling setGateway() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DnsHostName":
/*     */           try {
/* 534 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 535 */             setDnsHostName((String)value);
/* 536 */           } catch (Exception ee) {
/* 537 */             throw new DtxException("An exception occurred while calling setDnsHostName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Dhcp":
/*     */           try {
/* 543 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 544 */             setDhcp((Boolean)value);
/* 545 */           } catch (Exception ee) {
/* 546 */             throw new DtxException("An exception occurred while calling setDhcp() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FirmwareVersion":
/*     */           try {
/* 552 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 553 */             setFirmwareVersion((String)value);
/* 554 */           } catch (Exception ee) {
/* 555 */             throw new DtxException("An exception occurred while calling setFirmwareVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Kup":
/*     */           try {
/* 561 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 562 */             setKup((String)value);
/* 563 */           } catch (Exception ee) {
/* 564 */             throw new DtxException("An exception occurred while calling setKup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "KupUpdateDate":
/*     */           try {
/* 570 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 571 */             setKupUpdateDate((Date)value);
/* 572 */           } catch (Exception ee) {
/* 573 */             throw new DtxException("An exception occurred while calling setKupUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeepOnOpen":
/*     */           try {
/* 579 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 580 */             setBeepOnOpen((Boolean)value);
/* 581 */           } catch (Exception ee) {
/* 582 */             throw new DtxException("An exception occurred while calling setBeepOnOpen() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeepLongOpen":
/*     */           try {
/* 588 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 589 */             setBeepLongOpen((Boolean)value);
/* 590 */           } catch (Exception ee) {
/* 591 */             throw new DtxException("An exception occurred while calling setBeepLongOpen() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 597 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 598 */             setCreateDate((Date)value);
/* 599 */           } catch (Exception ee) {
/* 600 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 606 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 607 */             setCreateUserId((String)value);
/* 608 */           } catch (Exception ee) {
/* 609 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 615 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 616 */             setUpdateDate((Date)value);
/* 617 */           } catch (Exception ee) {
/* 618 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 624 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 625 */             setUpdateUserId((String)value);
/* 626 */           } catch (Exception ee) {
/* 627 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\IpCashDrawerDeviceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */