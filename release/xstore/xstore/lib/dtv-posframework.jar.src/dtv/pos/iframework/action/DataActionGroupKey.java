/*     */ package dtv.pos.iframework.action;
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
/*     */ public final class DataActionGroupKey
/*     */   implements Comparable<DataActionGroupKey>
/*     */ {
/*  22 */   private static final Logger logger_ = Logger.getLogger(DataActionGroupKey.class);
/*     */ 
/*     */ 
/*     */   
/*  26 */   public static final DataActionGroupKey DEFAULT = new DataActionGroupKey("DEFAULT");
/*     */   
/*  28 */   public static final DataActionGroupKey NO_SKIP = new DataActionGroupKey("NO_SKIP");
/*     */   
/*  30 */   public static final DataActionGroupKey EDIT = new DataActionGroupKey("EDIT");
/*     */   
/*  32 */   public static final DataActionGroupKey VIEW = new DataActionGroupKey("VIEW");
/*     */   
/*  34 */   public static final DataActionGroupKey AUDIT = new DataActionGroupKey("AUDIT");
/*     */   
/*  36 */   public static final DataActionGroupKey WITH_TRAN = new DataActionGroupKey("WITH_TRAN");
/*     */   
/*  38 */   public static final DataActionGroupKey NO_ADD = new DataActionGroupKey("NO_ADD");
/*     */   
/*  40 */   public static final DataActionGroupKey ADD = new DataActionGroupKey("ADD");
/*     */   
/*  42 */   public static final DataActionGroupKey CANCEL_ON_ESCAPE = new DataActionGroupKey("CANCEL_ON_ESCAPE");
/*     */   
/*  44 */   public static final DataActionGroupKey VIEW_FULFILLMENT_QUEUE = new DataActionGroupKey("VIEW_FULFILLMENT_QUEUE");
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, DataActionGroupKey> values_;
/*     */ 
/*     */ 
/*     */   
/*     */   private static DataActionGroupKey[] sortedInstances_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataActionGroupKey createForName(String argName) {
/*  60 */     return forName(argName, true, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataActionGroupKey forName(IConfigObject argName) {
/*  70 */     return forName(argName.toString(), false, argName.getSourceDescription());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final DataActionGroupKey forName(String argName) {
/*  80 */     return forName(argName, false, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final DataActionGroupKey[] getInstances() {
/*  89 */     if (sortedInstances_ == null) {
/*  90 */       sortedInstances_ = (DataActionGroupKey[])values_.values().toArray((Object[])new DataActionGroupKey[0]);
/*  91 */       Arrays.sort((Object[])sortedInstances_);
/*     */     } 
/*  93 */     return sortedInstances_;
/*     */   }
/*     */   
/*     */   private static DataActionGroupKey forName(String argName, boolean argCreate, String argSourceDescription) {
/*  97 */     if (argName == null) {
/*  98 */       return null;
/*     */     }
/* 100 */     String name = argName.toString().trim().toUpperCase();
/* 101 */     DataActionGroupKey found = values_.get(name);
/* 102 */     if (found == null) {
/* 103 */       if (argCreate) {
/* 104 */         found = new DataActionGroupKey(argName);
/*     */       } else {
/*     */         
/* 107 */         logger_.warn("There is no instance of [" + DataActionGroupKey.class.getName() + "] named [" + argName + "]:" + argSourceDescription);
/*     */       } 
/*     */     }
/*     */     
/* 111 */     return found;
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
/*     */   private DataActionGroupKey(String argName) {
/* 123 */     this.name_ = argName.trim().toUpperCase();
/* 124 */     if (values_ == null) {
/* 125 */       values_ = new HashMap<>();
/*     */     }
/* 127 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(DataActionGroupKey other) {
/* 138 */     return this.name_.compareTo(other.name_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObject) {
/* 149 */     boolean equals = false;
/* 150 */     if (argObject instanceof DataActionGroupKey) {
/* 151 */       equals = ((DataActionGroupKey)argObject).name_.equals(this.name_);
/*     */     }
/* 153 */     return equals;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 163 */     return this.name_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 173 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\DataActionGroupKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */