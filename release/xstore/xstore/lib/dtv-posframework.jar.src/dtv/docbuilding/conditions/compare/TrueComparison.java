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
/*    */ public class TrueComparison
/*    */   extends FalseComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOther) {
/* 20 */     return !super.compareImpl(argOther);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\TrueComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */