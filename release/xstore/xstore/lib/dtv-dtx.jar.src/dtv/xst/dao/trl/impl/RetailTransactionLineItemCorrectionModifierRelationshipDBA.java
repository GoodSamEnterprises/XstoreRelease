/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.trl.CorrectionModifierId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RetailTransactionLineItemCorrectionModifierRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/* 21 */   CorrectionModifierId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT business_date, organization_id, rtl_loc_id, rtrans_lineitm_seq, trans_seq, wkstn_id, create_date, create_user_id, update_date, update_user_id, original_rtl_loc_id, original_wkstn_id, original_business_date, original_trans_seq, original_rtrans_lineitm_seq, reascode, notes, original_tax_amt, original_extended_amt, original_unit_amt, original_base_extended_amt, original_base_unit_amt FROM trl_correction_mod WHERE business_date = ? AND organization_id = ? AND rtl_loc_id = ? AND rtrans_lineitm_seq = ? AND trans_seq = ? AND wkstn_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     RetailTransactionLineItemDAO dao = (RetailTransactionLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new CorrectionModifierId();
/* 31 */     this._parameterList.add(dao.getBusinessDate());
/* 32 */     this._childObjectId.setBusinessDate(dao.getBusinessDate());
/* 33 */     this._parameterList.add(dao.getOrganizationId());
/* 34 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 35 */     this._parameterList.add(dao.getRetailLocationId());
/* 36 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 37 */     this._parameterList.add(dao.getRetailTransactionLineItemSequence());
/* 38 */     this._childObjectId.setRetailTransactionLineItemSequence(dao.getRetailTransactionLineItemSequence());
/* 39 */     this._parameterList.add(dao.getTransactionSequence());
/* 40 */     this._childObjectId.setTransactionSequence(dao.getTransactionSequence());
/* 41 */     this._parameterList.add(dao.getWorkstationId());
/* 42 */     this._childObjectId.setWorkstationId(dao.getWorkstationId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 51 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 55 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionLineItemCorrectionModifierRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */