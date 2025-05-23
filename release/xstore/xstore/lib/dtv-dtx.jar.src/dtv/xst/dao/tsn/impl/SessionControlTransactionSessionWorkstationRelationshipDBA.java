/*    */ package dtv.xst.dao.tsn.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.tsn.SessionWorkstationId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SessionControlTransactionSessionWorkstationRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/* 21 */   SessionWorkstationId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, session_id, session_wkstn_seq, create_date, create_user_id, update_date, update_user_id, begin_datetime, cash_drawer_id, end_datetime, attached_flag, wkstn_id FROM tsn_session_wkstn WHERE organization_id = ? AND rtl_loc_id = ? AND session_id = ? AND session_wkstn_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     SessionControlTransactionDAO dao = (SessionControlTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new SessionWorkstationId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 35 */     this._parameterList.add(dao.getSessionId());
/* 36 */     this._childObjectId.setSessionId(dao.getSessionId());
/* 37 */     this._parameterList.add(dao.getSessionWorkstationSequence());
/* 38 */     this._childObjectId.setSessionWorkstationSequenceNbr(dao.getSessionWorkstationSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 43 */     return false;
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\SessionControlTransactionSessionWorkstationRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */