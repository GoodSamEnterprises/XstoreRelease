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
/*     */ import dtv.xst.dao.itm.IKitComponent;
/*     */ import dtv.xst.dao.itm.IKitComponentProperty;
/*     */ import dtv.xst.dao.itm.KitComponentPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class KitComponentModel extends AbstractDataModelWithPropertyImpl<IKitComponentProperty> implements IKitComponent {
/*     */   private static final long serialVersionUID = 673268455L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IKitComponentProperty> _properties; private transient HistoricalList<IKitComponentProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new KitComponentDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private KitComponentDAO getDAO_() {
/*  46 */     return (KitComponentDAO)this._daoImpl;
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
/*  70 */       this._events.post(IKitComponent.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<KitComponentPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((KitComponentPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getKitItemId() {
/* 101 */     return getDAO_().getKitItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKitItemId(String argKitItemId) {
/* 109 */     if (setKitItemId_noev(argKitItemId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IKitComponent.SET_KITITEMID, argKitItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setKitItemId_noev(String argKitItemId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getKitItemId() == null && argKitItemId != null) || (
/* 122 */       getDAO_().getKitItemId() != null && !getDAO_().getKitItemId().equals(argKitItemId))) {
/* 123 */       getDAO_().setKitItemId(argKitItemId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<KitComponentPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((KitComponentPropertyModel)it.next()).setKitItemId_noev(argKitItemId);
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
/*     */   public String getComponentItemId() {
/* 143 */     return getDAO_().getComponentItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/* 151 */     if (setComponentItemId_noev(argComponentItemId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IKitComponent.SET_COMPONENTITEMID, argComponentItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setComponentItemId_noev(String argComponentItemId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getComponentItemId() == null && argComponentItemId != null) || (
/* 164 */       getDAO_().getComponentItemId() != null && !getDAO_().getComponentItemId().equals(argComponentItemId))) {
/* 165 */       getDAO_().setComponentItemId(argComponentItemId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<KitComponentPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((KitComponentPropertyModel)it.next()).setComponentItemId_noev(argComponentItemId);
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
/*     */   public long getSequenceNumber() {
/* 185 */     if (getDAO_().getSequenceNumber() != null) {
/* 186 */       return getDAO_().getSequenceNumber().longValue();
/*     */     }
/*     */     
/* 189 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceNumber(long argSequenceNumber) {
/* 198 */     if (setSequenceNumber_noev(argSequenceNumber) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IKitComponent.SET_SEQUENCENUMBER, Long.valueOf(argSequenceNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequenceNumber_noev(long argSequenceNumber) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getSequenceNumber() == null && Long.valueOf(argSequenceNumber) != null) || (
/* 211 */       getDAO_().getSequenceNumber() != null && !getDAO_().getSequenceNumber().equals(Long.valueOf(argSequenceNumber)))) {
/* 212 */       getDAO_().setSequenceNumber(Long.valueOf(argSequenceNumber));
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<KitComponentPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((KitComponentPropertyModel)it.next()).setSequenceNumber_noev(argSequenceNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 232 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 240 */     if (setCreateDate_noev(argCreateDate) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IKitComponent.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 253 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 254 */       getDAO_().setCreateDate(argCreateDate);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 266 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 274 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(IKitComponent.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 287 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 288 */       getDAO_().setCreateUserId(argCreateUserId);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 300 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 308 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(IKitComponent.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 321 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 322 */       getDAO_().setUpdateDate(argUpdateDate);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 334 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 342 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(IKitComponent.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 355 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 356 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 368 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 376 */     if (setOrgCode_noev(argOrgCode) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(IKitComponent.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 389 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 390 */       getDAO_().setOrgCode(argOrgCode);
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 402 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 410 */     if (setOrgValue_noev(argOrgValue) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(IKitComponent.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 423 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 424 */       getDAO_().setOrgValue(argOrgValue);
/* 425 */       ev_postable = true;
/*     */     } 
/*     */     
/* 428 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayOrder() {
/* 436 */     if (getDAO_().getDisplayOrder() != null) {
/* 437 */       return getDAO_().getDisplayOrder().intValue();
/*     */     }
/*     */     
/* 440 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayOrder(int argDisplayOrder) {
/* 449 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IKitComponent.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/* 462 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/* 463 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQuantityPerKit() {
/* 475 */     if (getDAO_().getQuantityPerKit() != null) {
/* 476 */       return getDAO_().getQuantityPerKit().intValue();
/*     */     }
/*     */     
/* 479 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantityPerKit(int argQuantityPerKit) {
/* 488 */     if (setQuantityPerKit_noev(argQuantityPerKit) && 
/* 489 */       this._events != null && 
/* 490 */       postEventsForChanges()) {
/* 491 */       this._events.post(IKitComponent.SET_QUANTITYPERKIT, Integer.valueOf(argQuantityPerKit));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuantityPerKit_noev(int argQuantityPerKit) {
/* 498 */     boolean ev_postable = false;
/*     */     
/* 500 */     if ((getDAO_().getQuantityPerKit() == null && Integer.valueOf(argQuantityPerKit) != null) || (
/* 501 */       getDAO_().getQuantityPerKit() != null && !getDAO_().getQuantityPerKit().equals(Integer.valueOf(argQuantityPerKit)))) {
/* 502 */       getDAO_().setQuantityPerKit(Integer.valueOf(argQuantityPerKit));
/* 503 */       ev_postable = true;
/*     */     } 
/*     */     
/* 506 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBeginDatetime() {
/* 514 */     return getDAO_().getBeginDatetime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginDatetime(Date argBeginDatetime) {
/* 522 */     if (setBeginDatetime_noev(argBeginDatetime) && 
/* 523 */       this._events != null && 
/* 524 */       postEventsForChanges()) {
/* 525 */       this._events.post(IKitComponent.SET_BEGINDATETIME, argBeginDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginDatetime_noev(Date argBeginDatetime) {
/* 532 */     boolean ev_postable = false;
/*     */     
/* 534 */     if ((getDAO_().getBeginDatetime() == null && argBeginDatetime != null) || (
/* 535 */       getDAO_().getBeginDatetime() != null && !getDAO_().getBeginDatetime().equals(argBeginDatetime))) {
/* 536 */       getDAO_().setBeginDatetime(argBeginDatetime);
/* 537 */       ev_postable = true;
/*     */     } 
/*     */     
/* 540 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDatetime() {
/* 548 */     return getDAO_().getEndDatetime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndDatetime(Date argEndDatetime) {
/* 556 */     if (setEndDatetime_noev(argEndDatetime) && 
/* 557 */       this._events != null && 
/* 558 */       postEventsForChanges()) {
/* 559 */       this._events.post(IKitComponent.SET_ENDDATETIME, argEndDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndDatetime_noev(Date argEndDatetime) {
/* 566 */     boolean ev_postable = false;
/*     */     
/* 568 */     if ((getDAO_().getEndDatetime() == null && argEndDatetime != null) || (
/* 569 */       getDAO_().getEndDatetime() != null && !getDAO_().getEndDatetime().equals(argEndDatetime))) {
/* 570 */       getDAO_().setEndDatetime(argEndDatetime);
/* 571 */       ev_postable = true;
/*     */     } 
/*     */     
/* 574 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IKitComponentProperty newProperty(String argPropertyName) {
/* 578 */     KitComponentPropertyId id = new KitComponentPropertyId();
/*     */     
/* 580 */     id.setKitItemId(getKitItemId());
/* 581 */     id.setComponentItemId(getComponentItemId());
/* 582 */     id.setSequenceNumber(Long.valueOf(getSequenceNumber()));
/* 583 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 585 */     IKitComponentProperty prop = (IKitComponentProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IKitComponentProperty.class);
/* 586 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IKitComponentProperty> getProperties() {
/* 595 */     if (this._properties == null) {
/* 596 */       this._properties = new HistoricalList(null);
/*     */     }
/* 598 */     return (List<IKitComponentProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IKitComponentProperty> argProperties) {
/* 602 */     if (this._properties == null) {
/* 603 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 605 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 608 */     for (IKitComponentProperty child : this._properties) {
/* 609 */       KitComponentPropertyModel model = (KitComponentPropertyModel)child;
/* 610 */       model.setOrganizationId_noev(getOrganizationId());
/* 611 */       model.setKitItemId_noev(getKitItemId());
/* 612 */       model.setComponentItemId_noev(getComponentItemId());
/* 613 */       model.setSequenceNumber_noev(getSequenceNumber());
/* 614 */       if (child instanceof IDataModelImpl) {
/* 615 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 616 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 617 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 618 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 621 */       if (postEventsForChanges()) {
/* 622 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addKitComponentProperty(IKitComponentProperty argKitComponentProperty) {
/* 628 */     if (this._properties == null) {
/* 629 */       this._properties = new HistoricalList(null);
/*     */     }
/* 631 */     argKitComponentProperty.setOrganizationId(getOrganizationId());
/* 632 */     argKitComponentProperty.setKitItemId(getKitItemId());
/* 633 */     argKitComponentProperty.setComponentItemId(getComponentItemId());
/* 634 */     argKitComponentProperty.setSequenceNumber(getSequenceNumber());
/* 635 */     if (argKitComponentProperty instanceof IDataModelImpl) {
/* 636 */       IDataAccessObject childDao = ((IDataModelImpl)argKitComponentProperty).getDAO();
/* 637 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 638 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 639 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 644 */     if (postEventsForChanges()) {
/* 645 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponentProperty));
/*     */     }
/*     */     
/* 648 */     this._properties.add(argKitComponentProperty);
/* 649 */     if (postEventsForChanges()) {
/* 650 */       this._events.post(IKitComponent.ADD_PROPERTIES, argKitComponentProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeKitComponentProperty(IKitComponentProperty argKitComponentProperty) {
/* 655 */     if (this._properties != null) {
/*     */       
/* 657 */       if (postEventsForChanges()) {
/* 658 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponentProperty));
/*     */       }
/* 660 */       this._properties.remove(argKitComponentProperty);
/* 661 */       if (postEventsForChanges()) {
/* 662 */         this._events.post(IKitComponent.REMOVE_PROPERTIES, argKitComponentProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 669 */     if ("Properties".equals(argFieldId)) {
/* 670 */       return getProperties();
/*     */     }
/* 672 */     if ("KitComponentExtension".equals(argFieldId)) {
/* 673 */       return this._myExtension;
/*     */     }
/*     */     
/* 676 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 682 */     if ("Properties".equals(argFieldId)) {
/* 683 */       setProperties(changeToList(argValue, IKitComponentProperty.class));
/*     */     }
/* 685 */     else if ("KitComponentExtension".equals(argFieldId)) {
/* 686 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 689 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 695 */     this._persistenceDefaults = argPD;
/* 696 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 697 */     this._eventManager = argEM;
/* 698 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 699 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 700 */     if (this._properties != null) {
/* 701 */       for (IKitComponentProperty relationship : this._properties) {
/* 702 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getKitComponentExt() {
/* 708 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setKitComponentExt(IDataModel argExt) {
/* 712 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 717 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 721 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 724 */     super.startTransaction();
/*     */     
/* 726 */     this._propertiesSavepoint = this._properties;
/* 727 */     if (this._properties != null) {
/* 728 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 729 */       Iterator<IDataModel> it = this._properties.iterator();
/* 730 */       while (it.hasNext()) {
/* 731 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 736 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 741 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 744 */     super.rollbackChanges();
/*     */     
/* 746 */     this._properties = this._propertiesSavepoint;
/* 747 */     this._propertiesSavepoint = null;
/* 748 */     if (this._properties != null) {
/* 749 */       Iterator<IDataModel> it = this._properties.iterator();
/* 750 */       while (it.hasNext()) {
/* 751 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 759 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 762 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 765 */     super.commitTransaction();
/*     */     
/* 767 */     this._propertiesSavepoint = this._properties;
/* 768 */     if (this._properties != null) {
/* 769 */       Iterator<IDataModel> it = this._properties.iterator();
/* 770 */       while (it.hasNext()) {
/* 771 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 773 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 777 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 782 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\KitComponentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */