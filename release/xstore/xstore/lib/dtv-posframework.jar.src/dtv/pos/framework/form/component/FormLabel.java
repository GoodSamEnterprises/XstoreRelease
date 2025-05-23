/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*     */ import dtv.pos.framework.ui.component.XstLabel;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
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
/*     */ public class FormLabel<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*     */   protected FormatterType formatterType_;
/*     */   protected XstLabel label_;
/*     */   protected IFormattable value_;
/*     */   
/*     */   public FormLabel() {
/*  33 */     this.label_ = createLabel();
/*  34 */     setComponent((IXstViewComponent)this.label_);
/*     */ 
/*     */ 
/*     */     
/*  38 */     getDisplayComponent().setForeground(getDefaultForeground());
/*  39 */     getDisplayComponent().setFont(getDefaultFont());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getModelValue() {
/*  45 */     if (this.value_ != null) {
/*  46 */       return this.value_.toString(OutputContextType.VIEW, getEditModel());
/*     */     }
/*     */     
/*  49 */     Object value = super.getModelValue();
/*     */     
/*  51 */     if (value instanceof String)
/*     */     {
/*  53 */       return (this.formatterType_ == null) ? FF.getSimpleFormattable((String)value) : FF
/*  54 */         .getSimpleFormattable(value, this.formatterType_);
/*     */     }
/*     */     
/*  57 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  64 */     super.init(argCfg);
/*     */     
/*  66 */     this.value_ = argCfg.getValue();
/*  67 */     this.formatterType_ = ((FormViewCellConfig)argCfg).getFormatterType();
/*     */     
/*  69 */     if (this.fieldKey_ == null)
/*     */     {
/*     */ 
/*     */       
/*  73 */       if (this.textKey_ != null) {
/*  74 */         setText(this.textKey_);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/*  81 */     super.init(argFieldDef);
/*     */     
/*  83 */     this.formatterType_ = argFieldDef.getFormatter();
/*     */     
/*  85 */     if (this.textKey_ != null) {
/*  86 */       setText(this.textKey_);
/*     */     }
/*  88 */     else if (this.fieldKey_ != null) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IFormComponentConfig<?> newValue) {
/*  99 */     super.setConfig(newValue);
/* 100 */     if (this.fieldKey_ != null) {
/* 101 */       getLabel().setText("{" + this.fieldKey_ + "}");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected XstLabel createLabel() {
/* 108 */     return XstViewComponentFactory.getInstance().createLabel(" ");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 114 */     return getLabel().getText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Font getDefaultFont() {
/* 122 */     return getDisplayComponent().getFont().deriveFont(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Color getDefaultForeground() {
/* 130 */     return Color.BLACK;
/*     */   }
/*     */   
/*     */   protected XstLabel getLabel() {
/* 134 */     return this.label_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentEnabled(boolean newValue) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 146 */     setText(value);
/*     */   }
/*     */   
/*     */   protected void setText(Object argValue) {
/* 150 */     if (argValue == null) {
/* 151 */       getLabel().setText((String)null);
/*     */     }
/* 153 */     else if (argValue instanceof IFormattable) {
/* 154 */       getLabel().setText((IFormattable)argValue);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 159 */       IFormattable text = (this.formatterType_ == null) ? FF.getSimpleFormattable(argValue.toString()) : FF.getSimpleFormattable(argValue, this.formatterType_);
/* 160 */       getLabel().setText(text);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */