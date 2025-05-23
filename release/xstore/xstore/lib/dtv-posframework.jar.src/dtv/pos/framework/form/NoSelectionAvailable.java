/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.util.ICodeInterface;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NoSelectionAvailable
/*     */   implements ICodeInterface, IFormattable
/*     */ {
/*  20 */   private final IFormattable value_ = FormattableFactory.getInstance().getTranslatable("_listSelectionNone");
/*     */ 
/*     */   
/*     */   private String sourceDescription_;
/*     */ 
/*     */   
/*     */   public int compareTo(ICodeInterface argOther) {
/*  27 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCode() {
/*  32 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  37 */     return toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/*  42 */     return this.value_.getLocale();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/*  47 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/*  52 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getUnformattedData() {
/*  57 */     return this.value_.getUnformattedData();
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
/*     */   public boolean isFormattingOptimizable() {
/*  72 */     return this.value_.isFormattingOptimizable();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocale(Locale argLocale) {
/*  77 */     this.value_.setLocale(argLocale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/*  82 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType outputContextType) {
/*  87 */     return this.value_.toString(outputContextType);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext, Locale argLocale) {
/*  92 */     return this.value_.toString(argContext, argLocale);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext, Locale argLocale, Object argTarget) {
/*  97 */     return this.value_.toString(argContext, argLocale, argTarget);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType outputContextType, Object object) {
/* 102 */     return this.value_.toString(outputContextType, object);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\NoSelectionAvailable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */