/*    */ package dtv.docbuilding.conditions.compare;
/*    */ 
/*    */ import dtv.util.StringUtils;
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
/*    */ public class EqualComparison
/*    */   extends AbstractComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOther) {
/*    */     Object o1;
/*    */     Object o2;
/* 26 */     if (argOther.length == 1) {
/* 27 */       o1 = getComparedValue();
/* 28 */       o2 = argOther[0];
/*    */     } else {
/*    */       
/* 31 */       o1 = argOther[0];
/* 32 */       o2 = argOther[1];
/*    */     } 
/*    */     
/* 35 */     if (o1 instanceof String && !(o2 instanceof String)) {
/* 36 */       o2 = StringUtils.nonNull(o2);
/*    */     }
/* 38 */     else if (!(o1 instanceof String) && o2 instanceof String) {
/* 39 */       o1 = StringUtils.nonNull(o1);
/*    */     } 
/*    */     
/* 42 */     if (o1 == null && o2 == null) {
/* 43 */       return true;
/*    */     }
/* 45 */     if (o1 == null || o2 == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     if (o1 instanceof Comparable) {
/* 49 */       return (((Comparable<Object>)o1).compareTo(o2) == 0);
/*    */     }
/* 51 */     if (o2 instanceof Comparable) {
/* 52 */       return (((Comparable<Object>)o2).compareTo(o1) == 0);
/*    */     }
/*    */     
/* 55 */     return o2.equals(o1);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\EqualComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */