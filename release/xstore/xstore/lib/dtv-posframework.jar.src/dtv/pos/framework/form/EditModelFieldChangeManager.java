/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.WeakReference;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.lang.ref.Reference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class EditModelFieldChangeManager
/*     */ {
/*  32 */   private static final Logger logger_ = Logger.getLogger(EditModelFieldChangeManager.class);
/*  33 */   private static final boolean isDebugEnabled_ = logger_.isDebugEnabled();
/*     */   
/*     */   private final Map<IEditModelField<?>, FieldChangeData> fieldChangeMap_;
/*     */   
/*     */   private boolean initialized_;
/*     */   
/*  39 */   private final EventHandler changeHandler_ = new EventHandler()
/*     */     {
/*     */       protected void handle(Event argEvent)
/*     */       {
/*  43 */         if (EditModelFieldChangeManager.this.initialized_) {
/*  44 */           IEditModelField<?> field = (IEditModelField)argEvent.getSource(IEditModelField.class);
/*  45 */           if (field != null) {
/*  46 */             EditModelFieldChangeManager.FieldChangeData data = (EditModelFieldChangeManager.FieldChangeData)EditModelFieldChangeManager.this.fieldChangeMap_.get(field);
/*  47 */             if (data != null)
/*     */             {
/*     */               
/*  50 */               Object newValue = argEvent.getPayload();
/*  51 */               data.hasChanged_ = !ObjectUtils.equivalent(newValue, data.savedValue_, true);
/*     */               
/*  53 */               if (EditModelFieldChangeManager.isDebugEnabled_) {
/*  54 */                 EditModelFieldChangeManager.logger_.debug(field + ": hasChanged? = " + data.hasChanged_ + " ([" + (
/*  55 */                     StringUtils.isPossibleCreditCardNumber(newValue) ? "REDACTED" : newValue) + "]/[" + data.savedValue_ + "])");
/*     */               }
/*     */             }
/*     */           
/*     */           }
/*     */         
/*  61 */         } else if (EditModelFieldChangeManager.isDebugEnabled_) {
/*  62 */           EditModelFieldChangeManager.logger_.debug("Ignoring event [" + argEvent + "] -- manager not yet initialized.");
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */   
/*     */   EditModelFieldChangeManager() {
/*  72 */     InjectionHammer.forceAtInjectProcessing(this);
/*  73 */     this.initialized_ = false;
/*  74 */     this.fieldChangeMap_ = Collections.synchronizedMap(new WeakHashMap<>());
/*     */   }
/*     */ 
/*     */   
/*     */   void addField(IEditModelField<?> argField) {
/*  79 */     this.fieldChangeMap_.put(argField, new FieldChangeData(argField));
/*  80 */     this._eventManager.registerEventHandler((IEventAware)this.changeHandler_, (IEventSource)argField, EditModelFieldChangeType.VALUE_CHANGED.toConstraint());
/*     */     
/*  82 */     if (isDebugEnabled_) {
/*  83 */       logger_.debug(argField + ": added to change manager");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean commitChanges(boolean argIgnoreChangeState) {
/*  91 */     boolean anyChanged = false;
/*  92 */     for (FieldChangeData data : this.fieldChangeMap_.values()) {
/*  93 */       if (commitChangesImpl(data.field_.get(), data, argIgnoreChangeState)) {
/*  94 */         anyChanged = true;
/*     */       }
/*     */     } 
/*  97 */     return anyChanged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean commitChanges(IEditModelField<?> argField, boolean argIgnoreChangeState) {
/* 104 */     return commitChangesImpl(argField, this.fieldChangeMap_.get(argField), argIgnoreChangeState);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Collection<IEditModelField<?>> getChangedFields() {
/* 110 */     Collection<IEditModelField<?>> changedFields = new ArrayList<>();
/*     */     
/* 112 */     for (FieldChangeData data : this.fieldChangeMap_.values()) {
/* 113 */       IEditModelField<?> field = data.field_.get();
/* 114 */       if (isDebugEnabled_) {
/* 115 */         logger_.debug(field + ": hasChanged? = " + data.hasChanged_);
/*     */       }
/*     */       
/* 118 */       if (field != null && data.hasChanged_) {
/* 119 */         changedFields.add(field);
/*     */       }
/*     */     } 
/* 122 */     return changedFields;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasChanged(IEditModelField<?> argField) {
/* 130 */     FieldChangeData data = this.fieldChangeMap_.get(argField);
/* 131 */     return (data != null) ? data.hasChanged_ : false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void initialize() {
/*     */     
/* 142 */     try { commitChanges(true); }
/*     */     
/* 144 */     catch (Exception exception) {  }
/*     */     finally
/* 146 */     { this.initialized_ = true;
/* 147 */       logger_.debug("INITIALIZED"); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   void removeField(IEditModelField<?> argField) {
/* 153 */     this._eventManager.deregisterEventHandler((IEventAware)this.changeHandler_, (IEventSource)argField);
/* 154 */     this.fieldChangeMap_.remove(argField);
/*     */     
/* 156 */     if (isDebugEnabled_) {
/* 157 */       logger_.debug(argField + ": removed from change manager");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void revertChanges(boolean argIgnoreChangeState) {
/* 166 */     for (FieldChangeData data : this.fieldChangeMap_.values()) {
/* 167 */       revertChangesImpl(data.field_.get(), data, argIgnoreChangeState);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void revertChanges(IEditModelField<?> argField, boolean argIgnoreChangeState) {
/* 176 */     revertChangesImpl(argField, this.fieldChangeMap_.get(argField), argIgnoreChangeState);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean commitChangesImpl(IEditModelField<?> argField, FieldChangeData argChangeData, boolean argIgnoreChangeState) {
/* 183 */     boolean anyChanged = false;
/*     */     
/* 185 */     if (argField != null && argChangeData != null && (argIgnoreChangeState || argChangeData.hasChanged_)) {
/* 186 */       anyChanged = true;
/* 187 */       argChangeData.setSavedValue(argField.getValue());
/* 188 */       argChangeData.hasChanged_ = false;
/*     */       
/* 190 */       if (isDebugEnabled_) {
/* 191 */         logger_.debug(argField + ": committing field change value to [" + argChangeData.savedValue_ + "]");
/*     */       }
/*     */     } 
/* 194 */     return anyChanged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void revertChangesImpl(IEditModelField argField, FieldChangeData argChangeData, boolean argIgnoreChangeState) {
/* 202 */     if (argField != null && argChangeData != null && (argIgnoreChangeState || argChangeData.hasChanged_)) {
/*     */ 
/*     */       
/* 205 */       argField.setValue(argChangeData.savedValue_);
/* 206 */       argChangeData.hasChanged_ = false;
/*     */       
/* 208 */       if (isDebugEnabled_) {
/* 209 */         logger_.debug(argField + ": reverting field value to [" + argChangeData.savedValue_ + "]");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static class FieldChangeData
/*     */   {
/*     */     final Reference<IEditModelField<?>> field_;
/*     */     
/*     */     Object savedValue_;
/*     */     
/*     */     boolean hasChanged_;
/*     */     
/*     */     FieldChangeData(IEditModelField<?> argField) {
/* 224 */       this.field_ = (Reference<IEditModelField<?>>)new WeakReference(argField);
/* 225 */       this.savedValue_ = null;
/* 226 */       this.hasChanged_ = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 232 */       return (new StringBuilder()).append(this.field_.get()).append("=[").append(this.hasChanged_).append("]").append(String.valueOf(this.savedValue_)).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSavedValue(Object argNewValue) {
/* 239 */       this.savedValue_ = convertNewValue(argNewValue);
/*     */     }
/*     */ 
/*     */     
/*     */     private Object convertNewValue(Object<Object> argNewValue) {
/* 244 */       Object<Object> convertedValue = argNewValue;
/*     */       
/* 246 */       if (argNewValue instanceof Collection) {
/* 247 */         Collection<?> newValues = (Collection)argNewValue;
/* 248 */         Collection<Object> newInstance = FormUtils.createInstance(newValues);
/* 249 */         newInstance.addAll(newValues);
/*     */         
/* 251 */         convertedValue = (Object<Object>)newInstance;
/*     */       } 
/* 253 */       return convertedValue;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelFieldChangeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */