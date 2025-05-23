/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.data2.access.impl.jdbc.JDBCAdapterMap;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenerateJDBCMapping
/*     */   implements Callable<Void>
/*     */ {
/*  20 */   private static final Logger logger_ = Logger.getLogger(GenerateJDBCMapping.class);
/*     */   
/*  22 */   private static final Class<?> DEFAULT_TARGET = JDBCAdapterMap.class;
/*     */   private static final String DEFAULT_CLASS_NAME = "JDBCAdapterMapImpl";
/*     */   private static final String DEFAULT_FILE_NAME = "JDBCAdapterMapImpl.java";
/*     */   private static final String DEFAULT_DIRECTORY = "/dtv/data2/access/impl/jdbc/";
/*     */   private static final String DEFAULT_PACKAGE = "dtv.data2.access.impl.jdbc";
/*     */   private static GenerateJDBCMapping INSTANCE;
/*     */   protected DaoGenHelper helper_;
/*     */   
/*     */   static {
/*     */     try {
/*  32 */       String className = System.getProperty(GenerateJDBCMapping.class.getName(), GenerateJDBCMapping.class.getName());
/*  33 */       INSTANCE = (GenerateJDBCMapping)Class.forName(className).newInstance();
/*     */     }
/*  35 */     catch (Exception ee) {
/*  36 */       System.err.println(ee);
/*  37 */       logger_.error("STACK", ee);
/*     */       
/*  39 */       if (ee instanceof RuntimeException) {
/*  40 */         throw (RuntimeException)ee;
/*     */       }
/*     */       
/*  43 */       throw new RuntimeException(ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GenerateJDBCMapping getInstance() {
/*  50 */     return INSTANCE;
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
/*     */   public Void call() throws IOException {
/*  63 */     logger_.info("Generating JDBC mapping class");
/*     */     
/*  65 */     Writer stringWriter = new StringWriter(10240);
/*     */     
/*  67 */     writePackageDeclaration(stringWriter);
/*  68 */     writeImportDeclaration(stringWriter);
/*     */     
/*  70 */     stringWriter.append("@SuppressWarnings(\"all\")\n");
/*  71 */     writeClassDeclaration(stringWriter);
/*  72 */     stringWriter.append("\n");
/*     */     
/*  74 */     writeVariableDeclaration(stringWriter);
/*  75 */     writeStaticDeclaration(stringWriter);
/*     */     
/*  77 */     writeAdditionalMethods(stringWriter);
/*     */     
/*  79 */     stringWriter.append("}\n\n");
/*     */ 
/*     */ 
/*     */     
/*  83 */     File f = new File(this.helper_.getOutPath() + DaoGenTargetHelper.getDirectoryName(DEFAULT_TARGET, "/dtv/data2/access/impl/jdbc/") + getFileName());
/*     */     
/*  85 */     this.helper_.getWriter().write(f, stringWriter.toString());
/*     */     
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelper(DaoGenHelper argHelper) {
/*  95 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getFileName() {
/* 100 */     return DaoGenTargetHelper.getFileName(DEFAULT_TARGET, "JDBCAdapterMapImpl.java");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeAdditionalMethods(Writer argW) throws IOException {
/* 105 */     writeAddAdapterMethod(argW);
/* 106 */     writeAddRelationshipAdapterMethod(argW);
/* 107 */     writeAdapterMethod(argW);
/* 108 */     writeRelationshipAdapterMethod(argW);
/* 109 */     writeInternalRelationshipAdapterMethod(argW);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeClassDeclaration(Writer argW) throws IOException {
/* 115 */     argW.append("public class ");
/* 116 */     argW.append(DaoGenTargetHelper.getClassName(DEFAULT_TARGET, "JDBCAdapterMapImpl"));
/* 117 */     argW.append(" extends JDBCAdapterMap {\n");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeImportDeclaration(Writer argW) throws IOException {
/* 122 */     argW.append("import dtv.data2.access.exception.DtxException;\nimport dtv.data2.access.AbstractInstanceGenerator;\nimport dtv.data2.access.impl.IRelationshipAdapter;\nimport dtv.data2.access.impl.jdbc.IJDBCTableAdapter;\nimport dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;\nimport dtv.data2.access.impl.jdbc.JDBCAdapterMap;\nimport java.util.HashMap;\nimport java.util.Map;\n\n");
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writePackageDeclaration(Writer argW) throws IOException {
/* 138 */     if (argW == null) {
/*     */       return;
/*     */     }
/* 141 */     String name = DaoGenTargetHelper.getPackageName(DEFAULT_TARGET, "dtv.data2.access.impl.jdbc");
/* 142 */     if (name != null && name.length() > 0) {
/* 143 */       argW.append("package ");
/* 144 */       argW.append(name);
/* 145 */       argW.append(";\n\n");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeStaticDeclaration(Writer argW) throws IOException {
/* 151 */     if (this.helper_.getDtxDefinitions() == null || this.helper_.getDtxDefinitions().isEmpty()) {
/*     */       return;
/*     */     }
/* 154 */     argW.append("  {\n");
/* 155 */     argW.append("    // populate the adapter map\n");
/* 156 */     argW.append("    AbstractInstanceGenerator<IJDBCTableAdapter> generator;\n");
/* 157 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/* 158 */       String adapterClass = dtx.getDba() + ".class";
/* 159 */       argW.append("    generator = new AbstractInstanceGenerator<IJDBCTableAdapter>() {\n");
/* 160 */       argW.append("      protected Class<? extends IJDBCTableAdapter> getType() {\n");
/* 161 */       argW.append("        return " + adapterClass + ";\n");
/* 162 */       argW.append("      }\n");
/* 163 */       argW.append("    };\n");
/* 164 */       if (!dtx.isExtended()) {
/* 165 */         argW.append("    addAdapter(\"" + dtx.getId() + "\", generator);\n");
/*     */       }
/* 167 */       argW.append("    addAdapter(\"" + dtx.getDao() + "\", generator);\n");
/* 168 */       argW.append("    addAdapter(\"" + dtx.getInterface() + "\", generator);\n");
/* 169 */       argW.append("    addAdapter(\"" + dtx.getName() + "\", generator);\n");
/*     */     } 
/*     */     
/* 172 */     argW.append("\n\n    // populate the relationship adapter map\n");
/* 173 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/* 174 */       if (!dtx.getRelationships().isEmpty()) {
/* 175 */         for (DtxRelationship relationship : dtx.getRelationships()) {
/*     */           
/* 177 */           String relationshipAdapterClass = dtx.getPackage() + "." + dtx.getName() + relationship.getName() + "RelationshipDBA" + ".class";
/*     */           
/* 179 */           argW.append("    addRelationshipAdapter(\"" + dtx.getDao() + "-" + relationship.getName() + "\", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {\n");
/*     */           
/* 181 */           argW.append("      protected Class<? extends IJDBCRelationshipAdapter> getType() {\n");
/* 182 */           argW.append("        return " + relationshipAdapterClass + ";\n");
/* 183 */           argW.append("      }\n");
/* 184 */           argW.append("    });\n");
/*     */         } 
/*     */       }
/*     */       
/* 188 */       if (dtx.isCustomerExtension()) {
/* 189 */         String extRelationshipName = dtx.getExtends().getName() + "Extension";
/*     */         
/* 191 */         String relationshipAdapterClass = dtx.getPackage() + "." + dtx.getName() + extRelationshipName + "RelationshipDBA" + ".class";
/*     */         
/* 193 */         argW.append("    addRelationshipAdapter(\"" + dtx.getExtends().getDao() + "-" + extRelationshipName + "\", new AbstractInstanceGenerator<IJDBCRelationshipAdapter>() {\n");
/*     */         
/* 195 */         argW.append("      protected Class<? extends IJDBCRelationshipAdapter> getType() {\n");
/* 196 */         argW.append("        return " + relationshipAdapterClass + ";\n");
/* 197 */         argW.append("      }\n");
/* 198 */         argW.append("    });\n");
/*     */       } 
/*     */     } 
/* 201 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeVariableDeclaration(Writer argW) throws IOException {
/* 207 */     argW.append("  private final Map<String,AbstractInstanceGenerator<? extends IJDBCTableAdapter>> adapterMap = new HashMap<>();\n");
/* 208 */     argW.append("  private final Map<String,AbstractInstanceGenerator<? extends IJDBCRelationshipAdapter>> relationshipAdapterMap = new HashMap<>();\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendOverrides(Writer argW) throws IOException {
/* 214 */     argW.append("  @Override\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAdapterMethod(Writer argW) throws IOException {
/* 219 */     appendOverrides(argW);
/* 220 */     argW.append("  public IJDBCTableAdapter getTableAdapterImpl(String argIdentifier) {\n");
/* 221 */     argW.append("    AbstractInstanceGenerator<? extends IJDBCTableAdapter> adapterClass = adapterMap.get(argIdentifier);\n");
/* 222 */     argW.append("    try {\n");
/* 223 */     argW.append("      return adapterClass != null ? adapterClass.newInstance() : null;\n");
/* 224 */     argW.append("    }\n");
/* 225 */     argW.append("    catch (InstantiationException | IllegalAccessException ex) {\n");
/* 226 */     argW.append("      throw new DtxException(\"Could not instantiate adapter for: \" + argIdentifier, ex);\n");
/* 227 */     argW.append("    }\n");
/* 228 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddAdapterMethod(Writer argW) throws IOException {
/* 233 */     argW.append("  protected void addAdapter(String argKey, AbstractInstanceGenerator<? extends IJDBCTableAdapter> argClass) {\n");
/* 234 */     argW.append("    adapterMap.put(argKey, argClass);\n");
/* 235 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddRelationshipAdapterMethod(Writer argW) throws IOException {
/* 240 */     argW.append("  protected void addRelationshipAdapter(String argKey, AbstractInstanceGenerator<? extends IJDBCRelationshipAdapter> argClass) {\n");
/* 241 */     argW.append("    relationshipAdapterMap.put(argKey, argClass);\n");
/* 242 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeInternalRelationshipAdapterMethod(Writer argW) throws IOException {
/* 247 */     argW.append("  private IJDBCRelationshipAdapter getRelationshipAdapterImplInternal(Class<?> argClass, String argIdentifier) {\n\n");
/* 248 */     argW.append("    AbstractInstanceGenerator<? extends IJDBCRelationshipAdapter> relationshipAdapterClass = relationshipAdapterMap.get(argClass.getName() + \"-\" + argIdentifier);\n");
/* 249 */     argW.append("    try {\n");
/* 250 */     argW.append("      if (relationshipAdapterClass != null) {\n");
/* 251 */     argW.append("        return relationshipAdapterClass.newInstance();\n");
/* 252 */     argW.append("      }\n");
/* 253 */     argW.append("    }\n");
/* 254 */     argW.append("    catch (InstantiationException | IllegalAccessException ex) {\n");
/* 255 */     argW.append("      throw new DtxException(\"Could not instantiate relationship adapter for class: [\" + argClass.getName() + \"] identifier: [\" + argIdentifier + \"]\", ex);\n");
/* 256 */     argW.append("    }\n\n");
/* 257 */     argW.append("    Class<?> parent = argClass.getSuperclass();\n");
/* 258 */     argW.append("    if (parent != null && !(parent.getName().startsWith(\"java.\"))) {\n");
/* 259 */     argW.append("      return getRelationshipAdapterImplInternal(parent, argIdentifier);\n");
/* 260 */     argW.append("    }\n");
/* 261 */     argW.append("     else {\n");
/* 262 */     argW.append("      return null;\n");
/* 263 */     argW.append("    }\n");
/* 264 */     argW.append("  }\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeRelationshipAdapterMethod(Writer argW) throws IOException {
/* 269 */     appendOverrides(argW);
/* 270 */     argW.append("  public IRelationshipAdapter getRelationshipAdapterImpl(Class argClass, String argIdentifier) {\n\n");
/* 271 */     argW.append("    IJDBCRelationshipAdapter adapter = getRelationshipAdapterImplInternal(argClass, argIdentifier);\n");
/* 272 */     argW.append("    if (adapter == null) {\n");
/* 273 */     argW.append("      return null;\n");
/* 274 */     argW.append("    }\n");
/* 275 */     argW.append("    return adapter;\n");
/* 276 */     argW.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateJDBCMapping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */