/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelFieldMetadata;
/*     */ import dtv.pos.iframework.form.IEditModelTableModelAdapter;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import java.util.List;
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
/*     */ public class DefaultEditModelTableModelAdapter
/*     */   implements IEditModelTableModelAdapter
/*     */ {
/*  23 */   private static final Logger logger_ = Logger.getLogger(DefaultEditModelTableModelAdapter.class);
/*     */ 
/*     */   
/*     */   private final IEditModel parentEditModel_;
/*     */ 
/*     */   
/*     */   private final String fieldKey_;
/*     */ 
/*     */   
/*     */   private final List<IDataModel> values_;
/*     */ 
/*     */   
/*     */   private final IListFieldElementDescr elementDescriptor_;
/*     */ 
/*     */   
/*     */   private boolean isRowAddingAllowed_ = true;
/*     */ 
/*     */   
/*     */   public DefaultEditModelTableModelAdapter(IEditModel argParentEditModel, String argFieldKey, List<IDataModel> argValues, IListFieldElementDescr argElementDescriptor) {
/*  42 */     if (argParentEditModel == null) {
/*  43 */       throw new NullPointerException("argParentEditModel is null");
/*     */     }
/*  45 */     if (argFieldKey == null) {
/*  46 */       throw new NullPointerException("argFieldKey is null");
/*     */     }
/*  48 */     if (argValues == null) {
/*  49 */       throw new NullPointerException("argValues is null");
/*     */     }
/*  51 */     if (argElementDescriptor == null) {
/*  52 */       throw new NullPointerException("argElementDescriptor is null");
/*     */     }
/*  54 */     this.parentEditModel_ = argParentEditModel;
/*  55 */     this.fieldKey_ = argFieldKey;
/*  56 */     this.values_ = argValues;
/*  57 */     this.elementDescriptor_ = argElementDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addRow() {
/*  67 */     if (this.parentEditModel_ instanceof DaoEditModel) {
/*  68 */       this.elementDescriptor_.addInstance(this.parentEditModel_, this.values_);
/*     */     } else {
/*     */       
/*  71 */       this.elementDescriptor_.addInstance(this.parentEditModel_, this.values_);
/*     */     } 
/*  73 */     return this.values_.size() - 1;
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
/*     */   public Class<?> getColumnClass(int columnIndex) {
/*  85 */     return this.elementDescriptor_.getFieldMetadata()[columnIndex].getDataType();
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
/*     */   public int getColumnCount() {
/*  97 */     if (this.elementDescriptor_ == null) {
/*  98 */       return 0;
/*     */     }
/* 100 */     IEditModelFieldMetadata[] a = this.elementDescriptor_.getFieldMetadata();
/* 101 */     if (a == null) {
/* 102 */       return 0;
/*     */     }
/*     */     
/* 105 */     return a.length;
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
/*     */   public IFormattable getColumnName(int columnIndex) {
/* 118 */     return this.elementDescriptor_.getFieldMetadata()[columnIndex].getFieldName();
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
/*     */   public List getEnumeratedPossibleValuesAt(int columnIndex) {
/* 130 */     return this.elementDescriptor_.getFieldMetadata()[columnIndex].getEnumeratedPossibleValues();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldKey(int columnIndex) {
/* 141 */     return this.elementDescriptor_.getFieldMetadata()[columnIndex].getFieldKey();
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
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/*     */     try {
/* 154 */       Object rowValue = this.values_.get(rowIndex);
/* 155 */       return this.elementDescriptor_.getFieldMetadata()[columnIndex].getValue(rowValue);
/*     */     }
/* 157 */     catch (Exception ex) {
/* 158 */       logger_.warn("CAUGHT EXCEPTION", ex);
/* 159 */       return null;
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
/*     */   public List getValues() {
/* 172 */     return this.values_;
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
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 185 */     if (rowIndex >= this.values_.size()) {
/* 186 */       logger_.warn("out of range!!", new Throwable("STACK TRACE"));
/* 187 */       return false;
/*     */     } 
/* 189 */     Object o = this.values_.get(rowIndex);
/* 190 */     boolean isNew = true;
/* 191 */     if (o instanceof IDataModel) {
/* 192 */       isNew = ((IDataModel)o).isNew();
/*     */     }
/* 194 */     return !this.elementDescriptor_.getFieldMetadata()[columnIndex].isReadOnly(isNew);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRowAddingAllowed() {
/* 204 */     return this.isRowAddingAllowed_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowAddingAllowed(boolean newValue) {
/* 214 */     this.isRowAddingAllowed_ = newValue;
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
/*     */   public void setValueAt(Object argValue, int rowIndex, int columnIndex) throws IllegalAccessException {
/* 232 */     Object rowValue = this.values_.get(rowIndex);
/* 233 */     boolean isNew = false;
/* 234 */     if (rowValue instanceof IDataModel) {
/* 235 */       isNew = ((IDataModel)rowValue).isNew();
/*     */     }
/* 237 */     IEditModelFieldMetadata fieldMetaData = this.elementDescriptor_.getFieldMetadata()[columnIndex];
/* 238 */     fieldMetaData.setValue(argValue, rowValue, isNew);
/*     */     
/* 240 */     updateEditModelList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValues(List<IDataModel> newValues) {
/* 250 */     if (!this.values_.equals(newValues)) {
/* 251 */       this.values_.clear();
/* 252 */       if (newValues != null) {
/* 253 */         this.values_.addAll(newValues);
/*     */       }
/* 255 */       updateEditModelList();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateEditModelList() {
/*     */     try {
/* 261 */       if (this.parentEditModel_ != null && !this.parentEditModel_.isReadOnly(this.fieldKey_)) {
/* 262 */         this.parentEditModel_.setValue(this.fieldKey_, this.values_);
/*     */       }
/*     */     }
/* 265 */     catch (Exception ex) {
/* 266 */       logger_.error("Exception writing data back to edit model ", ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\DefaultEditModelTableModelAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */