/*     */ package dtv.pos.iframework.action;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public final class FormTabKey
/*     */   implements IXstActionKey
/*     */ {
/*     */   private static final long serialVersionUID = -4394943265186436964L;
/*  20 */   public static final FormTabKey DEFAULT = new FormTabKey("DEFAULT");
/*     */   
/*  22 */   public static final FormTabKey NEXT_PAGE = new FormTabKey("NEXT_PAGE");
/*     */   
/*  24 */   public static final FormTabKey PREVIOUS_PAGE = new FormTabKey("PREVIOUS_PAGE");
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, FormTabKey> values_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */ 
/*     */   
/*     */   public static FormTabKey forName(String argName) {
/*  36 */     if (argName == null) {
/*  37 */       return null;
/*     */     }
/*  39 */     FormTabKey found = values_.get(argName.trim().toUpperCase());
/*  40 */     if (found == null) {
/*  41 */       found = new FormTabKey(argName);
/*     */     }
/*  43 */     return found;
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
/*     */   private FormTabKey(String argName) {
/*  55 */     this.name_ = argName.trim().toUpperCase();
/*  56 */     if (values_ == null) {
/*  57 */       values_ = new HashMap<>();
/*     */     }
/*  59 */     values_.put(this.name_, this);
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
/*  70 */     return (argObject instanceof FormTabKey && ((FormTabKey)argObject).name_.equals(this.name_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstActionKey get(String key) {
/*  81 */     return forName(key);
/*     */   }
/*     */   
/*     */   public String getName() {
/*  85 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  95 */     return this.name_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String argName) {
/* 106 */     return getName().equalsIgnoreCase(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 116 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\FormTabKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */