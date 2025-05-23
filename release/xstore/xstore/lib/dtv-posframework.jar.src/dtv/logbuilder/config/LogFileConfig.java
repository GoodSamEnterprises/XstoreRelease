/*     */ package dtv.logbuilder.config;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LogFileConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  23 */   private final List<LogDestinationConfig> logDestinationList_ = new ArrayList<>();
/*     */   
/*     */   private String fileId_;
/*     */   private String header_;
/*     */   private String footer_;
/*  28 */   private String encoding_ = "UTF-8";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/*  36 */     return this.encoding_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileId() {
/*  45 */     return this.fileId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFooter() {
/*  54 */     return this.footer_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHeader() {
/*  63 */     return this.header_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogDestinationConfig[] getLogDestinations() {
/*  72 */     return this.logDestinationList_.<LogDestinationConfig>toArray(new LogDestinationConfig[this.logDestinationList_.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  84 */     if ("id".equalsIgnoreCase(argKey) || "file_id".equalsIgnoreCase(argKey)) {
/*  85 */       this.fileId_ = argValue.toString();
/*     */     }
/*  87 */     else if ("header".equalsIgnoreCase(argKey)) {
/*  88 */       this.header_ = argValue.toString();
/*     */     }
/*  90 */     else if ("footer".equalsIgnoreCase(argKey)) {
/*  91 */       this.footer_ = argValue.toString();
/*     */     }
/*  93 */     else if ("encoding".equalsIgnoreCase(argKey)) {
/*  94 */       this.encoding_ = argValue.toString();
/*     */     }
/*  96 */     else if (argValue instanceof LogDestinationConfig) {
/*  97 */       ((LogDestinationConfig)argValue).setParent(this);
/*  98 */       this.logDestinationList_.add((LogDestinationConfig)argValue);
/*     */     } else {
/*     */       
/* 101 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\LogFileConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */