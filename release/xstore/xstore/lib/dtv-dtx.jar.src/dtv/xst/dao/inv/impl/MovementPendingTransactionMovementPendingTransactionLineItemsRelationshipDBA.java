/*    */ package dtv.xst.dao.inv.impl;
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
/*    */ public class MovementPendingTransactionMovementPendingTransactionLineItemsRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, trans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, original_rtl_loc_id, original_wkstn_id, original_business_date, original_trans_seq, original_trans_lineitm_seq, quantity_reconciled FROM inv_mptrans_lineitm WHERE organization_id = ? AND rtl_loc_id = ? AND wkstn_id = ? AND business_date = ? AND trans_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     MovementPendingTransactionDAO dao = (MovementPendingTransactionDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getRetailLocationId());
/* 30 */     this._parameterList.add(dao.getWorkstationId());
/* 31 */     this._parameterList.add(dao.getBusinessDate());
/* 32 */     this._parameterList.add(dao.getTransactionSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 41 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 45 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionMovementPendingTransactionLineItemsRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */