/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.IReceiptTextProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReceiptTextPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IReceiptTextProperty
/*     */ {
/*     */   private static final long serialVersionUID = 476120154L;
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
/*  36 */     setDAO((IDataAccessObject)new ReceiptTextPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReceiptTextPropertyDAO getDAO_() {
/*  44 */     return (ReceiptTextPropertyDAO)this._daoImpl;
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
/*  65 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  66 */       this._events != null && 
/*  67 */       postEventsForChanges()) {
/*  68 */       this._events.post(IReceiptTextProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  75 */     boolean ev_postable = false;
/*     */     
/*  77 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  78 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  79 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
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
/*     */   public String getTextCode() {
/*  91 */     return getDAO_().getTextCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/*  99 */     if (setTextCode_noev(argTextCode) && 
/* 100 */       this._events != null && 
/* 101 */       postEventsForChanges()) {
/* 102 */       this._events.post(IReceiptTextProperty.SET_TEXTCODE, argTextCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextCode_noev(String argTextCode) {
/* 109 */     boolean ev_postable = false;
/*     */     
/* 111 */     if ((getDAO_().getTextCode() == null && argTextCode != null) || (
/* 112 */       getDAO_().getTextCode() != null && !getDAO_().getTextCode().equals(argTextCode))) {
/* 113 */       getDAO_().setTextCode(argTextCode);
/* 114 */       ev_postable = true;
/*     */     } 
/*     */     
/* 117 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextSequence() {
/* 125 */     if (getDAO_().getTextSequence() != null) {
/* 126 */       return getDAO_().getTextSequence().intValue();
/*     */     }
/*     */     
/* 129 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextSequence(int argTextSequence) {
/* 138 */     if (setTextSequence_noev(argTextSequence) && 
/* 139 */       this._events != null && 
/* 140 */       postEventsForChanges()) {
/* 141 */       this._events.post(IReceiptTextProperty.SET_TEXTSEQUENCE, Integer.valueOf(argTextSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextSequence_noev(int argTextSequence) {
/* 148 */     boolean ev_postable = false;
/*     */     
/* 150 */     if ((getDAO_().getTextSequence() == null && Integer.valueOf(argTextSequence) != null) || (
/* 151 */       getDAO_().getTextSequence() != null && !getDAO_().getTextSequence().equals(Integer.valueOf(argTextSequence)))) {
/* 152 */       getDAO_().setTextSequence(Integer.valueOf(argTextSequence));
/* 153 */       ev_postable = true;
/*     */     } 
/*     */     
/* 156 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextSubcode() {
/* 164 */     return getDAO_().getTextSubcode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextSubcode(String argTextSubcode) {
/* 172 */     if (setTextSubcode_noev(argTextSubcode) && 
/* 173 */       this._events != null && 
/* 174 */       postEventsForChanges()) {
/* 175 */       this._events.post(IReceiptTextProperty.SET_TEXTSUBCODE, argTextSubcode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTextSubcode_noev(String argTextSubcode) {
/* 182 */     boolean ev_postable = false;
/*     */     
/* 184 */     if ((getDAO_().getTextSubcode() == null && argTextSubcode != null) || (
/* 185 */       getDAO_().getTextSubcode() != null && !getDAO_().getTextSubcode().equals(argTextSubcode))) {
/* 186 */       getDAO_().setTextSubcode(argTextSubcode);
/* 187 */       ev_postable = true;
/*     */     } 
/*     */     
/* 190 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigElement() {
/* 198 */     return getDAO_().getConfigElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 206 */     if (setConfigElement_noev(argConfigElement) && 
/* 207 */       this._events != null && 
/* 208 */       postEventsForChanges()) {
/* 209 */       this._events.post(IReceiptTextProperty.SET_CONFIGELEMENT, argConfigElement);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setConfigElement_noev(String argConfigElement) {
/* 216 */     boolean ev_postable = false;
/*     */     
/* 218 */     if ((getDAO_().getConfigElement() == null && argConfigElement != null) || (
/* 219 */       getDAO_().getConfigElement() != null && !getDAO_().getConfigElement().equals(argConfigElement))) {
/* 220 */       getDAO_().setConfigElement(argConfigElement);
/* 221 */       ev_postable = true;
/*     */     } 
/*     */     
/* 224 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 232 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 240 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 241 */       this._events != null && 
/* 242 */       postEventsForChanges()) {
/* 243 */       this._events.post(IReceiptTextProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 250 */     boolean ev_postable = false;
/*     */     
/* 252 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 253 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 254 */       getDAO_().setPropertyCode(argPropertyCode);
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
/*     */   public String getType() {
/* 266 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 274 */     if (setType_noev(argType) && 
/* 275 */       this._events != null && 
/* 276 */       postEventsForChanges()) {
/* 277 */       this._events.post(IReceiptTextProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 284 */     boolean ev_postable = false;
/*     */     
/* 286 */     if ((getDAO_().getType() == null && argType != null) || (
/* 287 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 288 */       getDAO_().setType(argType);
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
/*     */   public String getStringValue() {
/* 300 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 308 */     if (setStringValue_noev(argStringValue) && 
/* 309 */       this._events != null && 
/* 310 */       postEventsForChanges()) {
/* 311 */       this._events.post(IReceiptTextProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 318 */     boolean ev_postable = false;
/*     */     
/* 320 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 321 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 322 */       getDAO_().setStringValue(argStringValue);
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
/*     */   public Date getDateValue() {
/* 334 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 342 */     if (setDateValue_noev(argDateValue) && 
/* 343 */       this._events != null && 
/* 344 */       postEventsForChanges()) {
/* 345 */       this._events.post(IReceiptTextProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 352 */     boolean ev_postable = false;
/*     */     
/* 354 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 355 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 356 */       getDAO_().setDateValue(argDateValue);
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
/*     */   public BigDecimal getDecimalValue() {
/* 368 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 376 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 377 */       this._events != null && 
/* 378 */       postEventsForChanges()) {
/* 379 */       this._events.post(IReceiptTextProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 386 */     boolean ev_postable = false;
/*     */     
/* 388 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 389 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 390 */       getDAO_().setDecimalValue(argDecimalValue);
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
/*     */   public Date getCreateDate() {
/* 402 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 410 */     if (setCreateDate_noev(argCreateDate) && 
/* 411 */       this._events != null && 
/* 412 */       postEventsForChanges()) {
/* 413 */       this._events.post(IReceiptTextProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 420 */     boolean ev_postable = false;
/*     */     
/* 422 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 423 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 424 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 436 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 444 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 445 */       this._events != null && 
/* 446 */       postEventsForChanges()) {
/* 447 */       this._events.post(IReceiptTextProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 454 */     boolean ev_postable = false;
/*     */     
/* 456 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 457 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 458 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 470 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 478 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 479 */       this._events != null && 
/* 480 */       postEventsForChanges()) {
/* 481 */       this._events.post(IReceiptTextProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 488 */     boolean ev_postable = false;
/*     */     
/* 490 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 491 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 492 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 504 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 512 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 513 */       this._events != null && 
/* 514 */       postEventsForChanges()) {
/* 515 */       this._events.post(IReceiptTextProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 522 */     boolean ev_postable = false;
/*     */     
/* 524 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 525 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 526 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 527 */       ev_postable = true;
/*     */     } 
/*     */     
/* 530 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 536 */     if ("ReceiptTextPropertyExtension".equals(argFieldId)) {
/* 537 */       return this._myExtension;
/*     */     }
/*     */     
/* 540 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 546 */     if ("ReceiptTextPropertyExtension".equals(argFieldId)) {
/* 547 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 550 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 556 */     this._persistenceDefaults = argPD;
/* 557 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 558 */     this._eventManager = argEM;
/* 559 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 560 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 565 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 569 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 572 */     super.startTransaction();
/*     */ 
/*     */     
/* 575 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 580 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 583 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 589 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 592 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 595 */     super.commitTransaction();
/*     */ 
/*     */     
/* 598 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 603 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReceiptTextPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */