/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.pos.common.PriceTypes;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.itm.impl.ItemPricesDAO;
/*     */ import java.math.BigDecimal;
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
/*     */ public class RegularPriceTransformer
/*     */   extends AbstractPriceTransformer
/*     */ {
/*     */   private static final int FIELD_INDEX_FDETL_SELLING_RETAIL = 7;
/*     */   private static final int FIELD_INDEX_FDETL_MULTIPRICE = 10;
/*  34 */   private static final Logger _logger = Logger.getLogger(RegularPriceTransformer.class);
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getExternalSystem() {
/*  39 */     return "RPM-REGPC";
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
/*     */   protected List<IPersistable> transformDetail(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/*  53 */     validateDetail(argMetaData, argLine);
/*     */     
/*  55 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/*  57 */     String[] fields = argLine.getFields();
/*  58 */     if ("MOD".equals(fields[2]))
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
/*  70 */       persistables
/*  71 */         .add(getDeletePriceByEventQueryRequest(fields[3], getExternalSystem(), fields[4], ((MOMFileConfiguration)argMetaData
/*  72 */             .getConfigObject()).getStoreId()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  77 */     ItemPricesDAO dao = getNewItemPriceDAO(argMetaData.getIsFullReload(), ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/*     */     
/*  79 */     dao.setPrice(new BigDecimal(fields[7]));
/*  80 */     if (Integer.parseInt(fields[10]) == 1)
/*     */     {
/*  82 */       _logger.warn(buildTransformationMessage("Multiunit price conversion is not supported", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  87 */     dao.setExternalId(fields[3]);
/*     */     
/*  89 */     dao.setExternalSystem(getExternalSystem());
/*     */ 
/*     */     
/*  92 */     dao.setItemId(fields[4]);
/*     */     
/*  94 */     dao.setEffectiveDate(parseRPMDate(fields[5]));
/*     */     
/*  96 */     dao.setPricingQuantity(BigDecimal.ONE);
/*     */     
/*  98 */     dao.setItemPricePropertyCode(PriceTypes.REGULAR_PRICE.name());
/*     */     
/* 100 */     persistables.add(dao);
/* 101 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateDetail(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 111 */     validateCommonDetail(argMetaData, argLine);
/*     */     
/* 113 */     if (StringUtils.isEmpty(argLine.getFields()[7]))
/* 114 */       throw new DataFileException(buildTransformationMessage("Missing Selling Retail", argMetaData, argLine)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\RegularPriceTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */