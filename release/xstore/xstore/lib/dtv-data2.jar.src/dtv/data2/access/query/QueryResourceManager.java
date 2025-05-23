/*    */ package dtv.data2.access.query;
/*    */ 
/*    */ import dtv.data2.access.transaction.DataSourceTransactionException;
/*    */ import java.util.Set;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class QueryResourceManager
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(QueryResourceManager.class);
/* 24 */   private static QueryResourceManager instance_ = new QueryResourceManager();
/*    */   
/*    */   public static QueryResourceManager getInstance() {
/* 27 */     return instance_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void closeQueryResources(QueryToken argQueryToken) {
/* 33 */     Set<IQueryResource> queryResources = argQueryToken.drainQueryResources();
/* 34 */     if (queryResources.size() == 0) {
/* 35 */       if (logger_.isDebugEnabled()) {
/* 36 */         logger_
/* 37 */           .debug("closeQueryResources was called on token " + argQueryToken
/* 38 */             .toString() + " but no datasources were registered on that token.  This is not necessarily an indication of any issue, as not all query implementations use tokens.");
/*    */       }
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 44 */     for (IQueryResource resource : queryResources) {
/*    */       try {
/* 46 */         resource.close();
/*    */       }
/* 48 */       catch (Exception ex) {
/* 49 */         logger_.warn("An error occurred when closing query resources.", ex);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerQueryResource(QueryToken argQueryToken, IQueryResource argCloseableResource) {
/* 61 */     if (argQueryToken == null) {
/* 62 */       throw new DataSourceTransactionException("Cannot register query resource to null QueryToken.");
/*    */     }
/*    */ 
/*    */     
/* 66 */     argQueryToken.registerQueryResource(argCloseableResource);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryResourceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */