/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.IOException;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ public class DocBuilderTextBlock
/*     */   extends AbstractDocBuilderSectionMember
/*     */   implements IDocBuilderIteratorMember
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(DocBuilderTextBlock.class);
/*     */   
/*     */   private final String dateMethod_;
/*     */   
/*     */   private final IDocBuilderField code_;
/*     */   
/*     */   private final IDocBuilderField subcode_;
/*     */   
/*     */   private final List<IDocBuilderField> fields_;
/*     */   
/*     */   private final List<IDocBuilderCondition> conditions_;
/*     */   private final String leftMargin_;
/*     */   private final String rightMargin_;
/*     */   private final DocBuilderAlignmentType alignment_;
/*     */   private final DocBuilderRowCharSize charSize_;
/*     */   private final String style_;
/*     */   
/*     */   public DocBuilderTextBlock(String argDateMethod, IDocBuilderField argCode, IDocBuilderField argSubCode, List<IDocBuilderField> argFields, String argLeftMargin, String argRightMargin, DocBuilderAlignmentType argAlignment, DocBuilderRowCharSize argCharSize, String argStyle, List<IDocBuilderCondition> argConditions) {
/*  48 */     ensureNonNull(argCode, "code cannot be null");
/*  49 */     ensureNonNull(argSubCode, "subcode cannot be null");
/*  50 */     ensureNonNull(argLeftMargin, "left margin cannot be null");
/*  51 */     ensureNonNull(argRightMargin, "right margin cannot be null");
/*  52 */     ensureNonNull(argAlignment, "alignment cannot be null");
/*     */     
/*  54 */     this.dateMethod_ = argDateMethod;
/*  55 */     this.code_ = argCode;
/*  56 */     this.subcode_ = argSubCode;
/*  57 */     this.fields_ = argFields;
/*  58 */     this.leftMargin_ = argLeftMargin;
/*  59 */     this.rightMargin_ = argRightMargin;
/*  60 */     this.alignment_ = argAlignment;
/*  61 */     this.charSize_ = argCharSize;
/*  62 */     this.style_ = argStyle;
/*  63 */     this.conditions_ = argConditions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*  70 */     if (!DocBuilderHelper.meetsConditions(argSource, this.conditions_)) {
/*     */       return;
/*     */     }
/*     */     
/*  74 */     Locale locale = getDocumentLocale(argDoc);
/*     */     
/*  76 */     String code = evaluate(this.code_, argSource, argElementFactory, locale);
/*  77 */     if (StringUtils.isEmpty(code)) {
/*  78 */       logger_.debug("empty code::" + this.code_.getSourceDescription());
/*     */       
/*     */       return;
/*     */     } 
/*  82 */     String subcode = evaluate(this.subcode_, argSource, argElementFactory, locale);
/*  83 */     if (StringUtils.isEmpty(subcode)) {
/*  84 */       logger_.debug("empty subcode::" + this.code_.getSourceDescription());
/*     */       
/*     */       return;
/*     */     } 
/*  88 */     Date targetDate = null;
/*     */     try {
/*  90 */       if (this.dateMethod_ != null) {
/*  91 */         targetDate = (Date)DocBuilderHelper.invokeMethodChain(this.dateMethod_, argSource, null, null, 
/*  92 */             getSourceDescription());
/*     */       }
/*     */     }
/*  95 */     catch (Exception ex) {
/*  96 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */     
/*  99 */     String contents = getKeyedText(argSource, code, subcode, targetDate, locale);
/*     */     
/* 101 */     if (contents != null) {
/* 102 */       if (this.fields_ != null && !this.fields_.isEmpty()) {
/* 103 */         Object[] messageParameters = new Object[this.fields_.size()];
/*     */         
/* 105 */         for (int i = 0; i < this.fields_.size(); i++) {
/*     */           try {
/* 107 */             messageParameters[i] = evaluate(this.fields_.get(i), argSource, argElementFactory, locale);
/*     */           }
/* 109 */           catch (Exception ex) {
/* 110 */             logger_.error("CAUGHT EXCEPTION", ex);
/* 111 */             messageParameters[i] = "";
/*     */           } 
/*     */         } 
/* 114 */         contents = MessageFormat.format(contents, messageParameters);
/*     */       } 
/*     */       
/* 117 */       IDocBuilderField.FontInfo fontInfo = this.charSize_.getFieldFontInfo();
/* 118 */       String fieldPreFormatting = fontInfo.getBeginFont() + argElementFactory.getFieldStyleStart(this.style_);
/* 119 */       String fieldPostFormatting = argElementFactory.getFieldStyleEnd(this.style_) + fontInfo.getEndFont();
/*     */ 
/*     */       
/* 122 */       FormattedRegion region = new FormattedRegion(contents, this.leftMargin_, this.rightMargin_, fieldPreFormatting, fieldPostFormatting, this.alignment_, "", this.charSize_.isDoubleWide(), argElementFactory);
/* 123 */       region.setFromTextBlock(true);
/* 124 */       region.setTextCode(code);
/* 125 */       region.setTextSubCode(subcode);
/*     */       
/* 127 */       ITextElement element = argElementFactory.makeTextElement(Collections.singleton(region));
/* 128 */       argDoc.appendElement(element);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/* 136 */     if (this.code_ != null) {
/* 137 */       this.code_.trace("CODE", argTracer);
/*     */     }
/*     */     
/* 140 */     if (this.subcode_ != null) {
/* 141 */       this.subcode_.trace("SUBCODE", argTracer);
/*     */     }
/*     */     
/* 144 */     for (IDocBuilderField element : this.fields_) {
/* 145 */       element.trace("MESSAGEPARAM", argTracer);
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
/*     */ 
/*     */   
/*     */   protected String getKeyedText(Object argSource, String code, String subcode, Date targetDate, Locale argLocale) {
/* 161 */     return DocBuilderFieldFactory.getInstance().getKeyedText(targetDate, code, subcode, argLocale);
/*     */   }
/*     */ 
/*     */   
/*     */   private String evaluate(IDocBuilderField argField, Object argSource, IDocElementFactory argElementFactory, Locale argLocale) {
/* 166 */     FormattedString[] parts = argField.buildField(argSource, argElementFactory, DocBuilderRowCharSize.NORMAL
/* 167 */         .getFieldFontInfo(), argLocale);
/*     */     
/* 169 */     StringBuffer sb = new StringBuffer();
/* 170 */     for (FormattedString part : parts) {
/* 171 */       sb.append(part.getRawText());
/*     */     }
/*     */     
/* 174 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderTextBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */