/*     */ package dtv.pos.iframework.form.design.type;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FormComponentType
/*     */   implements Comparable<FormComponentType>
/*     */ {
/*  18 */   public static final FormComponentType LABEL = new FormComponentType("FormLabel");
/*  19 */   public static final FormComponentType LABEL_WRAPPING = new FormComponentType("FormLabelWrapping");
/*  20 */   public static final FormComponentType LABEL_DIMINISHED = new FormComponentType("FormLabelDiminished");
/*  21 */   public static final FormComponentType LABEL_WRAPPING_DIMINISHED = new FormComponentType("FormLabelWrappingDiminished");
/*     */   
/*  23 */   public static final FormComponentType ICON = new FormComponentType("FormIcon");
/*  24 */   public static final FormComponentType TEXT_FIELD = new FormComponentType("FormTextField");
/*  25 */   public static final FormComponentType LONG_TEXT_FIELD = new FormComponentType("FormLongTextField");
/*  26 */   public static final FormComponentType COMBO_BOX = new FormComponentType("FormComboBox");
/*  27 */   public static final FormComponentType LIST = new FormComponentType("FormList");
/*  28 */   public static final FormComponentType TABLE = new FormComponentType("FormTable");
/*  29 */   public static final FormComponentType YES_NO = new FormComponentType("FormYesNo");
/*  30 */   public static final FormComponentType YES_NO_INVERTED = new FormComponentType("FormYesNoInverted");
/*  31 */   public static final FormComponentType RULE = new FormComponentType("FormRule");
/*  32 */   public static final FormComponentType CHART = new FormComponentType("FormChart");
/*  33 */   public static final FormComponentType GANTT = new FormComponentType("FormGantt");
/*     */   
/*  35 */   public static final FormComponentType PROGRESS = new FormComponentType("FormProgress");
/*  36 */   public static final FormComponentType PANEL = new FormComponentType("FormPanel");
/*     */ 
/*     */   
/*     */   private static Map<String, FormComponentType> values_;
/*     */ 
/*     */   
/*  42 */   private static FormComponentType[] sortedInstances_ = null;
/*  43 */   private static FormComponentType[] sortedInstancesPlusNull_ = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final FormComponentType forName(String argName) {
/*  52 */     if (argName == null) {
/*  53 */       return null;
/*     */     }
/*  55 */     FormComponentType found = values_.get(argName.trim());
/*  56 */     if (found == null) {
/*  57 */       return new FormComponentType(argName);
/*     */     }
/*  59 */     return found;
/*     */   }
/*     */   
/*     */   public static final FormComponentType[] getInstances() {
/*  63 */     return getInstances(false);
/*     */   }
/*     */   
/*     */   public static final FormComponentType[] getInstances(boolean includeNull) {
/*  67 */     if (sortedInstances_ == null) {
/*  68 */       sortedInstances_ = (FormComponentType[])values_.values().toArray((Object[])new FormComponentType[0]);
/*  69 */       Arrays.sort((Object[])sortedInstances_);
/*     */       
/*  71 */       sortedInstancesPlusNull_ = new FormComponentType[sortedInstances_.length + 1];
/*  72 */       sortedInstancesPlusNull_[0] = null;
/*  73 */       System.arraycopy(sortedInstances_, 0, sortedInstancesPlusNull_, 1, sortedInstances_.length);
/*     */     } 
/*  75 */     if (includeNull) {
/*  76 */       return sortedInstancesPlusNull_;
/*     */     }
/*     */     
/*  79 */     return sortedInstances_;
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
/*     */   private FormComponentType(String argName) {
/*  92 */     this.name_ = argName.trim();
/*  93 */     if (values_ == null) {
/*  94 */       values_ = new HashMap<>();
/*     */     }
/*  96 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FormComponentType other) {
/* 101 */     return this.name_.compareTo(other.name_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/* 106 */     if (argOther == this) {
/* 107 */       return true;
/*     */     }
/* 109 */     if (!(argOther instanceof FormComponentType)) {
/* 110 */       return false;
/*     */     }
/* 112 */     FormComponentType other = (FormComponentType)argOther;
/*     */     
/* 114 */     return other.name_.equals(this.name_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 119 */     return this.name_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 129 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\design\type\FormComponentType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */