/*      */ package dtv.xst.dao.tsn.impl;
/*      */ 
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
/*      */ import dtv.xst.dao.com.IReasonCode;
/*      */ import dtv.xst.dao.crm.IParty;
/*      */ import dtv.xst.dao.trn.impl.PosTransactionModel;
/*      */ import dtv.xst.dao.tsn.ISession;
/*      */ import dtv.xst.dao.tsn.ITenderControlTransaction;
/*      */ import dtv.xst.dao.tsn.ITenderRepository;
/*      */ import dtv.xst.dao.tsn.ITenderTypeCount;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderControlTransactionModel
/*      */   extends PosTransactionModel
/*      */   implements ITenderControlTransaction
/*      */ {
/*      */   private static final long serialVersionUID = -645771435L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new TenderControlTransactionDAO());
/*      */   }
/*      */   private IParty _fundsReceiptParty; private transient IParty _fundsReceiptPartySavepoint; private ISession _inboundSession; private transient ISession _inboundSessionSavepoint; private ITenderRepository _inboundTenderRepository; private transient ITenderRepository _inboundTenderRepositorySavepoint;
/*      */   private ISession _outboundSession;
/*      */   private transient ISession _outboundSessionSavepoint;
/*      */   private ITenderRepository _outboundTenderRepository;
/*      */   
/*      */   private TenderControlTransactionDAO getDAO_() {
/*   46 */     return (TenderControlTransactionDAO)this._daoImpl;
/*      */   }
/*      */   private transient ITenderRepository _outboundTenderRepositorySavepoint; private IReasonCode _reasonCodeObject;
/*      */   private transient IReasonCode _reasonCodeObjectSavepoint;
/*      */   private HistoricalList<ITenderTypeCount> _tenderTypeCounts;
/*      */   private transient HistoricalList<ITenderTypeCount> _tenderTypeCountsSavepoint;
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
/*   67 */     if (setOrganizationId_noev(argOrganizationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   73 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*   76 */     if (super.setOrganizationId_noev(argOrganizationId) && 
/*   77 */       this._tenderTypeCounts != null) {
/*      */       
/*   79 */       Iterator<TenderTypeCountModel> it = this._tenderTypeCounts.iterator();
/*   80 */       while (it.hasNext())
/*      */       {
/*   82 */         ((TenderTypeCountModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*   87 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*   95 */     if (getDAO_().getRetailLocationId() != null) {
/*   96 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*   99 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  108 */     if (setRetailLocationId_noev(argRetailLocationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  114 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  117 */     if (super.setRetailLocationId_noev(argRetailLocationId) && 
/*  118 */       this._tenderTypeCounts != null) {
/*      */       
/*  120 */       Iterator<TenderTypeCountModel> it = this._tenderTypeCounts.iterator();
/*  121 */       while (it.hasNext())
/*      */       {
/*  123 */         ((TenderTypeCountModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  128 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  136 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  144 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  145 */       this._events != null && 
/*  146 */       postEventsForChanges()) {
/*  147 */       this._events.post(ITenderControlTransaction.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  154 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  157 */     if (super.setBusinessDate_noev(argBusinessDate) && 
/*  158 */       this._tenderTypeCounts != null) {
/*      */       
/*  160 */       Iterator<TenderTypeCountModel> it = this._tenderTypeCounts.iterator();
/*  161 */       while (it.hasNext())
/*      */       {
/*  163 */         ((TenderTypeCountModel)it.next()).setBusinessDayDate_noev(argBusinessDate);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  168 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  176 */     if (getDAO_().getWorkstationId() != null) {
/*  177 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  180 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  189 */     if (setWorkstationId_noev(argWorkstationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  195 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  198 */     if (super.setWorkstationId_noev(argWorkstationId) && 
/*  199 */       this._tenderTypeCounts != null) {
/*      */       
/*  201 */       Iterator<TenderTypeCountModel> it = this._tenderTypeCounts.iterator();
/*  202 */       while (it.hasNext())
/*      */       {
/*  204 */         ((TenderTypeCountModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  209 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  217 */     if (getDAO_().getTransactionSequence() != null) {
/*  218 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  221 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  230 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  231 */       this._events != null && 
/*  232 */       postEventsForChanges()) {
/*  233 */       this._events.post(ITenderControlTransaction.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  240 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  243 */     if (super.setTransactionSequence_noev(argTransactionSequence) && 
/*  244 */       this._tenderTypeCounts != null) {
/*      */       
/*  246 */       Iterator<TenderTypeCountModel> it = this._tenderTypeCounts.iterator();
/*  247 */       while (it.hasNext())
/*      */       {
/*  249 */         ((TenderTypeCountModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  254 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  262 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  270 */     if (setCreateDate_noev(argCreateDate) && 
/*  271 */       this._events != null && 
/*  272 */       postEventsForChanges()) {
/*  273 */       this._events.post(ITenderControlTransaction.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  280 */     boolean ev_postable = false;
/*      */     
/*  282 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  283 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  284 */       getDAO_().setCreateDate(argCreateDate);
/*  285 */       ev_postable = true;
/*      */     } 
/*      */     
/*  288 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  296 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  304 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  305 */       this._events != null && 
/*  306 */       postEventsForChanges()) {
/*  307 */       this._events.post(ITenderControlTransaction.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  314 */     boolean ev_postable = false;
/*      */     
/*  316 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  317 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  318 */       getDAO_().setCreateUserId(argCreateUserId);
/*  319 */       ev_postable = true;
/*      */     } 
/*      */     
/*  322 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  330 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  338 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  339 */       this._events != null && 
/*  340 */       postEventsForChanges()) {
/*  341 */       this._events.post(ITenderControlTransaction.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  348 */     boolean ev_postable = false;
/*      */     
/*  350 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  351 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  352 */       getDAO_().setUpdateDate(argUpdateDate);
/*  353 */       ev_postable = true;
/*      */     } 
/*      */     
/*  356 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  364 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  372 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  373 */       this._events != null && 
/*  374 */       postEventsForChanges()) {
/*  375 */       this._events.post(ITenderControlTransaction.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  382 */     boolean ev_postable = false;
/*      */     
/*  384 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  385 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  386 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  387 */       ev_postable = true;
/*      */     } 
/*      */     
/*  390 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  398 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  406 */     if (setAmount_noev(argAmount) && 
/*  407 */       this._events != null && 
/*  408 */       postEventsForChanges()) {
/*  409 */       this._events.post(ITenderControlTransaction.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  416 */     boolean ev_postable = false;
/*      */     
/*  418 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  419 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  420 */       getDAO_().setAmount(argAmount);
/*  421 */       ev_postable = true;
/*      */     } 
/*      */     
/*  424 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDepositDate() {
/*  432 */     return getDAO_().getDepositDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDepositDate(Date argDepositDate) {
/*  440 */     if (setDepositDate_noev(argDepositDate) && 
/*  441 */       this._events != null && 
/*  442 */       postEventsForChanges()) {
/*  443 */       this._events.post(ITenderControlTransaction.SET_DEPOSITDATE, argDepositDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDepositDate_noev(Date argDepositDate) {
/*  450 */     boolean ev_postable = false;
/*      */     
/*  452 */     if ((getDAO_().getDepositDate() == null && argDepositDate != null) || (
/*  453 */       getDAO_().getDepositDate() != null && !getDAO_().getDepositDate().equals(argDepositDate))) {
/*  454 */       getDAO_().setDepositDate(argDepositDate);
/*  455 */       ev_postable = true;
/*      */     } 
/*      */     
/*  458 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTypeCode() {
/*  466 */     return getDAO_().getTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTypeCode(String argTypeCode) {
/*  474 */     if (setTypeCode_noev(argTypeCode) && 
/*  475 */       this._events != null && 
/*  476 */       postEventsForChanges()) {
/*  477 */       this._events.post(ITenderControlTransaction.SET_TYPECODE, argTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTypeCode_noev(String argTypeCode) {
/*  484 */     boolean ev_postable = false;
/*      */     
/*  486 */     if ((getDAO_().getTypeCode() == null && argTypeCode != null) || (
/*  487 */       getDAO_().getTypeCode() != null && !getDAO_().getTypeCode().equals(argTypeCode))) {
/*  488 */       getDAO_().setTypeCode(argTypeCode);
/*  489 */       ev_postable = true;
/*      */     } 
/*      */     
/*  492 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getFundsReceiptPartyId() {
/*  500 */     if (getDAO_().getFundsReceiptPartyId() != null) {
/*  501 */       return getDAO_().getFundsReceiptPartyId().longValue();
/*      */     }
/*      */     
/*  504 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFundsReceiptPartyId(long argFundsReceiptPartyId) {
/*  513 */     if (setFundsReceiptPartyId_noev(argFundsReceiptPartyId) && 
/*  514 */       this._events != null && 
/*  515 */       postEventsForChanges()) {
/*  516 */       this._events.post(ITenderControlTransaction.SET_FUNDSRECEIPTPARTYID, Long.valueOf(argFundsReceiptPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFundsReceiptPartyId_noev(long argFundsReceiptPartyId) {
/*  523 */     boolean ev_postable = false;
/*      */     
/*  525 */     if ((getDAO_().getFundsReceiptPartyId() == null && Long.valueOf(argFundsReceiptPartyId) != null) || (
/*  526 */       getDAO_().getFundsReceiptPartyId() != null && !getDAO_().getFundsReceiptPartyId().equals(Long.valueOf(argFundsReceiptPartyId)))) {
/*  527 */       getDAO_().setFundsReceiptPartyId(Long.valueOf(argFundsReceiptPartyId));
/*  528 */       ev_postable = true;
/*      */     } 
/*      */     
/*  531 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getInboundSessionId() {
/*  539 */     if (getDAO_().getInboundSessionId() != null) {
/*  540 */       return getDAO_().getInboundSessionId().longValue();
/*      */     }
/*      */     
/*  543 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInboundSessionId(long argInboundSessionId) {
/*  552 */     if (setInboundSessionId_noev(argInboundSessionId) && 
/*  553 */       this._events != null && 
/*  554 */       postEventsForChanges()) {
/*  555 */       this._events.post(ITenderControlTransaction.SET_INBOUNDSESSIONID, Long.valueOf(argInboundSessionId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInboundSessionId_noev(long argInboundSessionId) {
/*  562 */     boolean ev_postable = false;
/*      */     
/*  564 */     if ((getDAO_().getInboundSessionId() == null && Long.valueOf(argInboundSessionId) != null) || (
/*  565 */       getDAO_().getInboundSessionId() != null && !getDAO_().getInboundSessionId().equals(Long.valueOf(argInboundSessionId)))) {
/*  566 */       getDAO_().setInboundSessionId(Long.valueOf(argInboundSessionId));
/*  567 */       ev_postable = true;
/*      */     } 
/*      */     
/*  570 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInboundTenderRepositoryId() {
/*  578 */     return getDAO_().getInboundTenderRepositoryId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInboundTenderRepositoryId(String argInboundTenderRepositoryId) {
/*  586 */     if (setInboundTenderRepositoryId_noev(argInboundTenderRepositoryId) && 
/*  587 */       this._events != null && 
/*  588 */       postEventsForChanges()) {
/*  589 */       this._events.post(ITenderControlTransaction.SET_INBOUNDTENDERREPOSITORYID, argInboundTenderRepositoryId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInboundTenderRepositoryId_noev(String argInboundTenderRepositoryId) {
/*  596 */     boolean ev_postable = false;
/*      */     
/*  598 */     if ((getDAO_().getInboundTenderRepositoryId() == null && argInboundTenderRepositoryId != null) || (
/*  599 */       getDAO_().getInboundTenderRepositoryId() != null && !getDAO_().getInboundTenderRepositoryId().equals(argInboundTenderRepositoryId))) {
/*  600 */       getDAO_().setInboundTenderRepositoryId(argInboundTenderRepositoryId);
/*  601 */       ev_postable = true;
/*      */     } 
/*      */     
/*  604 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOutboundSessionId() {
/*  612 */     if (getDAO_().getOutboundSessionId() != null) {
/*  613 */       return getDAO_().getOutboundSessionId().longValue();
/*      */     }
/*      */     
/*  616 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutboundSessionId(long argOutboundSessionId) {
/*  625 */     if (setOutboundSessionId_noev(argOutboundSessionId) && 
/*  626 */       this._events != null && 
/*  627 */       postEventsForChanges()) {
/*  628 */       this._events.post(ITenderControlTransaction.SET_OUTBOUNDSESSIONID, Long.valueOf(argOutboundSessionId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOutboundSessionId_noev(long argOutboundSessionId) {
/*  635 */     boolean ev_postable = false;
/*      */     
/*  637 */     if ((getDAO_().getOutboundSessionId() == null && Long.valueOf(argOutboundSessionId) != null) || (
/*  638 */       getDAO_().getOutboundSessionId() != null && !getDAO_().getOutboundSessionId().equals(Long.valueOf(argOutboundSessionId)))) {
/*  639 */       getDAO_().setOutboundSessionId(Long.valueOf(argOutboundSessionId));
/*  640 */       ev_postable = true;
/*      */     } 
/*      */     
/*  643 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOutboundTenderRepositoryId() {
/*  651 */     return getDAO_().getOutboundTenderRepositoryId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOutboundTenderRepositoryId(String argOutboundTenderRepositoryId) {
/*  659 */     if (setOutboundTenderRepositoryId_noev(argOutboundTenderRepositoryId) && 
/*  660 */       this._events != null && 
/*  661 */       postEventsForChanges()) {
/*  662 */       this._events.post(ITenderControlTransaction.SET_OUTBOUNDTENDERREPOSITORYID, argOutboundTenderRepositoryId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOutboundTenderRepositoryId_noev(String argOutboundTenderRepositoryId) {
/*  669 */     boolean ev_postable = false;
/*      */     
/*  671 */     if ((getDAO_().getOutboundTenderRepositoryId() == null && argOutboundTenderRepositoryId != null) || (
/*  672 */       getDAO_().getOutboundTenderRepositoryId() != null && !getDAO_().getOutboundTenderRepositoryId().equals(argOutboundTenderRepositoryId))) {
/*  673 */       getDAO_().setOutboundTenderRepositoryId(argOutboundTenderRepositoryId);
/*  674 */       ev_postable = true;
/*      */     } 
/*      */     
/*  677 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReasonCode() {
/*  685 */     return getDAO_().getReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReasonCode(String argReasonCode) {
/*  693 */     if (setReasonCode_noev(argReasonCode) && 
/*  694 */       this._events != null && 
/*  695 */       postEventsForChanges()) {
/*  696 */       this._events.post(ITenderControlTransaction.SET_REASONCODE, argReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReasonCode_noev(String argReasonCode) {
/*  703 */     boolean ev_postable = false;
/*      */     
/*  705 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/*  706 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/*  707 */       getDAO_().setReasonCode(argReasonCode);
/*  708 */       ev_postable = true;
/*      */     } 
/*      */     
/*  711 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSafeBagId() {
/*  719 */     return getDAO_().getSafeBagId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSafeBagId(String argSafeBagId) {
/*  727 */     if (setSafeBagId_noev(argSafeBagId) && 
/*  728 */       this._events != null && 
/*  729 */       postEventsForChanges()) {
/*  730 */       this._events.post(ITenderControlTransaction.SET_SAFEBAGID, argSafeBagId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSafeBagId_noev(String argSafeBagId) {
/*  737 */     boolean ev_postable = false;
/*      */     
/*  739 */     if ((getDAO_().getSafeBagId() == null && argSafeBagId != null) || (
/*  740 */       getDAO_().getSafeBagId() != null && !getDAO_().getSafeBagId().equals(argSafeBagId))) {
/*  741 */       getDAO_().setSafeBagId(argSafeBagId);
/*  742 */       ev_postable = true;
/*      */     } 
/*      */     
/*  745 */     return ev_postable;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "FundsReceiptParty")
/*      */   public IParty getFundsReceiptParty() {
/*  772 */     return this._fundsReceiptParty;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFundsReceiptParty(IParty argFundsReceiptParty) {
/*  777 */     if (argFundsReceiptParty == null) {
/*      */       
/*  779 */       getDAO_().setFundsReceiptPartyId((Long)null);
/*  780 */       if (this._fundsReceiptParty != null)
/*      */       {
/*  782 */         if (postEventsForChanges()) {
/*  783 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._fundsReceiptParty));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  788 */       getDAO_().setFundsReceiptPartyId(Long.valueOf(argFundsReceiptParty.getPartyId()));
/*      */       
/*  790 */       if (postEventsForChanges()) {
/*  791 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFundsReceiptParty));
/*      */       }
/*      */     } 
/*      */     
/*  795 */     this._fundsReceiptParty = argFundsReceiptParty;
/*  796 */     if (postEventsForChanges()) {
/*  797 */       this._events.post(ITenderControlTransaction.SET_FUNDSRECEIPTPARTY, argFundsReceiptParty);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "InboundSession")
/*      */   public ISession getInboundSession() {
/*  803 */     return this._inboundSession;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInboundSession(ISession argInboundSession) {
/*  808 */     if (argInboundSession == null) {
/*      */       
/*  810 */       getDAO_().setInboundSessionId((Long)null);
/*  811 */       if (this._inboundSession != null)
/*      */       {
/*  813 */         if (postEventsForChanges()) {
/*  814 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inboundSession));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  819 */       getDAO_().setInboundSessionId(Long.valueOf(argInboundSession.getSessionId()));
/*      */       
/*  821 */       if (postEventsForChanges()) {
/*  822 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInboundSession));
/*      */       }
/*      */     } 
/*      */     
/*  826 */     this._inboundSession = argInboundSession;
/*  827 */     if (postEventsForChanges()) {
/*  828 */       this._events.post(ITenderControlTransaction.SET_INBOUNDSESSION, argInboundSession);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "InboundTenderRepository")
/*      */   public ITenderRepository getInboundTenderRepository() {
/*  834 */     return this._inboundTenderRepository;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInboundTenderRepository(ITenderRepository argInboundTenderRepository) {
/*  839 */     if (argInboundTenderRepository == null) {
/*      */       
/*  841 */       getDAO_().setInboundTenderRepositoryId((String)null);
/*  842 */       if (this._inboundTenderRepository != null)
/*      */       {
/*  844 */         if (postEventsForChanges()) {
/*  845 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inboundTenderRepository));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  850 */       getDAO_().setInboundTenderRepositoryId(argInboundTenderRepository.getTenderRepositoryId());
/*      */       
/*  852 */       if (postEventsForChanges()) {
/*  853 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInboundTenderRepository));
/*      */       }
/*      */     } 
/*      */     
/*  857 */     this._inboundTenderRepository = argInboundTenderRepository;
/*  858 */     if (postEventsForChanges()) {
/*  859 */       this._events.post(ITenderControlTransaction.SET_INBOUNDTENDERREPOSITORY, argInboundTenderRepository);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "OutboundSession")
/*      */   public ISession getOutboundSession() {
/*  865 */     return this._outboundSession;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOutboundSession(ISession argOutboundSession) {
/*  870 */     if (argOutboundSession == null) {
/*      */       
/*  872 */       getDAO_().setOutboundSessionId((Long)null);
/*  873 */       if (this._outboundSession != null)
/*      */       {
/*  875 */         if (postEventsForChanges()) {
/*  876 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._outboundSession));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  881 */       getDAO_().setOutboundSessionId(Long.valueOf(argOutboundSession.getSessionId()));
/*      */       
/*  883 */       if (postEventsForChanges()) {
/*  884 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOutboundSession));
/*      */       }
/*      */     } 
/*      */     
/*  888 */     this._outboundSession = argOutboundSession;
/*  889 */     if (postEventsForChanges()) {
/*  890 */       this._events.post(ITenderControlTransaction.SET_OUTBOUNDSESSION, argOutboundSession);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "OutboundTenderRepository")
/*      */   public ITenderRepository getOutboundTenderRepository() {
/*  896 */     return this._outboundTenderRepository;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOutboundTenderRepository(ITenderRepository argOutboundTenderRepository) {
/*  901 */     if (argOutboundTenderRepository == null) {
/*      */       
/*  903 */       getDAO_().setOutboundTenderRepositoryId((String)null);
/*  904 */       if (this._outboundTenderRepository != null)
/*      */       {
/*  906 */         if (postEventsForChanges()) {
/*  907 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._outboundTenderRepository));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  912 */       getDAO_().setOutboundTenderRepositoryId(argOutboundTenderRepository.getTenderRepositoryId());
/*      */       
/*  914 */       if (postEventsForChanges()) {
/*  915 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOutboundTenderRepository));
/*      */       }
/*      */     } 
/*      */     
/*  919 */     this._outboundTenderRepository = argOutboundTenderRepository;
/*  920 */     if (postEventsForChanges()) {
/*  921 */       this._events.post(ITenderControlTransaction.SET_OUTBOUNDTENDERREPOSITORY, argOutboundTenderRepository);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "ReasonCodeObject")
/*      */   public IReasonCode getReasonCodeObject() {
/*  927 */     return this._reasonCodeObject;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setReasonCodeObject(IReasonCode argReasonCodeObject) {
/*  932 */     if (argReasonCodeObject == null) {
/*      */       
/*  934 */       getDAO_().setReasonCode((String)null);
/*  935 */       if (this._reasonCodeObject != null)
/*      */       {
/*  937 */         if (postEventsForChanges()) {
/*  938 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._reasonCodeObject));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  943 */       getDAO_().setReasonCode(argReasonCodeObject.getReasonCode());
/*      */       
/*  945 */       if (postEventsForChanges()) {
/*  946 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argReasonCodeObject));
/*      */       }
/*      */     } 
/*      */     
/*  950 */     this._reasonCodeObject = argReasonCodeObject;
/*  951 */     if (postEventsForChanges()) {
/*  952 */       this._events.post(ITenderControlTransaction.SET_REASONCODEOBJECT, argReasonCodeObject);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "TenderTypeCounts")
/*      */   public List<ITenderTypeCount> getTenderTypeCounts() {
/*  958 */     if (this._tenderTypeCounts == null) {
/*  959 */       this._tenderTypeCounts = new HistoricalList(null);
/*      */     }
/*  961 */     return (List<ITenderTypeCount>)this._tenderTypeCounts;
/*      */   }
/*      */   
/*      */   public void setTenderTypeCounts(List<ITenderTypeCount> argTenderTypeCounts) {
/*  965 */     if (this._tenderTypeCounts == null) {
/*  966 */       this._tenderTypeCounts = new HistoricalList(argTenderTypeCounts);
/*      */     } else {
/*  968 */       this._tenderTypeCounts.setCurrentList(argTenderTypeCounts);
/*      */     } 
/*      */     
/*  971 */     for (ITenderTypeCount child : this._tenderTypeCounts) {
/*  972 */       child.setParentTenderControlTransaction(this);
/*      */     }
/*      */     
/*  975 */     for (ITenderTypeCount child : this._tenderTypeCounts) {
/*  976 */       TenderTypeCountModel model = (TenderTypeCountModel)child;
/*  977 */       model.setBusinessDayDate_noev(getBusinessDate());
/*  978 */       model.setOrganizationId_noev(getOrganizationId());
/*  979 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  980 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  981 */       model.setWorkstationId_noev(getWorkstationId());
/*  982 */       if (child instanceof IDataModelImpl) {
/*  983 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  984 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  985 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  986 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  989 */       if (postEventsForChanges()) {
/*  990 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTenderTypeCount(ITenderTypeCount argTenderTypeCount) {
/*  997 */     argTenderTypeCount.setParentTenderControlTransaction(this);
/*  998 */     if (this._tenderTypeCounts == null) {
/*  999 */       this._tenderTypeCounts = new HistoricalList(null);
/*      */     }
/* 1001 */     argTenderTypeCount.setBusinessDayDate(getBusinessDate());
/* 1002 */     argTenderTypeCount.setOrganizationId(getOrganizationId());
/* 1003 */     argTenderTypeCount.setRetailLocationId(getRetailLocationId());
/* 1004 */     argTenderTypeCount.setTransactionSequence(getTransactionSequence());
/* 1005 */     argTenderTypeCount.setWorkstationId(getWorkstationId());
/* 1006 */     if (argTenderTypeCount instanceof IDataModelImpl) {
/* 1007 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderTypeCount).getDAO();
/* 1008 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1009 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1010 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1015 */     if (postEventsForChanges()) {
/* 1016 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderTypeCount));
/*      */     }
/*      */     
/* 1019 */     this._tenderTypeCounts.add(argTenderTypeCount);
/* 1020 */     if (postEventsForChanges()) {
/* 1021 */       this._events.post(ITenderControlTransaction.ADD_TENDERTYPECOUNTS, argTenderTypeCount);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderTypeCount(ITenderTypeCount argTenderTypeCount) {
/* 1026 */     if (this._tenderTypeCounts != null) {
/*      */       
/* 1028 */       if (postEventsForChanges()) {
/* 1029 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderTypeCount));
/*      */       }
/* 1031 */       this._tenderTypeCounts.remove(argTenderTypeCount);
/*      */       
/* 1033 */       argTenderTypeCount.setParentTenderControlTransaction(null);
/* 1034 */       if (postEventsForChanges()) {
/* 1035 */         this._events.post(ITenderControlTransaction.REMOVE_TENDERTYPECOUNTS, argTenderTypeCount);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1042 */     if ("FundsReceiptParty".equals(argFieldId)) {
/* 1043 */       return getFundsReceiptParty();
/*      */     }
/* 1045 */     if ("InboundSession".equals(argFieldId)) {
/* 1046 */       return getInboundSession();
/*      */     }
/* 1048 */     if ("InboundTenderRepository".equals(argFieldId)) {
/* 1049 */       return getInboundTenderRepository();
/*      */     }
/* 1051 */     if ("OutboundSession".equals(argFieldId)) {
/* 1052 */       return getOutboundSession();
/*      */     }
/* 1054 */     if ("OutboundTenderRepository".equals(argFieldId)) {
/* 1055 */       return getOutboundTenderRepository();
/*      */     }
/* 1057 */     if ("ReasonCodeObject".equals(argFieldId)) {
/* 1058 */       return getReasonCodeObject();
/*      */     }
/* 1060 */     if ("TenderTypeCounts".equals(argFieldId)) {
/* 1061 */       return getTenderTypeCounts();
/*      */     }
/* 1063 */     if ("TenderControlTransactionExtension".equals(argFieldId)) {
/* 1064 */       return this._myExtension;
/*      */     }
/*      */     
/* 1067 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1073 */     if ("FundsReceiptParty".equals(argFieldId)) {
/* 1074 */       setFundsReceiptParty((IParty)argValue);
/*      */     }
/* 1076 */     else if ("InboundSession".equals(argFieldId)) {
/* 1077 */       setInboundSession((ISession)argValue);
/*      */     }
/* 1079 */     else if ("InboundTenderRepository".equals(argFieldId)) {
/* 1080 */       setInboundTenderRepository((ITenderRepository)argValue);
/*      */     }
/* 1082 */     else if ("OutboundSession".equals(argFieldId)) {
/* 1083 */       setOutboundSession((ISession)argValue);
/*      */     }
/* 1085 */     else if ("OutboundTenderRepository".equals(argFieldId)) {
/* 1086 */       setOutboundTenderRepository((ITenderRepository)argValue);
/*      */     }
/* 1088 */     else if ("ReasonCodeObject".equals(argFieldId)) {
/* 1089 */       setReasonCodeObject((IReasonCode)argValue);
/*      */     }
/* 1091 */     else if ("TenderTypeCounts".equals(argFieldId)) {
/* 1092 */       setTenderTypeCounts(changeToList(argValue, ITenderTypeCount.class));
/*      */     }
/* 1094 */     else if ("TenderControlTransactionExtension".equals(argFieldId)) {
/* 1095 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1098 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1104 */     super.setDependencies(argPD, argEM);
/* 1105 */     if (this._fundsReceiptParty != null) {
/* 1106 */       ((IDataModelImpl)this._fundsReceiptParty).setDependencies(argPD, argEM);
/*      */     }
/* 1108 */     if (this._inboundSession != null) {
/* 1109 */       ((IDataModelImpl)this._inboundSession).setDependencies(argPD, argEM);
/*      */     }
/* 1111 */     if (this._inboundTenderRepository != null) {
/* 1112 */       ((IDataModelImpl)this._inboundTenderRepository).setDependencies(argPD, argEM);
/*      */     }
/* 1114 */     if (this._outboundSession != null) {
/* 1115 */       ((IDataModelImpl)this._outboundSession).setDependencies(argPD, argEM);
/*      */     }
/* 1117 */     if (this._outboundTenderRepository != null) {
/* 1118 */       ((IDataModelImpl)this._outboundTenderRepository).setDependencies(argPD, argEM);
/*      */     }
/* 1120 */     if (this._reasonCodeObject != null) {
/* 1121 */       ((IDataModelImpl)this._reasonCodeObject).setDependencies(argPD, argEM);
/*      */     }
/* 1123 */     if (this._tenderTypeCounts != null) {
/* 1124 */       for (ITenderTypeCount relationship : this._tenderTypeCounts) {
/* 1125 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderControlTransactionExt() {
/* 1131 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderControlTransactionExt(IDataModel argExt) {
/* 1135 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1140 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1144 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1147 */     super.startTransaction();
/*      */     
/* 1149 */     this._fundsReceiptPartySavepoint = this._fundsReceiptParty;
/* 1150 */     if (this._fundsReceiptParty != null) {
/* 1151 */       this._fundsReceiptParty.startTransaction();
/*      */     }
/*      */     
/* 1154 */     this._inboundSessionSavepoint = this._inboundSession;
/* 1155 */     if (this._inboundSession != null) {
/* 1156 */       this._inboundSession.startTransaction();
/*      */     }
/*      */     
/* 1159 */     this._inboundTenderRepositorySavepoint = this._inboundTenderRepository;
/* 1160 */     if (this._inboundTenderRepository != null) {
/* 1161 */       this._inboundTenderRepository.startTransaction();
/*      */     }
/*      */     
/* 1164 */     this._outboundSessionSavepoint = this._outboundSession;
/* 1165 */     if (this._outboundSession != null) {
/* 1166 */       this._outboundSession.startTransaction();
/*      */     }
/*      */     
/* 1169 */     this._outboundTenderRepositorySavepoint = this._outboundTenderRepository;
/* 1170 */     if (this._outboundTenderRepository != null) {
/* 1171 */       this._outboundTenderRepository.startTransaction();
/*      */     }
/*      */     
/* 1174 */     this._reasonCodeObjectSavepoint = this._reasonCodeObject;
/* 1175 */     if (this._reasonCodeObject != null) {
/* 1176 */       this._reasonCodeObject.startTransaction();
/*      */     }
/*      */     
/* 1179 */     this._tenderTypeCountsSavepoint = this._tenderTypeCounts;
/* 1180 */     if (this._tenderTypeCounts != null) {
/* 1181 */       this._tenderTypeCountsSavepoint = new HistoricalList((List)this._tenderTypeCounts);
/* 1182 */       Iterator<IDataModel> it = this._tenderTypeCounts.iterator();
/* 1183 */       while (it.hasNext()) {
/* 1184 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1189 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1194 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1197 */     super.rollbackChanges();
/*      */     
/* 1199 */     this._fundsReceiptParty = this._fundsReceiptPartySavepoint;
/* 1200 */     this._fundsReceiptPartySavepoint = null;
/* 1201 */     if (this._fundsReceiptParty != null) {
/* 1202 */       this._fundsReceiptParty.rollbackChanges();
/*      */     }
/*      */     
/* 1205 */     this._inboundSession = this._inboundSessionSavepoint;
/* 1206 */     this._inboundSessionSavepoint = null;
/* 1207 */     if (this._inboundSession != null) {
/* 1208 */       this._inboundSession.rollbackChanges();
/*      */     }
/*      */     
/* 1211 */     this._inboundTenderRepository = this._inboundTenderRepositorySavepoint;
/* 1212 */     this._inboundTenderRepositorySavepoint = null;
/* 1213 */     if (this._inboundTenderRepository != null) {
/* 1214 */       this._inboundTenderRepository.rollbackChanges();
/*      */     }
/*      */     
/* 1217 */     this._outboundSession = this._outboundSessionSavepoint;
/* 1218 */     this._outboundSessionSavepoint = null;
/* 1219 */     if (this._outboundSession != null) {
/* 1220 */       this._outboundSession.rollbackChanges();
/*      */     }
/*      */     
/* 1223 */     this._outboundTenderRepository = this._outboundTenderRepositorySavepoint;
/* 1224 */     this._outboundTenderRepositorySavepoint = null;
/* 1225 */     if (this._outboundTenderRepository != null) {
/* 1226 */       this._outboundTenderRepository.rollbackChanges();
/*      */     }
/*      */     
/* 1229 */     this._reasonCodeObject = this._reasonCodeObjectSavepoint;
/* 1230 */     this._reasonCodeObjectSavepoint = null;
/* 1231 */     if (this._reasonCodeObject != null) {
/* 1232 */       this._reasonCodeObject.rollbackChanges();
/*      */     }
/*      */     
/* 1235 */     this._tenderTypeCounts = this._tenderTypeCountsSavepoint;
/* 1236 */     this._tenderTypeCountsSavepoint = null;
/* 1237 */     if (this._tenderTypeCounts != null) {
/* 1238 */       Iterator<IDataModel> it = this._tenderTypeCounts.iterator();
/* 1239 */       while (it.hasNext()) {
/* 1240 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1248 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1251 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1254 */     super.commitTransaction();
/*      */     
/* 1256 */     this._fundsReceiptPartySavepoint = this._fundsReceiptParty;
/* 1257 */     if (this._fundsReceiptParty != null) {
/* 1258 */       this._fundsReceiptParty.commitTransaction();
/*      */     }
/*      */     
/* 1261 */     this._inboundSessionSavepoint = this._inboundSession;
/* 1262 */     if (this._inboundSession != null) {
/* 1263 */       this._inboundSession.commitTransaction();
/*      */     }
/*      */     
/* 1266 */     this._inboundTenderRepositorySavepoint = this._inboundTenderRepository;
/* 1267 */     if (this._inboundTenderRepository != null) {
/* 1268 */       this._inboundTenderRepository.commitTransaction();
/*      */     }
/*      */     
/* 1271 */     this._outboundSessionSavepoint = this._outboundSession;
/* 1272 */     if (this._outboundSession != null) {
/* 1273 */       this._outboundSession.commitTransaction();
/*      */     }
/*      */     
/* 1276 */     this._outboundTenderRepositorySavepoint = this._outboundTenderRepository;
/* 1277 */     if (this._outboundTenderRepository != null) {
/* 1278 */       this._outboundTenderRepository.commitTransaction();
/*      */     }
/*      */     
/* 1281 */     this._reasonCodeObjectSavepoint = this._reasonCodeObject;
/* 1282 */     if (this._reasonCodeObject != null) {
/* 1283 */       this._reasonCodeObject.commitTransaction();
/*      */     }
/*      */     
/* 1286 */     this._tenderTypeCountsSavepoint = this._tenderTypeCounts;
/* 1287 */     if (this._tenderTypeCounts != null) {
/* 1288 */       Iterator<IDataModel> it = this._tenderTypeCounts.iterator();
/* 1289 */       while (it.hasNext()) {
/* 1290 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1292 */       this._tenderTypeCounts = new HistoricalList((List)this._tenderTypeCounts);
/*      */     } 
/*      */ 
/*      */     
/* 1296 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1301 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderControlTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */