/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.swing.DtvCheckBox;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import javax.swing.ImageIcon;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormCheckBox<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */   implements ItemListener
/*     */ {
/*  37 */   static final Logger logger_ = Logger.getLogger(FormCheckBox.class);
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static final String DEFAULT_TEXT = FormattableFactory.getInstance().getTranslatable("_formCheckBoxDefaultText").toString(OutputContextType.VIEW);
/*     */   
/*  43 */   private static final ImageIcon icon_ = UIResourceManager.getInstance().getImageIcon("_imageCheckBoxIcon");
/*     */ 
/*     */   
/*  46 */   private static final ImageIcon selectedIcon_ = UIResourceManager.getInstance().getImageIcon("_imageCheckBoxSelectedIcon");
/*     */   
/*  48 */   protected DtvCheckBox checkBox_ = null;
/*     */   
/*     */   protected FormatterType formatterType_;
/*     */ 
/*     */   
/*     */   public FormCheckBox() {
/*  54 */     this.checkBox_ = new DtvCheckBox();
/*  55 */     this.checkBox_.setOpaque(false);
/*  56 */     this.checkBox_.setIcon(icon_);
/*  57 */     this.checkBox_.setSelectedIcon(selectedIcon_);
/*  58 */     this.checkBox_.setDisabledIcon(icon_);
/*  59 */     this.checkBox_.setDisabledSelectedIcon(selectedIcon_);
/*  60 */     this.checkBox_.setFocusable(true);
/*  61 */     this.checkBox_.setFocusPainted(true);
/*     */     
/*  63 */     this.checkBox_.addItemListener(this);
/*     */     
/*  65 */     setComponent((JComponent)this.checkBox_);
/*     */     
/*  67 */     this.checkBox_.setFont(getDisplayComponent().getFont().deriveFont(1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  73 */     super.init(argCfg);
/*     */     
/*  75 */     this.formatterType_ = ((FormViewCellConfig)argCfg).getFormatterType();
/*     */     
/*  77 */     if (this.textKey_ != null && !StringUtils.isEmpty(this.textKey_.toString())) {
/*  78 */       setText(this.textKey_);
/*     */     } else {
/*     */       
/*  81 */       this.checkBox_.setText(DEFAULT_TEXT);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/*  89 */     super.init(argFieldDef);
/*     */     
/*  91 */     this.formatterType_ = argFieldDef.getFormatter();
/*     */     
/*  93 */     if (this.textKey_ != null && !StringUtils.isEmpty(this.textKey_.toString())) {
/*  94 */       setText(this.textKey_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void itemStateChanged(ItemEvent evt) {
/* 102 */     if (logger_.isDebugEnabled()) {
/* 103 */       logger_.debug("state change " + evt);
/*     */     }
/*     */     
/* 106 */     if (evt.getStateChange() != 2) {
/* 107 */       updateModelValue();
/*     */     }
/* 109 */     else if (evt.getStateChange() == 2) {
/* 110 */       updateModelValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 117 */     return Boolean.valueOf(this.checkBox_.isSelected());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object argNewValue) {
/* 123 */     Boolean obj = Boolean.valueOf(false);
/*     */     
/* 125 */     if (argNewValue instanceof Boolean) {
/* 126 */       obj = (Boolean)argNewValue;
/*     */     }
/*     */     
/* 129 */     boolean editable = this.checkBox_.isEnabled();
/* 130 */     this.checkBox_.setEnabled(true);
/* 131 */     this.checkBox_.setSelected(obj.booleanValue());
/* 132 */     this.checkBox_.setEnabled(editable);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setText(Object argValue) {
/* 137 */     if (argValue == null) {
/* 138 */       this.checkBox_.setText((String)null);
/*     */     }
/* 140 */     else if (argValue instanceof IFormattable) {
/* 141 */       this.checkBox_.setText(((IFormattable)argValue).toString());
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 146 */       IFormattable text = (this.formatterType_ == null) ? FF.getSimpleFormattable(argValue.toString()) : FF.getSimpleFormattable(argValue, this.formatterType_);
/* 147 */       this.checkBox_.setText(text.toString());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormCheckBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */