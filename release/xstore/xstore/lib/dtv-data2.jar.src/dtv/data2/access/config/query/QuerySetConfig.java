/*    */ package dtv.data2.access.config.query;
/*    */ 
/*    */ import dtv.util.config.AbstractSetConfig;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class QuerySetConfig
/*    */   extends AbstractSetConfig<QueryConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getChildTag() {
/* 24 */     return "Query";
/*    */   }
/*    */   
/*    */   public List<QueryDescriptor> getQueryDescriptors() {
/* 28 */     List<QueryDescriptor> descriptors = new ArrayList<>();
/* 29 */     for (QueryConfig config : getChildren()) {
/* 30 */       descriptors.add(config.getQueryDescriptor());
/*    */     }
/* 32 */     return descriptors;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QuerySetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */