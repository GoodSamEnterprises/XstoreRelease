/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.security.SecurityUtil;
/*     */ import dtv.pos.iframework.form.EditModelException;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IEditModelFieldMetadata;
/*     */ import dtv.pos.iframework.form.IEditModelFieldValidationInfo;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*     */ import dtv.pos.iframework.security.AccessType;
/*     */ import dtv.pos.iframework.security.IAcl;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.pos.iframework.security.SecuredObjectID;
/*     */ import dtv.util.ReflectionException;
/*     */ import dtv.util.StringTrimType;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class EditModelFieldMetadata<T>
/*     */   implements IEditModelFieldMetadata<T>
/*     */ {
/*  38 */   protected static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*  40 */   private static final Logger logger_ = Logger.getLogger(EditModelFieldMetadata.class);
/*     */   
/*     */   protected static boolean hasAttribute(int i1, int i2) {
/*  43 */     return ((i1 & i2) != 0);
/*     */   }
/*     */   
/*     */   private static IFormattable getDefaultName(String argFieldKey) {
/*  47 */     return FF.getTranslatable("_editField_" + argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   protected final Eventor events_ = (Eventor)new DefaultEventor((IEventSource)this);
/*     */   
/*     */   protected final IAcl acl_;
/*     */   
/*     */   protected final Class<T> dataType_;
/*     */   
/*     */   protected final String fieldKey_;
/*     */   
/*     */   protected final IFormattable fieldName_;
/*     */   
/*     */   protected final IListFieldElementDescr fieldElementDescriptor_;
/*     */   
/*  69 */   protected ISystemUser user_ = null;
/*     */   protected IValueWrapperFactory wrapperFactory_;
/*     */   private final ICardinality cardinality_;
/*  72 */   protected int attributes_ = 0;
/*     */   
/*     */   protected boolean readAuthorized_ = false;
/*     */   protected boolean updateAuthorized_ = false;
/*     */   protected boolean createAuthorized_ = false;
/*  77 */   private final StringTrimType trimType_ = StringTrimType.FULL;
/*     */   
/*  79 */   private IEditModelFieldValidationInfo validationInfo_ = new EditModelFieldValidationInfo();
/*     */   
/*     */   private String getterName_;
/*     */   
/*     */   private String setterName_;
/*     */   
/*     */   private Class<?>[] getterParamClasses_;
/*     */   
/*     */   private Class<?>[] setterParamClasses_;
/*     */   
/*     */   public EditModelFieldMetadata(IDataEditFieldConfig argConfig, int argAttributes) {
/*  90 */     this(argConfig.getFieldKey(), argConfig.getDataType(), argAttributes, argConfig
/*  91 */         .getCardinality(), argConfig.getPossibleValues(), (IListFieldElementDescr)null, argConfig
/*  92 */         .getWrapperFactory(), argConfig.getFieldName(), argConfig.getSecuredObject());
/*     */   }
/*     */   private Object[] getterParams_; private Object[] setterParams_; private List<? extends T> possibleValues_;
/*     */   @Inject
/*     */   private SecurityUtil _securityUtil;
/*     */   
/*     */   public EditModelFieldMetadata(String argFieldKey, Class<T> argFieldDataType, int argAttributes, ICardinality argCardinality, List<? extends T> argPossibleValues, IListFieldElementDescr argFieldElementDescriptor, IValueWrapperFactory argValueWrapper, IFormattable argFieldName, ISecuredObjectID argSecuredObjectID) {
/*  99 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/* 101 */     this.fieldKey_ = argFieldKey;
/* 102 */     this.attributes_ = argAttributes;
/* 103 */     this.dataType_ = argFieldDataType;
/* 104 */     this.cardinality_ = nonNull(argCardinality, ICardinality.OPTIONAL);
/* 105 */     this.wrapperFactory_ = argValueWrapper;
/* 106 */     this.fieldName_ = (argFieldName != null) ? argFieldName : getDefaultName(argFieldKey);
/*     */     
/* 108 */     this.possibleValues_ = argPossibleValues;
/*     */ 
/*     */     
/* 111 */     IAcl temp = null;
/*     */ 
/*     */     
/*     */     try {
/* 115 */       temp = (argSecuredObjectID != null) ? this._securityUtil.getAcl(argSecuredObjectID) : this._securityUtil.getAcl((ISecuredObjectID)SecuredObjectID.DEFAULT);
/*     */     }
/* 117 */     catch (Error ex) {
/* 118 */       logger_.error(ex);
/*     */     } 
/*     */     
/* 121 */     this.acl_ = temp;
/* 122 */     this.fieldElementDescriptor_ = argFieldElementDescriptor;
/*     */     
/* 124 */     if (this.possibleValues_ == null && this.fieldElementDescriptor_ == null && this.cardinality_.isArray()) {
/* 125 */       logger_.warn("no element field definition nor possible values list...should provide one or the other");
/*     */     }
/*     */     
/* 128 */     if (this.wrapperFactory_ != null && this.possibleValues_ == null) {
/* 129 */       logger_.debug("no possible values, but we do have a value wrapper...could be a problem");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EditModelFieldMetadata(Map<String, IDataObjectDefinitionConfig> argObjectMap, IDataEditFieldConfig argConfig, int argAttributes) {
/* 137 */     this(argConfig.getFieldKey(), argConfig.getDataType(), argAttributes, argConfig
/* 138 */         .getCardinality(), argConfig.getPossibleValues(), (argConfig
/* 139 */         .getCardinality().isArray() && argConfig.getPossibleValues() == null) ? argConfig
/* 140 */         .makeFieldElementDescriptor(argObjectMap) : null, argConfig
/* 141 */         .getWrapperFactory(), argConfig.getFieldName(), argConfig.getSecuredObject());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICardinality getCardinality() {
/* 147 */     return this.cardinality_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<T> getDataType() {
/* 153 */     return this.dataType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<T> getEnumeratedPossibleValues() {
/* 159 */     return (this.possibleValues_ != null) ? Collections.<T>unmodifiableList(this.possibleValues_) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListFieldElementDescr getFieldElementDescriptor() {
/* 165 */     if (!getCardinality().isArray()) {
/* 166 */       return null;
/*     */     }
/*     */     
/* 169 */     if (this.fieldElementDescriptor_ == null) {
/* 170 */       logger_.warn("returning null field element descriptor");
/*     */     }
/* 172 */     return this.fieldElementDescriptor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldKey() {
/* 179 */     return this.fieldKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFieldName() {
/* 185 */     return this.fieldName_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEditModelFieldValidationInfo getValidationInfo() {
/* 191 */     return this.validationInfo_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getValue(Object argTarget) {
/* 198 */     lookupAccesorFields(argTarget);
/*     */     try {
/* 200 */       Method getter_ = argTarget.getClass().getMethod(this.getterName_, this.getterParamClasses_);
/* 201 */       return isReadAuthorized() ? (T)getter_.invoke(argTarget, this.getterParams_) : null;
/*     */     }
/* 203 */     catch (InvocationTargetException ex) {
/* 204 */       throw new ReflectionException(ex);
/*     */     }
/* 206 */     catch (IllegalArgumentException ex) {
/* 207 */       throw new ReflectionException(ex);
/*     */     }
/* 209 */     catch (IllegalAccessException ex) {
/* 210 */       throw new ReflectionException(ex);
/*     */     }
/* 212 */     catch (SecurityException ex) {
/* 213 */       throw new ReflectionException(ex);
/*     */     }
/* 215 */     catch (NoSuchMethodException ex) {
/* 216 */       throw new ReflectionException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString(Object argTarget) {
/*     */     try {
/* 224 */       Object o = getValue(argTarget);
/* 225 */       if (o == null) {
/* 226 */         return null;
/*     */       }
/* 228 */       String value = String.valueOf(o);
/* 229 */       return StringUtils.trim(value, this.trimType_);
/*     */     }
/* 231 */     catch (Exception ex) {
/* 232 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 233 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getValueWrapper() {
/* 240 */     return this.wrapperFactory_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable() {
/* 246 */     return isReadAuthorized() ? getCardinality().isAvailable() : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(boolean argIsNew) {
/* 252 */     return argIsNew ? ((
/* 253 */       hasAttribute(this.attributes_, 4) || !this.createAuthorized_)) : ((
/* 254 */       hasAttribute(this.attributes_, 4) || !this.updateAuthorized_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecured() {
/* 260 */     return (this.acl_ != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(ISystemUser argUser) {
/* 266 */     if (this.user_ != argUser) {
/* 267 */       this.user_ = argUser;
/* 268 */       updateSecurity();
/* 269 */       if (this.fieldElementDescriptor_ != null) {
/* 270 */         this.fieldElementDescriptor_.setUser(argUser);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValidationInfo(IEditModelFieldValidationInfo argValidationInfo) {
/* 282 */     this.validationInfo_ = argValidationInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(T argValue, Object argTarget, boolean argIsNew) {
/* 288 */     lookupAccesorFields(argTarget);
/*     */ 
/*     */     
/* 291 */     if (isReadOnly(argIsNew)) {
/* 292 */       throw new EditModelException("the field [" + this.fieldKey_ + "] is read only");
/*     */     }
/*     */     
/*     */     try {
/* 296 */       Object[] params = this.setterParams_;
/* 297 */       params[params.length - 1] = argValue;
/*     */ 
/*     */       
/* 300 */       if (this.dataType_ == String.class && argValue != null) {
/* 301 */         String s = StringUtils.trim(String.valueOf(argValue), this.trimType_);
/* 302 */         if (s.length() == 0) {
/* 303 */           s = null;
/*     */         }
/* 305 */         params[params.length - 1] = s;
/*     */       } 
/*     */       
/* 308 */       if (this.setterName_ != null) {
/* 309 */         Method setter = argTarget.getClass().getMethod(this.setterName_, this.setterParamClasses_);
/* 310 */         setter.invoke(argTarget, params);
/*     */       }
/*     */     
/* 313 */     } catch (InvocationTargetException ex) {
/* 314 */       throw new ReflectionException("problem setting field [" + this.fieldKey_ + "] with [" + ((argValue == null) ? "null" : argValue) + "] of type " + ((argValue == null) ? "null" : argValue
/*     */           
/* 316 */           .getClass().getName()) + " on [" + argTarget + "]", ex);
/*     */     }
/* 318 */     catch (IllegalArgumentException ex) {
/* 319 */       logger_.error("problem setting field [" + this.fieldKey_ + "] with [" + ((argValue == null) ? "null" : argValue) + "] of type " + ((argValue == null) ? "null" : argValue
/*     */           
/* 321 */           .getClass().getName()) + " on [" + argTarget + "]", ex);
/* 322 */       throw ex;
/*     */     }
/* 324 */     catch (Exception ex) {
/* 325 */       throw new EditModelException("problem setting field [" + this.fieldKey_ + "] with [" + ((argValue == null) ? "null" : argValue) + "] of type " + ((argValue == null) ? "null" : argValue
/*     */           
/* 327 */           .getClass().getName()) + " on [" + argTarget + "]", ex);
/*     */     } 
/* 329 */     this.events_.post(EditModelFieldChangeType.VALUE_CHANGED, argValue);
/*     */   }
/*     */   
/*     */   protected boolean isReadAuthorized() {
/* 333 */     return this.readAuthorized_;
/*     */   }
/*     */   
/*     */   protected void lookupAccesorFields(Object argTarget) {
/* 337 */     if (this.getterName_ != null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 341 */       String[] fieldParts = this.fieldKey_.split("::");
/* 342 */       int fieldPartCount = fieldParts.length;
/* 343 */       this.getterParamClasses_ = new Class[fieldPartCount - 1];
/* 344 */       this.getterParams_ = new Object[fieldPartCount - 1];
/* 345 */       this.setterParamClasses_ = new Class[fieldPartCount];
/* 346 */       this.setterParams_ = new Object[fieldPartCount];
/*     */       
/* 348 */       this.setterParamClasses_[fieldPartCount - 1] = this.dataType_;
/* 349 */       for (int i = 1; i < fieldPartCount; i++) {
/* 350 */         this.getterParamClasses_[i - 1] = String.class;
/* 351 */         this.getterParams_[i - 1] = fieldParts[i];
/*     */         
/* 353 */         this.setterParamClasses_[i - 1] = String.class;
/* 354 */         this.setterParams_[i - 1] = fieldParts[i];
/*     */       } 
/*     */       
/* 357 */       this.getterName_ = makeGetterName(fieldParts[0]);
/*     */       
/* 359 */       argTarget.getClass().getMethod(this.getterName_, this.getterParamClasses_);
/*     */       
/* 361 */       if (hasAttribute(this.attributes_, 4) || hasAttribute(this.attributes_, 8)) {
/* 362 */         this.setterName_ = null;
/*     */       } else {
/*     */         
/* 365 */         this.setterName_ = makeSetterName(fieldParts[0]);
/*     */         
/* 367 */         argTarget.getClass().getMethod(this.setterName_, this.setterParamClasses_);
/*     */       }
/*     */     
/* 370 */     } catch (Exception ex) {
/* 371 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 372 */       throw new IllegalArgumentException("problem finding field getter and setter methods [fieldKey=" + this.fieldKey_ + ",editModelClass=" + argTarget
/* 373 */           .getClass().getName() + "] (Is this a key field that is not configured in the <key_fields> section?)");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String makeGetterName(String argFieldName) {
/* 380 */     StringBuffer sb = new StringBuffer("get");
/* 381 */     sb.append(argFieldName.toUpperCase().charAt(0));
/* 382 */     sb.append(argFieldName.substring(1));
/* 383 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private String makeSetterName(String argFieldName) {
/* 388 */     StringBuffer sb = new StringBuffer("set");
/* 389 */     sb.append(argFieldName.toUpperCase().charAt(0));
/* 390 */     sb.append(argFieldName.substring(1));
/* 391 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private ICardinality nonNull(ICardinality argCardinality, ICardinality argDefault) {
/* 395 */     if (argCardinality == null) {
/* 396 */       return argDefault;
/*     */     }
/* 398 */     return argCardinality;
/*     */   }
/*     */   
/*     */   private void updateSecurity() {
/* 402 */     if (this.acl_ == null) {
/* 403 */       this.readAuthorized_ = true;
/* 404 */       this.createAuthorized_ = true;
/* 405 */       this.updateAuthorized_ = true;
/*     */     } else {
/*     */       
/* 408 */       this.readAuthorized_ = this.acl_.authorize(this.user_, AccessType.READ);
/* 409 */       this.createAuthorized_ = this.acl_.authorize(this.user_, AccessType.CREATE);
/* 410 */       this.updateAuthorized_ = this.acl_.authorize(this.user_, AccessType.UPDATE);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelFieldMetadata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */