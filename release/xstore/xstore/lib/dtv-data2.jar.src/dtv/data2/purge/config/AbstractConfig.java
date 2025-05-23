/*     */ package dtv.data2.purge.config;
/*     */ 
/*     */ import dtv.data2.purge.PurgeMetaData;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ public abstract class AbstractConfig
/*     */   extends AbstractParentConfig
/*     */   implements IPurgeConfig
/*     */ {
/*  29 */   private static final String CONFIG_NAME = normalize("Name");
/*  30 */   private static final String CONFIG_ORDER = normalize("Order");
/*  31 */   private static final String CONFIG_ENABLED = normalize("Enabled");
/*     */   private static final long serialVersionUID = 1L;
/*  33 */   private static final Logger _logger = Logger.getLogger(AbstractConfig.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String createLogTag(Object... argElements) {
/*  43 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  45 */     if (argElements != null && argElements.length > 0) {
/*  46 */       for (int i = 0; i < argElements.length - 1; i++) {
/*  47 */         sb.append(argElements[i]);
/*  48 */         sb.append("::");
/*     */       } 
/*  50 */       sb.append(argElements[argElements.length - 1]);
/*     */     } 
/*  52 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void log(String argMessage, boolean argError) {
/*  63 */     if (!StringUtils.isEmpty(argMessage)) {
/*  64 */       if (argError) {
/*  65 */         _logger.error(argMessage);
/*     */       } else {
/*     */         
/*  68 */         _logger.info(argMessage);
/*     */       } 
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
/*     */   protected static String normalize(String argValue) {
/*  81 */     return (argValue == null) ? null : argValue.trim().toUpperCase();
/*     */   }
/*     */   
/*  84 */   private final Map<String, IConfigObject> _parameters = new HashMap<>();
/*     */   
/*     */   private String _name;
/*     */   
/*     */   private int _order;
/*     */   
/*     */   private boolean _enabled;
/*     */ 
/*     */   
/*     */   public AbstractConfig() {
/*  94 */     this(null, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractConfig(int argOrder) {
/* 102 */     this(null, argOrder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractConfig(String argName) {
/* 110 */     this(argName, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractConfig(String argName, int argOrder) {
/* 121 */     this._name = argName;
/* 122 */     this._order = (argOrder < 0) ? Integer.MAX_VALUE : argOrder;
/* 123 */     this._enabled = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final PurgeMetaData call() throws Exception {
/* 131 */     PurgeMetaData purgeData = null;
/*     */     
/* 133 */     if (!isEnabled()) {
/* 134 */       purgeData = PurgeMetaData.makeSuccess(0, 0L);
/* 135 */       log(getDisabledLogMessage(purgeData), false);
/*     */     } else {
/*     */       
/* 138 */       log(getStartLogMessage(), false);
/*     */ 
/*     */       
/*     */       try {
/* 142 */         purgeData = callImpl();
/* 143 */         log(getSuccessLogMessage(purgeData), false);
/*     */       }
/* 145 */       catch (Exception ex) {
/* 146 */         purgeData = PurgeMetaData.makeFailure(ex);
/* 147 */         log(getFailureLogMessage(purgeData), true);
/*     */       } 
/*     */     } 
/* 150 */     return purgeData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(IPurgeConfig argOther) {
/* 158 */     return getOrder() - argOther.getOrder();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/* 164 */     if (argObj == this) {
/* 165 */       return true;
/*     */     }
/* 167 */     if (!(argObj instanceof AbstractConfig)) {
/* 168 */       return false;
/*     */     }
/* 170 */     AbstractConfig other = (AbstractConfig)argObj;
/* 171 */     return (new EqualsBuilder()).append(getName(), other.getName()).append(getOrder(), other.getOrder())
/* 172 */       .append(getParameters(), other.getParameters()).isEquals();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 178 */     return createLogTag(new Object[] { Integer.valueOf(getOrder()), getName() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 184 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOrder() {
/* 190 */     return this._order;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IConfigObject getParameterValue(String argParamName) {
/* 196 */     return this._parameters.get(normalize(argParamName));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 202 */     return (new HashCodeBuilder(17, 37)).append(getName()).append(getOrder()).append(getParameters())
/* 203 */       .toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 209 */     return this._enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 215 */     String key = normalize(argKey);
/*     */     
/* 217 */     if (CONFIG_NAME.equals(key)) {
/* 218 */       this._name = argValue.toString();
/*     */     }
/* 220 */     else if (CONFIG_ORDER.equals(key)) {
/* 221 */       int configOrder = ConfigUtils.toInt(argValue);
/* 222 */       this._order = (configOrder < 0) ? Integer.MAX_VALUE : configOrder;
/*     */     }
/* 224 */     else if (CONFIG_ENABLED.equals(key)) {
/* 225 */       this._enabled = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 227 */     else if (argValue instanceof ParameterConfig) {
/* 228 */       setParameter((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/* 231 */       setParameter(new ParameterConfig(argKey, argValue));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabled(boolean argEnabled) {
/* 238 */     this._enabled = argEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setParameter(ParameterConfig argParam) {
/* 245 */     ParameterConfig actualParam = handleParameter(argParam);
/*     */ 
/*     */     
/* 248 */     if (actualParam != null) {
/* 249 */       this._parameters.put(actualParam.getName(), actualParam.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 256 */     return (new ToStringBuilder(this))
/* 257 */       .append("name", getName())
/* 258 */       .append("priority", getOrder())
/* 259 */       .append("parameters", getParameters())
/* 260 */       .appendSuper(super.toString()).toString();
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
/*     */   protected String getDisabledLogMessage(PurgeMetaData argPurgeData) {
/* 278 */     StringBuilder sb = new StringBuilder(StringUtils.fill(" ", 8));
/* 279 */     sb.append("[-----]");
/* 280 */     sb.append(": purge disabled [");
/* 281 */     sb.append(getDescription() + "]");
/*     */     
/* 283 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getFailureLogMessage(PurgeMetaData argPurgeData) {
/* 293 */     return "Purge FAILED [" + this + "]:" + argPurgeData.getPurgeError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<? extends String, ? extends IConfigObject> getParameters() {
/* 303 */     return this._parameters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getStartLogMessage() {
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSuccessLogMessage(PurgeMetaData argPurgeData) {
/* 323 */     StringBuilder sb = new StringBuilder(StringUtils.fill(" ", 8));
/* 324 */     sb.append("[" + argPurgeData.getRecordsPurged());
/* 325 */     sb.append(" @ ");
/* 326 */     sb.append(argPurgeData.getPurgeTime() + " ms]");
/* 327 */     sb.append(": purge sucessful [");
/* 328 */     sb.append(getDescription() + "]");
/*     */     
/* 330 */     return sb.toString();
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
/*     */   protected ParameterConfig handleParameter(ParameterConfig argParam) {
/* 343 */     return argParam;
/*     */   }
/*     */   
/*     */   protected abstract PurgeMetaData callImpl() throws Exception;
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\AbstractConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */