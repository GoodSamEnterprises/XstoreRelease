/*    */ package dtv.xst.dao.tnd.impl;
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
/*    */ public class TenderUserSettingsPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(6);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT group_id, organization_id, tndr_id, usage_code, entry_mthd_code, config_element, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM tnd_tndr_user_settings_p WHERE group_id = ? AND organization_id = ? AND tndr_id = ? AND usage_code = ? AND entry_mthd_code = ? AND config_element = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     TenderUserSettingsDAO dao = (TenderUserSettingsDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getGroupId());
/* 29 */     this._parameterList.add(dao.getOrganizationId());
/* 30 */     this._parameterList.add(dao.getTenderId());
/* 31 */     this._parameterList.add(dao.getUsageCode());
/* 32 */     this._parameterList.add(dao.getEntryMethodCode());
/* 33 */     this._parameterList.add(dao.getConfigElement());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderUserSettingsPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */