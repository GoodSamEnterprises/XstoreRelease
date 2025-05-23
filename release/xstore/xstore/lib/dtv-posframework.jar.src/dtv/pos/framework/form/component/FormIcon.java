/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import com.micros.xstore.config.form.field.FormParameterTypeEnumeration;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosPrettyLabel;
/*     */ import dtv.pos.ui.util.IconUtils;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
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
/*     */ public class FormIcon<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*     */   private final PosPrettyLabel iconLabel_;
/*     */   
/*     */   public FormIcon() {
/*  33 */     this.iconLabel_ = createLabel();
/*  34 */     this.iconLabel_.addPropertyChangeListener(new PropertyChangeListener()
/*     */         {
/*     */           public void propertyChange(PropertyChangeEvent argEvt)
/*     */           {
/*  38 */             if (argEvt.getPropertyName().equalsIgnoreCase("enabled")) {
/*  39 */               FormIcon.this.iconLabel_.setEnabled(true);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/*  44 */     setComponent((JComponent)getIconLabel());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  50 */     super.init(argCfg);
/*     */     
/*  52 */     if (this.fieldKey_ != null) {
/*  53 */       getIconLabel().setIcon(createImageIcon(getModelValueAsString()));
/*     */     }
/*  55 */     else if (this.textKey_ != null) {
/*  56 */       getIconLabel().setIcon(createImageIcon(this.textKey_.getUnformattedData().toString()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/*  63 */     super.init(argFieldDef);
/*     */     
/*  65 */     if (this.fieldKey_ != null) {
/*  66 */       getIconLabel().setIcon(createImageIcon(getModelValueAsString()));
/*     */     }
/*  68 */     else if (this.textKey_ != null) {
/*  69 */       getIconLabel().setIcon(createImageIcon(this.textKey_.getUnformattedData().toString()));
/*     */     } 
/*     */ 
/*     */     
/*  73 */     boolean scaleImage = Boolean.valueOf(argFieldDef.getParameter(FormParameterTypeEnumeration.SCALE.value())).booleanValue();
/*     */     
/*  75 */     boolean stretchImage = Boolean.valueOf(argFieldDef.getParameter(FormParameterTypeEnumeration.STRETCH.value())).booleanValue();
/*     */     
/*  77 */     if (scaleImage) {
/*  78 */       getIconLabel().setIsIconScaled(true);
/*     */     }
/*  80 */     else if (stretchImage) {
/*  81 */       getIconLabel().setIsHorizontallyStretched(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ImageIcon createImageIcon(String argImageKey) {
/*  86 */     if (argImageKey != null && !argImageKey.isEmpty()) {
/*  87 */       return IconUtils.getVolatileComponentImageIcon(argImageKey);
/*     */     }
/*     */     
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected PosPrettyLabel createLabel() {
/*  95 */     return PosComponentFactory.getInstance().createPrettyLabel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 101 */     return getIconLabel().getText();
/*     */   }
/*     */   
/*     */   protected PosPrettyLabel getIconLabel() {
/* 105 */     return this.iconLabel_;
/*     */   }
/*     */   
/*     */   protected String getModelValueAsString() {
/* 109 */     Object o = getModelValue();
/* 110 */     return (o == null) ? "" : o.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 116 */     if (value instanceof Icon) {
/* 117 */       getIconLabel().setIcon((Icon)value);
/*     */     }
/* 119 */     else if (value != null) {
/* 120 */       getIconLabel().setIcon(createImageIcon(value.toString()));
/*     */     } else {
/*     */       
/* 123 */       getIconLabel().setIcon(null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormIcon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */