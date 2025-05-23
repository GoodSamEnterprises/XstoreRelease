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
/*    */ public class TaxRateRuleOverridePropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT expr_datetime, organization_id, tax_group_id, tax_loc_id, tax_rate_rule_seq, tax_rule_seq_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM tax_tax_rate_rule_override_p WHERE expr_datetime = ? AND organization_id = ? AND tax_group_id = ? AND tax_loc_id = ? AND tax_rate_rule_seq = ? AND tax_rule_seq_nbr = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     TaxRateRuleOverrideDAO dao = (TaxRateRuleOverrideDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getExpirationDatetimestamp());
/* 29 */     this._parameterList.add(dao.getOrganizationId());
/* 30 */     this._parameterList.add(dao.getTaxGroupId());
/* 31 */     this._parameterList.add(dao.getTaxLocationId());
/* 32 */     this._parameterList.add(dao.getTaxRateRuleSequence());
/* 33 */     this._parameterList.add(dao.getTaxRuleSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 42 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 46 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxRateRuleOverridePropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */