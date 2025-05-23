/*    */ package dtv.data2x.impl.req;
/*    */ 
/*    */ import dtv.service.ServiceException;
/*    */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*    */ public class TooManyRecordsFoundException
/*    */   extends ServiceException
/*    */ {
/*    */   private static final long serialVersionUID = -131334987695368224L;
/*    */   private final int _maxRecords;
/*    */   
/*    */   public TooManyRecordsFoundException(String argMessage) {
/* 32 */     this(argMessage, -2147483648);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TooManyRecordsFoundException(String argMessage, int argMaxRecords) {
/* 42 */     super(argMessage);
/* 43 */     this._maxRecords = argMaxRecords;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TooManyRecordsFoundException(String argMessage, Throwable argCause) {
/* 53 */     this(argMessage, argCause, -2147483648);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TooManyRecordsFoundException(String argMessage, Throwable argCause, int argMaxRecords) {
/* 64 */     super(argMessage, argCause);
/* 65 */     this._maxRecords = argMaxRecords;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TooManyRecordsFoundException(Throwable argCause) {
/* 73 */     this(argCause, -2147483648);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TooManyRecordsFoundException(Throwable argCause, int argMaxRecords) {
/* 83 */     super(argCause);
/* 84 */     this._maxRecords = argMaxRecords;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaximumRecords() {
/* 92 */     return (this._maxRecords >= 0) ? this._maxRecords : -1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 98 */     return (new ToStringBuilder(this)).append("maxRecords", (this._maxRecords >= 0) ? Integer.valueOf(this._maxRecords) : "?").toString();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\impl\req\TooManyRecordsFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */