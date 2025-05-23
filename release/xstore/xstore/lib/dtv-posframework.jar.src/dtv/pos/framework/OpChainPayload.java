/*    */ package dtv.pos.framework;
/*    */ 
/*    */ import dtv.pos.iframework.op.IOpChain;
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
/*    */ public class OpChainPayload
/*    */ {
/*    */   private String _chainKey;
/*    */   private boolean _isDefaultChain;
/*    */   private int _rollbackLevel;
/*    */   
/*    */   public OpChainPayload(IOpChain argChain) {
/* 26 */     this._chainKey = argChain.getChainKey().toString();
/* 27 */     this._isDefaultChain = argChain.isDefault();
/* 28 */     this._rollbackLevel = argChain.getRollbackLevel();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getChainKey() {
/* 35 */     return this._chainKey;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRollbackLevel() {
/* 42 */     return this._rollbackLevel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDefaultChain() {
/* 50 */     return this._isDefaultChain;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     String level = this._isDefaultChain ? (", RB = " + this._rollbackLevel) : "";
/* 57 */     return this._chainKey + " [Default = " + String.valueOf(this._isDefaultChain) + level + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\OpChainPayload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */