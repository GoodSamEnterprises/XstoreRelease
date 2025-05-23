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
/*    */ public class MatchComparison
/*    */   extends AbstractComparison
/*    */ {
/*    */   protected boolean compareImpl(Object[] argOthers) {
/* 21 */     String regex = StringUtils.nonNull(getComparedValue());
/* 22 */     String compare = StringUtils.nonNull(argOthers[0]);
/*    */     
/* 24 */     return compare.matches(regex);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\MatchComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */