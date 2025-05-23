/*    */ package dtv.data2.dataserver.config;
/*    */ 
/*    */ import dtv.data2.dataserver.QueryAction;
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
/*    */ public class QueryActionConfig
/*    */   extends AbstractActionConfig<QueryAction>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public QueryActionConfig() {
/* 24 */     super(QueryAction.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getType() {
/* 30 */     return "Query";
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\QueryActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */