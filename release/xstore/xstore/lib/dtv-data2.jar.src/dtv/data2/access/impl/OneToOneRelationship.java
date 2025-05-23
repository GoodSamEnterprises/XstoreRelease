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
/*    */ 
/*    */ public class OneToOneRelationship
/*    */   extends AbstractRelationshipImpl
/*    */ {
/*    */   public OneToOneRelationship(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argTransientRelationship) {
/* 31 */     super(argIdentifier, argChild, argUseParentPm, false, argTransientRelationship);
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
/*    */   public OneToOneRelationship(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argPropertyRelationship, boolean argTransientRelationship) {
/* 48 */     super(argIdentifier, argChild, argUseParentPm, argTransientRelationship, argPropertyRelationship);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final IDataModelRelationship.RelationshipType getType() {
/* 58 */     return IDataModelRelationship.RelationshipType.ONE_TO_ONE;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\OneToOneRelationship.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */