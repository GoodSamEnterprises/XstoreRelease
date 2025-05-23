/*    */ package dtv.pos.framework.process;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.Writer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StreamToFilePumper
/*    */   extends Thread
/*    */ {
/*    */   private final BufferedReader reader_;
/*    */   private final Writer writer_;
/*    */   private boolean endOfStream_ = false;
/* 20 */   private final int SLEEP_TIME = 100;
/*    */   
/*    */   private static int threadIndex_;
/*    */   
/*    */   public StreamToFilePumper(InputStream is, File argOutputFile, boolean argAppend) throws IOException {
/* 25 */     this.reader_ = new BufferedReader(new InputStreamReader(is));
/* 26 */     this.writer_ = new BufferedWriter(new FileWriter(argOutputFile, argAppend));
/* 27 */     setName("StreamToFilePumper-" + ++threadIndex_);
/* 28 */     setDaemon(true);
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     try {
/*    */       while (true) {
/*    */         try {
/* 35 */           if (!this.endOfStream_) {
/* 36 */             pumpStream();
/* 37 */             sleep(100L);
/*    */             continue;
/*    */           } 
/* 40 */         } catch (InterruptedException interruptedException) {}
/*    */         break;
/*    */       } 
/* 43 */       this.reader_.close();
/* 44 */       this.writer_.close();
/*    */     }
/* 46 */     catch (IOException iOException) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void pumpStream() throws IOException {
/* 53 */     if (!this.endOfStream_) {
/* 54 */       String line = this.reader_.readLine();
/*    */       
/* 56 */       if (line != null) {
/* 57 */         this.writer_.write(line);
/*    */       } else {
/*    */         
/* 60 */         this.endOfStream_ = true;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\process\StreamToFilePumper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */