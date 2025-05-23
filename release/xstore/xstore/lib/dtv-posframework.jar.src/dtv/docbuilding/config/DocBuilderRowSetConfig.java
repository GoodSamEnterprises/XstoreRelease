/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderHelper;
/*     */ import dtv.docbuilding.DocBuilderRow;
/*     */ import dtv.docbuilding.DocBuilderRowSet;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.docbuilding.types.DocBuilderRowStyleType;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderRowSetConfig
/*     */   extends AbstractDocBuilderRowConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  43 */   private final List<DocBuilderRowConfig> _rowConfigs = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DocBuilderRowConfig> getRowConfigs() {
/*  50 */     return this._rowConfigs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderRowSet makeRowSet(FormatterMapConfig argFormatterMap) {
/*  60 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(getConditionConfigs());
/*  61 */     List<DocBuilderRow> rows = createRows(argFormatterMap);
/*     */     
/*  63 */     DocBuilderRowSet rowSet = new DocBuilderRowSet(conditions, rows);
/*  64 */     rowSet.setSourceDescription(getSourceDescription());
/*     */     
/*  66 */     return rowSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  72 */     if (argValue instanceof DocBuilderRowConfig) {
/*  73 */       this._rowConfigs.add((DocBuilderRowConfig)argValue);
/*     */     } else {
/*     */       
/*  76 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<DocBuilderRow> createRows(FormatterMapConfig argFormatterMap) {
/*  87 */     List<DocBuilderRow> rows = new ArrayList<>();
/*     */     
/*  89 */     DocBuilderAlignmentType defaultAlignment = getAlignment();
/*  90 */     DocBuilderRowCharSize defaultCharSize = getCharSize();
/*  91 */     DocBuilderRowStyleType defaultStyle = getStyle();
/*     */     
/*  93 */     for (DocBuilderRowConfig rowCfg : getRowConfigs()) {
/*  94 */       if (rowCfg.getConfiguredAlignment() == null) rowCfg.setAlignment(defaultAlignment); 
/*  95 */       if (rowCfg.getConfiguredCharSize() == null) rowCfg.setCharSize(defaultCharSize); 
/*  96 */       if (rowCfg.getStyle() == null) rowCfg.setStyle(defaultStyle);
/*     */       
/*  98 */       rows.add(rowCfg.makeRow(argFormatterMap));
/*     */     } 
/* 100 */     return rows;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderRowSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */