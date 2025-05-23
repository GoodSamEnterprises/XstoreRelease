/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.ui.UIModelChangeType;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.model.ISingleSelectionModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.EventListenerList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultFormModel
/*     */   extends AbstractUIModel
/*     */   implements IFormModel
/*     */ {
/*  27 */   public static final EventEnum SET_ENABLED = new EventEnum("setEnabled");
/*  28 */   public static final EventEnum SET_EDITABLE = new EventEnum("setEditable");
/*     */   
/*     */   private final FormKey formKey_;
/*     */   
/*     */   private IEditModel editModel_;
/*     */   
/*     */   private ISingleSelectionModel selectionModel_;
/*     */   
/*     */   private boolean editable_ = true;
/*     */   private boolean enabled_ = true;
/*     */   private DataActionGroupKey actionGroupKey_;
/*     */   private String actionGroupSubKey_;
/*  40 */   protected transient ChangeEvent changeEvent = null;
/*     */ 
/*     */   
/*  43 */   protected EventListenerList listenerList_ = new EventListenerList();
/*     */   
/*     */   private String toString;
/*     */   
/*     */   public DefaultFormModel(FormKey argFormKey) {
/*  48 */     this.formKey_ = argFormKey;
/*     */   }
/*     */   
/*     */   public void addChangeListener(ChangeListener l) {
/*  52 */     this.listenerList_.add(ChangeListener.class, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataActionGroupKey getActionGroupKey() {
/*  57 */     return this.actionGroupKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getActionGroupSubKey() {
/*  62 */     return this.actionGroupSubKey_;
/*     */   }
/*     */   
/*     */   public ChangeListener[] getChangeListeners() {
/*  66 */     return this.listenerList_.<ChangeListener>getListeners(ChangeListener.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public IEditModel getEditModel() {
/*  71 */     return this.editModel_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getFormInstructions() {
/*  76 */     if (this.editModel_ == null) {
/*  77 */       return IFormattable.EMPTY;
/*     */     }
/*  79 */     return this.editModel_.getModelDescription();
/*     */   }
/*     */ 
/*     */   
/*     */   public FormKey getFormKey() {
/*  84 */     return this.formKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFormattable getFormName() {
/*  89 */     if (this.editModel_ == null) {
/*  90 */       return IFormattable.EMPTY;
/*     */     }
/*  92 */     return this.editModel_.getModelTitle();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSelectedTabKeyName() {
/*  97 */     return this.selectionModel_.getSelectedTab();
/*     */   }
/*     */ 
/*     */   
/*     */   public ISingleSelectionModel getSelectionModel() {
/* 102 */     return this.selectionModel_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getUserInput() {
/* 113 */     return this.editModel_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEditable() {
/* 118 */     return this.editable_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEditable(String argFieldName) {
/* 123 */     return (this.editModel_ != null && this.editable_ && !this.editModel_.isReadOnly(argFieldName) && this.editModel_
/* 124 */       .isAvailable(argFieldName));
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 128 */     return this.enabled_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRequired(String argFieldName) {
/* 133 */     if (this.editModel_ == null) {
/* 134 */       return false;
/*     */     }
/* 136 */     return this.editModel_.isRequired(argFieldName);
/*     */   }
/*     */   
/*     */   public void removeChangeListener(ChangeListener l) {
/* 140 */     this.listenerList_.remove(ChangeListener.class, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setActionGroupSubKey(String argActionGroupSubKey) {
/* 145 */     this.actionGroupSubKey_ = argActionGroupSubKey;
/*     */   }
/*     */   
/*     */   public void setEditable(boolean editable) {
/* 149 */     setEditable(editable, true);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 153 */     setEnabled(enabled, true);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled, boolean fireModelChange) {
/* 157 */     if (this.enabled_ != enabled) {
/* 158 */       this.enabled_ = enabled;
/* 159 */       if (fireModelChange) {
/* 160 */         this.events_.post(SET_ENABLED, Boolean.valueOf(enabled));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectionModel(ISingleSelectionModel model) {
/* 167 */     this.selectionModel_ = model;
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
/*     */   public void setUserInput(Object input) {
/* 179 */     this.editModel_ = (IEditModel)input;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(IEditModel editModel, DataActionGroupKey groupKey, boolean argEditable) {
/* 184 */     this.actionGroupKey_ = groupKey;
/*     */ 
/*     */ 
/*     */     
/* 188 */     UIModelChangeType constraint = UIModelChangeType.UPDATED;
/*     */     
/* 190 */     setEditable(argEditable, false);
/* 191 */     if (editModel == null) {
/* 192 */       constraint = UIModelChangeType.CLEARED;
/*     */     }
/* 194 */     this.editModel_ = editModel;
/* 195 */     this.events_.post(constraint, editModel);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 200 */     if (this.toString == null) {
/* 201 */       StringBuffer sb = new StringBuffer();
/* 202 */       sb.append(getClass().getName());
/* 203 */       sb.append("[");
/* 204 */       sb.append(this.formKey_);
/* 205 */       sb.append("]");
/* 206 */       this.toString = sb.toString();
/*     */     } 
/* 208 */     return this.toString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearModelImpl() {
/* 214 */     setValues(null, null, this.editable_);
/*     */   }
/*     */   
/*     */   protected void fireStateChanged() {
/* 218 */     ChangeListener[] listeners = getChangeListeners();
/*     */     
/* 220 */     if (listeners != null) {
/* 221 */       for (ChangeListener listener : listeners) {
/*     */         
/* 223 */         if (this.changeEvent == null) {
/* 224 */           this.changeEvent = new ChangeEvent(this);
/*     */         }
/* 226 */         listener.stateChanged(this.changeEvent);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void setEditable(boolean editable, boolean fireModelChange) {
/* 232 */     if (this.editable_ != editable) {
/* 233 */       this.editable_ = editable;
/* 234 */       if (fireModelChange)
/* 235 */         this.events_.post(SET_EDITABLE, Boolean.valueOf(editable)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultFormModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */