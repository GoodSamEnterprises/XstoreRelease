/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import java.util.List;
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
/*     */ public class PrintablePosDocument
/*     */   extends AbstractPosDocument
/*     */   implements IPrintablePosDocument
/*     */ {
/*     */   private static final long serialVersionUID = -4999735589136694611L;
/*  22 */   private static final Logger logger_ = Logger.getLogger(PrintablePosDocument.class);
/*  23 */   private static boolean isDebugEnabled_ = logger_.isDebugEnabled();
/*     */   
/*     */   private IPrinterTargetInfo targetInfo_;
/*     */   
/*  27 */   private String locale_ = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendElement(IDocElement aElement) {
/*  36 */     IDocElement previousElement = null;
/*  37 */     List<IDocElement> els = getElementList();
/*  38 */     if (els.size() > 0) {
/*  39 */       previousElement = els.get(els.size() - 1);
/*     */     }
/*     */ 
/*     */     
/*  43 */     if (aElement.isTextAppendable() && previousElement != null && previousElement instanceof PrintableTextElement) {
/*     */ 
/*     */       
/*  46 */       PrintableTextElement previousTextElement = (PrintableTextElement)previousElement;
/*  47 */       List<? extends Object> lines = aElement.getLines();
/*  48 */       previousTextElement.appendLines(lines);
/*     */ 
/*     */       
/*  51 */       if (isDebugEnabled_) {
/*  52 */         logger_.debug("appending receipt element to previous:'" + aElement + "'");
/*  53 */         StringBuffer sb = new StringBuffer();
/*  54 */         sb.append("appended as '");
/*  55 */         for (int i = 0; i < lines.size(); i++) {
/*  56 */           sb.append(lines.get(i));
/*  57 */           sb.append("\n");
/*     */         } 
/*  59 */         sb.append("'");
/*  60 */         logger_.debug(sb);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  65 */       els.add(aElement);
/*  66 */       if (isDebugEnabled_) {
/*  67 */         logger_.debug("adding receipt element:'" + aElement + "'");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocale() {
/*  75 */     return this.locale_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPrinterTargetInfo getPrinterTargetInfo() {
/*  85 */     return this.targetInfo_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocale(String argLocale) {
/*  91 */     this.locale_ = argLocale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrinterTargetInfo(IPrinterTargetInfo newValue) {
/* 101 */     this.targetInfo_ = newValue;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\PrintablePosDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */