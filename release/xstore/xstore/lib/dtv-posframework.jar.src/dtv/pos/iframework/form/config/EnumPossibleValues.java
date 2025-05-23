/*     */ package dtv.pos.iframework.form.config;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public final class EnumPossibleValues
/*     */ {
/*  23 */   private static final Logger logger_ = Logger.getLogger(EnumPossibleValues.class);
/*  24 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   private static final String SEPARATOR = ";";
/*     */   
/*     */   private static final String ENCODING_CHAR_SET = "UTF-8";
/*     */   
/*     */   private final String toString_;
/*     */   
/*     */   private final List<IFormattable> possibleValues_;
/*     */ 
/*     */   
/*     */   public static EnumPossibleValues makeFromConfigValue(String argValue) {
/*  36 */     String[] values = StringUtils.split(argValue, ';');
/*  37 */     List<IFormattable> l = new ArrayList<>(values.length);
/*  38 */     for (String value : values) {
/*  39 */       l.add(makeFormattable(decode(value)));
/*     */     }
/*  41 */     return new EnumPossibleValues(l, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EnumPossibleValues makeFromDesignValue(String argValue) {
/*  50 */     StringBuilder toString = new StringBuilder();
/*  51 */     List<IFormattable> valueList = new ArrayList<>();
/*     */     
/*  53 */     String value = argValue.replaceAll("\r\n", "\n").replaceAll("\r", "\n");
/*  54 */     for (String s : StringUtils.split(value, '\n')) {
/*  55 */       valueList.add(makeFormattable(s));
/*  56 */       toString.append(encode(s)).append(";");
/*     */     } 
/*     */ 
/*     */     
/*  60 */     if (toString.length() > 0) {
/*  61 */       toString.setLength(toString.length() - ";".length());
/*     */     }
/*  63 */     return new EnumPossibleValues(valueList, toString.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String decode(String argString) {
/*     */     try {
/*  73 */       return URLDecoder.decode(argString, "UTF-8");
/*     */     }
/*  75 */     catch (UnsupportedEncodingException ex) {
/*  76 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */       
/*  78 */       return argString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String encode(String argString) {
/*     */     try {
/*  88 */       return URLEncoder.encode(argString, "UTF-8");
/*     */     }
/*  90 */     catch (UnsupportedEncodingException ex) {
/*  91 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */       
/*  93 */       return argString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static IFormattable makeFormattable(String argString) {
/* 103 */     if (argString.startsWith("_")) {
/* 104 */       return FF.getTranslatable(argString);
/*     */     }
/*     */     
/* 107 */     return FF.getLiteral(argString);
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
/*     */   private EnumPossibleValues(List<IFormattable> argPossibleValues, String argToString) {
/* 121 */     this.possibleValues_ = argPossibleValues;
/* 122 */     this.toString_ = argToString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IFormattable> getValuesList() {
/* 130 */     return this.possibleValues_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValuesListString() {
/* 138 */     if (this.possibleValues_.isEmpty()) {
/* 139 */       return "";
/*     */     }
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     for (int i = 0; i < this.possibleValues_.size(); i++) {
/* 143 */       IFormattable f = this.possibleValues_.get(i);
/* 144 */       sb.append(f.getUnformattedData()).append("\n");
/*     */     } 
/*     */     
/* 147 */     sb.setLength(sb.length() - 1);
/* 148 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\EnumPossibleValues.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */