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
/*     */ import dtv.xst.dao.loc.IOrgHierarchy;
/*     */ import dtv.xst.dao.loc.IOrgHierarchyProperty;
/*     */ import dtv.xst.dao.loc.OrgHierarchyPropertyId;
/*     */ import dtv.xst.daocommon.IHierarchyElement;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class OrgHierarchyModel extends OrgHierarchyBaseModel implements IOrgHierarchy {
/*     */   private static final long serialVersionUID = -323299375L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IOrgHierarchy _parentElement; private transient IOrgHierarchy _parentElementSavepoint; private HistoricalList<IOrgHierarchyProperty> _properties; private transient HistoricalList<IOrgHierarchyProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new OrgHierarchyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OrgHierarchyDAO getDAO_() {
/*  48 */     return (OrgHierarchyDAO)this._daoImpl;
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
/*  72 */       this._events.post(IOrgHierarchy.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<OrgHierarchyPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((OrgHierarchyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 114 */       this._events.post(IOrgHierarchy.SET_LEVELCODE, argLevelCode);
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
/* 129 */         Iterator<OrgHierarchyPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((OrgHierarchyPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
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
/* 156 */       this._events.post(IOrgHierarchy.SET_LEVELVALUE, argLevelValue);
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
/* 171 */         Iterator<OrgHierarchyPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((OrgHierarchyPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
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
/* 198 */       this._events.post(IOrgHierarchy.SET_CREATEDATE, argCreateDate);
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
/* 232 */       this._events.post(IOrgHierarchy.SET_CREATEUSERID, argCreateUserId);
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
/* 266 */       this._events.post(IOrgHierarchy.SET_UPDATEDATE, argUpdateDate);
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
/* 300 */       this._events.post(IOrgHierarchy.SET_UPDATEUSERID, argUpdateUserId);
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
/* 334 */       this._events.post(IOrgHierarchy.SET_PARENTCODE, argParentCode);
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
/* 368 */       this._events.post(IOrgHierarchy.SET_PARENTVALUE, argParentValue);
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
/* 402 */       this._events.post(IOrgHierarchy.SET_DESCRIPTION, argDescription);
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
/*     */   public String getLevelManager() {
/* 425 */     return getDAO_().getLevelManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelManager(String argLevelManager) {
/* 433 */     if (setLevelManager_noev(argLevelManager) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(IOrgHierarchy.SET_LEVELMANAGER, argLevelManager);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelManager_noev(String argLevelManager) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getLevelManager() == null && argLevelManager != null) || (
/* 446 */       getDAO_().getLevelManager() != null && !getDAO_().getLevelManager().equals(argLevelManager))) {
/* 447 */       getDAO_().setLevelManager(argLevelManager);
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevelOrder() {
/* 459 */     if (getDAO_().getLevelOrder() != null) {
/* 460 */       return getDAO_().getLevelOrder().intValue();
/*     */     }
/*     */     
/* 463 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelOrder(int argLevelOrder) {
/* 472 */     if (setLevelOrder_noev(argLevelOrder) && 
/* 473 */       this._events != null && 
/* 474 */       postEventsForChanges()) {
/* 475 */       this._events.post(IOrgHierarchy.SET_LEVELORDER, Integer.valueOf(argLevelOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelOrder_noev(int argLevelOrder) {
/* 482 */     boolean ev_postable = false;
/*     */     
/* 484 */     if ((getDAO_().getLevelOrder() == null && Integer.valueOf(argLevelOrder) != null) || (
/* 485 */       getDAO_().getLevelOrder() != null && !getDAO_().getLevelOrder().equals(Integer.valueOf(argLevelOrder)))) {
/* 486 */       getDAO_().setLevelOrder(Integer.valueOf(argLevelOrder));
/* 487 */       ev_postable = true;
/*     */     } 
/*     */     
/* 490 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 498 */     if (getDAO_().getSortOrder() != null) {
/* 499 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 502 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 511 */     if (setSortOrder_noev(argSortOrder) && 
/* 512 */       this._events != null && 
/* 513 */       postEventsForChanges()) {
/* 514 */       this._events.post(IOrgHierarchy.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 521 */     boolean ev_postable = false;
/*     */     
/* 523 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 524 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 525 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 526 */       ev_postable = true;
/*     */     } 
/*     */     
/* 529 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInactive() {
/* 537 */     if (getDAO_().getInactive() != null) {
/* 538 */       return getDAO_().getInactive().booleanValue();
/*     */     }
/*     */     
/* 541 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInactive(boolean argInactive) {
/* 550 */     if (setInactive_noev(argInactive) && 
/* 551 */       this._events != null && 
/* 552 */       postEventsForChanges()) {
/* 553 */       this._events.post(IOrgHierarchy.SET_INACTIVE, Boolean.valueOf(argInactive));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInactive_noev(boolean argInactive) {
/* 560 */     boolean ev_postable = false;
/*     */     
/* 562 */     if ((getDAO_().getInactive() == null && Boolean.valueOf(argInactive) != null) || (
/* 563 */       getDAO_().getInactive() != null && !getDAO_().getInactive().equals(Boolean.valueOf(argInactive)))) {
/* 564 */       getDAO_().setInactive(Boolean.valueOf(argInactive));
/* 565 */       ev_postable = true;
/*     */     } 
/*     */     
/* 568 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IOrgHierarchyProperty newProperty(String argPropertyName) {
/* 572 */     OrgHierarchyPropertyId id = new OrgHierarchyPropertyId();
/*     */     
/* 574 */     id.setLevelCode(getLevelCode());
/* 575 */     id.setLevelValue(getLevelValue());
/* 576 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 578 */     IOrgHierarchyProperty prop = (IOrgHierarchyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrgHierarchyProperty.class);
/* 579 */     return prop;
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
/*     */   public IOrgHierarchy getParentElement() {
/* 591 */     return this._parentElement;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParentElement(IOrgHierarchy argParentElement) {
/* 596 */     if (argParentElement == null) {
/*     */       
/* 598 */       getDAO_().setParentCode(null);
/* 599 */       getDAO_().setParentValue(null);
/* 600 */       if (this._parentElement != null)
/*     */       {
/* 602 */         if (postEventsForChanges()) {
/* 603 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._parentElement));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 608 */       getDAO_().setParentCode(argParentElement.getLevelCode());
/* 609 */       getDAO_().setParentValue(argParentElement.getLevelValue());
/*     */       
/* 611 */       if (postEventsForChanges()) {
/* 612 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argParentElement));
/*     */       }
/*     */     } 
/*     */     
/* 616 */     this._parentElement = argParentElement;
/* 617 */     if (postEventsForChanges()) {
/* 618 */       this._events.post(IOrgHierarchy.SET_PARENTELEMENT, argParentElement);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IOrgHierarchyProperty> getProperties() {
/* 624 */     if (this._properties == null) {
/* 625 */       this._properties = new HistoricalList(null);
/*     */     }
/* 627 */     return (List<IOrgHierarchyProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IOrgHierarchyProperty> argProperties) {
/* 631 */     if (this._properties == null) {
/* 632 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 634 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 637 */     for (IOrgHierarchyProperty child : this._properties) {
/* 638 */       OrgHierarchyPropertyModel model = (OrgHierarchyPropertyModel)child;
/* 639 */       model.setOrganizationId_noev(getOrganizationId());
/* 640 */       model.setLevelCode_noev(getLevelCode());
/* 641 */       model.setLevelValue_noev(getLevelValue());
/* 642 */       if (child instanceof IDataModelImpl) {
/* 643 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 644 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 645 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 646 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 649 */       if (postEventsForChanges()) {
/* 650 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addOrgHierarchyProperty(IOrgHierarchyProperty argOrgHierarchyProperty) {
/* 656 */     if (this._properties == null) {
/* 657 */       this._properties = new HistoricalList(null);
/*     */     }
/* 659 */     argOrgHierarchyProperty.setOrganizationId(getOrganizationId());
/* 660 */     argOrgHierarchyProperty.setLevelCode(getLevelCode());
/* 661 */     argOrgHierarchyProperty.setLevelValue(getLevelValue());
/* 662 */     if (argOrgHierarchyProperty instanceof IDataModelImpl) {
/* 663 */       IDataAccessObject childDao = ((IDataModelImpl)argOrgHierarchyProperty).getDAO();
/* 664 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 665 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 666 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 671 */     if (postEventsForChanges()) {
/* 672 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrgHierarchyProperty));
/*     */     }
/*     */     
/* 675 */     this._properties.add(argOrgHierarchyProperty);
/* 676 */     if (postEventsForChanges()) {
/* 677 */       this._events.post(IOrgHierarchy.ADD_PROPERTIES, argOrgHierarchyProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOrgHierarchyProperty(IOrgHierarchyProperty argOrgHierarchyProperty) {
/* 682 */     if (this._properties != null) {
/*     */       
/* 684 */       if (postEventsForChanges()) {
/* 685 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrgHierarchyProperty));
/*     */       }
/* 687 */       this._properties.remove(argOrgHierarchyProperty);
/* 688 */       if (postEventsForChanges()) {
/* 689 */         this._events.post(IOrgHierarchy.REMOVE_PROPERTIES, argOrgHierarchyProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 696 */     if ("ParentElement".equals(argFieldId)) {
/* 697 */       return getParentElement();
/*     */     }
/* 699 */     if ("Properties".equals(argFieldId)) {
/* 700 */       return getProperties();
/*     */     }
/* 702 */     if ("OrgHierarchyExtension".equals(argFieldId)) {
/* 703 */       return this._myExtension;
/*     */     }
/*     */     
/* 706 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 712 */     if ("ParentElement".equals(argFieldId)) {
/* 713 */       setParentElement((IOrgHierarchy)argValue);
/*     */     }
/* 715 */     else if ("Properties".equals(argFieldId)) {
/* 716 */       setProperties(changeToList(argValue, IOrgHierarchyProperty.class));
/*     */     }
/* 718 */     else if ("OrgHierarchyExtension".equals(argFieldId)) {
/* 719 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 722 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 728 */     this._persistenceDefaults = argPD;
/* 729 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 730 */     this._eventManager = argEM;
/* 731 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 732 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 733 */     if (this._parentElement != null) {
/* 734 */       ((IDataModelImpl)this._parentElement).setDependencies(argPD, argEM);
/*     */     }
/* 736 */     if (this._properties != null) {
/* 737 */       for (IOrgHierarchyProperty relationship : this._properties) {
/* 738 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getOrgHierarchyExt() {
/* 744 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setOrgHierarchyExt(IDataModel argExt) {
/* 748 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 753 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 757 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 760 */     super.startTransaction();
/*     */     
/* 762 */     this._parentElementSavepoint = this._parentElement;
/* 763 */     if (this._parentElement != null) {
/* 764 */       this._parentElement.startTransaction();
/*     */     }
/*     */     
/* 767 */     this._propertiesSavepoint = this._properties;
/* 768 */     if (this._properties != null) {
/* 769 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 770 */       Iterator<IDataModel> it = this._properties.iterator();
/* 771 */       while (it.hasNext()) {
/* 772 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 777 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 782 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 785 */     super.rollbackChanges();
/*     */     
/* 787 */     this._parentElement = this._parentElementSavepoint;
/* 788 */     this._parentElementSavepoint = null;
/* 789 */     if (this._parentElement != null) {
/* 790 */       this._parentElement.rollbackChanges();
/*     */     }
/*     */     
/* 793 */     this._properties = this._propertiesSavepoint;
/* 794 */     this._propertiesSavepoint = null;
/* 795 */     if (this._properties != null) {
/* 796 */       Iterator<IDataModel> it = this._properties.iterator();
/* 797 */       while (it.hasNext()) {
/* 798 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 806 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 809 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 812 */     super.commitTransaction();
/*     */     
/* 814 */     this._parentElementSavepoint = this._parentElement;
/* 815 */     if (this._parentElement != null) {
/* 816 */       this._parentElement.commitTransaction();
/*     */     }
/*     */     
/* 819 */     this._propertiesSavepoint = this._properties;
/* 820 */     if (this._properties != null) {
/* 821 */       Iterator<IDataModel> it = this._properties.iterator();
/* 822 */       while (it.hasNext()) {
/* 823 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 825 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 829 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\OrgHierarchyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */