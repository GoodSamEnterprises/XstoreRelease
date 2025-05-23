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
/*    */ public class NotMatchComparison
/*    */   extends MatchComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOthers) {
/* 20 */     return !super.compareImpl(argOthers);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\NotMatchComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */