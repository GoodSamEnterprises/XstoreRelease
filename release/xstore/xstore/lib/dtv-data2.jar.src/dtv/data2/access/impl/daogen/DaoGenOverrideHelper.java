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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DaoGenOverrideHelper
/*    */   extends DaoGenHelper
/*    */ {
/*    */   public void optionalValidate() {}
/*    */   
/*    */   public void setupRelationships() {
/* 33 */     for (DtxDefinition dtxDefinition : this.dtxDefinitions_) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 39 */       String parentType = dtxDefinition.getExtendsStringType();
/* 40 */       if (!StringUtils.isEmpty(parentType)) {
/* 41 */         DtxDefinition parent = this.typeNameToDefinition_.get(parentType);
/*    */         
/* 43 */         if (parent == null) {
/* 44 */           parent = new DtxDefinition();
/*    */ 
/*    */           
/* 47 */           String parentPackage = parentType.substring(0, parentType.lastIndexOf('.'));
/* 48 */           String parentClassName = parentType.substring(parentType.lastIndexOf('.') + 1, parentType.length());
/* 49 */           parent.setName(parentClassName);
/* 50 */           parent.setPackage(parentPackage);
/* 51 */           parent.setPlaceHolder(true);
/*    */         } 
/*    */         
/* 54 */         dtxDefinition.setExtends(parent);
/*    */       } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 61 */       DtxInverseRelationship[] inverseRelationships = dtxDefinition.getInverseRelationships();
/* 62 */       for (DtxInverseRelationship ir : inverseRelationships) {
/*    */         
/* 64 */         DtxDefinition dtxParent = this.typeNameToDefinition_.get(ir.getParentType());
/*    */         
/* 66 */         if (dtxParent == null) {
/* 67 */           throw new RuntimeException("Could not find parent: " + ir.getParentType() + " for inverse relationship: " + ir
/* 68 */               .getName() + "\nfor dtx: " + dtxDefinition.getName());
/*    */         }
/*    */         
/* 71 */         ir.setParent(dtxParent);
/*    */       } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 78 */       for (DtxRelationship relationship : dtxDefinition.getRelationships()) {
/*    */         
/* 80 */         DtxDefinition child = this.typeNameToDefinition_.get(relationship.getChildName());
/*    */         
/* 82 */         if (child == null) {
/* 83 */           throw new RuntimeException("Unknown child type: " + relationship.getChildName() + " on relationship: " + relationship
/* 84 */               .getName() + " in dtx: " + dtxDefinition
/* 85 */               .getSourceDtxFile().getAbsolutePath());
/*    */         }
/*    */         
/* 88 */         relationship.setChild(child);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DaoGenOverrideHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */