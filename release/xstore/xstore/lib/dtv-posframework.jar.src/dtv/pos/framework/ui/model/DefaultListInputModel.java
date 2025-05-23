/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.ui.IDataAccessModifier;
/*     */ import dtv.ui.model.DefaultCombinedListModel;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.model.IListModel;
/*     */ import dtv.ui.model.IListSelectionModel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
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
/*     */ public class DefaultListInputModel
/*     */   extends AbstractUIInputModel
/*     */   implements ICombinedListModel<Object>
/*     */ {
/*     */   private final ICombinedListModel<Object> delegate_;
/*     */   
/*     */   public DefaultListInputModel() {
/*  30 */     this((ICombinedListModel<Object>)new DefaultCombinedListModel());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultListInputModel(IDataAccessModifier argDataModifier) {
/*  40 */     this((ICombinedListModel<Object>)new DefaultCombinedListModel(argDataModifier));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultListInputModel(List<Object> argElems) {
/*  48 */     this((ICombinedListModel<Object>)new DefaultCombinedListModel(argElems));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultListInputModel(List<Object> argElems, IDataAccessModifier argDataModifier) {
/*  59 */     this((ICombinedListModel<Object>)new DefaultCombinedListModel(argElems, argDataModifier));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultListInputModel(Object[] argElems) {
/*  67 */     this((ICombinedListModel<Object>)new DefaultCombinedListModel(argElems));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultListInputModel(Object[] argElems, IDataAccessModifier argDataModifier) {
/*  78 */     this((ICombinedListModel<Object>)new DefaultCombinedListModel(argElems, argDataModifier));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DefaultListInputModel(ICombinedListModel<Object> argDelegate) {
/*  85 */     this.delegate_ = argDelegate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSelection(Object argElem) {
/*  91 */     this.delegate_.addSelection(argElem);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSelections(List<Object> argElems) {
/*  97 */     this.delegate_.addSelections(argElems);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 103 */     this.delegate_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListModel getModel() {
/* 109 */     return this.delegate_.getModel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> getSelectedElements() {
/* 115 */     return this.delegate_.getSelectedElements();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IListSelectionModel getSelectionModel() {
/* 121 */     return this.delegate_.getSelectionModel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getUserInput() {
/* 127 */     return this.delegate_.getSelectedElements().toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSelection(List<Object> argElems) {
/* 133 */     this.delegate_.removeSelection(argElems);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSelection(Object argElem) {
/* 139 */     this.delegate_.removeSelection(argElem);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void selectLast() {
/* 145 */     this.delegate_.selectLast();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelection(Object argElem) {
/* 151 */     this.delegate_.setSelection(argElem);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelections(List<Object> argElems) {
/* 157 */     this.delegate_.setSelections(argElems);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserInput(Object argUserInput) {
/* 164 */     List<Object> selections = null;
/* 165 */     if (argUserInput instanceof Collection) {
/* 166 */       selections = new ArrayList((Collection)argUserInput);
/*     */     }
/* 168 */     else if (argUserInput instanceof Object[]) {
/* 169 */       selections = Arrays.asList((Object[])argUserInput);
/*     */     } else {
/*     */       
/* 172 */       selections = new ArrayList();
/* 173 */       selections.add(argUserInput);
/*     */     } 
/* 175 */     this.delegate_.setSelections(selections);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearModelImpl() {
/* 181 */     this.delegate_.clear();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultListInputModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */