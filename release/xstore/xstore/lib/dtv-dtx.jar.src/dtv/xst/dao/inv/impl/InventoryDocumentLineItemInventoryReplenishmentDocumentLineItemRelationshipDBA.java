/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryReplenishmentDocumentLineItemId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryDocumentLineItemInventoryReplenishmentDocumentLineItemRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   InventoryReplenishmentDocumentLineItemId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT invctl_document_id, document_typcode, invctl_document_line_nbr, organization_id, rtl_loc_id, suggested_order_qty, order_quantity, confirmed_quantity, confirmation_date, confirmation_number, ship_via, shipped_quantity, shipped_date, received_quantity, received_date, source_type, source_id, source_name, parent_document_id, create_date, create_user_id, update_date, update_user_id FROM inv_rep_document_lineitm WHERE invctl_document_id = ? AND document_typcode = ? AND invctl_document_line_nbr = ? AND organization_id = ? AND rtl_loc_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     InventoryDocumentLineItemDAO dao = (InventoryDocumentLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryReplenishmentDocumentLineItemId();
/* 31 */     this._parameterList.add(dao.getDocumentId());
/* 32 */     this._childObjectId.setDocumentId(dao.getDocumentId());
/* 33 */     this._parameterList.add(dao.getDocumentTypeCode());
/* 34 */     this._childObjectId.setDocumentTypeCode(dao.getDocumentTypeCode());
/* 35 */     this._parameterList.add(dao.getInventoryDocumentLineNumber());
/* 36 */     this._childObjectId.setInventoryDocumentLineNumber(dao.getInventoryDocumentLineNumber());
/* 37 */     this._parameterList.add(dao.getOrganizationId());
/* 38 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 39 */     this._parameterList.add(dao.getRetailLocationId());
/* 40 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemInventoryReplenishmentDocumentLineItemRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */