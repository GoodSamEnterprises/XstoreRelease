/*     */ package dtv.logbuilder.config;
/*     */ 
/*     */ import dtv.docbuilding.IDocBuilder;
/*     */ import dtv.docbuilding.config.DocBuilderConfigHelper;
/*     */ import dtv.docbuilding.config.DocBuilderSectionMapConfig;
/*     */ import dtv.docbuilding.config.DocConfig;
/*     */ import dtv.logbuilder.LogDocElementFactory;
/*     */ import dtv.logbuilder.config.reload.LogBuilderConfigReloader;
/*     */ import dtv.logbuilder.routing.RoutingRequestList;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class LogConfigHelper
/*     */   extends DocBuilderConfigHelper
/*     */ {
/*  24 */   private static final LogBuilderConfigReloader LOG_BUILDER_CONFIG_RELOADER = new LogBuilderConfigReloader();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilder<?> getLayout(String argType) {
/*  33 */     return ((LogDefsConfig)getRootConfig()).getDocListConfig().getBuilder(argType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogFileConfig getLogFile(String argFileId) {
/*  43 */     return ((LogDefsConfig)getRootConfig()).getLogFiles().getLogFile(argFileId);
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
/*     */   public RoutingRequestList getRoutingRequests(Object argSource) {
/*  55 */     if (LOG_BUILDER_CONFIG_RELOADER.reloadIfNeeded()) {
/*  56 */       this.rootConfig_ = null;
/*  57 */       initialize();
/*     */     } 
/*  59 */     return ((LogDefsConfig)getRootConfig()).getRoutingRules().getRoutingRequests(argSource);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/*  65 */     super.initializeImpl();
/*     */     
/*  67 */     LogDefsConfig rootConfig = (LogDefsConfig)getRootConfig();
/*     */     
/*  69 */     DocBuilderSectionMapConfig sectionConfig = rootConfig.getSectionsConfig();
/*  70 */     sectionConfig.initialize(LogDocElementFactory.getInstance(), rootConfig.getFormatterMap());
/*  71 */     rootConfig.getDocListConfig().initialize(sectionConfig.getSections());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/*  81 */     return "log";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String dtype, IConfigObject argParent, String argSourceDescription) {
/*  89 */     if (argParent instanceof LogDefsConfig) {
/*  90 */       IConfigObject c; LogDefsConfig parent = (LogDefsConfig)argParent;
/*     */       
/*  92 */       if ("LogFiles".equalsIgnoreCase(dtype)) {
/*  93 */         LogFilesConfig logFilesConfig = parent.getLogFiles();
/*     */       }
/*  95 */       else if ("RoutingRules".equalsIgnoreCase(dtype)) {
/*  96 */         RoutingRulesConfig routingRulesConfig = parent.getRoutingRules();
/*     */       } else {
/*     */         
/*  99 */         c = null;
/*     */       } 
/* 101 */       if (c != null) {
/* 102 */         return c;
/*     */       }
/*     */     } 
/* 105 */     return super.getConfigObject(argTagName, dtype, argParent, argSourceDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 111 */     if (dtype != null) {
/* 112 */       if ("LogDefinitions".equalsIgnoreCase(dtype)) {
/* 113 */         return (IConfigObject)new LogDefsConfig();
/*     */       }
/* 115 */       if ("RoutingRule".equalsIgnoreCase(dtype)) {
/* 116 */         return (IConfigObject)new RoutingRuleConfig();
/*     */       }
/* 118 */       if ("RoutingRules".equalsIgnoreCase(dtype)) {
/* 119 */         return (IConfigObject)new RoutingRulesConfig();
/*     */       }
/* 121 */       if ("LogFiles".equalsIgnoreCase(dtype)) {
/* 122 */         return (IConfigObject)new LogFilesConfig();
/*     */       }
/* 124 */       if ("LogFile".equalsIgnoreCase(dtype)) {
/* 125 */         return (IConfigObject)new LogFileConfig();
/*     */       }
/* 127 */       if ("Destination".equalsIgnoreCase(dtype)) {
/* 128 */         return (IConfigObject)new LogDestinationConfig();
/*     */       }
/* 130 */       if ("log_type".equalsIgnoreCase(dtype) || "LogType".equalsIgnoreCase(dtype)) {
/* 131 */         return (IConfigObject)new DocConfig();
/*     */       }
/*     */     } 
/* 134 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDirectoryBased() {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDocListConfig(String argDtype) {
/* 146 */     if ("log_types".equalsIgnoreCase(argDtype) || "LogTypes".equalsIgnoreCase(argDtype)) {
/* 147 */       return true;
/*     */     }
/* 149 */     return super.isDocListConfig(argDtype);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\config\LogConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */