/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.util.DtvDate;
/*    */ import java.util.Calendar;
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
/*    */ public class GmtDateFactory
/*    */   extends DaoDateFactory
/*    */ {
/* 20 */   private static ThreadLocal<Calendar> CAL = new ThreadLocal<Calendar>()
/*    */     {
/*    */       protected Calendar initialValue()
/*    */       {
/* 24 */         return Calendar.getInstance();
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/*    */   public DtvDate newDate() {
/* 31 */     DtvDate date = new DtvDate();
/* 32 */     Calendar cal = CAL.get();
/*    */     
/* 34 */     long now = date.getTime();
/* 35 */     cal.setTimeInMillis(now);
/* 36 */     now -= cal.get(15);
/* 37 */     now -= cal.get(16);
/* 38 */     date.setTime(now);
/*    */     
/* 40 */     return date;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\GmtDateFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */