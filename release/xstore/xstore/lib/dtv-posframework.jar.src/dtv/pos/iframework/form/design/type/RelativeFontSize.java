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
/*    */ public class RelativeFontSize
/*    */   extends FontSize
/*    */ {
/*    */   private final int offset_;
/*    */   
/*    */   RelativeFontSize(int argOffset) {
/* 18 */     this.offset_ = argOffset;
/*    */   }
/*    */   
/*    */   RelativeFontSize(String argOffset) {
/* 22 */     if (argOffset.charAt(0) == '+') {
/* 23 */       this.offset_ = Integer.parseInt(argOffset.substring(1));
/*    */     } else {
/*    */       
/* 26 */       this.offset_ = Integer.parseInt(argOffset);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getConfigValue() {
/* 32 */     if (this.offset_ < 0) {
/* 33 */       return "" + this.offset_;
/*    */     }
/*    */     
/* 36 */     return "+" + this.offset_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSize(int argSize) {
/* 42 */     return argSize + this.offset_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     return getConfigValue();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\design\type\RelativeFontSize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */