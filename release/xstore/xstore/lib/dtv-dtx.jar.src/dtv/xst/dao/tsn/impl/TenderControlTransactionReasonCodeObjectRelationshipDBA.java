/*    */ package dtv.xst.dao.tsn.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.com.ReasonCodeId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TenderControlTransactionReasonCodeObjectRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/* 21 */   ReasonCodeId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, reason_typcode, reason_code, create_date, create_user_id, update_date, update_user_id, config_element, description, comment_req, sort_order, parent_code, gl_acct_nbr, minimum_amt, maximum_amt, cust_msg, inv_action_code, location_id, bucket_id, hidden_flag FROM com_reason_code WHERE organization_id = ? AND reason_code = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     TenderControlTransactionDAO dao = (TenderControlTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new ReasonCodeId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add((dao.getReasonCode() != null && PersistenceConstants.MANAGE_CASE) ? dao.getReasonCode().toUpperCase() : dao.getReasonCode());
/* 34 */     this._childObjectId.setReasonCode(dao.getReasonCode());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 43 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 47 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderControlTransactionReasonCodeObjectRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */