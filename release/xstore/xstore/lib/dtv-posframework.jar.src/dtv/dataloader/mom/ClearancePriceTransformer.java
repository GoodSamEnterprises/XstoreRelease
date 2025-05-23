/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.pos.common.PriceTypes;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.impl.ItemPricesDAO;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class ClearancePriceTransformer
/*     */   extends AbstractPriceTransformer
/*     */ {
/*     */   private static final int FIELD_INDEX_FDETL_SELLING_RETAIL = 6;
/*     */   private static final int FIELD_INDEX_FDETL_RESET_CLEARANCE_ID = 9;
/*     */   
/*     */   protected String getExternalSystem() {
/*  47 */     return "RPM-CLRPC";
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
/*     */   protected List<IPersistable> transformDetail(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/*  60 */     validateDetail(argMetaData, argLine);
/*     */     
/*  62 */     List<IPersistable> persistables = new ArrayList<>(2);
/*     */     
/*  64 */     String[] fields = argLine.getFields();
/*  65 */     if ("MOD".equals(fields[2]))
/*     */     {
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
/*  77 */       persistables
/*  78 */         .add(getDeletePriceByEventQueryRequest(fields[3], getExternalSystem(), fields[4], ((MOMFileConfiguration)argMetaData
/*  79 */             .getConfigObject()).getStoreId()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  84 */     ItemPricesDAO dao = getNewItemPriceDAO(argMetaData.getIsFullReload(), ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/*  85 */     dao.setExternalId(fields[3]);
/*  86 */     dao.setExternalSystem(getExternalSystem());
/*  87 */     dao.setItemId(fields[4]);
/*  88 */     dao.setEffectiveDate(parseRPMDate(fields[5]));
/*  89 */     dao.setPrice(new BigDecimal(fields[6]));
/*  90 */     dao.setPricingQuantity(BigDecimal.ONE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     Date effectiveDate = parseRPMDate(fields[5]);
/*  97 */     long effectiveDateMiliSeconds = effectiveDate.getTime();
/*  98 */     Map<String, Object> parms = new HashMap<>(4);
/*  99 */     parms.put("argExpirationDate", new Date(--effectiveDateMiliSeconds));
/* 100 */     parms.put("argEffectiveDate", effectiveDate);
/* 101 */     parms.put("argLevelCode", "STORE");
/* 102 */     parms.put("argLevelValue", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/* 103 */     parms.put("argItemId", fields[4]);
/* 104 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 105 */     persistables.add(new QueryRequest("CLEARANCE_RESET_ITEM_PRICE_EVENT", parms));
/* 106 */     dao.setItemPricePropertyCode(PriceTypes.REGULAR_PRICE.name());
/*     */ 
/*     */     
/* 109 */     dao.setItemPricePropertyCode(PriceTypes.CLEARANCE_PRICE.name());
/*     */     
/* 111 */     persistables.add(dao);
/*     */     
/* 113 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateDetail(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 123 */     validateCommonDetail(argMetaData, argLine);
/*     */     
/* 125 */     if (StringUtils.isEmpty(argLine.getFields()[6]))
/* 126 */       throw new DataFileException(buildTransformationMessage("Missing Selling Retail", argMetaData, argLine)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\ClearancePriceTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */