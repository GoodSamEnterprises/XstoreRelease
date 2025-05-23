/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.util.StringUtils;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class CodeTranslationWrapper
/*    */   implements IEnumValueWrapper
/*    */ {
/* 23 */   private static final Logger logger_ = Logger.getLogger(CodeTranslationWrapper.class);
/*    */   
/*    */   private final IFormattable formattable_;
/*    */   private final String value_;
/*    */   
/*    */   public CodeTranslationWrapper(String argCode, IFormattable argFormattable) {
/* 29 */     this.value_ = argCode;
/* 30 */     if (argFormattable == null) {
/* 31 */       logger_.warn("null formatter... using EMPTY instead");
/* 32 */       this.formattable_ = IFormattable.EMPTY;
/*    */     } else {
/*    */       
/* 35 */       this.formattable_ = argFormattable;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 41 */     if (argOther == this) {
/* 42 */       return true;
/*    */     }
/* 44 */     if (argOther == null) {
/* 45 */       return StringUtils.isEmpty(this.value_);
/*    */     }
/* 47 */     if (!(argOther instanceof CodeTranslationWrapper)) {
/* 48 */       return false;
/*    */     }
/* 50 */     CodeTranslationWrapper other = (CodeTranslationWrapper)argOther;
/* 51 */     if (StringUtils.isEmpty(this.value_)) {
/* 52 */       return StringUtils.isEmpty(other.value_);
/*    */     }
/* 54 */     return ObjectUtils.equivalent(this.value_, other.value_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getActualValue() {
/* 59 */     return this.value_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 64 */     if (this.value_ == null) {
/* 65 */       return 0;
/*    */     }
/*    */     
/* 68 */     return this.value_.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setActualValue(Object newValue) {
/* 74 */     logger_.warn("cannot set value of this one");
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return this.formattable_.toString(OutputContextType.VIEW);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeTranslationWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */