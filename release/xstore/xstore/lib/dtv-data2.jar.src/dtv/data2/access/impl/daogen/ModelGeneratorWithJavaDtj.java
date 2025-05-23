/*      */ package dtv.data2.access.impl.daogen;
/*      */ 
/*      */ import dtv.data2.access.exception.DtxException;
/*      */ import dtv.data2.access.impl.AbstractDataModelImpl;
/*      */ import dtv.data2.access.impl.AbstractDataModelPropertiesImpl;
/*      */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*      */ import dtv.util.StringUtils;
/*      */ import java.io.IOException;
/*      */ import java.lang.reflect.Method;
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
/*      */ 
/*      */ public class ModelGeneratorWithJavaDtj
/*      */   implements IModelGenerator
/*      */ {
/*      */   private final DaoGenHelper _helper;
/*      */   private Class<?> _baseModelClass;
/*      */   
/*      */   public ModelGeneratorWithJavaDtj(DaoGenHelper argHelper) {
/*   34 */     this._helper = argHelper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String generateModel(DtxDefinition argDtxDefinition) throws IOException {
/*      */     try {
/*   46 */       String baseModelClassName = argDtxDefinition.getPackage() + "." + argDtxDefinition.getName() + "BaseModel";
/*   47 */       this._baseModelClass = this._helper.getPrecompileClassloader().loadClass(baseModelClassName);
/*      */     }
/*   49 */     catch (ClassNotFoundException classNotFoundException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   54 */     StringBuilder sb = new StringBuilder(20480);
/*   55 */     generateHeader(sb, argDtxDefinition);
/*   56 */     generateFields(sb, argDtxDefinition);
/*   57 */     generateDaoMethods(sb, argDtxDefinition);
/*      */     
/*   59 */     List<DtxRelationship> relationships = argDtxDefinition.getRelationships();
/*      */     
/*   61 */     if (DaoGenHelper.isPropertyChildNeeded(argDtxDefinition)) {
/*   62 */       generateNewPropertyMethod(sb, argDtxDefinition);
/*      */     }
/*      */     
/*   65 */     generateRelationshipFields(sb, relationships);
/*   66 */     generateRelationshipMethods(sb, argDtxDefinition, relationships);
/*      */     
/*   68 */     if (!argDtxDefinition.isProperties()) {
/*   69 */       generateExtensionMethods(sb, argDtxDefinition);
/*      */     }
/*      */     
/*   72 */     generateTransactionMethods(sb, argDtxDefinition);
/*   73 */     generateFooter(sb, argDtxDefinition);
/*      */     
/*   75 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void addListInitializer(StringBuilder out, DtxRelationship relationship, String argInitializeWith, String argElseSetList) {
/*   80 */     String initializeFieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*   81 */     out.append("    if (").append(initializeFieldName).append(" == null) {\n");
/*   82 */     out.append("      ").append(initializeFieldName).append(" = new HistoricalList<")
/*   83 */       .append(relationship.getChild().getInterface()).append(">(").append(argInitializeWith).append(");\n");
/*   84 */     out.append("    }");
/*   85 */     if (argElseSetList != null) {
/*   86 */       out.append(" else { \n");
/*   87 */       out.append("      ").append(initializeFieldName).append(".setCurrentList(").append(argInitializeWith)
/*   88 */         .append(");\n");
/*   89 */       out.append("    }");
/*      */     } 
/*   91 */     out.append("\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateCustomSerialization(StringBuilder out, DtxDefinition argDtx) {
/*  101 */     out.append("  private void readObject(java.io.ObjectInputStream argStream)\n");
/*  102 */     out.append("                         throws java.io.IOException, ClassNotFoundException {\n");
/*  103 */     out.append("    argStream.defaultReadObject();\n");
/*  104 */     out.append("  }\n");
/*      */   }
/*      */   
/*      */   protected void generateDaoMethods(StringBuilder out, DtxDefinition argDtx) {
/*  108 */     if (!argDtx.isExtended()) {
/*  109 */       out.append("  @Override\n");
/*  110 */       out.append("  public String toString() {\n");
/*  111 */       out.append("    return super.toString() + \" Id: \" + this.getObjectId();\n");
/*  112 */       out.append("  }\n\n");
/*      */     } 
/*      */     
/*  115 */     out.append("  @Override\n");
/*  116 */     out.append("  public void initDAO() {\n");
/*  117 */     out.append("    setDAO(new ");
/*  118 */     out.append(argDtx.getName());
/*  119 */     out.append("DAO());\n");
/*  120 */     out.append("  }\n\n");
/*      */     
/*  122 */     out.append("  /**\n");
/*  123 */     out.append("   * Return the data access object associated with this data model\n");
/*  124 */     out.append("   * @return our DAO, properly casted\n");
/*  125 */     out.append("   */\n");
/*  126 */     out.append("  private ");
/*  127 */     out.append(argDtx.getName());
/*  128 */     out.append("DAO getDAO_() {\n");
/*  129 */     out.append("     return (");
/*  130 */     out.append(argDtx.getName());
/*  131 */     out.append("DAO) _daoImpl;\n");
/*  132 */     out.append("  }\n\n");
/*      */     
/*  134 */     for (DtxDefinition.DtxDaoField field : argDtx.getFieldsPlusInheritedPrimaryKeys()) {
/*      */ 
/*      */       
/*  137 */       if (!argDtx.isExtended() || !field.isPrimaryKey() || 
/*  138 */         !argDtx.getRelationships(DtxRelationship.ONE_MANY).isEmpty()) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  143 */         generateFieldGetter(out, argDtx, field);
/*  144 */         generateFieldSetter(out, argDtx, field);
/*  145 */         generateEncryptedFieldGetter(out, argDtx, field);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   protected void generateEncryptedFieldGetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  150 */     String getterName = DaoGenUtils.getGetterNameForField(argField);
/*  151 */     String encryptedGetterName = DaoGenUtils.getGetterNameForField(argField) + "Encrypted";
/*      */ 
/*      */     
/*  154 */     if (getBaseModelMethod(getterName, new Class[0]) != null || StringUtils.isEmpty(argField.getEncrypt()) || 
/*  155 */       !"String".equalsIgnoreCase(argField.getType())) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  166 */     out.append("  /**\n   * Gets the value of the ");
/*      */     
/*  168 */     out.append(argField.getColumn());
/*  169 */     out.append(" field.\n   * @return The value of the field.\n   */\n  public ");
/*      */ 
/*      */ 
/*      */     
/*  173 */     out.append(DaoGenUtils.getVariableType(argField.getType()));
/*  174 */     out.append(" ");
/*  175 */     out.append(encryptedGetterName);
/*  176 */     out.append("() {\n");
/*      */     
/*  178 */     out.append("    return getDAO_().");
/*  179 */     out.append(getterName);
/*  180 */     out.append("()");
/*  181 */     out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  182 */     out.append(";\n");
/*      */     
/*  184 */     out.append("  }\n\n");
/*      */   }
/*      */   
/*      */   protected void generateExtensionMethods(StringBuilder out, DtxDefinition argDtx) {
/*  188 */     out.append("  public IDataModel get" + argDtx.getName() + "Ext() {\n");
/*  189 */     out.append("    return _myExtension;\n");
/*  190 */     out.append("  }\n\n");
/*      */     
/*  192 */     out.append("  public void set" + argDtx.getName() + "Ext(IDataModel argExt) {\n");
/*  193 */     out.append("    _myExtension = argExt;\n");
/*  194 */     out.append("  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateFieldGetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  201 */     String getterName = DaoGenUtils.getGetterNameForField(argField);
/*      */ 
/*      */     
/*  204 */     if (getBaseModelMethod(getterName, new Class[0]) != null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  212 */     out.append("  /**\n");
/*  213 */     out.append("   * Gets the value of the ");
/*  214 */     out.append(argField.getColumn());
/*  215 */     out.append(" field.\n");
/*  216 */     out.append("   * @return The value of the field.\n");
/*  217 */     out.append("   */\n");
/*  218 */     out.append("  public ");
/*  219 */     out.append(DaoGenUtils.getVariableType(argField.getType()));
/*  220 */     out.append(" ");
/*  221 */     out.append(getterName);
/*  222 */     out.append("() {\n");
/*      */     
/*  224 */     if ("Boolean".equalsIgnoreCase(argField.getType())) {
/*  225 */       out.append("    if (getDAO_().");
/*  226 */       out.append(getterName);
/*  227 */       out.append("() != null) {\n");
/*  228 */       out.append("      return getDAO_().");
/*  229 */       out.append(getterName);
/*  230 */       out.append("()");
/*  231 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  232 */       out.append(";\n");
/*  233 */       out.append("    }\n");
/*  234 */       out.append("    else {\n");
/*  235 */       out.append("      return false;\n");
/*  236 */       out.append("    }\n");
/*      */     }
/*  238 */     else if ("Integer".equalsIgnoreCase(argField.getType()) || "Long"
/*  239 */       .equalsIgnoreCase(argField.getType())) {
/*      */       
/*  241 */       out.append("    if (getDAO_().");
/*  242 */       out.append(getterName);
/*  243 */       out.append("() != null) {\n");
/*  244 */       out.append("      return getDAO_().");
/*  245 */       out.append(getterName);
/*  246 */       out.append("()");
/*  247 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  248 */       out.append(";\n");
/*  249 */       out.append("    }\n");
/*  250 */       out.append("    else {\n");
/*      */       
/*  252 */       if (argField.getDefaultValueIfNull() == null) {
/*  253 */         out.append("      return 0; // no default specified in the dtx; we default to 0\n");
/*      */       }
/*  255 */       else if (argField.getDefaultValueIfNull() instanceof Long) {
/*  256 */         out.append("      return ");
/*  257 */         out.append(argField.getDefaultValueIfNull());
/*  258 */         out.append("l; // <<< default specified in .dtx\n");
/*      */       } else {
/*      */         
/*  261 */         out.append("      return ");
/*  262 */         out.append(argField.getDefaultValueIfNull());
/*  263 */         out.append("; // <<< default specified in .dtx\n");
/*      */       } 
/*      */       
/*  266 */       out.append("    }\n");
/*      */     
/*      */     }
/*  269 */     else if (!StringUtils.isEmpty(argField.getEncrypt()) && "String".equalsIgnoreCase(argField.getType())) {
/*  270 */       out.append("    return decryptField(\"");
/*  271 */       out.append(argField.getEncrypt());
/*  272 */       out.append("\", ");
/*  273 */       out.append("getDAO_().");
/*  274 */       out.append(getterName);
/*  275 */       out.append("())");
/*  276 */       out.append(";\n");
/*      */     } else {
/*      */       
/*  279 */       out.append("    return getDAO_().");
/*  280 */       out.append(getterName);
/*  281 */       out.append("()");
/*  282 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  283 */       out.append(";\n");
/*      */     } 
/*      */ 
/*      */     
/*  287 */     out.append("  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateFields(StringBuilder out, DtxDefinition argDtx) {
/*  294 */     for (DtxInverseRelationship rel : argDtx.getInverseRelationships()) {
/*  295 */       out.append("  private ");
/*  296 */       out.append(rel.getParent().getInterface());
/*  297 */       out.append(" _");
/*  298 */       out.append(StringUtils.ensureFirstLowerCase(rel.getName()));
/*  299 */       out.append(";\n");
/*      */     } 
/*      */     
/*  302 */     if ((argDtx.getInverseRelationships()).length > 0) {
/*  303 */       out.append("\n");
/*      */     }
/*      */     
/*  306 */     out.append("\n  private transient boolean _alreadyInStart = false;\n  private transient boolean _alreadyInCommit = false;\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  314 */     out.append("  private IDataModel _myExtension;\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateFieldSetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  322 */     boolean childPrimaryKey = false;
/*      */     
/*  324 */     if (argDtx.isExtended() && argField.isPrimaryKey() && 
/*  325 */       !argDtx.getRelationships(DtxRelationship.ONE_MANY).isEmpty())
/*      */     {
/*      */ 
/*      */       
/*  329 */       childPrimaryKey = true;
/*      */     }
/*      */ 
/*      */     
/*  333 */     String getterName = DaoGenUtils.getGetterNameForField(argField);
/*  334 */     String setterName = DaoGenUtils.getSetterNameForField(argField);
/*  335 */     String arg = DaoGenUtils.getArgNameForField(argField);
/*      */     
/*  337 */     String obj = DaoGenUtils.wrapStatementWithObject(arg, argField.getType());
/*  338 */     out.append("  /**\n");
/*  339 */     out.append("   * Sets the value of the ").append(argField.getColumn()).append(" field.\n");
/*  340 */     out.append("   * @param ").append(arg).append(" The new value for the field.\n");
/*  341 */     out.append("   */\n");
/*  342 */     out.append("  public void ").append(setterName).append("(").append(DaoGenUtils.getVariableType(argField.getType()))
/*  343 */       .append(" ").append(arg).append(") {\n");
/*      */ 
/*      */     
/*  346 */     if (getBaseModelMethod(setterName, new Class[] { DaoGenUtils.getClassForType(argField.getType()) }) != null) {
/*  347 */       out.append("    super.");
/*  348 */       out.append(setterName);
/*  349 */       out.append("(");
/*  350 */       out.append(arg);
/*  351 */       out.append(");\n\n");
/*      */     } 
/*      */     
/*  354 */     out.append("    if (").append(setterName).append("_noev(").append(arg).append(")) {\n");
/*      */     
/*  356 */     if (!argField.isSuppressed()) {
/*  357 */       out.append("      if (_events != null) {\n");
/*  358 */       out.append("        if (postEventsForChanges()) {\n");
/*  359 */       out.append("          _events.post(").append(argDtx.getInterface()).append(".SET_")
/*  360 */         .append(argField.getName().toUpperCase()).append(", ").append(obj).append(");\n");
/*  361 */       out.append("        }\n");
/*  362 */       out.append("      }\n");
/*      */     } else {
/*      */       
/*  365 */       out.append("      // suppress-event is specified for this field.\n");
/*      */     } 
/*  367 */     out.append("    }\n");
/*  368 */     out.append("  }\n");
/*  369 */     out.append("\n");
/*      */ 
/*      */ 
/*      */     
/*  373 */     out.append("  public boolean ").append(setterName).append("_noev(")
/*  374 */       .append(DaoGenUtils.getVariableType(argField.getType())).append(" ").append(arg).append(") {\n");
/*  375 */     out.append("    boolean ev_postable = false;\n");
/*  376 */     out.append("\n");
/*      */     
/*  378 */     if (!childPrimaryKey) {
/*  379 */       out.append("    if ((getDAO_().").append(getterName).append("() == null && ").append(obj)
/*  380 */         .append(" != null) ||\n");
/*  381 */       out.append("        (getDAO_().").append(getterName).append("() != null && !getDAO_().")
/*  382 */         .append(getterName).append("().equals(").append(obj).append("))) {\n");
/*  383 */       if (!StringUtils.isEmpty(argField.getEncrypt()) && "String".equalsIgnoreCase(argField.getType())) {
/*  384 */         out.append("      getDAO_().").append(setterName).append("(").append("encryptField(\"")
/*  385 */           .append(argField.getEncrypt()).append("\", ").append(obj).append("));\n");
/*      */       } else {
/*      */         
/*  388 */         out.append("      getDAO_().").append(setterName).append("(").append(obj).append(");\n");
/*      */       } 
/*      */       
/*  391 */       out.append("      ev_postable = true;\n");
/*      */     } else {
/*      */       
/*  394 */       out.append("\n").append("    if (super.").append(setterName).append("_noev(").append(arg)
/*  395 */         .append(")) {\n");
/*      */     } 
/*      */ 
/*      */     
/*  399 */     for (DtxRelationship rel : argDtx.getRelationships(DtxRelationship.ONE_MANY)) {
/*  400 */       for (DtxRelationship.DtxRelationshipField fld : rel.getFields()) {
/*  401 */         if (fld.getParent().equals(argField.getName())) {
/*  402 */           String properChild = StringUtils.ensureFirstUpperCase(fld.getChild());
/*  403 */           out.append("      if (" + rel.getParentAttributeName()).append(" != null) {\n");
/*  404 */           out.append("        // Propagate changes to related objects in relation " + rel.getName())
/*  405 */             .append(".\n");
/*  406 */           out.append("        java.util.Iterator it = " + rel.getParentAttributeName() + ".iterator();\n");
/*  407 */           out.append("        while(it.hasNext()) {\n");
/*  408 */           out.append("          // Use the non-eventing setter directly.\n");
/*  409 */           out.append("          ((" + rel.getChild().getModel() + ") it.next()).set" + properChild + "_noev(" + arg + ");\n");
/*      */           
/*  411 */           out.append("        }\n");
/*  412 */           out.append("      }\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  418 */     for (DtxRelationship rel : argDtx.getRelationships(DtxRelationship.ONE_ONE)) {
/*  419 */       if (!rel.getDependent()) {
/*      */         continue;
/*      */       }
/*  422 */       for (DtxRelationship.DtxRelationshipField fld : rel.getFields()) {
/*  423 */         if (fld.getParent().equals(argField.getName())) {
/*  424 */           String properChild = StringUtils.ensureFirstUpperCase(fld.getChild());
/*  425 */           out.append("      if (" + rel.getParentAttributeName()).append(" != null) {\n");
/*  426 */           out.append("        // Propagate changes to related objects in relation " + rel.getName())
/*  427 */             .append(".\n");
/*  428 */           out.append("          // Use the non-eventing setter directly.\n");
/*  429 */           out.append("          ((" + rel.getChild().getModel() + ")" + rel.getParentAttributeName() + ").set" + properChild + "_noev(" + arg + ");\n");
/*      */           
/*  431 */           out.append("      }\n");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  436 */     out.append("    }\n");
/*  437 */     out.append("\n");
/*  438 */     out.append("    return ev_postable;\n");
/*  439 */     out.append("  }\n\n");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void generateFooter(StringBuilder out, DtxDefinition dtx) {
/*  444 */     out.append("\n");
/*  445 */     out.append("}\n");
/*      */   }
/*      */   
/*      */   protected void generateHeader(StringBuilder out, DtxDefinition argDtx) {
/*  449 */     out.append("package " + argDtx.getPackage() + ";\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  454 */     out.append("import java.math.BigDecimal;\n");
/*  455 */     out.append("import java.util.*;\n");
/*  456 */     out.append("import dtv.data2.access.impl.*;\n");
/*      */ 
/*      */     
/*  459 */     if (this._baseModelClass != null) {
/*  460 */       out.append("import ");
/*  461 */       out.append(this._baseModelClass.getName());
/*  462 */       out.append(";\n");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  468 */     out.append("import dtv.data2.access.IDataModel;\n");
/*  469 */     out.append("import dtv.data2.access.ModelEventor;\n");
/*      */     
/*  471 */     boolean historicalListImported = false;
/*      */     
/*  473 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*  474 */       if (DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType())) {
/*  475 */         out.append("import " + relationship.getChild().getInterface() + ";\n");
/*      */         continue;
/*      */       } 
/*  478 */       if (!historicalListImported) {
/*  479 */         out.append("import dtv.util.HistoricalList;\n");
/*  480 */         out.append("import dtv.data2.access.*;\n");
/*      */         
/*  482 */         historicalListImported = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  490 */     if (!argDtx.isExtended()) {
/*  491 */       out.append("import ");
/*  492 */       out.append(argDtx.getId());
/*  493 */       out.append(";\n");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  499 */     out.append(this._helper.getClassCommentWithSuppressWarnings("Auto Generated Model"));
/*      */     
/*  501 */     out.append("public class ");
/*  502 */     out.append(argDtx.getName());
/*  503 */     out.append("Model \n");
/*      */     
/*  505 */     if (this._baseModelClass != null) {
/*  506 */       out.append("    extends ");
/*  507 */       out.append(this._baseModelClass.getSimpleName());
/*  508 */       out.append("\n");
/*      */       
/*  510 */       if (argDtx.isExtended() && 
/*  511 */         !this._baseModelClass.getSuperclass().getName().equals(argDtx.getExtends().getModel())) {
/*  512 */         throw new DtxException("A base data model was provided for a data model that is an extension of another, but the base data model was not declared to extend the ancestor data model. For instance, a NonPhysicalItemBaseModel must extend ItemModel since NonPhysicalItem extends Item.");
/*      */       }
/*      */ 
/*      */       
/*  516 */       if (DaoGenHelper.isPropertyChildNeeded(argDtx) && 
/*  517 */         !this._baseModelClass.getSuperclass().equals(AbstractDataModelWithPropertyImpl.class)) {
/*  518 */         throw new DtxException("A base data model [" + this._baseModelClass.getName() + "] was provided for a data model that requires a property child [" + argDtx
/*  519 */             .getModel() + "], but the base model does not extend " + AbstractDataModelWithPropertyImpl.class
/*  520 */             .getName() + ".");
/*      */       
/*      */       }
/*      */     }
/*  524 */     else if (argDtx.isExtended()) {
/*      */ 
/*      */       
/*  527 */       out.append("    extends ");
/*  528 */       out.append(argDtx.getExtends().getModel());
/*  529 */       out.append("\n");
/*      */     }
/*  531 */     else if (DaoGenHelper.isPropertyChildNeeded(argDtx)) {
/*  532 */       out.append("    extends ");
/*  533 */       out.append(AbstractDataModelWithPropertyImpl.class.getName());
/*  534 */       out.append("<");
/*  535 */       out.append(DaoGenHelper.getPropertyInterfaceName(argDtx));
/*  536 */       out.append(">\n");
/*      */     }
/*  538 */     else if (argDtx.isProperties()) {
/*  539 */       out.append("    extends ");
/*  540 */       out.append(AbstractDataModelPropertiesImpl.class.getName());
/*  541 */       out.append("\n");
/*      */     } else {
/*      */       
/*  544 */       out.append("    extends ");
/*  545 */       out.append(AbstractDataModelImpl.class.getName());
/*  546 */       out.append("\n");
/*      */     } 
/*      */     
/*  549 */     out.append("    implements ");
/*  550 */     out.append(argDtx.getInterface());
/*  551 */     out.append(" {\n\n  // Fix serialization compatability based on the name of the DAO\n  private static final long serialVersionUID = ");
/*      */ 
/*      */     
/*  554 */     out.append(argDtx.getName().hashCode());
/*  555 */     out.append("L;\n\n");
/*      */   }
/*      */   
/*      */   protected void generateNewPropertyMethod(StringBuilder out, DtxDefinition argDtx) {
/*  559 */     String propertyName = DaoGenHelper.getPropertyName(argDtx);
/*  560 */     DtxDefinition child = this._helper.getTypeNameDefinition(propertyName);
/*      */ 
/*      */     
/*  563 */     out.append("  protected ");
/*  564 */     out.append(child.getInterface());
/*  565 */     out.append(" newProperty(String argPropertyName)  {\n");
/*      */     
/*  567 */     out.append("    ");
/*  568 */     out.append(child.getId());
/*  569 */     out.append(" id = new ");
/*  570 */     out.append(child.getId());
/*  571 */     out.append("();\n\n");
/*      */     
/*  573 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/*  574 */       if (!field.getName().equals("organizationId")) {
/*  575 */         out.append("    id.");
/*  576 */         out.append(DaoGenUtils.getSetterNameForField(field));
/*  577 */         out.append("(");
/*  578 */         out.append(DaoGenUtils.wrapStatementWithObject(DaoGenUtils.getGetterNameForField(field) + "()", field.getType()));
/*  579 */         out.append(");\n");
/*      */       } 
/*      */     } 
/*      */     
/*  583 */     out.append("    id.setPropertyCode(argPropertyName);\n\n");
/*  584 */     out.append("    ");
/*  585 */     out.append(child.getInterface());
/*  586 */     out.append(" prop = dtv.data2.access.DataFactory.getInstance().createNewObject(id, ");
/*  587 */     out.append(child.getInterface());
/*  588 */     out.append(".class);\n");
/*  589 */     out.append("    return prop;\n");
/*  590 */     out.append("  }\n");
/*  591 */     out.append("\n");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void generateRelationshipFields(StringBuilder out, List<DtxRelationship> argRelationships) {
/*  597 */     for (DtxRelationship relationship : argRelationships) {
/*      */ 
/*      */       
/*  600 */       String typeName = DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType()) ? relationship.getChild().getInterfaceTypeOnly() : ("HistoricalList<" + relationship.getChild().getInterface() + ">");
/*  601 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*  602 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*  603 */       out.append("  private " + typeName + " " + fieldName + ";\n");
/*  604 */       out.append("  // So that rollback() reverts to proper value\n");
/*  605 */       out.append("  private transient " + typeName + " " + savepointFieldName + ";\n");
/*      */     } 
/*  607 */     out.append("\n");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void generateRelationshipMethods(StringBuilder out, DtxDefinition argDtx, List<DtxRelationship> argRelationships) {
/*  612 */     StringBuilder persistenceDefaultsBuilder = new StringBuilder();
/*      */     
/*  614 */     persistenceDefaultsBuilder.append("  @Override\n");
/*  615 */     persistenceDefaultsBuilder.append("  public void setDependencies(dtv.data2.IPersistenceDefaults argPD, dtv.event.EventManager argEM) {\n");
/*      */ 
/*      */     
/*  618 */     if (argDtx.getExtends() == null) {
/*  619 */       persistenceDefaultsBuilder.append("    _persistenceDefaults = argPD;\n");
/*  620 */       persistenceDefaultsBuilder.append("    _daoImpl.setPersistenceDefaults(argPD);\n");
/*  621 */       persistenceDefaultsBuilder.append("    _eventManager = argEM;\n");
/*  622 */       persistenceDefaultsBuilder.append("    _events = new ModelEventor(this, argEM);\n");
/*  623 */       persistenceDefaultsBuilder
/*  624 */         .append("    _eventCascade = new dtv.event.handler.CascadingHandler(this);\n");
/*      */     } else {
/*      */       
/*  627 */       persistenceDefaultsBuilder.append("    super.setDependencies(argPD, argEM);\n");
/*      */     } 
/*      */     
/*  630 */     for (DtxRelationship relationship : argRelationships) {
/*  631 */       DtxDefinition child = relationship.getChild();
/*  632 */       String argName = DaoGenUtils.getArgNameForRelationship(relationship);
/*  633 */       String typeName = DaoGenUtils.getTypeForRelationship(relationship, false);
/*  634 */       String getterName = DaoGenUtils.getGetterNameForRelationship(relationship);
/*  635 */       String setterName = DaoGenUtils.getSetterNameForRelationship(relationship);
/*  636 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*  637 */       String relationshipName = StringUtils.ensureFirstUpperCase(relationship.getName());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  642 */       persistenceDefaultsBuilder.append("    if (" + fieldName + " != null) {\n");
/*  643 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType()) || DtxRelationship.MANY_MANY
/*  644 */         .equalsIgnoreCase(relationship.getType())) {
/*  645 */         persistenceDefaultsBuilder.append("      for (")
/*  646 */           .append(relationship.getChild().getInterface() + " relationship : ").append(fieldName)
/*  647 */           .append(") {\n");
/*  648 */         persistenceDefaultsBuilder.append("        ((dtv.data2.access.impl.IDataModelImpl)relationship).setDependencies(argPD, argEM);\n");
/*      */         
/*  650 */         persistenceDefaultsBuilder.append("      }\n");
/*      */       } else {
/*      */         
/*  653 */         persistenceDefaultsBuilder.append("      ((dtv.data2.access.impl.IDataModelImpl)" + fieldName + ").setDependencies(argPD, argEM);\n");
/*      */       } 
/*      */       
/*  656 */       persistenceDefaultsBuilder.append("    }\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  664 */       Method baseModelGetter = getBaseModelMethod(getterName, new Class[0]);
/*  665 */       if (baseModelGetter == null) {
/*  666 */         out.append("  @Relationship(name=\"").append(relationshipName).append("\")\n");
/*  667 */         out.append("  public ").append(typeName).append(" ").append(getterName).append("() {\n");
/*  668 */         if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType()) || DtxRelationship.MANY_MANY
/*  669 */           .equalsIgnoreCase(relationship.getType())) {
/*  670 */           addListInitializer(out, relationship, "null", null);
/*      */         }
/*  672 */         out.append("    return ").append(fieldName).append(";\n");
/*  673 */         out.append("  }\n\n");
/*      */       } 
/*      */       
/*  676 */       if (DtxRelationship.ONE_ONE.equalsIgnoreCase(relationship.getType())) {
/*      */ 
/*      */ 
/*      */         
/*  680 */         out.append("  public void ").append(setterName).append("( ").append(child.getInterface());
/*  681 */         out.append(" ");
/*  682 */         out.append(argName);
/*  683 */         out.append(") {\n");
/*      */ 
/*      */         
/*      */         try {
/*  687 */           Class<?> parameterClass = this._helper.getPrecompileClassloader().loadClass(child.getInterface());
/*      */           
/*  689 */           if (getBaseModelMethod(setterName, new Class[] { parameterClass }) != null) {
/*  690 */             out.append("    super.");
/*  691 */             out.append(setterName);
/*  692 */             out.append("(");
/*  693 */             out.append(argName);
/*  694 */             out.append(");\n\n");
/*      */           }
/*      */         
/*  697 */         } catch (ClassNotFoundException ex) {
/*  698 */           throw new DtxException(child.getInterface() + " class was not found when generating data model [" + argDtx
/*  699 */               .getName() + "].");
/*      */         } 
/*      */         
/*  702 */         out.append("    // null out keys that define this relationship\n");
/*  703 */         out.append("    if( ");
/*  704 */         out.append(argName);
/*  705 */         out.append(" == null) {\n");
/*      */         
/*  707 */         if (relationship.getFieldsNotShared().isEmpty()) {
/*  708 */           out.append("      // all the fields that define this relationship are shared.  It cannot be broken.\n");
/*      */           
/*  710 */           out.append("      if (");
/*  711 */           out.append(fieldName);
/*  712 */           out.append(" != null) {\n");
/*  713 */           out.append("        throw new dtv.data2.access.exception.DtxException(\"An Attempt was made to break a ONE-ONE");
/*      */           
/*  715 */           out.append(" relationship that cannot be broken because all fields that define the relationship are");
/*      */           
/*  717 */           out.append(" primary keys on the parent data object.\");\n");
/*  718 */           out.append("      }\n");
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  723 */         if (!relationship.getDependent()) {
/*  724 */           out.append("      // null out the keys that define this relationship of two independent objects.\n");
/*      */           
/*  726 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFieldsNotShared()) {
/*  727 */             out.append("      getDAO_().set");
/*  728 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  729 */             out.append("(null);\n");
/*      */           } 
/*      */         } 
/*      */         
/*  733 */         out.append("      if ( ");
/*  734 */         out.append(fieldName);
/*  735 */         out.append(" != null) {\n");
/*      */         
/*  737 */         out.append("        // De-register from the previous child.\n");
/*  738 */         out.append("        if (postEventsForChanges()) {\n");
/*  739 */         out.append("          _eventManager.deregisterEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */         
/*  741 */         out.append(fieldName).append("));\n");
/*  742 */         out.append("        }\n");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  747 */         if (relationship.getDependent()) {
/*  748 */           out.append("        super.addDeletedObject(");
/*  749 */           out.append(fieldName);
/*  750 */           out.append(");\n");
/*      */         } 
/*  752 */         out.append("      }\n    }\n    else {\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  760 */         if (relationship.getDependent()) {
/*  761 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFields()) {
/*  762 */             out.append("      ");
/*  763 */             out.append(argName);
/*  764 */             out.append(".set");
/*  765 */             out.append(StringUtils.ensureFirstUpperCase(field.getChild()));
/*  766 */             out.append("(this.get");
/*  767 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  768 */             out.append("());\n");
/*      */           } 
/*  770 */           out.append("\n");
/*      */         } else {
/*      */           
/*  773 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFieldsNotShared()) {
/*  774 */             DtxDefinition.DtxDaoField theRealField = relationship.getChild().findField(field.getChild());
/*      */             
/*  776 */             out.append("      getDAO_().set");
/*  777 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  778 */             out.append("(");
/*  779 */             out.append(DaoGenUtils.wrapStatementWithObject(argName + ".get" + 
/*  780 */                   StringUtils.ensureFirstUpperCase(field.getChild()) + "()", theRealField
/*  781 */                   .getType()));
/*  782 */             out.append(");\n");
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  788 */         DtxInverseRelationship inverseRelationship = child.getInverseRelationship(argDtx);
/*  789 */         if (inverseRelationship != null) {
/*  790 */           out.append("      // notify children with inverse relationships that they have a parent.\n");
/*  791 */           out.append("      " + argName + "." + inverseRelationship.getSetMethodName() + "(this);\n\n");
/*      */         } 
/*      */         
/*  794 */         out.append("      // Register the cascading event handler to receive events from the new child.\n      if (postEventsForChanges()) {\n        _eventManager.registerEventHandler(_eventCascade, new dtv.event.EventDescriptor(" + argName + "));\n      }\n    }\n\n    ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  801 */         out.append(fieldName);
/*  802 */         out.append(" = ");
/*  803 */         out.append(argName);
/*  804 */         out.append(";\n");
/*  805 */         out.append("    if (postEventsForChanges()) {\n");
/*  806 */         out.append("      _events.post(");
/*  807 */         out.append(argDtx.getInterface());
/*  808 */         out.append(".SET_");
/*  809 */         out.append(relationship.getName().toUpperCase());
/*  810 */         out.append(", ");
/*  811 */         out.append(argName);
/*  812 */         out.append(");\n");
/*  813 */         out.append("    }\n");
/*  814 */         out.append("  }\n\n");
/*      */         continue;
/*      */       } 
/*  817 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType()) || DtxRelationship.MANY_MANY
/*  818 */         .equalsIgnoreCase(relationship.getType())) {
/*  819 */         String addRemoveArgName = DaoGenUtils.getArgNameForRelationshipAddRemove(relationship);
/*  820 */         String childInterface = relationship.getChild().getInterface();
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  825 */         out.append("  public void ").append(setterName).append("( ").append(typeName);
/*  826 */         out.append(" ").append(argName).append(") {\n");
/*      */ 
/*      */         
/*  829 */         if (getBaseModelMethod(setterName, new Class[] { List.class }) != null) {
/*  830 */           out.append("    super.").append(setterName).append("(").append(argName).append(");\n\n");
/*      */         }
/*      */         
/*  833 */         addListInitializer(out, relationship, argName, argName);
/*      */ 
/*      */         
/*  836 */         DtxInverseRelationship inverseRelationship = child.getInverseRelationship(argDtx);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  841 */         if (inverseRelationship != null) {
/*  842 */           out.append("    // notify children with inverse relationships that they have a parent.\n");
/*  843 */           out.append("    for( ").append(childInterface).append(" child : ").append(fieldName)
/*  844 */             .append(") {\n");
/*  845 */           out.append("      child.").append(inverseRelationship.getSetMethodName()).append("(this);\n");
/*  846 */           out.append("    }\n\n");
/*      */         } 
/*      */ 
/*      */         
/*  850 */         String childType = child.getInterface();
/*  851 */         String childModel = child.getModel();
/*  852 */         if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType())) {
/*  853 */           out.append("    // Propagate identification information through the graph.\n");
/*  854 */           out.append("    for( ").append(childType).append(" child : ").append(fieldName).append(") {\n");
/*  855 */           out.append("      ").append(childModel).append(" model = (").append(childModel)
/*  856 */             .append(") child;\n");
/*      */           
/*  858 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFields()) {
/*  859 */             String parentName = StringUtils.ensureFirstUpperCase(field.getParent());
/*  860 */             String childName = StringUtils.ensureFirstUpperCase(field.getChild());
/*  861 */             out.append("      model.set").append(childName).append("_noev(this.get").append(parentName)
/*  862 */               .append("());\n");
/*      */           } 
/*      */           
/*  865 */           out.append("      if (child instanceof IDataModelImpl) {\n");
/*  866 */           out.append("        IDataAccessObject childDao = ((IDataModelImpl) child).getDAO();\n");
/*  867 */           out.append("        if (dtv.util.StringUtils.isEmpty(childDao.getOriginDataSource()) && \n");
/*  868 */           out.append("            !dtv.util.StringUtils.isEmpty(this.getDAO().getOriginDataSource())) {\n");
/*  869 */           out.append("          childDao.setOriginDataSource(this.getDAO().getOriginDataSource());\n");
/*  870 */           out.append("        }\n");
/*  871 */           out.append("      }\n");
/*      */ 
/*      */           
/*  874 */           out.append("      if (postEventsForChanges()) {\n");
/*  875 */           out.append("        _eventManager.registerEventHandler(_eventCascade, child);\n");
/*  876 */           out.append("      }\n");
/*  877 */           out.append("    }\n");
/*      */         } 
/*      */         
/*  880 */         out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  885 */         String adderMethodName = DaoGenUtils.getAdderNameForRelationship(relationship);
/*  886 */         out.append("  public void ");
/*  887 */         out.append(adderMethodName);
/*  888 */         out.append("(");
/*  889 */         out.append(relationship.getChild().getInterface());
/*  890 */         out.append(" ");
/*  891 */         out.append(addRemoveArgName);
/*  892 */         out.append(") {\n");
/*      */ 
/*      */         
/*      */         try {
/*  896 */           Class<?> parameterClass = this._helper.getPrecompileClassloader().loadClass(childInterface);
/*      */           
/*  898 */           if (getBaseModelMethod(adderMethodName, new Class[] { parameterClass }) != null) {
/*  899 */             out.append("    super.");
/*  900 */             out.append(adderMethodName);
/*  901 */             out.append("(");
/*  902 */             out.append(addRemoveArgName);
/*  903 */             out.append(");\n\n");
/*      */           }
/*      */         
/*  906 */         } catch (ClassNotFoundException ex) {
/*  907 */           throw new DtxException(childInterface + " class was not found when generating data model [" + argDtx
/*  908 */               .getName() + "].");
/*      */         } 
/*      */         
/*  911 */         if (inverseRelationship != null) {
/*  912 */           out.append("    // notify children with inverse relationships that they have a parent.\n");
/*  913 */           out.append("    ");
/*  914 */           out.append(addRemoveArgName);
/*  915 */           out.append(".");
/*  916 */           out.append(inverseRelationship.getSetMethodName());
/*  917 */           out.append("(this);\n");
/*      */         } 
/*      */         
/*  920 */         addListInitializer(out, relationship, "null", null);
/*      */ 
/*      */         
/*  923 */         if (DtxRelationship.ONE_MANY.equalsIgnoreCase(relationship.getType())) {
/*  924 */           for (DtxRelationship.DtxRelationshipField field : relationship.getFields()) {
/*  925 */             out.append("    ");
/*  926 */             out.append(addRemoveArgName);
/*  927 */             out.append(".set");
/*  928 */             out.append(StringUtils.ensureFirstUpperCase(field.getChild()));
/*  929 */             out.append("(this.get");
/*  930 */             out.append(StringUtils.ensureFirstUpperCase(field.getParent()));
/*  931 */             out.append("());\n");
/*      */           } 
/*      */ 
/*      */           
/*  935 */           out.append("    if (");
/*  936 */           out.append(addRemoveArgName);
/*  937 */           out.append(" instanceof IDataModelImpl) {\n");
/*  938 */           out.append("      IDataAccessObject childDao = ((IDataModelImpl) ");
/*  939 */           out.append(addRemoveArgName);
/*  940 */           out.append(").getDAO();\n");
/*  941 */           out.append("      if (dtv.util.StringUtils.isEmpty(childDao.getOriginDataSource()) && \n");
/*  942 */           out.append("          !dtv.util.StringUtils.isEmpty(this.getDAO().getOriginDataSource())) {\n");
/*  943 */           out.append("        childDao.setOriginDataSource(this.getDAO().getOriginDataSource());\n");
/*  944 */           out.append("      }\n");
/*  945 */           out.append("    }\n\n");
/*      */           
/*  947 */           out.append("    // Register the _handleChildEvent method to receive events from the new child.\n");
/*  948 */           out.append("    if (postEventsForChanges()) {\n");
/*  949 */           out.append("      _eventManager.registerEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */           
/*  951 */           out.append(addRemoveArgName + "));\n");
/*  952 */           out.append("    }\n\n");
/*      */         } 
/*      */         
/*  955 */         out.append("    ");
/*  956 */         out.append(fieldName);
/*  957 */         out.append(".add(");
/*  958 */         out.append(addRemoveArgName);
/*  959 */         out.append(");\n");
/*  960 */         out.append("    if (postEventsForChanges()) {\n");
/*  961 */         out.append("      _events.post(");
/*  962 */         out.append(argDtx.getInterface());
/*  963 */         out.append(".ADD_");
/*  964 */         out.append(relationship.getName().toUpperCase());
/*  965 */         out.append(", ");
/*  966 */         out.append(addRemoveArgName);
/*  967 */         out.append(");\n");
/*  968 */         out.append("    }\n");
/*  969 */         out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  974 */         String removerMethodName = DaoGenUtils.getRemoverNameForRelationship(relationship);
/*  975 */         out.append("  public void ");
/*  976 */         out.append(DaoGenUtils.getRemoverNameForRelationship(relationship));
/*  977 */         out.append("(");
/*  978 */         out.append(relationship.getChild().getInterface());
/*  979 */         out.append(" ");
/*  980 */         out.append(addRemoveArgName);
/*  981 */         out.append(") {\n");
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  987 */           Class<?> parameterClass = this._helper.getPrecompileClassloader().loadClass(childInterface);
/*      */           
/*  989 */           if (getBaseModelMethod(removerMethodName, new Class[0]) != null) {
/*  990 */             out.append("    super.");
/*  991 */             out.append(removerMethodName);
/*  992 */             out.append("(");
/*  993 */             out.append(addRemoveArgName);
/*  994 */             out.append(");\n\n");
/*      */           }
/*      */         
/*  997 */         } catch (ClassNotFoundException ex) {
/*  998 */           throw new DtxException(childInterface + " class was not found when generating data model [" + argDtx
/*  999 */               .getName() + "].");
/*      */         } 
/*      */         
/* 1002 */         out.append("    if (");
/* 1003 */         out.append(fieldName);
/* 1004 */         out.append(" != null) {\n");
/* 1005 */         out.append("    // De-Register the _handleChildEvent method from receiving the child events.\n");
/* 1006 */         out.append("    if (postEventsForChanges()) {\n");
/* 1007 */         out.append("      _eventManager.deregisterEventHandler(_eventCascade, new dtv.event.EventDescriptor(");
/*      */         
/* 1009 */         out.append(addRemoveArgName + "));\n");
/* 1010 */         out.append("    }\n");
/* 1011 */         out.append("      ");
/* 1012 */         out.append(fieldName);
/* 1013 */         out.append(".remove(");
/* 1014 */         out.append(addRemoveArgName);
/* 1015 */         out.append(");\n");
/*      */         
/* 1017 */         if (inverseRelationship != null) {
/* 1018 */           out.append("    // notify children with inverse relationships that they have a parent.\n");
/* 1019 */           out.append("    ").append(addRemoveArgName).append(".")
/* 1020 */             .append(inverseRelationship.getSetMethodName()).append("(null);\n");
/*      */         } 
/*      */         
/* 1023 */         out.append("      if (postEventsForChanges()) {\n");
/* 1024 */         out.append("        _events.post(");
/* 1025 */         out.append(argDtx.getInterface());
/* 1026 */         out.append(".REMOVE_");
/* 1027 */         out.append(relationship.getName().toUpperCase());
/* 1028 */         out.append(", ");
/* 1029 */         out.append(addRemoveArgName);
/* 1030 */         out.append(");\n");
/* 1031 */         out.append("      }\n");
/* 1032 */         out.append("    }\n  }\n\n");
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/* 1037 */       throw new Error("*** UNKNOWN RELATIONSHIP TYPE: " + relationship.getType() + " in file: " + argDtx
/* 1038 */           .getSourceDtxFile().getAbsolutePath());
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1046 */     for (DtxInverseRelationship inverseRelationship : argDtx.getInverseRelationships()) {
/*      */       
/* 1048 */       String argName = "arg" + StringUtils.ensureFirstUpperCase(inverseRelationship.getName());
/* 1049 */       String fieldName = "_" + StringUtils.ensureFirstLowerCase(inverseRelationship.getName());
/*      */       
/* 1051 */       out.append("  public void ");
/* 1052 */       out.append(inverseRelationship.getSetMethodName());
/* 1053 */       out.append("(");
/* 1054 */       out.append(inverseRelationship.getParent().getInterface());
/* 1055 */       out.append(" ");
/* 1056 */       out.append(argName);
/* 1057 */       out.append(") {\n    ");
/*      */       
/* 1059 */       out.append(fieldName);
/* 1060 */       out.append(" = ");
/* 1061 */       out.append(argName);
/* 1062 */       out.append(";\n  }\n\n  public ");
/*      */ 
/*      */ 
/*      */       
/* 1066 */       out.append(inverseRelationship.getParent().getInterface());
/* 1067 */       out.append(" ");
/* 1068 */       out.append(inverseRelationship.getGetMethodName());
/* 1069 */       out.append("() {\n    return " + fieldName + ";\n  }\n\n");
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
/* 1080 */     out.append("  @Override\n  public Object getValue(String argFieldId) {\n");
/*      */ 
/*      */     
/* 1083 */     boolean ifPrinted = false;
/* 1084 */     for (DtxRelationship relationship : argRelationships) {
/*      */       
/* 1086 */       if (!ifPrinted) {
/* 1087 */         out.append("    if (");
/* 1088 */         ifPrinted = true;
/*      */       } else {
/*      */         
/* 1091 */         out.append("    else if (");
/*      */       } 
/*      */       
/* 1094 */       out.append("\"");
/* 1095 */       out.append(StringUtils.ensureFirstUpperCase(relationship.getName()));
/* 1096 */       out.append("\".equals(argFieldId)) {\n      return ");
/*      */       
/* 1098 */       out.append(DaoGenUtils.getGetterNameForRelationship(relationship));
/* 1099 */       out.append("();\n    }\n");
/*      */     } 
/*      */ 
/*      */     
/* 1103 */     if (argRelationships.size() == 0) {
/* 1104 */       out.append("    if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } else {
/*      */       
/* 1107 */       out.append("    else if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } 
/*      */     
/* 1110 */     out.append("      return _myExtension;\n");
/* 1111 */     out.append("    }\n");
/*      */     
/* 1113 */     out.append("    else {\n      return super.getValue(argFieldId);\n    }\n  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1123 */     out.append("  @Override\n  public void setValue(String argFieldId, Object argValue) {\n");
/*      */ 
/*      */     
/* 1126 */     ifPrinted = false;
/* 1127 */     for (DtxRelationship relationship : argRelationships) {
/*      */       
/* 1129 */       if (!ifPrinted) {
/* 1130 */         out.append("    if (");
/* 1131 */         ifPrinted = true;
/*      */       } else {
/*      */         
/* 1134 */         out.append("    else if (");
/*      */       } 
/*      */       
/* 1137 */       out.append("\"");
/* 1138 */       out.append(StringUtils.ensureFirstUpperCase(relationship.getName()));
/* 1139 */       out.append("\".equals(argFieldId)) {\n");
/*      */       
/* 1141 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1142 */         out.append("      ");
/* 1143 */         out.append(DaoGenUtils.getSetterNameForRelationship(relationship));
/* 1144 */         out.append("((");
/* 1145 */         out.append(relationship.getChild().getInterface());
/* 1146 */         out.append(")argValue);\n");
/*      */       } else {
/*      */         
/* 1149 */         out.append("      ");
/* 1150 */         out.append(DaoGenUtils.getSetterNameForRelationship(relationship));
/* 1151 */         out.append("(changeToList(argValue,");
/* 1152 */         out.append(relationship.getChild().getInterface());
/* 1153 */         out.append(".class));\n");
/*      */       } 
/*      */       
/* 1156 */       out.append("    }\n");
/*      */     } 
/*      */     
/* 1159 */     if (argRelationships.size() == 0) {
/* 1160 */       out.append("    if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } else {
/*      */       
/* 1163 */       out.append("    else if (\"" + argDtx.getName() + "Extension\".equals(argFieldId)) {\n");
/*      */     } 
/*      */     
/* 1166 */     out.append("      _myExtension = (IDataModel)argValue;\n");
/* 1167 */     out.append("    }\n");
/*      */     
/* 1169 */     out.append("    else {\n      super.setValue(argFieldId, argValue);\n    }\n  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1176 */     persistenceDefaultsBuilder.append("  }\n\n");
/* 1177 */     out.append(persistenceDefaultsBuilder.toString());
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
/* 1188 */     out.append("  @Override\n  public void startTransaction() {\n    if (_alreadyInStart) {\n      return;\n    }\n    else {\n      _alreadyInStart = true;\n    }\n\n    super.startTransaction();\n\n");
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
/* 1200 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*      */       
/* 1202 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/* 1203 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*      */ 
/*      */       
/* 1206 */       out.append("    ");
/* 1207 */       out.append(savepointFieldName);
/* 1208 */       out.append(" = ");
/* 1209 */       out.append(fieldName);
/* 1210 */       out.append(";\n    if (");
/*      */       
/* 1212 */       out.append(fieldName);
/* 1213 */       out.append(" != null) {\n");
/*      */       
/* 1215 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1216 */         out.append("      ");
/* 1217 */         out.append(fieldName);
/* 1218 */         out.append(".startTransaction();\n");
/*      */       }
/* 1220 */       else if ("One-Many".equalsIgnoreCase(relationship.getType()) || "Many-Many"
/* 1221 */         .equalsIgnoreCase(relationship.getType())) {
/*      */ 
/*      */         
/* 1224 */         out.append("      ");
/* 1225 */         out.append(savepointFieldName);
/* 1226 */         out.append(" = new HistoricalList<");
/* 1227 */         out.append(relationship.getChild().getInterface());
/* 1228 */         out.append(">(");
/* 1229 */         out.append(fieldName);
/* 1230 */         out.append(");\n      java.util.Iterator it = ");
/*      */         
/* 1232 */         out.append(fieldName);
/* 1233 */         out.append(".iterator();\n      while (it.hasNext()) {\n        ((dtv.data2.access.IDataModel)it.next()).startTransaction();\n      }\n");
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1238 */       out.append("    }\n\n");
/*      */     } 
/*      */     
/* 1241 */     out.append("    \n    _alreadyInStart = false;\n  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1249 */     out.append("  @Override\n  public void rollbackChanges() {\n    if (isAlreadyRolledBack())\n      return;\n\n    super.rollbackChanges();\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1257 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*      */       
/* 1259 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/* 1260 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*      */ 
/*      */       
/* 1263 */       out.append("    ");
/* 1264 */       out.append(fieldName);
/* 1265 */       out.append(" = ");
/* 1266 */       out.append(savepointFieldName);
/* 1267 */       out.append(";\n    ");
/*      */       
/* 1269 */       out.append(savepointFieldName);
/* 1270 */       out.append(" = null;\n    if (");
/*      */       
/* 1272 */       out.append(fieldName);
/* 1273 */       out.append(" != null) {\n");
/*      */       
/* 1275 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1276 */         out.append("      ");
/* 1277 */         out.append(fieldName);
/* 1278 */         out.append(".rollbackChanges();\n");
/*      */       }
/* 1280 */       else if ("One-Many".equalsIgnoreCase(relationship.getType()) || "Many-Many"
/* 1281 */         .equalsIgnoreCase(relationship.getType())) {
/*      */         
/* 1283 */         out.append("      java.util.Iterator it = ");
/* 1284 */         out.append(fieldName);
/* 1285 */         out.append(".iterator();\n      while (it.hasNext()) {\n        ((dtv.data2.access.IDataModel)it.next()).rollbackChanges();\n      }\n");
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1291 */       out.append("    }\n\n");
/*      */     } 
/*      */     
/* 1294 */     out.append("  }\n\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1299 */     out.append("  @Override\n  public void commitTransaction() {\n    if (_alreadyInCommit) {\n      return;\n    } else {\n      _alreadyInCommit = true;\n    }\n\n    super.commitTransaction();\n\n");
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
/* 1310 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*      */       
/* 1312 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/* 1313 */       String savepointFieldName = DaoGenUtils.getFieldNameForRelationship(relationship) + "Savepoint";
/*      */ 
/*      */       
/* 1316 */       out.append("    ");
/* 1317 */       out.append(savepointFieldName);
/* 1318 */       out.append(" = ");
/* 1319 */       out.append(fieldName);
/* 1320 */       out.append(";\n    if (");
/*      */       
/* 1322 */       out.append(fieldName);
/* 1323 */       out.append(" != null) {\n");
/*      */       
/* 1325 */       if ("One-One".equalsIgnoreCase(relationship.getType())) {
/* 1326 */         out.append("      ");
/* 1327 */         out.append(fieldName);
/* 1328 */         out.append(".commitTransaction();\n");
/*      */       }
/* 1330 */       else if ("One-Many".equalsIgnoreCase(relationship.getType()) || "Many-Many"
/* 1331 */         .equalsIgnoreCase(relationship.getType())) {
/*      */ 
/*      */         
/* 1334 */         out.append("      java.util.Iterator it = ");
/* 1335 */         out.append(fieldName);
/* 1336 */         out.append(".iterator();\n      while (it.hasNext()) {\n        ((dtv.data2.access.IDataModel)it.next()).commitTransaction();\n      }\n");
/*      */ 
/*      */ 
/*      */         
/* 1340 */         out.append("      ");
/* 1341 */         out.append(fieldName);
/* 1342 */         out.append(" = new HistoricalList<");
/* 1343 */         out.append(relationship.getChild().getInterface());
/* 1344 */         out.append(">(");
/* 1345 */         out.append(fieldName);
/* 1346 */         out.append(");\n");
/*      */       } 
/* 1348 */       out.append("    }\n\n");
/*      */     } 
/*      */     
/* 1351 */     for (int i = 0; i < (argDtx.getFields()).length; i++) {
/* 1352 */       DtxDefinition.DtxDaoField field = argDtx.getFields()[i];
/*      */       
/* 1354 */       if (field.getIncrementField()) {
/* 1355 */         out.append("    getDAO_().setInit");
/* 1356 */         out.append(StringUtils.ensureFirstUpperCase(field.getName()));
/* 1357 */         out.append("(");
/* 1358 */         out.append(DaoGenUtils.wrapStatementWithObject(DaoGenUtils.getGetterNameForField(field) + "()", field.getType()));
/* 1359 */         out.append(");\n");
/*      */         
/* 1361 */         if (i == (argDtx.getFields()).length - 1) {
/* 1362 */           out.append("\n");
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1367 */     out.append("    \n    _alreadyInCommit = false;\n  }\n\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Method getBaseModelMethod(String argMethodName, Class<?>... argParameterTypes) {
/* 1374 */     Method method = null;
/*      */     
/* 1376 */     if (this._baseModelClass != null) {
/*      */       try {
/* 1378 */         method = this._baseModelClass.getDeclaredMethod(argMethodName, argParameterTypes);
/* 1379 */         return method;
/*      */       }
/* 1381 */       catch (NoSuchMethodException noSuchMethodException) {}
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1386 */     return method;
/*      */   }
/*      */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\ModelGeneratorWithJavaDtj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */