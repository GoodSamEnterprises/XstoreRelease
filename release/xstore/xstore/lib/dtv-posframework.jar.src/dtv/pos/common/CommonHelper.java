/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.util.CurrencyUtils;
/*     */ import dtv.util.ICode;
/*     */ import dtv.util.IKeyedValue;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Currency;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommonHelper
/*     */ {
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   private Currency _localCurrency;
/*     */   private String _microsRetailClientId;
/*     */   private String _baseXstoreRoot;
/*     */   
/*     */   public static void setParameter(Map<String, Object> argParams, String argKey, Object argValue) {
/*  36 */     if (argValue != null) {
/*  37 */       argParams.put(argKey, argValue);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAllStackTraces() {
/*  62 */     Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
/*  63 */     StringBuilder str = new StringBuilder(stackTraces.size() * 1024);
/*     */     
/*  65 */     for (Map.Entry<Thread, StackTraceElement[]> entry : stackTraces.entrySet()) {
/*  66 */       str.append(entry.getKey()).append("\n");
/*  67 */       for (StackTraceElement element : (StackTraceElement[])entry.getValue()) {
/*  68 */         str.append("  ").append(element).append("\n");
/*     */       }
/*  70 */       str.append("\n");
/*     */     } 
/*  72 */     return str.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrencyScale() {
/*  80 */     return this._localCurrency.getDefaultFractionDigits();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomerId() {
/*  88 */     return this._microsRetailClientId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Currency getLocalCurrency() {
/*  96 */     return this._localCurrency;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocalCurrencyId() {
/* 104 */     return this._persistenceDefaults.getCurrencyId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoundingMode getRoundingMethod() {
/* 112 */     return RoundingMode.HALF_UP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXstoreRoot() {
/* 120 */     String value = System.getProperty("user.dir", getXstoreBaseRoot());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     return value;
/*     */   }
/*     */   
/*     */   public void init() {
/* 130 */     this._microsRetailClientId = System.getProperty("dtv.CustomerId", "xyz");
/* 131 */     this._localCurrency = CurrencyUtils.getCurrency(getLocalCurrencyId());
/*     */     
/* 133 */     if (System.getProperty("java.home").startsWith("/")) {
/*     */       
/* 135 */       this._baseXstoreRoot = File.separator + "opt" + File.separator + "xstore";
/*     */     }
/*     */     else {
/*     */       
/* 139 */       this._baseXstoreRoot = "c:" + File.separator + "xstore";
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
/*     */   public boolean isAuthTrace() {
/* 153 */     return Boolean.getBoolean("dtv.auth.log.trace");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> makeParamMap(Collection<IKeyedValue<String, ?>> argFields) {
/* 162 */     return makeParamMap(argFields, new HashMap<>());
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
/*     */   public Map<String, Object> makeParamMap(Collection<IKeyedValue<String, ?>> argFields, Map<String, Object> params) {
/* 174 */     for (IKeyedValue<String, ?> field : argFields) {
/* 175 */       Object searchValue = getSearchValue(field.getValue());
/*     */       
/* 177 */       if (searchValue != null) {
/* 178 */         String fieldPrefix = (searchValue instanceof Collection) ? "@arg" : "arg";
/* 179 */         String fieldKey = (String)field.getKey();
/* 180 */         params.put(fieldPrefix + fieldKey.substring(0, 1).toUpperCase() + fieldKey.substring(1), searchValue);
/*     */       } 
/*     */     } 
/* 183 */     return params;
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
/*     */   public boolean putParam(Map<String, Object> argParams, String argKey, Object argValue) {
/* 198 */     boolean rejected = (argValue == null || (argValue instanceof String && StringUtils.isEmpty((String)argValue)));
/*     */     
/* 200 */     if (!rejected) {
/* 201 */       argParams.put(argKey, argValue);
/*     */     }
/* 203 */     return !rejected;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal roundCurrency(BigDecimal argAmount) {
/* 212 */     if (argAmount != null) {
/* 213 */       return argAmount.setScale(getCurrencyScale(), getRoundingMethod());
/*     */     }
/*     */     
/* 216 */     return argAmount;
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
/*     */   public <T> IQueryResultList<T> runQueryWrapResults(Collection<IKeyedValue<String, ?>> argFields, IQueryKey<T> argKey) {
/* 228 */     return runQueryWrapResults(argFields, argKey, new HashMap<>());
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
/*     */   public <T> IQueryResultList<T> runQueryWrapResults(Collection<IKeyedValue<String, ?>> argFields, IQueryKey<T> argKey, Map<String, Object> params) {
/* 242 */     return DataFactory.getObjectByQuery(argKey, makeParamMap(argFields, params));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getAllStackTracesImpl() {
/* 247 */     Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
/* 248 */     StringBuilder str = new StringBuilder(stackTraces.size() * 1024);
/*     */     
/* 250 */     for (Map.Entry<Thread, StackTraceElement[]> entry : stackTraces.entrySet()) {
/* 251 */       str.append(entry.getKey()).append("\n");
/* 252 */       for (StackTraceElement element : (StackTraceElement[])entry.getValue()) {
/* 253 */         str.append("  ").append(element).append("\n");
/*     */       }
/* 255 */       str.append("\n");
/*     */     } 
/* 257 */     return str.toString();
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
/*     */   protected Object getSearchValue(Object argFieldValue) {
/* 271 */     Object searchValue = argFieldValue;
/*     */     
/* 273 */     if (argFieldValue instanceof ICode) {
/* 274 */       searchValue = ((ICode)argFieldValue).getCode();
/*     */     }
/* 276 */     else if (argFieldValue instanceof Collection) {
/* 277 */       searchValue = new ArrayList();
/* 278 */       for (Object fieldElem : argFieldValue) {
/* 279 */         ((Collection<Object>)searchValue).add(getSearchValue(fieldElem));
/*     */       }
/*     */     }
/* 282 */     else if (argFieldValue instanceof String) {
/* 283 */       searchValue = ((String)argFieldValue).trim();
/*     */     } 
/* 285 */     return searchValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getXstoreBaseRoot() {
/* 295 */     return this._baseXstoreRoot;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\CommonHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */