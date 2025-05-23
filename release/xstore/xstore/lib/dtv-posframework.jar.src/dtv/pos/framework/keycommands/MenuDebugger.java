/*     */ package dtv.pos.framework.keycommands;
/*     */ 
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.ui.IMenuItem;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IMenuModel;
/*     */ import dtv.pos.iframework.ui.model.IPromptActionModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
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
/*     */ public class MenuDebugger
/*     */   implements IKeyCommand
/*     */ {
/*     */   @Inject
/*     */   private FormViewConfigHelper _formConfigHelper;
/*  38 */   private static final Logger logger = Logger.getLogger(MenuDebugger.class);
/*     */ 
/*     */   
/*     */   private static void appendParameter(StringBuilder sb, ParameterConfig argParameterConfig, int argPaddingLevel) {
/*  42 */     String padding = getPadding(argPaddingLevel);
/*  43 */     sb.append(padding).append(argParameterConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendVisibilityRule(StringBuilder sb, IVisibilityRule argVisibilityRule, int argPaddingLevel) {
/*  49 */     String padding = getPadding(argPaddingLevel);
/*  50 */     if (argVisibilityRule == null) {
/*  51 */       sb.append(padding).append("null access rule");
/*     */     } else {
/*     */       
/*  54 */       sb.append(padding).append("access rule [" + argVisibilityRule + "]");
/*     */       try {
/*  56 */         sb.append(padding).append("  no-access?:").append(argVisibilityRule.checkVisibility());
/*     */       }
/*  58 */       catch (Exception ex) {
/*  59 */         logger.error("CAUGHT EXCEPTION", ex);
/*  60 */         sb.append(padding).append("  no-access?:").append("DENIED").append("(" + ex + ":)");
/*     */       } 
/*     */     } 
/*     */   } @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   private static String getPadding(int argLevel) {
/*  66 */     switch (argLevel) {
/*     */       case 0:
/*  68 */         return StringUtils.NEW_LINE;
/*     */       case 1:
/*  70 */         return StringUtils.NEW_LINE + "  ";
/*     */       case 2:
/*  72 */         return StringUtils.NEW_LINE + "    ";
/*     */       case 3:
/*  74 */         return StringUtils.NEW_LINE + "      ";
/*     */     } 
/*  76 */     return StringUtils.NEW_LINE + StringUtils.fill(' ', 2 * argLevel);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String toString(IXstActionKey argKey) {
/*  81 */     return argKey.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() {
/*  92 */     if (logger.isInfoEnabled()) {
/*  93 */       logger.info(execute(new StringBuilder(1024)));
/*     */     }
/*     */   }
/*     */   
/*     */   public StringBuilder execute(StringBuilder sb) {
/*     */     try {
/*  99 */       IStationModel sm = ((IModeController)this._modeProvider.get()).getStationModel();
/*     */       try {
/* 101 */         appendMenuModel(sb, sm.getMenuModel());
/*     */       }
/* 103 */       catch (Exception ex) {
/* 104 */         logger.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */       try {
/* 107 */         appendPromptActionModel(sb, sm.getPromptActionModel());
/*     */       }
/* 109 */       catch (Exception ex) {
/* 110 */         logger.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */       try {
/* 113 */         StringUtils.appendLine(sb, "****************************************");
/* 114 */         StringUtils.appendLine(sb, "app change actions");
/* 115 */         appendActions(sb, sm.getAppChangeActions(), 1);
/*     */       }
/* 117 */       catch (Exception ex) {
/* 118 */         logger.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */       
/*     */       try {
/* 122 */         appendFormActions(sb, sm);
/*     */       }
/* 124 */       catch (Exception ex) {
/* 125 */         logger.error("CAUGHT EXCEPTION", ex);
/*     */       }
/*     */     
/* 128 */     } catch (Exception ex) {
/* 129 */       logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 131 */     return sb;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommand() {
/* 136 */     return "menu";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHelpText() {
/* 141 */     return "displays the current menu model";
/*     */   }
/*     */ 
/*     */   
/*     */   private void appendAction(StringBuilder sb, IXstAction argAction, int argPaddingLevel) {
/* 146 */     String padding = getPadding(argPaddingLevel);
/* 147 */     if (argAction == null) {
/* 148 */       sb.append(padding).append("null action");
/*     */     } else {
/*     */       
/* 151 */       sb.append(padding).append("action ");
/* 152 */       sb.append("\"").append(argAction.getActionName().toString(OutputContextType.VIEW)).append("\"");
/* 153 */       IXstActionKey actionKey = argAction.getActionKey();
/*     */       
/* 155 */       if (!(actionKey instanceof dtv.pos.framework.action.type.DummyActionKey)) {
/* 156 */         sb.append(" [").append(toString(actionKey)).append("]");
/*     */       }
/*     */       
/* 159 */       List<IVisibilityRule> rules = argAction.getVisibilityRules();
/*     */       
/* 161 */       if (rules != null && !rules.isEmpty()) {
/* 162 */         sb.append(padding).append("  access rules:");
/* 163 */         for (IVisibilityRule rule : rules) {
/* 164 */           appendVisibilityRule(sb, rule, argPaddingLevel + 2);
/*     */         }
/*     */       } 
/*     */       
/* 168 */       List<ParameterConfig> parameters = argAction.getParameters();
/* 169 */       if (parameters != null && !parameters.isEmpty()) {
/* 170 */         sb.append(padding).append("  parameters:");
/* 171 */         for (ParameterConfig pc : parameters) {
/* 172 */           appendParameter(sb, pc, argPaddingLevel + 2);
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
/*     */   private void appendActions(StringBuilder sb, Collection<IXstAction> argActions, int argPaddingLevel) {
/* 185 */     String padding = getPadding(argPaddingLevel);
/* 186 */     if (argActions == null) {
/* 187 */       sb.append(padding).append("null action array!!");
/*     */     } else {
/*     */       
/* 190 */       sb.append(padding).append("actions:");
/* 191 */       for (IXstAction action : argActions) {
/* 192 */         appendAction(sb, action, argPaddingLevel + 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void appendFormActions(StringBuilder sb, IStationModel sm) {
/* 199 */     FormKey formKey = sm.getPrimaryFormModelKey();
/* 200 */     StringUtils.appendLine(sb, "*****************************************");
/* 201 */     StringUtils.appendLine(sb, "current form");
/* 202 */     StringUtils.appendLine(sb, "  key:" + formKey);
/* 203 */     StringUtils.appendLine(sb, "  source:" + this._formConfigHelper.getSourceDescription(formKey));
/* 204 */     IFormModel formModel = sm.getFormModel(formKey);
/* 205 */     if (formModel != null) {
/* 206 */       DataActionGroupKey actionGroupKey = formModel.getActionGroupKey();
/* 207 */       if (actionGroupKey == null)
/*     */       {
/* 209 */         actionGroupKey = DataActionGroupKey.DEFAULT;
/*     */       }
/*     */       
/* 212 */       Collection<IXstAction> actions = this._formConfigHelper.getActions(formModel, actionGroupKey, formModel.getActionGroupSubKey());
/* 213 */       appendActions(sb, actions, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendMenuModel(StringBuilder sb, IMenuModel model) {
/* 218 */     sb.append("menu model");
/*     */     
/* 220 */     IMenuItem menu = model.getCurrentMenu();
/* 221 */     StringUtils.appendLine(sb, "  current menu");
/* 222 */     StringUtils.appendLine(sb, "    key:").append(menu.getMenuKey());
/* 223 */     StringUtils.appendLine(sb, "    source:").append(menu.getSourceDescription());
/* 224 */     if (menu.getMenuDescription() == null) {
/* 225 */       StringUtils.appendLine(sb, "    null description");
/*     */     } else {
/*     */       
/* 228 */       StringUtils.appendLine(sb, "    description:").append(menu.getMenuDescription());
/*     */     } 
/* 230 */     if (menu.getMenuTitle() == null) {
/* 231 */       StringUtils.appendLine(sb, "    null title");
/*     */     } else {
/*     */       
/* 234 */       StringUtils.appendLine(sb, "    title:").append(menu.getMenuTitle());
/*     */     } 
/*     */     
/* 237 */     appendAction(sb, menu.getAction(), 2);
/*     */     
/* 239 */     List<IMenuItem> children = menu.getChildren();
/*     */     
/* 241 */     if (children != null && !children.isEmpty()) {
/* 242 */       Collection<IXstAction> actions = new ArrayList<>(children.size());
/*     */       
/* 244 */       for (IMenuItem element : children) {
/* 245 */         actions.add(element.getAction());
/*     */       }
/*     */       
/* 248 */       appendActions(sb, actions, 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendPromptActionModel(StringBuilder sb, IPromptActionModel model) {
/* 253 */     StringUtils.appendLine(sb, "****************************************");
/* 254 */     StringUtils.appendLine(sb, "prompt action model");
/* 255 */     appendActions(sb, model.getActions(), 1);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\MenuDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */