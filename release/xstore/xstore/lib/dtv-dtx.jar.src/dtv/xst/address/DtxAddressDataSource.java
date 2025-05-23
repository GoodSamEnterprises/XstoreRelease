/*     */ package dtv.xst.address;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.address.CountryCache;
/*     */ import dtv.util.address.IPostalCode;
/*     */ import dtv.util.address.PostalCode;
/*     */ import dtv.util.address.StateCache;
/*     */ import dtv.util.address.datasource.AddressDataSourceException;
/*     */ import dtv.util.address.datasource.IAddressDataSource;
/*     */ import dtv.xst.dao.com.AddressPostalCodeId;
/*     */ import dtv.xst.dao.com.IAddressCountry;
/*     */ import dtv.xst.dao.com.IAddressPostalCode;
/*     */ import dtv.xst.dao.com.IAddressState;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class DtxAddressDataSource
/*     */   implements IAddressDataSource
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(DtxAddressDataSource.class);
/*     */   
/*     */   private static final String POSTAL_CODE_MODE_GROUP = "PostalCode";
/*     */   
/*     */   private static final String STATE_CODE_MODE_GROUP = "State";
/*     */   
/*     */   private static final String COUNTRY_CODE_MODE_GROUP = "Country";
/*  38 */   private static final IQueryKey<IAddressCountry> COUNTRY_QUERY = (IQueryKey<IAddressCountry>)new QueryKey("ADDRESS_COUNTRIES", IAddressCountry.class);
/*     */   
/*  40 */   private static final IQueryKey<IAddressState> STATE_QUERY = (IQueryKey<IAddressState>)new QueryKey("ADDRESS_STATES", IAddressState.class);
/*     */   
/*  42 */   private static final IQueryKey<AddressModeResult> ADDRESS_MODE_QUERY = (IQueryKey<AddressModeResult>)new QueryKey("ADDRESS_MODES", AddressModeResult.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, List<String>> modes_;
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxAddressDataSource() {
/*  51 */     initializeModes();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClosestActiveModeForField(String argField, String argAddressMode) {
/*  57 */     switch (argField) {
/*     */       case "postalCode":
/*  59 */         return getClosestActiveMode("PostalCode", argAddressMode);
/*     */       case "country":
/*  61 */         return getClosestActiveMode("Country", argAddressMode);
/*     */       case "state":
/*  63 */         return getClosestActiveMode("State", argAddressMode);
/*     */     } 
/*  65 */     return "DEFAULT";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CountryCache getCountries(String argAddressMode) throws AddressDataSourceException {
/*     */     IQueryResultList iQueryResultList;
/*  74 */     List<IAddressCountry> results = Collections.emptyList();
/*  75 */     Map<String, Object> params = new HashMap<>();
/*  76 */     params.put("argAddressMode", argAddressMode);
/*     */     try {
/*  78 */       iQueryResultList = DataFactory.getObjectByQuery(COUNTRY_QUERY, params);
/*     */     }
/*  80 */     catch (ObjectNotFoundException ex) {
/*  81 */       logger_.warn("Unable to find any countries with the mode" + argAddressMode + ".");
/*     */     }
/*  83 */     catch (Exception ex) {
/*  84 */       throw new AddressDataSourceException(ex);
/*     */     } 
/*     */     
/*  87 */     CountryCache cache = new CountryCache();
/*  88 */     for (IAddressCountry code : iQueryResultList) {
/*  89 */       cache.addCountry(code.getCountryId(), code.getCountryName(), code.getPostalCodeMaxLength());
/*     */     }
/*  91 */     cache.completeLoad();
/*     */     
/*  93 */     return cache;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPostalCode getPostalCode(String argPostalCode, String argCountryId, String argAddressMode) throws AddressDataSourceException {
/*     */     PostalCode postalCode1;
/* 101 */     IPostalCode postalCode = null;
/*     */     
/* 103 */     AddressPostalCodeId postalId = new AddressPostalCodeId();
/* 104 */     postalId.setPostalCodeId(StringUtils.nonNull(argPostalCode).toUpperCase());
/* 105 */     postalId.setCountryId(StringUtils.nonNull(argCountryId));
/* 106 */     postalId.setAddressMode(argAddressMode);
/*     */     
/*     */     try {
/* 109 */       IAddressPostalCode postalCodeModel = (IAddressPostalCode)DataFactory.getObjectById((IObjectId)postalId);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 114 */       postalCode1 = new PostalCode(postalCodeModel.getCountryId(), postalCodeModel.getPostalCode(), postalCodeModel.getStateId(), postalCodeModel.getCityName());
/*     */     }
/* 116 */     catch (ObjectNotFoundException ex) {
/* 117 */       logger_.debug("Couldn't find postal code with id " + postalId);
/*     */     }
/* 119 */     catch (Exception ex) {
/* 120 */       throw new AddressDataSourceException(ex);
/*     */     } 
/* 122 */     return (IPostalCode)postalCode1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StateCache getStates(String argAddressMode) throws AddressDataSourceException {
/*     */     IQueryResultList iQueryResultList;
/* 130 */     List<IAddressState> results = Collections.emptyList();
/* 131 */     Map<String, Object> params = new HashMap<>();
/* 132 */     params.put("argAddressMode", argAddressMode);
/*     */     
/*     */     try {
/* 135 */       iQueryResultList = DataFactory.getObjectByQuery(STATE_QUERY, params);
/*     */     }
/* 137 */     catch (ObjectNotFoundException ex) {
/* 138 */       logger_.debug("Unable to find any states with the mode" + argAddressMode + ".");
/*     */     }
/* 140 */     catch (Exception ex) {
/* 141 */       throw new AddressDataSourceException(ex);
/*     */     } 
/*     */     
/* 144 */     StateCache cache = new StateCache();
/* 145 */     for (IAddressState code : iQueryResultList) {
/* 146 */       cache.addState(code.getCountryId(), code.getStateId(), code.getStateName());
/*     */     }
/* 148 */     cache.completeLoad();
/*     */     
/* 150 */     return cache;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getClosestActiveMode(String argAddressModeGroup, String argAddressMode) {
/* 161 */     String closestMode = "DEFAULT";
/*     */     
/* 163 */     if (this.modes_ == null) {
/* 164 */       initializeModes();
/*     */     }
/* 166 */     List<String> modeList = this.modes_.get(argAddressModeGroup);
/*     */     
/* 168 */     if (modeList != null && modeList.contains(argAddressMode)) {
/* 169 */       closestMode = argAddressMode;
/*     */     }
/* 171 */     return closestMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initializeModes() {
/*     */     IQueryResultList iQueryResultList;
/* 179 */     this.modes_ = new HashMap<>();
/*     */     
/* 181 */     List<AddressModeResult> results = Collections.emptyList();
/*     */     try {
/* 183 */       iQueryResultList = DataFactory.getObjectByQuery(ADDRESS_MODE_QUERY, new HashMap<>());
/*     */     }
/* 185 */     catch (ObjectNotFoundException ex) {
/* 186 */       logger_.debug("No available modes found for DtxAddressDataSource, using DEFAULT.");
/*     */       
/*     */       return;
/*     */     } 
/* 190 */     for (AddressModeResult mode : iQueryResultList) {
/* 191 */       List<String> modeList = this.modes_.get(mode.getCodeName());
/* 192 */       if (modeList == null) {
/* 193 */         modeList = new ArrayList<>();
/* 194 */         this.modes_.put(mode.getCodeName(), modeList);
/*     */       } 
/* 196 */       modeList.add(mode.getMode());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\address\DtxAddressDataSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */