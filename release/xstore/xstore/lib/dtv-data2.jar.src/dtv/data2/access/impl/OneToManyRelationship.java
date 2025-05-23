/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataModelRelationship;
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
/*    */ public class OneToManyRelationship
/*    */   extends AbstractRelationshipImpl
/*    */ {
/*    */   public OneToManyRelationship(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argTransientRelationship) {
/* 30 */     super(argIdentifier, argChild, argUseParentPm, false, argTransientRelationship);
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public OneToManyRelationship(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argPropertyRelationship, boolean argTransientRelationship) {
/* 47 */     super(argIdentifier, argChild, argUseParentPm, argTransientRelationship, argPropertyRelationship);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final IDataModelRelationship.RelationshipType getType() {
/* 57 */     return IDataModelRelationship.RelationshipType.ONE_TO_MANY;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\OneToManyRelationship.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */