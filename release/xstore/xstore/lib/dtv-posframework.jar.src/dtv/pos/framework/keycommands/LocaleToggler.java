/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.i18n.LocaleHelper;
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import javax.inject.Inject;
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
/*    */ public class LocaleToggler
/*    */   implements IKeyCommand
/*    */ {
/*    */   @Inject
/*    */   private LocaleHelper _localeHelper;
/*    */   @Inject
/*    */   private LocaleManager _localeManager;
/*    */   
/*    */   public void execute() {
/* 33 */     List<Locale> locales = this._localeHelper.getAvailableLocales();
/* 34 */     Locale currentLocale = this._localeManager.getLocale(OutputContextType.VIEW);
/* 35 */     int newLocaleIdx = 0;
/*    */     
/* 37 */     for (int i = 0; i < locales.size(); i++) {
/* 38 */       if (((Locale)locales.get(i)).equals(currentLocale)) {
/* 39 */         newLocaleIdx = (i < locales.size() - 1) ? (i + 1) : 0;
/*    */         break;
/*    */       } 
/*    */     } 
/* 43 */     this._localeManager.setLocale(locales.get(newLocaleIdx), OutputContextType.VIEW);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 48 */     return "l";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 53 */     return "cycles the locale for the VIEW context";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\LocaleToggler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */