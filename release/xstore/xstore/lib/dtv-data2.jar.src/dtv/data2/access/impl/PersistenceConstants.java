/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import dtv.util.config.IPropertyConfigurationSource;
/*    */ import dtv.util.config.SystemPropertyConfigurationSource;
/*    */ import java.util.Properties;
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
/*    */ public class PersistenceConstants
/*    */ {
/*    */   public static final boolean MANAGE_CASE;
/*    */   
/*    */   static {
/* 23 */     IPropertyConfigurationSource propertySource = SystemPropertyConfigurationSource.getInstance();
/* 24 */     Properties properties = propertySource.getProperties();
/* 25 */     String caseProp = properties.getProperty(PersistenceConstants.class.getName() + ".manageCase", "true");
/* 26 */     MANAGE_CASE = Boolean.parseBoolean(caseProp);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\PersistenceConstants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */