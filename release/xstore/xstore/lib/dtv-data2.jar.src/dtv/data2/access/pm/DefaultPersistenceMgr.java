/*     */ package dtv.data2.access.pm;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.cache.CacheManager;
/*     */ import dtv.data2.cache.ICache;
/*     */ import dtv.data2.cache.config.CacheConfigHelper;
/*     */ import dtv.util.ResourceUtils;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultPersistenceMgr
/*     */   extends PersistenceManager
/*     */ {
/*  32 */   private static final Logger logger_ = Logger.getLogger(DefaultPersistenceMgr.class);
/*  33 */   private static final boolean DEBUG = logger_.isDebugEnabled();
/*  34 */   private static final ICache _cache = CacheManager.getInstance().getCache("dtx-cache");
/*  35 */   private static final ICache _transCache = CacheManager.getInstance().getCache("dtx-cache-trans");
/*     */   
/*  37 */   private static final boolean _writeThroughEnabled = CacheConfigHelper.getCacheConfig().getWriteThroughEnabled();
/*  38 */   private static final Properties _opClassMap = ResourceUtils.getProperties("QueryKeyMap");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getObjectById(IObjectId argId, IPersistenceMgrType argType) {
/*  44 */     IDataModel result = checkCacheForDataModelObject(argId, true);
/*     */     
/*  46 */     if (result == null) {
/*  47 */       PmOperationInfo operationInfo = new PmOperationInfo();
/*     */ 
/*     */       
/*     */       try {
/*  51 */         result = super.getObjectById(argId, argType);
/*  52 */         cache(argId, result, false);
/*     */       }
/*  54 */       catch (ObjectNotFoundException ee) {
/*     */ 
/*     */         
/*  57 */         cache(argId, result, !operationInfo.isOfflineDatasourceFound());
/*  58 */         throw ee;
/*     */       } 
/*     */     } 
/*  61 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObjectByQuery(String argQueryKey, Map<String, Object> argParams, IPersistenceMgrType argPmType) {
/*  70 */     String queryKey, override = (String)_opClassMap.get(argQueryKey);
/*  71 */     if (override != null) {
/*  72 */       queryKey = override;
/*     */     } else {
/*     */       
/*  75 */       queryKey = argQueryKey;
/*     */     } 
/*  77 */     QueryRequest request = new QueryRequest(queryKey, argParams, argPmType);
/*     */ 
/*     */     
/*  80 */     Object result = checkCaches(request, true);
/*     */     
/*  82 */     if (result == null) {
/*  83 */       PmOperationInfo operationInfo = new PmOperationInfo();
/*     */ 
/*     */       
/*     */       try {
/*  87 */         result = getObjectByQuery(request, operationInfo);
/*  88 */         cache(request, result, false);
/*     */       }
/*  90 */       catch (ObjectNotFoundException ee) {
/*     */ 
/*     */         
/*  93 */         cache(request, result, !operationInfo.isOfflineDatasourceFound());
/*  94 */         throw ee;
/*     */       } 
/*     */     } 
/*  97 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T makePersistent(T argObject, long argTimeout) {
/* 103 */     T persistenceReturnValue = super.makePersistent(argObject, argTimeout);
/*     */ 
/*     */     
/* 106 */     updateCache(argObject);
/*     */ 
/*     */     
/* 109 */     return persistenceReturnValue;
/*     */   }
/*     */   
/*     */   protected void cache(Object argKey, Object argValue, boolean canCacheNull) {
/* 113 */     _transCache.put(argKey, argValue);
/*     */     
/* 115 */     if (argValue != null || canCacheNull == true) {
/* 116 */       _cache.put(argKey, argValue);
/*     */     
/*     */     }
/* 119 */     else if (DEBUG) {
/* 120 */       logger_.debug("Key with null value not cached [" + argKey + "]");
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
/*     */   protected Object checkCache(ICache argCache, Object argCacheKey, boolean argThrowObjectNotFoundException) {
/* 134 */     Object result = argCache.getSafely(argCacheKey);
/*     */     
/* 136 */     if (result != null && !(result instanceof dtv.data2.cache.NullValue)) {
/* 137 */       if (DEBUG) {
/* 138 */         logger_.debug("Result found in cache for key [" + argCacheKey + "]; Object: " + result);
/*     */       }
/* 140 */       return result;
/*     */     } 
/* 142 */     if (result != null && result instanceof dtv.data2.cache.NullValue && argThrowObjectNotFoundException) {
/* 143 */       throw new ObjectNotFoundException("Cache contained a null value for key [" + argCacheKey + "]");
/*     */     }
/*     */     
/* 146 */     if (DEBUG) {
/* 147 */       logger_.debug("Result NOT found in cache for key [" + argCacheKey + "]");
/*     */     }
/* 149 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDataModel checkCacheForDataModelObject(Object argCacheKey, boolean argThrowObjectNotFoundException) {
/* 155 */     Object cacheResult = checkCaches(argCacheKey, argThrowObjectNotFoundException);
/* 156 */     if (cacheResult instanceof IDataModel) {
/* 157 */       return (IDataModel)cacheResult;
/*     */     }
/* 159 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object checkCaches(Object argCacheKey, boolean argThrowObjectNotFoundException) {
/* 164 */     Object result = checkCache(_transCache, argCacheKey, argThrowObjectNotFoundException);
/*     */     
/* 166 */     if (result == null) {
/* 167 */       result = checkCache(_cache, argCacheKey, argThrowObjectNotFoundException);
/*     */     }
/*     */     
/* 170 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadRelationship(IDataModelRelationship argRel, IDataModelImpl argModel, IPersistenceStrategy argPreferredDataSource, QueryToken argQueryToken, boolean isTransientRelationship, PmOperationInfo argoperationInfo) {
/* 180 */     IObjectId childObjectId = null;
/*     */     
/* 182 */     if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.equals(argRel.getType())) {
/* 183 */       argRel.setParent((IDataModel)argModel);
/* 184 */       childObjectId = argPreferredDataSource.getChildObjectIdForRelationship(argRel);
/*     */ 
/*     */       
/* 187 */       if (childObjectId != null && childObjectId.validate()) {
/* 188 */         IDataModel peerModel = checkCacheForDataModelObject(childObjectId, false);
/*     */         
/* 190 */         if (peerModel != null) {
/* 191 */           argModel.setValue(argRel.getIdentifier(), peerModel);
/* 192 */           if (isTransientRelationship) {
/* 193 */             setTransientFlag(peerModel);
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */       } else {
/* 199 */         childObjectId = null;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 204 */     PmOperationInfo operationInfo = new PmOperationInfo();
/*     */     
/* 206 */     super.loadRelationship(argRel, argModel, argPreferredDataSource, argQueryToken, isTransientRelationship, operationInfo);
/*     */ 
/*     */ 
/*     */     
/* 210 */     if (childObjectId != null) {
/* 211 */       cache(childObjectId, argModel.getValue(argRel.getIdentifier()), 
/* 212 */           !operationInfo.isOfflineDatasourceFound());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDataModel loadRelationships(IDataModel argDataModel, IPersistenceStrategy argPreferredDataSource, QueryToken argQueryToken, boolean ancestorHasTransientRelationship) {
/* 223 */     IDataModel result = checkCacheForDataModelObject(argDataModel.getObjectId(), false);
/*     */     
/* 225 */     if (result == null) {
/*     */       
/* 227 */       result = super.loadRelationships(argDataModel, argPreferredDataSource, argQueryToken, ancestorHasTransientRelationship);
/*     */ 
/*     */ 
/*     */       
/* 231 */       cache(argDataModel.getObjectId(), result, false);
/*     */     }
/* 233 */     else if (ancestorHasTransientRelationship) {
/* 234 */       setTransientFlag(result);
/*     */     } 
/*     */     
/* 237 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeFromCache(Object argKey) {
/* 246 */     _transCache.remove(argKey);
/* 247 */     _cache.remove(argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTransientFlag(IDataModel model) {
/* 256 */     if (model instanceof IDataModelImpl) {
/* 257 */       if (((IDataModelImpl)model).getDAO().isTransientObject()) {
/*     */         return;
/*     */       }
/*     */       
/* 261 */       for (DaoUtils.PersistableLink modelData : DaoUtils.getAllPersistables(model)) {
/* 262 */         if (modelData.getPersistable() instanceof IDataModelImpl) {
/* 263 */           ((IDataModelImpl)modelData.getPersistable()).getDAO().setTransientObject(true);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected <T> void updateCache(T argObject) {
/* 270 */     if (argObject instanceof IDataModel) {
/* 271 */       IObjectId modelId = ((IDataModel)argObject).getObjectId();
/* 272 */       if (modelId != null)
/* 273 */         if (_writeThroughEnabled) {
/* 274 */           cache(modelId, argObject, false);
/*     */         } else {
/*     */           
/* 277 */           removeFromCache(modelId);
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\DefaultPersistenceMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */