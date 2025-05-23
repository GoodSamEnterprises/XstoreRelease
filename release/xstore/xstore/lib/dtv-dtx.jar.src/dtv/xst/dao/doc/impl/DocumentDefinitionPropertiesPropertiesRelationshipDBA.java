/*    */ package dtv.xst.dao.doc.impl;
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
/*    */ public class DocumentDefinitionPropertiesPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT series_id, organization_id, document_type, doc_seq_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM doc_document_def_properties_p WHERE series_id = ? AND organization_id = ? AND document_type = ? AND doc_seq_nbr = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     DocumentDefinitionPropertiesDAO dao = (DocumentDefinitionPropertiesDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getSeriesId());
/* 29 */     this._parameterList.add(dao.getOrganizationId());
/* 30 */     this._parameterList.add(dao.getDocumentType());
/* 31 */     this._parameterList.add(dao.getSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\impl\DocumentDefinitionPropertiesPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */