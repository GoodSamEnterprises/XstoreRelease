/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.PersistenceConstants;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.dsc.DiscountId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DiscountLineItemLineItemDiscountRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/* 21 */   DiscountId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT discount_code, organization_id, dtv_class_name, create_date, create_user_id, update_date, update_user_id, config_element, discount, app_mthd_code, calculation_mthd_code, description, effective_datetime, exclusive_discount_flag, expr_datetime, max_trans_count, min_eligible_price, percentage, prompt, sound, typcode, serialized_discount_flag, privilege_type, taxability_code, max_discount, max_amount, max_percentage, sort_order, disallow_change_flag FROM dsc_discount WHERE discount_code = ? AND organization_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     DiscountLineItemDAO dao = (DiscountLineItemDAO)argDAO;
/* 30 */     this._childObjectId = new DiscountId();
/* 31 */     this._parameterList.add((dao.getDiscountCode() != null && PersistenceConstants.MANAGE_CASE) ? dao.getDiscountCode().toUpperCase() : dao.getDiscountCode());
/* 32 */     this._childObjectId.setDiscountCode(dao.getDiscountCode());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DiscountLineItemLineItemDiscountRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */