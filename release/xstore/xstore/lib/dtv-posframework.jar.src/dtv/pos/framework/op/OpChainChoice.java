/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
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
/*    */ public class OpChainChoice
/*    */ {
/* 19 */   private RunChainCondition _runCondition = new AlwaysRun();
/* 20 */   private XstChainActionType _chainType = XstChainActionType.STACK;
/*    */ 
/*    */   
/*    */   private OpChainKey _chainKey;
/*    */ 
/*    */   
/*    */   public OpChainChoice(OpChainKey argChainKey) {
/* 27 */     this._chainKey = argChainKey;
/*    */   }
/*    */   
/*    */   public OpChainKey getChainKey() {
/* 31 */     return this._chainKey;
/*    */   }
/*    */   
/*    */   public XstChainActionType getChainType() {
/* 35 */     return this._chainType;
/*    */   }
/*    */   
/*    */   public RunChainCondition getRunCondition() {
/* 39 */     return this._runCondition;
/*    */   }
/*    */   
/*    */   public void setChainType(XstChainActionType argChainType) {
/* 43 */     this._chainType = argChainType;
/*    */   }
/*    */   
/*    */   public void setRunCondition(RunChainCondition argRunCondition) {
/* 47 */     this._runCondition = argRunCondition;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainChoice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */