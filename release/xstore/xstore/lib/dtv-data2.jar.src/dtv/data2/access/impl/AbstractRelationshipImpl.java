/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRelationshipImpl
/*    */   implements IDataModelRelationshipImpl
/*    */ {
/*    */   private final boolean useParentPm_;
/*    */   private final String identifier_;
/*    */   private final Class<? extends Object> child_;
/*    */   private IDataModelImpl parent_;
/*    */   private final boolean propertyRelationship_;
/*    */   private final boolean transientRelationship_;
/*    */   
/*    */   protected AbstractRelationshipImpl(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argPropertyRelationship, boolean argTransientRelationship) {
/* 34 */     this.identifier_ = argIdentifier;
/* 35 */     this.child_ = argChild;
/* 36 */     this.useParentPm_ = argUseParentPm;
/* 37 */     this.propertyRelationship_ = argPropertyRelationship;
/* 38 */     this.transientRelationship_ = argTransientRelationship;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<? extends Object> getChild() {
/* 48 */     return this.child_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getIdentifier() {
/* 56 */     return this.identifier_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IDataModel getParent() {
/* 62 */     return this.parent_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPropertyRelationship() {
/* 68 */     return this.propertyRelationship_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isTransientRelationship() {
/* 74 */     return this.transientRelationship_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUseParentPm() {
/* 80 */     return this.useParentPm_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParent(IDataModel argOwner) {
/* 89 */     this.parent_ = (IDataModelImpl)argOwner;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\AbstractRelationshipImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */