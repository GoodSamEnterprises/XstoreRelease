/*      */ package dtv.data2.access.impl.daogen;
/*      */ 
/*      */ import dtv.util.FileUtils;
/*      */ import dtv.util.StringUtils;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.util.List;
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
/*      */ public class DefaultModelGenerator
/*      */   implements IModelGenerator
/*      */ {
/*      */   private final DaoGenHelper _helper;
/*      */   
/*      */   public DefaultModelGenerator(DaoGenHelper argHelper) {
/*   30 */     this._helper = argHelper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String generateModel(DtxDefinition argDtxDefinition) throws IOException {
/*   37 */     StringBuilder sb = new StringBuilder(20480);
/*   38 */     generateHeader(sb, argDtxDefinition);
/*   39 */     generateFields(sb, argDtxDefinition);
/*   40 */     generateDaoMethods(sb, argDtxDefinition);
/*      */     
/*   42 */     List<DtxRelationship> relationships = argDtxDefinition.getRelationships();
/*      */     
/*   44 */     if (DaoGenHelper.isPropertyChildNeeded(argDtxDefinition)) {
/*   45 */       generatePropertyMethods(sb, argDtxDefinition);
/*      */     }
/*      */     
/*   48 */     generateRelationshipFields(sb, relationships);
/*   49 */     generateRelationshipMethods(sb, argDtxDefinition, relationships);
/*      */     
/*   51 */     if (!argDtxDefinition.isProperties()) {
/*   52 */       generateExtensionMethods(sb, argDtxDefinition);
/*      */     }
/*      */     
/*   55 */     generateTransactionMethods(sb, argDtxDefinition);
/*      */     
/*   57 */     String dtjContents = getDtjContents(argDtxDefinition.getDtj());
/*      */     
/*   59 */     if (dtjContents.indexOf("private void readObject") == -1) {
/*   60 */       generateCustomSerialization(sb, argDtxDefinition);
/*      */     }
/*      */     
/*   63 */     sb = overrideMethods(argDtxDefinition, sb, dtjContents);
/*      */     
/*   65 */     sb.append(dtjContents);
/*   66 */     generateFooter(sb, argDtxDefinition);
/*      */     
/*   68 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addListInitializer(StringBuilder out, DtxRelationship relationship, String argInitializeWith, String argElseSetList) {
/*   73 */     String initializeFieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*   74 */     out.append("    if (").append(initializeFieldName).append(" == null) {\n");
/*   75 */     out.append("      ").append(initializeFieldName).append(" = new HistoricalList<")
/*   76 */       .append(relationship.getChild().getInterface()).append(">(").append(argInitializeWith).append(");\n");
/*   77 */     out.append("    }");
/*   78 */     if (argElseSetList != null) {
/*   79 */       out.append(" else { \n");
/*   80 */       out.append("      ").append(initializeFieldName).append(".setCurrentList(").append(argInitializeWith)
/*   81 */         .append(");\n");
/*   82 */       out.append("    }");
/*      */     } 
/*   84 */     out.append("\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateCustomSerialization(StringBuilder out, DtxDefinition argDtx) {
/*   94 */     out.append("  private void readObject(java.io.ObjectInputStream argStream)\n                         throws java.io.IOException, ClassNotFoundException {\n    argStream.defaultReadObject();\n  }\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateDaoMethods(StringBuilder out, DtxDefinition argDtx) {
/*  101 */     if (!argDtx.isExtended()) {
/*  102 */       out.append("  @Override\n  public String toString() {\n    return super.toString() + \" Id: \" + this.getObjectId();\n  }\n\n");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  108 */     out.append("  @Override\n  public void initDAO() {\n    setDAO(new ");
/*      */ 
/*      */     
/*  111 */     out.append(argDtx.getName());
/*  112 */     out.append("DAO());\n  }\n\n  /**\n   * Return the data access object associated with this data model\n   * @return our DAO, properly casted\n   */\n  private ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  120 */     out.append(argDtx.getName());
/*  121 */     out.append("DAO getDAO_() {\n     return (");
/*      */     
/*  123 */     out.append(argDtx.getName());
/*  124 */     out.append("DAO) _daoImpl;\n  }\n\n");
/*      */ 
/*      */ 
/*      */     
/*  128 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*      */ 
/*      */       
/*  131 */       if (!argDtx.isExtended() || !field.isPrimaryKey() || 
/*  132 */         !argDtx.getRelationships(DtxRelationship.ONE_MANY).isEmpty()) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  137 */         generateFieldGetter(out, argDtx, field);
/*  138 */         generateFieldSetter(out, argDtx, field);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateEncryptedFieldGetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  146 */     String getterName = DaoGenUtils.getGetterNameForField(argField);
/*  147 */     String encryptedGetterName = DaoGenUtils.getGetterNameForField(argField) + "Encrypted";
/*      */     
/*  149 */     out.append("  /**\n   * Gets the value of the ");
/*      */     
/*  151 */     out.append(argField.getColumn());
/*  152 */     out.append(" field.\n   * @return The encrypted value of the field.\n   */\n  public ");
/*      */ 
/*      */ 
/*      */     
/*  156 */     out.append(DaoGenUtils.getVariableType(argField.getType()));
/*  157 */     out.append(" ");
/*  158 */     out.append(encryptedGetterName);
/*  159 */     out.append("() {\n");
/*      */     
/*  161 */     out.append("    return getDAO_().");
/*  162 */     out.append(getterName);
/*  163 */     out.append("()");
/*  164 */     out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  165 */     out.append(";\n");
/*      */     
/*  167 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   protected void generateExtensionMethods(StringBuilder out, DtxDefinition argDtx) {
/*  171 */     out.append("  public IDataModel get" + argDtx.getName() + "Ext() {\n");
/*  172 */     out.append("    return _myExtension;\n");
/*  173 */     out.append("  }\n\n");
/*      */     
/*  175 */     out.append("  public void set" + argDtx.getName() + "Ext(IDataModel argExt) {\n");
/*  176 */     out.append("    _myExtension = argExt;\n");
/*  177 */     out.append("  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateFieldGetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  184 */     String getterName = DaoGenUtils.getGetterNameForField(argField);
/*      */     
/*  186 */     out.append("  /**\n   * Gets the value of the ");
/*      */     
/*  188 */     out.append(argField.getColumn());
/*  189 */     out.append(" field.\n   * @return The value of the field.\n   */\n  public ");
/*      */ 
/*      */ 
/*      */     
/*  193 */     out.append(DaoGenUtils.getVariableType(argField.getType()));
/*  194 */     out.append(" ");
/*  195 */     out.append(getterName);
/*  196 */     out.append("() {\n");
/*      */     
/*  198 */     if ("Boolean".equalsIgnoreCase(argField.getType())) {
/*  199 */       out.append("    if (getDAO_().");
/*  200 */       out.append(getterName);
/*  201 */       out.append("() != null) {\n      return getDAO_().");
/*      */       
/*  203 */       out.append(getterName);
/*  204 */       out.append("()");
/*  205 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  206 */       out.append(";\n    }\n    else {\n      return false;\n    }\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  212 */     else if ("Integer".equalsIgnoreCase(argField.getType()) || "Long"
/*  213 */       .equalsIgnoreCase(argField.getType())) {
/*      */       
/*  215 */       out.append("    if (getDAO_().");
/*  216 */       out.append(getterName);
/*  217 */       out.append("() != null) {\n      return getDAO_().");
/*      */       
/*  219 */       out.append(getterName);
/*  220 */       out.append("()");
/*  221 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  222 */       out.append(";\n    }\n    else {\n");
/*      */ 
/*      */       
/*  225 */       if (argField.getDefaultValueIfNull() == null) {
/*  226 */         out.append("      return 0; // no default specified in the dtx; we default to 0\n");
/*      */       }
/*  228 */       else if (argField.getDefaultValueIfNull() instanceof Long) {
/*  229 */         out.append("      return ");
/*  230 */         out.append(argField.getDefaultValueIfNull());
/*  231 */         out.append("l; // <<< default specified in .dtx\n");
/*      */       } else {
/*      */         
/*  234 */         out.append("      return ");
/*  235 */         out.append(argField.getDefaultValueIfNull());
/*  236 */         out.append("; // <<< default specified in .dtx\n");
/*      */       } 
/*  238 */       out.append("    }\n");
/*      */     
/*      */     }
/*  241 */     else if (!StringUtils.isEmpty(argField.getEncrypt()) && "String".equalsIgnoreCase(argField.getType())) {
/*  242 */       out.append("    return decryptField(\"");
/*  243 */       out.append(argField.getEncrypt());
/*  244 */       out.append("\", ");
/*  245 */       out.append("getDAO_().");
/*  246 */       out.append(getterName);
/*  247 */       out.append("())");
/*  248 */       out.append(";\n");
/*      */     } else {
/*      */       
/*  251 */       out.append("    return getDAO_().");
/*  252 */       out.append(getterName);
/*  253 */       out.append("()");
/*  254 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  255 */       out.append(";\n");
/*      */     } 
/*      */ 
/*      */     
/*  259 */     out.append("  }\n\n");
/*      */     
/*  261 */     if (!StringUtils.isEmpty(argField.getEncrypt()) && "String".equalsIgnoreCase(argField.getType())) {
/*  262 */       generateEncryptedFieldGetter(out, argDtx, argField);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateFields(StringBuilder out, DtxDefinition argDtx) {
/*  270 */     for (DtxInverseRelationship rel : argDtx.getInverseRelationships()) {
/*  271 */       out.append("  private ");
/*  272 */       out.append(rel.getParent().getInterface());
/*  273 */       out.append(" _");
/*  274 */       out.append(StringUtils.ensureFirstLowerCase(rel.getName()));
/*  275 */       out.append(";\n");
/*      */     } 
/*      */     
/*  278 */     if ((argDtx.getInverseRelationships()).length > 0) {
/*  279 */       out.append("\n");
/*      */     }
/*      */     
/*  282 */     out.append("\n  private transient boolean _alreadyInStart = false;\n  private transient boolean _alreadyInCommit = false;\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  290 */     out.append("  private IDataModel _myExtension;\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateFieldSetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  298 */     boolean childPrimaryKey = false;
/*      */     
/*  300 */     if (argDtx.isExtended() && argField.isPrimaryKey() && 
/*  301 */       !argDtx.getRelationships(DtxRelationship.ONE_MANY).isEmpty())
/*      */     {
/*      */ 
/*      */       
/*  305 */       childPrimaryKey = true;
/*      */     }
/*      */ 
/*      */     
/*  309 */     String getterName = DaoGenUtils.getGetterNameForField(argField);
/*  310 */     String setterName = DaoGenUtils.getSetterNameForField(argField);
/*  311 */     String argName = DaoGenUtils.getArgNameForField(argField);
/*      */     
/*  313 */     String obj = DaoGenUtils.wrapStatementWithObject(argName, argField.getType());
/*  314 */     out.append("  /**\n");
/*  315 */     out.append("   * Sets the value of the ").append(argField.getColumn()).append(" field.\n");
/*  316 */     out.append("   * @param ").append(argName).append(" The new value for the field.\n");
/*  317 */     out.append("   */\n");
/*  318 */     out.append("  public void ").append(setterName).append("(").append(DaoGenUtils.getVariableType(argField.getType()))
/*  319 */       .append(" ").append(argName).append(") {\n");
/*  320 */     out.append("    if (").append(setterName).append("_noev(").append(argName).append(")) {\n");
/*      */     
/*  322 */     if (!argField.isSuppressed()) {
/*  323 */       out.append("      if (_events != null) {\n");
/*  324 */       out.append("        if (postEventsForChanges()) {\n");
/*  325 */       out.append("          _events.post(").append(argDtx.getInterface()).append(".SET_")
/*  326 */         .append(argField.getName().toUpperCase()).append(", ").append(obj).append(");\n");
/*  327 */       out.append("        }\n");
/*  328 */       out.append("      }\n");
/*      */     } else {
/*      */       
/*  331 */       out.append("      // suppress-event is specified for this field.\n");
/*      */     } 
/*  333 */     out.append("    }\n");
/*  334 */     out.append("  }\n");
/*  335 */     out.append("\n");
/*      */ 
/*      */ 
/*      */     
/*  339 */     out.append("  public boolean ").append(setterName).append("_noev(")
/*  340 */       .append(DaoGenUtils.getVariableType(argField.getType())).append(" ").append(argName).append(") {\n");
/*  341 */     out.append("    boolean ev_postable = false;\n");
/*  342 */     out.append("\n");
/*      */     
/*  344 */     if (!childPrimaryKey) {
/*  345 */       out.append("    if ((getDAO_().").append(getterName).append("() == null && ").append(obj)
/*  346 */         .append(" != null) ||\n");
/*  347 */       out.append("        (getDAO_().").append(getterName).append("() != null && !getDAO_().")
/*  348 */         .append(getterName).append("().equals(").append(obj).append("))) {\n");
/*  349 */       if (!StringUtils.isEmpty(argField.getEncrypt()) && "String".equalsIgnoreCase(argField.getType())) {
/*  350 */         out.append("      getDAO_().").append(setterName).append("(").append("encryptField(\"")
/*  351 */           .append(argField.getEncrypt()).append("\" ,").append(obj).append("));\n");
/*      */       } else {
/*      */         
/*  354 */         out.append("      getDAO_().").append(setterName).append("(").append(obj).append(");\n");
/*      */       } 
/*      */       
/*  357 */       out.append("      ev_postable = true;\n");
/*      */     } else {
/*      */       
/*  360 */       out.append("\n").append("    if (super.").append(setterName).append("_noev(").append(argName)
/*  361 */         .append(")) {\n");
/*      */     } 
/*      */ 
/*      */     
/*  365 */     for (DtxRelationship rel : argDtx.getRelationships(DtxRelationship.ONE_MANY)) {
/*  366 */       for (DtxRelationship.DtxRelationshipField fld : rel.getFields()) {
/*  367 */         if (fld.getParent().equals(argField.getName())) {
/*  368 */           String properChild = StringUtils.ensureFirstUpperCase(fld.getChild());
/*  369 */           out.append("      if (" + rel.getParentAttributeName()).append(" != null) {\n");
/*  370 */           out.append("        // Propagate changes to related objects in relation " + rel.getName())
/*  371 */             .append(".\n");
/*  372 */           out.append("        java.util.Iterator it = " + rel.getParentAttributeName() + ".iterator();\n");
/*  373 */           out.append("        while(it.hasNext()) {\n");
/*  374 */           out.append("          // Use the non-eventing setter directly.\n");
/*  375 */           out.append("          ((" + rel.getChild().getModel() + ") it.next()).set" + properChild + "_noev(" + argName + ");\n");
/*      */           
/*  377 */           out.append("        }\n");
/*  378 */           out.append("      }\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  384 */     for (DtxRelationship rel : argDtx.getRelationships(DtxRelationship.ONE_ONE)) {
/*  385 */       if (!rel.getDependent()) {
/*      */         continue;
/*      */       }
/*  388 */       for (DtxRelationship.DtxRelationshipField fld : rel.getFields()) {
/*  389 */         if (fld.getParent().equals(argField.getName())) {
/*  390 */           String properChild = StringUtils.ensureFirstUpperCase(fld.getChild());
/*  391 */           out.append("      if (" + rel.getParentAttributeName()).append(" != null) {\n");
/*  392 */           out.append("        // Propagate changes to related objects in relation " + rel.getName())
/*  393 */             .append(".\n");
/*  394 */           out.append("          // Use the non-eventing setter directly.\n");
/*  395 */           out.append("          ((" + rel.getChild().getModel() + ")" + rel.getParentAttributeName() + ").set" + properChild + "_noev(" + argName + ");\n");
/*      */           
/*  397 */           out.append("      }\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  402 */     out.append("    }\n");
/*  403 */     out.append("\n");
/*  404 */     out.append("    return ev_postable;\n");
/*  405 */     out.append("  }\n\n");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void generateFooter(StringBuilder out, DtxDefinition dtx) {
/*  410 */     out.append("\n");
/*  411 */     out.append("}\n");
/*      */   }
/*      */   
/*      */   protected void generateHeader(StringBuilder out, DtxDefinition argDtx) {
/*  415 */     out.append("package " + argDtx.getPackage() + ";\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  420 */     out.append("import java.math.BigDecimal;\n");
/*  421 */     out.append("import java.util.*;\n");
/*  422 */     out.append("import dtv.data2.access.impl.*;\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  427 */     out.append("import dtv.data2.access.IDataModel;\n");
/*  428 */     out.append("import dtv.data2.access.ModelEventor;\n");
/*      */     
/*  430 */     boolean historicalListImported = false;
/*      */     
/*  432 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*  433 */       if (DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType())) {
/*  434 */         out.append("import " + relationship.getChild().getInterface() + ";\n");
/*      */         continue;
/*      */       } 
/*  437 */       if (!historicalListImported) {
/*  438 */         out.append("import dtv.util.HistoricalList;\n");
/*  439 */         out.append("import dtv.data2.access.*;\n");
/*      */         
/*  441 */         historicalListImported = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  449 */     if (!argDtx.isExtended()) {
/*  450 */       out.append("import ");
/*  451 */       out.append(argDtx.getId());
/*  452 */       out.append(";\n");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  458 */     out.append(this._helper.getClassCommentWithSuppressWarnings("Auto Generated Model"));
/*      */     
/*  460 */     out.append("public class ");
/*  461 */     out.append(argDtx.getName());
/*  462 */     out.append("Model \n");
/*  463 */     if (argDtx.isExtended()) {
/*      */ 
/*      */       
/*  466 */       out.append("  extends ");
/*  467 */       out.append(argDtx.getExtends().getModel());
/*  468 */       out.append("\n");
/*      */     }
/*  470 */     else if (DaoGenHelper.isPropertyChildNeeded(argDtx)) {
/*  471 */       out.append("  extends dtv.data2.access.impl.AbstractDataModelWithPropertyImpl<");
/*  472 */       out.append(DaoGenHelper.getPropertyInterfaceName(argDtx));
/*  473 */       out.append(">\n");
/*      */     }
/*  475 */     else if (argDtx.isProperties()) {
/*  476 */       out.append("  extends dtv.data2.access.impl.AbstractDataModelPropertiesImpl\n");
/*      */     } else {
/*      */       
/*  479 */       out.append("  extends dtv.data2.access.impl.AbstractDataModelImpl\n");
/*      */     } 
/*      */     
/*  482 */     out.append("  implements ");
/*  483 */     out.append(argDtx.getInterface());
/*  484 */     out.append(" {\n\n  // Fix serialization compatability based on the name of the DAO\n  private static final long serialVersionUID = ");
/*      */ 
/*      */     
/*  487 */     out.append(argDtx.getName().hashCode());
/*  488 */     out.append("L;\n\n");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void generatePropertyMethods(StringBuilder out, DtxDefinition argDtx) {
/*  493 */     String propertyName = DaoGenHelper.getPropertyName(argDtx);
/*  494 */     DtxDefinition child = this._helper.getTypeNameDefinition(propertyName);
/*      */ 
/*      */     
/*  497 */     out.append("  protected ");
/*  498 */     out.append(child.getInterface());
/*  499 */     out.append(" newProperty(String argPropertyName)  {\n");
/*      */     
/*  501 */     out.append("    ");
/*  502 */     out.append(child.getId());
/*  503 */     out.append(" id = new ");
/*  504 */     out.append(child.getId());
/*  505 */     out.append("();\n\n");
/*      */     
/*  507 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/*  508 */       if (!field.getName().equals("organizationId")) {
/*  509 */         out.append("    id.");
/*  510 */         out.append(DaoGenUtils.getSetterNameForField(field));
/*  511 */         out.append("(");
/*  512 */         out.append(DaoGenUtils.wrapStatementWithObject(DaoGenUtils.getGetterNameForField(field) + "()", field.getType()));
/*  513 */         out.append(");\n");
/*      */       } 
/*      */     } 
/*      */     
/*  517 */     out.append("    id.setPropertyCode(argPropertyName);\n\n");
/*  518 */     out.append("    ");
/*  519 */     out.append(child.getInterface());
/*  520 */     out.append(" prop = dtv.data2.access.DataFactory.getInstance().createNewObject(id, ");
/*  521 */     out.append(child.getInterface());
/*  522 */     out.append(".class);\n");
/*  523 */     out.append("    return prop;\n");
/*  524 */     out.append("  }\n");
/*  525 */     out.append("\n");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateRelationshipFields(StringBuilder out, List<DtxRelationship> argRelationships) {
/*  531 */     for (DtxRelationship relationship : argRelationships) {
/*      */ 
/*      */       
/*  534 */       String typeName = DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType()) ? relationship.getChild().getInterfaceTypeOnly() : ("HistoricalList<" + relationship.getChild().getInterface() + ">");
/*  535 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*  536 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*  537 */       out.append("  private " + typeName + " " + fieldName + ";\n");
/*  538 */       out.append("  // So that rollback() reverts to proper value\n");
/*  539 */       out.append("  private transient " + typeName + " " + savepointFieldName + ";\n");
/*      */     } 
/*  541 */     out.append("\n");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void generateRelationshipMethods(StringBuilder out, DtxDefinition argDtx, List<DtxRelationship> argRelationships) {
/*  546 */     StringBuilder persistenceDefaultsBuilder = new StringBuilder();
/*      */     
/*  548 */     persistenceDefaultsBuilder.append("  @Override\n");
/*  549 */     persistenceDefaultsBuilder.append("  public void setDependencies(dtv.data2.IPersistenceDefaults argPD, dtv.event.EventManager argEM) {\n");
/*      */ 
/*      */     
/*  552 */     if (argDtx.getExtends() == null) {
/*  553 */       persistenceDefaultsBuilder.append("    _persistenceDefaults = argPD;\n");
/*  554 */       persistenceDefaultsBuilder.append("    _daoImpl.setPersistenceDefaults(argPD);\n");
/*  555 */       persistenceDefaultsBuilder.append("    _eventManager = argEM;\n");
/*  556 */       persistenceDefaultsBuilder.append("    _events = new ModelEventor(this, argEM);\n");
/*  557 */       persistenceDefaultsBuilder
/*  558 */         .append("    _eventCascade = new dtv.event.handler.CascadingHandler(this);\n");
/*      */     } else {
/*      */       
/*  561 */       persistenceDefaultsBuilder.append("    super.setDependencies(argPD, argEM);\n");
/*      */     } 
/*      */     
/*  564 */     for (DtxRelationship relationship : argRelationships) {
/*  565 */       DtxDefinition child = relationship.getChild();
/*  566 */       String argName = DaoGenUtils.getArgNameForRelationship(relationship);
/*  567 */       String typeName = DaoGenUtils.getTypeForRelationship(relationship, false);
/*  568 */       String getterName = DaoGenUtils.getGetterNameForRelationship(relationship);
/*  569 */       String setterName = DaoGenUtils.getSetterNameForRelationship(relationship);
/*  570 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*  571 */       String relationshipName = StringUtils.ensureFirstUpperCase(relationship.getName());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  576 */       persistenceDefaultsBuilder.append("    if (" + fieldName + " != null) {\n");
/*  577 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType()) || DtxRelationship.MANY_MANY
/*  578 */         .equalsIgnoreCase(relationship.getType())) {
/*  579 */         persistenceDefaultsBuilder.append("      for (")
/*  580 */           .append(relationship.getChild().getInterface() + " relationship : ").append(fieldName)
/*  581 */           .append(") {\n");
/*  582 */         persistenceDefaultsBuilder.append("        ((dtv.data2.access.impl.IDataModelImpl)relationship).setDependencies(argPD, argEM);\n");
/*      */         
/*  584 */         persistenceDefaultsBuilder.append("      }\n");
/*      */       } else {
/*      */         
/*  587 */         persistenceDefaultsBuilder.append("      ((dtv.data2.access.impl.IDataModelImpl)" + fieldName + ").setDependencies(argPD, argEM);\n");
/*      */       } 
/*      */       
/*  590 */       persistenceDefaultsBuilder.append("    }\n");
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  595 */       out.append("  @Relationship(name=\"").append(relationshipName).append("\")\n");
/*  596 */       out.append("  public ").append(typeName).append(" ").append(getterName).append("() {\n");
/*  597 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType()) || DtxRelationship.MANY_MANY
/*  598 */         .equalsIgnoreCase(relationship.getType())) {
/*  599 */         addListInitializer(out, relationship, "null", null);
/*      */       }
/*  601 */       out.append("    return ").append(fieldName).append(";\n");
/*  602 */       out.append("  }\n\n");
/*      */       
/*  604 */       if (DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType())) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  609 */         out.append("  public void ").append(setterName).append("( ").append(typeName);
/*  610 */         out.append(" ").append(argName).append(") {\n");
/*      */         
/*  612 */         out.append("    // null out keys that define this relationship\n");
/*  613 */         out.append("    if( ").append(argName).append(" == null) {\n");
/*      */         
/*  615 */         if (relationship.getFieldsNotShared().isEmpty()) {
/*  616 */           out.append("      // all the fields that define this relationship are shared.  It cannot be broken.\n");
/*      */           
/*  618 */           out.append("      if (");
/*  619 */           out.append(fieldName);
/*  620 */           out.append(" != null) {\n");
/*  621 */           out.append("        throw new dtv.data2.access.exception.DtxException(\"An Attempt was made to break a ONE-ONE");
/*      */           
/*  623 */           out.append(" relationship that cannot be broken because all fields that define the relationship are");
/*      */           
/*  625 */           out.append(" primary keys on the parent data object.\");\n");
/*  626 */           out.append("      }\n");
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  631 */         if (!relationship.getDependent()) {
/*  632 */           out.append("      // null out the keys that define this relationship of two independent objects.\n");
/*      */           
/*  634 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFieldsNotShared()) {
/*  635 */             out.append("      getDAO_().set");
/*  636 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  637 */             out.append("(null);\n");
/*      */           } 
/*      */         } 
/*      */         
/*  641 */         out.append("      if ( ");
/*  642 */         out.append(fieldName);
/*  643 */         out.append(" != null) {\n");
/*      */         
/*  645 */         out.append("        // De-register from the previous child.\n");
/*  646 */         out.append("        if (postEventsForChanges()) {\n");
/*  647 */         out.append("          _eventManager.deregisterEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */         
/*  649 */         out.append(fieldName);
/*  650 */         out.append("));\n");
/*  651 */         out.append("        }\n");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  656 */         if (relationship.getDependent()) {
/*  657 */           out.append("        super.addDeletedObject(");
/*  658 */           out.append(fieldName);
/*  659 */           out.append(");\n");
/*      */         } 
/*  661 */         out.append("      }\n");
/*  662 */         out.append("    }\n");
/*  663 */         out.append("    else {\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  669 */         if (relationship.getDependent()) {
/*  670 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFields()) {
/*  671 */             out.append("      ");
/*  672 */             out.append(argName);
/*  673 */             out.append(".set");
/*  674 */             out.append(StringUtils.ensureFirstUpperCase(field.getChild()));
/*  675 */             out.append("(this.get");
/*  676 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  677 */             out.append("());\n");
/*      */           } 
/*  679 */           out.append("\n");
/*      */         } else {
/*      */           
/*  682 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFieldsNotShared()) {
/*  683 */             DtxDefinition.DtxDaoField theRealField = relationship.getChild().findField(field.getChild());
/*      */             
/*  685 */             out.append("      getDAO_().set");
/*  686 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  687 */             out.append("(");
/*  688 */             out.append(DaoGenUtils.wrapStatementWithObject(argName + ".get" + 
/*  689 */                   StringUtils.ensureFirstUpperCase(field.getChild()) + "()", theRealField
/*  690 */                   .getType()));
/*  691 */             out.append(");\n");
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  697 */         DtxInverseRelationship inverseRelationship = child.getInverseRelationship(argDtx);
/*  698 */         if (inverseRelationship != null) {
/*  699 */           out.append("      // notify children with inverse relationships that they have a parent.\n");
/*  700 */           out.append("      " + argName + "." + inverseRelationship.getSetMethodName() + "(this);\n\n");
/*      */         } 
/*      */         
/*  703 */         out.append("      // Register the cascading event handler to receive events from the new child.\n");
/*  704 */         out.append("      if (postEventsForChanges()) {\n");
/*  705 */         out.append("        _eventManager.registerEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */         
/*  707 */         out.append(argName + "));\n");
/*  708 */         out.append("      }\n");
/*  709 */         out.append("    }\n\n");
/*  710 */         out.append("    ");
/*  711 */         out.append(fieldName);
/*  712 */         out.append(" = ");
/*  713 */         out.append(argName);
/*  714 */         out.append(";\n");
/*  715 */         out.append("    if (postEventsForChanges()) {\n");
/*  716 */         out.append("      _events.post(");
/*  717 */         out.append(argDtx.getInterface());
/*  718 */         out.append(".SET_");
/*  719 */         out.append(relationship.getName().toUpperCase());
/*  720 */         out.append(", ");
/*  721 */         out.append(argName);
/*  722 */         out.append(");\n");
/*  723 */         out.append("    }\n");
/*  724 */         out.append("  }\n\n");
/*      */         continue;
/*      */       } 
/*  727 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType()) || DtxRelationship.MANY_MANY
/*  728 */         .equalsIgnoreCase(relationship.getType())) {
/*      */         
/*  730 */         String addRemoveArgName = DaoGenUtils.getArgNameForRelationshipAddRemove(relationship);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  736 */         out.append("  public void ").append(setterName).append("( ").append(typeName);
/*  737 */         out.append(" ").append(argName).append(") {\n");
/*  738 */         addListInitializer(out, relationship, argName, argName);
/*      */ 
/*      */         
/*  741 */         DtxInverseRelationship inverseRelationship = child.getInverseRelationship(argDtx);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  746 */         if (inverseRelationship != null) {
/*  747 */           out.append("    // notify children with inverse relationships that they have a parent.\n");
/*  748 */           out.append("    for( ").append(relationship.getChild().getInterface()).append(" child : ")
/*  749 */             .append(fieldName).append(") {\n");
/*  750 */           out.append("      child.").append(inverseRelationship.getSetMethodName()).append("(this);\n");
/*  751 */           out.append("    }\n");
/*      */         } 
/*      */ 
/*      */         
/*  755 */         String childType = child.getInterface();
/*  756 */         String childModel = child.getModel();
/*  757 */         if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType())) {
/*  758 */           out.append("    // Propagate identification information through the graph.\n");
/*  759 */           out.append("    for( ").append(childType).append(" child : ").append(fieldName).append(") {\n");
/*  760 */           out.append("      ").append(childModel).append(" model = (").append(childModel)
/*  761 */             .append(") child;\n");
/*      */           
/*  763 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFields()) {
/*  764 */             String parentName = StringUtils.ensureFirstUpperCase(field.getParent());
/*  765 */             String childName = StringUtils.ensureFirstUpperCase(field.getChild());
/*  766 */             out.append("      model.set" + childName + "_noev(this.get" + parentName + "());\n");
/*      */           } 
/*      */           
/*  769 */           out.append("      if (child instanceof IDataModelImpl) {\n");
/*  770 */           out.append("        IDataAccessObject childDao = ((IDataModelImpl) child).getDAO();\n");
/*  771 */           out.append("        if (dtv.util.StringUtils.isEmpty(childDao.getOriginDataSource()) && \n");
/*  772 */           out.append("            !dtv.util.StringUtils.isEmpty(this.getDAO().getOriginDataSource())) {\n");
/*  773 */           out.append("          childDao.setOriginDataSource(this.getDAO().getOriginDataSource());\n");
/*  774 */           out.append("        }\n");
/*  775 */           out.append("      }\n");
/*      */ 
/*      */           
/*  778 */           out.append("      if (postEventsForChanges()) {\n");
/*  779 */           out.append("        _eventManager.registerEventHandler(_eventCascade, child);\n");
/*  780 */           out.append("      }\n");
/*  781 */           out.append("    }\n");
/*      */         } 
/*      */ 
/*      */         
/*  785 */         out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  791 */         out.append("  public void ");
/*  792 */         out.append(DaoGenUtils.getAdderNameForRelationship(relationship));
/*  793 */         out.append("(");
/*  794 */         out.append(relationship.getChild().getInterface());
/*  795 */         out.append(" ");
/*  796 */         out.append(addRemoveArgName);
/*  797 */         out.append(") {\n");
/*      */         
/*  799 */         if (inverseRelationship != null) {
/*  800 */           out.append("    // notify children with inverse relationships that they have a parent.\n    ");
/*      */           
/*  802 */           out.append(addRemoveArgName);
/*  803 */           out.append(".");
/*  804 */           out.append(inverseRelationship.getSetMethodName());
/*  805 */           out.append("(this);\n");
/*      */         } 
/*      */ 
/*      */         
/*  809 */         addListInitializer(out, relationship, "null", null);
/*      */ 
/*      */         
/*  812 */         if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType())) {
/*  813 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFields()) {
/*  814 */             out.append("    ");
/*  815 */             out.append(addRemoveArgName);
/*  816 */             out.append(".set");
/*  817 */             out.append(StringUtils.ensureFirstUpperCase(field.getChild()));
/*  818 */             out.append("(this.get");
/*  819 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  820 */             out.append("());\n");
/*      */           } 
/*      */ 
/*      */           
/*  824 */           out.append("    if (");
/*  825 */           out.append(addRemoveArgName);
/*  826 */           out.append(" instanceof IDataModelImpl) {\n");
/*  827 */           out.append("      IDataAccessObject childDao = ((IDataModelImpl) ");
/*  828 */           out.append(addRemoveArgName);
/*  829 */           out.append(").getDAO();\n");
/*  830 */           out.append("      if (dtv.util.StringUtils.isEmpty(childDao.getOriginDataSource()) && \n");
/*  831 */           out.append("          !dtv.util.StringUtils.isEmpty(this.getDAO().getOriginDataSource())) {\n");
/*  832 */           out.append("        childDao.setOriginDataSource(this.getDAO().getOriginDataSource());\n");
/*  833 */           out.append("      }\n");
/*  834 */           out.append("    }\n\n");
/*      */           
/*  836 */           out.append("    // Register the _handleChildEvent method to receive events from the new child.\n");
/*  837 */           out.append("    if (postEventsForChanges()) {\n");
/*  838 */           out.append("      _eventManager.registerEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */           
/*  840 */           out.append(addRemoveArgName);
/*  841 */           out.append("));\n");
/*  842 */           out.append("    }\n\n");
/*      */         } 
/*      */         
/*  845 */         out.append("    ");
/*  846 */         out.append(fieldName);
/*  847 */         out.append(".add(");
/*  848 */         out.append(addRemoveArgName);
/*  849 */         out.append(");\n");
/*  850 */         out.append("    if (postEventsForChanges()) {\n");
/*  851 */         out.append("      _events.post(");
/*  852 */         out.append(argDtx.getInterface());
/*  853 */         out.append(".ADD_");
/*  854 */         out.append(relationship.getName().toUpperCase());
/*  855 */         out.append(", ");
/*  856 */         out.append(addRemoveArgName);
/*  857 */         out.append(");\n");
/*  858 */         out.append("    }\n");
/*  859 */         out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  865 */         out.append("  public void ");
/*  866 */         out.append(DaoGenUtils.getRemoverNameForRelationship(relationship));
/*  867 */         out.append("(");
/*  868 */         out.append(relationship.getChild().getInterface());
/*  869 */         out.append(" ");
/*  870 */         out.append(addRemoveArgName);
/*  871 */         out.append(") {\n");
/*      */         
/*  873 */         out.append("    if (");
/*  874 */         out.append(fieldName);
/*  875 */         out.append(" != null) {\n");
/*  876 */         out.append("    // De-Register the _handleChildEvent method from receiving the child events.\n");
/*  877 */         out.append("    if (postEventsForChanges()) {\n");
/*  878 */         out.append("      _eventManager.deregisterEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */         
/*  880 */         out.append(addRemoveArgName + "));\n");
/*  881 */         out.append("    }\n");
/*  882 */         out.append("      ");
/*  883 */         out.append(fieldName);
/*  884 */         out.append(".remove(");
/*  885 */         out.append(addRemoveArgName);
/*  886 */         out.append(");\n");
/*      */         
/*  888 */         if (inverseRelationship != null) {
/*  889 */           out.append("    // notify children with inverse relationships that they have a parent.\n");
/*  890 */           out.append("    ").append(addRemoveArgName).append(".")
/*  891 */             .append(inverseRelationship.getSetMethodName()).append("(null);\n");
/*      */         } 
/*      */         
/*  894 */         out.append("      if (postEventsForChanges()) {\n");
/*  895 */         out.append("        _events.post(");
/*  896 */         out.append(argDtx.getInterface());
/*  897 */         out.append(".REMOVE_");
/*  898 */         out.append(relationship.getName().toUpperCase());
/*  899 */         out.append(", ");
/*  900 */         out.append(addRemoveArgName);
/*  901 */         out.append(");\n");
/*  902 */         out.append("      }\n");
/*  903 */         out.append("    }\n  }\n\n");
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  908 */       throw new Error("*** UNKNOWN RELATIONSHIP TYPE: " + relationship.getType() + " in file: " + argDtx
/*  909 */           .getSourceDtxFile().getAbsolutePath());
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  917 */     for (DtxInverseRelationship inverseRelationship : argDtx.getInverseRelationships()) {
/*      */       
/*  919 */       String argName = "arg" + StringUtils.ensureFirstUpperCase(inverseRelationship.getName());
/*  920 */       String fieldName = "_" + StringUtils.ensureFirstLowerCase(inverseRelationship.getName());
/*      */       
/*  922 */       out.append("  public void ");
/*  923 */       out.append(inverseRelationship.getSetMethodName());
/*  924 */       out.append("(");
/*  925 */       out.append(inverseRelationship.getParent().getInterface());
/*  926 */       out.append(" ");
/*  927 */       out.append(argName);
/*  928 */       out.append(") {\n    ");
/*      */       
/*  930 */       out.append(fieldName);
/*  931 */       out.append(" = ");
/*  932 */       out.append(argName);
/*  933 */       out.append(";\n  }\n\n  public ");
/*      */ 
/*      */ 
/*      */       
/*  937 */       out.append(inverseRelationship.getParent().getInterface());
/*  938 */       out.append(" ");
/*  939 */       out.append(inverseRelationship.getGetMethodName());
/*  940 */       out.append("() {\n    return " + fieldName + ";\n  }\n\n");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  951 */     out.append("  @Override\n  public Object getValue(String argFieldId) {\n");
/*      */ 
/*      */     
/*  954 */     boolean ifPrinted = false;
/*  955 */     for (DtxRelationship relationship : argRelationships) {
/*      */       
/*  957 */       if (!ifPrinted) {
/*  958 */         out.append("    if (");
/*  959 */         ifPrinted = true;
/*      */       } else {
/*      */         
/*  962 */         out.append("    else if (");
/*      */       } 
/*      */       
/*  965 */       out.append("\"");
/*  966 */       out.append(StringUtils.ensureFirstUpperCase(relationship.getName()));
/*  967 */       out.append("\".equals(argFieldId)) {\n      return ");
/*      */       
/*  969 */       out.append(DaoGenUtils.getGetterNameForRelationship(relationship));
/*  970 */       out.append("();\n    }\n");
/*      */     } 
/*      */ 
/*      */     
/*  974 */     if (argRelationships.size() == 0) {
/*  975 */       out.append("    if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } else {
/*      */       
/*  978 */       out.append("    else if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } 
/*      */     
/*  981 */     out.append("      return _myExtension;\n");
/*  982 */     out.append("    }\n");
/*      */     
/*  984 */     out.append("    else {\n      return super.getValue(argFieldId);\n    }\n  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  994 */     out.append("  @Override\n  public void setValue(String argFieldId, Object argValue) {\n");
/*      */ 
/*      */     
/*  997 */     ifPrinted = false;
/*  998 */     for (DtxRelationship relationship : argRelationships) {
/*      */       
/* 1000 */       if (!ifPrinted) {
/* 1001 */         out.append("    if (");
/* 1002 */         ifPrinted = true;
/*      */       } else {
/*      */         
/* 1005 */         out.append("    else if (");
/*      */       } 
/*      */       
/* 1008 */       out.append("\"");
/* 1009 */       out.append(StringUtils.ensureFirstUpperCase(relationship.getName()));
/* 1010 */       out.append("\".equals(argFieldId)) {\n");
/*      */       
/* 1012 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1013 */         out.append("      ");
/* 1014 */         out.append(DaoGenUtils.getSetterNameForRelationship(relationship));
/* 1015 */         out.append("((");
/* 1016 */         out.append(relationship.getChild().getInterface());
/* 1017 */         out.append(")argValue);\n");
/*      */       } else {
/*      */         
/* 1020 */         out.append("      ");
/* 1021 */         out.append(DaoGenUtils.getSetterNameForRelationship(relationship));
/* 1022 */         out.append("(changeToList(argValue,");
/* 1023 */         out.append(relationship.getChild().getInterface());
/* 1024 */         out.append(".class));\n");
/*      */       } 
/*      */       
/* 1027 */       out.append("    }\n");
/*      */     } 
/*      */     
/* 1030 */     if (argRelationships.size() == 0) {
/* 1031 */       out.append("    if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } else {
/*      */       
/* 1034 */       out.append("    else if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } 
/*      */     
/* 1037 */     out.append("      _myExtension = (IDataModel)argValue;\n");
/* 1038 */     out.append("    }\n");
/*      */     
/* 1040 */     out.append("    else {\n      super.setValue(argFieldId, argValue);\n    }\n  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1047 */     persistenceDefaultsBuilder.append("  }\n\n");
/* 1048 */     out.append(persistenceDefaultsBuilder.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateTransactionMethods(StringBuilder out, DtxDefinition argDtx) {
/* 1059 */     out.append("  @Override\n  public void startTransaction() {\n    if (_alreadyInStart) {\n      return;\n    }\n    else {\n      _alreadyInStart = true;\n    }\n\n    super.startTransaction();\n\n");
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
/* 1071 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*      */       
/* 1073 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/* 1074 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*      */ 
/*      */       
/* 1077 */       out.append("    ");
/* 1078 */       out.append(savepointFieldName);
/* 1079 */       out.append(" = ");
/* 1080 */       out.append(fieldName);
/* 1081 */       out.append(";\n    if (");
/*      */       
/* 1083 */       out.append(fieldName);
/* 1084 */       out.append(" != null) {\n");
/*      */       
/* 1086 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1087 */         out.append("      ");
/* 1088 */         out.append(fieldName);
/* 1089 */         out.append(".startTransaction();\n");
/*      */       }
/* 1091 */       else if ("One-Many".equalsIgnoreCase(relationship.getType()) || "Many-Many"
/* 1092 */         .equalsIgnoreCase(relationship.getType())) {
/*      */ 
/*      */         
/* 1095 */         out.append("      ");
/* 1096 */         out.append(savepointFieldName);
/* 1097 */         out.append(" = new HistoricalList<");
/* 1098 */         out.append(relationship.getChild().getInterface());
/* 1099 */         out.append(">(");
/* 1100 */         out.append(fieldName);
/* 1101 */         out.append(");\n      java.util.Iterator it = ");
/*      */         
/* 1103 */         out.append(fieldName);
/* 1104 */         out.append(".iterator();\n      while (it.hasNext()) {\n        ((dtv.data2.access.IDataModel)it.next()).startTransaction();\n      }\n");
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1109 */       out.append("    }\n\n");
/*      */     } 
/*      */     
/* 1112 */     out.append("    \n    _alreadyInStart = false;\n  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1120 */     out.append("  @Override\n  public void rollbackChanges() {\n    if (isAlreadyRolledBack())\n      return;\n\n    super.rollbackChanges();\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1128 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*      */       
/* 1130 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/* 1131 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*      */ 
/*      */       
/* 1134 */       out.append("    ");
/* 1135 */       out.append(fieldName);
/* 1136 */       out.append(" = ");
/* 1137 */       out.append(savepointFieldName);
/* 1138 */       out.append(";\n    ");
/*      */       
/* 1140 */       out.append(savepointFieldName);
/* 1141 */       out.append(" = null;\n    if (");
/*      */       
/* 1143 */       out.append(fieldName);
/* 1144 */       out.append(" != null) {\n");
/*      */       
/* 1146 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1147 */         out.append("      ");
/* 1148 */         out.append(fieldName);
/* 1149 */         out.append(".rollbackChanges();\n");
/*      */       }
/* 1151 */       else if ("One-Many".equalsIgnoreCase(relationship.getType()) || "Many-Many"
/* 1152 */         .equalsIgnoreCase(relationship.getType())) {
/*      */         
/* 1154 */         out.append("      java.util.Iterator it = ");
/* 1155 */         out.append(fieldName);
/* 1156 */         out.append(".iterator();\n      while (it.hasNext()) {\n        ((dtv.data2.access.IDataModel)it.next()).rollbackChanges();\n      }\n");
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1162 */       out.append("    }\n\n");
/*      */     } 
/*      */     
/* 1165 */     out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1170 */     out.append("  @Override\n  public void commitTransaction() {\n    if (_alreadyInCommit) {\n      return;\n    } else {\n      _alreadyInCommit = true;\n    }\n\n    super.commitTransaction();\n\n");
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
/* 1181 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*      */       
/* 1183 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/* 1184 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*      */ 
/*      */       
/* 1187 */       out.append("    ");
/* 1188 */       out.append(savepointFieldName);
/* 1189 */       out.append(" = ");
/* 1190 */       out.append(fieldName);
/* 1191 */       out.append(";\n    if (");
/*      */       
/* 1193 */       out.append(fieldName);
/* 1194 */       out.append(" != null) {\n");
/*      */       
/* 1196 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1197 */         out.append("      ");
/* 1198 */         out.append(fieldName);
/* 1199 */         out.append(".commitTransaction();\n");
/*      */       }
/* 1201 */       else if ("One-Many".equalsIgnoreCase(relationship.getType()) || "Many-Many"
/* 1202 */         .equalsIgnoreCase(relationship.getType())) {
/*      */ 
/*      */         
/* 1205 */         out.append("      java.util.Iterator it = ");
/* 1206 */         out.append(fieldName);
/* 1207 */         out.append(".iterator();\n      while (it.hasNext()) {\n        ((dtv.data2.access.IDataModel)it.next()).commitTransaction();\n      }\n");
/*      */ 
/*      */ 
/*      */         
/* 1211 */         out.append("      ");
/* 1212 */         out.append(fieldName);
/* 1213 */         out.append(" = new HistoricalList<");
/* 1214 */         out.append(relationship.getChild().getInterface());
/* 1215 */         out.append(">(");
/* 1216 */         out.append(fieldName);
/* 1217 */         out.append(");\n");
/*      */       } 
/* 1219 */       out.append("    }\n\n");
/*      */     } 
/*      */     
/* 1222 */     for (int i = 0; i < (argDtx.getFields()).length; i++) {
/* 1223 */       DtxDefinition.DtxDaoField field = argDtx.getFields()[i];
/*      */       
/* 1225 */       if (field.getIncrementField()) {
/* 1226 */         out.append("    getDAO_().setInit");
/* 1227 */         out.append(StringUtils.ensureFirstUpperCase(field.getName()));
/* 1228 */         out.append("(");
/* 1229 */         out.append(DaoGenUtils.wrapStatementWithObject(DaoGenUtils.getGetterNameForField(field) + "()", field.getType()));
/* 1230 */         out.append(");\n");
/*      */         
/* 1232 */         if (i == (argDtx.getFields()).length - 1) {
/* 1233 */           out.append("\n");
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1238 */     out.append("    \n    _alreadyInCommit = false;\n  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getDtjContents(File argDtj) throws IOException {
/* 1247 */     if (!argDtj.exists()) {
/* 1248 */       return "";
/*      */     }
/* 1250 */     StringBuilder sb = new StringBuilder(1024);
/* 1251 */     sb.append("\n\n")
/* 1252 */       .append("  // ------------------------------------------------------------- \n")
/* 1253 */       .append("  // ------------------------------------------------------------- \n")
/* 1254 */       .append("  // - CUSTOM CODE BELOW THIS POINT. EDIT IN THE APPROPRIATE DTJ - \n")
/* 1255 */       .append("  // ------------------------------------------------------------- \n")
/* 1256 */       .append("  // ------------------------------------------------------------- \n\n");
/*      */     
/* 1258 */     try (Reader in = FileUtils.getFileReader(argDtj)) {
/* 1259 */       int inChar = -1;
/* 1260 */       while ((inChar = in.read()) > 0) {
/* 1261 */         sb.append((char)inChar);
/*      */       }
/* 1263 */       return sb.toString();
/*      */     } 
/*      */   }
/*      */   
/*      */   private StringBuilder overrideMethods(DtxDefinition argDtx, StringBuilder sb, String dtjContents) {
/* 1268 */     if (StringUtils.isEmpty(dtjContents)) {
/* 1269 */       return sb;
/*      */     }
/*      */     
/* 1272 */     String METHOD_OVERRIDE = "{OVERRIDE GENERATED METHOD}";
/*      */     
/* 1274 */     String[] dtj = dtjContents.split("\n");
/*      */     
/* 1276 */     for (int ii = 0; ii < dtj.length; ii++) {
/* 1277 */       if (dtj[ii].indexOf("{OVERRIDE GENERATED METHOD}") != -1) {
/*      */ 
/*      */ 
/*      */         
/* 1281 */         String methodDecl = (dtj[ii].indexOf("*/") >= 0) ? dtj[ii + 1] : dtj[ii + 2];
/*      */         
/* 1283 */         methodDecl = methodDecl.substring(0, methodDecl.indexOf("(")).trim();
/*      */         
/* 1285 */         if (sb.indexOf(methodDecl) == -1) {
/* 1286 */           throw new RuntimeException("Could not find method declaration: " + methodDecl + " in model generated for " + argDtx
/* 1287 */               .getName() + " methods overriden in the dtj must match the generated declaration character by character (case sensitive).");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1293 */         String overrideMethodDecl = methodDecl.replaceAll("public", "protected").trim();
/* 1294 */         overrideMethodDecl = overrideMethodDecl + "Impl(";
/* 1295 */         methodDecl = methodDecl + "(";
/* 1296 */         StringUtils.replaceAll(sb, methodDecl, overrideMethodDecl);
/*      */       } 
/*      */     } 
/*      */     
/* 1300 */     return sb;
/*      */   }
/*      */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DefaultModelGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */