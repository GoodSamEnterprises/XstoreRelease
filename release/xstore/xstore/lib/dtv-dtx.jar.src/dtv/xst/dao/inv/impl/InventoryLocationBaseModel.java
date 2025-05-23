/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.inv.IInventoryLocation;
/*    */ import dtv.xst.dao.inv.IInventoryLocationAvailability;
/*    */ import dtv.xst.dao.inv.IInventoryLocationModel;
/*    */ import dtv.xst.dao.inv.IInventoryLocationProperty;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public abstract class InventoryLocationBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IInventoryLocationProperty>
/*    */   implements IInventoryLocation, IInventoryLocationModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private transient Map<String, IInventoryLocationAvailability> availCodeMap_ = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public IInventoryLocationAvailability getAvailabilityByCode(String argCode) {
/* 31 */     Map<String, IInventoryLocationAvailability> codeMap = getAvailabilityCodeMap();
/*    */     
/* 33 */     if (codeMap.isEmpty()) {
/* 34 */       for (IInventoryLocationAvailability availability : getAvailabilityCodes()) {
/* 35 */         codeMap.put(availability.getAvailabilityCode(), availability);
/*    */       }
/*    */     }
/*    */     
/* 39 */     return codeMap.get(argCode);
/*    */   }
/*    */   
/*    */   private Map<String, IInventoryLocationAvailability> getAvailabilityCodeMap() {
/* 43 */     if (this.availCodeMap_ == null) {
/* 44 */       this.availCodeMap_ = new HashMap<>(12);
/*    */     }
/*    */     
/* 47 */     return this.availCodeMap_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */