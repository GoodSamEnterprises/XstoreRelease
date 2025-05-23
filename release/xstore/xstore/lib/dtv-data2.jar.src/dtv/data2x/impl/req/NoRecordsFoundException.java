/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.service.ServiceException;
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
/*    */ public class NoRecordsFoundException
/*    */   extends ServiceException
/*    */ {
/*    */   private static final long serialVersionUID = 4642053214166069535L;
/*    */   
/*    */   public NoRecordsFoundException(String argMessage) {
/* 28 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NoRecordsFoundException(String argMessage, Throwable argCause) {
/* 38 */     super(argMessage, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NoRecordsFoundException(Throwable argCause) {
/* 46 */     super(argCause);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\NoRecordsFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */