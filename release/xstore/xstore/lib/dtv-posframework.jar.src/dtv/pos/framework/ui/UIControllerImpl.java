/*      */ package dtv.pos.framework.ui;
/*      */ 
/*      */ import dtv.i18n.FormattableFactory;
/*      */ import dtv.pos.common.ConfigurationMgr;
/*      */ import dtv.pos.common.FormKey;
/*      */ import dtv.pos.framework.StationController;
/*      */ import dtv.pos.framework.action.IXstActionFactory;
/*      */ import dtv.pos.framework.action.type.XstKeyStroke;
/*      */ import dtv.pos.framework.event.KeyActionPair;
/*      */ import dtv.pos.framework.event.XstKeyEventDispatcher;
/*      */ import dtv.pos.framework.form.FormAssembler;
/*      */ import dtv.pos.framework.form.component.FormPanel;
/*      */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*      */ import dtv.pos.framework.ui.component.SecondaryComponentRegistry;
/*      */ import dtv.pos.framework.ui.config.FormConfigReloader;
/*      */ import dtv.pos.framework.ui.config.IRootComponentConfig;
/*      */ import dtv.pos.framework.ui.config.ViewInterfaceConfig;
/*      */ import dtv.pos.framework.ui.context.SecondDisplayMode;
/*      */ import dtv.pos.framework.ui.context.UIContext;
/*      */ import dtv.pos.framework.ui.menu.MenuConfigReloader;
/*      */ import dtv.pos.framework.ui.model.DefaultFormModel;
/*      */ import dtv.pos.framework.ui.view.DialogView;
/*      */ import dtv.pos.framework.ui.view.HelpActionPopupView;
/*      */ import dtv.pos.framework.ui.view.HelpView;
/*      */ import dtv.pos.iframework.IModeController;
/*      */ import dtv.pos.iframework.action.IActionOwner;
/*      */ import dtv.pos.iframework.action.IXstKeyStrokeAction;
/*      */ import dtv.pos.iframework.assistance.ITrainingModeHelper;
/*      */ import dtv.pos.iframework.event.IXstEventListener;
/*      */ import dtv.pos.iframework.form.FormLocationType;
/*      */ import dtv.pos.iframework.ui.ActionDisplayType;
/*      */ import dtv.pos.iframework.ui.IComponentRegistry;
/*      */ import dtv.pos.iframework.ui.IDialogOwner;
/*      */ import dtv.pos.iframework.ui.IUIController;
/*      */ import dtv.pos.iframework.ui.IXstViewComponent;
/*      */ import dtv.pos.iframework.ui.context.IComponentState;
/*      */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*      */ import dtv.pos.iframework.ui.model.IMenuModel;
/*      */ import dtv.pos.iframework.ui.model.IStationModel;
/*      */ import dtv.pos.ui.UIServices;
/*      */ import dtv.ui.ISwitchableView;
/*      */ import dtv.ui.UIServices;
/*      */ import dtv.ui.action.AbstractDtvAction;
/*      */ import dtv.ui.action.IDtvAction;
/*      */ import dtv.ui.context.Context;
/*      */ import dtv.util.PerformanceTimer;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.util.config.ParameterListConfig;
/*      */ import java.awt.Component;
/*      */ import java.awt.Container;
/*      */ import java.awt.Frame;
/*      */ import java.awt.Window;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import javax.inject.Inject;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.KeyStroke;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ 
/*      */ public class UIControllerImpl
/*      */   implements IUIController
/*      */ {
/*   69 */   static final Logger logger_ = Logger.getLogger(IUIController.class);
/*      */   
/*   71 */   static final PerformanceTimer timer_ = new PerformanceTimer(logger_);
/*      */   
/*      */   @Inject
/*      */   private UIConfigHelper _uiHelper;
/*      */   
/*      */   @Inject
/*      */   private IXstActionFactory _actionFactory;
/*      */   
/*      */   @Inject
/*      */   private ITrainingModeHelper _trainingModeHelper;
/*      */   
/*      */   @Inject
/*      */   private FormConfigReloader _formReloader;
/*      */   
/*      */   @Inject
/*      */   private MenuConfigReloader _menuReloader;
/*      */   
/*      */   @Inject
/*      */   private FormattableFactory _formattables;
/*      */   
/*      */   @Inject
/*      */   private FormAssembler _formAssembler;
/*      */   
/*      */   private final Map<String, Component> namedComponents_;
/*      */   
/*      */   final IContextChangeHandler[] contextChangeHandlers_;
/*      */   
/*      */   String currentFocusView_;
/*      */   protected String uiName_;
/*      */   private Component uiRoot_;
/*      */   private DialogView dialog_;
/*      */   boolean transactionListVisible_;
/*      */   boolean popupUp_;
/*      */   private boolean _isPopupFullScreen = false;
/*      */   protected boolean enableTransitions_ = true;
/*  106 */   private final Map<String, Object> uiProperties_ = new HashMap<>();
/*      */ 
/*      */   
/*      */   @Inject
/*      */   private XstKeyEventDispatcher _keyEventDispatcher;
/*      */   
/*      */   @Inject
/*      */   private FormViewConfigHelper _formConfigHelper;
/*      */   
/*      */   private IModeController _modeController;
/*      */ 
/*      */   
/*      */   public UIControllerImpl() {
/*  119 */     this.namedComponents_ = new HashMap<>();
/*      */     
/*  121 */     this.transactionListVisible_ = false;
/*  122 */     setPopupIsShowing(false);
/*  123 */     this.contextChangeHandlers_ = new IContextChangeHandler[] { new ContextListenerHandler(), new ContextComponentStateHandler(), new ContextMenuHandler(), new ContextListModelHandler() };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Component createUI(String uiName) {
/*  130 */     if (StringUtils.isEmpty(uiName)) {
/*  131 */       throw new IllegalArgumentException("UI must have a name!");
/*      */     }
/*      */     
/*  134 */     ViewInterfaceConfig uiConfig = this._uiHelper.getUIConfig(uiName);
/*  135 */     JComponent uiRoot = ComponentAssembler.getInstance().assemble((IRootComponentConfig)uiConfig, (IComponentRegistry)this);
/*      */     
/*  137 */     if (uiRoot == null) {
/*  138 */       logger_.error("No components derived from UI name [" + uiName + "]!");
/*  139 */       return null;
/*      */     } 
/*      */     
/*  142 */     this.uiName_ = uiName;
/*  143 */     this.uiRoot_ = uiRoot;
/*      */     
/*  145 */     return uiRoot;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void enableTransitions(boolean argEnable) {
/*  151 */     this.enableTransitions_ = argEnable;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IDtvAction getDialogCloseAction() {
/*  157 */     return getDialogCloseAction("_back", XstKeyStroke.forName("ESCAPE").getKeyStroke());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IDtvAction getDialogCloseAction(final String argText, final KeyStroke argKeyStroke) {
/*  163 */     return (IDtvAction)new AbstractDtvAction()
/*      */       {
/*      */         private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void actionPerformed(ActionEvent argEvent) {
/*  174 */           UIControllerImpl.this.hideDialog();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Component getFocusableChildComponent(String argParentComponentName) {
/*  182 */     Component focusableChild = null;
/*  183 */     JComponent parentComponent = (JComponent)getNamedComponent(argParentComponentName);
/*      */     
/*  185 */     if (parentComponent != null) {
/*      */       
/*  187 */       IXstViewComponent wrapper = (IXstViewComponent)parentComponent.getClientProperty("COMPONENT_WRAPPER");
/*      */       
/*  189 */       if (wrapper != null) {
/*  190 */         focusableChild = wrapper.getFocusComponent();
/*      */       }
/*      */     } 
/*      */     
/*  194 */     return focusableChild;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JComponent getFormView(FormKey viewKey, FormLocationType location) {
/*  201 */     String keyString = viewKey.toString();
/*  202 */     String locationString = (location != null) ? location.toString() : "MULTI_PURPOSE_VIEW";
/*      */     
/*  204 */     this._formReloader.reloadIfNeeded();
/*      */ 
/*      */     
/*  207 */     JComponent result = (JComponent)getNamedComponent(keyString);
/*      */     
/*  209 */     if (result == null) {
/*      */       
/*  211 */       FormPanel formPanel = null;
/*  212 */       if (this._formAssembler.hasFormConfiguration(viewKey)) {
/*  213 */         formPanel = this._formAssembler.assembleForm(viewKey);
/*      */       } else {
/*      */         
/*  216 */         formPanel = this._formConfigHelper.assemble(viewKey);
/*      */       } 
/*      */       
/*  219 */       if (formPanel != null) {
/*  220 */         result = formPanel.getDisplayComponent();
/*      */         
/*  222 */         result.setName(keyString);
/*  223 */         addNamedComponentToLocation(result, getLocationRoot(locationString));
/*      */       } 
/*      */     } 
/*      */     
/*  227 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Component getNamedComponent(String argComponentName) {
/*  233 */     return this.namedComponents_.get(argComponentName);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getProperty(String argKey) {
/*  239 */     return this.uiProperties_.get(argKey);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleContextTransition(IUIContextDescriptor argDescriptor, final Object argConstraint) {
/*  245 */     timer_.reset();
/*  246 */     if (logger_.isDebugEnabled()) {
/*  247 */       logger_.debug("UIController [" + this + "] transitioning to " + argDescriptor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  254 */     final UIContext context = (UIContext)argDescriptor.getContext();
/*  255 */     long changeType = argDescriptor.getChangeType();
/*      */ 
/*      */ 
/*      */     
/*  259 */     for (IContextChangeHandler element : this.contextChangeHandlers_) {
/*  260 */       if ((changeType & element.getChangeType()) != 0L) {
/*  261 */         if (element.needsUiThread()) {
/*  262 */           UIServices.invoke(new Runnable()
/*      */               {
/*      */                 public void run()
/*      */                 {
/*  266 */                   element.handleContextChange(context, argConstraint);
/*      */                 }
/*      */               }true, true);
/*      */         } else {
/*      */           
/*  271 */           element.handleContextChange(context, argConstraint);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  276 */     if (ConfigurationMgr.isDualScreenEnabled().booleanValue()) {
/*  277 */       UIServices.invoke(new Runnable()
/*      */           {
/*      */             public void run()
/*      */             {
/*  281 */               UIControllerImpl.logger_.info("Changing second screen context to [" + context + "]");
/*      */ 
/*      */               
/*  284 */               boolean isTrainingMode = UIControllerImpl.this._trainingModeHelper.isTrainingMode();
/*      */               
/*  286 */               UIControllerImpl.logger_.debug("Training mode is set to [" + isTrainingMode + "]");
/*      */               
/*  288 */               if (context.getSecondDisplayMode() != null && !isTrainingMode) {
/*  289 */                 UIControllerImpl.logger_.debug("Setting mode to [" + context.getSecondDisplayMode() + "]");
/*  290 */                 context.getSecondDisplayMode().doTransition();
/*      */               }
/*  292 */               else if (isTrainingMode) {
/*  293 */                 UIControllerImpl.logger_.debug("Setting mode to [" + SecondDisplayMode.TRAINING + "]");
/*  294 */                 SecondDisplayMode.TRAINING.doTransition();
/*      */               }
/*  296 */               else if (context.isSecondDisplayTransitionEnabled()) {
/*  297 */                 UIControllerImpl.logger_.debug("Setting mode to [" + SecondDisplayMode.OTHER + "]");
/*  298 */                 SecondDisplayMode.OTHER.doTransition();
/*      */               } 
/*      */             }
/*      */           },  true, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleDialogClose() {
/*  309 */     this._keyEventDispatcher.unblockKeyMappings();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void hideDialog() {
/*  315 */     this.dialog_.hide();
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
/*      */   public void hideHelpView() {
/*  330 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  334 */             if (!UIControllerImpl.this.popupUp_) {
/*      */               
/*  336 */               UIControllerImpl.this.hideHelpViewSetup();
/*      */ 
/*      */               
/*  339 */               UIControllerImpl.this.setMainFormModelEnabled(true);
/*      */             } else {
/*      */               
/*  342 */               UIControllerImpl.this.handleUITransition("POPUP_VIEW_BACKGROUND", !UIControllerImpl.this._isPopupFullScreen, !UIControllerImpl.this._isPopupFullScreen);
/*  343 */               UIControllerImpl.this.handleUITransition("POPUP_VIEW_BACKGROUND_FULL_SCREEN", UIControllerImpl.this._isPopupFullScreen, UIControllerImpl.this._isPopupFullScreen);
/*      */             } 
/*  345 */             UIControllerImpl.this.handleUITransition("HELP_VIEW_BACKGROUND", false, false);
/*  346 */             UIControllerImpl.this.handleUITransition("HELP_VIEW_PANEL", false, false);
/*  347 */             UIControllerImpl.this.handleFocusTransition(UIControllerImpl.this.currentFocusView_);
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void hidePopupView() {
/*  355 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void run()
/*      */           {
/*  366 */             UIControllerImpl.this.hidePopupViewSetup();
/*      */             
/*  368 */             if (UIControllerImpl.this.isPopupShowing()) {
/*  369 */               UIControllerImpl.logger_.debug("UIController [" + this + "] hiding popup view");
/*      */ 
/*      */               
/*  372 */               UIControllerImpl.this.handleUITransition("POPUP_LAYER", false, false);
/*      */ 
/*      */               
/*  375 */               UIControllerImpl.this.setMainFormModelEnabled(true);
/*  376 */               UIControllerImpl.this.setPopupIsShowing(false);
/*      */             } else {
/*      */               
/*  379 */               UIControllerImpl.logger_.debug("UIController [" + this + "]: popup was already hidden.");
/*      */             } 
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void hideUI() {
/*  388 */     if (this.uiRoot_ == null) {
/*  389 */       throw new IllegalStateException("UI has not been created and assigned!");
/*      */     }
/*  391 */     this.uiRoot_.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void initialize() {
/*  397 */     boolean popupShowing = this.popupUp_;
/*  398 */     boolean isPopupFullScreen = this._isPopupFullScreen;
/*  399 */     if (popupShowing) {
/*  400 */       hidePopupView();
/*  401 */       showPopupView(isPopupFullScreen);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  414 */       showPopupView(false);
/*  415 */       hidePopupView();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInputRestrictedToMenu() {
/*  422 */     IMenuModel menuModel = this._modeController.getStationModel().getMenuModel();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  428 */     ActionDisplayType displayType = menuModel.getCurrentMenuDisplayType();
/*      */     
/*  430 */     return (!ActionDisplayType.BUTTON.equals(displayType) && 
/*  431 */       !ActionDisplayType.BUTTON_EXCLUSIVE.equals(displayType));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPopupShowing() {
/*  437 */     return this.popupUp_;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Object putProperty(String argKey, Object argProperty) {
/*  443 */     return this.uiProperties_.put(argKey, argProperty);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void registerKeyActions(Collection<? extends KeyActionPair> argKeyActions, IActionOwner argActionOwner, Component... argTargetComponents) {
/*  451 */     if (argTargetComponents != null) {
/*  452 */       Collection<Component> targetComponents = Arrays.asList(argTargetComponents);
/*      */       
/*  454 */       for (KeyActionPair keyActionPair : argKeyActions) {
/*  455 */         ((IXstKeyStrokeAction)keyActionPair.b()).setKeyStrokeTargets(targetComponents);
/*      */       }
/*      */       
/*  458 */       this._keyEventDispatcher.setKeyMappings(argActionOwner, argKeyActions, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void registerNamedComponent(Component argComponent, String argName) {
/*  465 */     this.namedComponents_.put(argName, argComponent);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeNamedComponent(String argName) {
/*  471 */     this.namedComponents_.remove(argName);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setModeController(IModeController argController) {
/*  477 */     this._modeController = argController;
/*      */   }
/*      */   
/*      */   public void setPopupIsShowing(boolean popupUp) {
/*  481 */     if (this.popupUp_ != popupUp) {
/*  482 */       this.popupUp_ = popupUp;
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
/*      */   public void showDialog(IXstViewComponent argContent, String argTitle, Collection<IDtvAction> argActions, boolean argModal, boolean argDecorated) {
/*  514 */     if (this.dialog_ == null || !this.dialog_.isEnabled()) {
/*      */       
/*  516 */       boolean modal = true;
/*  517 */       Frame parent = null;
/*  518 */       if (StationController.getAppFrame().getFrameComponent() instanceof Frame) {
/*  519 */         modal = argModal;
/*  520 */         parent = (Frame)StationController.getAppFrame().getFrameComponent();
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  526 */       Collection<IDtvAction> actions = (argActions == null || argActions.isEmpty()) ? getDefaultDialogActions(argContent) : argActions;
/*  527 */       this.dialog_ = new DialogView((IDialogOwner)this, argContent, parent, argTitle, actions, modal, argDecorated);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  532 */       this._keyEventDispatcher.blockKeyMappings();
/*      */ 
/*      */       
/*  535 */       UIServices.moveWindowToDefaultScreen(this.dialog_.getDialog(), false);
/*  536 */       Window frameComponent = StationController.getAppFrame().getFrameComponent();
/*  537 */       if (!frameComponent.isVisible()) {
/*  538 */         frameComponent = null;
/*      */       }
/*  540 */       UIServices.centerComponent(this.dialog_.getDialog(), frameComponent);
/*      */ 
/*      */       
/*  543 */       this.dialog_.show();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showFocusBar() {
/*  550 */     hidePopupView();
/*      */     
/*  552 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  556 */             UIControllerImpl.this.handleUITransition("TRANSACTION_VIEW", true, true);
/*  557 */             UIControllerImpl.this.handleUITransition("FOCUS_BAR", true, true);
/*  558 */             UIControllerImpl.this.transactionListVisible_ = true;
/*      */             
/*  560 */             UIControllerImpl.this.handleFocusTransition("FOCUS_BAR");
/*  561 */             UIControllerImpl.this.currentFocusView_ = "FOCUS_BAR";
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public JComponent showFormView(FormKey viewKey, FormLocationType location, boolean requestFocus) {
/*  569 */     String keyString = viewKey.toString();
/*  570 */     final String locationString = (location != null) ? location.toString() : "MULTI_PURPOSE_VIEW";
/*  571 */     this.currentFocusView_ = keyString;
/*      */ 
/*      */     
/*  574 */     JComponent result = getFormView(viewKey, location);
/*      */ 
/*      */ 
/*      */     
/*  578 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  582 */             UIControllerImpl.this.handleUITransition(locationString, true, true);
/*      */           }
/*      */         }true, true);
/*      */ 
/*      */ 
/*      */     
/*  588 */     UIServices.showComponentAndParents(result, true);
/*      */ 
/*      */     
/*  591 */     if (requestFocus) {
/*  592 */       handleFocusTransition(keyString);
/*      */     }
/*  594 */     return result;
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
/*      */   public void showHelpView(IXstEventListener listener) {
/*  609 */     JComponent helpComp = (JComponent)this.namedComponents_.get("HELP_VIEW");
/*  610 */     HelpView helpView = (HelpView)helpComp.getClientProperty("COMPONENT_WRAPPER");
/*  611 */     helpView.updateView();
/*      */     
/*  613 */     helpComp = (JComponent)this.namedComponents_.get("HELP_ACTION_VIEW");
/*      */     
/*  615 */     HelpActionPopupView helpActionView = (HelpActionPopupView)helpComp.getClientProperty("COMPONENT_WRAPPER");
/*  616 */     helpActionView.updateView(listener);
/*      */     
/*  618 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           
/*      */           public void run()
/*      */           {
/*  623 */             UIControllerImpl.this.showHelpViewSetup();
/*      */ 
/*      */             
/*  626 */             UIControllerImpl.this.setMainFormModelEnabled(false);
/*      */ 
/*      */             
/*  629 */             UIControllerImpl.this.handleUITransition("HELP_VIEW_BACKGROUND", true, true);
/*  630 */             UIControllerImpl.this.handleUITransition("HELP_VIEW_PANEL", true, true);
/*  631 */             UIControllerImpl.this.handleUITransition("HELP_VIEW", true, true);
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showPopupIconMenu() {
/*  639 */     showPopupView(false);
/*      */     
/*  641 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  645 */             UIControllerImpl.this.handleUITransition("POPUP_ICON_MENU_VIEW", true, true);
/*  646 */             UIControllerImpl.this.handleFocusTransition("POPUP_ICON_MENU_VIEW");
/*  647 */             UIControllerImpl.this.currentFocusView_ = "POPUP_ICON_MENU_VIEW";
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showPopupList(final boolean argIsFullScreen) {
/*  655 */     showPopupView(argIsFullScreen);
/*      */     
/*  657 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  661 */             if (argIsFullScreen) {
/*  662 */               UIControllerImpl.this.handleUITransition("POPUP_LIST_VIEW_FULL_SCREEN", true, true);
/*  663 */               UIControllerImpl.this.handleFocusTransition("POPUP_LIST_VIEW_FULL_SCREEN");
/*  664 */               UIControllerImpl.this.currentFocusView_ = "POPUP_LIST_VIEW_FULL_SCREEN";
/*      */             } else {
/*      */               
/*  667 */               UIControllerImpl.this.handleUITransition("POPUP_LIST_VIEW", true, true);
/*  668 */               UIControllerImpl.this.handleFocusTransition("POPUP_LIST_VIEW");
/*  669 */               UIControllerImpl.this.currentFocusView_ = "POPUP_LIST_VIEW";
/*      */             } 
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showPopupLongText() {
/*  678 */     showPopupView(false);
/*      */     
/*  680 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  684 */             UIControllerImpl.this.handleUITransition("POPUP_LONG_TEXT_VIEW", true, true);
/*  685 */             UIControllerImpl.this.handleFocusTransition("POPUP_LONG_TEXT_VIEW");
/*  686 */             UIControllerImpl.this.currentFocusView_ = "POPUP_LONG_TEXT_VIEW";
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showPopupMenu() {
/*  694 */     showPopupView(false);
/*      */     
/*  696 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  700 */             UIControllerImpl.this.handleUITransition("POPUP_MENU_VIEW", true, true);
/*  701 */             UIControllerImpl.this.handleFocusTransition("POPUP_MENU_VIEW");
/*  702 */             UIControllerImpl.this.currentFocusView_ = "POPUP_MENU_VIEW";
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showPopupNotify() {
/*  710 */     showPopupView(false);
/*      */     
/*  712 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */           public void run() {
/*  715 */             UIControllerImpl.this.handleUITransition("POPUP_NOTIFY_VIEW", true, true);
/*  716 */             UIControllerImpl.this.currentFocusView_ = "POPUP_NOTIFY_VIEW";
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showPopupView(final boolean argIsFullScreen) {
/*  724 */     UIServices.invoke(new Runnable()
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void run()
/*      */           {
/*  735 */             UIControllerImpl.this.showPopupViewSetup();
/*      */             
/*  737 */             if (!UIControllerImpl.this.isPopupShowing()) {
/*  738 */               UIControllerImpl.logger_.debug("UIController [" + this + "] showing popup view");
/*      */ 
/*      */               
/*  741 */               UIControllerImpl.this.handleUITransition("POPUP_LAYER", true, true);
/*  742 */               UIControllerImpl.this.handleUITransition("POPUP_VIEW_BACKGROUND", !argIsFullScreen, !argIsFullScreen);
/*  743 */               UIControllerImpl.this.handleUITransition("POPUP_VIEW_BACKGROUND_FULL_SCREEN", argIsFullScreen, argIsFullScreen);
/*  744 */               UIControllerImpl.this.handleUITransition("POPUP_VIEW", true, true);
/*      */ 
/*      */               
/*  747 */               UIControllerImpl.this.setMainFormModelEnabled(false);
/*      */               
/*  749 */               UIControllerImpl.this.setPopupIsShowing(true);
/*  750 */               UIControllerImpl.this._isPopupFullScreen = argIsFullScreen;
/*      */             } else {
/*      */               
/*  753 */               UIControllerImpl.logger_.debug("UIController [" + this + "]: popup was already shown.");
/*      */               
/*  755 */               if (UIControllerImpl.this._isPopupFullScreen != argIsFullScreen) {
/*  756 */                 UIControllerImpl.this._isPopupFullScreen = argIsFullScreen;
/*  757 */                 UIControllerImpl.this.handleUITransition("POPUP_VIEW_BACKGROUND", !argIsFullScreen, !argIsFullScreen);
/*  758 */                 UIControllerImpl.this.handleUITransition("POPUP_VIEW_BACKGROUND_FULL_SCREEN", argIsFullScreen, argIsFullScreen);
/*      */               } 
/*      */             } 
/*      */           }
/*      */         }true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  768 */     return this.uiName_;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void addNamedComponentToLocation(Component comp, ISwitchableView locationRoot) {
/*  774 */     ((Container)locationRoot).add(comp, comp.getName());
/*  775 */     registerNamedComponent(comp, comp.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void handleFocusTransition(final String componentName) {
/*  785 */     final JComponent result = (JComponent)getNamedComponent(componentName);
/*      */ 
/*      */     
/*  788 */     final Object wrapper = result.getClientProperty("COMPONENT_WRAPPER");
/*      */     
/*  790 */     if (wrapper instanceof FormPanel) {
/*      */       
/*  792 */       UIServices.invoke(new Runnable()
/*      */           {
/*      */             
/*      */             public void run()
/*      */             {
/*  797 */               UIControllerImpl.timer_.reset();
/*      */               
/*  799 */               JComponent focusableComponent = ((FormPanel)wrapper).getFocusComponent();
/*  800 */               if (focusableComponent != null) {
/*  801 */                 Container grandparent = focusableComponent.getParent().getParent();
/*  802 */                 if (grandparent instanceof dtv.ui.swing.DtvScrollPane) {
/*  803 */                   grandparent = grandparent.getParent();
/*      */                 }
/*  805 */                 if (grandparent instanceof ISwitchableView) {
/*  806 */                   ((ISwitchableView)grandparent).setChildVisibility(focusableComponent.getParent(), null, true);
/*      */                 }
/*      */                 
/*  809 */                 focusableComponent.requestFocusInWindow();
/*  810 */                 UIControllerImpl.timer_.markOut("Transition focus to [" + focusableComponent + "] on form named [" + componentName + "].");
/*      */               }
/*      */             
/*      */             }
/*      */           });
/*      */     }
/*      */     else {
/*      */       
/*  818 */       UIServices.invoke(new Runnable()
/*      */           {
/*      */             public void run()
/*      */             {
/*  822 */               UIControllerImpl.timer_.reset();
/*  823 */               UIServices.requestFocusForChildren(result);
/*  824 */               UIControllerImpl.timer_.markOut("Transition focus to [" + result + "] named [" + componentName + "].");
/*      */             }
/*      */           });
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
/*      */ 
/*      */ 
/*      */   
/*      */   protected void handleUITransition(String componentName, boolean enabled) {
/*  842 */     if (this.enableTransitions_) {
/*      */       
/*  844 */       Component component = getNamedComponent(componentName);
/*      */       
/*  846 */       if (component == null) {
/*  847 */         logger_.error("THERE IS NO COMPONENT FOUND FOR " + componentName);
/*      */         return;
/*      */       } 
/*  850 */       component.setEnabled(enabled);
/*      */       
/*  852 */       if (component instanceof Container) {
/*  853 */         UIServices.setChildrenEnabled((Container)component, enabled);
/*      */       }
/*  855 */       for (String secondary : SecondaryComponentRegistry.getSecondaryNames(componentName)) {
/*  856 */         handleUITransition(secondary, enabled);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void handleUITransition(String componentName, boolean visible, boolean enabled) {
/*  876 */     handleUITransition(componentName, visible, enabled, null);
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
/*      */   protected void handleUITransition(String componentName, boolean visible, boolean enabled, ParameterListConfig parameters) {
/*  897 */     if (this.enableTransitions_) {
/*      */       
/*  899 */       Component component = getNamedComponent(componentName);
/*      */       
/*  901 */       if (component == null) {
/*  902 */         logger_.error("THERE IS NO COMPONENT FOUND FOR " + componentName);
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  907 */       UIServices.showComponentAndParents(component, true);
/*      */ 
/*      */       
/*  910 */       if (parameters != null) {
/*  911 */         parameters.setParametersOn(component);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  916 */       component.setVisible(visible);
/*  917 */       component.setEnabled(enabled);
/*      */ 
/*      */       
/*  920 */       if (component instanceof Container) {
/*  921 */         UIServices.setChildrenEnabled((Container)component, enabled);
/*      */       }
/*  923 */       for (String secondary : SecondaryComponentRegistry.getSecondaryNames(componentName)) {
/*  924 */         handleUITransition(secondary, visible, enabled, parameters);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void hideHelpViewSetup() {
/*  933 */     handleUITransition("MENU_VIEW", true);
/*  934 */     handleUITransition("FOCUS_BAR", true);
/*      */     
/*  936 */     handleUITransition("TRANSACTION_VIEW", true);
/*  937 */     handleUITransition("MULTI_PURPOSE_VIEW", true);
/*  938 */     handleUITransition("POPUP_LAYER", false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void hidePopupViewSetup() {
/*  945 */     handleUITransition("FOCUS_BAR_MESSAGE_AREA", true, true);
/*  946 */     handleUITransition("TRANSACTION_LIST_AREA_BACKGROUND", true, true);
/*      */     
/*  948 */     handleUITransition("FOCUS_BAR", true);
/*  949 */     handleUITransition("MENU_VIEW", true);
/*  950 */     handleUITransition("TRANSACTION_VIEW", true);
/*  951 */     handleUITransition("MULTI_PURPOSE_VIEW", true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void showHelpViewSetup() {
/*  958 */     handleUITransition("MENU_VIEW", false);
/*  959 */     handleUITransition("FOCUS_BAR", false);
/*      */     
/*  961 */     handleUITransition("TRANSACTION_VIEW", false);
/*  962 */     handleUITransition("MULTI_PURPOSE_VIEW", false);
/*      */ 
/*      */     
/*  965 */     handleUITransition("POPUP_LAYER", true, true);
/*      */     
/*  967 */     handleUITransition("POPUP_VIEW_BACKGROUND", false, false);
/*  968 */     handleUITransition("POPUP_VIEW_BACKGROUND_FULL_SCREEN", false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void showPopupViewSetup() {
/*  976 */     handleUITransition("MENU_VIEW", false);
/*  977 */     handleUITransition("MULTI_PURPOSE_VIEW", false);
/*  978 */     handleUITransition("TRANSACTION_VIEW", false);
/*      */   }
/*      */ 
/*      */   
/*      */   void setMainFormModelEnabled(boolean enabled) {
/*  983 */     if (!this.transactionListVisible_) {
/*  984 */       IStationModel sm = this._modeController.getStationModel();
/*  985 */       DefaultFormModel model = (DefaultFormModel)sm.getFormModel(sm.getPrimaryFormModelKey());
/*  986 */       model.setEnabled(enabled);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private Collection<IDtvAction> getDefaultDialogActions(IXstViewComponent argContent) {
/*  992 */     Collection<IDtvAction> actions = new ArrayList<>();
/*  993 */     Component focusComponent = argContent.getFocusComponent();
/*      */ 
/*      */     
/*  996 */     if (focusComponent instanceof javax.swing.Scrollable) {
/*  997 */       IXstKeyStrokeAction scrollUp = this._actionFactory.getScrollUpAction();
/*  998 */       IXstKeyStrokeAction scrollDown = this._actionFactory.getScrollDownAction();
/*  999 */       Collection<Component> targets = Collections.singleton(focusComponent);
/*      */       
/* 1001 */       scrollUp.setKeyStrokeTargets(targets);
/* 1002 */       scrollDown.setKeyStrokeTargets(targets);
/*      */     } 
/*      */     
/* 1005 */     actions.add(getDialogCloseAction());
/*      */     
/* 1007 */     return actions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ISwitchableView getLocationRoot(String locationName) {
/* 1014 */     return (ISwitchableView)getNamedComponent(locationName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ContextComponentStateHandler
/*      */     implements IContextChangeHandler
/*      */   {
/*      */     public long getChangeType() {
/* 1025 */       return 16L;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void handleContextChange(UIContext argContext, Object argConstraint) {
/* 1033 */       IComponentState[] states = argContext.getComponentStates();
/* 1034 */       if (states != null) {
/* 1035 */         for (IComponentState state : states) {
/* 1036 */           UIControllerImpl.this.handleUITransition(state.getComponentName(), state.isVisible(), state.isEnabled(), state
/* 1037 */               .getParameters());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean needsUiThread() {
/* 1045 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ContextListenerHandler
/*      */     implements IContextChangeHandler
/*      */   {
/*      */     public long getChangeType() {
/* 1056 */       return 1L;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void handleContextChange(UIContext argContext, Object argConstraint) {
/* 1064 */       UIControllerImpl.this._modeController.getContextManager().setContext((Context)argContext, argConstraint);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean needsUiThread() {
/* 1070 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ContextListModelHandler
/*      */     implements IContextChangeHandler
/*      */   {
/*      */     public long getChangeType() {
/* 1082 */       return 4096L;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void handleContextChange(UIContext argContext, Object argConstraint) {
/* 1091 */       if (argContext.getListModelKey() != null) {
/* 1092 */         UIControllerImpl.this._modeController.getStationModel().setCurrentListModel(argContext.getListModelKey());
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean needsUiThread() {
/* 1099 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ContextMenuHandler
/*      */     implements IContextChangeHandler
/*      */   {
/*      */     public long getChangeType() {
/* 1110 */       return 256L;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void handleContextChange(UIContext argContext, Object argConstraint) {
/* 1117 */       if (argContext.getMenuKey() != null) {
/* 1118 */         UIControllerImpl.this._menuReloader.reloadIfNeeded();
/* 1119 */         UIControllerImpl.this._modeController.getStationModel().getMenuModel().setCurrentMenu(argContext.getMenuKey());
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean needsUiThread() {
/* 1126 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static interface IContextChangeHandler {
/*      */     long getChangeType();
/*      */     
/*      */     void handleContextChange(UIContext param1UIContext, Object param1Object);
/*      */     
/*      */     boolean needsUiThread();
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\UIControllerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */