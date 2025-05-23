/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.form.DaoEditModel;
/*     */ import dtv.pos.framework.form.EditModelKey;
/*     */ import dtv.pos.i18n.config.FormattableConfig;
/*     */ import dtv.pos.iframework.XstApplication;
/*     */ import dtv.pos.iframework.form.IDaoEditModel;
/*     */ import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.pos.iframework.form.mapping.IEditModelKey;
/*     */ import dtv.pos.iframework.type.ExitType;
/*     */ import dtv.pos.iframework.type.IExitType;
/*     */ import dtv.util.ReflectionException;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DaoEditMappingConfig
/*     */   extends AbstractParentConfig
/*     */   implements IDaoEditMappingConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  39 */   private static final Logger logger_ = Logger.getLogger(DaoEditMappingConfig.class);
/*  40 */   private static final Class[] MODEL_CTOR_PARAM_TYPES_PRI = new Class[] { IDataModel[].class, IDaoEditMappingConfig.class, Boolean.class };
/*     */   
/*  42 */   private static final Class[] MODEL_CTOR_PARAM_TYPES_ALT = new Class[] { IDataModel[].class, IDaoEditMappingConfig.class, Boolean.class, IDataObjectDefinitionConfig.class };
/*     */ 
/*     */   
/*  45 */   private final List<String> dataObjectRefList_ = new ArrayList<>();
/*     */   
/*     */   private IEditModelKey modelKey_;
/*     */   
/*     */   private IFormattableConfig nameConfig_;
/*     */   private IFormattableConfig descriptionConfig_;
/*     */   private Constructor editModelCtor_;
/*     */   private ClassConfig<IDaoEditModel> editModelCtorConfig_;
/*     */   private Map<String, IDataObjectDefinitionConfig> objectMap_;
/*     */   private IDataObjectDefinitionConfig[] dataDefs_;
/*     */   private boolean usingAlternateCtor_;
/*     */   
/*     */   public IDataObjectDefinitionConfig[] getDataDefs() {
/*  58 */     return this.dataDefs_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getDescription() {
/*  63 */     return (this.descriptionConfig_ != null) ? this.descriptionConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   public IEditModelKey getModelKey() {
/*  68 */     return this.modelKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getName() {
/*  73 */     return (this.nameConfig_ != null) ? this.nameConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, IDataObjectDefinitionConfig> getObjectMap() {
/*  78 */     return Collections.unmodifiableMap(this.objectMap_);
/*     */   }
/*     */   
/*     */   public IDaoEditModel makeEditModel(IDataModel[] argDaos, Boolean argIsNew) {
/*     */     try {
/*     */       DaoEditModel model;
/*  84 */       Constructor<DaoEditModel> editModelCtor = getEditModelConstructor();
/*     */       
/*  86 */       if (editModelCtor == null) {
/*  87 */         model = new DaoEditModel(argDaos, this, argIsNew);
/*     */       } else {
/*     */         Object[] params;
/*     */         
/*  91 */         if (this.usingAlternateCtor_) {
/*  92 */           IDataObjectDefinitionConfig selfConfig = this.objectMap_.get(this.editModelCtorConfig_.getConfigValue());
/*  93 */           params = new Object[] { argDaos, this, argIsNew, selfConfig };
/*     */         } else {
/*     */           
/*  96 */           params = new Object[] { argDaos, this, argIsNew };
/*     */         } 
/*  98 */         model = editModelCtor.newInstance(params);
/*     */       } 
/* 100 */       model.initializeFieldState();
/* 101 */       return (IDaoEditModel)model;
/*     */     }
/* 103 */     catch (InvocationTargetException ex) {
/* 104 */       throw new ReflectionException(ex);
/*     */     }
/* 106 */     catch (IllegalArgumentException ex) {
/* 107 */       throw new ReflectionException(ex);
/*     */     }
/* 109 */     catch (IllegalAccessException ex) {
/* 110 */       throw new ReflectionException(ex);
/*     */     }
/* 112 */     catch (InstantiationException ex) {
/* 113 */       throw new ReflectionException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 123 */     if (argValue instanceof IFormattableConfig && ("model_name"
/* 124 */       .equalsIgnoreCase(argKey) || "name".equalsIgnoreCase(argKey))) {
/*     */       
/* 126 */       this.nameConfig_ = FormattableConfig.toFormattableConfig(argValue);
/*     */     }
/* 128 */     else if ("edit_model_class".equalsIgnoreCase(argKey) || "editModelClass".equalsIgnoreCase(argKey)) {
/* 129 */       ClassConfig<?> config = ConfigUtils.toClassConfig(argValue);
/* 130 */       this.editModelCtorConfig_ = (ClassConfig)config;
/*     */     }
/* 132 */     else if ("description".equalsIgnoreCase(argKey)) {
/* 133 */       this.descriptionConfig_ = FormattableConfig.toFormattableConfig(argValue);
/*     */     }
/* 135 */     else if (argValue instanceof dtv.util.config.StringConfig && ("model_key"
/* 136 */       .equalsIgnoreCase(argKey) || "name".equalsIgnoreCase(argKey))) {
/*     */       
/* 138 */       this.modelKey_ = EditModelKey.valueOf(argValue.toString());
/*     */     }
/* 140 */     else if ("data_object_ref".equalsIgnoreCase(argKey) || "dataObjectRef".equalsIgnoreCase(argKey)) {
/* 141 */       this.dataObjectRefList_.add(argValue.toString());
/*     */     } else {
/*     */       
/* 144 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setObjectMap(Map<String, IDataObjectDefinitionConfig> argMap) {
/* 150 */     this.objectMap_ = argMap;
/* 151 */     this.dataDefs_ = new IDataObjectDefinitionConfig[this.dataObjectRefList_.size()];
/* 152 */     for (int i = 0; i < this.dataDefs_.length; i++) {
/* 153 */       String id = this.dataObjectRefList_.get(i);
/* 154 */       this.dataDefs_[i] = argMap.get(id);
/* 155 */       if (this.dataDefs_[i] == null) {
/* 156 */         logger_.warn("no definition found for " + id + "::" + getSourceDescription());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private Constructor getAlternateEditModelConstructor() {
/*     */     try {
/* 163 */       this.editModelCtor_ = this.editModelCtorConfig_.getValue().getDeclaredConstructor(MODEL_CTOR_PARAM_TYPES_ALT);
/* 164 */       this.usingAlternateCtor_ = true;
/*     */     }
/* 166 */     catch (Exception ex) {
/* 167 */       if (logger_.isInfoEnabled()) {
/* 168 */         logger_.info(this.editModelCtorConfig_ + " does not implement the alternate constructor [" + MODEL_CTOR_PARAM_TYPES_PRI, ex);
/*     */       }
/*     */     } 
/*     */     
/* 172 */     return this.editModelCtor_;
/*     */   }
/*     */   
/*     */   private Constructor getEditModelConstructor() {
/*     */     Constructor results;
/* 177 */     if (this.editModelCtor_ == null && this.editModelCtorConfig_ != null) {
/* 178 */       results = getAlternateEditModelConstructor();
/* 179 */       if (results == null) {
/* 180 */         results = getPrimaryEditModelConstructor();
/*     */       }
/*     */     } else {
/*     */       
/* 184 */       results = this.editModelCtor_;
/*     */     } 
/* 186 */     return results;
/*     */   }
/*     */   
/*     */   private Constructor getPrimaryEditModelConstructor() {
/*     */     try {
/* 191 */       this.editModelCtor_ = this.editModelCtorConfig_.getValue().getDeclaredConstructor(MODEL_CTOR_PARAM_TYPES_PRI);
/*     */     }
/* 193 */     catch (Exception ex) {
/* 194 */       XstApplication.annihilate((IExitType)ExitType.CONFIG, this.editModelCtorConfig_ + " does not implement the correct constructor [" + MODEL_CTOR_PARAM_TYPES_PRI, ex);
/*     */     } 
/*     */     
/* 197 */     return this.editModelCtor_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\DaoEditMappingConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */