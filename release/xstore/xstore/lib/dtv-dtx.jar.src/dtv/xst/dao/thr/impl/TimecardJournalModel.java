/*     */ package dtv.xst.dao.thr.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.Relationship;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.crm.PartyId;
/*     */ import dtv.xst.dao.hrs.IWorkCodes;
/*     */ import dtv.xst.dao.thr.ITimecardJournal;
/*     */ import dtv.xst.dao.thr.ITimecardJournalProperty;
/*     */ import dtv.xst.dao.thr.TimecardJournalPropertyId;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TimecardJournalModel extends AbstractDataModelWithPropertyImpl<ITimecardJournalProperty> implements ITimecardJournal {
/*     */   private static final long serialVersionUID = -2077766406L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   private IDataModel _myExtension;
/*     */   
/*     */   public String toString() {
/*  34 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IWorkCodes _workCode; private transient IWorkCodes _workCodeSavepoint; private HistoricalList<ITimecardJournalProperty> _properties; private transient HistoricalList<ITimecardJournalProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  39 */     setDAO((IDataAccessObject)new TimecardJournalDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TimecardJournalDAO getDAO_() {
/*  47 */     return (TimecardJournalDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  55 */     if (getDAO_().getOrganizationId() != null) {
/*  56 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  59 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  69 */       this._events != null && 
/*  70 */       postEventsForChanges()) {
/*  71 */       this._events.post(ITimecardJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  78 */     boolean ev_postable = false;
/*     */     
/*  80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  83 */       ev_postable = true;
/*  84 */       if (this._properties != null) {
/*     */         
/*  86 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/*  87 */         while (it.hasNext())
/*     */         {
/*  89 */           ((TimecardJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 102 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 110 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 111 */       this._events != null && 
/* 112 */       postEventsForChanges()) {
/* 113 */       this._events.post(ITimecardJournal.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 120 */     boolean ev_postable = false;
/*     */     
/* 122 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 123 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 124 */       getDAO_().setBusinessDate(argBusinessDate);
/* 125 */       ev_postable = true;
/* 126 */       if (this._properties != null) {
/*     */         
/* 128 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/* 129 */         while (it.hasNext())
/*     */         {
/* 131 */           ((TimecardJournalPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 144 */     if (getDAO_().getRetailLocationId() != null) {
/* 145 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 148 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 157 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 158 */       this._events != null && 
/* 159 */       postEventsForChanges()) {
/* 160 */       this._events.post(ITimecardJournal.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 167 */     boolean ev_postable = false;
/*     */     
/* 169 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 170 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 171 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 172 */       ev_postable = true;
/* 173 */       if (this._properties != null) {
/*     */         
/* 175 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/* 176 */         while (it.hasNext())
/*     */         {
/* 178 */           ((TimecardJournalPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 191 */     if (getDAO_().getPartyId() != null) {
/* 192 */       return getDAO_().getPartyId().longValue();
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
/*     */   public void setPartyId(long argPartyId) {
/* 204 */     if (setPartyId_noev(argPartyId) && 
/* 205 */       this._events != null && 
/* 206 */       postEventsForChanges()) {
/* 207 */       this._events.post(ITimecardJournal.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 214 */     boolean ev_postable = false;
/*     */     
/* 216 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 217 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 218 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 219 */       ev_postable = true;
/* 220 */       if (this._properties != null) {
/*     */         
/* 222 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/* 223 */         while (it.hasNext())
/*     */         {
/* 225 */           ((TimecardJournalPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimecardEntryId() {
/* 238 */     if (getDAO_().getTimecardEntryId() != null) {
/* 239 */       return getDAO_().getTimecardEntryId().longValue();
/*     */     }
/*     */     
/* 242 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardEntryId(long argTimecardEntryId) {
/* 251 */     if (setTimecardEntryId_noev(argTimecardEntryId) && 
/* 252 */       this._events != null && 
/* 253 */       postEventsForChanges()) {
/* 254 */       this._events.post(ITimecardJournal.SET_TIMECARDENTRYID, Long.valueOf(argTimecardEntryId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntryId_noev(long argTimecardEntryId) {
/* 261 */     boolean ev_postable = false;
/*     */     
/* 263 */     if ((getDAO_().getTimecardEntryId() == null && Long.valueOf(argTimecardEntryId) != null) || (
/* 264 */       getDAO_().getTimecardEntryId() != null && !getDAO_().getTimecardEntryId().equals(Long.valueOf(argTimecardEntryId)))) {
/* 265 */       getDAO_().setTimecardEntryId(Long.valueOf(argTimecardEntryId));
/* 266 */       ev_postable = true;
/* 267 */       if (this._properties != null) {
/*     */         
/* 269 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/* 270 */         while (it.hasNext())
/*     */         {
/* 272 */           ((TimecardJournalPropertyModel)it.next()).setTimecardEntryId_noev(argTimecardEntryId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 277 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 285 */     if (getDAO_().getWorkstationId() != null) {
/* 286 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 289 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 298 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 299 */       this._events != null && 
/* 300 */       postEventsForChanges()) {
/* 301 */       this._events.post(ITimecardJournal.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 308 */     boolean ev_postable = false;
/*     */     
/* 310 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 311 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 312 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 313 */       ev_postable = true;
/* 314 */       if (this._properties != null) {
/*     */         
/* 316 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/* 317 */         while (it.hasNext())
/*     */         {
/* 319 */           ((TimecardJournalPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 324 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimecardEntrySeq() {
/* 332 */     if (getDAO_().getTimecardEntrySeq() != null) {
/* 333 */       return getDAO_().getTimecardEntrySeq().longValue();
/*     */     }
/*     */     
/* 336 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardEntrySeq(long argTimecardEntrySeq) {
/* 345 */     if (setTimecardEntrySeq_noev(argTimecardEntrySeq) && 
/* 346 */       this._events != null && 
/* 347 */       postEventsForChanges()) {
/* 348 */       this._events.post(ITimecardJournal.SET_TIMECARDENTRYSEQ, Long.valueOf(argTimecardEntrySeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntrySeq_noev(long argTimecardEntrySeq) {
/* 355 */     boolean ev_postable = false;
/*     */     
/* 357 */     if ((getDAO_().getTimecardEntrySeq() == null && Long.valueOf(argTimecardEntrySeq) != null) || (
/* 358 */       getDAO_().getTimecardEntrySeq() != null && !getDAO_().getTimecardEntrySeq().equals(Long.valueOf(argTimecardEntrySeq)))) {
/* 359 */       getDAO_().setTimecardEntrySeq(Long.valueOf(argTimecardEntrySeq));
/* 360 */       ev_postable = true;
/* 361 */       if (this._properties != null) {
/*     */         
/* 363 */         Iterator<TimecardJournalPropertyModel> it = this._properties.iterator();
/* 364 */         while (it.hasNext())
/*     */         {
/* 366 */           ((TimecardJournalPropertyModel)it.next()).setTimecardEntrySeq_noev(argTimecardEntrySeq);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 371 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 379 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 387 */     if (setCreateDate_noev(argCreateDate) && 
/* 388 */       this._events != null && 
/* 389 */       postEventsForChanges()) {
/* 390 */       this._events.post(ITimecardJournal.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 397 */     boolean ev_postable = false;
/*     */     
/* 399 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 400 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 401 */       getDAO_().setCreateDate(argCreateDate);
/* 402 */       ev_postable = true;
/*     */     } 
/*     */     
/* 405 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 413 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 421 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 422 */       this._events != null && 
/* 423 */       postEventsForChanges()) {
/* 424 */       this._events.post(ITimecardJournal.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 431 */     boolean ev_postable = false;
/*     */     
/* 433 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 434 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 435 */       getDAO_().setCreateUserId(argCreateUserId);
/* 436 */       ev_postable = true;
/*     */     } 
/*     */     
/* 439 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 447 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 455 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 456 */       this._events != null && 
/* 457 */       postEventsForChanges()) {
/* 458 */       this._events.post(ITimecardJournal.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 465 */     boolean ev_postable = false;
/*     */     
/* 467 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 468 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 469 */       getDAO_().setUpdateDate(argUpdateDate);
/* 470 */       ev_postable = true;
/*     */     } 
/*     */     
/* 473 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 481 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 489 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 490 */       this._events != null && 
/* 491 */       postEventsForChanges()) {
/* 492 */       this._events.post(ITimecardJournal.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 499 */     boolean ev_postable = false;
/*     */     
/* 501 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 502 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 503 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 504 */       ev_postable = true;
/*     */     } 
/*     */     
/* 507 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getClockInDateTime() {
/* 515 */     return getDAO_().getClockInDateTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClockInDateTime(Date argClockInDateTime) {
/* 523 */     if (setClockInDateTime_noev(argClockInDateTime) && 
/* 524 */       this._events != null && 
/* 525 */       postEventsForChanges()) {
/* 526 */       this._events.post(ITimecardJournal.SET_CLOCKINDATETIME, argClockInDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setClockInDateTime_noev(Date argClockInDateTime) {
/* 533 */     boolean ev_postable = false;
/*     */     
/* 535 */     if ((getDAO_().getClockInDateTime() == null && argClockInDateTime != null) || (
/* 536 */       getDAO_().getClockInDateTime() != null && !getDAO_().getClockInDateTime().equals(argClockInDateTime))) {
/* 537 */       getDAO_().setClockInDateTime(argClockInDateTime);
/* 538 */       ev_postable = true;
/*     */     } 
/*     */     
/* 541 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getClockOutDateTime() {
/* 549 */     return getDAO_().getClockOutDateTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClockOutDateTime(Date argClockOutDateTime) {
/* 557 */     if (setClockOutDateTime_noev(argClockOutDateTime) && 
/* 558 */       this._events != null && 
/* 559 */       postEventsForChanges()) {
/* 560 */       this._events.post(ITimecardJournal.SET_CLOCKOUTDATETIME, argClockOutDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setClockOutDateTime_noev(Date argClockOutDateTime) {
/* 567 */     boolean ev_postable = false;
/*     */     
/* 569 */     if ((getDAO_().getClockOutDateTime() == null && argClockOutDateTime != null) || (
/* 570 */       getDAO_().getClockOutDateTime() != null && !getDAO_().getClockOutDateTime().equals(argClockOutDateTime))) {
/* 571 */       getDAO_().setClockOutDateTime(argClockOutDateTime);
/* 572 */       ev_postable = true;
/*     */     } 
/*     */     
/* 575 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntryType() {
/* 583 */     return getDAO_().getEntryType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntryType(String argEntryType) {
/* 591 */     if (setEntryType_noev(argEntryType) && 
/* 592 */       this._events != null && 
/* 593 */       postEventsForChanges()) {
/* 594 */       this._events.post(ITimecardJournal.SET_ENTRYTYPE, argEntryType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setEntryType_noev(String argEntryType) {
/* 601 */     boolean ev_postable = false;
/*     */     
/* 603 */     if ((getDAO_().getEntryType() == null && argEntryType != null) || (
/* 604 */       getDAO_().getEntryType() != null && !getDAO_().getEntryType().equals(argEntryType))) {
/* 605 */       getDAO_().setEntryType(argEntryType);
/* 606 */       ev_postable = true;
/*     */     } 
/*     */     
/* 609 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDelete() {
/* 617 */     if (getDAO_().getDelete() != null) {
/* 618 */       return getDAO_().getDelete().booleanValue();
/*     */     }
/*     */     
/* 621 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDelete(boolean argDelete) {
/* 630 */     if (setDelete_noev(argDelete) && 
/* 631 */       this._events != null && 
/* 632 */       postEventsForChanges()) {
/* 633 */       this._events.post(ITimecardJournal.SET_DELETE, Boolean.valueOf(argDelete));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDelete_noev(boolean argDelete) {
/* 640 */     boolean ev_postable = false;
/*     */     
/* 642 */     if ((getDAO_().getDelete() == null && Boolean.valueOf(argDelete) != null) || (
/* 643 */       getDAO_().getDelete() != null && !getDAO_().getDelete().equals(Boolean.valueOf(argDelete)))) {
/* 644 */       getDAO_().setDelete(Boolean.valueOf(argDelete));
/* 645 */       ev_postable = true;
/*     */     } 
/*     */     
/* 648 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkCodeString() {
/* 656 */     return getDAO_().getWorkCodeString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkCodeString(String argWorkCodeString) {
/* 664 */     if (setWorkCodeString_noev(argWorkCodeString) && 
/* 665 */       this._events != null && 
/* 666 */       postEventsForChanges()) {
/* 667 */       this._events.post(ITimecardJournal.SET_WORKCODESTRING, argWorkCodeString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkCodeString_noev(String argWorkCodeString) {
/* 674 */     boolean ev_postable = false;
/*     */     
/* 676 */     if ((getDAO_().getWorkCodeString() == null && argWorkCodeString != null) || (
/* 677 */       getDAO_().getWorkCodeString() != null && !getDAO_().getWorkCodeString().equals(argWorkCodeString))) {
/* 678 */       getDAO_().setWorkCodeString(argWorkCodeString);
/* 679 */       ev_postable = true;
/*     */     } 
/*     */     
/* 682 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITimecardJournalProperty newProperty(String argPropertyName) {
/* 686 */     TimecardJournalPropertyId id = new TimecardJournalPropertyId();
/*     */     
/* 688 */     id.setBusinessDate(getBusinessDate());
/* 689 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 690 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 691 */     id.setTimecardEntryId(Long.valueOf(getTimecardEntryId()));
/* 692 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 693 */     id.setTimecardEntrySeq(Long.valueOf(getTimecardEntrySeq()));
/* 694 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 696 */     ITimecardJournalProperty prop = (ITimecardJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITimecardJournalProperty.class);
/* 697 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "WorkCode")
/*     */   public IWorkCodes getWorkCode() {
/* 709 */     return this._workCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorkCode(IWorkCodes argWorkCode) {
/* 714 */     if (argWorkCode == null) {
/*     */       
/* 716 */       getDAO_().setWorkCodeString(null);
/* 717 */       if (this._workCode != null)
/*     */       {
/* 719 */         if (postEventsForChanges()) {
/* 720 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workCode));
/*     */         }
/*     */       }
/*     */     } else {
/*     */       
/* 725 */       getDAO_().setWorkCodeString(argWorkCode.getWorkCode());
/*     */       
/* 727 */       if (postEventsForChanges()) {
/* 728 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCode));
/*     */       }
/*     */     } 
/*     */     
/* 732 */     this._workCode = argWorkCode;
/* 733 */     if (postEventsForChanges()) {
/* 734 */       this._events.post(ITimecardJournal.SET_WORKCODE, argWorkCode);
/*     */     }
/*     */   }
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITimecardJournalProperty> getProperties() {
/* 740 */     if (this._properties == null) {
/* 741 */       this._properties = new HistoricalList(null);
/*     */     }
/* 743 */     return (List<ITimecardJournalProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITimecardJournalProperty> argProperties) {
/* 747 */     if (this._properties == null) {
/* 748 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 750 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 753 */     for (ITimecardJournalProperty child : this._properties) {
/* 754 */       TimecardJournalPropertyModel model = (TimecardJournalPropertyModel)child;
/* 755 */       model.setOrganizationId_noev(getOrganizationId());
/* 756 */       model.setBusinessDate_noev(getBusinessDate());
/* 757 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 758 */       model.setPartyId_noev(getPartyId());
/* 759 */       model.setTimecardEntryId_noev(getTimecardEntryId());
/* 760 */       model.setWorkstationId_noev(getWorkstationId());
/* 761 */       model.setTimecardEntrySeq_noev(getTimecardEntrySeq());
/* 762 */       if (child instanceof IDataModelImpl) {
/* 763 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 764 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 765 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 766 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 769 */       if (postEventsForChanges()) {
/* 770 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTimecardJournalProperty(ITimecardJournalProperty argTimecardJournalProperty) {
/* 776 */     if (this._properties == null) {
/* 777 */       this._properties = new HistoricalList(null);
/*     */     }
/* 779 */     argTimecardJournalProperty.setOrganizationId(getOrganizationId());
/* 780 */     argTimecardJournalProperty.setBusinessDate(getBusinessDate());
/* 781 */     argTimecardJournalProperty.setRetailLocationId(getRetailLocationId());
/* 782 */     argTimecardJournalProperty.setPartyId(getPartyId());
/* 783 */     argTimecardJournalProperty.setTimecardEntryId(getTimecardEntryId());
/* 784 */     argTimecardJournalProperty.setWorkstationId(getWorkstationId());
/* 785 */     argTimecardJournalProperty.setTimecardEntrySeq(getTimecardEntrySeq());
/* 786 */     if (argTimecardJournalProperty instanceof IDataModelImpl) {
/* 787 */       IDataAccessObject childDao = ((IDataModelImpl)argTimecardJournalProperty).getDAO();
/* 788 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 789 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 790 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 795 */     if (postEventsForChanges()) {
/* 796 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTimecardJournalProperty));
/*     */     }
/*     */     
/* 799 */     this._properties.add(argTimecardJournalProperty);
/* 800 */     if (postEventsForChanges()) {
/* 801 */       this._events.post(ITimecardJournal.ADD_PROPERTIES, argTimecardJournalProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTimecardJournalProperty(ITimecardJournalProperty argTimecardJournalProperty) {
/* 806 */     if (this._properties != null) {
/*     */       
/* 808 */       if (postEventsForChanges()) {
/* 809 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTimecardJournalProperty));
/*     */       }
/* 811 */       this._properties.remove(argTimecardJournalProperty);
/* 812 */       if (postEventsForChanges()) {
/* 813 */         this._events.post(ITimecardJournal.REMOVE_PROPERTIES, argTimecardJournalProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 820 */     if ("WorkCode".equals(argFieldId)) {
/* 821 */       return getWorkCode();
/*     */     }
/* 823 */     if ("Properties".equals(argFieldId)) {
/* 824 */       return getProperties();
/*     */     }
/* 826 */     if ("TimecardJournalExtension".equals(argFieldId)) {
/* 827 */       return this._myExtension;
/*     */     }
/*     */     
/* 830 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 836 */     if ("WorkCode".equals(argFieldId)) {
/* 837 */       setWorkCode((IWorkCodes)argValue);
/*     */     }
/* 839 */     else if ("Properties".equals(argFieldId)) {
/* 840 */       setProperties(changeToList(argValue, ITimecardJournalProperty.class));
/*     */     }
/* 842 */     else if ("TimecardJournalExtension".equals(argFieldId)) {
/* 843 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 846 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 852 */     this._persistenceDefaults = argPD;
/* 853 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 854 */     this._eventManager = argEM;
/* 855 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 856 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 857 */     if (this._workCode != null) {
/* 858 */       ((IDataModelImpl)this._workCode).setDependencies(argPD, argEM);
/*     */     }
/* 860 */     if (this._properties != null) {
/* 861 */       for (ITimecardJournalProperty relationship : this._properties) {
/* 862 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTimecardJournalExt() {
/* 868 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTimecardJournalExt(IDataModel argExt) {
/* 872 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 877 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 881 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 884 */     super.startTransaction();
/*     */     
/* 886 */     this._workCodeSavepoint = this._workCode;
/* 887 */     if (this._workCode != null) {
/* 888 */       this._workCode.startTransaction();
/*     */     }
/*     */     
/* 891 */     this._propertiesSavepoint = this._properties;
/* 892 */     if (this._properties != null) {
/* 893 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 894 */       Iterator<IDataModel> it = this._properties.iterator();
/* 895 */       while (it.hasNext()) {
/* 896 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 901 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 906 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 909 */     super.rollbackChanges();
/*     */     
/* 911 */     this._workCode = this._workCodeSavepoint;
/* 912 */     this._workCodeSavepoint = null;
/* 913 */     if (this._workCode != null) {
/* 914 */       this._workCode.rollbackChanges();
/*     */     }
/*     */     
/* 917 */     this._properties = this._propertiesSavepoint;
/* 918 */     this._propertiesSavepoint = null;
/* 919 */     if (this._properties != null) {
/* 920 */       Iterator<IDataModel> it = this._properties.iterator();
/* 921 */       while (it.hasNext()) {
/* 922 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 930 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 933 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 936 */     super.commitTransaction();
/*     */     
/* 938 */     this._workCodeSavepoint = this._workCode;
/* 939 */     if (this._workCode != null) {
/* 940 */       this._workCode.commitTransaction();
/*     */     }
/*     */     
/* 943 */     this._propertiesSavepoint = this._properties;
/* 944 */     if (this._properties != null) {
/* 945 */       Iterator<IDataModel> it = this._properties.iterator();
/* 946 */       while (it.hasNext()) {
/* 947 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 949 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 953 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 958 */     argStream.defaultReadObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PartyId getPartyIdObject() {
/* 971 */     PartyId id = new PartyId();
/* 972 */     id.setPartyId(Long.valueOf(getPartyId()));
/*     */     
/* 974 */     return id;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getDeleteFormattable() {
/* 979 */     return getDelete() ? FormattableFactory.getInstance().getTranslatable("_voidEntry") : null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */