/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.util.config.reload.NamedXmlConfigReloader;
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
/*    */ 
/*    */ 
/*    */ public class SubstituteComponentsConfigReloader
/*    */   extends NamedXmlConfigReloader
/*    */ {
/*    */   protected String getConfigName() {
/* 26 */     return "SubstituteComponentConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void reloadConfig() {
/* 32 */     SubstituteComponentConfigHelper.reinitialize();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SubstituteComponentsConfigReloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */