/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.io.File;
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
/*    */ public class DocBuilderPictureConfig
/*    */   extends AbstractParentConfig
/*    */   implements ISectionMemberConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private File file_ = null;
/*    */ 
/*    */   
/*    */   private String filePath_;
/*    */   
/*    */   private boolean preload_ = false;
/*    */ 
/*    */   
/*    */   public File getFile() {
/* 32 */     return this.file_;
/*    */   }
/*    */   
/*    */   public String getFilePath() {
/* 36 */     return this.filePath_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getPreload() {
/* 44 */     return this.preload_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 51 */     if ("filename".equalsIgnoreCase(argKey)) {
/* 52 */       this.filePath_ = argValue.toString();
/* 53 */       this.file_ = new File(argValue.toString());
/*    */     }
/* 55 */     else if ("preload".equalsIgnoreCase(argKey)) {
/* 56 */       this.preload_ = ConfigUtils.toBoolean(argValue);
/*    */     } else {
/*    */       
/* 59 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setFilePath(String argPath) {
/* 64 */     this.filePath_ = argPath;
/* 65 */     this.file_ = new File(argPath);
/*    */   }
/*    */   
/*    */   public void setPreload(boolean argPreload) {
/* 69 */     this.preload_ = argPreload;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderPictureConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */