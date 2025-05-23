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
/*    */ public class GreaterThanOrEqualComparison
/*    */   extends AbstractComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOther) {
/* 20 */     Object o1 = getComparedValue();
/* 21 */     Object o2 = argOther[0];
/*    */     
/* 23 */     if (o1 == null && o2 == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     if (o1 == null || o2 == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     return (((Comparable<Object>)o2).compareTo(o1) >= 0);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\GreaterThanOrEqualComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */