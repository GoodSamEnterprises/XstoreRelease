/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.impl.daogen.DaoGenHelper;
/*     */ import dtv.data2.access.impl.daogen.DaoGenUtils;
/*     */ import dtv.data2.access.impl.daogen.DtxDefinition;
/*     */ import dtv.data2.access.impl.daogen.ModelGeneratorWithJavaDtj;
/*     */ import dtv.util.StringUtils;
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
/*     */ public class ItemOptionsModelGenerator
/*     */   extends ModelGeneratorWithJavaDtj
/*     */ {
/*     */   public ItemOptionsModelGenerator(DaoGenHelper argHelper) {
/*  25 */     super(argHelper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateFieldGetter(StringBuilder out, DtxDefinition argDtx, DtxDefinition.DtxDaoField argField) {
/*  34 */     String proper = StringUtils.ensureFirstUpperCase(argField.getName());
/*     */     
/*  36 */     out.append("  /**\n");
/*  37 */     out.append("   * Gets the value of the ");
/*  38 */     out.append(argField.getColumn());
/*  39 */     out.append(" field. If not value is available and the represented item is part of a style, then it looks to the style item for the value.\n");
/*     */     
/*  41 */     out.append("   * @return The value of the field.\n");
/*  42 */     out.append("   */\n");
/*  43 */     out.append("  public ");
/*  44 */     out.append(DaoGenUtils.getVariableType(argField.getType()));
/*  45 */     out.append(" get");
/*  46 */     out.append(proper);
/*  47 */     out.append("() {\n");
/*     */     
/*  49 */     if ("Boolean".equalsIgnoreCase(argField.getType())) {
/*  50 */       out.append("    if (getDAO_().get");
/*  51 */       out.append(proper);
/*  52 */       out.append("() != null) {\n");
/*  53 */       out.append("      return getDAO_().get");
/*  54 */       out.append(proper);
/*  55 */       out.append("()");
/*  56 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  57 */       out.append(";\n");
/*  58 */       out.append("    }\n");
/*  59 */       out.append("    else if (getParentOptions() != null) {\n");
/*  60 */       out.append("      return getParentOptions().get");
/*  61 */       out.append(proper);
/*  62 */       out.append("();\n");
/*  63 */       out.append("    }\n");
/*  64 */       out.append("    else {\n");
/*  65 */       out.append("      return false;\n");
/*  66 */       out.append("    }\n");
/*     */     }
/*  68 */     else if ("Integer".equalsIgnoreCase(argField.getType()) || "Long"
/*  69 */       .equalsIgnoreCase(argField.getType())) {
/*     */       
/*  71 */       out.append("    if (getDAO_().get");
/*  72 */       out.append(proper);
/*  73 */       out.append("() != null) {\n");
/*  74 */       out.append("      return getDAO_().get");
/*  75 */       out.append(proper);
/*  76 */       out.append("()");
/*  77 */       out.append(DaoGenUtils.toPrimitive(argField.getType()));
/*  78 */       out.append(";\n");
/*  79 */       out.append("    }\n");
/*  80 */       out.append("    else if (getParentOptions() != null) {\n");
/*  81 */       out.append("      return getParentOptions().get");
/*  82 */       out.append(proper);
/*  83 */       out.append("();\n");
/*  84 */       out.append("    }\n");
/*  85 */       out.append("    else {\n");
/*     */       
/*  87 */       if (argField.getDefaultValueIfNull() == null) {
/*  88 */         out.append("      return 0; // no default specified in the dtx; we default to 0\n");
/*     */       }
/*  90 */       else if (argField.getDefaultValueIfNull() instanceof Long) {
/*  91 */         out.append("      return ");
/*  92 */         out.append(argField.getDefaultValueIfNull());
/*  93 */         out.append("l; // <<< default specified in .dtx\n");
/*     */       } else {
/*     */         
/*  96 */         out.append("      return ");
/*  97 */         out.append(argField.getDefaultValueIfNull());
/*  98 */         out.append("; // <<< default specified in .dtx\n");
/*     */       } 
/* 100 */       out.append("    }\n");
/*     */     } else {
/*     */       
/* 103 */       out.append("    if (getDAO_().get");
/* 104 */       out.append(proper);
/* 105 */       out.append("() == null && getParentOptions() != null) {\n");
/* 106 */       out.append("      return getParentOptions().get");
/* 107 */       out.append(proper);
/* 108 */       out.append("();\n");
/* 109 */       out.append("    }\n");
/* 110 */       out.append("    else {\n");
/* 111 */       out.append("      return getDAO_().get");
/* 112 */       out.append(proper);
/* 113 */       out.append("();\n");
/* 114 */       out.append("    }\n");
/*     */     } 
/*     */     
/* 117 */     out.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemOptionsModelGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */