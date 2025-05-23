/*    */ package dtv.xst.dao.com.impl;
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
/*    */ public class SequencePropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, rtl_loc_id, wkstn_id, sequence_id, sequence_mode, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM com_sequence_p WHERE organization_id = ? AND rtl_loc_id = ? AND wkstn_id = ? AND sequence_id = ? AND sequence_mode = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     SequenceDAO dao = (SequenceDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getRetailLocationId());
/* 30 */     this._parameterList.add(dao.getWorkstationId());
/* 31 */     this._parameterList.add(dao.getSequenceId());
/* 32 */     this._parameterList.add(dao.getSequenceMode());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 41 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 45 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\SequencePropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */