/*    */ package dtv.pos.framework.location;
/*    */ 
/*    */ import dtv.i18n.FormattableFactory;
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.util.address.CountryCache;
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
/*    */ public class StoreRegionConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String ID_TAG = "id";
/*    */   private static final String NAME_TAG = "name";
/*    */   private static final String COUNTRY_TAG = "Country";
/* 28 */   private final List<StoreCountryConfig> countryList_ = new ArrayList<>();
/*    */ 
/*    */   
/*    */   private String _id;
/*    */   
/*    */   private IFormattable _name;
/*    */ 
/*    */   
/*    */   public Map<String, Boolean> getAVSEnabledByCountryMap() {
/* 37 */     Map<String, Boolean> AVSEnabledByCountryMap = new HashMap<>();
/* 38 */     this.countryList_.forEach(cList -> (Boolean)AVSEnabledByCountryMap.put(cList.getCode(), Boolean.valueOf(cList.getAvsEnabled())));
/* 39 */     return AVSEnabledByCountryMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getId() {
/* 47 */     return this._id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IRegion getRegion() {
/* 55 */     GeographicRegion region = new GeographicRegion();
/* 56 */     region.setId(this._id);
/* 57 */     region.setName(this._name);
/*    */     
/* 59 */     CountryCache cache = new CountryCache();
/*    */     
/* 61 */     for (StoreCountryConfig countryConfig : this.countryList_)
/*    */     {
/* 63 */       cache.addCountry(countryConfig.getCode(), countryConfig.getName(), 0);
/*    */     }
/*    */     
/* 66 */     region.setCountries(cache.getCountryArray());
/*    */     
/* 68 */     return region;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 73 */     if ("Country".equalsIgnoreCase(argKey) && argValue instanceof StoreCountryConfig) {
/* 74 */       this.countryList_.add((StoreCountryConfig)argValue);
/*    */     }
/* 76 */     else if ("id".equalsIgnoreCase(argKey)) {
/* 77 */       this._id = argValue.toString();
/*    */     }
/* 79 */     else if ("name".equalsIgnoreCase(argKey)) {
/* 80 */       this._name = FormattableFactory.getInstance().getSimpleFormattable(argValue.toString());
/*    */     } else {
/*    */       
/* 83 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\StoreRegionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */