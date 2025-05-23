/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import dtv.util.xmlexport.IXmlExportable;
/*     */ import dtv.util.xmlexport.XmlExportAttribute;
/*     */ import dtv.util.xmlexport.XmlExportWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormattedLine
/*     */   implements IWidthAwareString, IXmlExportable, IHasSourceDescription
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(FormattedLine.class);
/*     */   private static final long serialVersionUID = -3318845382926757756L;
/*  30 */   private static final Integer INT_ZERO = Integer.valueOf(0);
/*     */   
/*     */   private final Field[] fields_;
/*     */   
/*     */   private final DocBuilderAlignmentType alignment_;
/*     */   
/*     */   private final String lineFormatting_;
/*     */   private final boolean splitInsteadOfOvertype_;
/*     */   
/*     */   public static FormattedLine fromXml(Element argXmlElement) {
/*  40 */     boolean split = getSplitAttribute(argXmlElement);
/*  41 */     DocBuilderAlignmentType alignment = getAlignment(argXmlElement);
/*  42 */     String formatting = DomUtils.getChildElementValue(argXmlElement, "formatting");
/*  43 */     Field[] fields = getFields(argXmlElement);
/*     */     
/*  45 */     return new FormattedLine(fields, alignment, formatting, !split);
/*     */   }
/*     */   
/*     */   private static DocBuilderAlignmentType getAlignment(Element argElement) {
/*  49 */     String attributeName = argElement.getAttribute("alignment");
/*  50 */     if (!StringUtils.isEmpty(attributeName)) {
/*  51 */       return DocBuilderAlignmentType.forName(attributeName);
/*     */     }
/*  53 */     return DocBuilderAlignmentType.LEFT;
/*     */   }
/*     */   
/*     */   private static Field[] getFields(Element argElement) {
/*  57 */     List<Field> results = new LinkedList<>();
/*  58 */     NodeList children = argElement.getElementsByTagName("field");
/*  59 */     for (int i = 0; i < children.getLength(); i++) {
/*  60 */       if (children.item(i) instanceof Element) {
/*  61 */         Element childElement = (Element)children.item(i);
/*  62 */         Field f = Field.fromXml(childElement);
/*  63 */         if (f != null) {
/*  64 */           results.add(f);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     return results.<Field>toArray(new Field[results.size()]);
/*     */   }
/*     */   
/*     */   private static boolean getSplitAttribute(Element argElement) {
/*  73 */     String attribute = argElement.getAttribute("split");
/*  74 */     if (!StringUtils.isEmpty(attribute)) {
/*     */       try {
/*  76 */         return Boolean.parseBoolean(attribute);
/*     */       }
/*  78 */       catch (Exception ex) {
/*  79 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   private transient StringBuffer stringified_ = null;
/*  91 */   private transient int toStringWidth_ = -1;
/*  92 */   private transient StringBuffer rawText_ = null;
/*  93 */   private transient String sourceDescription_ = null;
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
/*     */   public FormattedLine(Field[] argFields, DocBuilderAlignmentType argAlignment, String argLineFormatting, boolean argOvertype) {
/* 107 */     this.fields_ = argFields;
/* 108 */     this.alignment_ = argAlignment;
/* 109 */     this.lineFormatting_ = argLineFormatting;
/* 110 */     this.splitInsteadOfOvertype_ = !argOvertype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRawText() {
/* 120 */     if (this.rawText_ == null) {
/* 121 */       this.rawText_ = new StringBuffer();
/* 122 */       for (Field element : this.fields_) {
/* 123 */         this.rawText_.append(element.getContents().getRawText());
/*     */       }
/*     */     } 
/* 126 */     return this.rawText_.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 132 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/* 142 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     return toString(40);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(int argLineLength) {
/* 163 */     if (this.stringified_ == null || this.toStringWidth_ != argLineLength) {
/*     */       try {
/* 165 */         this.stringified_ = new StringBuffer(argLineLength);
/* 166 */         FormattingList formattingList = new FormattingList();
/* 167 */         char[] columns = new char[argLineLength];
/* 168 */         int[] columnPriorities = new int[argLineLength];
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 173 */         int[] columnCharParts = new int[argLineLength];
/*     */         
/* 175 */         newLine(columns, columnPriorities, columnCharParts);
/*     */         
/* 177 */         int nextFieldStart = 0;
/* 178 */         int lastChar = 0;
/*     */         
/* 180 */         for (Field field : this.fields_) {
/* 181 */           Integer location = field.getColumn();
/* 182 */           FormattedString data = field.getContents();
/* 183 */           int rawTextLength = data.getRawTextLength();
/*     */           
/* 185 */           int startingColumn = getStartingColumn(argLineLength, nextFieldStart, location, rawTextLength, field.getAlignment());
/* 186 */           int endingColumn = getEndingColumn(argLineLength, rawTextLength, startingColumn);
/* 187 */           int fieldPriority = field._priority;
/*     */           
/* 189 */           int fieldCharIndex = 0;
/* 190 */           while (startingColumn < 0) {
/*     */             
/* 192 */             fieldCharIndex++;
/* 193 */             startingColumn++;
/*     */           } 
/*     */           
/* 196 */           if (this.splitInsteadOfOvertype_) {
/* 197 */             for (int j = startingColumn; j < endingColumn; j++) {
/*     */               
/* 199 */               if (columnPriorities[j] > Integer.MIN_VALUE) {
/*     */                 
/* 201 */                 this.stringified_
/* 202 */                   .append(endLine(argLineLength, columns, columnCharParts, lastChar, formattingList));
/* 203 */                 this.stringified_.append("\n");
/*     */                 
/* 205 */                 newLine(columns, columnPriorities, columnCharParts);
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/* 211 */           clearPositions(fieldPriority, startingColumn, endingColumn, columnCharParts, columnPriorities, columns);
/*     */ 
/*     */           
/* 214 */           for (int i = startingColumn; i < endingColumn; i++) {
/* 215 */             int width = 1;
/* 216 */             if (fieldPriority >= columnPriorities[i]) {
/* 217 */               width = setPosition(data, i, fieldCharIndex, fieldPriority, columnCharParts, columns, columnPriorities);
/*     */               
/* 219 */               i += width - 1;
/* 220 */               lastChar = Math.max(lastChar, i + width - 1);
/*     */             } 
/* 222 */             fieldCharIndex++;
/*     */           } 
/*     */           
/* 225 */           formattingList.add(startingColumn, data.getPreFormatting());
/* 226 */           formattingList.add(endingColumn, data.getPostFormatting());
/*     */           
/* 228 */           nextFieldStart = endingColumn;
/*     */         } 
/*     */ 
/*     */         
/* 232 */         this.stringified_.append(endLine(argLineLength, columns, columnCharParts, lastChar, formattingList));
/* 233 */         this.toStringWidth_ = argLineLength;
/*     */       }
/* 235 */       catch (Exception ex) {
/* 236 */         logger_.error("CAUGHT EXCEPTION::" + getSourceDescription(), ex);
/* 237 */         return "";
/*     */       } 
/*     */     }
/*     */     
/* 241 */     return this.stringified_.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeXml(XmlExportWriter w) throws IOException {
/* 249 */     List<XmlExportAttribute> l = new LinkedList<>();
/* 250 */     if (!this.splitInsteadOfOvertype_) {
/* 251 */       l.add(new XmlExportAttribute("split", "false"));
/*     */     }
/* 253 */     if (this.alignment_ != null && this.alignment_ != DocBuilderAlignmentType.LEFT) {
/* 254 */       l.add(new XmlExportAttribute("alignment", this.alignment_.getName() + ""));
/*     */     }
/* 256 */     w.writeHeader("line", l.<XmlExportAttribute>toArray(new XmlExportAttribute[l.size()]));
/* 257 */     w.writestring("formatting", this.lineFormatting_);
/*     */     
/* 259 */     for (Field element : this.fields_) {
/* 260 */       element.writeXml(w);
/*     */     }
/* 262 */     w.writeFooter("line");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void clearPosition(int argFieldPriority, int argPosition, int[] argColumnCharPart, int[] argColumnPriorities, char[] argColumns) {
/* 268 */     if (argColumnPriorities[argPosition] > argFieldPriority) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 273 */     if (argColumnCharPart[argPosition] == 0) {
/* 274 */       argColumns[argPosition] = ' ';
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 279 */     int position = argPosition;
/* 280 */     while (argColumnCharPart[position] > 1) {
/* 281 */       position--;
/*     */     }
/*     */ 
/*     */     
/* 285 */     argColumns[position] = ' ';
/* 286 */     argColumnCharPart[position] = 0;
/*     */ 
/*     */     
/* 289 */     for (int i = position + 1; i < argColumns.length; i++) {
/* 290 */       argColumns[position] = ' ';
/* 291 */       argColumnCharPart[position] = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void clearPositions(int argFieldPriority, int argStartingColumn, int argEndingColumn, int[] argColumnCharPart, int[] argColumnPriorities, char[] argColumns) {
/* 298 */     int end = Math.min(argEndingColumn, argColumnPriorities.length - 1);
/* 299 */     for (int i = argStartingColumn; i < end; i++) {
/* 300 */       clearPosition(argFieldPriority, i, argColumnCharPart, argColumnPriorities, argColumns);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String endLine(int argLineLength, char[] argColumns, int[] argCharParts, int argLastChar, FormattingList argFormattingList) {
/* 307 */     StringBuffer line = new StringBuffer(argLineLength + 10);
/*     */     
/* 309 */     if (this.lineFormatting_ != null) {
/* 310 */       line.append(this.lineFormatting_);
/*     */     }
/*     */ 
/*     */     
/* 314 */     int start = 0;
/* 315 */     if (this.alignment_ == DocBuilderAlignmentType.CENTERED) {
/* 316 */       start = argLineLength - argLastChar >> 1;
/*     */     }
/* 318 */     else if (this.alignment_ == DocBuilderAlignmentType.RIGHT) {
/* 319 */       start = argLineLength - argLastChar - 1;
/*     */     } 
/* 321 */     for (int i = 0; i < start; i++) {
/* 322 */       line.append(' ');
/*     */     }
/*     */ 
/*     */     
/* 326 */     Iterator<FormattingEntry> formattingEntryIter = argFormattingList.iterator();
/* 327 */     FormattingEntry formatting = nextFormattingEntry(formattingEntryIter);
/* 328 */     for (int j = 0; j <= argLastChar && j < argCharParts.length; j++) {
/* 329 */       int part = argCharParts[j];
/*     */       
/* 331 */       if (part < 2) {
/* 332 */         while (formatting._position <= j) {
/*     */           
/* 334 */           line.append(formatting._text);
/* 335 */           formatting = nextFormattingEntry(formattingEntryIter);
/*     */         } 
/* 337 */         line.append(argColumns[j]);
/*     */       } 
/*     */     } 
/* 340 */     line.append(formatting._text);
/* 341 */     argFormattingList.clear();
/*     */ 
/*     */     
/* 344 */     int endingSpaceCount = argLineLength - argLastChar - start - 1;
/* 345 */     for (int k = 0; k < endingSpaceCount; k++) {
/* 346 */       line.append(' ');
/*     */     }
/*     */     
/* 349 */     return line.toString();
/*     */   }
/*     */   
/*     */   private int getEndingColumn(int argLineLength, int argRawTextLength, int argStartingColumn) {
/* 353 */     int endingColumn = argStartingColumn + argRawTextLength;
/* 354 */     if (endingColumn > argLineLength) {
/* 355 */       endingColumn = argLineLength;
/*     */     }
/* 357 */     return endingColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getStartingColumn(int lineLength, int charCursor, Integer location, int rawTextLength, DocBuilderAlignmentType alignment) {
/*     */     int i;
/* 364 */     if (location == null) {
/* 365 */       i = charCursor;
/*     */     }
/* 367 */     else if (location.compareTo(INT_ZERO) < 0) {
/* 368 */       i = lineLength + location.intValue();
/*     */     } else {
/*     */       
/* 371 */       i = location.intValue();
/*     */     } 
/* 373 */     if (alignment == DocBuilderAlignmentType.RIGHT) {
/* 374 */       if (location == null) {
/* 375 */         i = lineLength - rawTextLength;
/*     */       } else {
/*     */         
/* 378 */         i -= rawTextLength;
/*     */       }
/*     */     
/* 381 */     } else if (alignment == DocBuilderAlignmentType.CENTERED) {
/* 382 */       i -= rawTextLength >> 1;
/*     */     } 
/* 384 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private void newLine(char[] argColumns, int[] argColumnPriorities, int[] argColumnCharPart) {
/* 389 */     Arrays.fill(argColumnPriorities, -2147483648);
/* 390 */     Arrays.fill(argColumns, ' ');
/* 391 */     Arrays.fill(argColumnCharPart, 0);
/*     */   }
/*     */   
/*     */   private FormattingEntry nextFormattingEntry(Iterator<FormattingEntry> it) {
/* 395 */     if (it.hasNext()) {
/* 396 */       return it.next();
/*     */     }
/*     */     
/* 399 */     return new FormattingEntry(2147483647, "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int setPosition(FormattedString argData, int argStartColumn, int argFieldCharIndex, int argFieldPriority, int[] argColumnCharPart, char[] argColumns, int[] argColumnPriorities) {
/* 406 */     int width = argData.charWidthAt(argFieldCharIndex);
/* 407 */     int endColumn = argStartColumn + width - 1;
/* 408 */     if (endColumn >= argColumns.length)
/*     */     {
/* 410 */       return 0;
/*     */     }
/* 412 */     if (width == 1) {
/* 413 */       argColumnCharPart[argStartColumn] = 0;
/* 414 */       argColumns[argStartColumn] = argData.charAt(argFieldCharIndex);
/* 415 */       argColumnPriorities[argStartColumn] = argFieldPriority;
/*     */     } else {
/*     */       
/* 418 */       int partIndex = 1;
/* 419 */       for (int i = argStartColumn; i <= endColumn; i++) {
/* 420 */         argColumnCharPart[i] = partIndex++;
/* 421 */         argColumns[i] = argData.charAt(argFieldCharIndex);
/* 422 */         argColumnPriorities[i] = argFieldPriority;
/*     */       } 
/*     */     } 
/* 425 */     return width;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Field
/*     */     implements Serializable, IXmlExportable, IHasSourceDescription
/*     */   {
/*     */     private static final long serialVersionUID = 2233861968639445630L;
/*     */ 
/*     */     
/*     */     protected final Integer _column;
/*     */     
/*     */     protected final FormattedString _contents;
/*     */     
/*     */     protected final DocBuilderAlignmentType _alignment;
/*     */     
/*     */     protected final int _priority;
/*     */     
/*     */     private transient String _sourceDescription;
/*     */ 
/*     */     
/*     */     public static Field fromXml(Element argXmlElement) {
/* 448 */       Integer column = null;
/* 449 */       String colAttr = argXmlElement.getAttribute("column");
/* 450 */       if (!StringUtils.isEmpty(colAttr)) {
/* 451 */         column = Integer.valueOf(colAttr);
/*     */       }
/* 453 */       int priority = 0;
/* 454 */       String priAttr = argXmlElement.getAttribute("priority");
/* 455 */       if (!StringUtils.isEmpty(priAttr)) {
/* 456 */         priority = Integer.parseInt(priAttr);
/*     */       }
/* 458 */       DocBuilderAlignmentType alignment = DocBuilderAlignmentType.LEFT;
/* 459 */       String alignmentName = argXmlElement.getAttribute("alignment");
/* 460 */       if (!StringUtils.isEmpty(alignmentName)) {
/* 461 */         alignment = DocBuilderAlignmentType.forName(alignmentName);
/*     */       }
/*     */       
/* 464 */       FormattedString contents = FormattedString.fromXml(DomUtils.getChildElement(argXmlElement, "formattedstring"));
/* 465 */       return new Field(column, contents, alignment, priority);
/*     */     }
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
/*     */     public Field(Integer argColumn, FormattedString argContents, DocBuilderAlignmentType argAlignment, int argPriority) {
/* 487 */       this._column = argColumn;
/* 488 */       this._contents = argContents;
/* 489 */       if (argAlignment == DocBuilderAlignmentType.DEFAULT) {
/* 490 */         this._alignment = DocBuilderAlignmentType.LEFT;
/*     */       } else {
/*     */         
/* 493 */         this._alignment = argAlignment;
/*     */       } 
/* 495 */       this._priority = argPriority;
/*     */     }
/*     */     
/*     */     public DocBuilderAlignmentType getAlignment() {
/* 499 */       return this._alignment;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getColumn() {
/* 509 */       return this._column;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FormattedString getContents() {
/* 518 */       return this._contents;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getSourceDescription() {
/* 523 */       return this._sourceDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSourceDescription(String argSourceDescription) {
/* 533 */       this._sourceDescription = argSourceDescription;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 543 */       return this._column + ":" + this._alignment + ":" + this._contents;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void writeXml(XmlExportWriter w) throws IOException {
/* 551 */       List<XmlExportAttribute> l = new LinkedList<>();
/* 552 */       if (this._column != null) {
/* 553 */         l.add(new XmlExportAttribute("column", this._column.toString()));
/*     */       }
/* 555 */       if (this._priority != 0) {
/* 556 */         l.add(new XmlExportAttribute("priority", this._priority + ""));
/*     */       }
/* 558 */       if (this._alignment != null && this._alignment != DocBuilderAlignmentType.LEFT) {
/* 559 */         l.add(new XmlExportAttribute("alignment", this._alignment.getName() + ""));
/*     */       }
/* 561 */       w.writeHeader("field", l.<XmlExportAttribute>toArray(new XmlExportAttribute[l.size()]));
/* 562 */       this._contents.writeXml(w);
/* 563 */       w.writeFooter("field");
/*     */     }
/*     */   }
/*     */   
/*     */   class FormattingEntry
/*     */     implements Comparable<FormattingEntry>
/*     */   {
/*     */     final int _position;
/*     */     final String _text;
/*     */     
/*     */     FormattingEntry(int argPosition, String argText) {
/* 574 */       this._position = argPosition;
/* 575 */       this._text = argText;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(FormattingEntry other) {
/* 580 */       return this._position - other._position;
/*     */     }
/*     */   }
/*     */   
/*     */   class FormattingList
/*     */     implements Iterable<FormattingEntry>
/*     */   {
/* 587 */     FormattedLine.FormattingEntry[] _entries = new FormattedLine.FormattingEntry[10];
/* 588 */     int _maxSize = 10;
/* 589 */     int _size = 0;
/*     */ 
/*     */     
/*     */     public Iterator<FormattedLine.FormattingEntry> iterator() {
/* 593 */       return new Iterator<FormattedLine.FormattingEntry>()
/*     */         {
/* 595 */           private int _index = 0;
/* 596 */           private final FormattedLine.FormattingEntry[] _array = FormattedLine.FormattingList.this.toArray();
/*     */ 
/*     */           
/*     */           public boolean hasNext() {
/* 600 */             if (this._index < this._array.length) {
/* 601 */               return true;
/*     */             }
/*     */             
/* 604 */             return false;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public FormattedLine.FormattingEntry next() {
/* 610 */             if (!hasNext()) {
/* 611 */               throw new NoSuchElementException();
/*     */             }
/* 613 */             return this._array[this._index++];
/*     */           }
/*     */ 
/*     */           
/*     */           public void remove() {
/* 618 */             throw new UnsupportedOperationException("remove not allowed");
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     void add(int argPosition, String argText) {
/* 624 */       if (argText == null || argText.length() == 0) {
/*     */         return;
/*     */       }
/* 627 */       FormattedLine.FormattingEntry entry = new FormattedLine.FormattingEntry(argPosition, argText);
/* 628 */       if (++this._size > this._maxSize) {
/* 629 */         grow();
/*     */       }
/* 631 */       this._entries[this._size - 1] = entry;
/*     */     }
/*     */     
/*     */     void clear() {
/* 635 */       this._size = 0;
/*     */     }
/*     */     
/*     */     FormattedLine.FormattingEntry[] toArray() {
/* 639 */       FormattedLine.FormattingEntry[] e = new FormattedLine.FormattingEntry[this._size];
/* 640 */       System.arraycopy(this._entries, 0, e, 0, this._size);
/* 641 */       Arrays.sort((Object[])e);
/* 642 */       return e;
/*     */     }
/*     */     
/*     */     private void grow() {
/* 646 */       this._maxSize += 10;
/* 647 */       FormattedLine.FormattingEntry[] newEntries = new FormattedLine.FormattingEntry[this._maxSize];
/* 648 */       System.arraycopy(this._entries, 0, newEntries, 0, this._entries.length);
/* 649 */       this._entries = newEntries;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\FormattedLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */