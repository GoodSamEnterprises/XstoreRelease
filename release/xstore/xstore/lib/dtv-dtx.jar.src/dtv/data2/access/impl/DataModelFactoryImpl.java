/*       */ package dtv.data2.access.impl;
/*       */ import dtv.data2.access.AbstractInstanceGenerator;
/*       */ import dtv.data2.access.IDataAccessObject;
/*       */ import dtv.data2.access.IDataModel;
/*       */ import dtv.data2.access.IDataModelRelationship;
/*       */ import dtv.data2.access.IObjectId;
/*       */ import dtv.data2.access.IRelationshipSetProducer;
/*       */ import dtv.xst.dao.crm.PartyId;
/*       */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
/*       */ 
/*       */ public class DataModelFactoryImpl extends DataModelFactory {
/*    12 */   private final Map<String, IRelationshipSetProducer> relationshipProducerMap = new HashMap<>();
/*    13 */   private final Map<String, AbstractInstanceGenerator<? extends IDataAccessObject>> daoForDaoNameMap = new HashMap<>();
/*    14 */   private final Map<String, AbstractInstanceGenerator<? extends IObjectId>> idForDaoNameMap = new HashMap<>();
/*    15 */   private final Map<String, AbstractInstanceGenerator<? extends IDataModelImpl>> modelForDaoMap = new HashMap<>();
/*    16 */   private final Map<String, AbstractInstanceGenerator<? extends IDataModel>> modelForInterfaceMap = new HashMap<>();
/*       */ 
/*       */   
/*       */   public DataModelFactoryImpl() {
/*    20 */     String parentClassName = null;
/*       */ 
/*       */ 
/*       */     
/*    24 */     IRelationshipSetProducer relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*    26 */           IDataModelRelationship[] rels = new IDataModelRelationship[17];
/*    27 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*    28 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*    29 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*    30 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("BaseReturnedQuantity", ReturnedItemCountId.class, false, false);
/*    31 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("CommissionModifiers", CommissionModifierId.class, false, false);
/*    32 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("DimensionModifiers", DimensionModifierId.class, false, false);
/*    33 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentLineItems", InventoryDocumentLineItemId.class, false, false);
/*    34 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("LineItemAssociationModifiers", LineItemAssociationModifierId.class, false, false);
/*    35 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("RetailPriceModifiers", RetailPriceModifierId.class, false, false);
/*    36 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("TaxGroup", TaxGroupId.class, false, true);
/*    37 */           rels[10] = (IDataModelRelationship)new OneToManyRelationship("TaxModifiers", SaleTaxModifierId.class, false, false);
/*    38 */           rels[11] = (IDataModelRelationship)new OneToOneRelationship("CustomerAccountModifier", CustomerItemAccountModifierId.class, false, false);
/*    39 */           rels[12] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, true);
/*    40 */           rels[13] = (IDataModelRelationship)new OneToManyRelationship("NoteSeq", RetailTransactionLineItemNotesId.class, false, false);
/*    41 */           rels[14] = (IDataModelRelationship)new OneToManyRelationship("RetailInventoryLocationModifiers", RetailInventoryLocationModifierId.class, false, false);
/*    42 */           rels[15] = (IDataModelRelationship)new OneToOneRelationship("OrderModifier", OrderModifierId.class, true, false);
/*    43 */           rels[16] = (IDataModelRelationship)new OneToManyRelationship("KitComponentModifiers", KitComponentModifierId.class, false, false);
/*    44 */           return rels;
/*       */         }
/*       */       };
/*    47 */     addRelationshipProducer("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO", relationshipProducer);
/*    48 */     addDataModels("dtv.xst.dao.trl.impl.SaleReturnLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*    50 */             return (Class)SaleReturnLineItemModel.class;
/*       */           }
/*       */         });
/*    53 */     addInterfaces("dtv.xst.dao.trl.ISaleReturnLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*    55 */             return (Class)SaleReturnLineItemModel.class;
/*       */           }
/*       */         });
/*    58 */     addDaos("SaleReturnLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*    60 */             return (Class)SaleReturnLineItemDAO.class;
/*       */           }
/*       */         });
/*    63 */     addObjectIds("SaleReturnLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*    65 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*    68 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*    70 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*    71 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*    72 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*    73 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*    74 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("RetailInventoryLocationModifiers", RetailInventoryLocationModifierId.class, false, false);
/*    75 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, false);
/*    76 */           return rels;
/*       */         }
/*       */       };
/*    79 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailTransactionExchangeLineItemDAO", relationshipProducer);
/*    80 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionExchangeLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*    82 */             return (Class)RetailTransactionExchangeLineItemModel.class;
/*       */           }
/*       */         });
/*    85 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionExchangeLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*    87 */             return (Class)RetailTransactionExchangeLineItemModel.class;
/*       */           }
/*       */         });
/*    90 */     addDaos("RetailTransactionExchangeLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*    92 */             return (Class)RetailTransactionExchangeLineItemDAO.class;
/*       */           }
/*       */         });
/*    95 */     addObjectIds("RetailTransactionExchangeLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*    97 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   100 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   102 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*   103 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("SaleTaxGroupRule", TaxGroupRuleId.class, false, true);
/*   104 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", SaleTaxModifierPropertyId.class, false, false, true);
/*   105 */           return rels;
/*       */         }
/*       */       };
/*   108 */     addRelationshipProducer("dtv.xst.dao.trl.impl.SaleTaxModifierDAO", relationshipProducer);
/*   109 */     addDataModels("dtv.xst.dao.trl.impl.SaleTaxModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   111 */             return (Class)SaleTaxModifierModel.class;
/*       */           }
/*       */         });
/*   114 */     addInterfaces("dtv.xst.dao.trl.ISaleTaxModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   116 */             return (Class)SaleTaxModifierModel.class;
/*       */           }
/*       */         });
/*   119 */     addDaos("SaleTaxModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   121 */             return (Class)SaleTaxModifierDAO.class;
/*       */           }
/*       */         });
/*   124 */     addObjectIds("SaleTaxModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   126 */             return (Class)SaleTaxModifierId.class;
/*       */           }
/*       */         });
/*   129 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   131 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*   132 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   133 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   134 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   135 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("SaleTaxGroupRule", TaxGroupRuleId.class, false, true);
/*   136 */           return rels;
/*       */         }
/*       */       };
/*   139 */     addRelationshipProducer("dtv.xst.dao.trl.impl.TaxLineItemDAO", relationshipProducer);
/*   140 */     addDataModels("dtv.xst.dao.trl.impl.TaxLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   142 */             return (Class)TaxLineItemModel.class;
/*       */           }
/*       */         });
/*   145 */     addInterfaces("dtv.xst.dao.trl.ITaxLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   147 */             return (Class)TaxLineItemModel.class;
/*       */           }
/*       */         });
/*   150 */     addDaos("TaxLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   152 */             return (Class)TaxLineItemDAO.class;
/*       */           }
/*       */         });
/*   155 */     addObjectIds("TaxLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   157 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   160 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   162 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*   163 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("DestinationZoneObject", AirportZoneId.class, false, false);
/*   164 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionFlightInfoPropertyId.class, false, false, true);
/*   165 */           return rels;
/*       */         }
/*       */       };
/*   168 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoDAO", relationshipProducer);
/*   169 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   171 */             return (Class)RetailTransactionFlightInfoModel.class;
/*       */           }
/*       */         });
/*   174 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionFlightInfo", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   176 */             return (Class)RetailTransactionFlightInfoModel.class;
/*       */           }
/*       */         });
/*   179 */     addDaos("RetailTransactionFlightInfo", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   181 */             return (Class)RetailTransactionFlightInfoDAO.class;
/*       */           }
/*       */         });
/*   184 */     addObjectIds("RetailTransactionFlightInfo", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   186 */             return (Class)RetailTransactionFlightInfoId.class;
/*       */           }
/*       */         });
/*   189 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   191 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*   192 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("KitComponent", KitComponentId.class, false, false);
/*   193 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", KitComponentModifierPropertyId.class, false, false, true);
/*   194 */           return rels;
/*       */         }
/*       */       };
/*   197 */     addRelationshipProducer("dtv.xst.dao.trl.impl.KitComponentModifierDAO", relationshipProducer);
/*   198 */     addDataModels("dtv.xst.dao.trl.impl.KitComponentModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   200 */             return (Class)KitComponentModifierModel.class;
/*       */           }
/*       */         });
/*   203 */     addInterfaces("dtv.xst.dao.trl.IKitComponentModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   205 */             return (Class)KitComponentModifierModel.class;
/*       */           }
/*       */         });
/*   208 */     addDaos("KitComponentModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   210 */             return (Class)KitComponentModifierDAO.class;
/*       */           }
/*       */         });
/*   213 */     addObjectIds("KitComponentModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   215 */             return (Class)KitComponentModifierId.class;
/*       */           }
/*       */         });
/*   218 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   220 */           IDataModelRelationship[] rels = new IDataModelRelationship[18];
/*   221 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   222 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   223 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   224 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("BaseReturnedQuantity", ReturnedItemCountId.class, false, false);
/*   225 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("CommissionModifiers", CommissionModifierId.class, false, false);
/*   226 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("DimensionModifiers", DimensionModifierId.class, false, false);
/*   227 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentLineItems", InventoryDocumentLineItemId.class, false, false);
/*   228 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("LineItemAssociationModifiers", LineItemAssociationModifierId.class, false, false);
/*   229 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("RetailPriceModifiers", RetailPriceModifierId.class, false, false);
/*   230 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("TaxGroup", TaxGroupId.class, false, true);
/*   231 */           rels[10] = (IDataModelRelationship)new OneToManyRelationship("TaxModifiers", SaleTaxModifierId.class, false, false);
/*   232 */           rels[11] = (IDataModelRelationship)new OneToOneRelationship("CustomerAccountModifier", CustomerItemAccountModifierId.class, false, false);
/*   233 */           rels[12] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, true);
/*   234 */           rels[13] = (IDataModelRelationship)new OneToManyRelationship("NoteSeq", RetailTransactionLineItemNotesId.class, false, false);
/*   235 */           rels[14] = (IDataModelRelationship)new OneToManyRelationship("RetailInventoryLocationModifiers", RetailInventoryLocationModifierId.class, false, false);
/*   236 */           rels[15] = (IDataModelRelationship)new OneToOneRelationship("OrderModifier", OrderModifierId.class, true, false);
/*   237 */           rels[16] = (IDataModelRelationship)new OneToManyRelationship("KitComponentModifiers", KitComponentModifierId.class, false, false);
/*   238 */           rels[17] = (IDataModelRelationship)new OneToManyRelationship("WarrantyModifiers", WarrantyModifierId.class, false, false);
/*   239 */           return rels;
/*       */         }
/*       */       };
/*   242 */     addRelationshipProducer("dtv.xst.dao.trl.impl.WarrantyLineItemDAO", relationshipProducer);
/*   243 */     addDataModels("dtv.xst.dao.trl.impl.WarrantyLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   245 */             return (Class)WarrantyLineItemModel.class;
/*       */           }
/*       */         });
/*   248 */     addInterfaces("dtv.xst.dao.trl.IWarrantyLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   250 */             return (Class)WarrantyLineItemModel.class;
/*       */           }
/*       */         });
/*   253 */     addDaos("WarrantyLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   255 */             return (Class)WarrantyLineItemDAO.class;
/*       */           }
/*       */         });
/*   258 */     addObjectIds("WarrantyLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   260 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   263 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   265 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   266 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WarrantyModifierPropertyId.class, false, false, true);
/*   267 */           return rels;
/*       */         }
/*       */       };
/*   270 */     addRelationshipProducer("dtv.xst.dao.trl.impl.WarrantyModifierDAO", relationshipProducer);
/*   271 */     addDataModels("dtv.xst.dao.trl.impl.WarrantyModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   273 */             return (Class)WarrantyModifierModel.class;
/*       */           }
/*       */         });
/*   276 */     addInterfaces("dtv.xst.dao.trl.IWarrantyModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   278 */             return (Class)WarrantyModifierModel.class;
/*       */           }
/*       */         });
/*   281 */     addDaos("WarrantyModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   283 */             return (Class)WarrantyModifierDAO.class;
/*       */           }
/*       */         });
/*   286 */     addObjectIds("WarrantyModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   288 */             return (Class)WarrantyModifierId.class;
/*       */           }
/*       */         });
/*   291 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   293 */           IDataModelRelationship[] rels = new IDataModelRelationship[17];
/*   294 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   295 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   296 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   297 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("BaseReturnedQuantity", ReturnedItemCountId.class, false, false);
/*   298 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("CommissionModifiers", CommissionModifierId.class, false, false);
/*   299 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("DimensionModifiers", DimensionModifierId.class, false, false);
/*   300 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentLineItems", InventoryDocumentLineItemId.class, false, false);
/*   301 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("LineItemAssociationModifiers", LineItemAssociationModifierId.class, false, false);
/*   302 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("RetailPriceModifiers", RetailPriceModifierId.class, false, false);
/*   303 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("TaxGroup", TaxGroupId.class, false, true);
/*   304 */           rels[10] = (IDataModelRelationship)new OneToManyRelationship("TaxModifiers", SaleTaxModifierId.class, false, false);
/*   305 */           rels[11] = (IDataModelRelationship)new OneToOneRelationship("CustomerAccountModifier", CustomerItemAccountModifierId.class, false, false);
/*   306 */           rels[12] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, true);
/*   307 */           rels[13] = (IDataModelRelationship)new OneToManyRelationship("NoteSeq", RetailTransactionLineItemNotesId.class, false, false);
/*   308 */           rels[14] = (IDataModelRelationship)new OneToManyRelationship("RetailInventoryLocationModifiers", RetailInventoryLocationModifierId.class, false, false);
/*   309 */           rels[15] = (IDataModelRelationship)new OneToOneRelationship("OrderModifier", OrderModifierId.class, true, false);
/*   310 */           rels[16] = (IDataModelRelationship)new OneToManyRelationship("KitComponentModifiers", KitComponentModifierId.class, false, false);
/*   311 */           return rels;
/*       */         }
/*       */       };
/*   314 */     addRelationshipProducer("dtv.xst.dao.trl.impl.AccountReceivableSaleLineItemDAO", relationshipProducer);
/*   315 */     addDataModels("dtv.xst.dao.trl.impl.AccountReceivableSaleLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   317 */             return (Class)AccountReceivableSaleLineItemModel.class;
/*       */           }
/*       */         });
/*   320 */     addInterfaces("dtv.xst.dao.trl.IAccountReceivableSaleLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   322 */             return (Class)AccountReceivableSaleLineItemModel.class;
/*       */           }
/*       */         });
/*   325 */     addDaos("AccountReceivableSaleLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   327 */             return (Class)AccountReceivableSaleLineItemDAO.class;
/*       */           }
/*       */         });
/*   330 */     addObjectIds("AccountReceivableSaleLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   332 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   335 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   337 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*   338 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("EmployeeParty", PartyId.class, true, false);
/*   339 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", CommissionModifierPropertyId.class, false, false, true);
/*   340 */           return rels;
/*       */         }
/*       */       };
/*   343 */     addRelationshipProducer("dtv.xst.dao.trl.impl.CommissionModifierDAO", relationshipProducer);
/*   344 */     addDataModels("dtv.xst.dao.trl.impl.CommissionModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   346 */             return (Class)CommissionModifierModel.class;
/*       */           }
/*       */         });
/*   349 */     addInterfaces("dtv.xst.dao.trl.ICommissionModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   351 */             return (Class)CommissionModifierModel.class;
/*       */           }
/*       */         });
/*   354 */     addDaos("CommissionModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   356 */             return (Class)CommissionModifierDAO.class;
/*       */           }
/*       */         });
/*   359 */     addObjectIds("CommissionModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   361 */             return (Class)CommissionModifierId.class;
/*       */           }
/*       */         });
/*   364 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   366 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   367 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CorrectionModifierPropertyId.class, false, false, true);
/*   368 */           return rels;
/*       */         }
/*       */       };
/*   371 */     addRelationshipProducer("dtv.xst.dao.trl.impl.CorrectionModifierDAO", relationshipProducer);
/*   372 */     addDataModels("dtv.xst.dao.trl.impl.CorrectionModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   374 */             return (Class)CorrectionModifierModel.class;
/*       */           }
/*       */         });
/*   377 */     addInterfaces("dtv.xst.dao.trl.ICorrectionModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   379 */             return (Class)CorrectionModifierModel.class;
/*       */           }
/*       */         });
/*   382 */     addDaos("CorrectionModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   384 */             return (Class)CorrectionModifierDAO.class;
/*       */           }
/*       */         });
/*   387 */     addObjectIds("CorrectionModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   389 */             return (Class)CorrectionModifierId.class;
/*       */           }
/*       */         });
/*   392 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   394 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*   395 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   396 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   397 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   398 */           return rels;
/*       */         }
/*       */       };
/*   401 */     addRelationshipProducer("dtv.xst.dao.trl.impl.CouponLineItemDAO", relationshipProducer);
/*   402 */     addDataModels("dtv.xst.dao.trl.impl.CouponLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   404 */             return (Class)CouponLineItemModel.class;
/*       */           }
/*       */         });
/*   407 */     addInterfaces("dtv.xst.dao.trl.ICouponLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   409 */             return (Class)CouponLineItemModel.class;
/*       */           }
/*       */         });
/*   412 */     addDaos("CouponLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   414 */             return (Class)CouponLineItemDAO.class;
/*       */           }
/*       */         });
/*   417 */     addObjectIds("CouponLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   419 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   422 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   424 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   425 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerItemAccountModifierPropertyId.class, false, false, true);
/*   426 */           return rels;
/*       */         }
/*       */       };
/*   429 */     addRelationshipProducer("dtv.xst.dao.trl.impl.CustomerItemAccountModifierDAO", relationshipProducer);
/*   430 */     addDataModels("dtv.xst.dao.trl.impl.CustomerItemAccountModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   432 */             return (Class)CustomerItemAccountModifierModel.class;
/*       */           }
/*       */         });
/*   435 */     addInterfaces("dtv.xst.dao.trl.ICustomerItemAccountModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   437 */             return (Class)CustomerItemAccountModifierModel.class;
/*       */           }
/*       */         });
/*   440 */     addDaos("CustomerItemAccountModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   442 */             return (Class)CustomerItemAccountModifierDAO.class;
/*       */           }
/*       */         });
/*   445 */     addObjectIds("CustomerItemAccountModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   447 */             return (Class)CustomerItemAccountModifierId.class;
/*       */           }
/*       */         });
/*   450 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   452 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   453 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DimensionModifierPropertyId.class, false, false, true);
/*   454 */           return rels;
/*       */         }
/*       */       };
/*   457 */     addRelationshipProducer("dtv.xst.dao.trl.impl.DimensionModifierDAO", relationshipProducer);
/*   458 */     addDataModels("dtv.xst.dao.trl.impl.DimensionModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   460 */             return (Class)DimensionModifierModel.class;
/*       */           }
/*       */         });
/*   463 */     addInterfaces("dtv.xst.dao.trl.IDimensionModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   465 */             return (Class)DimensionModifierModel.class;
/*       */           }
/*       */         });
/*   468 */     addDaos("DimensionModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   470 */             return (Class)DimensionModifierDAO.class;
/*       */           }
/*       */         });
/*   473 */     addObjectIds("DimensionModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   475 */             return (Class)DimensionModifierId.class;
/*       */           }
/*       */         });
/*   478 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   480 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*   481 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   482 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   483 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   484 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("LineItemDiscount", DiscountId.class, false, false);
/*   485 */           return rels;
/*       */         }
/*       */       };
/*   488 */     addRelationshipProducer("dtv.xst.dao.trl.impl.DiscountLineItemDAO", relationshipProducer);
/*   489 */     addDataModels("dtv.xst.dao.trl.impl.DiscountLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   491 */             return (Class)DiscountLineItemModel.class;
/*       */           }
/*       */         });
/*   494 */     addInterfaces("dtv.xst.dao.trl.IDiscountLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   496 */             return (Class)DiscountLineItemModel.class;
/*       */           }
/*       */         });
/*   499 */     addDaos("DiscountLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   501 */             return (Class)DiscountLineItemDAO.class;
/*       */           }
/*       */         });
/*   504 */     addObjectIds("DiscountLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   506 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   509 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   511 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*   512 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*   513 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*   514 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*   515 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*   516 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*   517 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("CustomerParty", PartyId.class, false, false);
/*   518 */           rels[6] = (IDataModelRelationship)new OneToOneRelationship("EscrowAccountActivity", EscrowAccountActivityId.class, false, false);
/*   519 */           return rels;
/*       */         }
/*       */       };
/*   522 */     addRelationshipProducer("dtv.xst.dao.trl.impl.EscrowTransactionDAO", relationshipProducer);
/*   523 */     addDataModels("dtv.xst.dao.trl.impl.EscrowTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   525 */             return (Class)EscrowTransactionModel.class;
/*       */           }
/*       */         });
/*   528 */     addInterfaces("dtv.xst.dao.trl.IEscrowTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   530 */             return (Class)EscrowTransactionModel.class;
/*       */           }
/*       */         });
/*   533 */     addDaos("EscrowTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   535 */             return (Class)EscrowTransactionDAO.class;
/*       */           }
/*       */         });
/*   538 */     addObjectIds("EscrowTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   540 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*   543 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   545 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*   546 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("InventoryDocument", InventoryDocumentId.class, false, false);
/*   547 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryDocumentModifierPropertyId.class, false, false, true);
/*   548 */           return rels;
/*       */         }
/*       */       };
/*   551 */     addRelationshipProducer("dtv.xst.dao.trl.impl.InventoryDocumentModifierDAO", relationshipProducer);
/*   552 */     addDataModels("dtv.xst.dao.trl.impl.InventoryDocumentModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   554 */             return (Class)InventoryDocumentModifierModel.class;
/*       */           }
/*       */         });
/*   557 */     addInterfaces("dtv.xst.dao.trl.IInventoryDocumentModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   559 */             return (Class)InventoryDocumentModifierModel.class;
/*       */           }
/*       */         });
/*   562 */     addDaos("InventoryDocumentModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   564 */             return (Class)InventoryDocumentModifierDAO.class;
/*       */           }
/*       */         });
/*   567 */     addObjectIds("InventoryDocumentModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   569 */             return (Class)InventoryDocumentModifierId.class;
/*       */           }
/*       */         });
/*   572 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   574 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*   575 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("ChildLineItem", RetailTransactionLineItemId.class, false, false);
/*   576 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("LineItemAssociationTypeCode", LineItemAssociationTypeCodeId.class, false, false);
/*   577 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", LineItemAssociationModifierPropertyId.class, false, false, true);
/*   578 */           return rels;
/*       */         }
/*       */       };
/*   581 */     addRelationshipProducer("dtv.xst.dao.trl.impl.LineItemAssociationModifierDAO", relationshipProducer);
/*   582 */     addDataModels("dtv.xst.dao.trl.impl.LineItemAssociationModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   584 */             return (Class)LineItemAssociationModifierModel.class;
/*       */           }
/*       */         });
/*   587 */     addInterfaces("dtv.xst.dao.trl.ILineItemAssociationModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   589 */             return (Class)LineItemAssociationModifierModel.class;
/*       */           }
/*       */         });
/*   592 */     addDaos("LineItemAssociationModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   594 */             return (Class)LineItemAssociationModifierDAO.class;
/*       */           }
/*       */         });
/*   597 */     addObjectIds("LineItemAssociationModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   599 */             return (Class)LineItemAssociationModifierId.class;
/*       */           }
/*       */         });
/*   602 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   604 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   605 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", LineItemAssociationTypeCodePropertyId.class, false, false, true);
/*   606 */           return rels;
/*       */         }
/*       */       };
/*   609 */     addRelationshipProducer("dtv.xst.dao.trl.impl.LineItemAssociationTypeCodeDAO", relationshipProducer);
/*   610 */     addDataModels("dtv.xst.dao.trl.impl.LineItemAssociationTypeCodeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   612 */             return (Class)LineItemAssociationTypeCodeModel.class;
/*       */           }
/*       */         });
/*   615 */     addInterfaces("dtv.xst.dao.trl.ILineItemAssociationTypeCode", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   617 */             return (Class)LineItemAssociationTypeCodeModel.class;
/*       */           }
/*       */         });
/*   620 */     addDaos("LineItemAssociationTypeCode", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   622 */             return (Class)LineItemAssociationTypeCodeDAO.class;
/*       */           }
/*       */         });
/*   625 */     addObjectIds("LineItemAssociationTypeCode", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   627 */             return (Class)LineItemAssociationTypeCodeId.class;
/*       */           }
/*       */         });
/*   630 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   632 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   633 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailInventoryLocationModifierPropertyId.class, false, false, true);
/*   634 */           return rels;
/*       */         }
/*       */       };
/*   637 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailInventoryLocationModifierDAO", relationshipProducer);
/*   638 */     addDataModels("dtv.xst.dao.trl.impl.RetailInventoryLocationModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   640 */             return (Class)RetailInventoryLocationModifierModel.class;
/*       */           }
/*       */         });
/*   643 */     addInterfaces("dtv.xst.dao.trl.IRetailInventoryLocationModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   645 */             return (Class)RetailInventoryLocationModifierModel.class;
/*       */           }
/*       */         });
/*   648 */     addDaos("RetailInventoryLocationModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   650 */             return (Class)RetailInventoryLocationModifierDAO.class;
/*       */           }
/*       */         });
/*   653 */     addObjectIds("RetailInventoryLocationModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   655 */             return (Class)RetailInventoryLocationModifierId.class;
/*       */           }
/*       */         });
/*   658 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   660 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*   661 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Discount", DiscountId.class, false, false);
/*   662 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("ReasonLineItem", RetailTransactionLineItemId.class, false, false);
/*   663 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailPriceModifierPropertyId.class, false, false, true);
/*   664 */           return rels;
/*       */         }
/*       */       };
/*   667 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailPriceModifierDAO", relationshipProducer);
/*   668 */     addDataModels("dtv.xst.dao.trl.impl.RetailPriceModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   670 */             return (Class)RetailPriceModifierModel.class;
/*       */           }
/*       */         });
/*   673 */     addInterfaces("dtv.xst.dao.trl.IRetailPriceModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   675 */             return (Class)RetailPriceModifierModel.class;
/*       */           }
/*       */         });
/*   678 */     addDaos("RetailPriceModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   680 */             return (Class)RetailPriceModifierDAO.class;
/*       */           }
/*       */         });
/*   683 */     addObjectIds("RetailPriceModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   685 */             return (Class)RetailPriceModifierId.class;
/*       */           }
/*       */         });
/*   688 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   690 */           IDataModelRelationship[] rels = new IDataModelRelationship[9];
/*   691 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*   692 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*   693 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*   694 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*   695 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*   696 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("CustomerParty", PartyId.class, false, false);
/*   697 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentModifiers", InventoryDocumentModifierId.class, false, false);
/*   698 */           rels[7] = (IDataModelRelationship)new OneToOneRelationship("TaxExemption", TaxExemptionId.class, false, false);
/*   699 */           rels[8] = (IDataModelRelationship)new OneToOneRelationship("FlightInformation", RetailTransactionFlightInfoId.class, false, false);
/*   700 */           return rels;
/*       */         }
/*       */       };
/*   703 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailTransactionDAO", relationshipProducer);
/*   704 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   706 */             return (Class)RetailTransactionModel.class;
/*       */           }
/*       */         });
/*   709 */     addInterfaces("dtv.xst.dao.trl.IRetailTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   711 */             return (Class)RetailTransactionModel.class;
/*       */           }
/*       */         });
/*   714 */     addDaos("RetailTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   716 */             return (Class)RetailTransactionDAO.class;
/*       */           }
/*       */         });
/*   719 */     addObjectIds("RetailTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   721 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*   724 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   726 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*   727 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   728 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   729 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   730 */           return rels;
/*       */         }
/*       */       };
/*   733 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailTransactionDealLineItemDAO", relationshipProducer);
/*   734 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionDealLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   736 */             return (Class)RetailTransactionDealLineItemModel.class;
/*       */           }
/*       */         });
/*   739 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionDealLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   741 */             return (Class)RetailTransactionDealLineItemModel.class;
/*       */           }
/*       */         });
/*   744 */     addDaos("RetailTransactionDealLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   746 */             return (Class)RetailTransactionDealLineItemDAO.class;
/*       */           }
/*       */         });
/*   749 */     addObjectIds("RetailTransactionDealLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   751 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   754 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   756 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*   757 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   758 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   759 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   760 */           return rels;
/*       */         }
/*       */       };
/*   763 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO", relationshipProducer);
/*   764 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   766 */             return (Class)RetailTransactionLineItemModel.class;
/*       */           }
/*       */         });
/*   769 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   771 */             return (Class)RetailTransactionLineItemModel.class;
/*       */           }
/*       */         });
/*   774 */     addDaos("RetailTransactionLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   776 */             return (Class)RetailTransactionLineItemDAO.class;
/*       */           }
/*       */         });
/*   779 */     addObjectIds("RetailTransactionLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   781 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   784 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   786 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   787 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemNotesPropertyId.class, false, false, true);
/*   788 */           return rels;
/*       */         }
/*       */       };
/*   791 */     addRelationshipProducer("dtv.xst.dao.trl.impl.RetailTransactionLineItemNotesDAO", relationshipProducer);
/*   792 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionLineItemNotesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   794 */             return (Class)RetailTransactionLineItemNotesModel.class;
/*       */           }
/*       */         });
/*   797 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionLineItemNotes", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   799 */             return (Class)RetailTransactionLineItemNotesModel.class;
/*       */           }
/*       */         });
/*   802 */     addDaos("RetailTransactionLineItemNotes", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   804 */             return (Class)RetailTransactionLineItemNotesDAO.class;
/*       */           }
/*       */         });
/*   807 */     addObjectIds("RetailTransactionLineItemNotes", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   809 */             return (Class)RetailTransactionLineItemNotesId.class;
/*       */           }
/*       */         });
/*   812 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   814 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   815 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReturnedItemCountPropertyId.class, false, false, true);
/*   816 */           return rels;
/*       */         }
/*       */       };
/*   819 */     addRelationshipProducer("dtv.xst.dao.trl.impl.ReturnedItemCountDAO", relationshipProducer);
/*   820 */     addDataModels("dtv.xst.dao.trl.impl.ReturnedItemCountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   822 */             return (Class)ReturnedItemCountModel.class;
/*       */           }
/*       */         });
/*   825 */     addInterfaces("dtv.xst.dao.trl.IReturnedItemCount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   827 */             return (Class)ReturnedItemCountModel.class;
/*       */           }
/*       */         });
/*   830 */     addDaos("ReturnedItemCount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   832 */             return (Class)ReturnedItemCountDAO.class;
/*       */           }
/*       */         });
/*   835 */     addObjectIds("ReturnedItemCount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   837 */             return (Class)ReturnedItemCountId.class;
/*       */           }
/*       */         });
/*   840 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   842 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   843 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReturnedItemJournalPropertyId.class, false, false, true);
/*   844 */           return rels;
/*       */         }
/*       */       };
/*   847 */     addRelationshipProducer("dtv.xst.dao.trl.impl.ReturnedItemJournalDAO", relationshipProducer);
/*   848 */     addDataModels("dtv.xst.dao.trl.impl.ReturnedItemJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   850 */             return (Class)ReturnedItemJournalModel.class;
/*       */           }
/*       */         });
/*   853 */     addInterfaces("dtv.xst.dao.trl.IReturnedItemJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   855 */             return (Class)ReturnedItemJournalModel.class;
/*       */           }
/*       */         });
/*   858 */     addDaos("ReturnedItemJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   860 */             return (Class)ReturnedItemJournalDAO.class;
/*       */           }
/*       */         });
/*   863 */     addObjectIds("ReturnedItemJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   865 */             return (Class)ReturnedItemJournalId.class;
/*       */           }
/*       */         });
/*   868 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   870 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*   871 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   872 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   873 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   874 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("LineItemDiscount", DiscountId.class, false, false);
/*   875 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("Voucher", VoucherId.class, false, false);
/*   876 */           return rels;
/*       */         }
/*       */       };
/*   879 */     addRelationshipProducer("dtv.xst.dao.trl.impl.VoucherDiscountLineItemDAO", relationshipProducer);
/*   880 */     addDataModels("dtv.xst.dao.trl.impl.VoucherDiscountLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   882 */             return (Class)VoucherDiscountLineItemModel.class;
/*       */           }
/*       */         });
/*   885 */     addInterfaces("dtv.xst.dao.trl.IVoucherDiscountLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   887 */             return (Class)VoucherDiscountLineItemModel.class;
/*       */           }
/*       */         });
/*   890 */     addDaos("VoucherDiscountLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   892 */             return (Class)VoucherDiscountLineItemDAO.class;
/*       */           }
/*       */         });
/*   895 */     addObjectIds("VoucherDiscountLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   897 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   900 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   902 */           IDataModelRelationship[] rels = new IDataModelRelationship[18];
/*   903 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*   904 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*   905 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*   906 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("BaseReturnedQuantity", ReturnedItemCountId.class, false, false);
/*   907 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("CommissionModifiers", CommissionModifierId.class, false, false);
/*   908 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("DimensionModifiers", DimensionModifierId.class, false, false);
/*   909 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentLineItems", InventoryDocumentLineItemId.class, false, false);
/*   910 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("LineItemAssociationModifiers", LineItemAssociationModifierId.class, false, false);
/*   911 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("RetailPriceModifiers", RetailPriceModifierId.class, false, false);
/*   912 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("TaxGroup", TaxGroupId.class, false, true);
/*   913 */           rels[10] = (IDataModelRelationship)new OneToManyRelationship("TaxModifiers", SaleTaxModifierId.class, false, false);
/*   914 */           rels[11] = (IDataModelRelationship)new OneToOneRelationship("CustomerAccountModifier", CustomerItemAccountModifierId.class, false, false);
/*   915 */           rels[12] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, true);
/*   916 */           rels[13] = (IDataModelRelationship)new OneToManyRelationship("NoteSeq", RetailTransactionLineItemNotesId.class, false, false);
/*   917 */           rels[14] = (IDataModelRelationship)new OneToManyRelationship("RetailInventoryLocationModifiers", RetailInventoryLocationModifierId.class, false, false);
/*   918 */           rels[15] = (IDataModelRelationship)new OneToOneRelationship("OrderModifier", OrderModifierId.class, true, false);
/*   919 */           rels[16] = (IDataModelRelationship)new OneToManyRelationship("KitComponentModifiers", KitComponentModifierId.class, false, false);
/*   920 */           rels[17] = (IDataModelRelationship)new OneToOneRelationship("Voucher", VoucherId.class, false, false);
/*   921 */           return rels;
/*       */         }
/*       */       };
/*   924 */     addRelationshipProducer("dtv.xst.dao.trl.impl.VoucherSaleLineItemDAO", relationshipProducer);
/*   925 */     addDataModels("dtv.xst.dao.trl.impl.VoucherSaleLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   927 */             return (Class)VoucherSaleLineItemModel.class;
/*       */           }
/*       */         });
/*   930 */     addInterfaces("dtv.xst.dao.trl.IVoucherSaleLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   932 */             return (Class)VoucherSaleLineItemModel.class;
/*       */           }
/*       */         });
/*   935 */     addDaos("VoucherSaleLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   937 */             return (Class)VoucherSaleLineItemDAO.class;
/*       */           }
/*       */         });
/*   940 */     addObjectIds("VoucherSaleLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   942 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*   945 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   947 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*   948 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", KitComponentPropertyId.class, false, false, true);
/*   949 */           return rels;
/*       */         }
/*       */       };
/*   952 */     addRelationshipProducer("dtv.xst.dao.itm.impl.KitComponentDAO", relationshipProducer);
/*   953 */     addDataModels("dtv.xst.dao.itm.impl.KitComponentDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   955 */             return (Class)KitComponentModel.class;
/*       */           }
/*       */         });
/*   958 */     addInterfaces("dtv.xst.dao.itm.IKitComponent", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   960 */             return (Class)KitComponentModel.class;
/*       */           }
/*       */         });
/*   963 */     addDaos("KitComponent", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   965 */             return (Class)KitComponentDAO.class;
/*       */           }
/*       */         });
/*   968 */     addObjectIds("KitComponent", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   970 */             return (Class)KitComponentId.class;
/*       */           }
/*       */         });
/*   973 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*   975 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*   976 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("ItemVendor", VendorId.class, false, false);
/*   977 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemOptionsPropertyId.class, false, false, true);
/*   978 */           return rels;
/*       */         }
/*       */       };
/*   981 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemOptionsDAO", relationshipProducer);
/*   982 */     addDataModels("dtv.xst.dao.itm.impl.ItemOptionsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*   984 */             return (Class)ItemOptionsModel.class;
/*       */           }
/*       */         });
/*   987 */     addInterfaces("dtv.xst.dao.itm.IItemOptions", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*   989 */             return (Class)ItemOptionsModel.class;
/*       */           }
/*       */         });
/*   992 */     addDaos("ItemOptions", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*   994 */             return (Class)ItemOptionsDAO.class;
/*       */           }
/*       */         });
/*   997 */     addObjectIds("ItemOptions", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*   999 */             return (Class)ItemOptionsId.class;
/*       */           }
/*       */         });
/*  1002 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1004 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1005 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemRestrictionCalendarPropertyId.class, false, false, true);
/*  1006 */           return rels;
/*       */         }
/*       */       };
/*  1009 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemRestrictionCalendarDAO", relationshipProducer);
/*  1010 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictionCalendarDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1012 */             return (Class)ItemRestrictionCalendarModel.class;
/*       */           }
/*       */         });
/*  1015 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictionCalendar", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1017 */             return (Class)ItemRestrictionCalendarModel.class;
/*       */           }
/*       */         });
/*  1020 */     addDaos("ItemRestrictionCalendar", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1022 */             return (Class)ItemRestrictionCalendarDAO.class;
/*       */           }
/*       */         });
/*  1025 */     addObjectIds("ItemRestrictionCalendar", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1027 */             return (Class)ItemRestrictionCalendarId.class;
/*       */           }
/*       */         });
/*  1030 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1032 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1033 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemRestrictionPropertyId.class, false, false, true);
/*  1034 */           return rels;
/*       */         }
/*       */       };
/*  1037 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemRestrictionDAO", relationshipProducer);
/*  1038 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1040 */             return (Class)ItemRestrictionModel.class;
/*       */           }
/*       */         });
/*  1043 */     addInterfaces("dtv.xst.dao.itm.IItemRestriction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1045 */             return (Class)ItemRestrictionModel.class;
/*       */           }
/*       */         });
/*  1048 */     addDaos("ItemRestriction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1050 */             return (Class)ItemRestrictionDAO.class;
/*       */           }
/*       */         });
/*  1053 */     addObjectIds("ItemRestriction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1055 */             return (Class)ItemRestrictionId.class;
/*       */           }
/*       */         });
/*  1058 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1060 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1061 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemRestrictionMappingPropertyId.class, false, false, true);
/*  1062 */           return rels;
/*       */         }
/*       */       };
/*  1065 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemRestrictionMappingDAO", relationshipProducer);
/*  1066 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictionMappingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1068 */             return (Class)ItemRestrictionMappingModel.class;
/*       */           }
/*       */         });
/*  1071 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictionMapping", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1073 */             return (Class)ItemRestrictionMappingModel.class;
/*       */           }
/*       */         });
/*  1076 */     addDaos("ItemRestrictionMapping", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1078 */             return (Class)ItemRestrictionMappingDAO.class;
/*       */           }
/*       */         });
/*  1081 */     addObjectIds("ItemRestrictionMapping", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1083 */             return (Class)ItemRestrictionMappingId.class;
/*       */           }
/*       */         });
/*  1086 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1088 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  1089 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("AttachedItem", ItemId.class, false, false);
/*  1090 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("SoldItem", ItemId.class, false, false);
/*  1091 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("AssociationType", LineItemAssociationTypeCodeId.class, false, false);
/*  1092 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("Properties", AttachedItemsPropertyId.class, false, false, true);
/*  1093 */           return rels;
/*       */         }
/*       */       };
/*  1096 */     addRelationshipProducer("dtv.xst.dao.itm.impl.AttachedItemsDAO", relationshipProducer);
/*  1097 */     addDataModels("dtv.xst.dao.itm.impl.AttachedItemsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1099 */             return (Class)AttachedItemsModel.class;
/*       */           }
/*       */         });
/*  1102 */     addInterfaces("dtv.xst.dao.itm.IAttachedItems", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1104 */             return (Class)AttachedItemsModel.class;
/*       */           }
/*       */         });
/*  1107 */     addDaos("AttachedItems", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1109 */             return (Class)AttachedItemsDAO.class;
/*       */           }
/*       */         });
/*  1112 */     addObjectIds("AttachedItems", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1114 */             return (Class)AttachedItemsId.class;
/*       */           }
/*       */         });
/*  1117 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1119 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  1120 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("DimensionValues", ItemDimensionValueId.class, false, false);
/*  1121 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemDimensionTypePropertyId.class, false, false, true);
/*  1122 */           return rels;
/*       */         }
/*       */       };
/*  1125 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemDimensionTypeDAO", relationshipProducer);
/*  1126 */     addDataModels("dtv.xst.dao.itm.impl.ItemDimensionTypeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1128 */             return (Class)ItemDimensionTypeModel.class;
/*       */           }
/*       */         });
/*  1131 */     addInterfaces("dtv.xst.dao.itm.IItemDimensionType", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1133 */             return (Class)ItemDimensionTypeModel.class;
/*       */           }
/*       */         });
/*  1136 */     addDaos("ItemDimensionType", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1138 */             return (Class)ItemDimensionTypeDAO.class;
/*       */           }
/*       */         });
/*  1141 */     addObjectIds("ItemDimensionType", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1143 */             return (Class)ItemDimensionTypeId.class;
/*       */           }
/*       */         });
/*  1146 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1148 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1149 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemDimensionValuePropertyId.class, false, false, true);
/*  1150 */           return rels;
/*       */         }
/*       */       };
/*  1153 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemDimensionValueDAO", relationshipProducer);
/*  1154 */     addDataModels("dtv.xst.dao.itm.impl.ItemDimensionValueDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1156 */             return (Class)ItemDimensionValueModel.class;
/*       */           }
/*       */         });
/*  1159 */     addInterfaces("dtv.xst.dao.itm.IItemDimensionValue", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1161 */             return (Class)ItemDimensionValueModel.class;
/*       */           }
/*       */         });
/*  1164 */     addDaos("ItemDimensionValue", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1166 */             return (Class)ItemDimensionValueDAO.class;
/*       */           }
/*       */         });
/*  1169 */     addObjectIds("ItemDimensionValue", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1171 */             return (Class)ItemDimensionValueId.class;
/*       */           }
/*       */         });
/*  1174 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1176 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  1177 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("LineItemTypes", ItemMessageTypesId.class, false, false);
/*  1178 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("ItemIds", ItemMessageCrossReferenceId.class, false, false);
/*  1179 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemMessagePropertyId.class, false, false, true);
/*  1180 */           return rels;
/*       */         }
/*       */       };
/*  1183 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemMessageDAO", relationshipProducer);
/*  1184 */     addDataModels("dtv.xst.dao.itm.impl.ItemMessageDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1186 */             return (Class)ItemMessageModel.class;
/*       */           }
/*       */         });
/*  1189 */     addInterfaces("dtv.xst.dao.itm.IItemMessage", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1191 */             return (Class)ItemMessageModel.class;
/*       */           }
/*       */         });
/*  1194 */     addDaos("ItemMessage", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1196 */             return (Class)ItemMessageDAO.class;
/*       */           }
/*       */         });
/*  1199 */     addObjectIds("ItemMessage", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1201 */             return (Class)ItemMessageId.class;
/*       */           }
/*       */         });
/*  1204 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1206 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1207 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", MerchandiseHierarchyPropertyId.class, false, false, true);
/*  1208 */           return rels;
/*       */         }
/*       */       };
/*  1211 */     addRelationshipProducer("dtv.xst.dao.itm.impl.MerchandiseHierarchyDAO", relationshipProducer);
/*  1212 */     addDataModels("dtv.xst.dao.itm.impl.MerchandiseHierarchyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1214 */             return (Class)MerchandiseHierarchyModel.class;
/*       */           }
/*       */         });
/*  1217 */     addInterfaces("dtv.xst.dao.itm.IMerchandiseHierarchy", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1219 */             return (Class)MerchandiseHierarchyModel.class;
/*       */           }
/*       */         });
/*  1222 */     addDaos("MerchandiseHierarchy", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1224 */             return (Class)MerchandiseHierarchyDAO.class;
/*       */           }
/*       */         });
/*  1227 */     addObjectIds("MerchandiseHierarchy", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1229 */             return (Class)MerchandiseHierarchyId.class;
/*       */           }
/*       */         });
/*  1232 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1234 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  1235 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, false);
/*  1236 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", QuickItemPropertyId.class, false, false, true);
/*  1237 */           return rels;
/*       */         }
/*       */       };
/*  1240 */     addRelationshipProducer("dtv.xst.dao.itm.impl.QuickItemDAO", relationshipProducer);
/*  1241 */     addDataModels("dtv.xst.dao.itm.impl.QuickItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1243 */             return (Class)QuickItemModel.class;
/*       */           }
/*       */         });
/*  1246 */     addInterfaces("dtv.xst.dao.itm.IQuickItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1248 */             return (Class)QuickItemModel.class;
/*       */           }
/*       */         });
/*  1251 */     addDaos("QuickItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1253 */             return (Class)QuickItemDAO.class;
/*       */           }
/*       */         });
/*  1256 */     addObjectIds("QuickItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1258 */             return (Class)QuickItemId.class;
/*       */           }
/*       */         });
/*  1261 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1263 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1264 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WarrantyPropertyId.class, false, false, true);
/*  1265 */           return rels;
/*       */         }
/*       */       };
/*  1268 */     addRelationshipProducer("dtv.xst.dao.itm.impl.WarrantyDAO", relationshipProducer);
/*  1269 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1271 */             return (Class)WarrantyModel.class;
/*       */           }
/*       */         });
/*  1274 */     addInterfaces("dtv.xst.dao.itm.IWarranty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1276 */             return (Class)WarrantyModel.class;
/*       */           }
/*       */         });
/*  1279 */     addDaos("Warranty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1281 */             return (Class)WarrantyDAO.class;
/*       */           }
/*       */         });
/*  1284 */     addObjectIds("Warranty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1286 */             return (Class)WarrantyId.class;
/*       */           }
/*       */         });
/*  1289 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1291 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1292 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WarrantyJournalPropertyId.class, false, false, true);
/*  1293 */           return rels;
/*       */         }
/*       */       };
/*  1296 */     addRelationshipProducer("dtv.xst.dao.itm.impl.WarrantyJournalDAO", relationshipProducer);
/*  1297 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1299 */             return (Class)WarrantyJournalModel.class;
/*       */           }
/*       */         });
/*  1302 */     addInterfaces("dtv.xst.dao.itm.IWarrantyJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1304 */             return (Class)WarrantyJournalModel.class;
/*       */           }
/*       */         });
/*  1307 */     addDaos("WarrantyJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1309 */             return (Class)WarrantyJournalDAO.class;
/*       */           }
/*       */         });
/*  1312 */     addObjectIds("WarrantyJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1314 */             return (Class)WarrantyJournalId.class;
/*       */           }
/*       */         });
/*  1317 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1319 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1320 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SubstituteItemsPropertyId.class, false, false, true);
/*  1321 */           return rels;
/*       */         }
/*       */       };
/*  1324 */     addRelationshipProducer("dtv.xst.dao.itm.impl.SubstituteItemsDAO", relationshipProducer);
/*  1325 */     addDataModels("dtv.xst.dao.itm.impl.SubstituteItemsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1327 */             return (Class)SubstituteItemsModel.class;
/*       */           }
/*       */         });
/*  1330 */     addInterfaces("dtv.xst.dao.itm.ISubstituteItems", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1332 */             return (Class)SubstituteItemsModel.class;
/*       */           }
/*       */         });
/*  1335 */     addDaos("SubstituteItems", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1337 */             return (Class)SubstituteItemsDAO.class;
/*       */           }
/*       */         });
/*  1340 */     addObjectIds("SubstituteItems", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1342 */             return (Class)SubstituteItemsId.class;
/*       */           }
/*       */         });
/*  1345 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1347 */           IDataModelRelationship[] rels = new IDataModelRelationship[9];
/*  1348 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("ItemOptions", ItemOptionsId.class, false, false);
/*  1349 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("ParentItem", ItemId.class, false, false);
/*  1350 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("ItemDealProperties", ItemDealPropertyId.class, false, false);
/*  1351 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("ItemPromptProperties", ItemPromptPropertyId.class, false, false);
/*  1352 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("ItemLabelProperties", ItemLabelPropertiesId.class, false, false);
/*  1353 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("ItemImages", ItemImageId.class, false, false);
/*  1354 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionTypes", ItemDimensionTypeId.class, false, false);
/*  1355 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionValues", ItemDimensionValueId.class, false, false);
/*  1356 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemPropertyId.class, false, false, true);
/*  1357 */           return rels;
/*       */         }
/*       */       };
/*  1360 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemDAO", relationshipProducer);
/*  1361 */     addDataModels("dtv.xst.dao.itm.impl.ItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1363 */             return (Class)ItemModel.class;
/*       */           }
/*       */         });
/*  1366 */     addInterfaces("dtv.xst.dao.itm.IItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1368 */             return (Class)ItemModel.class;
/*       */           }
/*       */         });
/*  1371 */     addDaos("Item", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1373 */             return (Class)ItemDAO.class;
/*       */           }
/*       */         });
/*  1376 */     addObjectIds("Item", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1378 */             return (Class)ItemId.class;
/*       */           }
/*       */         });
/*  1381 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1383 */           IDataModelRelationship[] rels = new IDataModelRelationship[9];
/*  1384 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("ItemOptions", ItemOptionsId.class, false, false);
/*  1385 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("ParentItem", ItemId.class, false, false);
/*  1386 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("ItemDealProperties", ItemDealPropertyId.class, false, false);
/*  1387 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("ItemPromptProperties", ItemPromptPropertyId.class, false, false);
/*  1388 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("ItemLabelProperties", ItemLabelPropertiesId.class, false, false);
/*  1389 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("ItemImages", ItemImageId.class, false, false);
/*  1390 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionTypes", ItemDimensionTypeId.class, false, false);
/*  1391 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionValues", ItemDimensionValueId.class, false, false);
/*  1392 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemPropertyId.class, false, false, true);
/*  1393 */           return rels;
/*       */         }
/*       */       };
/*  1396 */     addRelationshipProducer("dtv.xst.dao.itm.impl.NonPhysicalItemDAO", relationshipProducer);
/*  1397 */     addDataModels("dtv.xst.dao.itm.impl.NonPhysicalItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1399 */             return (Class)NonPhysicalItemModel.class;
/*       */           }
/*       */         });
/*  1402 */     addInterfaces("dtv.xst.dao.itm.INonPhysicalItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1404 */             return (Class)NonPhysicalItemModel.class;
/*       */           }
/*       */         });
/*  1407 */     addDaos("NonPhysicalItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1409 */             return (Class)NonPhysicalItemDAO.class;
/*       */           }
/*       */         });
/*  1412 */     addObjectIds("NonPhysicalItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1414 */             return (Class)ItemId.class;
/*       */           }
/*       */         });
/*  1417 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1419 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  1420 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Address", AddressId.class, false, false);
/*  1421 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", VendorPropertyId.class, false, false, true);
/*  1422 */           return rels;
/*       */         }
/*       */       };
/*  1425 */     addRelationshipProducer("dtv.xst.dao.itm.impl.VendorDAO", relationshipProducer);
/*  1426 */     addDataModels("dtv.xst.dao.itm.impl.VendorDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1428 */             return (Class)VendorModel.class;
/*       */           }
/*       */         });
/*  1431 */     addInterfaces("dtv.xst.dao.itm.IVendor", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1433 */             return (Class)VendorModel.class;
/*       */           }
/*       */         });
/*  1436 */     addDaos("Vendor", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1438 */             return (Class)VendorDAO.class;
/*       */           }
/*       */         });
/*  1441 */     addObjectIds("Vendor", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1443 */             return (Class)VendorId.class;
/*       */           }
/*       */         });
/*  1446 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1448 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  1449 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, false);
/*  1450 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemCrossReferencePropertyId.class, false, false, true);
/*  1451 */           return rels;
/*       */         }
/*       */       };
/*  1454 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemCrossReferenceDAO", relationshipProducer);
/*  1455 */     addDataModels("dtv.xst.dao.itm.impl.ItemCrossReferenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1457 */             return (Class)ItemCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  1460 */     addInterfaces("dtv.xst.dao.itm.IItemCrossReference", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1462 */             return (Class)ItemCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  1465 */     addDaos("ItemCrossReference", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1467 */             return (Class)ItemCrossReferenceDAO.class;
/*       */           }
/*       */         });
/*  1470 */     addObjectIds("ItemCrossReference", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1472 */             return (Class)ItemCrossReferenceId.class;
/*       */           }
/*       */         });
/*  1475 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1477 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1478 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemDealPropertyPropertyId.class, false, false, true);
/*  1479 */           return rels;
/*       */         }
/*       */       };
/*  1482 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemDealPropertyDAO", relationshipProducer);
/*  1483 */     addDataModels("dtv.xst.dao.itm.impl.ItemDealPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1485 */             return (Class)ItemDealPropertyModel.class;
/*       */           }
/*       */         });
/*  1488 */     addInterfaces("dtv.xst.dao.itm.IItemDealProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1490 */             return (Class)ItemDealPropertyModel.class;
/*       */           }
/*       */         });
/*  1493 */     addDaos("ItemDealProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1495 */             return (Class)ItemDealPropertyDAO.class;
/*       */           }
/*       */         });
/*  1498 */     addObjectIds("ItemDealProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1500 */             return (Class)ItemDealPropertyId.class;
/*       */           }
/*       */         });
/*  1503 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1505 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1506 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemMessageCrossReferencePropertyId.class, false, false, true);
/*  1507 */           return rels;
/*       */         }
/*       */       };
/*  1510 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemMessageCrossReferenceDAO", relationshipProducer);
/*  1511 */     addDataModels("dtv.xst.dao.itm.impl.ItemMessageCrossReferenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1513 */             return (Class)ItemMessageCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  1516 */     addInterfaces("dtv.xst.dao.itm.IItemMessageCrossReference", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1518 */             return (Class)ItemMessageCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  1521 */     addDaos("ItemMessageCrossReference", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1523 */             return (Class)ItemMessageCrossReferenceDAO.class;
/*       */           }
/*       */         });
/*  1526 */     addObjectIds("ItemMessageCrossReference", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1528 */             return (Class)ItemMessageCrossReferenceId.class;
/*       */           }
/*       */         });
/*  1531 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1533 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1534 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemMessageTypesPropertyId.class, false, false, true);
/*  1535 */           return rels;
/*       */         }
/*       */       };
/*  1538 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemMessageTypesDAO", relationshipProducer);
/*  1539 */     addDataModels("dtv.xst.dao.itm.impl.ItemMessageTypesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1541 */             return (Class)ItemMessageTypesModel.class;
/*       */           }
/*       */         });
/*  1544 */     addInterfaces("dtv.xst.dao.itm.IItemMessageTypes", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1546 */             return (Class)ItemMessageTypesModel.class;
/*       */           }
/*       */         });
/*  1549 */     addDaos("ItemMessageTypes", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1551 */             return (Class)ItemMessageTypesDAO.class;
/*       */           }
/*       */         });
/*  1554 */     addObjectIds("ItemMessageTypes", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1556 */             return (Class)ItemMessageTypesId.class;
/*       */           }
/*       */         });
/*  1559 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1561 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1562 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemPricesPropertyId.class, false, false, true);
/*  1563 */           return rels;
/*       */         }
/*       */       };
/*  1566 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemPricesDAO", relationshipProducer);
/*  1567 */     addDataModels("dtv.xst.dao.itm.impl.ItemPricesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1569 */             return (Class)ItemPricesModel.class;
/*       */           }
/*       */         });
/*  1572 */     addInterfaces("dtv.xst.dao.itm.IItemPrices", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1574 */             return (Class)ItemPricesModel.class;
/*       */           }
/*       */         });
/*  1577 */     addDaos("ItemPrices", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1579 */             return (Class)ItemPricesDAO.class;
/*       */           }
/*       */         });
/*  1582 */     addObjectIds("ItemPrices", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1584 */             return (Class)ItemPricesId.class;
/*       */           }
/*       */         });
/*  1587 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1589 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1590 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemPromptPropertyPropertyId.class, false, false, true);
/*  1591 */           return rels;
/*       */         }
/*       */       };
/*  1594 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemPromptPropertyDAO", relationshipProducer);
/*  1595 */     addDataModels("dtv.xst.dao.itm.impl.ItemPromptPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1597 */             return (Class)ItemPromptPropertyModel.class;
/*       */           }
/*       */         });
/*  1600 */     addInterfaces("dtv.xst.dao.itm.IItemPromptProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1602 */             return (Class)ItemPromptPropertyModel.class;
/*       */           }
/*       */         });
/*  1605 */     addDaos("ItemPromptProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1607 */             return (Class)ItemPromptPropertyDAO.class;
/*       */           }
/*       */         });
/*  1610 */     addObjectIds("ItemPromptProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1612 */             return (Class)ItemPromptPropertyId.class;
/*       */           }
/*       */         });
/*  1615 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1617 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1618 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemRestrictGS1PropertyId.class, false, false, true);
/*  1619 */           return rels;
/*       */         }
/*       */       };
/*  1622 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemRestrictGS1DAO", relationshipProducer);
/*  1623 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictGS1DAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1625 */             return (Class)ItemRestrictGS1Model.class;
/*       */           }
/*       */         });
/*  1628 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictGS1", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1630 */             return (Class)ItemRestrictGS1Model.class;
/*       */           }
/*       */         });
/*  1633 */     addDaos("ItemRestrictGS1", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1635 */             return (Class)ItemRestrictGS1DAO.class;
/*       */           }
/*       */         });
/*  1638 */     addObjectIds("ItemRestrictGS1", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1640 */             return (Class)ItemRestrictGS1Id.class;
/*       */           }
/*       */         });
/*  1643 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1645 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1646 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", RefundSchedulePropertyId.class, false, false, true);
/*  1647 */           return rels;
/*       */         }
/*       */       };
/*  1650 */     addRelationshipProducer("dtv.xst.dao.itm.impl.RefundScheduleDAO", relationshipProducer);
/*  1651 */     addDataModels("dtv.xst.dao.itm.impl.RefundScheduleDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1653 */             return (Class)RefundScheduleModel.class;
/*       */           }
/*       */         });
/*  1656 */     addInterfaces("dtv.xst.dao.itm.IRefundSchedule", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1658 */             return (Class)RefundScheduleModel.class;
/*       */           }
/*       */         });
/*  1661 */     addDaos("RefundSchedule", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1663 */             return (Class)RefundScheduleDAO.class;
/*       */           }
/*       */         });
/*  1666 */     addObjectIds("RefundSchedule", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1668 */             return (Class)RefundScheduleId.class;
/*       */           }
/*       */         });
/*  1671 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1673 */           IDataModelRelationship[] rels = new IDataModelRelationship[10];
/*  1674 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("ItemOptions", ItemOptionsId.class, false, false);
/*  1675 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("ParentItem", ItemId.class, false, false);
/*  1676 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("ItemDealProperties", ItemDealPropertyId.class, false, false);
/*  1677 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("ItemPromptProperties", ItemPromptPropertyId.class, false, false);
/*  1678 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("ItemLabelProperties", ItemLabelPropertiesId.class, false, false);
/*  1679 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("ItemImages", ItemImageId.class, false, false);
/*  1680 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionTypes", ItemDimensionTypeId.class, false, false);
/*  1681 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionValues", ItemDimensionValueId.class, false, false);
/*  1682 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemPropertyId.class, false, false, true);
/*  1683 */           rels[9] = (IDataModelRelationship)new OneToManyRelationship("WarrantyItemPrices", WarrantyItemPriceId.class, false, false);
/*  1684 */           return rels;
/*       */         }
/*       */       };
/*  1687 */     addRelationshipProducer("dtv.xst.dao.itm.impl.WarrantyItemDAO", relationshipProducer);
/*  1688 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1690 */             return (Class)WarrantyItemModel.class;
/*       */           }
/*       */         });
/*  1693 */     addInterfaces("dtv.xst.dao.itm.IWarrantyItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1695 */             return (Class)WarrantyItemModel.class;
/*       */           }
/*       */         });
/*  1698 */     addDaos("WarrantyItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1700 */             return (Class)WarrantyItemDAO.class;
/*       */           }
/*       */         });
/*  1703 */     addObjectIds("WarrantyItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1705 */             return (Class)ItemId.class;
/*       */           }
/*       */         });
/*  1708 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1710 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  1711 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("WarrantyItem", ItemId.class, false, false);
/*  1712 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", WarrantyItemCrossReferencePropertyId.class, false, false, true);
/*  1713 */           return rels;
/*       */         }
/*       */       };
/*  1716 */     addRelationshipProducer("dtv.xst.dao.itm.impl.WarrantyItemCrossReferenceDAO", relationshipProducer);
/*  1717 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyItemCrossReferenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1719 */             return (Class)WarrantyItemCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  1722 */     addInterfaces("dtv.xst.dao.itm.IWarrantyItemCrossReference", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1724 */             return (Class)WarrantyItemCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  1727 */     addDaos("WarrantyItemCrossReference", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1729 */             return (Class)WarrantyItemCrossReferenceDAO.class;
/*       */           }
/*       */         });
/*  1732 */     addObjectIds("WarrantyItemCrossReference", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1734 */             return (Class)WarrantyItemCrossReferenceId.class;
/*       */           }
/*       */         });
/*  1737 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1739 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1740 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WarrantyItemPricePropertyId.class, false, false, true);
/*  1741 */           return rels;
/*       */         }
/*       */       };
/*  1744 */     addRelationshipProducer("dtv.xst.dao.itm.impl.WarrantyItemPriceDAO", relationshipProducer);
/*  1745 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyItemPriceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1747 */             return (Class)WarrantyItemPriceModel.class;
/*       */           }
/*       */         });
/*  1750 */     addInterfaces("dtv.xst.dao.itm.IWarrantyItemPrice", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1752 */             return (Class)WarrantyItemPriceModel.class;
/*       */           }
/*       */         });
/*  1755 */     addDaos("WarrantyItemPrice", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1757 */             return (Class)WarrantyItemPriceDAO.class;
/*       */           }
/*       */         });
/*  1760 */     addObjectIds("WarrantyItemPrice", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1762 */             return (Class)WarrantyItemPriceId.class;
/*       */           }
/*       */         });
/*  1765 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1767 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  1768 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, false);
/*  1769 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemLabelBatchPropertyId.class, false, false, true);
/*  1770 */           return rels;
/*       */         }
/*       */       };
/*  1773 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemLabelBatchDAO", relationshipProducer);
/*  1774 */     addDataModels("dtv.xst.dao.itm.impl.ItemLabelBatchDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1776 */             return (Class)ItemLabelBatchModel.class;
/*       */           }
/*       */         });
/*  1779 */     addInterfaces("dtv.xst.dao.itm.IItemLabelBatch", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1781 */             return (Class)ItemLabelBatchModel.class;
/*       */           }
/*       */         });
/*  1784 */     addDaos("ItemLabelBatch", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1786 */             return (Class)ItemLabelBatchDAO.class;
/*       */           }
/*       */         });
/*  1789 */     addObjectIds("ItemLabelBatch", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1791 */             return (Class)ItemLabelBatchId.class;
/*       */           }
/*       */         });
/*  1794 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1796 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1797 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemImagePropertyId.class, false, false, true);
/*  1798 */           return rels;
/*       */         }
/*       */       };
/*  1801 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemImageDAO", relationshipProducer);
/*  1802 */     addDataModels("dtv.xst.dao.itm.impl.ItemImageDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1804 */             return (Class)ItemImageModel.class;
/*       */           }
/*       */         });
/*  1807 */     addInterfaces("dtv.xst.dao.itm.IItemImage", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1809 */             return (Class)ItemImageModel.class;
/*       */           }
/*       */         });
/*  1812 */     addDaos("ItemImage", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1814 */             return (Class)ItemImageDAO.class;
/*       */           }
/*       */         });
/*  1817 */     addObjectIds("ItemImage", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1819 */             return (Class)ItemImageId.class;
/*       */           }
/*       */         });
/*  1822 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1824 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1825 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemLabelPropertiesPropertyId.class, false, false, true);
/*  1826 */           return rels;
/*       */         }
/*       */       };
/*  1829 */     addRelationshipProducer("dtv.xst.dao.itm.impl.ItemLabelPropertiesDAO", relationshipProducer);
/*  1830 */     addDataModels("dtv.xst.dao.itm.impl.ItemLabelPropertiesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1832 */             return (Class)ItemLabelPropertiesModel.class;
/*       */           }
/*       */         });
/*  1835 */     addInterfaces("dtv.xst.dao.itm.IItemLabelProperties", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1837 */             return (Class)ItemLabelPropertiesModel.class;
/*       */           }
/*       */         });
/*  1840 */     addDaos("ItemLabelProperties", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1842 */             return (Class)ItemLabelPropertiesDAO.class;
/*       */           }
/*       */         });
/*  1845 */     addObjectIds("ItemLabelProperties", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1847 */             return (Class)ItemLabelPropertiesId.class;
/*       */           }
/*       */         });
/*  1850 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1852 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1853 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", MatrixSortOrderPropertyId.class, false, false, true);
/*  1854 */           return rels;
/*       */         }
/*       */       };
/*  1857 */     addRelationshipProducer("dtv.xst.dao.itm.impl.MatrixSortOrderDAO", relationshipProducer);
/*  1858 */     addDataModels("dtv.xst.dao.itm.impl.MatrixSortOrderDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1860 */             return (Class)MatrixSortOrderModel.class;
/*       */           }
/*       */         });
/*  1863 */     addInterfaces("dtv.xst.dao.itm.IMatrixSortOrder", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1865 */             return (Class)MatrixSortOrderModel.class;
/*       */           }
/*       */         });
/*  1868 */     addDaos("MatrixSortOrder", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1870 */             return (Class)MatrixSortOrderDAO.class;
/*       */           }
/*       */         });
/*  1873 */     addObjectIds("MatrixSortOrder", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1875 */             return (Class)MatrixSortOrderId.class;
/*       */           }
/*       */         });
/*  1878 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1880 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  1881 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  1882 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  1883 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  1884 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  1885 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  1886 */           return rels;
/*       */         }
/*       */       };
/*  1889 */     addRelationshipProducer("dtv.xst.dao.trn.impl.PosTransactionDAO", relationshipProducer);
/*  1890 */     addDataModels("dtv.xst.dao.trn.impl.PosTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1892 */             return (Class)PosTransactionModel.class;
/*       */           }
/*       */         });
/*  1895 */     addInterfaces("dtv.xst.dao.trn.IPosTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1897 */             return (Class)PosTransactionModel.class;
/*       */           }
/*       */         });
/*  1900 */     addDaos("PosTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1902 */             return (Class)PosTransactionDAO.class;
/*       */           }
/*       */         });
/*  1905 */     addObjectIds("PosTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1907 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  1910 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1912 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  1913 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  1914 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  1915 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  1916 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  1917 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  1918 */           return rels;
/*       */         }
/*       */       };
/*  1921 */     addRelationshipProducer("dtv.xst.dao.trn.impl.GiftRegistryTransactionDAO", relationshipProducer);
/*  1922 */     addDataModels("dtv.xst.dao.trn.impl.GiftRegistryTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1924 */             return (Class)GiftRegistryTransactionModel.class;
/*       */           }
/*       */         });
/*  1927 */     addInterfaces("dtv.xst.dao.trn.IGiftRegistryTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1929 */             return (Class)GiftRegistryTransactionModel.class;
/*       */           }
/*       */         });
/*  1932 */     addDaos("GiftRegistryTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1934 */             return (Class)GiftRegistryTransactionDAO.class;
/*       */           }
/*       */         });
/*  1937 */     addObjectIds("GiftRegistryTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1939 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  1942 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1944 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  1945 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", LineItemGenericStoragePropertyId.class, false, false, true);
/*  1946 */           return rels;
/*       */         }
/*       */       };
/*  1949 */     addRelationshipProducer("dtv.xst.dao.trn.impl.LineItemGenericStorageDAO", relationshipProducer);
/*  1950 */     addDataModels("dtv.xst.dao.trn.impl.LineItemGenericStorageDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1952 */             return (Class)LineItemGenericStorageModel.class;
/*       */           }
/*       */         });
/*  1955 */     addInterfaces("dtv.xst.dao.trn.ILineItemGenericStorage", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1957 */             return (Class)LineItemGenericStorageModel.class;
/*       */           }
/*       */         });
/*  1960 */     addDaos("LineItemGenericStorage", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1962 */             return (Class)LineItemGenericStorageDAO.class;
/*       */           }
/*       */         });
/*  1965 */     addObjectIds("LineItemGenericStorage", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1967 */             return (Class)LineItemGenericStorageId.class;
/*       */           }
/*       */         });
/*  1970 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  1972 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  1973 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  1974 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  1975 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  1976 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  1977 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  1978 */           return rels;
/*       */         }
/*       */       };
/*  1981 */     addRelationshipProducer("dtv.xst.dao.trn.impl.NoSaleTransactionDAO", relationshipProducer);
/*  1982 */     addDataModels("dtv.xst.dao.trn.impl.NoSaleTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  1984 */             return (Class)NoSaleTransactionModel.class;
/*       */           }
/*       */         });
/*  1987 */     addInterfaces("dtv.xst.dao.trn.INoSaleTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  1989 */             return (Class)NoSaleTransactionModel.class;
/*       */           }
/*       */         });
/*  1992 */     addDaos("NoSaleTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  1994 */             return (Class)NoSaleTransactionDAO.class;
/*       */           }
/*       */         });
/*  1997 */     addObjectIds("NoSaleTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  1999 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  2002 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2004 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2005 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosLogDataPropertyId.class, false, false, true);
/*  2006 */           return rels;
/*       */         }
/*       */       };
/*  2009 */     addRelationshipProducer("dtv.xst.dao.trn.impl.PosLogDataDAO", relationshipProducer);
/*  2010 */     addDataModels("dtv.xst.dao.trn.impl.PosLogDataDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2012 */             return (Class)PosLogDataModel.class;
/*       */           }
/*       */         });
/*  2015 */     addInterfaces("dtv.xst.dao.trn.IPosLogData", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2017 */             return (Class)PosLogDataModel.class;
/*       */           }
/*       */         });
/*  2020 */     addDaos("PosLogData", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2022 */             return (Class)PosLogDataDAO.class;
/*       */           }
/*       */         });
/*  2025 */     addObjectIds("PosLogData", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2027 */             return (Class)PosLogDataId.class;
/*       */           }
/*       */         });
/*  2030 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2032 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  2033 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("LinkedTransaction", PosTransactionId.class, false, false);
/*  2034 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionLinkPropertyId.class, false, false, true);
/*  2035 */           return rels;
/*       */         }
/*       */       };
/*  2038 */     addRelationshipProducer("dtv.xst.dao.trn.impl.PosTransactionLinkDAO", relationshipProducer);
/*  2039 */     addDataModels("dtv.xst.dao.trn.impl.PosTransactionLinkDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2041 */             return (Class)PosTransactionLinkModel.class;
/*       */           }
/*       */         });
/*  2044 */     addInterfaces("dtv.xst.dao.trn.IPosTransactionLink", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2046 */             return (Class)PosTransactionLinkModel.class;
/*       */           }
/*       */         });
/*  2049 */     addDaos("PosTransactionLink", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2051 */             return (Class)PosTransactionLinkDAO.class;
/*       */           }
/*       */         });
/*  2054 */     addObjectIds("PosTransactionLink", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2056 */             return (Class)PosTransactionLinkId.class;
/*       */           }
/*       */         });
/*  2059 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2061 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  2062 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  2063 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  2064 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  2065 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  2066 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  2067 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("VoidedTransaction", PosTransactionId.class, false, false);
/*  2068 */           return rels;
/*       */         }
/*       */       };
/*  2071 */     addRelationshipProducer("dtv.xst.dao.trn.impl.PostVoidTransactionDAO", relationshipProducer);
/*  2072 */     addDataModels("dtv.xst.dao.trn.impl.PostVoidTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2074 */             return (Class)PostVoidTransactionModel.class;
/*       */           }
/*       */         });
/*  2077 */     addInterfaces("dtv.xst.dao.trn.IPostVoidTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2079 */             return (Class)PostVoidTransactionModel.class;
/*       */           }
/*       */         });
/*  2082 */     addDaos("PostVoidTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2084 */             return (Class)PostVoidTransactionDAO.class;
/*       */           }
/*       */         });
/*  2087 */     addObjectIds("PostVoidTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2089 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  2092 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2094 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  2095 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, false);
/*  2096 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", RainCheckPropertyId.class, false, false, true);
/*  2097 */           return rels;
/*       */         }
/*       */       };
/*  2100 */     addRelationshipProducer("dtv.xst.dao.trn.impl.RainCheckDAO", relationshipProducer);
/*  2101 */     addDataModels("dtv.xst.dao.trn.impl.RainCheckDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2103 */             return (Class)RainCheckModel.class;
/*       */           }
/*       */         });
/*  2106 */     addInterfaces("dtv.xst.dao.trn.IRainCheck", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2108 */             return (Class)RainCheckModel.class;
/*       */           }
/*       */         });
/*  2111 */     addDaos("RainCheck", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2113 */             return (Class)RainCheckDAO.class;
/*       */           }
/*       */         });
/*  2116 */     addObjectIds("RainCheck", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2118 */             return (Class)RainCheckId.class;
/*       */           }
/*       */         });
/*  2121 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2123 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  2124 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  2125 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  2126 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  2127 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  2128 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  2129 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("RainCheck", RainCheckId.class, false, false);
/*  2130 */           return rels;
/*       */         }
/*       */       };
/*  2133 */     addRelationshipProducer("dtv.xst.dao.trn.impl.RainCheckTransactionDAO", relationshipProducer);
/*  2134 */     addDataModels("dtv.xst.dao.trn.impl.RainCheckTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2136 */             return (Class)RainCheckTransactionModel.class;
/*       */           }
/*       */         });
/*  2139 */     addInterfaces("dtv.xst.dao.trn.IRainCheckTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2141 */             return (Class)RainCheckTransactionModel.class;
/*       */           }
/*       */         });
/*  2144 */     addDaos("RainCheckTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2146 */             return (Class)RainCheckTransactionDAO.class;
/*       */           }
/*       */         });
/*  2149 */     addObjectIds("RainCheckTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2151 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  2154 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2156 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2157 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReceiptDataPropertyId.class, false, false, true);
/*  2158 */           return rels;
/*       */         }
/*       */       };
/*  2161 */     addRelationshipProducer("dtv.xst.dao.trn.impl.ReceiptDataDAO", relationshipProducer);
/*  2162 */     addDataModels("dtv.xst.dao.trn.impl.ReceiptDataDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2164 */             return (Class)ReceiptDataModel.class;
/*       */           }
/*       */         });
/*  2167 */     addInterfaces("dtv.xst.dao.trn.IReceiptData", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2169 */             return (Class)ReceiptDataModel.class;
/*       */           }
/*       */         });
/*  2172 */     addDaos("ReceiptData", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2174 */             return (Class)ReceiptDataDAO.class;
/*       */           }
/*       */         });
/*  2177 */     addObjectIds("ReceiptData", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2179 */             return (Class)ReceiptDataId.class;
/*       */           }
/*       */         });
/*  2182 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2184 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2185 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReceiptLookupPropertyId.class, false, false, true);
/*  2186 */           return rels;
/*       */         }
/*       */       };
/*  2189 */     addRelationshipProducer("dtv.xst.dao.trn.impl.ReceiptLookupDAO", relationshipProducer);
/*  2190 */     addDataModels("dtv.xst.dao.trn.impl.ReceiptLookupDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2192 */             return (Class)ReceiptLookupModel.class;
/*       */           }
/*       */         });
/*  2195 */     addInterfaces("dtv.xst.dao.trn.IReceiptLookup", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2197 */             return (Class)ReceiptLookupModel.class;
/*       */           }
/*       */         });
/*  2200 */     addDaos("ReceiptLookup", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2202 */             return (Class)ReceiptLookupDAO.class;
/*       */           }
/*       */         });
/*  2205 */     addObjectIds("ReceiptLookup", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2207 */             return (Class)ReceiptLookupId.class;
/*       */           }
/*       */         });
/*  2210 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2212 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2213 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TransactionNotesPropertyId.class, false, false, true);
/*  2214 */           return rels;
/*       */         }
/*       */       };
/*  2217 */     addRelationshipProducer("dtv.xst.dao.trn.impl.TransactionNotesDAO", relationshipProducer);
/*  2218 */     addDataModels("dtv.xst.dao.trn.impl.TransactionNotesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2220 */             return (Class)TransactionNotesModel.class;
/*       */           }
/*       */         });
/*  2223 */     addInterfaces("dtv.xst.dao.trn.ITransactionNotes", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2225 */             return (Class)TransactionNotesModel.class;
/*       */           }
/*       */         });
/*  2228 */     addDaos("TransactionNotes", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2230 */             return (Class)TransactionNotesDAO.class;
/*       */           }
/*       */         });
/*  2233 */     addObjectIds("TransactionNotes", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2235 */             return (Class)TransactionNotesId.class;
/*       */           }
/*       */         });
/*  2238 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2240 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2241 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TransactionVersionPropertyId.class, false, false, true);
/*  2242 */           return rels;
/*       */         }
/*       */       };
/*  2245 */     addRelationshipProducer("dtv.xst.dao.trn.impl.TransactionVersionDAO", relationshipProducer);
/*  2246 */     addDataModels("dtv.xst.dao.trn.impl.TransactionVersionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2248 */             return (Class)TransactionVersionModel.class;
/*       */           }
/*       */         });
/*  2251 */     addInterfaces("dtv.xst.dao.trn.ITransactionVersion", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2253 */             return (Class)TransactionVersionModel.class;
/*       */           }
/*       */         });
/*  2256 */     addDaos("TransactionVersion", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2258 */             return (Class)TransactionVersionDAO.class;
/*       */           }
/*       */         });
/*  2261 */     addObjectIds("TransactionVersion", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2263 */             return (Class)TransactionVersionId.class;
/*       */           }
/*       */         });
/*  2266 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2268 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2269 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2270 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2271 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2272 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2273 */           return rels;
/*       */         }
/*       */       };
/*  2276 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemDAO", relationshipProducer);
/*  2277 */     addDataModels("dtv.xst.dao.ttr.impl.CreditDebitTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2279 */             return (Class)CreditDebitTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2282 */     addInterfaces("dtv.xst.dao.ttr.ICreditDebitTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2284 */             return (Class)CreditDebitTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2287 */     addDaos("CreditDebitTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2289 */             return (Class)CreditDebitTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2292 */     addObjectIds("CreditDebitTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2294 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2297 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2299 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2300 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2301 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2302 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2303 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2304 */           return rels;
/*       */         }
/*       */       };
/*  2307 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.SendCheckTenderLineItemDAO", relationshipProducer);
/*  2308 */     addDataModels("dtv.xst.dao.ttr.impl.SendCheckTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2310 */             return (Class)SendCheckTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2313 */     addInterfaces("dtv.xst.dao.ttr.ISendCheckTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2315 */             return (Class)SendCheckTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2318 */     addDaos("SendCheckTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2320 */             return (Class)SendCheckTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2323 */     addObjectIds("SendCheckTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2325 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2328 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2330 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2331 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2332 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2333 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2334 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2335 */           return rels;
/*       */         }
/*       */       };
/*  2338 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.AccountCreditTenderLineItemDAO", relationshipProducer);
/*  2339 */     addDataModels("dtv.xst.dao.ttr.impl.AccountCreditTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2341 */             return (Class)AccountCreditTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2344 */     addInterfaces("dtv.xst.dao.ttr.IAccountCreditTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2346 */             return (Class)AccountCreditTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2349 */     addDaos("AccountCreditTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2351 */             return (Class)AccountCreditTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2354 */     addObjectIds("AccountCreditTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2356 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2359 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2361 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2362 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2363 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2364 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2365 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2366 */           return rels;
/*       */         }
/*       */       };
/*  2369 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.AccountReceivableTenderLineItemDAO", relationshipProducer);
/*  2370 */     addDataModels("dtv.xst.dao.ttr.impl.AccountReceivableTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2372 */             return (Class)AccountReceivableTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2375 */     addInterfaces("dtv.xst.dao.ttr.IAccountReceivableTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2377 */             return (Class)AccountReceivableTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2380 */     addDaos("AccountReceivableTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2382 */             return (Class)AccountReceivableTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2385 */     addObjectIds("AccountReceivableTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2387 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2390 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2392 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2393 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2394 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2395 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2396 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2397 */           return rels;
/*       */         }
/*       */       };
/*  2400 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.CheckTenderLineItemDAO", relationshipProducer);
/*  2401 */     addDataModels("dtv.xst.dao.ttr.impl.CheckTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2403 */             return (Class)CheckTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2406 */     addInterfaces("dtv.xst.dao.ttr.ICheckTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2408 */             return (Class)CheckTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2411 */     addDaos("CheckTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2413 */             return (Class)CheckTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2416 */     addObjectIds("CheckTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2418 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2421 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2423 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2424 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2425 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2426 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2427 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2428 */           return rels;
/*       */         }
/*       */       };
/*  2431 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.CouponTenderLineItemDAO", relationshipProducer);
/*  2432 */     addDataModels("dtv.xst.dao.ttr.impl.CouponTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2434 */             return (Class)CouponTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2437 */     addInterfaces("dtv.xst.dao.ttr.ICouponTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2439 */             return (Class)CouponTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2442 */     addDaos("CouponTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2444 */             return (Class)CouponTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2447 */     addObjectIds("CouponTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2449 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2452 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2454 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2455 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", IdentityVerificationPropertyId.class, false, false, true);
/*  2456 */           return rels;
/*       */         }
/*       */       };
/*  2459 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.IdentityVerificationDAO", relationshipProducer);
/*  2460 */     addDataModels("dtv.xst.dao.ttr.impl.IdentityVerificationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2462 */             return (Class)IdentityVerificationModel.class;
/*       */           }
/*       */         });
/*  2465 */     addInterfaces("dtv.xst.dao.ttr.IIdentityVerification", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2467 */             return (Class)IdentityVerificationModel.class;
/*       */           }
/*       */         });
/*  2470 */     addDaos("IdentityVerification", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2472 */             return (Class)IdentityVerificationDAO.class;
/*       */           }
/*       */         });
/*  2475 */     addObjectIds("IdentityVerification", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2477 */             return (Class)IdentityVerificationId.class;
/*       */           }
/*       */         });
/*  2480 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2482 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2483 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderAuthLogPropertyId.class, false, false, true);
/*  2484 */           return rels;
/*       */         }
/*       */       };
/*  2487 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.TenderAuthLogDAO", relationshipProducer);
/*  2488 */     addDataModels("dtv.xst.dao.ttr.impl.TenderAuthLogDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2490 */             return (Class)TenderAuthLogModel.class;
/*       */           }
/*       */         });
/*  2493 */     addInterfaces("dtv.xst.dao.ttr.ITenderAuthLog", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2495 */             return (Class)TenderAuthLogModel.class;
/*       */           }
/*       */         });
/*  2498 */     addDaos("TenderAuthLog", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2500 */             return (Class)TenderAuthLogDAO.class;
/*       */           }
/*       */         });
/*  2503 */     addObjectIds("TenderAuthLog", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2505 */             return (Class)TenderAuthLogId.class;
/*       */           }
/*       */         });
/*  2508 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2510 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  2511 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2512 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2513 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2514 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2515 */           return rels;
/*       */         }
/*       */       };
/*  2518 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.TenderLineItemDAO", relationshipProducer);
/*  2519 */     addDataModels("dtv.xst.dao.ttr.impl.TenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2521 */             return (Class)TenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2524 */     addInterfaces("dtv.xst.dao.ttr.ITenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2526 */             return (Class)TenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2529 */     addDaos("TenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2531 */             return (Class)TenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2534 */     addObjectIds("TenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2536 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2539 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2541 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2542 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderSignaturePropertyId.class, false, false, true);
/*  2543 */           return rels;
/*       */         }
/*       */       };
/*  2546 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.TenderSignatureDAO", relationshipProducer);
/*  2547 */     addDataModels("dtv.xst.dao.ttr.impl.TenderSignatureDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2549 */             return (Class)TenderSignatureModel.class;
/*       */           }
/*       */         });
/*  2552 */     addInterfaces("dtv.xst.dao.ttr.ITenderSignature", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2554 */             return (Class)TenderSignatureModel.class;
/*       */           }
/*       */         });
/*  2557 */     addDaos("TenderSignature", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2559 */             return (Class)TenderSignatureDAO.class;
/*       */           }
/*       */         });
/*  2562 */     addObjectIds("TenderSignature", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2564 */             return (Class)TenderSignatureId.class;
/*       */           }
/*       */         });
/*  2567 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2569 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2570 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", VoucherPropertyId.class, false, false, true);
/*  2571 */           return rels;
/*       */         }
/*       */       };
/*  2574 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.VoucherDAO", relationshipProducer);
/*  2575 */     addDataModels("dtv.xst.dao.ttr.impl.VoucherDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2577 */             return (Class)VoucherModel.class;
/*       */           }
/*       */         });
/*  2580 */     addInterfaces("dtv.xst.dao.ttr.IVoucher", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2582 */             return (Class)VoucherModel.class;
/*       */           }
/*       */         });
/*  2585 */     addDaos("Voucher", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2587 */             return (Class)VoucherDAO.class;
/*       */           }
/*       */         });
/*  2590 */     addObjectIds("Voucher", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2592 */             return (Class)VoucherId.class;
/*       */           }
/*       */         });
/*  2595 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2597 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2598 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", VoucherHistoryPropertyId.class, false, false, true);
/*  2599 */           return rels;
/*       */         }
/*       */       };
/*  2602 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.VoucherHistoryDAO", relationshipProducer);
/*  2603 */     addDataModels("dtv.xst.dao.ttr.impl.VoucherHistoryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2605 */             return (Class)VoucherHistoryModel.class;
/*       */           }
/*       */         });
/*  2608 */     addInterfaces("dtv.xst.dao.ttr.IVoucherHistory", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2610 */             return (Class)VoucherHistoryModel.class;
/*       */           }
/*       */         });
/*  2613 */     addDaos("VoucherHistory", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2615 */             return (Class)VoucherHistoryDAO.class;
/*       */           }
/*       */         });
/*  2618 */     addObjectIds("VoucherHistory", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2620 */             return (Class)VoucherHistoryId.class;
/*       */           }
/*       */         });
/*  2623 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2625 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  2626 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  2627 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  2628 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  2629 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("IdentityVerifications", IdentityVerificationId.class, false, false);
/*  2630 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("Voucher", VoucherId.class, false, false);
/*  2631 */           return rels;
/*       */         }
/*       */       };
/*  2634 */     addRelationshipProducer("dtv.xst.dao.ttr.impl.VoucherTenderLineItemDAO", relationshipProducer);
/*  2635 */     addDataModels("dtv.xst.dao.ttr.impl.VoucherTenderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2637 */             return (Class)VoucherTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2640 */     addInterfaces("dtv.xst.dao.ttr.IVoucherTenderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2642 */             return (Class)VoucherTenderLineItemModel.class;
/*       */           }
/*       */         });
/*  2645 */     addDaos("VoucherTenderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2647 */             return (Class)VoucherTenderLineItemDAO.class;
/*       */           }
/*       */         });
/*  2650 */     addObjectIds("VoucherTenderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2652 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  2655 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2657 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  2658 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Party", PartyId.class, true, false);
/*  2659 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("TenderRepository", TenderRepositoryId.class, false, false);
/*  2660 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("SessionTenders", SessionTenderId.class, false, false);
/*  2661 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("SessionWorkstations", SessionWorkstationId.class, false, false);
/*  2662 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", SessionPropertyId.class, false, false, true);
/*  2663 */           return rels;
/*       */         }
/*       */       };
/*  2666 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.SessionDAO", relationshipProducer);
/*  2667 */     addDataModels("dtv.xst.dao.tsn.impl.SessionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2669 */             return (Class)SessionModel.class;
/*       */           }
/*       */         });
/*  2672 */     addInterfaces("dtv.xst.dao.tsn.ISession", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2674 */             return (Class)SessionModel.class;
/*       */           }
/*       */         });
/*  2677 */     addDaos("Session", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2679 */             return (Class)SessionDAO.class;
/*       */           }
/*       */         });
/*  2682 */     addObjectIds("Session", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2684 */             return (Class)SessionId.class;
/*       */           }
/*       */         });
/*  2687 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2689 */           IDataModelRelationship[] rels = new IDataModelRelationship[12];
/*  2690 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  2691 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  2692 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  2693 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  2694 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  2695 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("FundsReceiptParty", PartyId.class, false, false);
/*  2696 */           rels[6] = (IDataModelRelationship)new OneToOneRelationship("InboundSession", SessionId.class, false, false);
/*  2697 */           rels[7] = (IDataModelRelationship)new OneToOneRelationship("InboundTenderRepository", TenderRepositoryId.class, false, false);
/*  2698 */           rels[8] = (IDataModelRelationship)new OneToOneRelationship("OutboundSession", SessionId.class, false, false);
/*  2699 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("OutboundTenderRepository", TenderRepositoryId.class, false, false);
/*  2700 */           rels[10] = (IDataModelRelationship)new OneToOneRelationship("ReasonCodeObject", ReasonCodeId.class, false, false);
/*  2701 */           rels[11] = (IDataModelRelationship)new OneToManyRelationship("TenderTypeCounts", TenderTypeCountId.class, false, false);
/*  2702 */           return rels;
/*       */         }
/*       */       };
/*  2705 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO", relationshipProducer);
/*  2706 */     addDataModels("dtv.xst.dao.tsn.impl.TenderControlTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2708 */             return (Class)TenderControlTransactionModel.class;
/*       */           }
/*       */         });
/*  2711 */     addInterfaces("dtv.xst.dao.tsn.ITenderControlTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2713 */             return (Class)TenderControlTransactionModel.class;
/*       */           }
/*       */         });
/*  2716 */     addDaos("TenderControlTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2718 */             return (Class)TenderControlTransactionDAO.class;
/*       */           }
/*       */         });
/*  2721 */     addObjectIds("TenderControlTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2723 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  2726 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2728 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  2729 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("TenderDenominationCounts", TenderDenominationCountId.class, false, false);
/*  2730 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderCountPropertyId.class, false, false, true);
/*  2731 */           return rels;
/*       */         }
/*       */       };
/*  2734 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderCountDAO", relationshipProducer);
/*  2735 */     addDataModels("dtv.xst.dao.tsn.impl.TenderCountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2737 */             return (Class)TenderCountModel.class;
/*       */           }
/*       */         });
/*  2740 */     addInterfaces("dtv.xst.dao.tsn.ITenderCount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2742 */             return (Class)TenderCountModel.class;
/*       */           }
/*       */         });
/*  2745 */     addDaos("TenderCount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2747 */             return (Class)TenderCountDAO.class;
/*       */           }
/*       */         });
/*  2750 */     addObjectIds("TenderCount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2752 */             return (Class)TenderCountId.class;
/*       */           }
/*       */         });
/*  2755 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2757 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2758 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ExchangeRateTransLineItemPropertyId.class, false, false, true);
/*  2759 */           return rels;
/*       */         }
/*       */       };
/*  2762 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.ExchangeRateTransLineItemDAO", relationshipProducer);
/*  2763 */     addDataModels("dtv.xst.dao.tsn.impl.ExchangeRateTransLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2765 */             return (Class)ExchangeRateTransLineItemModel.class;
/*       */           }
/*       */         });
/*  2768 */     addInterfaces("dtv.xst.dao.tsn.IExchangeRateTransLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2770 */             return (Class)ExchangeRateTransLineItemModel.class;
/*       */           }
/*       */         });
/*  2773 */     addDaos("ExchangeRateTransLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2775 */             return (Class)ExchangeRateTransLineItemDAO.class;
/*       */           }
/*       */         });
/*  2778 */     addObjectIds("ExchangeRateTransLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2780 */             return (Class)ExchangeRateTransLineItemId.class;
/*       */           }
/*       */         });
/*  2783 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2785 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  2786 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  2787 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  2788 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  2789 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  2790 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  2791 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("ExchangeRateTransLineItems", ExchangeRateTransLineItemId.class, false, false);
/*  2792 */           return rels;
/*       */         }
/*       */       };
/*  2795 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.ExchangeRateTransactionDAO", relationshipProducer);
/*  2796 */     addDataModels("dtv.xst.dao.tsn.impl.ExchangeRateTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2798 */             return (Class)ExchangeRateTransactionModel.class;
/*       */           }
/*       */         });
/*  2801 */     addInterfaces("dtv.xst.dao.tsn.IExchangeRateTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2803 */             return (Class)ExchangeRateTransactionModel.class;
/*       */           }
/*       */         });
/*  2806 */     addDaos("ExchangeRateTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2808 */             return (Class)ExchangeRateTransactionDAO.class;
/*       */           }
/*       */         });
/*  2811 */     addObjectIds("ExchangeRateTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2813 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  2816 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2818 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  2819 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  2820 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  2821 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  2822 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  2823 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  2824 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("Session", SessionId.class, false, false);
/*  2825 */           rels[6] = (IDataModelRelationship)new OneToOneRelationship("SessionWorkstation", SessionWorkstationId.class, false, false);
/*  2826 */           return rels;
/*       */         }
/*       */       };
/*  2829 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.SessionControlTransactionDAO", relationshipProducer);
/*  2830 */     addDataModels("dtv.xst.dao.tsn.impl.SessionControlTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2832 */             return (Class)SessionControlTransactionModel.class;
/*       */           }
/*       */         });
/*  2835 */     addInterfaces("dtv.xst.dao.tsn.ISessionControlTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2837 */             return (Class)SessionControlTransactionModel.class;
/*       */           }
/*       */         });
/*  2840 */     addDaos("SessionControlTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2842 */             return (Class)SessionControlTransactionDAO.class;
/*       */           }
/*       */         });
/*  2845 */     addObjectIds("SessionControlTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2847 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  2850 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2852 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2853 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SessionTenderPropertyId.class, false, false, true);
/*  2854 */           return rels;
/*       */         }
/*       */       };
/*  2857 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.SessionTenderDAO", relationshipProducer);
/*  2858 */     addDataModels("dtv.xst.dao.tsn.impl.SessionTenderDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2860 */             return (Class)SessionTenderModel.class;
/*       */           }
/*       */         });
/*  2863 */     addInterfaces("dtv.xst.dao.tsn.ISessionTender", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2865 */             return (Class)SessionTenderModel.class;
/*       */           }
/*       */         });
/*  2868 */     addDaos("SessionTender", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2870 */             return (Class)SessionTenderDAO.class;
/*       */           }
/*       */         });
/*  2873 */     addObjectIds("SessionTender", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2875 */             return (Class)SessionTenderId.class;
/*       */           }
/*       */         });
/*  2878 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2880 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2881 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SessionWorkstationPropertyId.class, false, false, true);
/*  2882 */           return rels;
/*       */         }
/*       */       };
/*  2885 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.SessionWorkstationDAO", relationshipProducer);
/*  2886 */     addDataModels("dtv.xst.dao.tsn.impl.SessionWorkstationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2888 */             return (Class)SessionWorkstationModel.class;
/*       */           }
/*       */         });
/*  2891 */     addInterfaces("dtv.xst.dao.tsn.ISessionWorkstation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2893 */             return (Class)SessionWorkstationModel.class;
/*       */           }
/*       */         });
/*  2896 */     addDaos("SessionWorkstation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2898 */             return (Class)SessionWorkstationDAO.class;
/*       */           }
/*       */         });
/*  2901 */     addObjectIds("SessionWorkstation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2903 */             return (Class)SessionWorkstationId.class;
/*       */           }
/*       */         });
/*  2906 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2908 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  2909 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("TenderDenomination", TenderDenominationId.class, false, false);
/*  2910 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderDenominationCountPropertyId.class, false, false, true);
/*  2911 */           return rels;
/*       */         }
/*       */       };
/*  2914 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderDenominationCountDAO", relationshipProducer);
/*  2915 */     addDataModels("dtv.xst.dao.tsn.impl.TenderDenominationCountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2917 */             return (Class)TenderDenominationCountModel.class;
/*       */           }
/*       */         });
/*  2920 */     addInterfaces("dtv.xst.dao.tsn.ITenderDenominationCount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2922 */             return (Class)TenderDenominationCountModel.class;
/*       */           }
/*       */         });
/*  2925 */     addDaos("TenderDenominationCount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2927 */             return (Class)TenderDenominationCountDAO.class;
/*       */           }
/*       */         });
/*  2930 */     addObjectIds("TenderDenominationCount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2932 */             return (Class)TenderDenominationCountId.class;
/*       */           }
/*       */         });
/*  2935 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2937 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  2938 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("TenderRepositoryFloat", TenderRepositoryFloatId.class, false, false);
/*  2939 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("TenderRepositoryStatus", TenderRepositoryStatusId.class, false, false);
/*  2940 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderRepositoryPropertyId.class, false, false, true);
/*  2941 */           return rels;
/*       */         }
/*       */       };
/*  2944 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderRepositoryDAO", relationshipProducer);
/*  2945 */     addDataModels("dtv.xst.dao.tsn.impl.TenderRepositoryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2947 */             return (Class)TenderRepositoryModel.class;
/*       */           }
/*       */         });
/*  2950 */     addInterfaces("dtv.xst.dao.tsn.ITenderRepository", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2952 */             return (Class)TenderRepositoryModel.class;
/*       */           }
/*       */         });
/*  2955 */     addDaos("TenderRepository", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2957 */             return (Class)TenderRepositoryDAO.class;
/*       */           }
/*       */         });
/*  2960 */     addObjectIds("TenderRepository", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2962 */             return (Class)TenderRepositoryId.class;
/*       */           }
/*       */         });
/*  2965 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2967 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2968 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderRepositoryFloatPropertyId.class, false, false, true);
/*  2969 */           return rels;
/*       */         }
/*       */       };
/*  2972 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderRepositoryFloatDAO", relationshipProducer);
/*  2973 */     addDataModels("dtv.xst.dao.tsn.impl.TenderRepositoryFloatDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  2975 */             return (Class)TenderRepositoryFloatModel.class;
/*       */           }
/*       */         });
/*  2978 */     addInterfaces("dtv.xst.dao.tsn.ITenderRepositoryFloat", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  2980 */             return (Class)TenderRepositoryFloatModel.class;
/*       */           }
/*       */         });
/*  2983 */     addDaos("TenderRepositoryFloat", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  2985 */             return (Class)TenderRepositoryFloatDAO.class;
/*       */           }
/*       */         });
/*  2988 */     addObjectIds("TenderRepositoryFloat", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  2990 */             return (Class)TenderRepositoryFloatId.class;
/*       */           }
/*       */         });
/*  2993 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  2995 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  2996 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderRepositoryStatusPropertyId.class, false, false, true);
/*  2997 */           return rels;
/*       */         }
/*       */       };
/*  3000 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderRepositoryStatusDAO", relationshipProducer);
/*  3001 */     addDataModels("dtv.xst.dao.tsn.impl.TenderRepositoryStatusDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3003 */             return (Class)TenderRepositoryStatusModel.class;
/*       */           }
/*       */         });
/*  3006 */     addInterfaces("dtv.xst.dao.tsn.ITenderRepositoryStatus", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3008 */             return (Class)TenderRepositoryStatusModel.class;
/*       */           }
/*       */         });
/*  3011 */     addDaos("TenderRepositoryStatus", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3013 */             return (Class)TenderRepositoryStatusDAO.class;
/*       */           }
/*       */         });
/*  3016 */     addObjectIds("TenderRepositoryStatus", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3018 */             return (Class)TenderRepositoryStatusId.class;
/*       */           }
/*       */         });
/*  3021 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  3023 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  3024 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Tender", TenderId.class, false, false);
/*  3025 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderSerializedCountPropertyId.class, false, false, true);
/*  3026 */           return rels;
/*       */         }
/*       */       };
/*  3029 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderSerializedCountDAO", relationshipProducer);
/*  3030 */     addDataModels("dtv.xst.dao.tsn.impl.TenderSerializedCountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3032 */             return (Class)TenderSerializedCountModel.class;
/*       */           }
/*       */         });
/*  3035 */     addInterfaces("dtv.xst.dao.tsn.ITenderSerializedCount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3037 */             return (Class)TenderSerializedCountModel.class;
/*       */           }
/*       */         });
/*  3040 */     addDaos("TenderSerializedCount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3042 */             return (Class)TenderSerializedCountDAO.class;
/*       */           }
/*       */         });
/*  3045 */     addObjectIds("TenderSerializedCount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3047 */             return (Class)TenderSerializedCountId.class;
/*       */           }
/*       */         });
/*  3050 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  3052 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  3053 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("TenderCounts", TenderCountId.class, false, false);
/*  3054 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("TenderSerializedCounts", TenderSerializedCountId.class, false, false);
/*  3055 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderTypeCountPropertyId.class, false, false, true);
/*  3056 */           return rels;
/*       */         }
/*       */       };
/*  3059 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TenderTypeCountDAO", relationshipProducer);
/*  3060 */     addDataModels("dtv.xst.dao.tsn.impl.TenderTypeCountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3062 */             return (Class)TenderTypeCountModel.class;
/*       */           }
/*       */         });
/*  3065 */     addInterfaces("dtv.xst.dao.tsn.ITenderTypeCount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3067 */             return (Class)TenderTypeCountModel.class;
/*       */           }
/*       */         });
/*  3070 */     addDaos("TenderTypeCount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3072 */             return (Class)TenderTypeCountDAO.class;
/*       */           }
/*       */         });
/*  3075 */     addObjectIds("TenderTypeCount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3077 */             return (Class)TenderTypeCountId.class;
/*       */           }
/*       */         });
/*  3080 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  3082 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  3083 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  3084 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  3085 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  3086 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  3087 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  3088 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("TillControlTransactionDetails", TillControlTransactionDetailId.class, false, false);
/*  3089 */           rels[6] = (IDataModelRelationship)new OneToOneRelationship("ReasonCodeObject", ReasonCodeId.class, false, false);
/*  3090 */           return rels;
/*       */         }
/*       */       };
/*  3093 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TillControlTransactionDAO", relationshipProducer);
/*  3094 */     addDataModels("dtv.xst.dao.tsn.impl.TillControlTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3096 */             return (Class)TillControlTransactionModel.class;
/*       */           }
/*       */         });
/*  3099 */     addInterfaces("dtv.xst.dao.tsn.ITillControlTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3101 */             return (Class)TillControlTransactionModel.class;
/*       */           }
/*       */         });
/*  3104 */     addDaos("TillControlTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3106 */             return (Class)TillControlTransactionDAO.class;
/*       */           }
/*       */         });
/*  3109 */     addObjectIds("TillControlTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3111 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  3114 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  3116 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  3117 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("AffectedTenderRepository", TenderRepositoryId.class, false, false);
/*  3118 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TillControlTransactionDetailPropertyId.class, false, false, true);
/*  3119 */           return rels;
/*       */         }
/*       */       };
/*  3122 */     addRelationshipProducer("dtv.xst.dao.tsn.impl.TillControlTransactionDetailDAO", relationshipProducer);
/*  3123 */     addDataModels("dtv.xst.dao.tsn.impl.TillControlTransactionDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3125 */             return (Class)TillControlTransactionDetailModel.class;
/*       */           }
/*       */         });
/*  3128 */     addInterfaces("dtv.xst.dao.tsn.ITillControlTransactionDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3130 */             return (Class)TillControlTransactionDetailModel.class;
/*       */           }
/*       */         });
/*  3133 */     addDaos("TillControlTransactionDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3135 */             return (Class)TillControlTransactionDetailDAO.class;
/*       */           }
/*       */         });
/*  3138 */     addObjectIds("TillControlTransactionDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3140 */             return (Class)TillControlTransactionDetailId.class;
/*       */           }
/*       */         });
/*  3143 */     addDataModels("dtv.xst.dao.trl.impl.SaleTaxModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3145 */             return (Class)SaleTaxModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3148 */     addInterfaces("dtv.xst.dao.trl.ISaleTaxModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3150 */             return (Class)SaleTaxModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3153 */     addDaos("SaleTaxModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3155 */             return (Class)SaleTaxModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3158 */     addObjectIds("SaleTaxModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3160 */             return (Class)SaleTaxModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3163 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionFlightInfoPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3165 */             return (Class)RetailTransactionFlightInfoPropertyModel.class;
/*       */           }
/*       */         });
/*  3168 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionFlightInfoProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3170 */             return (Class)RetailTransactionFlightInfoPropertyModel.class;
/*       */           }
/*       */         });
/*  3173 */     addDaos("RetailTransactionFlightInfoProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3175 */             return (Class)RetailTransactionFlightInfoPropertyDAO.class;
/*       */           }
/*       */         });
/*  3178 */     addObjectIds("RetailTransactionFlightInfoProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3180 */             return (Class)RetailTransactionFlightInfoPropertyId.class;
/*       */           }
/*       */         });
/*  3183 */     addDataModels("dtv.xst.dao.trl.impl.KitComponentModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3185 */             return (Class)KitComponentModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3188 */     addInterfaces("dtv.xst.dao.trl.IKitComponentModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3190 */             return (Class)KitComponentModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3193 */     addDaos("KitComponentModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3195 */             return (Class)KitComponentModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3198 */     addObjectIds("KitComponentModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3200 */             return (Class)KitComponentModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3203 */     addDataModels("dtv.xst.dao.trl.impl.WarrantyModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3205 */             return (Class)WarrantyModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3208 */     addInterfaces("dtv.xst.dao.trl.IWarrantyModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3210 */             return (Class)WarrantyModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3213 */     addDaos("WarrantyModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3215 */             return (Class)WarrantyModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3218 */     addObjectIds("WarrantyModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3220 */             return (Class)WarrantyModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3223 */     addDataModels("dtv.xst.dao.trl.impl.CommissionModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3225 */             return (Class)CommissionModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3228 */     addInterfaces("dtv.xst.dao.trl.ICommissionModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3230 */             return (Class)CommissionModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3233 */     addDaos("CommissionModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3235 */             return (Class)CommissionModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3238 */     addObjectIds("CommissionModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3240 */             return (Class)CommissionModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3243 */     addDataModels("dtv.xst.dao.trl.impl.CorrectionModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3245 */             return (Class)CorrectionModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3248 */     addInterfaces("dtv.xst.dao.trl.ICorrectionModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3250 */             return (Class)CorrectionModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3253 */     addDaos("CorrectionModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3255 */             return (Class)CorrectionModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3258 */     addObjectIds("CorrectionModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3260 */             return (Class)CorrectionModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3263 */     addDataModels("dtv.xst.dao.trl.impl.CustomerItemAccountModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3265 */             return (Class)CustomerItemAccountModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3268 */     addInterfaces("dtv.xst.dao.trl.ICustomerItemAccountModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3270 */             return (Class)CustomerItemAccountModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3273 */     addDaos("CustomerItemAccountModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3275 */             return (Class)CustomerItemAccountModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3278 */     addObjectIds("CustomerItemAccountModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3280 */             return (Class)CustomerItemAccountModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3283 */     addDataModels("dtv.xst.dao.trl.impl.DimensionModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3285 */             return (Class)DimensionModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3288 */     addInterfaces("dtv.xst.dao.trl.IDimensionModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3290 */             return (Class)DimensionModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3293 */     addDaos("DimensionModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3295 */             return (Class)DimensionModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3298 */     addObjectIds("DimensionModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3300 */             return (Class)DimensionModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3303 */     addDataModels("dtv.xst.dao.trl.impl.InventoryDocumentModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3305 */             return (Class)InventoryDocumentModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3308 */     addInterfaces("dtv.xst.dao.trl.IInventoryDocumentModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3310 */             return (Class)InventoryDocumentModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3313 */     addDaos("InventoryDocumentModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3315 */             return (Class)InventoryDocumentModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3318 */     addObjectIds("InventoryDocumentModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3320 */             return (Class)InventoryDocumentModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3323 */     addDataModels("dtv.xst.dao.trl.impl.LineItemAssociationModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3325 */             return (Class)LineItemAssociationModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3328 */     addInterfaces("dtv.xst.dao.trl.ILineItemAssociationModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3330 */             return (Class)LineItemAssociationModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3333 */     addDaos("LineItemAssociationModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3335 */             return (Class)LineItemAssociationModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3338 */     addObjectIds("LineItemAssociationModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3340 */             return (Class)LineItemAssociationModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3343 */     addDataModels("dtv.xst.dao.trl.impl.LineItemAssociationTypeCodePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3345 */             return (Class)LineItemAssociationTypeCodePropertyModel.class;
/*       */           }
/*       */         });
/*  3348 */     addInterfaces("dtv.xst.dao.trl.ILineItemAssociationTypeCodeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3350 */             return (Class)LineItemAssociationTypeCodePropertyModel.class;
/*       */           }
/*       */         });
/*  3353 */     addDaos("LineItemAssociationTypeCodeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3355 */             return (Class)LineItemAssociationTypeCodePropertyDAO.class;
/*       */           }
/*       */         });
/*  3358 */     addObjectIds("LineItemAssociationTypeCodeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3360 */             return (Class)LineItemAssociationTypeCodePropertyId.class;
/*       */           }
/*       */         });
/*  3363 */     addDataModels("dtv.xst.dao.trl.impl.RetailInventoryLocationModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3365 */             return (Class)RetailInventoryLocationModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3368 */     addInterfaces("dtv.xst.dao.trl.IRetailInventoryLocationModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3370 */             return (Class)RetailInventoryLocationModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3373 */     addDaos("RetailInventoryLocationModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3375 */             return (Class)RetailInventoryLocationModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3378 */     addObjectIds("RetailInventoryLocationModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3380 */             return (Class)RetailInventoryLocationModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3383 */     addDataModels("dtv.xst.dao.trl.impl.RetailPriceModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3385 */             return (Class)RetailPriceModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3388 */     addInterfaces("dtv.xst.dao.trl.IRetailPriceModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3390 */             return (Class)RetailPriceModifierPropertyModel.class;
/*       */           }
/*       */         });
/*  3393 */     addDaos("RetailPriceModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3395 */             return (Class)RetailPriceModifierPropertyDAO.class;
/*       */           }
/*       */         });
/*  3398 */     addObjectIds("RetailPriceModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3400 */             return (Class)RetailPriceModifierPropertyId.class;
/*       */           }
/*       */         });
/*  3403 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3405 */             return (Class)RetailTransactionLineItemPropertyModel.class;
/*       */           }
/*       */         });
/*  3408 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3410 */             return (Class)RetailTransactionLineItemPropertyModel.class;
/*       */           }
/*       */         });
/*  3413 */     addDaos("RetailTransactionLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3415 */             return (Class)RetailTransactionLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/*  3418 */     addObjectIds("RetailTransactionLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3420 */             return (Class)RetailTransactionLineItemPropertyId.class;
/*       */           }
/*       */         });
/*  3423 */     addDataModels("dtv.xst.dao.trl.impl.RetailTransactionLineItemNotesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3425 */             return (Class)RetailTransactionLineItemNotesPropertyModel.class;
/*       */           }
/*       */         });
/*  3428 */     addInterfaces("dtv.xst.dao.trl.IRetailTransactionLineItemNotesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3430 */             return (Class)RetailTransactionLineItemNotesPropertyModel.class;
/*       */           }
/*       */         });
/*  3433 */     addDaos("RetailTransactionLineItemNotesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3435 */             return (Class)RetailTransactionLineItemNotesPropertyDAO.class;
/*       */           }
/*       */         });
/*  3438 */     addObjectIds("RetailTransactionLineItemNotesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3440 */             return (Class)RetailTransactionLineItemNotesPropertyId.class;
/*       */           }
/*       */         });
/*  3443 */     addDataModels("dtv.xst.dao.trl.impl.ReturnedItemCountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3445 */             return (Class)ReturnedItemCountPropertyModel.class;
/*       */           }
/*       */         });
/*  3448 */     addInterfaces("dtv.xst.dao.trl.IReturnedItemCountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3450 */             return (Class)ReturnedItemCountPropertyModel.class;
/*       */           }
/*       */         });
/*  3453 */     addDaos("ReturnedItemCountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3455 */             return (Class)ReturnedItemCountPropertyDAO.class;
/*       */           }
/*       */         });
/*  3458 */     addObjectIds("ReturnedItemCountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3460 */             return (Class)ReturnedItemCountPropertyId.class;
/*       */           }
/*       */         });
/*  3463 */     addDataModels("dtv.xst.dao.trl.impl.ReturnedItemJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3465 */             return (Class)ReturnedItemJournalPropertyModel.class;
/*       */           }
/*       */         });
/*  3468 */     addInterfaces("dtv.xst.dao.trl.IReturnedItemJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3470 */             return (Class)ReturnedItemJournalPropertyModel.class;
/*       */           }
/*       */         });
/*  3473 */     addDaos("ReturnedItemJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3475 */             return (Class)ReturnedItemJournalPropertyDAO.class;
/*       */           }
/*       */         });
/*  3478 */     addObjectIds("ReturnedItemJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3480 */             return (Class)ReturnedItemJournalPropertyId.class;
/*       */           }
/*       */         });
/*  3483 */     addDataModels("dtv.xst.dao.itm.impl.KitComponentPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3485 */             return (Class)KitComponentPropertyModel.class;
/*       */           }
/*       */         });
/*  3488 */     addInterfaces("dtv.xst.dao.itm.IKitComponentProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3490 */             return (Class)KitComponentPropertyModel.class;
/*       */           }
/*       */         });
/*  3493 */     addDaos("KitComponentProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3495 */             return (Class)KitComponentPropertyDAO.class;
/*       */           }
/*       */         });
/*  3498 */     addObjectIds("KitComponentProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3500 */             return (Class)KitComponentPropertyId.class;
/*       */           }
/*       */         });
/*  3503 */     addDataModels("dtv.xst.dao.itm.impl.ItemOptionsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3505 */             return (Class)ItemOptionsPropertyModel.class;
/*       */           }
/*       */         });
/*  3508 */     addInterfaces("dtv.xst.dao.itm.IItemOptionsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3510 */             return (Class)ItemOptionsPropertyModel.class;
/*       */           }
/*       */         });
/*  3513 */     addDaos("ItemOptionsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3515 */             return (Class)ItemOptionsPropertyDAO.class;
/*       */           }
/*       */         });
/*  3518 */     addObjectIds("ItemOptionsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3520 */             return (Class)ItemOptionsPropertyId.class;
/*       */           }
/*       */         });
/*  3523 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictionCalendarPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3525 */             return (Class)ItemRestrictionCalendarPropertyModel.class;
/*       */           }
/*       */         });
/*  3528 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictionCalendarProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3530 */             return (Class)ItemRestrictionCalendarPropertyModel.class;
/*       */           }
/*       */         });
/*  3533 */     addDaos("ItemRestrictionCalendarProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3535 */             return (Class)ItemRestrictionCalendarPropertyDAO.class;
/*       */           }
/*       */         });
/*  3538 */     addObjectIds("ItemRestrictionCalendarProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3540 */             return (Class)ItemRestrictionCalendarPropertyId.class;
/*       */           }
/*       */         });
/*  3543 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3545 */             return (Class)ItemRestrictionPropertyModel.class;
/*       */           }
/*       */         });
/*  3548 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3550 */             return (Class)ItemRestrictionPropertyModel.class;
/*       */           }
/*       */         });
/*  3553 */     addDaos("ItemRestrictionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3555 */             return (Class)ItemRestrictionPropertyDAO.class;
/*       */           }
/*       */         });
/*  3558 */     addObjectIds("ItemRestrictionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3560 */             return (Class)ItemRestrictionPropertyId.class;
/*       */           }
/*       */         });
/*  3563 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictionMappingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3565 */             return (Class)ItemRestrictionMappingPropertyModel.class;
/*       */           }
/*       */         });
/*  3568 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictionMappingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3570 */             return (Class)ItemRestrictionMappingPropertyModel.class;
/*       */           }
/*       */         });
/*  3573 */     addDaos("ItemRestrictionMappingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3575 */             return (Class)ItemRestrictionMappingPropertyDAO.class;
/*       */           }
/*       */         });
/*  3578 */     addObjectIds("ItemRestrictionMappingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3580 */             return (Class)ItemRestrictionMappingPropertyId.class;
/*       */           }
/*       */         });
/*  3583 */     addDataModels("dtv.xst.dao.itm.impl.AttachedItemsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3585 */             return (Class)AttachedItemsPropertyModel.class;
/*       */           }
/*       */         });
/*  3588 */     addInterfaces("dtv.xst.dao.itm.IAttachedItemsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3590 */             return (Class)AttachedItemsPropertyModel.class;
/*       */           }
/*       */         });
/*  3593 */     addDaos("AttachedItemsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3595 */             return (Class)AttachedItemsPropertyDAO.class;
/*       */           }
/*       */         });
/*  3598 */     addObjectIds("AttachedItemsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3600 */             return (Class)AttachedItemsPropertyId.class;
/*       */           }
/*       */         });
/*  3603 */     addDataModels("dtv.xst.dao.itm.impl.ItemDimensionTypePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3605 */             return (Class)ItemDimensionTypePropertyModel.class;
/*       */           }
/*       */         });
/*  3608 */     addInterfaces("dtv.xst.dao.itm.IItemDimensionTypeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3610 */             return (Class)ItemDimensionTypePropertyModel.class;
/*       */           }
/*       */         });
/*  3613 */     addDaos("ItemDimensionTypeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3615 */             return (Class)ItemDimensionTypePropertyDAO.class;
/*       */           }
/*       */         });
/*  3618 */     addObjectIds("ItemDimensionTypeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3620 */             return (Class)ItemDimensionTypePropertyId.class;
/*       */           }
/*       */         });
/*  3623 */     addDataModels("dtv.xst.dao.itm.impl.ItemDimensionValuePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3625 */             return (Class)ItemDimensionValuePropertyModel.class;
/*       */           }
/*       */         });
/*  3628 */     addInterfaces("dtv.xst.dao.itm.IItemDimensionValueProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3630 */             return (Class)ItemDimensionValuePropertyModel.class;
/*       */           }
/*       */         });
/*  3633 */     addDaos("ItemDimensionValueProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3635 */             return (Class)ItemDimensionValuePropertyDAO.class;
/*       */           }
/*       */         });
/*  3638 */     addObjectIds("ItemDimensionValueProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3640 */             return (Class)ItemDimensionValuePropertyId.class;
/*       */           }
/*       */         });
/*  3643 */     addDataModels("dtv.xst.dao.itm.impl.ItemMessagePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3645 */             return (Class)ItemMessagePropertyModel.class;
/*       */           }
/*       */         });
/*  3648 */     addInterfaces("dtv.xst.dao.itm.IItemMessageProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3650 */             return (Class)ItemMessagePropertyModel.class;
/*       */           }
/*       */         });
/*  3653 */     addDaos("ItemMessageProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3655 */             return (Class)ItemMessagePropertyDAO.class;
/*       */           }
/*       */         });
/*  3658 */     addObjectIds("ItemMessageProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3660 */             return (Class)ItemMessagePropertyId.class;
/*       */           }
/*       */         });
/*  3663 */     addDataModels("dtv.xst.dao.itm.impl.MerchandiseHierarchyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3665 */             return (Class)MerchandiseHierarchyPropertyModel.class;
/*       */           }
/*       */         });
/*  3668 */     addInterfaces("dtv.xst.dao.itm.IMerchandiseHierarchyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3670 */             return (Class)MerchandiseHierarchyPropertyModel.class;
/*       */           }
/*       */         });
/*  3673 */     addDaos("MerchandiseHierarchyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3675 */             return (Class)MerchandiseHierarchyPropertyDAO.class;
/*       */           }
/*       */         });
/*  3678 */     addObjectIds("MerchandiseHierarchyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3680 */             return (Class)MerchandiseHierarchyPropertyId.class;
/*       */           }
/*       */         });
/*  3683 */     addDataModels("dtv.xst.dao.itm.impl.QuickItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3685 */             return (Class)QuickItemPropertyModel.class;
/*       */           }
/*       */         });
/*  3688 */     addInterfaces("dtv.xst.dao.itm.IQuickItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3690 */             return (Class)QuickItemPropertyModel.class;
/*       */           }
/*       */         });
/*  3693 */     addDaos("QuickItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3695 */             return (Class)QuickItemPropertyDAO.class;
/*       */           }
/*       */         });
/*  3698 */     addObjectIds("QuickItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3700 */             return (Class)QuickItemPropertyId.class;
/*       */           }
/*       */         });
/*  3703 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3705 */             return (Class)WarrantyPropertyModel.class;
/*       */           }
/*       */         });
/*  3708 */     addInterfaces("dtv.xst.dao.itm.IWarrantyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3710 */             return (Class)WarrantyPropertyModel.class;
/*       */           }
/*       */         });
/*  3713 */     addDaos("WarrantyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3715 */             return (Class)WarrantyPropertyDAO.class;
/*       */           }
/*       */         });
/*  3718 */     addObjectIds("WarrantyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3720 */             return (Class)WarrantyPropertyId.class;
/*       */           }
/*       */         });
/*  3723 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3725 */             return (Class)WarrantyJournalPropertyModel.class;
/*       */           }
/*       */         });
/*  3728 */     addInterfaces("dtv.xst.dao.itm.IWarrantyJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3730 */             return (Class)WarrantyJournalPropertyModel.class;
/*       */           }
/*       */         });
/*  3733 */     addDaos("WarrantyJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3735 */             return (Class)WarrantyJournalPropertyDAO.class;
/*       */           }
/*       */         });
/*  3738 */     addObjectIds("WarrantyJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3740 */             return (Class)WarrantyJournalPropertyId.class;
/*       */           }
/*       */         });
/*  3743 */     addDataModels("dtv.xst.dao.itm.impl.SubstituteItemsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3745 */             return (Class)SubstituteItemsPropertyModel.class;
/*       */           }
/*       */         });
/*  3748 */     addInterfaces("dtv.xst.dao.itm.ISubstituteItemsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3750 */             return (Class)SubstituteItemsPropertyModel.class;
/*       */           }
/*       */         });
/*  3753 */     addDaos("SubstituteItemsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3755 */             return (Class)SubstituteItemsPropertyDAO.class;
/*       */           }
/*       */         });
/*  3758 */     addObjectIds("SubstituteItemsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3760 */             return (Class)SubstituteItemsPropertyId.class;
/*       */           }
/*       */         });
/*  3763 */     addDataModels("dtv.xst.dao.itm.impl.ItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3765 */             return (Class)ItemPropertyModel.class;
/*       */           }
/*       */         });
/*  3768 */     addInterfaces("dtv.xst.dao.itm.IItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3770 */             return (Class)ItemPropertyModel.class;
/*       */           }
/*       */         });
/*  3773 */     addDaos("ItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3775 */             return (Class)ItemPropertyDAO.class;
/*       */           }
/*       */         });
/*  3778 */     addObjectIds("ItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3780 */             return (Class)ItemPropertyId.class;
/*       */           }
/*       */         });
/*  3783 */     addDataModels("dtv.xst.dao.itm.impl.VendorPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3785 */             return (Class)VendorPropertyModel.class;
/*       */           }
/*       */         });
/*  3788 */     addInterfaces("dtv.xst.dao.itm.IVendorProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3790 */             return (Class)VendorPropertyModel.class;
/*       */           }
/*       */         });
/*  3793 */     addDaos("VendorProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3795 */             return (Class)VendorPropertyDAO.class;
/*       */           }
/*       */         });
/*  3798 */     addObjectIds("VendorProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3800 */             return (Class)VendorPropertyId.class;
/*       */           }
/*       */         });
/*  3803 */     addDataModels("dtv.xst.dao.itm.impl.ItemCrossReferencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3805 */             return (Class)ItemCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/*  3808 */     addInterfaces("dtv.xst.dao.itm.IItemCrossReferenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3810 */             return (Class)ItemCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/*  3813 */     addDaos("ItemCrossReferenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3815 */             return (Class)ItemCrossReferencePropertyDAO.class;
/*       */           }
/*       */         });
/*  3818 */     addObjectIds("ItemCrossReferenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3820 */             return (Class)ItemCrossReferencePropertyId.class;
/*       */           }
/*       */         });
/*  3823 */     addDataModels("dtv.xst.dao.itm.impl.ItemDealPropertyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3825 */             return (Class)ItemDealPropertyPropertyModel.class;
/*       */           }
/*       */         });
/*  3828 */     addInterfaces("dtv.xst.dao.itm.IItemDealPropertyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3830 */             return (Class)ItemDealPropertyPropertyModel.class;
/*       */           }
/*       */         });
/*  3833 */     addDaos("ItemDealPropertyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3835 */             return (Class)ItemDealPropertyPropertyDAO.class;
/*       */           }
/*       */         });
/*  3838 */     addObjectIds("ItemDealPropertyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3840 */             return (Class)ItemDealPropertyPropertyId.class;
/*       */           }
/*       */         });
/*  3843 */     addDataModels("dtv.xst.dao.itm.impl.ItemMessageCrossReferencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3845 */             return (Class)ItemMessageCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/*  3848 */     addInterfaces("dtv.xst.dao.itm.IItemMessageCrossReferenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3850 */             return (Class)ItemMessageCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/*  3853 */     addDaos("ItemMessageCrossReferenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3855 */             return (Class)ItemMessageCrossReferencePropertyDAO.class;
/*       */           }
/*       */         });
/*  3858 */     addObjectIds("ItemMessageCrossReferenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3860 */             return (Class)ItemMessageCrossReferencePropertyId.class;
/*       */           }
/*       */         });
/*  3863 */     addDataModels("dtv.xst.dao.itm.impl.ItemMessageTypesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3865 */             return (Class)ItemMessageTypesPropertyModel.class;
/*       */           }
/*       */         });
/*  3868 */     addInterfaces("dtv.xst.dao.itm.IItemMessageTypesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3870 */             return (Class)ItemMessageTypesPropertyModel.class;
/*       */           }
/*       */         });
/*  3873 */     addDaos("ItemMessageTypesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3875 */             return (Class)ItemMessageTypesPropertyDAO.class;
/*       */           }
/*       */         });
/*  3878 */     addObjectIds("ItemMessageTypesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3880 */             return (Class)ItemMessageTypesPropertyId.class;
/*       */           }
/*       */         });
/*  3883 */     addDataModels("dtv.xst.dao.itm.impl.ItemPricesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3885 */             return (Class)ItemPricesPropertyModel.class;
/*       */           }
/*       */         });
/*  3888 */     addInterfaces("dtv.xst.dao.itm.IItemPricesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3890 */             return (Class)ItemPricesPropertyModel.class;
/*       */           }
/*       */         });
/*  3893 */     addDaos("ItemPricesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3895 */             return (Class)ItemPricesPropertyDAO.class;
/*       */           }
/*       */         });
/*  3898 */     addObjectIds("ItemPricesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3900 */             return (Class)ItemPricesPropertyId.class;
/*       */           }
/*       */         });
/*  3903 */     addDataModels("dtv.xst.dao.itm.impl.ItemPromptPropertyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3905 */             return (Class)ItemPromptPropertyPropertyModel.class;
/*       */           }
/*       */         });
/*  3908 */     addInterfaces("dtv.xst.dao.itm.IItemPromptPropertyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3910 */             return (Class)ItemPromptPropertyPropertyModel.class;
/*       */           }
/*       */         });
/*  3913 */     addDaos("ItemPromptPropertyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3915 */             return (Class)ItemPromptPropertyPropertyDAO.class;
/*       */           }
/*       */         });
/*  3918 */     addObjectIds("ItemPromptPropertyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3920 */             return (Class)ItemPromptPropertyPropertyId.class;
/*       */           }
/*       */         });
/*  3923 */     addDataModels("dtv.xst.dao.itm.impl.ItemRestrictGS1PropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3925 */             return (Class)ItemRestrictGS1PropertyModel.class;
/*       */           }
/*       */         });
/*  3928 */     addInterfaces("dtv.xst.dao.itm.IItemRestrictGS1Property", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3930 */             return (Class)ItemRestrictGS1PropertyModel.class;
/*       */           }
/*       */         });
/*  3933 */     addDaos("ItemRestrictGS1Property", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3935 */             return (Class)ItemRestrictGS1PropertyDAO.class;
/*       */           }
/*       */         });
/*  3938 */     addObjectIds("ItemRestrictGS1Property", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3940 */             return (Class)ItemRestrictGS1PropertyId.class;
/*       */           }
/*       */         });
/*  3943 */     addDataModels("dtv.xst.dao.itm.impl.RefundSchedulePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3945 */             return (Class)RefundSchedulePropertyModel.class;
/*       */           }
/*       */         });
/*  3948 */     addInterfaces("dtv.xst.dao.itm.IRefundScheduleProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3950 */             return (Class)RefundSchedulePropertyModel.class;
/*       */           }
/*       */         });
/*  3953 */     addDaos("RefundScheduleProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3955 */             return (Class)RefundSchedulePropertyDAO.class;
/*       */           }
/*       */         });
/*  3958 */     addObjectIds("RefundScheduleProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3960 */             return (Class)RefundSchedulePropertyId.class;
/*       */           }
/*       */         });
/*  3963 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyItemCrossReferencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3965 */             return (Class)WarrantyItemCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/*  3968 */     addInterfaces("dtv.xst.dao.itm.IWarrantyItemCrossReferenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3970 */             return (Class)WarrantyItemCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/*  3973 */     addDaos("WarrantyItemCrossReferenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3975 */             return (Class)WarrantyItemCrossReferencePropertyDAO.class;
/*       */           }
/*       */         });
/*  3978 */     addObjectIds("WarrantyItemCrossReferenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  3980 */             return (Class)WarrantyItemCrossReferencePropertyId.class;
/*       */           }
/*       */         });
/*  3983 */     addDataModels("dtv.xst.dao.itm.impl.WarrantyItemPricePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  3985 */             return (Class)WarrantyItemPricePropertyModel.class;
/*       */           }
/*       */         });
/*  3988 */     addInterfaces("dtv.xst.dao.itm.IWarrantyItemPriceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  3990 */             return (Class)WarrantyItemPricePropertyModel.class;
/*       */           }
/*       */         });
/*  3993 */     addDaos("WarrantyItemPriceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  3995 */             return (Class)WarrantyItemPricePropertyDAO.class;
/*       */           }
/*       */         });
/*  3998 */     addObjectIds("WarrantyItemPriceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4000 */             return (Class)WarrantyItemPricePropertyId.class;
/*       */           }
/*       */         });
/*  4003 */     addDataModels("dtv.xst.dao.itm.impl.ItemLabelBatchPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4005 */             return (Class)ItemLabelBatchPropertyModel.class;
/*       */           }
/*       */         });
/*  4008 */     addInterfaces("dtv.xst.dao.itm.IItemLabelBatchProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4010 */             return (Class)ItemLabelBatchPropertyModel.class;
/*       */           }
/*       */         });
/*  4013 */     addDaos("ItemLabelBatchProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4015 */             return (Class)ItemLabelBatchPropertyDAO.class;
/*       */           }
/*       */         });
/*  4018 */     addObjectIds("ItemLabelBatchProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4020 */             return (Class)ItemLabelBatchPropertyId.class;
/*       */           }
/*       */         });
/*  4023 */     addDataModels("dtv.xst.dao.itm.impl.ItemImagePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4025 */             return (Class)ItemImagePropertyModel.class;
/*       */           }
/*       */         });
/*  4028 */     addInterfaces("dtv.xst.dao.itm.IItemImageProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4030 */             return (Class)ItemImagePropertyModel.class;
/*       */           }
/*       */         });
/*  4033 */     addDaos("ItemImageProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4035 */             return (Class)ItemImagePropertyDAO.class;
/*       */           }
/*       */         });
/*  4038 */     addObjectIds("ItemImageProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4040 */             return (Class)ItemImagePropertyId.class;
/*       */           }
/*       */         });
/*  4043 */     addDataModels("dtv.xst.dao.itm.impl.ItemLabelPropertiesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4045 */             return (Class)ItemLabelPropertiesPropertyModel.class;
/*       */           }
/*       */         });
/*  4048 */     addInterfaces("dtv.xst.dao.itm.IItemLabelPropertiesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4050 */             return (Class)ItemLabelPropertiesPropertyModel.class;
/*       */           }
/*       */         });
/*  4053 */     addDaos("ItemLabelPropertiesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4055 */             return (Class)ItemLabelPropertiesPropertyDAO.class;
/*       */           }
/*       */         });
/*  4058 */     addObjectIds("ItemLabelPropertiesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4060 */             return (Class)ItemLabelPropertiesPropertyId.class;
/*       */           }
/*       */         });
/*  4063 */     addDataModels("dtv.xst.dao.itm.impl.MatrixSortOrderPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4065 */             return (Class)MatrixSortOrderPropertyModel.class;
/*       */           }
/*       */         });
/*  4068 */     addInterfaces("dtv.xst.dao.itm.IMatrixSortOrderProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4070 */             return (Class)MatrixSortOrderPropertyModel.class;
/*       */           }
/*       */         });
/*  4073 */     addDaos("MatrixSortOrderProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4075 */             return (Class)MatrixSortOrderPropertyDAO.class;
/*       */           }
/*       */         });
/*  4078 */     addObjectIds("MatrixSortOrderProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4080 */             return (Class)MatrixSortOrderPropertyId.class;
/*       */           }
/*       */         });
/*  4083 */     addDataModels("dtv.xst.dao.trn.impl.PosTransactionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4085 */             return (Class)PosTransactionPropertyModel.class;
/*       */           }
/*       */         });
/*  4088 */     addInterfaces("dtv.xst.dao.trn.IPosTransactionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4090 */             return (Class)PosTransactionPropertyModel.class;
/*       */           }
/*       */         });
/*  4093 */     addDaos("PosTransactionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4095 */             return (Class)PosTransactionPropertyDAO.class;
/*       */           }
/*       */         });
/*  4098 */     addObjectIds("PosTransactionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4100 */             return (Class)PosTransactionPropertyId.class;
/*       */           }
/*       */         });
/*  4103 */     addDataModels("dtv.xst.dao.trn.impl.LineItemGenericStoragePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4105 */             return (Class)LineItemGenericStoragePropertyModel.class;
/*       */           }
/*       */         });
/*  4108 */     addInterfaces("dtv.xst.dao.trn.ILineItemGenericStorageProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4110 */             return (Class)LineItemGenericStoragePropertyModel.class;
/*       */           }
/*       */         });
/*  4113 */     addDaos("LineItemGenericStorageProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4115 */             return (Class)LineItemGenericStoragePropertyDAO.class;
/*       */           }
/*       */         });
/*  4118 */     addObjectIds("LineItemGenericStorageProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4120 */             return (Class)LineItemGenericStoragePropertyId.class;
/*       */           }
/*       */         });
/*  4123 */     addDataModels("dtv.xst.dao.trn.impl.PosLogDataPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4125 */             return (Class)PosLogDataPropertyModel.class;
/*       */           }
/*       */         });
/*  4128 */     addInterfaces("dtv.xst.dao.trn.IPosLogDataProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4130 */             return (Class)PosLogDataPropertyModel.class;
/*       */           }
/*       */         });
/*  4133 */     addDaos("PosLogDataProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4135 */             return (Class)PosLogDataPropertyDAO.class;
/*       */           }
/*       */         });
/*  4138 */     addObjectIds("PosLogDataProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4140 */             return (Class)PosLogDataPropertyId.class;
/*       */           }
/*       */         });
/*  4143 */     addDataModels("dtv.xst.dao.trn.impl.PosTransactionLinkPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4145 */             return (Class)PosTransactionLinkPropertyModel.class;
/*       */           }
/*       */         });
/*  4148 */     addInterfaces("dtv.xst.dao.trn.IPosTransactionLinkProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4150 */             return (Class)PosTransactionLinkPropertyModel.class;
/*       */           }
/*       */         });
/*  4153 */     addDaos("PosTransactionLinkProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4155 */             return (Class)PosTransactionLinkPropertyDAO.class;
/*       */           }
/*       */         });
/*  4158 */     addObjectIds("PosTransactionLinkProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4160 */             return (Class)PosTransactionLinkPropertyId.class;
/*       */           }
/*       */         });
/*  4163 */     addDataModels("dtv.xst.dao.trn.impl.RainCheckPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4165 */             return (Class)RainCheckPropertyModel.class;
/*       */           }
/*       */         });
/*  4168 */     addInterfaces("dtv.xst.dao.trn.IRainCheckProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4170 */             return (Class)RainCheckPropertyModel.class;
/*       */           }
/*       */         });
/*  4173 */     addDaos("RainCheckProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4175 */             return (Class)RainCheckPropertyDAO.class;
/*       */           }
/*       */         });
/*  4178 */     addObjectIds("RainCheckProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4180 */             return (Class)RainCheckPropertyId.class;
/*       */           }
/*       */         });
/*  4183 */     addDataModels("dtv.xst.dao.trn.impl.ReceiptDataPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4185 */             return (Class)ReceiptDataPropertyModel.class;
/*       */           }
/*       */         });
/*  4188 */     addInterfaces("dtv.xst.dao.trn.IReceiptDataProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4190 */             return (Class)ReceiptDataPropertyModel.class;
/*       */           }
/*       */         });
/*  4193 */     addDaos("ReceiptDataProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4195 */             return (Class)ReceiptDataPropertyDAO.class;
/*       */           }
/*       */         });
/*  4198 */     addObjectIds("ReceiptDataProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4200 */             return (Class)ReceiptDataPropertyId.class;
/*       */           }
/*       */         });
/*  4203 */     addDataModels("dtv.xst.dao.trn.impl.ReceiptLookupPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4205 */             return (Class)ReceiptLookupPropertyModel.class;
/*       */           }
/*       */         });
/*  4208 */     addInterfaces("dtv.xst.dao.trn.IReceiptLookupProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4210 */             return (Class)ReceiptLookupPropertyModel.class;
/*       */           }
/*       */         });
/*  4213 */     addDaos("ReceiptLookupProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4215 */             return (Class)ReceiptLookupPropertyDAO.class;
/*       */           }
/*       */         });
/*  4218 */     addObjectIds("ReceiptLookupProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4220 */             return (Class)ReceiptLookupPropertyId.class;
/*       */           }
/*       */         });
/*  4223 */     addDataModels("dtv.xst.dao.trn.impl.TransactionNotesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4225 */             return (Class)TransactionNotesPropertyModel.class;
/*       */           }
/*       */         });
/*  4228 */     addInterfaces("dtv.xst.dao.trn.ITransactionNotesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4230 */             return (Class)TransactionNotesPropertyModel.class;
/*       */           }
/*       */         });
/*  4233 */     addDaos("TransactionNotesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4235 */             return (Class)TransactionNotesPropertyDAO.class;
/*       */           }
/*       */         });
/*  4238 */     addObjectIds("TransactionNotesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4240 */             return (Class)TransactionNotesPropertyId.class;
/*       */           }
/*       */         });
/*  4243 */     addDataModels("dtv.xst.dao.trn.impl.TransactionVersionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4245 */             return (Class)TransactionVersionPropertyModel.class;
/*       */           }
/*       */         });
/*  4248 */     addInterfaces("dtv.xst.dao.trn.ITransactionVersionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4250 */             return (Class)TransactionVersionPropertyModel.class;
/*       */           }
/*       */         });
/*  4253 */     addDaos("TransactionVersionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4255 */             return (Class)TransactionVersionPropertyDAO.class;
/*       */           }
/*       */         });
/*  4258 */     addObjectIds("TransactionVersionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4260 */             return (Class)TransactionVersionPropertyId.class;
/*       */           }
/*       */         });
/*  4263 */     addDataModels("dtv.xst.dao.ttr.impl.IdentityVerificationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4265 */             return (Class)IdentityVerificationPropertyModel.class;
/*       */           }
/*       */         });
/*  4268 */     addInterfaces("dtv.xst.dao.ttr.IIdentityVerificationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4270 */             return (Class)IdentityVerificationPropertyModel.class;
/*       */           }
/*       */         });
/*  4273 */     addDaos("IdentityVerificationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4275 */             return (Class)IdentityVerificationPropertyDAO.class;
/*       */           }
/*       */         });
/*  4278 */     addObjectIds("IdentityVerificationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4280 */             return (Class)IdentityVerificationPropertyId.class;
/*       */           }
/*       */         });
/*  4283 */     addDataModels("dtv.xst.dao.ttr.impl.TenderAuthLogPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4285 */             return (Class)TenderAuthLogPropertyModel.class;
/*       */           }
/*       */         });
/*  4288 */     addInterfaces("dtv.xst.dao.ttr.ITenderAuthLogProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4290 */             return (Class)TenderAuthLogPropertyModel.class;
/*       */           }
/*       */         });
/*  4293 */     addDaos("TenderAuthLogProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4295 */             return (Class)TenderAuthLogPropertyDAO.class;
/*       */           }
/*       */         });
/*  4298 */     addObjectIds("TenderAuthLogProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4300 */             return (Class)TenderAuthLogPropertyId.class;
/*       */           }
/*       */         });
/*  4303 */     addDataModels("dtv.xst.dao.ttr.impl.TenderSignaturePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4305 */             return (Class)TenderSignaturePropertyModel.class;
/*       */           }
/*       */         });
/*  4308 */     addInterfaces("dtv.xst.dao.ttr.ITenderSignatureProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4310 */             return (Class)TenderSignaturePropertyModel.class;
/*       */           }
/*       */         });
/*  4313 */     addDaos("TenderSignatureProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4315 */             return (Class)TenderSignaturePropertyDAO.class;
/*       */           }
/*       */         });
/*  4318 */     addObjectIds("TenderSignatureProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4320 */             return (Class)TenderSignaturePropertyId.class;
/*       */           }
/*       */         });
/*  4323 */     addDataModels("dtv.xst.dao.ttr.impl.VoucherPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4325 */             return (Class)VoucherPropertyModel.class;
/*       */           }
/*       */         });
/*  4328 */     addInterfaces("dtv.xst.dao.ttr.IVoucherProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4330 */             return (Class)VoucherPropertyModel.class;
/*       */           }
/*       */         });
/*  4333 */     addDaos("VoucherProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4335 */             return (Class)VoucherPropertyDAO.class;
/*       */           }
/*       */         });
/*  4338 */     addObjectIds("VoucherProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4340 */             return (Class)VoucherPropertyId.class;
/*       */           }
/*       */         });
/*  4343 */     addDataModels("dtv.xst.dao.ttr.impl.VoucherHistoryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4345 */             return (Class)VoucherHistoryPropertyModel.class;
/*       */           }
/*       */         });
/*  4348 */     addInterfaces("dtv.xst.dao.ttr.IVoucherHistoryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4350 */             return (Class)VoucherHistoryPropertyModel.class;
/*       */           }
/*       */         });
/*  4353 */     addDaos("VoucherHistoryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4355 */             return (Class)VoucherHistoryPropertyDAO.class;
/*       */           }
/*       */         });
/*  4358 */     addObjectIds("VoucherHistoryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4360 */             return (Class)VoucherHistoryPropertyId.class;
/*       */           }
/*       */         });
/*  4363 */     addDataModels("dtv.xst.dao.tsn.impl.SessionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4365 */             return (Class)SessionPropertyModel.class;
/*       */           }
/*       */         });
/*  4368 */     addInterfaces("dtv.xst.dao.tsn.ISessionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4370 */             return (Class)SessionPropertyModel.class;
/*       */           }
/*       */         });
/*  4373 */     addDaos("SessionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4375 */             return (Class)SessionPropertyDAO.class;
/*       */           }
/*       */         });
/*  4378 */     addObjectIds("SessionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4380 */             return (Class)SessionPropertyId.class;
/*       */           }
/*       */         });
/*  4383 */     addDataModels("dtv.xst.dao.tsn.impl.TenderCountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4385 */             return (Class)TenderCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4388 */     addInterfaces("dtv.xst.dao.tsn.ITenderCountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4390 */             return (Class)TenderCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4393 */     addDaos("TenderCountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4395 */             return (Class)TenderCountPropertyDAO.class;
/*       */           }
/*       */         });
/*  4398 */     addObjectIds("TenderCountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4400 */             return (Class)TenderCountPropertyId.class;
/*       */           }
/*       */         });
/*  4403 */     addDataModels("dtv.xst.dao.tsn.impl.ExchangeRateTransLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4405 */             return (Class)ExchangeRateTransLineItemPropertyModel.class;
/*       */           }
/*       */         });
/*  4408 */     addInterfaces("dtv.xst.dao.tsn.IExchangeRateTransLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4410 */             return (Class)ExchangeRateTransLineItemPropertyModel.class;
/*       */           }
/*       */         });
/*  4413 */     addDaos("ExchangeRateTransLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4415 */             return (Class)ExchangeRateTransLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/*  4418 */     addObjectIds("ExchangeRateTransLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4420 */             return (Class)ExchangeRateTransLineItemPropertyId.class;
/*       */           }
/*       */         });
/*  4423 */     addDataModels("dtv.xst.dao.tsn.impl.SessionTenderPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4425 */             return (Class)SessionTenderPropertyModel.class;
/*       */           }
/*       */         });
/*  4428 */     addInterfaces("dtv.xst.dao.tsn.ISessionTenderProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4430 */             return (Class)SessionTenderPropertyModel.class;
/*       */           }
/*       */         });
/*  4433 */     addDaos("SessionTenderProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4435 */             return (Class)SessionTenderPropertyDAO.class;
/*       */           }
/*       */         });
/*  4438 */     addObjectIds("SessionTenderProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4440 */             return (Class)SessionTenderPropertyId.class;
/*       */           }
/*       */         });
/*  4443 */     addDataModels("dtv.xst.dao.tsn.impl.SessionWorkstationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4445 */             return (Class)SessionWorkstationPropertyModel.class;
/*       */           }
/*       */         });
/*  4448 */     addInterfaces("dtv.xst.dao.tsn.ISessionWorkstationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4450 */             return (Class)SessionWorkstationPropertyModel.class;
/*       */           }
/*       */         });
/*  4453 */     addDaos("SessionWorkstationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4455 */             return (Class)SessionWorkstationPropertyDAO.class;
/*       */           }
/*       */         });
/*  4458 */     addObjectIds("SessionWorkstationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4460 */             return (Class)SessionWorkstationPropertyId.class;
/*       */           }
/*       */         });
/*  4463 */     addDataModels("dtv.xst.dao.tsn.impl.TenderDenominationCountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4465 */             return (Class)TenderDenominationCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4468 */     addInterfaces("dtv.xst.dao.tsn.ITenderDenominationCountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4470 */             return (Class)TenderDenominationCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4473 */     addDaos("TenderDenominationCountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4475 */             return (Class)TenderDenominationCountPropertyDAO.class;
/*       */           }
/*       */         });
/*  4478 */     addObjectIds("TenderDenominationCountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4480 */             return (Class)TenderDenominationCountPropertyId.class;
/*       */           }
/*       */         });
/*  4483 */     addDataModels("dtv.xst.dao.tsn.impl.TenderRepositoryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4485 */             return (Class)TenderRepositoryPropertyModel.class;
/*       */           }
/*       */         });
/*  4488 */     addInterfaces("dtv.xst.dao.tsn.ITenderRepositoryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4490 */             return (Class)TenderRepositoryPropertyModel.class;
/*       */           }
/*       */         });
/*  4493 */     addDaos("TenderRepositoryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4495 */             return (Class)TenderRepositoryPropertyDAO.class;
/*       */           }
/*       */         });
/*  4498 */     addObjectIds("TenderRepositoryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4500 */             return (Class)TenderRepositoryPropertyId.class;
/*       */           }
/*       */         });
/*  4503 */     addDataModels("dtv.xst.dao.tsn.impl.TenderRepositoryFloatPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4505 */             return (Class)TenderRepositoryFloatPropertyModel.class;
/*       */           }
/*       */         });
/*  4508 */     addInterfaces("dtv.xst.dao.tsn.ITenderRepositoryFloatProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4510 */             return (Class)TenderRepositoryFloatPropertyModel.class;
/*       */           }
/*       */         });
/*  4513 */     addDaos("TenderRepositoryFloatProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4515 */             return (Class)TenderRepositoryFloatPropertyDAO.class;
/*       */           }
/*       */         });
/*  4518 */     addObjectIds("TenderRepositoryFloatProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4520 */             return (Class)TenderRepositoryFloatPropertyId.class;
/*       */           }
/*       */         });
/*  4523 */     addDataModels("dtv.xst.dao.tsn.impl.TenderRepositoryStatusPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4525 */             return (Class)TenderRepositoryStatusPropertyModel.class;
/*       */           }
/*       */         });
/*  4528 */     addInterfaces("dtv.xst.dao.tsn.ITenderRepositoryStatusProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4530 */             return (Class)TenderRepositoryStatusPropertyModel.class;
/*       */           }
/*       */         });
/*  4533 */     addDaos("TenderRepositoryStatusProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4535 */             return (Class)TenderRepositoryStatusPropertyDAO.class;
/*       */           }
/*       */         });
/*  4538 */     addObjectIds("TenderRepositoryStatusProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4540 */             return (Class)TenderRepositoryStatusPropertyId.class;
/*       */           }
/*       */         });
/*  4543 */     addDataModels("dtv.xst.dao.tsn.impl.TenderSerializedCountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4545 */             return (Class)TenderSerializedCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4548 */     addInterfaces("dtv.xst.dao.tsn.ITenderSerializedCountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4550 */             return (Class)TenderSerializedCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4553 */     addDaos("TenderSerializedCountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4555 */             return (Class)TenderSerializedCountPropertyDAO.class;
/*       */           }
/*       */         });
/*  4558 */     addObjectIds("TenderSerializedCountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4560 */             return (Class)TenderSerializedCountPropertyId.class;
/*       */           }
/*       */         });
/*  4563 */     addDataModels("dtv.xst.dao.tsn.impl.TenderTypeCountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4565 */             return (Class)TenderTypeCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4568 */     addInterfaces("dtv.xst.dao.tsn.ITenderTypeCountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4570 */             return (Class)TenderTypeCountPropertyModel.class;
/*       */           }
/*       */         });
/*  4573 */     addDaos("TenderTypeCountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4575 */             return (Class)TenderTypeCountPropertyDAO.class;
/*       */           }
/*       */         });
/*  4578 */     addObjectIds("TenderTypeCountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4580 */             return (Class)TenderTypeCountPropertyId.class;
/*       */           }
/*       */         });
/*  4583 */     addDataModels("dtv.xst.dao.tsn.impl.TillControlTransactionDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4585 */             return (Class)TillControlTransactionDetailPropertyModel.class;
/*       */           }
/*       */         });
/*  4588 */     addInterfaces("dtv.xst.dao.tsn.ITillControlTransactionDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4590 */             return (Class)TillControlTransactionDetailPropertyModel.class;
/*       */           }
/*       */         });
/*  4593 */     addDaos("TillControlTransactionDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4595 */             return (Class)TillControlTransactionDetailPropertyDAO.class;
/*       */           }
/*       */         });
/*  4598 */     addObjectIds("TillControlTransactionDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4600 */             return (Class)TillControlTransactionDetailPropertyId.class;
/*       */           }
/*       */         });
/*  4603 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4605 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4606 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerConsentInfoPropertyId.class, false, false, true);
/*  4607 */           return rels;
/*       */         }
/*       */       };
/*  4610 */     addRelationshipProducer("dtv.xst.dao.crm.impl.CustomerConsentInfoDAO", relationshipProducer);
/*  4611 */     addDataModels("dtv.xst.dao.crm.impl.CustomerConsentInfoDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4613 */             return (Class)CustomerConsentInfoModel.class;
/*       */           }
/*       */         });
/*  4616 */     addInterfaces("dtv.xst.dao.crm.ICustomerConsentInfo", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4618 */             return (Class)CustomerConsentInfoModel.class;
/*       */           }
/*       */         });
/*  4621 */     addDaos("CustomerConsentInfo", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4623 */             return (Class)CustomerConsentInfoDAO.class;
/*       */           }
/*       */         });
/*  4626 */     addObjectIds("CustomerConsentInfo", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4628 */             return (Class)CustomerConsentInfoId.class;
/*       */           }
/*       */         });
/*  4631 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4633 */           IDataModelRelationship[] rels = new IDataModelRelationship[8];
/*  4634 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("AlternatePartyIds", PartyIdCrossReferenceId.class, false, false);
/*  4635 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("CustomerGroups", CustomerAffiliationId.class, false, false);
/*  4636 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("LocaleInformation", PartyLocaleInformationId.class, false, false);
/*  4637 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TelephoneInformation", PartyTelephoneId.class, false, false);
/*  4638 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("EmailInformation", PartyEmailId.class, false, false);
/*  4639 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("LoyaltyCards", CustomerLoyaltyCardId.class, false, false);
/*  4640 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("CustomerNotes", CustomerNoteId.class, false, false);
/*  4641 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("Properties", PartyPropertyId.class, false, false, true);
/*  4642 */           return rels;
/*       */         }
/*       */       };
/*  4645 */     addRelationshipProducer("dtv.xst.dao.crm.impl.PartyDAO", relationshipProducer);
/*  4646 */     addDataModels("dtv.xst.dao.crm.impl.PartyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4648 */             return (Class)PartyModel.class;
/*       */           }
/*       */         });
/*  4651 */     addInterfaces("dtv.xst.dao.crm.IParty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4653 */             return (Class)PartyModel.class;
/*       */           }
/*       */         });
/*  4656 */     addDaos("Party", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4658 */             return (Class)PartyDAO.class;
/*       */           }
/*       */         });
/*  4661 */     addObjectIds("Party", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4663 */             return (Class)PartyId.class;
/*       */           }
/*       */         });
/*  4666 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4668 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4669 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PartyLocaleInformationPropertyId.class, false, false, true);
/*  4670 */           return rels;
/*       */         }
/*       */       };
/*  4673 */     addRelationshipProducer("dtv.xst.dao.crm.impl.PartyLocaleInformationDAO", relationshipProducer);
/*  4674 */     addDataModels("dtv.xst.dao.crm.impl.PartyLocaleInformationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4676 */             return (Class)PartyLocaleInformationModel.class;
/*       */           }
/*       */         });
/*  4679 */     addInterfaces("dtv.xst.dao.crm.IPartyLocaleInformation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4681 */             return (Class)PartyLocaleInformationModel.class;
/*       */           }
/*       */         });
/*  4684 */     addDaos("PartyLocaleInformation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4686 */             return (Class)PartyLocaleInformationDAO.class;
/*       */           }
/*       */         });
/*  4689 */     addObjectIds("PartyLocaleInformation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4691 */             return (Class)PartyLocaleInformationId.class;
/*       */           }
/*       */         });
/*  4694 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4696 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4697 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAffiliationPropertyId.class, false, false, true);
/*  4698 */           return rels;
/*       */         }
/*       */       };
/*  4701 */     addRelationshipProducer("dtv.xst.dao.crm.impl.CustomerAffiliationDAO", relationshipProducer);
/*  4702 */     addDataModels("dtv.xst.dao.crm.impl.CustomerAffiliationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4704 */             return (Class)CustomerAffiliationModel.class;
/*       */           }
/*       */         });
/*  4707 */     addInterfaces("dtv.xst.dao.crm.ICustomerAffiliation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4709 */             return (Class)CustomerAffiliationModel.class;
/*       */           }
/*       */         });
/*  4712 */     addDaos("CustomerAffiliation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4714 */             return (Class)CustomerAffiliationDAO.class;
/*       */           }
/*       */         });
/*  4717 */     addObjectIds("CustomerAffiliation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4719 */             return (Class)CustomerAffiliationId.class;
/*       */           }
/*       */         });
/*  4722 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4724 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4725 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerNotePropertyId.class, false, false, true);
/*  4726 */           return rels;
/*       */         }
/*       */       };
/*  4729 */     addRelationshipProducer("dtv.xst.dao.crm.impl.CustomerNoteDAO", relationshipProducer);
/*  4730 */     addDataModels("dtv.xst.dao.crm.impl.CustomerNoteDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4732 */             return (Class)CustomerNoteModel.class;
/*       */           }
/*       */         });
/*  4735 */     addInterfaces("dtv.xst.dao.crm.ICustomerNote", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4737 */             return (Class)CustomerNoteModel.class;
/*       */           }
/*       */         });
/*  4740 */     addDaos("CustomerNote", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4742 */             return (Class)CustomerNoteDAO.class;
/*       */           }
/*       */         });
/*  4745 */     addObjectIds("CustomerNote", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4747 */             return (Class)CustomerNoteId.class;
/*       */           }
/*       */         });
/*  4750 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4752 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4753 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", GiftRegistryJournalPropertyId.class, false, false, true);
/*  4754 */           return rels;
/*       */         }
/*       */       };
/*  4757 */     addRelationshipProducer("dtv.xst.dao.crm.impl.GiftRegistryJournalDAO", relationshipProducer);
/*  4758 */     addDataModels("dtv.xst.dao.crm.impl.GiftRegistryJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4760 */             return (Class)GiftRegistryJournalModel.class;
/*       */           }
/*       */         });
/*  4763 */     addInterfaces("dtv.xst.dao.crm.IGiftRegistryJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4765 */             return (Class)GiftRegistryJournalModel.class;
/*       */           }
/*       */         });
/*  4768 */     addDaos("GiftRegistryJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4770 */             return (Class)GiftRegistryJournalDAO.class;
/*       */           }
/*       */         });
/*  4773 */     addObjectIds("GiftRegistryJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4775 */             return (Class)GiftRegistryJournalId.class;
/*       */           }
/*       */         });
/*  4778 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4780 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4781 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PartyCrossReferencePropertyId.class, false, false, true);
/*  4782 */           return rels;
/*       */         }
/*       */       };
/*  4785 */     addRelationshipProducer("dtv.xst.dao.crm.impl.PartyCrossReferenceDAO", relationshipProducer);
/*  4786 */     addDataModels("dtv.xst.dao.crm.impl.PartyCrossReferenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4788 */             return (Class)PartyCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  4791 */     addInterfaces("dtv.xst.dao.crm.IPartyCrossReference", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4793 */             return (Class)PartyCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  4796 */     addDaos("PartyCrossReference", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4798 */             return (Class)PartyCrossReferenceDAO.class;
/*       */           }
/*       */         });
/*  4801 */     addObjectIds("PartyCrossReference", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4803 */             return (Class)PartyCrossReferenceId.class;
/*       */           }
/*       */         });
/*  4806 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4808 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4809 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PartyEmailPropertyId.class, false, false, true);
/*  4810 */           return rels;
/*       */         }
/*       */       };
/*  4813 */     addRelationshipProducer("dtv.xst.dao.crm.impl.PartyEmailDAO", relationshipProducer);
/*  4814 */     addDataModels("dtv.xst.dao.crm.impl.PartyEmailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4816 */             return (Class)PartyEmailModel.class;
/*       */           }
/*       */         });
/*  4819 */     addInterfaces("dtv.xst.dao.crm.IPartyEmail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4821 */             return (Class)PartyEmailModel.class;
/*       */           }
/*       */         });
/*  4824 */     addDaos("PartyEmail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4826 */             return (Class)PartyEmailDAO.class;
/*       */           }
/*       */         });
/*  4829 */     addObjectIds("PartyEmail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4831 */             return (Class)PartyEmailId.class;
/*       */           }
/*       */         });
/*  4834 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4836 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4837 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PartyIdCrossReferencePropertyId.class, false, false, true);
/*  4838 */           return rels;
/*       */         }
/*       */       };
/*  4841 */     addRelationshipProducer("dtv.xst.dao.crm.impl.PartyIdCrossReferenceDAO", relationshipProducer);
/*  4842 */     addDataModels("dtv.xst.dao.crm.impl.PartyIdCrossReferenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4844 */             return (Class)PartyIdCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  4847 */     addInterfaces("dtv.xst.dao.crm.IPartyIdCrossReference", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4849 */             return (Class)PartyIdCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  4852 */     addDaos("PartyIdCrossReference", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4854 */             return (Class)PartyIdCrossReferenceDAO.class;
/*       */           }
/*       */         });
/*  4857 */     addObjectIds("PartyIdCrossReference", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4859 */             return (Class)PartyIdCrossReferenceId.class;
/*       */           }
/*       */         });
/*  4862 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4864 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4865 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PartyTelephonePropertyId.class, false, false, true);
/*  4866 */           return rels;
/*       */         }
/*       */       };
/*  4869 */     addRelationshipProducer("dtv.xst.dao.crm.impl.PartyTelephoneDAO", relationshipProducer);
/*  4870 */     addDataModels("dtv.xst.dao.crm.impl.PartyTelephoneDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4872 */             return (Class)PartyTelephoneModel.class;
/*       */           }
/*       */         });
/*  4875 */     addInterfaces("dtv.xst.dao.crm.IPartyTelephone", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4877 */             return (Class)PartyTelephoneModel.class;
/*       */           }
/*       */         });
/*  4880 */     addDaos("PartyTelephone", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4882 */             return (Class)PartyTelephoneDAO.class;
/*       */           }
/*       */         });
/*  4885 */     addObjectIds("PartyTelephone", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4887 */             return (Class)PartyTelephoneId.class;
/*       */           }
/*       */         });
/*  4890 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4892 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  4893 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Journals", CustomerAccountJournalId.class, false, false);
/*  4894 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("PaymentSchedule", PaymentScheduleId.class, false, false);
/*  4895 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("RetailLocation", RetailLocationId.class, false, false);
/*  4896 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("CustAccountNotes", CustomerAccountNoteId.class, false, false);
/*  4897 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountPropertyId.class, false, false, true);
/*  4898 */           return rels;
/*       */         }
/*       */       };
/*  4901 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerAccountDAO", relationshipProducer);
/*  4902 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4904 */             return (Class)CustomerAccountModel.class;
/*       */           }
/*       */         });
/*  4907 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4909 */             return (Class)CustomerAccountModel.class;
/*       */           }
/*       */         });
/*  4912 */     addDaos("CustomerAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4914 */             return (Class)CustomerAccountDAO.class;
/*       */           }
/*       */         });
/*  4917 */     addObjectIds("CustomerAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4919 */             return (Class)CustomerAccountId.class;
/*       */           }
/*       */         });
/*  4922 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4924 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  4925 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("AwardCoupons", AwardAccountCouponId.class, false, false);
/*  4926 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", AwardAccountPropertyId.class, false, false, true);
/*  4927 */           return rels;
/*       */         }
/*       */       };
/*  4930 */     addRelationshipProducer("dtv.xst.dao.cat.impl.AwardAccountDAO", relationshipProducer);
/*  4931 */     addDataModels("dtv.xst.dao.cat.impl.AwardAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4933 */             return (Class)AwardAccountModel.class;
/*       */           }
/*       */         });
/*  4936 */     addInterfaces("dtv.xst.dao.cat.IAwardAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4938 */             return (Class)AwardAccountModel.class;
/*       */           }
/*       */         });
/*  4941 */     addDaos("AwardAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4943 */             return (Class)AwardAccountDAO.class;
/*       */           }
/*       */         });
/*  4946 */     addObjectIds("AwardAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4948 */             return (Class)AwardAccountId.class;
/*       */           }
/*       */         });
/*  4951 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4953 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4954 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AwardAccountCouponPropertyId.class, false, false, true);
/*  4955 */           return rels;
/*       */         }
/*       */       };
/*  4958 */     addRelationshipProducer("dtv.xst.dao.cat.impl.AwardAccountCouponDAO", relationshipProducer);
/*  4959 */     addDataModels("dtv.xst.dao.cat.impl.AwardAccountCouponDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4961 */             return (Class)AwardAccountCouponModel.class;
/*       */           }
/*       */         });
/*  4964 */     addInterfaces("dtv.xst.dao.cat.IAwardAccountCoupon", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4966 */             return (Class)AwardAccountCouponModel.class;
/*       */           }
/*       */         });
/*  4969 */     addDaos("AwardAccountCoupon", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4971 */             return (Class)AwardAccountCouponDAO.class;
/*       */           }
/*       */         });
/*  4974 */     addObjectIds("AwardAccountCoupon", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  4976 */             return (Class)AwardAccountCouponId.class;
/*       */           }
/*       */         });
/*  4979 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  4981 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  4982 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ChargeAccountInvoicePropertyId.class, false, false, true);
/*  4983 */           return rels;
/*       */         }
/*       */       };
/*  4986 */     addRelationshipProducer("dtv.xst.dao.cat.impl.ChargeAccountInvoiceDAO", relationshipProducer);
/*  4987 */     addDataModels("dtv.xst.dao.cat.impl.ChargeAccountInvoiceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  4989 */             return (Class)ChargeAccountInvoiceModel.class;
/*       */           }
/*       */         });
/*  4992 */     addInterfaces("dtv.xst.dao.cat.IChargeAccountInvoice", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  4994 */             return (Class)ChargeAccountInvoiceModel.class;
/*       */           }
/*       */         });
/*  4997 */     addDaos("ChargeAccountInvoice", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  4999 */             return (Class)ChargeAccountInvoiceDAO.class;
/*       */           }
/*       */         });
/*  5002 */     addObjectIds("ChargeAccountInvoice", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5004 */             return (Class)ChargeAccountInvoiceId.class;
/*       */           }
/*       */         });
/*  5007 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5009 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5010 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ChargeAccountUserPropertyId.class, false, false, true);
/*  5011 */           return rels;
/*       */         }
/*       */       };
/*  5014 */     addRelationshipProducer("dtv.xst.dao.cat.impl.ChargeAccountUserDAO", relationshipProducer);
/*  5015 */     addDataModels("dtv.xst.dao.cat.impl.ChargeAccountUserDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5017 */             return (Class)ChargeAccountUserModel.class;
/*       */           }
/*       */         });
/*  5020 */     addInterfaces("dtv.xst.dao.cat.IChargeAccountUser", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5022 */             return (Class)ChargeAccountUserModel.class;
/*       */           }
/*       */         });
/*  5025 */     addDaos("ChargeAccountUser", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5027 */             return (Class)ChargeAccountUserDAO.class;
/*       */           }
/*       */         });
/*  5030 */     addObjectIds("ChargeAccountUser", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5032 */             return (Class)ChargeAccountUserId.class;
/*       */           }
/*       */         });
/*  5035 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5037 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5038 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountJournalPropertyId.class, false, false, true);
/*  5039 */           return rels;
/*       */         }
/*       */       };
/*  5042 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerAccountJournalDAO", relationshipProducer);
/*  5043 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5045 */             return (Class)CustomerAccountJournalModel.class;
/*       */           }
/*       */         });
/*  5048 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5050 */             return (Class)CustomerAccountJournalModel.class;
/*       */           }
/*       */         });
/*  5053 */     addDaos("CustomerAccountJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5055 */             return (Class)CustomerAccountJournalDAO.class;
/*       */           }
/*       */         });
/*  5058 */     addObjectIds("CustomerAccountJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5060 */             return (Class)CustomerAccountJournalId.class;
/*       */           }
/*       */         });
/*  5063 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5065 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5066 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerItemAccountActivityPropertyId.class, false, false, true);
/*  5067 */           return rels;
/*       */         }
/*       */       };
/*  5070 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerItemAccountActivityDAO", relationshipProducer);
/*  5071 */     addDataModels("dtv.xst.dao.cat.impl.CustomerItemAccountActivityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5073 */             return (Class)CustomerItemAccountActivityModel.class;
/*       */           }
/*       */         });
/*  5076 */     addInterfaces("dtv.xst.dao.cat.ICustomerItemAccountActivity", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5078 */             return (Class)CustomerItemAccountActivityModel.class;
/*       */           }
/*       */         });
/*  5081 */     addDaos("CustomerItemAccountActivity", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5083 */             return (Class)CustomerItemAccountActivityDAO.class;
/*       */           }
/*       */         });
/*  5086 */     addObjectIds("CustomerItemAccountActivity", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5088 */             return (Class)CustomerItemAccountActivityId.class;
/*       */           }
/*       */         });
/*  5091 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5093 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  5094 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("RetailLineItem", RetailTransactionLineItemId.class, true, false);
/*  5095 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("CustItemAccountActivities", CustomerItemAccountActivityId.class, false, false);
/*  5096 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("SourceLocation", RetailLocationId.class, false, false);
/*  5097 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("FullfillmentLocation", RetailLocationId.class, false, false);
/*  5098 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerItemAccountDetailPropertyId.class, false, false, true);
/*  5099 */           return rels;
/*       */         }
/*       */       };
/*  5102 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO", relationshipProducer);
/*  5103 */     addDataModels("dtv.xst.dao.cat.impl.CustomerItemAccountDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5105 */             return (Class)CustomerItemAccountDetailModel.class;
/*       */           }
/*       */         });
/*  5108 */     addInterfaces("dtv.xst.dao.cat.ICustomerItemAccountDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5110 */             return (Class)CustomerItemAccountDetailModel.class;
/*       */           }
/*       */         });
/*  5113 */     addDaos("CustomerItemAccountDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5115 */             return (Class)CustomerItemAccountDetailDAO.class;
/*       */           }
/*       */         });
/*  5118 */     addObjectIds("CustomerItemAccountDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5120 */             return (Class)CustomerItemAccountDetailId.class;
/*       */           }
/*       */         });
/*  5123 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5125 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5126 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountJournalPropertyId.class, false, false, true);
/*  5127 */           return rels;
/*       */         }
/*       */       };
/*  5130 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerItemAccountJournalDAO", relationshipProducer);
/*  5131 */     addDataModels("dtv.xst.dao.cat.impl.CustomerItemAccountJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5133 */             return (Class)CustomerItemAccountJournalModel.class;
/*       */           }
/*       */         });
/*  5136 */     addInterfaces("dtv.xst.dao.cat.ICustomerItemAccountJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5138 */             return (Class)CustomerItemAccountJournalModel.class;
/*       */           }
/*       */         });
/*  5141 */     addDaos("CustomerItemAccountJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5143 */             return (Class)CustomerItemAccountJournalDAO.class;
/*       */           }
/*       */         });
/*  5146 */     addObjectIds("CustomerItemAccountJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5148 */             return (Class)CustomerAccountJournalId.class;
/*       */           }
/*       */         });
/*  5151 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5153 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5154 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerLoyaltyAccountPropertyId.class, false, false, true);
/*  5155 */           return rels;
/*       */         }
/*       */       };
/*  5158 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerLoyaltyAccountDAO", relationshipProducer);
/*  5159 */     addDataModels("dtv.xst.dao.cat.impl.CustomerLoyaltyAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5161 */             return (Class)CustomerLoyaltyAccountModel.class;
/*       */           }
/*       */         });
/*  5164 */     addInterfaces("dtv.xst.dao.cat.ICustomerLoyaltyAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5166 */             return (Class)CustomerLoyaltyAccountModel.class;
/*       */           }
/*       */         });
/*  5169 */     addDaos("CustomerLoyaltyAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5171 */             return (Class)CustomerLoyaltyAccountDAO.class;
/*       */           }
/*       */         });
/*  5174 */     addObjectIds("CustomerLoyaltyAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5176 */             return (Class)CustomerLoyaltyAccountId.class;
/*       */           }
/*       */         });
/*  5179 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5181 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  5182 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("LoyaltyAccounts", CustomerLoyaltyAccountId.class, false, false);
/*  5183 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("AwardAccounts", AwardAccountId.class, false, false);
/*  5184 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerLoyaltyCardPropertyId.class, false, false, true);
/*  5185 */           return rels;
/*       */         }
/*       */       };
/*  5188 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerLoyaltyCardDAO", relationshipProducer);
/*  5189 */     addDataModels("dtv.xst.dao.cat.impl.CustomerLoyaltyCardDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5191 */             return (Class)CustomerLoyaltyCardModel.class;
/*       */           }
/*       */         });
/*  5194 */     addInterfaces("dtv.xst.dao.cat.ICustomerLoyaltyCard", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5196 */             return (Class)CustomerLoyaltyCardModel.class;
/*       */           }
/*       */         });
/*  5199 */     addDaos("CustomerLoyaltyCard", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5201 */             return (Class)CustomerLoyaltyCardDAO.class;
/*       */           }
/*       */         });
/*  5204 */     addObjectIds("CustomerLoyaltyCard", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5206 */             return (Class)CustomerLoyaltyCardId.class;
/*       */           }
/*       */         });
/*  5209 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5211 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5212 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DeliveryModifierPropertyId.class, false, false, true);
/*  5213 */           return rels;
/*       */         }
/*       */       };
/*  5216 */     addRelationshipProducer("dtv.xst.dao.cat.impl.DeliveryModifierDAO", relationshipProducer);
/*  5217 */     addDataModels("dtv.xst.dao.cat.impl.DeliveryModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5219 */             return (Class)DeliveryModifierModel.class;
/*       */           }
/*       */         });
/*  5222 */     addInterfaces("dtv.xst.dao.cat.IDeliveryModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5224 */             return (Class)DeliveryModifierModel.class;
/*       */           }
/*       */         });
/*  5227 */     addDaos("DeliveryModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5229 */             return (Class)DeliveryModifierDAO.class;
/*       */           }
/*       */         });
/*  5232 */     addObjectIds("DeliveryModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5234 */             return (Class)DeliveryModifierId.class;
/*       */           }
/*       */         });
/*  5237 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5239 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  5240 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("EscrowAccountActivities", EscrowAccountActivityId.class, false, false);
/*  5241 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", EscrowAccountPropertyId.class, false, false, true);
/*  5242 */           return rels;
/*       */         }
/*       */       };
/*  5245 */     addRelationshipProducer("dtv.xst.dao.cat.impl.EscrowAccountDAO", relationshipProducer);
/*  5246 */     addDataModels("dtv.xst.dao.cat.impl.EscrowAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5248 */             return (Class)EscrowAccountModel.class;
/*       */           }
/*       */         });
/*  5251 */     addInterfaces("dtv.xst.dao.cat.IEscrowAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5253 */             return (Class)EscrowAccountModel.class;
/*       */           }
/*       */         });
/*  5256 */     addDaos("EscrowAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5258 */             return (Class)EscrowAccountDAO.class;
/*       */           }
/*       */         });
/*  5261 */     addObjectIds("EscrowAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5263 */             return (Class)EscrowAccountId.class;
/*       */           }
/*       */         });
/*  5266 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5268 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5269 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ChargeAccountHistoryPropertyId.class, false, false, true);
/*  5270 */           return rels;
/*       */         }
/*       */       };
/*  5273 */     addRelationshipProducer("dtv.xst.dao.cat.impl.ChargeAccountHistoryDAO", relationshipProducer);
/*  5274 */     addDataModels("dtv.xst.dao.cat.impl.ChargeAccountHistoryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5276 */             return (Class)ChargeAccountHistoryModel.class;
/*       */           }
/*       */         });
/*  5279 */     addInterfaces("dtv.xst.dao.cat.IChargeAccountHistory", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5281 */             return (Class)ChargeAccountHistoryModel.class;
/*       */           }
/*       */         });
/*  5284 */     addDaos("ChargeAccountHistory", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5286 */             return (Class)ChargeAccountHistoryDAO.class;
/*       */           }
/*       */         });
/*  5289 */     addObjectIds("ChargeAccountHistory", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5291 */             return (Class)ChargeAccountHistoryId.class;
/*       */           }
/*       */         });
/*  5294 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5296 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5297 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountNotePropertyId.class, false, false, true);
/*  5298 */           return rels;
/*       */         }
/*       */       };
/*  5301 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerAccountNoteDAO", relationshipProducer);
/*  5302 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountNoteDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5304 */             return (Class)CustomerAccountNoteModel.class;
/*       */           }
/*       */         });
/*  5307 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountNote", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5309 */             return (Class)CustomerAccountNoteModel.class;
/*       */           }
/*       */         });
/*  5312 */     addDaos("CustomerAccountNote", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5314 */             return (Class)CustomerAccountNoteDAO.class;
/*       */           }
/*       */         });
/*  5317 */     addObjectIds("CustomerAccountNote", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5319 */             return (Class)CustomerAccountNoteId.class;
/*       */           }
/*       */         });
/*  5322 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5324 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5325 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountPlanPropertyId.class, false, false, true);
/*  5326 */           return rels;
/*       */         }
/*       */       };
/*  5329 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerAccountPlanDAO", relationshipProducer);
/*  5330 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountPlanDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5332 */             return (Class)CustomerAccountPlanModel.class;
/*       */           }
/*       */         });
/*  5335 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountPlan", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5337 */             return (Class)CustomerAccountPlanModel.class;
/*       */           }
/*       */         });
/*  5340 */     addDaos("CustomerAccountPlan", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5342 */             return (Class)CustomerAccountPlanDAO.class;
/*       */           }
/*       */         });
/*  5345 */     addObjectIds("CustomerAccountPlan", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5347 */             return (Class)CustomerAccountPlanId.class;
/*       */           }
/*       */         });
/*  5350 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5352 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  5353 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Journals", CustomerAccountJournalId.class, false, false);
/*  5354 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("PaymentSchedule", PaymentScheduleId.class, false, false);
/*  5355 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("RetailLocation", RetailLocationId.class, false, false);
/*  5356 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("CustAccountNotes", CustomerAccountNoteId.class, false, false);
/*  5357 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountPropertyId.class, false, false, true);
/*  5358 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("ChargeAccountUsers", ChargeAccountUserId.class, false, false);
/*  5359 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("ChargeAccountHistories", ChargeAccountHistoryId.class, false, false);
/*  5360 */           return rels;
/*       */         }
/*       */       };
/*  5363 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerConsumerChargeAccountDAO", relationshipProducer);
/*  5364 */     addDataModels("dtv.xst.dao.cat.impl.CustomerConsumerChargeAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5366 */             return (Class)CustomerConsumerChargeAccountModel.class;
/*       */           }
/*       */         });
/*  5369 */     addInterfaces("dtv.xst.dao.cat.ICustomerConsumerChargeAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5371 */             return (Class)CustomerConsumerChargeAccountModel.class;
/*       */           }
/*       */         });
/*  5374 */     addDaos("CustomerConsumerChargeAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5376 */             return (Class)CustomerConsumerChargeAccountDAO.class;
/*       */           }
/*       */         });
/*  5379 */     addObjectIds("CustomerConsumerChargeAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5381 */             return (Class)CustomerAccountId.class;
/*       */           }
/*       */         });
/*  5384 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5386 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  5387 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Journals", CustomerAccountJournalId.class, false, false);
/*  5388 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("PaymentSchedule", PaymentScheduleId.class, false, false);
/*  5389 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("RetailLocation", RetailLocationId.class, false, false);
/*  5390 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("CustAccountNotes", CustomerAccountNoteId.class, false, false);
/*  5391 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountPropertyId.class, false, false, true);
/*  5392 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("DeliveryModifier", DeliveryModifierId.class, false, false);
/*  5393 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("CustItemAccountDetails", CustomerItemAccountDetailId.class, false, false);
/*  5394 */           return rels;
/*       */         }
/*       */       };
/*  5397 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerItemAccountDAO", relationshipProducer);
/*  5398 */     addDataModels("dtv.xst.dao.cat.impl.CustomerItemAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5400 */             return (Class)CustomerItemAccountModel.class;
/*       */           }
/*       */         });
/*  5403 */     addInterfaces("dtv.xst.dao.cat.ICustomerItemAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5405 */             return (Class)CustomerItemAccountModel.class;
/*       */           }
/*       */         });
/*  5408 */     addDaos("CustomerItemAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5410 */             return (Class)CustomerItemAccountDAO.class;
/*       */           }
/*       */         });
/*  5413 */     addObjectIds("CustomerItemAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5415 */             return (Class)CustomerAccountId.class;
/*       */           }
/*       */         });
/*  5418 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5420 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5421 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EscrowAccountActivityPropertyId.class, false, false, true);
/*  5422 */           return rels;
/*       */         }
/*       */       };
/*  5425 */     addRelationshipProducer("dtv.xst.dao.cat.impl.EscrowAccountActivityDAO", relationshipProducer);
/*  5426 */     addDataModels("dtv.xst.dao.cat.impl.EscrowAccountActivityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5428 */             return (Class)EscrowAccountActivityModel.class;
/*       */           }
/*       */         });
/*  5431 */     addInterfaces("dtv.xst.dao.cat.IEscrowAccountActivity", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5433 */             return (Class)EscrowAccountActivityModel.class;
/*       */           }
/*       */         });
/*  5436 */     addDaos("EscrowAccountActivity", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5438 */             return (Class)EscrowAccountActivityDAO.class;
/*       */           }
/*       */         });
/*  5441 */     addObjectIds("EscrowAccountActivity", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5443 */             return (Class)EscrowAccountActivityId.class;
/*       */           }
/*       */         });
/*  5446 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5448 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5449 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PaymentSchedulePropertyId.class, false, false, true);
/*  5450 */           return rels;
/*       */         }
/*       */       };
/*  5453 */     addRelationshipProducer("dtv.xst.dao.cat.impl.PaymentScheduleDAO", relationshipProducer);
/*  5454 */     addDataModels("dtv.xst.dao.cat.impl.PaymentScheduleDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5456 */             return (Class)PaymentScheduleModel.class;
/*       */           }
/*       */         });
/*  5459 */     addInterfaces("dtv.xst.dao.cat.IPaymentSchedule", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5461 */             return (Class)PaymentScheduleModel.class;
/*       */           }
/*       */         });
/*  5464 */     addDaos("PaymentSchedule", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5466 */             return (Class)PaymentScheduleDAO.class;
/*       */           }
/*       */         });
/*  5469 */     addObjectIds("PaymentSchedule", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5471 */             return (Class)PaymentScheduleId.class;
/*       */           }
/*       */         });
/*  5474 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5476 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5477 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountAuthorizationPropertyId.class, false, false, true);
/*  5478 */           return rels;
/*       */         }
/*       */       };
/*  5481 */     addRelationshipProducer("dtv.xst.dao.cat.impl.CustomerAccountAuthorizationDAO", relationshipProducer);
/*  5482 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountAuthorizationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5484 */             return (Class)CustomerAccountAuthorizationModel.class;
/*       */           }
/*       */         });
/*  5487 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountAuthorization", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5489 */             return (Class)CustomerAccountAuthorizationModel.class;
/*       */           }
/*       */         });
/*  5492 */     addDaos("CustomerAccountAuthorization", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5494 */             return (Class)CustomerAccountAuthorizationDAO.class;
/*       */           }
/*       */         });
/*  5497 */     addObjectIds("CustomerAccountAuthorization", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5499 */             return (Class)CustomerAccountAuthorizationId.class;
/*       */           }
/*       */         });
/*  5502 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5504 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  5505 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("SourceModifier", SourceModifierId.class, true, false);
/*  5506 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("FulfillmentModifier", FulfillmentModifierId.class, true, false);
/*  5507 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("BalanceModifiers", BalanceModifierId.class, false, false);
/*  5508 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("CustomizationModifiers", CustomizationModifierId.class, false, false);
/*  5509 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Fees", FeeModifierId.class, false, false);
/*  5510 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemModifierId.class, true, false);
/*  5511 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrderLinePropertyId.class, false, false, true);
/*  5512 */           return rels;
/*       */         }
/*       */       };
/*  5515 */     addRelationshipProducer("dtv.xst.dao.xom.impl.OrderLineDAO", relationshipProducer);
/*  5516 */     addDataModels("dtv.xst.dao.xom.impl.OrderLineDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5518 */             return (Class)OrderLineModel.class;
/*       */           }
/*       */         });
/*  5521 */     addInterfaces("dtv.xst.dao.xom.IOrderLine", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5523 */             return (Class)OrderLineModel.class;
/*       */           }
/*       */         });
/*  5526 */     addDaos("OrderLine", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5528 */             return (Class)OrderLineDAO.class;
/*       */           }
/*       */         });
/*  5531 */     addObjectIds("OrderLine", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5533 */             return (Class)OrderLineId.class;
/*       */           }
/*       */         });
/*  5536 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5538 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  5539 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Customer", CustomerModifierId.class, false, false);
/*  5540 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Payments", OrderPaymentId.class, false, false);
/*  5541 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Fees", OrderFeeId.class, false, false);
/*  5542 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("OrderLines", OrderLineId.class, false, false);
/*  5543 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrderPropertyId.class, false, false, true);
/*  5544 */           return rels;
/*       */         }
/*       */       };
/*  5547 */     addRelationshipProducer("dtv.xst.dao.xom.impl.OrderDAO", relationshipProducer);
/*  5548 */     addDataModels("dtv.xst.dao.xom.impl.OrderDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5550 */             return (Class)OrderModel.class;
/*       */           }
/*       */         });
/*  5553 */     addInterfaces("dtv.xst.dao.xom.IOrder", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5555 */             return (Class)OrderModel.class;
/*       */           }
/*       */         });
/*  5558 */     addDaos("Order", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5560 */             return (Class)OrderDAO.class;
/*       */           }
/*       */         });
/*  5563 */     addObjectIds("Order", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5565 */             return (Class)OrderId.class;
/*       */           }
/*       */         });
/*  5568 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5570 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5571 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemModifierPropertyId.class, false, false, true);
/*  5572 */           return rels;
/*       */         }
/*       */       };
/*  5575 */     addRelationshipProducer("dtv.xst.dao.xom.impl.ItemModifierDAO", relationshipProducer);
/*  5576 */     addDataModels("dtv.xst.dao.xom.impl.ItemModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5578 */             return (Class)ItemModifierModel.class;
/*       */           }
/*       */         });
/*  5581 */     addInterfaces("dtv.xst.dao.xom.IItemModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5583 */             return (Class)ItemModifierModel.class;
/*       */           }
/*       */         });
/*  5586 */     addDaos("ItemModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5588 */             return (Class)ItemModifierDAO.class;
/*       */           }
/*       */         });
/*  5591 */     addObjectIds("ItemModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5593 */             return (Class)ItemModifierId.class;
/*       */           }
/*       */         });
/*  5596 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5598 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5599 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AddressModifierPropertyId.class, false, false, true);
/*  5600 */           return rels;
/*       */         }
/*       */       };
/*  5603 */     addRelationshipProducer("dtv.xst.dao.xom.impl.AddressModifierDAO", relationshipProducer);
/*  5604 */     addDataModels("dtv.xst.dao.xom.impl.AddressModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5606 */             return (Class)AddressModifierModel.class;
/*       */           }
/*       */         });
/*  5609 */     addInterfaces("dtv.xst.dao.xom.IAddressModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5611 */             return (Class)AddressModifierModel.class;
/*       */           }
/*       */         });
/*  5614 */     addDaos("AddressModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5616 */             return (Class)AddressModifierDAO.class;
/*       */           }
/*       */         });
/*  5619 */     addObjectIds("AddressModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5621 */             return (Class)AddressModifierId.class;
/*       */           }
/*       */         });
/*  5624 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5626 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5627 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", BalanceModifierPropertyId.class, false, false, true);
/*  5628 */           return rels;
/*       */         }
/*       */       };
/*  5631 */     addRelationshipProducer("dtv.xst.dao.xom.impl.BalanceModifierDAO", relationshipProducer);
/*  5632 */     addDataModels("dtv.xst.dao.xom.impl.BalanceModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5634 */             return (Class)BalanceModifierModel.class;
/*       */           }
/*       */         });
/*  5637 */     addInterfaces("dtv.xst.dao.xom.IBalanceModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5639 */             return (Class)BalanceModifierModel.class;
/*       */           }
/*       */         });
/*  5642 */     addDaos("BalanceModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5644 */             return (Class)BalanceModifierDAO.class;
/*       */           }
/*       */         });
/*  5647 */     addObjectIds("BalanceModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5649 */             return (Class)BalanceModifierId.class;
/*       */           }
/*       */         });
/*  5652 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5654 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  5655 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Address", AddressModifierId.class, false, false);
/*  5656 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerModifierPropertyId.class, false, false, true);
/*  5657 */           return rels;
/*       */         }
/*       */       };
/*  5660 */     addRelationshipProducer("dtv.xst.dao.xom.impl.CustomerModifierDAO", relationshipProducer);
/*  5661 */     addDataModels("dtv.xst.dao.xom.impl.CustomerModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5663 */             return (Class)CustomerModifierModel.class;
/*       */           }
/*       */         });
/*  5666 */     addInterfaces("dtv.xst.dao.xom.ICustomerModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5668 */             return (Class)CustomerModifierModel.class;
/*       */           }
/*       */         });
/*  5671 */     addDaos("CustomerModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5673 */             return (Class)CustomerModifierDAO.class;
/*       */           }
/*       */         });
/*  5676 */     addObjectIds("CustomerModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5678 */             return (Class)CustomerModifierId.class;
/*       */           }
/*       */         });
/*  5681 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5683 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5684 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomizationModifierPropertyId.class, false, false, true);
/*  5685 */           return rels;
/*       */         }
/*       */       };
/*  5688 */     addRelationshipProducer("dtv.xst.dao.xom.impl.CustomizationModifierDAO", relationshipProducer);
/*  5689 */     addDataModels("dtv.xst.dao.xom.impl.CustomizationModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5691 */             return (Class)CustomizationModifierModel.class;
/*       */           }
/*       */         });
/*  5694 */     addInterfaces("dtv.xst.dao.xom.ICustomizationModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5696 */             return (Class)CustomizationModifierModel.class;
/*       */           }
/*       */         });
/*  5699 */     addDaos("CustomizationModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5701 */             return (Class)CustomizationModifierDAO.class;
/*       */           }
/*       */         });
/*  5704 */     addObjectIds("CustomizationModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5706 */             return (Class)CustomizationModifierId.class;
/*       */           }
/*       */         });
/*  5709 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5711 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5712 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", FeeModifierPropertyId.class, false, false, true);
/*  5713 */           return rels;
/*       */         }
/*       */       };
/*  5716 */     addRelationshipProducer("dtv.xst.dao.xom.impl.FeeModifierDAO", relationshipProducer);
/*  5717 */     addDataModels("dtv.xst.dao.xom.impl.FeeModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5719 */             return (Class)FeeModifierModel.class;
/*       */           }
/*       */         });
/*  5722 */     addInterfaces("dtv.xst.dao.xom.IFeeModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5724 */             return (Class)FeeModifierModel.class;
/*       */           }
/*       */         });
/*  5727 */     addDaos("FeeModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5729 */             return (Class)FeeModifierDAO.class;
/*       */           }
/*       */         });
/*  5732 */     addObjectIds("FeeModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5734 */             return (Class)FeeModifierId.class;
/*       */           }
/*       */         });
/*  5737 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5739 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  5740 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Address", AddressModifierId.class, false, false);
/*  5741 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", FulfillmentModifierPropertyId.class, false, false, true);
/*  5742 */           return rels;
/*       */         }
/*       */       };
/*  5745 */     addRelationshipProducer("dtv.xst.dao.xom.impl.FulfillmentModifierDAO", relationshipProducer);
/*  5746 */     addDataModels("dtv.xst.dao.xom.impl.FulfillmentModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5748 */             return (Class)FulfillmentModifierModel.class;
/*       */           }
/*       */         });
/*  5751 */     addInterfaces("dtv.xst.dao.xom.IFulfillmentModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5753 */             return (Class)FulfillmentModifierModel.class;
/*       */           }
/*       */         });
/*  5756 */     addDaos("FulfillmentModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5758 */             return (Class)FulfillmentModifierDAO.class;
/*       */           }
/*       */         });
/*  5761 */     addObjectIds("FulfillmentModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5763 */             return (Class)FulfillmentModifierId.class;
/*       */           }
/*       */         });
/*  5766 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5768 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5769 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrderFeePropertyId.class, false, false, true);
/*  5770 */           return rels;
/*       */         }
/*       */       };
/*  5773 */     addRelationshipProducer("dtv.xst.dao.xom.impl.OrderFeeDAO", relationshipProducer);
/*  5774 */     addDataModels("dtv.xst.dao.xom.impl.OrderFeeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5776 */             return (Class)OrderFeeModel.class;
/*       */           }
/*       */         });
/*  5779 */     addInterfaces("dtv.xst.dao.xom.IOrderFee", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5781 */             return (Class)OrderFeeModel.class;
/*       */           }
/*       */         });
/*  5784 */     addDaos("OrderFee", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5786 */             return (Class)OrderFeeDAO.class;
/*       */           }
/*       */         });
/*  5789 */     addObjectIds("OrderFee", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5791 */             return (Class)OrderFeeId.class;
/*       */           }
/*       */         });
/*  5794 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5796 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5797 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrderModifierPropertyId.class, false, false, true);
/*  5798 */           return rels;
/*       */         }
/*       */       };
/*  5801 */     addRelationshipProducer("dtv.xst.dao.xom.impl.OrderModifierDAO", relationshipProducer);
/*  5802 */     addDataModels("dtv.xst.dao.xom.impl.OrderModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5804 */             return (Class)OrderModifierModel.class;
/*       */           }
/*       */         });
/*  5807 */     addInterfaces("dtv.xst.dao.xom.IOrderModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5809 */             return (Class)OrderModifierModel.class;
/*       */           }
/*       */         });
/*  5812 */     addDaos("OrderModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5814 */             return (Class)OrderModifierDAO.class;
/*       */           }
/*       */         });
/*  5817 */     addObjectIds("OrderModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5819 */             return (Class)OrderModifierId.class;
/*       */           }
/*       */         });
/*  5822 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5824 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5825 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrderPaymentPropertyId.class, false, false, true);
/*  5826 */           return rels;
/*       */         }
/*       */       };
/*  5829 */     addRelationshipProducer("dtv.xst.dao.xom.impl.OrderPaymentDAO", relationshipProducer);
/*  5830 */     addDataModels("dtv.xst.dao.xom.impl.OrderPaymentDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5832 */             return (Class)OrderPaymentModel.class;
/*       */           }
/*       */         });
/*  5835 */     addInterfaces("dtv.xst.dao.xom.IOrderPayment", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5837 */             return (Class)OrderPaymentModel.class;
/*       */           }
/*       */         });
/*  5840 */     addDaos("OrderPayment", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5842 */             return (Class)OrderPaymentDAO.class;
/*       */           }
/*       */         });
/*  5845 */     addObjectIds("OrderPayment", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5847 */             return (Class)OrderPaymentId.class;
/*       */           }
/*       */         });
/*  5850 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5852 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  5853 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Address", AddressModifierId.class, false, false);
/*  5854 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", SourceModifierPropertyId.class, false, false, true);
/*  5855 */           return rels;
/*       */         }
/*       */       };
/*  5858 */     addRelationshipProducer("dtv.xst.dao.xom.impl.SourceModifierDAO", relationshipProducer);
/*  5859 */     addDataModels("dtv.xst.dao.xom.impl.SourceModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5861 */             return (Class)SourceModifierModel.class;
/*       */           }
/*       */         });
/*  5864 */     addInterfaces("dtv.xst.dao.xom.ISourceModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5866 */             return (Class)SourceModifierModel.class;
/*       */           }
/*       */         });
/*  5869 */     addDaos("SourceModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5871 */             return (Class)SourceModifierDAO.class;
/*       */           }
/*       */         });
/*  5874 */     addObjectIds("SourceModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5876 */             return (Class)SourceModifierId.class;
/*       */           }
/*       */         });
/*  5879 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5881 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  5882 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Items", DealItemActionId.class, false, false);
/*  5883 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("CustomerGroups", DealCustomerGroupsId.class, false, false);
/*  5884 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Triggers", DealTriggerId.class, false, false);
/*  5885 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealPropertyId.class, false, false, true);
/*  5886 */           return rels;
/*       */         }
/*       */       };
/*  5889 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealDAO", relationshipProducer);
/*  5890 */     addDataModels("dtv.xst.dao.prc.impl.DealDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5892 */             return (Class)DealModel.class;
/*       */           }
/*       */         });
/*  5895 */     addInterfaces("dtv.xst.dao.prc.IDeal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5897 */             return (Class)DealModel.class;
/*       */           }
/*       */         });
/*  5900 */     addDaos("Deal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5902 */             return (Class)DealDAO.class;
/*       */           }
/*       */         });
/*  5905 */     addObjectIds("Deal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5907 */             return (Class)DealId.class;
/*       */           }
/*       */         });
/*  5910 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5912 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5913 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealCustomerGroupsPropertyId.class, false, false, true);
/*  5914 */           return rels;
/*       */         }
/*       */       };
/*  5917 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealCustomerGroupsDAO", relationshipProducer);
/*  5918 */     addDataModels("dtv.xst.dao.prc.impl.DealCustomerGroupsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5920 */             return (Class)DealCustomerGroupsModel.class;
/*       */           }
/*       */         });
/*  5923 */     addInterfaces("dtv.xst.dao.prc.IDealCustomerGroups", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5925 */             return (Class)DealCustomerGroupsModel.class;
/*       */           }
/*       */         });
/*  5928 */     addDaos("DealCustomerGroups", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5930 */             return (Class)DealCustomerGroupsDAO.class;
/*       */           }
/*       */         });
/*  5933 */     addObjectIds("DealCustomerGroups", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5935 */             return (Class)DealCustomerGroupsId.class;
/*       */           }
/*       */         });
/*  5938 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5940 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  5941 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Deals", DealId.class, false, false);
/*  5942 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("DocDefinitions", DocumentDefinitionId.class, false, false);
/*  5943 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealDocumentXrefPropertyId.class, false, false, true);
/*  5944 */           return rels;
/*       */         }
/*       */       };
/*  5947 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealDocumentXrefDAO", relationshipProducer);
/*  5948 */     addDataModels("dtv.xst.dao.prc.impl.DealDocumentXrefDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5950 */             return (Class)DealDocumentXrefModel.class;
/*       */           }
/*       */         });
/*  5953 */     addInterfaces("dtv.xst.dao.prc.IDealDocumentXref", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5955 */             return (Class)DealDocumentXrefModel.class;
/*       */           }
/*       */         });
/*  5958 */     addDaos("DealDocumentXref", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5960 */             return (Class)DealDocumentXrefDAO.class;
/*       */           }
/*       */         });
/*  5963 */     addObjectIds("DealDocumentXref", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5965 */             return (Class)DealDocumentXrefId.class;
/*       */           }
/*       */         });
/*  5968 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5970 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5971 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealFieldTestPropertyId.class, false, false, true);
/*  5972 */           return rels;
/*       */         }
/*       */       };
/*  5975 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealFieldTestDAO", relationshipProducer);
/*  5976 */     addDataModels("dtv.xst.dao.prc.impl.DealFieldTestDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  5978 */             return (Class)DealFieldTestModel.class;
/*       */           }
/*       */         });
/*  5981 */     addInterfaces("dtv.xst.dao.prc.IDealFieldTest", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  5983 */             return (Class)DealFieldTestModel.class;
/*       */           }
/*       */         });
/*  5986 */     addDaos("DealFieldTest", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  5988 */             return (Class)DealFieldTestDAO.class;
/*       */           }
/*       */         });
/*  5991 */     addObjectIds("DealFieldTest", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  5993 */             return (Class)DealFieldTestId.class;
/*       */           }
/*       */         });
/*  5996 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  5998 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  5999 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealItemActionPropertyId.class, false, false, true);
/*  6000 */           return rels;
/*       */         }
/*       */       };
/*  6003 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealItemActionDAO", relationshipProducer);
/*  6004 */     addDataModels("dtv.xst.dao.prc.impl.DealItemActionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6006 */             return (Class)DealItemActionModel.class;
/*       */           }
/*       */         });
/*  6009 */     addInterfaces("dtv.xst.dao.prc.IDealItemAction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6011 */             return (Class)DealItemActionModel.class;
/*       */           }
/*       */         });
/*  6014 */     addDaos("DealItemAction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6016 */             return (Class)DealItemActionDAO.class;
/*       */           }
/*       */         });
/*  6019 */     addObjectIds("DealItemAction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6021 */             return (Class)DealItemActionId.class;
/*       */           }
/*       */         });
/*  6024 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6026 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6027 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealTriggerPropertyId.class, false, false, true);
/*  6028 */           return rels;
/*       */         }
/*       */       };
/*  6031 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealTriggerDAO", relationshipProducer);
/*  6032 */     addDataModels("dtv.xst.dao.prc.impl.DealTriggerDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6034 */             return (Class)DealTriggerModel.class;
/*       */           }
/*       */         });
/*  6037 */     addInterfaces("dtv.xst.dao.prc.IDealTrigger", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6039 */             return (Class)DealTriggerModel.class;
/*       */           }
/*       */         });
/*  6042 */     addDaos("DealTrigger", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6044 */             return (Class)DealTriggerDAO.class;
/*       */           }
/*       */         });
/*  6047 */     addObjectIds("DealTrigger", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6049 */             return (Class)DealTriggerId.class;
/*       */           }
/*       */         });
/*  6052 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6054 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6055 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DealWeekPropertyId.class, false, false, true);
/*  6056 */           return rels;
/*       */         }
/*       */       };
/*  6059 */     addRelationshipProducer("dtv.xst.dao.prc.impl.DealWeekDAO", relationshipProducer);
/*  6060 */     addDataModels("dtv.xst.dao.prc.impl.DealWeekDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6062 */             return (Class)DealWeekModel.class;
/*       */           }
/*       */         });
/*  6065 */     addInterfaces("dtv.xst.dao.prc.IDealWeek", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6067 */             return (Class)DealWeekModel.class;
/*       */           }
/*       */         });
/*  6070 */     addDaos("DealWeek", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6072 */             return (Class)DealWeekDAO.class;
/*       */           }
/*       */         });
/*  6075 */     addObjectIds("DealWeek", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6077 */             return (Class)DealWeekId.class;
/*       */           }
/*       */         });
/*  6080 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6082 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6083 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PayrollPropertyId.class, false, false, true);
/*  6084 */           return rels;
/*       */         }
/*       */       };
/*  6087 */     addRelationshipProducer("dtv.xst.dao.thr.impl.PayrollDAO", relationshipProducer);
/*  6088 */     addDataModels("dtv.xst.dao.thr.impl.PayrollDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6090 */             return (Class)PayrollModel.class;
/*       */           }
/*       */         });
/*  6093 */     addInterfaces("dtv.xst.dao.thr.IPayroll", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6095 */             return (Class)PayrollModel.class;
/*       */           }
/*       */         });
/*  6098 */     addDaos("Payroll", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6100 */             return (Class)PayrollDAO.class;
/*       */           }
/*       */         });
/*  6103 */     addObjectIds("Payroll", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6105 */             return (Class)PayrollId.class;
/*       */           }
/*       */         });
/*  6108 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6110 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6111 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PayrollCategoryPropertyId.class, false, false, true);
/*  6112 */           return rels;
/*       */         }
/*       */       };
/*  6115 */     addRelationshipProducer("dtv.xst.dao.thr.impl.PayrollCategoryDAO", relationshipProducer);
/*  6116 */     addDataModels("dtv.xst.dao.thr.impl.PayrollCategoryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6118 */             return (Class)PayrollCategoryModel.class;
/*       */           }
/*       */         });
/*  6121 */     addInterfaces("dtv.xst.dao.thr.IPayrollCategory", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6123 */             return (Class)PayrollCategoryModel.class;
/*       */           }
/*       */         });
/*  6126 */     addDaos("PayrollCategory", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6128 */             return (Class)PayrollCategoryDAO.class;
/*       */           }
/*       */         });
/*  6131 */     addObjectIds("PayrollCategory", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6133 */             return (Class)PayrollCategoryId.class;
/*       */           }
/*       */         });
/*  6136 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6138 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6139 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PayrollHeaderPropertyId.class, false, false, true);
/*  6140 */           return rels;
/*       */         }
/*       */       };
/*  6143 */     addRelationshipProducer("dtv.xst.dao.thr.impl.PayrollHeaderDAO", relationshipProducer);
/*  6144 */     addDataModels("dtv.xst.dao.thr.impl.PayrollHeaderDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6146 */             return (Class)PayrollHeaderModel.class;
/*       */           }
/*       */         });
/*  6149 */     addInterfaces("dtv.xst.dao.thr.IPayrollHeader", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6151 */             return (Class)PayrollHeaderModel.class;
/*       */           }
/*       */         });
/*  6154 */     addDaos("PayrollHeader", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6156 */             return (Class)PayrollHeaderDAO.class;
/*       */           }
/*       */         });
/*  6159 */     addObjectIds("PayrollHeader", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6161 */             return (Class)PayrollHeaderId.class;
/*       */           }
/*       */         });
/*  6164 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6166 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6167 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PayrollNotesPropertyId.class, false, false, true);
/*  6168 */           return rels;
/*       */         }
/*       */       };
/*  6171 */     addRelationshipProducer("dtv.xst.dao.thr.impl.PayrollNotesDAO", relationshipProducer);
/*  6172 */     addDataModels("dtv.xst.dao.thr.impl.PayrollNotesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6174 */             return (Class)PayrollNotesModel.class;
/*       */           }
/*       */         });
/*  6177 */     addInterfaces("dtv.xst.dao.thr.IPayrollNotes", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6179 */             return (Class)PayrollNotesModel.class;
/*       */           }
/*       */         });
/*  6182 */     addDaos("PayrollNotes", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6184 */             return (Class)PayrollNotesDAO.class;
/*       */           }
/*       */         });
/*  6187 */     addObjectIds("PayrollNotes", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6189 */             return (Class)PayrollNotesId.class;
/*       */           }
/*       */         });
/*  6192 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6194 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  6195 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("WorkCode", WorkCodesId.class, false, false);
/*  6196 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TimecardEntryPropertyId.class, false, false, true);
/*  6197 */           return rels;
/*       */         }
/*       */       };
/*  6200 */     addRelationshipProducer("dtv.xst.dao.thr.impl.TimecardEntryDAO", relationshipProducer);
/*  6201 */     addDataModels("dtv.xst.dao.thr.impl.TimecardEntryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6203 */             return (Class)TimecardEntryModel.class;
/*       */           }
/*       */         });
/*  6206 */     addInterfaces("dtv.xst.dao.thr.ITimecardEntry", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6208 */             return (Class)TimecardEntryModel.class;
/*       */           }
/*       */         });
/*  6211 */     addDaos("TimecardEntry", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6213 */             return (Class)TimecardEntryDAO.class;
/*       */           }
/*       */         });
/*  6216 */     addObjectIds("TimecardEntry", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6218 */             return (Class)TimecardEntryId.class;
/*       */           }
/*       */         });
/*  6221 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6223 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6224 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TimecardEntryCommentPropertyId.class, false, false, true);
/*  6225 */           return rels;
/*       */         }
/*       */       };
/*  6228 */     addRelationshipProducer("dtv.xst.dao.thr.impl.TimecardEntryCommentDAO", relationshipProducer);
/*  6229 */     addDataModels("dtv.xst.dao.thr.impl.TimecardEntryCommentDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6231 */             return (Class)TimecardEntryCommentModel.class;
/*       */           }
/*       */         });
/*  6234 */     addInterfaces("dtv.xst.dao.thr.ITimecardEntryComment", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6236 */             return (Class)TimecardEntryCommentModel.class;
/*       */           }
/*       */         });
/*  6239 */     addDaos("TimecardEntryComment", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6241 */             return (Class)TimecardEntryCommentDAO.class;
/*       */           }
/*       */         });
/*  6244 */     addObjectIds("TimecardEntryComment", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6246 */             return (Class)TimecardEntryCommentId.class;
/*       */           }
/*       */         });
/*  6249 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6251 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  6252 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("WorkCode", WorkCodesId.class, false, false);
/*  6253 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TimecardJournalPropertyId.class, false, false, true);
/*  6254 */           return rels;
/*       */         }
/*       */       };
/*  6257 */     addRelationshipProducer("dtv.xst.dao.thr.impl.TimecardJournalDAO", relationshipProducer);
/*  6258 */     addDataModels("dtv.xst.dao.thr.impl.TimecardJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6260 */             return (Class)TimecardJournalModel.class;
/*       */           }
/*       */         });
/*  6263 */     addInterfaces("dtv.xst.dao.thr.ITimecardJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6265 */             return (Class)TimecardJournalModel.class;
/*       */           }
/*       */         });
/*  6268 */     addDaos("TimecardJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6270 */             return (Class)TimecardJournalDAO.class;
/*       */           }
/*       */         });
/*  6273 */     addObjectIds("TimecardJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6275 */             return (Class)TimecardJournalId.class;
/*       */           }
/*       */         });
/*  6278 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6280 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  6281 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  6282 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  6283 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  6284 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  6285 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  6286 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("WorkCode", WorkCodesId.class, false, false);
/*  6287 */           return rels;
/*       */         }
/*       */       };
/*  6290 */     addRelationshipProducer("dtv.xst.dao.thr.impl.TimeclockTransactionDAO", relationshipProducer);
/*  6291 */     addDataModels("dtv.xst.dao.thr.impl.TimeclockTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6293 */             return (Class)TimeclockTransactionModel.class;
/*       */           }
/*       */         });
/*  6296 */     addInterfaces("dtv.xst.dao.thr.ITimeclockTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6298 */             return (Class)TimeclockTransactionModel.class;
/*       */           }
/*       */         });
/*  6301 */     addDaos("TimeclockTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6303 */             return (Class)TimeclockTransactionDAO.class;
/*       */           }
/*       */         });
/*  6306 */     addObjectIds("TimeclockTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6308 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  6311 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6313 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6314 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderOptionsPropertyId.class, false, false, true);
/*  6315 */           return rels;
/*       */         }
/*       */       };
/*  6318 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderOptionsDAO", relationshipProducer);
/*  6319 */     addDataModels("dtv.xst.dao.tnd.impl.TenderOptionsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6321 */             return (Class)TenderOptionsModel.class;
/*       */           }
/*       */         });
/*  6324 */     addInterfaces("dtv.xst.dao.tnd.ITenderOptions", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6326 */             return (Class)TenderOptionsModel.class;
/*       */           }
/*       */         });
/*  6329 */     addDaos("TenderOptions", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6331 */             return (Class)TenderOptionsDAO.class;
/*       */           }
/*       */         });
/*  6334 */     addObjectIds("TenderOptions", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6336 */             return (Class)TenderOptionsId.class;
/*       */           }
/*       */         });
/*  6339 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6341 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  6342 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("TenderOptions", TenderOptionsId.class, false, false);
/*  6343 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("TenderAvailabilityCodes", TenderAvailabilityId.class, false, false);
/*  6344 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TenderDenominations", TenderDenominationId.class, false, false);
/*  6345 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("TenderType", TenderTypeId.class, false, false);
/*  6346 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderPropertyId.class, false, false, true);
/*  6347 */           return rels;
/*       */         }
/*       */       };
/*  6350 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderDAO", relationshipProducer);
/*  6351 */     addDataModels("dtv.xst.dao.tnd.impl.TenderDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6353 */             return (Class)TenderModel.class;
/*       */           }
/*       */         });
/*  6356 */     addInterfaces("dtv.xst.dao.tnd.ITender", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6358 */             return (Class)TenderModel.class;
/*       */           }
/*       */         });
/*  6361 */     addDaos("Tender", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6363 */             return (Class)TenderDAO.class;
/*       */           }
/*       */         });
/*  6366 */     addObjectIds("Tender", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6368 */             return (Class)TenderId.class;
/*       */           }
/*       */         });
/*  6371 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6373 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6374 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderAvailabilityPropertyId.class, false, false, true);
/*  6375 */           return rels;
/*       */         }
/*       */       };
/*  6378 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderAvailabilityDAO", relationshipProducer);
/*  6379 */     addDataModels("dtv.xst.dao.tnd.impl.TenderAvailabilityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6381 */             return (Class)TenderAvailabilityModel.class;
/*       */           }
/*       */         });
/*  6384 */     addInterfaces("dtv.xst.dao.tnd.ITenderAvailability", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6386 */             return (Class)TenderAvailabilityModel.class;
/*       */           }
/*       */         });
/*  6389 */     addDaos("TenderAvailability", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6391 */             return (Class)TenderAvailabilityDAO.class;
/*       */           }
/*       */         });
/*  6394 */     addObjectIds("TenderAvailability", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6396 */             return (Class)TenderAvailabilityId.class;
/*       */           }
/*       */         });
/*  6399 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6401 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6402 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderDenominationPropertyId.class, false, false, true);
/*  6403 */           return rels;
/*       */         }
/*       */       };
/*  6406 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderDenominationDAO", relationshipProducer);
/*  6407 */     addDataModels("dtv.xst.dao.tnd.impl.TenderDenominationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6409 */             return (Class)TenderDenominationModel.class;
/*       */           }
/*       */         });
/*  6412 */     addInterfaces("dtv.xst.dao.tnd.ITenderDenomination", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6414 */             return (Class)TenderDenominationModel.class;
/*       */           }
/*       */         });
/*  6417 */     addDaos("TenderDenomination", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6419 */             return (Class)TenderDenominationDAO.class;
/*       */           }
/*       */         });
/*  6422 */     addObjectIds("TenderDenomination", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6424 */             return (Class)TenderDenominationId.class;
/*       */           }
/*       */         });
/*  6427 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6429 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6430 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderExchangeRatePropertyId.class, false, false, true);
/*  6431 */           return rels;
/*       */         }
/*       */       };
/*  6434 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderExchangeRateDAO", relationshipProducer);
/*  6435 */     addDataModels("dtv.xst.dao.tnd.impl.TenderExchangeRateDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6437 */             return (Class)TenderExchangeRateModel.class;
/*       */           }
/*       */         });
/*  6440 */     addInterfaces("dtv.xst.dao.tnd.ITenderExchangeRate", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6442 */             return (Class)TenderExchangeRateModel.class;
/*       */           }
/*       */         });
/*  6445 */     addDaos("TenderExchangeRate", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6447 */             return (Class)TenderExchangeRateDAO.class;
/*       */           }
/*       */         });
/*  6450 */     addObjectIds("TenderExchangeRate", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6452 */             return (Class)TenderExchangeRateId.class;
/*       */           }
/*       */         });
/*  6455 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6457 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6458 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderTypePropertyId.class, false, false, true);
/*  6459 */           return rels;
/*       */         }
/*       */       };
/*  6462 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderTypeDAO", relationshipProducer);
/*  6463 */     addDataModels("dtv.xst.dao.tnd.impl.TenderTypeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6465 */             return (Class)TenderTypeModel.class;
/*       */           }
/*       */         });
/*  6468 */     addInterfaces("dtv.xst.dao.tnd.ITenderType", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6470 */             return (Class)TenderTypeModel.class;
/*       */           }
/*       */         });
/*  6473 */     addDaos("TenderType", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6475 */             return (Class)TenderTypeDAO.class;
/*       */           }
/*       */         });
/*  6478 */     addObjectIds("TenderType", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6480 */             return (Class)TenderTypeId.class;
/*       */           }
/*       */         });
/*  6483 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6485 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6486 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TenderUserSettingsPropertyId.class, false, false, true);
/*  6487 */           return rels;
/*       */         }
/*       */       };
/*  6490 */     addRelationshipProducer("dtv.xst.dao.tnd.impl.TenderUserSettingsDAO", relationshipProducer);
/*  6491 */     addDataModels("dtv.xst.dao.tnd.impl.TenderUserSettingsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6493 */             return (Class)TenderUserSettingsModel.class;
/*       */           }
/*       */         });
/*  6496 */     addInterfaces("dtv.xst.dao.tnd.ITenderUserSettings", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6498 */             return (Class)TenderUserSettingsModel.class;
/*       */           }
/*       */         });
/*  6501 */     addDaos("TenderUserSettings", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6503 */             return (Class)TenderUserSettingsDAO.class;
/*       */           }
/*       */         });
/*  6506 */     addObjectIds("TenderUserSettings", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6508 */             return (Class)TenderUserSettingsId.class;
/*       */           }
/*       */         });
/*  6511 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6513 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6514 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", IpCashDrawerDevicePropertyId.class, false, false, true);
/*  6515 */           return rels;
/*       */         }
/*       */       };
/*  6518 */     addRelationshipProducer("dtv.xst.dao.ctl.impl.IpCashDrawerDeviceDAO", relationshipProducer);
/*  6519 */     addDataModels("dtv.xst.dao.ctl.impl.IpCashDrawerDeviceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6521 */             return (Class)IpCashDrawerDeviceModel.class;
/*       */           }
/*       */         });
/*  6524 */     addInterfaces("dtv.xst.dao.ctl.IIpCashDrawerDevice", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6526 */             return (Class)IpCashDrawerDeviceModel.class;
/*       */           }
/*       */         });
/*  6529 */     addDaos("IpCashDrawerDevice", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6531 */             return (Class)IpCashDrawerDeviceDAO.class;
/*       */           }
/*       */         });
/*  6534 */     addObjectIds("IpCashDrawerDevice", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6536 */             return (Class)IpCashDrawerDeviceId.class;
/*       */           }
/*       */         });
/*  6539 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6541 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6542 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CheetahClientDeviceAccessPropertyId.class, false, false, true);
/*  6543 */           return rels;
/*       */         }
/*       */       };
/*  6546 */     addRelationshipProducer("dtv.xst.dao.ctl.impl.CheetahClientDeviceAccessDAO", relationshipProducer);
/*  6547 */     addDataModels("dtv.xst.dao.ctl.impl.CheetahClientDeviceAccessDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6549 */             return (Class)CheetahClientDeviceAccessModel.class;
/*       */           }
/*       */         });
/*  6552 */     addInterfaces("dtv.xst.dao.ctl.ICheetahClientDeviceAccess", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6554 */             return (Class)CheetahClientDeviceAccessModel.class;
/*       */           }
/*       */         });
/*  6557 */     addDaos("CheetahClientDeviceAccess", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6559 */             return (Class)CheetahClientDeviceAccessDAO.class;
/*       */           }
/*       */         });
/*  6562 */     addObjectIds("CheetahClientDeviceAccess", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6564 */             return (Class)CheetahClientDeviceAccessId.class;
/*       */           }
/*       */         });
/*  6567 */     addDataModels("dtv.xst.dao.ctl.impl.EventLogEntryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6569 */             return (Class)EventLogEntryModel.class;
/*       */           }
/*       */         });
/*  6572 */     addInterfaces("dtv.xst.dao.ctl.IEventLogEntry", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6574 */             return (Class)EventLogEntryModel.class;
/*       */           }
/*       */         });
/*  6577 */     addDaos("EventLogEntry", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6579 */             return (Class)EventLogEntryDAO.class;
/*       */           }
/*       */         });
/*  6582 */     addObjectIds("EventLogEntry", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6584 */             return (Class)EventLogEntryId.class;
/*       */           }
/*       */         });
/*  6587 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6589 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6590 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DataLoaderFailurePropertyId.class, false, false, true);
/*  6591 */           return rels;
/*       */         }
/*       */       };
/*  6594 */     addRelationshipProducer("dtv.xst.dao.ctl.impl.DataLoaderFailureDAO", relationshipProducer);
/*  6595 */     addDataModels("dtv.xst.dao.ctl.impl.DataLoaderFailureDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6597 */             return (Class)DataLoaderFailureModel.class;
/*       */           }
/*       */         });
/*  6600 */     addInterfaces("dtv.xst.dao.ctl.IDataLoaderFailure", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6602 */             return (Class)DataLoaderFailureModel.class;
/*       */           }
/*       */         });
/*  6605 */     addDaos("DataLoaderFailure", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6607 */             return (Class)DataLoaderFailureDAO.class;
/*       */           }
/*       */         });
/*  6610 */     addObjectIds("DataLoaderFailure", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6612 */             return (Class)DataLoaderFailureId.class;
/*       */           }
/*       */         });
/*  6615 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6617 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6618 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DataLoaderSummaryPropertyId.class, false, false, true);
/*  6619 */           return rels;
/*       */         }
/*       */       };
/*  6622 */     addRelationshipProducer("dtv.xst.dao.ctl.impl.DataLoaderSummaryDAO", relationshipProducer);
/*  6623 */     addDataModels("dtv.xst.dao.ctl.impl.DataLoaderSummaryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6625 */             return (Class)DataLoaderSummaryModel.class;
/*       */           }
/*       */         });
/*  6628 */     addInterfaces("dtv.xst.dao.ctl.IDataLoaderSummary", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6630 */             return (Class)DataLoaderSummaryModel.class;
/*       */           }
/*       */         });
/*  6633 */     addDaos("DataLoaderSummary", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6635 */             return (Class)DataLoaderSummaryDAO.class;
/*       */           }
/*       */         });
/*  6638 */     addObjectIds("DataLoaderSummary", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6640 */             return (Class)DataLoaderSummaryId.class;
/*       */           }
/*       */         });
/*  6643 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6645 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6646 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DeviceRegistrationPropertyId.class, false, false, true);
/*  6647 */           return rels;
/*       */         }
/*       */       };
/*  6650 */     addRelationshipProducer("dtv.xst.dao.ctl.impl.DeviceRegistrationDAO", relationshipProducer);
/*  6651 */     addDataModels("dtv.xst.dao.ctl.impl.DeviceRegistrationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6653 */             return (Class)DeviceRegistrationModel.class;
/*       */           }
/*       */         });
/*  6656 */     addInterfaces("dtv.xst.dao.ctl.IDeviceRegistration", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6658 */             return (Class)DeviceRegistrationModel.class;
/*       */           }
/*       */         });
/*  6661 */     addDaos("DeviceRegistration", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6663 */             return (Class)DeviceRegistrationDAO.class;
/*       */           }
/*       */         });
/*  6666 */     addObjectIds("DeviceRegistration", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6668 */             return (Class)DeviceRegistrationId.class;
/*       */           }
/*       */         });
/*  6671 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6673 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6674 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", VersionPropertyId.class, false, false, true);
/*  6675 */           return rels;
/*       */         }
/*       */       };
/*  6678 */     addRelationshipProducer("dtv.xst.dao.ctl.impl.VersionDAO", relationshipProducer);
/*  6679 */     addDataModels("dtv.xst.dao.ctl.impl.VersionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6681 */             return (Class)VersionModel.class;
/*       */           }
/*       */         });
/*  6684 */     addInterfaces("dtv.xst.dao.ctl.IVersion", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6686 */             return (Class)VersionModel.class;
/*       */           }
/*       */         });
/*  6689 */     addDaos("Version", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6691 */             return (Class)VersionDAO.class;
/*       */           }
/*       */         });
/*  6694 */     addObjectIds("Version", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6696 */             return (Class)VersionId.class;
/*       */           }
/*       */         });
/*  6699 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6701 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6702 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailLocationPropertyId.class, false, false, true);
/*  6703 */           return rels;
/*       */         }
/*       */       };
/*  6706 */     addRelationshipProducer("dtv.xst.dao.loc.impl.RetailLocationDAO", relationshipProducer);
/*  6707 */     addDataModels("dtv.xst.dao.loc.impl.RetailLocationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6709 */             return (Class)RetailLocationModel.class;
/*       */           }
/*       */         });
/*  6712 */     addInterfaces("dtv.xst.dao.loc.IRetailLocation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6714 */             return (Class)RetailLocationModel.class;
/*       */           }
/*       */         });
/*  6717 */     addDaos("RetailLocation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6719 */             return (Class)RetailLocationDAO.class;
/*       */           }
/*       */         });
/*  6722 */     addObjectIds("RetailLocation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6724 */             return (Class)RetailLocationId.class;
/*       */           }
/*       */         });
/*  6727 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6729 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  6730 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("ParentElement", OrgHierarchyId.class, false, false);
/*  6731 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrgHierarchyPropertyId.class, false, false, true);
/*  6732 */           return rels;
/*       */         }
/*       */       };
/*  6735 */     addRelationshipProducer("dtv.xst.dao.loc.impl.OrgHierarchyDAO", relationshipProducer);
/*  6736 */     addDataModels("dtv.xst.dao.loc.impl.OrgHierarchyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6738 */             return (Class)OrgHierarchyModel.class;
/*       */           }
/*       */         });
/*  6741 */     addInterfaces("dtv.xst.dao.loc.IOrgHierarchy", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6743 */             return (Class)OrgHierarchyModel.class;
/*       */           }
/*       */         });
/*  6746 */     addDaos("OrgHierarchy", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6748 */             return (Class)OrgHierarchyDAO.class;
/*       */           }
/*       */         });
/*  6751 */     addObjectIds("OrgHierarchy", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6753 */             return (Class)OrgHierarchyId.class;
/*       */           }
/*       */         });
/*  6756 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6758 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  6759 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("ParentElement", PricingHierarchyId.class, false, false);
/*  6760 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", PricingHierarchyPropertyId.class, false, false, true);
/*  6761 */           return rels;
/*       */         }
/*       */       };
/*  6764 */     addRelationshipProducer("dtv.xst.dao.loc.impl.PricingHierarchyDAO", relationshipProducer);
/*  6765 */     addDataModels("dtv.xst.dao.loc.impl.PricingHierarchyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6767 */             return (Class)PricingHierarchyModel.class;
/*       */           }
/*       */         });
/*  6770 */     addInterfaces("dtv.xst.dao.loc.IPricingHierarchy", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6772 */             return (Class)PricingHierarchyModel.class;
/*       */           }
/*       */         });
/*  6775 */     addDaos("PricingHierarchy", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6777 */             return (Class)PricingHierarchyDAO.class;
/*       */           }
/*       */         });
/*  6780 */     addObjectIds("PricingHierarchy", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6782 */             return (Class)PricingHierarchyId.class;
/*       */           }
/*       */         });
/*  6785 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6787 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6788 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WorkstationPropertyId.class, false, false, true);
/*  6789 */           return rels;
/*       */         }
/*       */       };
/*  6792 */     addRelationshipProducer("dtv.xst.dao.loc.impl.WorkstationDAO", relationshipProducer);
/*  6793 */     addDataModels("dtv.xst.dao.loc.impl.WorkstationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6795 */             return (Class)WorkstationModel.class;
/*       */           }
/*       */         });
/*  6798 */     addInterfaces("dtv.xst.dao.loc.IWorkstation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6800 */             return (Class)WorkstationModel.class;
/*       */           }
/*       */         });
/*  6803 */     addDaos("Workstation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6805 */             return (Class)WorkstationDAO.class;
/*       */           }
/*       */         });
/*  6808 */     addObjectIds("Workstation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6810 */             return (Class)WorkstationId.class;
/*       */           }
/*       */         });
/*  6813 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6815 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6816 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CloseDatesPropertyId.class, false, false, true);
/*  6817 */           return rels;
/*       */         }
/*       */       };
/*  6820 */     addRelationshipProducer("dtv.xst.dao.loc.impl.CloseDatesDAO", relationshipProducer);
/*  6821 */     addDataModels("dtv.xst.dao.loc.impl.CloseDatesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6823 */             return (Class)CloseDatesModel.class;
/*       */           }
/*       */         });
/*  6826 */     addInterfaces("dtv.xst.dao.loc.ICloseDates", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6828 */             return (Class)CloseDatesModel.class;
/*       */           }
/*       */         });
/*  6831 */     addDaos("CloseDates", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6833 */             return (Class)CloseDatesDAO.class;
/*       */           }
/*       */         });
/*  6836 */     addObjectIds("CloseDates", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6838 */             return (Class)CloseDatesId.class;
/*       */           }
/*       */         });
/*  6841 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6843 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6844 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ClosingMessagePropertyId.class, false, false, true);
/*  6845 */           return rels;
/*       */         }
/*       */       };
/*  6848 */     addRelationshipProducer("dtv.xst.dao.loc.impl.ClosingMessageDAO", relationshipProducer);
/*  6849 */     addDataModels("dtv.xst.dao.loc.impl.ClosingMessageDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6851 */             return (Class)ClosingMessageModel.class;
/*       */           }
/*       */         });
/*  6854 */     addInterfaces("dtv.xst.dao.loc.IClosingMessage", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6856 */             return (Class)ClosingMessageModel.class;
/*       */           }
/*       */         });
/*  6859 */     addDaos("ClosingMessage", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6861 */             return (Class)ClosingMessageDAO.class;
/*       */           }
/*       */         });
/*  6864 */     addObjectIds("ClosingMessage", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6866 */             return (Class)ClosingMessageId.class;
/*       */           }
/*       */         });
/*  6869 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6871 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  6872 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("QuestionChoices", CycleQuestionChoiceId.class, false, false);
/*  6873 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", CycleQuestionPropertyId.class, false, false, true);
/*  6874 */           return rels;
/*       */         }
/*       */       };
/*  6877 */     addRelationshipProducer("dtv.xst.dao.loc.impl.CycleQuestionDAO", relationshipProducer);
/*  6878 */     addDataModels("dtv.xst.dao.loc.impl.CycleQuestionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6880 */             return (Class)CycleQuestionModel.class;
/*       */           }
/*       */         });
/*  6883 */     addInterfaces("dtv.xst.dao.loc.ICycleQuestion", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6885 */             return (Class)CycleQuestionModel.class;
/*       */           }
/*       */         });
/*  6888 */     addDaos("CycleQuestion", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6890 */             return (Class)CycleQuestionDAO.class;
/*       */           }
/*       */         });
/*  6893 */     addObjectIds("CycleQuestion", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6895 */             return (Class)CycleQuestionId.class;
/*       */           }
/*       */         });
/*  6898 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6900 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6901 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CycleQuestionAnswerPropertyId.class, false, false, true);
/*  6902 */           return rels;
/*       */         }
/*       */       };
/*  6905 */     addRelationshipProducer("dtv.xst.dao.loc.impl.CycleQuestionAnswerDAO", relationshipProducer);
/*  6906 */     addDataModels("dtv.xst.dao.loc.impl.CycleQuestionAnswerDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6908 */             return (Class)CycleQuestionAnswerModel.class;
/*       */           }
/*       */         });
/*  6911 */     addInterfaces("dtv.xst.dao.loc.ICycleQuestionAnswer", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6913 */             return (Class)CycleQuestionAnswerModel.class;
/*       */           }
/*       */         });
/*  6916 */     addDaos("CycleQuestionAnswer", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6918 */             return (Class)CycleQuestionAnswerDAO.class;
/*       */           }
/*       */         });
/*  6921 */     addObjectIds("CycleQuestionAnswer", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6923 */             return (Class)CycleQuestionAnswerId.class;
/*       */           }
/*       */         });
/*  6926 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6928 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6929 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CycleQuestionChoicePropertyId.class, false, false, true);
/*  6930 */           return rels;
/*       */         }
/*       */       };
/*  6933 */     addRelationshipProducer("dtv.xst.dao.loc.impl.CycleQuestionChoiceDAO", relationshipProducer);
/*  6934 */     addDataModels("dtv.xst.dao.loc.impl.CycleQuestionChoiceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6936 */             return (Class)CycleQuestionChoiceModel.class;
/*       */           }
/*       */         });
/*  6939 */     addInterfaces("dtv.xst.dao.loc.ICycleQuestionChoice", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6941 */             return (Class)CycleQuestionChoiceModel.class;
/*       */           }
/*       */         });
/*  6944 */     addDaos("CycleQuestionChoice", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6946 */             return (Class)CycleQuestionChoiceDAO.class;
/*       */           }
/*       */         });
/*  6949 */     addObjectIds("CycleQuestionChoice", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6951 */             return (Class)CycleQuestionChoiceId.class;
/*       */           }
/*       */         });
/*  6954 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6956 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6957 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", StateJournalPropertyId.class, false, false, true);
/*  6958 */           return rels;
/*       */         }
/*       */       };
/*  6961 */     addRelationshipProducer("dtv.xst.dao.loc.impl.StateJournalDAO", relationshipProducer);
/*  6962 */     addDataModels("dtv.xst.dao.loc.impl.StateJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6964 */             return (Class)StateJournalModel.class;
/*       */           }
/*       */         });
/*  6967 */     addInterfaces("dtv.xst.dao.loc.IStateJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6969 */             return (Class)StateJournalModel.class;
/*       */           }
/*       */         });
/*  6972 */     addDaos("StateJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  6974 */             return (Class)StateJournalDAO.class;
/*       */           }
/*       */         });
/*  6977 */     addObjectIds("StateJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  6979 */             return (Class)StateJournalId.class;
/*       */           }
/*       */         });
/*  6982 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  6984 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  6985 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", FlightInformationPropertyId.class, false, false, true);
/*  6986 */           return rels;
/*       */         }
/*       */       };
/*  6989 */     addRelationshipProducer("dtv.xst.dao.com.impl.FlightInformationDAO", relationshipProducer);
/*  6990 */     addDataModels("dtv.xst.dao.com.impl.FlightInformationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  6992 */             return (Class)FlightInformationModel.class;
/*       */           }
/*       */         });
/*  6995 */     addInterfaces("dtv.xst.dao.com.IFlightInformation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  6997 */             return (Class)FlightInformationModel.class;
/*       */           }
/*       */         });
/*  7000 */     addDaos("FlightInformation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7002 */             return (Class)FlightInformationDAO.class;
/*       */           }
/*       */         });
/*  7005 */     addObjectIds("FlightInformation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7007 */             return (Class)FlightInformationId.class;
/*       */           }
/*       */         });
/*  7010 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7012 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7013 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AirportPropertyId.class, false, false, true);
/*  7014 */           return rels;
/*       */         }
/*       */       };
/*  7017 */     addRelationshipProducer("dtv.xst.dao.com.impl.AirportDAO", relationshipProducer);
/*  7018 */     addDataModels("dtv.xst.dao.com.impl.AirportDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7020 */             return (Class)AirportModel.class;
/*       */           }
/*       */         });
/*  7023 */     addInterfaces("dtv.xst.dao.com.IAirport", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7025 */             return (Class)AirportModel.class;
/*       */           }
/*       */         });
/*  7028 */     addDaos("Airport", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7030 */             return (Class)AirportDAO.class;
/*       */           }
/*       */         });
/*  7033 */     addObjectIds("Airport", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7035 */             return (Class)AirportId.class;
/*       */           }
/*       */         });
/*  7038 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7040 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7041 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ButtonGridPropertyId.class, false, false, true);
/*  7042 */           return rels;
/*       */         }
/*       */       };
/*  7045 */     addRelationshipProducer("dtv.xst.dao.com.impl.ButtonGridDAO", relationshipProducer);
/*  7046 */     addDataModels("dtv.xst.dao.com.impl.ButtonGridDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7048 */             return (Class)ButtonGridModel.class;
/*       */           }
/*       */         });
/*  7051 */     addInterfaces("dtv.xst.dao.com.IButtonGrid", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7053 */             return (Class)ButtonGridModel.class;
/*       */           }
/*       */         });
/*  7056 */     addDaos("ButtonGrid", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7058 */             return (Class)ButtonGridDAO.class;
/*       */           }
/*       */         });
/*  7061 */     addObjectIds("ButtonGrid", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7063 */             return (Class)ButtonGridId.class;
/*       */           }
/*       */         });
/*  7066 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7068 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7069 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CodeValuePropertyId.class, false, false, true);
/*  7070 */           return rels;
/*       */         }
/*       */       };
/*  7073 */     addRelationshipProducer("dtv.xst.dao.com.impl.CodeValueDAO", relationshipProducer);
/*  7074 */     addDataModels("dtv.xst.dao.com.impl.CodeValueDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7076 */             return (Class)CodeValueModel.class;
/*       */           }
/*       */         });
/*  7079 */     addInterfaces("dtv.xst.dao.com.ICodeValue", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7081 */             return (Class)CodeValueModel.class;
/*       */           }
/*       */         });
/*  7084 */     addDaos("CodeValue", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7086 */             return (Class)CodeValueDAO.class;
/*       */           }
/*       */         });
/*  7089 */     addObjectIds("CodeValue", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7091 */             return (Class)CodeValueId.class;
/*       */           }
/*       */         });
/*  7094 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7096 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7097 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DatabaseTranslationPropertyId.class, false, false, true);
/*  7098 */           return rels;
/*       */         }
/*       */       };
/*  7101 */     addRelationshipProducer("dtv.xst.dao.com.impl.DatabaseTranslationDAO", relationshipProducer);
/*  7102 */     addDataModels("dtv.xst.dao.com.impl.DatabaseTranslationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7104 */             return (Class)DatabaseTranslationModel.class;
/*       */           }
/*       */         });
/*  7107 */     addInterfaces("dtv.xst.dao.com.IDatabaseTranslation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7109 */             return (Class)DatabaseTranslationModel.class;
/*       */           }
/*       */         });
/*  7112 */     addDaos("DatabaseTranslation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7114 */             return (Class)DatabaseTranslationDAO.class;
/*       */           }
/*       */         });
/*  7117 */     addObjectIds("DatabaseTranslation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7119 */             return (Class)DatabaseTranslationId.class;
/*       */           }
/*       */         });
/*  7122 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7124 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7125 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SequencePropertyId.class, false, false, true);
/*  7126 */           return rels;
/*       */         }
/*       */       };
/*  7129 */     addRelationshipProducer("dtv.xst.dao.com.impl.SequenceDAO", relationshipProducer);
/*  7130 */     addDataModels("dtv.xst.dao.com.impl.SequenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7132 */             return (Class)SequenceModel.class;
/*       */           }
/*       */         });
/*  7135 */     addInterfaces("dtv.xst.dao.com.ISequence", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7137 */             return (Class)SequenceModel.class;
/*       */           }
/*       */         });
/*  7140 */     addDaos("Sequence", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7142 */             return (Class)SequenceDAO.class;
/*       */           }
/*       */         });
/*  7145 */     addObjectIds("Sequence", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7147 */             return (Class)SequenceId.class;
/*       */           }
/*       */         });
/*  7150 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7152 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7153 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AddressPropertyId.class, false, false, true);
/*  7154 */           return rels;
/*       */         }
/*       */       };
/*  7157 */     addRelationshipProducer("dtv.xst.dao.com.impl.AddressDAO", relationshipProducer);
/*  7158 */     addDataModels("dtv.xst.dao.com.impl.AddressDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7160 */             return (Class)AddressModel.class;
/*       */           }
/*       */         });
/*  7163 */     addInterfaces("dtv.xst.dao.com.IAddress", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7165 */             return (Class)AddressModel.class;
/*       */           }
/*       */         });
/*  7168 */     addDaos("Address", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7170 */             return (Class)AddressDAO.class;
/*       */           }
/*       */         });
/*  7173 */     addObjectIds("Address", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7175 */             return (Class)AddressId.class;
/*       */           }
/*       */         });
/*  7178 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7180 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7181 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AddressCountryPropertyId.class, false, false, true);
/*  7182 */           return rels;
/*       */         }
/*       */       };
/*  7185 */     addRelationshipProducer("dtv.xst.dao.com.impl.AddressCountryDAO", relationshipProducer);
/*  7186 */     addDataModels("dtv.xst.dao.com.impl.AddressCountryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7188 */             return (Class)AddressCountryModel.class;
/*       */           }
/*       */         });
/*  7191 */     addInterfaces("dtv.xst.dao.com.IAddressCountry", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7193 */             return (Class)AddressCountryModel.class;
/*       */           }
/*       */         });
/*  7196 */     addDaos("AddressCountry", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7198 */             return (Class)AddressCountryDAO.class;
/*       */           }
/*       */         });
/*  7201 */     addObjectIds("AddressCountry", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7203 */             return (Class)AddressCountryId.class;
/*       */           }
/*       */         });
/*  7206 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7208 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7209 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AddressPostalCodePropertyId.class, false, false, true);
/*  7210 */           return rels;
/*       */         }
/*       */       };
/*  7213 */     addRelationshipProducer("dtv.xst.dao.com.impl.AddressPostalCodeDAO", relationshipProducer);
/*  7214 */     addDataModels("dtv.xst.dao.com.impl.AddressPostalCodeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7216 */             return (Class)AddressPostalCodeModel.class;
/*       */           }
/*       */         });
/*  7219 */     addInterfaces("dtv.xst.dao.com.IAddressPostalCode", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7221 */             return (Class)AddressPostalCodeModel.class;
/*       */           }
/*       */         });
/*  7224 */     addDaos("AddressPostalCode", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7226 */             return (Class)AddressPostalCodeDAO.class;
/*       */           }
/*       */         });
/*  7229 */     addObjectIds("AddressPostalCode", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7231 */             return (Class)AddressPostalCodeId.class;
/*       */           }
/*       */         });
/*  7234 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7236 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7237 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AddressStatePropertyId.class, false, false, true);
/*  7238 */           return rels;
/*       */         }
/*       */       };
/*  7241 */     addRelationshipProducer("dtv.xst.dao.com.impl.AddressStateDAO", relationshipProducer);
/*  7242 */     addDataModels("dtv.xst.dao.com.impl.AddressStateDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7244 */             return (Class)AddressStateModel.class;
/*       */           }
/*       */         });
/*  7247 */     addInterfaces("dtv.xst.dao.com.IAddressState", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7249 */             return (Class)AddressStateModel.class;
/*       */           }
/*       */         });
/*  7252 */     addDaos("AddressState", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7254 */             return (Class)AddressStateDAO.class;
/*       */           }
/*       */         });
/*  7257 */     addObjectIds("AddressState", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7259 */             return (Class)AddressStateId.class;
/*       */           }
/*       */         });
/*  7262 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7264 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7265 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CountryReturnMapPropertyId.class, false, false, true);
/*  7266 */           return rels;
/*       */         }
/*       */       };
/*  7269 */     addRelationshipProducer("dtv.xst.dao.com.impl.CountryReturnMapDAO", relationshipProducer);
/*  7270 */     addDataModels("dtv.xst.dao.com.impl.CountryReturnMapDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7272 */             return (Class)CountryReturnMapModel.class;
/*       */           }
/*       */         });
/*  7275 */     addInterfaces("dtv.xst.dao.com.ICountryReturnMap", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7277 */             return (Class)CountryReturnMapModel.class;
/*       */           }
/*       */         });
/*  7280 */     addDaos("CountryReturnMap", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7282 */             return (Class)CountryReturnMapDAO.class;
/*       */           }
/*       */         });
/*  7285 */     addObjectIds("CountryReturnMap", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7287 */             return (Class)CountryReturnMapId.class;
/*       */           }
/*       */         });
/*  7290 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7292 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7293 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReasonCodePropertyId.class, false, false, true);
/*  7294 */           return rels;
/*       */         }
/*       */       };
/*  7297 */     addRelationshipProducer("dtv.xst.dao.com.impl.ReasonCodeDAO", relationshipProducer);
/*  7298 */     addDataModels("dtv.xst.dao.com.impl.ReasonCodeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7300 */             return (Class)ReasonCodeModel.class;
/*       */           }
/*       */         });
/*  7303 */     addInterfaces("dtv.xst.dao.com.IReasonCode", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7305 */             return (Class)ReasonCodeModel.class;
/*       */           }
/*       */         });
/*  7308 */     addDaos("ReasonCode", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7310 */             return (Class)ReasonCodeDAO.class;
/*       */           }
/*       */         });
/*  7313 */     addObjectIds("ReasonCode", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7315 */             return (Class)ReasonCodeId.class;
/*       */           }
/*       */         });
/*  7318 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7320 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7321 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReceiptTextPropertyId.class, false, false, true);
/*  7322 */           return rels;
/*       */         }
/*       */       };
/*  7325 */     addRelationshipProducer("dtv.xst.dao.com.impl.ReceiptTextDAO", relationshipProducer);
/*  7326 */     addDataModels("dtv.xst.dao.com.impl.ReceiptTextDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7328 */             return (Class)ReceiptTextModel.class;
/*       */           }
/*       */         });
/*  7331 */     addInterfaces("dtv.xst.dao.com.IReceiptText", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7333 */             return (Class)ReceiptTextModel.class;
/*       */           }
/*       */         });
/*  7336 */     addDaos("ReceiptText", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7338 */             return (Class)ReceiptTextDAO.class;
/*       */           }
/*       */         });
/*  7341 */     addObjectIds("ReceiptText", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7343 */             return (Class)ReceiptTextId.class;
/*       */           }
/*       */         });
/*  7346 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7348 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7349 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReportDataPropertyId.class, false, false, true);
/*  7350 */           return rels;
/*       */         }
/*       */       };
/*  7353 */     addRelationshipProducer("dtv.xst.dao.com.impl.ReportDataDAO", relationshipProducer);
/*  7354 */     addDataModels("dtv.xst.dao.com.impl.ReportDataDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7356 */             return (Class)ReportDataModel.class;
/*       */           }
/*       */         });
/*  7359 */     addInterfaces("dtv.xst.dao.com.IReportData", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7361 */             return (Class)ReportDataModel.class;
/*       */           }
/*       */         });
/*  7364 */     addDaos("ReportData", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7366 */             return (Class)ReportDataDAO.class;
/*       */           }
/*       */         });
/*  7369 */     addObjectIds("ReportData", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7371 */             return (Class)ReportDataId.class;
/*       */           }
/*       */         });
/*  7374 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7376 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7377 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ReportLookupPropertyId.class, false, false, true);
/*  7378 */           return rels;
/*       */         }
/*       */       };
/*  7381 */     addRelationshipProducer("dtv.xst.dao.com.impl.ReportLookupDAO", relationshipProducer);
/*  7382 */     addDataModels("dtv.xst.dao.com.impl.ReportLookupDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7384 */             return (Class)ReportLookupModel.class;
/*       */           }
/*       */         });
/*  7387 */     addInterfaces("dtv.xst.dao.com.IReportLookup", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7389 */             return (Class)ReportLookupModel.class;
/*       */           }
/*       */         });
/*  7392 */     addDaos("ReportLookup", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7394 */             return (Class)ReportLookupDAO.class;
/*       */           }
/*       */         });
/*  7397 */     addObjectIds("ReportLookup", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7399 */             return (Class)ReportLookupId.class;
/*       */           }
/*       */         });
/*  7402 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7404 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7405 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SequencePartPropertyId.class, false, false, true);
/*  7406 */           return rels;
/*       */         }
/*       */       };
/*  7409 */     addRelationshipProducer("dtv.xst.dao.com.impl.SequencePartDAO", relationshipProducer);
/*  7410 */     addDataModels("dtv.xst.dao.com.impl.SequencePartDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7412 */             return (Class)SequencePartModel.class;
/*       */           }
/*       */         });
/*  7415 */     addInterfaces("dtv.xst.dao.com.ISequencePart", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7417 */             return (Class)SequencePartModel.class;
/*       */           }
/*       */         });
/*  7420 */     addDaos("SequencePart", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7422 */             return (Class)SequencePartDAO.class;
/*       */           }
/*       */         });
/*  7425 */     addObjectIds("SequencePart", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7427 */             return (Class)SequencePartId.class;
/*       */           }
/*       */         });
/*  7430 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7432 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7433 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShippingCostPropertyId.class, false, false, true);
/*  7434 */           return rels;
/*       */         }
/*       */       };
/*  7437 */     addRelationshipProducer("dtv.xst.dao.com.impl.ShippingCostDAO", relationshipProducer);
/*  7438 */     addDataModels("dtv.xst.dao.com.impl.ShippingCostDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7440 */             return (Class)ShippingCostModel.class;
/*       */           }
/*       */         });
/*  7443 */     addInterfaces("dtv.xst.dao.com.IShippingCost", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7445 */             return (Class)ShippingCostModel.class;
/*       */           }
/*       */         });
/*  7448 */     addDaos("ShippingCost", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7450 */             return (Class)ShippingCostDAO.class;
/*       */           }
/*       */         });
/*  7453 */     addObjectIds("ShippingCost", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7455 */             return (Class)ShippingCostId.class;
/*       */           }
/*       */         });
/*  7458 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7460 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7461 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TransactionPropertyPromptPropertyId.class, false, false, true);
/*  7462 */           return rels;
/*       */         }
/*       */       };
/*  7465 */     addRelationshipProducer("dtv.xst.dao.com.impl.TransactionPropertyPromptDAO", relationshipProducer);
/*  7466 */     addDataModels("dtv.xst.dao.com.impl.TransactionPropertyPromptDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7468 */             return (Class)TransactionPropertyPromptModel.class;
/*       */           }
/*       */         });
/*  7471 */     addInterfaces("dtv.xst.dao.com.ITransactionPropertyPrompt", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7473 */             return (Class)TransactionPropertyPromptModel.class;
/*       */           }
/*       */         });
/*  7476 */     addDaos("TransactionPropertyPrompt", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7478 */             return (Class)TransactionPropertyPromptDAO.class;
/*       */           }
/*       */         });
/*  7481 */     addObjectIds("TransactionPropertyPrompt", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7483 */             return (Class)TransactionPropertyPromptId.class;
/*       */           }
/*       */         });
/*  7486 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7488 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7489 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AirportZonePropertyId.class, false, false, true);
/*  7490 */           return rels;
/*       */         }
/*       */       };
/*  7493 */     addRelationshipProducer("dtv.xst.dao.com.impl.AirportZoneDAO", relationshipProducer);
/*  7494 */     addDataModels("dtv.xst.dao.com.impl.AirportZoneDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7496 */             return (Class)AirportZoneModel.class;
/*       */           }
/*       */         });
/*  7499 */     addInterfaces("dtv.xst.dao.com.IAirportZone", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7501 */             return (Class)AirportZoneModel.class;
/*       */           }
/*       */         });
/*  7504 */     addDaos("AirportZone", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7506 */             return (Class)AirportZoneDAO.class;
/*       */           }
/*       */         });
/*  7509 */     addObjectIds("AirportZone", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7511 */             return (Class)AirportZoneId.class;
/*       */           }
/*       */         });
/*  7514 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7516 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7517 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AirportZoneDetailPropertyId.class, false, false, true);
/*  7518 */           return rels;
/*       */         }
/*       */       };
/*  7521 */     addRelationshipProducer("dtv.xst.dao.com.impl.AirportZoneDetailDAO", relationshipProducer);
/*  7522 */     addDataModels("dtv.xst.dao.com.impl.AirportZoneDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7524 */             return (Class)AirportZoneDetailModel.class;
/*       */           }
/*       */         });
/*  7527 */     addInterfaces("dtv.xst.dao.com.IAirportZoneDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7529 */             return (Class)AirportZoneDetailModel.class;
/*       */           }
/*       */         });
/*  7532 */     addDaos("AirportZoneDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7534 */             return (Class)AirportZoneDetailDAO.class;
/*       */           }
/*       */         });
/*  7537 */     addObjectIds("AirportZoneDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7539 */             return (Class)AirportZoneDetailId.class;
/*       */           }
/*       */         });
/*  7542 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7544 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  7545 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("TieredFees", ShippingFeeTierId.class, false, false);
/*  7546 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShippingFeePropertyId.class, false, false, true);
/*  7547 */           return rels;
/*       */         }
/*       */       };
/*  7550 */     addRelationshipProducer("dtv.xst.dao.com.impl.ShippingFeeDAO", relationshipProducer);
/*  7551 */     addDataModels("dtv.xst.dao.com.impl.ShippingFeeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7553 */             return (Class)ShippingFeeModel.class;
/*       */           }
/*       */         });
/*  7556 */     addInterfaces("dtv.xst.dao.com.IShippingFee", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7558 */             return (Class)ShippingFeeModel.class;
/*       */           }
/*       */         });
/*  7561 */     addDaos("ShippingFee", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7563 */             return (Class)ShippingFeeDAO.class;
/*       */           }
/*       */         });
/*  7566 */     addObjectIds("ShippingFee", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7568 */             return (Class)ShippingFeeId.class;
/*       */           }
/*       */         });
/*  7571 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7573 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7574 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShippingFeeTierPropertyId.class, false, false, true);
/*  7575 */           return rels;
/*       */         }
/*       */       };
/*  7578 */     addRelationshipProducer("dtv.xst.dao.com.impl.ShippingFeeTierDAO", relationshipProducer);
/*  7579 */     addDataModels("dtv.xst.dao.com.impl.ShippingFeeTierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7581 */             return (Class)ShippingFeeTierModel.class;
/*       */           }
/*       */         });
/*  7584 */     addInterfaces("dtv.xst.dao.com.IShippingFeeTier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7586 */             return (Class)ShippingFeeTierModel.class;
/*       */           }
/*       */         });
/*  7589 */     addDaos("ShippingFeeTier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7591 */             return (Class)ShippingFeeTierDAO.class;
/*       */           }
/*       */         });
/*  7594 */     addObjectIds("ShippingFeeTier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7596 */             return (Class)ShippingFeeTierId.class;
/*       */           }
/*       */         });
/*  7599 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7601 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  7602 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("ResultItems", XunitResultItemId.class, false, false);
/*  7603 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", XunitResultPropertyId.class, false, false, true);
/*  7604 */           return rels;
/*       */         }
/*       */       };
/*  7607 */     addRelationshipProducer("dtv.xst.dao._test.impl.XunitResultDAO", relationshipProducer);
/*  7608 */     addDataModels("dtv.xst.dao._test.impl.XunitResultDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7610 */             return (Class)XunitResultModel.class;
/*       */           }
/*       */         });
/*  7613 */     addInterfaces("dtv.xst.dao._test.IXunitResult", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7615 */             return (Class)XunitResultModel.class;
/*       */           }
/*       */         });
/*  7618 */     addDaos("XunitResult", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7620 */             return (Class)XunitResultDAO.class;
/*       */           }
/*       */         });
/*  7623 */     addObjectIds("XunitResult", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7625 */             return (Class)XunitResultId.class;
/*       */           }
/*       */         });
/*  7628 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7630 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7631 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", XunitResultItemPropertyId.class, false, false, true);
/*  7632 */           return rels;
/*       */         }
/*       */       };
/*  7635 */     addRelationshipProducer("dtv.xst.dao._test.impl.XunitResultItemDAO", relationshipProducer);
/*  7636 */     addDataModels("dtv.xst.dao._test.impl.XunitResultItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7638 */             return (Class)XunitResultItemModel.class;
/*       */           }
/*       */         });
/*  7641 */     addInterfaces("dtv.xst.dao._test.IXunitResultItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7643 */             return (Class)XunitResultItemModel.class;
/*       */           }
/*       */         });
/*  7646 */     addDaos("XunitResultItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7648 */             return (Class)XunitResultItemDAO.class;
/*       */           }
/*       */         });
/*  7651 */     addObjectIds("XunitResultItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7653 */             return (Class)XunitResultItemId.class;
/*       */           }
/*       */         });
/*  7656 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7658 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  7659 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("PayrollCategory", PayrollCategoryId.class, false, false);
/*  7660 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", WorkCodesPropertyId.class, false, false, true);
/*  7661 */           return rels;
/*       */         }
/*       */       };
/*  7664 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.WorkCodesDAO", relationshipProducer);
/*  7665 */     addDataModels("dtv.xst.dao.hrs.impl.WorkCodesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7667 */             return (Class)WorkCodesModel.class;
/*       */           }
/*       */         });
/*  7670 */     addInterfaces("dtv.xst.dao.hrs.IWorkCodes", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7672 */             return (Class)WorkCodesModel.class;
/*       */           }
/*       */         });
/*  7675 */     addDaos("WorkCodes", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7677 */             return (Class)WorkCodesDAO.class;
/*       */           }
/*       */         });
/*  7680 */     addObjectIds("WorkCodes", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7682 */             return (Class)WorkCodesId.class;
/*       */           }
/*       */         });
/*  7685 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7687 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  7688 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Party", PartyId.class, true, false);
/*  7689 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("PrimaryGroup", GroupId.class, false, false);
/*  7690 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("WorkCode", WorkCodesId.class, false, false);
/*  7691 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("EmployeeStores", EmployeeStoreId.class, false, false);
/*  7692 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("EmployeeNotes", EmployeeNoteId.class, false, false);
/*  7693 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("EmployeeAnswers", EmployeeAnswersId.class, false, false);
/*  7694 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeePropertyId.class, false, false, true);
/*  7695 */           return rels;
/*       */         }
/*       */       };
/*  7698 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeDAO", relationshipProducer);
/*  7699 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7701 */             return (Class)EmployeeModel.class;
/*       */           }
/*       */         });
/*  7704 */     addInterfaces("dtv.xst.dao.hrs.IEmployee", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7706 */             return (Class)EmployeeModel.class;
/*       */           }
/*       */         });
/*  7709 */     addDaos("Employee", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7711 */             return (Class)EmployeeDAO.class;
/*       */           }
/*       */         });
/*  7714 */     addObjectIds("Employee", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7716 */             return (Class)EmployeeId.class;
/*       */           }
/*       */         });
/*  7719 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7721 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7722 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeFingerprintPropertyId.class, false, false, true);
/*  7723 */           return rels;
/*       */         }
/*       */       };
/*  7726 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeFingerprintDAO", relationshipProducer);
/*  7727 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeFingerprintDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7729 */             return (Class)EmployeeFingerprintModel.class;
/*       */           }
/*       */         });
/*  7732 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeFingerprint", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7734 */             return (Class)EmployeeFingerprintModel.class;
/*       */           }
/*       */         });
/*  7737 */     addDaos("EmployeeFingerprint", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7739 */             return (Class)EmployeeFingerprintDAO.class;
/*       */           }
/*       */         });
/*  7742 */     addObjectIds("EmployeeFingerprint", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7744 */             return (Class)EmployeeFingerprintId.class;
/*       */           }
/*       */         });
/*  7747 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7749 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7750 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeMessagePropertyId.class, false, false, true);
/*  7751 */           return rels;
/*       */         }
/*       */       };
/*  7754 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeMessageDAO", relationshipProducer);
/*  7755 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeMessageDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7757 */             return (Class)EmployeeMessageModel.class;
/*       */           }
/*       */         });
/*  7760 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeMessage", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7762 */             return (Class)EmployeeMessageModel.class;
/*       */           }
/*       */         });
/*  7765 */     addDaos("EmployeeMessage", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7767 */             return (Class)EmployeeMessageDAO.class;
/*       */           }
/*       */         });
/*  7770 */     addObjectIds("EmployeeMessage", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7772 */             return (Class)EmployeeMessageId.class;
/*       */           }
/*       */         });
/*  7775 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7777 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7778 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeAnswersPropertyId.class, false, false, true);
/*  7779 */           return rels;
/*       */         }
/*       */       };
/*  7782 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeAnswersDAO", relationshipProducer);
/*  7783 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeAnswersDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7785 */             return (Class)EmployeeAnswersModel.class;
/*       */           }
/*       */         });
/*  7788 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeAnswers", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7790 */             return (Class)EmployeeAnswersModel.class;
/*       */           }
/*       */         });
/*  7793 */     addDaos("EmployeeAnswers", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7795 */             return (Class)EmployeeAnswersDAO.class;
/*       */           }
/*       */         });
/*  7798 */     addObjectIds("EmployeeAnswers", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7800 */             return (Class)EmployeeAnswersId.class;
/*       */           }
/*       */         });
/*  7803 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7805 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  7806 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CreatorParty", PartyId.class, false, false);
/*  7807 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeNotePropertyId.class, false, false, true);
/*  7808 */           return rels;
/*       */         }
/*       */       };
/*  7811 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeNoteDAO", relationshipProducer);
/*  7812 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeNoteDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7814 */             return (Class)EmployeeNoteModel.class;
/*       */           }
/*       */         });
/*  7817 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeNote", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7819 */             return (Class)EmployeeNoteModel.class;
/*       */           }
/*       */         });
/*  7822 */     addDaos("EmployeeNote", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7824 */             return (Class)EmployeeNoteDAO.class;
/*       */           }
/*       */         });
/*  7827 */     addObjectIds("EmployeeNote", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7829 */             return (Class)EmployeeNoteId.class;
/*       */           }
/*       */         });
/*  7832 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7834 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7835 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeePasswordPropertyId.class, false, false, true);
/*  7836 */           return rels;
/*       */         }
/*       */       };
/*  7839 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeePasswordDAO", relationshipProducer);
/*  7840 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeePasswordDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7842 */             return (Class)EmployeePasswordModel.class;
/*       */           }
/*       */         });
/*  7845 */     addInterfaces("dtv.xst.dao.hrs.IEmployeePassword", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7847 */             return (Class)EmployeePasswordModel.class;
/*       */           }
/*       */         });
/*  7850 */     addDaos("EmployeePassword", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7852 */             return (Class)EmployeePasswordDAO.class;
/*       */           }
/*       */         });
/*  7855 */     addObjectIds("EmployeePassword", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7857 */             return (Class)EmployeePasswordId.class;
/*       */           }
/*       */         });
/*  7860 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7862 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7863 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeStorePropertyId.class, false, false, true);
/*  7864 */           return rels;
/*       */         }
/*       */       };
/*  7867 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeStoreDAO", relationshipProducer);
/*  7868 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeStoreDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7870 */             return (Class)EmployeeStoreModel.class;
/*       */           }
/*       */         });
/*  7873 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeStore", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7875 */             return (Class)EmployeeStoreModel.class;
/*       */           }
/*       */         });
/*  7878 */     addDaos("EmployeeStore", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7880 */             return (Class)EmployeeStoreDAO.class;
/*       */           }
/*       */         });
/*  7883 */     addObjectIds("EmployeeStore", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7885 */             return (Class)EmployeeStoreId.class;
/*       */           }
/*       */         });
/*  7888 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7890 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  7891 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CustomerParty", PartyId.class, false, false);
/*  7892 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("EmployeeTaskNotes", EmployeeTaskNoteId.class, false, false);
/*  7893 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeTaskPropertyId.class, false, false, true);
/*  7894 */           return rels;
/*       */         }
/*       */       };
/*  7897 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeTaskDAO", relationshipProducer);
/*  7898 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeTaskDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7900 */             return (Class)EmployeeTaskModel.class;
/*       */           }
/*       */         });
/*  7903 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeTask", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7905 */             return (Class)EmployeeTaskModel.class;
/*       */           }
/*       */         });
/*  7908 */     addDaos("EmployeeTask", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7910 */             return (Class)EmployeeTaskDAO.class;
/*       */           }
/*       */         });
/*  7913 */     addObjectIds("EmployeeTask", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7915 */             return (Class)EmployeeTaskId.class;
/*       */           }
/*       */         });
/*  7918 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7920 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  7921 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CreatorParty", PartyId.class, false, false);
/*  7922 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeTaskNotePropertyId.class, false, false, true);
/*  7923 */           return rels;
/*       */         }
/*       */       };
/*  7926 */     addRelationshipProducer("dtv.xst.dao.hrs.impl.EmployeeTaskNoteDAO", relationshipProducer);
/*  7927 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeTaskNoteDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7929 */             return (Class)EmployeeTaskNoteModel.class;
/*       */           }
/*       */         });
/*  7932 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeTaskNote", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7934 */             return (Class)EmployeeTaskNoteModel.class;
/*       */           }
/*       */         });
/*  7937 */     addDaos("EmployeeTaskNote", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7939 */             return (Class)EmployeeTaskNoteDAO.class;
/*       */           }
/*       */         });
/*  7942 */     addObjectIds("EmployeeTaskNote", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7944 */             return (Class)EmployeeTaskNoteId.class;
/*       */           }
/*       */         });
/*  7947 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7949 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  7950 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("RoleObjects", UserRoleId.class, false, false);
/*  7951 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", UserPasswordPropertyId.class, false, false, true);
/*  7952 */           return rels;
/*       */         }
/*       */       };
/*  7955 */     addRelationshipProducer("dtv.xst.dao.sec.impl.UserPasswordDAO", relationshipProducer);
/*  7956 */     addDataModels("dtv.xst.dao.sec.impl.UserPasswordDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7958 */             return (Class)UserPasswordModel.class;
/*       */           }
/*       */         });
/*  7961 */     addInterfaces("dtv.xst.dao.sec.IUserPassword", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7963 */             return (Class)UserPasswordModel.class;
/*       */           }
/*       */         });
/*  7966 */     addDaos("UserPassword", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7968 */             return (Class)UserPasswordDAO.class;
/*       */           }
/*       */         });
/*  7971 */     addObjectIds("UserPassword", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  7973 */             return (Class)UserPasswordId.class;
/*       */           }
/*       */         });
/*  7976 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  7978 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  7979 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", UserRolePropertyId.class, false, false, true);
/*  7980 */           return rels;
/*       */         }
/*       */       };
/*  7983 */     addRelationshipProducer("dtv.xst.dao.sec.impl.UserRoleDAO", relationshipProducer);
/*  7984 */     addDataModels("dtv.xst.dao.sec.impl.UserRoleDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  7986 */             return (Class)UserRoleModel.class;
/*       */           }
/*       */         });
/*  7989 */     addInterfaces("dtv.xst.dao.sec.IUserRole", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  7991 */             return (Class)UserRoleModel.class;
/*       */           }
/*       */         });
/*  7994 */     addDaos("UserRole", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  7996 */             return (Class)UserRoleDAO.class;
/*       */           }
/*       */         });
/*  7999 */     addObjectIds("UserRole", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8001 */             return (Class)UserRoleId.class;
/*       */           }
/*       */         });
/*  8004 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8006 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8007 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("AclEntries", AclAccessTypeId.class, false, false);
/*  8008 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", AccessControlListPropertyId.class, false, false, true);
/*  8009 */           return rels;
/*       */         }
/*       */       };
/*  8012 */     addRelationshipProducer("dtv.xst.dao.sec.impl.AccessControlListDAO", relationshipProducer);
/*  8013 */     addDataModels("dtv.xst.dao.sec.impl.AccessControlListDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8015 */             return (Class)AccessControlListModel.class;
/*       */           }
/*       */         });
/*  8018 */     addInterfaces("dtv.xst.dao.sec.IAccessControlList", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8020 */             return (Class)AccessControlListModel.class;
/*       */           }
/*       */         });
/*  8023 */     addDaos("AccessControlList", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8025 */             return (Class)AccessControlListDAO.class;
/*       */           }
/*       */         });
/*  8028 */     addObjectIds("AccessControlList", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8030 */             return (Class)AccessControlListId.class;
/*       */           }
/*       */         });
/*  8033 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8035 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8036 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", AclAccessTypePropertyId.class, false, false, true);
/*  8037 */           return rels;
/*       */         }
/*       */       };
/*  8040 */     addRelationshipProducer("dtv.xst.dao.sec.impl.AclAccessTypeDAO", relationshipProducer);
/*  8041 */     addDataModels("dtv.xst.dao.sec.impl.AclAccessTypeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8043 */             return (Class)AclAccessTypeModel.class;
/*       */           }
/*       */         });
/*  8046 */     addInterfaces("dtv.xst.dao.sec.IAclAccessType", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8048 */             return (Class)AclAccessTypeModel.class;
/*       */           }
/*       */         });
/*  8051 */     addDaos("AclAccessType", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8053 */             return (Class)AclAccessTypeDAO.class;
/*       */           }
/*       */         });
/*  8056 */     addObjectIds("AclAccessType", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8058 */             return (Class)AclAccessTypeId.class;
/*       */           }
/*       */         });
/*  8061 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8063 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8064 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", GroupPropertyId.class, false, false, true);
/*  8065 */           return rels;
/*       */         }
/*       */       };
/*  8068 */     addRelationshipProducer("dtv.xst.dao.sec.impl.GroupDAO", relationshipProducer);
/*  8069 */     addDataModels("dtv.xst.dao.sec.impl.GroupDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8071 */             return (Class)GroupModel.class;
/*       */           }
/*       */         });
/*  8074 */     addInterfaces("dtv.xst.dao.sec.IGroup", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8076 */             return (Class)GroupModel.class;
/*       */           }
/*       */         });
/*  8079 */     addDaos("Group", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8081 */             return (Class)GroupDAO.class;
/*       */           }
/*       */         });
/*  8084 */     addObjectIds("Group", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8086 */             return (Class)GroupId.class;
/*       */           }
/*       */         });
/*  8089 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8091 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8092 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", PrivilegePropertyId.class, false, false, true);
/*  8093 */           return rels;
/*       */         }
/*       */       };
/*  8096 */     addRelationshipProducer("dtv.xst.dao.sec.impl.PrivilegeDAO", relationshipProducer);
/*  8097 */     addDataModels("dtv.xst.dao.sec.impl.PrivilegeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8099 */             return (Class)PrivilegeModel.class;
/*       */           }
/*       */         });
/*  8102 */     addInterfaces("dtv.xst.dao.sec.IPrivilege", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8104 */             return (Class)PrivilegeModel.class;
/*       */           }
/*       */         });
/*  8107 */     addDaos("Privilege", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8109 */             return (Class)PrivilegeDAO.class;
/*       */           }
/*       */         });
/*  8112 */     addObjectIds("Privilege", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8114 */             return (Class)PrivilegeId.class;
/*       */           }
/*       */         });
/*  8117 */     addDataModels("dtv.xst.dao.sec.impl.SecurityLogDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8119 */             return (Class)SecurityLogModel.class;
/*       */           }
/*       */         });
/*  8122 */     addInterfaces("dtv.xst.dao.sec.ISecurityLog", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8124 */             return (Class)SecurityLogModel.class;
/*       */           }
/*       */         });
/*  8127 */     addDaos("SecurityLog", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8129 */             return (Class)SecurityLogDAO.class;
/*       */           }
/*       */         });
/*  8132 */     addObjectIds("SecurityLog", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8134 */             return (Class)SecurityLogId.class;
/*       */           }
/*       */         });
/*  8137 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8139 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8140 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CartonPropertyId.class, false, false, true);
/*  8141 */           return rels;
/*       */         }
/*       */       };
/*  8144 */     addRelationshipProducer("dtv.xst.dao.inv.impl.CartonDAO", relationshipProducer);
/*  8145 */     addDataModels("dtv.xst.dao.inv.impl.CartonDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8147 */             return (Class)CartonModel.class;
/*       */           }
/*       */         });
/*  8150 */     addInterfaces("dtv.xst.dao.inv.ICarton", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8152 */             return (Class)CartonModel.class;
/*       */           }
/*       */         });
/*  8155 */     addDaos("Carton", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8157 */             return (Class)CartonDAO.class;
/*       */           }
/*       */         });
/*  8160 */     addObjectIds("Carton", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8162 */             return (Class)CartonId.class;
/*       */           }
/*       */         });
/*  8165 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8167 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  8168 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentLineItems", InventoryDocumentLineItemId.class, false, false);
/*  8169 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Shipments", ShipmentId.class, false, false);
/*  8170 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Cartons", CartonId.class, false, false);
/*  8171 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("Notes", DocumentNoteId.class, false, false);
/*  8172 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("OriginatorAddress", AddressId.class, false, false);
/*  8173 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryDocumentPropertyId.class, false, false, true);
/*  8174 */           return rels;
/*       */         }
/*       */       };
/*  8177 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryDocumentDAO", relationshipProducer);
/*  8178 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8180 */             return (Class)InventoryDocumentModel.class;
/*       */           }
/*       */         });
/*  8183 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocument", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8185 */             return (Class)InventoryDocumentModel.class;
/*       */           }
/*       */         });
/*  8188 */     addDaos("InventoryDocument", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8190 */             return (Class)InventoryDocumentDAO.class;
/*       */           }
/*       */         });
/*  8193 */     addObjectIds("InventoryDocument", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8195 */             return (Class)InventoryDocumentId.class;
/*       */           }
/*       */         });
/*  8198 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8200 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  8201 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CustomerItemAccountMod", InventoryItemAccountModifierId.class, true, false);
/*  8202 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("SerialNumbers", InventoryDocumentLineSerialId.class, false, false);
/*  8203 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("DocumentInventoryLocationModifiers", DocumentInventoryLocationModifierId.class, false, false);
/*  8204 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("InventoryReplenishmentDocumentLineItem", InventoryReplenishmentDocumentLineItemId.class, true, false);
/*  8205 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Notes", DocumentLineItemNoteId.class, false, false);
/*  8206 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("InventoryLineCrossReference", InventoryDocumentCrossReferenceId.class, true, false);
/*  8207 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryDocumentLineItemPropertyId.class, false, false, true);
/*  8208 */           return rels;
/*       */         }
/*       */       };
/*  8211 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO", relationshipProducer);
/*  8212 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8214 */             return (Class)InventoryDocumentLineItemModel.class;
/*       */           }
/*       */         });
/*  8217 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8219 */             return (Class)InventoryDocumentLineItemModel.class;
/*       */           }
/*       */         });
/*  8222 */     addDaos("InventoryDocumentLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8224 */             return (Class)InventoryDocumentLineItemDAO.class;
/*       */           }
/*       */         });
/*  8227 */     addObjectIds("InventoryDocumentLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8229 */             return (Class)InventoryDocumentLineItemId.class;
/*       */           }
/*       */         });
/*  8232 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8234 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8235 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("InventoryDocumentLineItem", InventoryDocumentLineItemId.class, false, false);
/*  8236 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryTransactionDetailPropertyId.class, false, false, true);
/*  8237 */           return rels;
/*       */         }
/*       */       };
/*  8240 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryTransactionDetailDAO", relationshipProducer);
/*  8241 */     addDataModels("dtv.xst.dao.inv.impl.InventoryTransactionDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8243 */             return (Class)InventoryTransactionDetailModel.class;
/*       */           }
/*       */         });
/*  8246 */     addInterfaces("dtv.xst.dao.inv.IInventoryTransactionDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8248 */             return (Class)InventoryTransactionDetailModel.class;
/*       */           }
/*       */         });
/*  8251 */     addDaos("InventoryTransactionDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8253 */             return (Class)InventoryTransactionDetailDAO.class;
/*       */           }
/*       */         });
/*  8256 */     addObjectIds("InventoryTransactionDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8258 */             return (Class)InventoryTransactionDetailId.class;
/*       */           }
/*       */         });
/*  8261 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8263 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8264 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("InventoryCountBuckets", InventoryCountBucketId.class, false, false);
/*  8265 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountPropertyId.class, false, false, true);
/*  8266 */           return rels;
/*       */         }
/*       */       };
/*  8269 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountDAO", relationshipProducer);
/*  8270 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8272 */             return (Class)InventoryCountModel.class;
/*       */           }
/*       */         });
/*  8275 */     addInterfaces("dtv.xst.dao.inv.IInventoryCount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8277 */             return (Class)InventoryCountModel.class;
/*       */           }
/*       */         });
/*  8280 */     addDaos("InventoryCount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8282 */             return (Class)InventoryCountDAO.class;
/*       */           }
/*       */         });
/*  8285 */     addObjectIds("InventoryCount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8287 */             return (Class)InventoryCountId.class;
/*       */           }
/*       */         });
/*  8290 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8292 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8293 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("SectionDetails", InventoryCountSectionDetailId.class, false, false);
/*  8294 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountSectionPropertyId.class, false, false, true);
/*  8295 */           return rels;
/*       */         }
/*       */       };
/*  8298 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountSectionDAO", relationshipProducer);
/*  8299 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSectionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8301 */             return (Class)InventoryCountSectionModel.class;
/*       */           }
/*       */         });
/*  8304 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSection", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8306 */             return (Class)InventoryCountSectionModel.class;
/*       */           }
/*       */         });
/*  8309 */     addDaos("InventoryCountSection", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8311 */             return (Class)InventoryCountSectionDAO.class;
/*       */           }
/*       */         });
/*  8314 */     addObjectIds("InventoryCountSection", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8316 */             return (Class)InventoryCountSectionId.class;
/*       */           }
/*       */         });
/*  8319 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8321 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8322 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("CountSheetLineItems", InventoryCountSheetLineItemId.class, false, false);
/*  8323 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountSheetPropertyId.class, false, false, true);
/*  8324 */           return rels;
/*       */         }
/*       */       };
/*  8327 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountSheetDAO", relationshipProducer);
/*  8328 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSheetDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8330 */             return (Class)InventoryCountSheetModel.class;
/*       */           }
/*       */         });
/*  8333 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSheet", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8335 */             return (Class)InventoryCountSheetModel.class;
/*       */           }
/*       */         });
/*  8338 */     addDaos("InventoryCountSheet", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8340 */             return (Class)InventoryCountSheetDAO.class;
/*       */           }
/*       */         });
/*  8343 */     addObjectIds("InventoryCountSheet", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8345 */             return (Class)InventoryCountSheetId.class;
/*       */           }
/*       */         });
/*  8348 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8350 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  8351 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("InventoryLocationBuckets", InventoryLocationBucketId.class, false, false);
/*  8352 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("AvailabilityCodes", InventoryLocationAvailabilityId.class, false, false);
/*  8353 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryLocationPropertyId.class, false, false, true);
/*  8354 */           return rels;
/*       */         }
/*       */       };
/*  8357 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryLocationDAO", relationshipProducer);
/*  8358 */     addDataModels("dtv.xst.dao.inv.impl.InventoryLocationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8360 */             return (Class)InventoryLocationModel.class;
/*       */           }
/*       */         });
/*  8363 */     addInterfaces("dtv.xst.dao.inv.IInventoryLocation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8365 */             return (Class)InventoryLocationModel.class;
/*       */           }
/*       */         });
/*  8368 */     addDaos("InventoryLocation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8370 */             return (Class)InventoryLocationDAO.class;
/*       */           }
/*       */         });
/*  8373 */     addObjectIds("InventoryLocation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8375 */             return (Class)InventoryLocationId.class;
/*       */           }
/*       */         });
/*  8378 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8380 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  8381 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("MovementPendingDetails", InventoryMovementPendingDetailId.class, false, false);
/*  8382 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, false);
/*  8383 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("SaleLineItem", RetailTransactionLineItemId.class, false, false);
/*  8384 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("InventoryTransactionDetail", InventoryTransactionDetailId.class, false, false);
/*  8385 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryMovementPendingPropertyId.class, false, false, true);
/*  8386 */           return rels;
/*       */         }
/*       */       };
/*  8389 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO", relationshipProducer);
/*  8390 */     addDataModels("dtv.xst.dao.inv.impl.InventoryMovementPendingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8392 */             return (Class)InventoryMovementPendingModel.class;
/*       */           }
/*       */         });
/*  8395 */     addInterfaces("dtv.xst.dao.inv.IInventoryMovementPending", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8397 */             return (Class)InventoryMovementPendingModel.class;
/*       */           }
/*       */         });
/*  8400 */     addDaos("InventoryMovementPending", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8402 */             return (Class)InventoryMovementPendingDAO.class;
/*       */           }
/*       */         });
/*  8405 */     addObjectIds("InventoryMovementPending", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8407 */             return (Class)InventoryMovementPendingId.class;
/*       */           }
/*       */         });
/*  8410 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8412 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8413 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("InventoryMovementPending", InventoryMovementPendingId.class, false, false);
/*  8414 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", MovementPendingTransactionLineItemPropertyId.class, false, false, true);
/*  8415 */           return rels;
/*       */         }
/*       */       };
/*  8418 */     addRelationshipProducer("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemDAO", relationshipProducer);
/*  8419 */     addDataModels("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8421 */             return (Class)MovementPendingTransactionLineItemModel.class;
/*       */           }
/*       */         });
/*  8424 */     addInterfaces("dtv.xst.dao.inv.IMovementPendingTransactionLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8426 */             return (Class)MovementPendingTransactionLineItemModel.class;
/*       */           }
/*       */         });
/*  8429 */     addDaos("MovementPendingTransactionLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8431 */             return (Class)MovementPendingTransactionLineItemDAO.class;
/*       */           }
/*       */         });
/*  8434 */     addObjectIds("MovementPendingTransactionLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8436 */             return (Class)MovementPendingTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  8439 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8441 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  8442 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("DestinationParty", PartyId.class, true, false);
/*  8443 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("DestinationRetailLocation", RetailLocationId.class, false, false);
/*  8444 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("Address", ShipmentAddressId.class, false, false);
/*  8445 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("ShipmentLineItems", ShipmentLineItemId.class, false, false);
/*  8446 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShipmentPropertyId.class, false, false, true);
/*  8447 */           return rels;
/*       */         }
/*       */       };
/*  8450 */     addRelationshipProducer("dtv.xst.dao.inv.impl.ShipmentDAO", relationshipProducer);
/*  8451 */     addDataModels("dtv.xst.dao.inv.impl.ShipmentDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8453 */             return (Class)ShipmentModel.class;
/*       */           }
/*       */         });
/*  8456 */     addInterfaces("dtv.xst.dao.inv.IShipment", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8458 */             return (Class)ShipmentModel.class;
/*       */           }
/*       */         });
/*  8461 */     addDaos("Shipment", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8463 */             return (Class)ShipmentDAO.class;
/*       */           }
/*       */         });
/*  8466 */     addObjectIds("Shipment", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8468 */             return (Class)ShipmentId.class;
/*       */           }
/*       */         });
/*  8471 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8473 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8474 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShipmentLineItemPropertyId.class, false, false, true);
/*  8475 */           return rels;
/*       */         }
/*       */       };
/*  8478 */     addRelationshipProducer("dtv.xst.dao.inv.impl.ShipmentLineItemDAO", relationshipProducer);
/*  8479 */     addDataModels("dtv.xst.dao.inv.impl.ShipmentLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8481 */             return (Class)ShipmentLineItemModel.class;
/*       */           }
/*       */         });
/*  8484 */     addInterfaces("dtv.xst.dao.inv.IShipmentLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8486 */             return (Class)ShipmentLineItemModel.class;
/*       */           }
/*       */         });
/*  8489 */     addDaos("ShipmentLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8491 */             return (Class)ShipmentLineItemDAO.class;
/*       */           }
/*       */         });
/*  8494 */     addObjectIds("ShipmentLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8496 */             return (Class)ShipmentLineItemId.class;
/*       */           }
/*       */         });
/*  8499 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8501 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8502 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShipmentAddressPropertyId.class, false, false, true);
/*  8503 */           return rels;
/*       */         }
/*       */       };
/*  8506 */     addRelationshipProducer("dtv.xst.dao.inv.impl.ShipmentAddressDAO", relationshipProducer);
/*  8507 */     addDataModels("dtv.xst.dao.inv.impl.ShipmentAddressDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8509 */             return (Class)ShipmentAddressModel.class;
/*       */           }
/*       */         });
/*  8512 */     addInterfaces("dtv.xst.dao.inv.IShipmentAddress", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8514 */             return (Class)ShipmentAddressModel.class;
/*       */           }
/*       */         });
/*  8517 */     addDaos("ShipmentAddress", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8519 */             return (Class)ShipmentAddressDAO.class;
/*       */           }
/*       */         });
/*  8522 */     addObjectIds("ShipmentAddress", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8524 */             return (Class)ShipmentAddressId.class;
/*       */           }
/*       */         });
/*  8527 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8529 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8530 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryItemAccountModifierPropertyId.class, false, false, true);
/*  8531 */           return rels;
/*       */         }
/*       */       };
/*  8534 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryItemAccountModifierDAO", relationshipProducer);
/*  8535 */     addDataModels("dtv.xst.dao.inv.impl.InventoryItemAccountModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8537 */             return (Class)InventoryItemAccountModifierModel.class;
/*       */           }
/*       */         });
/*  8540 */     addInterfaces("dtv.xst.dao.inv.IInventoryItemAccountModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8542 */             return (Class)InventoryItemAccountModifierModel.class;
/*       */           }
/*       */         });
/*  8545 */     addDaos("InventoryItemAccountModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8547 */             return (Class)InventoryItemAccountModifierDAO.class;
/*       */           }
/*       */         });
/*  8550 */     addObjectIds("InventoryItemAccountModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8552 */             return (Class)InventoryItemAccountModifierId.class;
/*       */           }
/*       */         });
/*  8555 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8557 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8558 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DocumentInventoryLocationModifierPropertyId.class, false, false, true);
/*  8559 */           return rels;
/*       */         }
/*       */       };
/*  8562 */     addRelationshipProducer("dtv.xst.dao.inv.impl.DocumentInventoryLocationModifierDAO", relationshipProducer);
/*  8563 */     addDataModels("dtv.xst.dao.inv.impl.DocumentInventoryLocationModifierDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8565 */             return (Class)DocumentInventoryLocationModifierModel.class;
/*       */           }
/*       */         });
/*  8568 */     addInterfaces("dtv.xst.dao.inv.IDocumentInventoryLocationModifier", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8570 */             return (Class)DocumentInventoryLocationModifierModel.class;
/*       */           }
/*       */         });
/*  8573 */     addDaos("DocumentInventoryLocationModifier", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8575 */             return (Class)DocumentInventoryLocationModifierDAO.class;
/*       */           }
/*       */         });
/*  8578 */     addObjectIds("DocumentInventoryLocationModifier", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8580 */             return (Class)DocumentInventoryLocationModifierId.class;
/*       */           }
/*       */         });
/*  8583 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8585 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8586 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CreatorParty", PartyId.class, false, false);
/*  8587 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", DocumentNotePropertyId.class, false, false, true);
/*  8588 */           return rels;
/*       */         }
/*       */       };
/*  8591 */     addRelationshipProducer("dtv.xst.dao.inv.impl.DocumentNoteDAO", relationshipProducer);
/*  8592 */     addDataModels("dtv.xst.dao.inv.impl.DocumentNoteDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8594 */             return (Class)DocumentNoteModel.class;
/*       */           }
/*       */         });
/*  8597 */     addInterfaces("dtv.xst.dao.inv.IDocumentNote", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8599 */             return (Class)DocumentNoteModel.class;
/*       */           }
/*       */         });
/*  8602 */     addDaos("DocumentNote", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8604 */             return (Class)DocumentNoteDAO.class;
/*       */           }
/*       */         });
/*  8607 */     addObjectIds("DocumentNote", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8609 */             return (Class)DocumentNoteId.class;
/*       */           }
/*       */         });
/*  8612 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8614 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8615 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", FiscalYearPropertyId.class, false, false, true);
/*  8616 */           return rels;
/*       */         }
/*       */       };
/*  8619 */     addRelationshipProducer("dtv.xst.dao.inv.impl.FiscalYearDAO", relationshipProducer);
/*  8620 */     addDataModels("dtv.xst.dao.inv.impl.FiscalYearDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8622 */             return (Class)FiscalYearModel.class;
/*       */           }
/*       */         });
/*  8625 */     addInterfaces("dtv.xst.dao.inv.IFiscalYear", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8627 */             return (Class)FiscalYearModel.class;
/*       */           }
/*       */         });
/*  8630 */     addDaos("FiscalYear", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8632 */             return (Class)FiscalYearDAO.class;
/*       */           }
/*       */         });
/*  8635 */     addObjectIds("FiscalYear", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8637 */             return (Class)FiscalYearId.class;
/*       */           }
/*       */         });
/*  8640 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8642 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8643 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryBucketPropertyId.class, false, false, true);
/*  8644 */           return rels;
/*       */         }
/*       */       };
/*  8647 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryBucketDAO", relationshipProducer);
/*  8648 */     addDataModels("dtv.xst.dao.inv.impl.InventoryBucketDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8650 */             return (Class)InventoryBucketModel.class;
/*       */           }
/*       */         });
/*  8653 */     addInterfaces("dtv.xst.dao.inv.IInventoryBucket", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8655 */             return (Class)InventoryBucketModel.class;
/*       */           }
/*       */         });
/*  8658 */     addDaos("InventoryBucket", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8660 */             return (Class)InventoryBucketDAO.class;
/*       */           }
/*       */         });
/*  8663 */     addObjectIds("InventoryBucket", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8665 */             return (Class)InventoryBucketId.class;
/*       */           }
/*       */         });
/*  8668 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8670 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8671 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryDocumentCrossReferencePropertyId.class, false, false, true);
/*  8672 */           return rels;
/*       */         }
/*       */       };
/*  8675 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryDocumentCrossReferenceDAO", relationshipProducer);
/*  8676 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentCrossReferenceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8678 */             return (Class)InventoryDocumentCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  8681 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentCrossReference", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8683 */             return (Class)InventoryDocumentCrossReferenceModel.class;
/*       */           }
/*       */         });
/*  8686 */     addDaos("InventoryDocumentCrossReference", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8688 */             return (Class)InventoryDocumentCrossReferenceDAO.class;
/*       */           }
/*       */         });
/*  8691 */     addObjectIds("InventoryDocumentCrossReference", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8693 */             return (Class)InventoryDocumentCrossReferenceId.class;
/*       */           }
/*       */         });
/*  8696 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8698 */           IDataModelRelationship[] rels = new IDataModelRelationship[7];
/*  8699 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  8700 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  8701 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  8702 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  8703 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  8704 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("InventoryDocument", InventoryDocumentId.class, false, false);
/*  8705 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryTransactionDetails", InventoryTransactionDetailId.class, false, false);
/*  8706 */           return rels;
/*       */         }
/*       */       };
/*  8709 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryTransactionDAO", relationshipProducer);
/*  8710 */     addDataModels("dtv.xst.dao.inv.impl.InventoryTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8712 */             return (Class)InventoryTransactionModel.class;
/*       */           }
/*       */         });
/*  8715 */     addInterfaces("dtv.xst.dao.inv.IInventoryTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8717 */             return (Class)InventoryTransactionModel.class;
/*       */           }
/*       */         });
/*  8720 */     addDaos("InventoryTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8722 */             return (Class)InventoryTransactionDAO.class;
/*       */           }
/*       */         });
/*  8725 */     addObjectIds("InventoryTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8727 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  8730 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8732 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8733 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCostItemYearEndPropertyId.class, false, false, true);
/*  8734 */           return rels;
/*       */         }
/*       */       };
/*  8737 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCostItemYearEndDAO", relationshipProducer);
/*  8738 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCostItemYearEndDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8740 */             return (Class)InventoryCostItemYearEndModel.class;
/*       */           }
/*       */         });
/*  8743 */     addInterfaces("dtv.xst.dao.inv.IInventoryCostItemYearEnd", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8745 */             return (Class)InventoryCostItemYearEndModel.class;
/*       */           }
/*       */         });
/*  8748 */     addDaos("InventoryCostItemYearEnd", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8750 */             return (Class)InventoryCostItemYearEndDAO.class;
/*       */           }
/*       */         });
/*  8753 */     addObjectIds("InventoryCostItemYearEnd", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8755 */             return (Class)InventoryCostItemYearEndId.class;
/*       */           }
/*       */         });
/*  8758 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8760 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8761 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountBucketPropertyId.class, false, false, true);
/*  8762 */           return rels;
/*       */         }
/*       */       };
/*  8765 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountBucketDAO", relationshipProducer);
/*  8766 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountBucketDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8768 */             return (Class)InventoryCountBucketModel.class;
/*       */           }
/*       */         });
/*  8771 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountBucket", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8773 */             return (Class)InventoryCountBucketModel.class;
/*       */           }
/*       */         });
/*  8776 */     addDaos("InventoryCountBucket", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8778 */             return (Class)InventoryCountBucketDAO.class;
/*       */           }
/*       */         });
/*  8781 */     addObjectIds("InventoryCountBucket", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8783 */             return (Class)InventoryCountBucketId.class;
/*       */           }
/*       */         });
/*  8786 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8788 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8789 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountSectionDetailPropertyId.class, false, false, true);
/*  8790 */           return rels;
/*       */         }
/*       */       };
/*  8793 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountSectionDetailDAO", relationshipProducer);
/*  8794 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSectionDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8796 */             return (Class)InventoryCountSectionDetailModel.class;
/*       */           }
/*       */         });
/*  8799 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSectionDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8801 */             return (Class)InventoryCountSectionDetailModel.class;
/*       */           }
/*       */         });
/*  8804 */     addDaos("InventoryCountSectionDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8806 */             return (Class)InventoryCountSectionDetailDAO.class;
/*       */           }
/*       */         });
/*  8809 */     addObjectIds("InventoryCountSectionDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8811 */             return (Class)InventoryCountSectionDetailId.class;
/*       */           }
/*       */         });
/*  8814 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8816 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8817 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountSheetLineItemPropertyId.class, false, false, true);
/*  8818 */           return rels;
/*       */         }
/*       */       };
/*  8821 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountSheetLineItemDAO", relationshipProducer);
/*  8822 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSheetLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8824 */             return (Class)InventoryCountSheetLineItemModel.class;
/*       */           }
/*       */         });
/*  8827 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSheetLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8829 */             return (Class)InventoryCountSheetLineItemModel.class;
/*       */           }
/*       */         });
/*  8832 */     addDaos("InventoryCountSheetLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8834 */             return (Class)InventoryCountSheetLineItemDAO.class;
/*       */           }
/*       */         });
/*  8837 */     addObjectIds("InventoryCountSheetLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8839 */             return (Class)InventoryCountSheetLineItemId.class;
/*       */           }
/*       */         });
/*  8842 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8844 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8845 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryCountSnapshotPropertyId.class, false, false, true);
/*  8846 */           return rels;
/*       */         }
/*       */       };
/*  8849 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryCountSnapshotDAO", relationshipProducer);
/*  8850 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSnapshotDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8852 */             return (Class)InventoryCountSnapshotModel.class;
/*       */           }
/*       */         });
/*  8855 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSnapshot", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8857 */             return (Class)InventoryCountSnapshotModel.class;
/*       */           }
/*       */         });
/*  8860 */     addDaos("InventoryCountSnapshot", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8862 */             return (Class)InventoryCountSnapshotDAO.class;
/*       */           }
/*       */         });
/*  8865 */     addObjectIds("InventoryCountSnapshot", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8867 */             return (Class)InventoryCountSnapshotId.class;
/*       */           }
/*       */         });
/*  8870 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8872 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8873 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryJournalPropertyId.class, false, false, true);
/*  8874 */           return rels;
/*       */         }
/*       */       };
/*  8877 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryJournalDAO", relationshipProducer);
/*  8878 */     addDataModels("dtv.xst.dao.inv.impl.InventoryJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8880 */             return (Class)InventoryJournalModel.class;
/*       */           }
/*       */         });
/*  8883 */     addInterfaces("dtv.xst.dao.inv.IInventoryJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8885 */             return (Class)InventoryJournalModel.class;
/*       */           }
/*       */         });
/*  8888 */     addDaos("InventoryJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8890 */             return (Class)InventoryJournalDAO.class;
/*       */           }
/*       */         });
/*  8893 */     addObjectIds("InventoryJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8895 */             return (Class)InventoryJournalId.class;
/*       */           }
/*       */         });
/*  8898 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8900 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8901 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Privilege", PrivilegeId.class, false, false);
/*  8902 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryLocationAvailabilityPropertyId.class, false, false, true);
/*  8903 */           return rels;
/*       */         }
/*       */       };
/*  8906 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityDAO", relationshipProducer);
/*  8907 */     addDataModels("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8909 */             return (Class)InventoryLocationAvailabilityModel.class;
/*       */           }
/*       */         });
/*  8912 */     addInterfaces("dtv.xst.dao.inv.IInventoryLocationAvailability", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8914 */             return (Class)InventoryLocationAvailabilityModel.class;
/*       */           }
/*       */         });
/*  8917 */     addDaos("InventoryLocationAvailability", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8919 */             return (Class)InventoryLocationAvailabilityDAO.class;
/*       */           }
/*       */         });
/*  8922 */     addObjectIds("InventoryLocationAvailability", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8924 */             return (Class)InventoryLocationAvailabilityId.class;
/*       */           }
/*       */         });
/*  8927 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8929 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  8930 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("InventoryBucket", InventoryBucketId.class, false, false);
/*  8931 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryLocationBucketPropertyId.class, false, false, true);
/*  8932 */           return rels;
/*       */         }
/*       */       };
/*  8935 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryLocationBucketDAO", relationshipProducer);
/*  8936 */     addDataModels("dtv.xst.dao.inv.impl.InventoryLocationBucketDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8938 */             return (Class)InventoryLocationBucketModel.class;
/*       */           }
/*       */         });
/*  8941 */     addInterfaces("dtv.xst.dao.inv.IInventoryLocationBucket", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8943 */             return (Class)InventoryLocationBucketModel.class;
/*       */           }
/*       */         });
/*  8946 */     addDaos("InventoryLocationBucket", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8948 */             return (Class)InventoryLocationBucketDAO.class;
/*       */           }
/*       */         });
/*  8951 */     addObjectIds("InventoryLocationBucket", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8953 */             return (Class)InventoryLocationBucketId.class;
/*       */           }
/*       */         });
/*  8956 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8958 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  8959 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryMovementPendingDetailPropertyId.class, false, false, true);
/*  8960 */           return rels;
/*       */         }
/*       */       };
/*  8963 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryMovementPendingDetailDAO", relationshipProducer);
/*  8964 */     addDataModels("dtv.xst.dao.inv.impl.InventoryMovementPendingDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8966 */             return (Class)InventoryMovementPendingDetailModel.class;
/*       */           }
/*       */         });
/*  8969 */     addInterfaces("dtv.xst.dao.inv.IInventoryMovementPendingDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  8971 */             return (Class)InventoryMovementPendingDetailModel.class;
/*       */           }
/*       */         });
/*  8974 */     addDaos("InventoryMovementPendingDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  8976 */             return (Class)InventoryMovementPendingDetailDAO.class;
/*       */           }
/*       */         });
/*  8979 */     addObjectIds("InventoryMovementPendingDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  8981 */             return (Class)InventoryMovementPendingDetailId.class;
/*       */           }
/*       */         });
/*  8984 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  8986 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  8987 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  8988 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  8989 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  8990 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  8991 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  8992 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("InventorySummaryCountTransactionDetails", InventorySummaryCountTransactionDetailId.class, false, false);
/*  8993 */           return rels;
/*       */         }
/*       */       };
/*  8996 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDAO", relationshipProducer);
/*  8997 */     addDataModels("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  8999 */             return (Class)InventorySummaryCountTransactionModel.class;
/*       */           }
/*       */         });
/*  9002 */     addInterfaces("dtv.xst.dao.inv.IInventorySummaryCountTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9004 */             return (Class)InventorySummaryCountTransactionModel.class;
/*       */           }
/*       */         });
/*  9007 */     addDaos("InventorySummaryCountTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9009 */             return (Class)InventorySummaryCountTransactionDAO.class;
/*       */           }
/*       */         });
/*  9012 */     addObjectIds("InventorySummaryCountTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9014 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  9017 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9019 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9020 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventorySummaryCountTransactionDetailPropertyId.class, false, false, true);
/*  9021 */           return rels;
/*       */         }
/*       */       };
/*  9024 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailDAO", relationshipProducer);
/*  9025 */     addDataModels("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9027 */             return (Class)InventorySummaryCountTransactionDetailModel.class;
/*       */           }
/*       */         });
/*  9030 */     addInterfaces("dtv.xst.dao.inv.IInventorySummaryCountTransactionDetail", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9032 */             return (Class)InventorySummaryCountTransactionDetailModel.class;
/*       */           }
/*       */         });
/*  9035 */     addDaos("InventorySummaryCountTransactionDetail", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9037 */             return (Class)InventorySummaryCountTransactionDetailDAO.class;
/*       */           }
/*       */         });
/*  9040 */     addObjectIds("InventorySummaryCountTransactionDetail", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9042 */             return (Class)InventorySummaryCountTransactionDetailId.class;
/*       */           }
/*       */         });
/*  9045 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9047 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9048 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryValidDestinationsPropertyId.class, false, false, true);
/*  9049 */           return rels;
/*       */         }
/*       */       };
/*  9052 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryValidDestinationsDAO", relationshipProducer);
/*  9053 */     addDataModels("dtv.xst.dao.inv.impl.InventoryValidDestinationsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9055 */             return (Class)InventoryValidDestinationsModel.class;
/*       */           }
/*       */         });
/*  9058 */     addInterfaces("dtv.xst.dao.inv.IInventoryValidDestinations", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9060 */             return (Class)InventoryValidDestinationsModel.class;
/*       */           }
/*       */         });
/*  9063 */     addDaos("InventoryValidDestinations", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9065 */             return (Class)InventoryValidDestinationsDAO.class;
/*       */           }
/*       */         });
/*  9068 */     addObjectIds("InventoryValidDestinations", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9070 */             return (Class)InventoryValidDestinationsId.class;
/*       */           }
/*       */         });
/*  9073 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9075 */           IDataModelRelationship[] rels = new IDataModelRelationship[6];
/*  9076 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("OperatorParty", PartyId.class, true, false);
/*  9077 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("RetailTransactionLineItems", RetailTransactionLineItemId.class, false, false);
/*  9078 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("TransactionLinks", PosTransactionLinkId.class, false, false);
/*  9079 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("TransactionNotes", TransactionNotesId.class, false, false);
/*  9080 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", PosTransactionPropertyId.class, false, false, true);
/*  9081 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("MovementPendingTransactionLineItems", MovementPendingTransactionLineItemId.class, false, false);
/*  9082 */           return rels;
/*       */         }
/*       */       };
/*  9085 */     addRelationshipProducer("dtv.xst.dao.inv.impl.MovementPendingTransactionDAO", relationshipProducer);
/*  9086 */     addDataModels("dtv.xst.dao.inv.impl.MovementPendingTransactionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9088 */             return (Class)MovementPendingTransactionModel.class;
/*       */           }
/*       */         });
/*  9091 */     addInterfaces("dtv.xst.dao.inv.IMovementPendingTransaction", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9093 */             return (Class)MovementPendingTransactionModel.class;
/*       */           }
/*       */         });
/*  9096 */     addDaos("MovementPendingTransaction", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9098 */             return (Class)MovementPendingTransactionDAO.class;
/*       */           }
/*       */         });
/*  9101 */     addObjectIds("MovementPendingTransaction", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9103 */             return (Class)PosTransactionId.class;
/*       */           }
/*       */         });
/*  9106 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9108 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9109 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SerializedStockLedgerPropertyId.class, false, false, true);
/*  9110 */           return rels;
/*       */         }
/*       */       };
/*  9113 */     addRelationshipProducer("dtv.xst.dao.inv.impl.SerializedStockLedgerDAO", relationshipProducer);
/*  9114 */     addDataModels("dtv.xst.dao.inv.impl.SerializedStockLedgerDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9116 */             return (Class)SerializedStockLedgerModel.class;
/*       */           }
/*       */         });
/*  9119 */     addInterfaces("dtv.xst.dao.inv.ISerializedStockLedger", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9121 */             return (Class)SerializedStockLedgerModel.class;
/*       */           }
/*       */         });
/*  9124 */     addDaos("SerializedStockLedger", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9126 */             return (Class)SerializedStockLedgerDAO.class;
/*       */           }
/*       */         });
/*  9129 */     addObjectIds("SerializedStockLedger", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9131 */             return (Class)SerializedStockLedgerId.class;
/*       */           }
/*       */         });
/*  9134 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9136 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9137 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShipperPropertyId.class, false, false, true);
/*  9138 */           return rels;
/*       */         }
/*       */       };
/*  9141 */     addRelationshipProducer("dtv.xst.dao.inv.impl.ShipperDAO", relationshipProducer);
/*  9142 */     addDataModels("dtv.xst.dao.inv.impl.ShipperDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9144 */             return (Class)ShipperModel.class;
/*       */           }
/*       */         });
/*  9147 */     addInterfaces("dtv.xst.dao.inv.IShipper", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9149 */             return (Class)ShipperModel.class;
/*       */           }
/*       */         });
/*  9152 */     addDaos("Shipper", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9154 */             return (Class)ShipperDAO.class;
/*       */           }
/*       */         });
/*  9157 */     addObjectIds("Shipper", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9159 */             return (Class)ShipperId.class;
/*       */           }
/*       */         });
/*  9162 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9164 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9165 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShipperMethodPropertyId.class, false, false, true);
/*  9166 */           return rels;
/*       */         }
/*       */       };
/*  9169 */     addRelationshipProducer("dtv.xst.dao.inv.impl.ShipperMethodDAO", relationshipProducer);
/*  9170 */     addDataModels("dtv.xst.dao.inv.impl.ShipperMethodDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9172 */             return (Class)ShipperMethodModel.class;
/*       */           }
/*       */         });
/*  9175 */     addInterfaces("dtv.xst.dao.inv.IShipperMethod", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9177 */             return (Class)ShipperMethodModel.class;
/*       */           }
/*       */         });
/*  9180 */     addDaos("ShipperMethod", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9182 */             return (Class)ShipperMethodDAO.class;
/*       */           }
/*       */         });
/*  9185 */     addObjectIds("ShipperMethod", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9187 */             return (Class)ShipperMethodId.class;
/*       */           }
/*       */         });
/*  9190 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9192 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9193 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", StockLedgerPropertyId.class, false, false, true);
/*  9194 */           return rels;
/*       */         }
/*       */       };
/*  9197 */     addRelationshipProducer("dtv.xst.dao.inv.impl.StockLedgerDAO", relationshipProducer);
/*  9198 */     addDataModels("dtv.xst.dao.inv.impl.StockLedgerDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9200 */             return (Class)StockLedgerModel.class;
/*       */           }
/*       */         });
/*  9203 */     addInterfaces("dtv.xst.dao.inv.IStockLedger", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9205 */             return (Class)StockLedgerModel.class;
/*       */           }
/*       */         });
/*  9208 */     addDaos("StockLedger", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9210 */             return (Class)StockLedgerDAO.class;
/*       */           }
/*       */         });
/*  9213 */     addObjectIds("StockLedger", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9215 */             return (Class)StockLedgerId.class;
/*       */           }
/*       */         });
/*  9218 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9220 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  9221 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CreatorParty", PartyId.class, false, false);
/*  9222 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", DocumentLineItemNotePropertyId.class, false, false, true);
/*  9223 */           return rels;
/*       */         }
/*       */       };
/*  9226 */     addRelationshipProducer("dtv.xst.dao.inv.impl.DocumentLineItemNoteDAO", relationshipProducer);
/*  9227 */     addDataModels("dtv.xst.dao.inv.impl.DocumentLineItemNoteDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9229 */             return (Class)DocumentLineItemNoteModel.class;
/*       */           }
/*       */         });
/*  9232 */     addInterfaces("dtv.xst.dao.inv.IDocumentLineItemNote", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9234 */             return (Class)DocumentLineItemNoteModel.class;
/*       */           }
/*       */         });
/*  9237 */     addDaos("DocumentLineItemNote", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9239 */             return (Class)DocumentLineItemNoteDAO.class;
/*       */           }
/*       */         });
/*  9242 */     addObjectIds("DocumentLineItemNote", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9244 */             return (Class)DocumentLineItemNoteId.class;
/*       */           }
/*       */         });
/*  9247 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9249 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9250 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryDocumentLineSerialPropertyId.class, false, false, true);
/*  9251 */           return rels;
/*       */         }
/*       */       };
/*  9254 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryDocumentLineSerialDAO", relationshipProducer);
/*  9255 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentLineSerialDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9257 */             return (Class)InventoryDocumentLineSerialModel.class;
/*       */           }
/*       */         });
/*  9260 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentLineSerial", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9262 */             return (Class)InventoryDocumentLineSerialModel.class;
/*       */           }
/*       */         });
/*  9265 */     addDaos("InventoryDocumentLineSerial", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9267 */             return (Class)InventoryDocumentLineSerialDAO.class;
/*       */           }
/*       */         });
/*  9270 */     addObjectIds("InventoryDocumentLineSerial", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9272 */             return (Class)InventoryDocumentLineSerialId.class;
/*       */           }
/*       */         });
/*  9275 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9277 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9278 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InventoryReplenishmentDocumentLineItemPropertyId.class, false, false, true);
/*  9279 */           return rels;
/*       */         }
/*       */       };
/*  9282 */     addRelationshipProducer("dtv.xst.dao.inv.impl.InventoryReplenishmentDocumentLineItemDAO", relationshipProducer);
/*  9283 */     addDataModels("dtv.xst.dao.inv.impl.InventoryReplenishmentDocumentLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9285 */             return (Class)InventoryReplenishmentDocumentLineItemModel.class;
/*       */           }
/*       */         });
/*  9288 */     addInterfaces("dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9290 */             return (Class)InventoryReplenishmentDocumentLineItemModel.class;
/*       */           }
/*       */         });
/*  9293 */     addDaos("InventoryReplenishmentDocumentLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9295 */             return (Class)InventoryReplenishmentDocumentLineItemDAO.class;
/*       */           }
/*       */         });
/*  9298 */     addObjectIds("InventoryReplenishmentDocumentLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9300 */             return (Class)InventoryReplenishmentDocumentLineItemId.class;
/*       */           }
/*       */         });
/*  9303 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9305 */           IDataModelRelationship[] rels = new IDataModelRelationship[5];
/*  9306 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("CompatibleDiscounts", DiscountCompatabilityId.class, false, false);
/*  9307 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("ValidSaleLineItemTypeCodes", DiscountTypeEligibilityId.class, false, false);
/*  9308 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("CustomerGroups", DiscountGroupMappingId.class, false, false);
/*  9309 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("Privilege", PrivilegeId.class, false, false);
/*  9310 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", DiscountPropertyId.class, false, false, true);
/*  9311 */           return rels;
/*       */         }
/*       */       };
/*  9314 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.DiscountDAO", relationshipProducer);
/*  9315 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9317 */             return (Class)DiscountModel.class;
/*       */           }
/*       */         });
/*  9320 */     addInterfaces("dtv.xst.dao.dsc.IDiscount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9322 */             return (Class)DiscountModel.class;
/*       */           }
/*       */         });
/*  9325 */     addDaos("Discount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9327 */             return (Class)DiscountDAO.class;
/*       */           }
/*       */         });
/*  9330 */     addObjectIds("Discount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9332 */             return (Class)DiscountId.class;
/*       */           }
/*       */         });
/*  9335 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9337 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  9338 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CouponDiscount", DiscountId.class, false, false);
/*  9339 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Tender", TenderId.class, false, false);
/*  9340 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", CouponPropertyId.class, false, false, true);
/*  9341 */           return rels;
/*       */         }
/*       */       };
/*  9344 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.CouponDAO", relationshipProducer);
/*  9345 */     addDataModels("dtv.xst.dao.dsc.impl.CouponDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9347 */             return (Class)CouponModel.class;
/*       */           }
/*       */         });
/*  9350 */     addInterfaces("dtv.xst.dao.dsc.ICoupon", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9352 */             return (Class)CouponModel.class;
/*       */           }
/*       */         });
/*  9355 */     addDaos("Coupon", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9357 */             return (Class)CouponDAO.class;
/*       */           }
/*       */         });
/*  9360 */     addObjectIds("Coupon", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9362 */             return (Class)CouponId.class;
/*       */           }
/*       */         });
/*  9365 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9367 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9368 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DiscountCompatabilityPropertyId.class, false, false, true);
/*  9369 */           return rels;
/*       */         }
/*       */       };
/*  9372 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.DiscountCompatabilityDAO", relationshipProducer);
/*  9373 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountCompatabilityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9375 */             return (Class)DiscountCompatabilityModel.class;
/*       */           }
/*       */         });
/*  9378 */     addInterfaces("dtv.xst.dao.dsc.IDiscountCompatability", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9380 */             return (Class)DiscountCompatabilityModel.class;
/*       */           }
/*       */         });
/*  9383 */     addDaos("DiscountCompatability", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9385 */             return (Class)DiscountCompatabilityDAO.class;
/*       */           }
/*       */         });
/*  9388 */     addObjectIds("DiscountCompatability", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9390 */             return (Class)DiscountCompatabilityId.class;
/*       */           }
/*       */         });
/*  9393 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9395 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9396 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DiscountGroupMappingPropertyId.class, false, false, true);
/*  9397 */           return rels;
/*       */         }
/*       */       };
/*  9400 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.DiscountGroupMappingDAO", relationshipProducer);
/*  9401 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountGroupMappingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9403 */             return (Class)DiscountGroupMappingModel.class;
/*       */           }
/*       */         });
/*  9406 */     addInterfaces("dtv.xst.dao.dsc.IDiscountGroupMapping", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9408 */             return (Class)DiscountGroupMappingModel.class;
/*       */           }
/*       */         });
/*  9411 */     addDaos("DiscountGroupMapping", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9413 */             return (Class)DiscountGroupMappingDAO.class;
/*       */           }
/*       */         });
/*  9416 */     addObjectIds("DiscountGroupMapping", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9418 */             return (Class)DiscountGroupMappingId.class;
/*       */           }
/*       */         });
/*  9421 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9423 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9424 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DiscountItemExclusionsPropertyId.class, false, false, true);
/*  9425 */           return rels;
/*       */         }
/*       */       };
/*  9428 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.DiscountItemExclusionsDAO", relationshipProducer);
/*  9429 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountItemExclusionsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9431 */             return (Class)DiscountItemExclusionsModel.class;
/*       */           }
/*       */         });
/*  9434 */     addInterfaces("dtv.xst.dao.dsc.IDiscountItemExclusions", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9436 */             return (Class)DiscountItemExclusionsModel.class;
/*       */           }
/*       */         });
/*  9439 */     addDaos("DiscountItemExclusions", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9441 */             return (Class)DiscountItemExclusionsDAO.class;
/*       */           }
/*       */         });
/*  9444 */     addObjectIds("DiscountItemExclusions", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9446 */             return (Class)DiscountItemExclusionsId.class;
/*       */           }
/*       */         });
/*  9449 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9451 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9452 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DiscountItemInclusionsPropertyId.class, false, false, true);
/*  9453 */           return rels;
/*       */         }
/*       */       };
/*  9456 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.DiscountItemInclusionsDAO", relationshipProducer);
/*  9457 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountItemInclusionsDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9459 */             return (Class)DiscountItemInclusionsModel.class;
/*       */           }
/*       */         });
/*  9462 */     addInterfaces("dtv.xst.dao.dsc.IDiscountItemInclusions", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9464 */             return (Class)DiscountItemInclusionsModel.class;
/*       */           }
/*       */         });
/*  9467 */     addDaos("DiscountItemInclusions", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9469 */             return (Class)DiscountItemInclusionsDAO.class;
/*       */           }
/*       */         });
/*  9472 */     addObjectIds("DiscountItemInclusions", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9474 */             return (Class)DiscountItemInclusionsId.class;
/*       */           }
/*       */         });
/*  9477 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9479 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9480 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DiscountTypeEligibilityPropertyId.class, false, false, true);
/*  9481 */           return rels;
/*       */         }
/*       */       };
/*  9484 */     addRelationshipProducer("dtv.xst.dao.dsc.impl.DiscountTypeEligibilityDAO", relationshipProducer);
/*  9485 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountTypeEligibilityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9487 */             return (Class)DiscountTypeEligibilityModel.class;
/*       */           }
/*       */         });
/*  9490 */     addInterfaces("dtv.xst.dao.dsc.IDiscountTypeEligibility", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9492 */             return (Class)DiscountTypeEligibilityModel.class;
/*       */           }
/*       */         });
/*  9495 */     addDaos("DiscountTypeEligibility", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9497 */             return (Class)DiscountTypeEligibilityDAO.class;
/*       */           }
/*       */         });
/*  9500 */     addObjectIds("DiscountTypeEligibility", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9502 */             return (Class)DiscountTypeEligibilityId.class;
/*       */           }
/*       */         });
/*  9505 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9507 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  9508 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("InvoiceServiceLocation", ServiceLocationId.class, false, false);
/*  9509 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("LineItems", InvoiceLineItemId.class, false, false);
/*  9510 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", InvoicePropertyId.class, false, false, true);
/*  9511 */           return rels;
/*       */         }
/*       */       };
/*  9514 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.InvoiceDAO", relationshipProducer);
/*  9515 */     addDataModels("dtv.xst.dao.cwo.impl.InvoiceDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9517 */             return (Class)InvoiceModel.class;
/*       */           }
/*       */         });
/*  9520 */     addInterfaces("dtv.xst.dao.cwo.IInvoice", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9522 */             return (Class)InvoiceModel.class;
/*       */           }
/*       */         });
/*  9525 */     addDaos("Invoice", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9527 */             return (Class)InvoiceDAO.class;
/*       */           }
/*       */         });
/*  9530 */     addObjectIds("Invoice", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9532 */             return (Class)InvoiceId.class;
/*       */           }
/*       */         });
/*  9535 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9537 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9538 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WorkItemPropertyId.class, false, false, true);
/*  9539 */           return rels;
/*       */         }
/*       */       };
/*  9542 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkItemDAO", relationshipProducer);
/*  9543 */     addDataModels("dtv.xst.dao.cwo.impl.WorkItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9545 */             return (Class)WorkItemModel.class;
/*       */           }
/*       */         });
/*  9548 */     addInterfaces("dtv.xst.dao.cwo.IWorkItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9550 */             return (Class)WorkItemModel.class;
/*       */           }
/*       */         });
/*  9553 */     addDaos("WorkItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9555 */             return (Class)WorkItemDAO.class;
/*       */           }
/*       */         });
/*  9558 */     addObjectIds("WorkItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9560 */             return (Class)WorkItemId.class;
/*       */           }
/*       */         });
/*  9563 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9565 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  9566 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CategoryServiceLocation", ServiceLocationId.class, false, false);
/*  9567 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", CategoryServiceLocationPropertyId.class, false, false, true);
/*  9568 */           return rels;
/*       */         }
/*       */       };
/*  9571 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.CategoryServiceLocationDAO", relationshipProducer);
/*  9572 */     addDataModels("dtv.xst.dao.cwo.impl.CategoryServiceLocationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9574 */             return (Class)CategoryServiceLocationModel.class;
/*       */           }
/*       */         });
/*  9577 */     addInterfaces("dtv.xst.dao.cwo.ICategoryServiceLocation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9579 */             return (Class)CategoryServiceLocationModel.class;
/*       */           }
/*       */         });
/*  9582 */     addDaos("CategoryServiceLocation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9584 */             return (Class)CategoryServiceLocationDAO.class;
/*       */           }
/*       */         });
/*  9587 */     addObjectIds("CategoryServiceLocation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9589 */             return (Class)CategoryServiceLocationId.class;
/*       */           }
/*       */         });
/*  9592 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9594 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9595 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", InvoiceLineItemPropertyId.class, false, false, true);
/*  9596 */           return rels;
/*       */         }
/*       */       };
/*  9599 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.InvoiceLineItemDAO", relationshipProducer);
/*  9600 */     addDataModels("dtv.xst.dao.cwo.impl.InvoiceLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9602 */             return (Class)InvoiceLineItemModel.class;
/*       */           }
/*       */         });
/*  9605 */     addInterfaces("dtv.xst.dao.cwo.IInvoiceLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9607 */             return (Class)InvoiceLineItemModel.class;
/*       */           }
/*       */         });
/*  9610 */     addDaos("InvoiceLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9612 */             return (Class)InvoiceLineItemDAO.class;
/*       */           }
/*       */         });
/*  9615 */     addObjectIds("InvoiceLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9617 */             return (Class)InvoiceLineItemId.class;
/*       */           }
/*       */         });
/*  9620 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9622 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  9623 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Address", AddressId.class, false, false);
/*  9624 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", ServiceLocationPropertyId.class, false, false, true);
/*  9625 */           return rels;
/*       */         }
/*       */       };
/*  9628 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.ServiceLocationDAO", relationshipProducer);
/*  9629 */     addDataModels("dtv.xst.dao.cwo.impl.ServiceLocationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9631 */             return (Class)ServiceLocationModel.class;
/*       */           }
/*       */         });
/*  9634 */     addInterfaces("dtv.xst.dao.cwo.IServiceLocation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9636 */             return (Class)ServiceLocationModel.class;
/*       */           }
/*       */         });
/*  9639 */     addDaos("ServiceLocation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9641 */             return (Class)ServiceLocationDAO.class;
/*       */           }
/*       */         });
/*  9644 */     addObjectIds("ServiceLocation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9646 */             return (Class)ServiceLocationId.class;
/*       */           }
/*       */         });
/*  9649 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9651 */           IDataModelRelationship[] rels = new IDataModelRelationship[9];
/*  9652 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("ItemOptions", ItemOptionsId.class, false, false);
/*  9653 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("ParentItem", ItemId.class, false, false);
/*  9654 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("ItemDealProperties", ItemDealPropertyId.class, false, false);
/*  9655 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("ItemPromptProperties", ItemPromptPropertyId.class, false, false);
/*  9656 */           rels[4] = (IDataModelRelationship)new OneToOneRelationship("ItemLabelProperties", ItemLabelPropertiesId.class, false, false);
/*  9657 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("ItemImages", ItemImageId.class, false, false);
/*  9658 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionTypes", ItemDimensionTypeId.class, false, false);
/*  9659 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("ItemDimensionValues", ItemDimensionValueId.class, false, false);
/*  9660 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("Properties", ItemPropertyId.class, false, false, true);
/*  9661 */           return rels;
/*       */         }
/*       */       };
/*  9664 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.TaskDAO", relationshipProducer);
/*  9665 */     addDataModels("dtv.xst.dao.cwo.impl.TaskDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9667 */             return (Class)TaskModel.class;
/*       */           }
/*       */         });
/*  9670 */     addInterfaces("dtv.xst.dao.cwo.ITask", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9672 */             return (Class)TaskModel.class;
/*       */           }
/*       */         });
/*  9675 */     addDaos("Task", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9677 */             return (Class)TaskDAO.class;
/*       */           }
/*       */         });
/*  9680 */     addObjectIds("Task", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9682 */             return (Class)ItemId.class;
/*       */           }
/*       */         });
/*  9685 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9687 */           IDataModelRelationship[] rels = new IDataModelRelationship[11];
/*  9688 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Journals", CustomerAccountJournalId.class, false, false);
/*  9689 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("PaymentSchedule", PaymentScheduleId.class, false, false);
/*  9690 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("RetailLocation", RetailLocationId.class, false, false);
/*  9691 */           rels[3] = (IDataModelRelationship)new OneToManyRelationship("CustAccountNotes", CustomerAccountNoteId.class, false, false);
/*  9692 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountPropertyId.class, false, false, true);
/*  9693 */           rels[5] = (IDataModelRelationship)new OneToOneRelationship("DeliveryModifier", DeliveryModifierId.class, false, false);
/*  9694 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("CustItemAccountDetails", CustomerItemAccountDetailId.class, false, false);
/*  9695 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("WorkItemsRelationship", WorkItemId.class, false, false);
/*  9696 */           rels[8] = (IDataModelRelationship)new OneToOneRelationship("WorkOrderAccountServiceLocation", ServiceLocationId.class, false, false);
/*  9697 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("WorkOrderAccountCategory", WorkOrderCategoryId.class, false, false);
/*  9698 */           rels[10] = (IDataModelRelationship)new OneToOneRelationship("WorkOrderAccountPriceCode", WorkOrderPriceCodeId.class, false, false);
/*  9699 */           return rels;
/*       */         }
/*       */       };
/*  9702 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO", relationshipProducer);
/*  9703 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderAccountDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9705 */             return (Class)WorkOrderAccountModel.class;
/*       */           }
/*       */         });
/*  9708 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderAccount", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9710 */             return (Class)WorkOrderAccountModel.class;
/*       */           }
/*       */         });
/*  9713 */     addDaos("WorkOrderAccount", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9715 */             return (Class)WorkOrderAccountDAO.class;
/*       */           }
/*       */         });
/*  9718 */     addObjectIds("WorkOrderAccount", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9720 */             return (Class)CustomerAccountId.class;
/*       */           }
/*       */         });
/*  9723 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9725 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/*  9726 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", CustomerAccountJournalPropertyId.class, false, false, true);
/*  9727 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("WorkOrderAccountJournalPriceCode", WorkOrderPriceCodeId.class, false, false);
/*  9728 */           rels[2] = (IDataModelRelationship)new OneToOneRelationship("WorkOrderAccountJournalCategory", WorkOrderCategoryId.class, false, false);
/*  9729 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("WorkOrderAccountJournalServiceLocation", ServiceLocationId.class, false, false);
/*  9730 */           return rels;
/*       */         }
/*       */       };
/*  9733 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkOrderAccountJournalDAO", relationshipProducer);
/*  9734 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderAccountJournalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9736 */             return (Class)WorkOrderAccountJournalModel.class;
/*       */           }
/*       */         });
/*  9739 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderAccountJournal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9741 */             return (Class)WorkOrderAccountJournalModel.class;
/*       */           }
/*       */         });
/*  9744 */     addDaos("WorkOrderAccountJournal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9746 */             return (Class)WorkOrderAccountJournalDAO.class;
/*       */           }
/*       */         });
/*  9749 */     addObjectIds("WorkOrderAccountJournal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9751 */             return (Class)CustomerAccountJournalId.class;
/*       */           }
/*       */         });
/*  9754 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9756 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9757 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WorkOrderCategoryPropertyId.class, false, false, true);
/*  9758 */           return rels;
/*       */         }
/*       */       };
/*  9761 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkOrderCategoryDAO", relationshipProducer);
/*  9762 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderCategoryDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9764 */             return (Class)WorkOrderCategoryModel.class;
/*       */           }
/*       */         });
/*  9767 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderCategory", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9769 */             return (Class)WorkOrderCategoryModel.class;
/*       */           }
/*       */         });
/*  9772 */     addDaos("WorkOrderCategory", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9774 */             return (Class)WorkOrderCategoryDAO.class;
/*       */           }
/*       */         });
/*  9777 */     addObjectIds("WorkOrderCategory", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9779 */             return (Class)WorkOrderCategoryId.class;
/*       */           }
/*       */         });
/*  9782 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9784 */           IDataModelRelationship[] rels = new IDataModelRelationship[17];
/*  9785 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/*  9786 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/*  9787 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/*  9788 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("BaseReturnedQuantity", ReturnedItemCountId.class, false, false);
/*  9789 */           rels[4] = (IDataModelRelationship)new OneToManyRelationship("CommissionModifiers", CommissionModifierId.class, false, false);
/*  9790 */           rels[5] = (IDataModelRelationship)new OneToManyRelationship("DimensionModifiers", DimensionModifierId.class, false, false);
/*  9791 */           rels[6] = (IDataModelRelationship)new OneToManyRelationship("InventoryDocumentLineItems", InventoryDocumentLineItemId.class, false, false);
/*  9792 */           rels[7] = (IDataModelRelationship)new OneToManyRelationship("LineItemAssociationModifiers", LineItemAssociationModifierId.class, false, false);
/*  9793 */           rels[8] = (IDataModelRelationship)new OneToManyRelationship("RetailPriceModifiers", RetailPriceModifierId.class, false, false);
/*  9794 */           rels[9] = (IDataModelRelationship)new OneToOneRelationship("TaxGroup", TaxGroupId.class, false, true);
/*  9795 */           rels[10] = (IDataModelRelationship)new OneToManyRelationship("TaxModifiers", SaleTaxModifierId.class, false, false);
/*  9796 */           rels[11] = (IDataModelRelationship)new OneToOneRelationship("CustomerAccountModifier", CustomerItemAccountModifierId.class, false, false);
/*  9797 */           rels[12] = (IDataModelRelationship)new OneToOneRelationship("Item", ItemId.class, false, true);
/*  9798 */           rels[13] = (IDataModelRelationship)new OneToManyRelationship("NoteSeq", RetailTransactionLineItemNotesId.class, false, false);
/*  9799 */           rels[14] = (IDataModelRelationship)new OneToManyRelationship("RetailInventoryLocationModifiers", RetailInventoryLocationModifierId.class, false, false);
/*  9800 */           rels[15] = (IDataModelRelationship)new OneToOneRelationship("OrderModifier", OrderModifierId.class, true, false);
/*  9801 */           rels[16] = (IDataModelRelationship)new OneToManyRelationship("KitComponentModifiers", KitComponentModifierId.class, false, false);
/*  9802 */           return rels;
/*       */         }
/*       */       };
/*  9805 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkOrderLineItemDAO", relationshipProducer);
/*  9806 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9808 */             return (Class)WorkOrderLineItemModel.class;
/*       */           }
/*       */         });
/*  9811 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9813 */             return (Class)WorkOrderLineItemModel.class;
/*       */           }
/*       */         });
/*  9816 */     addDaos("WorkOrderLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9818 */             return (Class)WorkOrderLineItemDAO.class;
/*       */           }
/*       */         });
/*  9821 */     addObjectIds("WorkOrderLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9823 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/*  9826 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9828 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9829 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WorkOrderPriceCodePropertyId.class, false, false, true);
/*  9830 */           return rels;
/*       */         }
/*       */       };
/*  9833 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkOrderPriceCodeDAO", relationshipProducer);
/*  9834 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderPriceCodeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9836 */             return (Class)WorkOrderPriceCodeModel.class;
/*       */           }
/*       */         });
/*  9839 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderPriceCode", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9841 */             return (Class)WorkOrderPriceCodeModel.class;
/*       */           }
/*       */         });
/*  9844 */     addDaos("WorkOrderPriceCode", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9846 */             return (Class)WorkOrderPriceCodeDAO.class;
/*       */           }
/*       */         });
/*  9849 */     addObjectIds("WorkOrderPriceCode", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9851 */             return (Class)WorkOrderPriceCodeId.class;
/*       */           }
/*       */         });
/*  9854 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9856 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9857 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", WorkOrderPricingPropertyId.class, false, false, true);
/*  9858 */           return rels;
/*       */         }
/*       */       };
/*  9861 */     addRelationshipProducer("dtv.xst.dao.cwo.impl.WorkOrderPricingDAO", relationshipProducer);
/*  9862 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderPricingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9864 */             return (Class)WorkOrderPricingModel.class;
/*       */           }
/*       */         });
/*  9867 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderPricing", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9869 */             return (Class)WorkOrderPricingModel.class;
/*       */           }
/*       */         });
/*  9872 */     addDaos("WorkOrderPricing", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9874 */             return (Class)WorkOrderPricingDAO.class;
/*       */           }
/*       */         });
/*  9877 */     addObjectIds("WorkOrderPricing", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9879 */             return (Class)WorkOrderPricingId.class;
/*       */           }
/*       */         });
/*  9882 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9884 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9885 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxAuthorityPropertyId.class, false, false, true);
/*  9886 */           return rels;
/*       */         }
/*       */       };
/*  9889 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxAuthorityDAO", relationshipProducer);
/*  9890 */     addDataModels("dtv.xst.dao.tax.impl.TaxAuthorityDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9892 */             return (Class)TaxAuthorityModel.class;
/*       */           }
/*       */         });
/*  9895 */     addInterfaces("dtv.xst.dao.tax.ITaxAuthority", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9897 */             return (Class)TaxAuthorityModel.class;
/*       */           }
/*       */         });
/*  9900 */     addDaos("TaxAuthority", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9902 */             return (Class)TaxAuthorityDAO.class;
/*       */           }
/*       */         });
/*  9905 */     addObjectIds("TaxAuthority", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9907 */             return (Class)TaxAuthorityId.class;
/*       */           }
/*       */         });
/*  9910 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9912 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/*  9913 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("TaxCode", TaxCodeId.class, false, false);
/*  9914 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxGroupPropertyId.class, false, false, true);
/*  9915 */           return rels;
/*       */         }
/*       */       };
/*  9918 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxGroupDAO", relationshipProducer);
/*  9919 */     addDataModels("dtv.xst.dao.tax.impl.TaxGroupDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9921 */             return (Class)TaxGroupModel.class;
/*       */           }
/*       */         });
/*  9924 */     addInterfaces("dtv.xst.dao.tax.ITaxGroup", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9926 */             return (Class)TaxGroupModel.class;
/*       */           }
/*       */         });
/*  9929 */     addDaos("TaxGroup", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9931 */             return (Class)TaxGroupDAO.class;
/*       */           }
/*       */         });
/*  9934 */     addObjectIds("TaxGroup", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9936 */             return (Class)TaxGroupId.class;
/*       */           }
/*       */         });
/*  9939 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9941 */           IDataModelRelationship[] rels = new IDataModelRelationship[3];
/*  9942 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("TaxAuthority", TaxAuthorityId.class, false, false);
/*  9943 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("TaxRateRules", TaxRateRuleId.class, false, false);
/*  9944 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxGroupRulePropertyId.class, false, false, true);
/*  9945 */           return rels;
/*       */         }
/*       */       };
/*  9948 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxGroupRuleDAO", relationshipProducer);
/*  9949 */     addDataModels("dtv.xst.dao.tax.impl.TaxGroupRuleDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9951 */             return (Class)TaxGroupRuleModel.class;
/*       */           }
/*       */         });
/*  9954 */     addInterfaces("dtv.xst.dao.tax.ITaxGroupRule", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9956 */             return (Class)TaxGroupRuleModel.class;
/*       */           }
/*       */         });
/*  9959 */     addDaos("TaxGroupRule", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9961 */             return (Class)TaxGroupRuleDAO.class;
/*       */           }
/*       */         });
/*  9964 */     addObjectIds("TaxGroupRule", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9966 */             return (Class)TaxGroupRuleId.class;
/*       */           }
/*       */         });
/*  9969 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9971 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/*  9972 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxLocationPropertyId.class, false, false, true);
/*  9973 */           return rels;
/*       */         }
/*       */       };
/*  9976 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxLocationDAO", relationshipProducer);
/*  9977 */     addDataModels("dtv.xst.dao.tax.impl.TaxLocationDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/*  9979 */             return (Class)TaxLocationModel.class;
/*       */           }
/*       */         });
/*  9982 */     addInterfaces("dtv.xst.dao.tax.ITaxLocation", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/*  9984 */             return (Class)TaxLocationModel.class;
/*       */           }
/*       */         });
/*  9987 */     addDaos("TaxLocation", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/*  9989 */             return (Class)TaxLocationDAO.class;
/*       */           }
/*       */         });
/*  9992 */     addObjectIds("TaxLocation", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/*  9994 */             return (Class)TaxLocationId.class;
/*       */           }
/*       */         });
/*  9997 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/*  9999 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10000 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxRateRulePropertyId.class, false, false, true);
/* 10001 */           return rels;
/*       */         }
/*       */       };
/* 10004 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxRateRuleDAO", relationshipProducer);
/* 10005 */     addDataModels("dtv.xst.dao.tax.impl.TaxRateRuleDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10007 */             return (Class)TaxRateRuleModel.class;
/*       */           }
/*       */         });
/* 10010 */     addInterfaces("dtv.xst.dao.tax.ITaxRateRule", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10012 */             return (Class)TaxRateRuleModel.class;
/*       */           }
/*       */         });
/* 10015 */     addDaos("TaxRateRule", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10017 */             return (Class)TaxRateRuleDAO.class;
/*       */           }
/*       */         });
/* 10020 */     addObjectIds("TaxRateRule", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10022 */             return (Class)TaxRateRuleId.class;
/*       */           }
/*       */         });
/* 10025 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10027 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10028 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxCodePropertyId.class, false, false, true);
/* 10029 */           return rels;
/*       */         }
/*       */       };
/* 10032 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxCodeDAO", relationshipProducer);
/* 10033 */     addDataModels("dtv.xst.dao.tax.impl.TaxCodeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10035 */             return (Class)TaxCodeModel.class;
/*       */           }
/*       */         });
/* 10038 */     addInterfaces("dtv.xst.dao.tax.ITaxCode", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10040 */             return (Class)TaxCodeModel.class;
/*       */           }
/*       */         });
/* 10043 */     addDaos("TaxCode", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10045 */             return (Class)TaxCodeDAO.class;
/*       */           }
/*       */         });
/* 10048 */     addObjectIds("TaxCode", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10050 */             return (Class)TaxCodeId.class;
/*       */           }
/*       */         });
/* 10053 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10055 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/* 10056 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("PostalTaxLocation", TaxLocationId.class, false, false);
/* 10057 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", PostalCodeMappingPropertyId.class, false, false, true);
/* 10058 */           return rels;
/*       */         }
/*       */       };
/* 10061 */     addRelationshipProducer("dtv.xst.dao.tax.impl.PostalCodeMappingDAO", relationshipProducer);
/* 10062 */     addDataModels("dtv.xst.dao.tax.impl.PostalCodeMappingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10064 */             return (Class)PostalCodeMappingModel.class;
/*       */           }
/*       */         });
/* 10067 */     addInterfaces("dtv.xst.dao.tax.IPostalCodeMapping", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10069 */             return (Class)PostalCodeMappingModel.class;
/*       */           }
/*       */         });
/* 10072 */     addDaos("PostalCodeMapping", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10074 */             return (Class)PostalCodeMappingDAO.class;
/*       */           }
/*       */         });
/* 10077 */     addObjectIds("PostalCodeMapping", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10079 */             return (Class)PostalCodeMappingId.class;
/*       */           }
/*       */         });
/* 10082 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10084 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/* 10085 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("TaxLocation", TaxLocationId.class, false, false);
/* 10086 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailLocationTaxMappingPropertyId.class, false, false, true);
/* 10087 */           return rels;
/*       */         }
/*       */       };
/* 10090 */     addRelationshipProducer("dtv.xst.dao.tax.impl.RetailLocationTaxMappingDAO", relationshipProducer);
/* 10091 */     addDataModels("dtv.xst.dao.tax.impl.RetailLocationTaxMappingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10093 */             return (Class)RetailLocationTaxMappingModel.class;
/*       */           }
/*       */         });
/* 10096 */     addInterfaces("dtv.xst.dao.tax.IRetailLocationTaxMapping", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10098 */             return (Class)RetailLocationTaxMappingModel.class;
/*       */           }
/*       */         });
/* 10101 */     addDaos("RetailLocationTaxMapping", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10103 */             return (Class)RetailLocationTaxMappingDAO.class;
/*       */           }
/*       */         });
/* 10106 */     addObjectIds("RetailLocationTaxMapping", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10108 */             return (Class)RetailLocationTaxMappingId.class;
/*       */           }
/*       */         });
/* 10111 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10113 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10114 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxBracketPropertyId.class, false, false, true);
/* 10115 */           return rels;
/*       */         }
/*       */       };
/* 10118 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxBracketDAO", relationshipProducer);
/* 10119 */     addDataModels("dtv.xst.dao.tax.impl.TaxBracketDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10121 */             return (Class)TaxBracketModel.class;
/*       */           }
/*       */         });
/* 10124 */     addInterfaces("dtv.xst.dao.tax.ITaxBracket", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10126 */             return (Class)TaxBracketModel.class;
/*       */           }
/*       */         });
/* 10129 */     addDaos("TaxBracket", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10131 */             return (Class)TaxBracketDAO.class;
/*       */           }
/*       */         });
/* 10134 */     addObjectIds("TaxBracket", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10136 */             return (Class)TaxBracketId.class;
/*       */           }
/*       */         });
/* 10139 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10141 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/* 10142 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("Address", AddressId.class, false, false);
/* 10143 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxExemptionPropertyId.class, false, false, true);
/* 10144 */           return rels;
/*       */         }
/*       */       };
/* 10147 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxExemptionDAO", relationshipProducer);
/* 10148 */     addDataModels("dtv.xst.dao.tax.impl.TaxExemptionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10150 */             return (Class)TaxExemptionModel.class;
/*       */           }
/*       */         });
/* 10153 */     addInterfaces("dtv.xst.dao.tax.ITaxExemption", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10155 */             return (Class)TaxExemptionModel.class;
/*       */           }
/*       */         });
/* 10158 */     addDaos("TaxExemption", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10160 */             return (Class)TaxExemptionDAO.class;
/*       */           }
/*       */         });
/* 10163 */     addObjectIds("TaxExemption", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10165 */             return (Class)TaxExemptionId.class;
/*       */           }
/*       */         });
/* 10168 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10170 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10171 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxRateRuleOverridePropertyId.class, false, false, true);
/* 10172 */           return rels;
/*       */         }
/*       */       };
/* 10175 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxRateRuleOverrideDAO", relationshipProducer);
/* 10176 */     addDataModels("dtv.xst.dao.tax.impl.TaxRateRuleOverrideDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10178 */             return (Class)TaxRateRuleOverrideModel.class;
/*       */           }
/*       */         });
/* 10181 */     addInterfaces("dtv.xst.dao.tax.ITaxRateRuleOverride", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10183 */             return (Class)TaxRateRuleOverrideModel.class;
/*       */           }
/*       */         });
/* 10186 */     addDaos("TaxRateRuleOverride", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10188 */             return (Class)TaxRateRuleOverrideDAO.class;
/*       */           }
/*       */         });
/* 10191 */     addObjectIds("TaxRateRuleOverride", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10193 */             return (Class)TaxRateRuleOverrideId.class;
/*       */           }
/*       */         });
/* 10196 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10198 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10199 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", TaxTaxGroupMappingPropertyId.class, false, false, true);
/* 10200 */           return rels;
/*       */         }
/*       */       };
/* 10203 */     addRelationshipProducer("dtv.xst.dao.tax.impl.TaxTaxGroupMappingDAO", relationshipProducer);
/* 10204 */     addDataModels("dtv.xst.dao.tax.impl.TaxTaxGroupMappingDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10206 */             return (Class)TaxTaxGroupMappingModel.class;
/*       */           }
/*       */         });
/* 10209 */     addInterfaces("dtv.xst.dao.tax.ITaxTaxGroupMapping", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10211 */             return (Class)TaxTaxGroupMappingModel.class;
/*       */           }
/*       */         });
/* 10214 */     addDaos("TaxTaxGroupMapping", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10216 */             return (Class)TaxTaxGroupMappingDAO.class;
/*       */           }
/*       */         });
/* 10219 */     addObjectIds("TaxTaxGroupMapping", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10221 */             return (Class)TaxTaxGroupMappingId.class;
/*       */           }
/*       */         });
/* 10224 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10226 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/* 10227 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("DocumentDefinition", DocumentDefinitionId.class, false, false);
/* 10228 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", DocumentPropertyId.class, false, false, true);
/* 10229 */           return rels;
/*       */         }
/*       */       };
/* 10232 */     addRelationshipProducer("dtv.xst.dao.doc.impl.DocumentDAO", relationshipProducer);
/* 10233 */     addDataModels("dtv.xst.dao.doc.impl.DocumentDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10235 */             return (Class)DocumentModel.class;
/*       */           }
/*       */         });
/* 10238 */     addInterfaces("dtv.xst.dao.doc.IDocument", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10240 */             return (Class)DocumentModel.class;
/*       */           }
/*       */         });
/* 10243 */     addDaos("Document", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10245 */             return (Class)DocumentDAO.class;
/*       */           }
/*       */         });
/* 10248 */     addObjectIds("Document", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10250 */             return (Class)DocumentId.class;
/*       */           }
/*       */         });
/* 10253 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10255 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/* 10256 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("DocDefProperties", DocumentDefinitionPropertiesId.class, false, false);
/* 10257 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", DocumentDefinitionPropertyId.class, false, false, true);
/* 10258 */           return rels;
/*       */         }
/*       */       };
/* 10261 */     addRelationshipProducer("dtv.xst.dao.doc.impl.DocumentDefinitionDAO", relationshipProducer);
/* 10262 */     addDataModels("dtv.xst.dao.doc.impl.DocumentDefinitionDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10264 */             return (Class)DocumentDefinitionModel.class;
/*       */           }
/*       */         });
/* 10267 */     addInterfaces("dtv.xst.dao.doc.IDocumentDefinition", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10269 */             return (Class)DocumentDefinitionModel.class;
/*       */           }
/*       */         });
/* 10272 */     addDaos("DocumentDefinition", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10274 */             return (Class)DocumentDefinitionDAO.class;
/*       */           }
/*       */         });
/* 10277 */     addObjectIds("DocumentDefinition", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10279 */             return (Class)DocumentDefinitionId.class;
/*       */           }
/*       */         });
/* 10282 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10284 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10285 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", DocumentDefinitionPropertiesPropertyId.class, false, false, true);
/* 10286 */           return rels;
/*       */         }
/*       */       };
/* 10289 */     addRelationshipProducer("dtv.xst.dao.doc.impl.DocumentDefinitionPropertiesDAO", relationshipProducer);
/* 10290 */     addDataModels("dtv.xst.dao.doc.impl.DocumentDefinitionPropertiesDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10292 */             return (Class)DocumentDefinitionPropertiesModel.class;
/*       */           }
/*       */         });
/* 10295 */     addInterfaces("dtv.xst.dao.doc.IDocumentDefinitionProperties", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10297 */             return (Class)DocumentDefinitionPropertiesModel.class;
/*       */           }
/*       */         });
/* 10300 */     addDaos("DocumentDefinitionProperties", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10302 */             return (Class)DocumentDefinitionPropertiesDAO.class;
/*       */           }
/*       */         });
/* 10305 */     addObjectIds("DocumentDefinitionProperties", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10307 */             return (Class)DocumentDefinitionPropertiesId.class;
/*       */           }
/*       */         });
/* 10310 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10312 */           IDataModelRelationship[] rels = new IDataModelRelationship[4];
/* 10313 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("CorrectionModifier", CorrectionModifierId.class, false, false);
/* 10314 */           rels[1] = (IDataModelRelationship)new OneToOneRelationship("Signature", TenderSignatureId.class, false, false);
/* 10315 */           rels[2] = (IDataModelRelationship)new OneToManyRelationship("Properties", RetailTransactionLineItemPropertyId.class, false, false, true);
/* 10316 */           rels[3] = (IDataModelRelationship)new OneToOneRelationship("Document", DocumentId.class, false, false);
/* 10317 */           return rels;
/*       */         }
/*       */       };
/* 10320 */     addRelationshipProducer("dtv.xst.dao.doc.impl.DocumentLineItemDAO", relationshipProducer);
/* 10321 */     addDataModels("dtv.xst.dao.doc.impl.DocumentLineItemDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10323 */             return (Class)DocumentLineItemModel.class;
/*       */           }
/*       */         });
/* 10326 */     addInterfaces("dtv.xst.dao.doc.IDocumentLineItem", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10328 */             return (Class)DocumentLineItemModel.class;
/*       */           }
/*       */         });
/* 10331 */     addDaos("DocumentLineItem", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10333 */             return (Class)DocumentLineItemDAO.class;
/*       */           }
/*       */         });
/* 10336 */     addObjectIds("DocumentLineItem", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10338 */             return (Class)RetailTransactionLineItemId.class;
/*       */           }
/*       */         });
/* 10341 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10343 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10344 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", OrganizerPropertyId.class, false, false, true);
/* 10345 */           return rels;
/*       */         }
/*       */       };
/* 10348 */     addRelationshipProducer("dtv.xst.dao.rpt.impl.OrganizerDAO", relationshipProducer);
/* 10349 */     addDataModels("dtv.xst.dao.rpt.impl.OrganizerDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10351 */             return (Class)OrganizerModel.class;
/*       */           }
/*       */         });
/* 10354 */     addInterfaces("dtv.xst.dao.rpt.IOrganizer", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10356 */             return (Class)OrganizerModel.class;
/*       */           }
/*       */         });
/* 10359 */     addDaos("Organizer", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10361 */             return (Class)OrganizerDAO.class;
/*       */           }
/*       */         });
/* 10364 */     addObjectIds("Organizer", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10366 */             return (Class)OrganizerId.class;
/*       */           }
/*       */         });
/* 10369 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10371 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10372 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", EmployeeTimeOffPropertyId.class, false, false, true);
/* 10373 */           return rels;
/*       */         }
/*       */       };
/* 10376 */     addRelationshipProducer("dtv.xst.dao.sch.impl.EmployeeTimeOffDAO", relationshipProducer);
/* 10377 */     addDataModels("dtv.xst.dao.sch.impl.EmployeeTimeOffDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10379 */             return (Class)EmployeeTimeOffModel.class;
/*       */           }
/*       */         });
/* 10382 */     addInterfaces("dtv.xst.dao.sch.IEmployeeTimeOff", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10384 */             return (Class)EmployeeTimeOffModel.class;
/*       */           }
/*       */         });
/* 10387 */     addDaos("EmployeeTimeOff", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10389 */             return (Class)EmployeeTimeOffDAO.class;
/*       */           }
/*       */         });
/* 10392 */     addObjectIds("EmployeeTimeOff", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10394 */             return (Class)EmployeeTimeOffId.class;
/*       */           }
/*       */         });
/* 10397 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10399 */           IDataModelRelationship[] rels = new IDataModelRelationship[2];
/* 10400 */           rels[0] = (IDataModelRelationship)new OneToOneRelationship("WorkCode", WorkCodesId.class, false, false);
/* 10401 */           rels[1] = (IDataModelRelationship)new OneToManyRelationship("Properties", SchedulePropertyId.class, false, false, true);
/* 10402 */           return rels;
/*       */         }
/*       */       };
/* 10405 */     addRelationshipProducer("dtv.xst.dao.sch.impl.ScheduleDAO", relationshipProducer);
/* 10406 */     addDataModels("dtv.xst.dao.sch.impl.ScheduleDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10408 */             return (Class)ScheduleModel.class;
/*       */           }
/*       */         });
/* 10411 */     addInterfaces("dtv.xst.dao.sch.ISchedule", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10413 */             return (Class)ScheduleModel.class;
/*       */           }
/*       */         });
/* 10416 */     addDaos("Schedule", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10418 */             return (Class)ScheduleDAO.class;
/*       */           }
/*       */         });
/* 10421 */     addObjectIds("Schedule", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10423 */             return (Class)ScheduleId.class;
/*       */           }
/*       */         });
/* 10426 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10428 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10429 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", ShiftPropertyId.class, false, false, true);
/* 10430 */           return rels;
/*       */         }
/*       */       };
/* 10433 */     addRelationshipProducer("dtv.xst.dao.sch.impl.ShiftDAO", relationshipProducer);
/* 10434 */     addDataModels("dtv.xst.dao.sch.impl.ShiftDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10436 */             return (Class)ShiftModel.class;
/*       */           }
/*       */         });
/* 10439 */     addInterfaces("dtv.xst.dao.sch.IShift", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10441 */             return (Class)ShiftModel.class;
/*       */           }
/*       */         });
/* 10444 */     addDaos("Shift", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10446 */             return (Class)ShiftDAO.class;
/*       */           }
/*       */         });
/* 10449 */     addObjectIds("Shift", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10451 */             return (Class)ShiftId.class;
/*       */           }
/*       */         });
/* 10454 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10456 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10457 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("Properties", SalesGoalPropertyId.class, false, false, true);
/* 10458 */           return rels;
/*       */         }
/*       */       };
/* 10461 */     addRelationshipProducer("dtv.xst.dao.sls.impl.SalesGoalDAO", relationshipProducer);
/* 10462 */     addDataModels("dtv.xst.dao.sls.impl.SalesGoalDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10464 */             return (Class)SalesGoalModel.class;
/*       */           }
/*       */         });
/* 10467 */     addInterfaces("dtv.xst.dao.sls.ISalesGoal", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10469 */             return (Class)SalesGoalModel.class;
/*       */           }
/*       */         });
/* 10472 */     addDaos("SalesGoal", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10474 */             return (Class)SalesGoalDAO.class;
/*       */           }
/*       */         });
/* 10477 */     addObjectIds("SalesGoal", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10479 */             return (Class)SalesGoalId.class;
/*       */           }
/*       */         });
/* 10482 */     relationshipProducer = new IRelationshipSetProducer() {
/*       */         public IDataModelRelationship[] getRelationshipSet() {
/* 10484 */           IDataModelRelationship[] rels = new IDataModelRelationship[1];
/* 10485 */           rels[0] = (IDataModelRelationship)new OneToManyRelationship("OrgScopes", XadminUserNodeId.class, false, false);
/* 10486 */           return rels;
/*       */         }
/*       */       };
/* 10489 */     addRelationshipProducer("dtv.xst.dao.cfg.impl.XadminUserDAO", relationshipProducer);
/* 10490 */     addDataModels("dtv.xst.dao.cfg.impl.XadminUserDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10492 */             return (Class)XadminUserModel.class;
/*       */           }
/*       */         });
/* 10495 */     addInterfaces("dtv.xst.dao.cfg.IXadminUser", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10497 */             return (Class)XadminUserModel.class;
/*       */           }
/*       */         });
/* 10500 */     addDaos("XadminUser", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10502 */             return (Class)XadminUserDAO.class;
/*       */           }
/*       */         });
/* 10505 */     addObjectIds("XadminUser", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10507 */             return (Class)XadminUserId.class;
/*       */           }
/*       */         });
/* 10510 */     addDataModels("dtv.xst.dao.cfg.impl.XadminUserNodeDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10512 */             return (Class)XadminUserNodeModel.class;
/*       */           }
/*       */         });
/* 10515 */     addInterfaces("dtv.xst.dao.cfg.IXadminUserNode", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10517 */             return (Class)XadminUserNodeModel.class;
/*       */           }
/*       */         });
/* 10520 */     addDaos("XadminUserNode", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10522 */             return (Class)XadminUserNodeDAO.class;
/*       */           }
/*       */         });
/* 10525 */     addObjectIds("XadminUserNode", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10527 */             return (Class)XadminUserNodeId.class;
/*       */           }
/*       */         });
/* 10530 */     addDataModels("dtv.xst.dao.crm.impl.CustomerConsentInfoPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10532 */             return (Class)CustomerConsentInfoPropertyModel.class;
/*       */           }
/*       */         });
/* 10535 */     addInterfaces("dtv.xst.dao.crm.ICustomerConsentInfoProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10537 */             return (Class)CustomerConsentInfoPropertyModel.class;
/*       */           }
/*       */         });
/* 10540 */     addDaos("CustomerConsentInfoProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10542 */             return (Class)CustomerConsentInfoPropertyDAO.class;
/*       */           }
/*       */         });
/* 10545 */     addObjectIds("CustomerConsentInfoProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10547 */             return (Class)CustomerConsentInfoPropertyId.class;
/*       */           }
/*       */         });
/* 10550 */     addDataModels("dtv.xst.dao.crm.impl.PartyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10552 */             return (Class)PartyPropertyModel.class;
/*       */           }
/*       */         });
/* 10555 */     addInterfaces("dtv.xst.dao.crm.IPartyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10557 */             return (Class)PartyPropertyModel.class;
/*       */           }
/*       */         });
/* 10560 */     addDaos("PartyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10562 */             return (Class)PartyPropertyDAO.class;
/*       */           }
/*       */         });
/* 10565 */     addObjectIds("PartyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10567 */             return (Class)PartyPropertyId.class;
/*       */           }
/*       */         });
/* 10570 */     addDataModels("dtv.xst.dao.crm.impl.PartyLocaleInformationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10572 */             return (Class)PartyLocaleInformationPropertyModel.class;
/*       */           }
/*       */         });
/* 10575 */     addInterfaces("dtv.xst.dao.crm.IPartyLocaleInformationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10577 */             return (Class)PartyLocaleInformationPropertyModel.class;
/*       */           }
/*       */         });
/* 10580 */     addDaos("PartyLocaleInformationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10582 */             return (Class)PartyLocaleInformationPropertyDAO.class;
/*       */           }
/*       */         });
/* 10585 */     addObjectIds("PartyLocaleInformationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10587 */             return (Class)PartyLocaleInformationPropertyId.class;
/*       */           }
/*       */         });
/* 10590 */     addDataModels("dtv.xst.dao.crm.impl.CustomerAffiliationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10592 */             return (Class)CustomerAffiliationPropertyModel.class;
/*       */           }
/*       */         });
/* 10595 */     addInterfaces("dtv.xst.dao.crm.ICustomerAffiliationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10597 */             return (Class)CustomerAffiliationPropertyModel.class;
/*       */           }
/*       */         });
/* 10600 */     addDaos("CustomerAffiliationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10602 */             return (Class)CustomerAffiliationPropertyDAO.class;
/*       */           }
/*       */         });
/* 10605 */     addObjectIds("CustomerAffiliationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10607 */             return (Class)CustomerAffiliationPropertyId.class;
/*       */           }
/*       */         });
/* 10610 */     addDataModels("dtv.xst.dao.crm.impl.CustomerNotePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10612 */             return (Class)CustomerNotePropertyModel.class;
/*       */           }
/*       */         });
/* 10615 */     addInterfaces("dtv.xst.dao.crm.ICustomerNoteProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10617 */             return (Class)CustomerNotePropertyModel.class;
/*       */           }
/*       */         });
/* 10620 */     addDaos("CustomerNoteProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10622 */             return (Class)CustomerNotePropertyDAO.class;
/*       */           }
/*       */         });
/* 10625 */     addObjectIds("CustomerNoteProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10627 */             return (Class)CustomerNotePropertyId.class;
/*       */           }
/*       */         });
/* 10630 */     addDataModels("dtv.xst.dao.crm.impl.GiftRegistryJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10632 */             return (Class)GiftRegistryJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 10635 */     addInterfaces("dtv.xst.dao.crm.IGiftRegistryJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10637 */             return (Class)GiftRegistryJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 10640 */     addDaos("GiftRegistryJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10642 */             return (Class)GiftRegistryJournalPropertyDAO.class;
/*       */           }
/*       */         });
/* 10645 */     addObjectIds("GiftRegistryJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10647 */             return (Class)GiftRegistryJournalPropertyId.class;
/*       */           }
/*       */         });
/* 10650 */     addDataModels("dtv.xst.dao.crm.impl.PartyCrossReferencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10652 */             return (Class)PartyCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/* 10655 */     addInterfaces("dtv.xst.dao.crm.IPartyCrossReferenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10657 */             return (Class)PartyCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/* 10660 */     addDaos("PartyCrossReferenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10662 */             return (Class)PartyCrossReferencePropertyDAO.class;
/*       */           }
/*       */         });
/* 10665 */     addObjectIds("PartyCrossReferenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10667 */             return (Class)PartyCrossReferencePropertyId.class;
/*       */           }
/*       */         });
/* 10670 */     addDataModels("dtv.xst.dao.crm.impl.PartyEmailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10672 */             return (Class)PartyEmailPropertyModel.class;
/*       */           }
/*       */         });
/* 10675 */     addInterfaces("dtv.xst.dao.crm.IPartyEmailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10677 */             return (Class)PartyEmailPropertyModel.class;
/*       */           }
/*       */         });
/* 10680 */     addDaos("PartyEmailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10682 */             return (Class)PartyEmailPropertyDAO.class;
/*       */           }
/*       */         });
/* 10685 */     addObjectIds("PartyEmailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10687 */             return (Class)PartyEmailPropertyId.class;
/*       */           }
/*       */         });
/* 10690 */     addDataModels("dtv.xst.dao.crm.impl.PartyIdCrossReferencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10692 */             return (Class)PartyIdCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/* 10695 */     addInterfaces("dtv.xst.dao.crm.IPartyIdCrossReferenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10697 */             return (Class)PartyIdCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/* 10700 */     addDaos("PartyIdCrossReferenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10702 */             return (Class)PartyIdCrossReferencePropertyDAO.class;
/*       */           }
/*       */         });
/* 10705 */     addObjectIds("PartyIdCrossReferenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10707 */             return (Class)PartyIdCrossReferencePropertyId.class;
/*       */           }
/*       */         });
/* 10710 */     addDataModels("dtv.xst.dao.crm.impl.PartyTelephonePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10712 */             return (Class)PartyTelephonePropertyModel.class;
/*       */           }
/*       */         });
/* 10715 */     addInterfaces("dtv.xst.dao.crm.IPartyTelephoneProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10717 */             return (Class)PartyTelephonePropertyModel.class;
/*       */           }
/*       */         });
/* 10720 */     addDaos("PartyTelephoneProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10722 */             return (Class)PartyTelephonePropertyDAO.class;
/*       */           }
/*       */         });
/* 10725 */     addObjectIds("PartyTelephoneProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10727 */             return (Class)PartyTelephonePropertyId.class;
/*       */           }
/*       */         });
/* 10730 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10732 */             return (Class)CustomerAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10735 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10737 */             return (Class)CustomerAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10740 */     addDaos("CustomerAccountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10742 */             return (Class)CustomerAccountPropertyDAO.class;
/*       */           }
/*       */         });
/* 10745 */     addObjectIds("CustomerAccountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10747 */             return (Class)CustomerAccountPropertyId.class;
/*       */           }
/*       */         });
/* 10750 */     addDataModels("dtv.xst.dao.cat.impl.AwardAccountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10752 */             return (Class)AwardAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10755 */     addInterfaces("dtv.xst.dao.cat.IAwardAccountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10757 */             return (Class)AwardAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10760 */     addDaos("AwardAccountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10762 */             return (Class)AwardAccountPropertyDAO.class;
/*       */           }
/*       */         });
/* 10765 */     addObjectIds("AwardAccountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10767 */             return (Class)AwardAccountPropertyId.class;
/*       */           }
/*       */         });
/* 10770 */     addDataModels("dtv.xst.dao.cat.impl.AwardAccountCouponPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10772 */             return (Class)AwardAccountCouponPropertyModel.class;
/*       */           }
/*       */         });
/* 10775 */     addInterfaces("dtv.xst.dao.cat.IAwardAccountCouponProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10777 */             return (Class)AwardAccountCouponPropertyModel.class;
/*       */           }
/*       */         });
/* 10780 */     addDaos("AwardAccountCouponProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10782 */             return (Class)AwardAccountCouponPropertyDAO.class;
/*       */           }
/*       */         });
/* 10785 */     addObjectIds("AwardAccountCouponProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10787 */             return (Class)AwardAccountCouponPropertyId.class;
/*       */           }
/*       */         });
/* 10790 */     addDataModels("dtv.xst.dao.cat.impl.ChargeAccountInvoicePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10792 */             return (Class)ChargeAccountInvoicePropertyModel.class;
/*       */           }
/*       */         });
/* 10795 */     addInterfaces("dtv.xst.dao.cat.IChargeAccountInvoiceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10797 */             return (Class)ChargeAccountInvoicePropertyModel.class;
/*       */           }
/*       */         });
/* 10800 */     addDaos("ChargeAccountInvoiceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10802 */             return (Class)ChargeAccountInvoicePropertyDAO.class;
/*       */           }
/*       */         });
/* 10805 */     addObjectIds("ChargeAccountInvoiceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10807 */             return (Class)ChargeAccountInvoicePropertyId.class;
/*       */           }
/*       */         });
/* 10810 */     addDataModels("dtv.xst.dao.cat.impl.ChargeAccountUserPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10812 */             return (Class)ChargeAccountUserPropertyModel.class;
/*       */           }
/*       */         });
/* 10815 */     addInterfaces("dtv.xst.dao.cat.IChargeAccountUserProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10817 */             return (Class)ChargeAccountUserPropertyModel.class;
/*       */           }
/*       */         });
/* 10820 */     addDaos("ChargeAccountUserProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10822 */             return (Class)ChargeAccountUserPropertyDAO.class;
/*       */           }
/*       */         });
/* 10825 */     addObjectIds("ChargeAccountUserProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10827 */             return (Class)ChargeAccountUserPropertyId.class;
/*       */           }
/*       */         });
/* 10830 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10832 */             return (Class)CustomerAccountJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 10835 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10837 */             return (Class)CustomerAccountJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 10840 */     addDaos("CustomerAccountJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10842 */             return (Class)CustomerAccountJournalPropertyDAO.class;
/*       */           }
/*       */         });
/* 10845 */     addObjectIds("CustomerAccountJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10847 */             return (Class)CustomerAccountJournalPropertyId.class;
/*       */           }
/*       */         });
/* 10850 */     addDataModels("dtv.xst.dao.cat.impl.CustomerItemAccountActivityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10852 */             return (Class)CustomerItemAccountActivityPropertyModel.class;
/*       */           }
/*       */         });
/* 10855 */     addInterfaces("dtv.xst.dao.cat.ICustomerItemAccountActivityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10857 */             return (Class)CustomerItemAccountActivityPropertyModel.class;
/*       */           }
/*       */         });
/* 10860 */     addDaos("CustomerItemAccountActivityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10862 */             return (Class)CustomerItemAccountActivityPropertyDAO.class;
/*       */           }
/*       */         });
/* 10865 */     addObjectIds("CustomerItemAccountActivityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10867 */             return (Class)CustomerItemAccountActivityPropertyId.class;
/*       */           }
/*       */         });
/* 10870 */     addDataModels("dtv.xst.dao.cat.impl.CustomerItemAccountDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10872 */             return (Class)CustomerItemAccountDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 10875 */     addInterfaces("dtv.xst.dao.cat.ICustomerItemAccountDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10877 */             return (Class)CustomerItemAccountDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 10880 */     addDaos("CustomerItemAccountDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10882 */             return (Class)CustomerItemAccountDetailPropertyDAO.class;
/*       */           }
/*       */         });
/* 10885 */     addObjectIds("CustomerItemAccountDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10887 */             return (Class)CustomerItemAccountDetailPropertyId.class;
/*       */           }
/*       */         });
/* 10890 */     addDataModels("dtv.xst.dao.cat.impl.CustomerLoyaltyAccountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10892 */             return (Class)CustomerLoyaltyAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10895 */     addInterfaces("dtv.xst.dao.cat.ICustomerLoyaltyAccountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10897 */             return (Class)CustomerLoyaltyAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10900 */     addDaos("CustomerLoyaltyAccountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10902 */             return (Class)CustomerLoyaltyAccountPropertyDAO.class;
/*       */           }
/*       */         });
/* 10905 */     addObjectIds("CustomerLoyaltyAccountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10907 */             return (Class)CustomerLoyaltyAccountPropertyId.class;
/*       */           }
/*       */         });
/* 10910 */     addDataModels("dtv.xst.dao.cat.impl.CustomerLoyaltyCardPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10912 */             return (Class)CustomerLoyaltyCardPropertyModel.class;
/*       */           }
/*       */         });
/* 10915 */     addInterfaces("dtv.xst.dao.cat.ICustomerLoyaltyCardProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10917 */             return (Class)CustomerLoyaltyCardPropertyModel.class;
/*       */           }
/*       */         });
/* 10920 */     addDaos("CustomerLoyaltyCardProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10922 */             return (Class)CustomerLoyaltyCardPropertyDAO.class;
/*       */           }
/*       */         });
/* 10925 */     addObjectIds("CustomerLoyaltyCardProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10927 */             return (Class)CustomerLoyaltyCardPropertyId.class;
/*       */           }
/*       */         });
/* 10930 */     addDataModels("dtv.xst.dao.cat.impl.DeliveryModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10932 */             return (Class)DeliveryModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 10935 */     addInterfaces("dtv.xst.dao.cat.IDeliveryModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10937 */             return (Class)DeliveryModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 10940 */     addDaos("DeliveryModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10942 */             return (Class)DeliveryModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 10945 */     addObjectIds("DeliveryModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10947 */             return (Class)DeliveryModifierPropertyId.class;
/*       */           }
/*       */         });
/* 10950 */     addDataModels("dtv.xst.dao.cat.impl.EscrowAccountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10952 */             return (Class)EscrowAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10955 */     addInterfaces("dtv.xst.dao.cat.IEscrowAccountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10957 */             return (Class)EscrowAccountPropertyModel.class;
/*       */           }
/*       */         });
/* 10960 */     addDaos("EscrowAccountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10962 */             return (Class)EscrowAccountPropertyDAO.class;
/*       */           }
/*       */         });
/* 10965 */     addObjectIds("EscrowAccountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10967 */             return (Class)EscrowAccountPropertyId.class;
/*       */           }
/*       */         });
/* 10970 */     addDataModels("dtv.xst.dao.cat.impl.ChargeAccountHistoryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10972 */             return (Class)ChargeAccountHistoryPropertyModel.class;
/*       */           }
/*       */         });
/* 10975 */     addInterfaces("dtv.xst.dao.cat.IChargeAccountHistoryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10977 */             return (Class)ChargeAccountHistoryPropertyModel.class;
/*       */           }
/*       */         });
/* 10980 */     addDaos("ChargeAccountHistoryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 10982 */             return (Class)ChargeAccountHistoryPropertyDAO.class;
/*       */           }
/*       */         });
/* 10985 */     addObjectIds("ChargeAccountHistoryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 10987 */             return (Class)ChargeAccountHistoryPropertyId.class;
/*       */           }
/*       */         });
/* 10990 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountNotePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 10992 */             return (Class)CustomerAccountNotePropertyModel.class;
/*       */           }
/*       */         });
/* 10995 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountNoteProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 10997 */             return (Class)CustomerAccountNotePropertyModel.class;
/*       */           }
/*       */         });
/* 11000 */     addDaos("CustomerAccountNoteProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11002 */             return (Class)CustomerAccountNotePropertyDAO.class;
/*       */           }
/*       */         });
/* 11005 */     addObjectIds("CustomerAccountNoteProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11007 */             return (Class)CustomerAccountNotePropertyId.class;
/*       */           }
/*       */         });
/* 11010 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountPlanPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11012 */             return (Class)CustomerAccountPlanPropertyModel.class;
/*       */           }
/*       */         });
/* 11015 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountPlanProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11017 */             return (Class)CustomerAccountPlanPropertyModel.class;
/*       */           }
/*       */         });
/* 11020 */     addDaos("CustomerAccountPlanProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11022 */             return (Class)CustomerAccountPlanPropertyDAO.class;
/*       */           }
/*       */         });
/* 11025 */     addObjectIds("CustomerAccountPlanProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11027 */             return (Class)CustomerAccountPlanPropertyId.class;
/*       */           }
/*       */         });
/* 11030 */     addDataModels("dtv.xst.dao.cat.impl.EscrowAccountActivityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11032 */             return (Class)EscrowAccountActivityPropertyModel.class;
/*       */           }
/*       */         });
/* 11035 */     addInterfaces("dtv.xst.dao.cat.IEscrowAccountActivityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11037 */             return (Class)EscrowAccountActivityPropertyModel.class;
/*       */           }
/*       */         });
/* 11040 */     addDaos("EscrowAccountActivityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11042 */             return (Class)EscrowAccountActivityPropertyDAO.class;
/*       */           }
/*       */         });
/* 11045 */     addObjectIds("EscrowAccountActivityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11047 */             return (Class)EscrowAccountActivityPropertyId.class;
/*       */           }
/*       */         });
/* 11050 */     addDataModels("dtv.xst.dao.cat.impl.PaymentSchedulePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11052 */             return (Class)PaymentSchedulePropertyModel.class;
/*       */           }
/*       */         });
/* 11055 */     addInterfaces("dtv.xst.dao.cat.IPaymentScheduleProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11057 */             return (Class)PaymentSchedulePropertyModel.class;
/*       */           }
/*       */         });
/* 11060 */     addDaos("PaymentScheduleProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11062 */             return (Class)PaymentSchedulePropertyDAO.class;
/*       */           }
/*       */         });
/* 11065 */     addObjectIds("PaymentScheduleProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11067 */             return (Class)PaymentSchedulePropertyId.class;
/*       */           }
/*       */         });
/* 11070 */     addDataModels("dtv.xst.dao.cat.impl.CustomerAccountAuthorizationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11072 */             return (Class)CustomerAccountAuthorizationPropertyModel.class;
/*       */           }
/*       */         });
/* 11075 */     addInterfaces("dtv.xst.dao.cat.ICustomerAccountAuthorizationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11077 */             return (Class)CustomerAccountAuthorizationPropertyModel.class;
/*       */           }
/*       */         });
/* 11080 */     addDaos("CustomerAccountAuthorizationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11082 */             return (Class)CustomerAccountAuthorizationPropertyDAO.class;
/*       */           }
/*       */         });
/* 11085 */     addObjectIds("CustomerAccountAuthorizationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11087 */             return (Class)CustomerAccountAuthorizationPropertyId.class;
/*       */           }
/*       */         });
/* 11090 */     addDataModels("dtv.xst.dao.xom.impl.OrderLinePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11092 */             return (Class)OrderLinePropertyModel.class;
/*       */           }
/*       */         });
/* 11095 */     addInterfaces("dtv.xst.dao.xom.IOrderLineProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11097 */             return (Class)OrderLinePropertyModel.class;
/*       */           }
/*       */         });
/* 11100 */     addDaos("OrderLineProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11102 */             return (Class)OrderLinePropertyDAO.class;
/*       */           }
/*       */         });
/* 11105 */     addObjectIds("OrderLineProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11107 */             return (Class)OrderLinePropertyId.class;
/*       */           }
/*       */         });
/* 11110 */     addDataModels("dtv.xst.dao.xom.impl.OrderPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11112 */             return (Class)OrderPropertyModel.class;
/*       */           }
/*       */         });
/* 11115 */     addInterfaces("dtv.xst.dao.xom.IOrderProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11117 */             return (Class)OrderPropertyModel.class;
/*       */           }
/*       */         });
/* 11120 */     addDaos("OrderProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11122 */             return (Class)OrderPropertyDAO.class;
/*       */           }
/*       */         });
/* 11125 */     addObjectIds("OrderProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11127 */             return (Class)OrderPropertyId.class;
/*       */           }
/*       */         });
/* 11130 */     addDataModels("dtv.xst.dao.xom.impl.ItemModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11132 */             return (Class)ItemModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11135 */     addInterfaces("dtv.xst.dao.xom.IItemModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11137 */             return (Class)ItemModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11140 */     addDaos("ItemModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11142 */             return (Class)ItemModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11145 */     addObjectIds("ItemModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11147 */             return (Class)ItemModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11150 */     addDataModels("dtv.xst.dao.xom.impl.AddressModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11152 */             return (Class)AddressModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11155 */     addInterfaces("dtv.xst.dao.xom.IAddressModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11157 */             return (Class)AddressModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11160 */     addDaos("AddressModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11162 */             return (Class)AddressModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11165 */     addObjectIds("AddressModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11167 */             return (Class)AddressModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11170 */     addDataModels("dtv.xst.dao.xom.impl.BalanceModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11172 */             return (Class)BalanceModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11175 */     addInterfaces("dtv.xst.dao.xom.IBalanceModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11177 */             return (Class)BalanceModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11180 */     addDaos("BalanceModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11182 */             return (Class)BalanceModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11185 */     addObjectIds("BalanceModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11187 */             return (Class)BalanceModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11190 */     addDataModels("dtv.xst.dao.xom.impl.CustomerModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11192 */             return (Class)CustomerModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11195 */     addInterfaces("dtv.xst.dao.xom.ICustomerModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11197 */             return (Class)CustomerModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11200 */     addDaos("CustomerModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11202 */             return (Class)CustomerModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11205 */     addObjectIds("CustomerModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11207 */             return (Class)CustomerModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11210 */     addDataModels("dtv.xst.dao.xom.impl.CustomizationModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11212 */             return (Class)CustomizationModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11215 */     addInterfaces("dtv.xst.dao.xom.ICustomizationModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11217 */             return (Class)CustomizationModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11220 */     addDaos("CustomizationModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11222 */             return (Class)CustomizationModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11225 */     addObjectIds("CustomizationModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11227 */             return (Class)CustomizationModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11230 */     addDataModels("dtv.xst.dao.xom.impl.FeeModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11232 */             return (Class)FeeModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11235 */     addInterfaces("dtv.xst.dao.xom.IFeeModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11237 */             return (Class)FeeModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11240 */     addDaos("FeeModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11242 */             return (Class)FeeModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11245 */     addObjectIds("FeeModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11247 */             return (Class)FeeModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11250 */     addDataModels("dtv.xst.dao.xom.impl.FulfillmentModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11252 */             return (Class)FulfillmentModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11255 */     addInterfaces("dtv.xst.dao.xom.IFulfillmentModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11257 */             return (Class)FulfillmentModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11260 */     addDaos("FulfillmentModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11262 */             return (Class)FulfillmentModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11265 */     addObjectIds("FulfillmentModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11267 */             return (Class)FulfillmentModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11270 */     addDataModels("dtv.xst.dao.xom.impl.OrderFeePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11272 */             return (Class)OrderFeePropertyModel.class;
/*       */           }
/*       */         });
/* 11275 */     addInterfaces("dtv.xst.dao.xom.IOrderFeeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11277 */             return (Class)OrderFeePropertyModel.class;
/*       */           }
/*       */         });
/* 11280 */     addDaos("OrderFeeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11282 */             return (Class)OrderFeePropertyDAO.class;
/*       */           }
/*       */         });
/* 11285 */     addObjectIds("OrderFeeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11287 */             return (Class)OrderFeePropertyId.class;
/*       */           }
/*       */         });
/* 11290 */     addDataModels("dtv.xst.dao.xom.impl.OrderModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11292 */             return (Class)OrderModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11295 */     addInterfaces("dtv.xst.dao.xom.IOrderModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11297 */             return (Class)OrderModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11300 */     addDaos("OrderModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11302 */             return (Class)OrderModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11305 */     addObjectIds("OrderModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11307 */             return (Class)OrderModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11310 */     addDataModels("dtv.xst.dao.xom.impl.OrderPaymentPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11312 */             return (Class)OrderPaymentPropertyModel.class;
/*       */           }
/*       */         });
/* 11315 */     addInterfaces("dtv.xst.dao.xom.IOrderPaymentProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11317 */             return (Class)OrderPaymentPropertyModel.class;
/*       */           }
/*       */         });
/* 11320 */     addDaos("OrderPaymentProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11322 */             return (Class)OrderPaymentPropertyDAO.class;
/*       */           }
/*       */         });
/* 11325 */     addObjectIds("OrderPaymentProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11327 */             return (Class)OrderPaymentPropertyId.class;
/*       */           }
/*       */         });
/* 11330 */     addDataModels("dtv.xst.dao.xom.impl.SourceModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11332 */             return (Class)SourceModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11335 */     addInterfaces("dtv.xst.dao.xom.ISourceModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11337 */             return (Class)SourceModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 11340 */     addDaos("SourceModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11342 */             return (Class)SourceModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 11345 */     addObjectIds("SourceModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11347 */             return (Class)SourceModifierPropertyId.class;
/*       */           }
/*       */         });
/* 11350 */     addDataModels("dtv.xst.dao.prc.impl.DealPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11352 */             return (Class)DealPropertyModel.class;
/*       */           }
/*       */         });
/* 11355 */     addInterfaces("dtv.xst.dao.prc.IDealProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11357 */             return (Class)DealPropertyModel.class;
/*       */           }
/*       */         });
/* 11360 */     addDaos("DealProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11362 */             return (Class)DealPropertyDAO.class;
/*       */           }
/*       */         });
/* 11365 */     addObjectIds("DealProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11367 */             return (Class)DealPropertyId.class;
/*       */           }
/*       */         });
/* 11370 */     addDataModels("dtv.xst.dao.prc.impl.DealCustomerGroupsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11372 */             return (Class)DealCustomerGroupsPropertyModel.class;
/*       */           }
/*       */         });
/* 11375 */     addInterfaces("dtv.xst.dao.prc.IDealCustomerGroupsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11377 */             return (Class)DealCustomerGroupsPropertyModel.class;
/*       */           }
/*       */         });
/* 11380 */     addDaos("DealCustomerGroupsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11382 */             return (Class)DealCustomerGroupsPropertyDAO.class;
/*       */           }
/*       */         });
/* 11385 */     addObjectIds("DealCustomerGroupsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11387 */             return (Class)DealCustomerGroupsPropertyId.class;
/*       */           }
/*       */         });
/* 11390 */     addDataModels("dtv.xst.dao.prc.impl.DealDocumentXrefPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11392 */             return (Class)DealDocumentXrefPropertyModel.class;
/*       */           }
/*       */         });
/* 11395 */     addInterfaces("dtv.xst.dao.prc.IDealDocumentXrefProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11397 */             return (Class)DealDocumentXrefPropertyModel.class;
/*       */           }
/*       */         });
/* 11400 */     addDaos("DealDocumentXrefProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11402 */             return (Class)DealDocumentXrefPropertyDAO.class;
/*       */           }
/*       */         });
/* 11405 */     addObjectIds("DealDocumentXrefProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11407 */             return (Class)DealDocumentXrefPropertyId.class;
/*       */           }
/*       */         });
/* 11410 */     addDataModels("dtv.xst.dao.prc.impl.DealFieldTestPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11412 */             return (Class)DealFieldTestPropertyModel.class;
/*       */           }
/*       */         });
/* 11415 */     addInterfaces("dtv.xst.dao.prc.IDealFieldTestProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11417 */             return (Class)DealFieldTestPropertyModel.class;
/*       */           }
/*       */         });
/* 11420 */     addDaos("DealFieldTestProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11422 */             return (Class)DealFieldTestPropertyDAO.class;
/*       */           }
/*       */         });
/* 11425 */     addObjectIds("DealFieldTestProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11427 */             return (Class)DealFieldTestPropertyId.class;
/*       */           }
/*       */         });
/* 11430 */     addDataModels("dtv.xst.dao.prc.impl.DealItemActionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11432 */             return (Class)DealItemActionPropertyModel.class;
/*       */           }
/*       */         });
/* 11435 */     addInterfaces("dtv.xst.dao.prc.IDealItemActionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11437 */             return (Class)DealItemActionPropertyModel.class;
/*       */           }
/*       */         });
/* 11440 */     addDaos("DealItemActionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11442 */             return (Class)DealItemActionPropertyDAO.class;
/*       */           }
/*       */         });
/* 11445 */     addObjectIds("DealItemActionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11447 */             return (Class)DealItemActionPropertyId.class;
/*       */           }
/*       */         });
/* 11450 */     addDataModels("dtv.xst.dao.prc.impl.DealTriggerPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11452 */             return (Class)DealTriggerPropertyModel.class;
/*       */           }
/*       */         });
/* 11455 */     addInterfaces("dtv.xst.dao.prc.IDealTriggerProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11457 */             return (Class)DealTriggerPropertyModel.class;
/*       */           }
/*       */         });
/* 11460 */     addDaos("DealTriggerProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11462 */             return (Class)DealTriggerPropertyDAO.class;
/*       */           }
/*       */         });
/* 11465 */     addObjectIds("DealTriggerProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11467 */             return (Class)DealTriggerPropertyId.class;
/*       */           }
/*       */         });
/* 11470 */     addDataModels("dtv.xst.dao.prc.impl.DealWeekPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11472 */             return (Class)DealWeekPropertyModel.class;
/*       */           }
/*       */         });
/* 11475 */     addInterfaces("dtv.xst.dao.prc.IDealWeekProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11477 */             return (Class)DealWeekPropertyModel.class;
/*       */           }
/*       */         });
/* 11480 */     addDaos("DealWeekProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11482 */             return (Class)DealWeekPropertyDAO.class;
/*       */           }
/*       */         });
/* 11485 */     addObjectIds("DealWeekProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11487 */             return (Class)DealWeekPropertyId.class;
/*       */           }
/*       */         });
/* 11490 */     addDataModels("dtv.xst.dao.thr.impl.PayrollPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11492 */             return (Class)PayrollPropertyModel.class;
/*       */           }
/*       */         });
/* 11495 */     addInterfaces("dtv.xst.dao.thr.IPayrollProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11497 */             return (Class)PayrollPropertyModel.class;
/*       */           }
/*       */         });
/* 11500 */     addDaos("PayrollProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11502 */             return (Class)PayrollPropertyDAO.class;
/*       */           }
/*       */         });
/* 11505 */     addObjectIds("PayrollProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11507 */             return (Class)PayrollPropertyId.class;
/*       */           }
/*       */         });
/* 11510 */     addDataModels("dtv.xst.dao.thr.impl.PayrollCategoryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11512 */             return (Class)PayrollCategoryPropertyModel.class;
/*       */           }
/*       */         });
/* 11515 */     addInterfaces("dtv.xst.dao.thr.IPayrollCategoryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11517 */             return (Class)PayrollCategoryPropertyModel.class;
/*       */           }
/*       */         });
/* 11520 */     addDaos("PayrollCategoryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11522 */             return (Class)PayrollCategoryPropertyDAO.class;
/*       */           }
/*       */         });
/* 11525 */     addObjectIds("PayrollCategoryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11527 */             return (Class)PayrollCategoryPropertyId.class;
/*       */           }
/*       */         });
/* 11530 */     addDataModels("dtv.xst.dao.thr.impl.PayrollHeaderPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11532 */             return (Class)PayrollHeaderPropertyModel.class;
/*       */           }
/*       */         });
/* 11535 */     addInterfaces("dtv.xst.dao.thr.IPayrollHeaderProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11537 */             return (Class)PayrollHeaderPropertyModel.class;
/*       */           }
/*       */         });
/* 11540 */     addDaos("PayrollHeaderProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11542 */             return (Class)PayrollHeaderPropertyDAO.class;
/*       */           }
/*       */         });
/* 11545 */     addObjectIds("PayrollHeaderProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11547 */             return (Class)PayrollHeaderPropertyId.class;
/*       */           }
/*       */         });
/* 11550 */     addDataModels("dtv.xst.dao.thr.impl.PayrollNotesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11552 */             return (Class)PayrollNotesPropertyModel.class;
/*       */           }
/*       */         });
/* 11555 */     addInterfaces("dtv.xst.dao.thr.IPayrollNotesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11557 */             return (Class)PayrollNotesPropertyModel.class;
/*       */           }
/*       */         });
/* 11560 */     addDaos("PayrollNotesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11562 */             return (Class)PayrollNotesPropertyDAO.class;
/*       */           }
/*       */         });
/* 11565 */     addObjectIds("PayrollNotesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11567 */             return (Class)PayrollNotesPropertyId.class;
/*       */           }
/*       */         });
/* 11570 */     addDataModels("dtv.xst.dao.thr.impl.TimecardEntryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11572 */             return (Class)TimecardEntryPropertyModel.class;
/*       */           }
/*       */         });
/* 11575 */     addInterfaces("dtv.xst.dao.thr.ITimecardEntryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11577 */             return (Class)TimecardEntryPropertyModel.class;
/*       */           }
/*       */         });
/* 11580 */     addDaos("TimecardEntryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11582 */             return (Class)TimecardEntryPropertyDAO.class;
/*       */           }
/*       */         });
/* 11585 */     addObjectIds("TimecardEntryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11587 */             return (Class)TimecardEntryPropertyId.class;
/*       */           }
/*       */         });
/* 11590 */     addDataModels("dtv.xst.dao.thr.impl.TimecardEntryCommentPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11592 */             return (Class)TimecardEntryCommentPropertyModel.class;
/*       */           }
/*       */         });
/* 11595 */     addInterfaces("dtv.xst.dao.thr.ITimecardEntryCommentProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11597 */             return (Class)TimecardEntryCommentPropertyModel.class;
/*       */           }
/*       */         });
/* 11600 */     addDaos("TimecardEntryCommentProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11602 */             return (Class)TimecardEntryCommentPropertyDAO.class;
/*       */           }
/*       */         });
/* 11605 */     addObjectIds("TimecardEntryCommentProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11607 */             return (Class)TimecardEntryCommentPropertyId.class;
/*       */           }
/*       */         });
/* 11610 */     addDataModels("dtv.xst.dao.thr.impl.TimecardJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11612 */             return (Class)TimecardJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 11615 */     addInterfaces("dtv.xst.dao.thr.ITimecardJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11617 */             return (Class)TimecardJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 11620 */     addDaos("TimecardJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11622 */             return (Class)TimecardJournalPropertyDAO.class;
/*       */           }
/*       */         });
/* 11625 */     addObjectIds("TimecardJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11627 */             return (Class)TimecardJournalPropertyId.class;
/*       */           }
/*       */         });
/* 11630 */     addDataModels("dtv.xst.dao.tnd.impl.TenderOptionsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11632 */             return (Class)TenderOptionsPropertyModel.class;
/*       */           }
/*       */         });
/* 11635 */     addInterfaces("dtv.xst.dao.tnd.ITenderOptionsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11637 */             return (Class)TenderOptionsPropertyModel.class;
/*       */           }
/*       */         });
/* 11640 */     addDaos("TenderOptionsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11642 */             return (Class)TenderOptionsPropertyDAO.class;
/*       */           }
/*       */         });
/* 11645 */     addObjectIds("TenderOptionsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11647 */             return (Class)TenderOptionsPropertyId.class;
/*       */           }
/*       */         });
/* 11650 */     addDataModels("dtv.xst.dao.tnd.impl.TenderPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11652 */             return (Class)TenderPropertyModel.class;
/*       */           }
/*       */         });
/* 11655 */     addInterfaces("dtv.xst.dao.tnd.ITenderProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11657 */             return (Class)TenderPropertyModel.class;
/*       */           }
/*       */         });
/* 11660 */     addDaos("TenderProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11662 */             return (Class)TenderPropertyDAO.class;
/*       */           }
/*       */         });
/* 11665 */     addObjectIds("TenderProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11667 */             return (Class)TenderPropertyId.class;
/*       */           }
/*       */         });
/* 11670 */     addDataModels("dtv.xst.dao.tnd.impl.TenderAvailabilityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11672 */             return (Class)TenderAvailabilityPropertyModel.class;
/*       */           }
/*       */         });
/* 11675 */     addInterfaces("dtv.xst.dao.tnd.ITenderAvailabilityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11677 */             return (Class)TenderAvailabilityPropertyModel.class;
/*       */           }
/*       */         });
/* 11680 */     addDaos("TenderAvailabilityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11682 */             return (Class)TenderAvailabilityPropertyDAO.class;
/*       */           }
/*       */         });
/* 11685 */     addObjectIds("TenderAvailabilityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11687 */             return (Class)TenderAvailabilityPropertyId.class;
/*       */           }
/*       */         });
/* 11690 */     addDataModels("dtv.xst.dao.tnd.impl.TenderDenominationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11692 */             return (Class)TenderDenominationPropertyModel.class;
/*       */           }
/*       */         });
/* 11695 */     addInterfaces("dtv.xst.dao.tnd.ITenderDenominationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11697 */             return (Class)TenderDenominationPropertyModel.class;
/*       */           }
/*       */         });
/* 11700 */     addDaos("TenderDenominationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11702 */             return (Class)TenderDenominationPropertyDAO.class;
/*       */           }
/*       */         });
/* 11705 */     addObjectIds("TenderDenominationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11707 */             return (Class)TenderDenominationPropertyId.class;
/*       */           }
/*       */         });
/* 11710 */     addDataModels("dtv.xst.dao.tnd.impl.TenderExchangeRatePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11712 */             return (Class)TenderExchangeRatePropertyModel.class;
/*       */           }
/*       */         });
/* 11715 */     addInterfaces("dtv.xst.dao.tnd.ITenderExchangeRateProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11717 */             return (Class)TenderExchangeRatePropertyModel.class;
/*       */           }
/*       */         });
/* 11720 */     addDaos("TenderExchangeRateProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11722 */             return (Class)TenderExchangeRatePropertyDAO.class;
/*       */           }
/*       */         });
/* 11725 */     addObjectIds("TenderExchangeRateProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11727 */             return (Class)TenderExchangeRatePropertyId.class;
/*       */           }
/*       */         });
/* 11730 */     addDataModels("dtv.xst.dao.tnd.impl.TenderTypePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11732 */             return (Class)TenderTypePropertyModel.class;
/*       */           }
/*       */         });
/* 11735 */     addInterfaces("dtv.xst.dao.tnd.ITenderTypeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11737 */             return (Class)TenderTypePropertyModel.class;
/*       */           }
/*       */         });
/* 11740 */     addDaos("TenderTypeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11742 */             return (Class)TenderTypePropertyDAO.class;
/*       */           }
/*       */         });
/* 11745 */     addObjectIds("TenderTypeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11747 */             return (Class)TenderTypePropertyId.class;
/*       */           }
/*       */         });
/* 11750 */     addDataModels("dtv.xst.dao.tnd.impl.TenderUserSettingsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11752 */             return (Class)TenderUserSettingsPropertyModel.class;
/*       */           }
/*       */         });
/* 11755 */     addInterfaces("dtv.xst.dao.tnd.ITenderUserSettingsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11757 */             return (Class)TenderUserSettingsPropertyModel.class;
/*       */           }
/*       */         });
/* 11760 */     addDaos("TenderUserSettingsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11762 */             return (Class)TenderUserSettingsPropertyDAO.class;
/*       */           }
/*       */         });
/* 11765 */     addObjectIds("TenderUserSettingsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11767 */             return (Class)TenderUserSettingsPropertyId.class;
/*       */           }
/*       */         });
/* 11770 */     addDataModels("dtv.xst.dao.ctl.impl.IpCashDrawerDevicePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11772 */             return (Class)IpCashDrawerDevicePropertyModel.class;
/*       */           }
/*       */         });
/* 11775 */     addInterfaces("dtv.xst.dao.ctl.IIpCashDrawerDeviceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11777 */             return (Class)IpCashDrawerDevicePropertyModel.class;
/*       */           }
/*       */         });
/* 11780 */     addDaos("IpCashDrawerDeviceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11782 */             return (Class)IpCashDrawerDevicePropertyDAO.class;
/*       */           }
/*       */         });
/* 11785 */     addObjectIds("IpCashDrawerDeviceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11787 */             return (Class)IpCashDrawerDevicePropertyId.class;
/*       */           }
/*       */         });
/* 11790 */     addDataModels("dtv.xst.dao.ctl.impl.CheetahClientDeviceAccessPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11792 */             return (Class)CheetahClientDeviceAccessPropertyModel.class;
/*       */           }
/*       */         });
/* 11795 */     addInterfaces("dtv.xst.dao.ctl.ICheetahClientDeviceAccessProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11797 */             return (Class)CheetahClientDeviceAccessPropertyModel.class;
/*       */           }
/*       */         });
/* 11800 */     addDaos("CheetahClientDeviceAccessProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11802 */             return (Class)CheetahClientDeviceAccessPropertyDAO.class;
/*       */           }
/*       */         });
/* 11805 */     addObjectIds("CheetahClientDeviceAccessProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11807 */             return (Class)CheetahClientDeviceAccessPropertyId.class;
/*       */           }
/*       */         });
/* 11810 */     addDataModels("dtv.xst.dao.ctl.impl.DataLoaderFailurePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11812 */             return (Class)DataLoaderFailurePropertyModel.class;
/*       */           }
/*       */         });
/* 11815 */     addInterfaces("dtv.xst.dao.ctl.IDataLoaderFailureProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11817 */             return (Class)DataLoaderFailurePropertyModel.class;
/*       */           }
/*       */         });
/* 11820 */     addDaos("DataLoaderFailureProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11822 */             return (Class)DataLoaderFailurePropertyDAO.class;
/*       */           }
/*       */         });
/* 11825 */     addObjectIds("DataLoaderFailureProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11827 */             return (Class)DataLoaderFailurePropertyId.class;
/*       */           }
/*       */         });
/* 11830 */     addDataModels("dtv.xst.dao.ctl.impl.DataLoaderSummaryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11832 */             return (Class)DataLoaderSummaryPropertyModel.class;
/*       */           }
/*       */         });
/* 11835 */     addInterfaces("dtv.xst.dao.ctl.IDataLoaderSummaryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11837 */             return (Class)DataLoaderSummaryPropertyModel.class;
/*       */           }
/*       */         });
/* 11840 */     addDaos("DataLoaderSummaryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11842 */             return (Class)DataLoaderSummaryPropertyDAO.class;
/*       */           }
/*       */         });
/* 11845 */     addObjectIds("DataLoaderSummaryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11847 */             return (Class)DataLoaderSummaryPropertyId.class;
/*       */           }
/*       */         });
/* 11850 */     addDataModels("dtv.xst.dao.ctl.impl.DeviceRegistrationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11852 */             return (Class)DeviceRegistrationPropertyModel.class;
/*       */           }
/*       */         });
/* 11855 */     addInterfaces("dtv.xst.dao.ctl.IDeviceRegistrationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11857 */             return (Class)DeviceRegistrationPropertyModel.class;
/*       */           }
/*       */         });
/* 11860 */     addDaos("DeviceRegistrationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11862 */             return (Class)DeviceRegistrationPropertyDAO.class;
/*       */           }
/*       */         });
/* 11865 */     addObjectIds("DeviceRegistrationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11867 */             return (Class)DeviceRegistrationPropertyId.class;
/*       */           }
/*       */         });
/* 11870 */     addDataModels("dtv.xst.dao.ctl.impl.VersionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11872 */             return (Class)VersionPropertyModel.class;
/*       */           }
/*       */         });
/* 11875 */     addInterfaces("dtv.xst.dao.ctl.IVersionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11877 */             return (Class)VersionPropertyModel.class;
/*       */           }
/*       */         });
/* 11880 */     addDaos("VersionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11882 */             return (Class)VersionPropertyDAO.class;
/*       */           }
/*       */         });
/* 11885 */     addObjectIds("VersionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11887 */             return (Class)VersionPropertyId.class;
/*       */           }
/*       */         });
/* 11890 */     addDataModels("dtv.xst.dao.loc.impl.RetailLocationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11892 */             return (Class)RetailLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 11895 */     addInterfaces("dtv.xst.dao.loc.IRetailLocationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11897 */             return (Class)RetailLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 11900 */     addDaos("RetailLocationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11902 */             return (Class)RetailLocationPropertyDAO.class;
/*       */           }
/*       */         });
/* 11905 */     addObjectIds("RetailLocationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11907 */             return (Class)RetailLocationPropertyId.class;
/*       */           }
/*       */         });
/* 11910 */     addDataModels("dtv.xst.dao.loc.impl.OrgHierarchyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11912 */             return (Class)OrgHierarchyPropertyModel.class;
/*       */           }
/*       */         });
/* 11915 */     addInterfaces("dtv.xst.dao.loc.IOrgHierarchyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11917 */             return (Class)OrgHierarchyPropertyModel.class;
/*       */           }
/*       */         });
/* 11920 */     addDaos("OrgHierarchyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11922 */             return (Class)OrgHierarchyPropertyDAO.class;
/*       */           }
/*       */         });
/* 11925 */     addObjectIds("OrgHierarchyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11927 */             return (Class)OrgHierarchyPropertyId.class;
/*       */           }
/*       */         });
/* 11930 */     addDataModels("dtv.xst.dao.loc.impl.PricingHierarchyPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11932 */             return (Class)PricingHierarchyPropertyModel.class;
/*       */           }
/*       */         });
/* 11935 */     addInterfaces("dtv.xst.dao.loc.IPricingHierarchyProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11937 */             return (Class)PricingHierarchyPropertyModel.class;
/*       */           }
/*       */         });
/* 11940 */     addDaos("PricingHierarchyProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11942 */             return (Class)PricingHierarchyPropertyDAO.class;
/*       */           }
/*       */         });
/* 11945 */     addObjectIds("PricingHierarchyProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11947 */             return (Class)PricingHierarchyPropertyId.class;
/*       */           }
/*       */         });
/* 11950 */     addDataModels("dtv.xst.dao.loc.impl.WorkstationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11952 */             return (Class)WorkstationPropertyModel.class;
/*       */           }
/*       */         });
/* 11955 */     addInterfaces("dtv.xst.dao.loc.IWorkstationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11957 */             return (Class)WorkstationPropertyModel.class;
/*       */           }
/*       */         });
/* 11960 */     addDaos("WorkstationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11962 */             return (Class)WorkstationPropertyDAO.class;
/*       */           }
/*       */         });
/* 11965 */     addObjectIds("WorkstationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11967 */             return (Class)WorkstationPropertyId.class;
/*       */           }
/*       */         });
/* 11970 */     addDataModels("dtv.xst.dao.loc.impl.CloseDatesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11972 */             return (Class)CloseDatesPropertyModel.class;
/*       */           }
/*       */         });
/* 11975 */     addInterfaces("dtv.xst.dao.loc.ICloseDatesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11977 */             return (Class)CloseDatesPropertyModel.class;
/*       */           }
/*       */         });
/* 11980 */     addDaos("CloseDatesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 11982 */             return (Class)CloseDatesPropertyDAO.class;
/*       */           }
/*       */         });
/* 11985 */     addObjectIds("CloseDatesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 11987 */             return (Class)CloseDatesPropertyId.class;
/*       */           }
/*       */         });
/* 11990 */     addDataModels("dtv.xst.dao.loc.impl.ClosingMessagePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 11992 */             return (Class)ClosingMessagePropertyModel.class;
/*       */           }
/*       */         });
/* 11995 */     addInterfaces("dtv.xst.dao.loc.IClosingMessageProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 11997 */             return (Class)ClosingMessagePropertyModel.class;
/*       */           }
/*       */         });
/* 12000 */     addDaos("ClosingMessageProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12002 */             return (Class)ClosingMessagePropertyDAO.class;
/*       */           }
/*       */         });
/* 12005 */     addObjectIds("ClosingMessageProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12007 */             return (Class)ClosingMessagePropertyId.class;
/*       */           }
/*       */         });
/* 12010 */     addDataModels("dtv.xst.dao.loc.impl.CycleQuestionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12012 */             return (Class)CycleQuestionPropertyModel.class;
/*       */           }
/*       */         });
/* 12015 */     addInterfaces("dtv.xst.dao.loc.ICycleQuestionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12017 */             return (Class)CycleQuestionPropertyModel.class;
/*       */           }
/*       */         });
/* 12020 */     addDaos("CycleQuestionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12022 */             return (Class)CycleQuestionPropertyDAO.class;
/*       */           }
/*       */         });
/* 12025 */     addObjectIds("CycleQuestionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12027 */             return (Class)CycleQuestionPropertyId.class;
/*       */           }
/*       */         });
/* 12030 */     addDataModels("dtv.xst.dao.loc.impl.CycleQuestionAnswerPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12032 */             return (Class)CycleQuestionAnswerPropertyModel.class;
/*       */           }
/*       */         });
/* 12035 */     addInterfaces("dtv.xst.dao.loc.ICycleQuestionAnswerProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12037 */             return (Class)CycleQuestionAnswerPropertyModel.class;
/*       */           }
/*       */         });
/* 12040 */     addDaos("CycleQuestionAnswerProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12042 */             return (Class)CycleQuestionAnswerPropertyDAO.class;
/*       */           }
/*       */         });
/* 12045 */     addObjectIds("CycleQuestionAnswerProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12047 */             return (Class)CycleQuestionAnswerPropertyId.class;
/*       */           }
/*       */         });
/* 12050 */     addDataModels("dtv.xst.dao.loc.impl.CycleQuestionChoicePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12052 */             return (Class)CycleQuestionChoicePropertyModel.class;
/*       */           }
/*       */         });
/* 12055 */     addInterfaces("dtv.xst.dao.loc.ICycleQuestionChoiceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12057 */             return (Class)CycleQuestionChoicePropertyModel.class;
/*       */           }
/*       */         });
/* 12060 */     addDaos("CycleQuestionChoiceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12062 */             return (Class)CycleQuestionChoicePropertyDAO.class;
/*       */           }
/*       */         });
/* 12065 */     addObjectIds("CycleQuestionChoiceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12067 */             return (Class)CycleQuestionChoicePropertyId.class;
/*       */           }
/*       */         });
/* 12070 */     addDataModels("dtv.xst.dao.loc.impl.StateJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12072 */             return (Class)StateJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 12075 */     addInterfaces("dtv.xst.dao.loc.IStateJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12077 */             return (Class)StateJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 12080 */     addDaos("StateJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12082 */             return (Class)StateJournalPropertyDAO.class;
/*       */           }
/*       */         });
/* 12085 */     addObjectIds("StateJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12087 */             return (Class)StateJournalPropertyId.class;
/*       */           }
/*       */         });
/* 12090 */     addDataModels("dtv.xst.dao.com.impl.FlightInformationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12092 */             return (Class)FlightInformationPropertyModel.class;
/*       */           }
/*       */         });
/* 12095 */     addInterfaces("dtv.xst.dao.com.IFlightInformationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12097 */             return (Class)FlightInformationPropertyModel.class;
/*       */           }
/*       */         });
/* 12100 */     addDaos("FlightInformationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12102 */             return (Class)FlightInformationPropertyDAO.class;
/*       */           }
/*       */         });
/* 12105 */     addObjectIds("FlightInformationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12107 */             return (Class)FlightInformationPropertyId.class;
/*       */           }
/*       */         });
/* 12110 */     addDataModels("dtv.xst.dao.com.impl.AirportPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12112 */             return (Class)AirportPropertyModel.class;
/*       */           }
/*       */         });
/* 12115 */     addInterfaces("dtv.xst.dao.com.IAirportProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12117 */             return (Class)AirportPropertyModel.class;
/*       */           }
/*       */         });
/* 12120 */     addDaos("AirportProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12122 */             return (Class)AirportPropertyDAO.class;
/*       */           }
/*       */         });
/* 12125 */     addObjectIds("AirportProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12127 */             return (Class)AirportPropertyId.class;
/*       */           }
/*       */         });
/* 12130 */     addDataModels("dtv.xst.dao.com.impl.ButtonGridPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12132 */             return (Class)ButtonGridPropertyModel.class;
/*       */           }
/*       */         });
/* 12135 */     addInterfaces("dtv.xst.dao.com.IButtonGridProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12137 */             return (Class)ButtonGridPropertyModel.class;
/*       */           }
/*       */         });
/* 12140 */     addDaos("ButtonGridProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12142 */             return (Class)ButtonGridPropertyDAO.class;
/*       */           }
/*       */         });
/* 12145 */     addObjectIds("ButtonGridProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12147 */             return (Class)ButtonGridPropertyId.class;
/*       */           }
/*       */         });
/* 12150 */     addDataModels("dtv.xst.dao.com.impl.CodeValuePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12152 */             return (Class)CodeValuePropertyModel.class;
/*       */           }
/*       */         });
/* 12155 */     addInterfaces("dtv.xst.dao.com.ICodeValueProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12157 */             return (Class)CodeValuePropertyModel.class;
/*       */           }
/*       */         });
/* 12160 */     addDaos("CodeValueProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12162 */             return (Class)CodeValuePropertyDAO.class;
/*       */           }
/*       */         });
/* 12165 */     addObjectIds("CodeValueProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12167 */             return (Class)CodeValuePropertyId.class;
/*       */           }
/*       */         });
/* 12170 */     addDataModels("dtv.xst.dao.com.impl.DatabaseTranslationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12172 */             return (Class)DatabaseTranslationPropertyModel.class;
/*       */           }
/*       */         });
/* 12175 */     addInterfaces("dtv.xst.dao.com.IDatabaseTranslationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12177 */             return (Class)DatabaseTranslationPropertyModel.class;
/*       */           }
/*       */         });
/* 12180 */     addDaos("DatabaseTranslationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12182 */             return (Class)DatabaseTranslationPropertyDAO.class;
/*       */           }
/*       */         });
/* 12185 */     addObjectIds("DatabaseTranslationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12187 */             return (Class)DatabaseTranslationPropertyId.class;
/*       */           }
/*       */         });
/* 12190 */     addDataModels("dtv.xst.dao.com.impl.SequencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12192 */             return (Class)SequencePropertyModel.class;
/*       */           }
/*       */         });
/* 12195 */     addInterfaces("dtv.xst.dao.com.ISequenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12197 */             return (Class)SequencePropertyModel.class;
/*       */           }
/*       */         });
/* 12200 */     addDaos("SequenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12202 */             return (Class)SequencePropertyDAO.class;
/*       */           }
/*       */         });
/* 12205 */     addObjectIds("SequenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12207 */             return (Class)SequencePropertyId.class;
/*       */           }
/*       */         });
/* 12210 */     addDataModels("dtv.xst.dao.com.impl.AddressPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12212 */             return (Class)AddressPropertyModel.class;
/*       */           }
/*       */         });
/* 12215 */     addInterfaces("dtv.xst.dao.com.IAddressProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12217 */             return (Class)AddressPropertyModel.class;
/*       */           }
/*       */         });
/* 12220 */     addDaos("AddressProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12222 */             return (Class)AddressPropertyDAO.class;
/*       */           }
/*       */         });
/* 12225 */     addObjectIds("AddressProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12227 */             return (Class)AddressPropertyId.class;
/*       */           }
/*       */         });
/* 12230 */     addDataModels("dtv.xst.dao.com.impl.AddressCountryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12232 */             return (Class)AddressCountryPropertyModel.class;
/*       */           }
/*       */         });
/* 12235 */     addInterfaces("dtv.xst.dao.com.IAddressCountryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12237 */             return (Class)AddressCountryPropertyModel.class;
/*       */           }
/*       */         });
/* 12240 */     addDaos("AddressCountryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12242 */             return (Class)AddressCountryPropertyDAO.class;
/*       */           }
/*       */         });
/* 12245 */     addObjectIds("AddressCountryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12247 */             return (Class)AddressCountryPropertyId.class;
/*       */           }
/*       */         });
/* 12250 */     addDataModels("dtv.xst.dao.com.impl.AddressPostalCodePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12252 */             return (Class)AddressPostalCodePropertyModel.class;
/*       */           }
/*       */         });
/* 12255 */     addInterfaces("dtv.xst.dao.com.IAddressPostalCodeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12257 */             return (Class)AddressPostalCodePropertyModel.class;
/*       */           }
/*       */         });
/* 12260 */     addDaos("AddressPostalCodeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12262 */             return (Class)AddressPostalCodePropertyDAO.class;
/*       */           }
/*       */         });
/* 12265 */     addObjectIds("AddressPostalCodeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12267 */             return (Class)AddressPostalCodePropertyId.class;
/*       */           }
/*       */         });
/* 12270 */     addDataModels("dtv.xst.dao.com.impl.AddressStatePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12272 */             return (Class)AddressStatePropertyModel.class;
/*       */           }
/*       */         });
/* 12275 */     addInterfaces("dtv.xst.dao.com.IAddressStateProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12277 */             return (Class)AddressStatePropertyModel.class;
/*       */           }
/*       */         });
/* 12280 */     addDaos("AddressStateProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12282 */             return (Class)AddressStatePropertyDAO.class;
/*       */           }
/*       */         });
/* 12285 */     addObjectIds("AddressStateProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12287 */             return (Class)AddressStatePropertyId.class;
/*       */           }
/*       */         });
/* 12290 */     addDataModels("dtv.xst.dao.com.impl.CountryReturnMapPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12292 */             return (Class)CountryReturnMapPropertyModel.class;
/*       */           }
/*       */         });
/* 12295 */     addInterfaces("dtv.xst.dao.com.ICountryReturnMapProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12297 */             return (Class)CountryReturnMapPropertyModel.class;
/*       */           }
/*       */         });
/* 12300 */     addDaos("CountryReturnMapProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12302 */             return (Class)CountryReturnMapPropertyDAO.class;
/*       */           }
/*       */         });
/* 12305 */     addObjectIds("CountryReturnMapProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12307 */             return (Class)CountryReturnMapPropertyId.class;
/*       */           }
/*       */         });
/* 12310 */     addDataModels("dtv.xst.dao.com.impl.ReasonCodePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12312 */             return (Class)ReasonCodePropertyModel.class;
/*       */           }
/*       */         });
/* 12315 */     addInterfaces("dtv.xst.dao.com.IReasonCodeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12317 */             return (Class)ReasonCodePropertyModel.class;
/*       */           }
/*       */         });
/* 12320 */     addDaos("ReasonCodeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12322 */             return (Class)ReasonCodePropertyDAO.class;
/*       */           }
/*       */         });
/* 12325 */     addObjectIds("ReasonCodeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12327 */             return (Class)ReasonCodePropertyId.class;
/*       */           }
/*       */         });
/* 12330 */     addDataModels("dtv.xst.dao.com.impl.ReceiptTextPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12332 */             return (Class)ReceiptTextPropertyModel.class;
/*       */           }
/*       */         });
/* 12335 */     addInterfaces("dtv.xst.dao.com.IReceiptTextProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12337 */             return (Class)ReceiptTextPropertyModel.class;
/*       */           }
/*       */         });
/* 12340 */     addDaos("ReceiptTextProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12342 */             return (Class)ReceiptTextPropertyDAO.class;
/*       */           }
/*       */         });
/* 12345 */     addObjectIds("ReceiptTextProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12347 */             return (Class)ReceiptTextPropertyId.class;
/*       */           }
/*       */         });
/* 12350 */     addDataModels("dtv.xst.dao.com.impl.ReportDataPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12352 */             return (Class)ReportDataPropertyModel.class;
/*       */           }
/*       */         });
/* 12355 */     addInterfaces("dtv.xst.dao.com.IReportDataProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12357 */             return (Class)ReportDataPropertyModel.class;
/*       */           }
/*       */         });
/* 12360 */     addDaos("ReportDataProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12362 */             return (Class)ReportDataPropertyDAO.class;
/*       */           }
/*       */         });
/* 12365 */     addObjectIds("ReportDataProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12367 */             return (Class)ReportDataPropertyId.class;
/*       */           }
/*       */         });
/* 12370 */     addDataModels("dtv.xst.dao.com.impl.ReportLookupPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12372 */             return (Class)ReportLookupPropertyModel.class;
/*       */           }
/*       */         });
/* 12375 */     addInterfaces("dtv.xst.dao.com.IReportLookupProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12377 */             return (Class)ReportLookupPropertyModel.class;
/*       */           }
/*       */         });
/* 12380 */     addDaos("ReportLookupProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12382 */             return (Class)ReportLookupPropertyDAO.class;
/*       */           }
/*       */         });
/* 12385 */     addObjectIds("ReportLookupProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12387 */             return (Class)ReportLookupPropertyId.class;
/*       */           }
/*       */         });
/* 12390 */     addDataModels("dtv.xst.dao.com.impl.SequencePartPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12392 */             return (Class)SequencePartPropertyModel.class;
/*       */           }
/*       */         });
/* 12395 */     addInterfaces("dtv.xst.dao.com.ISequencePartProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12397 */             return (Class)SequencePartPropertyModel.class;
/*       */           }
/*       */         });
/* 12400 */     addDaos("SequencePartProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12402 */             return (Class)SequencePartPropertyDAO.class;
/*       */           }
/*       */         });
/* 12405 */     addObjectIds("SequencePartProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12407 */             return (Class)SequencePartPropertyId.class;
/*       */           }
/*       */         });
/* 12410 */     addDataModels("dtv.xst.dao.com.impl.ShippingCostPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12412 */             return (Class)ShippingCostPropertyModel.class;
/*       */           }
/*       */         });
/* 12415 */     addInterfaces("dtv.xst.dao.com.IShippingCostProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12417 */             return (Class)ShippingCostPropertyModel.class;
/*       */           }
/*       */         });
/* 12420 */     addDaos("ShippingCostProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12422 */             return (Class)ShippingCostPropertyDAO.class;
/*       */           }
/*       */         });
/* 12425 */     addObjectIds("ShippingCostProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12427 */             return (Class)ShippingCostPropertyId.class;
/*       */           }
/*       */         });
/* 12430 */     addDataModels("dtv.xst.dao.com.impl.TransactionPropertyPromptPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12432 */             return (Class)TransactionPropertyPromptPropertyModel.class;
/*       */           }
/*       */         });
/* 12435 */     addInterfaces("dtv.xst.dao.com.ITransactionPropertyPromptProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12437 */             return (Class)TransactionPropertyPromptPropertyModel.class;
/*       */           }
/*       */         });
/* 12440 */     addDaos("TransactionPropertyPromptProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12442 */             return (Class)TransactionPropertyPromptPropertyDAO.class;
/*       */           }
/*       */         });
/* 12445 */     addObjectIds("TransactionPropertyPromptProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12447 */             return (Class)TransactionPropertyPromptPropertyId.class;
/*       */           }
/*       */         });
/* 12450 */     addDataModels("dtv.xst.dao.com.impl.AirportZonePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12452 */             return (Class)AirportZonePropertyModel.class;
/*       */           }
/*       */         });
/* 12455 */     addInterfaces("dtv.xst.dao.com.IAirportZoneProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12457 */             return (Class)AirportZonePropertyModel.class;
/*       */           }
/*       */         });
/* 12460 */     addDaos("AirportZoneProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12462 */             return (Class)AirportZonePropertyDAO.class;
/*       */           }
/*       */         });
/* 12465 */     addObjectIds("AirportZoneProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12467 */             return (Class)AirportZonePropertyId.class;
/*       */           }
/*       */         });
/* 12470 */     addDataModels("dtv.xst.dao.com.impl.AirportZoneDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12472 */             return (Class)AirportZoneDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 12475 */     addInterfaces("dtv.xst.dao.com.IAirportZoneDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12477 */             return (Class)AirportZoneDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 12480 */     addDaos("AirportZoneDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12482 */             return (Class)AirportZoneDetailPropertyDAO.class;
/*       */           }
/*       */         });
/* 12485 */     addObjectIds("AirportZoneDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12487 */             return (Class)AirportZoneDetailPropertyId.class;
/*       */           }
/*       */         });
/* 12490 */     addDataModels("dtv.xst.dao.com.impl.ShippingFeePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12492 */             return (Class)ShippingFeePropertyModel.class;
/*       */           }
/*       */         });
/* 12495 */     addInterfaces("dtv.xst.dao.com.IShippingFeeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12497 */             return (Class)ShippingFeePropertyModel.class;
/*       */           }
/*       */         });
/* 12500 */     addDaos("ShippingFeeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12502 */             return (Class)ShippingFeePropertyDAO.class;
/*       */           }
/*       */         });
/* 12505 */     addObjectIds("ShippingFeeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12507 */             return (Class)ShippingFeePropertyId.class;
/*       */           }
/*       */         });
/* 12510 */     addDataModels("dtv.xst.dao.com.impl.ShippingFeeTierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12512 */             return (Class)ShippingFeeTierPropertyModel.class;
/*       */           }
/*       */         });
/* 12515 */     addInterfaces("dtv.xst.dao.com.IShippingFeeTierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12517 */             return (Class)ShippingFeeTierPropertyModel.class;
/*       */           }
/*       */         });
/* 12520 */     addDaos("ShippingFeeTierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12522 */             return (Class)ShippingFeeTierPropertyDAO.class;
/*       */           }
/*       */         });
/* 12525 */     addObjectIds("ShippingFeeTierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12527 */             return (Class)ShippingFeeTierPropertyId.class;
/*       */           }
/*       */         });
/* 12530 */     addDataModels("dtv.xst.dao._test.impl.XunitResultPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12532 */             return (Class)XunitResultPropertyModel.class;
/*       */           }
/*       */         });
/* 12535 */     addInterfaces("dtv.xst.dao._test.IXunitResultProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12537 */             return (Class)XunitResultPropertyModel.class;
/*       */           }
/*       */         });
/* 12540 */     addDaos("XunitResultProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12542 */             return (Class)XunitResultPropertyDAO.class;
/*       */           }
/*       */         });
/* 12545 */     addObjectIds("XunitResultProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12547 */             return (Class)XunitResultPropertyId.class;
/*       */           }
/*       */         });
/* 12550 */     addDataModels("dtv.xst.dao._test.impl.XunitResultItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12552 */             return (Class)XunitResultItemPropertyModel.class;
/*       */           }
/*       */         });
/* 12555 */     addInterfaces("dtv.xst.dao._test.IXunitResultItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12557 */             return (Class)XunitResultItemPropertyModel.class;
/*       */           }
/*       */         });
/* 12560 */     addDaos("XunitResultItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12562 */             return (Class)XunitResultItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 12565 */     addObjectIds("XunitResultItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12567 */             return (Class)XunitResultItemPropertyId.class;
/*       */           }
/*       */         });
/* 12570 */     addDataModels("dtv.xst.dao.hrs.impl.WorkCodesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12572 */             return (Class)WorkCodesPropertyModel.class;
/*       */           }
/*       */         });
/* 12575 */     addInterfaces("dtv.xst.dao.hrs.IWorkCodesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12577 */             return (Class)WorkCodesPropertyModel.class;
/*       */           }
/*       */         });
/* 12580 */     addDaos("WorkCodesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12582 */             return (Class)WorkCodesPropertyDAO.class;
/*       */           }
/*       */         });
/* 12585 */     addObjectIds("WorkCodesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12587 */             return (Class)WorkCodesPropertyId.class;
/*       */           }
/*       */         });
/* 12590 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12592 */             return (Class)EmployeePropertyModel.class;
/*       */           }
/*       */         });
/* 12595 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12597 */             return (Class)EmployeePropertyModel.class;
/*       */           }
/*       */         });
/* 12600 */     addDaos("EmployeeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12602 */             return (Class)EmployeePropertyDAO.class;
/*       */           }
/*       */         });
/* 12605 */     addObjectIds("EmployeeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12607 */             return (Class)EmployeePropertyId.class;
/*       */           }
/*       */         });
/* 12610 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeFingerprintPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12612 */             return (Class)EmployeeFingerprintPropertyModel.class;
/*       */           }
/*       */         });
/* 12615 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeFingerprintProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12617 */             return (Class)EmployeeFingerprintPropertyModel.class;
/*       */           }
/*       */         });
/* 12620 */     addDaos("EmployeeFingerprintProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12622 */             return (Class)EmployeeFingerprintPropertyDAO.class;
/*       */           }
/*       */         });
/* 12625 */     addObjectIds("EmployeeFingerprintProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12627 */             return (Class)EmployeeFingerprintPropertyId.class;
/*       */           }
/*       */         });
/* 12630 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeMessagePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12632 */             return (Class)EmployeeMessagePropertyModel.class;
/*       */           }
/*       */         });
/* 12635 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeMessageProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12637 */             return (Class)EmployeeMessagePropertyModel.class;
/*       */           }
/*       */         });
/* 12640 */     addDaos("EmployeeMessageProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12642 */             return (Class)EmployeeMessagePropertyDAO.class;
/*       */           }
/*       */         });
/* 12645 */     addObjectIds("EmployeeMessageProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12647 */             return (Class)EmployeeMessagePropertyId.class;
/*       */           }
/*       */         });
/* 12650 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeAnswersPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12652 */             return (Class)EmployeeAnswersPropertyModel.class;
/*       */           }
/*       */         });
/* 12655 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeAnswersProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12657 */             return (Class)EmployeeAnswersPropertyModel.class;
/*       */           }
/*       */         });
/* 12660 */     addDaos("EmployeeAnswersProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12662 */             return (Class)EmployeeAnswersPropertyDAO.class;
/*       */           }
/*       */         });
/* 12665 */     addObjectIds("EmployeeAnswersProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12667 */             return (Class)EmployeeAnswersPropertyId.class;
/*       */           }
/*       */         });
/* 12670 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeNotePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12672 */             return (Class)EmployeeNotePropertyModel.class;
/*       */           }
/*       */         });
/* 12675 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeNoteProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12677 */             return (Class)EmployeeNotePropertyModel.class;
/*       */           }
/*       */         });
/* 12680 */     addDaos("EmployeeNoteProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12682 */             return (Class)EmployeeNotePropertyDAO.class;
/*       */           }
/*       */         });
/* 12685 */     addObjectIds("EmployeeNoteProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12687 */             return (Class)EmployeeNotePropertyId.class;
/*       */           }
/*       */         });
/* 12690 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeePasswordPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12692 */             return (Class)EmployeePasswordPropertyModel.class;
/*       */           }
/*       */         });
/* 12695 */     addInterfaces("dtv.xst.dao.hrs.IEmployeePasswordProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12697 */             return (Class)EmployeePasswordPropertyModel.class;
/*       */           }
/*       */         });
/* 12700 */     addDaos("EmployeePasswordProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12702 */             return (Class)EmployeePasswordPropertyDAO.class;
/*       */           }
/*       */         });
/* 12705 */     addObjectIds("EmployeePasswordProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12707 */             return (Class)EmployeePasswordPropertyId.class;
/*       */           }
/*       */         });
/* 12710 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeStorePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12712 */             return (Class)EmployeeStorePropertyModel.class;
/*       */           }
/*       */         });
/* 12715 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeStoreProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12717 */             return (Class)EmployeeStorePropertyModel.class;
/*       */           }
/*       */         });
/* 12720 */     addDaos("EmployeeStoreProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12722 */             return (Class)EmployeeStorePropertyDAO.class;
/*       */           }
/*       */         });
/* 12725 */     addObjectIds("EmployeeStoreProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12727 */             return (Class)EmployeeStorePropertyId.class;
/*       */           }
/*       */         });
/* 12730 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeTaskPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12732 */             return (Class)EmployeeTaskPropertyModel.class;
/*       */           }
/*       */         });
/* 12735 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeTaskProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12737 */             return (Class)EmployeeTaskPropertyModel.class;
/*       */           }
/*       */         });
/* 12740 */     addDaos("EmployeeTaskProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12742 */             return (Class)EmployeeTaskPropertyDAO.class;
/*       */           }
/*       */         });
/* 12745 */     addObjectIds("EmployeeTaskProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12747 */             return (Class)EmployeeTaskPropertyId.class;
/*       */           }
/*       */         });
/* 12750 */     addDataModels("dtv.xst.dao.hrs.impl.EmployeeTaskNotePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12752 */             return (Class)EmployeeTaskNotePropertyModel.class;
/*       */           }
/*       */         });
/* 12755 */     addInterfaces("dtv.xst.dao.hrs.IEmployeeTaskNoteProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12757 */             return (Class)EmployeeTaskNotePropertyModel.class;
/*       */           }
/*       */         });
/* 12760 */     addDaos("EmployeeTaskNoteProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12762 */             return (Class)EmployeeTaskNotePropertyDAO.class;
/*       */           }
/*       */         });
/* 12765 */     addObjectIds("EmployeeTaskNoteProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12767 */             return (Class)EmployeeTaskNotePropertyId.class;
/*       */           }
/*       */         });
/* 12770 */     addDataModels("dtv.xst.dao.sec.impl.UserPasswordPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12772 */             return (Class)UserPasswordPropertyModel.class;
/*       */           }
/*       */         });
/* 12775 */     addInterfaces("dtv.xst.dao.sec.IUserPasswordProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12777 */             return (Class)UserPasswordPropertyModel.class;
/*       */           }
/*       */         });
/* 12780 */     addDaos("UserPasswordProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12782 */             return (Class)UserPasswordPropertyDAO.class;
/*       */           }
/*       */         });
/* 12785 */     addObjectIds("UserPasswordProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12787 */             return (Class)UserPasswordPropertyId.class;
/*       */           }
/*       */         });
/* 12790 */     addDataModels("dtv.xst.dao.sec.impl.UserRolePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12792 */             return (Class)UserRolePropertyModel.class;
/*       */           }
/*       */         });
/* 12795 */     addInterfaces("dtv.xst.dao.sec.IUserRoleProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12797 */             return (Class)UserRolePropertyModel.class;
/*       */           }
/*       */         });
/* 12800 */     addDaos("UserRoleProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12802 */             return (Class)UserRolePropertyDAO.class;
/*       */           }
/*       */         });
/* 12805 */     addObjectIds("UserRoleProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12807 */             return (Class)UserRolePropertyId.class;
/*       */           }
/*       */         });
/* 12810 */     addDataModels("dtv.xst.dao.sec.impl.AccessControlListPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12812 */             return (Class)AccessControlListPropertyModel.class;
/*       */           }
/*       */         });
/* 12815 */     addInterfaces("dtv.xst.dao.sec.IAccessControlListProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12817 */             return (Class)AccessControlListPropertyModel.class;
/*       */           }
/*       */         });
/* 12820 */     addDaos("AccessControlListProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12822 */             return (Class)AccessControlListPropertyDAO.class;
/*       */           }
/*       */         });
/* 12825 */     addObjectIds("AccessControlListProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12827 */             return (Class)AccessControlListPropertyId.class;
/*       */           }
/*       */         });
/* 12830 */     addDataModels("dtv.xst.dao.sec.impl.AclAccessTypePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12832 */             return (Class)AclAccessTypePropertyModel.class;
/*       */           }
/*       */         });
/* 12835 */     addInterfaces("dtv.xst.dao.sec.IAclAccessTypeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12837 */             return (Class)AclAccessTypePropertyModel.class;
/*       */           }
/*       */         });
/* 12840 */     addDaos("AclAccessTypeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12842 */             return (Class)AclAccessTypePropertyDAO.class;
/*       */           }
/*       */         });
/* 12845 */     addObjectIds("AclAccessTypeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12847 */             return (Class)AclAccessTypePropertyId.class;
/*       */           }
/*       */         });
/* 12850 */     addDataModels("dtv.xst.dao.sec.impl.GroupPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12852 */             return (Class)GroupPropertyModel.class;
/*       */           }
/*       */         });
/* 12855 */     addInterfaces("dtv.xst.dao.sec.IGroupProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12857 */             return (Class)GroupPropertyModel.class;
/*       */           }
/*       */         });
/* 12860 */     addDaos("GroupProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12862 */             return (Class)GroupPropertyDAO.class;
/*       */           }
/*       */         });
/* 12865 */     addObjectIds("GroupProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12867 */             return (Class)GroupPropertyId.class;
/*       */           }
/*       */         });
/* 12870 */     addDataModels("dtv.xst.dao.sec.impl.PrivilegePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12872 */             return (Class)PrivilegePropertyModel.class;
/*       */           }
/*       */         });
/* 12875 */     addInterfaces("dtv.xst.dao.sec.IPrivilegeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12877 */             return (Class)PrivilegePropertyModel.class;
/*       */           }
/*       */         });
/* 12880 */     addDaos("PrivilegeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12882 */             return (Class)PrivilegePropertyDAO.class;
/*       */           }
/*       */         });
/* 12885 */     addObjectIds("PrivilegeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12887 */             return (Class)PrivilegePropertyId.class;
/*       */           }
/*       */         });
/* 12890 */     addDataModels("dtv.xst.dao.inv.impl.CartonPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12892 */             return (Class)CartonPropertyModel.class;
/*       */           }
/*       */         });
/* 12895 */     addInterfaces("dtv.xst.dao.inv.ICartonProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12897 */             return (Class)CartonPropertyModel.class;
/*       */           }
/*       */         });
/* 12900 */     addDaos("CartonProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12902 */             return (Class)CartonPropertyDAO.class;
/*       */           }
/*       */         });
/* 12905 */     addObjectIds("CartonProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12907 */             return (Class)CartonPropertyId.class;
/*       */           }
/*       */         });
/* 12910 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12912 */             return (Class)InventoryDocumentPropertyModel.class;
/*       */           }
/*       */         });
/* 12915 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12917 */             return (Class)InventoryDocumentPropertyModel.class;
/*       */           }
/*       */         });
/* 12920 */     addDaos("InventoryDocumentProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12922 */             return (Class)InventoryDocumentPropertyDAO.class;
/*       */           }
/*       */         });
/* 12925 */     addObjectIds("InventoryDocumentProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12927 */             return (Class)InventoryDocumentPropertyId.class;
/*       */           }
/*       */         });
/* 12930 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12932 */             return (Class)InventoryDocumentLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 12935 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12937 */             return (Class)InventoryDocumentLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 12940 */     addDaos("InventoryDocumentLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12942 */             return (Class)InventoryDocumentLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 12945 */     addObjectIds("InventoryDocumentLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12947 */             return (Class)InventoryDocumentLineItemPropertyId.class;
/*       */           }
/*       */         });
/* 12950 */     addDataModels("dtv.xst.dao.inv.impl.InventoryTransactionDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12952 */             return (Class)InventoryTransactionDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 12955 */     addInterfaces("dtv.xst.dao.inv.IInventoryTransactionDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12957 */             return (Class)InventoryTransactionDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 12960 */     addDaos("InventoryTransactionDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12962 */             return (Class)InventoryTransactionDetailPropertyDAO.class;
/*       */           }
/*       */         });
/* 12965 */     addObjectIds("InventoryTransactionDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12967 */             return (Class)InventoryTransactionDetailPropertyId.class;
/*       */           }
/*       */         });
/* 12970 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12972 */             return (Class)InventoryCountPropertyModel.class;
/*       */           }
/*       */         });
/* 12975 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12977 */             return (Class)InventoryCountPropertyModel.class;
/*       */           }
/*       */         });
/* 12980 */     addDaos("InventoryCountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 12982 */             return (Class)InventoryCountPropertyDAO.class;
/*       */           }
/*       */         });
/* 12985 */     addObjectIds("InventoryCountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 12987 */             return (Class)InventoryCountPropertyId.class;
/*       */           }
/*       */         });
/* 12990 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSectionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 12992 */             return (Class)InventoryCountSectionPropertyModel.class;
/*       */           }
/*       */         });
/* 12995 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSectionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 12997 */             return (Class)InventoryCountSectionPropertyModel.class;
/*       */           }
/*       */         });
/* 13000 */     addDaos("InventoryCountSectionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13002 */             return (Class)InventoryCountSectionPropertyDAO.class;
/*       */           }
/*       */         });
/* 13005 */     addObjectIds("InventoryCountSectionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13007 */             return (Class)InventoryCountSectionPropertyId.class;
/*       */           }
/*       */         });
/* 13010 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSheetPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13012 */             return (Class)InventoryCountSheetPropertyModel.class;
/*       */           }
/*       */         });
/* 13015 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSheetProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13017 */             return (Class)InventoryCountSheetPropertyModel.class;
/*       */           }
/*       */         });
/* 13020 */     addDaos("InventoryCountSheetProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13022 */             return (Class)InventoryCountSheetPropertyDAO.class;
/*       */           }
/*       */         });
/* 13025 */     addObjectIds("InventoryCountSheetProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13027 */             return (Class)InventoryCountSheetPropertyId.class;
/*       */           }
/*       */         });
/* 13030 */     addDataModels("dtv.xst.dao.inv.impl.InventoryLocationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13032 */             return (Class)InventoryLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13035 */     addInterfaces("dtv.xst.dao.inv.IInventoryLocationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13037 */             return (Class)InventoryLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13040 */     addDaos("InventoryLocationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13042 */             return (Class)InventoryLocationPropertyDAO.class;
/*       */           }
/*       */         });
/* 13045 */     addObjectIds("InventoryLocationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13047 */             return (Class)InventoryLocationPropertyId.class;
/*       */           }
/*       */         });
/* 13050 */     addDataModels("dtv.xst.dao.inv.impl.InventoryMovementPendingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13052 */             return (Class)InventoryMovementPendingPropertyModel.class;
/*       */           }
/*       */         });
/* 13055 */     addInterfaces("dtv.xst.dao.inv.IInventoryMovementPendingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13057 */             return (Class)InventoryMovementPendingPropertyModel.class;
/*       */           }
/*       */         });
/* 13060 */     addDaos("InventoryMovementPendingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13062 */             return (Class)InventoryMovementPendingPropertyDAO.class;
/*       */           }
/*       */         });
/* 13065 */     addObjectIds("InventoryMovementPendingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13067 */             return (Class)InventoryMovementPendingPropertyId.class;
/*       */           }
/*       */         });
/* 13070 */     addDataModels("dtv.xst.dao.inv.impl.MovementPendingTransactionLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13072 */             return (Class)MovementPendingTransactionLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13075 */     addInterfaces("dtv.xst.dao.inv.IMovementPendingTransactionLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13077 */             return (Class)MovementPendingTransactionLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13080 */     addDaos("MovementPendingTransactionLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13082 */             return (Class)MovementPendingTransactionLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 13085 */     addObjectIds("MovementPendingTransactionLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13087 */             return (Class)MovementPendingTransactionLineItemPropertyId.class;
/*       */           }
/*       */         });
/* 13090 */     addDataModels("dtv.xst.dao.inv.impl.ShipmentPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13092 */             return (Class)ShipmentPropertyModel.class;
/*       */           }
/*       */         });
/* 13095 */     addInterfaces("dtv.xst.dao.inv.IShipmentProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13097 */             return (Class)ShipmentPropertyModel.class;
/*       */           }
/*       */         });
/* 13100 */     addDaos("ShipmentProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13102 */             return (Class)ShipmentPropertyDAO.class;
/*       */           }
/*       */         });
/* 13105 */     addObjectIds("ShipmentProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13107 */             return (Class)ShipmentPropertyId.class;
/*       */           }
/*       */         });
/* 13110 */     addDataModels("dtv.xst.dao.inv.impl.ShipmentLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13112 */             return (Class)ShipmentLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13115 */     addInterfaces("dtv.xst.dao.inv.IShipmentLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13117 */             return (Class)ShipmentLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13120 */     addDaos("ShipmentLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13122 */             return (Class)ShipmentLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 13125 */     addObjectIds("ShipmentLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13127 */             return (Class)ShipmentLineItemPropertyId.class;
/*       */           }
/*       */         });
/* 13130 */     addDataModels("dtv.xst.dao.inv.impl.ShipmentAddressPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13132 */             return (Class)ShipmentAddressPropertyModel.class;
/*       */           }
/*       */         });
/* 13135 */     addInterfaces("dtv.xst.dao.inv.IShipmentAddressProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13137 */             return (Class)ShipmentAddressPropertyModel.class;
/*       */           }
/*       */         });
/* 13140 */     addDaos("ShipmentAddressProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13142 */             return (Class)ShipmentAddressPropertyDAO.class;
/*       */           }
/*       */         });
/* 13145 */     addObjectIds("ShipmentAddressProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13147 */             return (Class)ShipmentAddressPropertyId.class;
/*       */           }
/*       */         });
/* 13150 */     addDataModels("dtv.xst.dao.inv.impl.InventoryItemAccountModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13152 */             return (Class)InventoryItemAccountModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 13155 */     addInterfaces("dtv.xst.dao.inv.IInventoryItemAccountModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13157 */             return (Class)InventoryItemAccountModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 13160 */     addDaos("InventoryItemAccountModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13162 */             return (Class)InventoryItemAccountModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 13165 */     addObjectIds("InventoryItemAccountModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13167 */             return (Class)InventoryItemAccountModifierPropertyId.class;
/*       */           }
/*       */         });
/* 13170 */     addDataModels("dtv.xst.dao.inv.impl.DocumentInventoryLocationModifierPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13172 */             return (Class)DocumentInventoryLocationModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 13175 */     addInterfaces("dtv.xst.dao.inv.IDocumentInventoryLocationModifierProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13177 */             return (Class)DocumentInventoryLocationModifierPropertyModel.class;
/*       */           }
/*       */         });
/* 13180 */     addDaos("DocumentInventoryLocationModifierProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13182 */             return (Class)DocumentInventoryLocationModifierPropertyDAO.class;
/*       */           }
/*       */         });
/* 13185 */     addObjectIds("DocumentInventoryLocationModifierProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13187 */             return (Class)DocumentInventoryLocationModifierPropertyId.class;
/*       */           }
/*       */         });
/* 13190 */     addDataModels("dtv.xst.dao.inv.impl.DocumentNotePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13192 */             return (Class)DocumentNotePropertyModel.class;
/*       */           }
/*       */         });
/* 13195 */     addInterfaces("dtv.xst.dao.inv.IDocumentNoteProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13197 */             return (Class)DocumentNotePropertyModel.class;
/*       */           }
/*       */         });
/* 13200 */     addDaos("DocumentNoteProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13202 */             return (Class)DocumentNotePropertyDAO.class;
/*       */           }
/*       */         });
/* 13205 */     addObjectIds("DocumentNoteProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13207 */             return (Class)DocumentNotePropertyId.class;
/*       */           }
/*       */         });
/* 13210 */     addDataModels("dtv.xst.dao.inv.impl.FiscalYearPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13212 */             return (Class)FiscalYearPropertyModel.class;
/*       */           }
/*       */         });
/* 13215 */     addInterfaces("dtv.xst.dao.inv.IFiscalYearProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13217 */             return (Class)FiscalYearPropertyModel.class;
/*       */           }
/*       */         });
/* 13220 */     addDaos("FiscalYearProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13222 */             return (Class)FiscalYearPropertyDAO.class;
/*       */           }
/*       */         });
/* 13225 */     addObjectIds("FiscalYearProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13227 */             return (Class)FiscalYearPropertyId.class;
/*       */           }
/*       */         });
/* 13230 */     addDataModels("dtv.xst.dao.inv.impl.InventoryBucketPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13232 */             return (Class)InventoryBucketPropertyModel.class;
/*       */           }
/*       */         });
/* 13235 */     addInterfaces("dtv.xst.dao.inv.IInventoryBucketProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13237 */             return (Class)InventoryBucketPropertyModel.class;
/*       */           }
/*       */         });
/* 13240 */     addDaos("InventoryBucketProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13242 */             return (Class)InventoryBucketPropertyDAO.class;
/*       */           }
/*       */         });
/* 13245 */     addObjectIds("InventoryBucketProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13247 */             return (Class)InventoryBucketPropertyId.class;
/*       */           }
/*       */         });
/* 13250 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentCrossReferencePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13252 */             return (Class)InventoryDocumentCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/* 13255 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentCrossReferenceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13257 */             return (Class)InventoryDocumentCrossReferencePropertyModel.class;
/*       */           }
/*       */         });
/* 13260 */     addDaos("InventoryDocumentCrossReferenceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13262 */             return (Class)InventoryDocumentCrossReferencePropertyDAO.class;
/*       */           }
/*       */         });
/* 13265 */     addObjectIds("InventoryDocumentCrossReferenceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13267 */             return (Class)InventoryDocumentCrossReferencePropertyId.class;
/*       */           }
/*       */         });
/* 13270 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCostItemYearEndPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13272 */             return (Class)InventoryCostItemYearEndPropertyModel.class;
/*       */           }
/*       */         });
/* 13275 */     addInterfaces("dtv.xst.dao.inv.IInventoryCostItemYearEndProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13277 */             return (Class)InventoryCostItemYearEndPropertyModel.class;
/*       */           }
/*       */         });
/* 13280 */     addDaos("InventoryCostItemYearEndProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13282 */             return (Class)InventoryCostItemYearEndPropertyDAO.class;
/*       */           }
/*       */         });
/* 13285 */     addObjectIds("InventoryCostItemYearEndProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13287 */             return (Class)InventoryCostItemYearEndPropertyId.class;
/*       */           }
/*       */         });
/* 13290 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountBucketPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13292 */             return (Class)InventoryCountBucketPropertyModel.class;
/*       */           }
/*       */         });
/* 13295 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountBucketProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13297 */             return (Class)InventoryCountBucketPropertyModel.class;
/*       */           }
/*       */         });
/* 13300 */     addDaos("InventoryCountBucketProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13302 */             return (Class)InventoryCountBucketPropertyDAO.class;
/*       */           }
/*       */         });
/* 13305 */     addObjectIds("InventoryCountBucketProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13307 */             return (Class)InventoryCountBucketPropertyId.class;
/*       */           }
/*       */         });
/* 13310 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSectionDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13312 */             return (Class)InventoryCountSectionDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 13315 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSectionDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13317 */             return (Class)InventoryCountSectionDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 13320 */     addDaos("InventoryCountSectionDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13322 */             return (Class)InventoryCountSectionDetailPropertyDAO.class;
/*       */           }
/*       */         });
/* 13325 */     addObjectIds("InventoryCountSectionDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13327 */             return (Class)InventoryCountSectionDetailPropertyId.class;
/*       */           }
/*       */         });
/* 13330 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSheetLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13332 */             return (Class)InventoryCountSheetLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13335 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSheetLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13337 */             return (Class)InventoryCountSheetLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13340 */     addDaos("InventoryCountSheetLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13342 */             return (Class)InventoryCountSheetLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 13345 */     addObjectIds("InventoryCountSheetLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13347 */             return (Class)InventoryCountSheetLineItemPropertyId.class;
/*       */           }
/*       */         });
/* 13350 */     addDataModels("dtv.xst.dao.inv.impl.InventoryCountSnapshotPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13352 */             return (Class)InventoryCountSnapshotPropertyModel.class;
/*       */           }
/*       */         });
/* 13355 */     addInterfaces("dtv.xst.dao.inv.IInventoryCountSnapshotProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13357 */             return (Class)InventoryCountSnapshotPropertyModel.class;
/*       */           }
/*       */         });
/* 13360 */     addDaos("InventoryCountSnapshotProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13362 */             return (Class)InventoryCountSnapshotPropertyDAO.class;
/*       */           }
/*       */         });
/* 13365 */     addObjectIds("InventoryCountSnapshotProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13367 */             return (Class)InventoryCountSnapshotPropertyId.class;
/*       */           }
/*       */         });
/* 13370 */     addDataModels("dtv.xst.dao.inv.impl.InventoryJournalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13372 */             return (Class)InventoryJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 13375 */     addInterfaces("dtv.xst.dao.inv.IInventoryJournalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13377 */             return (Class)InventoryJournalPropertyModel.class;
/*       */           }
/*       */         });
/* 13380 */     addDaos("InventoryJournalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13382 */             return (Class)InventoryJournalPropertyDAO.class;
/*       */           }
/*       */         });
/* 13385 */     addObjectIds("InventoryJournalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13387 */             return (Class)InventoryJournalPropertyId.class;
/*       */           }
/*       */         });
/* 13390 */     addDataModels("dtv.xst.dao.inv.impl.InventoryLocationAvailabilityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13392 */             return (Class)InventoryLocationAvailabilityPropertyModel.class;
/*       */           }
/*       */         });
/* 13395 */     addInterfaces("dtv.xst.dao.inv.IInventoryLocationAvailabilityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13397 */             return (Class)InventoryLocationAvailabilityPropertyModel.class;
/*       */           }
/*       */         });
/* 13400 */     addDaos("InventoryLocationAvailabilityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13402 */             return (Class)InventoryLocationAvailabilityPropertyDAO.class;
/*       */           }
/*       */         });
/* 13405 */     addObjectIds("InventoryLocationAvailabilityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13407 */             return (Class)InventoryLocationAvailabilityPropertyId.class;
/*       */           }
/*       */         });
/* 13410 */     addDataModels("dtv.xst.dao.inv.impl.InventoryLocationBucketPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13412 */             return (Class)InventoryLocationBucketPropertyModel.class;
/*       */           }
/*       */         });
/* 13415 */     addInterfaces("dtv.xst.dao.inv.IInventoryLocationBucketProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13417 */             return (Class)InventoryLocationBucketPropertyModel.class;
/*       */           }
/*       */         });
/* 13420 */     addDaos("InventoryLocationBucketProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13422 */             return (Class)InventoryLocationBucketPropertyDAO.class;
/*       */           }
/*       */         });
/* 13425 */     addObjectIds("InventoryLocationBucketProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13427 */             return (Class)InventoryLocationBucketPropertyId.class;
/*       */           }
/*       */         });
/* 13430 */     addDataModels("dtv.xst.dao.inv.impl.InventoryMovementPendingDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13432 */             return (Class)InventoryMovementPendingDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 13435 */     addInterfaces("dtv.xst.dao.inv.IInventoryMovementPendingDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13437 */             return (Class)InventoryMovementPendingDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 13440 */     addDaos("InventoryMovementPendingDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13442 */             return (Class)InventoryMovementPendingDetailPropertyDAO.class;
/*       */           }
/*       */         });
/* 13445 */     addObjectIds("InventoryMovementPendingDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13447 */             return (Class)InventoryMovementPendingDetailPropertyId.class;
/*       */           }
/*       */         });
/* 13450 */     addDataModels("dtv.xst.dao.inv.impl.InventorySummaryCountTransactionDetailPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13452 */             return (Class)InventorySummaryCountTransactionDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 13455 */     addInterfaces("dtv.xst.dao.inv.IInventorySummaryCountTransactionDetailProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13457 */             return (Class)InventorySummaryCountTransactionDetailPropertyModel.class;
/*       */           }
/*       */         });
/* 13460 */     addDaos("InventorySummaryCountTransactionDetailProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13462 */             return (Class)InventorySummaryCountTransactionDetailPropertyDAO.class;
/*       */           }
/*       */         });
/* 13465 */     addObjectIds("InventorySummaryCountTransactionDetailProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13467 */             return (Class)InventorySummaryCountTransactionDetailPropertyId.class;
/*       */           }
/*       */         });
/* 13470 */     addDataModels("dtv.xst.dao.inv.impl.InventoryValidDestinationsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13472 */             return (Class)InventoryValidDestinationsPropertyModel.class;
/*       */           }
/*       */         });
/* 13475 */     addInterfaces("dtv.xst.dao.inv.IInventoryValidDestinationsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13477 */             return (Class)InventoryValidDestinationsPropertyModel.class;
/*       */           }
/*       */         });
/* 13480 */     addDaos("InventoryValidDestinationsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13482 */             return (Class)InventoryValidDestinationsPropertyDAO.class;
/*       */           }
/*       */         });
/* 13485 */     addObjectIds("InventoryValidDestinationsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13487 */             return (Class)InventoryValidDestinationsPropertyId.class;
/*       */           }
/*       */         });
/* 13490 */     addDataModels("dtv.xst.dao.inv.impl.SerializedStockLedgerPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13492 */             return (Class)SerializedStockLedgerPropertyModel.class;
/*       */           }
/*       */         });
/* 13495 */     addInterfaces("dtv.xst.dao.inv.ISerializedStockLedgerProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13497 */             return (Class)SerializedStockLedgerPropertyModel.class;
/*       */           }
/*       */         });
/* 13500 */     addDaos("SerializedStockLedgerProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13502 */             return (Class)SerializedStockLedgerPropertyDAO.class;
/*       */           }
/*       */         });
/* 13505 */     addObjectIds("SerializedStockLedgerProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13507 */             return (Class)SerializedStockLedgerPropertyId.class;
/*       */           }
/*       */         });
/* 13510 */     addDataModels("dtv.xst.dao.inv.impl.ShipperPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13512 */             return (Class)ShipperPropertyModel.class;
/*       */           }
/*       */         });
/* 13515 */     addInterfaces("dtv.xst.dao.inv.IShipperProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13517 */             return (Class)ShipperPropertyModel.class;
/*       */           }
/*       */         });
/* 13520 */     addDaos("ShipperProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13522 */             return (Class)ShipperPropertyDAO.class;
/*       */           }
/*       */         });
/* 13525 */     addObjectIds("ShipperProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13527 */             return (Class)ShipperPropertyId.class;
/*       */           }
/*       */         });
/* 13530 */     addDataModels("dtv.xst.dao.inv.impl.ShipperMethodPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13532 */             return (Class)ShipperMethodPropertyModel.class;
/*       */           }
/*       */         });
/* 13535 */     addInterfaces("dtv.xst.dao.inv.IShipperMethodProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13537 */             return (Class)ShipperMethodPropertyModel.class;
/*       */           }
/*       */         });
/* 13540 */     addDaos("ShipperMethodProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13542 */             return (Class)ShipperMethodPropertyDAO.class;
/*       */           }
/*       */         });
/* 13545 */     addObjectIds("ShipperMethodProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13547 */             return (Class)ShipperMethodPropertyId.class;
/*       */           }
/*       */         });
/* 13550 */     addDataModels("dtv.xst.dao.inv.impl.StockLedgerPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13552 */             return (Class)StockLedgerPropertyModel.class;
/*       */           }
/*       */         });
/* 13555 */     addInterfaces("dtv.xst.dao.inv.IStockLedgerProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13557 */             return (Class)StockLedgerPropertyModel.class;
/*       */           }
/*       */         });
/* 13560 */     addDaos("StockLedgerProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13562 */             return (Class)StockLedgerPropertyDAO.class;
/*       */           }
/*       */         });
/* 13565 */     addObjectIds("StockLedgerProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13567 */             return (Class)StockLedgerPropertyId.class;
/*       */           }
/*       */         });
/* 13570 */     addDataModels("dtv.xst.dao.inv.impl.DocumentLineItemNotePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13572 */             return (Class)DocumentLineItemNotePropertyModel.class;
/*       */           }
/*       */         });
/* 13575 */     addInterfaces("dtv.xst.dao.inv.IDocumentLineItemNoteProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13577 */             return (Class)DocumentLineItemNotePropertyModel.class;
/*       */           }
/*       */         });
/* 13580 */     addDaos("DocumentLineItemNoteProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13582 */             return (Class)DocumentLineItemNotePropertyDAO.class;
/*       */           }
/*       */         });
/* 13585 */     addObjectIds("DocumentLineItemNoteProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13587 */             return (Class)DocumentLineItemNotePropertyId.class;
/*       */           }
/*       */         });
/* 13590 */     addDataModels("dtv.xst.dao.inv.impl.InventoryDocumentLineSerialPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13592 */             return (Class)InventoryDocumentLineSerialPropertyModel.class;
/*       */           }
/*       */         });
/* 13595 */     addInterfaces("dtv.xst.dao.inv.IInventoryDocumentLineSerialProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13597 */             return (Class)InventoryDocumentLineSerialPropertyModel.class;
/*       */           }
/*       */         });
/* 13600 */     addDaos("InventoryDocumentLineSerialProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13602 */             return (Class)InventoryDocumentLineSerialPropertyDAO.class;
/*       */           }
/*       */         });
/* 13605 */     addObjectIds("InventoryDocumentLineSerialProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13607 */             return (Class)InventoryDocumentLineSerialPropertyId.class;
/*       */           }
/*       */         });
/* 13610 */     addDataModels("dtv.xst.dao.inv.impl.InventoryReplenishmentDocumentLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13612 */             return (Class)InventoryReplenishmentDocumentLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13615 */     addInterfaces("dtv.xst.dao.inv.IInventoryReplenishmentDocumentLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13617 */             return (Class)InventoryReplenishmentDocumentLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13620 */     addDaos("InventoryReplenishmentDocumentLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13622 */             return (Class)InventoryReplenishmentDocumentLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 13625 */     addObjectIds("InventoryReplenishmentDocumentLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13627 */             return (Class)InventoryReplenishmentDocumentLineItemPropertyId.class;
/*       */           }
/*       */         });
/* 13630 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13632 */             return (Class)DiscountPropertyModel.class;
/*       */           }
/*       */         });
/* 13635 */     addInterfaces("dtv.xst.dao.dsc.IDiscountProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13637 */             return (Class)DiscountPropertyModel.class;
/*       */           }
/*       */         });
/* 13640 */     addDaos("DiscountProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13642 */             return (Class)DiscountPropertyDAO.class;
/*       */           }
/*       */         });
/* 13645 */     addObjectIds("DiscountProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13647 */             return (Class)DiscountPropertyId.class;
/*       */           }
/*       */         });
/* 13650 */     addDataModels("dtv.xst.dao.dsc.impl.CouponPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13652 */             return (Class)CouponPropertyModel.class;
/*       */           }
/*       */         });
/* 13655 */     addInterfaces("dtv.xst.dao.dsc.ICouponProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13657 */             return (Class)CouponPropertyModel.class;
/*       */           }
/*       */         });
/* 13660 */     addDaos("CouponProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13662 */             return (Class)CouponPropertyDAO.class;
/*       */           }
/*       */         });
/* 13665 */     addObjectIds("CouponProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13667 */             return (Class)CouponPropertyId.class;
/*       */           }
/*       */         });
/* 13670 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountCompatabilityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13672 */             return (Class)DiscountCompatabilityPropertyModel.class;
/*       */           }
/*       */         });
/* 13675 */     addInterfaces("dtv.xst.dao.dsc.IDiscountCompatabilityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13677 */             return (Class)DiscountCompatabilityPropertyModel.class;
/*       */           }
/*       */         });
/* 13680 */     addDaos("DiscountCompatabilityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13682 */             return (Class)DiscountCompatabilityPropertyDAO.class;
/*       */           }
/*       */         });
/* 13685 */     addObjectIds("DiscountCompatabilityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13687 */             return (Class)DiscountCompatabilityPropertyId.class;
/*       */           }
/*       */         });
/* 13690 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountGroupMappingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13692 */             return (Class)DiscountGroupMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 13695 */     addInterfaces("dtv.xst.dao.dsc.IDiscountGroupMappingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13697 */             return (Class)DiscountGroupMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 13700 */     addDaos("DiscountGroupMappingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13702 */             return (Class)DiscountGroupMappingPropertyDAO.class;
/*       */           }
/*       */         });
/* 13705 */     addObjectIds("DiscountGroupMappingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13707 */             return (Class)DiscountGroupMappingPropertyId.class;
/*       */           }
/*       */         });
/* 13710 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountItemExclusionsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13712 */             return (Class)DiscountItemExclusionsPropertyModel.class;
/*       */           }
/*       */         });
/* 13715 */     addInterfaces("dtv.xst.dao.dsc.IDiscountItemExclusionsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13717 */             return (Class)DiscountItemExclusionsPropertyModel.class;
/*       */           }
/*       */         });
/* 13720 */     addDaos("DiscountItemExclusionsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13722 */             return (Class)DiscountItemExclusionsPropertyDAO.class;
/*       */           }
/*       */         });
/* 13725 */     addObjectIds("DiscountItemExclusionsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13727 */             return (Class)DiscountItemExclusionsPropertyId.class;
/*       */           }
/*       */         });
/* 13730 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountItemInclusionsPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13732 */             return (Class)DiscountItemInclusionsPropertyModel.class;
/*       */           }
/*       */         });
/* 13735 */     addInterfaces("dtv.xst.dao.dsc.IDiscountItemInclusionsProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13737 */             return (Class)DiscountItemInclusionsPropertyModel.class;
/*       */           }
/*       */         });
/* 13740 */     addDaos("DiscountItemInclusionsProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13742 */             return (Class)DiscountItemInclusionsPropertyDAO.class;
/*       */           }
/*       */         });
/* 13745 */     addObjectIds("DiscountItemInclusionsProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13747 */             return (Class)DiscountItemInclusionsPropertyId.class;
/*       */           }
/*       */         });
/* 13750 */     addDataModels("dtv.xst.dao.dsc.impl.DiscountTypeEligibilityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13752 */             return (Class)DiscountTypeEligibilityPropertyModel.class;
/*       */           }
/*       */         });
/* 13755 */     addInterfaces("dtv.xst.dao.dsc.IDiscountTypeEligibilityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13757 */             return (Class)DiscountTypeEligibilityPropertyModel.class;
/*       */           }
/*       */         });
/* 13760 */     addDaos("DiscountTypeEligibilityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13762 */             return (Class)DiscountTypeEligibilityPropertyDAO.class;
/*       */           }
/*       */         });
/* 13765 */     addObjectIds("DiscountTypeEligibilityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13767 */             return (Class)DiscountTypeEligibilityPropertyId.class;
/*       */           }
/*       */         });
/* 13770 */     addDataModels("dtv.xst.dao.cwo.impl.InvoicePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13772 */             return (Class)InvoicePropertyModel.class;
/*       */           }
/*       */         });
/* 13775 */     addInterfaces("dtv.xst.dao.cwo.IInvoiceProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13777 */             return (Class)InvoicePropertyModel.class;
/*       */           }
/*       */         });
/* 13780 */     addDaos("InvoiceProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13782 */             return (Class)InvoicePropertyDAO.class;
/*       */           }
/*       */         });
/* 13785 */     addObjectIds("InvoiceProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13787 */             return (Class)InvoicePropertyId.class;
/*       */           }
/*       */         });
/* 13790 */     addDataModels("dtv.xst.dao.cwo.impl.WorkItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13792 */             return (Class)WorkItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13795 */     addInterfaces("dtv.xst.dao.cwo.IWorkItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13797 */             return (Class)WorkItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13800 */     addDaos("WorkItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13802 */             return (Class)WorkItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 13805 */     addObjectIds("WorkItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13807 */             return (Class)WorkItemPropertyId.class;
/*       */           }
/*       */         });
/* 13810 */     addDataModels("dtv.xst.dao.cwo.impl.CategoryServiceLocationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13812 */             return (Class)CategoryServiceLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13815 */     addInterfaces("dtv.xst.dao.cwo.ICategoryServiceLocationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13817 */             return (Class)CategoryServiceLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13820 */     addDaos("CategoryServiceLocationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13822 */             return (Class)CategoryServiceLocationPropertyDAO.class;
/*       */           }
/*       */         });
/* 13825 */     addObjectIds("CategoryServiceLocationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13827 */             return (Class)CategoryServiceLocationPropertyId.class;
/*       */           }
/*       */         });
/* 13830 */     addDataModels("dtv.xst.dao.cwo.impl.InvoiceLineItemPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13832 */             return (Class)InvoiceLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13835 */     addInterfaces("dtv.xst.dao.cwo.IInvoiceLineItemProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13837 */             return (Class)InvoiceLineItemPropertyModel.class;
/*       */           }
/*       */         });
/* 13840 */     addDaos("InvoiceLineItemProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13842 */             return (Class)InvoiceLineItemPropertyDAO.class;
/*       */           }
/*       */         });
/* 13845 */     addObjectIds("InvoiceLineItemProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13847 */             return (Class)InvoiceLineItemPropertyId.class;
/*       */           }
/*       */         });
/* 13850 */     addDataModels("dtv.xst.dao.cwo.impl.ServiceLocationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13852 */             return (Class)ServiceLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13855 */     addInterfaces("dtv.xst.dao.cwo.IServiceLocationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13857 */             return (Class)ServiceLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13860 */     addDaos("ServiceLocationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13862 */             return (Class)ServiceLocationPropertyDAO.class;
/*       */           }
/*       */         });
/* 13865 */     addObjectIds("ServiceLocationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13867 */             return (Class)ServiceLocationPropertyId.class;
/*       */           }
/*       */         });
/* 13870 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderCategoryPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13872 */             return (Class)WorkOrderCategoryPropertyModel.class;
/*       */           }
/*       */         });
/* 13875 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderCategoryProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13877 */             return (Class)WorkOrderCategoryPropertyModel.class;
/*       */           }
/*       */         });
/* 13880 */     addDaos("WorkOrderCategoryProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13882 */             return (Class)WorkOrderCategoryPropertyDAO.class;
/*       */           }
/*       */         });
/* 13885 */     addObjectIds("WorkOrderCategoryProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13887 */             return (Class)WorkOrderCategoryPropertyId.class;
/*       */           }
/*       */         });
/* 13890 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderPriceCodePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13892 */             return (Class)WorkOrderPriceCodePropertyModel.class;
/*       */           }
/*       */         });
/* 13895 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderPriceCodeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13897 */             return (Class)WorkOrderPriceCodePropertyModel.class;
/*       */           }
/*       */         });
/* 13900 */     addDaos("WorkOrderPriceCodeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13902 */             return (Class)WorkOrderPriceCodePropertyDAO.class;
/*       */           }
/*       */         });
/* 13905 */     addObjectIds("WorkOrderPriceCodeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13907 */             return (Class)WorkOrderPriceCodePropertyId.class;
/*       */           }
/*       */         });
/* 13910 */     addDataModels("dtv.xst.dao.cwo.impl.WorkOrderPricingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13912 */             return (Class)WorkOrderPricingPropertyModel.class;
/*       */           }
/*       */         });
/* 13915 */     addInterfaces("dtv.xst.dao.cwo.IWorkOrderPricingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13917 */             return (Class)WorkOrderPricingPropertyModel.class;
/*       */           }
/*       */         });
/* 13920 */     addDaos("WorkOrderPricingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13922 */             return (Class)WorkOrderPricingPropertyDAO.class;
/*       */           }
/*       */         });
/* 13925 */     addObjectIds("WorkOrderPricingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13927 */             return (Class)WorkOrderPricingPropertyId.class;
/*       */           }
/*       */         });
/* 13930 */     addDataModels("dtv.xst.dao.tax.impl.TaxAuthorityPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13932 */             return (Class)TaxAuthorityPropertyModel.class;
/*       */           }
/*       */         });
/* 13935 */     addInterfaces("dtv.xst.dao.tax.ITaxAuthorityProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13937 */             return (Class)TaxAuthorityPropertyModel.class;
/*       */           }
/*       */         });
/* 13940 */     addDaos("TaxAuthorityProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13942 */             return (Class)TaxAuthorityPropertyDAO.class;
/*       */           }
/*       */         });
/* 13945 */     addObjectIds("TaxAuthorityProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13947 */             return (Class)TaxAuthorityPropertyId.class;
/*       */           }
/*       */         });
/* 13950 */     addDataModels("dtv.xst.dao.tax.impl.TaxGroupPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13952 */             return (Class)TaxGroupPropertyModel.class;
/*       */           }
/*       */         });
/* 13955 */     addInterfaces("dtv.xst.dao.tax.ITaxGroupProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13957 */             return (Class)TaxGroupPropertyModel.class;
/*       */           }
/*       */         });
/* 13960 */     addDaos("TaxGroupProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13962 */             return (Class)TaxGroupPropertyDAO.class;
/*       */           }
/*       */         });
/* 13965 */     addObjectIds("TaxGroupProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13967 */             return (Class)TaxGroupPropertyId.class;
/*       */           }
/*       */         });
/* 13970 */     addDataModels("dtv.xst.dao.tax.impl.TaxGroupRulePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13972 */             return (Class)TaxGroupRulePropertyModel.class;
/*       */           }
/*       */         });
/* 13975 */     addInterfaces("dtv.xst.dao.tax.ITaxGroupRuleProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13977 */             return (Class)TaxGroupRulePropertyModel.class;
/*       */           }
/*       */         });
/* 13980 */     addDaos("TaxGroupRuleProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 13982 */             return (Class)TaxGroupRulePropertyDAO.class;
/*       */           }
/*       */         });
/* 13985 */     addObjectIds("TaxGroupRuleProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 13987 */             return (Class)TaxGroupRulePropertyId.class;
/*       */           }
/*       */         });
/* 13990 */     addDataModels("dtv.xst.dao.tax.impl.TaxLocationPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 13992 */             return (Class)TaxLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 13995 */     addInterfaces("dtv.xst.dao.tax.ITaxLocationProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 13997 */             return (Class)TaxLocationPropertyModel.class;
/*       */           }
/*       */         });
/* 14000 */     addDaos("TaxLocationProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14002 */             return (Class)TaxLocationPropertyDAO.class;
/*       */           }
/*       */         });
/* 14005 */     addObjectIds("TaxLocationProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14007 */             return (Class)TaxLocationPropertyId.class;
/*       */           }
/*       */         });
/* 14010 */     addDataModels("dtv.xst.dao.tax.impl.TaxRateRulePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14012 */             return (Class)TaxRateRulePropertyModel.class;
/*       */           }
/*       */         });
/* 14015 */     addInterfaces("dtv.xst.dao.tax.ITaxRateRuleProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14017 */             return (Class)TaxRateRulePropertyModel.class;
/*       */           }
/*       */         });
/* 14020 */     addDaos("TaxRateRuleProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14022 */             return (Class)TaxRateRulePropertyDAO.class;
/*       */           }
/*       */         });
/* 14025 */     addObjectIds("TaxRateRuleProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14027 */             return (Class)TaxRateRulePropertyId.class;
/*       */           }
/*       */         });
/* 14030 */     addDataModels("dtv.xst.dao.tax.impl.TaxCodePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14032 */             return (Class)TaxCodePropertyModel.class;
/*       */           }
/*       */         });
/* 14035 */     addInterfaces("dtv.xst.dao.tax.ITaxCodeProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14037 */             return (Class)TaxCodePropertyModel.class;
/*       */           }
/*       */         });
/* 14040 */     addDaos("TaxCodeProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14042 */             return (Class)TaxCodePropertyDAO.class;
/*       */           }
/*       */         });
/* 14045 */     addObjectIds("TaxCodeProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14047 */             return (Class)TaxCodePropertyId.class;
/*       */           }
/*       */         });
/* 14050 */     addDataModels("dtv.xst.dao.tax.impl.PostalCodeMappingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14052 */             return (Class)PostalCodeMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 14055 */     addInterfaces("dtv.xst.dao.tax.IPostalCodeMappingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14057 */             return (Class)PostalCodeMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 14060 */     addDaos("PostalCodeMappingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14062 */             return (Class)PostalCodeMappingPropertyDAO.class;
/*       */           }
/*       */         });
/* 14065 */     addObjectIds("PostalCodeMappingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14067 */             return (Class)PostalCodeMappingPropertyId.class;
/*       */           }
/*       */         });
/* 14070 */     addDataModels("dtv.xst.dao.tax.impl.RetailLocationTaxMappingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14072 */             return (Class)RetailLocationTaxMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 14075 */     addInterfaces("dtv.xst.dao.tax.IRetailLocationTaxMappingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14077 */             return (Class)RetailLocationTaxMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 14080 */     addDaos("RetailLocationTaxMappingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14082 */             return (Class)RetailLocationTaxMappingPropertyDAO.class;
/*       */           }
/*       */         });
/* 14085 */     addObjectIds("RetailLocationTaxMappingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14087 */             return (Class)RetailLocationTaxMappingPropertyId.class;
/*       */           }
/*       */         });
/* 14090 */     addDataModels("dtv.xst.dao.tax.impl.TaxBracketPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14092 */             return (Class)TaxBracketPropertyModel.class;
/*       */           }
/*       */         });
/* 14095 */     addInterfaces("dtv.xst.dao.tax.ITaxBracketProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14097 */             return (Class)TaxBracketPropertyModel.class;
/*       */           }
/*       */         });
/* 14100 */     addDaos("TaxBracketProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14102 */             return (Class)TaxBracketPropertyDAO.class;
/*       */           }
/*       */         });
/* 14105 */     addObjectIds("TaxBracketProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14107 */             return (Class)TaxBracketPropertyId.class;
/*       */           }
/*       */         });
/* 14110 */     addDataModels("dtv.xst.dao.tax.impl.TaxExemptionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14112 */             return (Class)TaxExemptionPropertyModel.class;
/*       */           }
/*       */         });
/* 14115 */     addInterfaces("dtv.xst.dao.tax.ITaxExemptionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14117 */             return (Class)TaxExemptionPropertyModel.class;
/*       */           }
/*       */         });
/* 14120 */     addDaos("TaxExemptionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14122 */             return (Class)TaxExemptionPropertyDAO.class;
/*       */           }
/*       */         });
/* 14125 */     addObjectIds("TaxExemptionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14127 */             return (Class)TaxExemptionPropertyId.class;
/*       */           }
/*       */         });
/* 14130 */     addDataModels("dtv.xst.dao.tax.impl.TaxRateRuleOverridePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14132 */             return (Class)TaxRateRuleOverridePropertyModel.class;
/*       */           }
/*       */         });
/* 14135 */     addInterfaces("dtv.xst.dao.tax.ITaxRateRuleOverrideProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14137 */             return (Class)TaxRateRuleOverridePropertyModel.class;
/*       */           }
/*       */         });
/* 14140 */     addDaos("TaxRateRuleOverrideProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14142 */             return (Class)TaxRateRuleOverridePropertyDAO.class;
/*       */           }
/*       */         });
/* 14145 */     addObjectIds("TaxRateRuleOverrideProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14147 */             return (Class)TaxRateRuleOverridePropertyId.class;
/*       */           }
/*       */         });
/* 14150 */     addDataModels("dtv.xst.dao.tax.impl.TaxTaxGroupMappingPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14152 */             return (Class)TaxTaxGroupMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 14155 */     addInterfaces("dtv.xst.dao.tax.ITaxTaxGroupMappingProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14157 */             return (Class)TaxTaxGroupMappingPropertyModel.class;
/*       */           }
/*       */         });
/* 14160 */     addDaos("TaxTaxGroupMappingProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14162 */             return (Class)TaxTaxGroupMappingPropertyDAO.class;
/*       */           }
/*       */         });
/* 14165 */     addObjectIds("TaxTaxGroupMappingProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14167 */             return (Class)TaxTaxGroupMappingPropertyId.class;
/*       */           }
/*       */         });
/* 14170 */     addDataModels("dtv.xst.dao.doc.impl.DocumentPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14172 */             return (Class)DocumentPropertyModel.class;
/*       */           }
/*       */         });
/* 14175 */     addInterfaces("dtv.xst.dao.doc.IDocumentProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14177 */             return (Class)DocumentPropertyModel.class;
/*       */           }
/*       */         });
/* 14180 */     addDaos("DocumentProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14182 */             return (Class)DocumentPropertyDAO.class;
/*       */           }
/*       */         });
/* 14185 */     addObjectIds("DocumentProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14187 */             return (Class)DocumentPropertyId.class;
/*       */           }
/*       */         });
/* 14190 */     addDataModels("dtv.xst.dao.doc.impl.DocumentDefinitionPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14192 */             return (Class)DocumentDefinitionPropertyModel.class;
/*       */           }
/*       */         });
/* 14195 */     addInterfaces("dtv.xst.dao.doc.IDocumentDefinitionProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14197 */             return (Class)DocumentDefinitionPropertyModel.class;
/*       */           }
/*       */         });
/* 14200 */     addDaos("DocumentDefinitionProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14202 */             return (Class)DocumentDefinitionPropertyDAO.class;
/*       */           }
/*       */         });
/* 14205 */     addObjectIds("DocumentDefinitionProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14207 */             return (Class)DocumentDefinitionPropertyId.class;
/*       */           }
/*       */         });
/* 14210 */     addDataModels("dtv.xst.dao.doc.impl.DocumentDefinitionPropertiesPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14212 */             return (Class)DocumentDefinitionPropertiesPropertyModel.class;
/*       */           }
/*       */         });
/* 14215 */     addInterfaces("dtv.xst.dao.doc.IDocumentDefinitionPropertiesProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14217 */             return (Class)DocumentDefinitionPropertiesPropertyModel.class;
/*       */           }
/*       */         });
/* 14220 */     addDaos("DocumentDefinitionPropertiesProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14222 */             return (Class)DocumentDefinitionPropertiesPropertyDAO.class;
/*       */           }
/*       */         });
/* 14225 */     addObjectIds("DocumentDefinitionPropertiesProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14227 */             return (Class)DocumentDefinitionPropertiesPropertyId.class;
/*       */           }
/*       */         });
/* 14230 */     addDataModels("dtv.xst.dao.rpt.impl.OrganizerPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14232 */             return (Class)OrganizerPropertyModel.class;
/*       */           }
/*       */         });
/* 14235 */     addInterfaces("dtv.xst.dao.rpt.IOrganizerProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14237 */             return (Class)OrganizerPropertyModel.class;
/*       */           }
/*       */         });
/* 14240 */     addDaos("OrganizerProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14242 */             return (Class)OrganizerPropertyDAO.class;
/*       */           }
/*       */         });
/* 14245 */     addObjectIds("OrganizerProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14247 */             return (Class)OrganizerPropertyId.class;
/*       */           }
/*       */         });
/* 14250 */     addDataModels("dtv.xst.dao.sch.impl.EmployeeTimeOffPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14252 */             return (Class)EmployeeTimeOffPropertyModel.class;
/*       */           }
/*       */         });
/* 14255 */     addInterfaces("dtv.xst.dao.sch.IEmployeeTimeOffProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14257 */             return (Class)EmployeeTimeOffPropertyModel.class;
/*       */           }
/*       */         });
/* 14260 */     addDaos("EmployeeTimeOffProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14262 */             return (Class)EmployeeTimeOffPropertyDAO.class;
/*       */           }
/*       */         });
/* 14265 */     addObjectIds("EmployeeTimeOffProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14267 */             return (Class)EmployeeTimeOffPropertyId.class;
/*       */           }
/*       */         });
/* 14270 */     addDataModels("dtv.xst.dao.sch.impl.SchedulePropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14272 */             return (Class)SchedulePropertyModel.class;
/*       */           }
/*       */         });
/* 14275 */     addInterfaces("dtv.xst.dao.sch.IScheduleProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14277 */             return (Class)SchedulePropertyModel.class;
/*       */           }
/*       */         });
/* 14280 */     addDaos("ScheduleProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14282 */             return (Class)SchedulePropertyDAO.class;
/*       */           }
/*       */         });
/* 14285 */     addObjectIds("ScheduleProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14287 */             return (Class)SchedulePropertyId.class;
/*       */           }
/*       */         });
/* 14290 */     addDataModels("dtv.xst.dao.sch.impl.ShiftPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14292 */             return (Class)ShiftPropertyModel.class;
/*       */           }
/*       */         });
/* 14295 */     addInterfaces("dtv.xst.dao.sch.IShiftProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14297 */             return (Class)ShiftPropertyModel.class;
/*       */           }
/*       */         });
/* 14300 */     addDaos("ShiftProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14302 */             return (Class)ShiftPropertyDAO.class;
/*       */           }
/*       */         });
/* 14305 */     addObjectIds("ShiftProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14307 */             return (Class)ShiftPropertyId.class;
/*       */           }
/*       */         });
/* 14310 */     addDataModels("dtv.xst.dao.sls.impl.SalesGoalPropertyDAO", new AbstractInstanceGenerator<IDataModelImpl>() {
/*       */           protected Class<? extends IDataModelImpl> getType() {
/* 14312 */             return (Class)SalesGoalPropertyModel.class;
/*       */           }
/*       */         });
/* 14315 */     addInterfaces("dtv.xst.dao.sls.ISalesGoalProperty", new AbstractInstanceGenerator<IDataModel>() {
/*       */           protected Class<? extends IDataModel> getType() {
/* 14317 */             return (Class)SalesGoalPropertyModel.class;
/*       */           }
/*       */         });
/* 14320 */     addDaos("SalesGoalProperty", new AbstractInstanceGenerator<IDataAccessObject>() {
/*       */           protected Class<? extends IDataAccessObject> getType() {
/* 14322 */             return (Class)SalesGoalPropertyDAO.class;
/*       */           }
/*       */         });
/* 14325 */     addObjectIds("SalesGoalProperty", new AbstractInstanceGenerator<IObjectId>() {
/*       */           protected Class<? extends IObjectId> getType() {
/* 14327 */             return (Class)SalesGoalPropertyId.class;
/*       */           }
/*       */         });
/*       */   }
/*       */   
/*       */   protected void addRelationshipProducer(String argKey, IRelationshipSetProducer argRelationshipProducer) {
/* 14333 */     this.relationshipProducerMap.put(argKey, argRelationshipProducer);
/*       */   }
/*       */   
/*       */   protected void addDaos(String argKey, AbstractInstanceGenerator<? extends IDataAccessObject> argDataAccessObject) {
/* 14337 */     this.daoForDaoNameMap.put(argKey, argDataAccessObject);
/*       */   }
/*       */   
/*       */   protected void addObjectIds(String argKey, AbstractInstanceGenerator<? extends IObjectId> argObjectId) {
/* 14341 */     this.idForDaoNameMap.put(argKey, argObjectId);
/*       */   }
/*       */   
/*       */   protected void addDataModels(String argKey, AbstractInstanceGenerator<? extends IDataModelImpl> argDataModel) {
/* 14345 */     this.modelForDaoMap.put(argKey, argDataModel);
/*       */   }
/*       */   
/*       */   protected void addInterfaces(String argKey, AbstractInstanceGenerator<? extends IDataModel> argDataModel) {
/* 14349 */     this.modelForInterfaceMap.put(argKey, argDataModel);
/*       */   }
/*       */   
/*       */   public IRelationshipSetProducer getRelationshipsInternal(String argClassName) {
/* 14353 */     return this.relationshipProducerMap.get(argClassName);
/*       */   }
/*       */ 
/*       */   
/*       */   public IDataModelRelationship[] getRelationshipsImpl(String argClassName) {
/* 14358 */     IRelationshipSetProducer producer = this.relationshipProducerMap.get(argClassName);
/* 14359 */     return (producer != null) ? producer.getRelationshipSet() : null;
/*       */   }
/*       */ 
/*       */   
/*       */   public IDataAccessObject getDaoForDaoNameImpl(String argDaoName) {
/* 14364 */     AbstractInstanceGenerator<? extends IDataAccessObject> daoClass = this.daoForDaoNameMap.get(argDaoName);
/*       */     try {
/* 14366 */       return (daoClass != null) ? (IDataAccessObject)daoClass.newInstance() : null;
/*       */     }
/* 14368 */     catch (InstantiationException|IllegalAccessException ex) {
/* 14369 */       throw new DtxException("Could not instantiate DAO for: " + argDaoName, ex);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public IObjectId getIdForDaoNameImpl(String argDaoName) {
/* 14375 */     AbstractInstanceGenerator<? extends IObjectId> idClass = this.idForDaoNameMap.get(argDaoName);
/*       */     try {
/* 14377 */       return (idClass != null) ? (IObjectId)idClass.newInstance() : null;
/*       */     }
/* 14379 */     catch (InstantiationException|IllegalAccessException ex) {
/* 14380 */       throw new DtxException("Could not instantiate object Id for: " + argDaoName, ex);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public IDataModelImpl getModelForDAOImpl(String argDaoClassName) {
/* 14386 */     AbstractInstanceGenerator<? extends IDataModelImpl> modelClass = this.modelForDaoMap.get(argDaoClassName);
/*       */     try {
/* 14388 */       return (modelClass != null) ? (IDataModelImpl)modelClass.newInstance() : null;
/*       */     }
/* 14390 */     catch (InstantiationException|IllegalAccessException ex) {
/* 14391 */       throw new DtxException("Could not instantiate model for: " + argDaoClassName, ex);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public <T extends IDataModel> T getModelForInterfaceImpl(Class<T> argInterfaceClass) {
/* 14397 */     AbstractInstanceGenerator<? extends IDataModel> modelClass = this.modelForInterfaceMap.get(argInterfaceClass.getName());
/*       */     try {
/* 14399 */       return (modelClass != null) ? (T)modelClass.newInstance() : null;
/*       */     }
/* 14401 */     catch (InstantiationException|IllegalAccessException ex) {
/* 14402 */       throw new DtxException("Could not instantiate model for: " + argInterfaceClass.getName(), ex);
/*       */     } 
/*       */   }
/*       */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\data2\access\impl\DataModelFactoryImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */