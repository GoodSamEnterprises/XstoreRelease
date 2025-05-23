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
/*     */ import dtv.xst.dao.inv.DocumentNotePropertyId;
/*     */ import dtv.xst.dao.inv.IDocumentNote;
/*     */ import dtv.xst.dao.inv.IDocumentNoteProperty;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DocumentNoteModel extends AbstractDataModelWithPropertyImpl<IDocumentNoteProperty> implements IDocumentNote {
/*     */   private static final long serialVersionUID = -1309064243L;
/*     */   private IInventoryDocument _parentDocument;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  36 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private IParty _creatorParty; private transient IParty _creatorPartySavepoint; private HistoricalList<IDocumentNoteProperty> _properties; private transient HistoricalList<IDocumentNoteProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  41 */     setDAO((IDataAccessObject)new DocumentNoteDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentNoteDAO getDAO_() {
/*  49 */     return (DocumentNoteDAO)this._daoImpl;
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
/*  73 */       this._events.post(IDocumentNote.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  88 */         Iterator<DocumentNotePropertyModel> it = this._properties.iterator();
/*  89 */         while (it.hasNext())
/*     */         {
/*  91 */           ((DocumentNotePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/* 120 */       this._events.post(IDocumentNote.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
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
/* 135 */         Iterator<DocumentNotePropertyModel> it = this._properties.iterator();
/* 136 */         while (it.hasNext())
/*     */         {
/* 138 */           ((DocumentNotePropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/* 162 */       this._events.post(IDocumentNote.SET_DOCUMENTID, argDocumentId);
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
/* 177 */         Iterator<DocumentNotePropertyModel> it = this._properties.iterator();
/* 178 */         while (it.hasNext())
/*     */         {
/* 180 */           ((DocumentNotePropertyModel)it.next()).setDocumentId_noev(argDocumentId);
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
/* 204 */       this._events.post(IDocumentNote.SET_DOCUMENTTYPECODE, argDocumentTypeCode);
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
/* 219 */         Iterator<DocumentNotePropertyModel> it = this._properties.iterator();
/* 220 */         while (it.hasNext())
/*     */         {
/* 222 */           ((DocumentNotePropertyModel)it.next()).setDocumentTypeCode_noev(argDocumentTypeCode);
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
/*     */   public long getNoteId() {
/* 235 */     if (getDAO_().getNoteId() != null) {
/* 236 */       return getDAO_().getNoteId().longValue();
/*     */     }
/*     */     
/* 239 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteId(long argNoteId) {
/* 248 */     if (setNoteId_noev(argNoteId) && 
/* 249 */       this._events != null && 
/* 250 */       postEventsForChanges()) {
/* 251 */       this._events.post(IDocumentNote.SET_NOTEID, Long.valueOf(argNoteId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteId_noev(long argNoteId) {
/* 258 */     boolean ev_postable = false;
/*     */     
/* 260 */     if ((getDAO_().getNoteId() == null && Long.valueOf(argNoteId) != null) || (
/* 261 */       getDAO_().getNoteId() != null && !getDAO_().getNoteId().equals(Long.valueOf(argNoteId)))) {
/* 262 */       getDAO_().setNoteId(Long.valueOf(argNoteId));
/* 263 */       ev_postable = true;
/* 264 */       if (this._properties != null) {
/*     */         
/* 266 */         Iterator<DocumentNotePropertyModel> it = this._properties.iterator();
/* 267 */         while (it.hasNext())
/*     */         {
/* 269 */           ((DocumentNotePropertyModel)it.next()).setNoteId_noev(argNoteId);
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
/*     */   public Date getCreateDate() {
/* 282 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 290 */     if (setCreateDate_noev(argCreateDate) && 
/* 291 */       this._events != null && 
/* 292 */       postEventsForChanges()) {
/* 293 */       this._events.post(IDocumentNote.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 300 */     boolean ev_postable = false;
/*     */     
/* 302 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 303 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 304 */       getDAO_().setCreateDate(argCreateDate);
/* 305 */       ev_postable = true;
/*     */     } 
/*     */     
/* 308 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 316 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 324 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 325 */       this._events != null && 
/* 326 */       postEventsForChanges()) {
/* 327 */       this._events.post(IDocumentNote.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 334 */     boolean ev_postable = false;
/*     */     
/* 336 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 337 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 338 */       getDAO_().setCreateUserId(argCreateUserId);
/* 339 */       ev_postable = true;
/*     */     } 
/*     */     
/* 342 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 350 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 358 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 359 */       this._events != null && 
/* 360 */       postEventsForChanges()) {
/* 361 */       this._events.post(IDocumentNote.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 368 */     boolean ev_postable = false;
/*     */     
/* 370 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 371 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 372 */       getDAO_().setUpdateDate(argUpdateDate);
/* 373 */       ev_postable = true;
/*     */     } 
/*     */     
/* 376 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 384 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 392 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 393 */       this._events != null && 
/* 394 */       postEventsForChanges()) {
/* 395 */       this._events.post(IDocumentNote.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 402 */     boolean ev_postable = false;
/*     */     
/* 404 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 405 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 406 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 407 */       ev_postable = true;
/*     */     } 
/*     */     
/* 410 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getNoteDatetimestamp() {
/* 418 */     return getDAO_().getNoteDatetimestamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteDatetimestamp(Date argNoteDatetimestamp) {
/* 426 */     if (setNoteDatetimestamp_noev(argNoteDatetimestamp) && 
/* 427 */       this._events != null && 
/* 428 */       postEventsForChanges()) {
/* 429 */       this._events.post(IDocumentNote.SET_NOTEDATETIMESTAMP, argNoteDatetimestamp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteDatetimestamp_noev(Date argNoteDatetimestamp) {
/* 436 */     boolean ev_postable = false;
/*     */     
/* 438 */     if ((getDAO_().getNoteDatetimestamp() == null && argNoteDatetimestamp != null) || (
/* 439 */       getDAO_().getNoteDatetimestamp() != null && !getDAO_().getNoteDatetimestamp().equals(argNoteDatetimestamp))) {
/* 440 */       getDAO_().setNoteDatetimestamp(argNoteDatetimestamp);
/* 441 */       ev_postable = true;
/*     */     } 
/*     */     
/* 444 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNote() {
/* 452 */     return getDAO_().getNote();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(String argNote) {
/* 460 */     if (setNote_noev(argNote) && 
/* 461 */       this._events != null && 
/* 462 */       postEventsForChanges()) {
/* 463 */       this._events.post(IDocumentNote.SET_NOTE, argNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNote_noev(String argNote) {
/* 470 */     boolean ev_postable = false;
/*     */     
/* 472 */     if ((getDAO_().getNote() == null && argNote != null) || (
/* 473 */       getDAO_().getNote() != null && !getDAO_().getNote().equals(argNote))) {
/* 474 */       getDAO_().setNote(argNote);
/* 475 */       ev_postable = true;
/*     */     } 
/*     */     
/* 478 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCreatorPartyId() {
/* 486 */     if (getDAO_().getCreatorPartyId() != null) {
/* 487 */       return getDAO_().getCreatorPartyId().longValue();
/*     */     }
/*     */     
/* 490 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorPartyId(long argCreatorPartyId) {
/* 499 */     if (setCreatorPartyId_noev(argCreatorPartyId) && 
/* 500 */       this._events != null && 
/* 501 */       postEventsForChanges()) {
/* 502 */       this._events.post(IDocumentNote.SET_CREATORPARTYID, Long.valueOf(argCreatorPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreatorPartyId_noev(long argCreatorPartyId) {
/* 509 */     boolean ev_postable = false;
/*     */     
/* 511 */     if ((getDAO_().getCreatorPartyId() == null && Long.valueOf(argCreatorPartyId) != null) || (
/* 512 */       getDAO_().getCreatorPartyId() != null && !getDAO_().getCreatorPartyId().equals(Long.valueOf(argCreatorPartyId)))) {
/* 513 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorPartyId));
/* 514 */       ev_postable = true;
/*     */     } 
/*     */     
/* 517 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNoteType() {
/* 525 */     return getDAO_().getNoteType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteType(String argNoteType) {
/* 533 */     if (setNoteType_noev(argNoteType) && 
/* 534 */       this._events != null && 
/* 535 */       postEventsForChanges()) {
/* 536 */       this._events.post(IDocumentNote.SET_NOTETYPE, argNoteType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNoteType_noev(String argNoteType) {
/* 543 */     boolean ev_postable = false;
/*     */     
/* 545 */     if ((getDAO_().getNoteType() == null && argNoteType != null) || (
/* 546 */       getDAO_().getNoteType() != null && !getDAO_().getNoteType().equals(argNoteType))) {
/* 547 */       getDAO_().setNoteType(argNoteType);
/* 548 */       ev_postable = true;
/*     */     } 
/*     */     
/* 551 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IDocumentNoteProperty newProperty(String argPropertyName) {
/* 555 */     DocumentNotePropertyId id = new DocumentNotePropertyId();
/*     */     
/* 557 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 558 */     id.setDocumentId(getDocumentId());
/* 559 */     id.setDocumentTypeCode(getDocumentTypeCode());
/* 560 */     id.setNoteId(Long.valueOf(getNoteId()));
/* 561 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 563 */     IDocumentNoteProperty prop = (IDocumentNoteProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDocumentNoteProperty.class);
/* 564 */     return prop;
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
/* 576 */     return this._creatorParty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCreatorParty(IParty argCreatorParty) {
/* 581 */     if (argCreatorParty == null) {
/*     */       
/* 583 */       getDAO_().setCreatorPartyId(null);
/* 584 */       if (this._creatorParty != null)
/*     */       {
/* 586 */         if (postEventsForChanges()) {
/* 587 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._creatorParty));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 592 */       getDAO_().setCreatorPartyId(Long.valueOf(argCreatorParty.getPartyId()));
/*     */       
/* 594 */       if (postEventsForChanges()) {
/* 595 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCreatorParty));
/*     */       }
/*     */     } 
/*     */     
/* 599 */     this._creatorParty = argCreatorParty;
/* 600 */     if (postEventsForChanges()) {
/* 601 */       this._events.post(IDocumentNote.SET_CREATORPARTY, argCreatorParty);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IDocumentNoteProperty> getProperties() {
/* 607 */     if (this._properties == null) {
/* 608 */       this._properties = new HistoricalList(null);
/*     */     }
/* 610 */     return (List<IDocumentNoteProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IDocumentNoteProperty> argProperties) {
/* 614 */     if (this._properties == null) {
/* 615 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 617 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 620 */     for (IDocumentNoteProperty child : this._properties) {
/* 621 */       DocumentNotePropertyModel model = (DocumentNotePropertyModel)child;
/* 622 */       model.setOrganizationId_noev(getOrganizationId());
/* 623 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 624 */       model.setDocumentId_noev(getDocumentId());
/* 625 */       model.setDocumentTypeCode_noev(getDocumentTypeCode());
/* 626 */       model.setNoteId_noev(getNoteId());
/* 627 */       if (child instanceof IDataModelImpl) {
/* 628 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 629 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 630 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 631 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 634 */       if (postEventsForChanges()) {
/* 635 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDocumentNoteProperty(IDocumentNoteProperty argDocumentNoteProperty) {
/* 641 */     if (this._properties == null) {
/* 642 */       this._properties = new HistoricalList(null);
/*     */     }
/* 644 */     argDocumentNoteProperty.setOrganizationId(getOrganizationId());
/* 645 */     argDocumentNoteProperty.setRetailLocationId(getRetailLocationId());
/* 646 */     argDocumentNoteProperty.setDocumentId(getDocumentId());
/* 647 */     argDocumentNoteProperty.setDocumentTypeCode(getDocumentTypeCode());
/* 648 */     argDocumentNoteProperty.setNoteId(getNoteId());
/* 649 */     if (argDocumentNoteProperty instanceof IDataModelImpl) {
/* 650 */       IDataAccessObject childDao = ((IDataModelImpl)argDocumentNoteProperty).getDAO();
/* 651 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 652 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 653 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 658 */     if (postEventsForChanges()) {
/* 659 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentNoteProperty));
/*     */     }
/*     */     
/* 662 */     this._properties.add(argDocumentNoteProperty);
/* 663 */     if (postEventsForChanges()) {
/* 664 */       this._events.post(IDocumentNote.ADD_PROPERTIES, argDocumentNoteProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeDocumentNoteProperty(IDocumentNoteProperty argDocumentNoteProperty) {
/* 669 */     if (this._properties != null) {
/*     */       
/* 671 */       if (postEventsForChanges()) {
/* 672 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDocumentNoteProperty));
/*     */       }
/* 674 */       this._properties.remove(argDocumentNoteProperty);
/* 675 */       if (postEventsForChanges()) {
/* 676 */         this._events.post(IDocumentNote.REMOVE_PROPERTIES, argDocumentNoteProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setParentDocument(IInventoryDocument argParentDocument) {
/* 682 */     this._parentDocument = argParentDocument;
/*     */   }
/*     */   
/*     */   public IInventoryDocument getParentDocument() {
/* 686 */     return this._parentDocument;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 691 */     if ("CreatorParty".equals(argFieldId)) {
/* 692 */       return getCreatorParty();
/*     */     }
/* 694 */     if ("Properties".equals(argFieldId)) {
/* 695 */       return getProperties();
/*     */     }
/* 697 */     if ("DocumentNoteExtension".equals(argFieldId)) {
/* 698 */       return this._myExtension;
/*     */     }
/*     */     
/* 701 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 707 */     if ("CreatorParty".equals(argFieldId)) {
/* 708 */       setCreatorParty((IParty)argValue);
/*     */     }
/* 710 */     else if ("Properties".equals(argFieldId)) {
/* 711 */       setProperties(changeToList(argValue, IDocumentNoteProperty.class));
/*     */     }
/* 713 */     else if ("DocumentNoteExtension".equals(argFieldId)) {
/* 714 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 717 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 723 */     this._persistenceDefaults = argPD;
/* 724 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 725 */     this._eventManager = argEM;
/* 726 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 727 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 728 */     if (this._creatorParty != null) {
/* 729 */       ((IDataModelImpl)this._creatorParty).setDependencies(argPD, argEM);
/*     */     }
/* 731 */     if (this._properties != null) {
/* 732 */       for (IDocumentNoteProperty relationship : this._properties) {
/* 733 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getDocumentNoteExt() {
/* 739 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setDocumentNoteExt(IDataModel argExt) {
/* 743 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 748 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 752 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 755 */     super.startTransaction();
/*     */     
/* 757 */     this._creatorPartySavepoint = this._creatorParty;
/* 758 */     if (this._creatorParty != null) {
/* 759 */       this._creatorParty.startTransaction();
/*     */     }
/*     */     
/* 762 */     this._propertiesSavepoint = this._properties;
/* 763 */     if (this._properties != null) {
/* 764 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 765 */       Iterator<IDataModel> it = this._properties.iterator();
/* 766 */       while (it.hasNext()) {
/* 767 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 772 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 777 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 780 */     super.rollbackChanges();
/*     */     
/* 782 */     this._creatorParty = this._creatorPartySavepoint;
/* 783 */     this._creatorPartySavepoint = null;
/* 784 */     if (this._creatorParty != null) {
/* 785 */       this._creatorParty.rollbackChanges();
/*     */     }
/*     */     
/* 788 */     this._properties = this._propertiesSavepoint;
/* 789 */     this._propertiesSavepoint = null;
/* 790 */     if (this._properties != null) {
/* 791 */       Iterator<IDataModel> it = this._properties.iterator();
/* 792 */       while (it.hasNext()) {
/* 793 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 801 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 804 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 807 */     super.commitTransaction();
/*     */     
/* 809 */     this._creatorPartySavepoint = this._creatorParty;
/* 810 */     if (this._creatorParty != null) {
/* 811 */       this._creatorParty.commitTransaction();
/*     */     }
/*     */     
/* 814 */     this._propertiesSavepoint = this._properties;
/* 815 */     if (this._properties != null) {
/* 816 */       Iterator<IDataModel> it = this._properties.iterator();
/* 817 */       while (it.hasNext()) {
/* 818 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 820 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 824 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 829 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\DocumentNoteModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */