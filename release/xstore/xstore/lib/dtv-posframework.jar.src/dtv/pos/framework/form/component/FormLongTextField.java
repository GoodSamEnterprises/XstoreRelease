/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.config.IColorGroupConfig;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.IModelEnabled;
/*     */ import dtv.ui.swing.DtvScrollTextArea;
/*     */ import dtv.ui.swing.DtvTextArea;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
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
/*     */ public class FormLongTextField<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */   implements DocumentListener
/*     */ {
/*     */   private final XstScrollTextArea longTextField_;
/*     */   private boolean displayEndOfText_ = true;
/*     */   
/*     */   public FormLongTextField() {
/*  47 */     this.longTextField_ = new XstScrollTextArea();
/*  48 */     this.longTextField_.getTextArea().getDocument().addDocumentListener(this);
/*  49 */     setComponent((JComponent)this.longTextField_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void changedUpdate(DocumentEvent evt) {
/*  55 */     updateModelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  61 */     return (JComponent)getTextArea();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> config) {
/*  67 */     super.init(config);
/*     */     
/*  69 */     getTextArea().setRequired(this.required_);
/*  70 */     this.longTextField_.setEnabled(!this.readOnly_);
/*     */     
/*  72 */     IDataFieldConfig dataConfig = config.getDataConfig();
/*  73 */     this.longTextField_.setDataFieldParameters(dataConfig);
/*  74 */     if (dataConfig != null) {
/*  75 */       this.displayEndOfText_ = dataConfig.isEndOfValueDisplayed();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/*  82 */     super.init(argFieldDef);
/*     */     
/*  84 */     getTextArea().setRequired(this.required_);
/*  85 */     this.longTextField_.setEnabled(!this.readOnly_);
/*     */     
/*  87 */     IDataFieldConfig dataConfig = argFieldDef.getDataField();
/*  88 */     this.longTextField_.setDataFieldParameters(dataConfig);
/*     */     
/*  90 */     if (dataConfig != null) {
/*  91 */       this.displayEndOfText_ = dataConfig.isEndOfValueDisplayed();
/*     */     }
/*     */   }
/*     */   
/*     */   public void insert(DocumentEvent evt) {
/*  96 */     updateModelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertUpdate(DocumentEvent evt) {
/* 102 */     updateModelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeUpdate(DocumentEvent evt) {
/* 109 */     updateModelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 115 */     return getTextArea().getText();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected JComponent getFontComponent() {
/* 121 */     return (JComponent)getTextArea();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected JComponent getMostVisibleComponent() {
/* 127 */     return (JComponent)getTextArea();
/*     */   }
/*     */   
/*     */   protected DtvTextArea getTextArea() {
/* 131 */     return this.longTextField_.getTextArea();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 137 */     String text = StringUtils.nonNull(value);
/* 138 */     text = text.replaceAll("\\\\n", "\n");
/* 139 */     getTextArea().setText(text);
/* 140 */     if (this.displayEndOfText_) {
/* 141 */       getTextArea().setCaretPosition(text.length());
/*     */     }
/*     */   }
/*     */   
/*     */   private static class XstScrollTextArea
/*     */     extends DtvScrollTextArea
/*     */     implements IModelEnabled
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/* 150 */     private final Set<KeyStroke> forwardTraversalKeys_ = new HashSet<>();
/* 151 */     private final Set<KeyStroke> backwardTraversalKeys_ = new HashSet<>();
/*     */     private boolean modelEnabled_ = true;
/*     */     private boolean componentEnabled_ = true;
/*     */     private Boolean _editableOverride;
/*     */     
/*     */     public XstScrollTextArea() {
/* 157 */       this.forwardTraversalKeys_.add(KeyStroke.getKeyStroke(9, 0));
/* 158 */       this.backwardTraversalKeys_.add(KeyStroke.getKeyStroke(9, 1));
/*     */       
/* 160 */       getTextArea().setFocusTraversalKeys(0, this.forwardTraversalKeys_);
/* 161 */       getTextArea().setFocusTraversalKeys(1, this.backwardTraversalKeys_);
/*     */       
/* 163 */       getTextArea().addMouseListener(new MouseAdapter()
/*     */           {
/*     */             public void mousePressed(MouseEvent argE)
/*     */             {
/* 167 */               DtvTextArea dtvTextArea = FormLongTextField.XstScrollTextArea.this.getTextArea();
/* 168 */               if (ConfigurationMgr.isOnScreenKeyboardEnabled() && ConfigurationMgr.isOnScreenKeyboardAutomaticallyCalled() && dtvTextArea.isEditable() && dtvTextArea
/* 169 */                 .isEnabled()) {
/* 170 */                 OnScreenKeyboard.ensureKeyboardIsShowing();
/*     */               }
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEnabled(boolean argEnabled) {
/* 179 */       this.componentEnabled_ = argEnabled;
/* 180 */       setEnabled();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setModelEnabled(boolean argEnabled) {
/* 186 */       this.modelEnabled_ = argEnabled;
/* 187 */       setEnabled();
/*     */     }
/*     */     
/*     */     protected void setDataFieldParameters(IDataFieldConfig config) {
/* 191 */       if (config != null) {
/* 192 */         if (config.getMaxCharacters() > 0 || config.getMaxCharacters() == -1000) {
/* 193 */           int maxCharacters = config.getMaxCharacters();
/* 194 */           getTextArea().setMaxCharacters(maxCharacters);
/*     */         } 
/*     */         
/* 197 */         this._editableOverride = config.isEditable();
/*     */         
/* 199 */         IColorGroupConfig colors = config.getColorGroupConfig();
/*     */         
/* 201 */         if (colors.getFgColor() != null) {
/* 202 */           getTextArea().setForeground(colors.getFgColor());
/*     */         }
/*     */         
/* 205 */         if (colors.getBgColor() != null) {
/* 206 */           getTextArea().setBackground(colors.getBgColor());
/*     */         }
/*     */         
/* 209 */         if (colors.getSelectionFgColor() != null) {
/* 210 */           getTextArea().setSelectedTextColor(colors.getSelectionFgColor());
/*     */         }
/*     */         
/* 213 */         if (colors.getSelectionBgColor() != null) {
/* 214 */           getTextArea().setSelectionColor(colors.getSelectionBgColor());
/*     */         }
/*     */         
/* 217 */         Font baseFont = getTextArea().getFont();
/* 218 */         Font newFont = config.getFontConfig().getFont(baseFont);
/* 219 */         getTextArea().setFont(newFont);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setEnabled() {
/* 225 */       boolean enabled = (this.modelEnabled_ && this.componentEnabled_);
/*     */       
/* 227 */       if (this._editableOverride != null) {
/* 228 */         getTextArea().setEditable(this._editableOverride.booleanValue());
/*     */       } else {
/*     */         
/* 231 */         getTextArea().setEditable(enabled);
/*     */       } 
/*     */       
/* 234 */       getTextArea().setFocusable(enabled);
/* 235 */       getTextArea().setEnabled(enabled);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormLongTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */