/*     */ package dtv.xst.dao.cat.impl;
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ModelEventor;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.handler.CascadingHandler;
/*     */ import dtv.util.HistoricalList;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.cat.EscrowAccountActivityPropertyId;
/*     */ import dtv.xst.dao.cat.IEscrowAccountActivity;
/*     */ import dtv.xst.dao.cat.IEscrowAccountActivityProperty;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public class EscrowAccountActivityModel extends AbstractDataModelWithPropertyImpl<IEscrowAccountActivityProperty> implements IEscrowAccountActivity {
/*     */   private static final long serialVersionUID = -374900425L;
/*     */   private transient boolean _alreadyInStart = false;
/*     */   private transient boolean _alreadyInCommit = false;
/*     */   
/*     */   public String toString() {
/*  33 */     return super.toString() + " Id: " + getObjectId();
/*     */   }
/*     */   private IDataModel _myExtension; private HistoricalList<IEscrowAccountActivityProperty> _properties; private transient HistoricalList<IEscrowAccountActivityProperty> _propertiesSavepoint;
/*     */   
/*     */   public void initDAO() {
/*  38 */     setDAO((IDataAccessObject)new EscrowAccountActivityDAO());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EscrowAccountActivityDAO getDAO_() {
/*  46 */     return (EscrowAccountActivityDAO)this._daoImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  54 */     if (getDAO_().getOrganizationId() != null) {
/*  55 */       return getDAO_().getOrganizationId().longValue();
/*     */     }
/*     */     
/*  58 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/*  67 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  68 */       this._events != null && 
/*  69 */       postEventsForChanges()) {
/*  70 */       this._events.post(IEscrowAccountActivity.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  77 */     boolean ev_postable = false;
/*     */     
/*  79 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  80 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  81 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  82 */       ev_postable = true;
/*  83 */       if (this._properties != null) {
/*     */         
/*  85 */         Iterator<EscrowAccountActivityPropertyModel> it = this._properties.iterator();
/*  86 */         while (it.hasNext())
/*     */         {
/*  88 */           ((EscrowAccountActivityPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/* 101 */     return getDAO_().getCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/* 109 */     if (setCustAccountId_noev(argCustAccountId) && 
/* 110 */       this._events != null && 
/* 111 */       postEventsForChanges()) {
/* 112 */       this._events.post(IEscrowAccountActivity.SET_CUSTACCOUNTID, argCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustAccountId_noev(String argCustAccountId) {
/* 119 */     boolean ev_postable = false;
/*     */     
/* 121 */     if ((getDAO_().getCustAccountId() == null && argCustAccountId != null) || (
/* 122 */       getDAO_().getCustAccountId() != null && !getDAO_().getCustAccountId().equals(argCustAccountId))) {
/* 123 */       getDAO_().setCustAccountId(argCustAccountId);
/* 124 */       ev_postable = true;
/* 125 */       if (this._properties != null) {
/*     */         
/* 127 */         Iterator<EscrowAccountActivityPropertyModel> it = this._properties.iterator();
/* 128 */         while (it.hasNext())
/*     */         {
/* 130 */           ((EscrowAccountActivityPropertyModel)it.next()).setCustAccountId_noev(argCustAccountId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSeqNbr() {
/* 143 */     if (getDAO_().getSeqNbr() != null) {
/* 144 */       return getDAO_().getSeqNbr().longValue();
/*     */     }
/*     */     
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeqNbr(long argSeqNbr) {
/* 156 */     if (setSeqNbr_noev(argSeqNbr) && 
/* 157 */       this._events != null && 
/* 158 */       postEventsForChanges()) {
/* 159 */       this._events.post(IEscrowAccountActivity.SET_SEQNBR, Long.valueOf(argSeqNbr));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSeqNbr_noev(long argSeqNbr) {
/* 166 */     boolean ev_postable = false;
/*     */     
/* 168 */     if ((getDAO_().getSeqNbr() == null && Long.valueOf(argSeqNbr) != null) || (
/* 169 */       getDAO_().getSeqNbr() != null && !getDAO_().getSeqNbr().equals(Long.valueOf(argSeqNbr)))) {
/* 170 */       getDAO_().setSeqNbr(Long.valueOf(argSeqNbr));
/* 171 */       ev_postable = true;
/* 172 */       if (this._properties != null) {
/*     */         
/* 174 */         Iterator<EscrowAccountActivityPropertyModel> it = this._properties.iterator();
/* 175 */         while (it.hasNext())
/*     */         {
/* 177 */           ((EscrowAccountActivityPropertyModel)it.next()).setSeqNbr_noev(argSeqNbr);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/* 190 */     return getDAO_().getCreateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 198 */     if (setCreateDate_noev(argCreateDate) && 
/* 199 */       this._events != null && 
/* 200 */       postEventsForChanges()) {
/* 201 */       this._events.post(IEscrowAccountActivity.SET_CREATEDATE, argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateDate_noev(Date argCreateDate) {
/* 208 */     boolean ev_postable = false;
/*     */     
/* 210 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/* 211 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/* 212 */       getDAO_().setCreateDate(argCreateDate);
/* 213 */       ev_postable = true;
/*     */     } 
/*     */     
/* 216 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 224 */     return getDAO_().getCreateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 232 */     if (setCreateUserId_noev(argCreateUserId) && 
/* 233 */       this._events != null && 
/* 234 */       postEventsForChanges()) {
/* 235 */       this._events.post(IEscrowAccountActivity.SET_CREATEUSERID, argCreateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCreateUserId_noev(String argCreateUserId) {
/* 242 */     boolean ev_postable = false;
/*     */     
/* 244 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/* 245 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/* 246 */       getDAO_().setCreateUserId(argCreateUserId);
/* 247 */       ev_postable = true;
/*     */     } 
/*     */     
/* 250 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getUpdateDate() {
/* 258 */     return getDAO_().getUpdateDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 266 */     if (setUpdateDate_noev(argUpdateDate) && 
/* 267 */       this._events != null && 
/* 268 */       postEventsForChanges()) {
/* 269 */       this._events.post(IEscrowAccountActivity.SET_UPDATEDATE, argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/* 276 */     boolean ev_postable = false;
/*     */     
/* 278 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/* 279 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/* 280 */       getDAO_().setUpdateDate(argUpdateDate);
/* 281 */       ev_postable = true;
/*     */     } 
/*     */     
/* 284 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 292 */     return getDAO_().getUpdateUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 300 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/* 301 */       this._events != null && 
/* 302 */       postEventsForChanges()) {
/* 303 */       this._events.post(IEscrowAccountActivity.SET_UPDATEUSERID, argUpdateUserId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/* 310 */     boolean ev_postable = false;
/*     */     
/* 312 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/* 313 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/* 314 */       getDAO_().setUpdateUserId(argUpdateUserId);
/* 315 */       ev_postable = true;
/*     */     } 
/*     */     
/* 318 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getActivityDate() {
/* 326 */     return getDAO_().getActivityDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityDate(Date argActivityDate) {
/* 334 */     if (setActivityDate_noev(argActivityDate) && 
/* 335 */       this._events != null && 
/* 336 */       postEventsForChanges()) {
/* 337 */       this._events.post(IEscrowAccountActivity.SET_ACTIVITYDATE, argActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityDate_noev(Date argActivityDate) {
/* 344 */     boolean ev_postable = false;
/*     */     
/* 346 */     if ((getDAO_().getActivityDate() == null && argActivityDate != null) || (
/* 347 */       getDAO_().getActivityDate() != null && !getDAO_().getActivityDate().equals(argActivityDate))) {
/* 348 */       getDAO_().setActivityDate(argActivityDate);
/* 349 */       ev_postable = true;
/*     */     } 
/*     */     
/* 352 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActivityEnum() {
/* 360 */     return getDAO_().getActivityEnum();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActivityEnum(String argActivityEnum) {
/* 368 */     if (setActivityEnum_noev(argActivityEnum) && 
/* 369 */       this._events != null && 
/* 370 */       postEventsForChanges()) {
/* 371 */       this._events.post(IEscrowAccountActivity.SET_ACTIVITYENUM, argActivityEnum);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setActivityEnum_noev(String argActivityEnum) {
/* 378 */     boolean ev_postable = false;
/*     */     
/* 380 */     if ((getDAO_().getActivityEnum() == null && argActivityEnum != null) || (
/* 381 */       getDAO_().getActivityEnum() != null && !getDAO_().getActivityEnum().equals(argActivityEnum))) {
/* 382 */       getDAO_().setActivityEnum(argActivityEnum);
/* 383 */       ev_postable = true;
/*     */     } 
/*     */     
/* 386 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAmt() {
/* 394 */     return getDAO_().getAmt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAmt(BigDecimal argAmt) {
/* 402 */     if (setAmt_noev(argAmt) && 
/* 403 */       this._events != null && 
/* 404 */       postEventsForChanges()) {
/* 405 */       this._events.post(IEscrowAccountActivity.SET_AMT, argAmt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setAmt_noev(BigDecimal argAmt) {
/* 412 */     boolean ev_postable = false;
/*     */     
/* 414 */     if ((getDAO_().getAmt() == null && argAmt != null) || (
/* 415 */       getDAO_().getAmt() != null && !getDAO_().getAmt().equals(argAmt))) {
/* 416 */       getDAO_().setAmt(argAmt);
/* 417 */       ev_postable = true;
/*     */     } 
/*     */     
/* 420 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getBusinessDate() {
/* 428 */     return getDAO_().getBusinessDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/* 436 */     if (setBusinessDate_noev(argBusinessDate) && 
/* 437 */       this._events != null && 
/* 438 */       postEventsForChanges()) {
/* 439 */       this._events.post(IEscrowAccountActivity.SET_BUSINESSDATE, argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/* 446 */     boolean ev_postable = false;
/*     */     
/* 448 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/* 449 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/* 450 */       getDAO_().setBusinessDate(argBusinessDate);
/* 451 */       ev_postable = true;
/*     */     } 
/*     */     
/* 454 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTransactionSequence() {
/* 462 */     if (getDAO_().getTransactionSequence() != null) {
/* 463 */       return getDAO_().getTransactionSequence().longValue();
/*     */     }
/*     */     
/* 466 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionSequence(long argTransactionSequence) {
/* 475 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/* 476 */       this._events != null && 
/* 477 */       postEventsForChanges()) {
/* 478 */       this._events.post(IEscrowAccountActivity.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/* 485 */     boolean ev_postable = false;
/*     */     
/* 487 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/* 488 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/* 489 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/* 490 */       ev_postable = true;
/*     */     } 
/*     */     
/* 493 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWorkstationId() {
/* 501 */     if (getDAO_().getWorkstationId() != null) {
/* 502 */       return getDAO_().getWorkstationId().longValue();
/*     */     }
/*     */     
/* 505 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorkstationId(long argWorkstationId) {
/* 514 */     if (setWorkstationId_noev(argWorkstationId) && 
/* 515 */       this._events != null && 
/* 516 */       postEventsForChanges()) {
/* 517 */       this._events.post(IEscrowAccountActivity.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setWorkstationId_noev(long argWorkstationId) {
/* 524 */     boolean ev_postable = false;
/*     */     
/* 526 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/* 527 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/* 528 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/* 529 */       ev_postable = true;
/*     */     } 
/*     */     
/* 532 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/* 540 */     if (getDAO_().getRetailLocationId() != null) {
/* 541 */       return getDAO_().getRetailLocationId().longValue();
/*     */     }
/*     */     
/* 544 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 553 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/* 554 */       this._events != null && 
/* 555 */       postEventsForChanges()) {
/* 556 */       this._events.post(IEscrowAccountActivity.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/* 563 */     boolean ev_postable = false;
/*     */     
/* 565 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/* 566 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/* 567 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/* 568 */       ev_postable = true;
/*     */     } 
/*     */     
/* 571 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceCustAccountId() {
/* 579 */     return getDAO_().getSourceCustAccountId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceCustAccountId(String argSourceCustAccountId) {
/* 587 */     if (setSourceCustAccountId_noev(argSourceCustAccountId) && 
/* 588 */       this._events != null && 
/* 589 */       postEventsForChanges()) {
/* 590 */       this._events.post(IEscrowAccountActivity.SET_SOURCECUSTACCOUNTID, argSourceCustAccountId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSourceCustAccountId_noev(String argSourceCustAccountId) {
/* 597 */     boolean ev_postable = false;
/*     */     
/* 599 */     if ((getDAO_().getSourceCustAccountId() == null && argSourceCustAccountId != null) || (
/* 600 */       getDAO_().getSourceCustAccountId() != null && !getDAO_().getSourceCustAccountId().equals(argSourceCustAccountId))) {
/* 601 */       getDAO_().setSourceCustAccountId(argSourceCustAccountId);
/* 602 */       ev_postable = true;
/*     */     } 
/*     */     
/* 605 */     return ev_postable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceCustAccountCode() {
/* 613 */     return getDAO_().getSourceCustAccountCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceCustAccountCode(String argSourceCustAccountCode) {
/* 621 */     if (setSourceCustAccountCode_noev(argSourceCustAccountCode) && 
/* 622 */       this._events != null && 
/* 623 */       postEventsForChanges()) {
/* 624 */       this._events.post(IEscrowAccountActivity.SET_SOURCECUSTACCOUNTCODE, argSourceCustAccountCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setSourceCustAccountCode_noev(String argSourceCustAccountCode) {
/* 631 */     boolean ev_postable = false;
/*     */     
/* 633 */     if ((getDAO_().getSourceCustAccountCode() == null && argSourceCustAccountCode != null) || (
/* 634 */       getDAO_().getSourceCustAccountCode() != null && !getDAO_().getSourceCustAccountCode().equals(argSourceCustAccountCode))) {
/* 635 */       getDAO_().setSourceCustAccountCode(argSourceCustAccountCode);
/* 636 */       ev_postable = true;
/*     */     } 
/*     */     
/* 639 */     return ev_postable;
/*     */   }
/*     */   
/*     */   protected IEscrowAccountActivityProperty newProperty(String argPropertyName) {
/* 643 */     EscrowAccountActivityPropertyId id = new EscrowAccountActivityPropertyId();
/*     */     
/* 645 */     id.setCustAccountId(getCustAccountId());
/* 646 */     id.setSeqNbr(Long.valueOf(getSeqNbr()));
/* 647 */     id.setPropertyCode(argPropertyName);
/*     */     
/* 649 */     IEscrowAccountActivityProperty prop = (IEscrowAccountActivityProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IEscrowAccountActivityProperty.class);
/* 650 */     return prop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Relationship(name = "Properties")
/*     */   public List<IEscrowAccountActivityProperty> getProperties() {
/* 659 */     if (this._properties == null) {
/* 660 */       this._properties = new HistoricalList(null);
/*     */     }
/* 662 */     return (List<IEscrowAccountActivityProperty>)this._properties;
/*     */   }
/*     */   
/*     */   public void setProperties(List<IEscrowAccountActivityProperty> argProperties) {
/* 666 */     if (this._properties == null) {
/* 667 */       this._properties = new HistoricalList(argProperties);
/*     */     } else {
/* 669 */       this._properties.setCurrentList(argProperties);
/*     */     } 
/*     */     
/* 672 */     for (IEscrowAccountActivityProperty child : this._properties) {
/* 673 */       EscrowAccountActivityPropertyModel model = (EscrowAccountActivityPropertyModel)child;
/* 674 */       model.setOrganizationId_noev(getOrganizationId());
/* 675 */       model.setCustAccountId_noev(getCustAccountId());
/* 676 */       model.setSeqNbr_noev(getSeqNbr());
/* 677 */       if (child instanceof IDataModelImpl) {
/* 678 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 679 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 680 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 681 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */         }
/*     */       } 
/* 684 */       if (postEventsForChanges()) {
/* 685 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addEscrowAccountActivityProperty(IEscrowAccountActivityProperty argEscrowAccountActivityProperty) {
/* 691 */     if (this._properties == null) {
/* 692 */       this._properties = new HistoricalList(null);
/*     */     }
/* 694 */     argEscrowAccountActivityProperty.setOrganizationId(getOrganizationId());
/* 695 */     argEscrowAccountActivityProperty.setCustAccountId(getCustAccountId());
/* 696 */     argEscrowAccountActivityProperty.setSeqNbr(getSeqNbr());
/* 697 */     if (argEscrowAccountActivityProperty instanceof IDataModelImpl) {
/* 698 */       IDataAccessObject childDao = ((IDataModelImpl)argEscrowAccountActivityProperty).getDAO();
/* 699 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 700 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 701 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 706 */     if (postEventsForChanges()) {
/* 707 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountActivityProperty));
/*     */     }
/*     */     
/* 710 */     this._properties.add(argEscrowAccountActivityProperty);
/* 711 */     if (postEventsForChanges()) {
/* 712 */       this._events.post(IEscrowAccountActivity.ADD_PROPERTIES, argEscrowAccountActivityProperty);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEscrowAccountActivityProperty(IEscrowAccountActivityProperty argEscrowAccountActivityProperty) {
/* 717 */     if (this._properties != null) {
/*     */       
/* 719 */       if (postEventsForChanges()) {
/* 720 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argEscrowAccountActivityProperty));
/*     */       }
/* 722 */       this._properties.remove(argEscrowAccountActivityProperty);
/* 723 */       if (postEventsForChanges()) {
/* 724 */         this._events.post(IEscrowAccountActivity.REMOVE_PROPERTIES, argEscrowAccountActivityProperty);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldId) {
/* 731 */     if ("Properties".equals(argFieldId)) {
/* 732 */       return getProperties();
/*     */     }
/* 734 */     if ("EscrowAccountActivityExtension".equals(argFieldId)) {
/* 735 */       return this._myExtension;
/*     */     }
/*     */     
/* 738 */     return super.getValue(argFieldId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldId, Object argValue) {
/* 744 */     if ("Properties".equals(argFieldId)) {
/* 745 */       setProperties(changeToList(argValue, IEscrowAccountActivityProperty.class));
/*     */     }
/* 747 */     else if ("EscrowAccountActivityExtension".equals(argFieldId)) {
/* 748 */       this._myExtension = (IDataModel)argValue;
/*     */     } else {
/*     */       
/* 751 */       super.setValue(argFieldId, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 757 */     this._persistenceDefaults = argPD;
/* 758 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 759 */     this._eventManager = argEM;
/* 760 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 761 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 762 */     if (this._properties != null) {
/* 763 */       for (IEscrowAccountActivityProperty relationship : this._properties) {
/* 764 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataModel getEscrowAccountActivityExt() {
/* 770 */     return this._myExtension;
/*     */   }
/*     */   
/*     */   public void setEscrowAccountActivityExt(IDataModel argExt) {
/* 774 */     this._myExtension = argExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startTransaction() {
/* 779 */     if (this._alreadyInStart) {
/*     */       return;
/*     */     }
/*     */     
/* 783 */     this._alreadyInStart = true;
/*     */ 
/*     */     
/* 786 */     super.startTransaction();
/*     */     
/* 788 */     this._propertiesSavepoint = this._properties;
/* 789 */     if (this._properties != null) {
/* 790 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 791 */       Iterator<IDataModel> it = this._properties.iterator();
/* 792 */       while (it.hasNext()) {
/* 793 */         ((IDataModel)it.next()).startTransaction();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 798 */     this._alreadyInStart = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollbackChanges() {
/* 803 */     if (isAlreadyRolledBack()) {
/*     */       return;
/*     */     }
/* 806 */     super.rollbackChanges();
/*     */     
/* 808 */     this._properties = this._propertiesSavepoint;
/* 809 */     this._propertiesSavepoint = null;
/* 810 */     if (this._properties != null) {
/* 811 */       Iterator<IDataModel> it = this._properties.iterator();
/* 812 */       while (it.hasNext()) {
/* 813 */         ((IDataModel)it.next()).rollbackChanges();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitTransaction() {
/* 821 */     if (this._alreadyInCommit) {
/*     */       return;
/*     */     }
/* 824 */     this._alreadyInCommit = true;
/*     */ 
/*     */     
/* 827 */     super.commitTransaction();
/*     */     
/* 829 */     this._propertiesSavepoint = this._properties;
/* 830 */     if (this._properties != null) {
/* 831 */       Iterator<IDataModel> it = this._properties.iterator();
/* 832 */       while (it.hasNext()) {
/* 833 */         ((IDataModel)it.next()).commitTransaction();
/*     */       }
/* 835 */       this._properties = new HistoricalList((List)this._properties);
/*     */     } 
/*     */ 
/*     */     
/* 839 */     this._alreadyInCommit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 844 */     argStream.defaultReadObject();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountActivityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */