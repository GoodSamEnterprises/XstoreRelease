/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.data2.access.DataModelFactory;
/*     */ import dtv.data2.access.impl.jdbc.JDBCAdapterMap;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.core.config.Configuration;
/*     */ import org.apache.logging.log4j.core.config.ConfigurationFactory;
/*     */ import org.apache.logging.log4j.core.config.ConfigurationSource;
/*     */ import org.apache.logging.log4j.core.config.DefaultConfiguration;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.apache.tools.ant.Task;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DAOGenAnt
/*     */   extends Task
/*     */ {
/*     */   static {
/*  29 */     final DefaultConfiguration log4jConfig = new DefaultConfiguration();
/*  30 */     defaultConfiguration.getRootLogger().setLevel(Level.INFO);
/*  31 */     ConfigurationFactory factory = new ConfigurationFactory()
/*     */       {
/*     */         public Configuration getConfiguration(ConfigurationSource argSource) {
/*  34 */           return log4jConfig;
/*     */         }
/*     */ 
/*     */         
/*     */         public Configuration getConfiguration(String name, URI configLocation) {
/*  39 */           return log4jConfig;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public Configuration getConfiguration(String name, URI configLocation, ClassLoader loader) {
/*  45 */           return log4jConfig;
/*     */         }
/*     */ 
/*     */         
/*     */         protected String[] getSupportedTypes() {
/*  50 */           return null;
/*     */         }
/*     */       };
/*  53 */     ConfigurationFactory.setConfigurationFactory(factory);
/*     */   }
/*     */   
/*  56 */   private final Collection<File> baseDirs_ = new ArrayList<>();
/*  57 */   private File destDir_ = null;
/*  58 */   private File cleanbeanDestDir_ = null;
/*  59 */   private File dir_ = null;
/*  60 */   private File tempDir_ = null;
/*  61 */   private File sourcesDir_ = null;
/*  62 */   private String adapterMapName_ = null;
/*  63 */   private String dataModelFactoryName_ = null;
/*     */   private boolean overrideMode_ = false;
/*  65 */   private String overrideType_ = "Customer";
/*  66 */   private String overrideExtends_ = "Country";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() throws BuildException {
/*  72 */     if (!this.dir_.exists()) {
/*  73 */       throw new BuildException("Source directory does not exist!");
/*     */     }
/*     */     
/*  76 */     if (this.destDir_ == null) {
/*  77 */       this.destDir_ = this.dir_;
/*     */     }
/*  79 */     if (!this.destDir_.exists()) {
/*  80 */       throw new BuildException("Destination directory does not exist!");
/*     */     }
/*  82 */     if (this.tempDir_ == null || !this.tempDir_.exists()) {
/*  83 */       throw new BuildException("tempdir attribute must be specified and must reference a path that exists!");
/*     */     }
/*     */     
/*     */     try {
/*  87 */       DAOGen phase1 = new DAOGen(this.baseDirs_, this.dir_, this.destDir_, this.cleanbeanDestDir_, this.sourcesDir_, this.tempDir_, this.overrideMode_, this.overrideType_, this.overrideExtends_);
/*     */       
/*  89 */       phase1.call();
/*     */     }
/*  91 */     catch (Exception ex) {
/*  92 */       throw new BuildException("Could not complete DAO generation.", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAdapterMapName(String argAdapterMapname) {
/* 102 */     this.adapterMapName_ = argAdapterMapname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseDir(String argDirs) {
/* 111 */     for (String dir : StringUtils.split(argDirs, ';')) {
/* 112 */       this.baseDirs_.add((new File(dir)).getAbsoluteFile());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCleanbeanDest(File argCleanbeanDest) {
/* 122 */     this.cleanbeanDestDir_ = argCleanbeanDest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataModelFactoryName(String argDataModelFactoryName) {
/* 131 */     this.dataModelFactoryName_ = argDataModelFactoryName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDest(File argDest) {
/* 140 */     this.destDir_ = argDest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDir(File argDir) {
/* 149 */     this.dir_ = argDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverrideExtends(String argOverrideExtends) {
/* 157 */     this.overrideExtends_ = argOverrideExtends;
/*     */   }
/*     */   
/*     */   public void setOverrideMode(boolean argOverrideMode) {
/* 161 */     this.overrideMode_ = argOverrideMode;
/* 162 */     if (this.overrideMode_) {
/* 163 */       System.setProperty(DaoGenHelper.class.getName(), DaoGenOverrideHelper.class.getName());
/*     */       
/* 165 */       System.setProperty(GenerateDataModelFactoryImpl.class.getName(), GenerateDataModelFactoryOverride.class
/* 166 */           .getName());
/*     */       
/* 168 */       System.setProperty(GenerateJDBCMapping.class.getName(), GenerateJDBCMappingOverride.class.getName());
/*     */       
/* 170 */       System.setProperty(GenerateConfigElementTableList.class.getName(), GenerateConfigElementTableListOverride.class
/* 171 */           .getName());
/*     */       
/* 173 */       System.setProperty(GenerateOrgHierarchyTableList.class.getName(), GenerateOrgHierarchyTableListOverride.class
/* 174 */           .getName());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverrideType(String argOverrideType) {
/* 183 */     this.overrideType_ = argOverrideType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourcesDir(File argSourcesDir) {
/* 191 */     this.sourcesDir_ = argSourcesDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempDir(File argTempDir) {
/* 199 */     this.tempDir_ = argTempDir;
/*     */   }
/*     */   
/*     */   public void setUsePackageSpace(boolean argUniquePackage) {
/* 203 */     if (argUniquePackage) {
/* 204 */       if (this.adapterMapName_ != null) {
/* 205 */         System.setProperty(JDBCAdapterMap.class.getName(), this.adapterMapName_);
/*     */       }
/*     */       
/* 208 */       if (this.dataModelFactoryName_ != null)
/* 209 */         System.setProperty(DataModelFactory.class.getName(), this.dataModelFactoryName_); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DAOGenAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */