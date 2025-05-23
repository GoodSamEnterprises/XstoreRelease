/*     */ package dtv.data2.access.pm;
/*     */ 
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import java.io.Serializable;
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
/*     */ public class PersistenceManagerType
/*     */   implements Comparable<IPersistenceMgrType>, Serializable, IPersistenceMgrType
/*     */ {
/*     */   public static final String PM_TYPE_PROPERTY = "dtv.data.access.PersistenceManagerType";
/*  25 */   private static final Logger logger_ = Logger.getLogger(PersistenceManagerType.class);
/*     */   
/*     */   private static final long serialVersionUID = -6279059104161422598L;
/*     */   private static Map<String, PersistenceManagerType> values_;
/*  29 */   private static PersistenceManagerType[] sortedInstances_ = null;
/*     */   
/*     */   static {
/*     */     try {
/*  33 */       String className = System.getProperty("dtv.data.access.PersistenceManagerType", PersistenceManagerType.class.getName());
/*  34 */       if (className == null) {
/*  35 */         logger_.error("No PersistenceManagerType implementation defined with property dtv.data.access.PersistenceManagerType");
/*     */       }
/*     */       
/*  38 */       PersistenceManagerType.class.getClassLoader().loadClass(className);
/*     */     }
/*  40 */     catch (Exception ex) {
/*  41 */       logger_.error("Unable to load persistence manager base type ", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static PersistenceManagerType forName(String argName) {
/*  52 */     if (argName == null) {
/*  53 */       throw new DtxException("PersistenceManagerType.forName(String) cannot accept null argName.  Please provide a PM type name. (e.g. \"TRANSACTION\", \"INVENTORY\", etc.");
/*     */     }
/*     */ 
/*     */     
/*  57 */     String name = argName.trim();
/*     */     
/*  59 */     if (values_ == null) {
/*  60 */       values_ = new HashMap<>();
/*     */     }
/*  62 */     PersistenceManagerType found = values_.get(name);
/*     */     
/*  64 */     if (found == null) {
/*  65 */       found = new PersistenceManagerType(name);
/*     */     }
/*  67 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PersistenceManagerType[] getInstances() {
/*  76 */     if (sortedInstances_ == null) {
/*  77 */       PersistenceManagerType[] instances = new PersistenceManagerType[values_.size()];
/*  78 */       instances = (PersistenceManagerType[])values_.values().toArray((Object[])instances);
/*  79 */       Arrays.sort((Object[])instances);
/*  80 */       sortedInstances_ = instances;
/*     */     } 
/*  82 */     return sortedInstances_;
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
/*     */   protected PersistenceManagerType(String argName) {
/*  94 */     this.name_ = argName.trim();
/*  95 */     if (values_ == null) {
/*  96 */       values_ = new HashMap<>();
/*     */     }
/*  98 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(IPersistenceMgrType other) {
/* 103 */     return getName().compareTo(other.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object other) {
/* 108 */     if (!(other instanceof PersistenceManagerType)) {
/* 109 */       return false;
/*     */     }
/* 111 */     return this.name_.equals(((PersistenceManagerType)other).getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 120 */     return this.name_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return this.name_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object readResolve() {
/* 140 */     return forName(this.name_);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\PersistenceManagerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */