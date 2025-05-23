/*     */ package dtv.pos.iframework.ui;
/*     */ 
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ 
/*     */ public enum FontStyle
/*     */ {
/*  21 */   DEFAULT("<default>", -1), BOLD("BOLD", 1), BOLDITALIC("BOLDITALIC", 3),
/*  22 */   ITALIC("ITALIC", 2), PLAIN("PLAIN", 0); private static final Logger logger_;
/*     */   static {
/*  24 */     logger_ = Logger.getLogger(FontStyle.class);
/*     */ 
/*     */ 
/*     */     
/*  28 */     valueToEnumMap_ = new HashMap<>();
/*  29 */     nameToEnumMap_ = new HashMap<>();
/*  30 */     sortedInstances_ = null;
/*     */ 
/*     */     
/*  33 */     for (FontStyle s : values()) {
/*  34 */       valueToEnumMap_.put(Integer.valueOf(s.intValue_), s);
/*  35 */       nameToEnumMap_.put(s.name_, s);
/*     */     } 
/*     */   }
/*     */   private static final int DEFAULT_INT_VALUE = -1; private static Map<Integer, FontStyle> valueToEnumMap_;
/*     */   private static Map<String, FontStyle> nameToEnumMap_;
/*     */   private static FontStyle[] sortedInstances_;
/*     */   private final String name_;
/*     */   private final int intValue_;
/*     */   
/*     */   public static FontStyle forName(IConfigObject argName) {
/*  45 */     if (argName == null) {
/*  46 */       return null;
/*     */     }
/*  48 */     FontStyle found = nameToEnumMap_.get(argName.toString().trim().toUpperCase());
/*  49 */     if (found == null) {
/*  50 */       logger_.warn("There is no instance of [" + FontStyle.class.getName() + "] named [" + argName + "]:" + argName
/*  51 */           .getSourceDescription());
/*  52 */       return DEFAULT;
/*     */     } 
/*  54 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FontStyle forName(String argName) {
/*  65 */     if (argName == null) {
/*  66 */       return DEFAULT;
/*     */     }
/*  68 */     FontStyle found = nameToEnumMap_.get(argName.trim().toUpperCase());
/*  69 */     if (found == null) {
/*  70 */       logger_.warn("There is no instance of [" + FontStyle.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */       
/*  72 */       return DEFAULT;
/*     */     } 
/*  74 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FontStyle forValue(int argIntValue) {
/*  85 */     Integer intObject = Integer.valueOf(argIntValue);
/*     */     
/*  87 */     FontStyle found = valueToEnumMap_.get(intObject);
/*  88 */     if (found == null) {
/*  89 */       logger_.warn("There is no instance of [" + FontStyle.class.getName() + "] for [" + intObject + "].", new Throwable("STACK TRACE"));
/*     */       
/*  91 */       return DEFAULT;
/*     */     } 
/*  93 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FontStyle[] getInstances() {
/* 101 */     if (sortedInstances_ == null) {
/* 102 */       sortedInstances_ = (FontStyle[])nameToEnumMap_.values().toArray((Object[])new FontStyle[0]);
/* 103 */       Arrays.sort((Object[])sortedInstances_);
/*     */     } 
/* 105 */     return sortedInstances_;
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
/*     */   FontStyle(String argName, int argIntValue) {
/* 119 */     this.name_ = argName.trim().toUpperCase();
/* 120 */     this.intValue_ = argIntValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFontStyle(int argDefaultStyle) {
/* 129 */     if (this.intValue_ == -1) {
/* 130 */       return argDefaultStyle;
/*     */     }
/*     */     
/* 133 */     return this.intValue_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFontStyleName(int argDefaultStyle) {
/* 143 */     if (this.intValue_ == -1) {
/* 144 */       switch (argDefaultStyle) {
/*     */         case 1:
/* 146 */           return "BOLD";
/*     */         case 2:
/* 148 */           return "ITALIC";
/*     */         case 3:
/* 150 */           return "BOLDITALIC";
/*     */       } 
/* 152 */       return "PLAIN";
/*     */     } 
/*     */ 
/*     */     
/* 156 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 165 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 171 */     return getName();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\FontStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */