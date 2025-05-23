/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultEditModelFieldDefinition
/*    */   extends EditModelField<String>
/*    */ {
/*    */   private final boolean isRequired_;
/*    */   private String xmlTag_;
/*    */   private String value_;
/*    */   
/*    */   public DefaultEditModelFieldDefinition(IFormViewCellConfig cfg, IEditModel model) {
/* 29 */     super(model, cfg.getResource(), String.class);
/*    */     
/* 31 */     this.isRequired_ = cfg.isRequired();
/* 32 */     if (cfg.isReadOnly()) {
/* 33 */       this.attributes_ |= 0x4;
/*    */     }
/* 35 */     if (cfg.getXmlTag() != null && !cfg.getXmlTag().equals("")) {
/* 36 */       this.xmlTag_ = cfg.getXmlTag();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 42 */     return this.value_;
/*    */   }
/*    */   
/*    */   public String getXmlTag() {
/* 46 */     return this.xmlTag_;
/*    */   }
/*    */   
/*    */   public boolean isRequired() {
/* 50 */     return this.isRequired_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String value) {
/* 55 */     this.value_ = value;
/*    */   }
/*    */   
/*    */   protected void lookupAccesorFields(Object argTarget) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DefaultEditModelFieldDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */