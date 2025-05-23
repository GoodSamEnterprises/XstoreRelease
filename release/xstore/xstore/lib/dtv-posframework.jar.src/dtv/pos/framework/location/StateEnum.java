/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.pos.framework.reporting.fill.CommonReportParameters;
/*    */ import dtv.pos.iframework.reporting.IReportParamChoiceLoader;
/*    */ import dtv.util.address.AddressService;
/*    */ import dtv.util.address.IAddressServiceInstance;
/*    */ import dtv.xst.dao.loc.IRetailLocation;
/*    */ import dtv.xst.dao.loc.RetailLocationId;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public class StateEnum
/*    */   implements IReportParamChoiceLoader
/*    */ {
/*    */   public final List<Object> getInstances() {
/* 30 */     IAddressServiceInstance as = AddressService.getInternalInstance().getAddressServiceInstance("REPORTING", new byte[] { 32 });
/*    */ 
/*    */ 
/*    */     
/* 34 */     RetailLocationId rtlLocId = new RetailLocationId();
/*    */     
/* 36 */     rtlLocId.setRetailLocationId((Long)CommonReportParameters.RETAIL_LOCATION_ID.getValue());
/* 37 */     IRetailLocation rtlLoc = (IRetailLocation)DataFactory.getObjectByIdNoThrow((IObjectId)rtlLocId);
/*    */     
/* 39 */     as.setCountry(rtlLoc.getCountry());
/*    */     
/* 41 */     return Arrays.asList(as.getArrayForField("state"));
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StateEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */