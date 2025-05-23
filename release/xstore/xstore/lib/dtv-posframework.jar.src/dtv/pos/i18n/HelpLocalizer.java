/*    */ package dtv.pos.i18n;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.IResourceFormattable;
/*    */ import dtv.i18n.OutputContextType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HelpLocalizer
/*    */ {
/*    */   private static final String HELP_BUNDLE_NAME = "dtv.pos.i18n.help";
/*    */   
/*    */   public static String localize(IFormattable argLocalizable) {
/* 20 */     return (argLocalizable == null) ? null : argLocalizable.toString(OutputContextType.VIEW);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String localize(String argSource, IFormattable... argParams) {
/* 27 */     IFormattable[] params = (argParams == null) ? new IFormattable[0] : argParams;
/*    */     
/* 29 */     IFormattable localizable = FormattableFactory.getInstance().getTranslatable(argSource, params);
/* 30 */     if (localizable instanceof IResourceFormattable) {
/* 31 */       ((IResourceFormattable)localizable).setResourceBundleName("dtv.pos.i18n.help");
/*    */     }
/*    */     
/* 34 */     return localize(localizable);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\i18n\HelpLocalizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */