/*    */ package dtv.data2.dataserver.config;
/*    */ 
/*    */ import dtv.data2.dataserver.IDataServerAction;
/*    */ import dtv.util.config.ConfigHelper;
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
/*    */ 
/*    */ 
/*    */ public class ConfigHelper
/*    */   extends ConfigHelper<EnvironmentConfig>
/*    */ {
/* 23 */   private static final Logger _logger = Logger.getLogger(ConfigHelper.class);
/* 24 */   private static final boolean _debugEnabled = _logger.isDebugEnabled();
/*    */   
/*    */   private static ConfigHelper _configHelper;
/*    */   
/*    */   public static synchronized ConfigHelper getInstance() {
/* 29 */     if (_configHelper == null) {
/* 30 */       ConfigHelper configHelper = new ConfigHelper();
/* 31 */       configHelper.initialize();
/* 32 */       _configHelper = configHelper;
/*    */     } 
/*    */     
/* 35 */     return _configHelper;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IDataServerAction> getActions(String argInstructionType) throws Exception {
/* 41 */     InstructionConfig instruction = ((EnvironmentConfig)getRootConfig()).getInstructionConfig(argInstructionType);
/* 42 */     List<IDataServerAction> actions = instruction.getActions();
/*    */     
/* 44 */     if (_debugEnabled) {
/* 45 */       _logger.debug("Requested instruction = [" + argInstructionType + "].  Returning actions: " + actions);
/*    */     }
/*    */     
/* 48 */     return actions;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public OptionsConfig getEnvironmentOptions() {
/* 59 */     return getEnvironmentOptions("XSTORE");
/*    */   }
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
/*    */   public OptionsConfig getEnvironmentOptions(String argOptionsType) {
/* 72 */     OptionsConfig config = ((EnvironmentConfig)getRootConfig()).getOptionsConfig(argOptionsType);
/* 73 */     return config;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 79 */     return "EnvironmentConfig";
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\ConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */