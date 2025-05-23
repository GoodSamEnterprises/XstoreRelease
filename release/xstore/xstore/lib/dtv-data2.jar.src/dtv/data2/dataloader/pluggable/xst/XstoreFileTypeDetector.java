/*    */ package dtv.data2.dataloader.pluggable.xst;
/*    */ 
/*    */ import dtv.data2.dataloader.fileprocessing.HeaderLine;
/*    */ import dtv.data2.dataloader.fileprocessing.ParsingUtils;
/*    */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*    */ import dtv.data2.dataloader.pluggable.DeploymentInfo;
/*    */ import dtv.data2.dataloader.pluggable.IDataFileTypeDetector;
/*    */ import dtv.data2.dataloader.pluggable.IFileNameSortingStrategy;
/*    */ import java.io.File;
/*    */ import javax.annotation.Resource;
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
/*    */ public class XstoreFileTypeDetector
/*    */   implements IDataFileTypeDetector
/*    */ {
/*    */   @Resource(name = "xstoreFileNameSortingStrategy")
/*    */   private IFileNameSortingStrategy _fileNameSortingStrategy;
/*    */   
/*    */   public DataFileMetaData<XstoreFileConfiguration> detect(File argDataFile) {
/* 30 */     ProspectiveXstoreFile prospectiveFile = new ProspectiveXstoreFile(argDataFile);
/* 31 */     XstoreFileType detectedType = detectXstoreFileType(prospectiveFile);
/*    */ 
/*    */     
/* 34 */     if (detectedType == null) {
/* 35 */       return null;
/*    */     }
/*    */     
/* 38 */     boolean preTruncate = shouldTruncateBeforeLoading(argDataFile);
/*    */     
/* 40 */     HeaderLine headerLine = prospectiveFile.getHeaderLine();
/* 41 */     boolean shouldSkip = (headerLine != null) ? headerLine.isFutureApplicationDate() : false;
/*    */ 
/*    */     
/* 44 */     DataFileMetaData<XstoreFileConfiguration> metaData = new DataFileMetaData(argDataFile, detectedType.name(), preTruncate, shouldSkip, headerLine, (DeploymentInfo)headerLine);
/*    */ 
/*    */     
/* 47 */     return metaData;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IFileNameSortingStrategy getFileNameSortingStrategy() {
/* 55 */     return this._fileNameSortingStrategy;
/*    */   }
/*    */   
/*    */   private XstoreFileType detectXstoreFileType(ProspectiveXstoreFile argFile) {
/* 59 */     String name = argFile.getName().toLowerCase();
/*    */ 
/*    */     
/* 62 */     if (name.endsWith(".rep") || name.endsWith(".reo") || argFile.getHeaderLine() != null) {
/* 63 */       return XstoreFileType.XSTORE_MNT;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 68 */       ParsingUtils.getInstance().parseInstruction(argFile.getFirstNonCommentLine());
/* 69 */       return XstoreFileType.XSTORE_MNT;
/*    */     }
/* 71 */     catch (Exception ex) {
/* 72 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean shouldTruncateBeforeLoading(File argDataFile) {
/* 77 */     String fileName = argDataFile.getName().toLowerCase();
/* 78 */     if (fileName.endsWith(".rep") || fileName.endsWith(".reo")) {
/* 79 */       return true;
/*    */     }
/*    */     
/* 82 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private enum XstoreFileType
/*    */   {
/* 91 */     XSTORE_MNT;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\xst\XstoreFileTypeDetector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */