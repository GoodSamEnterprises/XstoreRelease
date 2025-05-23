/*      */ package dtv.xst.dao.trn.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*      */ import dtv.xst.dao.trl.impl.RetailTransactionLineItemModel;
/*      */ import dtv.xst.dao.trn.IPosTransaction;
/*      */ import dtv.xst.dao.trn.IPosTransactionLink;
/*      */ import dtv.xst.dao.trn.IPosTransactionProperty;
/*      */ import dtv.xst.dao.trn.ITransactionNotes;
/*      */ import dtv.xst.dao.trn.PosTransactionPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class PosTransactionModel extends PosTransactionBaseModel implements IPosTransaction {
/*      */   private static final long serialVersionUID = 1475778570L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IParty _operatorParty;
/*      */   private transient IParty _operatorPartySavepoint;
/*      */   private HistoricalList<IRetailTransactionLineItem> _retailTransactionLineItems;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient HistoricalList<IRetailTransactionLineItem> _retailTransactionLineItemsSavepoint; private HistoricalList<IPosTransactionLink> _transactionLinks; private transient HistoricalList<IPosTransactionLink> _transactionLinksSavepoint; private HistoricalList<ITransactionNotes> _transactionNotes; private transient HistoricalList<ITransactionNotes> _transactionNotesSavepoint; private HistoricalList<IPosTransactionProperty> _properties; private transient HistoricalList<IPosTransactionProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new PosTransactionDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PosTransactionDAO getDAO_() {
/*   48 */     return (PosTransactionDAO)this._daoImpl;
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
/*   69 */     if (setOrganizationId_noev(argOrganizationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   75 */     boolean ev_postable = false;
/*      */     
/*   77 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   78 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   79 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   80 */       ev_postable = true;
/*   81 */       if (this._retailTransactionLineItems != null) {
/*      */         
/*   83 */         Iterator<RetailTransactionLineItemModel> it = this._retailTransactionLineItems.iterator();
/*   84 */         while (it.hasNext())
/*      */         {
/*   86 */           ((RetailTransactionLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   89 */       if (this._transactionLinks != null) {
/*      */         
/*   91 */         Iterator<PosTransactionLinkModel> it = this._transactionLinks.iterator();
/*   92 */         while (it.hasNext())
/*      */         {
/*   94 */           ((PosTransactionLinkModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   97 */       if (this._transactionNotes != null) {
/*      */         
/*   99 */         Iterator<TransactionNotesModel> it = this._transactionNotes.iterator();
/*  100 */         while (it.hasNext())
/*      */         {
/*  102 */           ((TransactionNotesModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  105 */       if (this._properties != null) {
/*      */         
/*  107 */         Iterator<PosTransactionPropertyModel> it = this._properties.iterator();
/*  108 */         while (it.hasNext())
/*      */         {
/*  110 */           ((PosTransactionPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  115 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  123 */     if (getDAO_().getRetailLocationId() != null) {
/*  124 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  127 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  136 */     if (setRetailLocationId_noev(argRetailLocationId));
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
/*  148 */       if (this._retailTransactionLineItems != null) {
/*      */         
/*  150 */         Iterator<RetailTransactionLineItemModel> it = this._retailTransactionLineItems.iterator();
/*  151 */         while (it.hasNext())
/*      */         {
/*  153 */           ((RetailTransactionLineItemModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  156 */       if (this._transactionLinks != null) {
/*      */         
/*  158 */         Iterator<PosTransactionLinkModel> it = this._transactionLinks.iterator();
/*  159 */         while (it.hasNext())
/*      */         {
/*  161 */           ((PosTransactionLinkModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  164 */       if (this._transactionNotes != null) {
/*      */         
/*  166 */         Iterator<TransactionNotesModel> it = this._transactionNotes.iterator();
/*  167 */         while (it.hasNext())
/*      */         {
/*  169 */           ((TransactionNotesModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  172 */       if (this._properties != null) {
/*      */         
/*  174 */         Iterator<PosTransactionPropertyModel> it = this._properties.iterator();
/*  175 */         while (it.hasNext())
/*      */         {
/*  177 */           ((PosTransactionPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  182 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  190 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  198 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  199 */       this._events != null && 
/*  200 */       postEventsForChanges()) {
/*  201 */       this._events.post(IPosTransaction.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  208 */     boolean ev_postable = false;
/*      */     
/*  210 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  211 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  212 */       getDAO_().setBusinessDate(argBusinessDate);
/*  213 */       ev_postable = true;
/*  214 */       if (this._retailTransactionLineItems != null) {
/*      */         
/*  216 */         Iterator<RetailTransactionLineItemModel> it = this._retailTransactionLineItems.iterator();
/*  217 */         while (it.hasNext())
/*      */         {
/*  219 */           ((RetailTransactionLineItemModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  222 */       if (this._transactionLinks != null) {
/*      */         
/*  224 */         Iterator<PosTransactionLinkModel> it = this._transactionLinks.iterator();
/*  225 */         while (it.hasNext())
/*      */         {
/*  227 */           ((PosTransactionLinkModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  230 */       if (this._transactionNotes != null) {
/*      */         
/*  232 */         Iterator<TransactionNotesModel> it = this._transactionNotes.iterator();
/*  233 */         while (it.hasNext())
/*      */         {
/*  235 */           ((TransactionNotesModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  238 */       if (this._properties != null) {
/*      */         
/*  240 */         Iterator<PosTransactionPropertyModel> it = this._properties.iterator();
/*  241 */         while (it.hasNext())
/*      */         {
/*  243 */           ((PosTransactionPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  248 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  256 */     if (getDAO_().getWorkstationId() != null) {
/*  257 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  260 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  269 */     if (setWorkstationId_noev(argWorkstationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  275 */     boolean ev_postable = false;
/*      */     
/*  277 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  278 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  279 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  280 */       ev_postable = true;
/*  281 */       if (this._retailTransactionLineItems != null) {
/*      */         
/*  283 */         Iterator<RetailTransactionLineItemModel> it = this._retailTransactionLineItems.iterator();
/*  284 */         while (it.hasNext())
/*      */         {
/*  286 */           ((RetailTransactionLineItemModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  289 */       if (this._transactionLinks != null) {
/*      */         
/*  291 */         Iterator<PosTransactionLinkModel> it = this._transactionLinks.iterator();
/*  292 */         while (it.hasNext())
/*      */         {
/*  294 */           ((PosTransactionLinkModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  297 */       if (this._transactionNotes != null) {
/*      */         
/*  299 */         Iterator<TransactionNotesModel> it = this._transactionNotes.iterator();
/*  300 */         while (it.hasNext())
/*      */         {
/*  302 */           ((TransactionNotesModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  305 */       if (this._properties != null) {
/*      */         
/*  307 */         Iterator<PosTransactionPropertyModel> it = this._properties.iterator();
/*  308 */         while (it.hasNext())
/*      */         {
/*  310 */           ((PosTransactionPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  315 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  323 */     if (getDAO_().getTransactionSequence() != null) {
/*  324 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  327 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  336 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  337 */       this._events != null && 
/*  338 */       postEventsForChanges()) {
/*  339 */       this._events.post(IPosTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  346 */     boolean ev_postable = false;
/*      */     
/*  348 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  349 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  350 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  351 */       ev_postable = true;
/*  352 */       if (this._retailTransactionLineItems != null) {
/*      */         
/*  354 */         Iterator<RetailTransactionLineItemModel> it = this._retailTransactionLineItems.iterator();
/*  355 */         while (it.hasNext())
/*      */         {
/*  357 */           ((RetailTransactionLineItemModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  360 */       if (this._transactionLinks != null) {
/*      */         
/*  362 */         Iterator<PosTransactionLinkModel> it = this._transactionLinks.iterator();
/*  363 */         while (it.hasNext())
/*      */         {
/*  365 */           ((PosTransactionLinkModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  368 */       if (this._transactionNotes != null) {
/*      */         
/*  370 */         Iterator<TransactionNotesModel> it = this._transactionNotes.iterator();
/*  371 */         while (it.hasNext())
/*      */         {
/*  373 */           ((TransactionNotesModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  376 */       if (this._properties != null) {
/*      */         
/*  378 */         Iterator<PosTransactionPropertyModel> it = this._properties.iterator();
/*  379 */         while (it.hasNext())
/*      */         {
/*  381 */           ((PosTransactionPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  386 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getClassName() {
/*  394 */     return getDAO_().getClassName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClassName(String argClassName) {
/*  402 */     if (setClassName_noev(argClassName));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClassName_noev(String argClassName) {
/*  408 */     boolean ev_postable = false;
/*      */     
/*  410 */     if ((getDAO_().getClassName() == null && argClassName != null) || (
/*  411 */       getDAO_().getClassName() != null && !getDAO_().getClassName().equals(argClassName))) {
/*  412 */       getDAO_().setClassName(argClassName);
/*  413 */       ev_postable = true;
/*      */     } 
/*      */     
/*  416 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  424 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  432 */     if (setCreateDate_noev(argCreateDate));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  438 */     boolean ev_postable = false;
/*      */     
/*  440 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  441 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  442 */       getDAO_().setCreateDate(argCreateDate);
/*  443 */       ev_postable = true;
/*      */     } 
/*      */     
/*  446 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  454 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  462 */     if (setCreateUserId_noev(argCreateUserId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  468 */     boolean ev_postable = false;
/*      */     
/*  470 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  471 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  472 */       getDAO_().setCreateUserId(argCreateUserId);
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
/*      */   public Date getUpdateDate() {
/*  484 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  492 */     if (setUpdateDate_noev(argUpdateDate));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  498 */     boolean ev_postable = false;
/*      */     
/*  500 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  501 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  502 */       getDAO_().setUpdateDate(argUpdateDate);
/*  503 */       ev_postable = true;
/*      */     } 
/*      */     
/*  506 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  514 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  522 */     if (setUpdateUserId_noev(argUpdateUserId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  528 */     boolean ev_postable = false;
/*      */     
/*  530 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  531 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  532 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  533 */       ev_postable = true;
/*      */     } 
/*      */     
/*  536 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBeginDateTimestamp() {
/*  544 */     return getDAO_().getBeginDateTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeginDateTimestamp(Date argBeginDateTimestamp) {
/*  552 */     super.setBeginDateTimestamp(argBeginDateTimestamp);
/*      */     
/*  554 */     if (setBeginDateTimestamp_noev(argBeginDateTimestamp) && 
/*  555 */       this._events != null && 
/*  556 */       postEventsForChanges()) {
/*  557 */       this._events.post(IPosTransaction.SET_BEGINDATETIMESTAMP, argBeginDateTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeginDateTimestamp_noev(Date argBeginDateTimestamp) {
/*  564 */     boolean ev_postable = false;
/*      */     
/*  566 */     if ((getDAO_().getBeginDateTimestamp() == null && argBeginDateTimestamp != null) || (
/*  567 */       getDAO_().getBeginDateTimestamp() != null && !getDAO_().getBeginDateTimestamp().equals(argBeginDateTimestamp))) {
/*  568 */       getDAO_().setBeginDateTimestamp(argBeginDateTimestamp);
/*  569 */       ev_postable = true;
/*      */     } 
/*      */     
/*  572 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getTransactionDate() {
/*  580 */     return getDAO_().getTransactionDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionDate(Date argTransactionDate) {
/*  588 */     if (setTransactionDate_noev(argTransactionDate) && 
/*  589 */       this._events != null && 
/*  590 */       postEventsForChanges()) {
/*  591 */       this._events.post(IPosTransaction.SET_TRANSACTIONDATE, argTransactionDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionDate_noev(Date argTransactionDate) {
/*  598 */     boolean ev_postable = false;
/*      */     
/*  600 */     if ((getDAO_().getTransactionDate() == null && argTransactionDate != null) || (
/*  601 */       getDAO_().getTransactionDate() != null && !getDAO_().getTransactionDate().equals(argTransactionDate))) {
/*  602 */       getDAO_().setTransactionDate(argTransactionDate);
/*  603 */       ev_postable = true;
/*      */     } 
/*      */     
/*  606 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBeginTimeInt() {
/*  614 */     if (getDAO_().getBeginTimeInt() != null) {
/*  615 */       return getDAO_().getBeginTimeInt().intValue();
/*      */     }
/*      */     
/*  618 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeginTimeInt(int argBeginTimeInt) {
/*  627 */     if (setBeginTimeInt_noev(argBeginTimeInt) && 
/*  628 */       this._events != null && 
/*  629 */       postEventsForChanges()) {
/*  630 */       this._events.post(IPosTransaction.SET_BEGINTIMEINT, Integer.valueOf(argBeginTimeInt));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeginTimeInt_noev(int argBeginTimeInt) {
/*  637 */     boolean ev_postable = false;
/*      */     
/*  639 */     if ((getDAO_().getBeginTimeInt() == null && Integer.valueOf(argBeginTimeInt) != null) || (
/*  640 */       getDAO_().getBeginTimeInt() != null && !getDAO_().getBeginTimeInt().equals(Integer.valueOf(argBeginTimeInt)))) {
/*  641 */       getDAO_().setBeginTimeInt(Integer.valueOf(argBeginTimeInt));
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
/*      */   public Date getEndDateTimestamp() {
/*  653 */     return getDAO_().getEndDateTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDateTimestamp(Date argEndDateTimestamp) {
/*  661 */     if (setEndDateTimestamp_noev(argEndDateTimestamp) && 
/*  662 */       this._events != null && 
/*  663 */       postEventsForChanges()) {
/*  664 */       this._events.post(IPosTransaction.SET_ENDDATETIMESTAMP, argEndDateTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDateTimestamp_noev(Date argEndDateTimestamp) {
/*  671 */     boolean ev_postable = false;
/*      */     
/*  673 */     if ((getDAO_().getEndDateTimestamp() == null && argEndDateTimestamp != null) || (
/*  674 */       getDAO_().getEndDateTimestamp() != null && !getDAO_().getEndDateTimestamp().equals(argEndDateTimestamp))) {
/*  675 */       getDAO_().setEndDateTimestamp(argEndDateTimestamp);
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
/*      */   public boolean getKeyedOffline() {
/*  687 */     if (getDAO_().getKeyedOffline() != null) {
/*  688 */       return getDAO_().getKeyedOffline().booleanValue();
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
/*      */   public void setKeyedOffline(boolean argKeyedOffline) {
/*  700 */     if (setKeyedOffline_noev(argKeyedOffline) && 
/*  701 */       this._events != null && 
/*  702 */       postEventsForChanges()) {
/*  703 */       this._events.post(IPosTransaction.SET_KEYEDOFFLINE, Boolean.valueOf(argKeyedOffline));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setKeyedOffline_noev(boolean argKeyedOffline) {
/*  710 */     boolean ev_postable = false;
/*      */     
/*  712 */     if ((getDAO_().getKeyedOffline() == null && Boolean.valueOf(argKeyedOffline) != null) || (
/*  713 */       getDAO_().getKeyedOffline() != null && !getDAO_().getKeyedOffline().equals(Boolean.valueOf(argKeyedOffline)))) {
/*  714 */       getDAO_().setKeyedOffline(Boolean.valueOf(argKeyedOffline));
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
/*      */   public boolean getPosted() {
/*  726 */     if (getDAO_().getPosted() != null) {
/*  727 */       return getDAO_().getPosted().booleanValue();
/*      */     }
/*      */     
/*  730 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPosted(boolean argPosted) {
/*  739 */     if (setPosted_noev(argPosted) && 
/*  740 */       this._events != null && 
/*  741 */       postEventsForChanges()) {
/*  742 */       this._events.post(IPosTransaction.SET_POSTED, Boolean.valueOf(argPosted));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPosted_noev(boolean argPosted) {
/*  749 */     boolean ev_postable = false;
/*      */     
/*  751 */     if ((getDAO_().getPosted() == null && Boolean.valueOf(argPosted) != null) || (
/*  752 */       getDAO_().getPosted() != null && !getDAO_().getPosted().equals(Boolean.valueOf(argPosted)))) {
/*  753 */       getDAO_().setPosted(Boolean.valueOf(argPosted));
/*  754 */       ev_postable = true;
/*      */     } 
/*      */     
/*  757 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getSessionId() {
/*  765 */     if (getDAO_().getSessionId() != null) {
/*  766 */       return getDAO_().getSessionId().longValue();
/*      */     }
/*      */     
/*  769 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSessionId(long argSessionId) {
/*  778 */     if (setSessionId_noev(argSessionId) && 
/*  779 */       this._events != null && 
/*  780 */       postEventsForChanges()) {
/*  781 */       this._events.post(IPosTransaction.SET_SESSIONID, Long.valueOf(argSessionId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSessionId_noev(long argSessionId) {
/*  788 */     boolean ev_postable = false;
/*      */     
/*  790 */     if ((getDAO_().getSessionId() == null && Long.valueOf(argSessionId) != null) || (
/*  791 */       getDAO_().getSessionId() != null && !getDAO_().getSessionId().equals(Long.valueOf(argSessionId)))) {
/*  792 */       getDAO_().setSessionId(Long.valueOf(argSessionId));
/*  793 */       ev_postable = true;
/*      */     } 
/*      */     
/*  796 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getSubtotal() {
/*  804 */     return getDAO_().getSubtotal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubtotal(BigDecimal argSubtotal) {
/*  812 */     if (setSubtotal_noev(argSubtotal) && 
/*  813 */       this._events != null && 
/*  814 */       postEventsForChanges()) {
/*  815 */       this._events.post(IPosTransaction.SET_SUBTOTAL, argSubtotal);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSubtotal_noev(BigDecimal argSubtotal) {
/*  822 */     boolean ev_postable = false;
/*      */     
/*  824 */     if ((getDAO_().getSubtotal() == null && argSubtotal != null) || (
/*  825 */       getDAO_().getSubtotal() != null && !getDAO_().getSubtotal().equals(argSubtotal))) {
/*  826 */       getDAO_().setSubtotal(argSubtotal);
/*  827 */       ev_postable = true;
/*      */     } 
/*      */     
/*  830 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTaxAmount() {
/*  838 */     return getDAO_().getTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxAmount(BigDecimal argTaxAmount) {
/*  846 */     if (setTaxAmount_noev(argTaxAmount) && 
/*  847 */       this._events != null && 
/*  848 */       postEventsForChanges()) {
/*  849 */       this._events.post(IPosTransaction.SET_TAXAMOUNT, argTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/*  856 */     boolean ev_postable = false;
/*      */     
/*  858 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/*  859 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/*  860 */       getDAO_().setTaxAmount(argTaxAmount);
/*  861 */       ev_postable = true;
/*      */     } 
/*      */     
/*  864 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRoundedAmount(BigDecimal argRoundedAmount) {
/*  872 */     if (setRoundedAmount_noev(argRoundedAmount) && 
/*  873 */       this._events != null && 
/*  874 */       postEventsForChanges()) {
/*  875 */       this._events.post(IPosTransaction.SET_ROUNDEDAMOUNT, argRoundedAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRoundedAmount_noev(BigDecimal argRoundedAmount) {
/*  882 */     boolean ev_postable = false;
/*      */     
/*  884 */     if ((getDAO_().getRoundedAmount() == null && argRoundedAmount != null) || (
/*  885 */       getDAO_().getRoundedAmount() != null && !getDAO_().getRoundedAmount().equals(argRoundedAmount))) {
/*  886 */       getDAO_().setRoundedAmount(argRoundedAmount);
/*  887 */       ev_postable = true;
/*      */     } 
/*      */     
/*  890 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTotal() {
/*  898 */     return getDAO_().getTotal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTotal(BigDecimal argTotal) {
/*  906 */     if (setTotal_noev(argTotal) && 
/*  907 */       this._events != null && 
/*  908 */       postEventsForChanges()) {
/*  909 */       this._events.post(IPosTransaction.SET_TOTAL, argTotal);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTotal_noev(BigDecimal argTotal) {
/*  916 */     boolean ev_postable = false;
/*      */     
/*  918 */     if ((getDAO_().getTotal() == null && argTotal != null) || (
/*  919 */       getDAO_().getTotal() != null && !getDAO_().getTotal().equals(argTotal))) {
/*  920 */       getDAO_().setTotal(argTotal);
/*  921 */       ev_postable = true;
/*      */     } 
/*      */     
/*  924 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransactionStatusCode() {
/*  932 */     return getDAO_().getTransactionStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionStatusCode(String argTransactionStatusCode) {
/*  940 */     if (setTransactionStatusCode_noev(argTransactionStatusCode) && 
/*  941 */       this._events != null && 
/*  942 */       postEventsForChanges()) {
/*  943 */       this._events.post(IPosTransaction.SET_TRANSACTIONSTATUSCODE, argTransactionStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionStatusCode_noev(String argTransactionStatusCode) {
/*  950 */     boolean ev_postable = false;
/*      */     
/*  952 */     if ((getDAO_().getTransactionStatusCode() == null && argTransactionStatusCode != null) || (
/*  953 */       getDAO_().getTransactionStatusCode() != null && !getDAO_().getTransactionStatusCode().equals(argTransactionStatusCode))) {
/*  954 */       getDAO_().setTransactionStatusCode(argTransactionStatusCode);
/*  955 */       ev_postable = true;
/*      */     } 
/*      */     
/*  958 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransactionTypeCode() {
/*  966 */     return getDAO_().getTransactionTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionTypeCode(String argTransactionTypeCode) {
/*  974 */     if (setTransactionTypeCode_noev(argTransactionTypeCode) && 
/*  975 */       this._events != null && 
/*  976 */       postEventsForChanges()) {
/*  977 */       this._events.post(IPosTransaction.SET_TRANSACTIONTYPECODE, argTransactionTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionTypeCode_noev(String argTransactionTypeCode) {
/*  984 */     boolean ev_postable = false;
/*      */     
/*  986 */     if ((getDAO_().getTransactionTypeCode() == null && argTransactionTypeCode != null) || (
/*  987 */       getDAO_().getTransactionTypeCode() != null && !getDAO_().getTransactionTypeCode().equals(argTransactionTypeCode))) {
/*  988 */       getDAO_().setTransactionTypeCode(argTransactionTypeCode);
/*  989 */       ev_postable = true;
/*      */     } 
/*      */     
/*  992 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTransactionCancelledReasonCode() {
/* 1000 */     return getDAO_().getTransactionCancelledReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionCancelledReasonCode(String argTransactionCancelledReasonCode) {
/* 1008 */     if (setTransactionCancelledReasonCode_noev(argTransactionCancelledReasonCode) && 
/* 1009 */       this._events != null && 
/* 1010 */       postEventsForChanges()) {
/* 1011 */       this._events.post(IPosTransaction.SET_TRANSACTIONCANCELLEDREASONCODE, argTransactionCancelledReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionCancelledReasonCode_noev(String argTransactionCancelledReasonCode) {
/* 1018 */     boolean ev_postable = false;
/*      */     
/* 1020 */     if ((getDAO_().getTransactionCancelledReasonCode() == null && argTransactionCancelledReasonCode != null) || (
/* 1021 */       getDAO_().getTransactionCancelledReasonCode() != null && !getDAO_().getTransactionCancelledReasonCode().equals(argTransactionCancelledReasonCode))) {
/* 1022 */       getDAO_().setTransactionCancelledReasonCode(argTransactionCancelledReasonCode);
/* 1023 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1026 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getGenericStorage() {
/* 1034 */     if (getDAO_().getGenericStorage() != null) {
/* 1035 */       return getDAO_().getGenericStorage().booleanValue();
/*      */     }
/*      */     
/* 1038 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGenericStorage(boolean argGenericStorage) {
/* 1047 */     if (setGenericStorage_noev(argGenericStorage) && 
/* 1048 */       this._events != null && 
/* 1049 */       postEventsForChanges()) {
/* 1050 */       this._events.post(IPosTransaction.SET_GENERICSTORAGE, Boolean.valueOf(argGenericStorage));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGenericStorage_noev(boolean argGenericStorage) {
/* 1057 */     boolean ev_postable = false;
/*      */     
/* 1059 */     if ((getDAO_().getGenericStorage() == null && Boolean.valueOf(argGenericStorage) != null) || (
/* 1060 */       getDAO_().getGenericStorage() != null && !getDAO_().getGenericStorage().equals(Boolean.valueOf(argGenericStorage)))) {
/* 1061 */       getDAO_().setGenericStorage(Boolean.valueOf(argGenericStorage));
/* 1062 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1065 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOperatorPartyId() {
/* 1073 */     if (getDAO_().getOperatorPartyId() != null) {
/* 1074 */       return getDAO_().getOperatorPartyId().longValue();
/*      */     }
/*      */     
/* 1077 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOperatorPartyId(long argOperatorPartyId) {
/* 1086 */     if (setOperatorPartyId_noev(argOperatorPartyId) && 
/* 1087 */       this._events != null && 
/* 1088 */       postEventsForChanges()) {
/* 1089 */       this._events.post(IPosTransaction.SET_OPERATORPARTYID, Long.valueOf(argOperatorPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOperatorPartyId_noev(long argOperatorPartyId) {
/* 1096 */     boolean ev_postable = false;
/*      */     
/* 1098 */     if ((getDAO_().getOperatorPartyId() == null && Long.valueOf(argOperatorPartyId) != null) || (
/* 1099 */       getDAO_().getOperatorPartyId() != null && !getDAO_().getOperatorPartyId().equals(Long.valueOf(argOperatorPartyId)))) {
/* 1100 */       getDAO_().setOperatorPartyId(Long.valueOf(argOperatorPartyId));
/* 1101 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1104 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPostVoid() {
/* 1112 */     if (getDAO_().getPostVoid() != null) {
/* 1113 */       return getDAO_().getPostVoid().booleanValue();
/*      */     }
/*      */     
/* 1116 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPostVoid(boolean argPostVoid) {
/* 1125 */     if (setPostVoid_noev(argPostVoid) && 
/* 1126 */       this._events != null && 
/* 1127 */       postEventsForChanges()) {
/* 1128 */       this._events.post(IPosTransaction.SET_POSTVOID, Boolean.valueOf(argPostVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPostVoid_noev(boolean argPostVoid) {
/* 1135 */     boolean ev_postable = false;
/*      */     
/* 1137 */     if ((getDAO_().getPostVoid() == null && Boolean.valueOf(argPostVoid) != null) || (
/* 1138 */       getDAO_().getPostVoid() != null && !getDAO_().getPostVoid().equals(Boolean.valueOf(argPostVoid)))) {
/* 1139 */       getDAO_().setPostVoid(Boolean.valueOf(argPostVoid));
/* 1140 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1143 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCashDrawerId() {
/* 1151 */     return getDAO_().getCashDrawerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCashDrawerId(String argCashDrawerId) {
/* 1159 */     if (setCashDrawerId_noev(argCashDrawerId) && 
/* 1160 */       this._events != null && 
/* 1161 */       postEventsForChanges()) {
/* 1162 */       this._events.post(IPosTransaction.SET_CASHDRAWERID, argCashDrawerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCashDrawerId_noev(String argCashDrawerId) {
/* 1169 */     boolean ev_postable = false;
/*      */     
/* 1171 */     if ((getDAO_().getCashDrawerId() == null && argCashDrawerId != null) || (
/* 1172 */       getDAO_().getCashDrawerId() != null && !getDAO_().getCashDrawerId().equals(argCashDrawerId))) {
/* 1173 */       getDAO_().setCashDrawerId(argCashDrawerId);
/* 1174 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1177 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFiscalNumber() {
/* 1185 */     return getDAO_().getFiscalNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFiscalNumber(String argFiscalNumber) {
/* 1193 */     if (setFiscalNumber_noev(argFiscalNumber) && 
/* 1194 */       this._events != null && 
/* 1195 */       postEventsForChanges()) {
/* 1196 */       this._events.post(IPosTransaction.SET_FISCALNUMBER, argFiscalNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFiscalNumber_noev(String argFiscalNumber) {
/* 1203 */     boolean ev_postable = false;
/*      */     
/* 1205 */     if ((getDAO_().getFiscalNumber() == null && argFiscalNumber != null) || (
/* 1206 */       getDAO_().getFiscalNumber() != null && !getDAO_().getFiscalNumber().equals(argFiscalNumber))) {
/* 1207 */       getDAO_().setFiscalNumber(argFiscalNumber);
/* 1208 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1211 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IPosTransactionProperty newProperty(String argPropertyName) {
/* 1215 */     PosTransactionPropertyId id = new PosTransactionPropertyId();
/*      */     
/* 1217 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/* 1218 */     id.setBusinessDate(getBusinessDate());
/* 1219 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/* 1220 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/* 1221 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1223 */     IPosTransactionProperty prop = (IPosTransactionProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IPosTransactionProperty.class);
/* 1224 */     return prop;
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
/*      */   @Relationship(name = "OperatorParty")
/*      */   public IParty getOperatorParty() {
/* 1245 */     return this._operatorParty;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOperatorParty(IParty argOperatorParty) {
/* 1250 */     if (argOperatorParty == null) {
/*      */       
/* 1252 */       getDAO_().setOperatorPartyId(null);
/* 1253 */       if (this._operatorParty != null)
/*      */       {
/* 1255 */         if (postEventsForChanges()) {
/* 1256 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._operatorParty));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1261 */       getDAO_().setOperatorPartyId(Long.valueOf(argOperatorParty.getPartyId()));
/*      */       
/* 1263 */       if (postEventsForChanges()) {
/* 1264 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOperatorParty));
/*      */       }
/*      */     } 
/*      */     
/* 1268 */     this._operatorParty = argOperatorParty;
/* 1269 */     if (postEventsForChanges()) {
/* 1270 */       this._events.post(IPosTransaction.SET_OPERATORPARTY, argOperatorParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "RetailTransactionLineItems")
/*      */   public List<IRetailTransactionLineItem> getRetailTransactionLineItems() {
/* 1276 */     if (this._retailTransactionLineItems == null) {
/* 1277 */       this._retailTransactionLineItems = new HistoricalList(null);
/*      */     }
/* 1279 */     return (List<IRetailTransactionLineItem>)this._retailTransactionLineItems;
/*      */   }
/*      */   
/*      */   public void setRetailTransactionLineItems(List<IRetailTransactionLineItem> argRetailTransactionLineItems) {
/* 1283 */     super.setRetailTransactionLineItems(argRetailTransactionLineItems);
/*      */     
/* 1285 */     if (this._retailTransactionLineItems == null) {
/* 1286 */       this._retailTransactionLineItems = new HistoricalList(argRetailTransactionLineItems);
/*      */     } else {
/* 1288 */       this._retailTransactionLineItems.setCurrentList(argRetailTransactionLineItems);
/*      */     } 
/*      */     
/* 1291 */     for (IRetailTransactionLineItem child : this._retailTransactionLineItems) {
/* 1292 */       child.setParentTransaction(this);
/*      */     }
/*      */ 
/*      */     
/* 1296 */     for (IRetailTransactionLineItem child : this._retailTransactionLineItems) {
/* 1297 */       RetailTransactionLineItemModel model = (RetailTransactionLineItemModel)child;
/* 1298 */       model.setOrganizationId_noev(getOrganizationId());
/* 1299 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1300 */       model.setBusinessDate_noev(getBusinessDate());
/* 1301 */       model.setWorkstationId_noev(getWorkstationId());
/* 1302 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 1303 */       if (child instanceof IDataModelImpl) {
/* 1304 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1305 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1306 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1307 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1310 */       if (postEventsForChanges()) {
/* 1311 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addRetailTransactionLineItem(IRetailTransactionLineItem argRetailTransactionLineItem) {
/* 1317 */     super.addRetailTransactionLineItem(argRetailTransactionLineItem);
/*      */ 
/*      */     
/* 1320 */     argRetailTransactionLineItem.setParentTransaction(this);
/* 1321 */     if (this._retailTransactionLineItems == null) {
/* 1322 */       this._retailTransactionLineItems = new HistoricalList(null);
/*      */     }
/* 1324 */     argRetailTransactionLineItem.setOrganizationId(getOrganizationId());
/* 1325 */     argRetailTransactionLineItem.setRetailLocationId(getRetailLocationId());
/* 1326 */     argRetailTransactionLineItem.setBusinessDate(getBusinessDate());
/* 1327 */     argRetailTransactionLineItem.setWorkstationId(getWorkstationId());
/* 1328 */     argRetailTransactionLineItem.setTransactionSequence(getTransactionSequence());
/* 1329 */     if (argRetailTransactionLineItem instanceof IDataModelImpl) {
/* 1330 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailTransactionLineItem).getDAO();
/* 1331 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1332 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1333 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1338 */     if (postEventsForChanges()) {
/* 1339 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItem));
/*      */     }
/*      */     
/* 1342 */     this._retailTransactionLineItems.add(argRetailTransactionLineItem);
/* 1343 */     if (postEventsForChanges()) {
/* 1344 */       this._events.post(IPosTransaction.ADD_RETAILTRANSACTIONLINEITEMS, argRetailTransactionLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailTransactionLineItem(IRetailTransactionLineItem argRetailTransactionLineItem) {
/* 1349 */     if (this._retailTransactionLineItems != null) {
/*      */       
/* 1351 */       if (postEventsForChanges()) {
/* 1352 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItem));
/*      */       }
/* 1354 */       this._retailTransactionLineItems.remove(argRetailTransactionLineItem);
/*      */       
/* 1356 */       argRetailTransactionLineItem.setParentTransaction(null);
/* 1357 */       if (postEventsForChanges()) {
/* 1358 */         this._events.post(IPosTransaction.REMOVE_RETAILTRANSACTIONLINEITEMS, argRetailTransactionLineItem);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TransactionLinks")
/*      */   public List<IPosTransactionLink> getTransactionLinks() {
/* 1365 */     if (this._transactionLinks == null) {
/* 1366 */       this._transactionLinks = new HistoricalList(null);
/*      */     }
/* 1368 */     return (List<IPosTransactionLink>)this._transactionLinks;
/*      */   }
/*      */   
/*      */   public void setTransactionLinks(List<IPosTransactionLink> argTransactionLinks) {
/* 1372 */     if (this._transactionLinks == null) {
/* 1373 */       this._transactionLinks = new HistoricalList(argTransactionLinks);
/*      */     } else {
/* 1375 */       this._transactionLinks.setCurrentList(argTransactionLinks);
/*      */     } 
/*      */     
/* 1378 */     for (IPosTransactionLink child : this._transactionLinks) {
/* 1379 */       child.setParentTransaction(this);
/*      */     }
/*      */ 
/*      */     
/* 1383 */     for (IPosTransactionLink child : this._transactionLinks) {
/* 1384 */       PosTransactionLinkModel model = (PosTransactionLinkModel)child;
/* 1385 */       model.setOrganizationId_noev(getOrganizationId());
/* 1386 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1387 */       model.setBusinessDate_noev(getBusinessDate());
/* 1388 */       model.setWorkstationId_noev(getWorkstationId());
/* 1389 */       model.setTransactionSequence_noev(getTransactionSequence());
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
/*      */   
/*      */   public void addPosTransactionLink(IPosTransactionLink argPosTransactionLink) {
/* 1405 */     argPosTransactionLink.setParentTransaction(this);
/* 1406 */     if (this._transactionLinks == null) {
/* 1407 */       this._transactionLinks = new HistoricalList(null);
/*      */     }
/* 1409 */     argPosTransactionLink.setOrganizationId(getOrganizationId());
/* 1410 */     argPosTransactionLink.setRetailLocationId(getRetailLocationId());
/* 1411 */     argPosTransactionLink.setBusinessDate(getBusinessDate());
/* 1412 */     argPosTransactionLink.setWorkstationId(getWorkstationId());
/* 1413 */     argPosTransactionLink.setTransactionSequence(getTransactionSequence());
/* 1414 */     if (argPosTransactionLink instanceof IDataModelImpl) {
/* 1415 */       IDataAccessObject childDao = ((IDataModelImpl)argPosTransactionLink).getDAO();
/* 1416 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1417 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1418 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1423 */     if (postEventsForChanges()) {
/* 1424 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosTransactionLink));
/*      */     }
/*      */     
/* 1427 */     this._transactionLinks.add(argPosTransactionLink);
/* 1428 */     if (postEventsForChanges()) {
/* 1429 */       this._events.post(IPosTransaction.ADD_TRANSACTIONLINKS, argPosTransactionLink);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePosTransactionLink(IPosTransactionLink argPosTransactionLink) {
/* 1434 */     if (this._transactionLinks != null) {
/*      */       
/* 1436 */       if (postEventsForChanges()) {
/* 1437 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosTransactionLink));
/*      */       }
/* 1439 */       this._transactionLinks.remove(argPosTransactionLink);
/*      */       
/* 1441 */       argPosTransactionLink.setParentTransaction(null);
/* 1442 */       if (postEventsForChanges()) {
/* 1443 */         this._events.post(IPosTransaction.REMOVE_TRANSACTIONLINKS, argPosTransactionLink);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TransactionNotes")
/*      */   public List<ITransactionNotes> getTransactionNotes() {
/* 1450 */     if (this._transactionNotes == null) {
/* 1451 */       this._transactionNotes = new HistoricalList(null);
/*      */     }
/* 1453 */     return (List<ITransactionNotes>)this._transactionNotes;
/*      */   }
/*      */   
/*      */   public void setTransactionNotes(List<ITransactionNotes> argTransactionNotes) {
/* 1457 */     if (this._transactionNotes == null) {
/* 1458 */       this._transactionNotes = new HistoricalList(argTransactionNotes);
/*      */     } else {
/* 1460 */       this._transactionNotes.setCurrentList(argTransactionNotes);
/*      */     } 
/*      */     
/* 1463 */     for (ITransactionNotes child : this._transactionNotes) {
/* 1464 */       child.setParentTransaction(this);
/*      */     }
/*      */ 
/*      */     
/* 1468 */     for (ITransactionNotes child : this._transactionNotes) {
/* 1469 */       TransactionNotesModel model = (TransactionNotesModel)child;
/* 1470 */       model.setOrganizationId_noev(getOrganizationId());
/* 1471 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1472 */       model.setBusinessDate_noev(getBusinessDate());
/* 1473 */       model.setWorkstationId_noev(getWorkstationId());
/* 1474 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 1475 */       if (child instanceof IDataModelImpl) {
/* 1476 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1477 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1478 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1479 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1482 */       if (postEventsForChanges()) {
/* 1483 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTransactionNotes(ITransactionNotes argTransactionNotes) {
/* 1489 */     super.addTransactionNotes(argTransactionNotes);
/*      */ 
/*      */     
/* 1492 */     argTransactionNotes.setParentTransaction(this);
/* 1493 */     if (this._transactionNotes == null) {
/* 1494 */       this._transactionNotes = new HistoricalList(null);
/*      */     }
/* 1496 */     argTransactionNotes.setOrganizationId(getOrganizationId());
/* 1497 */     argTransactionNotes.setRetailLocationId(getRetailLocationId());
/* 1498 */     argTransactionNotes.setBusinessDate(getBusinessDate());
/* 1499 */     argTransactionNotes.setWorkstationId(getWorkstationId());
/* 1500 */     argTransactionNotes.setTransactionSequence(getTransactionSequence());
/* 1501 */     if (argTransactionNotes instanceof IDataModelImpl) {
/* 1502 */       IDataAccessObject childDao = ((IDataModelImpl)argTransactionNotes).getDAO();
/* 1503 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1504 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1505 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1510 */     if (postEventsForChanges()) {
/* 1511 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionNotes));
/*      */     }
/*      */     
/* 1514 */     this._transactionNotes.add(argTransactionNotes);
/* 1515 */     if (postEventsForChanges()) {
/* 1516 */       this._events.post(IPosTransaction.ADD_TRANSACTIONNOTES, argTransactionNotes);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTransactionNotes(ITransactionNotes argTransactionNotes) {
/* 1521 */     if (this._transactionNotes != null) {
/*      */       
/* 1523 */       if (postEventsForChanges()) {
/* 1524 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTransactionNotes));
/*      */       }
/* 1526 */       this._transactionNotes.remove(argTransactionNotes);
/*      */       
/* 1528 */       argTransactionNotes.setParentTransaction(null);
/* 1529 */       if (postEventsForChanges()) {
/* 1530 */         this._events.post(IPosTransaction.REMOVE_TRANSACTIONNOTES, argTransactionNotes);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IPosTransactionProperty> getProperties() {
/* 1537 */     if (this._properties == null) {
/* 1538 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1540 */     return (List<IPosTransactionProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IPosTransactionProperty> argProperties) {
/* 1544 */     if (this._properties == null) {
/* 1545 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1547 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1550 */     for (IPosTransactionProperty child : this._properties) {
/* 1551 */       PosTransactionPropertyModel model = (PosTransactionPropertyModel)child;
/* 1552 */       model.setOrganizationId_noev(getOrganizationId());
/* 1553 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1554 */       model.setBusinessDate_noev(getBusinessDate());
/* 1555 */       model.setWorkstationId_noev(getWorkstationId());
/* 1556 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 1557 */       if (child instanceof IDataModelImpl) {
/* 1558 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1559 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1560 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1561 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1564 */       if (postEventsForChanges()) {
/* 1565 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addPosTransactionProperty(IPosTransactionProperty argPosTransactionProperty) {
/* 1571 */     if (this._properties == null) {
/* 1572 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1574 */     argPosTransactionProperty.setOrganizationId(getOrganizationId());
/* 1575 */     argPosTransactionProperty.setRetailLocationId(getRetailLocationId());
/* 1576 */     argPosTransactionProperty.setBusinessDate(getBusinessDate());
/* 1577 */     argPosTransactionProperty.setWorkstationId(getWorkstationId());
/* 1578 */     argPosTransactionProperty.setTransactionSequence(getTransactionSequence());
/* 1579 */     if (argPosTransactionProperty instanceof IDataModelImpl) {
/* 1580 */       IDataAccessObject childDao = ((IDataModelImpl)argPosTransactionProperty).getDAO();
/* 1581 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1582 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1583 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1588 */     if (postEventsForChanges()) {
/* 1589 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosTransactionProperty));
/*      */     }
/*      */     
/* 1592 */     this._properties.add(argPosTransactionProperty);
/* 1593 */     if (postEventsForChanges()) {
/* 1594 */       this._events.post(IPosTransaction.ADD_PROPERTIES, argPosTransactionProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePosTransactionProperty(IPosTransactionProperty argPosTransactionProperty) {
/* 1599 */     if (this._properties != null) {
/*      */       
/* 1601 */       if (postEventsForChanges()) {
/* 1602 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argPosTransactionProperty));
/*      */       }
/* 1604 */       this._properties.remove(argPosTransactionProperty);
/* 1605 */       if (postEventsForChanges()) {
/* 1606 */         this._events.post(IPosTransaction.REMOVE_PROPERTIES, argPosTransactionProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1613 */     if ("OperatorParty".equals(argFieldId)) {
/* 1614 */       return getOperatorParty();
/*      */     }
/* 1616 */     if ("RetailTransactionLineItems".equals(argFieldId)) {
/* 1617 */       return getRetailTransactionLineItems();
/*      */     }
/* 1619 */     if ("TransactionLinks".equals(argFieldId)) {
/* 1620 */       return getTransactionLinks();
/*      */     }
/* 1622 */     if ("TransactionNotes".equals(argFieldId)) {
/* 1623 */       return getTransactionNotes();
/*      */     }
/* 1625 */     if ("Properties".equals(argFieldId)) {
/* 1626 */       return getProperties();
/*      */     }
/* 1628 */     if ("PosTransactionExtension".equals(argFieldId)) {
/* 1629 */       return this._myExtension;
/*      */     }
/*      */     
/* 1632 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1638 */     if ("OperatorParty".equals(argFieldId)) {
/* 1639 */       setOperatorParty((IParty)argValue);
/*      */     }
/* 1641 */     else if ("RetailTransactionLineItems".equals(argFieldId)) {
/* 1642 */       setRetailTransactionLineItems(changeToList(argValue, IRetailTransactionLineItem.class));
/*      */     }
/* 1644 */     else if ("TransactionLinks".equals(argFieldId)) {
/* 1645 */       setTransactionLinks(changeToList(argValue, IPosTransactionLink.class));
/*      */     }
/* 1647 */     else if ("TransactionNotes".equals(argFieldId)) {
/* 1648 */       setTransactionNotes(changeToList(argValue, ITransactionNotes.class));
/*      */     }
/* 1650 */     else if ("Properties".equals(argFieldId)) {
/* 1651 */       setProperties(changeToList(argValue, IPosTransactionProperty.class));
/*      */     }
/* 1653 */     else if ("PosTransactionExtension".equals(argFieldId)) {
/* 1654 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1657 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1663 */     this._persistenceDefaults = argPD;
/* 1664 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1665 */     this._eventManager = argEM;
/* 1666 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1667 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1668 */     if (this._operatorParty != null) {
/* 1669 */       ((IDataModelImpl)this._operatorParty).setDependencies(argPD, argEM);
/*      */     }
/* 1671 */     if (this._retailTransactionLineItems != null) {
/* 1672 */       for (IRetailTransactionLineItem relationship : this._retailTransactionLineItems) {
/* 1673 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1676 */     if (this._transactionLinks != null) {
/* 1677 */       for (IPosTransactionLink relationship : this._transactionLinks) {
/* 1678 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1681 */     if (this._transactionNotes != null) {
/* 1682 */       for (ITransactionNotes relationship : this._transactionNotes) {
/* 1683 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1686 */     if (this._properties != null) {
/* 1687 */       for (IPosTransactionProperty relationship : this._properties) {
/* 1688 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getPosTransactionExt() {
/* 1694 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setPosTransactionExt(IDataModel argExt) {
/* 1698 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1703 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1707 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1710 */     super.startTransaction();
/*      */     
/* 1712 */     this._operatorPartySavepoint = this._operatorParty;
/* 1713 */     if (this._operatorParty != null) {
/* 1714 */       this._operatorParty.startTransaction();
/*      */     }
/*      */     
/* 1717 */     this._retailTransactionLineItemsSavepoint = this._retailTransactionLineItems;
/* 1718 */     if (this._retailTransactionLineItems != null) {
/* 1719 */       this._retailTransactionLineItemsSavepoint = new HistoricalList((List)this._retailTransactionLineItems);
/* 1720 */       Iterator<IDataModel> it = this._retailTransactionLineItems.iterator();
/* 1721 */       while (it.hasNext()) {
/* 1722 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1726 */     this._transactionLinksSavepoint = this._transactionLinks;
/* 1727 */     if (this._transactionLinks != null) {
/* 1728 */       this._transactionLinksSavepoint = new HistoricalList((List)this._transactionLinks);
/* 1729 */       Iterator<IDataModel> it = this._transactionLinks.iterator();
/* 1730 */       while (it.hasNext()) {
/* 1731 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1735 */     this._transactionNotesSavepoint = this._transactionNotes;
/* 1736 */     if (this._transactionNotes != null) {
/* 1737 */       this._transactionNotesSavepoint = new HistoricalList((List)this._transactionNotes);
/* 1738 */       Iterator<IDataModel> it = this._transactionNotes.iterator();
/* 1739 */       while (it.hasNext()) {
/* 1740 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1744 */     this._propertiesSavepoint = this._properties;
/* 1745 */     if (this._properties != null) {
/* 1746 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1747 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1748 */       while (it.hasNext()) {
/* 1749 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1754 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1759 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1762 */     super.rollbackChanges();
/*      */     
/* 1764 */     this._operatorParty = this._operatorPartySavepoint;
/* 1765 */     this._operatorPartySavepoint = null;
/* 1766 */     if (this._operatorParty != null) {
/* 1767 */       this._operatorParty.rollbackChanges();
/*      */     }
/*      */     
/* 1770 */     this._retailTransactionLineItems = this._retailTransactionLineItemsSavepoint;
/* 1771 */     this._retailTransactionLineItemsSavepoint = null;
/* 1772 */     if (this._retailTransactionLineItems != null) {
/* 1773 */       Iterator<IDataModel> it = this._retailTransactionLineItems.iterator();
/* 1774 */       while (it.hasNext()) {
/* 1775 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1779 */     this._transactionLinks = this._transactionLinksSavepoint;
/* 1780 */     this._transactionLinksSavepoint = null;
/* 1781 */     if (this._transactionLinks != null) {
/* 1782 */       Iterator<IDataModel> it = this._transactionLinks.iterator();
/* 1783 */       while (it.hasNext()) {
/* 1784 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1788 */     this._transactionNotes = this._transactionNotesSavepoint;
/* 1789 */     this._transactionNotesSavepoint = null;
/* 1790 */     if (this._transactionNotes != null) {
/* 1791 */       Iterator<IDataModel> it = this._transactionNotes.iterator();
/* 1792 */       while (it.hasNext()) {
/* 1793 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1797 */     this._properties = this._propertiesSavepoint;
/* 1798 */     this._propertiesSavepoint = null;
/* 1799 */     if (this._properties != null) {
/* 1800 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1801 */       while (it.hasNext()) {
/* 1802 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1810 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1813 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1816 */     super.commitTransaction();
/*      */     
/* 1818 */     this._operatorPartySavepoint = this._operatorParty;
/* 1819 */     if (this._operatorParty != null) {
/* 1820 */       this._operatorParty.commitTransaction();
/*      */     }
/*      */     
/* 1823 */     this._retailTransactionLineItemsSavepoint = this._retailTransactionLineItems;
/* 1824 */     if (this._retailTransactionLineItems != null) {
/* 1825 */       Iterator<IDataModel> it = this._retailTransactionLineItems.iterator();
/* 1826 */       while (it.hasNext()) {
/* 1827 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1829 */       this._retailTransactionLineItems = new HistoricalList((List)this._retailTransactionLineItems);
/*      */     } 
/*      */     
/* 1832 */     this._transactionLinksSavepoint = this._transactionLinks;
/* 1833 */     if (this._transactionLinks != null) {
/* 1834 */       Iterator<IDataModel> it = this._transactionLinks.iterator();
/* 1835 */       while (it.hasNext()) {
/* 1836 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1838 */       this._transactionLinks = new HistoricalList((List)this._transactionLinks);
/*      */     } 
/*      */     
/* 1841 */     this._transactionNotesSavepoint = this._transactionNotes;
/* 1842 */     if (this._transactionNotes != null) {
/* 1843 */       Iterator<IDataModel> it = this._transactionNotes.iterator();
/* 1844 */       while (it.hasNext()) {
/* 1845 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1847 */       this._transactionNotes = new HistoricalList((List)this._transactionNotes);
/*      */     } 
/*      */     
/* 1850 */     this._propertiesSavepoint = this._properties;
/* 1851 */     if (this._properties != null) {
/* 1852 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1853 */       while (it.hasNext()) {
/* 1854 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1856 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1860 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */