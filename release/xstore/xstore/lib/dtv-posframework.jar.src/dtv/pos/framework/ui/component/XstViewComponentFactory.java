/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.form.component.FormLabel;
/*     */ import dtv.pos.framework.form.component.FormPanel;
/*     */ import dtv.pos.framework.form.component.IMasterDetailFormPanel;
/*     */ import dtv.pos.framework.form.component.MasterDetailFormPanel;
/*     */ import dtv.pos.framework.form.config.AbstractFormComponentConfig;
/*     */ import dtv.pos.framework.form.config.FormLayoutConfig;
/*     */ import dtv.pos.framework.touch.TouchConfig;
/*     */ import dtv.pos.framework.touch.rules.AccessResponsivenessRule;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.touch.TouchConstants;
/*     */ import dtv.ui.touch.TouchHelper;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.ResourceUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.KeyStroke;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class XstViewComponentFactory
/*     */   implements IXstViewComponentFactory {
/*  53 */   private static final Logger logger_ = Logger.getLogger(XstViewComponentFactory.class);
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_PROPERTY_FILE = "componentWrapper";
/*     */   
/*  58 */   private static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
/*  59 */   private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
/*     */   
/*     */   public static final String VIEW_COMPONENT_FACTORY_PROPERTY = "dtv.pos.viewcomponentfactory";
/*     */   
/*     */   private static IXstViewComponentFactory INSTANCE;
/*     */   
/*     */   private static final String APP_FRAME = "AppFrame";
/*     */   
/*     */   private static final String BUTTON = "Button";
/*     */   
/*     */   private static final String LABEL = "Label";
/*     */   
/*     */   private static final String LABEL_WRAPPING = "LabelWrapping";
/*     */   private static final String ACTION_LIST = "ActionList";
/*     */   private static final String LIST = "List";
/*     */   private static final String LONG_TEXT_FIELD = "LongTextField";
/*     */   private static final String READ_ONLY_TEXT_AREA = "ReadOnlyTextArea";
/*     */   private static final String MESSAGE_AREA = "MessageArea";
/*     */   private static final String TEXT_FIELD = "TextField";
/*     */   private static final String TITLED_INSTRUCTION_PANEL = "TitledInstructionPanel";
/*     */   private static final String SECONDARY_TITLED_INSTRUCTION_PANEL = "SecondaryTitledInstructionPanel";
/*     */   private static final String TITLED_PANEL = "TitledPanel";
/*     */   private final Properties DEFAULT_COMPONENT_MAP;
/*     */   private String componentMapSource_;
/*     */   private Properties componentMap_;
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   @Inject
/*     */   private TouchHelper _touchHelper;
/*     */   
/*     */   public static IXstViewComponentFactory getInstance() {
/*  90 */     if (INSTANCE == null) {
/*     */       
/*  92 */       String className = System.getProperty("dtv.pos.viewcomponentfactory");
/*     */       try {
/*  94 */         INSTANCE = (IXstViewComponentFactory)Class.forName(className).newInstance();
/*     */       }
/*  96 */       catch (Exception ex) {
/*  97 */         INSTANCE = new XstViewComponentFactory();
/*     */       } 
/*     */     } 
/* 100 */     return INSTANCE;
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
/*     */   private XstViewComponentFactory() {
/* 116 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/* 118 */     logger_.debug("Creating component factory: " + getClass() + ".");
/*     */     
/* 120 */     this.DEFAULT_COMPONENT_MAP = getDefaultProperties();
/* 121 */     this.componentMap_ = this.DEFAULT_COMPONENT_MAP;
/* 122 */     this.componentMapSource_ = "componentWrapper";
/*     */   }
/*     */ 
/*     */   
/*     */   public XstActionList createActionList() {
/* 127 */     return (XstActionList)createComponentWrapper("ActionList");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstActionList createActionList(ICombinedListModel<Object> argModel) {
/* 132 */     XstActionList list = (XstActionList)createComponentWrapper("ActionList");
/* 133 */     list.setModel(argModel);
/* 134 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstActionList createActionList(ICombinedListModel<Object> argModel, ComponentID argId) {
/* 139 */     XstActionList list = (XstActionList)createComponentWrapper("ActionList", new Class[] { ComponentID.class }, new Object[] { argId });
/*     */     
/* 141 */     list.setModel(argModel);
/* 142 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstAnchor createAnchor() {
/* 147 */     return new XstAnchor();
/*     */   }
/*     */ 
/*     */   
/*     */   public XstAppFrame createAppFrame(boolean argDecorated) {
/* 152 */     return (XstAppFrame)createComponentWrapper("AppFrame", new Class[] { boolean.class }, new Object[] {
/* 153 */           Boolean.valueOf(argDecorated)
/*     */         });
/*     */   }
/*     */   
/*     */   public XstButton createButton() {
/* 158 */     return createButton(null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstButton createButton(ComponentID argId) {
/* 163 */     return createButton(null, null, argId);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstButton createButton(IXstAction argAction) {
/* 168 */     return createButton(argAction, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstButton createButton(IXstAction argAction, KeyStroke argFixedKeyStroke) {
/* 173 */     return createButton(argAction, argFixedKeyStroke, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XstButton createButton(IXstAction argAction, KeyStroke argFixedKeyStroke, ComponentID argId) {
/* 179 */     XstButton button = (XstButton)createComponentWrapper("Button", new Class[] { ComponentID.class }, new Object[] { argId });
/*     */     
/* 181 */     button.setAction((Action)argAction);
/* 182 */     button.setFixedKeyStroke(argFixedKeyStroke);
/*     */     
/* 184 */     return button;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstButton createButton(KeyStroke argFixedKeyStroke) {
/* 189 */     return createButton(null, argFixedKeyStroke);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent createComponent(IViewComponentConfig<?> config, boolean designMode) {
/* 195 */     Class[] argumentClasses = EMPTY_CLASS_ARRAY;
/* 196 */     Object[] arguments = EMPTY_OBJECT_ARRAY;
/*     */     
/* 198 */     if (config.getComponentId() != null) {
/* 199 */       argumentClasses = new Class[] { ComponentID.class };
/* 200 */       arguments = new Object[] { config.getComponentId() };
/*     */     } 
/* 202 */     return createComponent(config, argumentClasses, arguments, designMode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent createComponent(IViewComponentConfig<?> config, Class<?>[] argumentClasses, Object[] arguments, boolean designMode) {
/* 209 */     String componentTypeName = config.getClassType();
/* 210 */     JComponent displayComponent = null;
/*     */     
/* 212 */     String componentType = this.componentMap_.getProperty(componentTypeName);
/* 213 */     if (componentType == null) {
/* 214 */       displayComponent = (JComponent)PosComponentFactory.getInstance().createComponent(componentTypeName, argumentClasses, arguments);
/*     */     }
/*     */     else {
/*     */       
/* 218 */       IXstViewComponent component = createComponentWrapper(componentTypeName, argumentClasses, arguments);
/* 219 */       if (component != null) {
/* 220 */         displayComponent = component.getDisplayComponent();
/*     */         
/* 222 */         displayComponent.putClientProperty("COMPONENT_WRAPPER", component);
/*     */       } 
/*     */     } 
/* 225 */     initComponent(displayComponent, config, designMode);
/*     */     
/* 227 */     return displayComponent;
/*     */   }
/*     */   
/*     */   public IXstViewComponent createComponentWrapper(String componentType) {
/* 231 */     return createComponentWrapper(componentType, EMPTY_CLASS_ARRAY, EMPTY_OBJECT_ARRAY);
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormComponent createFormComponent(IFormComponentConfig<?> config, boolean designMode) {
/*     */     FormLabel formLabel;
/* 237 */     IFormComponent formComponent = (IFormComponent)createComponentWrapper((IViewComponentConfig<?>)config, designMode);
/* 238 */     if (formComponent != null) {
/* 239 */       formComponent.getDisplayComponent().setName(config.getResource());
/* 240 */       formComponent.getDisplayComponent().putClientProperty("COMPONENT_WRAPPER", formComponent);
/*     */       
/* 242 */       formComponent.init(config);
/* 243 */       if (designMode) {
/* 244 */         formComponent.setConfig(config);
/*     */       }
/*     */     }
/* 247 */     else if (designMode) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       formLabel = new FormLabel();
/*     */ 
/*     */       
/* 255 */       LiteralConfig literalConfig = new LiteralConfig();
/* 256 */       literalConfig.setValue("invalid type [" + config.getClassType() + "]");
/*     */ 
/*     */       
/* 259 */       IFormViewCellConfig cellConfig = (IFormViewCellConfig)config;
/* 260 */       cellConfig.setTextKey((IFormattableConfig)literalConfig);
/* 261 */       cellConfig.setResource(null);
/*     */ 
/*     */       
/* 264 */       formLabel.init(config);
/* 265 */       formLabel.setConfig(config);
/*     */     } else {
/*     */       
/* 268 */       logger_.warn("unable to create " + config.getClassType());
/*     */     } 
/*     */     
/* 271 */     return (IFormComponent)formLabel;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormComponent createFormComponent(ResolvedFieldConfig argFieldDef) {
/* 276 */     IFormComponent formComponent = (IFormComponent)createComponentWrapper(argFieldDef);
/* 277 */     if (formComponent != null) {
/* 278 */       formComponent.getDisplayComponent().setName(argFieldDef.getName());
/* 279 */       formComponent.getDisplayComponent().putClientProperty("COMPONENT_WRAPPER", formComponent);
/*     */       
/* 281 */       formComponent.init(argFieldDef);
/*     */     } 
/*     */     
/* 284 */     return formComponent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormPanel createFormPanel(IFormComponentConfig config, boolean argIsTitled, boolean argDesignMode) {
/* 290 */     FormPanel formPanel = null;
/*     */     
/* 292 */     if (config.getComponentId() != null) {
/* 293 */       JComponent component = createComponent((IViewComponentConfig<?>)config, argDesignMode);
/* 294 */       formPanel = (FormPanel)component.getClientProperty("COMPONENT_WRAPPER");
/*     */     } else {
/*     */       
/* 297 */       formPanel = createFormPanel(config.getClassType(), argIsTitled, argDesignMode);
/*     */     } 
/*     */     
/* 300 */     formPanel.init(config);
/* 301 */     if (argDesignMode) {
/* 302 */       formPanel.setConfig(config);
/*     */     }
/* 304 */     initComponent(formPanel.getContainer(), (IViewComponentConfig<?>)config, argDesignMode);
/*     */     
/* 306 */     return formPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormPanel createFormPanel(ResolvedFieldConfig argFormDef, String argClassType, boolean argIsTitled, ComponentID argComponentId, List<IXstAction> argTouchActionList) {
/* 314 */     FormPanel formPanel = null;
/* 315 */     if (argComponentId != null) {
/* 316 */       Class[] argumentClasses = { ComponentID.class };
/* 317 */       Object[] arguments = { argComponentId };
/*     */       
/* 319 */       JComponent displayComponent = null;
/*     */       
/* 321 */       String componentType = this.componentMap_.getProperty(argClassType);
/* 322 */       if (componentType == null) {
/* 323 */         displayComponent = (JComponent)PosComponentFactory.getInstance().createComponent(argClassType, argumentClasses, arguments);
/*     */       }
/*     */       else {
/*     */         
/* 327 */         final IXstViewComponent component = createComponentWrapper(argClassType, argumentClasses, arguments);
/* 328 */         if (component != null) {
/* 329 */           displayComponent = component.getDisplayComponent();
/*     */           
/* 331 */           displayComponent.putClientProperty("COMPONENT_WRAPPER", component);
/*     */         } 
/*     */       } 
/*     */       
/* 335 */       formPanel = (FormPanel)displayComponent.getClientProperty("COMPONENT_WRAPPER");
/*     */     } else {
/*     */       
/* 338 */       formPanel = createFormPanel(argClassType, argIsTitled, false);
/*     */     } 
/*     */     
/* 341 */     formPanel.init(argFormDef);
/*     */     
/* 343 */     if (argTouchActionList != null && !argTouchActionList.isEmpty()) {
/* 344 */       final JComponent component = formPanel.getDisplayComponent();
/* 345 */       component.addMouseListener(new MouseAdapter() {
/* 346 */             private final Color origBackgroundColor_ = component.getBackground();
/*     */ 
/*     */ 
/*     */             
/*     */             public void mousePressed(MouseEvent argE) {
/* 351 */               component.setBackground(this.origBackgroundColor_.darker());
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void mouseReleased(MouseEvent argE) {
/* 357 */               component.setBackground(this.origBackgroundColor_);
/*     */             }
/*     */           });
/*     */       
/* 361 */       for (IXstAction action : argTouchActionList) {
/* 362 */         this._touchHelper.addTouchActionsToComponent(component, TouchConstants.TouchType.TOUCH, (ActionListener)action, action
/* 363 */             .getVisibilityRules());
/*     */       }
/*     */     } 
/* 366 */     return formPanel;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createLabel() {
/* 371 */     return createLabel(null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createLabel(Icon icon) {
/* 376 */     return createLabel(null, icon);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createLabel(String text) {
/* 381 */     return createLabel(text, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createLabel(String text, Icon icon) {
/* 386 */     XstLabel label = (XstLabel)createComponentWrapper("Label");
/*     */     
/* 388 */     label.setText(text);
/* 389 */     label.setIcon(icon);
/*     */     
/* 391 */     return label;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstList createList() {
/* 396 */     return (XstList)createComponentWrapper("List");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstList createList(boolean useSimpleRenderer) {
/* 401 */     XstList list = (XstList)createComponentWrapper("List");
/* 402 */     list.setUseSimpleRenderer(useSimpleRenderer);
/*     */     
/* 404 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstList createList(ComponentID argId) {
/* 409 */     return (XstList)createComponentWrapper("List", new Class[] { ComponentID.class }, new Object[] { argId });
/*     */   }
/*     */ 
/*     */   
/*     */   public XstList createList(ICombinedListModel<Object> model) {
/* 414 */     XstList list = (XstList)createComponentWrapper("List");
/* 415 */     list.setModel(model);
/*     */     
/* 417 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstList createList(ICombinedListModel<Object> model, boolean useSimpleRenderer) {
/* 422 */     XstList list = (XstList)createComponentWrapper("List");
/* 423 */     list.setModel(model);
/* 424 */     list.setUseSimpleRenderer(useSimpleRenderer);
/*     */     
/* 426 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLongTextField createLongTextField() {
/* 431 */     return (XstLongTextField)createComponentWrapper("LongTextField");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstMessageArea createMessageArea() {
/* 436 */     return (XstMessageArea)createComponentWrapper("MessageArea");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IMasterDetailFormPanel createMultiTabFormPanel(FormLayoutConfig argLayoutConf, boolean argIsTitled) {
/* 442 */     MasterDetailFormPanel rootPanel = new MasterDetailFormPanel(argLayoutConf, argIsTitled);
/* 443 */     return (IMasterDetailFormPanel)rootPanel;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstReadOnlyTextArea createReadOnlyTextArea() {
/* 448 */     return (XstReadOnlyTextArea)createComponentWrapper("ReadOnlyTextArea");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XstTitledInstructionPanel createSecondaryTitledInstructionPanel() {
/* 454 */     return (XstTitledInstructionPanel)createComponentWrapper("SecondaryTitledInstructionPanel");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstTextField createTextField() {
/* 459 */     return (XstTextField)createComponentWrapper("TextField");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstTitledInstructionPanel createTitledInstructionPanel() {
/* 464 */     return (XstTitledInstructionPanel)createComponentWrapper("TitledInstructionPanel");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstTitledInstructionPanel createTitledInstructionPanel(IXstViewComponent content) {
/* 469 */     return createTitledInstructionPanel((content != null) ? content.getDisplayComponent() : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstTitledInstructionPanel createTitledInstructionPanel(JComponent content) {
/* 474 */     return (XstTitledInstructionPanel)createComponentWrapper("TitledInstructionPanel", new Class[] { JComponent.class }, new Object[] { content });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XstTitledPanel createTitledPanel() {
/* 480 */     return (XstTitledPanel)createComponentWrapper("TitledPanel");
/*     */   }
/*     */ 
/*     */   
/*     */   public XstTitledPanel createTitledPanel(IXstViewComponent content) {
/* 485 */     return createTitledPanel((content != null) ? content.getDisplayComponent() : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstTitledPanel createTitledPanel(JComponent content) {
/* 490 */     XstTitledPanel titledPanel = (XstTitledPanel)createComponentWrapper("TitledPanel");
/* 491 */     titledPanel.setContent(content);
/*     */     
/* 493 */     return titledPanel;
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createWrappingLabel() {
/* 498 */     return createWrappingLabel(null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createWrappingLabel(Icon icon) {
/* 503 */     return createWrappingLabel(null, icon);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createWrappingLabel(String text) {
/* 508 */     return createWrappingLabel(text, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public XstLabel createWrappingLabel(String text, Icon icon) {
/* 513 */     XstLabel label = (XstLabel)createComponentWrapper("LabelWrapping");
/*     */     
/* 515 */     label.setText(text);
/* 516 */     label.setIcon(icon);
/*     */     
/* 518 */     return label;
/*     */   }
/*     */   
/*     */   public void initialize() {}
/*     */   
/*     */   public void setProperties(String argPropertyFileName) {
/* 524 */     this.componentMap_ = getProperties(argPropertyFileName, this.DEFAULT_COMPONENT_MAP);
/* 525 */     this.componentMapSource_ = argPropertyFileName;
/*     */   }
/*     */   
/*     */   protected IXstViewComponent createComponentWrapper(ResolvedFieldConfig argFieldDef) {
/* 529 */     String componentTypeName = argFieldDef.getType();
/*     */     
/* 531 */     IXstViewComponent componentWrapper = null;
/*     */     
/* 533 */     if (componentTypeName != null && !this.componentMap_.contains(componentTypeName) && componentTypeName
/* 534 */       .indexOf('.') > -1) {
/*     */       try {
/* 536 */         componentWrapper = (IXstViewComponent)ObjectUtils.createInstance(Class.forName(componentTypeName));
/*     */       }
/* 538 */       catch (Exception ex) {
/* 539 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     } else {
/*     */       
/* 543 */       componentWrapper = createComponentWrapper(componentTypeName, (ComponentID)null);
/*     */     } 
/*     */     
/* 546 */     return componentWrapper;
/*     */   }
/*     */ 
/*     */   
/*     */   protected IXstViewComponent createComponentWrapper(String componentType, ComponentID argID) {
/* 551 */     if (argID != null) {
/* 552 */       Class[] classArr = { ComponentID.class };
/* 553 */       Object[] objectArr = { argID };
/* 554 */       return createComponentWrapper(componentType, classArr, objectArr);
/*     */     } 
/*     */     
/* 557 */     return createComponentWrapper(componentType);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FormPanel createFormPanel(String argClassType, boolean argIsTitled, boolean argDesignMode) {
/* 562 */     FormPanel formPanel = null;
/* 563 */     Class<FormPanel> objClass = null;
/*     */     
/* 565 */     String name = this.componentMap_.getProperty(argClassType);
/* 566 */     if (!StringUtils.isEmpty(name)) {
/* 567 */       objClass = ObjectUtils.getClass(name);
/*     */     }
/* 569 */     if (objClass == null) {
/*     */       
/*     */       try {
/* 572 */         objClass = (Class)Class.forName(argClassType);
/*     */       }
/* 574 */       catch (ClassNotFoundException ex) {
/* 575 */         logger_.fatal("no mapping for '" + argClassType + "'.", ex);
/* 576 */         throw new ConfigException(ex);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 583 */       Constructor<?> objConstructor = objClass.getDeclaredConstructor(new Class[] { boolean.class, boolean.class });
/* 584 */       if (objConstructor != null) {
/* 585 */         formPanel = (FormPanel)objConstructor.newInstance(new Object[] { Boolean.valueOf(argIsTitled), Boolean.valueOf(argDesignMode) });
/*     */       }
/*     */     }
/* 588 */     catch (Exception ex) {
/* 589 */       logger_.debug("Could not instantiate '" + argClassType + "'.", ex);
/*     */     } 
/*     */     
/* 592 */     if (formPanel == null) {
/*     */       try {
/* 594 */         formPanel = objClass.newInstance();
/*     */       }
/* 596 */       catch (Exception ex) {
/* 597 */         logger_.fatal("Could not instantiate '" + argClassType + "'.", ex);
/* 598 */         throw new ConfigException(ex);
/*     */       } 
/*     */     }
/*     */     
/* 602 */     return formPanel;
/*     */   }
/*     */   
/*     */   protected void initTouchFunctionality(final JComponent component, IViewComponentConfig<?> config) {
/* 606 */     if (config != null && config instanceof AbstractFormComponentConfig && ((AbstractFormComponentConfig)config)
/* 607 */       .getTouchConfigurations() != null) {
/* 608 */       List<TouchConfig> configs = ((AbstractFormComponentConfig)config).getTouchConfigurations();
/*     */       
/* 610 */       boolean paintedTouch = false;
/*     */       
/* 612 */       for (TouchConfig touch : configs) {
/* 613 */         List<ITouchResponsivenessRule> rules = new ArrayList<>();
/* 614 */         IXstAction action = touch.getAction();
/*     */         
/* 616 */         if (action != null && AccessResponsivenessRule.getRules(action.getVisibilityRules()) != null) {
/* 617 */           rules.addAll(AccessResponsivenessRule.getRules(action.getVisibilityRules()));
/*     */         }
/*     */         
/* 620 */         if (touch.getResponsivenessRules() != null) {
/* 621 */           rules.addAll(touch.getResponsivenessRules());
/*     */         }
/*     */         
/* 624 */         if (touch.isPaintingTouch() && !paintedTouch) {
/* 625 */           component.addMouseListener(new MouseAdapter() {
/* 626 */                 private final Color origBackgroundColor_ = component.getBackground();
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void mousePressed(MouseEvent argE) {
/* 631 */                   component.setBackground(this.origBackgroundColor_.darker());
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void mouseReleased(MouseEvent argE) {
/* 637 */                   component.setBackground(this.origBackgroundColor_);
/*     */                 }
/*     */               });
/*     */           
/* 641 */           paintedTouch = true;
/*     */         } 
/*     */         
/* 644 */         this._touchHelper.addTouchResponsiveness(component, touch.getType(), (ActionListener)action, rules, touch
/* 645 */             .isSimulatingGlassPane());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private IXstViewComponent createComponentWrapper(IViewComponentConfig<?> config, boolean designMode) {
/* 652 */     String componentTypeName = config.getClassType();
/*     */     
/* 654 */     IXstViewComponent componentWrapper = null;
/*     */     
/* 656 */     if (componentTypeName != null && !this.componentMap_.contains(componentTypeName) && componentTypeName
/* 657 */       .indexOf('.') > -1) {
/*     */       try {
/* 659 */         componentWrapper = (IXstViewComponent)ObjectUtils.createInstance(Class.forName(componentTypeName));
/*     */       }
/* 661 */       catch (Exception ex) {
/* 662 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     } else {
/*     */       
/* 666 */       componentWrapper = createComponentWrapper(componentTypeName, config.getComponentId());
/*     */     } 
/*     */     
/* 669 */     if (componentWrapper != null) {
/* 670 */       initComponent(componentWrapper.getDisplayComponent(), config, designMode);
/*     */     }
/* 672 */     return componentWrapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IXstViewComponent createComponentWrapper(String componentType, Class[] argumentClasses, Object[] arguments) {
/* 679 */     if (componentType == null) {
/* 680 */       logger_.error("Component type cannot be null.  Component cannot be created.", new Throwable("STACK TRACE"));
/*     */       
/* 682 */       return null;
/*     */     } 
/*     */     try {
/* 685 */       return (IXstViewComponent)ObjectUtils.createInstance(this.componentMapSource_, this.componentMap_, componentType
/* 686 */           .toString(), argumentClasses, arguments);
/*     */     }
/* 688 */     catch (Exception ex) {
/* 689 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 690 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Properties getDefaultProperties() {
/* 695 */     return getProperties("componentWrapper", null);
/*     */   }
/*     */   
/*     */   private Properties getProperties(String argPropertyFileName, Properties argDefaultProperties) {
/* 699 */     Properties properties = new Properties(argDefaultProperties);
/* 700 */     return ResourceUtils.getProperties(argPropertyFileName, properties, logger_);
/*     */   }
/*     */   
/*     */   private void initComponent(JComponent component, IViewComponentConfig<?> config, boolean argDesignMode) {
/* 704 */     if (config.getLayout() != null) {
/*     */       try {
/* 706 */         component.setLayout(config.getLayoutManager());
/*     */       }
/* 708 */       catch (Exception ex) {
/* 709 */         logger_.error("Exception caught during component creation ", ex);
/*     */       } 
/*     */     }
/*     */     
/* 713 */     if (config.getName() != null) {
/* 714 */       component.setName(config.getName());
/*     */     }
/*     */     
/* 717 */     if (config.getWidth() > 0 && config.getHeight() > 0) {
/* 718 */       Dimension d = new Dimension(config.getWidth(), config.getHeight());
/* 719 */       component.setSize(d);
/* 720 */       component.setPreferredSize(d);
/*     */     } 
/* 722 */     if (config.getToolTip() != null) {
/* 723 */       component.setToolTipText(config.getToolTip());
/*     */     }
/* 725 */     if (config.getColorGroupConfig().getBgColor() != null) {
/* 726 */       component.setBackground(config.getColorGroupConfig().getBgColor());
/*     */     }
/* 728 */     if (config.getColorGroupConfig().getFgColor() != null) {
/* 729 */       component.setForeground(config.getColorGroupConfig().getFgColor());
/*     */     }
/*     */     
/* 732 */     if (config.isContextSensitive() && component instanceof IContextChangeListener) {
/* 733 */       IContextChangeListener listener = (IContextChangeListener)component;
/*     */       
/* 735 */       ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener(listener, config
/* 736 */           .getContextSensitiveConstraint());
/*     */     } 
/*     */     
/* 739 */     component.setEnabled(config.getEnabled());
/* 740 */     component.setVisible(config.getVisible());
/*     */     
/* 742 */     for (ParameterConfig param : config.getComponentParameters()) {
/* 743 */       param.setParameterOn(component);
/*     */     }
/* 745 */     if (!argDesignMode)
/* 746 */       initTouchFunctionality(component, config); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstViewComponentFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */