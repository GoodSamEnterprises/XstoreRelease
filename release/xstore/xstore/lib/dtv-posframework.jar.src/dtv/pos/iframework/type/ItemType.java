/*     */ package dtv.pos.iframework.type;
/*     */ 
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
/*     */ public class ItemType
/*     */ {
/*  19 */   private static final Logger logger_ = Logger.getLogger(ItemType.class);
/*     */ 
/*     */   
/*  22 */   public static final ItemType NON_PHYSICAL = new ItemType("NON_PHYSICAL");
/*     */   
/*  24 */   public static final ItemType STANDARD = new ItemType("STANDARD");
/*     */   
/*  26 */   public static final ItemType DUMMY = new ItemType("DUMMY");
/*     */   
/*  28 */   public static final ItemType NOT_ON_FILE = new ItemType("NOT_ON_FILE");
/*     */   
/*  30 */   public static final ItemType KIT = new ItemType("KIT");
/*     */   
/*  32 */   public static final ItemType TRADEIN = new ItemType("TRADEIN");
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, ItemType> values_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemType forName(String argName) {
/*  44 */     if (argName == null) {
/*  45 */       return null;
/*     */     }
/*  47 */     ItemType found = values_.get(argName.trim().toUpperCase());
/*  48 */     if (found == null) {
/*  49 */       logger_.warn("There is no instance of [" + ItemType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  52 */     return found;
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
/*     */   private ItemType(String argName) {
/*  64 */     this.name_ = argName.trim().toUpperCase();
/*  65 */     if (values_ == null) {
/*  66 */       values_ = new HashMap<>();
/*     */     }
/*  68 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  77 */     return this.name_;
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
/*     */   public boolean matches(String argName) {
/*  89 */     if (argName == null) {
/*  90 */       return false;
/*     */     }
/*  92 */     return this.name_.equalsIgnoreCase(argName.trim());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\ItemType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */