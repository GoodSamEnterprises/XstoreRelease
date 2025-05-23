/*    */ package dtv.pos.iframework.validation;
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
/*    */ public final class ValidationDataType
/*    */ {
/* 16 */   public static final ValidationDataType OBJECT_ARRAY = new ValidationDataType("ObjectArray");
/*    */ 
/*    */   
/* 19 */   public static final ValidationDataType OBJECT = new ValidationDataType("Object");
/*    */ 
/*    */   
/* 22 */   public static final ValidationDataType STRING = new ValidationDataType("String");
/*    */ 
/*    */   
/* 25 */   public static final ValidationDataType INT = new ValidationDataType("int");
/*    */ 
/*    */   
/* 28 */   public static final ValidationDataType DOUBLE = new ValidationDataType("double");
/*    */ 
/*    */   
/* 31 */   public static final ValidationDataType BIG_DECIMAL = new ValidationDataType("BigDecimal");
/*    */ 
/*    */   
/* 34 */   public static final ValidationDataType MONEY = new ValidationDataType("Money");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private ValidationDataType(String argName) {
/* 47 */     this.name_ = argName.trim().toUpperCase();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     return this.name_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\ValidationDataType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */