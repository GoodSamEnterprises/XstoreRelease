/*     */ package dtv.logbuilder;
/*     */ 
/*     */ import dtv.logbuilder.config.LogDestinationConfig;
/*     */ import dtv.logbuilder.config.LogFileConfig;
/*     */ import dtv.logbuilder.writers.ILogEntryWriter;
/*     */ import dtv.logbuilder.writers.LogEntryWriterFactory;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.TypeSafeMapKey;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class LogEntryWriterGroup
/*     */ {
/*     */   public static LogEntryWriterGroup getGroup(LogFileConfig argConfig, Map<TypeSafeMapKey<?>, Object> argSettings) throws IOException {
/*  42 */     return new LogEntryWriterGroup(argConfig, argSettings);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void putParameters(Map<TypeSafeMapKey<?>, Object> argSettings, Map<String, IConfigObject> argParameters) {
/*  49 */     for (Map.Entry<String, IConfigObject> entry : argParameters.entrySet()) {
/*  50 */       IConfigObject value = entry.getValue();
/*  51 */       if (value instanceof IReflectionParameterCapable) {
/*  52 */         IReflectionParameterCapable rpc = (IReflectionParameterCapable)value;
/*  53 */         TypeSafeMapKey typeSafeMapKey1 = new TypeSafeMapKey(entry.getKey(), rpc.getParamDataType());
/*  54 */         TypeSafeMapKey typeSafeMapKey2 = new TypeSafeMapKey(entry.getKey(), Object.class);
/*  55 */         LogBuilder.putIfMissing(argSettings, typeSafeMapKey1, rpc.getParamValue());
/*  56 */         LogBuilder.putIfMissing(argSettings, typeSafeMapKey2, rpc.getParamValue());
/*     */         
/*     */         continue;
/*     */       } 
/*  60 */       TypeSafeMapKey<IConfigObject> mapKey = new TypeSafeMapKey(entry.getKey(), value.getClass());
/*  61 */       TypeSafeMapKey<IConfigObject> mapKey2 = new TypeSafeMapKey(entry.getKey(), Object.class);
/*  62 */       LogBuilder.putIfMissing(argSettings, mapKey, value);
/*  63 */       LogBuilder.putIfMissing(argSettings, mapKey2, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  68 */   private static final Logger logger_ = Logger.getLogger(LogEntryWriterGroup.class);
/*     */   
/*     */   private ILogEntryWriter[] writers_;
/*     */   
/*     */   private final StringBuilder logInfo_;
/*     */ 
/*     */   
/*     */   private LogEntryWriterGroup(LogFileConfig argConfig, Map<TypeSafeMapKey<?>, Object> argSettings) throws IOException {
/*  76 */     LogDestinationConfig[] logDestinations = argConfig.getLogDestinations();
/*  77 */     LogBuilder.putIfMissing(argSettings, ILogBuilder.ENCODING, argConfig.getEncoding());
/*  78 */     LogBuilder.putIfMissing(argSettings, ILogBuilder.HEADER, argConfig.getHeader());
/*  79 */     LogBuilder.putIfMissing(argSettings, ILogBuilder.FOOTER, argConfig.getFooter());
/*  80 */     this.writers_ = new ILogEntryWriter[logDestinations.length];
/*  81 */     for (int i = 0; i < logDestinations.length; i++) {
/*     */       
/*  83 */       LogDestinationConfig config = logDestinations[i];
/*  84 */       Map<TypeSafeMapKey<?>, Object> settings = new HashMap<>(argSettings);
/*  85 */       LogBuilder.putIfMissing(settings, ILogBuilder.WRITER_IMPL, config.getImplementationClass());
/*  86 */       settings.put(ILogBuilder.CONFIG_SOURCE, config.getSourceDescription());
/*  87 */       putParameters(settings, config.getParameters());
/*     */       try {
/*  89 */         this.writers_[i] = LogEntryWriterFactory.getWriter(settings);
/*     */       }
/*  91 */       catch (IOException ex) {
/*  92 */         if (this.writers_.length == 1) {
/*  93 */           throw ex;
/*     */         }
/*     */         
/*  96 */         logger_.error("CAUGHT EXCEPTION", ex);
/*  97 */         this.writers_ = (ILogEntryWriter[])ArrayUtils.remove((Object[])this.writers_, i);
/*  98 */         i--;
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     this.logInfo_ = new StringBuilder(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 113 */     String logData = this.logInfo_.toString();
/* 114 */     for (int i = 0; i < this.writers_.length; i++) {
/*     */       try {
/* 116 */         this.writers_[i].write(logData);
/* 117 */         this.writers_[i].close();
/*     */       }
/* 119 */       catch (IOException ex) {
/* 120 */         if (this.writers_.length == 1) {
/* 121 */           throw ex;
/*     */         }
/*     */         
/* 124 */         logger_.error("CAUGHT EXCEPTION", ex);
/* 125 */         this.writers_ = (ILogEntryWriter[])ArrayUtils.remove((Object[])this.writers_, i);
/* 126 */         i--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(String argString) {
/* 138 */     this.logInfo_.append(argString);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LogEntryWriterGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */