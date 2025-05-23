/*      */ package dtv.xst.dao.tsn.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.i18n.IFormatter;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.tsn.ISession;
/*      */ import dtv.xst.dao.tsn.ISessionProperty;
/*      */ import dtv.xst.dao.tsn.ISessionTender;
/*      */ import dtv.xst.dao.tsn.ISessionWorkstation;
/*      */ import dtv.xst.dao.tsn.ITenderRepository;
/*      */ import dtv.xst.dao.tsn.SessionPropertyId;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class SessionModel extends AbstractDataModelWithPropertyImpl<ISessionProperty> implements ISession {
/*      */   private static final long serialVersionUID = -645326218L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IParty _party;
/*      */   private transient IParty _partySavepoint;
/*      */   private ITenderRepository _tenderRepository;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient ITenderRepository _tenderRepositorySavepoint; private HistoricalList<ISessionTender> _sessionTenders; private transient HistoricalList<ISessionTender> _sessionTendersSavepoint; private HistoricalList<ISessionWorkstation> _sessionWorkstations; private transient HistoricalList<ISessionWorkstation> _sessionWorkstationsSavepoint; private HistoricalList<ISessionProperty> _properties; private transient HistoricalList<ISessionProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new SessionDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SessionDAO getDAO_() {
/*   48 */     return (SessionDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   56 */     if (getDAO_().getOrganizationId() != null) {
/*   57 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   60 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   70 */       this._events != null && 
/*   71 */       postEventsForChanges()) {
/*   72 */       this._events.post(ISession.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   79 */     boolean ev_postable = false;
/*      */     
/*   81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   84 */       ev_postable = true;
/*   85 */       if (this._sessionTenders != null) {
/*      */         
/*   87 */         Iterator<SessionTenderModel> it = this._sessionTenders.iterator();
/*   88 */         while (it.hasNext())
/*      */         {
/*   90 */           ((SessionTenderModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   93 */       if (this._sessionWorkstations != null) {
/*      */         
/*   95 */         Iterator<SessionWorkstationModel> it = this._sessionWorkstations.iterator();
/*   96 */         while (it.hasNext())
/*      */         {
/*   98 */           ((SessionWorkstationModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  101 */       if (this._properties != null) {
/*      */         
/*  103 */         Iterator<SessionPropertyModel> it = this._properties.iterator();
/*  104 */         while (it.hasNext())
/*      */         {
/*  106 */           ((SessionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  111 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  119 */     if (getDAO_().getRetailLocationId() != null) {
/*  120 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  123 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  132 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  133 */       this._events != null && 
/*  134 */       postEventsForChanges()) {
/*  135 */       this._events.post(ISession.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  142 */     boolean ev_postable = false;
/*      */     
/*  144 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  145 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  146 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  147 */       ev_postable = true;
/*  148 */       if (this._sessionTenders != null) {
/*      */         
/*  150 */         Iterator<SessionTenderModel> it = this._sessionTenders.iterator();
/*  151 */         while (it.hasNext())
/*      */         {
/*  153 */           ((SessionTenderModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  156 */       if (this._sessionWorkstations != null) {
/*      */         
/*  158 */         Iterator<SessionWorkstationModel> it = this._sessionWorkstations.iterator();
/*  159 */         while (it.hasNext())
/*      */         {
/*  161 */           ((SessionWorkstationModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  164 */       if (this._properties != null) {
/*      */         
/*  166 */         Iterator<SessionPropertyModel> it = this._properties.iterator();
/*  167 */         while (it.hasNext())
/*      */         {
/*  169 */           ((SessionPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  174 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getSessionId() {
/*  182 */     if (getDAO_().getSessionId() != null) {
/*  183 */       return getDAO_().getSessionId().longValue();
/*      */     }
/*      */     
/*  186 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSessionId(long argSessionId) {
/*  195 */     if (setSessionId_noev(argSessionId) && 
/*  196 */       this._events != null && 
/*  197 */       postEventsForChanges()) {
/*  198 */       this._events.post(ISession.SET_SESSIONID, Long.valueOf(argSessionId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSessionId_noev(long argSessionId) {
/*  205 */     boolean ev_postable = false;
/*      */     
/*  207 */     if ((getDAO_().getSessionId() == null && Long.valueOf(argSessionId) != null) || (
/*  208 */       getDAO_().getSessionId() != null && !getDAO_().getSessionId().equals(Long.valueOf(argSessionId)))) {
/*  209 */       getDAO_().setSessionId(Long.valueOf(argSessionId));
/*  210 */       ev_postable = true;
/*  211 */       if (this._sessionTenders != null) {
/*      */         
/*  213 */         Iterator<SessionTenderModel> it = this._sessionTenders.iterator();
/*  214 */         while (it.hasNext())
/*      */         {
/*  216 */           ((SessionTenderModel)it.next()).setSessionId_noev(argSessionId);
/*      */         }
/*      */       } 
/*  219 */       if (this._sessionWorkstations != null) {
/*      */         
/*  221 */         Iterator<SessionWorkstationModel> it = this._sessionWorkstations.iterator();
/*  222 */         while (it.hasNext())
/*      */         {
/*  224 */           ((SessionWorkstationModel)it.next()).setSessionId_noev(argSessionId);
/*      */         }
/*      */       } 
/*  227 */       if (this._properties != null) {
/*      */         
/*  229 */         Iterator<SessionPropertyModel> it = this._properties.iterator();
/*  230 */         while (it.hasNext())
/*      */         {
/*  232 */           ((SessionPropertyModel)it.next()).setSessionId_noev(argSessionId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  237 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  245 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  253 */     if (setCreateDate_noev(argCreateDate) && 
/*  254 */       this._events != null && 
/*  255 */       postEventsForChanges()) {
/*  256 */       this._events.post(ISession.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  263 */     boolean ev_postable = false;
/*      */     
/*  265 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  266 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  267 */       getDAO_().setCreateDate(argCreateDate);
/*  268 */       ev_postable = true;
/*      */     } 
/*      */     
/*  271 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  279 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  287 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  288 */       this._events != null && 
/*  289 */       postEventsForChanges()) {
/*  290 */       this._events.post(ISession.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  297 */     boolean ev_postable = false;
/*      */     
/*  299 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  300 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  301 */       getDAO_().setCreateUserId(argCreateUserId);
/*  302 */       ev_postable = true;
/*      */     } 
/*      */     
/*  305 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  313 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  321 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  322 */       this._events != null && 
/*  323 */       postEventsForChanges()) {
/*  324 */       this._events.post(ISession.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  331 */     boolean ev_postable = false;
/*      */     
/*  333 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  334 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  335 */       getDAO_().setUpdateDate(argUpdateDate);
/*  336 */       ev_postable = true;
/*      */     } 
/*      */     
/*  339 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  347 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  355 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  356 */       this._events != null && 
/*  357 */       postEventsForChanges()) {
/*  358 */       this._events.post(ISession.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  365 */     boolean ev_postable = false;
/*      */     
/*  367 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  368 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  369 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  370 */       ev_postable = true;
/*      */     } 
/*      */     
/*  373 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBeginDatetimestamp() {
/*  381 */     return getDAO_().getBeginDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeginDatetimestamp(Date argBeginDatetimestamp) {
/*  389 */     if (setBeginDatetimestamp_noev(argBeginDatetimestamp) && 
/*  390 */       this._events != null && 
/*  391 */       postEventsForChanges()) {
/*  392 */       this._events.post(ISession.SET_BEGINDATETIMESTAMP, argBeginDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeginDatetimestamp_noev(Date argBeginDatetimestamp) {
/*  399 */     boolean ev_postable = false;
/*      */     
/*  401 */     if ((getDAO_().getBeginDatetimestamp() == null && argBeginDatetimestamp != null) || (
/*  402 */       getDAO_().getBeginDatetimestamp() != null && !getDAO_().getBeginDatetimestamp().equals(argBeginDatetimestamp))) {
/*  403 */       getDAO_().setBeginDatetimestamp(argBeginDatetimestamp);
/*  404 */       ev_postable = true;
/*      */     } 
/*      */     
/*  407 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  415 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  423 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  424 */       this._events != null && 
/*  425 */       postEventsForChanges()) {
/*  426 */       this._events.post(ISession.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  433 */     boolean ev_postable = false;
/*      */     
/*  435 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  436 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  437 */       getDAO_().setBusinessDate(argBusinessDate);
/*  438 */       ev_postable = true;
/*      */     } 
/*      */     
/*  441 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndDatetimestamp() {
/*  449 */     return getDAO_().getEndDatetimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDatetimestamp(Date argEndDatetimestamp) {
/*  457 */     if (setEndDatetimestamp_noev(argEndDatetimestamp) && 
/*  458 */       this._events != null && 
/*  459 */       postEventsForChanges()) {
/*  460 */       this._events.post(ISession.SET_ENDDATETIMESTAMP, argEndDatetimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDatetimestamp_noev(Date argEndDatetimestamp) {
/*  467 */     boolean ev_postable = false;
/*      */     
/*  469 */     if ((getDAO_().getEndDatetimestamp() == null && argEndDatetimestamp != null) || (
/*  470 */       getDAO_().getEndDatetimestamp() != null && !getDAO_().getEndDatetimestamp().equals(argEndDatetimestamp))) {
/*  471 */       getDAO_().setEndDatetimestamp(argEndDatetimestamp);
/*  472 */       ev_postable = true;
/*      */     } 
/*      */     
/*  475 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  483 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  491 */     if (setStatusCode_noev(argStatusCode) && 
/*  492 */       this._events != null && 
/*  493 */       postEventsForChanges()) {
/*  494 */       this._events.post(ISession.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  501 */     boolean ev_postable = false;
/*      */     
/*  503 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  504 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  505 */       getDAO_().setStatusCode(argStatusCode);
/*  506 */       ev_postable = true;
/*      */     } 
/*      */     
/*  509 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getEmployeePartyId() {
/*  517 */     if (getDAO_().getEmployeePartyId() != null) {
/*  518 */       return getDAO_().getEmployeePartyId().longValue();
/*      */     }
/*      */     
/*  521 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeePartyId(long argEmployeePartyId) {
/*  530 */     if (setEmployeePartyId_noev(argEmployeePartyId) && 
/*  531 */       this._events != null && 
/*  532 */       postEventsForChanges()) {
/*  533 */       this._events.post(ISession.SET_EMPLOYEEPARTYID, Long.valueOf(argEmployeePartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeePartyId_noev(long argEmployeePartyId) {
/*  540 */     boolean ev_postable = false;
/*      */     
/*  542 */     if ((getDAO_().getEmployeePartyId() == null && Long.valueOf(argEmployeePartyId) != null) || (
/*  543 */       getDAO_().getEmployeePartyId() != null && !getDAO_().getEmployeePartyId().equals(Long.valueOf(argEmployeePartyId)))) {
/*  544 */       getDAO_().setEmployeePartyId(Long.valueOf(argEmployeePartyId));
/*  545 */       ev_postable = true;
/*      */     } 
/*      */     
/*  548 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderRepositoryId() {
/*  556 */     return getDAO_().getTenderRepositoryId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/*  564 */     if (setTenderRepositoryId_noev(argTenderRepositoryId) && 
/*  565 */       this._events != null && 
/*  566 */       postEventsForChanges()) {
/*  567 */       this._events.post(ISession.SET_TENDERREPOSITORYID, argTenderRepositoryId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderRepositoryId_noev(String argTenderRepositoryId) {
/*  574 */     boolean ev_postable = false;
/*      */     
/*  576 */     if ((getDAO_().getTenderRepositoryId() == null && argTenderRepositoryId != null) || (
/*  577 */       getDAO_().getTenderRepositoryId() != null && !getDAO_().getTenderRepositoryId().equals(argTenderRepositoryId))) {
/*  578 */       getDAO_().setTenderRepositoryId(argTenderRepositoryId);
/*  579 */       ev_postable = true;
/*      */     } 
/*      */     
/*  582 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCashDrawerId() {
/*  590 */     return getDAO_().getCashDrawerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCashDrawerId(String argCashDrawerId) {
/*  598 */     if (setCashDrawerId_noev(argCashDrawerId) && 
/*  599 */       this._events != null && 
/*  600 */       postEventsForChanges()) {
/*  601 */       this._events.post(ISession.SET_CASHDRAWERID, argCashDrawerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCashDrawerId_noev(String argCashDrawerId) {
/*  608 */     boolean ev_postable = false;
/*      */     
/*  610 */     if ((getDAO_().getCashDrawerId() == null && argCashDrawerId != null) || (
/*  611 */       getDAO_().getCashDrawerId() != null && !getDAO_().getCashDrawerId().equals(argCashDrawerId))) {
/*  612 */       getDAO_().setCashDrawerId(argCashDrawerId);
/*  613 */       ev_postable = true;
/*      */     } 
/*      */     
/*  616 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ISessionProperty newProperty(String argPropertyName) {
/*  620 */     SessionPropertyId id = new SessionPropertyId();
/*      */     
/*  622 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  623 */     id.setSessionId(Long.valueOf(getSessionId()));
/*  624 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  626 */     ISessionProperty prop = (ISessionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISessionProperty.class);
/*  627 */     return prop;
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
/*      */ 
/*      */   
/*      */   @Relationship(name = "Party")
/*      */   public IParty getParty() {
/*  648 */     return this._party;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setParty(IParty argParty) {
/*  653 */     if (argParty == null) {
/*      */       
/*  655 */       getDAO_().setEmployeePartyId(null);
/*  656 */       if (this._party != null)
/*      */       {
/*  658 */         if (postEventsForChanges()) {
/*  659 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._party));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  664 */       getDAO_().setEmployeePartyId(Long.valueOf(argParty.getPartyId()));
/*      */       
/*  666 */       if (postEventsForChanges()) {
/*  667 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argParty));
/*      */       }
/*      */     } 
/*      */     
/*  671 */     this._party = argParty;
/*  672 */     if (postEventsForChanges()) {
/*  673 */       this._events.post(ISession.SET_PARTY, argParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "TenderRepository")
/*      */   public ITenderRepository getTenderRepository() {
/*  679 */     return this._tenderRepository;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTenderRepository(ITenderRepository argTenderRepository) {
/*  684 */     if (argTenderRepository == null) {
/*      */       
/*  686 */       getDAO_().setTenderRepositoryId(null);
/*  687 */       if (this._tenderRepository != null)
/*      */       {
/*  689 */         if (postEventsForChanges()) {
/*  690 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._tenderRepository));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  695 */       getDAO_().setTenderRepositoryId(argTenderRepository.getTenderRepositoryId());
/*      */       
/*  697 */       if (postEventsForChanges()) {
/*  698 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderRepository));
/*      */       }
/*      */     } 
/*      */     
/*  702 */     this._tenderRepository = argTenderRepository;
/*  703 */     if (postEventsForChanges()) {
/*  704 */       this._events.post(ISession.SET_TENDERREPOSITORY, argTenderRepository);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "SessionTenders")
/*      */   public List<ISessionTender> getSessionTenders() {
/*  710 */     if (this._sessionTenders == null) {
/*  711 */       this._sessionTenders = new HistoricalList(null);
/*      */     }
/*  713 */     return (List<ISessionTender>)this._sessionTenders;
/*      */   }
/*      */   
/*      */   public void setSessionTenders(List<ISessionTender> argSessionTenders) {
/*  717 */     if (this._sessionTenders == null) {
/*  718 */       this._sessionTenders = new HistoricalList(argSessionTenders);
/*      */     } else {
/*  720 */       this._sessionTenders.setCurrentList(argSessionTenders);
/*      */     } 
/*      */     
/*  723 */     for (ISessionTender child : this._sessionTenders) {
/*  724 */       child.setParentSession(this);
/*      */     }
/*      */     
/*  727 */     for (ISessionTender child : this._sessionTenders) {
/*  728 */       SessionTenderModel model = (SessionTenderModel)child;
/*  729 */       model.setOrganizationId_noev(getOrganizationId());
/*  730 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  731 */       model.setSessionId_noev(getSessionId());
/*  732 */       if (child instanceof IDataModelImpl) {
/*  733 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  734 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  735 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  736 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  739 */       if (postEventsForChanges()) {
/*  740 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addSessionTender(ISessionTender argSessionTender) {
/*  747 */     argSessionTender.setParentSession(this);
/*  748 */     if (this._sessionTenders == null) {
/*  749 */       this._sessionTenders = new HistoricalList(null);
/*      */     }
/*  751 */     argSessionTender.setOrganizationId(getOrganizationId());
/*  752 */     argSessionTender.setRetailLocationId(getRetailLocationId());
/*  753 */     argSessionTender.setSessionId(getSessionId());
/*  754 */     if (argSessionTender instanceof IDataModelImpl) {
/*  755 */       IDataAccessObject childDao = ((IDataModelImpl)argSessionTender).getDAO();
/*  756 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  757 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  758 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  763 */     if (postEventsForChanges()) {
/*  764 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionTender));
/*      */     }
/*      */     
/*  767 */     this._sessionTenders.add(argSessionTender);
/*  768 */     if (postEventsForChanges()) {
/*  769 */       this._events.post(ISession.ADD_SESSIONTENDERS, argSessionTender);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeSessionTender(ISessionTender argSessionTender) {
/*  774 */     if (this._sessionTenders != null) {
/*      */       
/*  776 */       if (postEventsForChanges()) {
/*  777 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionTender));
/*      */       }
/*  779 */       this._sessionTenders.remove(argSessionTender);
/*      */       
/*  781 */       argSessionTender.setParentSession(null);
/*  782 */       if (postEventsForChanges()) {
/*  783 */         this._events.post(ISession.REMOVE_SESSIONTENDERS, argSessionTender);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "SessionWorkstations")
/*      */   public List<ISessionWorkstation> getSessionWorkstations() {
/*  790 */     if (this._sessionWorkstations == null) {
/*  791 */       this._sessionWorkstations = new HistoricalList(null);
/*      */     }
/*  793 */     return (List<ISessionWorkstation>)this._sessionWorkstations;
/*      */   }
/*      */   
/*      */   public void setSessionWorkstations(List<ISessionWorkstation> argSessionWorkstations) {
/*  797 */     if (this._sessionWorkstations == null) {
/*  798 */       this._sessionWorkstations = new HistoricalList(argSessionWorkstations);
/*      */     } else {
/*  800 */       this._sessionWorkstations.setCurrentList(argSessionWorkstations);
/*      */     } 
/*      */     
/*  803 */     for (ISessionWorkstation child : this._sessionWorkstations) {
/*  804 */       child.setParentSession(this);
/*      */     }
/*      */     
/*  807 */     for (ISessionWorkstation child : this._sessionWorkstations) {
/*  808 */       SessionWorkstationModel model = (SessionWorkstationModel)child;
/*  809 */       model.setOrganizationId_noev(getOrganizationId());
/*  810 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  811 */       model.setSessionId_noev(getSessionId());
/*  812 */       if (child instanceof IDataModelImpl) {
/*  813 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  814 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  815 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  816 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  819 */       if (postEventsForChanges()) {
/*  820 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addSessionWorkstationImpl(ISessionWorkstation argSessionWorkstation) {
/*  827 */     argSessionWorkstation.setParentSession(this);
/*  828 */     if (this._sessionWorkstations == null) {
/*  829 */       this._sessionWorkstations = new HistoricalList(null);
/*      */     }
/*  831 */     argSessionWorkstation.setOrganizationId(getOrganizationId());
/*  832 */     argSessionWorkstation.setRetailLocationId(getRetailLocationId());
/*  833 */     argSessionWorkstation.setSessionId(getSessionId());
/*  834 */     if (argSessionWorkstation instanceof IDataModelImpl) {
/*  835 */       IDataAccessObject childDao = ((IDataModelImpl)argSessionWorkstation).getDAO();
/*  836 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  837 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  838 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  843 */     if (postEventsForChanges()) {
/*  844 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionWorkstation));
/*      */     }
/*      */     
/*  847 */     this._sessionWorkstations.add(argSessionWorkstation);
/*  848 */     if (postEventsForChanges()) {
/*  849 */       this._events.post(ISession.ADD_SESSIONWORKSTATIONS, argSessionWorkstation);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeSessionWorkstation(ISessionWorkstation argSessionWorkstation) {
/*  854 */     if (this._sessionWorkstations != null) {
/*      */       
/*  856 */       if (postEventsForChanges()) {
/*  857 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionWorkstation));
/*      */       }
/*  859 */       this._sessionWorkstations.remove(argSessionWorkstation);
/*      */       
/*  861 */       argSessionWorkstation.setParentSession(null);
/*  862 */       if (postEventsForChanges()) {
/*  863 */         this._events.post(ISession.REMOVE_SESSIONWORKSTATIONS, argSessionWorkstation);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ISessionProperty> getProperties() {
/*  870 */     if (this._properties == null) {
/*  871 */       this._properties = new HistoricalList(null);
/*      */     }
/*  873 */     return (List<ISessionProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ISessionProperty> argProperties) {
/*  877 */     if (this._properties == null) {
/*  878 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  880 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  883 */     for (ISessionProperty child : this._properties) {
/*  884 */       SessionPropertyModel model = (SessionPropertyModel)child;
/*  885 */       model.setOrganizationId_noev(getOrganizationId());
/*  886 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  887 */       model.setSessionId_noev(getSessionId());
/*  888 */       if (child instanceof IDataModelImpl) {
/*  889 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  890 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  891 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  892 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  895 */       if (postEventsForChanges()) {
/*  896 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addSessionProperty(ISessionProperty argSessionProperty) {
/*  902 */     if (this._properties == null) {
/*  903 */       this._properties = new HistoricalList(null);
/*      */     }
/*  905 */     argSessionProperty.setOrganizationId(getOrganizationId());
/*  906 */     argSessionProperty.setRetailLocationId(getRetailLocationId());
/*  907 */     argSessionProperty.setSessionId(getSessionId());
/*  908 */     if (argSessionProperty instanceof IDataModelImpl) {
/*  909 */       IDataAccessObject childDao = ((IDataModelImpl)argSessionProperty).getDAO();
/*  910 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  911 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  912 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  917 */     if (postEventsForChanges()) {
/*  918 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionProperty));
/*      */     }
/*      */     
/*  921 */     this._properties.add(argSessionProperty);
/*  922 */     if (postEventsForChanges()) {
/*  923 */       this._events.post(ISession.ADD_PROPERTIES, argSessionProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeSessionProperty(ISessionProperty argSessionProperty) {
/*  928 */     if (this._properties != null) {
/*      */       
/*  930 */       if (postEventsForChanges()) {
/*  931 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSessionProperty));
/*      */       }
/*  933 */       this._properties.remove(argSessionProperty);
/*  934 */       if (postEventsForChanges()) {
/*  935 */         this._events.post(ISession.REMOVE_PROPERTIES, argSessionProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  942 */     if ("Party".equals(argFieldId)) {
/*  943 */       return getParty();
/*      */     }
/*  945 */     if ("TenderRepository".equals(argFieldId)) {
/*  946 */       return getTenderRepository();
/*      */     }
/*  948 */     if ("SessionTenders".equals(argFieldId)) {
/*  949 */       return getSessionTenders();
/*      */     }
/*  951 */     if ("SessionWorkstations".equals(argFieldId)) {
/*  952 */       return getSessionWorkstations();
/*      */     }
/*  954 */     if ("Properties".equals(argFieldId)) {
/*  955 */       return getProperties();
/*      */     }
/*  957 */     if ("SessionExtension".equals(argFieldId)) {
/*  958 */       return this._myExtension;
/*      */     }
/*      */     
/*  961 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  967 */     if ("Party".equals(argFieldId)) {
/*  968 */       setParty((IParty)argValue);
/*      */     }
/*  970 */     else if ("TenderRepository".equals(argFieldId)) {
/*  971 */       setTenderRepository((ITenderRepository)argValue);
/*      */     }
/*  973 */     else if ("SessionTenders".equals(argFieldId)) {
/*  974 */       setSessionTenders(changeToList(argValue, ISessionTender.class));
/*      */     }
/*  976 */     else if ("SessionWorkstations".equals(argFieldId)) {
/*  977 */       setSessionWorkstations(changeToList(argValue, ISessionWorkstation.class));
/*      */     }
/*  979 */     else if ("Properties".equals(argFieldId)) {
/*  980 */       setProperties(changeToList(argValue, ISessionProperty.class));
/*      */     }
/*  982 */     else if ("SessionExtension".equals(argFieldId)) {
/*  983 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  986 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  992 */     this._persistenceDefaults = argPD;
/*  993 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  994 */     this._eventManager = argEM;
/*  995 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  996 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  997 */     if (this._party != null) {
/*  998 */       ((IDataModelImpl)this._party).setDependencies(argPD, argEM);
/*      */     }
/* 1000 */     if (this._tenderRepository != null) {
/* 1001 */       ((IDataModelImpl)this._tenderRepository).setDependencies(argPD, argEM);
/*      */     }
/* 1003 */     if (this._sessionTenders != null) {
/* 1004 */       for (ISessionTender relationship : this._sessionTenders) {
/* 1005 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1008 */     if (this._sessionWorkstations != null) {
/* 1009 */       for (ISessionWorkstation relationship : this._sessionWorkstations) {
/* 1010 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1013 */     if (this._properties != null) {
/* 1014 */       for (ISessionProperty relationship : this._properties) {
/* 1015 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getSessionExt() {
/* 1021 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setSessionExt(IDataModel argExt) {
/* 1025 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1030 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1034 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1037 */     super.startTransaction();
/*      */     
/* 1039 */     this._partySavepoint = this._party;
/* 1040 */     if (this._party != null) {
/* 1041 */       this._party.startTransaction();
/*      */     }
/*      */     
/* 1044 */     this._tenderRepositorySavepoint = this._tenderRepository;
/* 1045 */     if (this._tenderRepository != null) {
/* 1046 */       this._tenderRepository.startTransaction();
/*      */     }
/*      */     
/* 1049 */     this._sessionTendersSavepoint = this._sessionTenders;
/* 1050 */     if (this._sessionTenders != null) {
/* 1051 */       this._sessionTendersSavepoint = new HistoricalList((List)this._sessionTenders);
/* 1052 */       Iterator<IDataModel> it = this._sessionTenders.iterator();
/* 1053 */       while (it.hasNext()) {
/* 1054 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1058 */     this._sessionWorkstationsSavepoint = this._sessionWorkstations;
/* 1059 */     if (this._sessionWorkstations != null) {
/* 1060 */       this._sessionWorkstationsSavepoint = new HistoricalList((List)this._sessionWorkstations);
/* 1061 */       Iterator<IDataModel> it = this._sessionWorkstations.iterator();
/* 1062 */       while (it.hasNext()) {
/* 1063 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1067 */     this._propertiesSavepoint = this._properties;
/* 1068 */     if (this._properties != null) {
/* 1069 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1070 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1071 */       while (it.hasNext()) {
/* 1072 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1077 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1082 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1085 */     super.rollbackChanges();
/*      */     
/* 1087 */     this._party = this._partySavepoint;
/* 1088 */     this._partySavepoint = null;
/* 1089 */     if (this._party != null) {
/* 1090 */       this._party.rollbackChanges();
/*      */     }
/*      */     
/* 1093 */     this._tenderRepository = this._tenderRepositorySavepoint;
/* 1094 */     this._tenderRepositorySavepoint = null;
/* 1095 */     if (this._tenderRepository != null) {
/* 1096 */       this._tenderRepository.rollbackChanges();
/*      */     }
/*      */     
/* 1099 */     this._sessionTenders = this._sessionTendersSavepoint;
/* 1100 */     this._sessionTendersSavepoint = null;
/* 1101 */     if (this._sessionTenders != null) {
/* 1102 */       Iterator<IDataModel> it = this._sessionTenders.iterator();
/* 1103 */       while (it.hasNext()) {
/* 1104 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1108 */     this._sessionWorkstations = this._sessionWorkstationsSavepoint;
/* 1109 */     this._sessionWorkstationsSavepoint = null;
/* 1110 */     if (this._sessionWorkstations != null) {
/* 1111 */       Iterator<IDataModel> it = this._sessionWorkstations.iterator();
/* 1112 */       while (it.hasNext()) {
/* 1113 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1117 */     this._properties = this._propertiesSavepoint;
/* 1118 */     this._propertiesSavepoint = null;
/* 1119 */     if (this._properties != null) {
/* 1120 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1121 */       while (it.hasNext()) {
/* 1122 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1130 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1133 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1136 */     super.commitTransaction();
/*      */     
/* 1138 */     this._partySavepoint = this._party;
/* 1139 */     if (this._party != null) {
/* 1140 */       this._party.commitTransaction();
/*      */     }
/*      */     
/* 1143 */     this._tenderRepositorySavepoint = this._tenderRepository;
/* 1144 */     if (this._tenderRepository != null) {
/* 1145 */       this._tenderRepository.commitTransaction();
/*      */     }
/*      */     
/* 1148 */     this._sessionTendersSavepoint = this._sessionTenders;
/* 1149 */     if (this._sessionTenders != null) {
/* 1150 */       Iterator<IDataModel> it = this._sessionTenders.iterator();
/* 1151 */       while (it.hasNext()) {
/* 1152 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1154 */       this._sessionTenders = new HistoricalList((List)this._sessionTenders);
/*      */     } 
/*      */     
/* 1157 */     this._sessionWorkstationsSavepoint = this._sessionWorkstations;
/* 1158 */     if (this._sessionWorkstations != null) {
/* 1159 */       Iterator<IDataModel> it = this._sessionWorkstations.iterator();
/* 1160 */       while (it.hasNext()) {
/* 1161 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1163 */       this._sessionWorkstations = new HistoricalList((List)this._sessionWorkstations);
/*      */     } 
/*      */     
/* 1166 */     this._propertiesSavepoint = this._properties;
/* 1167 */     if (this._properties != null) {
/* 1168 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1169 */       while (it.hasNext()) {
/* 1170 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1172 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1176 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1181 */     argStream.defaultReadObject();
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
/*      */   public void addSessionWorkstation(ISessionWorkstation argSessionWorkstation) {
/* 1197 */     synchronized (this) {
/* 1198 */       argSessionWorkstation.setSessionWorkstationSequenceNbr(getSessionWorkstations().size() + 1);
/* 1199 */       addSessionWorkstationImpl(argSessionWorkstation);
/*      */     } 
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
/*      */   public String getSessionData() {
/* 1214 */     StringBuilder sessionData = new StringBuilder(40);
/*      */     
/* 1216 */     String id = String.valueOf(getSessionId());
/*      */     
/* 1218 */     if (id.length() >= 4) {
/* 1219 */       sessionData.append(StringUtils.right(id, 4));
/*      */     } else {
/*      */       
/* 1222 */       sessionData.append(id);
/*      */     } 
/*      */     
/* 1225 */     IFormatter dateTimeShortFormatter = FormatterFactory.getInstance().getDateTimeShortFormatter();
/* 1226 */     sessionData.append("  ");
/* 1227 */     Date beginDateTime = getBeginDatetimestamp();
/* 1228 */     sessionData.append(dateTimeShortFormatter.format(beginDateTime, OutputContextType.VIEW));
/* 1229 */     sessionData.append(" - ");
/* 1230 */     Date endDateTime = getEndDatetimestamp();
/*      */     
/* 1232 */     if (endDateTime != null) {
/* 1233 */       if (DateUtils.dateDiff(CalendarField.DAY, beginDateTime, endDateTime) == 0L) {
/*      */ 
/*      */ 
/*      */         
/* 1237 */         String[] formattedEndDate = dateTimeShortFormatter.format(endDateTime, OutputContextType.VIEW).split("\\s");
/* 1238 */         int length = formattedEndDate.length;
/* 1239 */         sessionData.append(formattedEndDate[length - 2]);
/* 1240 */         sessionData.append(" ").append(formattedEndDate[length - 1]);
/*      */       } else {
/*      */         
/* 1243 */         sessionData.append(dateTimeShortFormatter.format(endDateTime, OutputContextType.VIEW));
/*      */       } 
/*      */     }
/* 1246 */     return sessionData.toString();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */