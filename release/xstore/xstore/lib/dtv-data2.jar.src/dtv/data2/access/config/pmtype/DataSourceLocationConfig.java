/*    */ package dtv.data2.access.config.pmtype;
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
/*    */ public class DataSourceLocationConfig
/*    */   extends AbstractParentConfig
/*    */   implements Comparable<DataSourceLocationConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String dataSourceName_;
/* 21 */   private int order_ = -1;
/*    */ 
/*    */   
/*    */   public int compareTo(DataSourceLocationConfig argOther) {
/* 25 */     return this.order_ - argOther.order_;
/*    */   }
/*    */   
/*    */   public String getDataSourceName() {
/* 29 */     return this.dataSourceName_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getOrder() {
/* 36 */     return this.order_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 41 */     if ("DataSourceName".equalsIgnoreCase(argKey)) {
/* 42 */       this.dataSourceName_ = argValue.toString();
/*    */     }
/* 44 */     else if ("Order".equalsIgnoreCase(argKey)) {
/* 45 */       this.order_ = ConfigUtils.toInt(argValue);
/*    */     } else {
/*    */       
/* 48 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setOrder(int argOrder) {
/* 53 */     this.order_ = argOrder;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\DataSourceLocationConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */