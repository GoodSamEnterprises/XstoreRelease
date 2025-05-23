/*     */ package dtv.data2.dataloader.valuetranslator;
/*     */ 
/*     */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
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
/*     */ public class BooleanInverterTranslator
/*     */   extends AbstractValueTranslator
/*     */   implements IValueTranslator
/*     */ {
/*  28 */   private static final String PARAM_NAME_FALSE = Boolean.FALSE.toString().trim().toUpperCase();
/*  29 */   private static final String PARAM_NAME_NULL = String.valueOf((Object)null).trim().toUpperCase();
/*  30 */   private static final String PARAM_NAME_TRUE = Boolean.TRUE.toString().trim().toUpperCase();
/*     */   
/*  32 */   private static final String TRUE = String.valueOf(1).trim().toUpperCase();
/*  33 */   private static final String FALSE = String.valueOf(0).trim().toUpperCase();
/*     */   
/*     */   private boolean isNullTrue_ = false;
/*  36 */   private final Collection<String> truthValues_ = new HashSet<>();
/*  37 */   private final Collection<String> falseValues_ = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BooleanInverterTranslator() {
/*  43 */     this.truthValues_.add(TRUE);
/*  44 */     this.truthValues_.add("Y");
/*  45 */     this.falseValues_.add(FALSE);
/*  46 */     this.falseValues_.add("N");
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
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/*  70 */     String value = null;
/*  71 */     if (argValue != null) {
/*  72 */       value = argValue.trim().toUpperCase();
/*     */     }
/*  74 */     if (PARAM_NAME_FALSE.equalsIgnoreCase(argName)) {
/*  75 */       this.falseValues_.add(value);
/*     */     }
/*  77 */     else if (PARAM_NAME_NULL.equalsIgnoreCase(argName)) {
/*  78 */       this.isNullTrue_ = ConfigUtils.toBoolean(value).booleanValue();
/*     */     }
/*  80 */     else if (PARAM_NAME_TRUE.equalsIgnoreCase(argName)) {
/*  81 */       this.truthValues_.add(value);
/*     */     } else {
/*     */       
/*  84 */       super.setParameter(argName, argValue);
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
/*     */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 112 */     boolean newValue = false;
/* 113 */     String currentValue = null;
/*     */ 
/*     */     
/* 116 */     if (StringUtils.isEmpty(argCurrentValue)) {
/* 117 */       currentValue = this.isNullTrue_ ? TRUE : FALSE;
/*     */     } else {
/*     */       
/* 120 */       currentValue = argCurrentValue.trim().toUpperCase();
/*     */     } 
/*     */ 
/*     */     
/* 124 */     if (this.falseValues_.contains(currentValue)) {
/* 125 */       newValue = false;
/*     */     }
/*     */ 
/*     */     
/* 129 */     if (this.truthValues_.contains(currentValue)) {
/* 130 */       newValue = true;
/*     */     }
/*     */ 
/*     */     
/* 134 */     newValue = !newValue;
/*     */ 
/*     */     
/* 137 */     return newValue ? TRUE : FALSE;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\BooleanInverterTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */