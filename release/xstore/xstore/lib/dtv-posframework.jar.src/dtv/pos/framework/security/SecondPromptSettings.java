/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.pos.iframework.security.ISecondPromptSettings;
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
/*    */ public class SecondPromptSettings
/*    */   implements ISecondPromptSettings
/*    */ {
/*    */   public static final int REQUIRE_GRP_MEMBERSHIP_INT = 1;
/*    */   public static final int ANY_EMP_OK_INT = 2;
/*    */   public static final int NO_PROMPT_INT = 3;
/* 23 */   public static final ISecondPromptSettings REQUIRE_GRP_MEMBERSHIP = new SecondPromptSettings("REQUIRE_GRP_MEMBERSHIP", 1);
/*    */ 
/*    */   
/* 26 */   public static final ISecondPromptSettings ANY_EMP_OK = new SecondPromptSettings("ANY_EMP_OK", 2);
/*    */ 
/*    */   
/* 29 */   public static final ISecondPromptSettings NO_PROMPT = new SecondPromptSettings("NO_PROMPT", 3);
/*    */   
/*    */   private final String name_;
/*    */   
/*    */   private final int level_;
/*    */   
/*    */   protected SecondPromptSettings(String argName, int argLevel) {
/* 36 */     this.name_ = argName;
/* 37 */     this.level_ = argLevel;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(ISecondPromptSettings o) {
/* 42 */     if (o.getLevel() > this.level_) {
/* 43 */       return -1;
/*    */     }
/* 45 */     if (o.getLevel() < this.level_) {
/* 46 */       return 1;
/*    */     }
/*    */     
/* 49 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLevel() {
/* 55 */     return this.level_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 60 */     return this.name_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAnyEmpOk() {
/* 65 */     return (this.level_ == 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPrompt() {
/* 70 */     return (this.level_ != 3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRequireGroupMembership() {
/* 75 */     return (this.level_ == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 80 */     return getClass().getName() + "[" + this.name_ + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\SecondPromptSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */