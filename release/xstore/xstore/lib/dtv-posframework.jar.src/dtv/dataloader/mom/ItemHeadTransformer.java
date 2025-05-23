/*      */ package dtv.dataloader.mom;
/*      */ 
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.DefaultQueryResult;
/*      */ import dtv.data2.access.IPersistable;
/*      */ import dtv.data2.access.IQueryKey;
/*      */ import dtv.data2.access.IQueryResultList;
/*      */ import dtv.data2.access.QueryKey;
/*      */ import dtv.data2.access.impl.DaoState;
/*      */ import dtv.data2.access.query.QueryRequest;
/*      */ import dtv.data2.dataloader.DataLoaderUtils;
/*      */ import dtv.data2.dataloader.pluggable.DataFileException;
/*      */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*      */ import dtv.pos.common.ConfigurationMgr;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.com.impl.DatabaseTranslationDAO;
/*      */ import dtv.xst.dao.itm.impl.ItemCrossReferenceDAO;
/*      */ import dtv.xst.dao.itm.impl.ItemDAO;
/*      */ import dtv.xst.dao.itm.impl.ItemDimensionTypeDAO;
/*      */ import dtv.xst.dao.itm.impl.ItemDimensionValueDAO;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ItemHeadTransformer
/*      */   extends AbstractItemTransformer
/*      */ {
/*   37 */   private static final Logger LOG = LogManager.getLogger(ItemHeadTransformer.class);
/*      */   
/*   39 */   private static final IQueryKey<DefaultQueryResult> SELECT_ITEM_DIFF_GROUP_DESCRIPTIONS = (IQueryKey<DefaultQueryResult>)new QueryKey("SELECT_ITEM_DIFF_GROUP_DESCRIPTIONS", DefaultQueryResult.class);
/*      */ 
/*      */   
/*   42 */   private static final IQueryKey<DefaultQueryResult> SELECT_ITEM_DIFF_DESCRIPTION = (IQueryKey<DefaultQueryResult>)new QueryKey("SELECT_ITEM_DIFF_DESCRIPTION", DefaultQueryResult.class);
/*      */ 
/*      */   
/*   45 */   private static final IQueryKey<DefaultQueryResult> GET_GROUP_ID = (IQueryKey<DefaultQueryResult>)new QueryKey("GET_GROUP_ID", DefaultQueryResult.class);
/*      */   
/*      */   private static final int FIELD_INDEX_FAMILY = 0;
/*      */   
/*      */   private static final int FIELD_INDEX_TYPE = 1;
/*      */   
/*      */   private static final int FIELD_INDEX_LOCATION = 2;
/*      */   
/*      */   private static final int FIELD_INDEX_ITEM = 3;
/*      */   
/*      */   private static final int FIELD_INDEX_ITEM_PARENT = 4;
/*      */   
/*      */   private static final int FIELD_INDEX_ITEM_GRAND_PARENT = 5;
/*      */   
/*      */   private static final int FIELD_INDEX_ITEM_LEVEL = 8;
/*      */   
/*      */   private static final int FIELD_INDEX_TRAN_LEVEL = 9;
/*      */   private static final int FIELD_INDEX_INVENTORY_IND = 10;
/*      */   private static final int FIELD_INDEX_DIFF1_LEVEL = 11;
/*      */   private static final int FIELD_INDEX_DIFF1_TYPE = 12;
/*      */   private static final int FIELD_INDEX_DIFF1 = 13;
/*      */   private static final int FIELD_INDEX_DIFF2_LEVEL = 14;
/*      */   private static final int FIELD_INDEX_DIFF2_TYPE = 15;
/*      */   private static final int FIELD_INDEX_DIFF2 = 16;
/*      */   private static final int FIELD_INDEX_DIFF3_LEVEL = 17;
/*      */   private static final int FIELD_INDEX_DIFF3_TYPE = 18;
/*      */   private static final int FIELD_INDEX_DIFF3 = 19;
/*      */   private static final int FIELD_INDEX_DIFF4 = 22;
/*      */   private static final int FIELD_INDEX_DEPT = 23;
/*      */   private static final int FIELD_INDEX_UNIQUE_CLASS = 25;
/*      */   private static final int FIELD_INDEX_UNIQUE_SUBCLASS = 27;
/*      */   private static final int FIELD_INDEX_ITEM_DESC = 29;
/*      */   private static final int FIELD_INDEX_MERCHANDISE_IND = 33;
/*      */   private static final int FIELD_INDEX_MFG_REC_RETAIL = 44;
/*      */   private static final int FIELD_INDEX_CATCH_WEIGHT_IND = 72;
/*   80 */   private Map<String, String> _deptGroupMapper = new HashMap<>();
/*      */ 
/*      */   
/*   83 */   private Map<String, String> _diffGroupDescMapper = null;
/*      */ 
/*      */   
/*   86 */   private String defaultDiffGroupIdPrefix = "DEF_";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultDiffGroupIdPrefix() {
/*   93 */     return this.defaultDiffGroupIdPrefix;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  106 */     List<IPersistable> persistables = new ArrayList<>(5);
/*  107 */     persistables.add(getDeleteByExternalSystemPersistable("itm_item", "RMS"));
/*  108 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("itm_item_cross_reference"));
/*  109 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("itm_item_dimension_type"));
/*  110 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("itm_item_dimension_value"));
/*      */     
/*  112 */     if (isCorporate(((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId())) {
/*  113 */       persistables.add(getDeleteByExternalSystemPersistable("com_translations", "RMS"));
/*      */     }
/*      */     
/*  116 */     return persistables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultDiffGroupIdPrefix(String argPrefix) {
/*  125 */     if (argPrefix.length() > 4) {
/*  126 */       throw new UnsupportedOperationException("Prefix must be 4 characters or less [" + argPrefix + "]");
/*      */     }
/*  128 */     this.defaultDiffGroupIdPrefix = argPrefix;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*  137 */     LOG.debug(() -> ((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*      */     
/*  139 */     List<IPersistable> persistables = new ArrayList<>(1);
/*      */     
/*  141 */     MOMFileLine line = argUnit.getData().get(0);
/*      */     
/*  143 */     validate(argMetaData, line);
/*      */     
/*  145 */     if ("N".equals(line.getFields()[33]))
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */       
/*  151 */       LOG.info(() -> "Skipping non-merchandise (merchandiseInd='N') item record:" + line.getFileLine()); }
/*      */     else
/*  153 */     { if (isSupported(line))
/*      */       
/*  155 */       { switch (line.getFields()[1])
/*      */         
/*      */         { case "FULLHDR":
/*  158 */             if (!argMetaData.getIsFullReload()) {
/*  159 */               throw new DataFileException(
/*  160 */                   buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*      */             }
/*      */ 
/*      */           
/*      */           case "ITEMHDRCRE":
/*  165 */             if (isCrossReferenceItem(line)) {
/*      */ 
/*      */               
/*  168 */               ItemCrossReferenceDAO xrefDao = (ItemCrossReferenceDAO)getNewDAO("ItemCrossReference", DaoState.INSERT_ONLY);
/*  169 */               populateItemCrossReferenceDAO(line, xrefDao);
/*  170 */               persistables.add(xrefDao);
/*      */             } else {
/*      */               String dimensionSystem;
/*      */               
/*  174 */               ItemDAO itemDao = (ItemDAO)getNewDAO("Item", DaoState.INSERT_ONLY);
/*  175 */               populateItemDAO(argMetaData, line, itemDao);
/*  176 */               switch (itemDao.getItemLevelCode()) {
/*      */ 
/*      */                 
/*      */                 case "STYLE":
/*  180 */                   dimensionSystem = getLineLevelItemId(argMetaData, line);
/*  181 */                   persistables.addAll(getNewDimensionTypeDAOs(line, dimensionSystem));
/*      */                   break;
/*      */               } 
/*      */               
/*  185 */               persistables.add(itemDao);
/*      */               
/*  187 */               if (isStyleItem(line))
/*      */               {
/*  189 */                 persistables.addAll(getNewDimensionValueDAOs(line, getLineLevelItemId(argMetaData, line)));
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*  194 */               if (isCorporate(((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId())) {
/*  195 */                 DatabaseTranslationDAO descTranslationDao = getDescriptionTranslationDao(line
/*  196 */                     .getFields()[2], line.getFields()[3], line
/*  197 */                     .getFields()[29], DaoState.INSERT_ONLY);
/*  198 */                 persistables.add(descTranslationDao);
/*      */               } 
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  306 */             return persistables;case "ITEMHDRMOD": if (isCrossReferenceItem(line)) { ItemCrossReferenceDAO xrefDao = (ItemCrossReferenceDAO)getNewDAO("ItemCrossReference", DaoState.INSERT_OR_UPDATE); populateItemCrossReferenceDAO(line, xrefDao); persistables.add(xrefDao); } else { String dimensionSystem; QueryRequest request = createQueryRequestForUpdateItem(argMetaData, line); switch ((String)request.getParams().get("argItemLevelCode")) { case "STYLE": dimensionSystem = getLineLevelItemId(argMetaData, line); persistables.add(getDeleteDimensionTypesQueryRequest(dimensionSystem, "*", "*")); persistables.addAll(getNewDimensionTypeDAOs(line, dimensionSystem)); break; }  persistables.add(request); if (isStyleItem(line)) persistables.addAll(getNewDimensionValueDAOs(line, getLineLevelItemId(argMetaData, line)));  if (isCorporate(((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId())) { DatabaseTranslationDAO descTranslationDao = getDescriptionTranslationDao(line.getFields()[2], line.getFields()[3], line.getFields()[29], DaoState.INSERT_OR_UPDATE); persistables.add(descTranslationDao); }  }  return persistables;case "ITEMHDRDEL": if (isBelowTransactionLevel(line)) { ItemCrossReferenceDAO xrefDao = (ItemCrossReferenceDAO)getNewDAO("ItemCrossReference", DaoState.DELETED); xrefDao.setManufacturerUpc(line.getFields()[3]); persistables.add(xrefDao); } else { ItemDAO itemDao = (ItemDAO)getNewDAO("Item", DaoState.DELETED); itemDao.setItemId(line.getFields()[3]); persistables.add(itemDao); }  if (isLineLevel(line) && Integer.parseInt(line.getFields()[9]) > 1) { String dimensionSystem = line.getFields()[3]; persistables.add(getDeleteDimensionTypesQueryRequest(dimensionSystem, "*", "*")); persistables.add(getDeleteDimensionValuesQueryRequest(dimensionSystem, "*", "*")); }  if (isCorporate(((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId())) { DatabaseTranslationDAO descTranslationDao = getDescriptionTranslationDao(line.getFields()[2], line.getFields()[3], line.getFields()[29], DaoState.DELETED); persistables.add(descTranslationDao); }  return persistables; }  throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line)); }  LOG.info(() -> "Skipping above-transaction level item record:" + line.getFileLine()); }  return persistables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getGroupId(String departmentId) {
/*  316 */     String groupId = this._deptGroupMapper.get(departmentId);
/*      */     
/*  318 */     if (groupId == null) {
/*      */       
/*  320 */       Map<String, Object> params = new HashMap<>(6);
/*  321 */       params.put("argDepartmentId", departmentId);
/*  322 */       params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*      */ 
/*      */ 
/*      */       
/*  326 */       IQueryResultList<DefaultQueryResult> results = DataFactory.getObjectByQueryNoThrow(GET_GROUP_ID, params);
/*      */ 
/*      */       
/*  329 */       if (!results.isEmpty()) {
/*  330 */         groupId = (String)((DefaultQueryResult)results.get(0)).get("groupId");
/*  331 */         if (groupId != null) {
/*  332 */           this._deptGroupMapper.put(departmentId, groupId);
/*      */         } else {
/*      */           
/*  335 */           groupId = "";
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  340 */     return groupId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private QueryRequest createQueryRequestForUpdateItem(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/*  351 */     Map<String, Object> parms = new HashMap<>(4);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  356 */     parms.put("argItemTypeCode", "STANDARD");
/*  357 */     parms.put("argExternalSystem", "RMS");
/*      */     
/*  359 */     String translationKey = getDescriptionTranslationKey(argLine.getFields()[3]);
/*      */ 
/*      */ 
/*      */     
/*  363 */     parms.put("argDescription", translationKey);
/*  364 */     parms.put("argName", translationKey);
/*      */ 
/*      */     
/*  367 */     setParmsForMerchandiseHierarchy(argLine, parms);
/*      */     
/*  369 */     parms.put("argItemLevelCode", isStyle(argLine) ? "STYLE" : "ITEM");
/*      */     
/*  371 */     if (isStyle(argLine)) {
/*      */       
/*  373 */       parms.put("argDimensionSystem", getLineLevelItemId(argMetaData, argLine));
/*  374 */       parms.put("argParentItemId", null);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  379 */       parms.put("argDimension1", getDiffGroup1(argLine));
/*  380 */       parms.put("argDimension2", getDiffGroup2(argLine));
/*  381 */       parms.put("argDimension3", getDiffGroup3(argLine));
/*      */     
/*      */     }
/*  384 */     else if (isStyleItem(argLine)) {
/*  385 */       String dimensionSystem = getLineLevelItemId(argMetaData, argLine);
/*      */       
/*  387 */       parms.put("argDimensionSystem", dimensionSystem);
/*  388 */       parms.put("argParentItemId", dimensionSystem);
/*      */       
/*  390 */       parms.put("argDimension1", StringUtils.nonEmpty(argLine.getFields()[13]));
/*  391 */       parms.put("argDimension2", StringUtils.nonEmpty(argLine.getFields()[16]));
/*  392 */       parms.put("argDimension3", StringUtils.nonEmpty(argLine.getFields()[19]));
/*      */     }
/*      */     else {
/*      */       
/*  396 */       parms.put("argDimensionSystem", null);
/*  397 */       parms.put("argParentItemId", null);
/*  398 */       parms.put("argDimension1", null);
/*  399 */       parms.put("argDimension2", null);
/*  400 */       parms.put("argDimension3", null);
/*      */     } 
/*      */     
/*  403 */     parms.put("argNotInventoried", Boolean.valueOf("N".equals(argLine.getFields()[10])));
/*  404 */     parms.put("argMeasurementRequired", Boolean.valueOf("Y".equals(argLine.getFields()[72])));
/*      */     
/*  406 */     if (!StringUtils.isEmpty(argLine.getFields()[44])) {
/*  407 */       parms.put("argListPrice", new BigDecimal(argLine.getFields()[44]));
/*      */     } else {
/*      */       
/*  410 */       parms.put("argListPrice", null);
/*      */     } 
/*      */     
/*  413 */     parms.put("argUpdateDate", new Date());
/*  414 */     parms.put("argUpdateUserId", "DATALOADER");
/*      */ 
/*      */     
/*  417 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  418 */     parms.put("argItemId", StringUtils.nonEmpty(argLine.getFields()[3]));
/*  419 */     parms.put("argOrgCode", "*");
/*  420 */     parms.put("argOrgValue", "*");
/*      */     
/*  422 */     QueryRequest queryRequest = new QueryRequest("UPDATE_ITEM", parms);
/*      */     
/*  424 */     return queryRequest;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private QueryRequest getDeleteDimensionTypesQueryRequest(String argDimensionSystem, String argOrgCode, String argOrgValue) {
/*  438 */     Map<String, Object> parms = new HashMap<>(4);
/*  439 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  440 */     parms.put("argOrgCode", argOrgCode);
/*  441 */     parms.put("argOrgValue", argOrgValue);
/*  442 */     parms.put("argDimensionSystem", argDimensionSystem);
/*      */     
/*  444 */     QueryRequest query = new QueryRequest("DELETE_DIMENSION_TYPES", parms);
/*      */     
/*  446 */     return query;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private QueryRequest getDeleteDimensionValuesQueryRequest(String argDimensionSystem, String argOrgCode, String argOrgValue) {
/*  460 */     Map<String, Object> parms = new HashMap<>(4);
/*  461 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  462 */     parms.put("argOrgCode", argOrgCode);
/*  463 */     parms.put("argOrgValue", argOrgValue);
/*  464 */     parms.put("argDimensionSystem", argDimensionSystem);
/*  465 */     QueryRequest query = new QueryRequest("DELETE_DIMENSION_VALUES", parms);
/*  466 */     return query;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getDiffDescription(String argDiffId) {
/*  476 */     String description = null;
/*      */     
/*  478 */     Map<String, Object> params = new HashMap<>(1);
/*  479 */     params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  480 */     params.put("argDiffId", argDiffId);
/*      */ 
/*      */     
/*  483 */     IQueryResultList<DefaultQueryResult> results = DataFactory.getObjectByQueryNoThrow(SELECT_ITEM_DIFF_DESCRIPTION, params);
/*  484 */     if (!results.isEmpty())
/*      */     {
/*  486 */       description = (String)((DefaultQueryResult)results.get(0)).get("diffDesc");
/*      */     }
/*      */     
/*  489 */     return description;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getDiffGroup1(MOMFileLine argLine) {
/*  502 */     String diffGroup = null;
/*  503 */     if ("GROUP".equals(argLine.getFields()[11])) {
/*  504 */       diffGroup = StringUtils.nonEmpty(argLine.getFields()[13]);
/*      */     }
/*  506 */     else if ("ID".equals(argLine.getFields()[11])) {
/*  507 */       diffGroup = getDefaultDiffGroupIdPrefix() + argLine.getFields()[12];
/*      */     } 
/*  509 */     return diffGroup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getDiffGroup2(MOMFileLine argLine) {
/*  522 */     String diffGroup = null;
/*  523 */     if ("GROUP".equals(argLine.getFields()[14])) {
/*  524 */       diffGroup = StringUtils.nonEmpty(argLine.getFields()[16]);
/*      */     }
/*  526 */     else if ("ID".equals(argLine.getFields()[14])) {
/*  527 */       diffGroup = getDefaultDiffGroupIdPrefix() + argLine.getFields()[15];
/*      */     } 
/*  529 */     return diffGroup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getDiffGroup3(MOMFileLine argLine) {
/*  542 */     String diffGroup = null;
/*  543 */     if ("GROUP".equals(argLine.getFields()[17])) {
/*  544 */       diffGroup = StringUtils.nonEmpty(argLine.getFields()[19]);
/*      */     }
/*  546 */     else if ("ID".equals(argLine.getFields()[17])) {
/*  547 */       diffGroup = getDefaultDiffGroupIdPrefix() + argLine.getFields()[18];
/*      */     } 
/*  549 */     return diffGroup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getLineLevelItemId(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/*  564 */     switch (argLine.getFields()[8]) {
/*      */       case "3":
/*  566 */         return argLine.getFields()[5];
/*      */       case "2":
/*  568 */         return argLine.getFields()[4];
/*      */       case "1":
/*  570 */         return argLine.getFields()[3];
/*      */     } 
/*  572 */     throw new DataFileException(
/*  573 */         buildTransformationMessage("Unsupported LineLevel", argMetaData, argLine));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private IPersistable getNewDimensionTypeDao(String argDimensionSystem, String argDiffType, int argSequence, String argDescription, String argLocation) {
/*  589 */     ItemDimensionTypeDAO dao = (ItemDimensionTypeDAO)getNewDAO("ItemDimensionType", DaoState.INSERT_ONLY);
/*  590 */     dao.setDimensionSystem(argDimensionSystem);
/*  591 */     dao.setDimension(argDiffType);
/*  592 */     dao.setSequence(Integer.valueOf(argSequence));
/*      */     
/*  594 */     if (argDescription != null) {
/*  595 */       dao.setDescription(argDescription);
/*      */     } else {
/*      */       
/*  598 */       LOG.warn(() -> "Description does not exist for DiffType: " + argDiffType);
/*      */     } 
/*      */     
/*  601 */     dao.setOrgCode("*");
/*  602 */     dao.setOrgValue("*");
/*  603 */     return (IPersistable)dao;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Collection<? extends IPersistable> getNewDimensionTypeDAOs(MOMFileLine argLine, String argDimensionSystem) {
/*  618 */     List<IPersistable> persistables = new ArrayList<>(6);
/*      */     
/*  620 */     if (this._diffGroupDescMapper == null) {
/*      */       
/*  622 */       this._diffGroupDescMapper = new HashMap<>(10);
/*      */ 
/*      */       
/*  625 */       Map<String, Object> params = new HashMap<>(1);
/*      */       
/*  627 */       IQueryResultList<DefaultQueryResult> results = DataFactory.getObjectByQueryNoThrow(SELECT_ITEM_DIFF_GROUP_DESCRIPTIONS, params);
/*  628 */       params.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*      */ 
/*      */       
/*  631 */       if (!results.isEmpty()) {
/*      */         
/*  633 */         for (DefaultQueryResult result : results) {
/*      */           
/*  635 */           String diffGroupId = (String)result.get("diffGroupId");
/*  636 */           String diffGroupDesc = (String)result.get("diffGroupDesc");
/*      */           
/*  638 */           this._diffGroupDescMapper.put(diffGroupId, diffGroupDesc);
/*      */         } 
/*      */       } else {
/*      */         
/*  642 */         LOG.warn("No DiffGroups found");
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  648 */     if (!StringUtils.isEmpty(getDiffGroup1(argLine))) {
/*  649 */       String description = this._diffGroupDescMapper.get(getDiffGroup1(argLine));
/*      */       
/*  651 */       persistables.add(getNewDimensionTypeDao(argDimensionSystem, argLine.getFields()[12], 1, description, argLine
/*  652 */             .getFields()[2]));
/*      */     } 
/*      */ 
/*      */     
/*  656 */     if (!StringUtils.isEmpty(getDiffGroup2(argLine))) {
/*  657 */       String description = this._diffGroupDescMapper.get(getDiffGroup2(argLine));
/*      */       
/*  659 */       persistables.add(getNewDimensionTypeDao(argDimensionSystem, argLine.getFields()[15], 2, description, argLine
/*  660 */             .getFields()[2]));
/*      */     } 
/*      */ 
/*      */     
/*  664 */     if (!StringUtils.isEmpty(getDiffGroup3(argLine))) {
/*      */       
/*  666 */       String description = this._diffGroupDescMapper.get(getDiffGroup3(argLine));
/*      */       
/*  668 */       persistables.add(getNewDimensionTypeDao(argDimensionSystem, argLine.getFields()[18], 3, description, argLine
/*  669 */             .getFields()[2]));
/*      */     } 
/*      */     
/*  672 */     return persistables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemDimensionValueDAO getNewDimensionValueDao(String argDimensionSystem, String argDimension, String argValue, String argDescription, String argLocation) {
/*  688 */     ItemDimensionValueDAO dao = (ItemDimensionValueDAO)getNewDAO("ItemDimensionValue", DaoState.INSERT_ONLY);
/*  689 */     dao.setDimensionSystem(argDimensionSystem);
/*  690 */     dao.setDimension(argDimension);
/*  691 */     dao.setDimensionValue(argValue);
/*  692 */     dao.setDescription(argDescription);
/*  693 */     dao.setSortOrder(null);
/*      */     
/*  695 */     dao.setOrgCode("*");
/*  696 */     dao.setOrgValue("*");
/*  697 */     return dao;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Collection<? extends IPersistable> getNewDimensionValueDAOs(MOMFileLine argLine, String argDimensionSystem) {
/*  709 */     List<IPersistable> persistables = new ArrayList<>(6);
/*      */ 
/*      */ 
/*      */     
/*  713 */     if (!StringUtils.isEmpty(getDiffGroup1(argLine)))
/*      */     {
/*  715 */       persistables.add(getNewDimensionValueDao(argDimensionSystem, argLine
/*  716 */             .getFields()[12], argLine.getFields()[13], 
/*  717 */             getDiffDescription(argLine.getFields()[13]), argLine
/*  718 */             .getFields()[2]));
/*      */     }
/*      */ 
/*      */     
/*  722 */     if (!StringUtils.isEmpty(getDiffGroup2(argLine)))
/*      */     {
/*  724 */       persistables.add(getNewDimensionValueDao(argDimensionSystem, argLine
/*  725 */             .getFields()[15], argLine.getFields()[16], 
/*  726 */             getDiffDescription(argLine.getFields()[16]), argLine
/*  727 */             .getFields()[2]));
/*      */     }
/*      */ 
/*      */     
/*  731 */     if (!StringUtils.isEmpty(getDiffGroup3(argLine)))
/*      */     {
/*  733 */       persistables.add(getNewDimensionValueDao(argDimensionSystem, argLine
/*  734 */             .getFields()[18], argLine.getFields()[19], 
/*  735 */             getDiffDescription(argLine.getFields()[19]), argLine
/*  736 */             .getFields()[2]));
/*      */     }
/*      */     
/*  739 */     return persistables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean hasParent(MOMFileLine argLine) {
/*  748 */     return !StringUtils.isEmpty(argLine.getFields()[4]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isAboveTransactionLevel(MOMFileLine argLine) {
/*  758 */     return 
/*  759 */       (Integer.parseInt(argLine.getFields()[8]) < Integer.parseInt(argLine.getFields()[9]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isBelowTransactionLevel(MOMFileLine argLine) {
/*  769 */     return 
/*  770 */       (Integer.parseInt(argLine.getFields()[8]) > Integer.parseInt(argLine.getFields()[9]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isCrossReferenceItem(MOMFileLine argLine) {
/*  779 */     return (isBelowTransactionLevel(argLine) && hasParent(argLine));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isLineLevel(MOMFileLine argLine) {
/*  788 */     return (Integer.parseInt(argLine.getFields()[8]) == 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isRegularItem(MOMFileLine argLine) {
/*  797 */     return (isTransactionLevel(argLine) && !isStyleItem(argLine));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isStyle(MOMFileLine argLine) {
/*  807 */     return (isAboveTransactionLevel(argLine) && isLineLevel(argLine) && ("GROUP"
/*  808 */       .equals(argLine.getFields()[11]) || "ID"
/*  809 */       .equals(argLine.getFields()[11])));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isStyleItem(MOMFileLine argLine) {
/*  820 */     return (Integer.parseInt(argLine.getFields()[8]) > 1 && isTransactionLevel(argLine) && "ID"
/*  821 */       .equals(argLine.getFields()[11]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSupported(MOMFileLine argLine) {
/*  831 */     if ("ITEMHDRDEL".equals(argLine.getFields()[1]))
/*      */     {
/*      */       
/*  834 */       return (isLineLevel(argLine) || isTransactionLevel(argLine) || isBelowTransactionLevel(argLine));
/*      */     }
/*      */     
/*  837 */     return (isStyle(argLine) || isStyleItem(argLine) || isRegularItem(argLine) || 
/*  838 */       isBelowTransactionLevel(argLine));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isTransactionLevel(MOMFileLine argLine) {
/*  848 */     return 
/*  849 */       (Integer.parseInt(argLine.getFields()[8]) == Integer.parseInt(argLine.getFields()[9]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void populateItemCrossReferenceDAO(MOMFileLine argLine, ItemCrossReferenceDAO argDao) {
/*  858 */     argDao.setItemId(argLine.getFields()[4]);
/*  859 */     argDao.setManufacturerUpc(argLine.getFields()[3]);
/*      */     
/*  861 */     argDao.setOrgCode("*");
/*  862 */     argDao.setOrgValue("*");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void populateItemDAO(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine, ItemDAO argDao) {
/*  874 */     argDao.setItemId(argLine.getFields()[3]);
/*      */ 
/*      */     
/*  877 */     argDao.setItemTypeCode("STANDARD");
/*  878 */     argDao.setExternalSystem("RMS");
/*      */ 
/*      */ 
/*      */     
/*  882 */     String translationKey = getDescriptionTranslationKey(argLine.getFields()[3]);
/*  883 */     argDao.setDescription(translationKey);
/*  884 */     argDao.setName(translationKey);
/*      */ 
/*      */     
/*  887 */     populateMerchandiseHierarchy(argLine, argDao);
/*      */     
/*  889 */     argDao.setItemLevelCode(isStyle(argLine) ? "STYLE" : "ITEM");
/*      */ 
/*      */ 
/*      */     
/*  893 */     if (isStyle(argLine)) {
/*      */       
/*  895 */       argDao.setDimensionSystem(getLineLevelItemId(argMetaData, argLine));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  900 */       argDao.setDimension1(getDiffGroup1(argLine));
/*  901 */       argDao.setDimension2(getDiffGroup2(argLine));
/*  902 */       argDao.setDimension3(getDiffGroup3(argLine));
/*      */     }
/*  904 */     else if (isStyleItem(argLine)) {
/*      */       
/*  906 */       String dimensionSystem = getLineLevelItemId(argMetaData, argLine);
/*  907 */       argDao.setDimensionSystem(dimensionSystem);
/*  908 */       argDao.setParentItemId(dimensionSystem);
/*  909 */       argDao.setDimension1(StringUtils.nonEmpty(argLine.getFields()[13]));
/*  910 */       argDao.setDimension2(StringUtils.nonEmpty(argLine.getFields()[16]));
/*  911 */       argDao.setDimension3(StringUtils.nonEmpty(argLine.getFields()[19]));
/*      */     } else {
/*      */       
/*  914 */       argDao.setParentItemId(null);
/*      */     } 
/*      */     
/*  917 */     argDao.setNotInventoried(Boolean.valueOf("N".equals(argLine.getFields()[10])));
/*  918 */     argDao.setMeasurementRequired(Boolean.valueOf("Y".equals(argLine.getFields()[72])));
/*      */     
/*  920 */     if (!StringUtils.isEmpty(argLine.getFields()[44])) {
/*  921 */       argDao.setListPrice(new BigDecimal(argLine.getFields()[44]));
/*      */     }
/*      */     
/*  924 */     argDao.setOrgCode("*");
/*  925 */     argDao.setOrgValue("*");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void populateMerchandiseHierarchy(MOMFileLine argLine, ItemDAO argDao) {
/*      */     String departmentId;
/*  947 */     switch (ConfigurationMgr.getNumberOfMerchHierLevels()) {
/*      */       
/*      */       case 4:
/*  950 */         departmentId = argLine.getFields()[23] + MerchHierarchyTransformer.HierarchyLevel.DEPARTMENT.getUniqueChar();
/*      */         
/*  952 */         argDao.setMerchLevel1Id(getGroupId(departmentId));
/*  953 */         argDao.setMerchLevel2Id(departmentId);
/*  954 */         argDao.setMerchLevel3Id(argLine
/*  955 */             .getFields()[25] + MerchHierarchyTransformer.HierarchyLevel.CLASS.getUniqueChar());
/*  956 */         argDao.setMerchLevel4Id(argLine
/*  957 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/*      */         return;
/*      */       case 3:
/*  960 */         argDao.setMerchLevel1Id(argLine
/*  961 */             .getFields()[23] + MerchHierarchyTransformer.HierarchyLevel.DEPARTMENT.getUniqueChar());
/*  962 */         argDao.setMerchLevel2Id(argLine
/*  963 */             .getFields()[25] + MerchHierarchyTransformer.HierarchyLevel.CLASS.getUniqueChar());
/*  964 */         argDao.setMerchLevel3Id(argLine
/*  965 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/*      */         return;
/*      */       case 2:
/*  968 */         argDao.setMerchLevel2Id(argLine
/*  969 */             .getFields()[25] + MerchHierarchyTransformer.HierarchyLevel.CLASS.getUniqueChar());
/*  970 */         argDao.setMerchLevel1Id(argLine
/*  971 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/*      */         return;
/*      */       case 1:
/*  974 */         argDao.setMerchLevel1Id(argLine
/*  975 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/*      */         return;
/*      */     } 
/*      */     
/*  979 */     LOG.warn(() -> "Unable to map Merchandise Hieararchy Levels: Unsupported number of levels configured " + ConfigurationMgr.getNumberOfMerchHierLevels());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setParmsForMerchandiseHierarchy(MOMFileLine argLine, Map<String, Object> parms) {
/*      */     String departmentId;
/*  991 */     switch (ConfigurationMgr.getNumberOfMerchHierLevels()) {
/*      */       
/*      */       case 4:
/*  994 */         departmentId = argLine.getFields()[23] + MerchHierarchyTransformer.HierarchyLevel.DEPARTMENT.getUniqueChar();
/*      */         
/*  996 */         parms.put("argMerchLevel1Id", getGroupId(departmentId));
/*  997 */         parms.put("argMerchLevel2Id", departmentId);
/*  998 */         parms.put("argMerchLevel3Id", argLine
/*  999 */             .getFields()[25] + MerchHierarchyTransformer.HierarchyLevel.CLASS.getUniqueChar());
/* 1000 */         parms.put("argMerchLevel4Id", argLine
/* 1001 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/*      */         return;
/*      */       case 3:
/* 1004 */         parms.put("argMerchLevel1Id", argLine
/* 1005 */             .getFields()[23] + MerchHierarchyTransformer.HierarchyLevel.DEPARTMENT.getUniqueChar());
/* 1006 */         parms.put("argMerchLevel2Id", argLine
/* 1007 */             .getFields()[25] + MerchHierarchyTransformer.HierarchyLevel.CLASS.getUniqueChar());
/* 1008 */         parms.put("argMerchLevel3Id", argLine
/* 1009 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/* 1010 */         parms.put("argMerchLevel4Id", null);
/*      */         return;
/*      */       case 2:
/* 1013 */         parms.put("argMerchLevel2Id", argLine
/* 1014 */             .getFields()[25] + MerchHierarchyTransformer.HierarchyLevel.CLASS.getUniqueChar());
/* 1015 */         parms.put("argMerchLevel1Id", argLine
/* 1016 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/* 1017 */         parms.put("argMerchLevel3Id", null);
/* 1018 */         parms.put("argMerchLevel4Id", null);
/*      */         return;
/*      */       case 1:
/* 1021 */         parms.put("MerchLevel1Id", argLine
/* 1022 */             .getFields()[27] + MerchHierarchyTransformer.HierarchyLevel.SUBCLASS.getUniqueChar());
/* 1023 */         parms.put("argMerchLevel2Id", null);
/* 1024 */         parms.put("argMerchLevel3Id", null);
/* 1025 */         parms.put("argMerchLevel4Id", null);
/*      */         return;
/*      */     } 
/*      */     
/* 1029 */     LOG.warn(() -> "Unable to map Merchandise Hieararchy Levels: Unsupported number of levels configured " + ConfigurationMgr.getNumberOfMerchHierLevels());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 1043 */     String[] fields = argLine.getFields();
/*      */     
/* 1045 */     if (fields.length != 83) {
/* 1046 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*      */     }
/*      */     
/* 1049 */     if (!"ITEMS".equals(fields[0])) {
/* 1050 */       throw new DataFileException(buildTransformationMessage("Family must be 'ITEMS'", argMetaData, argLine));
/*      */     }
/*      */     
/* 1053 */     if (StringUtils.isEmpty(fields[3])) {
/* 1054 */       throw new DataFileException(buildTransformationMessage("Missing Item", argMetaData, argLine));
/*      */     }
/*      */     
/* 1057 */     if (StringUtils.isEmpty(fields[2])) {
/* 1058 */       throw new DataFileException(buildTransformationMessage("Missing Location", argMetaData, argLine));
/*      */     }
/*      */ 
/*      */     
/* 1062 */     if (!"ITEMHDRDEL".equals(argLine.getFields()[1])) {
/*      */       
/* 1064 */       if (StringUtils.isEmpty(fields[8])) {
/* 1065 */         throw new DataFileException(buildTransformationMessage("Missing Item Level", argMetaData, argLine));
/*      */       }
/* 1067 */       if (StringUtils.isEmpty(fields[9])) {
/* 1068 */         throw new DataFileException(buildTransformationMessage("Missing Tranlevel", argMetaData, argLine));
/*      */       }
/* 1070 */       if (StringUtils.isEmpty(fields[10])) {
/* 1071 */         throw new DataFileException(buildTransformationMessage("Missing InventoryInd", argMetaData, argLine));
/*      */       }
/* 1073 */       if (StringUtils.isEmpty(fields[23])) {
/* 1074 */         throw new DataFileException(buildTransformationMessage("Missing Dept", argMetaData, argLine));
/*      */       }
/* 1076 */       if (StringUtils.isEmpty(fields[25])) {
/* 1077 */         throw new DataFileException(buildTransformationMessage("Missing Class", argMetaData, argLine));
/*      */       }
/* 1079 */       if (StringUtils.isEmpty(fields[27])) {
/* 1080 */         throw new DataFileException(buildTransformationMessage("Missing Subclass", argMetaData, argLine));
/*      */       }
/* 1082 */       if (StringUtils.isEmpty(fields[29])) {
/* 1083 */         throw new DataFileException(buildTransformationMessage("Missing ItemDesc", argMetaData, argLine));
/*      */       }
/* 1085 */       if (StringUtils.isEmpty(fields[33])) {
/* 1086 */         throw new DataFileException(
/* 1087 */             buildTransformationMessage("Missing MerchandiseInd", argMetaData, argLine));
/*      */       }
/* 1089 */       if (StringUtils.isEmpty(fields[72])) {
/* 1090 */         throw new DataFileException(
/* 1091 */             buildTransformationMessage("Missing CatchWeightInd", argMetaData, argLine));
/*      */       }
/*      */ 
/*      */       
/* 1095 */       if (!StringUtils.isEmpty(argLine.getFields()[22]))
/* 1096 */         LOG.warn(() -> "DIFF4 is not supported. " + argLine.getFileLine()); 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\ItemHeadTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */