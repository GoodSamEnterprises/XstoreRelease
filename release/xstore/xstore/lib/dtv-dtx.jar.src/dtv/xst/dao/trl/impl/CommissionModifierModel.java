/*      */ package dtv.xst.dao.trl.impl;
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
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.trl.CommissionModifierPropertyId;
/*      */ import dtv.xst.dao.trl.ICommissionModifier;
/*      */ import dtv.xst.dao.trl.ICommissionModifierProperty;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class CommissionModifierModel extends AbstractDataModelWithPropertyImpl<ICommissionModifierProperty> implements ICommissionModifier {
/*      */   private static final long serialVersionUID = -1992981246L;
/*      */   private ISaleReturnLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private IParty _employeeParty; private transient IParty _employeePartySavepoint; private HistoricalList<ICommissionModifierProperty> _properties; private transient HistoricalList<ICommissionModifierProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new CommissionModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CommissionModifierDAO getDAO_() {
/*   49 */     return (CommissionModifierDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*   57 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*   65 */     if (setBusinessDate_noev(argBusinessDate) && 
/*   66 */       this._events != null && 
/*   67 */       postEventsForChanges()) {
/*   68 */       this._events.post(ICommissionModifier.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*   75 */     boolean ev_postable = false;
/*      */     
/*   77 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*   78 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*   79 */       getDAO_().setBusinessDate(argBusinessDate);
/*   80 */       ev_postable = true;
/*   81 */       if (this._properties != null) {
/*      */         
/*   83 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*   84 */         while (it.hasNext())
/*      */         {
/*   86 */           ((CommissionModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   91 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCommissionModifierSequenceNbr() {
/*   99 */     if (getDAO_().getCommissionModifierSequenceNbr() != null) {
/*  100 */       return getDAO_().getCommissionModifierSequenceNbr().intValue();
/*      */     }
/*      */     
/*  103 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCommissionModifierSequenceNbr(int argCommissionModifierSequenceNbr) {
/*  112 */     if (setCommissionModifierSequenceNbr_noev(argCommissionModifierSequenceNbr) && 
/*  113 */       this._events != null && 
/*  114 */       postEventsForChanges()) {
/*  115 */       this._events.post(ICommissionModifier.SET_COMMISSIONMODIFIERSEQUENCENBR, Integer.valueOf(argCommissionModifierSequenceNbr));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCommissionModifierSequenceNbr_noev(int argCommissionModifierSequenceNbr) {
/*  122 */     boolean ev_postable = false;
/*      */     
/*  124 */     if ((getDAO_().getCommissionModifierSequenceNbr() == null && Integer.valueOf(argCommissionModifierSequenceNbr) != null) || (
/*  125 */       getDAO_().getCommissionModifierSequenceNbr() != null && !getDAO_().getCommissionModifierSequenceNbr().equals(Integer.valueOf(argCommissionModifierSequenceNbr)))) {
/*  126 */       getDAO_().setCommissionModifierSequenceNbr(Integer.valueOf(argCommissionModifierSequenceNbr));
/*  127 */       ev_postable = true;
/*  128 */       if (this._properties != null) {
/*      */         
/*  130 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*  131 */         while (it.hasNext())
/*      */         {
/*  133 */           ((CommissionModifierPropertyModel)it.next()).setCommissionModifierSequenceNbr_noev(argCommissionModifierSequenceNbr);
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
/*      */   public long getOrganizationId() {
/*  146 */     if (getDAO_().getOrganizationId() != null) {
/*  147 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  150 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  159 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  160 */       this._events != null && 
/*  161 */       postEventsForChanges()) {
/*  162 */       this._events.post(ICommissionModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  169 */     boolean ev_postable = false;
/*      */     
/*  171 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  172 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  173 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  174 */       ev_postable = true;
/*  175 */       if (this._properties != null) {
/*      */         
/*  177 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*  178 */         while (it.hasNext())
/*      */         {
/*  180 */           ((CommissionModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  185 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  193 */     if (getDAO_().getRetailLocationId() != null) {
/*  194 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  197 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  206 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  207 */       this._events != null && 
/*  208 */       postEventsForChanges()) {
/*  209 */       this._events.post(ICommissionModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  216 */     boolean ev_postable = false;
/*      */     
/*  218 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  219 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  220 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  221 */       ev_postable = true;
/*  222 */       if (this._properties != null) {
/*      */         
/*  224 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*  225 */         while (it.hasNext())
/*      */         {
/*  227 */           ((CommissionModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  232 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  240 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  241 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  244 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  253 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  254 */       this._events != null && 
/*  255 */       postEventsForChanges()) {
/*  256 */       this._events.post(ICommissionModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  263 */     boolean ev_postable = false;
/*      */     
/*  265 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  266 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  267 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  268 */       ev_postable = true;
/*  269 */       if (this._properties != null) {
/*      */         
/*  271 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*  272 */         while (it.hasNext())
/*      */         {
/*  274 */           ((CommissionModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  279 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  287 */     if (getDAO_().getTransactionSequence() != null) {
/*  288 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  291 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  300 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  301 */       this._events != null && 
/*  302 */       postEventsForChanges()) {
/*  303 */       this._events.post(ICommissionModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  310 */     boolean ev_postable = false;
/*      */     
/*  312 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  313 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  314 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  315 */       ev_postable = true;
/*  316 */       if (this._properties != null) {
/*      */         
/*  318 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*  319 */         while (it.hasNext())
/*      */         {
/*  321 */           ((CommissionModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  326 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  334 */     if (getDAO_().getWorkstationId() != null) {
/*  335 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  338 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  347 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  348 */       this._events != null && 
/*  349 */       postEventsForChanges()) {
/*  350 */       this._events.post(ICommissionModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  357 */     boolean ev_postable = false;
/*      */     
/*  359 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  360 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  361 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  362 */       ev_postable = true;
/*  363 */       if (this._properties != null) {
/*      */         
/*  365 */         Iterator<CommissionModifierPropertyModel> it = this._properties.iterator();
/*  366 */         while (it.hasNext())
/*      */         {
/*  368 */           ((CommissionModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  373 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  381 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  389 */     if (setCreateDate_noev(argCreateDate) && 
/*  390 */       this._events != null && 
/*  391 */       postEventsForChanges()) {
/*  392 */       this._events.post(ICommissionModifier.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  399 */     boolean ev_postable = false;
/*      */     
/*  401 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  402 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  403 */       getDAO_().setCreateDate(argCreateDate);
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
/*      */   public String getCreateUserId() {
/*  415 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  423 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  424 */       this._events != null && 
/*  425 */       postEventsForChanges()) {
/*  426 */       this._events.post(ICommissionModifier.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  433 */     boolean ev_postable = false;
/*      */     
/*  435 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  436 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  437 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*      */   public Date getUpdateDate() {
/*  449 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  457 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  458 */       this._events != null && 
/*  459 */       postEventsForChanges()) {
/*  460 */       this._events.post(ICommissionModifier.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  467 */     boolean ev_postable = false;
/*      */     
/*  469 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  470 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  471 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*      */   public String getUpdateUserId() {
/*  483 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  491 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  492 */       this._events != null && 
/*  493 */       postEventsForChanges()) {
/*  494 */       this._events.post(ICommissionModifier.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  501 */     boolean ev_postable = false;
/*      */     
/*  503 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  504 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  505 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*      */   public BigDecimal getAmount() {
/*  517 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  525 */     if (setAmount_noev(argAmount) && 
/*  526 */       this._events != null && 
/*  527 */       postEventsForChanges()) {
/*  528 */       this._events.post(ICommissionModifier.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  535 */     boolean ev_postable = false;
/*      */     
/*  537 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  538 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  539 */       getDAO_().setAmount(argAmount);
/*  540 */       ev_postable = true;
/*      */     } 
/*      */     
/*  543 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPercentage() {
/*  551 */     return getDAO_().getPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPercentage(BigDecimal argPercentage) {
/*  559 */     if (setPercentage_noev(argPercentage) && 
/*  560 */       this._events != null && 
/*  561 */       postEventsForChanges()) {
/*  562 */       this._events.post(ICommissionModifier.SET_PERCENTAGE, argPercentage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPercentage_noev(BigDecimal argPercentage) {
/*  569 */     boolean ev_postable = false;
/*      */     
/*  571 */     if ((getDAO_().getPercentage() == null && argPercentage != null) || (
/*  572 */       getDAO_().getPercentage() != null && !getDAO_().getPercentage().equals(argPercentage))) {
/*  573 */       getDAO_().setPercentage(argPercentage);
/*  574 */       ev_postable = true;
/*      */     } 
/*      */     
/*  577 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPercentageOfItem() {
/*  585 */     return getDAO_().getPercentageOfItem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPercentageOfItem(BigDecimal argPercentageOfItem) {
/*  593 */     if (setPercentageOfItem_noev(argPercentageOfItem) && 
/*  594 */       this._events != null && 
/*  595 */       postEventsForChanges()) {
/*  596 */       this._events.post(ICommissionModifier.SET_PERCENTAGEOFITEM, argPercentageOfItem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPercentageOfItem_noev(BigDecimal argPercentageOfItem) {
/*  603 */     boolean ev_postable = false;
/*      */     
/*  605 */     if ((getDAO_().getPercentageOfItem() == null && argPercentageOfItem != null) || (
/*  606 */       getDAO_().getPercentageOfItem() != null && !getDAO_().getPercentageOfItem().equals(argPercentageOfItem))) {
/*  607 */       getDAO_().setPercentageOfItem(argPercentageOfItem);
/*  608 */       ev_postable = true;
/*      */     } 
/*      */     
/*  611 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTypeCode() {
/*  619 */     return getDAO_().getTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeCode(String argTypeCode) {
/*  627 */     if (setTypeCode_noev(argTypeCode) && 
/*  628 */       this._events != null && 
/*  629 */       postEventsForChanges()) {
/*  630 */       this._events.post(ICommissionModifier.SET_TYPECODE, argTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTypeCode_noev(String argTypeCode) {
/*  637 */     boolean ev_postable = false;
/*      */     
/*  639 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/*  640 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/*  641 */       getDAO_().setTypeCode(argTypeCode);
/*  642 */       ev_postable = true;
/*      */     } 
/*      */     
/*  645 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUnverifiableEmployeeId() {
/*  653 */     return getDAO_().getUnverifiableEmployeeId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnverifiableEmployeeId(String argUnverifiableEmployeeId) {
/*  661 */     if (setUnverifiableEmployeeId_noev(argUnverifiableEmployeeId) && 
/*  662 */       this._events != null && 
/*  663 */       postEventsForChanges()) {
/*  664 */       this._events.post(ICommissionModifier.SET_UNVERIFIABLEEMPLOYEEID, argUnverifiableEmployeeId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnverifiableEmployeeId_noev(String argUnverifiableEmployeeId) {
/*  671 */     boolean ev_postable = false;
/*      */     
/*  673 */     if ((getDAO_().getUnverifiableEmployeeId() == null && argUnverifiableEmployeeId != null) || (
/*  674 */       getDAO_().getUnverifiableEmployeeId() != null && !getDAO_().getUnverifiableEmployeeId().equals(argUnverifiableEmployeeId))) {
/*  675 */       getDAO_().setUnverifiableEmployeeId(argUnverifiableEmployeeId);
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
/*      */   public long getEmployeePartyId() {
/*  687 */     if (getDAO_().getEmployeePartyId() != null) {
/*  688 */       return getDAO_().getEmployeePartyId().longValue();
/*      */     }
/*      */     
/*  691 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEmployeePartyId(long argEmployeePartyId) {
/*  700 */     if (setEmployeePartyId_noev(argEmployeePartyId) && 
/*  701 */       this._events != null && 
/*  702 */       postEventsForChanges()) {
/*  703 */       this._events.post(ICommissionModifier.SET_EMPLOYEEPARTYID, Long.valueOf(argEmployeePartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEmployeePartyId_noev(long argEmployeePartyId) {
/*  710 */     boolean ev_postable = false;
/*      */     
/*  712 */     if ((getDAO_().getEmployeePartyId() == null && Long.valueOf(argEmployeePartyId) != null) || (
/*  713 */       getDAO_().getEmployeePartyId() != null && !getDAO_().getEmployeePartyId().equals(Long.valueOf(argEmployeePartyId)))) {
/*  714 */       getDAO_().setEmployeePartyId(Long.valueOf(argEmployeePartyId));
/*  715 */       ev_postable = true;
/*      */     } 
/*      */     
/*  718 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ICommissionModifierProperty newProperty(String argPropertyName) {
/*  722 */     CommissionModifierPropertyId id = new CommissionModifierPropertyId();
/*      */     
/*  724 */     id.setBusinessDate(getBusinessDate());
/*  725 */     id.setCommissionModifierSequenceNbr(Integer.valueOf(getCommissionModifierSequenceNbr()));
/*  726 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  727 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/*  728 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  729 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  730 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  732 */     ICommissionModifierProperty prop = (ICommissionModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICommissionModifierProperty.class);
/*  733 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "EmployeeParty")
/*      */   public IParty getEmployeeParty() {
/*  745 */     return this._employeeParty;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setEmployeeParty(IParty argEmployeeParty) {
/*  750 */     if (argEmployeeParty == null) {
/*      */       
/*  752 */       getDAO_().setEmployeePartyId(null);
/*  753 */       if (this._employeeParty != null)
/*      */       {
/*  755 */         if (postEventsForChanges()) {
/*  756 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._employeeParty));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  761 */       getDAO_().setEmployeePartyId(Long.valueOf(argEmployeeParty.getPartyId()));
/*      */       
/*  763 */       if (postEventsForChanges()) {
/*  764 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEmployeeParty));
/*      */       }
/*      */     } 
/*      */     
/*  768 */     this._employeeParty = argEmployeeParty;
/*  769 */     if (postEventsForChanges()) {
/*  770 */       this._events.post(ICommissionModifier.SET_EMPLOYEEPARTY, argEmployeeParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ICommissionModifierProperty> getProperties() {
/*  776 */     if (this._properties == null) {
/*  777 */       this._properties = new HistoricalList(null);
/*      */     }
/*  779 */     return (List<ICommissionModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ICommissionModifierProperty> argProperties) {
/*  783 */     if (this._properties == null) {
/*  784 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  786 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  789 */     for (ICommissionModifierProperty child : this._properties) {
/*  790 */       CommissionModifierPropertyModel model = (CommissionModifierPropertyModel)child;
/*  791 */       model.setBusinessDate_noev(getBusinessDate());
/*  792 */       model.setCommissionModifierSequenceNbr_noev(getCommissionModifierSequenceNbr());
/*  793 */       model.setOrganizationId_noev(getOrganizationId());
/*  794 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  795 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  796 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  797 */       model.setWorkstationId_noev(getWorkstationId());
/*  798 */       if (child instanceof IDataModelImpl) {
/*  799 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  800 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  801 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  802 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  805 */       if (postEventsForChanges()) {
/*  806 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCommissionModifierProperty(ICommissionModifierProperty argCommissionModifierProperty) {
/*  812 */     if (this._properties == null) {
/*  813 */       this._properties = new HistoricalList(null);
/*      */     }
/*  815 */     argCommissionModifierProperty.setBusinessDate(getBusinessDate());
/*  816 */     argCommissionModifierProperty.setCommissionModifierSequenceNbr(getCommissionModifierSequenceNbr());
/*  817 */     argCommissionModifierProperty.setOrganizationId(getOrganizationId());
/*  818 */     argCommissionModifierProperty.setRetailLocationId(getRetailLocationId());
/*  819 */     argCommissionModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  820 */     argCommissionModifierProperty.setTransactionSequence(getTransactionSequence());
/*  821 */     argCommissionModifierProperty.setWorkstationId(getWorkstationId());
/*  822 */     if (argCommissionModifierProperty instanceof IDataModelImpl) {
/*  823 */       IDataAccessObject childDao = ((IDataModelImpl)argCommissionModifierProperty).getDAO();
/*  824 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  825 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  826 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  831 */     if (postEventsForChanges()) {
/*  832 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCommissionModifierProperty));
/*      */     }
/*      */     
/*  835 */     this._properties.add(argCommissionModifierProperty);
/*  836 */     if (postEventsForChanges()) {
/*  837 */       this._events.post(ICommissionModifier.ADD_PROPERTIES, argCommissionModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCommissionModifierProperty(ICommissionModifierProperty argCommissionModifierProperty) {
/*  842 */     if (this._properties != null) {
/*      */       
/*  844 */       if (postEventsForChanges()) {
/*  845 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCommissionModifierProperty));
/*      */       }
/*  847 */       this._properties.remove(argCommissionModifierProperty);
/*  848 */       if (postEventsForChanges()) {
/*  849 */         this._events.post(ICommissionModifier.REMOVE_PROPERTIES, argCommissionModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/*  855 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public ISaleReturnLineItem getParentLine() {
/*  859 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  864 */     if ("EmployeeParty".equals(argFieldId)) {
/*  865 */       return getEmployeeParty();
/*      */     }
/*  867 */     if ("Properties".equals(argFieldId)) {
/*  868 */       return getProperties();
/*      */     }
/*  870 */     if ("CommissionModifierExtension".equals(argFieldId)) {
/*  871 */       return this._myExtension;
/*      */     }
/*      */     
/*  874 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  880 */     if ("EmployeeParty".equals(argFieldId)) {
/*  881 */       setEmployeeParty((IParty)argValue);
/*      */     }
/*  883 */     else if ("Properties".equals(argFieldId)) {
/*  884 */       setProperties(changeToList(argValue, ICommissionModifierProperty.class));
/*      */     }
/*  886 */     else if ("CommissionModifierExtension".equals(argFieldId)) {
/*  887 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  890 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  896 */     this._persistenceDefaults = argPD;
/*  897 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  898 */     this._eventManager = argEM;
/*  899 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  900 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  901 */     if (this._employeeParty != null) {
/*  902 */       ((IDataModelImpl)this._employeeParty).setDependencies(argPD, argEM);
/*      */     }
/*  904 */     if (this._properties != null) {
/*  905 */       for (ICommissionModifierProperty relationship : this._properties) {
/*  906 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getCommissionModifierExt() {
/*  912 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setCommissionModifierExt(IDataModel argExt) {
/*  916 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  921 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  925 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  928 */     super.startTransaction();
/*      */     
/*  930 */     this._employeePartySavepoint = this._employeeParty;
/*  931 */     if (this._employeeParty != null) {
/*  932 */       this._employeeParty.startTransaction();
/*      */     }
/*      */     
/*  935 */     this._propertiesSavepoint = this._properties;
/*  936 */     if (this._properties != null) {
/*  937 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  938 */       Iterator<IDataModel> it = this._properties.iterator();
/*  939 */       while (it.hasNext()) {
/*  940 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  945 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  950 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  953 */     super.rollbackChanges();
/*      */     
/*  955 */     this._employeeParty = this._employeePartySavepoint;
/*  956 */     this._employeePartySavepoint = null;
/*  957 */     if (this._employeeParty != null) {
/*  958 */       this._employeeParty.rollbackChanges();
/*      */     }
/*      */     
/*  961 */     this._properties = this._propertiesSavepoint;
/*  962 */     this._propertiesSavepoint = null;
/*  963 */     if (this._properties != null) {
/*  964 */       Iterator<IDataModel> it = this._properties.iterator();
/*  965 */       while (it.hasNext()) {
/*  966 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/*  974 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/*  977 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/*  980 */     super.commitTransaction();
/*      */     
/*  982 */     this._employeePartySavepoint = this._employeeParty;
/*  983 */     if (this._employeeParty != null) {
/*  984 */       this._employeeParty.commitTransaction();
/*      */     }
/*      */     
/*  987 */     this._propertiesSavepoint = this._properties;
/*  988 */     if (this._properties != null) {
/*  989 */       Iterator<IDataModel> it = this._properties.iterator();
/*  990 */       while (it.hasNext()) {
/*  991 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/*  993 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/*  997 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1002 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CommissionModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */