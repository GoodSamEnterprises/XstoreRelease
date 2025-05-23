/*    */ package dtv.xst.dao.thr.impl;
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
/*    */ public class TimecardEntryCommentPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, week_ending_date, rtl_loc_id, wkstn_id, party_id, comment_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM thr_timecard_entry_comment_p WHERE organization_id = ? AND week_ending_date = ? AND rtl_loc_id = ? AND wkstn_id = ? AND party_id = ? AND comment_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     TimecardEntryCommentDAO dao = (TimecardEntryCommentDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getWeekEndingDate());
/* 30 */     this._parameterList.add(dao.getRetailLocationId());
/* 31 */     this._parameterList.add(dao.getWorkstationId());
/* 32 */     this._parameterList.add(dao.getPartyId());
/* 33 */     this._parameterList.add(dao.getCommentSeq());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 42 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 46 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\TimecardEntryCommentPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */