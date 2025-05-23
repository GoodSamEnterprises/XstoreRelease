/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.framework.ui.component.XstList;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.ui.swing.DtvList;
/*    */ import dtv.ui.touch.ISwipable;
/*    */ import dtv.ui.touch.ITouchReady;
/*    */ import dtv.ui.touch.SwipableDecorator;
/*    */ import javax.swing.JPanel;
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
/*    */ public class FormListOneTouch<T extends IFormModel>
/*    */   extends ScrollEventFormList<T>
/*    */ {
/*    */   protected JPanel createContainerPanel() {
/* 27 */     return new ContainerPanel();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected XstList createListComponent() {
/* 33 */     return new XstList(DtvList.ONE_TOUCH_LIST_ID);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class ContainerPanel
/*    */     extends JPanel
/*    */     implements ITouchReady
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 49 */     private ISwipable swipable_ = SwipableDecorator.makeSwipable(this); public ContainerPanel() {
/* 50 */       if (isSwipeEnabled()) {
/* 51 */         this.swipable_.register();
/*    */       }
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public ISwipable getSwipable() {
/* 58 */       return this.swipable_;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean isSwipeEnabled() {
/* 64 */       return true;
/*    */     }
/*    */     
/*    */     public void setSwipeEnabled(boolean argIsSwipeEnabled) {}
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormListOneTouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */