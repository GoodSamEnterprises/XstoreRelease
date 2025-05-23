/*    */ package dtv.data2.access.config.query;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class QueryExpressionConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 21 */   private String expression_ = null;
/* 22 */   private String trigger_ = null;
/* 23 */   private String parameters_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getExpression() {
/* 31 */     return this.expression_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getParameters() {
/* 40 */     return (this.parameters_ != null) ? this.parameters_ : this.trigger_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTrigger() {
/* 49 */     return this.trigger_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 55 */     if ("trigger".equalsIgnoreCase(argKey)) {
/* 56 */       this.trigger_ = argValue.toString();
/*    */     }
/* 58 */     else if ("parameters".equalsIgnoreCase(argKey)) {
/* 59 */       this.parameters_ = argValue.toString();
/*    */     } else {
/*    */       
/* 62 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(String argValue) {
/* 69 */     this.expression_ = argValue;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\QueryExpressionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */