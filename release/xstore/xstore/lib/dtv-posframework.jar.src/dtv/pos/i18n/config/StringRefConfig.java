/*    */ package dtv.pos.i18n.config;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.util.config.StringConfig;
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
/*    */ public class StringRefConfig
/*    */   extends StringConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getConfigDataType() {
/* 24 */     return "StringRef";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getParamValue() {
/* 30 */     return FormattableFactory.getInstance().getSimpleFormattable(super.getParamValue())
/* 31 */       .toString(OutputContextType.VIEW);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\config\StringRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */