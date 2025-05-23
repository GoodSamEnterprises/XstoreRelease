/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.cat.PaymentScheduleId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomerAccountPaymentScheduleRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   PaymentScheduleId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, begin_date, interval_type_enum, interval_count, total_payment_amt, payment_count FROM cat_payment_schedule WHERE organization_id = ? AND cust_acct_id = ? AND cust_acct_code = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     CustomerAccountDAO dao = (CustomerAccountDAO)argDAO;
/* 30 */     this._childObjectId = new PaymentScheduleId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getCustAccountId());
/* 34 */     this._childObjectId.setCustAccountId(dao.getCustAccountId());
/* 35 */     this._parameterList.add(dao.getCustAccountCode());
/* 36 */     this._childObjectId.setCustAccountCode(dao.getCustAccountCode());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountPaymentScheduleRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */