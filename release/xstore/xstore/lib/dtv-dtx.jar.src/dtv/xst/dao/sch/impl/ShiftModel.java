/*     */ package dtv.xst.dao.sch.impl;
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
/*     */ import dtv.xst.dao.sch.IShift;
/*     */ import dtv.xst.dao.sch.IShiftProperty;
/*     */ import dtv.xst.dao.sch.ShiftPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShiftModel extends AbstractDataModelWithPropertyImpl<IShiftProperty> implements IShift {
/*     */   private static final long serialVersionUID = 79854690L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IShiftProperty> _properties; private transient HistoricalList<IShiftProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ShiftDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShiftDAO getDAO_() {
/*  46 */     return (ShiftDAO)this._daoImpl;
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
/*  70 */       this._events.post(IShift.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ShiftPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ShiftPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getShiftId() {
/* 101 */     if (getDAO_().getShiftId() != null) {
/* 102 */       return getDAO_().getShiftId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShiftId(long argShiftId) {
/* 114 */     if (setShiftId_noev(argShiftId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IShift.SET_SHIFTID, Long.valueOf(argShiftId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShiftId_noev(long argShiftId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getShiftId() == null && Long.valueOf(argShiftId) != null) || (
/* 127 */       getDAO_().getShiftId() != null && !getDAO_().getShiftId().equals(Long.valueOf(argShiftId)))) {
/* 128 */       getDAO_().setShiftId(Long.valueOf(argShiftId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<ShiftPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((ShiftPropertyModel)it.next()).setShiftId_noev(argShiftId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 148 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 156 */     if (setOrgCode_noev(argOrgCode) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IShift.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 169 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 170 */       getDAO_().setOrgCode(argOrgCode);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 182 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 190 */     if (setOrgValue_noev(argOrgValue) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(IShift.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 203 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 204 */       getDAO_().setOrgValue(argOrgValue);
/* 205 */       ev_postable = true;
/*     */     } 
/*     */     
/* 208 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 216 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 224 */     if (setCreateDate_noev(argCreateDate) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(IShift.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 237 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 238 */       getDAO_().setCreateDate(argCreateDate);
/* 239 */       ev_postable = true;
/*     */     } 
/*     */     
/* 242 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 250 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 258 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(IShift.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 271 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 272 */       getDAO_().setCreateUserId(argCreateUserId);
/* 273 */       ev_postable = true;
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 284 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 292 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IShift.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 305 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 306 */       getDAO_().setUpdateDate(argUpdateDate);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 318 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 326 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(IShift.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 339 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 340 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 352 */     return getDAO_().getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 360 */     if (setName_noev(argName) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(IShift.SET_NAME, argName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setName_noev(String argName) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getName() == null && argName != null) || (
/* 373 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/* 374 */       getDAO_().setName(argName);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 386 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 394 */     if (setDescription_noev(argDescription) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(IShift.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 407 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 408 */       getDAO_().setDescription(argDescription);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkCode() {
/* 420 */     return getDAO_().getWorkCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCode(String argWorkCode) {
/* 428 */     if (setWorkCode_noev(argWorkCode) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(IShift.SET_WORKCODE, argWorkCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkCode_noev(String argWorkCode) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getWorkCode() == null && argWorkCode != null) || (
/* 441 */       getDAO_().getWorkCode() != null && !getDAO_().getWorkCode().equals(argWorkCode))) {
/* 442 */       getDAO_().setWorkCode(argWorkCode);
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartTime() {
/* 454 */     return getDAO_().getStartTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartTime(Date argStartTime) {
/* 462 */     if (setStartTime_noev(argStartTime) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(IShift.SET_STARTTIME, argStartTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStartTime_noev(Date argStartTime) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/* 475 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/* 476 */       getDAO_().setStartTime(argStartTime);
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndTime() {
/* 488 */     return getDAO_().getEndTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndTime(Date argEndTime) {
/* 496 */     if (setEndTime_noev(argEndTime) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(IShift.SET_ENDTIME, argEndTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndTime_noev(Date argEndTime) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/* 509 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/* 510 */       getDAO_().setEndTime(argEndTime);
/* 511 */       ev_postable = true;
/*     */     } 
/*     */     
/* 514 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVoid() {
/* 522 */     if (getDAO_().getVoid() != null) {
/* 523 */       return getDAO_().getVoid().booleanValue();
/*     */     }
/*     */     
/* 526 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoid(boolean argVoid) {
/* 535 */     if (setVoid_noev(argVoid) && 
/* 536 */       this._events != null && 
/* 537 */       postEventsForChanges()) {
/* 538 */       this._events.post(IShift.SET_VOID, Boolean.valueOf(argVoid));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoid_noev(boolean argVoid) {
/* 545 */     boolean ev_postable = false;
/*     */     
/* 547 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/* 548 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/* 549 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/* 550 */       ev_postable = true;
/*     */     } 
/*     */     
/* 553 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getBreakDuration() {
/* 561 */     if (getDAO_().getBreakDuration() != null) {
/* 562 */       return getDAO_().getBreakDuration().longValue();
/*     */     }
/*     */     
/* 565 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBreakDuration(long argBreakDuration) {
/* 574 */     if (setBreakDuration_noev(argBreakDuration) && 
/* 575 */       this._events != null && 
/* 576 */       postEventsForChanges()) {
/* 577 */       this._events.post(IShift.SET_BREAKDURATION, Long.valueOf(argBreakDuration));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBreakDuration_noev(long argBreakDuration) {
/* 584 */     boolean ev_postable = false;
/*     */     
/* 586 */     if ((getDAO_().getBreakDuration() == null && Long.valueOf(argBreakDuration) != null) || (
/* 587 */       getDAO_().getBreakDuration() != null && !getDAO_().getBreakDuration().equals(Long.valueOf(argBreakDuration)))) {
/* 588 */       getDAO_().setBreakDuration(Long.valueOf(argBreakDuration));
/* 589 */       ev_postable = true;
/*     */     } 
/*     */     
/* 592 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShiftProperty newProperty(String argPropertyName) {
/* 596 */     ShiftPropertyId id = new ShiftPropertyId();
/*     */     
/* 598 */     id.setShiftId(Long.valueOf(getShiftId()));
/* 599 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 601 */     IShiftProperty prop = (IShiftProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShiftProperty.class);
/* 602 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShiftProperty> getProperties() {
/* 611 */     if (this._properties == null) {
/* 612 */       this._properties = new HistoricalList(null);
/*     */     }
/* 614 */     return (List<IShiftProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShiftProperty> argProperties) {
/* 618 */     if (this._properties == null) {
/* 619 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 621 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 624 */     for (IShiftProperty child : this._properties) {
/* 625 */       ShiftPropertyModel model = (ShiftPropertyModel)child;
/* 626 */       model.setOrganizationId_noev(getOrganizationId());
/* 627 */       model.setShiftId_noev(getShiftId());
/* 628 */       if (child instanceof IDataModelImpl) {
/* 629 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 630 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 631 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 632 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 635 */       if (postEventsForChanges()) {
/* 636 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShiftProperty(IShiftProperty argShiftProperty) {
/* 642 */     if (this._properties == null) {
/* 643 */       this._properties = new HistoricalList(null);
/*     */     }
/* 645 */     argShiftProperty.setOrganizationId(getOrganizationId());
/* 646 */     argShiftProperty.setShiftId(getShiftId());
/* 647 */     if (argShiftProperty instanceof IDataModelImpl) {
/* 648 */       IDataAccessObject childDao = ((IDataModelImpl)argShiftProperty).getDAO();
/* 649 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 650 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 651 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 656 */     if (postEventsForChanges()) {
/* 657 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShiftProperty));
/*     */     }
/*     */     
/* 660 */     this._properties.add(argShiftProperty);
/* 661 */     if (postEventsForChanges()) {
/* 662 */       this._events.post(IShift.ADD_PROPERTIES, argShiftProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShiftProperty(IShiftProperty argShiftProperty) {
/* 667 */     if (this._properties != null) {
/*     */       
/* 669 */       if (postEventsForChanges()) {
/* 670 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShiftProperty));
/*     */       }
/* 672 */       this._properties.remove(argShiftProperty);
/* 673 */       if (postEventsForChanges()) {
/* 674 */         this._events.post(IShift.REMOVE_PROPERTIES, argShiftProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 681 */     if ("Properties".equals(argFieldId)) {
/* 682 */       return getProperties();
/*     */     }
/* 684 */     if ("ShiftExtension".equals(argFieldId)) {
/* 685 */       return this._myExtension;
/*     */     }
/*     */     
/* 688 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 694 */     if ("Properties".equals(argFieldId)) {
/* 695 */       setProperties(changeToList(argValue, IShiftProperty.class));
/*     */     }
/* 697 */     else if ("ShiftExtension".equals(argFieldId)) {
/* 698 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 701 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 707 */     this._persistenceDefaults = argPD;
/* 708 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 709 */     this._eventManager = argEM;
/* 710 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 711 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 712 */     if (this._properties != null) {
/* 713 */       for (IShiftProperty relationship : this._properties) {
/* 714 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShiftExt() {
/* 720 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShiftExt(IDataModel argExt) {
/* 724 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 729 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 733 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 736 */     super.startTransaction();
/*     */     
/* 738 */     this._propertiesSavepoint = this._properties;
/* 739 */     if (this._properties != null) {
/* 740 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 741 */       Iterator<IDataModel> it = this._properties.iterator();
/* 742 */       while (it.hasNext()) {
/* 743 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 748 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 753 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 756 */     super.rollbackChanges();
/*     */     
/* 758 */     this._properties = this._propertiesSavepoint;
/* 759 */     this._propertiesSavepoint = null;
/* 760 */     if (this._properties != null) {
/* 761 */       Iterator<IDataModel> it = this._properties.iterator();
/* 762 */       while (it.hasNext()) {
/* 763 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 771 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 774 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 777 */     super.commitTransaction();
/*     */     
/* 779 */     this._propertiesSavepoint = this._properties;
/* 780 */     if (this._properties != null) {
/* 781 */       Iterator<IDataModel> it = this._properties.iterator();
/* 782 */       while (it.hasNext()) {
/* 783 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 785 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 789 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 794 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sch\impl\ShiftModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */