/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class VATItemTransformer
/*     */   extends AbstractItemTransformer
/*     */ {
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   private static final int FIELD_INDEX_ACTION = 1;
/*     */   private static final int FIELD_INDEX_ITEM_ID = 2;
/*     */   private static final int FIELD_INDEX_VAT_REGION = 3;
/*     */   private static final int FIELD_INDEX_ACTIVE_DATE = 4;
/*     */   private static final int FIELD_INDEX_VAT_TYPE = 5;
/*     */   private static final int FIELD_INDEX_VAT_CODE = 6;
/*     */   
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  43 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */ 
/*     */     
/*  46 */     QueryRequest queryRequest = createQueryRequestForUpdateTaxGroupID((String)null, (String)null, "STORE", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/*  47 */     persistables.add(queryRequest);
/*     */     
/*  49 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/*  58 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */ 
/*     */     
/*  61 */     MOMFileLine line = argUnit.getData().get(0);
/*     */ 
/*     */     
/*  64 */     ActionCode actionCode = validate(argMetaData, line);
/*     */     
/*  66 */     switch (actionCode) {
/*     */       
/*     */       case FULL:
/*     */       case VATITEMCRE:
/*     */       case VATITEMMOD:
/*  71 */         if (!line.getFields()[5].equals("C")) {
/*     */           
/*  73 */           QueryRequest queryRequest = createQueryRequestForUpdateTaxGroupID(line.getFields()[6], line
/*  74 */               .getFields()[2], "STORE", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId());
/*  75 */           persistables.add(queryRequest);
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
/*  90 */         return persistables;case VATITEMDEL: if (!line.getFields()[5].equals("C")) { QueryRequest queryRequest = createQueryRequestForUpdateTaxGroupID((String)null, line.getFields()[2], "STORE", ((MOMFileConfiguration)argMetaData.getConfigObject()).getStoreId()); persistables.add(queryRequest); }  return persistables;
/*     */     } 
/*     */     throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ActionCode validate(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMFileLine argLine) {
/* 101 */     String[] fields = argLine.getFields();
/* 102 */     ActionCode actionCode = null;
/*     */     
/* 104 */     if (fields.length != 9) {
/* 105 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/*     */     
/* 108 */     if (!"VATITEM".equals(fields[0])) {
/* 109 */       throw new DataFileException(buildTransformationMessage("Family must be 'VAT'", argMetaData, argLine));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 114 */       actionCode = ActionCode.valueOf(argLine.getFields()[1]);
/*     */     }
/* 116 */     catch (Exception e) {
/* 117 */       throw new DataFileException(buildTransformationMessage("Invalid action code", argMetaData, argLine));
/*     */     } 
/*     */     
/* 120 */     if (StringUtils.isEmpty(fields[3])) {
/* 121 */       throw new DataFileException(buildTransformationMessage("Missing VAT region", argMetaData, argLine));
/*     */     }
/*     */     
/* 124 */     if (StringUtils.isEmpty(fields[4])) {
/* 125 */       throw new DataFileException(buildTransformationMessage("Missing VAT rate active date", argMetaData, argLine));
/*     */     }
/*     */     
/* 128 */     if (StringUtils.isEmpty(fields[2])) {
/* 129 */       throw new DataFileException(buildTransformationMessage("Missing VAT item id", argMetaData, argLine));
/*     */     }
/*     */     
/* 132 */     if (StringUtils.isEmpty(fields[5])) {
/* 133 */       throw new DataFileException(buildTransformationMessage("Missing VAT type", argMetaData, argLine));
/*     */     }
/*     */     
/* 136 */     if (StringUtils.isEmpty(fields[6])) {
/* 137 */       throw new DataFileException(buildTransformationMessage("Missing VAT code", argMetaData, argLine));
/*     */     }
/*     */     
/* 140 */     if (!StringUtils.isEmpty(fields[5]) || actionCode != ActionCode.VATITEMDEL)
/*     */     {
/* 142 */       if (!fields[5].equals("C") && !fields[5].equals("R") && 
/* 143 */         !fields[5].equals("B")) {
/* 144 */         throw new DataFileException(buildTransformationMessage("VAT type is invalid", argMetaData, argLine));
/*     */       }
/*     */     }
/*     */     
/* 148 */     return actionCode;
/*     */   }
/*     */   
/*     */   private enum ActionCode
/*     */   {
/* 153 */     FULL, VATITEMMOD, VATITEMCRE, VATITEMDEL;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\VATItemTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */