/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.inv.ShipmentAddressId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShipmentAddressRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/* 21 */   ShipmentAddressId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, rtl_loc_id, invctl_document_id, document_typcode, shipment_seq, create_date, create_user_id, update_date, update_user_id, address1, address2, address3, address4, apartment, city, state, postal_code, country, telephone1, telephone2, telephone3, telephone4, neighborhood, county FROM inv_shipment_address WHERE organization_id = ? AND rtl_loc_id = ? AND invctl_document_id = ? AND document_typcode = ? AND shipment_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     ShipmentDAO dao = (ShipmentDAO)argDAO;
/* 30 */     this._childObjectId = new ShipmentAddressId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getRetailLocationId());
/* 34 */     this._childObjectId.setRetailLocationId(dao.getRetailLocationId());
/* 35 */     this._parameterList.add(dao.getDocumentId());
/* 36 */     this._childObjectId.setDocumentId(dao.getDocumentId());
/* 37 */     this._parameterList.add(dao.getDocumentTypeCode());
/* 38 */     this._childObjectId.setDocumentTypeCode(dao.getDocumentTypeCode());
/* 39 */     this._parameterList.add(dao.getShipmentSequence());
/* 40 */     this._childObjectId.setShipmentSequence(dao.getShipmentSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentAddressRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */