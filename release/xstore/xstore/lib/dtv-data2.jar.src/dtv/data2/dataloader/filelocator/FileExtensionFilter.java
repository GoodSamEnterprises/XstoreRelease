/*    */ package dtv.data2.dataloader.filelocator;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.apache.commons.io.filefilter.WildcardFileFilter;
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
/*    */ public class FileExtensionFilter
/*    */   extends WildcardFileFilter
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private boolean _invert = false;
/*    */   
/*    */   public FileExtensionFilter(String... argExtensions) {
/* 29 */     super(argExtensions);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean accept(File argFile) {
/* 35 */     if (argFile.isDirectory()) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     boolean accepted = super.accept(argFile);
/* 40 */     return this._invert ? (!accepted) : accepted;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean accept(File argDir, String argFileName) {
/* 46 */     if ((new File(argDir, argFileName)).isDirectory()) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     boolean accepted = super.accept(argDir, argFileName);
/* 51 */     return this._invert ? (!accepted) : accepted;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setInvert(boolean argInvert) {
/* 60 */     this._invert = argInvert;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\FileExtensionFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */