/*     */ package dtv.xst.dao.loc.impl;
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
/*     */ import dtv.xst.dao.loc.IPricingHierarchy;
/*     */ import dtv.xst.dao.loc.IPricingHierarchyProperty;
/*     */ import dtv.xst.dao.loc.PricingHierarchyPropertyId;
/*     */ import dtv.xst.daocommon.IHierarchyElement;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PricingHierarchyModel extends PricingHierarchyBaseModel implements IPricingHierarchy {
/*     */   private static final long serialVersionUID = -1021266641L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IPricingHierarchy _parentElement; private transient IPricingHierarchy _parentElementSavepoint; private HistoricalList<IPricingHierarchyProperty> _properties; private transient HistoricalList<IPricingHierarchyProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new PricingHierarchyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PricingHierarchyDAO getDAO_() {
/*  48 */     return (PricingHierarchyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  56 */     if (getDAO_().getOrganizationId() != null) {
/*  57 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  60 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  70 */       this._events != null && 
/*  71 */       postEventsForChanges()) {
/*  72 */       this._events.post(IPricingHierarchy.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  79 */     boolean ev_postable = false;
/*     */     
/*  81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  84 */       ev_postable = true;
/*  85 */       if (this._properties != null) {
/*     */         
/*  87 */         Iterator<PricingHierarchyPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((PricingHierarchyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/* 103 */     return getDAO_().getLevelCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 111 */     if (setLevelCode_noev(argLevelCode) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IPricingHierarchy.SET_LEVELCODE, argLevelCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelCode_noev(String argLevelCode) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/* 124 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/* 125 */       getDAO_().setLevelCode(argLevelCode);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<PricingHierarchyPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((PricingHierarchyPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelValue() {
/* 145 */     return getDAO_().getLevelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/* 153 */     if (setLevelValue_noev(argLevelValue) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IPricingHierarchy.SET_LEVELVALUE, argLevelValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelValue_noev(String argLevelValue) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/* 166 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/* 167 */       getDAO_().setLevelValue(argLevelValue);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<PricingHierarchyPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((PricingHierarchyPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 187 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 195 */     if (setCreateDate_noev(argCreateDate) && 
/* 196 */       this._events != null && 
/* 197 */       postEventsForChanges()) {
/* 198 */       this._events.post(IPricingHierarchy.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 205 */     boolean ev_postable = false;
/*     */     
/* 207 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 208 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 209 */       getDAO_().setCreateDate(argCreateDate);
/* 210 */       ev_postable = true;
/*     */     } 
/*     */     
/* 213 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 221 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 229 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 230 */       this._events != null && 
/* 231 */       postEventsForChanges()) {
/* 232 */       this._events.post(IPricingHierarchy.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 239 */     boolean ev_postable = false;
/*     */     
/* 241 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 242 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 243 */       getDAO_().setCreateUserId(argCreateUserId);
/* 244 */       ev_postable = true;
/*     */     } 
/*     */     
/* 247 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 255 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 263 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(IPricingHierarchy.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 276 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 277 */       getDAO_().setUpdateDate(argUpdateDate);
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 289 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 297 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(IPricingHierarchy.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 310 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 311 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 312 */       ev_postable = true;
/*     */     } 
/*     */     
/* 315 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentCode() {
/* 323 */     return getDAO_().getParentCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentCode(String argParentCode) {
/* 331 */     if (setParentCode_noev(argParentCode) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(IPricingHierarchy.SET_PARENTCODE, argParentCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentCode_noev(String argParentCode) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getParentCode() == null && argParentCode != null) || (
/* 344 */       getDAO_().getParentCode() != null && !getDAO_().getParentCode().equals(argParentCode))) {
/* 345 */       getDAO_().setParentCode(argParentCode);
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentValue() {
/* 357 */     return getDAO_().getParentValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentValue(String argParentValue) {
/* 365 */     if (setParentValue_noev(argParentValue) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(IPricingHierarchy.SET_PARENTVALUE, argParentValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentValue_noev(String argParentValue) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getParentValue() == null && argParentValue != null) || (
/* 378 */       getDAO_().getParentValue() != null && !getDAO_().getParentValue().equals(argParentValue))) {
/* 379 */       getDAO_().setParentValue(argParentValue);
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 391 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 399 */     if (setDescription_noev(argDescription) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(IPricingHierarchy.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 412 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 413 */       getDAO_().setDescription(argDescription);
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevelOrder() {
/* 425 */     if (getDAO_().getLevelOrder() != null) {
/* 426 */       return getDAO_().getLevelOrder().intValue();
/*     */     }
/*     */     
/* 429 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelOrder(int argLevelOrder) {
/* 438 */     if (setLevelOrder_noev(argLevelOrder) && 
/* 439 */       this._events != null && 
/* 440 */       postEventsForChanges()) {
/* 441 */       this._events.post(IPricingHierarchy.SET_LEVELORDER, Integer.valueOf(argLevelOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelOrder_noev(int argLevelOrder) {
/* 448 */     boolean ev_postable = false;
/*     */     
/* 450 */     if ((getDAO_().getLevelOrder() == null && Integer.valueOf(argLevelOrder) != null) || (
/* 451 */       getDAO_().getLevelOrder() != null && !getDAO_().getLevelOrder().equals(Integer.valueOf(argLevelOrder)))) {
/* 452 */       getDAO_().setLevelOrder(Integer.valueOf(argLevelOrder));
/* 453 */       ev_postable = true;
/*     */     } 
/*     */     
/* 456 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 464 */     if (getDAO_().getSortOrder() != null) {
/* 465 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 468 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 477 */     if (setSortOrder_noev(argSortOrder) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(IPricingHierarchy.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 490 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 491 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IPricingHierarchyProperty newProperty(String argPropertyName) {
/* 499 */     PricingHierarchyPropertyId id = new PricingHierarchyPropertyId();
/*     */     
/* 501 */     id.setLevelCode(getLevelCode());
/* 502 */     id.setLevelValue(getLevelValue());
/* 503 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 505 */     IPricingHierarchyProperty prop = (IPricingHierarchyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPricingHierarchyProperty.class);
/* 506 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "ParentElement")
/*     */   public IPricingHierarchy getParentElement() {
/* 518 */     return this._parentElement;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParentElement(IPricingHierarchy argParentElement) {
/* 523 */     if (argParentElement == null) {
/*     */       
/* 525 */       getDAO_().setParentCode(null);
/* 526 */       getDAO_().setParentValue(null);
/* 527 */       if (this._parentElement != null)
/*     */       {
/* 529 */         if (postEventsForChanges()) {
/* 530 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._parentElement));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 535 */       getDAO_().setParentCode(argParentElement.getLevelCode());
/* 536 */       getDAO_().setParentValue(argParentElement.getLevelValue());
/*     */       
/* 538 */       if (postEventsForChanges()) {
/* 539 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argParentElement));
/*     */       }
/*     */     } 
/*     */     
/* 543 */     this._parentElement = argParentElement;
/* 544 */     if (postEventsForChanges()) {
/* 545 */       this._events.post(IPricingHierarchy.SET_PARENTELEMENT, argParentElement);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IPricingHierarchyProperty> getProperties() {
/* 551 */     if (this._properties == null) {
/* 552 */       this._properties = new HistoricalList(null);
/*     */     }
/* 554 */     return (List<IPricingHierarchyProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IPricingHierarchyProperty> argProperties) {
/* 558 */     if (this._properties == null) {
/* 559 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 561 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 564 */     for (IPricingHierarchyProperty child : this._properties) {
/* 565 */       PricingHierarchyPropertyModel model = (PricingHierarchyPropertyModel)child;
/* 566 */       model.setOrganizationId_noev(getOrganizationId());
/* 567 */       model.setLevelCode_noev(getLevelCode());
/* 568 */       model.setLevelValue_noev(getLevelValue());
/* 569 */       if (child instanceof IDataModelImpl) {
/* 570 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 571 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 572 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 573 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 576 */       if (postEventsForChanges()) {
/* 577 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPricingHierarchyProperty(IPricingHierarchyProperty argPricingHierarchyProperty) {
/* 583 */     if (this._properties == null) {
/* 584 */       this._properties = new HistoricalList(null);
/*     */     }
/* 586 */     argPricingHierarchyProperty.setOrganizationId(getOrganizationId());
/* 587 */     argPricingHierarchyProperty.setLevelCode(getLevelCode());
/* 588 */     argPricingHierarchyProperty.setLevelValue(getLevelValue());
/* 589 */     if (argPricingHierarchyProperty instanceof IDataModelImpl) {
/* 590 */       IDataAccessObject childDao = ((IDataModelImpl)argPricingHierarchyProperty).getDAO();
/* 591 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 592 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 593 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 598 */     if (postEventsForChanges()) {
/* 599 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPricingHierarchyProperty));
/*     */     }
/*     */     
/* 602 */     this._properties.add(argPricingHierarchyProperty);
/* 603 */     if (postEventsForChanges()) {
/* 604 */       this._events.post(IPricingHierarchy.ADD_PROPERTIES, argPricingHierarchyProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePricingHierarchyProperty(IPricingHierarchyProperty argPricingHierarchyProperty) {
/* 609 */     if (this._properties != null) {
/*     */       
/* 611 */       if (postEventsForChanges()) {
/* 612 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPricingHierarchyProperty));
/*     */       }
/* 614 */       this._properties.remove(argPricingHierarchyProperty);
/* 615 */       if (postEventsForChanges()) {
/* 616 */         this._events.post(IPricingHierarchy.REMOVE_PROPERTIES, argPricingHierarchyProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 623 */     if ("ParentElement".equals(argFieldId)) {
/* 624 */       return getParentElement();
/*     */     }
/* 626 */     if ("Properties".equals(argFieldId)) {
/* 627 */       return getProperties();
/*     */     }
/* 629 */     if ("PricingHierarchyExtension".equals(argFieldId)) {
/* 630 */       return this._myExtension;
/*     */     }
/*     */     
/* 633 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 639 */     if ("ParentElement".equals(argFieldId)) {
/* 640 */       setParentElement((IPricingHierarchy)argValue);
/*     */     }
/* 642 */     else if ("Properties".equals(argFieldId)) {
/* 643 */       setProperties(changeToList(argValue, IPricingHierarchyProperty.class));
/*     */     }
/* 645 */     else if ("PricingHierarchyExtension".equals(argFieldId)) {
/* 646 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 649 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 655 */     this._persistenceDefaults = argPD;
/* 656 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 657 */     this._eventManager = argEM;
/* 658 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 659 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 660 */     if (this._parentElement != null) {
/* 661 */       ((IDataModelImpl)this._parentElement).setDependencies(argPD, argEM);
/*     */     }
/* 663 */     if (this._properties != null) {
/* 664 */       for (IPricingHierarchyProperty relationship : this._properties) {
/* 665 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getPricingHierarchyExt() {
/* 671 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setPricingHierarchyExt(IDataModel argExt) {
/* 675 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 680 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 684 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 687 */     super.startTransaction();
/*     */     
/* 689 */     this._parentElementSavepoint = this._parentElement;
/* 690 */     if (this._parentElement != null) {
/* 691 */       this._parentElement.startTransaction();
/*     */     }
/*     */     
/* 694 */     this._propertiesSavepoint = this._properties;
/* 695 */     if (this._properties != null) {
/* 696 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 697 */       Iterator<IDataModel> it = this._properties.iterator();
/* 698 */       while (it.hasNext()) {
/* 699 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 704 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 709 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 712 */     super.rollbackChanges();
/*     */     
/* 714 */     this._parentElement = this._parentElementSavepoint;
/* 715 */     this._parentElementSavepoint = null;
/* 716 */     if (this._parentElement != null) {
/* 717 */       this._parentElement.rollbackChanges();
/*     */     }
/*     */     
/* 720 */     this._properties = this._propertiesSavepoint;
/* 721 */     this._propertiesSavepoint = null;
/* 722 */     if (this._properties != null) {
/* 723 */       Iterator<IDataModel> it = this._properties.iterator();
/* 724 */       while (it.hasNext()) {
/* 725 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 733 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 736 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 739 */     super.commitTransaction();
/*     */     
/* 741 */     this._parentElementSavepoint = this._parentElement;
/* 742 */     if (this._parentElement != null) {
/* 743 */       this._parentElement.commitTransaction();
/*     */     }
/*     */     
/* 746 */     this._propertiesSavepoint = this._properties;
/* 747 */     if (this._properties != null) {
/* 748 */       Iterator<IDataModel> it = this._properties.iterator();
/* 749 */       while (it.hasNext()) {
/* 750 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 752 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 756 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\PricingHierarchyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */