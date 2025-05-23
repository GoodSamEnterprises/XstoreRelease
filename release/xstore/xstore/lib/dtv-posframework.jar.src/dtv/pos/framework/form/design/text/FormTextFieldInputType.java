/*     */ package dtv.pos.framework.form.design.text;
/*     */ 
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class FormTextFieldInputType
/*     */   implements Comparable<FormTextFieldInputType>
/*     */ {
/*  21 */   private static final Logger logger = Logger.getLogger(FormTextFieldInputType.class);
/*     */   
/*  23 */   private static int MASK_HAS_NONE = 0;
/*  24 */   private static int MASK_HAS_MAX_CHARACTERS = 1;
/*  25 */   private static int MASK_HAS_MAX_INTEGER_DIGITS = 2;
/*  26 */   private static int MASK_HAS_MAX_FRACTION_DIGITS = 4;
/*  27 */   private static int MASK_HAS_SIGN = 8;
/*  28 */   private static int MASK_HAS_MAX = 16;
/*  29 */   private static int MASK_HAS_MIN = 32;
/*  30 */   private static int MASK_HAS_REGEX_POLICY = 64;
/*  31 */   private static int MASK_HAS_EDIT_PATTERN = 128;
/*  32 */   private static int MASK_HAS_ALL = MASK_HAS_MAX_CHARACTERS | MASK_HAS_MAX_INTEGER_DIGITS | MASK_HAS_MAX_FRACTION_DIGITS | MASK_HAS_SIGN | MASK_HAS_MAX | MASK_HAS_MIN | MASK_HAS_REGEX_POLICY | MASK_HAS_EDIT_PATTERN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static final FormTextFieldInputType MASK = new FormTextFieldInputType("Mask", MASK_HAS_EDIT_PATTERN);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static final FormTextFieldInputType CASE_ALL_UPPER = new FormTextFieldInputType("CaseAllUpper", MASK_HAS_MAX_CHARACTERS + MASK_HAS_REGEX_POLICY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public static final FormTextFieldInputType CASE_ALL_LOWER = new FormTextFieldInputType("CaseAllLower", MASK_HAS_MAX_CHARACTERS + MASK_HAS_REGEX_POLICY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final FormTextFieldInputType CASE_PROPER_NAME = new FormTextFieldInputType("CaseProperName", MASK_HAS_MAX_CHARACTERS + MASK_HAS_REGEX_POLICY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final FormTextFieldInputType CASE_MIXED = new FormTextFieldInputType("CaseMixed", MASK_HAS_MAX_CHARACTERS + MASK_HAS_REGEX_POLICY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final FormTextFieldInputType DATE = new FormTextFieldInputType("Date", MASK_HAS_NONE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final FormTextFieldInputType BIRTH_DATE = new FormTextFieldInputType("BirthDate", MASK_HAS_NONE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public static final FormTextFieldInputType INTEGER = new FormTextFieldInputType("Integer", MASK_HAS_MAX_INTEGER_DIGITS + MASK_HAS_SIGN + MASK_HAS_MAX + MASK_HAS_MIN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final FormTextFieldInputType NUMERIC = new FormTextFieldInputType("Numeric", MASK_HAS_MAX_INTEGER_DIGITS);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final FormTextFieldInputType DECIMAL = new FormTextFieldInputType("Decimal", MASK_HAS_MAX_INTEGER_DIGITS + MASK_HAS_MAX_FRACTION_DIGITS + MASK_HAS_SIGN + MASK_HAS_MAX + MASK_HAS_MIN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public static final FormTextFieldInputType MONEY = new FormTextFieldInputType("Money", MASK_HAS_MAX_INTEGER_DIGITS + MASK_HAS_MAX_FRACTION_DIGITS + MASK_HAS_MAX + MASK_HAS_MIN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public static final FormTextFieldInputType PERCENT = new FormTextFieldInputType("Percent", MASK_HAS_MAX_INTEGER_DIGITS + MASK_HAS_MAX_FRACTION_DIGITS + MASK_HAS_SIGN + MASK_HAS_MAX + MASK_HAS_MIN);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public static final FormTextFieldInputType SIMPLE = new FormTextFieldInputType("Simple", MASK_HAS_MAX_CHARACTERS);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   public static final FormTextFieldInputType TIME_SHORT = new FormTextFieldInputType("TimeShort", MASK_HAS_NONE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public static final FormTextFieldInputType TIME_MEDIUM = new FormTextFieldInputType("TimeMedium", MASK_HAS_NONE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public static final FormTextFieldInputType TIME_LONG = new FormTextFieldInputType("TimeLong", MASK_HAS_NONE);
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, FormTextFieldInputType> values_;
/*     */ 
/*     */   
/* 135 */   private static FormTextFieldInputType[] sortedInstances_ = null;
/* 136 */   private static FormTextFieldInputType[] sortedInstancesPlusNull_ = null;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final int type_;
/*     */ 
/*     */   
/*     */   public static FormTextFieldInputType forName(String argName) {
/* 145 */     return forName(argName, true);
/*     */   }
/*     */   
/*     */   public static FormTextFieldInputType forName(String argName, boolean argCreateNotFound) {
/* 149 */     if (argName == null) {
/* 150 */       return null;
/*     */     }
/* 152 */     FormTextFieldInputType found = values_.get(argName.trim());
/* 153 */     if (found == null) {
/* 154 */       if (argCreateNotFound) {
/* 155 */         found = new FormTextFieldInputType(argName, MASK_HAS_ALL);
/*     */       } else {
/*     */         
/* 158 */         logger.warn("There is no instance of [" + FormTextFieldInputType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */       } 
/*     */     }
/*     */     
/* 162 */     return found;
/*     */   }
/*     */   
/*     */   public static FormTextFieldInputType forType(TextFieldInputType argType) {
/* 166 */     if (argType == null) {
/* 167 */       return null;
/*     */     }
/* 169 */     return forName(argType.toString());
/*     */   }
/*     */   
/*     */   public static FormTextFieldInputType[] getInstances() {
/* 173 */     return getInstances(false);
/*     */   }
/*     */   
/*     */   public static FormTextFieldInputType[] getInstances(boolean includeNull) {
/* 177 */     if (sortedInstances_ == null) {
/* 178 */       sortedInstances_ = (FormTextFieldInputType[])values_.values().toArray((Object[])new FormTextFieldInputType[0]);
/* 179 */       Arrays.sort((Object[])sortedInstances_);
/*     */       
/* 181 */       sortedInstancesPlusNull_ = new FormTextFieldInputType[sortedInstances_.length + 1];
/* 182 */       sortedInstancesPlusNull_[0] = null;
/* 183 */       System.arraycopy(sortedInstances_, 0, sortedInstancesPlusNull_, 1, sortedInstances_.length);
/*     */     } 
/* 185 */     if (includeNull) {
/* 186 */       return sortedInstancesPlusNull_;
/*     */     }
/*     */     
/* 189 */     return sortedInstances_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FormTextFieldInputType(String argName, int argType) {
/* 199 */     this.name_ = argName.trim();
/* 200 */     this.type_ = argType;
/* 201 */     if (values_ == null) {
/* 202 */       values_ = new HashMap<>();
/*     */     }
/* 204 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FormTextFieldInputType other) {
/* 209 */     return this.name_.compareTo(other.name_);
/*     */   }
/*     */   
/*     */   public boolean hasEditPattern() {
/* 213 */     return ((this.type_ & MASK_HAS_EDIT_PATTERN) == MASK_HAS_EDIT_PATTERN);
/*     */   }
/*     */   
/*     */   public boolean hasMaxCharacters() {
/* 217 */     return ((this.type_ & MASK_HAS_MAX_CHARACTERS) == MASK_HAS_MAX_CHARACTERS);
/*     */   }
/*     */   
/*     */   public boolean hasMaximumFractionDigits() {
/* 221 */     return ((this.type_ & MASK_HAS_MAX_FRACTION_DIGITS) == MASK_HAS_MAX_FRACTION_DIGITS);
/*     */   }
/*     */   
/*     */   public boolean hasMaximumIntegerDigits() {
/* 225 */     return ((this.type_ & MASK_HAS_MAX_INTEGER_DIGITS) == MASK_HAS_MAX_INTEGER_DIGITS);
/*     */   }
/*     */   
/*     */   public boolean hasMaximumValue() {
/* 229 */     return ((this.type_ & MASK_HAS_MAX) == MASK_HAS_MAX);
/*     */   }
/*     */   
/*     */   public boolean hasMinimumValue() {
/* 233 */     return ((this.type_ & MASK_HAS_MIN) == MASK_HAS_MIN);
/*     */   }
/*     */   
/*     */   public boolean hasRegexPolicy() {
/* 237 */     return ((this.type_ & MASK_HAS_REGEX_POLICY) == MASK_HAS_REGEX_POLICY);
/*     */   }
/*     */   
/*     */   public boolean hasSign() {
/* 241 */     return ((this.type_ & MASK_HAS_SIGN) == MASK_HAS_SIGN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 251 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\text\FormTextFieldInputType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */