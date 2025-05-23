/*     */ package dtv.logbuilder;
/*     */ 
/*     */ import dtv.docbuilding.FormattedLine;
/*     */ import dtv.docbuilding.IDocElement;
/*     */ import dtv.docbuilding.IPrinterTargetInfo;
/*     */ import dtv.logbuilder.config.LogFileConfig;
/*     */ import dtv.util.TypeSafeMapKey;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ class LogEntry
/*     */   implements ILogEntryDoc
/*     */ {
/*     */   private static final long serialVersionUID = 2649605208467616329L;
/*     */   private final LogEntryWriterGroup outWriter_;
/*     */   
/*     */   public LogEntry(LogFileConfig argConfig, Map<TypeSafeMapKey<?>, Object> argSettings) throws IOException {
/*  38 */     this.outWriter_ = LogEntryWriterGroup.getGroup(argConfig, argSettings);
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
/*     */   public void appendElement(IDocElement argElement) throws IOException {
/*  51 */     List<?> lines = argElement.getLines();
/*     */ 
/*     */     
/*  54 */     for (int i = 0; i < lines.size(); i++) {
/*  55 */       Object o = lines.get(i);
/*  56 */       if (o instanceof FormattedLine) {
/*  57 */         this.outWriter_.write(((FormattedLine)o).getRawText() + "\n");
/*     */       } else {
/*     */         
/*  60 */         this.outWriter_.write(o.toString() + "\n");
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
/*     */ 
/*     */   
/*     */   public void appendElements(IDocElement[] argElements) throws IOException {
/*  75 */     for (IDocElement argElement : argElements) {
/*  76 */       appendElement(argElement);
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
/*     */   public void close() throws IOException {
/*  89 */     this.outWriter_.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocElement[] getElements() {
/*  95 */     throw new UnsupportedOperationException("This LogEntry document is write-only.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPrinterTargetInfo getPrinterTargetInfo() {
/* 105 */     throw new UnsupportedOperationException("LogEntry documents are not printable -- operation not implemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadable() {
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public void setPrinterTargetInfo(IPrinterTargetInfo newValue) {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LogEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */