/*    */ package dtv.xst.dao.tax.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaxGroupRuleTaxRateRulesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, tax_group_id, tax_loc_id, tax_rate_rule_seq, tax_rule_seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, amt, breakpoint_typcode, daily_end_time, daily_start_time, effective_datetime, expr_datetime, percentage, tax_rate_max_taxable_amt, tax_rate_min_taxable_amt, tax_bracket_id, external_system FROM tax_tax_rate_rule WHERE organization_id = ? AND tax_group_id = ? AND tax_loc_id = ? AND tax_rule_seq_nbr = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     TaxGroupRuleDAO dao = (TaxGroupRuleDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getTaxGroupId());
/* 30 */     this._parameterList.add(dao.getTaxLocationId());
/* 31 */     this._parameterList.add(dao.getTaxRuleSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 40 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 44 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxGroupRuleTaxRateRulesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */