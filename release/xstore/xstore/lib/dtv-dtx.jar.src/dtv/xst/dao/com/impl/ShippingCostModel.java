/*     */ package dtv.xst.dao.com.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.com.IShippingCost;
/*     */ import dtv.xst.dao.com.IShippingCostProperty;
/*     */ import dtv.xst.dao.com.ShippingCostPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShippingCostModel extends AbstractDataModelWithPropertyImpl<IShippingCostProperty> implements IShippingCost {
/*     */   private static final long serialVersionUID = -234631493L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IShippingCostProperty> _properties; private transient HistoricalList<IShippingCostProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ShippingCostDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShippingCostDAO getDAO_() {
/*  46 */     return (ShippingCostDAO)this._daoImpl;
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
/*  70 */       this._events.post(IShippingCost.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ShippingCostPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ShippingCostPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCategory() {
/* 101 */     return getDAO_().getCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategory(String argCategory) {
/* 109 */     if (setCategory_noev(argCategory) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IShippingCost.SET_CATEGORY, argCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCategory_noev(String argCategory) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCategory() == null && argCategory != null) || (
/* 122 */       getDAO_().getCategory() != null && !getDAO_().getCategory().equals(argCategory))) {
/* 123 */       getDAO_().setCategory(argCategory);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ShippingCostPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ShippingCostPropertyModel)it.next()).setCategory_noev(argCategory);
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
/*     */   public BigDecimal getBeginRange() {
/* 143 */     return getDAO_().getBeginRange();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBeginRange(BigDecimal argBeginRange) {
/* 151 */     if (setBeginRange_noev(argBeginRange) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IShippingCost.SET_BEGINRANGE, argBeginRange);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBeginRange_noev(BigDecimal argBeginRange) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getBeginRange() == null && argBeginRange != null) || (
/* 164 */       getDAO_().getBeginRange() != null && !getDAO_().getBeginRange().equals(argBeginRange))) {
/* 165 */       getDAO_().setBeginRange(argBeginRange);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<ShippingCostPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((ShippingCostPropertyModel)it.next()).setBeginRange_noev(argBeginRange);
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
/*     */   public BigDecimal getEndRange() {
/* 185 */     return getDAO_().getEndRange();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEndRange(BigDecimal argEndRange) {
/* 193 */     if (setEndRange_noev(argEndRange) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IShippingCost.SET_ENDRANGE, argEndRange);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEndRange_noev(BigDecimal argEndRange) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getEndRange() == null && argEndRange != null) || (
/* 206 */       getDAO_().getEndRange() != null && !getDAO_().getEndRange().equals(argEndRange))) {
/* 207 */       getDAO_().setEndRange(argEndRange);
/* 208 */       ev_postable = true;
/* 209 */       if (this._properties != null) {
/*     */         
/* 211 */         Iterator<ShippingCostPropertyModel> it = this._properties.iterator();
/* 212 */         while (it.hasNext())
/*     */         {
/* 214 */           ((ShippingCostPropertyModel)it.next()).setEndRange_noev(argEndRange);
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
/*     */   public BigDecimal getCost() {
/* 227 */     return getDAO_().getCost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/* 235 */     if (setCost_noev(argCost) && 
/* 236 */       this._events != null && 
/* 237 */       postEventsForChanges()) {
/* 238 */       this._events.post(IShippingCost.SET_COST, argCost);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCost_noev(BigDecimal argCost) {
/* 245 */     boolean ev_postable = false;
/*     */     
/* 247 */     if ((getDAO_().getCost() == null && argCost != null) || (
/* 248 */       getDAO_().getCost() != null && !getDAO_().getCost().equals(argCost))) {
/* 249 */       getDAO_().setCost(argCost);
/* 250 */       ev_postable = true;
/* 251 */       if (this._properties != null) {
/*     */         
/* 253 */         Iterator<ShippingCostPropertyModel> it = this._properties.iterator();
/* 254 */         while (it.hasNext())
/*     */         {
/* 256 */           ((ShippingCostPropertyModel)it.next()).setCost_noev(argCost);
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
/* 280 */       this._events.post(IShippingCost.SET_CREATEDATE, argCreateDate);
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
/* 314 */       this._events.post(IShippingCost.SET_CREATEUSERID, argCreateUserId);
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
/* 348 */       this._events.post(IShippingCost.SET_UPDATEDATE, argUpdateDate);
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
/* 382 */       this._events.post(IShippingCost.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getOrgCode() {
/* 405 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 413 */     if (setOrgCode_noev(argOrgCode) && 
/* 414 */       this._events != null && 
/* 415 */       postEventsForChanges()) {
/* 416 */       this._events.post(IShippingCost.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 423 */     boolean ev_postable = false;
/*     */     
/* 425 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 426 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 427 */       getDAO_().setOrgCode(argOrgCode);
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
/*     */   public String getOrgValue() {
/* 439 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 447 */     if (setOrgValue_noev(argOrgValue) && 
/* 448 */       this._events != null && 
/* 449 */       postEventsForChanges()) {
/* 450 */       this._events.post(IShippingCost.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 457 */     boolean ev_postable = false;
/*     */     
/* 459 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 460 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 461 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public BigDecimal getMinimumCost() {
/* 473 */     return getDAO_().getMinimumCost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumCost(BigDecimal argMinimumCost) {
/* 481 */     if (setMinimumCost_noev(argMinimumCost) && 
/* 482 */       this._events != null && 
/* 483 */       postEventsForChanges()) {
/* 484 */       this._events.post(IShippingCost.SET_MINIMUMCOST, argMinimumCost);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinimumCost_noev(BigDecimal argMinimumCost) {
/* 491 */     boolean ev_postable = false;
/*     */     
/* 493 */     if ((getDAO_().getMinimumCost() == null && argMinimumCost != null) || (
/* 494 */       getDAO_().getMinimumCost() != null && !getDAO_().getMinimumCost().equals(argMinimumCost))) {
/* 495 */       getDAO_().setMinimumCost(argMinimumCost);
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
/*     */   public BigDecimal getMaximumCost() {
/* 507 */     return getDAO_().getMaximumCost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumCost(BigDecimal argMaximumCost) {
/* 515 */     if (setMaximumCost_noev(argMaximumCost) && 
/* 516 */       this._events != null && 
/* 517 */       postEventsForChanges()) {
/* 518 */       this._events.post(IShippingCost.SET_MAXIMUMCOST, argMaximumCost);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaximumCost_noev(BigDecimal argMaximumCost) {
/* 525 */     boolean ev_postable = false;
/*     */     
/* 527 */     if ((getDAO_().getMaximumCost() == null && argMaximumCost != null) || (
/* 528 */       getDAO_().getMaximumCost() != null && !getDAO_().getMaximumCost().equals(argMaximumCost))) {
/* 529 */       getDAO_().setMaximumCost(argMaximumCost);
/* 530 */       ev_postable = true;
/*     */     } 
/*     */     
/* 533 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 541 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 549 */     if (setItemId_noev(argItemId) && 
/* 550 */       this._events != null && 
/* 551 */       postEventsForChanges()) {
/* 552 */       this._events.post(IShippingCost.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 559 */     boolean ev_postable = false;
/*     */     
/* 561 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 562 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 563 */       getDAO_().setItemId(argItemId);
/* 564 */       ev_postable = true;
/*     */     } 
/*     */     
/* 567 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShippingCostProperty newProperty(String argPropertyName) {
/* 571 */     ShippingCostPropertyId id = new ShippingCostPropertyId();
/*     */     
/* 573 */     id.setCategory(getCategory());
/* 574 */     id.setBeginRange(getBeginRange());
/* 575 */     id.setEndRange(getEndRange());
/* 576 */     id.setCost(getCost());
/* 577 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 579 */     IShippingCostProperty prop = (IShippingCostProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShippingCostProperty.class);
/* 580 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShippingCostProperty> getProperties() {
/* 589 */     if (this._properties == null) {
/* 590 */       this._properties = new HistoricalList(null);
/*     */     }
/* 592 */     return (List<IShippingCostProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShippingCostProperty> argProperties) {
/* 596 */     if (this._properties == null) {
/* 597 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 599 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 602 */     for (IShippingCostProperty child : this._properties) {
/* 603 */       ShippingCostPropertyModel model = (ShippingCostPropertyModel)child;
/* 604 */       model.setOrganizationId_noev(getOrganizationId());
/* 605 */       model.setCategory_noev(getCategory());
/* 606 */       model.setBeginRange_noev(getBeginRange());
/* 607 */       model.setEndRange_noev(getEndRange());
/* 608 */       model.setCost_noev(getCost());
/* 609 */       if (child instanceof IDataModelImpl) {
/* 610 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 611 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 612 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 613 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 616 */       if (postEventsForChanges()) {
/* 617 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShippingCostProperty(IShippingCostProperty argShippingCostProperty) {
/* 623 */     if (this._properties == null) {
/* 624 */       this._properties = new HistoricalList(null);
/*     */     }
/* 626 */     argShippingCostProperty.setOrganizationId(getOrganizationId());
/* 627 */     argShippingCostProperty.setCategory(getCategory());
/* 628 */     argShippingCostProperty.setBeginRange(getBeginRange());
/* 629 */     argShippingCostProperty.setEndRange(getEndRange());
/* 630 */     argShippingCostProperty.setCost(getCost());
/* 631 */     if (argShippingCostProperty instanceof IDataModelImpl) {
/* 632 */       IDataAccessObject childDao = ((IDataModelImpl)argShippingCostProperty).getDAO();
/* 633 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 634 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 635 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 640 */     if (postEventsForChanges()) {
/* 641 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingCostProperty));
/*     */     }
/*     */     
/* 644 */     this._properties.add(argShippingCostProperty);
/* 645 */     if (postEventsForChanges()) {
/* 646 */       this._events.post(IShippingCost.ADD_PROPERTIES, argShippingCostProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShippingCostProperty(IShippingCostProperty argShippingCostProperty) {
/* 651 */     if (this._properties != null) {
/*     */       
/* 653 */       if (postEventsForChanges()) {
/* 654 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShippingCostProperty));
/*     */       }
/* 656 */       this._properties.remove(argShippingCostProperty);
/* 657 */       if (postEventsForChanges()) {
/* 658 */         this._events.post(IShippingCost.REMOVE_PROPERTIES, argShippingCostProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 665 */     if ("Properties".equals(argFieldId)) {
/* 666 */       return getProperties();
/*     */     }
/* 668 */     if ("ShippingCostExtension".equals(argFieldId)) {
/* 669 */       return this._myExtension;
/*     */     }
/*     */     
/* 672 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 678 */     if ("Properties".equals(argFieldId)) {
/* 679 */       setProperties(changeToList(argValue, IShippingCostProperty.class));
/*     */     }
/* 681 */     else if ("ShippingCostExtension".equals(argFieldId)) {
/* 682 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 685 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 691 */     this._persistenceDefaults = argPD;
/* 692 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 693 */     this._eventManager = argEM;
/* 694 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 695 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 696 */     if (this._properties != null) {
/* 697 */       for (IShippingCostProperty relationship : this._properties) {
/* 698 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShippingCostExt() {
/* 704 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShippingCostExt(IDataModel argExt) {
/* 708 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 713 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 717 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 720 */     super.startTransaction();
/*     */     
/* 722 */     this._propertiesSavepoint = this._properties;
/* 723 */     if (this._properties != null) {
/* 724 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 725 */       Iterator<IDataModel> it = this._properties.iterator();
/* 726 */       while (it.hasNext()) {
/* 727 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 732 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 737 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 740 */     super.rollbackChanges();
/*     */     
/* 742 */     this._properties = this._propertiesSavepoint;
/* 743 */     this._propertiesSavepoint = null;
/* 744 */     if (this._properties != null) {
/* 745 */       Iterator<IDataModel> it = this._properties.iterator();
/* 746 */       while (it.hasNext()) {
/* 747 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 755 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 758 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 761 */     super.commitTransaction();
/*     */     
/* 763 */     this._propertiesSavepoint = this._properties;
/* 764 */     if (this._properties != null) {
/* 765 */       Iterator<IDataModel> it = this._properties.iterator();
/* 766 */       while (it.hasNext()) {
/* 767 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 769 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 773 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 778 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingCostModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */