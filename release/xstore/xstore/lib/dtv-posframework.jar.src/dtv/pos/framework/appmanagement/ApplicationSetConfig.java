/*    */ package dtv.pos.framework.appmanagement;
/*    */ 
/*    */ import dtv.pos.framework.ApplicationData;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ApplicationSetConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private ApplicationData[] applicationData_;
/* 24 */   private Map<String, ApplicationConfig> _apps = new HashMap<>();
/*    */   
/*    */   public ApplicationData[] getApplicationData() {
/* 27 */     if (this.applicationData_ == null) {
/* 28 */       List<ApplicationData> appDataList = new ArrayList<>();
/*    */       
/* 30 */       for (ApplicationConfig appCfg : this._apps.values()) {
/*    */ 
/*    */         
/* 33 */         if (!appCfg.getIsEnabled()) {
/*    */           continue;
/*    */         }
/*    */         
/* 37 */         appDataList.add(appCfg.getApplicationData());
/*    */       } 
/* 39 */       this.applicationData_ = appDataList.<ApplicationData>toArray(new ApplicationData[0]);
/*    */     } 
/* 41 */     return this.applicationData_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 47 */     if (argValue instanceof ApplicationConfig) {
/* 48 */       ApplicationConfig app = (ApplicationConfig)argValue;
/* 49 */       this._apps.put(app.getKey(), app);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\appmanagement\ApplicationSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */