/*    */ package dtv.data2.purge.config;
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
/*    */ 
/*    */ public class PurgeRootConfig
/*    */   extends AbstractParentConfig<PurgeGroupConfig>
/*    */ {
/*    */   public static final String CONFIG_NAME = "Root";
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public PurgeRootConfig() {
/* 25 */     super(PurgeGroupConfig.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 31 */     return "ROOT";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getOrder() {
/* 37 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\PurgeRootConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */