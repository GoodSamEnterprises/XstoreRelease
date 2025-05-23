/*    */ package dtv.xst.dao.trl.impl;
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
/*    */ public class SaleReturnLineItemInventoryDocumentLineItemsRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, inventory_item_id, lineitm_business_date, lineitm_rtl_loc_id, lineitm_rtrans_lineitm_seq, lineitm_trans_seq, lineitm_typcode, lineitm_wkstn_id, status_code, serial_number, unit_count, unit_cost, expected_count, posted_count, posted_cost, record_creation_type, entered_item_description, entered_item_id, carton_id, retail, model_nbr, original_bucket_id, original_loc_id, control_number, shipping_weight FROM inv_invctl_document_lineitm WHERE organization_id = ? AND lineitm_rtl_loc_id = ? AND lineitm_business_date = ? AND lineitm_wkstn_id = ? AND lineitm_trans_seq = ? AND lineitm_rtrans_lineitm_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     SaleReturnLineItemDAO dao = (SaleReturnLineItemDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getRetailLocationId());
/* 30 */     this._parameterList.add(dao.getBusinessDate());
/* 31 */     this._parameterList.add(dao.getWorkstationId());
/* 32 */     this._parameterList.add(dao.getTransactionSequence());
/* 33 */     this._parameterList.add(dao.getRetailTransactionLineItemSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 42 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 46 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\SaleReturnLineItemInventoryDocumentLineItemsRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */