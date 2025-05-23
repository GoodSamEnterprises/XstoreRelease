/*    */ package dtv.data2.access.pm;
/*    */ 
/*    */ import dtv.data2.access.impl.IPersistenceStrategy;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PmStrategyInfo
/*    */ {
/*    */   private IPersistenceStrategy strategy_;
/*    */   private boolean isCurrentlyAvailable_;
/*    */   
/*    */   public PmStrategyInfo(IPersistenceStrategy argStrategy, boolean argIsAvaliable) {
/* 27 */     this.strategy_ = argStrategy;
/* 28 */     this.isCurrentlyAvailable_ = argIsAvaliable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IPersistenceStrategy getStrategy() {
/* 36 */     return this.strategy_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isCurrentlyAvailable() {
/* 45 */     return this.isCurrentlyAvailable_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\PmStrategyInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */