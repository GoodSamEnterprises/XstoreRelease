/*    */ package dtv.pos.iframework.ui.config;
/*    */ 
/*    */ import dtv.util.config.ICascadableConfig;
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
/*    */ public interface IDataSelectionConfig
/*    */   extends ICascadableConfig, IUIConfig
/*    */ {
/*    */   SelectionMode getSelectionMode();
/*    */   
/*    */   boolean isMultipleSelect();
/*    */   
/*    */   void setMultipleSelect(Boolean paramBoolean);
/*    */   
/*    */   void setSelectionMode(SelectionMode paramSelectionMode);
/*    */   
/*    */   public enum SelectionMode
/*    */   {
/* 31 */     SINGLE, MULTIPLE, UNSELECTABLE;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IDataSelectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */