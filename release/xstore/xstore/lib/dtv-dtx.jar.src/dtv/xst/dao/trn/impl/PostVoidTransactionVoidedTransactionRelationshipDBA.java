/*    */ package dtv.xst.dao.trn.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.trn.PosTransactionId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PostVoidTransactionVoidedTransactionRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   PosTransactionId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, dtv_class_name, create_date, create_user_id, update_date, update_user_id, begin_datetime, trans_date, begin_time_int, end_datetime, keyed_offline_flag, posted_flag, session_id, subtotal, taxtotal, roundtotal, total, trans_statcode, trans_typcode, trans_cancel_reascode, generic_storage_flag, operator_party_id, post_void_flag, cash_drawer_id, fiscal_number FROM trn_trans WHERE organization_id = ? AND rtl_loc_id = ? AND business_date = ? AND wkstn_id = ? AND trans_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     PostVoidTransactionDAO dao = (PostVoidTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new PosTransactionId();
/* 31 */     this._parameterList.add(dao.getVoidedOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getVoidedOrganizationId());
/* 33 */     this._parameterList.add(dao.getVoidedRetailStoreId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getVoidedRetailStoreId());
/* 35 */     this._parameterList.add(dao.getVoidedBusinessDate());
/* 36 */     this._childObjectId.setBusinessDate(dao.getVoidedBusinessDate());
/* 37 */     this._parameterList.add(dao.getVoidedWorkstationId());
/* 38 */     this._childObjectId.setWorkstationId(dao.getVoidedWorkstationId());
/* 39 */     this._parameterList.add(dao.getVoidedTransactionId());
/* 40 */     this._childObjectId.setTransactionSequence(dao.getVoidedTransactionId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 49 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 53 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PostVoidTransactionVoidedTransactionRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */