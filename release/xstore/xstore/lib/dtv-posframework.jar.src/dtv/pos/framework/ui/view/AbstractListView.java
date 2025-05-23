/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.pos.framework.ui.component.XstList;
/*     */ import dtv.pos.framework.ui.model.ListEditModelFactory;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.form.IListEditModel;
/*     */ import dtv.pos.iframework.type.ModelKey;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.model.IListModel;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.JComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractListView
/*     */   extends AbstractUIView<IListEditModel<Object>>
/*     */ {
/*     */   private final XstList list_;
/*     */   private IEventAware updateListener_;
/*     */   @Inject
/*     */   private ListEditModelFactory _listModelFactory;
/*     */   
/*     */   protected AbstractListView() {
/*  47 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*  49 */     IListEditModel<Object> model = this._listModelFactory.createListModel(getModelKey());
/*  50 */     this.list_ = createList((ICombinedListModel<Object>)model);
/*  51 */     setRenderer(getList(), getListView());
/*  52 */     this.updateListener_ = createUpdateEventListener();
/*  53 */     setModel(model);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  59 */     return getList().getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  65 */     return getList().getFocusComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected XstList createList(ICombinedListModel<Object> argModel) {
/*  70 */     return new XstList(DtvList.BASIC_LIST_ID, argModel);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IEventAware createUpdateEventListener() {
/*  75 */     return new UpdateListener(getList());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(IListEditModel<Object> argModel) {
/*  81 */     this._eventManager.deregisterEventHandler(this.updateListener_, getUpdateEventSource());
/*  82 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XstList getList() {
/*  87 */     return this.list_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(IListEditModel<Object> argModel) {
/* 103 */     super.registerEventHandlers(argModel);
/* 104 */     this._eventManager.registerEventHandler(this.updateListener_, getUpdateEventSource());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setRenderer(XstList argList, IViewElementType argListView) {
/* 109 */     argList.setCellRendererDef(new RendererDef(argListView));
/* 110 */     argList.setColumnHeaderRendererDef(new RendererDef(argListView));
/*     */   }
/*     */   
/*     */   protected abstract IViewElementType getListView();
/*     */   
/*     */   protected abstract ModelKey getModelKey();
/*     */   
/*     */   protected abstract IEventSource getUpdateEventSource();
/*     */   
/*     */   protected static class UpdateListener
/*     */     extends EventHandler implements IEventAware {
/*     */     public UpdateListener(XstList argList) {
/* 122 */       this.list_ = argList;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final XstList list_;
/*     */     
/*     */     protected void handle(Event argEvent) {
/* 129 */       IListModel model = this.list_.getModel().getModel();
/* 130 */       if (!model.isEmpty()) {
/* 131 */         DtvList dList = this.list_.getListComponent();
/* 132 */         dList.ensureIndexIsVisible(model.getSize() - 1);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\AbstractListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */