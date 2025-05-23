/*     */ package dtv.pos.framework.action;
/*     */ import com.micros.xstore.config.IConfigMgr;
/*     */ import com.micros.xstore.config.IPropertyCascader;
/*     */ import com.micros.xstore.config.action.ActionSet;
/*     */ import com.micros.xstore.config.common.Action;
/*     */ import com.micros.xstore.config.common.Parameter;
/*     */ import com.micros.xstore.config.impl.ConfigLoadingException;
/*     */ import com.micros.xstore.config.impl.LocatableObject;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.ConfigToObjectUtils;
/*     */ import dtv.pos.framework.action.access.AlwaysHideVisibilityRule;
/*     */ import dtv.pos.framework.action.access.CurrentUserAccCheck;
/*     */ import dtv.pos.framework.action.type.FormNavigationActionType;
/*     */ import dtv.pos.framework.action.type.FormOptionsActionType;
/*     */ import dtv.pos.framework.action.type.FormOptionsKey;
/*     */ import dtv.pos.framework.action.type.SortActionKey;
/*     */ import dtv.pos.framework.action.type.XstChainActionType;
/*     */ import dtv.pos.framework.action.type.XstKeyStroke;
/*     */ import dtv.pos.framework.event.KeyActionPair;
/*     */ import dtv.pos.framework.ui.config.IconGroup;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IFormNavigationAction;
/*     */ import dtv.pos.iframework.action.ISortAction;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.action.IXstChainAction;
/*     */ import dtv.pos.iframework.action.IXstChainActionType;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.action.IXstDataActionKey;
/*     */ import dtv.pos.iframework.action.IXstKeyStroke;
/*     */ import dtv.pos.iframework.action.IXstKeyStrokeAction;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.ui.IUIResourceManager;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.KeyStroke;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class XstActionFactory implements IXstActionFactory {
/*  49 */   public static final String SYSTEM_PROPERTY = XstActionFactory.class.getName();
/*     */   
/*  51 */   private static final Logger logger = Logger.getLogger(XstActionFactory.class);
/*     */   
/*  53 */   private static final IUIResourceManager UIRM = UIResourceManager.getInstance();
/*     */   
/*     */   private IPropertyCascader<Action> _actionCascader;
/*     */   
/*     */   private IConfigMgr<ActionSet> _actionConfigMgr;
/*  58 */   private ConfigToObjectUtils _configUtils = new ConfigToObjectUtils();
/*     */ 
/*     */   
/*     */   private Map<String, Action> _actionMap;
/*     */ 
/*     */   
/*     */   public XstActionFactory(IConfigMgr<ActionSet> argConfigMgr) {
/*  65 */     this._actionConfigMgr = argConfigMgr;
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
/*     */   public IXstAction getAction(DataActionGroupKey argGroupKey, Action argAction) {
/*  77 */     Action resolvedConfig = argAction;
/*     */     
/*  79 */     if (!StringUtils.isEmpty(argAction.getRef())) {
/*  80 */       Action referent = this._actionMap.get(argAction.getRef());
/*     */       
/*  82 */       if (referent == null) {
/*  83 */         logger.info("Action will be excluded, as its reference does not exist [" + argAction.getRef() + "] @@ " + argAction
/*  84 */             .getSourceDescription());
/*  85 */         return null;
/*     */       } 
/*     */       
/*  88 */       resolvedConfig = (Action)this._actionCascader.copyCascadableProperties((LocatableObject)argAction, (LocatableObject)referent);
/*     */     } 
/*     */     
/*  91 */     IXstAction action = buildActionFromConfig(argGroupKey, resolvedConfig);
/*     */     
/*  93 */     return action;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstAction getAction(String argActionName) {
/* 104 */     Action actionConfig = this._actionMap.get(argActionName);
/* 105 */     IXstAction action = buildActionFromConfig(null, actionConfig);
/* 106 */     return action;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstChainAction getChainAction(OpChainKey argKey, IXstChainActionType argType) {
/* 112 */     IXstChainAction chainAction = null;
/*     */     
/* 114 */     IXstChainActionType type = (argType == null) ? (IXstChainActionType)XstChainActionType.DEFAULT : argType;
/*     */     
/* 116 */     chainAction = new XstChainAction(type, argKey);
/*     */     
/* 118 */     return chainAction;
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
/*     */   public IXstDataAction getDataAction(IXstDataActionKey argKey) {
/* 130 */     return new XstDataAction(XstDataActionType.STANDARD, argKey);
/*     */   }
/*     */ 
/*     */   
/*     */   public IXstAction getEmptyAction() {
/* 135 */     IXstAction emptyAction = getAction(null, new Action());
/* 136 */     AlwaysHideVisibilityRule hideRule = new AlwaysHideVisibilityRule();
/* 137 */     List<IVisibilityRule> rules = new ArrayList<>();
/* 138 */     rules.add(hideRule);
/* 139 */     emptyAction.setVisible(true);
/* 140 */     emptyAction.setVisibilityRules(rules, true);
/* 141 */     return emptyAction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormNavigationAction getFormNavigationAction(DataActionGroupKey argContainingGroupKey, FormTabKey argKey) {
/* 147 */     if (argKey == null) {
/* 148 */       return null;
/*     */     }
/*     */     
/* 151 */     FormNavigationActionType type = FormNavigationActionType.STANDARD;
/* 152 */     IFormNavigationAction result = new FormNavigationAction(argContainingGroupKey, type, argKey);
/* 153 */     return result;
/*     */   }
/*     */   
/*     */   public IXstAction getFormOptionsAction(FormOptionsKey argKey) {
/* 157 */     if (argKey == null) {
/* 158 */       return null;
/*     */     }
/*     */     
/* 161 */     FormOptionsActionType type = FormOptionsActionType.STANDARD;
/* 162 */     IXstAction action = new FormOptionsAction(argKey, type);
/* 163 */     return action;
/*     */   }
/*     */   
/*     */   public IXstAction getHelpAction() {
/*     */     IXstChainAction iXstChainAction;
/* 168 */     IXstAction helpAction = null;
/* 169 */     XstKeyStroke helpKey = ConfigurationMgr.getHelpKey();
/*     */     
/* 171 */     if (helpKey != null) {
/* 172 */       iXstChainAction = getChainAction(OpChainKey.valueOf("HELP"), (IXstChainActionType)XstChainActionType.STACK);
/* 173 */       iXstChainAction.setActionNameKey("_help");
/* 174 */       iXstChainAction.setKeyStroke(helpKey.getKeyStroke());
/* 175 */       iXstChainAction.setVisible(true);
/* 176 */       iXstChainAction.setEnabled(true);
/*     */     } 
/*     */     
/* 179 */     return (IXstAction)iXstChainAction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstKeyStrokeAction getKeyStrokeAction(IXstKeyStroke argKey) {
/* 185 */     return new XstKeyStrokeAction(XstKeyStrokeActionType.STANDARD, argKey);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstMenuAction getMenuAction(ActionEvent argMenuEvent) {
/* 191 */     return new XstMenuAction(argMenuEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public IXstAction getMoreAction() {
/* 196 */     IXstAction action = getAction(null, new Action());
/* 197 */     action.setActionNameKey("_menutext98");
/* 198 */     action.setVisible(true);
/*     */     
/* 200 */     return action;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstKeyStrokeAction getScrollDownAction() {
/* 206 */     IXstKeyStrokeAction downAction = getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("Down"));
/*     */     
/* 208 */     downAction.setVisible(true);
/* 209 */     downAction.setEnabled(true);
/*     */     
/* 211 */     downAction.setSmallIcon(UIRM.getImageIcon("_imageButtonDownArrow"));
/* 212 */     downAction.setRolloverIcon(UIRM.getImageIcon("_imageButtonDownArrowRoll"));
/* 213 */     downAction.setPressedIcon(UIRM.getImageIcon("_imageButtonDownArrowPress"));
/*     */     
/* 215 */     return downAction;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<? extends KeyActionPair> getScrollKeyActions() {
/* 221 */     Collection<KeyActionPair> pairs = new ArrayList<>();
/*     */     
/* 223 */     pairs.add(new KeyActionPair(KeyStroke.getKeyStroke(38, 0), (Action)getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("UP"))));
/* 224 */     pairs.add(new KeyActionPair(KeyStroke.getKeyStroke(40, 0), (Action)getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("DOWN"))));
/* 225 */     pairs.add(new KeyActionPair(KeyStroke.getKeyStroke(33, 0), (Action)getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("PAGE_UP"))));
/* 226 */     pairs.add(new KeyActionPair(KeyStroke.getKeyStroke(34, 0), (Action)getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("PAGE_DOWN"))));
/* 227 */     pairs.add(new KeyActionPair(KeyStroke.getKeyStroke(36, 0), (Action)getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("HOME"))));
/* 228 */     pairs.add(new KeyActionPair(KeyStroke.getKeyStroke(35, 0), (Action)getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("END"))));
/*     */     
/* 230 */     return pairs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstKeyStrokeAction getScrollUpAction() {
/* 236 */     IXstKeyStrokeAction upAction = getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName("Up"));
/*     */     
/* 238 */     upAction.setVisible(true);
/* 239 */     upAction.setEnabled(true);
/* 240 */     upAction.setSmallIcon(UIRM.getImageIcon("_imageButtonUpArrow"));
/* 241 */     upAction.setRolloverIcon(UIRM.getImageIcon("_imageButtonUpArrowRoll"));
/* 242 */     upAction.setPressedIcon(UIRM.getImageIcon("_imageButtonUpArrowPress"));
/*     */     
/* 244 */     return upAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*     */     try {
/* 250 */       ActionSet actionSet = (ActionSet)this._actionConfigMgr.getResolvedConfigs();
/* 251 */       this._actionMap = new HashMap<>();
/*     */       
/* 253 */       for (Action actionType : actionSet.getActions()) {
/* 254 */         this._actionMap.put(actionType.getName(), actionType);
/*     */       }
/*     */     }
/* 257 */     catch (ConfigLoadingException ex) {
/* 258 */       logger.error("Failed to successfully load ActionConfig.xml files.", (Throwable)ex);
/* 259 */       throw new ConfigException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setActionCascader(IPropertyCascader<Action> argCascader) {
/* 264 */     this._actionCascader = argCascader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IXstAction buildActionFromConfig(DataActionGroupKey argActionGroup, Action argActionConfig) {
/* 272 */     IXstAction action = null;
/*     */     
/* 274 */     if (!StringUtils.isEmpty(argActionConfig.getChainKey())) {
/*     */       
/* 276 */       XstChainActionType chainType = (argActionConfig.getChainType() == null) ? null : XstChainActionType.forName(argActionConfig.getChainType());
/* 277 */       IXstChainAction iXstChainAction = getChainAction(OpChainKey.valueOf(argActionConfig.getChainKey()), (IXstChainActionType)chainType);
/*     */     }
/* 279 */     else if (!StringUtils.isEmpty(argActionConfig.getTabKey())) {
/* 280 */       IFormNavigationAction iFormNavigationAction = getFormNavigationAction(null, FormTabKey.forName(argActionConfig.getTabKey()));
/*     */     }
/* 282 */     else if (!StringUtils.isEmpty(argActionConfig.getDataKey())) {
/* 283 */       IXstDataAction iXstDataAction = getDataAction(XstDataActionKey.valueOf(argActionConfig.getDataKey()));
/*     */     }
/* 285 */     else if (!StringUtils.isEmpty(argActionConfig.getKeyStrokeKey())) {
/* 286 */       IXstKeyStrokeAction iXstKeyStrokeAction = getKeyStrokeAction((IXstKeyStroke)XstKeyStroke.forName(argActionConfig.getKeyStrokeKey()));
/*     */     }
/* 288 */     else if (!StringUtils.isEmpty(argActionConfig.getFormOptionsKey())) {
/* 289 */       action = getFormOptionsAction(FormOptionsKey.valueOf(argActionConfig.getFormOptionsKey()));
/*     */     }
/* 291 */     else if (!StringUtils.isEmpty(argActionConfig.getSortKey())) {
/* 292 */       SortActionKey sortKey = SortActionKey.valueOf(argActionConfig.getSortKey());
/* 293 */       ISortAction iSortAction = getSortAction(sortKey, argActionConfig.getSubKey());
/*     */     } else {
/*     */       
/* 296 */       action = new XstDefaultAction();
/*     */     } 
/*     */     
/* 299 */     action.setActionNameKey(argActionConfig.getText());
/* 300 */     action.setData(argActionConfig.getData());
/*     */     
/* 302 */     IconGroup iconGroup = new IconGroup(argActionConfig.getIconGroup());
/* 303 */     action.setSmallIcon(iconGroup.getIcon());
/* 304 */     action.setRolloverIcon(iconGroup.getRollIcon());
/* 305 */     action.setPressedIcon(iconGroup.getPressIcon());
/* 306 */     action.setDisabledIcon(iconGroup.getDisabledIcon());
/*     */ 
/*     */ 
/*     */     
/* 310 */     action.setVisible(ConfigUtils.toBoolean(argActionConfig.getVisible(), true).booleanValue());
/* 311 */     action.setKeywords(argActionConfig.getKeywords());
/*     */     
/* 313 */     if (argActionConfig.getIconGroup() != null) {
/* 314 */       action.setIconKey(argActionConfig.getIconGroup().getIcon());
/*     */     }
/*     */     
/* 317 */     action.setEnabled(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 326 */     List<ParameterConfig> parameters = new ArrayList<>();
/*     */     
/* 328 */     for (Parameter paramConfig : argActionConfig.getParameters()) {
/*     */       
/* 330 */       ParameterConfig param = new ParameterConfig(paramConfig.getName(), (IConfigObject)new StringConfig(paramConfig.getValue()));
/* 331 */       parameters.add(param);
/*     */     } 
/*     */     
/* 334 */     action.setParameters(parameters);
/*     */     
/* 336 */     List<IVisibilityRule> visibilityRules = new ArrayList<>();
/*     */     
/* 338 */     if (!StringUtils.isEmpty(argActionConfig.getPrivilege())) {
/* 339 */       for (String privilege : argActionConfig.getPrivilege().split(",")) {
/* 340 */         CurrentUserAccCheck rule = new CurrentUserAccCheck();
/* 341 */         rule.setParameter("privilege", privilege);
/* 342 */         visibilityRules.add(rule);
/*     */       } 
/*     */     }
/*     */     
/* 346 */     for (Action.VisibilityRule ruleConfig : argActionConfig.getVisibilityRules()) {
/* 347 */       IVisibilityRule rule = this._configUtils.buildVisibilityRule(ruleConfig);
/* 348 */       visibilityRules.add(rule);
/*     */     } 
/*     */     
/* 351 */     action.setVisibilityRules(visibilityRules, false);
/*     */     
/* 353 */     List<String> keyStrokes = new ArrayList<>(argActionConfig.getKeyStrokes());
/*     */     
/* 355 */     if (!StringUtils.isEmpty(argActionConfig.getKeyStroke())) {
/* 356 */       keyStrokes.add(0, argActionConfig.getKeyStroke());
/*     */     }
/*     */     
/* 359 */     if (keyStrokes != null && !keyStrokes.isEmpty()) {
/* 360 */       KeyStroke[] strokes = new KeyStroke[keyStrokes.size()];
/* 361 */       int i = 0;
/*     */       
/* 363 */       for (String keyStroke : keyStrokes) {
/* 364 */         XstKeyStroke xstKeyStroke = XstKeyStroke.forName(keyStroke);
/* 365 */         strokes[i++] = xstKeyStroke.getKeyStroke();
/*     */       } 
/*     */       
/* 368 */       action.setKeyStrokes(strokes);
/*     */     } 
/*     */     
/* 371 */     for (Action postActionCfg : argActionConfig.getActions()) {
/* 372 */       action.addPostAction((Action)getAction(argActionGroup, postActionCfg));
/*     */     }
/*     */     
/* 375 */     return action;
/*     */   }
/*     */   
/*     */   protected ISortAction getSortAction(SortActionKey argKey, String argSortField) {
/* 379 */     if (argKey == null) {
/* 380 */       return null;
/*     */     }
/*     */     
/* 383 */     ISortAction action = new ListSortAction(argKey);
/* 384 */     action.setSortField(argSortField);
/*     */     
/* 386 */     return action;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\XstActionFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */