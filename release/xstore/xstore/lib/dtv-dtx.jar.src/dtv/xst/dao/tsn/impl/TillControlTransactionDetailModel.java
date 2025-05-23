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
/*     */ import dtv.xst.dao.tsn.ITenderRepository;
/*     */ import dtv.xst.dao.tsn.ITillControlTransaction;
/*     */ import dtv.xst.dao.tsn.ITillControlTransactionDetail;
/*     */ import dtv.xst.dao.tsn.ITillControlTransactionDetailProperty;
/*     */ import dtv.xst.dao.tsn.TillControlTransactionDetailPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TillControlTransactionDetailModel extends AbstractDataModelWithPropertyImpl<ITillControlTransactionDetailProperty> implements ITillControlTransactionDetail {
/*     */   private static final long serialVersionUID = 1585992935L;
/*     */   private ITillControlTransaction _parentTransaction;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private ITenderRepository _affectedTenderRepository; private transient ITenderRepository _affectedTenderRepositorySavepoint; private HistoricalList<ITillControlTransactionDetailProperty> _properties; private transient HistoricalList<ITillControlTransactionDetailProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new TillControlTransactionDetailDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TillControlTransactionDetailDAO getDAO_() {
/*  49 */     return (TillControlTransactionDetailDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(ITillControlTransactionDetail.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<TillControlTransactionDetailPropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((TillControlTransactionDetailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 104 */     if (getDAO_().getRetailLocationId() != null) {
/* 105 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 108 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 117 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(ITillControlTransactionDetail.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 130 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 131 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 132 */       ev_postable = true;
/* 133 */       if (this._properties != null) {
/*     */         
/* 135 */         Iterator<TillControlTransactionDetailPropertyModel> it = this._properties.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((TillControlTransactionDetailPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 151 */     if (getDAO_().getWorkstationId() != null) {
/* 152 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 155 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 164 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 165 */       this._events != null && 
/* 166 */       postEventsForChanges()) {
/* 167 */       this._events.post(ITillControlTransactionDetail.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 174 */     boolean ev_postable = false;
/*     */     
/* 176 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 177 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 178 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 179 */       ev_postable = true;
/* 180 */       if (this._properties != null) {
/*     */         
/* 182 */         Iterator<TillControlTransactionDetailPropertyModel> it = this._properties.iterator();
/* 183 */         while (it.hasNext())
/*     */         {
/* 185 */           ((TillControlTransactionDetailPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 190 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 198 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 206 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(ITillControlTransactionDetail.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 219 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 220 */       getDAO_().setBusinessDate(argBusinessDate);
/* 221 */       ev_postable = true;
/* 222 */       if (this._properties != null) {
/*     */         
/* 224 */         Iterator<TillControlTransactionDetailPropertyModel> it = this._properties.iterator();
/* 225 */         while (it.hasNext())
/*     */         {
/* 227 */           ((TillControlTransactionDetailPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*     */   public long getTransactionSequence() {
/* 240 */     if (getDAO_().getTransactionSequence() != null) {
/* 241 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 244 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 253 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(ITillControlTransactionDetail.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 266 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 267 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 268 */       ev_postable = true;
/* 269 */       if (this._properties != null) {
/*     */         
/* 271 */         Iterator<TillControlTransactionDetailPropertyModel> it = this._properties.iterator();
/* 272 */         while (it.hasNext())
/*     */         {
/* 274 */           ((TillControlTransactionDetailPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 279 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionLineItemSequence() {
/* 287 */     if (getDAO_().getTransactionLineItemSequence() != null) {
/* 288 */       return getDAO_().getTransactionLineItemSequence().longValue();
/*     */     }
/*     */     
/* 291 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionLineItemSequence(long argTransactionLineItemSequence) {
/* 300 */     if (setTransactionLineItemSequence_noev(argTransactionLineItemSequence) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(ITillControlTransactionDetail.SET_TRANSACTIONLINEITEMSEQUENCE, Long.valueOf(argTransactionLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionLineItemSequence_noev(long argTransactionLineItemSequence) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getTransactionLineItemSequence() == null && Long.valueOf(argTransactionLineItemSequence) != null) || (
/* 313 */       getDAO_().getTransactionLineItemSequence() != null && !getDAO_().getTransactionLineItemSequence().equals(Long.valueOf(argTransactionLineItemSequence)))) {
/* 314 */       getDAO_().setTransactionLineItemSequence(Long.valueOf(argTransactionLineItemSequence));
/* 315 */       ev_postable = true;
/* 316 */       if (this._properties != null) {
/*     */         
/* 318 */         Iterator<TillControlTransactionDetailPropertyModel> it = this._properties.iterator();
/* 319 */         while (it.hasNext())
/*     */         {
/* 321 */           ((TillControlTransactionDetailPropertyModel)it.next()).setTransactionLineItemSequence_noev(argTransactionLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 326 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 334 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 342 */     if (setCreateDate_noev(argCreateDate) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(ITillControlTransactionDetail.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 355 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 356 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 368 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 376 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(ITillControlTransactionDetail.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 389 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 390 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 402 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 410 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(ITillControlTransactionDetail.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 423 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 424 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 436 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 444 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 445 */       this._events != null && 
/* 446 */       postEventsForChanges()) {
/* 447 */       this._events.post(ITillControlTransactionDetail.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 454 */     boolean ev_postable = false;
/*     */     
/* 456 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 457 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 458 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 459 */       ev_postable = true;
/*     */     } 
/*     */     
/* 462 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAffectedTenderRepositoryId() {
/* 470 */     return getDAO_().getAffectedTenderRepositoryId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAffectedTenderRepositoryId(String argAffectedTenderRepositoryId) {
/* 478 */     if (setAffectedTenderRepositoryId_noev(argAffectedTenderRepositoryId) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(ITillControlTransactionDetail.SET_AFFECTEDTENDERREPOSITORYID, argAffectedTenderRepositoryId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAffectedTenderRepositoryId_noev(String argAffectedTenderRepositoryId) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getAffectedTenderRepositoryId() == null && argAffectedTenderRepositoryId != null) || (
/* 491 */       getDAO_().getAffectedTenderRepositoryId() != null && !getDAO_().getAffectedTenderRepositoryId().equals(argAffectedTenderRepositoryId))) {
/* 492 */       getDAO_().setAffectedTenderRepositoryId(argAffectedTenderRepositoryId);
/* 493 */       ev_postable = true;
/*     */     } 
/*     */     
/* 496 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAffectedWorkstationId() {
/* 504 */     if (getDAO_().getAffectedWorkstationId() != null) {
/* 505 */       return getDAO_().getAffectedWorkstationId().longValue();
/*     */     }
/*     */     
/* 508 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAffectedWorkstationId(long argAffectedWorkstationId) {
/* 517 */     if (setAffectedWorkstationId_noev(argAffectedWorkstationId) && 
/* 518 */       this._events != null && 
/* 519 */       postEventsForChanges()) {
/* 520 */       this._events.post(ITillControlTransactionDetail.SET_AFFECTEDWORKSTATIONID, Long.valueOf(argAffectedWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAffectedWorkstationId_noev(long argAffectedWorkstationId) {
/* 527 */     boolean ev_postable = false;
/*     */     
/* 529 */     if ((getDAO_().getAffectedWorkstationId() == null && Long.valueOf(argAffectedWorkstationId) != null) || (
/* 530 */       getDAO_().getAffectedWorkstationId() != null && !getDAO_().getAffectedWorkstationId().equals(Long.valueOf(argAffectedWorkstationId)))) {
/* 531 */       getDAO_().setAffectedWorkstationId(Long.valueOf(argAffectedWorkstationId));
/* 532 */       ev_postable = true;
/*     */     } 
/*     */     
/* 535 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrencyId() {
/* 543 */     return getDAO_().getCurrencyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 551 */     if (setCurrencyId_noev(argCurrencyId) && 
/* 552 */       this._events != null && 
/* 553 */       postEventsForChanges()) {
/* 554 */       this._events.post(ITillControlTransactionDetail.SET_CURRENCYID, argCurrencyId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCurrencyId_noev(String argCurrencyId) {
/* 561 */     boolean ev_postable = false;
/*     */     
/* 563 */     if ((getDAO_().getCurrencyId() == null && argCurrencyId != null) || (
/* 564 */       getDAO_().getCurrencyId() != null && !getDAO_().getCurrencyId().equals(argCurrencyId))) {
/* 565 */       getDAO_().setCurrencyId(argCurrencyId);
/* 566 */       ev_postable = true;
/*     */     } 
/*     */     
/* 569 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOldAmount() {
/* 577 */     return getDAO_().getOldAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOldAmount(BigDecimal argOldAmount) {
/* 585 */     if (setOldAmount_noev(argOldAmount) && 
/* 586 */       this._events != null && 
/* 587 */       postEventsForChanges()) {
/* 588 */       this._events.post(ITillControlTransactionDetail.SET_OLDAMOUNT, argOldAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOldAmount_noev(BigDecimal argOldAmount) {
/* 595 */     boolean ev_postable = false;
/*     */     
/* 597 */     if ((getDAO_().getOldAmount() == null && argOldAmount != null) || (
/* 598 */       getDAO_().getOldAmount() != null && !getDAO_().getOldAmount().equals(argOldAmount))) {
/* 599 */       getDAO_().setOldAmount(argOldAmount);
/* 600 */       ev_postable = true;
/*     */     } 
/*     */     
/* 603 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getNewAmount() {
/* 611 */     return getDAO_().getNewAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewAmount(BigDecimal argNewAmount) {
/* 619 */     if (setNewAmount_noev(argNewAmount) && 
/* 620 */       this._events != null && 
/* 621 */       postEventsForChanges()) {
/* 622 */       this._events.post(ITillControlTransactionDetail.SET_NEWAMOUNT, argNewAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNewAmount_noev(BigDecimal argNewAmount) {
/* 629 */     boolean ev_postable = false;
/*     */     
/* 631 */     if ((getDAO_().getNewAmount() == null && argNewAmount != null) || (
/* 632 */       getDAO_().getNewAmount() != null && !getDAO_().getNewAmount().equals(argNewAmount))) {
/* 633 */       getDAO_().setNewAmount(argNewAmount);
/* 634 */       ev_postable = true;
/*     */     } 
/*     */     
/* 637 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITillControlTransactionDetailProperty newProperty(String argPropertyName) {
/* 641 */     TillControlTransactionDetailPropertyId id = new TillControlTransactionDetailPropertyId();
/*     */     
/* 643 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 644 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 645 */     id.setBusinessDate(getBusinessDate());
/* 646 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 647 */     id.setTransactionLineItemSequence(Long.valueOf(getTransactionLineItemSequence()));
/* 648 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 650 */     ITillControlTransactionDetailProperty prop = (ITillControlTransactionDetailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITillControlTransactionDetailProperty.class);
/* 651 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "AffectedTenderRepository")
/*     */   public ITenderRepository getAffectedTenderRepository() {
/* 663 */     return this._affectedTenderRepository;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAffectedTenderRepository(ITenderRepository argAffectedTenderRepository) {
/* 668 */     if (argAffectedTenderRepository == null) {
/*     */       
/* 670 */       getDAO_().setAffectedTenderRepositoryId(null);
/* 671 */       if (this._affectedTenderRepository != null)
/*     */       {
/* 673 */         if (postEventsForChanges()) {
/* 674 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._affectedTenderRepository));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 679 */       getDAO_().setAffectedTenderRepositoryId(argAffectedTenderRepository.getTenderRepositoryId());
/*     */       
/* 681 */       if (postEventsForChanges()) {
/* 682 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argAffectedTenderRepository));
/*     */       }
/*     */     } 
/*     */     
/* 686 */     this._affectedTenderRepository = argAffectedTenderRepository;
/* 687 */     if (postEventsForChanges()) {
/* 688 */       this._events.post(ITillControlTransactionDetail.SET_AFFECTEDTENDERREPOSITORY, argAffectedTenderRepository);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITillControlTransactionDetailProperty> getProperties() {
/* 694 */     if (this._properties == null) {
/* 695 */       this._properties = new HistoricalList(null);
/*     */     }
/* 697 */     return (List<ITillControlTransactionDetailProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITillControlTransactionDetailProperty> argProperties) {
/* 701 */     if (this._properties == null) {
/* 702 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 704 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 707 */     for (ITillControlTransactionDetailProperty child : this._properties) {
/* 708 */       TillControlTransactionDetailPropertyModel model = (TillControlTransactionDetailPropertyModel)child;
/* 709 */       model.setOrganizationId_noev(getOrganizationId());
/* 710 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 711 */       model.setWorkstationId_noev(getWorkstationId());
/* 712 */       model.setBusinessDate_noev(getBusinessDate());
/* 713 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 714 */       model.setTransactionLineItemSequence_noev(getTransactionLineItemSequence());
/* 715 */       if (child instanceof IDataModelImpl) {
/* 716 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 717 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 718 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 719 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 722 */       if (postEventsForChanges()) {
/* 723 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTillControlTransactionDetailProperty(ITillControlTransactionDetailProperty argTillControlTransactionDetailProperty) {
/* 729 */     if (this._properties == null) {
/* 730 */       this._properties = new HistoricalList(null);
/*     */     }
/* 732 */     argTillControlTransactionDetailProperty.setOrganizationId(getOrganizationId());
/* 733 */     argTillControlTransactionDetailProperty.setRetailLocationId(getRetailLocationId());
/* 734 */     argTillControlTransactionDetailProperty.setWorkstationId(getWorkstationId());
/* 735 */     argTillControlTransactionDetailProperty.setBusinessDate(getBusinessDate());
/* 736 */     argTillControlTransactionDetailProperty.setTransactionSequence(getTransactionSequence());
/* 737 */     argTillControlTransactionDetailProperty.setTransactionLineItemSequence(getTransactionLineItemSequence());
/* 738 */     if (argTillControlTransactionDetailProperty instanceof IDataModelImpl) {
/* 739 */       IDataAccessObject childDao = ((IDataModelImpl)argTillControlTransactionDetailProperty).getDAO();
/* 740 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 741 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 742 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 747 */     if (postEventsForChanges()) {
/* 748 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTillControlTransactionDetailProperty));
/*     */     }
/*     */     
/* 751 */     this._properties.add(argTillControlTransactionDetailProperty);
/* 752 */     if (postEventsForChanges()) {
/* 753 */       this._events.post(ITillControlTransactionDetail.ADD_PROPERTIES, argTillControlTransactionDetailProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTillControlTransactionDetailProperty(ITillControlTransactionDetailProperty argTillControlTransactionDetailProperty) {
/* 758 */     if (this._properties != null) {
/*     */       
/* 760 */       if (postEventsForChanges()) {
/* 761 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTillControlTransactionDetailProperty));
/*     */       }
/* 763 */       this._properties.remove(argTillControlTransactionDetailProperty);
/* 764 */       if (postEventsForChanges()) {
/* 765 */         this._events.post(ITillControlTransactionDetail.REMOVE_PROPERTIES, argTillControlTransactionDetailProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTransaction(ITillControlTransaction argParentTransaction) {
/* 771 */     this._parentTransaction = argParentTransaction;
/*     */   }
/*     */   
/*     */   public ITillControlTransaction getParentTransaction() {
/* 775 */     return this._parentTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 780 */     if ("AffectedTenderRepository".equals(argFieldId)) {
/* 781 */       return getAffectedTenderRepository();
/*     */     }
/* 783 */     if ("Properties".equals(argFieldId)) {
/* 784 */       return getProperties();
/*     */     }
/* 786 */     if ("TillControlTransactionDetailExtension".equals(argFieldId)) {
/* 787 */       return this._myExtension;
/*     */     }
/*     */     
/* 790 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 796 */     if ("AffectedTenderRepository".equals(argFieldId)) {
/* 797 */       setAffectedTenderRepository((ITenderRepository)argValue);
/*     */     }
/* 799 */     else if ("Properties".equals(argFieldId)) {
/* 800 */       setProperties(changeToList(argValue, ITillControlTransactionDetailProperty.class));
/*     */     }
/* 802 */     else if ("TillControlTransactionDetailExtension".equals(argFieldId)) {
/* 803 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 806 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 812 */     this._persistenceDefaults = argPD;
/* 813 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 814 */     this._eventManager = argEM;
/* 815 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 816 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 817 */     if (this._affectedTenderRepository != null) {
/* 818 */       ((IDataModelImpl)this._affectedTenderRepository).setDependencies(argPD, argEM);
/*     */     }
/* 820 */     if (this._properties != null) {
/* 821 */       for (ITillControlTransactionDetailProperty relationship : this._properties) {
/* 822 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTillControlTransactionDetailExt() {
/* 828 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTillControlTransactionDetailExt(IDataModel argExt) {
/* 832 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 837 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 841 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 844 */     super.startTransaction();
/*     */     
/* 846 */     this._affectedTenderRepositorySavepoint = this._affectedTenderRepository;
/* 847 */     if (this._affectedTenderRepository != null) {
/* 848 */       this._affectedTenderRepository.startTransaction();
/*     */     }
/*     */     
/* 851 */     this._propertiesSavepoint = this._properties;
/* 852 */     if (this._properties != null) {
/* 853 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 854 */       Iterator<IDataModel> it = this._properties.iterator();
/* 855 */       while (it.hasNext()) {
/* 856 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 861 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 866 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 869 */     super.rollbackChanges();
/*     */     
/* 871 */     this._affectedTenderRepository = this._affectedTenderRepositorySavepoint;
/* 872 */     this._affectedTenderRepositorySavepoint = null;
/* 873 */     if (this._affectedTenderRepository != null) {
/* 874 */       this._affectedTenderRepository.rollbackChanges();
/*     */     }
/*     */     
/* 877 */     this._properties = this._propertiesSavepoint;
/* 878 */     this._propertiesSavepoint = null;
/* 879 */     if (this._properties != null) {
/* 880 */       Iterator<IDataModel> it = this._properties.iterator();
/* 881 */       while (it.hasNext()) {
/* 882 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 890 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 893 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 896 */     super.commitTransaction();
/*     */     
/* 898 */     this._affectedTenderRepositorySavepoint = this._affectedTenderRepository;
/* 899 */     if (this._affectedTenderRepository != null) {
/* 900 */       this._affectedTenderRepository.commitTransaction();
/*     */     }
/*     */     
/* 903 */     this._propertiesSavepoint = this._properties;
/* 904 */     if (this._properties != null) {
/* 905 */       Iterator<IDataModel> it = this._properties.iterator();
/* 906 */       while (it.hasNext()) {
/* 907 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 909 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 913 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 918 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TillControlTransactionDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */