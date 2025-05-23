/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import dtv.xst.dao.trl.IInventoryDocumentModifier;
/*     */ import dtv.xst.dao.trl.IInventoryDocumentModifierProperty;
/*     */ import dtv.xst.dao.trl.InventoryDocumentModifierPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryDocumentModifierModel extends AbstractDataModelWithPropertyImpl<IInventoryDocumentModifierProperty> implements IInventoryDocumentModifier {
/*     */   private static final long serialVersionUID = -1151176082L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IInventoryDocument _inventoryDocument; private transient IInventoryDocument _inventoryDocumentSavepoint; private HistoricalList<IInventoryDocumentModifierProperty> _properties; private transient HistoricalList<IInventoryDocumentModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new InventoryDocumentModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InventoryDocumentModifierDAO getDAO_() {
/*  47 */     return (InventoryDocumentModifierDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  55 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  63 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  64 */       this._events != null && 
/*  65 */       postEventsForChanges()) {
/*  66 */       this._events.post(IInventoryDocumentModifier.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  73 */     boolean ev_postable = false;
/*     */     
/*  75 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  76 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  77 */       getDAO_().setBusinessDate(argBusinessDate);
/*  78 */       ev_postable = true;
/*  79 */       if (this._properties != null) {
/*     */         
/*  81 */         Iterator<InventoryDocumentModifierPropertyModel> it = this._properties.iterator();
/*  82 */         while (it.hasNext())
/*     */         {
/*  84 */           ((InventoryDocumentModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDocumentModifierSequence() {
/*  97 */     if (getDAO_().getDocumentModifierSequence() != null) {
/*  98 */       return getDAO_().getDocumentModifierSequence().intValue();
/*     */     }
/*     */     
/* 101 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentModifierSequence(int argDocumentModifierSequence) {
/* 110 */     if (setDocumentModifierSequence_noev(argDocumentModifierSequence) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(IInventoryDocumentModifier.SET_DOCUMENTMODIFIERSEQUENCE, Integer.valueOf(argDocumentModifierSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentModifierSequence_noev(int argDocumentModifierSequence) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getDocumentModifierSequence() == null && Integer.valueOf(argDocumentModifierSequence) != null) || (
/* 123 */       getDAO_().getDocumentModifierSequence() != null && !getDAO_().getDocumentModifierSequence().equals(Integer.valueOf(argDocumentModifierSequence)))) {
/* 124 */       getDAO_().setDocumentModifierSequence(Integer.valueOf(argDocumentModifierSequence));
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<InventoryDocumentModifierPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((InventoryDocumentModifierPropertyModel)it.next()).setDocumentModifierSequence_noev(argDocumentModifierSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 144 */     if (getDAO_().getOrganizationId() != null) {
/* 145 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 148 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 157 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IInventoryDocumentModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 170 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 171 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<InventoryDocumentModifierPropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((InventoryDocumentModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 191 */     if (getDAO_().getRetailLocationId() != null) {
/* 192 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 195 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 204 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 205 */       this._events != null && 
/* 206 */       postEventsForChanges()) {
/* 207 */       this._events.post(IInventoryDocumentModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 214 */     boolean ev_postable = false;
/*     */     
/* 216 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 217 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 218 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 219 */       ev_postable = true;
/* 220 */       if (this._properties != null) {
/*     */         
/* 222 */         Iterator<InventoryDocumentModifierPropertyModel> it = this._properties.iterator();
/* 223 */         while (it.hasNext())
/*     */         {
/* 225 */           ((InventoryDocumentModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 238 */     if (getDAO_().getTransactionSequence() != null) {
/* 239 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 242 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 251 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 252 */       this._events != null && 
/* 253 */       postEventsForChanges()) {
/* 254 */       this._events.post(IInventoryDocumentModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 261 */     boolean ev_postable = false;
/*     */     
/* 263 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 264 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 265 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 266 */       ev_postable = true;
/* 267 */       if (this._properties != null) {
/*     */         
/* 269 */         Iterator<InventoryDocumentModifierPropertyModel> it = this._properties.iterator();
/* 270 */         while (it.hasNext())
/*     */         {
/* 272 */           ((InventoryDocumentModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 285 */     if (getDAO_().getWorkstationId() != null) {
/* 286 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 289 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 298 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 299 */       this._events != null && 
/* 300 */       postEventsForChanges()) {
/* 301 */       this._events.post(IInventoryDocumentModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 308 */     boolean ev_postable = false;
/*     */     
/* 310 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 311 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 312 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 313 */       ev_postable = true;
/* 314 */       if (this._properties != null) {
/*     */         
/* 316 */         Iterator<InventoryDocumentModifierPropertyModel> it = this._properties.iterator();
/* 317 */         while (it.hasNext())
/*     */         {
/* 319 */           ((InventoryDocumentModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 332 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 340 */     if (setCreateDate_noev(argCreateDate) && 
/* 341 */       this._events != null && 
/* 342 */       postEventsForChanges()) {
/* 343 */       this._events.post(IInventoryDocumentModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 350 */     boolean ev_postable = false;
/*     */     
/* 352 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 353 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 354 */       getDAO_().setCreateDate(argCreateDate);
/* 355 */       ev_postable = true;
/*     */     } 
/*     */     
/* 358 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 366 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 374 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 375 */       this._events != null && 
/* 376 */       postEventsForChanges()) {
/* 377 */       this._events.post(IInventoryDocumentModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 384 */     boolean ev_postable = false;
/*     */     
/* 386 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 387 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 388 */       getDAO_().setCreateUserId(argCreateUserId);
/* 389 */       ev_postable = true;
/*     */     } 
/*     */     
/* 392 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 400 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 408 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 409 */       this._events != null && 
/* 410 */       postEventsForChanges()) {
/* 411 */       this._events.post(IInventoryDocumentModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 418 */     boolean ev_postable = false;
/*     */     
/* 420 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 421 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 422 */       getDAO_().setUpdateDate(argUpdateDate);
/* 423 */       ev_postable = true;
/*     */     } 
/*     */     
/* 426 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 434 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 442 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 443 */       this._events != null && 
/* 444 */       postEventsForChanges()) {
/* 445 */       this._events.post(IInventoryDocumentModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 452 */     boolean ev_postable = false;
/*     */     
/* 454 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 455 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 456 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 457 */       ev_postable = true;
/*     */     } 
/*     */     
/* 460 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/* 468 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 476 */     if (setDocumentId_noev(argDocumentId) && 
/* 477 */       this._events != null && 
/* 478 */       postEventsForChanges()) {
/* 479 */       this._events.post(IInventoryDocumentModifier.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 486 */     boolean ev_postable = false;
/*     */     
/* 488 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 489 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 490 */       getDAO_().setDocumentId(argDocumentId);
/* 491 */       ev_postable = true;
/*     */     } 
/*     */     
/* 494 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 502 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 510 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 511 */       this._events != null && 
/* 512 */       postEventsForChanges()) {
/* 513 */       this._events.post(IInventoryDocumentModifier.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 520 */     boolean ev_postable = false;
/*     */     
/* 522 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 523 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 524 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 525 */       ev_postable = true;
/*     */     } 
/*     */     
/* 528 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IInventoryDocumentModifierProperty newProperty(String argPropertyName) {
/* 532 */     InventoryDocumentModifierPropertyId id = new InventoryDocumentModifierPropertyId();
/*     */     
/* 534 */     id.setBusinessDate(getBusinessDate());
/* 535 */     id.setDocumentModifierSequence(Integer.valueOf(getDocumentModifierSequence()));
/* 536 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 537 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 538 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 539 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 541 */     IInventoryDocumentModifierProperty prop = (IInventoryDocumentModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryDocumentModifierProperty.class);
/* 542 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "InventoryDocument")
/*     */   public IInventoryDocument getInventoryDocument() {
/* 554 */     return this._inventoryDocument;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInventoryDocument(IInventoryDocument argInventoryDocument) {
/* 559 */     if (argInventoryDocument == null) {
/*     */       
/* 561 */       getDAO_().setDocumentId(null);
/* 562 */       getDAO_().setDocumentTypeCode(null);
/* 563 */       if (this._inventoryDocument != null)
/*     */       {
/* 565 */         if (postEventsForChanges()) {
/* 566 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryDocument));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 571 */       getDAO_().setDocumentId(argInventoryDocument.getDocumentId());
/* 572 */       getDAO_().setDocumentTypeCode(argInventoryDocument.getDocumentTypeCode());
/*     */       
/* 574 */       if (postEventsForChanges()) {
/* 575 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocument));
/*     */       }
/*     */     } 
/*     */     
/* 579 */     this._inventoryDocument = argInventoryDocument;
/* 580 */     if (postEventsForChanges()) {
/* 581 */       this._events.post(IInventoryDocumentModifier.SET_INVENTORYDOCUMENT, argInventoryDocument);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IInventoryDocumentModifierProperty> getProperties() {
/* 587 */     if (this._properties == null) {
/* 588 */       this._properties = new HistoricalList(null);
/*     */     }
/* 590 */     return (List<IInventoryDocumentModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IInventoryDocumentModifierProperty> argProperties) {
/* 594 */     if (this._properties == null) {
/* 595 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 597 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 600 */     for (IInventoryDocumentModifierProperty child : this._properties) {
/* 601 */       InventoryDocumentModifierPropertyModel model = (InventoryDocumentModifierPropertyModel)child;
/* 602 */       model.setBusinessDate_noev(getBusinessDate());
/* 603 */       model.setDocumentModifierSequence_noev(getDocumentModifierSequence());
/* 604 */       model.setOrganizationId_noev(getOrganizationId());
/* 605 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 606 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 607 */       model.setWorkstationId_noev(getWorkstationId());
/* 608 */       if (child instanceof IDataModelImpl) {
/* 609 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 610 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 611 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 612 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 615 */       if (postEventsForChanges()) {
/* 616 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInventoryDocumentModifierProperty(IInventoryDocumentModifierProperty argInventoryDocumentModifierProperty) {
/* 622 */     if (this._properties == null) {
/* 623 */       this._properties = new HistoricalList(null);
/*     */     }
/* 625 */     argInventoryDocumentModifierProperty.setBusinessDate(getBusinessDate());
/* 626 */     argInventoryDocumentModifierProperty.setDocumentModifierSequence(getDocumentModifierSequence());
/* 627 */     argInventoryDocumentModifierProperty.setOrganizationId(getOrganizationId());
/* 628 */     argInventoryDocumentModifierProperty.setRetailLocationId(getRetailLocationId());
/* 629 */     argInventoryDocumentModifierProperty.setTransactionSequence(getTransactionSequence());
/* 630 */     argInventoryDocumentModifierProperty.setWorkstationId(getWorkstationId());
/* 631 */     if (argInventoryDocumentModifierProperty instanceof IDataModelImpl) {
/* 632 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentModifierProperty).getDAO();
/* 633 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 634 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 635 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 640 */     if (postEventsForChanges()) {
/* 641 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentModifierProperty));
/*     */     }
/*     */     
/* 644 */     this._properties.add(argInventoryDocumentModifierProperty);
/* 645 */     if (postEventsForChanges()) {
/* 646 */       this._events.post(IInventoryDocumentModifier.ADD_PROPERTIES, argInventoryDocumentModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeInventoryDocumentModifierProperty(IInventoryDocumentModifierProperty argInventoryDocumentModifierProperty) {
/* 651 */     if (this._properties != null) {
/*     */       
/* 653 */       if (postEventsForChanges()) {
/* 654 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentModifierProperty));
/*     */       }
/* 656 */       this._properties.remove(argInventoryDocumentModifierProperty);
/* 657 */       if (postEventsForChanges()) {
/* 658 */         this._events.post(IInventoryDocumentModifier.REMOVE_PROPERTIES, argInventoryDocumentModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 665 */     if ("InventoryDocument".equals(argFieldId)) {
/* 666 */       return getInventoryDocument();
/*     */     }
/* 668 */     if ("Properties".equals(argFieldId)) {
/* 669 */       return getProperties();
/*     */     }
/* 671 */     if ("InventoryDocumentModifierExtension".equals(argFieldId)) {
/* 672 */       return this._myExtension;
/*     */     }
/*     */     
/* 675 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 681 */     if ("InventoryDocument".equals(argFieldId)) {
/* 682 */       setInventoryDocument((IInventoryDocument)argValue);
/*     */     }
/* 684 */     else if ("Properties".equals(argFieldId)) {
/* 685 */       setProperties(changeToList(argValue, IInventoryDocumentModifierProperty.class));
/*     */     }
/* 687 */     else if ("InventoryDocumentModifierExtension".equals(argFieldId)) {
/* 688 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 691 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 697 */     this._persistenceDefaults = argPD;
/* 698 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 699 */     this._eventManager = argEM;
/* 700 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 701 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 702 */     if (this._inventoryDocument != null) {
/* 703 */       ((IDataModelImpl)this._inventoryDocument).setDependencies(argPD, argEM);
/*     */     }
/* 705 */     if (this._properties != null) {
/* 706 */       for (IInventoryDocumentModifierProperty relationship : this._properties) {
/* 707 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getInventoryDocumentModifierExt() {
/* 713 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setInventoryDocumentModifierExt(IDataModel argExt) {
/* 717 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 722 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 726 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 729 */     super.startTransaction();
/*     */     
/* 731 */     this._inventoryDocumentSavepoint = this._inventoryDocument;
/* 732 */     if (this._inventoryDocument != null) {
/* 733 */       this._inventoryDocument.startTransaction();
/*     */     }
/*     */     
/* 736 */     this._propertiesSavepoint = this._properties;
/* 737 */     if (this._properties != null) {
/* 738 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 739 */       Iterator<IDataModel> it = this._properties.iterator();
/* 740 */       while (it.hasNext()) {
/* 741 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 746 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 751 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 754 */     super.rollbackChanges();
/*     */     
/* 756 */     this._inventoryDocument = this._inventoryDocumentSavepoint;
/* 757 */     this._inventoryDocumentSavepoint = null;
/* 758 */     if (this._inventoryDocument != null) {
/* 759 */       this._inventoryDocument.rollbackChanges();
/*     */     }
/*     */     
/* 762 */     this._properties = this._propertiesSavepoint;
/* 763 */     this._propertiesSavepoint = null;
/* 764 */     if (this._properties != null) {
/* 765 */       Iterator<IDataModel> it = this._properties.iterator();
/* 766 */       while (it.hasNext()) {
/* 767 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 775 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 778 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 781 */     super.commitTransaction();
/*     */     
/* 783 */     this._inventoryDocumentSavepoint = this._inventoryDocument;
/* 784 */     if (this._inventoryDocument != null) {
/* 785 */       this._inventoryDocument.commitTransaction();
/*     */     }
/*     */     
/* 788 */     this._propertiesSavepoint = this._properties;
/* 789 */     if (this._properties != null) {
/* 790 */       Iterator<IDataModel> it = this._properties.iterator();
/* 791 */       while (it.hasNext()) {
/* 792 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 794 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 798 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 803 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\InventoryDocumentModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */