/*      */ package dtv.xst.dao.thr.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.i18n.FormattableFactory;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.hrs.IWorkCodes;
/*      */ import dtv.xst.dao.thr.ITimecardEntry;
/*      */ import dtv.xst.dao.thr.ITimecardEntryProperty;
/*      */ import dtv.xst.dao.thr.TimecardEntryPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TimecardEntryModel extends AbstractDataModelWithPropertyImpl<ITimecardEntryProperty> implements ITimecardEntry {
/*      */   private static final long serialVersionUID = 556317429L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IWorkCodes _workCode;
/*      */   private transient IWorkCodes _workCodeSavepoint;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<ITimecardEntryProperty> _properties; private transient HistoricalList<ITimecardEntryProperty> _propertiesSavepoint; private transient boolean _updateFlag; private transient Date timecardDate; private transient boolean _postedFlag; private transient String _employeeId;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new TimecardEntryDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TimecardEntryDAO getDAO_() {
/*   47 */     return (TimecardEntryDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   55 */     if (getDAO_().getOrganizationId() != null) {
/*   56 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   59 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   69 */       this._events != null && 
/*   70 */       postEventsForChanges()) {
/*   71 */       this._events.post(ITimecardEntry.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   78 */     boolean ev_postable = false;
/*      */     
/*   80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   83 */       ev_postable = true;
/*   84 */       if (this._properties != null) {
/*      */         
/*   86 */         Iterator<TimecardEntryPropertyModel> it = this._properties.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((TimecardEntryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   94 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  102 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  110 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  111 */       this._events != null && 
/*  112 */       postEventsForChanges()) {
/*  113 */       this._events.post(ITimecardEntry.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  120 */     boolean ev_postable = false;
/*      */     
/*  122 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  123 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  124 */       getDAO_().setBusinessDate(argBusinessDate);
/*  125 */       ev_postable = true;
/*  126 */       if (this._properties != null) {
/*      */         
/*  128 */         Iterator<TimecardEntryPropertyModel> it = this._properties.iterator();
/*  129 */         while (it.hasNext())
/*      */         {
/*  131 */           ((TimecardEntryPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  136 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  144 */     if (getDAO_().getRetailLocationId() != null) {
/*  145 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  148 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  157 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  158 */       this._events != null && 
/*  159 */       postEventsForChanges()) {
/*  160 */       this._events.post(ITimecardEntry.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  167 */     boolean ev_postable = false;
/*      */     
/*  169 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  170 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  171 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  172 */       ev_postable = true;
/*  173 */       if (this._properties != null) {
/*      */         
/*  175 */         Iterator<TimecardEntryPropertyModel> it = this._properties.iterator();
/*  176 */         while (it.hasNext())
/*      */         {
/*  178 */           ((TimecardEntryPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  183 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  191 */     if (getDAO_().getPartyId() != null) {
/*  192 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  195 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  204 */     if (setPartyId_noev(argPartyId) && 
/*  205 */       this._events != null && 
/*  206 */       postEventsForChanges()) {
/*  207 */       this._events.post(ITimecardEntry.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  214 */     boolean ev_postable = false;
/*      */     
/*  216 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  217 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  218 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  219 */       ev_postable = true;
/*  220 */       if (this._properties != null) {
/*      */         
/*  222 */         Iterator<TimecardEntryPropertyModel> it = this._properties.iterator();
/*  223 */         while (it.hasNext())
/*      */         {
/*  225 */           ((TimecardEntryPropertyModel)it.next()).setPartyId_noev(argPartyId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  230 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTimecardEntryId() {
/*  238 */     if (getDAO_().getTimecardEntryId() != null) {
/*  239 */       return getDAO_().getTimecardEntryId().longValue();
/*      */     }
/*      */     
/*  242 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTimecardEntryId(long argTimecardEntryId) {
/*  251 */     if (setTimecardEntryId_noev(argTimecardEntryId) && 
/*  252 */       this._events != null && 
/*  253 */       postEventsForChanges()) {
/*  254 */       this._events.post(ITimecardEntry.SET_TIMECARDENTRYID, Long.valueOf(argTimecardEntryId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTimecardEntryId_noev(long argTimecardEntryId) {
/*  261 */     boolean ev_postable = false;
/*      */     
/*  263 */     if ((getDAO_().getTimecardEntryId() == null && Long.valueOf(argTimecardEntryId) != null) || (
/*  264 */       getDAO_().getTimecardEntryId() != null && !getDAO_().getTimecardEntryId().equals(Long.valueOf(argTimecardEntryId)))) {
/*  265 */       getDAO_().setTimecardEntryId(Long.valueOf(argTimecardEntryId));
/*  266 */       ev_postable = true;
/*  267 */       if (this._properties != null) {
/*      */         
/*  269 */         Iterator<TimecardEntryPropertyModel> it = this._properties.iterator();
/*  270 */         while (it.hasNext())
/*      */         {
/*  272 */           ((TimecardEntryPropertyModel)it.next()).setTimecardEntryId_noev(argTimecardEntryId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  277 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  285 */     if (getDAO_().getWorkstationId() != null) {
/*  286 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  289 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  298 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  299 */       this._events != null && 
/*  300 */       postEventsForChanges()) {
/*  301 */       this._events.post(ITimecardEntry.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  308 */     boolean ev_postable = false;
/*      */     
/*  310 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  311 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  312 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  313 */       ev_postable = true;
/*  314 */       if (this._properties != null) {
/*      */         
/*  316 */         Iterator<TimecardEntryPropertyModel> it = this._properties.iterator();
/*  317 */         while (it.hasNext())
/*      */         {
/*  319 */           ((TimecardEntryPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  324 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  332 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  340 */     if (setCreateDate_noev(argCreateDate) && 
/*  341 */       this._events != null && 
/*  342 */       postEventsForChanges()) {
/*  343 */       this._events.post(ITimecardEntry.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  350 */     boolean ev_postable = false;
/*      */     
/*  352 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  353 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  354 */       getDAO_().setCreateDate(argCreateDate);
/*  355 */       ev_postable = true;
/*      */     } 
/*      */     
/*  358 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  366 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  374 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  375 */       this._events != null && 
/*  376 */       postEventsForChanges()) {
/*  377 */       this._events.post(ITimecardEntry.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  384 */     boolean ev_postable = false;
/*      */     
/*  386 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  387 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  388 */       getDAO_().setCreateUserId(argCreateUserId);
/*  389 */       ev_postable = true;
/*      */     } 
/*      */     
/*  392 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  400 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  408 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  409 */       this._events != null && 
/*  410 */       postEventsForChanges()) {
/*  411 */       this._events.post(ITimecardEntry.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  418 */     boolean ev_postable = false;
/*      */     
/*  420 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  421 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  422 */       getDAO_().setUpdateDate(argUpdateDate);
/*  423 */       ev_postable = true;
/*      */     } 
/*      */     
/*  426 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  434 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  442 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  443 */       this._events != null && 
/*  444 */       postEventsForChanges()) {
/*  445 */       this._events.post(ITimecardEntry.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  452 */     boolean ev_postable = false;
/*      */     
/*  454 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  455 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  456 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  457 */       ev_postable = true;
/*      */     } 
/*      */     
/*  460 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getClockInDateTime() {
/*  468 */     return getDAO_().getClockInDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClockInDateTime(Date argClockInDateTime) {
/*  476 */     if (setClockInDateTime_noev(argClockInDateTime) && 
/*  477 */       this._events != null && 
/*  478 */       postEventsForChanges()) {
/*  479 */       this._events.post(ITimecardEntry.SET_CLOCKINDATETIME, argClockInDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClockInDateTime_noev(Date argClockInDateTime) {
/*  486 */     boolean ev_postable = false;
/*      */     
/*  488 */     if ((getDAO_().getClockInDateTime() == null && argClockInDateTime != null) || (
/*  489 */       getDAO_().getClockInDateTime() != null && !getDAO_().getClockInDateTime().equals(argClockInDateTime))) {
/*  490 */       getDAO_().setClockInDateTime(argClockInDateTime);
/*  491 */       ev_postable = true;
/*      */     } 
/*      */     
/*  494 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getClockOutDateTime() {
/*  502 */     return getDAO_().getClockOutDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClockOutDateTime(Date argClockOutDateTime) {
/*  510 */     if (setClockOutDateTime_noev(argClockOutDateTime) && 
/*  511 */       this._events != null && 
/*  512 */       postEventsForChanges()) {
/*  513 */       this._events.post(ITimecardEntry.SET_CLOCKOUTDATETIME, argClockOutDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClockOutDateTime_noev(Date argClockOutDateTime) {
/*  520 */     boolean ev_postable = false;
/*      */     
/*  522 */     if ((getDAO_().getClockOutDateTime() == null && argClockOutDateTime != null) || (
/*  523 */       getDAO_().getClockOutDateTime() != null && !getDAO_().getClockOutDateTime().equals(argClockOutDateTime))) {
/*  524 */       getDAO_().setClockOutDateTime(argClockOutDateTime);
/*  525 */       ev_postable = true;
/*      */     } 
/*      */     
/*  528 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEntryType() {
/*  536 */     return getDAO_().getEntryType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEntryType(String argEntryType) {
/*  544 */     if (setEntryType_noev(argEntryType) && 
/*  545 */       this._events != null && 
/*  546 */       postEventsForChanges()) {
/*  547 */       this._events.post(ITimecardEntry.SET_ENTRYTYPE, argEntryType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEntryType_noev(String argEntryType) {
/*  554 */     boolean ev_postable = false;
/*      */     
/*  556 */     if ((getDAO_().getEntryType() == null && argEntryType != null) || (
/*  557 */       getDAO_().getEntryType() != null && !getDAO_().getEntryType().equals(argEntryType))) {
/*  558 */       getDAO_().setEntryType(argEntryType);
/*  559 */       ev_postable = true;
/*      */     } 
/*      */     
/*  562 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDelete() {
/*  570 */     if (getDAO_().getDelete() != null) {
/*  571 */       return getDAO_().getDelete().booleanValue();
/*      */     }
/*      */     
/*  574 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDelete(boolean argDelete) {
/*  583 */     if (setDelete_noev(argDelete) && 
/*  584 */       this._events != null && 
/*  585 */       postEventsForChanges()) {
/*  586 */       this._events.post(ITimecardEntry.SET_DELETE, Boolean.valueOf(argDelete));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDelete_noev(boolean argDelete) {
/*  593 */     boolean ev_postable = false;
/*      */     
/*  595 */     if ((getDAO_().getDelete() == null && Boolean.valueOf(argDelete) != null) || (
/*  596 */       getDAO_().getDelete() != null && !getDAO_().getDelete().equals(Boolean.valueOf(argDelete)))) {
/*  597 */       getDAO_().setDelete(Boolean.valueOf(argDelete));
/*  598 */       ev_postable = true;
/*      */     } 
/*      */     
/*  601 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getOpenRecord() {
/*  609 */     if (getDAO_().getOpenRecord() != null) {
/*  610 */       return getDAO_().getOpenRecord().booleanValue();
/*      */     }
/*      */     
/*  613 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOpenRecord(boolean argOpenRecord) {
/*  622 */     if (setOpenRecord_noev(argOpenRecord) && 
/*  623 */       this._events != null && 
/*  624 */       postEventsForChanges()) {
/*  625 */       this._events.post(ITimecardEntry.SET_OPENRECORD, Boolean.valueOf(argOpenRecord));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOpenRecord_noev(boolean argOpenRecord) {
/*  632 */     boolean ev_postable = false;
/*      */     
/*  634 */     if ((getDAO_().getOpenRecord() == null && Boolean.valueOf(argOpenRecord) != null) || (
/*  635 */       getDAO_().getOpenRecord() != null && !getDAO_().getOpenRecord().equals(Boolean.valueOf(argOpenRecord)))) {
/*  636 */       getDAO_().setOpenRecord(Boolean.valueOf(argOpenRecord));
/*  637 */       ev_postable = true;
/*      */     } 
/*      */     
/*  640 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getDuration() {
/*  648 */     if (getDAO_().getDuration() != null) {
/*  649 */       return getDAO_().getDuration().longValue();
/*      */     }
/*      */     
/*  652 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDuration(long argDuration) {
/*  661 */     if (setDuration_noev(argDuration) && 
/*  662 */       this._events != null && 
/*  663 */       postEventsForChanges()) {
/*  664 */       this._events.post(ITimecardEntry.SET_DURATION, Long.valueOf(argDuration));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDuration_noev(long argDuration) {
/*  671 */     boolean ev_postable = false;
/*      */     
/*  673 */     if ((getDAO_().getDuration() == null && Long.valueOf(argDuration) != null) || (
/*  674 */       getDAO_().getDuration() != null && !getDAO_().getDuration().equals(Long.valueOf(argDuration)))) {
/*  675 */       getDAO_().setDuration(Long.valueOf(argDuration));
/*  676 */       ev_postable = true;
/*      */     } 
/*      */     
/*  679 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPayrollUpdateRequired() {
/*  687 */     if (getDAO_().getPayrollUpdateRequired() != null) {
/*  688 */       return getDAO_().getPayrollUpdateRequired().booleanValue();
/*      */     }
/*      */     
/*  691 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPayrollUpdateRequired(boolean argPayrollUpdateRequired) {
/*  700 */     if (setPayrollUpdateRequired_noev(argPayrollUpdateRequired) && 
/*  701 */       this._events != null && 
/*  702 */       postEventsForChanges()) {
/*  703 */       this._events.post(ITimecardEntry.SET_PAYROLLUPDATEREQUIRED, Boolean.valueOf(argPayrollUpdateRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPayrollUpdateRequired_noev(boolean argPayrollUpdateRequired) {
/*  710 */     boolean ev_postable = false;
/*      */     
/*  712 */     if ((getDAO_().getPayrollUpdateRequired() == null && Boolean.valueOf(argPayrollUpdateRequired) != null) || (
/*  713 */       getDAO_().getPayrollUpdateRequired() != null && !getDAO_().getPayrollUpdateRequired().equals(Boolean.valueOf(argPayrollUpdateRequired)))) {
/*  714 */       getDAO_().setPayrollUpdateRequired(Boolean.valueOf(argPayrollUpdateRequired));
/*  715 */       ev_postable = true;
/*      */     } 
/*      */     
/*  718 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWorkCodeString() {
/*  726 */     return getDAO_().getWorkCodeString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkCodeString(String argWorkCodeString) {
/*  734 */     if (setWorkCodeString_noev(argWorkCodeString) && 
/*  735 */       this._events != null && 
/*  736 */       postEventsForChanges()) {
/*  737 */       this._events.post(ITimecardEntry.SET_WORKCODESTRING, argWorkCodeString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkCodeString_noev(String argWorkCodeString) {
/*  744 */     boolean ev_postable = false;
/*      */     
/*  746 */     if ((getDAO_().getWorkCodeString() == null && argWorkCodeString != null) || (
/*  747 */       getDAO_().getWorkCodeString() != null && !getDAO_().getWorkCodeString().equals(argWorkCodeString))) {
/*  748 */       getDAO_().setWorkCodeString(argWorkCodeString);
/*  749 */       ev_postable = true;
/*      */     } 
/*      */     
/*  752 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITimecardEntryProperty newProperty(String argPropertyName) {
/*  756 */     TimecardEntryPropertyId id = new TimecardEntryPropertyId();
/*      */     
/*  758 */     id.setBusinessDate(getBusinessDate());
/*  759 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  760 */     id.setPartyId(Long.valueOf(getPartyId()));
/*  761 */     id.setTimecardEntryId(Long.valueOf(getTimecardEntryId()));
/*  762 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  763 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  765 */     ITimecardEntryProperty prop = (ITimecardEntryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITimecardEntryProperty.class);
/*  766 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "WorkCode")
/*      */   public IWorkCodes getWorkCode() {
/*  778 */     return this._workCode;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWorkCode(IWorkCodes argWorkCode) {
/*  783 */     if (argWorkCode == null) {
/*      */       
/*  785 */       getDAO_().setWorkCodeString(null);
/*  786 */       if (this._workCode != null)
/*      */       {
/*  788 */         if (postEventsForChanges()) {
/*  789 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._workCode));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  794 */       getDAO_().setWorkCodeString(argWorkCode.getWorkCode());
/*      */       
/*  796 */       if (postEventsForChanges()) {
/*  797 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWorkCode));
/*      */       }
/*      */     } 
/*      */     
/*  801 */     this._workCode = argWorkCode;
/*  802 */     if (postEventsForChanges()) {
/*  803 */       this._events.post(ITimecardEntry.SET_WORKCODE, argWorkCode);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITimecardEntryProperty> getProperties() {
/*  809 */     if (this._properties == null) {
/*  810 */       this._properties = new HistoricalList(null);
/*      */     }
/*  812 */     return (List<ITimecardEntryProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITimecardEntryProperty> argProperties) {
/*  816 */     if (this._properties == null) {
/*  817 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  819 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  822 */     for (ITimecardEntryProperty child : this._properties) {
/*  823 */       TimecardEntryPropertyModel model = (TimecardEntryPropertyModel)child;
/*  824 */       model.setOrganizationId_noev(getOrganizationId());
/*  825 */       model.setBusinessDate_noev(getBusinessDate());
/*  826 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  827 */       model.setPartyId_noev(getPartyId());
/*  828 */       model.setTimecardEntryId_noev(getTimecardEntryId());
/*  829 */       model.setWorkstationId_noev(getWorkstationId());
/*  830 */       if (child instanceof IDataModelImpl) {
/*  831 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  832 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  833 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  834 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  837 */       if (postEventsForChanges()) {
/*  838 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTimecardEntryProperty(ITimecardEntryProperty argTimecardEntryProperty) {
/*  844 */     if (this._properties == null) {
/*  845 */       this._properties = new HistoricalList(null);
/*      */     }
/*  847 */     argTimecardEntryProperty.setOrganizationId(getOrganizationId());
/*  848 */     argTimecardEntryProperty.setBusinessDate(getBusinessDate());
/*  849 */     argTimecardEntryProperty.setRetailLocationId(getRetailLocationId());
/*  850 */     argTimecardEntryProperty.setPartyId(getPartyId());
/*  851 */     argTimecardEntryProperty.setTimecardEntryId(getTimecardEntryId());
/*  852 */     argTimecardEntryProperty.setWorkstationId(getWorkstationId());
/*  853 */     if (argTimecardEntryProperty instanceof IDataModelImpl) {
/*  854 */       IDataAccessObject childDao = ((IDataModelImpl)argTimecardEntryProperty).getDAO();
/*  855 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  856 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  857 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  862 */     if (postEventsForChanges()) {
/*  863 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTimecardEntryProperty));
/*      */     }
/*      */     
/*  866 */     this._properties.add(argTimecardEntryProperty);
/*  867 */     if (postEventsForChanges()) {
/*  868 */       this._events.post(ITimecardEntry.ADD_PROPERTIES, argTimecardEntryProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTimecardEntryProperty(ITimecardEntryProperty argTimecardEntryProperty) {
/*  873 */     if (this._properties != null) {
/*      */       
/*  875 */       if (postEventsForChanges()) {
/*  876 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTimecardEntryProperty));
/*      */       }
/*  878 */       this._properties.remove(argTimecardEntryProperty);
/*  879 */       if (postEventsForChanges()) {
/*  880 */         this._events.post(ITimecardEntry.REMOVE_PROPERTIES, argTimecardEntryProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  887 */     if ("WorkCode".equals(argFieldId)) {
/*  888 */       return getWorkCode();
/*      */     }
/*  890 */     if ("Properties".equals(argFieldId)) {
/*  891 */       return getProperties();
/*      */     }
/*  893 */     if ("TimecardEntryExtension".equals(argFieldId)) {
/*  894 */       return this._myExtension;
/*      */     }
/*      */     
/*  897 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  903 */     if ("WorkCode".equals(argFieldId)) {
/*  904 */       setWorkCode((IWorkCodes)argValue);
/*      */     }
/*  906 */     else if ("Properties".equals(argFieldId)) {
/*  907 */       setProperties(changeToList(argValue, ITimecardEntryProperty.class));
/*      */     }
/*  909 */     else if ("TimecardEntryExtension".equals(argFieldId)) {
/*  910 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  913 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  919 */     this._persistenceDefaults = argPD;
/*  920 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  921 */     this._eventManager = argEM;
/*  922 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  923 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  924 */     if (this._workCode != null) {
/*  925 */       ((IDataModelImpl)this._workCode).setDependencies(argPD, argEM);
/*      */     }
/*  927 */     if (this._properties != null) {
/*  928 */       for (ITimecardEntryProperty relationship : this._properties) {
/*  929 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTimecardEntryExt() {
/*  935 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTimecardEntryExt(IDataModel argExt) {
/*  939 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  944 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  948 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  951 */     super.startTransaction();
/*      */     
/*  953 */     this._workCodeSavepoint = this._workCode;
/*  954 */     if (this._workCode != null) {
/*  955 */       this._workCode.startTransaction();
/*      */     }
/*      */     
/*  958 */     this._propertiesSavepoint = this._properties;
/*  959 */     if (this._properties != null) {
/*  960 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  961 */       Iterator<IDataModel> it = this._properties.iterator();
/*  962 */       while (it.hasNext()) {
/*  963 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  968 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  973 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  976 */     super.rollbackChanges();
/*      */     
/*  978 */     this._workCode = this._workCodeSavepoint;
/*  979 */     this._workCodeSavepoint = null;
/*  980 */     if (this._workCode != null) {
/*  981 */       this._workCode.rollbackChanges();
/*      */     }
/*      */     
/*  984 */     this._properties = this._propertiesSavepoint;
/*  985 */     this._propertiesSavepoint = null;
/*  986 */     if (this._properties != null) {
/*  987 */       Iterator<IDataModel> it = this._properties.iterator();
/*  988 */       while (it.hasNext()) {
/*  989 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  997 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1000 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1003 */     super.commitTransaction();
/*      */     
/* 1005 */     this._workCodeSavepoint = this._workCode;
/* 1006 */     if (this._workCode != null) {
/* 1007 */       this._workCode.commitTransaction();
/*      */     }
/*      */     
/* 1010 */     this._propertiesSavepoint = this._properties;
/* 1011 */     if (this._properties != null) {
/* 1012 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1013 */       while (it.hasNext()) {
/* 1014 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1016 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1020 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1025 */     argStream.defaultReadObject();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getUpdateFlag() {
/* 1043 */     return this._updateFlag;
/*      */   }
/*      */   public void setUpdateFlag(boolean updFlag) {
/* 1046 */     this._updateFlag = updFlag;
/*      */   }
/*      */   public String getEditedByTimecardMainIndicator() {
/* 1049 */     if (getEntryType() != null && (
/* 1050 */       getEntryType().equalsIgnoreCase("TIMECARD") || 
/* 1051 */       getEntryType().equalsIgnoreCase("AUTO"))) {
/* 1052 */       return "*";
/*      */     }
/* 1054 */     return "";
/*      */   }
/*      */   
/*      */   public void setTimecardDate(Date date) {
/* 1058 */     this.timecardDate = date;
/*      */   }
/*      */   public Date getTimecardDate() {
/* 1061 */     return this.timecardDate;
/*      */   }
/*      */   
/*      */   public IFormattable getDeleteFormattable() {
/* 1065 */     if (getDelete()) {
/* 1066 */       return FormattableFactory.getInstance()
/* 1067 */         .getTranslatable("_voidEntry");
/*      */     }
/*      */     
/* 1070 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getDeleteText() {
/* 1075 */     if (getDelete()) {
/* 1076 */       return getDeleteFormattable().toString(OutputContextType.VIEW);
/*      */     }
/* 1078 */     return null;
/*      */   }
/*      */   
/*      */   public boolean getPostedFlag() {
/* 1082 */     return this._postedFlag;
/*      */   }
/*      */   
/*      */   public void setPostedFlag(boolean argPostedFlag) {
/* 1086 */     this._postedFlag = argPostedFlag;
/*      */   }
/*      */   
/*      */   public String getEmployeeId() {
/* 1090 */     return this._employeeId;
/*      */   }
/*      */   
/*      */   public void setEmployeeId(String argId) {
/* 1094 */     this._employeeId = argId;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */