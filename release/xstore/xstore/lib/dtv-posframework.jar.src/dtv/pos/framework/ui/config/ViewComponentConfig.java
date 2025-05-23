/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.form.LayoutLocation;
/*     */ import dtv.pos.framework.form.LayoutParameters;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.form.ILayoutLocation;
/*     */ import dtv.pos.iframework.form.design.model.ILayoutParameters;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.layout.TableLayout;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.ParameterListConfig;
/*     */ import java.awt.Component;
/*     */ import java.awt.LayoutManager;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ViewComponentConfig<C extends IViewComponentConfig>
/*     */   extends AbstractUIConfig
/*     */   implements IViewComponentConfig<C>, IReflectionParameterCapable<Component>, ISavableConfig
/*     */ {
/*     */   public static final String VIEW_COMPONENT_MAIN_TAG = "Component";
/*     */   protected static final String CLASS_TAG = "Class";
/*     */   protected static final String COMPONENT_ID_TAG = "ComponentId";
/*     */   protected static final String COMPONENT_PARAMETER_TAG = "ComponentParameter";
/*     */   protected static final String CONTEXT_SENSITIVE_CONSTRAINT_TAG = "ContextSensitiveConstraint";
/*     */   protected static final String DESCRIPTION_TAG = "Description";
/*     */   protected static final String ENABLED_TAG = "Enabled";
/*     */   protected static final String LAYOUT_LAYER_TAG = "LayoutLayer";
/*     */   protected static final String LAYOUT_LOCATION_TAG = "LayoutLocation";
/*     */   protected static final String LAYOUT_PARAMETER_LIST_TAG = "LayoutParameters";
/*     */   protected static final String LAYOUT_PARAMETER_TAG = "LayoutParameter";
/*     */   protected static final String LAYOUT_TAG = "Layout";
/*     */   protected static final String NAME_TAG = "Name";
/*     */   protected static final String TOOL_TIP_TAG = "ToolTip";
/*     */   protected static final String TYPE_TAG = "Type";
/*     */   protected static final String VISIBLE_TAG = "Visible";
/*     */   protected static final String TITLE_TAG = "Title";
/*  57 */   private static final Logger logger_ = Logger.getLogger(ViewComponentConfig.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   private List<C> children_;
/*     */   private boolean childrenSorted_ = false;
/*     */   private String classType_;
/*     */   private ComponentID compId_;
/*     */   private ClassConfig<? extends Component> componentClass_;
/*  65 */   private final List<ParameterConfig> componentParameterList_ = new ArrayList<>();
/*     */   
/*     */   private String contextSensitiveConstraint_;
/*     */   
/*     */   private IDataFieldConfig dataConfig_;
/*     */   
/*     */   private LayoutLocation editableLayoutLocation_;
/*     */   
/*     */   private LayoutParameters editableLayoutParameters_;
/*     */   
/*     */   private Boolean enabled_;
/*     */   private Boolean visible_;
/*     */   private Integer layer_;
/*  78 */   private IFormattableConfig title_ = (IFormattableConfig)new TranslatableConfig(); private ClassConfig<? extends LayoutManager> layout_; private String layoutParameter_; private String layoutLocation_; private ParameterListConfig layoutParameters; private String name_; private String description_;
/*     */   private String toolTip_;
/*     */   private String toString_;
/*     */   private Component c_;
/*     */   
/*     */   public void addChild(C child) {
/*  84 */     if (this.children_ == null) {
/*  85 */       this.children_ = new ArrayList<>();
/*     */     }
/*     */     try {
/*  88 */       this.children_.add(child);
/*  89 */       this.childrenSorted_ = false;
/*     */     }
/*  91 */     catch (ClassCastException ex) {
/*     */       
/*  93 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*  95 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteChild(C child) {
/* 100 */     if (this.children_ != null) {
/* 101 */       this.children_.remove(child);
/*     */     }
/* 103 */     setDirty();
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
/*     */   public final List<C> getChildren() {
/* 115 */     if (this.children_ != null) {
/* 116 */       if (!this.childrenSorted_) {
/* 117 */         if (sortChildren()) {
/* 118 */           List<C> l = this.children_;
/* 119 */           Collections.sort(l);
/*     */         } 
/* 121 */         this.childrenSorted_ = true;
/*     */       } 
/* 123 */       return Collections.unmodifiableList(this.children_);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClassType() {
/* 140 */     return this.classType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends Component> getComponentClass() {
/* 151 */     return (this.componentClass_ == null) ? null : this.componentClass_.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentID getComponentId() {
/* 161 */     return this.compId_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParameterConfig[] getComponentParameters() {
/* 166 */     return this.componentParameterList_.<ParameterConfig>toArray(new ParameterConfig[this.componentParameterList_.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/* 172 */     return "Component";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/* 178 */     return (this.componentClass_ == null) ? "" : this.componentClass_.getConfigValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getContextSensitiveConstraint() {
/* 183 */     return this.contextSensitiveConstraint_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataFieldConfig getDataConfig() {
/* 188 */     return this.dataConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 199 */     return this.description_;
/*     */   }
/*     */ 
/*     */   
/*     */   public LayoutLocation getEditableLayoutLocation() {
/* 204 */     if (this.editableLayoutLocation_ == null) {
/* 205 */       this.editableLayoutLocation_ = new LayoutLocation(getLayoutLocation());
/*     */     }
/* 207 */     return this.editableLayoutLocation_;
/*     */   }
/*     */ 
/*     */   
/*     */   public LayoutParameters getEditableLayoutParameters() {
/* 212 */     if (this.editableLayoutParameters_ == null) {
/* 213 */       this.editableLayoutParameters_ = new LayoutParameters(getLayoutParameters());
/*     */     }
/* 215 */     return this.editableLayoutParameters_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEnabled() {
/* 224 */     return ConfigUtils.asBool(this.enabled_, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends LayoutManager> getLayout() {
/* 235 */     return (this.layout_ == null) ? null : this.layout_.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getLayoutLayer() {
/* 240 */     return this.layer_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLayoutLocation() {
/* 251 */     return this.layoutLocation_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LayoutManager getLayoutManager() throws Exception {
/* 257 */     LayoutManager layout = getLayout().newInstance();
/* 258 */     if (getLayoutParameters() != null) {
/* 259 */       getLayoutParameters().setParametersOn(layout);
/*     */ 
/*     */     
/*     */     }
/* 263 */     else if (getLayoutParameter() != null && layout instanceof TableLayout) {
/* 264 */       String[] splits = getLayoutParameter().split(",");
/* 265 */       int cols = Integer.parseInt(splits[0].trim());
/* 266 */       int rows = Integer.parseInt(splits[1].trim());
/*     */       
/* 268 */       ((TableLayout)layout).setSize(cols, rows);
/* 269 */       if (splits.length > 2) {
/* 270 */         ((TableLayout)layout).setVerticalStretch(Boolean.valueOf(splits[2].trim()).booleanValue());
/*     */       }
/*     */     } 
/* 273 */     return layout;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLayoutParameter() {
/* 278 */     return this.layoutParameter_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParameterListConfig getLayoutParameters() {
/* 283 */     return this.layoutParameters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 294 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<Component> getParamDataType() {
/* 300 */     return Component.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getParamValue() {
/* 306 */     if (this.c_ == null) {
/* 307 */       this.c_ = XstViewComponentFactory.getInstance().createComponent(this, false);
/*     */     }
/*     */     
/* 310 */     return this.c_;
/*     */   }
/*     */   
/*     */   public IFormattable getTitle() {
/* 314 */     return (this.title_ != null) ? this.title_.getFormattable() : IFormattable.EMPTY;
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
/*     */   public String getToolTip() {
/* 328 */     return (this.toolTip_ == null || this.toolTip_.trim().length() == 0) ? null : this.toolTip_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVisible() {
/* 337 */     return ConfigUtils.asBool(this.visible_, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isContextSensitive() {
/* 346 */     return !StringUtils.isEmpty(this.contextSensitiveConstraint_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirty() {
/* 354 */     boolean dirty = ((this.layoutParameters != null && this.layoutParameters.isDirty()) || (this.editableLayoutParameters_ != null && this.editableLayoutParameters_.isDirty()) || (this.editableLayoutLocation_ != null && this.editableLayoutLocation_.isDirty()) || (this.dataConfig_ != null && this.dataConfig_.isDirty()) || super.isDirty());
/* 355 */     if (dirty) {
/* 356 */       return true;
/*     */     }
/* 358 */     for (int i = 0; this.children_ != null && i < this.children_.size(); i++) {
/* 359 */       ViewComponentConfig c = (ViewComponentConfig)this.children_.get(i);
/* 360 */       if (c.isDirty()) {
/* 361 */         return true;
/*     */       }
/*     */     } 
/* 364 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEntryMasked() {
/* 375 */     if (this.dataConfig_ != null) {
/* 376 */       return this.dataConfig_.isEntryMasked();
/*     */     }
/*     */     
/* 379 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClassType(String argClass) {
/* 389 */     this.toString_ = null;
/* 390 */     this.classType_ = argClass;
/* 391 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setClean() {
/* 396 */     super.setClean();
/* 397 */     if (this.layoutParameters != null) {
/* 398 */       this.layoutParameters.setClean();
/*     */     }
/* 400 */     if (this.editableLayoutParameters_ != null) {
/* 401 */       this.editableLayoutParameters_.setClean();
/*     */     }
/* 403 */     if (this.editableLayoutLocation_ != null) {
/* 404 */       this.editableLayoutLocation_.setClean();
/*     */     }
/* 406 */     if (this.dataConfig_ != null) {
/* 407 */       this.dataConfig_.setClean();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComponentClass(ClassConfig<? extends Component> argClassConfig) {
/* 418 */     this.toString_ = null;
/* 419 */     this.componentClass_ = argClassConfig;
/* 420 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComponentId(String compIdString) {
/* 430 */     this.compId_ = new ComponentID(compIdString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 441 */     this.toString_ = null;
/*     */     
/* 443 */     if (argKey.equalsIgnoreCase("Component") && argValue instanceof IViewComponentConfig) {
/* 444 */       addChild((C)argValue);
/*     */     }
/* 446 */     else if (argKey.equalsIgnoreCase("Name")) {
/* 447 */       setName(argValue.toString());
/*     */     }
/* 449 */     else if (argKey.equalsIgnoreCase("Title")) {
/* 450 */       setTitle((IFormattableConfig)argValue);
/*     */     }
/* 452 */     else if (argKey.equalsIgnoreCase("DataField")) {
/* 453 */       setDataConfig((DataFieldConfig)argValue);
/*     */     }
/* 455 */     else if (argKey.equalsIgnoreCase("Description")) {
/* 456 */       setDescription(argValue.toString());
/*     */     }
/* 458 */     else if (argKey.equalsIgnoreCase("ToolTip")) {
/* 459 */       setToolTip(argValue.toString());
/*     */     }
/* 461 */     else if (argKey.equalsIgnoreCase("Type")) {
/* 462 */       setClassType(argValue.toString());
/*     */     }
/* 464 */     else if (argKey.equalsIgnoreCase("Class")) {
/* 465 */       setComponentClass(ConfigUtils.toClassConfig(argValue));
/*     */     }
/* 467 */     else if (argKey.equalsIgnoreCase("Enabled")) {
/* 468 */       setEnabled(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 470 */     else if (argKey.equalsIgnoreCase("Visible")) {
/* 471 */       setVisible(Boolean.valueOf(ConfigUtils.toBoolean(argValue)));
/*     */     }
/* 473 */     else if (argKey.equalsIgnoreCase("ContextSensitiveConstraint")) {
/* 474 */       setContextSensitiveConstraint(argValue.toString());
/*     */     }
/* 476 */     else if (argKey.equalsIgnoreCase("Layout")) {
/* 477 */       setLayout(ConfigUtils.toClassConfig(argValue));
/*     */     }
/* 479 */     else if (argKey.equalsIgnoreCase("LayoutLayer")) {
/* 480 */       setLayoutLayer(Integer.valueOf(ConfigUtils.toInt(argValue)));
/*     */     }
/* 482 */     else if (argKey.equalsIgnoreCase("LayoutParameter")) {
/* 483 */       setLayoutParameter(argValue.toString());
/*     */     }
/* 485 */     else if (argKey.equalsIgnoreCase("LayoutParameters")) {
/* 486 */       setLayoutParameters((ParameterListConfig)argValue);
/*     */     }
/* 488 */     else if (argKey.equalsIgnoreCase("LayoutLocation")) {
/* 489 */       setLayoutLocation(argValue.toString());
/*     */     }
/* 491 */     else if (argKey.equalsIgnoreCase("ComponentId")) {
/* 492 */       setComponentId(argValue.toString());
/*     */     }
/* 494 */     else if (argValue instanceof ParameterConfig && "ComponentParameter".equalsIgnoreCase(argKey)) {
/* 495 */       this.componentParameterList_.add((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/* 498 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/* 500 */     setClean();
/*     */   }
/*     */   
/*     */   public void setContextSensitiveConstraint(String argConstraint) {
/* 504 */     this.toString_ = null;
/* 505 */     this.contextSensitiveConstraint_ = argConstraint;
/* 506 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setDataConfig(IDataFieldConfig dataConfig) {
/* 510 */     this.dataConfig_ = dataConfig;
/* 511 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 520 */     this.toString_ = null;
/* 521 */     this.description_ = argDescription;
/* 522 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabled(Boolean argEnabled) {
/* 530 */     this.toString_ = null;
/* 531 */     this.enabled_ = argEnabled;
/* 532 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLayout(ClassConfig<? extends LayoutManager> argLayout) {
/* 542 */     this.toString_ = null;
/* 543 */     this.layout_ = argLayout;
/* 544 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLayoutLocation(String argLoc) {
/* 554 */     this.toString_ = null;
/* 555 */     this.layoutLocation_ = argLoc;
/* 556 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setLayoutParameter(String argParm) {
/* 560 */     this.toString_ = null;
/* 561 */     this.layoutParameter_ = argParm;
/* 562 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setLayoutParameters(ParameterListConfig argParm) {
/* 566 */     this.toString_ = null;
/* 567 */     this.layoutParameters = argParm;
/* 568 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String argName) {
/* 578 */     this.toString_ = null;
/* 579 */     this.name_ = argName;
/* 580 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setTitle(IFormattableConfig argTitle) {
/* 584 */     this.title_ = argTitle;
/* 585 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setToolTip(String argTip) {
/* 595 */     this.toString_ = null;
/* 596 */     this.toolTip_ = argTip;
/* 597 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(Boolean argVisible) {
/* 605 */     this.toString_ = null;
/* 606 */     this.visible_ = argVisible;
/* 607 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 612 */     if (this.toString_ == null) {
/* 613 */       StringBuffer sb = new StringBuffer();
/* 614 */       sb.append(getClass().getName());
/* 615 */       sb.append("[");
/* 616 */       if (this.name_ != null) {
/* 617 */         sb.append("name=");
/* 618 */         sb.append(this.name_);
/* 619 */         sb.append(",");
/*     */       } 
/* 621 */       if (this.description_ != null) {
/* 622 */         sb.append("description=");
/* 623 */         sb.append(this.description_);
/* 624 */         sb.append(",");
/*     */       } 
/* 626 */       if (this.toolTip_ != null) {
/* 627 */         sb.append("toolTip_=");
/* 628 */         sb.append(this.toolTip_);
/* 629 */         sb.append(",");
/*     */       } 
/* 631 */       if (this.classType_ != null) {
/* 632 */         sb.append("classType=");
/* 633 */         sb.append(this.classType_);
/* 634 */         sb.append(",");
/*     */       } 
/* 636 */       if (this.componentClass_ != null) {
/* 637 */         sb.append("componentClass=");
/* 638 */         sb.append(this.componentClass_.getConfigValue());
/* 639 */         sb.append(",");
/*     */       } 
/* 641 */       if (this.layoutLocation_ != null) {
/* 642 */         sb.append("layoutLocation=");
/* 643 */         sb.append(this.layoutLocation_);
/* 644 */         sb.append(",");
/*     */       } 
/* 646 */       if (this.layout_ != null) {
/* 647 */         sb.append("layout=");
/* 648 */         sb.append(this.layout_);
/* 649 */         sb.append(",");
/*     */       } 
/* 651 */       if (this.layoutParameter_ != null) {
/* 652 */         sb.append("layoutParameter=");
/* 653 */         sb.append(this.layoutParameter_);
/* 654 */         sb.append(",");
/*     */       } 
/* 656 */       if (this.layoutParameters != null) {
/* 657 */         sb.append("layoutParameters=");
/* 658 */         sb.append(this.layoutParameters);
/* 659 */         sb.append(",");
/*     */       } 
/* 661 */       if (this.enabled_ != null) {
/* 662 */         sb.append("enabled=");
/* 663 */         sb.append(this.enabled_);
/* 664 */         sb.append(",");
/*     */       } 
/* 666 */       if (this.children_ != null) {
/* 667 */         sb.append("children=");
/* 668 */         sb.append(this.children_);
/*     */       } 
/* 670 */       sb.append("]");
/* 671 */       this.toString_ = sb.toString();
/*     */     } 
/* 673 */     return this.toString_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 680 */     StringBuilder attr = new StringBuilder();
/* 681 */     if (getName() != null) {
/* 682 */       attr.append(" name=\"");
/* 683 */       attr.append(getName());
/* 684 */       attr.append("\"");
/*     */     } 
/* 686 */     argWriter.writeHeader(getConfigDataType(), getConfigDataType(), attr.toString().trim());
/*     */     
/* 688 */     argWriter.writeValue("Type", "String", this.classType_);
/* 689 */     writeLayout(argWriter);
/* 690 */     writeLayoutParameters(argWriter);
/* 691 */     writeParameterConfigs(argWriter);
/*     */     
/* 693 */     argWriter.writeFooter(getConfigDataType());
/*     */   }
/*     */   
/*     */   protected boolean sortChildren() {
/* 697 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeLayout(IXmlWriter argWriter) throws IOException {
/* 702 */     Class<?> layout = getLayout();
/* 703 */     if (layout != null)
/*     */     {
/* 705 */       argWriter.writeValue("Layout", "Class", layout.getName());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeLayoutParameters(IXmlWriter argWriter) throws IOException {
/* 711 */     if (this.layoutParameters != null) {
/* 712 */       ParameterConfig[] parameters = this.layoutParameters.getParameters();
/* 713 */       if (parameters.length > 0) {
/* 714 */         argWriter.writeHeader("LayoutParameters", "ParameterList");
/* 715 */         for (ParameterConfig pc : parameters) {
/* 716 */           pc.write(argWriter);
/*     */         }
/* 718 */         argWriter.writeFooter("LayoutParameters");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeParameterConfigs(IXmlWriter argWriter) throws IOException {
/* 725 */     for (ParameterConfig parameterConfig : getComponentParameters()) {
/* 726 */       parameterConfig.write(argWriter, "ComponentParameter");
/*     */     }
/*     */   }
/*     */   
/*     */   private void setLayoutLayer(Integer layer) {
/* 731 */     this.layer_ = layer;
/* 732 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ViewComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */