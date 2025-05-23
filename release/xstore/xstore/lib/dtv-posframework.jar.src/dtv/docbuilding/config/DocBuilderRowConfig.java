/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.docbuilding.DocBuilderHelper;
/*    */ import dtv.docbuilding.DocBuilderRow;
/*    */ import dtv.docbuilding.IDocBuilderField;
/*    */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderRowConfig
/*    */   extends AbstractDocBuilderRowConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private final List<DocBuilderFieldConfig> fieldConfigs_ = new ArrayList<>();
/*    */   
/* 28 */   private int count_ = 1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCount() {
/* 37 */     return this.count_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DocBuilderFieldConfig> getFieldConfigs() {
/* 45 */     return this.fieldConfigs_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocBuilderRow makeRow(FormatterMapConfig argFormatterMap) {
/* 55 */     List<IDocBuilderCondition> conditions = DocBuilderHelper.createConditions(getConditionConfigs());
/* 56 */     List<IDocBuilderField> fields = createFields(argFormatterMap);
/*    */ 
/*    */     
/* 59 */     DocBuilderRow row = new DocBuilderRow(getAlignment(), getCharSize(), getStyle(), isOvertype(), conditions, fields);
/*    */     
/* 61 */     row.setSourceDescription(getSourceDescription());
/*    */     
/* 63 */     return row;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 69 */     if (argValue instanceof DocBuilderFieldConfig) {
/* 70 */       this.fieldConfigs_.add((DocBuilderFieldConfig)argValue);
/*    */     }
/* 72 */     else if ("n".equalsIgnoreCase(argKey)) {
/* 73 */       this.count_ = ConfigUtils.toInt(argValue, 1);
/*    */     } else {
/*    */       
/* 76 */       super.setConfigObject(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected List<IDocBuilderField> createFields(FormatterMapConfig argFormatterMap) {
/* 87 */     List<IDocBuilderField> fields = new ArrayList<>();
/* 88 */     for (DocBuilderFieldConfig cfg : getFieldConfigs()) {
/* 89 */       fields.add(cfg.makeField(argFormatterMap));
/*    */     }
/* 91 */     return fields;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderRowConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */