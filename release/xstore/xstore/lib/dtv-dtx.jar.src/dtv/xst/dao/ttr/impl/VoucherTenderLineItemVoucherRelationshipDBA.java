/*    */ package dtv.xst.dao.ttr.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.ttr.VoucherId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VoucherTenderLineItemVoucherRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   VoucherId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, serial_nbr, voucher_typcode, create_date, create_user_id, update_date, update_user_id, effective_date, expr_date, face_value_amt, issue_datetime, issue_typcode, unspent_balance_amt, voucher_status_code, currency_id FROM ttr_voucher WHERE organization_id = ? AND serial_nbr = ? AND voucher_typcode = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     VoucherTenderLineItemDAO dao = (VoucherTenderLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new VoucherId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getSerialNumber());
/* 34 */     this._childObjectId.setSerialNumber(dao.getSerialNumber());
/* 35 */     this._parameterList.add((dao.getVoucherTypeCode() != null && PersistenceConstants.MANAGE_CASE) ? dao.getVoucherTypeCode().toUpperCase() : dao.getVoucherTypeCode());
/* 36 */     this._childObjectId.setVoucherTypeCode(dao.getVoucherTypeCode());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\VoucherTenderLineItemVoucherRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */