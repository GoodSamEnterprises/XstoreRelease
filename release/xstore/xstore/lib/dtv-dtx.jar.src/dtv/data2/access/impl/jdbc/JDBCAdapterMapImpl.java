/*      */ package dtv.data2.access.impl.jdbc;
/*      */ import dtv.data2.access.AbstractInstanceGenerator;
/*      */ import dtv.xst.dao.cat.impl.CustomerLoyaltyAccountPropertiesRelationshipDBA;
/*      */ import dtv.xst.dao.cfg.impl.XadminUserDBA;
/*      */ import dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailPropertiesRelationshipDBA;
/*      */ import dtv.xst.dao.sec.impl.AccessControlListAclEntriesRelationshipDBA;
/*      */ import dtv.xst.dao.trl.impl.CorrectionModifierDBA;
/*      */ import dtv.xst.dao.tsn.impl.TenderDenominationCountPropertiesRelationshipDBA;
/*      */ import dtv.xst.dao.tsn.impl.TenderRepositoryStatusPropertiesRelationshipDBA;
/*      */ import dtv.xst.dao.tsn.impl.TillControlTransactionDBA;
/*      */ import dtv.xst.dao.xom.impl.BalanceModifierPropertiesRelationshipDBA;
/*      */ import dtv.xst.dao.xom.impl.SourceModifierPropertiesRelationshipDBA;
/*      */ 
/*      */ public class JDBCAdapterMapImpl extends JDBCAdapterMap {
/*   15 */   private final Map<String, AbstractInstanceGenerator<? extends IJDBCTableAdapter>> adapterMap = new HashMap<>();
/*   16 */   private final Map<String, AbstractInstanceGenerator<? extends IJDBCRelationshipAdapter>> relationshipAdapterMap = new HashMap<>();
/*      */ 
/*      */ 
/*      */   
/*      */   public JDBCAdapterMapImpl() {
/*   21 */     AbstractInstanceGenerator<IJDBCTableAdapter> generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   23 */           return (Class)SaleReturnLineItemDBA.class;
/*      */         }
/*      */       };
/*   26 */     addAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO", generator);
/*   27 */     addAdapter("dtv.xst.dao.trl.ISaleReturnLineItem", generator);
/*   28 */     addAdapter("SaleReturnLineItem", generator);
/*   29 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   31 */           return (Class)RetailTransactionExchangeLineItemDBA.class;
/*      */         }
/*      */       };
/*   34 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionExchangeLineItemDAO", generator);
/*   35 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionExchangeLineItem", generator);
/*   36 */     addAdapter("RetailTransactionExchangeLineItem", generator);
/*   37 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   39 */           return (Class)SaleTaxModifierDBA.class;
/*      */         }
/*      */       };
/*   42 */     addAdapter("dtv.xst.dao.trl.SaleTaxModifierId", generator);
/*   43 */     addAdapter("dtv.xst.dao.trl.impl.SaleTaxModifierDAO", generator);
/*   44 */     addAdapter("dtv.xst.dao.trl.ISaleTaxModifier", generator);
/*   45 */     addAdapter("SaleTaxModifier", generator);
/*   46 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   48 */           return (Class)TaxLineItemDBA.class;
/*      */         }
/*      */       };
/*   51 */     addAdapter("dtv.xst.dao.trl.impl.TaxLineItemDAO", generator);
/*   52 */     addAdapter("dtv.xst.dao.trl.ITaxLineItem", generator);
/*   53 */     addAdapter("TaxLineItem", generator);
/*   54 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   56 */           return (Class)RetailTransactionFlightInfoDBA.class;
/*      */         }
/*      */       };
/*   59 */     addAdapter("dtv.xst.dao.trl.RetailTransactionFlightInfoId", generator);
/*   60 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoDAO", generator);
/*   61 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionFlightInfo", generator);
/*   62 */     addAdapter("RetailTransactionFlightInfo", generator);
/*   63 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   65 */           return (Class)KitComponentModifierDBA.class;
/*      */         }
/*      */       };
/*   68 */     addAdapter("dtv.xst.dao.trl.KitComponentModifierId", generator);
/*   69 */     addAdapter("dtv.xst.dao.trl.impl.KitComponentModifierDAO", generator);
/*   70 */     addAdapter("dtv.xst.dao.trl.IKitComponentModifier", generator);
/*   71 */     addAdapter("KitComponentModifier", generator);
/*   72 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   74 */           return (Class)WarrantyLineItemDBA.class;
/*      */         }
/*      */       };
/*   77 */     addAdapter("dtv.xst.dao.trl.impl.WarrantyLineItemDAO", generator);
/*   78 */     addAdapter("dtv.xst.dao.trl.IWarrantyLineItem", generator);
/*   79 */     addAdapter("WarrantyLineItem", generator);
/*   80 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   82 */           return (Class)WarrantyModifierDBA.class;
/*      */         }
/*      */       };
/*   85 */     addAdapter("dtv.xst.dao.trl.WarrantyModifierId", generator);
/*   86 */     addAdapter("dtv.xst.dao.trl.impl.WarrantyModifierDAO", generator);
/*   87 */     addAdapter("dtv.xst.dao.trl.IWarrantyModifier", generator);
/*   88 */     addAdapter("WarrantyModifier", generator);
/*   89 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   91 */           return (Class)AccountReceivableSaleLineItemDBA.class;
/*      */         }
/*      */       };
/*   94 */     addAdapter("dtv.xst.dao.trl.impl.AccountReceivableSaleLineItemDAO", generator);
/*   95 */     addAdapter("dtv.xst.dao.trl.IAccountReceivableSaleLineItem", generator);
/*   96 */     addAdapter("AccountReceivableSaleLineItem", generator);
/*   97 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*   99 */           return (Class)CommissionModifierDBA.class;
/*      */         }
/*      */       };
/*  102 */     addAdapter("dtv.xst.dao.trl.CommissionModifierId", generator);
/*  103 */     addAdapter("dtv.xst.dao.trl.impl.CommissionModifierDAO", generator);
/*  104 */     addAdapter("dtv.xst.dao.trl.ICommissionModifier", generator);
/*  105 */     addAdapter("CommissionModifier", generator);
/*  106 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  108 */           return (Class)CorrectionModifierDBA.class;
/*      */         }
/*      */       };
/*  111 */     addAdapter("dtv.xst.dao.trl.CorrectionModifierId", generator);
/*  112 */     addAdapter("dtv.xst.dao.trl.impl.CorrectionModifierDAO", generator);
/*  113 */     addAdapter("dtv.xst.dao.trl.ICorrectionModifier", generator);
/*  114 */     addAdapter("CorrectionModifier", generator);
/*  115 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  117 */           return (Class)CouponLineItemDBA.class;
/*      */         }
/*      */       };
/*  120 */     addAdapter("dtv.xst.dao.trl.impl.CouponLineItemDAO", generator);
/*  121 */     addAdapter("dtv.xst.dao.trl.ICouponLineItem", generator);
/*  122 */     addAdapter("CouponLineItem", generator);
/*  123 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  125 */           return (Class)CustomerItemAccountModifierDBA.class;
/*      */         }
/*      */       };
/*  128 */     addAdapter("dtv.xst.dao.trl.CustomerItemAccountModifierId", generator);
/*  129 */     addAdapter("dtv.xst.dao.trl.impl.CustomerItemAccountModifierDAO", generator);
/*  130 */     addAdapter("dtv.xst.dao.trl.ICustomerItemAccountModifier", generator);
/*  131 */     addAdapter("CustomerItemAccountModifier", generator);
/*  132 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  134 */           return (Class)DimensionModifierDBA.class;
/*      */         }
/*      */       };
/*  137 */     addAdapter("dtv.xst.dao.trl.DimensionModifierId", generator);
/*  138 */     addAdapter("dtv.xst.dao.trl.impl.DimensionModifierDAO", generator);
/*  139 */     addAdapter("dtv.xst.dao.trl.IDimensionModifier", generator);
/*  140 */     addAdapter("DimensionModifier", generator);
/*  141 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  143 */           return (Class)DiscountLineItemDBA.class;
/*      */         }
/*      */       };
/*  146 */     addAdapter("dtv.xst.dao.trl.impl.DiscountLineItemDAO", generator);
/*  147 */     addAdapter("dtv.xst.dao.trl.IDiscountLineItem", generator);
/*  148 */     addAdapter("DiscountLineItem", generator);
/*  149 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  151 */           return (Class)EscrowTransactionDBA.class;
/*      */         }
/*      */       };
/*  154 */     addAdapter("dtv.xst.dao.trl.impl.EscrowTransactionDAO", generator);
/*  155 */     addAdapter("dtv.xst.dao.trl.IEscrowTransaction", generator);
/*  156 */     addAdapter("EscrowTransaction", generator);
/*  157 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  159 */           return (Class)InventoryDocumentModifierDBA.class;
/*      */         }
/*      */       };
/*  162 */     addAdapter("dtv.xst.dao.trl.InventoryDocumentModifierId", generator);
/*  163 */     addAdapter("dtv.xst.dao.trl.impl.InventoryDocumentModifierDAO", generator);
/*  164 */     addAdapter("dtv.xst.dao.trl.IInventoryDocumentModifier", generator);
/*  165 */     addAdapter("InventoryDocumentModifier", generator);
/*  166 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  168 */           return (Class)LineItemAssociationModifierDBA.class;
/*      */         }
/*      */       };
/*  171 */     addAdapter("dtv.xst.dao.trl.LineItemAssociationModifierId", generator);
/*  172 */     addAdapter("dtv.xst.dao.trl.impl.LineItemAssociationModifierDAO", generator);
/*  173 */     addAdapter("dtv.xst.dao.trl.ILineItemAssociationModifier", generator);
/*  174 */     addAdapter("LineItemAssociationModifier", generator);
/*  175 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  177 */           return (Class)LineItemAssociationTypeCodeDBA.class;
/*      */         }
/*      */       };
/*  180 */     addAdapter("dtv.xst.dao.trl.LineItemAssociationTypeCodeId", generator);
/*  181 */     addAdapter("dtv.xst.dao.trl.impl.LineItemAssociationTypeCodeDAO", generator);
/*  182 */     addAdapter("dtv.xst.dao.trl.ILineItemAssociationTypeCode", generator);
/*  183 */     addAdapter("LineItemAssociationTypeCode", generator);
/*  184 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  186 */           return (Class)RetailInventoryLocationModifierDBA.class;
/*      */         }
/*      */       };
/*  189 */     addAdapter("dtv.xst.dao.trl.RetailInventoryLocationModifierId", generator);
/*  190 */     addAdapter("dtv.xst.dao.trl.impl.RetailInventoryLocationModifierDAO", generator);
/*  191 */     addAdapter("dtv.xst.dao.trl.IRetailInventoryLocationModifier", generator);
/*  192 */     addAdapter("RetailInventoryLocationModifier", generator);
/*  193 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  195 */           return (Class)RetailPriceModifierDBA.class;
/*      */         }
/*      */       };
/*  198 */     addAdapter("dtv.xst.dao.trl.RetailPriceModifierId", generator);
/*  199 */     addAdapter("dtv.xst.dao.trl.impl.RetailPriceModifierDAO", generator);
/*  200 */     addAdapter("dtv.xst.dao.trl.IRetailPriceModifier", generator);
/*  201 */     addAdapter("RetailPriceModifier", generator);
/*  202 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  204 */           return (Class)RetailTransactionDBA.class;
/*      */         }
/*      */       };
/*  207 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionDAO", generator);
/*  208 */     addAdapter("dtv.xst.dao.trl.IRetailTransaction", generator);
/*  209 */     addAdapter("RetailTransaction", generator);
/*  210 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  212 */           return (Class)RetailTransactionDealLineItemDBA.class;
/*      */         }
/*      */       };
/*  215 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionDealLineItemDAO", generator);
/*  216 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionDealLineItem", generator);
/*  217 */     addAdapter("RetailTransactionDealLineItem", generator);
/*  218 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  220 */           return (Class)RetailTransactionLineItemDBA.class;
/*      */         }
/*      */       };
/*  223 */     addAdapter("dtv.xst.dao.trl.RetailTransactionLineItemId", generator);
/*  224 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO", generator);
/*  225 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionLineItem", generator);
/*  226 */     addAdapter("RetailTransactionLineItem", generator);
/*  227 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  229 */           return (Class)RetailTransactionLineItemNotesDBA.class;
/*      */         }
/*      */       };
/*  232 */     addAdapter("dtv.xst.dao.trl.RetailTransactionLineItemNotesId", generator);
/*  233 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemNotesDAO", generator);
/*  234 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionLineItemNotes", generator);
/*  235 */     addAdapter("RetailTransactionLineItemNotes", generator);
/*  236 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  238 */           return (Class)ReturnedItemCountDBA.class;
/*      */         }
/*      */       };
/*  241 */     addAdapter("dtv.xst.dao.trl.ReturnedItemCountId", generator);
/*  242 */     addAdapter("dtv.xst.dao.trl.impl.ReturnedItemCountDAO", generator);
/*  243 */     addAdapter("dtv.xst.dao.trl.IReturnedItemCount", generator);
/*  244 */     addAdapter("ReturnedItemCount", generator);
/*  245 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  247 */           return (Class)ReturnedItemJournalDBA.class;
/*      */         }
/*      */       };
/*  250 */     addAdapter("dtv.xst.dao.trl.ReturnedItemJournalId", generator);
/*  251 */     addAdapter("dtv.xst.dao.trl.impl.ReturnedItemJournalDAO", generator);
/*  252 */     addAdapter("dtv.xst.dao.trl.IReturnedItemJournal", generator);
/*  253 */     addAdapter("ReturnedItemJournal", generator);
/*  254 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  256 */           return (Class)VoucherDiscountLineItemDBA.class;
/*      */         }
/*      */       };
/*  259 */     addAdapter("dtv.xst.dao.trl.impl.VoucherDiscountLineItemDAO", generator);
/*  260 */     addAdapter("dtv.xst.dao.trl.IVoucherDiscountLineItem", generator);
/*  261 */     addAdapter("VoucherDiscountLineItem", generator);
/*  262 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  264 */           return (Class)VoucherSaleLineItemDBA.class;
/*      */         }
/*      */       };
/*  267 */     addAdapter("dtv.xst.dao.trl.impl.VoucherSaleLineItemDAO", generator);
/*  268 */     addAdapter("dtv.xst.dao.trl.IVoucherSaleLineItem", generator);
/*  269 */     addAdapter("VoucherSaleLineItem", generator);
/*  270 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  272 */           return (Class)KitComponentDBA.class;
/*      */         }
/*      */       };
/*  275 */     addAdapter("dtv.xst.dao.itm.KitComponentId", generator);
/*  276 */     addAdapter("dtv.xst.dao.itm.impl.KitComponentDAO", generator);
/*  277 */     addAdapter("dtv.xst.dao.itm.IKitComponent", generator);
/*  278 */     addAdapter("KitComponent", generator);
/*  279 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  281 */           return (Class)ItemOptionsDBA.class;
/*      */         }
/*      */       };
/*  284 */     addAdapter("dtv.xst.dao.itm.ItemOptionsId", generator);
/*  285 */     addAdapter("dtv.xst.dao.itm.impl.ItemOptionsDAO", generator);
/*  286 */     addAdapter("dtv.xst.dao.itm.IItemOptions", generator);
/*  287 */     addAdapter("ItemOptions", generator);
/*  288 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  290 */           return (Class)ItemRestrictionCalendarDBA.class;
/*      */         }
/*      */       };
/*  293 */     addAdapter("dtv.xst.dao.itm.ItemRestrictionCalendarId", generator);
/*  294 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictionCalendarDAO", generator);
/*  295 */     addAdapter("dtv.xst.dao.itm.IItemRestrictionCalendar", generator);
/*  296 */     addAdapter("ItemRestrictionCalendar", generator);
/*  297 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  299 */           return (Class)ItemRestrictionDBA.class;
/*      */         }
/*      */       };
/*  302 */     addAdapter("dtv.xst.dao.itm.ItemRestrictionId", generator);
/*  303 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictionDAO", generator);
/*  304 */     addAdapter("dtv.xst.dao.itm.IItemRestriction", generator);
/*  305 */     addAdapter("ItemRestriction", generator);
/*  306 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  308 */           return (Class)ItemRestrictionMappingDBA.class;
/*      */         }
/*      */       };
/*  311 */     addAdapter("dtv.xst.dao.itm.ItemRestrictionMappingId", generator);
/*  312 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictionMappingDAO", generator);
/*  313 */     addAdapter("dtv.xst.dao.itm.IItemRestrictionMapping", generator);
/*  314 */     addAdapter("ItemRestrictionMapping", generator);
/*  315 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  317 */           return (Class)AttachedItemsDBA.class;
/*      */         }
/*      */       };
/*  320 */     addAdapter("dtv.xst.dao.itm.AttachedItemsId", generator);
/*  321 */     addAdapter("dtv.xst.dao.itm.impl.AttachedItemsDAO", generator);
/*  322 */     addAdapter("dtv.xst.dao.itm.IAttachedItems", generator);
/*  323 */     addAdapter("AttachedItems", generator);
/*  324 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  326 */           return (Class)ItemDimensionTypeDBA.class;
/*      */         }
/*      */       };
/*  329 */     addAdapter("dtv.xst.dao.itm.ItemDimensionTypeId", generator);
/*  330 */     addAdapter("dtv.xst.dao.itm.impl.ItemDimensionTypeDAO", generator);
/*  331 */     addAdapter("dtv.xst.dao.itm.IItemDimensionType", generator);
/*  332 */     addAdapter("ItemDimensionType", generator);
/*  333 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  335 */           return (Class)ItemDimensionValueDBA.class;
/*      */         }
/*      */       };
/*  338 */     addAdapter("dtv.xst.dao.itm.ItemDimensionValueId", generator);
/*  339 */     addAdapter("dtv.xst.dao.itm.impl.ItemDimensionValueDAO", generator);
/*  340 */     addAdapter("dtv.xst.dao.itm.IItemDimensionValue", generator);
/*  341 */     addAdapter("ItemDimensionValue", generator);
/*  342 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  344 */           return (Class)ItemMessageDBA.class;
/*      */         }
/*      */       };
/*  347 */     addAdapter("dtv.xst.dao.itm.ItemMessageId", generator);
/*  348 */     addAdapter("dtv.xst.dao.itm.impl.ItemMessageDAO", generator);
/*  349 */     addAdapter("dtv.xst.dao.itm.IItemMessage", generator);
/*  350 */     addAdapter("ItemMessage", generator);
/*  351 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  353 */           return (Class)MerchandiseHierarchyDBA.class;
/*      */         }
/*      */       };
/*  356 */     addAdapter("dtv.xst.dao.itm.MerchandiseHierarchyId", generator);
/*  357 */     addAdapter("dtv.xst.dao.itm.impl.MerchandiseHierarchyDAO", generator);
/*  358 */     addAdapter("dtv.xst.dao.itm.IMerchandiseHierarchy", generator);
/*  359 */     addAdapter("MerchandiseHierarchy", generator);
/*  360 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  362 */           return (Class)QuickItemDBA.class;
/*      */         }
/*      */       };
/*  365 */     addAdapter("dtv.xst.dao.itm.QuickItemId", generator);
/*  366 */     addAdapter("dtv.xst.dao.itm.impl.QuickItemDAO", generator);
/*  367 */     addAdapter("dtv.xst.dao.itm.IQuickItem", generator);
/*  368 */     addAdapter("QuickItem", generator);
/*  369 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  371 */           return (Class)WarrantyDBA.class;
/*      */         }
/*      */       };
/*  374 */     addAdapter("dtv.xst.dao.itm.WarrantyId", generator);
/*  375 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyDAO", generator);
/*  376 */     addAdapter("dtv.xst.dao.itm.IWarranty", generator);
/*  377 */     addAdapter("Warranty", generator);
/*  378 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  380 */           return (Class)WarrantyJournalDBA.class;
/*      */         }
/*      */       };
/*  383 */     addAdapter("dtv.xst.dao.itm.WarrantyJournalId", generator);
/*  384 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyJournalDAO", generator);
/*  385 */     addAdapter("dtv.xst.dao.itm.IWarrantyJournal", generator);
/*  386 */     addAdapter("WarrantyJournal", generator);
/*  387 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  389 */           return (Class)SubstituteItemsDBA.class;
/*      */         }
/*      */       };
/*  392 */     addAdapter("dtv.xst.dao.itm.SubstituteItemsId", generator);
/*  393 */     addAdapter("dtv.xst.dao.itm.impl.SubstituteItemsDAO", generator);
/*  394 */     addAdapter("dtv.xst.dao.itm.ISubstituteItems", generator);
/*  395 */     addAdapter("SubstituteItems", generator);
/*  396 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  398 */           return (Class)ItemDBA.class;
/*      */         }
/*      */       };
/*  401 */     addAdapter("dtv.xst.dao.itm.ItemId", generator);
/*  402 */     addAdapter("dtv.xst.dao.itm.impl.ItemDAO", generator);
/*  403 */     addAdapter("dtv.xst.dao.itm.IItem", generator);
/*  404 */     addAdapter("Item", generator);
/*  405 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  407 */           return (Class)NonPhysicalItemDBA.class;
/*      */         }
/*      */       };
/*  410 */     addAdapter("dtv.xst.dao.itm.impl.NonPhysicalItemDAO", generator);
/*  411 */     addAdapter("dtv.xst.dao.itm.INonPhysicalItem", generator);
/*  412 */     addAdapter("NonPhysicalItem", generator);
/*  413 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  415 */           return (Class)VendorDBA.class;
/*      */         }
/*      */       };
/*  418 */     addAdapter("dtv.xst.dao.itm.VendorId", generator);
/*  419 */     addAdapter("dtv.xst.dao.itm.impl.VendorDAO", generator);
/*  420 */     addAdapter("dtv.xst.dao.itm.IVendor", generator);
/*  421 */     addAdapter("Vendor", generator);
/*  422 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  424 */           return (Class)ItemCrossReferenceDBA.class;
/*      */         }
/*      */       };
/*  427 */     addAdapter("dtv.xst.dao.itm.ItemCrossReferenceId", generator);
/*  428 */     addAdapter("dtv.xst.dao.itm.impl.ItemCrossReferenceDAO", generator);
/*  429 */     addAdapter("dtv.xst.dao.itm.IItemCrossReference", generator);
/*  430 */     addAdapter("ItemCrossReference", generator);
/*  431 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  433 */           return (Class)ItemDealPropertyDBA.class;
/*      */         }
/*      */       };
/*  436 */     addAdapter("dtv.xst.dao.itm.ItemDealPropertyId", generator);
/*  437 */     addAdapter("dtv.xst.dao.itm.impl.ItemDealPropertyDAO", generator);
/*  438 */     addAdapter("dtv.xst.dao.itm.IItemDealProperty", generator);
/*  439 */     addAdapter("ItemDealProperty", generator);
/*  440 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  442 */           return (Class)ItemMessageCrossReferenceDBA.class;
/*      */         }
/*      */       };
/*  445 */     addAdapter("dtv.xst.dao.itm.ItemMessageCrossReferenceId", generator);
/*  446 */     addAdapter("dtv.xst.dao.itm.impl.ItemMessageCrossReferenceDAO", generator);
/*  447 */     addAdapter("dtv.xst.dao.itm.IItemMessageCrossReference", generator);
/*  448 */     addAdapter("ItemMessageCrossReference", generator);
/*  449 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  451 */           return (Class)ItemMessageTypesDBA.class;
/*      */         }
/*      */       };
/*  454 */     addAdapter("dtv.xst.dao.itm.ItemMessageTypesId", generator);
/*  455 */     addAdapter("dtv.xst.dao.itm.impl.ItemMessageTypesDAO", generator);
/*  456 */     addAdapter("dtv.xst.dao.itm.IItemMessageTypes", generator);
/*  457 */     addAdapter("ItemMessageTypes", generator);
/*  458 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  460 */           return (Class)ItemPricesDBA.class;
/*      */         }
/*      */       };
/*  463 */     addAdapter("dtv.xst.dao.itm.ItemPricesId", generator);
/*  464 */     addAdapter("dtv.xst.dao.itm.impl.ItemPricesDAO", generator);
/*  465 */     addAdapter("dtv.xst.dao.itm.IItemPrices", generator);
/*  466 */     addAdapter("ItemPrices", generator);
/*  467 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  469 */           return (Class)ItemPromptPropertyDBA.class;
/*      */         }
/*      */       };
/*  472 */     addAdapter("dtv.xst.dao.itm.ItemPromptPropertyId", generator);
/*  473 */     addAdapter("dtv.xst.dao.itm.impl.ItemPromptPropertyDAO", generator);
/*  474 */     addAdapter("dtv.xst.dao.itm.IItemPromptProperty", generator);
/*  475 */     addAdapter("ItemPromptProperty", generator);
/*  476 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  478 */           return (Class)ItemRestrictGS1DBA.class;
/*      */         }
/*      */       };
/*  481 */     addAdapter("dtv.xst.dao.itm.ItemRestrictGS1Id", generator);
/*  482 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictGS1DAO", generator);
/*  483 */     addAdapter("dtv.xst.dao.itm.IItemRestrictGS1", generator);
/*  484 */     addAdapter("ItemRestrictGS1", generator);
/*  485 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  487 */           return (Class)RefundScheduleDBA.class;
/*      */         }
/*      */       };
/*  490 */     addAdapter("dtv.xst.dao.itm.RefundScheduleId", generator);
/*  491 */     addAdapter("dtv.xst.dao.itm.impl.RefundScheduleDAO", generator);
/*  492 */     addAdapter("dtv.xst.dao.itm.IRefundSchedule", generator);
/*  493 */     addAdapter("RefundSchedule", generator);
/*  494 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  496 */           return (Class)WarrantyItemDBA.class;
/*      */         }
/*      */       };
/*  499 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyItemDAO", generator);
/*  500 */     addAdapter("dtv.xst.dao.itm.IWarrantyItem", generator);
/*  501 */     addAdapter("WarrantyItem", generator);
/*  502 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  504 */           return (Class)WarrantyItemCrossReferenceDBA.class;
/*      */         }
/*      */       };
/*  507 */     addAdapter("dtv.xst.dao.itm.WarrantyItemCrossReferenceId", generator);
/*  508 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyItemCrossReferenceDAO", generator);
/*  509 */     addAdapter("dtv.xst.dao.itm.IWarrantyItemCrossReference", generator);
/*  510 */     addAdapter("WarrantyItemCrossReference", generator);
/*  511 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  513 */           return (Class)WarrantyItemPriceDBA.class;
/*      */         }
/*      */       };
/*  516 */     addAdapter("dtv.xst.dao.itm.WarrantyItemPriceId", generator);
/*  517 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyItemPriceDAO", generator);
/*  518 */     addAdapter("dtv.xst.dao.itm.IWarrantyItemPrice", generator);
/*  519 */     addAdapter("WarrantyItemPrice", generator);
/*  520 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  522 */           return (Class)ItemLabelBatchDBA.class;
/*      */         }
/*      */       };
/*  525 */     addAdapter("dtv.xst.dao.itm.ItemLabelBatchId", generator);
/*  526 */     addAdapter("dtv.xst.dao.itm.impl.ItemLabelBatchDAO", generator);
/*  527 */     addAdapter("dtv.xst.dao.itm.IItemLabelBatch", generator);
/*  528 */     addAdapter("ItemLabelBatch", generator);
/*  529 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  531 */           return (Class)ItemImageDBA.class;
/*      */         }
/*      */       };
/*  534 */     addAdapter("dtv.xst.dao.itm.ItemImageId", generator);
/*  535 */     addAdapter("dtv.xst.dao.itm.impl.ItemImageDAO", generator);
/*  536 */     addAdapter("dtv.xst.dao.itm.IItemImage", generator);
/*  537 */     addAdapter("ItemImage", generator);
/*  538 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  540 */           return (Class)ItemLabelPropertiesDBA.class;
/*      */         }
/*      */       };
/*  543 */     addAdapter("dtv.xst.dao.itm.ItemLabelPropertiesId", generator);
/*  544 */     addAdapter("dtv.xst.dao.itm.impl.ItemLabelPropertiesDAO", generator);
/*  545 */     addAdapter("dtv.xst.dao.itm.IItemLabelProperties", generator);
/*  546 */     addAdapter("ItemLabelProperties", generator);
/*  547 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  549 */           return (Class)MatrixSortOrderDBA.class;
/*      */         }
/*      */       };
/*  552 */     addAdapter("dtv.xst.dao.itm.MatrixSortOrderId", generator);
/*  553 */     addAdapter("dtv.xst.dao.itm.impl.MatrixSortOrderDAO", generator);
/*  554 */     addAdapter("dtv.xst.dao.itm.IMatrixSortOrder", generator);
/*  555 */     addAdapter("MatrixSortOrder", generator);
/*  556 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  558 */           return (Class)PosTransactionDBA.class;
/*      */         }
/*      */       };
/*  561 */     addAdapter("dtv.xst.dao.trn.PosTransactionId", generator);
/*  562 */     addAdapter("dtv.xst.dao.trn.impl.PosTransactionDAO", generator);
/*  563 */     addAdapter("dtv.xst.dao.trn.IPosTransaction", generator);
/*  564 */     addAdapter("PosTransaction", generator);
/*  565 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  567 */           return (Class)GiftRegistryTransactionDBA.class;
/*      */         }
/*      */       };
/*  570 */     addAdapter("dtv.xst.dao.trn.impl.GiftRegistryTransactionDAO", generator);
/*  571 */     addAdapter("dtv.xst.dao.trn.IGiftRegistryTransaction", generator);
/*  572 */     addAdapter("GiftRegistryTransaction", generator);
/*  573 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  575 */           return (Class)LineItemGenericStorageDBA.class;
/*      */         }
/*      */       };
/*  578 */     addAdapter("dtv.xst.dao.trn.LineItemGenericStorageId", generator);
/*  579 */     addAdapter("dtv.xst.dao.trn.impl.LineItemGenericStorageDAO", generator);
/*  580 */     addAdapter("dtv.xst.dao.trn.ILineItemGenericStorage", generator);
/*  581 */     addAdapter("LineItemGenericStorage", generator);
/*  582 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  584 */           return (Class)NoSaleTransactionDBA.class;
/*      */         }
/*      */       };
/*  587 */     addAdapter("dtv.xst.dao.trn.impl.NoSaleTransactionDAO", generator);
/*  588 */     addAdapter("dtv.xst.dao.trn.INoSaleTransaction", generator);
/*  589 */     addAdapter("NoSaleTransaction", generator);
/*  590 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  592 */           return (Class)PosLogDataDBA.class;
/*      */         }
/*      */       };
/*  595 */     addAdapter("dtv.xst.dao.trn.PosLogDataId", generator);
/*  596 */     addAdapter("dtv.xst.dao.trn.impl.PosLogDataDAO", generator);
/*  597 */     addAdapter("dtv.xst.dao.trn.IPosLogData", generator);
/*  598 */     addAdapter("PosLogData", generator);
/*  599 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  601 */           return (Class)PosTransactionLinkDBA.class;
/*      */         }
/*      */       };
/*  604 */     addAdapter("dtv.xst.dao.trn.PosTransactionLinkId", generator);
/*  605 */     addAdapter("dtv.xst.dao.trn.impl.PosTransactionLinkDAO", generator);
/*  606 */     addAdapter("dtv.xst.dao.trn.IPosTransactionLink", generator);
/*  607 */     addAdapter("PosTransactionLink", generator);
/*  608 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  610 */           return (Class)PostVoidTransactionDBA.class;
/*      */         }
/*      */       };
/*  613 */     addAdapter("dtv.xst.dao.trn.impl.PostVoidTransactionDAO", generator);
/*  614 */     addAdapter("dtv.xst.dao.trn.IPostVoidTransaction", generator);
/*  615 */     addAdapter("PostVoidTransaction", generator);
/*  616 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  618 */           return (Class)RainCheckDBA.class;
/*      */         }
/*      */       };
/*  621 */     addAdapter("dtv.xst.dao.trn.RainCheckId", generator);
/*  622 */     addAdapter("dtv.xst.dao.trn.impl.RainCheckDAO", generator);
/*  623 */     addAdapter("dtv.xst.dao.trn.IRainCheck", generator);
/*  624 */     addAdapter("RainCheck", generator);
/*  625 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  627 */           return (Class)RainCheckTransactionDBA.class;
/*      */         }
/*      */       };
/*  630 */     addAdapter("dtv.xst.dao.trn.impl.RainCheckTransactionDAO", generator);
/*  631 */     addAdapter("dtv.xst.dao.trn.IRainCheckTransaction", generator);
/*  632 */     addAdapter("RainCheckTransaction", generator);
/*  633 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  635 */           return (Class)ReceiptDataDBA.class;
/*      */         }
/*      */       };
/*  638 */     addAdapter("dtv.xst.dao.trn.ReceiptDataId", generator);
/*  639 */     addAdapter("dtv.xst.dao.trn.impl.ReceiptDataDAO", generator);
/*  640 */     addAdapter("dtv.xst.dao.trn.IReceiptData", generator);
/*  641 */     addAdapter("ReceiptData", generator);
/*  642 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  644 */           return (Class)ReceiptLookupDBA.class;
/*      */         }
/*      */       };
/*  647 */     addAdapter("dtv.xst.dao.trn.ReceiptLookupId", generator);
/*  648 */     addAdapter("dtv.xst.dao.trn.impl.ReceiptLookupDAO", generator);
/*  649 */     addAdapter("dtv.xst.dao.trn.IReceiptLookup", generator);
/*  650 */     addAdapter("ReceiptLookup", generator);
/*  651 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  653 */           return (Class)TransactionNotesDBA.class;
/*      */         }
/*      */       };
/*  656 */     addAdapter("dtv.xst.dao.trn.TransactionNotesId", generator);
/*  657 */     addAdapter("dtv.xst.dao.trn.impl.TransactionNotesDAO", generator);
/*  658 */     addAdapter("dtv.xst.dao.trn.ITransactionNotes", generator);
/*  659 */     addAdapter("TransactionNotes", generator);
/*  660 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  662 */           return (Class)TransactionVersionDBA.class;
/*      */         }
/*      */       };
/*  665 */     addAdapter("dtv.xst.dao.trn.TransactionVersionId", generator);
/*  666 */     addAdapter("dtv.xst.dao.trn.impl.TransactionVersionDAO", generator);
/*  667 */     addAdapter("dtv.xst.dao.trn.ITransactionVersion", generator);
/*  668 */     addAdapter("TransactionVersion", generator);
/*  669 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  671 */           return (Class)CreditDebitTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  674 */     addAdapter("dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemDAO", generator);
/*  675 */     addAdapter("dtv.xst.dao.ttr.ICreditDebitTenderLineItem", generator);
/*  676 */     addAdapter("CreditDebitTenderLineItem", generator);
/*  677 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  679 */           return (Class)SendCheckTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  682 */     addAdapter("dtv.xst.dao.ttr.impl.SendCheckTenderLineItemDAO", generator);
/*  683 */     addAdapter("dtv.xst.dao.ttr.ISendCheckTenderLineItem", generator);
/*  684 */     addAdapter("SendCheckTenderLineItem", generator);
/*  685 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  687 */           return (Class)AccountCreditTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  690 */     addAdapter("dtv.xst.dao.ttr.impl.AccountCreditTenderLineItemDAO", generator);
/*  691 */     addAdapter("dtv.xst.dao.ttr.IAccountCreditTenderLineItem", generator);
/*  692 */     addAdapter("AccountCreditTenderLineItem", generator);
/*  693 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  695 */           return (Class)AccountReceivableTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  698 */     addAdapter("dtv.xst.dao.ttr.impl.AccountReceivableTenderLineItemDAO", generator);
/*  699 */     addAdapter("dtv.xst.dao.ttr.IAccountReceivableTenderLineItem", generator);
/*  700 */     addAdapter("AccountReceivableTenderLineItem", generator);
/*  701 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  703 */           return (Class)CheckTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  706 */     addAdapter("dtv.xst.dao.ttr.impl.CheckTenderLineItemDAO", generator);
/*  707 */     addAdapter("dtv.xst.dao.ttr.ICheckTenderLineItem", generator);
/*  708 */     addAdapter("CheckTenderLineItem", generator);
/*  709 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  711 */           return (Class)CouponTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  714 */     addAdapter("dtv.xst.dao.ttr.impl.CouponTenderLineItemDAO", generator);
/*  715 */     addAdapter("dtv.xst.dao.ttr.ICouponTenderLineItem", generator);
/*  716 */     addAdapter("CouponTenderLineItem", generator);
/*  717 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  719 */           return (Class)IdentityVerificationDBA.class;
/*      */         }
/*      */       };
/*  722 */     addAdapter("dtv.xst.dao.ttr.IdentityVerificationId", generator);
/*  723 */     addAdapter("dtv.xst.dao.ttr.impl.IdentityVerificationDAO", generator);
/*  724 */     addAdapter("dtv.xst.dao.ttr.IIdentityVerification", generator);
/*  725 */     addAdapter("IdentityVerification", generator);
/*  726 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  728 */           return (Class)TenderAuthLogDBA.class;
/*      */         }
/*      */       };
/*  731 */     addAdapter("dtv.xst.dao.ttr.TenderAuthLogId", generator);
/*  732 */     addAdapter("dtv.xst.dao.ttr.impl.TenderAuthLogDAO", generator);
/*  733 */     addAdapter("dtv.xst.dao.ttr.ITenderAuthLog", generator);
/*  734 */     addAdapter("TenderAuthLog", generator);
/*  735 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  737 */           return (Class)TenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  740 */     addAdapter("dtv.xst.dao.ttr.impl.TenderLineItemDAO", generator);
/*  741 */     addAdapter("dtv.xst.dao.ttr.ITenderLineItem", generator);
/*  742 */     addAdapter("TenderLineItem", generator);
/*  743 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  745 */           return (Class)TenderSignatureDBA.class;
/*      */         }
/*      */       };
/*  748 */     addAdapter("dtv.xst.dao.ttr.TenderSignatureId", generator);
/*  749 */     addAdapter("dtv.xst.dao.ttr.impl.TenderSignatureDAO", generator);
/*  750 */     addAdapter("dtv.xst.dao.ttr.ITenderSignature", generator);
/*  751 */     addAdapter("TenderSignature", generator);
/*  752 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  754 */           return (Class)VoucherDBA.class;
/*      */         }
/*      */       };
/*  757 */     addAdapter("dtv.xst.dao.ttr.VoucherId", generator);
/*  758 */     addAdapter("dtv.xst.dao.ttr.impl.VoucherDAO", generator);
/*  759 */     addAdapter("dtv.xst.dao.ttr.IVoucher", generator);
/*  760 */     addAdapter("Voucher", generator);
/*  761 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  763 */           return (Class)VoucherHistoryDBA.class;
/*      */         }
/*      */       };
/*  766 */     addAdapter("dtv.xst.dao.ttr.VoucherHistoryId", generator);
/*  767 */     addAdapter("dtv.xst.dao.ttr.impl.VoucherHistoryDAO", generator);
/*  768 */     addAdapter("dtv.xst.dao.ttr.IVoucherHistory", generator);
/*  769 */     addAdapter("VoucherHistory", generator);
/*  770 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  772 */           return (Class)VoucherTenderLineItemDBA.class;
/*      */         }
/*      */       };
/*  775 */     addAdapter("dtv.xst.dao.ttr.impl.VoucherTenderLineItemDAO", generator);
/*  776 */     addAdapter("dtv.xst.dao.ttr.IVoucherTenderLineItem", generator);
/*  777 */     addAdapter("VoucherTenderLineItem", generator);
/*  778 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  780 */           return (Class)SessionDBA.class;
/*      */         }
/*      */       };
/*  783 */     addAdapter("dtv.xst.dao.tsn.SessionId", generator);
/*  784 */     addAdapter("dtv.xst.dao.tsn.impl.SessionDAO", generator);
/*  785 */     addAdapter("dtv.xst.dao.tsn.ISession", generator);
/*  786 */     addAdapter("Session", generator);
/*  787 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  789 */           return (Class)TenderControlTransactionDBA.class;
/*      */         }
/*      */       };
/*  792 */     addAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO", generator);
/*  793 */     addAdapter("dtv.xst.dao.tsn.ITenderControlTransaction", generator);
/*  794 */     addAdapter("TenderControlTransaction", generator);
/*  795 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  797 */           return (Class)TenderCountDBA.class;
/*      */         }
/*      */       };
/*  800 */     addAdapter("dtv.xst.dao.tsn.TenderCountId", generator);
/*  801 */     addAdapter("dtv.xst.dao.tsn.impl.TenderCountDAO", generator);
/*  802 */     addAdapter("dtv.xst.dao.tsn.ITenderCount", generator);
/*  803 */     addAdapter("TenderCount", generator);
/*  804 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  806 */           return (Class)ExchangeRateTransLineItemDBA.class;
/*      */         }
/*      */       };
/*  809 */     addAdapter("dtv.xst.dao.tsn.ExchangeRateTransLineItemId", generator);
/*  810 */     addAdapter("dtv.xst.dao.tsn.impl.ExchangeRateTransLineItemDAO", generator);
/*  811 */     addAdapter("dtv.xst.dao.tsn.IExchangeRateTransLineItem", generator);
/*  812 */     addAdapter("ExchangeRateTransLineItem", generator);
/*  813 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  815 */           return (Class)ExchangeRateTransactionDBA.class;
/*      */         }
/*      */       };
/*  818 */     addAdapter("dtv.xst.dao.tsn.impl.ExchangeRateTransactionDAO", generator);
/*  819 */     addAdapter("dtv.xst.dao.tsn.IExchangeRateTransaction", generator);
/*  820 */     addAdapter("ExchangeRateTransaction", generator);
/*  821 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  823 */           return (Class)SessionControlTransactionDBA.class;
/*      */         }
/*      */       };
/*  826 */     addAdapter("dtv.xst.dao.tsn.impl.SessionControlTransactionDAO", generator);
/*  827 */     addAdapter("dtv.xst.dao.tsn.ISessionControlTransaction", generator);
/*  828 */     addAdapter("SessionControlTransaction", generator);
/*  829 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  831 */           return (Class)SessionTenderDBA.class;
/*      */         }
/*      */       };
/*  834 */     addAdapter("dtv.xst.dao.tsn.SessionTenderId", generator);
/*  835 */     addAdapter("dtv.xst.dao.tsn.impl.SessionTenderDAO", generator);
/*  836 */     addAdapter("dtv.xst.dao.tsn.ISessionTender", generator);
/*  837 */     addAdapter("SessionTender", generator);
/*  838 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  840 */           return (Class)SessionWorkstationDBA.class;
/*      */         }
/*      */       };
/*  843 */     addAdapter("dtv.xst.dao.tsn.SessionWorkstationId", generator);
/*  844 */     addAdapter("dtv.xst.dao.tsn.impl.SessionWorkstationDAO", generator);
/*  845 */     addAdapter("dtv.xst.dao.tsn.ISessionWorkstation", generator);
/*  846 */     addAdapter("SessionWorkstation", generator);
/*  847 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  849 */           return (Class)TenderDenominationCountDBA.class;
/*      */         }
/*      */       };
/*  852 */     addAdapter("dtv.xst.dao.tsn.TenderDenominationCountId", generator);
/*  853 */     addAdapter("dtv.xst.dao.tsn.impl.TenderDenominationCountDAO", generator);
/*  854 */     addAdapter("dtv.xst.dao.tsn.ITenderDenominationCount", generator);
/*  855 */     addAdapter("TenderDenominationCount", generator);
/*  856 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  858 */           return (Class)TenderRepositoryDBA.class;
/*      */         }
/*      */       };
/*  861 */     addAdapter("dtv.xst.dao.tsn.TenderRepositoryId", generator);
/*  862 */     addAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryDAO", generator);
/*  863 */     addAdapter("dtv.xst.dao.tsn.ITenderRepository", generator);
/*  864 */     addAdapter("TenderRepository", generator);
/*  865 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  867 */           return (Class)TenderRepositoryFloatDBA.class;
/*      */         }
/*      */       };
/*  870 */     addAdapter("dtv.xst.dao.tsn.TenderRepositoryFloatId", generator);
/*  871 */     addAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryFloatDAO", generator);
/*  872 */     addAdapter("dtv.xst.dao.tsn.ITenderRepositoryFloat", generator);
/*  873 */     addAdapter("TenderRepositoryFloat", generator);
/*  874 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  876 */           return (Class)TenderRepositoryStatusDBA.class;
/*      */         }
/*      */       };
/*  879 */     addAdapter("dtv.xst.dao.tsn.TenderRepositoryStatusId", generator);
/*  880 */     addAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryStatusDAO", generator);
/*  881 */     addAdapter("dtv.xst.dao.tsn.ITenderRepositoryStatus", generator);
/*  882 */     addAdapter("TenderRepositoryStatus", generator);
/*  883 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  885 */           return (Class)TenderSerializedCountDBA.class;
/*      */         }
/*      */       };
/*  888 */     addAdapter("dtv.xst.dao.tsn.TenderSerializedCountId", generator);
/*  889 */     addAdapter("dtv.xst.dao.tsn.impl.TenderSerializedCountDAO", generator);
/*  890 */     addAdapter("dtv.xst.dao.tsn.ITenderSerializedCount", generator);
/*  891 */     addAdapter("TenderSerializedCount", generator);
/*  892 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  894 */           return (Class)TenderTypeCountDBA.class;
/*      */         }
/*      */       };
/*  897 */     addAdapter("dtv.xst.dao.tsn.TenderTypeCountId", generator);
/*  898 */     addAdapter("dtv.xst.dao.tsn.impl.TenderTypeCountDAO", generator);
/*  899 */     addAdapter("dtv.xst.dao.tsn.ITenderTypeCount", generator);
/*  900 */     addAdapter("TenderTypeCount", generator);
/*  901 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  903 */           return (Class)TillControlTransactionDBA.class;
/*      */         }
/*      */       };
/*  906 */     addAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDAO", generator);
/*  907 */     addAdapter("dtv.xst.dao.tsn.ITillControlTransaction", generator);
/*  908 */     addAdapter("TillControlTransaction", generator);
/*  909 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  911 */           return (Class)TillControlTransactionDetailDBA.class;
/*      */         }
/*      */       };
/*  914 */     addAdapter("dtv.xst.dao.tsn.TillControlTransactionDetailId", generator);
/*  915 */     addAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDetailDAO", generator);
/*  916 */     addAdapter("dtv.xst.dao.tsn.ITillControlTransactionDetail", generator);
/*  917 */     addAdapter("TillControlTransactionDetail", generator);
/*  918 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  920 */           return (Class)SaleTaxModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  923 */     addAdapter("dtv.xst.dao.trl.SaleTaxModifierPropertyId", generator);
/*  924 */     addAdapter("dtv.xst.dao.trl.impl.SaleTaxModifierPropertyDAO", generator);
/*  925 */     addAdapter("dtv.xst.dao.trl.ISaleTaxModifierProperty", generator);
/*  926 */     addAdapter("SaleTaxModifierProperty", generator);
/*  927 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  929 */           return (Class)RetailTransactionFlightInfoPropertyDBA.class;
/*      */         }
/*      */       };
/*  932 */     addAdapter("dtv.xst.dao.trl.RetailTransactionFlightInfoPropertyId", generator);
/*  933 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoPropertyDAO", generator);
/*  934 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionFlightInfoProperty", generator);
/*  935 */     addAdapter("RetailTransactionFlightInfoProperty", generator);
/*  936 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  938 */           return (Class)KitComponentModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  941 */     addAdapter("dtv.xst.dao.trl.KitComponentModifierPropertyId", generator);
/*  942 */     addAdapter("dtv.xst.dao.trl.impl.KitComponentModifierPropertyDAO", generator);
/*  943 */     addAdapter("dtv.xst.dao.trl.IKitComponentModifierProperty", generator);
/*  944 */     addAdapter("KitComponentModifierProperty", generator);
/*  945 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  947 */           return (Class)WarrantyModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  950 */     addAdapter("dtv.xst.dao.trl.WarrantyModifierPropertyId", generator);
/*  951 */     addAdapter("dtv.xst.dao.trl.impl.WarrantyModifierPropertyDAO", generator);
/*  952 */     addAdapter("dtv.xst.dao.trl.IWarrantyModifierProperty", generator);
/*  953 */     addAdapter("WarrantyModifierProperty", generator);
/*  954 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  956 */           return (Class)CommissionModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  959 */     addAdapter("dtv.xst.dao.trl.CommissionModifierPropertyId", generator);
/*  960 */     addAdapter("dtv.xst.dao.trl.impl.CommissionModifierPropertyDAO", generator);
/*  961 */     addAdapter("dtv.xst.dao.trl.ICommissionModifierProperty", generator);
/*  962 */     addAdapter("CommissionModifierProperty", generator);
/*  963 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  965 */           return (Class)CorrectionModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  968 */     addAdapter("dtv.xst.dao.trl.CorrectionModifierPropertyId", generator);
/*  969 */     addAdapter("dtv.xst.dao.trl.impl.CorrectionModifierPropertyDAO", generator);
/*  970 */     addAdapter("dtv.xst.dao.trl.ICorrectionModifierProperty", generator);
/*  971 */     addAdapter("CorrectionModifierProperty", generator);
/*  972 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  974 */           return (Class)CustomerItemAccountModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  977 */     addAdapter("dtv.xst.dao.trl.CustomerItemAccountModifierPropertyId", generator);
/*  978 */     addAdapter("dtv.xst.dao.trl.impl.CustomerItemAccountModifierPropertyDAO", generator);
/*  979 */     addAdapter("dtv.xst.dao.trl.ICustomerItemAccountModifierProperty", generator);
/*  980 */     addAdapter("CustomerItemAccountModifierProperty", generator);
/*  981 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  983 */           return (Class)DimensionModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  986 */     addAdapter("dtv.xst.dao.trl.DimensionModifierPropertyId", generator);
/*  987 */     addAdapter("dtv.xst.dao.trl.impl.DimensionModifierPropertyDAO", generator);
/*  988 */     addAdapter("dtv.xst.dao.trl.IDimensionModifierProperty", generator);
/*  989 */     addAdapter("DimensionModifierProperty", generator);
/*  990 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/*  992 */           return (Class)InventoryDocumentModifierPropertyDBA.class;
/*      */         }
/*      */       };
/*  995 */     addAdapter("dtv.xst.dao.trl.InventoryDocumentModifierPropertyId", generator);
/*  996 */     addAdapter("dtv.xst.dao.trl.impl.InventoryDocumentModifierPropertyDAO", generator);
/*  997 */     addAdapter("dtv.xst.dao.trl.IInventoryDocumentModifierProperty", generator);
/*  998 */     addAdapter("InventoryDocumentModifierProperty", generator);
/*  999 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1001 */           return (Class)LineItemAssociationModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 1004 */     addAdapter("dtv.xst.dao.trl.LineItemAssociationModifierPropertyId", generator);
/* 1005 */     addAdapter("dtv.xst.dao.trl.impl.LineItemAssociationModifierPropertyDAO", generator);
/* 1006 */     addAdapter("dtv.xst.dao.trl.ILineItemAssociationModifierProperty", generator);
/* 1007 */     addAdapter("LineItemAssociationModifierProperty", generator);
/* 1008 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1010 */           return (Class)LineItemAssociationTypeCodePropertyDBA.class;
/*      */         }
/*      */       };
/* 1013 */     addAdapter("dtv.xst.dao.trl.LineItemAssociationTypeCodePropertyId", generator);
/* 1014 */     addAdapter("dtv.xst.dao.trl.impl.LineItemAssociationTypeCodePropertyDAO", generator);
/* 1015 */     addAdapter("dtv.xst.dao.trl.ILineItemAssociationTypeCodeProperty", generator);
/* 1016 */     addAdapter("LineItemAssociationTypeCodeProperty", generator);
/* 1017 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1019 */           return (Class)RetailInventoryLocationModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 1022 */     addAdapter("dtv.xst.dao.trl.RetailInventoryLocationModifierPropertyId", generator);
/* 1023 */     addAdapter("dtv.xst.dao.trl.impl.RetailInventoryLocationModifierPropertyDAO", generator);
/* 1024 */     addAdapter("dtv.xst.dao.trl.IRetailInventoryLocationModifierProperty", generator);
/* 1025 */     addAdapter("RetailInventoryLocationModifierProperty", generator);
/* 1026 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1028 */           return (Class)RetailPriceModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 1031 */     addAdapter("dtv.xst.dao.trl.RetailPriceModifierPropertyId", generator);
/* 1032 */     addAdapter("dtv.xst.dao.trl.impl.RetailPriceModifierPropertyDAO", generator);
/* 1033 */     addAdapter("dtv.xst.dao.trl.IRetailPriceModifierProperty", generator);
/* 1034 */     addAdapter("RetailPriceModifierProperty", generator);
/* 1035 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1037 */           return (Class)RetailTransactionLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 1040 */     addAdapter("dtv.xst.dao.trl.RetailTransactionLineItemPropertyId", generator);
/* 1041 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemPropertyDAO", generator);
/* 1042 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionLineItemProperty", generator);
/* 1043 */     addAdapter("RetailTransactionLineItemProperty", generator);
/* 1044 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1046 */           return (Class)RetailTransactionLineItemNotesPropertyDBA.class;
/*      */         }
/*      */       };
/* 1049 */     addAdapter("dtv.xst.dao.trl.RetailTransactionLineItemNotesPropertyId", generator);
/* 1050 */     addAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemNotesPropertyDAO", generator);
/* 1051 */     addAdapter("dtv.xst.dao.trl.IRetailTransactionLineItemNotesProperty", generator);
/* 1052 */     addAdapter("RetailTransactionLineItemNotesProperty", generator);
/* 1053 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1055 */           return (Class)ReturnedItemCountPropertyDBA.class;
/*      */         }
/*      */       };
/* 1058 */     addAdapter("dtv.xst.dao.trl.ReturnedItemCountPropertyId", generator);
/* 1059 */     addAdapter("dtv.xst.dao.trl.impl.ReturnedItemCountPropertyDAO", generator);
/* 1060 */     addAdapter("dtv.xst.dao.trl.IReturnedItemCountProperty", generator);
/* 1061 */     addAdapter("ReturnedItemCountProperty", generator);
/* 1062 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1064 */           return (Class)ReturnedItemJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 1067 */     addAdapter("dtv.xst.dao.trl.ReturnedItemJournalPropertyId", generator);
/* 1068 */     addAdapter("dtv.xst.dao.trl.impl.ReturnedItemJournalPropertyDAO", generator);
/* 1069 */     addAdapter("dtv.xst.dao.trl.IReturnedItemJournalProperty", generator);
/* 1070 */     addAdapter("ReturnedItemJournalProperty", generator);
/* 1071 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1073 */           return (Class)KitComponentPropertyDBA.class;
/*      */         }
/*      */       };
/* 1076 */     addAdapter("dtv.xst.dao.itm.KitComponentPropertyId", generator);
/* 1077 */     addAdapter("dtv.xst.dao.itm.impl.KitComponentPropertyDAO", generator);
/* 1078 */     addAdapter("dtv.xst.dao.itm.IKitComponentProperty", generator);
/* 1079 */     addAdapter("KitComponentProperty", generator);
/* 1080 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1082 */           return (Class)ItemOptionsPropertyDBA.class;
/*      */         }
/*      */       };
/* 1085 */     addAdapter("dtv.xst.dao.itm.ItemOptionsPropertyId", generator);
/* 1086 */     addAdapter("dtv.xst.dao.itm.impl.ItemOptionsPropertyDAO", generator);
/* 1087 */     addAdapter("dtv.xst.dao.itm.IItemOptionsProperty", generator);
/* 1088 */     addAdapter("ItemOptionsProperty", generator);
/* 1089 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1091 */           return (Class)ItemRestrictionCalendarPropertyDBA.class;
/*      */         }
/*      */       };
/* 1094 */     addAdapter("dtv.xst.dao.itm.ItemRestrictionCalendarPropertyId", generator);
/* 1095 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictionCalendarPropertyDAO", generator);
/* 1096 */     addAdapter("dtv.xst.dao.itm.IItemRestrictionCalendarProperty", generator);
/* 1097 */     addAdapter("ItemRestrictionCalendarProperty", generator);
/* 1098 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1100 */           return (Class)ItemRestrictionPropertyDBA.class;
/*      */         }
/*      */       };
/* 1103 */     addAdapter("dtv.xst.dao.itm.ItemRestrictionPropertyId", generator);
/* 1104 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictionPropertyDAO", generator);
/* 1105 */     addAdapter("dtv.xst.dao.itm.IItemRestrictionProperty", generator);
/* 1106 */     addAdapter("ItemRestrictionProperty", generator);
/* 1107 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1109 */           return (Class)ItemRestrictionMappingPropertyDBA.class;
/*      */         }
/*      */       };
/* 1112 */     addAdapter("dtv.xst.dao.itm.ItemRestrictionMappingPropertyId", generator);
/* 1113 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictionMappingPropertyDAO", generator);
/* 1114 */     addAdapter("dtv.xst.dao.itm.IItemRestrictionMappingProperty", generator);
/* 1115 */     addAdapter("ItemRestrictionMappingProperty", generator);
/* 1116 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1118 */           return (Class)AttachedItemsPropertyDBA.class;
/*      */         }
/*      */       };
/* 1121 */     addAdapter("dtv.xst.dao.itm.AttachedItemsPropertyId", generator);
/* 1122 */     addAdapter("dtv.xst.dao.itm.impl.AttachedItemsPropertyDAO", generator);
/* 1123 */     addAdapter("dtv.xst.dao.itm.IAttachedItemsProperty", generator);
/* 1124 */     addAdapter("AttachedItemsProperty", generator);
/* 1125 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1127 */           return (Class)ItemDimensionTypePropertyDBA.class;
/*      */         }
/*      */       };
/* 1130 */     addAdapter("dtv.xst.dao.itm.ItemDimensionTypePropertyId", generator);
/* 1131 */     addAdapter("dtv.xst.dao.itm.impl.ItemDimensionTypePropertyDAO", generator);
/* 1132 */     addAdapter("dtv.xst.dao.itm.IItemDimensionTypeProperty", generator);
/* 1133 */     addAdapter("ItemDimensionTypeProperty", generator);
/* 1134 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1136 */           return (Class)ItemDimensionValuePropertyDBA.class;
/*      */         }
/*      */       };
/* 1139 */     addAdapter("dtv.xst.dao.itm.ItemDimensionValuePropertyId", generator);
/* 1140 */     addAdapter("dtv.xst.dao.itm.impl.ItemDimensionValuePropertyDAO", generator);
/* 1141 */     addAdapter("dtv.xst.dao.itm.IItemDimensionValueProperty", generator);
/* 1142 */     addAdapter("ItemDimensionValueProperty", generator);
/* 1143 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1145 */           return (Class)ItemMessagePropertyDBA.class;
/*      */         }
/*      */       };
/* 1148 */     addAdapter("dtv.xst.dao.itm.ItemMessagePropertyId", generator);
/* 1149 */     addAdapter("dtv.xst.dao.itm.impl.ItemMessagePropertyDAO", generator);
/* 1150 */     addAdapter("dtv.xst.dao.itm.IItemMessageProperty", generator);
/* 1151 */     addAdapter("ItemMessageProperty", generator);
/* 1152 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1154 */           return (Class)MerchandiseHierarchyPropertyDBA.class;
/*      */         }
/*      */       };
/* 1157 */     addAdapter("dtv.xst.dao.itm.MerchandiseHierarchyPropertyId", generator);
/* 1158 */     addAdapter("dtv.xst.dao.itm.impl.MerchandiseHierarchyPropertyDAO", generator);
/* 1159 */     addAdapter("dtv.xst.dao.itm.IMerchandiseHierarchyProperty", generator);
/* 1160 */     addAdapter("MerchandiseHierarchyProperty", generator);
/* 1161 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1163 */           return (Class)QuickItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 1166 */     addAdapter("dtv.xst.dao.itm.QuickItemPropertyId", generator);
/* 1167 */     addAdapter("dtv.xst.dao.itm.impl.QuickItemPropertyDAO", generator);
/* 1168 */     addAdapter("dtv.xst.dao.itm.IQuickItemProperty", generator);
/* 1169 */     addAdapter("QuickItemProperty", generator);
/* 1170 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1172 */           return (Class)WarrantyPropertyDBA.class;
/*      */         }
/*      */       };
/* 1175 */     addAdapter("dtv.xst.dao.itm.WarrantyPropertyId", generator);
/* 1176 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyPropertyDAO", generator);
/* 1177 */     addAdapter("dtv.xst.dao.itm.IWarrantyProperty", generator);
/* 1178 */     addAdapter("WarrantyProperty", generator);
/* 1179 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1181 */           return (Class)WarrantyJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 1184 */     addAdapter("dtv.xst.dao.itm.WarrantyJournalPropertyId", generator);
/* 1185 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyJournalPropertyDAO", generator);
/* 1186 */     addAdapter("dtv.xst.dao.itm.IWarrantyJournalProperty", generator);
/* 1187 */     addAdapter("WarrantyJournalProperty", generator);
/* 1188 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1190 */           return (Class)SubstituteItemsPropertyDBA.class;
/*      */         }
/*      */       };
/* 1193 */     addAdapter("dtv.xst.dao.itm.SubstituteItemsPropertyId", generator);
/* 1194 */     addAdapter("dtv.xst.dao.itm.impl.SubstituteItemsPropertyDAO", generator);
/* 1195 */     addAdapter("dtv.xst.dao.itm.ISubstituteItemsProperty", generator);
/* 1196 */     addAdapter("SubstituteItemsProperty", generator);
/* 1197 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1199 */           return (Class)ItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 1202 */     addAdapter("dtv.xst.dao.itm.ItemPropertyId", generator);
/* 1203 */     addAdapter("dtv.xst.dao.itm.impl.ItemPropertyDAO", generator);
/* 1204 */     addAdapter("dtv.xst.dao.itm.IItemProperty", generator);
/* 1205 */     addAdapter("ItemProperty", generator);
/* 1206 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1208 */           return (Class)VendorPropertyDBA.class;
/*      */         }
/*      */       };
/* 1211 */     addAdapter("dtv.xst.dao.itm.VendorPropertyId", generator);
/* 1212 */     addAdapter("dtv.xst.dao.itm.impl.VendorPropertyDAO", generator);
/* 1213 */     addAdapter("dtv.xst.dao.itm.IVendorProperty", generator);
/* 1214 */     addAdapter("VendorProperty", generator);
/* 1215 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1217 */           return (Class)ItemCrossReferencePropertyDBA.class;
/*      */         }
/*      */       };
/* 1220 */     addAdapter("dtv.xst.dao.itm.ItemCrossReferencePropertyId", generator);
/* 1221 */     addAdapter("dtv.xst.dao.itm.impl.ItemCrossReferencePropertyDAO", generator);
/* 1222 */     addAdapter("dtv.xst.dao.itm.IItemCrossReferenceProperty", generator);
/* 1223 */     addAdapter("ItemCrossReferenceProperty", generator);
/* 1224 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1226 */           return (Class)ItemDealPropertyPropertyDBA.class;
/*      */         }
/*      */       };
/* 1229 */     addAdapter("dtv.xst.dao.itm.ItemDealPropertyPropertyId", generator);
/* 1230 */     addAdapter("dtv.xst.dao.itm.impl.ItemDealPropertyPropertyDAO", generator);
/* 1231 */     addAdapter("dtv.xst.dao.itm.IItemDealPropertyProperty", generator);
/* 1232 */     addAdapter("ItemDealPropertyProperty", generator);
/* 1233 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1235 */           return (Class)ItemMessageCrossReferencePropertyDBA.class;
/*      */         }
/*      */       };
/* 1238 */     addAdapter("dtv.xst.dao.itm.ItemMessageCrossReferencePropertyId", generator);
/* 1239 */     addAdapter("dtv.xst.dao.itm.impl.ItemMessageCrossReferencePropertyDAO", generator);
/* 1240 */     addAdapter("dtv.xst.dao.itm.IItemMessageCrossReferenceProperty", generator);
/* 1241 */     addAdapter("ItemMessageCrossReferenceProperty", generator);
/* 1242 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1244 */           return (Class)ItemMessageTypesPropertyDBA.class;
/*      */         }
/*      */       };
/* 1247 */     addAdapter("dtv.xst.dao.itm.ItemMessageTypesPropertyId", generator);
/* 1248 */     addAdapter("dtv.xst.dao.itm.impl.ItemMessageTypesPropertyDAO", generator);
/* 1249 */     addAdapter("dtv.xst.dao.itm.IItemMessageTypesProperty", generator);
/* 1250 */     addAdapter("ItemMessageTypesProperty", generator);
/* 1251 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1253 */           return (Class)ItemPricesPropertyDBA.class;
/*      */         }
/*      */       };
/* 1256 */     addAdapter("dtv.xst.dao.itm.ItemPricesPropertyId", generator);
/* 1257 */     addAdapter("dtv.xst.dao.itm.impl.ItemPricesPropertyDAO", generator);
/* 1258 */     addAdapter("dtv.xst.dao.itm.IItemPricesProperty", generator);
/* 1259 */     addAdapter("ItemPricesProperty", generator);
/* 1260 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1262 */           return (Class)ItemPromptPropertyPropertyDBA.class;
/*      */         }
/*      */       };
/* 1265 */     addAdapter("dtv.xst.dao.itm.ItemPromptPropertyPropertyId", generator);
/* 1266 */     addAdapter("dtv.xst.dao.itm.impl.ItemPromptPropertyPropertyDAO", generator);
/* 1267 */     addAdapter("dtv.xst.dao.itm.IItemPromptPropertyProperty", generator);
/* 1268 */     addAdapter("ItemPromptPropertyProperty", generator);
/* 1269 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1271 */           return (Class)ItemRestrictGS1PropertyDBA.class;
/*      */         }
/*      */       };
/* 1274 */     addAdapter("dtv.xst.dao.itm.ItemRestrictGS1PropertyId", generator);
/* 1275 */     addAdapter("dtv.xst.dao.itm.impl.ItemRestrictGS1PropertyDAO", generator);
/* 1276 */     addAdapter("dtv.xst.dao.itm.IItemRestrictGS1Property", generator);
/* 1277 */     addAdapter("ItemRestrictGS1Property", generator);
/* 1278 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1280 */           return (Class)RefundSchedulePropertyDBA.class;
/*      */         }
/*      */       };
/* 1283 */     addAdapter("dtv.xst.dao.itm.RefundSchedulePropertyId", generator);
/* 1284 */     addAdapter("dtv.xst.dao.itm.impl.RefundSchedulePropertyDAO", generator);
/* 1285 */     addAdapter("dtv.xst.dao.itm.IRefundScheduleProperty", generator);
/* 1286 */     addAdapter("RefundScheduleProperty", generator);
/* 1287 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1289 */           return (Class)WarrantyItemCrossReferencePropertyDBA.class;
/*      */         }
/*      */       };
/* 1292 */     addAdapter("dtv.xst.dao.itm.WarrantyItemCrossReferencePropertyId", generator);
/* 1293 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyItemCrossReferencePropertyDAO", generator);
/* 1294 */     addAdapter("dtv.xst.dao.itm.IWarrantyItemCrossReferenceProperty", generator);
/* 1295 */     addAdapter("WarrantyItemCrossReferenceProperty", generator);
/* 1296 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1298 */           return (Class)WarrantyItemPricePropertyDBA.class;
/*      */         }
/*      */       };
/* 1301 */     addAdapter("dtv.xst.dao.itm.WarrantyItemPricePropertyId", generator);
/* 1302 */     addAdapter("dtv.xst.dao.itm.impl.WarrantyItemPricePropertyDAO", generator);
/* 1303 */     addAdapter("dtv.xst.dao.itm.IWarrantyItemPriceProperty", generator);
/* 1304 */     addAdapter("WarrantyItemPriceProperty", generator);
/* 1305 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1307 */           return (Class)ItemLabelBatchPropertyDBA.class;
/*      */         }
/*      */       };
/* 1310 */     addAdapter("dtv.xst.dao.itm.ItemLabelBatchPropertyId", generator);
/* 1311 */     addAdapter("dtv.xst.dao.itm.impl.ItemLabelBatchPropertyDAO", generator);
/* 1312 */     addAdapter("dtv.xst.dao.itm.IItemLabelBatchProperty", generator);
/* 1313 */     addAdapter("ItemLabelBatchProperty", generator);
/* 1314 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1316 */           return (Class)ItemImagePropertyDBA.class;
/*      */         }
/*      */       };
/* 1319 */     addAdapter("dtv.xst.dao.itm.ItemImagePropertyId", generator);
/* 1320 */     addAdapter("dtv.xst.dao.itm.impl.ItemImagePropertyDAO", generator);
/* 1321 */     addAdapter("dtv.xst.dao.itm.IItemImageProperty", generator);
/* 1322 */     addAdapter("ItemImageProperty", generator);
/* 1323 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1325 */           return (Class)ItemLabelPropertiesPropertyDBA.class;
/*      */         }
/*      */       };
/* 1328 */     addAdapter("dtv.xst.dao.itm.ItemLabelPropertiesPropertyId", generator);
/* 1329 */     addAdapter("dtv.xst.dao.itm.impl.ItemLabelPropertiesPropertyDAO", generator);
/* 1330 */     addAdapter("dtv.xst.dao.itm.IItemLabelPropertiesProperty", generator);
/* 1331 */     addAdapter("ItemLabelPropertiesProperty", generator);
/* 1332 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1334 */           return (Class)MatrixSortOrderPropertyDBA.class;
/*      */         }
/*      */       };
/* 1337 */     addAdapter("dtv.xst.dao.itm.MatrixSortOrderPropertyId", generator);
/* 1338 */     addAdapter("dtv.xst.dao.itm.impl.MatrixSortOrderPropertyDAO", generator);
/* 1339 */     addAdapter("dtv.xst.dao.itm.IMatrixSortOrderProperty", generator);
/* 1340 */     addAdapter("MatrixSortOrderProperty", generator);
/* 1341 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1343 */           return (Class)PosTransactionPropertyDBA.class;
/*      */         }
/*      */       };
/* 1346 */     addAdapter("dtv.xst.dao.trn.PosTransactionPropertyId", generator);
/* 1347 */     addAdapter("dtv.xst.dao.trn.impl.PosTransactionPropertyDAO", generator);
/* 1348 */     addAdapter("dtv.xst.dao.trn.IPosTransactionProperty", generator);
/* 1349 */     addAdapter("PosTransactionProperty", generator);
/* 1350 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1352 */           return (Class)LineItemGenericStoragePropertyDBA.class;
/*      */         }
/*      */       };
/* 1355 */     addAdapter("dtv.xst.dao.trn.LineItemGenericStoragePropertyId", generator);
/* 1356 */     addAdapter("dtv.xst.dao.trn.impl.LineItemGenericStoragePropertyDAO", generator);
/* 1357 */     addAdapter("dtv.xst.dao.trn.ILineItemGenericStorageProperty", generator);
/* 1358 */     addAdapter("LineItemGenericStorageProperty", generator);
/* 1359 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1361 */           return (Class)PosLogDataPropertyDBA.class;
/*      */         }
/*      */       };
/* 1364 */     addAdapter("dtv.xst.dao.trn.PosLogDataPropertyId", generator);
/* 1365 */     addAdapter("dtv.xst.dao.trn.impl.PosLogDataPropertyDAO", generator);
/* 1366 */     addAdapter("dtv.xst.dao.trn.IPosLogDataProperty", generator);
/* 1367 */     addAdapter("PosLogDataProperty", generator);
/* 1368 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1370 */           return (Class)PosTransactionLinkPropertyDBA.class;
/*      */         }
/*      */       };
/* 1373 */     addAdapter("dtv.xst.dao.trn.PosTransactionLinkPropertyId", generator);
/* 1374 */     addAdapter("dtv.xst.dao.trn.impl.PosTransactionLinkPropertyDAO", generator);
/* 1375 */     addAdapter("dtv.xst.dao.trn.IPosTransactionLinkProperty", generator);
/* 1376 */     addAdapter("PosTransactionLinkProperty", generator);
/* 1377 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1379 */           return (Class)RainCheckPropertyDBA.class;
/*      */         }
/*      */       };
/* 1382 */     addAdapter("dtv.xst.dao.trn.RainCheckPropertyId", generator);
/* 1383 */     addAdapter("dtv.xst.dao.trn.impl.RainCheckPropertyDAO", generator);
/* 1384 */     addAdapter("dtv.xst.dao.trn.IRainCheckProperty", generator);
/* 1385 */     addAdapter("RainCheckProperty", generator);
/* 1386 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1388 */           return (Class)ReceiptDataPropertyDBA.class;
/*      */         }
/*      */       };
/* 1391 */     addAdapter("dtv.xst.dao.trn.ReceiptDataPropertyId", generator);
/* 1392 */     addAdapter("dtv.xst.dao.trn.impl.ReceiptDataPropertyDAO", generator);
/* 1393 */     addAdapter("dtv.xst.dao.trn.IReceiptDataProperty", generator);
/* 1394 */     addAdapter("ReceiptDataProperty", generator);
/* 1395 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1397 */           return (Class)ReceiptLookupPropertyDBA.class;
/*      */         }
/*      */       };
/* 1400 */     addAdapter("dtv.xst.dao.trn.ReceiptLookupPropertyId", generator);
/* 1401 */     addAdapter("dtv.xst.dao.trn.impl.ReceiptLookupPropertyDAO", generator);
/* 1402 */     addAdapter("dtv.xst.dao.trn.IReceiptLookupProperty", generator);
/* 1403 */     addAdapter("ReceiptLookupProperty", generator);
/* 1404 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1406 */           return (Class)TransactionNotesPropertyDBA.class;
/*      */         }
/*      */       };
/* 1409 */     addAdapter("dtv.xst.dao.trn.TransactionNotesPropertyId", generator);
/* 1410 */     addAdapter("dtv.xst.dao.trn.impl.TransactionNotesPropertyDAO", generator);
/* 1411 */     addAdapter("dtv.xst.dao.trn.ITransactionNotesProperty", generator);
/* 1412 */     addAdapter("TransactionNotesProperty", generator);
/* 1413 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1415 */           return (Class)TransactionVersionPropertyDBA.class;
/*      */         }
/*      */       };
/* 1418 */     addAdapter("dtv.xst.dao.trn.TransactionVersionPropertyId", generator);
/* 1419 */     addAdapter("dtv.xst.dao.trn.impl.TransactionVersionPropertyDAO", generator);
/* 1420 */     addAdapter("dtv.xst.dao.trn.ITransactionVersionProperty", generator);
/* 1421 */     addAdapter("TransactionVersionProperty", generator);
/* 1422 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1424 */           return (Class)IdentityVerificationPropertyDBA.class;
/*      */         }
/*      */       };
/* 1427 */     addAdapter("dtv.xst.dao.ttr.IdentityVerificationPropertyId", generator);
/* 1428 */     addAdapter("dtv.xst.dao.ttr.impl.IdentityVerificationPropertyDAO", generator);
/* 1429 */     addAdapter("dtv.xst.dao.ttr.IIdentityVerificationProperty", generator);
/* 1430 */     addAdapter("IdentityVerificationProperty", generator);
/* 1431 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1433 */           return (Class)TenderAuthLogPropertyDBA.class;
/*      */         }
/*      */       };
/* 1436 */     addAdapter("dtv.xst.dao.ttr.TenderAuthLogPropertyId", generator);
/* 1437 */     addAdapter("dtv.xst.dao.ttr.impl.TenderAuthLogPropertyDAO", generator);
/* 1438 */     addAdapter("dtv.xst.dao.ttr.ITenderAuthLogProperty", generator);
/* 1439 */     addAdapter("TenderAuthLogProperty", generator);
/* 1440 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1442 */           return (Class)TenderSignaturePropertyDBA.class;
/*      */         }
/*      */       };
/* 1445 */     addAdapter("dtv.xst.dao.ttr.TenderSignaturePropertyId", generator);
/* 1446 */     addAdapter("dtv.xst.dao.ttr.impl.TenderSignaturePropertyDAO", generator);
/* 1447 */     addAdapter("dtv.xst.dao.ttr.ITenderSignatureProperty", generator);
/* 1448 */     addAdapter("TenderSignatureProperty", generator);
/* 1449 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1451 */           return (Class)VoucherPropertyDBA.class;
/*      */         }
/*      */       };
/* 1454 */     addAdapter("dtv.xst.dao.ttr.VoucherPropertyId", generator);
/* 1455 */     addAdapter("dtv.xst.dao.ttr.impl.VoucherPropertyDAO", generator);
/* 1456 */     addAdapter("dtv.xst.dao.ttr.IVoucherProperty", generator);
/* 1457 */     addAdapter("VoucherProperty", generator);
/* 1458 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1460 */           return (Class)VoucherHistoryPropertyDBA.class;
/*      */         }
/*      */       };
/* 1463 */     addAdapter("dtv.xst.dao.ttr.VoucherHistoryPropertyId", generator);
/* 1464 */     addAdapter("dtv.xst.dao.ttr.impl.VoucherHistoryPropertyDAO", generator);
/* 1465 */     addAdapter("dtv.xst.dao.ttr.IVoucherHistoryProperty", generator);
/* 1466 */     addAdapter("VoucherHistoryProperty", generator);
/* 1467 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1469 */           return (Class)SessionPropertyDBA.class;
/*      */         }
/*      */       };
/* 1472 */     addAdapter("dtv.xst.dao.tsn.SessionPropertyId", generator);
/* 1473 */     addAdapter("dtv.xst.dao.tsn.impl.SessionPropertyDAO", generator);
/* 1474 */     addAdapter("dtv.xst.dao.tsn.ISessionProperty", generator);
/* 1475 */     addAdapter("SessionProperty", generator);
/* 1476 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1478 */           return (Class)TenderCountPropertyDBA.class;
/*      */         }
/*      */       };
/* 1481 */     addAdapter("dtv.xst.dao.tsn.TenderCountPropertyId", generator);
/* 1482 */     addAdapter("dtv.xst.dao.tsn.impl.TenderCountPropertyDAO", generator);
/* 1483 */     addAdapter("dtv.xst.dao.tsn.ITenderCountProperty", generator);
/* 1484 */     addAdapter("TenderCountProperty", generator);
/* 1485 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1487 */           return (Class)ExchangeRateTransLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 1490 */     addAdapter("dtv.xst.dao.tsn.ExchangeRateTransLineItemPropertyId", generator);
/* 1491 */     addAdapter("dtv.xst.dao.tsn.impl.ExchangeRateTransLineItemPropertyDAO", generator);
/* 1492 */     addAdapter("dtv.xst.dao.tsn.IExchangeRateTransLineItemProperty", generator);
/* 1493 */     addAdapter("ExchangeRateTransLineItemProperty", generator);
/* 1494 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1496 */           return (Class)SessionTenderPropertyDBA.class;
/*      */         }
/*      */       };
/* 1499 */     addAdapter("dtv.xst.dao.tsn.SessionTenderPropertyId", generator);
/* 1500 */     addAdapter("dtv.xst.dao.tsn.impl.SessionTenderPropertyDAO", generator);
/* 1501 */     addAdapter("dtv.xst.dao.tsn.ISessionTenderProperty", generator);
/* 1502 */     addAdapter("SessionTenderProperty", generator);
/* 1503 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1505 */           return (Class)SessionWorkstationPropertyDBA.class;
/*      */         }
/*      */       };
/* 1508 */     addAdapter("dtv.xst.dao.tsn.SessionWorkstationPropertyId", generator);
/* 1509 */     addAdapter("dtv.xst.dao.tsn.impl.SessionWorkstationPropertyDAO", generator);
/* 1510 */     addAdapter("dtv.xst.dao.tsn.ISessionWorkstationProperty", generator);
/* 1511 */     addAdapter("SessionWorkstationProperty", generator);
/* 1512 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1514 */           return (Class)TenderDenominationCountPropertyDBA.class;
/*      */         }
/*      */       };
/* 1517 */     addAdapter("dtv.xst.dao.tsn.TenderDenominationCountPropertyId", generator);
/* 1518 */     addAdapter("dtv.xst.dao.tsn.impl.TenderDenominationCountPropertyDAO", generator);
/* 1519 */     addAdapter("dtv.xst.dao.tsn.ITenderDenominationCountProperty", generator);
/* 1520 */     addAdapter("TenderDenominationCountProperty", generator);
/* 1521 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1523 */           return (Class)TenderRepositoryPropertyDBA.class;
/*      */         }
/*      */       };
/* 1526 */     addAdapter("dtv.xst.dao.tsn.TenderRepositoryPropertyId", generator);
/* 1527 */     addAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryPropertyDAO", generator);
/* 1528 */     addAdapter("dtv.xst.dao.tsn.ITenderRepositoryProperty", generator);
/* 1529 */     addAdapter("TenderRepositoryProperty", generator);
/* 1530 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1532 */           return (Class)TenderRepositoryFloatPropertyDBA.class;
/*      */         }
/*      */       };
/* 1535 */     addAdapter("dtv.xst.dao.tsn.TenderRepositoryFloatPropertyId", generator);
/* 1536 */     addAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryFloatPropertyDAO", generator);
/* 1537 */     addAdapter("dtv.xst.dao.tsn.ITenderRepositoryFloatProperty", generator);
/* 1538 */     addAdapter("TenderRepositoryFloatProperty", generator);
/* 1539 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1541 */           return (Class)TenderRepositoryStatusPropertyDBA.class;
/*      */         }
/*      */       };
/* 1544 */     addAdapter("dtv.xst.dao.tsn.TenderRepositoryStatusPropertyId", generator);
/* 1545 */     addAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryStatusPropertyDAO", generator);
/* 1546 */     addAdapter("dtv.xst.dao.tsn.ITenderRepositoryStatusProperty", generator);
/* 1547 */     addAdapter("TenderRepositoryStatusProperty", generator);
/* 1548 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1550 */           return (Class)TenderSerializedCountPropertyDBA.class;
/*      */         }
/*      */       };
/* 1553 */     addAdapter("dtv.xst.dao.tsn.TenderSerializedCountPropertyId", generator);
/* 1554 */     addAdapter("dtv.xst.dao.tsn.impl.TenderSerializedCountPropertyDAO", generator);
/* 1555 */     addAdapter("dtv.xst.dao.tsn.ITenderSerializedCountProperty", generator);
/* 1556 */     addAdapter("TenderSerializedCountProperty", generator);
/* 1557 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1559 */           return (Class)TenderTypeCountPropertyDBA.class;
/*      */         }
/*      */       };
/* 1562 */     addAdapter("dtv.xst.dao.tsn.TenderTypeCountPropertyId", generator);
/* 1563 */     addAdapter("dtv.xst.dao.tsn.impl.TenderTypeCountPropertyDAO", generator);
/* 1564 */     addAdapter("dtv.xst.dao.tsn.ITenderTypeCountProperty", generator);
/* 1565 */     addAdapter("TenderTypeCountProperty", generator);
/* 1566 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1568 */           return (Class)TillControlTransactionDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 1571 */     addAdapter("dtv.xst.dao.tsn.TillControlTransactionDetailPropertyId", generator);
/* 1572 */     addAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDetailPropertyDAO", generator);
/* 1573 */     addAdapter("dtv.xst.dao.tsn.ITillControlTransactionDetailProperty", generator);
/* 1574 */     addAdapter("TillControlTransactionDetailProperty", generator);
/* 1575 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1577 */           return (Class)CustomerConsentInfoDBA.class;
/*      */         }
/*      */       };
/* 1580 */     addAdapter("dtv.xst.dao.crm.CustomerConsentInfoId", generator);
/* 1581 */     addAdapter("dtv.xst.dao.crm.impl.CustomerConsentInfoDAO", generator);
/* 1582 */     addAdapter("dtv.xst.dao.crm.ICustomerConsentInfo", generator);
/* 1583 */     addAdapter("CustomerConsentInfo", generator);
/* 1584 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1586 */           return (Class)PartyDBA.class;
/*      */         }
/*      */       };
/* 1589 */     addAdapter("dtv.xst.dao.crm.PartyId", generator);
/* 1590 */     addAdapter("dtv.xst.dao.crm.impl.PartyDAO", generator);
/* 1591 */     addAdapter("dtv.xst.dao.crm.IParty", generator);
/* 1592 */     addAdapter("Party", generator);
/* 1593 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1595 */           return (Class)PartyLocaleInformationDBA.class;
/*      */         }
/*      */       };
/* 1598 */     addAdapter("dtv.xst.dao.crm.PartyLocaleInformationId", generator);
/* 1599 */     addAdapter("dtv.xst.dao.crm.impl.PartyLocaleInformationDAO", generator);
/* 1600 */     addAdapter("dtv.xst.dao.crm.IPartyLocaleInformation", generator);
/* 1601 */     addAdapter("PartyLocaleInformation", generator);
/* 1602 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1604 */           return (Class)CustomerAffiliationDBA.class;
/*      */         }
/*      */       };
/* 1607 */     addAdapter("dtv.xst.dao.crm.CustomerAffiliationId", generator);
/* 1608 */     addAdapter("dtv.xst.dao.crm.impl.CustomerAffiliationDAO", generator);
/* 1609 */     addAdapter("dtv.xst.dao.crm.ICustomerAffiliation", generator);
/* 1610 */     addAdapter("CustomerAffiliation", generator);
/* 1611 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1613 */           return (Class)CustomerNoteDBA.class;
/*      */         }
/*      */       };
/* 1616 */     addAdapter("dtv.xst.dao.crm.CustomerNoteId", generator);
/* 1617 */     addAdapter("dtv.xst.dao.crm.impl.CustomerNoteDAO", generator);
/* 1618 */     addAdapter("dtv.xst.dao.crm.ICustomerNote", generator);
/* 1619 */     addAdapter("CustomerNote", generator);
/* 1620 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1622 */           return (Class)GiftRegistryJournalDBA.class;
/*      */         }
/*      */       };
/* 1625 */     addAdapter("dtv.xst.dao.crm.GiftRegistryJournalId", generator);
/* 1626 */     addAdapter("dtv.xst.dao.crm.impl.GiftRegistryJournalDAO", generator);
/* 1627 */     addAdapter("dtv.xst.dao.crm.IGiftRegistryJournal", generator);
/* 1628 */     addAdapter("GiftRegistryJournal", generator);
/* 1629 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1631 */           return (Class)PartyCrossReferenceDBA.class;
/*      */         }
/*      */       };
/* 1634 */     addAdapter("dtv.xst.dao.crm.PartyCrossReferenceId", generator);
/* 1635 */     addAdapter("dtv.xst.dao.crm.impl.PartyCrossReferenceDAO", generator);
/* 1636 */     addAdapter("dtv.xst.dao.crm.IPartyCrossReference", generator);
/* 1637 */     addAdapter("PartyCrossReference", generator);
/* 1638 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1640 */           return (Class)PartyEmailDBA.class;
/*      */         }
/*      */       };
/* 1643 */     addAdapter("dtv.xst.dao.crm.PartyEmailId", generator);
/* 1644 */     addAdapter("dtv.xst.dao.crm.impl.PartyEmailDAO", generator);
/* 1645 */     addAdapter("dtv.xst.dao.crm.IPartyEmail", generator);
/* 1646 */     addAdapter("PartyEmail", generator);
/* 1647 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1649 */           return (Class)PartyIdCrossReferenceDBA.class;
/*      */         }
/*      */       };
/* 1652 */     addAdapter("dtv.xst.dao.crm.PartyIdCrossReferenceId", generator);
/* 1653 */     addAdapter("dtv.xst.dao.crm.impl.PartyIdCrossReferenceDAO", generator);
/* 1654 */     addAdapter("dtv.xst.dao.crm.IPartyIdCrossReference", generator);
/* 1655 */     addAdapter("PartyIdCrossReference", generator);
/* 1656 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1658 */           return (Class)PartyTelephoneDBA.class;
/*      */         }
/*      */       };
/* 1661 */     addAdapter("dtv.xst.dao.crm.PartyTelephoneId", generator);
/* 1662 */     addAdapter("dtv.xst.dao.crm.impl.PartyTelephoneDAO", generator);
/* 1663 */     addAdapter("dtv.xst.dao.crm.IPartyTelephone", generator);
/* 1664 */     addAdapter("PartyTelephone", generator);
/* 1665 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1667 */           return (Class)CustomerAccountDBA.class;
/*      */         }
/*      */       };
/* 1670 */     addAdapter("dtv.xst.dao.cat.CustomerAccountId", generator);
/* 1671 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountDAO", generator);
/* 1672 */     addAdapter("dtv.xst.dao.cat.ICustomerAccount", generator);
/* 1673 */     addAdapter("CustomerAccount", generator);
/* 1674 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1676 */           return (Class)AwardAccountDBA.class;
/*      */         }
/*      */       };
/* 1679 */     addAdapter("dtv.xst.dao.cat.AwardAccountId", generator);
/* 1680 */     addAdapter("dtv.xst.dao.cat.impl.AwardAccountDAO", generator);
/* 1681 */     addAdapter("dtv.xst.dao.cat.IAwardAccount", generator);
/* 1682 */     addAdapter("AwardAccount", generator);
/* 1683 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1685 */           return (Class)AwardAccountCouponDBA.class;
/*      */         }
/*      */       };
/* 1688 */     addAdapter("dtv.xst.dao.cat.AwardAccountCouponId", generator);
/* 1689 */     addAdapter("dtv.xst.dao.cat.impl.AwardAccountCouponDAO", generator);
/* 1690 */     addAdapter("dtv.xst.dao.cat.IAwardAccountCoupon", generator);
/* 1691 */     addAdapter("AwardAccountCoupon", generator);
/* 1692 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1694 */           return (Class)ChargeAccountInvoiceDBA.class;
/*      */         }
/*      */       };
/* 1697 */     addAdapter("dtv.xst.dao.cat.ChargeAccountInvoiceId", generator);
/* 1698 */     addAdapter("dtv.xst.dao.cat.impl.ChargeAccountInvoiceDAO", generator);
/* 1699 */     addAdapter("dtv.xst.dao.cat.IChargeAccountInvoice", generator);
/* 1700 */     addAdapter("ChargeAccountInvoice", generator);
/* 1701 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1703 */           return (Class)ChargeAccountUserDBA.class;
/*      */         }
/*      */       };
/* 1706 */     addAdapter("dtv.xst.dao.cat.ChargeAccountUserId", generator);
/* 1707 */     addAdapter("dtv.xst.dao.cat.impl.ChargeAccountUserDAO", generator);
/* 1708 */     addAdapter("dtv.xst.dao.cat.IChargeAccountUser", generator);
/* 1709 */     addAdapter("ChargeAccountUser", generator);
/* 1710 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1712 */           return (Class)CustomerAccountJournalDBA.class;
/*      */         }
/*      */       };
/* 1715 */     addAdapter("dtv.xst.dao.cat.CustomerAccountJournalId", generator);
/* 1716 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountJournalDAO", generator);
/* 1717 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountJournal", generator);
/* 1718 */     addAdapter("CustomerAccountJournal", generator);
/* 1719 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1721 */           return (Class)CustomerItemAccountActivityDBA.class;
/*      */         }
/*      */       };
/* 1724 */     addAdapter("dtv.xst.dao.cat.CustomerItemAccountActivityId", generator);
/* 1725 */     addAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountActivityDAO", generator);
/* 1726 */     addAdapter("dtv.xst.dao.cat.ICustomerItemAccountActivity", generator);
/* 1727 */     addAdapter("CustomerItemAccountActivity", generator);
/* 1728 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1730 */           return (Class)CustomerItemAccountDetailDBA.class;
/*      */         }
/*      */       };
/* 1733 */     addAdapter("dtv.xst.dao.cat.CustomerItemAccountDetailId", generator);
/* 1734 */     addAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO", generator);
/* 1735 */     addAdapter("dtv.xst.dao.cat.ICustomerItemAccountDetail", generator);
/* 1736 */     addAdapter("CustomerItemAccountDetail", generator);
/* 1737 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1739 */           return (Class)CustomerItemAccountJournalDBA.class;
/*      */         }
/*      */       };
/* 1742 */     addAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountJournalDAO", generator);
/* 1743 */     addAdapter("dtv.xst.dao.cat.ICustomerItemAccountJournal", generator);
/* 1744 */     addAdapter("CustomerItemAccountJournal", generator);
/* 1745 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1747 */           return (Class)CustomerLoyaltyAccountDBA.class;
/*      */         }
/*      */       };
/* 1750 */     addAdapter("dtv.xst.dao.cat.CustomerLoyaltyAccountId", generator);
/* 1751 */     addAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyAccountDAO", generator);
/* 1752 */     addAdapter("dtv.xst.dao.cat.ICustomerLoyaltyAccount", generator);
/* 1753 */     addAdapter("CustomerLoyaltyAccount", generator);
/* 1754 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1756 */           return (Class)CustomerLoyaltyCardDBA.class;
/*      */         }
/*      */       };
/* 1759 */     addAdapter("dtv.xst.dao.cat.CustomerLoyaltyCardId", generator);
/* 1760 */     addAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyCardDAO", generator);
/* 1761 */     addAdapter("dtv.xst.dao.cat.ICustomerLoyaltyCard", generator);
/* 1762 */     addAdapter("CustomerLoyaltyCard", generator);
/* 1763 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1765 */           return (Class)DeliveryModifierDBA.class;
/*      */         }
/*      */       };
/* 1768 */     addAdapter("dtv.xst.dao.cat.DeliveryModifierId", generator);
/* 1769 */     addAdapter("dtv.xst.dao.cat.impl.DeliveryModifierDAO", generator);
/* 1770 */     addAdapter("dtv.xst.dao.cat.IDeliveryModifier", generator);
/* 1771 */     addAdapter("DeliveryModifier", generator);
/* 1772 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1774 */           return (Class)EscrowAccountDBA.class;
/*      */         }
/*      */       };
/* 1777 */     addAdapter("dtv.xst.dao.cat.EscrowAccountId", generator);
/* 1778 */     addAdapter("dtv.xst.dao.cat.impl.EscrowAccountDAO", generator);
/* 1779 */     addAdapter("dtv.xst.dao.cat.IEscrowAccount", generator);
/* 1780 */     addAdapter("EscrowAccount", generator);
/* 1781 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1783 */           return (Class)ChargeAccountHistoryDBA.class;
/*      */         }
/*      */       };
/* 1786 */     addAdapter("dtv.xst.dao.cat.ChargeAccountHistoryId", generator);
/* 1787 */     addAdapter("dtv.xst.dao.cat.impl.ChargeAccountHistoryDAO", generator);
/* 1788 */     addAdapter("dtv.xst.dao.cat.IChargeAccountHistory", generator);
/* 1789 */     addAdapter("ChargeAccountHistory", generator);
/* 1790 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1792 */           return (Class)CustomerAccountNoteDBA.class;
/*      */         }
/*      */       };
/* 1795 */     addAdapter("dtv.xst.dao.cat.CustomerAccountNoteId", generator);
/* 1796 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountNoteDAO", generator);
/* 1797 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountNote", generator);
/* 1798 */     addAdapter("CustomerAccountNote", generator);
/* 1799 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1801 */           return (Class)CustomerAccountPlanDBA.class;
/*      */         }
/*      */       };
/* 1804 */     addAdapter("dtv.xst.dao.cat.CustomerAccountPlanId", generator);
/* 1805 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountPlanDAO", generator);
/* 1806 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountPlan", generator);
/* 1807 */     addAdapter("CustomerAccountPlan", generator);
/* 1808 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1810 */           return (Class)CustomerConsumerChargeAccountDBA.class;
/*      */         }
/*      */       };
/* 1813 */     addAdapter("dtv.xst.dao.cat.impl.CustomerConsumerChargeAccountDAO", generator);
/* 1814 */     addAdapter("dtv.xst.dao.cat.ICustomerConsumerChargeAccount", generator);
/* 1815 */     addAdapter("CustomerConsumerChargeAccount", generator);
/* 1816 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1818 */           return (Class)CustomerItemAccountDBA.class;
/*      */         }
/*      */       };
/* 1821 */     addAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDAO", generator);
/* 1822 */     addAdapter("dtv.xst.dao.cat.ICustomerItemAccount", generator);
/* 1823 */     addAdapter("CustomerItemAccount", generator);
/* 1824 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1826 */           return (Class)EscrowAccountActivityDBA.class;
/*      */         }
/*      */       };
/* 1829 */     addAdapter("dtv.xst.dao.cat.EscrowAccountActivityId", generator);
/* 1830 */     addAdapter("dtv.xst.dao.cat.impl.EscrowAccountActivityDAO", generator);
/* 1831 */     addAdapter("dtv.xst.dao.cat.IEscrowAccountActivity", generator);
/* 1832 */     addAdapter("EscrowAccountActivity", generator);
/* 1833 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1835 */           return (Class)PaymentScheduleDBA.class;
/*      */         }
/*      */       };
/* 1838 */     addAdapter("dtv.xst.dao.cat.PaymentScheduleId", generator);
/* 1839 */     addAdapter("dtv.xst.dao.cat.impl.PaymentScheduleDAO", generator);
/* 1840 */     addAdapter("dtv.xst.dao.cat.IPaymentSchedule", generator);
/* 1841 */     addAdapter("PaymentSchedule", generator);
/* 1842 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1844 */           return (Class)CustomerAccountAuthorizationDBA.class;
/*      */         }
/*      */       };
/* 1847 */     addAdapter("dtv.xst.dao.cat.CustomerAccountAuthorizationId", generator);
/* 1848 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountAuthorizationDAO", generator);
/* 1849 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountAuthorization", generator);
/* 1850 */     addAdapter("CustomerAccountAuthorization", generator);
/* 1851 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1853 */           return (Class)OrderLineDBA.class;
/*      */         }
/*      */       };
/* 1856 */     addAdapter("dtv.xst.dao.xom.OrderLineId", generator);
/* 1857 */     addAdapter("dtv.xst.dao.xom.impl.OrderLineDAO", generator);
/* 1858 */     addAdapter("dtv.xst.dao.xom.IOrderLine", generator);
/* 1859 */     addAdapter("OrderLine", generator);
/* 1860 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1862 */           return (Class)OrderDBA.class;
/*      */         }
/*      */       };
/* 1865 */     addAdapter("dtv.xst.dao.xom.OrderId", generator);
/* 1866 */     addAdapter("dtv.xst.dao.xom.impl.OrderDAO", generator);
/* 1867 */     addAdapter("dtv.xst.dao.xom.IOrder", generator);
/* 1868 */     addAdapter("Order", generator);
/* 1869 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1871 */           return (Class)ItemModifierDBA.class;
/*      */         }
/*      */       };
/* 1874 */     addAdapter("dtv.xst.dao.xom.ItemModifierId", generator);
/* 1875 */     addAdapter("dtv.xst.dao.xom.impl.ItemModifierDAO", generator);
/* 1876 */     addAdapter("dtv.xst.dao.xom.IItemModifier", generator);
/* 1877 */     addAdapter("ItemModifier", generator);
/* 1878 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1880 */           return (Class)AddressModifierDBA.class;
/*      */         }
/*      */       };
/* 1883 */     addAdapter("dtv.xst.dao.xom.AddressModifierId", generator);
/* 1884 */     addAdapter("dtv.xst.dao.xom.impl.AddressModifierDAO", generator);
/* 1885 */     addAdapter("dtv.xst.dao.xom.IAddressModifier", generator);
/* 1886 */     addAdapter("AddressModifier", generator);
/* 1887 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1889 */           return (Class)BalanceModifierDBA.class;
/*      */         }
/*      */       };
/* 1892 */     addAdapter("dtv.xst.dao.xom.BalanceModifierId", generator);
/* 1893 */     addAdapter("dtv.xst.dao.xom.impl.BalanceModifierDAO", generator);
/* 1894 */     addAdapter("dtv.xst.dao.xom.IBalanceModifier", generator);
/* 1895 */     addAdapter("BalanceModifier", generator);
/* 1896 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1898 */           return (Class)CustomerModifierDBA.class;
/*      */         }
/*      */       };
/* 1901 */     addAdapter("dtv.xst.dao.xom.CustomerModifierId", generator);
/* 1902 */     addAdapter("dtv.xst.dao.xom.impl.CustomerModifierDAO", generator);
/* 1903 */     addAdapter("dtv.xst.dao.xom.ICustomerModifier", generator);
/* 1904 */     addAdapter("CustomerModifier", generator);
/* 1905 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1907 */           return (Class)CustomizationModifierDBA.class;
/*      */         }
/*      */       };
/* 1910 */     addAdapter("dtv.xst.dao.xom.CustomizationModifierId", generator);
/* 1911 */     addAdapter("dtv.xst.dao.xom.impl.CustomizationModifierDAO", generator);
/* 1912 */     addAdapter("dtv.xst.dao.xom.ICustomizationModifier", generator);
/* 1913 */     addAdapter("CustomizationModifier", generator);
/* 1914 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1916 */           return (Class)FeeModifierDBA.class;
/*      */         }
/*      */       };
/* 1919 */     addAdapter("dtv.xst.dao.xom.FeeModifierId", generator);
/* 1920 */     addAdapter("dtv.xst.dao.xom.impl.FeeModifierDAO", generator);
/* 1921 */     addAdapter("dtv.xst.dao.xom.IFeeModifier", generator);
/* 1922 */     addAdapter("FeeModifier", generator);
/* 1923 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1925 */           return (Class)FulfillmentModifierDBA.class;
/*      */         }
/*      */       };
/* 1928 */     addAdapter("dtv.xst.dao.xom.FulfillmentModifierId", generator);
/* 1929 */     addAdapter("dtv.xst.dao.xom.impl.FulfillmentModifierDAO", generator);
/* 1930 */     addAdapter("dtv.xst.dao.xom.IFulfillmentModifier", generator);
/* 1931 */     addAdapter("FulfillmentModifier", generator);
/* 1932 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1934 */           return (Class)OrderFeeDBA.class;
/*      */         }
/*      */       };
/* 1937 */     addAdapter("dtv.xst.dao.xom.OrderFeeId", generator);
/* 1938 */     addAdapter("dtv.xst.dao.xom.impl.OrderFeeDAO", generator);
/* 1939 */     addAdapter("dtv.xst.dao.xom.IOrderFee", generator);
/* 1940 */     addAdapter("OrderFee", generator);
/* 1941 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1943 */           return (Class)OrderModifierDBA.class;
/*      */         }
/*      */       };
/* 1946 */     addAdapter("dtv.xst.dao.xom.OrderModifierId", generator);
/* 1947 */     addAdapter("dtv.xst.dao.xom.impl.OrderModifierDAO", generator);
/* 1948 */     addAdapter("dtv.xst.dao.xom.IOrderModifier", generator);
/* 1949 */     addAdapter("OrderModifier", generator);
/* 1950 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1952 */           return (Class)OrderPaymentDBA.class;
/*      */         }
/*      */       };
/* 1955 */     addAdapter("dtv.xst.dao.xom.OrderPaymentId", generator);
/* 1956 */     addAdapter("dtv.xst.dao.xom.impl.OrderPaymentDAO", generator);
/* 1957 */     addAdapter("dtv.xst.dao.xom.IOrderPayment", generator);
/* 1958 */     addAdapter("OrderPayment", generator);
/* 1959 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1961 */           return (Class)SourceModifierDBA.class;
/*      */         }
/*      */       };
/* 1964 */     addAdapter("dtv.xst.dao.xom.SourceModifierId", generator);
/* 1965 */     addAdapter("dtv.xst.dao.xom.impl.SourceModifierDAO", generator);
/* 1966 */     addAdapter("dtv.xst.dao.xom.ISourceModifier", generator);
/* 1967 */     addAdapter("SourceModifier", generator);
/* 1968 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1970 */           return (Class)DealDBA.class;
/*      */         }
/*      */       };
/* 1973 */     addAdapter("dtv.xst.dao.prc.DealId", generator);
/* 1974 */     addAdapter("dtv.xst.dao.prc.impl.DealDAO", generator);
/* 1975 */     addAdapter("dtv.xst.dao.prc.IDeal", generator);
/* 1976 */     addAdapter("Deal", generator);
/* 1977 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1979 */           return (Class)DealCustomerGroupsDBA.class;
/*      */         }
/*      */       };
/* 1982 */     addAdapter("dtv.xst.dao.prc.DealCustomerGroupsId", generator);
/* 1983 */     addAdapter("dtv.xst.dao.prc.impl.DealCustomerGroupsDAO", generator);
/* 1984 */     addAdapter("dtv.xst.dao.prc.IDealCustomerGroups", generator);
/* 1985 */     addAdapter("DealCustomerGroups", generator);
/* 1986 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1988 */           return (Class)DealDocumentXrefDBA.class;
/*      */         }
/*      */       };
/* 1991 */     addAdapter("dtv.xst.dao.prc.DealDocumentXrefId", generator);
/* 1992 */     addAdapter("dtv.xst.dao.prc.impl.DealDocumentXrefDAO", generator);
/* 1993 */     addAdapter("dtv.xst.dao.prc.IDealDocumentXref", generator);
/* 1994 */     addAdapter("DealDocumentXref", generator);
/* 1995 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 1997 */           return (Class)DealFieldTestDBA.class;
/*      */         }
/*      */       };
/* 2000 */     addAdapter("dtv.xst.dao.prc.DealFieldTestId", generator);
/* 2001 */     addAdapter("dtv.xst.dao.prc.impl.DealFieldTestDAO", generator);
/* 2002 */     addAdapter("dtv.xst.dao.prc.IDealFieldTest", generator);
/* 2003 */     addAdapter("DealFieldTest", generator);
/* 2004 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2006 */           return (Class)DealItemActionDBA.class;
/*      */         }
/*      */       };
/* 2009 */     addAdapter("dtv.xst.dao.prc.DealItemActionId", generator);
/* 2010 */     addAdapter("dtv.xst.dao.prc.impl.DealItemActionDAO", generator);
/* 2011 */     addAdapter("dtv.xst.dao.prc.IDealItemAction", generator);
/* 2012 */     addAdapter("DealItemAction", generator);
/* 2013 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2015 */           return (Class)DealTriggerDBA.class;
/*      */         }
/*      */       };
/* 2018 */     addAdapter("dtv.xst.dao.prc.DealTriggerId", generator);
/* 2019 */     addAdapter("dtv.xst.dao.prc.impl.DealTriggerDAO", generator);
/* 2020 */     addAdapter("dtv.xst.dao.prc.IDealTrigger", generator);
/* 2021 */     addAdapter("DealTrigger", generator);
/* 2022 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2024 */           return (Class)DealWeekDBA.class;
/*      */         }
/*      */       };
/* 2027 */     addAdapter("dtv.xst.dao.prc.DealWeekId", generator);
/* 2028 */     addAdapter("dtv.xst.dao.prc.impl.DealWeekDAO", generator);
/* 2029 */     addAdapter("dtv.xst.dao.prc.IDealWeek", generator);
/* 2030 */     addAdapter("DealWeek", generator);
/* 2031 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2033 */           return (Class)PayrollDBA.class;
/*      */         }
/*      */       };
/* 2036 */     addAdapter("dtv.xst.dao.thr.PayrollId", generator);
/* 2037 */     addAdapter("dtv.xst.dao.thr.impl.PayrollDAO", generator);
/* 2038 */     addAdapter("dtv.xst.dao.thr.IPayroll", generator);
/* 2039 */     addAdapter("Payroll", generator);
/* 2040 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2042 */           return (Class)PayrollCategoryDBA.class;
/*      */         }
/*      */       };
/* 2045 */     addAdapter("dtv.xst.dao.thr.PayrollCategoryId", generator);
/* 2046 */     addAdapter("dtv.xst.dao.thr.impl.PayrollCategoryDAO", generator);
/* 2047 */     addAdapter("dtv.xst.dao.thr.IPayrollCategory", generator);
/* 2048 */     addAdapter("PayrollCategory", generator);
/* 2049 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2051 */           return (Class)PayrollHeaderDBA.class;
/*      */         }
/*      */       };
/* 2054 */     addAdapter("dtv.xst.dao.thr.PayrollHeaderId", generator);
/* 2055 */     addAdapter("dtv.xst.dao.thr.impl.PayrollHeaderDAO", generator);
/* 2056 */     addAdapter("dtv.xst.dao.thr.IPayrollHeader", generator);
/* 2057 */     addAdapter("PayrollHeader", generator);
/* 2058 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2060 */           return (Class)PayrollNotesDBA.class;
/*      */         }
/*      */       };
/* 2063 */     addAdapter("dtv.xst.dao.thr.PayrollNotesId", generator);
/* 2064 */     addAdapter("dtv.xst.dao.thr.impl.PayrollNotesDAO", generator);
/* 2065 */     addAdapter("dtv.xst.dao.thr.IPayrollNotes", generator);
/* 2066 */     addAdapter("PayrollNotes", generator);
/* 2067 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2069 */           return (Class)TimecardEntryDBA.class;
/*      */         }
/*      */       };
/* 2072 */     addAdapter("dtv.xst.dao.thr.TimecardEntryId", generator);
/* 2073 */     addAdapter("dtv.xst.dao.thr.impl.TimecardEntryDAO", generator);
/* 2074 */     addAdapter("dtv.xst.dao.thr.ITimecardEntry", generator);
/* 2075 */     addAdapter("TimecardEntry", generator);
/* 2076 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2078 */           return (Class)TimecardEntryCommentDBA.class;
/*      */         }
/*      */       };
/* 2081 */     addAdapter("dtv.xst.dao.thr.TimecardEntryCommentId", generator);
/* 2082 */     addAdapter("dtv.xst.dao.thr.impl.TimecardEntryCommentDAO", generator);
/* 2083 */     addAdapter("dtv.xst.dao.thr.ITimecardEntryComment", generator);
/* 2084 */     addAdapter("TimecardEntryComment", generator);
/* 2085 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2087 */           return (Class)TimecardJournalDBA.class;
/*      */         }
/*      */       };
/* 2090 */     addAdapter("dtv.xst.dao.thr.TimecardJournalId", generator);
/* 2091 */     addAdapter("dtv.xst.dao.thr.impl.TimecardJournalDAO", generator);
/* 2092 */     addAdapter("dtv.xst.dao.thr.ITimecardJournal", generator);
/* 2093 */     addAdapter("TimecardJournal", generator);
/* 2094 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2096 */           return (Class)TimeclockTransactionDBA.class;
/*      */         }
/*      */       };
/* 2099 */     addAdapter("dtv.xst.dao.thr.impl.TimeclockTransactionDAO", generator);
/* 2100 */     addAdapter("dtv.xst.dao.thr.ITimeclockTransaction", generator);
/* 2101 */     addAdapter("TimeclockTransaction", generator);
/* 2102 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2104 */           return (Class)TenderOptionsDBA.class;
/*      */         }
/*      */       };
/* 2107 */     addAdapter("dtv.xst.dao.tnd.TenderOptionsId", generator);
/* 2108 */     addAdapter("dtv.xst.dao.tnd.impl.TenderOptionsDAO", generator);
/* 2109 */     addAdapter("dtv.xst.dao.tnd.ITenderOptions", generator);
/* 2110 */     addAdapter("TenderOptions", generator);
/* 2111 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2113 */           return (Class)TenderDBA.class;
/*      */         }
/*      */       };
/* 2116 */     addAdapter("dtv.xst.dao.tnd.TenderId", generator);
/* 2117 */     addAdapter("dtv.xst.dao.tnd.impl.TenderDAO", generator);
/* 2118 */     addAdapter("dtv.xst.dao.tnd.ITender", generator);
/* 2119 */     addAdapter("Tender", generator);
/* 2120 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2122 */           return (Class)TenderAvailabilityDBA.class;
/*      */         }
/*      */       };
/* 2125 */     addAdapter("dtv.xst.dao.tnd.TenderAvailabilityId", generator);
/* 2126 */     addAdapter("dtv.xst.dao.tnd.impl.TenderAvailabilityDAO", generator);
/* 2127 */     addAdapter("dtv.xst.dao.tnd.ITenderAvailability", generator);
/* 2128 */     addAdapter("TenderAvailability", generator);
/* 2129 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2131 */           return (Class)TenderDenominationDBA.class;
/*      */         }
/*      */       };
/* 2134 */     addAdapter("dtv.xst.dao.tnd.TenderDenominationId", generator);
/* 2135 */     addAdapter("dtv.xst.dao.tnd.impl.TenderDenominationDAO", generator);
/* 2136 */     addAdapter("dtv.xst.dao.tnd.ITenderDenomination", generator);
/* 2137 */     addAdapter("TenderDenomination", generator);
/* 2138 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2140 */           return (Class)TenderExchangeRateDBA.class;
/*      */         }
/*      */       };
/* 2143 */     addAdapter("dtv.xst.dao.tnd.TenderExchangeRateId", generator);
/* 2144 */     addAdapter("dtv.xst.dao.tnd.impl.TenderExchangeRateDAO", generator);
/* 2145 */     addAdapter("dtv.xst.dao.tnd.ITenderExchangeRate", generator);
/* 2146 */     addAdapter("TenderExchangeRate", generator);
/* 2147 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2149 */           return (Class)TenderTypeDBA.class;
/*      */         }
/*      */       };
/* 2152 */     addAdapter("dtv.xst.dao.tnd.TenderTypeId", generator);
/* 2153 */     addAdapter("dtv.xst.dao.tnd.impl.TenderTypeDAO", generator);
/* 2154 */     addAdapter("dtv.xst.dao.tnd.ITenderType", generator);
/* 2155 */     addAdapter("TenderType", generator);
/* 2156 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2158 */           return (Class)TenderUserSettingsDBA.class;
/*      */         }
/*      */       };
/* 2161 */     addAdapter("dtv.xst.dao.tnd.TenderUserSettingsId", generator);
/* 2162 */     addAdapter("dtv.xst.dao.tnd.impl.TenderUserSettingsDAO", generator);
/* 2163 */     addAdapter("dtv.xst.dao.tnd.ITenderUserSettings", generator);
/* 2164 */     addAdapter("TenderUserSettings", generator);
/* 2165 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2167 */           return (Class)IpCashDrawerDeviceDBA.class;
/*      */         }
/*      */       };
/* 2170 */     addAdapter("dtv.xst.dao.ctl.IpCashDrawerDeviceId", generator);
/* 2171 */     addAdapter("dtv.xst.dao.ctl.impl.IpCashDrawerDeviceDAO", generator);
/* 2172 */     addAdapter("dtv.xst.dao.ctl.IIpCashDrawerDevice", generator);
/* 2173 */     addAdapter("IpCashDrawerDevice", generator);
/* 2174 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2176 */           return (Class)CheetahClientDeviceAccessDBA.class;
/*      */         }
/*      */       };
/* 2179 */     addAdapter("dtv.xst.dao.ctl.CheetahClientDeviceAccessId", generator);
/* 2180 */     addAdapter("dtv.xst.dao.ctl.impl.CheetahClientDeviceAccessDAO", generator);
/* 2181 */     addAdapter("dtv.xst.dao.ctl.ICheetahClientDeviceAccess", generator);
/* 2182 */     addAdapter("CheetahClientDeviceAccess", generator);
/* 2183 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2185 */           return (Class)EventLogEntryDBA.class;
/*      */         }
/*      */       };
/* 2188 */     addAdapter("dtv.xst.dao.ctl.EventLogEntryId", generator);
/* 2189 */     addAdapter("dtv.xst.dao.ctl.impl.EventLogEntryDAO", generator);
/* 2190 */     addAdapter("dtv.xst.dao.ctl.IEventLogEntry", generator);
/* 2191 */     addAdapter("EventLogEntry", generator);
/* 2192 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2194 */           return (Class)DataLoaderFailureDBA.class;
/*      */         }
/*      */       };
/* 2197 */     addAdapter("dtv.xst.dao.ctl.DataLoaderFailureId", generator);
/* 2198 */     addAdapter("dtv.xst.dao.ctl.impl.DataLoaderFailureDAO", generator);
/* 2199 */     addAdapter("dtv.xst.dao.ctl.IDataLoaderFailure", generator);
/* 2200 */     addAdapter("DataLoaderFailure", generator);
/* 2201 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2203 */           return (Class)DataLoaderSummaryDBA.class;
/*      */         }
/*      */       };
/* 2206 */     addAdapter("dtv.xst.dao.ctl.DataLoaderSummaryId", generator);
/* 2207 */     addAdapter("dtv.xst.dao.ctl.impl.DataLoaderSummaryDAO", generator);
/* 2208 */     addAdapter("dtv.xst.dao.ctl.IDataLoaderSummary", generator);
/* 2209 */     addAdapter("DataLoaderSummary", generator);
/* 2210 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2212 */           return (Class)DeviceRegistrationDBA.class;
/*      */         }
/*      */       };
/* 2215 */     addAdapter("dtv.xst.dao.ctl.DeviceRegistrationId", generator);
/* 2216 */     addAdapter("dtv.xst.dao.ctl.impl.DeviceRegistrationDAO", generator);
/* 2217 */     addAdapter("dtv.xst.dao.ctl.IDeviceRegistration", generator);
/* 2218 */     addAdapter("DeviceRegistration", generator);
/* 2219 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2221 */           return (Class)VersionDBA.class;
/*      */         }
/*      */       };
/* 2224 */     addAdapter("dtv.xst.dao.ctl.VersionId", generator);
/* 2225 */     addAdapter("dtv.xst.dao.ctl.impl.VersionDAO", generator);
/* 2226 */     addAdapter("dtv.xst.dao.ctl.IVersion", generator);
/* 2227 */     addAdapter("Version", generator);
/* 2228 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2230 */           return (Class)RetailLocationDBA.class;
/*      */         }
/*      */       };
/* 2233 */     addAdapter("dtv.xst.dao.loc.RetailLocationId", generator);
/* 2234 */     addAdapter("dtv.xst.dao.loc.impl.RetailLocationDAO", generator);
/* 2235 */     addAdapter("dtv.xst.dao.loc.IRetailLocation", generator);
/* 2236 */     addAdapter("RetailLocation", generator);
/* 2237 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2239 */           return (Class)OrgHierarchyDBA.class;
/*      */         }
/*      */       };
/* 2242 */     addAdapter("dtv.xst.dao.loc.OrgHierarchyId", generator);
/* 2243 */     addAdapter("dtv.xst.dao.loc.impl.OrgHierarchyDAO", generator);
/* 2244 */     addAdapter("dtv.xst.dao.loc.IOrgHierarchy", generator);
/* 2245 */     addAdapter("OrgHierarchy", generator);
/* 2246 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2248 */           return (Class)PricingHierarchyDBA.class;
/*      */         }
/*      */       };
/* 2251 */     addAdapter("dtv.xst.dao.loc.PricingHierarchyId", generator);
/* 2252 */     addAdapter("dtv.xst.dao.loc.impl.PricingHierarchyDAO", generator);
/* 2253 */     addAdapter("dtv.xst.dao.loc.IPricingHierarchy", generator);
/* 2254 */     addAdapter("PricingHierarchy", generator);
/* 2255 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2257 */           return (Class)WorkstationDBA.class;
/*      */         }
/*      */       };
/* 2260 */     addAdapter("dtv.xst.dao.loc.WorkstationId", generator);
/* 2261 */     addAdapter("dtv.xst.dao.loc.impl.WorkstationDAO", generator);
/* 2262 */     addAdapter("dtv.xst.dao.loc.IWorkstation", generator);
/* 2263 */     addAdapter("Workstation", generator);
/* 2264 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2266 */           return (Class)CloseDatesDBA.class;
/*      */         }
/*      */       };
/* 2269 */     addAdapter("dtv.xst.dao.loc.CloseDatesId", generator);
/* 2270 */     addAdapter("dtv.xst.dao.loc.impl.CloseDatesDAO", generator);
/* 2271 */     addAdapter("dtv.xst.dao.loc.ICloseDates", generator);
/* 2272 */     addAdapter("CloseDates", generator);
/* 2273 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2275 */           return (Class)ClosingMessageDBA.class;
/*      */         }
/*      */       };
/* 2278 */     addAdapter("dtv.xst.dao.loc.ClosingMessageId", generator);
/* 2279 */     addAdapter("dtv.xst.dao.loc.impl.ClosingMessageDAO", generator);
/* 2280 */     addAdapter("dtv.xst.dao.loc.IClosingMessage", generator);
/* 2281 */     addAdapter("ClosingMessage", generator);
/* 2282 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2284 */           return (Class)CycleQuestionDBA.class;
/*      */         }
/*      */       };
/* 2287 */     addAdapter("dtv.xst.dao.loc.CycleQuestionId", generator);
/* 2288 */     addAdapter("dtv.xst.dao.loc.impl.CycleQuestionDAO", generator);
/* 2289 */     addAdapter("dtv.xst.dao.loc.ICycleQuestion", generator);
/* 2290 */     addAdapter("CycleQuestion", generator);
/* 2291 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2293 */           return (Class)CycleQuestionAnswerDBA.class;
/*      */         }
/*      */       };
/* 2296 */     addAdapter("dtv.xst.dao.loc.CycleQuestionAnswerId", generator);
/* 2297 */     addAdapter("dtv.xst.dao.loc.impl.CycleQuestionAnswerDAO", generator);
/* 2298 */     addAdapter("dtv.xst.dao.loc.ICycleQuestionAnswer", generator);
/* 2299 */     addAdapter("CycleQuestionAnswer", generator);
/* 2300 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2302 */           return (Class)CycleQuestionChoiceDBA.class;
/*      */         }
/*      */       };
/* 2305 */     addAdapter("dtv.xst.dao.loc.CycleQuestionChoiceId", generator);
/* 2306 */     addAdapter("dtv.xst.dao.loc.impl.CycleQuestionChoiceDAO", generator);
/* 2307 */     addAdapter("dtv.xst.dao.loc.ICycleQuestionChoice", generator);
/* 2308 */     addAdapter("CycleQuestionChoice", generator);
/* 2309 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2311 */           return (Class)StateJournalDBA.class;
/*      */         }
/*      */       };
/* 2314 */     addAdapter("dtv.xst.dao.loc.StateJournalId", generator);
/* 2315 */     addAdapter("dtv.xst.dao.loc.impl.StateJournalDAO", generator);
/* 2316 */     addAdapter("dtv.xst.dao.loc.IStateJournal", generator);
/* 2317 */     addAdapter("StateJournal", generator);
/* 2318 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2320 */           return (Class)FlightInformationDBA.class;
/*      */         }
/*      */       };
/* 2323 */     addAdapter("dtv.xst.dao.com.FlightInformationId", generator);
/* 2324 */     addAdapter("dtv.xst.dao.com.impl.FlightInformationDAO", generator);
/* 2325 */     addAdapter("dtv.xst.dao.com.IFlightInformation", generator);
/* 2326 */     addAdapter("FlightInformation", generator);
/* 2327 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2329 */           return (Class)AirportDBA.class;
/*      */         }
/*      */       };
/* 2332 */     addAdapter("dtv.xst.dao.com.AirportId", generator);
/* 2333 */     addAdapter("dtv.xst.dao.com.impl.AirportDAO", generator);
/* 2334 */     addAdapter("dtv.xst.dao.com.IAirport", generator);
/* 2335 */     addAdapter("Airport", generator);
/* 2336 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2338 */           return (Class)ButtonGridDBA.class;
/*      */         }
/*      */       };
/* 2341 */     addAdapter("dtv.xst.dao.com.ButtonGridId", generator);
/* 2342 */     addAdapter("dtv.xst.dao.com.impl.ButtonGridDAO", generator);
/* 2343 */     addAdapter("dtv.xst.dao.com.IButtonGrid", generator);
/* 2344 */     addAdapter("ButtonGrid", generator);
/* 2345 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2347 */           return (Class)CodeValueDBA.class;
/*      */         }
/*      */       };
/* 2350 */     addAdapter("dtv.xst.dao.com.CodeValueId", generator);
/* 2351 */     addAdapter("dtv.xst.dao.com.impl.CodeValueDAO", generator);
/* 2352 */     addAdapter("dtv.xst.dao.com.ICodeValue", generator);
/* 2353 */     addAdapter("CodeValue", generator);
/* 2354 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2356 */           return (Class)DatabaseTranslationDBA.class;
/*      */         }
/*      */       };
/* 2359 */     addAdapter("dtv.xst.dao.com.DatabaseTranslationId", generator);
/* 2360 */     addAdapter("dtv.xst.dao.com.impl.DatabaseTranslationDAO", generator);
/* 2361 */     addAdapter("dtv.xst.dao.com.IDatabaseTranslation", generator);
/* 2362 */     addAdapter("DatabaseTranslation", generator);
/* 2363 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2365 */           return (Class)SequenceDBA.class;
/*      */         }
/*      */       };
/* 2368 */     addAdapter("dtv.xst.dao.com.SequenceId", generator);
/* 2369 */     addAdapter("dtv.xst.dao.com.impl.SequenceDAO", generator);
/* 2370 */     addAdapter("dtv.xst.dao.com.ISequence", generator);
/* 2371 */     addAdapter("Sequence", generator);
/* 2372 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2374 */           return (Class)AddressDBA.class;
/*      */         }
/*      */       };
/* 2377 */     addAdapter("dtv.xst.dao.com.AddressId", generator);
/* 2378 */     addAdapter("dtv.xst.dao.com.impl.AddressDAO", generator);
/* 2379 */     addAdapter("dtv.xst.dao.com.IAddress", generator);
/* 2380 */     addAdapter("Address", generator);
/* 2381 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2383 */           return (Class)AddressCountryDBA.class;
/*      */         }
/*      */       };
/* 2386 */     addAdapter("dtv.xst.dao.com.AddressCountryId", generator);
/* 2387 */     addAdapter("dtv.xst.dao.com.impl.AddressCountryDAO", generator);
/* 2388 */     addAdapter("dtv.xst.dao.com.IAddressCountry", generator);
/* 2389 */     addAdapter("AddressCountry", generator);
/* 2390 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2392 */           return (Class)AddressPostalCodeDBA.class;
/*      */         }
/*      */       };
/* 2395 */     addAdapter("dtv.xst.dao.com.AddressPostalCodeId", generator);
/* 2396 */     addAdapter("dtv.xst.dao.com.impl.AddressPostalCodeDAO", generator);
/* 2397 */     addAdapter("dtv.xst.dao.com.IAddressPostalCode", generator);
/* 2398 */     addAdapter("AddressPostalCode", generator);
/* 2399 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2401 */           return (Class)AddressStateDBA.class;
/*      */         }
/*      */       };
/* 2404 */     addAdapter("dtv.xst.dao.com.AddressStateId", generator);
/* 2405 */     addAdapter("dtv.xst.dao.com.impl.AddressStateDAO", generator);
/* 2406 */     addAdapter("dtv.xst.dao.com.IAddressState", generator);
/* 2407 */     addAdapter("AddressState", generator);
/* 2408 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2410 */           return (Class)CountryReturnMapDBA.class;
/*      */         }
/*      */       };
/* 2413 */     addAdapter("dtv.xst.dao.com.CountryReturnMapId", generator);
/* 2414 */     addAdapter("dtv.xst.dao.com.impl.CountryReturnMapDAO", generator);
/* 2415 */     addAdapter("dtv.xst.dao.com.ICountryReturnMap", generator);
/* 2416 */     addAdapter("CountryReturnMap", generator);
/* 2417 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2419 */           return (Class)ReasonCodeDBA.class;
/*      */         }
/*      */       };
/* 2422 */     addAdapter("dtv.xst.dao.com.ReasonCodeId", generator);
/* 2423 */     addAdapter("dtv.xst.dao.com.impl.ReasonCodeDAO", generator);
/* 2424 */     addAdapter("dtv.xst.dao.com.IReasonCode", generator);
/* 2425 */     addAdapter("ReasonCode", generator);
/* 2426 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2428 */           return (Class)ReceiptTextDBA.class;
/*      */         }
/*      */       };
/* 2431 */     addAdapter("dtv.xst.dao.com.ReceiptTextId", generator);
/* 2432 */     addAdapter("dtv.xst.dao.com.impl.ReceiptTextDAO", generator);
/* 2433 */     addAdapter("dtv.xst.dao.com.IReceiptText", generator);
/* 2434 */     addAdapter("ReceiptText", generator);
/* 2435 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2437 */           return (Class)ReportDataDBA.class;
/*      */         }
/*      */       };
/* 2440 */     addAdapter("dtv.xst.dao.com.ReportDataId", generator);
/* 2441 */     addAdapter("dtv.xst.dao.com.impl.ReportDataDAO", generator);
/* 2442 */     addAdapter("dtv.xst.dao.com.IReportData", generator);
/* 2443 */     addAdapter("ReportData", generator);
/* 2444 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2446 */           return (Class)ReportLookupDBA.class;
/*      */         }
/*      */       };
/* 2449 */     addAdapter("dtv.xst.dao.com.ReportLookupId", generator);
/* 2450 */     addAdapter("dtv.xst.dao.com.impl.ReportLookupDAO", generator);
/* 2451 */     addAdapter("dtv.xst.dao.com.IReportLookup", generator);
/* 2452 */     addAdapter("ReportLookup", generator);
/* 2453 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2455 */           return (Class)SequencePartDBA.class;
/*      */         }
/*      */       };
/* 2458 */     addAdapter("dtv.xst.dao.com.SequencePartId", generator);
/* 2459 */     addAdapter("dtv.xst.dao.com.impl.SequencePartDAO", generator);
/* 2460 */     addAdapter("dtv.xst.dao.com.ISequencePart", generator);
/* 2461 */     addAdapter("SequencePart", generator);
/* 2462 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2464 */           return (Class)ShippingCostDBA.class;
/*      */         }
/*      */       };
/* 2467 */     addAdapter("dtv.xst.dao.com.ShippingCostId", generator);
/* 2468 */     addAdapter("dtv.xst.dao.com.impl.ShippingCostDAO", generator);
/* 2469 */     addAdapter("dtv.xst.dao.com.IShippingCost", generator);
/* 2470 */     addAdapter("ShippingCost", generator);
/* 2471 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2473 */           return (Class)TransactionPropertyPromptDBA.class;
/*      */         }
/*      */       };
/* 2476 */     addAdapter("dtv.xst.dao.com.TransactionPropertyPromptId", generator);
/* 2477 */     addAdapter("dtv.xst.dao.com.impl.TransactionPropertyPromptDAO", generator);
/* 2478 */     addAdapter("dtv.xst.dao.com.ITransactionPropertyPrompt", generator);
/* 2479 */     addAdapter("TransactionPropertyPrompt", generator);
/* 2480 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2482 */           return (Class)AirportZoneDBA.class;
/*      */         }
/*      */       };
/* 2485 */     addAdapter("dtv.xst.dao.com.AirportZoneId", generator);
/* 2486 */     addAdapter("dtv.xst.dao.com.impl.AirportZoneDAO", generator);
/* 2487 */     addAdapter("dtv.xst.dao.com.IAirportZone", generator);
/* 2488 */     addAdapter("AirportZone", generator);
/* 2489 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2491 */           return (Class)AirportZoneDetailDBA.class;
/*      */         }
/*      */       };
/* 2494 */     addAdapter("dtv.xst.dao.com.AirportZoneDetailId", generator);
/* 2495 */     addAdapter("dtv.xst.dao.com.impl.AirportZoneDetailDAO", generator);
/* 2496 */     addAdapter("dtv.xst.dao.com.IAirportZoneDetail", generator);
/* 2497 */     addAdapter("AirportZoneDetail", generator);
/* 2498 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2500 */           return (Class)ShippingFeeDBA.class;
/*      */         }
/*      */       };
/* 2503 */     addAdapter("dtv.xst.dao.com.ShippingFeeId", generator);
/* 2504 */     addAdapter("dtv.xst.dao.com.impl.ShippingFeeDAO", generator);
/* 2505 */     addAdapter("dtv.xst.dao.com.IShippingFee", generator);
/* 2506 */     addAdapter("ShippingFee", generator);
/* 2507 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2509 */           return (Class)ShippingFeeTierDBA.class;
/*      */         }
/*      */       };
/* 2512 */     addAdapter("dtv.xst.dao.com.ShippingFeeTierId", generator);
/* 2513 */     addAdapter("dtv.xst.dao.com.impl.ShippingFeeTierDAO", generator);
/* 2514 */     addAdapter("dtv.xst.dao.com.IShippingFeeTier", generator);
/* 2515 */     addAdapter("ShippingFeeTier", generator);
/* 2516 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2518 */           return (Class)XunitResultDBA.class;
/*      */         }
/*      */       };
/* 2521 */     addAdapter("dtv.xst.dao._test.XunitResultId", generator);
/* 2522 */     addAdapter("dtv.xst.dao._test.impl.XunitResultDAO", generator);
/* 2523 */     addAdapter("dtv.xst.dao._test.IXunitResult", generator);
/* 2524 */     addAdapter("XunitResult", generator);
/* 2525 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2527 */           return (Class)XunitResultItemDBA.class;
/*      */         }
/*      */       };
/* 2530 */     addAdapter("dtv.xst.dao._test.XunitResultItemId", generator);
/* 2531 */     addAdapter("dtv.xst.dao._test.impl.XunitResultItemDAO", generator);
/* 2532 */     addAdapter("dtv.xst.dao._test.IXunitResultItem", generator);
/* 2533 */     addAdapter("XunitResultItem", generator);
/* 2534 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2536 */           return (Class)WorkCodesDBA.class;
/*      */         }
/*      */       };
/* 2539 */     addAdapter("dtv.xst.dao.hrs.WorkCodesId", generator);
/* 2540 */     addAdapter("dtv.xst.dao.hrs.impl.WorkCodesDAO", generator);
/* 2541 */     addAdapter("dtv.xst.dao.hrs.IWorkCodes", generator);
/* 2542 */     addAdapter("WorkCodes", generator);
/* 2543 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2545 */           return (Class)EmployeeDBA.class;
/*      */         }
/*      */       };
/* 2548 */     addAdapter("dtv.xst.dao.hrs.EmployeeId", generator);
/* 2549 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO", generator);
/* 2550 */     addAdapter("dtv.xst.dao.hrs.IEmployee", generator);
/* 2551 */     addAdapter("Employee", generator);
/* 2552 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2554 */           return (Class)EmployeeFingerprintDBA.class;
/*      */         }
/*      */       };
/* 2557 */     addAdapter("dtv.xst.dao.hrs.EmployeeFingerprintId", generator);
/* 2558 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeFingerprintDAO", generator);
/* 2559 */     addAdapter("dtv.xst.dao.hrs.IEmployeeFingerprint", generator);
/* 2560 */     addAdapter("EmployeeFingerprint", generator);
/* 2561 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2563 */           return (Class)EmployeeMessageDBA.class;
/*      */         }
/*      */       };
/* 2566 */     addAdapter("dtv.xst.dao.hrs.EmployeeMessageId", generator);
/* 2567 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeMessageDAO", generator);
/* 2568 */     addAdapter("dtv.xst.dao.hrs.IEmployeeMessage", generator);
/* 2569 */     addAdapter("EmployeeMessage", generator);
/* 2570 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2572 */           return (Class)EmployeeAnswersDBA.class;
/*      */         }
/*      */       };
/* 2575 */     addAdapter("dtv.xst.dao.hrs.EmployeeAnswersId", generator);
/* 2576 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeAnswersDAO", generator);
/* 2577 */     addAdapter("dtv.xst.dao.hrs.IEmployeeAnswers", generator);
/* 2578 */     addAdapter("EmployeeAnswers", generator);
/* 2579 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2581 */           return (Class)EmployeeNoteDBA.class;
/*      */         }
/*      */       };
/* 2584 */     addAdapter("dtv.xst.dao.hrs.EmployeeNoteId", generator);
/* 2585 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeNoteDAO", generator);
/* 2586 */     addAdapter("dtv.xst.dao.hrs.IEmployeeNote", generator);
/* 2587 */     addAdapter("EmployeeNote", generator);
/* 2588 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2590 */           return (Class)EmployeePasswordDBA.class;
/*      */         }
/*      */       };
/* 2593 */     addAdapter("dtv.xst.dao.hrs.EmployeePasswordId", generator);
/* 2594 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeePasswordDAO", generator);
/* 2595 */     addAdapter("dtv.xst.dao.hrs.IEmployeePassword", generator);
/* 2596 */     addAdapter("EmployeePassword", generator);
/* 2597 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2599 */           return (Class)EmployeeStoreDBA.class;
/*      */         }
/*      */       };
/* 2602 */     addAdapter("dtv.xst.dao.hrs.EmployeeStoreId", generator);
/* 2603 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeStoreDAO", generator);
/* 2604 */     addAdapter("dtv.xst.dao.hrs.IEmployeeStore", generator);
/* 2605 */     addAdapter("EmployeeStore", generator);
/* 2606 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2608 */           return (Class)EmployeeTaskDBA.class;
/*      */         }
/*      */       };
/* 2611 */     addAdapter("dtv.xst.dao.hrs.EmployeeTaskId", generator);
/* 2612 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskDAO", generator);
/* 2613 */     addAdapter("dtv.xst.dao.hrs.IEmployeeTask", generator);
/* 2614 */     addAdapter("EmployeeTask", generator);
/* 2615 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2617 */           return (Class)EmployeeTaskNoteDBA.class;
/*      */         }
/*      */       };
/* 2620 */     addAdapter("dtv.xst.dao.hrs.EmployeeTaskNoteId", generator);
/* 2621 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskNoteDAO", generator);
/* 2622 */     addAdapter("dtv.xst.dao.hrs.IEmployeeTaskNote", generator);
/* 2623 */     addAdapter("EmployeeTaskNote", generator);
/* 2624 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2626 */           return (Class)UserPasswordDBA.class;
/*      */         }
/*      */       };
/* 2629 */     addAdapter("dtv.xst.dao.sec.UserPasswordId", generator);
/* 2630 */     addAdapter("dtv.xst.dao.sec.impl.UserPasswordDAO", generator);
/* 2631 */     addAdapter("dtv.xst.dao.sec.IUserPassword", generator);
/* 2632 */     addAdapter("UserPassword", generator);
/* 2633 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2635 */           return (Class)UserRoleDBA.class;
/*      */         }
/*      */       };
/* 2638 */     addAdapter("dtv.xst.dao.sec.UserRoleId", generator);
/* 2639 */     addAdapter("dtv.xst.dao.sec.impl.UserRoleDAO", generator);
/* 2640 */     addAdapter("dtv.xst.dao.sec.IUserRole", generator);
/* 2641 */     addAdapter("UserRole", generator);
/* 2642 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2644 */           return (Class)AccessControlListDBA.class;
/*      */         }
/*      */       };
/* 2647 */     addAdapter("dtv.xst.dao.sec.AccessControlListId", generator);
/* 2648 */     addAdapter("dtv.xst.dao.sec.impl.AccessControlListDAO", generator);
/* 2649 */     addAdapter("dtv.xst.dao.sec.IAccessControlList", generator);
/* 2650 */     addAdapter("AccessControlList", generator);
/* 2651 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2653 */           return (Class)AclAccessTypeDBA.class;
/*      */         }
/*      */       };
/* 2656 */     addAdapter("dtv.xst.dao.sec.AclAccessTypeId", generator);
/* 2657 */     addAdapter("dtv.xst.dao.sec.impl.AclAccessTypeDAO", generator);
/* 2658 */     addAdapter("dtv.xst.dao.sec.IAclAccessType", generator);
/* 2659 */     addAdapter("AclAccessType", generator);
/* 2660 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2662 */           return (Class)GroupDBA.class;
/*      */         }
/*      */       };
/* 2665 */     addAdapter("dtv.xst.dao.sec.GroupId", generator);
/* 2666 */     addAdapter("dtv.xst.dao.sec.impl.GroupDAO", generator);
/* 2667 */     addAdapter("dtv.xst.dao.sec.IGroup", generator);
/* 2668 */     addAdapter("Group", generator);
/* 2669 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2671 */           return (Class)PrivilegeDBA.class;
/*      */         }
/*      */       };
/* 2674 */     addAdapter("dtv.xst.dao.sec.PrivilegeId", generator);
/* 2675 */     addAdapter("dtv.xst.dao.sec.impl.PrivilegeDAO", generator);
/* 2676 */     addAdapter("dtv.xst.dao.sec.IPrivilege", generator);
/* 2677 */     addAdapter("Privilege", generator);
/* 2678 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2680 */           return (Class)SecurityLogDBA.class;
/*      */         }
/*      */       };
/* 2683 */     addAdapter("dtv.xst.dao.sec.SecurityLogId", generator);
/* 2684 */     addAdapter("dtv.xst.dao.sec.impl.SecurityLogDAO", generator);
/* 2685 */     addAdapter("dtv.xst.dao.sec.ISecurityLog", generator);
/* 2686 */     addAdapter("SecurityLog", generator);
/* 2687 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2689 */           return (Class)CartonDBA.class;
/*      */         }
/*      */       };
/* 2692 */     addAdapter("dtv.xst.dao.inv.CartonId", generator);
/* 2693 */     addAdapter("dtv.xst.dao.inv.impl.CartonDAO", generator);
/* 2694 */     addAdapter("dtv.xst.dao.inv.ICarton", generator);
/* 2695 */     addAdapter("Carton", generator);
/* 2696 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2698 */           return (Class)InventoryDocumentDBA.class;
/*      */         }
/*      */       };
/* 2701 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentId", generator);
/* 2702 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO", generator);
/* 2703 */     addAdapter("dtv.xst.dao.inv.IInventoryDocument", generator);
/* 2704 */     addAdapter("InventoryDocument", generator);
/* 2705 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2707 */           return (Class)InventoryDocumentLineItemDBA.class;
/*      */         }
/*      */       };
/* 2710 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentLineItemId", generator);
/* 2711 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO", generator);
/* 2712 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentLineItem", generator);
/* 2713 */     addAdapter("InventoryDocumentLineItem", generator);
/* 2714 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2716 */           return (Class)InventoryTransactionDetailDBA.class;
/*      */         }
/*      */       };
/* 2719 */     addAdapter("dtv.xst.dao.inv.InventoryTransactionDetailId", generator);
/* 2720 */     addAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDetailDAO", generator);
/* 2721 */     addAdapter("dtv.xst.dao.inv.IInventoryTransactionDetail", generator);
/* 2722 */     addAdapter("InventoryTransactionDetail", generator);
/* 2723 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2725 */           return (Class)InventoryCountDBA.class;
/*      */         }
/*      */       };
/* 2728 */     addAdapter("dtv.xst.dao.inv.InventoryCountId", generator);
/* 2729 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountDAO", generator);
/* 2730 */     addAdapter("dtv.xst.dao.inv.IInventoryCount", generator);
/* 2731 */     addAdapter("InventoryCount", generator);
/* 2732 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2734 */           return (Class)InventoryCountSectionDBA.class;
/*      */         }
/*      */       };
/* 2737 */     addAdapter("dtv.xst.dao.inv.InventoryCountSectionId", generator);
/* 2738 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionDAO", generator);
/* 2739 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSection", generator);
/* 2740 */     addAdapter("InventoryCountSection", generator);
/* 2741 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2743 */           return (Class)InventoryCountSheetDBA.class;
/*      */         }
/*      */       };
/* 2746 */     addAdapter("dtv.xst.dao.inv.InventoryCountSheetId", generator);
/* 2747 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetDAO", generator);
/* 2748 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSheet", generator);
/* 2749 */     addAdapter("InventoryCountSheet", generator);
/* 2750 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2752 */           return (Class)InventoryLocationDBA.class;
/*      */         }
/*      */       };
/* 2755 */     addAdapter("dtv.xst.dao.inv.InventoryLocationId", generator);
/* 2756 */     addAdapter("dtv.xst.dao.inv.impl.InventoryLocationDAO", generator);
/* 2757 */     addAdapter("dtv.xst.dao.inv.IInventoryLocation", generator);
/* 2758 */     addAdapter("InventoryLocation", generator);
/* 2759 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2761 */           return (Class)InventoryMovementPendingDBA.class;
/*      */         }
/*      */       };
/* 2764 */     addAdapter("dtv.xst.dao.inv.InventoryMovementPendingId", generator);
/* 2765 */     addAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO", generator);
/* 2766 */     addAdapter("dtv.xst.dao.inv.IInventoryMovementPending", generator);
/* 2767 */     addAdapter("InventoryMovementPending", generator);
/* 2768 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2770 */           return (Class)MovementPendingTransactionLineItemDBA.class;
/*      */         }
/*      */       };
/* 2773 */     addAdapter("dtv.xst.dao.inv.MovementPendingTransactionLineItemId", generator);
/* 2774 */     addAdapter("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemDAO", generator);
/* 2775 */     addAdapter("dtv.xst.dao.inv.IMovementPendingTransactionLineItem", generator);
/* 2776 */     addAdapter("MovementPendingTransactionLineItem", generator);
/* 2777 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2779 */           return (Class)ShipmentDBA.class;
/*      */         }
/*      */       };
/* 2782 */     addAdapter("dtv.xst.dao.inv.ShipmentId", generator);
/* 2783 */     addAdapter("dtv.xst.dao.inv.impl.ShipmentDAO", generator);
/* 2784 */     addAdapter("dtv.xst.dao.inv.IShipment", generator);
/* 2785 */     addAdapter("Shipment", generator);
/* 2786 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2788 */           return (Class)ShipmentLineItemDBA.class;
/*      */         }
/*      */       };
/* 2791 */     addAdapter("dtv.xst.dao.inv.ShipmentLineItemId", generator);
/* 2792 */     addAdapter("dtv.xst.dao.inv.impl.ShipmentLineItemDAO", generator);
/* 2793 */     addAdapter("dtv.xst.dao.inv.IShipmentLineItem", generator);
/* 2794 */     addAdapter("ShipmentLineItem", generator);
/* 2795 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2797 */           return (Class)ShipmentAddressDBA.class;
/*      */         }
/*      */       };
/* 2800 */     addAdapter("dtv.xst.dao.inv.ShipmentAddressId", generator);
/* 2801 */     addAdapter("dtv.xst.dao.inv.impl.ShipmentAddressDAO", generator);
/* 2802 */     addAdapter("dtv.xst.dao.inv.IShipmentAddress", generator);
/* 2803 */     addAdapter("ShipmentAddress", generator);
/* 2804 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2806 */           return (Class)InventoryItemAccountModifierDBA.class;
/*      */         }
/*      */       };
/* 2809 */     addAdapter("dtv.xst.dao.inv.InventoryItemAccountModifierId", generator);
/* 2810 */     addAdapter("dtv.xst.dao.inv.impl.InventoryItemAccountModifierDAO", generator);
/* 2811 */     addAdapter("dtv.xst.dao.inv.IInventoryItemAccountModifier", generator);
/* 2812 */     addAdapter("InventoryItemAccountModifier", generator);
/* 2813 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2815 */           return (Class)DocumentInventoryLocationModifierDBA.class;
/*      */         }
/*      */       };
/* 2818 */     addAdapter("dtv.xst.dao.inv.DocumentInventoryLocationModifierId", generator);
/* 2819 */     addAdapter("dtv.xst.dao.inv.impl.DocumentInventoryLocationModifierDAO", generator);
/* 2820 */     addAdapter("dtv.xst.dao.inv.IDocumentInventoryLocationModifier", generator);
/* 2821 */     addAdapter("DocumentInventoryLocationModifier", generator);
/* 2822 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2824 */           return (Class)DocumentNoteDBA.class;
/*      */         }
/*      */       };
/* 2827 */     addAdapter("dtv.xst.dao.inv.DocumentNoteId", generator);
/* 2828 */     addAdapter("dtv.xst.dao.inv.impl.DocumentNoteDAO", generator);
/* 2829 */     addAdapter("dtv.xst.dao.inv.IDocumentNote", generator);
/* 2830 */     addAdapter("DocumentNote", generator);
/* 2831 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2833 */           return (Class)FiscalYearDBA.class;
/*      */         }
/*      */       };
/* 2836 */     addAdapter("dtv.xst.dao.inv.FiscalYearId", generator);
/* 2837 */     addAdapter("dtv.xst.dao.inv.impl.FiscalYearDAO", generator);
/* 2838 */     addAdapter("dtv.xst.dao.inv.IFiscalYear", generator);
/* 2839 */     addAdapter("FiscalYear", generator);
/* 2840 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2842 */           return (Class)InventoryBucketDBA.class;
/*      */         }
/*      */       };
/* 2845 */     addAdapter("dtv.xst.dao.inv.InventoryBucketId", generator);
/* 2846 */     addAdapter("dtv.xst.dao.inv.impl.InventoryBucketDAO", generator);
/* 2847 */     addAdapter("dtv.xst.dao.inv.IInventoryBucket", generator);
/* 2848 */     addAdapter("InventoryBucket", generator);
/* 2849 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2851 */           return (Class)InventoryDocumentCrossReferenceDBA.class;
/*      */         }
/*      */       };
/* 2854 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentCrossReferenceId", generator);
/* 2855 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentCrossReferenceDAO", generator);
/* 2856 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentCrossReference", generator);
/* 2857 */     addAdapter("InventoryDocumentCrossReference", generator);
/* 2858 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2860 */           return (Class)InventoryTransactionDBA.class;
/*      */         }
/*      */       };
/* 2863 */     addAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDAO", generator);
/* 2864 */     addAdapter("dtv.xst.dao.inv.IInventoryTransaction", generator);
/* 2865 */     addAdapter("InventoryTransaction", generator);
/* 2866 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2868 */           return (Class)InventoryCostItemYearEndDBA.class;
/*      */         }
/*      */       };
/* 2871 */     addAdapter("dtv.xst.dao.inv.InventoryCostItemYearEndId", generator);
/* 2872 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCostItemYearEndDAO", generator);
/* 2873 */     addAdapter("dtv.xst.dao.inv.IInventoryCostItemYearEnd", generator);
/* 2874 */     addAdapter("InventoryCostItemYearEnd", generator);
/* 2875 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2877 */           return (Class)InventoryCountBucketDBA.class;
/*      */         }
/*      */       };
/* 2880 */     addAdapter("dtv.xst.dao.inv.InventoryCountBucketId", generator);
/* 2881 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountBucketDAO", generator);
/* 2882 */     addAdapter("dtv.xst.dao.inv.IInventoryCountBucket", generator);
/* 2883 */     addAdapter("InventoryCountBucket", generator);
/* 2884 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2886 */           return (Class)InventoryCountSectionDetailDBA.class;
/*      */         }
/*      */       };
/* 2889 */     addAdapter("dtv.xst.dao.inv.InventoryCountSectionDetailId", generator);
/* 2890 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionDetailDAO", generator);
/* 2891 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSectionDetail", generator);
/* 2892 */     addAdapter("InventoryCountSectionDetail", generator);
/* 2893 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2895 */           return (Class)InventoryCountSheetLineItemDBA.class;
/*      */         }
/*      */       };
/* 2898 */     addAdapter("dtv.xst.dao.inv.InventoryCountSheetLineItemId", generator);
/* 2899 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetLineItemDAO", generator);
/* 2900 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSheetLineItem", generator);
/* 2901 */     addAdapter("InventoryCountSheetLineItem", generator);
/* 2902 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2904 */           return (Class)InventoryCountSnapshotDBA.class;
/*      */         }
/*      */       };
/* 2907 */     addAdapter("dtv.xst.dao.inv.InventoryCountSnapshotId", generator);
/* 2908 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSnapshotDAO", generator);
/* 2909 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSnapshot", generator);
/* 2910 */     addAdapter("InventoryCountSnapshot", generator);
/* 2911 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2913 */           return (Class)InventoryJournalDBA.class;
/*      */         }
/*      */       };
/* 2916 */     addAdapter("dtv.xst.dao.inv.InventoryJournalId", generator);
/* 2917 */     addAdapter("dtv.xst.dao.inv.impl.InventoryJournalDAO", generator);
/* 2918 */     addAdapter("dtv.xst.dao.inv.IInventoryJournal", generator);
/* 2919 */     addAdapter("InventoryJournal", generator);
/* 2920 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2922 */           return (Class)InventoryLocationAvailabilityDBA.class;
/*      */         }
/*      */       };
/* 2925 */     addAdapter("dtv.xst.dao.inv.InventoryLocationAvailabilityId", generator);
/* 2926 */     addAdapter("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityDAO", generator);
/* 2927 */     addAdapter("dtv.xst.dao.inv.IInventoryLocationAvailability", generator);
/* 2928 */     addAdapter("InventoryLocationAvailability", generator);
/* 2929 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2931 */           return (Class)InventoryLocationBucketDBA.class;
/*      */         }
/*      */       };
/* 2934 */     addAdapter("dtv.xst.dao.inv.InventoryLocationBucketId", generator);
/* 2935 */     addAdapter("dtv.xst.dao.inv.impl.InventoryLocationBucketDAO", generator);
/* 2936 */     addAdapter("dtv.xst.dao.inv.IInventoryLocationBucket", generator);
/* 2937 */     addAdapter("InventoryLocationBucket", generator);
/* 2938 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2940 */           return (Class)InventoryMovementPendingDetailDBA.class;
/*      */         }
/*      */       };
/* 2943 */     addAdapter("dtv.xst.dao.inv.InventoryMovementPendingDetailId", generator);
/* 2944 */     addAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDetailDAO", generator);
/* 2945 */     addAdapter("dtv.xst.dao.inv.IInventoryMovementPendingDetail", generator);
/* 2946 */     addAdapter("InventoryMovementPendingDetail", generator);
/* 2947 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2949 */           return (Class)InventorySummaryCountTransactionDBA.class;
/*      */         }
/*      */       };
/* 2952 */     addAdapter("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDAO", generator);
/* 2953 */     addAdapter("dtv.xst.dao.inv.IInventorySummaryCountTransaction", generator);
/* 2954 */     addAdapter("InventorySummaryCountTransaction", generator);
/* 2955 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2957 */           return (Class)InventorySummaryCountTransactionDetailDBA.class;
/*      */         }
/*      */       };
/* 2960 */     addAdapter("dtv.xst.dao.inv.InventorySummaryCountTransactionDetailId", generator);
/* 2961 */     addAdapter("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailDAO", generator);
/* 2962 */     addAdapter("dtv.xst.dao.inv.IInventorySummaryCountTransactionDetail", generator);
/* 2963 */     addAdapter("InventorySummaryCountTransactionDetail", generator);
/* 2964 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2966 */           return (Class)InventoryValidDestinationsDBA.class;
/*      */         }
/*      */       };
/* 2969 */     addAdapter("dtv.xst.dao.inv.InventoryValidDestinationsId", generator);
/* 2970 */     addAdapter("dtv.xst.dao.inv.impl.InventoryValidDestinationsDAO", generator);
/* 2971 */     addAdapter("dtv.xst.dao.inv.IInventoryValidDestinations", generator);
/* 2972 */     addAdapter("InventoryValidDestinations", generator);
/* 2973 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2975 */           return (Class)MovementPendingTransactionDBA.class;
/*      */         }
/*      */       };
/* 2978 */     addAdapter("dtv.xst.dao.inv.impl.MovementPendingTransactionDAO", generator);
/* 2979 */     addAdapter("dtv.xst.dao.inv.IMovementPendingTransaction", generator);
/* 2980 */     addAdapter("MovementPendingTransaction", generator);
/* 2981 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2983 */           return (Class)SerializedStockLedgerDBA.class;
/*      */         }
/*      */       };
/* 2986 */     addAdapter("dtv.xst.dao.inv.SerializedStockLedgerId", generator);
/* 2987 */     addAdapter("dtv.xst.dao.inv.impl.SerializedStockLedgerDAO", generator);
/* 2988 */     addAdapter("dtv.xst.dao.inv.ISerializedStockLedger", generator);
/* 2989 */     addAdapter("SerializedStockLedger", generator);
/* 2990 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 2992 */           return (Class)ShipperDBA.class;
/*      */         }
/*      */       };
/* 2995 */     addAdapter("dtv.xst.dao.inv.ShipperId", generator);
/* 2996 */     addAdapter("dtv.xst.dao.inv.impl.ShipperDAO", generator);
/* 2997 */     addAdapter("dtv.xst.dao.inv.IShipper", generator);
/* 2998 */     addAdapter("Shipper", generator);
/* 2999 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3001 */           return (Class)ShipperMethodDBA.class;
/*      */         }
/*      */       };
/* 3004 */     addAdapter("dtv.xst.dao.inv.ShipperMethodId", generator);
/* 3005 */     addAdapter("dtv.xst.dao.inv.impl.ShipperMethodDAO", generator);
/* 3006 */     addAdapter("dtv.xst.dao.inv.IShipperMethod", generator);
/* 3007 */     addAdapter("ShipperMethod", generator);
/* 3008 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3010 */           return (Class)StockLedgerDBA.class;
/*      */         }
/*      */       };
/* 3013 */     addAdapter("dtv.xst.dao.inv.StockLedgerId", generator);
/* 3014 */     addAdapter("dtv.xst.dao.inv.impl.StockLedgerDAO", generator);
/* 3015 */     addAdapter("dtv.xst.dao.inv.IStockLedger", generator);
/* 3016 */     addAdapter("StockLedger", generator);
/* 3017 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3019 */           return (Class)DocumentLineItemNoteDBA.class;
/*      */         }
/*      */       };
/* 3022 */     addAdapter("dtv.xst.dao.inv.DocumentLineItemNoteId", generator);
/* 3023 */     addAdapter("dtv.xst.dao.inv.impl.DocumentLineItemNoteDAO", generator);
/* 3024 */     addAdapter("dtv.xst.dao.inv.IDocumentLineItemNote", generator);
/* 3025 */     addAdapter("DocumentLineItemNote", generator);
/* 3026 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3028 */           return (Class)InventoryDocumentLineSerialDBA.class;
/*      */         }
/*      */       };
/* 3031 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentLineSerialId", generator);
/* 3032 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineSerialDAO", generator);
/* 3033 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentLineSerial", generator);
/* 3034 */     addAdapter("InventoryDocumentLineSerial", generator);
/* 3035 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3037 */           return (Class)InventoryReplenishmentDocumentLineItemDBA.class;
/*      */         }
/*      */       };
/* 3040 */     addAdapter("dtv.xst.dao.inv.InventoryReplenishmentDocumentLineItemId", generator);
/* 3041 */     addAdapter("dtv.xst.dao.inv.impl.InventoryReplenishmentDocumentLineItemDAO", generator);
/* 3042 */     addAdapter("dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItem", generator);
/* 3043 */     addAdapter("InventoryReplenishmentDocumentLineItem", generator);
/* 3044 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3046 */           return (Class)DiscountDBA.class;
/*      */         }
/*      */       };
/* 3049 */     addAdapter("dtv.xst.dao.dsc.DiscountId", generator);
/* 3050 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountDAO", generator);
/* 3051 */     addAdapter("dtv.xst.dao.dsc.IDiscount", generator);
/* 3052 */     addAdapter("Discount", generator);
/* 3053 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3055 */           return (Class)CouponDBA.class;
/*      */         }
/*      */       };
/* 3058 */     addAdapter("dtv.xst.dao.dsc.CouponId", generator);
/* 3059 */     addAdapter("dtv.xst.dao.dsc.impl.CouponDAO", generator);
/* 3060 */     addAdapter("dtv.xst.dao.dsc.ICoupon", generator);
/* 3061 */     addAdapter("Coupon", generator);
/* 3062 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3064 */           return (Class)DiscountCompatabilityDBA.class;
/*      */         }
/*      */       };
/* 3067 */     addAdapter("dtv.xst.dao.dsc.DiscountCompatabilityId", generator);
/* 3068 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountCompatabilityDAO", generator);
/* 3069 */     addAdapter("dtv.xst.dao.dsc.IDiscountCompatability", generator);
/* 3070 */     addAdapter("DiscountCompatability", generator);
/* 3071 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3073 */           return (Class)DiscountGroupMappingDBA.class;
/*      */         }
/*      */       };
/* 3076 */     addAdapter("dtv.xst.dao.dsc.DiscountGroupMappingId", generator);
/* 3077 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountGroupMappingDAO", generator);
/* 3078 */     addAdapter("dtv.xst.dao.dsc.IDiscountGroupMapping", generator);
/* 3079 */     addAdapter("DiscountGroupMapping", generator);
/* 3080 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3082 */           return (Class)DiscountItemExclusionsDBA.class;
/*      */         }
/*      */       };
/* 3085 */     addAdapter("dtv.xst.dao.dsc.DiscountItemExclusionsId", generator);
/* 3086 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountItemExclusionsDAO", generator);
/* 3087 */     addAdapter("dtv.xst.dao.dsc.IDiscountItemExclusions", generator);
/* 3088 */     addAdapter("DiscountItemExclusions", generator);
/* 3089 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3091 */           return (Class)DiscountItemInclusionsDBA.class;
/*      */         }
/*      */       };
/* 3094 */     addAdapter("dtv.xst.dao.dsc.DiscountItemInclusionsId", generator);
/* 3095 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountItemInclusionsDAO", generator);
/* 3096 */     addAdapter("dtv.xst.dao.dsc.IDiscountItemInclusions", generator);
/* 3097 */     addAdapter("DiscountItemInclusions", generator);
/* 3098 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3100 */           return (Class)DiscountTypeEligibilityDBA.class;
/*      */         }
/*      */       };
/* 3103 */     addAdapter("dtv.xst.dao.dsc.DiscountTypeEligibilityId", generator);
/* 3104 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountTypeEligibilityDAO", generator);
/* 3105 */     addAdapter("dtv.xst.dao.dsc.IDiscountTypeEligibility", generator);
/* 3106 */     addAdapter("DiscountTypeEligibility", generator);
/* 3107 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3109 */           return (Class)InvoiceDBA.class;
/*      */         }
/*      */       };
/* 3112 */     addAdapter("dtv.xst.dao.cwo.InvoiceId", generator);
/* 3113 */     addAdapter("dtv.xst.dao.cwo.impl.InvoiceDAO", generator);
/* 3114 */     addAdapter("dtv.xst.dao.cwo.IInvoice", generator);
/* 3115 */     addAdapter("Invoice", generator);
/* 3116 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3118 */           return (Class)WorkItemDBA.class;
/*      */         }
/*      */       };
/* 3121 */     addAdapter("dtv.xst.dao.cwo.WorkItemId", generator);
/* 3122 */     addAdapter("dtv.xst.dao.cwo.impl.WorkItemDAO", generator);
/* 3123 */     addAdapter("dtv.xst.dao.cwo.IWorkItem", generator);
/* 3124 */     addAdapter("WorkItem", generator);
/* 3125 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3127 */           return (Class)CategoryServiceLocationDBA.class;
/*      */         }
/*      */       };
/* 3130 */     addAdapter("dtv.xst.dao.cwo.CategoryServiceLocationId", generator);
/* 3131 */     addAdapter("dtv.xst.dao.cwo.impl.CategoryServiceLocationDAO", generator);
/* 3132 */     addAdapter("dtv.xst.dao.cwo.ICategoryServiceLocation", generator);
/* 3133 */     addAdapter("CategoryServiceLocation", generator);
/* 3134 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3136 */           return (Class)InvoiceLineItemDBA.class;
/*      */         }
/*      */       };
/* 3139 */     addAdapter("dtv.xst.dao.cwo.InvoiceLineItemId", generator);
/* 3140 */     addAdapter("dtv.xst.dao.cwo.impl.InvoiceLineItemDAO", generator);
/* 3141 */     addAdapter("dtv.xst.dao.cwo.IInvoiceLineItem", generator);
/* 3142 */     addAdapter("InvoiceLineItem", generator);
/* 3143 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3145 */           return (Class)ServiceLocationDBA.class;
/*      */         }
/*      */       };
/* 3148 */     addAdapter("dtv.xst.dao.cwo.ServiceLocationId", generator);
/* 3149 */     addAdapter("dtv.xst.dao.cwo.impl.ServiceLocationDAO", generator);
/* 3150 */     addAdapter("dtv.xst.dao.cwo.IServiceLocation", generator);
/* 3151 */     addAdapter("ServiceLocation", generator);
/* 3152 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3154 */           return (Class)TaskDBA.class;
/*      */         }
/*      */       };
/* 3157 */     addAdapter("dtv.xst.dao.cwo.impl.TaskDAO", generator);
/* 3158 */     addAdapter("dtv.xst.dao.cwo.ITask", generator);
/* 3159 */     addAdapter("Task", generator);
/* 3160 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3162 */           return (Class)WorkOrderAccountDBA.class;
/*      */         }
/*      */       };
/* 3165 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO", generator);
/* 3166 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderAccount", generator);
/* 3167 */     addAdapter("WorkOrderAccount", generator);
/* 3168 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3170 */           return (Class)WorkOrderAccountJournalDBA.class;
/*      */         }
/*      */       };
/* 3173 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountJournalDAO", generator);
/* 3174 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderAccountJournal", generator);
/* 3175 */     addAdapter("WorkOrderAccountJournal", generator);
/* 3176 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3178 */           return (Class)WorkOrderCategoryDBA.class;
/*      */         }
/*      */       };
/* 3181 */     addAdapter("dtv.xst.dao.cwo.WorkOrderCategoryId", generator);
/* 3182 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderCategoryDAO", generator);
/* 3183 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderCategory", generator);
/* 3184 */     addAdapter("WorkOrderCategory", generator);
/* 3185 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3187 */           return (Class)WorkOrderLineItemDBA.class;
/*      */         }
/*      */       };
/* 3190 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderLineItemDAO", generator);
/* 3191 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderLineItem", generator);
/* 3192 */     addAdapter("WorkOrderLineItem", generator);
/* 3193 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3195 */           return (Class)WorkOrderPriceCodeDBA.class;
/*      */         }
/*      */       };
/* 3198 */     addAdapter("dtv.xst.dao.cwo.WorkOrderPriceCodeId", generator);
/* 3199 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderPriceCodeDAO", generator);
/* 3200 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderPriceCode", generator);
/* 3201 */     addAdapter("WorkOrderPriceCode", generator);
/* 3202 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3204 */           return (Class)WorkOrderPricingDBA.class;
/*      */         }
/*      */       };
/* 3207 */     addAdapter("dtv.xst.dao.cwo.WorkOrderPricingId", generator);
/* 3208 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderPricingDAO", generator);
/* 3209 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderPricing", generator);
/* 3210 */     addAdapter("WorkOrderPricing", generator);
/* 3211 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3213 */           return (Class)TaxAuthorityDBA.class;
/*      */         }
/*      */       };
/* 3216 */     addAdapter("dtv.xst.dao.tax.TaxAuthorityId", generator);
/* 3217 */     addAdapter("dtv.xst.dao.tax.impl.TaxAuthorityDAO", generator);
/* 3218 */     addAdapter("dtv.xst.dao.tax.ITaxAuthority", generator);
/* 3219 */     addAdapter("TaxAuthority", generator);
/* 3220 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3222 */           return (Class)TaxGroupDBA.class;
/*      */         }
/*      */       };
/* 3225 */     addAdapter("dtv.xst.dao.tax.TaxGroupId", generator);
/* 3226 */     addAdapter("dtv.xst.dao.tax.impl.TaxGroupDAO", generator);
/* 3227 */     addAdapter("dtv.xst.dao.tax.ITaxGroup", generator);
/* 3228 */     addAdapter("TaxGroup", generator);
/* 3229 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3231 */           return (Class)TaxGroupRuleDBA.class;
/*      */         }
/*      */       };
/* 3234 */     addAdapter("dtv.xst.dao.tax.TaxGroupRuleId", generator);
/* 3235 */     addAdapter("dtv.xst.dao.tax.impl.TaxGroupRuleDAO", generator);
/* 3236 */     addAdapter("dtv.xst.dao.tax.ITaxGroupRule", generator);
/* 3237 */     addAdapter("TaxGroupRule", generator);
/* 3238 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3240 */           return (Class)TaxLocationDBA.class;
/*      */         }
/*      */       };
/* 3243 */     addAdapter("dtv.xst.dao.tax.TaxLocationId", generator);
/* 3244 */     addAdapter("dtv.xst.dao.tax.impl.TaxLocationDAO", generator);
/* 3245 */     addAdapter("dtv.xst.dao.tax.ITaxLocation", generator);
/* 3246 */     addAdapter("TaxLocation", generator);
/* 3247 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3249 */           return (Class)TaxRateRuleDBA.class;
/*      */         }
/*      */       };
/* 3252 */     addAdapter("dtv.xst.dao.tax.TaxRateRuleId", generator);
/* 3253 */     addAdapter("dtv.xst.dao.tax.impl.TaxRateRuleDAO", generator);
/* 3254 */     addAdapter("dtv.xst.dao.tax.ITaxRateRule", generator);
/* 3255 */     addAdapter("TaxRateRule", generator);
/* 3256 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3258 */           return (Class)TaxCodeDBA.class;
/*      */         }
/*      */       };
/* 3261 */     addAdapter("dtv.xst.dao.tax.TaxCodeId", generator);
/* 3262 */     addAdapter("dtv.xst.dao.tax.impl.TaxCodeDAO", generator);
/* 3263 */     addAdapter("dtv.xst.dao.tax.ITaxCode", generator);
/* 3264 */     addAdapter("TaxCode", generator);
/* 3265 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3267 */           return (Class)PostalCodeMappingDBA.class;
/*      */         }
/*      */       };
/* 3270 */     addAdapter("dtv.xst.dao.tax.PostalCodeMappingId", generator);
/* 3271 */     addAdapter("dtv.xst.dao.tax.impl.PostalCodeMappingDAO", generator);
/* 3272 */     addAdapter("dtv.xst.dao.tax.IPostalCodeMapping", generator);
/* 3273 */     addAdapter("PostalCodeMapping", generator);
/* 3274 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3276 */           return (Class)RetailLocationTaxMappingDBA.class;
/*      */         }
/*      */       };
/* 3279 */     addAdapter("dtv.xst.dao.tax.RetailLocationTaxMappingId", generator);
/* 3280 */     addAdapter("dtv.xst.dao.tax.impl.RetailLocationTaxMappingDAO", generator);
/* 3281 */     addAdapter("dtv.xst.dao.tax.IRetailLocationTaxMapping", generator);
/* 3282 */     addAdapter("RetailLocationTaxMapping", generator);
/* 3283 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3285 */           return (Class)TaxBracketDBA.class;
/*      */         }
/*      */       };
/* 3288 */     addAdapter("dtv.xst.dao.tax.TaxBracketId", generator);
/* 3289 */     addAdapter("dtv.xst.dao.tax.impl.TaxBracketDAO", generator);
/* 3290 */     addAdapter("dtv.xst.dao.tax.ITaxBracket", generator);
/* 3291 */     addAdapter("TaxBracket", generator);
/* 3292 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3294 */           return (Class)TaxExemptionDBA.class;
/*      */         }
/*      */       };
/* 3297 */     addAdapter("dtv.xst.dao.tax.TaxExemptionId", generator);
/* 3298 */     addAdapter("dtv.xst.dao.tax.impl.TaxExemptionDAO", generator);
/* 3299 */     addAdapter("dtv.xst.dao.tax.ITaxExemption", generator);
/* 3300 */     addAdapter("TaxExemption", generator);
/* 3301 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3303 */           return (Class)TaxRateRuleOverrideDBA.class;
/*      */         }
/*      */       };
/* 3306 */     addAdapter("dtv.xst.dao.tax.TaxRateRuleOverrideId", generator);
/* 3307 */     addAdapter("dtv.xst.dao.tax.impl.TaxRateRuleOverrideDAO", generator);
/* 3308 */     addAdapter("dtv.xst.dao.tax.ITaxRateRuleOverride", generator);
/* 3309 */     addAdapter("TaxRateRuleOverride", generator);
/* 3310 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3312 */           return (Class)TaxTaxGroupMappingDBA.class;
/*      */         }
/*      */       };
/* 3315 */     addAdapter("dtv.xst.dao.tax.TaxTaxGroupMappingId", generator);
/* 3316 */     addAdapter("dtv.xst.dao.tax.impl.TaxTaxGroupMappingDAO", generator);
/* 3317 */     addAdapter("dtv.xst.dao.tax.ITaxTaxGroupMapping", generator);
/* 3318 */     addAdapter("TaxTaxGroupMapping", generator);
/* 3319 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3321 */           return (Class)DocumentDBA.class;
/*      */         }
/*      */       };
/* 3324 */     addAdapter("dtv.xst.dao.doc.DocumentId", generator);
/* 3325 */     addAdapter("dtv.xst.dao.doc.impl.DocumentDAO", generator);
/* 3326 */     addAdapter("dtv.xst.dao.doc.IDocument", generator);
/* 3327 */     addAdapter("Document", generator);
/* 3328 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3330 */           return (Class)DocumentDefinitionDBA.class;
/*      */         }
/*      */       };
/* 3333 */     addAdapter("dtv.xst.dao.doc.DocumentDefinitionId", generator);
/* 3334 */     addAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionDAO", generator);
/* 3335 */     addAdapter("dtv.xst.dao.doc.IDocumentDefinition", generator);
/* 3336 */     addAdapter("DocumentDefinition", generator);
/* 3337 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3339 */           return (Class)DocumentDefinitionPropertiesDBA.class;
/*      */         }
/*      */       };
/* 3342 */     addAdapter("dtv.xst.dao.doc.DocumentDefinitionPropertiesId", generator);
/* 3343 */     addAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionPropertiesDAO", generator);
/* 3344 */     addAdapter("dtv.xst.dao.doc.IDocumentDefinitionProperties", generator);
/* 3345 */     addAdapter("DocumentDefinitionProperties", generator);
/* 3346 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3348 */           return (Class)DocumentLineItemDBA.class;
/*      */         }
/*      */       };
/* 3351 */     addAdapter("dtv.xst.dao.doc.impl.DocumentLineItemDAO", generator);
/* 3352 */     addAdapter("dtv.xst.dao.doc.IDocumentLineItem", generator);
/* 3353 */     addAdapter("DocumentLineItem", generator);
/* 3354 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3356 */           return (Class)OrganizerDBA.class;
/*      */         }
/*      */       };
/* 3359 */     addAdapter("dtv.xst.dao.rpt.OrganizerId", generator);
/* 3360 */     addAdapter("dtv.xst.dao.rpt.impl.OrganizerDAO", generator);
/* 3361 */     addAdapter("dtv.xst.dao.rpt.IOrganizer", generator);
/* 3362 */     addAdapter("Organizer", generator);
/* 3363 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3365 */           return (Class)EmployeeTimeOffDBA.class;
/*      */         }
/*      */       };
/* 3368 */     addAdapter("dtv.xst.dao.sch.EmployeeTimeOffId", generator);
/* 3369 */     addAdapter("dtv.xst.dao.sch.impl.EmployeeTimeOffDAO", generator);
/* 3370 */     addAdapter("dtv.xst.dao.sch.IEmployeeTimeOff", generator);
/* 3371 */     addAdapter("EmployeeTimeOff", generator);
/* 3372 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3374 */           return (Class)ScheduleDBA.class;
/*      */         }
/*      */       };
/* 3377 */     addAdapter("dtv.xst.dao.sch.ScheduleId", generator);
/* 3378 */     addAdapter("dtv.xst.dao.sch.impl.ScheduleDAO", generator);
/* 3379 */     addAdapter("dtv.xst.dao.sch.ISchedule", generator);
/* 3380 */     addAdapter("Schedule", generator);
/* 3381 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3383 */           return (Class)ShiftDBA.class;
/*      */         }
/*      */       };
/* 3386 */     addAdapter("dtv.xst.dao.sch.ShiftId", generator);
/* 3387 */     addAdapter("dtv.xst.dao.sch.impl.ShiftDAO", generator);
/* 3388 */     addAdapter("dtv.xst.dao.sch.IShift", generator);
/* 3389 */     addAdapter("Shift", generator);
/* 3390 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3392 */           return (Class)SalesGoalDBA.class;
/*      */         }
/*      */       };
/* 3395 */     addAdapter("dtv.xst.dao.sls.SalesGoalId", generator);
/* 3396 */     addAdapter("dtv.xst.dao.sls.impl.SalesGoalDAO", generator);
/* 3397 */     addAdapter("dtv.xst.dao.sls.ISalesGoal", generator);
/* 3398 */     addAdapter("SalesGoal", generator);
/* 3399 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3401 */           return (Class)XadminUserDBA.class;
/*      */         }
/*      */       };
/* 3404 */     addAdapter("dtv.xst.dao.cfg.XadminUserId", generator);
/* 3405 */     addAdapter("dtv.xst.dao.cfg.impl.XadminUserDAO", generator);
/* 3406 */     addAdapter("dtv.xst.dao.cfg.IXadminUser", generator);
/* 3407 */     addAdapter("XadminUser", generator);
/* 3408 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3410 */           return (Class)XadminUserNodeDBA.class;
/*      */         }
/*      */       };
/* 3413 */     addAdapter("dtv.xst.dao.cfg.XadminUserNodeId", generator);
/* 3414 */     addAdapter("dtv.xst.dao.cfg.impl.XadminUserNodeDAO", generator);
/* 3415 */     addAdapter("dtv.xst.dao.cfg.IXadminUserNode", generator);
/* 3416 */     addAdapter("XadminUserNode", generator);
/* 3417 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3419 */           return (Class)CustomerConsentInfoPropertyDBA.class;
/*      */         }
/*      */       };
/* 3422 */     addAdapter("dtv.xst.dao.crm.CustomerConsentInfoPropertyId", generator);
/* 3423 */     addAdapter("dtv.xst.dao.crm.impl.CustomerConsentInfoPropertyDAO", generator);
/* 3424 */     addAdapter("dtv.xst.dao.crm.ICustomerConsentInfoProperty", generator);
/* 3425 */     addAdapter("CustomerConsentInfoProperty", generator);
/* 3426 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3428 */           return (Class)PartyPropertyDBA.class;
/*      */         }
/*      */       };
/* 3431 */     addAdapter("dtv.xst.dao.crm.PartyPropertyId", generator);
/* 3432 */     addAdapter("dtv.xst.dao.crm.impl.PartyPropertyDAO", generator);
/* 3433 */     addAdapter("dtv.xst.dao.crm.IPartyProperty", generator);
/* 3434 */     addAdapter("PartyProperty", generator);
/* 3435 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3437 */           return (Class)PartyLocaleInformationPropertyDBA.class;
/*      */         }
/*      */       };
/* 3440 */     addAdapter("dtv.xst.dao.crm.PartyLocaleInformationPropertyId", generator);
/* 3441 */     addAdapter("dtv.xst.dao.crm.impl.PartyLocaleInformationPropertyDAO", generator);
/* 3442 */     addAdapter("dtv.xst.dao.crm.IPartyLocaleInformationProperty", generator);
/* 3443 */     addAdapter("PartyLocaleInformationProperty", generator);
/* 3444 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3446 */           return (Class)CustomerAffiliationPropertyDBA.class;
/*      */         }
/*      */       };
/* 3449 */     addAdapter("dtv.xst.dao.crm.CustomerAffiliationPropertyId", generator);
/* 3450 */     addAdapter("dtv.xst.dao.crm.impl.CustomerAffiliationPropertyDAO", generator);
/* 3451 */     addAdapter("dtv.xst.dao.crm.ICustomerAffiliationProperty", generator);
/* 3452 */     addAdapter("CustomerAffiliationProperty", generator);
/* 3453 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3455 */           return (Class)CustomerNotePropertyDBA.class;
/*      */         }
/*      */       };
/* 3458 */     addAdapter("dtv.xst.dao.crm.CustomerNotePropertyId", generator);
/* 3459 */     addAdapter("dtv.xst.dao.crm.impl.CustomerNotePropertyDAO", generator);
/* 3460 */     addAdapter("dtv.xst.dao.crm.ICustomerNoteProperty", generator);
/* 3461 */     addAdapter("CustomerNoteProperty", generator);
/* 3462 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3464 */           return (Class)GiftRegistryJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 3467 */     addAdapter("dtv.xst.dao.crm.GiftRegistryJournalPropertyId", generator);
/* 3468 */     addAdapter("dtv.xst.dao.crm.impl.GiftRegistryJournalPropertyDAO", generator);
/* 3469 */     addAdapter("dtv.xst.dao.crm.IGiftRegistryJournalProperty", generator);
/* 3470 */     addAdapter("GiftRegistryJournalProperty", generator);
/* 3471 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3473 */           return (Class)PartyCrossReferencePropertyDBA.class;
/*      */         }
/*      */       };
/* 3476 */     addAdapter("dtv.xst.dao.crm.PartyCrossReferencePropertyId", generator);
/* 3477 */     addAdapter("dtv.xst.dao.crm.impl.PartyCrossReferencePropertyDAO", generator);
/* 3478 */     addAdapter("dtv.xst.dao.crm.IPartyCrossReferenceProperty", generator);
/* 3479 */     addAdapter("PartyCrossReferenceProperty", generator);
/* 3480 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3482 */           return (Class)PartyEmailPropertyDBA.class;
/*      */         }
/*      */       };
/* 3485 */     addAdapter("dtv.xst.dao.crm.PartyEmailPropertyId", generator);
/* 3486 */     addAdapter("dtv.xst.dao.crm.impl.PartyEmailPropertyDAO", generator);
/* 3487 */     addAdapter("dtv.xst.dao.crm.IPartyEmailProperty", generator);
/* 3488 */     addAdapter("PartyEmailProperty", generator);
/* 3489 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3491 */           return (Class)PartyIdCrossReferencePropertyDBA.class;
/*      */         }
/*      */       };
/* 3494 */     addAdapter("dtv.xst.dao.crm.PartyIdCrossReferencePropertyId", generator);
/* 3495 */     addAdapter("dtv.xst.dao.crm.impl.PartyIdCrossReferencePropertyDAO", generator);
/* 3496 */     addAdapter("dtv.xst.dao.crm.IPartyIdCrossReferenceProperty", generator);
/* 3497 */     addAdapter("PartyIdCrossReferenceProperty", generator);
/* 3498 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3500 */           return (Class)PartyTelephonePropertyDBA.class;
/*      */         }
/*      */       };
/* 3503 */     addAdapter("dtv.xst.dao.crm.PartyTelephonePropertyId", generator);
/* 3504 */     addAdapter("dtv.xst.dao.crm.impl.PartyTelephonePropertyDAO", generator);
/* 3505 */     addAdapter("dtv.xst.dao.crm.IPartyTelephoneProperty", generator);
/* 3506 */     addAdapter("PartyTelephoneProperty", generator);
/* 3507 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3509 */           return (Class)CustomerAccountPropertyDBA.class;
/*      */         }
/*      */       };
/* 3512 */     addAdapter("dtv.xst.dao.cat.CustomerAccountPropertyId", generator);
/* 3513 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountPropertyDAO", generator);
/* 3514 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountProperty", generator);
/* 3515 */     addAdapter("CustomerAccountProperty", generator);
/* 3516 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3518 */           return (Class)AwardAccountPropertyDBA.class;
/*      */         }
/*      */       };
/* 3521 */     addAdapter("dtv.xst.dao.cat.AwardAccountPropertyId", generator);
/* 3522 */     addAdapter("dtv.xst.dao.cat.impl.AwardAccountPropertyDAO", generator);
/* 3523 */     addAdapter("dtv.xst.dao.cat.IAwardAccountProperty", generator);
/* 3524 */     addAdapter("AwardAccountProperty", generator);
/* 3525 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3527 */           return (Class)AwardAccountCouponPropertyDBA.class;
/*      */         }
/*      */       };
/* 3530 */     addAdapter("dtv.xst.dao.cat.AwardAccountCouponPropertyId", generator);
/* 3531 */     addAdapter("dtv.xst.dao.cat.impl.AwardAccountCouponPropertyDAO", generator);
/* 3532 */     addAdapter("dtv.xst.dao.cat.IAwardAccountCouponProperty", generator);
/* 3533 */     addAdapter("AwardAccountCouponProperty", generator);
/* 3534 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3536 */           return (Class)ChargeAccountInvoicePropertyDBA.class;
/*      */         }
/*      */       };
/* 3539 */     addAdapter("dtv.xst.dao.cat.ChargeAccountInvoicePropertyId", generator);
/* 3540 */     addAdapter("dtv.xst.dao.cat.impl.ChargeAccountInvoicePropertyDAO", generator);
/* 3541 */     addAdapter("dtv.xst.dao.cat.IChargeAccountInvoiceProperty", generator);
/* 3542 */     addAdapter("ChargeAccountInvoiceProperty", generator);
/* 3543 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3545 */           return (Class)ChargeAccountUserPropertyDBA.class;
/*      */         }
/*      */       };
/* 3548 */     addAdapter("dtv.xst.dao.cat.ChargeAccountUserPropertyId", generator);
/* 3549 */     addAdapter("dtv.xst.dao.cat.impl.ChargeAccountUserPropertyDAO", generator);
/* 3550 */     addAdapter("dtv.xst.dao.cat.IChargeAccountUserProperty", generator);
/* 3551 */     addAdapter("ChargeAccountUserProperty", generator);
/* 3552 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3554 */           return (Class)CustomerAccountJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 3557 */     addAdapter("dtv.xst.dao.cat.CustomerAccountJournalPropertyId", generator);
/* 3558 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountJournalPropertyDAO", generator);
/* 3559 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountJournalProperty", generator);
/* 3560 */     addAdapter("CustomerAccountJournalProperty", generator);
/* 3561 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3563 */           return (Class)CustomerItemAccountActivityPropertyDBA.class;
/*      */         }
/*      */       };
/* 3566 */     addAdapter("dtv.xst.dao.cat.CustomerItemAccountActivityPropertyId", generator);
/* 3567 */     addAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountActivityPropertyDAO", generator);
/* 3568 */     addAdapter("dtv.xst.dao.cat.ICustomerItemAccountActivityProperty", generator);
/* 3569 */     addAdapter("CustomerItemAccountActivityProperty", generator);
/* 3570 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3572 */           return (Class)CustomerItemAccountDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 3575 */     addAdapter("dtv.xst.dao.cat.CustomerItemAccountDetailPropertyId", generator);
/* 3576 */     addAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailPropertyDAO", generator);
/* 3577 */     addAdapter("dtv.xst.dao.cat.ICustomerItemAccountDetailProperty", generator);
/* 3578 */     addAdapter("CustomerItemAccountDetailProperty", generator);
/* 3579 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3581 */           return (Class)CustomerLoyaltyAccountPropertyDBA.class;
/*      */         }
/*      */       };
/* 3584 */     addAdapter("dtv.xst.dao.cat.CustomerLoyaltyAccountPropertyId", generator);
/* 3585 */     addAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyAccountPropertyDAO", generator);
/* 3586 */     addAdapter("dtv.xst.dao.cat.ICustomerLoyaltyAccountProperty", generator);
/* 3587 */     addAdapter("CustomerLoyaltyAccountProperty", generator);
/* 3588 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3590 */           return (Class)CustomerLoyaltyCardPropertyDBA.class;
/*      */         }
/*      */       };
/* 3593 */     addAdapter("dtv.xst.dao.cat.CustomerLoyaltyCardPropertyId", generator);
/* 3594 */     addAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyCardPropertyDAO", generator);
/* 3595 */     addAdapter("dtv.xst.dao.cat.ICustomerLoyaltyCardProperty", generator);
/* 3596 */     addAdapter("CustomerLoyaltyCardProperty", generator);
/* 3597 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3599 */           return (Class)DeliveryModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3602 */     addAdapter("dtv.xst.dao.cat.DeliveryModifierPropertyId", generator);
/* 3603 */     addAdapter("dtv.xst.dao.cat.impl.DeliveryModifierPropertyDAO", generator);
/* 3604 */     addAdapter("dtv.xst.dao.cat.IDeliveryModifierProperty", generator);
/* 3605 */     addAdapter("DeliveryModifierProperty", generator);
/* 3606 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3608 */           return (Class)EscrowAccountPropertyDBA.class;
/*      */         }
/*      */       };
/* 3611 */     addAdapter("dtv.xst.dao.cat.EscrowAccountPropertyId", generator);
/* 3612 */     addAdapter("dtv.xst.dao.cat.impl.EscrowAccountPropertyDAO", generator);
/* 3613 */     addAdapter("dtv.xst.dao.cat.IEscrowAccountProperty", generator);
/* 3614 */     addAdapter("EscrowAccountProperty", generator);
/* 3615 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3617 */           return (Class)ChargeAccountHistoryPropertyDBA.class;
/*      */         }
/*      */       };
/* 3620 */     addAdapter("dtv.xst.dao.cat.ChargeAccountHistoryPropertyId", generator);
/* 3621 */     addAdapter("dtv.xst.dao.cat.impl.ChargeAccountHistoryPropertyDAO", generator);
/* 3622 */     addAdapter("dtv.xst.dao.cat.IChargeAccountHistoryProperty", generator);
/* 3623 */     addAdapter("ChargeAccountHistoryProperty", generator);
/* 3624 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3626 */           return (Class)CustomerAccountNotePropertyDBA.class;
/*      */         }
/*      */       };
/* 3629 */     addAdapter("dtv.xst.dao.cat.CustomerAccountNotePropertyId", generator);
/* 3630 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountNotePropertyDAO", generator);
/* 3631 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountNoteProperty", generator);
/* 3632 */     addAdapter("CustomerAccountNoteProperty", generator);
/* 3633 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3635 */           return (Class)CustomerAccountPlanPropertyDBA.class;
/*      */         }
/*      */       };
/* 3638 */     addAdapter("dtv.xst.dao.cat.CustomerAccountPlanPropertyId", generator);
/* 3639 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountPlanPropertyDAO", generator);
/* 3640 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountPlanProperty", generator);
/* 3641 */     addAdapter("CustomerAccountPlanProperty", generator);
/* 3642 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3644 */           return (Class)EscrowAccountActivityPropertyDBA.class;
/*      */         }
/*      */       };
/* 3647 */     addAdapter("dtv.xst.dao.cat.EscrowAccountActivityPropertyId", generator);
/* 3648 */     addAdapter("dtv.xst.dao.cat.impl.EscrowAccountActivityPropertyDAO", generator);
/* 3649 */     addAdapter("dtv.xst.dao.cat.IEscrowAccountActivityProperty", generator);
/* 3650 */     addAdapter("EscrowAccountActivityProperty", generator);
/* 3651 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3653 */           return (Class)PaymentSchedulePropertyDBA.class;
/*      */         }
/*      */       };
/* 3656 */     addAdapter("dtv.xst.dao.cat.PaymentSchedulePropertyId", generator);
/* 3657 */     addAdapter("dtv.xst.dao.cat.impl.PaymentSchedulePropertyDAO", generator);
/* 3658 */     addAdapter("dtv.xst.dao.cat.IPaymentScheduleProperty", generator);
/* 3659 */     addAdapter("PaymentScheduleProperty", generator);
/* 3660 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3662 */           return (Class)CustomerAccountAuthorizationPropertyDBA.class;
/*      */         }
/*      */       };
/* 3665 */     addAdapter("dtv.xst.dao.cat.CustomerAccountAuthorizationPropertyId", generator);
/* 3666 */     addAdapter("dtv.xst.dao.cat.impl.CustomerAccountAuthorizationPropertyDAO", generator);
/* 3667 */     addAdapter("dtv.xst.dao.cat.ICustomerAccountAuthorizationProperty", generator);
/* 3668 */     addAdapter("CustomerAccountAuthorizationProperty", generator);
/* 3669 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3671 */           return (Class)OrderLinePropertyDBA.class;
/*      */         }
/*      */       };
/* 3674 */     addAdapter("dtv.xst.dao.xom.OrderLinePropertyId", generator);
/* 3675 */     addAdapter("dtv.xst.dao.xom.impl.OrderLinePropertyDAO", generator);
/* 3676 */     addAdapter("dtv.xst.dao.xom.IOrderLineProperty", generator);
/* 3677 */     addAdapter("OrderLineProperty", generator);
/* 3678 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3680 */           return (Class)OrderPropertyDBA.class;
/*      */         }
/*      */       };
/* 3683 */     addAdapter("dtv.xst.dao.xom.OrderPropertyId", generator);
/* 3684 */     addAdapter("dtv.xst.dao.xom.impl.OrderPropertyDAO", generator);
/* 3685 */     addAdapter("dtv.xst.dao.xom.IOrderProperty", generator);
/* 3686 */     addAdapter("OrderProperty", generator);
/* 3687 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3689 */           return (Class)ItemModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3692 */     addAdapter("dtv.xst.dao.xom.ItemModifierPropertyId", generator);
/* 3693 */     addAdapter("dtv.xst.dao.xom.impl.ItemModifierPropertyDAO", generator);
/* 3694 */     addAdapter("dtv.xst.dao.xom.IItemModifierProperty", generator);
/* 3695 */     addAdapter("ItemModifierProperty", generator);
/* 3696 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3698 */           return (Class)AddressModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3701 */     addAdapter("dtv.xst.dao.xom.AddressModifierPropertyId", generator);
/* 3702 */     addAdapter("dtv.xst.dao.xom.impl.AddressModifierPropertyDAO", generator);
/* 3703 */     addAdapter("dtv.xst.dao.xom.IAddressModifierProperty", generator);
/* 3704 */     addAdapter("AddressModifierProperty", generator);
/* 3705 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3707 */           return (Class)BalanceModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3710 */     addAdapter("dtv.xst.dao.xom.BalanceModifierPropertyId", generator);
/* 3711 */     addAdapter("dtv.xst.dao.xom.impl.BalanceModifierPropertyDAO", generator);
/* 3712 */     addAdapter("dtv.xst.dao.xom.IBalanceModifierProperty", generator);
/* 3713 */     addAdapter("BalanceModifierProperty", generator);
/* 3714 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3716 */           return (Class)CustomerModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3719 */     addAdapter("dtv.xst.dao.xom.CustomerModifierPropertyId", generator);
/* 3720 */     addAdapter("dtv.xst.dao.xom.impl.CustomerModifierPropertyDAO", generator);
/* 3721 */     addAdapter("dtv.xst.dao.xom.ICustomerModifierProperty", generator);
/* 3722 */     addAdapter("CustomerModifierProperty", generator);
/* 3723 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3725 */           return (Class)CustomizationModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3728 */     addAdapter("dtv.xst.dao.xom.CustomizationModifierPropertyId", generator);
/* 3729 */     addAdapter("dtv.xst.dao.xom.impl.CustomizationModifierPropertyDAO", generator);
/* 3730 */     addAdapter("dtv.xst.dao.xom.ICustomizationModifierProperty", generator);
/* 3731 */     addAdapter("CustomizationModifierProperty", generator);
/* 3732 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3734 */           return (Class)FeeModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3737 */     addAdapter("dtv.xst.dao.xom.FeeModifierPropertyId", generator);
/* 3738 */     addAdapter("dtv.xst.dao.xom.impl.FeeModifierPropertyDAO", generator);
/* 3739 */     addAdapter("dtv.xst.dao.xom.IFeeModifierProperty", generator);
/* 3740 */     addAdapter("FeeModifierProperty", generator);
/* 3741 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3743 */           return (Class)FulfillmentModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3746 */     addAdapter("dtv.xst.dao.xom.FulfillmentModifierPropertyId", generator);
/* 3747 */     addAdapter("dtv.xst.dao.xom.impl.FulfillmentModifierPropertyDAO", generator);
/* 3748 */     addAdapter("dtv.xst.dao.xom.IFulfillmentModifierProperty", generator);
/* 3749 */     addAdapter("FulfillmentModifierProperty", generator);
/* 3750 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3752 */           return (Class)OrderFeePropertyDBA.class;
/*      */         }
/*      */       };
/* 3755 */     addAdapter("dtv.xst.dao.xom.OrderFeePropertyId", generator);
/* 3756 */     addAdapter("dtv.xst.dao.xom.impl.OrderFeePropertyDAO", generator);
/* 3757 */     addAdapter("dtv.xst.dao.xom.IOrderFeeProperty", generator);
/* 3758 */     addAdapter("OrderFeeProperty", generator);
/* 3759 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3761 */           return (Class)OrderModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3764 */     addAdapter("dtv.xst.dao.xom.OrderModifierPropertyId", generator);
/* 3765 */     addAdapter("dtv.xst.dao.xom.impl.OrderModifierPropertyDAO", generator);
/* 3766 */     addAdapter("dtv.xst.dao.xom.IOrderModifierProperty", generator);
/* 3767 */     addAdapter("OrderModifierProperty", generator);
/* 3768 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3770 */           return (Class)OrderPaymentPropertyDBA.class;
/*      */         }
/*      */       };
/* 3773 */     addAdapter("dtv.xst.dao.xom.OrderPaymentPropertyId", generator);
/* 3774 */     addAdapter("dtv.xst.dao.xom.impl.OrderPaymentPropertyDAO", generator);
/* 3775 */     addAdapter("dtv.xst.dao.xom.IOrderPaymentProperty", generator);
/* 3776 */     addAdapter("OrderPaymentProperty", generator);
/* 3777 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3779 */           return (Class)SourceModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 3782 */     addAdapter("dtv.xst.dao.xom.SourceModifierPropertyId", generator);
/* 3783 */     addAdapter("dtv.xst.dao.xom.impl.SourceModifierPropertyDAO", generator);
/* 3784 */     addAdapter("dtv.xst.dao.xom.ISourceModifierProperty", generator);
/* 3785 */     addAdapter("SourceModifierProperty", generator);
/* 3786 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3788 */           return (Class)DealPropertyDBA.class;
/*      */         }
/*      */       };
/* 3791 */     addAdapter("dtv.xst.dao.prc.DealPropertyId", generator);
/* 3792 */     addAdapter("dtv.xst.dao.prc.impl.DealPropertyDAO", generator);
/* 3793 */     addAdapter("dtv.xst.dao.prc.IDealProperty", generator);
/* 3794 */     addAdapter("DealProperty", generator);
/* 3795 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3797 */           return (Class)DealCustomerGroupsPropertyDBA.class;
/*      */         }
/*      */       };
/* 3800 */     addAdapter("dtv.xst.dao.prc.DealCustomerGroupsPropertyId", generator);
/* 3801 */     addAdapter("dtv.xst.dao.prc.impl.DealCustomerGroupsPropertyDAO", generator);
/* 3802 */     addAdapter("dtv.xst.dao.prc.IDealCustomerGroupsProperty", generator);
/* 3803 */     addAdapter("DealCustomerGroupsProperty", generator);
/* 3804 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3806 */           return (Class)DealDocumentXrefPropertyDBA.class;
/*      */         }
/*      */       };
/* 3809 */     addAdapter("dtv.xst.dao.prc.DealDocumentXrefPropertyId", generator);
/* 3810 */     addAdapter("dtv.xst.dao.prc.impl.DealDocumentXrefPropertyDAO", generator);
/* 3811 */     addAdapter("dtv.xst.dao.prc.IDealDocumentXrefProperty", generator);
/* 3812 */     addAdapter("DealDocumentXrefProperty", generator);
/* 3813 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3815 */           return (Class)DealFieldTestPropertyDBA.class;
/*      */         }
/*      */       };
/* 3818 */     addAdapter("dtv.xst.dao.prc.DealFieldTestPropertyId", generator);
/* 3819 */     addAdapter("dtv.xst.dao.prc.impl.DealFieldTestPropertyDAO", generator);
/* 3820 */     addAdapter("dtv.xst.dao.prc.IDealFieldTestProperty", generator);
/* 3821 */     addAdapter("DealFieldTestProperty", generator);
/* 3822 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3824 */           return (Class)DealItemActionPropertyDBA.class;
/*      */         }
/*      */       };
/* 3827 */     addAdapter("dtv.xst.dao.prc.DealItemActionPropertyId", generator);
/* 3828 */     addAdapter("dtv.xst.dao.prc.impl.DealItemActionPropertyDAO", generator);
/* 3829 */     addAdapter("dtv.xst.dao.prc.IDealItemActionProperty", generator);
/* 3830 */     addAdapter("DealItemActionProperty", generator);
/* 3831 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3833 */           return (Class)DealTriggerPropertyDBA.class;
/*      */         }
/*      */       };
/* 3836 */     addAdapter("dtv.xst.dao.prc.DealTriggerPropertyId", generator);
/* 3837 */     addAdapter("dtv.xst.dao.prc.impl.DealTriggerPropertyDAO", generator);
/* 3838 */     addAdapter("dtv.xst.dao.prc.IDealTriggerProperty", generator);
/* 3839 */     addAdapter("DealTriggerProperty", generator);
/* 3840 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3842 */           return (Class)DealWeekPropertyDBA.class;
/*      */         }
/*      */       };
/* 3845 */     addAdapter("dtv.xst.dao.prc.DealWeekPropertyId", generator);
/* 3846 */     addAdapter("dtv.xst.dao.prc.impl.DealWeekPropertyDAO", generator);
/* 3847 */     addAdapter("dtv.xst.dao.prc.IDealWeekProperty", generator);
/* 3848 */     addAdapter("DealWeekProperty", generator);
/* 3849 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3851 */           return (Class)PayrollPropertyDBA.class;
/*      */         }
/*      */       };
/* 3854 */     addAdapter("dtv.xst.dao.thr.PayrollPropertyId", generator);
/* 3855 */     addAdapter("dtv.xst.dao.thr.impl.PayrollPropertyDAO", generator);
/* 3856 */     addAdapter("dtv.xst.dao.thr.IPayrollProperty", generator);
/* 3857 */     addAdapter("PayrollProperty", generator);
/* 3858 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3860 */           return (Class)PayrollCategoryPropertyDBA.class;
/*      */         }
/*      */       };
/* 3863 */     addAdapter("dtv.xst.dao.thr.PayrollCategoryPropertyId", generator);
/* 3864 */     addAdapter("dtv.xst.dao.thr.impl.PayrollCategoryPropertyDAO", generator);
/* 3865 */     addAdapter("dtv.xst.dao.thr.IPayrollCategoryProperty", generator);
/* 3866 */     addAdapter("PayrollCategoryProperty", generator);
/* 3867 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3869 */           return (Class)PayrollHeaderPropertyDBA.class;
/*      */         }
/*      */       };
/* 3872 */     addAdapter("dtv.xst.dao.thr.PayrollHeaderPropertyId", generator);
/* 3873 */     addAdapter("dtv.xst.dao.thr.impl.PayrollHeaderPropertyDAO", generator);
/* 3874 */     addAdapter("dtv.xst.dao.thr.IPayrollHeaderProperty", generator);
/* 3875 */     addAdapter("PayrollHeaderProperty", generator);
/* 3876 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3878 */           return (Class)PayrollNotesPropertyDBA.class;
/*      */         }
/*      */       };
/* 3881 */     addAdapter("dtv.xst.dao.thr.PayrollNotesPropertyId", generator);
/* 3882 */     addAdapter("dtv.xst.dao.thr.impl.PayrollNotesPropertyDAO", generator);
/* 3883 */     addAdapter("dtv.xst.dao.thr.IPayrollNotesProperty", generator);
/* 3884 */     addAdapter("PayrollNotesProperty", generator);
/* 3885 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3887 */           return (Class)TimecardEntryPropertyDBA.class;
/*      */         }
/*      */       };
/* 3890 */     addAdapter("dtv.xst.dao.thr.TimecardEntryPropertyId", generator);
/* 3891 */     addAdapter("dtv.xst.dao.thr.impl.TimecardEntryPropertyDAO", generator);
/* 3892 */     addAdapter("dtv.xst.dao.thr.ITimecardEntryProperty", generator);
/* 3893 */     addAdapter("TimecardEntryProperty", generator);
/* 3894 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3896 */           return (Class)TimecardEntryCommentPropertyDBA.class;
/*      */         }
/*      */       };
/* 3899 */     addAdapter("dtv.xst.dao.thr.TimecardEntryCommentPropertyId", generator);
/* 3900 */     addAdapter("dtv.xst.dao.thr.impl.TimecardEntryCommentPropertyDAO", generator);
/* 3901 */     addAdapter("dtv.xst.dao.thr.ITimecardEntryCommentProperty", generator);
/* 3902 */     addAdapter("TimecardEntryCommentProperty", generator);
/* 3903 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3905 */           return (Class)TimecardJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 3908 */     addAdapter("dtv.xst.dao.thr.TimecardJournalPropertyId", generator);
/* 3909 */     addAdapter("dtv.xst.dao.thr.impl.TimecardJournalPropertyDAO", generator);
/* 3910 */     addAdapter("dtv.xst.dao.thr.ITimecardJournalProperty", generator);
/* 3911 */     addAdapter("TimecardJournalProperty", generator);
/* 3912 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3914 */           return (Class)TenderOptionsPropertyDBA.class;
/*      */         }
/*      */       };
/* 3917 */     addAdapter("dtv.xst.dao.tnd.TenderOptionsPropertyId", generator);
/* 3918 */     addAdapter("dtv.xst.dao.tnd.impl.TenderOptionsPropertyDAO", generator);
/* 3919 */     addAdapter("dtv.xst.dao.tnd.ITenderOptionsProperty", generator);
/* 3920 */     addAdapter("TenderOptionsProperty", generator);
/* 3921 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3923 */           return (Class)TenderPropertyDBA.class;
/*      */         }
/*      */       };
/* 3926 */     addAdapter("dtv.xst.dao.tnd.TenderPropertyId", generator);
/* 3927 */     addAdapter("dtv.xst.dao.tnd.impl.TenderPropertyDAO", generator);
/* 3928 */     addAdapter("dtv.xst.dao.tnd.ITenderProperty", generator);
/* 3929 */     addAdapter("TenderProperty", generator);
/* 3930 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3932 */           return (Class)TenderAvailabilityPropertyDBA.class;
/*      */         }
/*      */       };
/* 3935 */     addAdapter("dtv.xst.dao.tnd.TenderAvailabilityPropertyId", generator);
/* 3936 */     addAdapter("dtv.xst.dao.tnd.impl.TenderAvailabilityPropertyDAO", generator);
/* 3937 */     addAdapter("dtv.xst.dao.tnd.ITenderAvailabilityProperty", generator);
/* 3938 */     addAdapter("TenderAvailabilityProperty", generator);
/* 3939 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3941 */           return (Class)TenderDenominationPropertyDBA.class;
/*      */         }
/*      */       };
/* 3944 */     addAdapter("dtv.xst.dao.tnd.TenderDenominationPropertyId", generator);
/* 3945 */     addAdapter("dtv.xst.dao.tnd.impl.TenderDenominationPropertyDAO", generator);
/* 3946 */     addAdapter("dtv.xst.dao.tnd.ITenderDenominationProperty", generator);
/* 3947 */     addAdapter("TenderDenominationProperty", generator);
/* 3948 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3950 */           return (Class)TenderExchangeRatePropertyDBA.class;
/*      */         }
/*      */       };
/* 3953 */     addAdapter("dtv.xst.dao.tnd.TenderExchangeRatePropertyId", generator);
/* 3954 */     addAdapter("dtv.xst.dao.tnd.impl.TenderExchangeRatePropertyDAO", generator);
/* 3955 */     addAdapter("dtv.xst.dao.tnd.ITenderExchangeRateProperty", generator);
/* 3956 */     addAdapter("TenderExchangeRateProperty", generator);
/* 3957 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3959 */           return (Class)TenderTypePropertyDBA.class;
/*      */         }
/*      */       };
/* 3962 */     addAdapter("dtv.xst.dao.tnd.TenderTypePropertyId", generator);
/* 3963 */     addAdapter("dtv.xst.dao.tnd.impl.TenderTypePropertyDAO", generator);
/* 3964 */     addAdapter("dtv.xst.dao.tnd.ITenderTypeProperty", generator);
/* 3965 */     addAdapter("TenderTypeProperty", generator);
/* 3966 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3968 */           return (Class)TenderUserSettingsPropertyDBA.class;
/*      */         }
/*      */       };
/* 3971 */     addAdapter("dtv.xst.dao.tnd.TenderUserSettingsPropertyId", generator);
/* 3972 */     addAdapter("dtv.xst.dao.tnd.impl.TenderUserSettingsPropertyDAO", generator);
/* 3973 */     addAdapter("dtv.xst.dao.tnd.ITenderUserSettingsProperty", generator);
/* 3974 */     addAdapter("TenderUserSettingsProperty", generator);
/* 3975 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3977 */           return (Class)IpCashDrawerDevicePropertyDBA.class;
/*      */         }
/*      */       };
/* 3980 */     addAdapter("dtv.xst.dao.ctl.IpCashDrawerDevicePropertyId", generator);
/* 3981 */     addAdapter("dtv.xst.dao.ctl.impl.IpCashDrawerDevicePropertyDAO", generator);
/* 3982 */     addAdapter("dtv.xst.dao.ctl.IIpCashDrawerDeviceProperty", generator);
/* 3983 */     addAdapter("IpCashDrawerDeviceProperty", generator);
/* 3984 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3986 */           return (Class)CheetahClientDeviceAccessPropertyDBA.class;
/*      */         }
/*      */       };
/* 3989 */     addAdapter("dtv.xst.dao.ctl.CheetahClientDeviceAccessPropertyId", generator);
/* 3990 */     addAdapter("dtv.xst.dao.ctl.impl.CheetahClientDeviceAccessPropertyDAO", generator);
/* 3991 */     addAdapter("dtv.xst.dao.ctl.ICheetahClientDeviceAccessProperty", generator);
/* 3992 */     addAdapter("CheetahClientDeviceAccessProperty", generator);
/* 3993 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 3995 */           return (Class)DataLoaderFailurePropertyDBA.class;
/*      */         }
/*      */       };
/* 3998 */     addAdapter("dtv.xst.dao.ctl.DataLoaderFailurePropertyId", generator);
/* 3999 */     addAdapter("dtv.xst.dao.ctl.impl.DataLoaderFailurePropertyDAO", generator);
/* 4000 */     addAdapter("dtv.xst.dao.ctl.IDataLoaderFailureProperty", generator);
/* 4001 */     addAdapter("DataLoaderFailureProperty", generator);
/* 4002 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4004 */           return (Class)DataLoaderSummaryPropertyDBA.class;
/*      */         }
/*      */       };
/* 4007 */     addAdapter("dtv.xst.dao.ctl.DataLoaderSummaryPropertyId", generator);
/* 4008 */     addAdapter("dtv.xst.dao.ctl.impl.DataLoaderSummaryPropertyDAO", generator);
/* 4009 */     addAdapter("dtv.xst.dao.ctl.IDataLoaderSummaryProperty", generator);
/* 4010 */     addAdapter("DataLoaderSummaryProperty", generator);
/* 4011 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4013 */           return (Class)DeviceRegistrationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4016 */     addAdapter("dtv.xst.dao.ctl.DeviceRegistrationPropertyId", generator);
/* 4017 */     addAdapter("dtv.xst.dao.ctl.impl.DeviceRegistrationPropertyDAO", generator);
/* 4018 */     addAdapter("dtv.xst.dao.ctl.IDeviceRegistrationProperty", generator);
/* 4019 */     addAdapter("DeviceRegistrationProperty", generator);
/* 4020 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4022 */           return (Class)VersionPropertyDBA.class;
/*      */         }
/*      */       };
/* 4025 */     addAdapter("dtv.xst.dao.ctl.VersionPropertyId", generator);
/* 4026 */     addAdapter("dtv.xst.dao.ctl.impl.VersionPropertyDAO", generator);
/* 4027 */     addAdapter("dtv.xst.dao.ctl.IVersionProperty", generator);
/* 4028 */     addAdapter("VersionProperty", generator);
/* 4029 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4031 */           return (Class)RetailLocationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4034 */     addAdapter("dtv.xst.dao.loc.RetailLocationPropertyId", generator);
/* 4035 */     addAdapter("dtv.xst.dao.loc.impl.RetailLocationPropertyDAO", generator);
/* 4036 */     addAdapter("dtv.xst.dao.loc.IRetailLocationProperty", generator);
/* 4037 */     addAdapter("RetailLocationProperty", generator);
/* 4038 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4040 */           return (Class)OrgHierarchyPropertyDBA.class;
/*      */         }
/*      */       };
/* 4043 */     addAdapter("dtv.xst.dao.loc.OrgHierarchyPropertyId", generator);
/* 4044 */     addAdapter("dtv.xst.dao.loc.impl.OrgHierarchyPropertyDAO", generator);
/* 4045 */     addAdapter("dtv.xst.dao.loc.IOrgHierarchyProperty", generator);
/* 4046 */     addAdapter("OrgHierarchyProperty", generator);
/* 4047 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4049 */           return (Class)PricingHierarchyPropertyDBA.class;
/*      */         }
/*      */       };
/* 4052 */     addAdapter("dtv.xst.dao.loc.PricingHierarchyPropertyId", generator);
/* 4053 */     addAdapter("dtv.xst.dao.loc.impl.PricingHierarchyPropertyDAO", generator);
/* 4054 */     addAdapter("dtv.xst.dao.loc.IPricingHierarchyProperty", generator);
/* 4055 */     addAdapter("PricingHierarchyProperty", generator);
/* 4056 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4058 */           return (Class)WorkstationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4061 */     addAdapter("dtv.xst.dao.loc.WorkstationPropertyId", generator);
/* 4062 */     addAdapter("dtv.xst.dao.loc.impl.WorkstationPropertyDAO", generator);
/* 4063 */     addAdapter("dtv.xst.dao.loc.IWorkstationProperty", generator);
/* 4064 */     addAdapter("WorkstationProperty", generator);
/* 4065 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4067 */           return (Class)CloseDatesPropertyDBA.class;
/*      */         }
/*      */       };
/* 4070 */     addAdapter("dtv.xst.dao.loc.CloseDatesPropertyId", generator);
/* 4071 */     addAdapter("dtv.xst.dao.loc.impl.CloseDatesPropertyDAO", generator);
/* 4072 */     addAdapter("dtv.xst.dao.loc.ICloseDatesProperty", generator);
/* 4073 */     addAdapter("CloseDatesProperty", generator);
/* 4074 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4076 */           return (Class)ClosingMessagePropertyDBA.class;
/*      */         }
/*      */       };
/* 4079 */     addAdapter("dtv.xst.dao.loc.ClosingMessagePropertyId", generator);
/* 4080 */     addAdapter("dtv.xst.dao.loc.impl.ClosingMessagePropertyDAO", generator);
/* 4081 */     addAdapter("dtv.xst.dao.loc.IClosingMessageProperty", generator);
/* 4082 */     addAdapter("ClosingMessageProperty", generator);
/* 4083 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4085 */           return (Class)CycleQuestionPropertyDBA.class;
/*      */         }
/*      */       };
/* 4088 */     addAdapter("dtv.xst.dao.loc.CycleQuestionPropertyId", generator);
/* 4089 */     addAdapter("dtv.xst.dao.loc.impl.CycleQuestionPropertyDAO", generator);
/* 4090 */     addAdapter("dtv.xst.dao.loc.ICycleQuestionProperty", generator);
/* 4091 */     addAdapter("CycleQuestionProperty", generator);
/* 4092 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4094 */           return (Class)CycleQuestionAnswerPropertyDBA.class;
/*      */         }
/*      */       };
/* 4097 */     addAdapter("dtv.xst.dao.loc.CycleQuestionAnswerPropertyId", generator);
/* 4098 */     addAdapter("dtv.xst.dao.loc.impl.CycleQuestionAnswerPropertyDAO", generator);
/* 4099 */     addAdapter("dtv.xst.dao.loc.ICycleQuestionAnswerProperty", generator);
/* 4100 */     addAdapter("CycleQuestionAnswerProperty", generator);
/* 4101 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4103 */           return (Class)CycleQuestionChoicePropertyDBA.class;
/*      */         }
/*      */       };
/* 4106 */     addAdapter("dtv.xst.dao.loc.CycleQuestionChoicePropertyId", generator);
/* 4107 */     addAdapter("dtv.xst.dao.loc.impl.CycleQuestionChoicePropertyDAO", generator);
/* 4108 */     addAdapter("dtv.xst.dao.loc.ICycleQuestionChoiceProperty", generator);
/* 4109 */     addAdapter("CycleQuestionChoiceProperty", generator);
/* 4110 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4112 */           return (Class)StateJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 4115 */     addAdapter("dtv.xst.dao.loc.StateJournalPropertyId", generator);
/* 4116 */     addAdapter("dtv.xst.dao.loc.impl.StateJournalPropertyDAO", generator);
/* 4117 */     addAdapter("dtv.xst.dao.loc.IStateJournalProperty", generator);
/* 4118 */     addAdapter("StateJournalProperty", generator);
/* 4119 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4121 */           return (Class)FlightInformationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4124 */     addAdapter("dtv.xst.dao.com.FlightInformationPropertyId", generator);
/* 4125 */     addAdapter("dtv.xst.dao.com.impl.FlightInformationPropertyDAO", generator);
/* 4126 */     addAdapter("dtv.xst.dao.com.IFlightInformationProperty", generator);
/* 4127 */     addAdapter("FlightInformationProperty", generator);
/* 4128 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4130 */           return (Class)AirportPropertyDBA.class;
/*      */         }
/*      */       };
/* 4133 */     addAdapter("dtv.xst.dao.com.AirportPropertyId", generator);
/* 4134 */     addAdapter("dtv.xst.dao.com.impl.AirportPropertyDAO", generator);
/* 4135 */     addAdapter("dtv.xst.dao.com.IAirportProperty", generator);
/* 4136 */     addAdapter("AirportProperty", generator);
/* 4137 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4139 */           return (Class)ButtonGridPropertyDBA.class;
/*      */         }
/*      */       };
/* 4142 */     addAdapter("dtv.xst.dao.com.ButtonGridPropertyId", generator);
/* 4143 */     addAdapter("dtv.xst.dao.com.impl.ButtonGridPropertyDAO", generator);
/* 4144 */     addAdapter("dtv.xst.dao.com.IButtonGridProperty", generator);
/* 4145 */     addAdapter("ButtonGridProperty", generator);
/* 4146 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4148 */           return (Class)CodeValuePropertyDBA.class;
/*      */         }
/*      */       };
/* 4151 */     addAdapter("dtv.xst.dao.com.CodeValuePropertyId", generator);
/* 4152 */     addAdapter("dtv.xst.dao.com.impl.CodeValuePropertyDAO", generator);
/* 4153 */     addAdapter("dtv.xst.dao.com.ICodeValueProperty", generator);
/* 4154 */     addAdapter("CodeValueProperty", generator);
/* 4155 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4157 */           return (Class)DatabaseTranslationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4160 */     addAdapter("dtv.xst.dao.com.DatabaseTranslationPropertyId", generator);
/* 4161 */     addAdapter("dtv.xst.dao.com.impl.DatabaseTranslationPropertyDAO", generator);
/* 4162 */     addAdapter("dtv.xst.dao.com.IDatabaseTranslationProperty", generator);
/* 4163 */     addAdapter("DatabaseTranslationProperty", generator);
/* 4164 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4166 */           return (Class)SequencePropertyDBA.class;
/*      */         }
/*      */       };
/* 4169 */     addAdapter("dtv.xst.dao.com.SequencePropertyId", generator);
/* 4170 */     addAdapter("dtv.xst.dao.com.impl.SequencePropertyDAO", generator);
/* 4171 */     addAdapter("dtv.xst.dao.com.ISequenceProperty", generator);
/* 4172 */     addAdapter("SequenceProperty", generator);
/* 4173 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4175 */           return (Class)AddressPropertyDBA.class;
/*      */         }
/*      */       };
/* 4178 */     addAdapter("dtv.xst.dao.com.AddressPropertyId", generator);
/* 4179 */     addAdapter("dtv.xst.dao.com.impl.AddressPropertyDAO", generator);
/* 4180 */     addAdapter("dtv.xst.dao.com.IAddressProperty", generator);
/* 4181 */     addAdapter("AddressProperty", generator);
/* 4182 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4184 */           return (Class)AddressCountryPropertyDBA.class;
/*      */         }
/*      */       };
/* 4187 */     addAdapter("dtv.xst.dao.com.AddressCountryPropertyId", generator);
/* 4188 */     addAdapter("dtv.xst.dao.com.impl.AddressCountryPropertyDAO", generator);
/* 4189 */     addAdapter("dtv.xst.dao.com.IAddressCountryProperty", generator);
/* 4190 */     addAdapter("AddressCountryProperty", generator);
/* 4191 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4193 */           return (Class)AddressPostalCodePropertyDBA.class;
/*      */         }
/*      */       };
/* 4196 */     addAdapter("dtv.xst.dao.com.AddressPostalCodePropertyId", generator);
/* 4197 */     addAdapter("dtv.xst.dao.com.impl.AddressPostalCodePropertyDAO", generator);
/* 4198 */     addAdapter("dtv.xst.dao.com.IAddressPostalCodeProperty", generator);
/* 4199 */     addAdapter("AddressPostalCodeProperty", generator);
/* 4200 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4202 */           return (Class)AddressStatePropertyDBA.class;
/*      */         }
/*      */       };
/* 4205 */     addAdapter("dtv.xst.dao.com.AddressStatePropertyId", generator);
/* 4206 */     addAdapter("dtv.xst.dao.com.impl.AddressStatePropertyDAO", generator);
/* 4207 */     addAdapter("dtv.xst.dao.com.IAddressStateProperty", generator);
/* 4208 */     addAdapter("AddressStateProperty", generator);
/* 4209 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4211 */           return (Class)CountryReturnMapPropertyDBA.class;
/*      */         }
/*      */       };
/* 4214 */     addAdapter("dtv.xst.dao.com.CountryReturnMapPropertyId", generator);
/* 4215 */     addAdapter("dtv.xst.dao.com.impl.CountryReturnMapPropertyDAO", generator);
/* 4216 */     addAdapter("dtv.xst.dao.com.ICountryReturnMapProperty", generator);
/* 4217 */     addAdapter("CountryReturnMapProperty", generator);
/* 4218 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4220 */           return (Class)ReasonCodePropertyDBA.class;
/*      */         }
/*      */       };
/* 4223 */     addAdapter("dtv.xst.dao.com.ReasonCodePropertyId", generator);
/* 4224 */     addAdapter("dtv.xst.dao.com.impl.ReasonCodePropertyDAO", generator);
/* 4225 */     addAdapter("dtv.xst.dao.com.IReasonCodeProperty", generator);
/* 4226 */     addAdapter("ReasonCodeProperty", generator);
/* 4227 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4229 */           return (Class)ReceiptTextPropertyDBA.class;
/*      */         }
/*      */       };
/* 4232 */     addAdapter("dtv.xst.dao.com.ReceiptTextPropertyId", generator);
/* 4233 */     addAdapter("dtv.xst.dao.com.impl.ReceiptTextPropertyDAO", generator);
/* 4234 */     addAdapter("dtv.xst.dao.com.IReceiptTextProperty", generator);
/* 4235 */     addAdapter("ReceiptTextProperty", generator);
/* 4236 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4238 */           return (Class)ReportDataPropertyDBA.class;
/*      */         }
/*      */       };
/* 4241 */     addAdapter("dtv.xst.dao.com.ReportDataPropertyId", generator);
/* 4242 */     addAdapter("dtv.xst.dao.com.impl.ReportDataPropertyDAO", generator);
/* 4243 */     addAdapter("dtv.xst.dao.com.IReportDataProperty", generator);
/* 4244 */     addAdapter("ReportDataProperty", generator);
/* 4245 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4247 */           return (Class)ReportLookupPropertyDBA.class;
/*      */         }
/*      */       };
/* 4250 */     addAdapter("dtv.xst.dao.com.ReportLookupPropertyId", generator);
/* 4251 */     addAdapter("dtv.xst.dao.com.impl.ReportLookupPropertyDAO", generator);
/* 4252 */     addAdapter("dtv.xst.dao.com.IReportLookupProperty", generator);
/* 4253 */     addAdapter("ReportLookupProperty", generator);
/* 4254 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4256 */           return (Class)SequencePartPropertyDBA.class;
/*      */         }
/*      */       };
/* 4259 */     addAdapter("dtv.xst.dao.com.SequencePartPropertyId", generator);
/* 4260 */     addAdapter("dtv.xst.dao.com.impl.SequencePartPropertyDAO", generator);
/* 4261 */     addAdapter("dtv.xst.dao.com.ISequencePartProperty", generator);
/* 4262 */     addAdapter("SequencePartProperty", generator);
/* 4263 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4265 */           return (Class)ShippingCostPropertyDBA.class;
/*      */         }
/*      */       };
/* 4268 */     addAdapter("dtv.xst.dao.com.ShippingCostPropertyId", generator);
/* 4269 */     addAdapter("dtv.xst.dao.com.impl.ShippingCostPropertyDAO", generator);
/* 4270 */     addAdapter("dtv.xst.dao.com.IShippingCostProperty", generator);
/* 4271 */     addAdapter("ShippingCostProperty", generator);
/* 4272 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4274 */           return (Class)TransactionPropertyPromptPropertyDBA.class;
/*      */         }
/*      */       };
/* 4277 */     addAdapter("dtv.xst.dao.com.TransactionPropertyPromptPropertyId", generator);
/* 4278 */     addAdapter("dtv.xst.dao.com.impl.TransactionPropertyPromptPropertyDAO", generator);
/* 4279 */     addAdapter("dtv.xst.dao.com.ITransactionPropertyPromptProperty", generator);
/* 4280 */     addAdapter("TransactionPropertyPromptProperty", generator);
/* 4281 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4283 */           return (Class)AirportZonePropertyDBA.class;
/*      */         }
/*      */       };
/* 4286 */     addAdapter("dtv.xst.dao.com.AirportZonePropertyId", generator);
/* 4287 */     addAdapter("dtv.xst.dao.com.impl.AirportZonePropertyDAO", generator);
/* 4288 */     addAdapter("dtv.xst.dao.com.IAirportZoneProperty", generator);
/* 4289 */     addAdapter("AirportZoneProperty", generator);
/* 4290 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4292 */           return (Class)AirportZoneDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 4295 */     addAdapter("dtv.xst.dao.com.AirportZoneDetailPropertyId", generator);
/* 4296 */     addAdapter("dtv.xst.dao.com.impl.AirportZoneDetailPropertyDAO", generator);
/* 4297 */     addAdapter("dtv.xst.dao.com.IAirportZoneDetailProperty", generator);
/* 4298 */     addAdapter("AirportZoneDetailProperty", generator);
/* 4299 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4301 */           return (Class)ShippingFeePropertyDBA.class;
/*      */         }
/*      */       };
/* 4304 */     addAdapter("dtv.xst.dao.com.ShippingFeePropertyId", generator);
/* 4305 */     addAdapter("dtv.xst.dao.com.impl.ShippingFeePropertyDAO", generator);
/* 4306 */     addAdapter("dtv.xst.dao.com.IShippingFeeProperty", generator);
/* 4307 */     addAdapter("ShippingFeeProperty", generator);
/* 4308 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4310 */           return (Class)ShippingFeeTierPropertyDBA.class;
/*      */         }
/*      */       };
/* 4313 */     addAdapter("dtv.xst.dao.com.ShippingFeeTierPropertyId", generator);
/* 4314 */     addAdapter("dtv.xst.dao.com.impl.ShippingFeeTierPropertyDAO", generator);
/* 4315 */     addAdapter("dtv.xst.dao.com.IShippingFeeTierProperty", generator);
/* 4316 */     addAdapter("ShippingFeeTierProperty", generator);
/* 4317 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4319 */           return (Class)XunitResultPropertyDBA.class;
/*      */         }
/*      */       };
/* 4322 */     addAdapter("dtv.xst.dao._test.XunitResultPropertyId", generator);
/* 4323 */     addAdapter("dtv.xst.dao._test.impl.XunitResultPropertyDAO", generator);
/* 4324 */     addAdapter("dtv.xst.dao._test.IXunitResultProperty", generator);
/* 4325 */     addAdapter("XunitResultProperty", generator);
/* 4326 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4328 */           return (Class)XunitResultItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4331 */     addAdapter("dtv.xst.dao._test.XunitResultItemPropertyId", generator);
/* 4332 */     addAdapter("dtv.xst.dao._test.impl.XunitResultItemPropertyDAO", generator);
/* 4333 */     addAdapter("dtv.xst.dao._test.IXunitResultItemProperty", generator);
/* 4334 */     addAdapter("XunitResultItemProperty", generator);
/* 4335 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4337 */           return (Class)WorkCodesPropertyDBA.class;
/*      */         }
/*      */       };
/* 4340 */     addAdapter("dtv.xst.dao.hrs.WorkCodesPropertyId", generator);
/* 4341 */     addAdapter("dtv.xst.dao.hrs.impl.WorkCodesPropertyDAO", generator);
/* 4342 */     addAdapter("dtv.xst.dao.hrs.IWorkCodesProperty", generator);
/* 4343 */     addAdapter("WorkCodesProperty", generator);
/* 4344 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4346 */           return (Class)EmployeePropertyDBA.class;
/*      */         }
/*      */       };
/* 4349 */     addAdapter("dtv.xst.dao.hrs.EmployeePropertyId", generator);
/* 4350 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeePropertyDAO", generator);
/* 4351 */     addAdapter("dtv.xst.dao.hrs.IEmployeeProperty", generator);
/* 4352 */     addAdapter("EmployeeProperty", generator);
/* 4353 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4355 */           return (Class)EmployeeFingerprintPropertyDBA.class;
/*      */         }
/*      */       };
/* 4358 */     addAdapter("dtv.xst.dao.hrs.EmployeeFingerprintPropertyId", generator);
/* 4359 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeFingerprintPropertyDAO", generator);
/* 4360 */     addAdapter("dtv.xst.dao.hrs.IEmployeeFingerprintProperty", generator);
/* 4361 */     addAdapter("EmployeeFingerprintProperty", generator);
/* 4362 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4364 */           return (Class)EmployeeMessagePropertyDBA.class;
/*      */         }
/*      */       };
/* 4367 */     addAdapter("dtv.xst.dao.hrs.EmployeeMessagePropertyId", generator);
/* 4368 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeMessagePropertyDAO", generator);
/* 4369 */     addAdapter("dtv.xst.dao.hrs.IEmployeeMessageProperty", generator);
/* 4370 */     addAdapter("EmployeeMessageProperty", generator);
/* 4371 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4373 */           return (Class)EmployeeAnswersPropertyDBA.class;
/*      */         }
/*      */       };
/* 4376 */     addAdapter("dtv.xst.dao.hrs.EmployeeAnswersPropertyId", generator);
/* 4377 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeAnswersPropertyDAO", generator);
/* 4378 */     addAdapter("dtv.xst.dao.hrs.IEmployeeAnswersProperty", generator);
/* 4379 */     addAdapter("EmployeeAnswersProperty", generator);
/* 4380 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4382 */           return (Class)EmployeeNotePropertyDBA.class;
/*      */         }
/*      */       };
/* 4385 */     addAdapter("dtv.xst.dao.hrs.EmployeeNotePropertyId", generator);
/* 4386 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeNotePropertyDAO", generator);
/* 4387 */     addAdapter("dtv.xst.dao.hrs.IEmployeeNoteProperty", generator);
/* 4388 */     addAdapter("EmployeeNoteProperty", generator);
/* 4389 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4391 */           return (Class)EmployeePasswordPropertyDBA.class;
/*      */         }
/*      */       };
/* 4394 */     addAdapter("dtv.xst.dao.hrs.EmployeePasswordPropertyId", generator);
/* 4395 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeePasswordPropertyDAO", generator);
/* 4396 */     addAdapter("dtv.xst.dao.hrs.IEmployeePasswordProperty", generator);
/* 4397 */     addAdapter("EmployeePasswordProperty", generator);
/* 4398 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4400 */           return (Class)EmployeeStorePropertyDBA.class;
/*      */         }
/*      */       };
/* 4403 */     addAdapter("dtv.xst.dao.hrs.EmployeeStorePropertyId", generator);
/* 4404 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeStorePropertyDAO", generator);
/* 4405 */     addAdapter("dtv.xst.dao.hrs.IEmployeeStoreProperty", generator);
/* 4406 */     addAdapter("EmployeeStoreProperty", generator);
/* 4407 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4409 */           return (Class)EmployeeTaskPropertyDBA.class;
/*      */         }
/*      */       };
/* 4412 */     addAdapter("dtv.xst.dao.hrs.EmployeeTaskPropertyId", generator);
/* 4413 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskPropertyDAO", generator);
/* 4414 */     addAdapter("dtv.xst.dao.hrs.IEmployeeTaskProperty", generator);
/* 4415 */     addAdapter("EmployeeTaskProperty", generator);
/* 4416 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4418 */           return (Class)EmployeeTaskNotePropertyDBA.class;
/*      */         }
/*      */       };
/* 4421 */     addAdapter("dtv.xst.dao.hrs.EmployeeTaskNotePropertyId", generator);
/* 4422 */     addAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskNotePropertyDAO", generator);
/* 4423 */     addAdapter("dtv.xst.dao.hrs.IEmployeeTaskNoteProperty", generator);
/* 4424 */     addAdapter("EmployeeTaskNoteProperty", generator);
/* 4425 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4427 */           return (Class)UserPasswordPropertyDBA.class;
/*      */         }
/*      */       };
/* 4430 */     addAdapter("dtv.xst.dao.sec.UserPasswordPropertyId", generator);
/* 4431 */     addAdapter("dtv.xst.dao.sec.impl.UserPasswordPropertyDAO", generator);
/* 4432 */     addAdapter("dtv.xst.dao.sec.IUserPasswordProperty", generator);
/* 4433 */     addAdapter("UserPasswordProperty", generator);
/* 4434 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4436 */           return (Class)UserRolePropertyDBA.class;
/*      */         }
/*      */       };
/* 4439 */     addAdapter("dtv.xst.dao.sec.UserRolePropertyId", generator);
/* 4440 */     addAdapter("dtv.xst.dao.sec.impl.UserRolePropertyDAO", generator);
/* 4441 */     addAdapter("dtv.xst.dao.sec.IUserRoleProperty", generator);
/* 4442 */     addAdapter("UserRoleProperty", generator);
/* 4443 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4445 */           return (Class)AccessControlListPropertyDBA.class;
/*      */         }
/*      */       };
/* 4448 */     addAdapter("dtv.xst.dao.sec.AccessControlListPropertyId", generator);
/* 4449 */     addAdapter("dtv.xst.dao.sec.impl.AccessControlListPropertyDAO", generator);
/* 4450 */     addAdapter("dtv.xst.dao.sec.IAccessControlListProperty", generator);
/* 4451 */     addAdapter("AccessControlListProperty", generator);
/* 4452 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4454 */           return (Class)AclAccessTypePropertyDBA.class;
/*      */         }
/*      */       };
/* 4457 */     addAdapter("dtv.xst.dao.sec.AclAccessTypePropertyId", generator);
/* 4458 */     addAdapter("dtv.xst.dao.sec.impl.AclAccessTypePropertyDAO", generator);
/* 4459 */     addAdapter("dtv.xst.dao.sec.IAclAccessTypeProperty", generator);
/* 4460 */     addAdapter("AclAccessTypeProperty", generator);
/* 4461 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4463 */           return (Class)GroupPropertyDBA.class;
/*      */         }
/*      */       };
/* 4466 */     addAdapter("dtv.xst.dao.sec.GroupPropertyId", generator);
/* 4467 */     addAdapter("dtv.xst.dao.sec.impl.GroupPropertyDAO", generator);
/* 4468 */     addAdapter("dtv.xst.dao.sec.IGroupProperty", generator);
/* 4469 */     addAdapter("GroupProperty", generator);
/* 4470 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4472 */           return (Class)PrivilegePropertyDBA.class;
/*      */         }
/*      */       };
/* 4475 */     addAdapter("dtv.xst.dao.sec.PrivilegePropertyId", generator);
/* 4476 */     addAdapter("dtv.xst.dao.sec.impl.PrivilegePropertyDAO", generator);
/* 4477 */     addAdapter("dtv.xst.dao.sec.IPrivilegeProperty", generator);
/* 4478 */     addAdapter("PrivilegeProperty", generator);
/* 4479 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4481 */           return (Class)CartonPropertyDBA.class;
/*      */         }
/*      */       };
/* 4484 */     addAdapter("dtv.xst.dao.inv.CartonPropertyId", generator);
/* 4485 */     addAdapter("dtv.xst.dao.inv.impl.CartonPropertyDAO", generator);
/* 4486 */     addAdapter("dtv.xst.dao.inv.ICartonProperty", generator);
/* 4487 */     addAdapter("CartonProperty", generator);
/* 4488 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4490 */           return (Class)InventoryDocumentPropertyDBA.class;
/*      */         }
/*      */       };
/* 4493 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentPropertyId", generator);
/* 4494 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentPropertyDAO", generator);
/* 4495 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentProperty", generator);
/* 4496 */     addAdapter("InventoryDocumentProperty", generator);
/* 4497 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4499 */           return (Class)InventoryDocumentLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4502 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentLineItemPropertyId", generator);
/* 4503 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemPropertyDAO", generator);
/* 4504 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentLineItemProperty", generator);
/* 4505 */     addAdapter("InventoryDocumentLineItemProperty", generator);
/* 4506 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4508 */           return (Class)InventoryTransactionDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 4511 */     addAdapter("dtv.xst.dao.inv.InventoryTransactionDetailPropertyId", generator);
/* 4512 */     addAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDetailPropertyDAO", generator);
/* 4513 */     addAdapter("dtv.xst.dao.inv.IInventoryTransactionDetailProperty", generator);
/* 4514 */     addAdapter("InventoryTransactionDetailProperty", generator);
/* 4515 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4517 */           return (Class)InventoryCountPropertyDBA.class;
/*      */         }
/*      */       };
/* 4520 */     addAdapter("dtv.xst.dao.inv.InventoryCountPropertyId", generator);
/* 4521 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountPropertyDAO", generator);
/* 4522 */     addAdapter("dtv.xst.dao.inv.IInventoryCountProperty", generator);
/* 4523 */     addAdapter("InventoryCountProperty", generator);
/* 4524 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4526 */           return (Class)InventoryCountSectionPropertyDBA.class;
/*      */         }
/*      */       };
/* 4529 */     addAdapter("dtv.xst.dao.inv.InventoryCountSectionPropertyId", generator);
/* 4530 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionPropertyDAO", generator);
/* 4531 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSectionProperty", generator);
/* 4532 */     addAdapter("InventoryCountSectionProperty", generator);
/* 4533 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4535 */           return (Class)InventoryCountSheetPropertyDBA.class;
/*      */         }
/*      */       };
/* 4538 */     addAdapter("dtv.xst.dao.inv.InventoryCountSheetPropertyId", generator);
/* 4539 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetPropertyDAO", generator);
/* 4540 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSheetProperty", generator);
/* 4541 */     addAdapter("InventoryCountSheetProperty", generator);
/* 4542 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4544 */           return (Class)InventoryLocationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4547 */     addAdapter("dtv.xst.dao.inv.InventoryLocationPropertyId", generator);
/* 4548 */     addAdapter("dtv.xst.dao.inv.impl.InventoryLocationPropertyDAO", generator);
/* 4549 */     addAdapter("dtv.xst.dao.inv.IInventoryLocationProperty", generator);
/* 4550 */     addAdapter("InventoryLocationProperty", generator);
/* 4551 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4553 */           return (Class)InventoryMovementPendingPropertyDBA.class;
/*      */         }
/*      */       };
/* 4556 */     addAdapter("dtv.xst.dao.inv.InventoryMovementPendingPropertyId", generator);
/* 4557 */     addAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingPropertyDAO", generator);
/* 4558 */     addAdapter("dtv.xst.dao.inv.IInventoryMovementPendingProperty", generator);
/* 4559 */     addAdapter("InventoryMovementPendingProperty", generator);
/* 4560 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4562 */           return (Class)MovementPendingTransactionLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4565 */     addAdapter("dtv.xst.dao.inv.MovementPendingTransactionLineItemPropertyId", generator);
/* 4566 */     addAdapter("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemPropertyDAO", generator);
/* 4567 */     addAdapter("dtv.xst.dao.inv.IMovementPendingTransactionLineItemProperty", generator);
/* 4568 */     addAdapter("MovementPendingTransactionLineItemProperty", generator);
/* 4569 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4571 */           return (Class)ShipmentPropertyDBA.class;
/*      */         }
/*      */       };
/* 4574 */     addAdapter("dtv.xst.dao.inv.ShipmentPropertyId", generator);
/* 4575 */     addAdapter("dtv.xst.dao.inv.impl.ShipmentPropertyDAO", generator);
/* 4576 */     addAdapter("dtv.xst.dao.inv.IShipmentProperty", generator);
/* 4577 */     addAdapter("ShipmentProperty", generator);
/* 4578 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4580 */           return (Class)ShipmentLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4583 */     addAdapter("dtv.xst.dao.inv.ShipmentLineItemPropertyId", generator);
/* 4584 */     addAdapter("dtv.xst.dao.inv.impl.ShipmentLineItemPropertyDAO", generator);
/* 4585 */     addAdapter("dtv.xst.dao.inv.IShipmentLineItemProperty", generator);
/* 4586 */     addAdapter("ShipmentLineItemProperty", generator);
/* 4587 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4589 */           return (Class)ShipmentAddressPropertyDBA.class;
/*      */         }
/*      */       };
/* 4592 */     addAdapter("dtv.xst.dao.inv.ShipmentAddressPropertyId", generator);
/* 4593 */     addAdapter("dtv.xst.dao.inv.impl.ShipmentAddressPropertyDAO", generator);
/* 4594 */     addAdapter("dtv.xst.dao.inv.IShipmentAddressProperty", generator);
/* 4595 */     addAdapter("ShipmentAddressProperty", generator);
/* 4596 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4598 */           return (Class)InventoryItemAccountModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 4601 */     addAdapter("dtv.xst.dao.inv.InventoryItemAccountModifierPropertyId", generator);
/* 4602 */     addAdapter("dtv.xst.dao.inv.impl.InventoryItemAccountModifierPropertyDAO", generator);
/* 4603 */     addAdapter("dtv.xst.dao.inv.IInventoryItemAccountModifierProperty", generator);
/* 4604 */     addAdapter("InventoryItemAccountModifierProperty", generator);
/* 4605 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4607 */           return (Class)DocumentInventoryLocationModifierPropertyDBA.class;
/*      */         }
/*      */       };
/* 4610 */     addAdapter("dtv.xst.dao.inv.DocumentInventoryLocationModifierPropertyId", generator);
/* 4611 */     addAdapter("dtv.xst.dao.inv.impl.DocumentInventoryLocationModifierPropertyDAO", generator);
/* 4612 */     addAdapter("dtv.xst.dao.inv.IDocumentInventoryLocationModifierProperty", generator);
/* 4613 */     addAdapter("DocumentInventoryLocationModifierProperty", generator);
/* 4614 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4616 */           return (Class)DocumentNotePropertyDBA.class;
/*      */         }
/*      */       };
/* 4619 */     addAdapter("dtv.xst.dao.inv.DocumentNotePropertyId", generator);
/* 4620 */     addAdapter("dtv.xst.dao.inv.impl.DocumentNotePropertyDAO", generator);
/* 4621 */     addAdapter("dtv.xst.dao.inv.IDocumentNoteProperty", generator);
/* 4622 */     addAdapter("DocumentNoteProperty", generator);
/* 4623 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4625 */           return (Class)FiscalYearPropertyDBA.class;
/*      */         }
/*      */       };
/* 4628 */     addAdapter("dtv.xst.dao.inv.FiscalYearPropertyId", generator);
/* 4629 */     addAdapter("dtv.xst.dao.inv.impl.FiscalYearPropertyDAO", generator);
/* 4630 */     addAdapter("dtv.xst.dao.inv.IFiscalYearProperty", generator);
/* 4631 */     addAdapter("FiscalYearProperty", generator);
/* 4632 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4634 */           return (Class)InventoryBucketPropertyDBA.class;
/*      */         }
/*      */       };
/* 4637 */     addAdapter("dtv.xst.dao.inv.InventoryBucketPropertyId", generator);
/* 4638 */     addAdapter("dtv.xst.dao.inv.impl.InventoryBucketPropertyDAO", generator);
/* 4639 */     addAdapter("dtv.xst.dao.inv.IInventoryBucketProperty", generator);
/* 4640 */     addAdapter("InventoryBucketProperty", generator);
/* 4641 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4643 */           return (Class)InventoryDocumentCrossReferencePropertyDBA.class;
/*      */         }
/*      */       };
/* 4646 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentCrossReferencePropertyId", generator);
/* 4647 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentCrossReferencePropertyDAO", generator);
/* 4648 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentCrossReferenceProperty", generator);
/* 4649 */     addAdapter("InventoryDocumentCrossReferenceProperty", generator);
/* 4650 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4652 */           return (Class)InventoryCostItemYearEndPropertyDBA.class;
/*      */         }
/*      */       };
/* 4655 */     addAdapter("dtv.xst.dao.inv.InventoryCostItemYearEndPropertyId", generator);
/* 4656 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCostItemYearEndPropertyDAO", generator);
/* 4657 */     addAdapter("dtv.xst.dao.inv.IInventoryCostItemYearEndProperty", generator);
/* 4658 */     addAdapter("InventoryCostItemYearEndProperty", generator);
/* 4659 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4661 */           return (Class)InventoryCountBucketPropertyDBA.class;
/*      */         }
/*      */       };
/* 4664 */     addAdapter("dtv.xst.dao.inv.InventoryCountBucketPropertyId", generator);
/* 4665 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountBucketPropertyDAO", generator);
/* 4666 */     addAdapter("dtv.xst.dao.inv.IInventoryCountBucketProperty", generator);
/* 4667 */     addAdapter("InventoryCountBucketProperty", generator);
/* 4668 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4670 */           return (Class)InventoryCountSectionDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 4673 */     addAdapter("dtv.xst.dao.inv.InventoryCountSectionDetailPropertyId", generator);
/* 4674 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionDetailPropertyDAO", generator);
/* 4675 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSectionDetailProperty", generator);
/* 4676 */     addAdapter("InventoryCountSectionDetailProperty", generator);
/* 4677 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4679 */           return (Class)InventoryCountSheetLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4682 */     addAdapter("dtv.xst.dao.inv.InventoryCountSheetLineItemPropertyId", generator);
/* 4683 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetLineItemPropertyDAO", generator);
/* 4684 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSheetLineItemProperty", generator);
/* 4685 */     addAdapter("InventoryCountSheetLineItemProperty", generator);
/* 4686 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4688 */           return (Class)InventoryCountSnapshotPropertyDBA.class;
/*      */         }
/*      */       };
/* 4691 */     addAdapter("dtv.xst.dao.inv.InventoryCountSnapshotPropertyId", generator);
/* 4692 */     addAdapter("dtv.xst.dao.inv.impl.InventoryCountSnapshotPropertyDAO", generator);
/* 4693 */     addAdapter("dtv.xst.dao.inv.IInventoryCountSnapshotProperty", generator);
/* 4694 */     addAdapter("InventoryCountSnapshotProperty", generator);
/* 4695 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4697 */           return (Class)InventoryJournalPropertyDBA.class;
/*      */         }
/*      */       };
/* 4700 */     addAdapter("dtv.xst.dao.inv.InventoryJournalPropertyId", generator);
/* 4701 */     addAdapter("dtv.xst.dao.inv.impl.InventoryJournalPropertyDAO", generator);
/* 4702 */     addAdapter("dtv.xst.dao.inv.IInventoryJournalProperty", generator);
/* 4703 */     addAdapter("InventoryJournalProperty", generator);
/* 4704 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4706 */           return (Class)InventoryLocationAvailabilityPropertyDBA.class;
/*      */         }
/*      */       };
/* 4709 */     addAdapter("dtv.xst.dao.inv.InventoryLocationAvailabilityPropertyId", generator);
/* 4710 */     addAdapter("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityPropertyDAO", generator);
/* 4711 */     addAdapter("dtv.xst.dao.inv.IInventoryLocationAvailabilityProperty", generator);
/* 4712 */     addAdapter("InventoryLocationAvailabilityProperty", generator);
/* 4713 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4715 */           return (Class)InventoryLocationBucketPropertyDBA.class;
/*      */         }
/*      */       };
/* 4718 */     addAdapter("dtv.xst.dao.inv.InventoryLocationBucketPropertyId", generator);
/* 4719 */     addAdapter("dtv.xst.dao.inv.impl.InventoryLocationBucketPropertyDAO", generator);
/* 4720 */     addAdapter("dtv.xst.dao.inv.IInventoryLocationBucketProperty", generator);
/* 4721 */     addAdapter("InventoryLocationBucketProperty", generator);
/* 4722 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4724 */           return (Class)InventoryMovementPendingDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 4727 */     addAdapter("dtv.xst.dao.inv.InventoryMovementPendingDetailPropertyId", generator);
/* 4728 */     addAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDetailPropertyDAO", generator);
/* 4729 */     addAdapter("dtv.xst.dao.inv.IInventoryMovementPendingDetailProperty", generator);
/* 4730 */     addAdapter("InventoryMovementPendingDetailProperty", generator);
/* 4731 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4733 */           return (Class)InventorySummaryCountTransactionDetailPropertyDBA.class;
/*      */         }
/*      */       };
/* 4736 */     addAdapter("dtv.xst.dao.inv.InventorySummaryCountTransactionDetailPropertyId", generator);
/* 4737 */     addAdapter("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailPropertyDAO", generator);
/* 4738 */     addAdapter("dtv.xst.dao.inv.IInventorySummaryCountTransactionDetailProperty", generator);
/* 4739 */     addAdapter("InventorySummaryCountTransactionDetailProperty", generator);
/* 4740 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4742 */           return (Class)InventoryValidDestinationsPropertyDBA.class;
/*      */         }
/*      */       };
/* 4745 */     addAdapter("dtv.xst.dao.inv.InventoryValidDestinationsPropertyId", generator);
/* 4746 */     addAdapter("dtv.xst.dao.inv.impl.InventoryValidDestinationsPropertyDAO", generator);
/* 4747 */     addAdapter("dtv.xst.dao.inv.IInventoryValidDestinationsProperty", generator);
/* 4748 */     addAdapter("InventoryValidDestinationsProperty", generator);
/* 4749 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4751 */           return (Class)SerializedStockLedgerPropertyDBA.class;
/*      */         }
/*      */       };
/* 4754 */     addAdapter("dtv.xst.dao.inv.SerializedStockLedgerPropertyId", generator);
/* 4755 */     addAdapter("dtv.xst.dao.inv.impl.SerializedStockLedgerPropertyDAO", generator);
/* 4756 */     addAdapter("dtv.xst.dao.inv.ISerializedStockLedgerProperty", generator);
/* 4757 */     addAdapter("SerializedStockLedgerProperty", generator);
/* 4758 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4760 */           return (Class)ShipperPropertyDBA.class;
/*      */         }
/*      */       };
/* 4763 */     addAdapter("dtv.xst.dao.inv.ShipperPropertyId", generator);
/* 4764 */     addAdapter("dtv.xst.dao.inv.impl.ShipperPropertyDAO", generator);
/* 4765 */     addAdapter("dtv.xst.dao.inv.IShipperProperty", generator);
/* 4766 */     addAdapter("ShipperProperty", generator);
/* 4767 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4769 */           return (Class)ShipperMethodPropertyDBA.class;
/*      */         }
/*      */       };
/* 4772 */     addAdapter("dtv.xst.dao.inv.ShipperMethodPropertyId", generator);
/* 4773 */     addAdapter("dtv.xst.dao.inv.impl.ShipperMethodPropertyDAO", generator);
/* 4774 */     addAdapter("dtv.xst.dao.inv.IShipperMethodProperty", generator);
/* 4775 */     addAdapter("ShipperMethodProperty", generator);
/* 4776 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4778 */           return (Class)StockLedgerPropertyDBA.class;
/*      */         }
/*      */       };
/* 4781 */     addAdapter("dtv.xst.dao.inv.StockLedgerPropertyId", generator);
/* 4782 */     addAdapter("dtv.xst.dao.inv.impl.StockLedgerPropertyDAO", generator);
/* 4783 */     addAdapter("dtv.xst.dao.inv.IStockLedgerProperty", generator);
/* 4784 */     addAdapter("StockLedgerProperty", generator);
/* 4785 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4787 */           return (Class)DocumentLineItemNotePropertyDBA.class;
/*      */         }
/*      */       };
/* 4790 */     addAdapter("dtv.xst.dao.inv.DocumentLineItemNotePropertyId", generator);
/* 4791 */     addAdapter("dtv.xst.dao.inv.impl.DocumentLineItemNotePropertyDAO", generator);
/* 4792 */     addAdapter("dtv.xst.dao.inv.IDocumentLineItemNoteProperty", generator);
/* 4793 */     addAdapter("DocumentLineItemNoteProperty", generator);
/* 4794 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4796 */           return (Class)InventoryDocumentLineSerialPropertyDBA.class;
/*      */         }
/*      */       };
/* 4799 */     addAdapter("dtv.xst.dao.inv.InventoryDocumentLineSerialPropertyId", generator);
/* 4800 */     addAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineSerialPropertyDAO", generator);
/* 4801 */     addAdapter("dtv.xst.dao.inv.IInventoryDocumentLineSerialProperty", generator);
/* 4802 */     addAdapter("InventoryDocumentLineSerialProperty", generator);
/* 4803 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4805 */           return (Class)InventoryReplenishmentDocumentLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4808 */     addAdapter("dtv.xst.dao.inv.InventoryReplenishmentDocumentLineItemPropertyId", generator);
/* 4809 */     addAdapter("dtv.xst.dao.inv.impl.InventoryReplenishmentDocumentLineItemPropertyDAO", generator);
/* 4810 */     addAdapter("dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItemProperty", generator);
/* 4811 */     addAdapter("InventoryReplenishmentDocumentLineItemProperty", generator);
/* 4812 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4814 */           return (Class)DiscountPropertyDBA.class;
/*      */         }
/*      */       };
/* 4817 */     addAdapter("dtv.xst.dao.dsc.DiscountPropertyId", generator);
/* 4818 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountPropertyDAO", generator);
/* 4819 */     addAdapter("dtv.xst.dao.dsc.IDiscountProperty", generator);
/* 4820 */     addAdapter("DiscountProperty", generator);
/* 4821 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4823 */           return (Class)CouponPropertyDBA.class;
/*      */         }
/*      */       };
/* 4826 */     addAdapter("dtv.xst.dao.dsc.CouponPropertyId", generator);
/* 4827 */     addAdapter("dtv.xst.dao.dsc.impl.CouponPropertyDAO", generator);
/* 4828 */     addAdapter("dtv.xst.dao.dsc.ICouponProperty", generator);
/* 4829 */     addAdapter("CouponProperty", generator);
/* 4830 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4832 */           return (Class)DiscountCompatabilityPropertyDBA.class;
/*      */         }
/*      */       };
/* 4835 */     addAdapter("dtv.xst.dao.dsc.DiscountCompatabilityPropertyId", generator);
/* 4836 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountCompatabilityPropertyDAO", generator);
/* 4837 */     addAdapter("dtv.xst.dao.dsc.IDiscountCompatabilityProperty", generator);
/* 4838 */     addAdapter("DiscountCompatabilityProperty", generator);
/* 4839 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4841 */           return (Class)DiscountGroupMappingPropertyDBA.class;
/*      */         }
/*      */       };
/* 4844 */     addAdapter("dtv.xst.dao.dsc.DiscountGroupMappingPropertyId", generator);
/* 4845 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountGroupMappingPropertyDAO", generator);
/* 4846 */     addAdapter("dtv.xst.dao.dsc.IDiscountGroupMappingProperty", generator);
/* 4847 */     addAdapter("DiscountGroupMappingProperty", generator);
/* 4848 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4850 */           return (Class)DiscountItemExclusionsPropertyDBA.class;
/*      */         }
/*      */       };
/* 4853 */     addAdapter("dtv.xst.dao.dsc.DiscountItemExclusionsPropertyId", generator);
/* 4854 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountItemExclusionsPropertyDAO", generator);
/* 4855 */     addAdapter("dtv.xst.dao.dsc.IDiscountItemExclusionsProperty", generator);
/* 4856 */     addAdapter("DiscountItemExclusionsProperty", generator);
/* 4857 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4859 */           return (Class)DiscountItemInclusionsPropertyDBA.class;
/*      */         }
/*      */       };
/* 4862 */     addAdapter("dtv.xst.dao.dsc.DiscountItemInclusionsPropertyId", generator);
/* 4863 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountItemInclusionsPropertyDAO", generator);
/* 4864 */     addAdapter("dtv.xst.dao.dsc.IDiscountItemInclusionsProperty", generator);
/* 4865 */     addAdapter("DiscountItemInclusionsProperty", generator);
/* 4866 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4868 */           return (Class)DiscountTypeEligibilityPropertyDBA.class;
/*      */         }
/*      */       };
/* 4871 */     addAdapter("dtv.xst.dao.dsc.DiscountTypeEligibilityPropertyId", generator);
/* 4872 */     addAdapter("dtv.xst.dao.dsc.impl.DiscountTypeEligibilityPropertyDAO", generator);
/* 4873 */     addAdapter("dtv.xst.dao.dsc.IDiscountTypeEligibilityProperty", generator);
/* 4874 */     addAdapter("DiscountTypeEligibilityProperty", generator);
/* 4875 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4877 */           return (Class)InvoicePropertyDBA.class;
/*      */         }
/*      */       };
/* 4880 */     addAdapter("dtv.xst.dao.cwo.InvoicePropertyId", generator);
/* 4881 */     addAdapter("dtv.xst.dao.cwo.impl.InvoicePropertyDAO", generator);
/* 4882 */     addAdapter("dtv.xst.dao.cwo.IInvoiceProperty", generator);
/* 4883 */     addAdapter("InvoiceProperty", generator);
/* 4884 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4886 */           return (Class)WorkItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4889 */     addAdapter("dtv.xst.dao.cwo.WorkItemPropertyId", generator);
/* 4890 */     addAdapter("dtv.xst.dao.cwo.impl.WorkItemPropertyDAO", generator);
/* 4891 */     addAdapter("dtv.xst.dao.cwo.IWorkItemProperty", generator);
/* 4892 */     addAdapter("WorkItemProperty", generator);
/* 4893 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4895 */           return (Class)CategoryServiceLocationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4898 */     addAdapter("dtv.xst.dao.cwo.CategoryServiceLocationPropertyId", generator);
/* 4899 */     addAdapter("dtv.xst.dao.cwo.impl.CategoryServiceLocationPropertyDAO", generator);
/* 4900 */     addAdapter("dtv.xst.dao.cwo.ICategoryServiceLocationProperty", generator);
/* 4901 */     addAdapter("CategoryServiceLocationProperty", generator);
/* 4902 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4904 */           return (Class)InvoiceLineItemPropertyDBA.class;
/*      */         }
/*      */       };
/* 4907 */     addAdapter("dtv.xst.dao.cwo.InvoiceLineItemPropertyId", generator);
/* 4908 */     addAdapter("dtv.xst.dao.cwo.impl.InvoiceLineItemPropertyDAO", generator);
/* 4909 */     addAdapter("dtv.xst.dao.cwo.IInvoiceLineItemProperty", generator);
/* 4910 */     addAdapter("InvoiceLineItemProperty", generator);
/* 4911 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4913 */           return (Class)ServiceLocationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4916 */     addAdapter("dtv.xst.dao.cwo.ServiceLocationPropertyId", generator);
/* 4917 */     addAdapter("dtv.xst.dao.cwo.impl.ServiceLocationPropertyDAO", generator);
/* 4918 */     addAdapter("dtv.xst.dao.cwo.IServiceLocationProperty", generator);
/* 4919 */     addAdapter("ServiceLocationProperty", generator);
/* 4920 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4922 */           return (Class)WorkOrderCategoryPropertyDBA.class;
/*      */         }
/*      */       };
/* 4925 */     addAdapter("dtv.xst.dao.cwo.WorkOrderCategoryPropertyId", generator);
/* 4926 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderCategoryPropertyDAO", generator);
/* 4927 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderCategoryProperty", generator);
/* 4928 */     addAdapter("WorkOrderCategoryProperty", generator);
/* 4929 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4931 */           return (Class)WorkOrderPriceCodePropertyDBA.class;
/*      */         }
/*      */       };
/* 4934 */     addAdapter("dtv.xst.dao.cwo.WorkOrderPriceCodePropertyId", generator);
/* 4935 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderPriceCodePropertyDAO", generator);
/* 4936 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderPriceCodeProperty", generator);
/* 4937 */     addAdapter("WorkOrderPriceCodeProperty", generator);
/* 4938 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4940 */           return (Class)WorkOrderPricingPropertyDBA.class;
/*      */         }
/*      */       };
/* 4943 */     addAdapter("dtv.xst.dao.cwo.WorkOrderPricingPropertyId", generator);
/* 4944 */     addAdapter("dtv.xst.dao.cwo.impl.WorkOrderPricingPropertyDAO", generator);
/* 4945 */     addAdapter("dtv.xst.dao.cwo.IWorkOrderPricingProperty", generator);
/* 4946 */     addAdapter("WorkOrderPricingProperty", generator);
/* 4947 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4949 */           return (Class)TaxAuthorityPropertyDBA.class;
/*      */         }
/*      */       };
/* 4952 */     addAdapter("dtv.xst.dao.tax.TaxAuthorityPropertyId", generator);
/* 4953 */     addAdapter("dtv.xst.dao.tax.impl.TaxAuthorityPropertyDAO", generator);
/* 4954 */     addAdapter("dtv.xst.dao.tax.ITaxAuthorityProperty", generator);
/* 4955 */     addAdapter("TaxAuthorityProperty", generator);
/* 4956 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4958 */           return (Class)TaxGroupPropertyDBA.class;
/*      */         }
/*      */       };
/* 4961 */     addAdapter("dtv.xst.dao.tax.TaxGroupPropertyId", generator);
/* 4962 */     addAdapter("dtv.xst.dao.tax.impl.TaxGroupPropertyDAO", generator);
/* 4963 */     addAdapter("dtv.xst.dao.tax.ITaxGroupProperty", generator);
/* 4964 */     addAdapter("TaxGroupProperty", generator);
/* 4965 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4967 */           return (Class)TaxGroupRulePropertyDBA.class;
/*      */         }
/*      */       };
/* 4970 */     addAdapter("dtv.xst.dao.tax.TaxGroupRulePropertyId", generator);
/* 4971 */     addAdapter("dtv.xst.dao.tax.impl.TaxGroupRulePropertyDAO", generator);
/* 4972 */     addAdapter("dtv.xst.dao.tax.ITaxGroupRuleProperty", generator);
/* 4973 */     addAdapter("TaxGroupRuleProperty", generator);
/* 4974 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4976 */           return (Class)TaxLocationPropertyDBA.class;
/*      */         }
/*      */       };
/* 4979 */     addAdapter("dtv.xst.dao.tax.TaxLocationPropertyId", generator);
/* 4980 */     addAdapter("dtv.xst.dao.tax.impl.TaxLocationPropertyDAO", generator);
/* 4981 */     addAdapter("dtv.xst.dao.tax.ITaxLocationProperty", generator);
/* 4982 */     addAdapter("TaxLocationProperty", generator);
/* 4983 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4985 */           return (Class)TaxRateRulePropertyDBA.class;
/*      */         }
/*      */       };
/* 4988 */     addAdapter("dtv.xst.dao.tax.TaxRateRulePropertyId", generator);
/* 4989 */     addAdapter("dtv.xst.dao.tax.impl.TaxRateRulePropertyDAO", generator);
/* 4990 */     addAdapter("dtv.xst.dao.tax.ITaxRateRuleProperty", generator);
/* 4991 */     addAdapter("TaxRateRuleProperty", generator);
/* 4992 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 4994 */           return (Class)TaxCodePropertyDBA.class;
/*      */         }
/*      */       };
/* 4997 */     addAdapter("dtv.xst.dao.tax.TaxCodePropertyId", generator);
/* 4998 */     addAdapter("dtv.xst.dao.tax.impl.TaxCodePropertyDAO", generator);
/* 4999 */     addAdapter("dtv.xst.dao.tax.ITaxCodeProperty", generator);
/* 5000 */     addAdapter("TaxCodeProperty", generator);
/* 5001 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5003 */           return (Class)PostalCodeMappingPropertyDBA.class;
/*      */         }
/*      */       };
/* 5006 */     addAdapter("dtv.xst.dao.tax.PostalCodeMappingPropertyId", generator);
/* 5007 */     addAdapter("dtv.xst.dao.tax.impl.PostalCodeMappingPropertyDAO", generator);
/* 5008 */     addAdapter("dtv.xst.dao.tax.IPostalCodeMappingProperty", generator);
/* 5009 */     addAdapter("PostalCodeMappingProperty", generator);
/* 5010 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5012 */           return (Class)RetailLocationTaxMappingPropertyDBA.class;
/*      */         }
/*      */       };
/* 5015 */     addAdapter("dtv.xst.dao.tax.RetailLocationTaxMappingPropertyId", generator);
/* 5016 */     addAdapter("dtv.xst.dao.tax.impl.RetailLocationTaxMappingPropertyDAO", generator);
/* 5017 */     addAdapter("dtv.xst.dao.tax.IRetailLocationTaxMappingProperty", generator);
/* 5018 */     addAdapter("RetailLocationTaxMappingProperty", generator);
/* 5019 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5021 */           return (Class)TaxBracketPropertyDBA.class;
/*      */         }
/*      */       };
/* 5024 */     addAdapter("dtv.xst.dao.tax.TaxBracketPropertyId", generator);
/* 5025 */     addAdapter("dtv.xst.dao.tax.impl.TaxBracketPropertyDAO", generator);
/* 5026 */     addAdapter("dtv.xst.dao.tax.ITaxBracketProperty", generator);
/* 5027 */     addAdapter("TaxBracketProperty", generator);
/* 5028 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5030 */           return (Class)TaxExemptionPropertyDBA.class;
/*      */         }
/*      */       };
/* 5033 */     addAdapter("dtv.xst.dao.tax.TaxExemptionPropertyId", generator);
/* 5034 */     addAdapter("dtv.xst.dao.tax.impl.TaxExemptionPropertyDAO", generator);
/* 5035 */     addAdapter("dtv.xst.dao.tax.ITaxExemptionProperty", generator);
/* 5036 */     addAdapter("TaxExemptionProperty", generator);
/* 5037 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5039 */           return (Class)TaxRateRuleOverridePropertyDBA.class;
/*      */         }
/*      */       };
/* 5042 */     addAdapter("dtv.xst.dao.tax.TaxRateRuleOverridePropertyId", generator);
/* 5043 */     addAdapter("dtv.xst.dao.tax.impl.TaxRateRuleOverridePropertyDAO", generator);
/* 5044 */     addAdapter("dtv.xst.dao.tax.ITaxRateRuleOverrideProperty", generator);
/* 5045 */     addAdapter("TaxRateRuleOverrideProperty", generator);
/* 5046 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5048 */           return (Class)TaxTaxGroupMappingPropertyDBA.class;
/*      */         }
/*      */       };
/* 5051 */     addAdapter("dtv.xst.dao.tax.TaxTaxGroupMappingPropertyId", generator);
/* 5052 */     addAdapter("dtv.xst.dao.tax.impl.TaxTaxGroupMappingPropertyDAO", generator);
/* 5053 */     addAdapter("dtv.xst.dao.tax.ITaxTaxGroupMappingProperty", generator);
/* 5054 */     addAdapter("TaxTaxGroupMappingProperty", generator);
/* 5055 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5057 */           return (Class)DocumentPropertyDBA.class;
/*      */         }
/*      */       };
/* 5060 */     addAdapter("dtv.xst.dao.doc.DocumentPropertyId", generator);
/* 5061 */     addAdapter("dtv.xst.dao.doc.impl.DocumentPropertyDAO", generator);
/* 5062 */     addAdapter("dtv.xst.dao.doc.IDocumentProperty", generator);
/* 5063 */     addAdapter("DocumentProperty", generator);
/* 5064 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5066 */           return (Class)DocumentDefinitionPropertyDBA.class;
/*      */         }
/*      */       };
/* 5069 */     addAdapter("dtv.xst.dao.doc.DocumentDefinitionPropertyId", generator);
/* 5070 */     addAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionPropertyDAO", generator);
/* 5071 */     addAdapter("dtv.xst.dao.doc.IDocumentDefinitionProperty", generator);
/* 5072 */     addAdapter("DocumentDefinitionProperty", generator);
/* 5073 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5075 */           return (Class)DocumentDefinitionPropertiesPropertyDBA.class;
/*      */         }
/*      */       };
/* 5078 */     addAdapter("dtv.xst.dao.doc.DocumentDefinitionPropertiesPropertyId", generator);
/* 5079 */     addAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionPropertiesPropertyDAO", generator);
/* 5080 */     addAdapter("dtv.xst.dao.doc.IDocumentDefinitionPropertiesProperty", generator);
/* 5081 */     addAdapter("DocumentDefinitionPropertiesProperty", generator);
/* 5082 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5084 */           return (Class)OrganizerPropertyDBA.class;
/*      */         }
/*      */       };
/* 5087 */     addAdapter("dtv.xst.dao.rpt.OrganizerPropertyId", generator);
/* 5088 */     addAdapter("dtv.xst.dao.rpt.impl.OrganizerPropertyDAO", generator);
/* 5089 */     addAdapter("dtv.xst.dao.rpt.IOrganizerProperty", generator);
/* 5090 */     addAdapter("OrganizerProperty", generator);
/* 5091 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5093 */           return (Class)EmployeeTimeOffPropertyDBA.class;
/*      */         }
/*      */       };
/* 5096 */     addAdapter("dtv.xst.dao.sch.EmployeeTimeOffPropertyId", generator);
/* 5097 */     addAdapter("dtv.xst.dao.sch.impl.EmployeeTimeOffPropertyDAO", generator);
/* 5098 */     addAdapter("dtv.xst.dao.sch.IEmployeeTimeOffProperty", generator);
/* 5099 */     addAdapter("EmployeeTimeOffProperty", generator);
/* 5100 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5102 */           return (Class)SchedulePropertyDBA.class;
/*      */         }
/*      */       };
/* 5105 */     addAdapter("dtv.xst.dao.sch.SchedulePropertyId", generator);
/* 5106 */     addAdapter("dtv.xst.dao.sch.impl.SchedulePropertyDAO", generator);
/* 5107 */     addAdapter("dtv.xst.dao.sch.IScheduleProperty", generator);
/* 5108 */     addAdapter("ScheduleProperty", generator);
/* 5109 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5111 */           return (Class)ShiftPropertyDBA.class;
/*      */         }
/*      */       };
/* 5114 */     addAdapter("dtv.xst.dao.sch.ShiftPropertyId", generator);
/* 5115 */     addAdapter("dtv.xst.dao.sch.impl.ShiftPropertyDAO", generator);
/* 5116 */     addAdapter("dtv.xst.dao.sch.IShiftProperty", generator);
/* 5117 */     addAdapter("ShiftProperty", generator);
/* 5118 */     generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {
/*      */         protected Class<? extends IJDBCTableAdapter> getType() {
/* 5120 */           return (Class)SalesGoalPropertyDBA.class;
/*      */         }
/*      */       };
/* 5123 */     addAdapter("dtv.xst.dao.sls.SalesGoalPropertyId", generator);
/* 5124 */     addAdapter("dtv.xst.dao.sls.impl.SalesGoalPropertyDAO", generator);
/* 5125 */     addAdapter("dtv.xst.dao.sls.ISalesGoalProperty", generator);
/* 5126 */     addAdapter("SalesGoalProperty", generator);
/*      */ 
/*      */ 
/*      */     
/* 5130 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-BaseReturnedQuantity", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5132 */             return (Class)SaleReturnLineItemBaseReturnedQuantityRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5135 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-CommissionModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5137 */             return (Class)SaleReturnLineItemCommissionModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5140 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-DimensionModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5142 */             return (Class)SaleReturnLineItemDimensionModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5145 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-InventoryDocumentLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5147 */             return (Class)SaleReturnLineItemInventoryDocumentLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5150 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-LineItemAssociationModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5152 */             return (Class)SaleReturnLineItemLineItemAssociationModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5155 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-RetailPriceModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5157 */             return (Class)SaleReturnLineItemRetailPriceModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5160 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-TaxGroup", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5162 */             return (Class)SaleReturnLineItemTaxGroupRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5165 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-TaxModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5167 */             return (Class)SaleReturnLineItemTaxModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5170 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-CustomerAccountModifier", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5172 */             return (Class)SaleReturnLineItemCustomerAccountModifierRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5175 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5177 */             return (Class)SaleReturnLineItemItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5180 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-NoteSeq", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5182 */             return (Class)SaleReturnLineItemNoteSeqRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5185 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-RetailInventoryLocationModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5187 */             return (Class)SaleReturnLineItemRetailInventoryLocationModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5190 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-OrderModifier", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5192 */             return (Class)SaleReturnLineItemOrderModifierRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5195 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO-KitComponentModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5197 */             return (Class)SaleReturnLineItemKitComponentModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5200 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionExchangeLineItemDAO-RetailInventoryLocationModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5202 */             return (Class)RetailTransactionExchangeLineItemRetailInventoryLocationModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5205 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionExchangeLineItemDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5207 */             return (Class)RetailTransactionExchangeLineItemItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5210 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleTaxModifierDAO-SaleTaxGroupRule", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5212 */             return (Class)SaleTaxModifierSaleTaxGroupRuleRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5215 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.SaleTaxModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5217 */             return (Class)SaleTaxModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5220 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.TaxLineItemDAO-SaleTaxGroupRule", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5222 */             return (Class)TaxLineItemSaleTaxGroupRuleRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5225 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoDAO-DestinationZoneObject", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5227 */             return (Class)RetailTransactionFlightInfoDestinationZoneObjectRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5230 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5232 */             return (Class)RetailTransactionFlightInfoPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5235 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.KitComponentModifierDAO-KitComponent", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5237 */             return (Class)KitComponentModifierKitComponentRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5240 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.KitComponentModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5242 */             return (Class)KitComponentModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5245 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.WarrantyLineItemDAO-WarrantyModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5247 */             return (Class)WarrantyLineItemWarrantyModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5250 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.WarrantyModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5252 */             return (Class)WarrantyModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5255 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.CommissionModifierDAO-EmployeeParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5257 */             return (Class)CommissionModifierEmployeePartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5260 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.CommissionModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5262 */             return (Class)CommissionModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5265 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.CorrectionModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5267 */             return (Class)CorrectionModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5270 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.CustomerItemAccountModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5272 */             return (Class)CustomerItemAccountModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5275 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.DimensionModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5277 */             return (Class)DimensionModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5280 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.DiscountLineItemDAO-LineItemDiscount", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5282 */             return (Class)DiscountLineItemLineItemDiscountRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5285 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.EscrowTransactionDAO-CustomerParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5287 */             return (Class)EscrowTransactionCustomerPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5290 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.EscrowTransactionDAO-EscrowAccountActivity", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5292 */             return (Class)EscrowTransactionEscrowAccountActivityRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5295 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.InventoryDocumentModifierDAO-InventoryDocument", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5297 */             return (Class)InventoryDocumentModifierInventoryDocumentRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5300 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.InventoryDocumentModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5302 */             return (Class)InventoryDocumentModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5305 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.LineItemAssociationModifierDAO-ChildLineItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5307 */             return (Class)LineItemAssociationModifierChildLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5310 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.LineItemAssociationModifierDAO-LineItemAssociationTypeCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5312 */             return (Class)LineItemAssociationModifierLineItemAssociationTypeCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5315 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.LineItemAssociationModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5317 */             return (Class)LineItemAssociationModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5320 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.LineItemAssociationTypeCodeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5322 */             return (Class)LineItemAssociationTypeCodePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5325 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailInventoryLocationModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5327 */             return (Class)RetailInventoryLocationModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5330 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailPriceModifierDAO-Discount", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5332 */             return (Class)RetailPriceModifierDiscountRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5335 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailPriceModifierDAO-ReasonLineItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5337 */             return (Class)RetailPriceModifierReasonLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5340 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailPriceModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5342 */             return (Class)RetailPriceModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5345 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionDAO-CustomerParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5347 */             return (Class)RetailTransactionCustomerPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5350 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionDAO-InventoryDocumentModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5352 */             return (Class)RetailTransactionInventoryDocumentModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5355 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionDAO-TaxExemption", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5357 */             return (Class)RetailTransactionTaxExemptionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5360 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionDAO-FlightInformation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5362 */             return (Class)RetailTransactionFlightInformationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5365 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO-CorrectionModifier", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5367 */             return (Class)RetailTransactionLineItemCorrectionModifierRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5370 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO-Signature", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5372 */             return (Class)RetailTransactionLineItemSignatureRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5375 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5377 */             return (Class)RetailTransactionLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5380 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.RetailTransactionLineItemNotesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5382 */             return (Class)RetailTransactionLineItemNotesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5385 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.ReturnedItemCountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5387 */             return (Class)ReturnedItemCountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5390 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.ReturnedItemJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5392 */             return (Class)ReturnedItemJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5395 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.VoucherDiscountLineItemDAO-Voucher", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5397 */             return (Class)VoucherDiscountLineItemVoucherRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5400 */     addRelationshipAdapter("dtv.xst.dao.trl.impl.VoucherSaleLineItemDAO-Voucher", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5402 */             return (Class)VoucherSaleLineItemVoucherRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5405 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.KitComponentDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5407 */             return (Class)KitComponentPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5410 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemOptionsDAO-ItemVendor", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5412 */             return (Class)ItemOptionsItemVendorRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5415 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemOptionsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5417 */             return (Class)ItemOptionsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5420 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemRestrictionCalendarDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5422 */             return (Class)ItemRestrictionCalendarPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5425 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemRestrictionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5427 */             return (Class)ItemRestrictionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5430 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemRestrictionMappingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5432 */             return (Class)ItemRestrictionMappingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5435 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.AttachedItemsDAO-AttachedItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5437 */             return (Class)AttachedItemsAttachedItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5440 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.AttachedItemsDAO-SoldItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5442 */             return (Class)AttachedItemsSoldItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5445 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.AttachedItemsDAO-AssociationType", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5447 */             return (Class)AttachedItemsAssociationTypeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5450 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.AttachedItemsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5452 */             return (Class)AttachedItemsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5455 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDimensionTypeDAO-DimensionValues", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5457 */             return (Class)ItemDimensionTypeDimensionValuesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5460 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDimensionTypeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5462 */             return (Class)ItemDimensionTypePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5465 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDimensionValueDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5467 */             return (Class)ItemDimensionValuePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5470 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemMessageDAO-LineItemTypes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5472 */             return (Class)ItemMessageLineItemTypesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5475 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemMessageDAO-ItemIds", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5477 */             return (Class)ItemMessageItemIdsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5480 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemMessageDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5482 */             return (Class)ItemMessagePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5485 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.MerchandiseHierarchyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5487 */             return (Class)MerchandiseHierarchyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5490 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.QuickItemDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5492 */             return (Class)QuickItemItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5495 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.QuickItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5497 */             return (Class)QuickItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5500 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.WarrantyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5502 */             return (Class)WarrantyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5505 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.WarrantyJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5507 */             return (Class)WarrantyJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5510 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.SubstituteItemsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5512 */             return (Class)SubstituteItemsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5515 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemOptions", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5517 */             return (Class)ItemItemOptionsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5520 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ParentItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5522 */             return (Class)ItemParentItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5525 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemDealProperties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5527 */             return (Class)ItemItemDealPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5530 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemPromptProperties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5532 */             return (Class)ItemItemPromptPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5535 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemLabelProperties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5537 */             return (Class)ItemItemLabelPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5540 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemImages", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5542 */             return (Class)ItemItemImagesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5545 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemDimensionTypes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5547 */             return (Class)ItemItemDimensionTypesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5550 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-ItemDimensionValues", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5552 */             return (Class)ItemItemDimensionValuesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5555 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5557 */             return (Class)ItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5560 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.VendorDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5562 */             return (Class)VendorAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5565 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.VendorDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5567 */             return (Class)VendorPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5570 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemCrossReferenceDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5572 */             return (Class)ItemCrossReferenceItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5575 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemCrossReferenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5577 */             return (Class)ItemCrossReferencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5580 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemDealPropertyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5582 */             return (Class)ItemDealPropertyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5585 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemMessageCrossReferenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5587 */             return (Class)ItemMessageCrossReferencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5590 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemMessageTypesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5592 */             return (Class)ItemMessageTypesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5595 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemPricesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5597 */             return (Class)ItemPricesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5600 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemPromptPropertyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5602 */             return (Class)ItemPromptPropertyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5605 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemRestrictGS1DAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5607 */             return (Class)ItemRestrictGS1PropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5610 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.RefundScheduleDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5612 */             return (Class)RefundSchedulePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5615 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.WarrantyItemDAO-WarrantyItemPrices", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5617 */             return (Class)WarrantyItemWarrantyItemPricesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5620 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.WarrantyItemCrossReferenceDAO-WarrantyItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5622 */             return (Class)WarrantyItemCrossReferenceWarrantyItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5625 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.WarrantyItemCrossReferenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5627 */             return (Class)WarrantyItemCrossReferencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5630 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.WarrantyItemPriceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5632 */             return (Class)WarrantyItemPricePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5635 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemLabelBatchDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5637 */             return (Class)ItemLabelBatchItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5640 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemLabelBatchDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5642 */             return (Class)ItemLabelBatchPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5645 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemImageDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5647 */             return (Class)ItemImagePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5650 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.ItemLabelPropertiesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5652 */             return (Class)ItemLabelPropertiesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5655 */     addRelationshipAdapter("dtv.xst.dao.itm.impl.MatrixSortOrderDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5657 */             return (Class)MatrixSortOrderPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5660 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionDAO-OperatorParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5662 */             return (Class)PosTransactionOperatorPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5665 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionDAO-RetailTransactionLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5667 */             return (Class)PosTransactionRetailTransactionLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5670 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionDAO-TransactionLinks", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5672 */             return (Class)PosTransactionTransactionLinksRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5675 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionDAO-TransactionNotes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5677 */             return (Class)PosTransactionTransactionNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5680 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5682 */             return (Class)PosTransactionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5685 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.LineItemGenericStorageDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5687 */             return (Class)LineItemGenericStoragePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5690 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosLogDataDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5692 */             return (Class)PosLogDataPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5695 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionLinkDAO-LinkedTransaction", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5697 */             return (Class)PosTransactionLinkLinkedTransactionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5700 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PosTransactionLinkDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5702 */             return (Class)PosTransactionLinkPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5705 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.PostVoidTransactionDAO-VoidedTransaction", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5707 */             return (Class)PostVoidTransactionVoidedTransactionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5710 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.RainCheckDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5712 */             return (Class)RainCheckItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5715 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.RainCheckDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5717 */             return (Class)RainCheckPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5720 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.RainCheckTransactionDAO-RainCheck", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5722 */             return (Class)RainCheckTransactionRainCheckRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5725 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.ReceiptDataDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5727 */             return (Class)ReceiptDataPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5730 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.ReceiptLookupDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5732 */             return (Class)ReceiptLookupPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5735 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.TransactionNotesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5737 */             return (Class)TransactionNotesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5740 */     addRelationshipAdapter("dtv.xst.dao.trn.impl.TransactionVersionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5742 */             return (Class)TransactionVersionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5745 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.IdentityVerificationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5747 */             return (Class)IdentityVerificationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5750 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.TenderAuthLogDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5752 */             return (Class)TenderAuthLogPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5755 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.TenderLineItemDAO-IdentityVerifications", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5757 */             return (Class)TenderLineItemIdentityVerificationsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5760 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.TenderSignatureDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5762 */             return (Class)TenderSignaturePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5765 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.VoucherDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5767 */             return (Class)VoucherPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5770 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.VoucherHistoryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5772 */             return (Class)VoucherHistoryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5775 */     addRelationshipAdapter("dtv.xst.dao.ttr.impl.VoucherTenderLineItemDAO-Voucher", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5777 */             return (Class)VoucherTenderLineItemVoucherRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5780 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionDAO-Party", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5782 */             return (Class)SessionPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5785 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionDAO-TenderRepository", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5787 */             return (Class)SessionTenderRepositoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5790 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionDAO-SessionTenders", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5792 */             return (Class)SessionSessionTendersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5795 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionDAO-SessionWorkstations", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5797 */             return (Class)SessionSessionWorkstationsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5800 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5802 */             return (Class)SessionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5805 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-FundsReceiptParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5807 */             return (Class)TenderControlTransactionFundsReceiptPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5810 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-InboundSession", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5812 */             return (Class)TenderControlTransactionInboundSessionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5815 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-InboundTenderRepository", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5817 */             return (Class)TenderControlTransactionInboundTenderRepositoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5820 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-OutboundSession", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5822 */             return (Class)TenderControlTransactionOutboundSessionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5825 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-OutboundTenderRepository", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5827 */             return (Class)TenderControlTransactionOutboundTenderRepositoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5830 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-ReasonCodeObject", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5832 */             return (Class)TenderControlTransactionReasonCodeObjectRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5835 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO-TenderTypeCounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5837 */             return (Class)TenderControlTransactionTenderTypeCountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5840 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderCountDAO-TenderDenominationCounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5842 */             return (Class)TenderCountTenderDenominationCountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5845 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderCountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5847 */             return (Class)TenderCountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5850 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.ExchangeRateTransLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5852 */             return (Class)ExchangeRateTransLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5855 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.ExchangeRateTransactionDAO-ExchangeRateTransLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5857 */             return (Class)ExchangeRateTransactionExchangeRateTransLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5860 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionControlTransactionDAO-Session", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5862 */             return (Class)SessionControlTransactionSessionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5865 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionControlTransactionDAO-SessionWorkstation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5867 */             return (Class)SessionControlTransactionSessionWorkstationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5870 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionTenderDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5872 */             return (Class)SessionTenderPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5875 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.SessionWorkstationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5877 */             return (Class)SessionWorkstationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5880 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderDenominationCountDAO-TenderDenomination", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5882 */             return (Class)TenderDenominationCountTenderDenominationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5885 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderDenominationCountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5887 */             return (Class)TenderDenominationCountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5890 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryDAO-TenderRepositoryFloat", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5892 */             return (Class)TenderRepositoryTenderRepositoryFloatRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5895 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryDAO-TenderRepositoryStatus", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5897 */             return (Class)TenderRepositoryTenderRepositoryStatusRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5900 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5902 */             return (Class)TenderRepositoryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5905 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryFloatDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5907 */             return (Class)TenderRepositoryFloatPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5910 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderRepositoryStatusDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5912 */             return (Class)TenderRepositoryStatusPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5915 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderSerializedCountDAO-Tender", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5917 */             return (Class)TenderSerializedCountTenderRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5920 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderSerializedCountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5922 */             return (Class)TenderSerializedCountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5925 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderTypeCountDAO-TenderCounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5927 */             return (Class)TenderTypeCountTenderCountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5930 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderTypeCountDAO-TenderSerializedCounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5932 */             return (Class)TenderTypeCountTenderSerializedCountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5935 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TenderTypeCountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5937 */             return (Class)TenderTypeCountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5940 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDAO-TillControlTransactionDetails", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5942 */             return (Class)TillControlTransactionTillControlTransactionDetailsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5945 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDAO-ReasonCodeObject", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5947 */             return (Class)TillControlTransactionReasonCodeObjectRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5950 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDetailDAO-AffectedTenderRepository", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5952 */             return (Class)TillControlTransactionDetailAffectedTenderRepositoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5955 */     addRelationshipAdapter("dtv.xst.dao.tsn.impl.TillControlTransactionDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5957 */             return (Class)TillControlTransactionDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5960 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.CustomerConsentInfoDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5962 */             return (Class)CustomerConsentInfoPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5965 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-AlternatePartyIds", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5967 */             return (Class)PartyAlternatePartyIdsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5970 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-CustomerGroups", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5972 */             return (Class)PartyCustomerGroupsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5975 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-LocaleInformation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5977 */             return (Class)PartyLocaleInformationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5980 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-TelephoneInformation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5982 */             return (Class)PartyTelephoneInformationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5985 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-EmailInformation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5987 */             return (Class)PartyEmailInformationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5990 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-LoyaltyCards", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5992 */             return (Class)PartyLoyaltyCardsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 5995 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-CustomerNotes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 5997 */             return (Class)PartyCustomerNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6000 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6002 */             return (Class)PartyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6005 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyLocaleInformationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6007 */             return (Class)PartyLocaleInformationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6010 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.CustomerAffiliationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6012 */             return (Class)CustomerAffiliationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6015 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.CustomerNoteDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6017 */             return (Class)CustomerNotePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6020 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.GiftRegistryJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6022 */             return (Class)GiftRegistryJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6025 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyCrossReferenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6027 */             return (Class)PartyCrossReferencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6030 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyEmailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6032 */             return (Class)PartyEmailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6035 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyIdCrossReferenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6037 */             return (Class)PartyIdCrossReferencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6040 */     addRelationshipAdapter("dtv.xst.dao.crm.impl.PartyTelephoneDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6042 */             return (Class)PartyTelephonePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6045 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountDAO-Journals", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6047 */             return (Class)CustomerAccountJournalsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6050 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountDAO-PaymentSchedule", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6052 */             return (Class)CustomerAccountPaymentScheduleRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6055 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountDAO-RetailLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6057 */             return (Class)CustomerAccountRetailLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6060 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountDAO-CustAccountNotes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6062 */             return (Class)CustomerAccountCustAccountNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6065 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6067 */             return (Class)CustomerAccountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6070 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.AwardAccountDAO-AwardCoupons", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6072 */             return (Class)AwardAccountAwardCouponsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6075 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.AwardAccountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6077 */             return (Class)AwardAccountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6080 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.AwardAccountCouponDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6082 */             return (Class)AwardAccountCouponPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6085 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.ChargeAccountInvoiceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6087 */             return (Class)ChargeAccountInvoicePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6090 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.ChargeAccountUserDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6092 */             return (Class)ChargeAccountUserPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6095 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6097 */             return (Class)CustomerAccountJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6100 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountActivityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6102 */             return (Class)CustomerItemAccountActivityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6105 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO-RetailLineItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6107 */             return (Class)CustomerItemAccountDetailRetailLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6110 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO-CustItemAccountActivities", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6112 */             return (Class)CustomerItemAccountDetailCustItemAccountActivitiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6115 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO-SourceLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6117 */             return (Class)CustomerItemAccountDetailSourceLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6120 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO-FullfillmentLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6122 */             return (Class)CustomerItemAccountDetailFullfillmentLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6125 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6127 */             return (Class)CustomerItemAccountDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6130 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyAccountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6132 */             return (Class)CustomerLoyaltyAccountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6135 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyCardDAO-LoyaltyAccounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6137 */             return (Class)CustomerLoyaltyCardLoyaltyAccountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6140 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyCardDAO-AwardAccounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6142 */             return (Class)CustomerLoyaltyCardAwardAccountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6145 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerLoyaltyCardDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6147 */             return (Class)CustomerLoyaltyCardPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6150 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.DeliveryModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6152 */             return (Class)DeliveryModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6155 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.EscrowAccountDAO-EscrowAccountActivities", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6157 */             return (Class)EscrowAccountEscrowAccountActivitiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6160 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.EscrowAccountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6162 */             return (Class)EscrowAccountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6165 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.ChargeAccountHistoryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6167 */             return (Class)ChargeAccountHistoryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6170 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountNoteDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6172 */             return (Class)CustomerAccountNotePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6175 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountPlanDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6177 */             return (Class)CustomerAccountPlanPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6180 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerConsumerChargeAccountDAO-ChargeAccountUsers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6182 */             return (Class)CustomerConsumerChargeAccountChargeAccountUsersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6185 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerConsumerChargeAccountDAO-ChargeAccountHistories", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6187 */             return (Class)CustomerConsumerChargeAccountChargeAccountHistoriesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6190 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDAO-DeliveryModifier", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6192 */             return (Class)CustomerItemAccountDeliveryModifierRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6195 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerItemAccountDAO-CustItemAccountDetails", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6197 */             return (Class)CustomerItemAccountCustItemAccountDetailsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6200 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.EscrowAccountActivityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6202 */             return (Class)EscrowAccountActivityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6205 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.PaymentScheduleDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6207 */             return (Class)PaymentSchedulePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6210 */     addRelationshipAdapter("dtv.xst.dao.cat.impl.CustomerAccountAuthorizationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6212 */             return (Class)CustomerAccountAuthorizationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6215 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-SourceModifier", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6217 */             return (Class)OrderLineSourceModifierRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6220 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-FulfillmentModifier", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6222 */             return (Class)OrderLineFulfillmentModifierRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6225 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-BalanceModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6227 */             return (Class)OrderLineBalanceModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6230 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-CustomizationModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6232 */             return (Class)OrderLineCustomizationModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6235 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-Fees", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6237 */             return (Class)OrderLineFeesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6240 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6242 */             return (Class)OrderLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6245 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderLineDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6247 */             return (Class)OrderLinePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6250 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderDAO-Customer", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6252 */             return (Class)OrderCustomerRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6255 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderDAO-Payments", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6257 */             return (Class)OrderPaymentsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6260 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderDAO-Fees", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6262 */             return (Class)OrderFeesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6265 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderDAO-OrderLines", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6267 */             return (Class)OrderOrderLinesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6270 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6272 */             return (Class)OrderPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6275 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.ItemModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6277 */             return (Class)ItemModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6280 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.AddressModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6282 */             return (Class)AddressModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6285 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.BalanceModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6287 */             return (Class)BalanceModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6290 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.CustomerModifierDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6292 */             return (Class)CustomerModifierAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6295 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.CustomerModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6297 */             return (Class)CustomerModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6300 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.CustomizationModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6302 */             return (Class)CustomizationModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6305 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.FeeModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6307 */             return (Class)FeeModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6310 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.FulfillmentModifierDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6312 */             return (Class)FulfillmentModifierAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6315 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.FulfillmentModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6317 */             return (Class)FulfillmentModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6320 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderFeeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6322 */             return (Class)OrderFeePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6325 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6327 */             return (Class)OrderModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6330 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.OrderPaymentDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6332 */             return (Class)OrderPaymentPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6335 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.SourceModifierDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6337 */             return (Class)SourceModifierAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6340 */     addRelationshipAdapter("dtv.xst.dao.xom.impl.SourceModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6342 */             return (Class)SourceModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6345 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDAO-Items", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6347 */             return (Class)DealItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6350 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDAO-CustomerGroups", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6352 */             return (Class)DealCustomerGroupsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6355 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDAO-Triggers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6357 */             return (Class)DealTriggersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6360 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6362 */             return (Class)DealPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6365 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealCustomerGroupsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6367 */             return (Class)DealCustomerGroupsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6370 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDocumentXrefDAO-Deals", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6372 */             return (Class)DealDocumentXrefDealsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6375 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDocumentXrefDAO-DocDefinitions", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6377 */             return (Class)DealDocumentXrefDocDefinitionsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6380 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealDocumentXrefDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6382 */             return (Class)DealDocumentXrefPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6385 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealFieldTestDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6387 */             return (Class)DealFieldTestPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6390 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealItemActionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6392 */             return (Class)DealItemActionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6395 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealTriggerDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6397 */             return (Class)DealTriggerPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6400 */     addRelationshipAdapter("dtv.xst.dao.prc.impl.DealWeekDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6402 */             return (Class)DealWeekPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6405 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.PayrollDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6407 */             return (Class)PayrollPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6410 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.PayrollCategoryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6412 */             return (Class)PayrollCategoryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6415 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.PayrollHeaderDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6417 */             return (Class)PayrollHeaderPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6420 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.PayrollNotesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6422 */             return (Class)PayrollNotesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6425 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.TimecardEntryDAO-WorkCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6427 */             return (Class)TimecardEntryWorkCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6430 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.TimecardEntryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6432 */             return (Class)TimecardEntryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6435 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.TimecardEntryCommentDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6437 */             return (Class)TimecardEntryCommentPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6440 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.TimecardJournalDAO-WorkCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6442 */             return (Class)TimecardJournalWorkCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6445 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.TimecardJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6447 */             return (Class)TimecardJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6450 */     addRelationshipAdapter("dtv.xst.dao.thr.impl.TimeclockTransactionDAO-WorkCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6452 */             return (Class)TimeclockTransactionWorkCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6455 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderOptionsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6457 */             return (Class)TenderOptionsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6460 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderDAO-TenderOptions", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6462 */             return (Class)TenderTenderOptionsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6465 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderDAO-TenderAvailabilityCodes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6467 */             return (Class)TenderTenderAvailabilityCodesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6470 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderDAO-TenderDenominations", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6472 */             return (Class)TenderTenderDenominationsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6475 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderDAO-TenderType", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6477 */             return (Class)TenderTenderTypeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6480 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6482 */             return (Class)TenderPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6485 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderAvailabilityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6487 */             return (Class)TenderAvailabilityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6490 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderDenominationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6492 */             return (Class)TenderDenominationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6495 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderExchangeRateDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6497 */             return (Class)TenderExchangeRatePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6500 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderTypeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6502 */             return (Class)TenderTypePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6505 */     addRelationshipAdapter("dtv.xst.dao.tnd.impl.TenderUserSettingsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6507 */             return (Class)TenderUserSettingsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6510 */     addRelationshipAdapter("dtv.xst.dao.ctl.impl.IpCashDrawerDeviceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6512 */             return (Class)IpCashDrawerDevicePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6515 */     addRelationshipAdapter("dtv.xst.dao.ctl.impl.CheetahClientDeviceAccessDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6517 */             return (Class)CheetahClientDeviceAccessPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6520 */     addRelationshipAdapter("dtv.xst.dao.ctl.impl.DataLoaderFailureDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6522 */             return (Class)DataLoaderFailurePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6525 */     addRelationshipAdapter("dtv.xst.dao.ctl.impl.DataLoaderSummaryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6527 */             return (Class)DataLoaderSummaryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6530 */     addRelationshipAdapter("dtv.xst.dao.ctl.impl.DeviceRegistrationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6532 */             return (Class)DeviceRegistrationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6535 */     addRelationshipAdapter("dtv.xst.dao.ctl.impl.VersionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6537 */             return (Class)VersionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6540 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.RetailLocationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6542 */             return (Class)RetailLocationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6545 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.OrgHierarchyDAO-ParentElement", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6547 */             return (Class)OrgHierarchyParentElementRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6550 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.OrgHierarchyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6552 */             return (Class)OrgHierarchyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6555 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.PricingHierarchyDAO-ParentElement", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6557 */             return (Class)PricingHierarchyParentElementRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6560 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.PricingHierarchyDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6562 */             return (Class)PricingHierarchyPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6565 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.WorkstationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6567 */             return (Class)WorkstationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6570 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.CloseDatesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6572 */             return (Class)CloseDatesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6575 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.ClosingMessageDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6577 */             return (Class)ClosingMessagePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6580 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.CycleQuestionDAO-QuestionChoices", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6582 */             return (Class)CycleQuestionQuestionChoicesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6585 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.CycleQuestionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6587 */             return (Class)CycleQuestionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6590 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.CycleQuestionAnswerDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6592 */             return (Class)CycleQuestionAnswerPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6595 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.CycleQuestionChoiceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6597 */             return (Class)CycleQuestionChoicePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6600 */     addRelationshipAdapter("dtv.xst.dao.loc.impl.StateJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6602 */             return (Class)StateJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6605 */     addRelationshipAdapter("dtv.xst.dao.com.impl.FlightInformationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6607 */             return (Class)FlightInformationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6610 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AirportDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6612 */             return (Class)AirportPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6615 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ButtonGridDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6617 */             return (Class)ButtonGridPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6620 */     addRelationshipAdapter("dtv.xst.dao.com.impl.CodeValueDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6622 */             return (Class)CodeValuePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6625 */     addRelationshipAdapter("dtv.xst.dao.com.impl.DatabaseTranslationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6627 */             return (Class)DatabaseTranslationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6630 */     addRelationshipAdapter("dtv.xst.dao.com.impl.SequenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6632 */             return (Class)SequencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6635 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AddressDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6637 */             return (Class)AddressPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6640 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AddressCountryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6642 */             return (Class)AddressCountryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6645 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AddressPostalCodeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6647 */             return (Class)AddressPostalCodePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6650 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AddressStateDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6652 */             return (Class)AddressStatePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6655 */     addRelationshipAdapter("dtv.xst.dao.com.impl.CountryReturnMapDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6657 */             return (Class)CountryReturnMapPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6660 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ReasonCodeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6662 */             return (Class)ReasonCodePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6665 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ReceiptTextDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6667 */             return (Class)ReceiptTextPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6670 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ReportDataDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6672 */             return (Class)ReportDataPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6675 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ReportLookupDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6677 */             return (Class)ReportLookupPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6680 */     addRelationshipAdapter("dtv.xst.dao.com.impl.SequencePartDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6682 */             return (Class)SequencePartPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6685 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ShippingCostDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6687 */             return (Class)ShippingCostPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6690 */     addRelationshipAdapter("dtv.xst.dao.com.impl.TransactionPropertyPromptDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6692 */             return (Class)TransactionPropertyPromptPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6695 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AirportZoneDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6697 */             return (Class)AirportZonePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6700 */     addRelationshipAdapter("dtv.xst.dao.com.impl.AirportZoneDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6702 */             return (Class)AirportZoneDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6705 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ShippingFeeDAO-TieredFees", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6707 */             return (Class)ShippingFeeTieredFeesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6710 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ShippingFeeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6712 */             return (Class)ShippingFeePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6715 */     addRelationshipAdapter("dtv.xst.dao.com.impl.ShippingFeeTierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6717 */             return (Class)ShippingFeeTierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6720 */     addRelationshipAdapter("dtv.xst.dao._test.impl.XunitResultDAO-ResultItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6722 */             return (Class)XunitResultResultItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6725 */     addRelationshipAdapter("dtv.xst.dao._test.impl.XunitResultDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6727 */             return (Class)XunitResultPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6730 */     addRelationshipAdapter("dtv.xst.dao._test.impl.XunitResultItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6732 */             return (Class)XunitResultItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6735 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.WorkCodesDAO-PayrollCategory", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6737 */             return (Class)WorkCodesPayrollCategoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6740 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.WorkCodesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6742 */             return (Class)WorkCodesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6745 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-Party", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6747 */             return (Class)EmployeePartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6750 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-PrimaryGroup", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6752 */             return (Class)EmployeePrimaryGroupRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6755 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-WorkCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6757 */             return (Class)EmployeeWorkCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6760 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-EmployeeStores", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6762 */             return (Class)EmployeeEmployeeStoresRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6765 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-EmployeeNotes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6767 */             return (Class)EmployeeEmployeeNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6770 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-EmployeeAnswers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6772 */             return (Class)EmployeeEmployeeAnswersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6775 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6777 */             return (Class)EmployeePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6780 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeFingerprintDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6782 */             return (Class)EmployeeFingerprintPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6785 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeMessageDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6787 */             return (Class)EmployeeMessagePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6790 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeAnswersDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6792 */             return (Class)EmployeeAnswersPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6795 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeNoteDAO-CreatorParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6797 */             return (Class)EmployeeNoteCreatorPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6800 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeNoteDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6802 */             return (Class)EmployeeNotePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6805 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeePasswordDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6807 */             return (Class)EmployeePasswordPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6810 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeStoreDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6812 */             return (Class)EmployeeStorePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6815 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskDAO-CustomerParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6817 */             return (Class)EmployeeTaskCustomerPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6820 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskDAO-EmployeeTaskNotes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6822 */             return (Class)EmployeeTaskEmployeeTaskNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6825 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6827 */             return (Class)EmployeeTaskPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6830 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskNoteDAO-CreatorParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6832 */             return (Class)EmployeeTaskNoteCreatorPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6835 */     addRelationshipAdapter("dtv.xst.dao.hrs.impl.EmployeeTaskNoteDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6837 */             return (Class)EmployeeTaskNotePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6840 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.UserPasswordDAO-RoleObjects", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6842 */             return (Class)UserPasswordRoleObjectsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6845 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.UserPasswordDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6847 */             return (Class)UserPasswordPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6850 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.UserRoleDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6852 */             return (Class)UserRolePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6855 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.AccessControlListDAO-AclEntries", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6857 */             return (Class)AccessControlListAclEntriesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6860 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.AccessControlListDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6862 */             return (Class)AccessControlListPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6865 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.AclAccessTypeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6867 */             return (Class)AclAccessTypePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6870 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.GroupDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6872 */             return (Class)GroupPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6875 */     addRelationshipAdapter("dtv.xst.dao.sec.impl.PrivilegeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6877 */             return (Class)PrivilegePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6880 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.CartonDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6882 */             return (Class)CartonPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6885 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO-InventoryDocumentLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6887 */             return (Class)InventoryDocumentInventoryDocumentLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6890 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO-Shipments", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6892 */             return (Class)InventoryDocumentShipmentsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6895 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO-Cartons", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6897 */             return (Class)InventoryDocumentCartonsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6900 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO-Notes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6902 */             return (Class)InventoryDocumentNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6905 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO-OriginatorAddress", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6907 */             return (Class)InventoryDocumentOriginatorAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6910 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6912 */             return (Class)InventoryDocumentPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6915 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-CustomerItemAccountMod", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6917 */             return (Class)InventoryDocumentLineItemCustomerItemAccountModRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6920 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-SerialNumbers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6922 */             return (Class)InventoryDocumentLineItemSerialNumbersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6925 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-DocumentInventoryLocationModifiers", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6927 */             return (Class)InventoryDocumentLineItemDocumentInventoryLocationModifiersRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6930 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-InventoryReplenishmentDocumentLineItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6932 */             return (Class)InventoryDocumentLineItemInventoryReplenishmentDocumentLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6935 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-Notes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6937 */             return (Class)InventoryDocumentLineItemNotesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6940 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-InventoryLineCrossReference", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6942 */             return (Class)InventoryDocumentLineItemInventoryLineCrossReferenceRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6945 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6947 */             return (Class)InventoryDocumentLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6950 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDetailDAO-InventoryDocumentLineItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6952 */             return (Class)InventoryTransactionDetailInventoryDocumentLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6955 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6957 */             return (Class)InventoryTransactionDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6960 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountDAO-InventoryCountBuckets", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6962 */             return (Class)InventoryCountInventoryCountBucketsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6965 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6967 */             return (Class)InventoryCountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6970 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionDAO-SectionDetails", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6972 */             return (Class)InventoryCountSectionSectionDetailsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6975 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6977 */             return (Class)InventoryCountSectionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6980 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetDAO-CountSheetLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6982 */             return (Class)InventoryCountSheetCountSheetLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6985 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6987 */             return (Class)InventoryCountSheetPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6990 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationDAO-InventoryLocationBuckets", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6992 */             return (Class)InventoryLocationInventoryLocationBucketsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 6995 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationDAO-AvailabilityCodes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 6997 */             return (Class)InventoryLocationAvailabilityCodesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7000 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7002 */             return (Class)InventoryLocationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7005 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO-MovementPendingDetails", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7007 */             return (Class)InventoryMovementPendingMovementPendingDetailsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7010 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO-Item", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7012 */             return (Class)InventoryMovementPendingItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7015 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO-SaleLineItem", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7017 */             return (Class)InventoryMovementPendingSaleLineItemRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7020 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO-InventoryTransactionDetail", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7022 */             return (Class)InventoryMovementPendingInventoryTransactionDetailRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7025 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7027 */             return (Class)InventoryMovementPendingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7030 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemDAO-InventoryMovementPending", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7032 */             return (Class)MovementPendingTransactionLineItemInventoryMovementPendingRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7035 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7037 */             return (Class)MovementPendingTransactionLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7040 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentDAO-DestinationParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7042 */             return (Class)ShipmentDestinationPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7045 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentDAO-DestinationRetailLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7047 */             return (Class)ShipmentDestinationRetailLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7050 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7052 */             return (Class)ShipmentAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7055 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentDAO-ShipmentLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7057 */             return (Class)ShipmentShipmentLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7060 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7062 */             return (Class)ShipmentPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7065 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7067 */             return (Class)ShipmentLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7070 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipmentAddressDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7072 */             return (Class)ShipmentAddressPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7075 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryItemAccountModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7077 */             return (Class)InventoryItemAccountModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7080 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.DocumentInventoryLocationModifierDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7082 */             return (Class)DocumentInventoryLocationModifierPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7085 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.DocumentNoteDAO-CreatorParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7087 */             return (Class)DocumentNoteCreatorPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7090 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.DocumentNoteDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7092 */             return (Class)DocumentNotePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7095 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.FiscalYearDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7097 */             return (Class)FiscalYearPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7100 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryBucketDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7102 */             return (Class)InventoryBucketPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7105 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentCrossReferenceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7107 */             return (Class)InventoryDocumentCrossReferencePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7110 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDAO-InventoryDocument", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7112 */             return (Class)InventoryTransactionInventoryDocumentRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7115 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryTransactionDAO-InventoryTransactionDetails", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7117 */             return (Class)InventoryTransactionInventoryTransactionDetailsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7120 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCostItemYearEndDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7122 */             return (Class)InventoryCostItemYearEndPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7125 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountBucketDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7127 */             return (Class)InventoryCountBucketPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7130 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSectionDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7132 */             return (Class)InventoryCountSectionDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7135 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSheetLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7137 */             return (Class)InventoryCountSheetLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7140 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryCountSnapshotDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7142 */             return (Class)InventoryCountSnapshotPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7145 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryJournalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7147 */             return (Class)InventoryJournalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7150 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityDAO-Privilege", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7152 */             return (Class)InventoryLocationAvailabilityPrivilegeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7155 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7157 */             return (Class)InventoryLocationAvailabilityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7160 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationBucketDAO-InventoryBucket", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7162 */             return (Class)InventoryLocationBucketInventoryBucketRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7165 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryLocationBucketDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7167 */             return (Class)InventoryLocationBucketPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7170 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryMovementPendingDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7172 */             return (Class)InventoryMovementPendingDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7175 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDAO-InventorySummaryCountTransactionDetails", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7177 */             return (Class)InventorySummaryCountTransactionInventorySummaryCountTransactionDetailsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7180 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7182 */             return (Class)InventorySummaryCountTransactionDetailPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7185 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryValidDestinationsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7187 */             return (Class)InventoryValidDestinationsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7190 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.MovementPendingTransactionDAO-MovementPendingTransactionLineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7192 */             return (Class)MovementPendingTransactionMovementPendingTransactionLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7195 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.SerializedStockLedgerDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7197 */             return (Class)SerializedStockLedgerPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7200 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipperDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7202 */             return (Class)ShipperPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7205 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.ShipperMethodDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7207 */             return (Class)ShipperMethodPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7210 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.StockLedgerDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7212 */             return (Class)StockLedgerPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7215 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.DocumentLineItemNoteDAO-CreatorParty", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7217 */             return (Class)DocumentLineItemNoteCreatorPartyRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7220 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.DocumentLineItemNoteDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7222 */             return (Class)DocumentLineItemNotePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7225 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryDocumentLineSerialDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7227 */             return (Class)InventoryDocumentLineSerialPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7230 */     addRelationshipAdapter("dtv.xst.dao.inv.impl.InventoryReplenishmentDocumentLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7232 */             return (Class)InventoryReplenishmentDocumentLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7235 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountDAO-CompatibleDiscounts", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7237 */             return (Class)DiscountCompatibleDiscountsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7240 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountDAO-ValidSaleLineItemTypeCodes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7242 */             return (Class)DiscountValidSaleLineItemTypeCodesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7245 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountDAO-CustomerGroups", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7247 */             return (Class)DiscountCustomerGroupsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7250 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountDAO-Privilege", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7252 */             return (Class)DiscountPrivilegeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7255 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7257 */             return (Class)DiscountPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7260 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.CouponDAO-CouponDiscount", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7262 */             return (Class)CouponCouponDiscountRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7265 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.CouponDAO-Tender", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7267 */             return (Class)CouponTenderRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7270 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.CouponDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7272 */             return (Class)CouponPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7275 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountCompatabilityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7277 */             return (Class)DiscountCompatabilityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7280 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountGroupMappingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7282 */             return (Class)DiscountGroupMappingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7285 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountItemExclusionsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7287 */             return (Class)DiscountItemExclusionsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7290 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountItemInclusionsDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7292 */             return (Class)DiscountItemInclusionsPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7295 */     addRelationshipAdapter("dtv.xst.dao.dsc.impl.DiscountTypeEligibilityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7297 */             return (Class)DiscountTypeEligibilityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7300 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.InvoiceDAO-InvoiceServiceLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7302 */             return (Class)InvoiceInvoiceServiceLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7305 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.InvoiceDAO-LineItems", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7307 */             return (Class)InvoiceLineItemsRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7310 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.InvoiceDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7312 */             return (Class)InvoicePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7315 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7317 */             return (Class)WorkItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7320 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.CategoryServiceLocationDAO-CategoryServiceLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7322 */             return (Class)CategoryServiceLocationCategoryServiceLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7325 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.CategoryServiceLocationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7327 */             return (Class)CategoryServiceLocationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7330 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.InvoiceLineItemDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7332 */             return (Class)InvoiceLineItemPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7335 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.ServiceLocationDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7337 */             return (Class)ServiceLocationAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7340 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.ServiceLocationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7342 */             return (Class)ServiceLocationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7345 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO-WorkItemsRelationship", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7347 */             return (Class)WorkOrderAccountWorkItemsRelationshipRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7350 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO-WorkOrderAccountServiceLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7352 */             return (Class)WorkOrderAccountWorkOrderAccountServiceLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7355 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO-WorkOrderAccountCategory", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7357 */             return (Class)WorkOrderAccountWorkOrderAccountCategoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7360 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO-WorkOrderAccountPriceCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7362 */             return (Class)WorkOrderAccountWorkOrderAccountPriceCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7365 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountJournalDAO-WorkOrderAccountJournalPriceCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7367 */             return (Class)WorkOrderAccountJournalWorkOrderAccountJournalPriceCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7370 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountJournalDAO-WorkOrderAccountJournalCategory", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7372 */             return (Class)WorkOrderAccountJournalWorkOrderAccountJournalCategoryRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7375 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderAccountJournalDAO-WorkOrderAccountJournalServiceLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7377 */             return (Class)WorkOrderAccountJournalWorkOrderAccountJournalServiceLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7380 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderCategoryDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7382 */             return (Class)WorkOrderCategoryPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7385 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderPriceCodeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7387 */             return (Class)WorkOrderPriceCodePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7390 */     addRelationshipAdapter("dtv.xst.dao.cwo.impl.WorkOrderPricingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7392 */             return (Class)WorkOrderPricingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7395 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxAuthorityDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7397 */             return (Class)TaxAuthorityPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7400 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxGroupDAO-TaxCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7402 */             return (Class)TaxGroupTaxCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7405 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxGroupDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7407 */             return (Class)TaxGroupPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7410 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxGroupRuleDAO-TaxAuthority", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7412 */             return (Class)TaxGroupRuleTaxAuthorityRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7415 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxGroupRuleDAO-TaxRateRules", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7417 */             return (Class)TaxGroupRuleTaxRateRulesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7420 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxGroupRuleDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7422 */             return (Class)TaxGroupRulePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7425 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxLocationDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7427 */             return (Class)TaxLocationPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7430 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxRateRuleDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7432 */             return (Class)TaxRateRulePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7435 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxCodeDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7437 */             return (Class)TaxCodePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7440 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.PostalCodeMappingDAO-PostalTaxLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7442 */             return (Class)PostalCodeMappingPostalTaxLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7445 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.PostalCodeMappingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7447 */             return (Class)PostalCodeMappingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7450 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.RetailLocationTaxMappingDAO-TaxLocation", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7452 */             return (Class)RetailLocationTaxMappingTaxLocationRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7455 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.RetailLocationTaxMappingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7457 */             return (Class)RetailLocationTaxMappingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7460 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxBracketDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7462 */             return (Class)TaxBracketPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7465 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxExemptionDAO-Address", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7467 */             return (Class)TaxExemptionAddressRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7470 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxExemptionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7472 */             return (Class)TaxExemptionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7475 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxRateRuleOverrideDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7477 */             return (Class)TaxRateRuleOverridePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7480 */     addRelationshipAdapter("dtv.xst.dao.tax.impl.TaxTaxGroupMappingDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7482 */             return (Class)TaxTaxGroupMappingPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7485 */     addRelationshipAdapter("dtv.xst.dao.doc.impl.DocumentDAO-DocumentDefinition", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7487 */             return (Class)DocumentDocumentDefinitionRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7490 */     addRelationshipAdapter("dtv.xst.dao.doc.impl.DocumentDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7492 */             return (Class)DocumentPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7495 */     addRelationshipAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionDAO-DocDefProperties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7497 */             return (Class)DocumentDefinitionDocDefPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7500 */     addRelationshipAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7502 */             return (Class)DocumentDefinitionPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7505 */     addRelationshipAdapter("dtv.xst.dao.doc.impl.DocumentDefinitionPropertiesDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7507 */             return (Class)DocumentDefinitionPropertiesPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7510 */     addRelationshipAdapter("dtv.xst.dao.doc.impl.DocumentLineItemDAO-Document", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7512 */             return (Class)DocumentLineItemDocumentRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7515 */     addRelationshipAdapter("dtv.xst.dao.rpt.impl.OrganizerDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7517 */             return (Class)OrganizerPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7520 */     addRelationshipAdapter("dtv.xst.dao.sch.impl.EmployeeTimeOffDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7522 */             return (Class)EmployeeTimeOffPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7525 */     addRelationshipAdapter("dtv.xst.dao.sch.impl.ScheduleDAO-WorkCode", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7527 */             return (Class)ScheduleWorkCodeRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7530 */     addRelationshipAdapter("dtv.xst.dao.sch.impl.ScheduleDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7532 */             return (Class)SchedulePropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7535 */     addRelationshipAdapter("dtv.xst.dao.sch.impl.ShiftDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7537 */             return (Class)ShiftPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7540 */     addRelationshipAdapter("dtv.xst.dao.sls.impl.SalesGoalDAO-Properties", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7542 */             return (Class)SalesGoalPropertiesRelationshipDBA.class;
/*      */           }
/*      */         });
/* 7545 */     addRelationshipAdapter("dtv.xst.dao.cfg.impl.XadminUserDAO-OrgScopes", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {
/*      */           protected Class<? extends IJDBCRelationshipAdapter> getType() {
/* 7547 */             return (Class)XadminUserOrgScopesRelationshipDBA.class;
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   protected void addAdapter(String argKey, AbstractInstanceGenerator<? extends IJDBCTableAdapter> argClass) {
/* 7553 */     this.adapterMap.put(argKey, argClass);
/*      */   }
/*      */   
/*      */   protected void addRelationshipAdapter(String argKey, AbstractInstanceGenerator<? extends IJDBCRelationshipAdapter> argClass) {
/* 7557 */     this.relationshipAdapterMap.put(argKey, argClass);
/*      */   }
/*      */ 
/*      */   
/*      */   public IJDBCTableAdapter getTableAdapterImpl(String argIdentifier) {
/* 7562 */     AbstractInstanceGenerator<? extends IJDBCTableAdapter> adapterClass = this.adapterMap.get(argIdentifier);
/*      */     try {
/* 7564 */       return (adapterClass != null) ? (IJDBCTableAdapter)adapterClass.newInstance() : null;
/*      */     }
/* 7566 */     catch (InstantiationException|IllegalAccessException ex) {
/* 7567 */       throw new DtxException("Could not instantiate adapter for: " + argIdentifier, ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IRelationshipAdapter getRelationshipAdapterImpl(Class<?> argClass, String argIdentifier) {
/* 7574 */     IJDBCRelationshipAdapter adapter = getRelationshipAdapterImplInternal(argClass, argIdentifier);
/* 7575 */     if (adapter == null) {
/* 7576 */       return null;
/*      */     }
/* 7578 */     return (IRelationshipAdapter)adapter;
/*      */   }
/*      */ 
/*      */   
/*      */   private IJDBCRelationshipAdapter getRelationshipAdapterImplInternal(Class<?> argClass, String argIdentifier) {
/* 7583 */     AbstractInstanceGenerator<? extends IJDBCRelationshipAdapter> relationshipAdapterClass = this.relationshipAdapterMap.get(argClass.getName() + "-" + argIdentifier);
/*      */     try {
/* 7585 */       if (relationshipAdapterClass != null) {
/* 7586 */         return (IJDBCRelationshipAdapter)relationshipAdapterClass.newInstance();
/*      */       }
/*      */     }
/* 7589 */     catch (InstantiationException|IllegalAccessException ex) {
/* 7590 */       throw new DtxException("Could not instantiate relationship adapter for class: [" + argClass.getName() + "] identifier: [" + argIdentifier + "]", ex);
/*      */     } 
/*      */     
/* 7593 */     Class<?> parent = argClass.getSuperclass();
/* 7594 */     if (parent != null && !parent.getName().startsWith("java.")) {
/* 7595 */       return getRelationshipAdapterImplInternal(parent, argIdentifier);
/*      */     }
/*      */     
/* 7598 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\data2\access\impl\jdbc\JDBCAdapterMapImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */