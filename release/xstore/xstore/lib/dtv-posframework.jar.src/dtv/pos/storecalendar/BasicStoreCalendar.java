/*    */ package dtv.pos.storecalendar;
/*    */ 
/*    */ import dtv.pos.common.ConfigurationMgr;
/*    */ 
/*    */ 
/*    */ public class BasicStoreCalendar
/*    */   extends AbstractStoreCalendar
/*    */ {
/*    */   public BasicStoreCalendar() {
/* 10 */     this(ConfigurationMgr.getBasicCalendarPayrollWeekendingDay());
/*    */   }
/*    */   
/*    */   public BasicStoreCalendar(int argLastDayOfWeek) {
/* 14 */     super(argLastDayOfWeek);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean preferOpenOnCurrentSystemDate() {
/* 19 */     return ConfigurationMgr.getPreferCurrentSystemDayOpen();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean getAllowSameDayStoreReopen() {
/* 24 */     return ConfigurationMgr.getAllowSameDayStoreReopen();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\BasicStoreCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */