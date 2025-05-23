/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.loc.impl.OrgHierarchyDAO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OrgHierarchyTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  33 */   private static final Logger _logger = Logger.getLogger(OrgHierarchyTransformer.class);
/*     */   
/*     */   private static final int FIELD_INDEX_ACTION = 1;
/*     */   
/*     */   private static final int FIELD_INDEX_HIER_LEVEL = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_HIER_NODE = 3;
/*     */   
/*     */   private static final int FIELD_INDEX_HIER_NODE_NAME = 4;
/*     */   
/*     */   private static final int FIELD_INDEX_PARENT_LEVEL = 5;
/*     */   
/*     */   private static final int FIELD_INDEX_PARENT_ID = 6;
/*     */   
/*     */   private static final int FIELD_INDEX_MGR_NAME = 7;
/*     */   
/*     */   private static final int FIELD_INDEX_CURRENCY = 8;
/*     */   
/*     */   private static final String TABLE_ORG_HIERARCHY = "LOC_ORG_HIERARCHY";
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  54 */     List<IPersistable> persistables = new ArrayList<>(1);
/*  55 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("LOC_ORG_HIERARCHY"));
/*  56 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*  66 */     MOMFileLine line = argUnit.getData().get(0);
/*     */ 
/*     */     
/*  69 */     if ((line.getFields()).length <= 8) {
/*  70 */       throw new DataFileException(buildTransformationMessage("Incomplete record for line", argMetaData, line));
/*     */     }
/*     */ 
/*     */     
/*  74 */     HierarchyLevel hierarchyLevel = validateOrgHierarchyLevel(argMetaData, line);
/*     */ 
/*     */     
/*  77 */     ActionCode actionCode = validateActionCode(argMetaData, hierarchyLevel, line);
/*     */     
/*  79 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/*  81 */     switch (actionCode) {
/*     */       case CHAIN:
/*     */       case AREA:
/*  84 */         persistables.add(getInsertUpdateOrgHierarchyNodePersistable(hierarchyLevel, argMetaData, line, DaoState.INSERT_ONLY));
/*     */         break;
/*     */ 
/*     */       
/*     */       case REGION:
/*  89 */         persistables.add(getInsertUpdateOrgHierarchyNodePersistable(hierarchyLevel, argMetaData, line, DaoState.INSERT_OR_UPDATE));
/*     */         break;
/*     */ 
/*     */       
/*     */       case DISTRICT:
/*  94 */         persistables.add(getDeleteOrgHierarchyNodePersistable(hierarchyLevel, argMetaData, line));
/*     */         break;
/*     */     } 
/*  97 */     return persistables;
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
/*     */   private void addIdFieldsToPersistable(OrgHierarchyDAO argDao, HierarchyLevel argHierarchyLevel, MOMFileLine argLine) {
/* 109 */     String[] fields = argLine.getFields();
/*     */ 
/*     */     
/* 112 */     if (argHierarchyLevel.isRoot()) {
/*     */       
/* 114 */       argDao.setLevelCode("*");
/* 115 */       argDao.setLevelValue("*");
/*     */     } else {
/*     */       
/* 118 */       argDao.setLevelCode(argHierarchyLevel.name());
/* 119 */       argDao.setLevelValue(fields[3]);
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
/*     */   private void addUpdatableFieldsToPersistable(OrgHierarchyDAO argDao, HierarchyLevel argHierarchyLevel, HierarchyLevel argParentLevel, DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 135 */     String[] fields = argLine.getFields();
/*     */     
/* 137 */     if (argParentLevel == null) {
/*     */       
/* 139 */       argDao.setParentCode(null);
/* 140 */       argDao.setParentValue(null);
/*     */     }
/* 142 */     else if (argParentLevel.isRoot()) {
/*     */       
/* 144 */       argDao.setParentCode("*");
/* 145 */       argDao.setParentValue("*");
/*     */     } else {
/*     */       
/* 148 */       argDao.setParentCode(argParentLevel.name());
/* 149 */       argDao.setParentValue(fields[6]);
/*     */     } 
/*     */     
/* 152 */     argDao.setLevelOrder(Integer.valueOf(argHierarchyLevel.getLevelOrder()));
/* 153 */     argDao.setSortOrder(Integer.valueOf(0));
/*     */ 
/*     */     
/* 156 */     argDao.setDescription(StringUtils.nonEmpty(fields[4]));
/* 157 */     argDao.setLevelManager(StringUtils.nonEmpty(fields[7]));
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
/*     */   private IPersistable getDeleteOrgHierarchyNodePersistable(HierarchyLevel argHierarchyLevel, DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 171 */     if (argHierarchyLevel.isRoot()) {
/* 172 */       throw new DataFileException(buildTransformationMessage("Unable to delete root node", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/* 176 */     OrgHierarchyDAO dao = (OrgHierarchyDAO)getNewDAO("OrgHierarchy", DaoState.DELETED);
/* 177 */     addIdFieldsToPersistable(dao, argHierarchyLevel, argLine);
/*     */     
/* 179 */     return (IPersistable)dao;
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
/*     */   private IPersistable getInsertUpdateOrgHierarchyNodePersistable(HierarchyLevel argHierarchyLevel, DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine, DaoState argDaoState) {
/* 194 */     HierarchyLevel parentLevel = validateOrgHierarchyParent(argHierarchyLevel, argMetaData, argLine);
/*     */     
/* 196 */     OrgHierarchyDAO dao = (OrgHierarchyDAO)getNewDAO("OrgHierarchy", argDaoState);
/* 197 */     addIdFieldsToPersistable(dao, argHierarchyLevel, argLine);
/* 198 */     addUpdatableFieldsToPersistable(dao, argHierarchyLevel, parentLevel, argMetaData, argLine);
/*     */     
/* 200 */     return (IPersistable)dao;
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
/*     */   private ActionCode validateActionCode(DataFileMetaData<MOMFileConfiguration> argMetaData, HierarchyLevel argHierarchyLevel, MOMFileLine argLine) {
/* 213 */     String actionCodeName = null;
/* 214 */     String[] fields = argLine.getFields();
/* 215 */     if (argMetaData.getIsFullReload()) {
/* 216 */       actionCodeName = fields[1];
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 221 */     else if (fields[1].startsWith(argHierarchyLevel.getShortName())) {
/* 222 */       actionCodeName = fields[1].substring(argHierarchyLevel.getShortName().length());
/*     */     } else {
/*     */       
/* 225 */       throw new DataFileException(buildTransformationMessage("Invalid action code", argMetaData, argLine));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 230 */     ActionCode actionCode = null;
/*     */     try {
/* 232 */       actionCode = ActionCode.valueOf(actionCodeName);
/*     */     }
/* 234 */     catch (Exception e) {
/* 235 */       throw new DataFileException(buildTransformationMessage("Invalid action code", argMetaData, argLine));
/*     */     } 
/*     */ 
/*     */     
/* 239 */     if (argMetaData.getIsFullReload() && actionCode != ActionCode.FULL) {
/* 240 */       throw new DataFileException(buildTransformationMessage("Invalid action code", argMetaData, argLine));
/*     */     }
/*     */     
/* 243 */     if (!argMetaData.getIsFullReload() && actionCode == ActionCode.FULL) {
/* 244 */       throw new DataFileException(buildTransformationMessage("Invalid action code", argMetaData, argLine));
/*     */     }
/*     */     
/* 247 */     return actionCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HierarchyLevel validateOrgHierarchyLevel(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 258 */     String[] fields = argLine.getFields();
/* 259 */     String levelCode = fields[2];
/* 260 */     String levelValue = fields[3];
/*     */ 
/*     */     
/* 263 */     if (StringUtils.isBlank(levelCode) || StringUtils.isBlank(levelValue)) {
/* 264 */       throw new DataFileException(buildTransformationMessage("Unable to process a node with empty hierarchy level or id", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 269 */       HierarchyLevel hierarchyLevel = HierarchyLevel.valueOf(fields[2]);
/* 270 */       return hierarchyLevel;
/*     */     }
/* 272 */     catch (Exception e) {
/* 273 */       throw new DataFileException(buildTransformationMessage("Unable to process a node with empty hierarchy level", argMetaData, argLine));
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
/*     */   private HierarchyLevel validateOrgHierarchyParent(HierarchyLevel argHierarchyLevel, DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 287 */     String[] fields = argLine.getFields();
/* 288 */     String parentLevelCode = fields[5];
/* 289 */     String parentLevelValue = fields[6];
/*     */ 
/*     */     
/* 292 */     if (argHierarchyLevel.isRoot()) {
/* 293 */       if (!StringUtils.isBlank(parentLevelCode) || !StringUtils.isBlank(parentLevelValue)) {
/* 294 */         throw new DataFileException(buildTransformationMessage("Unable to process a root node with a parent hierarchy level", argMetaData, argLine));
/*     */       }
/*     */       
/* 297 */       return null;
/*     */     } 
/*     */     
/* 300 */     if (StringUtils.isBlank(parentLevelCode) || StringUtils.isBlank(parentLevelValue)) {
/* 301 */       throw new DataFileException(buildTransformationMessage("Unable to process a non-root node with empty parent hierarchy level", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 306 */       HierarchyLevel parentLevel = HierarchyLevel.valueOf(parentLevelCode);
/*     */ 
/*     */       
/* 309 */       if (!parentLevel.isParentOf(argHierarchyLevel)) {
/* 310 */         throw new DataFileException(buildTransformationMessage("Unable to process a node with invalid parent hierarchy level", argMetaData, argLine));
/*     */       }
/*     */       
/* 313 */       return parentLevel;
/*     */     }
/* 315 */     catch (Exception e) {
/* 316 */       throw new DataFileException(buildTransformationMessage("Unable to process a node with invalid parent hierarchy level", argMetaData, argLine));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private enum ActionCode
/*     */   {
/* 324 */     FULL, CRE, MOD, DEL;
/*     */   }
/*     */   
/*     */   private enum HierarchyLevel
/*     */   {
/* 329 */     COMPANY("COMP", 0), CHAIN("CHAIN", 10), AREA("AREA", 20), REGION("REGION", 30), DISTRICT("DISTRICT", 40),
/* 330 */     STORE("STORE", 1000), WAREHOUSE("WH", 2000);
/*     */     
/*     */     private final String _shortName;
/*     */     private final int _levelOrder;
/*     */     
/*     */     HierarchyLevel(String argShortName, int argLevelOrder) {
/* 336 */       this._shortName = argShortName;
/* 337 */       this._levelOrder = argLevelOrder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int getLevelOrder() {
/* 344 */       return this._levelOrder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String getShortName() {
/* 351 */       return this._shortName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean isParentOf(HierarchyLevel level) {
/* 360 */       switch (level) {
/*     */         case CHAIN:
/* 362 */           return (this == COMPANY);
/*     */         case AREA:
/* 364 */           return (this == CHAIN);
/*     */         case REGION:
/* 366 */           return (this == AREA);
/*     */         case DISTRICT:
/* 368 */           return (this == REGION);
/*     */         case STORE:
/* 370 */           return (this == DISTRICT);
/*     */         case WAREHOUSE:
/* 372 */           return (this == COMPANY);
/*     */       } 
/* 374 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean isRoot() {
/* 382 */       return (this == COMPANY);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\OrgHierarchyTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */