/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.ui.model.IPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.Component;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import javax.swing.JTabbedPane;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TextPromptReqHandler
/*     */   extends AbstractPromptReqHandler
/*     */ {
/*  36 */   private static final Logger logger = Logger.getLogger(TextPromptReqHandler.class);
/*     */ 
/*     */   
/*     */   private static final String NUMERIC_KEYPAD_TAB_NAME = "NUMERIC_KEYPAD";
/*     */ 
/*     */   
/*     */   private IModeController _modeController;
/*     */   
/*     */   private boolean _lastPromptRequestedKeypad = false;
/*     */ 
/*     */   
/*     */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/*  48 */     UIServices.invoke(() -> { this._modeController = argModeController; super.handleRequest(argRequest, argListener, argModeController); PromptRequest promptRequest = (PromptRequest)argRequest; PromptConfig promptConfig = promptRequest.getPromptConfig(); if (ConfigurationMgr.isDecimalKeyboardAutomaticallyCalled() && promptConfig.isAutoPopDecimalKbdEnabled()) { this._lastPromptRequestedKeypad = true; showKeypadTab(); } else if (this._lastPromptRequestedKeypad) { this._lastPromptRequestedKeypad = false; showDefaultTab(); }  this._modeController.getUiController().showFocusBar(); }true, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPopupHandler() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<Component> getKeyStrokeTargets() {
/*  77 */     Component c = this._modeController.getUiController().getFocusableChildComponent("FOCUS_BAR");
/*     */     
/*  79 */     return Arrays.asList(new Component[] { c });
/*     */   }
/*     */ 
/*     */   
/*     */   protected IPromptModel getPromptModel() {
/*  84 */     IStationModel sm = this._modeController.getStationModel();
/*     */     
/*  86 */     if (sm == null) {
/*  87 */       logger.warn("NULL STATION MODEL ?!?!?!?!");
/*  88 */       return null;
/*     */     } 
/*     */     
/*  91 */     return (IPromptModel)sm.getTextPromptModel();
/*     */   }
/*     */   
/*     */   protected void showKeypadTab() {
/*  95 */     final JTabbedPane pane = getTabContainer();
/*  96 */     int matchedIndex = -1;
/*     */     
/*  98 */     for (int i = 0; i < pane.getTabCount(); i++) {
/*  99 */       if ("NUMERIC_KEYPAD".matches(pane.getComponentAt(i).getName())) {
/* 100 */         matchedIndex = i;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 105 */     if (matchedIndex >= 0) {
/* 106 */       final int keypadIndex = matchedIndex;
/*     */       
/* 108 */       UIServices.invoke(new Runnable()
/*     */           {
/*     */             public void run() {
/* 111 */               pane.setSelectedIndex(keypadIndex);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\TextPromptReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */