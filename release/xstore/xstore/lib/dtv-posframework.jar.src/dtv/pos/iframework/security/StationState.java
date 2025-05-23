/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.util.DtvDate;
/*    */ import dtv.xst.daocommon.ISystemUser;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StationState
/*    */ {
/*    */   private Integer _retailLocationId;
/*    */   private Integer _workstationId;
/*    */   private ISystemUser _currentUser;
/*    */   private DtvDate _currentBusinessDate;
/*    */   
/*    */   public DtvDate getCurrentBusinessDate() {
/* 34 */     if (this._currentBusinessDate == null) {
/* 35 */       return null;
/*    */     }
/* 37 */     return (DtvDate)this._currentBusinessDate.clone();
/*    */   }
/*    */   
/*    */   public int getRetailLocationId() {
/* 41 */     if (this._retailLocationId != null) {
/* 42 */       return this._retailLocationId.intValue();
/*    */     }
/*    */     
/* 45 */     return -1;
/*    */   }
/*    */   
/*    */   public ISystemUser getSystemUser() {
/* 49 */     return this._currentUser;
/*    */   }
/*    */   
/*    */   public int getWorkstationId() {
/* 53 */     if (this._workstationId != null) {
/* 54 */       return this._workstationId.intValue();
/*    */     }
/*    */     
/* 57 */     return -1;
/*    */   }
/*    */   
/*    */   public synchronized void setBusinessDate(DtvDate argBusinessDate) {
/* 61 */     if (argBusinessDate == null) {
/* 62 */       this._currentBusinessDate = null;
/*    */     } else {
/*    */       
/* 65 */       this._currentBusinessDate = (DtvDate)argBusinessDate.clone();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRetailLocationId(int argRetailLocationId) throws IllegalStateException {
/* 71 */     if (this._retailLocationId == null) {
/* 72 */       this._retailLocationId = Integer.valueOf(argRetailLocationId);
/*    */     }
/* 74 */     else if (!this._retailLocationId.equals(Integer.valueOf(argRetailLocationId))) {
/* 75 */       throw new IllegalStateException(String.format("Invalid state: Overriding the current id of the retail location within the same session is not allowed (I had %d and you wanted %d)", new Object[] { this._retailLocationId, 
/*    */               
/* 77 */               Integer.valueOf(argRetailLocationId) }));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setSystemUser(ISystemUser argSystemUser) {
/* 82 */     this._currentUser = argSystemUser;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorkstationId(int argWorkstationId) throws IllegalStateException {
/* 87 */     if (this._workstationId == null) {
/* 88 */       this._workstationId = Integer.valueOf(argWorkstationId);
/*    */     }
/* 90 */     else if (!this._workstationId.equals(Integer.valueOf(argWorkstationId))) {
/* 91 */       throw new IllegalStateException(String.format("Invalid state: Overriding the current id of the workstation within the same session is not allowed (I had %d and you wanted %d)", new Object[] { this._workstationId, 
/*    */               
/* 93 */               Integer.valueOf(argWorkstationId) }));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\StationState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */