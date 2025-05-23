/*    */ package dtv.xst.dao.loc.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.util.address.IAddress;
/*    */ import dtv.xst.dao.loc.IRetailLocation;
/*    */ import dtv.xst.dao.loc.IRetailLocationModel;
/*    */ import dtv.xst.dao.loc.IRetailLocationProperty;
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
/*    */ 
/*    */ public abstract class RetailLocationBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IRetailLocationProperty>
/*    */   implements IRetailLocation, IRetailLocationModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public IAddress getLocationAddress() {
/* 27 */     return (IAddress)this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLocationId() {
/* 33 */     return String.valueOf(getRetailLocationId());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLocationName1() {
/* 39 */     return getStoreName();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLocationName2() {
/* 46 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\RetailLocationBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */