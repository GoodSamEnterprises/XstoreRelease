/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.xst.dao.dsc.IDiscount;
/*     */ import dtv.xst.dao.trl.IDiscountLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class DiscountLineItemModel
/*     */   extends RetailTransactionLineItemModel
/*     */   implements IDiscountLineItem
/*     */ {
/*     */   private static final long serialVersionUID = 1289146792L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   private IDiscount _lineItemDiscount;
/*     */   private transient IDiscount _lineItemDiscountSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  31 */     setDAO((IDataAccessObject)new DiscountLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DiscountLineItemDAO getDAO_() {
/*  39 */     return (DiscountLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  47 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  55 */     if (setCreateDate_noev(argCreateDate) && 
/*  56 */       this._events != null && 
/*  57 */       postEventsForChanges()) {
/*  58 */       this._events.post(IDiscountLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  65 */     boolean ev_postable = false;
/*     */     
/*  67 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  68 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  69 */       getDAO_().setCreateDate(argCreateDate);
/*  70 */       ev_postable = true;
/*     */     } 
/*     */     
/*  73 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  81 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  89 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  90 */       this._events != null && 
/*  91 */       postEventsForChanges()) {
/*  92 */       this._events.post(IDiscountLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  99 */     boolean ev_postable = false;
/*     */     
/* 101 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 102 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 103 */       getDAO_().setCreateUserId(argCreateUserId);
/* 104 */       ev_postable = true;
/*     */     } 
/*     */     
/* 107 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 115 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 123 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 124 */       this._events != null && 
/* 125 */       postEventsForChanges()) {
/* 126 */       this._events.post(IDiscountLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 133 */     boolean ev_postable = false;
/*     */     
/* 135 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 136 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 137 */       getDAO_().setUpdateDate(argUpdateDate);
/* 138 */       ev_postable = true;
/*     */     } 
/*     */     
/* 141 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 149 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 157 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(IDiscountLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 170 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 171 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 172 */       ev_postable = true;
/*     */     } 
/*     */     
/* 175 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getAmountImpl() {
/* 183 */     return getDAO_().getAmount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setAmountImpl(BigDecimal argAmount) {
/* 191 */     if (setAmount_noev(argAmount) && 
/* 192 */       this._events != null && 
/* 193 */       postEventsForChanges()) {
/* 194 */       this._events.post(IDiscountLineItem.SET_AMOUNT, argAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmount_noev(BigDecimal argAmount) {
/* 201 */     boolean ev_postable = false;
/*     */     
/* 203 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/* 204 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/* 205 */       getDAO_().setAmount(argAmount);
/* 206 */       ev_postable = true;
/*     */     } 
/*     */     
/* 209 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getPercent() {
/* 217 */     return getDAO_().getPercent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPercent(BigDecimal argPercent) {
/* 225 */     if (setPercent_noev(argPercent) && 
/* 226 */       this._events != null && 
/* 227 */       postEventsForChanges()) {
/* 228 */       this._events.post(IDiscountLineItem.SET_PERCENT, argPercent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPercent_noev(BigDecimal argPercent) {
/* 235 */     boolean ev_postable = false;
/*     */     
/* 237 */     if ((getDAO_().getPercent() == null && argPercent != null) || (
/* 238 */       getDAO_().getPercent() != null && !getDAO_().getPercent().equals(argPercent))) {
/* 239 */       getDAO_().setPercent(argPercent);
/* 240 */       ev_postable = true;
/*     */     } 
/*     */     
/* 243 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigDecimal getNewPriceImpl() {
/* 251 */     return getDAO_().getNewPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setNewPriceImpl(BigDecimal argNewPrice) {
/* 259 */     if (setNewPrice_noev(argNewPrice) && 
/* 260 */       this._events != null && 
/* 261 */       postEventsForChanges()) {
/* 262 */       this._events.post(IDiscountLineItem.SET_NEWPRICE, argNewPrice);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNewPrice_noev(BigDecimal argNewPrice) {
/* 269 */     boolean ev_postable = false;
/*     */     
/* 271 */     if ((getDAO_().getNewPrice() == null && argNewPrice != null) || (
/* 272 */       getDAO_().getNewPrice() != null && !getDAO_().getNewPrice().equals(argNewPrice))) {
/* 273 */       getDAO_().setNewPrice(argNewPrice);
/* 274 */       ev_postable = true;
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getNewPriceQuantity() {
/* 285 */     return getDAO_().getNewPriceQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewPriceQuantity(BigDecimal argNewPriceQuantity) {
/* 293 */     if (setNewPriceQuantity_noev(argNewPriceQuantity) && 
/* 294 */       this._events != null && 
/* 295 */       postEventsForChanges()) {
/* 296 */       this._events.post(IDiscountLineItem.SET_NEWPRICEQUANTITY, argNewPriceQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNewPriceQuantity_noev(BigDecimal argNewPriceQuantity) {
/* 303 */     boolean ev_postable = false;
/*     */     
/* 305 */     if ((getDAO_().getNewPriceQuantity() == null && argNewPriceQuantity != null) || (
/* 306 */       getDAO_().getNewPriceQuantity() != null && !getDAO_().getNewPriceQuantity().equals(argNewPriceQuantity))) {
/* 307 */       getDAO_().setNewPriceQuantity(argNewPriceQuantity);
/* 308 */       ev_postable = true;
/*     */     } 
/*     */     
/* 311 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 319 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 327 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 328 */       this._events != null && 
/* 329 */       postEventsForChanges()) {
/* 330 */       this._events.post(IDiscountLineItem.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 337 */     boolean ev_postable = false;
/*     */     
/* 339 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 340 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 341 */       getDAO_().setSerialNumber(argSerialNumber);
/* 342 */       ev_postable = true;
/*     */     } 
/*     */     
/* 345 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiscountCode() {
/* 353 */     return getDAO_().getDiscountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/* 361 */     if (setDiscountCode_noev(argDiscountCode) && 
/* 362 */       this._events != null && 
/* 363 */       postEventsForChanges()) {
/* 364 */       this._events.post(IDiscountLineItem.SET_DISCOUNTCODE, argDiscountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDiscountCode_noev(String argDiscountCode) {
/* 371 */     boolean ev_postable = false;
/*     */     
/* 373 */     if ((getDAO_().getDiscountCode() == null && argDiscountCode != null) || (
/* 374 */       getDAO_().getDiscountCode() != null && !getDAO_().getDiscountCode().equals(argDiscountCode))) {
/* 375 */       getDAO_().setDiscountCode(argDiscountCode);
/* 376 */       ev_postable = true;
/*     */     } 
/*     */     
/* 379 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxabilityCode() {
/* 387 */     return getDAO_().getTaxabilityCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTaxabilityCode(String argTaxabilityCode) {
/* 395 */     if (setTaxabilityCode_noev(argTaxabilityCode) && 
/* 396 */       this._events != null && 
/* 397 */       postEventsForChanges()) {
/* 398 */       this._events.post(IDiscountLineItem.SET_TAXABILITYCODE, argTaxabilityCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTaxabilityCode_noev(String argTaxabilityCode) {
/* 405 */     boolean ev_postable = false;
/*     */     
/* 407 */     if ((getDAO_().getTaxabilityCode() == null && argTaxabilityCode != null) || (
/* 408 */       getDAO_().getTaxabilityCode() != null && !getDAO_().getTaxabilityCode().equals(argTaxabilityCode))) {
/* 409 */       getDAO_().setTaxabilityCode(argTaxabilityCode);
/* 410 */       ev_postable = true;
/*     */     } 
/*     */     
/* 413 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAwardTransactionId() {
/* 421 */     return getDAO_().getAwardTransactionId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAwardTransactionId(String argAwardTransactionId) {
/* 429 */     if (setAwardTransactionId_noev(argAwardTransactionId) && 
/* 430 */       this._events != null && 
/* 431 */       postEventsForChanges()) {
/* 432 */       this._events.post(IDiscountLineItem.SET_AWARDTRANSACTIONID, argAwardTransactionId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAwardTransactionId_noev(String argAwardTransactionId) {
/* 439 */     boolean ev_postable = false;
/*     */     
/* 441 */     if ((getDAO_().getAwardTransactionId() == null && argAwardTransactionId != null) || (
/* 442 */       getDAO_().getAwardTransactionId() != null && !getDAO_().getAwardTransactionId().equals(argAwardTransactionId))) {
/* 443 */       getDAO_().setAwardTransactionId(argAwardTransactionId);
/* 444 */       ev_postable = true;
/*     */     } 
/*     */     
/* 447 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "LineItemDiscount")
/*     */   public IDiscount getLineItemDiscount() {
/* 456 */     return this._lineItemDiscount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLineItemDiscount(IDiscount argLineItemDiscount) {
/* 461 */     if (argLineItemDiscount == null) {
/*     */       
/* 463 */       getDAO_().setDiscountCode(null);
/* 464 */       if (this._lineItemDiscount != null)
/*     */       {
/* 466 */         if (postEventsForChanges()) {
/* 467 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._lineItemDiscount));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 472 */       getDAO_().setDiscountCode(argLineItemDiscount.getDiscountCode());
/*     */       
/* 474 */       if (postEventsForChanges()) {
/* 475 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemDiscount));
/*     */       }
/*     */     } 
/*     */     
/* 479 */     this._lineItemDiscount = argLineItemDiscount;
/* 480 */     if (postEventsForChanges()) {
/* 481 */       this._events.post(IDiscountLineItem.SET_LINEITEMDISCOUNT, argLineItemDiscount);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 487 */     if ("LineItemDiscount".equals(argFieldId)) {
/* 488 */       return getLineItemDiscount();
/*     */     }
/* 490 */     if ("DiscountLineItemExtension".equals(argFieldId)) {
/* 491 */       return this._myExtension;
/*     */     }
/*     */     
/* 494 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 500 */     if ("LineItemDiscount".equals(argFieldId)) {
/* 501 */       setLineItemDiscount((IDiscount)argValue);
/*     */     }
/* 503 */     else if ("DiscountLineItemExtension".equals(argFieldId)) {
/* 504 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 507 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 513 */     super.setDependencies(argPD, argEM);
/* 514 */     if (this._lineItemDiscount != null) {
/* 515 */       ((IDataModelImpl)this._lineItemDiscount).setDependencies(argPD, argEM);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDiscountLineItemExt() {
/* 520 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDiscountLineItemExt(IDataModel argExt) {
/* 524 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 529 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 533 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 536 */     super.startTransaction();
/*     */     
/* 538 */     this._lineItemDiscountSavepoint = this._lineItemDiscount;
/* 539 */     if (this._lineItemDiscount != null) {
/* 540 */       this._lineItemDiscount.startTransaction();
/*     */     }
/*     */ 
/*     */     
/* 544 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 549 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 552 */     super.rollbackChanges();
/*     */     
/* 554 */     this._lineItemDiscount = this._lineItemDiscountSavepoint;
/* 555 */     this._lineItemDiscountSavepoint = null;
/* 556 */     if (this._lineItemDiscount != null) {
/* 557 */       this._lineItemDiscount.rollbackChanges();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 564 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 567 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 570 */     super.commitTransaction();
/*     */     
/* 572 */     this._lineItemDiscountSavepoint = this._lineItemDiscount;
/* 573 */     if (this._lineItemDiscount != null) {
/* 574 */       this._lineItemDiscount.commitTransaction();
/*     */     }
/*     */ 
/*     */     
/* 578 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 583 */     argStream.defaultReadObject();
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
/*     */   public BigDecimal getAmount() {
/* 599 */     return getLocalizedAmount(getAmountImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/* 606 */     BigDecimal relativeAmount = getRelativeAmount(argAmount);
/* 607 */     setAmountImpl(relativeAmount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getNewPrice() {
/* 614 */     return getLocalizedAmount(getNewPriceImpl());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewPrice(BigDecimal argNewPrice) {
/* 621 */     BigDecimal relativeAmount = getRelativeAmount(argNewPrice);
/* 622 */     setNewPriceImpl(relativeAmount);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DiscountLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */