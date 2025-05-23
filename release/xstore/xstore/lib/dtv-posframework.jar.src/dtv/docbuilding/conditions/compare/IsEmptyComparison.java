/*    */ package dtv.docbuilding.conditions.compare;
/*    */ 
/*    */ import dtv.util.ObjectUtils;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class IsEmptyComparison
/*    */   extends AbstractComparison
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(IsEmptyComparison.class);
/*    */ 
/*    */   
/*    */   protected boolean compareImpl(Object[] argOther) {
/* 27 */     Object other = argOther[0];
/*    */     
/* 29 */     if (other == null) {
/* 30 */       return true;
/*    */     }
/* 32 */     if (other instanceof Map) {
/* 33 */       return ((Map)other).isEmpty();
/*    */     }
/* 35 */     if (other instanceof Collection) {
/* 36 */       return ((Collection)other).isEmpty();
/*    */     }
/*    */     
/* 39 */     logger_.warn("Unexpected object " + ObjectUtils.getClassNameFromObject(other));
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\IsEmptyComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */