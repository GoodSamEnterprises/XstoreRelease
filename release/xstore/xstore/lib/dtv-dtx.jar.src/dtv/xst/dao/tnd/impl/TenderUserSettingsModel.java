/*     */ package dtv.xst.dao.tnd.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.tnd.ITenderUserSettings;
/*     */ import dtv.xst.dao.tnd.ITenderUserSettingsProperty;
/*     */ import dtv.xst.dao.tnd.TenderUserSettingsPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderUserSettingsModel extends AbstractDataModelWithPropertyImpl<ITenderUserSettingsProperty> implements ITenderUserSettings {
/*     */   private static final long serialVersionUID = -576227806L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITenderUserSettingsProperty> _properties; private transient HistoricalList<ITenderUserSettingsProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TenderUserSettingsDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderUserSettingsDAO getDAO_() {
/*  46 */     return (TenderUserSettingsDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupId() {
/*  54 */     return getDAO_().getGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  62 */     if (setGroupId_noev(argGroupId) && 
/*  63 */       this._events != null && 
/*  64 */       postEventsForChanges()) {
/*  65 */       this._events.post(ITenderUserSettings.SET_GROUPID, argGroupId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGroupId_noev(String argGroupId) {
/*  72 */     boolean ev_postable = false;
/*     */     
/*  74 */     if ((getDAO_().getGroupId() == null && argGroupId != null) || (
/*  75 */       getDAO_().getGroupId() != null && !getDAO_().getGroupId().equals(argGroupId))) {
/*  76 */       getDAO_().setGroupId(argGroupId);
/*  77 */       ev_postable = true;
/*  78 */       if (this._properties != null) {
/*     */         
/*  80 */         Iterator<TenderUserSettingsPropertyModel> it = this._properties.iterator();
/*  81 */         while (it.hasNext())
/*     */         {
/*  83 */           ((TenderUserSettingsPropertyModel)it.next()).setGroupId_noev(argGroupId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  96 */     if (getDAO_().getOrganizationId() != null) {
/*  97 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 100 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 109 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITenderUserSettings.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 122 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 123 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TenderUserSettingsPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TenderUserSettingsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/* 143 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 151 */     if (setTenderId_noev(argTenderId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ITenderUserSettings.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 164 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 165 */       getDAO_().setTenderId(argTenderId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<TenderUserSettingsPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((TenderUserSettingsPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsageCode() {
/* 185 */     return getDAO_().getUsageCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsageCode(String argUsageCode) {
/* 193 */     if (setUsageCode_noev(argUsageCode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(ITenderUserSettings.SET_USAGECODE, argUsageCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUsageCode_noev(String argUsageCode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getUsageCode() == null && argUsageCode != null) || (
/* 206 */       getDAO_().getUsageCode() != null && !getDAO_().getUsageCode().equals(argUsageCode))) {
/* 207 */       getDAO_().setUsageCode(argUsageCode);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<TenderUserSettingsPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((TenderUserSettingsPropertyModel)it.next()).setUsageCode_noev(argUsageCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntryMethodCode() {
/* 227 */     return getDAO_().getEntryMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 235 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(ITenderUserSettings.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/* 248 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/* 249 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
/* 250 */       ev_postable = true;
/* 251 */       if (this._properties != null) {
/*     */         
/* 253 */         Iterator<TenderUserSettingsPropertyModel> it = this._properties.iterator();
/* 254 */         while (it.hasNext())
/*     */         {
/* 256 */           ((TenderUserSettingsPropertyModel)it.next()).setEntryMethodCode_noev(argEntryMethodCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigElement() {
/* 269 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 277 */     if (setConfigElement_noev(argConfigElement) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(ITenderUserSettings.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 290 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 291 */       getDAO_().setConfigElement(argConfigElement);
/* 292 */       ev_postable = true;
/* 293 */       if (this._properties != null) {
/*     */         
/* 295 */         Iterator<TenderUserSettingsPropertyModel> it = this._properties.iterator();
/* 296 */         while (it.hasNext())
/*     */         {
/* 298 */           ((TenderUserSettingsPropertyModel)it.next()).setConfigElement_noev(argConfigElement);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 303 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 311 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 319 */     if (setCreateDate_noev(argCreateDate) && 
/* 320 */       this._events != null && 
/* 321 */       postEventsForChanges()) {
/* 322 */       this._events.post(ITenderUserSettings.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 329 */     boolean ev_postable = false;
/*     */     
/* 331 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 332 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 333 */       getDAO_().setCreateDate(argCreateDate);
/* 334 */       ev_postable = true;
/*     */     } 
/*     */     
/* 337 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 345 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 353 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 354 */       this._events != null && 
/* 355 */       postEventsForChanges()) {
/* 356 */       this._events.post(ITenderUserSettings.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 363 */     boolean ev_postable = false;
/*     */     
/* 365 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 366 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 367 */       getDAO_().setCreateUserId(argCreateUserId);
/* 368 */       ev_postable = true;
/*     */     } 
/*     */     
/* 371 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 379 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 387 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 388 */       this._events != null && 
/* 389 */       postEventsForChanges()) {
/* 390 */       this._events.post(ITenderUserSettings.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 397 */     boolean ev_postable = false;
/*     */     
/* 399 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 400 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 401 */       getDAO_().setUpdateDate(argUpdateDate);
/* 402 */       ev_postable = true;
/*     */     } 
/*     */     
/* 405 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 413 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 421 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 422 */       this._events != null && 
/* 423 */       postEventsForChanges()) {
/* 424 */       this._events.post(ITenderUserSettings.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 431 */     boolean ev_postable = false;
/*     */     
/* 433 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 434 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 435 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 436 */       ev_postable = true;
/*     */     } 
/*     */     
/* 439 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaximumAcceptAmount() {
/* 447 */     return getDAO_().getMaximumAcceptAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumAcceptAmount(BigDecimal argMaximumAcceptAmount) {
/* 455 */     if (setMaximumAcceptAmount_noev(argMaximumAcceptAmount) && 
/* 456 */       this._events != null && 
/* 457 */       postEventsForChanges()) {
/* 458 */       this._events.post(ITenderUserSettings.SET_MAXIMUMACCEPTAMOUNT, argMaximumAcceptAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaximumAcceptAmount_noev(BigDecimal argMaximumAcceptAmount) {
/* 465 */     boolean ev_postable = false;
/*     */     
/* 467 */     if ((getDAO_().getMaximumAcceptAmount() == null && argMaximumAcceptAmount != null) || (
/* 468 */       getDAO_().getMaximumAcceptAmount() != null && !getDAO_().getMaximumAcceptAmount().equals(argMaximumAcceptAmount))) {
/* 469 */       getDAO_().setMaximumAcceptAmount(argMaximumAcceptAmount);
/* 470 */       ev_postable = true;
/*     */     } 
/*     */     
/* 473 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMinimumAcceptAmount() {
/* 481 */     return getDAO_().getMinimumAcceptAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumAcceptAmount(BigDecimal argMinimumAcceptAmount) {
/* 489 */     if (setMinimumAcceptAmount_noev(argMinimumAcceptAmount) && 
/* 490 */       this._events != null && 
/* 491 */       postEventsForChanges()) {
/* 492 */       this._events.post(ITenderUserSettings.SET_MINIMUMACCEPTAMOUNT, argMinimumAcceptAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinimumAcceptAmount_noev(BigDecimal argMinimumAcceptAmount) {
/* 499 */     boolean ev_postable = false;
/*     */     
/* 501 */     if ((getDAO_().getMinimumAcceptAmount() == null && argMinimumAcceptAmount != null) || (
/* 502 */       getDAO_().getMinimumAcceptAmount() != null && !getDAO_().getMinimumAcceptAmount().equals(argMinimumAcceptAmount))) {
/* 503 */       getDAO_().setMinimumAcceptAmount(argMinimumAcceptAmount);
/* 504 */       ev_postable = true;
/*     */     } 
/*     */     
/* 507 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOfflineCeilingApprovalAmount() {
/* 515 */     return getDAO_().getOfflineCeilingApprovalAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOfflineCeilingApprovalAmount(BigDecimal argOfflineCeilingApprovalAmount) {
/* 523 */     if (setOfflineCeilingApprovalAmount_noev(argOfflineCeilingApprovalAmount) && 
/* 524 */       this._events != null && 
/* 525 */       postEventsForChanges()) {
/* 526 */       this._events.post(ITenderUserSettings.SET_OFFLINECEILINGAPPROVALAMOUNT, argOfflineCeilingApprovalAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOfflineCeilingApprovalAmount_noev(BigDecimal argOfflineCeilingApprovalAmount) {
/* 533 */     boolean ev_postable = false;
/*     */     
/* 535 */     if ((getDAO_().getOfflineCeilingApprovalAmount() == null && argOfflineCeilingApprovalAmount != null) || (
/* 536 */       getDAO_().getOfflineCeilingApprovalAmount() != null && !getDAO_().getOfflineCeilingApprovalAmount().equals(argOfflineCeilingApprovalAmount))) {
/* 537 */       getDAO_().setOfflineCeilingApprovalAmount(argOfflineCeilingApprovalAmount);
/* 538 */       ev_postable = true;
/*     */     } 
/*     */     
/* 541 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOfflineFloorApprovalAmount() {
/* 549 */     return getDAO_().getOfflineFloorApprovalAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOfflineFloorApprovalAmount(BigDecimal argOfflineFloorApprovalAmount) {
/* 557 */     if (setOfflineFloorApprovalAmount_noev(argOfflineFloorApprovalAmount) && 
/* 558 */       this._events != null && 
/* 559 */       postEventsForChanges()) {
/* 560 */       this._events.post(ITenderUserSettings.SET_OFFLINEFLOORAPPROVALAMOUNT, argOfflineFloorApprovalAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOfflineFloorApprovalAmount_noev(BigDecimal argOfflineFloorApprovalAmount) {
/* 567 */     boolean ev_postable = false;
/*     */     
/* 569 */     if ((getDAO_().getOfflineFloorApprovalAmount() == null && argOfflineFloorApprovalAmount != null) || (
/* 570 */       getDAO_().getOfflineFloorApprovalAmount() != null && !getDAO_().getOfflineFloorApprovalAmount().equals(argOfflineFloorApprovalAmount))) {
/* 571 */       getDAO_().setOfflineFloorApprovalAmount(argOfflineFloorApprovalAmount);
/* 572 */       ev_postable = true;
/*     */     } 
/*     */     
/* 575 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOnlineCeilingApprovalAmount() {
/* 583 */     return getDAO_().getOnlineCeilingApprovalAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnlineCeilingApprovalAmount(BigDecimal argOnlineCeilingApprovalAmount) {
/* 591 */     if (setOnlineCeilingApprovalAmount_noev(argOnlineCeilingApprovalAmount) && 
/* 592 */       this._events != null && 
/* 593 */       postEventsForChanges()) {
/* 594 */       this._events.post(ITenderUserSettings.SET_ONLINECEILINGAPPROVALAMOUNT, argOnlineCeilingApprovalAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOnlineCeilingApprovalAmount_noev(BigDecimal argOnlineCeilingApprovalAmount) {
/* 601 */     boolean ev_postable = false;
/*     */     
/* 603 */     if ((getDAO_().getOnlineCeilingApprovalAmount() == null && argOnlineCeilingApprovalAmount != null) || (
/* 604 */       getDAO_().getOnlineCeilingApprovalAmount() != null && !getDAO_().getOnlineCeilingApprovalAmount().equals(argOnlineCeilingApprovalAmount))) {
/* 605 */       getDAO_().setOnlineCeilingApprovalAmount(argOnlineCeilingApprovalAmount);
/* 606 */       ev_postable = true;
/*     */     } 
/*     */     
/* 609 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOnlineFloorApprovalAmount() {
/* 617 */     return getDAO_().getOnlineFloorApprovalAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnlineFloorApprovalAmount(BigDecimal argOnlineFloorApprovalAmount) {
/* 625 */     if (setOnlineFloorApprovalAmount_noev(argOnlineFloorApprovalAmount) && 
/* 626 */       this._events != null && 
/* 627 */       postEventsForChanges()) {
/* 628 */       this._events.post(ITenderUserSettings.SET_ONLINEFLOORAPPROVALAMOUNT, argOnlineFloorApprovalAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOnlineFloorApprovalAmount_noev(BigDecimal argOnlineFloorApprovalAmount) {
/* 635 */     boolean ev_postable = false;
/*     */     
/* 637 */     if ((getDAO_().getOnlineFloorApprovalAmount() == null && argOnlineFloorApprovalAmount != null) || (
/* 638 */       getDAO_().getOnlineFloorApprovalAmount() != null && !getDAO_().getOnlineFloorApprovalAmount().equals(argOnlineFloorApprovalAmount))) {
/* 639 */       getDAO_().setOnlineFloorApprovalAmount(argOnlineFloorApprovalAmount);
/* 640 */       ev_postable = true;
/*     */     } 
/*     */     
/* 643 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOverTenderLimit() {
/* 651 */     return getDAO_().getOverTenderLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverTenderLimit(BigDecimal argOverTenderLimit) {
/* 659 */     if (setOverTenderLimit_noev(argOverTenderLimit) && 
/* 660 */       this._events != null && 
/* 661 */       postEventsForChanges()) {
/* 662 */       this._events.post(ITenderUserSettings.SET_OVERTENDERLIMIT, argOverTenderLimit);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOverTenderLimit_noev(BigDecimal argOverTenderLimit) {
/* 669 */     boolean ev_postable = false;
/*     */     
/* 671 */     if ((getDAO_().getOverTenderLimit() == null && argOverTenderLimit != null) || (
/* 672 */       getDAO_().getOverTenderLimit() != null && !getDAO_().getOverTenderLimit().equals(argOverTenderLimit))) {
/* 673 */       getDAO_().setOverTenderLimit(argOverTenderLimit);
/* 674 */       ev_postable = true;
/*     */     } 
/*     */     
/* 677 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaximumRefundWithReceiptAmount() {
/* 685 */     return getDAO_().getMaximumRefundWithReceiptAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumRefundWithReceiptAmount(BigDecimal argMaximumRefundWithReceiptAmount) {
/* 693 */     if (setMaximumRefundWithReceiptAmount_noev(argMaximumRefundWithReceiptAmount) && 
/* 694 */       this._events != null && 
/* 695 */       postEventsForChanges()) {
/* 696 */       this._events.post(ITenderUserSettings.SET_MAXIMUMREFUNDWITHRECEIPTAMOUNT, argMaximumRefundWithReceiptAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaximumRefundWithReceiptAmount_noev(BigDecimal argMaximumRefundWithReceiptAmount) {
/* 703 */     boolean ev_postable = false;
/*     */     
/* 705 */     if ((getDAO_().getMaximumRefundWithReceiptAmount() == null && argMaximumRefundWithReceiptAmount != null) || (
/* 706 */       getDAO_().getMaximumRefundWithReceiptAmount() != null && !getDAO_().getMaximumRefundWithReceiptAmount().equals(argMaximumRefundWithReceiptAmount))) {
/* 707 */       getDAO_().setMaximumRefundWithReceiptAmount(argMaximumRefundWithReceiptAmount);
/* 708 */       ev_postable = true;
/*     */     } 
/*     */     
/* 711 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaximumRefundWithoutReceiptAmount() {
/* 719 */     return getDAO_().getMaximumRefundWithoutReceiptAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumRefundWithoutReceiptAmount(BigDecimal argMaximumRefundWithoutReceiptAmount) {
/* 727 */     if (setMaximumRefundWithoutReceiptAmount_noev(argMaximumRefundWithoutReceiptAmount) && 
/* 728 */       this._events != null && 
/* 729 */       postEventsForChanges()) {
/* 730 */       this._events.post(ITenderUserSettings.SET_MAXIMUMREFUNDWITHOUTRECEIPTAMOUNT, argMaximumRefundWithoutReceiptAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaximumRefundWithoutReceiptAmount_noev(BigDecimal argMaximumRefundWithoutReceiptAmount) {
/* 737 */     boolean ev_postable = false;
/*     */     
/* 739 */     if ((getDAO_().getMaximumRefundWithoutReceiptAmount() == null && argMaximumRefundWithoutReceiptAmount != null) || (
/* 740 */       getDAO_().getMaximumRefundWithoutReceiptAmount() != null && !getDAO_().getMaximumRefundWithoutReceiptAmount().equals(argMaximumRefundWithoutReceiptAmount))) {
/* 741 */       getDAO_().setMaximumRefundWithoutReceiptAmount(argMaximumRefundWithoutReceiptAmount);
/* 742 */       ev_postable = true;
/*     */     } 
/*     */     
/* 745 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderUserSettingsProperty newProperty(String argPropertyName) {
/* 749 */     TenderUserSettingsPropertyId id = new TenderUserSettingsPropertyId();
/*     */     
/* 751 */     id.setGroupId(getGroupId());
/* 752 */     id.setTenderId(getTenderId());
/* 753 */     id.setUsageCode(getUsageCode());
/* 754 */     id.setEntryMethodCode(getEntryMethodCode());
/* 755 */     id.setConfigElement(getConfigElement());
/* 756 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 758 */     ITenderUserSettingsProperty prop = (ITenderUserSettingsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderUserSettingsProperty.class);
/* 759 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderUserSettingsProperty> getProperties() {
/* 768 */     if (this._properties == null) {
/* 769 */       this._properties = new HistoricalList(null);
/*     */     }
/* 771 */     return (List<ITenderUserSettingsProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderUserSettingsProperty> argProperties) {
/* 775 */     if (this._properties == null) {
/* 776 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 778 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 781 */     for (ITenderUserSettingsProperty child : this._properties) {
/* 782 */       TenderUserSettingsPropertyModel model = (TenderUserSettingsPropertyModel)child;
/* 783 */       model.setGroupId_noev(getGroupId());
/* 784 */       model.setOrganizationId_noev(getOrganizationId());
/* 785 */       model.setTenderId_noev(getTenderId());
/* 786 */       model.setUsageCode_noev(getUsageCode());
/* 787 */       model.setEntryMethodCode_noev(getEntryMethodCode());
/* 788 */       model.setConfigElement_noev(getConfigElement());
/* 789 */       if (child instanceof IDataModelImpl) {
/* 790 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 791 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 792 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 793 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 796 */       if (postEventsForChanges()) {
/* 797 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderUserSettingsProperty(ITenderUserSettingsProperty argTenderUserSettingsProperty) {
/* 803 */     if (this._properties == null) {
/* 804 */       this._properties = new HistoricalList(null);
/*     */     }
/* 806 */     argTenderUserSettingsProperty.setGroupId(getGroupId());
/* 807 */     argTenderUserSettingsProperty.setOrganizationId(getOrganizationId());
/* 808 */     argTenderUserSettingsProperty.setTenderId(getTenderId());
/* 809 */     argTenderUserSettingsProperty.setUsageCode(getUsageCode());
/* 810 */     argTenderUserSettingsProperty.setEntryMethodCode(getEntryMethodCode());
/* 811 */     argTenderUserSettingsProperty.setConfigElement(getConfigElement());
/* 812 */     if (argTenderUserSettingsProperty instanceof IDataModelImpl) {
/* 813 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderUserSettingsProperty).getDAO();
/* 814 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 815 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 816 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 821 */     if (postEventsForChanges()) {
/* 822 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderUserSettingsProperty));
/*     */     }
/*     */     
/* 825 */     this._properties.add(argTenderUserSettingsProperty);
/* 826 */     if (postEventsForChanges()) {
/* 827 */       this._events.post(ITenderUserSettings.ADD_PROPERTIES, argTenderUserSettingsProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderUserSettingsProperty(ITenderUserSettingsProperty argTenderUserSettingsProperty) {
/* 832 */     if (this._properties != null) {
/*     */       
/* 834 */       if (postEventsForChanges()) {
/* 835 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderUserSettingsProperty));
/*     */       }
/* 837 */       this._properties.remove(argTenderUserSettingsProperty);
/* 838 */       if (postEventsForChanges()) {
/* 839 */         this._events.post(ITenderUserSettings.REMOVE_PROPERTIES, argTenderUserSettingsProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 846 */     if ("Properties".equals(argFieldId)) {
/* 847 */       return getProperties();
/*     */     }
/* 849 */     if ("TenderUserSettingsExtension".equals(argFieldId)) {
/* 850 */       return this._myExtension;
/*     */     }
/*     */     
/* 853 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 859 */     if ("Properties".equals(argFieldId)) {
/* 860 */       setProperties(changeToList(argValue, ITenderUserSettingsProperty.class));
/*     */     }
/* 862 */     else if ("TenderUserSettingsExtension".equals(argFieldId)) {
/* 863 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 866 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 872 */     this._persistenceDefaults = argPD;
/* 873 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 874 */     this._eventManager = argEM;
/* 875 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 876 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 877 */     if (this._properties != null) {
/* 878 */       for (ITenderUserSettingsProperty relationship : this._properties) {
/* 879 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderUserSettingsExt() {
/* 885 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderUserSettingsExt(IDataModel argExt) {
/* 889 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 894 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 898 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 901 */     super.startTransaction();
/*     */     
/* 903 */     this._propertiesSavepoint = this._properties;
/* 904 */     if (this._properties != null) {
/* 905 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 906 */       Iterator<IDataModel> it = this._properties.iterator();
/* 907 */       while (it.hasNext()) {
/* 908 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 913 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 918 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 921 */     super.rollbackChanges();
/*     */     
/* 923 */     this._properties = this._propertiesSavepoint;
/* 924 */     this._propertiesSavepoint = null;
/* 925 */     if (this._properties != null) {
/* 926 */       Iterator<IDataModel> it = this._properties.iterator();
/* 927 */       while (it.hasNext()) {
/* 928 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 936 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 939 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 942 */     super.commitTransaction();
/*     */     
/* 944 */     this._propertiesSavepoint = this._properties;
/* 945 */     if (this._properties != null) {
/* 946 */       Iterator<IDataModel> it = this._properties.iterator();
/* 947 */       while (it.hasNext()) {
/* 948 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 950 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 954 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 959 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderUserSettingsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */