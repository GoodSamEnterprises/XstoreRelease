/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.cache.CacheManager;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.pos.iframework.ILocationFactory;
/*     */ import dtv.xst.dao.loc.IOrgHierarchy;
/*     */ import dtv.xst.dao.loc.IPricingHierarchy;
/*     */ import dtv.xst.dao.loc.IRetailLocation;
/*     */ import dtv.xst.dao.loc.IWorkstation;
/*     */ import dtv.xst.dao.loc.OrgHierarchyId;
/*     */ import dtv.xst.dao.loc.PricingHierarchyId;
/*     */ import dtv.xst.dao.loc.RetailLocationId;
/*     */ import dtv.xst.daocommon.IHierarchyElement;
/*     */ import dtv.xst.daocommon.IHierarchyItem;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class LocationFactory
/*     */   implements ILocationFactory {
/*  32 */   private static final Logger _logger = Logger.getLogger(LocationFactory.class);
/*     */   
/*     */   private static final ILocationFactory _impl;
/*     */   
/*  36 */   private static final IQueryKey<IRetailLocation> RETAIL_LOCATIONS = (IQueryKey<IRetailLocation>)new QueryKey("RETAIL_LOCATIONS", IRetailLocation.class);
/*     */ 
/*     */   
/*  39 */   private static final IQueryKey<IWorkstation> ALL_WORKSTATIONS = (IQueryKey<IWorkstation>)new QueryKey("ALL_WORKSTATIONS", IWorkstation.class);
/*     */ 
/*     */   
/*  42 */   private static final ICache _retailLocationCache = CacheManager.getInstance().getCache("RETAIL_LOCATION_CACHE");
/*     */ 
/*     */   
/*  45 */   private static final ICache _locationHierarchyCache = CacheManager.getInstance().getCache("LOCATION_HIERARCHY_CACHE");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  51 */     String className = System.getProperty(ILocationFactory.class.getName());
/*     */     try {
/*  53 */       temp = (ILocationFactory)Class.forName(className).newInstance();
/*     */     }
/*  55 */     catch (Exception ex) {
/*  56 */       temp = new LocationFactory();
/*     */     } 
/*  58 */     _impl = temp;
/*     */   }
/*     */   
/*     */   static {
/*     */     ILocationFactory temp;
/*     */   }
/*     */   
/*     */   public static ILocationFactory getInstance() {
/*  66 */     return _impl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<? extends IHierarchyElement> getOrganizationHierarchy(long argRetailLocationId) {
/*  76 */     return _impl.getOrganizationHierarchy((IHierarchyItem)_impl.getOrganizationHierarchyNode(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<? extends IWorkstation> getWorkstations(long argRetailLocationId) {
/*  84 */     return _impl.getWorkstations(_impl.getStoreById(argRetailLocationId));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IRetailLocation> getAllLocations() {
/*     */     try {
/* 105 */       return (List<? extends IRetailLocation>)DataFactory.getObjectByQuery(RETAIL_LOCATIONS, new HashMap<>());
/*     */     }
/* 107 */     catch (Exception ex) {
/* 108 */       _logger.error("CAUGHT EXCEPTION", ex);
/* 109 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IHierarchyElement> getOrganizationHierarchy(IHierarchyItem argHierarchyItem) {
/* 116 */     List<IHierarchyElement> result = new ArrayList<>();
/*     */     
/* 118 */     IHierarchyElement current = getOrganizationHierarchyNode(argHierarchyItem);
/*     */     
/* 120 */     if (current != null) {
/* 121 */       while (current != null) {
/* 122 */         result.add(current);
/* 123 */         current = current.getParentElement();
/*     */       } 
/*     */     }
/* 126 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IHierarchyElement getOrganizationHierarchyNode(long argRetailLocationId) {
/* 132 */     return getOrganizationHierarchy(getDefaultHierarchyNode(argRetailLocationId)).get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IHierarchyElement> getPricingHierarchy(IHierarchyItem argHierarchyItem) {
/* 138 */     List<IHierarchyElement> result = new ArrayList<>();
/*     */     
/* 140 */     IHierarchyElement current = getPricingHierarchyNode(argHierarchyItem);
/*     */     
/* 142 */     if (current != null) {
/* 143 */       while (current != null) {
/* 144 */         result.add(current);
/* 145 */         current = current.getParentElement();
/*     */       } 
/*     */     }
/* 148 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IHierarchyElement getPricingHierarchyNode(long argRetailLocationId) {
/* 154 */     return getPricingHierarchy(getDefaultHierarchyNode(argRetailLocationId)).get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IRetailLocation getStoreById(long argStoreNumber) {
/* 160 */     RetailLocationId id = new RetailLocationId();
/* 161 */     id.setRetailLocationId(Long.valueOf(argStoreNumber));
/*     */     
/* 163 */     return getStoreById(id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IRetailLocation getStoreById(RetailLocationId argLocId) {
/* 169 */     Object cacheResponse = _retailLocationCache.getSafely(argLocId);
/*     */ 
/*     */     
/* 172 */     if (cacheResponse instanceof IRetailLocation) {
/* 173 */       return (IRetailLocation)cacheResponse;
/*     */     }
/*     */ 
/*     */     
/* 177 */     IRetailLocation retailLoc = null;
/*     */     try {
/* 179 */       retailLoc = (IRetailLocation)DataFactory.getObjectById((IObjectId)argLocId);
/* 180 */       _retailLocationCache.put(argLocId, retailLoc);
/*     */     }
/* 182 */     catch (ObjectNotFoundException ex) {
/* 183 */       _logger.info("CAUGHT EXCEPTION", (Throwable)ex);
/*     */     } 
/*     */ 
/*     */     
/* 187 */     return retailLoc;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends IWorkstation> getWorkstations(IRetailLocation argLocation) {
/*     */     try {
/* 194 */       Map<String, Object> params = new HashMap<>();
/* 195 */       params.put("argRetailLocationId", Long.valueOf(argLocation.getRetailLocationId()));
/*     */       
/* 197 */       return (List<? extends IWorkstation>)DataFactory.getObjectByQuery(ALL_WORKSTATIONS, params);
/*     */     }
/* 199 */     catch (Exception ex) {
/* 200 */       _logger.error("CAUGHT EXCEPTION", ex);
/* 201 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IHierarchyItem getDefaultHierarchyNode(long argRetailLocationId) {
/* 214 */     return HierarchyItem.makeStoreNode(Long.valueOf(argRetailLocationId).intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IHierarchyElement getOrganizationHierarchyNode(IHierarchyItem argHierarchyItem) {
/* 224 */     OrgHierarchyId id = new OrgHierarchyId();
/* 225 */     id.setLevelCode(argHierarchyItem.getLevelCode());
/* 226 */     id.setLevelValue(argHierarchyItem.getLevelValue());
/* 227 */     id.setOrganizationId(Long.valueOf(argHierarchyItem.getOrganizationId()));
/*     */ 
/*     */     
/* 230 */     Object cacheResponse = _locationHierarchyCache.getSafely(id);
/*     */ 
/*     */     
/* 233 */     if (cacheResponse instanceof IHierarchyElement) {
/* 234 */       return (IHierarchyElement)cacheResponse;
/*     */     }
/*     */ 
/*     */     
/* 238 */     IOrgHierarchy orgHier = null;
/*     */     try {
/* 240 */       orgHier = (IOrgHierarchy)DataFactory.getObjectById((IObjectId)id);
/* 241 */       _locationHierarchyCache.put(id, orgHier);
/*     */     }
/* 243 */     catch (ObjectNotFoundException ex) {
/* 244 */       _logger.info("CAUGHT EXCEPTION", (Throwable)ex);
/*     */     } 
/*     */ 
/*     */     
/* 248 */     return (IHierarchyElement)orgHier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IHierarchyElement getPricingHierarchyNode(IHierarchyItem argHierarchyItem) {
/* 258 */     PricingHierarchyId id = new PricingHierarchyId();
/* 259 */     id.setLevelCode(argHierarchyItem.getLevelCode());
/* 260 */     id.setLevelValue(argHierarchyItem.getLevelValue());
/* 261 */     id.setOrganizationId(Long.valueOf(argHierarchyItem.getOrganizationId()));
/* 262 */     IPricingHierarchy result = null;
/*     */     
/*     */     try {
/* 265 */       result = (IPricingHierarchy)DataFactory.getObjectById((IObjectId)id);
/*     */     }
/* 267 */     catch (ObjectNotFoundException ex) {
/* 268 */       _logger.warn("Pricing hierarchy not found for level code [" + id.getLevelCode() + "] and level value [" + id
/* 269 */           .getLevelValue() + "]");
/*     */     } 
/* 271 */     return (IHierarchyElement)result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ArtificialNode
/*     */     implements IHierarchyElement
/*     */   {
/*     */     private final String _levelCode;
/*     */ 
/*     */     
/*     */     private final String _levelValue;
/*     */ 
/*     */     
/*     */     private final int _depth;
/*     */ 
/*     */ 
/*     */     
/*     */     ArtificialNode(String argLevelCode, String argLevelValue, int argDepth) {
/* 291 */       this._levelCode = argLevelCode;
/* 292 */       this._levelValue = argLevelValue;
/* 293 */       this._depth = argDepth;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean equals(Object argObj) {
/* 301 */       if (argObj == this) {
/* 302 */         return true;
/*     */       }
/* 304 */       if (!(argObj instanceof IHierarchyElement)) {
/* 305 */         return false;
/*     */       }
/* 307 */       IHierarchyElement other = (IHierarchyElement)argObj;
/* 308 */       return (new EqualsBuilder())
/* 309 */         .append(this._levelCode, other.getLevelCode())
/* 310 */         .append(this._levelValue, other.getLevelValue())
/* 311 */         .append(getOrganizationId(), other.getOrganizationId()).isEquals();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getDepth() {
/* 317 */       return this._depth;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String getLevelCode() {
/* 323 */       return this._levelCode;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String getLevelValue() {
/* 329 */       return this._levelValue;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final long getOrganizationId() {
/* 335 */       return ConfigurationMgr.getOrganizationId();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final IHierarchyElement getParentElement() {
/* 342 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 348 */       return (new HashCodeBuilder()).append(this._levelCode).append(this._levelValue).append(getOrganizationId())
/* 349 */         .toHashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 355 */       return (new ToStringBuilder(this)).append("level", this._levelCode).append("value", this._levelValue).toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\LocationFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */