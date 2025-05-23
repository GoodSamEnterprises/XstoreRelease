/*     */ package dtv.pos.framework.form.config;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.form.component.FormPanel;
/*     */ import dtv.pos.framework.form.component.HeaderDetailFooterFormPanel;
/*     */ import dtv.pos.framework.form.component.IMasterDetailFormPanel;
/*     */ import dtv.pos.framework.form.component.MasterDetailFormPanel;
/*     */ import dtv.pos.framework.form.component.TransactionFormPanel;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.FormPanelType;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.config.IActionGroupConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.pos.ui.component.PosFormPanel;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IParentConfig;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.JComponent;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class FormViewConfigHelper extends ConfigHelper<FormViewSetConfig> {
/*  50 */   private static final Logger logger_ = Logger.getLogger(FormViewConfigHelper.class); public static final String FORM_DIR = "form";
/*     */   private static final int BACKUP_LEVELS = 10;
/*  52 */   private final AtomicReference<Map<FormKey, IFormViewConfig>> uiHash_ = new AtomicReference<>();
/*     */ 
/*     */   
/*     */   IFormViewConfig currentFormView_;
/*     */ 
/*     */   
/*     */   String workingDir_;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   @Inject
/*     */   private IVisibilityRuleLocator _visibilityRuleLocator;
/*     */   
/*     */   @Inject
/*     */   private FormLayoutConfigHelper _formLayoutConfigHelper;
/*     */ 
/*     */   
/*     */   public FormViewConfigHelper(String argWorkingDir) {
/*  72 */     this();
/*  73 */     this.workingDir_ = argWorkingDir;
/*     */   }
/*     */   
/*     */   public void addFormConfig(IFormViewConfig config) {
/*  77 */     ((FormViewSetConfig)getRootConfig()).addChild((IConfigObject)config);
/*  78 */     ((Map<FormKey, IFormViewConfig>)this.uiHash_.get()).put(config.getFormKey(), config);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormPanel assemble(FormKey formKey) {
/*  88 */     return assemble(formKey, false);
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
/*     */   public FormPanel<IFormModel> assemble(FormKey formKey, boolean designMode) {
/* 100 */     FormPanel<IFormModel> formPanel = null;
/* 101 */     logger_.debug("assembling " + formKey);
/*     */     
/*     */     try {
/* 104 */       FormViewConfig formUIConfig = getFormViewConfig(formKey);
/*     */       
/* 106 */       if (formUIConfig != null) {
/* 107 */         this.currentFormView_ = formUIConfig;
/* 108 */         boolean isTitled = FormLocationType.POPUP_VIEW_PANEL.equals(formUIConfig.getFormLocation());
/*     */ 
/*     */         
/* 111 */         if (formUIConfig.getCustomViewClass() != null) {
/*     */           
/* 113 */           Class<?> panelClass = formUIConfig.getCustomViewClass();
/* 114 */           IXstViewComponent panel = (IXstViewComponent)ObjectUtils.createInstance(panelClass);
/*     */           
/* 116 */           formPanel = new FormPanel((PosFormPanel)panel.getDisplayComponent(), isTitled);
/* 117 */           JComponent displayComponent = panel.getDisplayComponent();
/*     */           
/* 119 */           if (displayComponent instanceof IFormComponent) {
/* 120 */             formPanel.addFormComponent((IFormComponent)displayComponent, null);
/*     */           } else {
/*     */             
/* 123 */             logger_.warn((displayComponent == null) ? null : (displayComponent
/* 124 */                 .getClass().getName() + " does not implement " + IFormComponent.class));
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 129 */           formPanel = assembleFormPanel(formUIConfig, formUIConfig.getViewPanelConfigs(), isTitled, designMode);
/*     */         } 
/*     */       } else {
/*     */         
/* 133 */         logger_.error("The requested form UI does not exist [" + formKey + "]");
/*     */       }
/*     */     
/* 136 */     } catch (Exception ex) {
/* 137 */       logger_.error("Exception assembling form UI from config [" + formKey + "]", ex);
/*     */     } 
/* 139 */     return formPanel;
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
/*     */   public Collection<IXstAction> getActions(IFormModel formModel, DataActionGroupKey actionGroupKey, String actionGroupSubKey) {
/* 155 */     return getActions(formModel, actionGroupKey, actionGroupSubKey, true);
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
/*     */   public Collection<IXstAction> getActions(IFormModel argFormModel, DataActionGroupKey argGroupKey, String argSubGroupKey, boolean argIncludeHelpAction) {
/*     */     DataActionGroupKey groupKey;
/* 175 */     if (argGroupKey == null) {
/* 176 */       logger_.warn("passed a null action group key, using 'DEFAULT' instead", new Throwable("STACK TRACE"));
/* 177 */       groupKey = DataActionGroupKey.DEFAULT;
/*     */     } else {
/*     */       
/* 180 */       groupKey = argGroupKey;
/*     */     } 
/*     */     
/* 183 */     Collection<IXstAction> actions = null;
/* 184 */     FormKey formKey = argFormModel.getFormKey();
/*     */     
/* 186 */     if (logger_.isDebugEnabled()) {
/* 187 */       logger_.debug("getting actions " + formKey);
/*     */     }
/*     */     
/* 190 */     IFormViewConfig ui = (IFormViewConfig)((Map)this.uiHash_.get()).get(formKey);
/*     */     
/* 192 */     if (ui != null) {
/* 193 */       actions = ui.getPromptActions(argFormModel.getEditModel(), groupKey, argSubGroupKey);
/*     */     }
/*     */     
/* 196 */     IXstAction helpAction = this._actionFactory.getHelpAction();
/*     */ 
/*     */     
/* 199 */     boolean isHelpActionDefined = false;
/* 200 */     for (IXstAction action : actions) {
/* 201 */       if (action.getKeyStroke() != null && action.getKeyStroke().equals(helpAction.getKeyStroke())) {
/* 202 */         isHelpActionDefined = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 207 */     if (argIncludeHelpAction && actions != null && helpAction != null && !isHelpActionDefined) {
/* 208 */       actions.add(helpAction);
/*     */     }
/*     */     
/* 211 */     return actions;
/*     */   }
/*     */   
/*     */   public FormViewConfig getFormViewConfig(FormKey argKey) {
/* 215 */     return (FormViewConfig)((Map)this.uiHash_.get()).get(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription(FormKey argFormKey) {
/* 225 */     FormViewConfig formUIConfig = getFormViewConfig(argFormKey);
/* 226 */     return (formUIConfig == null) ? "not found" : formUIConfig.getSourceUrl();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/* 231 */     super.initializeImpl();
/*     */     
/* 233 */     FormViewSetConfig root = (FormViewSetConfig)getRootConfig();
/* 234 */     Collection<IFormViewConfig> children = root.getChildren();
/*     */     
/* 236 */     if (children != null) {
/* 237 */       Map<FormKey, IFormViewConfig> newUiHash = new HashMap<>();
/* 238 */       for (IFormViewConfig config : children) {
/* 239 */         if (isFormOverriden(config, newUiHash)) {
/* 240 */           copyOverridenFormComponents(config, newUiHash);
/*     */           continue;
/*     */         } 
/* 243 */         newUiHash.put(config.getFormKey(), config);
/*     */       } 
/*     */       
/* 246 */       this.uiHash_.set(newUiHash);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCellVisible(String argVisibilityGroup) {
/*     */     try {
/* 252 */       IVisibilityRule rule = this._visibilityRuleLocator.getVisibilityRule(argVisibilityGroup);
/* 253 */       return rule.checkVisibility().isGranted();
/*     */     }
/* 255 */     catch (Exception ex) {
/* 256 */       logger_.warn("VisibilityGroup [" + argVisibilityGroup + "] was referenced in the form, but could not be found in configuration.");
/*     */       
/* 258 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isDirty() {
/* 263 */     for (IFormViewConfig item : ((Map)this.uiHash_.get()).values()) {
/* 264 */       if (item.isDirty()) {
/* 265 */         return true;
/*     */       }
/*     */     } 
/* 268 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isFormConfigurationExist(FormKey argKey) {
/* 272 */     return (getFormViewConfig(argKey) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(File configDir) throws IOException {
/* 278 */     for (IFormViewConfig item : ((Map)this.uiHash_.get()).values()) {
/* 279 */       String configName = configDir.getAbsolutePath() + "/" + item.getFormKey().toString() + ".xml";
/* 280 */       File origFile = new File(configName);
/*     */       
/* 282 */       if (item.isDirty()) {
/* 283 */         File tempFile = File.createTempFile("frm", ".tmp", configDir);
/* 284 */         tempFile.createNewFile();
/* 285 */         XmlWriter writer = openFile(tempFile);
/* 286 */         item.write(writer);
/* 287 */         closeFile(writer);
/* 288 */         moveToBackup(origFile);
/* 289 */         tempFile.renameTo(new File(configName));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveToDir(File argFormConfigDir_) {}
/*     */ 
/*     */   
/*     */   protected void addFormComponent(IFormComponent parent, IFormComponent child, IFormComponentConfig<IFormComponentConfig> childConfig) {
/* 299 */     if (parent != null && child != null && childConfig != null) {
/* 300 */       String location = childConfig.getLayoutLocation();
/*     */ 
/*     */       
/* 303 */       parent.getContainer().add(child.getDisplayComponent(), (location == null) ? "" : location);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IFormComponent assembleFormComponent(IFormComponentConfig<IFormComponentConfig> formComponentConfig, boolean argDesignMode) {
/* 311 */     if (formComponentConfig instanceof FormViewPanelConfig) {
/* 312 */       return (IFormComponent)assembleFormPanel((FormViewPanelConfig)formComponentConfig, false, argDesignMode);
/*     */     }
/*     */ 
/*     */     
/* 316 */     IFormComponent formComponent = XstViewComponentFactory.getInstance().createFormComponent(formComponentConfig, argDesignMode);
/*     */     
/* 318 */     if (argDesignMode) {
/* 319 */       formComponent.setConfig(formComponentConfig);
/*     */     }
/* 321 */     Collection<IFormComponentConfig> childConfigs = formComponentConfig.getChildren();
/*     */     
/* 323 */     if (childConfigs != null) {
/* 324 */       for (IFormComponentConfig<IFormComponentConfig> childConfig : childConfigs) {
/* 325 */         IFormComponent child = assembleFormComponent(childConfig, argDesignMode);
/* 326 */         addFormComponent(formComponent, child, childConfig);
/*     */       } 
/*     */     }
/*     */     
/* 330 */     return formComponent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormPanel<IFormModel> assembleFormPanel(IFormViewPanelConfig<IFormComponentConfig> formPanelConfig, boolean argIsTitled, boolean argDesignMode) {
/* 338 */     if (formPanelConfig.getCustomViewClass() != null) {
/* 339 */       Class panelClass = formPanelConfig.getCustomViewClass();
/* 340 */       IXstViewComponent panel = (IXstViewComponent)ObjectUtils.createInstance(panelClass);
/*     */       
/* 342 */       FormPanel<IFormModel> formPanel1 = null;
/*     */       
/* 344 */       if (formPanelConfig.getClassType() != null && formPanelConfig.getClassType().indexOf('.') >= 0) {
/*     */ 
/*     */         
/* 347 */         formPanel1 = null;
/*     */         try {
/* 349 */           Class<?> clazz = ObjectUtils.getClass(formPanelConfig.getClassType());
/* 350 */           Constructor<?> c = clazz.getConstructor(new Class[] { PosFormPanel.class, boolean.class });
/* 351 */           formPanel1 = (FormPanel<IFormModel>)c.newInstance(new Object[] { panel.getDisplayComponent(), Boolean.valueOf(argIsTitled) });
/*     */         }
/* 353 */         catch (Exception ex) {
/* 354 */           logger_.error("Could not instantiate '" + formPanelConfig.getClassType() + "'.", ex);
/*     */         } 
/*     */       } 
/*     */       
/* 358 */       if (formPanel1 == null) {
/* 359 */         formPanel1 = new FormPanel((PosFormPanel)panel.getDisplayComponent(), argIsTitled);
/*     */       }
/*     */       
/* 362 */       IFormComponent custComponent = (IFormComponent)panel.getDisplayComponent();
/* 363 */       formPanel1.addFormComponent(custComponent, null);
/*     */       
/* 365 */       formPanel1.init((IFormComponentConfig)formPanelConfig);
/* 366 */       custComponent.init((IFormComponentConfig)formPanelConfig);
/* 367 */       if (argDesignMode) {
/* 368 */         formPanel1.setConfig((IFormComponentConfig)formPanelConfig);
/* 369 */         custComponent.setConfig((IFormComponentConfig)formPanelConfig);
/*     */       } 
/*     */       
/* 372 */       formPanel1.setActionSubGroupKey(formPanelConfig.getActionSubGroupKey());
/* 373 */       return formPanel1;
/*     */     } 
/*     */ 
/*     */     
/* 377 */     FormPanel<IFormModel> formPanel = XstViewComponentFactory.getInstance().createFormPanel((IFormComponentConfig)formPanelConfig, argIsTitled, argDesignMode);
/*     */     
/* 379 */     List<IFormComponentConfig> childConfigs = formPanelConfig.getChildren();
/* 380 */     if (childConfigs != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 386 */       childConfigs = new ArrayList<>(childConfigs);
/* 387 */       Collections.sort(childConfigs);
/*     */       
/* 389 */       for (IFormComponentConfig<IFormComponentConfig> childConfig : childConfigs) {
/* 390 */         IFormViewPanelConfig iFormViewPanelConfig; if (childConfig instanceof dtv.pos.iframework.form.config.IFormViewSectionRefConfig) {
/* 391 */           IFormViewSectionConfig section = getFormViewSection(childConfig.getName());
/* 392 */           if (section != null && section.getFormViewPanel() != null) {
/* 393 */             iFormViewPanelConfig = section.getFormViewPanel();
/*     */           } else {
/*     */             continue;
/*     */           } 
/*     */         } 
/*     */         
/* 399 */         if (iFormViewPanelConfig instanceof IFormViewCellConfig) {
/* 400 */           String visibilityGroup = ((IFormViewCellConfig)iFormViewPanelConfig).getVisibilityGroup();
/* 401 */           if (visibilityGroup != null && 
/* 402 */             !isCellVisible(visibilityGroup) && !argDesignMode) {
/*     */             continue;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 408 */         IFormComponent childComponent = assembleFormComponent((IFormComponentConfig<IFormComponentConfig>)iFormViewPanelConfig, argDesignMode);
/*     */         
/* 410 */         if (childComponent instanceof FormPanel) {
/* 411 */           ((FormPanel)childComponent).getContainer().setFocusCycleRoot(false);
/* 412 */           ((FormPanel)childComponent).getContainer().setFocusable(false);
/*     */         } 
/*     */         
/* 415 */         formPanel.addFormComponent(childComponent, iFormViewPanelConfig.getResource());
/* 416 */         addFormComponent((IFormComponent)formPanel, childComponent, (IFormComponentConfig<IFormComponentConfig>)iFormViewPanelConfig);
/*     */       } 
/*     */     } 
/*     */     
/* 420 */     formPanel.setActionSubGroupKey(formPanelConfig.getActionSubGroupKey());
/* 421 */     return formPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormPanel<IFormModel> assembleHeaderDetailFooterPanel(IFormViewPanelConfig[] argFormPanelConfigs, boolean argIsTitled, boolean argDesignMode) {
/* 428 */     IFormViewPanelConfig<IFormComponentConfig> headerPanel = null, detailPanel = null, footerPanel = null;
/*     */     
/* 430 */     for (IFormViewPanelConfig<IFormComponentConfig> pc : argFormPanelConfigs) {
/* 431 */       FormPanelType type = pc.getPanelType();
/* 432 */       if (FormPanelType.HEADER.equals(type)) {
/* 433 */         headerPanel = pc;
/*     */       }
/* 435 */       else if (FormPanelType.DETAIL.equals(type)) {
/* 436 */         detailPanel = pc;
/*     */       }
/* 438 */       else if (FormPanelType.FOOTER.equals(type)) {
/* 439 */         footerPanel = pc;
/*     */       } else {
/*     */         
/* 442 */         logger_.warn("unexpected panel type " + type);
/*     */       } 
/*     */     } 
/*     */     
/* 446 */     HeaderDetailFooterFormPanel<IFormModel> rootPanel = new HeaderDetailFooterFormPanel(argIsTitled);
/*     */     
/* 448 */     if (headerPanel != null) {
/* 449 */       rootPanel.setHeaderView(assembleFormPanel(headerPanel, argIsTitled, argDesignMode));
/*     */     }
/* 451 */     if (footerPanel != null) {
/* 452 */       rootPanel.setFooterView(assembleFormPanel(footerPanel, argIsTitled, argDesignMode));
/*     */     }
/* 454 */     if (detailPanel != null) {
/* 455 */       rootPanel.setDetailView(assembleFormPanel(detailPanel, argIsTitled, argDesignMode));
/*     */     }
/* 457 */     return (FormPanel<IFormModel>)rootPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormPanel<IFormModel> assembleMasterDetailPanel(String argLayoutName, IFormViewPanelConfig[] argFormPanelConfigs, boolean argIsTitled, boolean argDesignMode) {
/* 463 */     IFormViewPanelConfig<IFormComponentConfig> masterPanel = null;
/* 464 */     List<IFormViewPanelConfig> detailPanels = new ArrayList<>();
/*     */     
/* 466 */     for (IFormViewPanelConfig<IFormComponentConfig> pc : argFormPanelConfigs) {
/* 467 */       FormPanelType type = pc.getPanelType();
/* 468 */       if (FormPanelType.MASTER.equals(type)) {
/* 469 */         masterPanel = pc;
/*     */         
/* 471 */         if (masterPanel.getComponentId() == null) {
/* 472 */           masterPanel.setComponentId(DtvPanel.CONTEXT_HEADER_PANEL_ID.getIDName());
/*     */         }
/*     */       }
/* 475 */       else if (FormPanelType.DETAIL.equals(type)) {
/* 476 */         detailPanels.add(pc);
/*     */         
/* 478 */         if (pc.getComponentId() == null) {
/* 479 */           pc.setComponentId(DtvPanel.CONTEXT_PANEL_ID.getIDName());
/*     */         }
/*     */       } else {
/*     */         
/* 483 */         logger_.warn("unexpected panel type " + type);
/*     */       } 
/*     */     } 
/*     */     
/* 487 */     Collections.sort(detailPanels, (arg1, arg2) -> arg1.getTabOrder().compareTo(arg2.getTabOrder()));
/*     */     
/* 489 */     IMasterDetailFormPanel rootPanel = createMasterDetailFormPanel(argLayoutName, argIsTitled);
/* 490 */     if (masterPanel != null) {
/* 491 */       rootPanel.setMasterView(assembleFormPanel(masterPanel, argIsTitled, argDesignMode));
/*     */     }
/* 493 */     if (detailPanels.size() == 1) {
/* 494 */       rootPanel.setDetailView(assembleFormPanel(detailPanels.get(0), argIsTitled, argDesignMode));
/*     */     } else {
/*     */       
/* 497 */       for (int i = 0; i < detailPanels.size(); i++) {
/* 498 */         rootPanel.addDetailView(assembleFormPanel(detailPanels.get(i), argIsTitled, argDesignMode));
/*     */       }
/*     */     } 
/* 501 */     return (FormPanel<IFormModel>)rootPanel;
/*     */   }
/*     */ 
/*     */   
/*     */   protected FormPanel<IFormModel> assembleTransactionPanel(IFormViewPanelConfig[] argFormPanelConfigs, boolean argIsTitled, boolean argDesignMode) {
/* 506 */     IFormViewPanelConfig<IFormComponentConfig> topInfoPanel = null, bottomInfoPanel = null;
/* 507 */     IFormViewPanelConfig<IFormComponentConfig> transactionListFooterPanel = null, listPanel = null, topInfoFooterPanel = null;
/*     */     
/* 509 */     for (IFormViewPanelConfig<IFormComponentConfig> pc : argFormPanelConfigs) {
/* 510 */       FormPanelType type = pc.getPanelType();
/* 511 */       switch (type) {
/*     */         case TOP_INFO:
/* 513 */           topInfoPanel = pc;
/*     */           break;
/*     */         case TOP_INFO_FOOTER:
/* 516 */           topInfoFooterPanel = pc;
/*     */           break;
/*     */         case BOTTOM_INFO:
/* 519 */           bottomInfoPanel = pc;
/*     */           break;
/*     */         case LIST:
/* 522 */           listPanel = pc;
/*     */           break;
/*     */         case LIST_FOOTER:
/* 525 */           transactionListFooterPanel = pc;
/*     */           break;
/*     */         default:
/* 528 */           logger_.warn("unexpected panel type " + type);
/*     */           break;
/*     */       } 
/*     */     } 
/* 532 */     TransactionFormPanel<IFormModel> rootPanel = new TransactionFormPanel(argIsTitled);
/* 533 */     if (topInfoPanel != null) {
/* 534 */       rootPanel.setTopInfoView(assembleFormPanel(topInfoPanel, argIsTitled, argDesignMode));
/*     */     }
/* 536 */     if (bottomInfoPanel != null) {
/* 537 */       rootPanel.setBottomInfoView(assembleFormPanel(bottomInfoPanel, argIsTitled, argDesignMode));
/*     */     }
/* 539 */     if (listPanel != null) {
/* 540 */       rootPanel.setListView(assembleFormPanel(listPanel, argIsTitled, argDesignMode));
/*     */     }
/* 542 */     if (transactionListFooterPanel != null) {
/* 543 */       rootPanel.setTransactionListFooterView(
/* 544 */           assembleFormPanel(transactionListFooterPanel, argIsTitled, argDesignMode));
/*     */     }
/* 546 */     if (topInfoFooterPanel != null) {
/* 547 */       rootPanel.setTopInfoFooterView(assembleFormPanel(topInfoFooterPanel, argIsTitled, argDesignMode));
/*     */     }
/* 549 */     return (FormPanel<IFormModel>)rootPanel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void closeFile(XmlWriter writer) throws IOException {
/* 555 */     writer.writeFooter("FormViewSet");
/* 556 */     writer.flush();
/* 557 */     writer.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void copyOverridenFormComponents(IFormViewConfig argConfig, Map<FormKey, IFormViewConfig> argHash) {
/* 563 */     boolean inWorkingDir = false;
/*     */     
/* 565 */     String working = (this.workingDir_ != null && !this.workingDir_.isEmpty()) ? ("file:/" + this.workingDir_.replaceAll("\\\\", "/").toLowerCase()) : null;
/*     */     
/* 567 */     String local = (argConfig.getSourceUrl() != null && !argConfig.getSourceUrl().isEmpty()) ? argConfig.getSourceUrl().toLowerCase() : null;
/* 568 */     if (working != null && local != null && 
/* 569 */       local.startsWith(working)) {
/* 570 */       inWorkingDir = true;
/*     */     }
/*     */ 
/*     */     
/* 574 */     IFormViewConfig currentConfig = argHash.get(argConfig.getFormKey());
/*     */     
/* 576 */     currentConfig.setSourceInfo(argConfig.getSourceUrl(), argConfig.getSourceLineNumber());
/*     */     
/* 578 */     for (IFormViewPanelConfig panel : argConfig.getViewPanelConfigs()) {
/* 579 */       if (!panel.getVisible()) {
/* 580 */         currentConfig.removeViewPanelConfig(panel);
/*     */       } else {
/*     */         
/* 583 */         if (inWorkingDir) {
/* 584 */           ((IParentConfig)panel).setDirty();
/*     */         }
/* 586 */         currentConfig.addViewPanelConfig(panel);
/*     */       } 
/*     */     } 
/*     */     
/* 590 */     for (IFormViewSectionConfig section : argConfig.getViewSectionConfigs()) {
/* 591 */       if (!section.getVisible()) {
/* 592 */         currentConfig.removeViewSectionConfig(section);
/*     */       } else {
/*     */         
/* 595 */         if (inWorkingDir) {
/* 596 */           ((IParentConfig)section).setDirty();
/*     */         }
/* 598 */         currentConfig.addViewSectionConfig(section);
/*     */       } 
/*     */     } 
/*     */     
/* 602 */     for (IActionGroupConfig action : argConfig.getActionGroupConfigs()) {
/* 603 */       if (inWorkingDir) {
/* 604 */         ((IParentConfig)action).setDirty();
/*     */       }
/* 606 */       currentConfig.addActionGroupConfig(action);
/*     */     } 
/* 608 */     if (!inWorkingDir) {
/* 609 */       currentConfig.setClean();
/*     */     }
/*     */   }
/*     */   
/*     */   protected IMasterDetailFormPanel createMasterDetailFormPanel(String argLayoutName, boolean argIsTitled) {
/* 614 */     FormLayoutConfig layoutConfig = this._formLayoutConfigHelper.getFormLayout(argLayoutName);
/* 615 */     return (IMasterDetailFormPanel)new MasterDetailFormPanel(layoutConfig, argIsTitled);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/* 620 */     return "form";
/*     */   }
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 625 */     if ("FormViewSet".equalsIgnoreCase(dtype)) {
/* 626 */       return (IConfigObject)new FormViewSetConfig();
/*     */     }
/* 628 */     if ("FormView".equalsIgnoreCase(dtype)) {
/* 629 */       return (IConfigObject)new FormViewConfig();
/*     */     }
/* 631 */     if ("FormViewPanel".equalsIgnoreCase(dtype)) {
/* 632 */       return (IConfigObject)new FormViewPanelConfig();
/*     */     }
/* 634 */     if ("FormViewSectionRef".equalsIgnoreCase(dtype)) {
/* 635 */       return (IConfigObject)new FormViewSectionRefConfig();
/*     */     }
/* 637 */     if ("FormViewSection".equalsIgnoreCase(dtype)) {
/* 638 */       return (IConfigObject)new FormViewSectionConfig();
/*     */     }
/* 640 */     if ("FormViewCell".equalsIgnoreCase(dtype)) {
/* 641 */       return (IConfigObject)new FormViewCellConfig();
/*     */     }
/* 643 */     if ("TableColumns".equalsIgnoreCase(dtype)) {
/* 644 */       return (IConfigObject)new TableColumnsConfig();
/*     */     }
/* 646 */     if ("TableColumn".equalsIgnoreCase(dtype)) {
/* 647 */       return (IConfigObject)new TableColumnConfig();
/*     */     }
/* 649 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*     */   }
/*     */   
/*     */   protected IFormViewSectionConfig getFormViewSection(String argName) {
/* 653 */     return this.currentFormView_.getFormViewSection(argName);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isDirectoryBased() {
/* 658 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isFormOverriden(IFormViewConfig argConfig, Map<FormKey, IFormViewConfig> argUiHash) {
/* 663 */     boolean overriden = false;
/*     */     
/* 665 */     IFormViewConfig currentConfig = argUiHash.get(argConfig.getFormKey());
/* 666 */     if (currentConfig != null && currentConfig
/* 667 */       .getFormLocation().equals(argConfig.getFormLocation()) && this._formLayoutConfigHelper
/* 668 */       .getFormLayout(currentConfig.getFormLayoutName())
/* 669 */       .equals(this._formLayoutConfigHelper.getFormLayout(argConfig.getFormLayoutName()))) {
/* 670 */       overriden = true;
/*     */     }
/*     */     
/* 673 */     return overriden;
/*     */   }
/*     */   
/*     */   protected String makeBackupFileName(File origFile, int i) {
/* 677 */     return origFile.getPath() + "~" + i + "~";
/*     */   }
/*     */   
/*     */   protected void moveToBackup(File origFile) {
/* 681 */     for (int i = 10; i > 0; ) {
/* 682 */       File f1 = new File(makeBackupFileName(origFile, i));
/* 683 */       if (f1.exists()) {
/* 684 */         f1.delete();
/*     */       }
/* 686 */       File f2 = new File(makeBackupFileName(origFile, --i));
/* 687 */       if (f2.exists()) {
/* 688 */         f2.renameTo(f1);
/*     */       }
/*     */     } 
/* 691 */     origFile.renameTo(new File(makeBackupFileName(origFile, 1)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected XmlWriter openFile(File f) throws IOException {
/* 697 */     OutputStream out = new BufferedOutputStream(new FileOutputStream(f));
/* 698 */     XmlWriter writer = new XmlWriter(new OutputStreamWriter(out));
/* 699 */     writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
/* 700 */     writer.write("<!-- last saved in FormDesigner ");
/* 701 */     writer.write(DateUtils.getNewDate().toInstant().toString());
/* 702 */     writer.write(" -->\n");
/* 703 */     writer.write("<!-- NOTE: THIS CONFIG SHOULD BE MAINTAINED USING FormDesigner. ANY OTHER EDITS MAY GET LOST -->\n");
/*     */     
/* 705 */     writer.writeHeader("FormViewSet", "FormViewSet");
/*     */     
/* 707 */     return writer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormPanel<IFormModel> assembleFormPanel(IFormViewConfig formConfig, IFormViewPanelConfig<IFormComponentConfig>[] formPanelConfigs, boolean argIsTitled, boolean argDesignMode) {
/* 714 */     if (formPanelConfigs.length > 0 && FormPanelType.TOP_INFO.equals(formPanelConfigs[0].getPanelType())) {
/* 715 */       return assembleTransactionPanel((IFormViewPanelConfig[])formPanelConfigs, argIsTitled, argDesignMode);
/*     */     }
/* 717 */     if (formPanelConfigs.length > 0 && FormPanelType.HEADER.equals(formPanelConfigs[0].getPanelType())) {
/* 718 */       return assembleHeaderDetailFooterPanel((IFormViewPanelConfig[])formPanelConfigs, argIsTitled, argDesignMode);
/*     */     }
/* 720 */     if (formPanelConfigs.length == 1) {
/* 721 */       return assembleFormPanel(formPanelConfigs[0], argIsTitled, argDesignMode);
/*     */     }
/*     */     
/* 724 */     return assembleMasterDetailPanel(formConfig.getFormLayoutName(), (IFormViewPanelConfig[])formPanelConfigs, argIsTitled, argDesignMode);
/*     */   }
/*     */   
/*     */   public FormViewConfigHelper() {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */