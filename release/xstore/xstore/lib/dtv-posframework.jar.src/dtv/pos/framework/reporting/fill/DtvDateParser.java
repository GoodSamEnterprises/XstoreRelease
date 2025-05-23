/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.pos.iframework.type.IDtvDate;
/*    */ import dtv.pos.iframework.type.IDtvDateRange;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DtvDateParser
/*    */ {
/*    */   public static IDtvDate parseDate(String s) {
/* 17 */     if (Character.isDigit(s.charAt(0))) {
/* 18 */       return AbsoluteDtvDate.valueOf(s);
/*    */     }
/*    */     
/* 21 */     return RelativeDtvDate.forName(s);
/*    */   }
/*    */ 
/*    */   
/*    */   public static IDtvDateRange parseDateRange(String s) {
/* 26 */     if (Character.isDigit(s.charAt(0))) {
/* 27 */       return AbsoluteDtvDateRange.valueOf(s);
/*    */     }
/*    */     
/* 30 */     return RelativeDtvDateRange.forName(s);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\DtvDateParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */