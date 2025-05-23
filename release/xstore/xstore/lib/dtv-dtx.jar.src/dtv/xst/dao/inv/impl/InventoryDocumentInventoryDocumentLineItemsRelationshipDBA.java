/*    */ package dtv.xst.dao.inv.impl;
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
/*    */ public class InventoryDocumentInventoryDocumentLineItemsRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, inventory_item_id, lineitm_business_date, lineitm_rtl_loc_id, lineitm_rtrans_lineitm_seq, lineitm_trans_seq, lineitm_typcode, lineitm_wkstn_id, status_code, serial_number, unit_count, unit_cost, expected_count, posted_count, posted_cost, record_creation_type, entered_item_description, entered_item_id, carton_id, retail, model_nbr, original_bucket_id, original_loc_id, control_number, shipping_weight FROM inv_invctl_document_lineitm WHERE document_typcode = ? AND invctl_document_id = ? AND organization_id = ? AND rtl_loc_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     InventoryDocumentDAO dao = (InventoryDocumentDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getDocumentTypeCode());
/* 29 */     this._parameterList.add(dao.getDocumentId());
/* 30 */     this._parameterList.add(dao.getOrganizationId());
/* 31 */     this._parameterList.add(dao.getRetailLocationId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 36 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 40 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 44 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentInventoryDocumentLineItemsRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */