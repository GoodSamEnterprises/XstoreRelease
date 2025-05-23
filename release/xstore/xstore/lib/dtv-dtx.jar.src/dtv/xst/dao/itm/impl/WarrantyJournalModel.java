/*      */ package dtv.xst.dao.itm.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventHandler;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.itm.IWarrantyJournal;
/*      */ import dtv.xst.dao.itm.IWarrantyJournalProperty;
/*      */ import dtv.xst.dao.itm.WarrantyJournalPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class WarrantyJournalModel extends WarrantyJournalBaseModel implements IWarrantyJournal {
/*      */   private static final long serialVersionUID = 2069047931L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   34 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private HistoricalList<IWarrantyJournalProperty> _properties; private transient HistoricalList<IWarrantyJournalProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   39 */     setDAO((IDataAccessObject)new WarrantyJournalDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private WarrantyJournalDAO getDAO_() {
/*   47 */     return (WarrantyJournalDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   55 */     if (getDAO_().getOrganizationId() != null) {
/*   56 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   59 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   68 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   69 */       this._events != null && 
/*   70 */       postEventsForChanges()) {
/*   71 */       this._events.post(IWarrantyJournal.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   78 */     boolean ev_postable = false;
/*      */     
/*   80 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   81 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   82 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   83 */       ev_postable = true;
/*   84 */       if (this._properties != null) {
/*      */         
/*   86 */         Iterator<WarrantyJournalPropertyModel> it = this._properties.iterator();
/*   87 */         while (it.hasNext())
/*      */         {
/*   89 */           ((WarrantyJournalPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   94 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWarrantyNbr() {
/*  102 */     return getDAO_().getWarrantyNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  110 */     if (setWarrantyNbr_noev(argWarrantyNbr) && 
/*  111 */       this._events != null && 
/*  112 */       postEventsForChanges()) {
/*  113 */       this._events.post(IWarrantyJournal.SET_WARRANTYNBR, argWarrantyNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyNbr_noev(String argWarrantyNbr) {
/*  120 */     boolean ev_postable = false;
/*      */     
/*  122 */     if ((getDAO_().getWarrantyNbr() == null && argWarrantyNbr != null) || (
/*  123 */       getDAO_().getWarrantyNbr() != null && !getDAO_().getWarrantyNbr().equals(argWarrantyNbr))) {
/*  124 */       getDAO_().setWarrantyNbr(argWarrantyNbr);
/*  125 */       ev_postable = true;
/*  126 */       if (this._properties != null) {
/*      */         
/*  128 */         Iterator<WarrantyJournalPropertyModel> it = this._properties.iterator();
/*  129 */         while (it.hasNext())
/*      */         {
/*  131 */           ((WarrantyJournalPropertyModel)it.next()).setWarrantyNbr_noev(argWarrantyNbr);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  136 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWarrantyTypeCode() {
/*  144 */     return getDAO_().getWarrantyTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  152 */     if (setWarrantyTypeCode_noev(argWarrantyTypeCode) && 
/*  153 */       this._events != null && 
/*  154 */       postEventsForChanges()) {
/*  155 */       this._events.post(IWarrantyJournal.SET_WARRANTYTYPECODE, argWarrantyTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyTypeCode_noev(String argWarrantyTypeCode) {
/*  162 */     boolean ev_postable = false;
/*      */     
/*  164 */     if ((getDAO_().getWarrantyTypeCode() == null && argWarrantyTypeCode != null) || (
/*  165 */       getDAO_().getWarrantyTypeCode() != null && !getDAO_().getWarrantyTypeCode().equals(argWarrantyTypeCode))) {
/*  166 */       getDAO_().setWarrantyTypeCode(argWarrantyTypeCode);
/*  167 */       ev_postable = true;
/*  168 */       if (this._properties != null) {
/*      */         
/*  170 */         Iterator<WarrantyJournalPropertyModel> it = this._properties.iterator();
/*  171 */         while (it.hasNext())
/*      */         {
/*  173 */           ((WarrantyJournalPropertyModel)it.next()).setWarrantyTypeCode_noev(argWarrantyTypeCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  178 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getJournalSequence() {
/*  186 */     if (getDAO_().getJournalSequence() != null) {
/*  187 */       return getDAO_().getJournalSequence().longValue();
/*      */     }
/*      */     
/*  190 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setJournalSequence(long argJournalSequence) {
/*  199 */     if (setJournalSequence_noev(argJournalSequence) && 
/*  200 */       this._events != null && 
/*  201 */       postEventsForChanges()) {
/*  202 */       this._events.post(IWarrantyJournal.SET_JOURNALSEQUENCE, Long.valueOf(argJournalSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setJournalSequence_noev(long argJournalSequence) {
/*  209 */     boolean ev_postable = false;
/*      */     
/*  211 */     if ((getDAO_().getJournalSequence() == null && Long.valueOf(argJournalSequence) != null) || (
/*  212 */       getDAO_().getJournalSequence() != null && !getDAO_().getJournalSequence().equals(Long.valueOf(argJournalSequence)))) {
/*  213 */       getDAO_().setJournalSequence(Long.valueOf(argJournalSequence));
/*  214 */       ev_postable = true;
/*  215 */       if (this._properties != null) {
/*      */         
/*  217 */         Iterator<WarrantyJournalPropertyModel> it = this._properties.iterator();
/*  218 */         while (it.hasNext())
/*      */         {
/*  220 */           ((WarrantyJournalPropertyModel)it.next()).setJournalSequence_noev(argJournalSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  225 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  233 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  241 */     if (setOrgCode_noev(argOrgCode) && 
/*  242 */       this._events != null && 
/*  243 */       postEventsForChanges()) {
/*  244 */       this._events.post(IWarrantyJournal.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  251 */     boolean ev_postable = false;
/*      */     
/*  253 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  254 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  255 */       getDAO_().setOrgCode(argOrgCode);
/*  256 */       ev_postable = true;
/*      */     } 
/*      */     
/*  259 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  267 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  275 */     if (setOrgValue_noev(argOrgValue) && 
/*  276 */       this._events != null && 
/*  277 */       postEventsForChanges()) {
/*  278 */       this._events.post(IWarrantyJournal.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  285 */     boolean ev_postable = false;
/*      */     
/*  287 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  288 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  289 */       getDAO_().setOrgValue(argOrgValue);
/*  290 */       ev_postable = true;
/*      */     } 
/*      */     
/*  293 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  301 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  309 */     if (setCreateDate_noev(argCreateDate) && 
/*  310 */       this._events != null && 
/*  311 */       postEventsForChanges()) {
/*  312 */       this._events.post(IWarrantyJournal.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  319 */     boolean ev_postable = false;
/*      */     
/*  321 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  322 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  323 */       getDAO_().setCreateDate(argCreateDate);
/*  324 */       ev_postable = true;
/*      */     } 
/*      */     
/*  327 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  335 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  343 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  344 */       this._events != null && 
/*  345 */       postEventsForChanges()) {
/*  346 */       this._events.post(IWarrantyJournal.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  353 */     boolean ev_postable = false;
/*      */     
/*  355 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  356 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  357 */       getDAO_().setCreateUserId(argCreateUserId);
/*  358 */       ev_postable = true;
/*      */     } 
/*      */     
/*  361 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  369 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  377 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  378 */       this._events != null && 
/*  379 */       postEventsForChanges()) {
/*  380 */       this._events.post(IWarrantyJournal.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  387 */     boolean ev_postable = false;
/*      */     
/*  389 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  390 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  391 */       getDAO_().setUpdateDate(argUpdateDate);
/*  392 */       ev_postable = true;
/*      */     } 
/*      */     
/*  395 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  403 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  411 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  412 */       this._events != null && 
/*  413 */       postEventsForChanges()) {
/*  414 */       this._events.post(IWarrantyJournal.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  421 */     boolean ev_postable = false;
/*      */     
/*  423 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  424 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  425 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  426 */       ev_postable = true;
/*      */     } 
/*      */     
/*  429 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getTransBusinessDate() {
/*  437 */     return getDAO_().getTransBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransBusinessDate(Date argTransBusinessDate) {
/*  445 */     if (setTransBusinessDate_noev(argTransBusinessDate) && 
/*  446 */       this._events != null && 
/*  447 */       postEventsForChanges()) {
/*  448 */       this._events.post(IWarrantyJournal.SET_TRANSBUSINESSDATE, argTransBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransBusinessDate_noev(Date argTransBusinessDate) {
/*  455 */     boolean ev_postable = false;
/*      */     
/*  457 */     if ((getDAO_().getTransBusinessDate() == null && argTransBusinessDate != null) || (
/*  458 */       getDAO_().getTransBusinessDate() != null && !getDAO_().getTransBusinessDate().equals(argTransBusinessDate))) {
/*  459 */       getDAO_().setTransBusinessDate(argTransBusinessDate);
/*  460 */       ev_postable = true;
/*      */     } 
/*      */     
/*  463 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransRtlLocId() {
/*  471 */     if (getDAO_().getTransRtlLocId() != null) {
/*  472 */       return getDAO_().getTransRtlLocId().longValue();
/*      */     }
/*      */     
/*  475 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransRtlLocId(long argTransRtlLocId) {
/*  484 */     if (setTransRtlLocId_noev(argTransRtlLocId) && 
/*  485 */       this._events != null && 
/*  486 */       postEventsForChanges()) {
/*  487 */       this._events.post(IWarrantyJournal.SET_TRANSRTLLOCID, Long.valueOf(argTransRtlLocId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransRtlLocId_noev(long argTransRtlLocId) {
/*  494 */     boolean ev_postable = false;
/*      */     
/*  496 */     if ((getDAO_().getTransRtlLocId() == null && Long.valueOf(argTransRtlLocId) != null) || (
/*  497 */       getDAO_().getTransRtlLocId() != null && !getDAO_().getTransRtlLocId().equals(Long.valueOf(argTransRtlLocId)))) {
/*  498 */       getDAO_().setTransRtlLocId(Long.valueOf(argTransRtlLocId));
/*  499 */       ev_postable = true;
/*      */     } 
/*      */     
/*  502 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransWkstnId() {
/*  510 */     if (getDAO_().getTransWkstnId() != null) {
/*  511 */       return getDAO_().getTransWkstnId().longValue();
/*      */     }
/*      */     
/*  514 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransWkstnId(long argTransWkstnId) {
/*  523 */     if (setTransWkstnId_noev(argTransWkstnId) && 
/*  524 */       this._events != null && 
/*  525 */       postEventsForChanges()) {
/*  526 */       this._events.post(IWarrantyJournal.SET_TRANSWKSTNID, Long.valueOf(argTransWkstnId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransWkstnId_noev(long argTransWkstnId) {
/*  533 */     boolean ev_postable = false;
/*      */     
/*  535 */     if ((getDAO_().getTransWkstnId() == null && Long.valueOf(argTransWkstnId) != null) || (
/*  536 */       getDAO_().getTransWkstnId() != null && !getDAO_().getTransWkstnId().equals(Long.valueOf(argTransWkstnId)))) {
/*  537 */       getDAO_().setTransWkstnId(Long.valueOf(argTransWkstnId));
/*  538 */       ev_postable = true;
/*      */     } 
/*      */     
/*  541 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransTransSeq() {
/*  549 */     if (getDAO_().getTransTransSeq() != null) {
/*  550 */       return getDAO_().getTransTransSeq().longValue();
/*      */     }
/*      */     
/*  553 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransTransSeq(long argTransTransSeq) {
/*  562 */     if (setTransTransSeq_noev(argTransTransSeq) && 
/*  563 */       this._events != null && 
/*  564 */       postEventsForChanges()) {
/*  565 */       this._events.post(IWarrantyJournal.SET_TRANSTRANSSEQ, Long.valueOf(argTransTransSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransTransSeq_noev(long argTransTransSeq) {
/*  572 */     boolean ev_postable = false;
/*      */     
/*  574 */     if ((getDAO_().getTransTransSeq() == null && Long.valueOf(argTransTransSeq) != null) || (
/*  575 */       getDAO_().getTransTransSeq() != null && !getDAO_().getTransTransSeq().equals(Long.valueOf(argTransTransSeq)))) {
/*  576 */       getDAO_().setTransTransSeq(Long.valueOf(argTransTransSeq));
/*  577 */       ev_postable = true;
/*      */     } 
/*      */     
/*  580 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWarrantyPlanId() {
/*  588 */     return getDAO_().getWarrantyPlanId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyPlanId(String argWarrantyPlanId) {
/*  596 */     if (setWarrantyPlanId_noev(argWarrantyPlanId) && 
/*  597 */       this._events != null && 
/*  598 */       postEventsForChanges()) {
/*  599 */       this._events.post(IWarrantyJournal.SET_WARRANTYPLANID, argWarrantyPlanId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyPlanId_noev(String argWarrantyPlanId) {
/*  606 */     boolean ev_postable = false;
/*      */     
/*  608 */     if ((getDAO_().getWarrantyPlanId() == null && argWarrantyPlanId != null) || (
/*  609 */       getDAO_().getWarrantyPlanId() != null && !getDAO_().getWarrantyPlanId().equals(argWarrantyPlanId))) {
/*  610 */       getDAO_().setWarrantyPlanId(argWarrantyPlanId);
/*  611 */       ev_postable = true;
/*      */     } 
/*      */     
/*  614 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getWarrantyIssueDate() {
/*  622 */     return getDAO_().getWarrantyIssueDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyIssueDate(Date argWarrantyIssueDate) {
/*  630 */     if (setWarrantyIssueDate_noev(argWarrantyIssueDate) && 
/*  631 */       this._events != null && 
/*  632 */       postEventsForChanges()) {
/*  633 */       this._events.post(IWarrantyJournal.SET_WARRANTYISSUEDATE, argWarrantyIssueDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyIssueDate_noev(Date argWarrantyIssueDate) {
/*  640 */     boolean ev_postable = false;
/*      */     
/*  642 */     if ((getDAO_().getWarrantyIssueDate() == null && argWarrantyIssueDate != null) || (
/*  643 */       getDAO_().getWarrantyIssueDate() != null && !getDAO_().getWarrantyIssueDate().equals(argWarrantyIssueDate))) {
/*  644 */       getDAO_().setWarrantyIssueDate(argWarrantyIssueDate);
/*  645 */       ev_postable = true;
/*      */     } 
/*      */     
/*  648 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getWarrantyExpirationDate() {
/*  656 */     return getDAO_().getWarrantyExpirationDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyExpirationDate(Date argWarrantyExpirationDate) {
/*  664 */     if (setWarrantyExpirationDate_noev(argWarrantyExpirationDate) && 
/*  665 */       this._events != null && 
/*  666 */       postEventsForChanges()) {
/*  667 */       this._events.post(IWarrantyJournal.SET_WARRANTYEXPIRATIONDATE, argWarrantyExpirationDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyExpirationDate_noev(Date argWarrantyExpirationDate) {
/*  674 */     boolean ev_postable = false;
/*      */     
/*  676 */     if ((getDAO_().getWarrantyExpirationDate() == null && argWarrantyExpirationDate != null) || (
/*  677 */       getDAO_().getWarrantyExpirationDate() != null && !getDAO_().getWarrantyExpirationDate().equals(argWarrantyExpirationDate))) {
/*  678 */       getDAO_().setWarrantyExpirationDate(argWarrantyExpirationDate);
/*  679 */       ev_postable = true;
/*      */     } 
/*      */     
/*  682 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  690 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  698 */     if (setStatusCode_noev(argStatusCode) && 
/*  699 */       this._events != null && 
/*  700 */       postEventsForChanges()) {
/*  701 */       this._events.post(IWarrantyJournal.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  708 */     boolean ev_postable = false;
/*      */     
/*  710 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  711 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  712 */       getDAO_().setStatusCode(argStatusCode);
/*  713 */       ev_postable = true;
/*      */     } 
/*      */     
/*  716 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPurchasePrice() {
/*  724 */     return getDAO_().getPurchasePrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPurchasePrice(BigDecimal argPurchasePrice) {
/*  732 */     if (setPurchasePrice_noev(argPurchasePrice) && 
/*  733 */       this._events != null && 
/*  734 */       postEventsForChanges()) {
/*  735 */       this._events.post(IWarrantyJournal.SET_PURCHASEPRICE, argPurchasePrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPurchasePrice_noev(BigDecimal argPurchasePrice) {
/*  742 */     boolean ev_postable = false;
/*      */     
/*  744 */     if ((getDAO_().getPurchasePrice() == null && argPurchasePrice != null) || (
/*  745 */       getDAO_().getPurchasePrice() != null && !getDAO_().getPurchasePrice().equals(argPurchasePrice))) {
/*  746 */       getDAO_().setPurchasePrice(argPurchasePrice);
/*  747 */       ev_postable = true;
/*      */     } 
/*      */     
/*  750 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCustomerId() {
/*  758 */     return getDAO_().getCustomerId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerId(String argCustomerId) {
/*  766 */     if (setCustomerId_noev(argCustomerId) && 
/*  767 */       this._events != null && 
/*  768 */       postEventsForChanges()) {
/*  769 */       this._events.post(IWarrantyJournal.SET_CUSTOMERID, argCustomerId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomerId_noev(String argCustomerId) {
/*  776 */     boolean ev_postable = false;
/*      */     
/*  778 */     if ((getDAO_().getCustomerId() == null && argCustomerId != null) || (
/*  779 */       getDAO_().getCustomerId() != null && !getDAO_().getCustomerId().equals(argCustomerId))) {
/*  780 */       getDAO_().setCustomerId(argCustomerId);
/*  781 */       ev_postable = true;
/*      */     } 
/*      */     
/*  784 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPartyId() {
/*  792 */     if (getDAO_().getPartyId() != null) {
/*  793 */       return getDAO_().getPartyId().longValue();
/*      */     }
/*      */     
/*  796 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartyId(long argPartyId) {
/*  805 */     if (setPartyId_noev(argPartyId) && 
/*  806 */       this._events != null && 
/*  807 */       postEventsForChanges()) {
/*  808 */       this._events.post(IWarrantyJournal.SET_PARTYID, Long.valueOf(argPartyId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartyId_noev(long argPartyId) {
/*  815 */     boolean ev_postable = false;
/*      */     
/*  817 */     if ((getDAO_().getPartyId() == null && Long.valueOf(argPartyId) != null) || (
/*  818 */       getDAO_().getPartyId() != null && !getDAO_().getPartyId().equals(Long.valueOf(argPartyId)))) {
/*  819 */       getDAO_().setPartyId(Long.valueOf(argPartyId));
/*  820 */       ev_postable = true;
/*      */     } 
/*      */     
/*  823 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCertificateNbr() {
/*  831 */     return getDAO_().getCertificateNbr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateNbr(String argCertificateNbr) {
/*  839 */     if (setCertificateNbr_noev(argCertificateNbr) && 
/*  840 */       this._events != null && 
/*  841 */       postEventsForChanges()) {
/*  842 */       this._events.post(IWarrantyJournal.SET_CERTIFICATENBR, argCertificateNbr);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateNbr_noev(String argCertificateNbr) {
/*  849 */     boolean ev_postable = false;
/*      */     
/*  851 */     if ((getDAO_().getCertificateNbr() == null && argCertificateNbr != null) || (
/*  852 */       getDAO_().getCertificateNbr() != null && !getDAO_().getCertificateNbr().equals(argCertificateNbr))) {
/*  853 */       getDAO_().setCertificateNbr(argCertificateNbr);
/*  854 */       ev_postable = true;
/*      */     } 
/*      */     
/*  857 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCertificateCompanyName() {
/*  865 */     return getDAO_().getCertificateCompanyName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCertificateCompanyName(String argCertificateCompanyName) {
/*  873 */     if (setCertificateCompanyName_noev(argCertificateCompanyName) && 
/*  874 */       this._events != null && 
/*  875 */       postEventsForChanges()) {
/*  876 */       this._events.post(IWarrantyJournal.SET_CERTIFICATECOMPANYNAME, argCertificateCompanyName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCertificateCompanyName_noev(String argCertificateCompanyName) {
/*  883 */     boolean ev_postable = false;
/*      */     
/*  885 */     if ((getDAO_().getCertificateCompanyName() == null && argCertificateCompanyName != null) || (
/*  886 */       getDAO_().getCertificateCompanyName() != null && !getDAO_().getCertificateCompanyName().equals(argCertificateCompanyName))) {
/*  887 */       getDAO_().setCertificateCompanyName(argCertificateCompanyName);
/*  888 */       ev_postable = true;
/*      */     } 
/*      */     
/*  891 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWarrantyItemId() {
/*  899 */     return getDAO_().getWarrantyItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyItemId(String argWarrantyItemId) {
/*  907 */     if (setWarrantyItemId_noev(argWarrantyItemId) && 
/*  908 */       this._events != null && 
/*  909 */       postEventsForChanges()) {
/*  910 */       this._events.post(IWarrantyJournal.SET_WARRANTYITEMID, argWarrantyItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyItemId_noev(String argWarrantyItemId) {
/*  917 */     boolean ev_postable = false;
/*      */     
/*  919 */     if ((getDAO_().getWarrantyItemId() == null && argWarrantyItemId != null) || (
/*  920 */       getDAO_().getWarrantyItemId() != null && !getDAO_().getWarrantyItemId().equals(argWarrantyItemId))) {
/*  921 */       getDAO_().setWarrantyItemId(argWarrantyItemId);
/*  922 */       ev_postable = true;
/*      */     } 
/*      */     
/*  925 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getWarrantyLineBusinessDate() {
/*  933 */     return getDAO_().getWarrantyLineBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineBusinessDate(Date argWarrantyLineBusinessDate) {
/*  941 */     if (setWarrantyLineBusinessDate_noev(argWarrantyLineBusinessDate) && 
/*  942 */       this._events != null && 
/*  943 */       postEventsForChanges()) {
/*  944 */       this._events.post(IWarrantyJournal.SET_WARRANTYLINEBUSINESSDATE, argWarrantyLineBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineBusinessDate_noev(Date argWarrantyLineBusinessDate) {
/*  951 */     boolean ev_postable = false;
/*      */     
/*  953 */     if ((getDAO_().getWarrantyLineBusinessDate() == null && argWarrantyLineBusinessDate != null) || (
/*  954 */       getDAO_().getWarrantyLineBusinessDate() != null && !getDAO_().getWarrantyLineBusinessDate().equals(argWarrantyLineBusinessDate))) {
/*  955 */       getDAO_().setWarrantyLineBusinessDate(argWarrantyLineBusinessDate);
/*  956 */       ev_postable = true;
/*      */     } 
/*      */     
/*  959 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWarrantyLineRtlLocId() {
/*  967 */     if (getDAO_().getWarrantyLineRtlLocId() != null) {
/*  968 */       return getDAO_().getWarrantyLineRtlLocId().longValue();
/*      */     }
/*      */     
/*  971 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineRtlLocId(long argWarrantyLineRtlLocId) {
/*  980 */     if (setWarrantyLineRtlLocId_noev(argWarrantyLineRtlLocId) && 
/*  981 */       this._events != null && 
/*  982 */       postEventsForChanges()) {
/*  983 */       this._events.post(IWarrantyJournal.SET_WARRANTYLINERTLLOCID, Long.valueOf(argWarrantyLineRtlLocId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineRtlLocId_noev(long argWarrantyLineRtlLocId) {
/*  990 */     boolean ev_postable = false;
/*      */     
/*  992 */     if ((getDAO_().getWarrantyLineRtlLocId() == null && Long.valueOf(argWarrantyLineRtlLocId) != null) || (
/*  993 */       getDAO_().getWarrantyLineRtlLocId() != null && !getDAO_().getWarrantyLineRtlLocId().equals(Long.valueOf(argWarrantyLineRtlLocId)))) {
/*  994 */       getDAO_().setWarrantyLineRtlLocId(Long.valueOf(argWarrantyLineRtlLocId));
/*  995 */       ev_postable = true;
/*      */     } 
/*      */     
/*  998 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWarrantyLineWkstnId() {
/* 1006 */     if (getDAO_().getWarrantyLineWkstnId() != null) {
/* 1007 */       return getDAO_().getWarrantyLineWkstnId().longValue();
/*      */     }
/*      */     
/* 1010 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineWkstnId(long argWarrantyLineWkstnId) {
/* 1019 */     if (setWarrantyLineWkstnId_noev(argWarrantyLineWkstnId) && 
/* 1020 */       this._events != null && 
/* 1021 */       postEventsForChanges()) {
/* 1022 */       this._events.post(IWarrantyJournal.SET_WARRANTYLINEWKSTNID, Long.valueOf(argWarrantyLineWkstnId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineWkstnId_noev(long argWarrantyLineWkstnId) {
/* 1029 */     boolean ev_postable = false;
/*      */     
/* 1031 */     if ((getDAO_().getWarrantyLineWkstnId() == null && Long.valueOf(argWarrantyLineWkstnId) != null) || (
/* 1032 */       getDAO_().getWarrantyLineWkstnId() != null && !getDAO_().getWarrantyLineWkstnId().equals(Long.valueOf(argWarrantyLineWkstnId)))) {
/* 1033 */       getDAO_().setWarrantyLineWkstnId(Long.valueOf(argWarrantyLineWkstnId));
/* 1034 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1037 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWarrantyLineTransSeq() {
/* 1045 */     if (getDAO_().getWarrantyLineTransSeq() != null) {
/* 1046 */       return getDAO_().getWarrantyLineTransSeq().longValue();
/*      */     }
/*      */     
/* 1049 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineTransSeq(long argWarrantyLineTransSeq) {
/* 1058 */     if (setWarrantyLineTransSeq_noev(argWarrantyLineTransSeq) && 
/* 1059 */       this._events != null && 
/* 1060 */       postEventsForChanges()) {
/* 1061 */       this._events.post(IWarrantyJournal.SET_WARRANTYLINETRANSSEQ, Long.valueOf(argWarrantyLineTransSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineTransSeq_noev(long argWarrantyLineTransSeq) {
/* 1068 */     boolean ev_postable = false;
/*      */     
/* 1070 */     if ((getDAO_().getWarrantyLineTransSeq() == null && Long.valueOf(argWarrantyLineTransSeq) != null) || (
/* 1071 */       getDAO_().getWarrantyLineTransSeq() != null && !getDAO_().getWarrantyLineTransSeq().equals(Long.valueOf(argWarrantyLineTransSeq)))) {
/* 1072 */       getDAO_().setWarrantyLineTransSeq(Long.valueOf(argWarrantyLineTransSeq));
/* 1073 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1076 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getWarrantyLineTransLineItemSeq() {
/* 1084 */     if (getDAO_().getWarrantyLineTransLineItemSeq() != null) {
/* 1085 */       return getDAO_().getWarrantyLineTransLineItemSeq().intValue();
/*      */     }
/*      */     
/* 1088 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarrantyLineTransLineItemSeq(int argWarrantyLineTransLineItemSeq) {
/* 1097 */     if (setWarrantyLineTransLineItemSeq_noev(argWarrantyLineTransLineItemSeq) && 
/* 1098 */       this._events != null && 
/* 1099 */       postEventsForChanges()) {
/* 1100 */       this._events.post(IWarrantyJournal.SET_WARRANTYLINETRANSLINEITEMSEQ, Integer.valueOf(argWarrantyLineTransLineItemSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarrantyLineTransLineItemSeq_noev(int argWarrantyLineTransLineItemSeq) {
/* 1107 */     boolean ev_postable = false;
/*      */     
/* 1109 */     if ((getDAO_().getWarrantyLineTransLineItemSeq() == null && Integer.valueOf(argWarrantyLineTransLineItemSeq) != null) || (
/* 1110 */       getDAO_().getWarrantyLineTransLineItemSeq() != null && !getDAO_().getWarrantyLineTransLineItemSeq().equals(Integer.valueOf(argWarrantyLineTransLineItemSeq)))) {
/* 1111 */       getDAO_().setWarrantyLineTransLineItemSeq(Integer.valueOf(argWarrantyLineTransLineItemSeq));
/* 1112 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1115 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCoveredItemId() {
/* 1123 */     return getDAO_().getCoveredItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredItemId(String argCoveredItemId) {
/* 1131 */     if (setCoveredItemId_noev(argCoveredItemId) && 
/* 1132 */       this._events != null && 
/* 1133 */       postEventsForChanges()) {
/* 1134 */       this._events.post(IWarrantyJournal.SET_COVEREDITEMID, argCoveredItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredItemId_noev(String argCoveredItemId) {
/* 1141 */     boolean ev_postable = false;
/*      */     
/* 1143 */     if ((getDAO_().getCoveredItemId() == null && argCoveredItemId != null) || (
/* 1144 */       getDAO_().getCoveredItemId() != null && !getDAO_().getCoveredItemId().equals(argCoveredItemId))) {
/* 1145 */       getDAO_().setCoveredItemId(argCoveredItemId);
/* 1146 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1149 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCoveredLineBusinessDate() {
/* 1157 */     return getDAO_().getCoveredLineBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineBusinessDate(Date argCoveredLineBusinessDate) {
/* 1165 */     if (setCoveredLineBusinessDate_noev(argCoveredLineBusinessDate) && 
/* 1166 */       this._events != null && 
/* 1167 */       postEventsForChanges()) {
/* 1168 */       this._events.post(IWarrantyJournal.SET_COVEREDLINEBUSINESSDATE, argCoveredLineBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineBusinessDate_noev(Date argCoveredLineBusinessDate) {
/* 1175 */     boolean ev_postable = false;
/*      */     
/* 1177 */     if ((getDAO_().getCoveredLineBusinessDate() == null && argCoveredLineBusinessDate != null) || (
/* 1178 */       getDAO_().getCoveredLineBusinessDate() != null && !getDAO_().getCoveredLineBusinessDate().equals(argCoveredLineBusinessDate))) {
/* 1179 */       getDAO_().setCoveredLineBusinessDate(argCoveredLineBusinessDate);
/* 1180 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1183 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCoveredLineRtlLocId() {
/* 1191 */     if (getDAO_().getCoveredLineRtlLocId() != null) {
/* 1192 */       return getDAO_().getCoveredLineRtlLocId().longValue();
/*      */     }
/*      */     
/* 1195 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineRtlLocId(long argCoveredLineRtlLocId) {
/* 1204 */     if (setCoveredLineRtlLocId_noev(argCoveredLineRtlLocId) && 
/* 1205 */       this._events != null && 
/* 1206 */       postEventsForChanges()) {
/* 1207 */       this._events.post(IWarrantyJournal.SET_COVEREDLINERTLLOCID, Long.valueOf(argCoveredLineRtlLocId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineRtlLocId_noev(long argCoveredLineRtlLocId) {
/* 1214 */     boolean ev_postable = false;
/*      */     
/* 1216 */     if ((getDAO_().getCoveredLineRtlLocId() == null && Long.valueOf(argCoveredLineRtlLocId) != null) || (
/* 1217 */       getDAO_().getCoveredLineRtlLocId() != null && !getDAO_().getCoveredLineRtlLocId().equals(Long.valueOf(argCoveredLineRtlLocId)))) {
/* 1218 */       getDAO_().setCoveredLineRtlLocId(Long.valueOf(argCoveredLineRtlLocId));
/* 1219 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1222 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCoveredLineWkstnId() {
/* 1230 */     if (getDAO_().getCoveredLineWkstnId() != null) {
/* 1231 */       return getDAO_().getCoveredLineWkstnId().longValue();
/*      */     }
/*      */     
/* 1234 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineWkstnId(long argCoveredLineWkstnId) {
/* 1243 */     if (setCoveredLineWkstnId_noev(argCoveredLineWkstnId) && 
/* 1244 */       this._events != null && 
/* 1245 */       postEventsForChanges()) {
/* 1246 */       this._events.post(IWarrantyJournal.SET_COVEREDLINEWKSTNID, Long.valueOf(argCoveredLineWkstnId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineWkstnId_noev(long argCoveredLineWkstnId) {
/* 1253 */     boolean ev_postable = false;
/*      */     
/* 1255 */     if ((getDAO_().getCoveredLineWkstnId() == null && Long.valueOf(argCoveredLineWkstnId) != null) || (
/* 1256 */       getDAO_().getCoveredLineWkstnId() != null && !getDAO_().getCoveredLineWkstnId().equals(Long.valueOf(argCoveredLineWkstnId)))) {
/* 1257 */       getDAO_().setCoveredLineWkstnId(Long.valueOf(argCoveredLineWkstnId));
/* 1258 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1261 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCoveredLineTransSeq() {
/* 1269 */     if (getDAO_().getCoveredLineTransSeq() != null) {
/* 1270 */       return getDAO_().getCoveredLineTransSeq().longValue();
/*      */     }
/*      */     
/* 1273 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineTransSeq(long argCoveredLineTransSeq) {
/* 1282 */     if (setCoveredLineTransSeq_noev(argCoveredLineTransSeq) && 
/* 1283 */       this._events != null && 
/* 1284 */       postEventsForChanges()) {
/* 1285 */       this._events.post(IWarrantyJournal.SET_COVEREDLINETRANSSEQ, Long.valueOf(argCoveredLineTransSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineTransSeq_noev(long argCoveredLineTransSeq) {
/* 1292 */     boolean ev_postable = false;
/*      */     
/* 1294 */     if ((getDAO_().getCoveredLineTransSeq() == null && Long.valueOf(argCoveredLineTransSeq) != null) || (
/* 1295 */       getDAO_().getCoveredLineTransSeq() != null && !getDAO_().getCoveredLineTransSeq().equals(Long.valueOf(argCoveredLineTransSeq)))) {
/* 1296 */       getDAO_().setCoveredLineTransSeq(Long.valueOf(argCoveredLineTransSeq));
/* 1297 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1300 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCoveredLineTransLineItemSeq() {
/* 1308 */     if (getDAO_().getCoveredLineTransLineItemSeq() != null) {
/* 1309 */       return getDAO_().getCoveredLineTransLineItemSeq().intValue();
/*      */     }
/*      */     
/* 1312 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCoveredLineTransLineItemSeq(int argCoveredLineTransLineItemSeq) {
/* 1321 */     if (setCoveredLineTransLineItemSeq_noev(argCoveredLineTransLineItemSeq) && 
/* 1322 */       this._events != null && 
/* 1323 */       postEventsForChanges()) {
/* 1324 */       this._events.post(IWarrantyJournal.SET_COVEREDLINETRANSLINEITEMSEQ, Integer.valueOf(argCoveredLineTransLineItemSeq));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCoveredLineTransLineItemSeq_noev(int argCoveredLineTransLineItemSeq) {
/* 1331 */     boolean ev_postable = false;
/*      */     
/* 1333 */     if ((getDAO_().getCoveredLineTransLineItemSeq() == null && Integer.valueOf(argCoveredLineTransLineItemSeq) != null) || (
/* 1334 */       getDAO_().getCoveredLineTransLineItemSeq() != null && !getDAO_().getCoveredLineTransLineItemSeq().equals(Integer.valueOf(argCoveredLineTransLineItemSeq)))) {
/* 1335 */       getDAO_().setCoveredLineTransLineItemSeq(Integer.valueOf(argCoveredLineTransLineItemSeq));
/* 1336 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1339 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IWarrantyJournalProperty newProperty(String argPropertyName) {
/* 1343 */     WarrantyJournalPropertyId id = new WarrantyJournalPropertyId();
/*      */     
/* 1345 */     id.setWarrantyNbr(getWarrantyNbr());
/* 1346 */     id.setWarrantyTypeCode(getWarrantyTypeCode());
/* 1347 */     id.setJournalSequence(Long.valueOf(getJournalSequence()));
/* 1348 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1350 */     IWarrantyJournalProperty prop = (IWarrantyJournalProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IWarrantyJournalProperty.class);
/* 1351 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IWarrantyJournalProperty> getProperties() {
/* 1360 */     if (this._properties == null) {
/* 1361 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1363 */     return (List<IWarrantyJournalProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IWarrantyJournalProperty> argProperties) {
/* 1367 */     if (this._properties == null) {
/* 1368 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1370 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1373 */     for (IWarrantyJournalProperty child : this._properties) {
/* 1374 */       WarrantyJournalPropertyModel model = (WarrantyJournalPropertyModel)child;
/* 1375 */       model.setOrganizationId_noev(getOrganizationId());
/* 1376 */       model.setWarrantyNbr_noev(getWarrantyNbr());
/* 1377 */       model.setWarrantyTypeCode_noev(getWarrantyTypeCode());
/* 1378 */       model.setJournalSequence_noev(getJournalSequence());
/* 1379 */       if (child instanceof IDataModelImpl) {
/* 1380 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1381 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1382 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1383 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1386 */       if (postEventsForChanges()) {
/* 1387 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addWarrantyJournalProperty(IWarrantyJournalProperty argWarrantyJournalProperty) {
/* 1393 */     if (this._properties == null) {
/* 1394 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1396 */     argWarrantyJournalProperty.setOrganizationId(getOrganizationId());
/* 1397 */     argWarrantyJournalProperty.setWarrantyNbr(getWarrantyNbr());
/* 1398 */     argWarrantyJournalProperty.setWarrantyTypeCode(getWarrantyTypeCode());
/* 1399 */     argWarrantyJournalProperty.setJournalSequence(getJournalSequence());
/* 1400 */     if (argWarrantyJournalProperty instanceof IDataModelImpl) {
/* 1401 */       IDataAccessObject childDao = ((IDataModelImpl)argWarrantyJournalProperty).getDAO();
/* 1402 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1403 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1404 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1409 */     if (postEventsForChanges()) {
/* 1410 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyJournalProperty));
/*      */     }
/*      */     
/* 1413 */     this._properties.add(argWarrantyJournalProperty);
/* 1414 */     if (postEventsForChanges()) {
/* 1415 */       this._events.post(IWarrantyJournal.ADD_PROPERTIES, argWarrantyJournalProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeWarrantyJournalProperty(IWarrantyJournalProperty argWarrantyJournalProperty) {
/* 1420 */     if (this._properties != null) {
/*      */       
/* 1422 */       if (postEventsForChanges()) {
/* 1423 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argWarrantyJournalProperty));
/*      */       }
/* 1425 */       this._properties.remove(argWarrantyJournalProperty);
/* 1426 */       if (postEventsForChanges()) {
/* 1427 */         this._events.post(IWarrantyJournal.REMOVE_PROPERTIES, argWarrantyJournalProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1434 */     if ("Properties".equals(argFieldId)) {
/* 1435 */       return getProperties();
/*      */     }
/* 1437 */     if ("WarrantyJournalExtension".equals(argFieldId)) {
/* 1438 */       return this._myExtension;
/*      */     }
/*      */     
/* 1441 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1447 */     if ("Properties".equals(argFieldId)) {
/* 1448 */       setProperties(changeToList(argValue, IWarrantyJournalProperty.class));
/*      */     }
/* 1450 */     else if ("WarrantyJournalExtension".equals(argFieldId)) {
/* 1451 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1454 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1460 */     this._persistenceDefaults = argPD;
/* 1461 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1462 */     this._eventManager = argEM;
/* 1463 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1464 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1465 */     if (this._properties != null) {
/* 1466 */       for (IWarrantyJournalProperty relationship : this._properties) {
/* 1467 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getWarrantyJournalExt() {
/* 1473 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setWarrantyJournalExt(IDataModel argExt) {
/* 1477 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1482 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1486 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1489 */     super.startTransaction();
/*      */     
/* 1491 */     this._propertiesSavepoint = this._properties;
/* 1492 */     if (this._properties != null) {
/* 1493 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1494 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1495 */       while (it.hasNext()) {
/* 1496 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1501 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1506 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1509 */     super.rollbackChanges();
/*      */     
/* 1511 */     this._properties = this._propertiesSavepoint;
/* 1512 */     this._propertiesSavepoint = null;
/* 1513 */     if (this._properties != null) {
/* 1514 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1515 */       while (it.hasNext()) {
/* 1516 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1524 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1527 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1530 */     super.commitTransaction();
/*      */     
/* 1532 */     this._propertiesSavepoint = this._properties;
/* 1533 */     if (this._properties != null) {
/* 1534 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1535 */       while (it.hasNext()) {
/* 1536 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1538 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1542 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */