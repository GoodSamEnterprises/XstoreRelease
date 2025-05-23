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
/*    */ public class ButtonGridPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(8);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, level_code, level_value, grid_id, row_id, column_id, component_id, sort_order, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM com_button_grid_p WHERE organization_id = ? AND level_code = ? AND level_value = ? AND grid_id = ? AND row_id = ? AND column_id = ? AND component_id = ? AND sort_order = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     ButtonGridDAO dao = (ButtonGridDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getLevelCode());
/* 30 */     this._parameterList.add(dao.getLevelValue());
/* 31 */     this._parameterList.add(dao.getGridId());
/* 32 */     this._parameterList.add(dao.getRowId());
/* 33 */     this._parameterList.add(dao.getColumnId());
/* 34 */     this._parameterList.add(dao.getComponentId());
/* 35 */     this._parameterList.add(dao.getSortOrder());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 44 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 48 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ButtonGridPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */