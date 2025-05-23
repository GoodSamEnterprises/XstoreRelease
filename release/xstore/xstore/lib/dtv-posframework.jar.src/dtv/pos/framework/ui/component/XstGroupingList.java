/*    */ package dtv.pos.framework.ui.component;
/*    */ 
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.ui.ComponentID;
/*    */ import dtv.ui.model.IGroupingListModel;
/*    */ import dtv.ui.swing.lists.grouping.DtvGroupingList;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.SwingUtilities;
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
/*    */ public class XstGroupingList
/*    */   implements IXstViewComponent
/*    */ {
/*    */   private DtvGroupingList list_;
/*    */   private IGroupingListModel model_;
/*    */   
/*    */   public XstGroupingList() {
/* 33 */     this(DtvGroupingList.DEFAULT);
/*    */   }
/*    */   
/*    */   public XstGroupingList(ComponentID argId) {
/* 37 */     this.list_ = new DtvGroupingList(argId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getDisplayComponent() {
/* 43 */     return (JComponent)getGroupingList();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 49 */     return (JComponent)getGroupingList();
/*    */   }
/*    */   
/*    */   public DtvGroupingList getGroupingList() {
/* 53 */     return this.list_;
/*    */   }
/*    */   
/*    */   public IGroupingListModel getModel() {
/* 57 */     return this.model_;
/*    */   }
/*    */   
/*    */   public void setModel(IGroupingListModel argModel) {
/* 61 */     this.model_ = argModel;
/*    */     
/* 63 */     if (SwingUtilities.isEventDispatchThread()) {
/* 64 */       (new UpdateThread(this.list_, argModel)).start();
/*    */     } else {
/*    */       
/* 67 */       this.list_.updateListFromModel(argModel);
/*    */     } 
/*    */   }
/*    */   
/*    */   private class UpdateThread
/*    */     extends Thread
/*    */   {
/*    */     private final IGroupingListModel m;
/*    */     private final DtvGroupingList l;
/*    */     
/*    */     public UpdateThread(DtvGroupingList argList, IGroupingListModel argModel) {
/* 78 */       this.m = argModel;
/* 79 */       this.l = argList;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void run() {
/* 85 */       this.l.updateListFromModel(this.m);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstGroupingList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */