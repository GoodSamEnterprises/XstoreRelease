/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.form.Cardinality;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.IFieldReader;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.pos.iframework.form.config.IFieldDependencyConfig;
/*     */ import dtv.pos.iframework.form.dependency.IDependencyRule;
/*     */ import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EditModelField<T>
/*     */   extends EditModelFieldMetadata<T>
/*     */   implements IEditModelField<T>, IMutableFieldDefinition<T>, IFieldReader
/*     */ {
/*  36 */   private static final Logger logger_ = Logger.getLogger(EditModelField.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private final IDependencyRule dependency_;
/*     */ 
/*     */ 
/*     */   
/*     */   private List<T> possibleValueOverrides_;
/*     */ 
/*     */   
/*     */   private Comparator<Object> _possibleValuesComparator;
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEditModelField makeFieldDef(IEditModel argParent, IDataEditFieldConfig argConfig, int argAttributes, Object argTargetModel, Map<String, IDataObjectDefinitionConfig> argObjectMap) {
/*  52 */     return new EditModelField(argParent, argConfig, argAttributes, argTargetModel, argObjectMap);
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
/*     */   public static <T> IEditModelField<T> makeFieldDef(IEditModel argParent, String argFieldKey, Class<T> argFieldDataType, int argAttributes) {
/*  67 */     return new EditModelField<>(argParent, argFieldKey, argFieldDataType, argAttributes, (IFieldDependencyConfig)null, (ICardinality)null, (List<? extends T>)null, (IListFieldElementDescr)null, (IValueWrapperFactory)null, (IFormattable)null, (ISecuredObjectID)null);
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
/*     */   public static <T> EditModelField<T> makeFieldDef(IEditModel argParent, String argFieldKey, Class<T> argFieldDataType, int argAttributes, ICardinality argCardinality) {
/*  85 */     return new EditModelField<>(argParent, argFieldKey, argFieldDataType, argAttributes, (IFieldDependencyConfig)null, argCardinality, (List<? extends T>)null, (IListFieldElementDescr)null, (IValueWrapperFactory)null, (IFormattable)null, (ISecuredObjectID)null);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> EditModelField<T> makeFieldDef(IEditModel argParent, String argFieldKey, Class<T> argFieldDataType, int argAttributes, ICardinality argCardinality, ISecuredObjectID argSecuredId) {
/* 106 */     return new EditModelField<>(argParent, argFieldKey, argFieldDataType, argAttributes, (IFieldDependencyConfig)null, argCardinality, (List<? extends T>)null, (IListFieldElementDescr)null, (IValueWrapperFactory)null, (IFormattable)null, argSecuredId);
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
/*     */   public static <T> IEditModelField<T> makeFieldDef(IEditModel argParent, String argFieldKey, Class<T> argFieldDataType, int argAttributes, IFieldDependencyConfig argFieldDependencyConfig, ICardinality argCardinality, List<? extends T> argPossibleValues, IListFieldElementDescr argFieldElementDescriptor, IValueWrapperFactory argWrapperFactory, ISecuredObjectID argSecuredObjectId) {
/* 135 */     return new EditModelField<>(argParent, argFieldKey, argFieldDataType, argAttributes, argFieldDependencyConfig, argCardinality, argPossibleValues, argFieldElementDescriptor, argWrapperFactory, (IFormattable)null, argSecuredObjectId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IEditModelField makeFieldDefUnsafe(IEditModel argParent, String argFieldKey, Class<?> argFieldDataType, int argAttributes, IFieldDependencyConfig argFieldDependencyConfig, ICardinality argCardinality, List<?> argPossibleValues, IListFieldElementDescr argFieldElementDescriptor, IValueWrapperFactory argWrapperFactory, ISecuredObjectID argSecuredObjectId) {
/* 145 */     return new EditModelField(argParent, argFieldKey, argFieldDataType, argAttributes, argFieldDependencyConfig, argCardinality, argPossibleValues, argFieldElementDescriptor, argWrapperFactory, (IFormattable)null, argSecuredObjectId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean forcedReadOnly_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IEditModel parentModel_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Object targetModel_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean isNew_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ICardinality cardinality_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EditModelField(IEditModel argParent, IDataEditFieldConfig argConfig, int argAttributes, Object argTargetModel, Map<String, IDataObjectDefinitionConfig> argObjectMap) {
/* 181 */     super(argObjectMap, argConfig, argAttributes);
/*     */     
/* 183 */     if (argTargetModel == null) {
/*     */ 
/*     */       
/* 186 */       String message = "The target object for field key [" + argConfig.getFieldKey() + "] on edit model [" + argParent + "] is null.  Hence, the field cannot be added to the model.  The field definition source is [" + argConfig.getSourceDescription() + "].";
/* 187 */       throw new NullPointerException(message);
/*     */     } 
/* 189 */     this.parentModel_ = argParent;
/* 190 */     this.targetModel_ = argTargetModel;
/* 191 */     this.isNew_ = hasAttribute(argAttributes, 2);
/*     */     
/* 193 */     IFieldDependencyConfig dc = argConfig.getFieldDependencyConfig();
/* 194 */     this.dependency_ = (dc == null) ? null : dc.makeDependencyRule(this.parentModel_, this);
/*     */     
/* 196 */     lookupAccesorFields(this.targetModel_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EditModelField(IEditModel argParent, String argFieldKey, Class<T> argFieldDataType) {
/* 207 */     this(argParent, argFieldKey, argFieldDataType, 2, (IFieldDependencyConfig)null, (ICardinality)null, (List<? extends T>)null, (IListFieldElementDescr)null, (IValueWrapperFactory)null, (IFormattable)null, (ISecuredObjectID)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EditModelField(IEditModel argEditModel, String argFieldKey, Class<T> argFieldDataType, int argAttributes, IFieldDependencyConfig argFieldDependencyConfig, ICardinality argCardinality, List<? extends T> argPossibleValues, IListFieldElementDescr argFieldElementDescriptor, IValueWrapperFactory argValueWrapper, IFormattable argFieldName, ISecuredObjectID argSecuredObjectId) {
/* 218 */     super(argFieldKey, argFieldDataType, argAttributes, argCardinality, argPossibleValues, argFieldElementDescriptor, argValueWrapper, argFieldName, argSecuredObjectId);
/*     */ 
/*     */     
/* 221 */     this.parentModel_ = argEditModel;
/* 222 */     this.targetModel_ = argEditModel;
/* 223 */     this.isNew_ = hasAttribute(argAttributes, 2);
/* 224 */     this
/* 225 */       .dependency_ = (argFieldDependencyConfig == null) ? null : argFieldDependencyConfig.makeDependencyRule(this.parentModel_, this);
/*     */ 
/*     */     
/* 228 */     lookupAccesorFields(this.targetModel_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICardinality getCardinality() {
/* 234 */     if (this.cardinality_ == null) {
/* 235 */       return super.getCardinality();
/*     */     }
/* 237 */     return this.cardinality_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<Object> getCurrentComparator() {
/* 243 */     return this._possibleValuesComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getElements() {
/* 249 */     return getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<T> getEnumeratedPossibleValues() {
/* 255 */     return (this.possibleValueOverrides_ != null) ? Collections.<T>unmodifiableList(this.possibleValueOverrides_) : super
/* 256 */       .getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getValue() {
/* 262 */     return getValue(this.targetModel_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString() {
/* 268 */     return getValueAsString(this.targetModel_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDependency() {
/* 274 */     return (this.dependency_ != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/* 280 */     if (this.dependency_ != null) {
/* 281 */       this.dependency_.initialize();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 288 */     return isReadOnly(this.isNew_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(boolean argIsNew) {
/* 294 */     return (this.forcedReadOnly_ || super.isReadOnly(argIsNew));
/*     */   }
/*     */ 
/*     */   
/*     */   public void makeRequired() {
/* 299 */     setRequired(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean readFrom(Object argObject) {
/* 305 */     if (argObject == this.targetModel_) {
/* 306 */       return false;
/*     */     }
/*     */     
/*     */     try {
/* 310 */       String[] fieldParts = this.fieldKey_.split("::");
/* 311 */       int fieldPartCount = fieldParts.length;
/* 312 */       Class[] getterParamClasses = new Class[fieldPartCount - 1];
/* 313 */       Object[] getterParams = new Object[fieldPartCount - 1];
/*     */       
/* 315 */       for (int i = 1; i < fieldPartCount; i++) {
/* 316 */         getterParamClasses[i - 1] = String.class;
/* 317 */         getterParams[i - 1] = fieldParts[i];
/*     */       } 
/*     */       
/* 320 */       Method getter = argObject.getClass().getMethod(makeGetterName(fieldParts[0]), getterParamClasses);
/*     */       
/* 322 */       if (!ObjectUtils.isReflectivelyAssignableFrom(getter.getReturnType(), getDataType())) {
/* 323 */         return false;
/*     */       }
/* 325 */       T value = (T)getter.invoke(argObject, getterParams);
/* 326 */       setValue(value);
/* 327 */       return true;
/*     */     }
/* 329 */     catch (Exception ex) {
/* 330 */       logger_.debug("CAUGHT EXCEPTION", ex);
/* 331 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeValue() {
/*     */     try {
/* 339 */       Object newValue = isBooleanField() ? Boolean.FALSE : null;
/* 340 */       this.parentModel_.setValue(this.fieldKey_, newValue);
/*     */     }
/* 342 */     catch (Exception ex) {
/* 343 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setCardinality(ICardinality argCardinality) {
/* 350 */     this.cardinality_ = argCardinality;
/* 351 */     this.events_.post(EditModelFieldChangeType.CARDINALITY_CHANGED, argCardinality);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentComparator(Comparator<Object> argComparator) {
/* 357 */     this._possibleValuesComparator = argComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElements(List<?> argElems) {
/* 363 */     List<T> isThisCastedListReallyNecessaryCommaGenerics = (List)argElems;
/* 364 */     setEnumeratedPossibleValues(isThisCastedListReallyNecessaryCommaGenerics);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnumeratedPossibleValues(List<T> argValues) {
/* 370 */     this.possibleValueOverrides_ = argValues;
/* 371 */     this.events_.post(EditModelFieldChangeType.ENUMERATION_CHANGED, getEnumeratedPossibleValues());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean argReadOnly) {
/* 377 */     this.forcedReadOnly_ = argReadOnly;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean argRequired) {
/* 383 */     setCardinality(Cardinality.makeRequired(getCardinality(), argRequired));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(T argValue) {
/* 389 */     setValue(argValue, this.targetModel_, this.isNew_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 395 */     return this.fieldKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unremoveValue() {
/* 401 */     if (!isBooleanField()) {
/* 402 */       this.parentModel_.revertChanges(this.fieldKey_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isBooleanField() {
/* 411 */     return (Boolean.class.equals(this.dataType_) || boolean.class.equals(this.dataType_));
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */