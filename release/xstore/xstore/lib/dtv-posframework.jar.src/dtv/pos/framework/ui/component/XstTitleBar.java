/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.framework.ui.context.UIContext;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.assistance.ITrainingModeHelper;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosTitleBar;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.ui.context.ContextManager;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.util.MutableString;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.Timer;
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
/*     */ public class XstTitleBar
/*     */   implements IXstViewComponent, IContextChangeListener
/*     */ {
/*     */   final PosTitleBar titleBar_;
/*     */   final MutableString trainingText_;
/*     */   private final Timer trainingTimer_;
/*     */   MutableString currentText2_;
/*     */   boolean trainingModeDisplayed_;
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   @Inject
/*     */   private ITrainingModeHelper _trainingModeHelper;
/*     */   
/*     */   public XstTitleBar() {
/*  48 */     InjectionHammer.forceAtInjectProcessing(this);
/*  49 */     this.titleBar_ = PosComponentFactory.getInstance().createTitleBar();
/*     */     
/*  51 */     this.titleBar_.setTitle(LocaleManager.getInstance().getRegisteredString("_appTitle"));
/*  52 */     this.trainingText_ = LocaleManager.getInstance().getRegisteredString("_trainingContext");
/*     */     
/*  54 */     this.trainingTimer_ = new Timer(1500, new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent event)
/*     */           {
/*  58 */             XstTitleBar.this.titleBar_.setText2(XstTitleBar.this.trainingModeDisplayed_ ? XstTitleBar.this.currentText2_ : XstTitleBar.this.trainingText_);
/*  59 */             XstTitleBar.this.trainingModeDisplayed_ = !XstTitleBar.this.trainingModeDisplayed_;
/*     */           }
/*     */         });
/*  62 */     this.trainingTimer_.setRepeats(true);
/*     */     
/*  64 */     ContextManager cm = ((IModeController)this._modeProvider.get()).getContextManager();
/*  65 */     cm.addContextChangeListener(this);
/*  66 */     cm.addContextChangeListener(this, ITrainingModeHelper.TRAINING_MODE_CONTEXT_CONSTRAINT);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  71 */     return (JComponent)getTitleBarComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  76 */     return (JComponent)getTitleBarComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleContextChange(ContextChangeEvent event) {
/*  81 */     UIContext context = (UIContext)event.getNewContext();
/*     */     
/*  83 */     if (this._trainingModeHelper.isTrainingMode()) {
/*  84 */       this.trainingTimer_.start();
/*     */     } else {
/*     */       
/*  87 */       this.trainingTimer_.stop();
/*  88 */       this.trainingModeDisplayed_ = false;
/*     */     } 
/*     */     
/*  91 */     if (context != null) {
/*  92 */       if (!StringUtils.isEmpty(StringUtils.nonNull(context.getTitle()))) {
/*  93 */         this.titleBar_.setTitle(context.getTitle());
/*     */       }
/*     */       
/*  96 */       if (!StringUtils.isEmpty(StringUtils.nonNull(context.getText1()))) {
/*  97 */         this.titleBar_.setText1(context.getText1());
/*     */       }
/*     */       
/* 100 */       if (!StringUtils.isEmpty(StringUtils.nonNull(context.getText2()))) {
/* 101 */         this.currentText2_ = context.getText2();
/*     */       }
/*     */     } 
/*     */     
/* 105 */     this.titleBar_.setText2(this.currentText2_);
/*     */   }
/*     */   
/*     */   private PosTitleBar getTitleBarComponent() {
/* 109 */     return this.titleBar_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstTitleBar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */