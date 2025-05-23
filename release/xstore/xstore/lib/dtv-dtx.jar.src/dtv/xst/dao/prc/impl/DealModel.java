/*      */ package dtv.xst.dao.prc.impl;
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
/*      */ import dtv.xst.dao.prc.DealPropertyId;
/*      */ import dtv.xst.dao.prc.IDeal;
/*      */ import dtv.xst.dao.prc.IDealCustomerGroups;
/*      */ import dtv.xst.dao.prc.IDealItemAction;
/*      */ import dtv.xst.dao.prc.IDealProperty;
/*      */ import dtv.xst.dao.prc.IDealTrigger;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class DealModel extends AbstractDataModelWithPropertyImpl<IDealProperty> implements IDeal {
/*      */   private static final long serialVersionUID = 2125964L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IDealItemAction> _items;
/*      */   private transient HistoricalList<IDealItemAction> _itemsSavepoint;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<IDealCustomerGroups> _customerGroups; private transient HistoricalList<IDealCustomerGroups> _customerGroupsSavepoint; private HistoricalList<IDealTrigger> _triggers; private transient HistoricalList<IDealTrigger> _triggersSavepoint; private HistoricalList<IDealProperty> _properties; private transient HistoricalList<IDealProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new DealDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DealDAO getDAO_() {
/*   46 */     return (DealDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   54 */     if (getDAO_().getOrganizationId() != null) {
/*   55 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   58 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   68 */       this._events != null && 
/*   69 */       postEventsForChanges()) {
/*   70 */       this._events.post(IDeal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   77 */     boolean ev_postable = false;
/*      */     
/*   79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   82 */       ev_postable = true;
/*   83 */       if (this._items != null) {
/*      */         
/*   85 */         Iterator<DealItemActionModel> it = this._items.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((DealItemActionModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   91 */       if (this._customerGroups != null) {
/*      */         
/*   93 */         Iterator<DealCustomerGroupsModel> it = this._customerGroups.iterator();
/*   94 */         while (it.hasNext())
/*      */         {
/*   96 */           ((DealCustomerGroupsModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   99 */       if (this._triggers != null) {
/*      */         
/*  101 */         Iterator<DealTriggerModel> it = this._triggers.iterator();
/*  102 */         while (it.hasNext())
/*      */         {
/*  104 */           ((DealTriggerModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  107 */       if (this._properties != null) {
/*      */         
/*  109 */         Iterator<DealPropertyModel> it = this._properties.iterator();
/*  110 */         while (it.hasNext())
/*      */         {
/*  112 */           ((DealPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  117 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDealId() {
/*  125 */     return getDAO_().getDealId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDealId(String argDealId) {
/*  133 */     if (setDealId_noev(argDealId) && 
/*  134 */       this._events != null && 
/*  135 */       postEventsForChanges()) {
/*  136 */       this._events.post(IDeal.SET_DEALID, argDealId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDealId_noev(String argDealId) {
/*  143 */     boolean ev_postable = false;
/*      */     
/*  145 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/*  146 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/*  147 */       getDAO_().setDealId(argDealId);
/*  148 */       ev_postable = true;
/*  149 */       if (this._items != null) {
/*      */         
/*  151 */         Iterator<DealItemActionModel> it = this._items.iterator();
/*  152 */         while (it.hasNext())
/*      */         {
/*  154 */           ((DealItemActionModel)it.next()).setDealId_noev(argDealId);
/*      */         }
/*      */       } 
/*  157 */       if (this._customerGroups != null) {
/*      */         
/*  159 */         Iterator<DealCustomerGroupsModel> it = this._customerGroups.iterator();
/*  160 */         while (it.hasNext())
/*      */         {
/*  162 */           ((DealCustomerGroupsModel)it.next()).setDealId_noev(argDealId);
/*      */         }
/*      */       } 
/*  165 */       if (this._triggers != null) {
/*      */         
/*  167 */         Iterator<DealTriggerModel> it = this._triggers.iterator();
/*  168 */         while (it.hasNext())
/*      */         {
/*  170 */           ((DealTriggerModel)it.next()).setDealId_noev(argDealId);
/*      */         }
/*      */       } 
/*  173 */       if (this._properties != null) {
/*      */         
/*  175 */         Iterator<DealPropertyModel> it = this._properties.iterator();
/*  176 */         while (it.hasNext())
/*      */         {
/*  178 */           ((DealPropertyModel)it.next()).setDealId_noev(argDealId);
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
/*      */   public String getOrgCode() {
/*  191 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  199 */     if (setOrgCode_noev(argOrgCode) && 
/*  200 */       this._events != null && 
/*  201 */       postEventsForChanges()) {
/*  202 */       this._events.post(IDeal.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  209 */     boolean ev_postable = false;
/*      */     
/*  211 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  212 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  213 */       getDAO_().setOrgCode(argOrgCode);
/*  214 */       ev_postable = true;
/*      */     } 
/*      */     
/*  217 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  225 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  233 */     if (setOrgValue_noev(argOrgValue) && 
/*  234 */       this._events != null && 
/*  235 */       postEventsForChanges()) {
/*  236 */       this._events.post(IDeal.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  243 */     boolean ev_postable = false;
/*      */     
/*  245 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  246 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  247 */       getDAO_().setOrgValue(argOrgValue);
/*  248 */       ev_postable = true;
/*      */     } 
/*      */     
/*  251 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  259 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  267 */     if (setCreateDate_noev(argCreateDate) && 
/*  268 */       this._events != null && 
/*  269 */       postEventsForChanges()) {
/*  270 */       this._events.post(IDeal.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  277 */     boolean ev_postable = false;
/*      */     
/*  279 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  280 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  281 */       getDAO_().setCreateDate(argCreateDate);
/*  282 */       ev_postable = true;
/*      */     } 
/*      */     
/*  285 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  293 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  301 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  302 */       this._events != null && 
/*  303 */       postEventsForChanges()) {
/*  304 */       this._events.post(IDeal.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  311 */     boolean ev_postable = false;
/*      */     
/*  313 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  314 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  315 */       getDAO_().setCreateUserId(argCreateUserId);
/*  316 */       ev_postable = true;
/*      */     } 
/*      */     
/*  319 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  327 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  335 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  336 */       this._events != null && 
/*  337 */       postEventsForChanges()) {
/*  338 */       this._events.post(IDeal.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  345 */     boolean ev_postable = false;
/*      */     
/*  347 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  348 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  349 */       getDAO_().setUpdateDate(argUpdateDate);
/*  350 */       ev_postable = true;
/*      */     } 
/*      */     
/*  353 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  361 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  369 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  370 */       this._events != null && 
/*  371 */       postEventsForChanges()) {
/*  372 */       this._events.post(IDeal.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  379 */     boolean ev_postable = false;
/*      */     
/*  381 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  382 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  383 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  384 */       ev_postable = true;
/*      */     } 
/*      */     
/*  387 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  395 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  403 */     if (setDescription_noev(argDescription) && 
/*  404 */       this._events != null && 
/*  405 */       postEventsForChanges()) {
/*  406 */       this._events.post(IDeal.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  413 */     boolean ev_postable = false;
/*      */     
/*  415 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  416 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  417 */       getDAO_().setDescription(argDescription);
/*  418 */       ev_postable = true;
/*      */     } 
/*      */     
/*  421 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getConsumable() {
/*  429 */     if (getDAO_().getConsumable() != null) {
/*  430 */       return getDAO_().getConsumable().booleanValue();
/*      */     }
/*      */     
/*  433 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConsumable(boolean argConsumable) {
/*  442 */     if (setConsumable_noev(argConsumable) && 
/*  443 */       this._events != null && 
/*  444 */       postEventsForChanges()) {
/*  445 */       this._events.post(IDeal.SET_CONSUMABLE, Boolean.valueOf(argConsumable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setConsumable_noev(boolean argConsumable) {
/*  452 */     boolean ev_postable = false;
/*      */     
/*  454 */     if ((getDAO_().getConsumable() == null && Boolean.valueOf(argConsumable) != null) || (
/*  455 */       getDAO_().getConsumable() != null && !getDAO_().getConsumable().equals(Boolean.valueOf(argConsumable)))) {
/*  456 */       getDAO_().setConsumable(Boolean.valueOf(argConsumable));
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
/*      */   public boolean getDeferred() {
/*  468 */     if (getDAO_().getDeferred() != null) {
/*  469 */       return getDAO_().getDeferred().booleanValue();
/*      */     }
/*      */     
/*  472 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeferred(boolean argDeferred) {
/*  481 */     if (setDeferred_noev(argDeferred) && 
/*  482 */       this._events != null && 
/*  483 */       postEventsForChanges()) {
/*  484 */       this._events.post(IDeal.SET_DEFERRED, Boolean.valueOf(argDeferred));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDeferred_noev(boolean argDeferred) {
/*  491 */     boolean ev_postable = false;
/*      */     
/*  493 */     if ((getDAO_().getDeferred() == null && Boolean.valueOf(argDeferred) != null) || (
/*  494 */       getDAO_().getDeferred() != null && !getDAO_().getDeferred().equals(Boolean.valueOf(argDeferred)))) {
/*  495 */       getDAO_().setDeferred(Boolean.valueOf(argDeferred));
/*  496 */       ev_postable = true;
/*      */     } 
/*      */     
/*  499 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEffectiveDate() {
/*  507 */     return getDAO_().getEffectiveDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEffectiveDate(Date argEffectiveDate) {
/*  515 */     if (setEffectiveDate_noev(argEffectiveDate) && 
/*  516 */       this._events != null && 
/*  517 */       postEventsForChanges()) {
/*  518 */       this._events.post(IDeal.SET_EFFECTIVEDATE, argEffectiveDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEffectiveDate_noev(Date argEffectiveDate) {
/*  525 */     boolean ev_postable = false;
/*      */     
/*  527 */     if ((getDAO_().getEffectiveDate() == null && argEffectiveDate != null) || (
/*  528 */       getDAO_().getEffectiveDate() != null && !getDAO_().getEffectiveDate().equals(argEffectiveDate))) {
/*  529 */       getDAO_().setEffectiveDate(argEffectiveDate);
/*  530 */       ev_postable = true;
/*      */     } 
/*      */     
/*  533 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndDate() {
/*  541 */     return getDAO_().getEndDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDate(Date argEndDate) {
/*  549 */     if (setEndDate_noev(argEndDate) && 
/*  550 */       this._events != null && 
/*  551 */       postEventsForChanges()) {
/*  552 */       this._events.post(IDeal.SET_ENDDATE, argEndDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDate_noev(Date argEndDate) {
/*  559 */     boolean ev_postable = false;
/*      */     
/*  561 */     if ((getDAO_().getEndDate() == null && argEndDate != null) || (
/*  562 */       getDAO_().getEndDate() != null && !getDAO_().getEndDate().equals(argEndDate))) {
/*  563 */       getDAO_().setEndDate(argEndDate);
/*  564 */       ev_postable = true;
/*      */     } 
/*      */     
/*  567 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getStartTime() {
/*  575 */     return getDAO_().getStartTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStartTime(Date argStartTime) {
/*  583 */     if (setStartTime_noev(argStartTime) && 
/*  584 */       this._events != null && 
/*  585 */       postEventsForChanges()) {
/*  586 */       this._events.post(IDeal.SET_STARTTIME, argStartTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStartTime_noev(Date argStartTime) {
/*  593 */     boolean ev_postable = false;
/*      */     
/*  595 */     if ((getDAO_().getStartTime() == null && argStartTime != null) || (
/*  596 */       getDAO_().getStartTime() != null && !getDAO_().getStartTime().equals(argStartTime))) {
/*  597 */       getDAO_().setStartTime(argStartTime);
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
/*      */   public Date getEndTime() {
/*  609 */     return getDAO_().getEndTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndTime(Date argEndTime) {
/*  617 */     if (setEndTime_noev(argEndTime) && 
/*  618 */       this._events != null && 
/*  619 */       postEventsForChanges()) {
/*  620 */       this._events.post(IDeal.SET_ENDTIME, argEndTime);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndTime_noev(Date argEndTime) {
/*  627 */     boolean ev_postable = false;
/*      */     
/*  629 */     if ((getDAO_().getEndTime() == null && argEndTime != null) || (
/*  630 */       getDAO_().getEndTime() != null && !getDAO_().getEndTime().equals(argEndTime))) {
/*  631 */       getDAO_().setEndTime(argEndTime);
/*  632 */       ev_postable = true;
/*      */     } 
/*      */     
/*  635 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getGenerosityCap() {
/*  643 */     return getDAO_().getGenerosityCap();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGenerosityCap(BigDecimal argGenerosityCap) {
/*  651 */     if (setGenerosityCap_noev(argGenerosityCap) && 
/*  652 */       this._events != null && 
/*  653 */       postEventsForChanges()) {
/*  654 */       this._events.post(IDeal.SET_GENEROSITYCAP, argGenerosityCap);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGenerosityCap_noev(BigDecimal argGenerosityCap) {
/*  661 */     boolean ev_postable = false;
/*      */     
/*  663 */     if ((getDAO_().getGenerosityCap() == null && argGenerosityCap != null) || (
/*  664 */       getDAO_().getGenerosityCap() != null && !getDAO_().getGenerosityCap().equals(argGenerosityCap))) {
/*  665 */       getDAO_().setGenerosityCap(argGenerosityCap);
/*  666 */       ev_postable = true;
/*      */     } 
/*      */     
/*  669 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getIterationCap() {
/*  677 */     if (getDAO_().getIterationCap() != null) {
/*  678 */       return getDAO_().getIterationCap().intValue();
/*      */     }
/*      */     
/*  681 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIterationCap(int argIterationCap) {
/*  690 */     if (setIterationCap_noev(argIterationCap) && 
/*  691 */       this._events != null && 
/*  692 */       postEventsForChanges()) {
/*  693 */       this._events.post(IDeal.SET_ITERATIONCAP, Integer.valueOf(argIterationCap));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setIterationCap_noev(int argIterationCap) {
/*  700 */     boolean ev_postable = false;
/*      */     
/*  702 */     if ((getDAO_().getIterationCap() == null && Integer.valueOf(argIterationCap) != null) || (
/*  703 */       getDAO_().getIterationCap() != null && !getDAO_().getIterationCap().equals(Integer.valueOf(argIterationCap)))) {
/*  704 */       getDAO_().setIterationCap(Integer.valueOf(argIterationCap));
/*  705 */       ev_postable = true;
/*      */     } 
/*      */     
/*  708 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPriorityNudge() {
/*  716 */     if (getDAO_().getPriorityNudge() != null) {
/*  717 */       return getDAO_().getPriorityNudge().intValue();
/*      */     }
/*      */     
/*  720 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriorityNudge(int argPriorityNudge) {
/*  729 */     if (setPriorityNudge_noev(argPriorityNudge) && 
/*  730 */       this._events != null && 
/*  731 */       postEventsForChanges()) {
/*  732 */       this._events.post(IDeal.SET_PRIORITYNUDGE, Integer.valueOf(argPriorityNudge));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriorityNudge_noev(int argPriorityNudge) {
/*  739 */     boolean ev_postable = false;
/*      */     
/*  741 */     if ((getDAO_().getPriorityNudge() == null && Integer.valueOf(argPriorityNudge) != null) || (
/*  742 */       getDAO_().getPriorityNudge() != null && !getDAO_().getPriorityNudge().equals(Integer.valueOf(argPriorityNudge)))) {
/*  743 */       getDAO_().setPriorityNudge(Integer.valueOf(argPriorityNudge));
/*  744 */       ev_postable = true;
/*      */     } 
/*      */     
/*  747 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMinimumSubtotal() {
/*  755 */     return getDAO_().getMinimumSubtotal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinimumSubtotal(BigDecimal argMinimumSubtotal) {
/*  763 */     if (setMinimumSubtotal_noev(argMinimumSubtotal) && 
/*  764 */       this._events != null && 
/*  765 */       postEventsForChanges()) {
/*  766 */       this._events.post(IDeal.SET_MINIMUMSUBTOTAL, argMinimumSubtotal);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMinimumSubtotal_noev(BigDecimal argMinimumSubtotal) {
/*  773 */     boolean ev_postable = false;
/*      */     
/*  775 */     if ((getDAO_().getMinimumSubtotal() == null && argMinimumSubtotal != null) || (
/*  776 */       getDAO_().getMinimumSubtotal() != null && !getDAO_().getMinimumSubtotal().equals(argMinimumSubtotal))) {
/*  777 */       getDAO_().setMinimumSubtotal(argMinimumSubtotal);
/*  778 */       ev_postable = true;
/*      */     } 
/*      */     
/*  781 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMaximumSubtotal() {
/*  789 */     return getDAO_().getMaximumSubtotal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaximumSubtotal(BigDecimal argMaximumSubtotal) {
/*  797 */     if (setMaximumSubtotal_noev(argMaximumSubtotal) && 
/*  798 */       this._events != null && 
/*  799 */       postEventsForChanges()) {
/*  800 */       this._events.post(IDeal.SET_MAXIMUMSUBTOTAL, argMaximumSubtotal);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaximumSubtotal_noev(BigDecimal argMaximumSubtotal) {
/*  807 */     boolean ev_postable = false;
/*      */     
/*  809 */     if ((getDAO_().getMaximumSubtotal() == null && argMaximumSubtotal != null) || (
/*  810 */       getDAO_().getMaximumSubtotal() != null && !getDAO_().getMaximumSubtotal().equals(argMaximumSubtotal))) {
/*  811 */       getDAO_().setMaximumSubtotal(argMaximumSubtotal);
/*  812 */       ev_postable = true;
/*      */     } 
/*      */     
/*  815 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransActionType() {
/*  823 */     return getDAO_().getTransActionType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransActionType(String argTransActionType) {
/*  831 */     if (setTransActionType_noev(argTransActionType) && 
/*  832 */       this._events != null && 
/*  833 */       postEventsForChanges()) {
/*  834 */       this._events.post(IDeal.SET_TRANSACTIONTYPE, argTransActionType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransActionType_noev(String argTransActionType) {
/*  841 */     boolean ev_postable = false;
/*      */     
/*  843 */     if ((getDAO_().getTransActionType() == null && argTransActionType != null) || (
/*  844 */       getDAO_().getTransActionType() != null && !getDAO_().getTransActionType().equals(argTransActionType))) {
/*  845 */       getDAO_().setTransActionType(argTransActionType);
/*  846 */       ev_postable = true;
/*      */     } 
/*      */     
/*  849 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTransActionAmount() {
/*  857 */     return getDAO_().getTransActionAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransActionAmount(BigDecimal argTransActionAmount) {
/*  865 */     if (setTransActionAmount_noev(argTransActionAmount) && 
/*  866 */       this._events != null && 
/*  867 */       postEventsForChanges()) {
/*  868 */       this._events.post(IDeal.SET_TRANSACTIONAMOUNT, argTransActionAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransActionAmount_noev(BigDecimal argTransActionAmount) {
/*  875 */     boolean ev_postable = false;
/*      */     
/*  877 */     if ((getDAO_().getTransActionAmount() == null && argTransActionAmount != null) || (
/*  878 */       getDAO_().getTransActionAmount() != null && !getDAO_().getTransActionAmount().equals(argTransActionAmount))) {
/*  879 */       getDAO_().setTransActionAmount(argTransActionAmount);
/*  880 */       ev_postable = true;
/*      */     } 
/*      */     
/*  883 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxabilityCode() {
/*  891 */     return getDAO_().getTaxabilityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxabilityCode(String argTaxabilityCode) {
/*  899 */     if (setTaxabilityCode_noev(argTaxabilityCode) && 
/*  900 */       this._events != null && 
/*  901 */       postEventsForChanges()) {
/*  902 */       this._events.post(IDeal.SET_TAXABILITYCODE, argTaxabilityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxabilityCode_noev(String argTaxabilityCode) {
/*  909 */     boolean ev_postable = false;
/*      */     
/*  911 */     if ((getDAO_().getTaxabilityCode() == null && argTaxabilityCode != null) || (
/*  912 */       getDAO_().getTaxabilityCode() != null && !getDAO_().getTaxabilityCode().equals(argTaxabilityCode))) {
/*  913 */       getDAO_().setTaxabilityCode(argTaxabilityCode);
/*  914 */       ev_postable = true;
/*      */     } 
/*      */     
/*  917 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHigherNonactionAmt() {
/*  925 */     if (getDAO_().getHigherNonactionAmt() != null) {
/*  926 */       return getDAO_().getHigherNonactionAmt().booleanValue();
/*      */     }
/*      */     
/*  929 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHigherNonactionAmt(boolean argHigherNonactionAmt) {
/*  938 */     if (setHigherNonactionAmt_noev(argHigherNonactionAmt) && 
/*  939 */       this._events != null && 
/*  940 */       postEventsForChanges()) {
/*  941 */       this._events.post(IDeal.SET_HIGHERNONACTIONAMT, Boolean.valueOf(argHigherNonactionAmt));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setHigherNonactionAmt_noev(boolean argHigherNonactionAmt) {
/*  948 */     boolean ev_postable = false;
/*      */     
/*  950 */     if ((getDAO_().getHigherNonactionAmt() == null && Boolean.valueOf(argHigherNonactionAmt) != null) || (
/*  951 */       getDAO_().getHigherNonactionAmt() != null && !getDAO_().getHigherNonactionAmt().equals(Boolean.valueOf(argHigherNonactionAmt)))) {
/*  952 */       getDAO_().setHigherNonactionAmt(Boolean.valueOf(argHigherNonactionAmt));
/*  953 */       ev_postable = true;
/*      */     } 
/*      */     
/*  956 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getExcludePriceOverride() {
/*  964 */     if (getDAO_().getExcludePriceOverride() != null) {
/*  965 */       return getDAO_().getExcludePriceOverride().booleanValue();
/*      */     }
/*      */     
/*  968 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExcludePriceOverride(boolean argExcludePriceOverride) {
/*  977 */     if (setExcludePriceOverride_noev(argExcludePriceOverride) && 
/*  978 */       this._events != null && 
/*  979 */       postEventsForChanges()) {
/*  980 */       this._events.post(IDeal.SET_EXCLUDEPRICEOVERRIDE, Boolean.valueOf(argExcludePriceOverride));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExcludePriceOverride_noev(boolean argExcludePriceOverride) {
/*  987 */     boolean ev_postable = false;
/*      */     
/*  989 */     if ((getDAO_().getExcludePriceOverride() == null && Boolean.valueOf(argExcludePriceOverride) != null) || (
/*  990 */       getDAO_().getExcludePriceOverride() != null && !getDAO_().getExcludePriceOverride().equals(Boolean.valueOf(argExcludePriceOverride)))) {
/*  991 */       getDAO_().setExcludePriceOverride(Boolean.valueOf(argExcludePriceOverride));
/*  992 */       ev_postable = true;
/*      */     } 
/*      */     
/*  995 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getExcludeDiscounted() {
/* 1003 */     if (getDAO_().getExcludeDiscounted() != null) {
/* 1004 */       return getDAO_().getExcludeDiscounted().booleanValue();
/*      */     }
/*      */     
/* 1007 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExcludeDiscounted(boolean argExcludeDiscounted) {
/* 1016 */     if (setExcludeDiscounted_noev(argExcludeDiscounted) && 
/* 1017 */       this._events != null && 
/* 1018 */       postEventsForChanges()) {
/* 1019 */       this._events.post(IDeal.SET_EXCLUDEDISCOUNTED, Boolean.valueOf(argExcludeDiscounted));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExcludeDiscounted_noev(boolean argExcludeDiscounted) {
/* 1026 */     boolean ev_postable = false;
/*      */     
/* 1028 */     if ((getDAO_().getExcludeDiscounted() == null && Boolean.valueOf(argExcludeDiscounted) != null) || (
/* 1029 */       getDAO_().getExcludeDiscounted() != null && !getDAO_().getExcludeDiscounted().equals(Boolean.valueOf(argExcludeDiscounted)))) {
/* 1030 */       getDAO_().setExcludeDiscounted(Boolean.valueOf(argExcludeDiscounted));
/* 1031 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1034 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getUseWeekSchedule() {
/* 1042 */     if (getDAO_().getUseWeekSchedule() != null) {
/* 1043 */       return getDAO_().getUseWeekSchedule().booleanValue();
/*      */     }
/*      */     
/* 1046 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUseWeekSchedule(boolean argUseWeekSchedule) {
/* 1055 */     if (setUseWeekSchedule_noev(argUseWeekSchedule) && 
/* 1056 */       this._events != null && 
/* 1057 */       postEventsForChanges()) {
/* 1058 */       this._events.post(IDeal.SET_USEWEEKSCHEDULE, Boolean.valueOf(argUseWeekSchedule));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUseWeekSchedule_noev(boolean argUseWeekSchedule) {
/* 1065 */     boolean ev_postable = false;
/*      */     
/* 1067 */     if ((getDAO_().getUseWeekSchedule() == null && Boolean.valueOf(argUseWeekSchedule) != null) || (
/* 1068 */       getDAO_().getUseWeekSchedule() != null && !getDAO_().getUseWeekSchedule().equals(Boolean.valueOf(argUseWeekSchedule)))) {
/* 1069 */       getDAO_().setUseWeekSchedule(Boolean.valueOf(argUseWeekSchedule));
/* 1070 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1073 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getTargeted() {
/* 1081 */     if (getDAO_().getTargeted() != null) {
/* 1082 */       return getDAO_().getTargeted().booleanValue();
/*      */     }
/*      */     
/* 1085 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTargeted(boolean argTargeted) {
/* 1094 */     if (setTargeted_noev(argTargeted) && 
/* 1095 */       this._events != null && 
/* 1096 */       postEventsForChanges()) {
/* 1097 */       this._events.post(IDeal.SET_TARGETED, Boolean.valueOf(argTargeted));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTargeted_noev(boolean argTargeted) {
/* 1104 */     boolean ev_postable = false;
/*      */     
/* 1106 */     if ((getDAO_().getTargeted() == null && Boolean.valueOf(argTargeted) != null) || (
/* 1107 */       getDAO_().getTargeted() != null && !getDAO_().getTargeted().equals(Boolean.valueOf(argTargeted)))) {
/* 1108 */       getDAO_().setTargeted(Boolean.valueOf(argTargeted));
/* 1109 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1112 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromotionId() {
/* 1120 */     return getDAO_().getPromotionId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromotionId(String argPromotionId) {
/* 1128 */     if (setPromotionId_noev(argPromotionId) && 
/* 1129 */       this._events != null && 
/* 1130 */       postEventsForChanges()) {
/* 1131 */       this._events.post(IDeal.SET_PROMOTIONID, argPromotionId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromotionId_noev(String argPromotionId) {
/* 1138 */     boolean ev_postable = false;
/*      */     
/* 1140 */     if ((getDAO_().getPromotionId() == null && argPromotionId != null) || (
/* 1141 */       getDAO_().getPromotionId() != null && !getDAO_().getPromotionId().equals(argPromotionId))) {
/* 1142 */       getDAO_().setPromotionId(argPromotionId);
/* 1143 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1146 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSortOrder() {
/* 1154 */     if (getDAO_().getSortOrder() != null) {
/* 1155 */       return getDAO_().getSortOrder().intValue();
/*      */     }
/*      */     
/* 1158 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSortOrder(int argSortOrder) {
/* 1167 */     if (setSortOrder_noev(argSortOrder) && 
/* 1168 */       this._events != null && 
/* 1169 */       postEventsForChanges()) {
/* 1170 */       this._events.post(IDeal.SET_SORTORDER, Integer.valueOf(argSortOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSortOrder_noev(int argSortOrder) {
/* 1177 */     boolean ev_postable = false;
/*      */     
/* 1179 */     if ((getDAO_().getSortOrder() == null && Integer.valueOf(argSortOrder) != null) || (
/* 1180 */       getDAO_().getSortOrder() != null && !getDAO_().getSortOrder().equals(Integer.valueOf(argSortOrder)))) {
/* 1181 */       getDAO_().setSortOrder(Integer.valueOf(argSortOrder));
/* 1182 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1185 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getType() {
/* 1193 */     return getDAO_().getType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setType(String argType) {
/* 1201 */     if (setType_noev(argType) && 
/* 1202 */       this._events != null && 
/* 1203 */       postEventsForChanges()) {
/* 1204 */       this._events.post(IDeal.SET_TYPE, argType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setType_noev(String argType) {
/* 1211 */     boolean ev_postable = false;
/*      */     
/* 1213 */     if ((getDAO_().getType() == null && argType != null) || (
/* 1214 */       getDAO_().getType() != null && !getDAO_().getType().equals(argType))) {
/* 1215 */       getDAO_().setType(argType);
/* 1216 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1219 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGroupId() {
/* 1227 */     return getDAO_().getGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroupId(String argGroupId) {
/* 1235 */     if (setGroupId_noev(argGroupId) && 
/* 1236 */       this._events != null && 
/* 1237 */       postEventsForChanges()) {
/* 1238 */       this._events.post(IDeal.SET_GROUPID, argGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGroupId_noev(String argGroupId) {
/* 1245 */     boolean ev_postable = false;
/*      */     
/* 1247 */     if ((getDAO_().getGroupId() == null && argGroupId != null) || (
/* 1248 */       getDAO_().getGroupId() != null && !getDAO_().getGroupId().equals(argGroupId))) {
/* 1249 */       getDAO_().setGroupId(argGroupId);
/* 1250 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1253 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IDealProperty newProperty(String argPropertyName) {
/* 1257 */     DealPropertyId id = new DealPropertyId();
/*      */     
/* 1259 */     id.setDealId(getDealId());
/* 1260 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1262 */     IDealProperty prop = (IDealProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IDealProperty.class);
/* 1263 */     return prop;
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
/*      */   @Relationship(name = "Items")
/*      */   public List<IDealItemAction> getItems() {
/* 1281 */     if (this._items == null) {
/* 1282 */       this._items = new HistoricalList(null);
/*      */     }
/* 1284 */     return (List<IDealItemAction>)this._items;
/*      */   }
/*      */   
/*      */   public void setItems(List<IDealItemAction> argItems) {
/* 1288 */     if (this._items == null) {
/* 1289 */       this._items = new HistoricalList(argItems);
/*      */     } else {
/* 1291 */       this._items.setCurrentList(argItems);
/*      */     } 
/*      */     
/* 1294 */     for (IDealItemAction child : this._items) {
/* 1295 */       DealItemActionModel model = (DealItemActionModel)child;
/* 1296 */       model.setOrganizationId_noev(getOrganizationId());
/* 1297 */       model.setDealId_noev(getDealId());
/* 1298 */       if (child instanceof IDataModelImpl) {
/* 1299 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1300 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1301 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1302 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1305 */       if (postEventsForChanges()) {
/* 1306 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDealItemAction(IDealItemAction argDealItemAction) {
/* 1312 */     if (this._items == null) {
/* 1313 */       this._items = new HistoricalList(null);
/*      */     }
/* 1315 */     argDealItemAction.setOrganizationId(getOrganizationId());
/* 1316 */     argDealItemAction.setDealId(getDealId());
/* 1317 */     if (argDealItemAction instanceof IDataModelImpl) {
/* 1318 */       IDataAccessObject childDao = ((IDataModelImpl)argDealItemAction).getDAO();
/* 1319 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1320 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1321 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1326 */     if (postEventsForChanges()) {
/* 1327 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealItemAction));
/*      */     }
/*      */     
/* 1330 */     this._items.add(argDealItemAction);
/* 1331 */     if (postEventsForChanges()) {
/* 1332 */       this._events.post(IDeal.ADD_ITEMS, argDealItemAction);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDealItemAction(IDealItemAction argDealItemAction) {
/* 1337 */     if (this._items != null) {
/*      */       
/* 1339 */       if (postEventsForChanges()) {
/* 1340 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealItemAction));
/*      */       }
/* 1342 */       this._items.remove(argDealItemAction);
/* 1343 */       if (postEventsForChanges()) {
/* 1344 */         this._events.post(IDeal.REMOVE_ITEMS, argDealItemAction);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustomerGroups")
/*      */   public List<IDealCustomerGroups> getCustomerGroups() {
/* 1351 */     if (this._customerGroups == null) {
/* 1352 */       this._customerGroups = new HistoricalList(null);
/*      */     }
/* 1354 */     return (List<IDealCustomerGroups>)this._customerGroups;
/*      */   }
/*      */   
/*      */   public void setCustomerGroups(List<IDealCustomerGroups> argCustomerGroups) {
/* 1358 */     if (this._customerGroups == null) {
/* 1359 */       this._customerGroups = new HistoricalList(argCustomerGroups);
/*      */     } else {
/* 1361 */       this._customerGroups.setCurrentList(argCustomerGroups);
/*      */     } 
/*      */     
/* 1364 */     for (IDealCustomerGroups child : this._customerGroups) {
/* 1365 */       DealCustomerGroupsModel model = (DealCustomerGroupsModel)child;
/* 1366 */       model.setOrganizationId_noev(getOrganizationId());
/* 1367 */       model.setDealId_noev(getDealId());
/* 1368 */       if (child instanceof IDataModelImpl) {
/* 1369 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1370 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1371 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1372 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1375 */       if (postEventsForChanges()) {
/* 1376 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDealCustomerGroups(IDealCustomerGroups argDealCustomerGroups) {
/* 1382 */     if (this._customerGroups == null) {
/* 1383 */       this._customerGroups = new HistoricalList(null);
/*      */     }
/* 1385 */     argDealCustomerGroups.setOrganizationId(getOrganizationId());
/* 1386 */     argDealCustomerGroups.setDealId(getDealId());
/* 1387 */     if (argDealCustomerGroups instanceof IDataModelImpl) {
/* 1388 */       IDataAccessObject childDao = ((IDataModelImpl)argDealCustomerGroups).getDAO();
/* 1389 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1390 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1391 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1396 */     if (postEventsForChanges()) {
/* 1397 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealCustomerGroups));
/*      */     }
/*      */     
/* 1400 */     this._customerGroups.add(argDealCustomerGroups);
/* 1401 */     if (postEventsForChanges()) {
/* 1402 */       this._events.post(IDeal.ADD_CUSTOMERGROUPS, argDealCustomerGroups);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDealCustomerGroups(IDealCustomerGroups argDealCustomerGroups) {
/* 1407 */     if (this._customerGroups != null) {
/*      */       
/* 1409 */       if (postEventsForChanges()) {
/* 1410 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealCustomerGroups));
/*      */       }
/* 1412 */       this._customerGroups.remove(argDealCustomerGroups);
/* 1413 */       if (postEventsForChanges()) {
/* 1414 */         this._events.post(IDeal.REMOVE_CUSTOMERGROUPS, argDealCustomerGroups);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Triggers")
/*      */   public List<IDealTrigger> getTriggers() {
/* 1421 */     if (this._triggers == null) {
/* 1422 */       this._triggers = new HistoricalList(null);
/*      */     }
/* 1424 */     return (List<IDealTrigger>)this._triggers;
/*      */   }
/*      */   
/*      */   public void setTriggers(List<IDealTrigger> argTriggers) {
/* 1428 */     if (this._triggers == null) {
/* 1429 */       this._triggers = new HistoricalList(argTriggers);
/*      */     } else {
/* 1431 */       this._triggers.setCurrentList(argTriggers);
/*      */     } 
/*      */     
/* 1434 */     for (IDealTrigger child : this._triggers) {
/* 1435 */       DealTriggerModel model = (DealTriggerModel)child;
/* 1436 */       model.setOrganizationId_noev(getOrganizationId());
/* 1437 */       model.setDealId_noev(getDealId());
/* 1438 */       if (child instanceof IDataModelImpl) {
/* 1439 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1440 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1441 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1442 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1445 */       if (postEventsForChanges()) {
/* 1446 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDealTrigger(IDealTrigger argDealTrigger) {
/* 1452 */     if (this._triggers == null) {
/* 1453 */       this._triggers = new HistoricalList(null);
/*      */     }
/* 1455 */     argDealTrigger.setOrganizationId(getOrganizationId());
/* 1456 */     argDealTrigger.setDealId(getDealId());
/* 1457 */     if (argDealTrigger instanceof IDataModelImpl) {
/* 1458 */       IDataAccessObject childDao = ((IDataModelImpl)argDealTrigger).getDAO();
/* 1459 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1460 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1461 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1466 */     if (postEventsForChanges()) {
/* 1467 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealTrigger));
/*      */     }
/*      */     
/* 1470 */     this._triggers.add(argDealTrigger);
/* 1471 */     if (postEventsForChanges()) {
/* 1472 */       this._events.post(IDeal.ADD_TRIGGERS, argDealTrigger);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDealTrigger(IDealTrigger argDealTrigger) {
/* 1477 */     if (this._triggers != null) {
/*      */       
/* 1479 */       if (postEventsForChanges()) {
/* 1480 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealTrigger));
/*      */       }
/* 1482 */       this._triggers.remove(argDealTrigger);
/* 1483 */       if (postEventsForChanges()) {
/* 1484 */         this._events.post(IDeal.REMOVE_TRIGGERS, argDealTrigger);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IDealProperty> getProperties() {
/* 1491 */     if (this._properties == null) {
/* 1492 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1494 */     return (List<IDealProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IDealProperty> argProperties) {
/* 1498 */     if (this._properties == null) {
/* 1499 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1501 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1504 */     for (IDealProperty child : this._properties) {
/* 1505 */       DealPropertyModel model = (DealPropertyModel)child;
/* 1506 */       model.setOrganizationId_noev(getOrganizationId());
/* 1507 */       model.setDealId_noev(getDealId());
/* 1508 */       if (child instanceof IDataModelImpl) {
/* 1509 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1510 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1511 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1512 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1515 */       if (postEventsForChanges()) {
/* 1516 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addDealProperty(IDealProperty argDealProperty) {
/* 1522 */     if (this._properties == null) {
/* 1523 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1525 */     argDealProperty.setOrganizationId(getOrganizationId());
/* 1526 */     argDealProperty.setDealId(getDealId());
/* 1527 */     if (argDealProperty instanceof IDataModelImpl) {
/* 1528 */       IDataAccessObject childDao = ((IDataModelImpl)argDealProperty).getDAO();
/* 1529 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1530 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1531 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1536 */     if (postEventsForChanges()) {
/* 1537 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealProperty));
/*      */     }
/*      */     
/* 1540 */     this._properties.add(argDealProperty);
/* 1541 */     if (postEventsForChanges()) {
/* 1542 */       this._events.post(IDeal.ADD_PROPERTIES, argDealProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDealProperty(IDealProperty argDealProperty) {
/* 1547 */     if (this._properties != null) {
/*      */       
/* 1549 */       if (postEventsForChanges()) {
/* 1550 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDealProperty));
/*      */       }
/* 1552 */       this._properties.remove(argDealProperty);
/* 1553 */       if (postEventsForChanges()) {
/* 1554 */         this._events.post(IDeal.REMOVE_PROPERTIES, argDealProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1561 */     if ("Items".equals(argFieldId)) {
/* 1562 */       return getItems();
/*      */     }
/* 1564 */     if ("CustomerGroups".equals(argFieldId)) {
/* 1565 */       return getCustomerGroups();
/*      */     }
/* 1567 */     if ("Triggers".equals(argFieldId)) {
/* 1568 */       return getTriggers();
/*      */     }
/* 1570 */     if ("Properties".equals(argFieldId)) {
/* 1571 */       return getProperties();
/*      */     }
/* 1573 */     if ("DealExtension".equals(argFieldId)) {
/* 1574 */       return this._myExtension;
/*      */     }
/*      */     
/* 1577 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1583 */     if ("Items".equals(argFieldId)) {
/* 1584 */       setItems(changeToList(argValue, IDealItemAction.class));
/*      */     }
/* 1586 */     else if ("CustomerGroups".equals(argFieldId)) {
/* 1587 */       setCustomerGroups(changeToList(argValue, IDealCustomerGroups.class));
/*      */     }
/* 1589 */     else if ("Triggers".equals(argFieldId)) {
/* 1590 */       setTriggers(changeToList(argValue, IDealTrigger.class));
/*      */     }
/* 1592 */     else if ("Properties".equals(argFieldId)) {
/* 1593 */       setProperties(changeToList(argValue, IDealProperty.class));
/*      */     }
/* 1595 */     else if ("DealExtension".equals(argFieldId)) {
/* 1596 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1599 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1605 */     this._persistenceDefaults = argPD;
/* 1606 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1607 */     this._eventManager = argEM;
/* 1608 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1609 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1610 */     if (this._items != null) {
/* 1611 */       for (IDealItemAction relationship : this._items) {
/* 1612 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1615 */     if (this._customerGroups != null) {
/* 1616 */       for (IDealCustomerGroups relationship : this._customerGroups) {
/* 1617 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1620 */     if (this._triggers != null) {
/* 1621 */       for (IDealTrigger relationship : this._triggers) {
/* 1622 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1625 */     if (this._properties != null) {
/* 1626 */       for (IDealProperty relationship : this._properties) {
/* 1627 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getDealExt() {
/* 1633 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setDealExt(IDataModel argExt) {
/* 1637 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1642 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1646 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1649 */     super.startTransaction();
/*      */     
/* 1651 */     this._itemsSavepoint = this._items;
/* 1652 */     if (this._items != null) {
/* 1653 */       this._itemsSavepoint = new HistoricalList((List)this._items);
/* 1654 */       Iterator<IDataModel> it = this._items.iterator();
/* 1655 */       while (it.hasNext()) {
/* 1656 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1660 */     this._customerGroupsSavepoint = this._customerGroups;
/* 1661 */     if (this._customerGroups != null) {
/* 1662 */       this._customerGroupsSavepoint = new HistoricalList((List)this._customerGroups);
/* 1663 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 1664 */       while (it.hasNext()) {
/* 1665 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1669 */     this._triggersSavepoint = this._triggers;
/* 1670 */     if (this._triggers != null) {
/* 1671 */       this._triggersSavepoint = new HistoricalList((List)this._triggers);
/* 1672 */       Iterator<IDataModel> it = this._triggers.iterator();
/* 1673 */       while (it.hasNext()) {
/* 1674 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1678 */     this._propertiesSavepoint = this._properties;
/* 1679 */     if (this._properties != null) {
/* 1680 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1681 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1682 */       while (it.hasNext()) {
/* 1683 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1688 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1693 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1696 */     super.rollbackChanges();
/*      */     
/* 1698 */     this._items = this._itemsSavepoint;
/* 1699 */     this._itemsSavepoint = null;
/* 1700 */     if (this._items != null) {
/* 1701 */       Iterator<IDataModel> it = this._items.iterator();
/* 1702 */       while (it.hasNext()) {
/* 1703 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1707 */     this._customerGroups = this._customerGroupsSavepoint;
/* 1708 */     this._customerGroupsSavepoint = null;
/* 1709 */     if (this._customerGroups != null) {
/* 1710 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 1711 */       while (it.hasNext()) {
/* 1712 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1716 */     this._triggers = this._triggersSavepoint;
/* 1717 */     this._triggersSavepoint = null;
/* 1718 */     if (this._triggers != null) {
/* 1719 */       Iterator<IDataModel> it = this._triggers.iterator();
/* 1720 */       while (it.hasNext()) {
/* 1721 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1725 */     this._properties = this._propertiesSavepoint;
/* 1726 */     this._propertiesSavepoint = null;
/* 1727 */     if (this._properties != null) {
/* 1728 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1729 */       while (it.hasNext()) {
/* 1730 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1738 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1741 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1744 */     super.commitTransaction();
/*      */     
/* 1746 */     this._itemsSavepoint = this._items;
/* 1747 */     if (this._items != null) {
/* 1748 */       Iterator<IDataModel> it = this._items.iterator();
/* 1749 */       while (it.hasNext()) {
/* 1750 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1752 */       this._items = new HistoricalList((List)this._items);
/*      */     } 
/*      */     
/* 1755 */     this._customerGroupsSavepoint = this._customerGroups;
/* 1756 */     if (this._customerGroups != null) {
/* 1757 */       Iterator<IDataModel> it = this._customerGroups.iterator();
/* 1758 */       while (it.hasNext()) {
/* 1759 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1761 */       this._customerGroups = new HistoricalList((List)this._customerGroups);
/*      */     } 
/*      */     
/* 1764 */     this._triggersSavepoint = this._triggers;
/* 1765 */     if (this._triggers != null) {
/* 1766 */       Iterator<IDataModel> it = this._triggers.iterator();
/* 1767 */       while (it.hasNext()) {
/* 1768 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1770 */       this._triggers = new HistoricalList((List)this._triggers);
/*      */     } 
/*      */     
/* 1773 */     this._propertiesSavepoint = this._properties;
/* 1774 */     if (this._properties != null) {
/* 1775 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1776 */       while (it.hasNext()) {
/* 1777 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1779 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1783 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1788 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */