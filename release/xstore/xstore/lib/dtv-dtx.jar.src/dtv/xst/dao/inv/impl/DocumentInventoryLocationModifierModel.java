/*     */ package dtv.xst.dao.inv.impl;
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
/*     */ import dtv.xst.dao.inv.DocumentInventoryLocationModifierPropertyId;
/*     */ import dtv.xst.dao.inv.IDocumentInventoryLocationModifier;
/*     */ import dtv.xst.dao.inv.IDocumentInventoryLocationModifierProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DocumentInventoryLocationModifierModel extends AbstractDataModelWithPropertyImpl<IDocumentInventoryLocationModifierProperty> implements IDocumentInventoryLocationModifier {
/*     */   private static final long serialVersionUID = 432445997L;
/*     */   private IInventoryDocumentLineItem _parentLineItem;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   
/*     */   public String toString() {
/*  35 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IDocumentInventoryLocationModifierProperty> _properties; private transient HistoricalList<IDocumentInventoryLocationModifierProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  40 */     setDAO((IDataAccessObject)new DocumentInventoryLocationModifierDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentInventoryLocationModifierDAO getDAO_() {
/*  48 */     return (DocumentInventoryLocationModifierDAO)this._daoImpl;
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
/*  72 */       this._events.post(IDocumentInventoryLocationModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  87 */         Iterator<DocumentInventoryLocationModifierPropertyModel> it = this._properties.iterator();
/*  88 */         while (it.hasNext())
/*     */         {
/*  90 */           ((DocumentInventoryLocationModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 119 */       this._events.post(IDocumentInventoryLocationModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 134 */         Iterator<DocumentInventoryLocationModifierPropertyModel> it = this._properties.iterator();
/* 135 */         while (it.hasNext())
/*     */         {
/* 137 */           ((DocumentInventoryLocationModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*     */   public String getDocumentId() {
/* 150 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 158 */     if (setDocumentId_noev(argDocumentId) && 
/* 159 */       this._events != null && 
/* 160 */       postEventsForChanges()) {
/* 161 */       this._events.post(IDocumentInventoryLocationModifier.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 168 */     boolean ev_postable = false;
/*     */     
/* 170 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 171 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 172 */       getDAO_().setDocumentId(argDocumentId);
/* 173 */       ev_postable = true;
/* 174 */       if (this._properties != null) {
/*     */         
/* 176 */         Iterator<DocumentInventoryLocationModifierPropertyModel> it = this._properties.iterator();
/* 177 */         while (it.hasNext())
/*     */         {
/* 179 */           ((DocumentInventoryLocationModifierPropertyModel)it.next()).setDocumentId_noev(argDocumentId);
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
/*     */   public String getDocumentTypeCode() {
/* 192 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 200 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 201 */       this._events != null && 
/* 202 */       postEventsForChanges()) {
/* 203 */       this._events.post(IDocumentInventoryLocationModifier.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 210 */     boolean ev_postable = false;
/*     */     
/* 212 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 213 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 214 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 215 */       ev_postable = true;
/* 216 */       if (this._properties != null) {
/*     */         
/* 218 */         Iterator<DocumentInventoryLocationModifierPropertyModel> it = this._properties.iterator();
/* 219 */         while (it.hasNext())
/*     */         {
/* 221 */           ((DocumentInventoryLocationModifierPropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDocumentLineNumber() {
/* 234 */     if (getDAO_().getDocumentLineNumber() != null) {
/* 235 */       return getDAO_().getDocumentLineNumber().longValue();
/*     */     }
/*     */     
/* 238 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentLineNumber(long argDocumentLineNumber) {
/* 247 */     if (setDocumentLineNumber_noev(argDocumentLineNumber) && 
/* 248 */       this._events != null && 
/* 249 */       postEventsForChanges()) {
/* 250 */       this._events.post(IDocumentInventoryLocationModifier.SET_DOCUMENTLINENUMBER, Long.valueOf(argDocumentLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentLineNumber_noev(long argDocumentLineNumber) {
/* 257 */     boolean ev_postable = false;
/*     */     
/* 259 */     if ((getDAO_().getDocumentLineNumber() == null && Long.valueOf(argDocumentLineNumber) != null) || (
/* 260 */       getDAO_().getDocumentLineNumber() != null && !getDAO_().getDocumentLineNumber().equals(Long.valueOf(argDocumentLineNumber)))) {
/* 261 */       getDAO_().setDocumentLineNumber(Long.valueOf(argDocumentLineNumber));
/* 262 */       ev_postable = true;
/* 263 */       if (this._properties != null) {
/*     */         
/* 265 */         Iterator<DocumentInventoryLocationModifierPropertyModel> it = this._properties.iterator();
/* 266 */         while (it.hasNext())
/*     */         {
/* 268 */           ((DocumentInventoryLocationModifierPropertyModel)it.next()).setDocumentLineNumber_noev(argDocumentLineNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getModifierSequence() {
/* 281 */     if (getDAO_().getModifierSequence() != null) {
/* 282 */       return getDAO_().getModifierSequence().longValue();
/*     */     }
/*     */     
/* 285 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModifierSequence(long argModifierSequence) {
/* 294 */     if (setModifierSequence_noev(argModifierSequence) && 
/* 295 */       this._events != null && 
/* 296 */       postEventsForChanges()) {
/* 297 */       this._events.post(IDocumentInventoryLocationModifier.SET_MODIFIERSEQUENCE, Long.valueOf(argModifierSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setModifierSequence_noev(long argModifierSequence) {
/* 304 */     boolean ev_postable = false;
/*     */     
/* 306 */     if ((getDAO_().getModifierSequence() == null && Long.valueOf(argModifierSequence) != null) || (
/* 307 */       getDAO_().getModifierSequence() != null && !getDAO_().getModifierSequence().equals(Long.valueOf(argModifierSequence)))) {
/* 308 */       getDAO_().setModifierSequence(Long.valueOf(argModifierSequence));
/* 309 */       ev_postable = true;
/* 310 */       if (this._properties != null) {
/*     */         
/* 312 */         Iterator<DocumentInventoryLocationModifierPropertyModel> it = this._properties.iterator();
/* 313 */         while (it.hasNext())
/*     */         {
/* 315 */           ((DocumentInventoryLocationModifierPropertyModel)it.next()).setModifierSequence_noev(argModifierSequence);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 320 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 328 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 336 */     if (setCreateDate_noev(argCreateDate) && 
/* 337 */       this._events != null && 
/* 338 */       postEventsForChanges()) {
/* 339 */       this._events.post(IDocumentInventoryLocationModifier.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 346 */     boolean ev_postable = false;
/*     */     
/* 348 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 349 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 350 */       getDAO_().setCreateDate(argCreateDate);
/* 351 */       ev_postable = true;
/*     */     } 
/*     */     
/* 354 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 362 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 370 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 371 */       this._events != null && 
/* 372 */       postEventsForChanges()) {
/* 373 */       this._events.post(IDocumentInventoryLocationModifier.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 380 */     boolean ev_postable = false;
/*     */     
/* 382 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 383 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 384 */       getDAO_().setCreateUserId(argCreateUserId);
/* 385 */       ev_postable = true;
/*     */     } 
/*     */     
/* 388 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 396 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 404 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 405 */       this._events != null && 
/* 406 */       postEventsForChanges()) {
/* 407 */       this._events.post(IDocumentInventoryLocationModifier.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 414 */     boolean ev_postable = false;
/*     */     
/* 416 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 417 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 418 */       getDAO_().setUpdateDate(argUpdateDate);
/* 419 */       ev_postable = true;
/*     */     } 
/*     */     
/* 422 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 430 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 438 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 439 */       this._events != null && 
/* 440 */       postEventsForChanges()) {
/* 441 */       this._events.post(IDocumentInventoryLocationModifier.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 448 */     boolean ev_postable = false;
/*     */     
/* 450 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 451 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 452 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 453 */       ev_postable = true;
/*     */     } 
/*     */     
/* 456 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 464 */     return getDAO_().getSerialNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/* 472 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 473 */       this._events != null && 
/* 474 */       postEventsForChanges()) {
/* 475 */       this._events.post(IDocumentInventoryLocationModifier.SET_SERIALNUMBER, argSerialNumber);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 482 */     boolean ev_postable = false;
/*     */     
/* 484 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 485 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 486 */       getDAO_().setSerialNumber(argSerialNumber);
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
/*     */   public String getSourceLocationId() {
/* 498 */     return getDAO_().getSourceLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceLocationId(String argSourceLocationId) {
/* 506 */     if (setSourceLocationId_noev(argSourceLocationId) && 
/* 507 */       this._events != null && 
/* 508 */       postEventsForChanges()) {
/* 509 */       this._events.post(IDocumentInventoryLocationModifier.SET_SOURCELOCATIONID, argSourceLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSourceLocationId_noev(String argSourceLocationId) {
/* 516 */     boolean ev_postable = false;
/*     */     
/* 518 */     if ((getDAO_().getSourceLocationId() == null && argSourceLocationId != null) || (
/* 519 */       getDAO_().getSourceLocationId() != null && !getDAO_().getSourceLocationId().equals(argSourceLocationId))) {
/* 520 */       getDAO_().setSourceLocationId(argSourceLocationId);
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
/*     */   public String getSourceBucketId() {
/* 532 */     return getDAO_().getSourceBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceBucketId(String argSourceBucketId) {
/* 540 */     if (setSourceBucketId_noev(argSourceBucketId) && 
/* 541 */       this._events != null && 
/* 542 */       postEventsForChanges()) {
/* 543 */       this._events.post(IDocumentInventoryLocationModifier.SET_SOURCEBUCKETID, argSourceBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSourceBucketId_noev(String argSourceBucketId) {
/* 550 */     boolean ev_postable = false;
/*     */     
/* 552 */     if ((getDAO_().getSourceBucketId() == null && argSourceBucketId != null) || (
/* 553 */       getDAO_().getSourceBucketId() != null && !getDAO_().getSourceBucketId().equals(argSourceBucketId))) {
/* 554 */       getDAO_().setSourceBucketId(argSourceBucketId);
/* 555 */       ev_postable = true;
/*     */     } 
/*     */     
/* 558 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationLocationId() {
/* 566 */     return getDAO_().getDestinationLocationId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationLocationId(String argDestinationLocationId) {
/* 574 */     if (setDestinationLocationId_noev(argDestinationLocationId) && 
/* 575 */       this._events != null && 
/* 576 */       postEventsForChanges()) {
/* 577 */       this._events.post(IDocumentInventoryLocationModifier.SET_DESTINATIONLOCATIONID, argDestinationLocationId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationLocationId_noev(String argDestinationLocationId) {
/* 584 */     boolean ev_postable = false;
/*     */     
/* 586 */     if ((getDAO_().getDestinationLocationId() == null && argDestinationLocationId != null) || (
/* 587 */       getDAO_().getDestinationLocationId() != null && !getDAO_().getDestinationLocationId().equals(argDestinationLocationId))) {
/* 588 */       getDAO_().setDestinationLocationId(argDestinationLocationId);
/* 589 */       ev_postable = true;
/*     */     } 
/*     */     
/* 592 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationBucketId() {
/* 600 */     return getDAO_().getDestinationBucketId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationBucketId(String argDestinationBucketId) {
/* 608 */     if (setDestinationBucketId_noev(argDestinationBucketId) && 
/* 609 */       this._events != null && 
/* 610 */       postEventsForChanges()) {
/* 611 */       this._events.post(IDocumentInventoryLocationModifier.SET_DESTINATIONBUCKETID, argDestinationBucketId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDestinationBucketId_noev(String argDestinationBucketId) {
/* 618 */     boolean ev_postable = false;
/*     */     
/* 620 */     if ((getDAO_().getDestinationBucketId() == null && argDestinationBucketId != null) || (
/* 621 */       getDAO_().getDestinationBucketId() != null && !getDAO_().getDestinationBucketId().equals(argDestinationBucketId))) {
/* 622 */       getDAO_().setDestinationBucketId(argDestinationBucketId);
/* 623 */       ev_postable = true;
/*     */     } 
/*     */     
/* 626 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/* 634 */     return getDAO_().getItemId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 642 */     if (setItemId_noev(argItemId) && 
/* 643 */       this._events != null && 
/* 644 */       postEventsForChanges()) {
/* 645 */       this._events.post(IDocumentInventoryLocationModifier.SET_ITEMID, argItemId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setItemId_noev(String argItemId) {
/* 652 */     boolean ev_postable = false;
/*     */     
/* 654 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 655 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 656 */       getDAO_().setItemId(argItemId);
/* 657 */       ev_postable = true;
/*     */     } 
/*     */     
/* 660 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getQuantity() {
/* 668 */     return getDAO_().getQuantity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuantity(BigDecimal argQuantity) {
/* 676 */     if (setQuantity_noev(argQuantity) && 
/* 677 */       this._events != null && 
/* 678 */       postEventsForChanges()) {
/* 679 */       this._events.post(IDocumentInventoryLocationModifier.SET_QUANTITY, argQuantity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/* 686 */     boolean ev_postable = false;
/*     */     
/* 688 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/* 689 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/* 690 */       getDAO_().setQuantity(argQuantity);
/* 691 */       ev_postable = true;
/*     */     } 
/*     */     
/* 694 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionCode() {
/* 702 */     return getDAO_().getActionCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionCode(String argActionCode) {
/* 710 */     if (setActionCode_noev(argActionCode) && 
/* 711 */       this._events != null && 
/* 712 */       postEventsForChanges()) {
/* 713 */       this._events.post(IDocumentInventoryLocationModifier.SET_ACTIONCODE, argActionCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActionCode_noev(String argActionCode) {
/* 720 */     boolean ev_postable = false;
/*     */     
/* 722 */     if ((getDAO_().getActionCode() == null && argActionCode != null) || (
/* 723 */       getDAO_().getActionCode() != null && !getDAO_().getActionCode().equals(argActionCode))) {
/* 724 */       getDAO_().setActionCode(argActionCode);
/* 725 */       ev_postable = true;
/*     */     } 
/*     */     
/* 728 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getCost() {
/* 736 */     return getDAO_().getCost();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/* 744 */     if (setCost_noev(argCost) && 
/* 745 */       this._events != null && 
/* 746 */       postEventsForChanges()) {
/* 747 */       this._events.post(IDocumentInventoryLocationModifier.SET_COST, argCost);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCost_noev(BigDecimal argCost) {
/* 754 */     boolean ev_postable = false;
/*     */     
/* 756 */     if ((getDAO_().getCost() == null && argCost != null) || (
/* 757 */       getDAO_().getCost() != null && !getDAO_().getCost().equals(argCost))) {
/* 758 */       getDAO_().setCost(argCost);
/* 759 */       ev_postable = true;
/*     */     } 
/*     */     
/* 762 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDocumentInventoryLocationModifierProperty newProperty(String argPropertyName) {
/* 766 */     DocumentInventoryLocationModifierPropertyId id = new DocumentInventoryLocationModifierPropertyId();
/*     */     
/* 768 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 769 */     id.setDocumentId(getDocumentId());
/* 770 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 771 */     id.setDocumentLineNumber(Long.valueOf(getDocumentLineNumber()));
/* 772 */     id.setModifierSequence(Long.valueOf(getModifierSequence()));
/* 773 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 775 */     IDocumentInventoryLocationModifierProperty prop = (IDocumentInventoryLocationModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDocumentInventoryLocationModifierProperty.class);
/* 776 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDocumentInventoryLocationModifierProperty> getProperties() {
/* 785 */     if (this._properties == null) {
/* 786 */       this._properties = new HistoricalList(null);
/*     */     }
/* 788 */     return (List<IDocumentInventoryLocationModifierProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDocumentInventoryLocationModifierProperty> argProperties) {
/* 792 */     if (this._properties == null) {
/* 793 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 795 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 798 */     for (IDocumentInventoryLocationModifierProperty child : this._properties) {
/* 799 */       DocumentInventoryLocationModifierPropertyModel model = (DocumentInventoryLocationModifierPropertyModel)child;
/* 800 */       model.setOrganizationId_noev(getOrganizationId());
/* 801 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 802 */       model.setDocumentId_noev(getDocumentId());
/* 803 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 804 */       model.setDocumentLineNumber_noev(getDocumentLineNumber());
/* 805 */       model.setModifierSequence_noev(getModifierSequence());
/* 806 */       if (child instanceof IDataModelImpl) {
/* 807 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 808 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 809 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 810 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 813 */       if (postEventsForChanges()) {
/* 814 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDocumentInventoryLocationModifierProperty(IDocumentInventoryLocationModifierProperty argDocumentInventoryLocationModifierProperty) {
/* 820 */     if (this._properties == null) {
/* 821 */       this._properties = new HistoricalList(null);
/*     */     }
/* 823 */     argDocumentInventoryLocationModifierProperty.setOrganizationId(getOrganizationId());
/* 824 */     argDocumentInventoryLocationModifierProperty.setRetailLocationId(getRetailLocationId());
/* 825 */     argDocumentInventoryLocationModifierProperty.setDocumentId(getDocumentId());
/* 826 */     argDocumentInventoryLocationModifierProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 827 */     argDocumentInventoryLocationModifierProperty.setDocumentLineNumber(getDocumentLineNumber());
/* 828 */     argDocumentInventoryLocationModifierProperty.setModifierSequence(getModifierSequence());
/* 829 */     if (argDocumentInventoryLocationModifierProperty instanceof IDataModelImpl) {
/* 830 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentInventoryLocationModifierProperty).getDAO();
/* 831 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 832 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 833 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 838 */     if (postEventsForChanges()) {
/* 839 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentInventoryLocationModifierProperty));
/*     */     }
/*     */     
/* 842 */     this._properties.add(argDocumentInventoryLocationModifierProperty);
/* 843 */     if (postEventsForChanges()) {
/* 844 */       this._events.post(IDocumentInventoryLocationModifier.ADD_PROPERTIES, argDocumentInventoryLocationModifierProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDocumentInventoryLocationModifierProperty(IDocumentInventoryLocationModifierProperty argDocumentInventoryLocationModifierProperty) {
/* 849 */     if (this._properties != null) {
/*     */       
/* 851 */       if (postEventsForChanges()) {
/* 852 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentInventoryLocationModifierProperty));
/*     */       }
/* 854 */       this._properties.remove(argDocumentInventoryLocationModifierProperty);
/* 855 */       if (postEventsForChanges()) {
/* 856 */         this._events.post(IDocumentInventoryLocationModifier.REMOVE_PROPERTIES, argDocumentInventoryLocationModifierProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentLineItem(IInventoryDocumentLineItem argParentLineItem) {
/* 862 */     this._parentLineItem = argParentLineItem;
/*     */   }
/*     */   
/*     */   public IInventoryDocumentLineItem getParentLineItem() {
/* 866 */     return this._parentLineItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 871 */     if ("Properties".equals(argFieldId)) {
/* 872 */       return getProperties();
/*     */     }
/* 874 */     if ("DocumentInventoryLocationModifierExtension".equals(argFieldId)) {
/* 875 */       return this._myExtension;
/*     */     }
/*     */     
/* 878 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 884 */     if ("Properties".equals(argFieldId)) {
/* 885 */       setProperties(changeToList(argValue, IDocumentInventoryLocationModifierProperty.class));
/*     */     }
/* 887 */     else if ("DocumentInventoryLocationModifierExtension".equals(argFieldId)) {
/* 888 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 891 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 897 */     this._persistenceDefaults = argPD;
/* 898 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 899 */     this._eventManager = argEM;
/* 900 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 901 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 902 */     if (this._properties != null) {
/* 903 */       for (IDocumentInventoryLocationModifierProperty relationship : this._properties) {
/* 904 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDocumentInventoryLocationModifierExt() {
/* 910 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDocumentInventoryLocationModifierExt(IDataModel argExt) {
/* 914 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 919 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 923 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 926 */     super.startTransaction();
/*     */     
/* 928 */     this._propertiesSavepoint = this._properties;
/* 929 */     if (this._properties != null) {
/* 930 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 931 */       Iterator<IDataModel> it = this._properties.iterator();
/* 932 */       while (it.hasNext()) {
/* 933 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 938 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 943 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 946 */     super.rollbackChanges();
/*     */     
/* 948 */     this._properties = this._propertiesSavepoint;
/* 949 */     this._propertiesSavepoint = null;
/* 950 */     if (this._properties != null) {
/* 951 */       Iterator<IDataModel> it = this._properties.iterator();
/* 952 */       while (it.hasNext()) {
/* 953 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 961 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 964 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 967 */     super.commitTransaction();
/*     */     
/* 969 */     this._propertiesSavepoint = this._properties;
/* 970 */     if (this._properties != null) {
/* 971 */       Iterator<IDataModel> it = this._properties.iterator();
/* 972 */       while (it.hasNext()) {
/* 973 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 975 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 979 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 984 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentInventoryLocationModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */