/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*    */ import dtv.docbuilding.trace.ITracer;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*    */ import dtv.docbuilding.types.DocBuilderRowStyleType;
/*    */ import java.io.IOException;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderRegion
/*    */   extends AbstractDocBuilderSectionMember
/*    */   implements IDocBuilderIteratorMember
/*    */ {
/*    */   private final List<IDocBuilderCondition> conditions_;
/*    */   private final IDocBuilderField field_;
/*    */   private final String leftMargin_;
/*    */   private final String rightMargin_;
/*    */   private final DocBuilderAlignmentType alignment_;
/*    */   private final DocBuilderRowCharSize charSize_;
/*    */   private final DocBuilderRowStyleType style_;
/*    */   
/*    */   public DocBuilderRegion(IDocBuilderField argField, String argLeftMargin, String argRightMargin, DocBuilderAlignmentType argAlignment, DocBuilderRowCharSize argCharSize, DocBuilderRowStyleType argStyle, List<IDocBuilderCondition> argConditions) {
/* 47 */     ensureNonNull(argField, "field cannot be null");
/* 48 */     ensureNonNull(argLeftMargin, "left margin cannot be null");
/* 49 */     ensureNonNull(argRightMargin, "right margin cannot be null");
/* 50 */     ensureNonNull(argAlignment, "alignment cannot be null");
/*    */     
/* 52 */     this.field_ = argField;
/* 53 */     this.leftMargin_ = argLeftMargin;
/* 54 */     this.rightMargin_ = argRightMargin;
/* 55 */     this.alignment_ = argAlignment;
/* 56 */     this.charSize_ = argCharSize;
/* 57 */     this.style_ = argStyle;
/* 58 */     this.conditions_ = argConditions;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/* 65 */     if (!DocBuilderHelper.meetsConditions(argSource, this.conditions_)) {
/*    */       return;
/*    */     }
/* 68 */     Locale locale = getDocumentLocale(argDoc);
/* 69 */     FormattedString[] sa = this.field_.buildField(argSource, argElementFactory, DocBuilderRowCharSize.NORMAL
/* 70 */         .getFieldFontInfo(), locale);
/* 71 */     StringBuffer sb = new StringBuffer();
/* 72 */     for (FormattedString element : sa) {
/* 73 */       sb.append(element.getRawText());
/*    */     }
/*    */     
/* 76 */     if (sb.length() > 0) {
/* 77 */       String fieldPreFormatting = "";
/* 78 */       String fieldPostFormatting = "";
/*    */       
/* 80 */       if (sa.length > 0) {
/* 81 */         fieldPreFormatting = sa[0].getPreFormatting();
/* 82 */         fieldPostFormatting = sa[0].getPostFormatting();
/*    */       } 
/*    */ 
/*    */       
/* 86 */       FormattedRegion region = new FormattedRegion(sb.toString(), this.leftMargin_, this.rightMargin_, fieldPreFormatting, fieldPostFormatting, this.alignment_, argElementFactory.getRowStyle(this.style_), this.charSize_.isDoubleWide(), argElementFactory);
/*    */       
/* 88 */       Set<FormattedRegion> lines = Collections.singleton(region);
/* 89 */       ITextElement element = argElementFactory.makeTextElement((Collection)lines);
/* 90 */       argDoc.appendElement(element);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void trace(ITracer argTracer) {
/* 97 */     this.field_.trace("REGION", argTracer);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */