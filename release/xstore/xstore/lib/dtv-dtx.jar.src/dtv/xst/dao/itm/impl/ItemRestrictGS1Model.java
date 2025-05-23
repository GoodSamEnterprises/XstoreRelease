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
/*     */ import dtv.xst.dao.itm.IItemRestrictGS1;
/*     */ import dtv.xst.dao.itm.IItemRestrictGS1Property;
/*     */ import dtv.xst.dao.itm.ItemRestrictGS1PropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemRestrictGS1Model extends AbstractDataModelWithPropertyImpl<IItemRestrictGS1Property> implements IItemRestrictGS1 {
/*     */   private static final long serialVersionUID = 1589828438L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IItemRestrictGS1Property> _properties; private transient HistoricalList<IItemRestrictGS1Property> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ItemRestrictGS1DAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemRestrictGS1DAO getDAO_() {
/*  46 */     return (ItemRestrictGS1DAO)this._daoImpl;
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
/*  70 */       this._events.post(IItemRestrictGS1.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ItemRestrictGS1PropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ItemRestrictGS1PropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 112 */       this._events.post(IItemRestrictGS1.SET_ITEMID, argItemId);
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
/* 127 */         Iterator<ItemRestrictGS1PropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ItemRestrictGS1PropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getFieldId() {
/* 143 */     return getDAO_().getFieldId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldId(String argFieldId) {
/* 151 */     if (setFieldId_noev(argFieldId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IItemRestrictGS1.SET_FIELDID, argFieldId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setFieldId_noev(String argFieldId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getFieldId() == null && argFieldId != null) || (
/* 164 */       getDAO_().getFieldId() != null && !getDAO_().getFieldId().equals(argFieldId))) {
/* 165 */       getDAO_().setFieldId(argFieldId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ItemRestrictGS1PropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ItemRestrictGS1PropertyModel)it.next()).setFieldId_noev(argFieldId);
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
/*     */   public String getStartValue() {
/* 185 */     return getDAO_().getStartValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartValue(String argStartValue) {
/* 193 */     if (setStartValue_noev(argStartValue) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IItemRestrictGS1.SET_STARTVALUE, argStartValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartValue_noev(String argStartValue) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getStartValue() == null && argStartValue != null) || (
/* 206 */       getDAO_().getStartValue() != null && !getDAO_().getStartValue().equals(argStartValue))) {
/* 207 */       getDAO_().setStartValue(argStartValue);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ItemRestrictGS1PropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ItemRestrictGS1PropertyModel)it.next()).setStartValue_noev(argStartValue);
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
/*     */   public String getAiType() {
/* 227 */     return getDAO_().getAiType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAiType(String argAiType) {
/* 235 */     if (setAiType_noev(argAiType) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IItemRestrictGS1.SET_AITYPE, argAiType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAiType_noev(String argAiType) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getAiType() == null && argAiType != null) || (
/* 248 */       getDAO_().getAiType() != null && !getDAO_().getAiType().equals(argAiType))) {
/* 249 */       getDAO_().setAiType(argAiType);
/* 250 */       ev_postable = true;
/*     */     } 
/*     */     
/* 253 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEndValue() {
/* 261 */     return getDAO_().getEndValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndValue(String argEndValue) {
/* 269 */     if (setEndValue_noev(argEndValue) && 
/* 270 */       this._events != null && 
/* 271 */       postEventsForChanges()) {
/* 272 */       this._events.post(IItemRestrictGS1.SET_ENDVALUE, argEndValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndValue_noev(String argEndValue) {
/* 279 */     boolean ev_postable = false;
/*     */     
/* 281 */     if ((getDAO_().getEndValue() == null && argEndValue != null) || (
/* 282 */       getDAO_().getEndValue() != null && !getDAO_().getEndValue().equals(argEndValue))) {
/* 283 */       getDAO_().setEndValue(argEndValue);
/* 284 */       ev_postable = true;
/*     */     } 
/*     */     
/* 287 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 295 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 303 */     if (setOrgCode_noev(argOrgCode) && 
/* 304 */       this._events != null && 
/* 305 */       postEventsForChanges()) {
/* 306 */       this._events.post(IItemRestrictGS1.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 313 */     boolean ev_postable = false;
/*     */     
/* 315 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 316 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 317 */       getDAO_().setOrgCode(argOrgCode);
/* 318 */       ev_postable = true;
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 329 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 337 */     if (setOrgValue_noev(argOrgValue) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IItemRestrictGS1.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 350 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 351 */       getDAO_().setOrgValue(argOrgValue);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 363 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 371 */     if (setCreateDate_noev(argCreateDate) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IItemRestrictGS1.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 384 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 385 */       getDAO_().setCreateDate(argCreateDate);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 397 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 405 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IItemRestrictGS1.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 418 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 419 */       getDAO_().setCreateUserId(argCreateUserId);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 431 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 439 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IItemRestrictGS1.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 452 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 453 */       getDAO_().setUpdateDate(argUpdateDate);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 465 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 473 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IItemRestrictGS1.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 486 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 487 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordState() {
/* 499 */     return getDAO_().getRecordState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordState(String argRecordState) {
/* 507 */     if (setRecordState_noev(argRecordState) && 
/* 508 */       this._events != null && 
/* 509 */       postEventsForChanges()) {
/* 510 */       this._events.post(IItemRestrictGS1.SET_RECORDSTATE, argRecordState);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRecordState_noev(String argRecordState) {
/* 517 */     boolean ev_postable = false;
/*     */     
/* 519 */     if ((getDAO_().getRecordState() == null && argRecordState != null) || (
/* 520 */       getDAO_().getRecordState() != null && !getDAO_().getRecordState().equals(argRecordState))) {
/* 521 */       getDAO_().setRecordState(argRecordState);
/* 522 */       ev_postable = true;
/*     */     } 
/*     */     
/* 525 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemRestrictGS1Property newProperty(String argPropertyName) {
/* 529 */     ItemRestrictGS1PropertyId id = new ItemRestrictGS1PropertyId();
/*     */     
/* 531 */     id.setItemId(getItemId());
/* 532 */     id.setFieldId(getFieldId());
/* 533 */     id.setStartValue(getStartValue());
/* 534 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 536 */     IItemRestrictGS1Property prop = (IItemRestrictGS1Property)DataFactory.getInstance().createNewObject((IObjectId)id, IItemRestrictGS1Property.class);
/* 537 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemRestrictGS1Property> getProperties() {
/* 546 */     if (this._properties == null) {
/* 547 */       this._properties = new HistoricalList(null);
/*     */     }
/* 549 */     return (List<IItemRestrictGS1Property>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemRestrictGS1Property> argProperties) {
/* 553 */     if (this._properties == null) {
/* 554 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 556 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 559 */     for (IItemRestrictGS1Property child : this._properties) {
/* 560 */       ItemRestrictGS1PropertyModel model = (ItemRestrictGS1PropertyModel)child;
/* 561 */       model.setOrganizationId_noev(getOrganizationId());
/* 562 */       model.setItemId_noev(getItemId());
/* 563 */       model.setFieldId_noev(getFieldId());
/* 564 */       model.setStartValue_noev(getStartValue());
/* 565 */       if (child instanceof IDataModelImpl) {
/* 566 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 567 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 568 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 569 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 572 */       if (postEventsForChanges()) {
/* 573 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemRestrictGS1Property(IItemRestrictGS1Property argItemRestrictGS1Property) {
/* 579 */     if (this._properties == null) {
/* 580 */       this._properties = new HistoricalList(null);
/*     */     }
/* 582 */     argItemRestrictGS1Property.setOrganizationId(getOrganizationId());
/* 583 */     argItemRestrictGS1Property.setItemId(getItemId());
/* 584 */     argItemRestrictGS1Property.setFieldId(getFieldId());
/* 585 */     argItemRestrictGS1Property.setStartValue(getStartValue());
/* 586 */     if (argItemRestrictGS1Property instanceof IDataModelImpl) {
/* 587 */       IDataAccessObject childDao = ((IDataModelImpl)argItemRestrictGS1Property).getDAO();
/* 588 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 589 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 590 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 595 */     if (postEventsForChanges()) {
/* 596 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictGS1Property));
/*     */     }
/*     */     
/* 599 */     this._properties.add(argItemRestrictGS1Property);
/* 600 */     if (postEventsForChanges()) {
/* 601 */       this._events.post(IItemRestrictGS1.ADD_PROPERTIES, argItemRestrictGS1Property);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemRestrictGS1Property(IItemRestrictGS1Property argItemRestrictGS1Property) {
/* 606 */     if (this._properties != null) {
/*     */       
/* 608 */       if (postEventsForChanges()) {
/* 609 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemRestrictGS1Property));
/*     */       }
/* 611 */       this._properties.remove(argItemRestrictGS1Property);
/* 612 */       if (postEventsForChanges()) {
/* 613 */         this._events.post(IItemRestrictGS1.REMOVE_PROPERTIES, argItemRestrictGS1Property);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 620 */     if ("Properties".equals(argFieldId)) {
/* 621 */       return getProperties();
/*     */     }
/* 623 */     if ("ItemRestrictGS1Extension".equals(argFieldId)) {
/* 624 */       return this._myExtension;
/*     */     }
/*     */     
/* 627 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 633 */     if ("Properties".equals(argFieldId)) {
/* 634 */       setProperties(changeToList(argValue, IItemRestrictGS1Property.class));
/*     */     }
/* 636 */     else if ("ItemRestrictGS1Extension".equals(argFieldId)) {
/* 637 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 640 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 646 */     this._persistenceDefaults = argPD;
/* 647 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 648 */     this._eventManager = argEM;
/* 649 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 650 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 651 */     if (this._properties != null) {
/* 652 */       for (IItemRestrictGS1Property relationship : this._properties) {
/* 653 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemRestrictGS1Ext() {
/* 659 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemRestrictGS1Ext(IDataModel argExt) {
/* 663 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 668 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 672 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 675 */     super.startTransaction();
/*     */     
/* 677 */     this._propertiesSavepoint = this._properties;
/* 678 */     if (this._properties != null) {
/* 679 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 680 */       Iterator<IDataModel> it = this._properties.iterator();
/* 681 */       while (it.hasNext()) {
/* 682 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 687 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 692 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 695 */     super.rollbackChanges();
/*     */     
/* 697 */     this._properties = this._propertiesSavepoint;
/* 698 */     this._propertiesSavepoint = null;
/* 699 */     if (this._properties != null) {
/* 700 */       Iterator<IDataModel> it = this._properties.iterator();
/* 701 */       while (it.hasNext()) {
/* 702 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 710 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 713 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 716 */     super.commitTransaction();
/*     */     
/* 718 */     this._propertiesSavepoint = this._properties;
/* 719 */     if (this._properties != null) {
/* 720 */       Iterator<IDataModel> it = this._properties.iterator();
/* 721 */       while (it.hasNext()) {
/* 722 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 724 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 728 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 733 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictGS1Model.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */