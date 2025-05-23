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
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.NumberUtils;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.dsc.IDiscount;
/*      */ import dtv.xst.dao.trl.IDiscountLineItem;
/*      */ import dtv.xst.dao.trl.IRetailPriceModifier;
/*      */ import dtv.xst.dao.trl.IRetailPriceModifierProperty;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import dtv.xst.dao.trl.RetailPriceModifierPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class RetailPriceModifierModel extends AbstractDataModelWithPropertyImpl<IRetailPriceModifierProperty> implements IRetailPriceModifier {
/*      */   private static final long serialVersionUID = 1985659613L;
/*      */   private ISaleReturnLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDiscount _discount; private transient IDiscount _discountSavepoint; private IRetailTransactionLineItem _reasonLineItem; private transient IRetailTransactionLineItem _reasonLineItemSavepoint; private HistoricalList<IRetailPriceModifierProperty> _properties; private transient HistoricalList<IRetailPriceModifierProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new RetailPriceModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private RetailPriceModifierDAO getDAO_() {
/*   50 */     return (RetailPriceModifierDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*   58 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*   66 */     if (setBusinessDate_noev(argBusinessDate) && 
/*   67 */       this._events != null && 
/*   68 */       postEventsForChanges()) {
/*   69 */       this._events.post(IRetailPriceModifier.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*   76 */     boolean ev_postable = false;
/*      */     
/*   78 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*   79 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*   80 */       getDAO_().setBusinessDate(argBusinessDate);
/*   81 */       ev_postable = true;
/*   82 */       if (this._properties != null) {
/*      */         
/*   84 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*   85 */         while (it.hasNext())
/*      */         {
/*   87 */           ((RetailPriceModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   92 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  100 */     if (getDAO_().getOrganizationId() != null) {
/*  101 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  104 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  113 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  114 */       this._events != null && 
/*  115 */       postEventsForChanges()) {
/*  116 */       this._events.post(IRetailPriceModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  123 */     boolean ev_postable = false;
/*      */     
/*  125 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  126 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  127 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  128 */       ev_postable = true;
/*  129 */       if (this._properties != null) {
/*      */         
/*  131 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*  132 */         while (it.hasNext())
/*      */         {
/*  134 */           ((RetailPriceModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  139 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  147 */     if (getDAO_().getRetailLocationId() != null) {
/*  148 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  151 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  160 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  161 */       this._events != null && 
/*  162 */       postEventsForChanges()) {
/*  163 */       this._events.post(IRetailPriceModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  170 */     boolean ev_postable = false;
/*      */     
/*  172 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  173 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  174 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  175 */       ev_postable = true;
/*  176 */       if (this._properties != null) {
/*      */         
/*  178 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*  179 */         while (it.hasNext())
/*      */         {
/*  181 */           ((RetailPriceModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  186 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailPriceModifierSequenceNbr() {
/*  194 */     if (getDAO_().getRetailPriceModifierSequenceNbr() != null) {
/*  195 */       return getDAO_().getRetailPriceModifierSequenceNbr().intValue();
/*      */     }
/*      */     
/*  198 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailPriceModifierSequenceNbr(int argRetailPriceModifierSequenceNbr) {
/*  207 */     if (setRetailPriceModifierSequenceNbr_noev(argRetailPriceModifierSequenceNbr) && 
/*  208 */       this._events != null && 
/*  209 */       postEventsForChanges()) {
/*  210 */       this._events.post(IRetailPriceModifier.SET_RETAILPRICEMODIFIERSEQUENCENBR, Integer.valueOf(argRetailPriceModifierSequenceNbr));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailPriceModifierSequenceNbr_noev(int argRetailPriceModifierSequenceNbr) {
/*  217 */     boolean ev_postable = false;
/*      */     
/*  219 */     if ((getDAO_().getRetailPriceModifierSequenceNbr() == null && Integer.valueOf(argRetailPriceModifierSequenceNbr) != null) || (
/*  220 */       getDAO_().getRetailPriceModifierSequenceNbr() != null && !getDAO_().getRetailPriceModifierSequenceNbr().equals(Integer.valueOf(argRetailPriceModifierSequenceNbr)))) {
/*  221 */       getDAO_().setRetailPriceModifierSequenceNbr(Integer.valueOf(argRetailPriceModifierSequenceNbr));
/*  222 */       ev_postable = true;
/*  223 */       if (this._properties != null) {
/*      */         
/*  225 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*  226 */         while (it.hasNext())
/*      */         {
/*  228 */           ((RetailPriceModifierPropertyModel)it.next()).setRetailPriceModifierSequenceNbr_noev(argRetailPriceModifierSequenceNbr);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  233 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  241 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  242 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  245 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  254 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  255 */       this._events != null && 
/*  256 */       postEventsForChanges()) {
/*  257 */       this._events.post(IRetailPriceModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  264 */     boolean ev_postable = false;
/*      */     
/*  266 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  267 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  268 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  269 */       ev_postable = true;
/*  270 */       if (this._properties != null) {
/*      */         
/*  272 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*  273 */         while (it.hasNext())
/*      */         {
/*  275 */           ((RetailPriceModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  280 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  288 */     if (getDAO_().getTransactionSequence() != null) {
/*  289 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  292 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  301 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  302 */       this._events != null && 
/*  303 */       postEventsForChanges()) {
/*  304 */       this._events.post(IRetailPriceModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  311 */     boolean ev_postable = false;
/*      */     
/*  313 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  314 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  315 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  316 */       ev_postable = true;
/*  317 */       if (this._properties != null) {
/*      */         
/*  319 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*  320 */         while (it.hasNext())
/*      */         {
/*  322 */           ((RetailPriceModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  327 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  335 */     if (getDAO_().getWorkstationId() != null) {
/*  336 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  339 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  348 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  349 */       this._events != null && 
/*  350 */       postEventsForChanges()) {
/*  351 */       this._events.post(IRetailPriceModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  358 */     boolean ev_postable = false;
/*      */     
/*  360 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  361 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  362 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  363 */       ev_postable = true;
/*  364 */       if (this._properties != null) {
/*      */         
/*  366 */         Iterator<RetailPriceModifierPropertyModel> it = this._properties.iterator();
/*  367 */         while (it.hasNext())
/*      */         {
/*  369 */           ((RetailPriceModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  374 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  382 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  390 */     if (setCreateDate_noev(argCreateDate) && 
/*  391 */       this._events != null && 
/*  392 */       postEventsForChanges()) {
/*  393 */       this._events.post(IRetailPriceModifier.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  400 */     boolean ev_postable = false;
/*      */     
/*  402 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  403 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  404 */       getDAO_().setCreateDate(argCreateDate);
/*  405 */       ev_postable = true;
/*      */     } 
/*      */     
/*  408 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  416 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  424 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  425 */       this._events != null && 
/*  426 */       postEventsForChanges()) {
/*  427 */       this._events.post(IRetailPriceModifier.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  434 */     boolean ev_postable = false;
/*      */     
/*  436 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  437 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  438 */       getDAO_().setCreateUserId(argCreateUserId);
/*  439 */       ev_postable = true;
/*      */     } 
/*      */     
/*  442 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  450 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  458 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  459 */       this._events != null && 
/*  460 */       postEventsForChanges()) {
/*  461 */       this._events.post(IRetailPriceModifier.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  468 */     boolean ev_postable = false;
/*      */     
/*  470 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  471 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  472 */       getDAO_().setUpdateDate(argUpdateDate);
/*  473 */       ev_postable = true;
/*      */     } 
/*      */     
/*  476 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  484 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  492 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  493 */       this._events != null && 
/*  494 */       postEventsForChanges()) {
/*  495 */       this._events.post(IRetailPriceModifier.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  502 */     boolean ev_postable = false;
/*      */     
/*  504 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  505 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  506 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  507 */       ev_postable = true;
/*      */     } 
/*      */     
/*  510 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getAmountImpl() {
/*  518 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setAmountImpl(BigDecimal argAmount) {
/*  526 */     if (setAmount_noev(argAmount) && 
/*  527 */       this._events != null && 
/*  528 */       postEventsForChanges()) {
/*  529 */       this._events.post(IRetailPriceModifier.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  536 */     boolean ev_postable = false;
/*      */     
/*  538 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  539 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  540 */       getDAO_().setAmount(argAmount);
/*  541 */       ev_postable = true;
/*      */     } 
/*      */     
/*  544 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getExtendedAmountImpl() {
/*  552 */     return getDAO_().getExtendedAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExtendedAmountImpl(BigDecimal argExtendedAmount) {
/*  560 */     if (setExtendedAmount_noev(argExtendedAmount) && 
/*  561 */       this._events != null && 
/*  562 */       postEventsForChanges()) {
/*  563 */       this._events.post(IRetailPriceModifier.SET_EXTENDEDAMOUNT, argExtendedAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtendedAmount_noev(BigDecimal argExtendedAmount) {
/*  570 */     boolean ev_postable = false;
/*      */     
/*  572 */     if ((getDAO_().getExtendedAmount() == null && argExtendedAmount != null) || (
/*  573 */       getDAO_().getExtendedAmount() != null && !getDAO_().getExtendedAmount().equals(argExtendedAmount))) {
/*  574 */       getDAO_().setExtendedAmount(argExtendedAmount);
/*  575 */       ev_postable = true;
/*      */     } 
/*      */     
/*  578 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNotes() {
/*  586 */     return getDAO_().getNotes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotes(String argNotes) {
/*  594 */     if (setNotes_noev(argNotes) && 
/*  595 */       this._events != null && 
/*  596 */       postEventsForChanges()) {
/*  597 */       this._events.post(IRetailPriceModifier.SET_NOTES, argNotes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotes_noev(String argNotes) {
/*  604 */     boolean ev_postable = false;
/*      */     
/*  606 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/*  607 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/*  608 */       getDAO_().setNotes(argNotes);
/*  609 */       ev_postable = true;
/*      */     } 
/*      */     
/*  612 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  620 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  628 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  629 */       this._events != null && 
/*  630 */       postEventsForChanges()) {
/*  631 */       this._events.post(IRetailPriceModifier.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  638 */     boolean ev_postable = false;
/*      */     
/*  640 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  641 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  642 */       getDAO_().setSerialNumber(argSerialNumber);
/*  643 */       ev_postable = true;
/*      */     } 
/*      */     
/*  646 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPercent() {
/*  654 */     return getDAO_().getPercent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPercent(BigDecimal argPercent) {
/*  662 */     if (setPercent_noev(argPercent) && 
/*  663 */       this._events != null && 
/*  664 */       postEventsForChanges()) {
/*  665 */       this._events.post(IRetailPriceModifier.SET_PERCENT, argPercent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPercent_noev(BigDecimal argPercent) {
/*  672 */     boolean ev_postable = false;
/*      */     
/*  674 */     if ((getDAO_().getPercent() == null && argPercent != null) || (
/*  675 */       getDAO_().getPercent() != null && !getDAO_().getPercent().equals(argPercent))) {
/*  676 */       getDAO_().setPercent(argPercent);
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
/*      */   protected BigDecimal getPriceChangeAmountImpl() {
/*  688 */     return getDAO_().getPriceChangeAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setPriceChangeAmountImpl(BigDecimal argPriceChangeAmount) {
/*  696 */     if (setPriceChangeAmount_noev(argPriceChangeAmount) && 
/*  697 */       this._events != null && 
/*  698 */       postEventsForChanges()) {
/*  699 */       this._events.post(IRetailPriceModifier.SET_PRICECHANGEAMOUNT, argPriceChangeAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriceChangeAmount_noev(BigDecimal argPriceChangeAmount) {
/*  706 */     boolean ev_postable = false;
/*      */     
/*  708 */     if ((getDAO_().getPriceChangeAmount() == null && argPriceChangeAmount != null) || (
/*  709 */       getDAO_().getPriceChangeAmount() != null && !getDAO_().getPriceChangeAmount().equals(argPriceChangeAmount))) {
/*  710 */       getDAO_().setPriceChangeAmount(argPriceChangeAmount);
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
/*      */   public String getPriceChangeReasonCode() {
/*  722 */     return getDAO_().getPriceChangeReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriceChangeReasonCode(String argPriceChangeReasonCode) {
/*  730 */     if (setPriceChangeReasonCode_noev(argPriceChangeReasonCode) && 
/*  731 */       this._events != null && 
/*  732 */       postEventsForChanges()) {
/*  733 */       this._events.post(IRetailPriceModifier.SET_PRICECHANGEREASONCODE, argPriceChangeReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriceChangeReasonCode_noev(String argPriceChangeReasonCode) {
/*  740 */     boolean ev_postable = false;
/*      */     
/*  742 */     if ((getDAO_().getPriceChangeReasonCode() == null && argPriceChangeReasonCode != null) || (
/*  743 */       getDAO_().getPriceChangeReasonCode() != null && !getDAO_().getPriceChangeReasonCode().equals(argPriceChangeReasonCode))) {
/*  744 */       getDAO_().setPriceChangeReasonCode(argPriceChangeReasonCode);
/*  745 */       ev_postable = true;
/*      */     } 
/*      */     
/*  748 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromotionId() {
/*  756 */     return getDAO_().getPromotionId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromotionId(String argPromotionId) {
/*  764 */     if (setPromotionId_noev(argPromotionId) && 
/*  765 */       this._events != null && 
/*  766 */       postEventsForChanges()) {
/*  767 */       this._events.post(IRetailPriceModifier.SET_PROMOTIONID, argPromotionId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromotionId_noev(String argPromotionId) {
/*  774 */     boolean ev_postable = false;
/*      */     
/*  776 */     if ((getDAO_().getPromotionId() == null && argPromotionId != null) || (
/*  777 */       getDAO_().getPromotionId() != null && !getDAO_().getPromotionId().equals(argPromotionId))) {
/*  778 */       getDAO_().setPromotionId(argPromotionId);
/*  779 */       ev_postable = true;
/*      */     } 
/*      */     
/*  782 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescription() {
/*  790 */     return getDAO_().getDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  798 */     if (setDescription_noev(argDescription) && 
/*  799 */       this._events != null && 
/*  800 */       postEventsForChanges()) {
/*  801 */       this._events.post(IRetailPriceModifier.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  808 */     boolean ev_postable = false;
/*      */     
/*  810 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  811 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  812 */       getDAO_().setDescription(argDescription);
/*  813 */       ev_postable = true;
/*      */     } 
/*      */     
/*  816 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRetailPriceModifierReasonCode() {
/*  824 */     return getDAO_().getRetailPriceModifierReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailPriceModifierReasonCode(String argRetailPriceModifierReasonCode) {
/*  832 */     if (setRetailPriceModifierReasonCode_noev(argRetailPriceModifierReasonCode) && 
/*  833 */       this._events != null && 
/*  834 */       postEventsForChanges()) {
/*  835 */       this._events.post(IRetailPriceModifier.SET_RETAILPRICEMODIFIERREASONCODE, argRetailPriceModifierReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailPriceModifierReasonCode_noev(String argRetailPriceModifierReasonCode) {
/*  842 */     boolean ev_postable = false;
/*      */     
/*  844 */     if ((getDAO_().getRetailPriceModifierReasonCode() == null && argRetailPriceModifierReasonCode != null) || (
/*  845 */       getDAO_().getRetailPriceModifierReasonCode() != null && !getDAO_().getRetailPriceModifierReasonCode().equals(argRetailPriceModifierReasonCode))) {
/*  846 */       getDAO_().setRetailPriceModifierReasonCode(argRetailPriceModifierReasonCode);
/*  847 */       ev_postable = true;
/*      */     } 
/*      */     
/*  850 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/*  858 */     if (getDAO_().getVoid() != null) {
/*  859 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/*  862 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/*  871 */     if (setVoid_noev(argVoid) && 
/*  872 */       this._events != null && 
/*  873 */       postEventsForChanges()) {
/*  874 */       this._events.post(IRetailPriceModifier.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  881 */     boolean ev_postable = false;
/*      */     
/*  883 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  884 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  885 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/*  886 */       ev_postable = true;
/*      */     } 
/*      */     
/*  889 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDiscountGroupId() {
/*  897 */     if (getDAO_().getDiscountGroupId() != null) {
/*  898 */       return getDAO_().getDiscountGroupId().intValue();
/*      */     }
/*      */     
/*  901 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscountGroupId(int argDiscountGroupId) {
/*  910 */     if (setDiscountGroupId_noev(argDiscountGroupId) && 
/*  911 */       this._events != null && 
/*  912 */       postEventsForChanges()) {
/*  913 */       this._events.post(IRetailPriceModifier.SET_DISCOUNTGROUPID, Integer.valueOf(argDiscountGroupId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscountGroupId_noev(int argDiscountGroupId) {
/*  920 */     boolean ev_postable = false;
/*      */     
/*  922 */     if ((getDAO_().getDiscountGroupId() == null && Integer.valueOf(argDiscountGroupId) != null) || (
/*  923 */       getDAO_().getDiscountGroupId() != null && !getDAO_().getDiscountGroupId().equals(Integer.valueOf(argDiscountGroupId)))) {
/*  924 */       getDAO_().setDiscountGroupId(Integer.valueOf(argDiscountGroupId));
/*  925 */       ev_postable = true;
/*      */     } 
/*      */     
/*  928 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDealId() {
/*  936 */     return getDAO_().getDealId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDealId(String argDealId) {
/*  944 */     if (setDealId_noev(argDealId) && 
/*  945 */       this._events != null && 
/*  946 */       postEventsForChanges()) {
/*  947 */       this._events.post(IRetailPriceModifier.SET_DEALID, argDealId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDealId_noev(String argDealId) {
/*  954 */     boolean ev_postable = false;
/*      */     
/*  956 */     if ((getDAO_().getDealId() == null && argDealId != null) || (
/*  957 */       getDAO_().getDealId() != null && !getDAO_().getDealId().equals(argDealId))) {
/*  958 */       getDAO_().setDealId(argDealId);
/*  959 */       ev_postable = true;
/*      */     } 
/*      */     
/*  962 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDiscountCode() {
/*  970 */     return getDAO_().getDiscountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscountCode(String argDiscountCode) {
/*  978 */     if (setDiscountCode_noev(argDiscountCode) && 
/*  979 */       this._events != null && 
/*  980 */       postEventsForChanges()) {
/*  981 */       this._events.post(IRetailPriceModifier.SET_DISCOUNTCODE, argDiscountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscountCode_noev(String argDiscountCode) {
/*  988 */     boolean ev_postable = false;
/*      */     
/*  990 */     if ((getDAO_().getDiscountCode() == null && argDiscountCode != null) || (
/*  991 */       getDAO_().getDiscountCode() != null && !getDAO_().getDiscountCode().equals(argDiscountCode))) {
/*  992 */       getDAO_().setDiscountCode(argDiscountCode);
/*  993 */       ev_postable = true;
/*      */     } 
/*      */     
/*  996 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDiscBusinessDate() {
/* 1004 */     return getDAO_().getDiscBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscBusinessDate(Date argDiscBusinessDate) {
/* 1012 */     if (setDiscBusinessDate_noev(argDiscBusinessDate) && 
/* 1013 */       this._events != null && 
/* 1014 */       postEventsForChanges()) {
/* 1015 */       this._events.post(IRetailPriceModifier.SET_DISCBUSINESSDATE, argDiscBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscBusinessDate_noev(Date argDiscBusinessDate) {
/* 1022 */     boolean ev_postable = false;
/*      */     
/* 1024 */     if ((getDAO_().getDiscBusinessDate() == null && argDiscBusinessDate != null) || (
/* 1025 */       getDAO_().getDiscBusinessDate() != null && !getDAO_().getDiscBusinessDate().equals(argDiscBusinessDate))) {
/* 1026 */       getDAO_().setDiscBusinessDate(argDiscBusinessDate);
/* 1027 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1030 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getDiscRetailLocationId() {
/* 1038 */     if (getDAO_().getDiscRetailLocationId() != null) {
/* 1039 */       return getDAO_().getDiscRetailLocationId().longValue();
/*      */     }
/*      */     
/* 1042 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscRetailLocationId(long argDiscRetailLocationId) {
/* 1051 */     if (setDiscRetailLocationId_noev(argDiscRetailLocationId) && 
/* 1052 */       this._events != null && 
/* 1053 */       postEventsForChanges()) {
/* 1054 */       this._events.post(IRetailPriceModifier.SET_DISCRETAILLOCATIONID, Long.valueOf(argDiscRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscRetailLocationId_noev(long argDiscRetailLocationId) {
/* 1061 */     boolean ev_postable = false;
/*      */     
/* 1063 */     if ((getDAO_().getDiscRetailLocationId() == null && Long.valueOf(argDiscRetailLocationId) != null) || (
/* 1064 */       getDAO_().getDiscRetailLocationId() != null && !getDAO_().getDiscRetailLocationId().equals(Long.valueOf(argDiscRetailLocationId)))) {
/* 1065 */       getDAO_().setDiscRetailLocationId(Long.valueOf(argDiscRetailLocationId));
/* 1066 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1069 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDiscRetailTransactionLineItemSequence() {
/* 1077 */     if (getDAO_().getDiscRetailTransactionLineItemSequence() != null) {
/* 1078 */       return getDAO_().getDiscRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/* 1081 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscRetailTransactionLineItemSequence(int argDiscRetailTransactionLineItemSequence) {
/* 1090 */     if (setDiscRetailTransactionLineItemSequence_noev(argDiscRetailTransactionLineItemSequence) && 
/* 1091 */       this._events != null && 
/* 1092 */       postEventsForChanges()) {
/* 1093 */       this._events.post(IRetailPriceModifier.SET_DISCRETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argDiscRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscRetailTransactionLineItemSequence_noev(int argDiscRetailTransactionLineItemSequence) {
/* 1100 */     boolean ev_postable = false;
/*      */     
/* 1102 */     if ((getDAO_().getDiscRetailTransactionLineItemSequence() == null && Integer.valueOf(argDiscRetailTransactionLineItemSequence) != null) || (
/* 1103 */       getDAO_().getDiscRetailTransactionLineItemSequence() != null && !getDAO_().getDiscRetailTransactionLineItemSequence().equals(Integer.valueOf(argDiscRetailTransactionLineItemSequence)))) {
/* 1104 */       getDAO_().setDiscRetailTransactionLineItemSequence(Integer.valueOf(argDiscRetailTransactionLineItemSequence));
/* 1105 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1108 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getDiscTransactionSequence() {
/* 1116 */     if (getDAO_().getDiscTransactionSequence() != null) {
/* 1117 */       return getDAO_().getDiscTransactionSequence().longValue();
/*      */     }
/*      */     
/* 1120 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscTransactionSequence(long argDiscTransactionSequence) {
/* 1129 */     if (setDiscTransactionSequence_noev(argDiscTransactionSequence) && 
/* 1130 */       this._events != null && 
/* 1131 */       postEventsForChanges()) {
/* 1132 */       this._events.post(IRetailPriceModifier.SET_DISCTRANSACTIONSEQUENCE, Long.valueOf(argDiscTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscTransactionSequence_noev(long argDiscTransactionSequence) {
/* 1139 */     boolean ev_postable = false;
/*      */     
/* 1141 */     if ((getDAO_().getDiscTransactionSequence() == null && Long.valueOf(argDiscTransactionSequence) != null) || (
/* 1142 */       getDAO_().getDiscTransactionSequence() != null && !getDAO_().getDiscTransactionSequence().equals(Long.valueOf(argDiscTransactionSequence)))) {
/* 1143 */       getDAO_().setDiscTransactionSequence(Long.valueOf(argDiscTransactionSequence));
/* 1144 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1147 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getDiscWorkstationId() {
/* 1155 */     if (getDAO_().getDiscWorkstationId() != null) {
/* 1156 */       return getDAO_().getDiscWorkstationId().longValue();
/*      */     }
/*      */     
/* 1159 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscWorkstationId(long argDiscWorkstationId) {
/* 1168 */     if (setDiscWorkstationId_noev(argDiscWorkstationId) && 
/* 1169 */       this._events != null && 
/* 1170 */       postEventsForChanges()) {
/* 1171 */       this._events.post(IRetailPriceModifier.SET_DISCWORKSTATIONID, Long.valueOf(argDiscWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscWorkstationId_noev(long argDiscWorkstationId) {
/* 1178 */     boolean ev_postable = false;
/*      */     
/* 1180 */     if ((getDAO_().getDiscWorkstationId() == null && Long.valueOf(argDiscWorkstationId) != null) || (
/* 1181 */       getDAO_().getDiscWorkstationId() != null && !getDAO_().getDiscWorkstationId().equals(Long.valueOf(argDiscWorkstationId)))) {
/* 1182 */       getDAO_().setDiscWorkstationId(Long.valueOf(argDiscWorkstationId));
/* 1183 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1186 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDiscountReasonCode() {
/* 1194 */     return getDAO_().getDiscountReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiscountReasonCode(String argDiscountReasonCode) {
/* 1202 */     if (setDiscountReasonCode_noev(argDiscountReasonCode) && 
/* 1203 */       this._events != null && 
/* 1204 */       postEventsForChanges()) {
/* 1205 */       this._events.post(IRetailPriceModifier.SET_DISCOUNTREASONCODE, argDiscountReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDiscountReasonCode_noev(String argDiscountReasonCode) {
/* 1212 */     boolean ev_postable = false;
/*      */     
/* 1214 */     if ((getDAO_().getDiscountReasonCode() == null && argDiscountReasonCode != null) || (
/* 1215 */       getDAO_().getDiscountReasonCode() != null && !getDAO_().getDiscountReasonCode().equals(argDiscountReasonCode))) {
/* 1216 */       getDAO_().setDiscountReasonCode(argDiscountReasonCode);
/* 1217 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1220 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxabilityCode() {
/* 1228 */     return getDAO_().getTaxabilityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxabilityCode(String argTaxabilityCode) {
/* 1236 */     if (setTaxabilityCode_noev(argTaxabilityCode) && 
/* 1237 */       this._events != null && 
/* 1238 */       postEventsForChanges()) {
/* 1239 */       this._events.post(IRetailPriceModifier.SET_TAXABILITYCODE, argTaxabilityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxabilityCode_noev(String argTaxabilityCode) {
/* 1246 */     boolean ev_postable = false;
/*      */     
/* 1248 */     if ((getDAO_().getTaxabilityCode() == null && argTaxabilityCode != null) || (
/* 1249 */       getDAO_().getTaxabilityCode() != null && !getDAO_().getTaxabilityCode().equals(argTaxabilityCode))) {
/* 1250 */       getDAO_().setTaxabilityCode(argTaxabilityCode);
/* 1251 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1254 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getDealAmountImpl() {
/* 1262 */     return getDAO_().getDealAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setDealAmountImpl(BigDecimal argDealAmount) {
/* 1270 */     if (setDealAmount_noev(argDealAmount) && 
/* 1271 */       this._events != null && 
/* 1272 */       postEventsForChanges()) {
/* 1273 */       this._events.post(IRetailPriceModifier.SET_DEALAMOUNT, argDealAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDealAmount_noev(BigDecimal argDealAmount) {
/* 1280 */     boolean ev_postable = false;
/*      */     
/* 1282 */     if ((getDAO_().getDealAmount() == null && argDealAmount != null) || (
/* 1283 */       getDAO_().getDealAmount() != null && !getDAO_().getDealAmount().equals(argDealAmount))) {
/* 1284 */       getDAO_().setDealAmount(argDealAmount);
/* 1285 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1288 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IRetailPriceModifierProperty newProperty(String argPropertyName) {
/* 1292 */     RetailPriceModifierPropertyId id = new RetailPriceModifierPropertyId();
/*      */     
/* 1294 */     id.setBusinessDate(getBusinessDate());
/* 1295 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 1296 */     id.setRetailPriceModifierSequenceNbr(Integer.valueOf(getRetailPriceModifierSequenceNbr()));
/* 1297 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/* 1298 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 1299 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 1300 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1302 */     IRetailPriceModifierProperty prop = (IRetailPriceModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRetailPriceModifierProperty.class);
/* 1303 */     return prop;
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
/*      */   @Relationship(name = "Discount")
/*      */   public IDiscount getDiscount() {
/* 1318 */     return this._discount;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDiscount(IDiscount argDiscount) {
/* 1323 */     if (argDiscount == null) {
/*      */       
/* 1325 */       getDAO_().setDiscountCode(null);
/* 1326 */       if (this._discount != null)
/*      */       {
/* 1328 */         if (postEventsForChanges()) {
/* 1329 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._discount));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1334 */       getDAO_().setDiscountCode(argDiscount.getDiscountCode());
/*      */       
/* 1336 */       if (postEventsForChanges()) {
/* 1337 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDiscount));
/*      */       }
/*      */     } 
/*      */     
/* 1341 */     this._discount = argDiscount;
/* 1342 */     if (postEventsForChanges()) {
/* 1343 */       this._events.post(IRetailPriceModifier.SET_DISCOUNT, argDiscount);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "ReasonLineItem")
/*      */   public IRetailTransactionLineItem getReasonLineItem() {
/* 1349 */     return this._reasonLineItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setReasonLineItem(IRetailTransactionLineItem argReasonLineItem) {
/* 1354 */     if (argReasonLineItem == null) {
/*      */       
/* 1356 */       getDAO_().setDiscRetailLocationId(null);
/* 1357 */       getDAO_().setDiscBusinessDate(null);
/* 1358 */       getDAO_().setDiscWorkstationId(null);
/* 1359 */       getDAO_().setDiscTransactionSequence(null);
/* 1360 */       getDAO_().setDiscRetailTransactionLineItemSequence(null);
/* 1361 */       if (this._reasonLineItem != null)
/*      */       {
/* 1363 */         if (postEventsForChanges()) {
/* 1364 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._reasonLineItem));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1369 */       getDAO_().setDiscRetailLocationId(Long.valueOf(argReasonLineItem.getRetailLocationId()));
/* 1370 */       getDAO_().setDiscBusinessDate(argReasonLineItem.getBusinessDate());
/* 1371 */       getDAO_().setDiscWorkstationId(Long.valueOf(argReasonLineItem.getWorkstationId()));
/* 1372 */       getDAO_().setDiscTransactionSequence(Long.valueOf(argReasonLineItem.getTransactionSequence()));
/* 1373 */       getDAO_().setDiscRetailTransactionLineItemSequence(Integer.valueOf(argReasonLineItem.getRetailTransactionLineItemSequence()));
/*      */       
/* 1375 */       if (postEventsForChanges()) {
/* 1376 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReasonLineItem));
/*      */       }
/*      */     } 
/*      */     
/* 1380 */     this._reasonLineItem = argReasonLineItem;
/* 1381 */     if (postEventsForChanges()) {
/* 1382 */       this._events.post(IRetailPriceModifier.SET_REASONLINEITEM, argReasonLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IRetailPriceModifierProperty> getProperties() {
/* 1388 */     if (this._properties == null) {
/* 1389 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1391 */     return (List<IRetailPriceModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IRetailPriceModifierProperty> argProperties) {
/* 1395 */     if (this._properties == null) {
/* 1396 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1398 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1401 */     for (IRetailPriceModifierProperty child : this._properties) {
/* 1402 */       RetailPriceModifierPropertyModel model = (RetailPriceModifierPropertyModel)child;
/* 1403 */       model.setBusinessDate_noev(getBusinessDate());
/* 1404 */       model.setOrganizationId_noev(getOrganizationId());
/* 1405 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1406 */       model.setRetailPriceModifierSequenceNbr_noev(getRetailPriceModifierSequenceNbr());
/* 1407 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 1408 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 1409 */       model.setWorkstationId_noev(getWorkstationId());
/* 1410 */       if (child instanceof IDataModelImpl) {
/* 1411 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1412 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1413 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1414 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1417 */       if (postEventsForChanges()) {
/* 1418 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addRetailPriceModifierProperty(IRetailPriceModifierProperty argRetailPriceModifierProperty) {
/* 1424 */     if (this._properties == null) {
/* 1425 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1427 */     argRetailPriceModifierProperty.setBusinessDate(getBusinessDate());
/* 1428 */     argRetailPriceModifierProperty.setOrganizationId(getOrganizationId());
/* 1429 */     argRetailPriceModifierProperty.setRetailLocationId(getRetailLocationId());
/* 1430 */     argRetailPriceModifierProperty.setRetailPriceModifierSequenceNbr(getRetailPriceModifierSequenceNbr());
/* 1431 */     argRetailPriceModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 1432 */     argRetailPriceModifierProperty.setTransactionSequence(getTransactionSequence());
/* 1433 */     argRetailPriceModifierProperty.setWorkstationId(getWorkstationId());
/* 1434 */     if (argRetailPriceModifierProperty instanceof IDataModelImpl) {
/* 1435 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailPriceModifierProperty).getDAO();
/* 1436 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1437 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1438 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1443 */     if (postEventsForChanges()) {
/* 1444 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailPriceModifierProperty));
/*      */     }
/*      */     
/* 1447 */     this._properties.add(argRetailPriceModifierProperty);
/* 1448 */     if (postEventsForChanges()) {
/* 1449 */       this._events.post(IRetailPriceModifier.ADD_PROPERTIES, argRetailPriceModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailPriceModifierProperty(IRetailPriceModifierProperty argRetailPriceModifierProperty) {
/* 1454 */     if (this._properties != null) {
/*      */       
/* 1456 */       if (postEventsForChanges()) {
/* 1457 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailPriceModifierProperty));
/*      */       }
/* 1459 */       this._properties.remove(argRetailPriceModifierProperty);
/* 1460 */       if (postEventsForChanges()) {
/* 1461 */         this._events.post(IRetailPriceModifier.REMOVE_PROPERTIES, argRetailPriceModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(ISaleReturnLineItem argParentLine) {
/* 1467 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public ISaleReturnLineItem getParentLine() {
/* 1471 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1476 */     if ("Discount".equals(argFieldId)) {
/* 1477 */       return getDiscount();
/*      */     }
/* 1479 */     if ("ReasonLineItem".equals(argFieldId)) {
/* 1480 */       return getReasonLineItem();
/*      */     }
/* 1482 */     if ("Properties".equals(argFieldId)) {
/* 1483 */       return getProperties();
/*      */     }
/* 1485 */     if ("RetailPriceModifierExtension".equals(argFieldId)) {
/* 1486 */       return this._myExtension;
/*      */     }
/*      */     
/* 1489 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1495 */     if ("Discount".equals(argFieldId)) {
/* 1496 */       setDiscount((IDiscount)argValue);
/*      */     }
/* 1498 */     else if ("ReasonLineItem".equals(argFieldId)) {
/* 1499 */       setReasonLineItem((IRetailTransactionLineItem)argValue);
/*      */     }
/* 1501 */     else if ("Properties".equals(argFieldId)) {
/* 1502 */       setProperties(changeToList(argValue, IRetailPriceModifierProperty.class));
/*      */     }
/* 1504 */     else if ("RetailPriceModifierExtension".equals(argFieldId)) {
/* 1505 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1508 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1514 */     this._persistenceDefaults = argPD;
/* 1515 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1516 */     this._eventManager = argEM;
/* 1517 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1518 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1519 */     if (this._discount != null) {
/* 1520 */       ((IDataModelImpl)this._discount).setDependencies(argPD, argEM);
/*      */     }
/* 1522 */     if (this._reasonLineItem != null) {
/* 1523 */       ((IDataModelImpl)this._reasonLineItem).setDependencies(argPD, argEM);
/*      */     }
/* 1525 */     if (this._properties != null) {
/* 1526 */       for (IRetailPriceModifierProperty relationship : this._properties) {
/* 1527 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getRetailPriceModifierExt() {
/* 1533 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setRetailPriceModifierExt(IDataModel argExt) {
/* 1537 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1542 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1546 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1549 */     super.startTransaction();
/*      */     
/* 1551 */     this._discountSavepoint = this._discount;
/* 1552 */     if (this._discount != null) {
/* 1553 */       this._discount.startTransaction();
/*      */     }
/*      */     
/* 1556 */     this._reasonLineItemSavepoint = this._reasonLineItem;
/* 1557 */     if (this._reasonLineItem != null) {
/* 1558 */       this._reasonLineItem.startTransaction();
/*      */     }
/*      */     
/* 1561 */     this._propertiesSavepoint = this._properties;
/* 1562 */     if (this._properties != null) {
/* 1563 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1564 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1565 */       while (it.hasNext()) {
/* 1566 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1571 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1576 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1579 */     super.rollbackChanges();
/*      */     
/* 1581 */     this._discount = this._discountSavepoint;
/* 1582 */     this._discountSavepoint = null;
/* 1583 */     if (this._discount != null) {
/* 1584 */       this._discount.rollbackChanges();
/*      */     }
/*      */     
/* 1587 */     this._reasonLineItem = this._reasonLineItemSavepoint;
/* 1588 */     this._reasonLineItemSavepoint = null;
/* 1589 */     if (this._reasonLineItem != null) {
/* 1590 */       this._reasonLineItem.rollbackChanges();
/*      */     }
/*      */     
/* 1593 */     this._properties = this._propertiesSavepoint;
/* 1594 */     this._propertiesSavepoint = null;
/* 1595 */     if (this._properties != null) {
/* 1596 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1597 */       while (it.hasNext()) {
/* 1598 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1606 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1609 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1612 */     super.commitTransaction();
/*      */     
/* 1614 */     this._discountSavepoint = this._discount;
/* 1615 */     if (this._discount != null) {
/* 1616 */       this._discount.commitTransaction();
/*      */     }
/*      */     
/* 1619 */     this._reasonLineItemSavepoint = this._reasonLineItem;
/* 1620 */     if (this._reasonLineItem != null) {
/* 1621 */       this._reasonLineItem.commitTransaction();
/*      */     }
/*      */     
/* 1624 */     this._propertiesSavepoint = this._properties;
/* 1625 */     if (this._properties != null) {
/* 1626 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1627 */       while (it.hasNext()) {
/* 1628 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1630 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1634 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1639 */     argStream.defaultReadObject();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient boolean _fromVerifiedReturn = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDisplayDescription() {
/* 1653 */     return (getDescription() != null) ? getDescription() : getDiscount().getDescription();
/*      */   }
/*      */   
/*      */   public BigDecimal getPercentForRcpt() {
/* 1657 */     return NumberUtils.nonNull(getPercent());
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getPreviousPrice() {
/* 1662 */     return NumberUtils.add(getPriceChangeAmount(), getAmount());
/*      */   }
/*      */   
/*      */   public String getItemId() {
/* 1666 */     return (this._parentLine != null) ? this._parentLine.getItemId() : null;
/*      */   }
/*      */   
/*      */   public String getVendor() {
/* 1670 */     return (this._parentLine != null && this._parentLine.getItem() != null) ? this._parentLine
/* 1671 */       .getItem().getOptions().getVendorId() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFromVerifiedReturn() {
/* 1677 */     return this._fromVerifiedReturn;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFromVerifiedReturn(boolean argFromVerifiedReturn) {
/* 1682 */     this._fromVerifiedReturn = argFromVerifiedReturn;
/*      */   }
/*      */ 
/*      */   
/*      */   public IDiscountLineItem getDiscountLineItem() {
/* 1687 */     return (getReasonLineItem() instanceof IDiscountLineItem) ? (IDiscountLineItem)
/* 1688 */       getReasonLineItem() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/* 1696 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1698 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getAmountImpl()) : getAmountImpl();
/*      */     
/* 1700 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/* 1707 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1709 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argAmount) : argAmount;
/* 1710 */     setAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDealAmount() {
/* 1717 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1719 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getDealAmountImpl()) : getDealAmountImpl();
/*      */     
/* 1721 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDealAmount(BigDecimal argDealAmount) {
/* 1728 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1730 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argDealAmount) : argDealAmount;
/* 1731 */     setDealAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExtendedAmount() {
/* 1738 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1740 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getExtendedAmountImpl()) : getExtendedAmountImpl();
/*      */     
/* 1742 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/* 1749 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1751 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argExtendedAmount) : argExtendedAmount;
/* 1752 */     setExtendedAmountImpl(relativeAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPriceChangeAmount() {
/* 1759 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1761 */     BigDecimal localizedAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getLocalizedAmount(getPriceChangeAmountImpl()) : getPriceChangeAmountImpl();
/*      */     
/* 1763 */     return localizedAmount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriceChangeAmount(BigDecimal argPriceChangeAmount) {
/* 1770 */     ISaleReturnLineItem iSaleReturnLineItem = getParentLine();
/*      */     
/* 1772 */     BigDecimal relativeAmount = (iSaleReturnLineItem != null) ? iSaleReturnLineItem.getRelativeAmount(argPriceChangeAmount) : argPriceChangeAmount;
/* 1773 */     setPriceChangeAmountImpl(relativeAmount);
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailPriceModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */