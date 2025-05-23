/*    */ package dtv.xst.dao.hrs.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.sec.GroupId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmployeePrimaryGroupRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/* 21 */   GroupId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT group_id, organization_id, create_date, create_user_id, update_date, update_user_id, config_element, bitmap_position, description, group_rank FROM sec_groups WHERE group_id = ? AND organization_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     EmployeeDAO dao = (EmployeeDAO)argDAO;
/* 30 */     this._childObjectId = new GroupId();
/* 31 */     this._parameterList.add((dao.getPrimaryGroupId() != null && PersistenceConstants.MANAGE_CASE) ? dao.getPrimaryGroupId().toUpperCase() : dao.getPrimaryGroupId());
/* 32 */     this._childObjectId.setGroupId(dao.getPrimaryGroupId());
/* 33 */     this._parameterList.add(dao.getOrganizationId());
/* 34 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 43 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 47 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\impl\EmployeePrimaryGroupRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */