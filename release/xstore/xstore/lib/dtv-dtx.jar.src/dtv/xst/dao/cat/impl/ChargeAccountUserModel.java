/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.ChargeAccountUserPropertyId;
/*     */ import dtv.xst.dao.cat.IChargeAccountUser;
/*     */ import dtv.xst.dao.cat.IChargeAccountUserProperty;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ChargeAccountUserModel extends ChargeAccountUserBaseModel implements IChargeAccountUser {
/*     */   private static final long serialVersionUID = -143206364L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IChargeAccountUserProperty> _properties; private transient HistoricalList<IChargeAccountUserProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new ChargeAccountUserDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ChargeAccountUserDAO getDAO_() {
/*  47 */     return (ChargeAccountUserDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(IChargeAccountUser.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<ChargeAccountUserPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((ChargeAccountUserPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 102 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 110 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IChargeAccountUser.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 123 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 124 */       getDAO_().setCustAccountId(argCustAccountId);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<ChargeAccountUserPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((ChargeAccountUserPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountCode() {
/* 144 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 152 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IChargeAccountUser.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 165 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 166 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<ChargeAccountUserPropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((ChargeAccountUserPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserId() {
/* 186 */     return getDAO_().getAccountUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/* 194 */     if (setAccountUserId_noev(argAccountUserId) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(IChargeAccountUser.SET_ACCOUNTUSERID, argAccountUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserId_noev(String argAccountUserId) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getAccountUserId() == null && argAccountUserId != null) || (
/* 207 */       getDAO_().getAccountUserId() != null && !getDAO_().getAccountUserId().equals(argAccountUserId))) {
/* 208 */       getDAO_().setAccountUserId(argAccountUserId);
/* 209 */       ev_postable = true;
/* 210 */       if (this._properties != null) {
/*     */         
/* 212 */         Iterator<ChargeAccountUserPropertyModel> it = this._properties.iterator();
/* 213 */         while (it.hasNext())
/*     */         {
/* 215 */           ((ChargeAccountUserPropertyModel)it.next()).setAccountUserId_noev(argAccountUserId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 220 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 228 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 236 */     if (setCreateDate_noev(argCreateDate) && 
/* 237 */       this._events != null && 
/* 238 */       postEventsForChanges()) {
/* 239 */       this._events.post(IChargeAccountUser.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 246 */     boolean ev_postable = false;
/*     */     
/* 248 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 249 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 250 */       getDAO_().setCreateDate(argCreateDate);
/* 251 */       ev_postable = true;
/*     */     } 
/*     */     
/* 254 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 262 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 270 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 271 */       this._events != null && 
/* 272 */       postEventsForChanges()) {
/* 273 */       this._events.post(IChargeAccountUser.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 280 */     boolean ev_postable = false;
/*     */     
/* 282 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 283 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 284 */       getDAO_().setCreateUserId(argCreateUserId);
/* 285 */       ev_postable = true;
/*     */     } 
/*     */     
/* 288 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 296 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 304 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 305 */       this._events != null && 
/* 306 */       postEventsForChanges()) {
/* 307 */       this._events.post(IChargeAccountUser.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 314 */     boolean ev_postable = false;
/*     */     
/* 316 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 317 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 318 */       getDAO_().setUpdateDate(argUpdateDate);
/* 319 */       ev_postable = true;
/*     */     } 
/*     */     
/* 322 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 330 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 338 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 339 */       this._events != null && 
/* 340 */       postEventsForChanges()) {
/* 341 */       this._events.post(IChargeAccountUser.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 348 */     boolean ev_postable = false;
/*     */     
/* 350 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 351 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 352 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 353 */       ev_postable = true;
/*     */     } 
/*     */     
/* 356 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserName() {
/* 364 */     return getDAO_().getAccountUserName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserName(String argAccountUserName) {
/* 372 */     if (setAccountUserName_noev(argAccountUserName) && 
/* 373 */       this._events != null && 
/* 374 */       postEventsForChanges()) {
/* 375 */       this._events.post(IChargeAccountUser.SET_ACCOUNTUSERNAME, argAccountUserName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserName_noev(String argAccountUserName) {
/* 382 */     boolean ev_postable = false;
/*     */     
/* 384 */     if ((getDAO_().getAccountUserName() == null && argAccountUserName != null) || (
/* 385 */       getDAO_().getAccountUserName() != null && !getDAO_().getAccountUserName().equals(argAccountUserName))) {
/* 386 */       getDAO_().setAccountUserName(argAccountUserName);
/* 387 */       ev_postable = true;
/*     */     } 
/*     */     
/* 390 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 398 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 406 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 407 */       this._events != null && 
/* 408 */       postEventsForChanges()) {
/* 409 */       this._events.post(IChargeAccountUser.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 416 */     boolean ev_postable = false;
/*     */     
/* 418 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 419 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 420 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 421 */       ev_postable = true;
/*     */     } 
/*     */     
/* 424 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 432 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 440 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 441 */       this._events != null && 
/* 442 */       postEventsForChanges()) {
/* 443 */       this._events.post(IChargeAccountUser.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 450 */     boolean ev_postable = false;
/*     */     
/* 452 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 453 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 454 */       getDAO_().setExpirationDate(argExpirationDate);
/* 455 */       ev_postable = true;
/*     */     } 
/*     */     
/* 458 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPrimaryContact() {
/* 466 */     if (getDAO_().getPrimaryContact() != null) {
/* 467 */       return getDAO_().getPrimaryContact().booleanValue();
/*     */     }
/*     */     
/* 470 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryContact(boolean argPrimaryContact) {
/* 479 */     if (setPrimaryContact_noev(argPrimaryContact) && 
/* 480 */       this._events != null && 
/* 481 */       postEventsForChanges()) {
/* 482 */       this._events.post(IChargeAccountUser.SET_PRIMARYCONTACT, Boolean.valueOf(argPrimaryContact));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrimaryContact_noev(boolean argPrimaryContact) {
/* 489 */     boolean ev_postable = false;
/*     */     
/* 491 */     if ((getDAO_().getPrimaryContact() == null && Boolean.valueOf(argPrimaryContact) != null) || (
/* 492 */       getDAO_().getPrimaryContact() != null && !getDAO_().getPrimaryContact().equals(Boolean.valueOf(argPrimaryContact)))) {
/* 493 */       getDAO_().setPrimaryContact(Boolean.valueOf(argPrimaryContact));
/* 494 */       ev_postable = true;
/*     */     } 
/*     */     
/* 497 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 505 */     if (getDAO_().getPartyId() != null) {
/* 506 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/* 509 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 518 */     if (setPartyId_noev(argPartyId) && 
/* 519 */       this._events != null && 
/* 520 */       postEventsForChanges()) {
/* 521 */       this._events.post(IChargeAccountUser.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 528 */     boolean ev_postable = false;
/*     */     
/* 530 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 531 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 532 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 533 */       ev_postable = true;
/*     */     } 
/*     */     
/* 536 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserFirstName() {
/* 544 */     return getDAO_().getAccountUserFirstName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserFirstName(String argAccountUserFirstName) {
/* 552 */     if (setAccountUserFirstName_noev(argAccountUserFirstName) && 
/* 553 */       this._events != null && 
/* 554 */       postEventsForChanges()) {
/* 555 */       this._events.post(IChargeAccountUser.SET_ACCOUNTUSERFIRSTNAME, argAccountUserFirstName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserFirstName_noev(String argAccountUserFirstName) {
/* 562 */     boolean ev_postable = false;
/*     */     
/* 564 */     if ((getDAO_().getAccountUserFirstName() == null && argAccountUserFirstName != null) || (
/* 565 */       getDAO_().getAccountUserFirstName() != null && !getDAO_().getAccountUserFirstName().equals(argAccountUserFirstName))) {
/* 566 */       getDAO_().setAccountUserFirstName(argAccountUserFirstName);
/* 567 */       ev_postable = true;
/*     */     } 
/*     */     
/* 570 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccountUserLastName() {
/* 578 */     return getDAO_().getAccountUserLastName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAccountUserLastName(String argAccountUserLastName) {
/* 586 */     if (setAccountUserLastName_noev(argAccountUserLastName) && 
/* 587 */       this._events != null && 
/* 588 */       postEventsForChanges()) {
/* 589 */       this._events.post(IChargeAccountUser.SET_ACCOUNTUSERLASTNAME, argAccountUserLastName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAccountUserLastName_noev(String argAccountUserLastName) {
/* 596 */     boolean ev_postable = false;
/*     */     
/* 598 */     if ((getDAO_().getAccountUserLastName() == null && argAccountUserLastName != null) || (
/* 599 */       getDAO_().getAccountUserLastName() != null && !getDAO_().getAccountUserLastName().equals(argAccountUserLastName))) {
/* 600 */       getDAO_().setAccountUserLastName(argAccountUserLastName);
/* 601 */       ev_postable = true;
/*     */     } 
/*     */     
/* 604 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IChargeAccountUserProperty newProperty(String argPropertyName) {
/* 608 */     ChargeAccountUserPropertyId id = new ChargeAccountUserPropertyId();
/*     */     
/* 610 */     id.setCustAccountId(getCustAccountId());
/* 611 */     id.setCustAccountCode(getCustAccountCode());
/* 612 */     id.setAccountUserId(getAccountUserId());
/* 613 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 615 */     IChargeAccountUserProperty prop = (IChargeAccountUserProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IChargeAccountUserProperty.class);
/* 616 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IChargeAccountUserProperty> getProperties() {
/* 625 */     if (this._properties == null) {
/* 626 */       this._properties = new HistoricalList(null);
/*     */     }
/* 628 */     return (List<IChargeAccountUserProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IChargeAccountUserProperty> argProperties) {
/* 632 */     if (this._properties == null) {
/* 633 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 635 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 638 */     for (IChargeAccountUserProperty child : this._properties) {
/* 639 */       ChargeAccountUserPropertyModel model = (ChargeAccountUserPropertyModel)child;
/* 640 */       model.setOrganizationId_noev(getOrganizationId());
/* 641 */       model.setCustAccountId_noev(getCustAccountId());
/* 642 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 643 */       model.setAccountUserId_noev(getAccountUserId());
/* 644 */       if (child instanceof IDataModelImpl) {
/* 645 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 646 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 647 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 648 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 651 */       if (postEventsForChanges()) {
/* 652 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addChargeAccountUserProperty(IChargeAccountUserProperty argChargeAccountUserProperty) {
/* 658 */     if (this._properties == null) {
/* 659 */       this._properties = new HistoricalList(null);
/*     */     }
/* 661 */     argChargeAccountUserProperty.setOrganizationId(getOrganizationId());
/* 662 */     argChargeAccountUserProperty.setCustAccountId(getCustAccountId());
/* 663 */     argChargeAccountUserProperty.setCustAccountCode(getCustAccountCode());
/* 664 */     argChargeAccountUserProperty.setAccountUserId(getAccountUserId());
/* 665 */     if (argChargeAccountUserProperty instanceof IDataModelImpl) {
/* 666 */       IDataAccessObject childDao = ((IDataModelImpl)argChargeAccountUserProperty).getDAO();
/* 667 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 668 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 669 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 674 */     if (postEventsForChanges()) {
/* 675 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountUserProperty));
/*     */     }
/*     */     
/* 678 */     this._properties.add(argChargeAccountUserProperty);
/* 679 */     if (postEventsForChanges()) {
/* 680 */       this._events.post(IChargeAccountUser.ADD_PROPERTIES, argChargeAccountUserProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeChargeAccountUserProperty(IChargeAccountUserProperty argChargeAccountUserProperty) {
/* 685 */     if (this._properties != null) {
/*     */       
/* 687 */       if (postEventsForChanges()) {
/* 688 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountUserProperty));
/*     */       }
/* 690 */       this._properties.remove(argChargeAccountUserProperty);
/* 691 */       if (postEventsForChanges()) {
/* 692 */         this._events.post(IChargeAccountUser.REMOVE_PROPERTIES, argChargeAccountUserProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 699 */     if ("Properties".equals(argFieldId)) {
/* 700 */       return getProperties();
/*     */     }
/* 702 */     if ("ChargeAccountUserExtension".equals(argFieldId)) {
/* 703 */       return this._myExtension;
/*     */     }
/*     */     
/* 706 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 712 */     if ("Properties".equals(argFieldId)) {
/* 713 */       setProperties(changeToList(argValue, IChargeAccountUserProperty.class));
/*     */     }
/* 715 */     else if ("ChargeAccountUserExtension".equals(argFieldId)) {
/* 716 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 719 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 725 */     this._persistenceDefaults = argPD;
/* 726 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 727 */     this._eventManager = argEM;
/* 728 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 729 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 730 */     if (this._properties != null) {
/* 731 */       for (IChargeAccountUserProperty relationship : this._properties) {
/* 732 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getChargeAccountUserExt() {
/* 738 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setChargeAccountUserExt(IDataModel argExt) {
/* 742 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 747 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 751 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 754 */     super.startTransaction();
/*     */     
/* 756 */     this._propertiesSavepoint = this._properties;
/* 757 */     if (this._properties != null) {
/* 758 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 759 */       Iterator<IDataModel> it = this._properties.iterator();
/* 760 */       while (it.hasNext()) {
/* 761 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 766 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 771 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 774 */     super.rollbackChanges();
/*     */     
/* 776 */     this._properties = this._propertiesSavepoint;
/* 777 */     this._propertiesSavepoint = null;
/* 778 */     if (this._properties != null) {
/* 779 */       Iterator<IDataModel> it = this._properties.iterator();
/* 780 */       while (it.hasNext()) {
/* 781 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 789 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 792 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 795 */     super.commitTransaction();
/*     */     
/* 797 */     this._propertiesSavepoint = this._properties;
/* 798 */     if (this._properties != null) {
/* 799 */       Iterator<IDataModel> it = this._properties.iterator();
/* 800 */       while (it.hasNext()) {
/* 801 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 803 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 807 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountUserModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */