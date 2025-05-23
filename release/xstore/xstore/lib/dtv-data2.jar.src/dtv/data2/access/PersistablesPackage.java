/*    */ package dtv.data2.access;
/*    */ 
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
/*    */ public class PersistablesPackage
/*    */ {
/*    */   private final List<IPersistable> _persistables;
/*    */   private final Integer _clientTimeout;
/*    */   
/*    */   PersistablesPackage(List<IPersistable> argPersistables, Integer argClientTimeout) {
/* 20 */     this._persistables = argPersistables;
/* 21 */     this._clientTimeout = argClientTimeout;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getClientTimeout() {
/* 29 */     return this._clientTimeout;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IPersistable> getPersistables() {
/* 37 */     return this._persistables;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\PersistablesPackage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */