/*     */ package dtv.dataloader;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.dataloader.ConfigParameters;
/*     */ import dtv.data2.dataloader.IResultsWriter;
/*     */ import dtv.data2.dataloader.fileprocessing.FileProcessingStats;
/*     */ import dtv.data2.dataloader.fileprocessing.IHasSourceData;
/*     */ import dtv.xst.dao.ctl.IDataLoaderFailure;
/*     */ import dtv.xst.dao.ctl.IDataLoaderSummary;
/*     */ import java.util.Date;
/*     */ import javax.inject.Inject;
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
/*     */ 
/*     */ 
/*     */ public class DatabaseResultsWriter
/*     */   implements IResultsWriter
/*     */ {
/*     */   private String _currentFile;
/*     */   private Date _runStartTime;
/*  34 */   private int _fileErrorCount = 0;
/*     */ 
/*     */   
/*     */   private IDataLoaderSummary _currentSummary;
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */ 
/*     */   
/*     */   public void finish(String argOptionalRunID) {}
/*     */ 
/*     */   
/*     */   public void setFileBeingProcessed(String argFileName) {
/*  47 */     this._currentFile = argFileName;
/*     */     
/*  49 */     this._fileErrorCount = 0;
/*     */ 
/*     */ 
/*     */     
/*  53 */     this._currentSummary = (IDataLoaderSummary)DataFactory.createObject(IDataLoaderSummary.class);
/*  54 */     this._currentSummary.setOrganizationId(this._configParameters.getOrganizationId().longValue());
/*  55 */     this._currentSummary.setFileName(argFileName);
/*  56 */     this._currentSummary.setRunTime(this._runStartTime.getTime());
/*  57 */     DataFactory.makePersistent(this._currentSummary);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start(String argOptionalRunID, Date argRunStartTime) {
/*  63 */     this._runStartTime = argRunStartTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFailure(String argMessage, IHasSourceData argFailure) {
/*  69 */     this._fileErrorCount++;
/*     */     
/*  71 */     IDataLoaderFailure failure = (IDataLoaderFailure)DataFactory.createObject(IDataLoaderFailure.class);
/*  72 */     failure.setOrganizationId(this._configParameters.getOrganizationId().longValue());
/*  73 */     failure.setFileName(this._currentFile);
/*  74 */     failure.setRunTime(this._runStartTime.getTime());
/*  75 */     failure.setFailureSequence(this._fileErrorCount);
/*  76 */     failure.setFailureMessage(argMessage);
/*     */     
/*  78 */     if (argFailure.getSourceData() != null) {
/*  79 */       StringBuilder failedData = new StringBuilder();
/*     */       
/*  81 */       for (String data : argFailure.getSourceData()) {
/*  82 */         failedData.append(data);
/*     */         
/*  84 */         failedData.append("\n");
/*     */       } 
/*     */       
/*  87 */       failure.setFailedData(failedData.toString());
/*     */     } 
/*     */     
/*  90 */     DataFactory.makePersistent(failure);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeResultsSummary(FileProcessingStats argStats) {
/*  97 */     boolean success = (argStats.successCounter > 0 && argStats.failureCounter == 0);
/*  98 */     this._currentSummary.setSuccess(success);
/*  99 */     this._currentSummary.setSuccessfulRows(argStats.successCounter);
/* 100 */     this._currentSummary.setFailedRows(argStats.failureCounter);
/*     */     
/* 102 */     DataFactory.makePersistent(this._currentSummary);
/*     */   }
/*     */   
/*     */   public void writeSuccess(String argMessage) {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\DatabaseResultsWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */