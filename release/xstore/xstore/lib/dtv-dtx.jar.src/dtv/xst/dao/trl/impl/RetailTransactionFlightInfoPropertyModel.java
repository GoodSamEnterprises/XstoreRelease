/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ import dtv.xst.dao.trl.IRetailTransactionFlightInfoProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RetailTransactionFlightInfoPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IRetailTransactionFlightInfoProperty
/*     */ {
/*     */   private static final long serialVersionUID = 864863822L;
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
/*  36 */     setDAO((IDataAccessObject)new RetailTransactionFlightInfoPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RetailTransactionFlightInfoPropertyDAO getDAO_() {
/*  44 */     return (RetailTransactionFlightInfoPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  52 */     if (getDAO_().getOrganizationId() != null) {
/*  53 */       return getDAO_().getOrganizationId().longValue();
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
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  65 */     if (setOrganizationId_noev(argOrganizationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  71 */     boolean ev_postable = false;
/*     */     
/*  73 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  74 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  75 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  76 */       ev_postable = true;
/*     */     } 
/*     */     
/*  79 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  87 */     if (getDAO_().getRetailLocationId() != null) {
/*  88 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/*  91 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 100 */     if (setRetailLocationId_noev(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 106 */     boolean ev_postable = false;
/*     */     
/* 108 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 109 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 110 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 111 */       ev_postable = true;
/*     */     } 
/*     */     
/* 114 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 122 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 130 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 131 */       this._events != null && 
/* 132 */       postEventsForChanges()) {
/* 133 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 140 */     boolean ev_postable = false;
/*     */     
/* 142 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 143 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 144 */       getDAO_().setBusinessDate(argBusinessDate);
/* 145 */       ev_postable = true;
/*     */     } 
/*     */     
/* 148 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 156 */     if (getDAO_().getWorkstationId() != null) {
/* 157 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 160 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 169 */     if (setWorkstationId_noev(argWorkstationId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 175 */     boolean ev_postable = false;
/*     */     
/* 177 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 178 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 179 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 180 */       ev_postable = true;
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 191 */     if (getDAO_().getTransactionSequence() != null) {
/* 192 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 195 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 204 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 205 */       this._events != null && 
/* 206 */       postEventsForChanges()) {
/* 207 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 214 */     boolean ev_postable = false;
/*     */     
/* 216 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 217 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 218 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 219 */       ev_postable = true;
/*     */     } 
/*     */     
/* 222 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 230 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 238 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 239 */       this._events != null && 
/* 240 */       postEventsForChanges()) {
/* 241 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 248 */     boolean ev_postable = false;
/*     */     
/* 250 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 251 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 252 */       getDAO_().setPropertyCode(argPropertyCode);
/* 253 */       ev_postable = true;
/*     */     } 
/*     */     
/* 256 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 264 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 272 */     if (setType_noev(argType) && 
/* 273 */       this._events != null && 
/* 274 */       postEventsForChanges()) {
/* 275 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 282 */     boolean ev_postable = false;
/*     */     
/* 284 */     if ((getDAO_().getType() == null && argType != null) || (
/* 285 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 286 */       getDAO_().setType(argType);
/* 287 */       ev_postable = true;
/*     */     } 
/*     */     
/* 290 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 298 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 306 */     if (setStringValue_noev(argStringValue) && 
/* 307 */       this._events != null && 
/* 308 */       postEventsForChanges()) {
/* 309 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 316 */     boolean ev_postable = false;
/*     */     
/* 318 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 319 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 320 */       getDAO_().setStringValue(argStringValue);
/* 321 */       ev_postable = true;
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 332 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 340 */     if (setDateValue_noev(argDateValue) && 
/* 341 */       this._events != null && 
/* 342 */       postEventsForChanges()) {
/* 343 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 350 */     boolean ev_postable = false;
/*     */     
/* 352 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 353 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 354 */       getDAO_().setDateValue(argDateValue);
/* 355 */       ev_postable = true;
/*     */     } 
/*     */     
/* 358 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 366 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 374 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 375 */       this._events != null && 
/* 376 */       postEventsForChanges()) {
/* 377 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 384 */     boolean ev_postable = false;
/*     */     
/* 386 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 387 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 388 */       getDAO_().setDecimalValue(argDecimalValue);
/* 389 */       ev_postable = true;
/*     */     } 
/*     */     
/* 392 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 400 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 408 */     if (setCreateDate_noev(argCreateDate) && 
/* 409 */       this._events != null && 
/* 410 */       postEventsForChanges()) {
/* 411 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 418 */     boolean ev_postable = false;
/*     */     
/* 420 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 421 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 422 */       getDAO_().setCreateDate(argCreateDate);
/* 423 */       ev_postable = true;
/*     */     } 
/*     */     
/* 426 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 434 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 442 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 443 */       this._events != null && 
/* 444 */       postEventsForChanges()) {
/* 445 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 452 */     boolean ev_postable = false;
/*     */     
/* 454 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 455 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 456 */       getDAO_().setCreateUserId(argCreateUserId);
/* 457 */       ev_postable = true;
/*     */     } 
/*     */     
/* 460 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 468 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 476 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 477 */       this._events != null && 
/* 478 */       postEventsForChanges()) {
/* 479 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 486 */     boolean ev_postable = false;
/*     */     
/* 488 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 489 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 490 */       getDAO_().setUpdateDate(argUpdateDate);
/* 491 */       ev_postable = true;
/*     */     } 
/*     */     
/* 494 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 502 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 510 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 511 */       this._events != null && 
/* 512 */       postEventsForChanges()) {
/* 513 */       this._events.post(IRetailTransactionFlightInfoProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 520 */     boolean ev_postable = false;
/*     */     
/* 522 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 523 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 524 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 525 */       ev_postable = true;
/*     */     } 
/*     */     
/* 528 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 534 */     if ("RetailTransactionFlightInfoPropertyExtension".equals(argFieldId)) {
/* 535 */       return this._myExtension;
/*     */     }
/*     */     
/* 538 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 544 */     if ("RetailTransactionFlightInfoPropertyExtension".equals(argFieldId)) {
/* 545 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 548 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 554 */     this._persistenceDefaults = argPD;
/* 555 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 556 */     this._eventManager = argEM;
/* 557 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 558 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 563 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 567 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 570 */     super.startTransaction();
/*     */ 
/*     */     
/* 573 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 578 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 581 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 587 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 590 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 593 */     super.commitTransaction();
/*     */ 
/*     */     
/* 596 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 601 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionFlightInfoPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */