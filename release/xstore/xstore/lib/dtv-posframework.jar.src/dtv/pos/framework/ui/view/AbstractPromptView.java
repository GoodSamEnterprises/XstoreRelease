/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.pos.framework.ui.component.XstTitledInstructionPanel;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.model.IPromptModel;
/*     */ import dtv.ui.UIServices;
/*     */ import javax.swing.JComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractPromptView<T extends IPromptModel>
/*     */   extends AbstractUIView<T>
/*     */ {
/*  27 */   private static final IEventConstraint SET_VALUES_CONSTRAINT = (IEventConstraint)new NameConstraint(IPromptModel.SET_VALUES);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   private final XstTitledInstructionPanel _promptPanel = XstViewComponentFactory.getInstance().createTitledInstructionPanel();
/*  36 */   private final IEventAware _primaryHandler = createPrimaryHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  42 */     return getPromptPanel().getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  48 */     return getPromptPanel().getContent();
/*     */   }
/*     */   
/*     */   protected IEventAware createPrimaryHandler() {
/*  52 */     return (IEventAware)new BasicModelChangeHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(T argModel) {
/*  58 */     this._eventManager.deregisterEventHandler(this._primaryHandler, (IEventSource)argModel);
/*  59 */     super.deregisterEventHandlers(argModel);
/*     */   }
/*     */   
/*     */   protected XstTitledInstructionPanel getPromptPanel() {
/*  63 */     return this._promptPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerEventHandlers(T argModel) {
/*  69 */     super.registerEventHandlers(argModel);
/*  70 */     this._eventManager.registerEventHandler(this._primaryHandler, (IEventSource)argModel, SET_VALUES_CONSTRAINT);
/*     */   }
/*     */   
/*     */   protected void setIcon(IPromptModel argModel) {
/*  74 */     IPromptConfig config = argModel.getPromptConfig();
/*  75 */     getPromptPanel().setIcon(config.getIconGroupConfig().getIcon());
/*     */   }
/*     */   
/*     */   protected void setInstruction(IPromptModel argModel) {
/*  79 */     IPromptConfig config = argModel.getPromptConfig();
/*  80 */     getPromptPanel().setInstruction(config.getMsgSectionConfig().getText(argModel.getPromptArgs()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setSecondaryInstruction(IPromptModel argModel) {
/*  85 */     IPromptConfig config = argModel.getPromptConfig();
/*  86 */     getPromptPanel().setSecondaryInstruction(config
/*  87 */         .getSecondaryMsgSectionConfig().getText(argModel.getPromptArgs()));
/*     */   }
/*     */   
/*     */   protected void setTitle(IPromptModel argModel) {
/*  91 */     IPromptConfig config = argModel.getPromptConfig();
/*  92 */     getPromptPanel().setTitle(config.getTitleSectionConfig().getText(argModel.getPromptArgs()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class BasicModelChangeHandler
/*     */     extends EventHandler
/*     */   {
/*     */     protected void doMoreGUIWork(Event argEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void handle(final Event argEvent) {
/* 111 */       UIServices.invoke(new Runnable()
/*     */           {
/*     */             public void run() {
/* 114 */               IPromptModel promptModel = (IPromptModel)argEvent.getSource();
/*     */               
/* 116 */               AbstractPromptView.this.setTitle(promptModel);
/* 117 */               AbstractPromptView.this.setInstruction(promptModel);
/* 118 */               AbstractPromptView.this.setSecondaryInstruction(promptModel);
/* 119 */               AbstractPromptView.this.setIcon(promptModel);
/*     */               
/* 121 */               AbstractPromptView.BasicModelChangeHandler.this.doMoreGUIWork(argEvent);
/*     */             }
/*     */           },  false, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\AbstractPromptView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */