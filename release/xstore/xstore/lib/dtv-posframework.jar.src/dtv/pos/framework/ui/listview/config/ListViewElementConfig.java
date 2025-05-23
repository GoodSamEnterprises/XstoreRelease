/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.action.IXstActionFactory;
/*     */ import dtv.pos.framework.touch.HiddenButtonConfig;
/*     */ import dtv.pos.framework.touch.rules.AccessResponsivenessRule;
/*     */ import dtv.pos.framework.ui.config.AbstractUIConfig;
/*     */ import dtv.pos.framework.ui.listview.DefaultViewElement;
/*     */ import dtv.pos.framework.ui.listview.IViewElement;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.ITouchResponsivenessRule;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.util.common.CommonConstants;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
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
/*     */ public class ListViewElementConfig
/*     */   extends AbstractUIConfig
/*     */   implements IListViewElementConfig
/*     */ {
/*     */   public static final String MAIN_TAG = "Element";
/*  43 */   private static final Logger logger_ = Logger.getLogger(ListViewElementConfig.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   private static final String TYPE_TAG = "Type";
/*     */   private static final String RENDERER_CLASS_TAG = "RendererClass";
/*     */   private static final String ICON_KEY_TAG = "iconKey";
/*  50 */   private final List<ListViewRowConfig> _rows = new ArrayList<>();
/*     */   
/*     */   private IViewElementType _type;
/*     */   
/*     */   private ClassConfig<IViewElement> _rendererClass;
/*     */   private IViewElement _renderer;
/*     */   private String _hiddenButtonAction;
/*     */   private List<ITouchResponsivenessRule> _hiddenButtonResponsivenessRules;
/*     */   private String _iconKey;
/*     */   @Inject
/*     */   private IXstActionFactory _actionFactory;
/*     */   
/*     */   public ListViewElementConfig() {
/*  63 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstAction getHiddenButtonAction() {
/*  69 */     if (this._hiddenButtonAction != null) {
/*  70 */       IXstAction action = this._actionFactory.getAction(this._hiddenButtonAction);
/*  71 */       action.evaluateVisibility();
/*  72 */       List<ITouchResponsivenessRule> rules = AccessResponsivenessRule.getRules(action.getVisibilityRules());
/*  73 */       rules.addAll(getHiddenButtonResponsivenessRules());
/*  74 */       action.putValue("HiddenButtonResponsivenessRules", rules);
/*  75 */       return action;
/*     */     } 
/*     */     
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   public List<ITouchResponsivenessRule> getHiddenButtonResponsivenessRules() {
/*  82 */     return this._hiddenButtonResponsivenessRules;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIconKey() {
/*  87 */     return this._iconKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElement getRenderer() {
/*  93 */     String formFactor = System.getProperty("dtv.location.device.formfactor", CommonConstants.FormFactor.desktop.name());
/*     */     
/*  95 */     if (CommonConstants.FormFactor.valueOf(formFactor).isMobile()) {
/*  96 */       return createViewElement();
/*     */     }
/*     */     
/*  99 */     if (this._renderer == null) {
/* 100 */       this._renderer = createViewElement();
/*     */     }
/*     */     
/* 103 */     return this._renderer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ListViewRowConfig> getRows() {
/* 114 */     return this._rows;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getType() {
/* 125 */     return this._type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 132 */     if (argValue instanceof ListViewRowConfig && "Row".equalsIgnoreCase(argKey)) {
/* 133 */       this._rows.add((ListViewRowConfig)argValue);
/*     */     }
/* 135 */     else if ("name".equalsIgnoreCase(argKey) || "Type".equalsIgnoreCase(argKey)) {
/* 136 */       this._type = ViewElementType.valueOf(argValue.toString());
/*     */     }
/* 138 */     else if ("RendererClass".equalsIgnoreCase(argKey)) {
/* 139 */       ClassConfig<?> value = ConfigUtils.toClassConfig(argValue);
/* 140 */       this._rendererClass = (ClassConfig)value;
/*     */     }
/* 142 */     else if (argValue instanceof HiddenButtonConfig) {
/* 143 */       this._hiddenButtonAction = ((HiddenButtonConfig)argValue).getActionName();
/* 144 */       this._hiddenButtonResponsivenessRules = ((HiddenButtonConfig)argValue).getResponsivenessRules();
/*     */     }
/* 146 */     else if ("hiddenButton".equalsIgnoreCase(argKey)) {
/* 147 */       this._hiddenButtonAction = argValue.toString();
/*     */     }
/* 149 */     else if ("iconKey".equals(argKey)) {
/* 150 */       this._iconKey = argValue.toString();
/*     */     } else {
/*     */       
/* 153 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   private IViewElement createViewElement() {
/*     */     DefaultViewElement defaultViewElement;
/* 158 */     IViewElement viewElement = null;
/*     */     
/* 160 */     if (this._rendererClass != null) {
/*     */       try {
/* 162 */         viewElement = this._rendererClass.getValue().newInstance();
/*     */       }
/* 164 */       catch (Exception ex) {
/* 165 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     } else {
/*     */       
/* 169 */       defaultViewElement = new DefaultViewElement(false);
/*     */     } 
/*     */     
/* 172 */     defaultViewElement.setConfig(this);
/*     */     
/* 174 */     return (IViewElement)defaultViewElement;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewElementConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */