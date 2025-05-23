/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
/*    */ import dtv.pos.iframework.form.config.IDaoEditMappingListConfig;
/*    */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*    */ import dtv.pos.iframework.form.mapping.IEditModelKey;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DaoEditMappingListConfig
/*    */   extends AbstractParentConfig
/*    */   implements IDaoEditMappingListConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private static final Logger logger_ = Logger.getLogger(DaoEditMappingListConfig.class);
/*    */   
/* 28 */   private final List<DaoEditMappingConfig> mappings_ = new ArrayList<>();
/* 29 */   private final List<DataObjectDefinitionConfig> dataObjectList_ = new ArrayList<>();
/*    */   
/*    */   private Map<String, IDataObjectDefinitionConfig> dataObjectMap_;
/*    */   
/*    */   private Map<IEditModelKey, IDaoEditMappingConfig> mappingMap_;
/*    */   
/*    */   public Map<IEditModelKey, IDaoEditMappingConfig> getMappingsMap() {
/* 36 */     if (this.dataObjectMap_ == null) {
/* 37 */       this.dataObjectMap_ = new HashMap<>();
/* 38 */       for (IDataObjectDefinitionConfig objectDef : this.dataObjectList_) {
/* 39 */         String key = objectDef.getMappingId();
/* 40 */         if (this.dataObjectMap_.containsKey(key)) {
/* 41 */           logger_.info("overriding object id " + key + "::" + getSourceDescription());
/*    */         }
/* 43 */         this.dataObjectMap_.put(key, objectDef);
/*    */       } 
/*    */     } 
/* 46 */     if (this.mappingMap_ == null) {
/* 47 */       this.mappingMap_ = new HashMap<>();
/* 48 */       for (int i = 0; i < this.mappings_.size(); i++) {
/* 49 */         IDaoEditMappingConfig c = this.mappings_.get(i);
/* 50 */         c.setObjectMap(this.dataObjectMap_);
/* 51 */         this.mappingMap_.put(c.getModelKey(), c);
/*    */       } 
/*    */     } 
/* 54 */     return this.mappingMap_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Map<String, IDataObjectDefinitionConfig> getObjectMap() {
/* 59 */     return this.dataObjectMap_;
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
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 71 */     if (argValue instanceof DaoEditMappingConfig) {
/* 72 */       this.mappings_.add((DaoEditMappingConfig)argValue);
/*    */     }
/* 74 */     else if (argValue instanceof DataObjectDefinitionConfig) {
/* 75 */       this.dataObjectList_.add((DataObjectDefinitionConfig)argValue);
/*    */     } else {
/*    */       
/* 78 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\DaoEditMappingListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */