/*     */ package dtv.pos.framework.form;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.form.validators.IEditModelFieldValidator;
/*     */ import dtv.pos.framework.form.validators.IEditModelFieldValidatorFactory;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.pos.framework.validation.ValidationResultList;
/*     */ import dtv.pos.iframework.form.EditModelException;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.IFieldService;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.iframework.validation.IValidationResult;
/*     */ import dtv.pos.iframework.validation.IValidationResultList;
/*     */ import dtv.test.ITestHarness;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.DtvMultiStorage;
/*     */ import dtv.util.IKeyedValue;
/*     */ import dtv.util.KeyValuePair;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class BasicEditModel implements IEditModel {
/*  42 */   protected static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*  44 */   private static final Logger logger_ = Logger.getLogger(BasicEditModel.class);
/*  45 */   private static final boolean isDebugEnabled_ = logger_.isDebugEnabled();
/*     */ 
/*     */   
/*  48 */   protected final Eventor events_ = (Eventor)new DefaultEventor((IEventSource)this);
/*     */   
/*  50 */   protected final EditModelHelper helper_ = new EditModelHelper();
/*     */   
/*     */   protected ISystemUser user_;
/*     */   
/*  54 */   private final Map<String, IEditModelField<?>> fields_ = new HashMap<>();
/*  55 */   private final List<String> fieldNames_ = new ArrayList<>();
/*  56 */   private final DtvMultiStorage<String, CompositeObject.TwoPiece<IFieldService, String>> fieldServices_ = new DtvMultiStorage();
/*     */   
/*     */   private final IFormattable name_;
/*     */   
/*     */   private final IFormattable description_;
/*     */   
/*     */   @Inject
/*     */   private ITestHarness _testHarness;
/*     */   
/*     */   @Inject
/*     */   protected EventManager _eventManager;
/*     */   
/*     */   @Inject
/*     */   protected StationState _stationState;
/*     */   
/*     */   @Inject
/*     */   protected TransDateProvider _transDateProvider;
/*     */   @Inject
/*     */   private EditModelFieldChangeManager _changeManager;
/*  75 */   private String focusRequestFieldKey_ = null;
/*     */   @Deprecated
/*  77 */   private IEditModelSetFieldFilterFactory _setFieldFilterFactory = null;
/*     */   
/*     */   @Deprecated
/*  80 */   private IEditModelFieldValidatorFactory _validatorFactory = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicEditModel() {
/*  88 */     this(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicEditModel(IFormattable argModelName, IFormattable argModelDescription) {
/*  98 */     InjectionHammer.forceAtInjectProcessing(this);
/*  99 */     this.user_ = this._stationState.getSystemUser();
/* 100 */     this.name_ = argModelName;
/* 101 */     this.description_ = argModelDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean commitChanges() {
/* 107 */     return this._changeManager.commitChanges(false);
/*     */   }
/*     */   
/*     */   public boolean commitChanges(String argFieldKey) {
/* 111 */     boolean anyChanges = false;
/* 112 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/*     */     
/* 114 */     if (field != null) {
/* 115 */       anyChanges = this._changeManager.commitChanges(field, false);
/*     */     }
/*     */     
/* 118 */     return anyChanges;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deregisterFieldHandler(String argFieldKey, IEventAware argHandler) {
/* 124 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 125 */     if (field != null) {
/* 126 */       this._eventManager.deregisterEventHandler(argHandler, (IEventSource)field);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Collection<IKeyedValue<String, ?>> getChanges() {
/* 133 */     Collection<IEditModelField<?>> changedFields = this._changeManager.getChangedFields();
/*     */     
/* 135 */     Collection<IKeyedValue<String, ?>> changes = new ArrayList<>(changedFields.size());
/*     */     
/* 137 */     for (IEditModelField<?> field : changedFields) {
/* 138 */       changes.add(new KeyValuePair(field.getFieldKey(), field.getValue()));
/*     */     }
/* 140 */     return changes;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getDataType(String argFieldKey) {
/* 146 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 147 */     return (field != null) ? field.getDataType() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getEnumeratedPossibleValues(String argFieldKey) {
/* 153 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 154 */     return (field != null) ? field.getEnumeratedPossibleValues() : Collections.emptyList();
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
/*     */   public IEditModelField getFieldDef(String argFieldKey) {
/* 167 */     IEditModelField<?> field = this.fields_.get(argFieldKey);
/*     */     
/* 169 */     if (field == null) {
/* 170 */       if (isDynamicFieldCapable()) {
/* 171 */         field = new DynamicEditModelFieldDefinition(this, argFieldKey, String.class);
/* 172 */         addField(field);
/*     */       } else {
/*     */         
/* 175 */         StringBuilder sb = new StringBuilder();
/* 176 */         sb.append("FIELD [");
/* 177 */         sb.append(argFieldKey);
/* 178 */         sb.append("] NOT FOUND on ").append(getClass().getName());
/*     */         
/* 180 */         if (this._testHarness.isEnabled()) {
/* 181 */           this._testHarness.reportIncident(sb.toString(), this);
/*     */         }
/*     */         
/* 184 */         sb.append("\nAvailable fields:\n");
/* 185 */         for (String fieldKey : getFieldKeys()) {
/* 186 */           sb.append("\t");
/* 187 */           sb.append(fieldKey);
/* 188 */           sb.append("\n");
/*     */         } 
/* 190 */         logger_.warn(sb.toString());
/*     */       } 
/*     */     }
/* 193 */     return field;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListFieldElementDescr getFieldElementDescriptor(String argFieldKey) {
/* 199 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 200 */     return (field != null) ? field.getFieldElementDescriptor() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Collection<String> getFieldKeys() {
/* 206 */     return this.fieldNames_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFocusRequestFieldKey() {
/* 212 */     return this.focusRequestFieldKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getMaximum(String argFieldKey) {
/* 218 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 219 */     return (field != null) ? field.getCardinality().getMaximum() : Integer.valueOf(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimum(String argFieldKey) {
/* 225 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 226 */     return (field != null) ? field.getCardinality().getMinimum() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getModelDescription() {
/* 232 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getModelTitle() {
/* 238 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISystemUser getUser() {
/* 244 */     return this.user_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldKey) throws EditModelException {
/* 251 */     if (argFieldKey == null) {
/* 252 */       return null;
/*     */     }
/* 254 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 255 */     if (field == null) {
/* 256 */       throw new EditModelException("FIELD NOT FOUND [" + argFieldKey + "]");
/*     */     }
/*     */     
/* 259 */     Object value = field.getValue();
/* 260 */     if (isDebugEnabled_) {
/* 261 */       logger_.debug("getValue-live(" + argFieldKey + ")=" + (
/* 262 */           StringUtils.isPossibleCreditCardNumber(value) ? "[REDACTED]" : value));
/*     */     }
/* 264 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getValueWrapper(String argFieldKey) {
/* 270 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 271 */     return (field != null) ? field.getValueWrapper() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasChanges() {
/* 277 */     return !this._changeManager.getChangedFields().isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasFieldChanged(String argFieldKey) {
/* 283 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 284 */     return (field != null) ? this._changeManager.hasChanged(field) : false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void initializeFieldState() {
/* 292 */     for (String fieldKey : getFieldKeys()) {
/* 293 */       getFieldDef(fieldKey).initialize();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 298 */     IEditModelSetFieldFilterFactory setFieldFilterFactory = getSetFieldFilterFactory();
/* 299 */     if (setFieldFilterFactory != null) {
/* 300 */       for (String fieldKey : getFieldKeys()) {
/* 301 */         IEditModelSetFieldFilter<?> setFieldFilter = setFieldFilterFactory.getSetFieldFilter(fieldKey);
/* 302 */         if (setFieldFilter != null) {
/* 303 */           setFieldFilter.init(this, getFieldDef(fieldKey));
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 309 */     this._changeManager.initialize();
/*     */     
/* 311 */     initializeFieldValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArray(String argFieldKey) {
/* 317 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 318 */     return (field != null) ? field.getCardinality().isArray() : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable(String argFieldKey) {
/* 324 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 325 */     return (field != null) ? field.isAvailable() : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(String argFieldKey) {
/* 331 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 332 */     return (field != null) ? field.isReadOnly() : true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired(String argFieldKey) {
/* 338 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 339 */     return (field != null) ? field.getCardinality().isRequired() : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeRequired(String argFieldKey) {
/* 345 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 346 */     if (field != null) {
/* 347 */       field.makeRequired();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerFieldHandler(String argFieldKey, IEventAware argHandler, IEventConstraint argConstraint) {
/* 355 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 356 */     if (field != null) {
/* 357 */       this._eventManager.registerEventHandler(argHandler, (IEventSource)field, argConstraint);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerFieldService(String argFieldKey, IFieldService argService, String argServiceKey) {
/* 364 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 365 */     if (field != null) {
/* 366 */       this.fieldServices_.put(argFieldKey.toUpperCase(), CompositeObject.make(argService, argServiceKey));
/* 367 */       argService.registerField(this, field, argServiceKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void revertChanges() {
/* 374 */     this._changeManager.revertChanges(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void revertChanges(String argFieldKey) {
/* 380 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 381 */     if (field != null) {
/* 382 */       this._changeManager.revertChanges(field, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldWeight(String argFieldKey, int argFieldWeight) {}
/*     */ 
/*     */   
/*     */   public void setFocusRequestFieldKey(String newValue) {
/* 392 */     this.focusRequestFieldKey_ = newValue;
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
/*     */   public void setRequired(String argFieldKey, boolean argValue) {
/* 404 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/* 405 */     if (field != null) {
/* 406 */       field.setRequired(argValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(ISystemUser argUser) {
/* 413 */     this.user_ = argUser;
/* 414 */     for (IEditModelField<?> field : this.fields_.values()) {
/* 415 */       field.setUser(argUser);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldKey, Object argValue) throws EditModelException {
/* 425 */     if (argFieldKey == null) {
/* 426 */       logger_.warn("NULL FIELD KEY", new Throwable("STACK TRACE"));
/*     */       return;
/*     */     } 
/* 429 */     IEditModelField field = getFieldDef(argFieldKey);
/* 430 */     if (field == null) {
/* 431 */       throw new EditModelException("FIELD NOT FOUND [" + argFieldKey + "]");
/*     */     }
/*     */     
/* 434 */     if (isDebugEnabled_) {
/* 435 */       logger_.debug("setting " + argFieldKey + "=" + (
/* 436 */           StringUtils.isPossibleCreditCardNumber(argValue) ? "[REDACTED]" : argValue) + ":type=" + 
/* 437 */           ObjectUtils.getClassNameFromObject(argValue));
/*     */     }
/*     */     
/* 440 */     IEditModelSetFieldFilterFactory setFieldFilterFactory = getSetFieldFilterFactory();
/* 441 */     Object newValue = argValue;
/* 442 */     if (setFieldFilterFactory != null) {
/* 443 */       IEditModelSetFieldFilter<?> setFieldFilter = setFieldFilterFactory.getSetFieldFilter(argFieldKey);
/* 444 */       if (setFieldFilter != null) {
/* 445 */         newValue = setFieldFilter.setValue(this, getFieldDef(argFieldKey), newValue);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 450 */     newValue = ObjectUtils.cast(newValue, field.getDataType());
/*     */     
/* 452 */     if ("".equals(newValue)) {
/* 453 */       newValue = null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 458 */     field.setValue(newValue);
/* 459 */     if (isDebugEnabled_) {
/* 460 */       logger_.debug("setting " + argFieldKey + " (live)=" + (
/* 461 */           StringUtils.isPossibleCreditCardNumber(newValue) ? "[REDACTED]" : newValue) + ":type=" + 
/* 462 */           ObjectUtils.getClassNameFromObject(newValue));
/*     */     }
/* 464 */     notifyServices(argFieldKey, newValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 470 */     StringBuilder sb = new StringBuilder();
/* 471 */     sb.append(getClass().getName());
/* 472 */     sb.append("[");
/* 473 */     sb.append(getFieldKeys());
/* 474 */     sb.append("]");
/* 475 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValidationResultList validate() {
/* 481 */     return validate((IValidationResultList)new ValidationResultList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IValidationResultList validate(IValidationResultList argList) {
/* 489 */     this.focusRequestFieldKey_ = null;
/* 490 */     IEditModelFieldValidatorFactory vFactory = getValidatorFactory();
/* 491 */     for (String fieldKey : getFieldKeys()) {
/* 492 */       IEditModelFieldValidator validator = (vFactory != null) ? vFactory.getValidator(fieldKey) : null;
/*     */       
/* 494 */       if (validator == null || validator.runModelValidation()) {
/* 495 */         argList.add(validateField(fieldKey));
/*     */       }
/* 497 */       if (validator != null) {
/* 498 */         IEditModelField<?> field = getFieldDef(fieldKey);
/* 499 */         argList.add(validator.validateField(this, field));
/*     */       } 
/*     */     } 
/* 502 */     return argList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public IValidationResult validateField(String argFieldKey) {
/* 509 */     IValidationResult result = IValidationResult.SUCCESS;
/* 510 */     IEditModelField<?> field = getFieldDef(argFieldKey);
/*     */     
/* 512 */     if (!field.isReadOnly() && field.isAvailable()) {
/* 513 */       boolean isRequired = field.getCardinality().isRequired();
/* 514 */       if (isRequired) {
/*     */         Object value;
/*     */         try {
/* 517 */           value = getValue(argFieldKey);
/*     */         }
/* 519 */         catch (Exception ex) {
/* 520 */           return this.helper_.getValueAccessException(this, argFieldKey, ex);
/*     */         } 
/*     */         
/* 523 */         if (value == null || StringUtils.isEmpty(value.toString()) || (value instanceof Collection && ((Collection)value)
/* 524 */           .isEmpty())) {
/* 525 */           internalSetFocusRequestFieldKey(field.getFieldKey());
/* 526 */           result = this.helper_.getRequiredFieldMissing(field);
/*     */         } 
/*     */       } 
/*     */       
/* 530 */       if (!result.isValid()) {
/* 531 */         internalSetFocusRequestFieldKey(field.getFieldKey());
/*     */       }
/*     */     } 
/* 534 */     return result;
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
/*     */   protected final <T> IEditModelField<T> addField(IEditModel argFieldOwner, String argFieldKey, Class<T> argFieldDataType) {
/* 551 */     return addField(argFieldOwner, argFieldKey, argFieldDataType, 2);
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
/*     */   protected <T> IEditModelField<T> addField(IEditModel argFieldOwner, String argFieldKey, Class<T> argFieldDataType, int argAttributes) {
/* 569 */     IEditModel fieldOwner = (argFieldOwner != null) ? argFieldOwner : this;
/* 570 */     return addField(EditModelField.makeFieldDef(fieldOwner, argFieldKey, argFieldDataType, argAttributes));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final <T> IEditModelField<T> addField(IEditModelField<T> argField) {
/* 581 */     String key = argField.getFieldKey();
/* 582 */     IEditModelField<?> previous = this.fields_.put(key, argField);
/* 583 */     if (previous == null) {
/* 584 */       this.fieldNames_.add(key);
/*     */     } else {
/*     */       
/* 587 */       logger_.debug("Overriding field definition of '" + key + "' in " + getClass().getName());
/*     */     } 
/* 589 */     argField.setUser(this.user_);
/* 590 */     this._changeManager.addField(argField);
/*     */     
/* 592 */     return argField;
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
/*     */   protected final <T> IEditModelField<T> addField(String argFieldKey, Class<T> argFieldDataType) {
/* 605 */     return addField(this, argFieldKey, argFieldDataType, 2);
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
/*     */   protected final <T> IEditModelField<T> addField(String argFieldKey, Class<T> argFieldDataType, int argAttributes) {
/* 621 */     return addField(this, argFieldKey, argFieldDataType, argAttributes);
/*     */   }
/*     */   
/*     */   protected IEditModelSetFieldFilterFactory getSetFieldFilterFactory() {
/* 625 */     return this._setFieldFilterFactory;
/*     */   }
/*     */ 
/*     */   
/*     */   protected IEditModelFieldValidatorFactory getValidatorFactory() {
/* 630 */     return this._validatorFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initializeFieldValues() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void internalSetFocusRequestFieldKey(String argFieldKey) {
/* 648 */     if (this.focusRequestFieldKey_ == null) {
/* 649 */       this.focusRequestFieldKey_ = argFieldKey;
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
/*     */   protected boolean isDynamicFieldCapable() {
/* 662 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void notifyServices(String argFieldKey, Object argNewValue) {
/* 672 */     List<CompositeObject.TwoPiece<IFieldService, String>> serviceList = this.fieldServices_.getList(argFieldKey.toUpperCase());
/*     */     
/* 674 */     if (serviceList != null)
/* 675 */       for (CompositeObject.TwoPiece<IFieldService, String> element : serviceList)
/* 676 */         ((IFieldService)element.a()).notifyFieldChanged((String)element.b(), argNewValue);  
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\BasicEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */