/*    */ package dtv.docbuilding.conditions.compare;
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
/*    */ public abstract class AbstractComparison
/*    */   implements IComparison
/*    */ {
/* 17 */   private static final Logger logger_ = Logger.getLogger(AbstractComparison.class);
/*    */   
/*    */   private Object compareTo_;
/*    */   
/*    */   private String sourceDescription_;
/*    */ 
/*    */   
/*    */   public final boolean compare(Object[] argOthers) {
/* 25 */     if (!validate(argOthers)) {
/* 26 */       logger_.warn("Misconfigured comparison @@ " + getSourceDescription());
/* 27 */       return false;
/*    */     } 
/* 29 */     return compareImpl(argOthers);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSourceDescription() {
/* 34 */     return this.sourceDescription_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, Object argValue) {
/* 39 */     if ("value".equalsIgnoreCase(argName) || "compareTo".equalsIgnoreCase(argName)) {
/* 40 */       this.compareTo_ = argValue;
/*    */     } else {
/*    */       
/* 43 */       logger_.warn("Condition [" + getClass().getName() + "] does not support paramter named [" + argName + "] of type [" + ((argValue == null) ? null : argValue
/* 44 */           .getClass().getName()) + "]");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void setSourceDescription(String argValue) {
/* 50 */     this.sourceDescription_ = argValue;
/*    */   }
/*    */   
/*    */   protected abstract boolean compareImpl(Object[] paramArrayOfObject);
/*    */   
/*    */   protected Object getComparedValue() {
/* 56 */     return this.compareTo_;
/*    */   }
/*    */   
/*    */   protected boolean validate(Object[] argOthers) {
/* 60 */     return (argOthers != null && argOthers.length > 0);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\compare\AbstractComparison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */