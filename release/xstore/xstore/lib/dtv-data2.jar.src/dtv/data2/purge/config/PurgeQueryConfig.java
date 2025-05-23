/*     */ package dtv.data2.purge.config;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.purge.PurgeMetaData;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.DateConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.util.Date;
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
/*     */ public class PurgeQueryConfig
/*     */   extends AbstractConfig
/*     */ {
/*     */   public static final String CONFIG_NAME = "Query";
/*  50 */   private static final String CONFIG_AGE = normalize("Age");
/*  51 */   private static final String CONFIG_STATUS = normalize("Status");
/*  52 */   private static final String CONFIG_TYPE = normalize("Type");
/*  53 */   private static final String CONFIG_QUERY_KEY = normalize("Key");
/*  54 */   private static final String CONFIG_TABLE = normalize("Table");
/*     */   
/*     */   private static final String PARAM_DATE = "argDate";
/*     */   
/*     */   private static final String PARAM_STATUS = "argStatus";
/*     */   
/*     */   private static final String PARAM_TYPE = "argType";
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   protected static Date getPastDate(int argAgeInDays) {
/*  67 */     return (Date)new DtvDate(DateUtils.dateAdd(CalendarField.DAY, argAgeInDays * -1, System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   private String _purgeQueryKey = null;
/*     */   
/*  75 */   private String _purgeTableName = null;
/*     */ 
/*     */   
/*     */   public PurgeQueryConfig() {
/*  79 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  85 */     String description = super.getDescription();
/*  86 */     if (!StringUtils.isEmpty(this._purgeQueryKey)) {
/*  87 */       description = description + " <" + this._purgeQueryKey + ">";
/*     */     }
/*  89 */     return description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PurgeMetaData callImpl() throws Exception {
/*  98 */     long time = System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */     
/* 102 */     QueryKey queryKey = new QueryKey(getPurgeQueryKey(), Object[].class);
/* 103 */     int recordsPurged = DataFactory.executeQuery((IQueryKey)queryKey, createQueryArguments());
/*     */ 
/*     */     
/* 106 */     PurgeMetaData purgeData = PurgeMetaData.makeSuccess(recordsPurged, System.currentTimeMillis() - time);
/*     */ 
/*     */ 
/*     */     
/* 110 */     purgeData.setTablesPurged((recordsPurged > 0) ? 1 : 0);
/* 111 */     purgeData.setTablesTargeted(1);
/*     */     
/* 113 */     return purgeData;
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
/*     */   protected Map<String, Object> createQueryArguments() {
/* 125 */     Map<String, Object> args = new HashMap<>();
/*     */ 
/*     */     
/* 128 */     args.put("argOrganizationId", this._persistenceDefaults.getOrganizationId());
/* 129 */     args.put("argRetailLocationId", this._persistenceDefaults.getRetailLocationId());
/*     */ 
/*     */     
/* 132 */     for (Map.Entry<? extends String, ? extends IConfigObject> param : getParameters().entrySet()) {
/* 133 */       args.put(param.getKey(), getQueryArgument(param.getValue()));
/*     */     }
/*     */ 
/*     */     
/* 137 */     args.put("DB_TABLE", getPurgeTableName());
/*     */     
/* 139 */     return args;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getPurgeQueryKey() {
/* 149 */     return (this._purgeQueryKey == null) ? getName() : this._purgeQueryKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getPurgeTableName() {
/* 159 */     return (this._purgeTableName == null) ? getName() : this._purgeTableName;
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
/*     */   protected Object getQueryArgument(IConfigObject argParam) {
/* 174 */     return (argParam instanceof IReflectionParameterCapable) ? ((IReflectionParameterCapable)argParam)
/* 175 */       .getParamValue() : argParam
/* 176 */       .toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ParameterConfig handleParameter(ParameterConfig argParam) {
/* 182 */     ParameterConfig param = argParam;
/* 183 */     String paramName = normalize(argParam.getName());
/*     */     
/* 185 */     if (CONFIG_AGE.equals(paramName)) {
/*     */ 
/*     */       
/* 188 */       int ageInDays = ConfigUtils.toInt(argParam.getValue());
/* 189 */       param = new ParameterConfig("argDate", (IConfigObject)new DateConfig(getPastDate(ageInDays)));
/*     */     }
/* 191 */     else if (CONFIG_STATUS.equals(paramName)) {
/*     */       
/* 193 */       param = new ParameterConfig("argStatus", argParam.getValue());
/*     */     }
/* 195 */     else if (CONFIG_TYPE.equals(paramName)) {
/*     */       
/* 197 */       param = new ParameterConfig("argType", argParam.getValue());
/*     */     }
/* 199 */     else if (CONFIG_QUERY_KEY.equals(paramName)) {
/*     */       
/* 201 */       this._purgeQueryKey = argParam.getValue().toString();
/*     */     }
/* 203 */     else if (CONFIG_TABLE.equals(paramName)) {
/*     */       
/* 205 */       this._purgeTableName = argParam.getValue().toString();
/*     */     } 
/* 207 */     return param;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\PurgeQueryConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */