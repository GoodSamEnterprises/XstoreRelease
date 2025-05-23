/*      */ package dtv.xst.dao.inv.impl;
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
/*      */ import dtv.xst.dao.inv.IInventoryMovementPending;
/*      */ import dtv.xst.dao.inv.IInventoryMovementPendingDetail;
/*      */ import dtv.xst.dao.inv.IInventoryMovementPendingProperty;
/*      */ import dtv.xst.dao.inv.IInventoryTransactionDetail;
/*      */ import dtv.xst.dao.inv.InventoryMovementPendingPropertyId;
/*      */ import dtv.xst.dao.itm.IItem;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class InventoryMovementPendingModel extends InventoryMovementPendingBaseModel implements IInventoryMovementPending {
/*      */   private static final long serialVersionUID = -313774836L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IInventoryMovementPendingDetail> _movementPendingDetails;
/*      */   private transient HistoricalList<IInventoryMovementPendingDetail> _movementPendingDetailsSavepoint;
/*      */   private IItem _item;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient IItem _itemSavepoint; private ISaleReturnLineItem _saleLineItem; private transient ISaleReturnLineItem _saleLineItemSavepoint; private IInventoryTransactionDetail _inventoryTransactionDetail; private transient IInventoryTransactionDetail _inventoryTransactionDetailSavepoint; private HistoricalList<IInventoryMovementPendingProperty> _properties; private transient HistoricalList<IInventoryMovementPendingProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new InventoryMovementPendingDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InventoryMovementPendingDAO getDAO_() {
/*   50 */     return (InventoryMovementPendingDAO)this._daoImpl;
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
/*   74 */       this._events.post(IInventoryMovementPending.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   87 */       if (this._movementPendingDetails != null) {
/*      */         
/*   89 */         Iterator<InventoryMovementPendingDetailModel> it = this._movementPendingDetails.iterator();
/*   90 */         while (it.hasNext())
/*      */         {
/*   92 */           ((InventoryMovementPendingDetailModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   95 */       if (this._properties != null) {
/*      */         
/*   97 */         Iterator<InventoryMovementPendingPropertyModel> it = this._properties.iterator();
/*   98 */         while (it.hasNext())
/*      */         {
/*  100 */           ((InventoryMovementPendingPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  105 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  113 */     if (getDAO_().getRetailLocationId() != null) {
/*  114 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  117 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  126 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  127 */       this._events != null && 
/*  128 */       postEventsForChanges()) {
/*  129 */       this._events.post(IInventoryMovementPending.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  136 */     boolean ev_postable = false;
/*      */     
/*  138 */     if ((getDAO_().getRetailLocationId() == null && Long.valueOf(argRetailLocationId) != null) || (
/*  139 */       getDAO_().getRetailLocationId() != null && !getDAO_().getRetailLocationId().equals(Long.valueOf(argRetailLocationId)))) {
/*  140 */       getDAO_().setRetailLocationId(Long.valueOf(argRetailLocationId));
/*  141 */       ev_postable = true;
/*  142 */       if (this._movementPendingDetails != null) {
/*      */         
/*  144 */         Iterator<InventoryMovementPendingDetailModel> it = this._movementPendingDetails.iterator();
/*  145 */         while (it.hasNext())
/*      */         {
/*  147 */           ((InventoryMovementPendingDetailModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  150 */       if (this._properties != null) {
/*      */         
/*  152 */         Iterator<InventoryMovementPendingPropertyModel> it = this._properties.iterator();
/*  153 */         while (it.hasNext())
/*      */         {
/*  155 */           ((InventoryMovementPendingPropertyModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  160 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  168 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  176 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  177 */       this._events != null && 
/*  178 */       postEventsForChanges()) {
/*  179 */       this._events.post(IInventoryMovementPending.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  186 */     boolean ev_postable = false;
/*      */     
/*  188 */     if ((getDAO_().getBusinessDate() == null && argBusinessDate != null) || (
/*  189 */       getDAO_().getBusinessDate() != null && !getDAO_().getBusinessDate().equals(argBusinessDate))) {
/*  190 */       getDAO_().setBusinessDate(argBusinessDate);
/*  191 */       ev_postable = true;
/*  192 */       if (this._movementPendingDetails != null) {
/*      */         
/*  194 */         Iterator<InventoryMovementPendingDetailModel> it = this._movementPendingDetails.iterator();
/*  195 */         while (it.hasNext())
/*      */         {
/*  197 */           ((InventoryMovementPendingDetailModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  200 */       if (this._properties != null) {
/*      */         
/*  202 */         Iterator<InventoryMovementPendingPropertyModel> it = this._properties.iterator();
/*  203 */         while (it.hasNext())
/*      */         {
/*  205 */           ((InventoryMovementPendingPropertyModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  210 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  218 */     if (getDAO_().getWorkstationId() != null) {
/*  219 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  222 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  231 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  232 */       this._events != null && 
/*  233 */       postEventsForChanges()) {
/*  234 */       this._events.post(IInventoryMovementPending.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  241 */     boolean ev_postable = false;
/*      */     
/*  243 */     if ((getDAO_().getWorkstationId() == null && Long.valueOf(argWorkstationId) != null) || (
/*  244 */       getDAO_().getWorkstationId() != null && !getDAO_().getWorkstationId().equals(Long.valueOf(argWorkstationId)))) {
/*  245 */       getDAO_().setWorkstationId(Long.valueOf(argWorkstationId));
/*  246 */       ev_postable = true;
/*  247 */       if (this._movementPendingDetails != null) {
/*      */         
/*  249 */         Iterator<InventoryMovementPendingDetailModel> it = this._movementPendingDetails.iterator();
/*  250 */         while (it.hasNext())
/*      */         {
/*  252 */           ((InventoryMovementPendingDetailModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  255 */       if (this._properties != null) {
/*      */         
/*  257 */         Iterator<InventoryMovementPendingPropertyModel> it = this._properties.iterator();
/*  258 */         while (it.hasNext())
/*      */         {
/*  260 */           ((InventoryMovementPendingPropertyModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  265 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  273 */     if (getDAO_().getTransactionSequence() != null) {
/*  274 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  277 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  286 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  287 */       this._events != null && 
/*  288 */       postEventsForChanges()) {
/*  289 */       this._events.post(IInventoryMovementPending.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  296 */     boolean ev_postable = false;
/*      */     
/*  298 */     if ((getDAO_().getTransactionSequence() == null && Long.valueOf(argTransactionSequence) != null) || (
/*  299 */       getDAO_().getTransactionSequence() != null && !getDAO_().getTransactionSequence().equals(Long.valueOf(argTransactionSequence)))) {
/*  300 */       getDAO_().setTransactionSequence(Long.valueOf(argTransactionSequence));
/*  301 */       ev_postable = true;
/*  302 */       if (this._movementPendingDetails != null) {
/*      */         
/*  304 */         Iterator<InventoryMovementPendingDetailModel> it = this._movementPendingDetails.iterator();
/*  305 */         while (it.hasNext())
/*      */         {
/*  307 */           ((InventoryMovementPendingDetailModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  310 */       if (this._properties != null) {
/*      */         
/*  312 */         Iterator<InventoryMovementPendingPropertyModel> it = this._properties.iterator();
/*  313 */         while (it.hasNext())
/*      */         {
/*  315 */           ((InventoryMovementPendingPropertyModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  320 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLineItemSequence() {
/*  328 */     if (getDAO_().getLineItemSequence() != null) {
/*  329 */       return getDAO_().getLineItemSequence().intValue();
/*      */     }
/*      */     
/*  332 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineItemSequence(int argLineItemSequence) {
/*  341 */     if (setLineItemSequence_noev(argLineItemSequence) && 
/*  342 */       this._events != null && 
/*  343 */       postEventsForChanges()) {
/*  344 */       this._events.post(IInventoryMovementPending.SET_LINEITEMSEQUENCE, Integer.valueOf(argLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineItemSequence_noev(int argLineItemSequence) {
/*  351 */     boolean ev_postable = false;
/*      */     
/*  353 */     if ((getDAO_().getLineItemSequence() == null && Integer.valueOf(argLineItemSequence) != null) || (
/*  354 */       getDAO_().getLineItemSequence() != null && !getDAO_().getLineItemSequence().equals(Integer.valueOf(argLineItemSequence)))) {
/*  355 */       getDAO_().setLineItemSequence(Integer.valueOf(argLineItemSequence));
/*  356 */       ev_postable = true;
/*  357 */       if (this._movementPendingDetails != null) {
/*      */         
/*  359 */         Iterator<InventoryMovementPendingDetailModel> it = this._movementPendingDetails.iterator();
/*  360 */         while (it.hasNext())
/*      */         {
/*  362 */           ((InventoryMovementPendingDetailModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
/*      */         }
/*      */       } 
/*  365 */       if (this._properties != null) {
/*      */         
/*  367 */         Iterator<InventoryMovementPendingPropertyModel> it = this._properties.iterator();
/*  368 */         while (it.hasNext())
/*      */         {
/*  370 */           ((InventoryMovementPendingPropertyModel)it.next()).setLineItemSequence_noev(argLineItemSequence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  375 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  383 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  391 */     if (setCreateDate_noev(argCreateDate) && 
/*  392 */       this._events != null && 
/*  393 */       postEventsForChanges()) {
/*  394 */       this._events.post(IInventoryMovementPending.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  401 */     boolean ev_postable = false;
/*      */     
/*  403 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  404 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  405 */       getDAO_().setCreateDate(argCreateDate);
/*  406 */       ev_postable = true;
/*      */     } 
/*      */     
/*  409 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  417 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  425 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  426 */       this._events != null && 
/*  427 */       postEventsForChanges()) {
/*  428 */       this._events.post(IInventoryMovementPending.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  435 */     boolean ev_postable = false;
/*      */     
/*  437 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  438 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  439 */       getDAO_().setCreateUserId(argCreateUserId);
/*  440 */       ev_postable = true;
/*      */     } 
/*      */     
/*  443 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  451 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  459 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  460 */       this._events != null && 
/*  461 */       postEventsForChanges()) {
/*  462 */       this._events.post(IInventoryMovementPending.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  469 */     boolean ev_postable = false;
/*      */     
/*  471 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  472 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  473 */       getDAO_().setUpdateDate(argUpdateDate);
/*  474 */       ev_postable = true;
/*      */     } 
/*      */     
/*  477 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  485 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  493 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  494 */       this._events != null && 
/*  495 */       postEventsForChanges()) {
/*  496 */       this._events.post(IInventoryMovementPending.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  503 */     boolean ev_postable = false;
/*      */     
/*  505 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  506 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  507 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  508 */       ev_postable = true;
/*      */     } 
/*      */     
/*  511 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemId() {
/*  519 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  527 */     if (setItemId_noev(argItemId) && 
/*  528 */       this._events != null && 
/*  529 */       postEventsForChanges()) {
/*  530 */       this._events.post(IInventoryMovementPending.SET_ITEMID, argItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/*  537 */     boolean ev_postable = false;
/*      */     
/*  539 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/*  540 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/*  541 */       getDAO_().setItemId(argItemId);
/*  542 */       ev_postable = true;
/*      */     } 
/*      */     
/*  545 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/*  553 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/*  561 */     if (setSerialNumber_noev(argSerialNumber) && 
/*  562 */       this._events != null && 
/*  563 */       postEventsForChanges()) {
/*  564 */       this._events.post(IInventoryMovementPending.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/*  571 */     boolean ev_postable = false;
/*      */     
/*  573 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/*  574 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/*  575 */       getDAO_().setSerialNumber(argSerialNumber);
/*  576 */       ev_postable = true;
/*      */     } 
/*      */     
/*  579 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getActionCode() {
/*  587 */     return getDAO_().getActionCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActionCode(String argActionCode) {
/*  595 */     if (setActionCode_noev(argActionCode) && 
/*  596 */       this._events != null && 
/*  597 */       postEventsForChanges()) {
/*  598 */       this._events.post(IInventoryMovementPending.SET_ACTIONCODE, argActionCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActionCode_noev(String argActionCode) {
/*  605 */     boolean ev_postable = false;
/*      */     
/*  607 */     if ((getDAO_().getActionCode() == null && argActionCode != null) || (
/*  608 */       getDAO_().getActionCode() != null && !getDAO_().getActionCode().equals(argActionCode))) {
/*  609 */       getDAO_().setActionCode(argActionCode);
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
/*      */   public BigDecimal getQuantity() {
/*  621 */     return getDAO_().getQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(BigDecimal argQuantity) {
/*  629 */     if (setQuantity_noev(argQuantity) && 
/*  630 */       this._events != null && 
/*  631 */       postEventsForChanges()) {
/*  632 */       this._events.post(IInventoryMovementPending.SET_QUANTITY, argQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/*  639 */     boolean ev_postable = false;
/*      */     
/*  641 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/*  642 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/*  643 */       getDAO_().setQuantity(argQuantity);
/*  644 */       ev_postable = true;
/*      */     } 
/*      */     
/*  647 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getReconciled() {
/*  655 */     if (getDAO_().getReconciled() != null) {
/*  656 */       return getDAO_().getReconciled().booleanValue();
/*      */     }
/*      */     
/*  659 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReconciled(boolean argReconciled) {
/*  668 */     if (setReconciled_noev(argReconciled) && 
/*  669 */       this._events != null && 
/*  670 */       postEventsForChanges()) {
/*  671 */       this._events.post(IInventoryMovementPending.SET_RECONCILED, Boolean.valueOf(argReconciled));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReconciled_noev(boolean argReconciled) {
/*  678 */     boolean ev_postable = false;
/*      */     
/*  680 */     if ((getDAO_().getReconciled() == null && Boolean.valueOf(argReconciled) != null) || (
/*  681 */       getDAO_().getReconciled() != null && !getDAO_().getReconciled().equals(Boolean.valueOf(argReconciled)))) {
/*  682 */       getDAO_().setReconciled(Boolean.valueOf(argReconciled));
/*  683 */       ev_postable = true;
/*      */     } 
/*      */     
/*  686 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/*  694 */     if (getDAO_().getVoid() != null) {
/*  695 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/*  698 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/*  707 */     if (setVoid_noev(argVoid) && 
/*  708 */       this._events != null && 
/*  709 */       postEventsForChanges()) {
/*  710 */       this._events.post(IInventoryMovementPending.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  717 */     boolean ev_postable = false;
/*      */     
/*  719 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  720 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  721 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/*  722 */       ev_postable = true;
/*      */     } 
/*      */     
/*  725 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IInventoryMovementPendingProperty newProperty(String argPropertyName) {
/*  729 */     InventoryMovementPendingPropertyId id = new InventoryMovementPendingPropertyId();
/*      */     
/*  731 */     id.setRetailLocationId(Long.valueOf(getRetailLocationId()));
/*  732 */     id.setBusinessDate(getBusinessDate());
/*  733 */     id.setWorkstationId(Long.valueOf(getWorkstationId()));
/*  734 */     id.setTransactionSequence(Long.valueOf(getTransactionSequence()));
/*  735 */     id.setLineItemSequence(Integer.valueOf(getLineItemSequence()));
/*  736 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  738 */     IInventoryMovementPendingProperty prop = (IInventoryMovementPendingProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IInventoryMovementPendingProperty.class);
/*  739 */     return prop;
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
/*      */   @Relationship(name = "MovementPendingDetails")
/*      */   public List<IInventoryMovementPendingDetail> getMovementPendingDetails() {
/*  760 */     if (this._movementPendingDetails == null) {
/*  761 */       this._movementPendingDetails = new HistoricalList(null);
/*      */     }
/*  763 */     return (List<IInventoryMovementPendingDetail>)this._movementPendingDetails;
/*      */   }
/*      */   
/*      */   public void setMovementPendingDetails(List<IInventoryMovementPendingDetail> argMovementPendingDetails) {
/*  767 */     if (this._movementPendingDetails == null) {
/*  768 */       this._movementPendingDetails = new HistoricalList(argMovementPendingDetails);
/*      */     } else {
/*  770 */       this._movementPendingDetails.setCurrentList(argMovementPendingDetails);
/*      */     } 
/*      */     
/*  773 */     for (IInventoryMovementPendingDetail child : this._movementPendingDetails) {
/*  774 */       child.setParentObject(this);
/*      */     }
/*      */ 
/*      */     
/*  778 */     for (IInventoryMovementPendingDetail child : this._movementPendingDetails) {
/*  779 */       InventoryMovementPendingDetailModel model = (InventoryMovementPendingDetailModel)child;
/*  780 */       model.setOrganizationId_noev(getOrganizationId());
/*  781 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  782 */       model.setBusinessDate_noev(getBusinessDate());
/*  783 */       model.setWorkstationId_noev(getWorkstationId());
/*  784 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  785 */       model.setLineItemSequence_noev(getLineItemSequence());
/*  786 */       if (child instanceof IDataModelImpl) {
/*  787 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  788 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  789 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  790 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  793 */       if (postEventsForChanges()) {
/*  794 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryMovementPendingDetail(IInventoryMovementPendingDetail argInventoryMovementPendingDetail) {
/*  800 */     super.addInventoryMovementPendingDetail(argInventoryMovementPendingDetail);
/*      */ 
/*      */     
/*  803 */     argInventoryMovementPendingDetail.setParentObject(this);
/*  804 */     if (this._movementPendingDetails == null) {
/*  805 */       this._movementPendingDetails = new HistoricalList(null);
/*      */     }
/*  807 */     argInventoryMovementPendingDetail.setOrganizationId(getOrganizationId());
/*  808 */     argInventoryMovementPendingDetail.setRetailLocationId(getRetailLocationId());
/*  809 */     argInventoryMovementPendingDetail.setBusinessDate(getBusinessDate());
/*  810 */     argInventoryMovementPendingDetail.setWorkstationId(getWorkstationId());
/*  811 */     argInventoryMovementPendingDetail.setTransactionSequence(getTransactionSequence());
/*  812 */     argInventoryMovementPendingDetail.setLineItemSequence(getLineItemSequence());
/*  813 */     if (argInventoryMovementPendingDetail instanceof IDataModelImpl) {
/*  814 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryMovementPendingDetail).getDAO();
/*  815 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  816 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  817 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  822 */     if (postEventsForChanges()) {
/*  823 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPendingDetail));
/*      */     }
/*      */     
/*  826 */     this._movementPendingDetails.add(argInventoryMovementPendingDetail);
/*  827 */     if (postEventsForChanges()) {
/*  828 */       this._events.post(IInventoryMovementPending.ADD_MOVEMENTPENDINGDETAILS, argInventoryMovementPendingDetail);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryMovementPendingDetail(IInventoryMovementPendingDetail argInventoryMovementPendingDetail) {
/*  833 */     if (this._movementPendingDetails != null) {
/*      */       
/*  835 */       if (postEventsForChanges()) {
/*  836 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPendingDetail));
/*      */       }
/*  838 */       this._movementPendingDetails.remove(argInventoryMovementPendingDetail);
/*      */       
/*  840 */       argInventoryMovementPendingDetail.setParentObject(null);
/*  841 */       if (postEventsForChanges()) {
/*  842 */         this._events.post(IInventoryMovementPending.REMOVE_MOVEMENTPENDINGDETAILS, argInventoryMovementPendingDetail);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Item")
/*      */   public IItem getItem() {
/*  849 */     return this._item;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setItem(IItem argItem) {
/*  854 */     if (argItem == null) {
/*      */       
/*  856 */       getDAO_().setItemId(null);
/*  857 */       if (this._item != null)
/*      */       {
/*  859 */         if (postEventsForChanges()) {
/*  860 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/*  865 */       getDAO_().setItemId(argItem.getItemId());
/*      */       
/*  867 */       if (postEventsForChanges()) {
/*  868 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*      */       }
/*      */     } 
/*      */     
/*  872 */     this._item = argItem;
/*  873 */     if (postEventsForChanges()) {
/*  874 */       this._events.post(IInventoryMovementPending.SET_ITEM, argItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "SaleLineItem")
/*      */   public ISaleReturnLineItem getSaleLineItem() {
/*  880 */     return this._saleLineItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSaleLineItem(ISaleReturnLineItem argSaleLineItem) {
/*  885 */     if (argSaleLineItem == null) {
/*      */       
/*  887 */       if (this._saleLineItem != null) {
/*  888 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*      */       
/*  891 */       if (this._saleLineItem != null)
/*      */       {
/*  893 */         if (postEventsForChanges()) {
/*  894 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._saleLineItem));
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/*  900 */     else if (postEventsForChanges()) {
/*  901 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleLineItem));
/*      */     } 
/*      */ 
/*      */     
/*  905 */     this._saleLineItem = argSaleLineItem;
/*  906 */     if (postEventsForChanges()) {
/*  907 */       this._events.post(IInventoryMovementPending.SET_SALELINEITEM, argSaleLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "InventoryTransactionDetail")
/*      */   public IInventoryTransactionDetail getInventoryTransactionDetail() {
/*  913 */     return this._inventoryTransactionDetail;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInventoryTransactionDetail(IInventoryTransactionDetail argInventoryTransactionDetail) {
/*  918 */     if (argInventoryTransactionDetail == null) {
/*      */       
/*  920 */       if (this._inventoryTransactionDetail != null) {
/*  921 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*      */       
/*  924 */       if (this._inventoryTransactionDetail != null)
/*      */       {
/*  926 */         if (postEventsForChanges()) {
/*  927 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._inventoryTransactionDetail));
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/*  933 */     else if (postEventsForChanges()) {
/*  934 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryTransactionDetail));
/*      */     } 
/*      */ 
/*      */     
/*  938 */     this._inventoryTransactionDetail = argInventoryTransactionDetail;
/*  939 */     if (postEventsForChanges()) {
/*  940 */       this._events.post(IInventoryMovementPending.SET_INVENTORYTRANSACTIONDETAIL, argInventoryTransactionDetail);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IInventoryMovementPendingProperty> getProperties() {
/*  946 */     if (this._properties == null) {
/*  947 */       this._properties = new HistoricalList(null);
/*      */     }
/*  949 */     return (List<IInventoryMovementPendingProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IInventoryMovementPendingProperty> argProperties) {
/*  953 */     if (this._properties == null) {
/*  954 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/*  956 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/*  959 */     for (IInventoryMovementPendingProperty child : this._properties) {
/*  960 */       InventoryMovementPendingPropertyModel model = (InventoryMovementPendingPropertyModel)child;
/*  961 */       model.setOrganizationId_noev(getOrganizationId());
/*  962 */       model.setRetailLocationId_noev(getRetailLocationId());
/*  963 */       model.setBusinessDate_noev(getBusinessDate());
/*  964 */       model.setWorkstationId_noev(getWorkstationId());
/*  965 */       model.setTransactionSequence_noev(getTransactionSequence());
/*  966 */       model.setLineItemSequence_noev(getLineItemSequence());
/*  967 */       if (child instanceof IDataModelImpl) {
/*  968 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/*  969 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  970 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  971 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/*  974 */       if (postEventsForChanges()) {
/*  975 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryMovementPendingProperty(IInventoryMovementPendingProperty argInventoryMovementPendingProperty) {
/*  981 */     if (this._properties == null) {
/*  982 */       this._properties = new HistoricalList(null);
/*      */     }
/*  984 */     argInventoryMovementPendingProperty.setOrganizationId(getOrganizationId());
/*  985 */     argInventoryMovementPendingProperty.setRetailLocationId(getRetailLocationId());
/*  986 */     argInventoryMovementPendingProperty.setBusinessDate(getBusinessDate());
/*  987 */     argInventoryMovementPendingProperty.setWorkstationId(getWorkstationId());
/*  988 */     argInventoryMovementPendingProperty.setTransactionSequence(getTransactionSequence());
/*  989 */     argInventoryMovementPendingProperty.setLineItemSequence(getLineItemSequence());
/*  990 */     if (argInventoryMovementPendingProperty instanceof IDataModelImpl) {
/*  991 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryMovementPendingProperty).getDAO();
/*  992 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/*  993 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/*  994 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  999 */     if (postEventsForChanges()) {
/* 1000 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPendingProperty));
/*      */     }
/*      */     
/* 1003 */     this._properties.add(argInventoryMovementPendingProperty);
/* 1004 */     if (postEventsForChanges()) {
/* 1005 */       this._events.post(IInventoryMovementPending.ADD_PROPERTIES, argInventoryMovementPendingProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryMovementPendingProperty(IInventoryMovementPendingProperty argInventoryMovementPendingProperty) {
/* 1010 */     if (this._properties != null) {
/*      */       
/* 1012 */       if (postEventsForChanges()) {
/* 1013 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryMovementPendingProperty));
/*      */       }
/* 1015 */       this._properties.remove(argInventoryMovementPendingProperty);
/* 1016 */       if (postEventsForChanges()) {
/* 1017 */         this._events.post(IInventoryMovementPending.REMOVE_PROPERTIES, argInventoryMovementPendingProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1024 */     if ("MovementPendingDetails".equals(argFieldId)) {
/* 1025 */       return getMovementPendingDetails();
/*      */     }
/* 1027 */     if ("Item".equals(argFieldId)) {
/* 1028 */       return getItem();
/*      */     }
/* 1030 */     if ("SaleLineItem".equals(argFieldId)) {
/* 1031 */       return getSaleLineItem();
/*      */     }
/* 1033 */     if ("InventoryTransactionDetail".equals(argFieldId)) {
/* 1034 */       return getInventoryTransactionDetail();
/*      */     }
/* 1036 */     if ("Properties".equals(argFieldId)) {
/* 1037 */       return getProperties();
/*      */     }
/* 1039 */     if ("InventoryMovementPendingExtension".equals(argFieldId)) {
/* 1040 */       return this._myExtension;
/*      */     }
/*      */     
/* 1043 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1049 */     if ("MovementPendingDetails".equals(argFieldId)) {
/* 1050 */       setMovementPendingDetails(changeToList(argValue, IInventoryMovementPendingDetail.class));
/*      */     }
/* 1052 */     else if ("Item".equals(argFieldId)) {
/* 1053 */       setItem((IItem)argValue);
/*      */     }
/* 1055 */     else if ("SaleLineItem".equals(argFieldId)) {
/* 1056 */       setSaleLineItem((ISaleReturnLineItem)argValue);
/*      */     }
/* 1058 */     else if ("InventoryTransactionDetail".equals(argFieldId)) {
/* 1059 */       setInventoryTransactionDetail((IInventoryTransactionDetail)argValue);
/*      */     }
/* 1061 */     else if ("Properties".equals(argFieldId)) {
/* 1062 */       setProperties(changeToList(argValue, IInventoryMovementPendingProperty.class));
/*      */     }
/* 1064 */     else if ("InventoryMovementPendingExtension".equals(argFieldId)) {
/* 1065 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1068 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1074 */     this._persistenceDefaults = argPD;
/* 1075 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1076 */     this._eventManager = argEM;
/* 1077 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1078 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1079 */     if (this._movementPendingDetails != null) {
/* 1080 */       for (IInventoryMovementPendingDetail relationship : this._movementPendingDetails) {
/* 1081 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1084 */     if (this._item != null) {
/* 1085 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*      */     }
/* 1087 */     if (this._saleLineItem != null) {
/* 1088 */       ((IDataModelImpl)this._saleLineItem).setDependencies(argPD, argEM);
/*      */     }
/* 1090 */     if (this._inventoryTransactionDetail != null) {
/* 1091 */       ((IDataModelImpl)this._inventoryTransactionDetail).setDependencies(argPD, argEM);
/*      */     }
/* 1093 */     if (this._properties != null) {
/* 1094 */       for (IInventoryMovementPendingProperty relationship : this._properties) {
/* 1095 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getInventoryMovementPendingExt() {
/* 1101 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setInventoryMovementPendingExt(IDataModel argExt) {
/* 1105 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1110 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1114 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1117 */     super.startTransaction();
/*      */     
/* 1119 */     this._movementPendingDetailsSavepoint = this._movementPendingDetails;
/* 1120 */     if (this._movementPendingDetails != null) {
/* 1121 */       this._movementPendingDetailsSavepoint = new HistoricalList((List)this._movementPendingDetails);
/* 1122 */       Iterator<IDataModel> it = this._movementPendingDetails.iterator();
/* 1123 */       while (it.hasNext()) {
/* 1124 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1128 */     this._itemSavepoint = this._item;
/* 1129 */     if (this._item != null) {
/* 1130 */       this._item.startTransaction();
/*      */     }
/*      */     
/* 1133 */     this._saleLineItemSavepoint = this._saleLineItem;
/* 1134 */     if (this._saleLineItem != null) {
/* 1135 */       this._saleLineItem.startTransaction();
/*      */     }
/*      */     
/* 1138 */     this._inventoryTransactionDetailSavepoint = this._inventoryTransactionDetail;
/* 1139 */     if (this._inventoryTransactionDetail != null) {
/* 1140 */       this._inventoryTransactionDetail.startTransaction();
/*      */     }
/*      */     
/* 1143 */     this._propertiesSavepoint = this._properties;
/* 1144 */     if (this._properties != null) {
/* 1145 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1146 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1147 */       while (it.hasNext()) {
/* 1148 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1153 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1158 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1161 */     super.rollbackChanges();
/*      */     
/* 1163 */     this._movementPendingDetails = this._movementPendingDetailsSavepoint;
/* 1164 */     this._movementPendingDetailsSavepoint = null;
/* 1165 */     if (this._movementPendingDetails != null) {
/* 1166 */       Iterator<IDataModel> it = this._movementPendingDetails.iterator();
/* 1167 */       while (it.hasNext()) {
/* 1168 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1172 */     this._item = this._itemSavepoint;
/* 1173 */     this._itemSavepoint = null;
/* 1174 */     if (this._item != null) {
/* 1175 */       this._item.rollbackChanges();
/*      */     }
/*      */     
/* 1178 */     this._saleLineItem = this._saleLineItemSavepoint;
/* 1179 */     this._saleLineItemSavepoint = null;
/* 1180 */     if (this._saleLineItem != null) {
/* 1181 */       this._saleLineItem.rollbackChanges();
/*      */     }
/*      */     
/* 1184 */     this._inventoryTransactionDetail = this._inventoryTransactionDetailSavepoint;
/* 1185 */     this._inventoryTransactionDetailSavepoint = null;
/* 1186 */     if (this._inventoryTransactionDetail != null) {
/* 1187 */       this._inventoryTransactionDetail.rollbackChanges();
/*      */     }
/*      */     
/* 1190 */     this._properties = this._propertiesSavepoint;
/* 1191 */     this._propertiesSavepoint = null;
/* 1192 */     if (this._properties != null) {
/* 1193 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1194 */       while (it.hasNext()) {
/* 1195 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1203 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1206 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1209 */     super.commitTransaction();
/*      */     
/* 1211 */     this._movementPendingDetailsSavepoint = this._movementPendingDetails;
/* 1212 */     if (this._movementPendingDetails != null) {
/* 1213 */       Iterator<IDataModel> it = this._movementPendingDetails.iterator();
/* 1214 */       while (it.hasNext()) {
/* 1215 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1217 */       this._movementPendingDetails = new HistoricalList((List)this._movementPendingDetails);
/*      */     } 
/*      */     
/* 1220 */     this._itemSavepoint = this._item;
/* 1221 */     if (this._item != null) {
/* 1222 */       this._item.commitTransaction();
/*      */     }
/*      */     
/* 1225 */     this._saleLineItemSavepoint = this._saleLineItem;
/* 1226 */     if (this._saleLineItem != null) {
/* 1227 */       this._saleLineItem.commitTransaction();
/*      */     }
/*      */     
/* 1230 */     this._inventoryTransactionDetailSavepoint = this._inventoryTransactionDetail;
/* 1231 */     if (this._inventoryTransactionDetail != null) {
/* 1232 */       this._inventoryTransactionDetail.commitTransaction();
/*      */     }
/*      */     
/* 1235 */     this._propertiesSavepoint = this._properties;
/* 1236 */     if (this._properties != null) {
/* 1237 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1238 */       while (it.hasNext()) {
/* 1239 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1241 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1245 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */