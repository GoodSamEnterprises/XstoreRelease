/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public final class SecuredObjectID
/*    */   implements ISecuredObjectID
/*    */ {
/* 21 */   public static final SecuredObjectID DEFAULT = new SecuredObjectID("DEFAULT");
/*    */ 
/*    */   
/* 24 */   public static final SecuredObjectID CUSTOMER_ID = new SecuredObjectID("CUSTOMER_ID");
/* 25 */   public static final SecuredObjectID CUSTOMER_ATTRIBUTES = new SecuredObjectID("CUSTOMER_ATTRIBUTES");
/* 26 */   public static final SecuredObjectID CUSTOMER_CONTACT_INFO = new SecuredObjectID("CUSTOMER_CONTACT_INFO");
/* 27 */   public static final SecuredObjectID CUSTOMER_FINANCIAL_INFO = new SecuredObjectID("CUSTOMER_FINANCIAL_INFO");
/*    */   
/* 29 */   public static final SecuredObjectID CUSTOMER_LEVEL = new SecuredObjectID("CUSTOMER_LEVEL");
/* 30 */   public static final SecuredObjectID CUSTOMER_LEGAL_STATUS = new SecuredObjectID("CUSTOMER_LEGAL_STATUS");
/* 31 */   public static final SecuredObjectID CUSTOMER_GROUPS = new SecuredObjectID("CUSTOMER_GROUPS");
/* 32 */   public static final SecuredObjectID CUSTOMER_EMPLOYEE_DATA = new SecuredObjectID("CUSTOMER_EMPLOYEE_DATA");
/*    */   
/* 34 */   public static final SecuredObjectID EMPLOYEE_DATA = new SecuredObjectID("EMPLOYEE_DATA");
/* 35 */   public static final SecuredObjectID EMPLOYEE_NOTE = new SecuredObjectID("EMPLOYEE_NOTE");
/* 36 */   public static final SecuredObjectID EMPLOYEE_LOCKOUT = new SecuredObjectID("EMPLOYEE_LOCKOUT");
/* 37 */   public static final SecuredObjectID EMPLOYEE_SECURITY = new SecuredObjectID("EMPLOYEE_SECURITY");
/*    */ 
/*    */ 
/*    */   
/* 41 */   public static final SecuredObjectID ADMINISTRATIVE_WORK_CODE = new SecuredObjectID("ADMINISTRATIVE_WORK_CODE");
/*    */ 
/*    */   
/*    */   private static Map<String, SecuredObjectID> values_;
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */   
/*    */   public static SecuredObjectID forName(IConfigObject argName) {
/* 50 */     return forName(argName.toString());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SecuredObjectID forName(String argName) {
/* 60 */     if (argName == null) {
/* 61 */       return null;
/*    */     }
/* 63 */     String name = argName.trim().toUpperCase();
/* 64 */     SecuredObjectID found = values_.get(name);
/* 65 */     if (found == null) {
/* 66 */       found = new SecuredObjectID(argName);
/*    */     }
/* 68 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private SecuredObjectID(String argName) {
/* 80 */     this.name_ = argName.trim().toUpperCase();
/* 81 */     if (values_ == null) {
/* 82 */       values_ = new HashMap<>();
/*    */     }
/* 84 */     values_.put(this.name_, this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 88 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 98 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\SecuredObjectID.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */