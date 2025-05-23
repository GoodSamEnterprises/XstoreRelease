/*      */ package dtv.xst.dao.trl.impl;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.inv.IInventoryDocumentLineItem;
/*      */ import dtv.xst.dao.inv.impl.InventoryDocumentLineItemModel;
/*      */ import dtv.xst.dao.trl.ICommissionModifier;
/*      */ import dtv.xst.dao.trl.IDimensionModifier;
/*      */ import dtv.xst.dao.trl.IKitComponentModifier;
/*      */ import dtv.xst.dao.trl.ILineItemAssociationModifier;
/*      */ import dtv.xst.dao.trl.IRetailInventoryLocationModifier;
/*      */ import dtv.xst.dao.trl.IRetailPriceModifier;
/*      */ import dtv.xst.dao.trl.IRetailTransactionLineItemNotes;
/*      */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*      */ import dtv.xst.dao.trl.ISaleTaxModifier;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class SaleReturnLineItemModel extends RetailTransactionLineItemModel implements ISaleReturnLineItem {
/*      */   private static final long serialVersionUID = -1387284802L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private IReturnedItemCount _baseReturnedQuantity;
/*      */   private transient IReturnedItemCount _baseReturnedQuantitySavepoint;
/*      */   private HistoricalList<ICommissionModifier> _commissionModifiers;
/*      */   private transient HistoricalList<ICommissionModifier> _commissionModifiersSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   37 */     setDAO((IDataAccessObject)new SaleReturnLineItemDAO());
/*      */   }
/*      */   private HistoricalList<IDimensionModifier> _dimensionModifiers; private transient HistoricalList<IDimensionModifier> _dimensionModifiersSavepoint; private HistoricalList<IInventoryDocumentLineItem> _inventoryDocumentLineItems; private transient HistoricalList<IInventoryDocumentLineItem> _inventoryDocumentLineItemsSavepoint; private HistoricalList<ILineItemAssociationModifier> _lineItemAssociationModifiers; private transient HistoricalList<ILineItemAssociationModifier> _lineItemAssociationModifiersSavepoint; private HistoricalList<IRetailPriceModifier> _retailPriceModifiers; private transient HistoricalList<IRetailPriceModifier> _retailPriceModifiersSavepoint; private ITaxGroup _taxGroup; private transient ITaxGroup _taxGroupSavepoint; private HistoricalList<ISaleTaxModifier> _taxModifiers; private transient HistoricalList<ISaleTaxModifier> _taxModifiersSavepoint; private ICustomerItemAccountModifier _customerAccountModifier; private transient ICustomerItemAccountModifier _customerAccountModifierSavepoint; private IItem _item; private transient IItem _itemSavepoint; private HistoricalList<IRetailTransactionLineItemNotes> _noteSeq; private transient HistoricalList<IRetailTransactionLineItemNotes> _noteSeqSavepoint; private HistoricalList<IRetailInventoryLocationModifier> _retailInventoryLocationModifiers; private transient HistoricalList<IRetailInventoryLocationModifier> _retailInventoryLocationModifiersSavepoint; private IOrderModifier _orderModifier; private transient IOrderModifier _orderModifierSavepoint; private HistoricalList<IKitComponentModifier> _kitComponentModifiers;
/*      */   private transient HistoricalList<IKitComponentModifier> _kitComponentModifiersSavepoint;
/*      */   private boolean _priceChanged;
/*      */   private boolean _discounted;
/*      */   
/*      */   private SaleReturnLineItemDAO getDAO_() {
/*   45 */     return (SaleReturnLineItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   53 */     if (getDAO_().getOrganizationId() != null) {
/*   54 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   57 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   66 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   67 */       this._events != null && 
/*   68 */       postEventsForChanges()) {
/*   69 */       this._events.post(ISaleReturnLineItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   76 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*   79 */     if (super.setOrganizationId_noev(argOrganizationId)) {
/*   80 */       if (this._commissionModifiers != null) {
/*      */         
/*   82 */         Iterator<CommissionModifierModel> it = this._commissionModifiers.iterator();
/*   83 */         while (it.hasNext())
/*      */         {
/*   85 */           ((CommissionModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   88 */       if (this._dimensionModifiers != null) {
/*      */         
/*   90 */         Iterator<DimensionModifierModel> it = this._dimensionModifiers.iterator();
/*   91 */         while (it.hasNext())
/*      */         {
/*   93 */           ((DimensionModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   96 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*   98 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*   99 */         while (it.hasNext())
/*      */         {
/*  101 */           ((InventoryDocumentLineItemModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  104 */       if (this._lineItemAssociationModifiers != null) {
/*      */         
/*  106 */         Iterator<LineItemAssociationModifierModel> it = this._lineItemAssociationModifiers.iterator();
/*  107 */         while (it.hasNext())
/*      */         {
/*  109 */           ((LineItemAssociationModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  112 */       if (this._retailPriceModifiers != null) {
/*      */         
/*  114 */         Iterator<RetailPriceModifierModel> it = this._retailPriceModifiers.iterator();
/*  115 */         while (it.hasNext())
/*      */         {
/*  117 */           ((RetailPriceModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  120 */       if (this._taxModifiers != null) {
/*      */         
/*  122 */         Iterator<SaleTaxModifierModel> it = this._taxModifiers.iterator();
/*  123 */         while (it.hasNext())
/*      */         {
/*  125 */           ((SaleTaxModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  128 */       if (this._noteSeq != null) {
/*      */         
/*  130 */         Iterator<RetailTransactionLineItemNotesModel> it = this._noteSeq.iterator();
/*  131 */         while (it.hasNext())
/*      */         {
/*  133 */           ((RetailTransactionLineItemNotesModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  136 */       if (this._retailInventoryLocationModifiers != null) {
/*      */         
/*  138 */         Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  139 */         while (it.hasNext())
/*      */         {
/*  141 */           ((RetailInventoryLocationModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  144 */       if (this._kitComponentModifiers != null) {
/*      */         
/*  146 */         Iterator<KitComponentModifierModel> it = this._kitComponentModifiers.iterator();
/*  147 */         while (it.hasNext())
/*      */         {
/*  149 */           ((KitComponentModifierModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  152 */       if (this._baseReturnedQuantity != null)
/*      */       {
/*      */         
/*  155 */         ((ReturnedItemCountModel)this._baseReturnedQuantity).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  157 */       if (this._customerAccountModifier != null)
/*      */       {
/*      */         
/*  160 */         ((CustomerItemAccountModifierModel)this._customerAccountModifier).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*  162 */       if (this._orderModifier != null)
/*      */       {
/*      */         
/*  165 */         ((OrderModifierModel)this._orderModifier).setOrganizationId_noev(argOrganizationId);
/*      */       }
/*      */     } 
/*      */     
/*  169 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRetailLocationId() {
/*  177 */     if (getDAO_().getRetailLocationId() != null) {
/*  178 */       return getDAO_().getRetailLocationId().longValue();
/*      */     }
/*      */     
/*  181 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailLocationId(long argRetailLocationId) {
/*  190 */     if (setRetailLocationId_noev(argRetailLocationId) && 
/*  191 */       this._events != null && 
/*  192 */       postEventsForChanges()) {
/*  193 */       this._events.post(ISaleReturnLineItem.SET_RETAILLOCATIONID, Long.valueOf(argRetailLocationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailLocationId_noev(long argRetailLocationId) {
/*  200 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  203 */     if (super.setRetailLocationId_noev(argRetailLocationId)) {
/*  204 */       if (this._commissionModifiers != null) {
/*      */         
/*  206 */         Iterator<CommissionModifierModel> it = this._commissionModifiers.iterator();
/*  207 */         while (it.hasNext())
/*      */         {
/*  209 */           ((CommissionModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  212 */       if (this._dimensionModifiers != null) {
/*      */         
/*  214 */         Iterator<DimensionModifierModel> it = this._dimensionModifiers.iterator();
/*  215 */         while (it.hasNext())
/*      */         {
/*  217 */           ((DimensionModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  220 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  222 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  223 */         while (it.hasNext())
/*      */         {
/*  225 */           ((InventoryDocumentLineItemModel)it.next()).setLineItemRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  228 */       if (this._lineItemAssociationModifiers != null) {
/*      */         
/*  230 */         Iterator<LineItemAssociationModifierModel> it = this._lineItemAssociationModifiers.iterator();
/*  231 */         while (it.hasNext())
/*      */         {
/*  233 */           ((LineItemAssociationModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  236 */       if (this._retailPriceModifiers != null) {
/*      */         
/*  238 */         Iterator<RetailPriceModifierModel> it = this._retailPriceModifiers.iterator();
/*  239 */         while (it.hasNext())
/*      */         {
/*  241 */           ((RetailPriceModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  244 */       if (this._taxModifiers != null) {
/*      */         
/*  246 */         Iterator<SaleTaxModifierModel> it = this._taxModifiers.iterator();
/*  247 */         while (it.hasNext())
/*      */         {
/*  249 */           ((SaleTaxModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  252 */       if (this._noteSeq != null) {
/*      */         
/*  254 */         Iterator<RetailTransactionLineItemNotesModel> it = this._noteSeq.iterator();
/*  255 */         while (it.hasNext())
/*      */         {
/*  257 */           ((RetailTransactionLineItemNotesModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  260 */       if (this._retailInventoryLocationModifiers != null) {
/*      */         
/*  262 */         Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  263 */         while (it.hasNext())
/*      */         {
/*  265 */           ((RetailInventoryLocationModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  268 */       if (this._kitComponentModifiers != null) {
/*      */         
/*  270 */         Iterator<KitComponentModifierModel> it = this._kitComponentModifiers.iterator();
/*  271 */         while (it.hasNext())
/*      */         {
/*  273 */           ((KitComponentModifierModel)it.next()).setRetailLocationId_noev(argRetailLocationId);
/*      */         }
/*      */       } 
/*  276 */       if (this._baseReturnedQuantity != null)
/*      */       {
/*      */         
/*  279 */         ((ReturnedItemCountModel)this._baseReturnedQuantity).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*  281 */       if (this._customerAccountModifier != null)
/*      */       {
/*      */         
/*  284 */         ((CustomerItemAccountModifierModel)this._customerAccountModifier).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*  286 */       if (this._orderModifier != null)
/*      */       {
/*      */         
/*  289 */         ((OrderModifierModel)this._orderModifier).setRetailLocationId_noev(argRetailLocationId);
/*      */       }
/*      */     } 
/*      */     
/*  293 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getBusinessDate() {
/*  301 */     return getDAO_().getBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusinessDate(Date argBusinessDate) {
/*  309 */     if (setBusinessDate_noev(argBusinessDate) && 
/*  310 */       this._events != null && 
/*  311 */       postEventsForChanges()) {
/*  312 */       this._events.post(ISaleReturnLineItem.SET_BUSINESSDATE, argBusinessDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBusinessDate_noev(Date argBusinessDate) {
/*  319 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  322 */     if (super.setBusinessDate_noev(argBusinessDate)) {
/*  323 */       if (this._commissionModifiers != null) {
/*      */         
/*  325 */         Iterator<CommissionModifierModel> it = this._commissionModifiers.iterator();
/*  326 */         while (it.hasNext())
/*      */         {
/*  328 */           ((CommissionModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  331 */       if (this._dimensionModifiers != null) {
/*      */         
/*  333 */         Iterator<DimensionModifierModel> it = this._dimensionModifiers.iterator();
/*  334 */         while (it.hasNext())
/*      */         {
/*  336 */           ((DimensionModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  339 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  341 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  342 */         while (it.hasNext())
/*      */         {
/*  344 */           ((InventoryDocumentLineItemModel)it.next()).setLineItemBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  347 */       if (this._lineItemAssociationModifiers != null) {
/*      */         
/*  349 */         Iterator<LineItemAssociationModifierModel> it = this._lineItemAssociationModifiers.iterator();
/*  350 */         while (it.hasNext())
/*      */         {
/*  352 */           ((LineItemAssociationModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  355 */       if (this._retailPriceModifiers != null) {
/*      */         
/*  357 */         Iterator<RetailPriceModifierModel> it = this._retailPriceModifiers.iterator();
/*  358 */         while (it.hasNext())
/*      */         {
/*  360 */           ((RetailPriceModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  363 */       if (this._taxModifiers != null) {
/*      */         
/*  365 */         Iterator<SaleTaxModifierModel> it = this._taxModifiers.iterator();
/*  366 */         while (it.hasNext())
/*      */         {
/*  368 */           ((SaleTaxModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  371 */       if (this._noteSeq != null) {
/*      */         
/*  373 */         Iterator<RetailTransactionLineItemNotesModel> it = this._noteSeq.iterator();
/*  374 */         while (it.hasNext())
/*      */         {
/*  376 */           ((RetailTransactionLineItemNotesModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  379 */       if (this._retailInventoryLocationModifiers != null) {
/*      */         
/*  381 */         Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  382 */         while (it.hasNext())
/*      */         {
/*  384 */           ((RetailInventoryLocationModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  387 */       if (this._kitComponentModifiers != null) {
/*      */         
/*  389 */         Iterator<KitComponentModifierModel> it = this._kitComponentModifiers.iterator();
/*  390 */         while (it.hasNext())
/*      */         {
/*  392 */           ((KitComponentModifierModel)it.next()).setBusinessDate_noev(argBusinessDate);
/*      */         }
/*      */       } 
/*  395 */       if (this._baseReturnedQuantity != null)
/*      */       {
/*      */         
/*  398 */         ((ReturnedItemCountModel)this._baseReturnedQuantity).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*  400 */       if (this._customerAccountModifier != null)
/*      */       {
/*      */         
/*  403 */         ((CustomerItemAccountModifierModel)this._customerAccountModifier).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*  405 */       if (this._orderModifier != null)
/*      */       {
/*      */         
/*  408 */         ((OrderModifierModel)this._orderModifier).setBusinessDate_noev(argBusinessDate);
/*      */       }
/*      */     } 
/*      */     
/*  412 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWorkstationId() {
/*  420 */     if (getDAO_().getWorkstationId() != null) {
/*  421 */       return getDAO_().getWorkstationId().longValue();
/*      */     }
/*      */     
/*  424 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkstationId(long argWorkstationId) {
/*  433 */     if (setWorkstationId_noev(argWorkstationId) && 
/*  434 */       this._events != null && 
/*  435 */       postEventsForChanges()) {
/*  436 */       this._events.post(ISaleReturnLineItem.SET_WORKSTATIONID, Long.valueOf(argWorkstationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWorkstationId_noev(long argWorkstationId) {
/*  443 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  446 */     if (super.setWorkstationId_noev(argWorkstationId)) {
/*  447 */       if (this._commissionModifiers != null) {
/*      */         
/*  449 */         Iterator<CommissionModifierModel> it = this._commissionModifiers.iterator();
/*  450 */         while (it.hasNext())
/*      */         {
/*  452 */           ((CommissionModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  455 */       if (this._dimensionModifiers != null) {
/*      */         
/*  457 */         Iterator<DimensionModifierModel> it = this._dimensionModifiers.iterator();
/*  458 */         while (it.hasNext())
/*      */         {
/*  460 */           ((DimensionModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  463 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  465 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  466 */         while (it.hasNext())
/*      */         {
/*  468 */           ((InventoryDocumentLineItemModel)it.next()).setLineItemWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  471 */       if (this._lineItemAssociationModifiers != null) {
/*      */         
/*  473 */         Iterator<LineItemAssociationModifierModel> it = this._lineItemAssociationModifiers.iterator();
/*  474 */         while (it.hasNext())
/*      */         {
/*  476 */           ((LineItemAssociationModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  479 */       if (this._retailPriceModifiers != null) {
/*      */         
/*  481 */         Iterator<RetailPriceModifierModel> it = this._retailPriceModifiers.iterator();
/*  482 */         while (it.hasNext())
/*      */         {
/*  484 */           ((RetailPriceModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  487 */       if (this._taxModifiers != null) {
/*      */         
/*  489 */         Iterator<SaleTaxModifierModel> it = this._taxModifiers.iterator();
/*  490 */         while (it.hasNext())
/*      */         {
/*  492 */           ((SaleTaxModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  495 */       if (this._noteSeq != null) {
/*      */         
/*  497 */         Iterator<RetailTransactionLineItemNotesModel> it = this._noteSeq.iterator();
/*  498 */         while (it.hasNext())
/*      */         {
/*  500 */           ((RetailTransactionLineItemNotesModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  503 */       if (this._retailInventoryLocationModifiers != null) {
/*      */         
/*  505 */         Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  506 */         while (it.hasNext())
/*      */         {
/*  508 */           ((RetailInventoryLocationModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  511 */       if (this._kitComponentModifiers != null) {
/*      */         
/*  513 */         Iterator<KitComponentModifierModel> it = this._kitComponentModifiers.iterator();
/*  514 */         while (it.hasNext())
/*      */         {
/*  516 */           ((KitComponentModifierModel)it.next()).setWorkstationId_noev(argWorkstationId);
/*      */         }
/*      */       } 
/*  519 */       if (this._baseReturnedQuantity != null)
/*      */       {
/*      */         
/*  522 */         ((ReturnedItemCountModel)this._baseReturnedQuantity).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*  524 */       if (this._customerAccountModifier != null)
/*      */       {
/*      */         
/*  527 */         ((CustomerItemAccountModifierModel)this._customerAccountModifier).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*  529 */       if (this._orderModifier != null)
/*      */       {
/*      */         
/*  532 */         ((OrderModifierModel)this._orderModifier).setWorkstationId_noev(argWorkstationId);
/*      */       }
/*      */     } 
/*      */     
/*  536 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTransactionSequence() {
/*  544 */     if (getDAO_().getTransactionSequence() != null) {
/*  545 */       return getDAO_().getTransactionSequence().longValue();
/*      */     }
/*      */     
/*  548 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransactionSequence(long argTransactionSequence) {
/*  557 */     if (setTransactionSequence_noev(argTransactionSequence) && 
/*  558 */       this._events != null && 
/*  559 */       postEventsForChanges()) {
/*  560 */       this._events.post(ISaleReturnLineItem.SET_TRANSACTIONSEQUENCE, Long.valueOf(argTransactionSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTransactionSequence_noev(long argTransactionSequence) {
/*  567 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  570 */     if (super.setTransactionSequence_noev(argTransactionSequence)) {
/*  571 */       if (this._commissionModifiers != null) {
/*      */         
/*  573 */         Iterator<CommissionModifierModel> it = this._commissionModifiers.iterator();
/*  574 */         while (it.hasNext())
/*      */         {
/*  576 */           ((CommissionModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  579 */       if (this._dimensionModifiers != null) {
/*      */         
/*  581 */         Iterator<DimensionModifierModel> it = this._dimensionModifiers.iterator();
/*  582 */         while (it.hasNext())
/*      */         {
/*  584 */           ((DimensionModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  587 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  589 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  590 */         while (it.hasNext())
/*      */         {
/*  592 */           ((InventoryDocumentLineItemModel)it.next()).setLineItemTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  595 */       if (this._lineItemAssociationModifiers != null) {
/*      */         
/*  597 */         Iterator<LineItemAssociationModifierModel> it = this._lineItemAssociationModifiers.iterator();
/*  598 */         while (it.hasNext())
/*      */         {
/*  600 */           ((LineItemAssociationModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  603 */       if (this._retailPriceModifiers != null) {
/*      */         
/*  605 */         Iterator<RetailPriceModifierModel> it = this._retailPriceModifiers.iterator();
/*  606 */         while (it.hasNext())
/*      */         {
/*  608 */           ((RetailPriceModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  611 */       if (this._taxModifiers != null) {
/*      */         
/*  613 */         Iterator<SaleTaxModifierModel> it = this._taxModifiers.iterator();
/*  614 */         while (it.hasNext())
/*      */         {
/*  616 */           ((SaleTaxModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  619 */       if (this._noteSeq != null) {
/*      */         
/*  621 */         Iterator<RetailTransactionLineItemNotesModel> it = this._noteSeq.iterator();
/*  622 */         while (it.hasNext())
/*      */         {
/*  624 */           ((RetailTransactionLineItemNotesModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  627 */       if (this._retailInventoryLocationModifiers != null) {
/*      */         
/*  629 */         Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  630 */         while (it.hasNext())
/*      */         {
/*  632 */           ((RetailInventoryLocationModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  635 */       if (this._kitComponentModifiers != null) {
/*      */         
/*  637 */         Iterator<KitComponentModifierModel> it = this._kitComponentModifiers.iterator();
/*  638 */         while (it.hasNext())
/*      */         {
/*  640 */           ((KitComponentModifierModel)it.next()).setTransactionSequence_noev(argTransactionSequence);
/*      */         }
/*      */       } 
/*  643 */       if (this._baseReturnedQuantity != null)
/*      */       {
/*      */         
/*  646 */         ((ReturnedItemCountModel)this._baseReturnedQuantity).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*  648 */       if (this._customerAccountModifier != null)
/*      */       {
/*      */         
/*  651 */         ((CustomerItemAccountModifierModel)this._customerAccountModifier).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*  653 */       if (this._orderModifier != null)
/*      */       {
/*      */         
/*  656 */         ((OrderModifierModel)this._orderModifier).setTransactionSequence_noev(argTransactionSequence);
/*      */       }
/*      */     } 
/*      */     
/*  660 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRetailTransactionLineItemSequence() {
/*  668 */     if (getDAO_().getRetailTransactionLineItemSequence() != null) {
/*  669 */       return getDAO_().getRetailTransactionLineItemSequence().intValue();
/*      */     }
/*      */     
/*  672 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailTransactionLineItemSequence(int argRetailTransactionLineItemSequence) {
/*  681 */     if (setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence) && 
/*  682 */       this._events != null && 
/*  683 */       postEventsForChanges()) {
/*  684 */       this._events.post(ISaleReturnLineItem.SET_RETAILTRANSACTIONLINEITEMSEQUENCE, Integer.valueOf(argRetailTransactionLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRetailTransactionLineItemSequence_noev(int argRetailTransactionLineItemSequence) {
/*  691 */     boolean ev_postable = false;
/*      */ 
/*      */     
/*  694 */     if (super.setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence)) {
/*  695 */       if (this._commissionModifiers != null) {
/*      */         
/*  697 */         Iterator<CommissionModifierModel> it = this._commissionModifiers.iterator();
/*  698 */         while (it.hasNext())
/*      */         {
/*  700 */           ((CommissionModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  703 */       if (this._dimensionModifiers != null) {
/*      */         
/*  705 */         Iterator<DimensionModifierModel> it = this._dimensionModifiers.iterator();
/*  706 */         while (it.hasNext())
/*      */         {
/*  708 */           ((DimensionModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  711 */       if (this._inventoryDocumentLineItems != null) {
/*      */         
/*  713 */         Iterator<InventoryDocumentLineItemModel> it = this._inventoryDocumentLineItems.iterator();
/*  714 */         while (it.hasNext())
/*      */         {
/*  716 */           ((InventoryDocumentLineItemModel)it.next()).setLineItemRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  719 */       if (this._lineItemAssociationModifiers != null) {
/*      */         
/*  721 */         Iterator<LineItemAssociationModifierModel> it = this._lineItemAssociationModifiers.iterator();
/*  722 */         while (it.hasNext())
/*      */         {
/*  724 */           ((LineItemAssociationModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  727 */       if (this._retailPriceModifiers != null) {
/*      */         
/*  729 */         Iterator<RetailPriceModifierModel> it = this._retailPriceModifiers.iterator();
/*  730 */         while (it.hasNext())
/*      */         {
/*  732 */           ((RetailPriceModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  735 */       if (this._taxModifiers != null) {
/*      */         
/*  737 */         Iterator<SaleTaxModifierModel> it = this._taxModifiers.iterator();
/*  738 */         while (it.hasNext())
/*      */         {
/*  740 */           ((SaleTaxModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  743 */       if (this._noteSeq != null) {
/*      */         
/*  745 */         Iterator<RetailTransactionLineItemNotesModel> it = this._noteSeq.iterator();
/*  746 */         while (it.hasNext())
/*      */         {
/*  748 */           ((RetailTransactionLineItemNotesModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  751 */       if (this._retailInventoryLocationModifiers != null) {
/*      */         
/*  753 */         Iterator<RetailInventoryLocationModifierModel> it = this._retailInventoryLocationModifiers.iterator();
/*  754 */         while (it.hasNext())
/*      */         {
/*  756 */           ((RetailInventoryLocationModifierModel)it.next()).setTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  759 */       if (this._kitComponentModifiers != null) {
/*      */         
/*  761 */         Iterator<KitComponentModifierModel> it = this._kitComponentModifiers.iterator();
/*  762 */         while (it.hasNext())
/*      */         {
/*  764 */           ((KitComponentModifierModel)it.next()).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */         }
/*      */       } 
/*  767 */       if (this._baseReturnedQuantity != null)
/*      */       {
/*      */         
/*  770 */         ((ReturnedItemCountModel)this._baseReturnedQuantity).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*  772 */       if (this._customerAccountModifier != null)
/*      */       {
/*      */         
/*  775 */         ((CustomerItemAccountModifierModel)this._customerAccountModifier).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*  777 */       if (this._orderModifier != null)
/*      */       {
/*      */         
/*  780 */         ((OrderModifierModel)this._orderModifier).setRetailTransactionLineItemSequence_noev(argRetailTransactionLineItemSequence);
/*      */       }
/*      */     } 
/*      */     
/*  784 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  792 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  800 */     if (setCreateDate_noev(argCreateDate));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  806 */     boolean ev_postable = false;
/*      */     
/*  808 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  809 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  810 */       getDAO_().setCreateDate(argCreateDate);
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
/*      */   public String getCreateUserId() {
/*  822 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  830 */     if (setCreateUserId_noev(argCreateUserId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  836 */     boolean ev_postable = false;
/*      */     
/*  838 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  839 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  840 */       getDAO_().setCreateUserId(argCreateUserId);
/*  841 */       ev_postable = true;
/*      */     } 
/*      */     
/*  844 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  852 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  860 */     if (setUpdateDate_noev(argUpdateDate));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  866 */     boolean ev_postable = false;
/*      */     
/*  868 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  869 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  870 */       getDAO_().setUpdateDate(argUpdateDate);
/*  871 */       ev_postable = true;
/*      */     } 
/*      */     
/*  874 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  882 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  890 */     if (setUpdateUserId_noev(argUpdateUserId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  896 */     boolean ev_postable = false;
/*      */     
/*  898 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  899 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  900 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  901 */       ev_postable = true;
/*      */     } 
/*      */     
/*  904 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getBaseExtendedPriceImpl() {
/*  912 */     return getDAO_().getBaseExtendedPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setBaseExtendedPriceImpl(BigDecimal argBaseExtendedPrice) {
/*  920 */     if (setBaseExtendedPrice_noev(argBaseExtendedPrice) && 
/*  921 */       this._events != null && 
/*  922 */       postEventsForChanges()) {
/*  923 */       this._events.post(ISaleReturnLineItem.SET_BASEEXTENDEDPRICE, argBaseExtendedPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBaseExtendedPrice_noev(BigDecimal argBaseExtendedPrice) {
/*  930 */     boolean ev_postable = false;
/*      */     
/*  932 */     if ((getDAO_().getBaseExtendedPrice() == null && argBaseExtendedPrice != null) || (
/*  933 */       getDAO_().getBaseExtendedPrice() != null && !getDAO_().getBaseExtendedPrice().equals(argBaseExtendedPrice))) {
/*  934 */       getDAO_().setBaseExtendedPrice(argBaseExtendedPrice);
/*  935 */       ev_postable = true;
/*      */     } 
/*      */     
/*  938 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getBaseUnitPriceImpl() {
/*  946 */     return getDAO_().getBaseUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setBaseUnitPriceImpl(BigDecimal argBaseUnitPrice) {
/*  954 */     if (setBaseUnitPrice_noev(argBaseUnitPrice) && 
/*  955 */       this._events != null && 
/*  956 */       postEventsForChanges()) {
/*  957 */       this._events.post(ISaleReturnLineItem.SET_BASEUNITPRICE, argBaseUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setBaseUnitPrice_noev(BigDecimal argBaseUnitPrice) {
/*  964 */     boolean ev_postable = false;
/*      */     
/*  966 */     if ((getDAO_().getBaseUnitPrice() == null && argBaseUnitPrice != null) || (
/*  967 */       getDAO_().getBaseUnitPrice() != null && !getDAO_().getBaseUnitPrice().equals(argBaseUnitPrice))) {
/*  968 */       getDAO_().setBaseUnitPrice(argBaseUnitPrice);
/*  969 */       ev_postable = true;
/*      */     } 
/*      */     
/*  972 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMerchLevel1Id() {
/*  980 */     return getDAO_().getMerchLevel1Id();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchLevel1Id(String argMerchLevel1Id) {
/*  988 */     if (setMerchLevel1Id_noev(argMerchLevel1Id));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchLevel1Id_noev(String argMerchLevel1Id) {
/*  994 */     boolean ev_postable = false;
/*      */     
/*  996 */     if ((getDAO_().getMerchLevel1Id() == null && argMerchLevel1Id != null) || (
/*  997 */       getDAO_().getMerchLevel1Id() != null && !getDAO_().getMerchLevel1Id().equals(argMerchLevel1Id))) {
/*  998 */       getDAO_().setMerchLevel1Id(argMerchLevel1Id);
/*  999 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1002 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getExtendedAmountImpl() {
/* 1010 */     return getDAO_().getExtendedAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setExtendedAmountImpl(BigDecimal argExtendedAmount) {
/* 1018 */     if (setExtendedAmount_noev(argExtendedAmount) && 
/* 1019 */       this._events != null && 
/* 1020 */       postEventsForChanges()) {
/* 1021 */       this._events.post(ISaleReturnLineItem.SET_EXTENDEDAMOUNT, argExtendedAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExtendedAmount_noev(BigDecimal argExtendedAmount) {
/* 1028 */     boolean ev_postable = false;
/*      */     
/* 1030 */     if ((getDAO_().getExtendedAmount() == null && argExtendedAmount != null) || (
/* 1031 */       getDAO_().getExtendedAmount() != null && !getDAO_().getExtendedAmount().equals(argExtendedAmount))) {
/* 1032 */       getDAO_().setExtendedAmount(argExtendedAmount);
/* 1033 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1036 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getGiftReceiptCount() {
/* 1044 */     if (getDAO_().getGiftReceiptCount() != null) {
/* 1045 */       return getDAO_().getGiftReceiptCount().intValue();
/*      */     }
/*      */     
/* 1048 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGiftReceiptCount(int argGiftReceiptCount) {
/* 1057 */     if (setGiftReceiptCount_noev(argGiftReceiptCount) && 
/* 1058 */       this._events != null && 
/* 1059 */       postEventsForChanges()) {
/* 1060 */       this._events.post(ISaleReturnLineItem.SET_GIFTRECEIPTCOUNT, Integer.valueOf(argGiftReceiptCount));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGiftReceiptCount_noev(int argGiftReceiptCount) {
/* 1067 */     boolean ev_postable = false;
/*      */     
/* 1069 */     if ((getDAO_().getGiftReceiptCount() == null && Integer.valueOf(argGiftReceiptCount) != null) || (
/* 1070 */       getDAO_().getGiftReceiptCount() != null && !getDAO_().getGiftReceiptCount().equals(Integer.valueOf(argGiftReceiptCount)))) {
/* 1071 */       getDAO_().setGiftReceiptCount(Integer.valueOf(argGiftReceiptCount));
/* 1072 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1075 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getGrossAmountImpl() {
/* 1083 */     return getDAO_().getGrossAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setGrossAmountImpl(BigDecimal argGrossAmount) {
/* 1091 */     if (setGrossAmount_noev(argGrossAmount) && 
/* 1092 */       this._events != null && 
/* 1093 */       postEventsForChanges()) {
/* 1094 */       this._events.post(ISaleReturnLineItem.SET_GROSSAMOUNT, argGrossAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGrossAmount_noev(BigDecimal argGrossAmount) {
/* 1101 */     boolean ev_postable = false;
/*      */     
/* 1103 */     if ((getDAO_().getGrossAmount() == null && argGrossAmount != null) || (
/* 1104 */       getDAO_().getGrossAmount() != null && !getDAO_().getGrossAmount().equals(argGrossAmount))) {
/* 1105 */       getDAO_().setGrossAmount(argGrossAmount);
/* 1106 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1109 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInventoryActionCode() {
/* 1117 */     return getDAO_().getInventoryActionCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInventoryActionCode(String argInventoryActionCode) {
/* 1125 */     if (setInventoryActionCode_noev(argInventoryActionCode) && 
/* 1126 */       this._events != null && 
/* 1127 */       postEventsForChanges()) {
/* 1128 */       this._events.post(ISaleReturnLineItem.SET_INVENTORYACTIONCODE, argInventoryActionCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInventoryActionCode_noev(String argInventoryActionCode) {
/* 1135 */     boolean ev_postable = false;
/*      */     
/* 1137 */     if ((getDAO_().getInventoryActionCode() == null && argInventoryActionCode != null) || (
/* 1138 */       getDAO_().getInventoryActionCode() != null && !getDAO_().getInventoryActionCode().equals(argInventoryActionCode))) {
/* 1139 */       getDAO_().setInventoryActionCode(argInventoryActionCode);
/* 1140 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1143 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemId() {
/* 1151 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/* 1159 */     if (setItemId_noev(argItemId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/* 1165 */     boolean ev_postable = false;
/*      */     
/* 1167 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/* 1168 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/* 1169 */       getDAO_().setItemId(argItemId);
/* 1170 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1173 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemIdEntryMethodCode() {
/* 1181 */     return getDAO_().getItemIdEntryMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemIdEntryMethodCode(String argItemIdEntryMethodCode) {
/* 1189 */     if (setItemIdEntryMethodCode_noev(argItemIdEntryMethodCode) && 
/* 1190 */       this._events != null && 
/* 1191 */       postEventsForChanges()) {
/* 1192 */       this._events.post(ISaleReturnLineItem.SET_ITEMIDENTRYMETHODCODE, argItemIdEntryMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemIdEntryMethodCode_noev(String argItemIdEntryMethodCode) {
/* 1199 */     boolean ev_postable = false;
/*      */     
/* 1201 */     if ((getDAO_().getItemIdEntryMethodCode() == null && argItemIdEntryMethodCode != null) || (
/* 1202 */       getDAO_().getItemIdEntryMethodCode() != null && !getDAO_().getItemIdEntryMethodCode().equals(argItemIdEntryMethodCode))) {
/* 1203 */       getDAO_().setItemIdEntryMethodCode(argItemIdEntryMethodCode);
/* 1204 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1207 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getNetAmount() {
/* 1215 */     return getDAO_().getNetAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNetAmount(BigDecimal argNetAmount) {
/* 1223 */     if (setNetAmount_noev(argNetAmount) && 
/* 1224 */       this._events != null && 
/* 1225 */       postEventsForChanges()) {
/* 1226 */       this._events.post(ISaleReturnLineItem.SET_NETAMOUNT, argNetAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNetAmount_noev(BigDecimal argNetAmount) {
/* 1233 */     boolean ev_postable = false;
/*      */     
/* 1235 */     if ((getDAO_().getNetAmount() == null && argNetAmount != null) || (
/* 1236 */       getDAO_().getNetAmount() != null && !getDAO_().getNetAmount().equals(argNetAmount))) {
/* 1237 */       getDAO_().setNetAmount(argNetAmount);
/* 1238 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1241 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getRptBaseUnitPriceImpl() {
/* 1249 */     return getDAO_().getRptBaseUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setRptBaseUnitPriceImpl(BigDecimal argRptBaseUnitPrice) {
/* 1257 */     if (setRptBaseUnitPrice_noev(argRptBaseUnitPrice) && 
/* 1258 */       this._events != null && 
/* 1259 */       postEventsForChanges()) {
/* 1260 */       this._events.post(ISaleReturnLineItem.SET_RPTBASEUNITPRICE, argRptBaseUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRptBaseUnitPrice_noev(BigDecimal argRptBaseUnitPrice) {
/* 1267 */     boolean ev_postable = false;
/*      */     
/* 1269 */     if ((getDAO_().getRptBaseUnitPrice() == null && argRptBaseUnitPrice != null) || (
/* 1270 */       getDAO_().getRptBaseUnitPrice() != null && !getDAO_().getRptBaseUnitPrice().equals(argRptBaseUnitPrice))) {
/* 1271 */       getDAO_().setRptBaseUnitPrice(argRptBaseUnitPrice);
/* 1272 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1275 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getOriginalBusinessDate() {
/* 1283 */     return getDAO_().getOriginalBusinessDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalBusinessDate(Date argOriginalBusinessDate) {
/* 1291 */     if (setOriginalBusinessDate_noev(argOriginalBusinessDate));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalBusinessDate_noev(Date argOriginalBusinessDate) {
/* 1297 */     boolean ev_postable = false;
/*      */     
/* 1299 */     if ((getDAO_().getOriginalBusinessDate() == null && argOriginalBusinessDate != null) || (
/* 1300 */       getDAO_().getOriginalBusinessDate() != null && !getDAO_().getOriginalBusinessDate().equals(argOriginalBusinessDate))) {
/* 1301 */       getDAO_().setOriginalBusinessDate(argOriginalBusinessDate);
/* 1302 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1305 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getOriginalLineItemSequence() {
/* 1313 */     if (getDAO_().getOriginalLineItemSequence() != null) {
/* 1314 */       return getDAO_().getOriginalLineItemSequence().intValue();
/*      */     }
/*      */     
/* 1317 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalLineItemSequence(int argOriginalLineItemSequence) {
/* 1326 */     if (setOriginalLineItemSequence_noev(argOriginalLineItemSequence) && 
/* 1327 */       this._events != null && 
/* 1328 */       postEventsForChanges()) {
/* 1329 */       this._events.post(ISaleReturnLineItem.SET_ORIGINALLINEITEMSEQUENCE, Integer.valueOf(argOriginalLineItemSequence));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalLineItemSequence_noev(int argOriginalLineItemSequence) {
/* 1336 */     boolean ev_postable = false;
/*      */     
/* 1338 */     if ((getDAO_().getOriginalLineItemSequence() == null && Integer.valueOf(argOriginalLineItemSequence) != null) || (
/* 1339 */       getDAO_().getOriginalLineItemSequence() != null && !getDAO_().getOriginalLineItemSequence().equals(Integer.valueOf(argOriginalLineItemSequence)))) {
/* 1340 */       getDAO_().setOriginalLineItemSequence(Integer.valueOf(argOriginalLineItemSequence));
/* 1341 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1344 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalRetailLocationId() {
/* 1352 */     if (getDAO_().getOriginalRetailLocationId() != null) {
/* 1353 */       return getDAO_().getOriginalRetailLocationId().longValue();
/*      */     }
/*      */     
/* 1356 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalRetailLocationId(long argOriginalRetailLocationId) {
/* 1365 */     if (setOriginalRetailLocationId_noev(argOriginalRetailLocationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalRetailLocationId_noev(long argOriginalRetailLocationId) {
/* 1371 */     boolean ev_postable = false;
/*      */     
/* 1373 */     if ((getDAO_().getOriginalRetailLocationId() == null && Long.valueOf(argOriginalRetailLocationId) != null) || (
/* 1374 */       getDAO_().getOriginalRetailLocationId() != null && !getDAO_().getOriginalRetailLocationId().equals(Long.valueOf(argOriginalRetailLocationId)))) {
/* 1375 */       getDAO_().setOriginalRetailLocationId(Long.valueOf(argOriginalRetailLocationId));
/* 1376 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1379 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalTransactionSequence() {
/* 1387 */     if (getDAO_().getOriginalTransactionSequence() != null) {
/* 1388 */       return getDAO_().getOriginalTransactionSequence().longValue();
/*      */     }
/*      */     
/* 1391 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalTransactionSequence(long argOriginalTransactionSequence) {
/* 1400 */     if (setOriginalTransactionSequence_noev(argOriginalTransactionSequence));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalTransactionSequence_noev(long argOriginalTransactionSequence) {
/* 1406 */     boolean ev_postable = false;
/*      */     
/* 1408 */     if ((getDAO_().getOriginalTransactionSequence() == null && Long.valueOf(argOriginalTransactionSequence) != null) || (
/* 1409 */       getDAO_().getOriginalTransactionSequence() != null && !getDAO_().getOriginalTransactionSequence().equals(Long.valueOf(argOriginalTransactionSequence)))) {
/* 1410 */       getDAO_().setOriginalTransactionSequence(Long.valueOf(argOriginalTransactionSequence));
/* 1411 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1414 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOriginalWorkstationId() {
/* 1422 */     if (getDAO_().getOriginalWorkstationId() != null) {
/* 1423 */       return getDAO_().getOriginalWorkstationId().longValue();
/*      */     }
/*      */     
/* 1426 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOriginalWorkstationId(long argOriginalWorkstationId) {
/* 1435 */     if (setOriginalWorkstationId_noev(argOriginalWorkstationId));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOriginalWorkstationId_noev(long argOriginalWorkstationId) {
/* 1441 */     boolean ev_postable = false;
/*      */     
/* 1443 */     if ((getDAO_().getOriginalWorkstationId() == null && Long.valueOf(argOriginalWorkstationId) != null) || (
/* 1444 */       getDAO_().getOriginalWorkstationId() != null && !getDAO_().getOriginalWorkstationId().equals(Long.valueOf(argOriginalWorkstationId)))) {
/* 1445 */       getDAO_().setOriginalWorkstationId(Long.valueOf(argOriginalWorkstationId));
/* 1446 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1449 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPriceDerivationMethodCode() {
/* 1457 */     return getDAO_().getPriceDerivationMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriceDerivationMethodCode(String argPriceDerivationMethodCode) {
/* 1465 */     if (setPriceDerivationMethodCode_noev(argPriceDerivationMethodCode) && 
/* 1466 */       this._events != null && 
/* 1467 */       postEventsForChanges()) {
/* 1468 */       this._events.post(ISaleReturnLineItem.SET_PRICEDERIVATIONMETHODCODE, argPriceDerivationMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriceDerivationMethodCode_noev(String argPriceDerivationMethodCode) {
/* 1475 */     boolean ev_postable = false;
/*      */     
/* 1477 */     if ((getDAO_().getPriceDerivationMethodCode() == null && argPriceDerivationMethodCode != null) || (
/* 1478 */       getDAO_().getPriceDerivationMethodCode() != null && !getDAO_().getPriceDerivationMethodCode().equals(argPriceDerivationMethodCode))) {
/* 1479 */       getDAO_().setPriceDerivationMethodCode(argPriceDerivationMethodCode);
/* 1480 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1483 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPriceEntryMethodCode() {
/* 1491 */     return getDAO_().getPriceEntryMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPriceEntryMethodCode(String argPriceEntryMethodCode) {
/* 1499 */     if (setPriceEntryMethodCode_noev(argPriceEntryMethodCode) && 
/* 1500 */       this._events != null && 
/* 1501 */       postEventsForChanges()) {
/* 1502 */       this._events.post(ISaleReturnLineItem.SET_PRICEENTRYMETHODCODE, argPriceEntryMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPriceEntryMethodCode_noev(String argPriceEntryMethodCode) {
/* 1509 */     boolean ev_postable = false;
/*      */     
/* 1511 */     if ((getDAO_().getPriceEntryMethodCode() == null && argPriceEntryMethodCode != null) || (
/* 1512 */       getDAO_().getPriceEntryMethodCode() != null && !getDAO_().getPriceEntryMethodCode().equals(argPriceEntryMethodCode))) {
/* 1513 */       getDAO_().setPriceEntryMethodCode(argPriceEntryMethodCode);
/* 1514 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1517 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getQuantity() {
/* 1525 */     return getDAO_().getQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setQuantityImpl(BigDecimal argQuantity) {
/* 1533 */     if (setQuantity_noev(argQuantity) && 
/* 1534 */       this._events != null && 
/* 1535 */       postEventsForChanges()) {
/* 1536 */       this._events.post(ISaleReturnLineItem.SET_QUANTITY, argQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQuantity_noev(BigDecimal argQuantity) {
/* 1543 */     boolean ev_postable = false;
/*      */     
/* 1545 */     if ((getDAO_().getQuantity() == null && argQuantity != null) || (
/* 1546 */       getDAO_().getQuantity() != null && !getDAO_().getQuantity().equals(argQuantity))) {
/* 1547 */       getDAO_().setQuantity(argQuantity);
/* 1548 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1551 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReturnComment() {
/* 1559 */     return getDAO_().getReturnComment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReturnComment(String argReturnComment) {
/* 1567 */     if (setReturnComment_noev(argReturnComment) && 
/* 1568 */       this._events != null && 
/* 1569 */       postEventsForChanges()) {
/* 1570 */       this._events.post(ISaleReturnLineItem.SET_RETURNCOMMENT, argReturnComment);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReturnComment_noev(String argReturnComment) {
/* 1577 */     boolean ev_postable = false;
/*      */     
/* 1579 */     if ((getDAO_().getReturnComment() == null && argReturnComment != null) || (
/* 1580 */       getDAO_().getReturnComment() != null && !getDAO_().getReturnComment().equals(argReturnComment))) {
/* 1581 */       getDAO_().setReturnComment(argReturnComment);
/* 1582 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1585 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getReturn() {
/* 1593 */     if (getDAO_().getReturn() != null) {
/* 1594 */       return getDAO_().getReturn().booleanValue();
/*      */     }
/*      */     
/* 1597 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReturn(boolean argReturn) {
/* 1606 */     if (setReturn_noev(argReturn) && 
/* 1607 */       this._events != null && 
/* 1608 */       postEventsForChanges()) {
/* 1609 */       this._events.post(ISaleReturnLineItem.SET_RETURN, Boolean.valueOf(argReturn));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReturn_noev(boolean argReturn) {
/* 1616 */     boolean ev_postable = false;
/*      */     
/* 1618 */     if ((getDAO_().getReturn() == null && Boolean.valueOf(argReturn) != null) || (
/* 1619 */       getDAO_().getReturn() != null && !getDAO_().getReturn().equals(Boolean.valueOf(argReturn)))) {
/* 1620 */       getDAO_().setReturn(Boolean.valueOf(argReturn));
/* 1621 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1624 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReturnTypeCode() {
/* 1632 */     return getDAO_().getReturnTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReturnTypeCode(String argReturnTypeCode) {
/* 1640 */     if (setReturnTypeCode_noev(argReturnTypeCode) && 
/* 1641 */       this._events != null && 
/* 1642 */       postEventsForChanges()) {
/* 1643 */       this._events.post(ISaleReturnLineItem.SET_RETURNTYPECODE, argReturnTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReturnTypeCode_noev(String argReturnTypeCode) {
/* 1650 */     boolean ev_postable = false;
/*      */     
/* 1652 */     if ((getDAO_().getReturnTypeCode() == null && argReturnTypeCode != null) || (
/* 1653 */       getDAO_().getReturnTypeCode() != null && !getDAO_().getReturnTypeCode().equals(argReturnTypeCode))) {
/* 1654 */       getDAO_().setReturnTypeCode(argReturnTypeCode);
/* 1655 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1658 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSaleReturnLineItemTypeCode() {
/* 1666 */     return getDAO_().getSaleReturnLineItemTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSaleReturnLineItemTypeCode(String argSaleReturnLineItemTypeCode) {
/* 1674 */     if (setSaleReturnLineItemTypeCode_noev(argSaleReturnLineItemTypeCode) && 
/* 1675 */       this._events != null && 
/* 1676 */       postEventsForChanges()) {
/* 1677 */       this._events.post(ISaleReturnLineItem.SET_SALERETURNLINEITEMTYPECODE, argSaleReturnLineItemTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSaleReturnLineItemTypeCode_noev(String argSaleReturnLineItemTypeCode) {
/* 1684 */     boolean ev_postable = false;
/*      */     
/* 1686 */     if ((getDAO_().getSaleReturnLineItemTypeCode() == null && argSaleReturnLineItemTypeCode != null) || (
/* 1687 */       getDAO_().getSaleReturnLineItemTypeCode() != null && !getDAO_().getSaleReturnLineItemTypeCode().equals(argSaleReturnLineItemTypeCode))) {
/* 1688 */       getDAO_().setSaleReturnLineItemTypeCode(argSaleReturnLineItemTypeCode);
/* 1689 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1692 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getScannedItemId() {
/* 1700 */     return getDAO_().getScannedItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setScannedItemId(String argScannedItemId) {
/* 1708 */     if (setScannedItemId_noev(argScannedItemId) && 
/* 1709 */       this._events != null && 
/* 1710 */       postEventsForChanges()) {
/* 1711 */       this._events.post(ISaleReturnLineItem.SET_SCANNEDITEMID, argScannedItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setScannedItemId_noev(String argScannedItemId) {
/* 1718 */     boolean ev_postable = false;
/*      */     
/* 1720 */     if ((getDAO_().getScannedItemId() == null && argScannedItemId != null) || (
/* 1721 */       getDAO_().getScannedItemId() != null && !getDAO_().getScannedItemId().equals(argScannedItemId))) {
/* 1722 */       getDAO_().setScannedItemId(argScannedItemId);
/* 1723 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1726 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSerialNumber() {
/* 1734 */     return getDAO_().getSerialNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerialNumber(String argSerialNumber) {
/* 1742 */     if (setSerialNumber_noev(argSerialNumber) && 
/* 1743 */       this._events != null && 
/* 1744 */       postEventsForChanges()) {
/* 1745 */       this._events.post(ISaleReturnLineItem.SET_SERIALNUMBER, argSerialNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerialNumber_noev(String argSerialNumber) {
/* 1752 */     boolean ev_postable = false;
/*      */     
/* 1754 */     if ((getDAO_().getSerialNumber() == null && argSerialNumber != null) || (
/* 1755 */       getDAO_().getSerialNumber() != null && !getDAO_().getSerialNumber().equals(argSerialNumber))) {
/* 1756 */       getDAO_().setSerialNumber(argSerialNumber);
/* 1757 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1760 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getEnteredDescription() {
/* 1768 */     return getDAO_().getEnteredDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnteredDescription(String argEnteredDescription) {
/* 1776 */     if (setEnteredDescription_noev(argEnteredDescription) && 
/* 1777 */       this._events != null && 
/* 1778 */       postEventsForChanges()) {
/* 1779 */       this._events.post(ISaleReturnLineItem.SET_ENTEREDDESCRIPTION, argEnteredDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setEnteredDescription_noev(String argEnteredDescription) {
/* 1786 */     boolean ev_postable = false;
/*      */     
/* 1788 */     if ((getDAO_().getEnteredDescription() == null && argEnteredDescription != null) || (
/* 1789 */       getDAO_().getEnteredDescription() != null && !getDAO_().getEnteredDescription().equals(argEnteredDescription))) {
/* 1790 */       getDAO_().setEnteredDescription(argEnteredDescription);
/* 1791 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1794 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getUnitPriceImpl() {
/* 1802 */     return getDAO_().getUnitPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUnitPriceImpl(BigDecimal argUnitPrice) {
/* 1810 */     if (setUnitPrice_noev(argUnitPrice) && 
/* 1811 */       this._events != null && 
/* 1812 */       postEventsForChanges()) {
/* 1813 */       this._events.post(ISaleReturnLineItem.SET_UNITPRICE, argUnitPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitPrice_noev(BigDecimal argUnitPrice) {
/* 1820 */     boolean ev_postable = false;
/*      */     
/* 1822 */     if ((getDAO_().getUnitPrice() == null && argUnitPrice != null) || (
/* 1823 */       getDAO_().getUnitPrice() != null && !getDAO_().getUnitPrice().equals(argUnitPrice))) {
/* 1824 */       getDAO_().setUnitPrice(argUnitPrice);
/* 1825 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1828 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getVatAmount() {
/* 1836 */     return getDAO_().getVatAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVatAmount(BigDecimal argVatAmount) {
/* 1844 */     if (setVatAmount_noev(argVatAmount) && 
/* 1845 */       this._events != null && 
/* 1846 */       postEventsForChanges()) {
/* 1847 */       this._events.post(ISaleReturnLineItem.SET_VATAMOUNT, argVatAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVatAmount_noev(BigDecimal argVatAmount) {
/* 1854 */     boolean ev_postable = false;
/*      */     
/* 1856 */     if ((getDAO_().getVatAmount() == null && argVatAmount != null) || (
/* 1857 */       getDAO_().getVatAmount() != null && !getDAO_().getVatAmount().equals(argVatAmount))) {
/* 1858 */       getDAO_().setVatAmount(argVatAmount);
/* 1859 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1862 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceZeroExtendedAmt() {
/* 1870 */     if (getDAO_().getForceZeroExtendedAmt() != null) {
/* 1871 */       return getDAO_().getForceZeroExtendedAmt().booleanValue();
/*      */     }
/*      */     
/* 1874 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceZeroExtendedAmt(boolean argForceZeroExtendedAmt) {
/* 1883 */     if (setForceZeroExtendedAmt_noev(argForceZeroExtendedAmt) && 
/* 1884 */       this._events != null && 
/* 1885 */       postEventsForChanges()) {
/* 1886 */       this._events.post(ISaleReturnLineItem.SET_FORCEZEROEXTENDEDAMT, Boolean.valueOf(argForceZeroExtendedAmt));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setForceZeroExtendedAmt_noev(boolean argForceZeroExtendedAmt) {
/* 1893 */     boolean ev_postable = false;
/*      */     
/* 1895 */     if ((getDAO_().getForceZeroExtendedAmt() == null && Boolean.valueOf(argForceZeroExtendedAmt) != null) || (
/* 1896 */       getDAO_().getForceZeroExtendedAmt() != null && !getDAO_().getForceZeroExtendedAmt().equals(Boolean.valueOf(argForceZeroExtendedAmt)))) {
/* 1897 */       getDAO_().setForceZeroExtendedAmt(Boolean.valueOf(argForceZeroExtendedAmt));
/* 1898 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1901 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReturnReasonCode() {
/* 1909 */     return getDAO_().getReturnReasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReturnReasonCode(String argReturnReasonCode) {
/* 1917 */     if (setReturnReasonCode_noev(argReturnReasonCode) && 
/* 1918 */       this._events != null && 
/* 1919 */       postEventsForChanges()) {
/* 1920 */       this._events.post(ISaleReturnLineItem.SET_RETURNREASONCODE, argReturnReasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setReturnReasonCode_noev(String argReturnReasonCode) {
/* 1927 */     boolean ev_postable = false;
/*      */     
/* 1929 */     if ((getDAO_().getReturnReasonCode() == null && argReturnReasonCode != null) || (
/* 1930 */       getDAO_().getReturnReasonCode() != null && !getDAO_().getReturnReasonCode().equals(argReturnReasonCode))) {
/* 1931 */       getDAO_().setReturnReasonCode(argReturnReasonCode);
/* 1932 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1935 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxGroupId() {
/* 1943 */     return getDAO_().getTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/* 1951 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 1952 */       this._events != null && 
/* 1953 */       postEventsForChanges()) {
/* 1954 */       this._events.post(ISaleReturnLineItem.SET_TAXGROUPID, argTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 1961 */     boolean ev_postable = false;
/*      */     
/* 1963 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 1964 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 1965 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 1966 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1969 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getNetQuantity() {
/* 1977 */     return getDAO_().getNetQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNetQuantity(BigDecimal argNetQuantity) {
/* 1985 */     if (setNetQuantity_noev(argNetQuantity) && 
/* 1986 */       this._events != null && 
/* 1987 */       postEventsForChanges()) {
/* 1988 */       this._events.post(ISaleReturnLineItem.SET_NETQUANTITY, argNetQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNetQuantity_noev(BigDecimal argNetQuantity) {
/* 1995 */     boolean ev_postable = false;
/*      */     
/* 1997 */     if ((getDAO_().getNetQuantity() == null && argNetQuantity != null) || (
/* 1998 */       getDAO_().getNetQuantity() != null && !getDAO_().getNetQuantity().equals(argNetQuantity))) {
/* 1999 */       getDAO_().setNetQuantity(argNetQuantity);
/* 2000 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2003 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getGrossQuantity() {
/* 2011 */     return getDAO_().getGrossQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGrossQuantity(BigDecimal argGrossQuantity) {
/* 2019 */     if (setGrossQuantity_noev(argGrossQuantity) && 
/* 2020 */       this._events != null && 
/* 2021 */       postEventsForChanges()) {
/* 2022 */       this._events.post(ISaleReturnLineItem.SET_GROSSQUANTITY, argGrossQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGrossQuantity_noev(BigDecimal argGrossQuantity) {
/* 2029 */     boolean ev_postable = false;
/*      */     
/* 2031 */     if ((getDAO_().getGrossQuantity() == null && argGrossQuantity != null) || (
/* 2032 */       getDAO_().getGrossQuantity() != null && !getDAO_().getGrossQuantity().equals(argGrossQuantity))) {
/* 2033 */       getDAO_().setGrossQuantity(argGrossQuantity);
/* 2034 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2037 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getFoodStampsAppliedAmountImpl() {
/* 2045 */     return getDAO_().getFoodStampsAppliedAmount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFoodStampsAppliedAmountImpl(BigDecimal argFoodStampsAppliedAmount) {
/* 2053 */     if (setFoodStampsAppliedAmount_noev(argFoodStampsAppliedAmount) && 
/* 2054 */       this._events != null && 
/* 2055 */       postEventsForChanges()) {
/* 2056 */       this._events.post(ISaleReturnLineItem.SET_FOODSTAMPSAPPLIEDAMOUNT, argFoodStampsAppliedAmount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFoodStampsAppliedAmount_noev(BigDecimal argFoodStampsAppliedAmount) {
/* 2063 */     boolean ev_postable = false;
/*      */     
/* 2065 */     if ((getDAO_().getFoodStampsAppliedAmount() == null && argFoodStampsAppliedAmount != null) || (
/* 2066 */       getDAO_().getFoodStampsAppliedAmount() != null && !getDAO_().getFoodStampsAppliedAmount().equals(argFoodStampsAppliedAmount))) {
/* 2067 */       getDAO_().setFoodStampsAppliedAmount(argFoodStampsAppliedAmount);
/* 2068 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2071 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVendorId() {
/* 2079 */     return getDAO_().getVendorId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVendorId(String argVendorId) {
/* 2087 */     if (setVendorId_noev(argVendorId) && 
/* 2088 */       this._events != null && 
/* 2089 */       postEventsForChanges()) {
/* 2090 */       this._events.post(ISaleReturnLineItem.SET_VENDORID, argVendorId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVendorId_noev(String argVendorId) {
/* 2097 */     boolean ev_postable = false;
/*      */     
/* 2099 */     if ((getDAO_().getVendorId() == null && argVendorId != null) || (
/* 2100 */       getDAO_().getVendorId() != null && !getDAO_().getVendorId().equals(argVendorId))) {
/* 2101 */       getDAO_().setVendorId(argVendorId);
/* 2102 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2105 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BigDecimal getRegularBasePriceImpl() {
/* 2113 */     return getDAO_().getRegularBasePrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setRegularBasePriceImpl(BigDecimal argRegularBasePrice) {
/* 2121 */     if (setRegularBasePrice_noev(argRegularBasePrice) && 
/* 2122 */       this._events != null && 
/* 2123 */       postEventsForChanges()) {
/* 2124 */       this._events.post(ISaleReturnLineItem.SET_REGULARBASEPRICE, argRegularBasePrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRegularBasePrice_noev(BigDecimal argRegularBasePrice) {
/* 2131 */     boolean ev_postable = false;
/*      */     
/* 2133 */     if ((getDAO_().getRegularBasePrice() == null && argRegularBasePrice != null) || (
/* 2134 */       getDAO_().getRegularBasePrice() != null && !getDAO_().getRegularBasePrice().equals(argRegularBasePrice))) {
/* 2135 */       getDAO_().setRegularBasePrice(argRegularBasePrice);
/* 2136 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2139 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPricePropertyCode() {
/* 2147 */     return getDAO_().getPricePropertyCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPricePropertyCode(String argPricePropertyCode) {
/* 2155 */     if (setPricePropertyCode_noev(argPricePropertyCode) && 
/* 2156 */       this._events != null && 
/* 2157 */       postEventsForChanges()) {
/* 2158 */       this._events.post(ISaleReturnLineItem.SET_PRICEPROPERTYCODE, argPricePropertyCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPricePropertyCode_noev(String argPricePropertyCode) {
/* 2165 */     boolean ev_postable = false;
/*      */     
/* 2167 */     if ((getDAO_().getPricePropertyCode() == null && argPricePropertyCode != null) || (
/* 2168 */       getDAO_().getPricePropertyCode() != null && !getDAO_().getPricePropertyCode().equals(argPricePropertyCode))) {
/* 2169 */       getDAO_().setPricePropertyCode(argPricePropertyCode);
/* 2170 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2173 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getShippingWeight() {
/* 2181 */     return getDAO_().getShippingWeight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingWeight(BigDecimal argShippingWeight) {
/* 2189 */     if (setShippingWeight_noev(argShippingWeight) && 
/* 2190 */       this._events != null && 
/* 2191 */       postEventsForChanges()) {
/* 2192 */       this._events.post(ISaleReturnLineItem.SET_SHIPPINGWEIGHT, argShippingWeight);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingWeight_noev(BigDecimal argShippingWeight) {
/* 2199 */     boolean ev_postable = false;
/*      */     
/* 2201 */     if ((getDAO_().getShippingWeight() == null && argShippingWeight != null) || (
/* 2202 */       getDAO_().getShippingWeight() != null && !getDAO_().getShippingWeight().equals(argShippingWeight))) {
/* 2203 */       getDAO_().setShippingWeight(argShippingWeight);
/* 2204 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2207 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnitCost() {
/* 2215 */     return getDAO_().getUnitCost();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitCost(BigDecimal argUnitCost) {
/* 2223 */     if (setUnitCost_noev(argUnitCost) && 
/* 2224 */       this._events != null && 
/* 2225 */       postEventsForChanges()) {
/* 2226 */       this._events.post(ISaleReturnLineItem.SET_UNITCOST, argUnitCost);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitCost_noev(BigDecimal argUnitCost) {
/* 2233 */     boolean ev_postable = false;
/*      */     
/* 2235 */     if ((getDAO_().getUnitCost() == null && argUnitCost != null) || (
/* 2236 */       getDAO_().getUnitCost() != null && !getDAO_().getUnitCost().equals(argUnitCost))) {
/* 2237 */       getDAO_().setUnitCost(argUnitCost);
/* 2238 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2241 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAttachedItemFlag() {
/* 2249 */     if (getDAO_().getAttachedItemFlag() != null) {
/* 2250 */       return getDAO_().getAttachedItemFlag().booleanValue();
/*      */     }
/*      */     
/* 2253 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttachedItemFlag(boolean argAttachedItemFlag) {
/* 2262 */     if (setAttachedItemFlag_noev(argAttachedItemFlag) && 
/* 2263 */       this._events != null && 
/* 2264 */       postEventsForChanges()) {
/* 2265 */       this._events.post(ISaleReturnLineItem.SET_ATTACHEDITEMFLAG, Boolean.valueOf(argAttachedItemFlag));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAttachedItemFlag_noev(boolean argAttachedItemFlag) {
/* 2272 */     boolean ev_postable = false;
/*      */     
/* 2274 */     if ((getDAO_().getAttachedItemFlag() == null && Boolean.valueOf(argAttachedItemFlag) != null) || (
/* 2275 */       getDAO_().getAttachedItemFlag() != null && !getDAO_().getAttachedItemFlag().equals(Boolean.valueOf(argAttachedItemFlag)))) {
/* 2276 */       getDAO_().setAttachedItemFlag(Boolean.valueOf(argAttachedItemFlag));
/* 2277 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2280 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getInitialQuantity() {
/* 2288 */     return getDAO_().getInitialQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInitialQuantity(BigDecimal argInitialQuantity) {
/* 2296 */     if (setInitialQuantity_noev(argInitialQuantity) && 
/* 2297 */       this._events != null && 
/* 2298 */       postEventsForChanges()) {
/* 2299 */       this._events.post(ISaleReturnLineItem.SET_INITIALQUANTITY, argInitialQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInitialQuantity_noev(BigDecimal argInitialQuantity) {
/* 2306 */     boolean ev_postable = false;
/*      */     
/* 2308 */     if ((getDAO_().getInitialQuantity() == null && argInitialQuantity != null) || (
/* 2309 */       getDAO_().getInitialQuantity() != null && !getDAO_().getInitialQuantity().equals(argInitialQuantity))) {
/* 2310 */       getDAO_().setInitialQuantity(argInitialQuantity);
/* 2311 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2314 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getNotReturnable() {
/* 2322 */     if (getDAO_().getNotReturnable() != null) {
/* 2323 */       return getDAO_().getNotReturnable().booleanValue();
/*      */     }
/*      */     
/* 2326 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotReturnable(boolean argNotReturnable) {
/* 2335 */     if (setNotReturnable_noev(argNotReturnable) && 
/* 2336 */       this._events != null && 
/* 2337 */       postEventsForChanges()) {
/* 2338 */       this._events.post(ISaleReturnLineItem.SET_NOTRETURNABLE, Boolean.valueOf(argNotReturnable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotReturnable_noev(boolean argNotReturnable) {
/* 2345 */     boolean ev_postable = false;
/*      */     
/* 2347 */     if ((getDAO_().getNotReturnable() == null && Boolean.valueOf(argNotReturnable) != null) || (
/* 2348 */       getDAO_().getNotReturnable() != null && !getDAO_().getNotReturnable().equals(Boolean.valueOf(argNotReturnable)))) {
/* 2349 */       getDAO_().setNotReturnable(Boolean.valueOf(argNotReturnable));
/* 2350 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2353 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getExcludeFromNetSales() {
/* 2361 */     if (getDAO_().getExcludeFromNetSales() != null) {
/* 2362 */       return getDAO_().getExcludeFromNetSales().booleanValue();
/*      */     }
/*      */     
/* 2365 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExcludeFromNetSales(boolean argExcludeFromNetSales) {
/* 2374 */     if (setExcludeFromNetSales_noev(argExcludeFromNetSales) && 
/* 2375 */       this._events != null && 
/* 2376 */       postEventsForChanges()) {
/* 2377 */       this._events.post(ISaleReturnLineItem.SET_EXCLUDEFROMNETSALES, Boolean.valueOf(argExcludeFromNetSales));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExcludeFromNetSales_noev(boolean argExcludeFromNetSales) {
/* 2384 */     boolean ev_postable = false;
/*      */     
/* 2386 */     if ((getDAO_().getExcludeFromNetSales() == null && Boolean.valueOf(argExcludeFromNetSales) != null) || (
/* 2387 */       getDAO_().getExcludeFromNetSales() != null && !getDAO_().getExcludeFromNetSales().equals(Boolean.valueOf(argExcludeFromNetSales)))) {
/* 2388 */       getDAO_().setExcludeFromNetSales(Boolean.valueOf(argExcludeFromNetSales));
/* 2389 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2392 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getMeasurementRequired() {
/* 2400 */     if (getDAO_().getMeasurementRequired() != null) {
/* 2401 */       return getDAO_().getMeasurementRequired().booleanValue();
/*      */     }
/*      */     
/* 2404 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMeasurementRequired(boolean argMeasurementRequired) {
/* 2413 */     if (setMeasurementRequired_noev(argMeasurementRequired) && 
/* 2414 */       this._events != null && 
/* 2415 */       postEventsForChanges()) {
/* 2416 */       this._events.post(ISaleReturnLineItem.SET_MEASUREMENTREQUIRED, Boolean.valueOf(argMeasurementRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMeasurementRequired_noev(boolean argMeasurementRequired) {
/* 2423 */     boolean ev_postable = false;
/*      */     
/* 2425 */     if ((getDAO_().getMeasurementRequired() == null && Boolean.valueOf(argMeasurementRequired) != null) || (
/* 2426 */       getDAO_().getMeasurementRequired() != null && !getDAO_().getMeasurementRequired().equals(Boolean.valueOf(argMeasurementRequired)))) {
/* 2427 */       getDAO_().setMeasurementRequired(Boolean.valueOf(argMeasurementRequired));
/* 2428 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2431 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getWeightEntryMethodCode() {
/* 2439 */     return getDAO_().getWeightEntryMethodCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWeightEntryMethodCode(String argWeightEntryMethodCode) {
/* 2447 */     if (setWeightEntryMethodCode_noev(argWeightEntryMethodCode) && 
/* 2448 */       this._events != null && 
/* 2449 */       postEventsForChanges()) {
/* 2450 */       this._events.post(ISaleReturnLineItem.SET_WEIGHTENTRYMETHODCODE, argWeightEntryMethodCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWeightEntryMethodCode_noev(String argWeightEntryMethodCode) {
/* 2457 */     boolean ev_postable = false;
/*      */     
/* 2459 */     if ((getDAO_().getWeightEntryMethodCode() == null && argWeightEntryMethodCode != null) || (
/* 2460 */       getDAO_().getWeightEntryMethodCode() != null && !getDAO_().getWeightEntryMethodCode().equals(argWeightEntryMethodCode))) {
/* 2461 */       getDAO_().setWeightEntryMethodCode(argWeightEntryMethodCode);
/* 2462 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2465 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTareValue() {
/* 2473 */     return getDAO_().getTareValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTareValue(BigDecimal argTareValue) {
/* 2481 */     if (setTareValue_noev(argTareValue) && 
/* 2482 */       this._events != null && 
/* 2483 */       postEventsForChanges()) {
/* 2484 */       this._events.post(ISaleReturnLineItem.SET_TAREVALUE, argTareValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTareValue_noev(BigDecimal argTareValue) {
/* 2491 */     boolean ev_postable = false;
/*      */     
/* 2493 */     if ((getDAO_().getTareValue() == null && argTareValue != null) || (
/* 2494 */       getDAO_().getTareValue() != null && !getDAO_().getTareValue().equals(argTareValue))) {
/* 2495 */       getDAO_().setTareValue(argTareValue);
/* 2496 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2499 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTareType() {
/* 2507 */     return getDAO_().getTareType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTareType(String argTareType) {
/* 2515 */     if (setTareType_noev(argTareType) && 
/* 2516 */       this._events != null && 
/* 2517 */       postEventsForChanges()) {
/* 2518 */       this._events.post(ISaleReturnLineItem.SET_TARETYPE, argTareType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTareType_noev(String argTareType) {
/* 2525 */     boolean ev_postable = false;
/*      */     
/* 2527 */     if ((getDAO_().getTareType() == null && argTareType != null) || (
/* 2528 */       getDAO_().getTareType() != null && !getDAO_().getTareType().equals(argTareType))) {
/* 2529 */       getDAO_().setTareType(argTareType);
/* 2530 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2533 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTareUnitOfMeasureCode() {
/* 2541 */     return getDAO_().getTareUnitOfMeasureCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTareUnitOfMeasureCode(String argTareUnitOfMeasureCode) {
/* 2549 */     if (setTareUnitOfMeasureCode_noev(argTareUnitOfMeasureCode) && 
/* 2550 */       this._events != null && 
/* 2551 */       postEventsForChanges()) {
/* 2552 */       this._events.post(ISaleReturnLineItem.SET_TAREUNITOFMEASURECODE, argTareUnitOfMeasureCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTareUnitOfMeasureCode_noev(String argTareUnitOfMeasureCode) {
/* 2559 */     boolean ev_postable = false;
/*      */     
/* 2561 */     if ((getDAO_().getTareUnitOfMeasureCode() == null && argTareUnitOfMeasureCode != null) || (
/* 2562 */       getDAO_().getTareUnitOfMeasureCode() != null && !getDAO_().getTareUnitOfMeasureCode().equals(argTareUnitOfMeasureCode))) {
/* 2563 */       getDAO_().setTareUnitOfMeasureCode(argTareUnitOfMeasureCode);
/* 2564 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2567 */     return ev_postable;
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
/*      */   @Relationship(name = "BaseReturnedQuantity")
/*      */   public IReturnedItemCount getBaseReturnedQuantity() {
/* 2615 */     return this._baseReturnedQuantity;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBaseReturnedQuantity(IReturnedItemCount argBaseReturnedQuantity) {
/* 2620 */     if (argBaseReturnedQuantity == null) {
/*      */       
/* 2622 */       if (this._baseReturnedQuantity != null) {
/* 2623 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 2625 */       if (this._baseReturnedQuantity != null) {
/*      */         
/* 2627 */         if (postEventsForChanges()) {
/* 2628 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._baseReturnedQuantity));
/*      */         }
/* 2630 */         addDeletedObject((IDataModel)this._baseReturnedQuantity);
/*      */       } 
/*      */     } else {
/*      */       
/* 2634 */       argBaseReturnedQuantity.setOrganizationId(getOrganizationId());
/* 2635 */       argBaseReturnedQuantity.setRetailLocationId(getRetailLocationId());
/* 2636 */       argBaseReturnedQuantity.setWorkstationId(getWorkstationId());
/* 2637 */       argBaseReturnedQuantity.setBusinessDate(getBusinessDate());
/* 2638 */       argBaseReturnedQuantity.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 2639 */       argBaseReturnedQuantity.setTransactionSequence(getTransactionSequence());
/*      */ 
/*      */       
/* 2642 */       if (postEventsForChanges()) {
/* 2643 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argBaseReturnedQuantity));
/*      */       }
/*      */     } 
/*      */     
/* 2647 */     this._baseReturnedQuantity = argBaseReturnedQuantity;
/* 2648 */     if (postEventsForChanges()) {
/* 2649 */       this._events.post(ISaleReturnLineItem.SET_BASERETURNEDQUANTITY, argBaseReturnedQuantity);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "CommissionModifiers")
/*      */   public List<ICommissionModifier> getCommissionModifiers() {
/* 2655 */     if (this._commissionModifiers == null) {
/* 2656 */       this._commissionModifiers = new HistoricalList(null);
/*      */     }
/* 2658 */     return (List<ICommissionModifier>)this._commissionModifiers;
/*      */   }
/*      */   
/*      */   public void setCommissionModifiers(List<ICommissionModifier> argCommissionModifiers) {
/* 2662 */     if (this._commissionModifiers == null) {
/* 2663 */       this._commissionModifiers = new HistoricalList(argCommissionModifiers);
/*      */     } else {
/* 2665 */       this._commissionModifiers.setCurrentList(argCommissionModifiers);
/*      */     } 
/*      */     
/* 2668 */     for (ICommissionModifier child : this._commissionModifiers) {
/* 2669 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 2672 */     for (ICommissionModifier child : this._commissionModifiers) {
/* 2673 */       CommissionModifierModel model = (CommissionModifierModel)child;
/* 2674 */       model.setOrganizationId_noev(getOrganizationId());
/* 2675 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 2676 */       model.setBusinessDate_noev(getBusinessDate());
/* 2677 */       model.setWorkstationId_noev(getWorkstationId());
/* 2678 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 2679 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 2680 */       if (child instanceof IDataModelImpl) {
/* 2681 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 2682 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2683 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2684 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 2687 */       if (postEventsForChanges()) {
/* 2688 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addCommissionModifierImpl(ICommissionModifier argCommissionModifier) {
/* 2695 */     argCommissionModifier.setParentLine(this);
/* 2696 */     if (this._commissionModifiers == null) {
/* 2697 */       this._commissionModifiers = new HistoricalList(null);
/*      */     }
/* 2699 */     argCommissionModifier.setOrganizationId(getOrganizationId());
/* 2700 */     argCommissionModifier.setRetailLocationId(getRetailLocationId());
/* 2701 */     argCommissionModifier.setBusinessDate(getBusinessDate());
/* 2702 */     argCommissionModifier.setWorkstationId(getWorkstationId());
/* 2703 */     argCommissionModifier.setTransactionSequence(getTransactionSequence());
/* 2704 */     argCommissionModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 2705 */     if (argCommissionModifier instanceof IDataModelImpl) {
/* 2706 */       IDataAccessObject childDao = ((IDataModelImpl)argCommissionModifier).getDAO();
/* 2707 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2708 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2709 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2714 */     if (postEventsForChanges()) {
/* 2715 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCommissionModifier));
/*      */     }
/*      */     
/* 2718 */     this._commissionModifiers.add(argCommissionModifier);
/* 2719 */     if (postEventsForChanges()) {
/* 2720 */       this._events.post(ISaleReturnLineItem.ADD_COMMISSIONMODIFIERS, argCommissionModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeCommissionModifier(ICommissionModifier argCommissionModifier) {
/* 2725 */     if (this._commissionModifiers != null) {
/*      */       
/* 2727 */       if (postEventsForChanges()) {
/* 2728 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCommissionModifier));
/*      */       }
/* 2730 */       this._commissionModifiers.remove(argCommissionModifier);
/*      */       
/* 2732 */       argCommissionModifier.setParentLine(null);
/* 2733 */       if (postEventsForChanges()) {
/* 2734 */         this._events.post(ISaleReturnLineItem.REMOVE_COMMISSIONMODIFIERS, argCommissionModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "DimensionModifiers")
/*      */   public List<IDimensionModifier> getDimensionModifiers() {
/* 2741 */     if (this._dimensionModifiers == null) {
/* 2742 */       this._dimensionModifiers = new HistoricalList(null);
/*      */     }
/* 2744 */     return (List<IDimensionModifier>)this._dimensionModifiers;
/*      */   }
/*      */   
/*      */   public void setDimensionModifiers(List<IDimensionModifier> argDimensionModifiers) {
/* 2748 */     if (this._dimensionModifiers == null) {
/* 2749 */       this._dimensionModifiers = new HistoricalList(argDimensionModifiers);
/*      */     } else {
/* 2751 */       this._dimensionModifiers.setCurrentList(argDimensionModifiers);
/*      */     } 
/*      */     
/* 2754 */     for (IDimensionModifier child : this._dimensionModifiers) {
/* 2755 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 2758 */     for (IDimensionModifier child : this._dimensionModifiers) {
/* 2759 */       DimensionModifierModel model = (DimensionModifierModel)child;
/* 2760 */       model.setOrganizationId_noev(getOrganizationId());
/* 2761 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 2762 */       model.setBusinessDate_noev(getBusinessDate());
/* 2763 */       model.setWorkstationId_noev(getWorkstationId());
/* 2764 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 2765 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 2766 */       if (child instanceof IDataModelImpl) {
/* 2767 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 2768 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2769 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2770 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 2773 */       if (postEventsForChanges()) {
/* 2774 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addDimensionModifierImpl(IDimensionModifier argDimensionModifier) {
/* 2781 */     argDimensionModifier.setParentLine(this);
/* 2782 */     if (this._dimensionModifiers == null) {
/* 2783 */       this._dimensionModifiers = new HistoricalList(null);
/*      */     }
/* 2785 */     argDimensionModifier.setOrganizationId(getOrganizationId());
/* 2786 */     argDimensionModifier.setRetailLocationId(getRetailLocationId());
/* 2787 */     argDimensionModifier.setBusinessDate(getBusinessDate());
/* 2788 */     argDimensionModifier.setWorkstationId(getWorkstationId());
/* 2789 */     argDimensionModifier.setTransactionSequence(getTransactionSequence());
/* 2790 */     argDimensionModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 2791 */     if (argDimensionModifier instanceof IDataModelImpl) {
/* 2792 */       IDataAccessObject childDao = ((IDataModelImpl)argDimensionModifier).getDAO();
/* 2793 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2794 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2795 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2800 */     if (postEventsForChanges()) {
/* 2801 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDimensionModifier));
/*      */     }
/*      */     
/* 2804 */     this._dimensionModifiers.add(argDimensionModifier);
/* 2805 */     if (postEventsForChanges()) {
/* 2806 */       this._events.post(ISaleReturnLineItem.ADD_DIMENSIONMODIFIERS, argDimensionModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeDimensionModifier(IDimensionModifier argDimensionModifier) {
/* 2811 */     if (this._dimensionModifiers != null) {
/*      */       
/* 2813 */       if (postEventsForChanges()) {
/* 2814 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argDimensionModifier));
/*      */       }
/* 2816 */       this._dimensionModifiers.remove(argDimensionModifier);
/*      */       
/* 2818 */       argDimensionModifier.setParentLine(null);
/* 2819 */       if (postEventsForChanges()) {
/* 2820 */         this._events.post(ISaleReturnLineItem.REMOVE_DIMENSIONMODIFIERS, argDimensionModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "InventoryDocumentLineItems")
/*      */   public List<IInventoryDocumentLineItem> getInventoryDocumentLineItems() {
/* 2827 */     if (this._inventoryDocumentLineItems == null) {
/* 2828 */       this._inventoryDocumentLineItems = new HistoricalList(null);
/*      */     }
/* 2830 */     return (List<IInventoryDocumentLineItem>)this._inventoryDocumentLineItems;
/*      */   }
/*      */   
/*      */   public void setInventoryDocumentLineItems(List<IInventoryDocumentLineItem> argInventoryDocumentLineItems) {
/* 2834 */     if (this._inventoryDocumentLineItems == null) {
/* 2835 */       this._inventoryDocumentLineItems = new HistoricalList(argInventoryDocumentLineItems);
/*      */     } else {
/* 2837 */       this._inventoryDocumentLineItems.setCurrentList(argInventoryDocumentLineItems);
/*      */     } 
/*      */     
/* 2840 */     for (IInventoryDocumentLineItem child : this._inventoryDocumentLineItems) {
/* 2841 */       InventoryDocumentLineItemModel model = (InventoryDocumentLineItemModel)child;
/* 2842 */       model.setOrganizationId_noev(getOrganizationId());
/* 2843 */       model.setLineItemRetailLocationId_noev(getRetailLocationId());
/* 2844 */       model.setLineItemBusinessDate_noev(getBusinessDate());
/* 2845 */       model.setLineItemWorkstationId_noev(getWorkstationId());
/* 2846 */       model.setLineItemTransactionSequence_noev(getTransactionSequence());
/* 2847 */       model.setLineItemRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 2848 */       if (child instanceof IDataModelImpl) {
/* 2849 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 2850 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2851 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2852 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 2855 */       if (postEventsForChanges()) {
/* 2856 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addInventoryDocumentLineItem(IInventoryDocumentLineItem argInventoryDocumentLineItem) {
/* 2862 */     if (this._inventoryDocumentLineItems == null) {
/* 2863 */       this._inventoryDocumentLineItems = new HistoricalList(null);
/*      */     }
/* 2865 */     argInventoryDocumentLineItem.setOrganizationId(getOrganizationId());
/* 2866 */     argInventoryDocumentLineItem.setLineItemRetailLocationId(getRetailLocationId());
/* 2867 */     argInventoryDocumentLineItem.setLineItemBusinessDate(getBusinessDate());
/* 2868 */     argInventoryDocumentLineItem.setLineItemWorkstationId(getWorkstationId());
/* 2869 */     argInventoryDocumentLineItem.setLineItemTransactionSequence(getTransactionSequence());
/* 2870 */     argInventoryDocumentLineItem.setLineItemRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 2871 */     if (argInventoryDocumentLineItem instanceof IDataModelImpl) {
/* 2872 */       IDataAccessObject childDao = ((IDataModelImpl)argInventoryDocumentLineItem).getDAO();
/* 2873 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2874 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2875 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2880 */     if (postEventsForChanges()) {
/* 2881 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItem));
/*      */     }
/*      */     
/* 2884 */     this._inventoryDocumentLineItems.add(argInventoryDocumentLineItem);
/* 2885 */     if (postEventsForChanges()) {
/* 2886 */       this._events.post(ISaleReturnLineItem.ADD_INVENTORYDOCUMENTLINEITEMS, argInventoryDocumentLineItem);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeInventoryDocumentLineItem(IInventoryDocumentLineItem argInventoryDocumentLineItem) {
/* 2891 */     if (this._inventoryDocumentLineItems != null) {
/*      */       
/* 2893 */       if (postEventsForChanges()) {
/* 2894 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argInventoryDocumentLineItem));
/*      */       }
/* 2896 */       this._inventoryDocumentLineItems.remove(argInventoryDocumentLineItem);
/* 2897 */       if (postEventsForChanges()) {
/* 2898 */         this._events.post(ISaleReturnLineItem.REMOVE_INVENTORYDOCUMENTLINEITEMS, argInventoryDocumentLineItem);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "LineItemAssociationModifiers")
/*      */   public List<ILineItemAssociationModifier> getLineItemAssociationModifiers() {
/* 2905 */     if (this._lineItemAssociationModifiers == null) {
/* 2906 */       this._lineItemAssociationModifiers = new HistoricalList(null);
/*      */     }
/* 2908 */     return (List<ILineItemAssociationModifier>)this._lineItemAssociationModifiers;
/*      */   }
/*      */   
/*      */   public void setLineItemAssociationModifiers(List<ILineItemAssociationModifier> argLineItemAssociationModifiers) {
/* 2912 */     if (this._lineItemAssociationModifiers == null) {
/* 2913 */       this._lineItemAssociationModifiers = new HistoricalList(argLineItemAssociationModifiers);
/*      */     } else {
/* 2915 */       this._lineItemAssociationModifiers.setCurrentList(argLineItemAssociationModifiers);
/*      */     } 
/*      */     
/* 2918 */     for (ILineItemAssociationModifier child : this._lineItemAssociationModifiers) {
/* 2919 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 2922 */     for (ILineItemAssociationModifier child : this._lineItemAssociationModifiers) {
/* 2923 */       LineItemAssociationModifierModel model = (LineItemAssociationModifierModel)child;
/* 2924 */       model.setOrganizationId_noev(getOrganizationId());
/* 2925 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 2926 */       model.setBusinessDate_noev(getBusinessDate());
/* 2927 */       model.setWorkstationId_noev(getWorkstationId());
/* 2928 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 2929 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 2930 */       if (child instanceof IDataModelImpl) {
/* 2931 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 2932 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2933 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2934 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 2937 */       if (postEventsForChanges()) {
/* 2938 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addLineItemAssociationModifierImpl(ILineItemAssociationModifier argLineItemAssociationModifier) {
/* 2945 */     argLineItemAssociationModifier.setParentLine(this);
/* 2946 */     if (this._lineItemAssociationModifiers == null) {
/* 2947 */       this._lineItemAssociationModifiers = new HistoricalList(null);
/*      */     }
/* 2949 */     argLineItemAssociationModifier.setOrganizationId(getOrganizationId());
/* 2950 */     argLineItemAssociationModifier.setRetailLocationId(getRetailLocationId());
/* 2951 */     argLineItemAssociationModifier.setBusinessDate(getBusinessDate());
/* 2952 */     argLineItemAssociationModifier.setWorkstationId(getWorkstationId());
/* 2953 */     argLineItemAssociationModifier.setTransactionSequence(getTransactionSequence());
/* 2954 */     argLineItemAssociationModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 2955 */     if (argLineItemAssociationModifier instanceof IDataModelImpl) {
/* 2956 */       IDataAccessObject childDao = ((IDataModelImpl)argLineItemAssociationModifier).getDAO();
/* 2957 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2958 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2959 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2964 */     if (postEventsForChanges()) {
/* 2965 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationModifier));
/*      */     }
/*      */     
/* 2968 */     this._lineItemAssociationModifiers.add(argLineItemAssociationModifier);
/* 2969 */     if (postEventsForChanges()) {
/* 2970 */       this._events.post(ISaleReturnLineItem.ADD_LINEITEMASSOCIATIONMODIFIERS, argLineItemAssociationModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeLineItemAssociationModifier(ILineItemAssociationModifier argLineItemAssociationModifier) {
/* 2975 */     if (this._lineItemAssociationModifiers != null) {
/*      */       
/* 2977 */       if (postEventsForChanges()) {
/* 2978 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argLineItemAssociationModifier));
/*      */       }
/* 2980 */       this._lineItemAssociationModifiers.remove(argLineItemAssociationModifier);
/*      */       
/* 2982 */       argLineItemAssociationModifier.setParentLine(null);
/* 2983 */       if (postEventsForChanges()) {
/* 2984 */         this._events.post(ISaleReturnLineItem.REMOVE_LINEITEMASSOCIATIONMODIFIERS, argLineItemAssociationModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "RetailPriceModifiers")
/*      */   public List<IRetailPriceModifier> getRetailPriceModifiers() {
/* 2991 */     if (this._retailPriceModifiers == null) {
/* 2992 */       this._retailPriceModifiers = new HistoricalList(null);
/*      */     }
/* 2994 */     return (List<IRetailPriceModifier>)this._retailPriceModifiers;
/*      */   }
/*      */   
/*      */   protected void setRetailPriceModifiersImpl(List<IRetailPriceModifier> argRetailPriceModifiers) {
/* 2998 */     if (this._retailPriceModifiers == null) {
/* 2999 */       this._retailPriceModifiers = new HistoricalList(argRetailPriceModifiers);
/*      */     } else {
/* 3001 */       this._retailPriceModifiers.setCurrentList(argRetailPriceModifiers);
/*      */     } 
/*      */     
/* 3004 */     for (IRetailPriceModifier child : this._retailPriceModifiers) {
/* 3005 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 3008 */     for (IRetailPriceModifier child : this._retailPriceModifiers) {
/* 3009 */       RetailPriceModifierModel model = (RetailPriceModifierModel)child;
/* 3010 */       model.setOrganizationId_noev(getOrganizationId());
/* 3011 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 3012 */       model.setBusinessDate_noev(getBusinessDate());
/* 3013 */       model.setWorkstationId_noev(getWorkstationId());
/* 3014 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 3015 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 3016 */       if (child instanceof IDataModelImpl) {
/* 3017 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 3018 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3019 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3020 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 3023 */       if (postEventsForChanges()) {
/* 3024 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addRetailPriceModifierImpl(IRetailPriceModifier argRetailPriceModifier) {
/* 3031 */     argRetailPriceModifier.setParentLine(this);
/* 3032 */     if (this._retailPriceModifiers == null) {
/* 3033 */       this._retailPriceModifiers = new HistoricalList(null);
/*      */     }
/* 3035 */     argRetailPriceModifier.setOrganizationId(getOrganizationId());
/* 3036 */     argRetailPriceModifier.setRetailLocationId(getRetailLocationId());
/* 3037 */     argRetailPriceModifier.setBusinessDate(getBusinessDate());
/* 3038 */     argRetailPriceModifier.setWorkstationId(getWorkstationId());
/* 3039 */     argRetailPriceModifier.setTransactionSequence(getTransactionSequence());
/* 3040 */     argRetailPriceModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 3041 */     if (argRetailPriceModifier instanceof IDataModelImpl) {
/* 3042 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailPriceModifier).getDAO();
/* 3043 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3044 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3045 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3050 */     if (postEventsForChanges()) {
/* 3051 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailPriceModifier));
/*      */     }
/*      */     
/* 3054 */     this._retailPriceModifiers.add(argRetailPriceModifier);
/* 3055 */     if (postEventsForChanges()) {
/* 3056 */       this._events.post(ISaleReturnLineItem.ADD_RETAILPRICEMODIFIERS, argRetailPriceModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailPriceModifier(IRetailPriceModifier argRetailPriceModifier) {
/* 3061 */     if (this._retailPriceModifiers != null) {
/*      */       
/* 3063 */       if (postEventsForChanges()) {
/* 3064 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailPriceModifier));
/*      */       }
/* 3066 */       this._retailPriceModifiers.remove(argRetailPriceModifier);
/*      */       
/* 3068 */       argRetailPriceModifier.setParentLine(null);
/* 3069 */       if (postEventsForChanges()) {
/* 3070 */         this._events.post(ISaleReturnLineItem.REMOVE_RETAILPRICEMODIFIERS, argRetailPriceModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "TaxGroup")
/*      */   public ITaxGroup getTaxGroup() {
/* 3077 */     return this._taxGroup;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTaxGroup(ITaxGroup argTaxGroup) {
/* 3082 */     if (argTaxGroup == null) {
/*      */       
/* 3084 */       getDAO_().setTaxGroupId((String)null);
/* 3085 */       if (this._taxGroup != null)
/*      */       {
/* 3087 */         if (postEventsForChanges()) {
/* 3088 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._taxGroup));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 3093 */       getDAO_().setTaxGroupId(argTaxGroup.getTaxGroupId());
/*      */       
/* 3095 */       if (postEventsForChanges()) {
/* 3096 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argTaxGroup));
/*      */       }
/*      */     } 
/*      */     
/* 3100 */     this._taxGroup = argTaxGroup;
/* 3101 */     if (postEventsForChanges()) {
/* 3102 */       this._events.post(ISaleReturnLineItem.SET_TAXGROUP, argTaxGroup);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "TaxModifiers")
/*      */   public List<ISaleTaxModifier> getTaxModifiers() {
/* 3108 */     if (this._taxModifiers == null) {
/* 3109 */       this._taxModifiers = new HistoricalList(null);
/*      */     }
/* 3111 */     return (List<ISaleTaxModifier>)this._taxModifiers;
/*      */   }
/*      */   
/*      */   public void setTaxModifiers(List<ISaleTaxModifier> argTaxModifiers) {
/* 3115 */     if (this._taxModifiers == null) {
/* 3116 */       this._taxModifiers = new HistoricalList(argTaxModifiers);
/*      */     } else {
/* 3118 */       this._taxModifiers.setCurrentList(argTaxModifiers);
/*      */     } 
/*      */     
/* 3121 */     for (ISaleTaxModifier child : this._taxModifiers) {
/* 3122 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 3125 */     for (ISaleTaxModifier child : this._taxModifiers) {
/* 3126 */       SaleTaxModifierModel model = (SaleTaxModifierModel)child;
/* 3127 */       model.setOrganizationId_noev(getOrganizationId());
/* 3128 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 3129 */       model.setBusinessDate_noev(getBusinessDate());
/* 3130 */       model.setWorkstationId_noev(getWorkstationId());
/* 3131 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 3132 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 3133 */       if (child instanceof IDataModelImpl) {
/* 3134 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 3135 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3136 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3137 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 3140 */       if (postEventsForChanges()) {
/* 3141 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addSaleTaxModifierImpl(ISaleTaxModifier argSaleTaxModifier) {
/* 3148 */     argSaleTaxModifier.setParentLine(this);
/* 3149 */     if (this._taxModifiers == null) {
/* 3150 */       this._taxModifiers = new HistoricalList(null);
/*      */     }
/* 3152 */     argSaleTaxModifier.setOrganizationId(getOrganizationId());
/* 3153 */     argSaleTaxModifier.setRetailLocationId(getRetailLocationId());
/* 3154 */     argSaleTaxModifier.setBusinessDate(getBusinessDate());
/* 3155 */     argSaleTaxModifier.setWorkstationId(getWorkstationId());
/* 3156 */     argSaleTaxModifier.setTransactionSequence(getTransactionSequence());
/* 3157 */     argSaleTaxModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 3158 */     if (argSaleTaxModifier instanceof IDataModelImpl) {
/* 3159 */       IDataAccessObject childDao = ((IDataModelImpl)argSaleTaxModifier).getDAO();
/* 3160 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3161 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3162 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3167 */     if (postEventsForChanges()) {
/* 3168 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleTaxModifier));
/*      */     }
/*      */     
/* 3171 */     this._taxModifiers.add(argSaleTaxModifier);
/* 3172 */     if (postEventsForChanges()) {
/* 3173 */       this._events.post(ISaleReturnLineItem.ADD_TAXMODIFIERS, argSaleTaxModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeSaleTaxModifier(ISaleTaxModifier argSaleTaxModifier) {
/* 3178 */     if (this._taxModifiers != null) {
/*      */       
/* 3180 */       if (postEventsForChanges()) {
/* 3181 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argSaleTaxModifier));
/*      */       }
/* 3183 */       this._taxModifiers.remove(argSaleTaxModifier);
/*      */       
/* 3185 */       argSaleTaxModifier.setParentLine(null);
/* 3186 */       if (postEventsForChanges()) {
/* 3187 */         this._events.post(ISaleReturnLineItem.REMOVE_TAXMODIFIERS, argSaleTaxModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "CustomerAccountModifier")
/*      */   public ICustomerItemAccountModifier getCustomerAccountModifier() {
/* 3194 */     return this._customerAccountModifier;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setCustomerAccountModifierImpl(ICustomerItemAccountModifier argCustomerAccountModifier) {
/* 3199 */     if (argCustomerAccountModifier == null) {
/*      */       
/* 3201 */       if (this._customerAccountModifier != null) {
/* 3202 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 3204 */       if (this._customerAccountModifier != null) {
/*      */         
/* 3206 */         if (postEventsForChanges()) {
/* 3207 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._customerAccountModifier));
/*      */         }
/* 3209 */         addDeletedObject((IDataModel)this._customerAccountModifier);
/*      */       } 
/*      */     } else {
/*      */       
/* 3213 */       argCustomerAccountModifier.setBusinessDate(getBusinessDate());
/* 3214 */       argCustomerAccountModifier.setOrganizationId(getOrganizationId());
/* 3215 */       argCustomerAccountModifier.setRetailLocationId(getRetailLocationId());
/* 3216 */       argCustomerAccountModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 3217 */       argCustomerAccountModifier.setTransactionSequence(getTransactionSequence());
/* 3218 */       argCustomerAccountModifier.setWorkstationId(getWorkstationId());
/*      */ 
/*      */       
/* 3221 */       argCustomerAccountModifier.setParentLine(this);
/*      */ 
/*      */       
/* 3224 */       if (postEventsForChanges()) {
/* 3225 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argCustomerAccountModifier));
/*      */       }
/*      */     } 
/*      */     
/* 3229 */     this._customerAccountModifier = argCustomerAccountModifier;
/* 3230 */     if (postEventsForChanges()) {
/* 3231 */       this._events.post(ISaleReturnLineItem.SET_CUSTOMERACCOUNTMODIFIER, argCustomerAccountModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Item")
/*      */   public IItem getItem() {
/* 3237 */     return this._item;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setItem(IItem argItem) {
/* 3242 */     if (argItem == null) {
/*      */       
/* 3244 */       getDAO_().setItemId((String)null);
/* 3245 */       if (this._item != null)
/*      */       {
/* 3247 */         if (postEventsForChanges()) {
/* 3248 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._item));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 3253 */       getDAO_().setItemId(argItem.getItemId());
/*      */       
/* 3255 */       if (postEventsForChanges()) {
/* 3256 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItem));
/*      */       }
/*      */     } 
/*      */     
/* 3260 */     this._item = argItem;
/* 3261 */     if (postEventsForChanges()) {
/* 3262 */       this._events.post(ISaleReturnLineItem.SET_ITEM, argItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "NoteSeq")
/*      */   public List<IRetailTransactionLineItemNotes> getNoteSeq() {
/* 3268 */     if (this._noteSeq == null) {
/* 3269 */       this._noteSeq = new HistoricalList(null);
/*      */     }
/* 3271 */     return (List<IRetailTransactionLineItemNotes>)this._noteSeq;
/*      */   }
/*      */   
/*      */   public void setNoteSeq(List<IRetailTransactionLineItemNotes> argNoteSeq) {
/* 3275 */     if (this._noteSeq == null) {
/* 3276 */       this._noteSeq = new HistoricalList(argNoteSeq);
/*      */     } else {
/* 3278 */       this._noteSeq.setCurrentList(argNoteSeq);
/*      */     } 
/*      */     
/* 3281 */     for (IRetailTransactionLineItemNotes child : this._noteSeq) {
/* 3282 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 3285 */     for (IRetailTransactionLineItemNotes child : this._noteSeq) {
/* 3286 */       RetailTransactionLineItemNotesModel model = (RetailTransactionLineItemNotesModel)child;
/* 3287 */       model.setOrganizationId_noev(getOrganizationId());
/* 3288 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 3289 */       model.setBusinessDate_noev(getBusinessDate());
/* 3290 */       model.setWorkstationId_noev(getWorkstationId());
/* 3291 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 3292 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 3293 */       if (child instanceof IDataModelImpl) {
/* 3294 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 3295 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3296 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3297 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 3300 */       if (postEventsForChanges()) {
/* 3301 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addRetailTransactionLineItemNotesImpl(IRetailTransactionLineItemNotes argRetailTransactionLineItemNotes) {
/* 3308 */     argRetailTransactionLineItemNotes.setParentLine(this);
/* 3309 */     if (this._noteSeq == null) {
/* 3310 */       this._noteSeq = new HistoricalList(null);
/*      */     }
/* 3312 */     argRetailTransactionLineItemNotes.setOrganizationId(getOrganizationId());
/* 3313 */     argRetailTransactionLineItemNotes.setRetailLocationId(getRetailLocationId());
/* 3314 */     argRetailTransactionLineItemNotes.setBusinessDate(getBusinessDate());
/* 3315 */     argRetailTransactionLineItemNotes.setWorkstationId(getWorkstationId());
/* 3316 */     argRetailTransactionLineItemNotes.setTransactionSequence(getTransactionSequence());
/* 3317 */     argRetailTransactionLineItemNotes.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 3318 */     if (argRetailTransactionLineItemNotes instanceof IDataModelImpl) {
/* 3319 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailTransactionLineItemNotes).getDAO();
/* 3320 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3321 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3322 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3327 */     if (postEventsForChanges()) {
/* 3328 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItemNotes));
/*      */     }
/*      */     
/* 3331 */     this._noteSeq.add(argRetailTransactionLineItemNotes);
/* 3332 */     if (postEventsForChanges()) {
/* 3333 */       this._events.post(ISaleReturnLineItem.ADD_NOTESEQ, argRetailTransactionLineItemNotes);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailTransactionLineItemNotes(IRetailTransactionLineItemNotes argRetailTransactionLineItemNotes) {
/* 3338 */     if (this._noteSeq != null) {
/*      */       
/* 3340 */       if (postEventsForChanges()) {
/* 3341 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailTransactionLineItemNotes));
/*      */       }
/* 3343 */       this._noteSeq.remove(argRetailTransactionLineItemNotes);
/*      */       
/* 3345 */       argRetailTransactionLineItemNotes.setParentLine(null);
/* 3346 */       if (postEventsForChanges()) {
/* 3347 */         this._events.post(ISaleReturnLineItem.REMOVE_NOTESEQ, argRetailTransactionLineItemNotes);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "RetailInventoryLocationModifiers")
/*      */   public List<IRetailInventoryLocationModifier> getRetailInventoryLocationModifiers() {
/* 3354 */     if (this._retailInventoryLocationModifiers == null) {
/* 3355 */       this._retailInventoryLocationModifiers = new HistoricalList(null);
/*      */     }
/* 3357 */     return (List<IRetailInventoryLocationModifier>)this._retailInventoryLocationModifiers;
/*      */   }
/*      */   
/*      */   public void setRetailInventoryLocationModifiers(List<IRetailInventoryLocationModifier> argRetailInventoryLocationModifiers) {
/* 3361 */     if (this._retailInventoryLocationModifiers == null) {
/* 3362 */       this._retailInventoryLocationModifiers = new HistoricalList(argRetailInventoryLocationModifiers);
/*      */     } else {
/* 3364 */       this._retailInventoryLocationModifiers.setCurrentList(argRetailInventoryLocationModifiers);
/*      */     } 
/*      */     
/* 3367 */     for (IRetailInventoryLocationModifier child : this._retailInventoryLocationModifiers) {
/* 3368 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 3371 */     for (IRetailInventoryLocationModifier child : this._retailInventoryLocationModifiers) {
/* 3372 */       RetailInventoryLocationModifierModel model = (RetailInventoryLocationModifierModel)child;
/* 3373 */       model.setOrganizationId_noev(getOrganizationId());
/* 3374 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 3375 */       model.setBusinessDate_noev(getBusinessDate());
/* 3376 */       model.setWorkstationId_noev(getWorkstationId());
/* 3377 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 3378 */       model.setTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 3379 */       if (child instanceof IDataModelImpl) {
/* 3380 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 3381 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3382 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3383 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 3386 */       if (postEventsForChanges()) {
/* 3387 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addRetailInventoryLocationModifierImpl(IRetailInventoryLocationModifier argRetailInventoryLocationModifier) {
/* 3394 */     argRetailInventoryLocationModifier.setParentLine(this);
/* 3395 */     if (this._retailInventoryLocationModifiers == null) {
/* 3396 */       this._retailInventoryLocationModifiers = new HistoricalList(null);
/*      */     }
/* 3398 */     argRetailInventoryLocationModifier.setOrganizationId(getOrganizationId());
/* 3399 */     argRetailInventoryLocationModifier.setRetailLocationId(getRetailLocationId());
/* 3400 */     argRetailInventoryLocationModifier.setBusinessDate(getBusinessDate());
/* 3401 */     argRetailInventoryLocationModifier.setWorkstationId(getWorkstationId());
/* 3402 */     argRetailInventoryLocationModifier.setTransactionSequence(getTransactionSequence());
/* 3403 */     argRetailInventoryLocationModifier.setTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 3404 */     if (argRetailInventoryLocationModifier instanceof IDataModelImpl) {
/* 3405 */       IDataAccessObject childDao = ((IDataModelImpl)argRetailInventoryLocationModifier).getDAO();
/* 3406 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3407 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3408 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3413 */     if (postEventsForChanges()) {
/* 3414 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailInventoryLocationModifier));
/*      */     }
/*      */     
/* 3417 */     this._retailInventoryLocationModifiers.add(argRetailInventoryLocationModifier);
/* 3418 */     if (postEventsForChanges()) {
/* 3419 */       this._events.post(ISaleReturnLineItem.ADD_RETAILINVENTORYLOCATIONMODIFIERS, argRetailInventoryLocationModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeRetailInventoryLocationModifier(IRetailInventoryLocationModifier argRetailInventoryLocationModifier) {
/* 3424 */     if (this._retailInventoryLocationModifiers != null) {
/*      */       
/* 3426 */       if (postEventsForChanges()) {
/* 3427 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argRetailInventoryLocationModifier));
/*      */       }
/* 3429 */       this._retailInventoryLocationModifiers.remove(argRetailInventoryLocationModifier);
/*      */       
/* 3431 */       argRetailInventoryLocationModifier.setParentLine(null);
/* 3432 */       if (postEventsForChanges()) {
/* 3433 */         this._events.post(ISaleReturnLineItem.REMOVE_RETAILINVENTORYLOCATIONMODIFIERS, argRetailInventoryLocationModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "OrderModifier")
/*      */   public IOrderModifier getOrderModifier() {
/* 3440 */     return this._orderModifier;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOrderModifier(IOrderModifier argOrderModifier) {
/* 3445 */     if (argOrderModifier == null) {
/*      */       
/* 3447 */       if (this._orderModifier != null) {
/* 3448 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/* 3450 */       if (this._orderModifier != null) {
/*      */         
/* 3452 */         if (postEventsForChanges()) {
/* 3453 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._orderModifier));
/*      */         }
/* 3455 */         addDeletedObject((IDataModel)this._orderModifier);
/*      */       } 
/*      */     } else {
/*      */       
/* 3459 */       argOrderModifier.setOrganizationId(getOrganizationId());
/* 3460 */       argOrderModifier.setRetailLocationId(getRetailLocationId());
/* 3461 */       argOrderModifier.setBusinessDate(getBusinessDate());
/* 3462 */       argOrderModifier.setWorkstationId(getWorkstationId());
/* 3463 */       argOrderModifier.setTransactionSequence(getTransactionSequence());
/* 3464 */       argOrderModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/*      */ 
/*      */       
/* 3467 */       argOrderModifier.setParentLine(this);
/*      */ 
/*      */       
/* 3470 */       if (postEventsForChanges()) {
/* 3471 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argOrderModifier));
/*      */       }
/*      */     } 
/*      */     
/* 3475 */     this._orderModifier = argOrderModifier;
/* 3476 */     if (postEventsForChanges()) {
/* 3477 */       this._events.post(ISaleReturnLineItem.SET_ORDERMODIFIER, argOrderModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "KitComponentModifiers")
/*      */   public List<IKitComponentModifier> getKitComponentModifiers() {
/* 3483 */     if (this._kitComponentModifiers == null) {
/* 3484 */       this._kitComponentModifiers = new HistoricalList(null);
/*      */     }
/* 3486 */     return (List<IKitComponentModifier>)this._kitComponentModifiers;
/*      */   }
/*      */   
/*      */   public void setKitComponentModifiers(List<IKitComponentModifier> argKitComponentModifiers) {
/* 3490 */     if (this._kitComponentModifiers == null) {
/* 3491 */       this._kitComponentModifiers = new HistoricalList(argKitComponentModifiers);
/*      */     } else {
/* 3493 */       this._kitComponentModifiers.setCurrentList(argKitComponentModifiers);
/*      */     } 
/*      */     
/* 3496 */     for (IKitComponentModifier child : this._kitComponentModifiers) {
/* 3497 */       child.setParentLine(this);
/*      */     }
/*      */     
/* 3500 */     for (IKitComponentModifier child : this._kitComponentModifiers) {
/* 3501 */       KitComponentModifierModel model = (KitComponentModifierModel)child;
/* 3502 */       model.setOrganizationId_noev(getOrganizationId());
/* 3503 */       model.setRetailLocationId_noev(getRetailLocationId());
/* 3504 */       model.setBusinessDate_noev(getBusinessDate());
/* 3505 */       model.setWorkstationId_noev(getWorkstationId());
/* 3506 */       model.setTransactionSequence_noev(getTransactionSequence());
/* 3507 */       model.setRetailTransactionLineItemSequence_noev(getRetailTransactionLineItemSequence());
/* 3508 */       if (child instanceof IDataModelImpl) {
/* 3509 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 3510 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3511 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3512 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 3515 */       if (postEventsForChanges()) {
/* 3516 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addKitComponentModifier(IKitComponentModifier argKitComponentModifier) {
/* 3523 */     argKitComponentModifier.setParentLine(this);
/* 3524 */     if (this._kitComponentModifiers == null) {
/* 3525 */       this._kitComponentModifiers = new HistoricalList(null);
/*      */     }
/* 3527 */     argKitComponentModifier.setOrganizationId(getOrganizationId());
/* 3528 */     argKitComponentModifier.setRetailLocationId(getRetailLocationId());
/* 3529 */     argKitComponentModifier.setBusinessDate(getBusinessDate());
/* 3530 */     argKitComponentModifier.setWorkstationId(getWorkstationId());
/* 3531 */     argKitComponentModifier.setTransactionSequence(getTransactionSequence());
/* 3532 */     argKitComponentModifier.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 3533 */     if (argKitComponentModifier instanceof IDataModelImpl) {
/* 3534 */       IDataAccessObject childDao = ((IDataModelImpl)argKitComponentModifier).getDAO();
/* 3535 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 3536 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 3537 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3542 */     if (postEventsForChanges()) {
/* 3543 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponentModifier));
/*      */     }
/*      */     
/* 3546 */     this._kitComponentModifiers.add(argKitComponentModifier);
/* 3547 */     if (postEventsForChanges()) {
/* 3548 */       this._events.post(ISaleReturnLineItem.ADD_KITCOMPONENTMODIFIERS, argKitComponentModifier);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeKitComponentModifier(IKitComponentModifier argKitComponentModifier) {
/* 3553 */     if (this._kitComponentModifiers != null) {
/*      */       
/* 3555 */       if (postEventsForChanges()) {
/* 3556 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argKitComponentModifier));
/*      */       }
/* 3558 */       this._kitComponentModifiers.remove(argKitComponentModifier);
/*      */       
/* 3560 */       argKitComponentModifier.setParentLine(null);
/* 3561 */       if (postEventsForChanges()) {
/* 3562 */         this._events.post(ISaleReturnLineItem.REMOVE_KITCOMPONENTMODIFIERS, argKitComponentModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 3569 */     if ("BaseReturnedQuantity".equals(argFieldId)) {
/* 3570 */       return getBaseReturnedQuantity();
/*      */     }
/* 3572 */     if ("CommissionModifiers".equals(argFieldId)) {
/* 3573 */       return getCommissionModifiers();
/*      */     }
/* 3575 */     if ("DimensionModifiers".equals(argFieldId)) {
/* 3576 */       return getDimensionModifiers();
/*      */     }
/* 3578 */     if ("InventoryDocumentLineItems".equals(argFieldId)) {
/* 3579 */       return getInventoryDocumentLineItems();
/*      */     }
/* 3581 */     if ("LineItemAssociationModifiers".equals(argFieldId)) {
/* 3582 */       return getLineItemAssociationModifiers();
/*      */     }
/* 3584 */     if ("RetailPriceModifiers".equals(argFieldId)) {
/* 3585 */       return getRetailPriceModifiers();
/*      */     }
/* 3587 */     if ("TaxGroup".equals(argFieldId)) {
/* 3588 */       return getTaxGroup();
/*      */     }
/* 3590 */     if ("TaxModifiers".equals(argFieldId)) {
/* 3591 */       return getTaxModifiers();
/*      */     }
/* 3593 */     if ("CustomerAccountModifier".equals(argFieldId)) {
/* 3594 */       return getCustomerAccountModifier();
/*      */     }
/* 3596 */     if ("Item".equals(argFieldId)) {
/* 3597 */       return getItem();
/*      */     }
/* 3599 */     if ("NoteSeq".equals(argFieldId)) {
/* 3600 */       return getNoteSeq();
/*      */     }
/* 3602 */     if ("RetailInventoryLocationModifiers".equals(argFieldId)) {
/* 3603 */       return getRetailInventoryLocationModifiers();
/*      */     }
/* 3605 */     if ("OrderModifier".equals(argFieldId)) {
/* 3606 */       return getOrderModifier();
/*      */     }
/* 3608 */     if ("KitComponentModifiers".equals(argFieldId)) {
/* 3609 */       return getKitComponentModifiers();
/*      */     }
/* 3611 */     if ("SaleReturnLineItemExtension".equals(argFieldId)) {
/* 3612 */       return this._myExtension;
/*      */     }
/*      */     
/* 3615 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 3621 */     if ("BaseReturnedQuantity".equals(argFieldId)) {
/* 3622 */       setBaseReturnedQuantity((IReturnedItemCount)argValue);
/*      */     }
/* 3624 */     else if ("CommissionModifiers".equals(argFieldId)) {
/* 3625 */       setCommissionModifiers(changeToList(argValue, ICommissionModifier.class));
/*      */     }
/* 3627 */     else if ("DimensionModifiers".equals(argFieldId)) {
/* 3628 */       setDimensionModifiers(changeToList(argValue, IDimensionModifier.class));
/*      */     }
/* 3630 */     else if ("InventoryDocumentLineItems".equals(argFieldId)) {
/* 3631 */       setInventoryDocumentLineItems(changeToList(argValue, IInventoryDocumentLineItem.class));
/*      */     }
/* 3633 */     else if ("LineItemAssociationModifiers".equals(argFieldId)) {
/* 3634 */       setLineItemAssociationModifiers(changeToList(argValue, ILineItemAssociationModifier.class));
/*      */     }
/* 3636 */     else if ("RetailPriceModifiers".equals(argFieldId)) {
/* 3637 */       setRetailPriceModifiers(changeToList(argValue, IRetailPriceModifier.class));
/*      */     }
/* 3639 */     else if ("TaxGroup".equals(argFieldId)) {
/* 3640 */       setTaxGroup((ITaxGroup)argValue);
/*      */     }
/* 3642 */     else if ("TaxModifiers".equals(argFieldId)) {
/* 3643 */       setTaxModifiers(changeToList(argValue, ISaleTaxModifier.class));
/*      */     }
/* 3645 */     else if ("CustomerAccountModifier".equals(argFieldId)) {
/* 3646 */       setCustomerAccountModifier((ICustomerItemAccountModifier)argValue);
/*      */     }
/* 3648 */     else if ("Item".equals(argFieldId)) {
/* 3649 */       setItem((IItem)argValue);
/*      */     }
/* 3651 */     else if ("NoteSeq".equals(argFieldId)) {
/* 3652 */       setNoteSeq(changeToList(argValue, IRetailTransactionLineItemNotes.class));
/*      */     }
/* 3654 */     else if ("RetailInventoryLocationModifiers".equals(argFieldId)) {
/* 3655 */       setRetailInventoryLocationModifiers(changeToList(argValue, IRetailInventoryLocationModifier.class));
/*      */     }
/* 3657 */     else if ("OrderModifier".equals(argFieldId)) {
/* 3658 */       setOrderModifier((IOrderModifier)argValue);
/*      */     }
/* 3660 */     else if ("KitComponentModifiers".equals(argFieldId)) {
/* 3661 */       setKitComponentModifiers(changeToList(argValue, IKitComponentModifier.class));
/*      */     }
/* 3663 */     else if ("SaleReturnLineItemExtension".equals(argFieldId)) {
/* 3664 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 3667 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 3673 */     super.setDependencies(argPD, argEM);
/* 3674 */     if (this._baseReturnedQuantity != null) {
/* 3675 */       ((IDataModelImpl)this._baseReturnedQuantity).setDependencies(argPD, argEM);
/*      */     }
/* 3677 */     if (this._commissionModifiers != null) {
/* 3678 */       for (ICommissionModifier relationship : this._commissionModifiers) {
/* 3679 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3682 */     if (this._dimensionModifiers != null) {
/* 3683 */       for (IDimensionModifier relationship : this._dimensionModifiers) {
/* 3684 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3687 */     if (this._inventoryDocumentLineItems != null) {
/* 3688 */       for (IInventoryDocumentLineItem relationship : this._inventoryDocumentLineItems) {
/* 3689 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3692 */     if (this._lineItemAssociationModifiers != null) {
/* 3693 */       for (ILineItemAssociationModifier relationship : this._lineItemAssociationModifiers) {
/* 3694 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3697 */     if (this._retailPriceModifiers != null) {
/* 3698 */       for (IRetailPriceModifier relationship : this._retailPriceModifiers) {
/* 3699 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3702 */     if (this._taxGroup != null) {
/* 3703 */       ((IDataModelImpl)this._taxGroup).setDependencies(argPD, argEM);
/*      */     }
/* 3705 */     if (this._taxModifiers != null) {
/* 3706 */       for (ISaleTaxModifier relationship : this._taxModifiers) {
/* 3707 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3710 */     if (this._customerAccountModifier != null) {
/* 3711 */       ((IDataModelImpl)this._customerAccountModifier).setDependencies(argPD, argEM);
/*      */     }
/* 3713 */     if (this._item != null) {
/* 3714 */       ((IDataModelImpl)this._item).setDependencies(argPD, argEM);
/*      */     }
/* 3716 */     if (this._noteSeq != null) {
/* 3717 */       for (IRetailTransactionLineItemNotes relationship : this._noteSeq) {
/* 3718 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3721 */     if (this._retailInventoryLocationModifiers != null) {
/* 3722 */       for (IRetailInventoryLocationModifier relationship : this._retailInventoryLocationModifiers) {
/* 3723 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 3726 */     if (this._orderModifier != null) {
/* 3727 */       ((IDataModelImpl)this._orderModifier).setDependencies(argPD, argEM);
/*      */     }
/* 3729 */     if (this._kitComponentModifiers != null) {
/* 3730 */       for (IKitComponentModifier relationship : this._kitComponentModifiers) {
/* 3731 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getSaleReturnLineItemExt() {
/* 3737 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setSaleReturnLineItemExt(IDataModel argExt) {
/* 3741 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 3746 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 3750 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 3753 */     super.startTransaction();
/*      */     
/* 3755 */     this._baseReturnedQuantitySavepoint = this._baseReturnedQuantity;
/* 3756 */     if (this._baseReturnedQuantity != null) {
/* 3757 */       this._baseReturnedQuantity.startTransaction();
/*      */     }
/*      */     
/* 3760 */     this._commissionModifiersSavepoint = this._commissionModifiers;
/* 3761 */     if (this._commissionModifiers != null) {
/* 3762 */       this._commissionModifiersSavepoint = new HistoricalList((List)this._commissionModifiers);
/* 3763 */       Iterator<IDataModel> it = this._commissionModifiers.iterator();
/* 3764 */       while (it.hasNext()) {
/* 3765 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3769 */     this._dimensionModifiersSavepoint = this._dimensionModifiers;
/* 3770 */     if (this._dimensionModifiers != null) {
/* 3771 */       this._dimensionModifiersSavepoint = new HistoricalList((List)this._dimensionModifiers);
/* 3772 */       Iterator<IDataModel> it = this._dimensionModifiers.iterator();
/* 3773 */       while (it.hasNext()) {
/* 3774 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3778 */     this._inventoryDocumentLineItemsSavepoint = this._inventoryDocumentLineItems;
/* 3779 */     if (this._inventoryDocumentLineItems != null) {
/* 3780 */       this._inventoryDocumentLineItemsSavepoint = new HistoricalList((List)this._inventoryDocumentLineItems);
/* 3781 */       Iterator<IDataModel> it = this._inventoryDocumentLineItems.iterator();
/* 3782 */       while (it.hasNext()) {
/* 3783 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3787 */     this._lineItemAssociationModifiersSavepoint = this._lineItemAssociationModifiers;
/* 3788 */     if (this._lineItemAssociationModifiers != null) {
/* 3789 */       this._lineItemAssociationModifiersSavepoint = new HistoricalList((List)this._lineItemAssociationModifiers);
/* 3790 */       Iterator<IDataModel> it = this._lineItemAssociationModifiers.iterator();
/* 3791 */       while (it.hasNext()) {
/* 3792 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3796 */     this._retailPriceModifiersSavepoint = this._retailPriceModifiers;
/* 3797 */     if (this._retailPriceModifiers != null) {
/* 3798 */       this._retailPriceModifiersSavepoint = new HistoricalList((List)this._retailPriceModifiers);
/* 3799 */       Iterator<IDataModel> it = this._retailPriceModifiers.iterator();
/* 3800 */       while (it.hasNext()) {
/* 3801 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3805 */     this._taxGroupSavepoint = this._taxGroup;
/* 3806 */     if (this._taxGroup != null) {
/* 3807 */       this._taxGroup.startTransaction();
/*      */     }
/*      */     
/* 3810 */     this._taxModifiersSavepoint = this._taxModifiers;
/* 3811 */     if (this._taxModifiers != null) {
/* 3812 */       this._taxModifiersSavepoint = new HistoricalList((List)this._taxModifiers);
/* 3813 */       Iterator<IDataModel> it = this._taxModifiers.iterator();
/* 3814 */       while (it.hasNext()) {
/* 3815 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3819 */     this._customerAccountModifierSavepoint = this._customerAccountModifier;
/* 3820 */     if (this._customerAccountModifier != null) {
/* 3821 */       this._customerAccountModifier.startTransaction();
/*      */     }
/*      */     
/* 3824 */     this._itemSavepoint = this._item;
/* 3825 */     if (this._item != null) {
/* 3826 */       this._item.startTransaction();
/*      */     }
/*      */     
/* 3829 */     this._noteSeqSavepoint = this._noteSeq;
/* 3830 */     if (this._noteSeq != null) {
/* 3831 */       this._noteSeqSavepoint = new HistoricalList((List)this._noteSeq);
/* 3832 */       Iterator<IDataModel> it = this._noteSeq.iterator();
/* 3833 */       while (it.hasNext()) {
/* 3834 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3838 */     this._retailInventoryLocationModifiersSavepoint = this._retailInventoryLocationModifiers;
/* 3839 */     if (this._retailInventoryLocationModifiers != null) {
/* 3840 */       this._retailInventoryLocationModifiersSavepoint = new HistoricalList((List)this._retailInventoryLocationModifiers);
/* 3841 */       Iterator<IDataModel> it = this._retailInventoryLocationModifiers.iterator();
/* 3842 */       while (it.hasNext()) {
/* 3843 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 3847 */     this._orderModifierSavepoint = this._orderModifier;
/* 3848 */     if (this._orderModifier != null) {
/* 3849 */       this._orderModifier.startTransaction();
/*      */     }
/*      */     
/* 3852 */     this._kitComponentModifiersSavepoint = this._kitComponentModifiers;
/* 3853 */     if (this._kitComponentModifiers != null) {
/* 3854 */       this._kitComponentModifiersSavepoint = new HistoricalList((List)this._kitComponentModifiers);
/* 3855 */       Iterator<IDataModel> it = this._kitComponentModifiers.iterator();
/* 3856 */       while (it.hasNext()) {
/* 3857 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3862 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 3867 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 3870 */     super.rollbackChanges();
/*      */     
/* 3872 */     this._baseReturnedQuantity = this._baseReturnedQuantitySavepoint;
/* 3873 */     this._baseReturnedQuantitySavepoint = null;
/* 3874 */     if (this._baseReturnedQuantity != null) {
/* 3875 */       this._baseReturnedQuantity.rollbackChanges();
/*      */     }
/*      */     
/* 3878 */     this._commissionModifiers = this._commissionModifiersSavepoint;
/* 3879 */     this._commissionModifiersSavepoint = null;
/* 3880 */     if (this._commissionModifiers != null) {
/* 3881 */       Iterator<IDataModel> it = this._commissionModifiers.iterator();
/* 3882 */       while (it.hasNext()) {
/* 3883 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3887 */     this._dimensionModifiers = this._dimensionModifiersSavepoint;
/* 3888 */     this._dimensionModifiersSavepoint = null;
/* 3889 */     if (this._dimensionModifiers != null) {
/* 3890 */       Iterator<IDataModel> it = this._dimensionModifiers.iterator();
/* 3891 */       while (it.hasNext()) {
/* 3892 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3896 */     this._inventoryDocumentLineItems = this._inventoryDocumentLineItemsSavepoint;
/* 3897 */     this._inventoryDocumentLineItemsSavepoint = null;
/* 3898 */     if (this._inventoryDocumentLineItems != null) {
/* 3899 */       Iterator<IDataModel> it = this._inventoryDocumentLineItems.iterator();
/* 3900 */       while (it.hasNext()) {
/* 3901 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3905 */     this._lineItemAssociationModifiers = this._lineItemAssociationModifiersSavepoint;
/* 3906 */     this._lineItemAssociationModifiersSavepoint = null;
/* 3907 */     if (this._lineItemAssociationModifiers != null) {
/* 3908 */       Iterator<IDataModel> it = this._lineItemAssociationModifiers.iterator();
/* 3909 */       while (it.hasNext()) {
/* 3910 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3914 */     this._retailPriceModifiers = this._retailPriceModifiersSavepoint;
/* 3915 */     this._retailPriceModifiersSavepoint = null;
/* 3916 */     if (this._retailPriceModifiers != null) {
/* 3917 */       Iterator<IDataModel> it = this._retailPriceModifiers.iterator();
/* 3918 */       while (it.hasNext()) {
/* 3919 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3923 */     this._taxGroup = this._taxGroupSavepoint;
/* 3924 */     this._taxGroupSavepoint = null;
/* 3925 */     if (this._taxGroup != null) {
/* 3926 */       this._taxGroup.rollbackChanges();
/*      */     }
/*      */     
/* 3929 */     this._taxModifiers = this._taxModifiersSavepoint;
/* 3930 */     this._taxModifiersSavepoint = null;
/* 3931 */     if (this._taxModifiers != null) {
/* 3932 */       Iterator<IDataModel> it = this._taxModifiers.iterator();
/* 3933 */       while (it.hasNext()) {
/* 3934 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3938 */     this._customerAccountModifier = this._customerAccountModifierSavepoint;
/* 3939 */     this._customerAccountModifierSavepoint = null;
/* 3940 */     if (this._customerAccountModifier != null) {
/* 3941 */       this._customerAccountModifier.rollbackChanges();
/*      */     }
/*      */     
/* 3944 */     this._item = this._itemSavepoint;
/* 3945 */     this._itemSavepoint = null;
/* 3946 */     if (this._item != null) {
/* 3947 */       this._item.rollbackChanges();
/*      */     }
/*      */     
/* 3950 */     this._noteSeq = this._noteSeqSavepoint;
/* 3951 */     this._noteSeqSavepoint = null;
/* 3952 */     if (this._noteSeq != null) {
/* 3953 */       Iterator<IDataModel> it = this._noteSeq.iterator();
/* 3954 */       while (it.hasNext()) {
/* 3955 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3959 */     this._retailInventoryLocationModifiers = this._retailInventoryLocationModifiersSavepoint;
/* 3960 */     this._retailInventoryLocationModifiersSavepoint = null;
/* 3961 */     if (this._retailInventoryLocationModifiers != null) {
/* 3962 */       Iterator<IDataModel> it = this._retailInventoryLocationModifiers.iterator();
/* 3963 */       while (it.hasNext()) {
/* 3964 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 3968 */     this._orderModifier = this._orderModifierSavepoint;
/* 3969 */     this._orderModifierSavepoint = null;
/* 3970 */     if (this._orderModifier != null) {
/* 3971 */       this._orderModifier.rollbackChanges();
/*      */     }
/*      */     
/* 3974 */     this._kitComponentModifiers = this._kitComponentModifiersSavepoint;
/* 3975 */     this._kitComponentModifiersSavepoint = null;
/* 3976 */     if (this._kitComponentModifiers != null) {
/* 3977 */       Iterator<IDataModel> it = this._kitComponentModifiers.iterator();
/* 3978 */       while (it.hasNext()) {
/* 3979 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 3987 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 3990 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 3993 */     super.commitTransaction();
/*      */     
/* 3995 */     this._baseReturnedQuantitySavepoint = this._baseReturnedQuantity;
/* 3996 */     if (this._baseReturnedQuantity != null) {
/* 3997 */       this._baseReturnedQuantity.commitTransaction();
/*      */     }
/*      */     
/* 4000 */     this._commissionModifiersSavepoint = this._commissionModifiers;
/* 4001 */     if (this._commissionModifiers != null) {
/* 4002 */       Iterator<IDataModel> it = this._commissionModifiers.iterator();
/* 4003 */       while (it.hasNext()) {
/* 4004 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4006 */       this._commissionModifiers = new HistoricalList((List)this._commissionModifiers);
/*      */     } 
/*      */     
/* 4009 */     this._dimensionModifiersSavepoint = this._dimensionModifiers;
/* 4010 */     if (this._dimensionModifiers != null) {
/* 4011 */       Iterator<IDataModel> it = this._dimensionModifiers.iterator();
/* 4012 */       while (it.hasNext()) {
/* 4013 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4015 */       this._dimensionModifiers = new HistoricalList((List)this._dimensionModifiers);
/*      */     } 
/*      */     
/* 4018 */     this._inventoryDocumentLineItemsSavepoint = this._inventoryDocumentLineItems;
/* 4019 */     if (this._inventoryDocumentLineItems != null) {
/* 4020 */       Iterator<IDataModel> it = this._inventoryDocumentLineItems.iterator();
/* 4021 */       while (it.hasNext()) {
/* 4022 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4024 */       this._inventoryDocumentLineItems = new HistoricalList((List)this._inventoryDocumentLineItems);
/*      */     } 
/*      */     
/* 4027 */     this._lineItemAssociationModifiersSavepoint = this._lineItemAssociationModifiers;
/* 4028 */     if (this._lineItemAssociationModifiers != null) {
/* 4029 */       Iterator<IDataModel> it = this._lineItemAssociationModifiers.iterator();
/* 4030 */       while (it.hasNext()) {
/* 4031 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4033 */       this._lineItemAssociationModifiers = new HistoricalList((List)this._lineItemAssociationModifiers);
/*      */     } 
/*      */     
/* 4036 */     this._retailPriceModifiersSavepoint = this._retailPriceModifiers;
/* 4037 */     if (this._retailPriceModifiers != null) {
/* 4038 */       Iterator<IDataModel> it = this._retailPriceModifiers.iterator();
/* 4039 */       while (it.hasNext()) {
/* 4040 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4042 */       this._retailPriceModifiers = new HistoricalList((List)this._retailPriceModifiers);
/*      */     } 
/*      */     
/* 4045 */     this._taxGroupSavepoint = this._taxGroup;
/* 4046 */     if (this._taxGroup != null) {
/* 4047 */       this._taxGroup.commitTransaction();
/*      */     }
/*      */     
/* 4050 */     this._taxModifiersSavepoint = this._taxModifiers;
/* 4051 */     if (this._taxModifiers != null) {
/* 4052 */       Iterator<IDataModel> it = this._taxModifiers.iterator();
/* 4053 */       while (it.hasNext()) {
/* 4054 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4056 */       this._taxModifiers = new HistoricalList((List)this._taxModifiers);
/*      */     } 
/*      */     
/* 4059 */     this._customerAccountModifierSavepoint = this._customerAccountModifier;
/* 4060 */     if (this._customerAccountModifier != null) {
/* 4061 */       this._customerAccountModifier.commitTransaction();
/*      */     }
/*      */     
/* 4064 */     this._itemSavepoint = this._item;
/* 4065 */     if (this._item != null) {
/* 4066 */       this._item.commitTransaction();
/*      */     }
/*      */     
/* 4069 */     this._noteSeqSavepoint = this._noteSeq;
/* 4070 */     if (this._noteSeq != null) {
/* 4071 */       Iterator<IDataModel> it = this._noteSeq.iterator();
/* 4072 */       while (it.hasNext()) {
/* 4073 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4075 */       this._noteSeq = new HistoricalList((List)this._noteSeq);
/*      */     } 
/*      */     
/* 4078 */     this._retailInventoryLocationModifiersSavepoint = this._retailInventoryLocationModifiers;
/* 4079 */     if (this._retailInventoryLocationModifiers != null) {
/* 4080 */       Iterator<IDataModel> it = this._retailInventoryLocationModifiers.iterator();
/* 4081 */       while (it.hasNext()) {
/* 4082 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4084 */       this._retailInventoryLocationModifiers = new HistoricalList((List)this._retailInventoryLocationModifiers);
/*      */     } 
/*      */     
/* 4087 */     this._orderModifierSavepoint = this._orderModifier;
/* 4088 */     if (this._orderModifier != null) {
/* 4089 */       this._orderModifier.commitTransaction();
/*      */     }
/*      */     
/* 4092 */     this._kitComponentModifiersSavepoint = this._kitComponentModifiers;
/* 4093 */     if (this._kitComponentModifiers != null) {
/* 4094 */       Iterator<IDataModel> it = this._kitComponentModifiers.iterator();
/* 4095 */       while (it.hasNext()) {
/* 4096 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 4098 */       this._kitComponentModifiers = new HistoricalList((List)this._kitComponentModifiers);
/*      */     } 
/*      */ 
/*      */     
/* 4102 */     this._alreadyInCommit = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream argStream) throws IOException, ClassNotFoundException {
/* 4107 */     argStream.defaultReadObject();
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
/* 4123 */   private ListMultimap<String, IRetailPriceModifier> _retailPriceModifierTypeIdx = Multimaps.synchronizedListMultimap(
/* 4124 */       (ListMultimap)LinkedListMultimap.create());
/*      */   
/*      */   private boolean _calculatedPriceUpdated = false;
/*      */   private transient BigDecimal _returnedQuantity;
/*      */   private transient BigDecimal _preDiscountAmount;
/*      */   private transient BigDecimal _preDealAmount;
/*      */   private transient BigDecimal _originalBaseUnitPrice;
/*      */   private transient BigDecimal _originalTaxRate;
/*      */   private transient Boolean _selectedForPrint;
/* 4133 */   private transient List<String> _removedDealIds = new ArrayList<>();
/*      */   private transient Date _expirationDate;
/*      */   private transient boolean _returnedWithGiftReceipt = false;
/*      */   private transient boolean _incomingInventoryProcessed = false;
/*      */   private transient BigDecimal _quantityToAllocate;
/* 4138 */   private transient List<IChargeAccountInvoice> _chargeAccountInvoices = new ArrayList<>();
/*      */   private transient boolean _disallowDeal;
/*      */   private transient boolean _isAttachedItem;
/*      */   
/*      */   public BigDecimal getQuantityAvailableForReturn() {
/* 4143 */     return getQuantity().subtract(NumberUtils.nonNull(getReturnedQuantity()));
/*      */   }
/*      */   
/*      */   public boolean getPriceChanged() {
/* 4147 */     return this._priceChanged;
/*      */   }
/*      */   
/*      */   public IInventoryAccountModifier getInventoryAccountModifier() {
/* 4151 */     return (IInventoryAccountModifier)getCustomerAccountModifier();
/*      */   }
/*      */   
/*      */   public boolean getDiscounted() {
/* 4155 */     return this._discounted;
/*      */   }
/*      */   
/*      */   public List<IRetailPriceModifier> getRetailPriceModifierByTypeCode(String argCode) {
/* 4159 */     return this._retailPriceModifierTypeIdx.get(argCode);
/*      */   }
/*      */   
/*      */   public void setPreDealAmount(BigDecimal argAmount) {
/* 4163 */     BigDecimal convertedAmount = getRelativeAmount(argAmount);
/* 4164 */     this._preDealAmount = convertedAmount;
/*      */   }
/*      */   
/*      */   public BigDecimal getPreDealAmount() {
/* 4168 */     return getLocalizedAmount(this._preDealAmount);
/*      */   }
/*      */   
/*      */   public void setOriginalTaxRate(BigDecimal argTaxRate) {
/* 4172 */     this._originalTaxRate = argTaxRate;
/*      */   }
/*      */   
/*      */   public BigDecimal getOriginalTaxRate() {
/* 4176 */     return this._originalTaxRate;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOriginalBaseUnitPrice(BigDecimal argAmount) {
/* 4181 */     BigDecimal convertedAmount = getRelativeAmount(argAmount);
/* 4182 */     this._originalBaseUnitPrice = convertedAmount;
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getOriginalBaseUnitPrice() {
/* 4187 */     return getLocalizedAmount(this._originalBaseUnitPrice);
/*      */   }
/*      */   
/*      */   public String getCompositeSaleReturnLineItemTypeCode() {
/* 4191 */     if (getReturn()) {
/* 4192 */       SaleItemType type = SaleItemType.forName("RETURN");
/* 4193 */       String transKey = type.getTranslationKey();
/* 4194 */       return FormattableFactory.getInstance().getTranslatable(transKey)
/* 4195 */         .toString(OutputContextType.VIEW);
/*      */     } 
/*      */     
/* 4198 */     return getSaleReturnLineItemTypeTranslated();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getSaleReturnLineItemTypeTranslated() {
/* 4203 */     SaleItemType type = SaleItemType.forName(getSaleReturnLineItemTypeCode());
/* 4204 */     String transKey = type.getTranslationKey();
/*      */     
/* 4206 */     return FormattableFactory.getInstance().getTranslatable(transKey).toString(OutputContextType.VIEW);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<String> getRemovedDealIds() {
/* 4211 */     if (this._removedDealIds == null) {
/* 4212 */       this._removedDealIds = new ArrayList<>();
/*      */     }
/* 4214 */     return this._removedDealIds;
/*      */   }
/*      */   
/*      */   public void setRemovedDealIds(List<String> argList) {
/* 4218 */     this._removedDealIds = argList;
/*      */   }
/*      */   
/*      */   public void addRemovedDealId(String argId) {
/* 4222 */     getRemovedDealIds().add(argId);
/*      */   }
/*      */   
/*      */   public boolean getSelectedForPrint() {
/* 4226 */     if (this._selectedForPrint == null)
/*      */     {
/*      */       
/* 4229 */       this._selectedForPrint = Boolean.valueOf((getGiftReceiptCount() < 0));
/*      */     }
/* 4231 */     return this._selectedForPrint.booleanValue();
/*      */   }
/*      */   
/*      */   public void setSelectedForPrint(boolean argSelectedForPrint) {
/* 4235 */     this._selectedForPrint = Boolean.valueOf(argSelectedForPrint);
/*      */     
/* 4237 */     if (argSelectedForPrint) {
/*      */ 
/*      */ 
/*      */       
/* 4241 */       if (getGiftReceiptCount() == 0) {
/* 4242 */         setGiftReceiptCount(-1);
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 4247 */     else if (getGiftReceiptCount() < 0) {
/* 4248 */       setGiftReceiptCount(0);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getExtendedPriceConsiderReturnQty() {
/* 4254 */     BigDecimal extPrice = BigDecimal.ZERO;
/*      */     
/* 4256 */     if (!getForceZeroExtendedAmt() && getQuantityAvailableForReturn() != null && 
/* 4257 */       getUnitPriceImpl() != null) {
/* 4258 */       extPrice = getQuantityAvailableForReturn().multiply(getUnitPriceImpl());
/*      */       
/* 4260 */       extPrice = NumberUtils.roundExtendedAmount(extPrice, LocaleInfo.currencyFractionDigits());
/*      */     } 
/*      */     
/* 4263 */     return getLocalizedAmount(extPrice);
/*      */   }
/*      */   
/*      */   public String getItemDescription() {
/* 4267 */     if (!StringUtils.isEmpty(getEnteredDescription())) {
/* 4268 */       return getEnteredDescription();
/*      */     }
/*      */     
/* 4271 */     return (getItem() != null) ? getItem().getDescription() : "";
/*      */   }
/*      */ 
/*      */   
/*      */   public void setExpirationDate(Date argDate) {
/* 4276 */     this._expirationDate = argDate;
/*      */   }
/*      */   
/*      */   public Date getExpirationDate() {
/* 4280 */     return this._expirationDate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuantity(BigDecimal argQty) {
/* 4287 */     setQuantityImpl(argQty);
/* 4288 */     updateExtendedPrice();
/* 4289 */     updateBaseExtendedPrice();
/*      */   }
/*      */   
/*      */   private void updateExtendedPrice() {
/* 4293 */     BigDecimal unitPrice = getUnitPriceImpl();
/* 4294 */     BigDecimal qty = getQuantity();
/*      */     
/* 4296 */     if (unitPrice != null && qty != null) {
/*      */       
/* 4298 */       BigDecimal p = unitPrice.multiply(qty);
/*      */ 
/*      */       
/* 4301 */       p = NumberUtils.roundExtendedAmount(p, LocaleInfo.currencyFractionDigits());
/*      */       
/* 4303 */       setExtendedAmountImpl(getForceZeroExtendedAmt() ? BigDecimal.ZERO : p);
/*      */       
/* 4305 */       if (getCustomerAccountModifier() != null) {
/* 4306 */         getCustomerAccountModifier().setItemAccountExtendedPrice(p);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void updateBaseExtendedPrice() {
/* 4313 */     if (getBaseUnitPriceImpl() != null && getQuantity() != null) {
/*      */       
/* 4315 */       BigDecimal p = getBaseUnitPriceImpl().multiply(getQuantity());
/*      */ 
/*      */       
/* 4318 */       p = p.setScale(LocaleInfo.currencyFractionDigits(), RoundingMode.HALF_UP);
/*      */ 
/*      */       
/* 4321 */       if (getForceZeroExtendedAmt()) {
/* 4322 */         setBaseExtendedPriceImpl(BigDecimal.ZERO);
/* 4323 */         if (getCustomerAccountModifier() != null) {
/* 4324 */           getCustomerAccountModifier().setItemAccountExtendedPrice(p);
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/* 4329 */         setBaseExtendedPriceImpl(p);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getLineDescription() {
/* 4335 */     IItem item = getItem();
/* 4336 */     return (item != null) ? item.getDescription() : null;
/*      */   }
/*      */   
/*      */   public String getItemDimensionValue(int argIndex) {
/* 4340 */     IItem item = getItem();
/* 4341 */     return (item != null) ? item.getItemDimensionValue(argIndex) : null;
/*      */   }
/*      */   
/*      */   public BigDecimal getReturnedQuantity() {
/* 4345 */     BigDecimal retQty = this._returnedQuantity;
/*      */     
/* 4347 */     if (retQty == null && 
/* 4348 */       getBaseReturnedQuantity() != null) {
/* 4349 */       retQty = getBaseReturnedQuantity().getReturnedCount();
/*      */     }
/*      */     
/* 4352 */     return retQty;
/*      */   }
/*      */   
/*      */   public void setReturnedQuantity(BigDecimal argReturnedQuantity) {
/* 4356 */     this._returnedQuantity = argReturnedQuantity;
/*      */   }
/*      */   
/*      */   public BigDecimal getPrediscountAmount() {
/* 4360 */     return getLocalizedAmount(this._preDiscountAmount);
/*      */   }
/*      */   
/*      */   public void setPrediscountAmount(BigDecimal argAmount) {
/* 4364 */     BigDecimal convertedAmount = getRelativeAmount(argAmount);
/* 4365 */     this._preDiscountAmount = convertedAmount;
/*      */   }
/*      */   
/*      */   public PosTransactionId getOriginalTransactionObjectId() {
/* 4369 */     if (getOriginalBusinessDate() == null || 
/* 4370 */       getOriginalRetailLocationId() == 0L || 
/* 4371 */       getOriginalTransactionSequence() == 0L || 
/* 4372 */       getOriginalWorkstationId() == 0L) {
/* 4373 */       return null;
/*      */     }
/*      */     
/* 4376 */     PosTransactionId id = new PosTransactionId();
/* 4377 */     id.setBusinessDate(getOriginalBusinessDate());
/* 4378 */     id.setRetailLocationId(new Long(getOriginalRetailLocationId()));
/* 4379 */     id.setTransactionSequence(new Long(getOriginalTransactionSequence()));
/* 4380 */     id.setWorkstationId(new Long(getOriginalWorkstationId()));
/* 4381 */     return id;
/*      */   }
/*      */ 
/*      */   
/*      */   private void setCalculatedPriceUpdated(boolean calcPriceUpdated) {
/* 4386 */     this._calculatedPriceUpdated = calcPriceUpdated;
/*      */   }
/*      */ 
/*      */   
/*      */   public IInventoryDocumentLineItem getInventoryDocumentLineItem() {
/* 4391 */     List<IInventoryDocumentLineItem> lines = getInventoryDocumentLineItems();
/* 4392 */     return (lines != null && !lines.isEmpty()) ? lines.get(0) : null;
/*      */   }
/*      */   
/*      */   public void setInventoryDocumentLineItem(IInventoryDocumentLineItem argLineItem) {
/* 4396 */     if (argLineItem == null) {
/* 4397 */       setInventoryDocumentLineItems((List<IInventoryDocumentLineItem>)null);
/*      */     } else {
/*      */       
/* 4400 */       List<IInventoryDocumentLineItem> lines = new ArrayList<>(1);
/*      */       
/* 4402 */       lines.add(argLineItem);
/* 4403 */       setInventoryDocumentLineItems(lines);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSaleTaxModifier(ISaleTaxModifier taxModifier) {
/* 4411 */     synchronized (this) {
/* 4412 */       taxModifier.setSaleTaxModifierSequence(getTaxModifiers().size() + 1);
/* 4413 */       addSaleTaxModifierImpl(taxModifier);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCustomerAccountModifier(ICustomerItemAccountModifier custModifier) {
/* 4422 */     if (custModifier == null) {
/* 4423 */       this._customerAccountModifier = null;
/*      */     } else {
/*      */       
/* 4426 */       synchronized (this) {
/* 4427 */         custModifier.setIdValuesByObject((RetailTransactionLineItemId)getObjectId());
/* 4428 */         setCustomerAccountModifierImpl(custModifier);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addRetailPriceModifier(IRetailPriceModifier priceModifier) {
/* 4437 */     synchronized (this) {
/* 4438 */       priceModifier.setRetailPriceModifierSequenceNbr(getRetailPriceModifiers().size() + 1);
/* 4439 */       addRetailPriceModifierImpl(priceModifier);
/*      */     } 
/* 4441 */     this._retailPriceModifierTypeIdx.put(priceModifier.getRetailPriceModifierReasonCode(), priceModifier);
/* 4442 */     setModifierVariables(priceModifier);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetailPriceModifiers(List<IRetailPriceModifier> argRetailPriceModifiers) {
/* 4449 */     setRetailPriceModifiersImpl(argRetailPriceModifiers);
/*      */     
/* 4451 */     this
/*      */       
/* 4453 */       ._retailPriceModifierTypeIdx = Multimaps.synchronizedListMultimap(
/* 4454 */         (ListMultimap)LinkedListMultimap.create());
/*      */     
/* 4456 */     for (IRetailPriceModifier priceModifier : argRetailPriceModifiers) {
/* 4457 */       this._retailPriceModifierTypeIdx.put(priceModifier.getRetailPriceModifierReasonCode(), priceModifier);
/*      */       
/* 4459 */       if (!priceModifier.getVoid()) {
/* 4460 */         setModifierVariables(priceModifier);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setModifierVariables(IRetailPriceModifier priceModifier) {
/* 4466 */     RetailPriceModifierReasonCode type = RetailPriceModifierReasonCode.forName(priceModifier
/*      */         
/* 4468 */         .getRetailPriceModifierReasonCode());
/* 4469 */     if (type == RetailPriceModifierReasonCode.PRICE_OVERRIDE) {
/* 4470 */       this._priceChanged = true;
/*      */     }
/* 4472 */     else if (type == RetailPriceModifierReasonCode.LINE_ITEM_DISCOUNT || type == RetailPriceModifierReasonCode.TRANSACTION_DISCOUNT) {
/*      */       
/* 4474 */       this._discounted = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ISaleReturnLineItem clone() {
/* 4480 */     SaleReturnLineItemModel clonedSaleReturnLineItem = new SaleReturnLineItemModel();
/* 4481 */     clonedSaleReturnLineItem.setOrganizationId(getOrganizationId());
/* 4482 */     clonedSaleReturnLineItem.setRetailLocationId(getRetailLocationId());
/* 4483 */     clonedSaleReturnLineItem.setWorkstationId(getWorkstationId());
/* 4484 */     clonedSaleReturnLineItem.setBusinessDate(getBusinessDate());
/* 4485 */     clonedSaleReturnLineItem.setTransactionSequence(getTransactionSequence());
/* 4486 */     clonedSaleReturnLineItem.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 4487 */     clonedSaleReturnLineItem.setItem(getItem());
/* 4488 */     clonedSaleReturnLineItem.setQuantity(getQuantity());
/* 4489 */     clonedSaleReturnLineItem.setBaseUnitPriceImpl(getBaseUnitPriceImpl());
/* 4490 */     clonedSaleReturnLineItem.setExtendedAmountImpl(getExtendedAmountImpl());
/* 4491 */     clonedSaleReturnLineItem.setSerialNumber(getSerialNumber());
/* 4492 */     clonedSaleReturnLineItem.setTaxModifiers(getTaxModifiers());
/* 4493 */     clonedSaleReturnLineItem.setRetailPriceModifiers(getRetailPriceModifiers());
/* 4494 */     clonedSaleReturnLineItem.setReturnReasonCode(getReturnReasonCode());
/* 4495 */     clonedSaleReturnLineItem.setReturn(getReturn());
/* 4496 */     clonedSaleReturnLineItem.setReturnTypeCode(getReturnTypeCode());
/* 4497 */     clonedSaleReturnLineItem.setCustomerAccountModifier(getCustomerAccountModifier());
/* 4498 */     clonedSaleReturnLineItem.setLineItemAssociationModifiers(getLineItemAssociationModifiers());
/* 4499 */     return clonedSaleReturnLineItem;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBaseUnitPrice() {
/* 4506 */     return getLocalizedAmount(getBaseUnitPriceImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseUnitPrice(BigDecimal argBaseUnitPrice) {
/* 4513 */     BigDecimal convertedPrice = getRelativeAmount(argBaseUnitPrice);
/* 4514 */     setBaseUnitPriceImpl(convertedPrice);
/* 4515 */     updateBaseExtendedPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBaseExtendedPrice() {
/* 4522 */     return getLocalizedAmount(getBaseExtendedPriceImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseExtendedPrice(BigDecimal argBaseExtendedPrice) {
/* 4529 */     BigDecimal convertedPrice = getRelativeAmount(argBaseExtendedPrice);
/* 4530 */     setBaseExtendedPriceImpl(convertedPrice);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getExtendedAmount() {
/* 4537 */     return getLocalizedAmount(getExtendedAmountImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExtendedAmount(BigDecimal argExtendedAmount) {
/* 4544 */     BigDecimal convertedAmount = getRelativeAmount(argExtendedAmount);
/* 4545 */     setExtendedAmountImpl(convertedAmount);
/* 4546 */     setCalculatedPriceUpdated(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getFoodStampsAppliedAmount() {
/* 4553 */     return getLocalizedAmount(getFoodStampsAppliedAmountImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFoodStampsAppliedAmount(BigDecimal argAmount) {
/* 4560 */     BigDecimal convertedAmount = getRelativeAmount(argAmount);
/* 4561 */     setFoodStampsAppliedAmountImpl(convertedAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getGrossAmount() {
/* 4568 */     return getLocalizedAmount(getGrossAmountImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGrossAmount(BigDecimal argGrossAmount) {
/* 4575 */     BigDecimal convertedAmount = getRelativeAmount(argGrossAmount);
/* 4576 */     setGrossAmountImpl(convertedAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getRegularBasePrice() {
/* 4583 */     return getLocalizedAmount(getRegularBasePriceImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRegularBasePrice(BigDecimal argRegularBasePrice) {
/* 4590 */     BigDecimal convertedAmount = getRelativeAmount(argRegularBasePrice);
/* 4591 */     setRegularBasePriceImpl(convertedAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getRptBaseUnitPrice() {
/* 4598 */     return getLocalizedAmount(getRptBaseUnitPriceImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRptBaseUnitPrice(BigDecimal argRptBaseUnitPrice) {
/* 4605 */     BigDecimal convertedAmount = getRelativeAmount(argRptBaseUnitPrice);
/* 4606 */     setRptBaseUnitPriceImpl(convertedAmount);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnitPrice() {
/* 4613 */     return getLocalizedAmount(getUnitPriceImpl());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitPrice(BigDecimal argPrice) {
/* 4620 */     BigDecimal convertedPrice = getRelativeAmount(argPrice);
/* 4621 */     setUnitPriceImpl(argPrice);
/* 4622 */     updateExtendedPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCommissionModifier(ICommissionModifier commissionModifier) {
/* 4632 */     synchronized (this) {
/* 4633 */       commissionModifier.setCommissionModifierSequenceNbr(getCommissionModifiers().size() + 1);
/*      */       
/* 4635 */       addCommissionModifierImpl(commissionModifier);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLineItemAssociationModifier(ILineItemAssociationModifier modifier) {
/* 4646 */     synchronized (this) {
/* 4647 */       modifier.setLineItemAssociationModifierSequence(getLineItemAssociationModifiers().size() + 1);
/* 4648 */       addLineItemAssociationModifierImpl(modifier);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addDimensionModifier(IDimensionModifier modifier) {
/* 4656 */     synchronized (this) {
/* 4657 */       addDimensionModifierImpl(modifier);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean getReturnedWithGiftReceipt() {
/* 4662 */     return this._returnedWithGiftReceipt;
/*      */   }
/*      */   
/*      */   public void setReturnedWithGiftReceipt(boolean argFlag) {
/* 4666 */     this._returnedWithGiftReceipt = argFlag;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addRetailTransactionLineItemNotes(IRetailTransactionLineItemNotes argRetailTransactionLineItemNotes) {
/* 4673 */     synchronized (this) {
/* 4674 */       argRetailTransactionLineItemNotes.setNoteSeq((getNoteSeq().size() + 1));
/* 4675 */       addRetailTransactionLineItemNotesImpl(argRetailTransactionLineItemNotes);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addRetailInventoryLocationModifier(IRetailInventoryLocationModifier argModifier) {
/* 4683 */     synchronized (this) {
/* 4684 */       argModifier.setModifierSequence((getRetailInventoryLocationModifiers().size() + 1));
/* 4685 */       addRetailInventoryLocationModifierImpl(argModifier);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers() {
/* 4692 */     return (List)getRetailInventoryLocationModifiers();
/*      */   }
/*      */   
/*      */   public List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers() {
/* 4696 */     if (this._retailInventoryLocationModifiers == null || this._retailInventoryLocationModifiers.getAddedItems() == null) {
/* 4697 */       return new ArrayList<>();
/*      */     }
/*      */     
/* 4700 */     return this._retailInventoryLocationModifiers.getAddedItems();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 4706 */     if (argModifier instanceof IRetailInventoryLocationModifier) {
/* 4707 */       removeRetailInventoryLocationModifier((IRetailInventoryLocationModifier)argModifier);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addInventoryLocationModifier(IInventoryLocationModifier argModifier) {
/* 4716 */     if (argModifier instanceof IRetailInventoryLocationModifier) {
/* 4717 */       addRetailInventoryLocationModifier((IRetailInventoryLocationModifier)argModifier);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLineItemSequence() {
/* 4724 */     return getRetailTransactionLineItemSequence();
/*      */   }
/*      */   
/*      */   public BigDecimal getQuantityToAllocate() {
/* 4728 */     return this._quantityToAllocate;
/*      */   }
/*      */   
/*      */   public void setQuantityToAllocate(BigDecimal argQuantity) {
/* 4732 */     this._quantityToAllocate = argQuantity;
/*      */   }
/*      */   
/*      */   public boolean isIncomingInventoryProcessed() {
/* 4736 */     return this._incomingInventoryProcessed;
/*      */   }
/*      */   
/*      */   public void setIncomingInventoryProcessed(boolean argProcessed) {
/* 4740 */     this._incomingInventoryProcessed = argProcessed;
/*      */   }
/*      */   
/*      */   public List<IChargeAccountInvoice> getChargeAccountInvoices() {
/* 4744 */     if (this._chargeAccountInvoices == null) {
/* 4745 */       this._chargeAccountInvoices = new ArrayList<>();
/*      */     }
/* 4747 */     return this._chargeAccountInvoices;
/*      */   }
/*      */   
/*      */   public void setChargeAccountInvoices(List<IChargeAccountInvoice> argList) {
/* 4751 */     this._chargeAccountInvoices = argList;
/*      */   }
/*      */   
/*      */   public IReasonCode getReasonCodeObject() {
/* 4755 */     IReasonCode reasonCodeObj = null;
/*      */     
/* 4757 */     if (!StringUtils.isEmpty(getReturnReasonCode())) {
/* 4758 */       ReasonCodeId id = new ReasonCodeId();
/* 4759 */       id.setReasonTypeCode("RETURN");
/* 4760 */       id.setReasonCode(getReturnReasonCode());
/*      */       try {
/* 4762 */         reasonCodeObj = (IReasonCode)DataFactory.getObjectById((IObjectId)id);
/*      */       }
/* 4764 */       catch (ObjectNotFoundException objectNotFoundException) {}
/*      */     } 
/*      */ 
/*      */     
/* 4768 */     return reasonCodeObj;
/*      */   }
/*      */   
/*      */   public void setDisallowDealFlag(boolean argBool) {
/* 4772 */     this._disallowDeal = argBool;
/*      */   }
/*      */   
/*      */   public boolean getDisallowDealFlag() {
/* 4776 */     boolean retVal = this._disallowDeal;
/* 4777 */     if (!retVal && getItem() != null) {
/* 4778 */       retVal = getItem().getOptions().getDisallowDeals();
/*      */     }
/* 4780 */     return retVal;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IRetailPriceModifier> getRetailPriceModifiersSorted() {
/* 4788 */     List<IRetailPriceModifier> mods = getRetailPriceModifiers();
/*      */     
/* 4790 */     Collections.sort(mods, new Comparator<IRetailPriceModifier>()
/*      */         {
/*      */           public int compare(IRetailPriceModifier argO1, IRetailPriceModifier argO2) {
/* 4793 */             return StringUtils.nonNull(argO1.getDisplayDescription()).compareTo(
/* 4794 */                 StringUtils.nonNull(argO2.getDisplayDescription()));
/*      */           }
/*      */         });
/* 4797 */     return mods;
/*      */   }
/*      */   
/*      */   public boolean isAttachedItem() {
/* 4801 */     return this._isAttachedItem;
/*      */   }
/*      */   
/*      */   public void setAttachedItem(boolean argIsAttachedItem) {
/* 4805 */     this._isAttachedItem = argIsAttachedItem;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleReturnLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */