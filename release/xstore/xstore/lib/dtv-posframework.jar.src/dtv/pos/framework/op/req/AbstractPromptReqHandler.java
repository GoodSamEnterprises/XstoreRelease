/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.hardware.audio.AudioMgr;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.logging.ProcessLogger;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfigHelper;
/*     */ import dtv.pos.framework.ui.model.DefaultMenuModel;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.op.req.IPromptReqHandler;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.pos.iframework.ui.config.IPromptConfig;
/*     */ import dtv.pos.iframework.ui.model.IMenuModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import dtv.pos.iframework.xstorem.ICheetahXstoreBridge;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import java.awt.Component;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.KeyStroke;
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
/*     */ public abstract class AbstractPromptReqHandler
/*     */   implements IPromptReqHandler
/*     */ {
/*  42 */   static final Logger logger_ = Logger.getLogger(AbstractPromptReqHandler.class);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ProcessLogger _flowLogger;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   protected ICheetahXstoreBridge _cheetahBridge;
/*     */   
/*     */   @Inject
/*     */   private PromptConfigHelper _promptConfigHelper;
/*     */   
/*     */   private IModeController _modeController;
/*     */ 
/*     */   
/*     */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/*  59 */     this._modeController = argModeController;
/*  60 */     PromptRequest request = (PromptRequest)argRequest;
/*  61 */     PromptConfig config = request.getPromptConfig();
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (isPopupHandler()) {
/*     */       
/*  67 */       showDefaultTab();
/*     */ 
/*     */       
/*  70 */       PromptKey emptyTextKey = PromptRequest.BLANK_TEXT_PROMPT;
/*  71 */       PromptConfig emptyTextPrompt = this._promptConfigHelper.getPromptConfig(emptyTextKey, null);
/*  72 */       this._modeController.getStationModel().getTextPromptModel().setValues((IPromptConfig)emptyTextPrompt);
/*     */     } 
/*     */     
/*  75 */     if (Boolean.TRUE.equals(config.getModal())) {
/*  76 */       this._modeController.getStationModel().getMenuModel().setCurrentMenu(DefaultMenuModel.EMPTY_MENU);
/*     */     }
/*     */     
/*  79 */     this._flowLogger.info("Prompt", config.getPromptKey(), (IHasSourceDescription)config, null, null);
/*     */     
/*  81 */     if (logger_.isInfoEnabled()) {
/*  82 */       logger_.info("Using prompt [" + config.getPromptKey() + "] @@ " + config.getSourceDescription());
/*     */     }
/*     */ 
/*     */     
/*  86 */     AudioMgr.play(config.getSound());
/*     */     
/*  88 */     if (PromptKey.DEFAULT.equals(config.getPromptKey())) {
/*  89 */       logger_.warn("Prompt not defined:\n\tprompt = [" + request
/*  90 */           .getPromptKey() + "]\n\tshowing DEFAULT");
/*     */     }
/*     */     
/*  93 */     IPromptModel promptModel = getPromptModel();
/*  94 */     IUIInputModel dataModel = getDataModel();
/*  95 */     IPromptActionModel actionModel = this._modeController.getStationModel().getPromptActionModel();
/*     */     
/*  97 */     actionModel.setValues(filterExistingTouchActions(config.getPromptActions()), config
/*  98 */         .getActionDisplayType(), dataModel, getKeyStrokeTargets(), argListener);
/*     */     
/* 100 */     if (PromptKey.valueOf("STANDARD_ERROR").equals(request.getPromptKey())) {
/* 101 */       StringBuilder sb = new StringBuilder(1024);
/* 102 */       sb.append("HELP DESK ERROR");
/*     */       
/* 104 */       Logger.getLogger("HELP_DESK_ERROR.email").fatal(sb);
/*     */     } 
/*     */     
/* 107 */     if (promptModel != null) {
/* 108 */       setModelValues(promptModel, request);
/*     */     } else {
/*     */       
/* 111 */       logger_.warn("There is no prompt model for the system.  There is no way for the user to see this prompt!");
/*     */     } 
/*     */ 
/*     */     
/* 115 */     this._modeController.getStationModel().setActivePromptKey(config.getPromptKey().toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<IXstAction> filterExistingTouchActions(Collection<IXstAction> actions) {
/* 121 */     IMenuModel model = this._modeController.getStationModel().getMenuModel();
/*     */     
/* 123 */     if (model != null && model.getCurrentMenu() != null) {
/* 124 */       IMenuItem item = model.getCurrentMenu();
/*     */       
/* 126 */       for (IMenuItem child : item.getChildren()) {
/* 127 */         IXstAction menuItemAction = child.getAction();
/* 128 */         KeyStroke menuItemActionKeystroke = menuItemAction.getKeyStroke();
/* 129 */         if (menuItemAction != null) {
/* 130 */           Iterator<IXstAction> it = actions.iterator();
/*     */           
/* 132 */           while (it.hasNext()) {
/* 133 */             IXstAction action = it.next();
/* 134 */             KeyStroke actionKeyStroke = action.getKeyStroke();
/*     */ 
/*     */             
/* 137 */             if ((action.getActionKey().equals(menuItemAction.getActionKey()) || (actionKeyStroke != null && menuItemActionKeystroke != null && actionKeyStroke
/*     */               
/* 139 */               .toString().equals(menuItemActionKeystroke.toString()))) && 
/* 140 */               !action.isVisible()) {
/* 141 */               it.remove();
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 147 */     return actions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IUIInputModel getDataModel() {
/* 156 */     return (IUIInputModel)getPromptModel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Collection<Component> getKeyStrokeTargets();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract IPromptModel getPromptModel();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JTabbedPane getTabContainer() {
/* 177 */     JTabbedPane pane = (JTabbedPane)this._modeController.getUiController().getNamedComponent("INPUT_CONTROL_AREA");
/*     */     
/* 179 */     return pane;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setModelValues(IPromptModel model, PromptRequest request) {
/* 190 */     model.setPromptArgs(request.getPromptArgs());
/* 191 */     model.setValues((IPromptConfig)request.getPromptConfig());
/*     */   }
/*     */   
/*     */   protected void showDefaultTab() {
/* 195 */     final JTabbedPane pane = getTabContainer();
/* 196 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 199 */             pane.setSelectedIndex(0);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\AbstractPromptReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */