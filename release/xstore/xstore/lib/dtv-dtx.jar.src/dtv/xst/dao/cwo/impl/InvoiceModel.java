/*     */ package dtv.xst.dao.cwo.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cwo.IInvoice;
/*     */ import dtv.xst.dao.cwo.IInvoiceLineItem;
/*     */ import dtv.xst.dao.cwo.IInvoiceProperty;
/*     */ import dtv.xst.dao.cwo.IServiceLocation;
/*     */ import dtv.xst.dao.cwo.InvoicePropertyId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InvoiceModel extends InvoiceBaseModel implements IInvoice {
/*     */   private static final long serialVersionUID = -670115059L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IServiceLocation _invoiceServiceLocation;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient IServiceLocation _invoiceServiceLocationSavepoint; private HistoricalList<IInvoiceLineItem> _lineItems; private transient HistoricalList<IInvoiceLineItem> _lineItemsSavepoint; private HistoricalList<IInvoiceProperty> _properties; private transient HistoricalList<IInvoiceProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new InvoiceDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InvoiceDAO getDAO_() {
/*  48 */     return (InvoiceDAO)this._daoImpl;
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
/*  72 */       this._events.post(IInvoice.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */       if (this._lineItems != null) {
/*     */         
/*  87 */         Iterator<InvoiceLineItemModel> it = this._lineItems.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((InvoiceLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*  93 */       if (this._properties != null) {
/*     */         
/*  95 */         Iterator<InvoicePropertyModel> it = this._properties.iterator();
/*  96 */         while (it.hasNext())
/*     */         {
/*  98 */           ((InvoicePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 103 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceLocationId() {
/* 111 */     return getDAO_().getServiceLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/* 119 */     if (setServiceLocationId_noev(argServiceLocationId) && 
/* 120 */       this._events != null && 
/* 121 */       postEventsForChanges()) {
/* 122 */       this._events.post(IInvoice.SET_SERVICELOCATIONID, argServiceLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setServiceLocationId_noev(String argServiceLocationId) {
/* 129 */     boolean ev_postable = false;
/*     */     
/* 131 */     if ((getDAO_().getServiceLocationId() == null && argServiceLocationId != null) || (
/* 132 */       getDAO_().getServiceLocationId() != null && !getDAO_().getServiceLocationId().equals(argServiceLocationId))) {
/* 133 */       getDAO_().setServiceLocationId(argServiceLocationId);
/* 134 */       ev_postable = true;
/* 135 */       if (this._lineItems != null) {
/*     */         
/* 137 */         Iterator<InvoiceLineItemModel> it = this._lineItems.iterator();
/* 138 */         while (it.hasNext())
/*     */         {
/* 140 */           ((InvoiceLineItemModel)it.next()).setServiceLocationId_noev(argServiceLocationId);
/*     */         }
/*     */       } 
/* 143 */       if (this._properties != null) {
/*     */         
/* 145 */         Iterator<InvoicePropertyModel> it = this._properties.iterator();
/* 146 */         while (it.hasNext())
/*     */         {
/* 148 */           ((InvoicePropertyModel)it.next()).setServiceLocationId_noev(argServiceLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInvoiceNumber() {
/* 161 */     return getDAO_().getInvoiceNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceNumber(String argInvoiceNumber) {
/* 169 */     if (setInvoiceNumber_noev(argInvoiceNumber) && 
/* 170 */       this._events != null && 
/* 171 */       postEventsForChanges()) {
/* 172 */       this._events.post(IInvoice.SET_INVOICENUMBER, argInvoiceNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceNumber_noev(String argInvoiceNumber) {
/* 179 */     boolean ev_postable = false;
/*     */     
/* 181 */     if ((getDAO_().getInvoiceNumber() == null && argInvoiceNumber != null) || (
/* 182 */       getDAO_().getInvoiceNumber() != null && !getDAO_().getInvoiceNumber().equals(argInvoiceNumber))) {
/* 183 */       getDAO_().setInvoiceNumber(argInvoiceNumber);
/* 184 */       ev_postable = true;
/* 185 */       if (this._lineItems != null) {
/*     */         
/* 187 */         Iterator<InvoiceLineItemModel> it = this._lineItems.iterator();
/* 188 */         while (it.hasNext())
/*     */         {
/* 190 */           ((InvoiceLineItemModel)it.next()).setInvoiceNumber_noev(argInvoiceNumber);
/*     */         }
/*     */       } 
/* 193 */       if (this._properties != null) {
/*     */         
/* 195 */         Iterator<InvoicePropertyModel> it = this._properties.iterator();
/* 196 */         while (it.hasNext())
/*     */         {
/* 198 */           ((InvoicePropertyModel)it.next()).setInvoiceNumber_noev(argInvoiceNumber);
/*     */         }
/*     */       } 
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
/* 222 */       this._events.post(IInvoice.SET_CREATEDATE, argCreateDate);
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
/* 256 */       this._events.post(IInvoice.SET_CREATEUSERID, argCreateUserId);
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
/* 290 */       this._events.post(IInvoice.SET_UPDATEDATE, argUpdateDate);
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
/* 324 */       this._events.post(IInvoice.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public Date getInvoiceDate() {
/* 347 */     return getDAO_().getInvoiceDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvoiceDate(Date argInvoiceDate) {
/* 355 */     if (setInvoiceDate_noev(argInvoiceDate) && 
/* 356 */       this._events != null && 
/* 357 */       postEventsForChanges()) {
/* 358 */       this._events.post(IInvoice.SET_INVOICEDATE, argInvoiceDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInvoiceDate_noev(Date argInvoiceDate) {
/* 365 */     boolean ev_postable = false;
/*     */     
/* 367 */     if ((getDAO_().getInvoiceDate() == null && argInvoiceDate != null) || (
/* 368 */       getDAO_().getInvoiceDate() != null && !getDAO_().getInvoiceDate().equals(argInvoiceDate))) {
/* 369 */       getDAO_().setInvoiceDate(argInvoiceDate);
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
/*     */   public BigDecimal getAmountDue() {
/* 381 */     return getDAO_().getAmountDue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmountDue(BigDecimal argAmountDue) {
/* 389 */     if (setAmountDue_noev(argAmountDue) && 
/* 390 */       this._events != null && 
/* 391 */       postEventsForChanges()) {
/* 392 */       this._events.post(IInvoice.SET_AMOUNTDUE, argAmountDue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmountDue_noev(BigDecimal argAmountDue) {
/* 399 */     boolean ev_postable = false;
/*     */     
/* 401 */     if ((getDAO_().getAmountDue() == null && argAmountDue != null) || (
/* 402 */       getDAO_().getAmountDue() != null && !getDAO_().getAmountDue().equals(argAmountDue))) {
/* 403 */       getDAO_().setAmountDue(argAmountDue);
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
/*     */   public String getNotes() {
/* 415 */     return getDAO_().getNotes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 423 */     if (setNotes_noev(argNotes) && 
/* 424 */       this._events != null && 
/* 425 */       postEventsForChanges()) {
/* 426 */       this._events.post(IInvoice.SET_NOTES, argNotes);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNotes_noev(String argNotes) {
/* 433 */     boolean ev_postable = false;
/*     */     
/* 435 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/* 436 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/* 437 */       getDAO_().setNotes(argNotes);
/* 438 */       ev_postable = true;
/*     */     } 
/*     */     
/* 441 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInvoiceProperty newProperty(String argPropertyName) {
/* 445 */     InvoicePropertyId id = new InvoicePropertyId();
/*     */     
/* 447 */     id.setServiceLocationId(getServiceLocationId());
/* 448 */     id.setInvoiceNumber(getInvoiceNumber());
/* 449 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 451 */     IInvoiceProperty prop = (IInvoiceProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInvoiceProperty.class);
/* 452 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "InvoiceServiceLocation")
/*     */   public IServiceLocation getInvoiceServiceLocation() {
/* 467 */     return this._invoiceServiceLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInvoiceServiceLocation(IServiceLocation argInvoiceServiceLocation) {
/* 472 */     if (argInvoiceServiceLocation == null) {
/*     */       
/* 474 */       if (this._invoiceServiceLocation != null) {
/* 475 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 478 */       if (this._invoiceServiceLocation != null)
/*     */       {
/* 480 */         if (postEventsForChanges()) {
/* 481 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._invoiceServiceLocation));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 487 */     else if (postEventsForChanges()) {
/* 488 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceServiceLocation));
/*     */     } 
/*     */ 
/*     */     
/* 492 */     this._invoiceServiceLocation = argInvoiceServiceLocation;
/* 493 */     if (postEventsForChanges()) {
/* 494 */       this._events.post(IInvoice.SET_INVOICESERVICELOCATION, argInvoiceServiceLocation);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "LineItems")
/*     */   public List<IInvoiceLineItem> getLineItems() {
/* 500 */     if (this._lineItems == null) {
/* 501 */       this._lineItems = new HistoricalList(null);
/*     */     }
/* 503 */     return (List<IInvoiceLineItem>)this._lineItems;
/*     */   }
/*     */   
/*     */   public void setLineItems(List<IInvoiceLineItem> argLineItems) {
/* 507 */     if (this._lineItems == null) {
/* 508 */       this._lineItems = new HistoricalList(argLineItems);
/*     */     } else {
/* 510 */       this._lineItems.setCurrentList(argLineItems);
/*     */     } 
/*     */     
/* 513 */     for (IInvoiceLineItem child : this._lineItems) {
/* 514 */       child.setParentInvoice(this);
/*     */     }
/*     */ 
/*     */     
/* 518 */     for (IInvoiceLineItem child : this._lineItems) {
/* 519 */       InvoiceLineItemModel model = (InvoiceLineItemModel)child;
/* 520 */       model.setOrganizationId_noev(getOrganizationId());
/* 521 */       model.setServiceLocationId_noev(getServiceLocationId());
/* 522 */       model.setInvoiceNumber_noev(getInvoiceNumber());
/* 523 */       if (child instanceof IDataModelImpl) {
/* 524 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 525 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 526 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 527 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 530 */       if (postEventsForChanges()) {
/* 531 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInvoiceLineItem(IInvoiceLineItem argInvoiceLineItem) {
/* 537 */     super.addInvoiceLineItem(argInvoiceLineItem);
/*     */ 
/*     */     
/* 540 */     argInvoiceLineItem.setParentInvoice(this);
/* 541 */     if (this._lineItems == null) {
/* 542 */       this._lineItems = new HistoricalList(null);
/*     */     }
/* 544 */     argInvoiceLineItem.setOrganizationId(getOrganizationId());
/* 545 */     argInvoiceLineItem.setServiceLocationId(getServiceLocationId());
/* 546 */     argInvoiceLineItem.setInvoiceNumber(getInvoiceNumber());
/* 547 */     if (argInvoiceLineItem instanceof IDataModelImpl) {
/* 548 */       IDataAccessObject childDao = ((IDataModelImpl)argInvoiceLineItem).getDAO();
/* 549 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 550 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 551 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 556 */     if (postEventsForChanges()) {
/* 557 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceLineItem));
/*     */     }
/*     */     
/* 560 */     this._lineItems.add(argInvoiceLineItem);
/* 561 */     if (postEventsForChanges()) {
/* 562 */       this._events.post(IInvoice.ADD_LINEITEMS, argInvoiceLineItem);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInvoiceLineItem(IInvoiceLineItem argInvoiceLineItem) {
/* 567 */     if (this._lineItems != null) {
/*     */       
/* 569 */       if (postEventsForChanges()) {
/* 570 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceLineItem));
/*     */       }
/* 572 */       this._lineItems.remove(argInvoiceLineItem);
/*     */       
/* 574 */       argInvoiceLineItem.setParentInvoice(null);
/* 575 */       if (postEventsForChanges()) {
/* 576 */         this._events.post(IInvoice.REMOVE_LINEITEMS, argInvoiceLineItem);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInvoiceProperty> getProperties() {
/* 583 */     if (this._properties == null) {
/* 584 */       this._properties = new HistoricalList(null);
/*     */     }
/* 586 */     return (List<IInvoiceProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInvoiceProperty> argProperties) {
/* 590 */     if (this._properties == null) {
/* 591 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 593 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 596 */     for (IInvoiceProperty child : this._properties) {
/* 597 */       InvoicePropertyModel model = (InvoicePropertyModel)child;
/* 598 */       model.setOrganizationId_noev(getOrganizationId());
/* 599 */       model.setServiceLocationId_noev(getServiceLocationId());
/* 600 */       model.setInvoiceNumber_noev(getInvoiceNumber());
/* 601 */       if (child instanceof IDataModelImpl) {
/* 602 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 603 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 604 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 605 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 608 */       if (postEventsForChanges()) {
/* 609 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInvoiceProperty(IInvoiceProperty argInvoiceProperty) {
/* 615 */     if (this._properties == null) {
/* 616 */       this._properties = new HistoricalList(null);
/*     */     }
/* 618 */     argInvoiceProperty.setOrganizationId(getOrganizationId());
/* 619 */     argInvoiceProperty.setServiceLocationId(getServiceLocationId());
/* 620 */     argInvoiceProperty.setInvoiceNumber(getInvoiceNumber());
/* 621 */     if (argInvoiceProperty instanceof IDataModelImpl) {
/* 622 */       IDataAccessObject childDao = ((IDataModelImpl)argInvoiceProperty).getDAO();
/* 623 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 624 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 625 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 630 */     if (postEventsForChanges()) {
/* 631 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceProperty));
/*     */     }
/*     */     
/* 634 */     this._properties.add(argInvoiceProperty);
/* 635 */     if (postEventsForChanges()) {
/* 636 */       this._events.post(IInvoice.ADD_PROPERTIES, argInvoiceProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInvoiceProperty(IInvoiceProperty argInvoiceProperty) {
/* 641 */     if (this._properties != null) {
/*     */       
/* 643 */       if (postEventsForChanges()) {
/* 644 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInvoiceProperty));
/*     */       }
/* 646 */       this._properties.remove(argInvoiceProperty);
/* 647 */       if (postEventsForChanges()) {
/* 648 */         this._events.post(IInvoice.REMOVE_PROPERTIES, argInvoiceProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 655 */     if ("InvoiceServiceLocation".equals(argFieldId)) {
/* 656 */       return getInvoiceServiceLocation();
/*     */     }
/* 658 */     if ("LineItems".equals(argFieldId)) {
/* 659 */       return getLineItems();
/*     */     }
/* 661 */     if ("Properties".equals(argFieldId)) {
/* 662 */       return getProperties();
/*     */     }
/* 664 */     if ("InvoiceExtension".equals(argFieldId)) {
/* 665 */       return this._myExtension;
/*     */     }
/*     */     
/* 668 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 674 */     if ("InvoiceServiceLocation".equals(argFieldId)) {
/* 675 */       setInvoiceServiceLocation((IServiceLocation)argValue);
/*     */     }
/* 677 */     else if ("LineItems".equals(argFieldId)) {
/* 678 */       setLineItems(changeToList(argValue, IInvoiceLineItem.class));
/*     */     }
/* 680 */     else if ("Properties".equals(argFieldId)) {
/* 681 */       setProperties(changeToList(argValue, IInvoiceProperty.class));
/*     */     }
/* 683 */     else if ("InvoiceExtension".equals(argFieldId)) {
/* 684 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 687 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 693 */     this._persistenceDefaults = argPD;
/* 694 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 695 */     this._eventManager = argEM;
/* 696 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 697 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 698 */     if (this._invoiceServiceLocation != null) {
/* 699 */       ((IDataModelImpl)this._invoiceServiceLocation).setDependencies(argPD, argEM);
/*     */     }
/* 701 */     if (this._lineItems != null) {
/* 702 */       for (IInvoiceLineItem relationship : this._lineItems) {
/* 703 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/* 706 */     if (this._properties != null) {
/* 707 */       for (IInvoiceProperty relationship : this._properties) {
/* 708 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInvoiceExt() {
/* 714 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInvoiceExt(IDataModel argExt) {
/* 718 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 723 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 727 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 730 */     super.startTransaction();
/*     */     
/* 732 */     this._invoiceServiceLocationSavepoint = this._invoiceServiceLocation;
/* 733 */     if (this._invoiceServiceLocation != null) {
/* 734 */       this._invoiceServiceLocation.startTransaction();
/*     */     }
/*     */     
/* 737 */     this._lineItemsSavepoint = this._lineItems;
/* 738 */     if (this._lineItems != null) {
/* 739 */       this._lineItemsSavepoint = new HistoricalList((List)this._lineItems);
/* 740 */       Iterator<IDataModel> it = this._lineItems.iterator();
/* 741 */       while (it.hasNext()) {
/* 742 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */     
/* 746 */     this._propertiesSavepoint = this._properties;
/* 747 */     if (this._properties != null) {
/* 748 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 749 */       Iterator<IDataModel> it = this._properties.iterator();
/* 750 */       while (it.hasNext()) {
/* 751 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 756 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 761 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 764 */     super.rollbackChanges();
/*     */     
/* 766 */     this._invoiceServiceLocation = this._invoiceServiceLocationSavepoint;
/* 767 */     this._invoiceServiceLocationSavepoint = null;
/* 768 */     if (this._invoiceServiceLocation != null) {
/* 769 */       this._invoiceServiceLocation.rollbackChanges();
/*     */     }
/*     */     
/* 772 */     this._lineItems = this._lineItemsSavepoint;
/* 773 */     this._lineItemsSavepoint = null;
/* 774 */     if (this._lineItems != null) {
/* 775 */       Iterator<IDataModel> it = this._lineItems.iterator();
/* 776 */       while (it.hasNext()) {
/* 777 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */     
/* 781 */     this._properties = this._propertiesSavepoint;
/* 782 */     this._propertiesSavepoint = null;
/* 783 */     if (this._properties != null) {
/* 784 */       Iterator<IDataModel> it = this._properties.iterator();
/* 785 */       while (it.hasNext()) {
/* 786 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 794 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 797 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 800 */     super.commitTransaction();
/*     */     
/* 802 */     this._invoiceServiceLocationSavepoint = this._invoiceServiceLocation;
/* 803 */     if (this._invoiceServiceLocation != null) {
/* 804 */       this._invoiceServiceLocation.commitTransaction();
/*     */     }
/*     */     
/* 807 */     this._lineItemsSavepoint = this._lineItems;
/* 808 */     if (this._lineItems != null) {
/* 809 */       Iterator<IDataModel> it = this._lineItems.iterator();
/* 810 */       while (it.hasNext()) {
/* 811 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 813 */       this._lineItems = new HistoricalList((List)this._lineItems);
/*     */     } 
/*     */     
/* 816 */     this._propertiesSavepoint = this._properties;
/* 817 */     if (this._properties != null) {
/* 818 */       Iterator<IDataModel> it = this._properties.iterator();
/* 819 */       while (it.hasNext()) {
/* 820 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 822 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 826 */     this._alreadyInCommit = false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */