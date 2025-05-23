/*     */ package dtv.pos.framework.action;
/*     */ 
/*     */ import dtv.pos.framework.action.access.FormNavigationVisibilityRule;
/*     */ import dtv.pos.framework.action.type.FormNavigationActionType;
/*     */ import dtv.pos.framework.form.FormAssembler;
/*     */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IFormNavigationAction;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstActionType;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.security.ISecurityResponse;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.ui.model.ISingleSelectionModel;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
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
/*     */ public class FormNavigationAction
/*     */   extends XstDefaultAction
/*     */   implements IFormNavigationAction
/*     */ {
/*     */   public static final String PARAM_IGNORE_FORM_NAV_RULE = "IgnoreFormNavigationRule";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final FormTabKey tabKey_;
/*     */   private final DataActionGroupKey actionGroupKey_;
/*     */   private IVisibilityRule navVisibilityRule_;
/*     */   private final boolean changeModelIndex_;
/*     */   private boolean _ignoreNavVisibilityRule = false;
/*     */   private String actionGroupSubKey_;
/*     */   @Inject
/*     */   private FormViewConfigHelper _formConfigHelper;
/*     */   @Inject
/*     */   private FormAssembler _formAssembler;
/*     */   
/*     */   public FormNavigationAction(DataActionGroupKey argGroupKey, FormNavigationActionType argType, FormTabKey argTabKey) {
/*  59 */     super((IXstActionType)argType, (IXstActionKey)argTabKey);
/*     */     
/*  61 */     this.tabKey_ = argTabKey;
/*  62 */     this.actionGroupKey_ = argGroupKey;
/*  63 */     this.changeModelIndex_ = true;
/*  64 */     this.actionGroupSubKey_ = null;
/*     */ 
/*     */ 
/*     */     
/*  68 */     if (!this._ignoreNavVisibilityRule && 
/*  69 */       argTabKey != null) {
/*  70 */       FormNavigationVisibilityRule rule = new FormNavigationVisibilityRule();
/*  71 */       rule.setFormModel(getFormModel());
/*  72 */       rule.setParameter("formName", argTabKey.toString());
/*     */       
/*  74 */       this.navVisibilityRule_ = (IVisibilityRule)rule;
/*     */       
/*  76 */       addVisibilityRule(this.navVisibilityRule_, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormTabKey getFormTabKey() {
/*  83 */     return this.tabKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAccessGranted(ISecurityResponse argResponse) {
/*  89 */     if (getPrivileges() != null && (getPrivileges()).length > 0) {
/*  90 */       getEventListener().handleXstEvent((IXstEvent)this);
/*     */     }
/*     */     
/*  93 */     super.notifyAccessGranted(argResponse);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParameters(List<ParameterConfig> params) {
/*  98 */     super.setParameters(params);
/*     */ 
/*     */     
/* 101 */     for (ParameterConfig paramCfg : params) {
/* 102 */       String name = paramCfg.getName();
/* 103 */       IConfigObject value = paramCfg.getValue();
/*     */       
/* 105 */       if ("targetSubGroup".equalsIgnoreCase(name) || "subKey".equalsIgnoreCase(name)) {
/* 106 */         this.actionGroupSubKey_ = value.toString();
/*     */         break;
/*     */       } 
/* 109 */       if ("IgnoreFormNavigationRule".equalsIgnoreCase(name)) {
/* 110 */         this._ignoreNavVisibilityRule = ConfigUtils.toBoolean(value);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisibilityRules(List<IVisibilityRule> visibilityRules, boolean evaluateImmediately) {
/* 125 */     super.setVisibilityRules(visibilityRules, evaluateImmediately);
/*     */ 
/*     */     
/* 128 */     if (!this._ignoreNavVisibilityRule) {
/* 129 */       addVisibilityRule(this.navVisibilityRule_, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformedImpl(ActionEvent argEvent) {
/* 140 */     IFormModel formModel = getFormModel();
/* 141 */     String actionSubGroupKey = null;
/*     */     
/* 143 */     if (this.changeModelIndex_) {
/* 144 */       ISingleSelectionModel selectionModel = formModel.getSelectionModel();
/* 145 */       if (selectionModel != null) {
/* 146 */         if (FormTabKey.NEXT_PAGE.equals(getFormTabKey())) {
/* 147 */           actionSubGroupKey = selectionModel.selectNextIndex(true);
/*     */         }
/* 149 */         else if (FormTabKey.PREVIOUS_PAGE.equals(getFormTabKey())) {
/* 150 */           actionSubGroupKey = selectionModel.selectPreviousIndex(true);
/*     */         }
/* 152 */         else if (this.tabKey_ != null) {
/* 153 */           actionSubGroupKey = selectionModel.setSelectedTab(this.tabKey_.toString(), false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 162 */           IEditModel editModel = formModel.getEditModel();
/* 163 */           editModel.setFocusRequestFieldKey(null);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 168 */     String actionSubGroupKeyToUse = (this.actionGroupSubKey_ != null) ? this.actionGroupSubKey_ : actionSubGroupKey;
/* 169 */     formModel.setActionGroupSubKey(actionSubGroupKeyToUse);
/*     */ 
/*     */     
/* 172 */     if (this.actionGroupKey_ != null) {
/* 173 */       Collection<IXstAction> actions = null;
/*     */       
/* 175 */       if (this._formAssembler.hasFormConfiguration(formModel.getFormKey())) {
/* 176 */         actions = this._formAssembler.getActions(formModel.getEditModel(), this.actionGroupKey_, formModel.getFormKey(), actionSubGroupKeyToUse, true);
/*     */       }
/*     */       else {
/*     */         
/* 180 */         actions = this._formConfigHelper.getActions(formModel, this.actionGroupKey_, actionSubGroupKeyToUse);
/*     */       } 
/*     */       
/* 183 */       ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel().setValues(actions, ActionDisplayType.BUTTON_EXCLUSIVE, (IUIInputModel)formModel, null, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private IFormModel getFormModel() {
/* 189 */     IStationModel sm = ((IModeController)this._modeProvider.get()).getStationModel();
/* 190 */     return sm.getFormModel(sm.getPrimaryFormModelKey());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\FormNavigationAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */