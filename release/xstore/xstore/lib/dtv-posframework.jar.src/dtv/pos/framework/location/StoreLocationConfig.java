/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
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
/*    */ public class StoreLocationConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "LocationList";
/*    */   public static final String REGION_TAG = "Region";
/* 24 */   private final Map<String, StoreRegionConfig> _regionConfigMap = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StoreRegionConfig getRegionConfig(String argRegionId) {
/* 32 */     return this._regionConfigMap.get(argRegionId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<StoreRegionConfig> getRegionConfigs() {
/* 40 */     return this._regionConfigMap.values();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 45 */     if (argValue instanceof StoreRegionConfig) {
/* 46 */       StoreRegionConfig config = (StoreRegionConfig)argValue;
/* 47 */       this._regionConfigMap.put(config.getId(), config);
/*    */     } else {
/*    */       
/* 50 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StoreLocationConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */