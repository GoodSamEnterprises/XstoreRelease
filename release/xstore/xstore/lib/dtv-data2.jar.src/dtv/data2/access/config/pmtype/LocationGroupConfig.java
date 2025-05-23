/*    */ package dtv.data2.access.config.pmtype;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
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
/*    */ public class LocationGroupConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private final List<DataSourceLocationConfig> lookupConfigs_ = new ArrayList<>();
/* 23 */   private final List<DataSourceLocationConfig> persistenceConfigs_ = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean sorted_ = false;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DataSourceLocationConfig> getLookupLocations() {
/* 33 */     sort();
/* 34 */     return this.lookupConfigs_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DataSourceLocationConfig> getPersistenceLocations() {
/* 42 */     sort();
/* 43 */     return this.persistenceConfigs_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 48 */     if (argValue instanceof DataSourceLocationConfig) {
/* 49 */       DataSourceLocationConfig value = (DataSourceLocationConfig)argValue;
/* 50 */       if ("LookupLocation".equalsIgnoreCase(argKey)) {
/*    */         
/* 52 */         if (value.getOrder() < 0) {
/* 53 */           value.setOrder(this.lookupConfigs_.size());
/*    */         }
/* 55 */         this.lookupConfigs_.add(value);
/*    */         return;
/*    */       } 
/* 58 */       if ("PersistenceLocation".equalsIgnoreCase(argKey)) {
/*    */         
/* 60 */         if (value.getOrder() < 0) {
/* 61 */           value.setOrder(this.persistenceConfigs_.size());
/*    */         }
/* 63 */         this.persistenceConfigs_.add(value);
/*    */         return;
/*    */       } 
/*    */     } 
/* 67 */     warnUnsupported(argKey, argValue);
/*    */   }
/*    */   
/*    */   private void sort() {
/* 71 */     if (!this.sorted_) {
/* 72 */       Collections.sort(this.lookupConfigs_);
/* 73 */       Collections.sort(this.persistenceConfigs_);
/* 74 */       this.sorted_ = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\pmtype\LocationGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */