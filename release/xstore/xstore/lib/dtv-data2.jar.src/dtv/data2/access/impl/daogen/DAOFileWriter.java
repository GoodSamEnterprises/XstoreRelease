/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ import java.util.concurrent.BlockingQueue;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.Future;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DAOFileWriter
/*    */ {
/* 20 */   private final ExecutorService _executor = Executors.newFixedThreadPool(Runtime.getRuntime()
/* 21 */       .availableProcessors());
/* 22 */   private final BlockingQueue<Future<Void>> writeTasks = new LinkedBlockingQueue<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected synchronized void close() {
/*    */     try {
/* 30 */       flush();
/*    */     } finally {
/*    */       
/* 33 */       this._executor.shutdown();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected synchronized void flush() {
/*    */     try {
/* 42 */       Future<Void> nextRecord = null;
/* 43 */       while ((nextRecord = this.writeTasks.poll()) != null) {
/* 44 */         nextRecord.get();
/*    */       }
/*    */     }
/* 47 */     catch (Throwable t) {
/* 48 */       throw new RuntimeException(t);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected synchronized void write(File argFile, String argText) {
/* 59 */     this.writeTasks.add(this._executor.submit(new FileWriter(argFile, argText)));
/*    */   }
/*    */   
/*    */   private class FileWriter
/*    */     implements Callable<Void> {
/*    */     private final File _writeFile;
/*    */     private final String _writeContents;
/*    */     
/*    */     private FileWriter(File argFile, String argContents) {
/* 68 */       this._writeFile = argFile;
/* 69 */       this._writeContents = argContents;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Void call() throws Exception {
/* 76 */       byte[] fileBytes = this._writeContents.getBytes(StandardCharsets.UTF_8);
/* 77 */       if (!this._writeFile.getParentFile().exists()) {
/* 78 */         this._writeFile.getParentFile().mkdirs();
/*    */       }
/* 80 */       Files.write(this._writeFile.toPath(), fileBytes, new java.nio.file.OpenOption[0]);
/* 81 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DAOFileWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */