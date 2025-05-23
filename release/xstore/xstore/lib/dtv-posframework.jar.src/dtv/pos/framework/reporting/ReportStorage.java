/*    */ package dtv.pos.framework.reporting;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class ReportStorage
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private byte[] print_;
/*    */   
/*    */   public ReportStorage(byte[] argReport) {
/* 23 */     this.print_ = argReport;
/*    */   }
/*    */   
/*    */   public byte[] getPrint() {
/* 27 */     return this.print_;
/*    */   }
/*    */   
/*    */   public void setPrint(byte[] argPrint) {
/* 31 */     this.print_ = argPrint;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */