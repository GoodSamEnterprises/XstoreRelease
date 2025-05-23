/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.form.EditModelFieldMetadata;
/*     */ import dtv.pos.iframework.form.Cardinality;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.IEditModelFieldMetadata;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IndirectField<T>
/*     */   extends EditModelFieldMetadata<T>
/*     */   implements IEditModelField<T>
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(IndirectField.class);
/*     */   protected final IEditModelFieldMetadata directField_;
/*     */   protected final IEditModel parentModel_;
/*     */   
/*     */   public static <T> IndirectField<T> makeFieldDef(IEditModel argEditModel, IEditModelFieldMetadata argDirectField, String argFieldKey, Class<T> argFieldDataType) {
/*  35 */     return new IndirectField<>(argEditModel, argDirectField, argFieldKey, argFieldDataType, 4, null, null, null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<T> possibleValueOverrides_;
/*     */ 
/*     */   
/*     */   private Comparator<Object> _possibleValuesComparator;
/*     */ 
/*     */   
/*     */   private ICardinality cardinality_;
/*     */ 
/*     */   
/*     */   private IndirectField(IEditModel argEditModel, IEditModelFieldMetadata argDirectField, String argFieldKey, Class<T> argFieldDataType, int argAttributes, ICardinality argCardinality, List<T> argPossibleValues, IListFieldElementDescr argFieldElementDescriptor, IValueWrapperFactory argValueWrapper, IFormattable argFieldName) {
/*  50 */     super(argFieldKey, argFieldDataType, argAttributes, argCardinality, argPossibleValues, argFieldElementDescriptor, argValueWrapper, argFieldName, (ISecuredObjectID)null);
/*     */ 
/*     */     
/*  53 */     this.parentModel_ = argEditModel;
/*  54 */     this.directField_ = argDirectField;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ICardinality getCardinality() {
/*  60 */     if (this.cardinality_ == null) {
/*  61 */       return super.getCardinality();
/*     */     }
/*  63 */     return this.cardinality_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<Object> getCurrentComparator() {
/*  69 */     return this._possibleValuesComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getElements() {
/*  75 */     return getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<T> getEnumeratedPossibleValues() {
/*  81 */     return (this.possibleValueOverrides_ != null) ? Collections.<T>unmodifiableList(this.possibleValueOverrides_) : super
/*  82 */       .getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getValue() {
/*  88 */     Object o = getIndirectTarget();
/*  89 */     if (o == null) {
/*  90 */       return null;
/*     */     }
/*  92 */     return (T)getValue(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValueAsString() {
/*  98 */     Object o = getIndirectTarget();
/*  99 */     if (o == null) {
/* 100 */       return null;
/*     */     }
/* 102 */     return getValueAsString(o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasDependency() {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 118 */     return isReadOnly(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void makeRequired() {
/* 123 */     setRequired(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void refreshValue() {}
/*     */ 
/*     */   
/*     */   public final void setCardinality(ICardinality argCardinality) {
/* 131 */     this.cardinality_ = argCardinality;
/* 132 */     this.events_.post(EditModelFieldChangeType.CARDINALITY_CHANGED, argCardinality);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentComparator(Comparator<Object> argComparator) {
/* 138 */     this._possibleValuesComparator = argComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElements(List<?> argElems) {
/* 144 */     List<T> ridiculousCast = (List)argElems;
/* 145 */     setEnumeratedPossibleValues(ridiculousCast);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnumeratedPossibleValues(List<T> newValue) {
/* 150 */     this.possibleValueOverrides_ = newValue;
/* 151 */     this.events_.post(EditModelFieldChangeType.ENUMERATION_CHANGED, getEnumeratedPossibleValues());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean newValue) {
/* 157 */     logger_.warn("setReadOnly not supported on transaction fields");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequired(boolean argRequired) {
/* 163 */     this.cardinality_ = Cardinality.makeRequired(this.cardinality_, argRequired);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(ISystemUser argUser) {
/* 169 */     super.setUser(argUser);
/* 170 */     this.directField_.setUser(argUser);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object argValue) {
/* 176 */     logger_.warn("setValue not supported on transaction fields");
/*     */   }
/*     */   
/*     */   private Object getIndirectTarget() {
/* 180 */     return this.directField_.getValue(this.parentModel_);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\IndirectField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */