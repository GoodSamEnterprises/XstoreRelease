/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import java.io.File;
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
/*     */ public class DaoGenTargetHelper
/*     */ {
/*     */   public static String getClassName(Class<?> argClazz, String argDefault) {
/*  25 */     String retVal = null;
/*  26 */     if (argClazz == null) {
/*  27 */       return argDefault;
/*     */     }
/*  29 */     retVal = System.getProperty(argClazz.getName());
/*  30 */     if (retVal == null || retVal.length() == 0) {
/*  31 */       return argDefault;
/*     */     }
/*  33 */     int i = retVal.lastIndexOf(".");
/*  34 */     if (i < 0) {
/*  35 */       return retVal;
/*     */     }
/*  37 */     return retVal.substring(i + 1, retVal.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDirectoryName(Class<?> argClazz, String argDefault) {
/*  48 */     if (argClazz == null) {
/*  49 */       return argDefault;
/*     */     }
/*  51 */     String retVal = System.getProperty(argClazz.getName());
/*  52 */     if (retVal == null || retVal.length() == 0) {
/*  53 */       return argDefault;
/*     */     }
/*  55 */     int i = retVal.lastIndexOf(".");
/*  56 */     if (i < 0) {
/*  57 */       return File.separator;
/*     */     }
/*  59 */     retVal = File.separator + retVal.substring(0, i + 1).replace(".", File.separator);
/*  60 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFileName(Class<?> argClazz, String argDefault) {
/*  71 */     if (argDefault == null) {
/*  72 */       return argDefault;
/*     */     }
/*     */     
/*  75 */     String temp = argDefault.replace(".java", "");
/*  76 */     String name = getClassName(argClazz, temp);
/*  77 */     if (name != null) {
/*  78 */       return name + ".java";
/*     */     }
/*  80 */     return argDefault;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPackageName(Class<?> argClazz, String argDefault) {
/*  91 */     String retVal = "";
/*  92 */     if (argClazz == null) {
/*  93 */       return argDefault;
/*     */     }
/*  95 */     String name = System.getProperty(argClazz.getName());
/*  96 */     if (name == null || name.length() == 0) {
/*  97 */       return argDefault;
/*     */     }
/*  99 */     int i = name.lastIndexOf(".");
/* 100 */     if (i >= 0) {
/* 101 */       retVal = name.substring(0, i);
/*     */     }
/* 103 */     return retVal;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DaoGenTargetHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */