/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DiffGroupDetailTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(DiffGroupDetailTransformer.class);
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_TYPE = 1;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_GROUP_ID = 2;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_ID = 3;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_DISPLAY_SEQUENCE = 4;
/*     */ 
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  49 */     List<IPersistable> persistables = new ArrayList<>(1);
/*  50 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("rms_diff_group_detail"));
/*  51 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("itm_item_dimension_value"));
/*     */     
/*  53 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*     */     Map<String, Object> parms;
/*     */     QueryRequest query;
/*  62 */     if (_logger.isDebugEnabled()) {
/*  63 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/*  66 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/*  68 */     MOMFileLine line = argUnit.getData().get(0);
/*     */     
/*  70 */     validate(argMetaData, line);
/*     */ 
/*     */     
/*  73 */     switch (line.getFields()[1]) {
/*     */       
/*     */       case "FULL":
/*  76 */         if (!argMetaData.getIsFullReload()) {
/*  77 */           throw new DataFileException(buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */         }
/*     */ 
/*     */       
/*     */       case "DIFFGRPDTLCRE":
/*  82 */         parms = new HashMap<>(5);
/*  83 */         parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  84 */         parms.put("argDiffGroupId", line.getFields()[2]);
/*  85 */         parms.put("argDiffId", line.getFields()[3]);
/*  86 */         parms.put("argDisplaySequence", StringUtils.nonEmpty(line.getFields()[4]));
/*  87 */         parms.put("argCreateDate", new Date());
/*  88 */         query = new QueryRequest("INSERT_DIFF_GROUP_DETAIL", parms);
/*  89 */         persistables.add(query);
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
/* 143 */         return persistables;case "DIFFGRPDTLMOD": parms = new HashMap<>(5); parms.put("argDisplaySequence", StringUtils.nonEmpty(line.getFields()[4])); parms.put("argUpdateDate", new Date()); parms.put("argDiffId", line.getFields()[3]); parms.put("argDiffGroupId", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("UPDATE_DIFF_GROUP_DETAIL", parms); persistables.add(query); parms = new HashMap<>(7); parms.put("argSortOrder", StringUtils.nonEmpty(line.getFields()[4])); parms.put("argUpdateDate", new Date()); parms.put("argUpdateUserId", "DATALOADER"); parms.put("argDimensionValue", line.getFields()[3]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); parms.put("argDiffId", line.getFields()[3]); parms.put("argDiffGroupId", line.getFields()[2]); query = new QueryRequest("UPDATE_DIMENSION_VALUE_SORT_ORDER", parms); persistables.add(query); return persistables;case "DIFFGRPDTLDEL": parms = new HashMap<>(4); parms.put("argDimensionValue", line.getFields()[3]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); parms.put("argDiffId", line.getFields()[3]); parms.put("argDiffGroupId", line.getFields()[2]); query = new QueryRequest("DELETE_DIFFGROUP_MEMBER_FROM_DIMENSION_VALUE", parms); persistables.add(query); parms = new HashMap<>(3); parms.put("argDiffId", line.getFields()[3]); parms.put("argDiffGroupId", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("DELETE_DIFF_GROUP_DETAIL", parms); persistables.add(query); return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 154 */     String[] fields = argLine.getFields();
/*     */     
/* 156 */     if (fields.length != 5) {
/* 157 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 159 */     if (StringUtils.isEmpty(fields[0])) {
/* 160 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 162 */     if (StringUtils.isEmpty(fields[2])) {
/* 163 */       throw new DataFileException(buildTransformationMessage("Missing DiffGroupId", argMetaData, argLine));
/*     */     }
/* 165 */     if (StringUtils.isEmpty(fields[3]))
/* 166 */       throw new DataFileException(buildTransformationMessage("Missing DiffId", argMetaData, argLine)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\DiffGroupDetailTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */