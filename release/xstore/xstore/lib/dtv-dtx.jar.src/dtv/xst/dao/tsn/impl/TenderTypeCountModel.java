/*      */ package dtv.xst.dao.tsn.impl;
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
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.tsn.ITenderControlTransaction;
/*      */ import dtv.xst.dao.tsn.ITenderCount;
/*      */ import dtv.xst.dao.tsn.ITenderSerializedCount;
/*      */ import dtv.xst.dao.tsn.ITenderTypeCount;
/*      */ import dtv.xst.dao.tsn.ITenderTypeCountProperty;
/*      */ import dtv.xst.dao.tsn.TenderTypeCountPropertyId;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderTypeCountModel extends AbstractDataModelWithPropertyImpl<ITenderTypeCountProperty> implements ITenderTypeCount {
/*      */   private static final long serialVersionUID = 838474081L;
/*      */   private ITenderControlTransaction _parentTenderControlTransaction;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<ITenderCount> _tenderCounts; private transient HistoricalList<ITenderCount> _tenderCountsSavepoint; private HistoricalList<ITenderSerializedCount> _tenderSerializedCounts; private transient HistoricalList<ITenderSerializedCount> _tenderSerializedCountsSavepoint; private HistoricalList<ITenderTypeCountProperty> _properties; private transient HistoricalList<ITenderTypeCountProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new TenderTypeCountDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TenderTypeCountDAO getDAO_() {
/*   48 */     return (TenderTypeCountDAO)this._daoImpl;
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
/*   67 */       this._events.post(ITenderTypeCount.SET_BUSINESSDAYDATE, argBusinessDayDate);
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
/*   80 */       if (this._tenderCounts != null) {
/*      */         
/*   82 */         Iterator<TenderCountModel> it = this._tenderCounts.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((TenderCountModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
/*      */         }
/*      */       } 
/*   88 */       if (this._tenderSerializedCounts != null) {
/*      */         
/*   90 */         Iterator<TenderSerializedCountModel> it = this._tenderSerializedCounts.iterator();
/*   91 */         while (it.hasNext())
/*      */         {
/*   93 */           ((TenderSerializedCountModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
/*      */         }
/*      */       } 
/*   96 */       if (this._properties != null) {
/*      */         
/*   98 */         Iterator<TenderTypeCountPropertyModel> it = this._properties.iterator();
/*   99 */         while (it.hasNext())
/*      */         {
/*  101 */           ((TenderTypeCountPropertyModel)it.next()).setBusinessDayDate_noev(argBusinessDayDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  106 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*  114 */     if (getDAO_().getOrganizationId() != null) {
/*  115 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  118 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  127 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  128 */       this._events != null && 
/*  129 */       postEventsForChanges()) {
/*  130 */       this._events.post(ITenderTypeCount.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  137 */     boolean ev_postable = false;
/*      */     
/*  139 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  140 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  141 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  142 */       ev_postable = true;
/*  143 */       if (this._tenderCounts != null) {
/*      */         
/*  145 */         Iterator<TenderCountModel> it = this._tenderCounts.iterator();
/*  146 */         while (it.hasNext())
/*      */         {
/*  148 */           ((TenderCountModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  151 */       if (this._tenderSerializedCounts != null) {
/*      */         
/*  153 */         Iterator<TenderSerializedCountModel> it = this._tenderSerializedCounts.iterator();
/*  154 */         while (it.hasNext())
/*      */         {
/*  156 */           ((TenderSerializedCountModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  159 */       if (this._properties != null) {
/*      */         
/*  161 */         Iterator<TenderTypeCountPropertyModel> it = this._properties.iterator();
/*  162 */         while (it.hasNext())
/*      */         {
/*  164 */           ((TenderTypeCountPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  169 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  177 */     if (getDAO_().getRetailLocationId() != null) {
/*  178 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  181 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  190 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  191 */       this._events != null && 
/*  192 */       postEventsForChanges()) {
/*  193 */       this._events.post(ITenderTypeCount.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  200 */     boolean ev_postable = false;
/*      */     
/*  202 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  203 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  204 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  205 */       ev_postable = true;
/*  206 */       if (this._tenderCounts != null) {
/*      */         
/*  208 */         Iterator<TenderCountModel> it = this._tenderCounts.iterator();
/*  209 */         while (it.hasNext())
/*      */         {
/*  211 */           ((TenderCountModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  214 */       if (this._tenderSerializedCounts != null) {
/*      */         
/*  216 */         Iterator<TenderSerializedCountModel> it = this._tenderSerializedCounts.iterator();
/*  217 */         while (it.hasNext())
/*      */         {
/*  219 */           ((TenderSerializedCountModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  222 */       if (this._properties != null) {
/*      */         
/*  224 */         Iterator<TenderTypeCountPropertyModel> it = this._properties.iterator();
/*  225 */         while (it.hasNext())
/*      */         {
/*  227 */           ((TenderTypeCountPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
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
/*      */   public String getTenderTypeCode() {
/*  240 */     return getDAO_().getTenderTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTenderTypeCode(String argTenderTypeCode) {
/*  248 */     if (setTenderTypeCode_noev(argTenderTypeCode) && 
/*  249 */       this._events != null && 
/*  250 */       postEventsForChanges()) {
/*  251 */       this._events.post(ITenderTypeCount.SET_TENDERTYPECODE, argTenderTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTenderTypeCode_noev(String argTenderTypeCode) {
/*  258 */     boolean ev_postable = false;
/*      */     
/*  260 */     if ((getDAO_().getTenderTypeCode() == null && argTenderTypeCode != null) || (
/*  261 */       getDAO_().getTenderTypeCode() != null && !getDAO_().getTenderTypeCode().equals(argTenderTypeCode))) {
/*  262 */       getDAO_().setTenderTypeCode(argTenderTypeCode);
/*  263 */       ev_postable = true;
/*  264 */       if (this._tenderCounts != null) {
/*      */         
/*  266 */         Iterator<TenderCountModel> it = this._tenderCounts.iterator();
/*  267 */         while (it.hasNext())
/*      */         {
/*  269 */           ((TenderCountModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*      */         }
/*      */       } 
/*  272 */       if (this._tenderSerializedCounts != null) {
/*      */         
/*  274 */         Iterator<TenderSerializedCountModel> it = this._tenderSerializedCounts.iterator();
/*  275 */         while (it.hasNext())
/*      */         {
/*  277 */           ((TenderSerializedCountModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*      */         }
/*      */       } 
/*  280 */       if (this._properties != null) {
/*      */         
/*  282 */         Iterator<TenderTypeCountPropertyModel> it = this._properties.iterator();
/*  283 */         while (it.hasNext())
/*      */         {
/*  285 */           ((TenderTypeCountPropertyModel)it.next()).setTenderTypeCode_noev(argTenderTypeCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  290 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  298 */     if (getDAO_().getTransactionSequence() != null) {
/*  299 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  302 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  311 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  312 */       this._events != null && 
/*  313 */       postEventsForChanges()) {
/*  314 */       this._events.post(ITenderTypeCount.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  321 */     boolean ev_postable = false;
/*      */     
/*  323 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  324 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  325 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  326 */       ev_postable = true;
/*  327 */       if (this._tenderCounts != null) {
/*      */         
/*  329 */         Iterator<TenderCountModel> it = this._tenderCounts.iterator();
/*  330 */         while (it.hasNext())
/*      */         {
/*  332 */           ((TenderCountModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  335 */       if (this._tenderSerializedCounts != null) {
/*      */         
/*  337 */         Iterator<TenderSerializedCountModel> it = this._tenderSerializedCounts.iterator();
/*  338 */         while (it.hasNext())
/*      */         {
/*  340 */           ((TenderSerializedCountModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  343 */       if (this._properties != null) {
/*      */         
/*  345 */         Iterator<TenderTypeCountPropertyModel> it = this._properties.iterator();
/*  346 */         while (it.hasNext())
/*      */         {
/*  348 */           ((TenderTypeCountPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  353 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  361 */     if (getDAO_().getWorkstationId() != null) {
/*  362 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  365 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  374 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  375 */       this._events != null && 
/*  376 */       postEventsForChanges()) {
/*  377 */       this._events.post(ITenderTypeCount.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  384 */     boolean ev_postable = false;
/*      */     
/*  386 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  387 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  388 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  389 */       ev_postable = true;
/*  390 */       if (this._tenderCounts != null) {
/*      */         
/*  392 */         Iterator<TenderCountModel> it = this._tenderCounts.iterator();
/*  393 */         while (it.hasNext())
/*      */         {
/*  395 */           ((TenderCountModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  398 */       if (this._tenderSerializedCounts != null) {
/*      */         
/*  400 */         Iterator<TenderSerializedCountModel> it = this._tenderSerializedCounts.iterator();
/*  401 */         while (it.hasNext())
/*      */         {
/*  403 */           ((TenderSerializedCountModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  406 */       if (this._properties != null) {
/*      */         
/*  408 */         Iterator<TenderTypeCountPropertyModel> it = this._properties.iterator();
/*  409 */         while (it.hasNext())
/*      */         {
/*  411 */           ((TenderTypeCountPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
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
/*  432 */     if (setCreateDate_noev(argCreateDate) && 
/*  433 */       this._events != null && 
/*  434 */       postEventsForChanges()) {
/*  435 */       this._events.post(ITenderTypeCount.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  442 */     boolean ev_postable = false;
/*      */     
/*  444 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  445 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  446 */       getDAO_().setCreateDate(argCreateDate);
/*  447 */       ev_postable = true;
/*      */     } 
/*      */     
/*  450 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  458 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  466 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  467 */       this._events != null && 
/*  468 */       postEventsForChanges()) {
/*  469 */       this._events.post(ITenderTypeCount.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  476 */     boolean ev_postable = false;
/*      */     
/*  478 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  479 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  480 */       getDAO_().setCreateUserId(argCreateUserId);
/*  481 */       ev_postable = true;
/*      */     } 
/*      */     
/*  484 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  492 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  500 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  501 */       this._events != null && 
/*  502 */       postEventsForChanges()) {
/*  503 */       this._events.post(ITenderTypeCount.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  510 */     boolean ev_postable = false;
/*      */     
/*  512 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  513 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  514 */       getDAO_().setUpdateDate(argUpdateDate);
/*  515 */       ev_postable = true;
/*      */     } 
/*      */     
/*  518 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  526 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  534 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  535 */       this._events != null && 
/*  536 */       postEventsForChanges()) {
/*  537 */       this._events.post(ITenderTypeCount.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  544 */     boolean ev_postable = false;
/*      */     
/*  546 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  547 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  548 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  549 */       ev_postable = true;
/*      */     } 
/*      */     
/*  552 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmount() {
/*  560 */     return getDAO_().getAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmount(BigDecimal argAmount) {
/*  568 */     if (setAmount_noev(argAmount) && 
/*  569 */       this._events != null && 
/*  570 */       postEventsForChanges()) {
/*  571 */       this._events.post(ITenderTypeCount.SET_AMOUNT, argAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmount_noev(BigDecimal argAmount) {
/*  578 */     boolean ev_postable = false;
/*      */     
/*  580 */     if ((getDAO_().getAmount() == null && argAmount != null) || (
/*  581 */       getDAO_().getAmount() != null && !getDAO_().getAmount().equals(argAmount))) {
/*  582 */       getDAO_().setAmount(argAmount);
/*  583 */       ev_postable = true;
/*      */     } 
/*      */     
/*  586 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getDifferenceAmount() {
/*  594 */     return getDAO_().getDifferenceAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDifferenceAmount(BigDecimal argDifferenceAmount) {
/*  602 */     if (setDifferenceAmount_noev(argDifferenceAmount) && 
/*  603 */       this._events != null && 
/*  604 */       postEventsForChanges()) {
/*  605 */       this._events.post(ITenderTypeCount.SET_DIFFERENCEAMOUNT, argDifferenceAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDifferenceAmount_noev(BigDecimal argDifferenceAmount) {
/*  612 */     boolean ev_postable = false;
/*      */     
/*  614 */     if ((getDAO_().getDifferenceAmount() == null && argDifferenceAmount != null) || (
/*  615 */       getDAO_().getDifferenceAmount() != null && !getDAO_().getDifferenceAmount().equals(argDifferenceAmount))) {
/*  616 */       getDAO_().setDifferenceAmount(argDifferenceAmount);
/*  617 */       ev_postable = true;
/*      */     } 
/*      */     
/*  620 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDifferenceMediaCount() {
/*  628 */     if (getDAO_().getDifferenceMediaCount() != null) {
/*  629 */       return getDAO_().getDifferenceMediaCount().intValue();
/*      */     }
/*      */     
/*  632 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDifferenceMediaCount(int argDifferenceMediaCount) {
/*  641 */     if (setDifferenceMediaCount_noev(argDifferenceMediaCount) && 
/*  642 */       this._events != null && 
/*  643 */       postEventsForChanges()) {
/*  644 */       this._events.post(ITenderTypeCount.SET_DIFFERENCEMEDIACOUNT, Integer.valueOf(argDifferenceMediaCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDifferenceMediaCount_noev(int argDifferenceMediaCount) {
/*  651 */     boolean ev_postable = false;
/*      */     
/*  653 */     if ((getDAO_().getDifferenceMediaCount() == null && Integer.valueOf(argDifferenceMediaCount) != null) || (
/*  654 */       getDAO_().getDifferenceMediaCount() != null && !getDAO_().getDifferenceMediaCount().equals(Integer.valueOf(argDifferenceMediaCount)))) {
/*  655 */       getDAO_().setDifferenceMediaCount(Integer.valueOf(argDifferenceMediaCount));
/*  656 */       ev_postable = true;
/*      */     } 
/*      */     
/*  659 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMediaCount() {
/*  667 */     if (getDAO_().getMediaCount() != null) {
/*  668 */       return getDAO_().getMediaCount().intValue();
/*      */     }
/*      */     
/*  671 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMediaCount(int argMediaCount) {
/*  680 */     if (setMediaCount_noev(argMediaCount) && 
/*  681 */       this._events != null && 
/*  682 */       postEventsForChanges()) {
/*  683 */       this._events.post(ITenderTypeCount.SET_MEDIACOUNT, Integer.valueOf(argMediaCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMediaCount_noev(int argMediaCount) {
/*  690 */     boolean ev_postable = false;
/*      */     
/*  692 */     if ((getDAO_().getMediaCount() == null && Integer.valueOf(argMediaCount) != null) || (
/*  693 */       getDAO_().getMediaCount() != null && !getDAO_().getMediaCount().equals(Integer.valueOf(argMediaCount)))) {
/*  694 */       getDAO_().setMediaCount(Integer.valueOf(argMediaCount));
/*  695 */       ev_postable = true;
/*      */     } 
/*      */     
/*  698 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITenderTypeCountProperty newProperty(String argPropertyName) {
/*  702 */     TenderTypeCountPropertyId id = new TenderTypeCountPropertyId();
/*      */     
/*  704 */     id.setBusinessDayDate(getBusinessDayDate());
/*  705 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  706 */     id.setTenderTypeCode(getTenderTypeCode());
/*  707 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  708 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  709 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  711 */     ITenderTypeCountProperty prop = (ITenderTypeCountProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderTypeCountProperty.class);
/*  712 */     return prop;
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
/*      */   @Relationship(name = "TenderCounts")
/*      */   public List<ITenderCount> getTenderCounts() {
/*  727 */     if (this._tenderCounts == null) {
/*  728 */       this._tenderCounts = new HistoricalList(null);
/*      */     }
/*  730 */     return (List<ITenderCount>)this._tenderCounts;
/*      */   }
/*      */   
/*      */   public void setTenderCounts(List<ITenderCount> argTenderCounts) {
/*  734 */     if (this._tenderCounts == null) {
/*  735 */       this._tenderCounts = new HistoricalList(argTenderCounts);
/*      */     } else {
/*  737 */       this._tenderCounts.setCurrentList(argTenderCounts);
/*      */     } 
/*      */     
/*  740 */     for (ITenderCount child : this._tenderCounts) {
/*  741 */       child.setParentTenderTypeCount(this);
/*      */     }
/*      */     
/*  744 */     for (ITenderCount child : this._tenderCounts) {
/*  745 */       TenderCountModel model = (TenderCountModel)child;
/*  746 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/*  747 */       model.setOrganizationId_noev(getOrganizationId());
/*  748 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  749 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/*  750 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  751 */       model.setWorkstationId_noev(getWorkstationId());
/*  752 */       if (child instanceof IDataModelImpl) {
/*  753 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  754 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  755 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  756 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  759 */       if (postEventsForChanges()) {
/*  760 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addTenderCount(ITenderCount argTenderCount) {
/*  767 */     argTenderCount.setParentTenderTypeCount(this);
/*  768 */     if (this._tenderCounts == null) {
/*  769 */       this._tenderCounts = new HistoricalList(null);
/*      */     }
/*  771 */     argTenderCount.setBusinessDayDate(getBusinessDayDate());
/*  772 */     argTenderCount.setOrganizationId(getOrganizationId());
/*  773 */     argTenderCount.setRetailLocationId(getRetailLocationId());
/*  774 */     argTenderCount.setTenderTypeCode(getTenderTypeCode());
/*  775 */     argTenderCount.setTransactionSequence(getTransactionSequence());
/*  776 */     argTenderCount.setWorkstationId(getWorkstationId());
/*  777 */     if (argTenderCount instanceof IDataModelImpl) {
/*  778 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderCount).getDAO();
/*  779 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  780 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  781 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  786 */     if (postEventsForChanges()) {
/*  787 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderCount));
/*      */     }
/*      */     
/*  790 */     this._tenderCounts.add(argTenderCount);
/*  791 */     if (postEventsForChanges()) {
/*  792 */       this._events.post(ITenderTypeCount.ADD_TENDERCOUNTS, argTenderCount);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderCount(ITenderCount argTenderCount) {
/*  797 */     if (this._tenderCounts != null) {
/*      */       
/*  799 */       if (postEventsForChanges()) {
/*  800 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderCount));
/*      */       }
/*  802 */       this._tenderCounts.remove(argTenderCount);
/*      */       
/*  804 */       argTenderCount.setParentTenderTypeCount(null);
/*  805 */       if (postEventsForChanges()) {
/*  806 */         this._events.post(ITenderTypeCount.REMOVE_TENDERCOUNTS, argTenderCount);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TenderSerializedCounts")
/*      */   public List<ITenderSerializedCount> getTenderSerializedCounts() {
/*  813 */     if (this._tenderSerializedCounts == null) {
/*  814 */       this._tenderSerializedCounts = new HistoricalList(null);
/*      */     }
/*  816 */     return (List<ITenderSerializedCount>)this._tenderSerializedCounts;
/*      */   }
/*      */   
/*      */   public void setTenderSerializedCounts(List<ITenderSerializedCount> argTenderSerializedCounts) {
/*  820 */     if (this._tenderSerializedCounts == null) {
/*  821 */       this._tenderSerializedCounts = new HistoricalList(argTenderSerializedCounts);
/*      */     } else {
/*  823 */       this._tenderSerializedCounts.setCurrentList(argTenderSerializedCounts);
/*      */     } 
/*      */     
/*  826 */     for (ITenderSerializedCount child : this._tenderSerializedCounts) {
/*  827 */       child.setParentTenderTypeCount(this);
/*      */     }
/*      */     
/*  830 */     for (ITenderSerializedCount child : this._tenderSerializedCounts) {
/*  831 */       TenderSerializedCountModel model = (TenderSerializedCountModel)child;
/*  832 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/*  833 */       model.setOrganizationId_noev(getOrganizationId());
/*  834 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  835 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/*  836 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  837 */       model.setWorkstationId_noev(getWorkstationId());
/*  838 */       if (child instanceof IDataModelImpl) {
/*  839 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  840 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  841 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  842 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  845 */       if (postEventsForChanges()) {
/*  846 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addTenderSerializedCountImpl(ITenderSerializedCount argTenderSerializedCount) {
/*  853 */     argTenderSerializedCount.setParentTenderTypeCount(this);
/*  854 */     if (this._tenderSerializedCounts == null) {
/*  855 */       this._tenderSerializedCounts = new HistoricalList(null);
/*      */     }
/*  857 */     argTenderSerializedCount.setBusinessDayDate(getBusinessDayDate());
/*  858 */     argTenderSerializedCount.setOrganizationId(getOrganizationId());
/*  859 */     argTenderSerializedCount.setRetailLocationId(getRetailLocationId());
/*  860 */     argTenderSerializedCount.setTenderTypeCode(getTenderTypeCode());
/*  861 */     argTenderSerializedCount.setTransactionSequence(getTransactionSequence());
/*  862 */     argTenderSerializedCount.setWorkstationId(getWorkstationId());
/*  863 */     if (argTenderSerializedCount instanceof IDataModelImpl) {
/*  864 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderSerializedCount).getDAO();
/*  865 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  866 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  867 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  872 */     if (postEventsForChanges()) {
/*  873 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderSerializedCount));
/*      */     }
/*      */     
/*  876 */     this._tenderSerializedCounts.add(argTenderSerializedCount);
/*  877 */     if (postEventsForChanges()) {
/*  878 */       this._events.post(ITenderTypeCount.ADD_TENDERSERIALIZEDCOUNTS, argTenderSerializedCount);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderSerializedCount(ITenderSerializedCount argTenderSerializedCount) {
/*  883 */     if (this._tenderSerializedCounts != null) {
/*      */       
/*  885 */       if (postEventsForChanges()) {
/*  886 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderSerializedCount));
/*      */       }
/*  888 */       this._tenderSerializedCounts.remove(argTenderSerializedCount);
/*      */       
/*  890 */       argTenderSerializedCount.setParentTenderTypeCount(null);
/*  891 */       if (postEventsForChanges()) {
/*  892 */         this._events.post(ITenderTypeCount.REMOVE_TENDERSERIALIZEDCOUNTS, argTenderSerializedCount);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITenderTypeCountProperty> getProperties() {
/*  899 */     if (this._properties == null) {
/*  900 */       this._properties = new HistoricalList(null);
/*      */     }
/*  902 */     return (List<ITenderTypeCountProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITenderTypeCountProperty> argProperties) {
/*  906 */     if (this._properties == null) {
/*  907 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  909 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  912 */     for (ITenderTypeCountProperty child : this._properties) {
/*  913 */       TenderTypeCountPropertyModel model = (TenderTypeCountPropertyModel)child;
/*  914 */       model.setBusinessDayDate_noev(getBusinessDayDate());
/*  915 */       model.setOrganizationId_noev(getOrganizationId());
/*  916 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  917 */       model.setTenderTypeCode_noev(getTenderTypeCode());
/*  918 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  919 */       model.setWorkstationId_noev(getWorkstationId());
/*  920 */       if (child instanceof IDataModelImpl) {
/*  921 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  922 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  923 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  924 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  927 */       if (postEventsForChanges()) {
/*  928 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTenderTypeCountProperty(ITenderTypeCountProperty argTenderTypeCountProperty) {
/*  934 */     if (this._properties == null) {
/*  935 */       this._properties = new HistoricalList(null);
/*      */     }
/*  937 */     argTenderTypeCountProperty.setBusinessDayDate(getBusinessDayDate());
/*  938 */     argTenderTypeCountProperty.setOrganizationId(getOrganizationId());
/*  939 */     argTenderTypeCountProperty.setRetailLocationId(getRetailLocationId());
/*  940 */     argTenderTypeCountProperty.setTenderTypeCode(getTenderTypeCode());
/*  941 */     argTenderTypeCountProperty.setTransactionSequence(getTransactionSequence());
/*  942 */     argTenderTypeCountProperty.setWorkstationId(getWorkstationId());
/*  943 */     if (argTenderTypeCountProperty instanceof IDataModelImpl) {
/*  944 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderTypeCountProperty).getDAO();
/*  945 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  946 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  947 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  952 */     if (postEventsForChanges()) {
/*  953 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderTypeCountProperty));
/*      */     }
/*      */     
/*  956 */     this._properties.add(argTenderTypeCountProperty);
/*  957 */     if (postEventsForChanges()) {
/*  958 */       this._events.post(ITenderTypeCount.ADD_PROPERTIES, argTenderTypeCountProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderTypeCountProperty(ITenderTypeCountProperty argTenderTypeCountProperty) {
/*  963 */     if (this._properties != null) {
/*      */       
/*  965 */       if (postEventsForChanges()) {
/*  966 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderTypeCountProperty));
/*      */       }
/*  968 */       this._properties.remove(argTenderTypeCountProperty);
/*  969 */       if (postEventsForChanges()) {
/*  970 */         this._events.post(ITenderTypeCount.REMOVE_PROPERTIES, argTenderTypeCountProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentTenderControlTransaction(ITenderControlTransaction argParentTenderControlTransaction) {
/*  976 */     this._parentTenderControlTransaction = argParentTenderControlTransaction;
/*      */   }
/*      */   
/*      */   public ITenderControlTransaction getParentTenderControlTransaction() {
/*  980 */     return this._parentTenderControlTransaction;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  985 */     if ("TenderCounts".equals(argFieldId)) {
/*  986 */       return getTenderCounts();
/*      */     }
/*  988 */     if ("TenderSerializedCounts".equals(argFieldId)) {
/*  989 */       return getTenderSerializedCounts();
/*      */     }
/*  991 */     if ("Properties".equals(argFieldId)) {
/*  992 */       return getProperties();
/*      */     }
/*  994 */     if ("TenderTypeCountExtension".equals(argFieldId)) {
/*  995 */       return this._myExtension;
/*      */     }
/*      */     
/*  998 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1004 */     if ("TenderCounts".equals(argFieldId)) {
/* 1005 */       setTenderCounts(changeToList(argValue, ITenderCount.class));
/*      */     }
/* 1007 */     else if ("TenderSerializedCounts".equals(argFieldId)) {
/* 1008 */       setTenderSerializedCounts(changeToList(argValue, ITenderSerializedCount.class));
/*      */     }
/* 1010 */     else if ("Properties".equals(argFieldId)) {
/* 1011 */       setProperties(changeToList(argValue, ITenderTypeCountProperty.class));
/*      */     }
/* 1013 */     else if ("TenderTypeCountExtension".equals(argFieldId)) {
/* 1014 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1017 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1023 */     this._persistenceDefaults = argPD;
/* 1024 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1025 */     this._eventManager = argEM;
/* 1026 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1027 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1028 */     if (this._tenderCounts != null) {
/* 1029 */       for (ITenderCount relationship : this._tenderCounts) {
/* 1030 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1033 */     if (this._tenderSerializedCounts != null) {
/* 1034 */       for (ITenderSerializedCount relationship : this._tenderSerializedCounts) {
/* 1035 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1038 */     if (this._properties != null) {
/* 1039 */       for (ITenderTypeCountProperty relationship : this._properties) {
/* 1040 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderTypeCountExt() {
/* 1046 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderTypeCountExt(IDataModel argExt) {
/* 1050 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1055 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1059 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1062 */     super.startTransaction();
/*      */     
/* 1064 */     this._tenderCountsSavepoint = this._tenderCounts;
/* 1065 */     if (this._tenderCounts != null) {
/* 1066 */       this._tenderCountsSavepoint = new HistoricalList((List)this._tenderCounts);
/* 1067 */       Iterator<IDataModel> it = this._tenderCounts.iterator();
/* 1068 */       while (it.hasNext()) {
/* 1069 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1073 */     this._tenderSerializedCountsSavepoint = this._tenderSerializedCounts;
/* 1074 */     if (this._tenderSerializedCounts != null) {
/* 1075 */       this._tenderSerializedCountsSavepoint = new HistoricalList((List)this._tenderSerializedCounts);
/* 1076 */       Iterator<IDataModel> it = this._tenderSerializedCounts.iterator();
/* 1077 */       while (it.hasNext()) {
/* 1078 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1082 */     this._propertiesSavepoint = this._properties;
/* 1083 */     if (this._properties != null) {
/* 1084 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1085 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1086 */       while (it.hasNext()) {
/* 1087 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1092 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1097 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1100 */     super.rollbackChanges();
/*      */     
/* 1102 */     this._tenderCounts = this._tenderCountsSavepoint;
/* 1103 */     this._tenderCountsSavepoint = null;
/* 1104 */     if (this._tenderCounts != null) {
/* 1105 */       Iterator<IDataModel> it = this._tenderCounts.iterator();
/* 1106 */       while (it.hasNext()) {
/* 1107 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1111 */     this._tenderSerializedCounts = this._tenderSerializedCountsSavepoint;
/* 1112 */     this._tenderSerializedCountsSavepoint = null;
/* 1113 */     if (this._tenderSerializedCounts != null) {
/* 1114 */       Iterator<IDataModel> it = this._tenderSerializedCounts.iterator();
/* 1115 */       while (it.hasNext()) {
/* 1116 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1120 */     this._properties = this._propertiesSavepoint;
/* 1121 */     this._propertiesSavepoint = null;
/* 1122 */     if (this._properties != null) {
/* 1123 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1124 */       while (it.hasNext()) {
/* 1125 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1133 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1136 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1139 */     super.commitTransaction();
/*      */     
/* 1141 */     this._tenderCountsSavepoint = this._tenderCounts;
/* 1142 */     if (this._tenderCounts != null) {
/* 1143 */       Iterator<IDataModel> it = this._tenderCounts.iterator();
/* 1144 */       while (it.hasNext()) {
/* 1145 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1147 */       this._tenderCounts = new HistoricalList((List)this._tenderCounts);
/*      */     } 
/*      */     
/* 1150 */     this._tenderSerializedCountsSavepoint = this._tenderSerializedCounts;
/* 1151 */     if (this._tenderSerializedCounts != null) {
/* 1152 */       Iterator<IDataModel> it = this._tenderSerializedCounts.iterator();
/* 1153 */       while (it.hasNext()) {
/* 1154 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1156 */       this._tenderSerializedCounts = new HistoricalList((List)this._tenderSerializedCounts);
/*      */     } 
/*      */     
/* 1159 */     this._propertiesSavepoint = this._properties;
/* 1160 */     if (this._properties != null) {
/* 1161 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1162 */       while (it.hasNext()) {
/* 1163 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1165 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1169 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1174 */     argStream.defaultReadObject();
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
/*      */   public List<ITenderSerializedCount> getTenderSerializedCountByTenderCount(ITenderCount tenderCount) {
/* 1188 */     if (tenderCount == null) {
/* 1189 */       return Collections.emptyList();
/*      */     }
/* 1191 */     List<ITenderSerializedCount> serializedCountList = getTenderSerializedCounts();
/* 1192 */     List<ITenderSerializedCount> result = new ArrayList<>();
/*      */     
/* 1194 */     if (serializedCountList != null && !serializedCountList.isEmpty()) {
/* 1195 */       for (ITenderSerializedCount serializedCount : serializedCountList) {
/* 1196 */         if (serializedCount.getTender() != null && serializedCount
/* 1197 */           .getTender().getTenderId() == tenderCount.getTenderId())
/*      */         {
/* 1199 */           result.add(serializedCount);
/*      */         }
/*      */       } 
/*      */     }
/* 1203 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTenderSerializedCount(ITenderSerializedCount tenderSerializedCount) {
/* 1212 */     tenderSerializedCount.setSerializedCountSequence(getTenderSerializedCounts().size() + 1);
/*      */     
/* 1214 */     synchronized (this) {
/* 1215 */       addTenderSerializedCountImpl(tenderSerializedCount);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderTypeCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */