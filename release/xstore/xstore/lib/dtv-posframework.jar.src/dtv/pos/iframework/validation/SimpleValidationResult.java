/*     */ package dtv.pos.iframework.validation;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class SimpleValidationResult
/*     */   implements IValidationResult
/*     */ {
/*     */   private final boolean isValid_;
/*     */   private final IFormattable message_;
/*     */   
/*     */   public static IValidationResult getFailed() {
/*  26 */     return getFailed(FormattableFactory.getInstance().getTranslatable("_validationFailed"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IValidationResult getFailed(IFormattable argMessage) {
/*  35 */     return new SimpleValidationResult(argMessage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IValidationResult getFailed(String argTranslationKey) {
/*  45 */     FormattableFactory ff = FormattableFactory.getInstance();
/*  46 */     return getFailed(ff.getTranslatable(argTranslationKey));
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
/*     */   public static IValidationResult getFailed(String argTranslationKey, Object... argParams) {
/*  59 */     if (argParams == null || argParams.length == 0) {
/*  60 */       return getFailed(argTranslationKey);
/*     */     }
/*  62 */     FormattableFactory ff = FormattableFactory.getInstance();
/*  63 */     Collection<IFormattable> formattedParams = new ArrayList<>(argParams.length);
/*     */     
/*  65 */     for (Object param : argParams) {
/*  66 */       formattedParams.add(ff.getLiteral(param));
/*     */     }
/*  68 */     return getFailed(ff.getTranslatable(argTranslationKey, formattedParams.<IFormattable>toArray(new IFormattable[0])));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IValidationResult getFailedNull() {
/*  77 */     return getFailed(FormattableFactory.getInstance().getTranslatable("_validationFailedNull"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IValidationResult getPassed() {
/*  86 */     return IValidationResult.SUCCESS;
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
/*     */   protected SimpleValidationResult(IFormattable argMesage) {
/* 100 */     this.isValid_ = false;
/* 101 */     this.message_ = argMesage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SimpleValidationResult() {
/* 108 */     this.isValid_ = true;
/* 109 */     this.message_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getMessage() {
/* 115 */     return this.message_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrivilege() {
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecured() {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 133 */     return this.isValid_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     return "SimpleValidationResult[valid=" + this.isValid_ + ", message=" + getMessageDescription() + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getMessageDescription() {
/*     */     try {
/* 149 */       return (this.message_ == null) ? null : this.message_.toString(OutputContextType.LOG);
/*     */     }
/* 151 */     catch (Exception ex) {
/*     */       try {
/* 153 */         return this.message_.toString(OutputContextType.VIEW);
/*     */       }
/* 155 */       catch (Exception ex1) {
/* 156 */         return this.message_.getUnformattedData() + "";
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\SimpleValidationResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */