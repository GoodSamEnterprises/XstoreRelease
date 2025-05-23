/*     */ package dtv.xst.dao.com.impl;
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
/*     */ import dtv.xst.dao.com.ISequencePart;
/*     */ import dtv.xst.dao.com.ISequencePartProperty;
/*     */ import dtv.xst.dao.com.SequencePartPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SequencePartModel extends AbstractDataModelWithPropertyImpl<ISequencePartProperty> implements ISequencePart {
/*     */   private static final long serialVersionUID = 971889524L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ISequencePartProperty> _properties; private transient HistoricalList<ISequencePartProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new SequencePartDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SequencePartDAO getDAO_() {
/*  46 */     return (SequencePartDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(ISequencePart.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<SequencePartPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((SequencePartPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSequenceId() {
/* 101 */     return getDAO_().getSequenceId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceId(String argSequenceId) {
/* 109 */     if (setSequenceId_noev(argSequenceId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ISequencePart.SET_SEQUENCEID, argSequenceId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSequenceId_noev(String argSequenceId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getSequenceId() == null && argSequenceId != null) || (
/* 122 */       getDAO_().getSequenceId() != null && !getDAO_().getSequenceId().equals(argSequenceId))) {
/* 123 */       getDAO_().setSequenceId(argSequenceId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<SequencePartPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((SequencePartPropertyModel)it.next()).setSequenceId_noev(argSequenceId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 143 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 151 */     if (setCreateDate_noev(argCreateDate) && 
/* 152 */       this._events != null && 
/* 153 */       postEventsForChanges()) {
/* 154 */       this._events.post(ISequencePart.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 161 */     boolean ev_postable = false;
/*     */     
/* 163 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 164 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 165 */       getDAO_().setCreateDate(argCreateDate);
/* 166 */       ev_postable = true;
/*     */     } 
/*     */     
/* 169 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 177 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 185 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 186 */       this._events != null && 
/* 187 */       postEventsForChanges()) {
/* 188 */       this._events.post(ISequencePart.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 195 */     boolean ev_postable = false;
/*     */     
/* 197 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 198 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 199 */       getDAO_().setCreateUserId(argCreateUserId);
/* 200 */       ev_postable = true;
/*     */     } 
/*     */     
/* 203 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 211 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 219 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 220 */       this._events != null && 
/* 221 */       postEventsForChanges()) {
/* 222 */       this._events.post(ISequencePart.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 229 */     boolean ev_postable = false;
/*     */     
/* 231 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 232 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 233 */       getDAO_().setUpdateDate(argUpdateDate);
/* 234 */       ev_postable = true;
/*     */     } 
/*     */     
/* 237 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 245 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 253 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 254 */       this._events != null && 
/* 255 */       postEventsForChanges()) {
/* 256 */       this._events.post(ISequencePart.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 263 */     boolean ev_postable = false;
/*     */     
/* 265 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 266 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 267 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 268 */       ev_postable = true;
/*     */     } 
/*     */     
/* 271 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrefix() {
/* 279 */     return getDAO_().getPrefix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrefix(String argPrefix) {
/* 287 */     if (setPrefix_noev(argPrefix) && 
/* 288 */       this._events != null && 
/* 289 */       postEventsForChanges()) {
/* 290 */       this._events.post(ISequencePart.SET_PREFIX, argPrefix);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPrefix_noev(String argPrefix) {
/* 297 */     boolean ev_postable = false;
/*     */     
/* 299 */     if ((getDAO_().getPrefix() == null && argPrefix != null) || (
/* 300 */       getDAO_().getPrefix() != null && !getDAO_().getPrefix().equals(argPrefix))) {
/* 301 */       getDAO_().setPrefix(argPrefix);
/* 302 */       ev_postable = true;
/*     */     } 
/*     */     
/* 305 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuffix() {
/* 313 */     return getDAO_().getSuffix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuffix(String argSuffix) {
/* 321 */     if (setSuffix_noev(argSuffix) && 
/* 322 */       this._events != null && 
/* 323 */       postEventsForChanges()) {
/* 324 */       this._events.post(ISequencePart.SET_SUFFIX, argSuffix);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSuffix_noev(String argSuffix) {
/* 331 */     boolean ev_postable = false;
/*     */     
/* 333 */     if ((getDAO_().getSuffix() == null && argSuffix != null) || (
/* 334 */       getDAO_().getSuffix() != null && !getDAO_().getSuffix().equals(argSuffix))) {
/* 335 */       getDAO_().setSuffix(argSuffix);
/* 336 */       ev_postable = true;
/*     */     } 
/*     */     
/* 339 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEncode() {
/* 347 */     if (getDAO_().getEncode() != null) {
/* 348 */       return getDAO_().getEncode().booleanValue();
/*     */     }
/*     */     
/* 351 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEncode(boolean argEncode) {
/* 360 */     if (setEncode_noev(argEncode) && 
/* 361 */       this._events != null && 
/* 362 */       postEventsForChanges()) {
/* 363 */       this._events.post(ISequencePart.SET_ENCODE, Boolean.valueOf(argEncode));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEncode_noev(boolean argEncode) {
/* 370 */     boolean ev_postable = false;
/*     */     
/* 372 */     if ((getDAO_().getEncode() == null && Boolean.valueOf(argEncode) != null) || (
/* 373 */       getDAO_().getEncode() != null && !getDAO_().getEncode().equals(Boolean.valueOf(argEncode)))) {
/* 374 */       getDAO_().setEncode(Boolean.valueOf(argEncode));
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
/*     */   public String getCheckDigitAlgorithm() {
/* 386 */     return getDAO_().getCheckDigitAlgorithm();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCheckDigitAlgorithm(String argCheckDigitAlgorithm) {
/* 394 */     if (setCheckDigitAlgorithm_noev(argCheckDigitAlgorithm) && 
/* 395 */       this._events != null && 
/* 396 */       postEventsForChanges()) {
/* 397 */       this._events.post(ISequencePart.SET_CHECKDIGITALGORITHM, argCheckDigitAlgorithm);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCheckDigitAlgorithm_noev(String argCheckDigitAlgorithm) {
/* 404 */     boolean ev_postable = false;
/*     */     
/* 406 */     if ((getDAO_().getCheckDigitAlgorithm() == null && argCheckDigitAlgorithm != null) || (
/* 407 */       getDAO_().getCheckDigitAlgorithm() != null && !getDAO_().getCheckDigitAlgorithm().equals(argCheckDigitAlgorithm))) {
/* 408 */       getDAO_().setCheckDigitAlgorithm(argCheckDigitAlgorithm);
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
/*     */   public boolean getNumeric() {
/* 420 */     if (getDAO_().getNumeric() != null) {
/* 421 */       return getDAO_().getNumeric().booleanValue();
/*     */     }
/*     */     
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumeric(boolean argNumeric) {
/* 433 */     if (setNumeric_noev(argNumeric) && 
/* 434 */       this._events != null && 
/* 435 */       postEventsForChanges()) {
/* 436 */       this._events.post(ISequencePart.SET_NUMERIC, Boolean.valueOf(argNumeric));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNumeric_noev(boolean argNumeric) {
/* 443 */     boolean ev_postable = false;
/*     */     
/* 445 */     if ((getDAO_().getNumeric() == null && Boolean.valueOf(argNumeric) != null) || (
/* 446 */       getDAO_().getNumeric() != null && !getDAO_().getNumeric().equals(Boolean.valueOf(argNumeric)))) {
/* 447 */       getDAO_().setNumeric(Boolean.valueOf(argNumeric));
/* 448 */       ev_postable = true;
/*     */     } 
/*     */     
/* 451 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPadLength() {
/* 459 */     if (getDAO_().getPadLength() != null) {
/* 460 */       return getDAO_().getPadLength().longValue();
/*     */     }
/*     */     
/* 463 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPadLength(long argPadLength) {
/* 472 */     if (setPadLength_noev(argPadLength) && 
/* 473 */       this._events != null && 
/* 474 */       postEventsForChanges()) {
/* 475 */       this._events.post(ISequencePart.SET_PADLENGTH, Long.valueOf(argPadLength));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPadLength_noev(long argPadLength) {
/* 482 */     boolean ev_postable = false;
/*     */     
/* 484 */     if ((getDAO_().getPadLength() == null && Long.valueOf(argPadLength) != null) || (
/* 485 */       getDAO_().getPadLength() != null && !getDAO_().getPadLength().equals(Long.valueOf(argPadLength)))) {
/* 486 */       getDAO_().setPadLength(Long.valueOf(argPadLength));
/* 487 */       ev_postable = true;
/*     */     } 
/*     */     
/* 490 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPadCharacter() {
/* 498 */     return getDAO_().getPadCharacter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPadCharacter(String argPadCharacter) {
/* 506 */     if (setPadCharacter_noev(argPadCharacter) && 
/* 507 */       this._events != null && 
/* 508 */       postEventsForChanges()) {
/* 509 */       this._events.post(ISequencePart.SET_PADCHARACTER, argPadCharacter);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPadCharacter_noev(String argPadCharacter) {
/* 516 */     boolean ev_postable = false;
/*     */     
/* 518 */     if ((getDAO_().getPadCharacter() == null && argPadCharacter != null) || (
/* 519 */       getDAO_().getPadCharacter() != null && !getDAO_().getPadCharacter().equals(argPadCharacter))) {
/* 520 */       getDAO_().setPadCharacter(argPadCharacter);
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
/*     */   public long getInitialValue() {
/* 532 */     if (getDAO_().getInitialValue() != null) {
/* 533 */       return getDAO_().getInitialValue().longValue();
/*     */     }
/*     */     
/* 536 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInitialValue(long argInitialValue) {
/* 545 */     if (setInitialValue_noev(argInitialValue) && 
/* 546 */       this._events != null && 
/* 547 */       postEventsForChanges()) {
/* 548 */       this._events.post(ISequencePart.SET_INITIALVALUE, Long.valueOf(argInitialValue));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInitialValue_noev(long argInitialValue) {
/* 555 */     boolean ev_postable = false;
/*     */     
/* 557 */     if ((getDAO_().getInitialValue() == null && Long.valueOf(argInitialValue) != null) || (
/* 558 */       getDAO_().getInitialValue() != null && !getDAO_().getInitialValue().equals(Long.valueOf(argInitialValue)))) {
/* 559 */       getDAO_().setInitialValue(Long.valueOf(argInitialValue));
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
/*     */   public long getMaxValue() {
/* 571 */     if (getDAO_().getMaxValue() != null) {
/* 572 */       return getDAO_().getMaxValue().longValue();
/*     */     }
/*     */     
/* 575 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxValue(long argMaxValue) {
/* 584 */     if (setMaxValue_noev(argMaxValue) && 
/* 585 */       this._events != null && 
/* 586 */       postEventsForChanges()) {
/* 587 */       this._events.post(ISequencePart.SET_MAXVALUE, Long.valueOf(argMaxValue));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setMaxValue_noev(long argMaxValue) {
/* 594 */     boolean ev_postable = false;
/*     */     
/* 596 */     if ((getDAO_().getMaxValue() == null && Long.valueOf(argMaxValue) != null) || (
/* 597 */       getDAO_().getMaxValue() != null && !getDAO_().getMaxValue().equals(Long.valueOf(argMaxValue)))) {
/* 598 */       getDAO_().setMaxValue(Long.valueOf(argMaxValue));
/* 599 */       ev_postable = true;
/*     */     } 
/*     */     
/* 602 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getValueIncrement() {
/* 610 */     if (getDAO_().getValueIncrement() != null) {
/* 611 */       return getDAO_().getValueIncrement().longValue();
/*     */     }
/*     */     
/* 614 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueIncrement(long argValueIncrement) {
/* 623 */     if (setValueIncrement_noev(argValueIncrement) && 
/* 624 */       this._events != null && 
/* 625 */       postEventsForChanges()) {
/* 626 */       this._events.post(ISequencePart.SET_VALUEINCREMENT, Long.valueOf(argValueIncrement));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValueIncrement_noev(long argValueIncrement) {
/* 633 */     boolean ev_postable = false;
/*     */     
/* 635 */     if ((getDAO_().getValueIncrement() == null && Long.valueOf(argValueIncrement) != null) || (
/* 636 */       getDAO_().getValueIncrement() != null && !getDAO_().getValueIncrement().equals(Long.valueOf(argValueIncrement)))) {
/* 637 */       getDAO_().setValueIncrement(Long.valueOf(argValueIncrement));
/* 638 */       ev_postable = true;
/*     */     } 
/*     */     
/* 641 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIncludeStoreId() {
/* 649 */     if (getDAO_().getIncludeStoreId() != null) {
/* 650 */       return getDAO_().getIncludeStoreId().booleanValue();
/*     */     }
/*     */     
/* 653 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeStoreId(boolean argIncludeStoreId) {
/* 662 */     if (setIncludeStoreId_noev(argIncludeStoreId) && 
/* 663 */       this._events != null && 
/* 664 */       postEventsForChanges()) {
/* 665 */       this._events.post(ISequencePart.SET_INCLUDESTOREID, Boolean.valueOf(argIncludeStoreId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIncludeStoreId_noev(boolean argIncludeStoreId) {
/* 672 */     boolean ev_postable = false;
/*     */     
/* 674 */     if ((getDAO_().getIncludeStoreId() == null && Boolean.valueOf(argIncludeStoreId) != null) || (
/* 675 */       getDAO_().getIncludeStoreId() != null && !getDAO_().getIncludeStoreId().equals(Boolean.valueOf(argIncludeStoreId)))) {
/* 676 */       getDAO_().setIncludeStoreId(Boolean.valueOf(argIncludeStoreId));
/* 677 */       ev_postable = true;
/*     */     } 
/*     */     
/* 680 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getStorePadLength() {
/* 688 */     if (getDAO_().getStorePadLength() != null) {
/* 689 */       return getDAO_().getStorePadLength().longValue();
/*     */     }
/*     */     
/* 692 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStorePadLength(long argStorePadLength) {
/* 701 */     if (setStorePadLength_noev(argStorePadLength) && 
/* 702 */       this._events != null && 
/* 703 */       postEventsForChanges()) {
/* 704 */       this._events.post(ISequencePart.SET_STOREPADLENGTH, Long.valueOf(argStorePadLength));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setStorePadLength_noev(long argStorePadLength) {
/* 711 */     boolean ev_postable = false;
/*     */     
/* 713 */     if ((getDAO_().getStorePadLength() == null && Long.valueOf(argStorePadLength) != null) || (
/* 714 */       getDAO_().getStorePadLength() != null && !getDAO_().getStorePadLength().equals(Long.valueOf(argStorePadLength)))) {
/* 715 */       getDAO_().setStorePadLength(Long.valueOf(argStorePadLength));
/* 716 */       ev_postable = true;
/*     */     } 
/*     */     
/* 719 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIncludeWorkstationId() {
/* 727 */     if (getDAO_().getIncludeWorkstationId() != null) {
/* 728 */       return getDAO_().getIncludeWorkstationId().booleanValue();
/*     */     }
/*     */     
/* 731 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeWorkstationId(boolean argIncludeWorkstationId) {
/* 740 */     if (setIncludeWorkstationId_noev(argIncludeWorkstationId) && 
/* 741 */       this._events != null && 
/* 742 */       postEventsForChanges()) {
/* 743 */       this._events.post(ISequencePart.SET_INCLUDEWORKSTATIONID, Boolean.valueOf(argIncludeWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setIncludeWorkstationId_noev(boolean argIncludeWorkstationId) {
/* 750 */     boolean ev_postable = false;
/*     */     
/* 752 */     if ((getDAO_().getIncludeWorkstationId() == null && Boolean.valueOf(argIncludeWorkstationId) != null) || (
/* 753 */       getDAO_().getIncludeWorkstationId() != null && !getDAO_().getIncludeWorkstationId().equals(Boolean.valueOf(argIncludeWorkstationId)))) {
/* 754 */       getDAO_().setIncludeWorkstationId(Boolean.valueOf(argIncludeWorkstationId));
/* 755 */       ev_postable = true;
/*     */     } 
/*     */     
/* 758 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationPadLength() {
/* 766 */     if (getDAO_().getWorkstationPadLength() != null) {
/* 767 */       return getDAO_().getWorkstationPadLength().longValue();
/*     */     }
/*     */     
/* 770 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationPadLength(long argWorkstationPadLength) {
/* 779 */     if (setWorkstationPadLength_noev(argWorkstationPadLength) && 
/* 780 */       this._events != null && 
/* 781 */       postEventsForChanges()) {
/* 782 */       this._events.post(ISequencePart.SET_WORKSTATIONPADLENGTH, Long.valueOf(argWorkstationPadLength));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationPadLength_noev(long argWorkstationPadLength) {
/* 789 */     boolean ev_postable = false;
/*     */     
/* 791 */     if ((getDAO_().getWorkstationPadLength() == null && Long.valueOf(argWorkstationPadLength) != null) || (
/* 792 */       getDAO_().getWorkstationPadLength() != null && !getDAO_().getWorkstationPadLength().equals(Long.valueOf(argWorkstationPadLength)))) {
/* 793 */       getDAO_().setWorkstationPadLength(Long.valueOf(argWorkstationPadLength));
/* 794 */       ev_postable = true;
/*     */     } 
/*     */     
/* 797 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ISequencePartProperty newProperty(String argPropertyName) {
/* 801 */     SequencePartPropertyId id = new SequencePartPropertyId();
/*     */     
/* 803 */     id.setSequenceId(getSequenceId());
/* 804 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 806 */     ISequencePartProperty prop = (ISequencePartProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISequencePartProperty.class);
/* 807 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ISequencePartProperty> getProperties() {
/* 816 */     if (this._properties == null) {
/* 817 */       this._properties = new HistoricalList(null);
/*     */     }
/* 819 */     return (List<ISequencePartProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ISequencePartProperty> argProperties) {
/* 823 */     if (this._properties == null) {
/* 824 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 826 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 829 */     for (ISequencePartProperty child : this._properties) {
/* 830 */       SequencePartPropertyModel model = (SequencePartPropertyModel)child;
/* 831 */       model.setOrganizationId_noev(getOrganizationId());
/* 832 */       model.setSequenceId_noev(getSequenceId());
/* 833 */       if (child instanceof IDataModelImpl) {
/* 834 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 835 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 836 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 837 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 840 */       if (postEventsForChanges()) {
/* 841 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSequencePartProperty(ISequencePartProperty argSequencePartProperty) {
/* 847 */     if (this._properties == null) {
/* 848 */       this._properties = new HistoricalList(null);
/*     */     }
/* 850 */     argSequencePartProperty.setOrganizationId(getOrganizationId());
/* 851 */     argSequencePartProperty.setSequenceId(getSequenceId());
/* 852 */     if (argSequencePartProperty instanceof IDataModelImpl) {
/* 853 */       IDataAccessObject childDao = ((IDataModelImpl)argSequencePartProperty).getDAO();
/* 854 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 855 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 856 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 861 */     if (postEventsForChanges()) {
/* 862 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSequencePartProperty));
/*     */     }
/*     */     
/* 865 */     this._properties.add(argSequencePartProperty);
/* 866 */     if (postEventsForChanges()) {
/* 867 */       this._events.post(ISequencePart.ADD_PROPERTIES, argSequencePartProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSequencePartProperty(ISequencePartProperty argSequencePartProperty) {
/* 872 */     if (this._properties != null) {
/*     */       
/* 874 */       if (postEventsForChanges()) {
/* 875 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSequencePartProperty));
/*     */       }
/* 877 */       this._properties.remove(argSequencePartProperty);
/* 878 */       if (postEventsForChanges()) {
/* 879 */         this._events.post(ISequencePart.REMOVE_PROPERTIES, argSequencePartProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 886 */     if ("Properties".equals(argFieldId)) {
/* 887 */       return getProperties();
/*     */     }
/* 889 */     if ("SequencePartExtension".equals(argFieldId)) {
/* 890 */       return this._myExtension;
/*     */     }
/*     */     
/* 893 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 899 */     if ("Properties".equals(argFieldId)) {
/* 900 */       setProperties(changeToList(argValue, ISequencePartProperty.class));
/*     */     }
/* 902 */     else if ("SequencePartExtension".equals(argFieldId)) {
/* 903 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 906 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 912 */     this._persistenceDefaults = argPD;
/* 913 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 914 */     this._eventManager = argEM;
/* 915 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 916 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 917 */     if (this._properties != null) {
/* 918 */       for (ISequencePartProperty relationship : this._properties) {
/* 919 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getSequencePartExt() {
/* 925 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setSequencePartExt(IDataModel argExt) {
/* 929 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 934 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 938 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 941 */     super.startTransaction();
/*     */     
/* 943 */     this._propertiesSavepoint = this._properties;
/* 944 */     if (this._properties != null) {
/* 945 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 946 */       Iterator<IDataModel> it = this._properties.iterator();
/* 947 */       while (it.hasNext()) {
/* 948 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 953 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 958 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 961 */     super.rollbackChanges();
/*     */     
/* 963 */     this._properties = this._propertiesSavepoint;
/* 964 */     this._propertiesSavepoint = null;
/* 965 */     if (this._properties != null) {
/* 966 */       Iterator<IDataModel> it = this._properties.iterator();
/* 967 */       while (it.hasNext()) {
/* 968 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 976 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 979 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 982 */     super.commitTransaction();
/*     */     
/* 984 */     this._propertiesSavepoint = this._properties;
/* 985 */     if (this._properties != null) {
/* 986 */       Iterator<IDataModel> it = this._properties.iterator();
/* 987 */       while (it.hasNext()) {
/* 988 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 990 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 994 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 999 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequencePartModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */