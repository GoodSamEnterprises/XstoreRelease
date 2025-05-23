/*     */ package dtv.pos.framework.event;
/*     */ 
/*     */ import dtv.pos.iframework.action.ITriggeredAction;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.event.IXstEventRouter;
/*     */ import dtv.pos.iframework.xstorem.ICheetahXstoreBridge;
/*     */ import dtv.pos.ui.UIResponsivenessMgr;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class ConfigurableEventHandler
/*     */   implements IXstEventListener, IContextChangeListener
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(ConfigurableEventHandler.class);
/*     */   
/*  32 */   private EventActionMapConfig currentMap_ = null;
/*     */   
/*     */   private IXstEventRouter _mappedEventRouter;
/*     */   
/*     */   @Inject
/*     */   private EventConfigHelper _ecHelper;
/*     */   
/*     */   @Inject
/*     */   private UIResponsivenessMgr _uiResponsivenessMgr;
/*     */   
/*     */   @Inject
/*     */   private ICheetahXstoreBridge _cheetahBridge;
/*     */   
/*     */   public void handleContextChange(ContextChangeEvent argEvent) {
/*  46 */     EventActionMapConfig eventActionCfg = null;
/*     */     
/*  48 */     if (this._ecHelper != null && this._ecHelper.getMappings() != null) {
/*  49 */       String newContextName = (argEvent.getNewContext() != null) ? argEvent.getNewContext().getName() : null;
/*  50 */       eventActionCfg = this._ecHelper.getMappings().get(newContextName);
/*     */       
/*  52 */       if (eventActionCfg == null) {
/*  53 */         eventActionCfg = this._ecHelper.getDefaultActionMapping();
/*     */       }
/*     */     } 
/*     */     
/*  57 */     this.currentMap_ = eventActionCfg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleXstEvent(IXstEvent argEvent) {
/*  67 */     if (logger_.isInfoEnabled()) {
/*  68 */       logger_.info("Mapping the event to a command for event " + argEvent);
/*     */     }
/*     */     
/*  71 */     if (argEvent == null) {
/*  72 */       logger_.warn("unable to map null event");
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     IXstAction action = null;
/*     */     
/*  78 */     if (this.currentMap_ != null) {
/*  79 */       action = this.currentMap_.getAction(argEvent);
/*  80 */       if (logger_.isInfoEnabled()) {
/*  81 */         logger_.info("Mapped to action " + action);
/*     */       }
/*     */     } 
/*     */     
/*  85 */     if (action == null) {
/*     */       
/*  87 */       if (argEvent instanceof dtv.hardware.events.IHardwareInputEvent) {
/*  88 */         this._uiResponsivenessMgr.setResponsive(true);
/*     */ 
/*     */         
/*  91 */         this._cheetahBridge.undoReset();
/*  92 */         this._cheetahBridge.notifyRequestReady(null);
/*     */       } 
/*     */     } else {
/*     */       
/*  96 */       action.evaluateVisibility();
/*     */       
/*  98 */       if (!action.isEnabled()) {
/*  99 */         if (argEvent instanceof dtv.hardware.events.IHardwareInputEvent) {
/* 100 */           this._uiResponsivenessMgr.setResponsive(true);
/*     */ 
/*     */           
/* 103 */           this._cheetahBridge.undoReset();
/* 104 */           this._cheetahBridge.notifyRequestReady(null);
/*     */         } 
/*     */       } else {
/*     */         
/* 108 */         if (action instanceof ITriggeredAction) {
/* 109 */           ((ITriggeredAction)action).setTrigger(argEvent);
/*     */         }
/*     */         
/* 112 */         this._mappedEventRouter.fireEvent((IXstEvent)action);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMappedEventRouter(IXstEventRouter argEventRouter) {
/* 119 */     this._mappedEventRouter = argEventRouter;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\ConfigurableEventHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */