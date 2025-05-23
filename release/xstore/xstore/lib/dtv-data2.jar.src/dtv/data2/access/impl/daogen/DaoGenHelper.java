/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.FileUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.tools.JavaCompiler;
/*     */ import javax.tools.JavaFileObject;
/*     */ import javax.tools.StandardJavaFileManager;
/*     */ import javax.tools.ToolProvider;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.tools.ant.AntClassLoader;
/*     */ 
/*     */ public class DaoGenHelper
/*     */   implements AutoCloseable
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(DaoGenHelper.class);
/*     */ 
/*     */   
/*     */   public static DaoGenHelper create() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
/*  34 */     String className = System.getProperty(DaoGenHelper.class.getName(), DaoGenHelper.class.getName());
/*  35 */     return (DaoGenHelper)Class.forName(className).newInstance();
/*     */   }
/*     */   
/*     */   public static String getPropertyInterfaceName(DtxDefinition argParentDtx) {
/*  39 */     return argParentDtx.getInterface() + "Property";
/*     */   }
/*     */   
/*     */   public static String getPropertyName(DtxDefinition argParentDtx) {
/*  43 */     return argParentDtx.getName() + "Property";
/*     */   }
/*     */   
/*     */   public static boolean isPropertyChildNeeded(DtxDefinition argParentDtx) {
/*  47 */     boolean propertyTableNeeded = false;
/*     */     
/*  49 */     if (!argParentDtx.isExtended() && !argParentDtx.isCustomerExtension() && !argParentDtx.isProperties() && (argParentDtx
/*  50 */       .getPrimaryKeyFields()).length > 0) {
/*  51 */       DtxDefinition.DtxDaoField orgId = argParentDtx.findField("organizationId");
/*  52 */       if (orgId != null && orgId.isPrimaryKey()) {
/*  53 */         propertyTableNeeded = true;
/*     */       }
/*     */     } 
/*  56 */     return propertyTableNeeded;
/*     */   }
/*     */   
/*  59 */   protected List<DtxDefinition> dtxDefinitions_ = new ArrayList<>();
/*     */   
/*  61 */   protected Map<String, DtxDefinition> typeNameToDefinition_ = new HashMap<>(300);
/*  62 */   private final Collection<File> baseInDirs_ = new ArrayList<>();
/*  63 */   private final Collection<String> baseInPaths_ = new ArrayList<>();
/*     */   
/*  65 */   private final DAOFileWriter writer_ = new DAOFileWriter();
/*  66 */   private File inDir_ = null;
/*  67 */   private File outDir_ = null;
/*  68 */   private File tempDir_ = null;
/*  69 */   private File sourcesDir_ = null;
/*  70 */   private String inPath_ = null;
/*  71 */   private String outPath_ = null;
/*  72 */   private String cleanbeanOutPath_ = null;
/*     */   private boolean overrideMode_ = false;
/*  74 */   private String overrideType_ = "";
/*  75 */   private String overrideExtends_ = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private URLClassLoader precompileClassloader_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPropertyDefinitions() {
/*  86 */     List<DtxDefinition> dtxPropertyDefs = new ArrayList<>();
/*     */     
/*  88 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/*  89 */       if (isPropertyChildNeeded(dtx)) {
/*     */         
/*  91 */         DtxDefinition dtxProp = getPropertyDtxDefinition(dtx);
/*  92 */         dtxPropertyDefs.add(dtxProp);
/*  93 */         this.typeNameToDefinition_.put(dtxProp.getName(), dtxProp);
/*     */         
/*  95 */         DtxRelationship propertyRelationship = new DtxRelationship();
/*  96 */         propertyRelationship.setName("Properties");
/*  97 */         propertyRelationship.setChildName(getPropertyName(dtx));
/*  98 */         propertyRelationship.setChild(dtxProp);
/*  99 */         propertyRelationship.setType(DtxRelationship.ONE_MANY);
/* 100 */         propertyRelationship.setPropertyRelationship(true);
/*     */         
/* 102 */         for (DtxDefinition.DtxDaoField key : dtx.getPrimaryKeyFields()) {
/* 103 */           propertyRelationship.getClass(); DtxRelationship.DtxRelationshipField relationField = new DtxRelationship.DtxRelationshipField(propertyRelationship);
/* 104 */           relationField.setParent(key.getName());
/* 105 */           relationField.setChild(key.getName());
/*     */           
/* 107 */           propertyRelationship.addField(relationField);
/*     */         } 
/*     */         
/* 110 */         dtx.addRelationship(propertyRelationship);
/*     */       } 
/*     */     } 
/*     */     
/* 114 */     this.dtxDefinitions_.addAll(dtxPropertyDefs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws Exception {
/* 121 */     this.writer_.close();
/* 122 */     if (this.precompileClassloader_ != null) {
/* 123 */       this.precompileClassloader_.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean doesExtendsEqualType() {
/* 128 */     return getOverrideType().equalsIgnoreCase(getOverrideExtends());
/*     */   }
/*     */   
/*     */   public Collection<File> getBaseInDirs() {
/* 132 */     return this.baseInDirs_;
/*     */   }
/*     */   
/*     */   public Collection<String> getBaseInPaths() {
/* 136 */     return this.baseInPaths_;
/*     */   }
/*     */   
/*     */   public String getClassComment(String argClassComment) {
/* 140 */     return "\n/**\n * " + argClassComment + "<br>\n *\n * @author DAOGen\n */\n";
/*     */   }
/*     */   
/*     */   public String getClassCommentWithSuppressWarnings(String argClassComment) {
/* 144 */     return getClassComment(argClassComment) + "@SuppressWarnings(\"all\")\n";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCleanbeanOutPath() {
/* 151 */     return this.cleanbeanOutPath_;
/*     */   }
/*     */   
/*     */   public List<DtxDefinition> getDtxDefinitions() {
/* 155 */     return this.dtxDefinitions_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFilePath(DtxDefinition argDtx) throws IOException {
/* 161 */     String canPath = argDtx.getSourceDtxFile().getParentFile().getCanonicalPath();
/* 162 */     if (canPath.startsWith(this.inPath_)) {
/* 163 */       return argDtx.getSourceDtxFile().getParentFile().getCanonicalPath().substring(this.inPath_.length()) + File.separator;
/*     */     }
/*     */ 
/*     */     
/* 167 */     for (String path : getBaseInPaths()) {
/* 168 */       if (canPath.startsWith(path)) {
/* 169 */         return argDtx.getSourceDtxFile().getParentFile().getCanonicalPath().substring(path.length()) + File.separator;
/*     */       }
/*     */     } 
/*     */     
/* 173 */     throw new RuntimeException("Cannot translate path: " + canPath);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFilePathCleanbean(DtxDefinition argDtx) {
/* 179 */     String s = argDtx.getCleanbeanPackageRaw();
/* 180 */     String path = s.replace('.', File.separatorChar);
/* 181 */     return File.separator + path + File.separator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getInDir() {
/* 188 */     return this.inDir_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInPath() {
/* 195 */     return this.inPath_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getOutDir() {
/* 202 */     return this.outDir_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOutPath() {
/* 209 */     return this.outPath_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOverrideExtends() {
/* 216 */     return this.overrideExtends_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOverrideType() {
/* 223 */     return this.overrideType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassLoader getPrecompileClassloader() {
/* 231 */     return this.precompileClassloader_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSourcesDir() {
/* 239 */     return this.sourcesDir_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getTempDir() {
/* 247 */     return this.tempDir_;
/*     */   }
/*     */   
/*     */   public DtxDefinition getTypeNameDefinition(String argTypeName) {
/* 251 */     return this.typeNameToDefinition_.get(argTypeName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DAOFileWriter getWriter() {
/* 259 */     return this.writer_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOverrideMode() {
/* 266 */     return this.overrideMode_;
/*     */   }
/*     */   
/*     */   public void load() {
/* 270 */     addPropertyDefinitions();
/* 271 */     setupRelationships();
/* 272 */     optionalValidate();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     for (DtxDefinition dd : this.dtxDefinitions_) {
/* 278 */       dd.validate();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/* 286 */       DtxInverseRelationship[] inverseRelationships = dtx.getInverseRelationships();
/*     */       
/* 288 */       for (DtxInverseRelationship ir : inverseRelationships) {
/* 289 */         DtxDefinition dtxParent = ir.getParent();
/* 290 */         boolean ok = false;
/*     */         
/* 292 */         for (DtxRelationship relationship : dtxParent.getRelationships()) {
/* 293 */           if (relationship.getChild().getName().equals(dtx.getName())) {
/* 294 */             ok = true;
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 303 */         if (!ok && !dtx.getName().equals("TaxRateRuleOverride")) {
/* 304 */           throw new RuntimeException("dtx: " + dtx.getName() + " has an inverse relationship: " + ir.getName() + " which points to a parent: " + ir
/* 305 */               .getParentType() + " BUT THAT PARENT DOES NOT HAVE " + dtx
/* 306 */               .getName() + " as a child in any relationship.");
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     ensureUniqueNames(this.dtxDefinitions_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/* 321 */       if (dtx.isExtended() && dtx.getTable().equals(dtx.getExtends().getTable()) && (
/* 322 */         dtx.getFields()).length > 0) {
/* 323 */         throw new RuntimeException("DTX: " + dtx
/* 324 */             .getName() + " is in error. When a derived DTX points to the same table as his parent, he is not allowed to declare new fields.");
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 334 */     Comparator<DtxDefinition> comparator = new Comparator<DtxDefinition>()
/*     */       {
/*     */         public int compare(DtxDefinition argO1, DtxDefinition argO2) {
/* 337 */           String domain1 = argO1.getPackageDomain();
/*     */           
/* 339 */           boolean priority1 = (domain1.equals("trl") || domain1.equals("trn") || domain1.equals("tsn") || domain1.equals("itm") || domain1.equals("ttr"));
/*     */           
/* 341 */           String domain2 = argO2.getPackageDomain();
/*     */           
/* 343 */           boolean priority2 = (domain2.equals("trl") || domain2.equals("trn") || domain2.equals("tsn") || domain2.equals("itm") || domain2.equals("ttr"));
/*     */           
/* 345 */           if (priority1) {
/* 346 */             return priority2 ? 0 : -1;
/*     */           }
/*     */           
/* 349 */           return priority2 ? 1 : 0;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 354 */     Collections.sort(this.dtxDefinitions_, comparator);
/*     */   }
/*     */   
/*     */   public void optionalValidate() {
/* 358 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/* 359 */       if (!StringUtils.isEmpty(dtx.getExtendsStringType()) && 
/* 360 */         dtx.getExtendsStringType().startsWith("dtv.xst")) {
/* 361 */         throw new RuntimeException("DTX: " + dtx.getSourceDtxFile().getAbsolutePath() + " extends declaration should NOT have the fully-qualified name (" + dtx
/* 362 */             .getExtendsStringType() + ") just the type name.");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 367 */       for (DtxRelationship relationship : dtx.getRelationships()) {
/*     */         
/* 369 */         DtxDefinition parent = relationship.getParent();
/*     */         
/* 371 */         for (DtxRelationship.DtxRelationshipField relationshipField : relationship.getFields()) {
/* 372 */           if (!StringUtils.isEmpty(relationshipField.getParent()) && 
/* 373 */             parent.findField(relationshipField.getParent()) == null) {
/* 374 */             throw new RuntimeException("The relationship: " + relationship.getName() + " has a field which references non-existent parent field: " + relationshipField
/*     */                 
/* 376 */                 .getParent());
/*     */           }
/*     */         } 
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
/*     */   public void precompile() throws IOException {
/* 390 */     JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
/* 391 */     try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null)) {
/*     */       
/* 393 */       List<File> compileFiles = new ArrayList<>();
/* 394 */       compileFiles.addAll(FileUtils.getFiles(this.outDir_, ".java"));
/* 395 */       if (this.sourcesDir_ != null) {
/* 396 */         compileFiles.addAll(FileUtils.getFiles(this.sourcesDir_, ".java"));
/*     */       }
/*     */ 
/*     */       
/* 400 */       List<String> compilerOptions = new ArrayList<>();
/* 401 */       compilerOptions.add("-d");
/* 402 */       compilerOptions.add(this.tempDir_.getCanonicalPath());
/* 403 */       if (getClass().getClassLoader() instanceof AntClassLoader) {
/* 404 */         compilerOptions.add("-classpath");
/* 405 */         compilerOptions.add(((AntClassLoader)getClass().getClassLoader()).getClasspath());
/*     */       } 
/*     */ 
/*     */       
/* 409 */       if (compileFiles.size() > 0) {
/* 410 */         logger_.info("Pre-compiling " + compileFiles.size() + " files.");
/*     */         
/* 412 */         Iterable<? extends JavaFileObject> javaObjects = fileManager.getJavaFileObjectsFromFiles(compileFiles);
/* 413 */         Writer outWriter = new StringWriter();
/*     */         
/* 415 */         JavaCompiler.CompilationTask compileTask = compiler.getTask(outWriter, fileManager, null, compilerOptions, null, javaObjects);
/* 416 */         if (!compileTask.call().booleanValue()) {
/* 417 */           throw new Error("Generated code did not compile cleanly.\n\nCompiler Output:\n" + outWriter
/* 418 */               .toString());
/*     */         }
/*     */       } else {
/*     */         
/* 422 */         logger_.info("No files to pre-compile.");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 427 */     this
/* 428 */       .precompileClassloader_ = new URLClassLoader(new URL[] { this.tempDir_.toURI().toURL() }, getClass().getClassLoader());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void preLoad(List<File> fileList, boolean argGenerate) {
/* 439 */     logger_.info("Preloading all dtx files");
/*     */     
/* 441 */     DAOParser parser = new DAOParser();
/*     */     
/* 443 */     for (File file : fileList) {
/* 444 */       DtxDefinition dtx = parser.parse(file);
/* 445 */       dtx.setNeedsGeneration(argGenerate);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 450 */       DtxDefinition existing = this.typeNameToDefinition_.get(dtx.getName());
/* 451 */       if (existing == null) {
/* 452 */         this.typeNameToDefinition_.put(dtx.getName(), dtx);
/* 453 */         this.dtxDefinitions_.add(dtx); continue;
/*     */       } 
/* 455 */       if (!existing.needsGeneration(null) && dtx.needsGeneration(null)) {
/* 456 */         logger_.warn("Overriding reference definition [" + existing.getSourceDtxFile().getAbsolutePath() + "] with definition [" + existing
/* 457 */             .getSourceDtxFile().getAbsolutePath() + "]");
/* 458 */         this.dtxDefinitions_.remove(existing);
/* 459 */         this.typeNameToDefinition_.put(dtx.getName(), dtx);
/* 460 */         this.dtxDefinitions_.add(dtx); continue;
/*     */       } 
/* 462 */       if (!dtx.needsGeneration(null)) {
/*     */ 
/*     */         
/* 465 */         logger_.warn("Ignoring reference definition [" + dtx.getSourceDtxFile().getAbsolutePath() + "] in favor of definition [" + existing
/* 466 */             .getSourceDtxFile().getAbsolutePath() + "]");
/*     */         continue;
/*     */       } 
/* 469 */       throw new RuntimeException("Duplicate dtx type detected: " + dtx.getName() + " defined in [" + dtx
/* 470 */           .getSourceDtxFile().getAbsolutePath() + "] and [" + existing
/* 471 */           .getSourceDtxFile().getAbsolutePath() + "]");
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
/*     */   public void setBaseInDirs(Collection<? extends File> argBaseInDirs) throws IOException {
/* 483 */     if (argBaseInDirs != null) {
/* 484 */       for (File file : argBaseInDirs) {
/* 485 */         this.baseInDirs_.add(file);
/* 486 */         this.baseInPaths_.add(file.getCanonicalPath());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCleanbeanOutDir(File argCleanbeanOutDir) throws IOException {
/* 496 */     this.cleanbeanOutPath_ = (argCleanbeanOutDir != null) ? argCleanbeanOutDir.getCanonicalPath() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInDir(File argInDir) throws IOException {
/* 504 */     this.inDir_ = (argInDir != null) ? argInDir : new File(".");
/* 505 */     this.inPath_ = this.inDir_.getCanonicalPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutDir(File argOutDir) throws IOException {
/* 513 */     this.outDir_ = (argOutDir != null) ? argOutDir : new File(".");
/* 514 */     this.outPath_ = this.outDir_.getCanonicalPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverrideExtends(String argOverrideExtends) {
/* 521 */     this.overrideExtends_ = argOverrideExtends;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverrideMode(boolean argOverrideMode) {
/* 528 */     this.overrideMode_ = argOverrideMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverrideType(String argOverrideType) {
/* 535 */     this.overrideType_ = argOverrideType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourcesDir(File argSourcesDir) {
/* 543 */     this.sourcesDir_ = argSourcesDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTempDir(File argTempDir) {
/* 551 */     this.tempDir_ = argTempDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupRelationships() {
/* 558 */     for (DtxDefinition dtxDefinition : this.dtxDefinitions_) {
/*     */ 
/*     */ 
/*     */       
/* 562 */       String extendsStringType = dtxDefinition.getExtendsStringType();
/* 563 */       if (!StringUtils.isEmpty(extendsStringType)) {
/* 564 */         DtxDefinition parent = this.typeNameToDefinition_.get(extendsStringType);
/*     */         
/* 566 */         if (parent == null) {
/* 567 */           throw new RuntimeException("Could not find parent: " + extendsStringType + " for dtx: " + dtxDefinition
/* 568 */               .getName());
/*     */         }
/*     */         
/* 571 */         dtxDefinition.setExtends(parent);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 577 */       DtxInverseRelationship[] inverseRelationships = dtxDefinition.getInverseRelationships();
/* 578 */       for (DtxInverseRelationship ir : inverseRelationships) {
/*     */         
/* 580 */         DtxDefinition dtxParent = this.typeNameToDefinition_.get(ir.getParentType());
/*     */         
/* 582 */         if (dtxParent == null) {
/* 583 */           throw new RuntimeException("Could not find parent: " + ir.getParentType() + " for inverse relationship: " + ir
/* 584 */               .getName() + "\nfor dtx: " + dtxDefinition.getName());
/*     */         }
/*     */         
/* 587 */         ir.setParent(dtxParent);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 593 */       for (DtxRelationship relationship : dtxDefinition.getRelationships()) {
/* 594 */         DtxDefinition child = this.typeNameToDefinition_.get(relationship.getChildName());
/*     */         
/* 596 */         if (child == null) {
/* 597 */           throw new RuntimeException("Unknown child type: " + relationship.getChildName() + " on relationship: " + relationship
/* 598 */               .getName() + " in dtx: " + dtxDefinition
/* 599 */               .getSourceDtxFile().getAbsolutePath());
/*     */         }
/*     */         
/* 602 */         relationship.setChild(child);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected DtxDefinition.DtxDaoField getFieldDefinition(String argName, String argColumn, String argType, boolean argPrimaryKey) {
/* 609 */     DtxDefinition.DtxDaoField field = new DtxDefinition.DtxDaoField();
/*     */     
/* 611 */     field.setName(argName);
/* 612 */     field.setColumn(argColumn);
/* 613 */     field.setType(argType);
/* 614 */     field.setPrimaryKey(argPrimaryKey);
/*     */     
/* 616 */     return field;
/*     */   }
/*     */   
/*     */   protected DtxDefinition getPropertyDtxDefinition(DtxDefinition argParentDtx) {
/* 620 */     DtxDefinition dtxProp = new DtxDefinition();
/*     */     
/* 622 */     String propName = getPropertyName(argParentDtx);
/* 623 */     String tableName = argParentDtx.getTable() + "_p";
/*     */     
/* 625 */     File propFile = new File(argParentDtx.getSourceDtxFile().getParentFile().getPath() + File.separatorChar + propName + ".dtx");
/*     */     
/* 627 */     dtxProp.setIsProperties(true);
/* 628 */     dtxProp.setName(propName);
/* 629 */     dtxProp.setTable(tableName);
/* 630 */     dtxProp.setPackage(argParentDtx.getPackageRaw());
/* 631 */     dtxProp.setSourceDtxFile(propFile);
/*     */     
/* 633 */     for (DtxDefinition.DtxDaoField key : argParentDtx.getPrimaryKeyFields()) {
/* 634 */       dtxProp.addField(key);
/*     */     }
/*     */     
/* 637 */     dtxProp.addField(getFieldDefinition("propertyCode", "property_code", "String", true));
/* 638 */     dtxProp.addField(getFieldDefinition("type", "type", "String", false));
/* 639 */     dtxProp.addField(getFieldDefinition("stringValue", "string_value", "String", false));
/* 640 */     dtxProp.addField(getFieldDefinition("dateValue", "date_value", "Date", false));
/* 641 */     dtxProp.addField(getFieldDefinition("decimalValue", "decimal_value", "BigDecimal", false));
/* 642 */     dtxProp.addField(getFieldDefinition("createDate", "create_date", "Date", false));
/* 643 */     dtxProp.addField(getFieldDefinition("createUserId", "create_user_id", "String", false));
/* 644 */     dtxProp.addField(getFieldDefinition("updateDate", "update_date", "Date", false));
/* 645 */     dtxProp.addField(getFieldDefinition("updateUserId", "update_user_id", "String", false));
/*     */     
/* 647 */     return dtxProp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ensureUniqueNames(List<DtxDefinition> dtxDefinitions) {
/* 655 */     for (DtxDefinition dtx : dtxDefinitions) {
/* 656 */       Set<String> names = new HashSet<>();
/* 657 */       Set<String> columns = new HashSet<>();
/*     */       
/* 659 */       for (DtxDefinition.DtxDaoField field : dtx.getFields()) {
/* 660 */         if (names.contains(field.getName())) {
/* 661 */           throw new RuntimeException("The name " + field.getName() + " is used by more than one field in the " + dtx
/* 662 */               .getPackage() + "." + dtx.getName() + ".dtx.  One of these fields should be renamed.");
/*     */         }
/*     */         
/* 665 */         names.add(field.getName());
/*     */ 
/*     */         
/* 668 */         if (columns.contains(field.getColumn())) {
/* 669 */           throw new RuntimeException("The column " + field
/* 670 */               .getColumn() + " is used by more than one field in the " + dtx.getPackage() + "." + dtx
/* 671 */               .getName() + ".dtx.  One of these fields should be renamed.");
/*     */         }
/*     */         
/* 674 */         columns.add(field.getColumn());
/*     */       } 
/*     */ 
/*     */       
/* 678 */       for (DtxRelationship rel : dtx.getRelationships()) {
/* 679 */         if (names.contains(rel.getName())) {
/* 680 */           throw new RuntimeException("The name " + rel.getName() + " is used by more than one field/relationship in the " + dtx
/* 681 */               .getPackage() + "." + dtx
/* 682 */               .getName() + ".dtx.  One of these fields/relationships should be renamed.");
/*     */         }
/*     */         
/* 685 */         names.add(rel.getName());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DaoGenHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */