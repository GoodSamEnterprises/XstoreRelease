/*      */ package dtv.xst.dao.cat.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.cat.ChargeAccountHistoryPropertyId;
/*      */ import dtv.xst.dao.cat.IChargeAccountHistory;
/*      */ import dtv.xst.dao.cat.IChargeAccountHistoryProperty;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ChargeAccountHistoryModel extends AbstractDataModelWithPropertyImpl<IChargeAccountHistoryProperty> implements IChargeAccountHistory {
/*      */   private static final long serialVersionUID = -284103269L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IChargeAccountHistoryProperty> _properties; private transient HistoricalList<IChargeAccountHistoryProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new ChargeAccountHistoryDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ChargeAccountHistoryDAO getDAO_() {
/*   46 */     return (ChargeAccountHistoryDAO)this._daoImpl;
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
/*   70 */       this._events.post(IChargeAccountHistory.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   83 */       if (this._properties != null) {
/*      */         
/*   85 */         Iterator<ChargeAccountHistoryPropertyModel> it = this._properties.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((ChargeAccountHistoryPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   93 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountId() {
/*  101 */     return getDAO_().getCustAccountId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountId(String argCustAccountId) {
/*  109 */     if (setCustAccountId_noev(argCustAccountId) && 
/*  110 */       this._events != null && 
/*  111 */       postEventsForChanges()) {
/*  112 */       this._events.post(IChargeAccountHistory.SET_CUSTACCOUNTID, argCustAccountId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountId_noev(String argCustAccountId) {
/*  119 */     boolean ev_postable = false;
/*      */     
/*  121 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/*  122 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/*  123 */       getDAO_().setCustAccountId(argCustAccountId);
/*  124 */       ev_postable = true;
/*  125 */       if (this._properties != null) {
/*      */         
/*  127 */         Iterator<ChargeAccountHistoryPropertyModel> it = this._properties.iterator();
/*  128 */         while (it.hasNext())
/*      */         {
/*  130 */           ((ChargeAccountHistoryPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  135 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustAccountCode() {
/*  143 */     return getDAO_().getCustAccountCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustAccountCode(String argCustAccountCode) {
/*  151 */     if (setCustAccountCode_noev(argCustAccountCode) && 
/*  152 */       this._events != null && 
/*  153 */       postEventsForChanges()) {
/*  154 */       this._events.post(IChargeAccountHistory.SET_CUSTACCOUNTCODE, argCustAccountCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustAccountCode_noev(String argCustAccountCode) {
/*  161 */     boolean ev_postable = false;
/*      */     
/*  163 */     if ((getDAO_().getCustAccountCode() == null && argCustAccountCode != null) || (
/*  164 */       getDAO_().getCustAccountCode() != null && !getDAO_().getCustAccountCode().equals(argCustAccountCode))) {
/*  165 */       getDAO_().setCustAccountCode(argCustAccountCode);
/*  166 */       ev_postable = true;
/*  167 */       if (this._properties != null) {
/*      */         
/*  169 */         Iterator<ChargeAccountHistoryPropertyModel> it = this._properties.iterator();
/*  170 */         while (it.hasNext())
/*      */         {
/*  172 */           ((ChargeAccountHistoryPropertyModel)it.next()).setCustAccountCode_noev(argCustAccountCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  177 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getHistorySeq() {
/*  185 */     if (getDAO_().getHistorySeq() != null) {
/*  186 */       return getDAO_().getHistorySeq().longValue();
/*      */     }
/*      */     
/*  189 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHistorySeq(long argHistorySeq) {
/*  198 */     if (setHistorySeq_noev(argHistorySeq) && 
/*  199 */       this._events != null && 
/*  200 */       postEventsForChanges()) {
/*  201 */       this._events.post(IChargeAccountHistory.SET_HISTORYSEQ, Long.valueOf(argHistorySeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setHistorySeq_noev(long argHistorySeq) {
/*  208 */     boolean ev_postable = false;
/*      */     
/*  210 */     if ((getDAO_().getHistorySeq() == null && Long.valueOf(argHistorySeq) != null) || (
/*  211 */       getDAO_().getHistorySeq() != null && !getDAO_().getHistorySeq().equals(Long.valueOf(argHistorySeq)))) {
/*  212 */       getDAO_().setHistorySeq(Long.valueOf(argHistorySeq));
/*  213 */       ev_postable = true;
/*  214 */       if (this._properties != null) {
/*      */         
/*  216 */         Iterator<ChargeAccountHistoryPropertyModel> it = this._properties.iterator();
/*  217 */         while (it.hasNext())
/*      */         {
/*  219 */           ((ChargeAccountHistoryPropertyModel)it.next()).setHistorySeq_noev(argHistorySeq);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  224 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  232 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  240 */     if (setCreateDate_noev(argCreateDate) && 
/*  241 */       this._events != null && 
/*  242 */       postEventsForChanges()) {
/*  243 */       this._events.post(IChargeAccountHistory.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  250 */     boolean ev_postable = false;
/*      */     
/*  252 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  253 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  254 */       getDAO_().setCreateDate(argCreateDate);
/*  255 */       ev_postable = true;
/*      */     } 
/*      */     
/*  258 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  266 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  274 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  275 */       this._events != null && 
/*  276 */       postEventsForChanges()) {
/*  277 */       this._events.post(IChargeAccountHistory.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  284 */     boolean ev_postable = false;
/*      */     
/*  286 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  287 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  288 */       getDAO_().setCreateUserId(argCreateUserId);
/*  289 */       ev_postable = true;
/*      */     } 
/*      */     
/*  292 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  300 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  308 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  309 */       this._events != null && 
/*  310 */       postEventsForChanges()) {
/*  311 */       this._events.post(IChargeAccountHistory.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  318 */     boolean ev_postable = false;
/*      */     
/*  320 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  321 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  322 */       getDAO_().setUpdateDate(argUpdateDate);
/*  323 */       ev_postable = true;
/*      */     } 
/*      */     
/*  326 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  334 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  342 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  343 */       this._events != null && 
/*  344 */       postEventsForChanges()) {
/*  345 */       this._events.post(IChargeAccountHistory.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  352 */     boolean ev_postable = false;
/*      */     
/*  354 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  355 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  356 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  357 */       ev_postable = true;
/*      */     } 
/*      */     
/*  360 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getActivityDate() {
/*  368 */     return getDAO_().getActivityDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivityDate(Date argActivityDate) {
/*  376 */     if (setActivityDate_noev(argActivityDate) && 
/*  377 */       this._events != null && 
/*  378 */       postEventsForChanges()) {
/*  379 */       this._events.post(IChargeAccountHistory.SET_ACTIVITYDATE, argActivityDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActivityDate_noev(Date argActivityDate) {
/*  386 */     boolean ev_postable = false;
/*      */     
/*  388 */     if ((getDAO_().getActivityDate() == null && argActivityDate != null) || (
/*  389 */       getDAO_().getActivityDate() != null && !getDAO_().getActivityDate().equals(argActivityDate))) {
/*  390 */       getDAO_().setActivityDate(argActivityDate);
/*  391 */       ev_postable = true;
/*      */     } 
/*      */     
/*  394 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getActivityEnum() {
/*  402 */     return getDAO_().getActivityEnum();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivityEnum(String argActivityEnum) {
/*  410 */     if (setActivityEnum_noev(argActivityEnum) && 
/*  411 */       this._events != null && 
/*  412 */       postEventsForChanges()) {
/*  413 */       this._events.post(IChargeAccountHistory.SET_ACTIVITYENUM, argActivityEnum);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActivityEnum_noev(String argActivityEnum) {
/*  420 */     boolean ev_postable = false;
/*      */     
/*  422 */     if ((getDAO_().getActivityEnum() == null && argActivityEnum != null) || (
/*  423 */       getDAO_().getActivityEnum() != null && !getDAO_().getActivityEnum().equals(argActivityEnum))) {
/*  424 */       getDAO_().setActivityEnum(argActivityEnum);
/*  425 */       ev_postable = true;
/*      */     } 
/*      */     
/*  428 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAmt() {
/*  436 */     return getDAO_().getAmt();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAmt(BigDecimal argAmt) {
/*  444 */     if (setAmt_noev(argAmt) && 
/*  445 */       this._events != null && 
/*  446 */       postEventsForChanges()) {
/*  447 */       this._events.post(IChargeAccountHistory.SET_AMT, argAmt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAmt_noev(BigDecimal argAmt) {
/*  454 */     boolean ev_postable = false;
/*      */     
/*  456 */     if ((getDAO_().getAmt() == null && argAmt != null) || (
/*  457 */       getDAO_().getAmt() != null && !getDAO_().getAmt().equals(argAmt))) {
/*  458 */       getDAO_().setAmt(argAmt);
/*  459 */       ev_postable = true;
/*      */     } 
/*      */     
/*  462 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  470 */     if (getDAO_().getPartyId() != null) {
/*  471 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  474 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  483 */     if (setPartyId_noev(argPartyId) && 
/*  484 */       this._events != null && 
/*  485 */       postEventsForChanges()) {
/*  486 */       this._events.post(IChargeAccountHistory.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  493 */     boolean ev_postable = false;
/*      */     
/*  495 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  496 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  497 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  498 */       ev_postable = true;
/*      */     } 
/*      */     
/*  501 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  509 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  517 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  518 */       this._events != null && 
/*  519 */       postEventsForChanges()) {
/*  520 */       this._events.post(IChargeAccountHistory.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  527 */     boolean ev_postable = false;
/*      */     
/*  529 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  530 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  531 */       getDAO_().setBusinessDate(argBusinessDate);
/*  532 */       ev_postable = true;
/*      */     } 
/*      */     
/*  535 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  543 */     if (getDAO_().getTransactionSequence() != null) {
/*  544 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  547 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  556 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  557 */       this._events != null && 
/*  558 */       postEventsForChanges()) {
/*  559 */       this._events.post(IChargeAccountHistory.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  566 */     boolean ev_postable = false;
/*      */     
/*  568 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  569 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  570 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  571 */       ev_postable = true;
/*      */     } 
/*      */     
/*  574 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  582 */     if (getDAO_().getWorkstationId() != null) {
/*  583 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  586 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  595 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  596 */       this._events != null && 
/*  597 */       postEventsForChanges()) {
/*  598 */       this._events.post(IChargeAccountHistory.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  605 */     boolean ev_postable = false;
/*      */     
/*  607 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  608 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  609 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  610 */       ev_postable = true;
/*      */     } 
/*      */     
/*  613 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  621 */     if (getDAO_().getRetailLocationId() != null) {
/*  622 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  625 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  634 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  635 */       this._events != null && 
/*  636 */       postEventsForChanges()) {
/*  637 */       this._events.post(IChargeAccountHistory.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  644 */     boolean ev_postable = false;
/*      */     
/*  646 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  647 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  648 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  649 */       ev_postable = true;
/*      */     } 
/*      */     
/*  652 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  660 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  661 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  664 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  673 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  674 */       this._events != null && 
/*  675 */       postEventsForChanges()) {
/*  676 */       this._events.post(IChargeAccountHistory.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  683 */     boolean ev_postable = false;
/*      */     
/*  685 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  686 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  687 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  688 */       ev_postable = true;
/*      */     } 
/*      */     
/*  691 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAccountBalance() {
/*  699 */     return getDAO_().getAccountBalance();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountBalance(BigDecimal argAccountBalance) {
/*  707 */     if (setAccountBalance_noev(argAccountBalance) && 
/*  708 */       this._events != null && 
/*  709 */       postEventsForChanges()) {
/*  710 */       this._events.post(IChargeAccountHistory.SET_ACCOUNTBALANCE, argAccountBalance);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountBalance_noev(BigDecimal argAccountBalance) {
/*  717 */     boolean ev_postable = false;
/*      */     
/*  719 */     if ((getDAO_().getAccountBalance() == null && argAccountBalance != null) || (
/*  720 */       getDAO_().getAccountBalance() != null && !getDAO_().getAccountBalance().equals(argAccountBalance))) {
/*  721 */       getDAO_().setAccountBalance(argAccountBalance);
/*  722 */       ev_postable = true;
/*      */     } 
/*      */     
/*  725 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountUserName() {
/*  733 */     return getDAO_().getAccountUserName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountUserName(String argAccountUserName) {
/*  741 */     if (setAccountUserName_noev(argAccountUserName) && 
/*  742 */       this._events != null && 
/*  743 */       postEventsForChanges()) {
/*  744 */       this._events.post(IChargeAccountHistory.SET_ACCOUNTUSERNAME, argAccountUserName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountUserName_noev(String argAccountUserName) {
/*  751 */     boolean ev_postable = false;
/*      */     
/*  753 */     if ((getDAO_().getAccountUserName() == null && argAccountUserName != null) || (
/*  754 */       getDAO_().getAccountUserName() != null && !getDAO_().getAccountUserName().equals(argAccountUserName))) {
/*  755 */       getDAO_().setAccountUserName(argAccountUserName);
/*  756 */       ev_postable = true;
/*      */     } 
/*      */     
/*  759 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAccountUserId() {
/*  767 */     return getDAO_().getAccountUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAccountUserId(String argAccountUserId) {
/*  775 */     if (setAccountUserId_noev(argAccountUserId) && 
/*  776 */       this._events != null && 
/*  777 */       postEventsForChanges()) {
/*  778 */       this._events.post(IChargeAccountHistory.SET_ACCOUNTUSERID, argAccountUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAccountUserId_noev(String argAccountUserId) {
/*  785 */     boolean ev_postable = false;
/*      */     
/*  787 */     if ((getDAO_().getAccountUserId() == null && argAccountUserId != null) || (
/*  788 */       getDAO_().getAccountUserId() != null && !getDAO_().getAccountUserId().equals(argAccountUserId))) {
/*  789 */       getDAO_().setAccountUserId(argAccountUserId);
/*  790 */       ev_postable = true;
/*      */     } 
/*      */     
/*  793 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getReversedFlag() {
/*  801 */     if (getDAO_().getReversedFlag() != null) {
/*  802 */       return getDAO_().getReversedFlag().booleanValue();
/*      */     }
/*      */     
/*  805 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReversedFlag(boolean argReversedFlag) {
/*  814 */     if (setReversedFlag_noev(argReversedFlag) && 
/*  815 */       this._events != null && 
/*  816 */       postEventsForChanges()) {
/*  817 */       this._events.post(IChargeAccountHistory.SET_REVERSEDFLAG, Boolean.valueOf(argReversedFlag));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReversedFlag_noev(boolean argReversedFlag) {
/*  824 */     boolean ev_postable = false;
/*      */     
/*  826 */     if ((getDAO_().getReversedFlag() == null && Boolean.valueOf(argReversedFlag) != null) || (
/*  827 */       getDAO_().getReversedFlag() != null && !getDAO_().getReversedFlag().equals(Boolean.valueOf(argReversedFlag)))) {
/*  828 */       getDAO_().setReversedFlag(Boolean.valueOf(argReversedFlag));
/*  829 */       ev_postable = true;
/*      */     } 
/*      */     
/*  832 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IChargeAccountHistoryProperty newProperty(String argPropertyName) {
/*  836 */     ChargeAccountHistoryPropertyId id = new ChargeAccountHistoryPropertyId();
/*      */     
/*  838 */     id.setCustAccountId(getCustAccountId());
/*  839 */     id.setCustAccountCode(getCustAccountCode());
/*  840 */     id.setHistorySeq(Long.valueOf(getHistorySeq()));
/*  841 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  843 */     IChargeAccountHistoryProperty prop = (IChargeAccountHistoryProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IChargeAccountHistoryProperty.class);
/*  844 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IChargeAccountHistoryProperty> getProperties() {
/*  853 */     if (this._properties == null) {
/*  854 */       this._properties = new HistoricalList(null);
/*      */     }
/*  856 */     return (List<IChargeAccountHistoryProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IChargeAccountHistoryProperty> argProperties) {
/*  860 */     if (this._properties == null) {
/*  861 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  863 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  866 */     for (IChargeAccountHistoryProperty child : this._properties) {
/*  867 */       ChargeAccountHistoryPropertyModel model = (ChargeAccountHistoryPropertyModel)child;
/*  868 */       model.setOrganizationId_noev(getOrganizationId());
/*  869 */       model.setCustAccountId_noev(getCustAccountId());
/*  870 */       model.setCustAccountCode_noev(getCustAccountCode());
/*  871 */       model.setHistorySeq_noev(getHistorySeq());
/*  872 */       if (child instanceof IDataModelImpl) {
/*  873 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  874 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  875 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  876 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  879 */       if (postEventsForChanges()) {
/*  880 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addChargeAccountHistoryProperty(IChargeAccountHistoryProperty argChargeAccountHistoryProperty) {
/*  886 */     if (this._properties == null) {
/*  887 */       this._properties = new HistoricalList(null);
/*      */     }
/*  889 */     argChargeAccountHistoryProperty.setOrganizationId(getOrganizationId());
/*  890 */     argChargeAccountHistoryProperty.setCustAccountId(getCustAccountId());
/*  891 */     argChargeAccountHistoryProperty.setCustAccountCode(getCustAccountCode());
/*  892 */     argChargeAccountHistoryProperty.setHistorySeq(getHistorySeq());
/*  893 */     if (argChargeAccountHistoryProperty instanceof IDataModelImpl) {
/*  894 */       IDataAccessObject childDao = ((IDataModelImpl)argChargeAccountHistoryProperty).getDAO();
/*  895 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  896 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  897 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  902 */     if (postEventsForChanges()) {
/*  903 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountHistoryProperty));
/*      */     }
/*      */     
/*  906 */     this._properties.add(argChargeAccountHistoryProperty);
/*  907 */     if (postEventsForChanges()) {
/*  908 */       this._events.post(IChargeAccountHistory.ADD_PROPERTIES, argChargeAccountHistoryProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeChargeAccountHistoryProperty(IChargeAccountHistoryProperty argChargeAccountHistoryProperty) {
/*  913 */     if (this._properties != null) {
/*      */       
/*  915 */       if (postEventsForChanges()) {
/*  916 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argChargeAccountHistoryProperty));
/*      */       }
/*  918 */       this._properties.remove(argChargeAccountHistoryProperty);
/*  919 */       if (postEventsForChanges()) {
/*  920 */         this._events.post(IChargeAccountHistory.REMOVE_PROPERTIES, argChargeAccountHistoryProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  927 */     if ("Properties".equals(argFieldId)) {
/*  928 */       return getProperties();
/*      */     }
/*  930 */     if ("ChargeAccountHistoryExtension".equals(argFieldId)) {
/*  931 */       return this._myExtension;
/*      */     }
/*      */     
/*  934 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  940 */     if ("Properties".equals(argFieldId)) {
/*  941 */       setProperties(changeToList(argValue, IChargeAccountHistoryProperty.class));
/*      */     }
/*  943 */     else if ("ChargeAccountHistoryExtension".equals(argFieldId)) {
/*  944 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  947 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  953 */     this._persistenceDefaults = argPD;
/*  954 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  955 */     this._eventManager = argEM;
/*  956 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  957 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  958 */     if (this._properties != null) {
/*  959 */       for (IChargeAccountHistoryProperty relationship : this._properties) {
/*  960 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getChargeAccountHistoryExt() {
/*  966 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setChargeAccountHistoryExt(IDataModel argExt) {
/*  970 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  975 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  979 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  982 */     super.startTransaction();
/*      */     
/*  984 */     this._propertiesSavepoint = this._properties;
/*  985 */     if (this._properties != null) {
/*  986 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  987 */       Iterator<IDataModel> it = this._properties.iterator();
/*  988 */       while (it.hasNext()) {
/*  989 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  994 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  999 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1002 */     super.rollbackChanges();
/*      */     
/* 1004 */     this._properties = this._propertiesSavepoint;
/* 1005 */     this._propertiesSavepoint = null;
/* 1006 */     if (this._properties != null) {
/* 1007 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1008 */       while (it.hasNext()) {
/* 1009 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1017 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1020 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1023 */     super.commitTransaction();
/*      */     
/* 1025 */     this._propertiesSavepoint = this._properties;
/* 1026 */     if (this._properties != null) {
/* 1027 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1028 */       while (it.hasNext()) {
/* 1029 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1031 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1035 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1040 */     argStream.defaultReadObject();
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
/*      */   public Date getTransactionDate() {
/* 1053 */     return getActivityDate();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\ChargeAccountHistoryModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */