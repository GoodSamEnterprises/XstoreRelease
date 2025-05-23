/*    */ package dtv.data2.access;
/*    */ 
/*    */ import dtv.data2x.impl.req.NoRecordsFoundException;
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
/*    */ public class ObjectNotFoundException
/*    */   extends NoRecordsFoundException
/*    */ {
/*    */   private static final long serialVersionUID = 6733387471557595868L;
/*    */   
/*    */   public ObjectNotFoundException() {
/* 21 */     super((String)null);
/*    */   }
/*    */   
/*    */   public ObjectNotFoundException(String message) {
/* 25 */     super(message);
/*    */   }
/*    */   
/*    */   public ObjectNotFoundException(String message, Throwable cause) {
/* 29 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public ObjectNotFoundException(Throwable cause) {
/* 33 */     super(cause);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\ObjectNotFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */