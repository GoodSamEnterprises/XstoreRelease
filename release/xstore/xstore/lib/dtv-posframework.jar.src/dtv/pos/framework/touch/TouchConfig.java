/*     */ package dtv.pos.framework.touch;
/*     */ 
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.touch.rules.AccessResponsivenessRule;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.security.ISecureAction;
/*     */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*     */ import dtv.pos.iframework.ui.config.IActionConfig;
/*     */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*     */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.ui.touch.TouchConstants;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.security.ISecured;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TouchConfig
/*     */   extends AbstractParentConfig
/*     */   implements IConfigObject, ITouchConfig, ISavableConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String TOUCH_TAG = "touch";
/*     */   private String actionConfigRef_;
/*     */   private IActionConfig actionConfig_;
/*     */   private List<ResponsivenessRuleConfig> rules_;
/*     */   
/*     */   public static String getPrivilege(IXstAction action) {
/*  41 */     if (action != null) {
/*  42 */       IAccessLevel level = null;
/*  43 */       String privilegeName = null;
/*     */       
/*  45 */       for (IVisibilityRule rule : action.getVisibilityRules()) {
/*     */ 
/*     */         
/*     */         try {
/*  49 */           IAccessLevel current = rule.checkVisibility();
/*     */           
/*  51 */           if (level == null) {
/*  52 */             level = current;
/*     */             
/*  54 */             if (rule instanceof ISecured) {
/*  55 */               privilegeName = ((ISecured)rule).getPrivilege();
/*     */             }
/*     */             continue;
/*     */           } 
/*  59 */           if (current.getLevel() < level.getLevel()) {
/*  60 */             level = current;
/*     */             
/*  62 */             if (rule instanceof ISecured)
/*  63 */               privilegeName = ((ISecured)rule).getPrivilege(); 
/*     */             continue;
/*     */           } 
/*  66 */           if (current.getLevel() == level.getLevel() && current.isPrivilegeBased()) {
/*  67 */             level = current;
/*     */             
/*  69 */             if (rule instanceof ISecured) {
/*  70 */               privilegeName = ((ISecured)rule).getPrivilege();
/*     */             }
/*     */           }
/*     */         
/*     */         }
/*  75 */         catch (Exception exception) {}
/*     */       } 
/*     */       
/*  78 */       if (level != AccessLevel.GRANTED) {
/*  79 */         return privilegeName;
/*     */       }
/*     */     } 
/*     */     
/*  83 */     return null;
/*     */   }
/*     */   
/*     */   public static List<ITouchResponsivenessRule> getRules(ITouchConfig config) {
/*  87 */     List<ITouchResponsivenessRule> rules = new ArrayList<>();
/*  88 */     IXstAction action = config.getAction();
/*     */     
/*  90 */     if (action != null && AccessResponsivenessRule.getRules(action.getVisibilityRules()) != null) {
/*  91 */       rules.addAll(AccessResponsivenessRule.getRules(action.getVisibilityRules()));
/*     */     }
/*     */     
/*  94 */     if (config.getResponsivenessRules() != null) {
/*  95 */       rules.addAll(config.getResponsivenessRules());
/*     */     }
/*     */     
/*  98 */     return rules;
/*     */   }
/*     */   
/*     */   public static IXstAction getTouchAction(ITouchConfig config) {
/* 102 */     TouchConfig touch = (TouchConfig)config;
/* 103 */     IXstAction action = touch.getAction();
/*     */     
/* 105 */     if (action instanceof ISecureAction) {
/* 106 */       String privilege = getPrivilege(action);
/*     */       
/* 108 */       if (privilege != null) {
/* 109 */         ((ISecureAction)action).addPrivilege(privilege);
/*     */       }
/*     */     } 
/*     */     
/* 113 */     return action;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   private TouchConstants.TouchType type_ = TouchConstants.TouchType.TOUCH;
/*     */   private boolean isPaintingTouch_;
/*     */   private boolean simulateGlassPane_;
/* 122 */   private IXstAction _action = null;
/*     */   
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   public TouchConfig() {}
/*     */   
/*     */   public TouchConfig(String argActionConfig) {
/* 130 */     setActionConfig(argActionConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstAction getAction() {
/* 136 */     if (this._action == null) {
/* 137 */       InjectionHammer.forceAtInjectProcessing(this);
/*     */       
/* 139 */       if (this.actionConfigRef_ != null) {
/* 140 */         this._action = this._actionFactory.getAction(this.actionConfigRef_);
/*     */       } else {
/*     */         
/* 143 */         this._action = this.actionConfig_.getAction(null);
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     return this._action;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ITouchResponsivenessRule> getResponsivenessRules() {
/* 153 */     List<ITouchResponsivenessRule> list = new ArrayList<>();
/*     */     
/* 155 */     if (this.rules_ != null) {
/* 156 */       for (ResponsivenessRuleConfig config : this.rules_) {
/* 157 */         ITouchResponsivenessRule rule = config.getRule();
/*     */         
/* 159 */         if (rule != null) {
/* 160 */           rule.setParentConfigObject(this);
/* 161 */           list.add(rule);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 166 */     return list;
/*     */   }
/*     */   
/*     */   public TouchConstants.TouchType getType() {
/* 170 */     return this.type_;
/*     */   }
/*     */   
/*     */   public boolean isPaintingTouch() {
/* 174 */     return this.isPaintingTouch_;
/*     */   }
/*     */   
/*     */   public boolean isSimulatingGlassPane() {
/* 178 */     return this.simulateGlassPane_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 184 */     if (argKey.equalsIgnoreCase("ref")) {
/* 185 */       setActionConfig(argValue.toString());
/*     */     }
/*     */     
/* 188 */     if (argKey.equalsIgnoreCase("Action") && argValue instanceof dtv.pos.framework.ui.config.ActionConfig) {
/* 189 */       setActionConfig((IActionConfig)argValue);
/*     */     }
/*     */     
/* 192 */     if (argKey.equalsIgnoreCase("ResponsivenessRule") && argValue instanceof ResponsivenessRuleConfig) {
/* 193 */       addRule((ResponsivenessRuleConfig)argValue);
/*     */     }
/*     */     
/* 196 */     if (argKey.equalsIgnoreCase("type")) {
/* 197 */       setType(TouchConstants.TouchType.forName(argValue.toString()));
/*     */     }
/*     */     
/* 200 */     if (argKey.equalsIgnoreCase("paintTouch")) {
/* 201 */       this.isPaintingTouch_ = (new BooleanConfig(argValue.toString())).getBoolean().booleanValue();
/*     */     }
/*     */     
/* 204 */     if (argKey.equalsIgnoreCase("simulateGlassPane")) {
/* 205 */       this.simulateGlassPane_ = (new BooleanConfig(argValue.toString())).getBoolean().booleanValue();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 213 */     StringBuilder attribs = new StringBuilder();
/*     */     
/* 215 */     if (this.actionConfigRef_ != null) {
/* 216 */       attribs.append(" ref=\"").append(this.actionConfigRef_).append("\"");
/*     */     }
/*     */     
/* 219 */     if (this.type_ != TouchConstants.TouchType.TOUCH && this.type_ != null) {
/* 220 */       attribs.append(" type=\"").append(this.type_).append("\"");
/*     */     }
/*     */     
/* 223 */     if (isPaintingTouch()) {
/* 224 */       attribs.append(" paintTouch=\"true\"");
/*     */     }
/*     */     
/* 227 */     if (isSimulatingGlassPane()) {
/* 228 */       attribs.append(" simulateGlassPane=\"true\"");
/*     */     }
/*     */     
/* 231 */     argWriter.writeHeader("Touch", "Touch", attribs.toString().trim());
/*     */     
/* 233 */     if (this.actionConfig_ != null) {
/* 234 */       argWriter.writeValue((ISavableConfig)this.actionConfig_);
/*     */     }
/*     */     
/* 237 */     if (this.rules_ != null) {
/* 238 */       for (ResponsivenessRuleConfig rule : this.rules_) {
/* 239 */         argWriter.writeValue(rule);
/*     */       }
/*     */     }
/*     */     
/* 243 */     argWriter.writeFooter("Touch");
/*     */   }
/*     */   
/*     */   protected void addRule(ResponsivenessRuleConfig ruleConfig) {
/* 247 */     if (this.rules_ == null) {
/* 248 */       this.rules_ = new ArrayList<>();
/*     */     }
/*     */     
/* 251 */     this.rules_.add(ruleConfig);
/*     */   }
/*     */   
/*     */   protected void setActionConfig(IActionConfig actionConfig) {
/* 255 */     this.actionConfig_ = actionConfig;
/*     */   }
/*     */   
/*     */   protected void setActionConfig(String actionConfig) {
/* 259 */     this.actionConfigRef_ = actionConfig;
/*     */   }
/*     */   
/*     */   protected void setType(TouchConstants.TouchType type) {
/* 263 */     this.type_ = type;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\TouchConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */