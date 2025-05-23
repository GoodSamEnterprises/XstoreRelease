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
/*     */ public final class TableLayoutHorizontalAlignment
/*     */   implements Comparable<TableLayoutHorizontalAlignment>
/*     */ {
/*  21 */   private static final Logger logger_ = Logger.getLogger(TableLayoutHorizontalAlignment.class);
/*     */ 
/*     */ 
/*     */   
/*  25 */   public static final TableLayoutHorizontalAlignment LEFT = new TableLayoutHorizontalAlignment("LEFT", 0);
/*     */   
/*  27 */   public static final TableLayoutHorizontalAlignment RIGHT = new TableLayoutHorizontalAlignment("RIGHT", 3);
/*     */   
/*  29 */   public static final TableLayoutHorizontalAlignment CENTER = new TableLayoutHorizontalAlignment("CENTER", 1);
/*     */   
/*  31 */   public static final TableLayoutHorizontalAlignment FULL = new TableLayoutHorizontalAlignment("FULL", 2);
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, TableLayoutHorizontalAlignment> values_;
/*     */ 
/*     */   
/*  38 */   private static TableLayoutHorizontalAlignment[] sortedInstances_ = null;
/*  39 */   private static TableLayoutHorizontalAlignment[] sortedInstancesPlusNull_ = null;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final int value_;
/*     */ 
/*     */   
/*     */   public static TableLayoutHorizontalAlignment forName(String argName) {
/*  48 */     if (argName == null) {
/*  49 */       return null;
/*     */     }
/*  51 */     TableLayoutHorizontalAlignment found = values_.get(argName.trim().toUpperCase());
/*  52 */     if (found == null) {
/*  53 */       logger_.warn("There is no instance of [" + TableLayoutHorizontalAlignment.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  56 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TableLayoutHorizontalAlignment[] getInstances() {
/*  65 */     return getInstances(false);
/*     */   }
/*     */   
/*     */   public static TableLayoutHorizontalAlignment[] getInstances(boolean includeNull) {
/*  69 */     if (sortedInstances_ == null) {
/*     */       
/*  71 */       TableLayoutHorizontalAlignment[] sortedInstances = (TableLayoutHorizontalAlignment[])values_.values().toArray((Object[])new TableLayoutHorizontalAlignment[0]);
/*  72 */       Arrays.sort((Object[])sortedInstances);
/*     */       
/*  74 */       TableLayoutHorizontalAlignment[] sortedInstancesPlusNull = new TableLayoutHorizontalAlignment[sortedInstances.length + 1];
/*     */       
/*  76 */       sortedInstancesPlusNull[0] = null;
/*  77 */       System.arraycopy(sortedInstances, 0, sortedInstancesPlusNull, 1, sortedInstances.length);
/*  78 */       sortedInstances_ = sortedInstances;
/*  79 */       sortedInstancesPlusNull_ = sortedInstancesPlusNull;
/*     */     } 
/*  81 */     if (includeNull) {
/*  82 */       return sortedInstancesPlusNull_;
/*     */     }
/*     */     
/*  85 */     return sortedInstances_;
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
/*     */   private TableLayoutHorizontalAlignment(String argName, int argValue) {
/* 100 */     this.name_ = argName.trim().toUpperCase();
/* 101 */     this.value_ = argValue;
/* 102 */     if (values_ == null) {
/* 103 */       values_ = new HashMap<>();
/*     */     }
/* 105 */     values_.put("" + this.name_.charAt(0), this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(TableLayoutHorizontalAlignment other) {
/* 111 */     return this.name_.compareTo(other.name_);
/*     */   }
/*     */   
/*     */   public int getValue() {
/* 115 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\TableLayoutHorizontalAlignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */