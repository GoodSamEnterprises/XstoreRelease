/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.framework.ui.config.PromptConfig;
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
/*    */ public class ListPromptRequest
/*    */   extends PromptRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final Object[] listItems_;
/*    */   private final int[] selectedIndices_;
/*    */   private boolean _displayFullScreen = false;
/*    */   
/*    */   public ListPromptRequest(PromptKey promptKey, IFormattable[] promptArgs, Object[] listItems, Integer[] argSelectedIndices, PromptConfig config) {
/* 32 */     super(promptKey, config, null, promptArgs);
/*    */     
/* 34 */     this.listItems_ = listItems;
/* 35 */     if (argSelectedIndices == null || argSelectedIndices.length == 0) {
/* 36 */       this.selectedIndices_ = new int[] { -1 };
/*    */     } else {
/*    */       
/* 39 */       this.selectedIndices_ = new int[argSelectedIndices.length];
/*    */       
/* 41 */       for (int i = 0; i < this.selectedIndices_.length; i++) {
/* 42 */         this.selectedIndices_[i] = argSelectedIndices[i].intValue();
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object[] getListItems() {
/* 52 */     return this.listItems_;
/*    */   }
/*    */   
/*    */   public int[] getSelectedIndices() {
/* 56 */     return this.selectedIndices_;
/*    */   }
/*    */   
/*    */   public boolean isDisplayFullScreen() {
/* 60 */     return this._displayFullScreen;
/*    */   }
/*    */   
/*    */   public void setDisplayFullScreen(boolean argDisplayFullScreen) {
/* 64 */     this._displayFullScreen = argDisplayFullScreen;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\ListPromptRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */