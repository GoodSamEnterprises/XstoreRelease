/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.tax.TaxGroupRuleId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SaleTaxModifierSaleTaxGroupRuleRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/* 21 */   TaxGroupRuleId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, tax_group_id, tax_loc_id, tax_rule_seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, compound_flag, compound_seq_nbr, description, name, tax_typcode, taxed_at_trans_level_flag, tax_authority_id, external_system FROM tax_tax_group_rule WHERE organization_id = ? AND tax_group_id = ? AND tax_loc_id = ? AND tax_rule_seq_nbr = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     SaleTaxModifierDAO dao = (SaleTaxModifierDAO)argDAO;
/* 30 */     this._childObjectId = new TaxGroupRuleId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add((dao.getTaxGroupId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getTaxGroupId().toUpperCase() : dao.getTaxGroupId());
/* 34 */     this._childObjectId.setTaxGroupId(dao.getTaxGroupId());
/* 35 */     this._parameterList.add((dao.getTaxLocationId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getTaxLocationId().toUpperCase() : dao.getTaxLocationId());
/* 36 */     this._childObjectId.setTaxLocationId(dao.getTaxLocationId());
/* 37 */     this._parameterList.add(dao.getTaxRuleSequence());
/* 38 */     this._childObjectId.setTaxRuleSequence(dao.getTaxRuleSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 47 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 51 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleTaxModifierSaleTaxGroupRuleRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */