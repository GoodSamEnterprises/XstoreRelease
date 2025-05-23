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
/*    */ public class SavedReportType
/*    */ {
/* 18 */   private static final Logger logger_ = Logger.getLogger(SavedReportType.class);
/*    */ 
/*    */   
/* 21 */   public static final SavedReportType PDF_PRINT = new SavedReportType("PdfPrint");
/* 22 */   public static final SavedReportType REPORT_CRITERIA = new SavedReportType("ReportCriteria");
/* 23 */   public static final SavedReportType HTML = new SavedReportType("html");
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, SavedReportType> values_;
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */   
/*    */   public static SavedReportType forName(String argName) {
/* 36 */     if (argName == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     SavedReportType found = values_.get(argName.trim().toUpperCase());
/* 40 */     if (found == null) {
/* 41 */       logger_.warn("There is no instance of [" + SavedReportType.class
/* 42 */           .getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*    */     }
/*    */     
/* 45 */     return found;
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
/*    */   private SavedReportType(String argName) {
/* 57 */     this.name_ = argName;
/* 58 */     if (values_ == null) {
/* 59 */       values_ = new HashMap<>();
/*    */     }
/* 61 */     values_.put(this.name_.toUpperCase(), this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 70 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 80 */     return "SavedReportType[" + this.name_ + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\type\SavedReportType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */