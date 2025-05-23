/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import dtv.util.StringUtils;
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
/*    */ 
/*    */ 
/*    */ public class DtxInverseRelationship
/*    */ {
/*    */   private String name_;
/*    */   private DtxDefinition parent_;
/*    */   private String parentType_;
/*    */   
/*    */   public String getGetMethodName() {
/* 26 */     return "get" + StringUtils.ensureFirstUpperCase(getName());
/*    */   }
/*    */   
/*    */   public String getName() {
/* 30 */     return this.name_;
/*    */   }
/*    */   
/*    */   public DtxDefinition getParent() {
/* 34 */     return this.parent_;
/*    */   }
/*    */   
/*    */   public String getParentType() {
/* 38 */     return this.parentType_;
/*    */   }
/*    */   
/*    */   public String getSetMethodName() {
/* 42 */     return "set" + StringUtils.ensureFirstUpperCase(getName());
/*    */   }
/*    */   
/*    */   public void setName(String argName) {
/* 46 */     this.name_ = argName;
/*    */   }
/*    */   
/*    */   public void setParent(DtxDefinition argParent) {
/* 50 */     this.parent_ = argParent;
/*    */   }
/*    */   
/*    */   public void setParentType(String argParentType) {
/* 54 */     this.parentType_ = argParentType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void validate() {
/* 63 */     if (StringUtils.isEmpty(getName())) {
/* 64 */       throw new RuntimeException("InverseRelationship does not define a name.");
/*    */     }
/* 66 */     if (StringUtils.isEmpty(getParentType()))
/* 67 */       throw new RuntimeException("InverseRelationship: " + getName() + " does not define a parent."); 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DtxInverseRelationship.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */