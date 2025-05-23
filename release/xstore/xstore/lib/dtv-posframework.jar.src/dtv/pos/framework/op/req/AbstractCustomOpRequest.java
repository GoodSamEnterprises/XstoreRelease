/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.iframework.op.req.ICustomOpRequest;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractCustomOpRequest
/*    */   implements ICustomOpRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String getRequestType() {
/* 38 */     return OpRequestType.DEFAULT.name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\AbstractCustomOpRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */