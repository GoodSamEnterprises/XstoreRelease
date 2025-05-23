/*    */ package dtv.pos.framework.scope;
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
/*    */ public final class ScopeInfo
/*    */ {
/*    */   private String _name;
/*    */   private int _priority;
/*    */   
/*    */   public ScopeInfo(String argName, int argPriority) {
/* 27 */     this._name = argName;
/* 28 */     this._priority = argPriority;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 35 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPriority() {
/* 45 */     return this._priority;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\ScopeInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */