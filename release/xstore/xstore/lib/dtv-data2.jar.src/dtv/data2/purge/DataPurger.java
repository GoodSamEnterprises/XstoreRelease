/*     */ package dtv.data2.purge;
/*     */ 
/*     */ import dtv.data2.purge.config.IPurgeConfig;
/*     */ import dtv.data2.purge.config.IPurgeParentConfig;
/*     */ import dtv.data2.purge.config.PurgeConfigHelper;
/*     */ import dtv.util.ClassPathUtils;
/*     */ import dtv.util.EndsWithNameFilter;
/*     */ import dtv.util.INameFilter;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import dtv.util.config.SystemPropertiesLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.context.support.ClassPathXmlApplicationContext;
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
/*     */ public class DataPurger
/*     */   implements Callable<Void>
/*     */ {
/*  33 */   private static final Logger _logger = Logger.getLogger(DataPurger.class);
/*  34 */   private static final Collection<ParameterConfig> _argParameters = new ArrayList<>();
/*     */   
/*  36 */   private static String _argPurgeGroup = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String SPRING_DEFAULT_ACTIVE_PROFILES = "datapurger";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String _purgeGroup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  57 */     parseArgs(args);
/*     */     
/*  59 */     (new SystemPropertiesLoader()).loadSystemProperties();
/*     */ 
/*     */     
/*  62 */     String springProfiles = System.getProperty("spring.profiles.active");
/*     */     
/*  64 */     if (springProfiles == null) {
/*  65 */       System.setProperty("spring.profiles.active", "datapurger");
/*     */     }
/*     */ 
/*     */     
/*  69 */     String[] files = ClassPathUtils.getDirectoryBasedConfigFileListRelativePaths("spring", (INameFilter)new EndsWithNameFilter(new String[] { ".xml" }));
/*     */ 
/*     */     
/*  72 */     try (ClassPathXmlApplicationContext null = new ClassPathXmlApplicationContext(files)) {
/*     */ 
/*     */       
/*  75 */       (new DataPurger(_argPurgeGroup)).call();
/*     */     } 
/*  77 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void parseArgs(String[] args) {
/*  82 */     for (int i = 0; i < args.length; i++) {
/*  83 */       String arg = args[i];
/*     */       
/*  85 */       if (!arg.startsWith("-")) {
/*  86 */         System.err.println("error: unexpected argument -- " + arg);
/*  87 */         printUsage();
/*  88 */         System.exit(1);
/*     */       } 
/*     */       
/*  91 */       if (arg.equals("-group")) {
/*  92 */         _argPurgeGroup = args[++i];
/*     */       }
/*     */       else {
/*     */         
/*  96 */         _argParameters.add(new ParameterConfig(arg.substring(1), (IConfigObject)new StringConfig(args[++i])));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void printUsage() {
/* 103 */     System.out.println("Usage: java " + DataPurger.class.getName() + "[-group <purge group>]");
/* 104 */     System.exit(1);
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
/*     */   
/*     */   public DataPurger(String argPurgeGroup) {
/* 117 */     this._purgeGroup = argPurgeGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws Exception {
/* 126 */     IPurgeParentConfig<?> purgeRoot = (IPurgeParentConfig)(new PurgeConfigHelper()).getRootConfig();
/* 127 */     IPurgeConfig purgeToRun = getPurgeToRun(purgeRoot);
/*     */     
/* 129 */     String description = purgeToRun.getDescription();
/*     */     
/* 131 */     _logger.info("**********************************************");
/* 132 */     _logger.info("***** START: Purge [" + description + "] *****");
/* 133 */     _logger.info("**********************************************");
/* 134 */     PurgeMetaData purgeData = (PurgeMetaData)purgeToRun.call();
/* 135 */     _logger.info("**********************************************");
/* 136 */     _logger.info("***** END: Purge [" + description + "]: Results = [" + purgeData + "] *****");
/* 137 */     _logger.info("**********************************************");
/*     */     
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IPurgeConfig getPurgeToRun(IPurgeParentConfig<?> argPurgeRoot) {
/*     */     IPurgeConfig iPurgeConfig;
/* 150 */     IPurgeParentConfig<?> iPurgeParentConfig = argPurgeRoot;
/*     */     
/* 152 */     if (!StringUtils.isEmpty(this._purgeGroup)) {
/*     */       
/* 154 */       IPurgeConfig purgeGroupToRun = argPurgeRoot.getChild(this._purgeGroup);
/* 155 */       if (purgeGroupToRun != null) {
/* 156 */         iPurgeConfig = purgeGroupToRun;
/*     */       }
/*     */     } 
/*     */     
/* 160 */     for (ParameterConfig param : _argParameters) {
/* 161 */       iPurgeConfig.setParameter(param);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 166 */     iPurgeConfig.setEnabled(true);
/*     */     
/* 168 */     return iPurgeConfig;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\DataPurger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */