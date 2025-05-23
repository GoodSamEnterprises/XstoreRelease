/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.i18n.config.FormattableConfig;
/*     */ import dtv.pos.iframework.form.Cardinality;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.pos.iframework.form.config.IFieldDependencyConfig;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.pos.iframework.security.SecuredObjectID;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataEditFieldConfig
/*     */   extends AbstractParentConfig
/*     */   implements IDataEditFieldConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String fieldKey_;
/*     */   private ClassConfig<?> dataTypeConfig_;
/*     */   private IFormattableConfig fieldNameConfig_;
/*     */   private IFormattableConfig descriptionConfig_;
/*  35 */   private String inputMask_ = null;
/*  36 */   private String displayMask_ = null;
/*  37 */   private ICardinality cardinality_ = null;
/*  38 */   private FieldDependencyConfig dependencyConfig_ = null;
/*  39 */   private SecuredObjectID securedObjectId_ = null;
/*  40 */   private FormValueEnumConfig valueEnumConfig_ = null;
/*  41 */   private String elementDataObjectRef_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataEditFieldConfig() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataEditFieldConfig(String argName, Class argDataType, ICardinality argCardinality) {
/*  57 */     this.fieldKey_ = argName;
/*  58 */     this.dataTypeConfig_ = new ClassConfig(argDataType);
/*  59 */     this.cardinality_ = argCardinality;
/*     */   }
/*     */ 
/*     */   
/*     */   public ICardinality getCardinality() {
/*  64 */     return this.cardinality_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getDataType() {
/*  69 */     return (this.dataTypeConfig_ == null) ? null : this.dataTypeConfig_.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getDescription() {
/*  74 */     return (this.descriptionConfig_ == null) ? null : this.descriptionConfig_.getFormattable();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDisplayMask() {
/*  79 */     return this.displayMask_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFieldDependencyConfig getFieldDependencyConfig() {
/*  84 */     return this.dependencyConfig_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFieldKey() {
/*  89 */     return this.fieldKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getFieldName() {
/*  94 */     if (this.fieldNameConfig_ == null) {
/*  95 */       return null;
/*     */     }
/*  97 */     return this.fieldNameConfig_.getFormattable();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getInputMask() {
/* 102 */     return this.inputMask_;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<?> getPossibleValues() {
/* 107 */     if (this.valueEnumConfig_ == null) {
/* 108 */       return null;
/*     */     }
/* 110 */     return this.valueEnumConfig_.getValues();
/*     */   }
/*     */ 
/*     */   
/*     */   public ISecuredObjectID getSecuredObject() {
/* 115 */     return (ISecuredObjectID)this.securedObjectId_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getWrapperFactory() {
/* 120 */     if (this.valueEnumConfig_ == null) {
/* 121 */       return null;
/*     */     }
/* 123 */     return this.valueEnumConfig_.getWrapperFactory();
/*     */   }
/*     */ 
/*     */   
/*     */   public IListFieldElementDescr makeFieldElementDescriptor(Map<String, IDataObjectDefinitionConfig> objectMap) {
/* 128 */     if (this.elementDataObjectRef_ == null) {
/* 129 */       return null;
/*     */     }
/* 131 */     IDataObjectDefinitionConfig daoDef = objectMap.get(this.elementDataObjectRef_);
/* 132 */     return daoDef.makeFieldElementDescriptor();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 138 */     if ("name".equalsIgnoreCase(argKey) || "method_base".equalsIgnoreCase(argKey)) {
/* 139 */       this.fieldKey_ = argValue.toString();
/*     */     }
/* 141 */     else if ("class".equalsIgnoreCase(argKey)) {
/* 142 */       this.dataTypeConfig_ = ConfigUtils.toClassConfig(argValue);
/*     */     }
/* 144 */     else if ("label".equalsIgnoreCase(argKey)) {
/* 145 */       this.fieldNameConfig_ = FormattableConfig.toFormattableConfig(argValue);
/*     */     }
/* 147 */     else if ("description".equalsIgnoreCase(argKey)) {
/* 148 */       this.descriptionConfig_ = FormattableConfig.toFormattableConfig(argValue);
/*     */     }
/* 150 */     else if ("input_mask".equalsIgnoreCase(argKey) || "inputMask".equalsIgnoreCase(argKey)) {
/* 151 */       this.inputMask_ = argValue.toString();
/*     */     }
/* 153 */     else if ("display_mask".equalsIgnoreCase(argKey) || "displayMask".equalsIgnoreCase(argKey)) {
/* 154 */       this.displayMask_ = argValue.toString();
/*     */     }
/* 156 */     else if ("cardinality".equalsIgnoreCase(argKey)) {
/* 157 */       this.cardinality_ = (ICardinality)new Cardinality(argValue.toString());
/*     */     }
/* 159 */     else if (argValue instanceof FieldDependencyConfig) {
/* 160 */       this.dependencyConfig_ = (FieldDependencyConfig)argValue;
/*     */     }
/* 162 */     else if ("secured_object".equalsIgnoreCase(argKey) || "securedObject".equalsIgnoreCase(argKey)) {
/* 163 */       this.securedObjectId_ = SecuredObjectID.forName(argValue);
/*     */     }
/* 165 */     else if ("element_data_object_ref".equalsIgnoreCase(argKey)) {
/* 166 */       this.elementDataObjectRef_ = argValue.toString();
/*     */     }
/* 168 */     else if (argValue instanceof FormValueEnumConfig) {
/* 169 */       this.valueEnumConfig_ = (FormValueEnumConfig)argValue;
/*     */     } else {
/*     */       
/* 172 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\DataEditFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */