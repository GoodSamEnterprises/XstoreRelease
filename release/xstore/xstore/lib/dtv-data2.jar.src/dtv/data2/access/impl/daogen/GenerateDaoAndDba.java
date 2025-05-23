/*      */ package dtv.data2.access.impl.daogen;
/*      */ 
/*      */ import com.google.common.base.CaseFormat;
/*      */ import dtv.util.StringUtils;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.Callable;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GenerateDaoAndDba
/*      */   implements Callable<Void>
/*      */ {
/*   31 */   private static final Logger _logger = Logger.getLogger(GenerateDaoAndDba.class);
/*   32 */   private static final String[] FIELDS_EXCLUDED_FROM_UPDATE = new String[] { "createDate", "createUserId" };
/*      */   
/*      */   private final DaoGenHelper helper_;
/*      */   private final List<DtxDefinition> dtxDefinitions_;
/*      */   
/*      */   GenerateDaoAndDba(DaoGenHelper argHelper) {
/*   38 */     this.helper_ = argHelper;
/*   39 */     this.dtxDefinitions_ = this.helper_.getDtxDefinitions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Void call() throws IOException {
/*   47 */     _logger.info("Generating dtx mappings");
/*      */     
/*   49 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/*   50 */       if (DaoGenOrgHierarchyHelper.isOrgHierarchical(dtx)) {
/*   51 */         DaoGenOrgHierarchyHelper.addOrgHierarchyTable(dtx.getTable());
/*      */       }
/*      */       
/*   54 */       File dbaFile = new File(this.helper_.getOutPath() + this.helper_.getFilePath(dtx) + dtx.getName() + "DBA.java");
/*   55 */       if (dtx.needsGeneration(dbaFile)) {
/*   56 */         StringBuilder out = new StringBuilder(20480);
/*   57 */         getDBAHeader(out, dtx);
/*   58 */         getDBAMembers(out, dtx);
/*   59 */         getDBAMethods(out, dtx);
/*   60 */         getDBAFooter(out, dtx);
/*      */         
/*   62 */         this.helper_.getWriter().write(dbaFile, out.toString());
/*      */       } 
/*      */       
/*   65 */       File daoFile = new File(this.helper_.getOutPath() + this.helper_.getFilePath(dtx) + dtx.getName() + "DAO.java");
/*   66 */       if (dtx.needsGeneration(daoFile)) {
/*   67 */         StringBuilder out = new StringBuilder(20480);
/*   68 */         out.setLength(0);
/*   69 */         getDAOHeader(out, dtx);
/*   70 */         getDAOMembers(out, dtx);
/*   71 */         getDAOMethods(out, dtx);
/*   72 */         getDaoDbaUpdateDiffMethods(out, dtx);
/*   73 */         getDAOToString(out, dtx);
/*   74 */         getDAOFooter(out, dtx);
/*      */         
/*   76 */         this.helper_.getWriter().write(daoFile, out.toString());
/*      */       } 
/*      */     } 
/*   79 */     return null;
/*      */   }
/*      */   
/*      */   private void getDaoDbaUpdateDiffMethods(StringBuilder out, DtxDefinition argDtx) {
/*   83 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFieldsPlusInheritedPrimaryKeys();
/*      */     
/*   85 */     for (DtxDefinition.DtxDaoField field : fields) {
/*   86 */       if (field.getIncrementField()) {
/*   87 */         String fieldName = DaoGenUtils.getFieldNameForField(field);
/*   88 */         String initFieldName = "_init" + StringUtils.ensureFirstUpperCase(field.getName());
/*   89 */         String rawDataType = DaoGenUtils.getRawDataType(field.getType());
/*      */         
/*   91 */         out.append("  private " + rawDataType + " " + DaoGenUtils.getGetterNameForField(field) + "Diff() {\n    " + rawDataType + " val1;\n    " + rawDataType + " val2;\n\n    if (" + fieldName + " == null) {\n      val1 = new " + rawDataType + "(0);\n    }\n    else {\n      val1 = " + fieldName + ";\n    }\n\n    if (" + initFieldName + " == null) {\n      val2 = new " + rawDataType + "(0);\n    }\n    else {\n      val2 = " + initFieldName + ";\n    }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  109 */         if ("BigDecimal".equalsIgnoreCase(field.getType())) {
/*  110 */           out.append("    return val1.subtract(val2);\n");
/*      */         }
/*  112 */         else if ("Integer".equalsIgnoreCase(field.getType())) {
/*  113 */           out.append("    return Integer.valueOf(val1.intValue() - val2.intValue());\n");
/*      */         }
/*  115 */         else if ("Long".equalsIgnoreCase(field.getType())) {
/*  116 */           out.append("    return Long.valueOf(val1.longValue() - val2.longValue());\n");
/*      */         } 
/*      */         
/*  119 */         out.append("  }\n\n");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void getDAOFooter(StringBuilder out, DtxDefinition argDtx) {
/*  125 */     if (!argDtx.isExtended()) {
/*  126 */       out.append("  public IObjectId getObjectId() {\n");
/*  127 */       out.append("    " + argDtx.getId() + " id = new " + argDtx.getId() + "();\n");
/*      */       
/*  129 */       for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/*  130 */         String getterName = DaoGenUtils.getGetterNameForField(field);
/*  131 */         String setterName = DaoGenUtils.getSetterNameForField(field);
/*  132 */         out.append("    id." + setterName + "(this." + getterName + "());\n");
/*      */       } 
/*      */       
/*  135 */       out.append("    return id;\n");
/*  136 */       out.append("  }\n\n");
/*      */       
/*  138 */       out.append("  public void setObjectId(IObjectId argObjectId) {\n");
/*      */       
/*  140 */       if ((argDtx.getPrimaryKeyFields()).length > 0) {
/*  141 */         for (DtxDefinition.DtxDaoField f : argDtx.getPrimaryKeyFields()) {
/*  142 */           String getterName = DaoGenUtils.getGetterNameForField(f);
/*  143 */           String setterName = DaoGenUtils.getSetterNameForField(f);
/*  144 */           out.append("    " + setterName + "(((" + argDtx
/*  145 */               .getId() + ")argObjectId)." + getterName + "());\n");
/*      */         } 
/*      */       } else {
/*      */         
/*  149 */         out.append("    // " + argDtx.getName() + " does not define a primary key.\n");
/*      */       } 
/*      */       
/*  152 */       out.append("  }\n\n");
/*      */       
/*  154 */       out.append("  public String getImplementingClass() {\n");
/*  155 */       if (argDtx.isExtensible()) {
/*  156 */         out.append("    return _" + argDtx.getImplementingClassField() + ";\n");
/*      */       } else {
/*      */         
/*  159 */         out.append("    return null; // This DAO is not extensible\n");
/*      */       } 
/*      */       
/*  162 */       out.append("  }\n\n");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  168 */     if (argDtx.isExtended()) {
/*  169 */       out.append("  @Override\n");
/*      */     }
/*      */     
/*  172 */     out.append("  public String toXmlString() {\n");
/*  173 */     int buffSize = 50 * (argDtx.getFields()).length;
/*  174 */     DtxDefinition parent = argDtx.getExtends();
/*      */     
/*  176 */     while (parent != null) {
/*  177 */       buffSize += 50 * (parent.getFields()).length;
/*  178 */       parent = parent.getExtends();
/*      */     } 
/*      */     
/*  181 */     out.append("    StringBuilder buf = new StringBuilder(" + buffSize + ");\n");
/*  182 */     out.append("    buf.append(\"<\").append(DAO_ELEMENT_NAME).append(\" name=\\\"" + argDtx.getName() + "\\\" cmd=\\\"\" + getObjectStateString() + \"\\\">\");\n");
/*      */     
/*  184 */     out.append("    getFieldsAsXml(buf);\n");
/*  185 */     out.append("    buf.append(\"</\").append(DAO_ELEMENT_NAME).append(\">\");\n\n");
/*  186 */     out.append("    return buf.toString();\n");
/*  187 */     out.append("  }\n");
/*      */ 
/*      */     
/*  190 */     out.append("  @Override\n");
/*  191 */     out.append("  public java.util.Map<String, String> getValues() {\n");
/*  192 */     out.append("    java.util.Map<String, String> values = super.getValues();\n");
/*      */     
/*  194 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/*  195 */       String name = DaoGenUtils.getFieldNameForField(field);
/*  196 */       String publicName = "\"" + StringUtils.ensureFirstUpperCase(field.getName()) + "\"";
/*      */       
/*  198 */       out.append("    if (" + name + " != null) values.put(" + publicName + ", dtv.data2.access.DaoUtils.getXmlSafeFieldValue(" + 
/*  199 */           DaoGenUtils.getTypeForField(field) + ", ");
/*  200 */       if (field.getIncrementField()) {
/*  201 */         out.append("get" + StringUtils.ensureFirstUpperCase(field.getName()) + "Diff()");
/*      */       } else {
/*      */         
/*  204 */         out.append(name);
/*      */       } 
/*  206 */       out.append("));\n");
/*      */     } 
/*  208 */     out.append("    return values;\n");
/*  209 */     out.append("  }\n\n");
/*      */     
/*  211 */     out.append("  @Override\n");
/*      */     
/*  213 */     out.append("  public void setValues(java.util.Map<String, String> argValues) {\n");
/*  214 */     out.append("    super.setValues(argValues);\n");
/*  215 */     out.append("    java.util.Set<String> fieldNames = argValues.keySet();\n\n");
/*  216 */     out.append("    for (String fieldName : fieldNames) {\n\n");
/*  217 */     out.append("      int name = fieldName.hashCode();\n");
/*  218 */     out.append("      switch (name) {\n\n");
/*      */     
/*  220 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/*  221 */       String publicName = StringUtils.ensureFirstUpperCase(field.getName());
/*  222 */       String setterName = DaoGenUtils.getSetterNameForField(field);
/*  223 */       out.append("        case " + publicName.hashCode() + ": { // " + publicName + "\n");
/*  224 */       out.append("          try {\n");
/*  225 */       out.append("          Object value = dtv.data2.access.DaoUtils.\n");
/*  226 */       out.append("            getFieldValueForXmlString(" + DaoGenUtils.getTypeForField(field) + ", argValues.get(fieldName));\n\n");
/*      */       
/*  228 */       out.append("          ").append(setterName).append("(" + makeCast(field)).append("value);\n");
/*  229 */       out.append("          } catch (Exception ee) {\n");
/*  230 */       out.append("            throw new dtv.data2.access.exception.DtxException(\"An exception occurred while calling " + setterName + "() with \" + argValues.get(fieldName) + \" on: \" + this + \" \" + ee.toString(), ee);\n");
/*      */ 
/*      */ 
/*      */       
/*  234 */       out.append("          }\n");
/*  235 */       out.append("          break;\n");
/*  236 */       out.append("        }\n");
/*      */     } 
/*      */     
/*  239 */     out.append("        default: break;\n");
/*  240 */     out.append("      }\n");
/*  241 */     out.append("    }\n");
/*  242 */     out.append("  }\n");
/*  243 */     out.append("} ");
/*      */   }
/*      */   
/*      */   private String getDAOHeader(StringBuilder out, DtxDefinition argDtx) {
/*  247 */     out.append("package ");
/*  248 */     out.append(argDtx.getPackage());
/*  249 */     out.append(";\n\n");
/*  250 */     out.append("import java.util.Date;\n\n");
/*  251 */     out.append("import org.apache.log4j.Logger;\n\n");
/*  252 */     out.append("import dtv.data2.access.IObjectId;\n");
/*      */     
/*  254 */     out.append(this.helper_
/*  255 */         .getClassCommentWithSuppressWarnings("Auto-generated DAO\n *\n * DO NOT MANUALLY MODIFY THIS FILE."));
/*      */     
/*  257 */     out.append("public class " + argDtx.getName() + "DAO\n");
/*      */     
/*  259 */     if (argDtx.isExtended()) {
/*  260 */       out.append("    extends ");
/*  261 */       out.append(argDtx.getExtends().getDao());
/*  262 */       out.append("\n");
/*      */     }
/*  264 */     else if (argDtx.isExtensible()) {
/*  265 */       out.append("    extends dtv.data2.access.impl.AbstractExtensibleDAOImpl\n");
/*      */     } else {
/*      */       
/*  268 */       out.append("    extends dtv.data2.access.impl.AbstractDAOImpl\n");
/*      */     } 
/*      */     
/*  271 */     boolean hasConfigElementField = false;
/*      */     
/*  273 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  274 */       if (DaoGenConfigElementHelper.isConfigElementField(field)) {
/*  275 */         hasConfigElementField = true;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  280 */     if (argDtx.hasIncrementalField()) {
/*  281 */       out.append("    implements dtv.data2.access.impl.IHasIncrementalValues");
/*      */       
/*  283 */       if (hasConfigElementField) {
/*  284 */         out.append(", dtv.data2.access.IHasConfigElement");
/*      */       }
/*      */     }
/*  287 */     else if (hasConfigElementField) {
/*  288 */       out.append(" implements dtv.data2.access.IHasConfigElement");
/*      */     } 
/*      */     
/*  291 */     out.append(" {\n\n");
/*  292 */     out.append("  // Fix serialization compatability based on the name of the DAO\n");
/*  293 */     out.append("  private static final long serialVersionUID = " + argDtx.getName().hashCode() + "L;\n");
/*      */     
/*  295 */     out.append("  private static final Logger _logger = Logger.getLogger(" + argDtx
/*  296 */         .getDao() + ".class);\n\n");
/*      */     
/*  298 */     return out.toString();
/*      */   }
/*      */   
/*      */   private void getDAOMembers(StringBuilder out, DtxDefinition argDtx) {
/*  302 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFields();
/*      */     
/*  304 */     for (DtxDefinition.DtxDaoField field : fields) {
/*  305 */       String fieldType = DaoGenUtils.getConcreteDataType(field.getType());
/*  306 */       String fieldName = DaoGenUtils.getFieldNameForField(field);
/*  307 */       out.append("  private " + fieldType + " " + fieldName);
/*      */       
/*  309 */       if ("Boolean".equals(field.getType()))
/*      */       {
/*      */         
/*  312 */         out.append(" = Boolean.FALSE");
/*      */       }
/*  314 */       out.append(";\n");
/*      */       
/*  316 */       if (field.getIncrementField()) {
/*  317 */         out.append("  private " + fieldType + " _init" + StringUtils.ensureFirstUpperCase(field.getName()) + ";\n");
/*      */       }
/*      */     } 
/*      */     
/*  321 */     if (argDtx.hasIncrementalField()) {
/*  322 */       out.append("  protected boolean _incrementalActive = true;\n");
/*      */     }
/*  324 */     out.append("\n");
/*      */   }
/*      */   
/*      */   private void getDAOMethods(StringBuilder out, DtxDefinition argDtx) {
/*  328 */     getIncrementalActive(out, argDtx);
/*      */     
/*  330 */     for (DtxDefinition.DtxDaoField f : argDtx.getFields()) {
/*  331 */       String proper = StringUtils.ensureFirstUpperCase(f.getName());
/*  332 */       String arg = "arg" + proper;
/*  333 */       String argType = DaoGenUtils.getRawDataType(f.getType());
/*      */ 
/*      */       
/*  336 */       DaoGenUtils.appendGetterForField(out, f);
/*      */       
/*  338 */       if (f.getIncrementField()) {
/*  339 */         out.append("  public " + argType + " getInit" + proper + "() {\n");
/*  340 */         out.append("    return _init" + StringUtils.ensureFirstUpperCase(f.getName()) + ";\n");
/*  341 */         out.append("  }\n\n");
/*      */       } 
/*      */ 
/*      */       
/*  345 */       DaoGenUtils.appendSetterForField(out, f, true, true);
/*      */       
/*  347 */       if (f.getIncrementField()) {
/*  348 */         out.append("  public void setInit" + proper + "(" + argType + " " + arg + ") {\n");
/*  349 */         out.append("    _init" + StringUtils.ensureFirstUpperCase(f.getName()) + " = " + arg + ";\n");
/*  350 */         out.append("  }\n\n");
/*      */       } 
/*      */     } 
/*  353 */     out.append("\n");
/*      */   }
/*      */   
/*      */   private void getDAOToString(StringBuilder out, DtxDefinition argDtx) {
/*  357 */     out.append("  @Override\n");
/*  358 */     out.append("  public String toString() {\n");
/*  359 */     out.append("    StringBuilder buf = new StringBuilder(512);\n");
/*      */     
/*  361 */     if (!argDtx.isExtended()) {
/*  362 */       out.append("    buf.append(super.toString()).append(\" Id: \").append(getObjectId()).append(\" Values: \");\n");
/*      */     }
/*      */     else {
/*      */       
/*  366 */       out.append("    buf.append(super.toString());\n");
/*      */     } 
/*      */     
/*  369 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/*  370 */       if ("Boolean".equalsIgnoreCase(field.getType())) {
/*  371 */         out.append("    if (" + DaoGenUtils.getGetterNameForField(field) + "() != null && " + DaoGenUtils.getGetterNameForField(field) + "()) {\n");
/*      */       }
/*      */       else {
/*      */         
/*  375 */         out.append("    if (" + DaoGenUtils.getGetterNameForField(field) + "() != null) {\n");
/*      */       } 
/*      */ 
/*      */       
/*  379 */       String fieldValue = field.isSensitive() ? "REDACTED" : (DaoGenUtils.getGetterNameForField(field) + "()");
/*  380 */       out.append("      buf.append(\"" + field.getName() + "\").append(\"=\").append(" + fieldValue + ").append(\" \");\n");
/*      */       
/*  382 */       out.append("    }\n");
/*      */     } 
/*  384 */     out.append("\n    return buf.toString();\n");
/*  385 */     out.append("  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getDBADelete(StringBuilder out, DtxDefinition argDtx) {
/*  394 */     if (argDtx.isExtended() && argDtx.getTable().equals(argDtx.getExtends().getTable())) {
/*      */       return;
/*      */     }
/*      */     
/*  398 */     out.append("  private static final String[] DELETE_OBJECT = new String[] {\"DELETE FROM " + argDtx
/*  399 */         .getTable() + "\"};\n\n");
/*      */     
/*  401 */     if (argDtx.isExtended()) {
/*  402 */       out.append("  @Override\n");
/*      */     }
/*  404 */     out.append("  public String[] getDelete() {\n");
/*  405 */     if (!argDtx.isExtended()) {
/*  406 */       out.append("    return DELETE_OBJECT;\n");
/*      */     } else {
/*      */       
/*  409 */       out.append("    return dtv.util.ArrayUtils.combine(super.getDelete(), DELETE_OBJECT);\n");
/*      */     } 
/*  411 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAExtensions(StringBuilder out, DtxDefinition argDtx) {
/*  415 */     if (argDtx.isExtended()) {
/*  416 */       if (argDtx.getExtends().isExtended()) {
/*  417 */         out.append("  public String[] getAllSelects() {\n");
/*  418 */         out.append("    String[] sels = super.getAllSelects();\n");
/*  419 */         out.append("    String[] result = new String[sels.length+1];\n");
/*  420 */         out.append("    result[0] = getSelectImpl();\n");
/*  421 */         out.append("    System.arraycopy(sels, 0, result, 1, sels.length);\n");
/*  422 */         out.append("    return result;\n");
/*  423 */         out.append("  }\n\n");
/*      */         
/*  425 */         out.append("  public IFiller[] getAllFillers() {\n");
/*  426 */         out.append("    IFiller[] fills = super.getAllFillers();\n");
/*  427 */         out.append("    IFiller[] result = new IFiller[fills.length+1];\n");
/*  428 */         out.append("    result[0] = getFillerImpl();\n");
/*  429 */         out.append("    System.arraycopy(fills, 0, result, 1, fills.length);\n");
/*  430 */         out.append("    return result;\n");
/*  431 */         out.append("  }\n\n");
/*      */       } else {
/*      */         
/*  434 */         out.append("  public String[] getAllSelects() {\n");
/*  435 */         out.append("    return new String[] { getSelectImpl() };\n");
/*  436 */         out.append("  }\n\n");
/*      */         
/*  438 */         out.append("  public IFiller[] getAllFillers() {\n");
/*  439 */         out.append("    return new IFiller[] { getFillerImpl() };\n");
/*  440 */         out.append("  }\n\n");
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void getDBAFill(StringBuilder out, DtxDefinition argDtx) {
/*  446 */     if (argDtx.isExtensible()) {
/*  447 */       out.append("  public void fill(IJDBCTableAdapter argAdapter) {\n");
/*  448 */       out.append("    " + argDtx.getName() + "DBA adapter = (" + argDtx.getName() + "DBA) argAdapter;\n");
/*  449 */       for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  450 */         String fieldName = DaoGenUtils.getFieldNameForField(field);
/*  451 */         out.append("    " + fieldName + " = adapter." + fieldName + ";\n");
/*      */       } 
/*  453 */       out.append("  }\n\n");
/*      */     }
/*  455 */     else if (!argDtx.isExtended()) {
/*      */ 
/*      */ 
/*      */       
/*  459 */       out.append("  public void fill(IJDBCTableAdapter argAdapter) {\n");
/*  460 */       out.append("    // This DBA is not extensible, no need to implement!\n");
/*  461 */       out.append("  }\n\n");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void getDBAFiller(StringBuilder out, DtxDefinition argDtx) {
/*  466 */     if (argDtx.isExtended()) {
/*  467 */       out.append("  @Override\n");
/*      */     }
/*      */     
/*  470 */     out.append("  public IFiller getFiller() {\n");
/*  471 */     out.append("    return getFillerImpl();\n");
/*  472 */     out.append("  }\n\n");
/*      */     
/*  474 */     out.append("  private IFiller getFillerImpl() {\n");
/*  475 */     out.append("    return new " + argDtx.getName() + "Filler(this);\n");
/*  476 */     out.append("  }\n\n");
/*      */     
/*  478 */     out.append("  private static class " + argDtx.getName() + "Filler implements IFiller {\n\n");
/*  479 */     out.append("    private " + argDtx.getName() + "DBA _parent;\n\n");
/*  480 */     out.append("    public " + argDtx.getName() + "Filler(" + argDtx.getName() + "DBA argParent) {\n");
/*  481 */     out.append("      _parent = argParent;\n");
/*  482 */     out.append("    }\n\n");
/*      */     
/*  484 */     out.append("    public void fill(ResultSet argResultSet) throws java.sql.SQLException{");
/*      */     
/*  486 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFieldsPlusInheritedPrimaryKeys();
/*  487 */     int idx = 0;
/*  488 */     for (DtxDefinition.DtxDaoField field : fields) {
/*  489 */       idx++;
/*  490 */       String fieldName = DaoGenUtils.getFieldNameForField(field);
/*  491 */       String dbaField = "    _parent." + fieldName + " = ";
/*      */       
/*  493 */       if ("Date".equalsIgnoreCase(field.getType())) {
/*  494 */         String tempVariableName = "t" + idx;
/*      */         
/*  496 */         out.append("\n      java.sql.Timestamp " + tempVariableName + " = argResultSet.getTimestamp(" + idx + ");\n      if (" + tempVariableName + " != null) {\n    " + dbaField + " new dtv.util.DtvDate(" + tempVariableName + ".getTime());\n      }\n      else {\n        " + dbaField + " null;\n      }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  505 */       else if ("BigDecimal".equalsIgnoreCase(field.getType())) {
/*  506 */         out.append(dbaField + "argResultSet.g" + DaoGenUtils.getEtter(field.getType(), idx) + ";\n");
/*      */       }
/*  508 */       else if ("Long".equalsIgnoreCase(field.getType())) {
/*  509 */         out.append("\n      { // load Long value for field: " + field.getName() + " while preserving null values.\n");
/*      */         
/*  511 */         out.append("        long primitiveResult = argResultSet.getLong(" + idx + ");\n");
/*  512 */         out.append("        if (primitiveResult != 0 || argResultSet.getObject(" + idx + ") != null) {\n");
/*  513 */         out.append("        " + dbaField + "Long.valueOf(primitiveResult);\n");
/*  514 */         out.append("        }\n");
/*  515 */         out.append("      }\n\n");
/*      */       }
/*  517 */       else if ("Integer".equalsIgnoreCase(field.getType())) {
/*  518 */         out.append("\n      { // load Integer value for field: " + field.getName() + " while preserving null values.\n");
/*      */         
/*  520 */         out.append("        int primitiveResult = argResultSet.getInt(" + idx + ");\n");
/*  521 */         out.append("        if (primitiveResult != 0 || argResultSet.getObject(" + idx + ") != null) {\n");
/*  522 */         out.append("        " + dbaField + "Integer.valueOf(primitiveResult);\n");
/*  523 */         out.append("        }\n");
/*  524 */         out.append("      }\n\n");
/*      */       }
/*  526 */       else if ("Clob".equalsIgnoreCase(field.getType())) {
/*  527 */         out.append("\n    // load CLOB value for field: " + field.getName() + ".\n");
/*  528 */         out.append("    " + dbaField + "dtv.data2.access.impl.jdbc.JDBCHelper.clobToString(argResultSet, " + idx + ");\n\n");
/*      */       }
/*      */       else {
/*      */         
/*  532 */         out.append(dbaField + 
/*  533 */             DaoGenUtils.wrapStatementWithObject("argResultSet.g" + DaoGenUtils.getEtter(field.getType(), idx), field.getType()) + ";\n");
/*      */       } 
/*      */ 
/*      */       
/*  537 */       if (field.getIncrementField()) {
/*  538 */         String initField = "          _parent._init" + StringUtils.ensureFirstUpperCase(field.getName()) + " = ";
/*      */         
/*  540 */         if ("BigDecimal".equalsIgnoreCase(field.getType())) {
/*  541 */           out.append(initField + "argResultSet.g" + DaoGenUtils.getEtter(field.getType(), idx) + ";\n");
/*      */         } else {
/*      */           
/*  544 */           out.append(initField + 
/*  545 */               DaoGenUtils.wrapStatementWithObject("argResultSet.g" + DaoGenUtils.getEtter(field.getType(), idx), field.getType()) + ";\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  550 */     out.append("      }\n  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAFillFromDAO(StringBuilder out, DtxDefinition argDtx) {
/*  554 */     if (argDtx.isExtended()) {
/*  555 */       out.append("  @Override\n");
/*      */     }
/*      */     
/*  558 */     out.append("  public void fill(IDataAccessObject argDAO) {\n");
/*  559 */     out.append("    ");
/*  560 */     out.append(argDtx.getName());
/*  561 */     out.append("DAO dao = (");
/*  562 */     out.append(argDtx.getName());
/*  563 */     out.append("DAO)argDAO;\n");
/*      */     
/*  565 */     if (argDtx.isExtended()) {
/*  566 */       out.append("    super.fill(dao);\n");
/*      */     }
/*      */     
/*  569 */     int idx = 0;
/*  570 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  571 */       if ("Object".equalsIgnoreCase(field.getType())) {
/*  572 */         String fieldName = DaoGenUtils.getFieldNameForField(field);
/*  573 */         String varName = "oo" + idx++;
/*  574 */         out.append("    // BLOB field - Serialize the value for JDBC\n");
/*  575 */         out.append("    Object ");
/*  576 */         out.append(varName);
/*  577 */         out.append(" = dao.");
/*  578 */         out.append(DaoGenUtils.getGetterNameForField(field));
/*  579 */         out.append("();\n");
/*  580 */         out.append("    if (");
/*  581 */         out.append(varName);
/*  582 */         out.append(" != null) {\n");
/*  583 */         out.append("      try {\n");
/*  584 */         out.append("          java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();\n");
/*  585 */         out.append("          java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);\n");
/*  586 */         out.append("          oos.writeObject(");
/*  587 */         out.append(varName);
/*  588 */         out.append(");\n");
/*  589 */         out.append("          ");
/*  590 */         out.append(fieldName);
/*  591 */         out.append(" = baos.toByteArray();\n");
/*  592 */         out.append("      }\n");
/*  593 */         out.append("      catch (Exception ee) {\n");
/*  594 */         out.append("        throw new dtv.data2.access.exception.DtxException(\"An exception occurred while serializing to field: ");
/*      */         
/*  596 */         out.append(fieldName);
/*  597 */         out.append(". Value: \" + ");
/*  598 */         out.append(varName);
/*  599 */         out.append(", ee);\n");
/*  600 */         out.append("      }\n");
/*  601 */         out.append("    }\n");
/*  602 */         out.append("    else {\n");
/*  603 */         out.append("      ");
/*  604 */         out.append(fieldName);
/*  605 */         out.append(" = null;\n");
/*  606 */         out.append("    }\n\n");
/*      */       
/*      */       }
/*  609 */       else if ("Boolean".equalsIgnoreCase(field.getType())) {
/*  610 */         String method = DaoGenUtils.getGetterNameForField(field);
/*  611 */         out.append("    " + DaoGenUtils.getFieldNameForField(field) + " = dao." + method + "() != null ? dao." + method + "() : Boolean.valueOf(false);\n");
/*      */       }
/*      */       else {
/*      */         
/*  615 */         out.append("    ");
/*  616 */         out.append(DaoGenUtils.getFieldNameForField(field));
/*  617 */         out.append(" = dao.");
/*  618 */         out.append(DaoGenUtils.getGetterNameForField(field));
/*  619 */         out.append("();\n");
/*      */         
/*  621 */         if (field.getIncrementField()) {
/*  622 */           out.append("    _init");
/*  623 */           out.append(StringUtils.ensureFirstUpperCase(field.getName()));
/*  624 */           out.append(" = dao.getInit");
/*  625 */           out.append(StringUtils.ensureFirstUpperCase(field.getName()));
/*  626 */           out.append("();\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*  630 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAFooter(StringBuilder out, DtxDefinition argDtx) {
/*  634 */     out.append("}\n");
/*      */   }
/*      */   
/*      */   private void getDBAGetObjectId(StringBuilder out, DtxDefinition argDtx) {
/*  638 */     if (!argDtx.isExtended()) {
/*  639 */       out.append("  public IObjectId getObjectId() {\n");
/*  640 */       out.append("    " + argDtx.getId() + " id = new " + argDtx.getId() + "();\n");
/*  641 */       DtxDefinition.DtxDaoField[] primaryKeyfields = argDtx.getPrimaryKeyFields();
/*      */       
/*  643 */       for (DtxDefinition.DtxDaoField primaryKeyfield : primaryKeyfields) {
/*  644 */         out.append("    id." + DaoGenUtils.getSetterNameForField(primaryKeyfield) + "(" + 
/*  645 */             DaoGenUtils.getFieldNameForField(primaryKeyfield) + ");\n");
/*      */       }
/*  647 */       out.append("    return id;\n");
/*  648 */       out.append("  }\n\n");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void getDBAHeader(StringBuilder out, DtxDefinition argDtx) {
/*  653 */     out.append("package ");
/*  654 */     out.append(argDtx.getPackage());
/*  655 */     out.append(";\n\n");
/*      */     
/*  657 */     out.append("import java.sql.PreparedStatement;\nimport java.sql.ResultSet;\nimport java.util.Date;\nimport java.util.List;\n\nimport dtv.data2.access.IDataAccessObject;\nimport dtv.data2.access.IObjectId;\nimport dtv.data2.access.impl.jdbc.IFiller;\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  665 */     if (argDtx.isExtended()) {
/*  666 */       out.append("import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;\n\n");
/*      */     } else {
/*      */       
/*  669 */       out.append("import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;\n\n");
/*      */     } 
/*      */     
/*  672 */     out.append(this.helper_.getClassCommentWithSuppressWarnings("Auto-generated DBA"));
/*      */     
/*  674 */     out.append("public class ");
/*  675 */     out.append(argDtx.getName());
/*  676 */     out.append("DBA");
/*  677 */     if (argDtx.isExtended()) {
/*  678 */       out.append(" extends ");
/*  679 */       out.append(argDtx.getExtends().getDba());
/*  680 */       out.append(" implements IExtendedJDBCAdapter");
/*      */     } else {
/*      */       
/*  683 */       out.append(" implements IJDBCTableAdapter");
/*      */     } 
/*      */     
/*  686 */     if (argDtx.hasIncrementalField()) {
/*  687 */       out.append(", dtv.data2.access.impl.IHasIncrementalValues");
/*      */     }
/*      */     
/*  690 */     out.append(" {\n\n");
/*      */     
/*  692 */     out.append("  // Fix serialization compatability based on the name of the DAO\n  private static final long serialVersionUID = ");
/*      */     
/*  694 */     out.append(String.valueOf(argDtx.getName().hashCode()));
/*  695 */     out.append("L;\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getDBAInsert(StringBuilder out, DtxDefinition argDtx) {
/*  704 */     if (argDtx.isExtended() && argDtx.getTable().equals(argDtx.getExtends().getTable())) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  711 */     out.append("  private static final String[] INSERT_OBJECT = new String[] {\"");
/*  712 */     getDBAInsertSql(out, argDtx);
/*  713 */     out.append("\"};\n\n");
/*  714 */     if (argDtx.isExtended()) {
/*  715 */       out.append("  @Override\n");
/*      */     }
/*  717 */     out.append("  public String[] getInsert() {\n");
/*      */     
/*  719 */     if (!argDtx.isExtended()) {
/*  720 */       out.append("    return INSERT_OBJECT;\n");
/*      */     } else {
/*      */       
/*  723 */       out.append("    return dtv.util.ArrayUtils.combine(super.getInsert(), INSERT_OBJECT);\n");
/*      */     } 
/*  725 */     out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  730 */     if (argDtx.isExtended()) {
/*  731 */       out.append("  @Override\n");
/*      */     }
/*  733 */     out.append("  public Object[][] getInsertParameters() {\n");
/*  734 */     out.append("    Object[][] insertParameterObject = new Object[][] {{");
/*  735 */     getDBAInsertParameters(out, argDtx);
/*  736 */     out.append("}};\n");
/*      */     
/*  738 */     if (!argDtx.isExtended()) {
/*  739 */       out.append("    return insertParameterObject;\n");
/*      */     } else {
/*      */       
/*  742 */       out.append("    return dtv.util.ArrayUtils.combine(super.getInsertParameters(), insertParameterObject);\n");
/*      */     } 
/*      */     
/*  745 */     out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  750 */     out.append("  private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] {{");
/*  751 */     getDBAInsertParameterTypes(out, argDtx);
/*  752 */     out.append("}};\n\n");
/*      */     
/*  754 */     if (argDtx.isExtended()) {
/*  755 */       out.append("  @Override\n");
/*      */     }
/*  757 */     out.append("  public int[][] getInsertParameterTypes() {\n");
/*      */     
/*  759 */     if (!argDtx.isExtended()) {
/*  760 */       out.append("    return INSERT_PARAMETER_TYPES_OBJECT;\n");
/*      */     } else {
/*      */       
/*  763 */       out.append("    return dtv.util.ArrayUtils.combine(super.getInsertParameterTypes(), INSERT_PARAMETER_TYPES_OBJECT);\n");
/*      */     } 
/*      */     
/*  766 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAInsertParameters(StringBuilder out, DtxDefinition argDtx) {
/*  770 */     boolean orgNoded = argDtx.isOrgHierarchical();
/*      */     
/*  772 */     String prevSeparator = "";
/*  773 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  774 */       out.append(prevSeparator);
/*      */       
/*  776 */       if (orgNoded && DaoGenOrgHierarchyHelper.isOrgHierarchyField(field)) {
/*  777 */         DaoGenOrgHierarchyHelper.writeOrgHierarchyCUDParam(argDtx, field, out);
/*      */       }
/*  779 */       else if (DaoGenConfigElementHelper.isConfigElementField(field)) {
/*  780 */         DaoGenConfigElementHelper.ensureNonNullConfigElement(field, out);
/*      */       } else {
/*      */         
/*  783 */         out.append(DaoGenUtils.getFieldNameForField(field));
/*      */       } 
/*  785 */       prevSeparator = ", ";
/*      */     } 
/*      */   }
/*      */   
/*      */   private void getDBAInsertParameterTypes(StringBuilder out, DtxDefinition argDtx) {
/*  790 */     String prevSeparator = "";
/*  791 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  792 */       out.append(prevSeparator);
/*  793 */       out.append(String.valueOf(DaoGenUtils.getTypeForField(field)));
/*  794 */       prevSeparator = ", ";
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getDBAInsertSql(StringBuilder out, DtxDefinition argDtx) {
/*  802 */     out.append("INSERT INTO " + argDtx.getTable() + "(");
/*      */     
/*  804 */     String prevSeparator = "";
/*  805 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFieldsPlusInheritedPrimaryKeys();
/*  806 */     for (DtxDefinition.DtxDaoField field : fields) {
/*  807 */       out.append(prevSeparator);
/*  808 */       out.append(field.getColumn());
/*  809 */       prevSeparator = ", ";
/*      */     } 
/*      */     
/*  812 */     out.append(") VALUES (");
/*      */     
/*  814 */     prevSeparator = "";
/*      */     
/*  816 */     for (DtxDefinition.DtxDaoField field : fields) {
/*  817 */       out.append(prevSeparator);
/*  818 */       out.append("?");
/*  819 */       prevSeparator = ", ";
/*      */     } 
/*      */     
/*  822 */     out.append(")");
/*      */   }
/*      */   
/*      */   private void getDBALoadDAO(StringBuilder out, DtxDefinition argDtx) {
/*  826 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFieldsPlusInheritedPrimaryKeys();
/*      */     
/*  828 */     if (argDtx.isExtended()) {
/*  829 */       out.append("  @Override\n");
/*      */     }
/*      */     
/*  832 */     out.append("  public IDataAccessObject loadDAO(IDataAccessObject argDAO) {\n");
/*  833 */     if (argDtx.isExtended()) {
/*  834 */       out.append("    super.loadDAO(argDAO);\n");
/*      */     }
/*  836 */     out.append("    argDAO.suppressStateChanges(true);\n");
/*  837 */     out.append("    " + argDtx.getName() + "DAO dao = (" + argDtx.getName() + "DAO)argDAO;\n");
/*  838 */     for (DtxDefinition.DtxDaoField field : fields) {
/*  839 */       String fieldName = DaoGenUtils.getFieldNameForField(field);
/*  840 */       String setterName = DaoGenUtils.getSetterNameForField(field);
/*  841 */       if (field.getType().equalsIgnoreCase("Object")) {
/*  842 */         out.append("    // BLOB field - Deserialize the raw bytes\n    if (");
/*      */         
/*  844 */         out.append(fieldName);
/*  845 */         out.append(" != null) {\n        try {\n            java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(");
/*      */ 
/*      */         
/*  848 */         out.append(fieldName);
/*  849 */         out.append(");\n            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);\n            Object o = ois.readObject();\n            dao.");
/*      */ 
/*      */ 
/*      */         
/*  853 */         out.append(setterName);
/*  854 */         out.append("(o); // deserialize\n        }\n        catch (Exception ee) {\n          throw new dtv.data2.access.exception.DtxException(\"An exception occurred while deserializing field: ");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  859 */         out.append(fieldName);
/*  860 */         out.append(". Value: \" + ");
/*  861 */         out.append(fieldName);
/*  862 */         out.append(", ee);\n        }\n    }\n    else {\n      dao.");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  867 */         out.append(setterName);
/*  868 */         out.append("(null);\n    }\n");
/*      */       }
/*      */       else {
/*      */         
/*  872 */         out.append("    dao.");
/*  873 */         out.append(setterName);
/*  874 */         out.append("(");
/*  875 */         out.append(fieldName);
/*  876 */         out.append(");\n");
/*      */         
/*  878 */         if (field.getIncrementField()) {
/*  879 */           out.append("    dao.setInit");
/*  880 */           out.append(StringUtils.ensureFirstUpperCase(field.getName()));
/*  881 */           out.append("(");
/*  882 */           out.append(fieldName);
/*  883 */           out.append(");\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*  887 */     out.append("    argDAO.suppressStateChanges(false);\n");
/*  888 */     out.append("    return dao;\n");
/*  889 */     out.append("  }\n\n");
/*      */     
/*  891 */     if (argDtx.isExtended()) {
/*  892 */       out.append("  @Override\n");
/*      */     }
/*      */     
/*  895 */     out.append("  public IDataAccessObject loadDefaultDAO() {\n");
/*  896 */     out.append("    return loadDAO(new ");
/*  897 */     out.append(argDtx.getName());
/*  898 */     out.append("DAO());\n");
/*  899 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAMembers(StringBuilder out, DtxDefinition argDtx) {
/*  903 */     for (DtxDefinition.DtxDaoField f : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  904 */       if (f.getType().equalsIgnoreCase("Object")) {
/*  905 */         out.append("  private byte[] _");
/*  906 */         out.append(f.getName());
/*  907 */         out.append(";\n");
/*      */       } else {
/*      */         
/*  910 */         out.append("  private ");
/*  911 */         out.append(DaoGenUtils.getRawDataType(f.getType()));
/*  912 */         out.append(" ");
/*  913 */         out.append(DaoGenUtils.getFieldNameForField(f));
/*  914 */         out.append(";\n");
/*  915 */         if (f.getIncrementField()) {
/*  916 */           out.append("  private ");
/*  917 */           out.append(DaoGenUtils.getRawDataType(f.getType()));
/*  918 */           out.append(" _init");
/*  919 */           out.append(StringUtils.ensureFirstUpperCase(f.getName()));
/*  920 */           out.append(";\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  925 */     if (argDtx.hasIncrementalField()) {
/*  926 */       out.append("  protected boolean _incrementalActive = true;\n");
/*      */     }
/*  928 */     out.append("\n");
/*      */   }
/*      */   
/*      */   private void getDBAMethods(StringBuilder out, DtxDefinition argDtx) {
/*  932 */     getIncrementalActive(out, argDtx);
/*      */     
/*  934 */     getDBASelect(out, argDtx);
/*  935 */     getDBAInsert(out, argDtx);
/*  936 */     getDBAUpdate(out, argDtx);
/*  937 */     getDBADelete(out, argDtx);
/*  938 */     getDBAWhere(out, argDtx);
/*      */     
/*  940 */     getDaoDbaUpdateDiffMethods(out, argDtx);
/*  941 */     getDBATableName(out, argDtx);
/*  942 */     getDBAFiller(out, argDtx);
/*  943 */     getDBALoadDAO(out, argDtx);
/*  944 */     getDBAFillFromDAO(out, argDtx);
/*      */     
/*  946 */     getDBAWriteObjectId(out, argDtx);
/*  947 */     getDBAGetObjectId(out, argDtx);
/*  948 */     getDBAFill(out, argDtx);
/*  949 */     getDBARemaining(out, argDtx);
/*  950 */     getDBAExtensions(out, argDtx);
/*      */   }
/*      */   
/*      */   private void getDBARemaining(StringBuilder out, DtxDefinition argDtx) {
/*  954 */     if (!argDtx.isExtended()) {
/*  955 */       out.append("  public boolean isExtensible() {\n");
/*  956 */       out.append("    return " + argDtx.isExtensible() + ";\n");
/*  957 */       out.append("  }\n\n");
/*      */       
/*  959 */       out.append("  public String getImplementingClass() {\n");
/*  960 */       if (argDtx.isExtensible()) {
/*  961 */         out.append("    return _" + argDtx.getImplementingClassField() + ";\n");
/*      */       } else {
/*      */         
/*  964 */         out.append("    return null; // This DBA is not extensible\n");
/*      */       } 
/*  966 */       out.append("  }\n\n");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void getDBASelect(StringBuilder out, DtxDefinition argDtx) {
/*  972 */     out.append("  private static final String SELECT_OBJECT = ");
/*  973 */     out.append("\"SELECT ");
/*  974 */     String prevSeparator = "";
/*  975 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*  976 */       out.append(prevSeparator);
/*  977 */       out.append("t.");
/*  978 */       out.append(field.getColumn());
/*  979 */       prevSeparator = ", ";
/*      */     } 
/*  981 */     out.append(" FROM ");
/*  982 */     out.append(argDtx.getTable());
/*  983 */     out.append(" t\";\n\n");
/*      */     
/*  985 */     if (argDtx.isExtended()) {
/*  986 */       out.append("  @Override\n");
/*      */     }
/*  988 */     out.append("  public String getSelect() {\n    return getSelectImpl();\n  }\n\n  private String getSelectImpl() {\n    return SELECT_OBJECT;\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  994 */     out.append("  }\n\n");
/*      */     
/*  996 */     getDBASelectWhere(out, argDtx);
/*      */   }
/*      */   
/*      */   private void getDBASelectWhere(StringBuilder out, DtxDefinition argDtx) {
/* 1000 */     boolean isOrgHierarchical = argDtx.isOrgHierarchical();
/*      */     
/* 1002 */     out.append("  private static final String SELECT_WHERE_OBJECT = \"");
/* 1003 */     boolean whereWritten = false;
/*      */     
/* 1005 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 1006 */       if (field.isPrimaryKey() && (
/* 1007 */         !isOrgHierarchical || !DaoGenOrgHierarchyHelper.isOrgHierarchyField(field))) {
/* 1008 */         if (whereWritten) {
/* 1009 */           out.append(" AND ");
/*      */         } else {
/*      */           
/* 1012 */           out.append(" WHERE ");
/* 1013 */           whereWritten = true;
/*      */         } 
/* 1015 */         out.append(field.getColumn());
/* 1016 */         out.append(" = ? ");
/*      */       } 
/*      */     } 
/*      */     
/* 1020 */     out.append(" \";\n\n");
/*      */     
/* 1022 */     if (argDtx.isExtended()) {
/* 1023 */       out.append("  @Override\n");
/*      */     }
/* 1025 */     out.append("  public String getSelectWhere() {\n");
/* 1026 */     out.append("    return SELECT_WHERE_OBJECT;\n");
/* 1027 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBATableName(StringBuilder out, DtxDefinition argDtx) {
/* 1031 */     if (argDtx.isExtended()) {
/* 1032 */       out.append("  @Override\n");
/*      */     }
/* 1034 */     out.append("  public String getTableName() {\n    return \"" + argDtx
/* 1035 */         .getTable() + "\";\n  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getDBAUpdate(StringBuilder out, DtxDefinition argDtx) {
/* 1045 */     if ((argDtx.isExtended() && argDtx.getTable().equals(argDtx.getExtends().getTable())) || argDtx
/* 1046 */       .getNonPkFields().isEmpty()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1055 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFieldsPlusInheritedPrimaryKeys();
/*      */     
/* 1057 */     if (argDtx.hasIncrementalField()) {
/* 1058 */       out.append("  public String[] getUpdate () {\n");
/* 1059 */       out.append("    if (_incrementalActive) {\n");
/* 1060 */       out.append("      return getIncrementalUpdate();\n");
/* 1061 */       out.append("    }\n");
/* 1062 */       out.append("    else {\n");
/* 1063 */       out.append("      return getStandardUpdate();\n");
/* 1064 */       out.append("    }\n");
/* 1065 */       out.append("  }\n\n");
/*      */       
/* 1067 */       getDBAUpdateMethod(out, argDtx, "getIncrementalUpdate", true, false);
/* 1068 */       getDBAUpdateMethod(out, argDtx, "getStandardUpdate", false, false);
/*      */     } else {
/*      */       
/* 1071 */       getDBAUpdateMethod(out, argDtx, "getUpdate", true, argDtx.isExtended());
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1078 */     if (argDtx.isExtended()) {
/* 1079 */       out.append("  @Override\n");
/*      */     }
/* 1081 */     out.append("  public Object[][] getUpdateParameters() {\n");
/* 1082 */     out.append("    Object[][] updateParameterObject = new Object[][] {{");
/* 1083 */     getDBAUpdateCurrentFieldList(out, fields);
/* 1084 */     out.append("}};\n");
/*      */     
/* 1086 */     if (!argDtx.isExtended()) {
/* 1087 */       out.append("    return updateParameterObject;\n");
/*      */     } else {
/*      */       
/* 1090 */       out.append("    return dtv.util.ArrayUtils.combine(super.getUpdateParameters(), updateParameterObject);\n");
/*      */     } 
/*      */ 
/*      */     
/* 1094 */     out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1099 */     out.append("  private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] {{");
/* 1100 */     getDBAUpdateParameters(out, fields);
/* 1101 */     out.append("}};\n");
/*      */     
/* 1103 */     if (argDtx.isExtended()) {
/* 1104 */       out.append("  @Override\n");
/*      */     }
/* 1106 */     out.append("  public int[][] getUpdateParameterTypes() {\n");
/* 1107 */     if (!argDtx.isExtended()) {
/* 1108 */       out.append("    return UPDATE_PARAMETER_TYPE_OBJECT;\n");
/*      */     } else {
/*      */       
/* 1111 */       out.append("    return dtv.util.ArrayUtils.combine(super.getUpdateParameterTypes(), UPDATE_PARAMETER_TYPE_OBJECT);\n");
/*      */     } 
/*      */ 
/*      */     
/* 1115 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAUpdateCurrentFieldList(StringBuilder w, DtxDefinition.DtxDaoField[] fields) {
/* 1119 */     String prevSeparator = "";
/* 1120 */     for (DtxDefinition.DtxDaoField field : fields) {
/* 1121 */       if (!field.isPrimaryKey() && !Arrays.<String>asList(FIELDS_EXCLUDED_FROM_UPDATE).contains(field.getName())) {
/* 1122 */         w.append(prevSeparator);
/* 1123 */         if (field.getIncrementField()) {
/* 1124 */           w.append(DaoGenUtils.getGetterNameForField(field));
/* 1125 */           w.append("Diff()");
/*      */         }
/* 1127 */         else if (DaoGenConfigElementHelper.isConfigElementField(field)) {
/* 1128 */           DaoGenConfigElementHelper.ensureNonNullConfigElement(field, w);
/*      */         } else {
/*      */           
/* 1131 */           w.append(DaoGenUtils.getFieldNameForField(field));
/*      */         } 
/* 1133 */         prevSeparator = ", ";
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void getDBAUpdateMethod(StringBuilder out, DtxDefinition argDtx, String argMethodName, boolean argHonorIncremental, boolean argIsExtended) {
/* 1140 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFieldsPlusInheritedPrimaryKeys();
/*      */     
/* 1142 */     String fieldName = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, argMethodName.substring(3)) + "_OBJECT";
/*      */     
/* 1144 */     out.append("  private static final String[] " + fieldName + " = new String[] {\"");
/* 1145 */     getDBAUpdateSql(out, argDtx, fields, argHonorIncremental);
/* 1146 */     out.append("\"};\n\n");
/*      */     
/* 1148 */     if (argIsExtended) {
/* 1149 */       out.append("  @Override\n");
/*      */     }
/* 1151 */     out.append("  public String[] " + argMethodName + "() {\n");
/*      */     
/* 1153 */     if (!argDtx.isExtended()) {
/* 1154 */       out.append("    return " + fieldName + ";\n");
/*      */     } else {
/*      */       
/* 1157 */       out.append("    return dtv.util.ArrayUtils.combine(super.getUpdate(), " + fieldName + ");\n");
/*      */     } 
/*      */     
/* 1160 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getDBAUpdateParameters(StringBuilder out, DtxDefinition.DtxDaoField[] fields) {
/* 1164 */     String prevSeparator = "";
/* 1165 */     for (DtxDefinition.DtxDaoField field : fields) {
/* 1166 */       if (!field.isPrimaryKey() && !Arrays.<String>asList(FIELDS_EXCLUDED_FROM_UPDATE).contains(field.getName())) {
/* 1167 */         out.append(prevSeparator);
/* 1168 */         out.append(String.valueOf(DaoGenUtils.getTypeForField(field)));
/* 1169 */         prevSeparator = ", ";
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getDBAUpdateSql(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField[] fields, boolean argHonorIncrementalFields) {
/* 1181 */     out.append("UPDATE ");
/* 1182 */     out.append(argDtx.getTable());
/* 1183 */     out.append(" SET ");
/*      */     
/* 1185 */     String prevSeparator = "";
/* 1186 */     for (DtxDefinition.DtxDaoField field : fields) {
/* 1187 */       if (!field.isPrimaryKey() && !Arrays.<String>asList(FIELDS_EXCLUDED_FROM_UPDATE).contains(field.getName())) {
/* 1188 */         out.append(prevSeparator);
/* 1189 */         if (field.getIncrementField() && argHonorIncrementalFields) {
/* 1190 */           out.append(field.getColumn());
/* 1191 */           out.append(" = ");
/* 1192 */           out.append(field.getColumn());
/* 1193 */           out.append(" + ?");
/*      */         } else {
/*      */           
/* 1196 */           out.append(field.getColumn());
/* 1197 */           out.append(" = ?");
/*      */         } 
/* 1199 */         prevSeparator = ", ";
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void getDBAWhere(StringBuilder out, DtxDefinition argDtx) {
/* 1206 */     out.append("  private static final String WHERE_OBJECT = \"");
/* 1207 */     boolean whereWritten = false;
/* 1208 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 1209 */       if (field.isPrimaryKey()) {
/* 1210 */         if (whereWritten) {
/* 1211 */           out.append(" AND ");
/*      */         } else {
/*      */           
/* 1214 */           out.append(" WHERE ");
/* 1215 */           whereWritten = true;
/*      */         } 
/* 1217 */         out.append(field.getColumn());
/* 1218 */         out.append(" = ? ");
/*      */       } 
/*      */     } 
/* 1221 */     out.append(" \";\n\n");
/*      */     
/* 1223 */     if (argDtx.isExtended()) {
/* 1224 */       out.append("  @Override\n");
/*      */     }
/* 1226 */     out.append("  public String getWhere() {\n");
/* 1227 */     out.append("    return WHERE_OBJECT;");
/* 1228 */     out.append("  }\n\n");
/*      */     
/* 1230 */     getWhereParameters(out, argDtx);
/* 1231 */     getWhereParameterTypes(out, argDtx);
/*      */   }
/*      */   
/*      */   private void getDBAWriteObjectId(StringBuilder sb, DtxDefinition argDtx) {
/* 1235 */     boolean orgNoded = argDtx.isOrgHierarchical();
/* 1236 */     DtxDefinition.DtxDaoField[] primaryKeyfields = argDtx.getPrimaryKeyFields();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1241 */     if (argDtx.isExtended() && argDtx.getExtends().isPlaceHolder()) {
/*      */       return;
/*      */     }
/* 1244 */     boolean hasKey = (primaryKeyfields.length > 0);
/*      */     
/* 1246 */     if (argDtx.isExtended()) {
/* 1247 */       sb.append("  @Override\n");
/*      */     }
/*      */     
/* 1250 */     sb.append("  public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) ");
/* 1251 */     if (hasKey) {
/* 1252 */       sb.append("throws java.sql.SQLException ");
/*      */     }
/* 1254 */     sb.append("{\n");
/*      */     
/* 1256 */     if (hasKey) {
/* 1257 */       sb.append("    ").append(argDtx.getId()).append(" id = (").append(argDtx.getId()).append(") argId;\n");
/*      */     }
/*      */     
/* 1260 */     for (int i = 0; i < primaryKeyfields.length; i++) {
/* 1261 */       if (!orgNoded || !DaoGenOrgHierarchyHelper.isOrgHierarchyField(primaryKeyfields[i])) {
/*      */ 
/*      */ 
/*      */         
/* 1265 */         sb.append("      argStatement.s");
/* 1266 */         sb.append(DaoGenUtils.getEtterInputObject(primaryKeyfields[i].getType(), i + 1, "id.get" + 
/* 1267 */               StringUtils.ensureFirstUpperCase(DaoGenUtils.toPrimitive(primaryKeyfields[i]))));
/* 1268 */         sb.append(";\n");
/*      */       } 
/* 1270 */     }  sb.append("    return argStatement;\n");
/* 1271 */     sb.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private void getIncrementalActive(StringBuilder out, DtxDefinition argDtx) {
/* 1275 */     if (argDtx.hasIncrementalField()) {
/* 1276 */       out.append("  public void setIncrementalActive(boolean argActive) {\n");
/* 1277 */       out.append("    _incrementalActive = argActive;\n");
/* 1278 */       out.append("  }\n\n");
/*      */       
/* 1280 */       out.append("  public boolean getIncrementalActive() {\n");
/* 1281 */       out.append("    return _incrementalActive;\n");
/* 1282 */       out.append("  }\n\n");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getWhereParameters(StringBuilder out, DtxDefinition argDtx) {
/* 1290 */     boolean orgNoded = argDtx.isOrgHierarchical();
/*      */     
/* 1292 */     if (argDtx.isExtended()) {
/* 1293 */       out.append("  @Override\n");
/*      */     }
/* 1295 */     out.append("  public Object[] getWhereParameters() {\n    return new Object[] { ");
/*      */ 
/*      */     
/* 1298 */     String prevSeparator = "";
/* 1299 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 1300 */       if (field.isPrimaryKey()) {
/* 1301 */         out.append(prevSeparator);
/*      */         
/* 1303 */         if (orgNoded && DaoGenOrgHierarchyHelper.isOrgHierarchyField(field)) {
/* 1304 */           DaoGenOrgHierarchyHelper.writeOrgHierarchyCUDParam(argDtx, field, out);
/*      */         }
/* 1306 */         else if (DaoGenConfigElementHelper.isConfigElementField(field)) {
/* 1307 */           DaoGenConfigElementHelper.ensureNonNullConfigElement(field, out);
/*      */         } else {
/*      */           
/* 1310 */           out.append(DaoGenUtils.getFieldNameForField(field));
/*      */         } 
/* 1312 */         prevSeparator = ", ";
/*      */       } 
/*      */     } 
/*      */     
/* 1316 */     out.append(" };\n  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getWhereParameterTypes(StringBuilder w, DtxDefinition argDtx) {
/* 1325 */     w.append("  private static final int[] WHERE_PARAMETER_OBJECT = new int[] { ");
/* 1326 */     String prevSeparator = "";
/* 1327 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/* 1328 */       if (field.isPrimaryKey()) {
/* 1329 */         w.append(prevSeparator);
/* 1330 */         w.append(String.valueOf(DaoGenUtils.getTypeForField(field)));
/* 1331 */         prevSeparator = ", ";
/*      */       } 
/*      */     } 
/* 1334 */     w.append(" };\n\n");
/*      */     
/* 1336 */     if (argDtx.isExtended()) {
/* 1337 */       w.append("  @Override\n");
/*      */     }
/* 1339 */     w.append("  public int[] getWhereParameterTypes() {\n");
/* 1340 */     w.append("    return WHERE_PARAMETER_OBJECT;");
/* 1341 */     w.append("  }\n\n");
/*      */   }
/*      */   
/*      */   private String makeCast(DtxDefinition.DtxDaoField field) {
/* 1345 */     String type = DaoGenUtils.getRawDataType(field.getType());
/* 1346 */     if ("Object".equals(type)) {
/* 1347 */       return "";
/*      */     }
/* 1349 */     return "(" + type + ")";
/*      */   }
/*      */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateDaoAndDba.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */