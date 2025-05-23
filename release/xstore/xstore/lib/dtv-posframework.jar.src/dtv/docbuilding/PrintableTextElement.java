/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import dtv.util.xmlexport.IXmlExportable;
/*     */ import dtv.util.xmlexport.XmlExportWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PrintableTextElement
/*     */   implements ITextElement, IXmlExportable
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(PrintableTextElement.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 8762439958702199187L;
/*     */ 
/*     */   
/*     */   private final List<Object> lines_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static IDocElement fromXml(Element argXmlElement) {
/*  39 */     Collection<Element> children = DomUtils.getChildElements(argXmlElement);
/*  40 */     List<Object> contents = new LinkedList();
/*  41 */     for (Element element : children) {
/*  42 */       Object o = makeElement(element);
/*  43 */       if (o != null) {
/*  44 */         contents.add(o);
/*     */       }
/*     */     } 
/*  47 */     return new PrintableTextElement(contents);
/*     */   }
/*     */   
/*     */   private static Object makeElement(Element argElement) {
/*  51 */     String name = argElement.getNodeName();
/*  52 */     if ("string".equals(name)) {
/*  53 */       return DomUtils.getElementValue(argElement);
/*     */     }
/*  55 */     if ("region".equals(name)) {
/*  56 */       return FormattedRegion.fromXml(argElement);
/*     */     }
/*  58 */     if ("line".equals(name)) {
/*  59 */       return FormattedLine.fromXml(argElement);
/*     */     }
/*     */     
/*  62 */     return null;
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
/*     */   public PrintableTextElement(Collection<? extends Object> argLines) {
/*  75 */     this.lines_ = new ArrayList(argLines);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintableTextElement(String[] argLines) {
/*  84 */     this.lines_ = new ArrayList(argLines.length);
/*  85 */     this.lines_.addAll(Arrays.asList((Object[])argLines));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendLines(List<? extends Object> argLines) {
/*  94 */     for (Object o : argLines) {
/*  95 */       if (!(o instanceof IXmlExportable))
/*     */       {
/*     */         
/*  98 */         if (!(o instanceof String))
/*     */         {
/*     */ 
/*     */           
/* 102 */           logger_.warn("unexpected line type " + ObjectUtils.getClassNameFromObject(o)); } 
/*     */       }
/* 104 */       this.lines_.add(o);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 110 */     return new PrintableTextElement(this.lines_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IConfigurableTextInfo getConfigurableTextInfo() {
/* 116 */     if (isTextConfigurable()) {
/* 117 */       return (IConfigurableTextInfo)this.lines_.get(0);
/*     */     }
/*     */     
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> getLines() {
/* 130 */     return new ArrayList(this.lines_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTextAppendable() {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTextConfigurable() {
/* 146 */     boolean configurable = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     if (this.lines_ != null && this.lines_.size() == 1 && this.lines_.get(0) instanceof FormattedRegion) {
/* 154 */       FormattedRegion region = (FormattedRegion)this.lines_.get(0);
/* 155 */       configurable = region.isFromTextBlock();
/*     */     } 
/*     */     
/* 158 */     return configurable;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     return toString(40);
/*     */   }
/*     */   
/*     */   public String toString(int argLineWidth) {
/* 167 */     StringBuffer sb = new StringBuffer("RcptTextElement(linecount=");
/* 168 */     sb.append(this.lines_.size());
/* 169 */     sb.append(";lines='");
/* 170 */     for (int i = 0; i < this.lines_.size(); i++) {
/* 171 */       Object o = this.lines_.get(i);
/* 172 */       if (o instanceof IWidthAwareString) {
/* 173 */         sb.append(((IWidthAwareString)o).toString(argLineWidth));
/*     */       } else {
/*     */         
/* 176 */         sb.append(o);
/*     */       } 
/* 178 */       sb.append("\n");
/*     */     } 
/* 180 */     sb.append("')");
/* 181 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/* 187 */     argTracer.attr("TEXT");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeXml(XmlExportWriter w) throws IOException {
/* 195 */     w.writeHeader("text");
/* 196 */     for (Object o : this.lines_) {
/* 197 */       if (o instanceof IXmlExportable) {
/* 198 */         ((IXmlExportable)o).writeXml(w);
/*     */         continue;
/*     */       } 
/* 201 */       if (o == null || String.valueOf(o).length() == 0) {
/* 202 */         w.writeElement("string", new dtv.util.xmlexport.XmlExportAttribute[0]);
/*     */         continue;
/*     */       } 
/* 205 */       w.writestring("string", String.valueOf(o));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 210 */     w.writeFooter("text");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\PrintableTextElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */