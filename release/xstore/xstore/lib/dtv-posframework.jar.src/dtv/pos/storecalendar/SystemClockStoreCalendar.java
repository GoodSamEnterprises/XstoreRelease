/*    */ package dtv.pos.storecalendar;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SystemClockStoreCalendar
/*    */   extends AbstractStoreCalendar
/*    */ {
/*    */   public SystemClockStoreCalendar() {
/* 18 */     super(getLastDayOfWeek(Calendar.getInstance().getFirstDayOfWeek()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFirstDayOfWeek() {
/* 24 */     return super.getFirstDayOfWeek();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isBusinessDateSettable() {
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isChangeBusinessDateAllowed() {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean preferOpenOnCurrentSystemDate() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public void validateNewBusinessDate(Date businessDate, Date argCurrentBusinessDate) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\SystemClockStoreCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */