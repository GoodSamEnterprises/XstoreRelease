/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.trl.ReturnedItemCountId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SaleReturnLineItemBaseReturnedQuantityRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/* 21 */   ReturnedItemCountId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, wkstn_id, business_date, rtrans_lineitm_seq, trans_seq, create_date, create_user_id, update_date, update_user_id, returned_count FROM trl_returned_item_count WHERE organization_id = ? AND rtl_loc_id = ? AND wkstn_id = ? AND business_date = ? AND rtrans_lineitm_seq = ? AND trans_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     SaleReturnLineItemDAO dao = (SaleReturnLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new ReturnedItemCountId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 35 */     this._parameterList.add(dao.getWorkstationId());
/* 36 */     this._childObjectId.setWorkstationId(dao.getWorkstationId());
/* 37 */     this._parameterList.add(dao.getBusinessDate());
/* 38 */     this._childObjectId.setBusinessDate(dao.getBusinessDate());
/* 39 */     this._parameterList.add(dao.getRetailTransactionLineItemSequence());
/* 40 */     this._childObjectId.setRetailTransactionLineItemSequence(dao.getRetailTransactionLineItemSequence());
/* 41 */     this._parameterList.add(dao.getTransactionSequence());
/* 42 */     this._childObjectId.setTransactionSequence(dao.getTransactionSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleReturnLineItemBaseReturnedQuantityRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */