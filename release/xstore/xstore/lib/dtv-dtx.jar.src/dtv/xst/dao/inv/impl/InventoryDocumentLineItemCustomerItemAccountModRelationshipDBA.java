/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryItemAccountModifierId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryDocumentLineItemCustomerItemAccountModRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   InventoryItemAccountModifierId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, invctl_document_id, invctl_document_line_nbr, document_typcode, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, cust_acct_code, cust_acct_id FROM inv_item_acct_mod WHERE organization_id = ? AND invctl_document_id = ? AND invctl_document_line_nbr = ? AND document_typcode = ? AND rtl_loc_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     InventoryDocumentLineItemDAO dao = (InventoryDocumentLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryItemAccountModifierId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getDocumentId());
/* 34 */     this._childObjectId.setDocumentId(dao.getDocumentId());
/* 35 */     this._parameterList.add(dao.getInventoryDocumentLineNumber());
/* 36 */     this._childObjectId.setInventoryDocumentLineNumber(dao.getInventoryDocumentLineNumber());
/* 37 */     this._parameterList.add(dao.getDocumentTypeCode());
/* 38 */     this._childObjectId.setDocumentTypeCode(dao.getDocumentTypeCode());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemCustomerItemAccountModRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */