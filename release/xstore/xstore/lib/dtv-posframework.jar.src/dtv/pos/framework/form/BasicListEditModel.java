/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventConstraint;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.ui.model.DefaultListInputModel;
/*     */ import dtv.pos.iframework.form.EditModelException;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.pos.iframework.form.IFieldService;
/*     */ import dtv.pos.iframework.form.IListEditModel;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
/*     */ import dtv.pos.iframework.validation.IValidationResult;
/*     */ import dtv.pos.iframework.validation.IValidationResultList;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.util.IKeyedValue;
/*     */ import dtv.xst.daocommon.ILineItemFilter;
/*     */ import dtv.xst.daocommon.ISystemUser;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import javax.swing.event.ListDataEvent;
/*     */ import javax.swing.event.ListDataListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicListEditModel
/*     */   extends DefaultListInputModel
/*     */   implements IListEditModel<Object>, IEditModel
/*     */ {
/*  38 */   protected static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */ 
/*     */   
/*     */   private static final String VIEW_LIST_FIELD_KEY = "viewList";
/*     */   
/*     */   private final BasicEditModel delegate_;
/*     */   
/*     */   private IFormattable title_;
/*     */   
/*     */   private IFormattable description_;
/*     */ 
/*     */   
/*     */   public BasicListEditModel() {
/*  51 */     this((BasicEditModel)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicListEditModel(BasicEditModel argDelegate) {
/*  61 */     this.delegate_ = (argDelegate != null) ? argDelegate : new BasicEditModel();
/*     */     
/*  63 */     this.title_ = this.delegate_.getModelTitle();
/*  64 */     this.description_ = this.delegate_.getModelDescription();
/*     */     
/*  66 */     addField("viewList", ICombinedListModel.class);
/*  67 */     getModel().addListDataListener(createListDataListener());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean commitChanges() throws EditModelException {
/*  75 */     return this.delegate_.commitChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deregisterFieldHandler(String argFieldKey, IEventAware argHandler) {
/*  81 */     this.delegate_.deregisterFieldHandler(argFieldKey, argHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IKeyedValue<String, ?>> getChanges() {
/*  87 */     return this.delegate_.getChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getDataType(String argFieldKey) {
/*  93 */     return this.delegate_.getDataType(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<?> getEnumeratedPossibleValues(String argFieldKey) {
/*  99 */     return this.delegate_.getEnumeratedPossibleValues(argFieldKey);
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
/*     */   public IEditModelField<?> getFieldDef(String argFieldKey) {
/* 111 */     return this.delegate_.getFieldDef(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListFieldElementDescr getFieldElementDescriptor(String argFieldKey) {
/* 117 */     return this.delegate_.getFieldElementDescriptor(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<String> getFieldKeys() {
/* 123 */     return this.delegate_.getFieldKeys();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFocusRequestFieldKey() {
/* 129 */     return this.delegate_.getFocusRequestFieldKey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getMaximum(String argFieldKey) {
/* 135 */     return this.delegate_.getMaximum(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimum(String argFieldKey) {
/* 141 */     return this.delegate_.getMinimum(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getModelDescription() {
/* 147 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getModelTitle() {
/* 153 */     return this.title_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISystemUser getUser() {
/* 159 */     return this.delegate_.getUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String argFieldKey) throws EditModelException {
/* 167 */     return this.delegate_.getValue(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValueWrapperFactory getValueWrapper(String argFieldKey) {
/* 173 */     return this.delegate_.getValueWrapper(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ICombinedListModel<?> getViewList() {
/* 184 */     return (ICombinedListModel<?>)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasChanges() {
/* 190 */     return this.delegate_.hasChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasFieldChanged(String argFieldKey) {
/* 196 */     return this.delegate_.hasFieldChanged(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeFieldState() {
/* 202 */     this.delegate_.initializeFieldState();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArray(String argFieldKey) {
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable(String argFieldKey) {
/* 214 */     return this.delegate_.isAvailable(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(String argFieldKey) {
/* 220 */     return this.delegate_.isReadOnly(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired(String argFieldKey) {
/* 226 */     return this.delegate_.isRequired(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeRequired(String argFieldKey) {
/* 232 */     this.delegate_.makeRequired(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerFieldHandler(String argFieldKey, IEventAware argHandler, IEventConstraint argConstraint) {
/* 238 */     this.delegate_.registerFieldHandler(argFieldKey, argHandler, argConstraint);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerFieldService(String argFieldKey, IFieldService argService, String argServiceKey) {
/* 244 */     this.delegate_.registerFieldService(argFieldKey, argService, argServiceKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void revertChanges() {
/* 250 */     this.delegate_.revertChanges();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void revertChanges(String argFieldKey) {
/* 256 */     this.delegate_.revertChanges(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldWeight(String argFieldKey, int argFieldWeight) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFocusRequestFieldKey(String argFieldKey) {
/* 266 */     this.delegate_.setFocusRequestFieldKey(argFieldKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemSortComparator(Comparator<IDataModel> argComparator) {
/* 272 */     getLineItemFilter().setItemSortComparator(argComparator);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(ISystemUser argUser) {
/* 278 */     this.delegate_.setUser(argUser);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argFieldKey, Object argValue) throws EditModelException {
/* 285 */     this.delegate_.setValue(argFieldKey, argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setViewList(ICombinedListModel<?> argViewList) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IValidationResultList validate() {
/* 300 */     return this.delegate_.validate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValidationResultList validate(IValidationResultList argList) {
/* 306 */     return this.delegate_.validate(argList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IValidationResult validateField(String argFieldKey) {
/* 312 */     return this.delegate_.validateField(argFieldKey);
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
/*     */   protected final <T> IEditModelField<T> addField(IEditModel argFieldOwner, String argFieldKey, Class<T> argFieldDataType) {
/* 328 */     return this.delegate_.addField(argFieldOwner, argFieldKey, argFieldDataType);
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
/*     */   protected final <T> IEditModelField<T> addField(IEditModel argFieldOwner, String argFieldKey, Class<T> argFieldDataType, int argAttributes) {
/* 345 */     return this.delegate_.addField(argFieldOwner, argFieldKey, argFieldDataType, argAttributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> IEditModelField<T> addField(IEditModelField<T> argField) {
/* 355 */     return this.delegate_.addField(argField);
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
/*     */   protected final <T> IEditModelField<T> addField(String argFieldKey, Class<T> argFieldDataType) {
/* 367 */     return this.delegate_.addField(this, argFieldKey, argFieldDataType);
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
/*     */   protected final <T> IEditModelField<T> addField(String argFieldKey, Class<T> argFieldDataType, int argAttributes) {
/* 381 */     return this.delegate_.addField(this, argFieldKey, argFieldDataType, argAttributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ListDataListener createListDataListener() {
/* 391 */     return new ListDataHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BasicEditModel getDelegateModel() {
/* 399 */     return this.delegate_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ILineItemFilter getLineItemFilter() {
/* 409 */     return NonFilteringFilter.getInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class ListDataHandler
/*     */     implements ListDataListener
/*     */   {
/*     */     public void contentsChanged(ListDataEvent argEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void intervalAdded(ListDataEvent argEvent) {
/* 425 */       int firstIndex = argEvent.getIndex0();
/* 426 */       BasicListEditModel.this.getSelectionModel().setSelectionInterval(firstIndex, firstIndex);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void intervalRemoved(ListDataEvent argEvent) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class NonFilteringFilter
/*     */     implements ILineItemFilter
/*     */   {
/*     */     private static ILineItemFilter instance_;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ILineItemFilter getInstance() {
/* 449 */       if (instance_ == null) {
/* 450 */         instance_ = new NonFilteringFilter();
/*     */       }
/* 452 */       return instance_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<? extends IDataModel> filter(List<? extends IDataModel> argOrigList) {
/* 461 */       return argOrigList;
/*     */     }
/*     */     
/*     */     public void setItemSortComparator(Comparator<IDataModel> argComparator) {}
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\BasicListEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */