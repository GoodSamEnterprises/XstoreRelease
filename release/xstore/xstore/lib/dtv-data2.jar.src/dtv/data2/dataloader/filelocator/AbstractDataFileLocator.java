/*    */ package dtv.data2.dataloader.filelocator;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoaderEventLogger;
/*    */ import java.io.File;
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
/*    */ 
/*    */ public abstract class AbstractDataFileLocator
/*    */   implements IDataFileLocator
/*    */ {
/* 21 */   private static final Logger logger_ = Logger.getLogger(AbstractDataFileLocator.class);
/*    */   
/*    */   private File dataFile_;
/*    */   
/*    */   private String _dataFilePath;
/*    */   
/*    */   public AbstractDataFileLocator(String argDataFilePath) {
/* 28 */     this._dataFilePath = argDataFilePath;
/*    */   }
/*    */   
/*    */   protected File getConfiguredDataFile() {
/* 32 */     if (this.dataFile_ != null) {
/* 33 */       return this.dataFile_;
/*    */     }
/*    */     try {
/* 36 */       this.dataFile_ = new File(getDataFilePath());
/*    */     }
/* 38 */     catch (Exception ex) {
/* 39 */       String msg = "Data file path is not properly configured for DataLoader. Dataloader will exit without loading data.";
/*    */       
/* 41 */       logger_.warn(msg, ex);
/* 42 */       DataLoaderEventLogger.warn(msg, ex);
/*    */     } 
/*    */     
/* 45 */     return this.dataFile_;
/*    */   }
/*    */   
/*    */   protected String getDataFilePath() {
/* 49 */     return this._dataFilePath;
/*    */   }
/*    */   
/*    */   protected boolean isValidDataFile(File argFile) {
/* 53 */     if (argFile == null || !argFile.exists() || argFile.isDirectory()) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\AbstractDataFileLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */