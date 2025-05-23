/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosTextField;
/*     */ import dtv.pos.ui.text.TextFieldFormatters;
/*     */ import dtv.ui.UIServices;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.text.ParseException;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.Document;
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
/*     */ public class XstTextField
/*     */   implements IXstViewComponent
/*     */ {
/*     */   private final PosTextField textField_;
/*     */   
/*     */   public XstTextField() {
/*  45 */     this.textField_ = createTextField();
/*     */     
/*  47 */     this.textField_.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent argE)
/*     */           {
/*  51 */             if (ConfigurationMgr.isOnScreenKeyboardEnabled() && ConfigurationMgr.isOnScreenKeyboardAutomaticallyCalled() && XstTextField.this.textField_.isEditable() && XstTextField.this
/*  52 */               .textField_.isEnabled()) {
/*  53 */               OnScreenKeyboard.ensureKeyboardIsShowing();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void addDocumentListener(DocumentListener listener) {
/*  60 */     if (listener != null) {
/*  61 */       getTextFieldComponent().getDocument().removeDocumentListener(listener);
/*  62 */       getTextFieldComponent().getDocument().addDocumentListener(listener);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/*  67 */     if (listener != null) {
/*  68 */       getTextFieldComponent().removePropertyChangeListener(listener);
/*  69 */       getTextFieldComponent().addPropertyChangeListener(listener);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clear() {
/*  74 */     getTextFieldComponent().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void commitEdit() throws ParseException {
/*  79 */     getTextFieldComponent().commitEdit();
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
/*     */   public JComponent getDisplayComponent() {
/*  91 */     return (JComponent)getTextFieldComponent();
/*     */   }
/*     */   
/*     */   public Document getDocument() {
/*  95 */     return getTextFieldComponent().getDocument();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 100 */     return (JComponent)getTextFieldComponent();
/*     */   }
/*     */   
/*     */   public PosTextField getTextFieldComponent() {
/* 104 */     return this.textField_;
/*     */   }
/*     */   
/*     */   public Object getValue() {
/* 108 */     return getTextFieldComponent().getValue();
/*     */   }
/*     */   
/*     */   public void setEntryMasked(boolean entryMasked) {
/* 112 */     getTextFieldComponent().setEntryMasked(entryMasked);
/*     */   }
/*     */   
/*     */   public void setFormatters(TextFieldFormatters formatters) {
/* 116 */     getTextFieldComponent().setFormatters(formatters);
/*     */   }
/*     */   
/*     */   public void setModelEnabled(boolean enabled) {
/* 120 */     getTextFieldComponent().setModelEnabled(enabled);
/*     */   }
/*     */   
/*     */   public void setRequired(boolean required) {
/* 124 */     getTextFieldComponent().setRequired(required);
/*     */   }
/*     */   
/*     */   public void setText(final IFormattable text) {
/* 128 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 131 */             XstTextField.this.getTextFieldComponent().setText(LocaleManager.getInstance().getRegisteredString(text));
/* 132 */             XstTextField.this.getTextFieldComponent().selectAll();
/*     */           }
/*     */         },  true);
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
/*     */   public void setText(final String text) {
/* 146 */     UIServices.invoke(new Runnable()
/*     */         {
/*     */           public void run() {
/* 149 */             XstTextField.this.getTextFieldComponent().setText(text);
/* 150 */             XstTextField.this.getTextFieldComponent().selectAll();
/*     */           }
/*     */         },  true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object value) {
/* 158 */     getTextFieldComponent().setValue(value);
/*     */   }
/*     */   
/*     */   protected PosTextField createTextField() {
/* 162 */     return PosComponentFactory.getInstance().createTextField();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */