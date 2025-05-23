/*    */ package dtv.xst.dao.inv.impl;
/*    */ 
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.inv.IInventoryCount;
/*    */ import dtv.xst.dao.inv.IInventoryCountBucket;
/*    */ import dtv.xst.dao.inv.IInventoryCountModel;
/*    */ import dtv.xst.dao.inv.IInventoryCountProperty;
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
/*    */ public abstract class InventoryCountBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IInventoryCountProperty>
/*    */   implements IInventoryCount, IInventoryCountModel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private transient boolean _variancesAdjusted = true;
/*    */   private transient List<InventoryCountSheetResult> _countSheetResults;
/*    */   
/*    */   public List<InventoryCountSheetResult> getCountSheetResults() {
/* 31 */     return this._countSheetResults;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getFinalVariancesAdjusted() {
/* 37 */     return this._variancesAdjusted;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCountSheetResults(List<InventoryCountSheetResult> argCountSheetResults) {
/* 43 */     this._countSheetResults = argCountSheetResults;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setFinalVariancesAdjusted(boolean argVariancesAdjusted) {
/* 49 */     this._variancesAdjusted = argVariancesAdjusted;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateCountBucket(String argBucketId, int argNewCycle, String argStatus) {
/* 55 */     List<IInventoryCountBucket> countBuckets = getInventoryCountBuckets();
/*    */     
/* 57 */     for (IInventoryCountBucket countBucket : countBuckets) {
/* 58 */       if (countBucket.getInventoryBucketId().equals(argBucketId)) {
/* 59 */         countBucket.setCountCycle(argNewCycle);
/* 60 */         countBucket.setBucketStatus(argStatus);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */