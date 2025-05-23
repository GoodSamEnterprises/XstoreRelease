/*    */ package dtv.docbuilding.conditions.compare;
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
/*    */ public class FalseComparison
/*    */   extends AbstractComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOther) {
/* 21 */     Object other = argOther[0];
/*    */     
/* 23 */     if (other == null) {
/* 24 */       return true;
/*    */     }
/* 26 */     if (other instanceof Boolean) {
/* 27 */       return !((Boolean)other).booleanValue();
/*    */     }
/* 29 */     if (other instanceof String) {
/* 30 */       return !Boolean.valueOf((String)other).booleanValue();
/*    */     }
/* 32 */     if (other instanceof Number) {
/* 33 */       return (((Number)other).doubleValue() == 0.0D);
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\FalseComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */