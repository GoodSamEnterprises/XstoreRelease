/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryTransactionDetailId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryMovementPendingInventoryTransactionDetailRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/* 21 */   InventoryTransactionDetailId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, invctl_trans_seq, create_date, create_user_id, update_date, update_user_id, old_status_code, new_status_code, previous_unit_count, new_unit_count, action_code, new_posted_count, previous_posted_count, invctl_document_rtl_loc_id, invctl_document_id, document_typcode, invctl_document_line_nbr, item_id FROM inv_invctl_trans_detail WHERE organization_id = ? AND rtl_loc_id = ? AND business_date = ? AND wkstn_id = ? AND trans_seq = ? AND invctl_trans_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     InventoryMovementPendingDAO dao = (InventoryMovementPendingDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryTransactionDetailId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 35 */     this._parameterList.add(dao.getBusinessDate());
/* 36 */     this._childObjectId.setBusinessDate(dao.getBusinessDate());
/* 37 */     this._parameterList.add(dao.getWorkstationId());
/* 38 */     this._childObjectId.setWorkstationId(dao.getWorkstationId());
/* 39 */     this._parameterList.add(dao.getTransactionSequence());
/* 40 */     this._childObjectId.setTransactionSequence(dao.getTransactionSequence());
/* 41 */     this._parameterList.add(dao.getLineItemSequence());
/* 42 */     this._childObjectId.setInventoryDetailSequence(dao.getLineItemSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryMovementPendingInventoryTransactionDetailRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */