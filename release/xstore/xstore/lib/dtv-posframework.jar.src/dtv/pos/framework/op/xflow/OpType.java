/*     */ package dtv.pos.framework.op.xflow;
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
/*     */ public enum OpType
/*     */ {
/*  18 */   SYSTEM("system-op.jpg"),
/*     */ 
/*     */   
/*  21 */   FOCUS_BAR_BLUE("focusbar-blue.gif"),
/*     */ 
/*     */   
/*  24 */   FOCUS_BAR_BROWN("focusbar-brown.gif"),
/*     */ 
/*     */   
/*  27 */   FOCUS_BAR_GREEN("focusbar-green.gif"),
/*     */ 
/*     */   
/*  30 */   FOCUS_BAR_ORANGE("focusbar-orange.gif"),
/*     */ 
/*     */   
/*  33 */   FOCUS_BAR_PURPLE("focusbar-purple.gif"),
/*     */ 
/*     */   
/*  36 */   FOCUS_BAR_RED("focusbar-red.gif"),
/*     */ 
/*     */   
/*  39 */   FOCUS_BAR_TEAL("focusbar-teal.gif"),
/*     */ 
/*     */   
/*  42 */   FOCUS_BAR_YELLOW("focusbar-yellow.gif"),
/*     */ 
/*     */   
/*  45 */   FORM_DATA_ENTRY("form-dataentry.gif"),
/*     */ 
/*     */   
/*  48 */   FORM_MULTI_TABS("form-multipletabs.gif"),
/*     */ 
/*     */   
/*  51 */   FORM_SEARCH("form-search.gif"),
/*     */ 
/*     */   
/*  54 */   LISTVIEW_TRANS("listview-trans.gif"),
/*     */ 
/*     */   
/*  57 */   MSG_WINDOW("msgwindow.gif"),
/*     */ 
/*     */   
/*  60 */   PROMPT_1_OPTION("prompt-1option.gif"),
/*     */ 
/*     */   
/*  63 */   PROMPT_2_OPTION("prompt-2option.gif"),
/*     */ 
/*     */   
/*  66 */   PROMPT_3_OPTION("prompt-3option.gif"),
/*     */ 
/*     */   
/*  69 */   PROMPT_COMMENT("prompt-comment.gif"),
/*     */ 
/*     */   
/*  72 */   PROMPT_LIST("prompt-list.gif"),
/*     */ 
/*     */   
/*  75 */   PROMPT_SEARCH_RESULTS("prompt-searchresults.gif"),
/*     */ 
/*     */   
/*  78 */   RECEIPT("receipt.jpg"),
/*     */ 
/*     */   
/*  81 */   REPORT("report.gif");
/*     */ 
/*     */ 
/*     */   
/*     */   private final String iconName_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   OpType(String argIconName) {
/*  91 */     this.iconName_ = "classpath:graphics/xflow/" + argIconName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIconName() {
/* 100 */     return this.iconName_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\OpType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */