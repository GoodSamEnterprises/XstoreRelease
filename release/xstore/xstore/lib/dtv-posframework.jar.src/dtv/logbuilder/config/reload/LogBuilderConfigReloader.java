/*    */ package dtv.logbuilder.config.reload;
/*    */ 
/*    */ import dtv.util.ClassPathUtils;
/*    */ import dtv.util.config.reload.ConfigReloader;
/*    */ import java.net.URL;
/*    */ import java.util.Arrays;
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
/*    */ 
/*    */ 
/*    */ public class LogBuilderConfigReloader
/*    */   extends ConfigReloader
/*    */ {
/*    */   protected List<URL> getConfigLocations() {
/* 26 */     return Arrays.asList(ClassPathUtils.getDirectoryBasedConfigFileList("log", XML_EXTENSION));
/*    */   }
/*    */   
/*    */   protected void reloadConfig() {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\reload\LogBuilderConfigReloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */