/*     */ package dtv.pos.framework.action.type;
/*     */ 
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
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
/*     */ public class ActionType
/*     */   implements Comparable<ActionType>
/*     */ {
/*  22 */   private static final Logger logger_ = Logger.getLogger(ActionType.class);
/*     */ 
/*     */   
/*  25 */   public static ActionType DATA = new ActionType("DataAction", (Class)XstDataActionKey.class, (IXstActionKey)XstDataActionKey.ACCEPT, null);
/*     */   
/*  27 */   public static ActionType CHAIN = new ActionType("OpChain", (Class)OpChainKey.class, 
/*  28 */       (IXstActionKey)OpChainKey.valueOf("DO_NOTHING"), (IXstActionType)XstChainActionType.STACK);
/*  29 */   public static ActionType FORM_TAB = new ActionType("FormTabKey", (Class)FormTabKey.class, (IXstActionKey)FormTabKey.DEFAULT, null);
/*     */   
/*     */   private static Map<String, ActionType> valuesByName_;
/*     */   
/*     */   private static Map<Class<? extends IXstActionKey>, ActionType> valuesByClass_;
/*     */   
/*     */   private static ActionType[] sortedInstances_;
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final Class<? extends IXstActionKey> actionClass_;
/*     */   
/*     */   private final IXstActionKey defaultKey_;
/*     */   private final IXstActionType defaultType_;
/*     */   
/*     */   public static ActionType forActionKey(IXstActionKey argKey) {
/*  45 */     if (argKey == null) {
/*  46 */       return null;
/*     */     }
/*     */     
/*  49 */     return forClass(argKey.getClass());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ActionType forClass(Class<?> argClass) {
/*  59 */     if (argClass == null) {
/*  60 */       return null;
/*     */     }
/*  62 */     ActionType found = valuesByClass_.get(argClass);
/*  63 */     if (found == null) {
/*  64 */       logger_.warn("There is no instance of [" + ActionType.class.getName() + "] for " + argClass + ".", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  67 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ActionType forName(String argName) {
/*  77 */     if (argName == null) {
/*  78 */       return null;
/*     */     }
/*  80 */     ActionType found = valuesByName_.get(argName.trim());
/*  81 */     if (found == null) {
/*  82 */       logger_.warn("There is no instance of [" + ActionType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  85 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ActionType[] getInstances() {
/*  94 */     if (sortedInstances_ == null) {
/*  95 */       sortedInstances_ = (ActionType[])valuesByName_.values().toArray((Object[])new ActionType[0]);
/*  96 */       Arrays.sort((Object[])sortedInstances_);
/*     */     } 
/*  98 */     return sortedInstances_;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ActionType(String argName, Class<? extends IXstActionKey> argActionClass, IXstActionKey argDefaultKey, IXstActionType argDefaultType) {
/* 121 */     this.name_ = argName.trim();
/* 122 */     this.actionClass_ = argActionClass;
/* 123 */     this.defaultKey_ = argDefaultKey;
/* 124 */     this.defaultType_ = argDefaultType;
/* 125 */     if (valuesByName_ == null) {
/* 126 */       valuesByName_ = new HashMap<>();
/* 127 */       valuesByClass_ = new HashMap<>();
/*     */     } 
/* 129 */     valuesByName_.put(this.name_, this);
/* 130 */     valuesByClass_.put(this.actionClass_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ActionType other) {
/* 136 */     return this.name_.compareTo(other.name_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends IXstActionKey> getActionClass() {
/* 144 */     return this.actionClass_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey getDefaultKey() {
/* 152 */     return this.defaultKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionType getDefaultType() {
/* 160 */     return this.defaultType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 170 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\ActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */