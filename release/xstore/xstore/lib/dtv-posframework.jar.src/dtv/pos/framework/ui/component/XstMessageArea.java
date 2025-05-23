/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosComponentFactory;
/*     */ import dtv.pos.ui.component.PosTextPane;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.Color;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import javax.swing.text.Document;
/*     */ import javax.swing.text.Style;
/*     */ import javax.swing.text.StyleConstants;
/*     */ import javax.swing.text.StyleContext;
/*     */ import javax.swing.text.StyledDocument;
/*     */ import javax.swing.text.html.HTMLDocument;
/*     */ import javax.swing.text.html.HTMLEditorKit;
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
/*     */ public class XstMessageArea
/*     */   implements IXstViewComponent
/*     */ {
/*  43 */   private static final Logger logger = Logger.getLogger(XstMessageArea.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private final PosTextPane messagePane_;
/*     */ 
/*     */ 
/*     */   
/*     */   public XstMessageArea() {
/*  52 */     logger.debug("Creating view component: " + getClass() + ".");
/*     */     
/*  54 */     this.messagePane_ = PosComponentFactory.getInstance().createTextPane();
/*     */     
/*  56 */     this.messagePane_.addPropertyChangeListener("document", argEvt -> {
/*     */           if (argEvt.getNewValue() instanceof StyledDocument) {
/*     */             installStyles((StyledDocument)argEvt.getNewValue());
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/*  69 */     return getTextPane().getContentType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  75 */     return (JComponent)this.messagePane_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  81 */     return (JComponent)this.messagePane_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PosTextPane getTextPane() {
/*  88 */     return this.messagePane_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentType(String argContentType) {
/*  97 */     getTextPane().setContentType(argContentType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocument(Document argDoc) {
/* 106 */     getTextPane().setEditorKit(new HTMLEditorKit());
/* 107 */     getTextPane().setDocument(argDoc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHTMLText(String argDoc) {
/* 116 */     HTMLEditorKit htmlKit = new HTMLEditorKit();
/* 117 */     getTextPane().setEditorKit(new HTMLEditorKit());
/* 118 */     HTMLDocument htmlDoc = (HTMLDocument)htmlKit.createDefaultDocument();
/* 119 */     htmlDoc.setBase(ConfigurationMgr.getItemMessageFileUrl());
/* 120 */     getTextPane().setDocument(htmlDoc);
/*     */     
/* 122 */     getTextPane().setText(argDoc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImage(BufferedImage argImage) throws BadLocationException {
/* 133 */     StyledDocument doc = (StyledDocument)getTextPane().getDocument();
/* 134 */     if (doc != null) {
/* 135 */       Style style = doc.addStyle("ImageStyle", (Style)null);
/* 136 */       StyleConstants.setIcon(style, getScaledImageIcon(argImage));
/* 137 */       doc.insertString(0, "ignored text", style);
/*     */     } 
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
/*     */   public void setImage(URL argImageURL) throws BadLocationException, IOException {
/* 150 */     setImage(ImageIO.read(argImageURL));
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
/*     */   public void setPage(String argPage) throws IOException {
/* 162 */     getTextPane().setPage(argPage);
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
/*     */   public void setPage(URL argPage) throws IOException {
/* 174 */     getTextPane().setPage(argPage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(IFormattable argText) {
/* 183 */     setText(LocaleManager.getInstance().getRegisteredString(argText));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(MutableString argText) {
/* 192 */     getTextPane().setText(argText);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void installStyles(StyledDocument argDocument) {
/* 200 */     Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle("default");
/* 201 */     Style rootStyle = argDocument.addStyle("root", defaultStyle);
/* 202 */     StyleConstants.setFontSize(rootStyle, UIResourceManager.getInstance().getFont("_fontInstructionLarge").getSize());
/*     */     
/* 204 */     Style newStyle = argDocument.addStyle("header", rootStyle);
/* 205 */     StyleConstants.setAlignment(newStyle, 1);
/* 206 */     StyleConstants.setBold(newStyle, true);
/*     */     
/* 208 */     newStyle = argDocument.addStyle("detail", rootStyle);
/* 209 */     StyleConstants.setBold(newStyle, false);
/* 210 */     StyleConstants.setForeground(newStyle, Color.RED);
/* 211 */     StyleConstants.setLeftIndent(newStyle, 25.0F);
/* 212 */     StyleConstants.setFirstLineIndent(newStyle, 25.0F);
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
/*     */   private int[] getScaledImageDimensions(int argImageWidth, int argImageHeight, int containerWidth, int containerHeight) {
/* 230 */     float heightFactor = containerHeight / argImageHeight;
/* 231 */     float widthFactor = containerWidth / argImageWidth;
/* 232 */     int imageWidth = argImageWidth;
/* 233 */     int imageHeight = argImageHeight;
/* 234 */     if (heightFactor < 1.0F || widthFactor < 1.0F) {
/* 235 */       if (heightFactor < widthFactor) {
/* 236 */         imageWidth = Float.valueOf(heightFactor * imageWidth).intValue();
/* 237 */         imageHeight = containerHeight;
/*     */       } else {
/*     */         
/* 240 */         imageHeight = Float.valueOf(widthFactor * imageHeight).intValue();
/* 241 */         imageWidth = containerWidth;
/*     */       } 
/*     */     }
/* 244 */     int[] rtn = { imageWidth, imageHeight };
/* 245 */     return rtn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ImageIcon getScaledImageIcon(BufferedImage argBaseImage) {
/* 256 */     return getScaledImageIcon(argBaseImage, (getTextPane().getSize()).width, (getTextPane().getSize()).height);
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
/*     */   private ImageIcon getScaledImageIcon(BufferedImage argBaseImage, int argContainerWidth, int argContainerHeight) {
/* 269 */     int[] imageDims = getScaledImageDimensions(argBaseImage.getWidth(), argBaseImage.getHeight(), argContainerWidth, argContainerHeight);
/*     */     
/* 271 */     return new ImageIcon(argBaseImage.getScaledInstance(imageDims[0], imageDims[1], 0));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstMessageArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */