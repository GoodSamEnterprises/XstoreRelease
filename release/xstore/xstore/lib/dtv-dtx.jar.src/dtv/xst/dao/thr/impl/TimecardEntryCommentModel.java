/*     */ package dtv.xst.dao.thr.impl;
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
/*     */ import dtv.xst.dao.thr.ITimecardEntryComment;
/*     */ import dtv.xst.dao.thr.ITimecardEntryCommentProperty;
/*     */ import dtv.xst.dao.thr.TimecardEntryCommentPropertyId;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TimecardEntryCommentModel extends AbstractDataModelWithPropertyImpl<ITimecardEntryCommentProperty> implements ITimecardEntryComment {
/*     */   private static final long serialVersionUID = 1657830826L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<ITimecardEntryCommentProperty> _properties; private transient HistoricalList<ITimecardEntryCommentProperty> _propertiesSavepoint; private transient String _employeeId;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new TimecardEntryCommentDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TimecardEntryCommentDAO getDAO_() {
/*  46 */     return (TimecardEntryCommentDAO)this._daoImpl;
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
/*  70 */       this._events.post(ITimecardEntryComment.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*  85 */         Iterator<TimecardEntryCommentPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((TimecardEntryCommentPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*     */   public Date getWeekEndingDate() {
/* 101 */     return getDAO_().getWeekEndingDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/* 109 */     if (setWeekEndingDate_noev(argWeekEndingDate) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(ITimecardEntryComment.SET_WEEKENDINGDATE, argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWeekEndingDate_noev(Date argWeekEndingDate) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getWeekEndingDate() == null && argWeekEndingDate != null) || (
/* 122 */       getDAO_().getWeekEndingDate() != null && !getDAO_().getWeekEndingDate().equals(argWeekEndingDate))) {
/* 123 */       getDAO_().setWeekEndingDate(argWeekEndingDate);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<TimecardEntryCommentPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((TimecardEntryCommentPropertyModel)it.next()).setWeekEndingDate_noev(argWeekEndingDate);
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
/*     */   public long getRetailLocationId() {
/* 143 */     if (getDAO_().getRetailLocationId() != null) {
/* 144 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 156 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(ITimecardEntryComment.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 169 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 170 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<TimecardEntryCommentPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((TimecardEntryCommentPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 190 */     if (getDAO_().getWorkstationId() != null) {
/* 191 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 194 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 203 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 204 */       this._events != null && 
/* 205 */       postEventsForChanges()) {
/* 206 */       this._events.post(ITimecardEntryComment.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 213 */     boolean ev_postable = false;
/*     */     
/* 215 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 216 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 217 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 218 */       ev_postable = true;
/* 219 */       if (this._properties != null) {
/*     */         
/* 221 */         Iterator<TimecardEntryCommentPropertyModel> it = this._properties.iterator();
/* 222 */         while (it.hasNext())
/*     */         {
/* 224 */           ((TimecardEntryCommentPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPartyId() {
/* 237 */     if (getDAO_().getPartyId() != null) {
/* 238 */       return getDAO_().getPartyId().longValue();
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
/*     */   public void setPartyId(long argPartyId) {
/* 250 */     if (setPartyId_noev(argPartyId) && 
/* 251 */       this._events != null && 
/* 252 */       postEventsForChanges()) {
/* 253 */       this._events.post(ITimecardEntryComment.SET_PARTYID, Long.valueOf(argPartyId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPartyId_noev(long argPartyId) {
/* 260 */     boolean ev_postable = false;
/*     */     
/* 262 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/* 263 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/* 264 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/* 265 */       ev_postable = true;
/* 266 */       if (this._properties != null) {
/*     */         
/* 268 */         Iterator<TimecardEntryCommentPropertyModel> it = this._properties.iterator();
/* 269 */         while (it.hasNext())
/*     */         {
/* 271 */           ((TimecardEntryCommentPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCommentSeq() {
/* 284 */     if (getDAO_().getCommentSeq() != null) {
/* 285 */       return getDAO_().getCommentSeq().longValue();
/*     */     }
/*     */     
/* 288 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCommentSeq(long argCommentSeq) {
/* 297 */     if (setCommentSeq_noev(argCommentSeq) && 
/* 298 */       this._events != null && 
/* 299 */       postEventsForChanges()) {
/* 300 */       this._events.post(ITimecardEntryComment.SET_COMMENTSEQ, Long.valueOf(argCommentSeq));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCommentSeq_noev(long argCommentSeq) {
/* 307 */     boolean ev_postable = false;
/*     */     
/* 309 */     if ((getDAO_().getCommentSeq() == null && Long.valueOf(argCommentSeq) != null) || (
/* 310 */       getDAO_().getCommentSeq() != null && !getDAO_().getCommentSeq().equals(Long.valueOf(argCommentSeq)))) {
/* 311 */       getDAO_().setCommentSeq(Long.valueOf(argCommentSeq));
/* 312 */       ev_postable = true;
/* 313 */       if (this._properties != null) {
/*     */         
/* 315 */         Iterator<TimecardEntryCommentPropertyModel> it = this._properties.iterator();
/* 316 */         while (it.hasNext())
/*     */         {
/* 318 */           ((TimecardEntryCommentPropertyModel)it.next()).setCommentSeq_noev(argCommentSeq);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 331 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 339 */     if (setCreateDate_noev(argCreateDate) && 
/* 340 */       this._events != null && 
/* 341 */       postEventsForChanges()) {
/* 342 */       this._events.post(ITimecardEntryComment.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 349 */     boolean ev_postable = false;
/*     */     
/* 351 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 352 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 353 */       getDAO_().setCreateDate(argCreateDate);
/* 354 */       ev_postable = true;
/*     */     } 
/*     */     
/* 357 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 365 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 373 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 374 */       this._events != null && 
/* 375 */       postEventsForChanges()) {
/* 376 */       this._events.post(ITimecardEntryComment.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 383 */     boolean ev_postable = false;
/*     */     
/* 385 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 386 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 387 */       getDAO_().setCreateUserId(argCreateUserId);
/* 388 */       ev_postable = true;
/*     */     } 
/*     */     
/* 391 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 399 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 407 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 408 */       this._events != null && 
/* 409 */       postEventsForChanges()) {
/* 410 */       this._events.post(ITimecardEntryComment.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 417 */     boolean ev_postable = false;
/*     */     
/* 419 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 420 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 421 */       getDAO_().setUpdateDate(argUpdateDate);
/* 422 */       ev_postable = true;
/*     */     } 
/*     */     
/* 425 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 433 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 441 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 442 */       this._events != null && 
/* 443 */       postEventsForChanges()) {
/* 444 */       this._events.post(ITimecardEntryComment.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 451 */     boolean ev_postable = false;
/*     */     
/* 453 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 454 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 455 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 456 */       ev_postable = true;
/*     */     } 
/*     */     
/* 459 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCommentDateTime() {
/* 467 */     return getDAO_().getCommentDateTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCommentDateTime(Date argCommentDateTime) {
/* 475 */     if (setCommentDateTime_noev(argCommentDateTime) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(ITimecardEntryComment.SET_COMMENTDATETIME, argCommentDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCommentDateTime_noev(Date argCommentDateTime) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getCommentDateTime() == null && argCommentDateTime != null) || (
/* 488 */       getDAO_().getCommentDateTime() != null && !getDAO_().getCommentDateTime().equals(argCommentDateTime))) {
/* 489 */       getDAO_().setCommentDateTime(argCommentDateTime);
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommentText() {
/* 501 */     return getDAO_().getCommentText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCommentText(String argCommentText) {
/* 509 */     if (setCommentText_noev(argCommentText) && 
/* 510 */       this._events != null && 
/* 511 */       postEventsForChanges()) {
/* 512 */       this._events.post(ITimecardEntryComment.SET_COMMENTTEXT, argCommentText);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCommentText_noev(String argCommentText) {
/* 519 */     boolean ev_postable = false;
/*     */     
/* 521 */     if ((getDAO_().getCommentText() == null && argCommentText != null) || (
/* 522 */       getDAO_().getCommentText() != null && !getDAO_().getCommentText().equals(argCommentText))) {
/* 523 */       getDAO_().setCommentText(argCommentText);
/* 524 */       ev_postable = true;
/*     */     } 
/*     */     
/* 527 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreatorId() {
/* 535 */     return getDAO_().getCreatorId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorId(String argCreatorId) {
/* 543 */     if (setCreatorId_noev(argCreatorId) && 
/* 544 */       this._events != null && 
/* 545 */       postEventsForChanges()) {
/* 546 */       this._events.post(ITimecardEntryComment.SET_CREATORID, argCreatorId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreatorId_noev(String argCreatorId) {
/* 553 */     boolean ev_postable = false;
/*     */     
/* 555 */     if ((getDAO_().getCreatorId() == null && argCreatorId != null) || (
/* 556 */       getDAO_().getCreatorId() != null && !getDAO_().getCreatorId().equals(argCreatorId))) {
/* 557 */       getDAO_().setCreatorId(argCreatorId);
/* 558 */       ev_postable = true;
/*     */     } 
/*     */     
/* 561 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 569 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 577 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 578 */       this._events != null && 
/* 579 */       postEventsForChanges()) {
/* 580 */       this._events.post(ITimecardEntryComment.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 587 */     boolean ev_postable = false;
/*     */     
/* 589 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 590 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 591 */       getDAO_().setBusinessDate(argBusinessDate);
/* 592 */       ev_postable = true;
/*     */     } 
/*     */     
/* 595 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimecardEntryId() {
/* 603 */     if (getDAO_().getTimecardEntryId() != null) {
/* 604 */       return getDAO_().getTimecardEntryId().longValue();
/*     */     }
/*     */     
/* 607 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimecardEntryId(long argTimecardEntryId) {
/* 616 */     if (setTimecardEntryId_noev(argTimecardEntryId) && 
/* 617 */       this._events != null && 
/* 618 */       postEventsForChanges()) {
/* 619 */       this._events.post(ITimecardEntryComment.SET_TIMECARDENTRYID, Long.valueOf(argTimecardEntryId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTimecardEntryId_noev(long argTimecardEntryId) {
/* 626 */     boolean ev_postable = false;
/*     */     
/* 628 */     if ((getDAO_().getTimecardEntryId() == null && Long.valueOf(argTimecardEntryId) != null) || (
/* 629 */       getDAO_().getTimecardEntryId() != null && !getDAO_().getTimecardEntryId().equals(Long.valueOf(argTimecardEntryId)))) {
/* 630 */       getDAO_().setTimecardEntryId(Long.valueOf(argTimecardEntryId));
/* 631 */       ev_postable = true;
/*     */     } 
/*     */     
/* 634 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected ITimecardEntryCommentProperty newProperty(String argPropertyName) {
/* 638 */     TimecardEntryCommentPropertyId id = new TimecardEntryCommentPropertyId();
/*     */     
/* 640 */     id.setWeekEndingDate(getWeekEndingDate());
/* 641 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 642 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 643 */     id.setPartyId(Long.valueOf(getPartyId()));
/* 644 */     id.setCommentSeq(Long.valueOf(getCommentSeq()));
/* 645 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 647 */     ITimecardEntryCommentProperty prop = (ITimecardEntryCommentProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITimecardEntryCommentProperty.class);
/* 648 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<ITimecardEntryCommentProperty> getProperties() {
/* 657 */     if (this._properties == null) {
/* 658 */       this._properties = new HistoricalList(null);
/*     */     }
/* 660 */     return (List<ITimecardEntryCommentProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<ITimecardEntryCommentProperty> argProperties) {
/* 664 */     if (this._properties == null) {
/* 665 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 667 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 670 */     for (ITimecardEntryCommentProperty child : this._properties) {
/* 671 */       TimecardEntryCommentPropertyModel model = (TimecardEntryCommentPropertyModel)child;
/* 672 */       model.setOrganizationId_noev(getOrganizationId());
/* 673 */       model.setWeekEndingDate_noev(getWeekEndingDate());
/* 674 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 675 */       model.setWorkstationId_noev(getWorkstationId());
/* 676 */       model.setPartyId_noev(getPartyId());
/* 677 */       model.setCommentSeq_noev(getCommentSeq());
/* 678 */       if (child instanceof IDataModelImpl) {
/* 679 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 680 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 681 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 682 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 685 */       if (postEventsForChanges()) {
/* 686 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addTimecardEntryCommentProperty(ITimecardEntryCommentProperty argTimecardEntryCommentProperty) {
/* 692 */     if (this._properties == null) {
/* 693 */       this._properties = new HistoricalList(null);
/*     */     }
/* 695 */     argTimecardEntryCommentProperty.setOrganizationId(getOrganizationId());
/* 696 */     argTimecardEntryCommentProperty.setWeekEndingDate(getWeekEndingDate());
/* 697 */     argTimecardEntryCommentProperty.setRetailLocationId(getRetailLocationId());
/* 698 */     argTimecardEntryCommentProperty.setWorkstationId(getWorkstationId());
/* 699 */     argTimecardEntryCommentProperty.setPartyId(getPartyId());
/* 700 */     argTimecardEntryCommentProperty.setCommentSeq(getCommentSeq());
/* 701 */     if (argTimecardEntryCommentProperty instanceof IDataModelImpl) {
/* 702 */       IDataAccessObject childDao = ((IDataModelImpl)argTimecardEntryCommentProperty).getDAO();
/* 703 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 704 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 705 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 710 */     if (postEventsForChanges()) {
/* 711 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTimecardEntryCommentProperty));
/*     */     }
/*     */     
/* 714 */     this._properties.add(argTimecardEntryCommentProperty);
/* 715 */     if (postEventsForChanges()) {
/* 716 */       this._events.post(ITimecardEntryComment.ADD_PROPERTIES, argTimecardEntryCommentProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeTimecardEntryCommentProperty(ITimecardEntryCommentProperty argTimecardEntryCommentProperty) {
/* 721 */     if (this._properties != null) {
/*     */       
/* 723 */       if (postEventsForChanges()) {
/* 724 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTimecardEntryCommentProperty));
/*     */       }
/* 726 */       this._properties.remove(argTimecardEntryCommentProperty);
/* 727 */       if (postEventsForChanges()) {
/* 728 */         this._events.post(ITimecardEntryComment.REMOVE_PROPERTIES, argTimecardEntryCommentProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 735 */     if ("Properties".equals(argFieldId)) {
/* 736 */       return getProperties();
/*     */     }
/* 738 */     if ("TimecardEntryCommentExtension".equals(argFieldId)) {
/* 739 */       return this._myExtension;
/*     */     }
/*     */     
/* 742 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 748 */     if ("Properties".equals(argFieldId)) {
/* 749 */       setProperties(changeToList(argValue, ITimecardEntryCommentProperty.class));
/*     */     }
/* 751 */     else if ("TimecardEntryCommentExtension".equals(argFieldId)) {
/* 752 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 755 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 761 */     this._persistenceDefaults = argPD;
/* 762 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 763 */     this._eventManager = argEM;
/* 764 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 765 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 766 */     if (this._properties != null) {
/* 767 */       for (ITimecardEntryCommentProperty relationship : this._properties) {
/* 768 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getTimecardEntryCommentExt() {
/* 774 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setTimecardEntryCommentExt(IDataModel argExt) {
/* 778 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 783 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 787 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 790 */     super.startTransaction();
/*     */     
/* 792 */     this._propertiesSavepoint = this._properties;
/* 793 */     if (this._properties != null) {
/* 794 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 795 */       Iterator<IDataModel> it = this._properties.iterator();
/* 796 */       while (it.hasNext()) {
/* 797 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 802 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 807 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 810 */     super.rollbackChanges();
/*     */     
/* 812 */     this._properties = this._propertiesSavepoint;
/* 813 */     this._propertiesSavepoint = null;
/* 814 */     if (this._properties != null) {
/* 815 */       Iterator<IDataModel> it = this._properties.iterator();
/* 816 */       while (it.hasNext()) {
/* 817 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 825 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 828 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 831 */     super.commitTransaction();
/*     */     
/* 833 */     this._propertiesSavepoint = this._properties;
/* 834 */     if (this._properties != null) {
/* 835 */       Iterator<IDataModel> it = this._properties.iterator();
/* 836 */       while (it.hasNext()) {
/* 837 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 839 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 843 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 848 */     argStream.defaultReadObject();
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
/*     */ 
/*     */   
/*     */   public void setEmployeeId(String empId) {
/* 863 */     this._employeeId = empId;
/*     */   }
/*     */   
/*     */   public String getEmployeeId() {
/* 867 */     return this._employeeId;
/*     */   }
/*     */   
/*     */   public Date getBeginDateTimestamp() {
/* 871 */     return getCommentDateTime();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryCommentModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */