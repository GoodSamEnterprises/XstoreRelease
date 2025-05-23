/*     */ package dtv.pos.iframework.ui;
/*     */ 
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
/*     */ public final class TableLayoutVerticalAlignment
/*     */   implements Comparable<TableLayoutVerticalAlignment>
/*     */ {
/*  21 */   private static final Logger logger_ = Logger.getLogger(TableLayoutVerticalAlignment.class);
/*     */ 
/*     */   
/*  24 */   public static final TableLayoutVerticalAlignment TOP = new TableLayoutVerticalAlignment("TOP", 0);
/*     */   
/*  26 */   public static final TableLayoutVerticalAlignment BOTTOM = new TableLayoutVerticalAlignment("BOTTOM", 3);
/*     */   
/*  28 */   public static final TableLayoutVerticalAlignment CENTER = new TableLayoutVerticalAlignment("CENTER", 1);
/*     */   
/*  30 */   public static final TableLayoutVerticalAlignment FULL = new TableLayoutVerticalAlignment("FULL", 2);
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, TableLayoutVerticalAlignment> values_;
/*     */ 
/*     */   
/*  37 */   private static TableLayoutVerticalAlignment[] sortedInstances_ = null;
/*  38 */   private static TableLayoutVerticalAlignment[] sortedInstancesPlusNull_ = null;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final int value_;
/*     */ 
/*     */   
/*     */   public static TableLayoutVerticalAlignment forName(String argName) {
/*  47 */     if (argName == null) {
/*  48 */       return null;
/*     */     }
/*  50 */     TableLayoutVerticalAlignment t = values_.get(argName.trim().toUpperCase());
/*  51 */     if (t == null) {
/*  52 */       logger_.warn("There is no instance of [" + TableLayoutVerticalAlignment.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  55 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TableLayoutVerticalAlignment[] getInstances() {
/*  64 */     return getInstances(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TableLayoutVerticalAlignment[] getInstances(boolean includeNull) {
/*  73 */     if (sortedInstances_ == null) {
/*     */       
/*  75 */       TableLayoutVerticalAlignment[] sortedInstances = (TableLayoutVerticalAlignment[])values_.values().toArray((Object[])new TableLayoutVerticalAlignment[0]);
/*  76 */       Arrays.sort((Object[])sortedInstances);
/*     */       
/*  78 */       TableLayoutVerticalAlignment[] sortedInstancesPlusNull = new TableLayoutVerticalAlignment[sortedInstances.length + 1];
/*     */       
/*  80 */       sortedInstancesPlusNull[0] = null;
/*  81 */       System.arraycopy(sortedInstances, 0, sortedInstancesPlusNull, 1, sortedInstances.length);
/*  82 */       sortedInstances_ = sortedInstances;
/*  83 */       sortedInstancesPlusNull_ = sortedInstancesPlusNull;
/*     */     } 
/*  85 */     if (includeNull) {
/*  86 */       return sortedInstancesPlusNull_;
/*     */     }
/*     */     
/*  89 */     return sortedInstances_;
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
/*     */   private TableLayoutVerticalAlignment(String argName, int argValue) {
/* 104 */     this.name_ = argName.trim().toUpperCase();
/* 105 */     this.value_ = argValue;
/* 106 */     if (values_ == null) {
/* 107 */       values_ = new HashMap<>();
/*     */     }
/* 109 */     values_.put("" + this.name_.charAt(0), this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(TableLayoutVerticalAlignment other) {
/* 115 */     return this.name_.compareTo(other.name_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValue() {
/* 123 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\TableLayoutVerticalAlignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */