/*    */ package dtv.data2.dataloader.filelocator;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileFilter;
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
/*    */ public class StatusFileFilter
/*    */   implements FileFilter
/*    */ {
/*    */   public boolean accept(File argPathname) {
/* 25 */     boolean accepted = false;
/*    */     
/* 27 */     if (argPathname.isDirectory()) {
/* 28 */       accepted = false;
/*    */     }
/* 30 */     else if (argPathname.getName().startsWith("success.dat") || argPathname
/* 31 */       .getName().startsWith("failures.dat")) {
/* 32 */       accepted = true;
/*    */     } 
/*    */     
/* 35 */     return accepted;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\StatusFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */