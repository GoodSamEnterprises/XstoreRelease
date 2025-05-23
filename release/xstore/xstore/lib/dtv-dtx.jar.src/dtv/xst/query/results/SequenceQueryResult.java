/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.DefaultQueryResult;
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
/*    */ public class SequenceQueryResult
/*    */   extends DefaultQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 19 */   private int _returnValue = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getReturnValue() {
/* 27 */     return this._returnValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setReturnValue(int argReturnValue) {
/* 36 */     this._returnValue = argReturnValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\SequenceQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */