/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.CodeValuePropertyId;
/*     */ import dtv.xst.dao.com.ICodeValue;
/*     */ import dtv.xst.dao.com.ICodeValueProperty;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CodeValueModel extends CodeValueBaseModel implements ICodeValue {
/*     */   private static final long serialVersionUID = 868073316L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICodeValueProperty> _properties; private transient HistoricalList<ICodeValueProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new CodeValueDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CodeValueDAO getDAO_() {
/*  47 */     return (CodeValueDAO)this._daoImpl;
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
/*  71 */       this._events.post(ICodeValue.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  86 */         Iterator<CodeValuePropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((CodeValuePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCategory() {
/* 102 */     return getDAO_().getCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategory(String argCategory) {
/* 110 */     if (setCategory_noev(argCategory) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(ICodeValue.SET_CATEGORY, argCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCategory_noev(String argCategory) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getCategory() == null && argCategory != null) || (
/* 123 */       getDAO_().getCategory() != null && !getDAO_().getCategory().equals(argCategory))) {
/* 124 */       getDAO_().setCategory(argCategory);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<CodeValuePropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((CodeValuePropertyModel)it.next()).setCategory_noev(argCategory);
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
/*     */   public String getCode() {
/* 144 */     return getDAO_().getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCode(String argCode) {
/* 152 */     if (setCode_noev(argCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(ICodeValue.SET_CODE, argCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCode_noev(String argCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getCode() == null && argCode != null) || (
/* 165 */       getDAO_().getCode() != null && !getDAO_().getCode().equals(argCode))) {
/* 166 */       getDAO_().setCode(argCode);
/* 167 */       ev_postable = true;
/* 168 */       if (this._properties != null) {
/*     */         
/* 170 */         Iterator<CodeValuePropertyModel> it = this._properties.iterator();
/* 171 */         while (it.hasNext())
/*     */         {
/* 173 */           ((CodeValuePropertyModel)it.next()).setCode_noev(argCode);
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
/*     */   public Date getCreateDate() {
/* 186 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 194 */     if (setCreateDate_noev(argCreateDate) && 
/* 195 */       this._events != null && 
/* 196 */       postEventsForChanges()) {
/* 197 */       this._events.post(ICodeValue.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 204 */     boolean ev_postable = false;
/*     */     
/* 206 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 207 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 208 */       getDAO_().setCreateDate(argCreateDate);
/* 209 */       ev_postable = true;
/*     */     } 
/*     */     
/* 212 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 220 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 228 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 229 */       this._events != null && 
/* 230 */       postEventsForChanges()) {
/* 231 */       this._events.post(ICodeValue.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 238 */     boolean ev_postable = false;
/*     */     
/* 240 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 241 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 242 */       getDAO_().setCreateUserId(argCreateUserId);
/* 243 */       ev_postable = true;
/*     */     } 
/*     */     
/* 246 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 254 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 262 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 263 */       this._events != null && 
/* 264 */       postEventsForChanges()) {
/* 265 */       this._events.post(ICodeValue.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 272 */     boolean ev_postable = false;
/*     */     
/* 274 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 275 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 276 */       getDAO_().setUpdateDate(argUpdateDate);
/* 277 */       ev_postable = true;
/*     */     } 
/*     */     
/* 280 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 288 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 296 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 297 */       this._events != null && 
/* 298 */       postEventsForChanges()) {
/* 299 */       this._events.post(ICodeValue.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 306 */     boolean ev_postable = false;
/*     */     
/* 308 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 309 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 310 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 311 */       ev_postable = true;
/*     */     } 
/*     */     
/* 314 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigElement() {
/* 322 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 330 */     if (setConfigElement_noev(argConfigElement) && 
/* 331 */       this._events != null && 
/* 332 */       postEventsForChanges()) {
/* 333 */       this._events.post(ICodeValue.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 340 */     boolean ev_postable = false;
/*     */     
/* 342 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 343 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 344 */       getDAO_().setConfigElement(argConfigElement);
/* 345 */       ev_postable = true;
/*     */     } 
/*     */     
/* 348 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 356 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 364 */     if (setDescription_noev(argDescription) && 
/* 365 */       this._events != null && 
/* 366 */       postEventsForChanges()) {
/* 367 */       this._events.post(ICodeValue.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 374 */     boolean ev_postable = false;
/*     */     
/* 376 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 377 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 378 */       getDAO_().setDescription(argDescription);
/* 379 */       ev_postable = true;
/*     */     } 
/*     */     
/* 382 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 390 */     if (getDAO_().getSortOrder() != null) {
/* 391 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 394 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 403 */     if (setSortOrder_noev(argSortOrder) && 
/* 404 */       this._events != null && 
/* 405 */       postEventsForChanges()) {
/* 406 */       this._events.post(ICodeValue.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 413 */     boolean ev_postable = false;
/*     */     
/* 415 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 416 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 417 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 418 */       ev_postable = true;
/*     */     } 
/*     */     
/* 421 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHidden() {
/* 429 */     if (getDAO_().getHidden() != null) {
/* 430 */       return getDAO_().getHidden().booleanValue();
/*     */     }
/*     */     
/* 433 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(boolean argHidden) {
/* 442 */     if (setHidden_noev(argHidden) && 
/* 443 */       this._events != null && 
/* 444 */       postEventsForChanges()) {
/* 445 */       this._events.post(ICodeValue.SET_HIDDEN, Boolean.valueOf(argHidden));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHidden_noev(boolean argHidden) {
/* 452 */     boolean ev_postable = false;
/*     */     
/* 454 */     if ((getDAO_().getHidden() == null && Boolean.valueOf(argHidden) != null) || (
/* 455 */       getDAO_().getHidden() != null && !getDAO_().getHidden().equals(Boolean.valueOf(argHidden)))) {
/* 456 */       getDAO_().setHidden(Boolean.valueOf(argHidden));
/* 457 */       ev_postable = true;
/*     */     } 
/*     */     
/* 460 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRank() {
/* 468 */     if (getDAO_().getRank() != null) {
/* 469 */       return getDAO_().getRank().intValue();
/*     */     }
/*     */     
/* 472 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRank(int argRank) {
/* 481 */     if (setRank_noev(argRank) && 
/* 482 */       this._events != null && 
/* 483 */       postEventsForChanges()) {
/* 484 */       this._events.post(ICodeValue.SET_RANK, Integer.valueOf(argRank));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRank_noev(int argRank) {
/* 491 */     boolean ev_postable = false;
/*     */     
/* 493 */     if ((getDAO_().getRank() == null && Integer.valueOf(argRank) != null) || (
/* 494 */       getDAO_().getRank() != null && !getDAO_().getRank().equals(Integer.valueOf(argRank)))) {
/* 495 */       getDAO_().setRank(Integer.valueOf(argRank));
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
/*     */   public String getImageUrl() {
/* 507 */     return getDAO_().getImageUrl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 515 */     if (setImageUrl_noev(argImageUrl) && 
/* 516 */       this._events != null && 
/* 517 */       postEventsForChanges()) {
/* 518 */       this._events.post(ICodeValue.SET_IMAGEURL, argImageUrl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setImageUrl_noev(String argImageUrl) {
/* 525 */     boolean ev_postable = false;
/*     */     
/* 527 */     if ((getDAO_().getImageUrl() == null && argImageUrl != null) || (
/* 528 */       getDAO_().getImageUrl() != null && !getDAO_().getImageUrl().equals(argImageUrl))) {
/* 529 */       getDAO_().setImageUrl(argImageUrl);
/* 530 */       ev_postable = true;
/*     */     } 
/*     */     
/* 533 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICodeValueProperty newProperty(String argPropertyName) {
/* 537 */     CodeValuePropertyId id = new CodeValuePropertyId();
/*     */     
/* 539 */     id.setCategory(getCategory());
/* 540 */     id.setCode(getCode());
/* 541 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 543 */     ICodeValueProperty prop = (ICodeValueProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICodeValueProperty.class);
/* 544 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICodeValueProperty> getProperties() {
/* 553 */     if (this._properties == null) {
/* 554 */       this._properties = new HistoricalList(null);
/*     */     }
/* 556 */     return (List<ICodeValueProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICodeValueProperty> argProperties) {
/* 560 */     if (this._properties == null) {
/* 561 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 563 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 566 */     for (ICodeValueProperty child : this._properties) {
/* 567 */       CodeValuePropertyModel model = (CodeValuePropertyModel)child;
/* 568 */       model.setOrganizationId_noev(getOrganizationId());
/* 569 */       model.setCategory_noev(getCategory());
/* 570 */       model.setCode_noev(getCode());
/* 571 */       if (child instanceof IDataModelImpl) {
/* 572 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 573 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 574 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 575 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 578 */       if (postEventsForChanges()) {
/* 579 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCodeValueProperty(ICodeValueProperty argCodeValueProperty) {
/* 585 */     if (this._properties == null) {
/* 586 */       this._properties = new HistoricalList(null);
/*     */     }
/* 588 */     argCodeValueProperty.setOrganizationId(getOrganizationId());
/* 589 */     argCodeValueProperty.setCategory(getCategory());
/* 590 */     argCodeValueProperty.setCode(getCode());
/* 591 */     if (argCodeValueProperty instanceof IDataModelImpl) {
/* 592 */       IDataAccessObject childDao = ((IDataModelImpl)argCodeValueProperty).getDAO();
/* 593 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 594 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 595 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 600 */     if (postEventsForChanges()) {
/* 601 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCodeValueProperty));
/*     */     }
/*     */     
/* 604 */     this._properties.add(argCodeValueProperty);
/* 605 */     if (postEventsForChanges()) {
/* 606 */       this._events.post(ICodeValue.ADD_PROPERTIES, argCodeValueProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCodeValueProperty(ICodeValueProperty argCodeValueProperty) {
/* 611 */     if (this._properties != null) {
/*     */       
/* 613 */       if (postEventsForChanges()) {
/* 614 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCodeValueProperty));
/*     */       }
/* 616 */       this._properties.remove(argCodeValueProperty);
/* 617 */       if (postEventsForChanges()) {
/* 618 */         this._events.post(ICodeValue.REMOVE_PROPERTIES, argCodeValueProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 625 */     if ("Properties".equals(argFieldId)) {
/* 626 */       return getProperties();
/*     */     }
/* 628 */     if ("CodeValueExtension".equals(argFieldId)) {
/* 629 */       return this._myExtension;
/*     */     }
/*     */     
/* 632 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 638 */     if ("Properties".equals(argFieldId)) {
/* 639 */       setProperties(changeToList(argValue, ICodeValueProperty.class));
/*     */     }
/* 641 */     else if ("CodeValueExtension".equals(argFieldId)) {
/* 642 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 645 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 651 */     this._persistenceDefaults = argPD;
/* 652 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 653 */     this._eventManager = argEM;
/* 654 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 655 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 656 */     if (this._properties != null) {
/* 657 */       for (ICodeValueProperty relationship : this._properties) {
/* 658 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCodeValueExt() {
/* 664 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCodeValueExt(IDataModel argExt) {
/* 668 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 673 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 677 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 680 */     super.startTransaction();
/*     */     
/* 682 */     this._propertiesSavepoint = this._properties;
/* 683 */     if (this._properties != null) {
/* 684 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 685 */       Iterator<IDataModel> it = this._properties.iterator();
/* 686 */       while (it.hasNext()) {
/* 687 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 692 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 697 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 700 */     super.rollbackChanges();
/*     */     
/* 702 */     this._properties = this._propertiesSavepoint;
/* 703 */     this._propertiesSavepoint = null;
/* 704 */     if (this._properties != null) {
/* 705 */       Iterator<IDataModel> it = this._properties.iterator();
/* 706 */       while (it.hasNext()) {
/* 707 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 715 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 718 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 721 */     super.commitTransaction();
/*     */     
/* 723 */     this._propertiesSavepoint = this._properties;
/* 724 */     if (this._properties != null) {
/* 725 */       Iterator<IDataModel> it = this._properties.iterator();
/* 726 */       while (it.hasNext()) {
/* 727 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 729 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 733 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CodeValueModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */