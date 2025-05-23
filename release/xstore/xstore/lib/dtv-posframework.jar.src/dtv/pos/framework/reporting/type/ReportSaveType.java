/*    */ package dtv.pos.framework.reporting.type;
/*    */ 
/*    */ import dtv.pos.iframework.type.AbstractCodeEnum;
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
/*    */ 
/*    */ 
/*    */ public class ReportSaveType
/*    */   extends AbstractCodeEnum
/*    */ {
/* 22 */   private static final Logger logger_ = Logger.getLogger(ReportSaveType.class);
/*    */ 
/*    */   
/* 25 */   public static final ReportSaveType INCLUDE_DATA = new ReportSaveType("INCLUDE_DATA");
/* 26 */   public static final ReportSaveType SAVE_PARAMETERS = new ReportSaveType("SAVE_PARAMETERS");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, ReportSaveType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private static ReportSaveType[] sortedInstances_;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ReportSaveType forName(String argName) {
/* 40 */     if (argName == null) {
/* 41 */       return null;
/*    */     }
/* 43 */     ReportSaveType found = values_.get(argName.trim().toUpperCase());
/* 44 */     if (found == null) {
/* 45 */       logger_.warn("There is no instance of [" + ReportSaveType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 48 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ReportSaveType[] getInstances() {
/* 57 */     if (sortedInstances_ == null) {
/* 58 */       sortedInstances_ = (ReportSaveType[])values_.values().toArray((Object[])new ReportSaveType[0]);
/* 59 */       Arrays.sort((Object[])sortedInstances_);
/*    */     } 
/* 61 */     return sortedInstances_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ReportSaveType(String argName) {
/* 71 */     super(ReportSaveType.class, argName);
/* 72 */     if (values_ == null) {
/* 73 */       values_ = new HashMap<>();
/*    */     }
/* 75 */     values_.put(getCode(), this);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\type\ReportSaveType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */