/*    */ package dtv.xst.dao.tsn.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.tsn.TenderRepositoryId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TenderControlTransactionOutboundTenderRepositoryRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   TenderRepositoryId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, tndr_repository_id, create_date, create_user_id, update_date, update_user_id, description, name, not_issuable_flag, typcode, dflt_wkstn_id FROM tsn_tndr_repository WHERE organization_id = ? AND rtl_loc_id = ? AND tndr_repository_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     TenderControlTransactionDAO dao = (TenderControlTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new TenderRepositoryId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 35 */     this._parameterList.add((dao.getOutboundTenderRepositoryId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getOutboundTenderRepositoryId().toUpperCase() : dao.getOutboundTenderRepositoryId());
/* 36 */     this._childObjectId.setTenderRepositoryId(dao.getOutboundTenderRepositoryId());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderControlTransactionOutboundTenderRepositoryRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */