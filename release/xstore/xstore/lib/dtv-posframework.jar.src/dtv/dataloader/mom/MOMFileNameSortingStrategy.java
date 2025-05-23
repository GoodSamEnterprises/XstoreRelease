/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*    */ import dtv.data2.dataloader.pluggable.IFileNameSortingStrategy;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Required;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MOMFileNameSortingStrategy
/*    */   implements IFileNameSortingStrategy
/*    */ {
/*    */   public List<String> _fileTypes;
/*    */   
/*    */   public int compare(DataFileMetaData<?> arg1, DataFileMetaData<?> arg2) {
/* 32 */     int retValue = 0;
/*    */     
/* 34 */     if (indexOf(arg1.getType()) == indexOf(arg2.getType())) {
/*    */       
/* 36 */       MOMFileConfiguration config1 = (MOMFileConfiguration)arg1.getConfigObject();
/* 37 */       MOMFileConfiguration config2 = (MOMFileConfiguration)arg2.getConfigObject();
/* 38 */       retValue = config1.getTimestamp().compareTo(config2.getTimestamp());
/*    */     }
/*    */     else {
/*    */       
/* 42 */       retValue = (indexOf(arg1.getType()) < indexOf(arg2.getType())) ? -1 : 1;
/*    */     } 
/* 44 */     return retValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int indexOf(String argFileType) {
/* 53 */     return this._fileTypes.indexOf(argFileType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Required
/*    */   public void setFileTypes(List<String> argFileTypes) {
/* 62 */     this._fileTypes = argFileTypes;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMFileNameSortingStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */