/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.Version;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.i18n.HelpLocalizer;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.context.IUIContext;
/*     */ import dtv.pos.iframework.ui.model.IHelpModel;
/*     */ import dtv.pos.ui.UIResponsivenessMgr;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.context.Context;
/*     */ import dtv.util.StringUtils;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
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
/*     */ 
/*     */ public class HelpReqHandler
/*     */   implements IOpReqHandler, IXstEventListener
/*     */ {
/*  48 */   private static final Logger _logger = Logger.getLogger(HelpReqHandler.class);
/*     */   
/*  50 */   private static final String _defaultHelpTitle = Version.getLongTitle();
/*  51 */   private static final String _defaultHelpInstructions = Version.getVersion();
/*     */   
/*     */   private final Collection<? extends IXstAction> _helpActions;
/*     */   
/*     */   private Provider<IModeController> _modeProvider;
/*     */   
/*     */   @Inject
/*     */   private UIResponsivenessMgr _uiResponsivenessMgr;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   public HelpReqHandler(Provider<IModeController> argModeProvider) {
/*  63 */     this._modeProvider = argModeProvider;
/*     */     
/*  65 */     Collection<IXstAction> helpActions = new ArrayList<>();
/*  66 */     String helpMenuName = ConfigurationMgr.getHelpMenu();
/*     */     
/*  68 */     if (!StringUtils.isEmpty(helpMenuName)) {
/*  69 */       IMenuItem root = ((IModeController)this._modeProvider.get()).getStationModel().getMenuModel().getMenu(helpMenuName);
/*     */       
/*  71 */       if (root != null && root.getChildren() != null) {
/*  72 */         for (IMenuItem menuItem : root.getChildren()) {
/*  73 */           helpActions.add(menuItem.getAction());
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/*  78 */     this._helpActions = helpActions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleRequest(IOpRequest argRequest, IXstEventListener argListener, IModeController argModeController) {
/*  87 */     HelpRequest helpRequest = (HelpRequest)argRequest;
/*  88 */     IHelpModel helpModel = ((IModeController)this._modeProvider.get()).getStationModel().getHelpModel();
/*  89 */     IUIContext context = helpRequest.getContext();
/*  90 */     handleHelp(helpModel, context);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleXstEvent(IXstEvent argEvent) {
/*  96 */     if (argEvent instanceof IXstAction) {
/*  97 */       IModeController modeCon = (IModeController)this._modeProvider.get();
/*  98 */       IXstAction action = (IXstAction)argEvent;
/*     */       
/* 100 */       if (IHelpModel.HelpState.ABOUT.getActionKey().equals(action.getActionKey())) {
/* 101 */         handleAbout();
/*     */       }
/* 103 */       else if (IHelpModel.HelpState.HELP.getActionKey().equals(action.getActionKey())) {
/* 104 */         Context currentContext = modeCon.getContextManager().getCurrentContext();
/* 105 */         handleHelp(modeCon.getStationModel().getHelpModel(), (IUIContext)currentContext);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 110 */         _logger.debug("Disabling interactivity");
/* 111 */         this._uiResponsivenessMgr.setResponsive(false);
/*     */         
/* 113 */         _logger.debug("Hiding help view");
/*     */         
/* 115 */         IUIController uiCon = modeCon.getUiController();
/* 116 */         uiCon.enableTransitions(true);
/* 117 */         uiCon.hideHelpView();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 122 */         UIServices.invoke(new Runnable()
/*     */             {
/*     */               public void run() {
/* 125 */                 HelpReqHandler._logger.debug("Enabling interactivity");
/* 126 */                 HelpReqHandler.this._uiResponsivenessMgr.setResponsive(true);
/*     */               }
/*     */             },  true, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<? extends IXstAction> getHelpActions(IUIContext argContext) {
/* 140 */     return this._helpActions;
/*     */   }
/*     */   
/*     */   protected String getHelpInstructions(IUIContext argContext) {
/* 144 */     return _defaultHelpInstructions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHelpTitle(IUIContext argContext) {
/* 154 */     return _defaultHelpTitle;
/*     */   }
/*     */   
/*     */   protected void handleAbout() {
/* 158 */     String aboutMessage = HelpLocalizer.localize("_helpAboutXstore", new IFormattable[0]);
/* 159 */     IHelpModel helpModel = ((IModeController)this._modeProvider.get()).getStationModel().getHelpModel();
/* 160 */     helpModel.setHelpState(IHelpModel.HelpState.ABOUT);
/* 161 */     updateModelMessage(helpModel, aboutMessage);
/* 162 */     showHelpView();
/*     */   }
/*     */   
/*     */   protected void handleHelp(IHelpModel argHelpModel, IUIContext argContext) {
/* 166 */     argHelpModel.clearModel();
/* 167 */     argHelpModel.setHelpState(IHelpModel.HelpState.HELP);
/* 168 */     argHelpModel.setHelpTitle(getHelpTitle(argContext));
/* 169 */     argHelpModel.setHelpInstructions(getHelpInstructions(argContext));
/* 170 */     argHelpModel.setHelpActions(getHelpActions(argContext));
/*     */     
/* 172 */     IFormattable helpKey = (argContext == null) ? null : argContext.getHelpKey();
/* 173 */     String helpMessage = (helpKey == null) ? null : HelpLocalizer.localize(helpKey);
/* 174 */     updateModelMessage(argHelpModel, helpMessage);
/*     */     
/* 176 */     showHelpView();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateModelMessage(IHelpModel argModel, String argMessage) {
/* 186 */     if (!StringUtils.isEmpty(argMessage)) {
/* 187 */       boolean isHtmlMessage = false;
/* 188 */       URL helpMessageUrl = null;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 193 */         helpMessageUrl = new URL(argMessage);
/* 194 */         helpMessageUrl.openConnection();
/* 195 */         isHtmlMessage = true;
/*     */       }
/* 197 */       catch (Exception ex) {
/* 198 */         _logger.debug(argMessage + " is not a valid URL.  Trying again with default protocol/path...");
/*     */         try {
/* 200 */           helpMessageUrl = new URL(ConfigurationMgr.getHelpFilePathUrl().toExternalForm() + argMessage);
/* 201 */           helpMessageUrl.openConnection();
/* 202 */           isHtmlMessage = true;
/*     */         }
/* 204 */         catch (Exception ex2) {
/* 205 */           _logger.debug(argMessage + " is not a valid URL.  Assuming it's literal text.");
/*     */         } 
/*     */       } 
/*     */       
/* 209 */       argModel.setHelpMessage(isHtmlMessage ? helpMessageUrl.toExternalForm() : argMessage);
/* 210 */       argModel.setHelpContentType(isHtmlMessage ? "text/html" : "text/plain");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void showHelpView() {
/* 215 */     IModeController modeCon = (IModeController)this._modeProvider.get();
/* 216 */     IUIController uiCon = modeCon.getUiController();
/* 217 */     uiCon.showHelpView(this);
/* 218 */     uiCon.enableTransitions(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/* 229 */             HelpReqHandler.this._uiResponsivenessMgr.setResponsive(true);
/*     */           }
/*     */         },  false, false);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\HelpReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */