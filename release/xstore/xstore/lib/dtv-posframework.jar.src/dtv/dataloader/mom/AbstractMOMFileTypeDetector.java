/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*    */ import dtv.data2.dataloader.pluggable.DeploymentInfo;
/*    */ import dtv.data2.dataloader.pluggable.IDataFileTypeDetector;
/*    */ import dtv.data2.dataloader.pluggable.xst.ProspectiveXstoreFile;
/*    */ import dtv.util.StringUtils;
/*    */ import java.io.File;
/*    */ import java.util.Date;
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
/*    */ public abstract class AbstractMOMFileTypeDetector
/*    */   implements IDataFileTypeDetector
/*    */ {
/*    */   public static final String MOM_CORP_TARGET = "___MOM_CORP___";
/*    */   public static final String MOM_CHAINWIDE_TARGET = "*:*";
/*    */   
/*    */   public DataFileMetaData<MOMFileConfiguration> detect(File argDataFile) {
/* 30 */     String detectedFileTypeKey = detectMOMFileType(argDataFile);
/*    */ 
/*    */     
/* 33 */     if (detectedFileTypeKey == null) {
/* 34 */       return null;
/*    */     }
/*    */     
/* 37 */     MOMFileConfiguration config = new MOMFileConfiguration();
/* 38 */     config.setNumberOfLines(detectNumberOfLines(detectedFileTypeKey, argDataFile));
/* 39 */     config.setTimestamp(detectTimestamp(detectedFileTypeKey, argDataFile));
/* 40 */     String storeId = detectStoreId(detectedFileTypeKey, argDataFile);
/* 41 */     config.setStoreId(storeId);
/*    */     
/* 43 */     DeploymentInfo deploymentInfo = new DeploymentInfo();
/* 44 */     if (!StringUtils.isEmpty(storeId)) {
/* 45 */       if ("CORP".equalsIgnoreCase(storeId)) {
/* 46 */         deploymentInfo.setTargetOrgNode("___MOM_CORP___");
/*    */       } else {
/*    */         
/* 49 */         deploymentInfo.setTargetOrgNode("STORE:" + storeId);
/*    */       } 
/*    */     } else {
/*    */       
/* 53 */       deploymentInfo.setTargetOrgNode("*:*");
/*    */     } 
/*    */     
/* 56 */     ProspectiveXstoreFile pxf = new ProspectiveXstoreFile(argDataFile);
/*    */     
/* 58 */     if (pxf.getHeaderLine() != null) {
/* 59 */       deploymentInfo.setDownloadTime(pxf.getHeaderLine().getDownloadTime());
/* 60 */       deploymentInfo.setApplyImmediately(pxf.getHeaderLine().getApplyImmediately());
/*    */     } 
/*    */     
/* 63 */     boolean fullReload = shouldTruncateBeforeLoading(detectedFileTypeKey, argDataFile);
/*    */     
/* 65 */     DataFileMetaData<MOMFileConfiguration> metaData = new DataFileMetaData(argDataFile, detectedFileTypeKey, fullReload, false, config, deploymentInfo);
/*    */ 
/*    */     
/* 68 */     return metaData;
/*    */   }
/*    */   
/*    */   protected abstract String detectMOMFileType(File paramFile);
/*    */   
/*    */   protected abstract Integer detectNumberOfLines(String paramString, File paramFile);
/*    */   
/*    */   protected abstract String detectStoreId(String paramString, File paramFile);
/*    */   
/*    */   protected abstract Date detectTimestamp(String paramString, File paramFile);
/*    */   
/*    */   protected abstract boolean shouldTruncateBeforeLoading(String paramString, File paramFile);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\AbstractMOMFileTypeDetector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */