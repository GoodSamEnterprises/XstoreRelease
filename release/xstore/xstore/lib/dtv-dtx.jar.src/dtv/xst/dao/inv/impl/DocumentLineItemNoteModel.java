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
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.inv.DocumentLineItemNotePropertyId;
/*     */ import dtv.xst.dao.inv.IDocumentLineItemNote;
/*     */ import dtv.xst.dao.inv.IDocumentLineItemNoteProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DocumentLineItemNoteModel extends AbstractDataModelWithPropertyImpl<IDocumentLineItemNoteProperty> implements IDocumentLineItemNote {
/*     */   private static final long serialVersionUID = 1348617876L;
/*     */   private IInventoryDocumentLineItem _parentDocument;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IParty _creatorParty; private transient IParty _creatorPartySavepoint; private HistoricalList<IDocumentLineItemNoteProperty> _properties; private transient HistoricalList<IDocumentLineItemNoteProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new DocumentLineItemNoteDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentLineItemNoteDAO getDAO_() {
/*  49 */     return (DocumentLineItemNoteDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  57 */     if (getDAO_().getOrganizationId() != null) {
/*  58 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  61 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  71 */       this._events != null && 
/*  72 */       postEventsForChanges()) {
/*  73 */       this._events.post(IDocumentLineItemNote.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  80 */     boolean ev_postable = false;
/*     */     
/*  82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  85 */       ev_postable = true;
/*  86 */       if (this._properties != null) {
/*     */         
/*  88 */         Iterator<DocumentLineItemNotePropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((DocumentLineItemNotePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 104 */     if (getDAO_().getRetailLocationId() != null) {
/* 105 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 108 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 117 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 118 */       this._events != null && 
/* 119 */       postEventsForChanges()) {
/* 120 */       this._events.post(IDocumentLineItemNote.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 127 */     boolean ev_postable = false;
/*     */     
/* 129 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 130 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 131 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 132 */       ev_postable = true;
/* 133 */       if (this._properties != null) {
/*     */         
/* 135 */         Iterator<DocumentLineItemNotePropertyModel> it = this._properties.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((DocumentLineItemNotePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/* 151 */     return getDAO_().getDocumentId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String argDocumentId) {
/* 159 */     if (setDocumentId_noev(argDocumentId) && 
/* 160 */       this._events != null && 
/* 161 */       postEventsForChanges()) {
/* 162 */       this._events.post(IDocumentLineItemNote.SET_DOCUMENTID, argDocumentId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentId_noev(String argDocumentId) {
/* 169 */     boolean ev_postable = false;
/*     */     
/* 171 */     if ((getDAO_().getDocumentId() == null && argDocumentId != null) || (
/* 172 */       getDAO_().getDocumentId() != null && !getDAO_().getDocumentId().equals(argDocumentId))) {
/* 173 */       getDAO_().setDocumentId(argDocumentId);
/* 174 */       ev_postable = true;
/* 175 */       if (this._properties != null) {
/*     */         
/* 177 */         Iterator<DocumentLineItemNotePropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((DocumentLineItemNotePropertyModel)it.next()).setDocumentId_noev(argDocumentId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentTypeCode() {
/* 193 */     return getDAO_().getDocumentTypeCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentTypeCode(String argDocumentTypeCode) {
/* 201 */     if (setDocumentTypeCode_noev(argDocumentTypeCode) && 
/* 202 */       this._events != null && 
/* 203 */       postEventsForChanges()) {
/* 204 */       this._events.post(IDocumentLineItemNote.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDocumentTypeCode_noev(String argDocumentTypeCode) {
/* 211 */     boolean ev_postable = false;
/*     */     
/* 213 */     if ((getDAO_().getDocumentTypeCode() == null && argDocumentTypeCode != null) || (
/* 214 */       getDAO_().getDocumentTypeCode() != null && !getDAO_().getDocumentTypeCode().equals(argDocumentTypeCode))) {
/* 215 */       getDAO_().setDocumentTypeCode(argDocumentTypeCode);
/* 216 */       ev_postable = true;
/* 217 */       if (this._properties != null) {
/*     */         
/* 219 */         Iterator<DocumentLineItemNotePropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((DocumentLineItemNotePropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryDocumentLineNumber() {
/* 235 */     if (getDAO_().getInventoryDocumentLineNumber() != null) {
/* 236 */       return getDAO_().getInventoryDocumentLineNumber().intValue();
/*     */     }
/*     */     
/* 239 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryDocumentLineNumber(int argInventoryDocumentLineNumber) {
/* 248 */     if (setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber) && 
/* 249 */       this._events != null && 
/* 250 */       postEventsForChanges()) {
/* 251 */       this._events.post(IDocumentLineItemNote.SET_INVENTORYDOCUMENTLINENUMBER, Integer.valueOf(argInventoryDocumentLineNumber));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setInventoryDocumentLineNumber_noev(int argInventoryDocumentLineNumber) {
/* 258 */     boolean ev_postable = false;
/*     */     
/* 260 */     if ((getDAO_().getInventoryDocumentLineNumber() == null && Integer.valueOf(argInventoryDocumentLineNumber) != null) || (
/* 261 */       getDAO_().getInventoryDocumentLineNumber() != null && !getDAO_().getInventoryDocumentLineNumber().equals(Integer.valueOf(argInventoryDocumentLineNumber)))) {
/* 262 */       getDAO_().setInventoryDocumentLineNumber(Integer.valueOf(argInventoryDocumentLineNumber));
/* 263 */       ev_postable = true;
/* 264 */       if (this._properties != null) {
/*     */         
/* 266 */         Iterator<DocumentLineItemNotePropertyModel> it = this._properties.iterator();
/* 267 */         while (it.hasNext())
/*     */         {
/* 269 */           ((DocumentLineItemNotePropertyModel)it.next()).setInventoryDocumentLineNumber_noev(argInventoryDocumentLineNumber);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 274 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNoteId() {
/* 282 */     if (getDAO_().getNoteId() != null) {
/* 283 */       return getDAO_().getNoteId().longValue();
/*     */     }
/*     */     
/* 286 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteId(long argNoteId) {
/* 295 */     if (setNoteId_noev(argNoteId) && 
/* 296 */       this._events != null && 
/* 297 */       postEventsForChanges()) {
/* 298 */       this._events.post(IDocumentLineItemNote.SET_NOTEID, Long.valueOf(argNoteId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteId_noev(long argNoteId) {
/* 305 */     boolean ev_postable = false;
/*     */     
/* 307 */     if ((getDAO_().getNoteId() == null && Long.valueOf(argNoteId) != null) || (
/* 308 */       getDAO_().getNoteId() != null && !getDAO_().getNoteId().equals(Long.valueOf(argNoteId)))) {
/* 309 */       getDAO_().setNoteId(Long.valueOf(argNoteId));
/* 310 */       ev_postable = true;
/* 311 */       if (this._properties != null) {
/*     */         
/* 313 */         Iterator<DocumentLineItemNotePropertyModel> it = this._properties.iterator();
/* 314 */         while (it.hasNext())
/*     */         {
/* 316 */           ((DocumentLineItemNotePropertyModel)it.next()).setNoteId_noev(argNoteId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 321 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 329 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 337 */     if (setCreateDate_noev(argCreateDate) && 
/* 338 */       this._events != null && 
/* 339 */       postEventsForChanges()) {
/* 340 */       this._events.post(IDocumentLineItemNote.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 347 */     boolean ev_postable = false;
/*     */     
/* 349 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 350 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 351 */       getDAO_().setCreateDate(argCreateDate);
/* 352 */       ev_postable = true;
/*     */     } 
/*     */     
/* 355 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 363 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 371 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 372 */       this._events != null && 
/* 373 */       postEventsForChanges()) {
/* 374 */       this._events.post(IDocumentLineItemNote.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 381 */     boolean ev_postable = false;
/*     */     
/* 383 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 384 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 385 */       getDAO_().setCreateUserId(argCreateUserId);
/* 386 */       ev_postable = true;
/*     */     } 
/*     */     
/* 389 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 397 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 405 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 406 */       this._events != null && 
/* 407 */       postEventsForChanges()) {
/* 408 */       this._events.post(IDocumentLineItemNote.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 415 */     boolean ev_postable = false;
/*     */     
/* 417 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 418 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 419 */       getDAO_().setUpdateDate(argUpdateDate);
/* 420 */       ev_postable = true;
/*     */     } 
/*     */     
/* 423 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 431 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 439 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 440 */       this._events != null && 
/* 441 */       postEventsForChanges()) {
/* 442 */       this._events.post(IDocumentLineItemNote.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 449 */     boolean ev_postable = false;
/*     */     
/* 451 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 452 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 453 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 454 */       ev_postable = true;
/*     */     } 
/*     */     
/* 457 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 465 */     return getDAO_().getNoteDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 473 */     if (setNoteDatetimestamp_noev(argNoteDatetimestamp) && 
/* 474 */       this._events != null && 
/* 475 */       postEventsForChanges()) {
/* 476 */       this._events.post(IDocumentLineItemNote.SET_NOTEDATETIMESTAMP, argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteDatetimestamp_noev(Date argNoteDatetimestamp) {
/* 483 */     boolean ev_postable = false;
/*     */     
/* 485 */     if ((getDAO_().getNoteDatetimestamp() == null && argNoteDatetimestamp != null) || (
/* 486 */       getDAO_().getNoteDatetimestamp() != null && !getDAO_().getNoteDatetimestamp().equals(argNoteDatetimestamp))) {
/* 487 */       getDAO_().setNoteDatetimestamp(argNoteDatetimestamp);
/* 488 */       ev_postable = true;
/*     */     } 
/*     */     
/* 491 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 499 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 507 */     if (setNote_noev(argNote) && 
/* 508 */       this._events != null && 
/* 509 */       postEventsForChanges()) {
/* 510 */       this._events.post(IDocumentLineItemNote.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 517 */     boolean ev_postable = false;
/*     */     
/* 519 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 520 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 521 */       getDAO_().setNote(argNote);
/* 522 */       ev_postable = true;
/*     */     } 
/*     */     
/* 525 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCreatorPartyId() {
/* 533 */     if (getDAO_().getCreatorPartyId() != null) {
/* 534 */       return getDAO_().getCreatorPartyId().longValue();
/*     */     }
/*     */     
/* 537 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorPartyId(long argCreatorPartyId) {
/* 546 */     if (setCreatorPartyId_noev(argCreatorPartyId) && 
/* 547 */       this._events != null && 
/* 548 */       postEventsForChanges()) {
/* 549 */       this._events.post(IDocumentLineItemNote.SET_CREATORPARTYID, Long.valueOf(argCreatorPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreatorPartyId_noev(long argCreatorPartyId) {
/* 556 */     boolean ev_postable = false;
/*     */     
/* 558 */     if ((getDAO_().getCreatorPartyId() == null && Long.valueOf(argCreatorPartyId) != null) || (
/* 559 */       getDAO_().getCreatorPartyId() != null && !getDAO_().getCreatorPartyId().equals(Long.valueOf(argCreatorPartyId)))) {
/* 560 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorPartyId));
/* 561 */       ev_postable = true;
/*     */     } 
/*     */     
/* 564 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNoteType() {
/* 572 */     return getDAO_().getNoteType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteType(String argNoteType) {
/* 580 */     if (setNoteType_noev(argNoteType) && 
/* 581 */       this._events != null && 
/* 582 */       postEventsForChanges()) {
/* 583 */       this._events.post(IDocumentLineItemNote.SET_NOTETYPE, argNoteType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteType_noev(String argNoteType) {
/* 590 */     boolean ev_postable = false;
/*     */     
/* 592 */     if ((getDAO_().getNoteType() == null && argNoteType != null) || (
/* 593 */       getDAO_().getNoteType() != null && !getDAO_().getNoteType().equals(argNoteType))) {
/* 594 */       getDAO_().setNoteType(argNoteType);
/* 595 */       ev_postable = true;
/*     */     } 
/*     */     
/* 598 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordCreationType() {
/* 606 */     return getDAO_().getRecordCreationType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordCreationType(String argRecordCreationType) {
/* 614 */     if (setRecordCreationType_noev(argRecordCreationType) && 
/* 615 */       this._events != null && 
/* 616 */       postEventsForChanges()) {
/* 617 */       this._events.post(IDocumentLineItemNote.SET_RECORDCREATIONTYPE, argRecordCreationType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRecordCreationType_noev(String argRecordCreationType) {
/* 624 */     boolean ev_postable = false;
/*     */     
/* 626 */     if ((getDAO_().getRecordCreationType() == null && argRecordCreationType != null) || (
/* 627 */       getDAO_().getRecordCreationType() != null && !getDAO_().getRecordCreationType().equals(argRecordCreationType))) {
/* 628 */       getDAO_().setRecordCreationType(argRecordCreationType);
/* 629 */       ev_postable = true;
/*     */     } 
/*     */     
/* 632 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDocumentLineItemNoteProperty newProperty(String argPropertyName) {
/* 636 */     DocumentLineItemNotePropertyId id = new DocumentLineItemNotePropertyId();
/*     */     
/* 638 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 639 */     id.setDocumentId(getDocumentId());
/* 640 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 641 */     id.setInventoryDocumentLineNumber(Integer.valueOf(getInventoryDocumentLineNumber()));
/* 642 */     id.setNoteId(Long.valueOf(getNoteId()));
/* 643 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 645 */     IDocumentLineItemNoteProperty prop = (IDocumentLineItemNoteProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDocumentLineItemNoteProperty.class);
/* 646 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "CreatorParty")
/*     */   public IParty getCreatorParty() {
/* 658 */     return this._creatorParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCreatorParty(IParty argCreatorParty) {
/* 663 */     if (argCreatorParty == null) {
/*     */       
/* 665 */       getDAO_().setCreatorPartyId(null);
/* 666 */       if (this._creatorParty != null)
/*     */       {
/* 668 */         if (postEventsForChanges()) {
/* 669 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._creatorParty));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 674 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorParty.getPartyId()));
/*     */       
/* 676 */       if (postEventsForChanges()) {
/* 677 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCreatorParty));
/*     */       }
/*     */     } 
/*     */     
/* 681 */     this._creatorParty = argCreatorParty;
/* 682 */     if (postEventsForChanges()) {
/* 683 */       this._events.post(IDocumentLineItemNote.SET_CREATORPARTY, argCreatorParty);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDocumentLineItemNoteProperty> getProperties() {
/* 689 */     if (this._properties == null) {
/* 690 */       this._properties = new HistoricalList(null);
/*     */     }
/* 692 */     return (List<IDocumentLineItemNoteProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDocumentLineItemNoteProperty> argProperties) {
/* 696 */     if (this._properties == null) {
/* 697 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 699 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 702 */     for (IDocumentLineItemNoteProperty child : this._properties) {
/* 703 */       DocumentLineItemNotePropertyModel model = (DocumentLineItemNotePropertyModel)child;
/* 704 */       model.setOrganizationId_noev(getOrganizationId());
/* 705 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 706 */       model.setDocumentId_noev(getDocumentId());
/* 707 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 708 */       model.setInventoryDocumentLineNumber_noev(getInventoryDocumentLineNumber());
/* 709 */       model.setNoteId_noev(getNoteId());
/* 710 */       if (child instanceof IDataModelImpl) {
/* 711 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 712 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 713 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 714 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 717 */       if (postEventsForChanges()) {
/* 718 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDocumentLineItemNoteProperty(IDocumentLineItemNoteProperty argDocumentLineItemNoteProperty) {
/* 724 */     if (this._properties == null) {
/* 725 */       this._properties = new HistoricalList(null);
/*     */     }
/* 727 */     argDocumentLineItemNoteProperty.setOrganizationId(getOrganizationId());
/* 728 */     argDocumentLineItemNoteProperty.setRetailLocationId(getRetailLocationId());
/* 729 */     argDocumentLineItemNoteProperty.setDocumentId(getDocumentId());
/* 730 */     argDocumentLineItemNoteProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 731 */     argDocumentLineItemNoteProperty.setInventoryDocumentLineNumber(getInventoryDocumentLineNumber());
/* 732 */     argDocumentLineItemNoteProperty.setNoteId(getNoteId());
/* 733 */     if (argDocumentLineItemNoteProperty instanceof IDataModelImpl) {
/* 734 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentLineItemNoteProperty).getDAO();
/* 735 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 736 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 737 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 742 */     if (postEventsForChanges()) {
/* 743 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentLineItemNoteProperty));
/*     */     }
/*     */     
/* 746 */     this._properties.add(argDocumentLineItemNoteProperty);
/* 747 */     if (postEventsForChanges()) {
/* 748 */       this._events.post(IDocumentLineItemNote.ADD_PROPERTIES, argDocumentLineItemNoteProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDocumentLineItemNoteProperty(IDocumentLineItemNoteProperty argDocumentLineItemNoteProperty) {
/* 753 */     if (this._properties != null) {
/*     */       
/* 755 */       if (postEventsForChanges()) {
/* 756 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentLineItemNoteProperty));
/*     */       }
/* 758 */       this._properties.remove(argDocumentLineItemNoteProperty);
/* 759 */       if (postEventsForChanges()) {
/* 760 */         this._events.post(IDocumentLineItemNote.REMOVE_PROPERTIES, argDocumentLineItemNoteProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentDocument(IInventoryDocumentLineItem argParentDocument) {
/* 766 */     this._parentDocument = argParentDocument;
/*     */   }
/*     */   
/*     */   public IInventoryDocumentLineItem getParentDocument() {
/* 770 */     return this._parentDocument;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 775 */     if ("CreatorParty".equals(argFieldId)) {
/* 776 */       return getCreatorParty();
/*     */     }
/* 778 */     if ("Properties".equals(argFieldId)) {
/* 779 */       return getProperties();
/*     */     }
/* 781 */     if ("DocumentLineItemNoteExtension".equals(argFieldId)) {
/* 782 */       return this._myExtension;
/*     */     }
/*     */     
/* 785 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 791 */     if ("CreatorParty".equals(argFieldId)) {
/* 792 */       setCreatorParty((IParty)argValue);
/*     */     }
/* 794 */     else if ("Properties".equals(argFieldId)) {
/* 795 */       setProperties(changeToList(argValue, IDocumentLineItemNoteProperty.class));
/*     */     }
/* 797 */     else if ("DocumentLineItemNoteExtension".equals(argFieldId)) {
/* 798 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 801 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 807 */     this._persistenceDefaults = argPD;
/* 808 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 809 */     this._eventManager = argEM;
/* 810 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 811 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 812 */     if (this._creatorParty != null) {
/* 813 */       ((IDataModelImpl)this._creatorParty).setDependencies(argPD, argEM);
/*     */     }
/* 815 */     if (this._properties != null) {
/* 816 */       for (IDocumentLineItemNoteProperty relationship : this._properties) {
/* 817 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDocumentLineItemNoteExt() {
/* 823 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDocumentLineItemNoteExt(IDataModel argExt) {
/* 827 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 832 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 836 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 839 */     super.startTransaction();
/*     */     
/* 841 */     this._creatorPartySavepoint = this._creatorParty;
/* 842 */     if (this._creatorParty != null) {
/* 843 */       this._creatorParty.startTransaction();
/*     */     }
/*     */     
/* 846 */     this._propertiesSavepoint = this._properties;
/* 847 */     if (this._properties != null) {
/* 848 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 849 */       Iterator<IDataModel> it = this._properties.iterator();
/* 850 */       while (it.hasNext()) {
/* 851 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 856 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 861 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 864 */     super.rollbackChanges();
/*     */     
/* 866 */     this._creatorParty = this._creatorPartySavepoint;
/* 867 */     this._creatorPartySavepoint = null;
/* 868 */     if (this._creatorParty != null) {
/* 869 */       this._creatorParty.rollbackChanges();
/*     */     }
/*     */     
/* 872 */     this._properties = this._propertiesSavepoint;
/* 873 */     this._propertiesSavepoint = null;
/* 874 */     if (this._properties != null) {
/* 875 */       Iterator<IDataModel> it = this._properties.iterator();
/* 876 */       while (it.hasNext()) {
/* 877 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 885 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 888 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 891 */     super.commitTransaction();
/*     */     
/* 893 */     this._creatorPartySavepoint = this._creatorParty;
/* 894 */     if (this._creatorParty != null) {
/* 895 */       this._creatorParty.commitTransaction();
/*     */     }
/*     */     
/* 898 */     this._propertiesSavepoint = this._properties;
/* 899 */     if (this._properties != null) {
/* 900 */       Iterator<IDataModel> it = this._properties.iterator();
/* 901 */       while (it.hasNext()) {
/* 902 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 904 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 908 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 913 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentLineItemNoteModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */