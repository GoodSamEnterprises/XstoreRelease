/*    */ package dtv.xst.dao.tsn.impl;
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
/*    */ public class TenderDenominationCountPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(8);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT business_date, denomination_id, organization_id, rtl_loc_id, tndr_id, tndr_typcode, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM tsn_tndr_denomination_count_p WHERE business_date = ? AND denomination_id = ? AND organization_id = ? AND rtl_loc_id = ? AND tndr_id = ? AND tndr_typcode = ? AND trans_seq = ? AND wkstn_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     TenderDenominationCountDAO dao = (TenderDenominationCountDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getBusinessDayDate());
/* 29 */     this._parameterList.add(dao.getDenominationId());
/* 30 */     this._parameterList.add(dao.getOrganizationId());
/* 31 */     this._parameterList.add(dao.getRetailLocationId());
/* 32 */     this._parameterList.add(dao.getTenderId());
/* 33 */     this._parameterList.add(dao.getTenderTypeCode());
/* 34 */     this._parameterList.add(dao.getTransactionSequence());
/* 35 */     this._parameterList.add(dao.getWorkstationId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 44 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 48 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */