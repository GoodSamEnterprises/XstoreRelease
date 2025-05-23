/*      */ package dtv.xst.dao.tnd.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.tnd.ITender;
/*      */ import dtv.xst.dao.tnd.ITenderAvailability;
/*      */ import dtv.xst.dao.tnd.ITenderDenomination;
/*      */ import dtv.xst.dao.tnd.ITenderOptions;
/*      */ import dtv.xst.dao.tnd.ITenderProperty;
/*      */ import dtv.xst.dao.tnd.ITenderType;
/*      */ import dtv.xst.dao.tnd.TenderPropertyId;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderModel extends AbstractDataModelWithPropertyImpl<ITenderProperty> implements ITender {
/*      */   private static final long serialVersionUID = -1793466636L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<ITenderOptions> _tenderOptions;
/*      */   private transient HistoricalList<ITenderOptions> _tenderOptionsSavepoint;
/*      */   private HistoricalList<ITenderAvailability> _tenderAvailabilityCodes;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient HistoricalList<ITenderAvailability> _tenderAvailabilityCodesSavepoint; private HistoricalList<ITenderDenomination> _tenderDenominations; private transient HistoricalList<ITenderDenomination> _tenderDenominationsSavepoint; private ITenderType _tenderType; private transient ITenderType _tenderTypeSavepoint; private HistoricalList<ITenderProperty> _properties; private transient HistoricalList<ITenderProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new TenderDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TenderDAO getDAO_() {
/*   47 */     return (TenderDAO)this._daoImpl;
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
/*   71 */       this._events.post(ITender.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   84 */       if (this._tenderOptions != null) {
/*      */         
/*   86 */         Iterator<TenderOptionsModel> it = this._tenderOptions.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((TenderOptionsModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   92 */       if (this._tenderAvailabilityCodes != null) {
/*      */         
/*   94 */         Iterator<TenderAvailabilityModel> it = this._tenderAvailabilityCodes.iterator();
/*   95 */         while (it.hasNext())
/*      */         {
/*   97 */           ((TenderAvailabilityModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  100 */       if (this._tenderDenominations != null) {
/*      */         
/*  102 */         Iterator<TenderDenominationModel> it = this._tenderDenominations.iterator();
/*  103 */         while (it.hasNext())
/*      */         {
/*  105 */           ((TenderDenominationModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  108 */       if (this._properties != null) {
/*      */         
/*  110 */         Iterator<TenderPropertyModel> it = this._properties.iterator();
/*  111 */         while (it.hasNext())
/*      */         {
/*  113 */           ((TenderPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  118 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderId() {
/*  126 */     return getDAO_().getTenderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderId(String argTenderId) {
/*  134 */     if (setTenderId_noev(argTenderId) && 
/*  135 */       this._events != null && 
/*  136 */       postEventsForChanges()) {
/*  137 */       this._events.post(ITender.SET_TENDERID, argTenderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderId_noev(String argTenderId) {
/*  144 */     boolean ev_postable = false;
/*      */     
/*  146 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/*  147 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/*  148 */       getDAO_().setTenderId(argTenderId);
/*  149 */       ev_postable = true;
/*  150 */       if (this._tenderOptions != null) {
/*      */         
/*  152 */         Iterator<TenderOptionsModel> it = this._tenderOptions.iterator();
/*  153 */         while (it.hasNext())
/*      */         {
/*  155 */           ((TenderOptionsModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*  158 */       if (this._tenderAvailabilityCodes != null) {
/*      */         
/*  160 */         Iterator<TenderAvailabilityModel> it = this._tenderAvailabilityCodes.iterator();
/*  161 */         while (it.hasNext())
/*      */         {
/*  163 */           ((TenderAvailabilityModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*  166 */       if (this._tenderDenominations != null) {
/*      */         
/*  168 */         Iterator<TenderDenominationModel> it = this._tenderDenominations.iterator();
/*  169 */         while (it.hasNext())
/*      */         {
/*  171 */           ((TenderDenominationModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*  174 */       if (this._properties != null) {
/*      */         
/*  176 */         Iterator<TenderPropertyModel> it = this._properties.iterator();
/*  177 */         while (it.hasNext())
/*      */         {
/*  179 */           ((TenderPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  184 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  192 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  200 */     if (setCreateDate_noev(argCreateDate) && 
/*  201 */       this._events != null && 
/*  202 */       postEventsForChanges()) {
/*  203 */       this._events.post(ITender.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  210 */     boolean ev_postable = false;
/*      */     
/*  212 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  213 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  214 */       getDAO_().setCreateDate(argCreateDate);
/*  215 */       ev_postable = true;
/*      */     } 
/*      */     
/*  218 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  226 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  234 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  235 */       this._events != null && 
/*  236 */       postEventsForChanges()) {
/*  237 */       this._events.post(ITender.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  244 */     boolean ev_postable = false;
/*      */     
/*  246 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  247 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  248 */       getDAO_().setCreateUserId(argCreateUserId);
/*  249 */       ev_postable = true;
/*      */     } 
/*      */     
/*  252 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  260 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  268 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  269 */       this._events != null && 
/*  270 */       postEventsForChanges()) {
/*  271 */       this._events.post(ITender.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  278 */     boolean ev_postable = false;
/*      */     
/*  280 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  281 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  282 */       getDAO_().setUpdateDate(argUpdateDate);
/*  283 */       ev_postable = true;
/*      */     } 
/*      */     
/*  286 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  294 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  302 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  303 */       this._events != null && 
/*  304 */       postEventsForChanges()) {
/*  305 */       this._events.post(ITender.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  312 */     boolean ev_postable = false;
/*      */     
/*  314 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  315 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  316 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  317 */       ev_postable = true;
/*      */     } 
/*      */     
/*  320 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getCurrencyIdImpl() {
/*  328 */     return getDAO_().getCurrencyId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCurrencyId(String argCurrencyId) {
/*  336 */     if (setCurrencyId_noev(argCurrencyId) && 
/*  337 */       this._events != null && 
/*  338 */       postEventsForChanges()) {
/*  339 */       this._events.post(ITender.SET_CURRENCYID, argCurrencyId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCurrencyId_noev(String argCurrencyId) {
/*  346 */     boolean ev_postable = false;
/*      */     
/*  348 */     if ((getDAO_().getCurrencyId() == null && argCurrencyId != null) || (
/*  349 */       getDAO_().getCurrencyId() != null && !getDAO_().getCurrencyId().equals(argCurrencyId))) {
/*  350 */       getDAO_().setCurrencyId(argCurrencyId);
/*  351 */       ev_postable = true;
/*      */     } 
/*      */     
/*  354 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  362 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  370 */     if (setDescription_noev(argDescription) && 
/*  371 */       this._events != null && 
/*  372 */       postEventsForChanges()) {
/*  373 */       this._events.post(ITender.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  380 */     boolean ev_postable = false;
/*      */     
/*  382 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  383 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  384 */       getDAO_().setDescription(argDescription);
/*  385 */       ev_postable = true;
/*      */     } 
/*      */     
/*  388 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDisplayOrder() {
/*  396 */     if (getDAO_().getDisplayOrder() != null) {
/*  397 */       return getDAO_().getDisplayOrder().intValue();
/*      */     }
/*      */     
/*  400 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayOrder(int argDisplayOrder) {
/*  409 */     if (setDisplayOrder_noev(argDisplayOrder) && 
/*  410 */       this._events != null && 
/*  411 */       postEventsForChanges()) {
/*  412 */       this._events.post(ITender.SET_DISPLAYORDER, Integer.valueOf(argDisplayOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisplayOrder_noev(int argDisplayOrder) {
/*  419 */     boolean ev_postable = false;
/*      */     
/*  421 */     if ((getDAO_().getDisplayOrder() == null && Integer.valueOf(argDisplayOrder) != null) || (
/*  422 */       getDAO_().getDisplayOrder() != null && !getDAO_().getDisplayOrder().equals(Integer.valueOf(argDisplayOrder)))) {
/*  423 */       getDAO_().setDisplayOrder(Integer.valueOf(argDisplayOrder));
/*  424 */       ev_postable = true;
/*      */     } 
/*      */     
/*  427 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFlashSalesDisplayOrder() {
/*  435 */     if (getDAO_().getFlashSalesDisplayOrder() != null) {
/*  436 */       return getDAO_().getFlashSalesDisplayOrder().intValue();
/*      */     }
/*      */     
/*  439 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFlashSalesDisplayOrder(int argFlashSalesDisplayOrder) {
/*  448 */     if (setFlashSalesDisplayOrder_noev(argFlashSalesDisplayOrder) && 
/*  449 */       this._events != null && 
/*  450 */       postEventsForChanges()) {
/*  451 */       this._events.post(ITender.SET_FLASHSALESDISPLAYORDER, Integer.valueOf(argFlashSalesDisplayOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFlashSalesDisplayOrder_noev(int argFlashSalesDisplayOrder) {
/*  458 */     boolean ev_postable = false;
/*      */     
/*  460 */     if ((getDAO_().getFlashSalesDisplayOrder() == null && Integer.valueOf(argFlashSalesDisplayOrder) != null) || (
/*  461 */       getDAO_().getFlashSalesDisplayOrder() != null && !getDAO_().getFlashSalesDisplayOrder().equals(Integer.valueOf(argFlashSalesDisplayOrder)))) {
/*  462 */       getDAO_().setFlashSalesDisplayOrder(Integer.valueOf(argFlashSalesDisplayOrder));
/*  463 */       ev_postable = true;
/*      */     } 
/*      */     
/*  466 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderTypecode() {
/*  474 */     return getDAO_().getTenderTypecode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderTypecode(String argTenderTypecode) {
/*  482 */     if (setTenderTypecode_noev(argTenderTypecode) && 
/*  483 */       this._events != null && 
/*  484 */       postEventsForChanges()) {
/*  485 */       this._events.post(ITender.SET_TENDERTYPECODE, argTenderTypecode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderTypecode_noev(String argTenderTypecode) {
/*  492 */     boolean ev_postable = false;
/*      */     
/*  494 */     if ((getDAO_().getTenderTypecode() == null && argTenderTypecode != null) || (
/*  495 */       getDAO_().getTenderTypecode() != null && !getDAO_().getTenderTypecode().equals(argTenderTypecode))) {
/*  496 */       getDAO_().setTenderTypecode(argTenderTypecode);
/*  497 */       ev_postable = true;
/*      */     } 
/*      */     
/*  500 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisabled() {
/*  508 */     if (getDAO_().getDisabled() != null) {
/*  509 */       return getDAO_().getDisabled().booleanValue();
/*      */     }
/*      */     
/*  512 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisabled(boolean argDisabled) {
/*  521 */     if (setDisabled_noev(argDisabled) && 
/*  522 */       this._events != null && 
/*  523 */       postEventsForChanges()) {
/*  524 */       this._events.post(ITender.SET_DISABLED, Boolean.valueOf(argDisabled));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisabled_noev(boolean argDisabled) {
/*  531 */     boolean ev_postable = false;
/*      */     
/*  533 */     if ((getDAO_().getDisabled() == null && Boolean.valueOf(argDisabled) != null) || (
/*  534 */       getDAO_().getDisabled() != null && !getDAO_().getDisabled().equals(Boolean.valueOf(argDisabled)))) {
/*  535 */       getDAO_().setDisabled(Boolean.valueOf(argDisabled));
/*  536 */       ev_postable = true;
/*      */     } 
/*      */     
/*  539 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITenderProperty newProperty(String argPropertyName) {
/*  543 */     TenderPropertyId id = new TenderPropertyId();
/*      */     
/*  545 */     id.setTenderId(getTenderId());
/*  546 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  548 */     ITenderProperty prop = (ITenderProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderProperty.class);
/*  549 */     return prop;
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
/*      */   @Relationship(name = "TenderOptions")
/*      */   public List<ITenderOptions> getTenderOptions() {
/*  570 */     if (this._tenderOptions == null) {
/*  571 */       this._tenderOptions = new HistoricalList(null);
/*      */     }
/*  573 */     return (List<ITenderOptions>)this._tenderOptions;
/*      */   }
/*      */   
/*      */   public void setTenderOptions(List<ITenderOptions> argTenderOptions) {
/*  577 */     if (this._tenderOptions == null) {
/*  578 */       this._tenderOptions = new HistoricalList(argTenderOptions);
/*      */     } else {
/*  580 */       this._tenderOptions.setCurrentList(argTenderOptions);
/*      */     } 
/*      */     
/*  583 */     for (ITenderOptions child : this._tenderOptions) {
/*  584 */       child.setParentTender(this);
/*      */     }
/*      */     
/*  587 */     for (ITenderOptions child : this._tenderOptions) {
/*  588 */       TenderOptionsModel model = (TenderOptionsModel)child;
/*  589 */       model.setOrganizationId_noev(getOrganizationId());
/*  590 */       model.setTenderId_noev(getTenderId());
/*  591 */       if (child instanceof IDataModelImpl) {
/*  592 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  593 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  594 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  595 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  598 */       if (postEventsForChanges()) {
/*  599 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTenderOptions(ITenderOptions argTenderOptions) {
/*  606 */     argTenderOptions.setParentTender(this);
/*  607 */     if (this._tenderOptions == null) {
/*  608 */       this._tenderOptions = new HistoricalList(null);
/*      */     }
/*  610 */     argTenderOptions.setOrganizationId(getOrganizationId());
/*  611 */     argTenderOptions.setTenderId(getTenderId());
/*  612 */     if (argTenderOptions instanceof IDataModelImpl) {
/*  613 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderOptions).getDAO();
/*  614 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  615 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  616 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  621 */     if (postEventsForChanges()) {
/*  622 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderOptions));
/*      */     }
/*      */     
/*  625 */     this._tenderOptions.add(argTenderOptions);
/*  626 */     if (postEventsForChanges()) {
/*  627 */       this._events.post(ITender.ADD_TENDEROPTIONS, argTenderOptions);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderOptions(ITenderOptions argTenderOptions) {
/*  632 */     if (this._tenderOptions != null) {
/*      */       
/*  634 */       if (postEventsForChanges()) {
/*  635 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderOptions));
/*      */       }
/*  637 */       this._tenderOptions.remove(argTenderOptions);
/*      */       
/*  639 */       argTenderOptions.setParentTender(null);
/*  640 */       if (postEventsForChanges()) {
/*  641 */         this._events.post(ITender.REMOVE_TENDEROPTIONS, argTenderOptions);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TenderAvailabilityCodes")
/*      */   public List<ITenderAvailability> getTenderAvailabilityCodes() {
/*  648 */     if (this._tenderAvailabilityCodes == null) {
/*  649 */       this._tenderAvailabilityCodes = new HistoricalList(null);
/*      */     }
/*  651 */     return (List<ITenderAvailability>)this._tenderAvailabilityCodes;
/*      */   }
/*      */   
/*      */   protected void setTenderAvailabilityCodesImpl(List<ITenderAvailability> argTenderAvailabilityCodes) {
/*  655 */     if (this._tenderAvailabilityCodes == null) {
/*  656 */       this._tenderAvailabilityCodes = new HistoricalList(argTenderAvailabilityCodes);
/*      */     } else {
/*  658 */       this._tenderAvailabilityCodes.setCurrentList(argTenderAvailabilityCodes);
/*      */     } 
/*      */     
/*  661 */     for (ITenderAvailability child : this._tenderAvailabilityCodes) {
/*  662 */       TenderAvailabilityModel model = (TenderAvailabilityModel)child;
/*  663 */       model.setOrganizationId_noev(getOrganizationId());
/*  664 */       model.setTenderId_noev(getTenderId());
/*  665 */       if (child instanceof IDataModelImpl) {
/*  666 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  667 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  668 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  669 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  672 */       if (postEventsForChanges()) {
/*  673 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void addTenderAvailabilityImpl(ITenderAvailability argTenderAvailability) {
/*  679 */     if (this._tenderAvailabilityCodes == null) {
/*  680 */       this._tenderAvailabilityCodes = new HistoricalList(null);
/*      */     }
/*  682 */     argTenderAvailability.setOrganizationId(getOrganizationId());
/*  683 */     argTenderAvailability.setTenderId(getTenderId());
/*  684 */     if (argTenderAvailability instanceof IDataModelImpl) {
/*  685 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderAvailability).getDAO();
/*  686 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  687 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  688 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  693 */     if (postEventsForChanges()) {
/*  694 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderAvailability));
/*      */     }
/*      */     
/*  697 */     this._tenderAvailabilityCodes.add(argTenderAvailability);
/*  698 */     if (postEventsForChanges()) {
/*  699 */       this._events.post(ITender.ADD_TENDERAVAILABILITYCODES, argTenderAvailability);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void removeTenderAvailabilityImpl(ITenderAvailability argTenderAvailability) {
/*  704 */     if (this._tenderAvailabilityCodes != null) {
/*      */       
/*  706 */       if (postEventsForChanges()) {
/*  707 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderAvailability));
/*      */       }
/*  709 */       this._tenderAvailabilityCodes.remove(argTenderAvailability);
/*  710 */       if (postEventsForChanges()) {
/*  711 */         this._events.post(ITender.REMOVE_TENDERAVAILABILITYCODES, argTenderAvailability);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TenderDenominations")
/*      */   public List<ITenderDenomination> getTenderDenominations() {
/*  718 */     if (this._tenderDenominations == null) {
/*  719 */       this._tenderDenominations = new HistoricalList(null);
/*      */     }
/*  721 */     return (List<ITenderDenomination>)this._tenderDenominations;
/*      */   }
/*      */   
/*      */   public void setTenderDenominations(List<ITenderDenomination> argTenderDenominations) {
/*  725 */     if (this._tenderDenominations == null) {
/*  726 */       this._tenderDenominations = new HistoricalList(argTenderDenominations);
/*      */     } else {
/*  728 */       this._tenderDenominations.setCurrentList(argTenderDenominations);
/*      */     } 
/*      */     
/*  731 */     for (ITenderDenomination child : this._tenderDenominations) {
/*  732 */       child.setParentTender(this);
/*      */     }
/*      */     
/*  735 */     for (ITenderDenomination child : this._tenderDenominations) {
/*  736 */       TenderDenominationModel model = (TenderDenominationModel)child;
/*  737 */       model.setOrganizationId_noev(getOrganizationId());
/*  738 */       model.setTenderId_noev(getTenderId());
/*  739 */       if (child instanceof IDataModelImpl) {
/*  740 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  741 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  742 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  743 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  746 */       if (postEventsForChanges()) {
/*  747 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTenderDenomination(ITenderDenomination argTenderDenomination) {
/*  754 */     argTenderDenomination.setParentTender(this);
/*  755 */     if (this._tenderDenominations == null) {
/*  756 */       this._tenderDenominations = new HistoricalList(null);
/*      */     }
/*  758 */     argTenderDenomination.setOrganizationId(getOrganizationId());
/*  759 */     argTenderDenomination.setTenderId(getTenderId());
/*  760 */     if (argTenderDenomination instanceof IDataModelImpl) {
/*  761 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderDenomination).getDAO();
/*  762 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  763 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  764 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  769 */     if (postEventsForChanges()) {
/*  770 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenomination));
/*      */     }
/*      */     
/*  773 */     this._tenderDenominations.add(argTenderDenomination);
/*  774 */     if (postEventsForChanges()) {
/*  775 */       this._events.post(ITender.ADD_TENDERDENOMINATIONS, argTenderDenomination);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderDenomination(ITenderDenomination argTenderDenomination) {
/*  780 */     if (this._tenderDenominations != null) {
/*      */       
/*  782 */       if (postEventsForChanges()) {
/*  783 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenomination));
/*      */       }
/*  785 */       this._tenderDenominations.remove(argTenderDenomination);
/*      */       
/*  787 */       argTenderDenomination.setParentTender(null);
/*  788 */       if (postEventsForChanges()) {
/*  789 */         this._events.post(ITender.REMOVE_TENDERDENOMINATIONS, argTenderDenomination);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TenderType")
/*      */   public ITenderType getTenderType() {
/*  796 */     return this._tenderType;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTenderType(ITenderType argTenderType) {
/*  801 */     if (argTenderType == null) {
/*      */       
/*  803 */       getDAO_().setTenderTypecode(null);
/*  804 */       if (this._tenderType != null)
/*      */       {
/*  806 */         if (postEventsForChanges()) {
/*  807 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._tenderType));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  812 */       getDAO_().setTenderTypecode(argTenderType.getTenderTypecode());
/*      */       
/*  814 */       if (postEventsForChanges()) {
/*  815 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderType));
/*      */       }
/*      */     } 
/*      */     
/*  819 */     this._tenderType = argTenderType;
/*  820 */     if (postEventsForChanges()) {
/*  821 */       this._events.post(ITender.SET_TENDERTYPE, argTenderType);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITenderProperty> getProperties() {
/*  827 */     if (this._properties == null) {
/*  828 */       this._properties = new HistoricalList(null);
/*      */     }
/*  830 */     return (List<ITenderProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITenderProperty> argProperties) {
/*  834 */     if (this._properties == null) {
/*  835 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  837 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  840 */     for (ITenderProperty child : this._properties) {
/*  841 */       TenderPropertyModel model = (TenderPropertyModel)child;
/*  842 */       model.setOrganizationId_noev(getOrganizationId());
/*  843 */       model.setTenderId_noev(getTenderId());
/*  844 */       if (child instanceof IDataModelImpl) {
/*  845 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  846 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  847 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  848 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  851 */       if (postEventsForChanges()) {
/*  852 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTenderProperty(ITenderProperty argTenderProperty) {
/*  858 */     if (this._properties == null) {
/*  859 */       this._properties = new HistoricalList(null);
/*      */     }
/*  861 */     argTenderProperty.setOrganizationId(getOrganizationId());
/*  862 */     argTenderProperty.setTenderId(getTenderId());
/*  863 */     if (argTenderProperty instanceof IDataModelImpl) {
/*  864 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderProperty).getDAO();
/*  865 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  866 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  867 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  872 */     if (postEventsForChanges()) {
/*  873 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderProperty));
/*      */     }
/*      */     
/*  876 */     this._properties.add(argTenderProperty);
/*  877 */     if (postEventsForChanges()) {
/*  878 */       this._events.post(ITender.ADD_PROPERTIES, argTenderProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderProperty(ITenderProperty argTenderProperty) {
/*  883 */     if (this._properties != null) {
/*      */       
/*  885 */       if (postEventsForChanges()) {
/*  886 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderProperty));
/*      */       }
/*  888 */       this._properties.remove(argTenderProperty);
/*  889 */       if (postEventsForChanges()) {
/*  890 */         this._events.post(ITender.REMOVE_PROPERTIES, argTenderProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  897 */     if ("TenderOptions".equals(argFieldId)) {
/*  898 */       return getTenderOptions();
/*      */     }
/*  900 */     if ("TenderAvailabilityCodes".equals(argFieldId)) {
/*  901 */       return getTenderAvailabilityCodes();
/*      */     }
/*  903 */     if ("TenderDenominations".equals(argFieldId)) {
/*  904 */       return getTenderDenominations();
/*      */     }
/*  906 */     if ("TenderType".equals(argFieldId)) {
/*  907 */       return getTenderType();
/*      */     }
/*  909 */     if ("Properties".equals(argFieldId)) {
/*  910 */       return getProperties();
/*      */     }
/*  912 */     if ("TenderExtension".equals(argFieldId)) {
/*  913 */       return this._myExtension;
/*      */     }
/*      */     
/*  916 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  922 */     if ("TenderOptions".equals(argFieldId)) {
/*  923 */       setTenderOptions(changeToList(argValue, ITenderOptions.class));
/*      */     }
/*  925 */     else if ("TenderAvailabilityCodes".equals(argFieldId)) {
/*  926 */       setTenderAvailabilityCodes(changeToList(argValue, ITenderAvailability.class));
/*      */     }
/*  928 */     else if ("TenderDenominations".equals(argFieldId)) {
/*  929 */       setTenderDenominations(changeToList(argValue, ITenderDenomination.class));
/*      */     }
/*  931 */     else if ("TenderType".equals(argFieldId)) {
/*  932 */       setTenderType((ITenderType)argValue);
/*      */     }
/*  934 */     else if ("Properties".equals(argFieldId)) {
/*  935 */       setProperties(changeToList(argValue, ITenderProperty.class));
/*      */     }
/*  937 */     else if ("TenderExtension".equals(argFieldId)) {
/*  938 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  941 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  947 */     this._persistenceDefaults = argPD;
/*  948 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  949 */     this._eventManager = argEM;
/*  950 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  951 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  952 */     if (this._tenderOptions != null) {
/*  953 */       for (ITenderOptions relationship : this._tenderOptions) {
/*  954 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  957 */     if (this._tenderAvailabilityCodes != null) {
/*  958 */       for (ITenderAvailability relationship : this._tenderAvailabilityCodes) {
/*  959 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  962 */     if (this._tenderDenominations != null) {
/*  963 */       for (ITenderDenomination relationship : this._tenderDenominations) {
/*  964 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*  967 */     if (this._tenderType != null) {
/*  968 */       ((IDataModelImpl)this._tenderType).setDependencies(argPD, argEM);
/*      */     }
/*  970 */     if (this._properties != null) {
/*  971 */       for (ITenderProperty relationship : this._properties) {
/*  972 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderExt() {
/*  978 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderExt(IDataModel argExt) {
/*  982 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  987 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  991 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  994 */     super.startTransaction();
/*      */     
/*  996 */     this._tenderOptionsSavepoint = this._tenderOptions;
/*  997 */     if (this._tenderOptions != null) {
/*  998 */       this._tenderOptionsSavepoint = new HistoricalList((List)this._tenderOptions);
/*  999 */       Iterator<IDataModel> it = this._tenderOptions.iterator();
/* 1000 */       while (it.hasNext()) {
/* 1001 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1005 */     this._tenderAvailabilityCodesSavepoint = this._tenderAvailabilityCodes;
/* 1006 */     if (this._tenderAvailabilityCodes != null) {
/* 1007 */       this._tenderAvailabilityCodesSavepoint = new HistoricalList((List)this._tenderAvailabilityCodes);
/* 1008 */       Iterator<IDataModel> it = this._tenderAvailabilityCodes.iterator();
/* 1009 */       while (it.hasNext()) {
/* 1010 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1014 */     this._tenderDenominationsSavepoint = this._tenderDenominations;
/* 1015 */     if (this._tenderDenominations != null) {
/* 1016 */       this._tenderDenominationsSavepoint = new HistoricalList((List)this._tenderDenominations);
/* 1017 */       Iterator<IDataModel> it = this._tenderDenominations.iterator();
/* 1018 */       while (it.hasNext()) {
/* 1019 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1023 */     this._tenderTypeSavepoint = this._tenderType;
/* 1024 */     if (this._tenderType != null) {
/* 1025 */       this._tenderType.startTransaction();
/*      */     }
/*      */     
/* 1028 */     this._propertiesSavepoint = this._properties;
/* 1029 */     if (this._properties != null) {
/* 1030 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1031 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1032 */       while (it.hasNext()) {
/* 1033 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1038 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1043 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1046 */     super.rollbackChanges();
/*      */     
/* 1048 */     this._tenderOptions = this._tenderOptionsSavepoint;
/* 1049 */     this._tenderOptionsSavepoint = null;
/* 1050 */     if (this._tenderOptions != null) {
/* 1051 */       Iterator<IDataModel> it = this._tenderOptions.iterator();
/* 1052 */       while (it.hasNext()) {
/* 1053 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1057 */     this._tenderAvailabilityCodes = this._tenderAvailabilityCodesSavepoint;
/* 1058 */     this._tenderAvailabilityCodesSavepoint = null;
/* 1059 */     if (this._tenderAvailabilityCodes != null) {
/* 1060 */       Iterator<IDataModel> it = this._tenderAvailabilityCodes.iterator();
/* 1061 */       while (it.hasNext()) {
/* 1062 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1066 */     this._tenderDenominations = this._tenderDenominationsSavepoint;
/* 1067 */     this._tenderDenominationsSavepoint = null;
/* 1068 */     if (this._tenderDenominations != null) {
/* 1069 */       Iterator<IDataModel> it = this._tenderDenominations.iterator();
/* 1070 */       while (it.hasNext()) {
/* 1071 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1075 */     this._tenderType = this._tenderTypeSavepoint;
/* 1076 */     this._tenderTypeSavepoint = null;
/* 1077 */     if (this._tenderType != null) {
/* 1078 */       this._tenderType.rollbackChanges();
/*      */     }
/*      */     
/* 1081 */     this._properties = this._propertiesSavepoint;
/* 1082 */     this._propertiesSavepoint = null;
/* 1083 */     if (this._properties != null) {
/* 1084 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1085 */       while (it.hasNext()) {
/* 1086 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1094 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1097 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1100 */     super.commitTransaction();
/*      */     
/* 1102 */     this._tenderOptionsSavepoint = this._tenderOptions;
/* 1103 */     if (this._tenderOptions != null) {
/* 1104 */       Iterator<IDataModel> it = this._tenderOptions.iterator();
/* 1105 */       while (it.hasNext()) {
/* 1106 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1108 */       this._tenderOptions = new HistoricalList((List)this._tenderOptions);
/*      */     } 
/*      */     
/* 1111 */     this._tenderAvailabilityCodesSavepoint = this._tenderAvailabilityCodes;
/* 1112 */     if (this._tenderAvailabilityCodes != null) {
/* 1113 */       Iterator<IDataModel> it = this._tenderAvailabilityCodes.iterator();
/* 1114 */       while (it.hasNext()) {
/* 1115 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1117 */       this._tenderAvailabilityCodes = new HistoricalList((List)this._tenderAvailabilityCodes);
/*      */     } 
/*      */     
/* 1120 */     this._tenderDenominationsSavepoint = this._tenderDenominations;
/* 1121 */     if (this._tenderDenominations != null) {
/* 1122 */       Iterator<IDataModel> it = this._tenderDenominations.iterator();
/* 1123 */       while (it.hasNext()) {
/* 1124 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1126 */       this._tenderDenominations = new HistoricalList((List)this._tenderDenominations);
/*      */     } 
/*      */     
/* 1129 */     this._tenderTypeSavepoint = this._tenderType;
/* 1130 */     if (this._tenderType != null) {
/* 1131 */       this._tenderType.commitTransaction();
/*      */     }
/*      */     
/* 1134 */     this._propertiesSavepoint = this._properties;
/* 1135 */     if (this._properties != null) {
/* 1136 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1137 */       while (it.hasNext()) {
/* 1138 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1140 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1144 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1149 */     argStream.defaultReadObject();
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
/* 1160 */   private transient Set<String> _availCodes = new HashSet<>();
/* 1161 */   private transient ITenderOptions _options = null;
/* 1162 */   private transient ConfigKeyedDataFilter _dataFilter = new ConfigKeyedDataFilter();
/*      */   
/*      */   public boolean containsAvailCode(String argAvailCode) {
/* 1165 */     if (this._availCodes == null) {
/* 1166 */       this._availCodes = new HashSet<>();
/*      */       
/* 1168 */       List<ITenderAvailability> availabilities = getTenderAvailabilityCodes();
/*      */       
/* 1170 */       for (ITenderAvailability ta : availabilities) {
/* 1171 */         this._availCodes.add(ta.getAvailabilityCode());
/*      */       }
/*      */     } 
/* 1174 */     return this._availCodes.contains(argAvailCode);
/*      */   }
/*      */   
/*      */   public ITenderOptions getOptions() {
/* 1178 */     if (this._options == null) {
/* 1179 */       List<ITenderOptions> r = getTenderOptions();
/* 1180 */       Collection<ITenderOptions> tenderOptions = this._dataFilter.filterResults(r);
/* 1181 */       List<ITenderOptions> list = new ArrayList<>(tenderOptions);
/* 1182 */       this._options = list.get(0);
/*      */     } 
/*      */     
/* 1185 */     return this._options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderAvailabilityCodes(List<ITenderAvailability> argTenderAvailabilityCodes) {
/* 1192 */     setTenderAvailabilityCodesImpl(argTenderAvailabilityCodes);
/*      */     
/* 1194 */     this._availCodes.clear();
/* 1195 */     for (ITenderAvailability ta : argTenderAvailabilityCodes) {
/* 1196 */       this._availCodes.add(ta.getAvailabilityCode());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTenderAvailability(ITenderAvailability argTenderAvailability) {
/* 1204 */     addTenderAvailabilityImpl(argTenderAvailability);
/* 1205 */     this._availCodes.add(argTenderAvailability.getAvailabilityCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeTenderAvailability(ITenderAvailability argTenderAvailability) {
/* 1212 */     removeTenderAvailabilityImpl(argTenderAvailability);
/* 1213 */     this._availCodes.remove(argTenderAvailability.getAvailabilityCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCurrencyId() {
/* 1220 */     if ("*".equalsIgnoreCase(getCurrencyIdRaw())) {
/* 1221 */       return getPersistenceDefaults().getCurrencyId();
/*      */     }
/* 1223 */     return getDAO_().getCurrencyId();
/*      */   }
/*      */   
/*      */   public String getCurrencyIdRaw() {
/* 1227 */     return getDAO_().getCurrencyId();
/*      */   }
/*      */   
/*      */   public String getTenderDescriptionTranslated() {
/* 1231 */     return FormattableFactory.getInstance()
/* 1232 */       .getSimpleFormattable(getDescription()).toString(OutputContextType.VIEW);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */