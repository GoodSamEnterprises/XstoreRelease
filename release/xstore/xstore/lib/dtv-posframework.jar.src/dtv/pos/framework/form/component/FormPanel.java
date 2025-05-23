/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.ui.component.XstTitledInstructionPanel;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosFormPanel;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormPanel<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*  41 */   private static final Logger logger_ = Logger.getLogger(FormPanel.class);
/*     */   
/*  43 */   protected final Map<String, IFormComponent<?>> formComponentMap_ = new HashMap<>();
/*     */   
/*  45 */   private final List<IFormComponent> formComponents_ = new ArrayList<>();
/*     */   
/*     */   private final PosFormPanel formPanel_;
/*     */   protected final boolean isTitled_;
/*     */   protected XstTitledInstructionPanel titledPanel_;
/*     */   private TitledBorder formPanelTitledBorder_;
/*     */   private IFormattable borderTextKey_;
/*     */   private ChangeListener stateChangeListener_;
/*     */   
/*     */   public FormPanel() {
/*  55 */     this(false);
/*     */   }
/*     */   
/*     */   public FormPanel(boolean argIsTitled, boolean argDesignMode) {
/*  59 */     this(argDesignMode ? (PosFormPanel)PosComponentFactory.getInstance().createFormDesignPanel() : 
/*  60 */         PosComponentFactory.getInstance().createFormPanel(), argIsTitled);
/*     */   }
/*     */   
/*     */   public FormPanel(ComponentID argId) {
/*  64 */     this((PosFormPanel)PosComponentFactory.getInstance().createComponent("FormPanel", new Class[] { ComponentID.class }, new Object[] { argId }), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public FormPanel(PosFormPanel argFormPanel, boolean argIsTitled) {
/*  69 */     this.formPanel_ = argFormPanel;
/*  70 */     this.isTitled_ = argIsTitled;
/*  71 */     this.formPanel_.putClientProperty("COMPONENT_WRAPPER", this);
/*     */     
/*  73 */     if (this.isTitled_) {
/*  74 */       this.titledPanel_ = XstViewComponentFactory.getInstance().createTitledInstructionPanel((JComponent)this.formPanel_);
/*  75 */       this.titledPanel_.getDisplayComponent().putClientProperty("COMPONENT_WRAPPER", this);
/*  76 */       setComponent(this.titledPanel_.getDisplayComponent());
/*     */     } else {
/*     */       
/*  79 */       setComponent((JComponent)getFormPanel());
/*     */     } 
/*     */     
/*  82 */     this.stateChangeListener_ = new ChangeListener()
/*     */       {
/*     */         public void stateChanged(ChangeEvent argEvent) {
/*  85 */           FormPanel.this.formPanelTitledBorder_.setTitle(argEvent.getSource().toString());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected FormPanel(boolean argIsTitled) {
/*  91 */     this(argIsTitled, false);
/*     */   }
/*     */   
/*     */   public void addFormComponent(IFormComponent<?> comp, String argFieldKey) {
/*  95 */     this.formComponents_.add(comp);
/*     */     
/*  97 */     if (argFieldKey != null && argFieldKey.length() > 0) {
/*  98 */       this.formComponentMap_.put(argFieldKey, comp);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getContainer() {
/* 105 */     return (JComponent)this.formPanel_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 111 */     JComponent result = null;
/* 112 */     IEditModel editModel = getEditModel();
/* 113 */     if (editModel != null) {
/* 114 */       String field = editModel.getFocusRequestFieldKey();
/* 115 */       if (field != null && field.length() > 0) {
/* 116 */         Object<?> comp = (Object<?>)this.formComponentMap_.get(field);
/* 117 */         result = getValidFocusComponent(comp);
/*     */         
/* 119 */         if (result != null) {
/* 120 */           return result;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 126 */     IFormComponent[] components = getFormComponents();
/*     */     
/* 128 */     for (IFormComponent component : components) {
/* 129 */       result = getValidFocusComponent(component);
/* 130 */       if (result != null) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 135 */     return result;
/*     */   }
/*     */   
/*     */   public IFormComponent[] getFormComponents() {
/* 139 */     return this.formComponents_.<IFormComponent>toArray(new IFormComponent[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableString getMutableTitle() {
/* 147 */     return this.formPanel_.getMutableTitle();
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 151 */     return this.formPanel_.getTitle();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> config) {
/* 157 */     super.init(config);
/*     */     
/* 159 */     getFormPanel().setTitle(LocaleManager.getInstance().getRegisteredString(config.getTextKey()));
/*     */     
/* 161 */     if (config.getIconGroupConfig() != null && config.getIconGroupConfig().getIconConfig() != null) {
/* 162 */       this.titledPanel_.setIcon(config.getIconGroupConfig().getIconConfig().getIcon());
/*     */     }
/*     */     
/* 165 */     if (config instanceof IFormViewPanelConfig) {
/* 166 */       IFormViewPanelConfig<?> cfg = (IFormViewPanelConfig)config;
/* 167 */       if (cfg.getFormTabKey() != null) {
/* 168 */         getFormPanel().setName(cfg.getFormTabKey().toString());
/*     */       }
/*     */     }
/* 171 */     else if (config instanceof IFormViewCellConfig) {
/* 172 */       this.borderTextKey_ = ((IFormViewCellConfig)config).getBorderTextKey();
/* 173 */       setBorderLabel(this.borderTextKey_, config.getFontConfig().getFont());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/* 180 */     super.init(argFieldDef);
/* 181 */     this.formPanel_.putClientProperty("COMPONENT_WRAPPER", this);
/* 182 */     getFormPanel().setName(argFieldDef.getName());
/* 183 */     getFormPanel().setTitle(LocaleManager.getInstance().getRegisteredString(argFieldDef.getText()));
/*     */     
/* 185 */     if (this.isTitled_) {
/* 186 */       this.titledPanel_.getDisplayComponent().putClientProperty("COMPONENT_WRAPPER", this);
/* 187 */       setComponent(this.titledPanel_.getDisplayComponent());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionSubGroupKey(String argActionSubGroupKey) {
/* 196 */     this.formPanel_.setActionGroupKey(argActionSubGroupKey);
/*     */   }
/*     */   
/*     */   public void setModelEnabled(boolean enabled) {
/* 200 */     UIServices.setModelEnabled((Component)this.formPanel_, enabled);
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
/*     */   protected void createTitledBorder(IFormattable argTitle, Font argConfiguredFont) {
/* 214 */     MutableString registeredString_ = LocaleManager.getInstance().getRegisteredString(argTitle);
/*     */     
/* 216 */     registeredString_.addChangeListener(this.stateChangeListener_);
/*     */ 
/*     */     
/* 219 */     this.formPanelTitledBorder_ = new TitledBorder(argTitle.toString(OutputContextType.VIEW));
/*     */     
/* 221 */     if (argConfiguredFont != null) {
/* 222 */       this.formPanelTitledBorder_.setTitleFont(argConfiguredFont);
/*     */     } else {
/*     */       
/* 225 */       Font f = UIResourceManager.getInstance().getFont("_fontTitleMedium");
/* 226 */       this.formPanelTitledBorder_.setTitleFont(f);
/*     */     } 
/*     */     
/* 229 */     this.formPanel_.setBorder(this.formPanelTitledBorder_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   protected PosFormPanel getFormPanel() {
/* 240 */     return this.formPanel_;
/*     */   }
/*     */   
/*     */   protected JComponent getValidFocusComponent(Object component) {
/* 244 */     if (component != null) {
/* 245 */       if (component instanceof IFormComponent) {
/* 246 */         JComponent result = ((IFormComponent)component).getFocusComponent();
/* 247 */         if (isValidForFocus(result)) {
/* 248 */           return result;
/*     */         }
/*     */       } else {
/*     */         
/* 252 */         logger_.warn(component.getClass().getName() + " is not a " + IFormComponent.class.getName());
/*     */       } 
/*     */     }
/* 255 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initNewModelState(T argOldModel, T argNewModel) {
/* 261 */     super.initNewModelState(argOldModel, argNewModel);
/*     */     
/* 263 */     if (argNewModel != null && this.isTitled_) {
/* 264 */       this.titledPanel_.setTitle(argNewModel.getFormName());
/* 265 */       this.titledPanel_.setInstruction(argNewModel.getFormInstructions());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean isValidForFocus(JComponent comp) {
/* 270 */     return (comp != null && comp.isFocusable() && comp.isEnabled() && !(comp instanceof javax.swing.JLabel));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setModelImpl(T argOldModel, T argNewModel) {
/* 281 */     synchronized (this.formModelMutex_) {
/*     */       
/* 283 */       for (IFormComponent<T> comp : getFormComponents()) {
/* 284 */         comp.setModel((IModel)argNewModel);
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
/*     */   
/*     */   private void setBorderLabel(Object argValue, Font argConfigureFont) {
/*     */     IFormattable formattable;
/* 298 */     if (argValue == null) {
/* 299 */       formattable = IFormattable.EMPTY;
/*     */     }
/* 301 */     else if (argValue instanceof IFormattable) {
/* 302 */       formattable = (IFormattable)argValue;
/*     */     } else {
/*     */       
/* 305 */       formattable = FormattableFactory.getInstance().getSimpleFormattable(argValue.toString());
/*     */     } 
/*     */     
/* 308 */     createTitledBorder(formattable, argConfigureFont);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */