/*    */ package dtv.data2.dataloader.fileprocessing;
/*    */ 
/*    */ import dtv.data2.dataloader.pluggable.DeploymentInfo;
/*    */ import dtv.data2.dataloader.pluggable.xst.XstoreFileConfiguration;
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
/*    */ public class HeaderLine
/*    */   extends DeploymentInfo
/*    */   implements XstoreFileConfiguration
/*    */ {
/*    */   private Integer _declaredLineCount;
/*    */   
/*    */   public Integer getDeclaredLineCount() {
/* 23 */     return this._declaredLineCount;
/*    */   }
/*    */   
/*    */   public void setDeclaredLineCount(Integer argDeclaredLineCount) {
/* 27 */     this._declaredLineCount = argDeclaredLineCount;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 32 */     String ss = "HeaderLine _declaredLineCount=" + this._declaredLineCount;
/* 33 */     return ss;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\HeaderLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */