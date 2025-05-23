/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.IEditModelFieldValidationInfo;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFieldDependencyConfig;
/*     */ import dtv.pos.iframework.form.dependency.IDependencyRule;
/*     */ import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenericEditModelFieldDefinition
/*     */   implements IEditModelField, IMutableFieldDefinition
/*     */ {
/*     */   private final IDependencyRule dependency_;
/*  27 */   private ICardinality cardinality_ = ICardinality.OPTIONAL;
/*     */ 
/*     */   
/*     */   private Object value_;
/*     */   
/*     */   private Object valueHolder_;
/*     */   
/*     */   private final IDataEditFieldConfig config_;
/*     */   
/*     */   private List<?> possibleValues_;
/*     */   
/*     */   private Comparator<Object> _possibleValuesComparator;
/*     */ 
/*     */   
/*     */   public GenericEditModelFieldDefinition(IEditModel argParent, IDataEditFieldConfig argConfig) {
/*  42 */     this.config_ = argConfig;
/*  43 */     IFieldDependencyConfig dc = argConfig.getFieldDependencyConfig();
/*  44 */     this.dependency_ = (dc != null) ? dc.makeDependencyRule(argParent, this) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICardinality getCardinality() {
/*  50 */     return this.cardinality_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<Object> getCurrentComparator() {
/*  56 */     return this._possibleValuesComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getDataType() {
/*  62 */     return this.config_.getDataType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getElements() {
/*  68 */     return getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getEnumeratedPossibleValues() {
/*  74 */     return (this.possibleValues_ != null) ? this.possibleValues_ : this.config_.getPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListFieldElementDescr getFieldElementDescriptor() {
/*  80 */     return this.config_.makeFieldElementDescriptor(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldKey() {
/*  86 */     return this.config_.getFieldKey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFieldName() {
/*  92 */     return this.config_.getFieldName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEditModelFieldValidationInfo getValidationInfo() {
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue() {
/* 104 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(Object argTarget) {
/* 110 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString() {
/* 116 */     return (this.value_ != null) ? this.value_.toString() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString(Object argTarget) {
/* 122 */     return getValueAsString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getValueWrapper() {
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDependency() {
/* 134 */     return (this.dependency_ != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/* 142 */     if (this.dependency_ != null) {
/* 143 */       this.dependency_.initialize();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable() {
/* 150 */     return this.cardinality_.isAvailable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 159 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(boolean isNew) {
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecured() {
/* 171 */     return (this.config_.getSecuredObject() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeRequired() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeValue() {
/* 183 */     this.valueHolder_ = this.value_;
/* 184 */     this.value_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCardinality(ICardinality argCardinality) {
/* 190 */     this.cardinality_ = argCardinality;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentComparator(Comparator<Object> argComparator) {
/* 196 */     this._possibleValuesComparator = argComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElements(List<?> argElems) {
/* 202 */     setEnumeratedPossibleValues(argElems);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnumeratedPossibleValues(List<?> argValues) {
/* 208 */     this
/* 209 */       .possibleValues_ = (argValues == null && getEnumeratedPossibleValues() != null) ? Collections.emptyList() : argValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean argReadOnly) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean areRequired) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(ISystemUser argUser) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object argValue) {
/* 236 */     this.value_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object argValue, Object argTarget, boolean argIsNew) {
/* 242 */     this.value_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unremoveValue() {
/* 248 */     this.value_ = this.valueHolder_;
/* 249 */     this.valueHolder_ = null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\GenericEditModelFieldDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */