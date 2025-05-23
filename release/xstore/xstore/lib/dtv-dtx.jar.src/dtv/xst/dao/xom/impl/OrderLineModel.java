/*      */ package dtv.xst.dao.xom.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.inv.IShipperMethod;
/*      */ import dtv.xst.dao.xom.IBalanceModifier;
/*      */ import dtv.xst.dao.xom.ICustomizationModifier;
/*      */ import dtv.xst.dao.xom.IFeeModifier;
/*      */ import dtv.xst.dao.xom.IFulfillmentModifier;
/*      */ import dtv.xst.dao.xom.IItemModifier;
/*      */ import dtv.xst.dao.xom.IOrderLine;
/*      */ import dtv.xst.dao.xom.IOrderLineProperty;
/*      */ import dtv.xst.dao.xom.ISourceModifier;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class OrderLineModel extends AbstractDataModelWithPropertyImpl<IOrderLineProperty> implements IOrderLine {
/*      */   private static final long serialVersionUID = 1612149826L;
/*      */   private IOrder _parentOrder;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private ISourceModifier _sourceModifier;
/*      */   private transient ISourceModifier _sourceModifierSavepoint;
/*      */   private IFulfillmentModifier _fulfillmentModifier;
/*      */   private transient IFulfillmentModifier _fulfillmentModifierSavepoint;
/*      */   
/*      */   public String toString() {
/*   38 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private HistoricalList<IBalanceModifier> _balanceModifiers; private transient HistoricalList<IBalanceModifier> _balanceModifiersSavepoint; private HistoricalList<ICustomizationModifier> _customizationModifiers; private transient HistoricalList<ICustomizationModifier> _customizationModifiersSavepoint; private HistoricalList<IFeeModifier> _fees; private transient HistoricalList<IFeeModifier> _feesSavepoint; private IItemModifier _item; private transient IItemModifier _itemSavepoint; private HistoricalList<IOrderLineProperty> _properties; private transient HistoricalList<IOrderLineProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   43 */     setDAO((IDataAccessObject)new OrderLineDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private OrderLineDAO getDAO_() {
/*   51 */     return (OrderLineDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   59 */     if (getDAO_().getOrganizationId() != null) {
/*   60 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   63 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   72 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   73 */       this._events != null && 
/*   74 */       postEventsForChanges()) {
/*   75 */       this._events.post(IOrderLine.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   82 */     boolean ev_postable = false;
/*      */     
/*   84 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   85 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   86 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   87 */       ev_postable = true;
/*   88 */       if (this._balanceModifiers != null) {
/*      */         
/*   90 */         Iterator<BalanceModifierModel> it = this._balanceModifiers.iterator();
/*   91 */         while (it.hasNext())
/*      */         {
/*   93 */           ((BalanceModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   96 */       if (this._customizationModifiers != null) {
/*      */         
/*   98 */         Iterator<CustomizationModifierModel> it = this._customizationModifiers.iterator();
/*   99 */         while (it.hasNext())
/*      */         {
/*  101 */           ((CustomizationModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  104 */       if (this._fees != null) {
/*      */         
/*  106 */         Iterator<FeeModifierModel> it = this._fees.iterator();
/*  107 */         while (it.hasNext())
/*      */         {
/*  109 */           ((FeeModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  112 */       if (this._properties != null) {
/*      */         
/*  114 */         Iterator<OrderLinePropertyModel> it = this._properties.iterator();
/*  115 */         while (it.hasNext())
/*      */         {
/*  117 */           ((OrderLinePropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  120 */       if (this._sourceModifier != null)
/*      */       {
/*      */         
/*  123 */         ((SourceModifierModel)this._sourceModifier).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  125 */       if (this._fulfillmentModifier != null)
/*      */       {
/*      */         
/*  128 */         ((FulfillmentModifierModel)this._fulfillmentModifier).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  130 */       if (this._item != null)
/*      */       {
/*      */         
/*  133 */         ((ItemModifierModel)this._item).setOrganizationId_noev(argOrganizationId);
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
/*      */   public String getOrderId() {
/*  145 */     return getDAO_().getOrderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrderId(String argOrderId) {
/*  153 */     if (setOrderId_noev(argOrderId) && 
/*  154 */       this._events != null && 
/*  155 */       postEventsForChanges()) {
/*  156 */       this._events.post(IOrderLine.SET_ORDERID, argOrderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrderId_noev(String argOrderId) {
/*  163 */     boolean ev_postable = false;
/*      */     
/*  165 */     if ((getDAO_().getOrderId() == null && argOrderId != null) || (
/*  166 */       getDAO_().getOrderId() != null && !getDAO_().getOrderId().equals(argOrderId))) {
/*  167 */       getDAO_().setOrderId(argOrderId);
/*  168 */       ev_postable = true;
/*  169 */       if (this._balanceModifiers != null) {
/*      */         
/*  171 */         Iterator<BalanceModifierModel> it = this._balanceModifiers.iterator();
/*  172 */         while (it.hasNext())
/*      */         {
/*  174 */           ((BalanceModifierModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  177 */       if (this._customizationModifiers != null) {
/*      */         
/*  179 */         Iterator<CustomizationModifierModel> it = this._customizationModifiers.iterator();
/*  180 */         while (it.hasNext())
/*      */         {
/*  182 */           ((CustomizationModifierModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  185 */       if (this._fees != null) {
/*      */         
/*  187 */         Iterator<FeeModifierModel> it = this._fees.iterator();
/*  188 */         while (it.hasNext())
/*      */         {
/*  190 */           ((FeeModifierModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  193 */       if (this._properties != null) {
/*      */         
/*  195 */         Iterator<OrderLinePropertyModel> it = this._properties.iterator();
/*  196 */         while (it.hasNext())
/*      */         {
/*  198 */           ((OrderLinePropertyModel)it.next()).setOrderId_noev(argOrderId);
/*      */         }
/*      */       } 
/*  201 */       if (this._sourceModifier != null)
/*      */       {
/*      */         
/*  204 */         ((SourceModifierModel)this._sourceModifier).setOrderId_noev(argOrderId);
/*      */       }
/*  206 */       if (this._fulfillmentModifier != null)
/*      */       {
/*      */         
/*  209 */         ((FulfillmentModifierModel)this._fulfillmentModifier).setOrderId_noev(argOrderId);
/*      */       }
/*  211 */       if (this._item != null)
/*      */       {
/*      */         
/*  214 */         ((ItemModifierModel)this._item).setOrderId_noev(argOrderId);
/*      */       }
/*      */     } 
/*      */     
/*  218 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSequence() {
/*  226 */     if (getDAO_().getSequence() != null) {
/*  227 */       return getDAO_().getSequence().intValue();
/*      */     }
/*      */     
/*  230 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequence(int argSequence) {
/*  239 */     if (setSequence_noev(argSequence) && 
/*  240 */       this._events != null && 
/*  241 */       postEventsForChanges()) {
/*  242 */       this._events.post(IOrderLine.SET_SEQUENCE, Integer.valueOf(argSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSequence_noev(int argSequence) {
/*  249 */     boolean ev_postable = false;
/*      */     
/*  251 */     if ((getDAO_().getSequence() == null && Integer.valueOf(argSequence) != null) || (
/*  252 */       getDAO_().getSequence() != null && !getDAO_().getSequence().equals(Integer.valueOf(argSequence)))) {
/*  253 */       getDAO_().setSequence(Integer.valueOf(argSequence));
/*  254 */       ev_postable = true;
/*  255 */       if (this._balanceModifiers != null) {
/*      */         
/*  257 */         Iterator<BalanceModifierModel> it = this._balanceModifiers.iterator();
/*  258 */         while (it.hasNext())
/*      */         {
/*  260 */           ((BalanceModifierModel)it.next()).setSequence_noev(argSequence);
/*      */         }
/*      */       } 
/*  263 */       if (this._customizationModifiers != null) {
/*      */         
/*  265 */         Iterator<CustomizationModifierModel> it = this._customizationModifiers.iterator();
/*  266 */         while (it.hasNext())
/*      */         {
/*  268 */           ((CustomizationModifierModel)it.next()).setSequence_noev(argSequence);
/*      */         }
/*      */       } 
/*  271 */       if (this._fees != null) {
/*      */         
/*  273 */         Iterator<FeeModifierModel> it = this._fees.iterator();
/*  274 */         while (it.hasNext())
/*      */         {
/*  276 */           ((FeeModifierModel)it.next()).setSequence_noev(argSequence);
/*      */         }
/*      */       } 
/*  279 */       if (this._properties != null) {
/*      */         
/*  281 */         Iterator<OrderLinePropertyModel> it = this._properties.iterator();
/*  282 */         while (it.hasNext())
/*      */         {
/*  284 */           ((OrderLinePropertyModel)it.next()).setSequence_noev(argSequence);
/*      */         }
/*      */       } 
/*  287 */       if (this._sourceModifier != null)
/*      */       {
/*      */         
/*  290 */         ((SourceModifierModel)this._sourceModifier).setSequence_noev(argSequence);
/*      */       }
/*  292 */       if (this._fulfillmentModifier != null)
/*      */       {
/*      */         
/*  295 */         ((FulfillmentModifierModel)this._fulfillmentModifier).setSequence_noev(argSequence);
/*      */       }
/*  297 */       if (this._item != null)
/*      */       {
/*      */         
/*  300 */         ((ItemModifierModel)this._item).setSequence_noev(argSequence);
/*      */       }
/*      */     } 
/*      */     
/*  304 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  312 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  320 */     if (setCreateDate_noev(argCreateDate) && 
/*  321 */       this._events != null && 
/*  322 */       postEventsForChanges()) {
/*  323 */       this._events.post(IOrderLine.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  330 */     boolean ev_postable = false;
/*      */     
/*  332 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  333 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  334 */       getDAO_().setCreateDate(argCreateDate);
/*  335 */       ev_postable = true;
/*      */     } 
/*      */     
/*  338 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  346 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  354 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  355 */       this._events != null && 
/*  356 */       postEventsForChanges()) {
/*  357 */       this._events.post(IOrderLine.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  364 */     boolean ev_postable = false;
/*      */     
/*  366 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  367 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  368 */       getDAO_().setCreateUserId(argCreateUserId);
/*  369 */       ev_postable = true;
/*      */     } 
/*      */     
/*  372 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  380 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  388 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  389 */       this._events != null && 
/*  390 */       postEventsForChanges()) {
/*  391 */       this._events.post(IOrderLine.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  398 */     boolean ev_postable = false;
/*      */     
/*  400 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  401 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  402 */       getDAO_().setUpdateDate(argUpdateDate);
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
/*      */   public String getUpdateUserId() {
/*  414 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  422 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  423 */       this._events != null && 
/*  424 */       postEventsForChanges()) {
/*  425 */       this._events.post(IOrderLine.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  432 */     boolean ev_postable = false;
/*      */     
/*  434 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  435 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  436 */       getDAO_().setUpdateUserId(argUpdateUserId);
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
/*      */   public String getExternalOrderId() {
/*  448 */     return getDAO_().getExternalOrderId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalOrderId(String argExternalOrderId) {
/*  456 */     if (setExternalOrderId_noev(argExternalOrderId) && 
/*  457 */       this._events != null && 
/*  458 */       postEventsForChanges()) {
/*  459 */       this._events.post(IOrderLine.SET_EXTERNALORDERID, argExternalOrderId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalOrderId_noev(String argExternalOrderId) {
/*  466 */     boolean ev_postable = false;
/*      */     
/*  468 */     if ((getDAO_().getExternalOrderId() == null && argExternalOrderId != null) || (
/*  469 */       getDAO_().getExternalOrderId() != null && !getDAO_().getExternalOrderId().equals(argExternalOrderId))) {
/*  470 */       getDAO_().setExternalOrderId(argExternalOrderId);
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
/*      */   public String getItemId() {
/*  482 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  490 */     if (setItemId_noev(argItemId) && 
/*  491 */       this._events != null && 
/*  492 */       postEventsForChanges()) {
/*  493 */       this._events.post(IOrderLine.SET_ITEMID, argItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/*  500 */     boolean ev_postable = false;
/*      */     
/*  502 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/*  503 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/*  504 */       getDAO_().setItemId(argItemId);
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
/*      */   public BigDecimal getQuantity() {
/*  516 */     return getDAO_().getQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(BigDecimal argQuantity) {
/*  524 */     if (setQuantity_noev(argQuantity) && 
/*  525 */       this._events != null && 
/*  526 */       postEventsForChanges()) {
/*  527 */       this._events.post(IOrderLine.SET_QUANTITY, argQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/*  534 */     boolean ev_postable = false;
/*      */     
/*  536 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/*  537 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/*  538 */       getDAO_().setQuantity(argQuantity);
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
/*      */   public String getFulfillmentType() {
/*  550 */     return getDAO_().getFulfillmentType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFulfillmentType(String argFulfillmentType) {
/*  558 */     if (setFulfillmentType_noev(argFulfillmentType) && 
/*  559 */       this._events != null && 
/*  560 */       postEventsForChanges()) {
/*  561 */       this._events.post(IOrderLine.SET_FULFILLMENTTYPE, argFulfillmentType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFulfillmentType_noev(String argFulfillmentType) {
/*  568 */     boolean ev_postable = false;
/*      */     
/*  570 */     if ((getDAO_().getFulfillmentType() == null && argFulfillmentType != null) || (
/*  571 */       getDAO_().getFulfillmentType() != null && !getDAO_().getFulfillmentType().equals(argFulfillmentType))) {
/*  572 */       getDAO_().setFulfillmentType(argFulfillmentType);
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
/*      */   public String getStatusCode() {
/*  584 */     return getDAO_().getStatusCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCode(String argStatusCode) {
/*  592 */     if (setStatusCode_noev(argStatusCode) && 
/*  593 */       this._events != null && 
/*  594 */       postEventsForChanges()) {
/*  595 */       this._events.post(IOrderLine.SET_STATUSCODE, argStatusCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCode_noev(String argStatusCode) {
/*  602 */     boolean ev_postable = false;
/*      */     
/*  604 */     if ((getDAO_().getStatusCode() == null && argStatusCode != null) || (
/*  605 */       getDAO_().getStatusCode() != null && !getDAO_().getStatusCode().equals(argStatusCode))) {
/*  606 */       getDAO_().setStatusCode(argStatusCode);
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
/*      */   public BigDecimal getUnitPrice() {
/*  618 */     return getDAO_().getUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitPrice(BigDecimal argUnitPrice) {
/*  626 */     if (setUnitPrice_noev(argUnitPrice) && 
/*  627 */       this._events != null && 
/*  628 */       postEventsForChanges()) {
/*  629 */       this._events.post(IOrderLine.SET_UNITPRICE, argUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitPrice_noev(BigDecimal argUnitPrice) {
/*  636 */     boolean ev_postable = false;
/*      */     
/*  638 */     if ((getDAO_().getUnitPrice() == null && argUnitPrice != null) || (
/*  639 */       getDAO_().getUnitPrice() != null && !getDAO_().getUnitPrice().equals(argUnitPrice))) {
/*  640 */       getDAO_().setUnitPrice(argUnitPrice);
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
/*      */   public BigDecimal getExtendedPrice() {
/*  652 */     return getDAO_().getExtendedPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtendedPrice(BigDecimal argExtendedPrice) {
/*  660 */     if (setExtendedPrice_noev(argExtendedPrice) && 
/*  661 */       this._events != null && 
/*  662 */       postEventsForChanges()) {
/*  663 */       this._events.post(IOrderLine.SET_EXTENDEDPRICE, argExtendedPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtendedPrice_noev(BigDecimal argExtendedPrice) {
/*  670 */     boolean ev_postable = false;
/*      */     
/*  672 */     if ((getDAO_().getExtendedPrice() == null && argExtendedPrice != null) || (
/*  673 */       getDAO_().getExtendedPrice() != null && !getDAO_().getExtendedPrice().equals(argExtendedPrice))) {
/*  674 */       getDAO_().setExtendedPrice(argExtendedPrice);
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
/*      */   public BigDecimal getTaxAmount() {
/*  686 */     return getDAO_().getTaxAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxAmount(BigDecimal argTaxAmount) {
/*  694 */     if (setTaxAmount_noev(argTaxAmount) && 
/*  695 */       this._events != null && 
/*  696 */       postEventsForChanges()) {
/*  697 */       this._events.post(IOrderLine.SET_TAXAMOUNT, argTaxAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxAmount_noev(BigDecimal argTaxAmount) {
/*  704 */     boolean ev_postable = false;
/*      */     
/*  706 */     if ((getDAO_().getTaxAmount() == null && argTaxAmount != null) || (
/*  707 */       getDAO_().getTaxAmount() != null && !getDAO_().getTaxAmount().equals(argTaxAmount))) {
/*  708 */       getDAO_().setTaxAmount(argTaxAmount);
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
/*      */   public String getNotes() {
/*  720 */     return getDAO_().getNotes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotes(String argNotes) {
/*  728 */     if (setNotes_noev(argNotes) && 
/*  729 */       this._events != null && 
/*  730 */       postEventsForChanges()) {
/*  731 */       this._events.post(IOrderLine.SET_NOTES, argNotes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotes_noev(String argNotes) {
/*  738 */     boolean ev_postable = false;
/*      */     
/*  740 */     if ((getDAO_().getNotes() == null && argNotes != null) || (
/*  741 */       getDAO_().getNotes() != null && !getDAO_().getNotes().equals(argNotes))) {
/*  742 */       getDAO_().setNotes(argNotes);
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
/*      */   public String getSelectedShipMethod() {
/*  754 */     return getDAO_().getSelectedShipMethod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setSelectedShipMethodImpl(String argSelectedShipMethod) {
/*  762 */     if (setSelectedShipMethod_noev(argSelectedShipMethod) && 
/*  763 */       this._events != null && 
/*  764 */       postEventsForChanges()) {
/*  765 */       this._events.post(IOrderLine.SET_SELECTEDSHIPMETHOD, argSelectedShipMethod);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSelectedShipMethod_noev(String argSelectedShipMethod) {
/*  772 */     boolean ev_postable = false;
/*      */     
/*  774 */     if ((getDAO_().getSelectedShipMethod() == null && argSelectedShipMethod != null) || (
/*  775 */       getDAO_().getSelectedShipMethod() != null && !getDAO_().getSelectedShipMethod().equals(argSelectedShipMethod))) {
/*  776 */       getDAO_().setSelectedShipMethod(argSelectedShipMethod);
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
/*      */   public String getActualShipMethod() {
/*  788 */     return getDAO_().getActualShipMethod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActualShipMethod(String argActualShipMethod) {
/*  796 */     if (setActualShipMethod_noev(argActualShipMethod) && 
/*  797 */       this._events != null && 
/*  798 */       postEventsForChanges()) {
/*  799 */       this._events.post(IOrderLine.SET_ACTUALSHIPMETHOD, argActualShipMethod);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setActualShipMethod_noev(String argActualShipMethod) {
/*  806 */     boolean ev_postable = false;
/*      */     
/*  808 */     if ((getDAO_().getActualShipMethod() == null && argActualShipMethod != null) || (
/*  809 */       getDAO_().getActualShipMethod() != null && !getDAO_().getActualShipMethod().equals(argActualShipMethod))) {
/*  810 */       getDAO_().setActualShipMethod(argActualShipMethod);
/*  811 */       ev_postable = true;
/*      */     } 
/*      */     
/*  814 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTrackingNumber() {
/*  822 */     return getDAO_().getTrackingNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTrackingNumber(String argTrackingNumber) {
/*  830 */     if (setTrackingNumber_noev(argTrackingNumber) && 
/*  831 */       this._events != null && 
/*  832 */       postEventsForChanges()) {
/*  833 */       this._events.post(IOrderLine.SET_TRACKINGNUMBER, argTrackingNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTrackingNumber_noev(String argTrackingNumber) {
/*  840 */     boolean ev_postable = false;
/*      */     
/*  842 */     if ((getDAO_().getTrackingNumber() == null && argTrackingNumber != null) || (
/*  843 */       getDAO_().getTrackingNumber() != null && !getDAO_().getTrackingNumber().equals(argTrackingNumber))) {
/*  844 */       getDAO_().setTrackingNumber(argTrackingNumber);
/*  845 */       ev_postable = true;
/*      */     } 
/*      */     
/*  848 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDropShip() {
/*  856 */     if (getDAO_().getDropShip() != null) {
/*  857 */       return getDAO_().getDropShip().booleanValue();
/*      */     }
/*      */     
/*  860 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDropShip(boolean argDropShip) {
/*  869 */     if (setDropShip_noev(argDropShip) && 
/*  870 */       this._events != null && 
/*  871 */       postEventsForChanges()) {
/*  872 */       this._events.post(IOrderLine.SET_DROPSHIP, Boolean.valueOf(argDropShip));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDropShip_noev(boolean argDropShip) {
/*  879 */     boolean ev_postable = false;
/*      */     
/*  881 */     if ((getDAO_().getDropShip() == null && Boolean.valueOf(argDropShip) != null) || (
/*  882 */       getDAO_().getDropShip() != null && !getDAO_().getDropShip().equals(Boolean.valueOf(argDropShip)))) {
/*  883 */       getDAO_().setDropShip(Boolean.valueOf(argDropShip));
/*  884 */       ev_postable = true;
/*      */     } 
/*      */     
/*  887 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVoid() {
/*  895 */     if (getDAO_().getVoid() != null) {
/*  896 */       return getDAO_().getVoid().booleanValue();
/*      */     }
/*      */     
/*  899 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVoid(boolean argVoid) {
/*  908 */     if (setVoid_noev(argVoid) && 
/*  909 */       this._events != null && 
/*  910 */       postEventsForChanges()) {
/*  911 */       this._events.post(IOrderLine.SET_VOID, Boolean.valueOf(argVoid));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVoid_noev(boolean argVoid) {
/*  918 */     boolean ev_postable = false;
/*      */     
/*  920 */     if ((getDAO_().getVoid() == null && Boolean.valueOf(argVoid) != null) || (
/*  921 */       getDAO_().getVoid() != null && !getDAO_().getVoid().equals(Boolean.valueOf(argVoid)))) {
/*  922 */       getDAO_().setVoid(Boolean.valueOf(argVoid));
/*  923 */       ev_postable = true;
/*      */     } 
/*      */     
/*  926 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCodeReason() {
/*  934 */     return getDAO_().getStatusCodeReason();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCodeReason(String argStatusCodeReason) {
/*  942 */     if (setStatusCodeReason_noev(argStatusCodeReason) && 
/*  943 */       this._events != null && 
/*  944 */       postEventsForChanges()) {
/*  945 */       this._events.post(IOrderLine.SET_STATUSCODEREASON, argStatusCodeReason);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCodeReason_noev(String argStatusCodeReason) {
/*  952 */     boolean ev_postable = false;
/*      */     
/*  954 */     if ((getDAO_().getStatusCodeReason() == null && argStatusCodeReason != null) || (
/*  955 */       getDAO_().getStatusCodeReason() != null && !getDAO_().getStatusCodeReason().equals(argStatusCodeReason))) {
/*  956 */       getDAO_().setStatusCodeReason(argStatusCodeReason);
/*  957 */       ev_postable = true;
/*      */     } 
/*      */     
/*  960 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLineNumber() {
/*  968 */     if (getDAO_().getLineNumber() != null) {
/*  969 */       return getDAO_().getLineNumber().intValue();
/*      */     }
/*      */     
/*  972 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineNumber(int argLineNumber) {
/*  981 */     if (setLineNumber_noev(argLineNumber) && 
/*  982 */       this._events != null && 
/*  983 */       postEventsForChanges()) {
/*  984 */       this._events.post(IOrderLine.SET_LINENUMBER, Integer.valueOf(argLineNumber));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineNumber_noev(int argLineNumber) {
/*  991 */     boolean ev_postable = false;
/*      */     
/*  993 */     if ((getDAO_().getLineNumber() == null && Integer.valueOf(argLineNumber) != null) || (
/*  994 */       getDAO_().getLineNumber() != null && !getDAO_().getLineNumber().equals(Integer.valueOf(argLineNumber)))) {
/*  995 */       getDAO_().setLineNumber(Integer.valueOf(argLineNumber));
/*  996 */       ev_postable = true;
/*      */     } 
/*      */     
/*  999 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatusCodeReasonNote() {
/* 1007 */     return getDAO_().getStatusCodeReasonNote();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStatusCodeReasonNote(String argStatusCodeReasonNote) {
/* 1015 */     if (setStatusCodeReasonNote_noev(argStatusCodeReasonNote) && 
/* 1016 */       this._events != null && 
/* 1017 */       postEventsForChanges()) {
/* 1018 */       this._events.post(IOrderLine.SET_STATUSCODEREASONNOTE, argStatusCodeReasonNote);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStatusCodeReasonNote_noev(String argStatusCodeReasonNote) {
/* 1025 */     boolean ev_postable = false;
/*      */     
/* 1027 */     if ((getDAO_().getStatusCodeReasonNote() == null && argStatusCodeReasonNote != null) || (
/* 1028 */       getDAO_().getStatusCodeReasonNote() != null && !getDAO_().getStatusCodeReasonNote().equals(argStatusCodeReasonNote))) {
/* 1029 */       getDAO_().setStatusCodeReasonNote(argStatusCodeReasonNote);
/* 1030 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1033 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemUpcCode() {
/* 1041 */     return getDAO_().getItemUpcCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemUpcCode(String argItemUpcCode) {
/* 1049 */     if (setItemUpcCode_noev(argItemUpcCode) && 
/* 1050 */       this._events != null && 
/* 1051 */       postEventsForChanges()) {
/* 1052 */       this._events.post(IOrderLine.SET_ITEMUPCCODE, argItemUpcCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemUpcCode_noev(String argItemUpcCode) {
/* 1059 */     boolean ev_postable = false;
/*      */     
/* 1061 */     if ((getDAO_().getItemUpcCode() == null && argItemUpcCode != null) || (
/* 1062 */       getDAO_().getItemUpcCode() != null && !getDAO_().getItemUpcCode().equals(argItemUpcCode))) {
/* 1063 */       getDAO_().setItemUpcCode(argItemUpcCode);
/* 1064 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1067 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemEanCode() {
/* 1075 */     return getDAO_().getItemEanCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemEanCode(String argItemEanCode) {
/* 1083 */     if (setItemEanCode_noev(argItemEanCode) && 
/* 1084 */       this._events != null && 
/* 1085 */       postEventsForChanges()) {
/* 1086 */       this._events.post(IOrderLine.SET_ITEMEANCODE, argItemEanCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemEanCode_noev(String argItemEanCode) {
/* 1093 */     boolean ev_postable = false;
/*      */     
/* 1095 */     if ((getDAO_().getItemEanCode() == null && argItemEanCode != null) || (
/* 1096 */       getDAO_().getItemEanCode() != null && !getDAO_().getItemEanCode().equals(argItemEanCode))) {
/* 1097 */       getDAO_().setItemEanCode(argItemEanCode);
/* 1098 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1101 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExtendedFreight() {
/* 1109 */     return getDAO_().getExtendedFreight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtendedFreight(BigDecimal argExtendedFreight) {
/* 1117 */     if (setExtendedFreight_noev(argExtendedFreight) && 
/* 1118 */       this._events != null && 
/* 1119 */       postEventsForChanges()) {
/* 1120 */       this._events.post(IOrderLine.SET_EXTENDEDFREIGHT, argExtendedFreight);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtendedFreight_noev(BigDecimal argExtendedFreight) {
/* 1127 */     boolean ev_postable = false;
/*      */     
/* 1129 */     if ((getDAO_().getExtendedFreight() == null && argExtendedFreight != null) || (
/* 1130 */       getDAO_().getExtendedFreight() != null && !getDAO_().getExtendedFreight().equals(argExtendedFreight))) {
/* 1131 */       getDAO_().setExtendedFreight(argExtendedFreight);
/* 1132 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1135 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCustomizationCharge() {
/* 1143 */     return getDAO_().getCustomizationCharge();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomizationCharge(BigDecimal argCustomizationCharge) {
/* 1151 */     if (setCustomizationCharge_noev(argCustomizationCharge) && 
/* 1152 */       this._events != null && 
/* 1153 */       postEventsForChanges()) {
/* 1154 */       this._events.post(IOrderLine.SET_CUSTOMIZATIONCHARGE, argCustomizationCharge);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCustomizationCharge_noev(BigDecimal argCustomizationCharge) {
/* 1161 */     boolean ev_postable = false;
/*      */     
/* 1163 */     if ((getDAO_().getCustomizationCharge() == null && argCustomizationCharge != null) || (
/* 1164 */       getDAO_().getCustomizationCharge() != null && !getDAO_().getCustomizationCharge().equals(argCustomizationCharge))) {
/* 1165 */       getDAO_().setCustomizationCharge(argCustomizationCharge);
/* 1166 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1169 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getGiftWrap() {
/* 1177 */     if (getDAO_().getGiftWrap() != null) {
/* 1178 */       return getDAO_().getGiftWrap().booleanValue();
/*      */     }
/*      */     
/* 1181 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGiftWrap(boolean argGiftWrap) {
/* 1190 */     if (setGiftWrap_noev(argGiftWrap) && 
/* 1191 */       this._events != null && 
/* 1192 */       postEventsForChanges()) {
/* 1193 */       this._events.post(IOrderLine.SET_GIFTWRAP, Boolean.valueOf(argGiftWrap));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGiftWrap_noev(boolean argGiftWrap) {
/* 1200 */     boolean ev_postable = false;
/*      */     
/* 1202 */     if ((getDAO_().getGiftWrap() == null && Boolean.valueOf(argGiftWrap) != null) || (
/* 1203 */       getDAO_().getGiftWrap() != null && !getDAO_().getGiftWrap().equals(Boolean.valueOf(argGiftWrap)))) {
/* 1204 */       getDAO_().setGiftWrap(Boolean.valueOf(argGiftWrap));
/* 1205 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1208 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getShipAlone() {
/* 1216 */     if (getDAO_().getShipAlone() != null) {
/* 1217 */       return getDAO_().getShipAlone().booleanValue();
/*      */     }
/*      */     
/* 1220 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipAlone(boolean argShipAlone) {
/* 1229 */     if (setShipAlone_noev(argShipAlone) && 
/* 1230 */       this._events != null && 
/* 1231 */       postEventsForChanges()) {
/* 1232 */       this._events.post(IOrderLine.SET_SHIPALONE, Boolean.valueOf(argShipAlone));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipAlone_noev(boolean argShipAlone) {
/* 1239 */     boolean ev_postable = false;
/*      */     
/* 1241 */     if ((getDAO_().getShipAlone() == null && Boolean.valueOf(argShipAlone) != null) || (
/* 1242 */       getDAO_().getShipAlone() != null && !getDAO_().getShipAlone().equals(Boolean.valueOf(argShipAlone)))) {
/* 1243 */       getDAO_().setShipAlone(Boolean.valueOf(argShipAlone));
/* 1244 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1247 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getShipWeight() {
/* 1255 */     return getDAO_().getShipWeight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShipWeight(BigDecimal argShipWeight) {
/* 1263 */     if (setShipWeight_noev(argShipWeight) && 
/* 1264 */       this._events != null && 
/* 1265 */       postEventsForChanges()) {
/* 1266 */       this._events.post(IOrderLine.SET_SHIPWEIGHT, argShipWeight);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShipWeight_noev(BigDecimal argShipWeight) {
/* 1273 */     boolean ev_postable = false;
/*      */     
/* 1275 */     if ((getDAO_().getShipWeight() == null && argShipWeight != null) || (
/* 1276 */       getDAO_().getShipWeight() != null && !getDAO_().getShipWeight().equals(argShipWeight))) {
/* 1277 */       getDAO_().setShipWeight(argShipWeight);
/* 1278 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1281 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLineMessage() {
/* 1289 */     return getDAO_().getLineMessage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLineMessage(String argLineMessage) {
/* 1297 */     if (setLineMessage_noev(argLineMessage) && 
/* 1298 */       this._events != null && 
/* 1299 */       postEventsForChanges()) {
/* 1300 */       this._events.post(IOrderLine.SET_LINEMESSAGE, argLineMessage);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLineMessage_noev(String argLineMessage) {
/* 1307 */     boolean ev_postable = false;
/*      */     
/* 1309 */     if ((getDAO_().getLineMessage() == null && argLineMessage != null) || (
/* 1310 */       getDAO_().getLineMessage() != null && !getDAO_().getLineMessage().equals(argLineMessage))) {
/* 1311 */       getDAO_().setLineMessage(argLineMessage);
/* 1312 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1315 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IOrderLineProperty newProperty(String argPropertyName) {
/* 1319 */     OrderLinePropertyId id = new OrderLinePropertyId();
/*      */     
/* 1321 */     id.setOrderId(getOrderId());
/* 1322 */     id.setSequence(Integer.valueOf(getSequence()));
/* 1323 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1325 */     IOrderLineProperty prop = (IOrderLineProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IOrderLineProperty.class);
/* 1326 */     return prop;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "SourceModifier")
/*      */   public ISourceModifier getSourceModifier() {
/* 1353 */     return this._sourceModifier;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSourceModifier(ISourceModifier argSourceModifier) {
/* 1358 */     if (argSourceModifier == null) {
/*      */       
/* 1360 */       if (this._sourceModifier != null) {
/* 1361 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1363 */       if (this._sourceModifier != null) {
/*      */         
/* 1365 */         if (postEventsForChanges()) {
/* 1366 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._sourceModifier));
/*      */         }
/* 1368 */         addDeletedObject((IDataModel)this._sourceModifier);
/*      */       } 
/*      */     } else {
/*      */       
/* 1372 */       argSourceModifier.setOrganizationId(getOrganizationId());
/* 1373 */       argSourceModifier.setOrderId(getOrderId());
/* 1374 */       argSourceModifier.setSequence(getSequence());
/*      */ 
/*      */       
/* 1377 */       argSourceModifier.setParentLine(this);
/*      */ 
/*      */       
/* 1380 */       if (postEventsForChanges()) {
/* 1381 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSourceModifier));
/*      */       }
/*      */     } 
/*      */     
/* 1385 */     this._sourceModifier = argSourceModifier;
/* 1386 */     if (postEventsForChanges()) {
/* 1387 */       this._events.post(IOrderLine.SET_SOURCEMODIFIER, argSourceModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "FulfillmentModifier")
/*      */   public IFulfillmentModifier getFulfillmentModifier() {
/* 1393 */     return this._fulfillmentModifier;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFulfillmentModifier(IFulfillmentModifier argFulfillmentModifier) {
/* 1398 */     if (argFulfillmentModifier == null) {
/*      */       
/* 1400 */       if (this._fulfillmentModifier != null) {
/* 1401 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1403 */       if (this._fulfillmentModifier != null) {
/*      */         
/* 1405 */         if (postEventsForChanges()) {
/* 1406 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._fulfillmentModifier));
/*      */         }
/* 1408 */         addDeletedObject((IDataModel)this._fulfillmentModifier);
/*      */       } 
/*      */     } else {
/*      */       
/* 1412 */       argFulfillmentModifier.setOrganizationId(getOrganizationId());
/* 1413 */       argFulfillmentModifier.setOrderId(getOrderId());
/* 1414 */       argFulfillmentModifier.setSequence(getSequence());
/*      */ 
/*      */       
/* 1417 */       argFulfillmentModifier.setParentLine(this);
/*      */ 
/*      */       
/* 1420 */       if (postEventsForChanges()) {
/* 1421 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFulfillmentModifier));
/*      */       }
/*      */     } 
/*      */     
/* 1425 */     this._fulfillmentModifier = argFulfillmentModifier;
/* 1426 */     if (postEventsForChanges()) {
/* 1427 */       this._events.post(IOrderLine.SET_FULFILLMENTMODIFIER, argFulfillmentModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "BalanceModifiers")
/*      */   public List<IBalanceModifier> getBalanceModifiers() {
/* 1433 */     if (this._balanceModifiers == null) {
/* 1434 */       this._balanceModifiers = new HistoricalList(null);
/*      */     }
/* 1436 */     return (List<IBalanceModifier>)this._balanceModifiers;
/*      */   }
/*      */   
/*      */   public void setBalanceModifiers(List<IBalanceModifier> argBalanceModifiers) {
/* 1440 */     if (this._balanceModifiers == null) {
/* 1441 */       this._balanceModifiers = new HistoricalList(argBalanceModifiers);
/*      */     } else {
/* 1443 */       this._balanceModifiers.setCurrentList(argBalanceModifiers);
/*      */     } 
/*      */     
/* 1446 */     for (IBalanceModifier child : this._balanceModifiers) {
/* 1447 */       child.setParentOrderLine(this);
/*      */     }
/*      */     
/* 1450 */     for (IBalanceModifier child : this._balanceModifiers) {
/* 1451 */       BalanceModifierModel model = (BalanceModifierModel)child;
/* 1452 */       model.setOrganizationId_noev(getOrganizationId());
/* 1453 */       model.setOrderId_noev(getOrderId());
/* 1454 */       model.setSequence_noev(getSequence());
/* 1455 */       if (child instanceof IDataModelImpl) {
/* 1456 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1457 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1458 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1459 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1462 */       if (postEventsForChanges()) {
/* 1463 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addBalanceModifierImpl(IBalanceModifier argBalanceModifier) {
/* 1470 */     argBalanceModifier.setParentOrderLine(this);
/* 1471 */     if (this._balanceModifiers == null) {
/* 1472 */       this._balanceModifiers = new HistoricalList(null);
/*      */     }
/* 1474 */     argBalanceModifier.setOrganizationId(getOrganizationId());
/* 1475 */     argBalanceModifier.setOrderId(getOrderId());
/* 1476 */     argBalanceModifier.setSequence(getSequence());
/* 1477 */     if (argBalanceModifier instanceof IDataModelImpl) {
/* 1478 */       IDataAccessObject childDao = ((IDataModelImpl)argBalanceModifier).getDAO();
/* 1479 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1480 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1481 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1486 */     if (postEventsForChanges()) {
/* 1487 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argBalanceModifier));
/*      */     }
/*      */     
/* 1490 */     this._balanceModifiers.add(argBalanceModifier);
/* 1491 */     if (postEventsForChanges()) {
/* 1492 */       this._events.post(IOrderLine.ADD_BALANCEMODIFIERS, argBalanceModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeBalanceModifier(IBalanceModifier argBalanceModifier) {
/* 1497 */     if (this._balanceModifiers != null) {
/*      */       
/* 1499 */       if (postEventsForChanges()) {
/* 1500 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argBalanceModifier));
/*      */       }
/* 1502 */       this._balanceModifiers.remove(argBalanceModifier);
/*      */       
/* 1504 */       argBalanceModifier.setParentOrderLine(null);
/* 1505 */       if (postEventsForChanges()) {
/* 1506 */         this._events.post(IOrderLine.REMOVE_BALANCEMODIFIERS, argBalanceModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustomizationModifiers")
/*      */   public List<ICustomizationModifier> getCustomizationModifiers() {
/* 1513 */     if (this._customizationModifiers == null) {
/* 1514 */       this._customizationModifiers = new HistoricalList(null);
/*      */     }
/* 1516 */     return (List<ICustomizationModifier>)this._customizationModifiers;
/*      */   }
/*      */   
/*      */   public void setCustomizationModifiers(List<ICustomizationModifier> argCustomizationModifiers) {
/* 1520 */     if (this._customizationModifiers == null) {
/* 1521 */       this._customizationModifiers = new HistoricalList(argCustomizationModifiers);
/*      */     } else {
/* 1523 */       this._customizationModifiers.setCurrentList(argCustomizationModifiers);
/*      */     } 
/*      */     
/* 1526 */     for (ICustomizationModifier child : this._customizationModifiers) {
/* 1527 */       child.setParentOrderLine(this);
/*      */     }
/*      */     
/* 1530 */     for (ICustomizationModifier child : this._customizationModifiers) {
/* 1531 */       CustomizationModifierModel model = (CustomizationModifierModel)child;
/* 1532 */       model.setOrganizationId_noev(getOrganizationId());
/* 1533 */       model.setOrderId_noev(getOrderId());
/* 1534 */       model.setSequence_noev(getSequence());
/* 1535 */       if (child instanceof IDataModelImpl) {
/* 1536 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1537 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1538 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1539 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1542 */       if (postEventsForChanges()) {
/* 1543 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addCustomizationModifierImpl(ICustomizationModifier argCustomizationModifier) {
/* 1550 */     argCustomizationModifier.setParentOrderLine(this);
/* 1551 */     if (this._customizationModifiers == null) {
/* 1552 */       this._customizationModifiers = new HistoricalList(null);
/*      */     }
/* 1554 */     argCustomizationModifier.setOrganizationId(getOrganizationId());
/* 1555 */     argCustomizationModifier.setOrderId(getOrderId());
/* 1556 */     argCustomizationModifier.setSequence(getSequence());
/* 1557 */     if (argCustomizationModifier instanceof IDataModelImpl) {
/* 1558 */       IDataAccessObject childDao = ((IDataModelImpl)argCustomizationModifier).getDAO();
/* 1559 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1560 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1561 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1566 */     if (postEventsForChanges()) {
/* 1567 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomizationModifier));
/*      */     }
/*      */     
/* 1570 */     this._customizationModifiers.add(argCustomizationModifier);
/* 1571 */     if (postEventsForChanges()) {
/* 1572 */       this._events.post(IOrderLine.ADD_CUSTOMIZATIONMODIFIERS, argCustomizationModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCustomizationModifier(ICustomizationModifier argCustomizationModifier) {
/* 1577 */     if (this._customizationModifiers != null) {
/*      */       
/* 1579 */       if (postEventsForChanges()) {
/* 1580 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomizationModifier));
/*      */       }
/* 1582 */       this._customizationModifiers.remove(argCustomizationModifier);
/*      */       
/* 1584 */       argCustomizationModifier.setParentOrderLine(null);
/* 1585 */       if (postEventsForChanges()) {
/* 1586 */         this._events.post(IOrderLine.REMOVE_CUSTOMIZATIONMODIFIERS, argCustomizationModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Fees")
/*      */   public List<IFeeModifier> getFees() {
/* 1593 */     if (this._fees == null) {
/* 1594 */       this._fees = new HistoricalList(null);
/*      */     }
/* 1596 */     return (List<IFeeModifier>)this._fees;
/*      */   }
/*      */   
/*      */   public void setFees(List<IFeeModifier> argFees) {
/* 1600 */     if (this._fees == null) {
/* 1601 */       this._fees = new HistoricalList(argFees);
/*      */     } else {
/* 1603 */       this._fees.setCurrentList(argFees);
/*      */     } 
/*      */     
/* 1606 */     for (IFeeModifier child : this._fees) {
/* 1607 */       child.setParentOrderLine(this);
/*      */     }
/*      */     
/* 1610 */     for (IFeeModifier child : this._fees) {
/* 1611 */       FeeModifierModel model = (FeeModifierModel)child;
/* 1612 */       model.setOrganizationId_noev(getOrganizationId());
/* 1613 */       model.setOrderId_noev(getOrderId());
/* 1614 */       model.setSequence_noev(getSequence());
/* 1615 */       if (child instanceof IDataModelImpl) {
/* 1616 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1617 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1618 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1619 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1622 */       if (postEventsForChanges()) {
/* 1623 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addFeeModifierImpl(IFeeModifier argFeeModifier) {
/* 1630 */     argFeeModifier.setParentOrderLine(this);
/* 1631 */     if (this._fees == null) {
/* 1632 */       this._fees = new HistoricalList(null);
/*      */     }
/* 1634 */     argFeeModifier.setOrganizationId(getOrganizationId());
/* 1635 */     argFeeModifier.setOrderId(getOrderId());
/* 1636 */     argFeeModifier.setSequence(getSequence());
/* 1637 */     if (argFeeModifier instanceof IDataModelImpl) {
/* 1638 */       IDataAccessObject childDao = ((IDataModelImpl)argFeeModifier).getDAO();
/* 1639 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1640 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1641 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1646 */     if (postEventsForChanges()) {
/* 1647 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFeeModifier));
/*      */     }
/*      */     
/* 1650 */     this._fees.add(argFeeModifier);
/* 1651 */     if (postEventsForChanges()) {
/* 1652 */       this._events.post(IOrderLine.ADD_FEES, argFeeModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeFeeModifier(IFeeModifier argFeeModifier) {
/* 1657 */     if (this._fees != null) {
/*      */       
/* 1659 */       if (postEventsForChanges()) {
/* 1660 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argFeeModifier));
/*      */       }
/* 1662 */       this._fees.remove(argFeeModifier);
/*      */       
/* 1664 */       argFeeModifier.setParentOrderLine(null);
/* 1665 */       if (postEventsForChanges()) {
/* 1666 */         this._events.post(IOrderLine.REMOVE_FEES, argFeeModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Item")
/*      */   public IItemModifier getItem() {
/* 1673 */     return this._item;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setItem(IItemModifier argItem) {
/* 1678 */     if (argItem == null) {
/*      */       
/* 1680 */       if (this._item != null) {
/* 1681 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 1683 */       if (this._item != null) {
/*      */         
/* 1685 */         if (postEventsForChanges()) {
/* 1686 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*      */         }
/* 1688 */         addDeletedObject((IDataModel)this._item);
/*      */       } 
/*      */     } else {
/*      */       
/* 1692 */       argItem.setOrganizationId(getOrganizationId());
/* 1693 */       argItem.setOrderId(getOrderId());
/* 1694 */       argItem.setSequence(getSequence());
/*      */ 
/*      */       
/* 1697 */       if (postEventsForChanges()) {
/* 1698 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*      */       }
/*      */     } 
/*      */     
/* 1702 */     this._item = argItem;
/* 1703 */     if (postEventsForChanges()) {
/* 1704 */       this._events.post(IOrderLine.SET_ITEM, argItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IOrderLineProperty> getProperties() {
/* 1710 */     if (this._properties == null) {
/* 1711 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1713 */     return (List<IOrderLineProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IOrderLineProperty> argProperties) {
/* 1717 */     if (this._properties == null) {
/* 1718 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1720 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1723 */     for (IOrderLineProperty child : this._properties) {
/* 1724 */       OrderLinePropertyModel model = (OrderLinePropertyModel)child;
/* 1725 */       model.setOrganizationId_noev(getOrganizationId());
/* 1726 */       model.setOrderId_noev(getOrderId());
/* 1727 */       model.setSequence_noev(getSequence());
/* 1728 */       if (child instanceof IDataModelImpl) {
/* 1729 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1730 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1731 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1732 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1735 */       if (postEventsForChanges()) {
/* 1736 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addOrderLineProperty(IOrderLineProperty argOrderLineProperty) {
/* 1742 */     if (this._properties == null) {
/* 1743 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1745 */     argOrderLineProperty.setOrganizationId(getOrganizationId());
/* 1746 */     argOrderLineProperty.setOrderId(getOrderId());
/* 1747 */     argOrderLineProperty.setSequence(getSequence());
/* 1748 */     if (argOrderLineProperty instanceof IDataModelImpl) {
/* 1749 */       IDataAccessObject childDao = ((IDataModelImpl)argOrderLineProperty).getDAO();
/* 1750 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1751 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1752 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1757 */     if (postEventsForChanges()) {
/* 1758 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderLineProperty));
/*      */     }
/*      */     
/* 1761 */     this._properties.add(argOrderLineProperty);
/* 1762 */     if (postEventsForChanges()) {
/* 1763 */       this._events.post(IOrderLine.ADD_PROPERTIES, argOrderLineProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeOrderLineProperty(IOrderLineProperty argOrderLineProperty) {
/* 1768 */     if (this._properties != null) {
/*      */       
/* 1770 */       if (postEventsForChanges()) {
/* 1771 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderLineProperty));
/*      */       }
/* 1773 */       this._properties.remove(argOrderLineProperty);
/* 1774 */       if (postEventsForChanges()) {
/* 1775 */         this._events.post(IOrderLine.REMOVE_PROPERTIES, argOrderLineProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setParentOrder(IOrder argParentOrder) {
/* 1781 */     this._parentOrder = argParentOrder;
/*      */   }
/*      */   
/*      */   public IOrder getParentOrder() {
/* 1785 */     return this._parentOrder;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1790 */     if ("SourceModifier".equals(argFieldId)) {
/* 1791 */       return getSourceModifier();
/*      */     }
/* 1793 */     if ("FulfillmentModifier".equals(argFieldId)) {
/* 1794 */       return getFulfillmentModifier();
/*      */     }
/* 1796 */     if ("BalanceModifiers".equals(argFieldId)) {
/* 1797 */       return getBalanceModifiers();
/*      */     }
/* 1799 */     if ("CustomizationModifiers".equals(argFieldId)) {
/* 1800 */       return getCustomizationModifiers();
/*      */     }
/* 1802 */     if ("Fees".equals(argFieldId)) {
/* 1803 */       return getFees();
/*      */     }
/* 1805 */     if ("Item".equals(argFieldId)) {
/* 1806 */       return getItem();
/*      */     }
/* 1808 */     if ("Properties".equals(argFieldId)) {
/* 1809 */       return getProperties();
/*      */     }
/* 1811 */     if ("OrderLineExtension".equals(argFieldId)) {
/* 1812 */       return this._myExtension;
/*      */     }
/*      */     
/* 1815 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1821 */     if ("SourceModifier".equals(argFieldId)) {
/* 1822 */       setSourceModifier((ISourceModifier)argValue);
/*      */     }
/* 1824 */     else if ("FulfillmentModifier".equals(argFieldId)) {
/* 1825 */       setFulfillmentModifier((IFulfillmentModifier)argValue);
/*      */     }
/* 1827 */     else if ("BalanceModifiers".equals(argFieldId)) {
/* 1828 */       setBalanceModifiers(changeToList(argValue, IBalanceModifier.class));
/*      */     }
/* 1830 */     else if ("CustomizationModifiers".equals(argFieldId)) {
/* 1831 */       setCustomizationModifiers(changeToList(argValue, ICustomizationModifier.class));
/*      */     }
/* 1833 */     else if ("Fees".equals(argFieldId)) {
/* 1834 */       setFees(changeToList(argValue, IFeeModifier.class));
/*      */     }
/* 1836 */     else if ("Item".equals(argFieldId)) {
/* 1837 */       setItem((IItemModifier)argValue);
/*      */     }
/* 1839 */     else if ("Properties".equals(argFieldId)) {
/* 1840 */       setProperties(changeToList(argValue, IOrderLineProperty.class));
/*      */     }
/* 1842 */     else if ("OrderLineExtension".equals(argFieldId)) {
/* 1843 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1846 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1852 */     this._persistenceDefaults = argPD;
/* 1853 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1854 */     this._eventManager = argEM;
/* 1855 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1856 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1857 */     if (this._sourceModifier != null) {
/* 1858 */       ((IDataModelImpl)this._sourceModifier).setDependencies(argPD, argEM);
/*      */     }
/* 1860 */     if (this._fulfillmentModifier != null) {
/* 1861 */       ((IDataModelImpl)this._fulfillmentModifier).setDependencies(argPD, argEM);
/*      */     }
/* 1863 */     if (this._balanceModifiers != null) {
/* 1864 */       for (IBalanceModifier relationship : this._balanceModifiers) {
/* 1865 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1868 */     if (this._customizationModifiers != null) {
/* 1869 */       for (ICustomizationModifier relationship : this._customizationModifiers) {
/* 1870 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1873 */     if (this._fees != null) {
/* 1874 */       for (IFeeModifier relationship : this._fees) {
/* 1875 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1878 */     if (this._item != null) {
/* 1879 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*      */     }
/* 1881 */     if (this._properties != null) {
/* 1882 */       for (IOrderLineProperty relationship : this._properties) {
/* 1883 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getOrderLineExt() {
/* 1889 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setOrderLineExt(IDataModel argExt) {
/* 1893 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1898 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1902 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1905 */     super.startTransaction();
/*      */     
/* 1907 */     this._sourceModifierSavepoint = this._sourceModifier;
/* 1908 */     if (this._sourceModifier != null) {
/* 1909 */       this._sourceModifier.startTransaction();
/*      */     }
/*      */     
/* 1912 */     this._fulfillmentModifierSavepoint = this._fulfillmentModifier;
/* 1913 */     if (this._fulfillmentModifier != null) {
/* 1914 */       this._fulfillmentModifier.startTransaction();
/*      */     }
/*      */     
/* 1917 */     this._balanceModifiersSavepoint = this._balanceModifiers;
/* 1918 */     if (this._balanceModifiers != null) {
/* 1919 */       this._balanceModifiersSavepoint = new HistoricalList((List)this._balanceModifiers);
/* 1920 */       Iterator<IDataModel> it = this._balanceModifiers.iterator();
/* 1921 */       while (it.hasNext()) {
/* 1922 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1926 */     this._customizationModifiersSavepoint = this._customizationModifiers;
/* 1927 */     if (this._customizationModifiers != null) {
/* 1928 */       this._customizationModifiersSavepoint = new HistoricalList((List)this._customizationModifiers);
/* 1929 */       Iterator<IDataModel> it = this._customizationModifiers.iterator();
/* 1930 */       while (it.hasNext()) {
/* 1931 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1935 */     this._feesSavepoint = this._fees;
/* 1936 */     if (this._fees != null) {
/* 1937 */       this._feesSavepoint = new HistoricalList((List)this._fees);
/* 1938 */       Iterator<IDataModel> it = this._fees.iterator();
/* 1939 */       while (it.hasNext()) {
/* 1940 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1944 */     this._itemSavepoint = this._item;
/* 1945 */     if (this._item != null) {
/* 1946 */       this._item.startTransaction();
/*      */     }
/*      */     
/* 1949 */     this._propertiesSavepoint = this._properties;
/* 1950 */     if (this._properties != null) {
/* 1951 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1952 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1953 */       while (it.hasNext()) {
/* 1954 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1959 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1964 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1967 */     super.rollbackChanges();
/*      */     
/* 1969 */     this._sourceModifier = this._sourceModifierSavepoint;
/* 1970 */     this._sourceModifierSavepoint = null;
/* 1971 */     if (this._sourceModifier != null) {
/* 1972 */       this._sourceModifier.rollbackChanges();
/*      */     }
/*      */     
/* 1975 */     this._fulfillmentModifier = this._fulfillmentModifierSavepoint;
/* 1976 */     this._fulfillmentModifierSavepoint = null;
/* 1977 */     if (this._fulfillmentModifier != null) {
/* 1978 */       this._fulfillmentModifier.rollbackChanges();
/*      */     }
/*      */     
/* 1981 */     this._balanceModifiers = this._balanceModifiersSavepoint;
/* 1982 */     this._balanceModifiersSavepoint = null;
/* 1983 */     if (this._balanceModifiers != null) {
/* 1984 */       Iterator<IDataModel> it = this._balanceModifiers.iterator();
/* 1985 */       while (it.hasNext()) {
/* 1986 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1990 */     this._customizationModifiers = this._customizationModifiersSavepoint;
/* 1991 */     this._customizationModifiersSavepoint = null;
/* 1992 */     if (this._customizationModifiers != null) {
/* 1993 */       Iterator<IDataModel> it = this._customizationModifiers.iterator();
/* 1994 */       while (it.hasNext()) {
/* 1995 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 1999 */     this._fees = this._feesSavepoint;
/* 2000 */     this._feesSavepoint = null;
/* 2001 */     if (this._fees != null) {
/* 2002 */       Iterator<IDataModel> it = this._fees.iterator();
/* 2003 */       while (it.hasNext()) {
/* 2004 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2008 */     this._item = this._itemSavepoint;
/* 2009 */     this._itemSavepoint = null;
/* 2010 */     if (this._item != null) {
/* 2011 */       this._item.rollbackChanges();
/*      */     }
/*      */     
/* 2014 */     this._properties = this._propertiesSavepoint;
/* 2015 */     this._propertiesSavepoint = null;
/* 2016 */     if (this._properties != null) {
/* 2017 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2018 */       while (it.hasNext()) {
/* 2019 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 2027 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 2030 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 2033 */     super.commitTransaction();
/*      */     
/* 2035 */     this._sourceModifierSavepoint = this._sourceModifier;
/* 2036 */     if (this._sourceModifier != null) {
/* 2037 */       this._sourceModifier.commitTransaction();
/*      */     }
/*      */     
/* 2040 */     this._fulfillmentModifierSavepoint = this._fulfillmentModifier;
/* 2041 */     if (this._fulfillmentModifier != null) {
/* 2042 */       this._fulfillmentModifier.commitTransaction();
/*      */     }
/*      */     
/* 2045 */     this._balanceModifiersSavepoint = this._balanceModifiers;
/* 2046 */     if (this._balanceModifiers != null) {
/* 2047 */       Iterator<IDataModel> it = this._balanceModifiers.iterator();
/* 2048 */       while (it.hasNext()) {
/* 2049 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2051 */       this._balanceModifiers = new HistoricalList((List)this._balanceModifiers);
/*      */     } 
/*      */     
/* 2054 */     this._customizationModifiersSavepoint = this._customizationModifiers;
/* 2055 */     if (this._customizationModifiers != null) {
/* 2056 */       Iterator<IDataModel> it = this._customizationModifiers.iterator();
/* 2057 */       while (it.hasNext()) {
/* 2058 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2060 */       this._customizationModifiers = new HistoricalList((List)this._customizationModifiers);
/*      */     } 
/*      */     
/* 2063 */     this._feesSavepoint = this._fees;
/* 2064 */     if (this._fees != null) {
/* 2065 */       Iterator<IDataModel> it = this._fees.iterator();
/* 2066 */       while (it.hasNext()) {
/* 2067 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2069 */       this._fees = new HistoricalList((List)this._fees);
/*      */     } 
/*      */     
/* 2072 */     this._itemSavepoint = this._item;
/* 2073 */     if (this._item != null) {
/* 2074 */       this._item.commitTransaction();
/*      */     }
/*      */     
/* 2077 */     this._propertiesSavepoint = this._properties;
/* 2078 */     if (this._properties != null) {
/* 2079 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2080 */       while (it.hasNext()) {
/* 2081 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2083 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 2087 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 2092 */     argStream.defaultReadObject();
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
/* 2104 */   private transient ISaleReturnLineItem _shadowedSaleItem = null;
/* 2105 */   private transient ILocateItemData _locateItemData = null;
/* 2106 */   private transient IShipperMethod _selectedShipMethodObject = null;
/* 2107 */   private transient IShipperMethod _actualShipMethodObject = null;
/* 2108 */   private transient String _taxType = null;
/*      */ 
/*      */   
/*      */   public ILocateItemData getLocateItemData() {
/* 2112 */     return this._locateItemData;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLocateItemData(ILocateItemData argLocateItemData) {
/* 2117 */     this._locateItemData = argLocateItemData;
/*      */   }
/*      */ 
/*      */   
/*      */   public ISaleReturnLineItem getShadowedSaleItem() {
/* 2122 */     return this._shadowedSaleItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setShadowedSaleItem(ISaleReturnLineItem argSaleItem) {
/* 2127 */     this._shadowedSaleItem = argSaleItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public IShipperMethod getSelectedShipMethodObject() {
/* 2132 */     if (this._selectedShipMethodObject == null && !StringUtils.isEmpty(getSelectedShipMethod())) {
/* 2133 */       this._selectedShipMethodObject = getShipperMethodForId(getSelectedShipMethod());
/*      */     }
/*      */     
/* 2136 */     return this._selectedShipMethodObject;
/*      */   }
/*      */ 
/*      */   
/*      */   public IShipperMethod getActualShipMethodObject() {
/* 2141 */     if (this._actualShipMethodObject == null && !StringUtils.isEmpty(getActualShipMethod())) {
/* 2142 */       this._actualShipMethodObject = getShipperMethodForId(getActualShipMethod());
/*      */     }
/*      */     
/* 2145 */     return this._actualShipMethodObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBalanceModifier(IBalanceModifier argModifier) {
/* 2152 */     synchronized (this) {
/* 2153 */       argModifier.setModSequence(getBalanceModifiers().size() + 1);
/*      */     } 
/*      */     
/* 2156 */     addBalanceModifierImpl(argModifier);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCustomizationModifier(ICustomizationModifier argModifier) {
/* 2163 */     synchronized (this) {
/* 2164 */       argModifier.setModSequence(getCustomizationModifiers().size() + 1);
/*      */     } 
/*      */     
/* 2167 */     addCustomizationModifierImpl(argModifier);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addFeeModifier(IFeeModifier argModifier) {
/* 2174 */     synchronized (this) {
/* 2175 */       argModifier.setModSequence(getFees().size() + 1);
/*      */     } 
/*      */     
/* 2178 */     addFeeModifierImpl(argModifier);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelectedShipMethod(String argSelectedShipMethod) {
/* 2185 */     setSelectedShipMethodImpl(argSelectedShipMethod);
/* 2186 */     this._selectedShipMethodObject = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OrderDetailType getDetailType() {
/* 2193 */     return OrderDetailType.ITEM;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private IShipperMethod getShipperMethodForId(String argShipperMethod) {
/* 2202 */     ShipperMethodId id = new ShipperMethodId();
/* 2203 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 2204 */     id.setShipperMethodId(argShipperMethod);
/* 2205 */     IShipperMethod shipperMethod = (IShipperMethod)DataFactory.getObjectByIdNoThrow((IObjectId)id);
/*      */     
/* 2207 */     return shipperMethod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxType(String argTaxType) {
/* 2215 */     this._taxType = argTaxType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxType() {
/* 2222 */     return this._taxType;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\OrderLineModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */