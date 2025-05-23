/*    */ package dtv.pos.framework.ui.view;
/*    */ 
/*    */ import dtv.event.Event;
/*    */ import dtv.event.EventHandler;
/*    */ import dtv.event.EventManager;
/*    */ import dtv.event.IEventAware;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.IModel;
/*    */ import dtv.pos.iframework.IModelView;
/*    */ import dtv.pos.iframework.ui.IXstViewComponent;
/*    */ import dtv.util.temp.InjectionHammer;
/*    */ import javax.inject.Inject;
/*    */ import javax.inject.Provider;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractUIView<T extends IModel>
/*    */   implements IModelView<T>, IXstViewComponent
/*    */ {
/* 26 */   static final Logger logger_ = Logger.getLogger(AbstractUIView.class);
/*    */ 
/*    */   
/*    */   private T model_;
/*    */   
/*    */   @Inject
/*    */   protected Provider<IModeController> _modeProvider;
/*    */   
/*    */   @Inject
/*    */   protected EventManager _eventManager;
/*    */   
/*    */   @Inject
/*    */   protected LocaleManager _localeManager;
/*    */ 
/*    */   
/* 41 */   private final EventHandler modelChangeLogger_ = new EventHandler()
/*    */     {
/*    */       protected void handle(Event argEvent)
/*    */       {
/* 45 */         AbstractUIView.logger_.debug(argEvent);
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public AbstractUIView() {
/* 51 */     InjectionHammer.forceAtInjectProcessing(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T getModel() {
/* 59 */     return this.model_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setModel(T argModel) {
/* 64 */     if (this.model_ != argModel) {
/* 65 */       if (this.model_ != null) {
/* 66 */         deregisterEventHandlers(this.model_);
/*    */       }
/* 68 */       if (argModel != null) {
/* 69 */         registerEventHandlers(argModel);
/*    */       }
/*    */     } 
/* 72 */     this.model_ = argModel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deregisterEventHandlers(T argModel) {
/* 82 */     this._eventManager.deregisterEventHandler((IEventAware)this.modelChangeLogger_, (IEventSource)argModel);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void registerEventHandlers(T argModel) {
/* 92 */     this._eventManager.registerEventHandler((IEventAware)this.modelChangeLogger_, (IEventSource)argModel);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\AbstractUIView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */