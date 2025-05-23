/*    */ package dtv.data2.access.config.common;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public class PropertyConfigConverter
/*    */ {
/*    */   public static Properties convert(List<PropertyConfig> argConfigs) {
/* 17 */     return convert(argConfigs, new Properties());
/*    */   }
/*    */   
/*    */   public static Properties convert(List<PropertyConfig> argConfigs, Properties argTarget) {
/* 21 */     if (argConfigs == null || argConfigs.isEmpty()) {
/* 22 */       return argTarget;
/*    */     }
/*    */     
/* 25 */     PropertyConfig[] configs = new PropertyConfig[argConfigs.size()];
/* 26 */     configs = argConfigs.<PropertyConfig>toArray(configs);
/* 27 */     return convert(configs, argTarget);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Properties convert(PropertyConfig[] argConfigs) {
/* 32 */     return convert(argConfigs, new Properties());
/*    */   }
/*    */   
/*    */   public static Properties convert(PropertyConfig[] argConfigs, Properties argTarget) {
/* 36 */     if (argConfigs == null || argConfigs.length < 1) {
/* 37 */       return argTarget;
/*    */     }
/*    */     
/* 40 */     for (PropertyConfig argConfig : argConfigs) {
/* 41 */       if (argConfig.getKey() != null && argConfig.getValue() != null) {
/* 42 */         argTarget.setProperty(argConfig.getKey(), argConfig.getValue());
/*    */       }
/*    */     } 
/*    */     
/* 46 */     return argTarget;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\config\common\PropertyConfigConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */