/*    */ package dtv.xst.dao.trn.impl;
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
/*    */ public class PosTransactionLinkPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(9);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT business_date, link_business_date, link_rtl_loc_id, link_trans_seq, link_wkstn_id, organization_id, rtl_loc_id, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM trn_trans_link_p WHERE business_date = ? AND link_business_date = ? AND link_rtl_loc_id = ? AND link_trans_seq = ? AND link_wkstn_id = ? AND organization_id = ? AND rtl_loc_id = ? AND trans_seq = ? AND wkstn_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     PosTransactionLinkDAO dao = (PosTransactionLinkDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getBusinessDate());
/* 29 */     this._parameterList.add(dao.getLinkBusinessDate());
/* 30 */     this._parameterList.add(dao.getLinkRetailLocationId());
/* 31 */     this._parameterList.add(dao.getLinkTransactionSequence());
/* 32 */     this._parameterList.add(dao.getLinkWorkstationId());
/* 33 */     this._parameterList.add(dao.getOrganizationId());
/* 34 */     this._parameterList.add(dao.getRetailLocationId());
/* 35 */     this._parameterList.add(dao.getTransactionSequence());
/* 36 */     this._parameterList.add(dao.getWorkstationId());
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
/* 49 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */