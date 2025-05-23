/*    */ package dtv.data2.security;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
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
/*    */ public class SecurityThreadContextConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private final Collection<String> allow_ = new HashSet<>();
/* 25 */   private final Collection<String> deny_ = new HashSet<>();
/* 26 */   private final Collection<String> ignore_ = new HashSet<>();
/*    */   
/* 28 */   private String name_ = null;
/*    */   
/*    */   public boolean allowed(StackTraceElement argStackTraceElement) {
/* 31 */     String callingMethod = argStackTraceElement.getClassName() + "#" + argStackTraceElement.getMethodName();
/* 32 */     for (String s : this.deny_) {
/* 33 */       if (callingMethod.startsWith(s)) {
/* 34 */         return false;
/*    */       }
/*    */     } 
/* 37 */     for (String s : this.allow_) {
/* 38 */       if (callingMethod.startsWith(s)) {
/* 39 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 47 */     return this.name_;
/*    */   }
/*    */   
/*    */   public boolean ignored(StackTraceElement argStackTraceElement) {
/* 51 */     if (argStackTraceElement.getClassName().equals(DtvSecurityManager.class.getName())) {
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     String callingMethod = argStackTraceElement.getClassName() + "#" + argStackTraceElement.getMethodName();
/* 56 */     for (String s : this.ignore_) {
/* 57 */       if (callingMethod.startsWith(s)) {
/* 58 */         return true;
/*    */       }
/*    */     } 
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public void merge(SecurityThreadContextConfig argOther) {
/* 65 */     if (argOther != null) {
/* 66 */       if (!argOther.getName().equals(getName())) {
/* 67 */         throw new IllegalArgumentException();
/*    */       }
/* 69 */       this.allow_.addAll(argOther.allow_);
/* 70 */       this.deny_.addAll(argOther.deny_);
/* 71 */       this.ignore_.addAll(argOther.ignore_);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 78 */     if ("allow".equalsIgnoreCase(argKey)) {
/* 79 */       this.allow_.add(argValue.toString());
/*    */     }
/* 81 */     else if ("deny".equalsIgnoreCase(argKey)) {
/* 82 */       this.deny_.add(argValue.toString());
/*    */     }
/* 84 */     else if ("ignore".equalsIgnoreCase(argKey)) {
/* 85 */       this.ignore_.add(argValue.toString());
/*    */     }
/* 87 */     else if ("name".equals(argKey)) {
/* 88 */       this.name_ = argValue.toString();
/*    */     } else {
/*    */       
/* 91 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\security\SecurityThreadContextConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */