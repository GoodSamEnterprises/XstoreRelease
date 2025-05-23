/*    */ package dtv.data2;
/*    */ 
/*    */ import dtv.util.CompositeObject;
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
/*    */ public class SimplePersistenceDefaults
/*    */   implements IPersistenceDefaults
/*    */ {
/*    */   private boolean _isTraining = false;
/* 23 */   private long _workstationId = -1L;
/* 24 */   private int _retailLocationId = -1;
/* 25 */   private String _currencyId = "USD";
/* 26 */   private long _organizationId = -1L;
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCurrencyId() {
/* 31 */     return this._currencyId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Long getOrganizationId() {
/* 37 */     return Long.valueOf(this._organizationId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<CompositeObject.TwoPiece<String, String>> getOrgHierarchyAncestry() {
/* 43 */     return Arrays.asList((CompositeObject.TwoPiece<String, String>[])new CompositeObject.TwoPiece[] { CompositeObject.make("*", "*") });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getRetailLocationId() {
/* 49 */     return Integer.valueOf(this._retailLocationId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUserId() {
/* 55 */     return "";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Long getWorkstationId() {
/* 61 */     return Long.valueOf(this._workstationId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isTraining() {
/* 67 */     return this._isTraining;
/*    */   }
/*    */   
/*    */   public void setCurrencyId(String argCurrencyId) {
/* 71 */     this._currencyId = argCurrencyId;
/*    */   }
/*    */   
/*    */   public void setOrganizationId(long argOrganizationId) {
/* 75 */     this._organizationId = argOrganizationId;
/*    */   }
/*    */   
/*    */   public void setRetailLocationId(int argRetailLocationId) {
/* 79 */     this._retailLocationId = argRetailLocationId;
/*    */   }
/*    */   
/*    */   public void setTraining(boolean argIsTraining) {
/* 83 */     this._isTraining = argIsTraining;
/*    */   }
/*    */   
/*    */   public void setWorkstationId(long argWorkstationId) {
/* 87 */     this._workstationId = argWorkstationId;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\SimplePersistenceDefaults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */