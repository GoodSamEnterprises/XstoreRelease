/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.InventoryDocumentId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryDocumentModifierInventoryDocumentRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   InventoryDocumentId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT invctl_document_id, document_typcode, organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, complete_date_timestamp, create_date_timestamp, originator_id, status_code, document_subtypcode, originator_name, last_activity_date, po_ref_nbr, record_creation_type, description, control_number, originator_address_id, submit_date FROM inv_invctl_document WHERE organization_id = ? AND invctl_document_id = ? AND document_typcode = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     InventoryDocumentModifierDAO dao = (InventoryDocumentModifierDAO)argDAO;
/* 30 */     this._childObjectId = new InventoryDocumentId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add((dao.getDocumentId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDocumentId().toUpperCase() : dao.getDocumentId());
/* 34 */     this._childObjectId.setDocumentId(dao.getDocumentId());
/* 35 */     this._parameterList.add((dao.getDocumentTypeCode() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDocumentTypeCode().toUpperCase() : dao.getDocumentTypeCode());
/* 36 */     this._childObjectId.setDocumentTypeCode(dao.getDocumentTypeCode());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\InventoryDocumentModifierInventoryDocumentRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */