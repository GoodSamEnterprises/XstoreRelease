/*    */ package dtv.xst.dao.doc.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.doc.DocumentDefinitionId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocumentDocumentDefinitionRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   DocumentDefinitionId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT series_id, organization_id, document_type, create_date, create_user_id, update_date, update_user_id, org_code, org_value, start_issue_date, end_issue_date, start_redeem_date, end_redeem_date, vendor_id, description, receipt_type, segment_type, text_code_value, file_name FROM doc_document_definition WHERE series_id = ? AND organization_id = ? AND document_type = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     DocumentDAO dao = (DocumentDAO)argDAO;
/* 30 */     this._childObjectId = new DocumentDefinitionId();
/* 31 */     this._parameterList.add(dao.getSeriesId());
/* 32 */     this._childObjectId.setSeriesId(dao.getSeriesId());
/* 33 */     this._parameterList.add(dao.getOrganizationId());
/* 34 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 35 */     this._parameterList.add(dao.getDocumentType());
/* 36 */     this._childObjectId.setDocumentType(dao.getDocumentType());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 41 */     return true;
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDocumentDefinitionRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */