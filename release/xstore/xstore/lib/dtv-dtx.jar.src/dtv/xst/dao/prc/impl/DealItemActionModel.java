/*     */ package dtv.xst.dao.prc.impl;
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
/*     */ import dtv.xst.dao.prc.DealItemActionPropertyId;
/*     */ import dtv.xst.dao.prc.IDealItemAction;
/*     */ import dtv.xst.dao.prc.IDealItemActionProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DealItemActionModel extends AbstractDataModelWithPropertyImpl<IDealItemActionProperty> implements IDealItemAction {
/*     */   private static final long serialVersionUID = -1580459819L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IDealItemActionProperty> _properties; private transient HistoricalList<IDealItemActionProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new DealItemActionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DealItemActionDAO getDAO_() {
/*  46 */     return (DealItemActionDAO)this._daoImpl;
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
/*  70 */       this._events.post(IDealItemAction.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<DealItemActionPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((DealItemActionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getDealId() {
/* 101 */     return getDAO_().getDealId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 109 */     if (setDealId_noev(argDealId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IDealItemAction.SET_DEALID, argDealId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDealId_noev(String argDealId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/* 122 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/* 123 */       getDAO_().setDealId(argDealId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<DealItemActionPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((DealItemActionPropertyModel)it.next()).setDealId_noev(argDealId);
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
/*     */   public int getOrdinal() {
/* 143 */     if (getDAO_().getOrdinal() != null) {
/* 144 */       return getDAO_().getOrdinal().intValue();
/*     */     }
/*     */     
/* 147 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrdinal(int argOrdinal) {
/* 156 */     if (setOrdinal_noev(argOrdinal) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IDealItemAction.SET_ORDINAL, Integer.valueOf(argOrdinal));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrdinal_noev(int argOrdinal) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getOrdinal() == null && Integer.valueOf(argOrdinal) != null) || (
/* 169 */       getDAO_().getOrdinal() != null && !getDAO_().getOrdinal().equals(Integer.valueOf(argOrdinal)))) {
/* 170 */       getDAO_().setOrdinal(Integer.valueOf(argOrdinal));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<DealItemActionPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((DealItemActionPropertyModel)it.next()).setOrdinal_noev(argOrdinal);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 190 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 198 */     if (setOrgCode_noev(argOrgCode) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IDealItemAction.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 211 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 212 */       getDAO_().setOrgCode(argOrgCode);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 224 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 232 */     if (setOrgValue_noev(argOrgValue) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IDealItemAction.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 245 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 246 */       getDAO_().setOrgValue(argOrgValue);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 258 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 266 */     if (setCreateDate_noev(argCreateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IDealItemAction.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 279 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 280 */       getDAO_().setCreateDate(argCreateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 292 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 300 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IDealItemAction.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 313 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 314 */       getDAO_().setCreateUserId(argCreateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 326 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 334 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IDealItemAction.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 347 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 348 */       getDAO_().setUpdateDate(argUpdateDate);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 360 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 368 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IDealItemAction.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 381 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 382 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getConsumable() {
/* 394 */     if (getDAO_().getConsumable() != null) {
/* 395 */       return getDAO_().getConsumable().booleanValue();
/*     */     }
/*     */     
/* 398 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConsumable(boolean argConsumable) {
/* 407 */     if (setConsumable_noev(argConsumable) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(IDealItemAction.SET_CONSUMABLE, Boolean.valueOf(argConsumable));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConsumable_noev(boolean argConsumable) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getConsumable() == null && Boolean.valueOf(argConsumable) != null) || (
/* 420 */       getDAO_().getConsumable() != null && !getDAO_().getConsumable().equals(Boolean.valueOf(argConsumable)))) {
/* 421 */       getDAO_().setConsumable(Boolean.valueOf(argConsumable));
/* 422 */       ev_postable = true;
/*     */     } 
/*     */     
/* 425 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMinQty() {
/* 433 */     return getDAO_().getMinQty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinQty(BigDecimal argMinQty) {
/* 441 */     if (setMinQty_noev(argMinQty) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(IDealItemAction.SET_MINQTY, argMinQty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinQty_noev(BigDecimal argMinQty) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getMinQty() == null && argMinQty != null) || (
/* 454 */       getDAO_().getMinQty() != null && !getDAO_().getMinQty().equals(argMinQty))) {
/* 455 */       getDAO_().setMinQty(argMinQty);
/* 456 */       ev_postable = true;
/*     */     } 
/*     */     
/* 459 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMaxQty() {
/* 467 */     return getDAO_().getMaxQty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxQty(BigDecimal argMaxQty) {
/* 475 */     if (setMaxQty_noev(argMaxQty) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IDealItemAction.SET_MAXQTY, argMaxQty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxQty_noev(BigDecimal argMaxQty) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getMaxQty() == null && argMaxQty != null) || (
/* 488 */       getDAO_().getMaxQty() != null && !getDAO_().getMaxQty().equals(argMaxQty))) {
/* 489 */       getDAO_().setMaxQty(argMaxQty);
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getMinItemTotal() {
/* 501 */     return getDAO_().getMinItemTotal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinItemTotal(BigDecimal argMinItemTotal) {
/* 509 */     if (setMinItemTotal_noev(argMinItemTotal) && 
/* 510 */       this._events != null && 
/* 511 */       postEventsForChanges()) {
/* 512 */       this._events.post(IDealItemAction.SET_MINITEMTOTAL, argMinItemTotal);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMinItemTotal_noev(BigDecimal argMinItemTotal) {
/* 519 */     boolean ev_postable = false;
/*     */     
/* 521 */     if ((getDAO_().getMinItemTotal() == null && argMinItemTotal != null) || (
/* 522 */       getDAO_().getMinItemTotal() != null && !getDAO_().getMinItemTotal().equals(argMinItemTotal))) {
/* 523 */       getDAO_().setMinItemTotal(argMinItemTotal);
/* 524 */       ev_postable = true;
/*     */     } 
/*     */     
/* 527 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionType() {
/* 535 */     return getDAO_().getActionType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionType(String argActionType) {
/* 543 */     if (setActionType_noev(argActionType) && 
/* 544 */       this._events != null && 
/* 545 */       postEventsForChanges()) {
/* 546 */       this._events.post(IDealItemAction.SET_ACTIONTYPE, argActionType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActionType_noev(String argActionType) {
/* 553 */     boolean ev_postable = false;
/*     */     
/* 555 */     if ((getDAO_().getActionType() == null && argActionType != null) || (
/* 556 */       getDAO_().getActionType() != null && !getDAO_().getActionType().equals(argActionType))) {
/* 557 */       getDAO_().setActionType(argActionType);
/* 558 */       ev_postable = true;
/*     */     } 
/*     */     
/* 561 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getActionArg() {
/* 569 */     return getDAO_().getActionArg();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionArg(BigDecimal argActionArg) {
/* 577 */     if (setActionArg_noev(argActionArg) && 
/* 578 */       this._events != null && 
/* 579 */       postEventsForChanges()) {
/* 580 */       this._events.post(IDealItemAction.SET_ACTIONARG, argActionArg);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActionArg_noev(BigDecimal argActionArg) {
/* 587 */     boolean ev_postable = false;
/*     */     
/* 589 */     if ((getDAO_().getActionArg() == null && argActionArg != null) || (
/* 590 */       getDAO_().getActionArg() != null && !getDAO_().getActionArg().equals(argActionArg))) {
/* 591 */       getDAO_().setActionArg(argActionArg);
/* 592 */       ev_postable = true;
/*     */     } 
/*     */     
/* 595 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getActionArgQty() {
/* 603 */     return getDAO_().getActionArgQty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionArgQty(BigDecimal argActionArgQty) {
/* 611 */     if (setActionArgQty_noev(argActionArgQty) && 
/* 612 */       this._events != null && 
/* 613 */       postEventsForChanges()) {
/* 614 */       this._events.post(IDealItemAction.SET_ACTIONARGQTY, argActionArgQty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActionArgQty_noev(BigDecimal argActionArgQty) {
/* 621 */     boolean ev_postable = false;
/*     */     
/* 623 */     if ((getDAO_().getActionArgQty() == null && argActionArgQty != null) || (
/* 624 */       getDAO_().getActionArgQty() != null && !getDAO_().getActionArgQty().equals(argActionArgQty))) {
/* 625 */       getDAO_().setActionArgQty(argActionArgQty);
/* 626 */       ev_postable = true;
/*     */     } 
/*     */     
/* 629 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDealItemActionProperty newProperty(String argPropertyName) {
/* 633 */     DealItemActionPropertyId id = new DealItemActionPropertyId();
/*     */     
/* 635 */     id.setDealId(getDealId());
/* 636 */     id.setOrdinal(Integer.valueOf(getOrdinal()));
/* 637 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 639 */     IDealItemActionProperty prop = (IDealItemActionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDealItemActionProperty.class);
/* 640 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDealItemActionProperty> getProperties() {
/* 649 */     if (this._properties == null) {
/* 650 */       this._properties = new HistoricalList(null);
/*     */     }
/* 652 */     return (List<IDealItemActionProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDealItemActionProperty> argProperties) {
/* 656 */     if (this._properties == null) {
/* 657 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 659 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 662 */     for (IDealItemActionProperty child : this._properties) {
/* 663 */       DealItemActionPropertyModel model = (DealItemActionPropertyModel)child;
/* 664 */       model.setOrganizationId_noev(getOrganizationId());
/* 665 */       model.setDealId_noev(getDealId());
/* 666 */       model.setOrdinal_noev(getOrdinal());
/* 667 */       if (child instanceof IDataModelImpl) {
/* 668 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 669 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 670 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 671 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 674 */       if (postEventsForChanges()) {
/* 675 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDealItemActionProperty(IDealItemActionProperty argDealItemActionProperty) {
/* 681 */     if (this._properties == null) {
/* 682 */       this._properties = new HistoricalList(null);
/*     */     }
/* 684 */     argDealItemActionProperty.setOrganizationId(getOrganizationId());
/* 685 */     argDealItemActionProperty.setDealId(getDealId());
/* 686 */     argDealItemActionProperty.setOrdinal(getOrdinal());
/* 687 */     if (argDealItemActionProperty instanceof IDataModelImpl) {
/* 688 */       IDataAccessObject childDao = ((IDataModelImpl)argDealItemActionProperty).getDAO();
/* 689 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 690 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 691 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 696 */     if (postEventsForChanges()) {
/* 697 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealItemActionProperty));
/*     */     }
/*     */     
/* 700 */     this._properties.add(argDealItemActionProperty);
/* 701 */     if (postEventsForChanges()) {
/* 702 */       this._events.post(IDealItemAction.ADD_PROPERTIES, argDealItemActionProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDealItemActionProperty(IDealItemActionProperty argDealItemActionProperty) {
/* 707 */     if (this._properties != null) {
/*     */       
/* 709 */       if (postEventsForChanges()) {
/* 710 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealItemActionProperty));
/*     */       }
/* 712 */       this._properties.remove(argDealItemActionProperty);
/* 713 */       if (postEventsForChanges()) {
/* 714 */         this._events.post(IDealItemAction.REMOVE_PROPERTIES, argDealItemActionProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 721 */     if ("Properties".equals(argFieldId)) {
/* 722 */       return getProperties();
/*     */     }
/* 724 */     if ("DealItemActionExtension".equals(argFieldId)) {
/* 725 */       return this._myExtension;
/*     */     }
/*     */     
/* 728 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 734 */     if ("Properties".equals(argFieldId)) {
/* 735 */       setProperties(changeToList(argValue, IDealItemActionProperty.class));
/*     */     }
/* 737 */     else if ("DealItemActionExtension".equals(argFieldId)) {
/* 738 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 741 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 747 */     this._persistenceDefaults = argPD;
/* 748 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 749 */     this._eventManager = argEM;
/* 750 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 751 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 752 */     if (this._properties != null) {
/* 753 */       for (IDealItemActionProperty relationship : this._properties) {
/* 754 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDealItemActionExt() {
/* 760 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDealItemActionExt(IDataModel argExt) {
/* 764 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 769 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 773 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 776 */     super.startTransaction();
/*     */     
/* 778 */     this._propertiesSavepoint = this._properties;
/* 779 */     if (this._properties != null) {
/* 780 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 781 */       Iterator<IDataModel> it = this._properties.iterator();
/* 782 */       while (it.hasNext()) {
/* 783 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 788 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 793 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 796 */     super.rollbackChanges();
/*     */     
/* 798 */     this._properties = this._propertiesSavepoint;
/* 799 */     this._propertiesSavepoint = null;
/* 800 */     if (this._properties != null) {
/* 801 */       Iterator<IDataModel> it = this._properties.iterator();
/* 802 */       while (it.hasNext()) {
/* 803 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 811 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 814 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 817 */     super.commitTransaction();
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
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 834 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealItemActionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */