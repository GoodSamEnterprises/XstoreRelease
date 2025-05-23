/*    */ package dtv.pos.framework.worker;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.OutputContextType;
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
/*    */ public class WorkFailedException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final IFormattable message_;
/*    */   
/*    */   public WorkFailedException() {
/* 27 */     this(null, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WorkFailedException(IFormattable argMessage) {
/* 36 */     this(argMessage, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WorkFailedException(IFormattable argMessage, Throwable argCause) {
/* 47 */     super(argCause);
/* 48 */     this.message_ = (argMessage == null) ? IFormattable.EMPTY : argMessage;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WorkFailedException(Throwable argCause) {
/* 57 */     this(null, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 65 */     return getMessage(OutputContextType.DEFAULT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage(OutputContextType argContext) {
/* 75 */     return this.message_.toString(argContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IFormattable getMessageFormattable() {
/* 83 */     return this.message_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 89 */     return super.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\WorkFailedException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */