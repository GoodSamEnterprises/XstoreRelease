/*    */ package dtv.xst.dao.cat.impl;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.xst.dao.cat.IDeliveryModifier;
/*    */ import dtv.xst.dao.cat.IDeliveryModifierModel;
/*    */ import dtv.xst.dao.cat.IDeliveryModifierProperty;
/*    */ import dtv.xst.dao.inv.IShipperMethod;
/*    */ import dtv.xst.dao.inv.ShipperMethodId;
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
/*    */ public abstract class DeliveryModifierBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IDeliveryModifierProperty>
/*    */   implements IDeliveryModifier, IDeliveryModifierModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private transient IShipperMethod _shippingMethodObject = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSalutation() {
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IShipperMethod getShippingMethodObject() {
/* 38 */     if (this._shippingMethodObject == null && !StringUtils.isEmpty(getShippingMethod())) {
/* 39 */       this._shippingMethodObject = getShipperMethodForId(getShippingMethod());
/*    */     }
/*    */     
/* 42 */     return this._shippingMethodObject;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSuffix() {
/* 48 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private IShipperMethod getShipperMethodForId(String argShipperMethod) {
/* 57 */     ShipperMethodId id = new ShipperMethodId();
/* 58 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/* 59 */     id.setShipperMethodId(argShipperMethod);
/* 60 */     IShipperMethod shipperMethod = (IShipperMethod)DataFactory.getObjectById((IObjectId)id);
/*    */     
/* 62 */     return shipperMethod;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\DeliveryModifierBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */