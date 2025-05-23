/*    */ package dtv.data2.dataloader;
/*    */ 
/*    */ import java.io.File;
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
/*    */ 
/*    */ public class NoOpArchiver
/*    */   implements IFileArchiver
/*    */ {
/*    */   public void archiveDataFile(File argFile, String argNewFileName) {}
/*    */   
/*    */   public boolean archiveStatusFiles() {
/* 26 */     return false;
/*    */   }
/*    */   
/*    */   public void archiveSummaryFile() {}
/*    */   
/*    */   public void cleanUpArchives() {}
/*    */   
/*    */   public void cleanUpStatusFiles() {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\NoOpArchiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */