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
/*    */ 
/*    */ 
/*    */ public enum HttpEncodingType
/*    */ {
/* 17 */   BASE64("base64"),
/*    */   
/* 19 */   GZIP("gzip"),
/*    */   
/* 21 */   UTF8("UTF-8");
/*    */ 
/*    */ 
/*    */   
/*    */   private final String _value;
/*    */ 
/*    */ 
/*    */   
/*    */   HttpEncodingType(String argValue) {
/* 30 */     this._value = argValue;
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
/* 41 */     return this._value.equalsIgnoreCase(argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     return this._value;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\remote\HttpEncodingType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */