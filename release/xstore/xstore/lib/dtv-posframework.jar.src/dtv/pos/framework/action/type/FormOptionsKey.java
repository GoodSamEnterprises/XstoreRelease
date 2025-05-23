/*    */ package dtv.pos.framework.action.type;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstActionKey;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormOptionsKey
/*    */   implements IXstActionKey
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 23 */   private static Map<String, FormOptionsKey> values_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static FormOptionsKey valueOf(String argName) {
/* 32 */     if (argName == null) {
/* 33 */       return null;
/*    */     }
/*    */     
/* 36 */     FormOptionsKey found = values_.get(argName.trim().toUpperCase());
/*    */     
/* 38 */     if (found == null) {
/* 39 */       found = new FormOptionsKey(argName);
/*    */     }
/*    */     
/* 42 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private FormOptionsKey(String argName) {
/* 53 */     this.name_ = argName.trim().toUpperCase();
/* 54 */     values_.put(this.name_, this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObject) {
/* 60 */     return (argObject instanceof FormOptionsKey && ((FormOptionsKey)argObject).name_.equals(this.name_));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IXstActionKey get(String key) {
/* 66 */     return valueOf(key);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 70 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     return this.name_.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(String argName) {
/* 87 */     return getName().equalsIgnoreCase(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 93 */     return this.name_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\FormOptionsKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */