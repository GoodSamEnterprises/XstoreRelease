/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.reporting.ReportMgr;
/*     */ import dtv.pos.framework.reporting.type.ReportParamComponentType;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.pos.iframework.reporting.IListReportParam;
/*     */ import dtv.pos.iframework.reporting.IReportParamChoiceLoader;
/*     */ import dtv.pos.iframework.ui.SelectionMode;
/*     */ import dtv.util.ICode;
/*     */ import dtv.util.ICodeInterface;
/*     */ import dtv.util.StringUtils;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ class ListReportParam
/*     */   extends ReportParam
/*     */   implements IListReportParam
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(ListReportParam.class); private final List<Object> possibleValues_; private final Object defaultListSelection_;
/*     */   
/*     */   private static Object evaluateDefaultValue(String argListExpression, String[] argParams) {
/*     */     try {
/*  35 */       Object o = invoke(argListExpression, "getDefaultSelection", argParams);
/*  36 */       if (o == null) {
/*  37 */         logger_.info(argListExpression + ".getDefaultSelection() returned null");
/*  38 */         return null;
/*     */       } 
/*     */       
/*  41 */       return o;
/*     */     
/*     */     }
/*  44 */     catch (NoSuchMethodException ex) {
/*  45 */       logger_
/*  46 */         .debug("CAUGHT EXPECTED EXCEPTION (only lists that want to set a default value will implement 'getDefaultSelection')", ex);
/*     */ 
/*     */       
/*  49 */       return null;
/*     */     }
/*  51 */     catch (Exception ex) {
/*  52 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  53 */       return null;
/*     */     } 
/*     */   }
/*     */   private final SelectionMode listSelectionMode_; private final String fieldName_;
/*     */   private static List<Object> evaluateList(String argListExpression, String[] argParams) {
/*     */     try {
/*  59 */       Object o = invoke(argListExpression, "getInstances", argParams);
/*  60 */       if (o == null) {
/*  61 */         logger_.error(argListExpression + ".getInstances() returned null");
/*  62 */         return new ArrayList();
/*     */       } 
/*  64 */       if (o.getClass().isArray()) {
/*  65 */         return new ArrayList(Arrays.asList((Object[])o));
/*     */       }
/*  67 */       if (o instanceof Collection) {
/*  68 */         return new ArrayList((Collection)o);
/*     */       }
/*     */       
/*  71 */       logger_.error(argListExpression + ".getInstances() returned a " + o.getClass().getName() + ". Expected array or Collection.");
/*     */       
/*  73 */       return new ArrayList();
/*     */ 
/*     */     
/*     */     }
/*  77 */     catch (Exception ex) {
/*  78 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  79 */       return new ArrayList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object invoke(String argClassName, String argMethod, String[] argParameters) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
/*  88 */     Class<?> c = Class.forName(argClassName);
/*  89 */     Class<?>[] paramClasses = new Class[argParameters.length];
/*  90 */     for (int i = 0; i < paramClasses.length; i++) {
/*  91 */       paramClasses[i] = String.class;
/*     */     }
/*  93 */     Method m = c.getMethod(argMethod, paramClasses);
/*  94 */     Object instance = null;
/*  95 */     if (!Modifier.isStatic(m.getModifiers())) {
/*  96 */       instance = c.newInstance();
/*  97 */       if (!IReportParamChoiceLoader.class.isInstance(instance)) {
/*  98 */         logger_.warn(c + " does not implement " + IReportParamChoiceLoader.class.getName());
/*     */       }
/*     */     } 
/* 101 */     return m.invoke(instance, (Object[])argParameters);
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
/*     */   ListReportParam(String argParamName, Class<?> argValueClass, IFormattable argLabel, String[] argParams, ReportParamComponentType argComponentType, SelectionMode argListSelectionMode) {
/* 121 */     super(argParamName, argValueClass, argLabel, argComponentType);
/* 122 */     this.listSelectionMode_ = argListSelectionMode;
/* 123 */     List<String> params = new ArrayList<>();
/* 124 */     Object allSelection = null;
/* 125 */     String fieldName = null;
/* 126 */     for (int i = 3; i < argParams.length; i++) {
/* 127 */       String[] prop = StringUtils.split(argParams[i], '=');
/* 128 */       if ("all".equalsIgnoreCase(prop[0])) {
/* 129 */         allSelection = new AllListSelection(prop[1]);
/*     */       }
/* 131 */       else if ("fieldName".equalsIgnoreCase(prop[0])) {
/* 132 */         fieldName = prop[1];
/*     */       }
/* 134 */       else if ("invokeMethods".equalsIgnoreCase(prop[0])) {
/* 135 */         setInvokeMethods(StringUtils.split(prop[1], ','));
/*     */       }
/*     */       else {
/*     */         
/* 139 */         params.add(argParams[i]);
/*     */       } 
/*     */     } 
/* 142 */     this.fieldName_ = fieldName;
/* 143 */     this.possibleValues_ = evaluateList(argParams[2], params.<String>toArray(new String[0]));
/* 144 */     this.defaultListSelection_ = evaluateDefaultValue(argParams[2], params.<String>toArray(new String[0]));
/* 145 */     if (allSelection != null) {
/* 146 */       this.possibleValues_.add(0, allSelection);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/* 153 */     if (this.listSelectionMode_ != SelectionMode.SINGLE_SELECTION) {
/* 154 */       Object value = getValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       if (this.fieldName_ == null) {
/* 161 */         if (value == null || (value instanceof Object[] && ((Object[])value).length == this.possibleValues_
/* 162 */           .size())) {
/* 163 */           return null;
/*     */         }
/* 165 */         if (value instanceof Object[]) {
/* 166 */           List<Object> list = new LinkedList();
/* 167 */           for (Object element : (Object[])value) {
/* 168 */             Object obj = null;
/* 169 */             if (element instanceof ICode) {
/* 170 */               obj = ((ICode)element).getCode();
/*     */             }
/* 172 */             else if (element instanceof IEnumValueWrapper) {
/* 173 */               obj = ((IEnumValueWrapper)element).getActualValue();
/*     */             }
/* 175 */             else if (element != null) {
/* 176 */               obj = element.toString();
/*     */             } 
/*     */             
/* 179 */             if (obj instanceof Collection) {
/* 180 */               list.addAll((Collection)obj);
/*     */             }
/* 182 */             else if (obj instanceof Object[]) {
/* 183 */               list.addAll(Arrays.asList((Object[])obj));
/*     */             }
/* 185 */             else if (obj != null) {
/* 186 */               list.add(obj);
/*     */             } 
/*     */           } 
/* 189 */           return list.isEmpty() ? null : list;
/*     */         } 
/*     */       } 
/*     */       
/* 193 */       if (value == null || (value instanceof Object[] && ((Object[])value).length == this.possibleValues_
/* 194 */         .size())) {
/* 195 */         return null;
/*     */       }
/* 197 */       if (value instanceof Object[]) {
/* 198 */         return ReportMgr.getInstance().buildSqlInStatement(this.fieldName_, (Object[])value);
/*     */       }
/*     */     } 
/* 201 */     return super.getActualValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDefaultSelection() {
/* 207 */     return this.defaultListSelection_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectionMode getListSelectionMode() {
/* 213 */     return this.listSelectionMode_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> getPossibleValues() {
/* 219 */     return Collections.unmodifiableList(this.possibleValues_);
/*     */   }
/*     */   
/*     */   private class AllListSelection
/*     */     implements ICodeInterface
/*     */   {
/*     */     private final IFormattable description_;
/*     */     
/*     */     public AllListSelection(String argKey) {
/* 228 */       this.description_ = ReportParam.FF.getTranslatable(argKey);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(ICodeInterface argOther) {
/* 234 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getCode() {
/* 240 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDescription() {
/* 246 */       return this.description_.toString(OutputContextType.VIEW);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSortOrder() {
/* 252 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 257 */       return getDescription();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\ListReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */