/*    */ package dtv.pos.i18n.config;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.config.IFormattableConfig;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.PrimitiveConfig;
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
/*    */ public class LiteralConfig
/*    */   extends PrimitiveConfig
/*    */   implements IFormattableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private String literalValue_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LiteralConfig(String argValue) {
/* 33 */     setValue(argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigDataType() {
/* 39 */     return "Literal";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getConfigValue() {
/* 45 */     return this.literalValue_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable() {
/* 51 */     IFormattable f = FormattableFactory.getInstance().getLiteral(this.literalValue_);
/* 52 */     f.setSourceDescription(getSourceDescription());
/* 53 */     return f;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getFormattable(Object argSourceObject) {
/* 59 */     return getFormattable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<IFormattable> getParamDataType() {
/* 65 */     return IFormattable.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getParamValue() {
/* 71 */     return getFormattable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(String value) {
/* 77 */     this.literalValue_ = StringUtils.unescape(value);
/*    */   }
/*    */   
/*    */   public LiteralConfig() {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\LiteralConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */