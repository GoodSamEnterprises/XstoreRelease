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
/*    */ 
/*    */ public class ManyToManyRelationship
/*    */   extends AbstractRelationshipImpl
/*    */ {
/*    */   public ManyToManyRelationship(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argTransientRelationship) {
/* 32 */     super(argIdentifier, argChild, argUseParentPm, false, argTransientRelationship);
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
/*    */   public ManyToManyRelationship(String argIdentifier, Class<? extends Object> argChild, boolean argUseParentPm, boolean argPropertyRelationship, boolean argTransientRelationship) {
/* 49 */     super(argIdentifier, argChild, argUseParentPm, argTransientRelationship, argPropertyRelationship);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final IDataModelRelationship.RelationshipType getType() {
/* 59 */     return IDataModelRelationship.RelationshipType.MANY_TO_MANY;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\ManyToManyRelationship.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */