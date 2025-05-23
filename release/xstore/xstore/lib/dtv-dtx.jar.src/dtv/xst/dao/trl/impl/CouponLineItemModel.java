/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.trl.ICouponLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CouponLineItemModel
/*     */   extends RetailTransactionLineItemModel
/*     */   implements ICouponLineItem
/*     */ {
/*     */   private static final long serialVersionUID = 470353805L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new CouponLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CouponLineItemDAO getDAO_() {
/*  38 */     return (CouponLineItemDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  46 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  54 */     if (setCreateDate_noev(argCreateDate) && 
/*  55 */       this._events != null && 
/*  56 */       postEventsForChanges()) {
/*  57 */       this._events.post(ICouponLineItem.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  64 */     boolean ev_postable = false;
/*     */     
/*  66 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  67 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  68 */       getDAO_().setCreateDate(argCreateDate);
/*  69 */       ev_postable = true;
/*     */     } 
/*     */     
/*  72 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  88 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  89 */       this._events != null && 
/*  90 */       postEventsForChanges()) {
/*  91 */       this._events.post(ICouponLineItem.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  98 */     boolean ev_postable = false;
/*     */     
/* 100 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 101 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 102 */       getDAO_().setCreateUserId(argCreateUserId);
/* 103 */       ev_postable = true;
/*     */     } 
/*     */     
/* 106 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 114 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 123 */       this._events != null && 
/* 124 */       postEventsForChanges()) {
/* 125 */       this._events.post(ICouponLineItem.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 132 */     boolean ev_postable = false;
/*     */     
/* 134 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 135 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 136 */       getDAO_().setUpdateDate(argUpdateDate);
/* 137 */       ev_postable = true;
/*     */     } 
/*     */     
/* 140 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 148 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ICouponLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 169 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 170 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 171 */       ev_postable = true;
/*     */     } 
/*     */     
/* 174 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCouponId() {
/* 182 */     return getDAO_().getCouponId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCouponId(String argCouponId) {
/* 190 */     if (setCouponId_noev(argCouponId) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(ICouponLineItem.SET_COUPONID, argCouponId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCouponId_noev(String argCouponId) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getCouponId() == null && argCouponId != null) || (
/* 203 */       getDAO_().getCouponId() != null && !getDAO_().getCouponId().equals(argCouponId))) {
/* 204 */       getDAO_().setCouponId(argCouponId);
/* 205 */       ev_postable = true;
/*     */     } 
/*     */     
/* 208 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCouponTypeCode() {
/* 216 */     return getDAO_().getCouponTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCouponTypeCode(String argCouponTypeCode) {
/* 224 */     if (setCouponTypeCode_noev(argCouponTypeCode) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(ICouponLineItem.SET_COUPONTYPECODE, argCouponTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCouponTypeCode_noev(String argCouponTypeCode) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getCouponTypeCode() == null && argCouponTypeCode != null) || (
/* 237 */       getDAO_().getCouponTypeCode() != null && !getDAO_().getCouponTypeCode().equals(argCouponTypeCode))) {
/* 238 */       getDAO_().setCouponTypeCode(argCouponTypeCode);
/* 239 */       ev_postable = true;
/*     */     } 
/*     */     
/* 242 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 250 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 258 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 259 */       this._events != null && 
/* 260 */       postEventsForChanges()) {
/* 261 */       this._events.post(ICouponLineItem.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 268 */     boolean ev_postable = false;
/*     */     
/* 270 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 271 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 272 */       getDAO_().setExpirationDate(argExpirationDate);
/* 273 */       ev_postable = true;
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntryMethodCode() {
/* 284 */     return getDAO_().getEntryMethodCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/* 292 */     if (setEntryMethodCode_noev(argEntryMethodCode) && 
/* 293 */       this._events != null && 
/* 294 */       postEventsForChanges()) {
/* 295 */       this._events.post(ICouponLineItem.SET_ENTRYMETHODCODE, argEntryMethodCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryMethodCode_noev(String argEntryMethodCode) {
/* 302 */     boolean ev_postable = false;
/*     */     
/* 304 */     if ((getDAO_().getEntryMethodCode() == null && argEntryMethodCode != null) || (
/* 305 */       getDAO_().getEntryMethodCode() != null && !getDAO_().getEntryMethodCode().equals(argEntryMethodCode))) {
/* 306 */       getDAO_().setEntryMethodCode(argEntryMethodCode);
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
/*     */   public String getManufacturerId() {
/* 318 */     return getDAO_().getManufacturerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManufacturerId(String argManufacturerId) {
/* 326 */     if (setManufacturerId_noev(argManufacturerId) && 
/* 327 */       this._events != null && 
/* 328 */       postEventsForChanges()) {
/* 329 */       this._events.post(ICouponLineItem.SET_MANUFACTURERID, argManufacturerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setManufacturerId_noev(String argManufacturerId) {
/* 336 */     boolean ev_postable = false;
/*     */     
/* 338 */     if ((getDAO_().getManufacturerId() == null && argManufacturerId != null) || (
/* 339 */       getDAO_().getManufacturerId() != null && !getDAO_().getManufacturerId().equals(argManufacturerId))) {
/* 340 */       getDAO_().setManufacturerId(argManufacturerId);
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
/*     */   public String getValueCode() {
/* 352 */     return getDAO_().getValueCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueCode(String argValueCode) {
/* 360 */     if (setValueCode_noev(argValueCode) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(ICouponLineItem.SET_VALUECODE, argValueCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValueCode_noev(String argValueCode) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getValueCode() == null && argValueCode != null) || (
/* 373 */       getDAO_().getValueCode() != null && !getDAO_().getValueCode().equals(argValueCode))) {
/* 374 */       getDAO_().setValueCode(argValueCode);
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
/*     */   public BigDecimal getAmountEntered() {
/* 386 */     return getDAO_().getAmountEntered();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmountEntered(BigDecimal argAmountEntered) {
/* 394 */     if (setAmountEntered_noev(argAmountEntered) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(ICouponLineItem.SET_AMOUNTENTERED, argAmountEntered);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmountEntered_noev(BigDecimal argAmountEntered) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getAmountEntered() == null && argAmountEntered != null) || (
/* 407 */       getDAO_().getAmountEntered() != null && !getDAO_().getAmountEntered().equals(argAmountEntered))) {
/* 408 */       getDAO_().setAmountEntered(argAmountEntered);
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
/*     */   public String getManufacturerFamilyCode() {
/* 420 */     return getDAO_().getManufacturerFamilyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManufacturerFamilyCode(String argManufacturerFamilyCode) {
/* 428 */     if (setManufacturerFamilyCode_noev(argManufacturerFamilyCode) && 
/* 429 */       this._events != null && 
/* 430 */       postEventsForChanges()) {
/* 431 */       this._events.post(ICouponLineItem.SET_MANUFACTURERFAMILYCODE, argManufacturerFamilyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setManufacturerFamilyCode_noev(String argManufacturerFamilyCode) {
/* 438 */     boolean ev_postable = false;
/*     */     
/* 440 */     if ((getDAO_().getManufacturerFamilyCode() == null && argManufacturerFamilyCode != null) || (
/* 441 */       getDAO_().getManufacturerFamilyCode() != null && !getDAO_().getManufacturerFamilyCode().equals(argManufacturerFamilyCode))) {
/* 442 */       getDAO_().setManufacturerFamilyCode(argManufacturerFamilyCode);
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
/*     */   public boolean getSerialized() {
/* 454 */     if (getDAO_().getSerialized() != null) {
/* 455 */       return getDAO_().getSerialized().booleanValue();
/*     */     }
/*     */     
/* 458 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialized(boolean argSerialized) {
/* 467 */     if (setSerialized_noev(argSerialized) && 
/* 468 */       this._events != null && 
/* 469 */       postEventsForChanges()) {
/* 470 */       this._events.post(ICouponLineItem.SET_SERIALIZED, Boolean.valueOf(argSerialized));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialized_noev(boolean argSerialized) {
/* 477 */     boolean ev_postable = false;
/*     */     
/* 479 */     if ((getDAO_().getSerialized() == null && Boolean.valueOf(argSerialized) != null) || (
/* 480 */       getDAO_().getSerialized() != null && !getDAO_().getSerialized().equals(Boolean.valueOf(argSerialized)))) {
/* 481 */       getDAO_().setSerialized(Boolean.valueOf(argSerialized));
/* 482 */       ev_postable = true;
/*     */     } 
/*     */     
/* 485 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAuthorized() {
/* 493 */     if (getDAO_().getAuthorized() != null) {
/* 494 */       return getDAO_().getAuthorized().booleanValue();
/*     */     }
/*     */     
/* 497 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthorized(boolean argAuthorized) {
/* 506 */     if (setAuthorized_noev(argAuthorized) && 
/* 507 */       this._events != null && 
/* 508 */       postEventsForChanges()) {
/* 509 */       this._events.post(ICouponLineItem.SET_AUTHORIZED, Boolean.valueOf(argAuthorized));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAuthorized_noev(boolean argAuthorized) {
/* 516 */     boolean ev_postable = false;
/*     */     
/* 518 */     if ((getDAO_().getAuthorized() == null && Boolean.valueOf(argAuthorized) != null) || (
/* 519 */       getDAO_().getAuthorized() != null && !getDAO_().getAuthorized().equals(Boolean.valueOf(argAuthorized)))) {
/* 520 */       getDAO_().setAuthorized(Boolean.valueOf(argAuthorized));
/* 521 */       ev_postable = true;
/*     */     } 
/*     */     
/* 524 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRedemptionTransId() {
/* 532 */     return getDAO_().getRedemptionTransId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRedemptionTransId(String argRedemptionTransId) {
/* 540 */     if (setRedemptionTransId_noev(argRedemptionTransId) && 
/* 541 */       this._events != null && 
/* 542 */       postEventsForChanges()) {
/* 543 */       this._events.post(ICouponLineItem.SET_REDEMPTIONTRANSID, argRedemptionTransId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRedemptionTransId_noev(String argRedemptionTransId) {
/* 550 */     boolean ev_postable = false;
/*     */     
/* 552 */     if ((getDAO_().getRedemptionTransId() == null && argRedemptionTransId != null) || (
/* 553 */       getDAO_().getRedemptionTransId() != null && !getDAO_().getRedemptionTransId().equals(argRedemptionTransId))) {
/* 554 */       getDAO_().setRedemptionTransId(argRedemptionTransId);
/* 555 */       ev_postable = true;
/*     */     } 
/*     */     
/* 558 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 564 */     if ("CouponLineItemExtension".equals(argFieldId)) {
/* 565 */       return this._myExtension;
/*     */     }
/*     */     
/* 568 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 574 */     if ("CouponLineItemExtension".equals(argFieldId)) {
/* 575 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 578 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 584 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getCouponLineItemExt() {
/* 588 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCouponLineItemExt(IDataModel argExt) {
/* 592 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 597 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 601 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 604 */     super.startTransaction();
/*     */ 
/*     */     
/* 607 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 612 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 615 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 621 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 624 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 627 */     super.commitTransaction();
/*     */ 
/*     */     
/* 630 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 635 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean _forcedRedemption = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isForcedRedemption() {
/* 652 */     return this._forcedRedemption;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForcedRedemption(boolean argForced) {
/* 658 */     this._forcedRedemption = argForced;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CouponLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */