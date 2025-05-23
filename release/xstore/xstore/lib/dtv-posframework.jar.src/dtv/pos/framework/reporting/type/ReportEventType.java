/*    */ package dtv.pos.framework.reporting.type;
/*    */ 
/*    */ import dtv.pos.iframework.event.IXstEventType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportEventType
/*    */   implements IXstEventType
/*    */ {
/* 16 */   public static final ReportEventType REPORT_READY = new ReportEventType("REPORT_READY");
/*    */   
/* 18 */   public static final ReportEventType REPORT_FAILED = new ReportEventType("REPORT_FAILED");
/*    */   
/* 20 */   public static final ReportEventType REPORT_CANCELED = new ReportEventType("REPORT_CANCELED");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String name_;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private ReportEventType(String argName) {
/* 32 */     this.name_ = argName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 41 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return "ReportEventType[" + this.name_ + "]";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\type\ReportEventType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */