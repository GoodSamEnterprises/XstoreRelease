/*     */ package dtv.data2.dataloader;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*     */ import dtv.util.DateUtils;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
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
/*     */ public class DataLoaderUtils
/*     */ {
/*     */   public static final String DATALOADER = "DATALOADER";
/*     */   public static final String PARAM_FILE_POSITION = "filePosition=";
/*     */   public static final String PARAM_SYS_PROPERTY = "sysProp=";
/*     */   public static final String PARAM_LITERAL = "literal=";
/*  29 */   private static final IQueryKey<Object[]> DELETE_ALL_FROM_ORGANIZATION = (IQueryKey<Object[]>)new QueryKey("DELETE_ALL_FROM_ORGANIZATION", Object[].class);
/*     */ 
/*     */   
/*  32 */   private static final IQueryKey<Object[]> DELETE_EXTERNAL_SYS_FROM_ORGANIZATION = (IQueryKey<Object[]>)new QueryKey("DELETE_EXTERNAL_SYS_FROM_ORGANIZATION", Object[].class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IPersistable getDeleteByExternalSystemFromOrganizationPersistable(String argTable, String externalSystem) {
/*  42 */     Map<String, Object> queryParams = new HashMap<>();
/*     */     
/*  44 */     queryParams.put("$argTableName", argTable);
/*  45 */     queryParams.put("argOrganizationId", System.getProperty("dtv.location.organizationId"));
/*  46 */     queryParams.put("argExternalSystem", externalSystem);
/*     */     
/*  48 */     QueryRequest deleteQuery = new QueryRequest();
/*  49 */     deleteQuery.setQueryKey(DELETE_EXTERNAL_SYS_FROM_ORGANIZATION);
/*  50 */     deleteQuery.setParams(queryParams);
/*     */     
/*  52 */     return (IPersistable)deleteQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IPersistable getDeleteByOrganizationPersistable(String argTable) {
/*  60 */     Map<String, Object> queryParams = new HashMap<>();
/*     */     
/*  62 */     queryParams.put("$argTableName", argTable);
/*  63 */     queryParams.put("argDeleteOrgId", System.getProperty("dtv.location.organizationId"));
/*     */     
/*  65 */     QueryRequest deleteQuery = new QueryRequest();
/*  66 */     deleteQuery.setQueryKey(DELETE_ALL_FROM_ORGANIZATION);
/*  67 */     deleteQuery.setParams(queryParams);
/*     */     
/*  69 */     return (IPersistable)deleteQuery;
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
/*     */   public static String getValueForValueSpecifier(String argValueSpecifier, FileLine argCurrentLine) {
/*  83 */     if (argValueSpecifier == null) {
/*  84 */       return null;
/*     */     }
/*     */     
/*  87 */     if (argValueSpecifier.startsWith("filePosition=")) {
/*  88 */       int filePosition = Integer.parseInt(argValueSpecifier.substring("filePosition=".length()));
/*  89 */       return argCurrentLine.getFieldValue(filePosition - 2);
/*     */     } 
/*  91 */     if (argValueSpecifier.startsWith("sysProp=")) {
/*  92 */       return System.getProperty(argValueSpecifier.substring("sysProp=".length()));
/*     */     }
/*  94 */     if (argValueSpecifier.startsWith("literal=")) {
/*  95 */       return argValueSpecifier.substring("literal=".length());
/*     */     }
/*     */     
/*  98 */     return argValueSpecifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stampDaoAuditFields(IDataAccessObject argDao, DaoState argDaoState) {
/* 108 */     Date newDate = DateUtils.getNewDate();
/*     */     
/* 110 */     if (argDaoState.isCreate()) {
/* 111 */       argDao.setCreateDate(newDate);
/* 112 */       argDao.setCreateUserId("DATALOADER");
/*     */     } 
/*     */     
/* 115 */     if (argDaoState.isUpdate()) {
/* 116 */       argDao.setUpdateDate(newDate);
/* 117 */       argDao.setUpdateUserId("DATALOADER");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\DataLoaderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */