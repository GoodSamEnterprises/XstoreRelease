/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*    */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*    */ import dtv.util.ObjectUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ public class ValueWrapperFactory
/*    */   implements IValueWrapperFactory
/*    */ {
/* 25 */   private static final Logger logger_ = Logger.getLogger(ValueWrapperFactory.class);
/*    */   
/* 27 */   private static Map<Class<? extends IEnumValueWrapper>, IValueWrapperFactory> factoryCache_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final Class<? extends IEnumValueWrapper> wrapperClass_;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IValueWrapperFactory makeWrapperFactory(Class<? extends IEnumValueWrapper> argWrapperClass) {
/* 40 */     if (argWrapperClass == null) {
/* 41 */       throw new NullPointerException();
/*    */     }
/* 43 */     IValueWrapperFactory f = getCached(argWrapperClass);
/* 44 */     if (f == null) {
/* 45 */       if (!ObjectUtils.isImplementing(argWrapperClass, IEnumValueWrapper.class)) {
/* 46 */         throw new IllegalArgumentException(argWrapperClass.getClass().getName() + " does not implement " + IEnumValueWrapper.class
/* 47 */             .getName());
/*    */       }
/* 49 */       f = new ValueWrapperFactory(argWrapperClass);
/* 50 */       cache(argWrapperClass, f);
/*    */     } 
/* 52 */     return f;
/*    */   }
/*    */ 
/*    */   
/*    */   protected static final IValueWrapperFactory cache(Class<? extends IEnumValueWrapper> argWrapperClass, IValueWrapperFactory argWrapperFactory) {
/* 57 */     return factoryCache_.put(argWrapperClass, argWrapperFactory);
/*    */   }
/*    */   
/*    */   protected static final IValueWrapperFactory getCached(Class<? extends IEnumValueWrapper> argWrapperClass) {
/* 61 */     return factoryCache_.get(argWrapperClass);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ValueWrapperFactory(Class<? extends IEnumValueWrapper> argWrapperClass) {
/* 67 */     this.wrapperClass_ = argWrapperClass;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object wrapValue(Object actualValue) {
/* 72 */     if (this.wrapperClass_.isInstance(actualValue)) {
/* 73 */       return actualValue;
/*    */     }
/*    */     try {
/* 76 */       IEnumValueWrapper wrapper = this.wrapperClass_.newInstance();
/* 77 */       wrapper.setActualValue(actualValue);
/* 78 */       return wrapper;
/*    */     }
/* 80 */     catch (Exception ex) {
/* 81 */       logger_.error("CAUGHT EXCEPTION... using unwrapped value", ex);
/* 82 */       return actualValue;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\ValueWrapperFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */