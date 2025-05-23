/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryDocumentLineItemId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryTransactionDetailInventoryDocumentLineItemRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   InventoryDocumentLineItemId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, inventory_item_id, lineitm_business_date, lineitm_rtl_loc_id, lineitm_rtrans_lineitm_seq, lineitm_trans_seq, lineitm_typcode, lineitm_wkstn_id, status_code, serial_number, unit_count, unit_cost, expected_count, posted_count, posted_cost, record_creation_type, entered_item_description, entered_item_id, carton_id, retail, model_nbr, original_bucket_id, original_loc_id, control_number, shipping_weight FROM inv_invctl_document_lineitm WHERE invctl_document_id = ? AND document_typcode = ? AND invctl_document_line_nbr = ? AND organization_id = ? AND rtl_loc_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     InventoryTransactionDetailDAO dao = (InventoryTransactionDetailDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryDocumentLineItemId();
/* 31 */     this._parameterList.add((dao.getDocumentId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDocumentId().toUpperCase() : dao.getDocumentId());
/* 32 */     this._childObjectId.setDocumentId(dao.getDocumentId());
/* 33 */     this._parameterList.add((dao.getDocumentTypeCode() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDocumentTypeCode().toUpperCase() : dao.getDocumentTypeCode());
/* 34 */     this._childObjectId.setDocumentTypeCode(dao.getDocumentTypeCode());
/* 35 */     this._parameterList.add(dao.getInventoryDocumentLineNumber());
/* 36 */     this._childObjectId.setInventoryDocumentLineNumber(dao.getInventoryDocumentLineNumber());
/* 37 */     this._parameterList.add(dao.getOrganizationId());
/* 38 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 39 */     this._parameterList.add(dao.getInventoryDocumentRetailLocationId());
/* 40 */     this._childObjectId.setRetailLocationId(dao.getInventoryDocumentRetailLocationId());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryTransactionDetailInventoryDocumentLineItemRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */