/*    */ package dtv.pos.iframework.ui;
/*    */ 
/*    */ import dtv.ui.ComponentID;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IRefreshableView
/*    */   extends IXstViewComponent
/*    */ {
/*    */   ComponentID getId();
/*    */   
/*    */   void refreshView(RefreshCallback paramRefreshCallback, RefreshType paramRefreshType);
/*    */   
/*    */   public enum RefreshType
/*    */   {
/* 35 */     SUMMARY, DETAIL;
/*    */   }
/*    */   
/*    */   public static interface RefreshCallback {
/*    */     void afterRefresh(int param1Int);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IRefreshableView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */