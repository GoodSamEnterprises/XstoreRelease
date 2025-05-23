/*     */ package dtv.pos.iframework.type;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.util.ICodeInterface;
/*     */ import dtv.util.ResourceUtils;
/*     */ import java.util.Locale;
/*     */ import java.util.Properties;
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
/*     */ 
/*     */ public abstract class AbstractCodeEnum<E extends AbstractCodeEnum<E>>
/*     */   implements IFormattable, ICodeInterface
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(AbstractCodeEnum.class);
/*     */   
/*  28 */   private static Properties sortOrderProp = ResourceUtils.getProperties("SortOrder");
/*     */   
/*     */   private static String getDynamicSortOrder(Class<?> argClass, String argName) {
/*  31 */     return "_" + argClass.getName() + "." + argName + ".sortOrder";
/*     */   }
/*     */   
/*     */   private static String getTranslation(Class<?> argClass, String argName) {
/*  35 */     return "_" + argClass.getName() + "." + argName;
/*     */   }
/*     */   
/*  38 */   private FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   private final String code_;
/*     */   
/*     */   private final String description_;
/*     */   
/*     */   private final int sortOrder_;
/*     */   private final String dynamicSortOrder_;
/*     */   private Locale locale_;
/*  47 */   private String sourceDescription_ = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractCodeEnum(Class<?> argClass, String argName) {
/*  56 */     this(argName, getTranslation(argClass, argName), -1, getDynamicSortOrder(argClass, argName));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractCodeEnum(Class<?> argClass, String argName, int argSortOrder) {
/*  67 */     this(argName, getTranslation(argClass, argName), argSortOrder, null);
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
/*     */   protected AbstractCodeEnum(String argName, String argDescription, int argSortOrder, String argDynamicSortOrder) {
/*  81 */     this.code_ = argName.trim().toUpperCase();
/*  82 */     this.description_ = argDescription;
/*  83 */     this.sortOrder_ = argSortOrder;
/*  84 */     this.dynamicSortOrder_ = argDynamicSortOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int compareTo(ICodeInterface other) {
/*  91 */     int otherDisplayOrder = other.getSortOrder();
/*  92 */     int thisDisplayOrder = getSortOrder();
/*  93 */     if (thisDisplayOrder < otherDisplayOrder) {
/*  94 */       return -1;
/*     */     }
/*  96 */     if (thisDisplayOrder == otherDisplayOrder) {
/*  97 */       return 0;
/*     */     }
/*  99 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/* 105 */     if (argOther == this) {
/* 106 */       return true;
/*     */     }
/* 108 */     if (!(argOther instanceof AbstractCodeEnum)) {
/* 109 */       return false;
/*     */     }
/* 111 */     if (!argOther.getClass().getName().equals(getClass().getName())) {
/* 112 */       return false;
/*     */     }
/* 114 */     AbstractCodeEnum<?> other = (AbstractCodeEnum)argOther;
/*     */     
/* 116 */     return other.code_.equals(this.code_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getCode() {
/* 123 */     return this.code_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getDescription() {
/* 129 */     return toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Locale getLocale() {
/* 135 */     return this.locale_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 143 */     return this.code_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSortOrder() {
/* 149 */     if (this.dynamicSortOrder_ != null) {
/*     */       try {
/* 151 */         String s = sortOrderProp.getProperty(this.dynamicSortOrder_);
/* 152 */         return Integer.valueOf(s).intValue();
/*     */       }
/* 154 */       catch (Exception ex) {
/* 155 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/* 158 */     return this.sortOrder_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 164 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object getUnformattedData() {
/* 174 */     return this.FF.getTranslatable(this.description_).getUnformattedData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     return this.code_.hashCode();
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
/*     */   public boolean isFormattingOptimizable() {
/* 195 */     return this.FF.getTranslatable(this.description_).isFormattingOptimizable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String argName) {
/* 206 */     return getName().equalsIgnoreCase(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLocale(Locale argLcoale) {
/* 212 */     this.locale_ = argLcoale;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/* 218 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 224 */     return getDescription();
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
/*     */   public final String toString(OutputContextType argOutputContextType) {
/* 236 */     return this.FF.getTranslatable(this.description_).toString(argOutputContextType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString(OutputContextType argOutputContextType, Locale argLocale) {
/* 242 */     return this.FF.getTranslatable(this.description_).toString(argOutputContextType, argLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString(OutputContextType argContextType, Locale argLocale, Object argObject) {
/* 248 */     return this.FF.getTranslatable(this.description_).toString(argContextType, argLocale, argObject);
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
/*     */   public final String toString(OutputContextType argOutputContextType, Object argObject) {
/* 262 */     return this.FF.getTranslatable(this.description_).toString(argOutputContextType, argObject);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\AbstractCodeEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */