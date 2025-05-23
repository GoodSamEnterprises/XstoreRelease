/*    */ package dtv.pos.framework.reporting.type;
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
/*    */ public class ReportParamComponentType
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(ReportParamComponentType.class);
/*    */ 
/*    */   
/* 21 */   public static final ReportParamComponentType TEXT = new ReportParamComponentType("Text");
/*    */ 
/*    */   
/* 24 */   public static final ReportParamComponentType COMBO = new ReportParamComponentType("Combo");
/* 25 */   public static final ReportParamComponentType MULTI_SELECT_LIST = new ReportParamComponentType("MultiSelectList");
/*    */   
/* 27 */   public static final ReportParamComponentType SINGLE_SELECT_LIST = new ReportParamComponentType("SingleSelectList");
/*    */ 
/*    */   
/* 30 */   public static final ReportParamComponentType DATE = new ReportParamComponentType("Date");
/* 31 */   public static final ReportParamComponentType DATE_RANGE = new ReportParamComponentType("DateRange");
/* 32 */   public static final ReportParamComponentType TIME_INT = new ReportParamComponentType("TimeInt");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, ReportParamComponentType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static ReportParamComponentType forName(String argName) {
/* 45 */     if (argName == null) {
/* 46 */       return null;
/*    */     }
/* 48 */     ReportParamComponentType t = values_.get(argName.trim().toUpperCase());
/* 49 */     if (t == null) {
/* 50 */       logger_.warn("There is no instance of [" + ReportParamComponentType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 53 */     return t;
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
/*    */   private ReportParamComponentType(String argName) {
/* 65 */     this.name_ = argName.trim().toUpperCase();
/* 66 */     if (values_ == null) {
/* 67 */       values_ = new HashMap<>();
/*    */     }
/* 69 */     values_.put(this.name_, this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 78 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 88 */     return "ReportParamComponentType[" + this.name_ + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\type\ReportParamComponentType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */