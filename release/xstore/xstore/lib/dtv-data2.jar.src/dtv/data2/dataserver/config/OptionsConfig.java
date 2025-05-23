/*     */ package dtv.data2.dataserver.config;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.ICascadableConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class OptionsConfig
/*     */   extends AbstractParentConfig
/*     */   implements ICascadableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private static final Logger _logger = Logger.getLogger(OptionsConfig.class);
/*     */   
/*     */   private static final String NAME_TAG = "Name";
/*     */   
/*     */   private static final String ENABLED_TAG = "Enabled";
/*     */   private static final String ADDRESS_TAG = "Address";
/*     */   private static final String PORT_TAG = "Port";
/*     */   private static final String CLOSE_MARKER_LOCATION_TAG = "CloseMarkerLocation";
/*     */   private static final String VERSION_LOCATION_TAG = "VersionLocation";
/*     */   private static final String PASSWORD_LOCATION_TAG = "PasswordLocation";
/*     */   private static final String UPDATES_PENDING_MARKER_TAG = "UpdatesPendingMarkerFile";
/*     */   private static final String APPLY_UPDATES_METHOD_NAME = "ApplyUpdatesMethodName";
/*     */   private String _name;
/*  37 */   private Boolean _enabled = null;
/*     */   
/*     */   private String _address;
/*     */   
/*     */   private Integer _port;
/*     */   private String _closeMarkerLocation;
/*     */   private String _updatesPendingMarkerFileName;
/*     */   private String _versionLocation;
/*     */   private String _passwordLocation;
/*     */   private String _applyUpdatesMethodName;
/*     */   
/*     */   public void cascadeValues(IConfigObject argSource) {
/*  49 */     if (!(argSource instanceof OptionsConfig)) {
/*  50 */       _logger.warn("The object [" + argSource
/*  51 */           .getClass().getName() + "] that was passed to cascadeValues is not a [" + 
/*  52 */           getClass().getName() + "]. No cascasing can be performed.");
/*     */       
/*     */       return;
/*     */     } 
/*  56 */     OptionsConfig source = (OptionsConfig)argSource;
/*     */     
/*  58 */     if (getEnabled() == null) {
/*  59 */       setEnabled(source.getEnabled());
/*     */     }
/*     */     
/*  62 */     if (StringUtils.isEmpty(getAddress())) {
/*  63 */       setAddress(source.getAddress());
/*     */     }
/*     */     
/*  66 */     if (getPort() == null) {
/*  67 */       setPort(source.getPort());
/*     */     }
/*     */     
/*  70 */     if (StringUtils.isEmpty(getCloseMarkerLocation())) {
/*  71 */       setCloseMarkerLocation(source.getCloseMarkerLocation());
/*     */     }
/*     */     
/*  74 */     if (StringUtils.isEmpty(getVersionLocation())) {
/*  75 */       setVersionLocation(source.getVersionLocation());
/*     */     }
/*     */     
/*  78 */     if (StringUtils.isEmpty(getUpdatesPendingMarkerFileName())) {
/*  79 */       setUpdatesPendingMarkerFileName(source.getUpdatesPendingMarkerFileName());
/*     */     }
/*     */     
/*  82 */     if (StringUtils.isEmpty(getApplyUpdatesMethodName())) {
/*  83 */       setApplyUpdatesMethodName(source.getApplyUpdatesMethodName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/*  92 */     return this._address;
/*     */   }
/*     */   
/*     */   public String getApplyUpdatesMethodName() {
/*  96 */     return this._applyUpdatesMethodName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCloseMarkerLocation() {
/* 104 */     return this._closeMarkerLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 112 */     return this._name;
/*     */   }
/*     */   
/*     */   public String getPasswordLocation() {
/* 116 */     return this._passwordLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getPort() {
/* 124 */     return this._port;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdatesPendingMarkerFileName() {
/* 129 */     return this._updatesPendingMarkerFileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersionLocation() {
/* 137 */     return this._versionLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 145 */     return (this._enabled == null || this._enabled.booleanValue());
/*     */   }
/*     */   
/*     */   public void setAddress(String argAddress) {
/* 149 */     this._address = argAddress;
/*     */   }
/*     */   
/*     */   public void setApplyUpdatesMethodName(String applyUpdatesMethodName) {
/* 153 */     this._applyUpdatesMethodName = applyUpdatesMethodName;
/*     */   }
/*     */   
/*     */   public void setCloseMarkerLocation(String argCloseMarkerLocation) {
/* 157 */     this._closeMarkerLocation = argCloseMarkerLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 163 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 164 */       this._name = argValue.toString();
/*     */     }
/* 166 */     else if ("Enabled".equalsIgnoreCase(argKey)) {
/* 167 */       this._enabled = Boolean.valueOf(ConfigUtils.toBoolean(argValue));
/*     */     }
/* 169 */     else if ("Address".equalsIgnoreCase(argKey)) {
/* 170 */       this._address = argValue.toString();
/*     */     }
/* 172 */     else if ("Port".equalsIgnoreCase(argKey)) {
/* 173 */       this._port = Integer.valueOf(ConfigUtils.toInt(argValue));
/*     */     }
/* 175 */     else if ("CloseMarkerLocation".equalsIgnoreCase(argKey)) {
/* 176 */       this._closeMarkerLocation = argValue.toString();
/*     */     }
/* 178 */     else if ("VersionLocation".equalsIgnoreCase(argKey)) {
/* 179 */       this._versionLocation = argValue.toString();
/*     */     }
/* 181 */     else if ("PasswordLocation".equalsIgnoreCase(argKey)) {
/* 182 */       this._passwordLocation = argValue.toString();
/*     */     }
/* 184 */     else if ("UpdatesPendingMarkerFile".equalsIgnoreCase(argKey)) {
/* 185 */       this._updatesPendingMarkerFileName = argValue.toString();
/*     */     }
/* 187 */     else if ("ApplyUpdatesMethodName".equalsIgnoreCase(argKey)) {
/* 188 */       this._applyUpdatesMethodName = argValue.toString();
/*     */     } 
/*     */     
/* 191 */     setClean();
/*     */   }
/*     */   
/*     */   public void setEnabled(Boolean argEnabled) {
/* 195 */     this._enabled = argEnabled;
/*     */   }
/*     */   
/*     */   public void setPort(Integer argPort) {
/* 199 */     this._port = argPort;
/*     */   }
/*     */   
/*     */   public void setUpdatesPendingMarkerFileName(String argUpdatesPendingMarkerFileName) {
/* 203 */     this._updatesPendingMarkerFileName = argUpdatesPendingMarkerFileName;
/*     */   }
/*     */   
/*     */   public void setVersionLocation(String argVersionLocation) {
/* 207 */     this._versionLocation = argVersionLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Boolean getEnabled() {
/* 217 */     return this._enabled;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\OptionsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */