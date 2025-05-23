/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.framework.ui.component.XstAppFrame;
/*     */ import dtv.pos.iframework.IBusyState;
/*     */ import dtv.pos.ui.PosRepaintManager;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.swing.DtvTranslucentInstructionPane;
/*     */ import javax.inject.Inject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XstoreBusyState
/*     */   implements IBusyState
/*     */ {
/*     */   private static final String DEFAULT_MESSAGE_KEY = "_pleaseWait";
/*     */   private DtvTranslucentInstructionPane _busyPanel;
/*     */   private boolean _busyStateActive = false;
/*     */   private boolean _permanentState = false;
/*     */   @Inject
/*     */   private LocaleManager _localeManager;
/*     */   
/*     */   public XstoreBusyState(XstAppFrame argApplicationFrame) {
/*  43 */     this._busyPanel = argApplicationFrame.getGlassPane();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {
/*  49 */     if (!this._permanentState) {
/*  50 */       endImpl();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void endPermanent() {
/*  57 */     endImpl();
/*  58 */     this._permanentState = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  63 */     this._busyPanel.setInstruction(this._localeManager.getRegisteredString("_pleaseWait"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start(String argMessage) {
/*  69 */     startImpl(argMessage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startPermanent(String argMessage) {
/*  75 */     this._permanentState = true;
/*  76 */     startImpl(argMessage);
/*     */   }
/*     */   
/*     */   protected void endImpl() {
/*  80 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  84 */             XstoreBusyState.this._busyPanel.setVisible(false);
/*  85 */             XstoreBusyState.this._busyPanel.showProgress(false);
/*     */           }
/*     */         },  true, true);
/*     */     
/*  89 */     this._busyStateActive = false;
/*     */   }
/*     */   
/*     */   protected void startImpl(String argMessage) {
/*  93 */     if (!this._busyStateActive || argMessage != null) {
/*  94 */       final String message = (argMessage == null) ? "_pleaseWait" : argMessage;
/*     */ 
/*     */       
/*  97 */       PosRepaintManager.getInstance().forcePaintingEnabled();
/*     */       
/*  99 */       UIServices.invoke(new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 103 */               XstoreBusyState.this._busyPanel.setInstruction(XstoreBusyState.this._localeManager.getRegisteredString(message));
/* 104 */               XstoreBusyState.this._busyPanel.showProgress(true);
/* 105 */               XstoreBusyState.this._busyPanel.setVisible(true);
/*     */             }
/*     */           },  true, true);
/*     */       
/* 109 */       this._busyStateActive = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\XstoreBusyState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */