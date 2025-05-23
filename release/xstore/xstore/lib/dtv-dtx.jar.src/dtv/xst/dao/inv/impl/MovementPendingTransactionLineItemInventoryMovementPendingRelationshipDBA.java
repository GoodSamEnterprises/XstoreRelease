/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryMovementPendingId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MovementPendingTransactionLineItemInventoryMovementPendingRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/* 21 */   InventoryMovementPendingId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, trans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, item_id, serial_nbr, action_code, quantity, reconciled_flag, void_flag FROM inv_movement_pending WHERE organization_id = ? AND rtl_loc_id = ? AND business_date = ? AND wkstn_id = ? AND trans_seq = ? AND trans_lineitm_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     MovementPendingTransactionLineItemDAO dao = (MovementPendingTransactionLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryMovementPendingId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getOriginalRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getOriginalRetailLocationId());
/* 35 */     this._parameterList.add(dao.getOriginalBusinessDate());
/* 36 */     this._childObjectId.setBusinessDate(dao.getOriginalBusinessDate());
/* 37 */     this._parameterList.add(dao.getOriginalWorkstationId());
/* 38 */     this._childObjectId.setWorkstationId(dao.getOriginalWorkstationId());
/* 39 */     this._parameterList.add(dao.getOriginalTransactionSequence());
/* 40 */     this._childObjectId.setTransactionSequence(dao.getOriginalTransactionSequence());
/* 41 */     this._parameterList.add(dao.getOriginalLineItemSequence());
/* 42 */     this._childObjectId.setLineItemSequence(dao.getOriginalLineItemSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\MovementPendingTransactionLineItemInventoryMovementPendingRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */