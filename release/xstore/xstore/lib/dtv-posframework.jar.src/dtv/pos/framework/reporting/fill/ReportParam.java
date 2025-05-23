/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.reporting.type.ReportParamComponentType;
/*     */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*     */ import dtv.pos.iframework.reporting.IReportParam;
/*     */ import dtv.pos.iframework.type.IDtvDate;
/*     */ import dtv.pos.iframework.type.IDtvDateRange;
/*     */ import dtv.pos.iframework.ui.SelectionMode;
/*     */ import dtv.util.ICode;
/*     */ import dtv.util.StringUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public abstract class ReportParam
/*     */   implements IReportParam
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(ReportParam.class);
/*     */   
/*  30 */   protected static final FormattableFactory FF = FormattableFactory.getInstance(); public static IReportParam make(String argParamName, Class<?> argValueClass, String argDescr) {
/*     */     boolean isNewGroup;
/*     */     String paramName;
/*     */     ReportParamComponentType componentType;
/*     */     ReportParam results;
/*  35 */     if (argParamName.length() > 0 && argParamName.charAt(0) == '$') {
/*  36 */       isNewGroup = true;
/*  37 */       paramName = argParamName.substring(1);
/*     */     } else {
/*     */       
/*  40 */       isNewGroup = false;
/*  41 */       paramName = argParamName;
/*     */     } 
/*     */     
/*  44 */     String[] settings = argDescr.split(";");
/*     */     
/*  46 */     IFormattable label = FF.getSimpleFormattable(settings[0]);
/*     */ 
/*     */ 
/*     */     
/*  50 */     if (settings.length > 1) {
/*  51 */       componentType = ReportParamComponentType.forName(settings[1]);
/*     */     } else {
/*     */       
/*  54 */       componentType = ReportParamComponentType.TEXT;
/*     */     } 
/*     */ 
/*     */     
/*  58 */     if (componentType == ReportParamComponentType.TEXT) {
/*  59 */       results = new TextReportParam(paramName, argValueClass, label, settings, componentType, false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  65 */     else if (componentType == ReportParamComponentType.COMBO) {
/*  66 */       results = new ListReportParam(paramName, argValueClass, label, settings, componentType, SelectionMode.SINGLE_SELECTION);
/*     */     
/*     */     }
/*  69 */     else if (componentType == ReportParamComponentType.MULTI_SELECT_LIST) {
/*  70 */       results = new ListReportParam(paramName, argValueClass, label, settings, componentType, SelectionMode.MULTIPLE_SELECTION);
/*     */     
/*     */     }
/*  73 */     else if (componentType == ReportParamComponentType.SINGLE_SELECT_LIST) {
/*  74 */       results = new ListReportParam(paramName, argValueClass, label, settings, componentType, SelectionMode.SINGLE_SELECTION);
/*     */     
/*     */     }
/*  77 */     else if (componentType == ReportParamComponentType.DATE) {
/*  78 */       if (!argValueClass.isAssignableFrom(IDtvDate.class)) {
/*  79 */         throw new IllegalArgumentException("for parameter '" + paramName + "' component type '" + ReportParamComponentType.DATE
/*  80 */             .getName() + "' requires a parameter datatype of " + IDtvDate.class
/*  81 */             .getName());
/*     */       }
/*  83 */       results = new DateReportParam(paramName, argValueClass, label, settings, componentType);
/*     */     }
/*  85 */     else if (componentType == ReportParamComponentType.DATE_RANGE) {
/*  86 */       if (!argValueClass.isAssignableFrom(IDtvDateRange.class)) {
/*  87 */         throw new IllegalArgumentException("for parameter '" + paramName + "' component type '" + ReportParamComponentType.DATE_RANGE
/*  88 */             .getName() + "' requires a parameter datatype of " + IDtvDateRange.class
/*  89 */             .getName());
/*     */       }
/*  91 */       results = new DateRangeReportParam(paramName, argValueClass, label, settings, componentType);
/*     */     }
/*  93 */     else if (componentType == ReportParamComponentType.TIME_INT) {
/*  94 */       if (!argValueClass.isAssignableFrom(Integer.class)) {
/*  95 */         throw new IllegalArgumentException("for parameter '" + paramName + "' component type '" + ReportParamComponentType.TIME_INT
/*  96 */             .getName() + "' requires a parameter datatype of " + Integer.class
/*  97 */             .getName());
/*     */       }
/*  99 */       results = new TimeIntReportParam(paramName, argValueClass, label, settings, componentType);
/*     */     } else {
/*     */       
/* 102 */       throw new IllegalArgumentException("for parameter '" + paramName + "' unknown component type: " + componentType);
/*     */     } 
/*     */     
/* 105 */     results.isNewGroup_ = isNewGroup;
/* 106 */     return results;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNewGroup_;
/*     */   private final String fieldKey_;
/*     */   private final Class<?> valueClass_;
/*     */   private final IFormattable label_;
/*     */   private final ReportParamComponentType componentType_;
/* 115 */   private String[] invokeMethods_ = new String[0];
/*     */   
/*     */   private Object value_;
/*     */ 
/*     */   
/*     */   protected ReportParam(String argParamName, Class<?> argValueClass, IFormattable argLabel, ReportParamComponentType argComponentType) {
/* 121 */     this.fieldKey_ = argParamName;
/* 122 */     this.valueClass_ = argValueClass;
/* 123 */     this.label_ = argLabel;
/* 124 */     this.componentType_ = argComponentType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/* 129 */     if (this.value_ == null) {
/* 130 */       return null;
/*     */     }
/* 132 */     if (this.value_ instanceof ICode) {
/* 133 */       return ((ICode)this.value_).getCode();
/*     */     }
/* 135 */     if (this.value_ instanceof IEnumValueWrapper) {
/* 136 */       return ((IEnumValueWrapper)this.value_).getActualValue();
/*     */     }
/* 138 */     if (this.valueClass_.getName().equals(String.class.getName())) {
/* 139 */       return this.value_.toString();
/*     */     }
/*     */     
/* 142 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportParamComponentType getComponentType() {
/* 148 */     return this.componentType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldKey() {
/* 157 */     return this.fieldKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getInvokeMethods() {
/* 163 */     return this.invokeMethods_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getLabel() {
/* 172 */     return this.label_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue() {
/* 182 */     return this.value_;
/*     */   }
/*     */   
/*     */   public Class<?> getValueClass() {
/* 186 */     return this.valueClass_;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isNewGroup() {
/* 191 */     return this.isNewGroup_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object newValue) {
/* 200 */     if (logger_.isDebugEnabled()) {
/* 201 */       logger_.debug("setting " + this.fieldKey_ + "=" + newValue);
/*     */     }
/* 203 */     this.value_ = newValue;
/*     */   }
/*     */   
/*     */   protected final String[] parseInvokeMethods(String[] argParams) {
/* 207 */     for (String propValue : argParams) {
/* 208 */       String[] prop = StringUtils.split(propValue, '=');
/* 209 */       if ("invokeMethods".equals(prop[0])) {
/*     */         try {
/* 211 */           return StringUtils.split(prop[1], ',');
/*     */         }
/* 213 */         catch (Exception ex) {
/* 214 */           logger_.error("CAUGHT EXCEPTION with '" + propValue + "'", ex);
/*     */         } 
/*     */       }
/*     */     } 
/* 218 */     return new String[0];
/*     */   }
/*     */   
/*     */   protected final void setInvokeMethods(String[] argList) {
/* 222 */     this.invokeMethods_ = argList;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\ReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */