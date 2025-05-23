/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.Collection;
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
/*     */ public class GenerateOrgHierarchyTableList
/*     */   implements Callable<Void>
/*     */ {
/*  21 */   private static final Logger logger_ = Logger.getLogger(GenerateOrgHierarchyTableList.class);
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_CLASS_NAME = "OrgHierarchyTableList";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_FILE_NAME = "OrgHierarchyTableList.java";
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
/*     */   public static GenerateOrgHierarchyTableList createInstance(DaoGenHelper argHelper) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
/*  40 */     String className = System.getProperty(GenerateOrgHierarchyTableList.class.getName(), GenerateOrgHierarchyTableList.class
/*  41 */         .getName());
/*     */     
/*  43 */     GenerateOrgHierarchyTableList instance = (GenerateOrgHierarchyTableList)Class.forName(className).newInstance();
/*  44 */     instance.setHelper(argHelper);
/*  45 */     return instance;
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
/*  56 */     logger_.info("Generating Org Hierarchy Table List");
/*     */     
/*  58 */     Writer stringWriter = new StringWriter(10240);
/*     */     
/*  60 */     writePackageDeclaration(stringWriter);
/*  61 */     writeImportDeclaration(stringWriter);
/*     */     
/*  63 */     writeClassDeclaration(stringWriter);
/*  64 */     stringWriter.append("\n");
/*     */     
/*  66 */     writeVariableDeclaration(stringWriter);
/*  67 */     writeStaticDeclaration(stringWriter);
/*     */     
/*  69 */     writeAdditionalMethods(stringWriter);
/*     */     
/*  71 */     stringWriter.append("}\n\n");
/*     */     
/*  73 */     File f = new File(this.helper_.getOutPath() + "/dtv/xst/dao/" + getFileName());
/*     */     
/*  75 */     this.helper_.getWriter().write(f, stringWriter.toString());
/*     */     
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getFileName() {
/*  82 */     return "OrgHierarchyTableList.java";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setHelper(DaoGenHelper argHelper) {
/*  90 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeAdditionalMethods(Writer argW) throws IOException {
/*  95 */     writeAddTableMethod(argW);
/*  96 */     writeGetOrgHierarchyTablesMethod(argW);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeClassDeclaration(Writer argW) throws IOException {
/* 102 */     argW.append(this.helper_.getClassCommentWithSuppressWarnings("An auto-generated list of tables whose rows are qualified by a node in the organizational hierarchy."));
/*     */     
/* 104 */     argW.append("public class ");
/* 105 */     argW.append("OrgHierarchyTableList");
/* 106 */     argW.append(" implements IHasOrgHierarchyTables {\n");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeImportDeclaration(Writer argW) throws IOException {
/* 111 */     argW.append("import java.util.ArrayList;\nimport java.util.List;\nimport dtv.data2.access.impl.daogen.IHasOrgHierarchyTables;\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writePackageDeclaration(Writer argW) throws IOException {
/* 121 */     if (argW == null) {
/*     */       return;
/*     */     }
/* 124 */     argW.append("package ");
/* 125 */     argW.append("dtv.xst.dao");
/* 126 */     argW.append(";\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeStaticDeclaration(Writer argW) throws IOException {
/* 131 */     Collection<String> orgTables = DaoGenOrgHierarchyHelper.getOrgHierarchyTables();
/* 132 */     if (orgTables == null || orgTables.isEmpty()) {
/*     */       return;
/*     */     }
/* 135 */     argW.append("  {\n");
/*     */     
/* 137 */     argW.append("    // populate org hierarchy table list\n");
/* 138 */     for (String table : orgTables) {
/* 139 */       argW.append("    addTable(\"" + table + "\");\n");
/*     */     }
/* 141 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeVariableDeclaration(Writer argW) throws IOException {
/* 147 */     argW.append("  private final List<String> _entries = new ArrayList<>();\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendOverrides(Writer argW) throws IOException {
/* 153 */     argW.append("  @Override\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAddTableMethod(Writer argW) throws IOException {
/* 158 */     argW.append("  protected void addTable(String argTable) {\n");
/* 159 */     argW.append("    _entries.add(argTable);\n");
/* 160 */     argW.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeGetOrgHierarchyTablesMethod(Writer argW) throws IOException {
/* 165 */     appendOverrides(argW);
/* 166 */     argW.append("  public List<String> getOrgHierarchyTables() {\n");
/* 167 */     argW.append("    return _entries;\n");
/* 168 */     argW.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateOrgHierarchyTableList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */