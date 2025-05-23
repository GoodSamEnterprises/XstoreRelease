/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenerateInterfaces
/*     */   implements Callable<Void>
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(GenerateInterfaces.class);
/*     */   
/*     */   private final DaoGenHelper helper_;
/*  31 */   private final String ee = EventEnum.class.getName();
/*     */   
/*     */   GenerateInterfaces(DaoGenHelper argHelper) {
/*  34 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/*  41 */     logger_.info("Generating final interfaces");
/*  42 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/*  43 */       if (dtx.needsGeneration(null)) {
/*  44 */         StringBuilder w = new StringBuilder(5120);
/*     */         
/*  46 */         getInterfaceHeader(w, dtx);
/*  47 */         getInterfaceEventEnums(w, dtx);
/*  48 */         getInterfaceDaoMethods(w, dtx);
/*     */         
/*  50 */         if (!dtx.isProperties()) {
/*  51 */           getInterfaceExtensionMethods(w, dtx);
/*     */         }
/*     */         
/*  54 */         getInterfaceRelationshipMethods(w, dtx);
/*  55 */         getInterfaceTransactionMethods(w, dtx);
/*  56 */         getInterfaceFooter(w);
/*     */         
/*  58 */         String dir = this.helper_.getOutPath() + '/' + dtx.getInterfacePackage().replaceAll("\\.", "/") + '/';
/*  59 */         String fileName = dir + "I" + dtx.getName() + ".java";
/*  60 */         File f = new File(fileName);
/*  61 */         this.helper_.getWriter().write(f, w.toString());
/*     */       } 
/*     */     } 
/*  64 */     return null;
/*     */   }
/*     */   
/*     */   private void getEventEnum(StringBuilder out, String signame, String sigdesc) {
/*  68 */     out.append("  public static final ");
/*  69 */     out.append(this.ee);
/*  70 */     out.append(" ");
/*  71 */     out.append(signame);
/*  72 */     out.append(" = new ");
/*  73 */     out.append(this.ee);
/*  74 */     out.append("(\"");
/*  75 */     out.append(sigdesc);
/*  76 */     out.append("\");\n");
/*     */   }
/*     */   
/*     */   private void getInterfaceDaoMethods(StringBuilder out, DtxDefinition argDtx) {
/*  80 */     out.append("\n  // Methods related to DAO methods.  public void initDAO();\n  public void setDAO(");
/*     */ 
/*     */     
/*  83 */     out.append(IDataAccessObject.class.getName());
/*  84 */     out.append(" argDAO);\n");
/*     */     
/*  86 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/*  87 */       if (field.getExported()) {
/*     */ 
/*     */ 
/*     */         
/*  91 */         out.append("  /**\n   * Getter for ").append(field.getName()).append(".\n");
/*  92 */         String comment = field.getComment();
/*  93 */         if (comment != null && (comment = comment.trim()).length() > 0) {
/*  94 */           out.append("   * ").append(comment.replaceAll("\\n[\\t ]*", "\n   * ")).append('\n');
/*     */         }
/*  96 */         out.append("   * @return DAO alias for column ").append(field.getColumn());
/*  97 */         out.append("\n   */\n");
/*  98 */         out.append("  public ");
/*  99 */         out.append(DaoGenUtils.getVariableType(field.getType()));
/* 100 */         out.append(" ");
/* 101 */         out.append(DaoGenUtils.getGetterNameForField(field));
/* 102 */         out.append("();\n");
/* 103 */         out.append("  public void ");
/* 104 */         out.append(DaoGenUtils.getSetterNameForField(field));
/* 105 */         out.append("(");
/* 106 */         out.append(DaoGenUtils.getVariableType(field.getType()));
/* 107 */         out.append(" ");
/* 108 */         out.append(DaoGenUtils.getArgNameForField(field));
/* 109 */         out.append(");\n");
/*     */         
/* 111 */         if (!StringUtils.isEmpty(field.getEncrypt())) {
/* 112 */           if ("String".equalsIgnoreCase(field.getType())) {
/* 113 */             out.append("  public ");
/* 114 */             out.append(DaoGenUtils.getVariableType(field.getType()));
/* 115 */             out.append(" ");
/* 116 */             out.append(DaoGenUtils.getGetterNameForField(field)).append("Encrypted");
/* 117 */             out.append("();\n");
/*     */           } else {
/*     */             
/* 120 */             logger_.error("Configuration error: Non-string field [" + field.getName() + "] of [" + argDtx
/* 121 */                 .getName() + ".dtx] is marked with 'encrypt' attribute. Only 'String' type fields will support encryption");
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void getInterfaceEventEnums(StringBuilder out, DtxDefinition argDtx) {
/* 129 */     out.append("  // Events which may be posted by implementors of this model.\n");
/* 130 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/* 131 */       getEventEnum(out, "SET_" + field.getName().toUpperCase(), "set " + field.getName());
/*     */     }
/*     */     
/* 134 */     for (DtxRelationship rel : argDtx.getRelationships()) {
/* 135 */       String uc = rel.getName().toUpperCase();
/* 136 */       if (DtxRelationship.ONE_ONE.equalsIgnoreCase(rel.getType())) {
/* 137 */         getEventEnum(out, "SET_" + uc, "set " + rel.getName()); continue;
/*     */       } 
/* 139 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(rel.getType()) || DtxRelationship.MANY_MANY
/* 140 */         .equalsIgnoreCase(rel.getType())) {
/* 141 */         getEventEnum(out, "ADD_" + uc, "add " + rel.getName());
/* 142 */         getEventEnum(out, "REMOVE_" + uc, "remove " + rel.getName());
/* 143 */         getEventEnum(out, "SET_" + uc, "set " + rel.getName());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 148 */     getEventEnum(out, "START_TRANSACTION", "start transaction");
/* 149 */     getEventEnum(out, "ROLLBACK_TRANSACTION", "rollback transaction");
/* 150 */     getEventEnum(out, "COMMIT_TRANSACTION", "commit transaction");
/*     */ 
/*     */     
/* 153 */     out.append("\n");
/*     */   }
/*     */   
/*     */   private void getInterfaceExtensionMethods(StringBuilder out, DtxDefinition argDtx) {
/* 157 */     out.append("  /**\n");
/* 158 */     out.append("   * This method is used to get a customer extention object, if one is present.\n");
/* 159 */     out.append("   * @return IDataModel - this will either be null or a cust extention model.\n");
/* 160 */     out.append("   */\n");
/* 161 */     out.append("  public IDataModel get" + argDtx.getName() + "Ext();\n\n");
/*     */     
/* 163 */     out.append("  public void set" + argDtx.getName() + "Ext(IDataModel argExt);\n\n");
/*     */   }
/*     */   
/*     */   private void getInterfaceFooter(StringBuilder w) {
/* 167 */     w.append("}\n");
/*     */   }
/*     */   
/*     */   private void getInterfaceHeader(StringBuilder out, DtxDefinition argDtx) {
/* 171 */     out.append("package ");
/* 172 */     out.append(argDtx.getInterfacePackage());
/* 173 */     out.append(";\n\n");
/*     */     
/* 175 */     boolean hasConfigElementField = false;
/*     */ 
/*     */     
/* 178 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/* 179 */       if (field.getType() != null && field.getType().equals("Date")) {
/* 180 */         out.append("import java.util.Date;\n");
/*     */         
/*     */         break;
/*     */       } 
/* 184 */       if (DaoGenConfigElementHelper.isConfigElementField(field)) {
/* 185 */         hasConfigElementField = true;
/*     */       }
/*     */     } 
/*     */     
/* 189 */     out.append("import dtv.data2.access.IDataModel;\n");
/*     */     
/* 191 */     out.append("\n@SuppressWarnings(\"all\")");
/* 192 */     out.append("\npublic interface I");
/* 193 */     out.append(argDtx.getName());
/* 194 */     out.append(" extends IDataModel");
/*     */     
/* 196 */     if (hasConfigElementField) {
/* 197 */       out.append(", dtv.data2.access.IHasConfigElement");
/*     */     }
/*     */     
/* 200 */     if (argDtx.getImplements() != null) {
/* 201 */       out.append(", ");
/* 202 */       out.append(argDtx.getImplements());
/*     */     } 
/*     */     
/* 205 */     if (DaoGenHelper.isPropertyChildNeeded(argDtx)) {
/* 206 */       String propertyInterfaceName = DaoGenHelper.getPropertyInterfaceName(argDtx);
/*     */       
/* 208 */       out.append(", ");
/* 209 */       out.append("dtv.data2.access.IHasDataProperty<").append(propertyInterfaceName).append(">");
/*     */     } 
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
/* 229 */     if (argDtx.isProperties()) {
/* 230 */       out.append(", ");
/* 231 */       out.append("dtv.data2.access.IDataProperty");
/*     */     } 
/* 233 */     if (argDtx.isExtended()) {
/*     */       
/* 235 */       out.append(", ");
/* 236 */       out.append(argDtx.getExtends().getInterface());
/*     */     } 
/* 238 */     out.append(" {\n");
/*     */   }
/*     */   
/*     */   private void getInterfaceRelationshipMethods(StringBuilder out, DtxDefinition argDtx) {
/* 242 */     out.append("  // Methods related to data relationships\n");
/*     */     
/* 244 */     for (DtxRelationship rel : argDtx.getRelationships()) {
/*     */ 
/*     */       
/* 247 */       if (!rel.isExported()) {
/*     */         continue;
/*     */       }
/*     */       
/* 251 */       String argName = DaoGenUtils.getArgNameForRelationship(rel);
/* 252 */       String typeName = DaoGenUtils.getTypeForRelationship(rel, false);
/* 253 */       String getterName = DaoGenUtils.getGetterNameForRelationship(rel);
/* 254 */       String setterName = DaoGenUtils.getSetterNameForRelationship(rel);
/*     */ 
/*     */       
/* 257 */       out.append("  public ");
/* 258 */       out.append(typeName);
/* 259 */       out.append(" ");
/* 260 */       out.append(getterName);
/* 261 */       out.append("();\n");
/* 262 */       out.append("  public void ");
/* 263 */       out.append(setterName);
/* 264 */       out.append("(");
/* 265 */       out.append(typeName);
/* 266 */       out.append(" ");
/* 267 */       out.append(argName);
/* 268 */       out.append(");\n");
/*     */ 
/*     */       
/* 271 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(rel.getType()) || DtxRelationship.MANY_MANY
/* 272 */         .equalsIgnoreCase(rel.getType())) {
/* 273 */         String addRemoveArgName = DaoGenUtils.getArgNameForRelationshipAddRemove(rel);
/*     */         
/* 275 */         out.append("  public void ");
/* 276 */         out.append(DaoGenUtils.getAdderNameForRelationship(rel));
/* 277 */         out.append("(");
/* 278 */         out.append(rel.getChild().getInterface());
/* 279 */         out.append(" ");
/* 280 */         out.append(addRemoveArgName);
/* 281 */         out.append(");\n");
/* 282 */         out.append("  public void ");
/* 283 */         out.append(DaoGenUtils.getRemoverNameForRelationship(rel));
/* 284 */         out.append("(");
/* 285 */         out.append(rel.getChild().getInterface());
/* 286 */         out.append(" ");
/* 287 */         out.append(addRemoveArgName);
/* 288 */         out.append(");\n");
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 296 */     for (DtxInverseRelationship inverseRelationship : argDtx.getInverseRelationships()) {
/*     */       
/* 298 */       out.append("  public void ");
/* 299 */       out.append(inverseRelationship.getSetMethodName());
/* 300 */       out.append("(");
/* 301 */       out.append(inverseRelationship.getParent().getInterface());
/* 302 */       out.append(" arg");
/* 303 */       out.append(StringUtils.ensureFirstUpperCase(inverseRelationship.getName()));
/* 304 */       out.append(");\n");
/*     */       
/* 306 */       out.append("  public ");
/* 307 */       out.append(inverseRelationship.getParent().getInterface());
/* 308 */       out.append(" ");
/* 309 */       out.append(inverseRelationship.getGetMethodName());
/* 310 */       out.append("();\n");
/*     */     } 
/*     */     
/* 313 */     out.append("\n");
/*     */   }
/*     */   
/*     */   private void getInterfaceTransactionMethods(StringBuilder out, DtxDefinition argDtx) {
/* 317 */     out.append("  // Methods required for transactions\n  public void startTransaction();\n  public void rollbackChanges();\n  public void commitTransaction();\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateInterfaces.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */