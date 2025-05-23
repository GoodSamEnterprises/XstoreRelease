/*     */ package dtv.data2.dataloader;
/*     */ 
/*     */ import dtv.data2.dataloader.fileprocessing.FileProcessingStats;
/*     */ import dtv.data2.dataloader.fileprocessing.IHasSourceData;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileResultsWriter
/*     */   implements IResultsWriter
/*     */ {
/*  31 */   private static final Logger _logger = Logger.getLogger(FileResultsWriter.class);
/*  32 */   private static final Logger _successLogger = Logger.getLogger("dtv.xstore.dataloader.SuccessFile");
/*  33 */   private static final Logger _failuresLogger = Logger.getLogger("dtv.xstore.dataloader.FailuresFile");
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */   
/*     */   private PrintWriter _summaryResults;
/*     */   private Date _runStartTime;
/*     */   
/*     */   public void create() {
/*  42 */     String argDataFilePath = this._configParameters.getDataFileLocation();
/*  43 */     File f = new File(argDataFilePath + File.separator + "summary.ini");
/*     */     
/*     */     try {
/*  46 */       this._summaryResults = new PrintWriter(new FileWriter(f, false));
/*     */     }
/*  48 */     catch (IOException ex) {
/*  49 */       _logger.error("Could not create file", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void finish(String argOptionalRunID) {
/*  56 */     this._summaryResults.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileBeingProcessed(String argFileName) {
/*  63 */     this._summaryResults.println("[" + argFileName + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start(String argOptionalRunID, Date argRunStartTime) {
/*  69 */     this._runStartTime = argRunStartTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFailure(String argMessage, IHasSourceData argFailure) {
/*  75 */     _failuresLogger.error("#" + argMessage);
/*     */     
/*  77 */     if (argFailure.getSourceData() != null) {
/*  78 */       for (String data : argFailure.getSourceData()) {
/*  79 */         _failuresLogger.error(data);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeResultsSummary(FileProcessingStats argStats) {
/*  87 */     this._summaryResults.println("rows=" + argStats.successCounter);
/*  88 */     this._summaryResults.println("failedRows=" + argStats.failureCounter);
/*  89 */     this._summaryResults.println("appliedDate=" + this._runStartTime.getTime());
/*     */     
/*  91 */     for (Map.Entry<Class<?>, Integer> entry : (Iterable<Map.Entry<Class<?>, Integer>>)argStats.exceptionCounts.entrySet()) {
/*  92 */       this._summaryResults.println("exception." + ((Class)entry.getKey()).getCanonicalName() + "=" + ((Integer)entry
/*  93 */           .getValue()).toString());
/*     */     }
/*     */     
/*  96 */     this._summaryResults.println();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeSuccess(String argMessage) {
/* 102 */     if (_successLogger.isInfoEnabled())
/* 103 */       _successLogger.info(argMessage); 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\FileResultsWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */