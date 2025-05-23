/*     */ package dtv.xst.dao.cwo.impl;
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
/*     */ import dtv.xst.dao.cwo.IInvoice;
/*     */ import dtv.xst.dao.cwo.IInvoiceLineItem;
/*     */ import dtv.xst.dao.cwo.IInvoiceLineItemProperty;
/*     */ import dtv.xst.dao.cwo.InvoiceLineItemPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InvoiceLineItemModel extends AbstractDataModelWithPropertyImpl<IInvoiceLineItemProperty> implements IInvoiceLineItem {
/*     */   private static final long serialVersionUID = 1194092372L;
/*     */   private IInvoice _parentInvoice;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInvoiceLineItemProperty> _properties; private transient HistoricalList<IInvoiceLineItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InvoiceLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InvoiceLineItemDAO getDAO_() {
/*  48 */     return (InvoiceLineItemDAO)this._daoImpl;
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
/*  72 */       this._events.post(IInvoiceLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<InvoiceLineItemPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((InvoiceLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getServiceLocationId() {
/* 103 */     return getDAO_().getServiceLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 111 */     if (setServiceLocationId_noev(argServiceLocationId) && 
/* 112 */       this._events != null && 
/* 113 */       postEventsForChanges()) {
/* 114 */       this._events.post(IInvoiceLineItem.SET_SERVICELOCATIONID, argServiceLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setServiceLocationId_noev(String argServiceLocationId) {
/* 121 */     boolean ev_postable = false;
/*     */     
/* 123 */     if ((getDAO_().getServiceLocationId() == null && argServiceLocationId != null) || (
/* 124 */       getDAO_().getServiceLocationId() != null && !getDAO_().getServiceLocationId().equals(argServiceLocationId))) {
/* 125 */       getDAO_().setServiceLocationId(argServiceLocationId);
/* 126 */       ev_postable = true;
/* 127 */       if (this._properties != null) {
/*     */         
/* 129 */         Iterator<InvoiceLineItemPropertyModel> it = this._properties.iterator();
/* 130 */         while (it.hasNext())
/*     */         {
/* 132 */           ((InvoiceLineItemPropertyModel)it.next()).setServiceLocationId_noev(argServiceLocationId);
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
/*     */   public String getInvoiceNumber() {
/* 145 */     return getDAO_().getInvoiceNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/* 153 */     if (setInvoiceNumber_noev(argInvoiceNumber) && 
/* 154 */       this._events != null && 
/* 155 */       postEventsForChanges()) {
/* 156 */       this._events.post(IInvoiceLineItem.SET_INVOICENUMBER, argInvoiceNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceNumber_noev(String argInvoiceNumber) {
/* 163 */     boolean ev_postable = false;
/*     */     
/* 165 */     if ((getDAO_().getInvoiceNumber() == null && argInvoiceNumber != null) || (
/* 166 */       getDAO_().getInvoiceNumber() != null && !getDAO_().getInvoiceNumber().equals(argInvoiceNumber))) {
/* 167 */       getDAO_().setInvoiceNumber(argInvoiceNumber);
/* 168 */       ev_postable = true;
/* 169 */       if (this._properties != null) {
/*     */         
/* 171 */         Iterator<InvoiceLineItemPropertyModel> it = this._properties.iterator();
/* 172 */         while (it.hasNext())
/*     */         {
/* 174 */           ((InvoiceLineItemPropertyModel)it.next()).setInvoiceNumber_noev(argInvoiceNumber);
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
/*     */   public int getInvoiceLineItemSequence() {
/* 187 */     if (getDAO_().getInvoiceLineItemSequence() != null) {
/* 188 */       return getDAO_().getInvoiceLineItemSequence().intValue();
/*     */     }
/*     */     
/* 191 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceLineItemSequence(int argInvoiceLineItemSequence) {
/* 200 */     if (setInvoiceLineItemSequence_noev(argInvoiceLineItemSequence) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IInvoiceLineItem.SET_INVOICELINEITEMSEQUENCE, Integer.valueOf(argInvoiceLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceLineItemSequence_noev(int argInvoiceLineItemSequence) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getInvoiceLineItemSequence() == null && Integer.valueOf(argInvoiceLineItemSequence) != null) || (
/* 213 */       getDAO_().getInvoiceLineItemSequence() != null && !getDAO_().getInvoiceLineItemSequence().equals(Integer.valueOf(argInvoiceLineItemSequence)))) {
/* 214 */       getDAO_().setInvoiceLineItemSequence(Integer.valueOf(argInvoiceLineItemSequence));
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<InvoiceLineItemPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((InvoiceLineItemPropertyModel)it.next()).setInvoiceLineItemSequence_noev(argInvoiceLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 234 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 242 */     if (setCreateDate_noev(argCreateDate) && 
/* 243 */       this._events != null && 
/* 244 */       postEventsForChanges()) {
/* 245 */       this._events.post(IInvoiceLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 252 */     boolean ev_postable = false;
/*     */     
/* 254 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 255 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 256 */       getDAO_().setCreateDate(argCreateDate);
/* 257 */       ev_postable = true;
/*     */     } 
/*     */     
/* 260 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 268 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 276 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 277 */       this._events != null && 
/* 278 */       postEventsForChanges()) {
/* 279 */       this._events.post(IInvoiceLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 286 */     boolean ev_postable = false;
/*     */     
/* 288 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 289 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 290 */       getDAO_().setCreateUserId(argCreateUserId);
/* 291 */       ev_postable = true;
/*     */     } 
/*     */     
/* 294 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 302 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 310 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 311 */       this._events != null && 
/* 312 */       postEventsForChanges()) {
/* 313 */       this._events.post(IInvoiceLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 320 */     boolean ev_postable = false;
/*     */     
/* 322 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 323 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 324 */       getDAO_().setUpdateDate(argUpdateDate);
/* 325 */       ev_postable = true;
/*     */     } 
/*     */     
/* 328 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 336 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 344 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 345 */       this._events != null && 
/* 346 */       postEventsForChanges()) {
/* 347 */       this._events.post(IInvoiceLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 354 */     boolean ev_postable = false;
/*     */     
/* 356 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 357 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 358 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 359 */       ev_postable = true;
/*     */     } 
/*     */     
/* 362 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLineItemTypeCode() {
/* 370 */     return getDAO_().getLineItemTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemTypeCode(String argLineItemTypeCode) {
/* 378 */     if (setLineItemTypeCode_noev(argLineItemTypeCode) && 
/* 379 */       this._events != null && 
/* 380 */       postEventsForChanges()) {
/* 381 */       this._events.post(IInvoiceLineItem.SET_LINEITEMTYPECODE, argLineItemTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemTypeCode_noev(String argLineItemTypeCode) {
/* 388 */     boolean ev_postable = false;
/*     */     
/* 390 */     if ((getDAO_().getLineItemTypeCode() == null && argLineItemTypeCode != null) || (
/* 391 */       getDAO_().getLineItemTypeCode() != null && !getDAO_().getLineItemTypeCode().equals(argLineItemTypeCode))) {
/* 392 */       getDAO_().setLineItemTypeCode(argLineItemTypeCode);
/* 393 */       ev_postable = true;
/*     */     } 
/*     */     
/* 396 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 404 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 412 */     if (setAmount_noev(argAmount) && 
/* 413 */       this._events != null && 
/* 414 */       postEventsForChanges()) {
/* 415 */       this._events.post(IInvoiceLineItem.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 422 */     boolean ev_postable = false;
/*     */     
/* 424 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 425 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 426 */       getDAO_().setAmount(argAmount);
/* 427 */       ev_postable = true;
/*     */     } 
/*     */     
/* 430 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGlAccount() {
/* 438 */     return getDAO_().getGlAccount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGlAccount(String argGlAccount) {
/* 446 */     if (setGlAccount_noev(argGlAccount) && 
/* 447 */       this._events != null && 
/* 448 */       postEventsForChanges()) {
/* 449 */       this._events.post(IInvoiceLineItem.SET_GLACCOUNT, argGlAccount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setGlAccount_noev(String argGlAccount) {
/* 456 */     boolean ev_postable = false;
/*     */     
/* 458 */     if ((getDAO_().getGlAccount() == null && argGlAccount != null) || (
/* 459 */       getDAO_().getGlAccount() != null && !getDAO_().getGlAccount().equals(argGlAccount))) {
/* 460 */       getDAO_().setGlAccount(argGlAccount);
/* 461 */       ev_postable = true;
/*     */     } 
/*     */     
/* 464 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 472 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 480 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 481 */       this._events != null && 
/* 482 */       postEventsForChanges()) {
/* 483 */       this._events.post(IInvoiceLineItem.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 490 */     boolean ev_postable = false;
/*     */     
/* 492 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 493 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 494 */       getDAO_().setCustAccountId(argCustAccountId);
/* 495 */       ev_postable = true;
/*     */     } 
/*     */     
/* 498 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInvoiceLineItemProperty newProperty(String argPropertyName) {
/* 502 */     InvoiceLineItemPropertyId id = new InvoiceLineItemPropertyId();
/*     */     
/* 504 */     id.setServiceLocationId(getServiceLocationId());
/* 505 */     id.setInvoiceNumber(getInvoiceNumber());
/* 506 */     id.setInvoiceLineItemSequence(Integer.valueOf(getInvoiceLineItemSequence()));
/* 507 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 509 */     IInvoiceLineItemProperty prop = (IInvoiceLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInvoiceLineItemProperty.class);
/* 510 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInvoiceLineItemProperty> getProperties() {
/* 519 */     if (this._properties == null) {
/* 520 */       this._properties = new HistoricalList(null);
/*     */     }
/* 522 */     return (List<IInvoiceLineItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInvoiceLineItemProperty> argProperties) {
/* 526 */     if (this._properties == null) {
/* 527 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 529 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 532 */     for (IInvoiceLineItemProperty child : this._properties) {
/* 533 */       InvoiceLineItemPropertyModel model = (InvoiceLineItemPropertyModel)child;
/* 534 */       model.setOrganizationId_noev(getOrganizationId());
/* 535 */       model.setServiceLocationId_noev(getServiceLocationId());
/* 536 */       model.setInvoiceNumber_noev(getInvoiceNumber());
/* 537 */       model.setInvoiceLineItemSequence_noev(getInvoiceLineItemSequence());
/* 538 */       if (child instanceof IDataModelImpl) {
/* 539 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 540 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 541 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 542 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 545 */       if (postEventsForChanges()) {
/* 546 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInvoiceLineItemProperty(IInvoiceLineItemProperty argInvoiceLineItemProperty) {
/* 552 */     if (this._properties == null) {
/* 553 */       this._properties = new HistoricalList(null);
/*     */     }
/* 555 */     argInvoiceLineItemProperty.setOrganizationId(getOrganizationId());
/* 556 */     argInvoiceLineItemProperty.setServiceLocationId(getServiceLocationId());
/* 557 */     argInvoiceLineItemProperty.setInvoiceNumber(getInvoiceNumber());
/* 558 */     argInvoiceLineItemProperty.setInvoiceLineItemSequence(getInvoiceLineItemSequence());
/* 559 */     if (argInvoiceLineItemProperty instanceof IDataModelImpl) {
/* 560 */       IDataAccessObject childDao = ((IDataModelImpl)argInvoiceLineItemProperty).getDAO();
/* 561 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 562 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 563 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 568 */     if (postEventsForChanges()) {
/* 569 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceLineItemProperty));
/*     */     }
/*     */     
/* 572 */     this._properties.add(argInvoiceLineItemProperty);
/* 573 */     if (postEventsForChanges()) {
/* 574 */       this._events.post(IInvoiceLineItem.ADD_PROPERTIES, argInvoiceLineItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInvoiceLineItemProperty(IInvoiceLineItemProperty argInvoiceLineItemProperty) {
/* 579 */     if (this._properties != null) {
/*     */       
/* 581 */       if (postEventsForChanges()) {
/* 582 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceLineItemProperty));
/*     */       }
/* 584 */       this._properties.remove(argInvoiceLineItemProperty);
/* 585 */       if (postEventsForChanges()) {
/* 586 */         this._events.post(IInvoiceLineItem.REMOVE_PROPERTIES, argInvoiceLineItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentInvoice(IInvoice argParentInvoice) {
/* 592 */     this._parentInvoice = argParentInvoice;
/*     */   }
/*     */   
/*     */   public IInvoice getParentInvoice() {
/* 596 */     return this._parentInvoice;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 601 */     if ("Properties".equals(argFieldId)) {
/* 602 */       return getProperties();
/*     */     }
/* 604 */     if ("InvoiceLineItemExtension".equals(argFieldId)) {
/* 605 */       return this._myExtension;
/*     */     }
/*     */     
/* 608 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 614 */     if ("Properties".equals(argFieldId)) {
/* 615 */       setProperties(changeToList(argValue, IInvoiceLineItemProperty.class));
/*     */     }
/* 617 */     else if ("InvoiceLineItemExtension".equals(argFieldId)) {
/* 618 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 621 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 627 */     this._persistenceDefaults = argPD;
/* 628 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 629 */     this._eventManager = argEM;
/* 630 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 631 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 632 */     if (this._properties != null) {
/* 633 */       for (IInvoiceLineItemProperty relationship : this._properties) {
/* 634 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInvoiceLineItemExt() {
/* 640 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInvoiceLineItemExt(IDataModel argExt) {
/* 644 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 649 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 653 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 656 */     super.startTransaction();
/*     */     
/* 658 */     this._propertiesSavepoint = this._properties;
/* 659 */     if (this._properties != null) {
/* 660 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 661 */       Iterator<IDataModel> it = this._properties.iterator();
/* 662 */       while (it.hasNext()) {
/* 663 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 668 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 673 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 676 */     super.rollbackChanges();
/*     */     
/* 678 */     this._properties = this._propertiesSavepoint;
/* 679 */     this._propertiesSavepoint = null;
/* 680 */     if (this._properties != null) {
/* 681 */       Iterator<IDataModel> it = this._properties.iterator();
/* 682 */       while (it.hasNext()) {
/* 683 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 691 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 694 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 697 */     super.commitTransaction();
/*     */     
/* 699 */     this._propertiesSavepoint = this._properties;
/* 700 */     if (this._properties != null) {
/* 701 */       Iterator<IDataModel> it = this._properties.iterator();
/* 702 */       while (it.hasNext()) {
/* 703 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 705 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 709 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 714 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */