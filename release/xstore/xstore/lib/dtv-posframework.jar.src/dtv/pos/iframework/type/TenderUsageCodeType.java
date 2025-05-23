/*    */ package dtv.pos.iframework.type;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ public final class TenderUsageCodeType
/*    */   extends AbstractCodeEnum<TenderUsageCodeType>
/*    */ {
/* 19 */   private static final Logger logger_ = Logger.getLogger(TenderUsageCodeType.class);
/*    */ 
/*    */   
/* 22 */   public static final TenderUsageCodeType SALE = new TenderUsageCodeType("SALE");
/* 23 */   public static final TenderUsageCodeType RETURN_WITHRECEIPT = new TenderUsageCodeType("RETURN_WITHRECEIPT");
/* 24 */   public static final TenderUsageCodeType CHANGE = new TenderUsageCodeType("CHANGE");
/* 25 */   public static final TenderUsageCodeType RETURN_WITHOUTRECEIPT = new TenderUsageCodeType("RETURN_WITHOUTRECEIPT");
/*    */   
/* 27 */   public static final TenderUsageCodeType EXCHANGE = new TenderUsageCodeType("EXCHANGE");
/* 28 */   public static final TenderUsageCodeType VOID = new TenderUsageCodeType("VOID");
/* 29 */   public static final TenderUsageCodeType SIGNATURE_REQ_FLOOR_LIMIT = new TenderUsageCodeType("SIGNATURE_REQ_FLOOR_LIMIT");
/*    */   
/* 31 */   public static final TenderUsageCodeType SIGNATURE_REQ_FLOOR_LIMIT_NEG = new TenderUsageCodeType("SIGNATURE_REQ_FLOOR_LIMIT_NEG");
/*    */   
/* 33 */   public static final TenderUsageCodeType DEFAULT = new TenderUsageCodeType("DEFAULT");
/*    */ 
/*    */   
/*    */   private static Map<String, TenderUsageCodeType> values_;
/*    */ 
/*    */   
/* 39 */   private static TenderUsageCodeType[] sortedInstances_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TenderUsageCodeType forName(String argName) {
/* 48 */     if (argName == null) {
/* 49 */       return null;
/*    */     }
/* 51 */     TenderUsageCodeType found = values_.get(argName.trim().toUpperCase());
/* 52 */     if (found == null) {
/* 53 */       logger_.warn("There is no instance of [" + TenderUsageCodeType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 56 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TenderUsageCodeType[] getInstances() {
/* 65 */     if (sortedInstances_ == null) {
/* 66 */       sortedInstances_ = (TenderUsageCodeType[])values_.values().toArray((Object[])new TenderUsageCodeType[0]);
/* 67 */       Arrays.sort((Object[])sortedInstances_);
/*    */     } 
/* 69 */     return sortedInstances_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected TenderUsageCodeType(String argName) {
/* 78 */     super(TenderUsageCodeType.class, argName);
/* 79 */     if (values_ == null) {
/* 80 */       values_ = new HashMap<>();
/*    */     }
/* 82 */     values_.put(getName(), this);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\TenderUsageCodeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */