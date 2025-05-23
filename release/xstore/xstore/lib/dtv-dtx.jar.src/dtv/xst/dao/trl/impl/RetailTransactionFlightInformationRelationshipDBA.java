/*    */ package dtv.xst.dao.trl.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.trl.RetailTransactionFlightInfoId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RetailTransactionFlightInformationRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   RetailTransactionFlightInfoId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, create_date, create_user_id, update_date, update_user_id, flight_number, destination_airport, destination_country, destination_zone, destination_airport_name, origin_airport, tax_calculation_mode, first_flight_number, first_destination_airport, first_origin_airport, first_flight_seat_number, first_flight_scheduled_date FROM trl_rtrans_flight_info WHERE organization_id = ? AND rtl_loc_id = ? AND business_date = ? AND wkstn_id = ? AND trans_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     RetailTransactionDAO dao = (RetailTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new RetailTransactionFlightInfoId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 35 */     this._parameterList.add(dao.getBusinessDate());
/* 36 */     this._childObjectId.setBusinessDate(dao.getBusinessDate());
/* 37 */     this._parameterList.add(dao.getWorkstationId());
/* 38 */     this._childObjectId.setWorkstationId(dao.getWorkstationId());
/* 39 */     this._parameterList.add(dao.getTransactionSequence());
/* 40 */     this._childObjectId.setTransactionSequence(dao.getTransactionSequence());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 49 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 53 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionFlightInformationRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */