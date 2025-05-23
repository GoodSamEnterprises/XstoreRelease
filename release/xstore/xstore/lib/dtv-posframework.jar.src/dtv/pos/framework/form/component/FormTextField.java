/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.framework.ui.component.XstTextField;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.ui.text.TextFieldFormatters;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
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
/*     */ 
/*     */ 
/*     */ public class FormTextField<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*  28 */   protected static final Logger logger_ = Logger.getLogger(FormTextField.class);
/*     */   
/*     */   private final XstTextField textField_;
/*     */   
/*     */   private final PropertyChangeListener valueChangeListener_;
/*     */   
/*     */   public FormTextField() {
/*  35 */     this.textField_ = createTextField();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  41 */     this.valueChangeListener_ = new PropertyChangeListener()
/*     */       {
/*     */         public void propertyChange(PropertyChangeEvent argEvent)
/*     */         {
/*  45 */           if (argEvent.getNewValue() != argEvent.getOldValue()) {
/*  46 */             FormTextField.this.updateModelValue();
/*     */           }
/*     */         }
/*     */       };
/*  50 */     this.textField_.getTextFieldComponent().addPropertyChangeListener("value", this.valueChangeListener_);
/*     */     
/*  52 */     setComponent((IXstViewComponent)this.textField_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/*  58 */     super.init(argFieldDef);
/*     */     
/*  60 */     XstTextField t = getTextField();
/*  61 */     t.setRequired(this.required_);
/*  62 */     t.setModelEnabled(!this.readOnly_);
/*     */     
/*  64 */     IDataFieldConfig dataConfig = argFieldDef.getDataField();
/*     */     
/*  66 */     if (dataConfig != null) {
/*  67 */       t.setEntryMasked(dataConfig.isEntryMasked());
/*  68 */       t.setFormatters(dataConfig.getFormatters());
/*     */     } else {
/*     */       
/*  71 */       t.setFormatters(TextFieldFormatters.DEFAULT);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> config) {
/*  79 */     super.init(config);
/*     */     
/*  81 */     XstTextField t = getTextField();
/*  82 */     t.setRequired(this.required_);
/*  83 */     t.setModelEnabled(!this.readOnly_);
/*     */     
/*  85 */     IDataFieldConfig dataConfig = config.getDataConfig();
/*  86 */     if (dataConfig != null) {
/*  87 */       t.setEntryMasked(dataConfig.isEntryMasked());
/*  88 */       t.setFormatters(dataConfig.getFormatters());
/*     */     } else {
/*     */       
/*  91 */       t.setFormatters(TextFieldFormatters.DEFAULT);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected XstTextField createTextField() {
/*  96 */     return XstViewComponentFactory.getInstance().createTextField();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 102 */     XstTextField tf = getTextField();
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
/* 132 */     return tf.getValue();
/*     */   }
/*     */   
/*     */   protected XstTextField getTextField() {
/* 136 */     return this.textField_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 142 */     getTextField().setValue(value);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */