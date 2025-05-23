/*    */ package dtv.pos.iframework.validation;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.util.security.ISecured;
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
/*    */ public interface IValidationResult
/*    */   extends ISecured
/*    */ {
/* 18 */   public static final IValidationResult SUCCESS = new SimpleValidationResult();
/*    */   
/*    */   IFormattable getMessage();
/*    */   
/*    */   boolean isSecured();
/*    */   
/*    */   boolean isValid();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\IValidationResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */