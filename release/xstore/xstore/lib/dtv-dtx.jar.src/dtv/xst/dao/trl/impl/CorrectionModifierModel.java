/*      */ package dtv.xst.dao.trl.impl;
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
/*      */ import dtv.xst.dao.trl.CorrectionModifierPropertyId;
/*      */ import dtv.xst.dao.trl.ICorrectionModifier;
/*      */ import dtv.xst.dao.trl.ICorrectionModifierProperty;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class CorrectionModifierModel extends AbstractDataModelWithPropertyImpl<ICorrectionModifierProperty> implements ICorrectionModifier {
/*      */   private static final long serialVersionUID = 1247937653L;
/*      */   private IRetailTransactionLineItem _parentLine;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<ICorrectionModifierProperty> _properties; private transient HistoricalList<ICorrectionModifierProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new CorrectionModifierDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CorrectionModifierDAO getDAO_() {
/*   48 */     return (CorrectionModifierDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*   56 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*   64 */     if (setBusinessDate_noev(argBusinessDate) && 
/*   65 */       this._events != null && 
/*   66 */       postEventsForChanges()) {
/*   67 */       this._events.post(ICorrectionModifier.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*   74 */     boolean ev_postable = false;
/*      */     
/*   76 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*   77 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*   78 */       getDAO_().setBusinessDate(argBusinessDate);
/*   79 */       ev_postable = true;
/*   80 */       if (this._properties != null) {
/*      */         
/*   82 */         Iterator<CorrectionModifierPropertyModel> it = this._properties.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((CorrectionModifierPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   90 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   98 */     if (getDAO_().getOrganizationId() != null) {
/*   99 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*  102 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*  111 */     if (setOrganizationId_noev(argOrganizationId) && 
/*  112 */       this._events != null && 
/*  113 */       postEventsForChanges()) {
/*  114 */       this._events.post(ICorrectionModifier.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*  121 */     boolean ev_postable = false;
/*      */     
/*  123 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*  124 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*  125 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*  126 */       ev_postable = true;
/*  127 */       if (this._properties != null) {
/*      */         
/*  129 */         Iterator<CorrectionModifierPropertyModel> it = this._properties.iterator();
/*  130 */         while (it.hasNext())
/*      */         {
/*  132 */           ((CorrectionModifierPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  137 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  145 */     if (getDAO_().getRetailLocationId() != null) {
/*  146 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  149 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  158 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  159 */       this._events != null && 
/*  160 */       postEventsForChanges()) {
/*  161 */       this._events.post(ICorrectionModifier.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  168 */     boolean ev_postable = false;
/*      */     
/*  170 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  171 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  172 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  173 */       ev_postable = true;
/*  174 */       if (this._properties != null) {
/*      */         
/*  176 */         Iterator<CorrectionModifierPropertyModel> it = this._properties.iterator();
/*  177 */         while (it.hasNext())
/*      */         {
/*  179 */           ((CorrectionModifierPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  184 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  192 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  193 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  196 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  205 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  206 */       this._events != null && 
/*  207 */       postEventsForChanges()) {
/*  208 */       this._events.post(ICorrectionModifier.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  215 */     boolean ev_postable = false;
/*      */     
/*  217 */     if ((getDAO_().getRetailTransactionLineItemSequence() == null && Integer.valueOf(argRetailTransactionLineItemSequence) != null) || (
/*  218 */       getDAO_().getRetailTransactionLineItemSequence() != null && !getDAO_().getRetailTransactionLineItemSequence().equals(Integer.valueOf(argRetailTransactionLineItemSequence)))) {
/*  219 */       getDAO_().setRetailTransactionLineItemSequence(Integer.valueOf(argRetailTransactionLineItemSequence));
/*  220 */       ev_postable = true;
/*  221 */       if (this._properties != null) {
/*      */         
/*  223 */         Iterator<CorrectionModifierPropertyModel> it = this._properties.iterator();
/*  224 */         while (it.hasNext())
/*      */         {
/*  226 */           ((CorrectionModifierPropertyModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  231 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  239 */     if (getDAO_().getTransactionSequence() != null) {
/*  240 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  243 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  252 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  253 */       this._events != null && 
/*  254 */       postEventsForChanges()) {
/*  255 */       this._events.post(ICorrectionModifier.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  262 */     boolean ev_postable = false;
/*      */     
/*  264 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  265 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  266 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  267 */       ev_postable = true;
/*  268 */       if (this._properties != null) {
/*      */         
/*  270 */         Iterator<CorrectionModifierPropertyModel> it = this._properties.iterator();
/*  271 */         while (it.hasNext())
/*      */         {
/*  273 */           ((CorrectionModifierPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  278 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  286 */     if (getDAO_().getWorkstationId() != null) {
/*  287 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  290 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  299 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  300 */       this._events != null && 
/*  301 */       postEventsForChanges()) {
/*  302 */       this._events.post(ICorrectionModifier.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  309 */     boolean ev_postable = false;
/*      */     
/*  311 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  312 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  313 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  314 */       ev_postable = true;
/*  315 */       if (this._properties != null) {
/*      */         
/*  317 */         Iterator<CorrectionModifierPropertyModel> it = this._properties.iterator();
/*  318 */         while (it.hasNext())
/*      */         {
/*  320 */           ((CorrectionModifierPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  325 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  333 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  341 */     if (setCreateDate_noev(argCreateDate) && 
/*  342 */       this._events != null && 
/*  343 */       postEventsForChanges()) {
/*  344 */       this._events.post(ICorrectionModifier.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  351 */     boolean ev_postable = false;
/*      */     
/*  353 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  354 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  355 */       getDAO_().setCreateDate(argCreateDate);
/*  356 */       ev_postable = true;
/*      */     } 
/*      */     
/*  359 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  367 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  375 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  376 */       this._events != null && 
/*  377 */       postEventsForChanges()) {
/*  378 */       this._events.post(ICorrectionModifier.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  385 */     boolean ev_postable = false;
/*      */     
/*  387 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  388 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  389 */       getDAO_().setCreateUserId(argCreateUserId);
/*  390 */       ev_postable = true;
/*      */     } 
/*      */     
/*  393 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  401 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  409 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  410 */       this._events != null && 
/*  411 */       postEventsForChanges()) {
/*  412 */       this._events.post(ICorrectionModifier.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  419 */     boolean ev_postable = false;
/*      */     
/*  421 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  422 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  423 */       getDAO_().setUpdateDate(argUpdateDate);
/*  424 */       ev_postable = true;
/*      */     } 
/*      */     
/*  427 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  435 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  443 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  444 */       this._events != null && 
/*  445 */       postEventsForChanges()) {
/*  446 */       this._events.post(ICorrectionModifier.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  453 */     boolean ev_postable = false;
/*      */     
/*  455 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  456 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  457 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  458 */       ev_postable = true;
/*      */     } 
/*      */     
/*  461 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalRetailLocationId() {
/*  469 */     if (getDAO_().getOriginalRetailLocationId() != null) {
/*  470 */       return getDAO_().getOriginalRetailLocationId().longValue();
/*      */     }
/*      */     
/*  473 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalRetailLocationId(long argOriginalRetailLocationId) {
/*  482 */     if (setOriginalRetailLocationId_noev(argOriginalRetailLocationId) && 
/*  483 */       this._events != null && 
/*  484 */       postEventsForChanges()) {
/*  485 */       this._events.post(ICorrectionModifier.SET_ORIGINALRETAILLOCATIONID, Long.valueOf(argOriginalRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalRetailLocationId_noev(long argOriginalRetailLocationId) {
/*  492 */     boolean ev_postable = false;
/*      */     
/*  494 */     if ((getDAO_().getOriginalRetailLocationId() == null && Long.valueOf(argOriginalRetailLocationId) != null) || (
/*  495 */       getDAO_().getOriginalRetailLocationId() != null && !getDAO_().getOriginalRetailLocationId().equals(Long.valueOf(argOriginalRetailLocationId)))) {
/*  496 */       getDAO_().setOriginalRetailLocationId(Long.valueOf(argOriginalRetailLocationId));
/*  497 */       ev_postable = true;
/*      */     } 
/*      */     
/*  500 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalWorkstationId() {
/*  508 */     if (getDAO_().getOriginalWorkstationId() != null) {
/*  509 */       return getDAO_().getOriginalWorkstationId().longValue();
/*      */     }
/*      */     
/*  512 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalWorkstationId(long argOriginalWorkstationId) {
/*  521 */     if (setOriginalWorkstationId_noev(argOriginalWorkstationId) && 
/*  522 */       this._events != null && 
/*  523 */       postEventsForChanges()) {
/*  524 */       this._events.post(ICorrectionModifier.SET_ORIGINALWORKSTATIONID, Long.valueOf(argOriginalWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalWorkstationId_noev(long argOriginalWorkstationId) {
/*  531 */     boolean ev_postable = false;
/*      */     
/*  533 */     if ((getDAO_().getOriginalWorkstationId() == null && Long.valueOf(argOriginalWorkstationId) != null) || (
/*  534 */       getDAO_().getOriginalWorkstationId() != null && !getDAO_().getOriginalWorkstationId().equals(Long.valueOf(argOriginalWorkstationId)))) {
/*  535 */       getDAO_().setOriginalWorkstationId(Long.valueOf(argOriginalWorkstationId));
/*  536 */       ev_postable = true;
/*      */     } 
/*      */     
/*  539 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getOriginalBusinessDate() {
/*  547 */     return getDAO_().getOriginalBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/*  555 */     if (setOriginalBusinessDate_noev(argOriginalBusinessDate) && 
/*  556 */       this._events != null && 
/*  557 */       postEventsForChanges()) {
/*  558 */       this._events.post(ICorrectionModifier.SET_ORIGINALBUSINESSDATE, argOriginalBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalBusinessDate_noev(Date argOriginalBusinessDate) {
/*  565 */     boolean ev_postable = false;
/*      */     
/*  567 */     if ((getDAO_().getOriginalBusinessDate() == null && argOriginalBusinessDate != null) || (
/*  568 */       getDAO_().getOriginalBusinessDate() != null && !getDAO_().getOriginalBusinessDate().equals(argOriginalBusinessDate))) {
/*  569 */       getDAO_().setOriginalBusinessDate(argOriginalBusinessDate);
/*  570 */       ev_postable = true;
/*      */     } 
/*      */     
/*  573 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalTransactionSequence() {
/*  581 */     if (getDAO_().getOriginalTransactionSequence() != null) {
/*  582 */       return getDAO_().getOriginalTransactionSequence().longValue();
/*      */     }
/*      */     
/*  585 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalTransactionSequence(long argOriginalTransactionSequence) {
/*  594 */     if (setOriginalTransactionSequence_noev(argOriginalTransactionSequence) && 
/*  595 */       this._events != null && 
/*  596 */       postEventsForChanges()) {
/*  597 */       this._events.post(ICorrectionModifier.SET_ORIGINALTRANSACTIONSEQUENCE, Long.valueOf(argOriginalTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalTransactionSequence_noev(long argOriginalTransactionSequence) {
/*  604 */     boolean ev_postable = false;
/*      */     
/*  606 */     if ((getDAO_().getOriginalTransactionSequence() == null && Long.valueOf(argOriginalTransactionSequence) != null) || (
/*  607 */       getDAO_().getOriginalTransactionSequence() != null && !getDAO_().getOriginalTransactionSequence().equals(Long.valueOf(argOriginalTransactionSequence)))) {
/*  608 */       getDAO_().setOriginalTransactionSequence(Long.valueOf(argOriginalTransactionSequence));
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
/*      */   public int getOriginalRetailTransactionLineItemSequence() {
/*  620 */     if (getDAO_().getOriginalRetailTransactionLineItemSequence() != null) {
/*  621 */       return getDAO_().getOriginalRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  624 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalRetailTransactionLineItemSequence(int argOriginalRetailTransactionLineItemSequence) {
/*  633 */     if (setOriginalRetailTransactionLineItemSequence_noev(argOriginalRetailTransactionLineItemSequence) && 
/*  634 */       this._events != null && 
/*  635 */       postEventsForChanges()) {
/*  636 */       this._events.post(ICorrectionModifier.SET_ORIGINALRETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argOriginalRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalRetailTransactionLineItemSequence_noev(int argOriginalRetailTransactionLineItemSequence) {
/*  643 */     boolean ev_postable = false;
/*      */     
/*  645 */     if ((getDAO_().getOriginalRetailTransactionLineItemSequence() == null && Integer.valueOf(argOriginalRetailTransactionLineItemSequence) != null) || (
/*  646 */       getDAO_().getOriginalRetailTransactionLineItemSequence() != null && !getDAO_().getOriginalRetailTransactionLineItemSequence().equals(Integer.valueOf(argOriginalRetailTransactionLineItemSequence)))) {
/*  647 */       getDAO_().setOriginalRetailTransactionLineItemSequence(Integer.valueOf(argOriginalRetailTransactionLineItemSequence));
/*  648 */       ev_postable = true;
/*      */     } 
/*      */     
/*  651 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReasonCode() {
/*  659 */     return getDAO_().getReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReasonCode(String argReasonCode) {
/*  667 */     if (setReasonCode_noev(argReasonCode) && 
/*  668 */       this._events != null && 
/*  669 */       postEventsForChanges()) {
/*  670 */       this._events.post(ICorrectionModifier.SET_REASONCODE, argReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReasonCode_noev(String argReasonCode) {
/*  677 */     boolean ev_postable = false;
/*      */     
/*  679 */     if ((getDAO_().getReasonCode() == null && argReasonCode != null) || (
/*  680 */       getDAO_().getReasonCode() != null && !getDAO_().getReasonCode().equals(argReasonCode))) {
/*  681 */       getDAO_().setReasonCode(argReasonCode);
/*  682 */       ev_postable = true;
/*      */     } 
/*      */     
/*  685 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNotes() {
/*  693 */     return getDAO_().getNotes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotes(String argNotes) {
/*  701 */     if (setNotes_noev(argNotes) && 
/*  702 */       this._events != null && 
/*  703 */       postEventsForChanges()) {
/*  704 */       this._events.post(ICorrectionModifier.SET_NOTES, argNotes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotes_noev(String argNotes) {
/*  711 */     boolean ev_postable = false;
/*      */     
/*  713 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/*  714 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/*  715 */       getDAO_().setNotes(argNotes);
/*  716 */       ev_postable = true;
/*      */     } 
/*      */     
/*  719 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOriginalTaxAmt() {
/*  727 */     return getDAO_().getOriginalTaxAmt();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalTaxAmt(BigDecimal argOriginalTaxAmt) {
/*  735 */     if (setOriginalTaxAmt_noev(argOriginalTaxAmt) && 
/*  736 */       this._events != null && 
/*  737 */       postEventsForChanges()) {
/*  738 */       this._events.post(ICorrectionModifier.SET_ORIGINALTAXAMT, argOriginalTaxAmt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalTaxAmt_noev(BigDecimal argOriginalTaxAmt) {
/*  745 */     boolean ev_postable = false;
/*      */     
/*  747 */     if ((getDAO_().getOriginalTaxAmt() == null && argOriginalTaxAmt != null) || (
/*  748 */       getDAO_().getOriginalTaxAmt() != null && !getDAO_().getOriginalTaxAmt().equals(argOriginalTaxAmt))) {
/*  749 */       getDAO_().setOriginalTaxAmt(argOriginalTaxAmt);
/*  750 */       ev_postable = true;
/*      */     } 
/*      */     
/*  753 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOriginalExtendedPrice() {
/*  761 */     return getDAO_().getOriginalExtendedPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalExtendedPrice(BigDecimal argOriginalExtendedPrice) {
/*  769 */     if (setOriginalExtendedPrice_noev(argOriginalExtendedPrice) && 
/*  770 */       this._events != null && 
/*  771 */       postEventsForChanges()) {
/*  772 */       this._events.post(ICorrectionModifier.SET_ORIGINALEXTENDEDPRICE, argOriginalExtendedPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalExtendedPrice_noev(BigDecimal argOriginalExtendedPrice) {
/*  779 */     boolean ev_postable = false;
/*      */     
/*  781 */     if ((getDAO_().getOriginalExtendedPrice() == null && argOriginalExtendedPrice != null) || (
/*  782 */       getDAO_().getOriginalExtendedPrice() != null && !getDAO_().getOriginalExtendedPrice().equals(argOriginalExtendedPrice))) {
/*  783 */       getDAO_().setOriginalExtendedPrice(argOriginalExtendedPrice);
/*  784 */       ev_postable = true;
/*      */     } 
/*      */     
/*  787 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOriginalUnitPrice() {
/*  795 */     return getDAO_().getOriginalUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalUnitPrice(BigDecimal argOriginalUnitPrice) {
/*  803 */     if (setOriginalUnitPrice_noev(argOriginalUnitPrice) && 
/*  804 */       this._events != null && 
/*  805 */       postEventsForChanges()) {
/*  806 */       this._events.post(ICorrectionModifier.SET_ORIGINALUNITPRICE, argOriginalUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalUnitPrice_noev(BigDecimal argOriginalUnitPrice) {
/*  813 */     boolean ev_postable = false;
/*      */     
/*  815 */     if ((getDAO_().getOriginalUnitPrice() == null && argOriginalUnitPrice != null) || (
/*  816 */       getDAO_().getOriginalUnitPrice() != null && !getDAO_().getOriginalUnitPrice().equals(argOriginalUnitPrice))) {
/*  817 */       getDAO_().setOriginalUnitPrice(argOriginalUnitPrice);
/*  818 */       ev_postable = true;
/*      */     } 
/*      */     
/*  821 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOriginalBaseExtendedPrice() {
/*  829 */     return getDAO_().getOriginalBaseExtendedPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalBaseExtendedPrice(BigDecimal argOriginalBaseExtendedPrice) {
/*  837 */     if (setOriginalBaseExtendedPrice_noev(argOriginalBaseExtendedPrice) && 
/*  838 */       this._events != null && 
/*  839 */       postEventsForChanges()) {
/*  840 */       this._events.post(ICorrectionModifier.SET_ORIGINALBASEEXTENDEDPRICE, argOriginalBaseExtendedPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalBaseExtendedPrice_noev(BigDecimal argOriginalBaseExtendedPrice) {
/*  847 */     boolean ev_postable = false;
/*      */     
/*  849 */     if ((getDAO_().getOriginalBaseExtendedPrice() == null && argOriginalBaseExtendedPrice != null) || (
/*  850 */       getDAO_().getOriginalBaseExtendedPrice() != null && !getDAO_().getOriginalBaseExtendedPrice().equals(argOriginalBaseExtendedPrice))) {
/*  851 */       getDAO_().setOriginalBaseExtendedPrice(argOriginalBaseExtendedPrice);
/*  852 */       ev_postable = true;
/*      */     } 
/*      */     
/*  855 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getOriginalBaseUnitPrice() {
/*  863 */     return getDAO_().getOriginalBaseUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalBaseUnitPrice(BigDecimal argOriginalBaseUnitPrice) {
/*  871 */     if (setOriginalBaseUnitPrice_noev(argOriginalBaseUnitPrice) && 
/*  872 */       this._events != null && 
/*  873 */       postEventsForChanges()) {
/*  874 */       this._events.post(ICorrectionModifier.SET_ORIGINALBASEUNITPRICE, argOriginalBaseUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalBaseUnitPrice_noev(BigDecimal argOriginalBaseUnitPrice) {
/*  881 */     boolean ev_postable = false;
/*      */     
/*  883 */     if ((getDAO_().getOriginalBaseUnitPrice() == null && argOriginalBaseUnitPrice != null) || (
/*  884 */       getDAO_().getOriginalBaseUnitPrice() != null && !getDAO_().getOriginalBaseUnitPrice().equals(argOriginalBaseUnitPrice))) {
/*  885 */       getDAO_().setOriginalBaseUnitPrice(argOriginalBaseUnitPrice);
/*  886 */       ev_postable = true;
/*      */     } 
/*      */     
/*  889 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected ICorrectionModifierProperty newProperty(String argPropertyName) {
/*  893 */     CorrectionModifierPropertyId id = new CorrectionModifierPropertyId();
/*      */     
/*  895 */     id.setBusinessDate(getBusinessDate());
/*  896 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  897 */     id.setRetailTransactionLineItemSequence(Integer.valueOf(getRetailTransactionLineItemSequence()));
/*  898 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  899 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  900 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  902 */     ICorrectionModifierProperty prop = (ICorrectionModifierProperty)DataFactory.getInstance().createNewObject((IObjectId)id, ICorrectionModifierProperty.class);
/*  903 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<ICorrectionModifierProperty> getProperties() {
/*  912 */     if (this._properties == null) {
/*  913 */       this._properties = new HistoricalList(null);
/*      */     }
/*  915 */     return (List<ICorrectionModifierProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<ICorrectionModifierProperty> argProperties) {
/*  919 */     if (this._properties == null) {
/*  920 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  922 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  925 */     for (ICorrectionModifierProperty child : this._properties) {
/*  926 */       CorrectionModifierPropertyModel model = (CorrectionModifierPropertyModel)child;
/*  927 */       model.setBusinessDate_noev(getBusinessDate());
/*  928 */       model.setOrganizationId_noev(getOrganizationId());
/*  929 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  930 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/*  931 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  932 */       model.setWorkstationId_noev(getWorkstationId());
/*  933 */       if (child instanceof IDataModelImpl) {
/*  934 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  935 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  936 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  937 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  940 */       if (postEventsForChanges()) {
/*  941 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addCorrectionModifierProperty(ICorrectionModifierProperty argCorrectionModifierProperty) {
/*  947 */     if (this._properties == null) {
/*  948 */       this._properties = new HistoricalList(null);
/*      */     }
/*  950 */     argCorrectionModifierProperty.setBusinessDate(getBusinessDate());
/*  951 */     argCorrectionModifierProperty.setOrganizationId(getOrganizationId());
/*  952 */     argCorrectionModifierProperty.setRetailLocationId(getRetailLocationId());
/*  953 */     argCorrectionModifierProperty.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*  954 */     argCorrectionModifierProperty.setTransactionSequence(getTransactionSequence());
/*  955 */     argCorrectionModifierProperty.setWorkstationId(getWorkstationId());
/*  956 */     if (argCorrectionModifierProperty instanceof IDataModelImpl) {
/*  957 */       IDataAccessObject childDao = ((IDataModelImpl)argCorrectionModifierProperty).getDAO();
/*  958 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  959 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  960 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  965 */     if (postEventsForChanges()) {
/*  966 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCorrectionModifierProperty));
/*      */     }
/*      */     
/*  969 */     this._properties.add(argCorrectionModifierProperty);
/*  970 */     if (postEventsForChanges()) {
/*  971 */       this._events.post(ICorrectionModifier.ADD_PROPERTIES, argCorrectionModifierProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCorrectionModifierProperty(ICorrectionModifierProperty argCorrectionModifierProperty) {
/*  976 */     if (this._properties != null) {
/*      */       
/*  978 */       if (postEventsForChanges()) {
/*  979 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCorrectionModifierProperty));
/*      */       }
/*  981 */       this._properties.remove(argCorrectionModifierProperty);
/*  982 */       if (postEventsForChanges()) {
/*  983 */         this._events.post(ICorrectionModifier.REMOVE_PROPERTIES, argCorrectionModifierProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentLine(IRetailTransactionLineItem argParentLine) {
/*  989 */     this._parentLine = argParentLine;
/*      */   }
/*      */   
/*      */   public IRetailTransactionLineItem getParentLine() {
/*  993 */     return this._parentLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  998 */     if ("Properties".equals(argFieldId)) {
/*  999 */       return getProperties();
/*      */     }
/* 1001 */     if ("CorrectionModifierExtension".equals(argFieldId)) {
/* 1002 */       return this._myExtension;
/*      */     }
/*      */     
/* 1005 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1011 */     if ("Properties".equals(argFieldId)) {
/* 1012 */       setProperties(changeToList(argValue, ICorrectionModifierProperty.class));
/*      */     }
/* 1014 */     else if ("CorrectionModifierExtension".equals(argFieldId)) {
/* 1015 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1018 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1024 */     this._persistenceDefaults = argPD;
/* 1025 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1026 */     this._eventManager = argEM;
/* 1027 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1028 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1029 */     if (this._properties != null) {
/* 1030 */       for (ICorrectionModifierProperty relationship : this._properties) {
/* 1031 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getCorrectionModifierExt() {
/* 1037 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setCorrectionModifierExt(IDataModel argExt) {
/* 1041 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1046 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1050 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1053 */     super.startTransaction();
/*      */     
/* 1055 */     this._propertiesSavepoint = this._properties;
/* 1056 */     if (this._properties != null) {
/* 1057 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1058 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1059 */       while (it.hasNext()) {
/* 1060 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1065 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1070 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1073 */     super.rollbackChanges();
/*      */     
/* 1075 */     this._properties = this._propertiesSavepoint;
/* 1076 */     this._propertiesSavepoint = null;
/* 1077 */     if (this._properties != null) {
/* 1078 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1079 */       while (it.hasNext()) {
/* 1080 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1088 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1091 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1094 */     super.commitTransaction();
/*      */     
/* 1096 */     this._propertiesSavepoint = this._properties;
/* 1097 */     if (this._properties != null) {
/* 1098 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1099 */       while (it.hasNext()) {
/* 1100 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1102 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1106 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1111 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\CorrectionModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */