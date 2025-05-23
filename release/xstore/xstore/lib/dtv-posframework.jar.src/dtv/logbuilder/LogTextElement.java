/*     */ package dtv.logbuilder;
/*     */ 
/*     */ import dtv.docbuilding.IConfigurableTextInfo;
/*     */ import dtv.docbuilding.ITextElement;
/*     */ import dtv.docbuilding.IWidthAwareString;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
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
/*     */ public class LogTextElement
/*     */   implements ITextElement
/*     */ {
/*     */   private static final long serialVersionUID = 4303704815248331380L;
/*     */   private final List<Object> lines_;
/*     */   
/*     */   public LogTextElement(Collection<? extends Object> argLines) {
/*  30 */     this.lines_ = new ArrayList(argLines.size());
/*  31 */     this.lines_.addAll(argLines);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogTextElement(String[] argLines) {
/*  40 */     this.lines_ = new ArrayList(argLines.length);
/*  41 */     this.lines_.addAll(Arrays.asList((Object[])argLines));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendLines(List<? extends Object> argLines) {
/*  50 */     this.lines_.addAll(argLines);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/*  60 */     return new LogTextElement(this.lines_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IConfigurableTextInfo getConfigurableTextInfo() {
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> getLines() {
/*  76 */     return new ArrayList(this.lines_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTextAppendable() {
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTextConfigurable() {
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuffer sb = new StringBuffer("LogTextElement(linecount=");
/* 103 */     sb.append(this.lines_.size());
/* 104 */     sb.append(";lines='");
/* 105 */     for (int i = 0; i < this.lines_.size(); i++) {
/* 106 */       Object o = this.lines_.get(i);
/* 107 */       if (o instanceof IWidthAwareString) {
/* 108 */         sb.append(((IWidthAwareString)o).getRawText());
/*     */       } else {
/*     */         
/* 111 */         sb.append(o);
/*     */       } 
/* 113 */       sb.append("\n");
/*     */     } 
/* 115 */     sb.append("')");
/* 116 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public void trace(ITracer t) {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\LogTextElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */