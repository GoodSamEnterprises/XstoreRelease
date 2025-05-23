/*    */ package dtv.pos.framework.appmanagement;
/*    */ 
/*    */ import dtv.pos.framework.ApplicationData;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ public class ApplicationConfigHelper
/*    */   extends ConfigHelper<IConfigObject>
/*    */ {
/*    */   private static final String CONFIG_FILE_NAME = "ApplicationConfig";
/* 24 */   private static final List<ApplicationData> applications_ = new ArrayList<>();
/* 25 */   private static final Map<Object, ApplicationData> applicationMap_ = new HashMap<>();
/* 26 */   private static final Logger logger_ = Logger.getLogger(ApplicationConfigHelper.class);
/*    */   
/*    */   private static ApplicationConfigHelper INSTANCE;
/*    */   
/*    */   public static ApplicationConfigHelper getInstance() {
/* 31 */     if (INSTANCE == null) {
/* 32 */       INSTANCE = new ApplicationConfigHelper();
/*    */     }
/* 34 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   private ApplicationConfigHelper() {
/* 39 */     initialize();
/*    */   }
/*    */   
/*    */   public List<ApplicationData> getAllApplicationData() {
/* 43 */     return applications_;
/*    */   }
/*    */   
/*    */   public ApplicationData getApplicationData(Object applicationKey) {
/* 47 */     ApplicationData data = applicationMap_.get(applicationKey);
/* 48 */     if (data == null) {
/* 49 */       logger_.warn("No application found for [" + applicationKey + "]!");
/*    */     }
/* 51 */     return data;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 57 */     if ("ApplicationSet".equals(argDtype)) {
/* 58 */       return (IConfigObject)new ApplicationSetConfig();
/*    */     }
/* 60 */     if ("Application".equals(argDtype)) {
/* 61 */       return (IConfigObject)new ApplicationConfig();
/*    */     }
/*    */     
/* 64 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 71 */     super.initializeImpl();
/*    */     
/* 73 */     IConfigObject root = getRootConfig();
/* 74 */     if (root == null) {
/* 75 */       logger_.warn("No application configuration found!");
/*    */       return;
/*    */     } 
/* 78 */     if (!(root instanceof ApplicationSetConfig)) {
/* 79 */       logger_.warn("Applications configured with improper object type: [" + root + "]!");
/*    */       
/*    */       return;
/*    */     } 
/* 83 */     ApplicationData[] applications = ((ApplicationSetConfig)root).getApplicationData();
/*    */     
/* 85 */     for (ApplicationData application : applications) {
/* 86 */       if (application != null) {
/* 87 */         applicationMap_.put(application.getKey(), application);
/* 88 */         applications_.add(application);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 96 */     return "ApplicationConfig";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\appmanagement\ApplicationConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */