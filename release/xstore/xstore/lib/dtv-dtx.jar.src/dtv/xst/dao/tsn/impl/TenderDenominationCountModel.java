/*     */ package dtv.xst.dao.tsn.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
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
/*     */ import dtv.xst.dao.tnd.ITenderDenomination;
/*     */ import dtv.xst.dao.tsn.ITenderCount;
/*     */ import dtv.xst.dao.tsn.ITenderDenominationCount;
/*     */ import dtv.xst.dao.tsn.ITenderDenominationCountProperty;
/*     */ import dtv.xst.dao.tsn.TenderDenominationCountPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TenderDenominationCountModel extends AbstractDataModelWithPropertyImpl<ITenderDenominationCountProperty> implements ITenderDenominationCount {
/*     */   private static final long serialVersionUID = -1378804842L;
/*     */   private ITenderCount _parentTenderCount;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private ITenderDenomination _tenderDenomination; private transient ITenderDenomination _tenderDenominationSavepoint; private HistoricalList<ITenderDenominationCountProperty> _properties; private transient HistoricalList<ITenderDenominationCountProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new TenderDenominationCountDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TenderDenominationCountDAO getDAO_() {
/*  49 */     return (TenderDenominationCountDAO)this._daoImpl;
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
/*  68 */       this._events.post(ITenderDenominationCount.SET_BUSINESSDAYDATE, argBusinessDayDate);
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
/*  83 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/*  84 */         while (it.hasNext())
/*     */         {
/*  86 */           ((TenderDenominationCountPropertyModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
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
/*     */   public String getDenominationId() {
/*  99 */     return getDAO_().getDenominationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/* 107 */     if (setDenominationId_noev(argDenominationId) && 
/* 108 */       this._events != null && 
/* 109 */       postEventsForChanges()) {
/* 110 */       this._events.post(ITenderDenominationCount.SET_DENOMINATIONID, argDenominationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDenominationId_noev(String argDenominationId) {
/* 117 */     boolean ev_postable = false;
/*     */     
/* 119 */     if ((getDAO_().getDenominationId() == null && argDenominationId != null) || (
/* 120 */       getDAO_().getDenominationId() != null && !getDAO_().getDenominationId().equals(argDenominationId))) {
/* 121 */       getDAO_().setDenominationId(argDenominationId);
/* 122 */       ev_postable = true;
/* 123 */       if (this._properties != null) {
/*     */         
/* 125 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 126 */         while (it.hasNext())
/*     */         {
/* 128 */           ((TenderDenominationCountPropertyModel)it.next()).setDenominationId_noev(argDenominationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 141 */     if (getDAO_().getOrganizationId() != null) {
/* 142 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 145 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 154 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 155 */       this._events != null && 
/* 156 */       postEventsForChanges()) {
/* 157 */       this._events.post(ITenderDenominationCount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 164 */     boolean ev_postable = false;
/*     */     
/* 166 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 167 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 168 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 169 */       ev_postable = true;
/* 170 */       if (this._properties != null) {
/*     */         
/* 172 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 173 */         while (it.hasNext())
/*     */         {
/* 175 */           ((TenderDenominationCountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 188 */     if (getDAO_().getRetailLocationId() != null) {
/* 189 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 192 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 201 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(ITenderDenominationCount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 214 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 215 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((TenderDenominationCountPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/* 235 */     return getDAO_().getTenderId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/* 243 */     if (setTenderId_noev(argTenderId) && 
/* 244 */       this._events != null && 
/* 245 */       postEventsForChanges()) {
/* 246 */       this._events.post(ITenderDenominationCount.SET_TENDERID, argTenderId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderId_noev(String argTenderId) {
/* 253 */     boolean ev_postable = false;
/*     */     
/* 255 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/* 256 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/* 257 */       getDAO_().setTenderId(argTenderId);
/* 258 */       ev_postable = true;
/* 259 */       if (this._properties != null) {
/*     */         
/* 261 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 262 */         while (it.hasNext())
/*     */         {
/* 264 */           ((TenderDenominationCountPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 269 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderTypeCode() {
/* 277 */     return getDAO_().getTenderTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTenderTypeCode(String argTenderTypeCode) {
/* 285 */     if (setTenderTypeCode_noev(argTenderTypeCode) && 
/* 286 */       this._events != null && 
/* 287 */       postEventsForChanges()) {
/* 288 */       this._events.post(ITenderDenominationCount.SET_TENDERTYPECODE, argTenderTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTenderTypeCode_noev(String argTenderTypeCode) {
/* 295 */     boolean ev_postable = false;
/*     */     
/* 297 */     if ((getDAO_().getTenderTypeCode() == null && argTenderTypeCode != null) || (
/* 298 */       getDAO_().getTenderTypeCode() != null && !getDAO_().getTenderTypeCode().equals(argTenderTypeCode))) {
/* 299 */       getDAO_().setTenderTypeCode(argTenderTypeCode);
/* 300 */       ev_postable = true;
/* 301 */       if (this._properties != null) {
/*     */         
/* 303 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 304 */         while (it.hasNext())
/*     */         {
/* 306 */           ((TenderDenominationCountPropertyModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 311 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 319 */     if (getDAO_().getTransactionSequence() != null) {
/* 320 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 323 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 332 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 333 */       this._events != null && 
/* 334 */       postEventsForChanges()) {
/* 335 */       this._events.post(ITenderDenominationCount.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 342 */     boolean ev_postable = false;
/*     */     
/* 344 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 345 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 346 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 347 */       ev_postable = true;
/* 348 */       if (this._properties != null) {
/*     */         
/* 350 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 351 */         while (it.hasNext())
/*     */         {
/* 353 */           ((TenderDenominationCountPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 358 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 366 */     if (getDAO_().getWorkstationId() != null) {
/* 367 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 370 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 379 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 380 */       this._events != null && 
/* 381 */       postEventsForChanges()) {
/* 382 */       this._events.post(ITenderDenominationCount.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 389 */     boolean ev_postable = false;
/*     */     
/* 391 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 392 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 393 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 394 */       ev_postable = true;
/* 395 */       if (this._properties != null) {
/*     */         
/* 397 */         Iterator<TenderDenominationCountPropertyModel> it = this._properties.iterator();
/* 398 */         while (it.hasNext())
/*     */         {
/* 400 */           ((TenderDenominationCountPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 405 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 413 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 421 */     if (setCreateDate_noev(argCreateDate) && 
/* 422 */       this._events != null && 
/* 423 */       postEventsForChanges()) {
/* 424 */       this._events.post(ITenderDenominationCount.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 431 */     boolean ev_postable = false;
/*     */     
/* 433 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 434 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 435 */       getDAO_().setCreateDate(argCreateDate);
/* 436 */       ev_postable = true;
/*     */     } 
/*     */     
/* 439 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 447 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 455 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 456 */       this._events != null && 
/* 457 */       postEventsForChanges()) {
/* 458 */       this._events.post(ITenderDenominationCount.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 465 */     boolean ev_postable = false;
/*     */     
/* 467 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 468 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 469 */       getDAO_().setCreateUserId(argCreateUserId);
/* 470 */       ev_postable = true;
/*     */     } 
/*     */     
/* 473 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 481 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 489 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 490 */       this._events != null && 
/* 491 */       postEventsForChanges()) {
/* 492 */       this._events.post(ITenderDenominationCount.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 499 */     boolean ev_postable = false;
/*     */     
/* 501 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 502 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 503 */       getDAO_().setUpdateDate(argUpdateDate);
/* 504 */       ev_postable = true;
/*     */     } 
/*     */     
/* 507 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 515 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 523 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 524 */       this._events != null && 
/* 525 */       postEventsForChanges()) {
/* 526 */       this._events.post(ITenderDenominationCount.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 533 */     boolean ev_postable = false;
/*     */     
/* 535 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 536 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 537 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 538 */       ev_postable = true;
/*     */     } 
/*     */     
/* 541 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmount() {
/* 549 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 557 */     if (setAmount_noev(argAmount) && 
/* 558 */       this._events != null && 
/* 559 */       postEventsForChanges()) {
/* 560 */       this._events.post(ITenderDenominationCount.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 567 */     boolean ev_postable = false;
/*     */     
/* 569 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 570 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 571 */       getDAO_().setAmount(argAmount);
/* 572 */       ev_postable = true;
/*     */     } 
/*     */     
/* 575 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDifferenceAmount() {
/* 583 */     return getDAO_().getDifferenceAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDifferenceAmount(BigDecimal argDifferenceAmount) {
/* 591 */     if (setDifferenceAmount_noev(argDifferenceAmount) && 
/* 592 */       this._events != null && 
/* 593 */       postEventsForChanges()) {
/* 594 */       this._events.post(ITenderDenominationCount.SET_DIFFERENCEAMOUNT, argDifferenceAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDifferenceAmount_noev(BigDecimal argDifferenceAmount) {
/* 601 */     boolean ev_postable = false;
/*     */     
/* 603 */     if ((getDAO_().getDifferenceAmount() == null && argDifferenceAmount != null) || (
/* 604 */       getDAO_().getDifferenceAmount() != null && !getDAO_().getDifferenceAmount().equals(argDifferenceAmount))) {
/* 605 */       getDAO_().setDifferenceAmount(argDifferenceAmount);
/* 606 */       ev_postable = true;
/*     */     } 
/*     */     
/* 609 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDifferenceMediaCount() {
/* 617 */     if (getDAO_().getDifferenceMediaCount() != null) {
/* 618 */       return getDAO_().getDifferenceMediaCount().intValue();
/*     */     }
/*     */     
/* 621 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDifferenceMediaCount(int argDifferenceMediaCount) {
/* 630 */     if (setDifferenceMediaCount_noev(argDifferenceMediaCount) && 
/* 631 */       this._events != null && 
/* 632 */       postEventsForChanges()) {
/* 633 */       this._events.post(ITenderDenominationCount.SET_DIFFERENCEMEDIACOUNT, Integer.valueOf(argDifferenceMediaCount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDifferenceMediaCount_noev(int argDifferenceMediaCount) {
/* 640 */     boolean ev_postable = false;
/*     */     
/* 642 */     if ((getDAO_().getDifferenceMediaCount() == null && Integer.valueOf(argDifferenceMediaCount) != null) || (
/* 643 */       getDAO_().getDifferenceMediaCount() != null && !getDAO_().getDifferenceMediaCount().equals(Integer.valueOf(argDifferenceMediaCount)))) {
/* 644 */       getDAO_().setDifferenceMediaCount(Integer.valueOf(argDifferenceMediaCount));
/* 645 */       ev_postable = true;
/*     */     } 
/*     */     
/* 648 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMediaCount() {
/* 656 */     if (getDAO_().getMediaCount() != null) {
/* 657 */       return getDAO_().getMediaCount().intValue();
/*     */     }
/*     */     
/* 660 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMediaCount(int argMediaCount) {
/* 669 */     if (setMediaCount_noev(argMediaCount) && 
/* 670 */       this._events != null && 
/* 671 */       postEventsForChanges()) {
/* 672 */       this._events.post(ITenderDenominationCount.SET_MEDIACOUNT, Integer.valueOf(argMediaCount));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMediaCount_noev(int argMediaCount) {
/* 679 */     boolean ev_postable = false;
/*     */     
/* 681 */     if ((getDAO_().getMediaCount() == null && Integer.valueOf(argMediaCount) != null) || (
/* 682 */       getDAO_().getMediaCount() != null && !getDAO_().getMediaCount().equals(Integer.valueOf(argMediaCount)))) {
/* 683 */       getDAO_().setMediaCount(Integer.valueOf(argMediaCount));
/* 684 */       ev_postable = true;
/*     */     } 
/*     */     
/* 687 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITenderDenominationCountProperty newProperty(String argPropertyName) {
/* 691 */     TenderDenominationCountPropertyId id = new TenderDenominationCountPropertyId();
/*     */     
/* 693 */     id.setBusinessDayDate(getBusinessDayDate());
/* 694 */     id.setDenominationId(getDenominationId());
/* 695 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 696 */     id.setTenderId(getTenderId());
/* 697 */     id.setTenderTypeCode(getTenderTypeCode());
/* 698 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 699 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 700 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 702 */     ITenderDenominationCountProperty prop = (ITenderDenominationCountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderDenominationCountProperty.class);
/* 703 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "TenderDenomination")
/*     */   public ITenderDenomination getTenderDenomination() {
/* 715 */     return this._tenderDenomination;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTenderDenomination(ITenderDenomination argTenderDenomination) {
/* 720 */     if (argTenderDenomination == null) {
/*     */       
/* 722 */       if (this._tenderDenomination != null) {
/* 723 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*     */       }
/*     */       
/* 726 */       if (this._tenderDenomination != null)
/*     */       {
/* 728 */         if (postEventsForChanges()) {
/* 729 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._tenderDenomination));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 735 */     else if (postEventsForChanges()) {
/* 736 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenomination));
/*     */     } 
/*     */ 
/*     */     
/* 740 */     this._tenderDenomination = argTenderDenomination;
/* 741 */     if (postEventsForChanges()) {
/* 742 */       this._events.post(ITenderDenominationCount.SET_TENDERDENOMINATION, argTenderDenomination);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITenderDenominationCountProperty> getProperties() {
/* 748 */     if (this._properties == null) {
/* 749 */       this._properties = new HistoricalList(null);
/*     */     }
/* 751 */     return (List<ITenderDenominationCountProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITenderDenominationCountProperty> argProperties) {
/* 755 */     if (this._properties == null) {
/* 756 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 758 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 761 */     for (ITenderDenominationCountProperty child : this._properties) {
/* 762 */       TenderDenominationCountPropertyModel model = (TenderDenominationCountPropertyModel)child;
/* 763 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/* 764 */       model.setDenominationId_noev(getDenominationId());
/* 765 */       model.setOrganizationId_noev(getOrganizationId());
/* 766 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 767 */       model.setTenderId_noev(getTenderId());
/* 768 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/* 769 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 770 */       model.setWorkstationId_noev(getWorkstationId());
/* 771 */       if (child instanceof IDataModelImpl) {
/* 772 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 773 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 774 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 775 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 778 */       if (postEventsForChanges()) {
/* 779 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTenderDenominationCountProperty(ITenderDenominationCountProperty argTenderDenominationCountProperty) {
/* 785 */     if (this._properties == null) {
/* 786 */       this._properties = new HistoricalList(null);
/*     */     }
/* 788 */     argTenderDenominationCountProperty.setBusinessDayDate(getBusinessDayDate());
/* 789 */     argTenderDenominationCountProperty.setDenominationId(getDenominationId());
/* 790 */     argTenderDenominationCountProperty.setOrganizationId(getOrganizationId());
/* 791 */     argTenderDenominationCountProperty.setRetailLocationId(getRetailLocationId());
/* 792 */     argTenderDenominationCountProperty.setTenderId(getTenderId());
/* 793 */     argTenderDenominationCountProperty.setTenderTypeCode(getTenderTypeCode());
/* 794 */     argTenderDenominationCountProperty.setTransactionSequence(getTransactionSequence());
/* 795 */     argTenderDenominationCountProperty.setWorkstationId(getWorkstationId());
/* 796 */     if (argTenderDenominationCountProperty instanceof IDataModelImpl) {
/* 797 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderDenominationCountProperty).getDAO();
/* 798 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 799 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 800 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 805 */     if (postEventsForChanges()) {
/* 806 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenominationCountProperty));
/*     */     }
/*     */     
/* 809 */     this._properties.add(argTenderDenominationCountProperty);
/* 810 */     if (postEventsForChanges()) {
/* 811 */       this._events.post(ITenderDenominationCount.ADD_PROPERTIES, argTenderDenominationCountProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTenderDenominationCountProperty(ITenderDenominationCountProperty argTenderDenominationCountProperty) {
/* 816 */     if (this._properties != null) {
/*     */       
/* 818 */       if (postEventsForChanges()) {
/* 819 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenominationCountProperty));
/*     */       }
/* 821 */       this._properties.remove(argTenderDenominationCountProperty);
/* 822 */       if (postEventsForChanges()) {
/* 823 */         this._events.post(ITenderDenominationCount.REMOVE_PROPERTIES, argTenderDenominationCountProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTenderCount(ITenderCount argParentTenderCount) {
/* 829 */     this._parentTenderCount = argParentTenderCount;
/*     */   }
/*     */   
/*     */   public ITenderCount getParentTenderCount() {
/* 833 */     return this._parentTenderCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 838 */     if ("TenderDenomination".equals(argFieldId)) {
/* 839 */       return getTenderDenomination();
/*     */     }
/* 841 */     if ("Properties".equals(argFieldId)) {
/* 842 */       return getProperties();
/*     */     }
/* 844 */     if ("TenderDenominationCountExtension".equals(argFieldId)) {
/* 845 */       return this._myExtension;
/*     */     }
/*     */     
/* 848 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 854 */     if ("TenderDenomination".equals(argFieldId)) {
/* 855 */       setTenderDenomination((ITenderDenomination)argValue);
/*     */     }
/* 857 */     else if ("Properties".equals(argFieldId)) {
/* 858 */       setProperties(changeToList(argValue, ITenderDenominationCountProperty.class));
/*     */     }
/* 860 */     else if ("TenderDenominationCountExtension".equals(argFieldId)) {
/* 861 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 864 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 870 */     this._persistenceDefaults = argPD;
/* 871 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 872 */     this._eventManager = argEM;
/* 873 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 874 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 875 */     if (this._tenderDenomination != null) {
/* 876 */       ((IDataModelImpl)this._tenderDenomination).setDependencies(argPD, argEM);
/*     */     }
/* 878 */     if (this._properties != null) {
/* 879 */       for (ITenderDenominationCountProperty relationship : this._properties) {
/* 880 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTenderDenominationCountExt() {
/* 886 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTenderDenominationCountExt(IDataModel argExt) {
/* 890 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 895 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 899 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 902 */     super.startTransaction();
/*     */     
/* 904 */     this._tenderDenominationSavepoint = this._tenderDenomination;
/* 905 */     if (this._tenderDenomination != null) {
/* 906 */       this._tenderDenomination.startTransaction();
/*     */     }
/*     */     
/* 909 */     this._propertiesSavepoint = this._properties;
/* 910 */     if (this._properties != null) {
/* 911 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 912 */       Iterator<IDataModel> it = this._properties.iterator();
/* 913 */       while (it.hasNext()) {
/* 914 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 919 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 924 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 927 */     super.rollbackChanges();
/*     */     
/* 929 */     this._tenderDenomination = this._tenderDenominationSavepoint;
/* 930 */     this._tenderDenominationSavepoint = null;
/* 931 */     if (this._tenderDenomination != null) {
/* 932 */       this._tenderDenomination.rollbackChanges();
/*     */     }
/*     */     
/* 935 */     this._properties = this._propertiesSavepoint;
/* 936 */     this._propertiesSavepoint = null;
/* 937 */     if (this._properties != null) {
/* 938 */       Iterator<IDataModel> it = this._properties.iterator();
/* 939 */       while (it.hasNext()) {
/* 940 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 948 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 951 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 954 */     super.commitTransaction();
/*     */     
/* 956 */     this._tenderDenominationSavepoint = this._tenderDenomination;
/* 957 */     if (this._tenderDenomination != null) {
/* 958 */       this._tenderDenomination.commitTransaction();
/*     */     }
/*     */     
/* 961 */     this._propertiesSavepoint = this._properties;
/* 962 */     if (this._properties != null) {
/* 963 */       Iterator<IDataModel> it = this._properties.iterator();
/* 964 */       while (it.hasNext()) {
/* 965 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 967 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 971 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 976 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */