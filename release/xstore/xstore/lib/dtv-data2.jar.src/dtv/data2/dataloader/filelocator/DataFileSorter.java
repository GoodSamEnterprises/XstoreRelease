/*    */ package dtv.data2.dataloader.filelocator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataFileSorter
/*    */ {
/*    */   @Deprecated
/*    */   public static final String REPLACE_FILE_EXTENSION = ".rep";
/*    */   public static final String REORGANIZE_FILE_EXTENSION = ".reo";
/*    */   
/*    */   public static boolean isReorganizeFile(File argFile) {
/* 30 */     String lowerCaseFile = argFile.getName().toLowerCase();
/* 31 */     return (lowerCaseFile.endsWith(".reo") || lowerCaseFile
/* 32 */       .endsWith(".rep"));
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\DataFileSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */