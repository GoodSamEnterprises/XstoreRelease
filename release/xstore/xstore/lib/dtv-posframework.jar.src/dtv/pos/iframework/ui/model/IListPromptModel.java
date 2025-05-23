/*    */ package dtv.pos.iframework.ui.model;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*    */ import dtv.ui.model.ICombinedListModel;
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
/*    */ 
/*    */ public interface IListPromptModel<T>
/*    */   extends IPromptModel, ICombinedListModel<T>
/*    */ {
/* 27 */   public static final EventEnum VIEW_TYPE_CHANGED_CONSTRAINT = new EventEnum("ViewTypeChanged");
/*    */   
/*    */   void setValues(IPromptConfig paramIPromptConfig, Object[] paramArrayOfObject, int[] paramArrayOfint);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IListPromptModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */