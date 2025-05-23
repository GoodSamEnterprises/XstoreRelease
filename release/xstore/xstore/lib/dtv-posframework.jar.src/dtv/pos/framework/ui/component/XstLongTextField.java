/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*     */ import dtv.ui.swing.DtvScrollTextArea;
/*     */ import dtv.ui.swing.DtvTextArea;
/*     */ import dtv.ui.swing.text.BoundedPlainDocument;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JComponent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XstLongTextField
/*     */   implements IXstViewComponent
/*     */ {
/*     */   private static final int DEFAULT_MAX_CHARACTERS = 254;
/*     */   private final DtvScrollTextArea textArea_;
/*     */   private boolean displayEndOfText_ = false;
/*     */   
/*     */   public XstLongTextField() {
/*  49 */     this.textArea_ = new DtvScrollTextArea();
/*  50 */     this.textArea_.getTextArea().addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent argE)
/*     */           {
/*  54 */             DtvTextArea dtvTextArea = XstLongTextField.this.textArea_.getTextArea();
/*  55 */             if (ConfigurationMgr.isOnScreenKeyboardEnabled() && ConfigurationMgr.isOnScreenKeyboardAutomaticallyCalled() && dtvTextArea.isEditable() && dtvTextArea
/*  56 */               .isEnabled()) {
/*  57 */               OnScreenKeyboard.ensureKeyboardIsShowing();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void addDocumentListener(DocumentListener listener) {
/*  64 */     if (listener != null) {
/*  65 */       BoundedPlainDocument doc = getDocument();
/*  66 */       doc.removeDocumentListener(listener);
/*  67 */       doc.addDocumentListener(listener);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  74 */     return (JComponent)getScrollTextAreaComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  79 */     return (JComponent)getScrollTextAreaComponent().getTextArea();
/*     */   }
/*     */   
/*     */   public DtvScrollTextArea getScrollTextAreaComponent() {
/*  83 */     return this.textArea_;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  87 */     return getScrollTextAreaComponent().getTextArea().getText();
/*     */   }
/*     */   
/*     */   public void setDataFieldParameters(IDataFieldConfig config) {
/*  91 */     if (config == null) {
/*     */       
/*  93 */       getDocument().setMaxCharacters(254);
/*  94 */       setText("");
/*     */     } else {
/*     */       
/*  97 */       int maxCharacters = 254;
/*     */       
/*  99 */       if (config.getMaxCharacters() > 0 || config.getMaxCharacters() == -1000) {
/* 100 */         maxCharacters = config.getMaxCharacters();
/*     */       }
/* 102 */       getDocument().setMaxCharacters(maxCharacters);
/* 103 */       getScrollTextAreaComponent().setForeground(config.getColorGroupConfig().getFgColor());
/* 104 */       getScrollTextAreaComponent().setBackground(config.getColorGroupConfig().getBgColor());
/* 105 */       getScrollTextAreaComponent().getTextArea().setSelectedTextColor(config
/* 106 */           .getColorGroupConfig().getSelectionFgColor());
/* 107 */       getScrollTextAreaComponent().getTextArea().setSelectionColor(config
/* 108 */           .getColorGroupConfig().getSelectionBgColor());
/*     */       
/* 110 */       Font baseFont = getScrollTextAreaComponent().getTextArea().getFont();
/* 111 */       Font newFont = config.getFontConfig().getFont(baseFont);
/* 112 */       getScrollTextAreaComponent().getTextArea().setFont(newFont);
/*     */       
/* 114 */       getScrollTextAreaComponent().getTextArea().setEditable(!config.isEntryDisabled());
/*     */       
/* 116 */       if (config.getValue() == null) {
/* 117 */         setText(config.getTextKey());
/*     */       } else {
/*     */         
/* 120 */         setText(config.getValue().toString());
/*     */       } 
/* 122 */       this.displayEndOfText_ = config.isEndOfValueDisplayed();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean newValue) {
/* 127 */     getScrollTextAreaComponent().setEnabled(newValue);
/*     */   }
/*     */   
/*     */   public void setRequired(boolean newValue) {
/* 131 */     getScrollTextAreaComponent().getTextArea().setRequired(newValue);
/*     */   }
/*     */   
/*     */   public void setText(IFormattable text) {
/* 135 */     setText(text.toString(OutputContextType.VIEW));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String text) {
/* 145 */     getScrollTextAreaComponent().getTextArea().setText(text);
/* 146 */     if (this.displayEndOfText_) {
/* 147 */       getScrollTextAreaComponent().getTextArea().setCaretPosition(text.length());
/*     */     }
/*     */   }
/*     */   
/*     */   private BoundedPlainDocument getDocument() {
/* 152 */     return (BoundedPlainDocument)this.textArea_.getTextArea().getDocument();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstLongTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */