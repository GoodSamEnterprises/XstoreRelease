/*     */ package dtv.xst.dao.cat.impl;
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
/*     */ import dtv.xst.dao.cat.CustomerAccountPlanPropertyId;
/*     */ import dtv.xst.dao.cat.ICustomerAccountPlan;
/*     */ import dtv.xst.dao.cat.ICustomerAccountPlanProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerAccountPlanModel extends AbstractDataModelWithPropertyImpl<ICustomerAccountPlanProperty> implements ICustomerAccountPlan {
/*     */   private static final long serialVersionUID = 1544725528L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICustomerAccountPlanProperty> _properties; private transient HistoricalList<ICustomerAccountPlanProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CustomerAccountPlanDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerAccountPlanDAO getDAO_() {
/*  46 */     return (CustomerAccountPlanDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICustomerAccountPlan.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CustomerAccountPlanPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CustomerAccountPlanPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getCustAccountCode() {
/* 101 */     return getDAO_().getCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/* 109 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ICustomerAccountPlan.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/* 122 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/* 123 */       getDAO_().setCustAccountCode(argCustAccountCode);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<CustomerAccountPlanPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((CustomerAccountPlanPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
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
/*     */   public String getPlanId() {
/* 143 */     return getDAO_().getPlanId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlanId(String argPlanId) {
/* 151 */     if (setPlanId_noev(argPlanId) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ICustomerAccountPlan.SET_PLANID, argPlanId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPlanId_noev(String argPlanId) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getPlanId() == null && argPlanId != null) || (
/* 164 */       getDAO_().getPlanId() != null && !getDAO_().getPlanId().equals(argPlanId))) {
/* 165 */       getDAO_().setPlanId(argPlanId);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<CustomerAccountPlanPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((CustomerAccountPlanPropertyModel)it.next()).setPlanId_noev(argPlanId);
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
/* 196 */       this._events.post(ICustomerAccountPlan.SET_CREATEDATE, argCreateDate);
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
/* 230 */       this._events.post(ICustomerAccountPlan.SET_CREATEUSERID, argCreateUserId);
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
/* 264 */       this._events.post(ICustomerAccountPlan.SET_UPDATEDATE, argUpdateDate);
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
/* 298 */       this._events.post(ICustomerAccountPlan.SET_UPDATEUSERID, argUpdateUserId);
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
/* 332 */       this._events.post(ICustomerAccountPlan.SET_ORGCODE, argOrgCode);
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
/* 366 */       this._events.post(ICustomerAccountPlan.SET_ORGVALUE, argOrgValue);
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
/*     */   public String getPlanDescription() {
/* 389 */     return getDAO_().getPlanDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlanDescription(String argPlanDescription) {
/* 397 */     if (setPlanDescription_noev(argPlanDescription) && 
/* 398 */       this._events != null && 
/* 399 */       postEventsForChanges()) {
/* 400 */       this._events.post(ICustomerAccountPlan.SET_PLANDESCRIPTION, argPlanDescription);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPlanDescription_noev(String argPlanDescription) {
/* 407 */     boolean ev_postable = false;
/*     */     
/* 409 */     if ((getDAO_().getPlanDescription() == null && argPlanDescription != null) || (
/* 410 */       getDAO_().getPlanDescription() != null && !getDAO_().getPlanDescription().equals(argPlanDescription))) {
/* 411 */       getDAO_().setPlanDescription(argPlanDescription);
/* 412 */       ev_postable = true;
/*     */     } 
/*     */     
/* 415 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEffectiveDate() {
/* 423 */     return getDAO_().getEffectiveDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 431 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/* 432 */       this._events != null && 
/* 433 */       postEventsForChanges()) {
/* 434 */       this._events.post(ICustomerAccountPlan.SET_EFFECTIVEDATE, argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/* 441 */     boolean ev_postable = false;
/*     */     
/* 443 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/* 444 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/* 445 */       getDAO_().setEffectiveDate(argEffectiveDate);
/* 446 */       ev_postable = true;
/*     */     } 
/*     */     
/* 449 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 457 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 465 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 466 */       this._events != null && 
/* 467 */       postEventsForChanges()) {
/* 468 */       this._events.post(ICustomerAccountPlan.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 475 */     boolean ev_postable = false;
/*     */     
/* 477 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 478 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 479 */       getDAO_().setExpirationDate(argExpirationDate);
/* 480 */       ev_postable = true;
/*     */     } 
/*     */     
/* 483 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayOrder() {
/* 491 */     if (getDAO_().getDisplayOrder() != null) {
/* 492 */       return getDAO_().getDisplayOrder().intValue();
/*     */     }
/*     */     
/* 495 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayOrder(int argDisplayOrder) {
/* 504 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/* 505 */       this._events != null && 
/* 506 */       postEventsForChanges()) {
/* 507 */       this._events.post(ICustomerAccountPlan.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/* 514 */     boolean ev_postable = false;
/*     */     
/* 516 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/* 517 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/* 518 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
/* 519 */       ev_postable = true;
/*     */     } 
/*     */     
/* 522 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerAccountPlanProperty newProperty(String argPropertyName) {
/* 526 */     CustomerAccountPlanPropertyId id = new CustomerAccountPlanPropertyId();
/*     */     
/* 528 */     id.setCustAccountCode(getCustAccountCode());
/* 529 */     id.setPlanId(getPlanId());
/* 530 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 532 */     ICustomerAccountPlanProperty prop = (ICustomerAccountPlanProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerAccountPlanProperty.class);
/* 533 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerAccountPlanProperty> getProperties() {
/* 542 */     if (this._properties == null) {
/* 543 */       this._properties = new HistoricalList(null);
/*     */     }
/* 545 */     return (List<ICustomerAccountPlanProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerAccountPlanProperty> argProperties) {
/* 549 */     if (this._properties == null) {
/* 550 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 552 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 555 */     for (ICustomerAccountPlanProperty child : this._properties) {
/* 556 */       CustomerAccountPlanPropertyModel model = (CustomerAccountPlanPropertyModel)child;
/* 557 */       model.setOrganizationId_noev(getOrganizationId());
/* 558 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 559 */       model.setPlanId_noev(getPlanId());
/* 560 */       if (child instanceof IDataModelImpl) {
/* 561 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 562 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 563 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 564 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 567 */       if (postEventsForChanges()) {
/* 568 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerAccountPlanProperty(ICustomerAccountPlanProperty argCustomerAccountPlanProperty) {
/* 574 */     if (this._properties == null) {
/* 575 */       this._properties = new HistoricalList(null);
/*     */     }
/* 577 */     argCustomerAccountPlanProperty.setOrganizationId(getOrganizationId());
/* 578 */     argCustomerAccountPlanProperty.setCustAccountCode(getCustAccountCode());
/* 579 */     argCustomerAccountPlanProperty.setPlanId(getPlanId());
/* 580 */     if (argCustomerAccountPlanProperty instanceof IDataModelImpl) {
/* 581 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountPlanProperty).getDAO();
/* 582 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 583 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 584 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 589 */     if (postEventsForChanges()) {
/* 590 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountPlanProperty));
/*     */     }
/*     */     
/* 593 */     this._properties.add(argCustomerAccountPlanProperty);
/* 594 */     if (postEventsForChanges()) {
/* 595 */       this._events.post(ICustomerAccountPlan.ADD_PROPERTIES, argCustomerAccountPlanProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerAccountPlanProperty(ICustomerAccountPlanProperty argCustomerAccountPlanProperty) {
/* 600 */     if (this._properties != null) {
/*     */       
/* 602 */       if (postEventsForChanges()) {
/* 603 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountPlanProperty));
/*     */       }
/* 605 */       this._properties.remove(argCustomerAccountPlanProperty);
/* 606 */       if (postEventsForChanges()) {
/* 607 */         this._events.post(ICustomerAccountPlan.REMOVE_PROPERTIES, argCustomerAccountPlanProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 614 */     if ("Properties".equals(argFieldId)) {
/* 615 */       return getProperties();
/*     */     }
/* 617 */     if ("CustomerAccountPlanExtension".equals(argFieldId)) {
/* 618 */       return this._myExtension;
/*     */     }
/*     */     
/* 621 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 627 */     if ("Properties".equals(argFieldId)) {
/* 628 */       setProperties(changeToList(argValue, ICustomerAccountPlanProperty.class));
/*     */     }
/* 630 */     else if ("CustomerAccountPlanExtension".equals(argFieldId)) {
/* 631 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 634 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 640 */     this._persistenceDefaults = argPD;
/* 641 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 642 */     this._eventManager = argEM;
/* 643 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 644 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 645 */     if (this._properties != null) {
/* 646 */       for (ICustomerAccountPlanProperty relationship : this._properties) {
/* 647 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerAccountPlanExt() {
/* 653 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerAccountPlanExt(IDataModel argExt) {
/* 657 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 662 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 666 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 669 */     super.startTransaction();
/*     */     
/* 671 */     this._propertiesSavepoint = this._properties;
/* 672 */     if (this._properties != null) {
/* 673 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 674 */       Iterator<IDataModel> it = this._properties.iterator();
/* 675 */       while (it.hasNext()) {
/* 676 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 681 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 686 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 689 */     super.rollbackChanges();
/*     */     
/* 691 */     this._properties = this._propertiesSavepoint;
/* 692 */     this._propertiesSavepoint = null;
/* 693 */     if (this._properties != null) {
/* 694 */       Iterator<IDataModel> it = this._properties.iterator();
/* 695 */       while (it.hasNext()) {
/* 696 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 704 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 707 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 710 */     super.commitTransaction();
/*     */     
/* 712 */     this._propertiesSavepoint = this._properties;
/* 713 */     if (this._properties != null) {
/* 714 */       Iterator<IDataModel> it = this._properties.iterator();
/* 715 */       while (it.hasNext()) {
/* 716 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 718 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 722 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 727 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountPlanModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */