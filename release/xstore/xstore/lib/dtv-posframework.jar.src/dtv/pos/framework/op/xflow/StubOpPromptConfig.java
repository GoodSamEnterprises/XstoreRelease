/*     */ package dtv.pos.framework.op.xflow;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.TranslationHelper;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.ui.config.ActionConfig;
/*     */ import dtv.pos.framework.ui.config.PromptConfig;
/*     */ import dtv.pos.framework.ui.config.PromptSectionConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.op.IOpChainFactory;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.ui.ActionDisplayType;
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
/*     */ import dtv.pos.iframework.ui.config.IPromptSectionConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StubOpPromptConfig
/*     */   extends PromptConfig
/*     */ {
/*     */   private static final long serialVersionUID = -7310902244451474600L;
/*  49 */   private static final Logger logger_ = Logger.getLogger(StubOpPromptConfig.class);
/*  50 */   private static final String[] KEY_STROKE_POOL = new String[] { "F5", "F6", "F7", "F8" };
/*     */   
/*     */   private static final int ACTION_CONFIG_SIZE_LIMIT = 6;
/*     */   
/*     */   private final IOperation stubbedOp_;
/*     */   
/*     */   private final StubPlaceholderOp placeholderOp_;
/*     */   private IActionConfig[] actions_;
/*     */   @Inject
/*     */   private IOpChainFactory _opChainFactory;
/*     */   @Inject
/*     */   private FormattableFactory _FF;
/*     */   
/*     */   public StubOpPromptConfig(IOperation argStubbedOp, StubPlaceholderOp argPlaceholderOp) {
/*  64 */     InjectionHammer.forceAtInjectProcessing(this);
/*  65 */     this.stubbedOp_ = argStubbedOp;
/*  66 */     this.placeholderOp_ = argPlaceholderOp;
/*  67 */     buildActions();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionDisplayType getActionDisplayType() {
/*  73 */     return ActionDisplayType.POPUP;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPromptSectionConfig getMsgSectionConfig() {
/*  79 */     PromptSectionConfig section = new PromptSectionConfig();
/*  80 */     String htmlMessage = (new StubHtmlMessage(getStubbedOp(), getPlaceholderOp())).getHtmlMessage();
/*  81 */     section.setTextKey(this._FF.getLiteral(htmlMessage));
/*  82 */     return (IPromptSectionConfig)section;
/*     */   }
/*     */   
/*     */   public StubPlaceholderOp getPlaceholderOp() {
/*  86 */     return this.placeholderOp_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IActionConfig[] getPromptActionConfigs() {
/*  92 */     return this.actions_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PromptKey getPromptKey() {
/*  98 */     return PromptKey.valueOf("OPERATION STUB VIEW (defined in code)");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptType() {
/* 104 */     return "Notify";
/*     */   }
/*     */   
/*     */   public IOperation getStubbedOp() {
/* 108 */     return this.stubbedOp_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IPromptSectionConfig getTitleSectionConfig() {
/* 114 */     PromptSectionConfig section = new PromptSectionConfig();
/* 115 */     section.setTextKey(this._FF.getLiteral(getStubbedOp().getClass().getSimpleName()));
/* 116 */     return (IPromptSectionConfig)section;
/*     */   }
/*     */   
/*     */   protected void addAction(List<IActionConfig> argActionConfigs, IActionConfig argAction) {
/* 120 */     addAction(argActionConfigs, argAction, argActionConfigs.size());
/*     */   }
/*     */   
/*     */   protected void addAction(List<IActionConfig> argActionConfigs, IActionConfig argAction, int argIndex) {
/* 124 */     if (argActionConfigs.size() < 6) {
/* 125 */       argActionConfigs.add(argIndex, argAction);
/*     */     } else {
/*     */       
/* 128 */       logger_.warn("Action config size limit met; action will be ignored");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void addCancelIfNeeded(List<IActionConfig> argActionConfigs) {
/* 133 */     if (!OpType.SYSTEM.equals(getAnnotation().opType()) && !getAnnotation().noCancel()) {
/* 134 */       addAction(argActionConfigs, createCancelAction(), 0);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addCompleteIfNeeded(List<IActionConfig> argActionConfigs) {
/* 139 */     if (!isResponseTypePresent(ResponseType.COMPLETE) && !getAnnotation().noComplete()) {
/* 140 */       addAction(argActionConfigs, createCompleteAction(), 0);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addErrorIfNeeded(List<IActionConfig> argActionConfigs) {
/* 145 */     if (!isResponseTypePresent(ResponseType.NOTIFY_ERROR_RESPONSE)) {
/* 146 */       argActionConfigs.add(argActionConfigs.size(), createErrorAction());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addNotApplicableIfNeeded(List<IActionConfig> argActionConfigs) {
/* 151 */     if (getAnnotation().addApplicability()) {
/* 152 */       addAction(argActionConfigs, createNotApplicableAction(), 0);
/*     */     }
/*     */   }
/*     */   
/*     */   protected IActionConfig buildActionConfig(Action argActionAnnotation, int argIndex) {
/* 157 */     ActionConfig config = new ActionConfig();
/* 158 */     config.setConfigObject("TextKey", (IConfigObject)new StringConfig(argActionAnnotation.label()));
/* 159 */     config.setConfigObject("KeyStroke", (IConfigObject)new StringConfig(getKeyStroke(argIndex)));
/*     */     
/* 161 */     String key = argActionAnnotation.key();
/* 162 */     OpChainKey chainKey = OpChainKey.valueOf(key);
/* 163 */     config.setConfigObject("DataKey", (IConfigObject)new StringConfig(key));
/*     */     
/* 165 */     ResponseType responseType = argActionAnnotation.responseType();
/*     */     
/* 167 */     if (responseType != null && responseType.isChainType() && !this._opChainFactory.isValidChain(chainKey)) {
/* 168 */       String value = this.placeholderOp_.getParameter(key);
/*     */       
/* 170 */       if (value == null || !this._opChainFactory.isValidChain(OpChainKey.valueOf(value.toString()))) {
/* 171 */         return null;
/*     */       }
/*     */     } 
/*     */     
/* 175 */     return (IActionConfig)config;
/*     */   }
/*     */   
/*     */   protected void buildActions() {
/* 179 */     List<IActionConfig> actionConfigs = new ArrayList<>();
/* 180 */     int counter = 0;
/* 181 */     for (Action action : getAnnotation().actions()) {
/* 182 */       IActionConfig actionConfig = buildActionConfig(action, counter++);
/* 183 */       if (actionConfig != null) {
/* 184 */         actionConfigs.add(actionConfig);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 189 */     addCompleteIfNeeded(actionConfigs);
/* 190 */     addNotApplicableIfNeeded(actionConfigs);
/* 191 */     addCancelIfNeeded(actionConfigs);
/*     */     
/* 193 */     addErrorIfNeeded(actionConfigs);
/*     */     
/* 195 */     setConfigOrders(actionConfigs);
/*     */     
/* 197 */     this.actions_ = actionConfigs.<IActionConfig>toArray(new IActionConfig[actionConfigs.size()]);
/*     */   }
/*     */   
/*     */   protected IActionConfig createAction(String argTextKey, IXstActionKey argDataKey, String argKeyStroke) {
/* 201 */     ActionConfig config = new ActionConfig();
/* 202 */     config.setConfigObject("TextKey", (IConfigObject)new StringConfig(argTextKey));
/* 203 */     config.setConfigObject("KeyStroke", (IConfigObject)new StringConfig(argKeyStroke));
/* 204 */     config.setConfigObject("DataKey", (IConfigObject)new StringConfig(argDataKey.toString()));
/*     */     
/* 206 */     return (IActionConfig)config;
/*     */   }
/*     */   
/*     */   protected IActionConfig createCancelAction() {
/* 210 */     return createAction("Back", (IXstActionKey)XstDataActionKey.CANCEL, "Escape");
/*     */   }
/*     */   
/*     */   protected IActionConfig createCompleteAction() {
/* 214 */     return createAction("Op Complete", (IXstActionKey)XstDataActionKey.ACCEPT, "Enter");
/*     */   }
/*     */   
/*     */   protected IActionConfig createErrorAction() {
/* 218 */     return createAction("Error", (IXstActionKey)OpStubConstants.ERROR, "F9");
/*     */   }
/*     */   
/*     */   protected IActionConfig createNotApplicableAction() {
/* 222 */     return createAction("Not Applicable", (IXstActionKey)OpStubConstants.NOT_APPLICABLE, "F1");
/*     */   }
/*     */   
/*     */   protected IFormattableConfig createTextKey(String argKey) {
/* 226 */     if (TranslationHelper.getInstance().isTranslationKey(argKey)) {
/* 227 */       return (IFormattableConfig)new TranslatableConfig(argKey);
/*     */     }
/*     */     
/* 230 */     return (IFormattableConfig)new LiteralConfig(argKey);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Action getAction(IActionConfig argActionConfig) {
/* 235 */     for (Action action : getAnnotation().actions()) {
/* 236 */       if (action.label().equals(argActionConfig.getKey().toString())) {
/* 237 */         return action;
/*     */       }
/*     */     } 
/* 240 */     return null;
/*     */   }
/*     */   
/*     */   protected StubbedOperation getAnnotation() {
/* 244 */     return getStubbedOp().getClass().<StubbedOperation>getAnnotation(StubbedOperation.class);
/*     */   }
/*     */   
/*     */   protected String getKeyStroke(int argIndex) {
/* 248 */     return KEY_STROKE_POOL[argIndex % KEY_STROKE_POOL.length];
/*     */   }
/*     */   
/*     */   protected boolean isResponseTypePresent(ResponseType argResponseType) {
/* 252 */     for (Action action : getAnnotation().actions()) {
/* 253 */       if (action.responseType() == argResponseType) {
/* 254 */         return true;
/*     */       }
/*     */     } 
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   protected void setConfigOrders(Iterable<? extends IActionConfig> argActionConfigs) {
/* 261 */     int counter = 0;
/* 262 */     for (IActionConfig config : argActionConfigs)
/* 263 */       config.setConfigObject("order", (IConfigObject)new IntegerConfig(Integer.valueOf(counter++))); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\StubOpPromptConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */