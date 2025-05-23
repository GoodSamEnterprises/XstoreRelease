/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.pos.framework.form.config.DataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
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
/*     */ public class BeanEditModel
/*     */   extends BasicEditModel
/*     */ {
/*     */   private final Object beanObject_;
/*     */   
/*     */   public BeanEditModel(Object argDataBean) {
/*  34 */     super(null, null);
/*  35 */     this.beanObject_ = argDataBean;
/*  36 */     SortedMap<String, Method> getters = new TreeMap<>();
/*  37 */     Map<String, Method> setters = new HashMap<>();
/*  38 */     Method[] methods = argDataBean.getClass().getMethods();
/*  39 */     for (Method method : methods) {
/*  40 */       String name = method.getName();
/*  41 */       Class<?> returnType = method.getReturnType();
/*  42 */       Class[] paramTypes = method.getParameterTypes();
/*     */       
/*  44 */       if (name.length() > 3) {
/*  45 */         String fieldName = name.substring(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  51 */         if (paramTypes.length == 0 && 
/*     */           
/*  53 */           !ObjectUtils.equivalent(Void.class, returnType) && name
/*  54 */           .startsWith("get")) {
/*  55 */           getters.put(fieldName, method);
/*     */         
/*     */         }
/*  58 */         else if (paramTypes.length == 1 && 
/*     */           
/*  60 */           ObjectUtils.equivalent(Void.class, returnType) && name
/*  61 */           .startsWith("set")) {
/*  62 */           setters.put(fieldName, method);
/*     */         } 
/*     */       } 
/*  65 */     }  for (String field : getters.keySet()) {
/*  66 */       Method getter = getters.get(field);
/*  67 */       Method setter = setters.get(field);
/*  68 */       addField(field, getter, setter);
/*     */     } 
/*  70 */     initializeFieldState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDataObject() {
/*  79 */     return this.beanObject_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addField(String argName, Method argGetter, Method argSetter) {
/*  84 */     ICardinality cardinality = getCardinality(argGetter);
/*  85 */     boolean readOnly = !isGetterSetterPair(argGetter, argSetter);
/*  86 */     DataEditFieldConfig dataEditFieldConfig = new DataEditFieldConfig(argName, argGetter.getReturnType(), cardinality);
/*  87 */     int attr = (readOnly ? 4 : 0) + 2;
/*  88 */     Map<String, IDataObjectDefinitionConfig> map = Collections.emptyMap();
/*  89 */     addField(EditModelField.makeFieldDef(this, (IDataEditFieldConfig)dataEditFieldConfig, attr, this.beanObject_, map));
/*     */   }
/*     */   
/*     */   protected ICardinality getCardinality(Method argGetter) {
/*  93 */     if (ObjectUtils.isImplementing(argGetter.getReturnType(), Collection.class)) {
/*  94 */       return ICardinality.OPTIONAL_UNBOUNDED;
/*     */     }
/*     */     
/*  97 */     return ICardinality.OPTIONAL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isGetterSetterPair(Method argGetter, Method argSetter) {
/* 104 */     if (argSetter != null) {
/* 105 */       Class[] parameterTypes = argSetter.getParameterTypes();
/* 106 */       if (parameterTypes.length == 1) {
/* 107 */         Class setterType = parameterTypes[0];
/* 108 */         if (ObjectUtils.equivalent(setterType, argGetter.getReturnType())) {
/* 109 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 113 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\BeanEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */