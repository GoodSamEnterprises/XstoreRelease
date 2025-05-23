/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.framework.ui.config.PromptConfig;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
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
/*    */ public abstract class AbstractPromptModel
/*    */   extends AbstractUIInputModel
/*    */   implements IPromptModel
/*    */ {
/*    */   protected IPromptConfig config_;
/*    */   protected IFormattable[] promptArgs_;
/*    */   
/*    */   public IFormattable[] getPromptArgs() {
/* 31 */     return this.promptArgs_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IPromptConfig getPromptConfig() {
/* 43 */     return this.config_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPromptArgs(IFormattable[] promptArgs) {
/* 49 */     this.promptArgs_ = promptArgs;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValues(IPromptConfig config) {
/* 55 */     setPromptConfig(config);
/* 56 */     this.events_.post(SET_VALUES);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setPromptConfig(IPromptConfig argConfig) {
/* 67 */     this.config_ = (argConfig == null) ? (IPromptConfig)new PromptConfig() : argConfig;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\AbstractPromptModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */