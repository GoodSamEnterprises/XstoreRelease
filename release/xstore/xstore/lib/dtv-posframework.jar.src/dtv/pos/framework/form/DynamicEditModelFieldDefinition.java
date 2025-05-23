/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.IEditModelFieldValidationInfo;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
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
/*     */ public class DynamicEditModelFieldDefinition<T>
/*     */   implements IEditModelField<T>, IMutableFieldDefinition<T>
/*     */ {
/*     */   private final Class<T> dataType_;
/*     */   private final String fieldKey_;
/*  30 */   private final Eventor events_ = (Eventor)new DefaultEventor((IEventSource)this);
/*     */   
/*  32 */   private ICardinality cardinality_ = ICardinality.OPTIONAL;
/*     */   private boolean isReadOnly_ = false;
/*     */   private T value_;
/*     */   private T valueHolder_;
/*     */   private List<T> possibleValues_;
/*     */   private Comparator<Object> _currentComparator;
/*     */   
/*     */   public DynamicEditModelFieldDefinition(IEditModel argParent, String argFieldKey, Class<T> argDataType) {
/*  40 */     this.fieldKey_ = argFieldKey;
/*  41 */     this.dataType_ = argDataType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICardinality getCardinality() {
/*  47 */     return this.cardinality_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<Object> getCurrentComparator() {
/*  53 */     return this._currentComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<T> getDataType() {
/*  59 */     return this.dataType_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getElements() {
/*  65 */     return getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<T> getEnumeratedPossibleValues() {
/*  71 */     return this.possibleValues_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListFieldElementDescr getFieldElementDescriptor() {
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldKey() {
/*  83 */     return this.fieldKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getFieldName() {
/*  89 */     return FormattableFactory.getInstance().getTranslatable("_" + this.fieldKey_ + "FieldName");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEditModelFieldValidationInfo getValidationInfo() {
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getValue() {
/* 101 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getValue(Object argTarget) {
/* 107 */     return this.value_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString() {
/* 113 */     return (this.value_ != null) ? this.value_.toString() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString(Object argTarget) {
/* 119 */     return getValueAsString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getValueWrapper() {
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDependency() {
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable() {
/* 143 */     return this.cardinality_.isAvailable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 149 */     return this.isReadOnly_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(boolean isNew) {
/* 155 */     return isReadOnly();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecured() {
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeRequired() {
/* 167 */     setRequired(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeValue() {
/* 173 */     this.valueHolder_ = this.value_;
/* 174 */     this.value_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCardinality(ICardinality argCardinality) {
/* 180 */     this.cardinality_ = argCardinality;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentComparator(Comparator<Object> argComparator) {
/* 186 */     this._currentComparator = argComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElements(List<?> argElems) {
/* 193 */     List<T> ridiculousCast = (List)argElems;
/* 194 */     setEnumeratedPossibleValues(ridiculousCast);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnumeratedPossibleValues(List<T> argValues) {
/* 200 */     if (argValues == null && this.possibleValues_ != null) {
/* 201 */       this.possibleValues_ = Collections.emptyList();
/*     */     } else {
/*     */       
/* 204 */       this.possibleValues_ = argValues;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean argReadOnly) {
/* 211 */     this.isReadOnly_ = argReadOnly;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean argRequired) {
/* 217 */     if (argRequired) {
/* 218 */       this.cardinality_ = ICardinality.REQUIRED;
/*     */     } else {
/*     */       
/* 221 */       this.cardinality_ = ICardinality.OPTIONAL;
/*     */     } 
/*     */   }
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
/*     */   public void setValue(T argValue) {
/* 235 */     this.value_ = argValue;
/* 236 */     this.events_.post(EditModelFieldChangeType.VALUE_CHANGED, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(T argValue, Object argTarget, boolean argIsNew) {
/* 242 */     setValue(argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 248 */     return "Field[" + this.fieldKey_ + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unremoveValue() {
/* 254 */     this.value_ = this.valueHolder_;
/* 255 */     this.valueHolder_ = null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DynamicEditModelFieldDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */