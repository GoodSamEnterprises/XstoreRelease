/*    */ package dtv.xst.dao.tax.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.tax.TaxAuthorityId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaxGroupRuleTaxAuthorityRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/* 21 */   TaxAuthorityId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, tax_authority_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, name, rounding_code, rounding_digits_quantity, external_system FROM tax_tax_authority WHERE organization_id = ? AND tax_authority_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     TaxGroupRuleDAO dao = (TaxGroupRuleDAO)argDAO;
/* 30 */     this._childObjectId = new TaxAuthorityId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add((dao.getTaxAuthorityId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getTaxAuthorityId().toUpperCase() : dao.getTaxAuthorityId());
/* 34 */     this._childObjectId.setTaxAuthorityId(dao.getTaxAuthorityId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 43 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 47 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupRuleTaxAuthorityRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */