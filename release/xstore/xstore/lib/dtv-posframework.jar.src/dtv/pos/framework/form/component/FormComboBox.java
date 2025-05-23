/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.swing.DtvComboBox;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.swing.DefaultComboBoxModel;
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
/*     */ public class FormComboBox<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */   implements ItemListener
/*     */ {
/*  37 */   static final Logger logger_ = Logger.getLogger(FormComboBox.class);
/*     */   
/*  39 */   private static Object NULL_OBJECT = new Object()
/*     */     {
/*     */       public boolean equals(Object obj) {
/*  42 */         return (obj == null || obj == this);
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/*  47 */         return "";
/*     */       }
/*     */     };
/*     */   
/*  51 */   private final EventHandler enumChangeHandler_ = new EventHandler()
/*     */     {
/*     */       public String toString()
/*     */       {
/*  55 */         return FormComboBox.this.toString();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected void handle(Event argEvent) {
/*  61 */         FormComboBox.this.updateFormEnumeration(argEvent.getBaseEvent().getPayload());
/*     */       }
/*     */     };
/*  64 */   protected DtvComboBox<Object> comboBox_ = null;
/*     */   
/*     */   protected boolean valuesManuallySet_ = false;
/*     */   
/*     */   private boolean isModelTypeList_ = false;
/*     */ 
/*     */   
/*     */   public FormComboBox() {
/*  72 */     this.comboBox_ = new DtvComboBox();
/*  73 */     this.comboBox_.addItemListener(this);
/*     */     
/*  75 */     setComponent((JComponent)this.comboBox_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  81 */     return (this.comboBox_.getEditor() == null) ? super
/*  82 */       .getFocusComponent() : (JComponent)this.comboBox_
/*  83 */       .getEditor().getEditorComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  90 */     if (argCfg instanceof IFormViewCellConfig) {
/*  91 */       EnumPossibleValues ev = ((IFormViewCellConfig)argCfg).getEnumPossibleValues();
/*  92 */       if (ev != null) {
/*  93 */         this.comboBox_.setModel(new DefaultComboBoxModel(ev.getValuesList().toArray()));
/*  94 */         this.valuesManuallySet_ = true;
/*     */       } 
/*     */     } 
/*  97 */     super.init(argCfg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/* 103 */     super.init(argFieldDef);
/*     */     
/* 105 */     getFocusComponent().setFocusable(true);
/* 106 */     getDisplayComponent().setFocusable(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void itemStateChanged(ItemEvent evt) {
/* 112 */     if (logger_.isDebugEnabled()) {
/* 113 */       logger_.debug("state change " + evt);
/*     */     }
/*     */     
/* 116 */     if (evt.getStateChange() != 2) {
/* 117 */       updateModelValue();
/*     */     }
/* 119 */     else if (evt.getStateChange() == 2 && this.comboBox_.getModel().getSelectedItem() == null) {
/* 120 */       updateModelValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deregisterFieldHandlers(IEditModel argEditModel, String argFieldKey) {
/* 127 */     argEditModel.deregisterFieldHandler(argFieldKey, (IEventAware)this.enumChangeHandler_);
/* 128 */     super.deregisterFieldHandlers(argEditModel, argFieldKey);
/*     */   }
/*     */   
/*     */   protected DtvComboBox<?> getComboBox() {
/* 132 */     return this.comboBox_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 138 */     return this.comboBox_.getSelectedItem();
/*     */   }
/*     */   
/*     */   protected boolean isModelTypeList() {
/* 142 */     return this.isModelTypeList_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerFieldHandlers(IEditModel argEditModel, String argFieldKey) {
/* 148 */     super.registerFieldHandlers(argEditModel, argFieldKey);
/* 149 */     argEditModel.registerFieldHandler(argFieldKey, (IEventAware)this.enumChangeHandler_, EditModelFieldChangeType.ENUMERATION_CHANGED.toConstraint());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object argNewValue) {
/* 155 */     boolean editable = this.comboBox_.isEditable();
/* 156 */     this.comboBox_.setEditable(true);
/* 157 */     this.comboBox_.setSelectedItem(argNewValue);
/* 158 */     this.comboBox_.setEditable(editable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setModelImpl(T argOldModel, T argNewModel) {
/* 164 */     IEditModel em = getEditModel();
/* 165 */     if (em != null) {
/* 166 */       this.isModelTypeList_ = List.class.isAssignableFrom(em.getDataType(this.fieldKey_));
/*     */     }
/* 168 */     if (!this.valuesManuallySet_) {
/* 169 */       updateFormEnumeration();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object unwrapValue(Object<Object> argWrappedValue) {
/*     */     Object<Object> wrappedValue;
/* 177 */     if (argWrappedValue == NULL_OBJECT) {
/* 178 */       wrappedValue = null;
/*     */     } else {
/*     */       
/* 181 */       wrappedValue = argWrappedValue;
/*     */     } 
/* 183 */     Object<Object> value = wrappedValue;
/* 184 */     if (isModelTypeList()) {
/* 185 */       value = (Object<Object>)toList(wrappedValue);
/*     */     }
/* 187 */     return super.unwrapValue(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFormEnumeration() {
/* 195 */     IEditModel em = getEditModel();
/* 196 */     Collection<?> possibleValues = (em != null) ? em.getEnumeratedPossibleValues(this.fieldKey_) : null;
/* 197 */     possibleValues = wrapNull(possibleValues);
/* 198 */     updateFormEnumeration(possibleValues);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <PV extends Collection<?>> void updateFormEnumeration(PV argPossibleValues) {
/* 206 */     UIServices.invoke(() -> { Object selectedItem = wrapValue(getModelValue()); this.comboBox_.removeAllItems(); if (argPossibleValues != null) for (Object value : argPossibleValues) this.comboBox_.addItem(wrapValue(value));   this.comboBox_.setSelectedItem(selectedItem); }true, true);
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
/*     */   protected Collection<?> wrapNull(Collection<?> argCol) {
/* 225 */     Collection<?> col = argCol;
/* 226 */     if (col != null && !col.isEmpty()) {
/* 227 */       Iterator<?> iterator = col.iterator();
/* 228 */       Object first = iterator.next();
/*     */       
/* 230 */       if (first == null) {
/* 231 */         List<Object> cleaned = new ArrayList();
/* 232 */         cleaned.add(NULL_OBJECT);
/* 233 */         while (iterator.hasNext()) {
/* 234 */           cleaned.add(iterator.next());
/*     */         }
/* 236 */         col = cleaned;
/*     */       } 
/*     */     } 
/* 239 */     return col;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object wrapValue(Object argUnwrappedValue) {
/* 245 */     if (argUnwrappedValue == NULL_OBJECT) {
/* 246 */       return argUnwrappedValue;
/*     */     }
/* 248 */     Object wrapped = super.wrapValue(argUnwrappedValue);
/*     */     
/* 250 */     if (isModelTypeList()) {
/* 251 */       wrapped = fromList(wrapped);
/*     */     }
/* 253 */     return wrapped;
/*     */   }
/*     */   
/*     */   private Object fromList(Object argInput) {
/* 257 */     Object value = argInput;
/* 258 */     if (value instanceof List) {
/* 259 */       List<?> list = (List)argInput;
/* 260 */       value = list.isEmpty() ? null : list.get(0);
/*     */     } 
/* 262 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Object> toList(Object argInput) {
/*     */     List<Object> list;
/* 268 */     if (argInput instanceof List) {
/* 269 */       list = (List<Object>)argInput;
/*     */     } else {
/*     */       
/* 272 */       list = new ArrayList();
/* 273 */       if (argInput != null) {
/* 274 */         list.add(argInput);
/*     */       }
/*     */     } 
/* 277 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormComboBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */