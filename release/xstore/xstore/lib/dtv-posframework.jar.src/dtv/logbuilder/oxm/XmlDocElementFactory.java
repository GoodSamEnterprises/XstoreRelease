/*     */ package dtv.logbuilder.oxm;
/*     */ 
/*     */ import dtv.barcode.BarcodeTextType;
/*     */ import dtv.docbuilding.DocSectionParamMap;
/*     */ import dtv.docbuilding.IBarcodeElement;
/*     */ import dtv.docbuilding.IDocElement;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.IPictureElement;
/*     */ import dtv.docbuilding.ISignatureElement;
/*     */ import dtv.docbuilding.ITextElement;
/*     */ import dtv.docbuilding.types.DocBuilderRowStyleType;
/*     */ import dtv.pos.iframework.hardware.AlignmentType;
/*     */ import dtv.pos.iframework.hardware.IBarcode;
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
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
/*     */ public class XmlDocElementFactory
/*     */   implements IDocElementFactory
/*     */ {
/*  30 */   public static final String SYSTEM_PROPERTY = XmlDocElementFactory.class.getName();
/*     */   
/*  32 */   private static final Logger logger_ = Logger.getLogger(XmlDocElementFactory.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static IDocElementFactory INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IDocElementFactory getInstance() {
/*  42 */     if (INSTANCE == null) {
/*     */       
/*  44 */       String className = System.getProperty(SYSTEM_PROPERTY);
/*     */       try {
/*  46 */         INSTANCE = (IDocElementFactory)Class.forName(className).newInstance();
/*     */       }
/*  48 */       catch (Exception ex) {
/*  49 */         INSTANCE = new XmlDocElementFactory();
/*     */       } 
/*     */     } 
/*  52 */     return INSTANCE;
/*     */   }
/*     */   
/*  55 */   private final DocSectionParamMap parameters_ = new DocSectionParamMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldStyleEnd(String style) {
/*  65 */     if (style != null && style.length() > 0) {
/*  66 */       logger_.warn("Field styles are not supported in a TLOG.");
/*     */     }
/*  68 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldStyleStart(String style) {
/*  79 */     if (style != null && style.length() > 0) {
/*  80 */       logger_.warn("Field styles are not supported in a TLOG.");
/*     */     }
/*  82 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHorizontalRuleText(String argAlignment, int argPercentWidth, String argStyle) {
/*  92 */     throw new UnsupportedOperationException("Horizontal rules are not supported by this element factory.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocElement[] getPageBreakElements() {
/* 102 */     throw new UnsupportedOperationException("Page breaks are not supported by this element factory.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DocSectionParamMap getParameterMap() {
/* 108 */     return this.parameters_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRowStyle(DocBuilderRowStyleType style) {
/* 119 */     if (style != null) {
/* 120 */       logger_.warn("Row styles are not supported in a TLOG.");
/*     */     }
/* 122 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 128 */     return Boolean.getBoolean(getClass().getName() + ".trace");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IBarcodeElement makeBarcodeElement(IBarcode argBarcode, AlignmentType argAlignment, BarcodeTextType argTextPosition, int argWidth, int argHeight, String argPrefix) {
/* 139 */     throw new UnsupportedOperationException("Barcodes are not supported by this element factory.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocElement makeHorizontalRuleElement(String argAlignment, int argPercentWidth, String argStyle) {
/* 149 */     throw new UnsupportedOperationException("Horizontal rules are not supported by this element factory.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPictureElement makePictureElement(File argSource, boolean argPreload) {
/* 159 */     throw new UnsupportedOperationException("Pictures are not supported by this element factory.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISignatureElement makeSignatureElement(String argContent, AlignmentType argAlignment) {
/* 169 */     throw new UnsupportedOperationException("Signature are not supported by this element factory.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextElement makeTextElement(Collection<? extends Object> argLines) {
/* 180 */     return new XmlTextElement(argLines);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextElement makeTraceElement(String argLine) {
/* 186 */     return makeTextElement(Arrays.asList((Object[])new String[] { "<!-- ", argLine, " -->" }));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\oxm\XmlDocElementFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */