/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.data2.access.DataModelFactory;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenerateDataModelFactoryImpl
/*     */   implements Callable<Void>
/*     */ {
/*  21 */   private static final Logger logger_ = Logger.getLogger(GenerateDataModelFactoryImpl.class);
/*  22 */   private static final Class<?> DEFAULT_TARGET = DataModelFactory.class;
/*     */   private static final String DEFAULT_CLASS_NAME = "DataModelFactoryImpl";
/*     */   private static final String DEFAULT_FILE_NAME = "DataModelFactoryImpl.java";
/*     */   private static final String DEFAULT_DIRECTORY = "/dtv/data2/access/impl/";
/*     */   private static final String DEFAULT_PACKAGE = "dtv.data2.access.impl";
/*     */   private static GenerateDataModelFactoryImpl INSTANCE;
/*     */   
/*     */   static {
/*     */     try {
/*  31 */       String className = System.getProperty(GenerateDataModelFactoryImpl.class.getName(), GenerateDataModelFactoryImpl.class
/*  32 */           .getName());
/*  33 */       INSTANCE = (GenerateDataModelFactoryImpl)Class.forName(className).newInstance();
/*     */     }
/*  35 */     catch (Exception ee) {
/*  36 */       System.err.println(ee);
/*  37 */       logger_.error("STACK", ee);
/*  38 */       if (ee instanceof RuntimeException) {
/*  39 */         throw (RuntimeException)ee;
/*     */       }
/*     */       
/*  42 */       throw new RuntimeException(ee);
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
/*     */   
/*     */   public static GenerateDataModelFactoryImpl getInstance() {
/*  55 */     return INSTANCE;
/*     */   }
/*     */   
/*  58 */   protected DaoGenHelper helper_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/*  68 */     logger_.info("Generating DataModelFactoryImpl");
/*     */     
/*  70 */     Writer w = new StringWriter(10240);
/*     */     
/*  72 */     writePackageDeclaration(w);
/*  73 */     writeImportDeclaration(w);
/*     */     
/*  75 */     w.append("@SuppressWarnings(\"all\")\n");
/*  76 */     writeClassName(w);
/*  77 */     w.append("\n");
/*     */     
/*  79 */     writeVariableDeclaration(w);
/*  80 */     writeStaticDeclaration(w);
/*     */     
/*  82 */     writeAdditionalMethods(w);
/*     */     
/*  84 */     w.append("}\n\n");
/*     */ 
/*     */     
/*  87 */     File f = new File(this.helper_.getOutPath() + DaoGenTargetHelper.getDirectoryName(DEFAULT_TARGET, "/dtv/data2/access/impl/") + getFileName());
/*  88 */     this.helper_.getWriter().write(f, w.toString());
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelper(DaoGenHelper argHelper) {
/*  97 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getFileName() {
/* 102 */     return DaoGenTargetHelper.getFileName(DEFAULT_TARGET, "DataModelFactoryImpl.java");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeAdditionalMethods(Writer argW) throws IOException {
/* 107 */     writeAddRelationshipsMethod(argW);
/* 108 */     writeAddDaosMethod(argW);
/* 109 */     writeAddObjectIdsMethod(argW);
/* 110 */     writeAddDataModelsMethod(argW);
/* 111 */     writeAddInterfacesMethod(argW);
/* 112 */     writeGetRelationshipInternalMethod(argW);
/*     */     
/* 114 */     writeGetRelationshipImplMethod(argW);
/* 115 */     writeGetDaoForDaoNameImplMethod(argW);
/* 116 */     writeGetIdForDaoNameImplMethod(argW);
/* 117 */     writeGetModelForDAOImplMethod(argW);
/* 118 */     writeGetModelForInterfaceImplMethod(argW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeClassName(Writer argWriter) throws IOException {
/* 128 */     argWriter.append("public class ");
/* 129 */     argWriter.append(DaoGenTargetHelper.getClassName(DEFAULT_TARGET, "DataModelFactoryImpl"));
/* 130 */     argWriter.append(" extends DataModelFactory {\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeImportDeclaration(Writer argW) throws IOException {
/* 140 */     argW.append("import dtv.data2.access.exception.DtxException;\n");
/* 141 */     argW.append("import dtv.data2.access.*;\n");
/* 142 */     argW.append("import dtv.data2.access.impl.*;\n");
/* 143 */     argW.append("import java.util.HashMap;\n");
/* 144 */     argW.append("import java.util.Map;\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writePackageDeclaration(Writer argW) throws IOException {
/* 154 */     if (argW == null) {
/*     */       return;
/*     */     }
/* 157 */     String name = DaoGenTargetHelper.getPackageName(DEFAULT_TARGET, "dtv.data2.access.impl");
/* 158 */     if (name != null && name.length() > 0) {
/* 159 */       argW.append("package ");
/* 160 */       argW.append(name);
/* 161 */       argW.append(";\n\n");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeStaticDeclaration(Writer argW) throws IOException {
/* 167 */     if (this.helper_.getDtxDefinitions() == null || this.helper_.getDtxDefinitions().isEmpty()) {
/*     */       return;
/*     */     }
/* 170 */     argW.append("  {\n");
/* 171 */     argW.append("    IRelationshipSetProducer relationshipProducer;\n");
/* 172 */     argW.append("    String parentClassName = null;\n\n");
/* 173 */     argW.append("    IRelationshipSetProducer baseRelationshipProducer;\n");
/* 174 */     argW.append("    IRelationshipSetProducer custRelationshipProducer;\n");
/* 175 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/*     */       
/* 177 */       List<DtxRelationship> allRelationships = dtx.getAllRelationships();
/* 178 */       if (!allRelationships.isEmpty()) {
/* 179 */         argW.append("    relationshipProducer = new IRelationshipSetProducer() {\n");
/* 180 */         argW.append("      public IDataModelRelationship[] getRelationshipSet() {\n");
/* 181 */         argW.append("        IDataModelRelationship[] rels = new IDataModelRelationship[");
/* 182 */         argW.append(String.valueOf(allRelationships.size()));
/* 183 */         argW.append("];\n");
/*     */         
/* 185 */         int counter = 0;
/* 186 */         for (DtxRelationship relationship : allRelationships) {
/* 187 */           argW.append("        rels[");
/* 188 */           argW.append(String.valueOf(counter));
/* 189 */           argW.append("] = new ");
/* 190 */           if (DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType())) {
/* 191 */             argW.append("OneToOneRelationship");
/*     */           }
/* 193 */           else if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType())) {
/* 194 */             argW.append("OneToManyRelationship");
/*     */           }
/* 196 */           else if (DtxRelationship.MANY_MANY.equalsIgnoreCase(relationship.getType())) {
/* 197 */             argW.append("ManyToManyRelationship");
/*     */           } 
/*     */           
/* 200 */           argW.append("(\"");
/* 201 */           argW.append(relationship.getName());
/* 202 */           argW.append("\", ");
/* 203 */           argW.append(relationship.getChild().getId());
/* 204 */           argW.append(".class");
/* 205 */           if (DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType()) && relationship
/* 206 */             .isUseParentPm()) {
/* 207 */             argW.append(", true");
/*     */           } else {
/*     */             
/* 210 */             argW.append(", false");
/*     */           } 
/* 212 */           if (relationship.isTransient()) {
/* 213 */             argW.append(", true");
/*     */           } else {
/*     */             
/* 216 */             argW.append(", false");
/*     */           } 
/* 218 */           if (relationship.isPropertyRelationship()) {
/* 219 */             argW.append(", true");
/*     */           }
/* 221 */           argW.append(");\n");
/*     */           
/* 223 */           counter++;
/*     */         } 
/* 225 */         argW.append("        return rels;\n");
/* 226 */         argW.append("      }\n");
/* 227 */         argW.append("    };\n");
/* 228 */         argW.append("    addRelationshipProducer(\"" + dtx.getDao() + "\", relationshipProducer);\n");
/*     */       } 
/* 230 */       if (dtx.isCustomerExtension()) {
/* 231 */         argW.append("    parentClassName = " + dtx.getExtends().getDao() + ".class.getName();\n");
/* 232 */         argW.append("    baseRelationshipProducer = getRelationshipsInternal(parentClassName);\n");
/* 233 */         argW.append("    custRelationshipProducer = new IRelationshipSetProducer() {\n");
/* 234 */         argW.append("      public IDataModelRelationship[] getRelationshipSet() {\n");
/* 235 */         argW.append("        return new IDataModelRelationship[] {new OneToOneRelationship(\"" + dtx
/* 236 */             .getExtends().getName() + "Extension\", " + dtx.getId() + ".class, true, false)};\n");
/* 237 */         argW.append("      }\n");
/* 238 */         argW.append("    };\n");
/*     */         
/* 240 */         argW.append("    if (baseRelationshipProducer != null) {\n");
/* 241 */         argW.append("      addRelationshipProducer(parentClassName, new dtv.data2.access.ChainedRelationshipSetProducer(custRelationshipProducer, baseRelationshipProducer));\n");
/*     */         
/* 243 */         argW.append("    }\n");
/* 244 */         argW.append("    else {\n");
/* 245 */         argW.append("      addRelationshipProducer(parentClassName, custRelationshipProducer);\n");
/* 246 */         argW.append("    }\n");
/*     */       } 
/*     */ 
/*     */       
/* 250 */       String modelClass = dtx.getModel() + ".class";
/* 251 */       argW.append("    addDataModels(\"" + dtx
/* 252 */           .getDao() + "\", new AbstractInstanceGenerator<IDataModelImpl>(){\n");
/* 253 */       argW.append("      protected Class<? extends IDataModelImpl> getType() {\n");
/* 254 */       argW.append("        return " + modelClass + ";\n");
/* 255 */       argW.append("      }\n");
/* 256 */       argW.append("    });\n");
/*     */       
/* 258 */       argW.append("    addInterfaces(\"" + dtx
/* 259 */           .getInterface() + "\", new AbstractInstanceGenerator<IDataModel>(){\n");
/* 260 */       argW.append("      protected Class<? extends IDataModel> getType() {\n");
/* 261 */       argW.append("        return " + modelClass + ";\n");
/* 262 */       argW.append("      }\n");
/* 263 */       argW.append("    });\n");
/*     */       
/* 265 */       String daoClass = dtx.getDao() + ".class";
/* 266 */       argW.append("    addDaos(\"" + dtx
/* 267 */           .getName() + "\", new AbstractInstanceGenerator<IDataAccessObject>(){\n");
/* 268 */       argW.append("      protected Class<? extends IDataAccessObject> getType() {\n");
/* 269 */       argW.append("        return " + daoClass + ";\n");
/* 270 */       argW.append("      }\n");
/* 271 */       argW.append("    });\n");
/*     */       
/* 273 */       String idClass = dtx.getId() + ".class";
/* 274 */       argW.append("    addObjectIds(\"" + dtx
/* 275 */           .getName() + "\", new AbstractInstanceGenerator<IObjectId>(){\n");
/* 276 */       argW.append("      protected Class<? extends IObjectId> getType() {\n");
/* 277 */       argW.append("        return " + idClass + ";\n");
/* 278 */       argW.append("      }\n");
/* 279 */       argW.append("    });\n");
/*     */     } 
/*     */     
/* 282 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeVariableDeclaration(Writer argW) throws IOException {
/* 288 */     argW.append("  private final Map<String, IRelationshipSetProducer> relationshipProducerMap = new HashMap<>();\n");
/*     */     
/* 290 */     argW.append("  private final Map<String, AbstractInstanceGenerator<? extends IDataAccessObject>> daoForDaoNameMap = new HashMap<>();\n");
/*     */     
/* 292 */     argW.append("  private final Map<String, AbstractInstanceGenerator<? extends IObjectId>> idForDaoNameMap = new HashMap<>();\n");
/*     */     
/* 294 */     argW.append("  private final Map<String, AbstractInstanceGenerator<? extends IDataModelImpl>> modelForDaoMap = new HashMap<>();\n");
/*     */     
/* 296 */     argW.append("  private final Map<String, AbstractInstanceGenerator<? extends IDataModel>> modelForInterfaceMap = new HashMap<>();\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendOverrides(Writer argW) throws IOException {
/* 303 */     argW.append("  @Override\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddDaosMethod(Writer argW) throws IOException {
/* 308 */     argW.append("  protected void addDaos(String argKey, AbstractInstanceGenerator<? extends IDataAccessObject> argDataAccessObject) {\n");
/*     */     
/* 310 */     argW.append("    daoForDaoNameMap.put(argKey, argDataAccessObject);\n");
/* 311 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddDataModelsMethod(Writer argW) throws IOException {
/* 316 */     argW.append("  protected void addDataModels(String argKey, AbstractInstanceGenerator<? extends IDataModelImpl> argDataModel) {\n");
/*     */     
/* 318 */     argW.append("    modelForDaoMap.put(argKey, argDataModel);\n");
/* 319 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddInterfacesMethod(Writer argW) throws IOException {
/* 324 */     argW.append("  protected void addInterfaces(String argKey, AbstractInstanceGenerator<? extends IDataModel> argDataModel) {\n");
/*     */     
/* 326 */     argW.append("    modelForInterfaceMap.put(argKey, argDataModel);\n");
/* 327 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddObjectIdsMethod(Writer argW) throws IOException {
/* 332 */     argW.append("  protected void addObjectIds(String argKey, AbstractInstanceGenerator<? extends IObjectId> argObjectId) {\n");
/*     */     
/* 334 */     argW.append("    idForDaoNameMap.put(argKey, argObjectId);\n");
/* 335 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddRelationshipsMethod(Writer argW) throws IOException {
/* 340 */     argW.append("  protected void addRelationshipProducer(String argKey, IRelationshipSetProducer argRelationshipProducer) {\n");
/*     */     
/* 342 */     argW.append("    relationshipProducerMap.put(argKey, argRelationshipProducer);\n");
/* 343 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetDaoForDaoNameImplMethod(Writer argW) throws IOException {
/* 348 */     appendOverrides(argW);
/* 349 */     argW.append("  public IDataAccessObject getDaoForDaoNameImpl(String argDaoName) {\n");
/* 350 */     argW.append("    AbstractInstanceGenerator<? extends IDataAccessObject> daoClass = daoForDaoNameMap.get(argDaoName);\n");
/*     */     
/* 352 */     argW.append("    try {\n");
/* 353 */     argW.append("      return daoClass != null ? daoClass.newInstance() : null;\n");
/* 354 */     argW.append("    }\n");
/* 355 */     argW.append("    catch (InstantiationException | IllegalAccessException ex) {\n");
/* 356 */     argW.append("      throw new DtxException(\"Could not instantiate DAO for: \" + argDaoName, ex);\n");
/* 357 */     argW.append("    }\n");
/* 358 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetIdForDaoNameImplMethod(Writer argW) throws IOException {
/* 363 */     appendOverrides(argW);
/* 364 */     argW.append("  public IObjectId getIdForDaoNameImpl(String argDaoName) {\n");
/* 365 */     argW.append("    AbstractInstanceGenerator<? extends IObjectId> idClass = idForDaoNameMap.get(argDaoName);\n");
/*     */     
/* 367 */     argW.append("    try {\n");
/* 368 */     argW.append("      return idClass != null ? idClass.newInstance() : null;\n");
/* 369 */     argW.append("    }\n");
/* 370 */     argW.append("    catch (InstantiationException | IllegalAccessException ex) {\n");
/* 371 */     argW.append("      throw new DtxException(\"Could not instantiate object Id for: \" + argDaoName, ex);\n");
/*     */     
/* 373 */     argW.append("    }\n");
/* 374 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetModelForDAOImplMethod(Writer argW) throws IOException {
/* 379 */     appendOverrides(argW);
/* 380 */     argW.append("  public IDataModelImpl getModelForDAOImpl(String argDaoClassName) {\n");
/* 381 */     argW.append("    AbstractInstanceGenerator<? extends IDataModelImpl> modelClass = modelForDaoMap.get(argDaoClassName);\n");
/*     */     
/* 383 */     argW.append("    try {\n");
/* 384 */     argW.append("      return modelClass != null ? modelClass.newInstance() : null;\n");
/* 385 */     argW.append("    }\n");
/* 386 */     argW.append("    catch (InstantiationException | IllegalAccessException ex) {\n");
/* 387 */     argW.append("      throw new DtxException(\"Could not instantiate model for: \" + argDaoClassName, ex);\n");
/*     */     
/* 389 */     argW.append("    }\n");
/* 390 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetModelForInterfaceImplMethod(Writer argW) throws IOException {
/* 395 */     appendOverrides(argW);
/* 396 */     argW.append("  public <T extends IDataModel> T getModelForInterfaceImpl(Class<T> argInterfaceClass) {\n");
/* 397 */     argW.append("    AbstractInstanceGenerator<? extends IDataModel> modelClass = modelForInterfaceMap.get(argInterfaceClass.getName());\n");
/*     */     
/* 399 */     argW.append("    try {\n");
/* 400 */     argW.append("      return modelClass != null ? (T) modelClass.newInstance() : null;\n");
/* 401 */     argW.append("    }\n");
/* 402 */     argW.append("    catch (InstantiationException | IllegalAccessException ex) {\n");
/* 403 */     argW.append("      throw new DtxException(\"Could not instantiate model for: \" + argInterfaceClass.getName(), ex);\n");
/*     */     
/* 405 */     argW.append("    }\n");
/* 406 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetRelationshipImplMethod(Writer argW) throws IOException {
/* 411 */     appendOverrides(argW);
/* 412 */     argW.append("  public IDataModelRelationship[] getRelationshipsImpl(String argClassName) {\n");
/* 413 */     argW.append("    IRelationshipSetProducer producer = relationshipProducerMap.get(argClassName);\n");
/* 414 */     argW.append("    return producer != null ? producer.getRelationshipSet() : null;\n");
/* 415 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetRelationshipInternalMethod(Writer argW) throws IOException {
/* 420 */     argW.append("  public IRelationshipSetProducer getRelationshipsInternal(String argClassName) {\n");
/* 421 */     argW.append("    return relationshipProducerMap.get(argClassName);\n");
/* 422 */     argW.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateDataModelFactoryImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */