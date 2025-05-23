/*     */ package dtv.data2.dataloader.valuetranslator;
/*     */ 
/*     */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ public class OptionalStringConcatTranslator
/*     */   extends AbstractValueTranslator
/*     */   implements IValueTranslator
/*     */ {
/*     */   private static final String PARAM_SEPARATOR = "SEPARATOR";
/*     */   private static final String PARAM_ARG = "STRING.";
/*     */   private static final String PARAM_DEFAULT = "DEFAULT";
/*  53 */   private String separator_ = "";
/*     */ 
/*     */   
/*  56 */   private final Map<String, String> values_ = new TreeMap<>();
/*     */ 
/*     */   
/*  59 */   private String default_ = "";
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
/*  70 */     if (argName.equalsIgnoreCase("SEPARATOR")) {
/*  71 */       this.separator_ = (argValue == null) ? "" : argValue;
/*     */     }
/*  73 */     else if (argName.equalsIgnoreCase("DEFAULT")) {
/*  74 */       this.default_ = (argValue == null) ? "" : argValue;
/*     */     }
/*  76 */     else if (argName.toUpperCase().startsWith("STRING.")) {
/*  77 */       this.values_.put(argName.trim().toUpperCase(), argValue);
/*     */     } else {
/*     */       
/*  80 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/*  87 */     StringBuilder output = new StringBuilder(this.values_.size() * (this.separator_.length() + 20));
/*     */     
/*  89 */     boolean appended = false;
/*  90 */     for (String mapValue : this.values_.values()) {
/*  91 */       String value = getValueForArgument(argCurrentValue, mapValue, argCurrentLine);
/*  92 */       if (!StringUtils.isEmpty(value)) {
/*  93 */         if (appended) {
/*  94 */           output.append(this.separator_);
/*     */         }
/*  96 */         output.append(value);
/*  97 */         appended = true;
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     String returnValue = output.toString();
/* 102 */     if (StringUtils.isEmpty(returnValue)) {
/* 103 */       returnValue = this.default_;
/*     */     }
/* 105 */     return returnValue;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\OptionalStringConcatTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */