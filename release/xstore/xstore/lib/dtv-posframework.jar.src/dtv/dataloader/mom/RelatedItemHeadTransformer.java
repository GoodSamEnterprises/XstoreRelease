/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.IAttachedItems;
/*     */ import dtv.xst.dao.itm.ISubstituteItems;
/*     */ import dtv.xst.dao.itm.impl.AttachedItemsDAO;
/*     */ import dtv.xst.dao.itm.impl.SubstituteItemsDAO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.EnumUtils;
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
/*     */ 
/*     */ 
/*     */ public class RelatedItemHeadTransformer
/*     */   extends AbstractRelatedItemTransformer
/*     */ {
/*  38 */   private static final Logger _logger = Logger.getLogger(RelatedItemHeadTransformer.class);
/*     */   
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   
/*     */   private static final int FIELD_INDEX_TYPE = 1;
/*     */   
/*     */   private static final int FIELD_INDEX_RELATIONSHIP_ID = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_ITEM = 3;
/*     */   private static final int FIELD_INDEX_LOCATION = 4;
/*     */   private static final int FIELD_INDEX_RELATIONSHIP_NAME = 5;
/*     */   private static final int FIELD_INDEX_RELATIONSHIP_TYPE = 6;
/*     */   private static final int FIELD_INDEX_MANDATORY_IND = 7;
/*  51 */   private static final IQueryKey<IAttachedItems> GET_ATTACHED_ITEMS = (IQueryKey<IAttachedItems>)new QueryKey("GET_ATTACHED_ITEMS_BY_EXTERNAL_ID", IAttachedItems.class);
/*     */ 
/*     */ 
/*     */   
/*  55 */   private static final IQueryKey<ISubstituteItems> GET_SUBSTITUTE_ITEMS = (IQueryKey<ISubstituteItems>)new QueryKey("GET_SUBSTITUTE_ITEMS_BY_EXTERNAL_ID", ISubstituteItems.class);
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
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  67 */     List<IPersistable> persistables = new ArrayList<>(2);
/*     */ 
/*     */     
/*  70 */     Map<String, Object> params = new HashMap<>(2);
/*  71 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  72 */     params.put("argLocation", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/*  73 */     persistables.add(new QueryRequest("DELETE_ALL_RELATED_ITEM_HEAD", params));
/*     */ 
/*     */     
/*  76 */     params = new HashMap<>(4);
/*  77 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  78 */     params.put("argLevelCode", "STORE");
/*  79 */     params.put("argLevelValue", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/*  80 */     params.put("argExternalSystem", "RMS");
/*  81 */     persistables.add(new QueryRequest("CLEAR_ALL_RELATED_ITEM_FLAGS", params));
/*     */     
/*  83 */     return persistables;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*     */     QueryRequest query;
/*     */     AbstractRelatedItemTransformer.RelationshipType relType;
/*     */     AbstractRelatedItemTransformer.RelatedItemHead head;
/*     */     Map<String, Object> parms;
/*  92 */     if (_logger.isDebugEnabled()) {
/*  93 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/*  96 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/*  98 */     MOMFileLine line = argUnit.getData().get(0);
/*     */     
/* 100 */     validate(argMetaData, line);
/*     */ 
/*     */     
/* 103 */     switch (line.getFields()[1]) {
/*     */       
/*     */       case "FULLRELITEMHDR":
/* 106 */         if (!argMetaData.getIsFullReload()) {
/* 107 */           throw new DataFileException(buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case "RELITEMHEADCRE":
/* 114 */         query = new QueryRequest("INSERT_RELATED_ITEM_HEAD", getQueryParameters(line, true));
/* 115 */         persistables.add(query);
/*     */ 
/*     */         
/* 118 */         relType = AbstractRelatedItemTransformer.RelationshipType.valueOf(line.getFields()[6]);
/* 119 */         if (relType.isSubstituteItems()) {
/* 120 */           persistables.add(getUpdateSubstituteItemFlagQueryRequest(line.getFields()[3], line
/* 121 */                 .getFields()[4], true));
/*     */         } else {
/*     */           
/* 124 */           persistables.add(getUpdateAttachedItemFlagQueryRequest(line.getFields()[3], line
/* 125 */                 .getFields()[4], true));
/*     */         } 
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
/*     */ 
/*     */         
/* 197 */         return persistables;case "RELITEMHEADMOD": head = lookupRelatedItemHead(line.getFields()[2], line.getFields()[4], line); if (head != null) { AbstractRelatedItemTransformer.RelationshipType modRelationshipType = AbstractRelatedItemTransformer.RelationshipType.valueOf(line.getFields()[6]); if (head.getRelationshipType().isAttachedItems() && modRelationshipType.isSubstituteItems()) { persistables.addAll(createSubstituteItemsFromAttachedItems(head.getItem(), head.getRelationshipId())); } else if (head.getRelationshipType().isSubstituteItems() && modRelationshipType.isAttachedItems()) { persistables.addAll(createAttachedItemsFromSubstituteItems(head.getItem(), head.getRelationshipId())); }  persistables.add(new QueryRequest("UPDATE_RELATED_ITEM_HEAD", getQueryParameters(line, false))); } else { query = new QueryRequest("INSERT_RELATED_ITEM_HEAD", getQueryParameters(line, true)); persistables.add(query); }  persistables.add(getUpdateRelatedItemFlagsQueryRequest(((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId(), line)); return persistables;case "RELITEMHEADDEL": parms = new HashMap<>(3); parms.put("argRelationshipId", line.getFields()[2]); parms.put("argLocation", line.getFields()[4]); parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId")))); query = new QueryRequest("DELETE_RELATED_ITEM_HEAD", parms); persistables.add(query); persistables.add(getUpdateRelatedItemFlagsQueryRequest(((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId(), line)); return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Collection<? extends IPersistable> createAttachedItemsFromSubstituteItems(String argItemId, String argRelationshipId) {
/* 209 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */ 
/*     */     
/* 212 */     List<ISubstituteItems> substituteItems = loadSubstituteItems(argRelationshipId);
/* 213 */     for (ISubstituteItems substituteItem : substituteItems) {
/*     */ 
/*     */       
/* 216 */       AttachedItemsDAO aiDao = (AttachedItemsDAO)getNewDAO("AttachedItems", DaoState.INSERT_ONLY);
/*     */ 
/*     */ 
/*     */       
/* 220 */       aiDao.setPromptToAdd(Boolean.valueOf(true));
/* 221 */       aiDao.setPromptToAddMsgKey(getPromptToAddMessageKey());
/*     */       
/* 223 */       aiDao.setLevelCode(substituteItem.getLevelCode());
/* 224 */       aiDao.setLevelValue(substituteItem.getLevelValue());
/* 225 */       aiDao.setSoldItemId(argItemId);
/* 226 */       aiDao.setAttachedItemId(substituteItem.getSubstituteItemId());
/* 227 */       aiDao.setBeginDatetime(substituteItem.getBeginDatetime());
/* 228 */       aiDao.setEndDatetime(substituteItem.getEndDatetime());
/* 229 */       aiDao.setExternalSystem(substituteItem.getExternalSystem());
/* 230 */       aiDao.setExternalId(substituteItem.getExternalId());
/* 231 */       persistables.add(aiDao);
/*     */ 
/*     */       
/* 234 */       SubstituteItemsDAO siDao = (SubstituteItemsDAO)getNewDAO("SubstituteItems", DaoState.DELETED);
/* 235 */       siDao.setObjectId(substituteItem.getObjectId());
/* 236 */       persistables.add(siDao);
/*     */     } 
/* 238 */     return persistables;
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
/*     */   private Collection<? extends IPersistable> createSubstituteItemsFromAttachedItems(String argItemId, String argRelationshipId) {
/* 251 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */ 
/*     */     
/* 254 */     List<IAttachedItems> attachedItems = loadAttachedItems(argRelationshipId);
/* 255 */     for (IAttachedItems attachedItem : attachedItems) {
/*     */ 
/*     */       
/* 258 */       SubstituteItemsDAO siDao = (SubstituteItemsDAO)getNewDAO("SubstituteItems", DaoState.INSERT_ONLY);
/* 259 */       siDao.setLevelCode(attachedItem.getLevelCode());
/* 260 */       siDao.setLevelValue(attachedItem.getLevelValue());
/* 261 */       siDao.setPrimaryItemId(argItemId);
/* 262 */       siDao.setSubstituteItemId(attachedItem.getAttachedItemId());
/* 263 */       siDao.setBeginDatetime(attachedItem.getBeginDatetime());
/* 264 */       siDao.setEndDatetime(attachedItem.getEndDatetime());
/* 265 */       siDao.setExternalSystem(attachedItem.getExternalSystem());
/* 266 */       siDao.setExternalId(attachedItem.getExternalId());
/* 267 */       persistables.add(siDao);
/*     */ 
/*     */       
/* 270 */       AttachedItemsDAO aiDao = (AttachedItemsDAO)getNewDAO("AttachedItems", DaoState.DELETED);
/* 271 */       aiDao.setObjectId(attachedItem.getObjectId());
/* 272 */       persistables.add(aiDao);
/*     */     } 
/* 274 */     return persistables;
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
/*     */   private Map<String, Object> getQueryParameters(MOMFileLine argLine, boolean argInsert) {
/* 287 */     Map<String, Object> params = new HashMap<>(8);
/* 288 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 289 */     params.put("argRelationshipId", argLine.getFields()[2]);
/* 290 */     params.put("argItem", argLine.getFields()[3]);
/* 291 */     params.put("argLocation", argLine.getFields()[4]);
/* 292 */     params.put("argRelationshipName", argLine.getFields()[5]);
/* 293 */     params.put("argRelationshipType", argLine.getFields()[6]);
/* 294 */     params.put("argMandatoryInd", argLine.getFields()[7]);
/* 295 */     if (argInsert) {
/* 296 */       params.put("argCreateDate", new Date());
/*     */     } else {
/*     */       
/* 299 */       params.put("argUpdateDate", new Date());
/*     */     } 
/* 301 */     return params;
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
/*     */   private QueryRequest getUpdateAttachedItemFlagQueryRequest(String argItemId, String argStoreId, boolean argFlag) {
/* 313 */     return getUpdateItemFlagQueryRequest("UPDATE_ATTACHED_ITEMS_FLAG", argItemId, argStoreId, argFlag);
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
/*     */   private QueryRequest getUpdateItemFlagQueryRequest(String argQueryKey, String argItemId, String argStoreId, boolean argFlag) {
/* 326 */     Map<String, Object> parms = new HashMap<>(4);
/* 327 */     parms.put("argFlag", Integer.valueOf(argFlag ? 1 : 0));
/* 328 */     parms.put("argItemId", argItemId);
/* 329 */     parms.put("argUpdateUserId", "DATALOADER");
/* 330 */     parms.put("argUpdateDate", new Date());
/* 331 */     parms.put("argLevelCode", "STORE");
/* 332 */     parms.put("argLevelValue", argStoreId);
/* 333 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 334 */     return new QueryRequest(argQueryKey, parms);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private QueryRequest getUpdateRelatedItemFlagsQueryRequest(String argStoreId, MOMFileLine argLine) {
/* 344 */     Map<String, Object> params = new HashMap<>(10);
/* 345 */     params.put("argItemId", argLine.getFields()[3]);
/* 346 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 347 */     params.put("argItemId", argLine.getFields()[3]);
/* 348 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 349 */     params.put("argUpdateDate", new Date());
/* 350 */     params.put("argUpdateUserId", "DATALOADER");
/* 351 */     params.put("argItemId", argLine.getFields()[3]);
/* 352 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 353 */     params.put("argLevelCode", "STORE");
/* 354 */     params.put("argLevelValue", argStoreId);
/* 355 */     return new QueryRequest("UPDATE_RELATED_ITEM_FLAGS", params);
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
/*     */   private QueryRequest getUpdateSubstituteItemFlagQueryRequest(String argItemId, String argStoreId, boolean argFlag) {
/* 368 */     return getUpdateItemFlagQueryRequest("UPDATE_SUBSTITUTE_ITEMS_FLAG", argItemId, argStoreId, argFlag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IAttachedItems> loadAttachedItems(String argRelationshipId) {
/* 377 */     Map<String, Object> params = new HashMap<>(3);
/* 378 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 379 */     params.put("argExternalSystem", "RMS");
/* 380 */     params.put("argExternalId", argRelationshipId);
/*     */     
/* 382 */     return (List<IAttachedItems>)DataFactory.getObjectByQueryNoThrow(GET_ATTACHED_ITEMS, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ISubstituteItems> loadSubstituteItems(String argRelationshipId) {
/* 391 */     Map<String, Object> params = new HashMap<>(3);
/* 392 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 393 */     params.put("argExternalSystem", "RMS");
/* 394 */     params.put("argExternalId", argRelationshipId);
/*     */     
/* 396 */     return (List<ISubstituteItems>)DataFactory.getObjectByQueryNoThrow(GET_SUBSTITUTE_ITEMS, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 407 */     String[] fields = argLine.getFields();
/*     */     
/* 409 */     if (fields.length != 8) {
/* 410 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 412 */     if (StringUtils.isEmpty(fields[0])) {
/* 413 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 415 */     if (StringUtils.isEmpty(fields[2])) {
/* 416 */       throw new DataFileException(buildTransformationMessage("Missing RelationshipID", argMetaData, argLine));
/*     */     }
/* 418 */     if (StringUtils.isEmpty(fields[3])) {
/* 419 */       throw new DataFileException(buildTransformationMessage("Missing Item", argMetaData, argLine));
/*     */     }
/* 421 */     if (StringUtils.isEmpty(fields[4])) {
/* 422 */       throw new DataFileException(buildTransformationMessage("Missing Location", argMetaData, argLine));
/*     */     }
/*     */     
/* 425 */     if (!"RELITEMHEADDEL".equals(fields[1])) {
/* 426 */       if (StringUtils.isEmpty(fields[5])) {
/* 427 */         throw new DataFileException(buildTransformationMessage("Missing RelationshipName", argMetaData, argLine));
/*     */       }
/*     */       
/* 430 */       if (StringUtils.isEmpty(fields[6])) {
/* 431 */         throw new DataFileException(buildTransformationMessage("Missing RelationshipType", argMetaData, argLine));
/*     */       }
/*     */       
/* 434 */       if (!EnumUtils.isValidEnum(AbstractRelatedItemTransformer.RelationshipType.class, fields[6])) {
/* 435 */         throw new DataFileException(buildTransformationMessage("Unsupported RelationshipType", argMetaData, argLine));
/*     */       }
/*     */       
/* 438 */       if (StringUtils.isEmpty(fields[7]))
/* 439 */         throw new DataFileException(buildTransformationMessage("Missing MandatoryInd", argMetaData, argLine)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\RelatedItemHeadTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */