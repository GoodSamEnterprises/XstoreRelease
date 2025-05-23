/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.framework.ui.component.XstTextField;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
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
/*     */ public class MaskedMoneyField<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*  27 */   protected static final Logger logger_ = Logger.getLogger(MaskedMoneyField.class);
/*     */   
/*     */   private final XstTextField textField_;
/*     */   
/*     */   private final PropertyChangeListener valueChangeListener_;
/*     */   
/*     */   public MaskedMoneyField() {
/*  34 */     this.textField_ = createTextField();
/*  35 */     this.textField_.getTextFieldComponent().setMoney(true);
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
/*  46 */             MaskedMoneyField.this.updateModelValue();
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
/*     */   
/*     */   public void init(IFormComponentConfig<?> config) {
/*  59 */     super.init(config);
/*     */     
/*  61 */     XstTextField t = getTextField();
/*  62 */     t.setRequired(this.required_);
/*  63 */     t.setModelEnabled(!this.readOnly_);
/*  64 */     t.getTextFieldComponent().setMoney(true);
/*  65 */     IDataFieldConfig dataConfig = config.getDataConfig();
/*  66 */     if (dataConfig != null) {
/*  67 */       t.setEntryMasked(dataConfig.isEntryMasked());
/*  68 */       t.setFormatters(dataConfig.getFormatters());
/*     */     } else {
/*     */       
/*  71 */       t.setFormatters(TextFieldFormatters.DEFAULT);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected XstTextField createTextField() {
/*  76 */     return XstViewComponentFactory.getInstance().createTextField();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/*  82 */     XstTextField tf = getTextField();
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
/* 112 */     return tf.getValue();
/*     */   }
/*     */   
/*     */   protected XstTextField getTextField() {
/* 116 */     return this.textField_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 122 */     getTextField().setValue(value);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\MaskedMoneyField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */