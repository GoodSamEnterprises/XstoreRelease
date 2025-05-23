/*    */ package dtv.xst.daocommon;
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
/*    */ 
/*    */ 
/*    */ public class LocaleInfo
/*    */ {
/* 21 */   private static int currencyFractionDigits_ = Integer.MIN_VALUE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int currencyFractionDigits() {
/* 29 */     return currencyFractionDigits_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setCurrencyFractionDigits(int argFractionDigits) {
/* 38 */     if (currencyFractionDigits_ != Integer.MIN_VALUE) {
/* 39 */       throw new RuntimeException("Attempting to set local currency fraction digits twice!");
/*    */     }
/*    */     
/* 42 */     currencyFractionDigits_ = argFractionDigits;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\LocaleInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */