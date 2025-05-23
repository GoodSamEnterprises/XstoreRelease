/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.DataModelFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.impl.ItemPricesDAO;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractPriceTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*     */   protected static final int FIELD_INDEX_RECORD_DESCRIPTOR = 0;
/*     */   protected static final int FIELD_INDEX_FDETL_LINE_ID = 1;
/*     */   protected static final int FIELD_INDEX_FDETL_EVENT_TYPE = 2;
/*     */   protected static final int FIELD_INDEX_FDETL_EVENT_ID = 3;
/*     */   protected static final int FIELD_INDEX_FDETL_ITEM_ID = 4;
/*     */   protected static final int FIELD_INDEX_FDETL_EFFECTIVE_DATE = 5;
/*     */   protected static final int FIELD_INDEX_FDELE_LINE_ID = 1;
/*     */   protected static final int FIELD_INDEX_FDELE_EVENT_ID = 2;
/*     */   protected static final int FIELD_INDEX_FDELE_ITEM_ID = 3;
/*  44 */   private static final Logger _logger = Logger.getLogger(AbstractPriceTransformer.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getExternalSystem();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemPricesDAO getNewItemPriceDAO(boolean argIsFull, String argStoreId) {
/*  60 */     ItemPricesDAO dao = (ItemPricesDAO)DataModelFactory.getDaoForDaoName("ItemPrices");
/*     */     
/*  62 */     DaoState daoState = argIsFull ? DaoState.INSERT_ONLY : DaoState.INSERT_OR_UPDATE;
/*     */     
/*  64 */     dao.setObjectState(daoState.intVal());
/*  65 */     dao.setOrganizationId(Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*     */ 
/*     */     
/*  68 */     dao.setLevelCode("STORE");
/*  69 */     dao.setLevelValue(argStoreId);
/*     */     
/*  71 */     DataLoaderUtils.stampDaoAuditFields((IDataAccessObject)dao, daoState);
/*     */     
/*  73 */     return dao;
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
/*     */   protected QueryRequest getDeleteItemPricesQueryRequest(String argExternalSystem, String argStoreId) {
/*  86 */     return (QueryRequest)getDeleteByExternalSystemPersistable("ITM_ITEM_PRICES", argExternalSystem, "STORE", argStoreId);
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
/*     */   
/*     */   protected QueryRequest getDeletePriceByEventQueryRequest(String argExternalId, String argExternalSystem, String argItemId, String argStoreId) {
/* 102 */     Map<String, Object> parms = new HashMap<>(6);
/* 103 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 104 */     parms.put("argExternalId", argExternalId);
/* 105 */     parms.put("argExternalSystem", argExternalSystem);
/* 106 */     parms.put("argItemId", argItemId);
/*     */ 
/*     */     
/* 109 */     parms.put("argLevelCode", "STORE");
/* 110 */     parms.put("argLevelValue", argStoreId);
/*     */     
/* 112 */     QueryRequest query = new QueryRequest("DELETE_EXTERNAL_ITEM_PRICE_EVENT", parms);
/* 113 */     return query;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validateCommonDetail(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 124 */     String[] fields = argLine.getFields();
/*     */ 
/*     */     
/* 127 */     if (fields.length < 10) {
/* 128 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/*     */     
/* 131 */     if (StringUtils.isEmpty(fields[2])) {
/* 132 */       throw new DataFileException(buildTransformationMessage("Missing Event Type", argMetaData, argLine));
/*     */     }
/* 134 */     if (StringUtils.isEmpty(fields[3])) {
/* 135 */       throw new DataFileException(buildTransformationMessage("Missing Event Id", argMetaData, argLine));
/*     */     }
/*     */     
/* 138 */     if (StringUtils.isEmpty(fields[4])) {
/* 139 */       throw new DataFileException(buildTransformationMessage("Missing Item Id", argMetaData, argLine));
/*     */     }
/*     */     
/* 142 */     if (StringUtils.isEmpty(fields[5])) {
/* 143 */       throw new DataFileException(buildTransformationMessage("Missing Effective Date", argMetaData, argLine));
/*     */     }
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
/*     */   protected void validateDelete(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 156 */     String[] fields = argLine.getFields();
/*     */ 
/*     */     
/* 159 */     if (fields.length < 4) {
/* 160 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/*     */     
/* 163 */     if (StringUtils.isEmpty(fields[2])) {
/* 164 */       throw new DataFileException(buildTransformationMessage("Missing Event Id", argMetaData, argLine));
/*     */     }
/*     */     
/* 167 */     if (StringUtils.isEmpty(fields[3])) {
/* 168 */       throw new DataFileException(buildTransformationMessage("Missing Item Id", argMetaData, argLine));
/*     */     }
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
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/* 184 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/* 186 */     String storeId = ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId();
/* 187 */     persistables.add(getDeleteItemPricesQueryRequest(getExternalSystem(), storeId));
/* 188 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) {
/*     */     List<IPersistable> persistables;
/* 196 */     if (_logger.isDebugEnabled()) {
/* 197 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     MOMFileLine line = argUnit.getData().get(0);
/* 204 */     switch (line.getFields()[0]) {
/*     */       case "FDETL":
/* 206 */         persistables = transformDetail(argMetaData, line);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 216 */         return persistables;case "FDELE": persistables = transformDelete(argMetaData, line); return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract List<IPersistable> transformDetail(DataFileMetaData<MOMFileConfiguration> paramDataFileMetaData, MOMFileLine paramMOMFileLine);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<IPersistable> transformDelete(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 236 */     validateDelete(argMetaData, argLine);
/*     */     
/* 238 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/* 240 */     String[] fields = argLine.getFields();
/*     */ 
/*     */     
/* 243 */     QueryRequest query = getDeletePriceByEventQueryRequest(fields[2], getExternalSystem(), fields[3], ((MOMFileConfiguration)argMetaData
/* 244 */         .getConfigObject()).getStoreId());
/* 245 */     persistables.add(query);
/*     */     
/* 247 */     return persistables;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\AbstractPriceTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */