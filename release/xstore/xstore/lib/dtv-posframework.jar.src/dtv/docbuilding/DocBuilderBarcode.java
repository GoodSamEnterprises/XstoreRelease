/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import dtv.barcode.BarcodeTextType;
/*    */ import dtv.barcode.BarcodeType;
/*    */ import dtv.docbuilding.trace.ITracer;
/*    */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*    */ import dtv.docbuilding.types.DocBuilderRowCharSize;
/*    */ import dtv.pos.iframework.hardware.AlignmentType;
/*    */ import dtv.pos.iframework.hardware.Barcode;
/*    */ import dtv.pos.iframework.hardware.IBarcode;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderBarcode
/*    */   extends AbstractDocBuilderSectionMember
/*    */ {
/*    */   private final BarcodeType symbology_;
/*    */   private final BarcodeTextType textPosition_;
/*    */   private final int width_;
/*    */   private final int height_;
/*    */   private final IDocBuilderField fieldBuilder_;
/*    */   private final String prefix_;
/*    */   
/*    */   public DocBuilderBarcode(BarcodeType argType, IDocBuilderField argFieldBuilder, BarcodeTextType argTextPosition, int argWidth, int argHeight, String argPrefix) {
/* 44 */     this.symbology_ = argType;
/* 45 */     this.fieldBuilder_ = argFieldBuilder;
/* 46 */     this.textPosition_ = argTextPosition;
/* 47 */     this.width_ = argWidth;
/* 48 */     this.height_ = argHeight;
/* 49 */     this.prefix_ = argPrefix;
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
/*    */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*    */     AlignmentType barcodeAlignent;
/* 64 */     Locale locale = getDocumentLocale(argDoc);
/*    */     
/* 66 */     FormattedString[] s = this.fieldBuilder_.buildField(argSource, argElementFactory, DocBuilderRowCharSize.NORMAL
/* 67 */         .getFieldFontInfo(), locale);
/* 68 */     StringBuffer sb = new StringBuffer();
/* 69 */     for (FormattedString element : s) {
/* 70 */       sb.append(element);
/*    */     }
/*    */     
/* 73 */     Barcode bc = new Barcode(sb.toString(), this.symbology_, null);
/*    */ 
/*    */     
/* 76 */     DocBuilderAlignmentType fieldAlignment = this.fieldBuilder_.getAlignment();
/*    */     
/* 78 */     if (DocBuilderAlignmentType.LEFT.equals(fieldAlignment)) {
/* 79 */       barcodeAlignent = AlignmentType.LEFT;
/*    */     }
/* 81 */     else if (DocBuilderAlignmentType.RIGHT.equals(fieldAlignment)) {
/* 82 */       barcodeAlignent = AlignmentType.RIGHT;
/*    */     } else {
/*    */       
/* 85 */       barcodeAlignent = AlignmentType.CENTER;
/*    */     } 
/*    */     
/* 88 */     argDoc.appendElement(argElementFactory
/* 89 */         .makeBarcodeElement((IBarcode)bc, barcodeAlignent, this.textPosition_, this.width_, this.height_, this.prefix_));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void trace(ITracer argTracer) {
/* 95 */     this.fieldBuilder_.trace("BARCODE", argTracer);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderBarcode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */