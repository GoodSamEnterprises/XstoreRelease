/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.process.IProcMonitorConfig;
/*     */ import dtv.pos.framework.process.LaunchedProcessManager;
/*     */ import dtv.pos.framework.process.ProcMonitorConfig;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
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
/*     */ 
/*     */ public class XstExecAction
/*     */   extends XstDefaultAction
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  32 */   private static final Logger logger_ = Logger.getLogger(XstExecAction.class);
/*     */   
/*  34 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   private File executableDir_;
/*     */   private String executable_;
/*  38 */   protected List<String> args_ = new ArrayList<>();
/*     */   private File workingDir_;
/*  40 */   private final List<String> env_ = new ArrayList<>();
/*     */   
/*     */   private final boolean monitor_;
/*     */   
/*     */   private ProcMonitorConfig monitorConfig_;
/*     */ 
/*     */   
/*     */   public XstExecAction(boolean argMonitor) {
/*  48 */     this.monitor_ = argMonitor;
/*     */   }
/*     */   
/*     */   public boolean getMonitor() {
/*  52 */     return this.monitor_;
/*     */   }
/*     */   
/*     */   public void setArgs(List<String> argArgs) {
/*  56 */     this.args_ = argArgs;
/*     */   }
/*     */   
/*     */   public void setExecutable(String argExecutable) {
/*  60 */     this.executable_ = argExecutable;
/*     */   }
/*     */   
/*     */   public void setExecutableDir(File argExecutableDir) {
/*  64 */     this.executableDir_ = argExecutableDir;
/*     */   }
/*     */   
/*     */   public void setWorkingDir(File argWorkingDir) {
/*  68 */     this.workingDir_ = argWorkingDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformedImpl(ActionEvent event) {
/*  76 */     ProcMonitorConfig config = getMonitorConfig();
/*  77 */     if (getMonitor() && !config.allowMultiple() && 
/*  78 */       LaunchedProcessManager.getInstance().isProcessRunning(config.getKey())) {
/*     */       
/*  80 */       logger_.error(FF.getTranslatable("_execOpMsgErrorPrevProcessStillRunning"));
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/*  85 */       StringBuffer cmd = new StringBuffer();
/*  86 */       if (this.executableDir_ != null) {
/*  87 */         if (!this.executableDir_.exists()) {
/*     */           
/*  89 */           IFormattable dirName = FF.getLiteral(this.executableDir_.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
/*  90 */           logger_.error(FF.getTranslatable("_execOpMsgErrorExeDirDoesntExist", new IFormattable[] { dirName }));
/*     */           return;
/*     */         } 
/*  93 */         if (!this.executableDir_.isDirectory()) {
/*     */           
/*  95 */           IFormattable dirName = FF.getLiteral(this.executableDir_.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
/*  96 */           logger_.error(FF.getTranslatable("_execOpMsgErrorExeDirNotADir", new IFormattable[] { dirName }));
/*     */           return;
/*     */         } 
/*  99 */         cmd.append(this.executableDir_.getAbsoluteFile());
/* 100 */         cmd.append(System.getProperty("file.separator"));
/*     */       } 
/* 102 */       List<String> cmdPlusArgs = new ArrayList<>(2 + this.args_.size());
/*     */ 
/*     */       
/* 105 */       boolean first = true;
/* 106 */       for (String piece : StringUtils.split(this.executable_, ' ')) {
/* 107 */         if (!StringUtils.isEmpty(piece) && !first) {
/* 108 */           cmdPlusArgs.add(piece);
/*     */         }
/*     */         
/* 111 */         if (first) {
/* 112 */           cmd.append(piece);
/* 113 */           first = false;
/* 114 */           cmdPlusArgs.add(cmd.toString());
/*     */         } 
/*     */       } 
/* 117 */       for (String arg : this.args_) {
/* 118 */         cmdPlusArgs.add(arg);
/* 119 */         cmd.append(" ").append(arg);
/*     */       } 
/*     */       
/* 122 */       if (logger_.isInfoEnabled()) {
/* 123 */         logger_.info("launching " + cmd);
/*     */       }
/* 125 */       ProcessBuilder pb = new ProcessBuilder(cmdPlusArgs);
/* 126 */       pb.directory(this.workingDir_);
/* 127 */       for (String s : this.env_) {
/* 128 */         String[] parts = StringUtils.split(s, '=');
/* 129 */         pb.environment().put(parts[0], parts[1]);
/*     */       } 
/* 131 */       Process proc = pb.start();
/*     */       
/* 133 */       if (getMonitor()) {
/* 134 */         LaunchedProcessManager.getInstance().monitor((IProcMonitorConfig)config, proc);
/*     */       }
/*     */     }
/* 137 */     catch (IOException ex) {
/* 138 */       logger_.error(FF.getLiteral("Unable to launch program. Error " + ex.getMessage()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ProcMonitorConfig getMonitorConfig() {
/* 144 */     if (this.monitorConfig_ == null) {
/* 145 */       this.monitorConfig_ = new ProcMonitorConfig();
/*     */     }
/* 147 */     return this.monitorConfig_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstExecAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */