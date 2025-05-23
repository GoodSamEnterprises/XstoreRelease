/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.AbstractDataModelPropertiesImpl;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.xst.dao.thr.IPayrollProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PayrollPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IPayrollProperty
/*     */ {
/*     */   private static final long serialVersionUID = -967794182L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  31 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initDAO() {
/*  36 */     setDAO((IDataAccessObject)new PayrollPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PayrollPropertyDAO getDAO_() {
/*  44 */     return (PayrollPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocId() {
/*  52 */     if (getDAO_().getRetailLocId() != null) {
/*  53 */       return getDAO_().getRetailLocId().longValue();
/*     */     }
/*     */     
/*  56 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocId(long argRetailLocId) {
/*  65 */     if (setRetailLocId_noev(argRetailLocId) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(IPayrollProperty.SET_RETAILLOCID, Long.valueOf(argRetailLocId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocId_noev(long argRetailLocId) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getRetailLocId() == null && Long.valueOf(argRetailLocId) != null) || (
/*  78 */       getDAO_().getRetailLocId() != null && !getDAO_().getRetailLocId().equals(Long.valueOf(argRetailLocId)))) {
/*  79 */       getDAO_().setRetailLocId(Long.valueOf(argRetailLocId));
/*  80 */       ev_postable = true;
/*     */     } 
/*     */     
/*  83 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/*  91 */     if (getDAO_().getPartyId() != null) {
/*  92 */       return getDAO_().getPartyId().longValue();
/*     */     }
/*     */     
/*  95 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 104 */     if (setPartyId_noev(argPartyId) && 
/* 105 */       this._events != null && 
/* 106 */       postEventsForChanges()) {
/* 107 */       this._events.post(IPayrollProperty.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 114 */     boolean ev_postable = false;
/*     */     
/* 116 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 117 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 118 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 119 */       ev_postable = true;
/*     */     } 
/*     */     
/* 122 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 130 */     if (getDAO_().getOrganizationId() != null) {
/* 131 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 134 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 143 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 144 */       this._events != null && 
/* 145 */       postEventsForChanges()) {
/* 146 */       this._events.post(IPayrollProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 153 */     boolean ev_postable = false;
/*     */     
/* 155 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 156 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 157 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 158 */       ev_postable = true;
/*     */     } 
/*     */     
/* 161 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 169 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 177 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 178 */       this._events != null && 
/* 179 */       postEventsForChanges()) {
/* 180 */       this._events.post(IPayrollProperty.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 187 */     boolean ev_postable = false;
/*     */     
/* 189 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 190 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 191 */       getDAO_().setBusinessDate(argBusinessDate);
/* 192 */       ev_postable = true;
/*     */     } 
/*     */     
/* 195 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPayrollCategory() {
/* 203 */     return getDAO_().getPayrollCategory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPayrollCategory(String argPayrollCategory) {
/* 211 */     if (setPayrollCategory_noev(argPayrollCategory) && 
/* 212 */       this._events != null && 
/* 213 */       postEventsForChanges()) {
/* 214 */       this._events.post(IPayrollProperty.SET_PAYROLLCATEGORY, argPayrollCategory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPayrollCategory_noev(String argPayrollCategory) {
/* 221 */     boolean ev_postable = false;
/*     */     
/* 223 */     if ((getDAO_().getPayrollCategory() == null && argPayrollCategory != null) || (
/* 224 */       getDAO_().getPayrollCategory() != null && !getDAO_().getPayrollCategory().equals(argPayrollCategory))) {
/* 225 */       getDAO_().setPayrollCategory(argPayrollCategory);
/* 226 */       ev_postable = true;
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 237 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 245 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IPayrollProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 258 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 259 */       getDAO_().setPropertyCode(argPropertyCode);
/* 260 */       ev_postable = true;
/*     */     } 
/*     */     
/* 263 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 271 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 279 */     if (setType_noev(argType) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IPayrollProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getType() == null && argType != null) || (
/* 292 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 293 */       getDAO_().setType(argType);
/* 294 */       ev_postable = true;
/*     */     } 
/*     */     
/* 297 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 305 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 313 */     if (setStringValue_noev(argStringValue) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IPayrollProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 326 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 327 */       getDAO_().setStringValue(argStringValue);
/* 328 */       ev_postable = true;
/*     */     } 
/*     */     
/* 331 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 339 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 347 */     if (setDateValue_noev(argDateValue) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IPayrollProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 360 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 361 */       getDAO_().setDateValue(argDateValue);
/* 362 */       ev_postable = true;
/*     */     } 
/*     */     
/* 365 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 373 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 381 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IPayrollProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 394 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 395 */       getDAO_().setDecimalValue(argDecimalValue);
/* 396 */       ev_postable = true;
/*     */     } 
/*     */     
/* 399 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 407 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 415 */     if (setCreateDate_noev(argCreateDate) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IPayrollProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 428 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 429 */       getDAO_().setCreateDate(argCreateDate);
/* 430 */       ev_postable = true;
/*     */     } 
/*     */     
/* 433 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 441 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 449 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IPayrollProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 462 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 463 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 475 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 483 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 484 */       this._events != null && 
/* 485 */       postEventsForChanges()) {
/* 486 */       this._events.post(IPayrollProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 493 */     boolean ev_postable = false;
/*     */     
/* 495 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 496 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 497 */       getDAO_().setUpdateDate(argUpdateDate);
/* 498 */       ev_postable = true;
/*     */     } 
/*     */     
/* 501 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 509 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 517 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 518 */       this._events != null && 
/* 519 */       postEventsForChanges()) {
/* 520 */       this._events.post(IPayrollProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 527 */     boolean ev_postable = false;
/*     */     
/* 529 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 530 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 531 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 532 */       ev_postable = true;
/*     */     } 
/*     */     
/* 535 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 541 */     if ("PayrollPropertyExtension".equals(argFieldId)) {
/* 542 */       return this._myExtension;
/*     */     }
/*     */     
/* 545 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 551 */     if ("PayrollPropertyExtension".equals(argFieldId)) {
/* 552 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 555 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 561 */     this._persistenceDefaults = argPD;
/* 562 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 563 */     this._eventManager = argEM;
/* 564 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 565 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 570 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 574 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 577 */     super.startTransaction();
/*     */ 
/*     */     
/* 580 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 585 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 588 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 594 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 597 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 600 */     super.commitTransaction();
/*     */ 
/*     */     
/* 603 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 608 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */