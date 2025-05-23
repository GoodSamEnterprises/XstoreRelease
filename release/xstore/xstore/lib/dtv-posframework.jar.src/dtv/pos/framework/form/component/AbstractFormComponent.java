/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.event.Event;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.handler.GatedEventHandler;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.form.FormUtils;
/*     */ import dtv.pos.framework.ui.component.IEvaluable;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.IModel;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.component.IFormComponent;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.ui.component.IRequirableComponent;
/*     */ import dtv.ui.IModelEnabled;
/*     */ import dtv.ui.IRequirableComponent;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import javax.swing.JComponent;
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
/*     */ public abstract class AbstractFormComponent<T extends IFormModel>
/*     */   implements IFormComponent<T>
/*     */ {
/*  43 */   private static final Logger logger_ = Logger.getLogger(AbstractFormComponent.class);
/*  44 */   private static final boolean isDebugEnabled_ = logger_.isDebugEnabled();
/*     */   
/*  46 */   protected final Object formModelMutex_ = new Object();
/*     */   
/*     */   protected String fieldKey_;
/*     */   
/*     */   protected IFormattable textKey_;
/*     */   
/*     */   protected JComponent component_;
/*     */   protected boolean readOnly_;
/*     */   protected boolean required_;
/*     */   protected Integer fieldWeight_;
/*     */   protected boolean _alwaysEnabled;
/*     */   private T formModel_;
/*     */   private boolean refuseModelChangeRequests_ = false;
/*     */   
/*  60 */   private final GatedEventHandler updateValueHandler_ = new GatedEventHandler(GatedEventHandler.PendingEventStrategy.NONE)
/*     */     {
/*     */       public String toString()
/*     */       {
/*  64 */         return AbstractFormComponent.this.toString();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected void handle(Event argEvent) {
/*     */         try {
/*  71 */           AbstractFormComponent.this.updateComponentValue();
/*     */         } finally {
/*     */           
/*  74 */           AbstractFormComponent.this.updateState();
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*  79 */   private final GatedEventHandler updateStateHandler_ = new GatedEventHandler(GatedEventHandler.PendingEventStrategy.NONE)
/*     */     {
/*     */       public String toString()
/*     */       {
/*  83 */         return AbstractFormComponent.this.toString();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected void handle(Event argEvent) {
/*  89 */         AbstractFormComponent.this.updateState();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormComponentConfig<?> getConfig() {
/*  97 */     return (IFormComponentConfig)getMostVisibleComponent().getClientProperty(CONFIG_PROPERTY_KEY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getContainer() {
/* 103 */     return getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/* 109 */     return this.component_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 115 */     return this.component_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getModelValue() {
/* 123 */     if (getEditModel() != null && !StringUtils.isEmpty(this.fieldKey_)) {
/*     */       try {
/* 125 */         return getEditModel().getValue(this.fieldKey_);
/*     */       }
/* 127 */       catch (Exception ex) {
/* 128 */         logger_.error("Exception reading data from edit model ", ex);
/*     */       } 
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/* 137 */     this.fieldKey_ = argCfg.getResource();
/* 138 */     this.readOnly_ = argCfg.isReadOnly();
/* 139 */     this.required_ = argCfg.isRequired();
/* 140 */     this.textKey_ = argCfg.getTextKey();
/* 141 */     this.fieldWeight_ = argCfg.getFieldWeight();
/* 142 */     this._alwaysEnabled = argCfg.isAlwaysEnabled();
/*     */ 
/*     */     
/* 145 */     updateComponentFont(argCfg);
/*     */ 
/*     */     
/* 148 */     Color fgColor = argCfg.getForegroundColor();
/* 149 */     if (fgColor != null) {
/* 150 */       getDisplayComponent().setForeground(fgColor);
/*     */     }
/* 152 */     Color bgColor = argCfg.getBackgroundColor();
/* 153 */     if (bgColor != null) {
/* 154 */       getDisplayComponent().setBackground(bgColor);
/*     */     }
/*     */     
/* 157 */     Integer width = argCfg.getWidthObject();
/* 158 */     Integer height = argCfg.getHeightObject();
/* 159 */     Dimension minSize = getDisplayComponent().getMinimumSize();
/* 160 */     Dimension prefSize = getDisplayComponent().getPreferredSize();
/* 161 */     Dimension size = getDisplayComponent().getSize();
/* 162 */     boolean modified = false;
/*     */     
/* 164 */     if (width != null) {
/* 165 */       size.setSize(width.intValue(), size.height);
/* 166 */       prefSize.setSize(width.intValue(), prefSize.height);
/* 167 */       minSize.setSize(width.intValue(), minSize.height);
/* 168 */       modified = true;
/*     */     } 
/* 170 */     if (height != null) {
/* 171 */       size.setSize(size.width, height.intValue());
/* 172 */       prefSize.setSize(prefSize.width, height.intValue());
/* 173 */       minSize.setSize(minSize.width, height.intValue());
/* 174 */       modified = true;
/*     */     } 
/* 176 */     if (modified) {
/* 177 */       getDisplayComponent().setMinimumSize(minSize);
/* 178 */       getDisplayComponent().setPreferredSize(prefSize);
/* 179 */       getDisplayComponent().setSize(size);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/* 186 */     this.fieldKey_ = argFieldDef.getResource();
/* 187 */     this.readOnly_ = false;
/* 188 */     this.required_ = argFieldDef.isRequired();
/* 189 */     this.textKey_ = argFieldDef.getText();
/*     */     
/* 191 */     JComponent fontComponent = getFontComponent();
/* 192 */     Font font = argFieldDef.getFont();
/*     */     
/* 194 */     if (font != null) {
/* 195 */       fontComponent.setFont(font);
/*     */     }
/*     */     
/* 198 */     if (argFieldDef.getForegroundColor() != null) {
/* 199 */       getDisplayComponent().setForeground(argFieldDef.getForegroundColor());
/*     */     }
/*     */   }
/*     */   
/*     */   public void setAlwaysEnabled(boolean argValue) {
/* 204 */     this._alwaysEnabled = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IFormComponentConfig<?> newValue) {
/* 210 */     getMostVisibleComponent().putClientProperty(CONFIG_PROPERTY_KEY, newValue);
/* 211 */     newValue.setActiveFormComponent(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setModel(T argNewModel) {
/* 217 */     synchronized (this.formModelMutex_) {
/*     */ 
/*     */       
/* 220 */       T oldModel = this.formModel_;
/* 221 */       this.formModel_ = argNewModel;
/*     */ 
/*     */       
/* 224 */       initNewModelRegistration(oldModel, argNewModel);
/*     */ 
/*     */       
/* 227 */       setModelImpl(oldModel, argNewModel);
/*     */       
/* 229 */       if (argNewModel != null)
/*     */       {
/* 231 */         initNewModelState(oldModel, argNewModel);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 239 */     return (this.textKey_ != null) ? StringUtils.nonNull(this.textKey_.getUnformattedData()) : this.fieldKey_;
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
/*     */   public final void updateComponentValue() {
/* 252 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void run()
/*     */           {
/* 263 */             if (AbstractFormComponent.isDebugEnabled_) {
/* 264 */               AbstractFormComponent.logger_.debug(AbstractFormComponent.this.fieldKey_ + ": START - refusing to respond to model updates.");
/*     */             }
/*     */             
/* 267 */             AbstractFormComponent.this.refuseModelChangeRequests_ = true;
/* 268 */             AbstractFormComponent.this.setWrappedComponentValue(AbstractFormComponent.this.getModelValue());
/* 269 */             AbstractFormComponent.this.refuseModelChangeRequests_ = false;
/*     */             
/* 271 */             AbstractFormComponent.this.updateEvaluableComponents(AbstractFormComponent.this.getDisplayComponent());
/*     */             
/* 273 */             if (AbstractFormComponent.isDebugEnabled_) {
/* 274 */               AbstractFormComponent.logger_.debug(AbstractFormComponent.this.fieldKey_ + ": END - refusing to respond to model updates.");
/*     */             }
/*     */           }
/*     */         },  true, false);
/*     */   }
/*     */   
/*     */   public void updateEvaluableComponents(Container parent) {
/* 281 */     if (parent instanceof IEvaluable) {
/* 282 */       ((IEvaluable)parent).evaluate(getModelValue());
/*     */     }
/*     */     
/* 285 */     for (Component c : parent.getComponents()) {
/* 286 */       if (c instanceof Container) {
/* 287 */         updateEvaluableComponents((Container)c);
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
/*     */ 
/*     */   
/*     */   protected void deregisterEventHandlers(T argModel) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterFieldHandlers(IEditModel argEditModel, String argFieldKey) {
/* 312 */     argEditModel.deregisterFieldHandler(this.fieldKey_, (IEventAware)this.updateValueHandler_);
/* 313 */     argEditModel.deregisterFieldHandler(this.fieldKey_, (IEventAware)this.updateStateHandler_);
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
/*     */   protected IEditModel getEditModel() {
/* 331 */     return (getModel() != null) ? getModel().getEditModel() : null;
/*     */   }
/*     */   
/*     */   protected JComponent getFontComponent() {
/* 335 */     return getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected T getModel() {
/* 343 */     return this.formModel_;
/*     */   }
/*     */   
/*     */   protected JComponent getMostVisibleComponent() {
/* 347 */     return getDisplayComponent();
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
/*     */   protected IValueWrapperFactory getValueWrapper() {
/* 359 */     IValueWrapperFactory valueWrapper = null;
/*     */     
/* 361 */     IEditModel em = getEditModel();
/* 362 */     if (em != null) {
/* 363 */       valueWrapper = em.getValueWrapper(this.fieldKey_);
/*     */     }
/* 365 */     return valueWrapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initNewModelState(T argOldModel, T argNewModel) {
/* 375 */     IEditModel newEditModel = argNewModel.getEditModel();
/*     */     
/* 377 */     if (newEditModel != null && !StringUtils.isEmpty(this.fieldKey_)) {
/*     */ 
/*     */       
/* 380 */       if (this.required_) {
/* 381 */         newEditModel.makeRequired(this.fieldKey_);
/*     */       }
/* 383 */       if (this.fieldWeight_ != null) {
/* 384 */         newEditModel.setFieldWeight(this.fieldKey_, this.fieldWeight_.intValue());
/*     */       }
/*     */       
/* 387 */       updateComponentValue();
/* 388 */       updateState();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 393 */       setComponentEnabled((!this.readOnly_ && argNewModel.isEditable()));
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
/*     */   protected void registerEventHandlers(T argModel) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerFieldHandlers(IEditModel argEditModel, String argFieldKey) {
/* 416 */     argEditModel.registerFieldHandler(this.fieldKey_, (IEventAware)this.updateValueHandler_, EditModelFieldChangeType.VALUE_CHANGED.toConstraint());
/* 417 */     argEditModel.registerFieldHandler(this.fieldKey_, (IEventAware)this.updateStateHandler_, EditModelFieldChangeType.CARDINALITY_CHANGED.toConstraint());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponent(IXstViewComponent argComp) {
/* 426 */     setComponent((argComp != null) ? argComp.getDisplayComponent() : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponent(JComponent argComp) {
/* 435 */     this.component_ = argComp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentEnabled(boolean argEnabled) {
/* 445 */     if (this.component_ instanceof IModelEnabled) {
/* 446 */       ((IModelEnabled)this.component_).setModelEnabled(argEnabled);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setModelImpl(T argOldModel, T argNewModel) {}
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
/*     */   protected Object unwrapValue(Object argWrappedValue) {
/* 485 */     return FormUtils.unwrapValue(getValueWrapper(), argWrappedValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateComponentFont(IFormComponentConfig<?> argCfg) {
/* 493 */     JComponent fontComponent = getFontComponent();
/* 494 */     Font baseFont = fontComponent.getFont();
/* 495 */     Font font = argCfg.getFontConfig().getFont(baseFont);
/*     */     
/* 497 */     if (font != null) {
/* 498 */       fontComponent.setFont(font);
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
/*     */   protected void updateModelValue() {
/* 512 */     if (!this.refuseModelChangeRequests_) {
/*     */       try {
/* 514 */         IEditModel em = getEditModel();
/* 515 */         if (em != null && !em.isReadOnly(this.fieldKey_))
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 520 */           if (isDebugEnabled_) {
/* 521 */             logger_.debug(this.fieldKey_ + ": START - refusing to respond to component updates.");
/*     */           }
/* 523 */           this.updateValueHandler_.close();
/* 524 */           this.updateStateHandler_.close();
/*     */ 
/*     */ 
/*     */           
/* 528 */           Object unwrappedValue = getUnwrappedComponentValue();
/* 529 */           em.setValue(this.fieldKey_, unwrappedValue);
/* 530 */           if (isDebugEnabled_) {
/* 531 */             logger_.debug(this.fieldKey_ + ": Model value updated to " + (
/* 532 */                 StringUtils.isPossibleCreditCardNumber(unwrappedValue) ? "[REDACTED]" : unwrappedValue));
/*     */           }
/*     */         }
/*     */       
/* 536 */       } catch (Exception ex) {
/* 537 */         logger_.error("Exception writing data back to edit model ", ex);
/*     */       } finally {
/*     */         
/* 540 */         this.updateValueHandler_.open();
/* 541 */         this.updateStateHandler_.open();
/*     */         
/* 543 */         if (isDebugEnabled_) {
/* 544 */           logger_.debug(this.fieldKey_ + ": END - refusing to respond to component updates.");
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateState() {
/* 555 */     IFormModel fm = (IFormModel)getModel();
/*     */     
/* 557 */     if (fm == null) {
/*     */       return;
/*     */     }
/*     */     
/* 561 */     boolean required = (this.required_ || fm.isRequired(this.fieldKey_));
/* 562 */     boolean isDisabled = (this.readOnly_ || !fm.isEditable(this.fieldKey_));
/*     */     
/* 564 */     if (this.component_ instanceof IRequirableComponent) {
/* 565 */       IRequirableComponent comp = (IRequirableComponent)this.component_;
/*     */       
/* 567 */       if (required != comp.isRequired()) {
/* 568 */         comp.setRequired(required);
/*     */       }
/*     */     }
/* 571 */     else if (this.component_ instanceof IRequirableComponent) {
/* 572 */       IRequirableComponent comp = (IRequirableComponent)this.component_;
/*     */       
/* 574 */       if (required != comp.isRequired()) {
/* 575 */         comp.setRequired(required);
/*     */       }
/*     */     } 
/*     */     
/* 579 */     if (this._alwaysEnabled) {
/* 580 */       setComponentEnabled(true);
/*     */     } else {
/*     */       
/* 583 */       setComponentEnabled(!isDisabled);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object wrapValue(Object argUnwrappedValue) {
/* 594 */     return FormUtils.wrapValue(getValueWrapper(), argUnwrappedValue);
/*     */   }
/*     */ 
/*     */   
/*     */   private Object getUnwrappedComponentValue() {
/* 599 */     Object wrappedValue = getComponentValue();
/* 600 */     Object unwrappedValue = wrappedValue;
/*     */     
/*     */     try {
/* 603 */       unwrappedValue = unwrapValue(wrappedValue);
/*     */     }
/* 605 */     catch (Exception ex) {
/* 606 */       logger_.warn("Failed to unwrap [" + wrappedValue + "] for field [" + this.fieldKey_ + "]!");
/*     */     } 
/* 608 */     return unwrappedValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initNewModelRegistration(T argOldModel, T argNewModel) {
/* 614 */     if (argOldModel != null) {
/*     */       
/* 616 */       deregisterEventHandlers(argOldModel);
/*     */       
/* 618 */       IEditModel oldEditModel = argOldModel.getEditModel();
/* 619 */       if (oldEditModel != null && !StringUtils.isEmpty(this.fieldKey_))
/*     */       {
/*     */         
/* 622 */         deregisterFieldHandlers(oldEditModel, this.fieldKey_);
/*     */       }
/*     */     } 
/*     */     
/* 626 */     if (argNewModel != null) {
/*     */       
/* 628 */       registerEventHandlers(argNewModel);
/*     */       
/* 630 */       IEditModel newEditModel = argNewModel.getEditModel();
/* 631 */       if (newEditModel != null && !StringUtils.isEmpty(this.fieldKey_))
/*     */       {
/*     */         
/* 634 */         registerFieldHandlers(newEditModel, this.fieldKey_);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setWrappedComponentValue(Object argValue) {
/*     */     try {
/* 642 */       Object wrappedValue = wrapValue(argValue);
/* 643 */       setComponentValue(wrappedValue);
/* 644 */       if (isDebugEnabled_) {
/* 645 */         logger_.debug(this.fieldKey_ + ": Component value updated to " + wrappedValue);
/*     */       }
/*     */     }
/* 648 */     catch (ObjectNotFoundException ex1) {
/* 649 */       logger_.warn("Could not map [" + argValue + "] to a corresponding database value for field [" + this.fieldKey_ + "].");
/*     */     
/*     */     }
/* 652 */     catch (Exception ex2) {
/* 653 */       logger_.warn("Failed to wrap [" + argValue + "] for field [" + this.fieldKey_ + "]!", ex2);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract Object getComponentValue();
/*     */   
/*     */   protected abstract void setComponentValue(Object paramObject);
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\AbstractFormComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */