/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import dtv.event.Eventor;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ import dtv.pos.framework.ui.UIModelChangeType;
/*    */ import dtv.pos.iframework.ui.model.IUIModel;
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
/*    */ public abstract class AbstractUIModel
/*    */   implements IUIModel, IEventSource
/*    */ {
/* 22 */   protected transient Eventor events_ = (Eventor)new DefaultEventor(this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void clearModel() {
/* 33 */     clearModelImpl();
/* 34 */     this.events_.post(UIModelChangeType.CLEARED);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void clearView() {
/* 44 */     clearViewImpl();
/* 45 */     this.events_.post(UIModelChangeType.HIDE);
/*    */   }
/*    */   
/*    */   protected void clearModelImpl() {}
/*    */   
/*    */   protected void clearViewImpl() {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\AbstractUIModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */