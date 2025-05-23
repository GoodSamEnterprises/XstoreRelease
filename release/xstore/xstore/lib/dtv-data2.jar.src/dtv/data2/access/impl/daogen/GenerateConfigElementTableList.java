/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenerateConfigElementTableList
/*     */   implements Callable<Void>
/*     */ {
/*  22 */   private static final Logger logger_ = Logger.getLogger(GenerateConfigElementTableList.class);
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_CLASS_NAME = "ConfigElementTableList";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_FILE_NAME = "ConfigElementTableList.java";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_DIRECTORY = "/dtv/xst/dao/";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_PACKAGE = "dtv.xst.dao";
/*     */ 
/*     */   
/*     */   protected DaoGenHelper helper_;
/*     */ 
/*     */   
/*     */   public static GenerateConfigElementTableList createInstance(DaoGenHelper argHelper) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
/*  41 */     String className = System.getProperty(GenerateConfigElementTableList.class.getName(), GenerateConfigElementTableList.class
/*  42 */         .getName());
/*     */     
/*  44 */     GenerateConfigElementTableList instance = (GenerateConfigElementTableList)Class.forName(className).newInstance();
/*  45 */     instance.setHelper(argHelper);
/*  46 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/*  57 */     logger_.info("Generating Config Element Table List");
/*     */     
/*  59 */     Writer stringWriter = new StringWriter(10240);
/*     */     
/*  61 */     writePackageDeclaration(stringWriter);
/*  62 */     writeImportDeclaration(stringWriter);
/*     */     
/*  64 */     writeClassDeclaration(stringWriter);
/*  65 */     stringWriter.append("\n");
/*     */     
/*  67 */     writeVariableDeclaration(stringWriter);
/*  68 */     writeStaticDeclaration(stringWriter);
/*     */     
/*  70 */     writeAdditionalMethods(stringWriter);
/*     */     
/*  72 */     stringWriter.append("}\n\n");
/*     */     
/*  74 */     File f = new File(this.helper_.getOutPath() + "/dtv/xst/dao/" + getFileName());
/*     */     
/*  76 */     this.helper_.getWriter().write(f, stringWriter.toString());
/*     */     
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getFileName() {
/*  83 */     return "ConfigElementTableList.java";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setHelper(DaoGenHelper argHelper) {
/*  91 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeAdditionalMethods(Writer argW) throws IOException {
/*  96 */     writeAddTableMethod(argW);
/*  97 */     writeGetConfigElementTablesMethod(argW);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeClassDeclaration(Writer argW) throws IOException {
/* 103 */     argW.append(this.helper_.getClassCommentWithSuppressWarnings("An auto-generated list of tables whose rows are qualified by an entry in the system's config path."));
/*     */     
/* 105 */     argW.append("public class ");
/* 106 */     argW.append("ConfigElementTableList");
/* 107 */     argW.append(" implements IHasConfigElementTables {\n");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeImportDeclaration(Writer argW) throws IOException {
/* 112 */     argW.append("import java.util.ArrayList;\nimport java.util.List;\nimport dtv.data2.access.impl.daogen.IHasConfigElementTables;\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writePackageDeclaration(Writer argW) throws IOException {
/* 122 */     if (argW == null) {
/*     */       return;
/*     */     }
/* 125 */     argW.append("package ");
/* 126 */     argW.append("dtv.xst.dao");
/* 127 */     argW.append(";\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeStaticDeclaration(Writer argW) throws IOException {
/* 132 */     if (this.helper_.getDtxDefinitions() == null || this.helper_.getDtxDefinitions().isEmpty()) {
/*     */       return;
/*     */     }
/* 135 */     argW.append("  {\n");
/*     */     
/* 137 */     argW.append("    // populate config element table list\n");
/* 138 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/* 139 */       for (DtxDefinition.DtxDaoField field : dtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 140 */         if (DaoGenConfigElementHelper.isConfigElementField(field)) {
/* 141 */           argW.append("    addTable(\"" + dtx.getTable() + "\");\n");
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 146 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeVariableDeclaration(Writer argW) throws IOException {
/* 152 */     argW.append("  private final List<String> _entries = new ArrayList<>();\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendOverrides(Writer argW) throws IOException {
/* 158 */     argW.append("  @Override\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddTableMethod(Writer argW) throws IOException {
/* 163 */     argW.append("  protected void addTable(String argTable) {\n");
/* 164 */     argW.append("    _entries.add(argTable);\n");
/* 165 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetConfigElementTablesMethod(Writer argW) throws IOException {
/* 170 */     appendOverrides(argW);
/* 171 */     argW.append("  public List<String> getConfigElementTables() {\n");
/* 172 */     argW.append("    return _entries;\n");
/* 173 */     argW.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateConfigElementTableList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */