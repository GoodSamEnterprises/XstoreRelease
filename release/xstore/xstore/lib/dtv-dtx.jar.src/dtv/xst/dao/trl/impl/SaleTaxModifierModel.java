/*      */ package dtv.xst.dao.trl.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
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
/*      */ import dtv.xst.dao.tax.ITaxGroupRule;
/*      */ import dtv.xst.dao.tax.TaxExemptionId;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import dtv.xst.dao.trl.ISaleTaxModifier;
/*      */ import dtv.xst.dao.trl.ISaleTaxModifierProperty;
/*      */ import dtv.xst.dao.trl.SaleTaxModifierPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class SaleTaxModifierModel extends AbstractDataModelWithPropertyImpl<ISaleTaxModifierProperty> implements ISaleTaxModifier {
/*      */   private static final long serialVersionUID = 698796219L;
/*      */   private ISaleReturnLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private ITaxGroupRule _saleTaxGroupRule; private transient ITaxGroupRule _saleTaxGroupRuleSavepoint; private HistoricalList<ISaleTaxModifierProperty> _properties; private transient HistoricalList<ISaleTaxModifierProperty> _propertiesSavepoint; private transient BigDecimal _tranTaxableAmt;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new SaleTaxModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SaleTaxModifierDAO getDAO_() {
/*   49 */     return (SaleTaxModifierDAO)this._daoImpl;
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
/*   68 */       this._events.post(ISaleTaxModifier.SET_BUSINESSDATE, argBusinessDate);
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
/*   83 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*   84 */         while (it.hasNext())
/*      */         {
/*   86 */           ((SaleTaxModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*      */   public long getOrganizationId() {
/*   99 */     if (getDAO_().getOrganizationId() != null) {
/*  100 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  103 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  112 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  113 */       this._events != null && 
/*  114 */       postEventsForChanges()) {
/*  115 */       this._events.post(ISaleTaxModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  122 */     boolean ev_postable = false;
/*      */     
/*  124 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  125 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  126 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  127 */       ev_postable = true;
/*  128 */       if (this._properties != null) {
/*      */         
/*  130 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*  131 */         while (it.hasNext())
/*      */         {
/*  133 */           ((SaleTaxModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public long getRetailLocationId() {
/*  146 */     if (getDAO_().getRetailLocationId() != null) {
/*  147 */       return getDAO_().getRetailLocationId().longValue();
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
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  159 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  160 */       this._events != null && 
/*  161 */       postEventsForChanges()) {
/*  162 */       this._events.post(ISaleTaxModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  169 */     boolean ev_postable = false;
/*      */     
/*  171 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  172 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  173 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  174 */       ev_postable = true;
/*  175 */       if (this._properties != null) {
/*      */         
/*  177 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*  178 */         while (it.hasNext())
/*      */         {
/*  180 */           ((SaleTaxModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*      */   public int getRetailTransactionLineItemSequence() {
/*  193 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  194 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  197 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  206 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  207 */       this._events != null && 
/*  208 */       postEventsForChanges()) {
/*  209 */       this._events.post(ISaleTaxModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  216 */     boolean ev_postable = false;
/*      */     
/*  218 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  219 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  220 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  221 */       ev_postable = true;
/*  222 */       if (this._properties != null) {
/*      */         
/*  224 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*  225 */         while (it.hasNext())
/*      */         {
/*  227 */           ((SaleTaxModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
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
/*      */   public int getSaleTaxModifierSequence() {
/*  240 */     if (getDAO_().getSaleTaxModifierSequence() != null) {
/*  241 */       return getDAO_().getSaleTaxModifierSequence().intValue();
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
/*      */   public void setSaleTaxModifierSequence(int argSaleTaxModifierSequence) {
/*  253 */     if (setSaleTaxModifierSequence_noev(argSaleTaxModifierSequence) && 
/*  254 */       this._events != null && 
/*  255 */       postEventsForChanges()) {
/*  256 */       this._events.post(ISaleTaxModifier.SET_SALETAXMODIFIERSEQUENCE, Integer.valueOf(argSaleTaxModifierSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSaleTaxModifierSequence_noev(int argSaleTaxModifierSequence) {
/*  263 */     boolean ev_postable = false;
/*      */     
/*  265 */     if ((getDAO_().getSaleTaxModifierSequence() == null && Integer.valueOf(argSaleTaxModifierSequence) != null) || (
/*  266 */       getDAO_().getSaleTaxModifierSequence() != null && !getDAO_().getSaleTaxModifierSequence().equals(Integer.valueOf(argSaleTaxModifierSequence)))) {
/*  267 */       getDAO_().setSaleTaxModifierSequence(Integer.valueOf(argSaleTaxModifierSequence));
/*  268 */       ev_postable = true;
/*  269 */       if (this._properties != null) {
/*      */         
/*  271 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*  272 */         while (it.hasNext())
/*      */         {
/*  274 */           ((SaleTaxModifierPropertyModel)it.next()).setSaleTaxModifierSequence_noev(argSaleTaxModifierSequence);
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
/*  303 */       this._events.post(ISaleTaxModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/*  318 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*  319 */         while (it.hasNext())
/*      */         {
/*  321 */           ((SaleTaxModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*  350 */       this._events.post(ISaleTaxModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
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
/*  365 */         Iterator<SaleTaxModifierPropertyModel> it = this._properties.iterator();
/*  366 */         while (it.hasNext())
/*      */         {
/*  368 */           ((SaleTaxModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*  392 */       this._events.post(ISaleTaxModifier.SET_CREATEDATE, argCreateDate);
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
/*  426 */       this._events.post(ISaleTaxModifier.SET_CREATEUSERID, argCreateUserId);
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
/*  460 */       this._events.post(ISaleTaxModifier.SET_UPDATEDATE, argUpdateDate);
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
/*  494 */       this._events.post(ISaleTaxModifier.SET_UPDATEUSERID, argUpdateUserId);
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
/*      */   protected BigDecimal getTaxAmountImpl() {
/*  517 */     return getDAO_().getTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setTaxAmountImpl(BigDecimal argTaxAmount) {
/*  525 */     if (setTaxAmount_noev(argTaxAmount) && 
/*  526 */       this._events != null && 
/*  527 */       postEventsForChanges()) {
/*  528 */       this._events.post(ISaleTaxModifier.SET_TAXAMOUNT, argTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/*  535 */     boolean ev_postable = false;
/*      */     
/*  537 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/*  538 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/*  539 */       getDAO_().setTaxAmount(argTaxAmount);
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
/*      */   public BigDecimal getTaxPercentage() {
/*  551 */     return getDAO_().getTaxPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxPercentage(BigDecimal argTaxPercentage) {
/*  559 */     if (setTaxPercentage_noev(argTaxPercentage) && 
/*  560 */       this._events != null && 
/*  561 */       postEventsForChanges()) {
/*  562 */       this._events.post(ISaleTaxModifier.SET_TAXPERCENTAGE, argTaxPercentage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxPercentage_noev(BigDecimal argTaxPercentage) {
/*  569 */     boolean ev_postable = false;
/*      */     
/*  571 */     if ((getDAO_().getTaxPercentage() == null && argTaxPercentage != null) || (
/*  572 */       getDAO_().getTaxPercentage() != null && !getDAO_().getTaxPercentage().equals(argTaxPercentage))) {
/*  573 */       getDAO_().setTaxPercentage(argTaxPercentage);
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
/*      */   protected BigDecimal getRawTaxAmountImpl() {
/*  585 */     return getDAO_().getRawTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setRawTaxAmountImpl(BigDecimal argRawTaxAmount) {
/*  593 */     if (setRawTaxAmount_noev(argRawTaxAmount) && 
/*  594 */       this._events != null && 
/*  595 */       postEventsForChanges()) {
/*  596 */       this._events.post(ISaleTaxModifier.SET_RAWTAXAMOUNT, argRawTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRawTaxAmount_noev(BigDecimal argRawTaxAmount) {
/*  603 */     boolean ev_postable = false;
/*      */     
/*  605 */     if ((getDAO_().getRawTaxAmount() == null && argRawTaxAmount != null) || (
/*  606 */       getDAO_().getRawTaxAmount() != null && !getDAO_().getRawTaxAmount().equals(argRawTaxAmount))) {
/*  607 */       getDAO_().setRawTaxAmount(argRawTaxAmount);
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
/*      */   public BigDecimal getRawTaxPercentage() {
/*  619 */     return getDAO_().getRawTaxPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRawTaxPercentage(BigDecimal argRawTaxPercentage) {
/*  627 */     if (setRawTaxPercentage_noev(argRawTaxPercentage) && 
/*  628 */       this._events != null && 
/*  629 */       postEventsForChanges()) {
/*  630 */       this._events.post(ISaleTaxModifier.SET_RAWTAXPERCENTAGE, argRawTaxPercentage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRawTaxPercentage_noev(BigDecimal argRawTaxPercentage) {
/*  637 */     boolean ev_postable = false;
/*      */     
/*  639 */     if ((getDAO_().getRawTaxPercentage() == null && argRawTaxPercentage != null) || (
/*  640 */       getDAO_().getRawTaxPercentage() != null && !getDAO_().getRawTaxPercentage().equals(argRawTaxPercentage))) {
/*  641 */       getDAO_().setRawTaxPercentage(argRawTaxPercentage);
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
/*      */   protected BigDecimal getExemptTaxAmountImpl() {
/*  653 */     return getDAO_().getExemptTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExemptTaxAmountImpl(BigDecimal argExemptTaxAmount) {
/*  661 */     if (setExemptTaxAmount_noev(argExemptTaxAmount) && 
/*  662 */       this._events != null && 
/*  663 */       postEventsForChanges()) {
/*  664 */       this._events.post(ISaleTaxModifier.SET_EXEMPTTAXAMOUNT, argExemptTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExemptTaxAmount_noev(BigDecimal argExemptTaxAmount) {
/*  671 */     boolean ev_postable = false;
/*      */     
/*  673 */     if ((getDAO_().getExemptTaxAmount() == null && argExemptTaxAmount != null) || (
/*  674 */       getDAO_().getExemptTaxAmount() != null && !getDAO_().getExemptTaxAmount().equals(argExemptTaxAmount))) {
/*  675 */       getDAO_().setExemptTaxAmount(argExemptTaxAmount);
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
/*      */   protected BigDecimal getTaxExemptAmountImpl() {
/*  687 */     return getDAO_().getTaxExemptAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setTaxExemptAmountImpl(BigDecimal argTaxExemptAmount) {
/*  695 */     if (setTaxExemptAmount_noev(argTaxExemptAmount) && 
/*  696 */       this._events != null && 
/*  697 */       postEventsForChanges()) {
/*  698 */       this._events.post(ISaleTaxModifier.SET_TAXEXEMPTAMOUNT, argTaxExemptAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxExemptAmount_noev(BigDecimal argTaxExemptAmount) {
/*  705 */     boolean ev_postable = false;
/*      */     
/*  707 */     if ((getDAO_().getTaxExemptAmount() == null && argTaxExemptAmount != null) || (
/*  708 */       getDAO_().getTaxExemptAmount() != null && !getDAO_().getTaxExemptAmount().equals(argTaxExemptAmount))) {
/*  709 */       getDAO_().setTaxExemptAmount(argTaxExemptAmount);
/*  710 */       ev_postable = true;
/*      */     } 
/*      */     
/*  713 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxExemptionId() {
/*  721 */     return getDAO_().getTaxExemptionId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxExemptionId(String argTaxExemptionId) {
/*  729 */     if (setTaxExemptionId_noev(argTaxExemptionId) && 
/*  730 */       this._events != null && 
/*  731 */       postEventsForChanges()) {
/*  732 */       this._events.post(ISaleTaxModifier.SET_TAXEXEMPTIONID, argTaxExemptionId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxExemptionId_noev(String argTaxExemptionId) {
/*  739 */     boolean ev_postable = false;
/*      */     
/*  741 */     if ((getDAO_().getTaxExemptionId() == null && argTaxExemptionId != null) || (
/*  742 */       getDAO_().getTaxExemptionId() != null && !getDAO_().getTaxExemptionId().equals(argTaxExemptionId))) {
/*  743 */       getDAO_().setTaxExemptionId(argTaxExemptionId);
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
/*      */   protected BigDecimal getTaxOverrideAmountImpl() {
/*  755 */     return getDAO_().getTaxOverrideAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setTaxOverrideAmountImpl(BigDecimal argTaxOverrideAmount) {
/*  763 */     if (setTaxOverrideAmount_noev(argTaxOverrideAmount) && 
/*  764 */       this._events != null && 
/*  765 */       postEventsForChanges()) {
/*  766 */       this._events.post(ISaleTaxModifier.SET_TAXOVERRIDEAMOUNT, argTaxOverrideAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxOverrideAmount_noev(BigDecimal argTaxOverrideAmount) {
/*  773 */     boolean ev_postable = false;
/*      */     
/*  775 */     if ((getDAO_().getTaxOverrideAmount() == null && argTaxOverrideAmount != null) || (
/*  776 */       getDAO_().getTaxOverrideAmount() != null && !getDAO_().getTaxOverrideAmount().equals(argTaxOverrideAmount))) {
/*  777 */       getDAO_().setTaxOverrideAmount(argTaxOverrideAmount);
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
/*      */   public boolean getTaxOverride() {
/*  789 */     if (getDAO_().getTaxOverride() != null) {
/*  790 */       return getDAO_().getTaxOverride().booleanValue();
/*      */     }
/*      */     
/*  793 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxOverride(boolean argTaxOverride) {
/*  802 */     if (setTaxOverride_noev(argTaxOverride) && 
/*  803 */       this._events != null && 
/*  804 */       postEventsForChanges()) {
/*  805 */       this._events.post(ISaleTaxModifier.SET_TAXOVERRIDE, Boolean.valueOf(argTaxOverride));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxOverride_noev(boolean argTaxOverride) {
/*  812 */     boolean ev_postable = false;
/*      */     
/*  814 */     if ((getDAO_().getTaxOverride() == null && Boolean.valueOf(argTaxOverride) != null) || (
/*  815 */       getDAO_().getTaxOverride() != null && !getDAO_().getTaxOverride().equals(Boolean.valueOf(argTaxOverride)))) {
/*  816 */       getDAO_().setTaxOverride(Boolean.valueOf(argTaxOverride));
/*  817 */       ev_postable = true;
/*      */     } 
/*      */     
/*  820 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxOverridePercentage() {
/*  828 */     return getDAO_().getTaxOverridePercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setTaxOverridePercentageImpl(BigDecimal argTaxOverridePercentage) {
/*  836 */     if (setTaxOverridePercentage_noev(argTaxOverridePercentage) && 
/*  837 */       this._events != null && 
/*  838 */       postEventsForChanges()) {
/*  839 */       this._events.post(ISaleTaxModifier.SET_TAXOVERRIDEPERCENTAGE, argTaxOverridePercentage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxOverridePercentage_noev(BigDecimal argTaxOverridePercentage) {
/*  846 */     boolean ev_postable = false;
/*      */     
/*  848 */     if ((getDAO_().getTaxOverridePercentage() == null && argTaxOverridePercentage != null) || (
/*  849 */       getDAO_().getTaxOverridePercentage() != null && !getDAO_().getTaxOverridePercentage().equals(argTaxOverridePercentage))) {
/*  850 */       getDAO_().setTaxOverridePercentage(argTaxOverridePercentage);
/*  851 */       ev_postable = true;
/*      */     } 
/*      */     
/*  854 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxOverrideReasonCode() {
/*  862 */     return getDAO_().getTaxOverrideReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxOverrideReasonCode(String argTaxOverrideReasonCode) {
/*  870 */     if (setTaxOverrideReasonCode_noev(argTaxOverrideReasonCode) && 
/*  871 */       this._events != null && 
/*  872 */       postEventsForChanges()) {
/*  873 */       this._events.post(ISaleTaxModifier.SET_TAXOVERRIDEREASONCODE, argTaxOverrideReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxOverrideReasonCode_noev(String argTaxOverrideReasonCode) {
/*  880 */     boolean ev_postable = false;
/*      */     
/*  882 */     if ((getDAO_().getTaxOverrideReasonCode() == null && argTaxOverrideReasonCode != null) || (
/*  883 */       getDAO_().getTaxOverrideReasonCode() != null && !getDAO_().getTaxOverrideReasonCode().equals(argTaxOverrideReasonCode))) {
/*  884 */       getDAO_().setTaxOverrideReasonCode(argTaxOverrideReasonCode);
/*  885 */       ev_postable = true;
/*      */     } 
/*      */     
/*  888 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxOverrideComment() {
/*  896 */     return getDAO_().getTaxOverrideComment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxOverrideComment(String argTaxOverrideComment) {
/*  904 */     if (setTaxOverrideComment_noev(argTaxOverrideComment) && 
/*  905 */       this._events != null && 
/*  906 */       postEventsForChanges()) {
/*  907 */       this._events.post(ISaleTaxModifier.SET_TAXOVERRIDECOMMENT, argTaxOverrideComment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxOverrideComment_noev(String argTaxOverrideComment) {
/*  914 */     boolean ev_postable = false;
/*      */     
/*  916 */     if ((getDAO_().getTaxOverrideComment() == null && argTaxOverrideComment != null) || (
/*  917 */       getDAO_().getTaxOverrideComment() != null && !getDAO_().getTaxOverrideComment().equals(argTaxOverrideComment))) {
/*  918 */       getDAO_().setTaxOverrideComment(argTaxOverrideComment);
/*  919 */       ev_postable = true;
/*      */     } 
/*      */     
/*  922 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getTaxableAmountImpl() {
/*  930 */     return getDAO_().getTaxableAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setTaxableAmountImpl(BigDecimal argTaxableAmount) {
/*  938 */     if (setTaxableAmount_noev(argTaxableAmount) && 
/*  939 */       this._events != null && 
/*  940 */       postEventsForChanges()) {
/*  941 */       this._events.post(ISaleTaxModifier.SET_TAXABLEAMOUNT, argTaxableAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxableAmount_noev(BigDecimal argTaxableAmount) {
/*  948 */     boolean ev_postable = false;
/*      */     
/*  950 */     if ((getDAO_().getTaxableAmount() == null && argTaxableAmount != null) || (
/*  951 */       getDAO_().getTaxableAmount() != null && !getDAO_().getTaxableAmount().equals(argTaxableAmount))) {
/*  952 */       getDAO_().setTaxableAmount(argTaxableAmount);
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
/*      */   public boolean getVoid() {
/*  964 */     if (getDAO_().getVoid() != null) {
/*  965 */       return getDAO_().getVoid().booleanValue();
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
/*      */   public void setVoid(boolean argVoid) {
/*  977 */     if (setVoid_noev(argVoid) && 
/*  978 */       this._events != null && 
/*  979 */       postEventsForChanges()) {
/*  980 */       this._events.post(ISaleTaxModifier.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  987 */     boolean ev_postable = false;
/*      */     
/*  989 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  990 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  991 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
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
/*      */   public String getTaxGroupId() {
/* 1003 */     return getDAO_().getTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/* 1011 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 1012 */       this._events != null && 
/* 1013 */       postEventsForChanges()) {
/* 1014 */       this._events.post(ISaleTaxModifier.SET_TAXGROUPID, argTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 1021 */     boolean ev_postable = false;
/*      */     
/* 1023 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 1024 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 1025 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 1026 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1029 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxLocationId() {
/* 1037 */     return getDAO_().getTaxLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxLocationId(String argTaxLocationId) {
/* 1045 */     if (setTaxLocationId_noev(argTaxLocationId) && 
/* 1046 */       this._events != null && 
/* 1047 */       postEventsForChanges()) {
/* 1048 */       this._events.post(ISaleTaxModifier.SET_TAXLOCATIONID, argTaxLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxLocationId_noev(String argTaxLocationId) {
/* 1055 */     boolean ev_postable = false;
/*      */     
/* 1057 */     if ((getDAO_().getTaxLocationId() == null && argTaxLocationId != null) || (
/* 1058 */       getDAO_().getTaxLocationId() != null && !getDAO_().getTaxLocationId().equals(argTaxLocationId))) {
/* 1059 */       getDAO_().setTaxLocationId(argTaxLocationId);
/* 1060 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1063 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTaxRuleSequence() {
/* 1071 */     if (getDAO_().getTaxRuleSequence() != null) {
/* 1072 */       return getDAO_().getTaxRuleSequence().intValue();
/*      */     }
/*      */     
/* 1075 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxRuleSequence(int argTaxRuleSequence) {
/* 1084 */     if (setTaxRuleSequence_noev(argTaxRuleSequence) && 
/* 1085 */       this._events != null && 
/* 1086 */       postEventsForChanges()) {
/* 1087 */       this._events.post(ISaleTaxModifier.SET_TAXRULESEQUENCE, Integer.valueOf(argTaxRuleSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxRuleSequence_noev(int argTaxRuleSequence) {
/* 1094 */     boolean ev_postable = false;
/*      */     
/* 1096 */     if ((getDAO_().getTaxRuleSequence() == null && Integer.valueOf(argTaxRuleSequence) != null) || (
/* 1097 */       getDAO_().getTaxRuleSequence() != null && !getDAO_().getTaxRuleSequence().equals(Integer.valueOf(argTaxRuleSequence)))) {
/* 1098 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argTaxRuleSequence));
/* 1099 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1102 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthorityId() {
/* 1110 */     return getDAO_().getAuthorityId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorityId(String argAuthorityId) {
/* 1118 */     if (setAuthorityId_noev(argAuthorityId) && 
/* 1119 */       this._events != null && 
/* 1120 */       postEventsForChanges()) {
/* 1121 */       this._events.post(ISaleTaxModifier.SET_AUTHORITYID, argAuthorityId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorityId_noev(String argAuthorityId) {
/* 1128 */     boolean ev_postable = false;
/*      */     
/* 1130 */     if ((getDAO_().getAuthorityId() == null && argAuthorityId != null) || (
/* 1131 */       getDAO_().getAuthorityId() != null && !getDAO_().getAuthorityId().equals(argAuthorityId))) {
/* 1132 */       getDAO_().setAuthorityId(argAuthorityId);
/* 1133 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1136 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthorityName() {
/* 1144 */     return getDAO_().getAuthorityName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorityName(String argAuthorityName) {
/* 1152 */     if (setAuthorityName_noev(argAuthorityName) && 
/* 1153 */       this._events != null && 
/* 1154 */       postEventsForChanges()) {
/* 1155 */       this._events.post(ISaleTaxModifier.SET_AUTHORITYNAME, argAuthorityName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorityName_noev(String argAuthorityName) {
/* 1162 */     boolean ev_postable = false;
/*      */     
/* 1164 */     if ((getDAO_().getAuthorityName() == null && argAuthorityName != null) || (
/* 1165 */       getDAO_().getAuthorityName() != null && !getDAO_().getAuthorityName().equals(argAuthorityName))) {
/* 1166 */       getDAO_().setAuthorityName(argAuthorityName);
/* 1167 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1170 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAuthorityTypeCode() {
/* 1178 */     return getDAO_().getAuthorityTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthorityTypeCode(String argAuthorityTypeCode) {
/* 1186 */     if (setAuthorityTypeCode_noev(argAuthorityTypeCode) && 
/* 1187 */       this._events != null && 
/* 1188 */       postEventsForChanges()) {
/* 1189 */       this._events.post(ISaleTaxModifier.SET_AUTHORITYTYPECODE, argAuthorityTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthorityTypeCode_noev(String argAuthorityTypeCode) {
/* 1196 */     boolean ev_postable = false;
/*      */     
/* 1198 */     if ((getDAO_().getAuthorityTypeCode() == null && argAuthorityTypeCode != null) || (
/* 1199 */       getDAO_().getAuthorityTypeCode() != null && !getDAO_().getAuthorityTypeCode().equals(argAuthorityTypeCode))) {
/* 1200 */       getDAO_().setAuthorityTypeCode(argAuthorityTypeCode);
/* 1201 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1204 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxOverrideBracket() {
/* 1212 */     return getDAO_().getTaxOverrideBracket();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxOverrideBracket(String argTaxOverrideBracket) {
/* 1220 */     if (setTaxOverrideBracket_noev(argTaxOverrideBracket) && 
/* 1221 */       this._events != null && 
/* 1222 */       postEventsForChanges()) {
/* 1223 */       this._events.post(ISaleTaxModifier.SET_TAXOVERRIDEBRACKET, argTaxOverrideBracket);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxOverrideBracket_noev(String argTaxOverrideBracket) {
/* 1230 */     boolean ev_postable = false;
/*      */     
/* 1232 */     if ((getDAO_().getTaxOverrideBracket() == null && argTaxOverrideBracket != null) || (
/* 1233 */       getDAO_().getTaxOverrideBracket() != null && !getDAO_().getTaxOverrideBracket().equals(argTaxOverrideBracket))) {
/* 1234 */       getDAO_().setTaxOverrideBracket(argTaxOverrideBracket);
/* 1235 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1238 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOrigTaxableAmount() {
/* 1246 */     return getDAO_().getOrigTaxableAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigTaxableAmount(BigDecimal argOrigTaxableAmount) {
/* 1254 */     if (setOrigTaxableAmount_noev(argOrigTaxableAmount) && 
/* 1255 */       this._events != null && 
/* 1256 */       postEventsForChanges()) {
/* 1257 */       this._events.post(ISaleTaxModifier.SET_ORIGTAXABLEAMOUNT, argOrigTaxableAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigTaxableAmount_noev(BigDecimal argOrigTaxableAmount) {
/* 1264 */     boolean ev_postable = false;
/*      */     
/* 1266 */     if ((getDAO_().getOrigTaxableAmount() == null && argOrigTaxableAmount != null) || (
/* 1267 */       getDAO_().getOrigTaxableAmount() != null && !getDAO_().getOrigTaxableAmount().equals(argOrigTaxableAmount))) {
/* 1268 */       getDAO_().setOrigTaxableAmount(argOrigTaxableAmount);
/* 1269 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1272 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrigTaxGroupId() {
/* 1280 */     return getDAO_().getOrigTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrigTaxGroupId(String argOrigTaxGroupId) {
/* 1288 */     if (setOrigTaxGroupId_noev(argOrigTaxGroupId) && 
/* 1289 */       this._events != null && 
/* 1290 */       postEventsForChanges()) {
/* 1291 */       this._events.post(ISaleTaxModifier.SET_ORIGTAXGROUPID, argOrigTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrigTaxGroupId_noev(String argOrigTaxGroupId) {
/* 1298 */     boolean ev_postable = false;
/*      */     
/* 1300 */     if ((getDAO_().getOrigTaxGroupId() == null && argOrigTaxGroupId != null) || (
/* 1301 */       getDAO_().getOrigTaxGroupId() != null && !getDAO_().getOrigTaxGroupId().equals(argOrigTaxGroupId))) {
/* 1302 */       getDAO_().setOrigTaxGroupId(argOrigTaxGroupId);
/* 1303 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1306 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ISaleTaxModifierProperty newProperty(String argPropertyName) {
/* 1310 */     SaleTaxModifierPropertyId id = new SaleTaxModifierPropertyId();
/*      */     
/* 1312 */     id.setBusinessDate(getBusinessDate());
/* 1313 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 1314 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 1315 */     id.setSaleTaxModifierSequence(Integer.valueOf(getSaleTaxModifierSequence()));
/* 1316 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 1317 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 1318 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1320 */     ISaleTaxModifierProperty prop = (ISaleTaxModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ISaleTaxModifierProperty.class);
/* 1321 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "SaleTaxGroupRule")
/*      */   public ITaxGroupRule getSaleTaxGroupRule() {
/* 1333 */     return this._saleTaxGroupRule;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSaleTaxGroupRule(ITaxGroupRule argSaleTaxGroupRule) {
/* 1338 */     if (argSaleTaxGroupRule == null) {
/*      */       
/* 1340 */       getDAO_().setTaxGroupId(null);
/* 1341 */       getDAO_().setTaxLocationId(null);
/* 1342 */       getDAO_().setTaxRuleSequence(null);
/* 1343 */       if (this._saleTaxGroupRule != null)
/*      */       {
/* 1345 */         if (postEventsForChanges()) {
/* 1346 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._saleTaxGroupRule));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1351 */       getDAO_().setTaxGroupId(argSaleTaxGroupRule.getTaxGroupId());
/* 1352 */       getDAO_().setTaxLocationId(argSaleTaxGroupRule.getTaxLocationId());
/* 1353 */       getDAO_().setTaxRuleSequence(Integer.valueOf(argSaleTaxGroupRule.getTaxRuleSequence()));
/*      */       
/* 1355 */       if (postEventsForChanges()) {
/* 1356 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleTaxGroupRule));
/*      */       }
/*      */     } 
/*      */     
/* 1360 */     this._saleTaxGroupRule = argSaleTaxGroupRule;
/* 1361 */     if (postEventsForChanges()) {
/* 1362 */       this._events.post(ISaleTaxModifier.SET_SALETAXGROUPRULE, argSaleTaxGroupRule);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ISaleTaxModifierProperty> getProperties() {
/* 1368 */     if (this._properties == null) {
/* 1369 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1371 */     return (List<ISaleTaxModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ISaleTaxModifierProperty> argProperties) {
/* 1375 */     if (this._properties == null) {
/* 1376 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1378 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1381 */     for (ISaleTaxModifierProperty child : this._properties) {
/* 1382 */       SaleTaxModifierPropertyModel model = (SaleTaxModifierPropertyModel)child;
/* 1383 */       model.setBusinessDate_noev(getBusinessDate());
/* 1384 */       model.setOrganizationId_noev(getOrganizationId());
/* 1385 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1386 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 1387 */       model.setSaleTaxModifierSequence_noev(getSaleTaxModifierSequence());
/* 1388 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 1389 */       model.setWorkstationId_noev(getWorkstationId());
/* 1390 */       if (child instanceof IDataModelImpl) {
/* 1391 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1392 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1393 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1394 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1397 */       if (postEventsForChanges()) {
/* 1398 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addSaleTaxModifierProperty(ISaleTaxModifierProperty argSaleTaxModifierProperty) {
/* 1404 */     if (this._properties == null) {
/* 1405 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1407 */     argSaleTaxModifierProperty.setBusinessDate(getBusinessDate());
/* 1408 */     argSaleTaxModifierProperty.setOrganizationId(getOrganizationId());
/* 1409 */     argSaleTaxModifierProperty.setRetailLocationId(getRetailLocationId());
/* 1410 */     argSaleTaxModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 1411 */     argSaleTaxModifierProperty.setSaleTaxModifierSequence(getSaleTaxModifierSequence());
/* 1412 */     argSaleTaxModifierProperty.setTransactionSequence(getTransactionSequence());
/* 1413 */     argSaleTaxModifierProperty.setWorkstationId(getWorkstationId());
/* 1414 */     if (argSaleTaxModifierProperty instanceof IDataModelImpl) {
/* 1415 */       IDataAccessObject childDao = ((IDataModelImpl)argSaleTaxModifierProperty).getDAO();
/* 1416 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1417 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1418 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1423 */     if (postEventsForChanges()) {
/* 1424 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleTaxModifierProperty));
/*      */     }
/*      */     
/* 1427 */     this._properties.add(argSaleTaxModifierProperty);
/* 1428 */     if (postEventsForChanges()) {
/* 1429 */       this._events.post(ISaleTaxModifier.ADD_PROPERTIES, argSaleTaxModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeSaleTaxModifierProperty(ISaleTaxModifierProperty argSaleTaxModifierProperty) {
/* 1434 */     if (this._properties != null) {
/*      */       
/* 1436 */       if (postEventsForChanges()) {
/* 1437 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleTaxModifierProperty));
/*      */       }
/* 1439 */       this._properties.remove(argSaleTaxModifierProperty);
/* 1440 */       if (postEventsForChanges()) {
/* 1441 */         this._events.post(ISaleTaxModifier.REMOVE_PROPERTIES, argSaleTaxModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/* 1447 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public ISaleReturnLineItem getParentLine() {
/* 1451 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1456 */     if ("SaleTaxGroupRule".equals(argFieldId)) {
/* 1457 */       return getSaleTaxGroupRule();
/*      */     }
/* 1459 */     if ("Properties".equals(argFieldId)) {
/* 1460 */       return getProperties();
/*      */     }
/* 1462 */     if ("SaleTaxModifierExtension".equals(argFieldId)) {
/* 1463 */       return this._myExtension;
/*      */     }
/*      */     
/* 1466 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1472 */     if ("SaleTaxGroupRule".equals(argFieldId)) {
/* 1473 */       setSaleTaxGroupRule((ITaxGroupRule)argValue);
/*      */     }
/* 1475 */     else if ("Properties".equals(argFieldId)) {
/* 1476 */       setProperties(changeToList(argValue, ISaleTaxModifierProperty.class));
/*      */     }
/* 1478 */     else if ("SaleTaxModifierExtension".equals(argFieldId)) {
/* 1479 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1482 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1488 */     this._persistenceDefaults = argPD;
/* 1489 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1490 */     this._eventManager = argEM;
/* 1491 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1492 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1493 */     if (this._saleTaxGroupRule != null) {
/* 1494 */       ((IDataModelImpl)this._saleTaxGroupRule).setDependencies(argPD, argEM);
/*      */     }
/* 1496 */     if (this._properties != null) {
/* 1497 */       for (ISaleTaxModifierProperty relationship : this._properties) {
/* 1498 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getSaleTaxModifierExt() {
/* 1504 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setSaleTaxModifierExt(IDataModel argExt) {
/* 1508 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1513 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1517 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1520 */     super.startTransaction();
/*      */     
/* 1522 */     this._saleTaxGroupRuleSavepoint = this._saleTaxGroupRule;
/* 1523 */     if (this._saleTaxGroupRule != null) {
/* 1524 */       this._saleTaxGroupRule.startTransaction();
/*      */     }
/*      */     
/* 1527 */     this._propertiesSavepoint = this._properties;
/* 1528 */     if (this._properties != null) {
/* 1529 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1530 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1531 */       while (it.hasNext()) {
/* 1532 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1537 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1542 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1545 */     super.rollbackChanges();
/*      */     
/* 1547 */     this._saleTaxGroupRule = this._saleTaxGroupRuleSavepoint;
/* 1548 */     this._saleTaxGroupRuleSavepoint = null;
/* 1549 */     if (this._saleTaxGroupRule != null) {
/* 1550 */       this._saleTaxGroupRule.rollbackChanges();
/*      */     }
/*      */     
/* 1553 */     this._properties = this._propertiesSavepoint;
/* 1554 */     this._propertiesSavepoint = null;
/* 1555 */     if (this._properties != null) {
/* 1556 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1557 */       while (it.hasNext()) {
/* 1558 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1566 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1569 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1572 */     super.commitTransaction();
/*      */     
/* 1574 */     this._saleTaxGroupRuleSavepoint = this._saleTaxGroupRule;
/* 1575 */     if (this._saleTaxGroupRule != null) {
/* 1576 */       this._saleTaxGroupRule.commitTransaction();
/*      */     }
/*      */     
/* 1579 */     this._propertiesSavepoint = this._properties;
/* 1580 */     if (this._properties != null) {
/* 1581 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1582 */       while (it.hasNext()) {
/* 1583 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1585 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1589 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1594 */     argStream.defaultReadObject();
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
/*      */   public TaxExemptionId getTaxExemptionIdObject() {
/* 1609 */     if (getTaxExemptionId() == null || getTaxExemptionId().length() == 0) {
/* 1610 */       return null;
/*      */     }
/* 1612 */     TaxExemptionId id = new TaxExemptionId();
/* 1613 */     id.setTaxExemptionId(getTaxExemptionId());
/* 1614 */     return id;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxAmount() {
/* 1621 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1623 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getTaxAmountImpl()) : getTaxAmountImpl();
/*      */     
/* 1625 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxAmount(BigDecimal argTaxAmount) {
/* 1632 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1634 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argTaxAmount) : argTaxAmount;
/* 1635 */     setTaxAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExemptTaxAmount() {
/* 1642 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1644 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getExemptTaxAmountImpl()) : getExemptTaxAmountImpl();
/*      */     
/* 1646 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExemptTaxAmount(BigDecimal argExemptTaxAmount) {
/* 1653 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1655 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argExemptTaxAmount) : argExemptTaxAmount;
/* 1656 */     setExemptTaxAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxExemptAmount() {
/* 1663 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1665 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getTaxExemptAmountImpl()) : getTaxExemptAmountImpl();
/*      */     
/* 1667 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxExemptAmount(BigDecimal argTaxExemptAmount) {
/* 1674 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1676 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argTaxExemptAmount) : argTaxExemptAmount;
/* 1677 */     setTaxExemptAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getRawTaxAmount() {
/* 1684 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1686 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getRawTaxAmountImpl()) : getRawTaxAmountImpl();
/*      */     
/* 1688 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRawTaxAmount(BigDecimal argRawTaxAmount) {
/* 1695 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1697 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argRawTaxAmount) : argRawTaxAmount;
/* 1698 */     setRawTaxAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxableAmount() {
/* 1705 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1707 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getTaxableAmountImpl()) : getTaxableAmountImpl();
/*      */     
/* 1709 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxableAmount(BigDecimal argTaxableAmount) {
/* 1716 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1718 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argTaxableAmount) : argTaxableAmount;
/* 1719 */     setTaxableAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxOverrideAmount() {
/* 1726 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1728 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getTaxOverrideAmountImpl()) : getTaxOverrideAmountImpl();
/*      */     
/* 1730 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxOverrideAmount(BigDecimal argOverrideAmount) {
/* 1737 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1739 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argOverrideAmount) : argOverrideAmount;
/* 1740 */     setTaxOverrideAmountImpl(relativeAmount);
/*      */     
/* 1742 */     if (argOverrideAmount != null) {
/* 1743 */       setTaxOverridePercentage((BigDecimal)null);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxOverridePercentage(BigDecimal argOverridePercentage) {
/* 1751 */     setTaxOverridePercentageImpl(argOverridePercentage);
/*      */     
/* 1753 */     if (argOverridePercentage != null) {
/* 1754 */       setTaxOverrideAmountImpl((BigDecimal)null);
/*      */     }
/*      */   }
/*      */   
/*      */   public BigDecimal getTranTaxableAmt() {
/* 1759 */     return this._tranTaxableAmt;
/*      */   }
/*      */   
/*      */   public void setTranTaxableAmt(BigDecimal tranTaxableAmt) {
/* 1763 */     this._tranTaxableAmt = tranTaxableAmt;
/*      */   }
/*      */   
/*      */   public Date getBeginDateTimestamp() {
/* 1767 */     ISaleReturnLineItem parentLine = getParentLine();
/* 1768 */     if (parentLine != null) {
/* 1769 */       return parentLine.getBeginDateTimestamp();
/*      */     }
/* 1771 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleTaxModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */