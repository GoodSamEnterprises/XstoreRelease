/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
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
/*     */ public class StoreAddressTransformer
/*     */   extends AbstractMOMTransformer
/*     */ {
/*  43 */   private static final Logger _logger = Logger.getLogger(StoreAddressTransformer.class);
/*     */   
/*     */   private static final int FIELD_INDEX_FAMILY = 0;
/*     */   
/*     */   private static final int FIELD_INDEX_ACTION = 1;
/*     */   
/*     */   private static final int FIELD_INDEX_STORE_ID = 2;
/*     */   
/*     */   private static final int FIELD_INDEX_ADDRESS_TYPE = 3;
/*     */   
/*     */   private static final int FIELD_INDEX_PRIMARY_ADDRESS_INDICATOR = 5;
/*     */   
/*     */   private static final int FIELD_INDEX_ADDRESS_1 = 6;
/*     */   
/*     */   private static final int FIELD_INDEX_ADDRESS_2 = 7;
/*     */   
/*     */   private static final int FIELD_INDEX_ADDRESS_3 = 8;
/*     */   
/*     */   private static final int FIELD_INDEX_CITY = 9;
/*     */   
/*     */   private static final int FIELD_INDEX_STATE = 11;
/*     */   
/*     */   private static final int FIELD_INDEX_COUNTRY = 12;
/*     */   
/*     */   private static final int FIELD_INDEX_POSTAL_CODE = 13;
/*     */   
/*     */   private String _addrType;
/*     */ 
/*     */   
/*     */   public String getAddrType() {
/*  73 */     return this._addrType;
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
/*     */   public List<IPersistable> purgeData(DataFileMetaData<MOMFileConfiguration> argMetaData) throws DataFileException {
/*  86 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/*  88 */     Map<String, Object> parms = new HashMap<>(3);
/*  89 */     parms.put("argUpdateUserId", "DATALOADER");
/*  90 */     parms.put("argUpdateDate", new Date());
/*  91 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/*  92 */     persistables.add(new QueryRequest("UPDATE_ALL_STORE_ADDRESS_TO_NULL", parms));
/*     */     
/*  94 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddrType(String argAddrType) {
/* 104 */     this._addrType = argAddrType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IPersistable> transform(DataFileMetaData<MOMFileConfiguration> argMetaData, MOMUnit argUnit) throws DataFileException {
/* 112 */     if (_logger.isDebugEnabled()) {
/* 113 */       _logger.debug(((MOMFileLine)argUnit.getData().get(0)).getFileLine());
/*     */     }
/*     */     
/* 116 */     List<IPersistable> persistables = new ArrayList<>(1);
/*     */     
/* 118 */     MOMFileLine line = argUnit.getData().get(0);
/* 119 */     validate(argMetaData, line);
/*     */ 
/*     */     
/* 122 */     if (isPrimaryStoreAddress(line)) {
/* 123 */       QueryRequest queryRequest = null;
/* 124 */       long rtlLocId = Long.parseLong(line.getFields()[2]);
/*     */ 
/*     */       
/* 127 */       switch (line.getFields()[1]) {
/*     */         case "FULL":
/* 129 */           if (!argMetaData.getIsFullReload()) {
/* 130 */             throw new DataFileException(buildTransformationMessage("Unsupported Record Type for 'Full' file.", argMetaData, line));
/*     */           }
/*     */         
/*     */         case "STOREDTLCRE":
/*     */         case "STOREDTLMOD":
/* 135 */           queryRequest = getUpdateStoreAddressQueryRequest(line, rtlLocId);
/*     */           break;
/*     */         case "STOREDTLDEL":
/* 138 */           queryRequest = getUpdateStoreAddressQueryRequest(null, rtlLocId);
/*     */           break;
/*     */         
/*     */         default:
/* 142 */           throw new DataFileException(buildTransformationMessage("Unsupported Record Type.", argMetaData, line));
/*     */       } 
/*     */       
/* 145 */       persistables.add(queryRequest);
/*     */     } 
/* 147 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isPrimaryStoreAddress(MOMFileLine argLine) {
/* 157 */     String[] fields = argLine.getFields();
/* 158 */     return (getAddrType().equals(fields[3]) && "Y"
/* 159 */       .equals(fields[5]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private QueryRequest getUpdateStoreAddressQueryRequest(MOMFileLine argLine, long argRtlLocId) {
/* 168 */     Map<String, Object> parms = new HashMap<>(11);
/* 169 */     if (argLine == null) {
/*     */       
/* 171 */       parms.put("argAddress1", null);
/* 172 */       parms.put("argAddress2", null);
/* 173 */       parms.put("argAddress3", null);
/* 174 */       parms.put("argCity", null);
/* 175 */       parms.put("argState", null);
/* 176 */       parms.put("argCountry", null);
/* 177 */       parms.put("argPostalCode", null);
/*     */     } else {
/*     */       
/* 180 */       parms.put("argAddress1", argLine.getFields()[6]);
/* 181 */       parms.put("argAddress2", 
/* 182 */           StringUtils.isEmpty(argLine.getFields()[7]) ? null : argLine
/* 183 */           .getFields()[7]);
/* 184 */       parms.put("argAddress3", 
/* 185 */           StringUtils.isEmpty(argLine.getFields()[8]) ? null : argLine
/* 186 */           .getFields()[8]);
/* 187 */       parms.put("argCity", argLine.getFields()[9]);
/* 188 */       parms.put("argState", StringUtils.isEmpty(argLine.getFields()[11]) ? null : argLine
/* 189 */           .getFields()[11]);
/* 190 */       parms.put("argCountry", argLine.getFields()[12]);
/* 191 */       parms.put("argPostalCode", 
/* 192 */           StringUtils.isEmpty(argLine.getFields()[13]) ? null : argLine
/* 193 */           .getFields()[13]);
/*     */     } 
/* 195 */     parms.put("argRtlLocId", Long.valueOf(argRtlLocId));
/* 196 */     parms.put("argUpdateDate", new Date());
/* 197 */     parms.put("argUpdateUserId", "DATALOADER");
/* 198 */     parms.put("argOrganizationId", Long.valueOf(Long.parseLong(System.getProperty("dtv.location.organizationId"))));
/* 199 */     return new QueryRequest("UPDATE_STORE_ADDRESS", parms);
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
/* 210 */     String[] fields = argLine.getFields();
/*     */     
/* 212 */     if (fields.length != 19) {
/* 213 */       throw new DataFileException(buildTransformationMessage("Wrong number of fields", argMetaData, argLine));
/*     */     }
/* 215 */     if (StringUtils.isEmpty(fields[0])) {
/* 216 */       throw new DataFileException(buildTransformationMessage("Missing Family", argMetaData, argLine));
/*     */     }
/* 218 */     if (StringUtils.isEmpty(fields[2])) {
/* 219 */       throw new DataFileException(buildTransformationMessage("Missing StoreId", argMetaData, argLine));
/*     */     }
/* 221 */     if (StringUtils.isEmpty(fields[3])) {
/* 222 */       throw new DataFileException(buildTransformationMessage("Missing AddrType", argMetaData, argLine));
/*     */     }
/* 224 */     if (StringUtils.isEmpty(fields[5])) {
/* 225 */       throw new DataFileException(buildTransformationMessage("Missing PrimaryAddrInd", argMetaData, argLine));
/*     */     }
/*     */     
/* 228 */     if (!"STOREDTLDEL".equals(argLine.getFields()[1])) {
/* 229 */       if (StringUtils.isEmpty(fields[6])) {
/* 230 */         throw new DataFileException(buildTransformationMessage("Missing Add1", argMetaData, argLine));
/*     */       }
/* 232 */       if (StringUtils.isEmpty(fields[9])) {
/* 233 */         throw new DataFileException(buildTransformationMessage("Missing City", argMetaData, argLine));
/*     */       }
/* 235 */       if (StringUtils.isEmpty(fields[12]))
/* 236 */         throw new DataFileException(buildTransformationMessage("Missing Country", argMetaData, argLine)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\StoreAddressTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */