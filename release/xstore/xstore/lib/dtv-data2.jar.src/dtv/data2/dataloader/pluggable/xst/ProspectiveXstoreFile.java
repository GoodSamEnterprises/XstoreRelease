/*    */ package dtv.data2.dataloader.pluggable.xst;
/*    */ 
/*    */ import dtv.data2.dataloader.config.DataLoaderConfigHelper;
/*    */ import dtv.data2.dataloader.fileprocessing.DataFileHeaderProcessor;
/*    */ import dtv.data2.dataloader.fileprocessing.HeaderLine;
/*    */ import dtv.util.StringUtils;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStreamReader;
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
/*    */ public class ProspectiveXstoreFile
/*    */ {
/* 25 */   private static final Logger _logger = Logger.getLogger(ProspectiveXstoreFile.class);
/*    */   
/*    */   private String name;
/*    */   
/*    */   private HeaderLine headerLine;
/*    */   
/*    */   private String firstNonCommentLine;
/*    */   
/*    */   public ProspectiveXstoreFile(File argFile) {
/* 34 */     this.name = argFile.getName();
/* 35 */     parseFile(argFile);
/*    */   }
/*    */   
/*    */   public String getFirstNonCommentLine() {
/* 39 */     return this.firstNonCommentLine;
/*    */   }
/*    */   
/*    */   public HeaderLine getHeaderLine() {
/* 43 */     return this.headerLine;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 47 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void parseFile(File argFile) {
/* 53 */     try(FileInputStream in = new FileInputStream(argFile); 
/* 54 */         InputStreamReader r = new InputStreamReader(in, DataLoaderConfigHelper.getDataLoaderConfig().getCharacterEncoding()); 
/* 55 */         BufferedReader reader = new BufferedReader(r)) {
/*    */       
/* 57 */       boolean lookForHeaderLine = true;
/*    */       
/*    */       String line;
/* 60 */       while (reader.ready() && (line = reader.readLine()) != null) {
/*    */ 
/*    */         
/* 63 */         if (!StringUtils.isEmpty(line) && !line.trim().startsWith("#")) {
/*    */           
/* 65 */           if (lookForHeaderLine) {
/* 66 */             lookForHeaderLine = false;
/* 67 */             DataFileHeaderProcessor headerProcessor = new DataFileHeaderProcessor();
/*    */             
/* 69 */             if (headerProcessor.isHeaderLine(line)) {
/* 70 */               this.headerLine = headerProcessor.processHeader(line);
/*    */               
/*    */               continue;
/*    */             } 
/*    */           } 
/* 75 */           this.firstNonCommentLine = line;
/*    */           
/*    */           break;
/*    */         } 
/*    */       } 
/* 80 */     } catch (Exception ex) {
/* 81 */       _logger.debug("Exception while attempting to inspect file: " + argFile, ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\xst\ProspectiveXstoreFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */