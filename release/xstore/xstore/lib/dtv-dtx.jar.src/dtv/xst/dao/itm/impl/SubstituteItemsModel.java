/*     */ package dtv.xst.dao.itm.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.ISubstituteItems;
/*     */ import dtv.xst.dao.itm.ISubstituteItemsProperty;
/*     */ import dtv.xst.dao.itm.SubstituteItemsPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SubstituteItemsModel extends AbstractDataModelWithPropertyImpl<ISubstituteItemsProperty> implements ISubstituteItems {
/*     */   private static final long serialVersionUID = 453630758L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ISubstituteItemsProperty> _properties; private transient HistoricalList<ISubstituteItemsProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new SubstituteItemsDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SubstituteItemsDAO getDAO_() {
/*  46 */     return (SubstituteItemsDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(ISubstituteItems.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<SubstituteItemsPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((SubstituteItemsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrimaryItemId() {
/* 101 */     return getDAO_().getPrimaryItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryItemId(String argPrimaryItemId) {
/* 109 */     if (setPrimaryItemId_noev(argPrimaryItemId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ISubstituteItems.SET_PRIMARYITEMID, argPrimaryItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrimaryItemId_noev(String argPrimaryItemId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getPrimaryItemId() == null && argPrimaryItemId != null) || (
/* 122 */       getDAO_().getPrimaryItemId() != null && !getDAO_().getPrimaryItemId().equals(argPrimaryItemId))) {
/* 123 */       getDAO_().setPrimaryItemId(argPrimaryItemId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<SubstituteItemsPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((SubstituteItemsPropertyModel)it.next()).setPrimaryItemId_noev(argPrimaryItemId);
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
/*     */   public String getSubstituteItemId() {
/* 143 */     return getDAO_().getSubstituteItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubstituteItemId(String argSubstituteItemId) {
/* 151 */     if (setSubstituteItemId_noev(argSubstituteItemId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ISubstituteItems.SET_SUBSTITUTEITEMID, argSubstituteItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSubstituteItemId_noev(String argSubstituteItemId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getSubstituteItemId() == null && argSubstituteItemId != null) || (
/* 164 */       getDAO_().getSubstituteItemId() != null && !getDAO_().getSubstituteItemId().equals(argSubstituteItemId))) {
/* 165 */       getDAO_().setSubstituteItemId(argSubstituteItemId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<SubstituteItemsPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((SubstituteItemsPropertyModel)it.next()).setSubstituteItemId_noev(argSubstituteItemId);
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
/*     */   public String getLevelCode() {
/* 185 */     return getDAO_().getLevelCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 193 */     if (setLevelCode_noev(argLevelCode) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(ISubstituteItems.SET_LEVELCODE, argLevelCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelCode_noev(String argLevelCode) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/* 206 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/* 207 */       getDAO_().setLevelCode(argLevelCode);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<SubstituteItemsPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((SubstituteItemsPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
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
/*     */   public String getLevelValue() {
/* 227 */     return getDAO_().getLevelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/* 235 */     if (setLevelValue_noev(argLevelValue) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(ISubstituteItems.SET_LEVELVALUE, argLevelValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelValue_noev(String argLevelValue) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/* 248 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/* 249 */       getDAO_().setLevelValue(argLevelValue);
/* 250 */       ev_postable = true;
/* 251 */       if (this._properties != null) {
/*     */         
/* 253 */         Iterator<SubstituteItemsPropertyModel> it = this._properties.iterator();
/* 254 */         while (it.hasNext())
/*     */         {
/* 256 */           ((SubstituteItemsPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
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
/*     */   public Date getCreateDate() {
/* 269 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 277 */     if (setCreateDate_noev(argCreateDate) && 
/* 278 */       this._events != null && 
/* 279 */       postEventsForChanges()) {
/* 280 */       this._events.post(ISubstituteItems.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 287 */     boolean ev_postable = false;
/*     */     
/* 289 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 290 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 291 */       getDAO_().setCreateDate(argCreateDate);
/* 292 */       ev_postable = true;
/*     */     } 
/*     */     
/* 295 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 303 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 311 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 312 */       this._events != null && 
/* 313 */       postEventsForChanges()) {
/* 314 */       this._events.post(ISubstituteItems.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 321 */     boolean ev_postable = false;
/*     */     
/* 323 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 324 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 325 */       getDAO_().setCreateUserId(argCreateUserId);
/* 326 */       ev_postable = true;
/*     */     } 
/*     */     
/* 329 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 337 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 345 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(ISubstituteItems.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 358 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 359 */       getDAO_().setUpdateDate(argUpdateDate);
/* 360 */       ev_postable = true;
/*     */     } 
/*     */     
/* 363 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 371 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 379 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(ISubstituteItems.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 392 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 393 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 394 */       ev_postable = true;
/*     */     } 
/*     */     
/* 397 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDatetime() {
/* 405 */     return getDAO_().getBeginDatetime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDatetime(Date argBeginDatetime) {
/* 413 */     if (setBeginDatetime_noev(argBeginDatetime) && 
/* 414 */       this._events != null && 
/* 415 */       postEventsForChanges()) {
/* 416 */       this._events.post(ISubstituteItems.SET_BEGINDATETIME, argBeginDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginDatetime_noev(Date argBeginDatetime) {
/* 423 */     boolean ev_postable = false;
/*     */     
/* 425 */     if ((getDAO_().getBeginDatetime() == null && argBeginDatetime != null) || (
/* 426 */       getDAO_().getBeginDatetime() != null && !getDAO_().getBeginDatetime().equals(argBeginDatetime))) {
/* 427 */       getDAO_().setBeginDatetime(argBeginDatetime);
/* 428 */       ev_postable = true;
/*     */     } 
/*     */     
/* 431 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDatetime() {
/* 439 */     return getDAO_().getEndDatetime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDatetime(Date argEndDatetime) {
/* 447 */     if (setEndDatetime_noev(argEndDatetime) && 
/* 448 */       this._events != null && 
/* 449 */       postEventsForChanges()) {
/* 450 */       this._events.post(ISubstituteItems.SET_ENDDATETIME, argEndDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDatetime_noev(Date argEndDatetime) {
/* 457 */     boolean ev_postable = false;
/*     */     
/* 459 */     if ((getDAO_().getEndDatetime() == null && argEndDatetime != null) || (
/* 460 */       getDAO_().getEndDatetime() != null && !getDAO_().getEndDatetime().equals(argEndDatetime))) {
/* 461 */       getDAO_().setEndDatetime(argEndDatetime);
/* 462 */       ev_postable = true;
/*     */     } 
/*     */     
/* 465 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalId() {
/* 473 */     return getDAO_().getExternalId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalId(String argExternalId) {
/* 481 */     if (setExternalId_noev(argExternalId) && 
/* 482 */       this._events != null && 
/* 483 */       postEventsForChanges()) {
/* 484 */       this._events.post(ISubstituteItems.SET_EXTERNALID, argExternalId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalId_noev(String argExternalId) {
/* 491 */     boolean ev_postable = false;
/*     */     
/* 493 */     if ((getDAO_().getExternalId() == null && argExternalId != null) || (
/* 494 */       getDAO_().getExternalId() != null && !getDAO_().getExternalId().equals(argExternalId))) {
/* 495 */       getDAO_().setExternalId(argExternalId);
/* 496 */       ev_postable = true;
/*     */     } 
/*     */     
/* 499 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExternalSystem() {
/* 507 */     return getDAO_().getExternalSystem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExternalSystem(String argExternalSystem) {
/* 515 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 516 */       this._events != null && 
/* 517 */       postEventsForChanges()) {
/* 518 */       this._events.post(ISubstituteItems.SET_EXTERNALSYSTEM, argExternalSystem);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 525 */     boolean ev_postable = false;
/*     */     
/* 527 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 528 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 529 */       getDAO_().setExternalSystem(argExternalSystem);
/* 530 */       ev_postable = true;
/*     */     } 
/*     */     
/* 533 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISubstituteItemsProperty newProperty(String argPropertyName) {
/* 537 */     SubstituteItemsPropertyId id = new SubstituteItemsPropertyId();
/*     */     
/* 539 */     id.setPrimaryItemId(getPrimaryItemId());
/* 540 */     id.setSubstituteItemId(getSubstituteItemId());
/* 541 */     id.setLevelCode(getLevelCode());
/* 542 */     id.setLevelValue(getLevelValue());
/* 543 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 545 */     ISubstituteItemsProperty prop = (ISubstituteItemsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISubstituteItemsProperty.class);
/* 546 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISubstituteItemsProperty> getProperties() {
/* 555 */     if (this._properties == null) {
/* 556 */       this._properties = new HistoricalList(null);
/*     */     }
/* 558 */     return (List<ISubstituteItemsProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISubstituteItemsProperty> argProperties) {
/* 562 */     if (this._properties == null) {
/* 563 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 565 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 568 */     for (ISubstituteItemsProperty child : this._properties) {
/* 569 */       SubstituteItemsPropertyModel model = (SubstituteItemsPropertyModel)child;
/* 570 */       model.setOrganizationId_noev(getOrganizationId());
/* 571 */       model.setPrimaryItemId_noev(getPrimaryItemId());
/* 572 */       model.setSubstituteItemId_noev(getSubstituteItemId());
/* 573 */       model.setLevelCode_noev(getLevelCode());
/* 574 */       model.setLevelValue_noev(getLevelValue());
/* 575 */       if (child instanceof IDataModelImpl) {
/* 576 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 577 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 578 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 579 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 582 */       if (postEventsForChanges()) {
/* 583 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSubstituteItemsProperty(ISubstituteItemsProperty argSubstituteItemsProperty) {
/* 589 */     if (this._properties == null) {
/* 590 */       this._properties = new HistoricalList(null);
/*     */     }
/* 592 */     argSubstituteItemsProperty.setOrganizationId(getOrganizationId());
/* 593 */     argSubstituteItemsProperty.setPrimaryItemId(getPrimaryItemId());
/* 594 */     argSubstituteItemsProperty.setSubstituteItemId(getSubstituteItemId());
/* 595 */     argSubstituteItemsProperty.setLevelCode(getLevelCode());
/* 596 */     argSubstituteItemsProperty.setLevelValue(getLevelValue());
/* 597 */     if (argSubstituteItemsProperty instanceof IDataModelImpl) {
/* 598 */       IDataAccessObject childDao = ((IDataModelImpl)argSubstituteItemsProperty).getDAO();
/* 599 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 600 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 601 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 606 */     if (postEventsForChanges()) {
/* 607 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSubstituteItemsProperty));
/*     */     }
/*     */     
/* 610 */     this._properties.add(argSubstituteItemsProperty);
/* 611 */     if (postEventsForChanges()) {
/* 612 */       this._events.post(ISubstituteItems.ADD_PROPERTIES, argSubstituteItemsProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSubstituteItemsProperty(ISubstituteItemsProperty argSubstituteItemsProperty) {
/* 617 */     if (this._properties != null) {
/*     */       
/* 619 */       if (postEventsForChanges()) {
/* 620 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSubstituteItemsProperty));
/*     */       }
/* 622 */       this._properties.remove(argSubstituteItemsProperty);
/* 623 */       if (postEventsForChanges()) {
/* 624 */         this._events.post(ISubstituteItems.REMOVE_PROPERTIES, argSubstituteItemsProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 631 */     if ("Properties".equals(argFieldId)) {
/* 632 */       return getProperties();
/*     */     }
/* 634 */     if ("SubstituteItemsExtension".equals(argFieldId)) {
/* 635 */       return this._myExtension;
/*     */     }
/*     */     
/* 638 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 644 */     if ("Properties".equals(argFieldId)) {
/* 645 */       setProperties(changeToList(argValue, ISubstituteItemsProperty.class));
/*     */     }
/* 647 */     else if ("SubstituteItemsExtension".equals(argFieldId)) {
/* 648 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 651 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 657 */     this._persistenceDefaults = argPD;
/* 658 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 659 */     this._eventManager = argEM;
/* 660 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 661 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 662 */     if (this._properties != null) {
/* 663 */       for (ISubstituteItemsProperty relationship : this._properties) {
/* 664 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSubstituteItemsExt() {
/* 670 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSubstituteItemsExt(IDataModel argExt) {
/* 674 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 679 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 683 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 686 */     super.startTransaction();
/*     */     
/* 688 */     this._propertiesSavepoint = this._properties;
/* 689 */     if (this._properties != null) {
/* 690 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 691 */       Iterator<IDataModel> it = this._properties.iterator();
/* 692 */       while (it.hasNext()) {
/* 693 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 698 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 703 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 706 */     super.rollbackChanges();
/*     */     
/* 708 */     this._properties = this._propertiesSavepoint;
/* 709 */     this._propertiesSavepoint = null;
/* 710 */     if (this._properties != null) {
/* 711 */       Iterator<IDataModel> it = this._properties.iterator();
/* 712 */       while (it.hasNext()) {
/* 713 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 721 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 724 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 727 */     super.commitTransaction();
/*     */     
/* 729 */     this._propertiesSavepoint = this._properties;
/* 730 */     if (this._properties != null) {
/* 731 */       Iterator<IDataModel> it = this._properties.iterator();
/* 732 */       while (it.hasNext()) {
/* 733 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 735 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 739 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 744 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\SubstituteItemsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */