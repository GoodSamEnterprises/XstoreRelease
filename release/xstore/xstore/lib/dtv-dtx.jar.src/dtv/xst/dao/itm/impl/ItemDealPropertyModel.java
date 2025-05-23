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
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IItemDealProperty;
/*     */ import dtv.xst.dao.itm.IItemDealPropertyProperty;
/*     */ import dtv.xst.dao.itm.ItemDealPropertyPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ItemDealPropertyModel extends AbstractDataModelWithPropertyImpl<IItemDealPropertyProperty> implements IItemDealProperty {
/*     */   private static final long serialVersionUID = 1662263604L;
/*     */   private IItem _parentItem;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IItemDealPropertyProperty> _properties; private transient HistoricalList<IItemDealPropertyProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new ItemDealPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemDealPropertyDAO getDAO_() {
/*  48 */     return (ItemDealPropertyDAO)this._daoImpl;
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
/*  72 */       this._events.post(IItemDealProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<ItemDealPropertyPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((ItemDealPropertyPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getItemId() {
/* 103 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 111 */     if (setItemId_noev(argItemId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IItemDealProperty.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 124 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 125 */       getDAO_().setItemId(argItemId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<ItemDealPropertyPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((ItemDealPropertyPropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public String getItemDealPropertyCode() {
/* 145 */     return getDAO_().getItemDealPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemDealPropertyCode(String argItemDealPropertyCode) {
/* 153 */     if (setItemDealPropertyCode_noev(argItemDealPropertyCode) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IItemDealProperty.SET_ITEMDEALPROPERTYCODE, argItemDealPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemDealPropertyCode_noev(String argItemDealPropertyCode) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getItemDealPropertyCode() == null && argItemDealPropertyCode != null) || (
/* 166 */       getDAO_().getItemDealPropertyCode() != null && !getDAO_().getItemDealPropertyCode().equals(argItemDealPropertyCode))) {
/* 167 */       getDAO_().setItemDealPropertyCode(argItemDealPropertyCode);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<ItemDealPropertyPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((ItemDealPropertyPropertyModel)it.next()).setItemDealPropertyCode_noev(argItemDealPropertyCode);
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
/*     */   public Date getEffectiveDate() {
/* 187 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 195 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 196 */       this._events != null && 
/* 197 */       postEventsForChanges()) {
/* 198 */       this._events.post(IItemDealProperty.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 205 */     boolean ev_postable = false;
/*     */     
/* 207 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 208 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 209 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 210 */       ev_postable = true;
/* 211 */       if (this._properties != null) {
/*     */         
/* 213 */         Iterator<ItemDealPropertyPropertyModel> it = this._properties.iterator();
/* 214 */         while (it.hasNext())
/*     */         {
/* 216 */           ((ItemDealPropertyPropertyModel)it.next()).setEffectiveDate_noev(argEffectiveDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 221 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 229 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 237 */     if (setCreateDate_noev(argCreateDate) && 
/* 238 */       this._events != null && 
/* 239 */       postEventsForChanges()) {
/* 240 */       this._events.post(IItemDealProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 247 */     boolean ev_postable = false;
/*     */     
/* 249 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 250 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 251 */       getDAO_().setCreateDate(argCreateDate);
/* 252 */       ev_postable = true;
/*     */     } 
/*     */     
/* 255 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 263 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 271 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 272 */       this._events != null && 
/* 273 */       postEventsForChanges()) {
/* 274 */       this._events.post(IItemDealProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 281 */     boolean ev_postable = false;
/*     */     
/* 283 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 284 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 285 */       getDAO_().setCreateUserId(argCreateUserId);
/* 286 */       ev_postable = true;
/*     */     } 
/*     */     
/* 289 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 297 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 305 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 306 */       this._events != null && 
/* 307 */       postEventsForChanges()) {
/* 308 */       this._events.post(IItemDealProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 315 */     boolean ev_postable = false;
/*     */     
/* 317 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 318 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 319 */       getDAO_().setUpdateDate(argUpdateDate);
/* 320 */       ev_postable = true;
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 331 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 339 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(IItemDealProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 352 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 353 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 354 */       ev_postable = true;
/*     */     } 
/*     */     
/* 357 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 365 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 373 */     if (setOrgCode_noev(argOrgCode) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(IItemDealProperty.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 386 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 387 */       getDAO_().setOrgCode(argOrgCode);
/* 388 */       ev_postable = true;
/*     */     } 
/*     */     
/* 391 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 399 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 407 */     if (setOrgValue_noev(argOrgValue) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(IItemDealProperty.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 420 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 421 */       getDAO_().setOrgValue(argOrgValue);
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
/*     */   public Date getExpirationDate() {
/* 433 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 441 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(IItemDealProperty.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 454 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 455 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*     */   public String getType() {
/* 467 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 475 */     if (setType_noev(argType) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IItemDealProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getType() == null && argType != null) || (
/* 488 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 489 */       getDAO_().setType(argType);
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
/*     */   public String getStringValue() {
/* 501 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 509 */     if (setStringValue_noev(argStringValue) && 
/* 510 */       this._events != null && 
/* 511 */       postEventsForChanges()) {
/* 512 */       this._events.post(IItemDealProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 519 */     boolean ev_postable = false;
/*     */     
/* 521 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 522 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 523 */       getDAO_().setStringValue(argStringValue);
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
/*     */   public Date getDateValue() {
/* 535 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 543 */     if (setDateValue_noev(argDateValue) && 
/* 544 */       this._events != null && 
/* 545 */       postEventsForChanges()) {
/* 546 */       this._events.post(IItemDealProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 553 */     boolean ev_postable = false;
/*     */     
/* 555 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 556 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 557 */       getDAO_().setDateValue(argDateValue);
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
/*     */   public BigDecimal getDecimalValue() {
/* 569 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 577 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 578 */       this._events != null && 
/* 579 */       postEventsForChanges()) {
/* 580 */       this._events.post(IItemDealProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 587 */     boolean ev_postable = false;
/*     */     
/* 589 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 590 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 591 */       getDAO_().setDecimalValue(argDecimalValue);
/* 592 */       ev_postable = true;
/*     */     } 
/*     */     
/* 595 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IItemDealPropertyProperty newProperty(String argPropertyName) {
/* 599 */     ItemDealPropertyPropertyId id = new ItemDealPropertyPropertyId();
/*     */     
/* 601 */     id.setItemId(getItemId());
/* 602 */     id.setItemDealPropertyCode(getItemDealPropertyCode());
/* 603 */     id.setEffectiveDate(getEffectiveDate());
/* 604 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 606 */     IItemDealPropertyProperty prop = (IItemDealPropertyProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemDealPropertyProperty.class);
/* 607 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IItemDealPropertyProperty> getProperties() {
/* 616 */     if (this._properties == null) {
/* 617 */       this._properties = new HistoricalList(null);
/*     */     }
/* 619 */     return (List<IItemDealPropertyProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IItemDealPropertyProperty> argProperties) {
/* 623 */     if (this._properties == null) {
/* 624 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 626 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 629 */     for (IItemDealPropertyProperty child : this._properties) {
/* 630 */       ItemDealPropertyPropertyModel model = (ItemDealPropertyPropertyModel)child;
/* 631 */       model.setOrganizationId_noev(getOrganizationId());
/* 632 */       model.setItemId_noev(getItemId());
/* 633 */       model.setItemDealPropertyCode_noev(getItemDealPropertyCode());
/* 634 */       model.setEffectiveDate_noev(getEffectiveDate());
/* 635 */       if (child instanceof IDataModelImpl) {
/* 636 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 637 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 638 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 639 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 642 */       if (postEventsForChanges()) {
/* 643 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemDealPropertyProperty(IItemDealPropertyProperty argItemDealPropertyProperty) {
/* 649 */     if (this._properties == null) {
/* 650 */       this._properties = new HistoricalList(null);
/*     */     }
/* 652 */     argItemDealPropertyProperty.setOrganizationId(getOrganizationId());
/* 653 */     argItemDealPropertyProperty.setItemId(getItemId());
/* 654 */     argItemDealPropertyProperty.setItemDealPropertyCode(getItemDealPropertyCode());
/* 655 */     argItemDealPropertyProperty.setEffectiveDate(getEffectiveDate());
/* 656 */     if (argItemDealPropertyProperty instanceof IDataModelImpl) {
/* 657 */       IDataAccessObject childDao = ((IDataModelImpl)argItemDealPropertyProperty).getDAO();
/* 658 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 659 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 660 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 665 */     if (postEventsForChanges()) {
/* 666 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDealPropertyProperty));
/*     */     }
/*     */     
/* 669 */     this._properties.add(argItemDealPropertyProperty);
/* 670 */     if (postEventsForChanges()) {
/* 671 */       this._events.post(IItemDealProperty.ADD_PROPERTIES, argItemDealPropertyProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeItemDealPropertyProperty(IItemDealPropertyProperty argItemDealPropertyProperty) {
/* 676 */     if (this._properties != null) {
/*     */       
/* 678 */       if (postEventsForChanges()) {
/* 679 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDealPropertyProperty));
/*     */       }
/* 681 */       this._properties.remove(argItemDealPropertyProperty);
/* 682 */       if (postEventsForChanges()) {
/* 683 */         this._events.post(IItemDealProperty.REMOVE_PROPERTIES, argItemDealPropertyProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentItem(IItem argParentItem) {
/* 689 */     this._parentItem = argParentItem;
/*     */   }
/*     */   
/*     */   public IItem getParentItem() {
/* 693 */     return this._parentItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 698 */     if ("Properties".equals(argFieldId)) {
/* 699 */       return getProperties();
/*     */     }
/* 701 */     if ("ItemDealPropertyExtension".equals(argFieldId)) {
/* 702 */       return this._myExtension;
/*     */     }
/*     */     
/* 705 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 711 */     if ("Properties".equals(argFieldId)) {
/* 712 */       setProperties(changeToList(argValue, IItemDealPropertyProperty.class));
/*     */     }
/* 714 */     else if ("ItemDealPropertyExtension".equals(argFieldId)) {
/* 715 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 718 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 724 */     this._persistenceDefaults = argPD;
/* 725 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 726 */     this._eventManager = argEM;
/* 727 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 728 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 729 */     if (this._properties != null) {
/* 730 */       for (IItemDealPropertyProperty relationship : this._properties) {
/* 731 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getItemDealPropertyExt() {
/* 737 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setItemDealPropertyExt(IDataModel argExt) {
/* 741 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 746 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 750 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 753 */     super.startTransaction();
/*     */     
/* 755 */     this._propertiesSavepoint = this._properties;
/* 756 */     if (this._properties != null) {
/* 757 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 758 */       Iterator<IDataModel> it = this._properties.iterator();
/* 759 */       while (it.hasNext()) {
/* 760 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 765 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 770 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 773 */     super.rollbackChanges();
/*     */     
/* 775 */     this._properties = this._propertiesSavepoint;
/* 776 */     this._propertiesSavepoint = null;
/* 777 */     if (this._properties != null) {
/* 778 */       Iterator<IDataModel> it = this._properties.iterator();
/* 779 */       while (it.hasNext()) {
/* 780 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 788 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 791 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 794 */     super.commitTransaction();
/*     */     
/* 796 */     this._propertiesSavepoint = this._properties;
/* 797 */     if (this._properties != null) {
/* 798 */       Iterator<IDataModel> it = this._properties.iterator();
/* 799 */       while (it.hasNext()) {
/* 800 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 802 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 806 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 811 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemDealPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */