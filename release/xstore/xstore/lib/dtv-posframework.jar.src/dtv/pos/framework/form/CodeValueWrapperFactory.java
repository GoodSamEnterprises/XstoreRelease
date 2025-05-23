/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.xst.dao.com.ICodeValue;
/*    */ import java.util.Map;
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
/*    */ public class CodeValueWrapperFactory
/*    */   extends ValueWrapperFactory
/*    */ {
/*    */   private Map<String, ICodeValue> codes_;
/*    */   
/*    */   public static IValueWrapperFactory makeWrapperFactory(Class<? extends IEnumValueWrapper> argWrapperClass) {
/* 24 */     if (argWrapperClass == null) {
/* 25 */       throw new NullPointerException();
/*    */     }
/* 27 */     IValueWrapperFactory f = getCached(argWrapperClass);
/* 28 */     if (f == null) {
/* 29 */       if (!ObjectUtils.isImplementing(argWrapperClass, IEnumValueWrapper.class)) {
/* 30 */         throw new IllegalArgumentException(argWrapperClass.getClass().getName() + " does not implement " + IEnumValueWrapper.class
/* 31 */             .getName());
/*    */       }
/* 33 */       f = new CodeValueWrapperFactory(argWrapperClass);
/* 34 */       cache(argWrapperClass, f);
/*    */     } 
/* 36 */     return f;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected CodeValueWrapperFactory(Class<? extends IEnumValueWrapper> argWrapperClass) {
/* 42 */     super(argWrapperClass);
/*    */   }
/*    */   
/*    */   public void setCodes(Map<String, ICodeValue> argCodes) {
/* 46 */     this.codes_ = argCodes;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object wrapValue(Object argObject) {
/* 51 */     if (argObject instanceof String && this.codes_ != null) {
/* 52 */       return super.wrapValue(this.codes_.get(argObject));
/*    */     }
/*    */     
/* 55 */     return super.wrapValue(argObject);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\CodeValueWrapperFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */