/*      */ package dtv.xst.dao.cat.impl;
/*      */ 
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventHandler;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.cat.CustomerItemAccountActivityPropertyId;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccountActivity;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccountActivityProperty;
/*      */ import dtv.xst.dao.cat.ICustomerItemAccountDetail;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class CustomerItemAccountActivityModel extends CustomerItemAccountActivityBaseModel implements ICustomerItemAccountActivity {
/*      */   private static final long serialVersionUID = 570978283L;
/*      */   private ICustomerItemAccountDetail _parentCustItemAccountDetail;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICustomerItemAccountActivityProperty> _properties; private transient HistoricalList<ICustomerItemAccountActivityProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new CustomerItemAccountActivityDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CustomerItemAccountActivityDAO getDAO_() {
/*   49 */     return (CustomerItemAccountActivityDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   57 */     if (getDAO_().getOrganizationId() != null) {
/*   58 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   61 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   71 */       this._events != null && 
/*   72 */       postEventsForChanges()) {
/*   73 */       this._events.post(ICustomerItemAccountActivity.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   80 */     boolean ev_postable = false;
/*      */     
/*   82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   85 */       ev_postable = true;
/*   86 */       if (this._properties != null) {
/*      */         
/*   88 */         Iterator<CustomerItemAccountActivityPropertyModel> it = this._properties.iterator();
/*   89 */         while (it.hasNext())
/*      */         {
/*   91 */           ((CustomerItemAccountActivityPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   96 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountId() {
/*  104 */     return getDAO_().getCustAccountId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountId(String argCustAccountId) {
/*  112 */     if (setCustAccountId_noev(argCustAccountId) && 
/*  113 */       this._events != null && 
/*  114 */       postEventsForChanges()) {
/*  115 */       this._events.post(ICustomerItemAccountActivity.SET_CUSTACCOUNTID, argCustAccountId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountId_noev(String argCustAccountId) {
/*  122 */     boolean ev_postable = false;
/*      */     
/*  124 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/*  125 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/*  126 */       getDAO_().setCustAccountId(argCustAccountId);
/*  127 */       ev_postable = true;
/*  128 */       if (this._properties != null) {
/*      */         
/*  130 */         Iterator<CustomerItemAccountActivityPropertyModel> it = this._properties.iterator();
/*  131 */         while (it.hasNext())
/*      */         {
/*  133 */           ((CustomerItemAccountActivityPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  138 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountCode() {
/*  146 */     return getDAO_().getCustAccountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountCode(String argCustAccountCode) {
/*  154 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/*  155 */       this._events != null && 
/*  156 */       postEventsForChanges()) {
/*  157 */       this._events.post(ICustomerItemAccountActivity.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/*  164 */     boolean ev_postable = false;
/*      */     
/*  166 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/*  167 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/*  168 */       getDAO_().setCustAccountCode(argCustAccountCode);
/*  169 */       ev_postable = true;
/*  170 */       if (this._properties != null) {
/*      */         
/*  172 */         Iterator<CustomerItemAccountActivityPropertyModel> it = this._properties.iterator();
/*  173 */         while (it.hasNext())
/*      */         {
/*  175 */           ((CustomerItemAccountActivityPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  180 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCustAccountDetailNum() {
/*  188 */     if (getDAO_().getCustAccountDetailNum() != null) {
/*  189 */       return getDAO_().getCustAccountDetailNum().longValue();
/*      */     }
/*      */     
/*  192 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountDetailNum(long argCustAccountDetailNum) {
/*  201 */     if (setCustAccountDetailNum_noev(argCustAccountDetailNum) && 
/*  202 */       this._events != null && 
/*  203 */       postEventsForChanges()) {
/*  204 */       this._events.post(ICustomerItemAccountActivity.SET_CUSTACCOUNTDETAILNUM, Long.valueOf(argCustAccountDetailNum));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountDetailNum_noev(long argCustAccountDetailNum) {
/*  211 */     boolean ev_postable = false;
/*      */     
/*  213 */     if ((getDAO_().getCustAccountDetailNum() == null && Long.valueOf(argCustAccountDetailNum) != null) || (
/*  214 */       getDAO_().getCustAccountDetailNum() != null && !getDAO_().getCustAccountDetailNum().equals(Long.valueOf(argCustAccountDetailNum)))) {
/*  215 */       getDAO_().setCustAccountDetailNum(Long.valueOf(argCustAccountDetailNum));
/*  216 */       ev_postable = true;
/*  217 */       if (this._properties != null) {
/*      */         
/*  219 */         Iterator<CustomerItemAccountActivityPropertyModel> it = this._properties.iterator();
/*  220 */         while (it.hasNext())
/*      */         {
/*  222 */           ((CustomerItemAccountActivityPropertyModel)it.next()).setCustAccountDetailNum_noev(argCustAccountDetailNum);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  227 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getSequenceNumber() {
/*  235 */     if (getDAO_().getSequenceNumber() != null) {
/*  236 */       return getDAO_().getSequenceNumber().longValue();
/*      */     }
/*      */     
/*  239 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequenceNumber(long argSequenceNumber) {
/*  248 */     if (setSequenceNumber_noev(argSequenceNumber) && 
/*  249 */       this._events != null && 
/*  250 */       postEventsForChanges()) {
/*  251 */       this._events.post(ICustomerItemAccountActivity.SET_SEQUENCENUMBER, Long.valueOf(argSequenceNumber));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSequenceNumber_noev(long argSequenceNumber) {
/*  258 */     boolean ev_postable = false;
/*      */     
/*  260 */     if ((getDAO_().getSequenceNumber() == null && Long.valueOf(argSequenceNumber) != null) || (
/*  261 */       getDAO_().getSequenceNumber() != null && !getDAO_().getSequenceNumber().equals(Long.valueOf(argSequenceNumber)))) {
/*  262 */       getDAO_().setSequenceNumber(Long.valueOf(argSequenceNumber));
/*  263 */       ev_postable = true;
/*  264 */       if (this._properties != null) {
/*      */         
/*  266 */         Iterator<CustomerItemAccountActivityPropertyModel> it = this._properties.iterator();
/*  267 */         while (it.hasNext())
/*      */         {
/*  269 */           ((CustomerItemAccountActivityPropertyModel)it.next()).setSequenceNumber_noev(argSequenceNumber);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  274 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  282 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  290 */     if (setCreateDate_noev(argCreateDate) && 
/*  291 */       this._events != null && 
/*  292 */       postEventsForChanges()) {
/*  293 */       this._events.post(ICustomerItemAccountActivity.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  300 */     boolean ev_postable = false;
/*      */     
/*  302 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  303 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  304 */       getDAO_().setCreateDate(argCreateDate);
/*  305 */       ev_postable = true;
/*      */     } 
/*      */     
/*  308 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  316 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  324 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  325 */       this._events != null && 
/*  326 */       postEventsForChanges()) {
/*  327 */       this._events.post(ICustomerItemAccountActivity.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  334 */     boolean ev_postable = false;
/*      */     
/*  336 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  337 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  338 */       getDAO_().setCreateUserId(argCreateUserId);
/*  339 */       ev_postable = true;
/*      */     } 
/*      */     
/*  342 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  350 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  358 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  359 */       this._events != null && 
/*  360 */       postEventsForChanges()) {
/*  361 */       this._events.post(ICustomerItemAccountActivity.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  368 */     boolean ev_postable = false;
/*      */     
/*  370 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  371 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  372 */       getDAO_().setUpdateDate(argUpdateDate);
/*  373 */       ev_postable = true;
/*      */     } 
/*      */     
/*  376 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  384 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  392 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  393 */       this._events != null && 
/*  394 */       postEventsForChanges()) {
/*  395 */       this._events.post(ICustomerItemAccountActivity.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  402 */     boolean ev_postable = false;
/*      */     
/*  404 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  405 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  406 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  407 */       ev_postable = true;
/*      */     } 
/*      */     
/*  410 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExtendedAmount() {
/*  418 */     return getDAO_().getExtendedAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/*  426 */     if (setExtendedAmount_noev(argExtendedAmount) && 
/*  427 */       this._events != null && 
/*  428 */       postEventsForChanges()) {
/*  429 */       this._events.post(ICustomerItemAccountActivity.SET_EXTENDEDAMOUNT, argExtendedAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtendedAmount_noev(BigDecimal argExtendedAmount) {
/*  436 */     boolean ev_postable = false;
/*      */     
/*  438 */     if ((getDAO_().getExtendedAmount() == null && argExtendedAmount != null) || (
/*  439 */       getDAO_().getExtendedAmount() != null && !getDAO_().getExtendedAmount().equals(argExtendedAmount))) {
/*  440 */       getDAO_().setExtendedAmount(argExtendedAmount);
/*  441 */       ev_postable = true;
/*      */     } 
/*      */     
/*  444 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getActivityDateTime() {
/*  452 */     return getDAO_().getActivityDateTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivityDateTime(Date argActivityDateTime) {
/*  460 */     if (setActivityDateTime_noev(argActivityDateTime) && 
/*  461 */       this._events != null && 
/*  462 */       postEventsForChanges()) {
/*  463 */       this._events.post(ICustomerItemAccountActivity.SET_ACTIVITYDATETIME, argActivityDateTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActivityDateTime_noev(Date argActivityDateTime) {
/*  470 */     boolean ev_postable = false;
/*      */     
/*  472 */     if ((getDAO_().getActivityDateTime() == null && argActivityDateTime != null) || (
/*  473 */       getDAO_().getActivityDateTime() != null && !getDAO_().getActivityDateTime().equals(argActivityDateTime))) {
/*  474 */       getDAO_().setActivityDateTime(argActivityDateTime);
/*  475 */       ev_postable = true;
/*      */     } 
/*      */     
/*  478 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getActivityCode() {
/*  486 */     return getDAO_().getActivityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivityCode(String argActivityCode) {
/*  494 */     if (setActivityCode_noev(argActivityCode) && 
/*  495 */       this._events != null && 
/*  496 */       postEventsForChanges()) {
/*  497 */       this._events.post(ICustomerItemAccountActivity.SET_ACTIVITYCODE, argActivityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActivityCode_noev(String argActivityCode) {
/*  504 */     boolean ev_postable = false;
/*      */     
/*  506 */     if ((getDAO_().getActivityCode() == null && argActivityCode != null) || (
/*  507 */       getDAO_().getActivityCode() != null && !getDAO_().getActivityCode().equals(argActivityCode))) {
/*  508 */       getDAO_().setActivityCode(argActivityCode);
/*  509 */       ev_postable = true;
/*      */     } 
/*      */     
/*  512 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountLineItemStateCode() {
/*  520 */     return getDAO_().getAccountLineItemStateCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountLineItemStateCode(String argAccountLineItemStateCode) {
/*  528 */     if (setAccountLineItemStateCode_noev(argAccountLineItemStateCode) && 
/*  529 */       this._events != null && 
/*  530 */       postEventsForChanges()) {
/*  531 */       this._events.post(ICustomerItemAccountActivity.SET_ACCOUNTLINEITEMSTATECODE, argAccountLineItemStateCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountLineItemStateCode_noev(String argAccountLineItemStateCode) {
/*  538 */     boolean ev_postable = false;
/*      */     
/*  540 */     if ((getDAO_().getAccountLineItemStateCode() == null && argAccountLineItemStateCode != null) || (
/*  541 */       getDAO_().getAccountLineItemStateCode() != null && !getDAO_().getAccountLineItemStateCode().equals(argAccountLineItemStateCode))) {
/*  542 */       getDAO_().setAccountLineItemStateCode(argAccountLineItemStateCode);
/*  543 */       ev_postable = true;
/*      */     } 
/*      */     
/*  546 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTypeCode() {
/*  554 */     return getDAO_().getTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeCode(String argTypeCode) {
/*  562 */     if (setTypeCode_noev(argTypeCode) && 
/*  563 */       this._events != null && 
/*  564 */       postEventsForChanges()) {
/*  565 */       this._events.post(ICustomerItemAccountActivity.SET_TYPECODE, argTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTypeCode_noev(String argTypeCode) {
/*  572 */     boolean ev_postable = false;
/*      */     
/*  574 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/*  575 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/*  576 */       getDAO_().setTypeCode(argTypeCode);
/*  577 */       ev_postable = true;
/*      */     } 
/*      */     
/*  580 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  588 */     if (getDAO_().getRetailLocationId() != null) {
/*  589 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  592 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  601 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  602 */       this._events != null && 
/*  603 */       postEventsForChanges()) {
/*  604 */       this._events.post(ICustomerItemAccountActivity.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  611 */     boolean ev_postable = false;
/*      */     
/*  613 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  614 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  615 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  616 */       ev_postable = true;
/*      */     } 
/*      */     
/*  619 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  627 */     if (getDAO_().getWorkstationId() != null) {
/*  628 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  631 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  640 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  641 */       this._events != null && 
/*  642 */       postEventsForChanges()) {
/*  643 */       this._events.post(ICustomerItemAccountActivity.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  650 */     boolean ev_postable = false;
/*      */     
/*  652 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  653 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  654 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  655 */       ev_postable = true;
/*      */     } 
/*      */     
/*  658 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  666 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  674 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  675 */       this._events != null && 
/*  676 */       postEventsForChanges()) {
/*  677 */       this._events.post(ICustomerItemAccountActivity.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  684 */     boolean ev_postable = false;
/*      */     
/*  686 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  687 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  688 */       getDAO_().setBusinessDate(argBusinessDate);
/*  689 */       ev_postable = true;
/*      */     } 
/*      */     
/*  692 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransSequence() {
/*  700 */     if (getDAO_().getTransSequence() != null) {
/*  701 */       return getDAO_().getTransSequence().longValue();
/*      */     }
/*      */     
/*  704 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransSequence(long argTransSequence) {
/*  713 */     if (setTransSequence_noev(argTransSequence) && 
/*  714 */       this._events != null && 
/*  715 */       postEventsForChanges()) {
/*  716 */       this._events.post(ICustomerItemAccountActivity.SET_TRANSSEQUENCE, Long.valueOf(argTransSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransSequence_noev(long argTransSequence) {
/*  723 */     boolean ev_postable = false;
/*      */     
/*  725 */     if ((getDAO_().getTransSequence() == null && Long.valueOf(argTransSequence) != null) || (
/*  726 */       getDAO_().getTransSequence() != null && !getDAO_().getTransSequence().equals(Long.valueOf(argTransSequence)))) {
/*  727 */       getDAO_().setTransSequence(Long.valueOf(argTransSequence));
/*  728 */       ev_postable = true;
/*      */     } 
/*      */     
/*  731 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransLineItemSeq() {
/*  739 */     if (getDAO_().getTransLineItemSeq() != null) {
/*  740 */       return getDAO_().getTransLineItemSeq().longValue();
/*      */     }
/*      */     
/*  743 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransLineItemSeq(long argTransLineItemSeq) {
/*  752 */     if (setTransLineItemSeq_noev(argTransLineItemSeq) && 
/*  753 */       this._events != null && 
/*  754 */       postEventsForChanges()) {
/*  755 */       this._events.post(ICustomerItemAccountActivity.SET_TRANSLINEITEMSEQ, Long.valueOf(argTransLineItemSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransLineItemSeq_noev(long argTransLineItemSeq) {
/*  762 */     boolean ev_postable = false;
/*      */     
/*  764 */     if ((getDAO_().getTransLineItemSeq() == null && Long.valueOf(argTransLineItemSeq) != null) || (
/*  765 */       getDAO_().getTransLineItemSeq() != null && !getDAO_().getTransLineItemSeq().equals(Long.valueOf(argTransLineItemSeq)))) {
/*  766 */       getDAO_().setTransLineItemSeq(Long.valueOf(argTransLineItemSeq));
/*  767 */       ev_postable = true;
/*      */     } 
/*      */     
/*  770 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getNetAmount() {
/*  778 */     return getDAO_().getNetAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNetAmount(BigDecimal argNetAmount) {
/*  786 */     if (setNetAmount_noev(argNetAmount) && 
/*  787 */       this._events != null && 
/*  788 */       postEventsForChanges()) {
/*  789 */       this._events.post(ICustomerItemAccountActivity.SET_NETAMOUNT, argNetAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNetAmount_noev(BigDecimal argNetAmount) {
/*  796 */     boolean ev_postable = false;
/*      */     
/*  798 */     if ((getDAO_().getNetAmount() == null && argNetAmount != null) || (
/*  799 */       getDAO_().getNetAmount() != null && !getDAO_().getNetAmount().equals(argNetAmount))) {
/*  800 */       getDAO_().setNetAmount(argNetAmount);
/*  801 */       ev_postable = true;
/*      */     } 
/*      */     
/*  804 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnitPrice() {
/*  812 */     return getDAO_().getUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitPrice(BigDecimal argUnitPrice) {
/*  820 */     if (setUnitPrice_noev(argUnitPrice) && 
/*  821 */       this._events != null && 
/*  822 */       postEventsForChanges()) {
/*  823 */       this._events.post(ICustomerItemAccountActivity.SET_UNITPRICE, argUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitPrice_noev(BigDecimal argUnitPrice) {
/*  830 */     boolean ev_postable = false;
/*      */     
/*  832 */     if ((getDAO_().getUnitPrice() == null && argUnitPrice != null) || (
/*  833 */       getDAO_().getUnitPrice() != null && !getDAO_().getUnitPrice().equals(argUnitPrice))) {
/*  834 */       getDAO_().setUnitPrice(argUnitPrice);
/*  835 */       ev_postable = true;
/*      */     } 
/*      */     
/*  838 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getQuantity() {
/*  846 */     return getDAO_().getQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(BigDecimal argQuantity) {
/*  854 */     if (setQuantity_noev(argQuantity) && 
/*  855 */       this._events != null && 
/*  856 */       postEventsForChanges()) {
/*  857 */       this._events.post(ICustomerItemAccountActivity.SET_QUANTITY, argQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/*  864 */     boolean ev_postable = false;
/*      */     
/*  866 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/*  867 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/*  868 */       getDAO_().setQuantity(argQuantity);
/*  869 */       ev_postable = true;
/*      */     } 
/*      */     
/*  872 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getScheduledPickupDate() {
/*  880 */     return getDAO_().getScheduledPickupDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setScheduledPickupDate(Date argScheduledPickupDate) {
/*  888 */     if (setScheduledPickupDate_noev(argScheduledPickupDate) && 
/*  889 */       this._events != null && 
/*  890 */       postEventsForChanges()) {
/*  891 */       this._events.post(ICustomerItemAccountActivity.SET_SCHEDULEDPICKUPDATE, argScheduledPickupDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setScheduledPickupDate_noev(Date argScheduledPickupDate) {
/*  898 */     boolean ev_postable = false;
/*      */     
/*  900 */     if ((getDAO_().getScheduledPickupDate() == null && argScheduledPickupDate != null) || (
/*  901 */       getDAO_().getScheduledPickupDate() != null && !getDAO_().getScheduledPickupDate().equals(argScheduledPickupDate))) {
/*  902 */       getDAO_().setScheduledPickupDate(argScheduledPickupDate);
/*  903 */       ev_postable = true;
/*      */     } 
/*      */     
/*  906 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ICustomerItemAccountActivityProperty newProperty(String argPropertyName) {
/*  910 */     CustomerItemAccountActivityPropertyId id = new CustomerItemAccountActivityPropertyId();
/*      */     
/*  912 */     id.setCustAccountId(getCustAccountId());
/*  913 */     id.setCustAccountCode(getCustAccountCode());
/*  914 */     id.setCustAccountDetailNum(Long.valueOf(getCustAccountDetailNum()));
/*  915 */     id.setSequenceNumber(Long.valueOf(getSequenceNumber()));
/*  916 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  918 */     ICustomerItemAccountActivityProperty prop = (ICustomerItemAccountActivityProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICustomerItemAccountActivityProperty.class);
/*  919 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ICustomerItemAccountActivityProperty> getProperties() {
/*  928 */     if (this._properties == null) {
/*  929 */       this._properties = new HistoricalList(null);
/*      */     }
/*  931 */     return (List<ICustomerItemAccountActivityProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ICustomerItemAccountActivityProperty> argProperties) {
/*  935 */     if (this._properties == null) {
/*  936 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  938 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  941 */     for (ICustomerItemAccountActivityProperty child : this._properties) {
/*  942 */       CustomerItemAccountActivityPropertyModel model = (CustomerItemAccountActivityPropertyModel)child;
/*  943 */       model.setOrganizationId_noev(getOrganizationId());
/*  944 */       model.setCustAccountId_noev(getCustAccountId());
/*  945 */       model.setCustAccountCode_noev(getCustAccountCode());
/*  946 */       model.setCustAccountDetailNum_noev(getCustAccountDetailNum());
/*  947 */       model.setSequenceNumber_noev(getSequenceNumber());
/*  948 */       if (child instanceof IDataModelImpl) {
/*  949 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  950 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  951 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  952 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  955 */       if (postEventsForChanges()) {
/*  956 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCustomerItemAccountActivityProperty(ICustomerItemAccountActivityProperty argCustomerItemAccountActivityProperty) {
/*  962 */     if (this._properties == null) {
/*  963 */       this._properties = new HistoricalList(null);
/*      */     }
/*  965 */     argCustomerItemAccountActivityProperty.setOrganizationId(getOrganizationId());
/*  966 */     argCustomerItemAccountActivityProperty.setCustAccountId(getCustAccountId());
/*  967 */     argCustomerItemAccountActivityProperty.setCustAccountCode(getCustAccountCode());
/*  968 */     argCustomerItemAccountActivityProperty.setCustAccountDetailNum(getCustAccountDetailNum());
/*  969 */     argCustomerItemAccountActivityProperty.setSequenceNumber(getSequenceNumber());
/*  970 */     if (argCustomerItemAccountActivityProperty instanceof IDataModelImpl) {
/*  971 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomerItemAccountActivityProperty).getDAO();
/*  972 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  973 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  974 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  979 */     if (postEventsForChanges()) {
/*  980 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountActivityProperty));
/*      */     }
/*      */     
/*  983 */     this._properties.add(argCustomerItemAccountActivityProperty);
/*  984 */     if (postEventsForChanges()) {
/*  985 */       this._events.post(ICustomerItemAccountActivity.ADD_PROPERTIES, argCustomerItemAccountActivityProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomerItemAccountActivityProperty(ICustomerItemAccountActivityProperty argCustomerItemAccountActivityProperty) {
/*  990 */     if (this._properties != null) {
/*      */       
/*  992 */       if (postEventsForChanges()) {
/*  993 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerItemAccountActivityProperty));
/*      */       }
/*  995 */       this._properties.remove(argCustomerItemAccountActivityProperty);
/*  996 */       if (postEventsForChanges()) {
/*  997 */         this._events.post(ICustomerItemAccountActivity.REMOVE_PROPERTIES, argCustomerItemAccountActivityProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentCustItemAccountDetail(ICustomerItemAccountDetail argParentCustItemAccountDetail) {
/* 1003 */     this._parentCustItemAccountDetail = argParentCustItemAccountDetail;
/*      */   }
/*      */   
/*      */   public ICustomerItemAccountDetail getParentCustItemAccountDetail() {
/* 1007 */     return this._parentCustItemAccountDetail;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1012 */     if ("Properties".equals(argFieldId)) {
/* 1013 */       return getProperties();
/*      */     }
/* 1015 */     if ("CustomerItemAccountActivityExtension".equals(argFieldId)) {
/* 1016 */       return this._myExtension;
/*      */     }
/*      */     
/* 1019 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1025 */     if ("Properties".equals(argFieldId)) {
/* 1026 */       setProperties(changeToList(argValue, ICustomerItemAccountActivityProperty.class));
/*      */     }
/* 1028 */     else if ("CustomerItemAccountActivityExtension".equals(argFieldId)) {
/* 1029 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1032 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1038 */     this._persistenceDefaults = argPD;
/* 1039 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1040 */     this._eventManager = argEM;
/* 1041 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1042 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1043 */     if (this._properties != null) {
/* 1044 */       for (ICustomerItemAccountActivityProperty relationship : this._properties) {
/* 1045 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getCustomerItemAccountActivityExt() {
/* 1051 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setCustomerItemAccountActivityExt(IDataModel argExt) {
/* 1055 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1060 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1064 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1067 */     super.startTransaction();
/*      */     
/* 1069 */     this._propertiesSavepoint = this._properties;
/* 1070 */     if (this._properties != null) {
/* 1071 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1072 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1073 */       while (it.hasNext()) {
/* 1074 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1079 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1084 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1087 */     super.rollbackChanges();
/*      */     
/* 1089 */     this._properties = this._propertiesSavepoint;
/* 1090 */     this._propertiesSavepoint = null;
/* 1091 */     if (this._properties != null) {
/* 1092 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1093 */       while (it.hasNext()) {
/* 1094 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1102 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1105 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1108 */     super.commitTransaction();
/*      */     
/* 1110 */     this._propertiesSavepoint = this._properties;
/* 1111 */     if (this._properties != null) {
/* 1112 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1113 */       while (it.hasNext()) {
/* 1114 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1116 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1120 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountActivityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */