/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.DataModelFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractMOMTransformer
/*     */   implements IMOMDataTransformer
/*     */ {
/*     */   protected static final String RPM_DATE_FORMAT = "yyyyMMddHHmmss";
/*     */   private static final String RMS_DATE_FORMAT = "dd-MMM-yyyy";
/*     */   protected static final String DATALOADER = "DATALOADER";
/*     */   protected static final String EXTERNAL_SYSTEM = "RMS";
/*     */   protected static final String STORE_CODE = "STORE";
/*     */   protected static final String ASTERISK_CONSTANT = "*";
/*     */   
/*     */   protected String buildTransformationMessage(String argMessage, DataFileMetaData<MOMFileConfiguration> argMetaData, List<MOMFileLine> argLines) {
/*  62 */     StringBuilder message = new StringBuilder(128);
/*     */     
/*  64 */     message.append(argMessage);
/*  65 */     message.append("[").append(argMetaData.getFile().getName()).append("]");
/*     */     
/*  67 */     for (MOMFileLine line : argLines) {
/*  68 */       message.append("\n\tline[#").append(line.getLineNo()).append("]: ");
/*  69 */       message.append(line.getFileLine());
/*     */     } 
/*     */     
/*  72 */     return message.toString();
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
/*     */   protected String buildTransformationMessage(String argMessage, DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/*  87 */     List<MOMFileLine> argLines = new ArrayList<>(1);
/*  88 */     argLines.add(argLine);
/*  89 */     return buildTransformationMessage(argMessage, argMetaData, argLines);
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
/*     */   protected IPersistable getDeleteByExternalSystemPersistable(String argTableName, String argExternalSystem) {
/* 101 */     Map<String, Object> queryParams = new HashMap<>(3);
/* 102 */     queryParams.put("$argTableName", argTableName);
/* 103 */     queryParams.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 104 */     queryParams.put("argExternalSystem", argExternalSystem);
/* 105 */     return (IPersistable)new QueryRequest("DELETE_ALL_FROM_ORGANIZATION_BY_EXTERNAL_SYSTEM", queryParams);
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
/*     */   protected IPersistable getDeleteByExternalSystemPersistable(String argTableName, String argExternalSystem, String argLevelCode, String argLevelValue) {
/* 120 */     QueryRequest query = (QueryRequest)getDeleteByExternalSystemPersistable(argTableName, argExternalSystem);
/* 121 */     query.getParams().put("argLevelCode", argLevelCode);
/* 122 */     query.getParams().put("argLevelValue", argLevelValue);
/* 123 */     return (IPersistable)query;
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
/*     */   protected IDataAccessObject getNewDAO(String argDaoName, DaoState argDaoState) {
/* 135 */     IDataAccessObject dao = DataModelFactory.getDaoForDaoName(argDaoName);
/*     */     
/* 137 */     dao.setObjectState(argDaoState.intVal());
/* 138 */     dao.setOrganizationId(Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*     */     
/* 140 */     DataLoaderUtils.stampDaoAuditFields(dao, argDaoState);
/*     */     
/* 142 */     return dao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Date parseRMSDate(String argDateString) {
/* 152 */     if (StringUtils.isEmpty(argDateString)) {
/* 153 */       return null;
/*     */     }
/* 155 */     return DateUtils.parseDate(argDateString, "dd-MMM-yyyy");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Date parseRPMDate(String argDateString) {
/* 164 */     if (argDateString == null) {
/* 165 */       return null;
/*     */     }
/* 167 */     return DateUtils.parseDate(argDateString, "yyyyMMddHHmmss");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\AbstractMOMTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */