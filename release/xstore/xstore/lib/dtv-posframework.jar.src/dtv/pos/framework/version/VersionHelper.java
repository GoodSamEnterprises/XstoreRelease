/*    */ package dtv.pos.framework.version;
/*    */ 
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
/*    */ public class VersionHelper
/*    */ {
/* 17 */   private static final String IMPL_KEY = IVersionHelper.class.getName();
/* 18 */   private static final Logger _logger = Logger.getLogger(VersionHelper.class);
/*    */   
/* 20 */   private static IVersionHelper _instance = null;
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
/*    */   public static UniversalVersion getAppVersion(boolean argIncludePatchVersion) {
/* 32 */     UniversalVersion baseAppVersion = getInstance().getBaseAppVersion();
/* 33 */     UniversalVersion customerAppVersion = getInstance().getCustomerAppVersion();
/*    */     
/* 35 */     if (argIncludePatchVersion) {
/* 36 */       customerAppVersion = customerAppVersion.appendVersion(getInstance().getCustomerPatchVersion());
/*    */     }
/* 38 */     return baseAppVersion.appendVersion(customerAppVersion);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IVersionHelper getInstance() {
/* 46 */     if (_instance == null) {
/* 47 */       String className = System.getProperty(IMPL_KEY);
/*    */       
/*    */       try {
/* 50 */         _instance = (IVersionHelper)Class.forName(className).newInstance();
/*    */       }
/* 52 */       catch (Exception ex) {
/* 53 */         _logger.debug("No instance of " + IVersionHelper.class.getName() + " mapped to " + IMPL_KEY + ".  Using default implementation.");
/*    */         
/* 55 */         _instance = new VersionHelperImpl();
/*    */       } 
/*    */     } 
/* 58 */     return _instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static UniversalVersion getSchemaVersion(SchemaVersionScope argScope) {
/* 69 */     UniversalVersion baseSchemaVersion = getInstance().getBaseSchemaVersion(argScope);
/* 70 */     UniversalVersion customerSchemaVersion = getInstance().getCustomerSchemaVersion(argScope);
/*    */     
/* 72 */     return baseSchemaVersion.appendVersion(customerSchemaVersion);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\version\VersionHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */