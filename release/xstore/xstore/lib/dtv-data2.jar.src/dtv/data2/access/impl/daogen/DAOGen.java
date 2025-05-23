/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.FileUtils;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ public class DAOGen
/*     */   implements Callable<Void>
/*     */ {
/*  25 */   private static final Logger logger_ = LogManager.getLogger(DAOGen.class);
/*     */   
/*     */   private final Collection<? extends File> _baseDirs;
/*     */   
/*     */   private final File _inDir;
/*     */   
/*     */   private final File _outDir;
/*     */   private final File _cleanbeanOutDir;
/*     */   private final File _sourcesDir;
/*     */   private final File _tempDir;
/*     */   private final boolean _overrideMode;
/*     */   private final String _overrideType;
/*     */   private final String _overrideExtends;
/*     */   
/*     */   public DAOGen(Collection<? extends File> argBaseDirs, File inDir, File outDir, File cleanbeanOutDir, File sourcesDir, File tempDir, boolean argOverrideMode, String argOverrideType, String argOverrideExtends) {
/*  40 */     this._baseDirs = argBaseDirs;
/*  41 */     this._inDir = inDir;
/*  42 */     this._outDir = outDir;
/*  43 */     this._cleanbeanOutDir = cleanbeanOutDir;
/*  44 */     this._sourcesDir = sourcesDir;
/*  45 */     this._tempDir = tempDir;
/*  46 */     this._overrideMode = argOverrideMode;
/*  47 */     this._overrideType = argOverrideType;
/*  48 */     this._overrideExtends = argOverrideExtends;
/*     */   }
/*     */ 
/*     */   
/*     */   public DAOGen(File inDir, File outDir, File cleanbeanOutDir, File sourcesDir, File tempDir, boolean argOverrideMode) {
/*  53 */     this(null, inDir, outDir, cleanbeanOutDir, sourcesDir, tempDir, argOverrideMode, "", "");
/*     */   }
/*     */ 
/*     */   
/*     */   public DAOGen(File inDir, File outDir, File cleanbeanOutDir, File sourcesDir, File tempDir, boolean argOverrideMode, String argOverrideType, String argOverrideExtends) {
/*  58 */     this(null, inDir, outDir, cleanbeanOutDir, sourcesDir, tempDir, argOverrideMode, argOverrideType, argOverrideExtends);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws Exception {
/*  65 */     long startTime = System.currentTimeMillis();
/*     */     
/*  67 */     try (DaoGenHelper helper = DaoGenHelper.create()) {
/*  68 */       helper.setBaseInDirs(this._baseDirs);
/*  69 */       helper.setInDir(this._inDir);
/*  70 */       helper.setOutDir(this._outDir);
/*  71 */       helper.setCleanbeanOutDir(this._cleanbeanOutDir);
/*  72 */       helper.setSourcesDir(this._sourcesDir);
/*  73 */       helper.setTempDir(this._tempDir);
/*  74 */       helper.setOverrideMode(this._overrideMode);
/*  75 */       helper.setOverrideType(this._overrideType);
/*  76 */       helper.setOverrideExtends(this._overrideExtends);
/*     */       
/*  78 */       logger_.info("Input coming from '" + helper.getInPath() + "'");
/*  79 */       logger_.info("Output going to '" + helper.getOutPath() + "'");
/*  80 */       if (helper.getCleanbeanOutPath() != null) {
/*  81 */         logger_.info("Cleanbean output going to '" + helper.getCleanbeanOutPath() + "'");
/*     */       } else {
/*     */         
/*  84 */         logger_.info("Cleanbean generation not enabled.");
/*     */       } 
/*     */ 
/*     */       
/*  88 */       List<File> files = FileUtils.getFiles(helper.getInDir(), "dtx");
/*     */       
/*  90 */       helper.preLoad(files, true);
/*     */       
/*  92 */       for (File dir : helper.getBaseInDirs()) {
/*  93 */         List<File> baseFiles = FileUtils.getFiles(dir, "dtx");
/*  94 */         helper.preLoad(baseFiles, false);
/*     */       } 
/*     */       
/*  97 */       helper.load();
/*     */ 
/*     */       
/* 100 */       (new GenerateInterfaces(helper)).call();
/* 101 */       (new GenerateDaoAndDba(helper)).call();
/* 102 */       (new GenerateRelationships(helper)).call();
/* 103 */       (new GenerateIds(helper)).call();
/*     */ 
/*     */       
/* 106 */       helper.getWriter().flush();
/* 107 */       helper.precompile();
/*     */ 
/*     */ 
/*     */       
/* 111 */       GenerateOrgHierarchyTableList orgHierarchyTableList = GenerateOrgHierarchyTableList.createInstance(helper);
/* 112 */       orgHierarchyTableList.call();
/*     */       
/* 114 */       GenerateConfigElementTableList configElementTableList = GenerateConfigElementTableList.createInstance(helper);
/* 115 */       configElementTableList.call();
/*     */       
/* 117 */       (new GenerateXmlSchemas(helper)).call();
/* 118 */       if (helper.getCleanbeanOutPath() != null) {
/* 119 */         (new GenerateCleanbean(helper)).call();
/*     */       }
/* 121 */       GenerateJDBCMapping mapping = GenerateJDBCMapping.getInstance();
/* 122 */       mapping.setHelper(helper);
/* 123 */       mapping.call();
/*     */       
/* 125 */       (new GenerateModels(helper)).call();
/*     */       
/* 127 */       GenerateDataModelFactoryImpl modelFactory = GenerateDataModelFactoryImpl.getInstance();
/* 128 */       modelFactory.setHelper(helper);
/* 129 */       modelFactory.call();
/*     */     }
/* 131 */     catch (Exception ee) {
/*     */       
/* 133 */       logger_.error("Error: " + ee.getMessage(), ee);
/*     */       
/* 135 */       System.out.println("Error: " + ee.getMessage() + ee.getMessage());
/* 136 */       ee.printStackTrace();
/*     */       
/* 138 */       throw ee;
/*     */     } 
/*     */     
/* 141 */     long totalTime = System.currentTimeMillis() - startTime;
/* 142 */     logger_.info("DAO Generation completed in: " + totalTime + "ms");
/* 143 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DAOGen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */