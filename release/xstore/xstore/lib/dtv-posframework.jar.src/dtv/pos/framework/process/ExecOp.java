/*     */ package dtv.pos.framework.process;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.op.Operation;
/*     */ import dtv.pos.iframework.IBusyState;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.FileConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExecOp
/*     */   extends Operation
/*     */ {
/* 133 */   private static final Logger logger_ = Logger.getLogger(ExecOp.class);
/*     */   
/*     */   @Inject
/*     */   private IBusyState _busyState;
/*     */   
/*     */   private File executableDir_;
/*     */   private String executable_;
/* 140 */   protected List<String> args_ = new ArrayList<>();
/*     */   private File workingDir_;
/* 142 */   private final List<String> env_ = new ArrayList<>();
/*     */   
/*     */   private ProcMonitorConfig monitorConfig_;
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 148 */     ProcMonitorConfig config = getMonitorConfig();
/*     */     
/* 150 */     if (!config.allowMultiple() && 
/* 151 */       LaunchedProcessManager.getInstance().isProcessRunning(config.getKey()))
/*     */     {
/* 153 */       return handleError(this._formattables.getTranslatable("_execOpMsgErrorPrevProcessStillRunning"));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 158 */       StringBuffer str = new StringBuffer();
/*     */       
/* 160 */       if (this.executableDir_ != null) {
/* 161 */         if (!this.executableDir_.exists()) {
/*     */           
/* 163 */           IFormattable dirName = this._formattables.getLiteral(this.executableDir_.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
/* 164 */           return handleError(this._formattables.getTranslatable("_execOpMsgErrorExeDirDoesntExist", new IFormattable[] { dirName }));
/*     */         } 
/*     */         
/* 167 */         if (!this.executableDir_.isDirectory()) {
/*     */           
/* 169 */           IFormattable dirName = this._formattables.getLiteral(this.executableDir_.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
/* 170 */           return handleError(this._formattables.getTranslatable("_execOpMsgErrorExeDirNotADir", new IFormattable[] { dirName }));
/*     */         } 
/*     */         
/* 173 */         str.append(this.executableDir_.getAbsoluteFile());
/* 174 */         str.append(System.getProperty("file.separator"));
/*     */       } 
/*     */       
/* 177 */       str.append(this.executable_);
/* 178 */       String[] strPlusArgs = new String[1 + this.args_.size()];
/* 179 */       strPlusArgs[0] = str.toString();
/*     */       
/* 181 */       for (int i = 0; i < this.args_.size(); i++) {
/* 182 */         String arg = this.args_.get(i);
/* 183 */         strPlusArgs[i + 1] = arg;
/* 184 */         str.append(" ").append(arg);
/*     */       } 
/*     */       
/* 187 */       if (logger_.isInfoEnabled()) {
/* 188 */         logger_.info("launching " + str);
/*     */       }
/*     */       
/* 191 */       ProcessBuilder pb = new ProcessBuilder(strPlusArgs);
/* 192 */       pb.directory(this.workingDir_);
/*     */       
/* 194 */       for (String s : this.env_) {
/* 195 */         String[] parts = StringUtils.split(s, '=');
/* 196 */         pb.environment().put(parts[0], parts[1]);
/*     */       } 
/*     */       
/* 199 */       Process proc = pb.start();
/* 200 */       LaunchedProcessManager.getInstance().monitor(config, proc);
/*     */       
/* 202 */       if (config.waitForExit()) {
/* 203 */         this._busyState.start(null);
/* 204 */         int exitValue = -1;
/*     */         
/*     */         try {
/* 207 */           exitValue = proc.waitFor();
/*     */         }
/* 209 */         catch (InterruptedException ex) {
/* 210 */           logger_.error("INTERRUPTED WAITING FOR PROCESS EXIT", ex);
/*     */         } 
/*     */         
/* 213 */         if (0 != exitValue && !config.continueOnError()) {
/* 214 */           return this.HELPER.silentErrorResponse();
/*     */         }
/*     */       } 
/*     */       
/* 218 */       return this.HELPER.completeResponse();
/*     */     }
/* 220 */     catch (IOException ex) {
/* 221 */       return handleError(this._formattables.getLiteral("Unable to launch program. Error " + ex.getMessage()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 233 */     if ("processKey".equalsIgnoreCase(argName)) {
/* 234 */       getMonitorConfig().setKey(argValue);
/*     */     }
/* 236 */     else if ("executable".equalsIgnoreCase(argName)) {
/* 237 */       this.executable_ = argValue;
/*     */     }
/* 239 */     else if ("arg".equalsIgnoreCase(argName)) {
/* 240 */       this.args_.add(argValue);
/*     */     }
/* 242 */     else if ("executableDir".equalsIgnoreCase(argName)) {
/* 243 */       FileConfig config = new FileConfig(argValue);
/* 244 */       this.executableDir_ = ConfigUtils.toFile((IConfigObject)config);
/*     */     }
/* 246 */     else if ("workingDir".equalsIgnoreCase(argName)) {
/* 247 */       FileConfig config = new FileConfig(argValue);
/* 248 */       this.workingDir_ = ConfigUtils.toFile((IConfigObject)config);
/*     */     }
/* 250 */     else if ("env".equalsIgnoreCase(argName)) {
/* 251 */       this.env_.add(argValue);
/*     */     }
/* 253 */     else if ("outputFile".equalsIgnoreCase(argName)) {
/* 254 */       FileConfig config = new FileConfig(argValue);
/* 255 */       getMonitorConfig().setOutputFile(ConfigUtils.toFile((IConfigObject)config));
/*     */     }
/* 257 */     else if ("appendOutput".equalsIgnoreCase(argName)) {
/* 258 */       getMonitorConfig().setAppendOutputfile(ConfigUtils.toBoolean(argValue).booleanValue());
/*     */     }
/* 260 */     else if ("allowMultiple".equalsIgnoreCase(argName)) {
/* 261 */       getMonitorConfig().setAllowMultiple(ConfigUtils.toBoolean(argValue).booleanValue());
/*     */     }
/* 263 */     else if ("continueOnError".equalsIgnoreCase(argName)) {
/* 264 */       getMonitorConfig().setContinueOnError(ConfigUtils.toBoolean(argValue).booleanValue());
/*     */     }
/* 266 */     else if ("waitForExit".equalsIgnoreCase(argName)) {
/* 267 */       getMonitorConfig().setWaitForExit(ConfigUtils.toBoolean(argValue).booleanValue());
/*     */     } else {
/*     */       
/* 270 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ProcMonitorConfig getMonitorConfig() {
/* 275 */     if (this.monitorConfig_ == null) {
/* 276 */       this.monitorConfig_ = new ProcMonitorConfig();
/*     */     }
/*     */     
/* 279 */     return this.monitorConfig_;
/*     */   }
/*     */   
/*     */   protected IOpResponse handleError(IFormattable argMsg) {
/* 283 */     ProcMonitorConfig config = getMonitorConfig();
/*     */     
/* 285 */     if (config.continueOnError()) {
/* 286 */       return this.HELPER.completeResponse();
/*     */     }
/*     */     
/* 289 */     return this.HELPER.getErrorResponse(argMsg);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\process\ExecOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */