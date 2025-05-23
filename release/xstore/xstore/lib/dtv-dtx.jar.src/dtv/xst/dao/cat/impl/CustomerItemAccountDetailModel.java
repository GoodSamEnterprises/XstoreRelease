/*      */ package dtv.xst.dao.cat.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.cat.CustomerItemAccountDetailPropertyId;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccount;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccountActivity;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccountDetail;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccountDetailProperty;
/*      */ import dtv.xst.dao.loc.IRetailLocation;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class CustomerItemAccountDetailModel extends CustomerItemAccountDetailBaseModel implements ICustomerItemAccountDetail {
/*      */   private static final long serialVersionUID = -2003297235L;
/*      */   private ICustomerItemAccount _parentCustItemAccount;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IRetailTransactionLineItem _retailLineItem;
/*      */   private transient IRetailTransactionLineItem _retailLineItemSavepoint;
/*      */   
/*      */   public String toString() {
/*   39 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<ICustomerItemAccountActivity> _custItemAccountActivities; private transient HistoricalList<ICustomerItemAccountActivity> _custItemAccountActivitiesSavepoint; private IRetailLocation _sourceLocation; private transient IRetailLocation _sourceLocationSavepoint; private IRetailLocation _fullfillmentLocation; private transient IRetailLocation _fullfillmentLocationSavepoint; private HistoricalList<ICustomerItemAccountDetailProperty> _properties; private transient HistoricalList<ICustomerItemAccountDetailProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   44 */     setDAO((IDataAccessObject)new CustomerItemAccountDetailDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CustomerItemAccountDetailDAO getDAO_() {
/*   52 */     return (CustomerItemAccountDetailDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   60 */     if (getDAO_().getOrganizationId() != null) {
/*   61 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   64 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   73 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   74 */       this._events != null && 
/*   75 */       postEventsForChanges()) {
/*   76 */       this._events.post(ICustomerItemAccountDetail.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   83 */     boolean ev_postable = false;
/*      */     
/*   85 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   86 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   87 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   88 */       ev_postable = true;
/*   89 */       if (this._custItemAccountActivities != null) {
/*      */         
/*   91 */         Iterator<CustomerItemAccountActivityModel> it = this._custItemAccountActivities.iterator();
/*   92 */         while (it.hasNext())
/*      */         {
/*   94 */           ((CustomerItemAccountActivityModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   97 */       if (this._properties != null) {
/*      */         
/*   99 */         Iterator<CustomerItemAccountDetailPropertyModel> it = this._properties.iterator();
/*  100 */         while (it.hasNext())
/*      */         {
/*  102 */           ((CustomerItemAccountDetailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  107 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountId() {
/*  115 */     return getDAO_().getCustAccountId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountId(String argCustAccountId) {
/*  123 */     if (setCustAccountId_noev(argCustAccountId) && 
/*  124 */       this._events != null && 
/*  125 */       postEventsForChanges()) {
/*  126 */       this._events.post(ICustomerItemAccountDetail.SET_CUSTACCOUNTID, argCustAccountId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountId_noev(String argCustAccountId) {
/*  133 */     boolean ev_postable = false;
/*      */     
/*  135 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/*  136 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/*  137 */       getDAO_().setCustAccountId(argCustAccountId);
/*  138 */       ev_postable = true;
/*  139 */       if (this._custItemAccountActivities != null) {
/*      */         
/*  141 */         Iterator<CustomerItemAccountActivityModel> it = this._custItemAccountActivities.iterator();
/*  142 */         while (it.hasNext())
/*      */         {
/*  144 */           ((CustomerItemAccountActivityModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*  147 */       if (this._properties != null) {
/*      */         
/*  149 */         Iterator<CustomerItemAccountDetailPropertyModel> it = this._properties.iterator();
/*  150 */         while (it.hasNext())
/*      */         {
/*  152 */           ((CustomerItemAccountDetailPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  157 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountCode() {
/*  165 */     return getDAO_().getCustAccountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountCode(String argCustAccountCode) {
/*  173 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/*  174 */       this._events != null && 
/*  175 */       postEventsForChanges()) {
/*  176 */       this._events.post(ICustomerItemAccountDetail.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/*  183 */     boolean ev_postable = false;
/*      */     
/*  185 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/*  186 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/*  187 */       getDAO_().setCustAccountCode(argCustAccountCode);
/*  188 */       ev_postable = true;
/*  189 */       if (this._custItemAccountActivities != null) {
/*      */         
/*  191 */         Iterator<CustomerItemAccountActivityModel> it = this._custItemAccountActivities.iterator();
/*  192 */         while (it.hasNext())
/*      */         {
/*  194 */           ((CustomerItemAccountActivityModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*  197 */       if (this._properties != null) {
/*      */         
/*  199 */         Iterator<CustomerItemAccountDetailPropertyModel> it = this._properties.iterator();
/*  200 */         while (it.hasNext())
/*      */         {
/*  202 */           ((CustomerItemAccountDetailPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  207 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCustAccountDetailNum() {
/*  215 */     if (getDAO_().getCustAccountDetailNum() != null) {
/*  216 */       return getDAO_().getCustAccountDetailNum().longValue();
/*      */     }
/*      */     
/*  219 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountDetailNum(long argCustAccountDetailNum) {
/*  228 */     if (setCustAccountDetailNum_noev(argCustAccountDetailNum) && 
/*  229 */       this._events != null && 
/*  230 */       postEventsForChanges()) {
/*  231 */       this._events.post(ICustomerItemAccountDetail.SET_CUSTACCOUNTDETAILNUM, Long.valueOf(argCustAccountDetailNum));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountDetailNum_noev(long argCustAccountDetailNum) {
/*  238 */     boolean ev_postable = false;
/*      */     
/*  240 */     if ((getDAO_().getCustAccountDetailNum() == null && Long.valueOf(argCustAccountDetailNum) != null) || (
/*  241 */       getDAO_().getCustAccountDetailNum() != null && !getDAO_().getCustAccountDetailNum().equals(Long.valueOf(argCustAccountDetailNum)))) {
/*  242 */       getDAO_().setCustAccountDetailNum(Long.valueOf(argCustAccountDetailNum));
/*  243 */       ev_postable = true;
/*  244 */       if (this._custItemAccountActivities != null) {
/*      */         
/*  246 */         Iterator<CustomerItemAccountActivityModel> it = this._custItemAccountActivities.iterator();
/*  247 */         while (it.hasNext())
/*      */         {
/*  249 */           ((CustomerItemAccountActivityModel)it.next()).setCustAccountDetailNum_noev(argCustAccountDetailNum);
/*      */         }
/*      */       } 
/*  252 */       if (this._properties != null) {
/*      */         
/*  254 */         Iterator<CustomerItemAccountDetailPropertyModel> it = this._properties.iterator();
/*  255 */         while (it.hasNext())
/*      */         {
/*  257 */           ((CustomerItemAccountDetailPropertyModel)it.next()).setCustAccountDetailNum_noev(argCustAccountDetailNum);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  262 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  270 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  278 */     if (setCreateDate_noev(argCreateDate) && 
/*  279 */       this._events != null && 
/*  280 */       postEventsForChanges()) {
/*  281 */       this._events.post(ICustomerItemAccountDetail.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  288 */     boolean ev_postable = false;
/*      */     
/*  290 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  291 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  292 */       getDAO_().setCreateDate(argCreateDate);
/*  293 */       ev_postable = true;
/*      */     } 
/*      */     
/*  296 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  304 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  312 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  313 */       this._events != null && 
/*  314 */       postEventsForChanges()) {
/*  315 */       this._events.post(ICustomerItemAccountDetail.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  322 */     boolean ev_postable = false;
/*      */     
/*  324 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  325 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  326 */       getDAO_().setCreateUserId(argCreateUserId);
/*  327 */       ev_postable = true;
/*      */     } 
/*      */     
/*  330 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  338 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  346 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  347 */       this._events != null && 
/*  348 */       postEventsForChanges()) {
/*  349 */       this._events.post(ICustomerItemAccountDetail.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  356 */     boolean ev_postable = false;
/*      */     
/*  358 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  359 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  360 */       getDAO_().setUpdateDate(argUpdateDate);
/*  361 */       ev_postable = true;
/*      */     } 
/*      */     
/*  364 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  372 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  380 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  381 */       this._events != null && 
/*  382 */       postEventsForChanges()) {
/*  383 */       this._events.post(ICustomerItemAccountDetail.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  390 */     boolean ev_postable = false;
/*      */     
/*  392 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  393 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  394 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  395 */       ev_postable = true;
/*      */     } 
/*      */     
/*  398 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExtendedAmount() {
/*  406 */     return getDAO_().getExtendedAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/*  414 */     if (setExtendedAmount_noev(argExtendedAmount) && 
/*  415 */       this._events != null && 
/*  416 */       postEventsForChanges()) {
/*  417 */       this._events.post(ICustomerItemAccountDetail.SET_EXTENDEDAMOUNT, argExtendedAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtendedAmount_noev(BigDecimal argExtendedAmount) {
/*  424 */     boolean ev_postable = false;
/*      */     
/*  426 */     if ((getDAO_().getExtendedAmount() == null && argExtendedAmount != null) || (
/*  427 */       getDAO_().getExtendedAmount() != null && !getDAO_().getExtendedAmount().equals(argExtendedAmount))) {
/*  428 */       getDAO_().setExtendedAmount(argExtendedAmount);
/*  429 */       ev_postable = true;
/*      */     } 
/*      */     
/*  432 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStateCode() {
/*  440 */     return getDAO_().getStateCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStateCode(String argStateCode) {
/*  448 */     if (setStateCode_noev(argStateCode) && 
/*  449 */       this._events != null && 
/*  450 */       postEventsForChanges()) {
/*  451 */       this._events.post(ICustomerItemAccountDetail.SET_STATECODE, argStateCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStateCode_noev(String argStateCode) {
/*  458 */     boolean ev_postable = false;
/*      */     
/*  460 */     if ((getDAO_().getStateCode() == null && argStateCode != null) || (
/*  461 */       getDAO_().getStateCode() != null && !getDAO_().getStateCode().equals(argStateCode))) {
/*  462 */       getDAO_().setStateCode(argStateCode);
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
/*      */   public String getTypeCode() {
/*  474 */     return getDAO_().getTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeCode(String argTypeCode) {
/*  482 */     if (setTypeCode_noev(argTypeCode) && 
/*  483 */       this._events != null && 
/*  484 */       postEventsForChanges()) {
/*  485 */       this._events.post(ICustomerItemAccountDetail.SET_TYPECODE, argTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTypeCode_noev(String argTypeCode) {
/*  492 */     boolean ev_postable = false;
/*      */     
/*  494 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/*  495 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/*  496 */       getDAO_().setTypeCode(argTypeCode);
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
/*      */   public Date getOrigItemAddDate() {
/*  508 */     return getDAO_().getOrigItemAddDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigItemAddDate(Date argOrigItemAddDate) {
/*  516 */     if (setOrigItemAddDate_noev(argOrigItemAddDate) && 
/*  517 */       this._events != null && 
/*  518 */       postEventsForChanges()) {
/*  519 */       this._events.post(ICustomerItemAccountDetail.SET_ORIGITEMADDDATE, argOrigItemAddDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigItemAddDate_noev(Date argOrigItemAddDate) {
/*  526 */     boolean ev_postable = false;
/*      */     
/*  528 */     if ((getDAO_().getOrigItemAddDate() == null && argOrigItemAddDate != null) || (
/*  529 */       getDAO_().getOrigItemAddDate() != null && !getDAO_().getOrigItemAddDate().equals(argOrigItemAddDate))) {
/*  530 */       getDAO_().setOrigItemAddDate(argOrigItemAddDate);
/*  531 */       ev_postable = true;
/*      */     } 
/*      */     
/*  534 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getScheduledPickupDate() {
/*  542 */     return getDAO_().getScheduledPickupDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setScheduledPickupDate(Date argScheduledPickupDate) {
/*  550 */     if (setScheduledPickupDate_noev(argScheduledPickupDate) && 
/*  551 */       this._events != null && 
/*  552 */       postEventsForChanges()) {
/*  553 */       this._events.post(ICustomerItemAccountDetail.SET_SCHEDULEDPICKUPDATE, argScheduledPickupDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setScheduledPickupDate_noev(Date argScheduledPickupDate) {
/*  560 */     boolean ev_postable = false;
/*      */     
/*  562 */     if ((getDAO_().getScheduledPickupDate() == null && argScheduledPickupDate != null) || (
/*  563 */       getDAO_().getScheduledPickupDate() != null && !getDAO_().getScheduledPickupDate().equals(argScheduledPickupDate))) {
/*  564 */       getDAO_().setScheduledPickupDate(argScheduledPickupDate);
/*  565 */       ev_postable = true;
/*      */     } 
/*      */     
/*  568 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  576 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  584 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  585 */       this._events != null && 
/*  586 */       postEventsForChanges()) {
/*  587 */       this._events.post(ICustomerItemAccountDetail.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  594 */     boolean ev_postable = false;
/*      */     
/*  596 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  597 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  598 */       getDAO_().setBusinessDate(argBusinessDate);
/*  599 */       ev_postable = true;
/*      */     } 
/*      */     
/*  602 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  610 */     if (getDAO_().getRetailLocationId() != null) {
/*  611 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  614 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  623 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  624 */       this._events != null && 
/*  625 */       postEventsForChanges()) {
/*  626 */       this._events.post(ICustomerItemAccountDetail.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  633 */     boolean ev_postable = false;
/*      */     
/*  635 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  636 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  637 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  638 */       ev_postable = true;
/*      */     } 
/*      */     
/*  641 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getSourceLocationId() {
/*  649 */     if (getDAO_().getSourceLocationId() != null) {
/*  650 */       return getDAO_().getSourceLocationId().longValue();
/*      */     }
/*      */     
/*  653 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSourceLocationId(long argSourceLocationId) {
/*  662 */     if (setSourceLocationId_noev(argSourceLocationId) && 
/*  663 */       this._events != null && 
/*  664 */       postEventsForChanges()) {
/*  665 */       this._events.post(ICustomerItemAccountDetail.SET_SOURCELOCATIONID, Long.valueOf(argSourceLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSourceLocationId_noev(long argSourceLocationId) {
/*  672 */     boolean ev_postable = false;
/*      */     
/*  674 */     if ((getDAO_().getSourceLocationId() == null && Long.valueOf(argSourceLocationId) != null) || (
/*  675 */       getDAO_().getSourceLocationId() != null && !getDAO_().getSourceLocationId().equals(Long.valueOf(argSourceLocationId)))) {
/*  676 */       getDAO_().setSourceLocationId(Long.valueOf(argSourceLocationId));
/*  677 */       ev_postable = true;
/*      */     } 
/*      */     
/*  680 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDeliveryType() {
/*  688 */     return getDAO_().getDeliveryType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeliveryType(String argDeliveryType) {
/*  696 */     if (setDeliveryType_noev(argDeliveryType) && 
/*  697 */       this._events != null && 
/*  698 */       postEventsForChanges()) {
/*  699 */       this._events.post(ICustomerItemAccountDetail.SET_DELIVERYTYPE, argDeliveryType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDeliveryType_noev(String argDeliveryType) {
/*  706 */     boolean ev_postable = false;
/*      */     
/*  708 */     if ((getDAO_().getDeliveryType() == null && argDeliveryType != null) || (
/*  709 */       getDAO_().getDeliveryType() != null && !getDAO_().getDeliveryType().equals(argDeliveryType))) {
/*  710 */       getDAO_().setDeliveryType(argDeliveryType);
/*  711 */       ev_postable = true;
/*      */     } 
/*      */     
/*  714 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getFullfillmentLocationId() {
/*  722 */     if (getDAO_().getFullfillmentLocationId() != null) {
/*  723 */       return getDAO_().getFullfillmentLocationId().longValue();
/*      */     }
/*      */     
/*  726 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFullfillmentLocationId(long argFullfillmentLocationId) {
/*  735 */     if (setFullfillmentLocationId_noev(argFullfillmentLocationId) && 
/*  736 */       this._events != null && 
/*  737 */       postEventsForChanges()) {
/*  738 */       this._events.post(ICustomerItemAccountDetail.SET_FULLFILLMENTLOCATIONID, Long.valueOf(argFullfillmentLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFullfillmentLocationId_noev(long argFullfillmentLocationId) {
/*  745 */     boolean ev_postable = false;
/*      */     
/*  747 */     if ((getDAO_().getFullfillmentLocationId() == null && Long.valueOf(argFullfillmentLocationId) != null) || (
/*  748 */       getDAO_().getFullfillmentLocationId() != null && !getDAO_().getFullfillmentLocationId().equals(Long.valueOf(argFullfillmentLocationId)))) {
/*  749 */       getDAO_().setFullfillmentLocationId(Long.valueOf(argFullfillmentLocationId));
/*  750 */       ev_postable = true;
/*      */     } 
/*      */     
/*  753 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getReceivedByCustDate() {
/*  761 */     return getDAO_().getReceivedByCustDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReceivedByCustDate(Date argReceivedByCustDate) {
/*  769 */     if (setReceivedByCustDate_noev(argReceivedByCustDate) && 
/*  770 */       this._events != null && 
/*  771 */       postEventsForChanges()) {
/*  772 */       this._events.post(ICustomerItemAccountDetail.SET_RECEIVEDBYCUSTDATE, argReceivedByCustDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReceivedByCustDate_noev(Date argReceivedByCustDate) {
/*  779 */     boolean ev_postable = false;
/*      */     
/*  781 */     if ((getDAO_().getReceivedByCustDate() == null && argReceivedByCustDate != null) || (
/*  782 */       getDAO_().getReceivedByCustDate() != null && !getDAO_().getReceivedByCustDate().equals(argReceivedByCustDate))) {
/*  783 */       getDAO_().setReceivedByCustDate(argReceivedByCustDate);
/*  784 */       ev_postable = true;
/*      */     } 
/*      */     
/*  787 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  795 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  796 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  799 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  808 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  809 */       this._events != null && 
/*  810 */       postEventsForChanges()) {
/*  811 */       this._events.post(ICustomerItemAccountDetail.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  818 */     boolean ev_postable = false;
/*      */     
/*  820 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  821 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  822 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  823 */       ev_postable = true;
/*      */     } 
/*      */     
/*  826 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  834 */     if (getDAO_().getTransactionSequence() != null) {
/*  835 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  838 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  847 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  848 */       this._events != null && 
/*  849 */       postEventsForChanges()) {
/*  850 */       this._events.post(ICustomerItemAccountDetail.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  857 */     boolean ev_postable = false;
/*      */     
/*  859 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  860 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  861 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  862 */       ev_postable = true;
/*      */     } 
/*      */     
/*  865 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  873 */     if (getDAO_().getWorkstationId() != null) {
/*  874 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  877 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  886 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  887 */       this._events != null && 
/*  888 */       postEventsForChanges()) {
/*  889 */       this._events.post(ICustomerItemAccountDetail.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  896 */     boolean ev_postable = false;
/*      */     
/*  898 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  899 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  900 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  901 */       ev_postable = true;
/*      */     } 
/*      */     
/*  904 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getNetAmount() {
/*  912 */     return getDAO_().getNetAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNetAmount(BigDecimal argNetAmount) {
/*  920 */     if (setNetAmount_noev(argNetAmount) && 
/*  921 */       this._events != null && 
/*  922 */       postEventsForChanges()) {
/*  923 */       this._events.post(ICustomerItemAccountDetail.SET_NETAMOUNT, argNetAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNetAmount_noev(BigDecimal argNetAmount) {
/*  930 */     boolean ev_postable = false;
/*      */     
/*  932 */     if ((getDAO_().getNetAmount() == null && argNetAmount != null) || (
/*  933 */       getDAO_().getNetAmount() != null && !getDAO_().getNetAmount().equals(argNetAmount))) {
/*  934 */       getDAO_().setNetAmount(argNetAmount);
/*  935 */       ev_postable = true;
/*      */     } 
/*      */     
/*  938 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitPrice(BigDecimal argUnitPrice) {
/*  946 */     if (setUnitPrice_noev(argUnitPrice) && 
/*  947 */       this._events != null && 
/*  948 */       postEventsForChanges()) {
/*  949 */       this._events.post(ICustomerItemAccountDetail.SET_UNITPRICE, argUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitPrice_noev(BigDecimal argUnitPrice) {
/*  956 */     boolean ev_postable = false;
/*      */     
/*  958 */     if ((getDAO_().getUnitPrice() == null && argUnitPrice != null) || (
/*  959 */       getDAO_().getUnitPrice() != null && !getDAO_().getUnitPrice().equals(argUnitPrice))) {
/*  960 */       getDAO_().setUnitPrice(argUnitPrice);
/*  961 */       ev_postable = true;
/*      */     } 
/*      */     
/*  964 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(BigDecimal argQuantity) {
/*  972 */     if (setQuantity_noev(argQuantity) && 
/*  973 */       this._events != null && 
/*  974 */       postEventsForChanges()) {
/*  975 */       this._events.post(ICustomerItemAccountDetail.SET_QUANTITY, argQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/*  982 */     boolean ev_postable = false;
/*      */     
/*  984 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/*  985 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/*  986 */       getDAO_().setQuantity(argQuantity);
/*  987 */       ev_postable = true;
/*      */     } 
/*      */     
/*  990 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ICustomerItemAccountDetailProperty newProperty(String argPropertyName) {
/*  994 */     CustomerItemAccountDetailPropertyId id = new CustomerItemAccountDetailPropertyId();
/*      */     
/*  996 */     id.setCustAccountId(getCustAccountId());
/*  997 */     id.setCustAccountCode(getCustAccountCode());
/*  998 */     id.setCustAccountDetailNum(Long.valueOf(getCustAccountDetailNum()));
/*  999 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1001 */     ICustomerItemAccountDetailProperty prop = (ICustomerItemAccountDetailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerItemAccountDetailProperty.class);
/* 1002 */     return prop;
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
/*      */   @Relationship(name = "RetailLineItem")
/*      */   public IRetailTransactionLineItem getRetailLineItem() {
/* 1023 */     return this._retailLineItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRetailLineItem(IRetailTransactionLineItem argRetailLineItem) {
/* 1028 */     if (argRetailLineItem == null) {
/*      */       
/* 1030 */       getDAO_().setRetailLocationId(null);
/* 1031 */       getDAO_().setBusinessDate(null);
/* 1032 */       getDAO_().setWorkstationId(null);
/* 1033 */       getDAO_().setTransactionSequence(null);
/* 1034 */       getDAO_().setRetailTransactionLineItemSequence(null);
/* 1035 */       if (this._retailLineItem != null)
/*      */       {
/* 1037 */         if (postEventsForChanges()) {
/* 1038 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._retailLineItem));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1043 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLineItem.getRetailLocationId()));
/* 1044 */       getDAO_().setBusinessDate(argRetailLineItem.getBusinessDate());
/* 1045 */       getDAO_().setWorkstationId(Long.valueOf(argRetailLineItem.getWorkstationId()));
/* 1046 */       getDAO_().setTransactionSequence(Long.valueOf(argRetailLineItem.getTransactionSequence()));
/* 1047 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailLineItem.getRetailTransactionLineItemSequence()));
/*      */       
/* 1049 */       if (postEventsForChanges()) {
/* 1050 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailLineItem));
/*      */       }
/*      */     } 
/*      */     
/* 1054 */     this._retailLineItem = argRetailLineItem;
/* 1055 */     if (postEventsForChanges()) {
/* 1056 */       this._events.post(ICustomerItemAccountDetail.SET_RETAILLINEITEM, argRetailLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustItemAccountActivities")
/*      */   public List<ICustomerItemAccountActivity> getCustItemAccountActivities() {
/* 1062 */     if (this._custItemAccountActivities == null) {
/* 1063 */       this._custItemAccountActivities = new HistoricalList(null);
/*      */     }
/* 1065 */     return (List<ICustomerItemAccountActivity>)this._custItemAccountActivities;
/*      */   }
/*      */   
/*      */   public void setCustItemAccountActivities(List<ICustomerItemAccountActivity> argCustItemAccountActivities) {
/* 1069 */     if (this._custItemAccountActivities == null) {
/* 1070 */       this._custItemAccountActivities = new HistoricalList(argCustItemAccountActivities);
/*      */     } else {
/* 1072 */       this._custItemAccountActivities.setCurrentList(argCustItemAccountActivities);
/*      */     } 
/*      */     
/* 1075 */     for (ICustomerItemAccountActivity child : this._custItemAccountActivities) {
/* 1076 */       child.setParentCustItemAccountDetail(this);
/*      */     }
/*      */ 
/*      */     
/* 1080 */     for (ICustomerItemAccountActivity child : this._custItemAccountActivities) {
/* 1081 */       CustomerItemAccountActivityModel model = (CustomerItemAccountActivityModel)child;
/* 1082 */       model.setOrganizationId_noev(getOrganizationId());
/* 1083 */       model.setCustAccountId_noev(getCustAccountId());
/* 1084 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 1085 */       model.setCustAccountDetailNum_noev(getCustAccountDetailNum());
/* 1086 */       if (child instanceof IDataModelImpl) {
/* 1087 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1088 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1089 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1090 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1093 */       if (postEventsForChanges()) {
/* 1094 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerItemAccountActivity(ICustomerItemAccountActivity argCustomerItemAccountActivity) {
/* 1100 */     super.addCustomerItemAccountActivity(argCustomerItemAccountActivity);
/*      */ 
/*      */     
/* 1103 */     argCustomerItemAccountActivity.setParentCustItemAccountDetail(this);
/* 1104 */     if (this._custItemAccountActivities == null) {
/* 1105 */       this._custItemAccountActivities = new HistoricalList(null);
/*      */     }
/* 1107 */     argCustomerItemAccountActivity.setOrganizationId(getOrganizationId());
/* 1108 */     argCustomerItemAccountActivity.setCustAccountId(getCustAccountId());
/* 1109 */     argCustomerItemAccountActivity.setCustAccountCode(getCustAccountCode());
/* 1110 */     argCustomerItemAccountActivity.setCustAccountDetailNum(getCustAccountDetailNum());
/* 1111 */     if (argCustomerItemAccountActivity instanceof IDataModelImpl) {
/* 1112 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerItemAccountActivity).getDAO();
/* 1113 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1114 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1115 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1120 */     if (postEventsForChanges()) {
/* 1121 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountActivity));
/*      */     }
/*      */     
/* 1124 */     this._custItemAccountActivities.add(argCustomerItemAccountActivity);
/* 1125 */     if (postEventsForChanges()) {
/* 1126 */       this._events.post(ICustomerItemAccountDetail.ADD_CUSTITEMACCOUNTACTIVITIES, argCustomerItemAccountActivity);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerItemAccountActivity(ICustomerItemAccountActivity argCustomerItemAccountActivity) {
/* 1131 */     if (this._custItemAccountActivities != null) {
/*      */       
/* 1133 */       if (postEventsForChanges()) {
/* 1134 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountActivity));
/*      */       }
/* 1136 */       this._custItemAccountActivities.remove(argCustomerItemAccountActivity);
/*      */       
/* 1138 */       argCustomerItemAccountActivity.setParentCustItemAccountDetail(null);
/* 1139 */       if (postEventsForChanges()) {
/* 1140 */         this._events.post(ICustomerItemAccountDetail.REMOVE_CUSTITEMACCOUNTACTIVITIES, argCustomerItemAccountActivity);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "SourceLocation")
/*      */   public IRetailLocation getSourceLocation() {
/* 1147 */     return this._sourceLocation;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSourceLocation(IRetailLocation argSourceLocation) {
/* 1152 */     if (argSourceLocation == null) {
/*      */       
/* 1154 */       getDAO_().setSourceLocationId(null);
/* 1155 */       if (this._sourceLocation != null)
/*      */       {
/* 1157 */         if (postEventsForChanges()) {
/* 1158 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._sourceLocation));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1163 */       getDAO_().setSourceLocationId(Long.valueOf(argSourceLocation.getRetailLocationId()));
/*      */       
/* 1165 */       if (postEventsForChanges()) {
/* 1166 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSourceLocation));
/*      */       }
/*      */     } 
/*      */     
/* 1170 */     this._sourceLocation = argSourceLocation;
/* 1171 */     if (postEventsForChanges()) {
/* 1172 */       this._events.post(ICustomerItemAccountDetail.SET_SOURCELOCATION, argSourceLocation);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "FullfillmentLocation")
/*      */   public IRetailLocation getFullfillmentLocation() {
/* 1178 */     return this._fullfillmentLocation;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFullfillmentLocation(IRetailLocation argFullfillmentLocation) {
/* 1183 */     if (argFullfillmentLocation == null) {
/*      */       
/* 1185 */       getDAO_().setFullfillmentLocationId(null);
/* 1186 */       if (this._fullfillmentLocation != null)
/*      */       {
/* 1188 */         if (postEventsForChanges()) {
/* 1189 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._fullfillmentLocation));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1194 */       getDAO_().setFullfillmentLocationId(Long.valueOf(argFullfillmentLocation.getRetailLocationId()));
/*      */       
/* 1196 */       if (postEventsForChanges()) {
/* 1197 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFullfillmentLocation));
/*      */       }
/*      */     } 
/*      */     
/* 1201 */     this._fullfillmentLocation = argFullfillmentLocation;
/* 1202 */     if (postEventsForChanges()) {
/* 1203 */       this._events.post(ICustomerItemAccountDetail.SET_FULLFILLMENTLOCATION, argFullfillmentLocation);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ICustomerItemAccountDetailProperty> getProperties() {
/* 1209 */     if (this._properties == null) {
/* 1210 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1212 */     return (List<ICustomerItemAccountDetailProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ICustomerItemAccountDetailProperty> argProperties) {
/* 1216 */     if (this._properties == null) {
/* 1217 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1219 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1222 */     for (ICustomerItemAccountDetailProperty child : this._properties) {
/* 1223 */       CustomerItemAccountDetailPropertyModel model = (CustomerItemAccountDetailPropertyModel)child;
/* 1224 */       model.setOrganizationId_noev(getOrganizationId());
/* 1225 */       model.setCustAccountId_noev(getCustAccountId());
/* 1226 */       model.setCustAccountCode_noev(getCustAccountCode());
/* 1227 */       model.setCustAccountDetailNum_noev(getCustAccountDetailNum());
/* 1228 */       if (child instanceof IDataModelImpl) {
/* 1229 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1230 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1231 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1232 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1235 */       if (postEventsForChanges()) {
/* 1236 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerItemAccountDetailProperty(ICustomerItemAccountDetailProperty argCustomerItemAccountDetailProperty) {
/* 1242 */     if (this._properties == null) {
/* 1243 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1245 */     argCustomerItemAccountDetailProperty.setOrganizationId(getOrganizationId());
/* 1246 */     argCustomerItemAccountDetailProperty.setCustAccountId(getCustAccountId());
/* 1247 */     argCustomerItemAccountDetailProperty.setCustAccountCode(getCustAccountCode());
/* 1248 */     argCustomerItemAccountDetailProperty.setCustAccountDetailNum(getCustAccountDetailNum());
/* 1249 */     if (argCustomerItemAccountDetailProperty instanceof IDataModelImpl) {
/* 1250 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerItemAccountDetailProperty).getDAO();
/* 1251 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1252 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1253 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1258 */     if (postEventsForChanges()) {
/* 1259 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountDetailProperty));
/*      */     }
/*      */     
/* 1262 */     this._properties.add(argCustomerItemAccountDetailProperty);
/* 1263 */     if (postEventsForChanges()) {
/* 1264 */       this._events.post(ICustomerItemAccountDetail.ADD_PROPERTIES, argCustomerItemAccountDetailProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerItemAccountDetailProperty(ICustomerItemAccountDetailProperty argCustomerItemAccountDetailProperty) {
/* 1269 */     if (this._properties != null) {
/*      */       
/* 1271 */       if (postEventsForChanges()) {
/* 1272 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountDetailProperty));
/*      */       }
/* 1274 */       this._properties.remove(argCustomerItemAccountDetailProperty);
/* 1275 */       if (postEventsForChanges()) {
/* 1276 */         this._events.post(ICustomerItemAccountDetail.REMOVE_PROPERTIES, argCustomerItemAccountDetailProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentCustItemAccount(ICustomerItemAccount argParentCustItemAccount) {
/* 1282 */     this._parentCustItemAccount = argParentCustItemAccount;
/*      */   }
/*      */   
/*      */   public ICustomerItemAccount getParentCustItemAccount() {
/* 1286 */     return this._parentCustItemAccount;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1291 */     if ("RetailLineItem".equals(argFieldId)) {
/* 1292 */       return getRetailLineItem();
/*      */     }
/* 1294 */     if ("CustItemAccountActivities".equals(argFieldId)) {
/* 1295 */       return getCustItemAccountActivities();
/*      */     }
/* 1297 */     if ("SourceLocation".equals(argFieldId)) {
/* 1298 */       return getSourceLocation();
/*      */     }
/* 1300 */     if ("FullfillmentLocation".equals(argFieldId)) {
/* 1301 */       return getFullfillmentLocation();
/*      */     }
/* 1303 */     if ("Properties".equals(argFieldId)) {
/* 1304 */       return getProperties();
/*      */     }
/* 1306 */     if ("CustomerItemAccountDetailExtension".equals(argFieldId)) {
/* 1307 */       return this._myExtension;
/*      */     }
/*      */     
/* 1310 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1316 */     if ("RetailLineItem".equals(argFieldId)) {
/* 1317 */       setRetailLineItem((IRetailTransactionLineItem)argValue);
/*      */     }
/* 1319 */     else if ("CustItemAccountActivities".equals(argFieldId)) {
/* 1320 */       setCustItemAccountActivities(changeToList(argValue, ICustomerItemAccountActivity.class));
/*      */     }
/* 1322 */     else if ("SourceLocation".equals(argFieldId)) {
/* 1323 */       setSourceLocation((IRetailLocation)argValue);
/*      */     }
/* 1325 */     else if ("FullfillmentLocation".equals(argFieldId)) {
/* 1326 */       setFullfillmentLocation((IRetailLocation)argValue);
/*      */     }
/* 1328 */     else if ("Properties".equals(argFieldId)) {
/* 1329 */       setProperties(changeToList(argValue, ICustomerItemAccountDetailProperty.class));
/*      */     }
/* 1331 */     else if ("CustomerItemAccountDetailExtension".equals(argFieldId)) {
/* 1332 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1335 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1341 */     this._persistenceDefaults = argPD;
/* 1342 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1343 */     this._eventManager = argEM;
/* 1344 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1345 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1346 */     if (this._retailLineItem != null) {
/* 1347 */       ((IDataModelImpl)this._retailLineItem).setDependencies(argPD, argEM);
/*      */     }
/* 1349 */     if (this._custItemAccountActivities != null) {
/* 1350 */       for (ICustomerItemAccountActivity relationship : this._custItemAccountActivities) {
/* 1351 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1354 */     if (this._sourceLocation != null) {
/* 1355 */       ((IDataModelImpl)this._sourceLocation).setDependencies(argPD, argEM);
/*      */     }
/* 1357 */     if (this._fullfillmentLocation != null) {
/* 1358 */       ((IDataModelImpl)this._fullfillmentLocation).setDependencies(argPD, argEM);
/*      */     }
/* 1360 */     if (this._properties != null) {
/* 1361 */       for (ICustomerItemAccountDetailProperty relationship : this._properties) {
/* 1362 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getCustomerItemAccountDetailExt() {
/* 1368 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setCustomerItemAccountDetailExt(IDataModel argExt) {
/* 1372 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1377 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1381 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1384 */     super.startTransaction();
/*      */     
/* 1386 */     this._retailLineItemSavepoint = this._retailLineItem;
/* 1387 */     if (this._retailLineItem != null) {
/* 1388 */       this._retailLineItem.startTransaction();
/*      */     }
/*      */     
/* 1391 */     this._custItemAccountActivitiesSavepoint = this._custItemAccountActivities;
/* 1392 */     if (this._custItemAccountActivities != null) {
/* 1393 */       this._custItemAccountActivitiesSavepoint = new HistoricalList((List)this._custItemAccountActivities);
/* 1394 */       Iterator<IDataModel> it = this._custItemAccountActivities.iterator();
/* 1395 */       while (it.hasNext()) {
/* 1396 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1400 */     this._sourceLocationSavepoint = this._sourceLocation;
/* 1401 */     if (this._sourceLocation != null) {
/* 1402 */       this._sourceLocation.startTransaction();
/*      */     }
/*      */     
/* 1405 */     this._fullfillmentLocationSavepoint = this._fullfillmentLocation;
/* 1406 */     if (this._fullfillmentLocation != null) {
/* 1407 */       this._fullfillmentLocation.startTransaction();
/*      */     }
/*      */     
/* 1410 */     this._propertiesSavepoint = this._properties;
/* 1411 */     if (this._properties != null) {
/* 1412 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1413 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1414 */       while (it.hasNext()) {
/* 1415 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1420 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1425 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1428 */     super.rollbackChanges();
/*      */     
/* 1430 */     this._retailLineItem = this._retailLineItemSavepoint;
/* 1431 */     this._retailLineItemSavepoint = null;
/* 1432 */     if (this._retailLineItem != null) {
/* 1433 */       this._retailLineItem.rollbackChanges();
/*      */     }
/*      */     
/* 1436 */     this._custItemAccountActivities = this._custItemAccountActivitiesSavepoint;
/* 1437 */     this._custItemAccountActivitiesSavepoint = null;
/* 1438 */     if (this._custItemAccountActivities != null) {
/* 1439 */       Iterator<IDataModel> it = this._custItemAccountActivities.iterator();
/* 1440 */       while (it.hasNext()) {
/* 1441 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1445 */     this._sourceLocation = this._sourceLocationSavepoint;
/* 1446 */     this._sourceLocationSavepoint = null;
/* 1447 */     if (this._sourceLocation != null) {
/* 1448 */       this._sourceLocation.rollbackChanges();
/*      */     }
/*      */     
/* 1451 */     this._fullfillmentLocation = this._fullfillmentLocationSavepoint;
/* 1452 */     this._fullfillmentLocationSavepoint = null;
/* 1453 */     if (this._fullfillmentLocation != null) {
/* 1454 */       this._fullfillmentLocation.rollbackChanges();
/*      */     }
/*      */     
/* 1457 */     this._properties = this._propertiesSavepoint;
/* 1458 */     this._propertiesSavepoint = null;
/* 1459 */     if (this._properties != null) {
/* 1460 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1461 */       while (it.hasNext()) {
/* 1462 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1470 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1473 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1476 */     super.commitTransaction();
/*      */     
/* 1478 */     this._retailLineItemSavepoint = this._retailLineItem;
/* 1479 */     if (this._retailLineItem != null) {
/* 1480 */       this._retailLineItem.commitTransaction();
/*      */     }
/*      */     
/* 1483 */     this._custItemAccountActivitiesSavepoint = this._custItemAccountActivities;
/* 1484 */     if (this._custItemAccountActivities != null) {
/* 1485 */       Iterator<IDataModel> it = this._custItemAccountActivities.iterator();
/* 1486 */       while (it.hasNext()) {
/* 1487 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1489 */       this._custItemAccountActivities = new HistoricalList((List)this._custItemAccountActivities);
/*      */     } 
/*      */     
/* 1492 */     this._sourceLocationSavepoint = this._sourceLocation;
/* 1493 */     if (this._sourceLocation != null) {
/* 1494 */       this._sourceLocation.commitTransaction();
/*      */     }
/*      */     
/* 1497 */     this._fullfillmentLocationSavepoint = this._fullfillmentLocation;
/* 1498 */     if (this._fullfillmentLocation != null) {
/* 1499 */       this._fullfillmentLocation.commitTransaction();
/*      */     }
/*      */     
/* 1502 */     this._propertiesSavepoint = this._properties;
/* 1503 */     if (this._properties != null) {
/* 1504 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1505 */       while (it.hasNext()) {
/* 1506 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1508 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1512 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */