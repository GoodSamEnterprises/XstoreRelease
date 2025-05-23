/*    */ package dtv.xst.dao.loc.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.loc.PricingHierarchyId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PricingHierarchyParentElementRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   PricingHierarchyId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, level_code, level_value, create_date, create_user_id, update_date, update_user_id, parent_code, parent_value, description, level_order, sort_order FROM loc_pricing_hierarchy WHERE organization_id = ? AND level_code = ? AND level_value = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     PricingHierarchyDAO dao = (PricingHierarchyDAO)argDAO;
/* 30 */     this._childObjectId = new PricingHierarchyId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add((dao.getParentCode() != null && PersistenceConstants.MANAGE_CASE) ? dao.getParentCode().toUpperCase() : dao.getParentCode());
/* 34 */     this._childObjectId.setLevelCode(dao.getParentCode());
/* 35 */     this._parameterList.add((dao.getParentValue() != null && PersistenceConstants.MANAGE_CASE) ? dao.getParentValue().toUpperCase() : dao.getParentValue());
/* 36 */     this._childObjectId.setLevelValue(dao.getParentValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 45 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 49 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\PricingHierarchyParentElementRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */