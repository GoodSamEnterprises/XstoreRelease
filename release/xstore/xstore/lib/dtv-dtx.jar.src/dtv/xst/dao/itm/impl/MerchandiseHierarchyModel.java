/*     */ package dtv.xst.dao.itm.impl;
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
/*     */ import dtv.xst.dao.itm.IMerchandiseHierarchy;
/*     */ import dtv.xst.dao.itm.IMerchandiseHierarchyProperty;
/*     */ import dtv.xst.dao.itm.MerchandiseHierarchyPropertyId;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MerchandiseHierarchyModel extends MerchandiseHierarchyBaseModel implements IMerchandiseHierarchy {
/*     */   private static final long serialVersionUID = -746218030L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IMerchandiseHierarchyProperty> _properties; private transient HistoricalList<IMerchandiseHierarchyProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new MerchandiseHierarchyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MerchandiseHierarchyDAO getDAO_() {
/*  47 */     return (MerchandiseHierarchyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHierarchyId() {
/*  55 */     return getDAO_().getHierarchyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHierarchyId(String argHierarchyId) {
/*  63 */     if (setHierarchyId_noev(argHierarchyId) && 
/*  64 */       this._events != null && 
/*  65 */       postEventsForChanges()) {
/*  66 */       this._events.post(IMerchandiseHierarchy.SET_HIERARCHYID, argHierarchyId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHierarchyId_noev(String argHierarchyId) {
/*  73 */     boolean ev_postable = false;
/*     */     
/*  75 */     if ((getDAO_().getHierarchyId() == null && argHierarchyId != null) || (
/*  76 */       getDAO_().getHierarchyId() != null && !getDAO_().getHierarchyId().equals(argHierarchyId))) {
/*  77 */       getDAO_().setHierarchyId(argHierarchyId);
/*  78 */       ev_postable = true;
/*  79 */       if (this._properties != null) {
/*     */         
/*  81 */         Iterator<MerchandiseHierarchyPropertyModel> it = this._properties.iterator();
/*  82 */         while (it.hasNext())
/*     */         {
/*  84 */           ((MerchandiseHierarchyPropertyModel)it.next()).setHierarchyId_noev(argHierarchyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  97 */     if (getDAO_().getOrganizationId() != null) {
/*  98 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 101 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 110 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IMerchandiseHierarchy.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 123 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 124 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<MerchandiseHierarchyPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((MerchandiseHierarchyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getOrgCode() {
/* 144 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 152 */     if (setOrgCode_noev(argOrgCode) && 
/* 153 */       this._events != null && 
/* 154 */       postEventsForChanges()) {
/* 155 */       this._events.post(IMerchandiseHierarchy.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 162 */     boolean ev_postable = false;
/*     */     
/* 164 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 165 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 166 */       getDAO_().setOrgCode(argOrgCode);
/* 167 */       ev_postable = true;
/*     */     } 
/*     */     
/* 170 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 178 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 186 */     if (setOrgValue_noev(argOrgValue) && 
/* 187 */       this._events != null && 
/* 188 */       postEventsForChanges()) {
/* 189 */       this._events.post(IMerchandiseHierarchy.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 196 */     boolean ev_postable = false;
/*     */     
/* 198 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 199 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 200 */       getDAO_().setOrgValue(argOrgValue);
/* 201 */       ev_postable = true;
/*     */     } 
/*     */     
/* 204 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 212 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 220 */     if (setCreateDate_noev(argCreateDate) && 
/* 221 */       this._events != null && 
/* 222 */       postEventsForChanges()) {
/* 223 */       this._events.post(IMerchandiseHierarchy.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 230 */     boolean ev_postable = false;
/*     */     
/* 232 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 233 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 234 */       getDAO_().setCreateDate(argCreateDate);
/* 235 */       ev_postable = true;
/*     */     } 
/*     */     
/* 238 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 246 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 254 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 255 */       this._events != null && 
/* 256 */       postEventsForChanges()) {
/* 257 */       this._events.post(IMerchandiseHierarchy.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 264 */     boolean ev_postable = false;
/*     */     
/* 266 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 267 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 268 */       getDAO_().setCreateUserId(argCreateUserId);
/* 269 */       ev_postable = true;
/*     */     } 
/*     */     
/* 272 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 280 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 288 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 289 */       this._events != null && 
/* 290 */       postEventsForChanges()) {
/* 291 */       this._events.post(IMerchandiseHierarchy.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 298 */     boolean ev_postable = false;
/*     */     
/* 300 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 301 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 302 */       getDAO_().setUpdateDate(argUpdateDate);
/* 303 */       ev_postable = true;
/*     */     } 
/*     */     
/* 306 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 314 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 322 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 323 */       this._events != null && 
/* 324 */       postEventsForChanges()) {
/* 325 */       this._events.post(IMerchandiseHierarchy.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 332 */     boolean ev_postable = false;
/*     */     
/* 334 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 335 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 336 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 337 */       ev_postable = true;
/*     */     } 
/*     */     
/* 340 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentId() {
/* 348 */     return getDAO_().getParentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentId(String argParentId) {
/* 356 */     if (setParentId_noev(argParentId) && 
/* 357 */       this._events != null && 
/* 358 */       postEventsForChanges()) {
/* 359 */       this._events.post(IMerchandiseHierarchy.SET_PARENTID, argParentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParentId_noev(String argParentId) {
/* 366 */     boolean ev_postable = false;
/*     */     
/* 368 */     if ((getDAO_().getParentId() == null && argParentId != null) || (
/* 369 */       getDAO_().getParentId() != null && !getDAO_().getParentId().equals(argParentId))) {
/* 370 */       getDAO_().setParentId(argParentId);
/* 371 */       ev_postable = true;
/*     */     } 
/*     */     
/* 374 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 382 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 390 */     if (setDescription_noev(argDescription) && 
/* 391 */       this._events != null && 
/* 392 */       postEventsForChanges()) {
/* 393 */       this._events.post(IMerchandiseHierarchy.SET_DESCRIPTION, argDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDescription_noev(String argDescription) {
/* 400 */     boolean ev_postable = false;
/*     */     
/* 402 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/* 403 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/* 404 */       getDAO_().setDescription(argDescription);
/* 405 */       ev_postable = true;
/*     */     } 
/*     */     
/* 408 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/* 416 */     return getDAO_().getLevelCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 424 */     if (setLevelCode_noev(argLevelCode) && 
/* 425 */       this._events != null && 
/* 426 */       postEventsForChanges()) {
/* 427 */       this._events.post(IMerchandiseHierarchy.SET_LEVELCODE, argLevelCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLevelCode_noev(String argLevelCode) {
/* 434 */     boolean ev_postable = false;
/*     */     
/* 436 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/* 437 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/* 438 */       getDAO_().setLevelCode(argLevelCode);
/* 439 */       ev_postable = true;
/*     */     } 
/*     */     
/* 442 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 450 */     if (getDAO_().getSortOrder() != null) {
/* 451 */       return getDAO_().getSortOrder().intValue();
/*     */     }
/*     */     
/* 454 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 463 */     if (setSortOrder_noev(argSortOrder) && 
/* 464 */       this._events != null && 
/* 465 */       postEventsForChanges()) {
/* 466 */       this._events.post(IMerchandiseHierarchy.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSortOrder_noev(int argSortOrder) {
/* 473 */     boolean ev_postable = false;
/*     */     
/* 475 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 476 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 477 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 478 */       ev_postable = true;
/*     */     } 
/*     */     
/* 481 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHidden() {
/* 489 */     if (getDAO_().getHidden() != null) {
/* 490 */       return getDAO_().getHidden().booleanValue();
/*     */     }
/*     */     
/* 493 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(boolean argHidden) {
/* 502 */     if (setHidden_noev(argHidden) && 
/* 503 */       this._events != null && 
/* 504 */       postEventsForChanges()) {
/* 505 */       this._events.post(IMerchandiseHierarchy.SET_HIDDEN, Boolean.valueOf(argHidden));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHidden_noev(boolean argHidden) {
/* 512 */     boolean ev_postable = false;
/*     */     
/* 514 */     if ((getDAO_().getHidden() == null && Boolean.valueOf(argHidden) != null) || (
/* 515 */       getDAO_().getHidden() != null && !getDAO_().getHidden().equals(Boolean.valueOf(argHidden)))) {
/* 516 */       getDAO_().setHidden(Boolean.valueOf(argHidden));
/* 517 */       ev_postable = true;
/*     */     } 
/*     */     
/* 520 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisallowItemMatrixDisplay() {
/* 528 */     if (getDAO_().getDisallowItemMatrixDisplay() != null) {
/* 529 */       return getDAO_().getDisallowItemMatrixDisplay().booleanValue();
/*     */     }
/*     */     
/* 532 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisallowItemMatrixDisplay(boolean argDisallowItemMatrixDisplay) {
/* 541 */     if (setDisallowItemMatrixDisplay_noev(argDisallowItemMatrixDisplay) && 
/* 542 */       this._events != null && 
/* 543 */       postEventsForChanges()) {
/* 544 */       this._events.post(IMerchandiseHierarchy.SET_DISALLOWITEMMATRIXDISPLAY, Boolean.valueOf(argDisallowItemMatrixDisplay));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisallowItemMatrixDisplay_noev(boolean argDisallowItemMatrixDisplay) {
/* 551 */     boolean ev_postable = false;
/*     */     
/* 553 */     if ((getDAO_().getDisallowItemMatrixDisplay() == null && Boolean.valueOf(argDisallowItemMatrixDisplay) != null) || (
/* 554 */       getDAO_().getDisallowItemMatrixDisplay() != null && !getDAO_().getDisallowItemMatrixDisplay().equals(Boolean.valueOf(argDisallowItemMatrixDisplay)))) {
/* 555 */       getDAO_().setDisallowItemMatrixDisplay(Boolean.valueOf(argDisallowItemMatrixDisplay));
/* 556 */       ev_postable = true;
/*     */     } 
/*     */     
/* 559 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemMatrixColor() {
/* 567 */     return getDAO_().getItemMatrixColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemMatrixColor(String argItemMatrixColor) {
/* 575 */     if (setItemMatrixColor_noev(argItemMatrixColor) && 
/* 576 */       this._events != null && 
/* 577 */       postEventsForChanges()) {
/* 578 */       this._events.post(IMerchandiseHierarchy.SET_ITEMMATRIXCOLOR, argItemMatrixColor);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemMatrixColor_noev(String argItemMatrixColor) {
/* 585 */     boolean ev_postable = false;
/*     */     
/* 587 */     if ((getDAO_().getItemMatrixColor() == null && argItemMatrixColor != null) || (
/* 588 */       getDAO_().getItemMatrixColor() != null && !getDAO_().getItemMatrixColor().equals(argItemMatrixColor))) {
/* 589 */       getDAO_().setItemMatrixColor(argItemMatrixColor);
/* 590 */       ev_postable = true;
/*     */     } 
/*     */     
/* 593 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IMerchandiseHierarchyProperty newProperty(String argPropertyName) {
/* 597 */     MerchandiseHierarchyPropertyId id = new MerchandiseHierarchyPropertyId();
/*     */     
/* 599 */     id.setHierarchyId(getHierarchyId());
/* 600 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 602 */     IMerchandiseHierarchyProperty prop = (IMerchandiseHierarchyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IMerchandiseHierarchyProperty.class);
/* 603 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IMerchandiseHierarchyProperty> getProperties() {
/* 612 */     if (this._properties == null) {
/* 613 */       this._properties = new HistoricalList(null);
/*     */     }
/* 615 */     return (List<IMerchandiseHierarchyProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IMerchandiseHierarchyProperty> argProperties) {
/* 619 */     if (this._properties == null) {
/* 620 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 622 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 625 */     for (IMerchandiseHierarchyProperty child : this._properties) {
/* 626 */       MerchandiseHierarchyPropertyModel model = (MerchandiseHierarchyPropertyModel)child;
/* 627 */       model.setHierarchyId_noev(getHierarchyId());
/* 628 */       model.setOrganizationId_noev(getOrganizationId());
/* 629 */       if (child instanceof IDataModelImpl) {
/* 630 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 631 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 632 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 633 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 636 */       if (postEventsForChanges()) {
/* 637 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addMerchandiseHierarchyProperty(IMerchandiseHierarchyProperty argMerchandiseHierarchyProperty) {
/* 643 */     if (this._properties == null) {
/* 644 */       this._properties = new HistoricalList(null);
/*     */     }
/* 646 */     argMerchandiseHierarchyProperty.setHierarchyId(getHierarchyId());
/* 647 */     argMerchandiseHierarchyProperty.setOrganizationId(getOrganizationId());
/* 648 */     if (argMerchandiseHierarchyProperty instanceof IDataModelImpl) {
/* 649 */       IDataAccessObject childDao = ((IDataModelImpl)argMerchandiseHierarchyProperty).getDAO();
/* 650 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 651 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 652 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 657 */     if (postEventsForChanges()) {
/* 658 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMerchandiseHierarchyProperty));
/*     */     }
/*     */     
/* 661 */     this._properties.add(argMerchandiseHierarchyProperty);
/* 662 */     if (postEventsForChanges()) {
/* 663 */       this._events.post(IMerchandiseHierarchy.ADD_PROPERTIES, argMerchandiseHierarchyProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeMerchandiseHierarchyProperty(IMerchandiseHierarchyProperty argMerchandiseHierarchyProperty) {
/* 668 */     if (this._properties != null) {
/*     */       
/* 670 */       if (postEventsForChanges()) {
/* 671 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argMerchandiseHierarchyProperty));
/*     */       }
/* 673 */       this._properties.remove(argMerchandiseHierarchyProperty);
/* 674 */       if (postEventsForChanges()) {
/* 675 */         this._events.post(IMerchandiseHierarchy.REMOVE_PROPERTIES, argMerchandiseHierarchyProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 682 */     if ("Properties".equals(argFieldId)) {
/* 683 */       return getProperties();
/*     */     }
/* 685 */     if ("MerchandiseHierarchyExtension".equals(argFieldId)) {
/* 686 */       return this._myExtension;
/*     */     }
/*     */     
/* 689 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 695 */     if ("Properties".equals(argFieldId)) {
/* 696 */       setProperties(changeToList(argValue, IMerchandiseHierarchyProperty.class));
/*     */     }
/* 698 */     else if ("MerchandiseHierarchyExtension".equals(argFieldId)) {
/* 699 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 702 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 708 */     this._persistenceDefaults = argPD;
/* 709 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 710 */     this._eventManager = argEM;
/* 711 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 712 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 713 */     if (this._properties != null) {
/* 714 */       for (IMerchandiseHierarchyProperty relationship : this._properties) {
/* 715 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getMerchandiseHierarchyExt() {
/* 721 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setMerchandiseHierarchyExt(IDataModel argExt) {
/* 725 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 730 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 734 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 737 */     super.startTransaction();
/*     */     
/* 739 */     this._propertiesSavepoint = this._properties;
/* 740 */     if (this._properties != null) {
/* 741 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 742 */       Iterator<IDataModel> it = this._properties.iterator();
/* 743 */       while (it.hasNext()) {
/* 744 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 749 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 754 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 757 */     super.rollbackChanges();
/*     */     
/* 759 */     this._properties = this._propertiesSavepoint;
/* 760 */     this._propertiesSavepoint = null;
/* 761 */     if (this._properties != null) {
/* 762 */       Iterator<IDataModel> it = this._properties.iterator();
/* 763 */       while (it.hasNext()) {
/* 764 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 772 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 775 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 778 */     super.commitTransaction();
/*     */     
/* 780 */     this._propertiesSavepoint = this._properties;
/* 781 */     if (this._properties != null) {
/* 782 */       Iterator<IDataModel> it = this._properties.iterator();
/* 783 */       while (it.hasNext()) {
/* 784 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 786 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 790 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MerchandiseHierarchyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */