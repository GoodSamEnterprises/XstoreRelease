/*    */ package dtv.data2.access.impl.config;
/*    */ 
/*    */ import dtv.data2.access.pm.PmTypeDeterminationException;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ public class PmTypeMappingConfigHelper
/*    */   extends ConfigHelper<PmTypeMappingSetConfig>
/*    */ {
/*    */   private static final int ESTIMATED_DAO_COUNT = 250;
/*    */   private Map<String, PmTypeMappingConfig> idClassMap_;
/*    */   
/*    */   public String getPMType(String argObjectIdClass) {
/* 27 */     if (StringUtils.isEmpty(argObjectIdClass)) {
/* 28 */       throw new PmTypeDeterminationException("argObjectIdClass was null or empty.  A value is required.");
/*    */     }
/*    */     
/* 31 */     PmTypeMappingConfig dmConfig = this.idClassMap_.get(argObjectIdClass);
/*    */     
/* 33 */     if (dmConfig == null) {
/* 34 */       throw new PmTypeDeterminationException("Unable to load PmTypeMapping config for id: " + argObjectIdClass + " -- make sure PmTypeMappingConfig was initialized properlyand contains a mapping for this class name.");
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 39 */     return dmConfig.getPmType();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hashRootConfigs() {
/* 44 */     super.hashRootConfigs();
/*    */     
/* 46 */     this.idClassMap_ = new HashMap<>(250);
/*    */     
/* 48 */     Collection<PmTypeMappingConfig> dms = getRootChildren(PmTypeMappingSetConfig.class);
/* 49 */     if (dms != null) {
/* 50 */       for (PmTypeMappingConfig dm : dms) {
/* 51 */         this.idClassMap_.put(dm.getIdClass(), dm);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public Boolean isPMTypeLoadPropertiesEnabled(String argObjectIdClass) {
/* 57 */     if (StringUtils.isEmpty(argObjectIdClass)) {
/* 58 */       throw new PmTypeDeterminationException("argObjectIdClass was null or empty.  A value is required.");
/*    */     }
/*    */     
/* 61 */     PmTypeMappingConfig dmConfig = this.idClassMap_.get(argObjectIdClass);
/*    */     
/* 63 */     if (dmConfig == null) {
/* 64 */       throw new PmTypeDeterminationException("Unable to load PmTypeMapping config for id: " + argObjectIdClass + " -- make sure PmTypeMappingConfig was initialized properlyand contains a mapping for this class name.");
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 69 */     return dmConfig.isLoadPropertiesEnabled();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 78 */     return "PmTypeMappingConfig";
/*    */   }
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 83 */     if ("PmTypeMappingSet".equalsIgnoreCase(dtype)) {
/* 84 */       return (IConfigObject)new PmTypeMappingSetConfig();
/*    */     }
/* 86 */     if ("PmTypeMapping".equalsIgnoreCase(dtype)) {
/* 87 */       return (IConfigObject)new PmTypeMappingConfig();
/*    */     }
/* 89 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\config\PmTypeMappingConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */