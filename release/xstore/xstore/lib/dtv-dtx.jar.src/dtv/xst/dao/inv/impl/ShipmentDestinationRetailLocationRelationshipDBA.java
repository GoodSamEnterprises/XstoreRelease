/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.loc.RetailLocationId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShipmentDestinationRetailLocationRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/* 21 */   RetailLocationId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, address1, address2, address3, address4, apartment, city, country, locale, currency_id, description, postal_code, state, store_name, store_nbr, alternate_store_nbr, telephone1, telephone2, telephone3, telephone4, latitude, longitude, default_tax_percentage, store_manager, location_type, delivery_available_flag, pickup_available_flag, transfer_available_flag, email_addr, geo_code, uez_flag, district, area, use_till_accountability_flag, deposit_bank_name, deposit_bank_account_number, neighborhood, county, airport_code FROM loc_rtl_loc WHERE organization_id = ? AND rtl_loc_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     ShipmentDAO dao = (ShipmentDAO)argDAO;
/* 30 */     this._childObjectId = new RetailLocationId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getDestinationRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getDestinationRetailLocationId());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentDestinationRetailLocationRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */