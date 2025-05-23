/*    */ package dtv.xst.daocommon;
/*    */ 
/*    */ import dtv.util.DateUtils;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Utils
/*    */ {
/* 15 */   private static final String[] DAY_CODES = new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getDayOfWeek(Date argDate) {
/* 24 */     String dayCode = null;
/*    */     
/* 26 */     if (argDate != null) {
/* 27 */       int dayOfWeek = DateUtils.getDayOfWeek(argDate);
/* 28 */       dayCode = DAY_CODES[dayOfWeek - 1];
/*    */     } 
/* 30 */     return dayCode;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */