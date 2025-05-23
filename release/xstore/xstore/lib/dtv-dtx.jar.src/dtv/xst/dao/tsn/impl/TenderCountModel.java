/*      */ package dtv.xst.dao.tsn.impl;
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
/*      */ import dtv.xst.dao.tsn.ITenderCount;
/*      */ import dtv.xst.dao.tsn.ITenderCountProperty;
/*      */ import dtv.xst.dao.tsn.ITenderDenominationCount;
/*      */ import dtv.xst.dao.tsn.ITenderTypeCount;
/*      */ import dtv.xst.dao.tsn.TenderCountPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderCountModel extends AbstractDataModelWithPropertyImpl<ITenderCountProperty> implements ITenderCount {
/*      */   private static final long serialVersionUID = 715373179L;
/*      */   private ITenderTypeCount _parentTenderTypeCount;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<ITenderDenominationCount> _tenderDenominationCounts; private transient HistoricalList<ITenderDenominationCount> _tenderDenominationCountsSavepoint; private HistoricalList<ITenderCountProperty> _properties; private transient HistoricalList<ITenderCountProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new TenderCountDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TenderCountDAO getDAO_() {
/*   48 */     return (TenderCountDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDayDate() {
/*   56 */     return getDAO_().getBusinessDayDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDayDate(Date argBusinessDayDate) {
/*   64 */     if (setBusinessDayDate_noev(argBusinessDayDate) && 
/*   65 */       this._events != null && 
/*   66 */       postEventsForChanges()) {
/*   67 */       this._events.post(ITenderCount.SET_BUSINESSDAYDATE, argBusinessDayDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDayDate_noev(Date argBusinessDayDate) {
/*   74 */     boolean ev_postable = false;
/*      */     
/*   76 */     if ((getDAO_().getBusinessDayDate() == null && argBusinessDayDate != null) || (
/*   77 */       getDAO_().getBusinessDayDate() != null && !getDAO_().getBusinessDayDate().equals(argBusinessDayDate))) {
/*   78 */       getDAO_().setBusinessDayDate(argBusinessDayDate);
/*   79 */       ev_postable = true;
/*   80 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*   82 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((TenderDenominationCountModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
/*      */         }
/*      */       } 
/*   88 */       if (this._properties != null) {
/*      */         
/*   90 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*   91 */         while (it.hasNext())
/*      */         {
/*   93 */           ((TenderCountPropertyModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   98 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  106 */     if (getDAO_().getOrganizationId() != null) {
/*  107 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  110 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  119 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  120 */       this._events != null && 
/*  121 */       postEventsForChanges()) {
/*  122 */       this._events.post(ITenderCount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  129 */     boolean ev_postable = false;
/*      */     
/*  131 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  132 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  133 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  134 */       ev_postable = true;
/*  135 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*  137 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*  138 */         while (it.hasNext())
/*      */         {
/*  140 */           ((TenderDenominationCountModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  143 */       if (this._properties != null) {
/*      */         
/*  145 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*  146 */         while (it.hasNext())
/*      */         {
/*  148 */           ((TenderCountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  153 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  161 */     if (getDAO_().getRetailLocationId() != null) {
/*  162 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  165 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  174 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  175 */       this._events != null && 
/*  176 */       postEventsForChanges()) {
/*  177 */       this._events.post(ITenderCount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  184 */     boolean ev_postable = false;
/*      */     
/*  186 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  187 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  188 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  189 */       ev_postable = true;
/*  190 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*  192 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*  193 */         while (it.hasNext())
/*      */         {
/*  195 */           ((TenderDenominationCountModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  198 */       if (this._properties != null) {
/*      */         
/*  200 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*  201 */         while (it.hasNext())
/*      */         {
/*  203 */           ((TenderCountPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  208 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderId() {
/*  216 */     return getDAO_().getTenderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderId(String argTenderId) {
/*  224 */     if (setTenderId_noev(argTenderId) && 
/*  225 */       this._events != null && 
/*  226 */       postEventsForChanges()) {
/*  227 */       this._events.post(ITenderCount.SET_TENDERID, argTenderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderId_noev(String argTenderId) {
/*  234 */     boolean ev_postable = false;
/*      */     
/*  236 */     if ((getDAO_().getTenderId() == null && argTenderId != null) || (
/*  237 */       getDAO_().getTenderId() != null && !getDAO_().getTenderId().equals(argTenderId))) {
/*  238 */       getDAO_().setTenderId(argTenderId);
/*  239 */       ev_postable = true;
/*  240 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*  242 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*  243 */         while (it.hasNext())
/*      */         {
/*  245 */           ((TenderDenominationCountModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*  248 */       if (this._properties != null) {
/*      */         
/*  250 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*  251 */         while (it.hasNext())
/*      */         {
/*  253 */           ((TenderCountPropertyModel)it.next()).setTenderId_noev(argTenderId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  258 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTenderTypeCode() {
/*  266 */     return getDAO_().getTenderTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  274 */     if (setTenderTypeCode_noev(argTenderTypeCode) && 
/*  275 */       this._events != null && 
/*  276 */       postEventsForChanges()) {
/*  277 */       this._events.post(ITenderCount.SET_TENDERTYPECODE, argTenderTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderTypeCode_noev(String argTenderTypeCode) {
/*  284 */     boolean ev_postable = false;
/*      */     
/*  286 */     if ((getDAO_().getTenderTypeCode() == null && argTenderTypeCode != null) || (
/*  287 */       getDAO_().getTenderTypeCode() != null && !getDAO_().getTenderTypeCode().equals(argTenderTypeCode))) {
/*  288 */       getDAO_().setTenderTypeCode(argTenderTypeCode);
/*  289 */       ev_postable = true;
/*  290 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*  292 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*  293 */         while (it.hasNext())
/*      */         {
/*  295 */           ((TenderDenominationCountModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*      */         }
/*      */       } 
/*  298 */       if (this._properties != null) {
/*      */         
/*  300 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*  301 */         while (it.hasNext())
/*      */         {
/*  303 */           ((TenderCountPropertyModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  308 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  316 */     if (getDAO_().getTransactionSequence() != null) {
/*  317 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  320 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  329 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  330 */       this._events != null && 
/*  331 */       postEventsForChanges()) {
/*  332 */       this._events.post(ITenderCount.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  339 */     boolean ev_postable = false;
/*      */     
/*  341 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  342 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  343 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  344 */       ev_postable = true;
/*  345 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*  347 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*  348 */         while (it.hasNext())
/*      */         {
/*  350 */           ((TenderDenominationCountModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  353 */       if (this._properties != null) {
/*      */         
/*  355 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*  356 */         while (it.hasNext())
/*      */         {
/*  358 */           ((TenderCountPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  363 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  371 */     if (getDAO_().getWorkstationId() != null) {
/*  372 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  375 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  384 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  385 */       this._events != null && 
/*  386 */       postEventsForChanges()) {
/*  387 */       this._events.post(ITenderCount.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  394 */     boolean ev_postable = false;
/*      */     
/*  396 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  397 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  398 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  399 */       ev_postable = true;
/*  400 */       if (this._tenderDenominationCounts != null) {
/*      */         
/*  402 */         Iterator<TenderDenominationCountModel> it = this._tenderDenominationCounts.iterator();
/*  403 */         while (it.hasNext())
/*      */         {
/*  405 */           ((TenderDenominationCountModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  408 */       if (this._properties != null) {
/*      */         
/*  410 */         Iterator<TenderCountPropertyModel> it = this._properties.iterator();
/*  411 */         while (it.hasNext())
/*      */         {
/*  413 */           ((TenderCountPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  418 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  426 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  434 */     if (setCreateDate_noev(argCreateDate) && 
/*  435 */       this._events != null && 
/*  436 */       postEventsForChanges()) {
/*  437 */       this._events.post(ITenderCount.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  444 */     boolean ev_postable = false;
/*      */     
/*  446 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  447 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  448 */       getDAO_().setCreateDate(argCreateDate);
/*  449 */       ev_postable = true;
/*      */     } 
/*      */     
/*  452 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  460 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  468 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  469 */       this._events != null && 
/*  470 */       postEventsForChanges()) {
/*  471 */       this._events.post(ITenderCount.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  478 */     boolean ev_postable = false;
/*      */     
/*  480 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  481 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  482 */       getDAO_().setCreateUserId(argCreateUserId);
/*  483 */       ev_postable = true;
/*      */     } 
/*      */     
/*  486 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  494 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  502 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  503 */       this._events != null && 
/*  504 */       postEventsForChanges()) {
/*  505 */       this._events.post(ITenderCount.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  512 */     boolean ev_postable = false;
/*      */     
/*  514 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  515 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  516 */       getDAO_().setUpdateDate(argUpdateDate);
/*  517 */       ev_postable = true;
/*      */     } 
/*      */     
/*  520 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  528 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  536 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  537 */       this._events != null && 
/*  538 */       postEventsForChanges()) {
/*  539 */       this._events.post(ITenderCount.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  546 */     boolean ev_postable = false;
/*      */     
/*  548 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  549 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  550 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  551 */       ev_postable = true;
/*      */     } 
/*      */     
/*  554 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  562 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  570 */     if (setAmount_noev(argAmount) && 
/*  571 */       this._events != null && 
/*  572 */       postEventsForChanges()) {
/*  573 */       this._events.post(ITenderCount.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  580 */     boolean ev_postable = false;
/*      */     
/*  582 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  583 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  584 */       getDAO_().setAmount(argAmount);
/*  585 */       ev_postable = true;
/*      */     } 
/*      */     
/*  588 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDifferenceAmount() {
/*  596 */     return getDAO_().getDifferenceAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDifferenceAmount(BigDecimal argDifferenceAmount) {
/*  604 */     if (setDifferenceAmount_noev(argDifferenceAmount) && 
/*  605 */       this._events != null && 
/*  606 */       postEventsForChanges()) {
/*  607 */       this._events.post(ITenderCount.SET_DIFFERENCEAMOUNT, argDifferenceAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDifferenceAmount_noev(BigDecimal argDifferenceAmount) {
/*  614 */     boolean ev_postable = false;
/*      */     
/*  616 */     if ((getDAO_().getDifferenceAmount() == null && argDifferenceAmount != null) || (
/*  617 */       getDAO_().getDifferenceAmount() != null && !getDAO_().getDifferenceAmount().equals(argDifferenceAmount))) {
/*  618 */       getDAO_().setDifferenceAmount(argDifferenceAmount);
/*  619 */       ev_postable = true;
/*      */     } 
/*      */     
/*  622 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDifferenceMediaCount() {
/*  630 */     if (getDAO_().getDifferenceMediaCount() != null) {
/*  631 */       return getDAO_().getDifferenceMediaCount().intValue();
/*      */     }
/*      */     
/*  634 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDifferenceMediaCount(int argDifferenceMediaCount) {
/*  643 */     if (setDifferenceMediaCount_noev(argDifferenceMediaCount) && 
/*  644 */       this._events != null && 
/*  645 */       postEventsForChanges()) {
/*  646 */       this._events.post(ITenderCount.SET_DIFFERENCEMEDIACOUNT, Integer.valueOf(argDifferenceMediaCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDifferenceMediaCount_noev(int argDifferenceMediaCount) {
/*  653 */     boolean ev_postable = false;
/*      */     
/*  655 */     if ((getDAO_().getDifferenceMediaCount() == null && Integer.valueOf(argDifferenceMediaCount) != null) || (
/*  656 */       getDAO_().getDifferenceMediaCount() != null && !getDAO_().getDifferenceMediaCount().equals(Integer.valueOf(argDifferenceMediaCount)))) {
/*  657 */       getDAO_().setDifferenceMediaCount(Integer.valueOf(argDifferenceMediaCount));
/*  658 */       ev_postable = true;
/*      */     } 
/*      */     
/*  661 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMediaCount() {
/*  669 */     if (getDAO_().getMediaCount() != null) {
/*  670 */       return getDAO_().getMediaCount().intValue();
/*      */     }
/*      */     
/*  673 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMediaCount(int argMediaCount) {
/*  682 */     if (setMediaCount_noev(argMediaCount) && 
/*  683 */       this._events != null && 
/*  684 */       postEventsForChanges()) {
/*  685 */       this._events.post(ITenderCount.SET_MEDIACOUNT, Integer.valueOf(argMediaCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMediaCount_noev(int argMediaCount) {
/*  692 */     boolean ev_postable = false;
/*      */     
/*  694 */     if ((getDAO_().getMediaCount() == null && Integer.valueOf(argMediaCount) != null) || (
/*  695 */       getDAO_().getMediaCount() != null && !getDAO_().getMediaCount().equals(Integer.valueOf(argMediaCount)))) {
/*  696 */       getDAO_().setMediaCount(Integer.valueOf(argMediaCount));
/*  697 */       ev_postable = true;
/*      */     } 
/*      */     
/*  700 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDepositAmount() {
/*  708 */     return getDAO_().getDepositAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDepositAmount(BigDecimal argDepositAmount) {
/*  716 */     if (setDepositAmount_noev(argDepositAmount) && 
/*  717 */       this._events != null && 
/*  718 */       postEventsForChanges()) {
/*  719 */       this._events.post(ITenderCount.SET_DEPOSITAMOUNT, argDepositAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDepositAmount_noev(BigDecimal argDepositAmount) {
/*  726 */     boolean ev_postable = false;
/*      */     
/*  728 */     if ((getDAO_().getDepositAmount() == null && argDepositAmount != null) || (
/*  729 */       getDAO_().getDepositAmount() != null && !getDAO_().getDepositAmount().equals(argDepositAmount))) {
/*  730 */       getDAO_().setDepositAmount(argDepositAmount);
/*  731 */       ev_postable = true;
/*      */     } 
/*      */     
/*  734 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getLocalCurrencyAmount() {
/*  742 */     return getDAO_().getLocalCurrencyAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLocalCurrencyAmount(BigDecimal argLocalCurrencyAmount) {
/*  750 */     if (setLocalCurrencyAmount_noev(argLocalCurrencyAmount) && 
/*  751 */       this._events != null && 
/*  752 */       postEventsForChanges()) {
/*  753 */       this._events.post(ITenderCount.SET_LOCALCURRENCYAMOUNT, argLocalCurrencyAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLocalCurrencyAmount_noev(BigDecimal argLocalCurrencyAmount) {
/*  760 */     boolean ev_postable = false;
/*      */     
/*  762 */     if ((getDAO_().getLocalCurrencyAmount() == null && argLocalCurrencyAmount != null) || (
/*  763 */       getDAO_().getLocalCurrencyAmount() != null && !getDAO_().getLocalCurrencyAmount().equals(argLocalCurrencyAmount))) {
/*  764 */       getDAO_().setLocalCurrencyAmount(argLocalCurrencyAmount);
/*  765 */       ev_postable = true;
/*      */     } 
/*      */     
/*  768 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITenderCountProperty newProperty(String argPropertyName) {
/*  772 */     TenderCountPropertyId id = new TenderCountPropertyId();
/*      */     
/*  774 */     id.setBusinessDayDate(getBusinessDayDate());
/*  775 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  776 */     id.setTenderId(getTenderId());
/*  777 */     id.setTenderTypeCode(getTenderTypeCode());
/*  778 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  779 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  780 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  782 */     ITenderCountProperty prop = (ITenderCountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderCountProperty.class);
/*  783 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "TenderDenominationCounts")
/*      */   public List<ITenderDenominationCount> getTenderDenominationCounts() {
/*  795 */     if (this._tenderDenominationCounts == null) {
/*  796 */       this._tenderDenominationCounts = new HistoricalList(null);
/*      */     }
/*  798 */     return (List<ITenderDenominationCount>)this._tenderDenominationCounts;
/*      */   }
/*      */   
/*      */   public void setTenderDenominationCounts(List<ITenderDenominationCount> argTenderDenominationCounts) {
/*  802 */     if (this._tenderDenominationCounts == null) {
/*  803 */       this._tenderDenominationCounts = new HistoricalList(argTenderDenominationCounts);
/*      */     } else {
/*  805 */       this._tenderDenominationCounts.setCurrentList(argTenderDenominationCounts);
/*      */     } 
/*      */     
/*  808 */     for (ITenderDenominationCount child : this._tenderDenominationCounts) {
/*  809 */       child.setParentTenderCount(this);
/*      */     }
/*      */     
/*  812 */     for (ITenderDenominationCount child : this._tenderDenominationCounts) {
/*  813 */       TenderDenominationCountModel model = (TenderDenominationCountModel)child;
/*  814 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/*  815 */       model.setOrganizationId_noev(getOrganizationId());
/*  816 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  817 */       model.setTenderId_noev(getTenderId());
/*  818 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/*  819 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  820 */       model.setWorkstationId_noev(getWorkstationId());
/*  821 */       if (child instanceof IDataModelImpl) {
/*  822 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  823 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  824 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  825 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  828 */       if (postEventsForChanges()) {
/*  829 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTenderDenominationCount(ITenderDenominationCount argTenderDenominationCount) {
/*  836 */     argTenderDenominationCount.setParentTenderCount(this);
/*  837 */     if (this._tenderDenominationCounts == null) {
/*  838 */       this._tenderDenominationCounts = new HistoricalList(null);
/*      */     }
/*  840 */     argTenderDenominationCount.setBusinessDayDate(getBusinessDayDate());
/*  841 */     argTenderDenominationCount.setOrganizationId(getOrganizationId());
/*  842 */     argTenderDenominationCount.setRetailLocationId(getRetailLocationId());
/*  843 */     argTenderDenominationCount.setTenderId(getTenderId());
/*  844 */     argTenderDenominationCount.setTenderTypeCode(getTenderTypeCode());
/*  845 */     argTenderDenominationCount.setTransactionSequence(getTransactionSequence());
/*  846 */     argTenderDenominationCount.setWorkstationId(getWorkstationId());
/*  847 */     if (argTenderDenominationCount instanceof IDataModelImpl) {
/*  848 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderDenominationCount).getDAO();
/*  849 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  850 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  851 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  856 */     if (postEventsForChanges()) {
/*  857 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenominationCount));
/*      */     }
/*      */     
/*  860 */     this._tenderDenominationCounts.add(argTenderDenominationCount);
/*  861 */     if (postEventsForChanges()) {
/*  862 */       this._events.post(ITenderCount.ADD_TENDERDENOMINATIONCOUNTS, argTenderDenominationCount);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderDenominationCount(ITenderDenominationCount argTenderDenominationCount) {
/*  867 */     if (this._tenderDenominationCounts != null) {
/*      */       
/*  869 */       if (postEventsForChanges()) {
/*  870 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderDenominationCount));
/*      */       }
/*  872 */       this._tenderDenominationCounts.remove(argTenderDenominationCount);
/*      */       
/*  874 */       argTenderDenominationCount.setParentTenderCount(null);
/*  875 */       if (postEventsForChanges()) {
/*  876 */         this._events.post(ITenderCount.REMOVE_TENDERDENOMINATIONCOUNTS, argTenderDenominationCount);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITenderCountProperty> getProperties() {
/*  883 */     if (this._properties == null) {
/*  884 */       this._properties = new HistoricalList(null);
/*      */     }
/*  886 */     return (List<ITenderCountProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITenderCountProperty> argProperties) {
/*  890 */     if (this._properties == null) {
/*  891 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  893 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  896 */     for (ITenderCountProperty child : this._properties) {
/*  897 */       TenderCountPropertyModel model = (TenderCountPropertyModel)child;
/*  898 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/*  899 */       model.setOrganizationId_noev(getOrganizationId());
/*  900 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  901 */       model.setTenderId_noev(getTenderId());
/*  902 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/*  903 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  904 */       model.setWorkstationId_noev(getWorkstationId());
/*  905 */       if (child instanceof IDataModelImpl) {
/*  906 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  907 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  908 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  909 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  912 */       if (postEventsForChanges()) {
/*  913 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTenderCountProperty(ITenderCountProperty argTenderCountProperty) {
/*  919 */     if (this._properties == null) {
/*  920 */       this._properties = new HistoricalList(null);
/*      */     }
/*  922 */     argTenderCountProperty.setBusinessDayDate(getBusinessDayDate());
/*  923 */     argTenderCountProperty.setOrganizationId(getOrganizationId());
/*  924 */     argTenderCountProperty.setRetailLocationId(getRetailLocationId());
/*  925 */     argTenderCountProperty.setTenderId(getTenderId());
/*  926 */     argTenderCountProperty.setTenderTypeCode(getTenderTypeCode());
/*  927 */     argTenderCountProperty.setTransactionSequence(getTransactionSequence());
/*  928 */     argTenderCountProperty.setWorkstationId(getWorkstationId());
/*  929 */     if (argTenderCountProperty instanceof IDataModelImpl) {
/*  930 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderCountProperty).getDAO();
/*  931 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  932 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  933 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  938 */     if (postEventsForChanges()) {
/*  939 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderCountProperty));
/*      */     }
/*      */     
/*  942 */     this._properties.add(argTenderCountProperty);
/*  943 */     if (postEventsForChanges()) {
/*  944 */       this._events.post(ITenderCount.ADD_PROPERTIES, argTenderCountProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderCountProperty(ITenderCountProperty argTenderCountProperty) {
/*  949 */     if (this._properties != null) {
/*      */       
/*  951 */       if (postEventsForChanges()) {
/*  952 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderCountProperty));
/*      */       }
/*  954 */       this._properties.remove(argTenderCountProperty);
/*  955 */       if (postEventsForChanges()) {
/*  956 */         this._events.post(ITenderCount.REMOVE_PROPERTIES, argTenderCountProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentTenderTypeCount(ITenderTypeCount argParentTenderTypeCount) {
/*  962 */     this._parentTenderTypeCount = argParentTenderTypeCount;
/*      */   }
/*      */   
/*      */   public ITenderTypeCount getParentTenderTypeCount() {
/*  966 */     return this._parentTenderTypeCount;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  971 */     if ("TenderDenominationCounts".equals(argFieldId)) {
/*  972 */       return getTenderDenominationCounts();
/*      */     }
/*  974 */     if ("Properties".equals(argFieldId)) {
/*  975 */       return getProperties();
/*      */     }
/*  977 */     if ("TenderCountExtension".equals(argFieldId)) {
/*  978 */       return this._myExtension;
/*      */     }
/*      */     
/*  981 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  987 */     if ("TenderDenominationCounts".equals(argFieldId)) {
/*  988 */       setTenderDenominationCounts(changeToList(argValue, ITenderDenominationCount.class));
/*      */     }
/*  990 */     else if ("Properties".equals(argFieldId)) {
/*  991 */       setProperties(changeToList(argValue, ITenderCountProperty.class));
/*      */     }
/*  993 */     else if ("TenderCountExtension".equals(argFieldId)) {
/*  994 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  997 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1003 */     this._persistenceDefaults = argPD;
/* 1004 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1005 */     this._eventManager = argEM;
/* 1006 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1007 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1008 */     if (this._tenderDenominationCounts != null) {
/* 1009 */       for (ITenderDenominationCount relationship : this._tenderDenominationCounts) {
/* 1010 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1013 */     if (this._properties != null) {
/* 1014 */       for (ITenderCountProperty relationship : this._properties) {
/* 1015 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderCountExt() {
/* 1021 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderCountExt(IDataModel argExt) {
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
/* 1039 */     this._tenderDenominationCountsSavepoint = this._tenderDenominationCounts;
/* 1040 */     if (this._tenderDenominationCounts != null) {
/* 1041 */       this._tenderDenominationCountsSavepoint = new HistoricalList((List)this._tenderDenominationCounts);
/* 1042 */       Iterator<IDataModel> it = this._tenderDenominationCounts.iterator();
/* 1043 */       while (it.hasNext()) {
/* 1044 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1048 */     this._propertiesSavepoint = this._properties;
/* 1049 */     if (this._properties != null) {
/* 1050 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1051 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1052 */       while (it.hasNext()) {
/* 1053 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1058 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1063 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1066 */     super.rollbackChanges();
/*      */     
/* 1068 */     this._tenderDenominationCounts = this._tenderDenominationCountsSavepoint;
/* 1069 */     this._tenderDenominationCountsSavepoint = null;
/* 1070 */     if (this._tenderDenominationCounts != null) {
/* 1071 */       Iterator<IDataModel> it = this._tenderDenominationCounts.iterator();
/* 1072 */       while (it.hasNext()) {
/* 1073 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1077 */     this._properties = this._propertiesSavepoint;
/* 1078 */     this._propertiesSavepoint = null;
/* 1079 */     if (this._properties != null) {
/* 1080 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1081 */       while (it.hasNext()) {
/* 1082 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1090 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1093 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1096 */     super.commitTransaction();
/*      */     
/* 1098 */     this._tenderDenominationCountsSavepoint = this._tenderDenominationCounts;
/* 1099 */     if (this._tenderDenominationCounts != null) {
/* 1100 */       Iterator<IDataModel> it = this._tenderDenominationCounts.iterator();
/* 1101 */       while (it.hasNext()) {
/* 1102 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1104 */       this._tenderDenominationCounts = new HistoricalList((List)this._tenderDenominationCounts);
/*      */     } 
/*      */     
/* 1107 */     this._propertiesSavepoint = this._properties;
/* 1108 */     if (this._properties != null) {
/* 1109 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1110 */       while (it.hasNext()) {
/* 1111 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1113 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1117 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1122 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */