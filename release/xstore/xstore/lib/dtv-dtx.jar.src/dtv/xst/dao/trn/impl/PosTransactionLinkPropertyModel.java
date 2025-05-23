/*     */ package dtv.xst.dao.trn.impl;
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
/*     */ import dtv.xst.dao.trn.IPosTransactionLinkProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PosTransactionLinkPropertyModel
/*     */   extends AbstractDataModelPropertiesImpl
/*     */   implements IPosTransactionLinkProperty
/*     */ {
/*     */   private static final long serialVersionUID = 1196197145L;
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
/*  36 */     setDAO((IDataAccessObject)new PosTransactionLinkPropertyDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PosTransactionLinkPropertyDAO getDAO_() {
/*  44 */     return (PosTransactionLinkPropertyDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/*  52 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  60 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  61 */       this._events != null && 
/*  62 */       postEventsForChanges()) {
/*  63 */       this._events.post(IPosTransactionLinkProperty.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  70 */     boolean ev_postable = false;
/*     */     
/*  72 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  73 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  74 */       getDAO_().setBusinessDate(argBusinessDate);
/*  75 */       ev_postable = true;
/*     */     } 
/*     */     
/*  78 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLinkBusinessDate() {
/*  86 */     return getDAO_().getLinkBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkBusinessDate(Date argLinkBusinessDate) {
/*  94 */     if (setLinkBusinessDate_noev(argLinkBusinessDate) && 
/*  95 */       this._events != null && 
/*  96 */       postEventsForChanges()) {
/*  97 */       this._events.post(IPosTransactionLinkProperty.SET_LINKBUSINESSDATE, argLinkBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkBusinessDate_noev(Date argLinkBusinessDate) {
/* 104 */     boolean ev_postable = false;
/*     */     
/* 106 */     if ((getDAO_().getLinkBusinessDate() == null && argLinkBusinessDate != null) || (
/* 107 */       getDAO_().getLinkBusinessDate() != null && !getDAO_().getLinkBusinessDate().equals(argLinkBusinessDate))) {
/* 108 */       getDAO_().setLinkBusinessDate(argLinkBusinessDate);
/* 109 */       ev_postable = true;
/*     */     } 
/*     */     
/* 112 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLinkRetailLocationId() {
/* 120 */     if (getDAO_().getLinkRetailLocationId() != null) {
/* 121 */       return getDAO_().getLinkRetailLocationId().longValue();
/*     */     }
/*     */     
/* 124 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkRetailLocationId(long argLinkRetailLocationId) {
/* 133 */     if (setLinkRetailLocationId_noev(argLinkRetailLocationId) && 
/* 134 */       this._events != null && 
/* 135 */       postEventsForChanges()) {
/* 136 */       this._events.post(IPosTransactionLinkProperty.SET_LINKRETAILLOCATIONID, Long.valueOf(argLinkRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkRetailLocationId_noev(long argLinkRetailLocationId) {
/* 143 */     boolean ev_postable = false;
/*     */     
/* 145 */     if ((getDAO_().getLinkRetailLocationId() == null && Long.valueOf(argLinkRetailLocationId) != null) || (
/* 146 */       getDAO_().getLinkRetailLocationId() != null && !getDAO_().getLinkRetailLocationId().equals(Long.valueOf(argLinkRetailLocationId)))) {
/* 147 */       getDAO_().setLinkRetailLocationId(Long.valueOf(argLinkRetailLocationId));
/* 148 */       ev_postable = true;
/*     */     } 
/*     */     
/* 151 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLinkTransactionSequence() {
/* 159 */     if (getDAO_().getLinkTransactionSequence() != null) {
/* 160 */       return getDAO_().getLinkTransactionSequence().longValue();
/*     */     }
/*     */     
/* 163 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkTransactionSequence(long argLinkTransactionSequence) {
/* 172 */     if (setLinkTransactionSequence_noev(argLinkTransactionSequence) && 
/* 173 */       this._events != null && 
/* 174 */       postEventsForChanges()) {
/* 175 */       this._events.post(IPosTransactionLinkProperty.SET_LINKTRANSACTIONSEQUENCE, Long.valueOf(argLinkTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkTransactionSequence_noev(long argLinkTransactionSequence) {
/* 182 */     boolean ev_postable = false;
/*     */     
/* 184 */     if ((getDAO_().getLinkTransactionSequence() == null && Long.valueOf(argLinkTransactionSequence) != null) || (
/* 185 */       getDAO_().getLinkTransactionSequence() != null && !getDAO_().getLinkTransactionSequence().equals(Long.valueOf(argLinkTransactionSequence)))) {
/* 186 */       getDAO_().setLinkTransactionSequence(Long.valueOf(argLinkTransactionSequence));
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
/*     */   public long getLinkWorkstationId() {
/* 198 */     if (getDAO_().getLinkWorkstationId() != null) {
/* 199 */       return getDAO_().getLinkWorkstationId().longValue();
/*     */     }
/*     */     
/* 202 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkWorkstationId(long argLinkWorkstationId) {
/* 211 */     if (setLinkWorkstationId_noev(argLinkWorkstationId) && 
/* 212 */       this._events != null && 
/* 213 */       postEventsForChanges()) {
/* 214 */       this._events.post(IPosTransactionLinkProperty.SET_LINKWORKSTATIONID, Long.valueOf(argLinkWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLinkWorkstationId_noev(long argLinkWorkstationId) {
/* 221 */     boolean ev_postable = false;
/*     */     
/* 223 */     if ((getDAO_().getLinkWorkstationId() == null && Long.valueOf(argLinkWorkstationId) != null) || (
/* 224 */       getDAO_().getLinkWorkstationId() != null && !getDAO_().getLinkWorkstationId().equals(Long.valueOf(argLinkWorkstationId)))) {
/* 225 */       getDAO_().setLinkWorkstationId(Long.valueOf(argLinkWorkstationId));
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
/*     */   public long getOrganizationId() {
/* 237 */     if (getDAO_().getOrganizationId() != null) {
/* 238 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/* 241 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 250 */     if (setOrganizationId_noev(argOrganizationId) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(IPosTransactionLinkProperty.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/* 263 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/* 264 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/* 265 */       ev_postable = true;
/*     */     } 
/*     */     
/* 268 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 276 */     if (getDAO_().getRetailLocationId() != null) {
/* 277 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 280 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 289 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 290 */       this._events != null && 
/* 291 */       postEventsForChanges()) {
/* 292 */       this._events.post(IPosTransactionLinkProperty.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 299 */     boolean ev_postable = false;
/*     */     
/* 301 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 302 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 303 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 304 */       ev_postable = true;
/*     */     } 
/*     */     
/* 307 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 315 */     if (getDAO_().getTransactionSequence() != null) {
/* 316 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 319 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 328 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 329 */       this._events != null && 
/* 330 */       postEventsForChanges()) {
/* 331 */       this._events.post(IPosTransactionLinkProperty.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 338 */     boolean ev_postable = false;
/*     */     
/* 340 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 341 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 342 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 343 */       ev_postable = true;
/*     */     } 
/*     */     
/* 346 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 354 */     if (getDAO_().getWorkstationId() != null) {
/* 355 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 358 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 367 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 368 */       this._events != null && 
/* 369 */       postEventsForChanges()) {
/* 370 */       this._events.post(IPosTransactionLinkProperty.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 377 */     boolean ev_postable = false;
/*     */     
/* 379 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 380 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 381 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 382 */       ev_postable = true;
/*     */     } 
/*     */     
/* 385 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/* 393 */     return getDAO_().getPropertyCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 401 */     if (setPropertyCode_noev(argPropertyCode) && 
/* 402 */       this._events != null && 
/* 403 */       postEventsForChanges()) {
/* 404 */       this._events.post(IPosTransactionLinkProperty.SET_PROPERTYCODE, argPropertyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPropertyCode_noev(String argPropertyCode) {
/* 411 */     boolean ev_postable = false;
/*     */     
/* 413 */     if ((getDAO_().getPropertyCode() == null && argPropertyCode != null) || (
/* 414 */       getDAO_().getPropertyCode() != null && !getDAO_().getPropertyCode().equals(argPropertyCode))) {
/* 415 */       getDAO_().setPropertyCode(argPropertyCode);
/* 416 */       ev_postable = true;
/*     */     } 
/*     */     
/* 419 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 427 */     return getDAO_().getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(String argType) {
/* 435 */     if (setType_noev(argType) && 
/* 436 */       this._events != null && 
/* 437 */       postEventsForChanges()) {
/* 438 */       this._events.post(IPosTransactionLinkProperty.SET_TYPE, argType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setType_noev(String argType) {
/* 445 */     boolean ev_postable = false;
/*     */     
/* 447 */     if ((getDAO_().getType() == null && argType != null) || (
/* 448 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 449 */       getDAO_().setType(argType);
/* 450 */       ev_postable = true;
/*     */     } 
/*     */     
/* 453 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 461 */     return getDAO_().getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 469 */     if (setStringValue_noev(argStringValue) && 
/* 470 */       this._events != null && 
/* 471 */       postEventsForChanges()) {
/* 472 */       this._events.post(IPosTransactionLinkProperty.SET_STRINGVALUE, argStringValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStringValue_noev(String argStringValue) {
/* 479 */     boolean ev_postable = false;
/*     */     
/* 481 */     if ((getDAO_().getStringValue() == null && argStringValue != null) || (
/* 482 */       getDAO_().getStringValue() != null && !getDAO_().getStringValue().equals(argStringValue))) {
/* 483 */       getDAO_().setStringValue(argStringValue);
/* 484 */       ev_postable = true;
/*     */     } 
/*     */     
/* 487 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 495 */     return getDAO_().getDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 503 */     if (setDateValue_noev(argDateValue) && 
/* 504 */       this._events != null && 
/* 505 */       postEventsForChanges()) {
/* 506 */       this._events.post(IPosTransactionLinkProperty.SET_DATEVALUE, argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDateValue_noev(Date argDateValue) {
/* 513 */     boolean ev_postable = false;
/*     */     
/* 515 */     if ((getDAO_().getDateValue() == null && argDateValue != null) || (
/* 516 */       getDAO_().getDateValue() != null && !getDAO_().getDateValue().equals(argDateValue))) {
/* 517 */       getDAO_().setDateValue(argDateValue);
/* 518 */       ev_postable = true;
/*     */     } 
/*     */     
/* 521 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 529 */     return getDAO_().getDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 537 */     if (setDecimalValue_noev(argDecimalValue) && 
/* 538 */       this._events != null && 
/* 539 */       postEventsForChanges()) {
/* 540 */       this._events.post(IPosTransactionLinkProperty.SET_DECIMALVALUE, argDecimalValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDecimalValue_noev(BigDecimal argDecimalValue) {
/* 547 */     boolean ev_postable = false;
/*     */     
/* 549 */     if ((getDAO_().getDecimalValue() == null && argDecimalValue != null) || (
/* 550 */       getDAO_().getDecimalValue() != null && !getDAO_().getDecimalValue().equals(argDecimalValue))) {
/* 551 */       getDAO_().setDecimalValue(argDecimalValue);
/* 552 */       ev_postable = true;
/*     */     } 
/*     */     
/* 555 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 563 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 571 */     if (setCreateDate_noev(argCreateDate) && 
/* 572 */       this._events != null && 
/* 573 */       postEventsForChanges()) {
/* 574 */       this._events.post(IPosTransactionLinkProperty.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 581 */     boolean ev_postable = false;
/*     */     
/* 583 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 584 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 585 */       getDAO_().setCreateDate(argCreateDate);
/* 586 */       ev_postable = true;
/*     */     } 
/*     */     
/* 589 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 597 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 605 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 606 */       this._events != null && 
/* 607 */       postEventsForChanges()) {
/* 608 */       this._events.post(IPosTransactionLinkProperty.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 615 */     boolean ev_postable = false;
/*     */     
/* 617 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 618 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 619 */       getDAO_().setCreateUserId(argCreateUserId);
/* 620 */       ev_postable = true;
/*     */     } 
/*     */     
/* 623 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 631 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 639 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 640 */       this._events != null && 
/* 641 */       postEventsForChanges()) {
/* 642 */       this._events.post(IPosTransactionLinkProperty.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 649 */     boolean ev_postable = false;
/*     */     
/* 651 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 652 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 653 */       getDAO_().setUpdateDate(argUpdateDate);
/* 654 */       ev_postable = true;
/*     */     } 
/*     */     
/* 657 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 665 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 673 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 674 */       this._events != null && 
/* 675 */       postEventsForChanges()) {
/* 676 */       this._events.post(IPosTransactionLinkProperty.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 683 */     boolean ev_postable = false;
/*     */     
/* 685 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 686 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 687 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 688 */       ev_postable = true;
/*     */     } 
/*     */     
/* 691 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 697 */     if ("PosTransactionLinkPropertyExtension".equals(argFieldId)) {
/* 698 */       return this._myExtension;
/*     */     }
/*     */     
/* 701 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 707 */     if ("PosTransactionLinkPropertyExtension".equals(argFieldId)) {
/* 708 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 711 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 717 */     this._persistenceDefaults = argPD;
/* 718 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 719 */     this._eventManager = argEM;
/* 720 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 721 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 726 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 730 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 733 */     super.startTransaction();
/*     */ 
/*     */     
/* 736 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 741 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 744 */     super.rollbackChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 750 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 753 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 756 */     super.commitTransaction();
/*     */ 
/*     */     
/* 759 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 764 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkPropertyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */