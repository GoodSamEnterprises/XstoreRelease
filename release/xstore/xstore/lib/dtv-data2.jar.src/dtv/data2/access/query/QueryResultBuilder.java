/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryResult;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.StringTokenizer;
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
/*     */ public class QueryResultBuilder
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(QueryResultBuilder.class);
/*     */   
/*  28 */   private final String PUT_METHOD = "put";
/*  29 */   private final String SETTER_PREFIX = "set";
/*  30 */   private final String GETTER_PREFIX = "get";
/*  31 */   private final String DOT_OPERATOR = ".";
/*     */ 
/*     */ 
/*     */   
/*  35 */   private static final QueryResultBuilder INSTANCE = new QueryResultBuilder();
/*     */ 
/*     */   
/*     */   public static QueryResultBuilder getInstance() {
/*  39 */     return INSTANCE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IQueryResult[] buildResults(String argQueryKey, Object[][] argResults, String[] argFields, Class<?> argResultClass, String argDataSource) {
/*  61 */     checkForInputErrors(argQueryKey, argResults, argFields, argResultClass, argDataSource);
/*     */ 
/*     */     
/*  64 */     QueryResultHelper.DataMapping mapping = QueryResultHelper.getInstance().getMapping(argResultClass);
/*  65 */     IQueryResult[] returnModels = (IQueryResult[])Array.newInstance(argResultClass, argResults.length);
/*  66 */     for (int recordIndex = 0; recordIndex < argResults.length; recordIndex++) {
/*     */       try {
/*  68 */         returnModels[recordIndex] = (IQueryResult)argResultClass.newInstance();
/*     */       }
/*  70 */       catch (Exception ex) {
/*  71 */         throw new DtxException("Could not instantiate query result class specified: " + argResultClass
/*  72 */             .getName(), ex);
/*     */       } 
/*     */ 
/*     */       
/*  76 */       returnModels[recordIndex].setDataSource(argDataSource);
/*     */ 
/*     */       
/*  79 */       Object[] argObjectParameters = argResults[recordIndex];
/*  80 */       for (int index = 0; index < argFields.length; index++) {
/*  81 */         String fieldName = argFields[index];
/*  82 */         Object methodParameter = argObjectParameters[index];
/*     */ 
/*     */         
/*  85 */         if (methodParameter != null)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/*  90 */           if (fieldName.indexOf(".") != -1) {
/*  91 */             setValueMethodChain(returnModels[recordIndex], fieldName, methodParameter);
/*     */           } else {
/*     */ 
/*     */             
/*     */             try {
/*  96 */               Method setterMethod = mapping.getSetterForField(fieldName, methodParameter);
/*     */ 
/*     */               
/*  99 */               if (setterMethod != null && (setterMethod.getParameterTypes()).length == 1) {
/* 100 */                 invokeSetterForSingleArgumentMethod(returnModels[recordIndex], setterMethod, methodParameter);
/*     */               
/*     */               }
/* 103 */               else if ((setterMethod != null && (setterMethod.getParameterTypes()).length == 2) || setterMethod
/* 104 */                 .getName().equals("put")) {
/* 105 */                 setterMethod.invoke(returnModels[recordIndex], new Object[] { fieldName, methodParameter });
/*     */               }
/*     */               else {
/*     */                 
/* 109 */                 throw new DtxException("An unrecognized setter of [" + setterMethod.toString() + " was found for field " + fieldName + " but could not be used.");
/*     */               }
/*     */             
/*     */             }
/* 113 */             catch (Exception ee) {
/* 114 */               throw new DtxException("An exception occurred while setting field " + fieldName + ".  Could not successfully assign paramter of " + methodParameter + " [Type: " + methodParameter
/*     */                   
/* 116 */                   .getClass() + " Value: " + String.valueOf(methodParameter) + "].", ee);
/*     */             } 
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 121 */     return returnModels;
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
/*     */   public void setValueMethodChain(Object argCurrentResultObject, String methodChain, Object argParameter) {
/*     */     try {
/* 134 */       if (argCurrentResultObject instanceof dtv.data2.access.IDataModel)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 141 */         StringTokenizer tokens = new StringTokenizer(methodChain, ".");
/* 142 */         Object lastObject = argCurrentResultObject;
/*     */         
/* 144 */         while (tokens.hasMoreTokens()) {
/* 145 */           String methodName = tokens.nextToken();
/*     */           
/* 147 */           if (tokens.hasMoreTokens()) {
/* 148 */             Object currentObject = ObjectUtils.invokeMethod(methodName, lastObject, null);
/*     */             
/* 150 */             if (currentObject == null) {
/*     */               
/* 152 */               Class<?> objectType = lastObject.getClass().getMethod(methodName, new Class[0]).getReturnType();
/* 153 */               currentObject = DataFactory.createObject(objectType);
/*     */ 
/*     */               
/* 156 */               String setterName = "set" + methodName.substring("get".length());
/* 157 */               ObjectUtils.invokeMethod(setterName, lastObject, new Class[] { objectType }, new Object[] { currentObject }, null);
/*     */             } 
/*     */             
/* 160 */             lastObject = currentObject;
/*     */             continue;
/*     */           } 
/* 163 */           ObjectUtils.invokeMethod(methodName, lastObject, new Class[] { argParameter.getClass() }, new Object[] { argParameter }, null);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else
/*     */       {
/* 170 */         ObjectUtils.invokeMethodChain(methodChain, argCurrentResultObject, new Class[] { argParameter
/* 171 */               .getClass() }, new Object[] { argParameter }, null);
/*     */       }
/*     */     
/* 174 */     } catch (Exception ee) {
/* 175 */       throw new DtxException("An exception occurred while calling method chain " + methodChain + " on object of class: " + argCurrentResultObject
/* 176 */           .getClass().getName() + " with paramter: " + argParameter, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void invokeSetterForSingleArgumentMethod(IQueryResult argModelObject, Method argSetterMethod, Object argParameter) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
/* 184 */     Class<?> parameterClass = argParameter.getClass();
/* 185 */     Class<?> setterMethodParameterClass = argSetterMethod.getParameterTypes()[0];
/*     */ 
/*     */     
/* 188 */     if (setterMethodParameterClass.equals(parameterClass) || 
/* 189 */       ClassUtils.isAssignable(argSetterMethod.getParameterTypes()[0], parameterClass)) {
/* 190 */       argSetterMethod.invoke(argModelObject, new Object[] { argParameter });
/*     */ 
/*     */     
/*     */     }
/* 194 */     else if (argParameter instanceof Number && 
/* 195 */       ClassUtils.isAssignable(Number.class, setterMethodParameterClass)) {
/* 196 */       argSetterMethod.invoke(argModelObject, new Object[] {
/* 197 */             NumberUtils.getNumberFromOtherNumber((Number)argParameter, setterMethodParameterClass)
/*     */           });
/*     */     
/*     */     }
/* 201 */     else if (argParameter instanceof Number && 
/* 202 */       ClassUtils.isAssignable(Boolean.class, setterMethodParameterClass)) {
/* 203 */       argSetterMethod.invoke(argModelObject, new Object[] { Boolean.valueOf((((Number)argParameter).intValue() == 1)) });
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 208 */     else if (parameterClass.isArray() && 
/* 209 */       ClassUtils.isAssignable(parameterClass.getComponentType(), setterMethodParameterClass
/* 210 */         .getComponentType())) {
/* 211 */       int arrayLength = Array.getLength(argParameter);
/* 212 */       Object targetArray = Array.newInstance(setterMethodParameterClass.getComponentType(), arrayLength);
/* 213 */       for (int arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++) {
/* 214 */         Array.set(targetArray, arrayIndex, Array.get(argParameter, arrayIndex));
/*     */       }
/* 216 */       argSetterMethod.invoke(argModelObject, new Object[] { targetArray });
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 221 */       throw new DtxException("An exception occurred while calling [" + argSetterMethod.toString() + "].  Could not successfully assign paramter of " + argParameter + " [Type: " + parameterClass
/*     */           
/* 223 */           .toString() + "Value: " + String.valueOf(argParameter) + "].");
/*     */     } 
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
/*     */   private void checkForInputErrors(String argQueryKey, Object[][] argResults, String[] argFields, Class<?> argResultClass, String argDataSource) {
/* 238 */     if (argResults == null) {
/* 239 */       DtxException ex = new DtxException("buildResults was called with a NULL argResults array. This is an invalid call.");
/*     */       
/* 241 */       logQueryResultError(ex.getMessage(), argQueryKey, argResults, argFields, argResultClass, argDataSource, (Throwable)ex);
/*     */       
/* 243 */       throw ex;
/*     */     } 
/*     */     
/* 246 */     if (argFields == null) {
/* 247 */       DtxException ex = new DtxException("buildResults was called with a NULL argFields array. This is an invalid call.");
/*     */       
/* 249 */       logQueryResultError(ex.getMessage(), argQueryKey, argResults, argFields, argResultClass, argDataSource, (Throwable)ex);
/*     */       
/* 251 */       throw ex;
/*     */     } 
/*     */     
/* 254 */     if (argResultClass == null) {
/* 255 */       DtxException ex = new DtxException("buildResults was called with a NULL argResultClass. This is an invalid call.");
/*     */       
/* 257 */       logQueryResultError(ex.getMessage(), argQueryKey, argResults, argFields, argResultClass, argDataSource, (Throwable)ex);
/*     */       
/* 259 */       throw ex;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void logQueryResultError(String argMsg, String argQueryKey, Object[][] argResults, String[] argFields, Class<?> argResultClass, String argDataSource, Throwable argException) {
/* 267 */     String resultsString = "argResults: null";
/*     */     
/* 269 */     if (argResults != null) {
/* 270 */       resultsString = "argResults row length: " + argResults.length;
/* 271 */       resultsString = resultsString + " argResults values: ";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 277 */       for (int ii = 0, n = Math.min(argResults.length, 5); ii < n; ii++) {
/*     */ 
/*     */         
/* 280 */         resultsString = resultsString + "row idx " + ii + " column count: " + ((argResults[ii] != null) ? String.valueOf((argResults[ii]).length) : "null");
/*     */         
/* 282 */         resultsString = resultsString + " [";
/*     */         
/* 284 */         for (int jj = 0; jj < (argResults[ii]).length; jj++) {
/* 285 */           resultsString = resultsString + argResults[ii][jj];
/*     */           
/* 287 */           if (jj < (argResults[ii]).length - 1) {
/* 288 */             resultsString = resultsString + ", ";
/*     */           }
/*     */         } 
/* 291 */         resultsString = resultsString + "] ";
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 296 */     String argFieldsString = "argFields: null";
/*     */     
/* 298 */     if (argFields != null) {
/* 299 */       argFieldsString = "argFields length: " + argFields.length;
/* 300 */       argFieldsString = argFieldsString + " argFields values: ";
/*     */       
/* 302 */       for (int ii = 0; ii < argFields.length; ii++) {
/* 303 */         argFieldsString = argFieldsString + "[" + argFields[ii] + "]";
/*     */         
/* 305 */         if (ii < argFields.length - 1) {
/* 306 */           argFieldsString = argFieldsString + ", ";
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 313 */     String resultClassString = ("argResultClass: " + argResultClass != null) ? ObjectUtils.getClassName(argResultClass) : "null";
/*     */     
/* 315 */     String DIVIDER = " -- ";
/*     */     
/* 317 */     logger_.error(argMsg + " QUERY KEY: " + argQueryKey + " -- " + resultsString + " -- " + argFieldsString + " -- " + resultClassString + " -- " + "Datasource: " + argDataSource, (argException != null) ? argException : new Throwable("STACK TRACE"));
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryResultBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */