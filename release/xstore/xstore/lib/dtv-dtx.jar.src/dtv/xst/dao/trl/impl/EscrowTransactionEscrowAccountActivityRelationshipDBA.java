/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.cat.EscrowAccountActivityId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EscrowTransactionEscrowAccountActivityRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   EscrowAccountActivityId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, cust_acct_id, seq_nbr, create_date, create_user_id, update_date, update_user_id, activity_date, activity_enum, amt, business_date, trans_seq, wkstn_id, rtl_loc_id, source_cust_acct_id, source_cust_acct_code FROM cat_escrow_acct_activity WHERE organization_id = ? AND cust_acct_id = ? AND seq_nbr = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     EscrowTransactionDAO dao = (EscrowTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new EscrowAccountActivityId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add((dao.getCustAccountId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getCustAccountId().toUpperCase() : dao.getCustAccountId());
/* 34 */     this._childObjectId.setCustAccountId(dao.getCustAccountId());
/* 35 */     this._parameterList.add(dao.getActivitySequenceNumber());
/* 36 */     this._childObjectId.setSeqNbr(dao.getActivitySequenceNumber());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 45 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 49 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\EscrowTransactionEscrowAccountActivityRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */