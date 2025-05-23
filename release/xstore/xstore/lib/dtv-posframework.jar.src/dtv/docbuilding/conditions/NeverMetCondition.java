/*    */ package dtv.docbuilding.conditions;
/*    */ 
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
/*    */ public class NeverMetCondition
/*    */   extends AbstractInvertableCondition
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(NeverMetCondition.class);
/*    */   
/*    */   private final Throwable cause_;
/*    */   
/*    */   public NeverMetCondition() {
/* 23 */     this(null);
/*    */   }
/*    */   
/*    */   public NeverMetCondition(Throwable argCause) {
/* 27 */     this.cause_ = argCause;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean conditionMetImpl(Object argSource) {
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, Object argValue) {
/* 37 */     logger_.warn("unexpected parameter " + argName + "=" + argValue + " in config='" + getSourceDescription() + "'");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 43 */     return "NeverMetCondition[" + this.cause_ + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\NeverMetCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */