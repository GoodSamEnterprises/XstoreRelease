/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.event.Event;
/*    */ import dtv.event.EventHandler;
/*    */ import dtv.event.IEventAware;
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.constraint.NameConstraint;
/*    */ import dtv.pos.framework.ui.component.XstList;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.IModel;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.pos.iframework.ui.RendererDef;
/*    */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*    */ import dtv.pos.iframework.ui.model.IListPromptModel;
/*    */ import dtv.pos.iframework.ui.model.IPromptModel;
/*    */ import dtv.ui.model.ICombinedListModel;
/*    */ import dtv.ui.swing.DtvList;
/*    */ import javax.swing.JComponent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ListPromptView
/*    */   extends AbstractPromptView<IListPromptModel>
/*    */ {
/* 31 */   private static final IEventConstraint viewTypeChangedConstraint_ = (IEventConstraint)new NameConstraint(IListPromptModel.VIEW_TYPE_CHANGED_CONSTRAINT);
/*    */ 
/*    */   
/* 34 */   private final IEventAware viewChangeHandler_ = (IEventAware)new EventHandler()
/*    */     {
/*    */       protected void handle(Event argEvent)
/*    */       {
/* 38 */         IPromptConfig cfg = ListPromptView.this.getModel().getPromptConfig();
/*    */         
/* 40 */         ListPromptView.this.list_.setCellRendererDef(new RendererDef(cfg.getListViewRuleSet(), cfg.getListViewType()));
/* 41 */         ListPromptView.this.list_.setColumnHeaderRendererDef(new RendererDef(cfg.getListViewHeaderType()));
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/*    */   final XstList list_;
/*    */ 
/*    */   
/*    */   public ListPromptView() {
/* 51 */     IListPromptModel model = ((IModeController)this._modeProvider.get()).getStationModel().getListPromptModel();
/* 52 */     this.list_ = new XstList(DtvList.TOUCH_READY_LIST_ID, (ICombinedListModel)model);
/* 53 */     getPromptPanel().setContent((IXstViewComponent)this.list_);
/*    */     
/* 55 */     setModel(model);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JComponent getFocusComponent() {
/* 61 */     return this.list_.getFocusComponent();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IEventAware createPrimaryHandler() {
/* 67 */     return (IEventAware)new ListModelChangeHandler();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deregisterEventHandlers(IListPromptModel argModel) {
/* 73 */     this._eventManager.deregisterEventHandler(this.viewChangeHandler_, (IEventSource)argModel);
/* 74 */     super.deregisterEventHandlers(argModel);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void registerEventHandlers(IListPromptModel argModel) {
/* 80 */     super.registerEventHandlers(argModel);
/* 81 */     this._eventManager.registerEventHandler(this.viewChangeHandler_, (IEventSource)argModel, viewTypeChangedConstraint_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected class ListModelChangeHandler
/*    */     extends AbstractPromptView<IListPromptModel>.BasicModelChangeHandler
/*    */   {
/*    */     protected void doMoreGUIWork(Event argEvent) {
/* 90 */       super.doMoreGUIWork(argEvent);
/*    */       
/* 92 */       int visibleRow = Math.max(0, ListPromptView.this.getModel().getSelectionModel().getMaxSelectionIndex());
/* 93 */       ListPromptView.this.list_.getListComponent().ensureIndexIsVisible(visibleRow);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\ListPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */