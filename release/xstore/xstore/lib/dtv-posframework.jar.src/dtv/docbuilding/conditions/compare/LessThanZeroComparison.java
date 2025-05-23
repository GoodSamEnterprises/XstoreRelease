/*    */ package dtv.docbuilding.conditions.compare;
/*    */ 
/*    */ import java.math.BigDecimal;
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
/*    */ public class LessThanZeroComparison
/*    */   extends LessThanComparison
/*    */ {
/*    */   protected Object getComparedValue() {
/* 22 */     return BigDecimal.ZERO;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\LessThanZeroComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */