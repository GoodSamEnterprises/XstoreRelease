/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.pos.iframework.reporting.IReportQueryParam;
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
/*    */ public class ReportQueryParam
/*    */   implements IReportQueryParam
/*    */ {
/*    */   private final String queryString;
/*    */   private final String description;
/*    */   
/*    */   public ReportQueryParam(String argQueryString, String argDescription) {
/* 22 */     this.queryString = argQueryString;
/* 23 */     this.description = argDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 31 */     return this.description;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getQueryString() {
/* 39 */     return this.queryString;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\ReportQueryParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */