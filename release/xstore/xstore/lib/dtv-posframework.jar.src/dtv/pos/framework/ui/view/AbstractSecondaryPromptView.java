/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstTitledInstructionPanel;
/*    */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*    */ import dtv.pos.framework.ui.config.SecondaryPromptConfig;
/*    */ import dtv.pos.framework.ui.config.SecondaryPromptConfigHelper;
/*    */ import dtv.pos.framework.ui.config.SecondaryPromptSetConfig;
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
/*    */ public abstract class AbstractSecondaryPromptView<T extends IPromptModel>
/*    */   extends AbstractPromptView<T>
/*    */ {
/* 28 */   private final XstTitledInstructionPanel _promptPanel = XstViewComponentFactory.getInstance().createSecondaryTitledInstructionPanel();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract Class<T> getModelClass();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected XstTitledInstructionPanel getPromptPanel() {
/* 41 */     return this._promptPanel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isInterested(IPromptConfig argPrompt) {
/* 52 */     String name = argPrompt.getPromptKey().toString();
/* 53 */     String location = getDisplayComponent().getName();
/* 54 */     SecondaryPromptSetConfig root = SecondaryPromptConfigHelper.getConfig();
/* 55 */     SecondaryPromptConfig config = root.getChild(name, location);
/* 56 */     return config.isEnabled();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isInterested(IPromptModel argModel) {
/* 67 */     boolean result = false;
/* 68 */     Class<T> impl = getModelClass();
/* 69 */     if (impl.isInstance(argModel)) {
/* 70 */       result = isInterested(argModel.getPromptConfig());
/*    */     }
/* 72 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\AbstractSecondaryPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */