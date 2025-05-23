/*      */ package dtv.xst.dao.ttr.impl;
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
/*      */ import dtv.xst.dao.ttr.ITenderAuthLog;
/*      */ import dtv.xst.dao.ttr.ITenderAuthLogProperty;
/*      */ import dtv.xst.dao.ttr.TenderAuthLogPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class TenderAuthLogModel extends AbstractDataModelWithPropertyImpl<ITenderAuthLogProperty> implements ITenderAuthLog {
/*      */   private static final long serialVersionUID = -1325511960L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   33 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<ITenderAuthLogProperty> _properties; private transient HistoricalList<ITenderAuthLogProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   38 */     setDAO((IDataAccessObject)new TenderAuthLogDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TenderAuthLogDAO getDAO_() {
/*   46 */     return (TenderAuthLogDAO)this._daoImpl;
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
/*   70 */       this._events.post(ITenderAuthLog.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   85 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*   86 */         while (it.hasNext())
/*      */         {
/*   88 */           ((TenderAuthLogPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
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
/*      */   public long getRetailLocationId() {
/*  101 */     if (getDAO_().getRetailLocationId() != null) {
/*  102 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  105 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  114 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  115 */       this._events != null && 
/*  116 */       postEventsForChanges()) {
/*  117 */       this._events.post(ITenderAuthLog.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  124 */     boolean ev_postable = false;
/*      */     
/*  126 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  127 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  128 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  129 */       ev_postable = true;
/*  130 */       if (this._properties != null) {
/*      */         
/*  132 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*  133 */         while (it.hasNext())
/*      */         {
/*  135 */           ((TenderAuthLogPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  140 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  148 */     if (getDAO_().getWorkstationId() != null) {
/*  149 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  152 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  161 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  162 */       this._events != null && 
/*  163 */       postEventsForChanges()) {
/*  164 */       this._events.post(ITenderAuthLog.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  171 */     boolean ev_postable = false;
/*      */     
/*  173 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  174 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  175 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  176 */       ev_postable = true;
/*  177 */       if (this._properties != null) {
/*      */         
/*  179 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*  180 */         while (it.hasNext())
/*      */         {
/*  182 */           ((TenderAuthLogPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  187 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  195 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  203 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  204 */       this._events != null && 
/*  205 */       postEventsForChanges()) {
/*  206 */       this._events.post(ITenderAuthLog.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  213 */     boolean ev_postable = false;
/*      */     
/*  215 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  216 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  217 */       getDAO_().setBusinessDate(argBusinessDate);
/*  218 */       ev_postable = true;
/*  219 */       if (this._properties != null) {
/*      */         
/*  221 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*  222 */         while (it.hasNext())
/*      */         {
/*  224 */           ((TenderAuthLogPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  229 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  237 */     if (getDAO_().getTransactionSequence() != null) {
/*  238 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  241 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  250 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  251 */       this._events != null && 
/*  252 */       postEventsForChanges()) {
/*  253 */       this._events.post(ITenderAuthLog.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  260 */     boolean ev_postable = false;
/*      */     
/*  262 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  263 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  264 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  265 */       ev_postable = true;
/*  266 */       if (this._properties != null) {
/*      */         
/*  268 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*  269 */         while (it.hasNext())
/*      */         {
/*  271 */           ((TenderAuthLogPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  276 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  284 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  285 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  288 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  297 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  298 */       this._events != null && 
/*  299 */       postEventsForChanges()) {
/*  300 */       this._events.post(ITenderAuthLog.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  307 */     boolean ev_postable = false;
/*      */     
/*  309 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  310 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  311 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  312 */       ev_postable = true;
/*  313 */       if (this._properties != null) {
/*      */         
/*  315 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*  316 */         while (it.hasNext())
/*      */         {
/*  318 */           ((TenderAuthLogPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  323 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttemptSequence() {
/*  331 */     if (getDAO_().getAttemptSequence() != null) {
/*  332 */       return getDAO_().getAttemptSequence().intValue();
/*      */     }
/*      */     
/*  335 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttemptSequence(int argAttemptSequence) {
/*  344 */     if (setAttemptSequence_noev(argAttemptSequence) && 
/*  345 */       this._events != null && 
/*  346 */       postEventsForChanges()) {
/*  347 */       this._events.post(ITenderAuthLog.SET_ATTEMPTSEQUENCE, Integer.valueOf(argAttemptSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAttemptSequence_noev(int argAttemptSequence) {
/*  354 */     boolean ev_postable = false;
/*      */     
/*  356 */     if ((getDAO_().getAttemptSequence() == null && Integer.valueOf(argAttemptSequence) != null) || (
/*  357 */       getDAO_().getAttemptSequence() != null && !getDAO_().getAttemptSequence().equals(Integer.valueOf(argAttemptSequence)))) {
/*  358 */       getDAO_().setAttemptSequence(Integer.valueOf(argAttemptSequence));
/*  359 */       ev_postable = true;
/*  360 */       if (this._properties != null) {
/*      */         
/*  362 */         Iterator<TenderAuthLogPropertyModel> it = this._properties.iterator();
/*  363 */         while (it.hasNext())
/*      */         {
/*  365 */           ((TenderAuthLogPropertyModel)it.next()).setAttemptSequence_noev(argAttemptSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  370 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  378 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  386 */     if (setCreateDate_noev(argCreateDate) && 
/*  387 */       this._events != null && 
/*  388 */       postEventsForChanges()) {
/*  389 */       this._events.post(ITenderAuthLog.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  396 */     boolean ev_postable = false;
/*      */     
/*  398 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  399 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  400 */       getDAO_().setCreateDate(argCreateDate);
/*  401 */       ev_postable = true;
/*      */     } 
/*      */     
/*  404 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  412 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  420 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  421 */       this._events != null && 
/*  422 */       postEventsForChanges()) {
/*  423 */       this._events.post(ITenderAuthLog.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  430 */     boolean ev_postable = false;
/*      */     
/*  432 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  433 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  434 */       getDAO_().setCreateUserId(argCreateUserId);
/*  435 */       ev_postable = true;
/*      */     } 
/*      */     
/*  438 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  446 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  454 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  455 */       this._events != null && 
/*  456 */       postEventsForChanges()) {
/*  457 */       this._events.post(ITenderAuthLog.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  464 */     boolean ev_postable = false;
/*      */     
/*  466 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  467 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  468 */       getDAO_().setUpdateDate(argUpdateDate);
/*  469 */       ev_postable = true;
/*      */     } 
/*      */     
/*  472 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  480 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  488 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  489 */       this._events != null && 
/*  490 */       postEventsForChanges()) {
/*  491 */       this._events.post(ITenderAuthLog.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  498 */     boolean ev_postable = false;
/*      */     
/*  500 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  501 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  502 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*      */   public String getResponseCode() {
/*  514 */     return getDAO_().getResponseCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setResponseCode(String argResponseCode) {
/*  522 */     if (setResponseCode_noev(argResponseCode) && 
/*  523 */       this._events != null && 
/*  524 */       postEventsForChanges()) {
/*  525 */       this._events.post(ITenderAuthLog.SET_RESPONSECODE, argResponseCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setResponseCode_noev(String argResponseCode) {
/*  532 */     boolean ev_postable = false;
/*      */     
/*  534 */     if ((getDAO_().getResponseCode() == null && argResponseCode != null) || (
/*  535 */       getDAO_().getResponseCode() != null && !getDAO_().getResponseCode().equals(argResponseCode))) {
/*  536 */       getDAO_().setResponseCode(argResponseCode);
/*  537 */       ev_postable = true;
/*      */     } 
/*      */     
/*  540 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getApprovalCode() {
/*  548 */     return getDAO_().getApprovalCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApprovalCode(String argApprovalCode) {
/*  556 */     if (setApprovalCode_noev(argApprovalCode) && 
/*  557 */       this._events != null && 
/*  558 */       postEventsForChanges()) {
/*  559 */       this._events.post(ITenderAuthLog.SET_APPROVALCODE, argApprovalCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApprovalCode_noev(String argApprovalCode) {
/*  566 */     boolean ev_postable = false;
/*      */     
/*  568 */     if ((getDAO_().getApprovalCode() == null && argApprovalCode != null) || (
/*  569 */       getDAO_().getApprovalCode() != null && !getDAO_().getApprovalCode().equals(argApprovalCode))) {
/*  570 */       getDAO_().setApprovalCode(argApprovalCode);
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
/*      */   public String getAuthType() {
/*  582 */     return getDAO_().getAuthType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAuthType(String argAuthType) {
/*  590 */     if (setAuthType_noev(argAuthType) && 
/*  591 */       this._events != null && 
/*  592 */       postEventsForChanges()) {
/*  593 */       this._events.post(ITenderAuthLog.SET_AUTHTYPE, argAuthType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAuthType_noev(String argAuthType) {
/*  600 */     boolean ev_postable = false;
/*      */     
/*  602 */     if ((getDAO_().getAuthType() == null && argAuthType != null) || (
/*  603 */       getDAO_().getAuthType() != null && !getDAO_().getAuthType().equals(argAuthType))) {
/*  604 */       getDAO_().setAuthType(argAuthType);
/*  605 */       ev_postable = true;
/*      */     } 
/*      */     
/*  608 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustomerName() {
/*  616 */     return getDAO_().getCustomerName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerName(String argCustomerName) {
/*  624 */     if (setCustomerName_noev(argCustomerName) && 
/*  625 */       this._events != null && 
/*  626 */       postEventsForChanges()) {
/*  627 */       this._events.post(ITenderAuthLog.SET_CUSTOMERNAME, argCustomerName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomerName_noev(String argCustomerName) {
/*  634 */     boolean ev_postable = false;
/*      */     
/*  636 */     if ((getDAO_().getCustomerName() == null && argCustomerName != null) || (
/*  637 */       getDAO_().getCustomerName() != null && !getDAO_().getCustomerName().equals(argCustomerName))) {
/*  638 */       getDAO_().setCustomerName(argCustomerName);
/*  639 */       ev_postable = true;
/*      */     } 
/*      */     
/*  642 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReferenceNumber() {
/*  650 */     return getDAO_().getReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReferenceNumber(String argReferenceNumber) {
/*  658 */     if (setReferenceNumber_noev(argReferenceNumber) && 
/*  659 */       this._events != null && 
/*  660 */       postEventsForChanges()) {
/*  661 */       this._events.post(ITenderAuthLog.SET_REFERENCENUMBER, argReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReferenceNumber_noev(String argReferenceNumber) {
/*  668 */     boolean ev_postable = false;
/*      */     
/*  670 */     if ((getDAO_().getReferenceNumber() == null && argReferenceNumber != null) || (
/*  671 */       getDAO_().getReferenceNumber() != null && !getDAO_().getReferenceNumber().equals(argReferenceNumber))) {
/*  672 */       getDAO_().setReferenceNumber(argReferenceNumber);
/*  673 */       ev_postable = true;
/*      */     } 
/*      */     
/*  676 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getErrorCode() {
/*  684 */     return getDAO_().getErrorCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setErrorCode(String argErrorCode) {
/*  692 */     if (setErrorCode_noev(argErrorCode) && 
/*  693 */       this._events != null && 
/*  694 */       postEventsForChanges()) {
/*  695 */       this._events.post(ITenderAuthLog.SET_ERRORCODE, argErrorCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setErrorCode_noev(String argErrorCode) {
/*  702 */     boolean ev_postable = false;
/*      */     
/*  704 */     if ((getDAO_().getErrorCode() == null && argErrorCode != null) || (
/*  705 */       getDAO_().getErrorCode() != null && !getDAO_().getErrorCode().equals(argErrorCode))) {
/*  706 */       getDAO_().setErrorCode(argErrorCode);
/*  707 */       ev_postable = true;
/*      */     } 
/*      */     
/*  710 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getErrorText() {
/*  718 */     return getDAO_().getErrorText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setErrorText(String argErrorText) {
/*  726 */     if (setErrorText_noev(argErrorText) && 
/*  727 */       this._events != null && 
/*  728 */       postEventsForChanges()) {
/*  729 */       this._events.post(ITenderAuthLog.SET_ERRORTEXT, argErrorText);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setErrorText_noev(String argErrorText) {
/*  736 */     boolean ev_postable = false;
/*      */     
/*  738 */     if ((getDAO_().getErrorText() == null && argErrorText != null) || (
/*  739 */       getDAO_().getErrorText() != null && !getDAO_().getErrorText().equals(argErrorText))) {
/*  740 */       getDAO_().setErrorText(argErrorText);
/*  741 */       ev_postable = true;
/*      */     } 
/*      */     
/*  744 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getStartTimestamp() {
/*  752 */     return getDAO_().getStartTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStartTimestamp(Date argStartTimestamp) {
/*  760 */     if (setStartTimestamp_noev(argStartTimestamp) && 
/*  761 */       this._events != null && 
/*  762 */       postEventsForChanges()) {
/*  763 */       this._events.post(ITenderAuthLog.SET_STARTTIMESTAMP, argStartTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStartTimestamp_noev(Date argStartTimestamp) {
/*  770 */     boolean ev_postable = false;
/*      */     
/*  772 */     if ((getDAO_().getStartTimestamp() == null && argStartTimestamp != null) || (
/*  773 */       getDAO_().getStartTimestamp() != null && !getDAO_().getStartTimestamp().equals(argStartTimestamp))) {
/*  774 */       getDAO_().setStartTimestamp(argStartTimestamp);
/*  775 */       ev_postable = true;
/*      */     } 
/*      */     
/*  778 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndTimestamp() {
/*  786 */     return getDAO_().getEndTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndTimestamp(Date argEndTimestamp) {
/*  794 */     if (setEndTimestamp_noev(argEndTimestamp) && 
/*  795 */       this._events != null && 
/*  796 */       postEventsForChanges()) {
/*  797 */       this._events.post(ITenderAuthLog.SET_ENDTIMESTAMP, argEndTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndTimestamp_noev(Date argEndTimestamp) {
/*  804 */     boolean ev_postable = false;
/*      */     
/*  806 */     if ((getDAO_().getEndTimestamp() == null && argEndTimestamp != null) || (
/*  807 */       getDAO_().getEndTimestamp() != null && !getDAO_().getEndTimestamp().equals(argEndTimestamp))) {
/*  808 */       getDAO_().setEndTimestamp(argEndTimestamp);
/*  809 */       ev_postable = true;
/*      */     } 
/*      */     
/*  812 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ITenderAuthLogProperty newProperty(String argPropertyName) {
/*  816 */     TenderAuthLogPropertyId id = new TenderAuthLogPropertyId();
/*      */     
/*  818 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  819 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  820 */     id.setBusinessDate(getBusinessDate());
/*  821 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  822 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/*  823 */     id.setAttemptSequence(Integer.valueOf(getAttemptSequence()));
/*  824 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  826 */     ITenderAuthLogProperty prop = (ITenderAuthLogProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ITenderAuthLogProperty.class);
/*  827 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ITenderAuthLogProperty> getProperties() {
/*  836 */     if (this._properties == null) {
/*  837 */       this._properties = new HistoricalList(null);
/*      */     }
/*  839 */     return (List<ITenderAuthLogProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ITenderAuthLogProperty> argProperties) {
/*  843 */     if (this._properties == null) {
/*  844 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  846 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  849 */     for (ITenderAuthLogProperty child : this._properties) {
/*  850 */       TenderAuthLogPropertyModel model = (TenderAuthLogPropertyModel)child;
/*  851 */       model.setOrganizationId_noev(getOrganizationId());
/*  852 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  853 */       model.setWorkstationId_noev(getWorkstationId());
/*  854 */       model.setBusinessDate_noev(getBusinessDate());
/*  855 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  856 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  857 */       model.setAttemptSequence_noev(getAttemptSequence());
/*  858 */       if (child instanceof IDataModelImpl) {
/*  859 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  860 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  861 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  862 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  865 */       if (postEventsForChanges()) {
/*  866 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addTenderAuthLogProperty(ITenderAuthLogProperty argTenderAuthLogProperty) {
/*  872 */     if (this._properties == null) {
/*  873 */       this._properties = new HistoricalList(null);
/*      */     }
/*  875 */     argTenderAuthLogProperty.setOrganizationId(getOrganizationId());
/*  876 */     argTenderAuthLogProperty.setRetailLocationId(getRetailLocationId());
/*  877 */     argTenderAuthLogProperty.setWorkstationId(getWorkstationId());
/*  878 */     argTenderAuthLogProperty.setBusinessDate(getBusinessDate());
/*  879 */     argTenderAuthLogProperty.setTransactionSequence(getTransactionSequence());
/*  880 */     argTenderAuthLogProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  881 */     argTenderAuthLogProperty.setAttemptSequence(getAttemptSequence());
/*  882 */     if (argTenderAuthLogProperty instanceof IDataModelImpl) {
/*  883 */       IDataAccessObject childDao = ((IDataModelImpl)argTenderAuthLogProperty).getDAO();
/*  884 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  885 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  886 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  891 */     if (postEventsForChanges()) {
/*  892 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderAuthLogProperty));
/*      */     }
/*      */     
/*  895 */     this._properties.add(argTenderAuthLogProperty);
/*  896 */     if (postEventsForChanges()) {
/*  897 */       this._events.post(ITenderAuthLog.ADD_PROPERTIES, argTenderAuthLogProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeTenderAuthLogProperty(ITenderAuthLogProperty argTenderAuthLogProperty) {
/*  902 */     if (this._properties != null) {
/*      */       
/*  904 */       if (postEventsForChanges()) {
/*  905 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTenderAuthLogProperty));
/*      */       }
/*  907 */       this._properties.remove(argTenderAuthLogProperty);
/*  908 */       if (postEventsForChanges()) {
/*  909 */         this._events.post(ITenderAuthLog.REMOVE_PROPERTIES, argTenderAuthLogProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  916 */     if ("Properties".equals(argFieldId)) {
/*  917 */       return getProperties();
/*      */     }
/*  919 */     if ("TenderAuthLogExtension".equals(argFieldId)) {
/*  920 */       return this._myExtension;
/*      */     }
/*      */     
/*  923 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  929 */     if ("Properties".equals(argFieldId)) {
/*  930 */       setProperties(changeToList(argValue, ITenderAuthLogProperty.class));
/*      */     }
/*  932 */     else if ("TenderAuthLogExtension".equals(argFieldId)) {
/*  933 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  936 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  942 */     this._persistenceDefaults = argPD;
/*  943 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  944 */     this._eventManager = argEM;
/*  945 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  946 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  947 */     if (this._properties != null) {
/*  948 */       for (ITenderAuthLogProperty relationship : this._properties) {
/*  949 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getTenderAuthLogExt() {
/*  955 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setTenderAuthLogExt(IDataModel argExt) {
/*  959 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  964 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  968 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  971 */     super.startTransaction();
/*      */     
/*  973 */     this._propertiesSavepoint = this._properties;
/*  974 */     if (this._properties != null) {
/*  975 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  976 */       Iterator<IDataModel> it = this._properties.iterator();
/*  977 */       while (it.hasNext()) {
/*  978 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  983 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/*  988 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/*  991 */     super.rollbackChanges();
/*      */     
/*  993 */     this._properties = this._propertiesSavepoint;
/*  994 */     this._propertiesSavepoint = null;
/*  995 */     if (this._properties != null) {
/*  996 */       Iterator<IDataModel> it = this._properties.iterator();
/*  997 */       while (it.hasNext()) {
/*  998 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1006 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1009 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1012 */     super.commitTransaction();
/*      */     
/* 1014 */     this._propertiesSavepoint = this._properties;
/* 1015 */     if (this._properties != null) {
/* 1016 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1017 */       while (it.hasNext()) {
/* 1018 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1020 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1024 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1029 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\TenderAuthLogModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */