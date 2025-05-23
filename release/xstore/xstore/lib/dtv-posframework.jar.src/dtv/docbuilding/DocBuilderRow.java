/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.docbuilding.types.DocBuilderRowStyleType;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderRow
/*     */   extends AbstractDocBuilderSectionMember
/*     */   implements IDocBuilderIteratorMember
/*     */ {
/*     */   private final List<IDocBuilderField> fields_;
/*     */   private final List<IDocBuilderCondition> conditions_;
/*     */   private final DocBuilderAlignmentType alignment_;
/*     */   private final DocBuilderRowCharSize charSize_;
/*     */   private final DocBuilderRowStyleType style_;
/*     */   private final String rowStyle_;
/*     */   private final boolean overtype_;
/*     */   
/*     */   public DocBuilderRow() {
/*  32 */     this(DocBuilderAlignmentType.DEFAULT, DocBuilderRowCharSize.NORMAL, (DocBuilderRowStyleType)null, false, (List<IDocBuilderCondition>)null, (List<IDocBuilderField>)null);
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
/*     */   public DocBuilderRow(DocBuilderAlignmentType argAlignment, DocBuilderRowCharSize argCharSize, DocBuilderRowStyleType argRowStyle, boolean argOvertype, List<IDocBuilderCondition> argConditions, List<IDocBuilderField> argFields) {
/*  50 */     this(argAlignment, argCharSize, argRowStyle, (String)null, argOvertype, argConditions, argFields);
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
/*     */   public DocBuilderRow(DocBuilderAlignmentType argAlignment, String argRowStyle, boolean argOvertype, List<IDocBuilderCondition> argConditions, List<IDocBuilderField> argFields) {
/*  66 */     this(argAlignment, (DocBuilderRowCharSize)null, (DocBuilderRowStyleType)null, argRowStyle, argOvertype, argConditions, argFields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocBuilderRow(DocBuilderAlignmentType argAlignment, DocBuilderRowCharSize argCharSize, DocBuilderRowStyleType argStyle, String argRowStyle, boolean argOvertype, List<IDocBuilderCondition> argConditions, List<IDocBuilderField> argFields) {
/*  73 */     this.alignment_ = argAlignment;
/*  74 */     this.charSize_ = argCharSize;
/*  75 */     this.style_ = argStyle;
/*  76 */     this.rowStyle_ = argRowStyle;
/*  77 */     this.overtype_ = argOvertype;
/*  78 */     this.conditions_ = argConditions;
/*  79 */     this.fields_ = (argFields == null) ? new ArrayList<>() : argFields;
/*     */   }
/*     */   
/*     */   public void addField(IDocBuilderField argField) {
/*  83 */     this.fields_.add(argField);
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
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*  98 */     if (!DocBuilderHelper.meetsConditions(argSource, this.conditions_)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 104 */     IDocBuilderField.FontInfo fontInfo = (this.charSize_ == null) ? DocBuilderRowCharSize.NORMAL.getFieldFontInfo() : this.charSize_.getFieldFontInfo();
/*     */     
/* 106 */     List<FormattedLine.Field> fieldList = new ArrayList<>();
/* 107 */     Locale locale = getDocumentLocale(argDoc);
/* 108 */     for (IDocBuilderField element : this.fields_) {
/* 109 */       FormattedString[] fieldContents = element.buildField(argSource, argElementFactory, fontInfo, locale);
/*     */       
/* 111 */       for (FormattedString fieldContent : fieldContents) {
/*     */         
/* 113 */         FormattedLine.Field f = new FormattedLine.Field(element.getLocation(), fieldContent, element.getAlignment(), element.getPriority());
/* 114 */         f.setSourceDescription(element.getSourceDescription());
/*     */         
/* 116 */         fieldList.add(f);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 122 */     if (this.fields_.isEmpty() || !fieldList.isEmpty()) {
/* 123 */       FormattedLine.Field[] fields = fieldList.<FormattedLine.Field>toArray(new FormattedLine.Field[0]);
/*     */       
/* 125 */       String rowStyle = (this.rowStyle_ != null) ? this.rowStyle_ : argElementFactory.getRowStyle(this.style_);
/*     */       
/* 127 */       FormattedLine fLine = new FormattedLine(fields, this.alignment_, rowStyle, this.overtype_);
/* 128 */       fLine.setSourceDescription(getSourceDescription());
/* 129 */       List<FormattedLine> lines = new ArrayList<>();
/* 130 */       lines.add(fLine);
/* 131 */       argDoc.appendElement(argElementFactory.makeTextElement((Collection)lines));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void trace(ITracer argTracer) {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderRow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */