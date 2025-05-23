/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.BigDecimalConfig;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.EncryptedStringConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import dtv.util.config.ListConfig;
/*     */ import dtv.util.config.LongConfig;
/*     */ import dtv.util.config.MapConfig;
/*     */ import dtv.util.config.MapEntryConfig;
/*     */ import dtv.util.config.TimeConfig;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.time.LocalTime;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SystemConfigHelper extends ConfigHelper<IConfigObject> {
/*  34 */   private static final Logger logger_ = Logger.getLogger(SystemConfigHelper.class); public static final String CONFIG_FILE_NAME = "SystemConfig";
/*     */   public static final String KEY_SEPARATOR = "---";
/*  36 */   protected final Map<String, IConfigObject> configTable_ = new HashMap<>();
/*     */   
/*  38 */   private final Map<String, IConfigObject> settingMap_ = new AbstractMap<String, IConfigObject>()
/*     */     {
/*     */       public Set<Map.Entry<String, IConfigObject>> entrySet() {
/*  41 */         return SystemConfigHelper.this.configTable_.entrySet();
/*     */       }
/*     */     };
/*     */   
/*     */   private final boolean _preserveCaseSensitiveConfigPathKeys;
/*     */   
/*     */   public SystemConfigHelper() {
/*  48 */     this(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SystemConfigHelper(boolean argPreserveCaseSensitiveConfigPathKeys) {
/*  53 */     this._preserveCaseSensitiveConfigPathKeys = argPreserveCaseSensitiveConfigPathKeys;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(String[] argKeys) {
/*  63 */     return getBigDecimal(argKeys, NumberUtils.ZERO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal(String[] argKeys, BigDecimal argDefault) {
/*  74 */     BigDecimal result = argDefault;
/*     */     
/*     */     try {
/*  77 */       Object config = getObject(argKeys);
/*  78 */       if (config == null) {
/*  79 */         logger_.error("The key value is null for " + dumpKeys(argKeys), new Throwable("STACK TRACE"));
/*     */       }
/*  81 */       else if (config instanceof BigDecimalConfig) {
/*  82 */         result = ((BigDecimalConfig)config).getBigDecimal();
/*     */       } else {
/*     */         
/*  85 */         logger_.error("Invalid type configured for " + dumpKeys(argKeys), new Throwable("STACK TRACE"));
/*     */       }
/*     */     
/*  88 */     } catch (Exception ex) {
/*  89 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/*  91 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String[] argKeys) {
/* 102 */     return getBoolean(argKeys, false);
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
/*     */   public boolean getBoolean(String[] argKeys, boolean defaultValue) {
/* 114 */     boolean result = defaultValue;
/*     */     
/*     */     try {
/* 117 */       Object config = getObject(argKeys);
/* 118 */       if (config == null) {
/* 119 */         logger_.info("The key value is null for " + dumpKeys(argKeys));
/*     */       }
/* 121 */       else if (config instanceof BooleanConfig) {
/* 122 */         result = ((BooleanConfig)config).getBoolean().booleanValue();
/*     */       } else {
/*     */         
/* 125 */         result = ConfigUtils.asBool(config.toString(), defaultValue);
/*     */       }
/*     */     
/* 128 */     } catch (Exception ex) {
/* 129 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/* 131 */     return result;
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
/*     */   @Deprecated
/*     */   public Map<String, IConfigObject> getConfigDataMap() {
/* 145 */     return this.configTable_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getConfiguredClass(String[] argKeys) {
/* 155 */     Class result = null;
/*     */     
/*     */     try {
/* 158 */       Object config = getObject(argKeys);
/* 159 */       if (config == null) {
/* 160 */         logger_.error("The key value is null for " + dumpKeys(argKeys), new Throwable("STACK TRACE"));
/*     */       }
/* 162 */       else if (config instanceof ClassConfig) {
/* 163 */         result = ((ClassConfig)config).getValue();
/*     */       } else {
/*     */         
/* 166 */         logger_.error("Invalid type configured for " + dumpKeys(argKeys), new Throwable("STACK TRACE"));
/*     */       }
/*     */     
/* 169 */     } catch (Exception ex) {
/* 170 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/* 172 */     return result;
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
/*     */   public String getEncryptedString(String[] argKeys) {
/* 184 */     return decrypt(getString(argKeys), (String)null);
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
/*     */   public String getEncryptedString(String[] argKeys, String argDefault) {
/* 198 */     return decrypt(getString(argKeys), argDefault);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFormattable(String[] argKeys) {
/* 208 */     IFormattable result = IFormattable.EMPTY;
/*     */     try {
/* 210 */       Object o = getObject(argKeys);
/* 211 */       if (o instanceof IFormattableConfig) {
/* 212 */         result = ((IFormattableConfig)o).getFormattable();
/*     */       } else {
/*     */         
/* 215 */         result = FormattableFactory.getInstance().getLiteral(o.toString());
/*     */       }
/*     */     
/* 218 */     } catch (Exception ex) {
/* 219 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/* 221 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInt(String[] argKeys) {
/* 231 */     int result = 0;
/*     */     try {
/* 233 */       Object config = getObject(argKeys);
/* 234 */       if (config == null) {
/* 235 */         logger_.error("The key value is null for " + dumpKeys(argKeys));
/*     */       }
/* 237 */       else if (config instanceof IntegerConfig) {
/* 238 */         result = ((IntegerConfig)config).getInteger().intValue();
/*     */       } else {
/*     */         
/* 241 */         result = ConfigUtils.asInt(config.toString());
/*     */       }
/*     */     
/* 244 */     } catch (Exception ex) {
/* 245 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/* 247 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MapEntryConfig> getList(String[] argKeys) {
/*     */     try {
/* 259 */       List<MapEntryConfig> list = ((ListConfig)getObject(argKeys)).getList();
/* 260 */       return list;
/*     */     }
/* 262 */     catch (Exception ex) {
/* 263 */       logger_.error("Exception getting key value for " + dumpKeys(argKeys), ex);
/*     */       
/* 265 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLong(String[] argKeys) {
/* 275 */     long result = 0L;
/*     */     try {
/* 277 */       Object config = getObject(argKeys);
/* 278 */       if (config == null) {
/* 279 */         logger_.error("The key value is null for " + dumpKeys(argKeys));
/*     */       }
/* 281 */       else if (config instanceof LongConfig) {
/* 282 */         result = ((LongConfig)config).getLong().longValue();
/*     */       }
/* 284 */       else if (config instanceof IntegerConfig) {
/* 285 */         result = ((IntegerConfig)config).getInteger().longValue();
/*     */       } else {
/*     */         
/* 288 */         result = ConfigUtils.toLong(config.toString()).longValue();
/*     */       }
/*     */     
/* 291 */     } catch (Exception ex) {
/* 292 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/* 294 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Object, IConfigObject> getMap(String[] argKeys) {
/*     */     try {
/* 306 */       return ((MapConfig)getObject(argKeys)).getMap();
/*     */     }
/* 308 */     catch (Exception ex) {
/* 309 */       logger_.error("Exception getting key value for " + dumpKeys(argKeys), ex);
/*     */       
/* 311 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getObject(String[] argKeys) {
/* 321 */     return getObject(StringUtils.join((Object[])argKeys, "---"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, IConfigObject> getSettingMap() {
/* 329 */     return this.settingMap_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String[] argKeys) {
/* 340 */     return getString(StringUtils.join((Object[])argKeys, "---"));
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
/*     */   public String getString(String[] argKeys, String argDefault) {
/* 352 */     String configValue = getString(argKeys);
/* 353 */     if (configValue == null) {
/* 354 */       return argDefault;
/*     */     }
/* 356 */     return configValue;
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
/*     */   public List<String> getStringList(String[] argKeys) {
/*     */     try {
/* 369 */       return Arrays.asList(getString(argKeys).split(","));
/*     */     }
/* 371 */     catch (Exception ex) {
/* 372 */       logger_.error("Exception getting key value for " + dumpKeys(argKeys), ex);
/*     */       
/* 374 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LocalTime getTime(String[] argKeys) {
/* 384 */     LocalTime result = LocalTime.MIN;
/*     */     try {
/* 386 */       Object config = getObject(argKeys);
/* 387 */       if (config == null) {
/* 388 */         logger_.error("The key value is null for " + dumpKeys(argKeys));
/*     */       }
/* 390 */       else if (config instanceof TimeConfig) {
/* 391 */         result = ((TimeConfig)config).getTime();
/*     */       } else {
/*     */         
/* 394 */         result = ConfigUtils.asTime(config.toString());
/*     */       }
/*     */     
/* 397 */     } catch (Exception ex) {
/* 398 */       logger_.error("Exception in getting key value for " + dumpKeys(argKeys), ex);
/*     */     } 
/* 400 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/* 406 */     super.initializeImpl();
/* 407 */     this.rootConfig_ = null;
/* 408 */     this.parentConfigs_ = null;
/* 409 */     this.parentHash_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String decrypt(String argValue, String argDefault) {
/*     */     String result;
/* 421 */     if (StringUtils.isEmpty(argValue)) {
/* 422 */       result = argDefault;
/*     */     }
/*     */     else {
/*     */       
/* 426 */       EncryptedStringConfig config = new EncryptedStringConfig(argValue, "config");
/* 427 */       result = config.toString();
/*     */     } 
/* 429 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/* 437 */     return "SystemConfig";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 443 */     if ("default".equalsIgnoreCase(dtype)) {
/* 444 */       return null;
/*     */     }
/*     */     
/* 447 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getObject(String argKey) {
/* 458 */     return this.configTable_.get(this._preserveCaseSensitiveConfigPathKeys ? argKey : argKey.toUpperCase());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getString(List<String> argKeys) {
/* 469 */     return getString(argKeys.<String>toArray(new String[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getString(String argKey) {
/* 479 */     Object o = getObject(argKey);
/* 480 */     if (o == null) {
/* 481 */       return null;
/*     */     }
/* 483 */     return o.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadDocument(InputStream argInputStream) throws IOException {
/* 491 */     (new SaxSystemConfigLoader(this._preserveCaseSensitiveConfigPathKeys)).loadDocument(this, this.currentFile_, argInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   void addLeaf(String argKey, IConfigObject argConfig) {
/* 496 */     if (argConfig != null) {
/* 497 */       this.configTable_.put(argKey, argConfig);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String dumpKeys(String[] argKeys) {
/* 506 */     if (argKeys == null || argKeys.length < 1) {
/* 507 */       return "";
/*     */     }
/* 509 */     StringBuilder result = new StringBuilder(91);
/* 510 */     boolean first = true;
/* 511 */     for (String key : argKeys) {
/* 512 */       if (first) {
/* 513 */         first = false;
/*     */       } else {
/*     */         
/* 516 */         result.append(", ");
/*     */       } 
/* 518 */       result.append(key);
/*     */     } 
/* 520 */     result.append(']');
/* 521 */     return result.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\SystemConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */