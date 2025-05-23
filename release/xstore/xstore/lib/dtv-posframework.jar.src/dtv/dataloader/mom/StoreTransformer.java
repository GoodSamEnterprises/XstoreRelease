/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.loc.impl.RetailLocationDAO;
/*     */ import dtv.xst.dao.tax.impl.RetailLocationTaxMappingDAO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ public class StoreTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   private static final int FIELD_INDEX_ACTION = 1;
/*     */   private static final int FIELD_INDEX_STORE_ID = 2;
/*     */   private static final int FIELD_INDEX_STORE_NAME = 3;
/*     */   private static final int FIELD_INDEX_STORE_NAME_10 = 4;
/*     */   private static final int FIELD_INDEX_MANAGER = 9;
/*     */   private static final int FIELD_INDEX_FAX_NUMBER = 14;
/*     */   private static final int FIELD_INDEX_PHONE_NUMBER = 15;
/*     */   private static final int FIELD_INDEX_EMAIL = 16;
/*     */   private static final int FIELD_INDEX_VAT_REGION = 20;
/*     */   private static final int FIELD_INDEX_CURRENCY_CODE = 33;
/*     */   private static final int FIELD_INDEX_LOCALE = 34;
/*  46 */   private static final Logger _logger = Logger.getLogger(StoreTransformer.class);
/*     */   
/*  48 */   private String _locationType = null;
/*     */   
/*  50 */   private boolean _useTillAccountability = Boolean.FALSE.booleanValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationType() {
/*  57 */     return this._locationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUseTillAccountability() {
/*  65 */     return this._useTillAccountability;
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
/*  78 */     List<IPersistable> persistables = new ArrayList<>(1);
/*  79 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("tax_rtl_loc_tax_mapping"));
/*  80 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("loc_rtl_loc"));
/*     */     
/*  82 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocationType(String argLocationType) {
/*  90 */     this._locationType = argLocationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUseTillAccountability(boolean argUseTillAccountability) {
/*  98 */     this._useTillAccountability = argUseTillAccountability;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*     */     RetailLocationDAO dao;
/*     */     RetailLocationTaxMappingDAO taxMappingDao;
/*     */     QueryRequest updateStoreRequest;
/* 106 */     if (_logger.isDebugEnabled()) {
/* 107 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/* 110 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/* 112 */     MOMFileLine line = argUnit.getData().get(0);
/*     */     
/* 114 */     validate(argMetaData, line);
/*     */ 
/*     */     
/* 117 */     switch (line.getFields()[1]) {
/*     */       
/*     */       case "FULL":
/* 120 */         if (!argMetaData.getIsFullReload()) {
/* 121 */           throw new DataFileException(
/* 122 */               buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */         }
/*     */       
/*     */       case "STORECRE":
/* 126 */         dao = (RetailLocationDAO)getNewDAO("RetailLocation", DaoState.INSERT_ONLY);
/* 127 */         populateDAO(argMetaData, line, dao);
/* 128 */         persistables.add(dao);
/*     */ 
/*     */         
/* 131 */         taxMappingDao = null;
/* 132 */         if (!StringUtils.isEmpty(line.getFields()[20])) {
/*     */           
/* 134 */           taxMappingDao = (RetailLocationTaxMappingDAO)getNewDAO("RetailLocationTaxMapping", DaoState.INSERT_ONLY);
/* 135 */           populateDAO(argMetaData, line, taxMappingDao);
/* 136 */           persistables.add(taxMappingDao);
/*     */         } 
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
/* 174 */         return persistables;case "STOREMOD": updateStoreRequest = createQueryRequestForUpdateStore(line); persistables.add(updateStoreRequest); if (!StringUtils.isEmpty(line.getFields()[20])) { taxMappingDao = (RetailLocationTaxMappingDAO)getNewDAO("RetailLocationTaxMapping", DaoState.INSERT_OR_UPDATE); } else { taxMappingDao = (RetailLocationTaxMappingDAO)getNewDAO("RetailLocationTaxMapping", DaoState.DELETED); }  populateDAO(argMetaData, line, taxMappingDao); persistables.add(taxMappingDao); return persistables;case "STOREDEL": taxMappingDao = (RetailLocationTaxMappingDAO)getNewDAO("RetailLocationTaxMapping", DaoState.DELETED); populateDAO(argMetaData, line, taxMappingDao); persistables.add(taxMappingDao); dao = (RetailLocationDAO)getNewDAO("RetailLocation", DaoState.DELETED); populateDAO(argMetaData, line, dao); persistables.add(dao); return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private QueryRequest createQueryRequestForUpdateStore(MOMFileLine argLine) throws DataFileException {
/* 185 */     Map<String, Object> parms = new HashMap<>(14);
/*     */ 
/*     */     
/* 188 */     parms.put("argStoreNbr", StringUtils.nonEmpty(argLine.getFields()[2]));
/* 189 */     parms.put("argDescription", StringUtils.nonEmpty(argLine.getFields()[3]));
/* 190 */     parms.put("argStoreName", StringUtils.nonEmpty(argLine.getFields()[4]));
/* 191 */     parms.put("argStoreManager", StringUtils.nonEmpty(argLine.getFields()[9]));
/* 192 */     parms.put("argLocationType", getLocationType());
/* 193 */     parms.put("argTelephone1", StringUtils.nonEmpty(argLine.getFields()[15]));
/* 194 */     parms.put("argTelephone2", StringUtils.nonEmpty(argLine.getFields()[14]));
/* 195 */     parms.put("argEmailAddress", StringUtils.nonEmpty(argLine.getFields()[16]));
/* 196 */     parms.put("argCurrencyId", StringUtils.nonEmpty(argLine.getFields()[33]));
/* 197 */     parms.put("argLocale", (new Locale(
/* 198 */           StringUtils.nonEmpty(argLine.getFields()[34]))).getLanguage());
/* 199 */     parms.put("argUseTillAccountability", Boolean.valueOf(isUseTillAccountability()));
/* 200 */     parms.put("argUpdateDate", new Date());
/* 201 */     parms.put("argUpdateUserId", "DATALOADER");
/*     */     
/* 203 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 204 */     parms.put("argRetailLocationId", argLine.getFields()[2]);
/*     */     
/* 206 */     QueryRequest queryRequest = new QueryRequest("UPDATE_STORE", parms);
/*     */     
/* 208 */     return queryRequest;
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
/*     */   private void populateDAO(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine, RetailLocationDAO argDao) {
/* 220 */     argDao.setRetailLocationId(Long.valueOf(Long.parseLong(argLine.getFields()[2])));
/* 221 */     argDao.setStoreNbr(argLine.getFields()[2]);
/*     */ 
/*     */     
/* 224 */     argDao.setDescription(StringUtils.nonEmpty(argLine.getFields()[3]));
/* 225 */     argDao.setStoreName(StringUtils.nonEmpty(argLine.getFields()[4]));
/* 226 */     argDao.setStoreManager(StringUtils.nonEmpty(argLine.getFields()[9]));
/* 227 */     argDao.setTelephone1(StringUtils.nonEmpty(argLine.getFields()[15]));
/* 228 */     argDao.setTelephone2(StringUtils.nonEmpty(argLine.getFields()[14]));
/* 229 */     argDao.setEmailAddress(StringUtils.nonEmpty(argLine.getFields()[16]));
/* 230 */     argDao.setCurrencyId(StringUtils.nonEmpty(argLine.getFields()[33]));
/* 231 */     if (!StringUtils.isEmpty(argLine.getFields()[34])) {
/* 232 */       argDao
/* 233 */         .setLocale((new Locale(StringUtils.nonEmpty(argLine.getFields()[34]))).getLanguage());
/*     */     }
/*     */     
/* 236 */     if (getLocationType() != null) {
/* 237 */       argDao.setLocationType(getLocationType());
/*     */     }
/*     */ 
/*     */     
/* 241 */     argDao.setUseTillAccountability(Boolean.valueOf(isUseTillAccountability()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void populateDAO(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine, RetailLocationTaxMappingDAO argDao) {
/* 252 */     argDao.setRetailLocationId(Long.valueOf(Long.parseLong(argLine.getFields()[2])));
/*     */ 
/*     */     
/* 255 */     argDao.setTaxLocationId(StringUtils.nonEmpty(argLine.getFields()[20]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 265 */     String[] fields = argLine.getFields();
/*     */     
/* 267 */     if (fields.length != 48) {
/* 268 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 270 */     if (StringUtils.isEmpty(fields[0])) {
/* 271 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 273 */     if (StringUtils.isEmpty(fields[2]))
/* 274 */       throw new DataFileException(buildTransformationMessage("Missing StoreId", argMetaData, argLine)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\StoreTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */