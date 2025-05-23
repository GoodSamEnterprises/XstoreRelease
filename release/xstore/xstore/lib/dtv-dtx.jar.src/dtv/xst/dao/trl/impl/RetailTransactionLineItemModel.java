/*      */ package dtv.xst.dao.trl.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.trl.ICorrectionModifier;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItemProperty;
/*      */ import dtv.xst.dao.trl.RetailTransactionLineItemPropertyId;
/*      */ import dtv.xst.dao.trn.IPosTransaction;
/*      */ import dtv.xst.dao.trn.LineItemGenericStorageId;
/*      */ import dtv.xst.dao.ttr.ITenderSignature;
/*      */ import dtv.xst.dao.ttr.impl.TenderSignatureModel;
/*      */ import dtv.xst.daocommon.ExchangeRateHelper;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class RetailTransactionLineItemModel extends AbstractDataModelWithPropertyImpl<IRetailTransactionLineItemProperty> implements IRetailTransactionLineItem {
/*      */   private static final long serialVersionUID = 1772623874L;
/*      */   private IPosTransaction _parentTransaction;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private ICorrectionModifier _correctionModifier; private transient ICorrectionModifier _correctionModifierSavepoint; private ITenderSignature _signature; private transient ITenderSignature _signatureSavepoint; private HistoricalList<IRetailTransactionLineItemProperty> _properties; private transient HistoricalList<IRetailTransactionLineItemProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new RetailTransactionLineItemDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private RetailTransactionLineItemDAO getDAO_() {
/*   50 */     return (RetailTransactionLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   58 */     if (getDAO_().getOrganizationId() != null) {
/*   59 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   62 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   71 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   72 */       this._events != null && 
/*   73 */       postEventsForChanges()) {
/*   74 */       this._events.post(IRetailTransactionLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   81 */     boolean ev_postable = false;
/*      */     
/*   83 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   84 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   85 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   86 */       ev_postable = true;
/*   87 */       if (this._properties != null) {
/*      */         
/*   89 */         Iterator<RetailTransactionLineItemPropertyModel> it = this._properties.iterator();
/*   90 */         while (it.hasNext())
/*      */         {
/*   92 */           ((RetailTransactionLineItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   95 */       if (this._correctionModifier != null)
/*      */       {
/*      */         
/*   98 */         ((CorrectionModifierModel)this._correctionModifier).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  100 */       if (this._signature != null)
/*      */       {
/*      */         
/*  103 */         ((TenderSignatureModel)this._signature).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */     
/*  107 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  115 */     if (getDAO_().getRetailLocationId() != null) {
/*  116 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  119 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  128 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  129 */       this._events != null && 
/*  130 */       postEventsForChanges()) {
/*  131 */       this._events.post(IRetailTransactionLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  138 */     boolean ev_postable = false;
/*      */     
/*  140 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  141 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  142 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  143 */       ev_postable = true;
/*  144 */       if (this._properties != null) {
/*      */         
/*  146 */         Iterator<RetailTransactionLineItemPropertyModel> it = this._properties.iterator();
/*  147 */         while (it.hasNext())
/*      */         {
/*  149 */           ((RetailTransactionLineItemPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  152 */       if (this._correctionModifier != null)
/*      */       {
/*      */         
/*  155 */         ((CorrectionModifierModel)this._correctionModifier).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*  157 */       if (this._signature != null)
/*      */       {
/*      */         
/*  160 */         ((TenderSignatureModel)this._signature).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */     
/*  164 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  172 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  180 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  181 */       this._events != null && 
/*  182 */       postEventsForChanges()) {
/*  183 */       this._events.post(IRetailTransactionLineItem.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  190 */     boolean ev_postable = false;
/*      */     
/*  192 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  193 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  194 */       getDAO_().setBusinessDate(argBusinessDate);
/*  195 */       ev_postable = true;
/*  196 */       if (this._properties != null) {
/*      */         
/*  198 */         Iterator<RetailTransactionLineItemPropertyModel> it = this._properties.iterator();
/*  199 */         while (it.hasNext())
/*      */         {
/*  201 */           ((RetailTransactionLineItemPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  204 */       if (this._correctionModifier != null)
/*      */       {
/*      */         
/*  207 */         ((CorrectionModifierModel)this._correctionModifier).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*  209 */       if (this._signature != null)
/*      */       {
/*      */         
/*  212 */         ((TenderSignatureModel)this._signature).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*      */     } 
/*      */     
/*  216 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  224 */     if (getDAO_().getWorkstationId() != null) {
/*  225 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  228 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  237 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  238 */       this._events != null && 
/*  239 */       postEventsForChanges()) {
/*  240 */       this._events.post(IRetailTransactionLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  247 */     boolean ev_postable = false;
/*      */     
/*  249 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  250 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  251 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  252 */       ev_postable = true;
/*  253 */       if (this._properties != null) {
/*      */         
/*  255 */         Iterator<RetailTransactionLineItemPropertyModel> it = this._properties.iterator();
/*  256 */         while (it.hasNext())
/*      */         {
/*  258 */           ((RetailTransactionLineItemPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  261 */       if (this._correctionModifier != null)
/*      */       {
/*      */         
/*  264 */         ((CorrectionModifierModel)this._correctionModifier).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*  266 */       if (this._signature != null)
/*      */       {
/*      */         
/*  269 */         ((TenderSignatureModel)this._signature).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*      */     } 
/*      */     
/*  273 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  281 */     if (getDAO_().getTransactionSequence() != null) {
/*  282 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  285 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  294 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  295 */       this._events != null && 
/*  296 */       postEventsForChanges()) {
/*  297 */       this._events.post(IRetailTransactionLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  304 */     boolean ev_postable = false;
/*      */     
/*  306 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  307 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  308 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  309 */       ev_postable = true;
/*  310 */       if (this._properties != null) {
/*      */         
/*  312 */         Iterator<RetailTransactionLineItemPropertyModel> it = this._properties.iterator();
/*  313 */         while (it.hasNext())
/*      */         {
/*  315 */           ((RetailTransactionLineItemPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  318 */       if (this._correctionModifier != null)
/*      */       {
/*      */         
/*  321 */         ((CorrectionModifierModel)this._correctionModifier).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*  323 */       if (this._signature != null)
/*      */       {
/*      */         
/*  326 */         ((TenderSignatureModel)this._signature).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*      */     } 
/*      */     
/*  330 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  338 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  339 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  342 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  351 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  352 */       this._events != null && 
/*  353 */       postEventsForChanges()) {
/*  354 */       this._events.post(IRetailTransactionLineItem.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  361 */     boolean ev_postable = false;
/*      */     
/*  363 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  364 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  365 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  366 */       ev_postable = true;
/*  367 */       if (this._properties != null) {
/*      */         
/*  369 */         Iterator<RetailTransactionLineItemPropertyModel> it = this._properties.iterator();
/*  370 */         while (it.hasNext())
/*      */         {
/*  372 */           ((RetailTransactionLineItemPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  375 */       if (this._correctionModifier != null)
/*      */       {
/*      */         
/*  378 */         ((CorrectionModifierModel)this._correctionModifier).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*  380 */       if (this._signature != null)
/*      */       {
/*      */         
/*  383 */         ((TenderSignatureModel)this._signature).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*      */     } 
/*      */     
/*  387 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getClassName() {
/*  395 */     return getDAO_().getClassName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClassName(String argClassName) {
/*  403 */     if (setClassName_noev(argClassName) && 
/*  404 */       this._events != null && 
/*  405 */       postEventsForChanges()) {
/*  406 */       this._events.post(IRetailTransactionLineItem.SET_CLASSNAME, argClassName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClassName_noev(String argClassName) {
/*  413 */     boolean ev_postable = false;
/*      */     
/*  415 */     if ((getDAO_().getClassName() == null && argClassName != null) || (
/*  416 */       getDAO_().getClassName() != null && !getDAO_().getClassName().equals(argClassName))) {
/*  417 */       getDAO_().setClassName(argClassName);
/*  418 */       ev_postable = true;
/*      */     } 
/*      */     
/*  421 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  429 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  437 */     if (setCreateDate_noev(argCreateDate) && 
/*  438 */       this._events != null && 
/*  439 */       postEventsForChanges()) {
/*  440 */       this._events.post(IRetailTransactionLineItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  447 */     boolean ev_postable = false;
/*      */     
/*  449 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  450 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  451 */       getDAO_().setCreateDate(argCreateDate);
/*  452 */       ev_postable = true;
/*      */     } 
/*      */     
/*  455 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  463 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  471 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  472 */       this._events != null && 
/*  473 */       postEventsForChanges()) {
/*  474 */       this._events.post(IRetailTransactionLineItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  481 */     boolean ev_postable = false;
/*      */     
/*  483 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  484 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  485 */       getDAO_().setCreateUserId(argCreateUserId);
/*  486 */       ev_postable = true;
/*      */     } 
/*      */     
/*  489 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  497 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  505 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  506 */       this._events != null && 
/*  507 */       postEventsForChanges()) {
/*  508 */       this._events.post(IRetailTransactionLineItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  515 */     boolean ev_postable = false;
/*      */     
/*  517 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  518 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  519 */       getDAO_().setUpdateDate(argUpdateDate);
/*  520 */       ev_postable = true;
/*      */     } 
/*      */     
/*  523 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  531 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  539 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  540 */       this._events != null && 
/*  541 */       postEventsForChanges()) {
/*  542 */       this._events.post(IRetailTransactionLineItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  549 */     boolean ev_postable = false;
/*      */     
/*  551 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  552 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  553 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  554 */       ev_postable = true;
/*      */     } 
/*      */     
/*  557 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBeginDateTimestamp() {
/*  565 */     return getDAO_().getBeginDateTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeginDateTimestamp(Date argBeginDateTimestamp) {
/*  573 */     if (setBeginDateTimestamp_noev(argBeginDateTimestamp) && 
/*  574 */       this._events != null && 
/*  575 */       postEventsForChanges()) {
/*  576 */       this._events.post(IRetailTransactionLineItem.SET_BEGINDATETIMESTAMP, argBeginDateTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBeginDateTimestamp_noev(Date argBeginDateTimestamp) {
/*  583 */     boolean ev_postable = false;
/*      */     
/*  585 */     if ((getDAO_().getBeginDateTimestamp() == null && argBeginDateTimestamp != null) || (
/*  586 */       getDAO_().getBeginDateTimestamp() != null && !getDAO_().getBeginDateTimestamp().equals(argBeginDateTimestamp))) {
/*  587 */       getDAO_().setBeginDateTimestamp(argBeginDateTimestamp);
/*  588 */       ev_postable = true;
/*      */     } 
/*      */     
/*  591 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getEndDateTimestamp() {
/*  599 */     return getDAO_().getEndDateTimestamp();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEndDateTimestamp(Date argEndDateTimestamp) {
/*  607 */     if (setEndDateTimestamp_noev(argEndDateTimestamp) && 
/*  608 */       this._events != null && 
/*  609 */       postEventsForChanges()) {
/*  610 */       this._events.post(IRetailTransactionLineItem.SET_ENDDATETIMESTAMP, argEndDateTimestamp);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEndDateTimestamp_noev(Date argEndDateTimestamp) {
/*  617 */     boolean ev_postable = false;
/*      */     
/*  619 */     if ((getDAO_().getEndDateTimestamp() == null && argEndDateTimestamp != null) || (
/*  620 */       getDAO_().getEndDateTimestamp() != null && !getDAO_().getEndDateTimestamp().equals(argEndDateTimestamp))) {
/*  621 */       getDAO_().setEndDateTimestamp(argEndDateTimestamp);
/*  622 */       ev_postable = true;
/*      */     } 
/*      */     
/*  625 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLineItemStatusCode() {
/*  633 */     return getDAO_().getLineItemStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemStatusCode(String argLineItemStatusCode) {
/*  641 */     if (setLineItemStatusCode_noev(argLineItemStatusCode) && 
/*  642 */       this._events != null && 
/*  643 */       postEventsForChanges()) {
/*  644 */       this._events.post(IRetailTransactionLineItem.SET_LINEITEMSTATUSCODE, argLineItemStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemStatusCode_noev(String argLineItemStatusCode) {
/*  651 */     boolean ev_postable = false;
/*      */     
/*  653 */     if ((getDAO_().getLineItemStatusCode() == null && argLineItemStatusCode != null) || (
/*  654 */       getDAO_().getLineItemStatusCode() != null && !getDAO_().getLineItemStatusCode().equals(argLineItemStatusCode))) {
/*  655 */       getDAO_().setLineItemStatusCode(argLineItemStatusCode);
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
/*      */   public String getLineItemTypeCode() {
/*  667 */     return getDAO_().getLineItemTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemTypeCode(String argLineItemTypeCode) {
/*  675 */     if (setLineItemTypeCode_noev(argLineItemTypeCode) && 
/*  676 */       this._events != null && 
/*  677 */       postEventsForChanges()) {
/*  678 */       this._events.post(IRetailTransactionLineItem.SET_LINEITEMTYPECODE, argLineItemTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemTypeCode_noev(String argLineItemTypeCode) {
/*  685 */     boolean ev_postable = false;
/*      */     
/*  687 */     if ((getDAO_().getLineItemTypeCode() == null && argLineItemTypeCode != null) || (
/*  688 */       getDAO_().getLineItemTypeCode() != null && !getDAO_().getLineItemTypeCode().equals(argLineItemTypeCode))) {
/*  689 */       getDAO_().setLineItemTypeCode(argLineItemTypeCode);
/*  690 */       ev_postable = true;
/*      */     } 
/*      */     
/*  693 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNotes() {
/*  701 */     return getDAO_().getNotes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotes(String argNotes) {
/*  709 */     if (setNotes_noev(argNotes) && 
/*  710 */       this._events != null && 
/*  711 */       postEventsForChanges()) {
/*  712 */       this._events.post(IRetailTransactionLineItem.SET_NOTES, argNotes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotes_noev(String argNotes) {
/*  719 */     boolean ev_postable = false;
/*      */     
/*  721 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/*  722 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/*  723 */       getDAO_().setNotes(argNotes);
/*  724 */       ev_postable = true;
/*      */     } 
/*      */     
/*  727 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getVoidLineItemReasonCodeImpl() {
/*  735 */     return getDAO_().getVoidLineItemReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoidLineItemReasonCode(String argVoidLineItemReasonCode) {
/*  743 */     if (setVoidLineItemReasonCode_noev(argVoidLineItemReasonCode) && 
/*  744 */       this._events != null && 
/*  745 */       postEventsForChanges()) {
/*  746 */       this._events.post(IRetailTransactionLineItem.SET_VOIDLINEITEMREASONCODE, argVoidLineItemReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoidLineItemReasonCode_noev(String argVoidLineItemReasonCode) {
/*  753 */     boolean ev_postable = false;
/*      */     
/*  755 */     if ((getDAO_().getVoidLineItemReasonCode() == null && argVoidLineItemReasonCode != null) || (
/*  756 */       getDAO_().getVoidLineItemReasonCode() != null && !getDAO_().getVoidLineItemReasonCode().equals(argVoidLineItemReasonCode))) {
/*  757 */       getDAO_().setVoidLineItemReasonCode(argVoidLineItemReasonCode);
/*  758 */       ev_postable = true;
/*      */     } 
/*      */     
/*  761 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/*  769 */     if (getDAO_().getVoid() != null) {
/*  770 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/*  773 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/*  782 */     if (setVoid_noev(argVoid) && 
/*  783 */       this._events != null && 
/*  784 */       postEventsForChanges()) {
/*  785 */       this._events.post(IRetailTransactionLineItem.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  792 */     boolean ev_postable = false;
/*      */     
/*  794 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  795 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  796 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/*  797 */       ev_postable = true;
/*      */     } 
/*      */     
/*  800 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getGenericStorage() {
/*  808 */     if (getDAO_().getGenericStorage() != null) {
/*  809 */       return getDAO_().getGenericStorage().booleanValue();
/*      */     }
/*      */     
/*  812 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGenericStorage(boolean argGenericStorage) {
/*  821 */     if (setGenericStorage_noev(argGenericStorage) && 
/*  822 */       this._events != null && 
/*  823 */       postEventsForChanges()) {
/*  824 */       this._events.post(IRetailTransactionLineItem.SET_GENERICSTORAGE, Boolean.valueOf(argGenericStorage));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGenericStorage_noev(boolean argGenericStorage) {
/*  831 */     boolean ev_postable = false;
/*      */     
/*  833 */     if ((getDAO_().getGenericStorage() == null && Boolean.valueOf(argGenericStorage) != null) || (
/*  834 */       getDAO_().getGenericStorage() != null && !getDAO_().getGenericStorage().equals(Boolean.valueOf(argGenericStorage)))) {
/*  835 */       getDAO_().setGenericStorage(Boolean.valueOf(argGenericStorage));
/*  836 */       ev_postable = true;
/*      */     } 
/*      */     
/*  839 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getTLogSequenceImpl() {
/*  847 */     if (getDAO_().getTLogSequence() != null) {
/*  848 */       return getDAO_().getTLogSequence().intValue();
/*      */     }
/*      */     
/*  851 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTLogSequence(int argTLogSequence) {
/*  860 */     if (setTLogSequence_noev(argTLogSequence) && 
/*  861 */       this._events != null && 
/*  862 */       postEventsForChanges()) {
/*  863 */       this._events.post(IRetailTransactionLineItem.SET_TLOGSEQUENCE, Integer.valueOf(argTLogSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTLogSequence_noev(int argTLogSequence) {
/*  870 */     boolean ev_postable = false;
/*      */     
/*  872 */     if ((getDAO_().getTLogSequence() == null && Integer.valueOf(argTLogSequence) != null) || (
/*  873 */       getDAO_().getTLogSequence() != null && !getDAO_().getTLogSequence().equals(Integer.valueOf(argTLogSequence)))) {
/*  874 */       getDAO_().setTLogSequence(Integer.valueOf(argTLogSequence));
/*  875 */       ev_postable = true;
/*      */     } 
/*      */     
/*  878 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getCurrencyIdImpl() {
/*  886 */     return getDAO_().getCurrencyId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCurrencyId(String argCurrencyId) {
/*  894 */     if (setCurrencyId_noev(argCurrencyId) && 
/*  895 */       this._events != null && 
/*  896 */       postEventsForChanges()) {
/*  897 */       this._events.post(IRetailTransactionLineItem.SET_CURRENCYID, argCurrencyId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCurrencyId_noev(String argCurrencyId) {
/*  904 */     boolean ev_postable = false;
/*      */     
/*  906 */     if ((getDAO_().getCurrencyId() == null && argCurrencyId != null) || (
/*  907 */       getDAO_().getCurrencyId() != null && !getDAO_().getCurrencyId().equals(argCurrencyId))) {
/*  908 */       getDAO_().setCurrencyId(argCurrencyId);
/*  909 */       ev_postable = true;
/*      */     } 
/*      */     
/*  912 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IRetailTransactionLineItemProperty newProperty(String argPropertyName) {
/*  916 */     RetailTransactionLineItemPropertyId id = new RetailTransactionLineItemPropertyId();
/*      */     
/*  918 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  919 */     id.setBusinessDate(getBusinessDate());
/*  920 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  921 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  922 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/*  923 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  925 */     IRetailTransactionLineItemProperty prop = (IRetailTransactionLineItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IRetailTransactionLineItemProperty.class);
/*  926 */     return prop;
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
/*      */   @Relationship(name = "CorrectionModifier")
/*      */   public ICorrectionModifier getCorrectionModifier() {
/*  941 */     return this._correctionModifier;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCorrectionModifier(ICorrectionModifier argCorrectionModifier) {
/*  946 */     if (argCorrectionModifier == null) {
/*      */       
/*  948 */       if (this._correctionModifier != null) {
/*  949 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*  951 */       if (this._correctionModifier != null) {
/*      */         
/*  953 */         if (postEventsForChanges()) {
/*  954 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._correctionModifier));
/*      */         }
/*  956 */         addDeletedObject((IDataModel)this._correctionModifier);
/*      */       } 
/*      */     } else {
/*      */       
/*  960 */       argCorrectionModifier.setBusinessDate(getBusinessDate());
/*  961 */       argCorrectionModifier.setOrganizationId(getOrganizationId());
/*  962 */       argCorrectionModifier.setRetailLocationId(getRetailLocationId());
/*  963 */       argCorrectionModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  964 */       argCorrectionModifier.setTransactionSequence(getTransactionSequence());
/*  965 */       argCorrectionModifier.setWorkstationId(getWorkstationId());
/*      */ 
/*      */       
/*  968 */       argCorrectionModifier.setParentLine(this);
/*      */ 
/*      */       
/*  971 */       if (postEventsForChanges()) {
/*  972 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCorrectionModifier));
/*      */       }
/*      */     } 
/*      */     
/*  976 */     this._correctionModifier = argCorrectionModifier;
/*  977 */     if (postEventsForChanges()) {
/*  978 */       this._events.post(IRetailTransactionLineItem.SET_CORRECTIONMODIFIER, argCorrectionModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Signature")
/*      */   public ITenderSignature getSignature() {
/*  984 */     return this._signature;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSignature(ITenderSignature argSignature) {
/*  989 */     if (argSignature == null) {
/*      */       
/*  991 */       if (this._signature != null) {
/*  992 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*  994 */       if (this._signature != null) {
/*      */         
/*  996 */         if (postEventsForChanges()) {
/*  997 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._signature));
/*      */         }
/*  999 */         addDeletedObject((IDataModel)this._signature);
/*      */       } 
/*      */     } else {
/*      */       
/* 1003 */       argSignature.setOrganizationId(getOrganizationId());
/* 1004 */       argSignature.setRetailLocationId(getRetailLocationId());
/* 1005 */       argSignature.setBusinessDate(getBusinessDate());
/* 1006 */       argSignature.setWorkstationId(getWorkstationId());
/* 1007 */       argSignature.setTransactionSequence(getTransactionSequence());
/* 1008 */       argSignature.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*      */ 
/*      */       
/* 1011 */       if (postEventsForChanges()) {
/* 1012 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSignature));
/*      */       }
/*      */     } 
/*      */     
/* 1016 */     this._signature = argSignature;
/* 1017 */     if (postEventsForChanges()) {
/* 1018 */       this._events.post(IRetailTransactionLineItem.SET_SIGNATURE, argSignature);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IRetailTransactionLineItemProperty> getProperties() {
/* 1024 */     if (this._properties == null) {
/* 1025 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1027 */     return (List<IRetailTransactionLineItemProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IRetailTransactionLineItemProperty> argProperties) {
/* 1031 */     if (this._properties == null) {
/* 1032 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1034 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1037 */     for (IRetailTransactionLineItemProperty child : this._properties) {
/* 1038 */       RetailTransactionLineItemPropertyModel model = (RetailTransactionLineItemPropertyModel)child;
/* 1039 */       model.setOrganizationId_noev(getOrganizationId());
/* 1040 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 1041 */       model.setBusinessDate_noev(getBusinessDate());
/* 1042 */       model.setWorkstationId_noev(getWorkstationId());
/* 1043 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 1044 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 1045 */       if (child instanceof IDataModelImpl) {
/* 1046 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1047 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1048 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1049 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1052 */       if (postEventsForChanges()) {
/* 1053 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addRetailTransactionLineItemProperty(IRetailTransactionLineItemProperty argRetailTransactionLineItemProperty) {
/* 1059 */     if (this._properties == null) {
/* 1060 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1062 */     argRetailTransactionLineItemProperty.setOrganizationId(getOrganizationId());
/* 1063 */     argRetailTransactionLineItemProperty.setRetailLocationId(getRetailLocationId());
/* 1064 */     argRetailTransactionLineItemProperty.setBusinessDate(getBusinessDate());
/* 1065 */     argRetailTransactionLineItemProperty.setWorkstationId(getWorkstationId());
/* 1066 */     argRetailTransactionLineItemProperty.setTransactionSequence(getTransactionSequence());
/* 1067 */     argRetailTransactionLineItemProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 1068 */     if (argRetailTransactionLineItemProperty instanceof IDataModelImpl) {
/* 1069 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailTransactionLineItemProperty).getDAO();
/* 1070 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1071 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1072 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1077 */     if (postEventsForChanges()) {
/* 1078 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItemProperty));
/*      */     }
/*      */     
/* 1081 */     this._properties.add(argRetailTransactionLineItemProperty);
/* 1082 */     if (postEventsForChanges()) {
/* 1083 */       this._events.post(IRetailTransactionLineItem.ADD_PROPERTIES, argRetailTransactionLineItemProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailTransactionLineItemProperty(IRetailTransactionLineItemProperty argRetailTransactionLineItemProperty) {
/* 1088 */     if (this._properties != null) {
/*      */       
/* 1090 */       if (postEventsForChanges()) {
/* 1091 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItemProperty));
/*      */       }
/* 1093 */       this._properties.remove(argRetailTransactionLineItemProperty);
/* 1094 */       if (postEventsForChanges()) {
/* 1095 */         this._events.post(IRetailTransactionLineItem.REMOVE_PROPERTIES, argRetailTransactionLineItemProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentTransaction(IPosTransaction argParentTransaction) {
/* 1101 */     this._parentTransaction = argParentTransaction;
/*      */   }
/*      */   
/*      */   public IPosTransaction getParentTransaction() {
/* 1105 */     return this._parentTransaction;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1110 */     if ("CorrectionModifier".equals(argFieldId)) {
/* 1111 */       return getCorrectionModifier();
/*      */     }
/* 1113 */     if ("Signature".equals(argFieldId)) {
/* 1114 */       return getSignature();
/*      */     }
/* 1116 */     if ("Properties".equals(argFieldId)) {
/* 1117 */       return getProperties();
/*      */     }
/* 1119 */     if ("RetailTransactionLineItemExtension".equals(argFieldId)) {
/* 1120 */       return this._myExtension;
/*      */     }
/*      */     
/* 1123 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1129 */     if ("CorrectionModifier".equals(argFieldId)) {
/* 1130 */       setCorrectionModifier((ICorrectionModifier)argValue);
/*      */     }
/* 1132 */     else if ("Signature".equals(argFieldId)) {
/* 1133 */       setSignature((ITenderSignature)argValue);
/*      */     }
/* 1135 */     else if ("Properties".equals(argFieldId)) {
/* 1136 */       setProperties(changeToList(argValue, IRetailTransactionLineItemProperty.class));
/*      */     }
/* 1138 */     else if ("RetailTransactionLineItemExtension".equals(argFieldId)) {
/* 1139 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1142 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1148 */     this._persistenceDefaults = argPD;
/* 1149 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1150 */     this._eventManager = argEM;
/* 1151 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1152 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1153 */     if (this._correctionModifier != null) {
/* 1154 */       ((IDataModelImpl)this._correctionModifier).setDependencies(argPD, argEM);
/*      */     }
/* 1156 */     if (this._signature != null) {
/* 1157 */       ((IDataModelImpl)this._signature).setDependencies(argPD, argEM);
/*      */     }
/* 1159 */     if (this._properties != null) {
/* 1160 */       for (IRetailTransactionLineItemProperty relationship : this._properties) {
/* 1161 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getRetailTransactionLineItemExt() {
/* 1167 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setRetailTransactionLineItemExt(IDataModel argExt) {
/* 1171 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1176 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1180 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1183 */     super.startTransaction();
/*      */     
/* 1185 */     this._correctionModifierSavepoint = this._correctionModifier;
/* 1186 */     if (this._correctionModifier != null) {
/* 1187 */       this._correctionModifier.startTransaction();
/*      */     }
/*      */     
/* 1190 */     this._signatureSavepoint = this._signature;
/* 1191 */     if (this._signature != null) {
/* 1192 */       this._signature.startTransaction();
/*      */     }
/*      */     
/* 1195 */     this._propertiesSavepoint = this._properties;
/* 1196 */     if (this._properties != null) {
/* 1197 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1198 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1199 */       while (it.hasNext()) {
/* 1200 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1205 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1210 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1213 */     super.rollbackChanges();
/*      */     
/* 1215 */     this._correctionModifier = this._correctionModifierSavepoint;
/* 1216 */     this._correctionModifierSavepoint = null;
/* 1217 */     if (this._correctionModifier != null) {
/* 1218 */       this._correctionModifier.rollbackChanges();
/*      */     }
/*      */     
/* 1221 */     this._signature = this._signatureSavepoint;
/* 1222 */     this._signatureSavepoint = null;
/* 1223 */     if (this._signature != null) {
/* 1224 */       this._signature.rollbackChanges();
/*      */     }
/*      */     
/* 1227 */     this._properties = this._propertiesSavepoint;
/* 1228 */     this._propertiesSavepoint = null;
/* 1229 */     if (this._properties != null) {
/* 1230 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1231 */       while (it.hasNext()) {
/* 1232 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1240 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1243 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1246 */     super.commitTransaction();
/*      */     
/* 1248 */     this._correctionModifierSavepoint = this._correctionModifier;
/* 1249 */     if (this._correctionModifier != null) {
/* 1250 */       this._correctionModifier.commitTransaction();
/*      */     }
/*      */     
/* 1253 */     this._signatureSavepoint = this._signature;
/* 1254 */     if (this._signature != null) {
/* 1255 */       this._signature.commitTransaction();
/*      */     }
/*      */     
/* 1258 */     this._propertiesSavepoint = this._properties;
/* 1259 */     if (this._properties != null) {
/* 1260 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1261 */       while (it.hasNext()) {
/* 1262 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1264 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1268 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1273 */     argStream.defaultReadObject();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient boolean _signatureCaptureSkipped = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVoidLineItemReasonCode() {
/* 1290 */     return getVoid() ? getVoidLineItemReasonCodeImpl() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCurrencyId() {
/* 1297 */     if (getDAO_().getCurrencyId() == null) {
/* 1298 */       if (getPersistenceDefaults() != null) {
/* 1299 */         getDAO_().setCurrencyId(getPersistenceDefaults().getCurrencyId());
/*      */       } else {
/*      */         
/* 1302 */         return null;
/*      */       } 
/*      */     }
/*      */     
/* 1306 */     return getDAO_().getCurrencyId();
/*      */   }
/*      */   
/*      */   public LineItemGenericStorageId getLineItemGenericStorageId() {
/* 1310 */     return new LineItemGenericStorageId(getObjectId().toString());
/*      */   }
/*      */   
/*      */   public boolean getSignatureCaptureSkipped() {
/* 1314 */     return this._signatureCaptureSkipped;
/*      */   }
/*      */   
/*      */   public void setSignatureCaptureSkipped(boolean argSignatureCaptureSkipped) {
/* 1318 */     this._signatureCaptureSkipped = argSignatureCaptureSkipped;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTLogSequence() {
/* 1325 */     int tlogSequence = getTLogSequenceImpl();
/* 1326 */     return (tlogSequence > 0 || tlogSequence == Integer.MIN_VALUE) ? tlogSequence : 
/*      */       
/* 1328 */       getRetailTransactionLineItemSequence();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getLocalizedAmount(BigDecimal argAmount) {
/* 1337 */     return ExchangeRateHelper.getLocalizedAmount(argAmount, getCurrencyId(), getPersistenceDefaults().getCurrencyId(), this._persistenceDefaults.getRetailLocationId().intValue());
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getRelativeAmount(BigDecimal argAmount) {
/* 1342 */     return ExchangeRateHelper.getRelativeAmount(argAmount, getCurrencyId(), getPersistenceDefaults().getCurrencyId(), this._persistenceDefaults.getRetailLocationId().intValue());
/*      */   }
/*      */   
/*      */   public Date getTransactionDate() {
/* 1346 */     IPosTransaction parent = getParentTransaction();
/* 1347 */     if (parent == null) {
/* 1348 */       return null;
/*      */     }
/* 1350 */     return parent.getTransactionDate();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */