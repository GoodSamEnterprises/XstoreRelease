/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.tax.ITaxRateRule;
/*     */ import dtv.xst.dao.tax.TaxGroupRuleId;
/*     */ import dtv.xst.dao.tax.impl.TaxAuthorityDAO;
/*     */ import dtv.xst.dao.tax.impl.TaxGroupDAO;
/*     */ import dtv.xst.dao.tax.impl.TaxGroupRuleDAO;
/*     */ import dtv.xst.dao.tax.impl.TaxLocationDAO;
/*     */ import dtv.xst.dao.tax.impl.TaxRateRuleDAO;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VATTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   private static final int FIELD_INDEX_ACTION = 1;
/*     */   private static final int FIELD_INDEX_VAT_REGION = 2;
/*     */   private static final int FIELD_INDEX_VAT_REGION_NAME = 3;
/*     */   private static final int FIELD_INDEX_VAT_CODE = 4;
/*     */   private static final int FIELD_INDEX_VAT_CODE_DESC = 5;
/*     */   private static final int FIELD_INDEX_ACTIVE_DATE = 6;
/*     */   private static final int FIELD_INDEX_VAT_RATE = 7;
/*  43 */   private static final IQueryKey<ITaxRateRule> TAX_RULE_RATES = (IQueryKey<ITaxRateRule>)new QueryKey("GET_TAX_RULE_RATES", ITaxRateRule.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String TAX_TYPE_CODE_VAT = "VAT";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String EXTERNAL_SYS_RMS = "RMS";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int VAT_RULE_SEQ_NUMBER = 1;
/*     */ 
/*     */   
/*  58 */   private TaxRateRuleCache _taxRateRuleCache = new TaxRateRuleCache();
/*     */ 
/*     */   
/*     */   private String _roundingCode;
/*     */ 
/*     */   
/*     */   private int _roundingDigitsQty;
/*     */   
/*     */   private boolean _taxAtTransLevel;
/*     */ 
/*     */   
/*     */   public VATTransformer(boolean taxAtTransLevel, String roundingCode, int roundingDigitsQty) {
/*  70 */     this._taxAtTransLevel = taxAtTransLevel;
/*  71 */     this._roundingCode = roundingCode;
/*  72 */     this._roundingDigitsQty = roundingDigitsQty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  79 */     List<IPersistable> persistables = new ArrayList<>(5);
/*     */     
/*  81 */     persistables.add(DataLoaderUtils.getDeleteByExternalSystemFromOrganizationPersistable("tax_tax_loc", "RMS"));
/*     */     
/*  83 */     persistables.add(DataLoaderUtils.getDeleteByExternalSystemFromOrganizationPersistable("tax_tax_authority", "RMS"));
/*     */     
/*  85 */     persistables.add(DataLoaderUtils.getDeleteByExternalSystemFromOrganizationPersistable("tax_tax_group", "RMS"));
/*     */     
/*  87 */     persistables.add(
/*  88 */         DataLoaderUtils.getDeleteByExternalSystemFromOrganizationPersistable("tax_tax_group_rule", "RMS"));
/*  89 */     persistables.add(DataLoaderUtils.getDeleteByExternalSystemFromOrganizationPersistable("tax_tax_rate_rule", "RMS"));
/*     */ 
/*     */     
/*  92 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/* 101 */     MOMFileLine line = argUnit.getData().get(0);
/* 102 */     ActionCode actionCode = validate(argMetaData, line);
/*     */     
/* 104 */     List<IPersistable> persistables = null;
/* 105 */     switch (actionCode) {
/*     */       case FULL:
/*     */       case VATCRE:
/* 108 */         persistables = insertVATRate(argMetaData, line);
/*     */         break;
/*     */       
/*     */       case VATMOD:
/* 112 */         persistables = updateVATRate(argMetaData, line);
/*     */         break;
/*     */       
/*     */       case VATDEL:
/* 116 */         persistables = deleteVATRate(argMetaData, line);
/*     */         break;
/*     */     } 
/* 119 */     return persistables;
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
/*     */   private List<IPersistable> deleteVATRate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 132 */     return this._taxRateRuleCache.deleteTaxRateRule(argMetaData, argLine);
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
/*     */   private IPersistable insertUpdateTaxAuthority(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 144 */     TaxAuthorityDAO dao = (TaxAuthorityDAO)getNewDAO("TaxAuthority", DaoState.INSERT_OR_UPDATE);
/* 145 */     String[] fields = argLine.getFields();
/*     */     
/* 147 */     dao.setOrgCode("*");
/* 148 */     dao.setOrgValue("*");
/* 149 */     dao.setTaxAuthorityId(fields[2]);
/* 150 */     dao.setName(StringUtils.nonEmpty(fields[3]));
/* 151 */     dao.setRoundingCode(this._roundingCode);
/* 152 */     dao.setRoundingDigitsQuantity(Integer.valueOf(this._roundingDigitsQty));
/* 153 */     dao.setExternalSystem("RMS");
/*     */     
/* 155 */     return (IPersistable)dao;
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
/*     */   private IPersistable insertUpdateTaxGroup(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 167 */     TaxGroupDAO dao = (TaxGroupDAO)getNewDAO("TaxGroup", DaoState.INSERT_OR_UPDATE);
/* 168 */     String[] fields = argLine.getFields();
/*     */     
/* 170 */     dao.setOrgCode("*");
/* 171 */     dao.setOrgValue("*");
/* 172 */     dao.setTaxGroupId(fields[4]);
/* 173 */     dao.setName(StringUtils.nonEmpty(fields[5]));
/* 174 */     dao.setDescription(StringUtils.nonEmpty(fields[5]));
/* 175 */     dao.setExternalSystem("RMS");
/*     */     
/* 177 */     return (IPersistable)dao;
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
/*     */   private IPersistable insertUpdateTaxGroupRule(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 189 */     TaxGroupRuleDAO dao = (TaxGroupRuleDAO)getNewDAO("TaxGroupRule", DaoState.INSERT_OR_UPDATE);
/* 190 */     String[] fields = argLine.getFields();
/*     */     
/* 192 */     dao.setOrgCode("*");
/* 193 */     dao.setOrgValue("*");
/* 194 */     dao.setTaxLocationId(fields[2]);
/* 195 */     dao.setTaxGroupId(fields[4]);
/* 196 */     dao.setTaxRuleSequence(Integer.valueOf(1));
/*     */     
/* 198 */     dao.setTaxAuthorityId(fields[2]);
/* 199 */     dao.setName(StringUtils.nonEmpty(fields[5]));
/* 200 */     dao.setTaxedAtTransLevel(Boolean.valueOf(this._taxAtTransLevel));
/* 201 */     dao.setTaxTypeCode("VAT");
/* 202 */     dao.setExternalSystem("RMS");
/*     */     
/* 204 */     return (IPersistable)dao;
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
/*     */   private IPersistable insertUpdateTaxLocation(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 216 */     TaxLocationDAO dao = (TaxLocationDAO)getNewDAO("TaxLocation", DaoState.INSERT_OR_UPDATE);
/* 217 */     String[] fields = argLine.getFields();
/*     */     
/* 219 */     dao.setOrgCode("*");
/* 220 */     dao.setOrgValue("*");
/* 221 */     dao.setTaxLocationId(fields[2]);
/* 222 */     dao.setName(StringUtils.nonEmpty(fields[3]));
/* 223 */     dao.setDescription(StringUtils.nonEmpty(fields[3]));
/* 224 */     dao.setExternalSystem("RMS");
/*     */     
/* 226 */     return (IPersistable)dao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IPersistable> insertVATRate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 237 */     List<IPersistable> persistables = new ArrayList<>(5);
/*     */     
/* 239 */     persistables.add(insertUpdateTaxLocation(argMetaData, argLine));
/* 240 */     persistables.add(insertUpdateTaxAuthority(argMetaData, argLine));
/* 241 */     persistables.add(insertUpdateTaxGroup(argMetaData, argLine));
/* 242 */     persistables.add(insertUpdateTaxGroupRule(argMetaData, argLine));
/* 243 */     persistables.addAll(this._taxRateRuleCache.insertTaxRateRule(argMetaData, argLine));
/*     */     
/* 245 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IPersistable> updateVATRate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 255 */     List<IPersistable> persistables = new ArrayList<>(5);
/*     */     
/* 257 */     persistables.add(insertUpdateTaxLocation(argMetaData, argLine));
/* 258 */     persistables.add(insertUpdateTaxAuthority(argMetaData, argLine));
/* 259 */     persistables.add(insertUpdateTaxGroup(argMetaData, argLine));
/* 260 */     persistables.add(insertUpdateTaxGroupRule(argMetaData, argLine));
/* 261 */     persistables.addAll(this._taxRateRuleCache.updateTaxRateRule(argMetaData, argLine));
/*     */     
/* 263 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ActionCode validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 274 */     String[] fields = argLine.getFields();
/* 275 */     ActionCode actionCode = null;
/*     */     
/* 277 */     if (fields.length != 8) {
/* 278 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/*     */     
/* 281 */     if (!"VAT".equals(fields[0])) {
/* 282 */       throw new DataFileException(buildTransformationMessage("Family must be 'VAT'", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 287 */       actionCode = ActionCode.valueOf(argLine.getFields()[1]);
/*     */     }
/* 289 */     catch (Exception e) {
/* 290 */       throw new DataFileException(buildTransformationMessage("Invalid action code", argMetaData, argLine));
/*     */     } 
/*     */ 
/*     */     
/* 294 */     if (argMetaData.getIsFullReload() && actionCode != ActionCode.FULL) {
/* 295 */       throw new DataFileException(
/* 296 */           buildTransformationMessage("Invalid action code for full reload", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/* 300 */     if (!argMetaData.getIsFullReload() && actionCode == ActionCode.FULL) {
/* 301 */       throw new DataFileException(
/* 302 */           buildTransformationMessage("Invalid action code for delta reload", argMetaData, argLine));
/*     */     }
/*     */     
/* 305 */     if (StringUtils.isEmpty(fields[2])) {
/* 306 */       throw new DataFileException(buildTransformationMessage("Missing VAT region", argMetaData, argLine));
/*     */     }
/*     */     
/* 309 */     if (StringUtils.isEmpty(fields[4])) {
/* 310 */       throw new DataFileException(buildTransformationMessage("Missing VAT code", argMetaData, argLine));
/*     */     }
/*     */     
/* 313 */     if (StringUtils.isEmpty(fields[6])) {
/* 314 */       throw new DataFileException(
/* 315 */           buildTransformationMessage("Missing VAT rate active date", argMetaData, argLine));
/*     */     }
/*     */     
/* 318 */     if (StringUtils.isEmpty(fields[7]) && actionCode != ActionCode.VATDEL) {
/* 319 */       throw new DataFileException(buildTransformationMessage("Missing VAT rate", argMetaData, argLine));
/*     */     }
/*     */     
/* 322 */     return actionCode;
/*     */   }
/*     */   
/*     */   private enum ActionCode
/*     */   {
/* 327 */     FULL, VATCRE, VATDEL, VATMOD;
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
/*     */   private class TaxRateRuleCache
/*     */   {
/* 343 */     private Map<TaxGroupRuleId, List<ITaxRateRule>> _cache = new HashMap<>();
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
/*     */     public List<IPersistable> deleteTaxRateRule(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 356 */       List<ITaxRateRule> taxRateRulesToDelete = new ArrayList<>();
/* 357 */       ITaxRateRule prevTaxRateRule = null;
/*     */       
/* 359 */       String[] fields = argLine.getFields();
/* 360 */       Date effectiveDate = VATTransformer.this.parseRMSDate(fields[6]);
/*     */ 
/*     */       
/* 363 */       TaxGroupRuleId cacheKey = getCacheKey(fields);
/* 364 */       List<ITaxRateRule> taxRateRules = getTaxRateRules(cacheKey, argMetaData.getIsFullReload());
/*     */ 
/*     */       
/* 367 */       for (int i = 0; i < taxRateRules.size(); i++) {
/* 368 */         ITaxRateRule taxRateRule = taxRateRules.get(i);
/* 369 */         if (effectiveDate.equals(taxRateRule.getEffectiveDatetimestamp())) {
/* 370 */           taxRateRulesToDelete.add(taxRateRule);
/*     */ 
/*     */           
/* 373 */           if (i > 0 && effectiveDate.after(((ITaxRateRule)taxRateRules.get(i - 1)).getEffectiveDatetimestamp())) {
/* 374 */             prevTaxRateRule = taxRateRules.get(i - 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 381 */       if (prevTaxRateRule != null) {
/* 382 */         ITaxRateRule taxRateRule = taxRateRulesToDelete.get(taxRateRulesToDelete.size() - 1);
/* 383 */         prevTaxRateRule.setExpirationDatetimestamp(taxRateRule.getExpirationDatetimestamp());
/*     */       } 
/*     */ 
/*     */       
/* 387 */       taxRateRules.removeAll(taxRateRulesToDelete);
/*     */ 
/*     */ 
/*     */       
/* 391 */       List<IPersistable> result = generateTaxRateRulesPersistable(taxRateRulesToDelete, DaoState.DELETED);
/* 392 */       result.addAll(generateTaxRateRulePersistable(prevTaxRateRule, DaoState.UPDATED));
/* 393 */       return result;
/*     */     }
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
/*     */     public List<IPersistable> insertTaxRateRule(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 406 */       String[] fields = argLine.getFields();
/*     */ 
/*     */       
/* 409 */       TaxGroupRuleId cacheKey = getCacheKey(fields);
/* 410 */       List<ITaxRateRule> taxRateRules = getTaxRateRules(cacheKey, argMetaData.getIsFullReload());
/*     */ 
/*     */       
/* 413 */       int taxRateRuleSequence = getNextTaxRateRuleSequence(cacheKey, argMetaData.getIsFullReload());
/* 414 */       ITaxRateRule taxRateRule = createNewTaxRateRule(taxRateRuleSequence, fields);
/* 415 */       taxRateRules.add(taxRateRule);
/*     */ 
/*     */       
/* 418 */       ITaxRateRule[] sortedTaxRateRules = taxRateRules.<ITaxRateRule>toArray(new ITaxRateRule[0]);
/* 419 */       Arrays.sort(sortedTaxRateRules, new EffectiveDateComparator());
/* 420 */       taxRateRules = new ArrayList<>();
/* 421 */       taxRateRules.addAll(Arrays.asList(sortedTaxRateRules));
/* 422 */       this._cache.put(cacheKey, taxRateRules);
/*     */ 
/*     */       
/* 425 */       ITaxRateRule prevTaxRateRule = null;
/* 426 */       for (int i = 0; i < sortedTaxRateRules.length; i++) {
/* 427 */         if (taxRateRuleSequence == sortedTaxRateRules[i].getTaxRateRuleSequence()) {
/*     */ 
/*     */           
/* 430 */           if (sortedTaxRateRules.length > i + 1) {
/* 431 */             Calendar expirationDate = Calendar.getInstance();
/* 432 */             expirationDate
/* 433 */               .setTimeInMillis(sortedTaxRateRules[i + 1].getEffectiveDatetimestamp().getTime() - 1L);
/* 434 */             taxRateRule.setExpirationDatetimestamp(expirationDate.getTime());
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 439 */           if (i > 0) {
/* 440 */             Calendar expirationDate = Calendar.getInstance();
/* 441 */             expirationDate.setTimeInMillis(taxRateRule.getEffectiveDatetimestamp().getTime() - 1L);
/* 442 */             prevTaxRateRule = sortedTaxRateRules[i - 1];
/* 443 */             prevTaxRateRule.setExpirationDatetimestamp(expirationDate.getTime());
/*     */           } 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 451 */       List<IPersistable> result = generateTaxRateRulePersistable(taxRateRule, DaoState.INSERT_ONLY);
/* 452 */       result.addAll(generateTaxRateRulePersistable(prevTaxRateRule, DaoState.UPDATED));
/* 453 */       return result;
/*     */     }
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
/*     */     public List<IPersistable> updateTaxRateRule(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 466 */       List<ITaxRateRule> taxRateRulesToUpdate = new ArrayList<>();
/*     */       
/* 468 */       String[] fields = argLine.getFields();
/* 469 */       BigDecimal percent = (new BigDecimal(fields[7])).movePointLeft(2);
/* 470 */       Date effectiveDate = VATTransformer.this.parseRMSDate(fields[6]);
/*     */ 
/*     */       
/* 473 */       TaxGroupRuleId cacheKey = getCacheKey(fields);
/* 474 */       List<ITaxRateRule> taxRateRules = getTaxRateRules(cacheKey, argMetaData.getIsFullReload());
/*     */ 
/*     */       
/* 477 */       for (int i = 0; i < taxRateRules.size(); i++) {
/* 478 */         ITaxRateRule taxRateRule = taxRateRules.get(i);
/* 479 */         if (effectiveDate.equals(taxRateRule.getEffectiveDatetimestamp())) {
/* 480 */           taxRateRule.setPercent(percent);
/* 481 */           taxRateRulesToUpdate.add(taxRateRule);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 486 */       if (taxRateRulesToUpdate.size() == 0) {
/* 487 */         return insertTaxRateRule(argMetaData, argLine);
/*     */       }
/*     */ 
/*     */       
/* 491 */       return generateTaxRateRulesPersistable(taxRateRulesToUpdate, DaoState.UPDATED);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ITaxRateRule createNewTaxRateRule(int taxRateRuleSequence, String[] argFields) {
/* 501 */       ITaxRateRule taxRateRule = (ITaxRateRule)DataFactory.createObject(ITaxRateRule.class);
/*     */       
/* 503 */       taxRateRule.setOrgCode("*");
/* 504 */       taxRateRule.setOrgValue("*");
/* 505 */       taxRateRule.setTaxLocationId(argFields[2]);
/* 506 */       taxRateRule.setTaxGroupId(argFields[4]);
/* 507 */       taxRateRule.setTaxRuleSequence(1);
/* 508 */       taxRateRule.setTaxRateRuleSequence(taxRateRuleSequence);
/*     */       
/* 510 */       BigDecimal percent = (new BigDecimal(argFields[7])).movePointLeft(2);
/* 511 */       taxRateRule.setPercent(percent);
/*     */       
/* 513 */       Date effectiveDate = VATTransformer.this.parseRMSDate(argFields[6]);
/* 514 */       taxRateRule.setEffectiveDatetimestamp(effectiveDate);
/*     */       
/* 516 */       taxRateRule.setExternalSystem("RMS");
/*     */       
/* 518 */       return taxRateRule;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<IPersistable> generateTaxRateRulePersistable(ITaxRateRule taxRateRule, DaoState daoState) {
/* 528 */       List<ITaxRateRule> taxRateRules = new ArrayList<>();
/* 529 */       if (taxRateRule != null) {
/* 530 */         taxRateRules.add(taxRateRule);
/*     */       }
/*     */       
/* 533 */       return generateTaxRateRulesPersistable(taxRateRules, daoState);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<IPersistable> generateTaxRateRulesPersistable(List<ITaxRateRule> taxRateRules, DaoState daoState) {
/* 544 */       List<IPersistable> persistables = new ArrayList<>();
/* 545 */       TaxRateRuleDAO dao = null;
/* 546 */       for (ITaxRateRule taxRateRule : taxRateRules) {
/* 547 */         dao = (TaxRateRuleDAO)VATTransformer.this.getNewDAO("TaxRateRule", daoState);
/* 548 */         dao.setOrgCode(taxRateRule.getOrgCode());
/* 549 */         dao.setOrgValue(taxRateRule.getOrgValue());
/* 550 */         dao.setTaxLocationId(taxRateRule.getTaxLocationId());
/* 551 */         dao.setTaxGroupId(taxRateRule.getTaxGroupId());
/* 552 */         dao.setTaxRuleSequence(Integer.valueOf(taxRateRule.getTaxRuleSequence()));
/* 553 */         dao.setTaxRateRuleSequence(Integer.valueOf(taxRateRule.getTaxRateRuleSequence()));
/* 554 */         dao.setPercent(taxRateRule.getPercent());
/* 555 */         dao.setEffectiveDatetimestamp(taxRateRule.getEffectiveDatetimestamp());
/* 556 */         dao.setExpirationDatetimestamp(taxRateRule.getExpirationDatetimestamp());
/* 557 */         dao.setExternalSystem(taxRateRule.getExternalSystem());
/* 558 */         persistables.add(dao);
/*     */       } 
/*     */       
/* 561 */       return persistables;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private TaxGroupRuleId getCacheKey(String[] argFields) {
/* 570 */       TaxGroupRuleId cacheKey = new TaxGroupRuleId();
/* 571 */       cacheKey.setOrganizationId(Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 572 */       cacheKey.setTaxLocationId(argFields[2]);
/* 573 */       cacheKey.setTaxGroupId(argFields[4]);
/* 574 */       cacheKey.setTaxRuleSequence(Integer.valueOf(1));
/*     */       
/* 576 */       return cacheKey;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int getNextTaxRateRuleSequence(TaxGroupRuleId key, boolean isFullReload) {
/* 586 */       List<ITaxRateRule> taxRateRules = getTaxRateRules(key, isFullReload);
/*     */ 
/*     */       
/* 589 */       int taxRateRuleSequence = 0;
/* 590 */       for (ITaxRateRule taxRateRule : taxRateRules) {
/* 591 */         if (taxRateRule.getTaxRateRuleSequence() > taxRateRuleSequence) {
/* 592 */           taxRateRuleSequence = taxRateRule.getTaxRateRuleSequence();
/*     */         }
/*     */       } 
/* 595 */       return ++taxRateRuleSequence;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<ITaxRateRule> getTaxRateRules(TaxGroupRuleId key, boolean isFullReload) {
/* 605 */       List<ITaxRateRule> taxRateRules = this._cache.get(key);
/* 606 */       if (taxRateRules == null) {
/* 607 */         if (isFullReload) {
/*     */           
/* 609 */           taxRateRules = new ArrayList<>();
/*     */         } else {
/*     */           
/* 612 */           taxRateRules = loadTaxRateRules(key);
/*     */         } 
/* 614 */         this._cache.put(key, taxRateRules);
/*     */       } 
/*     */       
/* 617 */       return taxRateRules;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<ITaxRateRule> loadTaxRateRules(TaxGroupRuleId key) {
/* 627 */       Map<String, Object> paramMap = new HashMap<>();
/* 628 */       paramMap.put("argLocationId", key.getTaxLocationId());
/* 629 */       paramMap.put("argTaxGroupId", key.getTaxGroupId());
/* 630 */       paramMap.put("argRuleSeq", key.getTaxRuleSequence());
/* 631 */       paramMap.put("argOrganizationId", key.getOrganizationId());
/*     */       
/* 633 */       return (List<ITaxRateRule>)DataFactory.getObjectByQueryNoThrow(VATTransformer.TAX_RULE_RATES, paramMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private TaxRateRuleCache() {}
/*     */ 
/*     */ 
/*     */     
/*     */     private class EffectiveDateComparator
/*     */       implements Comparator<ITaxRateRule>
/*     */     {
/*     */       private EffectiveDateComparator() {}
/*     */ 
/*     */ 
/*     */       
/*     */       public int compare(ITaxRateRule argO1, ITaxRateRule argO2) {
/* 651 */         int result = argO1.getEffectiveDatetimestamp().compareTo(argO2.getEffectiveDatetimestamp());
/* 652 */         if (result == 0) {
/* 653 */           result = Integer.compare(argO1.getTaxRateRuleSequence(), argO2.getTaxRateRuleSequence());
/*     */         }
/* 655 */         return result;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\VATTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */