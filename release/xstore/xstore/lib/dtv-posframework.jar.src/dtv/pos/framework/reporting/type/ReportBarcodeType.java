/*     */ package dtv.pos.framework.reporting.type;
/*     */ 
/*     */ import dtv.barcode.BarcodeTextType;
/*     */ import dtv.barcode.BarcodeType;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ public class ReportBarcodeType
/*     */ {
/*  22 */   private static final Logger logger_ = Logger.getLogger(ReportBarcodeType.class);
/*     */ 
/*     */   
/*  25 */   public static final ReportBarcodeType CODE93 = new ReportBarcodeType("Code93", BarcodeType.CODE93, BarcodeTextType.NONE);
/*     */   
/*  27 */   public static final ReportBarcodeType CODE93BELOW = new ReportBarcodeType("Code93Below", BarcodeType.CODE93, BarcodeTextType.BELOW);
/*     */   
/*  29 */   public static final ReportBarcodeType CODE128 = new ReportBarcodeType("Code128", BarcodeType.CODE128, BarcodeTextType.NONE);
/*     */   
/*  31 */   public static final ReportBarcodeType CODE128BELOW = new ReportBarcodeType("Code128Below", BarcodeType.CODE128, BarcodeTextType.BELOW);
/*     */ 
/*     */   
/*  34 */   public static final ReportBarcodeType CODEQR = new ReportBarcodeType("CodeQR", BarcodeType.QR_CODE, BarcodeTextType.NONE);
/*     */ 
/*     */   
/*  37 */   public static final ReportBarcodeType EAN13 = new ReportBarcodeType("Ean13", BarcodeType.EAN13, BarcodeTextType.NONE);
/*     */   
/*  39 */   public static final ReportBarcodeType EAN13BELOW = new ReportBarcodeType("Ean13Below", BarcodeType.EAN13, BarcodeTextType.BELOW);
/*     */ 
/*     */   
/*     */   private static Map<String, ReportBarcodeType> values_;
/*     */ 
/*     */   
/*     */   private String _name;
/*     */ 
/*     */   
/*     */   private BarcodeType _barcodeType;
/*     */   
/*     */   private BarcodeTextType _barcodeTextType;
/*     */ 
/*     */   
/*     */   public static ReportBarcodeType forName(String argName) {
/*  54 */     if (argName == null) {
/*  55 */       return null;
/*     */     }
/*  57 */     ReportBarcodeType found = values_.get(argName.trim().toUpperCase());
/*  58 */     if (found == null) {
/*  59 */       logger_.warn("There is no instance of [" + ReportBarcodeType.class
/*  60 */           .getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  63 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ReportBarcodeType(String argName, BarcodeType argBarcodeType, BarcodeTextType argBarcodeTextType) {
/*  71 */     this._name = argName;
/*  72 */     this._barcodeType = argBarcodeType;
/*  73 */     this._barcodeTextType = argBarcodeTextType;
/*     */     
/*  75 */     if (values_ == null) {
/*  76 */       values_ = new HashMap<>();
/*     */     }
/*  78 */     values_.put(this._name.toUpperCase(), this);
/*     */   }
/*     */   
/*     */   public BarcodeTextType getBarcodeTextType() {
/*  82 */     return this._barcodeTextType;
/*     */   }
/*     */   
/*     */   public BarcodeType getBarcodeType() {
/*  86 */     return this._barcodeType;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  90 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     return "ReportBarcodeType[" + this._name + "]";
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\type\ReportBarcodeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */