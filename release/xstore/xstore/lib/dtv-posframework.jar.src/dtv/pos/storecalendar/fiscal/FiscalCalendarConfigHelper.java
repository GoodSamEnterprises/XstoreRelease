/*    */ package dtv.pos.storecalendar.fiscal;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class FiscalCalendarConfigHelper
/*    */   extends ConfigHelper<FiscalCalendarRootConfig>
/*    */ {
/*    */   private final String _calenderSet;
/*    */   
/*    */   public FiscalCalendarConfigHelper() {
/* 21 */     this((String)null);
/*    */   }
/*    */   
/*    */   public FiscalCalendarConfigHelper(String argCalenderSet) {
/* 25 */     this._calenderSet = argCalenderSet;
/* 26 */     initialize();
/*    */   }
/*    */   
/*    */   public FiscalCalendarWeekConfig[] getWeeks() {
/* 30 */     return ((FiscalCalendarRootConfig)getRootConfig()).getWeeks();
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 35 */     if (this._calenderSet == null) {
/* 36 */       return "fiscalcalendar";
/*    */     }
/*    */     
/* 39 */     return "fiscalcalendar/" + this._calenderSet;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 45 */     if ("root".equalsIgnoreCase(argDtype) || "calendar".equalsIgnoreCase(argDtype)) {
/* 46 */       return (IConfigObject)new FiscalCalendarRootConfig();
/*    */     }
/* 48 */     if ("week".equalsIgnoreCase(argDtype)) {
/* 49 */       return (IConfigObject)new FiscalCalendarWeekConfig();
/*    */     }
/*    */     
/* 52 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDirectoryBased() {
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalCalendarConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */