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
/*    */ public class NotNullComparison
/*    */   extends NullComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOther) {
/* 18 */     return !super.compareImpl(argOther);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\NotNullComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */