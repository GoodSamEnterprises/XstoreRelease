/*    */ package dtv.data2.dataloader.pluggable.xst;
/*    */ 
/*    */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*    */ import dtv.data2.dataloader.pluggable.IFileNameSortingStrategy;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XstoreFileNameSortingStrategy
/*    */   implements IFileNameSortingStrategy
/*    */ {
/*    */   @Deprecated
/*    */   public static final String REPLACE_FILE_EXTENSION = ".rep";
/*    */   public static final String REORGANIZE_FILE_EXTENSION = ".reo";
/*    */   
/*    */   public static boolean isReorganizeFile(File argFile) {
/* 36 */     String lowerCaseFile = argFile.getName().toLowerCase();
/* 37 */     return (lowerCaseFile.endsWith(".reo") || lowerCaseFile
/* 38 */       .endsWith(".rep"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(DataFileMetaData<?> arg1, DataFileMetaData<?> arg2) {
/* 48 */     if (isReorganizeFile(arg1.getFile()) && !isReorganizeFile(arg2.getFile())) {
/* 49 */       return -1;
/*    */     }
/* 51 */     if (!isReorganizeFile(arg1.getFile()) && isReorganizeFile(arg2.getFile())) {
/* 52 */       return 1;
/*    */     }
/*    */     
/* 55 */     return arg1.getFile().getName().compareTo(arg2.getFile().getName());
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\xst\XstoreFileNameSortingStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */