/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.IShipperMethod;
/*     */ import dtv.xst.dao.inv.IShipperMethodProperty;
/*     */ import dtv.xst.dao.inv.ShipperMethodPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ShipperMethodModel extends AbstractDataModelWithPropertyImpl<IShipperMethodProperty> implements IShipperMethod {
/*     */   private static final long serialVersionUID = 1477279106L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IShipperMethodProperty> _properties; private transient HistoricalList<IShipperMethodProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ShipperMethodDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ShipperMethodDAO getDAO_() {
/*  46 */     return (ShipperMethodDAO)this._daoImpl;
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
/*  70 */       this._events.post(IShipperMethod.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ShipperMethodPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ShipperMethodPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getShipperMethodId() {
/* 101 */     return getDAO_().getShipperMethodId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipperMethodId(String argShipperMethodId) {
/* 109 */     if (setShipperMethodId_noev(argShipperMethodId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IShipperMethod.SET_SHIPPERMETHODID, argShipperMethodId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipperMethodId_noev(String argShipperMethodId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getShipperMethodId() == null && argShipperMethodId != null) || (
/* 122 */       getDAO_().getShipperMethodId() != null && !getDAO_().getShipperMethodId().equals(argShipperMethodId))) {
/* 123 */       getDAO_().setShipperMethodId(argShipperMethodId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<ShipperMethodPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((ShipperMethodPropertyModel)it.next()).setShipperMethodId_noev(argShipperMethodId);
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
/* 154 */       this._events.post(IShipperMethod.SET_ORGCODE, argOrgCode);
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
/* 188 */       this._events.post(IShipperMethod.SET_ORGVALUE, argOrgValue);
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
/*     */   public Date getCreateDate() {
/* 211 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 219 */     if (setCreateDate_noev(argCreateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(IShipperMethod.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 232 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 233 */       getDAO_().setCreateDate(argCreateDate);
/* 234 */       ev_postable = true;
/*     */     } 
/*     */     
/* 237 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 245 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 253 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(IShipperMethod.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 266 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 267 */       getDAO_().setCreateUserId(argCreateUserId);
/* 268 */       ev_postable = true;
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 279 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 287 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(IShipperMethod.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 300 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 301 */       getDAO_().setUpdateDate(argUpdateDate);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 313 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 321 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(IShipperMethod.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 334 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 335 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShipperMethodDesc() {
/* 347 */     return getDAO_().getShipperMethodDesc();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipperMethodDesc(String argShipperMethodDesc) {
/* 355 */     if (setShipperMethodDesc_noev(argShipperMethodDesc) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IShipperMethod.SET_SHIPPERMETHODDESC, argShipperMethodDesc);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipperMethodDesc_noev(String argShipperMethodDesc) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getShipperMethodDesc() == null && argShipperMethodDesc != null) || (
/* 368 */       getDAO_().getShipperMethodDesc() != null && !getDAO_().getShipperMethodDesc().equals(argShipperMethodDesc))) {
/* 369 */       getDAO_().setShipperMethodDesc(argShipperMethodDesc);
/* 370 */       ev_postable = true;
/*     */     } 
/*     */     
/* 373 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShipperId() {
/* 381 */     return getDAO_().getShipperId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShipperId(String argShipperId) {
/* 389 */     if (setShipperId_noev(argShipperId) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(IShipperMethod.SET_SHIPPERID, argShipperId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setShipperId_noev(String argShipperId) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getShipperId() == null && argShipperId != null) || (
/* 402 */       getDAO_().getShipperId() != null && !getDAO_().getShipperId().equals(argShipperId))) {
/* 403 */       getDAO_().setShipperId(argShipperId);
/* 404 */       ev_postable = true;
/*     */     } 
/*     */     
/* 407 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDomesticServiceCode() {
/* 415 */     return getDAO_().getDomesticServiceCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDomesticServiceCode(String argDomesticServiceCode) {
/* 423 */     if (setDomesticServiceCode_noev(argDomesticServiceCode) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(IShipperMethod.SET_DOMESTICSERVICECODE, argDomesticServiceCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDomesticServiceCode_noev(String argDomesticServiceCode) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getDomesticServiceCode() == null && argDomesticServiceCode != null) || (
/* 436 */       getDAO_().getDomesticServiceCode() != null && !getDAO_().getDomesticServiceCode().equals(argDomesticServiceCode))) {
/* 437 */       getDAO_().setDomesticServiceCode(argDomesticServiceCode);
/* 438 */       ev_postable = true;
/*     */     } 
/*     */     
/* 441 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIntlServiceCode() {
/* 449 */     return getDAO_().getIntlServiceCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntlServiceCode(String argIntlServiceCode) {
/* 457 */     if (setIntlServiceCode_noev(argIntlServiceCode) && 
/* 458 */       this._events != null && 
/* 459 */       postEventsForChanges()) {
/* 460 */       this._events.post(IShipperMethod.SET_INTLSERVICECODE, argIntlServiceCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIntlServiceCode_noev(String argIntlServiceCode) {
/* 467 */     boolean ev_postable = false;
/*     */     
/* 469 */     if ((getDAO_().getIntlServiceCode() == null && argIntlServiceCode != null) || (
/* 470 */       getDAO_().getIntlServiceCode() != null && !getDAO_().getIntlServiceCode().equals(argIntlServiceCode))) {
/* 471 */       getDAO_().setIntlServiceCode(argIntlServiceCode);
/* 472 */       ev_postable = true;
/*     */     } 
/*     */     
/* 475 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayOrder() {
/* 483 */     if (getDAO_().getDisplayOrder() != null) {
/* 484 */       return getDAO_().getDisplayOrder().intValue();
/*     */     }
/*     */     
/* 487 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayOrder(int argDisplayOrder) {
/* 496 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(IShipperMethod.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/* 509 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/* 510 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
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
/*     */   public int getPriority() {
/* 522 */     if (getDAO_().getPriority() != null) {
/* 523 */       return getDAO_().getPriority().intValue();
/*     */     }
/*     */     
/* 526 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriority(int argPriority) {
/* 535 */     if (setPriority_noev(argPriority) && 
/* 536 */       this._events != null && 
/* 537 */       postEventsForChanges()) {
/* 538 */       this._events.post(IShipperMethod.SET_PRIORITY, Integer.valueOf(argPriority));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriority_noev(int argPriority) {
/* 545 */     boolean ev_postable = false;
/*     */     
/* 547 */     if ((getDAO_().getPriority() == null && Integer.valueOf(argPriority) != null) || (
/* 548 */       getDAO_().getPriority() != null && !getDAO_().getPriority().equals(Integer.valueOf(argPriority)))) {
/* 549 */       getDAO_().setPriority(Integer.valueOf(argPriority));
/* 550 */       ev_postable = true;
/*     */     } 
/*     */     
/* 553 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IShipperMethodProperty newProperty(String argPropertyName) {
/* 557 */     ShipperMethodPropertyId id = new ShipperMethodPropertyId();
/*     */     
/* 559 */     id.setShipperMethodId(getShipperMethodId());
/* 560 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 562 */     IShipperMethodProperty prop = (IShipperMethodProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IShipperMethodProperty.class);
/* 563 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IShipperMethodProperty> getProperties() {
/* 572 */     if (this._properties == null) {
/* 573 */       this._properties = new HistoricalList(null);
/*     */     }
/* 575 */     return (List<IShipperMethodProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IShipperMethodProperty> argProperties) {
/* 579 */     if (this._properties == null) {
/* 580 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 582 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 585 */     for (IShipperMethodProperty child : this._properties) {
/* 586 */       ShipperMethodPropertyModel model = (ShipperMethodPropertyModel)child;
/* 587 */       model.setOrganizationId_noev(getOrganizationId());
/* 588 */       model.setShipperMethodId_noev(getShipperMethodId());
/* 589 */       if (child instanceof IDataModelImpl) {
/* 590 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 591 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 592 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 593 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 596 */       if (postEventsForChanges()) {
/* 597 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addShipperMethodProperty(IShipperMethodProperty argShipperMethodProperty) {
/* 603 */     if (this._properties == null) {
/* 604 */       this._properties = new HistoricalList(null);
/*     */     }
/* 606 */     argShipperMethodProperty.setOrganizationId(getOrganizationId());
/* 607 */     argShipperMethodProperty.setShipperMethodId(getShipperMethodId());
/* 608 */     if (argShipperMethodProperty instanceof IDataModelImpl) {
/* 609 */       IDataAccessObject childDao = ((IDataModelImpl)argShipperMethodProperty).getDAO();
/* 610 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 611 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 612 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 617 */     if (postEventsForChanges()) {
/* 618 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipperMethodProperty));
/*     */     }
/*     */     
/* 621 */     this._properties.add(argShipperMethodProperty);
/* 622 */     if (postEventsForChanges()) {
/* 623 */       this._events.post(IShipperMethod.ADD_PROPERTIES, argShipperMethodProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeShipperMethodProperty(IShipperMethodProperty argShipperMethodProperty) {
/* 628 */     if (this._properties != null) {
/*     */       
/* 630 */       if (postEventsForChanges()) {
/* 631 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argShipperMethodProperty));
/*     */       }
/* 633 */       this._properties.remove(argShipperMethodProperty);
/* 634 */       if (postEventsForChanges()) {
/* 635 */         this._events.post(IShipperMethod.REMOVE_PROPERTIES, argShipperMethodProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 642 */     if ("Properties".equals(argFieldId)) {
/* 643 */       return getProperties();
/*     */     }
/* 645 */     if ("ShipperMethodExtension".equals(argFieldId)) {
/* 646 */       return this._myExtension;
/*     */     }
/*     */     
/* 649 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 655 */     if ("Properties".equals(argFieldId)) {
/* 656 */       setProperties(changeToList(argValue, IShipperMethodProperty.class));
/*     */     }
/* 658 */     else if ("ShipperMethodExtension".equals(argFieldId)) {
/* 659 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 662 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 668 */     this._persistenceDefaults = argPD;
/* 669 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 670 */     this._eventManager = argEM;
/* 671 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 672 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 673 */     if (this._properties != null) {
/* 674 */       for (IShipperMethodProperty relationship : this._properties) {
/* 675 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getShipperMethodExt() {
/* 681 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setShipperMethodExt(IDataModel argExt) {
/* 685 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 690 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 694 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 697 */     super.startTransaction();
/*     */     
/* 699 */     this._propertiesSavepoint = this._properties;
/* 700 */     if (this._properties != null) {
/* 701 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 702 */       Iterator<IDataModel> it = this._properties.iterator();
/* 703 */       while (it.hasNext()) {
/* 704 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 709 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 714 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 717 */     super.rollbackChanges();
/*     */     
/* 719 */     this._properties = this._propertiesSavepoint;
/* 720 */     this._propertiesSavepoint = null;
/* 721 */     if (this._properties != null) {
/* 722 */       Iterator<IDataModel> it = this._properties.iterator();
/* 723 */       while (it.hasNext()) {
/* 724 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 732 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 735 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 738 */     super.commitTransaction();
/*     */     
/* 740 */     this._propertiesSavepoint = this._properties;
/* 741 */     if (this._properties != null) {
/* 742 */       Iterator<IDataModel> it = this._properties.iterator();
/* 743 */       while (it.hasNext()) {
/* 744 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 746 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 750 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 755 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipperMethodModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */