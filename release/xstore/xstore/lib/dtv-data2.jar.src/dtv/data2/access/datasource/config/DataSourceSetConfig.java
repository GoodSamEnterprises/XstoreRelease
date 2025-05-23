/*    */ package dtv.data2.access.datasource.config;
/*    */ 
/*    */ import dtv.data2.access.config.common.PropertyConfig;
/*    */ import dtv.data2.access.config.common.PropertyConfigConverter;
/*    */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*    */ import dtv.util.config.AbstractSetConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Properties;
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
/*    */ public class DataSourceSetConfig
/*    */   extends AbstractSetConfig<DataSourceConfig>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private final List<PropertyConfig> _properties = new ArrayList<>();
/*    */   
/*    */   private Map<String, DataSourceDescriptor> _dataSources;
/*    */ 
/*    */   
/*    */   public String getChildTag() {
/* 33 */     return "DataSource";
/*    */   }
/*    */   
/*    */   public Map<String, DataSourceDescriptor> getDataSources() {
/* 37 */     if (this._dataSources == null) {
/* 38 */       this._dataSources = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 47 */       Map<String, DataSourceConfig> tempMap = new HashMap<>();
/* 48 */       for (DataSourceConfig config : this.childList_) {
/* 49 */         tempMap.put(config.getName(), config);
/*    */       }
/*    */       
/* 52 */       for (DataSourceConfig config : tempMap.values()) {
/* 53 */         DataSourceDescriptor descriptor = mergeProperties(config.getDataSource());
/* 54 */         descriptor.setSourceDescription(config.getSourceDescription());
/* 55 */         this._dataSources.put(descriptor.getName(), descriptor);
/*    */       } 
/*    */       
/* 58 */       this.childList_ = null;
/*    */     } 
/* 60 */     return this._dataSources;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 66 */     if ("Property".equalsIgnoreCase(argKey) && argValue instanceof PropertyConfig) {
/* 67 */       this._properties.add((PropertyConfig)argValue);
/*    */     } else {
/*    */       
/* 70 */       super.setConfigObject(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected DataSourceDescriptor mergeProperties(DataSourceDescriptor argSourceDescriptor) {
/* 83 */     DataSourceDescriptor sourceDescriptor = argSourceDescriptor;
/*    */     
/* 85 */     if (!this._properties.isEmpty()) {
/* 86 */       Properties sourceProps = argSourceDescriptor.getProperties();
/* 87 */       Properties setProps = PropertyConfigConverter.convert(this._properties, new Properties());
/*    */       
/* 89 */       for (Map.Entry<Object, Object> setProp : setProps.entrySet()) {
/*    */ 
/*    */         
/* 92 */         if (!sourceProps.containsKey(setProp.getKey())) {
/* 93 */           sourceProps.setProperty(setProp.getKey().toString(), setProp.getValue().toString());
/*    */         }
/*    */       } 
/*    */     } 
/* 97 */     return sourceDescriptor;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\config\DataSourceSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */