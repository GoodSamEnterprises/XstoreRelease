/*    */ package dtv.data2.access.config.query;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class QueryHavingConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String condition_;
/*    */   private String testExpression_;
/* 25 */   private final List<QueryParameterConfig> parameters_ = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCondition() {
/* 33 */     return this.condition_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<QueryParameterConfig> getParameters() {
/* 42 */     return this.parameters_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTestExpression() {
/* 51 */     return this.testExpression_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 57 */     if ("Condition".equalsIgnoreCase(argKey)) {
/* 58 */       this.condition_ = argValue.toString();
/*    */     }
/* 60 */     else if ("TestExpression".equalsIgnoreCase(argKey)) {
/* 61 */       this.testExpression_ = argValue.toString();
/*    */     }
/* 63 */     else if ("Parameter".equalsIgnoreCase(argKey)) {
/* 64 */       this.parameters_.add((QueryParameterConfig)argValue);
/*    */     } else {
/*    */       
/* 67 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QueryHavingConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */