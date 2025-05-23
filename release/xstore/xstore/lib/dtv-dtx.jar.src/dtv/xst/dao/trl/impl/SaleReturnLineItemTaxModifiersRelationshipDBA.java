/*    */ package dtv.xst.dao.trl.impl;
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
/*    */ public class SaleReturnLineItemTaxModifiersRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, sale_tax_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, tax_amt, tax_percentage, raw_tax_amount, raw_tax_percentage, exempt_tax_amount, tax_exempt_amt, tax_exemption_id, tax_override_amt, tax_override_flag, tax_override_percentage, tax_override_reascode, tax_override_comment, taxable_amt, void_flag, tax_group_id, tax_loc_id, tax_rule_seq_nbr, authority_id, authority_name, authority_type_code, tax_override_bracket_id, orig_taxable_amount, orig_tax_group_id FROM trl_sale_tax_lineitm WHERE organization_id = ? AND rtl_loc_id = ? AND business_date = ? AND wkstn_id = ? AND trans_seq = ? AND rtrans_lineitm_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     SaleReturnLineItemDAO dao = (SaleReturnLineItemDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getRetailLocationId());
/* 30 */     this._parameterList.add(dao.getBusinessDate());
/* 31 */     this._parameterList.add(dao.getWorkstationId());
/* 32 */     this._parameterList.add(dao.getTransactionSequence());
/* 33 */     this._parameterList.add(dao.getRetailTransactionLineItemSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleReturnLineItemTaxModifiersRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */