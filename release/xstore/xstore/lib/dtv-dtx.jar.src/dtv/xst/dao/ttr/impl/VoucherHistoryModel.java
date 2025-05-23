/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*     */ import dtv.xst.dao.ttr.IVoucherHistory;
/*     */ import dtv.xst.dao.ttr.IVoucherHistoryProperty;
/*     */ import dtv.xst.dao.ttr.VoucherHistoryPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class VoucherHistoryModel extends AbstractDataModelWithPropertyImpl<IVoucherHistoryProperty> implements IVoucherHistory {
/*     */   private static final long serialVersionUID = -41453018L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IVoucherHistoryProperty> _properties; private transient HistoricalList<IVoucherHistoryProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new VoucherHistoryDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private VoucherHistoryDAO getDAO_() {
/*  46 */     return (VoucherHistoryDAO)this._daoImpl;
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
/*  70 */       this._events.post(IVoucherHistory.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<VoucherHistoryPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((VoucherHistoryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public String getSerialNumber() {
/* 101 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 109 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IVoucherHistory.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 122 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 123 */       getDAO_().setSerialNumber(argSerialNumber);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<VoucherHistoryPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((VoucherHistoryPropertyModel)it.next()).setSerialNumber_noev(argSerialNumber);
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
/*     */   public String getVoucherTypeCode() {
/* 143 */     return getDAO_().getVoucherTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVoucherTypeCode(String argVoucherTypeCode) {
/* 151 */     if (setVoucherTypeCode_noev(argVoucherTypeCode) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(IVoucherHistory.SET_VOUCHERTYPECODE, argVoucherTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setVoucherTypeCode_noev(String argVoucherTypeCode) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getVoucherTypeCode() == null && argVoucherTypeCode != null) || (
/* 164 */       getDAO_().getVoucherTypeCode() != null && !getDAO_().getVoucherTypeCode().equals(argVoucherTypeCode))) {
/* 165 */       getDAO_().setVoucherTypeCode(argVoucherTypeCode);
/* 166 */       ev_postable = true;
/* 167 */       if (this._properties != null) {
/*     */         
/* 169 */         Iterator<VoucherHistoryPropertyModel> it = this._properties.iterator();
/* 170 */         while (it.hasNext())
/*     */         {
/* 172 */           ((VoucherHistoryPropertyModel)it.next()).setVoucherTypeCode_noev(argVoucherTypeCode);
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
/*     */   public long getHistorySequence() {
/* 185 */     if (getDAO_().getHistorySequence() != null) {
/* 186 */       return getDAO_().getHistorySequence().longValue();
/*     */     }
/*     */     
/* 189 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHistorySequence(long argHistorySequence) {
/* 198 */     if (setHistorySequence_noev(argHistorySequence) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IVoucherHistory.SET_HISTORYSEQUENCE, Long.valueOf(argHistorySequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHistorySequence_noev(long argHistorySequence) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getHistorySequence() == null && Long.valueOf(argHistorySequence) != null) || (
/* 211 */       getDAO_().getHistorySequence() != null && !getDAO_().getHistorySequence().equals(Long.valueOf(argHistorySequence)))) {
/* 212 */       getDAO_().setHistorySequence(Long.valueOf(argHistorySequence));
/* 213 */       ev_postable = true;
/* 214 */       if (this._properties != null) {
/*     */         
/* 216 */         Iterator<VoucherHistoryPropertyModel> it = this._properties.iterator();
/* 217 */         while (it.hasNext())
/*     */         {
/* 219 */           ((VoucherHistoryPropertyModel)it.next()).setHistorySequence_noev(argHistorySequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 232 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 240 */     if (setCreateDate_noev(argCreateDate) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IVoucherHistory.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 253 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 254 */       getDAO_().setCreateDate(argCreateDate);
/* 255 */       ev_postable = true;
/*     */     } 
/*     */     
/* 258 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 266 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 274 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(IVoucherHistory.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 287 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 288 */       getDAO_().setCreateUserId(argCreateUserId);
/* 289 */       ev_postable = true;
/*     */     } 
/*     */     
/* 292 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 300 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 308 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(IVoucherHistory.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 321 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 322 */       getDAO_().setUpdateDate(argUpdateDate);
/* 323 */       ev_postable = true;
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 334 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 342 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(IVoucherHistory.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 355 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 356 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 357 */       ev_postable = true;
/*     */     } 
/*     */     
/* 360 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActivityCode() {
/* 368 */     return getDAO_().getActivityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityCode(String argActivityCode) {
/* 376 */     if (setActivityCode_noev(argActivityCode) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(IVoucherHistory.SET_ACTIVITYCODE, argActivityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityCode_noev(String argActivityCode) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getActivityCode() == null && argActivityCode != null) || (
/* 389 */       getDAO_().getActivityCode() != null && !getDAO_().getActivityCode().equals(argActivityCode))) {
/* 390 */       getDAO_().setActivityCode(argActivityCode);
/* 391 */       ev_postable = true;
/*     */     } 
/*     */     
/* 394 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 402 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 410 */     if (setAmount_noev(argAmount) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(IVoucherHistory.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 423 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 424 */       getDAO_().setAmount(argAmount);
/* 425 */       ev_postable = true;
/*     */     } 
/*     */     
/* 428 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRetailTransactionLineItemSequence() {
/* 436 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/* 437 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*     */     }
/*     */     
/* 440 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/* 449 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IVoucherHistory.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/* 462 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/* 463 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 475 */     if (getDAO_().getRetailLocationId() != null) {
/* 476 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 479 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 488 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 489 */       this._events != null && 
/* 490 */       postEventsForChanges()) {
/* 491 */       this._events.post(IVoucherHistory.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 498 */     boolean ev_postable = false;
/*     */     
/* 500 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 501 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 502 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 503 */       ev_postable = true;
/*     */     } 
/*     */     
/* 506 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 514 */     if (getDAO_().getWorkstationId() != null) {
/* 515 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 518 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 527 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 528 */       this._events != null && 
/* 529 */       postEventsForChanges()) {
/* 530 */       this._events.post(IVoucherHistory.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 537 */     boolean ev_postable = false;
/*     */     
/* 539 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 540 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 541 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 542 */       ev_postable = true;
/*     */     } 
/*     */     
/* 545 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 553 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 561 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 562 */       this._events != null && 
/* 563 */       postEventsForChanges()) {
/* 564 */       this._events.post(IVoucherHistory.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 571 */     boolean ev_postable = false;
/*     */     
/* 573 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 574 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 575 */       getDAO_().setBusinessDate(argBusinessDate);
/* 576 */       ev_postable = true;
/*     */     } 
/*     */     
/* 579 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 587 */     if (getDAO_().getTransactionSequence() != null) {
/* 588 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 591 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 600 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 601 */       this._events != null && 
/* 602 */       postEventsForChanges()) {
/* 603 */       this._events.post(IVoucherHistory.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 610 */     boolean ev_postable = false;
/*     */     
/* 612 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 613 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 614 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 615 */       ev_postable = true;
/*     */     } 
/*     */     
/* 618 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IVoucherHistoryProperty newProperty(String argPropertyName) {
/* 622 */     VoucherHistoryPropertyId id = new VoucherHistoryPropertyId();
/*     */     
/* 624 */     id.setSerialNumber(getSerialNumber());
/* 625 */     id.setVoucherTypeCode(getVoucherTypeCode());
/* 626 */     id.setHistorySequence(Long.valueOf(getHistorySequence()));
/* 627 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 629 */     IVoucherHistoryProperty prop = (IVoucherHistoryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IVoucherHistoryProperty.class);
/* 630 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IVoucherHistoryProperty> getProperties() {
/* 639 */     if (this._properties == null) {
/* 640 */       this._properties = new HistoricalList(null);
/*     */     }
/* 642 */     return (List<IVoucherHistoryProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IVoucherHistoryProperty> argProperties) {
/* 646 */     if (this._properties == null) {
/* 647 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 649 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 652 */     for (IVoucherHistoryProperty child : this._properties) {
/* 653 */       VoucherHistoryPropertyModel model = (VoucherHistoryPropertyModel)child;
/* 654 */       model.setOrganizationId_noev(getOrganizationId());
/* 655 */       model.setSerialNumber_noev(getSerialNumber());
/* 656 */       model.setVoucherTypeCode_noev(getVoucherTypeCode());
/* 657 */       model.setHistorySequence_noev(getHistorySequence());
/* 658 */       if (child instanceof IDataModelImpl) {
/* 659 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 660 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 661 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 662 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 665 */       if (postEventsForChanges()) {
/* 666 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addVoucherHistoryProperty(IVoucherHistoryProperty argVoucherHistoryProperty) {
/* 672 */     if (this._properties == null) {
/* 673 */       this._properties = new HistoricalList(null);
/*     */     }
/* 675 */     argVoucherHistoryProperty.setOrganizationId(getOrganizationId());
/* 676 */     argVoucherHistoryProperty.setSerialNumber(getSerialNumber());
/* 677 */     argVoucherHistoryProperty.setVoucherTypeCode(getVoucherTypeCode());
/* 678 */     argVoucherHistoryProperty.setHistorySequence(getHistorySequence());
/* 679 */     if (argVoucherHistoryProperty instanceof IDataModelImpl) {
/* 680 */       IDataAccessObject childDao = ((IDataModelImpl)argVoucherHistoryProperty).getDAO();
/* 681 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 682 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 683 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 688 */     if (postEventsForChanges()) {
/* 689 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoucherHistoryProperty));
/*     */     }
/*     */     
/* 692 */     this._properties.add(argVoucherHistoryProperty);
/* 693 */     if (postEventsForChanges()) {
/* 694 */       this._events.post(IVoucherHistory.ADD_PROPERTIES, argVoucherHistoryProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeVoucherHistoryProperty(IVoucherHistoryProperty argVoucherHistoryProperty) {
/* 699 */     if (this._properties != null) {
/*     */       
/* 701 */       if (postEventsForChanges()) {
/* 702 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argVoucherHistoryProperty));
/*     */       }
/* 704 */       this._properties.remove(argVoucherHistoryProperty);
/* 705 */       if (postEventsForChanges()) {
/* 706 */         this._events.post(IVoucherHistory.REMOVE_PROPERTIES, argVoucherHistoryProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 713 */     if ("Properties".equals(argFieldId)) {
/* 714 */       return getProperties();
/*     */     }
/* 716 */     if ("VoucherHistoryExtension".equals(argFieldId)) {
/* 717 */       return this._myExtension;
/*     */     }
/*     */     
/* 720 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 726 */     if ("Properties".equals(argFieldId)) {
/* 727 */       setProperties(changeToList(argValue, IVoucherHistoryProperty.class));
/*     */     }
/* 729 */     else if ("VoucherHistoryExtension".equals(argFieldId)) {
/* 730 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 733 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 739 */     this._persistenceDefaults = argPD;
/* 740 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 741 */     this._eventManager = argEM;
/* 742 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 743 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 744 */     if (this._properties != null) {
/* 745 */       for (IVoucherHistoryProperty relationship : this._properties) {
/* 746 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getVoucherHistoryExt() {
/* 752 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setVoucherHistoryExt(IDataModel argExt) {
/* 756 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 761 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 765 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 768 */     super.startTransaction();
/*     */     
/* 770 */     this._propertiesSavepoint = this._properties;
/* 771 */     if (this._properties != null) {
/* 772 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 773 */       Iterator<IDataModel> it = this._properties.iterator();
/* 774 */       while (it.hasNext()) {
/* 775 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 780 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 785 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 788 */     super.rollbackChanges();
/*     */     
/* 790 */     this._properties = this._propertiesSavepoint;
/* 791 */     this._propertiesSavepoint = null;
/* 792 */     if (this._properties != null) {
/* 793 */       Iterator<IDataModel> it = this._properties.iterator();
/* 794 */       while (it.hasNext()) {
/* 795 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 803 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 806 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 809 */     super.commitTransaction();
/*     */     
/* 811 */     this._propertiesSavepoint = this._properties;
/* 812 */     if (this._properties != null) {
/* 813 */       Iterator<IDataModel> it = this._properties.iterator();
/* 814 */       while (it.hasNext()) {
/* 815 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 817 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 821 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 826 */     argStream.defaultReadObject();
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
/*     */   public void setRetailTransactionLineItem(IRetailTransactionLineItem argLineItem) {
/* 841 */     setRetailTransactionLineItemSequence(argLineItem
/* 842 */         .getRetailTransactionLineItemSequence());
/* 843 */     setRetailLocationId(argLineItem.getRetailLocationId());
/* 844 */     setWorkstationId(argLineItem.getWorkstationId());
/* 845 */     setBusinessDate(argLineItem.getBusinessDate());
/* 846 */     setTransactionSequence(argLineItem.getTransactionSequence());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherHistoryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */