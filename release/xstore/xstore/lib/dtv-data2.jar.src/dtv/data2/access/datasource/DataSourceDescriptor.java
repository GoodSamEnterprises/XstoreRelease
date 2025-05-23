/*     */ package dtv.data2.access.datasource;
/*     */ 
/*     */ import dtv.data2.access.datasource.config.IPing;
/*     */ import java.util.Properties;
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
/*     */ public class DataSourceDescriptor
/*     */ {
/*     */   public static final String LAN_NETWORK_SCOPE = "LAN";
/*     */   public static final String WAN_NETWORK_SCOPE = "WAN";
/*     */   public static final String LOCAL_SCOPE = "LOCAL";
/*     */   private final String _name;
/*     */   private final boolean _enabled;
/*     */   private final String _networkScope;
/*     */   private final Properties _props;
/*     */   private final IPing _ping;
/*     */   private final boolean _highAvailability;
/*     */   private final boolean _offlineVisible;
/*     */   private String _sourceDescription;
/*     */   private String _persistenceStrategyName;
/*     */   private boolean _forcedOffline = false;
/*     */   
/*     */   public DataSourceDescriptor(String argName, boolean argEnabled, String argNetworkScope, String argStrategyName, Properties argProps, IPing argPing, boolean argHighAvailability, boolean argOfflineVisible) {
/*  37 */     this._name = argName;
/*  38 */     this._enabled = argEnabled;
/*  39 */     this._networkScope = argNetworkScope;
/*  40 */     this._persistenceStrategyName = argStrategyName;
/*  41 */     this._props = argProps;
/*  42 */     this._ping = argPing;
/*  43 */     this._highAvailability = argHighAvailability;
/*  44 */     this._offlineVisible = argOfflineVisible;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObject) {
/*  50 */     return (argObject instanceof DataSourceDescriptor && getName().equals(((DataSourceDescriptor)argObject)
/*  51 */         .getName()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  60 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNetworkScope() {
/*  71 */     return this._networkScope;
/*     */   }
/*     */   
/*     */   public String getPersistenceStrategyName() {
/*  75 */     return this._persistenceStrategyName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPing getPing() {
/*  83 */     return this._ping;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPingHost() {
/*  88 */     return this._ping.getHost();
/*     */   }
/*     */   
/*     */   public int getPingPort() {
/*  92 */     return this._ping.getPort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getProperties() {
/* 102 */     return this._props;
/*     */   }
/*     */   
/*     */   public String getSourceDescription() {
/* 106 */     return this._sourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 112 */     return getName().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 121 */     return this._enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHighAvailability() {
/* 132 */     return this._highAvailability;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOfflineVisible() {
/* 143 */     return this._offlineVisible;
/*     */   }
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/* 147 */     this._sourceDescription = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return super.toString() + " [" + getName() + "]";
/*     */   }
/*     */   
/*     */   public void setForcedOffline(boolean argForcedOffline) {
/* 157 */     this._forcedOffline = argForcedOffline;
/*     */   }
/*     */   
/*     */   public boolean isForcedOffline() {
/* 161 */     return this._forcedOffline;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\DataSourceDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */