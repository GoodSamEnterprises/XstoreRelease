/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.ObjectUtils;
/*    */ import dtv.xst.dao.inv.IInventoryDocument;
/*    */ import dtv.xst.dao.inv.IShipment;
/*    */ import dtv.xst.dao.inv.IShipmentLineItem;
/*    */ import dtv.xst.dao.inv.IShipmentModel;
/*    */ import dtv.xst.dao.inv.IShipmentProperty;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ShipmentBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IShipmentProperty>
/*    */   implements IShipment, IShipmentModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient String tempShipmentStatusCode_;
/*    */   
/*    */   public void addLineItems(IShipmentLineItem lineItem) {
/* 29 */     IInventoryDocument cd = getParentDocument();
/*    */     
/* 31 */     if (cd == null) {
/* 32 */       throw new IllegalStateException("Inventory Control Document link must be established before line items can be added.");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void commitTemp() {
/* 40 */     if (!ObjectUtils.equivalent(getShipmentStatusCode(), this.tempShipmentStatusCode_)) {
/* 41 */       setShipmentStatusCode(this.tempShipmentStatusCode_);
/*    */     }
/*    */     
/* 44 */     for (IShipmentLineItem lineItem : getShipmentLineItems()) {
/* 45 */       lineItem.commitTemp();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDestinationIdAsString() {
/* 52 */     String destinationType = (getDestinationType() != null) ? getDestinationType() : "";
/*    */     
/* 54 */     switch (destinationType) {
/*    */       case "PARTY":
/* 56 */         return String.valueOf(getDestinationPartyId());
/*    */       case "RETAIL_LOCATION":
/* 58 */         return String.valueOf(getDestinationRetailLocationId());
/*    */       case "SERVICE_LOCATION":
/* 60 */         return getDestinationServiceLocationId();
/*    */     } 
/* 62 */     return "";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTempShipmentStatusCode() {
/* 69 */     return this.tempShipmentStatusCode_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTempShipmentStatusCode(String newValue) {
/* 75 */     this.tempShipmentStatusCode_ = newValue;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void startTemp() {
/* 81 */     if (getShipmentStatusCode() != null) {
/* 82 */       this.tempShipmentStatusCode_ = getShipmentStatusCode();
/*    */     }
/*    */     
/* 85 */     for (IShipmentLineItem lineItem : getShipmentLineItems())
/* 86 */       lineItem.startTemp(); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipmentBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */