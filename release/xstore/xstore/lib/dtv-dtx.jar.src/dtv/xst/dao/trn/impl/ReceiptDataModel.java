/*     */ package dtv.xst.dao.trn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.trn.IReceiptData;
/*     */ import dtv.xst.dao.trn.IReceiptDataProperty;
/*     */ import dtv.xst.dao.trn.ReceiptDataPropertyId;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class ReceiptDataModel extends AbstractDataModelWithPropertyImpl<IReceiptDataProperty> implements IReceiptData {
/*     */   private static final long serialVersionUID = -593976862L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private HistoricalList<IReceiptDataProperty> _properties; private transient HistoricalList<IReceiptDataProperty> _propertiesSavepoint; private static final byte VERSION = 0; private static final String ENCODING = "UTF-8";
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new ReceiptDataDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReceiptDataDAO getDAO_() {
/*  46 */     return (ReceiptDataDAO)this._daoImpl;
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
/*  70 */       this._events.post(IReceiptData.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<ReceiptDataPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((ReceiptDataPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 101 */     if (getDAO_().getRetailLocationId() != null) {
/* 102 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 105 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 115 */       this._events != null && 
/* 116 */       postEventsForChanges()) {
/* 117 */       this._events.post(IReceiptData.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 124 */     boolean ev_postable = false;
/*     */     
/* 126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 129 */       ev_postable = true;
/* 130 */       if (this._properties != null) {
/*     */         
/* 132 */         Iterator<ReceiptDataPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((ReceiptDataPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public long getWorkstationId() {
/* 148 */     if (getDAO_().getWorkstationId() != null) {
/* 149 */       return getDAO_().getWorkstationId().longValue();
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
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 161 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 162 */       this._events != null && 
/* 163 */       postEventsForChanges()) {
/* 164 */       this._events.post(IReceiptData.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 171 */     boolean ev_postable = false;
/*     */     
/* 173 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 174 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 175 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 176 */       ev_postable = true;
/* 177 */       if (this._properties != null) {
/*     */         
/* 179 */         Iterator<ReceiptDataPropertyModel> it = this._properties.iterator();
/* 180 */         while (it.hasNext())
/*     */         {
/* 182 */           ((ReceiptDataPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*     */   public Date getBusinessDate() {
/* 195 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 203 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(IReceiptData.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 216 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 217 */       getDAO_().setBusinessDate(argBusinessDate);
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<ReceiptDataPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((ReceiptDataPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 237 */     if (getDAO_().getTransactionSequence() != null) {
/* 238 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IReceiptData.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<ReceiptDataPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((ReceiptDataPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public String getReceiptId() {
/* 284 */     return getDAO_().getReceiptId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReceiptId(String argReceiptId) {
/* 292 */     if (setReceiptId_noev(argReceiptId) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(IReceiptData.SET_RECEIPTID, argReceiptId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReceiptId_noev(String argReceiptId) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getReceiptId() == null && argReceiptId != null) || (
/* 305 */       getDAO_().getReceiptId() != null && !getDAO_().getReceiptId().equals(argReceiptId))) {
/* 306 */       getDAO_().setReceiptId(argReceiptId);
/* 307 */       ev_postable = true;
/* 308 */       if (this._properties != null) {
/*     */         
/* 310 */         Iterator<ReceiptDataPropertyModel> it = this._properties.iterator();
/* 311 */         while (it.hasNext())
/*     */         {
/* 313 */           ((ReceiptDataPropertyModel)it.next()).setReceiptId_noev(argReceiptId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 326 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 334 */     if (setCreateDate_noev(argCreateDate) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IReceiptData.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 347 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 348 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 360 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 368 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IReceiptData.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 381 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 382 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 394 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 402 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IReceiptData.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 415 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 416 */       getDAO_().setUpdateDate(argUpdateDate);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 428 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 436 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IReceiptData.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 449 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 450 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getReceiptData() {
/* 462 */     return getDAO_().getReceiptData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReceiptData(Object argReceiptData) {
/* 470 */     if (setReceiptData_noev(argReceiptData) && 
/* 471 */       this._events != null && 
/* 472 */       postEventsForChanges()) {
/* 473 */       this._events.post(IReceiptData.SET_RECEIPTDATA, argReceiptData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setReceiptData_noev(Object argReceiptData) {
/* 480 */     boolean ev_postable = false;
/*     */     
/* 482 */     if ((getDAO_().getReceiptData() == null && argReceiptData != null) || (
/* 483 */       getDAO_().getReceiptData() != null && !getDAO_().getReceiptData().equals(argReceiptData))) {
/* 484 */       getDAO_().setReceiptData(argReceiptData);
/* 485 */       ev_postable = true;
/*     */     } 
/*     */     
/* 488 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IReceiptDataProperty newProperty(String argPropertyName) {
/* 492 */     ReceiptDataPropertyId id = new ReceiptDataPropertyId();
/*     */     
/* 494 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 495 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 496 */     id.setBusinessDate(getBusinessDate());
/* 497 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 498 */     id.setReceiptId(getReceiptId());
/* 499 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 501 */     IReceiptDataProperty prop = (IReceiptDataProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IReceiptDataProperty.class);
/* 502 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IReceiptDataProperty> getProperties() {
/* 511 */     if (this._properties == null) {
/* 512 */       this._properties = new HistoricalList(null);
/*     */     }
/* 514 */     return (List<IReceiptDataProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IReceiptDataProperty> argProperties) {
/* 518 */     if (this._properties == null) {
/* 519 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 521 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 524 */     for (IReceiptDataProperty child : this._properties) {
/* 525 */       ReceiptDataPropertyModel model = (ReceiptDataPropertyModel)child;
/* 526 */       model.setOrganizationId_noev(getOrganizationId());
/* 527 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 528 */       model.setWorkstationId_noev(getWorkstationId());
/* 529 */       model.setBusinessDate_noev(getBusinessDate());
/* 530 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 531 */       model.setReceiptId_noev(getReceiptId());
/* 532 */       if (child instanceof IDataModelImpl) {
/* 533 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 534 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 535 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 536 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 539 */       if (postEventsForChanges()) {
/* 540 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addReceiptDataProperty(IReceiptDataProperty argReceiptDataProperty) {
/* 546 */     if (this._properties == null) {
/* 547 */       this._properties = new HistoricalList(null);
/*     */     }
/* 549 */     argReceiptDataProperty.setOrganizationId(getOrganizationId());
/* 550 */     argReceiptDataProperty.setRetailLocationId(getRetailLocationId());
/* 551 */     argReceiptDataProperty.setWorkstationId(getWorkstationId());
/* 552 */     argReceiptDataProperty.setBusinessDate(getBusinessDate());
/* 553 */     argReceiptDataProperty.setTransactionSequence(getTransactionSequence());
/* 554 */     argReceiptDataProperty.setReceiptId(getReceiptId());
/* 555 */     if (argReceiptDataProperty instanceof IDataModelImpl) {
/* 556 */       IDataAccessObject childDao = ((IDataModelImpl)argReceiptDataProperty).getDAO();
/* 557 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 558 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 559 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 564 */     if (postEventsForChanges()) {
/* 565 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReceiptDataProperty));
/*     */     }
/*     */     
/* 568 */     this._properties.add(argReceiptDataProperty);
/* 569 */     if (postEventsForChanges()) {
/* 570 */       this._events.post(IReceiptData.ADD_PROPERTIES, argReceiptDataProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeReceiptDataProperty(IReceiptDataProperty argReceiptDataProperty) {
/* 575 */     if (this._properties != null) {
/*     */       
/* 577 */       if (postEventsForChanges()) {
/* 578 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReceiptDataProperty));
/*     */       }
/* 580 */       this._properties.remove(argReceiptDataProperty);
/* 581 */       if (postEventsForChanges()) {
/* 582 */         this._events.post(IReceiptData.REMOVE_PROPERTIES, argReceiptDataProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 589 */     if ("Properties".equals(argFieldId)) {
/* 590 */       return getProperties();
/*     */     }
/* 592 */     if ("ReceiptDataExtension".equals(argFieldId)) {
/* 593 */       return this._myExtension;
/*     */     }
/*     */     
/* 596 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 602 */     if ("Properties".equals(argFieldId)) {
/* 603 */       setProperties(changeToList(argValue, IReceiptDataProperty.class));
/*     */     }
/* 605 */     else if ("ReceiptDataExtension".equals(argFieldId)) {
/* 606 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 609 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 615 */     this._persistenceDefaults = argPD;
/* 616 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 617 */     this._eventManager = argEM;
/* 618 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 619 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 620 */     if (this._properties != null) {
/* 621 */       for (IReceiptDataProperty relationship : this._properties) {
/* 622 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getReceiptDataExt() {
/* 628 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setReceiptDataExt(IDataModel argExt) {
/* 632 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 637 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 641 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 644 */     super.startTransaction();
/*     */     
/* 646 */     this._propertiesSavepoint = this._properties;
/* 647 */     if (this._properties != null) {
/* 648 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 649 */       Iterator<IDataModel> it = this._properties.iterator();
/* 650 */       while (it.hasNext()) {
/* 651 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 656 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 661 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 664 */     super.rollbackChanges();
/*     */     
/* 666 */     this._properties = this._propertiesSavepoint;
/* 667 */     this._propertiesSavepoint = null;
/* 668 */     if (this._properties != null) {
/* 669 */       Iterator<IDataModel> it = this._properties.iterator();
/* 670 */       while (it.hasNext()) {
/* 671 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 679 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 682 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 685 */     super.commitTransaction();
/*     */     
/* 687 */     this._propertiesSavepoint = this._properties;
/* 688 */     if (this._properties != null) {
/* 689 */       Iterator<IDataModel> it = this._properties.iterator();
/* 690 */       while (it.hasNext()) {
/* 691 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 693 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 697 */     this._alreadyInCommit = false;
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
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 714 */     out.writeByte(0);
/* 715 */     writeDate(out, getCreateDate());
/* 716 */     writeString(out, getCreateUserId());
/* 717 */     writeDate(out, getUpdateDate());
/* 718 */     writeString(out, getUpdateUserId());
/* 719 */     out.writeLong(getOrganizationId());
/* 720 */     out.writeLong(getRetailLocationId());
/* 721 */     out.writeLong(getWorkstationId());
/* 722 */     writeDate(out, getBusinessDate());
/* 723 */     out.writeLong(getTransactionSequence());
/* 724 */     writeString(out, getReceiptId());
/*     */     
/* 726 */     byte[] buf = getReceiptBytes();
/* 727 */     if (buf == null) {
/* 728 */       out.writeInt(-1);
/*     */     } else {
/*     */       
/* 731 */       out.writeInt(buf.length);
/* 732 */       out.write(buf);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException {
/* 742 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */     
/* 744 */     byte version = in.readByte();
/* 745 */     if (version != 0) {
/* 746 */       Logger.getLogger(getClass())
/* 747 */         .warn("expected version=" + (new Integer(0)).toString() + ", actual=" + (new Integer(version))
/* 748 */           .toString());
/*     */     }
/* 750 */     setCreateDate(readDate(in));
/* 751 */     setCreateUserId(readString(in));
/* 752 */     setUpdateDate(readDate(in));
/* 753 */     setUpdateUserId(readString(in));
/* 754 */     setOrganizationId(in.readLong());
/* 755 */     setRetailLocationId(in.readLong());
/* 756 */     setWorkstationId(in.readLong());
/* 757 */     setBusinessDate(readDate(in));
/* 758 */     setTransactionSequence(in.readLong());
/* 759 */     setReceiptId(readString(in));
/* 760 */     int rcptSize = in.readInt();
/* 761 */     if (rcptSize > -1) {
/* 762 */       byte[] buf = new byte[rcptSize];
/* 763 */       (new DataInputStream(in)).readFully(buf);
/* 764 */       setReceiptBytes(buf);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void writeDate(ObjectOutputStream out, Date argDate) throws IOException {
/* 772 */     if (argDate == null) {
/* 773 */       out.writeLong(Long.MIN_VALUE);
/*     */     } else {
/*     */       
/* 776 */       out.writeLong(argDate.getTime());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Date readDate(ObjectInputStream in) throws IOException {
/* 783 */     long time = in.readLong();
/* 784 */     if (time == Long.MIN_VALUE) {
/* 785 */       return null;
/*     */     }
/* 787 */     return new Date(time);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void writeString(ObjectOutputStream out, String argString) throws IOException {
/* 794 */     if (argString == null) {
/* 795 */       out.writeInt(-1);
/*     */     } else {
/*     */       
/* 798 */       byte[] buf = argString.getBytes("UTF-8");
/* 799 */       out.writeInt(buf.length);
/* 800 */       out.write(buf);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String readString(ObjectInputStream in) throws IOException {
/* 807 */     int size = in.readInt();
/* 808 */     if (size < 0) {
/* 809 */       return null;
/*     */     }
/* 811 */     byte[] buf = new byte[size];
/* 812 */     in.read(buf);
/* 813 */     return new String(buf, "UTF-8");
/*     */   }
/*     */   
/*     */   public byte[] getReceiptBytes() {
/* 817 */     if (getReceiptData() == null) {
/* 818 */       return null;
/*     */     }
/*     */     try {
/* 821 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 822 */       ObjectOutputStream oos = new ObjectOutputStream(baos);
/* 823 */       oos.writeObject(getReceiptData());
/* 824 */       return baos.toByteArray();
/*     */     }
/* 826 */     catch (Throwable ex) {
/* 827 */       Logger.getLogger(getClass())
/* 828 */         .error("CAUGHT EXCEPTION getting receipt bytes", ex);
/* 829 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setReceiptBytes(byte[] argBytes) {
/*     */     try {
/* 835 */       ByteArrayInputStream bais = new ByteArrayInputStream(argBytes);
/* 836 */       ObjectInputStream ois = new ObjectInputStream(bais);
/* 837 */       Object o = ois.readObject();
/* 838 */       setReceiptData(o);
/*     */     }
/* 840 */     catch (Throwable ex) {
/* 841 */       Logger.getLogger(getClass())
/* 842 */         .error("CAUGHT EXCEPTION setting receipt bytes", ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\ReceiptDataModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */