/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ 
/*    */ public class StoreLocationHelper
/*    */   extends ConfigHelper<StoreLocationConfig>
/*    */ {
/*    */   private static StoreLocationHelper _configHelper;
/*    */   
/*    */   public static StoreLocationHelper getInstance() {
/* 26 */     if (_configHelper == null) {
/* 27 */       _configHelper = new StoreLocationHelper();
/* 28 */       _configHelper.initialize();
/*    */     } 
/*    */     
/* 31 */     return _configHelper;
/*    */   }
/*    */   
/* 34 */   private List<IRegion> _allRegions = new ArrayList<>();
/* 35 */   private Map<String, Boolean> AVSEnabledByCountryMap = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<IRegion> getRegions() {
/* 42 */     return this._allRegions;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 48 */     super.initializeImpl();
/*    */ 
/*    */     
/* 51 */     for (StoreRegionConfig config : ((StoreLocationConfig)getRootConfig()).getRegionConfigs()) {
/* 52 */       this._allRegions.add(config.getRegion());
/* 53 */       this.AVSEnabledByCountryMap.putAll(config.getAVSEnabledByCountryMap());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isAddressVerificationEnabledForCountry(String argCountryCode) {
/* 63 */     boolean isEnabled = false;
/* 64 */     if (this.AVSEnabledByCountryMap.containsKey(argCountryCode)) {
/* 65 */       isEnabled = ((Boolean)this.AVSEnabledByCountryMap.get(argCountryCode)).booleanValue();
/*    */     }
/* 67 */     return isEnabled;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 72 */     return "StoreLocationsAvailable";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StoreLocationHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */