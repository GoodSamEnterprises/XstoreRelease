/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.ITransactionVersion;
/*     */ import dtv.xst.dao.trn.ITransactionVersionProperty;
/*     */ import dtv.xst.dao.trn.TransactionVersionPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TransactionVersionModel extends AbstractDataModelWithPropertyImpl<ITransactionVersionProperty> implements ITransactionVersion {
/*     */   private static final long serialVersionUID = 1583695930L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITransactionVersionProperty> _properties; private transient HistoricalList<ITransactionVersionProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TransactionVersionDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TransactionVersionDAO getDAO_() {
/*  46 */     return (TransactionVersionDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITransactionVersion.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TransactionVersionPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TransactionVersionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 117 */       this._events.post(ITransactionVersion.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 132 */         Iterator<TransactionVersionPropertyModel> it = this._properties.iterator();
/* 133 */         while (it.hasNext())
/*     */         {
/* 135 */           ((TransactionVersionPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public Date getBusinessDate() {
/* 148 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 156 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ITransactionVersion.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 169 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 170 */       getDAO_().setBusinessDate(argBusinessDate);
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<TransactionVersionPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((TransactionVersionPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getWorkstationId() {
/* 190 */     if (getDAO_().getWorkstationId() != null) {
/* 191 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 194 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 203 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ITransactionVersion.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 216 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 217 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<TransactionVersionPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((TransactionVersionPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/* 253 */       this._events.post(ITransactionVersion.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/* 268 */         Iterator<TransactionVersionPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((TransactionVersionPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*     */   public Date getCreateDate() {
/* 284 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 292 */     if (setCreateDate_noev(argCreateDate) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(ITransactionVersion.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 305 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 306 */       getDAO_().setCreateDate(argCreateDate);
/* 307 */       ev_postable = true;
/*     */     } 
/*     */     
/* 310 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 318 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 326 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(ITransactionVersion.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 339 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 340 */       getDAO_().setCreateUserId(argCreateUserId);
/* 341 */       ev_postable = true;
/*     */     } 
/*     */     
/* 344 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 352 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 360 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(ITransactionVersion.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 373 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 374 */       getDAO_().setUpdateDate(argUpdateDate);
/* 375 */       ev_postable = true;
/*     */     } 
/*     */     
/* 378 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 386 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 394 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(ITransactionVersion.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 407 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 408 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 409 */       ev_postable = true;
/*     */     } 
/*     */     
/* 412 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseAppVersion() {
/* 420 */     return getDAO_().getBaseAppVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseAppVersion(String argBaseAppVersion) {
/* 428 */     if (setBaseAppVersion_noev(argBaseAppVersion) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(ITransactionVersion.SET_BASEAPPVERSION, argBaseAppVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseAppVersion_noev(String argBaseAppVersion) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getBaseAppVersion() == null && argBaseAppVersion != null) || (
/* 441 */       getDAO_().getBaseAppVersion() != null && !getDAO_().getBaseAppVersion().equals(argBaseAppVersion))) {
/* 442 */       getDAO_().setBaseAppVersion(argBaseAppVersion);
/* 443 */       ev_postable = true;
/*     */     } 
/*     */     
/* 446 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBaseAppDate() {
/* 454 */     return getDAO_().getBaseAppDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseAppDate(Date argBaseAppDate) {
/* 462 */     if (setBaseAppDate_noev(argBaseAppDate) && 
/* 463 */       this._events != null && 
/* 464 */       postEventsForChanges()) {
/* 465 */       this._events.post(ITransactionVersion.SET_BASEAPPDATE, argBaseAppDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseAppDate_noev(Date argBaseAppDate) {
/* 472 */     boolean ev_postable = false;
/*     */     
/* 474 */     if ((getDAO_().getBaseAppDate() == null && argBaseAppDate != null) || (
/* 475 */       getDAO_().getBaseAppDate() != null && !getDAO_().getBaseAppDate().equals(argBaseAppDate))) {
/* 476 */       getDAO_().setBaseAppDate(argBaseAppDate);
/* 477 */       ev_postable = true;
/*     */     } 
/*     */     
/* 480 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseSchemaVersion() {
/* 488 */     return getDAO_().getBaseSchemaVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseSchemaVersion(String argBaseSchemaVersion) {
/* 496 */     if (setBaseSchemaVersion_noev(argBaseSchemaVersion) && 
/* 497 */       this._events != null && 
/* 498 */       postEventsForChanges()) {
/* 499 */       this._events.post(ITransactionVersion.SET_BASESCHEMAVERSION, argBaseSchemaVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseSchemaVersion_noev(String argBaseSchemaVersion) {
/* 506 */     boolean ev_postable = false;
/*     */     
/* 508 */     if ((getDAO_().getBaseSchemaVersion() == null && argBaseSchemaVersion != null) || (
/* 509 */       getDAO_().getBaseSchemaVersion() != null && !getDAO_().getBaseSchemaVersion().equals(argBaseSchemaVersion))) {
/* 510 */       getDAO_().setBaseSchemaVersion(argBaseSchemaVersion);
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
/*     */   public Date getBaseSchemaDate() {
/* 522 */     return getDAO_().getBaseSchemaDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseSchemaDate(Date argBaseSchemaDate) {
/* 530 */     if (setBaseSchemaDate_noev(argBaseSchemaDate) && 
/* 531 */       this._events != null && 
/* 532 */       postEventsForChanges()) {
/* 533 */       this._events.post(ITransactionVersion.SET_BASESCHEMADATE, argBaseSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseSchemaDate_noev(Date argBaseSchemaDate) {
/* 540 */     boolean ev_postable = false;
/*     */     
/* 542 */     if ((getDAO_().getBaseSchemaDate() == null && argBaseSchemaDate != null) || (
/* 543 */       getDAO_().getBaseSchemaDate() != null && !getDAO_().getBaseSchemaDate().equals(argBaseSchemaDate))) {
/* 544 */       getDAO_().setBaseSchemaDate(argBaseSchemaDate);
/* 545 */       ev_postable = true;
/*     */     } 
/*     */     
/* 548 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerAppVersion() {
/* 556 */     return getDAO_().getCustomerAppVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerAppVersion(String argCustomerAppVersion) {
/* 564 */     if (setCustomerAppVersion_noev(argCustomerAppVersion) && 
/* 565 */       this._events != null && 
/* 566 */       postEventsForChanges()) {
/* 567 */       this._events.post(ITransactionVersion.SET_CUSTOMERAPPVERSION, argCustomerAppVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerAppVersion_noev(String argCustomerAppVersion) {
/* 574 */     boolean ev_postable = false;
/*     */     
/* 576 */     if ((getDAO_().getCustomerAppVersion() == null && argCustomerAppVersion != null) || (
/* 577 */       getDAO_().getCustomerAppVersion() != null && !getDAO_().getCustomerAppVersion().equals(argCustomerAppVersion))) {
/* 578 */       getDAO_().setCustomerAppVersion(argCustomerAppVersion);
/* 579 */       ev_postable = true;
/*     */     } 
/*     */     
/* 582 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerSchemaVersion() {
/* 590 */     return getDAO_().getCustomerSchemaVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerSchemaVersion(String argCustomerSchemaVersion) {
/* 598 */     if (setCustomerSchemaVersion_noev(argCustomerSchemaVersion) && 
/* 599 */       this._events != null && 
/* 600 */       postEventsForChanges()) {
/* 601 */       this._events.post(ITransactionVersion.SET_CUSTOMERSCHEMAVERSION, argCustomerSchemaVersion);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerSchemaVersion_noev(String argCustomerSchemaVersion) {
/* 608 */     boolean ev_postable = false;
/*     */     
/* 610 */     if ((getDAO_().getCustomerSchemaVersion() == null && argCustomerSchemaVersion != null) || (
/* 611 */       getDAO_().getCustomerSchemaVersion() != null && !getDAO_().getCustomerSchemaVersion().equals(argCustomerSchemaVersion))) {
/* 612 */       getDAO_().setCustomerSchemaVersion(argCustomerSchemaVersion);
/* 613 */       ev_postable = true;
/*     */     } 
/*     */     
/* 616 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCustomerSchemaDate() {
/* 624 */     return getDAO_().getCustomerSchemaDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomerSchemaDate(Date argCustomerSchemaDate) {
/* 632 */     if (setCustomerSchemaDate_noev(argCustomerSchemaDate) && 
/* 633 */       this._events != null && 
/* 634 */       postEventsForChanges()) {
/* 635 */       this._events.post(ITransactionVersion.SET_CUSTOMERSCHEMADATE, argCustomerSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomerSchemaDate_noev(Date argCustomerSchemaDate) {
/* 642 */     boolean ev_postable = false;
/*     */     
/* 644 */     if ((getDAO_().getCustomerSchemaDate() == null && argCustomerSchemaDate != null) || (
/* 645 */       getDAO_().getCustomerSchemaDate() != null && !getDAO_().getCustomerSchemaDate().equals(argCustomerSchemaDate))) {
/* 646 */       getDAO_().setCustomerSchemaDate(argCustomerSchemaDate);
/* 647 */       ev_postable = true;
/*     */     } 
/*     */     
/* 650 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITransactionVersionProperty newProperty(String argPropertyName) {
/* 654 */     TransactionVersionPropertyId id = new TransactionVersionPropertyId();
/*     */     
/* 656 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 657 */     id.setBusinessDate(getBusinessDate());
/* 658 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 659 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 660 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 662 */     ITransactionVersionProperty prop = (ITransactionVersionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITransactionVersionProperty.class);
/* 663 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITransactionVersionProperty> getProperties() {
/* 672 */     if (this._properties == null) {
/* 673 */       this._properties = new HistoricalList(null);
/*     */     }
/* 675 */     return (List<ITransactionVersionProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITransactionVersionProperty> argProperties) {
/* 679 */     if (this._properties == null) {
/* 680 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 682 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 685 */     for (ITransactionVersionProperty child : this._properties) {
/* 686 */       TransactionVersionPropertyModel model = (TransactionVersionPropertyModel)child;
/* 687 */       model.setOrganizationId_noev(getOrganizationId());
/* 688 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 689 */       model.setBusinessDate_noev(getBusinessDate());
/* 690 */       model.setWorkstationId_noev(getWorkstationId());
/* 691 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 692 */       if (child instanceof IDataModelImpl) {
/* 693 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 694 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 695 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 696 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 699 */       if (postEventsForChanges()) {
/* 700 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTransactionVersionProperty(ITransactionVersionProperty argTransactionVersionProperty) {
/* 706 */     if (this._properties == null) {
/* 707 */       this._properties = new HistoricalList(null);
/*     */     }
/* 709 */     argTransactionVersionProperty.setOrganizationId(getOrganizationId());
/* 710 */     argTransactionVersionProperty.setRetailLocationId(getRetailLocationId());
/* 711 */     argTransactionVersionProperty.setBusinessDate(getBusinessDate());
/* 712 */     argTransactionVersionProperty.setWorkstationId(getWorkstationId());
/* 713 */     argTransactionVersionProperty.setTransactionSequence(getTransactionSequence());
/* 714 */     if (argTransactionVersionProperty instanceof IDataModelImpl) {
/* 715 */       IDataAccessObject childDao = ((IDataModelImpl)argTransactionVersionProperty).getDAO();
/* 716 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 717 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 718 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 723 */     if (postEventsForChanges()) {
/* 724 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionVersionProperty));
/*     */     }
/*     */     
/* 727 */     this._properties.add(argTransactionVersionProperty);
/* 728 */     if (postEventsForChanges()) {
/* 729 */       this._events.post(ITransactionVersion.ADD_PROPERTIES, argTransactionVersionProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTransactionVersionProperty(ITransactionVersionProperty argTransactionVersionProperty) {
/* 734 */     if (this._properties != null) {
/*     */       
/* 736 */       if (postEventsForChanges()) {
/* 737 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionVersionProperty));
/*     */       }
/* 739 */       this._properties.remove(argTransactionVersionProperty);
/* 740 */       if (postEventsForChanges()) {
/* 741 */         this._events.post(ITransactionVersion.REMOVE_PROPERTIES, argTransactionVersionProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 748 */     if ("Properties".equals(argFieldId)) {
/* 749 */       return getProperties();
/*     */     }
/* 751 */     if ("TransactionVersionExtension".equals(argFieldId)) {
/* 752 */       return this._myExtension;
/*     */     }
/*     */     
/* 755 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 761 */     if ("Properties".equals(argFieldId)) {
/* 762 */       setProperties(changeToList(argValue, ITransactionVersionProperty.class));
/*     */     }
/* 764 */     else if ("TransactionVersionExtension".equals(argFieldId)) {
/* 765 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 768 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 774 */     this._persistenceDefaults = argPD;
/* 775 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 776 */     this._eventManager = argEM;
/* 777 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 778 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 779 */     if (this._properties != null) {
/* 780 */       for (ITransactionVersionProperty relationship : this._properties) {
/* 781 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTransactionVersionExt() {
/* 787 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTransactionVersionExt(IDataModel argExt) {
/* 791 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 796 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 800 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 803 */     super.startTransaction();
/*     */     
/* 805 */     this._propertiesSavepoint = this._properties;
/* 806 */     if (this._properties != null) {
/* 807 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 808 */       Iterator<IDataModel> it = this._properties.iterator();
/* 809 */       while (it.hasNext()) {
/* 810 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 815 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 820 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 823 */     super.rollbackChanges();
/*     */     
/* 825 */     this._properties = this._propertiesSavepoint;
/* 826 */     this._propertiesSavepoint = null;
/* 827 */     if (this._properties != null) {
/* 828 */       Iterator<IDataModel> it = this._properties.iterator();
/* 829 */       while (it.hasNext()) {
/* 830 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 838 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 841 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 844 */     super.commitTransaction();
/*     */     
/* 846 */     this._propertiesSavepoint = this._properties;
/* 847 */     if (this._properties != null) {
/* 848 */       Iterator<IDataModel> it = this._properties.iterator();
/* 849 */       while (it.hasNext()) {
/* 850 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 852 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 856 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 861 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\TransactionVersionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */