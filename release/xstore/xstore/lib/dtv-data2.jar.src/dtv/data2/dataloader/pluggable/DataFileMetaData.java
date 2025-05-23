/*    */ package dtv.data2.dataloader.pluggable;
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
/*    */ public class DataFileMetaData<T>
/*    */ {
/*    */   private final File _file;
/*    */   private final String _type;
/*    */   private final boolean _fullReload;
/*    */   private final boolean _skipThisFile;
/*    */   private final T _cfgObject;
/*    */   private final DeploymentInfo _deploymentInfo;
/*    */   
/*    */   public DataFileMetaData(File argFile, String argType, boolean argFullReload, boolean argSkipThisFile, T argConfigObject, DeploymentInfo argDeploymentInfo) {
/* 29 */     this._file = argFile;
/* 30 */     this._type = argType;
/* 31 */     this._fullReload = argFullReload;
/* 32 */     this._skipThisFile = argSkipThisFile;
/* 33 */     this._cfgObject = argConfigObject;
/* 34 */     this._deploymentInfo = argDeploymentInfo;
/*    */   }
/*    */   
/*    */   public T getConfigObject() {
/* 38 */     return this._cfgObject;
/*    */   }
/*    */   
/*    */   public DeploymentInfo getDeploymentInfo() {
/* 42 */     return this._deploymentInfo;
/*    */   }
/*    */   
/*    */   public File getFile() {
/* 46 */     return this._file;
/*    */   }
/*    */   
/*    */   public boolean getIsFullReload() {
/* 50 */     return this._fullReload;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getSkipThisFile() {
/* 59 */     return this._skipThisFile;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 63 */     return this._type;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\DataFileMetaData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */