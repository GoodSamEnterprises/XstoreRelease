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
/*     */ public class DiffGroupHeadTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(DiffGroupHeadTransformer.class);
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
/*     */   private static final int FIELD_INDEX_DIFF_GROUP_DESC = 3;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_DIFF_TYPE = 4;
/*     */ 
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  49 */     List<IPersistable> persistables = new ArrayList<>(1);
/*  50 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("rms_diff_group_head"));
/*     */     
/*  52 */     return persistables;
/*     */   }
/*     */ 
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
/*     */       
/*     */       case "DIFFGRPHDRCRE":
/*  83 */         parms = new HashMap<>(5);
/*  84 */         parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  85 */         parms.put("argDiffGroupId", line.getFields()[2]);
/*  86 */         parms.put("argDiffGroupDesc", line.getFields()[3]);
/*  87 */         parms.put("argDiffGroupType", line.getFields()[4]);
/*  88 */         parms.put("argCreateDate", new Date());
/*  89 */         query = new QueryRequest("INSERT_DIFF_GROUP_HEAD", parms);
/*  90 */         persistables.add(query);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 118 */         return persistables;case "DIFFGRPHDRMOD": parms = new HashMap<>(5); parms.put("argDiffGroupType", line.getFields()[4]); parms.put("argDiffGroupDesc", line.getFields()[3]); parms.put("argUpdateDate", new Date()); parms.put("argDiffGroupId", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("UPDATE_DIFF_GROUP_HEAD", parms); persistables.add(query); return persistables;case "DIFFGRPHDRDEL": parms = new HashMap<>(2); parms.put("argDiffGroupId", line.getFields()[2]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("DELETE_DIFF_GROUP_HEAD", parms); persistables.add(query); return persistables;
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
/* 129 */     String[] fields = argLine.getFields();
/*     */     
/* 131 */     if (fields.length != 6) {
/* 132 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 134 */     if (StringUtils.isEmpty(fields[0])) {
/* 135 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 137 */     if (StringUtils.isEmpty(fields[2])) {
/* 138 */       throw new DataFileException(buildTransformationMessage("Missing DiffGroupId", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/* 142 */     if (!"DIFFGRPHDRDEL".equals(argLine.getFields()[1])) {
/*     */       
/* 144 */       if (StringUtils.isEmpty(fields[3])) {
/* 145 */         throw new DataFileException(buildTransformationMessage("Missing Diff GROUP Description", argMetaData, argLine));
/*     */       }
/*     */       
/* 148 */       if (StringUtils.isEmpty(fields[4]))
/* 149 */         throw new DataFileException(buildTransformationMessage("Missing DiffType", argMetaData, argLine)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\DiffGroupHeadTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */