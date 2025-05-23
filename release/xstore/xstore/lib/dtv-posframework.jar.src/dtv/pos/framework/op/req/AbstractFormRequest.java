/*     */ package dtv.pos.framework.op.req;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.op.req.IUIOpRequest;
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
/*     */ public abstract class AbstractFormRequest
/*     */   implements IUIOpRequest
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final FormKey _formKey;
/*     */   private final IEditModel _model;
/*     */   private final DataActionGroupKey _actionGroup;
/*     */   private final boolean _editable;
/*     */   private final FormLocationType _formLocationType;
/*     */   private final FormTabKey _formTabKey;
/*     */   
/*     */   protected AbstractFormRequest(FormKey argFormKey, IEditModel argModel, boolean editable, DataActionGroupKey actionGroup, FormLocationType argFormLocationType, FormTabKey argTabKey) {
/*  45 */     if (argFormKey == null) {
/*  46 */       throw new NullPointerException("FormKey cannot be null");
/*     */     }
/*     */     
/*  49 */     this._formKey = argFormKey;
/*  50 */     this._editable = editable;
/*  51 */     this._actionGroup = actionGroup;
/*  52 */     this._model = argModel;
/*  53 */     this._formLocationType = argFormLocationType;
/*  54 */     this._formTabKey = argTabKey;
/*     */   }
/*     */   
/*     */   public DataActionGroupKey getActionGroup() {
/*  58 */     return this._actionGroup;
/*     */   }
/*     */   
/*     */   public IEditModel getEditModel() {
/*  62 */     return this._model;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormKey getFormKey() {
/*  70 */     return this._formKey;
/*     */   }
/*     */   
/*     */   public FormLocationType getFormLocationType() {
/*  74 */     return this._formLocationType;
/*     */   }
/*     */   
/*     */   public FormTabKey getTabKey() {
/*  78 */     return this._formTabKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUiRequestKey() {
/*  84 */     return getFormKey().toString();
/*     */   }
/*     */   
/*     */   public boolean isEditable() {
/*  88 */     return this._editable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder str = new StringBuilder(getClass().getName());
/*  98 */     str.append("::FormKey = ").append(this._formKey.toString());
/*  99 */     str.append("::Editable = ").append(isEditable());
/* 100 */     str.append("::ActionGroup = ").append(this._actionGroup);
/* 101 */     str.append("::EditModel = ").append(this._model);
/* 102 */     return str.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\AbstractFormRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */