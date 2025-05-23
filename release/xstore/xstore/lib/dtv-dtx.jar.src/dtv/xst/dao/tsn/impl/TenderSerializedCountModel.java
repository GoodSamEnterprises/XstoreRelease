/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.xst.dao.tnd.ITender;
/*     */ import dtv.xst.dao.tsn.ITenderSerializedCount;
/*     */ import dtv.xst.dao.tsn.ITenderSerializedCountProperty;
/*     */ import dtv.xst.dao.tsn.ITenderTypeCount;
/*     */ import dtv.xst.dao.tsn.TenderSerializedCountPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderSerializedCountModel extends AbstractDataModelWithPropertyImpl<ITenderSerializedCountProperty> implements ITenderSerializedCount {
/*     */   private static final long serialVersionUID = -395161513L;
/*     */   private ITenderTypeCount _parentTenderTypeCount;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private ITender _tender; private transient ITender _tenderSavepoint; private HistoricalList<ITenderSerializedCountProperty> _properties; private transient HistoricalList<ITenderSerializedCountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new TenderSerializedCountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderSerializedCountDAO getDAO_() {
/*  49 */     return (TenderSerializedCountDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDayDate() {
/*  57 */     return getDAO_().getBusinessDayDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*  65 */     if (setBusinessDayDate_noev(argBusinessDayDate) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(ITenderSerializedCount.SET_BUSINESSDAYDATE, argBusinessDayDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDayDate_noev(Date argBusinessDayDate) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getBusinessDayDate() == null && argBusinessDayDate != null) || (
/*  78 */       getDAO_().getBusinessDayDate() != null && !getDAO_().getBusinessDayDate().equals(argBusinessDayDate))) {
/*  79 */       getDAO_().setBusinessDayDate(argBusinessDayDate);
/*  80 */       ev_postable = true;
/*  81 */       if (this._properties != null) {
/*     */         
/*  83 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/*  84 */         while (it.hasNext())
/*     */         {
/*  86 */           ((TenderSerializedCountPropertyModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  99 */     if (getDAO_().getOrganizationId() != null) {
/* 100 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 103 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 112 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 113 */       this._events != null && 
/* 114 */       postEventsForChanges()) {
/* 115 */       this._events.post(ITenderSerializedCount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 122 */     boolean ev_postable = false;
/*     */     
/* 124 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 125 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 126 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 127 */       ev_postable = true;
/* 128 */       if (this._properties != null) {
/*     */         
/* 130 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/* 131 */         while (it.hasNext())
/*     */         {
/* 133 */           ((TenderSerializedCountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 146 */     if (getDAO_().getRetailLocationId() != null) {
/* 147 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 150 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 159 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(ITenderSerializedCount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 172 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 173 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 174 */       ev_postable = true;
/* 175 */       if (this._properties != null) {
/*     */         
/* 177 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((TenderSerializedCountPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSerializedCountSequence() {
/* 193 */     if (getDAO_().getSerializedCountSequence() != null) {
/* 194 */       return getDAO_().getSerializedCountSequence().intValue();
/*     */     }
/*     */     
/* 197 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerializedCountSequence(int argSerializedCountSequence) {
/* 206 */     if (setSerializedCountSequence_noev(argSerializedCountSequence) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(ITenderSerializedCount.SET_SERIALIZEDCOUNTSEQUENCE, Integer.valueOf(argSerializedCountSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerializedCountSequence_noev(int argSerializedCountSequence) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getSerializedCountSequence() == null && Integer.valueOf(argSerializedCountSequence) != null) || (
/* 219 */       getDAO_().getSerializedCountSequence() != null && !getDAO_().getSerializedCountSequence().equals(Integer.valueOf(argSerializedCountSequence)))) {
/* 220 */       getDAO_().setSerializedCountSequence(Integer.valueOf(argSerializedCountSequence));
/* 221 */       ev_postable = true;
/* 222 */       if (this._properties != null) {
/*     */         
/* 224 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/* 225 */         while (it.hasNext())
/*     */         {
/* 227 */           ((TenderSerializedCountPropertyModel)it.next()).setSerializedCountSequence_noev(argSerializedCountSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 232 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderTypeCode() {
/* 240 */     return getDAO_().getTenderTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/* 248 */     if (setTenderTypeCode_noev(argTenderTypeCode) && 
/* 249 */       this._events != null && 
/* 250 */       postEventsForChanges()) {
/* 251 */       this._events.post(ITenderSerializedCount.SET_TENDERTYPECODE, argTenderTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderTypeCode_noev(String argTenderTypeCode) {
/* 258 */     boolean ev_postable = false;
/*     */     
/* 260 */     if ((getDAO_().getTenderTypeCode() == null && argTenderTypeCode != null) || (
/* 261 */       getDAO_().getTenderTypeCode() != null && !getDAO_().getTenderTypeCode().equals(argTenderTypeCode))) {
/* 262 */       getDAO_().setTenderTypeCode(argTenderTypeCode);
/* 263 */       ev_postable = true;
/* 264 */       if (this._properties != null) {
/*     */         
/* 266 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/* 267 */         while (it.hasNext())
/*     */         {
/* 269 */           ((TenderSerializedCountPropertyModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 274 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 282 */     if (getDAO_().getTransactionSequence() != null) {
/* 283 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 286 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 295 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(ITenderSerializedCount.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 308 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 309 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 310 */       ev_postable = true;
/* 311 */       if (this._properties != null) {
/*     */         
/* 313 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/* 314 */         while (it.hasNext())
/*     */         {
/* 316 */           ((TenderSerializedCountPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 329 */     if (getDAO_().getWorkstationId() != null) {
/* 330 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 333 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 342 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(ITenderSerializedCount.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 355 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 356 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 357 */       ev_postable = true;
/* 358 */       if (this._properties != null) {
/*     */         
/* 360 */         Iterator<TenderSerializedCountPropertyModel> it = this._properties.iterator();
/* 361 */         while (it.hasNext())
/*     */         {
/* 363 */           ((TenderSerializedCountPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 368 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 376 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 384 */     if (setCreateDate_noev(argCreateDate) && 
/* 385 */       this._events != null && 
/* 386 */       postEventsForChanges()) {
/* 387 */       this._events.post(ITenderSerializedCount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 394 */     boolean ev_postable = false;
/*     */     
/* 396 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 397 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 398 */       getDAO_().setCreateDate(argCreateDate);
/* 399 */       ev_postable = true;
/*     */     } 
/*     */     
/* 402 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 410 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 418 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 419 */       this._events != null && 
/* 420 */       postEventsForChanges()) {
/* 421 */       this._events.post(ITenderSerializedCount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 428 */     boolean ev_postable = false;
/*     */     
/* 430 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 431 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 432 */       getDAO_().setCreateUserId(argCreateUserId);
/* 433 */       ev_postable = true;
/*     */     } 
/*     */     
/* 436 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 444 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 452 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 453 */       this._events != null && 
/* 454 */       postEventsForChanges()) {
/* 455 */       this._events.post(ITenderSerializedCount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 462 */     boolean ev_postable = false;
/*     */     
/* 464 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 465 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 466 */       getDAO_().setUpdateDate(argUpdateDate);
/* 467 */       ev_postable = true;
/*     */     } 
/*     */     
/* 470 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 478 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 486 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 487 */       this._events != null && 
/* 488 */       postEventsForChanges()) {
/* 489 */       this._events.post(ITenderSerializedCount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 496 */     boolean ev_postable = false;
/*     */     
/* 498 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 499 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 500 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 501 */       ev_postable = true;
/*     */     } 
/*     */     
/* 504 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 512 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 520 */     if (setAmount_noev(argAmount) && 
/* 521 */       this._events != null && 
/* 522 */       postEventsForChanges()) {
/* 523 */       this._events.post(ITenderSerializedCount.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 530 */     boolean ev_postable = false;
/*     */     
/* 532 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 533 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 534 */       getDAO_().setAmount(argAmount);
/* 535 */       ev_postable = true;
/*     */     } 
/*     */     
/* 538 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 546 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 554 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 555 */       this._events != null && 
/* 556 */       postEventsForChanges()) {
/* 557 */       this._events.post(ITenderSerializedCount.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 564 */     boolean ev_postable = false;
/*     */     
/* 566 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 567 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 568 */       getDAO_().setSerialNumber(argSerialNumber);
/* 569 */       ev_postable = true;
/*     */     } 
/*     */     
/* 572 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/* 580 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 588 */     if (setTenderId_noev(argTenderId) && 
/* 589 */       this._events != null && 
/* 590 */       postEventsForChanges()) {
/* 591 */       this._events.post(ITenderSerializedCount.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 598 */     boolean ev_postable = false;
/*     */     
/* 600 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 601 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 602 */       getDAO_().setTenderId(argTenderId);
/* 603 */       ev_postable = true;
/*     */     } 
/*     */     
/* 606 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderSerializedCountProperty newProperty(String argPropertyName) {
/* 610 */     TenderSerializedCountPropertyId id = new TenderSerializedCountPropertyId();
/*     */     
/* 612 */     id.setBusinessDayDate(getBusinessDayDate());
/* 613 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 614 */     id.setSerializedCountSequence(Integer.valueOf(getSerializedCountSequence()));
/* 615 */     id.setTenderTypeCode(getTenderTypeCode());
/* 616 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 617 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 618 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 620 */     ITenderSerializedCountProperty prop = (ITenderSerializedCountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderSerializedCountProperty.class);
/* 621 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Tender")
/*     */   public ITender getTender() {
/* 633 */     return this._tender;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTender(ITender argTender) {
/* 638 */     if (argTender == null) {
/*     */       
/* 640 */       getDAO_().setTenderId(null);
/* 641 */       if (this._tender != null)
/*     */       {
/* 643 */         if (postEventsForChanges()) {
/* 644 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._tender));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 649 */       getDAO_().setTenderId(argTender.getTenderId());
/*     */       
/* 651 */       if (postEventsForChanges()) {
/* 652 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTender));
/*     */       }
/*     */     } 
/*     */     
/* 656 */     this._tender = argTender;
/* 657 */     if (postEventsForChanges()) {
/* 658 */       this._events.post(ITenderSerializedCount.SET_TENDER, argTender);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderSerializedCountProperty> getProperties() {
/* 664 */     if (this._properties == null) {
/* 665 */       this._properties = new HistoricalList(null);
/*     */     }
/* 667 */     return (List<ITenderSerializedCountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderSerializedCountProperty> argProperties) {
/* 671 */     if (this._properties == null) {
/* 672 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 674 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 677 */     for (ITenderSerializedCountProperty child : this._properties) {
/* 678 */       TenderSerializedCountPropertyModel model = (TenderSerializedCountPropertyModel)child;
/* 679 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/* 680 */       model.setOrganizationId_noev(getOrganizationId());
/* 681 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 682 */       model.setSerializedCountSequence_noev(getSerializedCountSequence());
/* 683 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/* 684 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 685 */       model.setWorkstationId_noev(getWorkstationId());
/* 686 */       if (child instanceof IDataModelImpl) {
/* 687 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 688 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 689 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 690 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 693 */       if (postEventsForChanges()) {
/* 694 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderSerializedCountProperty(ITenderSerializedCountProperty argTenderSerializedCountProperty) {
/* 700 */     if (this._properties == null) {
/* 701 */       this._properties = new HistoricalList(null);
/*     */     }
/* 703 */     argTenderSerializedCountProperty.setBusinessDayDate(getBusinessDayDate());
/* 704 */     argTenderSerializedCountProperty.setOrganizationId(getOrganizationId());
/* 705 */     argTenderSerializedCountProperty.setRetailLocationId(getRetailLocationId());
/* 706 */     argTenderSerializedCountProperty.setSerializedCountSequence(getSerializedCountSequence());
/* 707 */     argTenderSerializedCountProperty.setTenderTypeCode(getTenderTypeCode());
/* 708 */     argTenderSerializedCountProperty.setTransactionSequence(getTransactionSequence());
/* 709 */     argTenderSerializedCountProperty.setWorkstationId(getWorkstationId());
/* 710 */     if (argTenderSerializedCountProperty instanceof IDataModelImpl) {
/* 711 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderSerializedCountProperty).getDAO();
/* 712 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 713 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 714 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 719 */     if (postEventsForChanges()) {
/* 720 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderSerializedCountProperty));
/*     */     }
/*     */     
/* 723 */     this._properties.add(argTenderSerializedCountProperty);
/* 724 */     if (postEventsForChanges()) {
/* 725 */       this._events.post(ITenderSerializedCount.ADD_PROPERTIES, argTenderSerializedCountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderSerializedCountProperty(ITenderSerializedCountProperty argTenderSerializedCountProperty) {
/* 730 */     if (this._properties != null) {
/*     */       
/* 732 */       if (postEventsForChanges()) {
/* 733 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderSerializedCountProperty));
/*     */       }
/* 735 */       this._properties.remove(argTenderSerializedCountProperty);
/* 736 */       if (postEventsForChanges()) {
/* 737 */         this._events.post(ITenderSerializedCount.REMOVE_PROPERTIES, argTenderSerializedCountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTenderTypeCount(ITenderTypeCount argParentTenderTypeCount) {
/* 743 */     this._parentTenderTypeCount = argParentTenderTypeCount;
/*     */   }
/*     */   
/*     */   public ITenderTypeCount getParentTenderTypeCount() {
/* 747 */     return this._parentTenderTypeCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 752 */     if ("Tender".equals(argFieldId)) {
/* 753 */       return getTender();
/*     */     }
/* 755 */     if ("Properties".equals(argFieldId)) {
/* 756 */       return getProperties();
/*     */     }
/* 758 */     if ("TenderSerializedCountExtension".equals(argFieldId)) {
/* 759 */       return this._myExtension;
/*     */     }
/*     */     
/* 762 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 768 */     if ("Tender".equals(argFieldId)) {
/* 769 */       setTender((ITender)argValue);
/*     */     }
/* 771 */     else if ("Properties".equals(argFieldId)) {
/* 772 */       setProperties(changeToList(argValue, ITenderSerializedCountProperty.class));
/*     */     }
/* 774 */     else if ("TenderSerializedCountExtension".equals(argFieldId)) {
/* 775 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 778 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 784 */     this._persistenceDefaults = argPD;
/* 785 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 786 */     this._eventManager = argEM;
/* 787 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 788 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 789 */     if (this._tender != null) {
/* 790 */       ((IDataModelImpl)this._tender).setDependencies(argPD, argEM);
/*     */     }
/* 792 */     if (this._properties != null) {
/* 793 */       for (ITenderSerializedCountProperty relationship : this._properties) {
/* 794 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderSerializedCountExt() {
/* 800 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderSerializedCountExt(IDataModel argExt) {
/* 804 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 809 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 813 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 816 */     super.startTransaction();
/*     */     
/* 818 */     this._tenderSavepoint = this._tender;
/* 819 */     if (this._tender != null) {
/* 820 */       this._tender.startTransaction();
/*     */     }
/*     */     
/* 823 */     this._propertiesSavepoint = this._properties;
/* 824 */     if (this._properties != null) {
/* 825 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 826 */       Iterator<IDataModel> it = this._properties.iterator();
/* 827 */       while (it.hasNext()) {
/* 828 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 833 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 838 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 841 */     super.rollbackChanges();
/*     */     
/* 843 */     this._tender = this._tenderSavepoint;
/* 844 */     this._tenderSavepoint = null;
/* 845 */     if (this._tender != null) {
/* 846 */       this._tender.rollbackChanges();
/*     */     }
/*     */     
/* 849 */     this._properties = this._propertiesSavepoint;
/* 850 */     this._propertiesSavepoint = null;
/* 851 */     if (this._properties != null) {
/* 852 */       Iterator<IDataModel> it = this._properties.iterator();
/* 853 */       while (it.hasNext()) {
/* 854 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 862 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 865 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 868 */     super.commitTransaction();
/*     */     
/* 870 */     this._tenderSavepoint = this._tender;
/* 871 */     if (this._tender != null) {
/* 872 */       this._tender.commitTransaction();
/*     */     }
/*     */     
/* 875 */     this._propertiesSavepoint = this._properties;
/* 876 */     if (this._properties != null) {
/* 877 */       Iterator<IDataModel> it = this._properties.iterator();
/* 878 */       while (it.hasNext()) {
/* 879 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 881 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 885 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 890 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderSerializedCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */