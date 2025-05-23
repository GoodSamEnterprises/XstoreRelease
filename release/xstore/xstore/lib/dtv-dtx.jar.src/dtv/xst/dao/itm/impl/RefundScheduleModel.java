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
/*     */ import dtv.xst.dao.itm.IRefundSchedule;
/*     */ import dtv.xst.dao.itm.IRefundScheduleProperty;
/*     */ import dtv.xst.dao.itm.RefundSchedulePropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class RefundScheduleModel extends AbstractDataModelWithPropertyImpl<IRefundScheduleProperty> implements IRefundSchedule {
/*     */   private static final long serialVersionUID = 1284811343L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IRefundScheduleProperty> _properties; private transient HistoricalList<IRefundScheduleProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new RefundScheduleDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RefundScheduleDAO getDAO_() {
/*  46 */     return (RefundScheduleDAO)this._daoImpl;
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
/*  70 */       this._events.post(IRefundSchedule.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<RefundSchedulePropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((RefundSchedulePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 101 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 109 */     if (setItemId_noev(argItemId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IRefundSchedule.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 122 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 123 */       getDAO_().setItemId(argItemId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<RefundSchedulePropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((RefundSchedulePropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getOrgCode() {
/* 143 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 151 */     if (setOrgCode_noev(argOrgCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IRefundSchedule.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 164 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 165 */       getDAO_().setOrgCode(argOrgCode);
/* 166 */       ev_postable = true;
/*     */     } 
/*     */     
/* 169 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 177 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 185 */     if (setOrgValue_noev(argOrgValue) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(IRefundSchedule.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 198 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 199 */       getDAO_().setOrgValue(argOrgValue);
/* 200 */       ev_postable = true;
/*     */     } 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 211 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 219 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(IRefundSchedule.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 232 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 233 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 234 */       ev_postable = true;
/* 235 */       if (this._properties != null) {
/*     */         
/* 237 */         Iterator<RefundSchedulePropertyModel> it = this._properties.iterator();
/* 238 */         while (it.hasNext())
/*     */         {
/* 240 */           ((RefundSchedulePropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 253 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 261 */     if (setCreateDate_noev(argCreateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IRefundSchedule.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 274 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 275 */       getDAO_().setCreateDate(argCreateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 287 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 295 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IRefundSchedule.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 308 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 309 */       getDAO_().setCreateUserId(argCreateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 321 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 329 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IRefundSchedule.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 342 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 343 */       getDAO_().setUpdateDate(argUpdateDate);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 355 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 363 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IRefundSchedule.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 376 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 377 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 389 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 397 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IRefundSchedule.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 410 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 411 */       getDAO_().setExpirationDate(argExpirationDate);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaximumFullRefundTime() {
/* 423 */     if (getDAO_().getMaximumFullRefundTime() != null) {
/* 424 */       return getDAO_().getMaximumFullRefundTime().intValue();
/*     */     }
/*     */     
/* 427 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumFullRefundTime(int argMaximumFullRefundTime) {
/* 436 */     if (setMaximumFullRefundTime_noev(argMaximumFullRefundTime) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IRefundSchedule.SET_MAXIMUMFULLREFUNDTIME, Integer.valueOf(argMaximumFullRefundTime));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaximumFullRefundTime_noev(int argMaximumFullRefundTime) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getMaximumFullRefundTime() == null && Integer.valueOf(argMaximumFullRefundTime) != null) || (
/* 449 */       getDAO_().getMaximumFullRefundTime() != null && !getDAO_().getMaximumFullRefundTime().equals(Integer.valueOf(argMaximumFullRefundTime)))) {
/* 450 */       getDAO_().setMaximumFullRefundTime(Integer.valueOf(argMaximumFullRefundTime));
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumNoRefundTime() {
/* 462 */     if (getDAO_().getMinimumNoRefundTime() != null) {
/* 463 */       return getDAO_().getMinimumNoRefundTime().intValue();
/*     */     }
/*     */     
/* 466 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumNoRefundTime(int argMinimumNoRefundTime) {
/* 475 */     if (setMinimumNoRefundTime_noev(argMinimumNoRefundTime) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IRefundSchedule.SET_MINIMUMNOREFUNDTIME, Integer.valueOf(argMinimumNoRefundTime));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinimumNoRefundTime_noev(int argMinimumNoRefundTime) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getMinimumNoRefundTime() == null && Integer.valueOf(argMinimumNoRefundTime) != null) || (
/* 488 */       getDAO_().getMinimumNoRefundTime() != null && !getDAO_().getMinimumNoRefundTime().equals(Integer.valueOf(argMinimumNoRefundTime)))) {
/* 489 */       getDAO_().setMinimumNoRefundTime(Integer.valueOf(argMinimumNoRefundTime));
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IRefundScheduleProperty newProperty(String argPropertyName) {
/* 497 */     RefundSchedulePropertyId id = new RefundSchedulePropertyId();
/*     */     
/* 499 */     id.setItemId(getItemId());
/* 500 */     id.setEffectiveDate(getEffectiveDate());
/* 501 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 503 */     IRefundScheduleProperty prop = (IRefundScheduleProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRefundScheduleProperty.class);
/* 504 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IRefundScheduleProperty> getProperties() {
/* 513 */     if (this._properties == null) {
/* 514 */       this._properties = new HistoricalList(null);
/*     */     }
/* 516 */     return (List<IRefundScheduleProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IRefundScheduleProperty> argProperties) {
/* 520 */     if (this._properties == null) {
/* 521 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 523 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 526 */     for (IRefundScheduleProperty child : this._properties) {
/* 527 */       RefundSchedulePropertyModel model = (RefundSchedulePropertyModel)child;
/* 528 */       model.setOrganizationId_noev(getOrganizationId());
/* 529 */       model.setItemId_noev(getItemId());
/* 530 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 531 */       if (child instanceof IDataModelImpl) {
/* 532 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 533 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 534 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 535 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addRefundScheduleProperty(IRefundScheduleProperty argRefundScheduleProperty) {
/* 545 */     if (this._properties == null) {
/* 546 */       this._properties = new HistoricalList(null);
/*     */     }
/* 548 */     argRefundScheduleProperty.setOrganizationId(getOrganizationId());
/* 549 */     argRefundScheduleProperty.setItemId(getItemId());
/* 550 */     argRefundScheduleProperty.setEffectiveDate(getEffectiveDate());
/* 551 */     if (argRefundScheduleProperty instanceof IDataModelImpl) {
/* 552 */       IDataAccessObject childDao = ((IDataModelImpl)argRefundScheduleProperty).getDAO();
/* 553 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 554 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 555 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 560 */     if (postEventsForChanges()) {
/* 561 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRefundScheduleProperty));
/*     */     }
/*     */     
/* 564 */     this._properties.add(argRefundScheduleProperty);
/* 565 */     if (postEventsForChanges()) {
/* 566 */       this._events.post(IRefundSchedule.ADD_PROPERTIES, argRefundScheduleProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRefundScheduleProperty(IRefundScheduleProperty argRefundScheduleProperty) {
/* 571 */     if (this._properties != null) {
/*     */       
/* 573 */       if (postEventsForChanges()) {
/* 574 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRefundScheduleProperty));
/*     */       }
/* 576 */       this._properties.remove(argRefundScheduleProperty);
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._events.post(IRefundSchedule.REMOVE_PROPERTIES, argRefundScheduleProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 585 */     if ("Properties".equals(argFieldId)) {
/* 586 */       return getProperties();
/*     */     }
/* 588 */     if ("RefundScheduleExtension".equals(argFieldId)) {
/* 589 */       return this._myExtension;
/*     */     }
/*     */     
/* 592 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 598 */     if ("Properties".equals(argFieldId)) {
/* 599 */       setProperties(changeToList(argValue, IRefundScheduleProperty.class));
/*     */     }
/* 601 */     else if ("RefundScheduleExtension".equals(argFieldId)) {
/* 602 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 605 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 611 */     this._persistenceDefaults = argPD;
/* 612 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 613 */     this._eventManager = argEM;
/* 614 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 615 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 616 */     if (this._properties != null) {
/* 617 */       for (IRefundScheduleProperty relationship : this._properties) {
/* 618 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getRefundScheduleExt() {
/* 624 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setRefundScheduleExt(IDataModel argExt) {
/* 628 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 633 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 637 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 640 */     super.startTransaction();
/*     */     
/* 642 */     this._propertiesSavepoint = this._properties;
/* 643 */     if (this._properties != null) {
/* 644 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 645 */       Iterator<IDataModel> it = this._properties.iterator();
/* 646 */       while (it.hasNext()) {
/* 647 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 652 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 657 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 660 */     super.rollbackChanges();
/*     */     
/* 662 */     this._properties = this._propertiesSavepoint;
/* 663 */     this._propertiesSavepoint = null;
/* 664 */     if (this._properties != null) {
/* 665 */       Iterator<IDataModel> it = this._properties.iterator();
/* 666 */       while (it.hasNext()) {
/* 667 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 675 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 678 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 681 */     super.commitTransaction();
/*     */     
/* 683 */     this._propertiesSavepoint = this._properties;
/* 684 */     if (this._properties != null) {
/* 685 */       Iterator<IDataModel> it = this._properties.iterator();
/* 686 */       while (it.hasNext()) {
/* 687 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 689 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 693 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 698 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\RefundScheduleModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */