/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.cat.DeliveryModifierId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomerItemAccountDeliveryModifierRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(3);
/*    */   
/* 21 */   DeliveryModifierId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, delivery_enum, first_name, middle_name, last_name, address1, address2, address3, address4, apartment, city, state, postal_code, country, telephone1, telephone2, telephone3, telephone4, shipping_method, tracking_number, instructions, extension, delivery_date, delivery_start_time, delivery_end_time, geo_code, neighborhood, county FROM cat_delivery_modifier WHERE organization_id = ? AND cust_acct_id = ? AND cust_acct_code = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     CustomerItemAccountDAO dao = (CustomerItemAccountDAO)argDAO;
/* 30 */     this._childObjectId = new DeliveryModifierId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getCustAccountId());
/* 34 */     this._childObjectId.setCustAccountId(dao.getCustAccountId());
/* 35 */     this._parameterList.add(dao.getCustAccountCode());
/* 36 */     this._childObjectId.setCustAccountCode(dao.getCustAccountCode());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDeliveryModifierRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */