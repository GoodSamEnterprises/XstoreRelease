/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.impl.MerchandiseHierarchyDAO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MerchHierarchyTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  40 */   private static final Logger _logger = Logger.getLogger(MerchHierarchyTransformer.class);
/*     */   
/*  42 */   private String _orgCode = "*";
/*     */   
/*  44 */   private String _orgValue = "*";
/*     */   
/*  46 */   private static final int _importedLevelsCount = ConfigurationMgr.getNumberOfMerchHierLevels();
/*     */   
/*     */   private static final int FIELD_INDEX_TYPE = 1;
/*     */   
/*     */   private static final int FIELD_INDEX_HIERARCHY_LEVEL = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_HIERARCHY_NODEID = 3;
/*     */   
/*     */   private static final int FIELD_INDEX_HIERARCHY_NODENAME = 4;
/*     */   
/*     */   private static final int FIELD_INDEX_PARENT_LEVEL = 5;
/*     */   
/*     */   private static final int FIELD_INDEX_PARENT_ID = 6;
/*     */   
/*     */   private void validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/*     */     ActionType actionType;
/*  62 */     String[] argLineFields = argLine.getFields();
/*     */ 
/*     */     
/*  65 */     if (argLineFields.length != 10) {
/*  66 */       throw new DataFileException(buildTransformationMessage("Unable to process line because of invalid data linefeeds", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  72 */       actionType = ActionType.valueOf(argLineFields[1]);
/*     */     }
/*  74 */     catch (IllegalArgumentException ex) {
/*  75 */       throw new DataFileException(buildTransformationMessage("Unable to process line because of invalid record type", argMetaData, argLine));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  81 */       HierarchyLevel.valueOf(argLineFields[2]);
/*     */     }
/*  83 */     catch (IllegalArgumentException ex) {
/*  84 */       throw new DataFileException(buildTransformationMessage("Unable to process node because missing/invalid level ", argMetaData, argLine));
/*     */     } 
/*     */ 
/*     */     
/*  88 */     if (!actionType.isDelete()) {
/*     */       
/*  90 */       if (StringUtils.isEmpty(argLineFields[5])) {
/*  91 */         throw new DataFileException(buildTransformationMessage("Unable to process node because missing parent level ", argMetaData, argLine));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  97 */         HierarchyLevel.valueOf(argLineFields[5]);
/*     */       }
/*  99 */       catch (IllegalArgumentException ex) {
/* 100 */         throw new DataFileException(buildTransformationMessage("Unable to process node because missing/invalid parent level ", argMetaData, argLine));
/*     */       } 
/*     */ 
/*     */       
/* 104 */       if (!HierarchyLevel.isValidLevelRelationship(argLineFields[2], argLineFields[5]))
/*     */       {
/* 106 */         throw new DataFileException(buildTransformationMessage("Unable to process node because invalid parent child hierarchy relationship", argMetaData, argLine));
/*     */       }
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
/*     */   private boolean isSupported(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 121 */     String[] argLineFields = argLine.getFields();
/* 122 */     boolean supports = true;
/*     */     
/* 124 */     if (!HierarchyLevel.isSupported(argLineFields[2])) {
/* 125 */       _logger.info(buildTransformationMessage("Unable to process node because level [" + argLineFields[2] + "] does not fall in configured maximum imported levels range [" + _importedLevelsCount + "]", argMetaData, argLine));
/*     */ 
/*     */ 
/*     */       
/* 129 */       supports = false;
/*     */     } 
/* 131 */     return supports;
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
/*     */   private void prepareDAOObject(MerchandiseHierarchyDAO argMerchandiseHierarchyDAO, String[] argLineFields, ActionType argActionType) {
/* 144 */     argMerchandiseHierarchyDAO.setHierarchyId(argLineFields[3] + 
/* 145 */         HierarchyLevel.valueOf(argLineFields[2]).getUniqueChar());
/*     */     
/* 147 */     argMerchandiseHierarchyDAO.setLevelCode(argLineFields[2]);
/*     */     
/* 149 */     if (!argActionType.isDelete() && !HierarchyLevel.isRootNode(argLineFields[2]))
/*     */     {
/*     */       
/* 152 */       argMerchandiseHierarchyDAO.setParentId(argLineFields[6] + 
/* 153 */           HierarchyLevel.valueOf(argLineFields[5]).getUniqueChar());
/*     */     }
/*     */     
/* 156 */     argMerchandiseHierarchyDAO.setDescription(
/* 157 */         StringUtils.nonEmpty(argLineFields[4]));
/*     */     
/* 159 */     if (argActionType.isModify()) {
/* 160 */       argMerchandiseHierarchyDAO.setOrgCode(this._orgCode);
/* 161 */       argMerchandiseHierarchyDAO.setOrgValue(this._orgValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/* 171 */     List<IPersistable> persistables = new ArrayList<>(1);
/* 172 */     persistables.add(DataLoaderUtils.getDeleteByOrganizationPersistable("ITM_MERCH_HIERARCHY"));
/* 173 */     return persistables;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 177 */     this._orgCode = argOrgCode;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 181 */     this._orgValue = argOrgValue;
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
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/* 196 */     MOMFileLine line = argUnit.getData().get(0);
/*     */ 
/*     */     
/* 199 */     String[] lineFields = line.getFields();
/*     */ 
/*     */     
/* 202 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     MerchandiseHierarchyDAO merchandiseHierarchyDAO = null;
/* 209 */     validate(argMetaData, line);
/*     */     
/* 211 */     if (isSupported(argMetaData, line)) {
/* 212 */       ActionType actionType = ActionType.valueOf(lineFields[1]);
/* 213 */       switch (actionType) {
/*     */ 
/*     */         
/*     */         case FULL:
/*     */         case DIVISIONCRE:
/*     */         case GROUPCRE:
/*     */         case DEPTCRE:
/*     */         case CLASSCRE:
/*     */         case SUBCLASSCRE:
/* 222 */           merchandiseHierarchyDAO = (MerchandiseHierarchyDAO)getNewDAO("MerchandiseHierarchy", DaoState.INSERT_ONLY);
/*     */           break;
/*     */ 
/*     */         
/*     */         case DIVISIONMOD:
/*     */         case GROUPMOD:
/*     */         case DEPTMOD:
/*     */         case CLASSMOD:
/*     */         case SUBCLASSMOD:
/* 231 */           merchandiseHierarchyDAO = (MerchandiseHierarchyDAO)getNewDAO("MerchandiseHierarchy", DaoState.INSERT_OR_UPDATE);
/*     */           break;
/*     */         
/*     */         case DIVISIONDEL:
/*     */         case GROUPDEL:
/*     */         case DEPTDEL:
/*     */         case CLASSDEL:
/*     */         case SUBCLASSDEL:
/* 239 */           merchandiseHierarchyDAO = (MerchandiseHierarchyDAO)getNewDAO("MerchandiseHierarchy", DaoState.DELETED);
/*     */           break;
/*     */         default:
/* 242 */           throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 247 */       prepareDAOObject(merchandiseHierarchyDAO, lineFields, actionType);
/*     */       
/* 249 */       persistables.add(merchandiseHierarchyDAO);
/*     */     } 
/* 251 */     return persistables;
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
/*     */   protected enum HierarchyLevel
/*     */   {
/* 267 */     COMPANY(6, 'M'), DIVISION(5, 'V'), GROUP(4, 'G'), DEPARTMENT(3, 'D'), CLASS(2, 'C'), SUBCLASS(1, 'S');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private char _uniqueChar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int _level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     HierarchyLevel(int argLevel, char argUniqueCharacter) {
/* 286 */       this._level = argLevel;
/* 287 */       this._uniqueChar = argUniqueCharacter;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected char getUniqueChar() {
/* 295 */       return this._uniqueChar;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static boolean isSupported(String argHierarchyLevel) {
/* 304 */       return (MerchHierarchyTransformer._importedLevelsCount >= (valueOf(argHierarchyLevel))._level);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static boolean isValidLevelRelationship(String argParent, String argHiearchyLevel) {
/* 312 */       return (Math.abs((valueOf(argParent))._level - (valueOf(argHiearchyLevel))._level) == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static boolean isRootNode(String argHierarchyLevel) {
/* 321 */       return (MerchHierarchyTransformer._importedLevelsCount == (valueOf(argHierarchyLevel))._level);
/*     */     }
/*     */   }
/*     */   
/*     */   private enum ActionType
/*     */   {
/* 327 */     FULL((String)ActionSubType.CRE), DIVISIONCRE((String)ActionSubType.CRE), DIVISIONMOD((String)ActionSubType.MOD), DIVISIONDEL((String)ActionSubType.DEL),
/* 328 */     GROUPCRE((String)ActionSubType.CRE), GROUPMOD((String)ActionSubType.MOD), GROUPDEL((String)ActionSubType.DEL),
/* 329 */     DEPTCRE((String)ActionSubType.CRE), DEPTMOD((String)ActionSubType.MOD),
/* 330 */     DEPTDEL((String)ActionSubType.DEL), CLASSCRE((String)ActionSubType.CRE), CLASSMOD((String)ActionSubType.MOD), CLASSDEL((String)ActionSubType.DEL),
/* 331 */     SUBCLASSCRE((String)ActionSubType.CRE), SUBCLASSMOD((String)ActionSubType.MOD), SUBCLASSDEL((String)ActionSubType.DEL);
/*     */     private ActionSubType _subType;
/*     */     
/*     */     private enum ActionSubType {
/* 335 */       CRE, DEL, MOD;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     ActionType(ActionSubType argSubType) {
/* 341 */       this._subType = argSubType;
/*     */     }
/*     */     
/*     */     public boolean isModify() {
/* 345 */       return ActionSubType.MOD.equals(this._subType);
/*     */     }
/*     */     
/*     */     public boolean isDelete() {
/* 349 */       return ActionSubType.DEL.equals(this._subType);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MerchHierarchyTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */