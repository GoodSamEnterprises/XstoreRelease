/*     */ package dtv.pos.common;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ public class DefaultCodeImpl
/*     */   implements ICodeInterface, IFormattable
/*     */ {
/*     */   private final String code_;
/*     */   private final int sortOrder_;
/*     */   private final IFormattable description_;
/*     */   
/*     */   public DefaultCodeImpl(String argCode, int argSortOrder, IFormattable argDescription) {
/*  26 */     this.code_ = argCode;
/*  27 */     this.sortOrder_ = argSortOrder;
/*  28 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ICodeInterface argOther) {
/*  34 */     return getSortOrder() - argOther.getSortOrder();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCode() {
/*  39 */     return this.code_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  44 */     return this.description_.toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/*  50 */     return this.description_.getLocale();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/*  55 */     return this.sortOrder_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/*  61 */     return this.description_.getSourceDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getUnformattedData() {
/*  67 */     return this.description_.getUnformattedData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormattingOptimizable() {
/*  73 */     return this.description_.isFormattingOptimizable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocale(Locale argLocale) {
/*  79 */     this.description_.setLocale(argLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/*  85 */     this.description_.setSourceDescription(argSourceDescription);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  90 */     return this.description_.toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext) {
/*  96 */     return this.description_.toString(argContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext, Locale argLocale) {
/* 102 */     return this.description_.toString(argContext, argLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext, Locale argLocale, Object argTarget) {
/* 108 */     return this.description_.toString(argContext, argLocale, argTarget);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(OutputContextType argContext, Object argTarget) {
/* 114 */     return this.description_.toString(argContext, argTarget);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\DefaultCodeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */