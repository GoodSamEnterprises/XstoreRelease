/*    */ package dtv.pos.framework.ui.vk.config;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
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
/*    */ public class KeyboardConfigHelper
/*    */   extends ConfigHelper<KeyboardConfig>
/*    */ {
/*    */   private static final String CONFIG_FILE_NAME = "KeyboardConfig";
/*    */   private static KeyboardConfigHelper instance_;
/*    */   
/*    */   public static KeyboardConfigHelper getInstance() {
/* 27 */     if (instance_ == null) {
/* 28 */       instance_ = new KeyboardConfigHelper();
/* 29 */       instance_.initialize();
/*    */     } 
/*    */     
/* 32 */     return instance_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 38 */     return "KeyboardConfig";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\config\KeyboardConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */