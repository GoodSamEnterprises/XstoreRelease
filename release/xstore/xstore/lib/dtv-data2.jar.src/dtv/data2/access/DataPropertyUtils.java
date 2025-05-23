/*     */ package dtv.data2.access;
/*     */ 
/*     */ import java.math.BigDecimal;
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
/*     */ public class DataPropertyUtils
/*     */ {
/*  22 */   private static final Logger _logger = Logger.getLogger(DataPropertyUtils.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getPropertyValue(IHasDataProperty<?> argParent, String argCode) {
/*  33 */     IDataProperty prop = (IDataProperty)argParent.getProperty(argCode);
/*  34 */     return (prop == null) ? null : prop.getPropertyValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPropertyValueType(Object argValue) {
/*  45 */     String valueType = null;
/*     */     
/*  47 */     if (argValue instanceof Boolean) {
/*  48 */       valueType = "BOOLEAN";
/*     */     }
/*  50 */     else if (argValue instanceof Date) {
/*  51 */       valueType = "DATE";
/*     */     }
/*  53 */     else if (argValue instanceof BigDecimal) {
/*  54 */       valueType = "BIGDECIMAL";
/*     */     }
/*  56 */     else if (argValue instanceof String) {
/*  57 */       valueType = "STRING";
/*     */     } 
/*  59 */     return valueType;
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
/*     */   public static void setPropertyValue(IHasDataProperty<?> argParent, String argCode, Object argValue) {
/*  71 */     IDataProperty prop = (IDataProperty)argParent.getProperty(argCode);
/*     */     
/*  73 */     if (prop != null) {
/*  74 */       prop.setPropertyValue(argValue);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  80 */       String valueType = getPropertyValueType(argValue);
/*     */       
/*  82 */       if ("BOOLEAN".equalsIgnoreCase(valueType)) {
/*  83 */         argParent.setBooleanProperty(argCode, ((Boolean)argValue).booleanValue());
/*     */       }
/*  85 */       else if ("DATE".equalsIgnoreCase(valueType)) {
/*  86 */         argParent.setDateProperty(argCode, (Date)argValue);
/*     */       }
/*  88 */       else if ("BIGDECIMAL".equalsIgnoreCase(valueType)) {
/*  89 */         argParent.setDecimalProperty(argCode, (BigDecimal)argValue);
/*     */       }
/*  91 */       else if ("STRING".equalsIgnoreCase(valueType)) {
/*  92 */         argParent.setStringProperty(argCode, (String)argValue);
/*     */       }
/*  94 */       else if (argValue != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  99 */         _logger.warn("[" + argValue + "] is not of a supported type to assign to model [" + argParent + "].  Converting the value to a string and assigning it as such,  though the calling client should be performing this conversion explicitly.");
/*     */ 
/*     */ 
/*     */         
/* 103 */         argParent.setStringProperty(argCode, argValue.toString());
/* 104 */         valueType = "STRING";
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DataPropertyUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */