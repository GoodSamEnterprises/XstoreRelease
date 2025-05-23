/*    */ package dtv.data2.access.config.query;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
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
/*    */ public class ResultFieldConfig
/*    */   extends AbstractParentConfig
/*    */   implements Comparable<ResultFieldConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   private String name_ = null;
/* 21 */   private int order_ = -1;
/* 22 */   private String type_ = null;
/*    */ 
/*    */   
/*    */   public int compareTo(ResultFieldConfig argOther) {
/* 26 */     return this.order_ - argOther.order_;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 30 */     return this.name_;
/*    */   }
/*    */   
/*    */   public int getOrder() {
/* 34 */     return this.order_;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 38 */     return this.type_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 43 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 44 */       this.name_ = argValue.toString();
/*    */     }
/* 46 */     else if ("Order".equalsIgnoreCase(argKey)) {
/* 47 */       this.order_ = ConfigUtils.toInt(argValue);
/*    */     }
/* 49 */     else if ("type".equalsIgnoreCase(argKey)) {
/* 50 */       this.type_ = argValue.toString();
/*    */     } else {
/*    */       
/* 53 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setOrder(int argOrder) {
/* 58 */     this.order_ = argOrder;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\query\ResultFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */