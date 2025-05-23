/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*    */ import dtv.util.ObjectUtils;
/*    */ import java.util.Locale;
/*    */ import org.apache.commons.lang3.LocaleUtils;
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
/*    */ public class LocaleStringWrapper
/*    */   implements IEnumValueWrapper
/*    */ {
/*    */   private Locale locale_;
/*    */   
/*    */   public boolean equals(Object argOther) {
/* 31 */     if (argOther == this) {
/* 32 */       return true;
/*    */     }
/* 34 */     if (!(argOther instanceof LocaleStringWrapper)) {
/* 35 */       return false;
/*    */     }
/* 37 */     LocaleStringWrapper other = (LocaleStringWrapper)argOther;
/*    */     
/* 39 */     return ObjectUtils.equivalent(other.locale_, this.locale_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getActualValue() {
/* 44 */     return (this.locale_ == null) ? null : this.locale_.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 49 */     return (this.locale_ == null) ? 0 : this.locale_.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setActualValue(Object newValue) {
/* 54 */     if (newValue instanceof String) {
/* 55 */       this.locale_ = LocaleUtils.toLocale((String)newValue);
/*    */     }
/* 57 */     else if (newValue instanceof Locale) {
/* 58 */       this.locale_ = (Locale)newValue;
/*    */     }
/* 60 */     else if (newValue == null) {
/* 61 */       this.locale_ = null;
/*    */     } else {
/*    */       
/* 64 */       throw new IllegalArgumentException("" + newValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     if (this.locale_ == null) {
/* 71 */       return "";
/*    */     }
/*    */     
/* 74 */     return this.locale_.getDisplayName(LocaleManager.getInstance().getLocale(OutputContextType.VIEW));
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\LocaleStringWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */