/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModelField;
/*    */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*    */ import dtv.pos.iframework.form.config.IFormViewConfig;
/*    */ import dtv.util.StringUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ public class DefaultEditModel
/*    */   extends BasicEditModel
/*    */ {
/* 24 */   private final Map<String, DefaultEditModelFieldDefinition> xmlTags_ = new HashMap<>();
/*    */ 
/*    */   
/*    */   public DefaultEditModel(IFormViewConfig cfg) {
/* 28 */     super(cfg.getTitleText(), cfg.getInstructions());
/*    */   }
/*    */ 
/*    */   
/*    */   public void addField(IFormViewCellConfig cfg) {
/* 33 */     if (cfg.getResource() != null) {
/*    */       
/* 35 */       DefaultEditModelFieldDefinition fieldDef = new DefaultEditModelFieldDefinition(cfg, this);
/* 36 */       if (fieldDef.getXmlTag() != null && !fieldDef.getXmlTag().equals("")) {
/* 37 */         this.xmlTags_.put(fieldDef.getXmlTag(), fieldDef);
/*    */       }
/* 39 */       addField(fieldDef);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IEditModelField getFieldDef(String argFieldKey) {
/* 52 */     if (this.xmlTags_.containsKey(argFieldKey)) {
/* 53 */       return this.xmlTags_.get(argFieldKey);
/*    */     }
/* 55 */     return super.getFieldDef(argFieldKey);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getXmlTag(String argKey) {
/* 60 */     IEditModelField def = super.getFieldDef(argKey);
/*    */     
/* 62 */     if (def instanceof DefaultEditModelFieldDefinition) {
/* 63 */       String tag = ((DefaultEditModelFieldDefinition)def).getXmlTag();
/*    */       
/* 65 */       if (!StringUtils.isEmpty(tag)) {
/* 66 */         return tag;
/*    */       }
/*    */     } 
/* 69 */     return argKey;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDynamicFieldCapable() {
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DefaultEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */