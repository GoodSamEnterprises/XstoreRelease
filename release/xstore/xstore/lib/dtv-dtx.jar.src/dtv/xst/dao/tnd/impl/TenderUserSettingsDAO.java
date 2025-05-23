/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderUserSettingsId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderUserSettingsDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -576227806L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderUserSettingsDAO.class);
/*     */   
/*     */   private String _groupId;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private String _usageCode;
/*     */   private String _entryMethodCode;
/*     */   private String _configElement;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _maximumAcceptAmount;
/*     */   private BigDecimal _minimumAcceptAmount;
/*     */   private BigDecimal _offlineCeilingApprovalAmount;
/*     */   private BigDecimal _offlineFloorApprovalAmount;
/*     */   private BigDecimal _onlineCeilingApprovalAmount;
/*     */   private BigDecimal _onlineFloorApprovalAmount;
/*     */   private BigDecimal _overTenderLimit;
/*     */   private BigDecimal _maximumRefundWithReceiptAmount;
/*     */   private BigDecimal _maximumRefundWithoutReceiptAmount;
/*     */   
/*     */   public String getGroupId() {
/*  46 */     return this._groupId;
/*     */   }
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  50 */     if (changed(argGroupId, this._groupId, "groupId")) {
/*  51 */       this._groupId = (argGroupId != null && MANAGE_CASE) ? argGroupId.toUpperCase() : argGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  56 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  60 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  61 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  66 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  70 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  71 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUsageCode() {
/*  76 */     return this._usageCode;
/*     */   }
/*     */   
/*     */   public void setUsageCode(String argUsageCode) {
/*  80 */     if (changed(argUsageCode, this._usageCode, "usageCode")) {
/*  81 */       this._usageCode = (argUsageCode != null && MANAGE_CASE) ? argUsageCode.toUpperCase() : argUsageCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/*  86 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/*  90 */     if (changed(argEntryMethodCode, this._entryMethodCode, "entryMethodCode")) {
/*  91 */       this._entryMethodCode = (argEntryMethodCode != null && MANAGE_CASE) ? argEntryMethodCode.toUpperCase() : argEntryMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  96 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 100 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 101 */       this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
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
/*     */   public BigDecimal getMaximumAcceptAmount() {
/* 148 */     return this._maximumAcceptAmount;
/*     */   }
/*     */   
/*     */   public void setMaximumAcceptAmount(BigDecimal argMaximumAcceptAmount) {
/* 152 */     if (changed(argMaximumAcceptAmount, this._maximumAcceptAmount, "maximumAcceptAmount")) {
/* 153 */       this._maximumAcceptAmount = argMaximumAcceptAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinimumAcceptAmount() {
/* 158 */     return this._minimumAcceptAmount;
/*     */   }
/*     */   
/*     */   public void setMinimumAcceptAmount(BigDecimal argMinimumAcceptAmount) {
/* 162 */     if (changed(argMinimumAcceptAmount, this._minimumAcceptAmount, "minimumAcceptAmount")) {
/* 163 */       this._minimumAcceptAmount = argMinimumAcceptAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOfflineCeilingApprovalAmount() {
/* 168 */     return this._offlineCeilingApprovalAmount;
/*     */   }
/*     */   
/*     */   public void setOfflineCeilingApprovalAmount(BigDecimal argOfflineCeilingApprovalAmount) {
/* 172 */     if (changed(argOfflineCeilingApprovalAmount, this._offlineCeilingApprovalAmount, "offlineCeilingApprovalAmount")) {
/* 173 */       this._offlineCeilingApprovalAmount = argOfflineCeilingApprovalAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOfflineFloorApprovalAmount() {
/* 178 */     return this._offlineFloorApprovalAmount;
/*     */   }
/*     */   
/*     */   public void setOfflineFloorApprovalAmount(BigDecimal argOfflineFloorApprovalAmount) {
/* 182 */     if (changed(argOfflineFloorApprovalAmount, this._offlineFloorApprovalAmount, "offlineFloorApprovalAmount")) {
/* 183 */       this._offlineFloorApprovalAmount = argOfflineFloorApprovalAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOnlineCeilingApprovalAmount() {
/* 188 */     return this._onlineCeilingApprovalAmount;
/*     */   }
/*     */   
/*     */   public void setOnlineCeilingApprovalAmount(BigDecimal argOnlineCeilingApprovalAmount) {
/* 192 */     if (changed(argOnlineCeilingApprovalAmount, this._onlineCeilingApprovalAmount, "onlineCeilingApprovalAmount")) {
/* 193 */       this._onlineCeilingApprovalAmount = argOnlineCeilingApprovalAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOnlineFloorApprovalAmount() {
/* 198 */     return this._onlineFloorApprovalAmount;
/*     */   }
/*     */   
/*     */   public void setOnlineFloorApprovalAmount(BigDecimal argOnlineFloorApprovalAmount) {
/* 202 */     if (changed(argOnlineFloorApprovalAmount, this._onlineFloorApprovalAmount, "onlineFloorApprovalAmount")) {
/* 203 */       this._onlineFloorApprovalAmount = argOnlineFloorApprovalAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOverTenderLimit() {
/* 208 */     return this._overTenderLimit;
/*     */   }
/*     */   
/*     */   public void setOverTenderLimit(BigDecimal argOverTenderLimit) {
/* 212 */     if (changed(argOverTenderLimit, this._overTenderLimit, "overTenderLimit")) {
/* 213 */       this._overTenderLimit = argOverTenderLimit;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaximumRefundWithReceiptAmount() {
/* 218 */     return this._maximumRefundWithReceiptAmount;
/*     */   }
/*     */   
/*     */   public void setMaximumRefundWithReceiptAmount(BigDecimal argMaximumRefundWithReceiptAmount) {
/* 222 */     if (changed(argMaximumRefundWithReceiptAmount, this._maximumRefundWithReceiptAmount, "maximumRefundWithReceiptAmount")) {
/* 223 */       this._maximumRefundWithReceiptAmount = argMaximumRefundWithReceiptAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaximumRefundWithoutReceiptAmount() {
/* 228 */     return this._maximumRefundWithoutReceiptAmount;
/*     */   }
/*     */   
/*     */   public void setMaximumRefundWithoutReceiptAmount(BigDecimal argMaximumRefundWithoutReceiptAmount) {
/* 232 */     if (changed(argMaximumRefundWithoutReceiptAmount, this._maximumRefundWithoutReceiptAmount, "maximumRefundWithoutReceiptAmount")) {
/* 233 */       this._maximumRefundWithoutReceiptAmount = argMaximumRefundWithoutReceiptAmount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 240 */     StringBuilder buf = new StringBuilder(512);
/* 241 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 242 */     if (getGroupId() != null) {
/* 243 */       buf.append("groupId").append("=").append(getGroupId()).append(" ");
/*     */     }
/* 245 */     if (getOrganizationId() != null) {
/* 246 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 248 */     if (getTenderId() != null) {
/* 249 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 251 */     if (getUsageCode() != null) {
/* 252 */       buf.append("usageCode").append("=").append(getUsageCode()).append(" ");
/*     */     }
/* 254 */     if (getEntryMethodCode() != null) {
/* 255 */       buf.append("entryMethodCode").append("=").append(getEntryMethodCode()).append(" ");
/*     */     }
/* 257 */     if (getConfigElement() != null) {
/* 258 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 260 */     if (getCreateDate() != null) {
/* 261 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 263 */     if (getCreateUserId() != null) {
/* 264 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 266 */     if (getUpdateDate() != null) {
/* 267 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 269 */     if (getUpdateUserId() != null) {
/* 270 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 272 */     if (getMaximumAcceptAmount() != null) {
/* 273 */       buf.append("maximumAcceptAmount").append("=").append(getMaximumAcceptAmount()).append(" ");
/*     */     }
/* 275 */     if (getMinimumAcceptAmount() != null) {
/* 276 */       buf.append("minimumAcceptAmount").append("=").append(getMinimumAcceptAmount()).append(" ");
/*     */     }
/* 278 */     if (getOfflineCeilingApprovalAmount() != null) {
/* 279 */       buf.append("offlineCeilingApprovalAmount").append("=").append(getOfflineCeilingApprovalAmount()).append(" ");
/*     */     }
/* 281 */     if (getOfflineFloorApprovalAmount() != null) {
/* 282 */       buf.append("offlineFloorApprovalAmount").append("=").append(getOfflineFloorApprovalAmount()).append(" ");
/*     */     }
/* 284 */     if (getOnlineCeilingApprovalAmount() != null) {
/* 285 */       buf.append("onlineCeilingApprovalAmount").append("=").append(getOnlineCeilingApprovalAmount()).append(" ");
/*     */     }
/* 287 */     if (getOnlineFloorApprovalAmount() != null) {
/* 288 */       buf.append("onlineFloorApprovalAmount").append("=").append(getOnlineFloorApprovalAmount()).append(" ");
/*     */     }
/* 290 */     if (getOverTenderLimit() != null) {
/* 291 */       buf.append("overTenderLimit").append("=").append(getOverTenderLimit()).append(" ");
/*     */     }
/* 293 */     if (getMaximumRefundWithReceiptAmount() != null) {
/* 294 */       buf.append("maximumRefundWithReceiptAmount").append("=").append(getMaximumRefundWithReceiptAmount()).append(" ");
/*     */     }
/* 296 */     if (getMaximumRefundWithoutReceiptAmount() != null) {
/* 297 */       buf.append("maximumRefundWithoutReceiptAmount").append("=").append(getMaximumRefundWithoutReceiptAmount()).append(" ");
/*     */     }
/*     */     
/* 300 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 304 */     TenderUserSettingsId id = new TenderUserSettingsId();
/* 305 */     id.setGroupId(getGroupId());
/* 306 */     id.setOrganizationId(getOrganizationId());
/* 307 */     id.setTenderId(getTenderId());
/* 308 */     id.setUsageCode(getUsageCode());
/* 309 */     id.setEntryMethodCode(getEntryMethodCode());
/* 310 */     id.setConfigElement(getConfigElement());
/* 311 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 315 */     setGroupId(((TenderUserSettingsId)argObjectId).getGroupId());
/* 316 */     setOrganizationId(((TenderUserSettingsId)argObjectId).getOrganizationId());
/* 317 */     setTenderId(((TenderUserSettingsId)argObjectId).getTenderId());
/* 318 */     setUsageCode(((TenderUserSettingsId)argObjectId).getUsageCode());
/* 319 */     setEntryMethodCode(((TenderUserSettingsId)argObjectId).getEntryMethodCode());
/* 320 */     setConfigElement(((TenderUserSettingsId)argObjectId).getConfigElement());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 324 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 328 */     StringBuilder buf = new StringBuilder(950);
/* 329 */     buf.append("<").append("dao").append(" name=\"TenderUserSettings\" cmd=\"" + getObjectStateString() + "\">");
/* 330 */     getFieldsAsXml(buf);
/* 331 */     buf.append("</").append("dao").append(">");
/*     */     
/* 333 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 337 */     Map<String, String> values = super.getValues();
/* 338 */     if (this._groupId != null) values.put("GroupId", DaoUtils.getXmlSafeFieldValue(12, this._groupId)); 
/* 339 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 340 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 341 */     if (this._usageCode != null) values.put("UsageCode", DaoUtils.getXmlSafeFieldValue(12, this._usageCode)); 
/* 342 */     if (this._entryMethodCode != null) values.put("EntryMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._entryMethodCode)); 
/* 343 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 344 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 345 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 346 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 347 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 348 */     if (this._maximumAcceptAmount != null) values.put("MaximumAcceptAmount", DaoUtils.getXmlSafeFieldValue(3, this._maximumAcceptAmount)); 
/* 349 */     if (this._minimumAcceptAmount != null) values.put("MinimumAcceptAmount", DaoUtils.getXmlSafeFieldValue(3, this._minimumAcceptAmount)); 
/* 350 */     if (this._offlineCeilingApprovalAmount != null) values.put("OfflineCeilingApprovalAmount", DaoUtils.getXmlSafeFieldValue(3, this._offlineCeilingApprovalAmount)); 
/* 351 */     if (this._offlineFloorApprovalAmount != null) values.put("OfflineFloorApprovalAmount", DaoUtils.getXmlSafeFieldValue(3, this._offlineFloorApprovalAmount)); 
/* 352 */     if (this._onlineCeilingApprovalAmount != null) values.put("OnlineCeilingApprovalAmount", DaoUtils.getXmlSafeFieldValue(3, this._onlineCeilingApprovalAmount)); 
/* 353 */     if (this._onlineFloorApprovalAmount != null) values.put("OnlineFloorApprovalAmount", DaoUtils.getXmlSafeFieldValue(3, this._onlineFloorApprovalAmount)); 
/* 354 */     if (this._overTenderLimit != null) values.put("OverTenderLimit", DaoUtils.getXmlSafeFieldValue(3, this._overTenderLimit)); 
/* 355 */     if (this._maximumRefundWithReceiptAmount != null) values.put("MaximumRefundWithReceiptAmount", DaoUtils.getXmlSafeFieldValue(3, this._maximumRefundWithReceiptAmount)); 
/* 356 */     if (this._maximumRefundWithoutReceiptAmount != null) values.put("MaximumRefundWithoutReceiptAmount", DaoUtils.getXmlSafeFieldValue(3, this._maximumRefundWithoutReceiptAmount)); 
/* 357 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 362 */     super.setValues(argValues);
/* 363 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 365 */       String fieldName = field.getKey();
/* 366 */       String fieldValue = field.getValue();
/* 367 */       switch (fieldName) {
/*     */         
/*     */         case "GroupId":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setGroupId((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 381 */             setOrganizationId((Long)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setTenderId((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UsageCode":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setUsageCode((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setUsageCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EntryMethodCode":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 408 */             setEntryMethodCode((String)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setEntryMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 416 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 417 */             setConfigElement((String)value);
/* 418 */           } catch (Exception ee) {
/* 419 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 425 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 426 */             setCreateDate((Date)value);
/* 427 */           } catch (Exception ee) {
/* 428 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 434 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 435 */             setCreateUserId((String)value);
/* 436 */           } catch (Exception ee) {
/* 437 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 443 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 444 */             setUpdateDate((Date)value);
/* 445 */           } catch (Exception ee) {
/* 446 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 452 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 453 */             setUpdateUserId((String)value);
/* 454 */           } catch (Exception ee) {
/* 455 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumAcceptAmount":
/*     */           try {
/* 461 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 462 */             setMaximumAcceptAmount((BigDecimal)value);
/* 463 */           } catch (Exception ee) {
/* 464 */             throw new DtxException("An exception occurred while calling setMaximumAcceptAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumAcceptAmount":
/*     */           try {
/* 470 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 471 */             setMinimumAcceptAmount((BigDecimal)value);
/* 472 */           } catch (Exception ee) {
/* 473 */             throw new DtxException("An exception occurred while calling setMinimumAcceptAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OfflineCeilingApprovalAmount":
/*     */           try {
/* 479 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 480 */             setOfflineCeilingApprovalAmount((BigDecimal)value);
/* 481 */           } catch (Exception ee) {
/* 482 */             throw new DtxException("An exception occurred while calling setOfflineCeilingApprovalAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OfflineFloorApprovalAmount":
/*     */           try {
/* 488 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 489 */             setOfflineFloorApprovalAmount((BigDecimal)value);
/* 490 */           } catch (Exception ee) {
/* 491 */             throw new DtxException("An exception occurred while calling setOfflineFloorApprovalAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OnlineCeilingApprovalAmount":
/*     */           try {
/* 497 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 498 */             setOnlineCeilingApprovalAmount((BigDecimal)value);
/* 499 */           } catch (Exception ee) {
/* 500 */             throw new DtxException("An exception occurred while calling setOnlineCeilingApprovalAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OnlineFloorApprovalAmount":
/*     */           try {
/* 506 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 507 */             setOnlineFloorApprovalAmount((BigDecimal)value);
/* 508 */           } catch (Exception ee) {
/* 509 */             throw new DtxException("An exception occurred while calling setOnlineFloorApprovalAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OverTenderLimit":
/*     */           try {
/* 515 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 516 */             setOverTenderLimit((BigDecimal)value);
/* 517 */           } catch (Exception ee) {
/* 518 */             throw new DtxException("An exception occurred while calling setOverTenderLimit() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumRefundWithReceiptAmount":
/*     */           try {
/* 524 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 525 */             setMaximumRefundWithReceiptAmount((BigDecimal)value);
/* 526 */           } catch (Exception ee) {
/* 527 */             throw new DtxException("An exception occurred while calling setMaximumRefundWithReceiptAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumRefundWithoutReceiptAmount":
/*     */           try {
/* 533 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 534 */             setMaximumRefundWithoutReceiptAmount((BigDecimal)value);
/* 535 */           } catch (Exception ee) {
/* 536 */             throw new DtxException("An exception occurred while calling setMaximumRefundWithoutReceiptAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderUserSettingsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */