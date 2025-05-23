/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.pos.iframework.ui.model.ITextPromptModel;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import javax.swing.text.Document;
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
/*     */ public class DefaultTextPromptModel
/*     */   extends AbstractPromptModel
/*     */   implements ITextPromptModel
/*     */ {
/*  42 */   private static final Logger logger = Logger.getLogger(DefaultTextPromptModel.class);
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
/*     */   public void changedUpdate(DocumentEvent event) {
/*  59 */     processDocumentEvent(event);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertUpdate(DocumentEvent event) {
/*  70 */     processDocumentEvent(event);
/*     */   }
/*     */ 
/*     */   
/*     */   public void propertyChange(PropertyChangeEvent event) {
/*  75 */     if (event != null) {
/*  76 */       String propertyName = event.getPropertyName();
/*     */       
/*  78 */       if ("value".equalsIgnoreCase(propertyName.trim())) {
/*  79 */         Object newValue = event.getNewValue();
/*  80 */         setUserInput(newValue);
/*     */       } 
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
/*     */   public void removeUpdate(DocumentEvent event) {
/*  93 */     processDocumentEvent(event);
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
/*     */   private void processDocumentEvent(DocumentEvent event) {
/* 105 */     if (logger.isDebugEnabled()) {
/* 106 */       logger.debug("Processing " + event.getType() + " document event from " + event.getDocument() + ".");
/*     */     }
/*     */     
/* 109 */     Document document = event.getDocument();
/*     */     
/*     */     try {
/* 112 */       String text = document.getText(0, document.getLength());
/* 113 */       setUserInput(text);
/*     */     }
/* 115 */     catch (BadLocationException e) {
/* 116 */       logger.error("Error processing document event:\n\t" + e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultTextPromptModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */