/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.util.CharWidth;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import dtv.util.xmlexport.IXmlExportable;
/*     */ import dtv.util.xmlexport.XmlExportAttribute;
/*     */ import dtv.util.xmlexport.XmlExportWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringEscapeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormattedRegion
/*     */   implements IWidthAwareString, IXmlExportable, IConfigurableTextInfo
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(FormattedRegion.class);
/*     */   private static final long serialVersionUID = 1302682382273258876L;
/*     */   private final Contents con_;
/*     */   private final String leftMargin_;
/*     */   private final String rightMargin_;
/*     */   private final String preFormatting_;
/*     */   private final String postFormatting_;
/*     */   private final boolean isDoubleWideFont_;
/*     */   
/*     */   public static FormattedRegion fromXml(Element argXmlElement) {
/*     */     DocBuilderAlignmentType alignment;
/*  41 */     Element elementFactoryElement = DomUtils.getChildElement(argXmlElement, "elementFactory");
/*     */     
/*  43 */     String elementFactoryName = (elementFactoryElement != null) ? DomUtils.getElementValue(elementFactoryElement) : null;
/*  44 */     String argElementFactoryName = StringUtils.nonNull(elementFactoryName);
/*  45 */     IDocElementFactory elementFactory = null;
/*     */ 
/*     */     
/*     */     try {
/*  49 */       elementFactory = (IDocElementFactory)Class.forName(argElementFactoryName).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
/*     */     }
/*  51 */     catch (Exception e) {
/*  52 */       logger_.error("Could not instantiate " + argElementFactoryName, e);
/*     */     } 
/*     */     
/*  55 */     boolean isdoublewide = getBooleanAttribute(argXmlElement, "isdoublewidefont");
/*  56 */     String alignmentName = argXmlElement.getAttribute("alignment");
/*     */     
/*  58 */     if (StringUtils.isEmpty(alignmentName)) {
/*  59 */       alignment = DocBuilderAlignmentType.LEFT;
/*     */     } else {
/*     */       
/*  62 */       alignment = DocBuilderAlignmentType.forName(alignmentName);
/*     */     } 
/*     */     
/*  65 */     boolean isFromTextBlock = getBooleanAttribute(argXmlElement, "isFromTextBlock");
/*  66 */     String textCode = null;
/*  67 */     String textSubCode = null;
/*     */     
/*  69 */     if (isFromTextBlock) {
/*  70 */       textCode = argXmlElement.getAttribute("textCode");
/*  71 */       textSubCode = argXmlElement.getAttribute("textSubCode");
/*     */     } 
/*     */     
/*  74 */     String preformatting = StringUtils.nonNull(DomUtils.getChildElementValue(argXmlElement, "preformatting"));
/*  75 */     String leftmargin = StringUtils.nonNull(DomUtils.getChildElementValue(argXmlElement, "leftmargin"));
/*  76 */     String rightmargin = StringUtils.nonNull(DomUtils.getChildElementValue(argXmlElement, "rightmargin"));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     String lineformatting = StringUtils.nonNull(DomUtils.getChildElementValue(argXmlElement, "lineformatting"));
/*     */     
/*  83 */     String contents = StringEscapeUtils.unescapeHtml4(StringUtils.nonNull(DomUtils.getChildElementValue(argXmlElement, "contents")));
/*     */     
/*  85 */     if (StringUtils.isEmpty(contents)) {
/*     */       
/*  87 */       NodeList lineInfoList = argXmlElement.getElementsByTagName("lineinfo");
/*  88 */       if (lineInfoList != null) {
/*  89 */         StringBuffer contentsBuffer = new StringBuffer();
/*  90 */         StringBuffer lineformattingBuffer = new StringBuffer();
/*     */         
/*  92 */         for (int i = 0; i < lineInfoList.getLength(); i++) {
/*  93 */           Element lineInfo = (Element)lineInfoList.item(i);
/*     */           
/*  95 */           contentsBuffer.append(
/*  96 */               StringEscapeUtils.unescapeHtml4(StringUtils.nonNull(DomUtils.getChildElementValue(lineInfo, "contents"))));
/*  97 */           lineformattingBuffer
/*  98 */             .append(StringUtils.nonNull(DomUtils.getChildElementValue(lineInfo, "lineformatting")));
/*     */           
/* 100 */           if (lineInfoList.getLength() > 1) {
/* 101 */             contentsBuffer.append("\n");
/* 102 */             lineformattingBuffer.append("\n");
/*     */           } 
/*     */         } 
/*     */         
/* 106 */         contents = contentsBuffer.toString();
/* 107 */         lineformatting = lineformattingBuffer.toString();
/*     */       } 
/*     */     } 
/*     */     
/* 111 */     String postformatting = StringUtils.nonNull(DomUtils.getChildElementValue(argXmlElement, "postformatting"));
/*     */ 
/*     */     
/* 114 */     FormattedRegion region = new FormattedRegion(contents.toString(), leftmargin, rightmargin, preformatting, postformatting, alignment, lineformatting.toString(), isdoublewide, elementFactory);
/* 115 */     region.setFromTextBlock(isFromTextBlock);
/* 116 */     region.setTextCode(textCode);
/* 117 */     region.setTextSubCode(textSubCode);
/* 118 */     return region;
/*     */   }
/*     */   
/*     */   private static boolean getBooleanAttribute(Element argElement, String argName) {
/* 122 */     String attribute = argElement.getAttribute(argName);
/* 123 */     if (!StringUtils.isEmpty(attribute)) {
/*     */       try {
/* 125 */         return Boolean.parseBoolean(attribute);
/*     */       }
/* 127 */       catch (Exception ex) {
/* 128 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   private String elementFactoryClass_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocBuilderAlignmentType alignment_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _isFromTextBlock = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String _textCode;
/*     */ 
/*     */ 
/*     */   
/*     */   private String _textSubCode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormattedRegion(String argContents, String argLeftMargin, String argRightMargin, String argPreFormatting, String argPostFormatting, DocBuilderAlignmentType argAlignment, String argLineFormatting, boolean argIsDoubleWideFont, IDocElementFactory argElementFactory) {
/* 165 */     ensureNonNull(argContents, "contents cannot be null");
/* 166 */     ensureNonNull(argLeftMargin, "left margin cannot be null");
/* 167 */     ensureNonNull(argRightMargin, "right margin cannot be null");
/* 168 */     ensureNonNull(argPreFormatting, "preformatting cannot be null");
/* 169 */     ensureNonNull(argPostFormatting, "post-formatting cannot be null");
/* 170 */     ensureNonNull(argAlignment, "alignment cannot be null");
/* 171 */     ensureNonNull(argLineFormatting, "line formatting cannot be null");
/*     */     
/* 173 */     this.leftMargin_ = argLeftMargin;
/* 174 */     this.rightMargin_ = argRightMargin;
/*     */     
/* 176 */     this.preFormatting_ = argPreFormatting;
/* 177 */     this.postFormatting_ = argPostFormatting;
/* 178 */     this.alignment_ = argAlignment;
/* 179 */     this.isDoubleWideFont_ = argIsDoubleWideFont;
/* 180 */     if (argElementFactory != null) {
/* 181 */       this.elementFactoryClass_ = argElementFactory.getClass().getName();
/*     */     }
/* 183 */     this.con_ = new Contents(argContents, argLineFormatting);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAlignment() {
/* 188 */     return this.alignment_.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDoubleWideFont() {
/* 193 */     return this.isDoubleWideFont_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDocElementFactory getElementFactory() {
/*     */     try {
/* 199 */       if (this.elementFactoryClass_ != null) {
/* 200 */         return (IDocElementFactory)Class.forName(this.elementFactoryClass_)
/* 201 */           .getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
/*     */       }
/*     */     }
/* 204 */     catch (Exception e) {
/* 205 */       logger_.error("Could not instantiate " + this.elementFactoryClass_, e);
/*     */     } 
/*     */     
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLeftMargin() {
/* 213 */     return this.leftMargin_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPostFormatting() {
/* 218 */     return this.postFormatting_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPreFormatting() {
/* 223 */     return this.preFormatting_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRawText() {
/* 228 */     return this.con_.getRawText();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRightMargin() {
/* 233 */     return this.rightMargin_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTextCode() {
/* 238 */     return this._textCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTextSubCode() {
/* 243 */     return this._textSubCode;
/*     */   }
/*     */   
/*     */   public boolean isFromTextBlock() {
/* 247 */     return this._isFromTextBlock;
/*     */   }
/*     */   
/*     */   public void setFromTextBlock(boolean argIsFromTextBlock) {
/* 251 */     this._isFromTextBlock = argIsFromTextBlock;
/*     */   }
/*     */   
/*     */   public void setTextCode(String argTextCode) {
/* 255 */     this._textCode = argTextCode;
/*     */   }
/*     */   
/*     */   public void setTextSubCode(String argTextSubCode) {
/* 259 */     this._textSubCode = argTextSubCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 264 */     return toString(40);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(int argLineLength) {
/* 270 */     if (argLineLength <= 0) {
/* 271 */       return "";
/*     */     }
/*     */     
/* 274 */     StringBuffer sb = new StringBuffer(argLineLength * this.con_.getSize());
/*     */     
/* 276 */     for (int i = 0; i < this.con_.getSize(); i++) {
/*     */       int lineLength;
/* 278 */       if (this.isDoubleWideFont_ || this.con_.isDoubleWide(i)) {
/* 279 */         lineLength = argLineLength / 2;
/*     */       } else {
/*     */         
/* 282 */         lineLength = argLineLength;
/*     */       } 
/*     */       
/* 285 */       String right = this.rightMargin_;
/* 286 */       String left = this.leftMargin_;
/* 287 */       int rightLen = right.length();
/* 288 */       int leftLen = left.length();
/*     */       
/* 290 */       while (rightLen + leftLen >= lineLength) {
/* 291 */         rightLen--;
/* 292 */         leftLen--;
/*     */       } 
/* 294 */       if (rightLen < 0 || leftLen < 0) {
/* 295 */         rightLen = 0;
/* 296 */         leftLen = 0;
/*     */       } 
/* 298 */       right = right.substring(0, rightLen);
/* 299 */       left = left.substring(0, leftLen);
/*     */       
/* 301 */       int regionWidth = lineLength - rightLen - leftLen;
/*     */       
/* 303 */       char[] contents = this.con_.getContents(i).toCharArray();
/*     */       
/* 305 */       boolean[] widths = getWidths(contents);
/* 306 */       String lineFormatting = this.con_.getLineFormatting(i);
/* 307 */       String lineFormattingPost = this.con_.getLineFormattingPost(i);
/*     */       
/* 309 */       int contentLength = contents.length;
/*     */ 
/*     */       
/* 312 */       int charCursor = 0;
/* 313 */       while (charCursor < contentLength) {
/*     */         int extraLeftSide, extraRightSide;
/* 315 */         sb.append(lineFormatting);
/* 316 */         sb.append(this.preFormatting_);
/*     */ 
/*     */         
/* 319 */         sb.append(left);
/*     */         
/* 321 */         int maxLineEnd = getMaxLineEnd(contents, widths, charCursor, regionWidth);
/* 322 */         int endOfLine = findEndOfLine(contents, charCursor, maxLineEnd);
/*     */         
/* 324 */         int wideCount = 0;
/* 325 */         for (int j = charCursor; j <= endOfLine - 1; j++) {
/* 326 */           if (widths[j]) {
/* 327 */             wideCount++;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 332 */         int length = endOfLine - charCursor;
/* 333 */         int extraSpaceCount = regionWidth - length - wideCount;
/*     */         
/* 335 */         if (this.alignment_ == DocBuilderAlignmentType.RIGHT) {
/* 336 */           extraLeftSide = extraSpaceCount;
/* 337 */           extraRightSide = 0;
/*     */         }
/* 339 */         else if (this.alignment_ == DocBuilderAlignmentType.CENTERED) {
/* 340 */           extraLeftSide = extraSpaceCount / 2;
/* 341 */           extraRightSide = extraSpaceCount - extraLeftSide;
/*     */         } else {
/*     */           
/* 344 */           extraLeftSide = 0;
/* 345 */           extraRightSide = extraSpaceCount;
/*     */         } 
/*     */         
/*     */         int k;
/* 349 */         for (k = 0; k < extraLeftSide; k++) {
/* 350 */           sb.append(' ');
/*     */         }
/*     */ 
/*     */         
/* 354 */         sb.append(contents, charCursor, length);
/*     */ 
/*     */         
/* 357 */         for (k = 0; k < extraRightSide; k++) {
/* 358 */           sb.append(' ');
/*     */         }
/*     */         
/* 361 */         int endOfThisLine = charCursor + regionWidth + rightLen - 1 - wideCount;
/* 362 */         int marginIndex = 0;
/* 363 */         for (int m = endOfLine + extraSpaceCount; m <= endOfThisLine; m++) {
/* 364 */           sb.append(right.charAt(marginIndex++));
/*     */         }
/*     */ 
/*     */         
/* 368 */         sb.append(this.postFormatting_);
/* 369 */         sb.append(lineFormattingPost);
/*     */ 
/*     */         
/* 372 */         charCursor = endOfLine;
/*     */         
/* 374 */         if (charCursor < contentLength)
/*     */         {
/* 376 */           if (contents[charCursor] == '\n') {
/* 377 */             charCursor++;
/*     */           }
/* 379 */           else if (Character.isWhitespace(contents[charCursor])) {
/* 380 */             if (charCursor + 1 < contentLength && contents[charCursor + 1] == '\n') {
/* 381 */               charCursor++;
/*     */             }
/* 383 */             charCursor++;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 388 */         sb.append('\n');
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 393 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeXml(XmlExportWriter w) throws IOException {
/* 401 */     List<XmlExportAttribute> l = new LinkedList<>();
/* 402 */     l.add(new XmlExportAttribute("isdoublewidefont", this.isDoubleWideFont_ + ""));
/* 403 */     if (this.alignment_ != null && this.alignment_ != DocBuilderAlignmentType.LEFT) {
/* 404 */       l.add(new XmlExportAttribute("alignment", this.alignment_.getName() + ""));
/*     */     }
/*     */     
/* 407 */     l.add(new XmlExportAttribute("isFromTextBlock", isFromTextBlock() + ""));
/*     */     
/* 409 */     if (isFromTextBlock()) {
/* 410 */       l.add(new XmlExportAttribute("textCode", getTextCode()));
/* 411 */       l.add(new XmlExportAttribute("textSubCode", getTextSubCode()));
/*     */     } 
/*     */     
/* 414 */     w.writeHeader("region", l.<XmlExportAttribute>toArray(new XmlExportAttribute[l.size()]));
/*     */     
/* 416 */     if (this.elementFactoryClass_ != null) {
/* 417 */       w.writestring("elementFactory", this.elementFactoryClass_);
/*     */     }
/* 419 */     w.writestring("preformatting", this.preFormatting_);
/* 420 */     w.writestring("leftmargin", this.leftMargin_);
/* 421 */     w.writestring("rightmargin", this.rightMargin_);
/* 422 */     for (int i = 0; i < this.con_.getSize(); i++) {
/*     */       
/* 424 */       w.writeHeader("lineinfo");
/* 425 */       w.writestring("lineformatting", this.con_.getLineFormatting(i));
/* 426 */       w.writestring("contents", this.con_.getContents(i));
/* 427 */       w.writeFooter("lineinfo");
/*     */     } 
/* 429 */     w.writestring("postformatting", this.postFormatting_);
/*     */     
/* 431 */     w.writeFooter("region");
/*     */   }
/*     */ 
/*     */   
/*     */   private void ensureNonNull(Object o, String argMessage) {
/* 436 */     if (o == null) {
/* 437 */       throw new NullPointerException(argMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int findEndOfLine(char[] argContentArray, int argStart, int argMaxEnd) {
/* 443 */     int testEndOfLine = argMaxEnd;
/* 444 */     if (testEndOfLine != argContentArray.length)
/*     */     {
/* 446 */       while (testEndOfLine > argStart && !Character.isWhitespace(argContentArray[testEndOfLine])) {
/* 447 */         testEndOfLine--;
/*     */       }
/*     */     }
/*     */     
/* 451 */     if (testEndOfLine == argStart) {
/* 452 */       testEndOfLine = argMaxEnd;
/*     */     }
/*     */ 
/*     */     
/* 456 */     for (int i = argStart; i < testEndOfLine; i++) {
/* 457 */       if (argContentArray[i] == '\n') {
/* 458 */         testEndOfLine = i;
/*     */         break;
/*     */       } 
/*     */     } 
/* 462 */     return testEndOfLine;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getMaxLineEnd(char[] argContentArray, boolean[] argWidths, int argStart, int argSpaceToFill) {
/* 468 */     int maxLineEnd = argStart;
/* 469 */     int spaceLeft = argSpaceToFill;
/* 470 */     for (; maxLineEnd < argContentArray.length && spaceLeft > 0; maxLineEnd++) {
/* 471 */       spaceLeft -= argWidths[maxLineEnd] ? 2 : 1;
/*     */     }
/* 473 */     if (spaceLeft < 0)
/*     */     {
/* 475 */       maxLineEnd--;
/*     */     }
/* 477 */     return maxLineEnd;
/*     */   }
/*     */   
/*     */   private boolean[] getWidths(char[] argChars) {
/* 481 */     CharWidth cw = new CharWidth();
/* 482 */     boolean[] widths = new boolean[argChars.length];
/* 483 */     for (int j = 0; j < argChars.length; j++) {
/* 484 */       widths[j] = cw.isWide(argChars[j]);
/*     */     }
/* 486 */     return widths;
/*     */   }
/*     */   
/*     */   private class Contents
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 7885865116657712008L;
/*     */     private final String rawText_;
/*     */     private final String[] contents_;
/*     */     private final String[] formatting_;
/*     */     private final String[] formattingPost_;
/*     */     private final boolean[] isDoubleWide_;
/*     */     
/*     */     public Contents(String argContents, String argBaseLineFormatting) {
/* 500 */       this.rawText_ = argContents;
/*     */       
/* 502 */       StringBuffer sb = new StringBuffer(argContents);
/* 503 */       StringUtils.replaceAll(sb, "<br>", "\n");
/* 504 */       StringUtils.replaceAll(sb, "\r\n", "\n");
/* 505 */       String[] contents = StringUtils.split(sb.toString(), '\n');
/*     */       
/* 507 */       StringBuffer sbFmt = new StringBuffer(argBaseLineFormatting);
/* 508 */       StringUtils.replaceAll(sbFmt, "<br>", "\n");
/* 509 */       StringUtils.replaceAll(sbFmt, "\r\n", "\n");
/* 510 */       String[] baseLineFormatting = StringUtils.split(sbFmt.toString(), '\n');
/*     */       
/* 512 */       this.contents_ = new String[contents.length];
/* 513 */       this.formatting_ = new String[contents.length];
/* 514 */       this.formattingPost_ = new String[contents.length];
/* 515 */       this.isDoubleWide_ = new boolean[contents.length];
/*     */ 
/*     */ 
/*     */       
/* 519 */       if (argContents.isEmpty()) {
/* 520 */         this.contents_[0] = argContents;
/* 521 */         this.formatting_[0] = "";
/* 522 */         this.formattingPost_[0] = "";
/* 523 */         this.isDoubleWide_[0] = false;
/*     */         
/*     */         return;
/*     */       } 
/* 527 */       boolean reprinting = false;
/*     */       
/* 529 */       for (int i = 0; i < contents.length; i++) {
/* 530 */         this.contents_[i] = contents[i];
/* 531 */         this.formatting_[i] = "";
/* 532 */         this.formattingPost_[i] = "";
/* 533 */         this.isDoubleWide_[i] = false;
/*     */ 
/*     */ 
/*     */         
/* 537 */         if (this.contents_[i].startsWith("<")) {
/*     */           try {
/* 539 */             Document doc = DomUtils.parseXml(this.contents_[i], new DomUtils.ParseOption[0]);
/*     */             
/* 541 */             Element element = doc.getDocumentElement();
/*     */             
/* 543 */             processElement(element, i);
/*     */           }
/* 545 */           catch (Exception e) {
/* 546 */             FormattedRegion.logger_.error("Error parsing formatted region text.  Text = '" + this.contents_[i] + "'", e);
/*     */           }
/*     */         
/*     */         }
/* 550 */         else if (baseLineFormatting.length == contents.length && baseLineFormatting.length > 1) {
/*     */ 
/*     */           
/* 553 */           reprinting = true;
/*     */           
/* 555 */           this.formatting_[i] = baseLineFormatting[i];
/*     */           
/* 557 */           if (this.formatting_[i] != null) {
/* 558 */             String compareFmt = this.formatting_[i].replaceAll("%ESC%", "\033");
/*     */             
/* 560 */             if (compareFmt
/* 561 */               .indexOf(DocBuilderRowCharSize.DOUBLEHIGH.getFieldFontInfo().getBeginFont()) >= 0) {
/* 562 */               this.isDoubleWide_[i] = DocBuilderRowCharSize.DOUBLEHIGH.isDoubleWide();
/* 563 */               this.formattingPost_[i] = this.formattingPost_[i] + DocBuilderRowCharSize.DOUBLEHIGH
/* 564 */                 .getFieldFontInfo().getEndFont();
/*     */             }
/* 566 */             else if (compareFmt
/* 567 */               .indexOf(DocBuilderRowCharSize.DOUBLEWIDE.getFieldFontInfo().getBeginFont()) >= 0) {
/* 568 */               this.isDoubleWide_[i] = DocBuilderRowCharSize.DOUBLEWIDE.isDoubleWide();
/* 569 */               this.formattingPost_[i] = this.formattingPost_[i] + DocBuilderRowCharSize.DOUBLEWIDE
/* 570 */                 .getFieldFontInfo().getEndFont();
/*     */             }
/* 572 */             else if (compareFmt.indexOf(DocBuilderRowCharSize.DOUBLEHIGHDOUBLEWIDE
/* 573 */                 .getFieldFontInfo().getBeginFont()) >= 0) {
/* 574 */               this.isDoubleWide_[i] = DocBuilderRowCharSize.DOUBLEHIGHDOUBLEWIDE.isDoubleWide();
/* 575 */               this.formattingPost_[i] = this.formattingPost_[i] + DocBuilderRowCharSize.DOUBLEHIGHDOUBLEWIDE
/* 576 */                 .getFieldFontInfo().getEndFont();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 583 */         if (StringUtils.isEmpty(this.formatting_[i]) && !reprinting) {
/* 584 */           this.formatting_[i] = argBaseLineFormatting;
/*     */         }
/*     */         
/* 587 */         IDocElementFactory elementFactory = FormattedRegion.this.getElementFactory();
/* 588 */         if (elementFactory != null) {
/* 589 */           this.formattingPost_[i] = this.formattingPost_[i] + elementFactory.getFieldStyleEnd("normal");
/*     */         }
/*     */         
/* 592 */         this.contents_[i] = this.contents_[i] + "\n";
/*     */       } 
/*     */     }
/*     */     
/*     */     public String getContents(int argIndex) {
/* 597 */       return this.contents_[argIndex];
/*     */     }
/*     */     
/*     */     public String getLineFormatting(int argIndex) {
/* 601 */       return this.formatting_[argIndex];
/*     */     }
/*     */     
/*     */     public String getLineFormattingPost(int argIndex) {
/* 605 */       return this.formattingPost_[argIndex];
/*     */     }
/*     */     
/*     */     public String getRawText() {
/* 609 */       return this.rawText_;
/*     */     }
/*     */     
/*     */     public int getSize() {
/* 613 */       return this.contents_.length;
/*     */     }
/*     */     
/*     */     public boolean isDoubleWide(int argIndex) {
/* 617 */       return this.isDoubleWide_[argIndex];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void processElement(Element element, int index) {
/* 623 */       String qualifiedName = element.getNodeName();
/* 624 */       IDocElementFactory elementFactory = FormattedRegion.this.getElementFactory();
/* 625 */       if (elementFactory != null) {
/* 626 */         if (qualifiedName.equalsIgnoreCase("b")) {
/* 627 */           this.formatting_[index] = this.formatting_[index] + elementFactory.getFieldStyleStart("bold");
/*     */         }
/* 629 */         else if (qualifiedName.equalsIgnoreCase("i")) {
/* 630 */           this.formatting_[index] = this.formatting_[index] + elementFactory.getFieldStyleStart("italics");
/*     */         }
/* 632 */         else if (qualifiedName.equalsIgnoreCase("u")) {
/* 633 */           this.formatting_[index] = this.formatting_[index] + elementFactory.getFieldStyleStart("underline");
/*     */         }
/* 635 */         else if (qualifiedName.equalsIgnoreCase("r")) {
/* 636 */           this.formatting_[index] = this.formatting_[index] + elementFactory.getFieldStyleStart("reverse");
/*     */         }
/* 638 */         else if (qualifiedName.equalsIgnoreCase("p")) {
/* 639 */           Collection<Attr> attributeCollection = DomUtils.getAttributes(element);
/* 640 */           if (attributeCollection != null) {
/* 641 */             for (Attr attribute : attributeCollection) {
/*     */               
/* 643 */               if (attribute.getName().equalsIgnoreCase("Size")) {
/* 644 */                 String size = attribute.getValue();
/* 645 */                 DocBuilderRowCharSize charSize = DocBuilderRowCharSize.forName(size);
/*     */                 
/* 647 */                 this.formatting_[index] = this.formatting_[index] + charSize.getFieldFontInfo().getBeginFont();
/* 648 */                 this.formattingPost_[index] = this.formattingPost_[index] + charSize.getFieldFontInfo().getEndFont();
/*     */                 
/* 650 */                 if (!this.isDoubleWide_[index])
/* 651 */                   this.isDoubleWide_[index] = charSize.isDoubleWide(); 
/*     */                 continue;
/*     */               } 
/* 654 */               if (attribute.getName().equalsIgnoreCase("Align")) {
/* 655 */                 String alignment = attribute.getValue();
/* 656 */                 DocBuilderAlignmentType alignmentType = DocBuilderAlignmentType.forName(alignment);
/* 657 */                 FormattedRegion.this.alignment_ = alignmentType;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 664 */       Collection<Element> children = DomUtils.getChildElements(element);
/* 665 */       if (children == null || children.size() == 0) {
/* 666 */         this.contents_[index] = DomUtils.getElementValue(element);
/*     */       } else {
/*     */         
/* 669 */         for (Element child : children)
/* 670 */           processElement(child, index); 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\FormattedRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */