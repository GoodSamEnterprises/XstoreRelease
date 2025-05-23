/*    */ package dtv.logbuilder.model;
/*    */ 
/*    */ import dtv.pos.framework.scope.TransactionScope;
/*    */ import dtv.pos.iframework.security.StationState;
/*    */ import dtv.util.DateUtils;
/*    */ import dtv.util.temp.InjectionHammer;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
/*    */ import dtv.xst.daocommon.ISystemUser;
/*    */ import java.util.Date;
/*    */ import javax.inject.Inject;
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
/*    */ public abstract class AbstractLogModel
/*    */   implements ILoggableModel
/*    */ {
/* 26 */   private final Date systemDateTimeStamp_ = DateUtils.getNewDate();
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private TransactionScope _transactionScope;
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject
/*    */   protected StationState _stationState;
/*    */ 
/*    */ 
/*    */   
/*    */   protected AbstractLogModel() {
/* 41 */     InjectionHammer.forceAtInjectProcessing(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAction() {
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public Date getBusinessDate() {
/* 55 */     return getCurrentBusinessDate();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Date getCurrentBusinessDate() {
/* 61 */     return (Date)this._stationState.getCurrentBusinessDate();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IPosTransaction getRelatedTransaction() {
/* 69 */     return this._transactionScope.getTransaction();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getRetailLocationId() {
/* 75 */     return this._stationState.getRetailLocationId();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Date getSystemDateTimeStamp() {
/* 81 */     return this.systemDateTimeStamp_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ISystemUser getSystemUser() {
/* 87 */     return this._stationState.getSystemUser();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getWorkstationId() {
/* 93 */     return this._stationState.getWorkstationId();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\model\AbstractLogModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */