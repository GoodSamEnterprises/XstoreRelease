/*    */ package dtv.xst.dao.doc.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.doc.DocumentId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocumentLineItemDocumentRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/* 21 */   DocumentId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT document_id, organization_id, document_type, series_id, create_date, create_user_id, update_date, update_user_id, org_code, org_value, document_status, issue_date, effective_date, expiration_date, amount, max_amount, percentage FROM doc_document WHERE document_id = ? AND organization_id = ? AND document_type = ? AND series_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     DocumentLineItemDAO dao = (DocumentLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new DocumentId();
/* 31 */     this._parameterList.add((dao.getDocumentId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDocumentId().toUpperCase() : dao.getDocumentId());
/* 32 */     this._childObjectId.setDocumentId(dao.getDocumentId());
/* 33 */     this._parameterList.add(dao.getOrganizationId());
/* 34 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 35 */     this._parameterList.add((dao.getDocumentType() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDocumentType().toUpperCase() : dao.getDocumentType());
/* 36 */     this._childObjectId.setDocumentType(dao.getDocumentType());
/* 37 */     this._parameterList.add((dao.getSeriesId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getSeriesId().toUpperCase() : dao.getSeriesId());
/* 38 */     this._childObjectId.setSeriesId(dao.getSeriesId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 47 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 51 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentLineItemDocumentRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */