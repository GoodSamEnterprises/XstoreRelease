/*    */ package dtv.data2.dataserver;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IQueryKey;
/*    */ import dtv.data2.access.IQueryResultList;
/*    */ import dtv.data2.access.QueryKey;
/*    */ import dtv.util.StringUtils;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryAction
/*    */   extends AbstractAction
/*    */ {
/*    */   private static final String DIRECT_REPLACEMENT_PARAM = "DirectReplacement";
/*    */   private static final String PARAM_PREFIX = "arg";
/* 31 */   private final Map<String, Object> _directReplacementParameters = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Map<String, Object> piratizeParameters(Map<String, String> argParameters) {
/* 40 */     Map<String, Object> pirateMap = new HashMap<>();
/*    */     
/* 42 */     for (Map.Entry<String, String> entry : argParameters.entrySet()) {
/* 43 */       String key = entry.getKey();
/*    */       
/* 45 */       String pirateKey = !key.startsWith("arg") ? ("arg" + key.substring(0, 1).toUpperCase() + key.substring(1)) : key;
/*    */ 
/*    */       
/* 48 */       if (this._directReplacementParameters.containsKey(key)) {
/* 49 */         pirateKey = "$" + pirateKey;
/*    */       }
/*    */       
/* 52 */       pirateMap.put(pirateKey, entry.getValue());
/*    */     } 
/*    */     
/* 55 */     return pirateMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object processImpl(Map<String, String> argParameters) throws Exception {
/* 64 */     QueryKey queryKey = new QueryKey(getValue(), DataServerQueryResult.class);
/*    */     
/* 66 */     Map<String, Object> params = piratizeParameters(argParameters);
/* 67 */     IQueryResultList<DataServerQueryResult> results = DataFactory.getObjectByQuery((IQueryKey)queryKey, params);
/* 68 */     DataServerQueryResult result = (DataServerQueryResult)results.get(0);
/*    */ 
/*    */ 
/*    */     
/* 72 */     if (result.getReturnValue() != 0) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 77 */       String message = !StringUtils.isEmpty(result.getErrorText()) ? result.getErrorText() : ("An exception occurred processing [" + toString() + "] - error code was " + result.getReturnValue());
/*    */       
/* 79 */       throw new SQLException(message);
/*    */     } 
/*    */     
/* 82 */     return results;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, Object argValue) {
/* 88 */     if ("DirectReplacement".equalsIgnoreCase(argName)) {
/*    */       
/* 90 */       this._directReplacementParameters.put(argValue.toString(), Integer.valueOf(1));
/*    */     } else {
/*    */       
/* 93 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\QueryAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */