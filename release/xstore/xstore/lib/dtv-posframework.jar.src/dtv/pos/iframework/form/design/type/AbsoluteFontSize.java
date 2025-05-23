/*    */ package dtv.pos.iframework.form.design.type;
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
/*    */ public class AbsoluteFontSize
/*    */   extends FontSize
/*    */ {
/*    */   private final int size_;
/*    */   
/*    */   AbsoluteFontSize(int argSize) {
/* 18 */     this.size_ = argSize;
/*    */   }
/*    */   
/*    */   AbsoluteFontSize(String argSize) {
/* 22 */     this(Integer.parseInt(argSize));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getConfigValue() {
/* 27 */     return "" + this.size_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize(int argSize) {
/* 32 */     return this.size_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return this.size_ + " (absolute)";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\design\type\AbsoluteFontSize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */