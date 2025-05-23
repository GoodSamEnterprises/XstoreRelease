/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ParameterConfig;
/*    */ import java.io.File;
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
/*    */ public class ExecConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "Exec";
/*    */   private String name_;
/*    */   private String executable_;
/*    */   private File directory_;
/*    */   private String text_;
/*    */   private String icon_;
/*    */   private boolean monitor_;
/* 33 */   private final List<ParameterConfig> parameters_ = new ArrayList<>();
/*    */   
/*    */   public File getDirectory() {
/* 36 */     return this.directory_;
/*    */   }
/*    */   
/*    */   public String getExecutable() {
/* 40 */     return this.executable_;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 44 */     return this.icon_;
/*    */   }
/*    */   
/*    */   public boolean getMonitor() {
/* 48 */     return this.monitor_;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 52 */     return this.name_;
/*    */   }
/*    */   
/*    */   public List<ParameterConfig> getParameterConfigs() {
/* 56 */     return this.parameters_;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 60 */     return this.text_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 66 */     if ("name".equalsIgnoreCase(argKey)) {
/* 67 */       this.name_ = argValue.toString();
/*    */     }
/* 69 */     else if ("executable".equalsIgnoreCase(argKey)) {
/* 70 */       this.executable_ = argValue.toString();
/*    */     }
/* 72 */     else if ("directory".equalsIgnoreCase(argKey)) {
/* 73 */       this.directory_ = new File(argValue.toString());
/*    */     }
/* 75 */     else if ("text".equalsIgnoreCase(argKey)) {
/* 76 */       this.text_ = argValue.toString();
/*    */     }
/* 78 */     else if ("icon".equalsIgnoreCase(argKey)) {
/* 79 */       this.icon_ = argValue.toString();
/*    */     }
/* 81 */     else if ("monitor".equalsIgnoreCase(argKey)) {
/* 82 */       this.monitor_ = ConfigUtils.toBoolean(argValue);
/*    */     }
/* 84 */     else if (argValue instanceof ParameterConfig) {
/* 85 */       this.parameters_.add((ParameterConfig)argValue);
/*    */     } else {
/*    */       
/* 88 */       this.parameters_.add(new ParameterConfig(argKey, argValue));
/*    */     } 
/* 90 */     setClean();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ExecConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */