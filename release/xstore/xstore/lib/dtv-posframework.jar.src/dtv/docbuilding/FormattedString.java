/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.util.CharWidth;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import dtv.util.xmlexport.IXmlExportable;
/*     */ import dtv.util.xmlexport.XmlExportAttribute;
/*     */ import dtv.util.xmlexport.XmlExportWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ public class FormattedString
/*     */   implements Serializable, IXmlExportable
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(FormattedString.class);
/*     */   
/*     */   private static final long serialVersionUID = 8256762165167679152L;
/*     */   
/*     */   private final String preFormatting_;
/*     */   private final String text_;
/*     */   private final int width_;
/*     */   private final int[] charWidths_;
/*     */   private final boolean isDoubleWideFont_;
/*     */   private final String postFormatting_;
/*     */   
/*     */   public static FormattedString fromXml(Element argXmlElement) {
/*  40 */     boolean isdoublewide = getBooleanAttribute(argXmlElement, "isdoublewidefont");
/*     */     
/*  42 */     String preformatting = DomUtils.getChildElementValue(argXmlElement, "preformatting");
/*  43 */     String text = DomUtils.getChildElementValue(argXmlElement, "text");
/*  44 */     String postformatting = DomUtils.getChildElementValue(argXmlElement, "postformatting");
/*  45 */     return new FormattedString(preformatting, text, postformatting, isdoublewide);
/*     */   }
/*     */   
/*     */   private static boolean getBooleanAttribute(Element argElement, String argName) {
/*  49 */     String attribute = argElement.getAttribute(argName);
/*  50 */     if (!StringUtils.isEmpty(attribute)) {
/*     */       try {
/*  52 */         return Boolean.parseBoolean(attribute);
/*     */       }
/*  54 */       catch (Exception ex) {
/*  55 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/*  58 */     return false;
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
/*     */ 
/*     */   
/*     */   public FormattedString(String argPreFormatting, String argText, String argPostFormatting) {
/*  78 */     this(argPreFormatting, argText, argPostFormatting, false);
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
/*     */   public FormattedString(String argPreFormatting, String argText, String argPostFormatting, boolean argIsDoubleWideFont) {
/*     */     int defaultCharWidth;
/*  92 */     if (argPreFormatting != null) {
/*  93 */       this.preFormatting_ = argPreFormatting;
/*     */     } else {
/*     */       
/*  96 */       this.preFormatting_ = "";
/*     */     } 
/*     */     
/*  99 */     if (argText != null) {
/* 100 */       this.text_ = argText;
/*     */     } else {
/*     */       
/* 103 */       this.text_ = "";
/*     */     } 
/* 105 */     if (argPostFormatting != null) {
/* 106 */       this.postFormatting_ = argPostFormatting;
/*     */     } else {
/*     */       
/* 109 */       this.postFormatting_ = "";
/*     */     } 
/* 111 */     this.isDoubleWideFont_ = argIsDoubleWideFont;
/*     */     
/* 113 */     this.charWidths_ = new int[this.text_.length()];
/* 114 */     int width = 0;
/*     */     
/* 116 */     if (this.isDoubleWideFont_) {
/* 117 */       defaultCharWidth = 2;
/*     */     } else {
/*     */       
/* 120 */       defaultCharWidth = 1;
/*     */     } 
/* 122 */     CharWidth cw = new CharWidth();
/* 123 */     for (int i = 0; i < this.charWidths_.length; i++) {
/* 124 */       this.charWidths_[i] = defaultCharWidth;
/* 125 */       if (cw.isWide(this.text_.charAt(i))) {
/* 126 */         this.charWidths_[i] = this.charWidths_[i] * 2;
/*     */       }
/* 128 */       width += this.charWidths_[i];
/*     */     } 
/* 130 */     this.width_ = width;
/*     */   }
/*     */   
/*     */   public char charAt(int argPosition) {
/* 134 */     return this.text_.charAt(argPosition);
/*     */   }
/*     */   
/*     */   public int charWidthAt(int argPosition) {
/* 138 */     if (argPosition >= this.charWidths_.length) {
/* 139 */       return 0;
/*     */     }
/*     */     
/* 142 */     return this.charWidths_[argPosition];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostFormatting() {
/* 152 */     return this.postFormatting_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPreFormatting() {
/* 161 */     return this.preFormatting_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRawText() {
/* 170 */     return this.text_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRawTextLength() {
/* 179 */     return this.width_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 189 */     return this.preFormatting_ + this.text_ + this.postFormatting_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeXml(XmlExportWriter w) throws IOException {
/* 197 */     List<XmlExportAttribute> l = new LinkedList<>();
/* 198 */     if (this.isDoubleWideFont_) {
/* 199 */       l.add(new XmlExportAttribute("isdoublewidefont", "true"));
/*     */     }
/* 201 */     w.writeHeader("formattedstring", l.<XmlExportAttribute>toArray(new XmlExportAttribute[l.size()]));
/*     */     
/* 203 */     w.writestring("preformatting", this.preFormatting_);
/* 204 */     w.writestring("text", this.text_);
/* 205 */     w.writestring("postformatting", this.postFormatting_);
/*     */     
/* 207 */     w.writeFooter("formattedstring");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\FormattedString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */