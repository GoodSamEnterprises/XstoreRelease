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
/*     */ import dtv.xst.dao.cat.CustomerAccountAuthorizationPropertyId;
/*     */ import dtv.xst.dao.cat.ICustomerAccountAuthorization;
/*     */ import dtv.xst.dao.cat.ICustomerAccountAuthorizationProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CustomerAccountAuthorizationModel extends AbstractDataModelWithPropertyImpl<ICustomerAccountAuthorizationProperty> implements ICustomerAccountAuthorization {
/*     */   private static final long serialVersionUID = -1099471766L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ICustomerAccountAuthorizationProperty> _properties; private transient HistoricalList<ICustomerAccountAuthorizationProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new CustomerAccountAuthorizationDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CustomerAccountAuthorizationDAO getDAO_() {
/*  46 */     return (CustomerAccountAuthorizationDAO)this._daoImpl;
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
/*  70 */       this._events.post(ICustomerAccountAuthorization.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<CustomerAccountAuthorizationPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((CustomerAccountAuthorizationPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public int getRetailTransactionLineItemSequence() {
/* 101 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 102 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 105 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 114 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(ICustomerAccountAuthorization.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 127 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 128 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<CustomerAccountAuthorizationPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((CustomerAccountAuthorizationPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 148 */     if (getDAO_().getRetailLocationId() != null) {
/* 149 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 152 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 161 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(ICustomerAccountAuthorization.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 174 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 175 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<CustomerAccountAuthorizationPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((CustomerAccountAuthorizationPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 195 */     if (getDAO_().getWorkstationId() != null) {
/* 196 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 199 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 208 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 209 */       this._events != null && 
/* 210 */       postEventsForChanges()) {
/* 211 */       this._events.post(ICustomerAccountAuthorization.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 218 */     boolean ev_postable = false;
/*     */     
/* 220 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 221 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 222 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 223 */       ev_postable = true;
/* 224 */       if (this._properties != null) {
/*     */         
/* 226 */         Iterator<CustomerAccountAuthorizationPropertyModel> it = this._properties.iterator();
/* 227 */         while (it.hasNext())
/*     */         {
/* 229 */           ((CustomerAccountAuthorizationPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 234 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 242 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 250 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(ICustomerAccountAuthorization.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 263 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 264 */       getDAO_().setBusinessDate(argBusinessDate);
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<CustomerAccountAuthorizationPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((CustomerAccountAuthorizationPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 284 */     if (getDAO_().getTransactionSequence() != null) {
/* 285 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 288 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 297 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(ICustomerAccountAuthorization.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 310 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 311 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<CustomerAccountAuthorizationPropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((CustomerAccountAuthorizationPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 331 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 339 */     if (setCreateDate_noev(argCreateDate) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ICustomerAccountAuthorization.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 352 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 353 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 365 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 373 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(ICustomerAccountAuthorization.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 386 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 387 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 399 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 407 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(ICustomerAccountAuthorization.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 420 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 421 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 433 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 441 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(ICustomerAccountAuthorization.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 454 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 455 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*     */   public String getStatusCode() {
/* 467 */     return getDAO_().getStatusCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusCode(String argStatusCode) {
/* 475 */     if (setStatusCode_noev(argStatusCode) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(ICustomerAccountAuthorization.SET_STATUSCODE, argStatusCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStatusCode_noev(String argStatusCode) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/* 488 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/* 489 */       getDAO_().setStatusCode(argStatusCode);
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
/*     */   public Date getStatusDatetime() {
/* 501 */     return getDAO_().getStatusDatetime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusDatetime(Date argStatusDatetime) {
/* 509 */     if (setStatusDatetime_noev(argStatusDatetime) && 
/* 510 */       this._events != null && 
/* 511 */       postEventsForChanges()) {
/* 512 */       this._events.post(ICustomerAccountAuthorization.SET_STATUSDATETIME, argStatusDatetime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStatusDatetime_noev(Date argStatusDatetime) {
/* 519 */     boolean ev_postable = false;
/*     */     
/* 521 */     if ((getDAO_().getStatusDatetime() == null && argStatusDatetime != null) || (
/* 522 */       getDAO_().getStatusDatetime() != null && !getDAO_().getStatusDatetime().equals(argStatusDatetime))) {
/* 523 */       getDAO_().setStatusDatetime(argStatusDatetime);
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
/*     */   public String getAuthorizationType() {
/* 535 */     return getDAO_().getAuthorizationType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorizationType(String argAuthorizationType) {
/* 543 */     if (setAuthorizationType_noev(argAuthorizationType) && 
/* 544 */       this._events != null && 
/* 545 */       postEventsForChanges()) {
/* 546 */       this._events.post(ICustomerAccountAuthorization.SET_AUTHORIZATIONTYPE, argAuthorizationType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorizationType_noev(String argAuthorizationType) {
/* 553 */     boolean ev_postable = false;
/*     */     
/* 555 */     if ((getDAO_().getAuthorizationType() == null && argAuthorizationType != null) || (
/* 556 */       getDAO_().getAuthorizationType() != null && !getDAO_().getAuthorizationType().equals(argAuthorizationType))) {
/* 557 */       getDAO_().setAuthorizationType(argAuthorizationType);
/* 558 */       ev_postable = true;
/*     */     } 
/*     */     
/* 561 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ICustomerAccountAuthorizationProperty newProperty(String argPropertyName) {
/* 565 */     CustomerAccountAuthorizationPropertyId id = new CustomerAccountAuthorizationPropertyId();
/*     */     
/* 567 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 568 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 569 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 570 */     id.setBusinessDate(getBusinessDate());
/* 571 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 572 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 574 */     ICustomerAccountAuthorizationProperty prop = (ICustomerAccountAuthorizationProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerAccountAuthorizationProperty.class);
/* 575 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ICustomerAccountAuthorizationProperty> getProperties() {
/* 584 */     if (this._properties == null) {
/* 585 */       this._properties = new HistoricalList(null);
/*     */     }
/* 587 */     return (List<ICustomerAccountAuthorizationProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ICustomerAccountAuthorizationProperty> argProperties) {
/* 591 */     if (this._properties == null) {
/* 592 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 594 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 597 */     for (ICustomerAccountAuthorizationProperty child : this._properties) {
/* 598 */       CustomerAccountAuthorizationPropertyModel model = (CustomerAccountAuthorizationPropertyModel)child;
/* 599 */       model.setOrganizationId_noev(getOrganizationId());
/* 600 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 601 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 602 */       model.setWorkstationId_noev(getWorkstationId());
/* 603 */       model.setBusinessDate_noev(getBusinessDate());
/* 604 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 605 */       if (child instanceof IDataModelImpl) {
/* 606 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 607 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 608 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 609 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 612 */       if (postEventsForChanges()) {
/* 613 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomerAccountAuthorizationProperty(ICustomerAccountAuthorizationProperty argCustomerAccountAuthorizationProperty) {
/* 619 */     if (this._properties == null) {
/* 620 */       this._properties = new HistoricalList(null);
/*     */     }
/* 622 */     argCustomerAccountAuthorizationProperty.setOrganizationId(getOrganizationId());
/* 623 */     argCustomerAccountAuthorizationProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 624 */     argCustomerAccountAuthorizationProperty.setRetailLocationId(getRetailLocationId());
/* 625 */     argCustomerAccountAuthorizationProperty.setWorkstationId(getWorkstationId());
/* 626 */     argCustomerAccountAuthorizationProperty.setBusinessDate(getBusinessDate());
/* 627 */     argCustomerAccountAuthorizationProperty.setTransactionSequence(getTransactionSequence());
/* 628 */     if (argCustomerAccountAuthorizationProperty instanceof IDataModelImpl) {
/* 629 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerAccountAuthorizationProperty).getDAO();
/* 630 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 631 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 632 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 637 */     if (postEventsForChanges()) {
/* 638 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountAuthorizationProperty));
/*     */     }
/*     */     
/* 641 */     this._properties.add(argCustomerAccountAuthorizationProperty);
/* 642 */     if (postEventsForChanges()) {
/* 643 */       this._events.post(ICustomerAccountAuthorization.ADD_PROPERTIES, argCustomerAccountAuthorizationProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCustomerAccountAuthorizationProperty(ICustomerAccountAuthorizationProperty argCustomerAccountAuthorizationProperty) {
/* 648 */     if (this._properties != null) {
/*     */       
/* 650 */       if (postEventsForChanges()) {
/* 651 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountAuthorizationProperty));
/*     */       }
/* 653 */       this._properties.remove(argCustomerAccountAuthorizationProperty);
/* 654 */       if (postEventsForChanges()) {
/* 655 */         this._events.post(ICustomerAccountAuthorization.REMOVE_PROPERTIES, argCustomerAccountAuthorizationProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 662 */     if ("Properties".equals(argFieldId)) {
/* 663 */       return getProperties();
/*     */     }
/* 665 */     if ("CustomerAccountAuthorizationExtension".equals(argFieldId)) {
/* 666 */       return this._myExtension;
/*     */     }
/*     */     
/* 669 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 675 */     if ("Properties".equals(argFieldId)) {
/* 676 */       setProperties(changeToList(argValue, ICustomerAccountAuthorizationProperty.class));
/*     */     }
/* 678 */     else if ("CustomerAccountAuthorizationExtension".equals(argFieldId)) {
/* 679 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 682 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 688 */     this._persistenceDefaults = argPD;
/* 689 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 690 */     this._eventManager = argEM;
/* 691 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 692 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 693 */     if (this._properties != null) {
/* 694 */       for (ICustomerAccountAuthorizationProperty relationship : this._properties) {
/* 695 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getCustomerAccountAuthorizationExt() {
/* 701 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCustomerAccountAuthorizationExt(IDataModel argExt) {
/* 705 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 710 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 714 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 717 */     super.startTransaction();
/*     */     
/* 719 */     this._propertiesSavepoint = this._properties;
/* 720 */     if (this._properties != null) {
/* 721 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 722 */       Iterator<IDataModel> it = this._properties.iterator();
/* 723 */       while (it.hasNext()) {
/* 724 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 729 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 734 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 737 */     super.rollbackChanges();
/*     */     
/* 739 */     this._properties = this._propertiesSavepoint;
/* 740 */     this._propertiesSavepoint = null;
/* 741 */     if (this._properties != null) {
/* 742 */       Iterator<IDataModel> it = this._properties.iterator();
/* 743 */       while (it.hasNext()) {
/* 744 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 752 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 755 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 758 */     super.commitTransaction();
/*     */     
/* 760 */     this._propertiesSavepoint = this._properties;
/* 761 */     if (this._properties != null) {
/* 762 */       Iterator<IDataModel> it = this._properties.iterator();
/* 763 */       while (it.hasNext()) {
/* 764 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 766 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 770 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 775 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountAuthorizationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */