/*     */ package dtv.data2x;
/*     */ 
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ 
/*     */ public class DataServiceUtils
/*     */ {
/*  23 */   private static final Logger _logger = Logger.getLogger(DataServiceUtils.class);
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
/*     */   public static boolean isUndefinedNumber(int argValue) {
/*  35 */     return (argValue == Integer.MIN_VALUE);
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
/*     */   public static boolean isUndefinedNumber(Number argValue) {
/*  48 */     return (argValue == null || argValue.intValue() == Integer.MIN_VALUE);
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
/*     */   public static boolean isUndefinedNumber(String argValue) {
/*  62 */     return isUndefinedNumber(Long.valueOf(toLong(argValue)));
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
/*     */   public static Date toDate(String argDateString, boolean argIncludeTime) {
/*  75 */     Date equivDate = null;
/*  76 */     if (!StringUtils.isEmpty(argDateString)) {
/*  77 */       equivDate = argIncludeTime ? DateUtils.parseIso(argDateString) : DateUtils.parseDate(argDateString);
/*     */     }
/*  79 */     return equivDate;
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
/*     */   public static String toDateString(Date argDate, boolean argIncludeTime) {
/*  93 */     String dateString = null;
/*  94 */     if (argDate != null) {
/*  95 */       dateString = argIncludeTime ? DateUtils.formatIsoDateTime(argDate) : DateUtils.format(argDate);
/*     */     }
/*  97 */     return dateString;
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
/*     */   public static int toInt(Object argValue) {
/*     */     try {
/* 110 */       return Integer.valueOf(argValue.toString()).intValue();
/*     */     }
/* 112 */     catch (Exception ex) {
/* 113 */       _logger.debug("Could not parse [" + argValue + "] into an int.", ex);
/* 114 */       return Integer.MIN_VALUE;
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
/*     */   public static long toLong(Object argValue) {
/*     */     try {
/* 128 */       return Long.valueOf(argValue.toString()).longValue();
/*     */     }
/* 130 */     catch (Exception ex) {
/* 131 */       _logger.debug("Could not parse [" + argValue + "] into a long.", ex);
/* 132 */       return -2147483648L;
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
/*     */   public static String toObscuredString(Object argValue) {
/* 145 */     return toObscuredString(argValue, false);
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
/*     */   public static String toObscuredString(Object argValue, boolean argFullyObscure) {
/* 160 */     return argFullyObscure ? toObscuredString(argValue, 0, true) : toObscuredString(argValue, 4, true);
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
/*     */   public static String toObscuredString(Object argValue, int argExposeLength, boolean argExposeEnd) {
/* 176 */     String obscuredValue = null;
/*     */     
/* 178 */     if (argValue != null) {
/* 179 */       String valueString = argValue.toString();
/* 180 */       obscuredValue = valueString;
/*     */       
/* 182 */       int exposeLength = Math.min(argExposeLength, valueString.length());
/* 183 */       int obscureLength = valueString.length() - exposeLength;
/*     */       
/* 185 */       if (obscureLength > 0) {
/* 186 */         if (argExposeEnd) {
/* 187 */           obscuredValue = StringUtils.fill('*', obscureLength);
/* 188 */           if (exposeLength > 0) {
/* 189 */             obscuredValue = obscuredValue + valueString.substring(obscureLength);
/*     */           }
/*     */         } else {
/*     */           
/* 193 */           if (exposeLength > 0) {
/* 194 */             obscuredValue = valueString.substring(0, exposeLength);
/*     */           }
/* 196 */           obscuredValue = obscuredValue + StringUtils.fill('*', obscureLength);
/*     */         } 
/*     */       }
/*     */     } 
/* 200 */     return obscuredValue;
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
/*     */   public static String toSafeString(Object argValue) {
/* 213 */     return (argValue == null) ? null : String.valueOf(argValue);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\DataServiceUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */