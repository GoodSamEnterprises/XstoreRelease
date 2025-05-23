/*    */ package dtv.pos.storecalendar.fourfivefour;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Date;
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
/*    */ public class FourFiveFourCalendarConfigHelper
/*    */   extends ConfigHelper<FourFiveFourCalendarConfig>
/*    */ {
/*    */   public List<Date> getClosedDates() {
/* 22 */     return ((FourFiveFourCalendarConfig)getRootConfig()).getClosedDates();
/*    */   }
/*    */   
/*    */   public List<Integer> getClosedDayOfWeeks() {
/* 26 */     return ((FourFiveFourCalendarConfig)getRootConfig()).getClosedDayOfWeeks();
/*    */   }
/*    */ 
/*    */   
/*    */   public IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 31 */     if ("FourFiveFourCalendar".equals(argDtype)) {
/* 32 */       return (IConfigObject)new FourFiveFourCalendarConfig();
/*    */     }
/*    */     
/* 35 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */   
/*    */   public Date getEpoch() {
/* 40 */     return ((FourFiveFourCalendarConfig)getRootConfig()).getEpoch();
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 45 */     return "FourFiveFourCalendarConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean replaceEntireFile() {
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fourfivefour\FourFiveFourCalendarConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */