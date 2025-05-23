/*    */ package dtv.pos.common;
/*    */ 
/*    */ import dtv.pos.iframework.type.AbstractCodeEnum;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class TransactionStatus
/*    */   extends AbstractCodeEnum<TransactionStatus>
/*    */ {
/* 22 */   private static final Logger logger_ = Logger.getLogger(TransactionStatus.class);
/*    */ 
/*    */   
/* 25 */   public static final TransactionStatus COMPLETE = new TransactionStatus("COMPLETE");
/* 26 */   public static final TransactionStatus CANCEL = new TransactionStatus("CANCEL");
/* 27 */   public static final TransactionStatus CANCEL_ORPHANED = new TransactionStatus("CANCEL_ORPHANED");
/* 28 */   public static final TransactionStatus NEW = new TransactionStatus("NEW");
/* 29 */   public static final TransactionStatus RESUME = new TransactionStatus("RESUME");
/* 30 */   public static final TransactionStatus SUSPEND = new TransactionStatus("SUSPEND");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, TransactionStatus> values_;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TransactionStatus forName(String argName) {
/* 44 */     if (argName == null) {
/* 45 */       return null;
/*    */     }
/* 47 */     TransactionStatus found = values_.get(argName.trim().toUpperCase());
/* 48 */     if (found == null) {
/* 49 */       logger_.warn("There is no instance of [" + TransactionStatus.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 52 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected TransactionStatus(String argName) {
/* 61 */     super(TransactionStatus.class, argName);
/* 62 */     if (values_ == null) {
/* 63 */       values_ = new HashMap<>();
/*    */     }
/* 65 */     values_.put(getCode(), this);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\TransactionStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */