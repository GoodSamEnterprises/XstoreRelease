/*     */ package dtv.xst.dao.tsn.impl;
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
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.tsn.ExchangeRateTransLineItemPropertyId;
/*     */ import dtv.xst.dao.tsn.IExchangeRateTransLineItem;
/*     */ import dtv.xst.dao.tsn.IExchangeRateTransLineItemProperty;
/*     */ import dtv.xst.dao.tsn.IExchangeRateTransaction;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ExchangeRateTransLineItemModel extends AbstractDataModelWithPropertyImpl<IExchangeRateTransLineItemProperty> implements IExchangeRateTransLineItem {
/*     */   private static final long serialVersionUID = -835436820L;
/*     */   private IExchangeRateTransaction _parentTransaction;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IExchangeRateTransLineItemProperty> _properties; private transient HistoricalList<IExchangeRateTransLineItemProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new ExchangeRateTransLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ExchangeRateTransLineItemDAO getDAO_() {
/*  48 */     return (ExchangeRateTransLineItemDAO)this._daoImpl;
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
/*  72 */       this._events.post(IExchangeRateTransLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<ExchangeRateTransLineItemPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((ExchangeRateTransLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public long getRetailLocationId() {
/* 103 */     if (getDAO_().getRetailLocationId() != null) {
/* 104 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 107 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 117 */       this._events != null && 
/* 118 */       postEventsForChanges()) {
/* 119 */       this._events.post(IExchangeRateTransLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 126 */     boolean ev_postable = false;
/*     */     
/* 128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 131 */       ev_postable = true;
/* 132 */       if (this._properties != null) {
/*     */         
/* 134 */         Iterator<ExchangeRateTransLineItemPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((ExchangeRateTransLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 150 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 158 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IExchangeRateTransLineItem.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 171 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 172 */       getDAO_().setBusinessDate(argBusinessDate);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<ExchangeRateTransLineItemPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((ExchangeRateTransLineItemPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 192 */     if (getDAO_().getWorkstationId() != null) {
/* 193 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 196 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 205 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 206 */       this._events != null && 
/* 207 */       postEventsForChanges()) {
/* 208 */       this._events.post(IExchangeRateTransLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 215 */     boolean ev_postable = false;
/*     */     
/* 217 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 218 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 219 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 220 */       ev_postable = true;
/* 221 */       if (this._properties != null) {
/*     */         
/* 223 */         Iterator<ExchangeRateTransLineItemPropertyModel> it = this._properties.iterator();
/* 224 */         while (it.hasNext())
/*     */         {
/* 226 */           ((ExchangeRateTransLineItemPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 239 */     if (getDAO_().getTransactionSequence() != null) {
/* 240 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 243 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 252 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 253 */       this._events != null && 
/* 254 */       postEventsForChanges()) {
/* 255 */       this._events.post(IExchangeRateTransLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 262 */     boolean ev_postable = false;
/*     */     
/* 264 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 265 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 266 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 267 */       ev_postable = true;
/* 268 */       if (this._properties != null) {
/*     */         
/* 270 */         Iterator<ExchangeRateTransLineItemPropertyModel> it = this._properties.iterator();
/* 271 */         while (it.hasNext())
/*     */         {
/* 273 */           ((ExchangeRateTransLineItemPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineItemSequence() {
/* 286 */     if (getDAO_().getLineItemSequence() != null) {
/* 287 */       return getDAO_().getLineItemSequence().intValue();
/*     */     }
/*     */     
/* 290 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineItemSequence(int argLineItemSequence) {
/* 299 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/* 300 */       this._events != null && 
/* 301 */       postEventsForChanges()) {
/* 302 */       this._events.post(IExchangeRateTransLineItem.SET_LINEITEMSEQUENCE, Integer.valueOf(argLineItemSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLineItemSequence_noev(int argLineItemSequence) {
/* 309 */     boolean ev_postable = false;
/*     */     
/* 311 */     if ((getDAO_().getLineItemSequence() == null && Integer.valueOf(argLineItemSequence) != null) || (
/* 312 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Integer.valueOf(argLineItemSequence)))) {
/* 313 */       getDAO_().setLineItemSequence(Integer.valueOf(argLineItemSequence));
/* 314 */       ev_postable = true;
/* 315 */       if (this._properties != null) {
/*     */         
/* 317 */         Iterator<ExchangeRateTransLineItemPropertyModel> it = this._properties.iterator();
/* 318 */         while (it.hasNext())
/*     */         {
/* 320 */           ((ExchangeRateTransLineItemPropertyModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 325 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 333 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 341 */     if (setCreateDate_noev(argCreateDate) && 
/* 342 */       this._events != null && 
/* 343 */       postEventsForChanges()) {
/* 344 */       this._events.post(IExchangeRateTransLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 351 */     boolean ev_postable = false;
/*     */     
/* 353 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 354 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 355 */       getDAO_().setCreateDate(argCreateDate);
/* 356 */       ev_postable = true;
/*     */     } 
/*     */     
/* 359 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 367 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 375 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 376 */       this._events != null && 
/* 377 */       postEventsForChanges()) {
/* 378 */       this._events.post(IExchangeRateTransLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 385 */     boolean ev_postable = false;
/*     */     
/* 387 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 388 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 389 */       getDAO_().setCreateUserId(argCreateUserId);
/* 390 */       ev_postable = true;
/*     */     } 
/*     */     
/* 393 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 401 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 409 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 410 */       this._events != null && 
/* 411 */       postEventsForChanges()) {
/* 412 */       this._events.post(IExchangeRateTransLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 419 */     boolean ev_postable = false;
/*     */     
/* 421 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 422 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 423 */       getDAO_().setUpdateDate(argUpdateDate);
/* 424 */       ev_postable = true;
/*     */     } 
/*     */     
/* 427 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 435 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 443 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 444 */       this._events != null && 
/* 445 */       postEventsForChanges()) {
/* 446 */       this._events.post(IExchangeRateTransLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 453 */     boolean ev_postable = false;
/*     */     
/* 455 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 456 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 457 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 458 */       ev_postable = true;
/*     */     } 
/*     */     
/* 461 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBaseCurrency() {
/* 469 */     return getDAO_().getBaseCurrency();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseCurrency(String argBaseCurrency) {
/* 477 */     if (setBaseCurrency_noev(argBaseCurrency) && 
/* 478 */       this._events != null && 
/* 479 */       postEventsForChanges()) {
/* 480 */       this._events.post(IExchangeRateTransLineItem.SET_BASECURRENCY, argBaseCurrency);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBaseCurrency_noev(String argBaseCurrency) {
/* 487 */     boolean ev_postable = false;
/*     */     
/* 489 */     if ((getDAO_().getBaseCurrency() == null && argBaseCurrency != null) || (
/* 490 */       getDAO_().getBaseCurrency() != null && !getDAO_().getBaseCurrency().equals(argBaseCurrency))) {
/* 491 */       getDAO_().setBaseCurrency(argBaseCurrency);
/* 492 */       ev_postable = true;
/*     */     } 
/*     */     
/* 495 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTargetCurrency() {
/* 503 */     return getDAO_().getTargetCurrency();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTargetCurrency(String argTargetCurrency) {
/* 511 */     if (setTargetCurrency_noev(argTargetCurrency) && 
/* 512 */       this._events != null && 
/* 513 */       postEventsForChanges()) {
/* 514 */       this._events.post(IExchangeRateTransLineItem.SET_TARGETCURRENCY, argTargetCurrency);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTargetCurrency_noev(String argTargetCurrency) {
/* 521 */     boolean ev_postable = false;
/*     */     
/* 523 */     if ((getDAO_().getTargetCurrency() == null && argTargetCurrency != null) || (
/* 524 */       getDAO_().getTargetCurrency() != null && !getDAO_().getTargetCurrency().equals(argTargetCurrency))) {
/* 525 */       getDAO_().setTargetCurrency(argTargetCurrency);
/* 526 */       ev_postable = true;
/*     */     } 
/*     */     
/* 529 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getOldExchangeRate() {
/* 537 */     return getDAO_().getOldExchangeRate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOldExchangeRate(BigDecimal argOldExchangeRate) {
/* 545 */     if (setOldExchangeRate_noev(argOldExchangeRate) && 
/* 546 */       this._events != null && 
/* 547 */       postEventsForChanges()) {
/* 548 */       this._events.post(IExchangeRateTransLineItem.SET_OLDEXCHANGERATE, argOldExchangeRate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOldExchangeRate_noev(BigDecimal argOldExchangeRate) {
/* 555 */     boolean ev_postable = false;
/*     */     
/* 557 */     if ((getDAO_().getOldExchangeRate() == null && argOldExchangeRate != null) || (
/* 558 */       getDAO_().getOldExchangeRate() != null && !getDAO_().getOldExchangeRate().equals(argOldExchangeRate))) {
/* 559 */       getDAO_().setOldExchangeRate(argOldExchangeRate);
/* 560 */       ev_postable = true;
/*     */     } 
/*     */     
/* 563 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getNewExchangeRate() {
/* 571 */     return getDAO_().getNewExchangeRate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewExchangeRate(BigDecimal argNewExchangeRate) {
/* 579 */     if (setNewExchangeRate_noev(argNewExchangeRate) && 
/* 580 */       this._events != null && 
/* 581 */       postEventsForChanges()) {
/* 582 */       this._events.post(IExchangeRateTransLineItem.SET_NEWEXCHANGERATE, argNewExchangeRate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNewExchangeRate_noev(BigDecimal argNewExchangeRate) {
/* 589 */     boolean ev_postable = false;
/*     */     
/* 591 */     if ((getDAO_().getNewExchangeRate() == null && argNewExchangeRate != null) || (
/* 592 */       getDAO_().getNewExchangeRate() != null && !getDAO_().getNewExchangeRate().equals(argNewExchangeRate))) {
/* 593 */       getDAO_().setNewExchangeRate(argNewExchangeRate);
/* 594 */       ev_postable = true;
/*     */     } 
/*     */     
/* 597 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNotes() {
/* 605 */     return getDAO_().getNotes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotes(String argNotes) {
/* 613 */     if (setNotes_noev(argNotes) && 
/* 614 */       this._events != null && 
/* 615 */       postEventsForChanges()) {
/* 616 */       this._events.post(IExchangeRateTransLineItem.SET_NOTES, argNotes);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNotes_noev(String argNotes) {
/* 623 */     boolean ev_postable = false;
/*     */     
/* 625 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/* 626 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/* 627 */       getDAO_().setNotes(argNotes);
/* 628 */       ev_postable = true;
/*     */     } 
/*     */     
/* 631 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IExchangeRateTransLineItemProperty newProperty(String argPropertyName) {
/* 635 */     ExchangeRateTransLineItemPropertyId id = new ExchangeRateTransLineItemPropertyId();
/*     */     
/* 637 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 638 */     id.setBusinessDate(getBusinessDate());
/* 639 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 640 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 641 */     id.setLineItemSequence(Integer.valueOf(getLineItemSequence()));
/* 642 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 644 */     IExchangeRateTransLineItemProperty prop = (IExchangeRateTransLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IExchangeRateTransLineItemProperty.class);
/* 645 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IExchangeRateTransLineItemProperty> getProperties() {
/* 654 */     if (this._properties == null) {
/* 655 */       this._properties = new HistoricalList(null);
/*     */     }
/* 657 */     return (List<IExchangeRateTransLineItemProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IExchangeRateTransLineItemProperty> argProperties) {
/* 661 */     if (this._properties == null) {
/* 662 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 664 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 667 */     for (IExchangeRateTransLineItemProperty child : this._properties) {
/* 668 */       ExchangeRateTransLineItemPropertyModel model = (ExchangeRateTransLineItemPropertyModel)child;
/* 669 */       model.setOrganizationId_noev(getOrganizationId());
/* 670 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 671 */       model.setBusinessDate_noev(getBusinessDate());
/* 672 */       model.setWorkstationId_noev(getWorkstationId());
/* 673 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 674 */       model.setLineItemSequence_noev(getLineItemSequence());
/* 675 */       if (child instanceof IDataModelImpl) {
/* 676 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 677 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 678 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 679 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 682 */       if (postEventsForChanges()) {
/* 683 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addExchangeRateTransLineItemProperty(IExchangeRateTransLineItemProperty argExchangeRateTransLineItemProperty) {
/* 689 */     if (this._properties == null) {
/* 690 */       this._properties = new HistoricalList(null);
/*     */     }
/* 692 */     argExchangeRateTransLineItemProperty.setOrganizationId(getOrganizationId());
/* 693 */     argExchangeRateTransLineItemProperty.setRetailLocationId(getRetailLocationId());
/* 694 */     argExchangeRateTransLineItemProperty.setBusinessDate(getBusinessDate());
/* 695 */     argExchangeRateTransLineItemProperty.setWorkstationId(getWorkstationId());
/* 696 */     argExchangeRateTransLineItemProperty.setTransactionSequence(getTransactionSequence());
/* 697 */     argExchangeRateTransLineItemProperty.setLineItemSequence(getLineItemSequence());
/* 698 */     if (argExchangeRateTransLineItemProperty instanceof IDataModelImpl) {
/* 699 */       IDataAccessObject childDao = ((IDataModelImpl)argExchangeRateTransLineItemProperty).getDAO();
/* 700 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 701 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 702 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 707 */     if (postEventsForChanges()) {
/* 708 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argExchangeRateTransLineItemProperty));
/*     */     }
/*     */     
/* 711 */     this._properties.add(argExchangeRateTransLineItemProperty);
/* 712 */     if (postEventsForChanges()) {
/* 713 */       this._events.post(IExchangeRateTransLineItem.ADD_PROPERTIES, argExchangeRateTransLineItemProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeExchangeRateTransLineItemProperty(IExchangeRateTransLineItemProperty argExchangeRateTransLineItemProperty) {
/* 718 */     if (this._properties != null) {
/*     */       
/* 720 */       if (postEventsForChanges()) {
/* 721 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argExchangeRateTransLineItemProperty));
/*     */       }
/* 723 */       this._properties.remove(argExchangeRateTransLineItemProperty);
/* 724 */       if (postEventsForChanges()) {
/* 725 */         this._events.post(IExchangeRateTransLineItem.REMOVE_PROPERTIES, argExchangeRateTransLineItemProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentTransaction(IExchangeRateTransaction argParentTransaction) {
/* 731 */     this._parentTransaction = argParentTransaction;
/*     */   }
/*     */   
/*     */   public IExchangeRateTransaction getParentTransaction() {
/* 735 */     return this._parentTransaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 740 */     if ("Properties".equals(argFieldId)) {
/* 741 */       return getProperties();
/*     */     }
/* 743 */     if ("ExchangeRateTransLineItemExtension".equals(argFieldId)) {
/* 744 */       return this._myExtension;
/*     */     }
/*     */     
/* 747 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 753 */     if ("Properties".equals(argFieldId)) {
/* 754 */       setProperties(changeToList(argValue, IExchangeRateTransLineItemProperty.class));
/*     */     }
/* 756 */     else if ("ExchangeRateTransLineItemExtension".equals(argFieldId)) {
/* 757 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 760 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 766 */     this._persistenceDefaults = argPD;
/* 767 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 768 */     this._eventManager = argEM;
/* 769 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 770 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 771 */     if (this._properties != null) {
/* 772 */       for (IExchangeRateTransLineItemProperty relationship : this._properties) {
/* 773 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getExchangeRateTransLineItemExt() {
/* 779 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setExchangeRateTransLineItemExt(IDataModel argExt) {
/* 783 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 788 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 792 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 795 */     super.startTransaction();
/*     */     
/* 797 */     this._propertiesSavepoint = this._properties;
/* 798 */     if (this._properties != null) {
/* 799 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 800 */       Iterator<IDataModel> it = this._properties.iterator();
/* 801 */       while (it.hasNext()) {
/* 802 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 807 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 812 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 815 */     super.rollbackChanges();
/*     */     
/* 817 */     this._properties = this._propertiesSavepoint;
/* 818 */     this._propertiesSavepoint = null;
/* 819 */     if (this._properties != null) {
/* 820 */       Iterator<IDataModel> it = this._properties.iterator();
/* 821 */       while (it.hasNext()) {
/* 822 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 830 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 833 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 836 */     super.commitTransaction();
/*     */     
/* 838 */     this._propertiesSavepoint = this._properties;
/* 839 */     if (this._properties != null) {
/* 840 */       Iterator<IDataModel> it = this._properties.iterator();
/* 841 */       while (it.hasNext()) {
/* 842 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 844 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 848 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 853 */     argStream.defaultReadObject();
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
/*     */   public String getTargetCurrencyDesc() {
/* 866 */     return FormattableFactory.getInstance().getTranslatable("_currency" + 
/* 867 */         getTargetCurrency()).toString(OutputContextType.RECEIPT);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\ExchangeRateTransLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */