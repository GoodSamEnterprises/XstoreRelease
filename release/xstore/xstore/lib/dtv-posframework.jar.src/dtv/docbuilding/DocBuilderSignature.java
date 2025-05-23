/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import dtv.docbuilding.trace.ITracer;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*    */ import dtv.pos.iframework.hardware.AlignmentType;
/*    */ import java.io.IOException;
/*    */ import java.util.Locale;
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
/*    */ public class DocBuilderSignature
/*    */   extends AbstractDocBuilderSectionMember
/*    */ {
/*    */   private final IDocBuilderField field_;
/*    */   
/*    */   public DocBuilderSignature(IDocBuilderField argField) {
/* 31 */     this.field_ = argField;
/*    */   }
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
/*    */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/* 48 */     Locale locale = getDocumentLocale(argDoc);
/*    */     
/* 50 */     FormattedString[] s = this.field_.buildField(argSource, argElementFactory, DocBuilderRowCharSize.NORMAL
/* 51 */         .getFieldFontInfo(), locale);
/* 52 */     StringBuffer sb = new StringBuffer();
/* 53 */     for (FormattedString element : s) {
/* 54 */       sb.append(element);
/*    */     }
/* 56 */     if (sb.length() != 0) {
/*    */       AlignmentType signatureAlignent;
/* 58 */       DocBuilderAlignmentType fieldAlignment = this.field_.getAlignment();
/*    */       
/* 60 */       if (DocBuilderAlignmentType.LEFT.equals(fieldAlignment)) {
/* 61 */         signatureAlignent = AlignmentType.LEFT;
/*    */       }
/* 63 */       else if (DocBuilderAlignmentType.RIGHT.equals(fieldAlignment)) {
/* 64 */         signatureAlignent = AlignmentType.RIGHT;
/*    */       } else {
/*    */         
/* 67 */         signatureAlignent = AlignmentType.CENTER;
/*    */       } 
/* 69 */       if (sb.toString().trim().length() > 0) {
/*    */         
/* 71 */         ISignatureElement sig = argElementFactory.makeSignatureElement(sb.toString(), signatureAlignent);
/* 72 */         argDoc.appendElement(sig);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void trace(ITracer argTracer) {
/* 80 */     String node = argTracer.startNode("SIGNATURE", hashCode());
/* 81 */     this.field_.trace("SIGNATURE", argTracer);
/* 82 */     argTracer.endNode(node);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderSignature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */