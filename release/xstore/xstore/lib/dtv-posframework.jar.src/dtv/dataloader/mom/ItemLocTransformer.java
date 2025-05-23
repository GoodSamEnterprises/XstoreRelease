/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.pos.common.PriceTypes;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.com.impl.DatabaseTranslationDAO;
/*     */ import dtv.xst.dao.itm.ItemAvailabilityCode;
/*     */ import dtv.xst.dao.itm.impl.ItemOptionsDAO;
/*     */ import dtv.xst.dao.itm.impl.ItemPricesDAO;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class ItemLocTransformer
/*     */   extends AbstractItemTransformer
/*     */ {
/*  36 */   private static final Logger _logger = Logger.getLogger(ItemLocTransformer.class);
/*     */   
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   
/*     */   private static final int FIELD_INDEX_TYPE = 1;
/*     */   
/*     */   private static final int FIELD_INDEX_LOCTYPE = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_LOCATION = 3;
/*     */   
/*     */   private static final int FIELD_INDEX_ITEM = 4;
/*     */   
/*     */   private static final int FIELD_INDEX_SELLINGUNITRETAIL = 8;
/*     */   
/*     */   private static final int FIELD_INDEX_SELLINGUOM = 10;
/*     */   
/*     */   private static final int FIELD_INDEX_TAXABLEIND = 11;
/*     */   
/*     */   private static final int FIELD_INDEX_LOCALITEMDESC = 12;
/*     */   
/*     */   private static final int FIELD_INDEX_STATUS = 17;
/*     */   
/*     */   private static final int FIELD_INDEX_UINTYPE = 30;
/*     */   
/*     */   private static final int FIELD_INDEX_QTYKEYOPTIONS = 38;
/*     */   
/*     */   private static final int FIELD_INDEX_MANUALPRICEENTRY = 39;
/*     */   
/*     */   private static final int FIELD_INDEX_FOODSTAMPIND = 41;
/*     */   
/*     */   private static final int FIELD_INDEX_FIXEDTAREVALUE = 44;
/*     */   private static final int FIELD_INDEX_FIXEDTAREUOM = 45;
/*     */   private static final int FIELD_INDEX_STOPSALEIND = 49;
/*     */   private static final int FIELD_INDEX_RETURNABLEIND = 61;
/*     */   private static final int FIELD_INDEX_MERCHANDISE_IND = 64;
/*     */   private String nonTaxableTaxGroupId;
/*     */   private boolean translateItemDescriptionEnabled = false;
/*     */   
/*     */   public String getNonTaxableTaxGroupId() {
/*  75 */     return this.nonTaxableTaxGroupId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTranslateItemDescriptionEnabled() {
/*  83 */     return this.translateItemDescriptionEnabled;
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
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  96 */     List<IPersistable> persistables = new ArrayList<>(2);
/*     */     
/*  98 */     persistables.add(getDeleteByExternalSystemPersistable("itm_item_options", "RMS", "STORE", ((MOMFileConfiguration)argMetaData
/*  99 */           .getConfigObject()).getStoreId()));
/*     */     
/* 101 */     persistables.add(getDeleteByExternalSystemPersistable("itm_item_prices", "RMS", "STORE", ((MOMFileConfiguration)argMetaData
/* 102 */           .getConfigObject()).getStoreId()));
/*     */     
/* 104 */     if (isTranslateItemDescriptionEnabled()) {
/* 105 */       persistables.add(getDeleteByExternalSystemPersistable("com_translations", "RMS"));
/*     */     }
/*     */ 
/*     */     
/* 109 */     Map<String, Object> params = new HashMap<>(6);
/* 110 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 111 */     params.put("argUpdateUserId", "DATALOADER");
/* 112 */     params.put("argUpdateDate", new Date());
/* 113 */     params.put("argOrgCode", "*");
/* 114 */     params.put("argOrgValue", "*");
/* 115 */     params.put("argExternalSystem", "RMS");
/* 116 */     persistables.add(new QueryRequest("CLEAR_ALL_SERIALIZED_ITEM_FLAGS", params));
/*     */     
/* 118 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNonTaxableTaxGroupId(String argNonTaxableTaxGroupId) {
/* 126 */     this.nonTaxableTaxGroupId = argNonTaxableTaxGroupId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTranslateItemDescriptionEnabled(boolean argTranslatedItemDescriptionEnabled) {
/* 134 */     this.translateItemDescriptionEnabled = argTranslatedItemDescriptionEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/* 142 */     if (_logger.isDebugEnabled()) {
/* 143 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/* 146 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/* 148 */     MOMFileLine line = argUnit.getData().get(0);
/*     */     
/* 150 */     validate(argMetaData, line);
/*     */     
/* 152 */     if ("N".equals(line.getFields()[64]))
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */       
/* 158 */       _logger.info("Skipping record because merchandiseInd='N':" + line.getFileLine()); }
/*     */     else
/* 160 */     { if ("S".equals(line.getFields()[2]))
/*     */       { ItemOptionsDAO itemOptionsDao;
/*     */         
/* 163 */         switch (line.getFields()[1])
/*     */         
/*     */         { case "FULLITEMLOC":
/* 166 */             if (!argMetaData.getIsFullReload()) {
/* 167 */               throw new DataFileException(buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */             }
/*     */ 
/*     */ 
/*     */           
/*     */           case "ITEMLOCCRE":
/* 173 */             itemOptionsDao = (ItemOptionsDAO)getNewDAO("ItemOptions", DaoState.INSERT_ONLY);
/* 174 */             populateItemOptionsDAO(line, itemOptionsDao);
/* 175 */             persistables.add(itemOptionsDao);
/*     */             
/* 177 */             if (isTranslateItemDescriptionEnabled()) {
/*     */ 
/*     */               
/* 180 */               DatabaseTranslationDAO descTranslationDao = getDescriptionTranslationDao(line.getFields()[3], line
/* 181 */                   .getFields()[4], line.getFields()[12], DaoState.INSERT_ONLY);
/*     */               
/* 183 */               persistables.add(descTranslationDao);
/*     */             } 
/*     */             
/* 186 */             if (!StringUtils.isEmpty(line.getFields()[8])) {
/*     */ 
/*     */               
/* 189 */               ItemPricesDAO itemPriceDAO = getSellingPriceDao(line);
/* 190 */               persistables.add(itemPriceDAO);
/*     */             } 
/* 192 */             if (!StringUtils.isEmpty(line.getFields()[30])) {
/*     */ 
/*     */               
/* 195 */               QueryRequest request = createQueryRequestForUpdateSerializedItemFlag(line.getFields()[4], "*", "*", true);
/*     */               
/* 197 */               persistables.add(request);
/*     */             }
/*     */             else {
/*     */               
/* 201 */               QueryRequest request = createQueryRequestForUpdateSerializedItemFlag(line.getFields()[4], "*", "*", false);
/*     */               
/* 203 */               persistables.add(request);
/*     */             } 
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
/*     */             
/* 278 */             return persistables;case "ITEMLOCMOD": if ("N".equals(line.getFields()[11])) { QueryRequest updateTaxGroupIdRequest = createQueryRequestForUpdateTaxGroupID(getNonTaxableTaxGroupId(), line.getFields()[4], "STORE", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId()); persistables.add(updateTaxGroupIdRequest); } else { QueryRequest updateItemOptionsRequest = createQueryRequestForUpdateItemOptions(line, "STORE", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId()); persistables.add(updateItemOptionsRequest); }  if (isTranslateItemDescriptionEnabled()) { DatabaseTranslationDAO descTranslationDao = getDescriptionTranslationDao(line.getFields()[3], line.getFields()[4], line.getFields()[12], DaoState.INSERT_OR_UPDATE); persistables.add(descTranslationDao); }  if (!StringUtils.isEmpty(line.getFields()[30])) { QueryRequest updateSerializedItemFlagRequest = createQueryRequestForUpdateSerializedItemFlag(line.getFields()[4], "*", "*", true); persistables.add(updateSerializedItemFlagRequest); } else { QueryRequest request = createQueryRequestForUpdateSerializedItemFlag(line.getFields()[4], "*", "*", false); persistables.add(request); }  return persistables;case "ITEMLOCDEL": itemOptionsDao = (ItemOptionsDAO)getNewDAO("ItemOptions", DaoState.DELETED); itemOptionsDao.setItemId(line.getFields()[4]); itemOptionsDao.setExternalSystem("RMS"); itemOptionsDao.setLevelCode("STORE"); itemOptionsDao.setLevelValue(line.getFields()[3]); persistables.add(itemOptionsDao); if (isTranslateItemDescriptionEnabled()) { DatabaseTranslationDAO descTranslationDao = getDescriptionTranslationDao(line.getFields()[3], line.getFields()[4], line.getFields()[12], DaoState.DELETED); persistables.add(descTranslationDao); }  return persistables; }  throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line)); }  _logger.info("Skipped non-store record: " + line.getFileLine()); }  return persistables;
/*     */   }
/*     */   
/*     */   protected String getLevelCode(String argLocation) {
/* 282 */     return isCorporate(argLocation) ? "*" : "STORE";
/*     */   }
/*     */   
/*     */   protected String getLevelValue(String argLocation) {
/* 286 */     return isCorporate(argLocation) ? "*" : argLocation;
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
/*     */   private QueryRequest createQueryRequestForUpdateItemOptions(MOMFileLine argLine, String argOrgCode, String argOrgValue) {
/* 298 */     Map<String, Object> parms = new HashMap<>(4);
/*     */ 
/*     */     
/* 301 */     parms.put("argUnitOfMeasureCode", StringUtils.nonEmpty(argLine.getFields()[10]));
/* 302 */     parms.put("argPromptForQuantity", Boolean.valueOf("R".equals(argLine.getFields()[38])));
/* 303 */     parms.put("argForceQuantityOfOne", Boolean.valueOf("P".equals(argLine.getFields()[38])));
/* 304 */     parms.put("argPromptForPrice", Boolean.valueOf("R".equals(argLine.getFields()[39])));
/* 305 */     parms.put("argFoodStampEligible", Boolean.valueOf("Y".equals(argLine.getFields()[41])));
/* 306 */     parms.put("argTareValue", StringUtils.nonEmpty(argLine.getFields()[44]));
/* 307 */     parms.put("argTareUnitOfMeasureCode", StringUtils.nonEmpty(argLine.getFields()[45]));
/* 308 */     parms.put("argNotReturnable", Boolean.valueOf("N".equals(argLine.getFields()[61])));
/*     */     
/* 310 */     if ("Y".equals(argLine.getFields()[49])) {
/*     */       
/* 312 */       parms.put("argItemAvailabilityCode", ItemAvailabilityCode.RECALL.getName());
/* 313 */       parms.put("argStockStatus", null);
/*     */     } else {
/*     */       String str; QueryRequest request;
/* 316 */       switch (argLine.getFields()[17]) {
/*     */         case "A":
/* 318 */           parms.put("argItemAvailabilityCode", ItemAvailabilityCode.AVAILABLE.getName());
/* 319 */           parms.put("argStockStatus", null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 338 */           parms.put("argExternalSystem", "RMS");
/*     */           
/* 340 */           parms.put("argUpdateDate", new Date());
/* 341 */           parms.put("argUpdateUserId", "DATALOADER");
/*     */ 
/*     */           
/* 344 */           parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 345 */           parms.put("argItemId", argLine.getFields()[4]);
/* 346 */           parms.put("argLevelCode", argOrgCode);
/* 347 */           parms.put("argLevelValue", argOrgValue);
/*     */           
/* 349 */           request = new QueryRequest("UPDATE_ITEM_OPTIONS", parms);
/*     */           
/* 351 */           return request;case "C": parms.put("argItemAvailabilityCode", ItemAvailabilityCode.AVAILABLE.getName()); parms.put("argStockStatus", "DISCONTINUED"); parms.put("argExternalSystem", "RMS"); parms.put("argUpdateDate", new Date()); parms.put("argUpdateUserId", "DATALOADER"); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); parms.put("argItemId", argLine.getFields()[4]); parms.put("argLevelCode", argOrgCode); parms.put("argLevelValue", argOrgValue); request = new QueryRequest("UPDATE_ITEM_OPTIONS", parms); return request;case "I": case "D": parms.put("argItemAvailabilityCode", ItemAvailabilityCode.NA.getName()); parms.put("argStockStatus", null); parms.put("argExternalSystem", "RMS"); parms.put("argUpdateDate", new Date()); parms.put("argUpdateUserId", "DATALOADER"); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); parms.put("argItemId", argLine.getFields()[4]); parms.put("argLevelCode", argOrgCode); parms.put("argLevelValue", argOrgValue); request = new QueryRequest("UPDATE_ITEM_OPTIONS", parms); return request;
/*     */       } 
/*     */       parms.put("argItemAvailabilityCode", null);
/*     */       parms.put("argStockStatus", null);
/*     */     } 
/*     */     parms.put("argExternalSystem", "RMS");
/*     */     parms.put("argUpdateDate", new Date());
/*     */     parms.put("argUpdateUserId", "DATALOADER");
/*     */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*     */     parms.put("argItemId", argLine.getFields()[4]);
/*     */     parms.put("argLevelCode", argOrgCode);
/*     */     parms.put("argLevelValue", argOrgValue);
/*     */     return new QueryRequest("UPDATE_ITEM_OPTIONS", parms);
/*     */   } private QueryRequest createQueryRequestForUpdateSerializedItemFlag(String argItemId, String argOrgCode, String argOrgValue, boolean argSerializedItemFlag) throws DataFileException {
/* 365 */     Map<String, Object> parms = new HashMap<>(4);
/*     */ 
/*     */     
/* 368 */     parms.put("argSerializedItemFlag", Integer.valueOf(argSerializedItemFlag ? 1 : 0));
/* 369 */     parms.put("argUpdateUserId", "DATALOADER");
/* 370 */     parms.put("argUpdateDate", new Date());
/*     */ 
/*     */     
/* 373 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 374 */     parms.put("argOrgCode", argOrgCode);
/* 375 */     parms.put("argOrgValue", argOrgValue);
/*     */ 
/*     */ 
/*     */     
/* 379 */     if (StringUtils.isEmpty(argItemId)) {
/* 380 */       parms.put("argExternalSystem", "RMS");
/*     */     } else {
/*     */       
/* 383 */       parms.put("argItemId", argItemId);
/*     */     } 
/*     */     
/* 386 */     QueryRequest queryRequest = new QueryRequest("UPDATE_SERIALIZED_ITEM_FLAG", parms);
/*     */     
/* 388 */     return queryRequest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemPricesDAO getSellingPriceDao(MOMFileLine argLine) {
/* 399 */     ItemPricesDAO itemPriceDAO = (ItemPricesDAO)getNewDAO("ItemPrices", DaoState.INSERT_ONLY);
/* 400 */     itemPriceDAO.setLevelCode("STORE");
/* 401 */     itemPriceDAO.setLevelValue(argLine.getFields()[3]);
/* 402 */     itemPriceDAO.setPrice(new BigDecimal(argLine.getFields()[8]));
/* 403 */     itemPriceDAO.setExternalSystem("RMS");
/* 404 */     itemPriceDAO.setItemId(argLine.getFields()[4]);
/* 405 */     itemPriceDAO.setPricingQuantity(BigDecimal.ONE);
/* 406 */     itemPriceDAO.setItemPricePropertyCode(PriceTypes.REGULAR_PRICE.name());
/*     */     
/* 408 */     GregorianCalendar currentTime = new GregorianCalendar();
/*     */ 
/*     */     
/* 411 */     GregorianCalendar beginningTimeOfTheDay = new GregorianCalendar(currentTime.get(1), currentTime.get(2), currentTime.get(5));
/* 412 */     itemPriceDAO.setEffectiveDate(beginningTimeOfTheDay.getTime());
/* 413 */     return itemPriceDAO;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void populateItemOptionsDAO(MOMFileLine argLine, ItemOptionsDAO argOptionsDao) {
/* 423 */     argOptionsDao.setItemId(argLine.getFields()[4]);
/* 424 */     argOptionsDao.setUnitOfMeasureCode(StringUtils.nonEmpty(argLine.getFields()[10]));
/* 425 */     argOptionsDao.setPromptForQuantity(Boolean.valueOf("R".equals(argLine.getFields()[38])));
/* 426 */     argOptionsDao.setForceQuantityOfOne(Boolean.valueOf("P".equals(argLine.getFields()[38])));
/* 427 */     argOptionsDao.setPromptForPrice(Boolean.valueOf("R".equals(argLine.getFields()[39])));
/* 428 */     argOptionsDao.setFoodStampEligible(Boolean.valueOf("Y".equals(argLine.getFields()[41])));
/* 429 */     argOptionsDao.setNotReturnable(Boolean.valueOf("N".equals(argLine.getFields()[61])));
/*     */     
/* 431 */     if (!StringUtils.isEmpty(argLine.getFields()[44])) {
/* 432 */       argOptionsDao.setTareValue(new BigDecimal(argLine.getFields()[44]));
/*     */     }
/*     */     
/* 435 */     if (!StringUtils.isEmpty(argLine.getFields()[45])) {
/* 436 */       argOptionsDao.setTareUnitOfMeasureCode(argLine.getFields()[45]);
/*     */     }
/*     */     
/* 439 */     if ("N".equals(argLine.getFields()[11]))
/*     */     {
/* 441 */       argOptionsDao.setTaxGroupId(getNonTaxableTaxGroupId());
/*     */     }
/*     */     
/* 444 */     if ("Y".equals(argLine.getFields()[49])) {
/*     */       
/* 446 */       argOptionsDao.setItemAvailabilityCode(ItemAvailabilityCode.RECALL.getName());
/*     */     }
/*     */     else {
/*     */       
/* 450 */       switch (argLine.getFields()[17]) {
/*     */         case "A":
/* 452 */           argOptionsDao.setItemAvailabilityCode(ItemAvailabilityCode.AVAILABLE.getName());
/*     */           break;
/*     */         
/*     */         case "C":
/* 456 */           argOptionsDao.setItemAvailabilityCode(ItemAvailabilityCode.AVAILABLE.getName());
/* 457 */           argOptionsDao.setStockStatus("DISCONTINUED");
/*     */           break;
/*     */         
/*     */         case "I":
/*     */         case "D":
/* 462 */           argOptionsDao.setItemAvailabilityCode(ItemAvailabilityCode.NA.getName());
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 467 */     argOptionsDao.setExternalSystem("RMS");
/* 468 */     argOptionsDao.setLevelCode(getLevelCode(argLine.getFields()[3]));
/* 469 */     argOptionsDao.setLevelValue(getLevelValue(argLine.getFields()[3]));
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
/*     */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 481 */     String[] fields = argLine.getFields();
/*     */     
/* 483 */     if (fields.length != 65) {
/* 484 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/*     */     
/* 487 */     if (!"ITEMLOC".equals(fields[0])) {
/* 488 */       throw new DataFileException(buildTransformationMessage("Family must be 'ITEMS'", argMetaData, argLine));
/*     */     }
/*     */     
/* 491 */     if (StringUtils.isEmpty(fields[2])) {
/* 492 */       throw new DataFileException(buildTransformationMessage("Missing LocType", argMetaData, argLine));
/*     */     }
/*     */     
/* 495 */     if (StringUtils.isEmpty(fields[3])) {
/* 496 */       throw new DataFileException(buildTransformationMessage("Missing Location", argMetaData, argLine));
/*     */     }
/*     */     
/* 499 */     if (StringUtils.isEmpty(fields[4])) {
/* 500 */       throw new DataFileException(buildTransformationMessage("Missing Item", argMetaData, argLine));
/*     */     }
/* 502 */     if (StringUtils.isEmpty(fields[64])) {
/* 503 */       throw new DataFileException(buildTransformationMessage("Missing MerchandiseInd", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/* 507 */     if (!"ITEMLOCDEL".equals(argLine.getFields()[1])) {
/* 508 */       if (StringUtils.isEmpty(fields[12])) {
/* 509 */         throw new DataFileException(buildTransformationMessage("Missing LocalItemDesc", argMetaData, argLine));
/*     */       }
/*     */       
/* 512 */       if (StringUtils.isEmpty(fields[11])) {
/* 513 */         throw new DataFileException(buildTransformationMessage("Missing TaxableInd", argMetaData, argLine));
/*     */       }
/*     */       
/* 516 */       if (StringUtils.isEmpty(fields[17]))
/* 517 */         throw new DataFileException(buildTransformationMessage("Missing Status", argMetaData, argLine)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\ItemLocTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */