/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import java.lang.reflect.Constructor;
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
/*     */ public final class FormUtils
/*     */ {
/*     */   public static Collection<Object> createInstance(Collection<?> argValues) {
/*  32 */     Collection<Object> retVal = null;
/*     */     try {
/*  34 */       retVal = (Collection)argValues.getClass().newInstance();
/*     */     }
/*  36 */     catch (Exception ex) {
/*     */       try {
/*  38 */         Constructor<? extends Collection> c = (Constructor)argValues.getClass().getConstructor(new Class[] { argValues.getClass() });
/*  39 */         retVal = c.newInstance(new Object[] { argValues });
/*     */       }
/*  41 */       catch (Exception ex2) {
/*  42 */         retVal = new ArrayList();
/*     */       } 
/*     */     } finally {
/*     */       
/*  46 */       retVal.clear();
/*     */     } 
/*  48 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object unwrapValue(IValueWrapperFactory argWrapperFactory, Object<Object> argValue) {
/*  59 */     Object<Object> actualValue = argValue;
/*     */     
/*  61 */     if (argWrapperFactory != null) {
/*  62 */       if (argValue instanceof Collection) {
/*  63 */         Collection<?> origValues = (Collection)argValue;
/*  64 */         Collection<Object> unwrappedValues = createInstance(origValues);
/*  65 */         for (Object value : origValues) {
/*  66 */           if (value instanceof IEnumValueWrapper) {
/*  67 */             value = ((IEnumValueWrapper)value).getActualValue();
/*     */           }
/*  69 */           unwrappedValues.add(value);
/*     */         } 
/*  71 */         actualValue = (Object<Object>)unwrappedValues;
/*     */       }
/*  73 */       else if (argValue instanceof IEnumValueWrapper) {
/*  74 */         actualValue = (Object<Object>)((IEnumValueWrapper)argValue).getActualValue();
/*     */       } 
/*     */     }
/*  77 */     return actualValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object wrapValue(IValueWrapperFactory argWrapperFactory, Object<Object> argValue) {
/*  88 */     Object<Object> wrappedValue = argValue;
/*     */     
/*  90 */     if (argWrapperFactory != null) {
/*  91 */       if (argValue instanceof Collection) {
/*  92 */         Collection<?> origValues = (Collection)argValue;
/*  93 */         Collection<Object> wrappedValues = createInstance(origValues);
/*  94 */         for (Object value : origValues) {
/*  95 */           if (!(value instanceof IEnumValueWrapper)) {
/*  96 */             value = argWrapperFactory.wrapValue(value);
/*     */           }
/*  98 */           wrappedValues.add(value);
/*     */         } 
/* 100 */         wrappedValue = (Object<Object>)wrappedValues;
/*     */       }
/* 102 */       else if (!(argValue instanceof IEnumValueWrapper)) {
/* 103 */         wrappedValue = (Object<Object>)argWrapperFactory.wrapValue(argValue);
/*     */       } 
/*     */     }
/* 106 */     return wrappedValue;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\FormUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */