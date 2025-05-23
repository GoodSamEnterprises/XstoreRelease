/*      */ package dtv.pos.framework.op;
/*      */ import dtv.event.Event;
/*      */ import dtv.event.EventEnum;
/*      */ import dtv.event.EventHandler;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventConstraint;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.pos.common.OpChainKey;
/*      */ import dtv.pos.common.PromptKey;
/*      */ import dtv.pos.framework.action.type.XstChainActionType;
/*      */ import dtv.pos.framework.action.type.XstMenuActionType;
/*      */ import dtv.pos.framework.logging.ProcessLogger;
/*      */ import dtv.pos.framework.op.req.HelpRequest;
/*      */ import dtv.pos.framework.op.req.PromptRequest;
/*      */ import dtv.pos.framework.ui.config.PromptConfig;
/*      */ import dtv.pos.framework.ui.config.PromptConfigHelper;
/*      */ import dtv.pos.framework.ui.context.UIContextDescriptor;
/*      */ import dtv.pos.iframework.IModeController;
/*      */ import dtv.pos.iframework.XstApplication;
/*      */ import dtv.pos.iframework.action.ITriggeredAction;
/*      */ import dtv.pos.iframework.action.IXstAction;
/*      */ import dtv.pos.iframework.action.IXstActionKey;
/*      */ import dtv.pos.iframework.action.IXstChainAction;
/*      */ import dtv.pos.iframework.event.IXstEvent;
/*      */ import dtv.pos.iframework.event.IXstEventListener;
/*      */ import dtv.pos.iframework.event.IXstEventType;
/*      */ import dtv.pos.iframework.op.IDebuggable;
/*      */ import dtv.pos.iframework.op.IOpChain;
/*      */ import dtv.pos.iframework.op.IOpChainFactory;
/*      */ import dtv.pos.iframework.op.IOpChainProcessor;
/*      */ import dtv.pos.iframework.op.IOpResponse;
/*      */ import dtv.pos.iframework.op.IOperation;
/*      */ import dtv.pos.iframework.op.OpStatus;
/*      */ import dtv.pos.iframework.op.TraversalStrategyType;
/*      */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*      */ import dtv.pos.iframework.op.req.IOpReqHandlerFactory;
/*      */ import dtv.pos.iframework.op.req.IOpRequest;
/*      */ import dtv.pos.iframework.type.ExitType;
/*      */ import dtv.pos.iframework.type.IExitType;
/*      */ import dtv.pos.iframework.ui.IMenuItem;
/*      */ import dtv.pos.iframework.ui.context.IUIContext;
/*      */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*      */ import dtv.pos.iframework.ui.model.IMenuModel;
/*      */ import dtv.ui.context.ContextChangeEvent;
/*      */ import dtv.ui.context.IContextChangeListener;
/*      */ import dtv.util.PerformanceTimer;
/*      */ import dtv.util.config.IHoldsConfigParameters;
/*      */ import dtv.util.config.ParameterConfig;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.Stack;
/*      */ import java.util.concurrent.LinkedBlockingQueue;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import javax.inject.Inject;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class OpChainProcessor implements IOpChainProcessor, IDebuggable {
/*   59 */   private static final Logger _logger = Logger.getLogger(OpChainProcessor.class);
/*   60 */   private static final boolean _debugLogging = _logger.isDebugEnabled();
/*      */   
/*   62 */   private static final Logger _adminLogger = Logger.getLogger("dtv.xstore.helpdesk");
/*      */   
/*   64 */   private static final Logger _memoryLogger = Logger.getLogger("dtv.xstore.helpdesk.memory");
/*   65 */   private static final IEventConstraint _menuForwardConstraint = (IEventConstraint)new NameConstraint(IMenuModel.FORWARD_TRAVERSAL_CONSTRAINT);
/*      */   
/*   67 */   private static final PromptKey PK_FRAMEWORK_ERROR = PromptKey.valueOf("FRAMEWORK_ERROR");
/*   68 */   private static final OpChainKey MENU_TRAVERSAL_FORWARD = OpChainKey.valueOf("MENU_TRAVERSAL_FORWARD");
/*   69 */   private static final PerformanceTimer _timer = new PerformanceTimer(); protected IOpChain currentChain_; protected IXstEvent currentEvent_; protected IUIContext currentUIContext_; protected OpChainKey defaultChainKey_; protected Class<?>[] evtInterface_; protected LinkedBlockingQueue<IXstEvent> evtQueue_; protected IXstEventType[] evtTypes_; protected LevelStack rollbackStack_;
/*      */   
/*      */   private static boolean isNonUiRequest(IOpResponse argResponse) {
/*   72 */     return argResponse.getOpRequests().stream().anyMatch(r -> r instanceof dtv.pos.iframework.op.req.IRunRequest);
/*      */   }
/*      */   
/*      */   private static boolean isUserPromptRequest(IOpResponse argResponse) {
/*   76 */     return argResponse.getOpRequests().stream().anyMatch(r -> r instanceof dtv.pos.iframework.op.req.IUIOpRequest);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  100 */   protected AtomicBoolean systemActive_ = new AtomicBoolean();
/*      */ 
/*      */   
/*      */   private IModeController _modeController;
/*      */   
/*      */   @Inject
/*      */   private ProcessLogger flowLogger_;
/*      */   
/*      */   @Inject
/*      */   private ActionLogger _actionLogger;
/*      */   
/*      */   @Inject
/*      */   private IOpReqHandlerFactory _opReqHandlerFactory;
/*      */   
/*      */   @Inject
/*      */   private IOpChainFactory _opChainFactory;
/*      */   
/*      */   @Inject
/*      */   private ICaptureHarness _captureHarness;
/*      */   
/*      */   @Inject
/*      */   private ITestHarness _testHarness;
/*      */   
/*      */   @Inject
/*      */   private UIResponsivenessMgr _uiResponsivenessMgr;
/*      */   
/*      */   @Inject
/*      */   private IBusyState _busyState;
/*      */   
/*      */   @Inject
/*      */   private PromptConfigHelper _promptConfigHelper;
/*      */   
/*      */   @Inject
/*      */   private ICheetahXstoreBridge _cheetahBridge;
/*      */   
/*      */   @Inject
/*      */   private EventManager _eventManager;
/*      */   
/*      */   @Inject
/*      */   private OpResponseHelper _opResponseHelper;
/*      */   
/*  141 */   private final Eventor events_ = (Eventor)new DefaultEventor((IEventSource)this);
/*      */   
/*      */   private final IContextChangeListener contextChangeListener_;
/*  144 */   private final Object busyLock_ = new Object();
/*      */   
/*      */   private OpChainKey currentRollBackChainKey_;
/*      */   
/*      */   private boolean busyFlag_ = false;
/*      */   
/*      */   private boolean initialized_ = false;
/*      */   
/*  152 */   private final EventHandler menuChangeHandler_ = new EventHandler()
/*      */     {
/*      */       protected void handle(Event argEvent)
/*      */       {
/*  156 */         IMenuModel menuModel = (IMenuModel)argEvent.getSource(IMenuModel.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  162 */         OpChainProcessor.this.processChain(OpChainProcessor.MENU_TRAVERSAL_FORWARD);
/*  163 */         IMenuItem newNode = menuModel.getCurrentMenu();
/*      */         
/*  165 */         if (newNode != null) {
/*  166 */           OpChainProcessor.this.currentChain_.setRollbackLevel(OpChainProcessor.this.rollbackStack_.getMaximumLevel() + 1);
/*      */         }
/*      */         
/*  169 */         OpChainProcessor.this.runChain();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/*      */   private String name_;
/*      */   
/*      */   private final OpChainProcessorType opChainType_;
/*      */   
/*      */   private OpChainKey preRollbackChainKey_;
/*      */ 
/*      */   
/*      */   public OpChainProcessor(OpChainProcessorType argType) {
/*  183 */     this.opChainType_ = argType;
/*  184 */     this.evtQueue_ = new LinkedBlockingQueue<>();
/*  185 */     this.systemActive_.set(true);
/*  186 */     this.rollbackStack_ = new LevelStack();
/*  187 */     this.currentUIContext_ = null;
/*  188 */     this.contextChangeListener_ = new ContextChangeListener();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dumpDebugInfo(int argLevel, StringBuilder sb) {
/*  194 */     sb.append("rollback stack:\n");
/*  195 */     Stack<?> stack = this.rollbackStack_.getStack();
/*      */     
/*  197 */     while (!stack.isEmpty()) {
/*      */       
/*  199 */       LevelStackObject o = (LevelStackObject)stack.pop();
/*  200 */       sb.append("  " + o.level_ + ":");
/*  201 */       sb.append("chain:" + o.source_.getChainKey() + ", context:" + o.source_.getUIContext());
/*  202 */       sb.append("\n");
/*      */     } 
/*      */     
/*  205 */     sb.append("default chain:" + this.defaultChainKey_ + "\n");
/*      */     
/*  207 */     if (this.currentChain_ instanceof IDebuggable) {
/*  208 */       ((IDebuggable)this.currentChain_).dumpDebugInfo(argLevel, sb);
/*      */     } else {
/*      */       
/*  211 */       sb.append("current chain :" + this.currentChain_ + "\n");
/*      */     } 
/*      */     
/*  214 */     sb.append("preRollbackChainKey: " + this.preRollbackChainKey_ + "\n");
/*  215 */     sb.append("currentRollBackChainKey: " + this.currentRollBackChainKey_ + "\n");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleXstAction(IXstAction argAction) {
/*  221 */     if (_debugLogging) {
/*  222 */       _logger.debug("Handling xst action " + argAction);
/*      */     }
/*      */     
/*  225 */     handleXstEvent((IXstEvent)argAction);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleXstEvent(IXstEvent argEvent) {
/*  235 */     if (this.initialized_) {
/*  236 */       if (this.opChainType_ == OpChainProcessorType.USER && !isBusy()) {
/*  237 */         _logger.debug("Disabling interactivity before queuing event");
/*  238 */         this._uiResponsivenessMgr.setResponsive(false);
/*      */       } 
/*      */       
/*  241 */       if (_debugLogging) {
/*  242 */         _logger.debug("Queuing event " + argEvent);
/*      */       }
/*      */       try {
/*  245 */         this.evtQueue_.put(argEvent);
/*      */       }
/*  247 */       catch (InterruptedException ex) {
/*  248 */         _logger.error("event not being placed onto queue ", ex);
/*      */       } 
/*      */     } else {
/*      */       
/*  252 */       _logger.debug(this + " is not yet initialized.  Event [" + argEvent + "] cannot be added to the queue; forwarding event directly to handleXstEventImmediately.");
/*      */       
/*  254 */       handleXstEventImmediately(argEvent);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleXstEventImmediately(IXstEvent argEvent) {
/*  266 */     if (_debugLogging) {
/*  267 */       _logger.debug("Handling event [" + argEvent + "]");
/*      */     }
/*      */     
/*  270 */     if (!this._testHarness.isProcessing()) {
/*  271 */       this._captureHarness.captureEvent(argEvent);
/*      */     }
/*      */     
/*  274 */     boolean continueChain = true;
/*  275 */     this.currentEvent_ = argEvent;
/*      */     
/*  277 */     if (argEvent instanceof IXstAction) {
/*  278 */       IXstAction action = (IXstAction)this.currentEvent_;
/*  279 */       IXstEventType type = action.getType();
/*  280 */       IXstActionKey key = action.getActionKey();
/*      */ 
/*      */ 
/*      */       
/*  284 */       if (OpChainKey.valueOf("HELP").equals(key)) {
/*  285 */         HelpRequest request = new HelpRequest(this.currentUIContext_);
/*  286 */         IOpReqHandler helpHandler = this._opReqHandlerFactory.getReqHandler(request.getRequestType());
/*  287 */         helpHandler.handleRequest((IOpRequest)request, getRequestEventListener((IOpRequest)request), this._modeController);
/*  288 */         continueChain = false;
/*      */       }
/*  290 */       else if (type.equals(XstMenuActionType.MENU)) {
/*  291 */         IOpRequest menuRequest = (IOpRequest)action;
/*  292 */         IOpReqHandler menuHandler = this._opReqHandlerFactory.getReqHandler(menuRequest.getRequestType());
/*  293 */         menuHandler.handleRequest(menuRequest, getRequestEventListener(menuRequest), this._modeController);
/*  294 */         continueChain = false;
/*      */       }
/*  296 */       else if (type.equals(XstChainActionType.START) || type.equals(XstChainActionType.START_NEW_APP) || type
/*  297 */         .equals(XstChainActionType.SYSTEM)) {
/*  298 */         handleChainStart((IXstChainAction)this.currentEvent_);
/*      */       }
/*  300 */       else if (type.equals(XstChainActionType.STACK)) {
/*  301 */         handleChainStack((IXstChainAction)this.currentEvent_);
/*      */       }
/*  303 */       else if (key.equals(XstDataActionKey.CANCEL)) {
/*  304 */         handleBackup();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  310 */     if (argEvent instanceof ITriggeredAction) {
/*  311 */       this.currentEvent_ = getTrigger((ITriggeredAction)argEvent);
/*      */     }
/*      */ 
/*      */     
/*  315 */     if (continueChain) {
/*  316 */       runChain();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void initialize() {
/*  323 */     if (!this.initialized_) {
/*      */ 
/*      */ 
/*      */       
/*  327 */       if (OpChainProcessorType.USER.equals(this.opChainType_)) {
/*  328 */         IMenuModel menuModel = this._modeController.getStationModel().getMenuModel();
/*  329 */         this._eventManager.registerEventHandler((IEventAware)this.menuChangeHandler_, (IEventSource)menuModel, _menuForwardConstraint);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  335 */         this._modeController.getContextManager().addContextChangeListener(this.contextChangeListener_);
/*      */       } 
/*  337 */       this.initialized_ = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void popDefaultChain() {
/*  346 */     if (!this.rollbackStack_.isEmpty() && this.rollbackStack_.getSize() > 1) {
/*  347 */       this.rollbackStack_.pop();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void postEvent(EventEnum argEvent, Object argPayload) {
/*  354 */     this.events_.post(argEvent, argPayload);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void processRollback() {
/*  361 */     processRollback(this.currentChain_.getChainKey());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void run() {
/*  370 */     _logger.info("Running op chain processor");
/*      */     
/*  372 */     while (this.systemActive_.get()) {
/*      */       try {
/*  374 */         setBusy(false);
/*  375 */         _logger.debug("Preparing to take event from queue...");
/*  376 */         IXstEvent event = this.evtQueue_.take();
/*  377 */         _logger.debug("Popping event " + event);
/*  378 */         setBusy(true);
/*      */         
/*  380 */         if (this.opChainType_ == OpChainProcessorType.USER) {
/*  381 */           _logger.debug("Disabling interactivity before processing event");
/*  382 */           this._uiResponsivenessMgr.setResponsive(false);
/*      */         } 
/*      */         
/*  385 */         handleXstEventImmediately(event);
/*      */         
/*  387 */         if (this.opChainType_ == OpChainProcessorType.USER) {
/*  388 */           this._busyState.end();
/*      */         }
/*      */         
/*  391 */         if (this.evtQueue_.size() == 0) {
/*  392 */           if (_logger.isInfoEnabled()) {
/*  393 */             _logger.info(this.opChainType_ + " ******* OP CHAIN PROCESSOR PAUSED ******** Re-enabling interactivity");
/*      */           }
/*      */           
/*  396 */           if (this.opChainType_ == OpChainProcessorType.USER) {
/*  397 */             this._uiResponsivenessMgr.setResponsive(true);
/*      */           }
/*      */         }
/*      */       
/*  401 */       } catch (InterruptedException ie) {
/*  402 */         if (this.systemActive_.get()) {
/*  403 */           String msg = "The main op chain processor loop has caught an unexpected InterruptedException";
/*  404 */           _adminLogger.fatal(msg, ie);
/*  405 */           XstApplication.annihilate((IExitType)ExitType.DISASTER, msg, ie);
/*      */         } else {
/*      */           
/*  408 */           _logger.info("Legitimate OCP shutdown");
/*      */         }
/*      */       
/*  411 */       } catch (OutOfMemoryError e) {
/*  412 */         String msg = "The JVM has run out of memory.  Try increasing the max value.";
/*  413 */         _memoryLogger.fatal(msg, e);
/*  414 */         XstApplication.annihilate((IExitType)ExitType.DISASTER, msg, e);
/*      */       }
/*  416 */       catch (Throwable ex) {
/*  417 */         String msg = "The main op chain processor loop has caught an exception";
/*  418 */         _adminLogger.fatal(msg, ex);
/*  419 */         XstApplication.annihilate((IExitType)ExitType.DISASTER, msg, ex);
/*      */       } 
/*      */       
/*      */       try {
/*  423 */         long t1 = System.currentTimeMillis();
/*      */ 
/*      */ 
/*      */         
/*  427 */         long t2 = System.currentTimeMillis();
/*      */         
/*  429 */         if (_debugLogging) {
/*  430 */           _logger.debug("listener notification took " + (t2 - t1) + " ms");
/*      */         }
/*      */       }
/*  433 */       catch (Throwable ex) {
/*  434 */         _adminLogger.error("CAUGHT EXCEPTION", ex);
/*  435 */         _logger.error("CAUGHT EXCEPTION", ex);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultChain(OpChainKey argDefaultChain, int rollbackLevel) {
/*  449 */     IMenuModel menuModel = this._modeController.getStationModel().getMenuModel();
/*      */ 
/*      */     
/*  452 */     RollbackElement rollbackElement = new RollbackElement(argDefaultChain, this.currentUIContext_, menuModel.getCurrentMenu());
/*      */     
/*  454 */     this.rollbackStack_.push(rollbackElement, rollbackLevel);
/*  455 */     this.defaultChainKey_ = argDefaultChain;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnabled(boolean argValue) {
/*  461 */     _logger.info("Setting chain processor active status flag to " + argValue);
/*  462 */     this.systemActive_.set(argValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setModeController(IModeController argController) {
/*  473 */     this._modeController = argController;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String argName) {
/*  482 */     this.name_ = argName;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  488 */     return this.name_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean processChain(OpChainKey currentChainKey) {
/*  499 */     if (_debugLogging) {
/*  500 */       _logger.debug("Setting new chain key: " + currentChainKey);
/*      */     }
/*      */     
/*  503 */     if (this.currentChain_ != null && !this.currentChain_.isComplete() && !this.currentChain_.isError())
/*      */     {
/*      */ 
/*      */       
/*  507 */       if (this.currentChain_.isCancelable() || (this._testHarness
/*  508 */         .isEnabled() && (this._testHarness
/*  509 */         .isProcessing() || this._testHarness.isReadyToFire()))) {
/*      */         
/*  511 */         _logger.info("The current chain is cancelable, proceeding with reverse");
/*  512 */         this.currentChain_.handleChainReverse();
/*      */       } else {
/*      */         
/*  515 */         _logger.info("The current chain is not cancelable, running cancel denied chain");
/*  516 */         this.currentChain_.stackChain(this._opChainFactory.getCancelDeniedChain());
/*  517 */         return false;
/*      */       } 
/*      */     }
/*      */     
/*  521 */     setCurrentChain(this._opChainFactory.getOpChain(currentChainKey));
/*  522 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setCurrentChain(IOpChain argChain) {
/*  531 */     this.currentChain_ = argChain;
/*  532 */     this.currentEvent_ = null;
/*  533 */     if (this.currentChain_ != null) {
/*  534 */       this.currentChain_.setProcessor(this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processDefaultContext() {
/*  544 */     RollbackElement elem = this.rollbackStack_.peek();
/*  545 */     if (elem != null) {
/*  546 */       processRollbackContext(elem.getUIContext());
/*      */     }
/*      */   }
/*      */   
/*      */   void processRollback(OpChainKey currentChainKey) {
/*  551 */     OpChainKey runChain = currentChainKey;
/*  552 */     IUIContext runContext = this.currentUIContext_;
/*  553 */     IMenuItem runMenu = null;
/*      */     
/*  555 */     if (this.rollbackStack_.getSize() > 1) {
/*  556 */       this.rollbackStack_.pop();
/*      */       
/*  558 */       RollbackElement elem = this.rollbackStack_.peek();
/*  559 */       runChain = elem.getChainKey();
/*  560 */       runContext = elem.getUIContext();
/*  561 */       runMenu = elem.getMenu();
/*      */     } 
/*      */ 
/*      */     
/*  565 */     processRollbackContext(runContext);
/*      */ 
/*      */     
/*  568 */     if (runMenu != null) {
/*  569 */       IMenuModel menuModel = this._modeController.getStationModel().getMenuModel();
/*  570 */       menuModel.setCurrentMenu(runMenu);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  575 */     this.defaultChainKey_ = runChain;
/*  576 */     processChain(runChain);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  585 */     if (MENU_TRAVERSAL_FORWARD.equals(runChain)) {
/*  586 */       this.currentChain_.setRollbackLevel(this.rollbackStack_.getMaximumLevel());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processRollbackContext(IUIContext argUIContext) {
/*  596 */     if (argUIContext != null) {
/*  597 */       UIContextDescriptor uIContextDescriptor = new UIContextDescriptor(argUIContext, 17L);
/*  598 */       this._modeController.getUiController().handleContextTransition((IUIContextDescriptor)uIContextDescriptor, null);
/*      */     } 
/*      */   }
/*      */   
/*      */   void processRollbackToTop() {
/*  603 */     processRollbackToTop(true);
/*      */   }
/*      */   
/*      */   void processRollbackToTop(boolean argProcessTopChain) {
/*  607 */     OpChainKey runChain = this.defaultChainKey_;
/*  608 */     IUIContext runContext = this.currentUIContext_;
/*  609 */     RollbackElement top = null;
/*      */     
/*  611 */     while (this.rollbackStack_.getSize() > 0) {
/*  612 */       RollbackElement elem = this.rollbackStack_.pop();
/*  613 */       runChain = elem.getChainKey();
/*  614 */       runContext = elem.getUIContext();
/*  615 */       top = elem;
/*      */     } 
/*      */ 
/*      */     
/*  619 */     processRollbackContext(runContext);
/*      */ 
/*      */ 
/*      */     
/*  623 */     this.defaultChainKey_ = runChain;
/*      */     
/*  625 */     if (argProcessTopChain) {
/*  626 */       processChain(runChain);
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  633 */       this.rollbackStack_.push(top, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void runChain() {
/*  643 */     IOpResponse opResponse = null;
/*  644 */     boolean stopped = false;
/*      */     
/*  646 */     if (_debugLogging) {
/*  647 */       _logger.debug("Handling chain run action " + this.currentEvent_);
/*      */     }
/*  649 */     deregisterForEvents();
/*      */ 
/*      */     
/*  652 */     this.events_.post(IOpChainProcessor.OP_CHAIN_PROCESSOR_STARTED);
/*      */ 
/*      */     
/*  655 */     _timer.markOut("Running Chain...");
/*      */     
/*  657 */     while (!stopped) {
/*  658 */       if (this.currentChain_ == null || this.currentChain_.isComplete())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  664 */         if (this.evtQueue_.isEmpty() && getDefaultChainKey() != null) {
/*  665 */           if (getDefaultChainKey() != null) {
/*  666 */             adjustDefaultChain();
/*      */             
/*  668 */             IOpChain defaultChain = this._opChainFactory.getOpChain(getDefaultChainKey());
/*  669 */             this.flowLogger_.info((IOperation)defaultChain, defaultChain.getTraversalStrategyType(), true);
/*      */             
/*  671 */             setCurrentChain(defaultChain);
/*      */           } else {
/*      */             
/*  674 */             setCurrentChain(null);
/*      */           } 
/*      */         } else {
/*      */           
/*  678 */           setCurrentChain(null);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  683 */       if (this.currentChain_ != null) {
/*  684 */         if (_debugLogging) {
/*  685 */           _logger.debug("Running exec on current chain " + this.currentChain_.getChainKey());
/*      */         }
/*      */         
/*  688 */         opResponse = this.currentChain_.handleOpExec(this.currentEvent_);
/*      */         
/*  690 */         if (opResponse == null) {
/*      */           
/*  692 */           _logger.error("opResponse is null");
/*  693 */           opResponse = this._opResponseHelper.errorNotifyResponse();
/*      */         } 
/*      */         
/*  696 */         OpStatus opStatus = opResponse.getOpStatus();
/*  697 */         stopped = opStatus.getPauseChain();
/*      */ 
/*      */         
/*  700 */         if (opStatus.isError()) {
/*      */           
/*  702 */           _logger.info("Operation completed with status of error");
/*  703 */           this.events_.post(IOpChain.OP_CHAIN_NOT_COMPLETE, opStatus);
/*  704 */           handleOpCancel();
/*      */         }
/*  706 */         else if (OpStatus.INCOMPLETE.equals(opStatus)) {
/*  707 */           _logger.info("Operation completed with status of incomplete");
/*  708 */           this.events_.post(IOpChain.OP_CHAIN_NOT_COMPLETE, opStatus);
/*      */         }
/*  710 */         else if (OpStatus.INCOMPLETE_HALT.equals(opStatus)) {
/*  711 */           _logger.info("Operation completed with status of incomplete");
/*  712 */           this.events_.post(IOpChain.OP_CHAIN_NOT_COMPLETE, opStatus);
/*  713 */           registerForEvents(this.currentChain_);
/*      */ 
/*      */           
/*  716 */           stopped = true;
/*      */         }
/*  718 */         else if (opStatus.isComplete() && this.currentChain_.isComplete() && TraversalStrategyType.FIND_BREAKPOINT
/*  719 */           .equals(this.currentChain_.getTraversalStrategyType())) {
/*  720 */           this.events_.post(IOpChain.OP_CHAIN_COMPLETE, new OpChainPayload(this.currentChain_));
/*      */ 
/*      */           
/*  723 */           if (this.currentRollBackChainKey_ != null) {
/*      */ 
/*      */             
/*  726 */             this.currentChain_.setTraversalStrategyType(TraversalStrategyType.FORWARD);
/*      */ 
/*      */             
/*  729 */             this.currentChain_.stackChain(this._opChainFactory.getOpChain(this.currentRollBackChainKey_));
/*      */ 
/*      */             
/*  732 */             this.currentRollBackChainKey_ = null;
/*  733 */             this.preRollbackChainKey_ = null;
/*      */           }
/*  735 */           else if (this.preRollbackChainKey_ != null && this.preRollbackChainKey_.equals(this.defaultChainKey_)) {
/*      */             
/*  737 */             processRollback(this.preRollbackChainKey_);
/*  738 */             this.preRollbackChainKey_ = null;
/*      */           } else {
/*      */             
/*  741 */             processDefaultContext();
/*  742 */             processChain(this.defaultChainKey_);
/*      */           }
/*      */         
/*  745 */         } else if (!opStatus.isComplete() || !this.currentChain_.isComplete()) {
/*  746 */           if (TraversalStrategyType.REVERSE.equals(this.currentChain_.getTraversalStrategyType())) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  755 */             processDefaultContext();
/*      */           
/*      */           }
/*  758 */           else if (opStatus.isBreakpointFound()) {
/*      */             
/*  760 */             this.currentRollBackChainKey_ = null;
/*  761 */             this.preRollbackChainKey_ = null;
/*      */           } 
/*      */         } 
/*  764 */         processRequests(opResponse);
/*      */ 
/*      */         
/*  767 */         if (this.currentChain_ != null && 
/*  768 */           isPromptingUser(opResponse, ((DefaultOpChain)this.currentChain_).getCurrentOp()) && this.opChainType_ == OpChainProcessorType.USER)
/*      */         {
/*      */ 
/*      */           
/*  772 */           this._cheetahBridge.notifyRequestReady(opResponse);
/*      */           
/*  774 */           this._actionLogger.logAllActions();
/*      */           
/*  776 */           if (this._captureHarness.isEnabled()) {
/*  777 */             this._captureHarness.setReadyToCapture((IOperation)this.currentChain_);
/*      */           }
/*      */           
/*  780 */           if (this._testHarness.isEnabled()) {
/*  781 */             this._testHarness.startIfReadyAndLoad((IOperation)this.currentChain_, opResponse);
/*      */           }
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/*  787 */         stopped = true;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  801 */       _timer.markOut(new Object[] { "OPC DONE AT STEP FOR ", this.currentChain_ });
/*      */       
/*  803 */       this.currentEvent_ = null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  809 */     if (this._testHarness.isEnabled() && this.initialized_) {
/*  810 */       this._testHarness.dispatchTestEvent();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  816 */     this.events_.post(OP_CHAIN_PROCESSOR_COMPLETE);
/*      */   }
/*      */   
/*      */   private void adjustDefaultChain() {
/*  820 */     IMenuItem newMenu = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  826 */     while (this.rollbackStack_.peek() != null) {
/*  827 */       RollbackElement elem = this.rollbackStack_.peek();
/*      */       
/*  829 */       if (MENU_TRAVERSAL_FORWARD.equals(elem.getChainKey())) {
/*  830 */         IMenuItem menuItem = elem.getMenu();
/*      */         
/*  832 */         if (menuItem.isSticky()) {
/*  833 */           newMenu = menuItem;
/*      */           
/*      */           break;
/*      */         } 
/*  837 */         this.rollbackStack_.pop();
/*      */         
/*  839 */         if (this.rollbackStack_.peek() != null) {
/*  840 */           OpChainKey newDefaultChain = this.rollbackStack_.peek().getChainKey();
/*      */           
/*  842 */           if (newDefaultChain != null) {
/*  843 */             this.defaultChainKey_ = newDefaultChain;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  853 */     if (newMenu != null) {
/*  854 */       IMenuModel menuModel = this._modeController.getStationModel().getMenuModel();
/*  855 */       menuModel.setCurrentMenu(newMenu);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void deregisterForEvents() {
/*  863 */     if (this.evtTypes_ != null) {
/*  864 */       for (IXstEventType element : this.evtTypes_) {
/*  865 */         this._modeController.getEventRouter().removeListener((IXstEventListener)this, element);
/*      */       }
/*      */     }
/*      */     
/*  869 */     if (this.evtInterface_ != null) {
/*  870 */       for (Class<?> element : this.evtInterface_) {
/*  871 */         this._modeController.getEventRouter().removeListener((IXstEventListener)this, element);
/*      */       }
/*      */     }
/*      */     
/*  875 */     this.evtTypes_ = null;
/*  876 */     this.evtInterface_ = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private OpChainKey getDefaultChainKey() {
/*  885 */     return this.defaultChainKey_;
/*      */   }
/*      */   
/*      */   private IXstEventListener getRequestEventListener(IOpRequest request) {
/*  889 */     if (!(request instanceof RunChainRequest)) {
/*  890 */       return (IXstEventListener)this;
/*      */     }
/*      */     
/*  893 */     IXstEventListener listener = ((RunChainRequest)request).getEventListener();
/*  894 */     return (listener != null) ? listener : (IXstEventListener)this;
/*      */   }
/*      */   
/*      */   private IXstEvent getTrigger(ITriggeredAction argEvent) {
/*  898 */     IXstEvent trigger = argEvent.getTrigger();
/*      */     
/*  900 */     if (trigger instanceof IHoldsConfigParameters && argEvent instanceof IHoldsConfigParameters) {
/*      */ 
/*      */       
/*  903 */       IHoldsConfigParameters t = (IHoldsConfigParameters)trigger;
/*  904 */       IHoldsConfigParameters e = (IHoldsConfigParameters)argEvent;
/*  905 */       List<ParameterConfig> parameters = e.getParameters();
/*      */       
/*  907 */       if (!parameters.isEmpty()) {
/*  908 */         t.setParameters(parameters);
/*      */       }
/*      */     } 
/*      */     
/*  912 */     return trigger;
/*      */   }
/*      */   
/*      */   private void handleBackup() {
/*  916 */     _logger.debug("Handling op chain backup ");
/*      */ 
/*      */     
/*  919 */     if (this.currentChain_ == null) {
/*      */       return;
/*      */     }
/*  922 */     if (this.currentChain_.isCurrentOpCancelable()) {
/*  923 */       _logger.debug("Really handling backup ");
/*      */ 
/*      */       
/*  926 */       if (this.currentChain_.canceling()) {
/*      */ 
/*      */         
/*  929 */         this.currentRollBackChainKey_ = this.currentChain_.getRollbackChainKey();
/*  930 */         this.preRollbackChainKey_ = this.currentChain_.getChainKey();
/*  931 */         this.currentChain_.setTraversalStrategyType(TraversalStrategyType.FIND_BREAKPOINT);
/*  932 */         this.currentEvent_ = null;
/*      */       } 
/*      */     } else {
/*      */       
/*  936 */       if (_debugLogging) {
/*  937 */         _logger.debug("Denying cancel op action for [" + this.currentChain_ + "]");
/*      */       }
/*      */       
/*  940 */       this.currentChain_.stackChain(this._opChainFactory.getCancelDeniedChain());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleChainStack(IXstChainAction argEvent) {
/*  950 */     if (this.currentChain_ != null) {
/*  951 */       IOpChain opc = this._opChainFactory.getOpChain(argEvent.getOpChainKey());
/*  952 */       opc.setRequired(argEvent.isRequired());
/*  953 */       this.currentChain_.stackChain(opc);
/*      */     } else {
/*      */       
/*  956 */       handleChainStart(argEvent);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleChainStart(IXstChainAction argEvent) {
/*  967 */     this.flowLogger_.clearProcessDepth();
/*  968 */     processChain(argEvent.getOpChainKey());
/*      */     
/*  970 */     this.currentEvent_ = (IXstEvent)argEvent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleOpCancel() {
/*  979 */     _logger.debug("Handling op chain action for cmd ");
/*      */     
/*  981 */     if (this.currentChain_.isCurrentOpCancelable()) {
/*  982 */       _logger.debug("Really handling cancel chain action for cmd ");
/*  983 */       this.currentChain_.setTraversalStrategyType(TraversalStrategyType.REVERSE);
/*      */     }
/*      */     else {
/*      */       
/*  987 */       _logger.warn("Denying cancel op action for cmd ");
/*  988 */       this.currentChain_.stackChain(this._opChainFactory.getCancelDeniedChain());
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean isBusy() {
/*  993 */     boolean busy = false;
/*      */     
/*  995 */     synchronized (this.busyLock_) {
/*  996 */       busy = this.busyFlag_;
/*      */     } 
/*      */     
/*  999 */     if (busy) {
/* 1000 */       _logger.debug("OCP is busy.");
/*      */     }
/*      */     
/* 1003 */     return busy;
/*      */   }
/*      */   
/*      */   private boolean isPromptingUser(IOpResponse argResponse, IOperation argOp) {
/* 1007 */     boolean result = false;
/*      */     
/* 1009 */     if (argResponse != null && !isNonUiRequest(argResponse)) {
/* 1010 */       boolean promptResponse = isUserPromptRequest(argResponse);
/*      */       
/* 1012 */       if (argResponse.getOpStatus().getPauseChain() || (promptResponse && argResponse
/* 1013 */         .getOpStatus().isIncomplete()))
/*      */       {
/* 1015 */         if (argOp instanceof ForceMenuSelectionOp || (argOp != null && argOp
/* 1016 */           .getContextDescriptor() != null && !argResponse.hasRequests())) {
/*      */           
/* 1018 */           result = true;
/*      */         }
/* 1020 */         else if (promptResponse) {
/*      */           
/* 1022 */           result = true;
/*      */         }
/* 1024 */         else if (argResponse.getOpStatus().isIncomplete() && !argResponse.hasRequests()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1038 */           this._cheetahBridge.undoReset();
/* 1039 */           result = true;
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1045 */     if (_debugLogging) {
/* 1046 */       StringBuilder sb = new StringBuilder();
/*      */       
/* 1048 */       sb.append("\nRESULT = " + result);
/* 1049 */       if (argOp != null) {
/* 1050 */         sb.append("\nOp: " + argOp.getClass().getSimpleName());
/*      */       } else {
/*      */         
/* 1053 */         sb.append("\nOp: argOp is null");
/*      */       } 
/*      */       
/* 1056 */       if (argResponse != null) {
/* 1057 */         sb.append("\nResp status: " + argResponse.getOpStatus() + " (pause chain = " + argResponse
/* 1058 */             .getOpStatus().getPauseChain() + ")");
/* 1059 */         sb.append("\nRequests: " + argResponse.getOpRequests().size());
/*      */         
/* 1061 */         for (IOpRequest request : argResponse.getOpRequests()) {
/* 1062 */           sb.append("\n    " + request.getClass().getSimpleName());
/*      */         }
/*      */       } else {
/*      */         
/* 1066 */         sb.append("\nResp: argResponse is null");
/*      */       } 
/* 1068 */       _logger.debug(sb.toString());
/*      */     } 
/*      */ 
/*      */     
/* 1072 */     return result;
/*      */   }
/*      */   
/*      */   private IOpRequest makeErrorPromptRequest() {
/* 1076 */     PromptKey promptKey = PK_FRAMEWORK_ERROR;
/* 1077 */     PromptConfig promptConfig = this._promptConfigHelper.getPromptConfig(promptKey, null);
/* 1078 */     return (IOpRequest)new PromptRequest(promptKey, promptConfig, null, new dtv.i18n.IFormattable[0]);
/*      */   }
/*      */   
/*      */   private void processRequests(IOpResponse opResponse) {
/* 1082 */     List<IOpRequest> opRequests = opResponse.getOpRequests();
/*      */     
/* 1084 */     if (_debugLogging) {
/* 1085 */       _logger.debug("Handling operation requests. resp= " + opResponse);
/*      */     }
/*      */     
/* 1088 */     if (opRequests != null) {
/* 1089 */       for (IOpRequest request : opRequests) {
/*      */         try {
/* 1091 */           if (_debugLogging) {
/* 1092 */             _logger.debug("Processing op request type [" + request + "].");
/*      */           }
/*      */           
/* 1095 */           IOpReqHandler reqHandler = this._opReqHandlerFactory.getReqHandler(request.getRequestType());
/* 1096 */           reqHandler.handleRequest(request, getRequestEventListener(request), this._modeController);
/*      */         }
/* 1098 */         catch (Throwable ex) {
/* 1099 */           _logger.error("A problem occurred handling request " + request, ex);
/* 1100 */           _adminLogger.error("A problem occurred handling request " + request, ex);
/* 1101 */           IOpRequest errorRequest = makeErrorPromptRequest();
/*      */           
/*      */           try {
/* 1104 */             IOpReqHandler reqHandler = this._opReqHandlerFactory.getReqHandler(errorRequest.getRequestType());
/* 1105 */             reqHandler.handleRequest(errorRequest, getRequestEventListener(errorRequest), this._modeController);
/*      */           }
/* 1107 */           catch (Throwable ex1) {
/* 1108 */             _logger.error("A problem occurred displaying the error that was triggered by the original request " + request, ex1);
/*      */             
/* 1110 */             _adminLogger.error("A problem occurred displaying the error that was triggered by the original request " + request, ex1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void registerForEvents(IOpChain argCurrentChain) {
/* 1121 */     IXstEventType[] types = argCurrentChain.getObservedEvents();
/* 1122 */     if (types != null && (
/* 1123 */       this.evtTypes_ == null || !Arrays.equals((Object[])types, (Object[])this.evtTypes_))) {
/* 1124 */       int addCt = 0;
/*      */ 
/*      */       
/* 1127 */       if (this.evtTypes_ != null && this.evtTypes_.length > 0) {
/* 1128 */         StringBuilder sb = new StringBuilder();
/* 1129 */         sb.append("might be losing the fact that we registered for event types\n\t IXstEventType[]{");
/*      */         
/* 1131 */         for (IXstEventType t : this.evtTypes_) {
/* 1132 */           if (t == null) {
/* 1133 */             sb.append(t);
/*      */           } else {
/*      */             
/* 1136 */             sb.append(t.getClass().getName());
/* 1137 */             sb.append(".");
/* 1138 */             sb.append(t);
/*      */           } 
/* 1140 */           sb.append(",");
/*      */         } 
/*      */         
/* 1143 */         sb.setLength(sb.length() - 1);
/* 1144 */         sb.append("}");
/* 1145 */         _logger.warn(sb);
/*      */       } 
/*      */ 
/*      */       
/* 1149 */       this.evtTypes_ = new IXstEventType[types.length];
/*      */       
/* 1151 */       for (IXstEventType type : types) {
/*      */         
/* 1153 */         if (this._modeController.getEventRouter().addListener((IXstEventListener)this, type)) {
/* 1154 */           this.evtTypes_[addCt++] = type;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1162 */     Class<?>[] interfaces = argCurrentChain.getObservedEventInterfaces();
/* 1163 */     if (interfaces != null && (
/* 1164 */       this.evtInterface_ == null || !Arrays.equals((Object[])interfaces, (Object[])this.evtInterface_))) {
/* 1165 */       int addCt = 0;
/*      */ 
/*      */       
/* 1168 */       if (this.evtInterface_ != null && this.evtInterface_.length > 0) {
/* 1169 */         StringBuffer sb = new StringBuffer();
/* 1170 */         sb.append("might be losing the fact that we registered for event types\n\t Class[]{");
/*      */         
/* 1172 */         for (Class<?> c : this.evtInterface_) {
/* 1173 */           if (c == null) {
/* 1174 */             sb.append(c);
/*      */           } else {
/*      */             
/* 1177 */             sb.append(c.getName());
/*      */           } 
/*      */           
/* 1180 */           sb.append(",");
/*      */         } 
/*      */         
/* 1183 */         sb.setLength(sb.length() - 1);
/* 1184 */         sb.append("}");
/* 1185 */         _logger.warn(sb);
/*      */       } 
/*      */ 
/*      */       
/* 1189 */       this.evtInterface_ = new Class[interfaces.length];
/*      */       
/* 1191 */       for (Class<?> interface1 : interfaces) {
/*      */         
/* 1193 */         if (this._modeController.getEventRouter().addListener((IXstEventListener)this, interface1)) {
/* 1194 */           this.evtInterface_[addCt++] = interface1;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setBusy(boolean newValue) {
/* 1203 */     synchronized (this.busyLock_) {
/* 1204 */       this.busyFlag_ = newValue;
/* 1205 */       _logger.debug(newValue ? "OCP is now busy." : "OCP is no longer busy.");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ContextChangeListener
/*      */     implements IContextChangeListener
/*      */   {
/*      */     public void handleContextChange(ContextChangeEvent argEvent) {
/* 1221 */       IUIContext newContext = (IUIContext)argEvent.getNewContext();
/*      */       
/* 1223 */       if (newContext != null) {
/* 1224 */         OpChainProcessor.this.flowLogger_.info("Context|Menu", newContext
/* 1225 */             .getName() + "|" + newContext.getMenuKey(), null, null, null);
/*      */       }
/*      */       
/* 1228 */       OpChainProcessor.this.currentUIContext_ = newContext;
/*      */     }
/*      */   }
/*      */   
/*      */   class LevelStack {
/* 1233 */     private final Stack<OpChainProcessor.LevelStackObject> stack_ = new Stack<>();
/*      */     
/*      */     public int getMaximumLevel() {
/* 1236 */       if (this.stack_.empty()) {
/* 1237 */         return -1;
/*      */       }
/*      */       
/* 1240 */       return ((OpChainProcessor.LevelStackObject)this.stack_.peek()).level_;
/*      */     }
/*      */     
/*      */     public int getSize() {
/* 1244 */       return this.stack_.size();
/*      */     }
/*      */     
/*      */     public Stack<?> getStack() {
/* 1248 */       return (Stack)this.stack_.clone();
/*      */     }
/*      */     
/*      */     public boolean isEmpty() {
/* 1252 */       return this.stack_.isEmpty();
/*      */     }
/*      */     
/*      */     public OpChainProcessor.RollbackElement peek() {
/* 1256 */       return ((OpChainProcessor.LevelStackObject)this.stack_.peek()).source_;
/*      */     }
/*      */     
/*      */     public OpChainProcessor.RollbackElement pop() {
/* 1260 */       return ((OpChainProcessor.LevelStackObject)this.stack_.pop()).source_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void push(OpChainProcessor.RollbackElement object, int level) {
/* 1267 */       while (!isEmpty()) {
/*      */ 
/*      */ 
/*      */         
/* 1271 */         OpChainProcessor.LevelStackObject obj = this.stack_.peek();
/*      */         
/* 1273 */         if (obj.level_ >= level) {
/* 1274 */           pop();
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*      */         break;
/*      */       } 
/* 1281 */       this.stack_.push(new OpChainProcessor.LevelStackObject(object, level));
/*      */     }
/*      */   }
/*      */   
/*      */   class LevelStackObject {
/*      */     final int level_;
/*      */     final OpChainProcessor.RollbackElement source_;
/*      */     
/*      */     public LevelStackObject(OpChainProcessor.RollbackElement source, int level) {
/* 1290 */       this.level_ = level;
/* 1291 */       this.source_ = source;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class RollbackElement
/*      */   {
/*      */     private final OpChainKey chainKey_;
/*      */ 
/*      */ 
/*      */     
/*      */     private final IMenuItem menuNode_;
/*      */ 
/*      */ 
/*      */     
/*      */     private final IUIContext uiContext_;
/*      */ 
/*      */ 
/*      */     
/*      */     public RollbackElement(OpChainKey argChainKey, IUIContext argUIContext, IMenuItem argMenu) {
/* 1313 */       this.chainKey_ = argChainKey;
/* 1314 */       this.uiContext_ = argUIContext;
/* 1315 */       this.menuNode_ = argMenu;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public OpChainKey getChainKey() {
/* 1323 */       return this.chainKey_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IMenuItem getMenu() {
/* 1331 */       return this.menuNode_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IUIContext getUIContext() {
/* 1340 */       return this.uiContext_;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */