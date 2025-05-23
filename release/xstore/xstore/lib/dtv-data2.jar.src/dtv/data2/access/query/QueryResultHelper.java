/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import com.google.common.primitives.Primitives;
/*     */ import dtv.data2.access.IGenericQueryResult;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Method;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.util.ClassUtils;
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
/*     */ public class QueryResultHelper
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(QueryResultHelper.class);
/*     */   
/*  32 */   private final ConcurrentHashMap<Class<?>, DataMapping> classMappings_ = new ConcurrentHashMap<>(16, 1.0F, 
/*  33 */       Runtime.getRuntime().availableProcessors());
/*  34 */   private final String PUT_METHOD = "put";
/*  35 */   private final String SETTER_PREFIX = "set";
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static final QueryResultHelper INSTANCE = new QueryResultHelper();
/*     */ 
/*     */   
/*     */   public static QueryResultHelper getInstance() {
/*  43 */     return INSTANCE;
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
/*     */   protected Method findCompatibleMethodForType(Class<?> argClass, String argMethodName, Class<?> argTypeClass) {
/*  57 */     for (Class<?> searchClass = argClass; searchClass != null; searchClass = searchClass.getSuperclass()) {
/*  58 */       for (Method method : searchClass.getDeclaredMethods()) {
/*  59 */         if (method.getName().equals(argMethodName) && (method.getParameterTypes()).length == 1 && (
/*  60 */           ClassUtils.isAssignable(method.getParameterTypes()[0], argTypeClass) || (method
/*  61 */           .getParameterTypes()[0].isArray() && argTypeClass.isArray() && 
/*  62 */           ClassUtils.isAssignable(method.getParameterTypes()[0].getComponentType(), argTypeClass
/*  63 */             .getComponentType())))) {
/*  64 */           return method;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  70 */     return null;
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
/*     */   protected Method findMethodAssignableToType(Class<?> argClass, String argMethodName, Class<?> argType) {
/*  82 */     for (Class<?> searchClass = argClass; searchClass != null; searchClass = searchClass.getSuperclass()) {
/*  83 */       for (Method method : searchClass.getDeclaredMethods()) {
/*  84 */         if (method.getName().equals(argMethodName) && (method.getParameterTypes()).length == 1 && 
/*  85 */           ClassUtils.isAssignable(argType, method.getParameterTypes()[0])) {
/*  86 */           return method;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DataMapping getMapping(Class<?> argResultClass) {
/* 100 */     DataMapping mapping = this.classMappings_.get(argResultClass);
/* 101 */     if (mapping == null) {
/* 102 */       DataMapping newMapping = new DataMapping(argResultClass);
/* 103 */       DataMapping existingMapping = this.classMappings_.putIfAbsent(argResultClass, newMapping);
/* 104 */       mapping = (existingMapping != null) ? existingMapping : newMapping;
/*     */     } 
/* 106 */     return mapping;
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
/*     */   protected Method getMethodForClass(Class<?> argResultClass, String argFieldName, Object argMethodParameter) {
/* 118 */     String methodName = "set" + argFieldName;
/* 119 */     Object methodParameter = argMethodParameter;
/* 120 */     Class<?> methodParameterClass = methodParameter.getClass();
/*     */ 
/*     */     
/* 123 */     Method modelMethod = getMethodForNameAndType(argResultClass, methodName, new Class[] { methodParameterClass });
/*     */ 
/*     */     
/* 126 */     if (modelMethod == null && methodParameter instanceof dtv.util.DtvDate) {
/* 127 */       modelMethod = getMethodForNameAndType(argResultClass, methodName, new Class[] { Date.class });
/*     */     }
/*     */ 
/*     */     
/* 131 */     if (modelMethod == null && Primitives.isWrapperType(methodParameterClass))
/*     */     {
/* 133 */       modelMethod = getMethodForNameAndType(argResultClass, methodName, new Class[] { Primitives.unwrap(methodParameterClass) });
/*     */     }
/*     */ 
/*     */     
/* 137 */     if (modelMethod == null && methodParameter instanceof Number && !(methodParameter instanceof BigDecimal)) {
/* 138 */       modelMethod = getMethodForNameAndType(argResultClass, methodName, new Class[] { BigDecimal.class });
/*     */     }
/*     */ 
/*     */     
/* 142 */     if (modelMethod == null && ClassUtils.isPrimitiveWrapperArray(methodParameterClass))
/*     */     {
/* 144 */       modelMethod = getMethodForNameAndType(argResultClass, methodName, new Class[] {
/* 145 */             Array.newInstance(Primitives.unwrap(methodParameterClass.getComponentType()), 0).getClass()
/*     */           });
/*     */     }
/*     */     
/* 149 */     if (modelMethod == null && ClassUtils.isPrimitiveArray(methodParameterClass))
/*     */     {
/* 151 */       modelMethod = getMethodForNameAndType(argResultClass, methodName, new Class[] {
/* 152 */             Array.newInstance(Primitives.wrap(methodParameterClass.getComponentType()), 0).getClass()
/*     */           });
/*     */     }
/*     */ 
/*     */     
/* 157 */     if (modelMethod == null) {
/* 158 */       modelMethod = findCompatibleMethodForType(argResultClass, methodName, methodParameterClass);
/*     */     }
/*     */ 
/*     */     
/* 162 */     if (modelMethod == null && methodParameter instanceof Number) {
/* 163 */       modelMethod = findMethodAssignableToType(argResultClass, methodName, Number.class);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (modelMethod == null && methodParameter instanceof Number) {
/* 169 */       modelMethod = findMethodAssignableToType(argResultClass, methodName, Boolean.class);
/*     */     }
/*     */ 
/*     */     
/* 173 */     if (modelMethod == null && (IGenericQueryResult.class
/* 174 */       .isAssignableFrom(argResultClass) || Map.class
/* 175 */       .isAssignableFrom(argResultClass)))
/*     */     {
/* 177 */       modelMethod = getMethodForNameAndType(argResultClass, "put", new Class[] { Object.class, Object.class });
/*     */     }
/*     */ 
/*     */     
/* 181 */     if (logger_.isDebugEnabled() && modelMethod != null) {
/* 182 */       logger_
/* 183 */         .debug("Associated method [" + modelMethod.toString() + "] with query criteria [ResultObject: " + argResultClass + " QueryFieldName: " + argFieldName + " ValueObject: " + argMethodParameter + "]");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     if (modelMethod == null) {
/* 190 */       throw new DtxException("Could not find a method on " + argResultClass.getName() + "meeting query criteria [ResultObject: " + argResultClass + " QueryFieldName: " + argFieldName + " ValueObject: " + argMethodParameter + "]");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 195 */     return modelMethod;
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
/*     */   protected Method getMethodForNameAndType(Class<?> argClass, String argMethodName, Class<?>... argMethodParameter) {
/* 208 */     for (Class<?> searchClass = argClass; searchClass != null; searchClass = searchClass.getSuperclass()) {
/*     */       try {
/* 210 */         return searchClass.getDeclaredMethod(argMethodName, argMethodParameter);
/*     */       }
/* 212 */       catch (NoSuchMethodException e) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 217 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class DataMapping
/*     */   {
/*     */     private final Class<?> modelClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     private final ConcurrentHashMap<String, Method> fieldMappings = new ConcurrentHashMap<>(8, 1.0F, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DataMapping(Class<?> argResultClass) {
/* 241 */       this.modelClass = argResultClass;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Method getExistingSetterForField(String argFieldName) {
/* 250 */       return this.fieldMappings.get(argFieldName);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Method getSetterForField(String argFieldName, Object argParameter) {
/* 261 */       Method mappingMethod = getExistingSetterForField(argFieldName);
/* 262 */       if (mappingMethod == null) {
/* 263 */         Method newMethod = QueryResultHelper.INSTANCE.getMethodForClass(this.modelClass, argFieldName, argParameter);
/* 264 */         Method existingMethod = this.fieldMappings.putIfAbsent(argFieldName, newMethod);
/* 265 */         mappingMethod = (existingMethod != null) ? existingMethod : newMethod;
/*     */       } 
/* 267 */       return mappingMethod;
/*     */     }
/*     */     
/*     */     String getSetterParameterTypeAsString(String argFieldName) {
/* 271 */       Method setterMethod = getExistingSetterForField(argFieldName);
/* 272 */       if (setterMethod != null) {
/* 273 */         if ((setterMethod.getParameterTypes()).length == 2) {
/* 274 */           return setterMethod.getParameterTypes()[1].getSimpleName();
/*     */         }
/*     */         
/* 277 */         return setterMethod.getParameterTypes()[0].getSimpleName();
/*     */       } 
/*     */       
/* 280 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryResultHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */