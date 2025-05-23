/*      */ package dtv.xst.dao.xom.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.xom.ICustomerModifier;
/*      */ import dtv.xst.dao.xom.IOrder;
/*      */ import dtv.xst.dao.xom.IOrderFee;
/*      */ import dtv.xst.dao.xom.IOrderLine;
/*      */ import dtv.xst.dao.xom.IOrderPayment;
/*      */ import dtv.xst.dao.xom.IOrderProperty;
/*      */ import dtv.xst.dao.xom.OrderPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class OrderModel extends OrderBaseModel implements IOrder {
/*      */   private static final long serialVersionUID = 76453678L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private ICustomerModifier _customer;
/*      */   private transient ICustomerModifier _customerSavepoint;
/*      */   private HistoricalList<IOrderPayment> _payments;
/*      */   
/*      */   public String toString() {
/*   35 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient HistoricalList<IOrderPayment> _paymentsSavepoint; private HistoricalList<IOrderFee> _fees; private transient HistoricalList<IOrderFee> _feesSavepoint; private HistoricalList<IOrderLine> _orderLines; private transient HistoricalList<IOrderLine> _orderLinesSavepoint; private HistoricalList<IOrderProperty> _properties; private transient HistoricalList<IOrderProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   40 */     setDAO((IDataAccessObject)new OrderDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private OrderDAO getDAO_() {
/*   48 */     return (OrderDAO)this._daoImpl;
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
/*   72 */       this._events.post(IOrder.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
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
/*   85 */       if (this._payments != null) {
/*      */         
/*   87 */         Iterator<OrderPaymentModel> it = this._payments.iterator();
/*   88 */         while (it.hasNext())
/*      */         {
/*   90 */           ((OrderPaymentModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   93 */       if (this._fees != null) {
/*      */         
/*   95 */         Iterator<OrderFeeModel> it = this._fees.iterator();
/*   96 */         while (it.hasNext())
/*      */         {
/*   98 */           ((OrderFeeModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  101 */       if (this._orderLines != null) {
/*      */         
/*  103 */         Iterator<OrderLineModel> it = this._orderLines.iterator();
/*  104 */         while (it.hasNext())
/*      */         {
/*  106 */           ((OrderLineModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  109 */       if (this._properties != null) {
/*      */         
/*  111 */         Iterator<OrderPropertyModel> it = this._properties.iterator();
/*  112 */         while (it.hasNext())
/*      */         {
/*  114 */           ((OrderPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  117 */       if (this._customer != null)
/*      */       {
/*      */         
/*  120 */         ((CustomerModifierModel)this._customer).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */     
/*  124 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrderId() {
/*  132 */     return getDAO_().getOrderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderId(String argOrderId) {
/*  140 */     if (setOrderId_noev(argOrderId) && 
/*  141 */       this._events != null && 
/*  142 */       postEventsForChanges()) {
/*  143 */       this._events.post(IOrder.SET_ORDERID, argOrderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderId_noev(String argOrderId) {
/*  150 */     boolean ev_postable = false;
/*      */     
/*  152 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/*  153 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/*  154 */       getDAO_().setOrderId(argOrderId);
/*  155 */       ev_postable = true;
/*  156 */       if (this._payments != null) {
/*      */         
/*  158 */         Iterator<OrderPaymentModel> it = this._payments.iterator();
/*  159 */         while (it.hasNext())
/*      */         {
/*  161 */           ((OrderPaymentModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  164 */       if (this._fees != null) {
/*      */         
/*  166 */         Iterator<OrderFeeModel> it = this._fees.iterator();
/*  167 */         while (it.hasNext())
/*      */         {
/*  169 */           ((OrderFeeModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  172 */       if (this._orderLines != null) {
/*      */         
/*  174 */         Iterator<OrderLineModel> it = this._orderLines.iterator();
/*  175 */         while (it.hasNext())
/*      */         {
/*  177 */           ((OrderLineModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  180 */       if (this._properties != null) {
/*      */         
/*  182 */         Iterator<OrderPropertyModel> it = this._properties.iterator();
/*  183 */         while (it.hasNext())
/*      */         {
/*  185 */           ((OrderPropertyModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  188 */       if (this._customer != null)
/*      */       {
/*      */         
/*  191 */         ((CustomerModifierModel)this._customer).setOrderId_noev(argOrderId);
/*      */       }
/*      */     } 
/*      */     
/*  195 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  203 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  211 */     if (setCreateDate_noev(argCreateDate) && 
/*  212 */       this._events != null && 
/*  213 */       postEventsForChanges()) {
/*  214 */       this._events.post(IOrder.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  221 */     boolean ev_postable = false;
/*      */     
/*  223 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  224 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  225 */       getDAO_().setCreateDate(argCreateDate);
/*  226 */       ev_postable = true;
/*      */     } 
/*      */     
/*  229 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  237 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  245 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  246 */       this._events != null && 
/*  247 */       postEventsForChanges()) {
/*  248 */       this._events.post(IOrder.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  255 */     boolean ev_postable = false;
/*      */     
/*  257 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  258 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  259 */       getDAO_().setCreateUserId(argCreateUserId);
/*  260 */       ev_postable = true;
/*      */     } 
/*      */     
/*  263 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  271 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  279 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  280 */       this._events != null && 
/*  281 */       postEventsForChanges()) {
/*  282 */       this._events.post(IOrder.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  289 */     boolean ev_postable = false;
/*      */     
/*  291 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  292 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  293 */       getDAO_().setUpdateDate(argUpdateDate);
/*  294 */       ev_postable = true;
/*      */     } 
/*      */     
/*  297 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  305 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  313 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  314 */       this._events != null && 
/*  315 */       postEventsForChanges()) {
/*  316 */       this._events.post(IOrder.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  323 */     boolean ev_postable = false;
/*      */     
/*  325 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  326 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  327 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  328 */       ev_postable = true;
/*      */     } 
/*      */     
/*  331 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrderType() {
/*  339 */     return getDAO_().getOrderType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderType(String argOrderType) {
/*  347 */     if (setOrderType_noev(argOrderType) && 
/*  348 */       this._events != null && 
/*  349 */       postEventsForChanges()) {
/*  350 */       this._events.post(IOrder.SET_ORDERTYPE, argOrderType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderType_noev(String argOrderType) {
/*  357 */     boolean ev_postable = false;
/*      */     
/*  359 */     if ((getDAO_().getOrderType() == null && argOrderType != null) || (
/*  360 */       getDAO_().getOrderType() != null && !getDAO_().getOrderType().equals(argOrderType))) {
/*  361 */       getDAO_().setOrderType(argOrderType);
/*  362 */       ev_postable = true;
/*      */     } 
/*      */     
/*  365 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCode() {
/*  373 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  381 */     if (setStatusCode_noev(argStatusCode) && 
/*  382 */       this._events != null && 
/*  383 */       postEventsForChanges()) {
/*  384 */       this._events.post(IOrder.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  391 */     boolean ev_postable = false;
/*      */     
/*  393 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  394 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  395 */       getDAO_().setStatusCode(argStatusCode);
/*  396 */       ev_postable = true;
/*      */     } 
/*      */     
/*  399 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getOrderDate() {
/*  407 */     return getDAO_().getOrderDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderDate(Date argOrderDate) {
/*  415 */     if (setOrderDate_noev(argOrderDate) && 
/*  416 */       this._events != null && 
/*  417 */       postEventsForChanges()) {
/*  418 */       this._events.post(IOrder.SET_ORDERDATE, argOrderDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderDate_noev(Date argOrderDate) {
/*  425 */     boolean ev_postable = false;
/*      */     
/*  427 */     if ((getDAO_().getOrderDate() == null && argOrderDate != null) || (
/*  428 */       getDAO_().getOrderDate() != null && !getDAO_().getOrderDate().equals(argOrderDate))) {
/*  429 */       getDAO_().setOrderDate(argOrderDate);
/*  430 */       ev_postable = true;
/*      */     } 
/*      */     
/*  433 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrderLocationId() {
/*  441 */     return getDAO_().getOrderLocationId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderLocationId(String argOrderLocationId) {
/*  449 */     if (setOrderLocationId_noev(argOrderLocationId) && 
/*  450 */       this._events != null && 
/*  451 */       postEventsForChanges()) {
/*  452 */       this._events.post(IOrder.SET_ORDERLOCATIONID, argOrderLocationId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderLocationId_noev(String argOrderLocationId) {
/*  459 */     boolean ev_postable = false;
/*      */     
/*  461 */     if ((getDAO_().getOrderLocationId() == null && argOrderLocationId != null) || (
/*  462 */       getDAO_().getOrderLocationId() != null && !getDAO_().getOrderLocationId().equals(argOrderLocationId))) {
/*  463 */       getDAO_().setOrderLocationId(argOrderLocationId);
/*  464 */       ev_postable = true;
/*      */     } 
/*      */     
/*  467 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getSubtotal() {
/*  475 */     return getDAO_().getSubtotal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubtotal(BigDecimal argSubtotal) {
/*  483 */     if (setSubtotal_noev(argSubtotal) && 
/*  484 */       this._events != null && 
/*  485 */       postEventsForChanges()) {
/*  486 */       this._events.post(IOrder.SET_SUBTOTAL, argSubtotal);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSubtotal_noev(BigDecimal argSubtotal) {
/*  493 */     boolean ev_postable = false;
/*      */     
/*  495 */     if ((getDAO_().getSubtotal() == null && argSubtotal != null) || (
/*  496 */       getDAO_().getSubtotal() != null && !getDAO_().getSubtotal().equals(argSubtotal))) {
/*  497 */       getDAO_().setSubtotal(argSubtotal);
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
/*      */   public BigDecimal getTaxAmount() {
/*  509 */     return getDAO_().getTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxAmount(BigDecimal argTaxAmount) {
/*  517 */     if (setTaxAmount_noev(argTaxAmount) && 
/*  518 */       this._events != null && 
/*  519 */       postEventsForChanges()) {
/*  520 */       this._events.post(IOrder.SET_TAXAMOUNT, argTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/*  527 */     boolean ev_postable = false;
/*      */     
/*  529 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/*  530 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/*  531 */       getDAO_().setTaxAmount(argTaxAmount);
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
/*      */   public BigDecimal getTotal() {
/*  543 */     return getDAO_().getTotal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTotal(BigDecimal argTotal) {
/*  551 */     if (setTotal_noev(argTotal) && 
/*  552 */       this._events != null && 
/*  553 */       postEventsForChanges()) {
/*  554 */       this._events.post(IOrder.SET_TOTAL, argTotal);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTotal_noev(BigDecimal argTotal) {
/*  561 */     boolean ev_postable = false;
/*      */     
/*  563 */     if ((getDAO_().getTotal() == null && argTotal != null) || (
/*  564 */       getDAO_().getTotal() != null && !getDAO_().getTotal().equals(argTotal))) {
/*  565 */       getDAO_().setTotal(argTotal);
/*  566 */       ev_postable = true;
/*      */     } 
/*      */     
/*  569 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBalanceDue() {
/*  577 */     return getDAO_().getBalanceDue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBalanceDue(BigDecimal argBalanceDue) {
/*  585 */     if (setBalanceDue_noev(argBalanceDue) && 
/*  586 */       this._events != null && 
/*  587 */       postEventsForChanges()) {
/*  588 */       this._events.post(IOrder.SET_BALANCEDUE, argBalanceDue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBalanceDue_noev(BigDecimal argBalanceDue) {
/*  595 */     boolean ev_postable = false;
/*      */     
/*  597 */     if ((getDAO_().getBalanceDue() == null && argBalanceDue != null) || (
/*  598 */       getDAO_().getBalanceDue() != null && !getDAO_().getBalanceDue().equals(argBalanceDue))) {
/*  599 */       getDAO_().setBalanceDue(argBalanceDue);
/*  600 */       ev_postable = true;
/*      */     } 
/*      */     
/*  603 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNotes() {
/*  611 */     return getDAO_().getNotes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotes(String argNotes) {
/*  619 */     if (setNotes_noev(argNotes) && 
/*  620 */       this._events != null && 
/*  621 */       postEventsForChanges()) {
/*  622 */       this._events.post(IOrder.SET_NOTES, argNotes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotes_noev(String argNotes) {
/*  629 */     boolean ev_postable = false;
/*      */     
/*  631 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/*  632 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/*  633 */       getDAO_().setNotes(argNotes);
/*  634 */       ev_postable = true;
/*      */     } 
/*      */     
/*  637 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReferenceNumber() {
/*  645 */     return getDAO_().getReferenceNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReferenceNumber(String argReferenceNumber) {
/*  653 */     if (setReferenceNumber_noev(argReferenceNumber) && 
/*  654 */       this._events != null && 
/*  655 */       postEventsForChanges()) {
/*  656 */       this._events.post(IOrder.SET_REFERENCENUMBER, argReferenceNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReferenceNumber_noev(String argReferenceNumber) {
/*  663 */     boolean ev_postable = false;
/*      */     
/*  665 */     if ((getDAO_().getReferenceNumber() == null && argReferenceNumber != null) || (
/*  666 */       getDAO_().getReferenceNumber() != null && !getDAO_().getReferenceNumber().equals(argReferenceNumber))) {
/*  667 */       getDAO_().setReferenceNumber(argReferenceNumber);
/*  668 */       ev_postable = true;
/*      */     } 
/*      */     
/*  671 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAdditionalFreightCharges() {
/*  679 */     return getDAO_().getAdditionalFreightCharges();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdditionalFreightCharges(BigDecimal argAdditionalFreightCharges) {
/*  687 */     if (setAdditionalFreightCharges_noev(argAdditionalFreightCharges) && 
/*  688 */       this._events != null && 
/*  689 */       postEventsForChanges()) {
/*  690 */       this._events.post(IOrder.SET_ADDITIONALFREIGHTCHARGES, argAdditionalFreightCharges);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAdditionalFreightCharges_noev(BigDecimal argAdditionalFreightCharges) {
/*  697 */     boolean ev_postable = false;
/*      */     
/*  699 */     if ((getDAO_().getAdditionalFreightCharges() == null && argAdditionalFreightCharges != null) || (
/*  700 */       getDAO_().getAdditionalFreightCharges() != null && !getDAO_().getAdditionalFreightCharges().equals(argAdditionalFreightCharges))) {
/*  701 */       getDAO_().setAdditionalFreightCharges(argAdditionalFreightCharges);
/*  702 */       ev_postable = true;
/*      */     } 
/*      */     
/*  705 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAdditionalCharges() {
/*  713 */     return getDAO_().getAdditionalCharges();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdditionalCharges(BigDecimal argAdditionalCharges) {
/*  721 */     if (setAdditionalCharges_noev(argAdditionalCharges) && 
/*  722 */       this._events != null && 
/*  723 */       postEventsForChanges()) {
/*  724 */       this._events.post(IOrder.SET_ADDITIONALCHARGES, argAdditionalCharges);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAdditionalCharges_noev(BigDecimal argAdditionalCharges) {
/*  731 */     boolean ev_postable = false;
/*      */     
/*  733 */     if ((getDAO_().getAdditionalCharges() == null && argAdditionalCharges != null) || (
/*  734 */       getDAO_().getAdditionalCharges() != null && !getDAO_().getAdditionalCharges().equals(argAdditionalCharges))) {
/*  735 */       getDAO_().setAdditionalCharges(argAdditionalCharges);
/*  736 */       ev_postable = true;
/*      */     } 
/*      */     
/*  739 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getShipComplete() {
/*  747 */     if (getDAO_().getShipComplete() != null) {
/*  748 */       return getDAO_().getShipComplete().booleanValue();
/*      */     }
/*      */     
/*  751 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipComplete(boolean argShipComplete) {
/*  760 */     if (setShipComplete_noev(argShipComplete) && 
/*  761 */       this._events != null && 
/*  762 */       postEventsForChanges()) {
/*  763 */       this._events.post(IOrder.SET_SHIPCOMPLETE, Boolean.valueOf(argShipComplete));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipComplete_noev(boolean argShipComplete) {
/*  770 */     boolean ev_postable = false;
/*      */     
/*  772 */     if ((getDAO_().getShipComplete() == null && Boolean.valueOf(argShipComplete) != null) || (
/*  773 */       getDAO_().getShipComplete() != null && !getDAO_().getShipComplete().equals(Boolean.valueOf(argShipComplete)))) {
/*  774 */       getDAO_().setShipComplete(Boolean.valueOf(argShipComplete));
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
/*      */   public BigDecimal getFreightTax() {
/*  786 */     return getDAO_().getFreightTax();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFreightTax(BigDecimal argFreightTax) {
/*  794 */     if (setFreightTax_noev(argFreightTax) && 
/*  795 */       this._events != null && 
/*  796 */       postEventsForChanges()) {
/*  797 */       this._events.post(IOrder.SET_FREIGHTTAX, argFreightTax);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFreightTax_noev(BigDecimal argFreightTax) {
/*  804 */     boolean ev_postable = false;
/*      */     
/*  806 */     if ((getDAO_().getFreightTax() == null && argFreightTax != null) || (
/*  807 */       getDAO_().getFreightTax() != null && !getDAO_().getFreightTax().equals(argFreightTax))) {
/*  808 */       getDAO_().setFreightTax(argFreightTax);
/*  809 */       ev_postable = true;
/*      */     } 
/*      */     
/*  812 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrderMessage() {
/*  820 */     return getDAO_().getOrderMessage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderMessage(String argOrderMessage) {
/*  828 */     if (setOrderMessage_noev(argOrderMessage) && 
/*  829 */       this._events != null && 
/*  830 */       postEventsForChanges()) {
/*  831 */       this._events.post(IOrder.SET_ORDERMESSAGE, argOrderMessage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderMessage_noev(String argOrderMessage) {
/*  838 */     boolean ev_postable = false;
/*      */     
/*  840 */     if ((getDAO_().getOrderMessage() == null && argOrderMessage != null) || (
/*  841 */       getDAO_().getOrderMessage() != null && !getDAO_().getOrderMessage().equals(argOrderMessage))) {
/*  842 */       getDAO_().setOrderMessage(argOrderMessage);
/*  843 */       ev_postable = true;
/*      */     } 
/*      */     
/*  846 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getGiftMessage() {
/*  854 */     return getDAO_().getGiftMessage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGiftMessage(String argGiftMessage) {
/*  862 */     if (setGiftMessage_noev(argGiftMessage) && 
/*  863 */       this._events != null && 
/*  864 */       postEventsForChanges()) {
/*  865 */       this._events.post(IOrder.SET_GIFTMESSAGE, argGiftMessage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGiftMessage_noev(String argGiftMessage) {
/*  872 */     boolean ev_postable = false;
/*      */     
/*  874 */     if ((getDAO_().getGiftMessage() == null && argGiftMessage != null) || (
/*  875 */       getDAO_().getGiftMessage() != null && !getDAO_().getGiftMessage().equals(argGiftMessage))) {
/*  876 */       getDAO_().setGiftMessage(argGiftMessage);
/*  877 */       ev_postable = true;
/*      */     } 
/*      */     
/*  880 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getUnderReview() {
/*  888 */     if (getDAO_().getUnderReview() != null) {
/*  889 */       return getDAO_().getUnderReview().booleanValue();
/*      */     }
/*      */     
/*  892 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnderReview(boolean argUnderReview) {
/*  901 */     if (setUnderReview_noev(argUnderReview) && 
/*  902 */       this._events != null && 
/*  903 */       postEventsForChanges()) {
/*  904 */       this._events.post(IOrder.SET_UNDERREVIEW, Boolean.valueOf(argUnderReview));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnderReview_noev(boolean argUnderReview) {
/*  911 */     boolean ev_postable = false;
/*      */     
/*  913 */     if ((getDAO_().getUnderReview() == null && Boolean.valueOf(argUnderReview) != null) || (
/*  914 */       getDAO_().getUnderReview() != null && !getDAO_().getUnderReview().equals(Boolean.valueOf(argUnderReview)))) {
/*  915 */       getDAO_().setUnderReview(Boolean.valueOf(argUnderReview));
/*  916 */       ev_postable = true;
/*      */     } 
/*      */     
/*  919 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCodeReason() {
/*  927 */     return getDAO_().getStatusCodeReason();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCodeReason(String argStatusCodeReason) {
/*  935 */     if (setStatusCodeReason_noev(argStatusCodeReason) && 
/*  936 */       this._events != null && 
/*  937 */       postEventsForChanges()) {
/*  938 */       this._events.post(IOrder.SET_STATUSCODEREASON, argStatusCodeReason);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCodeReason_noev(String argStatusCodeReason) {
/*  945 */     boolean ev_postable = false;
/*      */     
/*  947 */     if ((getDAO_().getStatusCodeReason() == null && argStatusCodeReason != null) || (
/*  948 */       getDAO_().getStatusCodeReason() != null && !getDAO_().getStatusCodeReason().equals(argStatusCodeReason))) {
/*  949 */       getDAO_().setStatusCodeReason(argStatusCodeReason);
/*  950 */       ev_postable = true;
/*      */     } 
/*      */     
/*  953 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCodeReasonNote() {
/*  961 */     return getDAO_().getStatusCodeReasonNote();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCodeReasonNote(String argStatusCodeReasonNote) {
/*  969 */     if (setStatusCodeReasonNote_noev(argStatusCodeReasonNote) && 
/*  970 */       this._events != null && 
/*  971 */       postEventsForChanges()) {
/*  972 */       this._events.post(IOrder.SET_STATUSCODEREASONNOTE, argStatusCodeReasonNote);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCodeReasonNote_noev(String argStatusCodeReasonNote) {
/*  979 */     boolean ev_postable = false;
/*      */     
/*  981 */     if ((getDAO_().getStatusCodeReasonNote() == null && argStatusCodeReasonNote != null) || (
/*  982 */       getDAO_().getStatusCodeReasonNote() != null && !getDAO_().getStatusCodeReasonNote().equals(argStatusCodeReasonNote))) {
/*  983 */       getDAO_().setStatusCodeReasonNote(argStatusCodeReasonNote);
/*  984 */       ev_postable = true;
/*      */     } 
/*      */     
/*  987 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IOrderProperty newProperty(String argPropertyName) {
/*  991 */     OrderPropertyId id = new OrderPropertyId();
/*      */     
/*  993 */     id.setOrderId(getOrderId());
/*  994 */     id.setPropertyCode(argPropertyName);
/*      */     
/*  996 */     IOrderProperty prop = (IOrderProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrderProperty.class);
/*  997 */     return prop;
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
/*      */   @Relationship(name = "Customer")
/*      */   public ICustomerModifier getCustomer() {
/* 1018 */     return this._customer;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCustomer(ICustomerModifier argCustomer) {
/* 1023 */     if (argCustomer == null) {
/*      */       
/* 1025 */       if (this._customer != null) {
/* 1026 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1028 */       if (this._customer != null) {
/*      */         
/* 1030 */         if (postEventsForChanges()) {
/* 1031 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._customer));
/*      */         }
/* 1033 */         addDeletedObject((IDataModel)this._customer);
/*      */       } 
/*      */     } else {
/*      */       
/* 1037 */       argCustomer.setOrganizationId(getOrganizationId());
/* 1038 */       argCustomer.setOrderId(getOrderId());
/*      */ 
/*      */       
/* 1041 */       argCustomer.setParentOrder(this);
/*      */ 
/*      */       
/* 1044 */       if (postEventsForChanges()) {
/* 1045 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomer));
/*      */       }
/*      */     } 
/*      */     
/* 1049 */     this._customer = argCustomer;
/* 1050 */     if (postEventsForChanges()) {
/* 1051 */       this._events.post(IOrder.SET_CUSTOMER, argCustomer);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Payments")
/*      */   public List<IOrderPayment> getPayments() {
/* 1057 */     if (this._payments == null) {
/* 1058 */       this._payments = new HistoricalList(null);
/*      */     }
/* 1060 */     return (List<IOrderPayment>)this._payments;
/*      */   }
/*      */   
/*      */   public void setPayments(List<IOrderPayment> argPayments) {
/* 1064 */     if (this._payments == null) {
/* 1065 */       this._payments = new HistoricalList(argPayments);
/*      */     } else {
/* 1067 */       this._payments.setCurrentList(argPayments);
/*      */     } 
/*      */     
/* 1070 */     for (IOrderPayment child : this._payments) {
/* 1071 */       child.setParentOrder(this);
/*      */     }
/*      */ 
/*      */     
/* 1075 */     for (IOrderPayment child : this._payments) {
/* 1076 */       OrderPaymentModel model = (OrderPaymentModel)child;
/* 1077 */       model.setOrganizationId_noev(getOrganizationId());
/* 1078 */       model.setOrderId_noev(getOrderId());
/* 1079 */       if (child instanceof IDataModelImpl) {
/* 1080 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1081 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1082 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1083 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1086 */       if (postEventsForChanges()) {
/* 1087 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addOrderPayment(IOrderPayment argOrderPayment) {
/* 1093 */     super.addOrderPayment(argOrderPayment);
/*      */ 
/*      */     
/* 1096 */     argOrderPayment.setParentOrder(this);
/* 1097 */     if (this._payments == null) {
/* 1098 */       this._payments = new HistoricalList(null);
/*      */     }
/* 1100 */     argOrderPayment.setOrganizationId(getOrganizationId());
/* 1101 */     argOrderPayment.setOrderId(getOrderId());
/* 1102 */     if (argOrderPayment instanceof IDataModelImpl) {
/* 1103 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderPayment).getDAO();
/* 1104 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1105 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1106 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1111 */     if (postEventsForChanges()) {
/* 1112 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderPayment));
/*      */     }
/*      */     
/* 1115 */     this._payments.add(argOrderPayment);
/* 1116 */     if (postEventsForChanges()) {
/* 1117 */       this._events.post(IOrder.ADD_PAYMENTS, argOrderPayment);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeOrderPayment(IOrderPayment argOrderPayment) {
/* 1122 */     if (this._payments != null) {
/*      */       
/* 1124 */       if (postEventsForChanges()) {
/* 1125 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderPayment));
/*      */       }
/* 1127 */       this._payments.remove(argOrderPayment);
/*      */       
/* 1129 */       argOrderPayment.setParentOrder(null);
/* 1130 */       if (postEventsForChanges()) {
/* 1131 */         this._events.post(IOrder.REMOVE_PAYMENTS, argOrderPayment);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Fees")
/*      */   public List<IOrderFee> getFees() {
/* 1138 */     if (this._fees == null) {
/* 1139 */       this._fees = new HistoricalList(null);
/*      */     }
/* 1141 */     return (List<IOrderFee>)this._fees;
/*      */   }
/*      */   
/*      */   public void setFees(List<IOrderFee> argFees) {
/* 1145 */     if (this._fees == null) {
/* 1146 */       this._fees = new HistoricalList(argFees);
/*      */     } else {
/* 1148 */       this._fees.setCurrentList(argFees);
/*      */     } 
/*      */     
/* 1151 */     for (IOrderFee child : this._fees) {
/* 1152 */       child.setParentOrder(this);
/*      */     }
/*      */ 
/*      */     
/* 1156 */     for (IOrderFee child : this._fees) {
/* 1157 */       OrderFeeModel model = (OrderFeeModel)child;
/* 1158 */       model.setOrganizationId_noev(getOrganizationId());
/* 1159 */       model.setOrderId_noev(getOrderId());
/* 1160 */       if (child instanceof IDataModelImpl) {
/* 1161 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1162 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1163 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1164 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1167 */       if (postEventsForChanges()) {
/* 1168 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addOrderFee(IOrderFee argOrderFee) {
/* 1174 */     super.addOrderFee(argOrderFee);
/*      */ 
/*      */     
/* 1177 */     argOrderFee.setParentOrder(this);
/* 1178 */     if (this._fees == null) {
/* 1179 */       this._fees = new HistoricalList(null);
/*      */     }
/* 1181 */     argOrderFee.setOrganizationId(getOrganizationId());
/* 1182 */     argOrderFee.setOrderId(getOrderId());
/* 1183 */     if (argOrderFee instanceof IDataModelImpl) {
/* 1184 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderFee).getDAO();
/* 1185 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1186 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1187 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1192 */     if (postEventsForChanges()) {
/* 1193 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderFee));
/*      */     }
/*      */     
/* 1196 */     this._fees.add(argOrderFee);
/* 1197 */     if (postEventsForChanges()) {
/* 1198 */       this._events.post(IOrder.ADD_FEES, argOrderFee);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeOrderFee(IOrderFee argOrderFee) {
/* 1203 */     if (this._fees != null) {
/*      */       
/* 1205 */       if (postEventsForChanges()) {
/* 1206 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderFee));
/*      */       }
/* 1208 */       this._fees.remove(argOrderFee);
/*      */       
/* 1210 */       argOrderFee.setParentOrder(null);
/* 1211 */       if (postEventsForChanges()) {
/* 1212 */         this._events.post(IOrder.REMOVE_FEES, argOrderFee);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "OrderLines")
/*      */   public List<IOrderLine> getOrderLines() {
/* 1219 */     if (this._orderLines == null) {
/* 1220 */       this._orderLines = new HistoricalList(null);
/*      */     }
/* 1222 */     return (List<IOrderLine>)this._orderLines;
/*      */   }
/*      */   
/*      */   public void setOrderLines(List<IOrderLine> argOrderLines) {
/* 1226 */     if (this._orderLines == null) {
/* 1227 */       this._orderLines = new HistoricalList(argOrderLines);
/*      */     } else {
/* 1229 */       this._orderLines.setCurrentList(argOrderLines);
/*      */     } 
/*      */     
/* 1232 */     for (IOrderLine child : this._orderLines) {
/* 1233 */       child.setParentOrder(this);
/*      */     }
/*      */ 
/*      */     
/* 1237 */     for (IOrderLine child : this._orderLines) {
/* 1238 */       OrderLineModel model = (OrderLineModel)child;
/* 1239 */       model.setOrganizationId_noev(getOrganizationId());
/* 1240 */       model.setOrderId_noev(getOrderId());
/* 1241 */       if (child instanceof IDataModelImpl) {
/* 1242 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1243 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1244 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1245 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1248 */       if (postEventsForChanges()) {
/* 1249 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addOrderLine(IOrderLine argOrderLine) {
/* 1255 */     super.addOrderLine(argOrderLine);
/*      */ 
/*      */     
/* 1258 */     argOrderLine.setParentOrder(this);
/* 1259 */     if (this._orderLines == null) {
/* 1260 */       this._orderLines = new HistoricalList(null);
/*      */     }
/* 1262 */     argOrderLine.setOrganizationId(getOrganizationId());
/* 1263 */     argOrderLine.setOrderId(getOrderId());
/* 1264 */     if (argOrderLine instanceof IDataModelImpl) {
/* 1265 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderLine).getDAO();
/* 1266 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1267 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1268 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1273 */     if (postEventsForChanges()) {
/* 1274 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderLine));
/*      */     }
/*      */     
/* 1277 */     this._orderLines.add(argOrderLine);
/* 1278 */     if (postEventsForChanges()) {
/* 1279 */       this._events.post(IOrder.ADD_ORDERLINES, argOrderLine);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeOrderLine(IOrderLine argOrderLine) {
/* 1284 */     if (this._orderLines != null) {
/*      */       
/* 1286 */       if (postEventsForChanges()) {
/* 1287 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderLine));
/*      */       }
/* 1289 */       this._orderLines.remove(argOrderLine);
/*      */       
/* 1291 */       argOrderLine.setParentOrder(null);
/* 1292 */       if (postEventsForChanges()) {
/* 1293 */         this._events.post(IOrder.REMOVE_ORDERLINES, argOrderLine);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IOrderProperty> getProperties() {
/* 1300 */     if (this._properties == null) {
/* 1301 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1303 */     return (List<IOrderProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IOrderProperty> argProperties) {
/* 1307 */     if (this._properties == null) {
/* 1308 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1310 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1313 */     for (IOrderProperty child : this._properties) {
/* 1314 */       OrderPropertyModel model = (OrderPropertyModel)child;
/* 1315 */       model.setOrganizationId_noev(getOrganizationId());
/* 1316 */       model.setOrderId_noev(getOrderId());
/* 1317 */       if (child instanceof IDataModelImpl) {
/* 1318 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1319 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1320 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1321 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1324 */       if (postEventsForChanges()) {
/* 1325 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addOrderProperty(IOrderProperty argOrderProperty) {
/* 1331 */     if (this._properties == null) {
/* 1332 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1334 */     argOrderProperty.setOrganizationId(getOrganizationId());
/* 1335 */     argOrderProperty.setOrderId(getOrderId());
/* 1336 */     if (argOrderProperty instanceof IDataModelImpl) {
/* 1337 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderProperty).getDAO();
/* 1338 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1339 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1340 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1345 */     if (postEventsForChanges()) {
/* 1346 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderProperty));
/*      */     }
/*      */     
/* 1349 */     this._properties.add(argOrderProperty);
/* 1350 */     if (postEventsForChanges()) {
/* 1351 */       this._events.post(IOrder.ADD_PROPERTIES, argOrderProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeOrderProperty(IOrderProperty argOrderProperty) {
/* 1356 */     if (this._properties != null) {
/*      */       
/* 1358 */       if (postEventsForChanges()) {
/* 1359 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderProperty));
/*      */       }
/* 1361 */       this._properties.remove(argOrderProperty);
/* 1362 */       if (postEventsForChanges()) {
/* 1363 */         this._events.post(IOrder.REMOVE_PROPERTIES, argOrderProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1370 */     if ("Customer".equals(argFieldId)) {
/* 1371 */       return getCustomer();
/*      */     }
/* 1373 */     if ("Payments".equals(argFieldId)) {
/* 1374 */       return getPayments();
/*      */     }
/* 1376 */     if ("Fees".equals(argFieldId)) {
/* 1377 */       return getFees();
/*      */     }
/* 1379 */     if ("OrderLines".equals(argFieldId)) {
/* 1380 */       return getOrderLines();
/*      */     }
/* 1382 */     if ("Properties".equals(argFieldId)) {
/* 1383 */       return getProperties();
/*      */     }
/* 1385 */     if ("OrderExtension".equals(argFieldId)) {
/* 1386 */       return this._myExtension;
/*      */     }
/*      */     
/* 1389 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1395 */     if ("Customer".equals(argFieldId)) {
/* 1396 */       setCustomer((ICustomerModifier)argValue);
/*      */     }
/* 1398 */     else if ("Payments".equals(argFieldId)) {
/* 1399 */       setPayments(changeToList(argValue, IOrderPayment.class));
/*      */     }
/* 1401 */     else if ("Fees".equals(argFieldId)) {
/* 1402 */       setFees(changeToList(argValue, IOrderFee.class));
/*      */     }
/* 1404 */     else if ("OrderLines".equals(argFieldId)) {
/* 1405 */       setOrderLines(changeToList(argValue, IOrderLine.class));
/*      */     }
/* 1407 */     else if ("Properties".equals(argFieldId)) {
/* 1408 */       setProperties(changeToList(argValue, IOrderProperty.class));
/*      */     }
/* 1410 */     else if ("OrderExtension".equals(argFieldId)) {
/* 1411 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1414 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1420 */     this._persistenceDefaults = argPD;
/* 1421 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1422 */     this._eventManager = argEM;
/* 1423 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1424 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1425 */     if (this._customer != null) {
/* 1426 */       ((IDataModelImpl)this._customer).setDependencies(argPD, argEM);
/*      */     }
/* 1428 */     if (this._payments != null) {
/* 1429 */       for (IOrderPayment relationship : this._payments) {
/* 1430 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1433 */     if (this._fees != null) {
/* 1434 */       for (IOrderFee relationship : this._fees) {
/* 1435 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1438 */     if (this._orderLines != null) {
/* 1439 */       for (IOrderLine relationship : this._orderLines) {
/* 1440 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1443 */     if (this._properties != null) {
/* 1444 */       for (IOrderProperty relationship : this._properties) {
/* 1445 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getOrderExt() {
/* 1451 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setOrderExt(IDataModel argExt) {
/* 1455 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1460 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1464 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1467 */     super.startTransaction();
/*      */     
/* 1469 */     this._customerSavepoint = this._customer;
/* 1470 */     if (this._customer != null) {
/* 1471 */       this._customer.startTransaction();
/*      */     }
/*      */     
/* 1474 */     this._paymentsSavepoint = this._payments;
/* 1475 */     if (this._payments != null) {
/* 1476 */       this._paymentsSavepoint = new HistoricalList((List)this._payments);
/* 1477 */       Iterator<IDataModel> it = this._payments.iterator();
/* 1478 */       while (it.hasNext()) {
/* 1479 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1483 */     this._feesSavepoint = this._fees;
/* 1484 */     if (this._fees != null) {
/* 1485 */       this._feesSavepoint = new HistoricalList((List)this._fees);
/* 1486 */       Iterator<IDataModel> it = this._fees.iterator();
/* 1487 */       while (it.hasNext()) {
/* 1488 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1492 */     this._orderLinesSavepoint = this._orderLines;
/* 1493 */     if (this._orderLines != null) {
/* 1494 */       this._orderLinesSavepoint = new HistoricalList((List)this._orderLines);
/* 1495 */       Iterator<IDataModel> it = this._orderLines.iterator();
/* 1496 */       while (it.hasNext()) {
/* 1497 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1501 */     this._propertiesSavepoint = this._properties;
/* 1502 */     if (this._properties != null) {
/* 1503 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1504 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1505 */       while (it.hasNext()) {
/* 1506 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1511 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1516 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1519 */     super.rollbackChanges();
/*      */     
/* 1521 */     this._customer = this._customerSavepoint;
/* 1522 */     this._customerSavepoint = null;
/* 1523 */     if (this._customer != null) {
/* 1524 */       this._customer.rollbackChanges();
/*      */     }
/*      */     
/* 1527 */     this._payments = this._paymentsSavepoint;
/* 1528 */     this._paymentsSavepoint = null;
/* 1529 */     if (this._payments != null) {
/* 1530 */       Iterator<IDataModel> it = this._payments.iterator();
/* 1531 */       while (it.hasNext()) {
/* 1532 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1536 */     this._fees = this._feesSavepoint;
/* 1537 */     this._feesSavepoint = null;
/* 1538 */     if (this._fees != null) {
/* 1539 */       Iterator<IDataModel> it = this._fees.iterator();
/* 1540 */       while (it.hasNext()) {
/* 1541 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1545 */     this._orderLines = this._orderLinesSavepoint;
/* 1546 */     this._orderLinesSavepoint = null;
/* 1547 */     if (this._orderLines != null) {
/* 1548 */       Iterator<IDataModel> it = this._orderLines.iterator();
/* 1549 */       while (it.hasNext()) {
/* 1550 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1554 */     this._properties = this._propertiesSavepoint;
/* 1555 */     this._propertiesSavepoint = null;
/* 1556 */     if (this._properties != null) {
/* 1557 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1558 */       while (it.hasNext()) {
/* 1559 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 1567 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 1570 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 1573 */     super.commitTransaction();
/*      */     
/* 1575 */     this._customerSavepoint = this._customer;
/* 1576 */     if (this._customer != null) {
/* 1577 */       this._customer.commitTransaction();
/*      */     }
/*      */     
/* 1580 */     this._paymentsSavepoint = this._payments;
/* 1581 */     if (this._payments != null) {
/* 1582 */       Iterator<IDataModel> it = this._payments.iterator();
/* 1583 */       while (it.hasNext()) {
/* 1584 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1586 */       this._payments = new HistoricalList((List)this._payments);
/*      */     } 
/*      */     
/* 1589 */     this._feesSavepoint = this._fees;
/* 1590 */     if (this._fees != null) {
/* 1591 */       Iterator<IDataModel> it = this._fees.iterator();
/* 1592 */       while (it.hasNext()) {
/* 1593 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1595 */       this._fees = new HistoricalList((List)this._fees);
/*      */     } 
/*      */     
/* 1598 */     this._orderLinesSavepoint = this._orderLines;
/* 1599 */     if (this._orderLines != null) {
/* 1600 */       Iterator<IDataModel> it = this._orderLines.iterator();
/* 1601 */       while (it.hasNext()) {
/* 1602 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1604 */       this._orderLines = new HistoricalList((List)this._orderLines);
/*      */     } 
/*      */     
/* 1607 */     this._propertiesSavepoint = this._properties;
/* 1608 */     if (this._properties != null) {
/* 1609 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1610 */       while (it.hasNext()) {
/* 1611 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 1613 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 1617 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */