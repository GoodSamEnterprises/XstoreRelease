/*     */ package dtv.xst.dao.cwo.impl;
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
/*     */ import dtv.xst.dao.cwo.IWorkOrderPricing;
/*     */ import dtv.xst.dao.cwo.IWorkOrderPricingProperty;
/*     */ import dtv.xst.dao.cwo.WorkOrderPricingPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WorkOrderPricingModel extends AbstractDataModelWithPropertyImpl<IWorkOrderPricingProperty> implements IWorkOrderPricing {
/*     */   private static final long serialVersionUID = 273533545L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IWorkOrderPricingProperty> _properties; private transient HistoricalList<IWorkOrderPricingProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new WorkOrderPricingDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorkOrderPricingDAO getDAO_() {
/*  46 */     return (WorkOrderPricingDAO)this._daoImpl;
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
/*  70 */       this._events.post(IWorkOrderPricing.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<WorkOrderPricingPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((WorkOrderPricingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getPriceCode() {
/* 101 */     return getDAO_().getPriceCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPriceCode(String argPriceCode) {
/* 109 */     if (setPriceCode_noev(argPriceCode) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IWorkOrderPricing.SET_PRICECODE, argPriceCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPriceCode_noev(String argPriceCode) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getPriceCode() == null && argPriceCode != null) || (
/* 122 */       getDAO_().getPriceCode() != null && !getDAO_().getPriceCode().equals(argPriceCode))) {
/* 123 */       getDAO_().setPriceCode(argPriceCode);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<WorkOrderPricingPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((WorkOrderPricingPropertyModel)it.next()).setPriceCode_noev(argPriceCode);
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
/*     */   public String getItemId() {
/* 143 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 151 */     if (setItemId_noev(argItemId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IWorkOrderPricing.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 164 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 165 */       getDAO_().setItemId(argItemId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<WorkOrderPricingPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((WorkOrderPricingPropertyModel)it.next()).setItemId_noev(argItemId);
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
/*     */   public Date getCreateDate() {
/* 185 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 193 */     if (setCreateDate_noev(argCreateDate) && 
/* 194 */       this._events != null && 
/* 195 */       postEventsForChanges()) {
/* 196 */       this._events.post(IWorkOrderPricing.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 203 */     boolean ev_postable = false;
/*     */     
/* 205 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 206 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 207 */       getDAO_().setCreateDate(argCreateDate);
/* 208 */       ev_postable = true;
/*     */     } 
/*     */     
/* 211 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 219 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 227 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 228 */       this._events != null && 
/* 229 */       postEventsForChanges()) {
/* 230 */       this._events.post(IWorkOrderPricing.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 237 */     boolean ev_postable = false;
/*     */     
/* 239 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 240 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 241 */       getDAO_().setCreateUserId(argCreateUserId);
/* 242 */       ev_postable = true;
/*     */     } 
/*     */     
/* 245 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 253 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 261 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 262 */       this._events != null && 
/* 263 */       postEventsForChanges()) {
/* 264 */       this._events.post(IWorkOrderPricing.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 271 */     boolean ev_postable = false;
/*     */     
/* 273 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 274 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 275 */       getDAO_().setUpdateDate(argUpdateDate);
/* 276 */       ev_postable = true;
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 287 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 295 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IWorkOrderPricing.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 308 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 309 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 310 */       ev_postable = true;
/*     */     } 
/*     */     
/* 313 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgCode() {
/* 321 */     return getDAO_().getOrgCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 329 */     if (setOrgCode_noev(argOrgCode) && 
/* 330 */       this._events != null && 
/* 331 */       postEventsForChanges()) {
/* 332 */       this._events.post(IWorkOrderPricing.SET_ORGCODE, argOrgCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgCode_noev(String argOrgCode) {
/* 339 */     boolean ev_postable = false;
/*     */     
/* 341 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/* 342 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/* 343 */       getDAO_().setOrgCode(argOrgCode);
/* 344 */       ev_postable = true;
/*     */     } 
/*     */     
/* 347 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrgValue() {
/* 355 */     return getDAO_().getOrgValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 363 */     if (setOrgValue_noev(argOrgValue) && 
/* 364 */       this._events != null && 
/* 365 */       postEventsForChanges()) {
/* 366 */       this._events.post(IWorkOrderPricing.SET_ORGVALUE, argOrgValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrgValue_noev(String argOrgValue) {
/* 373 */     boolean ev_postable = false;
/*     */     
/* 375 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/* 376 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/* 377 */       getDAO_().setOrgValue(argOrgValue);
/* 378 */       ev_postable = true;
/*     */     } 
/*     */     
/* 381 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPrice() {
/* 389 */     return getDAO_().getPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrice(BigDecimal argPrice) {
/* 397 */     if (setPrice_noev(argPrice) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(IWorkOrderPricing.SET_PRICE, argPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrice_noev(BigDecimal argPrice) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getPrice() == null && argPrice != null) || (
/* 410 */       getDAO_().getPrice() != null && !getDAO_().getPrice().equals(argPrice))) {
/* 411 */       getDAO_().setPrice(argPrice);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IWorkOrderPricingProperty newProperty(String argPropertyName) {
/* 419 */     WorkOrderPricingPropertyId id = new WorkOrderPricingPropertyId();
/*     */     
/* 421 */     id.setPriceCode(getPriceCode());
/* 422 */     id.setItemId(getItemId());
/* 423 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 425 */     IWorkOrderPricingProperty prop = (IWorkOrderPricingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWorkOrderPricingProperty.class);
/* 426 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IWorkOrderPricingProperty> getProperties() {
/* 435 */     if (this._properties == null) {
/* 436 */       this._properties = new HistoricalList(null);
/*     */     }
/* 438 */     return (List<IWorkOrderPricingProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IWorkOrderPricingProperty> argProperties) {
/* 442 */     if (this._properties == null) {
/* 443 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 445 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 448 */     for (IWorkOrderPricingProperty child : this._properties) {
/* 449 */       WorkOrderPricingPropertyModel model = (WorkOrderPricingPropertyModel)child;
/* 450 */       model.setOrganizationId_noev(getOrganizationId());
/* 451 */       model.setPriceCode_noev(getPriceCode());
/* 452 */       model.setItemId_noev(getItemId());
/* 453 */       if (child instanceof IDataModelImpl) {
/* 454 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 455 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 456 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 457 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 460 */       if (postEventsForChanges()) {
/* 461 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addWorkOrderPricingProperty(IWorkOrderPricingProperty argWorkOrderPricingProperty) {
/* 467 */     if (this._properties == null) {
/* 468 */       this._properties = new HistoricalList(null);
/*     */     }
/* 470 */     argWorkOrderPricingProperty.setOrganizationId(getOrganizationId());
/* 471 */     argWorkOrderPricingProperty.setPriceCode(getPriceCode());
/* 472 */     argWorkOrderPricingProperty.setItemId(getItemId());
/* 473 */     if (argWorkOrderPricingProperty instanceof IDataModelImpl) {
/* 474 */       IDataAccessObject childDao = ((IDataModelImpl)argWorkOrderPricingProperty).getDAO();
/* 475 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 476 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 477 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 482 */     if (postEventsForChanges()) {
/* 483 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderPricingProperty));
/*     */     }
/*     */     
/* 486 */     this._properties.add(argWorkOrderPricingProperty);
/* 487 */     if (postEventsForChanges()) {
/* 488 */       this._events.post(IWorkOrderPricing.ADD_PROPERTIES, argWorkOrderPricingProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWorkOrderPricingProperty(IWorkOrderPricingProperty argWorkOrderPricingProperty) {
/* 493 */     if (this._properties != null) {
/*     */       
/* 495 */       if (postEventsForChanges()) {
/* 496 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkOrderPricingProperty));
/*     */       }
/* 498 */       this._properties.remove(argWorkOrderPricingProperty);
/* 499 */       if (postEventsForChanges()) {
/* 500 */         this._events.post(IWorkOrderPricing.REMOVE_PROPERTIES, argWorkOrderPricingProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 507 */     if ("Properties".equals(argFieldId)) {
/* 508 */       return getProperties();
/*     */     }
/* 510 */     if ("WorkOrderPricingExtension".equals(argFieldId)) {
/* 511 */       return this._myExtension;
/*     */     }
/*     */     
/* 514 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 520 */     if ("Properties".equals(argFieldId)) {
/* 521 */       setProperties(changeToList(argValue, IWorkOrderPricingProperty.class));
/*     */     }
/* 523 */     else if ("WorkOrderPricingExtension".equals(argFieldId)) {
/* 524 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 527 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 533 */     this._persistenceDefaults = argPD;
/* 534 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 535 */     this._eventManager = argEM;
/* 536 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 537 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 538 */     if (this._properties != null) {
/* 539 */       for (IWorkOrderPricingProperty relationship : this._properties) {
/* 540 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getWorkOrderPricingExt() {
/* 546 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setWorkOrderPricingExt(IDataModel argExt) {
/* 550 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 555 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 559 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 562 */     super.startTransaction();
/*     */     
/* 564 */     this._propertiesSavepoint = this._properties;
/* 565 */     if (this._properties != null) {
/* 566 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 567 */       Iterator<IDataModel> it = this._properties.iterator();
/* 568 */       while (it.hasNext()) {
/* 569 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 574 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 579 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 582 */     super.rollbackChanges();
/*     */     
/* 584 */     this._properties = this._propertiesSavepoint;
/* 585 */     this._propertiesSavepoint = null;
/* 586 */     if (this._properties != null) {
/* 587 */       Iterator<IDataModel> it = this._properties.iterator();
/* 588 */       while (it.hasNext()) {
/* 589 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 597 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 600 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 603 */     super.commitTransaction();
/*     */     
/* 605 */     this._propertiesSavepoint = this._properties;
/* 606 */     if (this._properties != null) {
/* 607 */       Iterator<IDataModel> it = this._properties.iterator();
/* 608 */       while (it.hasNext()) {
/* 609 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 611 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 615 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 620 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderPricingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */