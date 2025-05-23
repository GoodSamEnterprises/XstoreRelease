/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.xst.dao.ttr.ICouponTenderLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CouponTenderLineItemModel
/*     */   extends TenderLineItemModel
/*     */   implements ICouponTenderLineItem
/*     */ {
/*     */   private static final long serialVersionUID = -1207671295L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public void initDAO() {
/*  30 */     setDAO((IDataAccessObject)new CouponTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CouponTenderLineItemDAO getDAO_() {
/*  38 */     return (CouponTenderLineItemDAO)this._daoImpl;
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
/*  57 */       this._events.post(ICouponTenderLineItem.SET_CREATEDATE, argCreateDate);
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
/*  91 */       this._events.post(ICouponTenderLineItem.SET_CREATEUSERID, argCreateUserId);
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
/* 125 */       this._events.post(ICouponTenderLineItem.SET_UPDATEDATE, argUpdateDate);
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
/* 159 */       this._events.post(ICouponTenderLineItem.SET_UPDATEUSERID, argUpdateUserId);
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
/*     */   public String getCouponTypeCode() {
/* 182 */     return getDAO_().getCouponTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCouponTypeCode(String argCouponTypeCode) {
/* 190 */     if (setCouponTypeCode_noev(argCouponTypeCode) && 
/* 191 */       this._events != null && 
/* 192 */       postEventsForChanges()) {
/* 193 */       this._events.post(ICouponTenderLineItem.SET_COUPONTYPECODE, argCouponTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCouponTypeCode_noev(String argCouponTypeCode) {
/* 200 */     boolean ev_postable = false;
/*     */     
/* 202 */     if ((getDAO_().getCouponTypeCode() == null && argCouponTypeCode != null) || (
/* 203 */       getDAO_().getCouponTypeCode() != null && !getDAO_().getCouponTypeCode().equals(argCouponTypeCode))) {
/* 204 */       getDAO_().setCouponTypeCode(argCouponTypeCode);
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
/*     */   public Date getExpirationDate() {
/* 216 */     return getDAO_().getExpirationDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 224 */     if (setExpirationDate_noev(argExpirationDate) && 
/* 225 */       this._events != null && 
/* 226 */       postEventsForChanges()) {
/* 227 */       this._events.post(ICouponTenderLineItem.SET_EXPIRATIONDATE, argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setExpirationDate_noev(Date argExpirationDate) {
/* 234 */     boolean ev_postable = false;
/*     */     
/* 236 */     if ((getDAO_().getExpirationDate() == null && argExpirationDate != null) || (
/* 237 */       getDAO_().getExpirationDate() != null && !getDAO_().getExpirationDate().equals(argExpirationDate))) {
/* 238 */       getDAO_().setExpirationDate(argExpirationDate);
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
/*     */   public boolean getKeyEntered() {
/* 250 */     if (getDAO_().getKeyEntered() != null) {
/* 251 */       return getDAO_().getKeyEntered().booleanValue();
/*     */     }
/*     */     
/* 254 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyEntered(boolean argKeyEntered) {
/* 263 */     if (setKeyEntered_noev(argKeyEntered) && 
/* 264 */       this._events != null && 
/* 265 */       postEventsForChanges()) {
/* 266 */       this._events.post(ICouponTenderLineItem.SET_KEYENTERED, Boolean.valueOf(argKeyEntered));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setKeyEntered_noev(boolean argKeyEntered) {
/* 273 */     boolean ev_postable = false;
/*     */     
/* 275 */     if ((getDAO_().getKeyEntered() == null && Boolean.valueOf(argKeyEntered) != null) || (
/* 276 */       getDAO_().getKeyEntered() != null && !getDAO_().getKeyEntered().equals(Boolean.valueOf(argKeyEntered)))) {
/* 277 */       getDAO_().setKeyEntered(Boolean.valueOf(argKeyEntered));
/* 278 */       ev_postable = true;
/*     */     } 
/*     */     
/* 281 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturerFamilyCode() {
/* 289 */     return getDAO_().getManufacturerFamilyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManufacturerFamilyCode(String argManufacturerFamilyCode) {
/* 297 */     if (setManufacturerFamilyCode_noev(argManufacturerFamilyCode) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(ICouponTenderLineItem.SET_MANUFACTURERFAMILYCODE, argManufacturerFamilyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setManufacturerFamilyCode_noev(String argManufacturerFamilyCode) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getManufacturerFamilyCode() == null && argManufacturerFamilyCode != null) || (
/* 310 */       getDAO_().getManufacturerFamilyCode() != null && !getDAO_().getManufacturerFamilyCode().equals(argManufacturerFamilyCode))) {
/* 311 */       getDAO_().setManufacturerFamilyCode(argManufacturerFamilyCode);
/* 312 */       ev_postable = true;
/*     */     } 
/*     */     
/* 315 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturerId() {
/* 323 */     return getDAO_().getManufacturerId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManufacturerId(String argManufacturerId) {
/* 331 */     if (setManufacturerId_noev(argManufacturerId) && 
/* 332 */       this._events != null && 
/* 333 */       postEventsForChanges()) {
/* 334 */       this._events.post(ICouponTenderLineItem.SET_MANUFACTURERID, argManufacturerId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setManufacturerId_noev(String argManufacturerId) {
/* 341 */     boolean ev_postable = false;
/*     */     
/* 343 */     if ((getDAO_().getManufacturerId() == null && argManufacturerId != null) || (
/* 344 */       getDAO_().getManufacturerId() != null && !getDAO_().getManufacturerId().equals(argManufacturerId))) {
/* 345 */       getDAO_().setManufacturerId(argManufacturerId);
/* 346 */       ev_postable = true;
/*     */     } 
/*     */     
/* 349 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromotionCode() {
/* 357 */     return getDAO_().getPromotionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPromotionCode(String argPromotionCode) {
/* 365 */     if (setPromotionCode_noev(argPromotionCode) && 
/* 366 */       this._events != null && 
/* 367 */       postEventsForChanges()) {
/* 368 */       this._events.post(ICouponTenderLineItem.SET_PROMOTIONCODE, argPromotionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPromotionCode_noev(String argPromotionCode) {
/* 375 */     boolean ev_postable = false;
/*     */     
/* 377 */     if ((getDAO_().getPromotionCode() == null && argPromotionCode != null) || (
/* 378 */       getDAO_().getPromotionCode() != null && !getDAO_().getPromotionCode().equals(argPromotionCode))) {
/* 379 */       getDAO_().setPromotionCode(argPromotionCode);
/* 380 */       ev_postable = true;
/*     */     } 
/*     */     
/* 383 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getScanCode() {
/* 391 */     return getDAO_().getScanCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScanCode(String argScanCode) {
/* 399 */     if (setScanCode_noev(argScanCode) && 
/* 400 */       this._events != null && 
/* 401 */       postEventsForChanges()) {
/* 402 */       this._events.post(ICouponTenderLineItem.SET_SCANCODE, argScanCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setScanCode_noev(String argScanCode) {
/* 409 */     boolean ev_postable = false;
/*     */     
/* 411 */     if ((getDAO_().getScanCode() == null && argScanCode != null) || (
/* 412 */       getDAO_().getScanCode() != null && !getDAO_().getScanCode().equals(argScanCode))) {
/* 413 */       getDAO_().setScanCode(argScanCode);
/* 414 */       ev_postable = true;
/*     */     } 
/*     */     
/* 417 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 423 */     if ("CouponTenderLineItemExtension".equals(argFieldId)) {
/* 424 */       return this._myExtension;
/*     */     }
/*     */     
/* 427 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 433 */     if ("CouponTenderLineItemExtension".equals(argFieldId)) {
/* 434 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 437 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 443 */     super.setDependencies(argPD, argEM);
/*     */   }
/*     */   
/*     */   public IDataModel getCouponTenderLineItemExt() {
/* 447 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setCouponTenderLineItemExt(IDataModel argExt) {
/* 451 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 456 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 460 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 463 */     super.startTransaction();
/*     */ 
/*     */     
/* 466 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 471 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 474 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 480 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 483 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 486 */     super.commitTransaction();
/*     */ 
/*     */     
/* 489 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 494 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\CouponTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */