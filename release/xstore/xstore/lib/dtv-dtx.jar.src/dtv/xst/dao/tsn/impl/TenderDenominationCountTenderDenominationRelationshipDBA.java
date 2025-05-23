/*    */ package dtv.xst.dao.tsn.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.tnd.TenderDenominationId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TenderDenominationCountTenderDenominationRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   TenderDenominationId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT denomination_id, organization_id, tndr_id, create_date, create_user_id, update_date, update_user_id, description, sort_order, value FROM tnd_tndr_denomination WHERE denomination_id = ? AND organization_id = ? AND tndr_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     TenderDenominationCountDAO dao = (TenderDenominationCountDAO)argDAO;
/* 30 */     this._childObjectId = new TenderDenominationId();
/* 31 */     this._parameterList.add(dao.getDenominationId());
/* 32 */     this._childObjectId.setDenominationId(dao.getDenominationId());
/* 33 */     this._parameterList.add(dao.getOrganizationId());
/* 34 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 35 */     this._parameterList.add(dao.getTenderId());
/* 36 */     this._childObjectId.setTenderId(dao.getTenderId());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderDenominationCountTenderDenominationRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */