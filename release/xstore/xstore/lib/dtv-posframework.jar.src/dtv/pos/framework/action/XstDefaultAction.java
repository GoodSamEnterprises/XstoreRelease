/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.event.EventDescriptor;
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.constraint.NameConstraint;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.action.access.AccessEvaluators;
/*     */ import dtv.pos.framework.action.type.DummyActionKey;
/*     */ import dtv.pos.framework.logging.ProcessLogger;
/*     */ import dtv.pos.framework.op.req.SecurityRequest;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IAccessEvaluator;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.action.IXstMenuAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.event.IXstEventType;
/*     */ import dtv.pos.iframework.op.req.IOpReqHandler;
/*     */ import dtv.pos.iframework.op.req.IOpReqHandlerFactory;
/*     */ import dtv.pos.iframework.op.req.IOpRequest;
/*     */ import dtv.pos.iframework.security.ISecureAction;
/*     */ import dtv.pos.iframework.security.ISecurityResponse;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.pos.ui.action.AbstractPosAction;
/*     */ import dtv.ui.temp.UIAccessLevel;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.Action;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class XstDefaultAction
/*     */   extends AbstractPosAction
/*     */   implements IXstAction, ISecureAction
/*     */ {
/*  49 */   public static final EventEnum EVALUATE_VISIBILITY_EVENT = new EventEnum("evaluate Visibility");
/*  50 */   public static final IEventConstraint EVALUATE_VISIBILITY_CONSTRAINT = (IEventConstraint)new NameConstraint(EVALUATE_VISIBILITY_EVENT);
/*     */   
/*  52 */   public static final EventDescriptor EVALUATE_VISIBILITY_DESCRIPTOR = new EventDescriptor("evaluateVisibility");
/*     */   
/*  54 */   private static final Logger logger_ = Logger.getLogger(XstDefaultAction.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   @Inject
/*     */   private ProcessLogger flowLogger_;
/*     */   
/*     */   @Inject
/*     */   protected IOpReqHandlerFactory _opReqHandlerFactory;
/*     */   
/*     */   @Inject
/*     */   protected Provider<IModeController> _modeProvider;
/*     */   
/*     */   @Inject
/*     */   protected FormattableFactory _formattables;
/*  69 */   private final Set<String> privileges_ = new HashSet<>();
/*     */   
/*     */   private Object source_;
/*     */   
/*     */   private IXstEventListener _eventListener;
/*  74 */   private IAccessEvaluator accessWorker_ = AccessEvaluators.getNoRulesEvaluator();
/*     */   
/*     */   private Object[] data_;
/*     */   private IXstActionKey key_;
/*     */   private ActionListener listener_;
/*  79 */   private List<ParameterConfig> parameters_ = new ArrayList<>();
/*  80 */   private List<Action> postActions_ = null;
/*     */   private IXstActionType type_;
/*  82 */   private IAccessLevel visibility_ = null;
/*  83 */   private List<IVisibilityRule> visibilityRules_ = new ArrayList<>();
/*     */   private boolean _actionListenerHandled = false;
/*     */   private String keywords_;
/*     */   private String iconKey_;
/*     */   private boolean _dataIsFinal = false;
/*     */   
/*     */   public XstDefaultAction() {
/*  90 */     this((IXstActionType)null, (IXstActionKey)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstDefaultAction(IXstActionType argType, IXstActionKey argKey) {
/*  95 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */ 
/*     */ 
/*     */     
/*  99 */     setType((argType == null) ? new IXstActionType() {  } : argType);
/* 100 */     setActionKey((argKey == null) ? (IXstActionKey)new DummyActionKey() : argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent event) {
/* 106 */     if (getActionName() != null) {
/* 107 */       this.flowLogger_.info("Action", "<click>", null, null, " -> " + getName() + " [" + getActionKey() + "]");
/*     */     }
/*     */     
/* 110 */     this._actionListenerHandled = false;
/*     */     
/* 112 */     super.actionPerformed(event);
/*     */ 
/*     */ 
/*     */     
/* 116 */     if (this.postActions_ != null) {
/* 117 */       for (Action postAction : this.postActions_) {
/* 118 */         postAction.actionPerformed(event);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 123 */     actionPerformedImpl(event);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     if (this.listener_ != null && !this._actionListenerHandled) {
/* 129 */       IXstMenuAction iXstMenuAction = getNewEventAction(event);
/* 130 */       getEventListener().handleXstEvent((IXstEvent)iXstMenuAction);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPostAction(Action argAction) {
/* 137 */     if (argAction != null) {
/* 138 */       if (this.postActions_ == null) {
/* 139 */         this.postActions_ = new ArrayList<>();
/*     */       }
/* 141 */       this.postActions_.add(argAction);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPrivilege(String argType) {
/* 149 */     this.privileges_.add(argType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearPostActions() {
/* 155 */     if (this.postActions_ != null) {
/* 156 */       this.postActions_.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearPrivilege() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public IAccessLevel evaluateVisibility() {
/* 167 */     setVisibility(this.accessWorker_.evaluateAccess(this));
/* 168 */     return getVisibility();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey getActionKey() {
/* 174 */     return this.key_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionListener getActionListener() {
/* 180 */     return this.listener_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getData() {
/* 186 */     return (this.data_ == null || this.data_.length == 0) ? null : this.data_[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDataIsFinal() {
/* 195 */     return this._dataIsFinal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getDataSet() {
/* 201 */     return this.data_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIconKey() {
/* 206 */     return this.iconKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeywords() {
/* 212 */     return this.keywords_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 218 */     return (getActionName() != null) ? getActionName().toString(OutputContextType.VIEW) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ParameterConfig> getParameters() {
/* 224 */     return this.parameters_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilege() {
/* 230 */     String[] privileges = getPrivileges();
/* 231 */     return (privileges != null && privileges.length > 0) ? privileges[0] : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getPrivileges() {
/* 237 */     if (this.privileges_ != null && this.privileges_.size() > 0) {
/* 238 */       return this.privileges_.<String>toArray(new String[0]);
/*     */     }
/* 240 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getSource() {
/* 246 */     return this.source_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringData() {
/* 252 */     String stringData = "";
/*     */     
/* 254 */     if (getData() != null) {
/* 255 */       stringData = getData().toString();
/*     */     }
/* 257 */     return stringData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstEventType getType() {
/* 263 */     return (IXstEventType)this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAccessLevel getVisibility() {
/* 269 */     return (IAccessLevel)getValue("VisibilitySetting");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IVisibilityRule> getVisibilityRules() {
/* 275 */     return this.visibilityRules_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 281 */     int result = 17;
/*     */     
/* 283 */     result = 37 * result + getActionKey().hashCode();
/* 284 */     result = 37 * result + getType().hashCode();
/*     */     
/* 286 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 292 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessDenied(ISecurityResponse argResponse) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessGranted(ISecurityResponse argResponse) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void removePostAction(Action argAction) {
/* 306 */     if (argAction != null && this.postActions_ != null) {
/* 307 */       this.postActions_.remove(argAction);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionKey(IXstActionKey argKey) {
/* 317 */     this.key_ = (argKey == null) ? (IXstActionKey)new DummyActionKey() : argKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionListener(ActionListener listener) {
/* 323 */     this.listener_ = listener;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setActionNameKey(String argKey) {
/* 328 */     setActionName(this._formattables.getSimpleFormattable(argKey));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setData(Object argData) {
/* 334 */     if (this.data_ != null && this._dataIsFinal) {
/*     */       return;
/*     */     }
/*     */     
/* 338 */     if (argData instanceof Object[]) {
/* 339 */       this.data_ = (Object[])argData;
/*     */     } else {
/*     */       
/* 342 */       this.data_ = new Object[1];
/* 343 */       this.data_[0] = argData;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataIsFinal(boolean argIsDataFinal) {
/* 353 */     this._dataIsFinal = argIsDataFinal;
/*     */   }
/*     */   
/*     */   public void setEventListener(IXstEventListener argListener) {
/* 357 */     this._eventListener = argListener;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIconKey(String argIconKey) {
/* 362 */     this.iconKey_ = argIconKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeywords(String argKeywords) {
/* 368 */     this.keywords_ = argKeywords;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameters(List<ParameterConfig> params) {
/* 374 */     this.parameters_ = params;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisibility(IAccessLevel argVisibility) {
/* 380 */     if (this.visibility_ == argVisibility) {
/* 381 */       if (!isEnabled() && !argVisibility.isViewable()) {
/*     */         return;
/*     */       }
/* 384 */       if (isEnabled() && argVisibility.isViewable()) {
/*     */         return;
/*     */       }
/*     */     } 
/* 388 */     this.visibility_ = argVisibility;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 393 */     if (!argVisibility.isViewable()) {
/* 394 */       setEnabled(false);
/*     */     } else {
/*     */       
/* 397 */       setEnabled(true);
/*     */     } 
/* 399 */     putValue("VisibilitySetting", argVisibility);
/*     */     
/* 401 */     setAccessLevel(convertVisibilityToUiAccessLevel(argVisibility));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisibilityRules(List<IVisibilityRule> visibilityRules, boolean evaluateImmediately) {
/* 407 */     this.visibilityRules_ = (visibilityRules != null) ? visibilityRules : new ArrayList<>();
/* 408 */     initVisibilityRules();
/*     */     
/* 410 */     if (evaluateImmediately) {
/* 411 */       evaluateVisibility();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 418 */     return "[" + getActionKey() + "::" + getType() + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformedImpl(ActionEvent event) {
/* 427 */     String[] privileges = getPrivileges();
/*     */     
/* 429 */     if (privileges == null || privileges.length == 0) {
/* 430 */       notifyAccessGranted((ISecurityResponse)null);
/*     */     } else {
/*     */       
/* 433 */       SecurityRequest securityRequest = SecurityRequest.getActionRequest(this);
/*     */       
/* 435 */       if (this.listener_ != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 443 */         IXstMenuAction menuAction = getNewEventAction(event);
/* 444 */         securityRequest.setPostSuccessRequest((IOpRequest)menuAction);
/* 445 */         this._actionListenerHandled = true;
/*     */       } 
/*     */       
/* 448 */       IOpReqHandler securityHandler = this._opReqHandlerFactory.getReqHandler(securityRequest.getRequestType());
/* 449 */       securityHandler.handleRequest((IOpRequest)securityRequest, getEventListener(), (IModeController)this._modeProvider.get());
/*     */     } 
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
/*     */   protected void addVisibilityRule(IVisibilityRule visibilityRule, boolean evaluateImmediately) {
/* 464 */     if (visibilityRule != null) {
/* 465 */       this.visibilityRules_.add(visibilityRule);
/* 466 */       initVisibilityRules();
/*     */       
/* 468 */       if (evaluateImmediately) {
/* 469 */         evaluateVisibility();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected IXstEventListener getEventListener() {
/* 475 */     return (this._eventListener != null) ? this._eventListener : (IXstEventListener)((IModeController)this._modeProvider.get()).getEventRouter();
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
/*     */   protected IXstMenuAction getNewEventAction(ActionEvent argCurrentEvent) {
/* 488 */     ActionEvent newEvent = new ActionEvent(this, argCurrentEvent.getID(), argCurrentEvent.getActionCommand(), argCurrentEvent.getWhen(), argCurrentEvent.getModifiers());
/* 489 */     IXstMenuAction menuAction = new XstMenuAction(newEvent);
/* 490 */     menuAction.setActionListener(this.listener_);
/* 491 */     return menuAction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private UIAccessLevel convertVisibilityToUiAccessLevel(IAccessLevel visibility) {
/* 497 */     switch (visibility.getLevel()) {
/*     */       
/*     */       case 2147483647:
/* 500 */         return UIAccessLevel.GRANTED;
/*     */       
/*     */       case 30:
/* 503 */         return UIAccessLevel.DENIED_OVERRIDABLE;
/*     */       
/*     */       case 10:
/*     */       case 20:
/* 507 */         return UIAccessLevel.DENIED;
/*     */     } 
/*     */     
/* 510 */     logger_.warn("No " + UIAccessLevel.class.getName() + " defined for " + visibility.getName());
/* 511 */     return UIAccessLevel.DENIED;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initVisibilityRules() {
/* 518 */     this.accessWorker_ = AccessEvaluators.getEvaluator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setType(IXstActionType argType) {
/* 526 */     this.type_ = (argType == null) ? new IXstActionType() {  } : argType;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstDefaultAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */