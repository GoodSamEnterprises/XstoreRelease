/*    */ package dtv.data2.access.impl.config;
/*    */ 
/*    */ import dtv.util.config.AbstractSetConfig;
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
/*    */ public class PmTypeMappingSetConfig
/*    */   extends AbstractSetConfig<PmTypeMappingConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "PmTypeMappingSet";
/*    */   
/*    */   public String getChildTag() {
/* 22 */     return "PmTypeMapping";
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\config\PmTypeMappingSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */