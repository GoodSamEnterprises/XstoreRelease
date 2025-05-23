/*    */ package dtv.pos.framework.systemcycle;
/*    */ 
/*    */ import dtv.pos.iframework.security.StationState;
/*    */ import dtv.util.DateUtils;
/*    */ import dtv.util.IDateProvider;
/*    */ import dtv.util.IDateTimeProvider;
/*    */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
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
/*    */ 
/*    */ public class TransDateProvider
/*    */   implements IDateTimeProvider, IDateProvider
/*    */ {
/*    */   @Inject
/*    */   private StationState _stationState;
/*    */   private boolean _useSystemDate = true;
/*    */   
/*    */   public Date getDate() {
/* 31 */     if (!this._useSystemDate && 
/* 32 */       this._stationState != null) {
/* 33 */       return (Date)this._stationState.getCurrentBusinessDate();
/*    */     }
/*    */     
/* 36 */     return DateUtils.clearTime(DateUtils.getNewDate());
/*    */   }
/*    */ 
/*    */   
/*    */   public Date getDateTime() {
/* 41 */     if (!this._useSystemDate && 
/* 42 */       this._stationState != null) {
/* 43 */       return (Date)this._stationState.getCurrentBusinessDate();
/*    */     }
/*    */     
/* 46 */     return DateUtils.getNewDate();
/*    */   }
/*    */   
/*    */   public Date getDateTime(IRetailTransactionLineItem argLine) {
/* 50 */     if (!this._useSystemDate) {
/* 51 */       return argLine.getBusinessDate();
/*    */     }
/* 53 */     return argLine.getBeginDateTimestamp();
/*    */   }
/*    */   
/*    */   public IDateTimeProvider getDateTimeProvider(IRetailTransactionLineItem argLine) {
/* 57 */     return () -> getDateTime(argLine);
/*    */   }
/*    */   
/*    */   public boolean getUseSystemDate() {
/* 61 */     return this._useSystemDate;
/*    */   }
/*    */   
/*    */   public void setUseSystemDate(boolean argUseSystemDate) {
/* 65 */     this._useSystemDate = argUseSystemDate;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\systemcycle\TransDateProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */