/*    */ package dtv.pos.iframework.ui.model;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
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
/*    */ public interface IPromptModel
/*    */   extends IUIInputModel
/*    */ {
/* 21 */   public static final EventEnum SET_VALUES = new EventEnum("setValues");
/*    */   
/*    */   IFormattable[] getPromptArgs();
/*    */   
/*    */   IPromptConfig getPromptConfig();
/*    */   
/*    */   void setPromptArgs(IFormattable[] paramArrayOfIFormattable);
/*    */   
/*    */   void setValues(IPromptConfig paramIPromptConfig);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IPromptModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */