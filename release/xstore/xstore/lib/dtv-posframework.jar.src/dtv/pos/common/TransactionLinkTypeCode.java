/*    */ package dtv.pos.common;
/*    */ 
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
/*    */ public class TransactionLinkTypeCode
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(TransactionLinkTypeCode.class);
/*    */ 
/*    */   
/* 21 */   public static final TransactionLinkTypeCode RESUME_TRANSACTION = new TransactionLinkTypeCode("RESUME_TRANSACTION");
/*    */ 
/*    */ 
/*    */   
/* 25 */   public static final TransactionLinkTypeCode DEFERRED_INVOICE_TRANSACTION = new TransactionLinkTypeCode("DEFERRED_INVOICE_TRANSACTION");
/*    */ 
/*    */ 
/*    */   
/* 29 */   public static final TransactionLinkTypeCode DEFERRED_TAXFREE_TRANSACTION = new TransactionLinkTypeCode("DEFERRED_TAXFREE_TRANSACTION");
/*    */ 
/*    */ 
/*    */   
/* 33 */   public static final TransactionLinkTypeCode VOID_INVOICE_TRANSACTION = new TransactionLinkTypeCode("VOID_INVOICE_TRANSACTION");
/*    */ 
/*    */ 
/*    */   
/* 37 */   public static final TransactionLinkTypeCode VOID_TAXFREE_TRANSACTION = new TransactionLinkTypeCode("VOID_TAXFREE_TRANSACTION");
/*    */ 
/*    */ 
/*    */   
/* 41 */   public static final TransactionLinkTypeCode REISSUE_TAXFREE_TRANSACTION = new TransactionLinkTypeCode("REISSUE_TAXFREE_TRANSACTION");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, TransactionLinkTypeCode> values_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TransactionLinkTypeCode forName(String argName) {
/* 57 */     if (argName == null) {
/* 58 */       return null;
/*    */     }
/* 60 */     TransactionLinkTypeCode found = values_.get(argName.trim().toUpperCase());
/* 61 */     if (found == null) {
/* 62 */       logger_.warn("There is no instance of [" + TransactionLinkTypeCode.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 65 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private TransactionLinkTypeCode(String argName) {
/* 77 */     this.name_ = argName.trim().toUpperCase();
/* 78 */     if (values_ == null) {
/* 79 */       values_ = new HashMap<>();
/*    */     }
/* 81 */     values_.put(this.name_, this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 85 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 95 */     return getName();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\TransactionLinkTypeCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */