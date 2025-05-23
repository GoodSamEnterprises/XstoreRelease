/*    */ package dtv.xst.dao.tnd.impl;
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
/*    */ public class TenderTenderOptionsRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, tndr_id, config_element, create_date, create_user_id, update_date, update_user_id, auth_expr_date_req_flag, auth_mthd_code, auth_req_flag, cust_association_flag, cust_id_req_code, cust_sig_req_flag, dflt_to_amt_due_flag, effective_date, endorsement_req_flag, expr_date, include_in_type_count_flag, mag_swipe_reader_req_flag, max_days_for_return, min_days_for_return, min_denomination_amt, open_cash_drawer_req_flag, pin_req_flag, populate_system_count_flag, serial_id_nbr_req_flag, unit_count_req_code, suggest_deposit_flag, suggested_deposit_threshold, cash_change_limit, change_tndr_id, over_tender_overridable_flag, non_voidable_flag, close_count_disc_threshold, cid_msr_req_flag, cid_keyed_req_flag, postal_code_req_flag, disallow_split_tndr_flag, post_void_open_drawer_flag, reporting_group, change_allowed_when_foreign, fiscal_tndr_id, rounding_mode, assign_cash_drawer_req_flag, post_void_assign_drawer_flag FROM tnd_tndr_options WHERE organization_id = ? AND tndr_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     TenderDAO dao = (TenderDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getTenderId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 38 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 42 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderTenderOptionsRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */