/*    */ package dtv.xst.dao.inv.impl;
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
/*    */ public class ShipmentShipmentLineItemsRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(5);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, rtl_loc_id, invctl_document_id, document_typcode, shipment_seq, lineitm_seq, create_date, create_user_id, update_date, update_user_id, invctl_document_line_nbr, ship_qty, carton_id, status_code FROM inv_shipment_lines WHERE document_typcode = ? AND invctl_document_id = ? AND organization_id = ? AND rtl_loc_id = ? AND shipment_seq = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     ShipmentDAO dao = (ShipmentDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getDocumentTypeCode());
/* 29 */     this._parameterList.add(dao.getDocumentId());
/* 30 */     this._parameterList.add(dao.getOrganizationId());
/* 31 */     this._parameterList.add(dao.getRetailLocationId());
/* 32 */     this._parameterList.add(dao.getShipmentSequence());
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentShipmentLineItemsRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */