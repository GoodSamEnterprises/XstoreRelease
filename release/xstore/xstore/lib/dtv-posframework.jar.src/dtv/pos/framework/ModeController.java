/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.action.type.FormNavigationActionType;
/*     */ import dtv.pos.framework.action.type.XstChainActionType;
/*     */ import dtv.pos.framework.action.type.XstDataActionType;
/*     */ import dtv.pos.framework.action.type.XstMenuActionType;
/*     */ import dtv.pos.framework.event.ConfigurableEventHandler;
/*     */ import dtv.pos.framework.op.OpChainProcessor;
/*     */ import dtv.pos.framework.scope.DefaultScope;
/*     */ import dtv.pos.framework.scope.TransactionScope;
/*     */ import dtv.pos.iframework.IErrorListener;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstChainAction;
/*     */ import dtv.pos.iframework.action.IXstChainActionType;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.event.IXstEventRouter;
/*     */ import dtv.pos.iframework.event.IXstEventType;
/*     */ import dtv.pos.iframework.ui.IUIController;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.iframework.xstorem.ICheetahXstoreBridge;
/*     */ import dtv.ui.context.ContextManager;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Named;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.ThreadContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModeController
/*     */   implements IModeController
/*     */ {
/*  44 */   private static final Logger _logger = LogManager.getLogger(StationController.class);
/*     */   
/*     */   private ApplicationData _appData;
/*  47 */   private final List<IErrorListener> _errorListeners = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private IStationModel _stationModel;
/*     */ 
/*     */ 
/*     */   
/*     */   private IXstEventRouter _eventRouter;
/*     */ 
/*     */ 
/*     */   
/*     */   private IUIController _uiController;
/*     */ 
/*     */ 
/*     */   
/*     */   private ContextManager _contextManager;
/*     */ 
/*     */   
/*     */   private List<IHasFlowEventListener> _ocpListeners;
/*     */ 
/*     */   
/*     */   private final ThreadGroup _threadGroup;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   @Named("userOpChainProcessor")
/*     */   private OpChainProcessor _userOcp;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   @Named("systemOpChainProcessor")
/*     */   private OpChainProcessor _sysOcp;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ConfigurableEventHandler _defaultEventHandler;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private DefaultScope _defaultScopeOnlyUsedForDebugDumpInfo;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private TransactionScope _transactionScopeOnlyUsedForDebugDumpInfo;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ICheetahXstoreBridge _cheetahBridge;
/*     */ 
/*     */   
/*     */   private boolean _initialized;
/*     */ 
/*     */ 
/*     */   
/*     */   public ModeController() {
/* 107 */     this._threadGroup = new ThreadGroup("group");
/* 108 */     this._threadGroup.setDaemon(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addErrorListener(IErrorListener argListener) {
/* 113 */     this._errorListeners.add(argListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ContextManager getContextManager() {
/* 119 */     return this._contextManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getDebugInfo(StringBuilder sb) {
/* 124 */     sb.append("\n****USER OPCHAIN PROCESSOR:\n");
/* 125 */     this._userOcp.dumpDebugInfo(0, sb);
/* 126 */     sb.append("\n****SYSTEM OPCHAIN PROCESSOR:\n");
/* 127 */     this._sysOcp.dumpDebugInfo(0, sb);
/*     */     
/* 129 */     String defaultScopeDump = this._defaultScopeOnlyUsedForDebugDumpInfo.dump();
/* 130 */     String transactionScopeDump = this._transactionScopeOnlyUsedForDebugDumpInfo.dump();
/*     */     
/* 132 */     sb.append(StringUtils.NEW_LINE);
/* 133 */     sb.append(defaultScopeDump);
/* 134 */     sb.append(StringUtils.NEW_LINE);
/* 135 */     sb.append(transactionScopeDump);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstEventRouter getEventRouter() {
/* 141 */     return this._eventRouter;
/*     */   }
/*     */ 
/*     */   
/*     */   public ApplicationData getModeData() {
/* 146 */     return this._appData;
/*     */   }
/*     */ 
/*     */   
/*     */   public IStationModel getStationModel() {
/* 151 */     return this._stationModel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IUIController getUiController() {
/* 157 */     return this._uiController;
/*     */   }
/*     */   
/*     */   public void initController(ApplicationData argModeData) {
/* 161 */     this._appData = argModeData;
/* 162 */     _logger.info("Initializing [{}] mode controller.", this._appData);
/*     */ 
/*     */     
/* 165 */     this._userOcp.setName("User OpChainProcessor[" + this._appData.toString() + "]");
/* 166 */     this._userOcp.setModeController(this);
/* 167 */     this._uiController.setModeController(this);
/* 168 */     this._stationModel.getMenuModel().setModeController(this);
/* 169 */     this._cheetahBridge.setModeController(this);
/* 170 */     registerFlowEventListeners(this._userOcp);
/*     */ 
/*     */     
/* 173 */     this._eventRouter.addListener((IXstEventListener)this._userOcp, (IXstEventType)XstDataActionType.STANDARD);
/* 174 */     this._eventRouter.addListener((IXstEventListener)this._userOcp, (IXstEventType)XstMenuActionType.MENU);
/* 175 */     this._eventRouter.addListener((IXstEventListener)this._userOcp, (IXstEventType)XstChainActionType.START);
/* 176 */     this._eventRouter.addListener((IXstEventListener)this._userOcp, (IXstEventType)XstChainActionType.START_NEW_APP);
/* 177 */     this._eventRouter.addListener((IXstEventListener)this._userOcp, (IXstEventType)XstChainActionType.STACK);
/* 178 */     this._eventRouter.addListener((IXstEventListener)this._userOcp, (IXstEventType)FormNavigationActionType.STANDARD);
/*     */ 
/*     */     
/* 181 */     this._sysOcp.setName("System OpChainProcessor[" + this._appData.toString() + "]");
/* 182 */     this._sysOcp.setModeController(this);
/* 183 */     registerFlowEventListeners(this._sysOcp);
/*     */ 
/*     */     
/* 186 */     this._eventRouter.addListener((IXstEventListener)this._sysOcp, (IXstEventType)XstChainActionType.SYSTEM);
/* 187 */     this._contextManager.addContextChangeListener((IContextChangeListener)this._defaultEventHandler);
/*     */ 
/*     */ 
/*     */     
/* 191 */     this._eventRouter.setDefaultEventHandler((IXstEventListener)this._defaultEventHandler);
/* 192 */     this._defaultEventHandler.setMappedEventRouter(this._eventRouter);
/* 193 */     this._stationModel.initialize(argModeData);
/*     */     
/* 195 */     StationController.dumpMemoryReport("After start of the system op chain processor");
/*     */   }
/*     */   
/*     */   public void initOCP() {
/* 199 */     this._userOcp.initialize();
/* 200 */     this._sysOcp.initialize();
/*     */   }
/*     */   
/*     */   public void initStationView() {
/* 204 */     String uiName = this._appData.getKey();
/*     */     
/* 206 */     if (ConfigurationMgr.isUIFlipped()) {
/* 207 */       uiName = uiName + "_FLIPPED";
/*     */     }
/*     */     
/* 210 */     Component baseUIComponent = this._uiController.createUI(uiName);
/* 211 */     if (baseUIComponent != null) {
/* 212 */       StationController.getAppFrame().add(baseUIComponent, this._appData.getKey());
/*     */ 
/*     */       
/* 215 */       StationController.showFrame();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInitialized() {
/* 223 */     return this._initialized;
/*     */   }
/*     */ 
/*     */   
/*     */   public void notifyErrorListeners(Throwable argThrowable) {
/* 228 */     if (argThrowable != null) {
/*     */       try {
/* 230 */         for (IErrorListener errorListener : this._errorListeners) {
/* 231 */           errorListener.errorOccurred(argThrowable);
/*     */         }
/*     */       }
/* 234 */       catch (Exception ex) {
/* 235 */         _logger.error("CAUGHT EXCEPTION notifying error listeners", ex);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeErrorListener(IErrorListener argListener) {
/* 242 */     this._errorListeners.remove(argListener);
/*     */   }
/*     */   
/*     */   public void setContextManager(ContextManager argContextManager) {
/* 246 */     this._contextManager = argContextManager;
/*     */   }
/*     */   
/*     */   public void setEventRouter(IXstEventRouter argEventRouter) {
/* 250 */     this._eventRouter = argEventRouter;
/*     */   }
/*     */   
/*     */   public void setFlowEventListeners(List<IHasFlowEventListener> argListeners) {
/* 254 */     this._ocpListeners = argListeners;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInitialized(boolean argInitialized) {
/* 262 */     this._initialized = argInitialized;
/*     */   }
/*     */   
/*     */   public void setStationModel(IStationModel argModel) {
/* 266 */     this._stationModel = argModel;
/*     */   }
/*     */   
/*     */   public void setUIController(IUIController argUIController) {
/* 270 */     this._uiController = argUIController;
/*     */   }
/*     */   
/*     */   public void shutdownController() {
/* 274 */     this._userOcp.setEnabled(false);
/* 275 */     this._sysOcp.setEnabled(false);
/*     */ 
/*     */ 
/*     */     
/* 279 */     this._threadGroup.interrupt();
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
/*     */   public void startController(boolean argPaused) {
/* 292 */     String workstationId = (this._appData != null && this._appData.getWorkstationInfo() != null) ? String.valueOf(this._appData.getWorkstationInfo().getWorkstationId()) : "";
/* 293 */     ThreadContext.put("wkstn_id", workstationId);
/* 294 */     String appData = this._appData + ":OCP" + (StringUtils.isEmpty(workstationId) ? "" : ("-" + workstationId));
/*     */     
/* 296 */     _logger.info("Starting the [{}] mode controller", this._appData);
/*     */ 
/*     */     
/* 299 */     OpChainKey startupChainKey = this._appData.getStartupOpChainKey();
/* 300 */     _logger.debug("Firing [{}] startup operation chain {}", this._appData, startupChainKey);
/*     */     
/* 302 */     IErrorListener errorListener = new IErrorListener()
/*     */       {
/*     */         public void errorOccurred(Throwable argThrowable) {
/* 305 */           throw new StartupException(argThrowable);
/*     */         }
/*     */       };
/*     */     
/* 309 */     addErrorListener(errorListener);
/* 310 */     IXstChainAction chainAction = this._actionFactory.getChainAction(startupChainKey, (IXstChainActionType)XstChainActionType.START);
/* 311 */     this._userOcp.handleXstEventImmediately((IXstEvent)chainAction);
/* 312 */     removeErrorListener(errorListener);
/*     */ 
/*     */     
/* 315 */     Thread userOpcThread = new Thread(this._threadGroup, (Runnable)this._userOcp, appData + " [User]");
/* 316 */     userOpcThread.setPriority(10);
/* 317 */     userOpcThread.start();
/*     */     
/* 319 */     Thread systemOpcThread = new Thread(this._threadGroup, (Runnable)this._sysOcp, appData + " [System]");
/*     */     
/* 321 */     systemOpcThread.start();
/*     */     
/* 323 */     this._userOcp.initialize();
/* 324 */     this._sysOcp.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 329 */     return "ModeController [" + this._appData.toString() + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerFlowEventListeners(OpChainProcessor argOcp) {
/* 336 */     for (IHasFlowEventListener listener : this._ocpListeners)
/* 337 */       listener.registerEventListener((IEventSource)argOcp); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\ModeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */