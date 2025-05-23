/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.pm.PersistenceManagerType;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.xst.dao.com.ICodeValue;
/*     */ import dtv.xst.dao.inv.IInventoryBucket;
/*     */ import dtv.xst.dao.inv.IInventoryLocationBucket;
/*     */ import dtv.xst.dao.loc.IOrgHierarchy;
/*     */ import dtv.xst.dao.loc.IRetailLocation;
/*     */ import dtv.xst.dao.loc.IWorkstation;
/*     */ import dtv.xst.dao.loc.OrgHierarchyId;
/*     */ import dtv.xst.dao.tax.IRetailLocationTaxMapping;
/*     */ import dtv.xst.dao.tsn.ITenderRepository;
/*     */ import dtv.xst.dao.tsn.ITenderRepositoryFloat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class RetailLocationSynchronizer {
/*  36 */   private static final Logger _logger = Logger.getLogger(RetailLocationSynchronizer.class);
/*     */   
/*  38 */   private static final PersistenceManagerType XCENTER = PersistenceManagerType.forName("RESERVED_CENTRAL");
/*  39 */   private static final PersistenceManagerType STOREPRIMARY = PersistenceManagerType.forName("RESERVED_STORE");
/*     */   
/*  41 */   private static final IQueryKey<IRetailLocation> RETAIL_LOCATIONS = (IQueryKey<IRetailLocation>)new QueryKey("RETAIL_LOCATIONS", IRetailLocation.class);
/*     */   
/*  43 */   private static final IQueryKey<IRetailLocationTaxMapping> TAX_MAP = (IQueryKey<IRetailLocationTaxMapping>)new QueryKey("SYNC_TAX_MAPPING_BY_LOCATION", IRetailLocationTaxMapping.class);
/*     */   
/*  45 */   private static final IQueryKey<IOrgHierarchy> ORG_HIERARCHY = (IQueryKey<IOrgHierarchy>)new QueryKey("SYNC_ORG_HIERARCHY_BY_LOCATION", IOrgHierarchy.class);
/*     */ 
/*     */   
/*  48 */   private static final IQueryKey<IWorkstation> WORKSTATIONS = (IQueryKey<IWorkstation>)new QueryKey("ALL_WORKSTATIONS", IWorkstation.class);
/*     */   
/*  50 */   private static final IQueryKey<ITenderRepository> REPOSITORIES = (IQueryKey<ITenderRepository>)new QueryKey("SYNC_TENDER_REPOSITORIES", ITenderRepository.class);
/*     */   
/*  52 */   private static final IQueryKey<ITenderRepositoryFloat> REPOSITORY_FLOATS = (IQueryKey<ITenderRepositoryFloat>)new QueryKey("SYNC_TENDER_REPOSITORY_FLOATS", ITenderRepositoryFloat.class);
/*     */ 
/*     */   
/*  55 */   private static final IQueryKey<ICodeValue> CODE_VALUE_LOOKUP = (IQueryKey<ICodeValue>)new QueryKey("SYNC_CODE_VALUE_LOOKUP", ICodeValue.class);
/*     */   
/*  57 */   private static final IQueryKey<IInventoryBucket> INV_BUCKETS = (IQueryKey<IInventoryBucket>)new QueryKey("SYNC_INVENTORY_BUCKETS", IInventoryBucket.class);
/*     */   
/*  59 */   private static final IQueryKey<IInventoryLocationBucket> INV_LOCATION_BUCKETS = (IQueryKey<IInventoryLocationBucket>)new QueryKey("SYNC_INVENTORY_LOCATION_BUCKETS", IInventoryLocationBucket.class);
/*     */ 
/*     */   
/*     */   private static final String INV_BUCKET_CATEGORY = "INV_BUCKET";
/*     */ 
/*     */   
/*     */   private static final String INV_BUCKET_SYSTEM_CATEGORY = "INV_BUCKET_SYSTEM";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_LOCATION_ID = "DEFAULT";
/*     */ 
/*     */   
/*     */   private static final String DEFAULT_TRACKING_METHOD = "ALL";
/*     */   
/*     */   private static final String SYNC_CREATE_USER_ID = "SYNCHRONIZE";
/*     */   
/*     */   private static final String PRIMARY_ONLY_PROP = "dtv.register.startup.synchronize.primaryOnly";
/*     */ 
/*     */   
/*     */   public void synchronizeRetailLocationInfo(long argOrgId, long argRetailLocationId, int argWorkstationId) {
/*  79 */     Boolean primaryOnly = Boolean.valueOf(System.getProperty("dtv.register.startup.synchronize.primaryOnly", "true"));
/*     */ 
/*     */ 
/*     */     
/*  83 */     if (!StatusMgr.getInstance().isOnline("Xcenter") || (primaryOnly
/*  84 */       .booleanValue() && argWorkstationId != ConfigurationMgr.getPrimaryTerminalId())) {
/*     */       return;
/*     */     }
/*     */     
/*  88 */     if (_logger.isDebugEnabled()) {
/*  89 */       _logger.debug("Start Synchronization of Retail Location Information.");
/*     */     }
/*  91 */     List<IPersistable> persistBag = new ArrayList<>();
/*     */     
/*  93 */     Map<String, Object> params = new HashMap<>();
/*  94 */     params.put("argOrganizationId", Long.valueOf(argOrgId));
/*  95 */     params.put("argRetailLocationId", Long.valueOf(argRetailLocationId));
/*     */ 
/*     */     
/*  98 */     List<String> orgNodeList = getNodeStringAncestry(Long.valueOf(argOrgId), Long.valueOf(argRetailLocationId));
/*  99 */     if (orgNodeList != null && !orgNodeList.isEmpty()) {
/* 100 */       Map<String, Object> orgParams = new HashMap<>();
/* 101 */       orgParams.put("argOrganizationId", Long.valueOf(argOrgId));
/* 102 */       orgParams.put("@argNodeList", orgNodeList);
/* 103 */       synchronize((IQueryKey)ORG_HIERARCHY, orgParams, persistBag);
/*     */     } 
/*     */ 
/*     */     
/* 107 */     synchronize((IQueryKey)RETAIL_LOCATIONS, params, persistBag);
/*     */ 
/*     */     
/* 110 */     synchronize((IQueryKey)TAX_MAP, params, persistBag);
/*     */ 
/*     */     
/* 113 */     synchronize((IQueryKey)WORKSTATIONS, params, persistBag);
/*     */ 
/*     */     
/* 116 */     synchronize((IQueryKey)REPOSITORIES, params, persistBag);
/*     */ 
/*     */     
/* 119 */     synchronize((IQueryKey)REPOSITORY_FLOATS, params, persistBag);
/*     */ 
/*     */     
/* 122 */     Map<String, Object> codeParams = new HashMap<>();
/* 123 */     codeParams.put("argOrganizationId", Long.valueOf(argOrgId));
/* 124 */     codeParams.put("argCategory", "INV_BUCKET");
/* 125 */     IQueryResultList iQueryResultList1 = DataFactory.getObjectByQueryNoThrow(CODE_VALUE_LOOKUP, codeParams, (IPersistenceMgrType)XCENTER);
/* 126 */     codeParams.put("argCategory", "INV_BUCKET_SYSTEM");
/*     */     
/* 128 */     IQueryResultList iQueryResultList2 = DataFactory.getObjectByQueryNoThrow(CODE_VALUE_LOOKUP, codeParams, (IPersistenceMgrType)XCENTER);
/*     */ 
/*     */     
/* 131 */     synchronizeInventoryBuckets(argOrgId, argRetailLocationId, (List<ICodeValue>)iQueryResultList1, (List<ICodeValue>)iQueryResultList2, params, persistBag);
/*     */ 
/*     */     
/* 134 */     synchronizeInventoryLocationBuckets(argOrgId, argRetailLocationId, (List<ICodeValue>)iQueryResultList1, params, persistBag);
/*     */ 
/*     */     
/* 137 */     if (persistBag != null && !persistBag.isEmpty()) {
/* 138 */       for (IPersistable model : persistBag) {
/* 139 */         IDataAccessObject dao = ((IDataModelImpl)model).getDAO();
/* 140 */         dao.setObjectState(DaoState.INSERT_OR_UPDATE.intVal());
/*     */       } 
/* 142 */       _logger.warn("Retail location information is being synchronized.");
/* 143 */       DataFactory.makePersistent(persistBag);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean doesBucketExistInInvBuckets(ICodeValue argCode, List<IInventoryBucket> argList) {
/* 154 */     boolean exists = false;
/* 155 */     for (IInventoryBucket bucket : argList) {
/* 156 */       if (argCode.getOrganizationId() == bucket.getOrganizationId() && argCode
/* 157 */         .getCode().equalsIgnoreCase(bucket.getBucketId())) {
/* 158 */         exists = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 163 */     return exists;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean doesBucketExistInInvLocationBuckets(ICodeValue argCode, List<IInventoryLocationBucket> argList) {
/* 174 */     boolean exists = false;
/* 175 */     for (IInventoryLocationBucket bucket : argList) {
/* 176 */       if (argCode.getOrganizationId() == bucket.getOrganizationId() && argCode
/* 177 */         .getCode().equalsIgnoreCase(bucket.getBucketId()) && bucket
/* 178 */         .getLocationId().equalsIgnoreCase("DEFAULT")) {
/* 179 */         exists = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 184 */     return exists;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getNodeString(IOrgHierarchy argHierarchyNode) {
/* 193 */     if (argHierarchyNode == null) {
/* 194 */       return "";
/*     */     }
/*     */     
/* 197 */     return argHierarchyNode.getLevelCode() + ":" + argHierarchyNode.getLevelValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> getNodeStringAncestry(Long argOrgId, Long argRtlLocId) {
/* 207 */     List<String> ancestry = new ArrayList<>();
/* 208 */     String nodeString = "STORE:" + String.valueOf(argRtlLocId);
/*     */     
/* 210 */     OrgHierarchyId id = new OrgHierarchyId();
/* 211 */     id.setOrganizationId(argOrgId);
/* 212 */     id.setLevelCode("STORE");
/* 213 */     id.setLevelValue(String.valueOf(argRtlLocId));
/* 214 */     IOrgHierarchy node = (IOrgHierarchy)DataFactory.getObjectByIdNoThrow((IObjectId)id, (IPersistenceMgrType)XCENTER);
/*     */     
/* 216 */     if (node != null) {
/* 217 */       ancestry.add(nodeString);
/*     */       
/* 219 */       while (node.getParentElement() != null) {
/* 220 */         ancestry.add(getNodeString(node.getParentElement()));
/* 221 */         node = node.getParentElement();
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     return ancestry;
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
/*     */   private void synchronize(IQueryKey<? extends IDataModel> argQuery, Map<String, Object> argParams, List<IPersistable> argPersistable) {
/* 237 */     IQueryResultList iQueryResultList1 = DataFactory.getObjectByQueryNoThrow(argQuery, argParams, (IPersistenceMgrType)STOREPRIMARY);
/*     */     
/* 239 */     IQueryResultList iQueryResultList2 = DataFactory.getObjectByQueryNoThrow(argQuery, argParams, (IPersistenceMgrType)XCENTER);
/*     */     
/* 241 */     if (_logger.isDebugEnabled()) {
/* 242 */       _logger.debug(argQuery.getName() + " - " + String.valueOf(iQueryResultList2.size()) + " Xcenter Records Retrieved.");
/*     */       
/* 244 */       _logger.debug(argQuery.getName() + " - " + String.valueOf(iQueryResultList1.size()) + " Store Records Retrieved.");
/*     */     } 
/*     */ 
/*     */     
/* 248 */     Map<String, IDataModel> xcenterRecordMap = new HashMap<>();
/* 249 */     for (IDataModel xcenterRecord : iQueryResultList2) {
/* 250 */       xcenterRecordMap.put(xcenterRecord.getObjectIdAsString(), xcenterRecord);
/*     */     }
/*     */     
/* 253 */     for (IDataModel storeRecord : iQueryResultList1) {
/* 254 */       xcenterRecordMap.remove(storeRecord.getObjectIdAsString());
/*     */     }
/*     */     
/* 257 */     if (_logger.isDebugEnabled()) {
/* 258 */       _logger.debug(argQuery.getName() + " - " + String.valueOf(xcenterRecordMap.values().size()) + " Xcenter Records persisted to Store.");
/*     */     }
/*     */     
/* 261 */     if (!xcenterRecordMap.values().isEmpty()) {
/* 262 */       argPersistable.addAll((Collection)xcenterRecordMap.values());
/*     */     }
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
/*     */   private void synchronizeInventoryBuckets(long argOrgId, long argRetailLocationId, List<ICodeValue> argBuckets, List<ICodeValue> argSystemBuckets, Map<String, Object> argParams, List<IPersistable> argPersistBag) {
/* 279 */     IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(INV_BUCKETS, argParams, (IPersistenceMgrType)STOREPRIMARY);
/*     */     
/* 281 */     Date createDate = new Date();
/*     */     
/* 283 */     int bucketCt = 0;
/* 284 */     for (ICodeValue code : argBuckets) {
/* 285 */       if (!doesBucketExistInInvBuckets(code, (List<IInventoryBucket>)iQueryResultList)) {
/* 286 */         IInventoryBucket bucket = (IInventoryBucket)DataFactory.createObject(IInventoryBucket.class);
/* 287 */         bucket.setOrganizationId(argOrgId);
/* 288 */         bucket.setRetailLocationId(argRetailLocationId);
/* 289 */         bucket.setBucketId(code.getCode());
/* 290 */         bucket.setName(code.getDescription());
/* 291 */         bucket.setDefaultLocationId("DEFAULT");
/* 292 */         bucket.setCreateDate(createDate);
/* 293 */         bucket.setCreateUserId("SYNCHRONIZE");
/*     */         
/* 295 */         argPersistBag.add(bucket);
/* 296 */         bucketCt++;
/*     */       } 
/*     */     } 
/*     */     
/* 300 */     for (ICodeValue code : argSystemBuckets) {
/* 301 */       if (!doesBucketExistInInvBuckets(code, (List<IInventoryBucket>)iQueryResultList)) {
/* 302 */         IInventoryBucket bucket = (IInventoryBucket)DataFactory.createObject(IInventoryBucket.class);
/* 303 */         bucket.setOrganizationId(argOrgId);
/* 304 */         bucket.setRetailLocationId(argRetailLocationId);
/* 305 */         bucket.setBucketId(code.getCode());
/* 306 */         bucket.setName(code.getDescription());
/* 307 */         bucket.setDefaultLocationId("DEFAULT");
/* 308 */         bucket.setSystemBucket(true);
/* 309 */         bucket.setCreateDate(createDate);
/* 310 */         bucket.setCreateUserId("SYNCHRONIZE");
/*     */         
/* 312 */         argPersistBag.add(bucket);
/* 313 */         bucketCt++;
/*     */       } 
/*     */     } 
/* 316 */     if (_logger.isDebugEnabled()) {
/* 317 */       _logger.debug(INV_BUCKETS.getName() + " - " + String.valueOf(bucketCt) + " Records peristed to Store.");
/*     */     }
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
/*     */   private void synchronizeInventoryLocationBuckets(long argOrgId, long argRetailLocationId, List<ICodeValue> argBuckets, Map<String, Object> argParams, List<IPersistable> argPersistBag) {
/* 332 */     IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(INV_LOCATION_BUCKETS, argParams, (IPersistenceMgrType)STOREPRIMARY);
/*     */     
/* 334 */     Date createDate = new Date();
/*     */     
/* 336 */     int bucketCt = 0;
/* 337 */     for (ICodeValue code : argBuckets) {
/* 338 */       if (!doesBucketExistInInvLocationBuckets(code, (List<IInventoryLocationBucket>)iQueryResultList)) {
/* 339 */         IInventoryLocationBucket locBucket = (IInventoryLocationBucket)DataFactory.createObject(IInventoryLocationBucket.class);
/* 340 */         locBucket.setOrganizationId(argOrgId);
/* 341 */         locBucket.setRetailLocationId(argRetailLocationId);
/* 342 */         locBucket.setLocationId("DEFAULT");
/* 343 */         locBucket.setBucketId(code.getCode());
/* 344 */         locBucket.setTrackingMethod("ALL");
/* 345 */         locBucket.setCreateDate(createDate);
/* 346 */         locBucket.setCreateUserId("SYNCHRONIZE");
/*     */         
/* 348 */         argPersistBag.add(locBucket);
/* 349 */         bucketCt++;
/*     */       } 
/*     */     } 
/* 352 */     if (_logger.isDebugEnabled())
/* 353 */       _logger.debug(INV_LOCATION_BUCKETS.getName() + " - " + String.valueOf(bucketCt) + " Records Added to Store."); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\RetailLocationSynchronizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */