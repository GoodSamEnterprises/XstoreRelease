/*    */ package dtv.pos.iframework.form;
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
/*    */ public interface ICardinality
/*    */ {
/* 14 */   public static final ICardinality REQUIRED = new Cardinality("1..1");
/*    */ 
/*    */   
/* 17 */   public static final ICardinality OPTIONAL = new Cardinality("0..1");
/*    */ 
/*    */   
/* 20 */   public static final ICardinality NOT_AVAILABLE = new Cardinality("0..0");
/*    */ 
/*    */   
/* 23 */   public static final ICardinality OPTIONAL_UNBOUNDED = new Cardinality("0..*");
/*    */ 
/*    */   
/* 26 */   public static final ICardinality REQUIRED_UNBOUNDED = new Cardinality("1..*");
/*    */   
/*    */   Integer getMaximum();
/*    */   
/*    */   int getMinimum();
/*    */   
/*    */   boolean isArray();
/*    */   
/*    */   boolean isAvailable();
/*    */   
/*    */   boolean isBounded();
/*    */   
/*    */   boolean isRequired();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\ICardinality.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */