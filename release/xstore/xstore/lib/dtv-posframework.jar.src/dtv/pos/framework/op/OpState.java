/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.iframework.op.IOpState;
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
/*    */ public class OpState
/*    */   implements IOpState
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String _name;
/*    */   
/*    */   public OpState(String argName) {
/* 28 */     this._name = argName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 34 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     return this._name;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */