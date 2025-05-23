/*    */ package dtv.xst.dao.itm.impl;
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
/*    */ public class ItemRestrictGS1PropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(4);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, item_id, field_id, start_value, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM itm_restrict_gs1_p WHERE organization_id = ? AND item_id = ? AND field_id = ? AND start_value = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     ItemRestrictGS1DAO dao = (ItemRestrictGS1DAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getItemId());
/* 30 */     this._parameterList.add(dao.getFieldId());
/* 31 */     this._parameterList.add(dao.getStartValue());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictGS1PropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */