/*      */ package dtv.xst.dao.inv.impl;
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
/*      */ import dtv.xst.dao.inv.IInventoryMovementPending;
/*      */ import dtv.xst.dao.inv.IInventoryMovementPendingDetail;
/*      */ import dtv.xst.dao.inv.IInventoryMovementPendingDetailProperty;
/*      */ import dtv.xst.dao.inv.InventoryMovementPendingDetailPropertyId;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class InventoryMovementPendingDetailModel extends AbstractDataModelWithPropertyImpl<IInventoryMovementPendingDetailProperty> implements IInventoryMovementPendingDetail {
/*      */   private static final long serialVersionUID = 827340925L;
/*      */   private IInventoryMovementPending _parentObject;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient boolean _alreadyInCommit = false; private IDataModel _myExtension; private HistoricalList<IInventoryMovementPendingDetailProperty> _properties; private transient HistoricalList<IInventoryMovementPendingDetailProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new InventoryMovementPendingDetailDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InventoryMovementPendingDetailDAO getDAO_() {
/*   48 */     return (InventoryMovementPendingDetailDAO)this._daoImpl;
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
/*   69 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   70 */       this._events != null && 
/*   71 */       postEventsForChanges()) {
/*   72 */       this._events.post(IInventoryMovementPendingDetail.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   79 */     boolean ev_postable = false;
/*      */     
/*   81 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   82 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   83 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   84 */       ev_postable = true;
/*   85 */       if (this._properties != null) {
/*      */         
/*   87 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*   88 */         while (it.hasNext())
/*      */         {
/*   90 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*   95 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  103 */     if (getDAO_().getRetailLocationId() != null) {
/*  104 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  107 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  116 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  117 */       this._events != null && 
/*  118 */       postEventsForChanges()) {
/*  119 */       this._events.post(IInventoryMovementPendingDetail.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  126 */     boolean ev_postable = false;
/*      */     
/*  128 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  129 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  130 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  131 */       ev_postable = true;
/*  132 */       if (this._properties != null) {
/*      */         
/*  134 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*  135 */         while (it.hasNext())
/*      */         {
/*  137 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  142 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  150 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  158 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  159 */       this._events != null && 
/*  160 */       postEventsForChanges()) {
/*  161 */       this._events.post(IInventoryMovementPendingDetail.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  168 */     boolean ev_postable = false;
/*      */     
/*  170 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  171 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  172 */       getDAO_().setBusinessDate(argBusinessDate);
/*  173 */       ev_postable = true;
/*  174 */       if (this._properties != null) {
/*      */         
/*  176 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*  177 */         while (it.hasNext())
/*      */         {
/*  179 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
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
/*      */   public long getWorkstationId() {
/*  192 */     if (getDAO_().getWorkstationId() != null) {
/*  193 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  196 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  205 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  206 */       this._events != null && 
/*  207 */       postEventsForChanges()) {
/*  208 */       this._events.post(IInventoryMovementPendingDetail.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  215 */     boolean ev_postable = false;
/*      */     
/*  217 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  218 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  219 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  220 */       ev_postable = true;
/*  221 */       if (this._properties != null) {
/*      */         
/*  223 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*  224 */         while (it.hasNext())
/*      */         {
/*  226 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
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
/*  255 */       this._events.post(IInventoryMovementPendingDetail.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
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
/*  270 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*  271 */         while (it.hasNext())
/*      */         {
/*  273 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
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
/*      */   public long getLineItemSequence() {
/*  286 */     if (getDAO_().getLineItemSequence() != null) {
/*  287 */       return getDAO_().getLineItemSequence().longValue();
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
/*      */   public void setLineItemSequence(long argLineItemSequence) {
/*  299 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/*  300 */       this._events != null && 
/*  301 */       postEventsForChanges()) {
/*  302 */       this._events.post(IInventoryMovementPendingDetail.SET_LINEITEMSEQUENCE, Long.valueOf(argLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemSequence_noev(long argLineItemSequence) {
/*  309 */     boolean ev_postable = false;
/*      */     
/*  311 */     if ((getDAO_().getLineItemSequence() == null && Long.valueOf(argLineItemSequence) != null) || (
/*  312 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Long.valueOf(argLineItemSequence)))) {
/*  313 */       getDAO_().setLineItemSequence(Long.valueOf(argLineItemSequence));
/*  314 */       ev_postable = true;
/*  315 */       if (this._properties != null) {
/*      */         
/*  317 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*  318 */         while (it.hasNext())
/*      */         {
/*  320 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
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
/*      */   public long getPendingSequence() {
/*  333 */     if (getDAO_().getPendingSequence() != null) {
/*  334 */       return getDAO_().getPendingSequence().longValue();
/*      */     }
/*      */     
/*  337 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPendingSequence(long argPendingSequence) {
/*  346 */     if (setPendingSequence_noev(argPendingSequence) && 
/*  347 */       this._events != null && 
/*  348 */       postEventsForChanges()) {
/*  349 */       this._events.post(IInventoryMovementPendingDetail.SET_PENDINGSEQUENCE, Long.valueOf(argPendingSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPendingSequence_noev(long argPendingSequence) {
/*  356 */     boolean ev_postable = false;
/*      */     
/*  358 */     if ((getDAO_().getPendingSequence() == null && Long.valueOf(argPendingSequence) != null) || (
/*  359 */       getDAO_().getPendingSequence() != null && !getDAO_().getPendingSequence().equals(Long.valueOf(argPendingSequence)))) {
/*  360 */       getDAO_().setPendingSequence(Long.valueOf(argPendingSequence));
/*  361 */       ev_postable = true;
/*  362 */       if (this._properties != null) {
/*      */         
/*  364 */         Iterator<InventoryMovementPendingDetailPropertyModel> it = this._properties.iterator();
/*  365 */         while (it.hasNext())
/*      */         {
/*  367 */           ((InventoryMovementPendingDetailPropertyModel)it.next()).setPendingSequence_noev(argPendingSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  372 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  380 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  388 */     if (setCreateDate_noev(argCreateDate) && 
/*  389 */       this._events != null && 
/*  390 */       postEventsForChanges()) {
/*  391 */       this._events.post(IInventoryMovementPendingDetail.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  398 */     boolean ev_postable = false;
/*      */     
/*  400 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  401 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  402 */       getDAO_().setCreateDate(argCreateDate);
/*  403 */       ev_postable = true;
/*      */     } 
/*      */     
/*  406 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  414 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  422 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  423 */       this._events != null && 
/*  424 */       postEventsForChanges()) {
/*  425 */       this._events.post(IInventoryMovementPendingDetail.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  432 */     boolean ev_postable = false;
/*      */     
/*  434 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  435 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  436 */       getDAO_().setCreateUserId(argCreateUserId);
/*  437 */       ev_postable = true;
/*      */     } 
/*      */     
/*  440 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  448 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  456 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  457 */       this._events != null && 
/*  458 */       postEventsForChanges()) {
/*  459 */       this._events.post(IInventoryMovementPendingDetail.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  466 */     boolean ev_postable = false;
/*      */     
/*  468 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  469 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  470 */       getDAO_().setUpdateDate(argUpdateDate);
/*  471 */       ev_postable = true;
/*      */     } 
/*      */     
/*  474 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  482 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  490 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  491 */       this._events != null && 
/*  492 */       postEventsForChanges()) {
/*  493 */       this._events.post(IInventoryMovementPendingDetail.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  500 */     boolean ev_postable = false;
/*      */     
/*  502 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  503 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  504 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  505 */       ev_postable = true;
/*      */     } 
/*      */     
/*  508 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  516 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  524 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  525 */       this._events != null && 
/*  526 */       postEventsForChanges()) {
/*  527 */       this._events.post(IInventoryMovementPendingDetail.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  534 */     boolean ev_postable = false;
/*      */     
/*  536 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  537 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  538 */       getDAO_().setSerialNumber(argSerialNumber);
/*  539 */       ev_postable = true;
/*      */     } 
/*      */     
/*  542 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemId() {
/*  550 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  558 */     if (setItemId_noev(argItemId) && 
/*  559 */       this._events != null && 
/*  560 */       postEventsForChanges()) {
/*  561 */       this._events.post(IInventoryMovementPendingDetail.SET_ITEMID, argItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/*  568 */     boolean ev_postable = false;
/*      */     
/*  570 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/*  571 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/*  572 */       getDAO_().setItemId(argItemId);
/*  573 */       ev_postable = true;
/*      */     } 
/*      */     
/*  576 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getQuantity() {
/*  584 */     return getDAO_().getQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(BigDecimal argQuantity) {
/*  592 */     if (setQuantity_noev(argQuantity) && 
/*  593 */       this._events != null && 
/*  594 */       postEventsForChanges()) {
/*  595 */       this._events.post(IInventoryMovementPendingDetail.SET_QUANTITY, argQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/*  602 */     boolean ev_postable = false;
/*      */     
/*  604 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/*  605 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/*  606 */       getDAO_().setQuantity(argQuantity);
/*  607 */       ev_postable = true;
/*      */     } 
/*      */     
/*  610 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSourceLocationId() {
/*  618 */     return getDAO_().getSourceLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSourceLocationId(String argSourceLocationId) {
/*  626 */     if (setSourceLocationId_noev(argSourceLocationId) && 
/*  627 */       this._events != null && 
/*  628 */       postEventsForChanges()) {
/*  629 */       this._events.post(IInventoryMovementPendingDetail.SET_SOURCELOCATIONID, argSourceLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSourceLocationId_noev(String argSourceLocationId) {
/*  636 */     boolean ev_postable = false;
/*      */     
/*  638 */     if ((getDAO_().getSourceLocationId() == null && argSourceLocationId != null) || (
/*  639 */       getDAO_().getSourceLocationId() != null && !getDAO_().getSourceLocationId().equals(argSourceLocationId))) {
/*  640 */       getDAO_().setSourceLocationId(argSourceLocationId);
/*  641 */       ev_postable = true;
/*      */     } 
/*      */     
/*  644 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSourceBucketId() {
/*  652 */     return getDAO_().getSourceBucketId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSourceBucketId(String argSourceBucketId) {
/*  660 */     if (setSourceBucketId_noev(argSourceBucketId) && 
/*  661 */       this._events != null && 
/*  662 */       postEventsForChanges()) {
/*  663 */       this._events.post(IInventoryMovementPendingDetail.SET_SOURCEBUCKETID, argSourceBucketId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSourceBucketId_noev(String argSourceBucketId) {
/*  670 */     boolean ev_postable = false;
/*      */     
/*  672 */     if ((getDAO_().getSourceBucketId() == null && argSourceBucketId != null) || (
/*  673 */       getDAO_().getSourceBucketId() != null && !getDAO_().getSourceBucketId().equals(argSourceBucketId))) {
/*  674 */       getDAO_().setSourceBucketId(argSourceBucketId);
/*  675 */       ev_postable = true;
/*      */     } 
/*      */     
/*  678 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationLocationId() {
/*  686 */     return getDAO_().getDestinationLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationLocationId(String argDestinationLocationId) {
/*  694 */     if (setDestinationLocationId_noev(argDestinationLocationId) && 
/*  695 */       this._events != null && 
/*  696 */       postEventsForChanges()) {
/*  697 */       this._events.post(IInventoryMovementPendingDetail.SET_DESTINATIONLOCATIONID, argDestinationLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationLocationId_noev(String argDestinationLocationId) {
/*  704 */     boolean ev_postable = false;
/*      */     
/*  706 */     if ((getDAO_().getDestinationLocationId() == null && argDestinationLocationId != null) || (
/*  707 */       getDAO_().getDestinationLocationId() != null && !getDAO_().getDestinationLocationId().equals(argDestinationLocationId))) {
/*  708 */       getDAO_().setDestinationLocationId(argDestinationLocationId);
/*  709 */       ev_postable = true;
/*      */     } 
/*      */     
/*  712 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDestinationBucketId() {
/*  720 */     return getDAO_().getDestinationBucketId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDestinationBucketId(String argDestinationBucketId) {
/*  728 */     if (setDestinationBucketId_noev(argDestinationBucketId) && 
/*  729 */       this._events != null && 
/*  730 */       postEventsForChanges()) {
/*  731 */       this._events.post(IInventoryMovementPendingDetail.SET_DESTINATIONBUCKETID, argDestinationBucketId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDestinationBucketId_noev(String argDestinationBucketId) {
/*  738 */     boolean ev_postable = false;
/*      */     
/*  740 */     if ((getDAO_().getDestinationBucketId() == null && argDestinationBucketId != null) || (
/*  741 */       getDAO_().getDestinationBucketId() != null && !getDAO_().getDestinationBucketId().equals(argDestinationBucketId))) {
/*  742 */       getDAO_().setDestinationBucketId(argDestinationBucketId);
/*  743 */       ev_postable = true;
/*      */     } 
/*      */     
/*  746 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getActionCode() {
/*  754 */     return getDAO_().getActionCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActionCode(String argActionCode) {
/*  762 */     if (setActionCode_noev(argActionCode) && 
/*  763 */       this._events != null && 
/*  764 */       postEventsForChanges()) {
/*  765 */       this._events.post(IInventoryMovementPendingDetail.SET_ACTIONCODE, argActionCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActionCode_noev(String argActionCode) {
/*  772 */     boolean ev_postable = false;
/*      */     
/*  774 */     if ((getDAO_().getActionCode() == null && argActionCode != null) || (
/*  775 */       getDAO_().getActionCode() != null && !getDAO_().getActionCode().equals(argActionCode))) {
/*  776 */       getDAO_().setActionCode(argActionCode);
/*  777 */       ev_postable = true;
/*      */     } 
/*      */     
/*  780 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/*  788 */     if (getDAO_().getVoid() != null) {
/*  789 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/*  792 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/*  801 */     if (setVoid_noev(argVoid) && 
/*  802 */       this._events != null && 
/*  803 */       postEventsForChanges()) {
/*  804 */       this._events.post(IInventoryMovementPendingDetail.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  811 */     boolean ev_postable = false;
/*      */     
/*  813 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  814 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  815 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/*  816 */       ev_postable = true;
/*      */     } 
/*      */     
/*  819 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IInventoryMovementPendingDetailProperty newProperty(String argPropertyName) {
/*  823 */     InventoryMovementPendingDetailPropertyId id = new InventoryMovementPendingDetailPropertyId();
/*      */     
/*  825 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  826 */     id.setBusinessDate(getBusinessDate());
/*  827 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  828 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  829 */     id.setLineItemSequence(Long.valueOf(getLineItemSequence()));
/*  830 */     id.setPendingSequence(Long.valueOf(getPendingSequence()));
/*  831 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  833 */     IInventoryMovementPendingDetailProperty prop = (IInventoryMovementPendingDetailProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryMovementPendingDetailProperty.class);
/*  834 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IInventoryMovementPendingDetailProperty> getProperties() {
/*  843 */     if (this._properties == null) {
/*  844 */       this._properties = new HistoricalList(null);
/*      */     }
/*  846 */     return (List<IInventoryMovementPendingDetailProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IInventoryMovementPendingDetailProperty> argProperties) {
/*  850 */     if (this._properties == null) {
/*  851 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  853 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  856 */     for (IInventoryMovementPendingDetailProperty child : this._properties) {
/*  857 */       InventoryMovementPendingDetailPropertyModel model = (InventoryMovementPendingDetailPropertyModel)child;
/*  858 */       model.setOrganizationId_noev(getOrganizationId());
/*  859 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  860 */       model.setBusinessDate_noev(getBusinessDate());
/*  861 */       model.setWorkstationId_noev(getWorkstationId());
/*  862 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  863 */       model.setLineItemSequence_noev(getLineItemSequence());
/*  864 */       model.setPendingSequence_noev(getPendingSequence());
/*  865 */       if (child instanceof IDataModelImpl) {
/*  866 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  867 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  868 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  869 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  872 */       if (postEventsForChanges()) {
/*  873 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryMovementPendingDetailProperty(IInventoryMovementPendingDetailProperty argInventoryMovementPendingDetailProperty) {
/*  879 */     if (this._properties == null) {
/*  880 */       this._properties = new HistoricalList(null);
/*      */     }
/*  882 */     argInventoryMovementPendingDetailProperty.setOrganizationId(getOrganizationId());
/*  883 */     argInventoryMovementPendingDetailProperty.setRetailLocationId(getRetailLocationId());
/*  884 */     argInventoryMovementPendingDetailProperty.setBusinessDate(getBusinessDate());
/*  885 */     argInventoryMovementPendingDetailProperty.setWorkstationId(getWorkstationId());
/*  886 */     argInventoryMovementPendingDetailProperty.setTransactionSequence(getTransactionSequence());
/*  887 */     argInventoryMovementPendingDetailProperty.setLineItemSequence(getLineItemSequence());
/*  888 */     argInventoryMovementPendingDetailProperty.setPendingSequence(getPendingSequence());
/*  889 */     if (argInventoryMovementPendingDetailProperty instanceof IDataModelImpl) {
/*  890 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryMovementPendingDetailProperty).getDAO();
/*  891 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  892 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  893 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  898 */     if (postEventsForChanges()) {
/*  899 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPendingDetailProperty));
/*      */     }
/*      */     
/*  902 */     this._properties.add(argInventoryMovementPendingDetailProperty);
/*  903 */     if (postEventsForChanges()) {
/*  904 */       this._events.post(IInventoryMovementPendingDetail.ADD_PROPERTIES, argInventoryMovementPendingDetailProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryMovementPendingDetailProperty(IInventoryMovementPendingDetailProperty argInventoryMovementPendingDetailProperty) {
/*  909 */     if (this._properties != null) {
/*      */       
/*  911 */       if (postEventsForChanges()) {
/*  912 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPendingDetailProperty));
/*      */       }
/*  914 */       this._properties.remove(argInventoryMovementPendingDetailProperty);
/*  915 */       if (postEventsForChanges()) {
/*  916 */         this._events.post(IInventoryMovementPendingDetail.REMOVE_PROPERTIES, argInventoryMovementPendingDetailProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentObject(IInventoryMovementPending argParentObject) {
/*  922 */     this._parentObject = argParentObject;
/*      */   }
/*      */   
/*      */   public IInventoryMovementPending getParentObject() {
/*  926 */     return this._parentObject;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/*  931 */     if ("Properties".equals(argFieldId)) {
/*  932 */       return getProperties();
/*      */     }
/*  934 */     if ("InventoryMovementPendingDetailExtension".equals(argFieldId)) {
/*  935 */       return this._myExtension;
/*      */     }
/*      */     
/*  938 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/*  944 */     if ("Properties".equals(argFieldId)) {
/*  945 */       setProperties(changeToList(argValue, IInventoryMovementPendingDetailProperty.class));
/*      */     }
/*  947 */     else if ("InventoryMovementPendingDetailExtension".equals(argFieldId)) {
/*  948 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/*  951 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/*  957 */     this._persistenceDefaults = argPD;
/*  958 */     this._daoImpl.setPersistenceDefaults(argPD);
/*  959 */     this._eventManager = argEM;
/*  960 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/*  961 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/*  962 */     if (this._properties != null) {
/*  963 */       for (IInventoryMovementPendingDetailProperty relationship : this._properties) {
/*  964 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getInventoryMovementPendingDetailExt() {
/*  970 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setInventoryMovementPendingDetailExt(IDataModel argExt) {
/*  974 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/*  979 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/*  983 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/*  986 */     super.startTransaction();
/*      */     
/*  988 */     this._propertiesSavepoint = this._properties;
/*  989 */     if (this._properties != null) {
/*  990 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/*  991 */       Iterator<IDataModel> it = this._properties.iterator();
/*  992 */       while (it.hasNext()) {
/*  993 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  998 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1003 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1006 */     super.rollbackChanges();
/*      */     
/* 1008 */     this._properties = this._propertiesSavepoint;
/* 1009 */     this._propertiesSavepoint = null;
/* 1010 */     if (this._properties != null) {
/* 1011 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1012 */       while (it.hasNext()) {
/* 1013 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1021 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1024 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1027 */     super.commitTransaction();
/*      */     
/* 1029 */     this._propertiesSavepoint = this._properties;
/* 1030 */     if (this._properties != null) {
/* 1031 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1032 */       while (it.hasNext()) {
/* 1033 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1035 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1039 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 1044 */     argStream.defaultReadObject();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */