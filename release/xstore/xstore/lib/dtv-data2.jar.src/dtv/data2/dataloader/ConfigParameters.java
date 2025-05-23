/*    */ package dtv.data2.dataloader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigParameters
/*    */ {
/*    */   private String _dataFilePath;
/*    */   private String _dataSource;
/*    */   private int _recordsPerTransaction;
/*    */   private int _archiveDays;
/*    */   private String _archivePath;
/*    */   private boolean _processListFiles;
/*    */   private Long _organizationId;
/*    */   
/*    */   public int getArchiveDays() {
/* 22 */     return this._archiveDays;
/*    */   }
/*    */   
/*    */   public String getArchivePath() {
/* 26 */     return this._archivePath;
/*    */   }
/*    */   
/*    */   public String getDataFileLocation() {
/* 30 */     return this._dataFilePath;
/*    */   }
/*    */   
/*    */   public String getDataSource() {
/* 34 */     return this._dataSource;
/*    */   }
/*    */   
/*    */   public Long getOrganizationId() {
/* 38 */     return this._organizationId;
/*    */   }
/*    */   
/*    */   public boolean getProcessListFiles() {
/* 42 */     return this._processListFiles;
/*    */   }
/*    */   
/*    */   public int getRecordsPerTransaction() {
/* 46 */     return this._recordsPerTransaction;
/*    */   }
/*    */   
/*    */   public void setArchiveDays(int argArchiveDays) {
/* 50 */     this._archiveDays = argArchiveDays;
/*    */   }
/*    */   
/*    */   public void setArchivePath(String argArchivePath) {
/* 54 */     this._archivePath = argArchivePath;
/*    */   }
/*    */   
/*    */   public void setDataFileLocation(String argDataFilePath) {
/* 58 */     this._dataFilePath = argDataFilePath;
/*    */   }
/*    */   
/*    */   public void setDataSource(String argDataSource) {
/* 62 */     this._dataSource = argDataSource;
/*    */   }
/*    */   
/*    */   public void setOrganizationId(Long argOrganizationId) {
/* 66 */     this._organizationId = argOrganizationId;
/*    */   }
/*    */   
/*    */   public void setProcessListFiles(boolean argProcessListFiles) {
/* 70 */     this._processListFiles = argProcessListFiles;
/*    */   }
/*    */   
/*    */   public void setRecordsPerTransaction(int argRecordsPerTransaction) {
/* 74 */     this._recordsPerTransaction = argRecordsPerTransaction;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\ConfigParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */