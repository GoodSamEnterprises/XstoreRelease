/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosTextPane;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.Color;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.text.Style;
/*     */ import javax.swing.text.StyleConstants;
/*     */ import javax.swing.text.StyleContext;
/*     */ import javax.swing.text.StyledDocument;
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
/*     */ 
/*     */ 
/*     */ public class XstReadOnlyTextArea
/*     */   implements IXstViewComponent
/*     */ {
/*  40 */   private static final Logger logger = Logger.getLogger(XstReadOnlyTextArea.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PosTextPane textPane_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstReadOnlyTextArea() {
/*  51 */     logger.debug("Creating view component: " + getClass() + ".");
/*  52 */     this.textPane_ = PosComponentFactory.getInstance().createTextPane();
/*     */     
/*  54 */     this.textPane_.addPropertyChangeListener("document", new PropertyChangeListener()
/*     */         {
/*     */           public void propertyChange(PropertyChangeEvent argEvt)
/*     */           {
/*  58 */             if (argEvt.getNewValue() instanceof StyledDocument) {
/*  59 */               XstReadOnlyTextArea.this.installStyles((StyledDocument)argEvt.getNewValue());
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public String getContentType() {
/*  66 */     return getTextPane().getContentType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  72 */     return (JComponent)getTextPane();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  78 */     return (JComponent)getTextPane();
/*     */   }
/*     */   
/*     */   public PosTextPane getTextPane() {
/*  82 */     return this.textPane_;
/*     */   }
/*     */   
/*     */   public void setContentType(String contentType) {
/*  86 */     getTextPane().setContentType(contentType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPage(String page) throws IOException {
/*  92 */     getTextPane().setPage(page);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPage(URL page) throws IOException {
/*  98 */     getTextPane().setPage(page);
/*     */   }
/*     */   
/*     */   public void setText(IFormattable text) {
/* 102 */     setText(LocaleManager.getInstance().getRegisteredString(text));
/*     */   }
/*     */   
/*     */   public void setText(MutableString text) {
/* 106 */     getTextPane().setText(text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void installStyles(StyledDocument argDocument) {
/* 114 */     Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle("default");
/* 115 */     Style rootStyle = argDocument.addStyle("root", defaultStyle);
/* 116 */     StyleConstants.setFontSize(rootStyle, UIResourceManager.getInstance().getFont("_fontInstructionLarge").getSize());
/*     */     
/* 118 */     Style newStyle = argDocument.addStyle("header", rootStyle);
/* 119 */     StyleConstants.setAlignment(newStyle, 1);
/* 120 */     StyleConstants.setBold(newStyle, true);
/*     */     
/* 122 */     newStyle = argDocument.addStyle("detail", rootStyle);
/* 123 */     StyleConstants.setBold(newStyle, false);
/* 124 */     StyleConstants.setForeground(newStyle, Color.RED);
/* 125 */     StyleConstants.setLeftIndent(newStyle, 25.0F);
/* 126 */     StyleConstants.setFirstLineIndent(newStyle, 25.0F);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstReadOnlyTextArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */