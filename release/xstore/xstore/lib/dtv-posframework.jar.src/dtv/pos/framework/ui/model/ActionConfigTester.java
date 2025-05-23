/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import com.micros.xstore.config.IPropertyCascader;
/*    */ import com.micros.xstore.config.impl.ActionCascader;
/*    */ import com.micros.xstore.config.impl.ActionConfigMgr;
/*    */ import com.micros.xstore.config.impl.ConfigLoadingException;
/*    */ import dtv.util.config.SystemPropertiesLoader;
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
/*    */ public class ActionConfigTester
/*    */ {
/*    */   public static void main(String[] args) {
/* 23 */     SystemPropertiesLoader.loadConfigPathPropertiesFile();
/*    */     
/* 25 */     ActionConfigMgr mgr = new ActionConfigMgr((IPropertyCascader)new ActionCascader());
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 30 */       mgr.getResolvedConfigs();
/*    */     }
/* 32 */     catch (ConfigLoadingException ex) {
/* 33 */       ex.printStackTrace(System.err);
/*    */     } 
/*    */     
/* 36 */     System.exit(0);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\ActionConfigTester.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */