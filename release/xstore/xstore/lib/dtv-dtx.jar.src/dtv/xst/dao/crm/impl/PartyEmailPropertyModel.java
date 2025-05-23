/*     */ package dtv.xst.dao.crm.impl;
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
/*     */ import dtv.xst.dao.crm.IPartyEmailProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PartyEmailPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IPartyEmailProperty
/*     */ {
/*     */   private static final long serialVersionUID = 1818978411L;
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
/*  36 */     setDAO((IDataAccessObject)new PartyEmailPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PartyEmailPropertyDAO getDAO_() {
/*  44 */     return (PartyEmailPropertyDAO)this._daoImpl;
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
/*  68 */       this._events.post(IPartyEmailProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/* 107 */       this._events.post(IPartyEmailProperty.SET_PARTYID, Long.valueOf(argPartyId));
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
/*     */   public int getSequence() {
/* 130 */     if (getDAO_().getSequence() != null) {
/* 131 */       return getDAO_().getSequence().intValue();
/*     */     }
/*     */     
/* 134 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(int argSequence) {
/* 143 */     if (setSequence_noev(argSequence) && 
/* 144 */       this._events != null && 
/* 145 */       postEventsForChanges()) {
/* 146 */       this._events.post(IPartyEmailProperty.SET_SEQUENCE, Integer.valueOf(argSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequence_noev(int argSequence) {
/* 153 */     boolean ev_postable = false;
/*     */     
/* 155 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/* 156 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/* 157 */       getDAO_().setSequence(Integer.valueOf(argSequence));
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
/*     */   public String getPropertyCode() {
/* 169 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 177 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 178 */       this._events != null && 
/* 179 */       postEventsForChanges()) {
/* 180 */       this._events.post(IPartyEmailProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 187 */     boolean ev_postable = false;
/*     */     
/* 189 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 190 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 191 */       getDAO_().setPropertyCode(argPropertyCode);
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
/*     */   public String getType() {
/* 203 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 211 */     if (setType_noev(argType) && 
/* 212 */       this._events != null && 
/* 213 */       postEventsForChanges()) {
/* 214 */       this._events.post(IPartyEmailProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 221 */     boolean ev_postable = false;
/*     */     
/* 223 */     if ((getDAO_().getType() == null && argType != null) || (
/* 224 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 225 */       getDAO_().setType(argType);
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
/*     */   public String getStringValue() {
/* 237 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 245 */     if (setStringValue_noev(argStringValue) && 
/* 246 */       this._events != null && 
/* 247 */       postEventsForChanges()) {
/* 248 */       this._events.post(IPartyEmailProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 255 */     boolean ev_postable = false;
/*     */     
/* 257 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 258 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 259 */       getDAO_().setStringValue(argStringValue);
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
/*     */   public Date getDateValue() {
/* 271 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 279 */     if (setDateValue_noev(argDateValue) && 
/* 280 */       this._events != null && 
/* 281 */       postEventsForChanges()) {
/* 282 */       this._events.post(IPartyEmailProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 289 */     boolean ev_postable = false;
/*     */     
/* 291 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 292 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 293 */       getDAO_().setDateValue(argDateValue);
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
/*     */   public BigDecimal getDecimalValue() {
/* 305 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 313 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 314 */       this._events != null && 
/* 315 */       postEventsForChanges()) {
/* 316 */       this._events.post(IPartyEmailProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 323 */     boolean ev_postable = false;
/*     */     
/* 325 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 326 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 327 */       getDAO_().setDecimalValue(argDecimalValue);
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
/*     */   public Date getCreateDate() {
/* 339 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 347 */     if (setCreateDate_noev(argCreateDate) && 
/* 348 */       this._events != null && 
/* 349 */       postEventsForChanges()) {
/* 350 */       this._events.post(IPartyEmailProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 357 */     boolean ev_postable = false;
/*     */     
/* 359 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 360 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 361 */       getDAO_().setCreateDate(argCreateDate);
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
/*     */   public String getCreateUserId() {
/* 373 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 381 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 382 */       this._events != null && 
/* 383 */       postEventsForChanges()) {
/* 384 */       this._events.post(IPartyEmailProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 391 */     boolean ev_postable = false;
/*     */     
/* 393 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 394 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 395 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*     */   public Date getUpdateDate() {
/* 407 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 415 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 416 */       this._events != null && 
/* 417 */       postEventsForChanges()) {
/* 418 */       this._events.post(IPartyEmailProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 425 */     boolean ev_postable = false;
/*     */     
/* 427 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 428 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 429 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*     */   public String getUpdateUserId() {
/* 441 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 449 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 450 */       this._events != null && 
/* 451 */       postEventsForChanges()) {
/* 452 */       this._events.post(IPartyEmailProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 459 */     boolean ev_postable = false;
/*     */     
/* 461 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 462 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 463 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 464 */       ev_postable = true;
/*     */     } 
/*     */     
/* 467 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 473 */     if ("PartyEmailPropertyExtension".equals(argFieldId)) {
/* 474 */       return this._myExtension;
/*     */     }
/*     */     
/* 477 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 483 */     if ("PartyEmailPropertyExtension".equals(argFieldId)) {
/* 484 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 487 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 493 */     this._persistenceDefaults = argPD;
/* 494 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 495 */     this._eventManager = argEM;
/* 496 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 497 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 502 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 506 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 509 */     super.startTransaction();
/*     */ 
/*     */     
/* 512 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 517 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 520 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 526 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 529 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 532 */     super.commitTransaction();
/*     */ 
/*     */     
/* 535 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 540 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyEmailPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */