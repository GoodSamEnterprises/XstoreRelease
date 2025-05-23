/*    */ package dtv.data2.dataserver;
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
/*    */ public class DataServerQueryResult
/*    */   extends DefaultQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 30 */   private String _errorText = null;
/* 31 */   private int _returnValue = 0;
/*    */   
/*    */   public String getErrorText() {
/* 34 */     return this._errorText;
/*    */   }
/*    */   
/*    */   public int getReturnValue() {
/* 38 */     return this._returnValue;
/*    */   }
/*    */   
/*    */   public void setErrorText(String argErrorText) {
/* 42 */     this._errorText = argErrorText;
/*    */   }
/*    */   
/*    */   public void setReturnValue(int argReturnValue) {
/* 46 */     this._returnValue = argReturnValue;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\DataServerQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */