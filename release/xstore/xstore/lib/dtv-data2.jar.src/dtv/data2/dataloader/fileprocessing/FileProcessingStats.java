/*    */ package dtv.data2.dataloader.fileprocessing;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoader;
/*    */ import dtv.data2.dataloader.pluggable.DataFileException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class FileProcessingStats
/*    */ {
/* 20 */   public int successCounter = 0;
/* 21 */   public int failureCounter = 0;
/* 22 */   public Map<Class<?>, Integer> exceptionCounts = new HashMap<>();
/*    */   
/*    */   public void addPersistenceResult(DataLoader.PersistenceResult argPersistenceResult) {
/* 25 */     this.successCounter += argPersistenceResult.successfulAtomicPersists;
/*    */     
/* 27 */     for (Map.Entry<Class<?>, Integer> entry : (Iterable<Map.Entry<Class<?>, Integer>>)argPersistenceResult.exceptionCounts.entrySet()) {
/* 28 */       this.failureCounter += ((Integer)entry.getValue()).intValue();
/* 29 */       addExceptionCount(entry.getKey(), ((Integer)entry.getValue()).intValue());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void addProcessingException(DataFileException argException) {
/* 35 */     Throwable cause = (argException.getCause() != null) ? argException.getCause() : (Throwable)argException;
/* 36 */     Class<?> causeClass = cause.getClass();
/*    */     
/* 38 */     addExceptionCount(causeClass, 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void addExceptionCount(Class<?> argCauseClass, int argCount) {
/* 44 */     Integer exceptionCount = Integer.valueOf(this.exceptionCounts.containsKey(argCauseClass) ? (((Integer)this.exceptionCounts.get(argCauseClass)).intValue() + argCount) : argCount);
/*    */ 
/*    */     
/* 47 */     this.exceptionCounts.put(argCauseClass, exceptionCount);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\FileProcessingStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */