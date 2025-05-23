/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import com.micros.xstore.config.report.DataTemplate;
/*    */ import com.micros.xstore.config.report.ParameterType;
/*    */ import com.micros.xstore.config.report.ParametersType;
/*    */ import dtv.pos.iframework.reporting.IReportParam;
/*    */ import dtv.pos.iframework.reporting.IReportParams;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ReportParams
/*    */   implements IReportParams
/*    */ {
/* 25 */   private static final Logger logger_ = Logger.getLogger(ReportParams.class);
/*    */   
/*    */   public static IReportParams make(DataTemplate argDataTemplate) {
/* 28 */     List<IReportParam> paramList = new ArrayList<>();
/*    */     
/* 30 */     ParametersType parameters = argDataTemplate.getParameters();
/*    */     
/* 32 */     if (parameters != null) {
/* 33 */       for (ParameterType parameter : parameters.getParameters()) {
/* 34 */         if (parameter.getIsForPrompting().booleanValue()) {
/* 35 */           String description = parameter.getParameterDescription();
/* 36 */           if (description != null) {
/*    */             try {
/* 38 */               Class<?> valueClass = Class.forName(parameter.getClazz());
/* 39 */               IReportParam p = ReportParam.make(parameter.getName(), valueClass, description);
/* 40 */               paramList.add(p);
/*    */             }
/* 42 */             catch (Exception ex) {
/* 43 */               logger_.error("CAUGHT EXCEPTION with parameter=[" + parameter.getName() + "] and description=[" + parameter
/* 44 */                   .getParameterDescription() + "]", ex);
/*    */             } 
/*    */           }
/*    */         } 
/*    */       } 
/*    */     }
/* 50 */     IReportParam[] params = paramList.<IReportParam>toArray(new IReportParam[paramList.size()]);
/* 51 */     return new ReportParams(params);
/*    */   }
/*    */ 
/*    */   
/*    */   private final IReportParam[] params_;
/*    */   
/*    */   private ReportParams(IReportParam[] argParams) {
/* 58 */     this.params_ = argParams;
/*    */   }
/*    */ 
/*    */   
/*    */   public IReportParam[] getReportParams() {
/* 63 */     return this.params_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\ReportParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */