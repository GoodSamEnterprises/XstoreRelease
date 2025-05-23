/*    */ package dtv.data2.access.datasource.config;
/*    */ 
/*    */ import dtv.data2.access.config.common.PropertyConfig;
/*    */ import dtv.data2.access.config.common.PropertyConfigConverter;
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataSourceConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String _dataSourceName;
/*    */   private String _persistenceStrategyName;
/* 29 */   private String _networkScope = "LAN";
/*    */   private IPing _ping;
/*    */   private boolean _highAvailability = false;
/*    */   private boolean _offlineVisible = true;
/*    */   private boolean _enabled = true;
/* 34 */   private final List<PropertyConfig> _properties = new ArrayList<>();
/*    */   
/*    */   public DataSourceDescriptor getDataSource() {
/* 37 */     Properties props = new Properties();
/* 38 */     props = PropertyConfigConverter.convert(this._properties, props);
/*    */     
/* 40 */     return new DataSourceDescriptor(this._dataSourceName, getEnabled(), this._networkScope, this._persistenceStrategyName, props, this._ping, this._highAvailability, this._offlineVisible);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 47 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 48 */       this._dataSourceName = argValue.toString();
/*    */     }
/* 50 */     else if ("Enabled".equalsIgnoreCase(argKey)) {
/* 51 */       this._enabled = ConfigUtils.toBoolean(argValue);
/*    */     }
/* 53 */     else if ("NetworkScope".equalsIgnoreCase(argKey)) {
/* 54 */       this._networkScope = argValue.toString();
/*    */     }
/* 56 */     else if ("HighAvailability".equalsIgnoreCase(argKey)) {
/* 57 */       this._highAvailability = ConfigUtils.toBoolean(argValue);
/*    */     }
/* 59 */     else if ("OfflineVisible".equalsIgnoreCase(argKey)) {
/* 60 */       this._offlineVisible = ConfigUtils.toBoolean(argValue);
/*    */     }
/* 62 */     else if ("Strategy".equalsIgnoreCase(argKey)) {
/* 63 */       this._persistenceStrategyName = argValue.toString();
/*    */     }
/* 65 */     else if ("Property".equalsIgnoreCase(argKey) && argValue instanceof PropertyConfig) {
/* 66 */       this._properties.add((PropertyConfig)argValue);
/*    */     }
/* 68 */     else if ("Ping".equalsIgnoreCase(argKey) && argValue instanceof PingConfig) {
/* 69 */       this._ping = ((PingConfig)argValue).getPing();
/*    */     } else {
/*    */       
/* 72 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return (new ToStringBuilder(this)).append(this._dataSourceName).append(getSourceDescription()).toString();
/*    */   }
/*    */   
/*    */   String getName() {
/* 83 */     return this._dataSourceName;
/*    */   }
/*    */   
/*    */   private boolean getEnabled() {
/* 87 */     return this._enabled;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\config\DataSourceConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */