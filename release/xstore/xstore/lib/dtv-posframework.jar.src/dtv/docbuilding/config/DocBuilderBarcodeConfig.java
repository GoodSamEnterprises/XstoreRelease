/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.barcode.BarcodeTextType;
/*     */ import dtv.barcode.BarcodeType;
/*     */ import dtv.docbuilding.DocBuilderBarcode;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderBarcodeConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private BarcodeType symbology_;
/*     */   private DocBuilderFieldConfig field_;
/*     */   private BarcodeTextType textPosition_;
/*     */   private int width_;
/*     */   private int height_;
/*     */   private String prefix_;
/*     */   
/*     */   public BarcodeType getBarcodeType() {
/*  31 */     return this.symbology_;
/*     */   }
/*     */   
/*     */   public DocBuilderFieldConfig getField() {
/*  35 */     return this.field_;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*  39 */     return this.height_;
/*     */   }
/*     */   
/*     */   public String getPrefix() {
/*  43 */     return this.prefix_;
/*     */   }
/*     */   
/*     */   public BarcodeTextType getTextPosition() {
/*  47 */     return this.textPosition_;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*  51 */     return this.width_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderBarcode makeBarcode(FormatterMapConfig argFormatterMap) {
/*  61 */     DocBuilderBarcode barcode = new DocBuilderBarcode(getSymbology(), getField().makeField(argFormatterMap), this.textPosition_, this.width_, this.height_, this.prefix_);
/*     */     
/*  63 */     barcode.setSourceDescription(getSourceDescription());
/*  64 */     return barcode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  71 */     if ("symbology".equalsIgnoreCase(argKey)) {
/*  72 */       this.symbology_ = BarcodeType.forName(argValue.toString());
/*     */     }
/*  74 */     else if (argValue instanceof DocBuilderFieldConfig) {
/*  75 */       this.field_ = (DocBuilderFieldConfig)argValue;
/*     */     }
/*  77 */     else if ("textposition".equalsIgnoreCase(argKey)) {
/*  78 */       this.textPosition_ = BarcodeTextType.forName(argValue.toString());
/*     */     }
/*  80 */     else if ("width".equalsIgnoreCase(argKey)) {
/*  81 */       this.width_ = ConfigUtils.toInt(argValue);
/*     */     }
/*  83 */     else if ("height".equalsIgnoreCase(argKey)) {
/*  84 */       this.height_ = ConfigUtils.toInt(argValue);
/*     */     }
/*  86 */     else if ("prefix".equalsIgnoreCase(argKey)) {
/*  87 */       this.prefix_ = argValue.toString();
/*     */     }
/*     */     else {
/*     */       
/*  91 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setField(DocBuilderFieldConfig argField) {
/*  96 */     this.field_ = argField;
/*     */   }
/*     */   
/*     */   public void setHeight(int argHeight) {
/* 100 */     this.height_ = argHeight;
/*     */   }
/*     */   
/*     */   public void setPrefix(String argPrefix) {
/* 104 */     this.prefix_ = argPrefix;
/*     */   }
/*     */   
/*     */   public void setSymbology(BarcodeType argSymbology) {
/* 108 */     this.symbology_ = argSymbology;
/*     */   }
/*     */   
/*     */   public void setTextPosition(BarcodeTextType argTextPosition) {
/* 112 */     this.textPosition_ = argTextPosition;
/*     */   }
/*     */   
/*     */   public void setWidth(int argWidth) {
/* 116 */     this.width_ = argWidth;
/*     */   }
/*     */   
/*     */   private BarcodeType getSymbology() {
/* 120 */     return this.symbology_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderBarcodeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */