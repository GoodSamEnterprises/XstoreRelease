/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import dtv.data2.access.impl.DaoState;
/*    */ import dtv.data2.access.query.QueryRequest;
/*    */ import dtv.data2.dataloader.pluggable.DataFileException;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.xst.dao.com.impl.DatabaseTranslationDAO;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
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
/*    */ public abstract class AbstractItemTransformer
/*    */   extends AbstractMOMTransformer
/*    */ {
/* 25 */   private static String PREFIX_ITEM_DESC_TRANSLATION_KEY = "+item:";
/* 26 */   private static String SUFFIX_ITEM_DESC_TRANSLATION_KEY = ":description";
/*    */ 
/*    */   
/*    */   protected DatabaseTranslationDAO getDescriptionTranslationDao(String storeId, String itemId, String description, DaoState argDaoState) {
/* 30 */     DatabaseTranslationDAO dao = (DatabaseTranslationDAO)getNewDAO("DatabaseTranslation", argDaoState);
/* 31 */     dao.setOrgCode("*");
/* 32 */     dao.setOrgValue("*");
/* 33 */     dao.setLocale("DEFAULT");
/* 34 */     dao.setTranslation(description);
/* 35 */     dao.setTranslationKey(getDescriptionTranslationKey(itemId));
/* 36 */     dao.setExternalSystem("RMS");
/* 37 */     return dao;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getDescriptionTranslationKey(String argItemId) {
/* 47 */     return PREFIX_ITEM_DESC_TRANSLATION_KEY + argItemId + SUFFIX_ITEM_DESC_TRANSLATION_KEY;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isCorporate(String argLocation) {
/* 57 */     if (argLocation == null) {
/* 58 */       return false;
/*    */     }
/* 60 */     return argLocation.toUpperCase().startsWith("CORP");
/*    */   }
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
/*    */ 
/*    */   
/*    */   protected QueryRequest createQueryRequestForUpdateTaxGroupID(String argTaxGroupId, String argItemId, String argLevelCode, String argLevelValue) throws DataFileException {
/* 76 */     Map<String, Object> parms = new HashMap<>(4);
/*    */ 
/*    */     
/* 79 */     parms.put("argTaxGroupId", argTaxGroupId);
/* 80 */     parms.put("argUpdateUserId", "DATALOADER");
/* 81 */     parms.put("argUpdateDate", new Date());
/*    */ 
/*    */     
/* 84 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 85 */     parms.put("argLevelCode", argLevelCode);
/* 86 */     parms.put("argLevelValue", argLevelValue);
/*    */ 
/*    */ 
/*    */     
/* 90 */     if (StringUtils.isEmpty(argItemId)) {
/* 91 */       parms.put("argExternalSystem", "RMS");
/*    */     } else {
/*    */       
/* 94 */       parms.put("argItemId", argItemId);
/*    */     } 
/*    */     
/* 97 */     QueryRequest queryRequest = new QueryRequest("UPDATE_ITEM_TAX_GROUP_ID", parms);
/*    */     
/* 99 */     return queryRequest;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\AbstractItemTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */