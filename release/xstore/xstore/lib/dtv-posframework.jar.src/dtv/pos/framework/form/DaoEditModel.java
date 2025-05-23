/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.exception.PersistenceException;
/*     */ import dtv.pos.common.OpExecutionException;
/*     */ import dtv.pos.iframework.form.IDaoEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldListConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DaoEditModel
/*     */   extends BasicEditModel
/*     */   implements IDaoEditModel
/*     */ {
/*  33 */   private static final Logger logger_ = Logger.getLogger(DaoEditModel.class);
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IDataModel[] daos_;
/*     */ 
/*     */   
/*     */   protected final boolean isNew_;
/*     */ 
/*     */   
/*     */   protected final IDaoEditMappingConfig mappingConfig_;
/*     */ 
/*     */ 
/*     */   
/*     */   public DaoEditModel(IDataModel[] argDaos, IDaoEditMappingConfig argConfig, Boolean argIsNew) {
/*  48 */     this(argDaos, argConfig, argIsNew, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DaoEditModel(IDataModel[] argDaos, IDaoEditMappingConfig argConfig, Boolean argIsNew, IDataObjectDefinitionConfig argSelfFieldConfig) {
/*  57 */     super(argConfig.getName(), argConfig.getDescription());
/*     */     
/*  59 */     this.mappingConfig_ = argConfig;
/*  60 */     this.daos_ = argDaos;
/*  61 */     this.isNew_ = (argIsNew == null) ? this.daos_[0].isNew() : argIsNew.booleanValue();
/*     */     
/*  63 */     init(argIsNew);
/*     */ 
/*     */     
/*  66 */     addSelfFields(this.mappingConfig_.getObjectMap(), argSelfFieldConfig, argIsNew);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean commitChanges() {
/*  72 */     boolean committed = false;
/*     */     try {
/*  74 */       committed = (commitChangesImpl() || this.isNew_);
/*  75 */       if (committed) {
/*  76 */         DataFactory.makePersistent(this.daos_[0]);
/*     */       }
/*     */     }
/*  79 */     catch (PersistenceException ex) {
/*  80 */       throw new OpExecutionException(ex);
/*     */     } 
/*  82 */     return committed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel[] getDaos() {
/*  88 */     return this.daos_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDaoEditMappingConfig getMappingConfig() {
/*  98 */     return this.mappingConfig_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuffer sb = new StringBuffer(super.toString());
/*     */     
/* 111 */     sb.setLength(sb.length() - "]".length());
/* 112 */     sb.append(",daos_={");
/* 113 */     for (IDataModel element : this.daos_) {
/* 114 */       sb.append(element);
/* 115 */       sb.append(":");
/* 116 */       sb.append(ObjectUtils.getClassNameFromObject(element));
/* 117 */       sb.append(",");
/*     */     } 
/*     */     
/* 120 */     sb.setLength(sb.length() - ",".length());
/* 121 */     sb.append("}]");
/* 122 */     return sb.toString();
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
/*     */   protected void addFields(Map<String, IDataObjectDefinitionConfig> argObjectMap, Object argTargetObject, IDataEditFieldConfig[] fieldConfigs, int argAttributes) {
/* 137 */     for (IDataEditFieldConfig config : fieldConfigs) {
/*     */       
/* 139 */       IEditModelField<?> field = EditModelField.makeFieldDef(this, config, argAttributes, argTargetObject, argObjectMap);
/* 140 */       addField(field);
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
/*     */   protected void addSelfField(IDataEditFieldConfig argFieldConfig, int argAttributes, Map<String, IDataObjectDefinitionConfig> argObjectMap) {
/* 155 */     IEditModelField<?> field = EditModelField.makeFieldDef(this, argFieldConfig, argAttributes, this, argObjectMap);
/* 156 */     addField(field);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean commitChangesImpl() {
/* 163 */     return super.commitChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void init(Boolean argIsNew) {
/* 172 */     IDataObjectDefinitionConfig[] defs = this.mappingConfig_.getDataDefs();
/*     */     
/* 174 */     for (int i = 0; i < defs.length; i++) {
/*     */       try {
/* 176 */         boolean isNew = (argIsNew == null) ? this.daos_[i].isNew() : argIsNew.booleanValue();
/*     */         
/* 178 */         addFields(this.mappingConfig_.getObjectMap(), this.daos_[i], defs[i].getKeyFields().getFieldConfigs(), 0x4 | (isNew ? 2 : 0));
/*     */         
/* 180 */         addFields(this.mappingConfig_.getObjectMap(), this.daos_[i], defs[i].getOtherFields().getFieldConfigs(), isNew ? 2 : 0);
/*     */       
/*     */       }
/* 183 */       catch (NullPointerException ex) {
/* 184 */         logger_.error("CAUGHT EXCEPTION", ex);
/* 185 */         throw ex;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addSelfFields(Map<String, IDataObjectDefinitionConfig> argObjectMap, IDataEditFieldListConfig argFieldList, int argAttributes) {
/* 193 */     IDataEditFieldConfig[] fieldConfigs = argFieldList.getFieldConfigs();
/* 194 */     for (IDataEditFieldConfig fieldConfig : fieldConfigs) {
/* 195 */       addSelfField(fieldConfig, argAttributes, argObjectMap);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addSelfFields(Map<String, IDataObjectDefinitionConfig> argObjectMap, IDataObjectDefinitionConfig argSelfFieldConfig, Boolean argIsNew) {
/* 202 */     if (argSelfFieldConfig != null) {
/* 203 */       boolean isNew = (argIsNew == null) ? true : argIsNew.booleanValue();
/* 204 */       int newAttr = isNew ? 2 : 0;
/*     */       
/* 206 */       addSelfFields(argObjectMap, argSelfFieldConfig.getKeyFields(), 0x4 | newAttr);
/* 207 */       addSelfFields(argObjectMap, argSelfFieldConfig.getOtherFields(), newAttr);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DaoEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */