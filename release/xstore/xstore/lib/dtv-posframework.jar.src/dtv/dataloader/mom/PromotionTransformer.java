/*      */ package dtv.dataloader.mom;
/*      */ 
/*      */ import dtv.data2.access.IPersistable;
/*      */ import dtv.data2.access.impl.DaoState;
/*      */ import dtv.data2.access.query.QueryRequest;
/*      */ import dtv.data2.dataloader.pluggable.DataFileException;
/*      */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*      */ import dtv.pos.common.ConfigurationMgr;
/*      */ import dtv.pos.common.PriceTypes;
/*      */ import dtv.pricing2.ItemField;
/*      */ import dtv.util.CurrencyUtils;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.util.ThreadSafeFormat;
/*      */ import dtv.xst.dao.prc.impl.DealDAO;
/*      */ import dtv.xst.dao.prc.impl.DealFieldTestDAO;
/*      */ import dtv.xst.dao.prc.impl.DealItemActionDAO;
/*      */ import java.math.BigDecimal;
/*      */ import java.text.Format;
/*      */ import java.text.ParseException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.Date;
/*      */ import java.util.EnumMap;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import org.apache.log4j.Logger;
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
/*      */ public class PromotionTransformer
/*      */   extends AbstractMOMTransformer
/*      */ {
/*   49 */   private static final Logger _logger = Logger.getLogger(PromotionTransformer.class);
/*      */   
/*      */   private static final String ITEM_FIELD_SKU = "SKU";
/*      */   
/*      */   private static final String ITEM_FIELD_PRICE = "PRICE";
/*      */   
/*      */   private static final String ITEM_FIELD_PRICE_PROPERTY_CODE = "PRICE_PROPERTY_CODE";
/*      */   
/*      */   private static final String DEAL_GROUP_PRIORITY = "PRIORITY";
/*      */   
/*      */   private static final String DEAL_GROUP_DEFAULT = "DEFAULT";
/*      */   
/*      */   private static final String ACTION_CURRENCY_OFF = "CURRENCY_OFF";
/*      */   
/*      */   private static final String ACTION_PERCENT_OFF = "PERCENT_OFF";
/*      */   
/*      */   private static final String ACTION_NEW_PRICE = "NEW_PRICE";
/*      */   private static final String MATCH_RULE_EQUAL = "EQUAL";
/*      */   private static final String MATCH_RULE_NOT_EQUAL = "NOT_EQUAL";
/*      */   private static final String MATCH_RULE_BETWEEN = "BETWEEN";
/*   69 */   protected static final BigDecimal QUANTITY_ALL_ITEMS = BigDecimal.valueOf(2147483647L);
/*   70 */   protected static final BigDecimal PRORATE_EACH_ITEM = BigDecimal.ONE;
/*   71 */   protected static final BigDecimal PRORATE_SPLIT_AMONG_ALL_ITEMS = BigDecimal.valueOf(-1L);
/*      */   
/*   73 */   protected Format _timestampFormatter = ThreadSafeFormat.getDateInstance("yyyyMMddHHmmss");
/*      */   
/*      */   protected Properties _configuration;
/*      */   
/*   77 */   protected Map<ActionType, String> _actionTypeMapping = new EnumMap<>(ActionType.class); protected Context _ctx;
/*      */   private final Comparator<Discount> thresholdDiscountComparator;
/*      */   
/*      */   public PromotionTransformer(Properties argConfig) {
/*   81 */     this.thresholdDiscountComparator = ((a, b) -> {
/*      */         assert a != null;
/*      */ 
/*      */         
/*      */         assert b != null;
/*      */ 
/*      */         
/*      */         String valueA = a._thresholdValue;
/*      */         
/*      */         if (StringUtils.isEmpty(valueA)) {
/*      */           return 1;
/*      */         }
/*      */         
/*      */         String valueB = b._thresholdValue;
/*      */         
/*      */         return StringUtils.isEmpty(valueB) ? -1 : (new BigDecimal(valueB)).compareTo(new BigDecimal(valueA));
/*      */       });
/*      */     
/*   99 */     this._configuration = argConfig;
/*      */     
/*  101 */     this._actionTypeMapping.put(ActionType.PERCENT_OFF, "PERCENT_OFF");
/*  102 */     this._actionTypeMapping.put(ActionType.AMOUNT_OFF, "CURRENCY_OFF");
/*  103 */     this._actionTypeMapping.put(ActionType.FIXED_PRICE, "NEW_PRICE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  110 */     List<IPersistable> persistables = new ArrayList<>(0);
/*  111 */     persistables.add(new QueryRequest("TRUNCATE_TABLE", 
/*      */           
/*  113 */           Collections.singletonMap("$argTableName", "prc_deal")));
/*  114 */     persistables.add(new QueryRequest("TRUNCATE_TABLE", 
/*      */           
/*  116 */           Collections.singletonMap("$argTableName", "prc_deal_item")));
/*  117 */     persistables.add(new QueryRequest("TRUNCATE_TABLE", 
/*      */           
/*  119 */           Collections.singletonMap("$argTableName", "prc_deal_field_test")));
/*      */ 
/*      */ 
/*      */     
/*  123 */     return persistables;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) {
/*  129 */     List<IPersistable> deal = new ArrayList<>();
/*  130 */     for (MOMFileLine line : argUnit.getData()) {
/*  131 */       List<IPersistable> list = transformRecord(argMetaData, argUnit, line);
/*  132 */       if (list != null) {
/*  133 */         deal.addAll(list);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  138 */     this._ctx._metaData = argMetaData;
/*  139 */     this._ctx._momUnit = argUnit;
/*      */ 
/*      */     
/*  142 */     List<IPersistable> r_deal = createDeal();
/*  143 */     if (r_deal != null) {
/*  144 */       deal.addAll(r_deal);
/*      */     }
/*      */     
/*  147 */     return deal;
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
/*      */   protected List<IPersistable> createDeal() {
/*  165 */     List<IPersistable> deal = new ArrayList<>();
/*  166 */     Deal dealCtx = this._ctx._currentDeal;
/*      */ 
/*      */     
/*  169 */     if (dealCtx == null) {
/*  170 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  174 */     if (this._ctx._currentDealIdx == 1 && this._ctx._action == Action.MODIFY) {
/*  175 */       deal.addAll(deleteDealsByDealId(createDealId(dealCtx)));
/*      */     }
/*      */     
/*  178 */     if (StringUtils.isEmpty(dealCtx._parentId)) {
/*      */       
/*  180 */       if (dealCtx._type == DealType.THRESHOLD) {
/*  181 */         List<Discount> discounts = ((GroupList)((Group)dealCtx._groups.get(0))._groupLists.get(0))._discounts;
/*  182 */         Collections.sort(discounts, this.thresholdDiscountComparator);
/*  183 */         for (int discountIdx = 0; discountIdx < discounts.size(); discountIdx++) {
/*  184 */           Discount discount = discounts.get(discountIdx);
/*  185 */           ((GroupList)((Group)dealCtx._groups.get(0))._groupLists.get(0))._discounts = Arrays.asList(new Discount[] { discount });
/*  186 */           dealCtx._thresholdDealIdx = discountIdx + 1;
/*      */           
/*  188 */           deal.addAll(makeDeal(dealCtx));
/*      */         } 
/*      */         
/*  191 */         ((GroupList)((Group)dealCtx._groups.get(0))._groupLists.get(0))._discounts = discounts;
/*      */       } else {
/*      */         
/*  194 */         deal.addAll(makeDeal(dealCtx));
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  199 */       deal.addAll(makeChildDeal(dealCtx));
/*      */     } 
/*      */     
/*  202 */     return deal;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String createDealId(Deal argDeal) {
/*  211 */     return "RPM:" + argDeal._promotionId + ":" + argDeal._promotionComponentId + ":" + argDeal._promotionComponentDetailId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Discount createDiscount(Discount argDiscount, BigDecimal argAmount) {
/*  222 */     Discount discount = new Discount();
/*  223 */     discount._action = argDiscount._action;
/*  224 */     discount._amount = argAmount;
/*  225 */     discount._thresholdType = ThresholdType.QUANTITY;
/*  226 */     discount._thresholdValue = argDiscount._thresholdValue;
/*  227 */     return discount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<IPersistable> deleteDealsByDealId(String dealId) {
/*  235 */     List<IPersistable> queries = new ArrayList<>();
/*      */     
/*  237 */     Map<String, Object> params = new HashMap<>();
/*  238 */     params.put("argDealId", dealId);
/*  239 */     params.put("argLikeDealId", dealId + ":%");
/*      */     
/*  241 */     queries.add(new QueryRequest("DELETE_FIELD_TESTS_BY_DEALID", params));
/*  242 */     queries.add(new QueryRequest("DELETE_DEAL_ITEMS_BY_DEALID", params));
/*  243 */     queries.add(new QueryRequest("DELETE_DEALS_BY_DEALID", params));
/*      */     
/*  245 */     return queries;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<IPersistable> deleteDealsByPromotion(String promotionId) {
/*  253 */     List<IPersistable> queries = new ArrayList<>();
/*      */     
/*  255 */     Map<String, Object> params = new HashMap<>();
/*  256 */     params.put("argPromotionId", promotionId);
/*      */     
/*  258 */     queries.add(new QueryRequest("DELETE_FIELD_TESTS_BY_PROMOTION", params));
/*  259 */     queries.add(new QueryRequest("DELETE_DEAL_ITEMS_BY_PROMOTION", params));
/*  260 */     queries.add(new QueryRequest("DELETE_DEALS_BY_PROMOTION", params));
/*      */     
/*  262 */     return queries;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int determineDiscountCount(Deal argDealCtx) {
/*  269 */     int count = 0;
/*      */     
/*  271 */     for (Group group : argDealCtx._groups) {
/*  272 */       count += group._groupLists.size();
/*      */     }
/*      */     
/*  275 */     return count;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean determineMultibuyAllBuyListsFlag(Deal argDealCtx) {
/*  282 */     if (argDealCtx._type != DealType.MULTIBUY) {
/*  283 */       return false;
/*      */     }
/*      */     
/*  286 */     if (argDealCtx._groups.isEmpty()) {
/*  287 */       return false;
/*      */     }
/*      */     
/*  290 */     for (Group group : argDealCtx._groups) {
/*  291 */       for (GroupList groupList : group._groupLists) {
/*  292 */         if ("1".equals(groupList._rewardApplication)) {
/*  293 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  298 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getLocalCurrencyScale() {
/*  305 */     String currencyId = this._configuration.getProperty("LOCAL_CURRENCY_ID_PROPERTY");
/*  306 */     if (currencyId == null) {
/*  307 */       return ConfigurationMgr.getLocalCurrencyScale();
/*      */     }
/*      */     
/*  310 */     return CurrencyUtils.getCurrency(currencyId).getDefaultFractionDigits();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<IPersistable> makeChildDeal(Deal argDealCtx) {
/*  318 */     List<IPersistable> result = new ArrayList<>();
/*  319 */     int groupIdx = 1;
/*      */     
/*  321 */     Deal parentDeal = this._ctx._parentDeal;
/*  322 */     if (parentDeal == null || !parentDeal._promotionId.equals(argDealCtx._promotionId) || 
/*  323 */       !parentDeal._promotionComponentId.equals(argDealCtx._promotionComponentId) || 
/*  324 */       !parentDeal._promotionComponentDetailId.equals(argDealCtx._parentId)) {
/*  325 */       throw new DataFileException(buildTransformationMessage("Encountered child promo component detail record without parent record right ahead of it: " + argDealCtx._parentId, this._ctx._metaData, this._ctx._momUnit
/*      */ 
/*      */             
/*  328 */             .getData()));
/*      */     }
/*      */ 
/*      */     
/*  332 */     String parentDealId = createDealId(parentDeal);
/*      */ 
/*      */ 
/*      */     
/*  336 */     for (GroupList childGroupList : ((Group)argDealCtx._groups.get(0))._groupLists) {
/*      */ 
/*      */ 
/*      */       
/*  340 */       if (((Discount)childGroupList._discounts.get(0))._action == ActionType.EXCLUDE) {
/*  341 */         if (childGroupList._items.isEmpty()) {
/*  342 */           if (childGroupList._priceMin.compareTo(BigDecimal.ZERO) != 0 || childGroupList._priceMax
/*  343 */             .compareTo(BigDecimal.valueOf(2147483647L)) != 0) {
/*      */             
/*  345 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  346 */             result.add(fieldTest);
/*      */             
/*  348 */             fieldTest.setItemConditionGroup(Integer.valueOf(1));
/*  349 */             fieldTest.setItemConditionSeq(Integer.valueOf(parentDeal._childDealMatcherIdx++));
/*  350 */             fieldTest.setDealId(parentDealId);
/*  351 */             fieldTest.setOrdinal(Integer.valueOf(parentDeal._childDealItemIdx));
/*  352 */             fieldTest.setField(ItemField.PRICE.name());
/*  353 */             fieldTest.setMatchRule("BETWEEN");
/*  354 */             fieldTest.setValue1(childGroupList._priceMin.toPlainString());
/*  355 */             fieldTest.setValue2(childGroupList._priceMax.toPlainString());
/*      */           } 
/*      */ 
/*      */           
/*  359 */           if (argDealCtx._applyTo != ApplyTo.BOTH) {
/*  360 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  361 */             result.add(fieldTest);
/*  362 */             fieldTest.setItemConditionGroup(Integer.valueOf(1));
/*  363 */             fieldTest.setItemConditionSeq(Integer.valueOf(parentDeal._childDealMatcherIdx++));
/*  364 */             fieldTest.setDealId(parentDealId);
/*  365 */             fieldTest.setOrdinal(Integer.valueOf(parentDeal._childDealItemIdx));
/*  366 */             fieldTest.setField(ItemField.PRICE_PROPERTY_CODE.name());
/*      */             
/*  368 */             String matchRule = (argDealCtx._applyTo == ApplyTo.CLEARANCE) ? "EQUAL" : "NOT_EQUAL";
/*  369 */             fieldTest.setMatchRule(matchRule);
/*  370 */             fieldTest.setValue1(PriceTypes.CLEARANCE_PRICE.name());
/*      */           } 
/*      */         } 
/*      */         
/*  374 */         for (String itemId : childGroupList._items) {
/*      */           
/*  376 */           DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  377 */           result.add(fieldTest);
/*      */           
/*  379 */           fieldTest.setItemConditionGroup(Integer.valueOf(1));
/*  380 */           fieldTest.setItemConditionSeq(Integer.valueOf(parentDeal._childDealMatcherIdx++));
/*  381 */           fieldTest.setDealId(parentDealId);
/*  382 */           fieldTest.setOrdinal(Integer.valueOf(parentDeal._childDealItemIdx));
/*  383 */           fieldTest.setField("SKU");
/*  384 */           fieldTest.setMatchRule("NOT_EQUAL");
/*  385 */           fieldTest.setValue1(itemId);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  390 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<IPersistable> makeDeal(Deal dealCtx) {
/*  398 */     List<IPersistable> result = new ArrayList<>();
/*      */     
/*  400 */     DealDAO deal = (DealDAO)getNewDAO("Deal", DaoState.INSERT_ONLY);
/*  401 */     result.add(deal);
/*      */ 
/*      */     
/*  404 */     String dealId = createDealId(dealCtx);
/*      */     
/*  406 */     if (dealCtx._type == DealType.THRESHOLD) {
/*  407 */       dealId = dealId + ":" + dealCtx._thresholdDealIdx;
/*      */     }
/*      */     
/*  410 */     deal.setDealId(dealId);
/*  411 */     deal.setGroupId((dealCtx._type == DealType.SIMPLE) ? "PRIORITY" : "DEFAULT");
/*  412 */     deal.setDescription(dealCtx._description);
/*  413 */     deal.setPromotionId(dealCtx._promotionId);
/*      */     
/*  415 */     deal.setEffectiveDate(dealCtx._effectiveDate);
/*  416 */     deal.setEndDate(dealCtx._endDate);
/*      */ 
/*      */     
/*  419 */     int sortOrder = 0;
/*  420 */     if (dealCtx._type == DealType.SIMPLE) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  425 */       switch (((Discount)((GroupList)((Group)dealCtx._groups.get(0))._groupLists.get(0))._discounts.get(0))._action) {
/*      */         case QUANTITY:
/*  427 */           sortOrder = -100;
/*      */           break;
/*      */         
/*      */         case AMOUNT:
/*  431 */           sortOrder = 0;
/*      */           break;
/*      */         
/*      */         case ALL:
/*  435 */           sortOrder = 100;
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  445 */     } else if (dealCtx._type == DealType.THRESHOLD) {
/*  446 */       sortOrder = 10;
/*      */     } 
/*  448 */     deal.setSortOrder(Integer.valueOf(sortOrder));
/*      */     
/*  450 */     if (dealCtx._type == DealType.THRESHOLD || dealCtx._type == DealType.TRANSACTION) {
/*  451 */       deal.setIterationCap(Integer.valueOf(1));
/*      */     } else {
/*      */       
/*  454 */       deal.setIterationCap(Integer.valueOf(dealCtx._iterationCap));
/*      */     } 
/*      */     
/*  457 */     deal.setExcludeDiscounted(
/*  458 */         Boolean.valueOf(Boolean.parseBoolean(this._configuration.getProperty("EXCLUDE_DISCOUNTED", "false"))));
/*  459 */     deal.setExcludePriceOverride(
/*  460 */         Boolean.valueOf(Boolean.parseBoolean(this._configuration.getProperty("EXCLUDE_PRICE_OVERRIDEN", "false"))));
/*  461 */     deal.setGenerosityCap(new BigDecimal(this._configuration.getProperty("GENEROSITY_CAP", "-1")));
/*      */     
/*  463 */     boolean isMultibuyAllBuyLists = determineMultibuyAllBuyListsFlag(dealCtx);
/*  464 */     int multibuyRewardListCount = determineDiscountCount(dealCtx);
/*      */     
/*  466 */     if (dealCtx._type == DealType.MULTIBUY) {
/*      */       
/*  468 */       List<Group> tmpCtxGroups = new ArrayList<>(dealCtx._groups);
/*  469 */       int groupIdx = 0;
/*  470 */       for (int tmpGroupIdx = 0; tmpGroupIdx < tmpCtxGroups.size(); tmpGroupIdx++) {
/*  471 */         Group group = tmpCtxGroups.get(tmpGroupIdx);
/*  472 */         List<Group> splittedGroups = new ArrayList<>();
/*  473 */         int i = 0;
/*  474 */         for (GroupList groupList : group._groupLists) {
/*  475 */           Discount discount = groupList._discounts.get(0);
/*  476 */           if (discount._thresholdType == ThresholdType.ALL) {
/*      */ 
/*      */             
/*  479 */             List<GroupList> groupLists = splitGroupList(group._groupLists.get(0));
/*      */             
/*  481 */             int itemQuantity = groupList._items.size();
/*  482 */             if (itemQuantity > 1) {
/*  483 */               BigDecimal amount = discount._amount;
/*  484 */               for (int idx = 0; idx < itemQuantity; idx++) {
/*  485 */                 if (discount._action != ActionType.PERCENT_OFF) {
/*      */                   
/*  487 */                   int localCurrencyScale = getLocalCurrencyScale();
/*      */                   
/*  489 */                   BigDecimal[] amountAndReminder = discount._amount.movePointRight(localCurrencyScale).divideAndRemainder(new BigDecimal(itemQuantity));
/*  490 */                   amount = amountAndReminder[0];
/*  491 */                   i += amountAndReminder[1].intValue();
/*  492 */                   if (i >= itemQuantity) {
/*  493 */                     amount = amount.add(BigDecimal.ONE);
/*  494 */                     i -= itemQuantity;
/*      */                   } 
/*  496 */                   amount = amount.movePointLeft(localCurrencyScale);
/*      */                 } 
/*      */                 
/*  499 */                 if (idx == 0)
/*      */                 {
/*  501 */                   ((Group)dealCtx._groups.get(groupIdx))._groupLists.clear();
/*      */                   
/*  503 */                   ((Group)dealCtx._groups.get(groupIdx))._groupLists.add(groupLists.get(idx));
/*  504 */                   ((GroupList)((Group)dealCtx._groups.get(groupIdx))._groupLists.get(0))._discounts
/*  505 */                     .add(createDiscount(discount, amount));
/*      */                 }
/*      */                 else
/*      */                 {
/*  509 */                   Group splittedGroup = new Group();
/*      */                   
/*  511 */                   splittedGroup._groupLists.add(groupLists.get(idx));
/*  512 */                   ((GroupList)splittedGroup._groupLists.get(0))._discounts.add(createDiscount(discount, amount));
/*  513 */                   splittedGroups.add(splittedGroup);
/*      */                 }
/*      */               
/*      */               } 
/*      */             } else {
/*      */               
/*  519 */               ((Discount)((GroupList)((Group)dealCtx._groups.get(groupIdx))._groupLists.get(0))._discounts.get(0))._thresholdType = ThresholdType.QUANTITY;
/*      */             } 
/*      */             
/*  522 */             groupIdx++;
/*  523 */             if (splittedGroups.size() > 0) {
/*      */               
/*  525 */               dealCtx._groups.addAll(groupIdx, splittedGroups);
/*  526 */               groupIdx += splittedGroups.size();
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  533 */     int carrySign = 0;
/*      */ 
/*      */     
/*  536 */     int matcherIdx = 1;
/*  537 */     for (Group group : dealCtx._groups) {
/*  538 */       for (GroupList groupList : group._groupLists) {
/*      */         
/*  540 */         DealItemActionDAO dealItem = (DealItemActionDAO)getNewDAO("DealItemAction", DaoState.INSERT_ONLY);
/*  541 */         result.add(dealItem);
/*  542 */         dealItem.setDealId(dealId);
/*  543 */         dealItem.setOrdinal(Integer.valueOf(matcherIdx));
/*      */ 
/*      */ 
/*      */         
/*  547 */         if (dealCtx._type == DealType.SIMPLE) {
/*  548 */           dealItem.setConsumable(
/*  549 */               Boolean.valueOf(!Boolean.parseBoolean(this._configuration.getProperty("overlapSimplePromotions", "false"))));
/*      */         } else {
/*      */           
/*  552 */           dealItem.setConsumable(Boolean.valueOf(true));
/*      */         } 
/*      */         
/*  555 */         if (groupList._discounts.size() > 1)
/*      */         {
/*      */           
/*  558 */           if (dealCtx._type != DealType.THRESHOLD)
/*      */           {
/*      */ 
/*      */ 
/*      */             
/*  563 */             throw new DataFileException(buildTransformationMessage("Multiple discount records detected", this._ctx._metaData, this._ctx._momUnit
/*  564 */                   .getData()));
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*  569 */         Discount discount = groupList._discounts.get(0);
/*      */ 
/*      */         
/*  572 */         dealItem.setMinQty(BigDecimal.ONE);
/*  573 */         if (dealCtx._type == DealType.SIMPLE) {
/*  574 */           dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*      */         }
/*  576 */         else if (dealCtx._type == DealType.TRANSACTION && groupList._items.isEmpty()) {
/*  577 */           dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*      */         } else {
/*      */           BigDecimal qty;
/*  580 */           dealItem.setMaxQty(BigDecimal.ONE);
/*      */           
/*  582 */           switch (discount._thresholdType) {
/*      */             case QUANTITY:
/*  584 */               qty = new BigDecimal(discount._thresholdValue);
/*  585 */               dealItem.setMinQty(qty);
/*  586 */               if (dealCtx._type != DealType.THRESHOLD) {
/*  587 */                 dealItem.setMaxQty(qty);
/*      */                 break;
/*      */               } 
/*  590 */               dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*      */               break;
/*      */ 
/*      */             
/*      */             case AMOUNT:
/*  595 */               dealItem.setMinItemTotal(new BigDecimal(discount._thresholdValue));
/*  596 */               dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*      */               break;
/*      */             
/*      */             case ALL:
/*  600 */               dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*      */               break;
/*      */           } 
/*      */         
/*      */         } 
/*  605 */         if (discount._action != ActionType.DO_NOTHING) {
/*  606 */           if (discount._action == ActionType.CHEAPEST_FREE) {
/*  607 */             dealItem.setMinQty(BigDecimal.ONE);
/*  608 */             dealItem.setMaxQty(BigDecimal.ONE);
/*  609 */             dealItem.setActionType("NEW_PRICE");
/*  610 */             dealItem.setActionArg(BigDecimal.ZERO);
/*      */           } else {
/*      */             
/*  613 */             String pricingAction = this._actionTypeMapping.get(discount._action);
/*  614 */             if (pricingAction != null) {
/*  615 */               dealItem.setActionType(pricingAction);
/*      */             }
/*      */ 
/*      */             
/*  619 */             BigDecimal amount = (discount._action == ActionType.FIXED_PRICE) ? discount._amount : discount._amount.negate();
/*      */             
/*  621 */             if (isMultibuyAllBuyLists && discount._action != ActionType.PERCENT_OFF) {
/*  622 */               int localCurrencyScale = getLocalCurrencyScale();
/*      */               
/*  624 */               BigDecimal[] amountAndReminder = amount.movePointRight(localCurrencyScale).divideAndRemainder(new BigDecimal(multibuyRewardListCount));
/*  625 */               amount = amountAndReminder[0];
/*  626 */               carrySign += amountAndReminder[1].intValue();
/*      */               
/*  628 */               if (carrySign >= multibuyRewardListCount) {
/*  629 */                 amount = amount.add(BigDecimal.ONE);
/*  630 */                 carrySign -= multibuyRewardListCount;
/*      */               } 
/*      */               
/*  633 */               amount = amount.movePointLeft(localCurrencyScale);
/*      */             } 
/*      */             
/*  636 */             dealItem.setActionArg(amount);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  642 */         if (dealCtx._type == DealType.TRANSACTION) {
/*  643 */           dealItem.setActionArgQty(PRORATE_SPLIT_AMONG_ALL_ITEMS);
/*      */         }
/*  645 */         else if (dealCtx._type == DealType.MULTIBUY) {
/*  646 */           if (isMultibuyAllBuyLists) {
/*  647 */             dealItem.setActionArgQty(PRORATE_SPLIT_AMONG_ALL_ITEMS);
/*      */           
/*      */           }
/*  650 */           else if (discount._action == ActionType.AMOUNT_OFF || discount._action == ActionType.PERCENT_OFF) {
/*  651 */             dealItem.setActionArgQty(PRORATE_EACH_ITEM);
/*      */           }
/*  653 */           else if (discount._action == ActionType.FIXED_PRICE) {
/*  654 */             dealItem.setActionArgQty(PRORATE_SPLIT_AMONG_ALL_ITEMS);
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/*  659 */           dealItem.setActionArgQty(PRORATE_EACH_ITEM);
/*      */         } 
/*      */         
/*  662 */         int groupIdx = 1;
/*  663 */         int sequenceIdx = 1;
/*      */         
/*  665 */         if (groupList._items.isEmpty()) {
/*  666 */           if (groupList._priceMin.compareTo(BigDecimal.ZERO) != 0 || groupList._priceMax
/*  667 */             .compareTo(BigDecimal.valueOf(2147483647L)) != 0) {
/*  668 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  669 */             result.add(fieldTest);
/*      */             
/*  671 */             fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  672 */             fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  673 */             fieldTest.setDealId(dealId);
/*  674 */             fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  675 */             fieldTest.setField(ItemField.PRICE.name());
/*  676 */             fieldTest.setMatchRule("BETWEEN");
/*  677 */             fieldTest.setValue1(groupList._priceMin.toPlainString());
/*  678 */             fieldTest.setValue2(groupList._priceMax.toPlainString());
/*  679 */             sequenceIdx++;
/*      */           } 
/*      */ 
/*      */           
/*  683 */           if (dealCtx._applyTo != ApplyTo.BOTH) {
/*  684 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  685 */             result.add(fieldTest);
/*      */             
/*  687 */             fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  688 */             fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  689 */             fieldTest.setDealId(dealId);
/*  690 */             fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  691 */             fieldTest.setField(ItemField.PRICE_PROPERTY_CODE.name());
/*      */             
/*  693 */             String matchRule = (dealCtx._applyTo == ApplyTo.CLEARANCE) ? "EQUAL" : "NOT_EQUAL";
/*      */             
/*  695 */             fieldTest.setMatchRule(matchRule);
/*  696 */             fieldTest.setValue1(PriceTypes.CLEARANCE_PRICE.name());
/*      */             
/*  698 */             sequenceIdx++;
/*      */           } 
/*      */         } else {
/*      */           
/*  702 */           for (String itemId : groupList._items) {
/*  703 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  704 */             result.add(fieldTest);
/*      */ 
/*      */             
/*  707 */             fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  708 */             fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  709 */             fieldTest.setDealId(dealId);
/*  710 */             fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  711 */             fieldTest.setField("SKU");
/*  712 */             fieldTest.setMatchRule("EQUAL");
/*  713 */             fieldTest.setValue1(itemId);
/*  714 */             sequenceIdx++;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  723 */             if (groupList._priceMin.compareTo(BigDecimal.ZERO) != 0 || groupList._priceMax
/*  724 */               .compareTo(BigDecimal.valueOf(2147483647L)) != 0) {
/*  725 */               fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  726 */               result.add(fieldTest);
/*  727 */               fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  728 */               fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  729 */               fieldTest.setDealId(dealId);
/*  730 */               fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  731 */               fieldTest.setField("PRICE");
/*  732 */               fieldTest.setMatchRule("BETWEEN");
/*  733 */               fieldTest.setValue1(groupList._priceMin.toPlainString());
/*  734 */               fieldTest.setValue2(groupList._priceMax.toPlainString());
/*  735 */               sequenceIdx++;
/*      */             } 
/*      */ 
/*      */             
/*  739 */             if (dealCtx._applyTo != ApplyTo.BOTH) {
/*  740 */               fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  741 */               result.add(fieldTest);
/*  742 */               fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  743 */               fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  744 */               fieldTest.setDealId(dealId);
/*  745 */               fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  746 */               fieldTest.setField("PRICE_PROPERTY_CODE");
/*      */               
/*  748 */               String matchRule = (dealCtx._applyTo == ApplyTo.CLEARANCE) ? "EQUAL" : "NOT_EQUAL";
/*      */               
/*  750 */               fieldTest.setMatchRule(matchRule);
/*  751 */               fieldTest.setValue1(PriceTypes.CLEARANCE_PRICE.name());
/*      */               
/*  753 */               sequenceIdx++;
/*      */             } 
/*      */ 
/*      */             
/*  757 */             groupIdx++;
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  762 */         matcherIdx++;
/*      */       } 
/*      */     } 
/*      */     
/*  766 */     if (dealCtx._type == DealType.TRANSACTION) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  773 */       GroupList firstGroup = ((Group)dealCtx._groups.get(0))._groupLists.get(0);
/*  774 */       Discount discount = firstGroup._discounts.get(0);
/*      */       
/*  776 */       if (discount._action == ActionType.PERCENT_OFF)
/*      */       {
/*      */         
/*  779 */         if (!firstGroup._items.isEmpty()) {
/*      */           
/*  781 */           DealItemActionDAO dealItem = (DealItemActionDAO)getNewDAO("DealItemAction", DaoState.INSERT_ONLY);
/*  782 */           result.add(dealItem);
/*  783 */           dealItem.setDealId(dealId);
/*  784 */           dealItem.setOrdinal(Integer.valueOf(matcherIdx));
/*  785 */           dealItem.setConsumable(Boolean.valueOf(true));
/*  786 */           dealItem.setMinQty(BigDecimal.ZERO);
/*  787 */           dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*  788 */           dealItem.setActionType("PERCENT_OFF");
/*  789 */           dealItem.setActionArg(discount._amount.negate());
/*      */           
/*  791 */           matcherIdx++;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  796 */         this._ctx._parentDeal = dealCtx;
/*  797 */         dealCtx._childDealMatcherIdx = matcherIdx;
/*  798 */         dealCtx._childDealItemIdx = 1;
/*  799 */         dealCtx._groups = null;
/*      */       }
/*      */     
/*  802 */     } else if (dealCtx._type == DealType.THRESHOLD) {
/*  803 */       Discount discount = ((GroupList)((Group)dealCtx._groups.get(0))._groupLists.get(0))._discounts.get(0);
/*  804 */       if (discount._thresholdType == ThresholdType.AMOUNT) {
/*      */         
/*  806 */         DealItemActionDAO dealItem = (DealItemActionDAO)getNewDAO("DealItemAction", DaoState.INSERT_ONLY);
/*  807 */         result.add(dealItem);
/*  808 */         dealItem.setDealId(dealId);
/*  809 */         dealItem.setOrdinal(Integer.valueOf(matcherIdx));
/*  810 */         dealItem.setConsumable(Boolean.valueOf(true));
/*  811 */         dealItem.setMinQty(BigDecimal.ZERO);
/*  812 */         dealItem.setMaxQty(QUANTITY_ALL_ITEMS);
/*      */         
/*  814 */         String pricingAction = this._actionTypeMapping.get(discount._action);
/*  815 */         if (pricingAction != null) {
/*  816 */           dealItem.setActionType(pricingAction);
/*      */         }
/*      */ 
/*      */         
/*  820 */         BigDecimal amount = (discount._action == ActionType.FIXED_PRICE) ? discount._amount : discount._amount.negate();
/*  821 */         dealItem.setActionArg(amount);
/*      */         
/*  823 */         GroupList groupList = ((Group)dealCtx._groups.get(0))._groupLists.get(0);
/*      */         
/*  825 */         int groupIdx = 1;
/*  826 */         int sequenceIdx = 1;
/*      */         
/*  828 */         if (groupList._items.isEmpty()) {
/*  829 */           if (groupList._priceMin.compareTo(BigDecimal.ZERO) != 0 || groupList._priceMax
/*  830 */             .compareTo(BigDecimal.valueOf(2147483647L)) != 0) {
/*  831 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  832 */             result.add(fieldTest);
/*      */             
/*  834 */             fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  835 */             fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  836 */             fieldTest.setDealId(dealId);
/*  837 */             fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  838 */             fieldTest.setField(ItemField.PRICE.name());
/*  839 */             fieldTest.setMatchRule("BETWEEN");
/*  840 */             fieldTest.setValue1(groupList._priceMin.toPlainString());
/*  841 */             fieldTest.setValue2(groupList._priceMax.toPlainString());
/*  842 */             sequenceIdx++;
/*      */           } 
/*      */ 
/*      */           
/*  846 */           if (dealCtx._applyTo != ApplyTo.BOTH) {
/*  847 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  848 */             result.add(fieldTest);
/*  849 */             fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  850 */             fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  851 */             fieldTest.setDealId(dealId);
/*  852 */             fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  853 */             fieldTest.setField(ItemField.PRICE_PROPERTY_CODE.name());
/*      */             
/*  855 */             String matchRule = (dealCtx._applyTo == ApplyTo.CLEARANCE) ? "EQUAL" : "NOT_EQUAL";
/*      */             
/*  857 */             fieldTest.setMatchRule(matchRule);
/*  858 */             fieldTest.setValue1(PriceTypes.CLEARANCE_PRICE.name());
/*      */             
/*  860 */             sequenceIdx++;
/*      */           } 
/*      */         } else {
/*      */           
/*  864 */           for (String itemId : groupList._items) {
/*  865 */             DealFieldTestDAO fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  866 */             result.add(fieldTest);
/*      */ 
/*      */             
/*  869 */             fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  870 */             fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  871 */             fieldTest.setDealId(dealId);
/*  872 */             fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  873 */             fieldTest.setField("SKU");
/*  874 */             fieldTest.setMatchRule("EQUAL");
/*  875 */             fieldTest.setValue1(itemId);
/*  876 */             sequenceIdx++;
/*      */ 
/*      */             
/*  879 */             if (groupList._priceMin.compareTo(BigDecimal.ZERO) != 0 || groupList._priceMax
/*  880 */               .compareTo(BigDecimal.valueOf(2147483647L)) != 0) {
/*  881 */               fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  882 */               result.add(fieldTest);
/*  883 */               fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  884 */               fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  885 */               fieldTest.setDealId(dealId);
/*  886 */               fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  887 */               fieldTest.setField("PRICE");
/*  888 */               fieldTest.setMatchRule("BETWEEN");
/*  889 */               fieldTest.setValue1(groupList._priceMin.toPlainString());
/*  890 */               fieldTest.setValue2(groupList._priceMax.toPlainString());
/*  891 */               sequenceIdx++;
/*      */             } 
/*      */ 
/*      */             
/*  895 */             if (dealCtx._applyTo != ApplyTo.BOTH) {
/*  896 */               fieldTest = (DealFieldTestDAO)getNewDAO("DealFieldTest", DaoState.INSERT_ONLY);
/*  897 */               result.add(fieldTest);
/*  898 */               fieldTest.setItemConditionGroup(Integer.valueOf(groupIdx));
/*  899 */               fieldTest.setItemConditionSeq(Integer.valueOf(sequenceIdx));
/*  900 */               fieldTest.setDealId(dealId);
/*  901 */               fieldTest.setOrdinal(Integer.valueOf(matcherIdx));
/*  902 */               fieldTest.setField("PRICE_PROPERTY_CODE");
/*      */               
/*  904 */               String matchRule = (dealCtx._applyTo == ApplyTo.CLEARANCE) ? "EQUAL" : "NOT_EQUAL";
/*      */               
/*  906 */               fieldTest.setMatchRule(matchRule);
/*  907 */               fieldTest.setValue1(PriceTypes.CLEARANCE_PRICE.name());
/*      */               
/*  909 */               sequenceIdx++;
/*      */             } 
/*      */           } 
/*      */           
/*  913 */           groupIdx++;
/*      */         } 
/*      */         
/*  916 */         matcherIdx++;
/*      */       } 
/*      */     } 
/*      */     
/*  920 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<GroupList> splitGroupList(GroupList argGroupList) {
/*  929 */     List<GroupList> groupLists = new ArrayList<>();
/*  930 */     for (int idx = 0; idx < argGroupList._items.size(); idx++) {
/*  931 */       GroupList groupList = new GroupList();
/*  932 */       groupList._items.add(argGroupList._items.get(idx));
/*  933 */       groupLists.add(groupList);
/*      */     } 
/*  935 */     return groupLists; } protected List<IPersistable> transformRecord(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit, MOMFileLine argLine) { String eventType, promoId, rewardApplication, itemId, changeType, promotionId; Action action; String promoCompId, priceRangeMin, changeAmount; List<IPersistable> queries; String promoCompDesc, priceRangeMax, changePercent, promoType; GroupList groupList; String qualificationType, promoCompDetailId, qualificationValue, startDate; ActionType actionType; String endDate; BigDecimal amount; String applyToCode;
/*      */     Discount discount;
/*      */     String discountLimit;
/*      */     ThresholdType thresholdType;
/*      */     String parentId;
/*      */     Deal deal;
/*      */     DealType dealType;
/*      */     ApplyTo applyToType;
/*  943 */     String[] argFields = argLine.getFields();
/*      */     
/*  945 */     String recordDescriptor = argFields[0];
/*  946 */     switch (recordDescriptor) {
/*      */       
/*      */       case "TMBPE":
/*  949 */         eventType = argFields[2];
/*      */         
/*  951 */         action = Action.findByCode(eventType);
/*  952 */         if (action == null) {
/*  953 */           throw new DataFileException(
/*  954 */               buildTransformationMessage("Unknown event type in TMBPE record: " + eventType, argMetaData, argLine));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  959 */         this._ctx = new Context();
/*  960 */         this._ctx._action = action;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case "TPDTL":
/*  966 */         promoId = argFields[2];
/*  967 */         promoCompId = argFields[3];
/*      */ 
/*      */         
/*  970 */         promoCompDesc = argFields[6];
/*  971 */         promoType = argFields[7];
/*  972 */         promoCompDetailId = argFields[8];
/*  973 */         startDate = argFields[9];
/*  974 */         endDate = argFields[10];
/*  975 */         applyToCode = argFields[11];
/*  976 */         discountLimit = argFields[12];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  983 */         parentId = null;
/*      */ 
/*      */         
/*  986 */         if (argFields.length > 17) {
/*  987 */           parentId = argFields[17];
/*      */         }
/*      */         
/*  990 */         deal = new Deal();
/*  991 */         this._ctx._currentDeal = deal;
/*  992 */         this._ctx._currentDealIdx++;
/*      */         
/*  994 */         deal._promotionId = promoId;
/*  995 */         deal._promotionComponentId = promoCompId;
/*  996 */         deal._promotionComponentDetailId = promoCompDetailId;
/*  997 */         deal._parentId = parentId;
/*      */         
/*  999 */         dealType = DealType.findByCode(promoType);
/* 1000 */         if (dealType == null) {
/* 1001 */           throw new DataFileException(
/* 1002 */               buildTransformationMessage("Unknown PromotionType in TPDTL record: " + dealType, argMetaData, argLine));
/*      */         }
/*      */ 
/*      */         
/* 1006 */         deal._type = dealType;
/* 1007 */         deal._description = promoCompDesc;
/*      */         
/* 1009 */         if (!StringUtils.isEmpty(discountLimit)) {
/*      */           try {
/* 1011 */             deal._iterationCap = Integer.parseInt(discountLimit);
/*      */           }
/* 1013 */           catch (NumberFormatException ex) {
/* 1014 */             throw new DataFileException(
/* 1015 */                 buildTransformationMessage("Couldn't parse DiscountLimit in TPDTL record: " + discountLimit, argMetaData, argLine));
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/* 1020 */           deal._iterationCap = -1;
/*      */         } 
/*      */         
/*      */         try {
/* 1024 */           deal._effectiveDate = (Date)this._timestampFormatter.parseObject(startDate);
/*      */         }
/* 1026 */         catch (ParseException ex) {
/* 1027 */           throw new DataFileException(
/* 1028 */               buildTransformationMessage("Couldn't parse StartDate in TPDTL record: " + startDate, argMetaData, argLine));
/*      */         } 
/*      */ 
/*      */         
/* 1032 */         if (!StringUtils.isEmpty(endDate)) {
/*      */           try {
/* 1034 */             deal._endDate = (Date)this._timestampFormatter.parseObject(endDate);
/*      */           }
/* 1036 */           catch (ParseException ex) {
/* 1037 */             throw new DataFileException(
/* 1038 */                 buildTransformationMessage("Couldn't parse EndDate in TPDTL record: " + endDate, argMetaData, argLine));
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/* 1043 */         applyToType = ApplyTo.findByCode(applyToCode);
/* 1044 */         if (applyToType == null) {
/* 1045 */           throw new DataFileException(
/* 1046 */               buildTransformationMessage("Unknown ApplyToOrder in TPDTL record: " + applyToType, argMetaData, argLine));
/*      */         }
/*      */ 
/*      */         
/* 1050 */         deal._applyTo = applyToType;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case "TPGRP":
/* 1056 */         this._ctx._currentGroup = new Group();
/* 1057 */         this._ctx._currentDeal._groups.add(this._ctx._currentGroup);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case "TGLIST":
/* 1065 */         rewardApplication = argFields[3];
/*      */         
/* 1067 */         priceRangeMin = argFields[5];
/* 1068 */         priceRangeMax = argFields[6];
/*      */         
/* 1070 */         groupList = new GroupList();
/* 1071 */         this._ctx._currentGroup._groupLists.add(groupList);
/* 1072 */         this._ctx._currentGroupList = groupList;
/*      */         
/* 1074 */         if (!StringUtils.isEmpty(priceRangeMin)) {
/* 1075 */           groupList._priceMin = new BigDecimal(priceRangeMin);
/*      */         }
/*      */         
/* 1078 */         if (!StringUtils.isEmpty(priceRangeMax)) {
/* 1079 */           groupList._priceMax = new BigDecimal(priceRangeMax);
/*      */         }
/*      */         
/* 1082 */         groupList._rewardApplication = rewardApplication;
/*      */ 
/*      */ 
/*      */       
/*      */       case "TLITM":
/* 1087 */         itemId = argFields[2];
/*      */         
/* 1089 */         this._ctx._currentGroupList._items.add(itemId);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case "TPDSC":
/* 1096 */         changeType = argFields[2];
/* 1097 */         changeAmount = argFields[3];
/*      */         
/* 1099 */         changePercent = argFields[5];
/*      */         
/* 1101 */         qualificationType = argFields[7];
/* 1102 */         qualificationValue = argFields[8];
/*      */ 
/*      */         
/* 1105 */         actionType = ActionType.findByCode(changeType);
/* 1106 */         if (actionType == null) {
/* 1107 */           throw new DataFileException(
/* 1108 */               buildTransformationMessage("Unknown ChangeType in TPDSC: " + changeType, argMetaData, argLine));
/*      */         }
/* 1110 */         if (actionType == ActionType.CHEAPEST_FREE) {
/* 1111 */           throw new DataFileException(buildTransformationMessage("Promotions with 'Cheapest Free' action are NOT supported!", argMetaData, argUnit
/* 1112 */                 .getData()));
/*      */         }
/*      */ 
/*      */         
/* 1116 */         switch (actionType) {
/*      */           case QUANTITY:
/*      */           case ALL:
/* 1119 */             amount = new BigDecimal(changeAmount);
/*      */             break;
/*      */           
/*      */           case AMOUNT:
/* 1123 */             amount = new BigDecimal(changePercent);
/*      */             break;
/*      */           default:
/* 1126 */             amount = null;
/*      */             break;
/*      */         } 
/*      */         
/* 1130 */         discount = new Discount();
/* 1131 */         discount._action = actionType;
/* 1132 */         discount._amount = amount;
/*      */         
/* 1134 */         thresholdType = null;
/* 1135 */         if (!StringUtils.isEmpty(qualificationType)) {
/* 1136 */           thresholdType = ThresholdType.findByCode(qualificationType);
/*      */         }
/*      */         
/* 1139 */         if (actionType != ActionType.EXCLUDE && 
/* 1140 */           thresholdType == null) {
/* 1141 */           throw new DataFileException(buildTransformationMessage("Unknown QualificationType in TPDSC: " + qualificationType, argMetaData, argLine));
/*      */         }
/*      */ 
/*      */         
/* 1145 */         discount._thresholdType = thresholdType;
/* 1146 */         discount._thresholdValue = qualificationValue;
/*      */         
/* 1148 */         this._ctx._currentGroupList._discounts.add(discount);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case "FPDEL":
/* 1154 */         this._ctx = new Context();
/*      */         
/* 1156 */         promotionId = argFields[2];
/* 1157 */         queries = deleteDealsByPromotion(promotionId);
/*      */         
/* 1159 */         return queries;
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
/*      */       case "TPISR":
/*      */       case "TPILSR":
/*      */       case "TPCDT":
/*      */       case "TPCI":
/*      */       case "TPCIL":
/*      */       case "TLLST":
/* 1176 */         return null;
/*      */     } 
/*      */     _logger.warn(buildTransformationMessage("Ignoring unknown record type: " + recordDescriptor, argMetaData, argUnit.getData())); }
/*      */ 
/*      */   
/*      */   enum Action
/*      */   {
/* 1183 */     CREATE("CRE"), MODIFY("MOD"); private String _code;
/*      */     
/*      */     public static Action findByCode(String argCode) {
/* 1186 */       for (Action element : values()) {
/* 1187 */         if (element._code.equals(argCode)) {
/* 1188 */           return element;
/*      */         }
/*      */       } 
/*      */       
/* 1192 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Action(String argCode) {
/* 1198 */       this._code = argCode;
/*      */     }
/*      */   }
/*      */   
/*      */   enum ActionType {
/* 1203 */     DO_NOTHING("-1"), PERCENT_OFF("0"), AMOUNT_OFF("1"), FIXED_PRICE("2"), EXCLUDE("4"), CHEAPEST_FREE("6"); private String _code;
/*      */     
/*      */     public static ActionType findByCode(String argCode) {
/* 1206 */       for (ActionType element : values()) {
/* 1207 */         if (element._code.equals(argCode)) {
/* 1208 */           return element;
/*      */         }
/*      */       } 
/*      */       
/* 1212 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     ActionType(String argCode) {
/* 1218 */       this._code = argCode;
/*      */     }
/*      */   }
/*      */   
/*      */   enum ApplyTo {
/* 1223 */     REGULAR("0"), CLEARANCE("1"), BOTH("2"); private String _code;
/*      */     
/*      */     public static ApplyTo findByCode(String argCode) {
/* 1226 */       for (ApplyTo element : values()) {
/* 1227 */         if (element._code.equals(argCode)) {
/* 1228 */           return element;
/*      */         }
/*      */       } 
/*      */       
/* 1232 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     ApplyTo(String argCode) {
/* 1238 */       this._code = argCode;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class Context
/*      */   {
/*      */     protected MOMUnit _momUnit;
/*      */     
/*      */     protected DataFileMetaData<MOMFileConfiguration> _metaData;
/*      */     
/*      */     protected PromotionTransformer.Action _action;
/*      */     
/* 1252 */     protected int _currentDealIdx = 0;
/*      */     
/*      */     protected PromotionTransformer.Deal _currentDeal;
/*      */     protected PromotionTransformer.GroupList _currentGroupList;
/*      */     protected PromotionTransformer.Group _currentGroup;
/* 1257 */     protected PromotionTransformer.Deal _parentDeal = null;
/*      */   }
/*      */   
/*      */   class Deal {
/*      */     protected int _thresholdDealIdx;
/*      */     protected String _promotionId;
/*      */     protected String _promotionComponentId;
/*      */     protected String _promotionComponentDetailId;
/*      */     protected String _parentId;
/*      */     protected String _description;
/*      */     protected PromotionTransformer.DealType _type;
/*      */     protected int _iterationCap;
/*      */     protected PromotionTransformer.ApplyTo _applyTo;
/*      */     protected Date _endDate;
/*      */     protected Date _effectiveDate;
/*      */     protected int _childDealMatcherIdx;
/*      */     protected int _childDealItemIdx;
/* 1274 */     protected List<PromotionTransformer.Group> _groups = new ArrayList<>();
/*      */   }
/*      */   
/*      */   enum DealType {
/* 1278 */     MULTIBUY("0"), SIMPLE("1"), THRESHOLD("2"), FINANCE("3"), TRANSACTION("4"); private String _code;
/*      */     
/*      */     public static DealType findByCode(String argCode) {
/* 1281 */       for (DealType element : values()) {
/* 1282 */         if (element._code.equals(argCode)) {
/* 1283 */           return element;
/*      */         }
/*      */       } 
/*      */       
/* 1287 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     DealType(String argCode) {
/* 1293 */       this._code = argCode;
/*      */     }
/*      */   }
/*      */   
/*      */   class Discount {
/*      */     protected PromotionTransformer.ActionType _action;
/*      */     protected BigDecimal _amount;
/*      */     protected PromotionTransformer.ThresholdType _thresholdType;
/*      */     protected String _thresholdValue;
/*      */   }
/*      */   
/*      */   class Group {
/* 1305 */     protected List<PromotionTransformer.GroupList> _groupLists = new ArrayList<>();
/*      */   }
/*      */   
/*      */   class GroupList {
/* 1309 */     protected BigDecimal _priceMin = BigDecimal.ZERO;
/* 1310 */     protected BigDecimal _priceMax = BigDecimal.valueOf(2147483647L);
/*      */     
/*      */     protected String _rewardApplication;
/*      */     
/* 1314 */     protected List<String> _items = new ArrayList<>();
/* 1315 */     protected List<PromotionTransformer.Discount> _discounts = new ArrayList<>();
/*      */   }
/*      */   
/*      */   enum ThresholdType {
/* 1319 */     ALL("0"), AMOUNT("1"), QUANTITY("2"); private String _code;
/*      */     
/*      */     public static ThresholdType findByCode(String argCode) {
/* 1322 */       for (ThresholdType element : values()) {
/* 1323 */         if (element._code.equals(argCode)) {
/* 1324 */           return element;
/*      */         }
/*      */       } 
/*      */       
/* 1328 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     ThresholdType(String argCode) {
/* 1334 */       this._code = argCode;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\PromotionTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */