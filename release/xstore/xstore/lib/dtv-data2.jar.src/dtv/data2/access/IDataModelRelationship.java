/*    */ package dtv.data2.access;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IDataModelRelationship
/*    */ {
/*    */   Class<? extends Object> getChild();
/*    */   
/*    */   String getIdentifier();
/*    */   
/*    */   IDataModel getParent();
/*    */   
/*    */   RelationshipType getType();
/*    */   
/*    */   boolean isPropertyRelationship();
/*    */   
/*    */   boolean isTransientRelationship();
/*    */   
/*    */   boolean isUseParentPm();
/*    */   
/*    */   void setParent(IDataModel paramIDataModel);
/*    */   
/*    */   public enum RelationshipType
/*    */   {
/* 66 */     MANY_TO_MANY("MANY-MANY"), ONE_TO_MANY("ONE-MANY"), ONE_TO_ONE("ONE-ONE");
/*    */     private final String toString_;
/*    */     
/*    */     RelationshipType(String s) {
/* 70 */       this.toString_ = s;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public String toString() {
/* 76 */       return this.toString_;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataModelRelationship.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */