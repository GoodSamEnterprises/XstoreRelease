/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.impl.AttachedItemsDAO;
/*     */ import dtv.xst.dao.itm.impl.SubstituteItemsDAO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class RelatedItemDetailTransformer
/*     */   extends AbstractRelatedItemTransformer
/*     */ {
/*  31 */   private static final Logger _logger = Logger.getLogger(RelatedItemDetailTransformer.class);
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_TYPE = 1;
/*     */ 
/*     */   
/*     */   private static final int FIELD_INDEX_RELATIONSHIP_ID = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_RELATED_ITEM = 3;
/*     */   
/*     */   private static final int FIELD_INDEX_LOCATION = 4;
/*     */   
/*     */   private static final int FIELD_INDEX_START_DATE = 6;
/*     */   
/*     */   private static final int FIELD_INDEX_END_DATE = 7;
/*     */ 
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  52 */     List<IPersistable> persistables = new ArrayList<>(2);
/*     */     
/*  54 */     persistables.add(getDeleteByExternalSystemPersistable("itm_attached_items", "RMS", "STORE", ((MOMFileConfiguration)argMetaData
/*  55 */           .getConfigObject()).getStoreId()));
/*     */     
/*  57 */     persistables.add(getDeleteByExternalSystemPersistable("itm_substitute_items", "RMS", "STORE", ((MOMFileConfiguration)argMetaData
/*  58 */           .getConfigObject()).getStoreId()));
/*     */     
/*  60 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*  69 */     if (_logger.isDebugEnabled()) {
/*  70 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/*  73 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/*  75 */     MOMFileLine line = argUnit.getData().get(0);
/*     */     
/*  77 */     validate(argMetaData, line);
/*     */ 
/*     */     
/*  80 */     switch (line.getFields()[1]) {
/*     */       
/*     */       case "FULLRELITEMDET":
/*  83 */         if (!argMetaData.getIsFullReload()) {
/*  84 */           throw new DataFileException(buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       case "RELITEMDETCRE":
/*  90 */         persistables.addAll(getRelatedItemInsertUpdate(argMetaData, line, DaoState.INSERT_ONLY));
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
/* 109 */         return persistables;case "RELITEMDETMOD": persistables.addAll(getRelatedItemInsertUpdate(argMetaData, line, DaoState.INSERT_OR_UPDATE)); return persistables;case "RELITEMDETDEL": persistables.addAll(getRelatedItemDeletion(argMetaData, line)); return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<? extends IPersistable> getRelatedItemDeletion(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 120 */     List<IPersistable> persistables = new ArrayList<>(2);
/*     */     
/* 122 */     String rtlLocId = ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId();
/*     */ 
/*     */ 
/*     */     
/* 126 */     AbstractRelatedItemTransformer.RelatedItemDetail detail = new AbstractRelatedItemTransformer.RelatedItemDetail(this, argLine.getFields()[2], argLine.getFields()[3], null, argLine.getFields()[6], argLine.getFields()[7]);
/*     */ 
/*     */     
/* 129 */     Map<String, Object> siParms = new HashMap<>(5);
/* 130 */     siParms.put("argSubstituteItem", detail.getRelatedItem());
/* 131 */     siParms.put("argExternalId", detail.getRelationshipId());
/* 132 */     siParms.put("argOrgCode", "STORE");
/* 133 */     siParms.put("argOrgValue", rtlLocId);
/* 134 */     siParms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 135 */     persistables.add(new QueryRequest("DELETE_SUBSTITUTE_ITEM", siParms));
/*     */ 
/*     */     
/* 138 */     Map<String, Object> aiParms = new HashMap<>(5);
/* 139 */     aiParms.put("argAttachedItem", detail.getRelatedItem());
/* 140 */     aiParms.put("argExternalId", detail.getRelationshipId());
/* 141 */     aiParms.put("argLevelCode", "STORE");
/* 142 */     aiParms.put("argLevelValue", rtlLocId);
/* 143 */     aiParms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 144 */     persistables.add(new QueryRequest("DELETE_ATTACHED_ITEM", aiParms));
/*     */     
/* 146 */     return persistables;
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
/*     */   protected Collection<? extends IPersistable> getRelatedItemInsertUpdate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine, DaoState argDaoState) {
/* 159 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */ 
/*     */     
/* 162 */     AbstractRelatedItemTransformer.RelatedItemHead head = lookupRelatedItemHead(argLine.getFields()[2], argLine
/* 163 */         .getFields()[4], argLine);
/* 164 */     if (head != null) {
/* 165 */       SubstituteItemsDAO siDao; AttachedItemsDAO aiDao; String rtlLocId = ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId();
/*     */ 
/*     */ 
/*     */       
/* 169 */       AbstractRelatedItemTransformer.RelatedItemDetail detail = new AbstractRelatedItemTransformer.RelatedItemDetail(this, argLine.getFields()[2], argLine.getFields()[3], null, argLine.getFields()[6], argLine.getFields()[7]);
/*     */       
/* 171 */       switch (head.getRelationshipType()) {
/*     */         case SUBS:
/* 173 */           siDao = (SubstituteItemsDAO)getNewDAO("SubstituteItems", argDaoState);
/* 174 */           populateSubstituteItemsDAO(rtlLocId, head, detail, siDao);
/* 175 */           persistables.add(siDao);
/*     */           break;
/*     */         
/*     */         case CRSL:
/*     */         case UPSL:
/* 180 */           aiDao = (AttachedItemsDAO)getNewDAO("AttachedItems", argDaoState);
/* 181 */           populateAttachedItemsDAO(rtlLocId, head, detail, aiDao);
/* 182 */           persistables.add(aiDao);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } else {
/* 188 */       _logger.warn(buildTransformationMessage("Missing head record", argMetaData, argLine));
/*     */     } 
/*     */     
/* 191 */     return persistables;
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
/*     */   private void populateAttachedItemsDAO(String argRtlLocId, AbstractRelatedItemTransformer.RelatedItemHead argHead, AbstractRelatedItemTransformer.RelatedItemDetail argDetail, AttachedItemsDAO argDao) {
/* 204 */     argDao.setLevelCode("STORE");
/* 205 */     argDao.setLevelValue(argRtlLocId);
/*     */     
/* 207 */     argDao.setSoldItemId(argHead.getItem());
/* 208 */     argDao.setAttachedItemId(argDetail.getRelatedItem());
/* 209 */     argDao.setBeginDatetime(argDetail.getStartDate());
/* 210 */     argDao.setEndDatetime(argDetail.getEndDate());
/*     */ 
/*     */ 
/*     */     
/* 214 */     argDao.setPromptToAdd(Boolean.valueOf(true));
/* 215 */     argDao.setPromptToAddMsgKey(getPromptToAddMessageKey());
/*     */     
/* 217 */     argDao.setExternalId(argDetail.getRelationshipId());
/* 218 */     argDao.setExternalSystem("RMS");
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
/*     */   private void populateSubstituteItemsDAO(String argRtlLocId, AbstractRelatedItemTransformer.RelatedItemHead argHead, AbstractRelatedItemTransformer.RelatedItemDetail argDetail, SubstituteItemsDAO argDao) {
/* 231 */     argDao.setLevelCode("STORE");
/* 232 */     argDao.setLevelValue(argRtlLocId);
/*     */     
/* 234 */     argDao.setPrimaryItemId(argHead.getItem());
/* 235 */     argDao.setSubstituteItemId(argDetail.getRelatedItem());
/* 236 */     argDao.setBeginDatetime(argDetail.getStartDate());
/* 237 */     argDao.setEndDatetime(argDetail.getEndDate());
/*     */     
/* 239 */     argDao.setExternalId(argDetail.getRelationshipId());
/* 240 */     argDao.setExternalSystem("RMS");
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
/* 251 */     String[] fields = argLine.getFields();
/*     */     
/* 253 */     if (fields.length != 8) {
/* 254 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 256 */     if (StringUtils.isEmpty(fields[0])) {
/* 257 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 259 */     if (StringUtils.isEmpty(fields[2])) {
/* 260 */       throw new DataFileException(buildTransformationMessage("Missing RelationshipID", argMetaData, argLine));
/*     */     }
/* 262 */     if (StringUtils.isEmpty(fields[3])) {
/* 263 */       throw new DataFileException(buildTransformationMessage("Missing RelatedItem", argMetaData, argLine));
/*     */     }
/* 265 */     if (StringUtils.isEmpty(fields[4]))
/* 266 */       throw new DataFileException(buildTransformationMessage("Missing Location", argMetaData, argLine)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\RelatedItemDetailTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */