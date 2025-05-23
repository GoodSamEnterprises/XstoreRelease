/*     */ package dtv.xst.pricing.refresh;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.DefaultQueryResult;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.pricing2.DealAction;
/*     */ import dtv.pricing2.IFieldTest;
/*     */ import dtv.pricing2.IItemField;
/*     */ import dtv.pricing2.IItemMatcher;
/*     */ import dtv.pricing2.IMatchingRule;
/*     */ import dtv.pricing2.ItemMatch;
/*     */ import dtv.pricing2.PricingAdapter;
/*     */ import dtv.pricing2.PricingDeal;
/*     */ import dtv.pricing2.match.DenyFieldTest;
/*     */ import dtv.pricing2.match.OrFieldTest;
/*     */ import dtv.pricing2.match.PassFieldTest;
/*     */ import dtv.pricing2.match.SimpleFieldTest;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.xst.dao.prc.IDeal;
/*     */ import dtv.xst.dao.prc.IDealFieldTest;
/*     */ import dtv.xst.dao.prc.IDealItemAction;
/*     */ import dtv.xst.dao.prc.IDealTrigger;
/*     */ import dtv.xst.dao.prc.IDealWeek;
/*     */ import dtv.xst.pricing.XSTPricingDescriptor;
/*     */ import java.math.BigDecimal;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.LocalTime;
/*     */ import java.time.ZoneId;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ public abstract class DtxRefreshStrategyBase extends DealRefreshStrategy {
/*  41 */   private static final Logger logger_ = LogManager.getLogger(DtxRefreshStrategyBase.class);
/*     */ 
/*     */   
/*  44 */   protected static final IQueryKey<IDealFieldTest> LOAD_FIELD_TESTS_QUERY = (IQueryKey<IDealFieldTest>)new QueryKey("LOAD_FIELD_TESTS", IDealFieldTest.class);
/*     */ 
/*     */   
/*  47 */   private static final IQueryKey<IDealWeek> DEAL_TIMES_BY_DAY = (IQueryKey<IDealWeek>)new QueryKey("DEAL_TIMES_BY_DAY", IDealWeek.class);
/*     */ 
/*     */ 
/*     */   
/*  51 */   protected static final IQueryKey<DefaultQueryResult> COUNT_FIELD_TESTS = (IQueryKey<DefaultQueryResult>)new QueryKey("COUNT_FIELD_TESTS", DefaultQueryResult.class);
/*     */ 
/*     */   
/*  54 */   private static final BigDecimal MAX_QUANTITY = BigDecimal.valueOf(1000000L);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   @Named("preloadedDealDefinitions")
/*     */   private Map<String, PricingDeal> _preloadedDealDefinitions;
/*     */ 
/*     */ 
/*     */   
/*     */   protected static LocalDateTime getLocalDateTime(Date argDate) {
/*  64 */     if (argDate != null) {
/*  65 */       return LocalDateTime.ofInstant(argDate.toInstant(), ZoneId.systemDefault());
/*     */     }
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static LocalTime getLocalTime(Date argTime) {
/*  78 */     if (argTime != null) {
/*  79 */       LocalDateTime argDateTime = LocalDateTime.ofInstant(argTime.toInstant(), ZoneId.systemDefault());
/*  80 */       return argDateTime.toLocalTime();
/*     */     } 
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean shouldLazyLoad(IDeal argDeal) {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PricingDeal translateDeal(IDeal xstoreDeal, XSTPricingDescriptor attachment) {
/* 108 */     boolean shouldLazyLoad = shouldLazyLoad(xstoreDeal);
/* 109 */     boolean hasExclusions = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     String dealId = xstoreDeal.getDealId();
/* 116 */     PricingDeal pricingDeal = new PricingDeal(dealId, attachment);
/*     */     
/* 118 */     pricingDeal.setPriorityNudge(xstoreDeal.getPriorityNudge());
/*     */ 
/*     */     
/* 121 */     if (xstoreDeal.getEffectiveDate() != null) {
/* 122 */       pricingDeal.setEffectiveDate(getLocalDateTime(xstoreDeal.getEffectiveDate()));
/*     */     }
/* 124 */     if (xstoreDeal.getEndDate() != null) {
/* 125 */       pricingDeal.setEndDate(getLocalDateTime(xstoreDeal.getEndDate()));
/*     */     }
/*     */     
/* 128 */     boolean useGlobalEffectiveTime = true;
/*     */ 
/*     */     
/* 131 */     if (xstoreDeal.getUseWeekSchedule()) {
/*     */       
/* 133 */       Collection<CompositeObject.TwoPiece<LocalTime, LocalTime>> effectiveTimes = translateEffectiveTimes(xstoreDeal, DateUtils.getNewDate());
/*     */       
/* 135 */       if (!effectiveTimes.isEmpty()) {
/* 136 */         useGlobalEffectiveTime = false;
/* 137 */         pricingDeal.setEffectiveTimes(effectiveTimes);
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     if (useGlobalEffectiveTime) {
/* 142 */       if (xstoreDeal.getStartTime() != null) {
/* 143 */         pricingDeal.setStartTime(getLocalTime(xstoreDeal.getStartTime()));
/*     */       }
/*     */       
/* 146 */       if (xstoreDeal.getEndTime() != null) {
/* 147 */         pricingDeal.setEndTime(getLocalTime(xstoreDeal.getEndTime()));
/*     */       }
/*     */     } 
/*     */     
/* 151 */     pricingDeal.setGroupId(xstoreDeal.getGroupId());
/* 152 */     pricingDeal.setSortOrder(xstoreDeal.getSortOrder());
/* 153 */     pricingDeal.setType(xstoreDeal.getType());
/*     */ 
/*     */     
/* 156 */     if (xstoreDeal.getConsumable()) {
/* 157 */       pricingDeal.setConsumable(xstoreDeal.getConsumable());
/*     */     }
/*     */ 
/*     */     
/* 161 */     if (xstoreDeal.getDeferred()) {
/* 162 */       pricingDeal.setDeferred(xstoreDeal.getDeferred());
/*     */     }
/*     */ 
/*     */     
/* 166 */     PricingAdapter<?, ?> pricingAdapter = getPricingAdapter();
/* 167 */     long qtyOne = pricingAdapter.convertQuantity(BigDecimal.ONE);
/*     */     
/* 169 */     pricingDeal.setQtyOne(qtyOne);
/*     */     
/* 171 */     if (NumberUtils.isPositive(xstoreDeal.getGenerosityCap())) {
/* 172 */       pricingDeal.setGenerosityCap(pricingAdapter.convertPrice(xstoreDeal.getGenerosityCap()));
/*     */     }
/* 174 */     if (xstoreDeal.getTransActionType() != null) {
/*     */       
/* 176 */       pricingDeal.setIterationCap(1);
/*     */     } else {
/*     */       
/* 179 */       pricingDeal.setIterationCap(xstoreDeal.getIterationCap());
/*     */     } 
/*     */     
/* 182 */     if (xstoreDeal.getHigherNonactionAmt()) {
/* 183 */       pricingDeal.setHigherNonactionAmt(xstoreDeal.getHigherNonactionAmt());
/*     */     }
/* 185 */     if (xstoreDeal.getExcludePriceOverride()) {
/* 186 */       pricingDeal.setExcludePriceOverride(xstoreDeal.getExcludePriceOverride());
/*     */     }
/* 188 */     if (xstoreDeal.getExcludeDiscounted()) {
/* 189 */       pricingDeal.setExcludeDiscounted(xstoreDeal.getExcludeDiscounted());
/*     */     }
/* 191 */     if (xstoreDeal.getTargeted()) {
/* 192 */       pricingDeal.setTarget(dealId);
/*     */     }
/*     */ 
/*     */     
/* 196 */     if (xstoreDeal.getMinimumSubtotal() != null) {
/* 197 */       pricingDeal.setSubtotalMin(pricingAdapter.convertPrice(xstoreDeal.getMinimumSubtotal()));
/*     */     }
/* 199 */     if (xstoreDeal.getMaximumSubtotal() != null) {
/* 200 */       pricingDeal.setSubtotalMax(pricingAdapter.convertPrice(xstoreDeal.getMaximumSubtotal()));
/*     */     }
/* 202 */     else if (xstoreDeal.getMinimumSubtotal() != null) {
/* 203 */       pricingDeal.setSubtotalMax(pricingAdapter.convertPrice(BigDecimal.valueOf(99999999L, 2)));
/*     */     } 
/*     */ 
/*     */     
/* 207 */     if (xstoreDeal.getTransActionType() != null) {
/* 208 */       DealAction action = this._actionFactory.createAction(xstoreDeal.getTransActionType());
/* 209 */       action.setAmount(pricingAdapter.convertPrice(xstoreDeal.getTransActionAmount()));
/* 210 */       action.setDistribution(-qtyOne);
/* 211 */       action.setQtyOne(qtyOne);
/*     */       
/* 213 */       pricingDeal.setTransactionAction(action);
/*     */     } 
/*     */     
/* 216 */     List<String> trigs = new ArrayList<>(xstoreDeal.getTriggers().size());
/*     */ 
/*     */     
/* 219 */     if (xstoreDeal.getCustomerGroups() != null) {
/* 220 */       for (IDealTrigger trig : xstoreDeal.getTriggers()) {
/* 221 */         trigs.add(trig.getTrigger());
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 226 */     if (xstoreDeal.getCustomerGroups() != null) {
/* 227 */       for (IDealCustomerGroups groups : xstoreDeal.getCustomerGroups()) {
/* 228 */         trigs.add("CUSTGROUP:" + groups.getCustomerGroupId());
/*     */       }
/*     */     }
/*     */     
/* 232 */     pricingDeal.setTriggers(trigs);
/*     */ 
/*     */     
/* 235 */     List<IDealItemAction> xItemMatchers = xstoreDeal.getItems();
/*     */     
/* 237 */     Collections.sort(xItemMatchers, Comparator.comparingInt(IDealItemAction::getOrdinal));
/*     */     
/* 239 */     List<IItemMatcher> pItemMatchers = new ArrayList<>();
/* 240 */     for (IDealItemAction xItemMatcher : xItemMatchers) {
/* 241 */       IQueryResultList<IDealFieldTest> iQueryResultList; OrFieldTest orFieldTest; ItemMatch pItemMatcher = new ItemMatch();
/* 242 */       pItemMatcher.setConsumable(xItemMatcher.getConsumable());
/*     */ 
/*     */       
/* 245 */       if (shouldLazyLoad) {
/* 246 */         Map<String, Object> params = new TreeMap<>();
/* 247 */         params.put("argDealId", dealId);
/* 248 */         params.put("argOrdinal", Integer.valueOf(xItemMatcher.getOrdinal()));
/*     */         
/* 250 */         params.put("argMatchRule", "EQUAL");
/*     */         
/* 252 */         int testCount = ((Integer)((DefaultQueryResult)DataFactory.getObjectByQuery(COUNT_FIELD_TESTS, params).get(0)).get("test_count")).intValue();
/*     */         
/* 254 */         params.put("argMatchRule", "NOT_EQUAL");
/*     */         
/* 256 */         int exclusionCount = ((Integer)((DefaultQueryResult)DataFactory.getObjectByQuery(COUNT_FIELD_TESTS, params).get(0)).get("test_count")).intValue();
/*     */         
/* 258 */         if (testCount > 0 && exclusionCount > 0) {
/* 259 */           logger_.error("Deal {} mixes exclusion and normal field tests!", dealId);
/* 260 */           return null;
/*     */         } 
/*     */         
/* 263 */         this._preloadedDealDefinitions.put(dealId, pricingDeal);
/*     */       } 
/*     */       
/* 266 */       if (xItemMatcher.getActionType() != null && !xItemMatcher.getActionType().isEmpty()) {
/* 267 */         DealAction action = this._actionFactory.createAction(xItemMatcher.getActionType());
/* 268 */         action.setAmount(pricingAdapter.convertPrice(xItemMatcher.getActionArg()));
/*     */         
/* 270 */         BigDecimal actionArgQty = (xItemMatcher.getActionArgQty() == null) ? BigDecimal.ONE : xItemMatcher.getActionArgQty();
/* 271 */         action.setDistribution(pricingAdapter.convertQuantity(actionArgQty));
/* 272 */         action.setQtyOne(qtyOne);
/* 273 */         pItemMatcher.setAction(action);
/*     */       } 
/*     */ 
/*     */       
/* 277 */       if (xItemMatcher.getMinQty() != null) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 282 */           BigDecimal maxQty = NumberUtils.isNonPositive(xItemMatcher.getMaxQty()) ? MAX_QUANTITY : xItemMatcher.getMaxQty();
/*     */           
/* 284 */           BigDecimal minQty = NumberUtils.isNonPositive(xItemMatcher.getMinQty()) ? NumberUtils.ZERO : xItemMatcher.getMinQty();
/*     */ 
/*     */           
/* 287 */           if (NumberUtils.isGreaterThan(minQty, maxQty)) {
/* 288 */             maxQty = minQty;
/*     */           }
/* 290 */           pItemMatcher.setMinQty(pricingAdapter.convertQuantity(minQty));
/* 291 */           pItemMatcher.setMaxQty(pricingAdapter.convertQuantity(maxQty));
/*     */         }
/* 293 */         catch (Exception ex) {
/* 294 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */       }
/*     */       
/* 298 */       if (NumberUtils.isPositive(xItemMatcher.getMinItemTotal())) {
/* 299 */         pItemMatcher.setMinTotal(pricingAdapter.convertPrice(xItemMatcher.getMinItemTotal()));
/*     */       }
/*     */ 
/*     */       
/* 303 */       if (shouldLazyLoad) {
/* 304 */         List<IDealFieldTest> xFieldTests = Collections.emptyList();
/*     */       } else {
/*     */         
/* 307 */         Map<String, Object> params = new HashMap<>();
/* 308 */         params.put("argDealId", dealId);
/* 309 */         params.put("argOrdinal", Integer.valueOf(xItemMatcher.getOrdinal()));
/*     */         
/* 311 */         iQueryResultList = DataFactory.getObjectByQueryNoThrow(LOAD_FIELD_TESTS_QUERY, params);
/*     */       } 
/*     */ 
/*     */       
/* 315 */       if (iQueryResultList.isEmpty()) {
/* 316 */         if (shouldLazyLoad) {
/* 317 */           DenyFieldTest denyFieldTest = new DenyFieldTest();
/*     */         } else {
/*     */           
/* 320 */           PassFieldTest passFieldTest = new PassFieldTest();
/*     */         }
/*     */       
/*     */       }
/* 324 */       else if (iQueryResultList.size() == 1 && "ANY_ITEM".equals(((IDealFieldTest)iQueryResultList.get(0)).getField())) {
/* 325 */         PassFieldTest passFieldTest = new PassFieldTest();
/*     */       } else {
/*     */         
/* 328 */         Map<Integer, IFieldTest> fts = new TreeMap<>();
/* 329 */         for (IDealFieldTest xFieldTest : iQueryResultList) {
/* 330 */           String field = xFieldTest.getItemFieldName();
/* 331 */           String parameter = xFieldTest.getItemFieldParameter();
/*     */ 
/*     */           
/* 334 */           if (field == null) {
/* 335 */             logger_.error("Deal {} uses field test but doesn't specify field name.", dealId);
/* 336 */             return null;
/*     */           } 
/*     */           
/* 339 */           IMatchingRule matchRule = this._matchRuleFactory.createRule(xFieldTest.getMatchRule());
/*     */           
/* 341 */           IItemField<?> itemField = (IItemField)this._itemFields.get(field);
/* 342 */           if (itemField == null) {
/* 343 */             logger_.error("Deal {} uses unknown item field: {}.", dealId, field);
/* 344 */             return null;
/*     */           } 
/* 346 */           matchRule.setTarget1(itemField.parse(xFieldTest.getValue1()));
/* 347 */           matchRule.setTarget2(itemField.parse(xFieldTest.getValue2()));
/*     */           
/* 349 */           SimpleFieldTest ft = new SimpleFieldTest();
/* 350 */           ft.setField(field);
/* 351 */           ft.setParameter(parameter);
/* 352 */           ft.setMatchRule(matchRule);
/*     */           
/* 354 */           int conditionGroup = xFieldTest.getItemConditionGroup();
/* 355 */           if (fts.containsKey(Integer.valueOf(conditionGroup))) {
/* 356 */             fts.put(Integer.valueOf(conditionGroup), new AndFieldTest(fts.get(Integer.valueOf(conditionGroup)), (IFieldTest)ft));
/*     */             continue;
/*     */           } 
/* 359 */           fts.put(Integer.valueOf(conditionGroup), ft);
/*     */         } 
/*     */ 
/*     */         
/* 363 */         orFieldTest = new OrFieldTest(fts.values());
/*     */       } 
/* 365 */       pItemMatcher.setFieldTest((IFieldTest)orFieldTest);
/*     */       
/* 367 */       pItemMatchers.add(pItemMatcher);
/*     */     } 
/*     */     
/* 370 */     pricingDeal.setItemMatchers(pItemMatchers);
/*     */     
/* 372 */     return pricingDeal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<CompositeObject.TwoPiece<LocalTime, LocalTime>> translateEffectiveTimes(IDeal argDeal, Date argDate) {
/* 385 */     List<CompositeObject.TwoPiece<LocalTime, LocalTime>> ranges = new ArrayList<>();
/*     */     
/*     */     try {
/* 388 */       Map<String, Object> params = new HashMap<>();
/* 389 */       params.put("argDealId", argDeal.getDealId());
/* 390 */       params.put("argDayCode", Utils.getDayOfWeek(argDate));
/*     */       
/* 392 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(DEAL_TIMES_BY_DAY, params);
/*     */       
/* 394 */       for (IDealWeek schedule : iQueryResultList) {
/* 395 */         ranges.add(
/* 396 */             CompositeObject.make(getLocalTime(schedule.getStartTime()), getLocalTime(schedule.getEndTime())));
/*     */       }
/*     */     }
/* 399 */     catch (ObjectNotFoundException ex) {
/* 400 */       logger_.debug("No daily schedules for deal [" + argDeal + "] on [" + argDate + "].");
/*     */     }
/* 402 */     catch (Exception ex) {
/* 403 */       logger_.error("CAUGHT EXCEPTION: ", ex);
/*     */     } 
/* 405 */     return ranges;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\pricing\refresh\DtxRefreshStrategyBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */