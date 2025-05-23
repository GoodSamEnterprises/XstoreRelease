/*    */ package dtv.pos.iframework.op.req;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public interface IOpRequest
/*    */   extends Serializable
/*    */ {
/*    */   String getRequestType();
/*    */   
/*    */   default String getUiRequestKey() {
/* 25 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\req\IOpRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */