/*    */ package dtv.pos.common;
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
/*    */ public enum RollingCloseType
/*    */ {
/* 15 */   DISABLED
/*    */   {
/*    */     public boolean enabled()
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */   },
/* 22 */   PROMPT_FOR_FLOAT
/*    */   {
/*    */     public boolean startTillCount()
/*    */     {
/* 26 */       return true;
/*    */     }
/*    */   },
/*    */   
/* 30 */   CARRY_OVER_BALANCE
/*    */   {
/*    */     public boolean carryOverBalance()
/*    */     {
/* 34 */       return true;
/*    */     }
/*    */   },
/* 37 */   FLOAT_BALANCE
/*    */   {
/*    */     public boolean carryOverBalance()
/*    */     {
/* 41 */       return true;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean pickupFloat() {
/* 47 */       return true;
/*    */     }
/*    */   },
/* 50 */   INSERT_PREDEFINED_FLOAT;
/*    */   
/*    */   public boolean carryOverBalance() {
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public boolean enabled() {
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   public boolean pickupFloat() {
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public boolean startTillCount() {
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\RollingCloseType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */