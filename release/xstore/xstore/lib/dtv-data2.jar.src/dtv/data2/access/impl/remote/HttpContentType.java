/*    */ package dtv.data2.access.impl.remote;
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
/*    */ public enum HttpContentType
/*    */ {
/* 15 */   BINARY("application/octet-stream"),
/*    */   
/* 17 */   SOAP_XML("text/xml;charset=utf-8"),
/*    */   
/* 19 */   TEXT("text/plain");
/*    */ 
/*    */ 
/*    */   
/*    */   private final String _value;
/*    */ 
/*    */ 
/*    */   
/*    */   HttpContentType(String argValue) {
/* 28 */     this._value = argValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(String argValue) {
/* 39 */     return this._value.equalsIgnoreCase(argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     return this._value;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\remote\HttpContentType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */