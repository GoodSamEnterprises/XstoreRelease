/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryDocumentCrossReferenceId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryDocumentLineItemInventoryLineCrossReferenceRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   InventoryDocumentCrossReferenceId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, invctl_document_id, invctl_document_line_nbr, document_typcode, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, cross_ref_organization_id, cross_ref_document_id, cross_ref_line_number, cross_ref_document_typcode, cross_ref_rtl_loc_id FROM inv_invctl_document_xref WHERE organization_id = ? AND invctl_document_id = ? AND invctl_document_line_nbr = ? AND document_typcode = ? AND rtl_loc_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     InventoryDocumentLineItemDAO dao = (InventoryDocumentLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryDocumentCrossReferenceId();
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryDocumentLineItemInventoryLineCrossReferenceRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */