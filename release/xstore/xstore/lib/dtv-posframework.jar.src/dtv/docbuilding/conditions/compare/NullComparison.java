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
/*    */ public class NullComparison
/*    */   extends AbstractComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOther) {
/* 18 */     return (argOther[0] == null);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\NullComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */