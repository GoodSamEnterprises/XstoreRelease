/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.pos.framework.ui.UIModelChangeType;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstChainAction;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.action.IXstKeyStrokeAction;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*     */ import java.awt.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
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
/*     */ public class DefaultPromptActionModel
/*     */   extends AbstractUIModel
/*     */   implements IPromptActionModel
/*     */ {
/*  41 */   private static final Logger logger_ = Logger.getLogger(DefaultPromptActionModel.class);
/*     */   
/*  43 */   private final List<IXstAction> actionList_ = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean clear_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAction(IXstAction action) {
/*  59 */     if (logger_.isDebugEnabled()) {
/*  60 */       logger_.debug("Adding prompt action: [" + action + "].");
/*     */     }
/*  62 */     this.actionList_.add(action);
/*  63 */     IXstAction[] actions = null;
/*  64 */     actions = this.actionList_.<IXstAction>toArray(actions);
/*  65 */     Arrays.sort((Object[])actions);
/*     */     
/*  67 */     this.events_.post(IPromptActionModel.ADD_ACTION, this.actionList_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void evaluateVisibility() {
/*  73 */     evaluateVisibility(getActions());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<IXstAction> getActions() {
/*  83 */     return this.actionList_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAction(IXstAction action) {
/*  93 */     if (logger_.isDebugEnabled()) {
/*  94 */       logger_.debug("Removing prompt action: [" + action + "].");
/*     */     }
/*  96 */     this.actionList_.remove(action);
/*  97 */     this.events_.post(IPromptActionModel.REMOVE_ACTION, action);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValues(Collection<IXstAction> argActions, ActionDisplayType actionDisplayType, IUIInputModel dataModel, Collection<Component> argKeyTargets, IXstEventListener eventListener) {
/* 104 */     if (argActions != null) {
/* 105 */       IXstDataAction dataAction = null;
/* 106 */       IXstKeyStrokeAction keyStrokeAction = null;
/*     */       
/* 108 */       for (IXstAction action : argActions) {
/*     */         
/* 110 */         if (action instanceof IXstChainAction) {
/* 111 */           ((IXstChainAction)action).setEventListener(eventListener);
/*     */         }
/* 113 */         if (action instanceof IXstDataAction) {
/* 114 */           dataAction = (IXstDataAction)action;
/* 115 */           dataAction.setModel(dataModel);
/* 116 */           dataAction.setParent(this);
/* 117 */           dataAction.setEventListener(eventListener); continue;
/*     */         } 
/* 119 */         if (action instanceof IXstKeyStrokeAction) {
/* 120 */           keyStrokeAction = (IXstKeyStrokeAction)action;
/* 121 */           keyStrokeAction.setKeyStrokeTargets(argKeyTargets);
/*     */         } 
/*     */       } 
/*     */     } 
/* 125 */     setValues(argActions, actionDisplayType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearModelImpl() {
/* 131 */     setValues(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void evaluateVisibility(Collection<IXstAction> actions) {
/* 138 */     if (actions != null) {
/* 139 */       for (IXstAction action : actions) {
/* 140 */         if (action != null) {
/* 141 */           action.evaluateVisibility();
/*     */         }
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
/*     */   private void setValues(Collection<IXstAction> actions, ActionDisplayType actionDisplayType) {
/* 154 */     if (logger_.isDebugEnabled()) {
/* 155 */       logger_.debug("Setting all prompt actions: \n\t[" + actions + "]");
/*     */     }
/* 157 */     this.actionList_.clear();
/*     */     
/* 159 */     if (actions != null && !actions.isEmpty()) {
/* 160 */       this.actionList_.addAll(actions);
/*     */     }
/*     */     
/* 163 */     evaluateVisibility(this.actionList_);
/*     */     
/* 165 */     if (this.actionList_.isEmpty()) {
/* 166 */       if (!this.clear_) {
/*     */         
/* 168 */         this.events_.post(UIModelChangeType.CLEARED);
/* 169 */         this.clear_ = true;
/*     */       } 
/*     */     } else {
/*     */       
/* 173 */       this.events_.post(actionDisplayType, this.actionList_);
/* 174 */       this.clear_ = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultPromptActionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */