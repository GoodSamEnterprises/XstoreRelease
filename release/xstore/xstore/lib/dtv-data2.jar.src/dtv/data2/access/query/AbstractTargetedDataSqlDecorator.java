/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractTargetedDataSqlDecorator
/*     */   implements ISqlQueryDecorator
/*     */ {
/*  31 */   private static final Pattern NO_ALIAS_PATTERN = Pattern.compile("^\\s*(?:WHERE|UNION|ON|LEFT|RIGHT|INNER|OUTER|\\)|\\,)\\s*.*", 34);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, IObjectId argObjId) {
/*  37 */     Map<String, Object> params = new HashMap<>();
/*  38 */     if (argObjId != null) {
/*  39 */       if (argObjId.containsKey("IGNORE_ORG_HIERARCHY_FILTERING")) {
/*  40 */         params.put("IGNORE_ORG_HIERARCHY_FILTERING", argObjId
/*  41 */             .get("IGNORE_ORG_HIERARCHY_FILTERING"));
/*     */       }
/*  43 */       if (argObjId.containsKey("IGNORE_CONFIG_ELEMENT_FILTERING")) {
/*  44 */         params.put("IGNORE_CONFIG_ELEMENT_FILTERING", argObjId
/*  45 */             .get("IGNORE_CONFIG_ELEMENT_FILTERING"));
/*     */       }
/*     */     } 
/*  48 */     return decorateSql(argSqlStatement, argTargetStrategy, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, Map<String, Object> argParams) {
/*  56 */     return isDecoratable(argSqlStatement, argParams) ? 
/*  57 */       decorateSqlImpl(argSqlStatement, argTargetStrategy, argParams) : argSqlStatement;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String decorateSqlImpl(String argSqlStatement, IPersistenceStrategy argTargetStrategy, Map<String, Object> argQueryParams) {
/*  80 */     StringBuilder workingSql = new StringBuilder(argSqlStatement);
/*     */ 
/*     */ 
/*     */     
/*  84 */     label16: for (String candidateTable : getTablesToDecorate()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       int tableStartPos = 0;
/*  91 */       int afterTablePos = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/* 100 */         tableStartPos = workingSql.indexOf(" " + candidateTable + " ", afterTablePos);
/*     */         
/* 102 */         if (tableStartPos >= 0) {
/*     */           
/* 104 */           afterTablePos = tableStartPos + candidateTable.length() + 2;
/*     */           
/* 106 */           String replacementSql = getReplacementSql(candidateTable, argQueryParams);
/*     */ 
/*     */           
/* 109 */           String afterTableSql = workingSql.substring(afterTablePos);
/*     */           
/* 111 */           if (StringUtils.isEmpty(afterTableSql) || NO_ALIAS_PATTERN.matcher(afterTableSql).matches())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 119 */             replacementSql = replacementSql + " " + candidateTable;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 124 */           workingSql = workingSql.replace(tableStartPos + 1, afterTablePos - 1, replacementSql);
/*     */ 
/*     */ 
/*     */           
/* 128 */           afterTablePos = tableStartPos + replacementSql.length() + 1;
/*     */         } 
/*     */ 
/*     */         
/* 132 */         if (tableStartPos < 0)
/*     */           continue label16; 
/*     */       } 
/* 135 */     }  return workingSql.toString();
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
/*     */   protected abstract String getReplacementSql(String paramString, Map<String, Object> paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Collection<String> getTablesToDecorate();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDecoratable(String argSqlStatement, Map<String, Object> argQueryParams) {
/* 167 */     String trimmedSqlStatement = argSqlStatement.trim();
/* 168 */     return (!StringUtils.startsWithIgnoreCase(trimmedSqlStatement, "DELETE") && 
/* 169 */       !StringUtils.startsWithIgnoreCase(trimmedSqlStatement, "TRUNCATE"));
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\AbstractTargetedDataSqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */