/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.DefaultQueryResult;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
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
/*     */ public class DiffTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  29 */   private static final Logger _logger = Logger.getLogger(DiffTransformer.class);
/*     */   
/*  31 */   private static final IQueryKey<DefaultQueryResult> SELECT_DEFAULT_DIFF_GROUPS = (IQueryKey<DefaultQueryResult>)new QueryKey("SELECT_DEFAULT_DIFF_GROUPS", DefaultQueryResult.class);
/*     */   
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   
/*     */   private static final int FIELD_INDEX_TYPE = 1;
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_ID = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_DESC = 3;
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_TYPE = 4;
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_TYPE_DESC = 5;
/*     */   
/*  45 */   private final Map<String, String> defaultDiffGroupCache = new HashMap<>();
/*     */   
/*  47 */   private String defaultDiffGroupIdPrefix = "DEF_";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultDiffGroupIdPrefix() {
/*  54 */     return this.defaultDiffGroupIdPrefix;
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
/*  67 */     List<IPersistable> persistables = new ArrayList<>(3);
/*  68 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("rms_diff_ids"));
/*  69 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("itm_item_dimension_value"));
/*     */ 
/*     */     
/*  72 */     Map<String, Object> params = new HashMap<>(2);
/*  73 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  74 */     params.put("argDefaultDiffGroupIdPrefix", getDefaultDiffGroupIdPrefix() + "%");
/*  75 */     persistables.add(new QueryRequest("DELETE_DEFAULT_DIFF_GROUPS", params));
/*     */     
/*  77 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultDiffGroupIdPrefix(String argPrefix) {
/*  86 */     if (argPrefix.length() > 4) {
/*  87 */       throw new UnsupportedOperationException("Prefix must be 4 characters or less [" + argPrefix + "]");
/*     */     }
/*  89 */     this.defaultDiffGroupIdPrefix = argPrefix;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*     */     Map<String, Object> parms;
/*     */     QueryRequest query;
/*  97 */     if (_logger.isDebugEnabled()) {
/*  98 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/* 101 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/* 103 */     MOMFileLine line = argUnit.getData().get(0);
/*     */     
/* 105 */     validate(argMetaData, line);
/*     */ 
/*     */     
/* 108 */     if (!argMetaData.getIsFullReload() && this.defaultDiffGroupCache.isEmpty()) {
/* 109 */       loadDefaultDiffGroupCache();
/*     */     }
/*     */ 
/*     */     
/* 113 */     String defaultDiffGroupId = getDefaultDiffGroupIdPrefix() + line.getFields()[4];
/*     */ 
/*     */     
/* 116 */     switch (line.getFields()[1]) {
/*     */       
/*     */       case "FULL":
/* 119 */         if (!argMetaData.getIsFullReload()) {
/* 120 */           throw new DataFileException(buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case "DIFFCRE":
/* 127 */         parms = new HashMap<>(6);
/* 128 */         parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 129 */         parms.put("argDiffId", line.getFields()[2]);
/* 130 */         parms.put("argDiffDescription", line.getFields()[3]);
/* 131 */         parms.put("argDiffType", line.getFields()[4]);
/* 132 */         parms.put("argDiffTypeDescription", line.getFields()[5]);
/* 133 */         parms.put("argCreateDate", new Date());
/* 134 */         query = new QueryRequest("INSERT_DIFF_IDS", parms);
/* 135 */         persistables.add(query);
/*     */ 
/*     */         
/* 138 */         if (!this.defaultDiffGroupCache.containsKey(defaultDiffGroupId)) {
/*     */ 
/*     */           
/* 141 */           String defaultDiffGroupDesc = line.getFields()[5];
/*     */           
/* 143 */           parms = new HashMap<>(5);
/* 144 */           parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 145 */           parms.put("argDiffGroupId", defaultDiffGroupId);
/* 146 */           parms.put("argDiffGroupDesc", defaultDiffGroupDesc);
/* 147 */           parms.put("argDiffGroupType", line.getFields()[4]);
/* 148 */           parms.put("argCreateDate", new Date());
/* 149 */           query = new QueryRequest("INSERT_DIFF_GROUP_HEAD", parms);
/* 150 */           persistables.add(query);
/*     */ 
/*     */           
/* 153 */           this.defaultDiffGroupCache.put(defaultDiffGroupId, defaultDiffGroupDesc);
/*     */         } 
/*     */ 
/*     */         
/* 157 */         parms = new HashMap<>(5);
/* 158 */         parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 159 */         parms.put("argDiffGroupId", defaultDiffGroupId);
/* 160 */         parms.put("argDiffId", line.getFields()[2]);
/* 161 */         parms.put("argDisplaySequence", null);
/* 162 */         parms.put("argCreateDate", new Date());
/* 163 */         query = new QueryRequest("INSERT_DIFF_GROUP_DETAIL", parms);
/* 164 */         persistables.add(query);
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
/* 252 */         return persistables;case "DIFFMOD": parms = new HashMap<>(6); parms.put("argDiffDescription", line.getFields()[3]); parms.put("argDiffType", line.getFields()[4]); parms.put("argDiffTypeDescription", line.getFields()[5]); parms.put("argUpdateDate", new Date()); parms.put("argDiffId", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("UPDATE_DIFF_IDS", parms); persistables.add(query); parms = new HashMap<>(6); parms.put("argDescription", line.getFields()[3]); parms.put("argUpdateDate", new Date()); parms.put("argUpdateUserId", "DATALOADER"); parms.put("argDimension", line.getFields()[4]); parms.put("argDimensionValue", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("UPDATE_DIMENSION_VALUE_DESCRIPTION", parms); persistables.add(query); parms = new HashMap<>(5); parms.put("argDescription", line.getFields()[5]); parms.put("argUpdateDate", new Date()); parms.put("argUpdateUserId", "DATALOADER"); parms.put("argDimension", line.getFields()[4]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("UPDATE_DIMENSION_TYPE_DESCRIPTION", parms); persistables.add(query); parms = new HashMap<>(5); parms.put("argDiffGroupType", line.getFields()[4]); parms.put("argDiffGroupDesc", line.getFields()[5]); parms.put("argUpdateDate", new Date()); parms.put("argDiffGroupId", getDefaultDiffGroupIdPrefix() + line.getFields()[4]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("UPDATE_DIFF_GROUP_HEAD", parms); persistables.add(query); return persistables;case "DIFFDEL": parms = new HashMap<>(2); parms.put("argDiffId", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("DELETE_DIFF_IDS", parms); persistables.add(query); parms = new HashMap<>(3); parms.put("argDimension", line.getFields()[4]); parms.put("argDimensionValue", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("DELETE_DIFF_ID_FROM_DIMENSION_VALUE", parms); persistables.add(query); parms = new HashMap<>(3); parms.put("argDiffGroupId", defaultDiffGroupId); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); parms.put("argDiffType", line.getFields()[4]); query = new QueryRequest("DELETE_DEFAULT_DIFF_GROUP_BY_DIFF_TYPE", parms); persistables.add(query); parms = new HashMap<>(3); parms.put("argDiffId", line.getFields()[2]); parms.put("argDiffGroupId", defaultDiffGroupId); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("DELETE_DIFF_GROUP_DETAIL", parms); persistables.add(query); return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void loadDefaultDiffGroupCache() {
/* 260 */     Map<String, Object> params = new HashMap<>(2);
/* 261 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 262 */     params.put("argDefaultDiffGroupIdPrefix", getDefaultDiffGroupIdPrefix() + "%");
/*     */ 
/*     */ 
/*     */     
/* 266 */     IQueryResultList<DefaultQueryResult> results = DataFactory.getObjectByQueryNoThrow(SELECT_DEFAULT_DIFF_GROUPS, params);
/*     */ 
/*     */     
/* 269 */     if (!results.isEmpty())
/*     */     {
/* 271 */       for (DefaultQueryResult result : results) {
/*     */         
/* 273 */         String diffGroupId = (String)result.get("diffGroupId");
/* 274 */         String diffGroupDesc = (String)result.get("diffGroupDesc");
/* 275 */         this.defaultDiffGroupCache.put(diffGroupId, diffGroupDesc);
/*     */       } 
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
/*     */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 289 */     String[] fields = argLine.getFields();
/*     */     
/* 291 */     if (fields.length != 8) {
/* 292 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 294 */     if (StringUtils.isEmpty(fields[0])) {
/* 295 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 297 */     if (StringUtils.isEmpty(fields[2])) {
/* 298 */       throw new DataFileException(buildTransformationMessage("Missing DiffId", argMetaData, argLine));
/*     */     }
/* 300 */     if (StringUtils.isEmpty(fields[3])) {
/* 301 */       throw new DataFileException(
/* 302 */           buildTransformationMessage("Missing Diff Description", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/* 306 */     if (!"DIFFDEL".equals(argLine.getFields()[1])) {
/*     */       
/* 308 */       if (StringUtils.isEmpty(fields[4])) {
/* 309 */         throw new DataFileException(buildTransformationMessage("Missing DiffType", argMetaData, argLine));
/*     */       }
/* 311 */       if (StringUtils.isEmpty(fields[5]))
/* 312 */         throw new DataFileException(buildTransformationMessage("Missing DiffType Description", argMetaData, argLine)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\DiffTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */