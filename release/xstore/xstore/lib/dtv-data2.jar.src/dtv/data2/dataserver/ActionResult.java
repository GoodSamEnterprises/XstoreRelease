/*    */ package dtv.data2.dataserver;
/*    */ 
/*    */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*    */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActionResult
/*    */ {
/*    */   private Throwable _processError;
/*    */   private boolean _successful;
/*    */   private long _processingTime;
/*    */   
/*    */   public static ActionResult makeFailure(Throwable argThrowable) {
/* 17 */     ActionResult failure = new ActionResult();
/* 18 */     failure._processError = argThrowable;
/* 19 */     failure._successful = false;
/* 20 */     return failure;
/*    */   }
/*    */   
/*    */   public static ActionResult makeSuccess() {
/* 24 */     ActionResult success = new ActionResult();
/* 25 */     success._successful = true;
/* 26 */     return success;
/*    */   }
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
/*    */   public boolean equals(Object argObj) {
/* 41 */     if (argObj == null) {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     if (argObj == this) {
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     if (!(argObj instanceof ActionResult)) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     ActionResult other = (ActionResult)argObj;
/* 54 */     return (new EqualsBuilder()).append(isSuccess(), other.isSuccess()).append(getError(), other.getError())
/* 55 */       .append(getProcessingTime(), other.getProcessingTime()).appendSuper(super.equals(other)).isEquals();
/*    */   }
/*    */   
/*    */   public Throwable getError() {
/* 59 */     return this._processError;
/*    */   }
/*    */   
/*    */   public long getProcessingTime() {
/* 63 */     return this._processingTime;
/*    */   }
/*    */   
/*    */   public Throwable getRootError() {
/* 67 */     Throwable rootError = this._processError;
/*    */     
/* 69 */     while (rootError.getCause() != null) {
/* 70 */       rootError = rootError.getCause();
/*    */     }
/*    */     
/* 73 */     return rootError;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 79 */     return (new HashCodeBuilder(17, 37)).append(isSuccess()).append(getError()).append(getProcessingTime())
/* 80 */       .appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */   
/*    */   public boolean isSuccess() {
/* 84 */     return this._successful;
/*    */   }
/*    */   
/*    */   public void setProcessingTime(long argProcessingTime) {
/* 88 */     this._processingTime = argProcessingTime;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 94 */     return (new ToStringBuilder(this)).append("successful", isSuccess()).append("error", getError())
/* 95 */       .append("processingTime", getProcessingTime()).toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\ActionResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */