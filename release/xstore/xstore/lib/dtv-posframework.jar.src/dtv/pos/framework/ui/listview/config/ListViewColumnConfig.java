/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.security.SecurityUtil;
/*     */ import dtv.pos.framework.ui.config.AbstractUIConfig;
/*     */ import dtv.pos.framework.ui.config.IconRefConfig;
/*     */ import dtv.pos.framework.ui.listview.DefaultCellDataHandler;
/*     */ import dtv.pos.framework.ui.listview.ICellDataHandler;
/*     */ import dtv.pos.i18n.config.EvaluatedFormattableConfig;
/*     */ import dtv.pos.i18n.config.LiteralConfig;
/*     */ import dtv.pos.i18n.config.TranslatableConfig;
/*     */ import dtv.pos.iframework.security.AccessType;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.pos.iframework.security.SecuredObjectID;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.ui.AlignmentType;
/*     */ import dtv.ui.IViewColumnRenderer;
/*     */ import dtv.util.common.CommonConstants;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IconConfig;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListViewColumnConfig
/*     */   extends AbstractUIConfig
/*     */ {
/*     */   public static final String MAIN_TAG = "Column";
/*     */   private static final long serialVersionUID = 1L;
/*  40 */   private static final Logger logger_ = Logger.getLogger(ListViewColumnConfig.class);
/*     */   
/*     */   private static final String ACL_TAG = "SecuredObject";
/*     */   private static final String ALIGNMENT_KEY_TAG = "Alignment";
/*     */   private static final String VALIGNMENT_KEY_TAG = "VAlignment";
/*     */   private static final String CELL_DATA_FACTORY_CLASS_TAG = "CellDataHandlerFactoryClass";
/*     */   private static final String ICON_TAG = "Icon";
/*     */   private static final String PARAMETER_TAG = "Parameter";
/*     */   private static final String RENDERER_CLASS_TAG = "RendererClass";
/*     */   private static final String SEARCH_ON_TAG = "SearchOn";
/*     */   private static final String START_TAG = "Start";
/*     */   private static final String WRAP_TEXT = "WrapText";
/*     */   private static final String TRANSLATABLE_KEY_TAG = "Translatable";
/*     */   private static final String LITERAL_KEY_TAG = "Literal";
/*     */   private static final String METHOD_KEY_TAG = "Method";
/*     */   private static final String METHOD2_KEY_TAG = "Method2";
/*     */   private static final String FORMATTER_KEY_TAG = "Formatter";
/*     */   private AlignmentType alignment_;
/*     */   private AlignmentType vAlignment_;
/*     */   private IFormattableConfig attributeConfig_;
/*     */   private IFormattableConfig attributeConfig2_;
/*     */   private ICellDataHandler cellDataHandlerFactory_;
/*     */   private Class<ICellDataHandler> cellDataHandlerFactoryClass_;
/*     */   private ImageIcon icon_;
/*  64 */   private final List<ParameterConfig> params_ = new ArrayList<>();
/*     */   private IViewColumnRenderer renderer_;
/*     */   private ClassConfig<IViewColumnRenderer> rendererClass_;
/*     */   private boolean searchOn_ = false;
/*  68 */   private final List<SecuredObjectID> securedObjectIds_ = new ArrayList<>();
/*     */   
/*     */   private Integer start_;
/*     */   
/*     */   private boolean wrapText_ = false;
/*     */   
/*     */   @Inject
/*     */   private SecurityUtil _securityUtil;
/*     */   @Inject
/*     */   private StationState _stationState;
/*     */   
/*     */   public ListViewColumnConfig() {
/*  80 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */   
/*     */   public AlignmentType getAlignment() {
/*  84 */     if (this.alignment_ == null) {
/*  85 */       this.alignment_ = AlignmentType.DEFAULT;
/*     */     }
/*  87 */     return this.alignment_;
/*     */   }
/*     */   
/*     */   public IFormattable getAttribute() {
/*  91 */     return (this.attributeConfig_ != null) ? this.attributeConfig_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */   
/*     */   public IFormattable getAttribute(Object argTarget) {
/*  95 */     if (argTarget == null) {
/*  96 */       return getAttribute();
/*     */     }
/*  98 */     return (this.attributeConfig_ != null) ? this.attributeConfig_.getFormattable(argTarget) : IFormattable.EMPTY;
/*     */   }
/*     */   
/*     */   public IFormattable getAttribute2() {
/* 102 */     return (this.attributeConfig2_ != null) ? this.attributeConfig2_.getFormattable() : IFormattable.EMPTY;
/*     */   }
/*     */   
/*     */   public IFormattableConfig getAttributeConfig() {
/* 106 */     return this.attributeConfig_;
/*     */   }
/*     */   
/*     */   public IFormattableConfig getAttributeConfig2() {
/* 110 */     return this.attributeConfig2_;
/*     */   }
/*     */   
/*     */   public ICellDataHandler getCellDataHandlerFactory() {
/* 114 */     String formFactor = System.getProperty("dtv.location.device.formfactor", CommonConstants.FormFactor.desktop.name());
/*     */     
/* 116 */     if (CommonConstants.FormFactor.valueOf(formFactor).isMobile()) {
/* 117 */       return createCellDataHandler();
/*     */     }
/*     */     
/* 120 */     if (this.cellDataHandlerFactory_ == null) {
/* 121 */       this.cellDataHandlerFactory_ = createCellDataHandler();
/*     */     }
/*     */     
/* 124 */     return this.cellDataHandlerFactory_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ImageIcon getIcon() {
/* 129 */     return this.icon_;
/*     */   }
/*     */   
/*     */   public IViewColumnRenderer getRenderer() {
/* 133 */     String formFactor = System.getProperty("dtv.location.device.formfactor", CommonConstants.FormFactor.desktop.name());
/*     */     
/* 135 */     if ((this.renderer_ == null || CommonConstants.FormFactor.valueOf(formFactor).isMobile()) && this.rendererClass_ != null) {
/*     */       try {
/* 137 */         this.renderer_ = this.rendererClass_.getValue().newInstance();
/*     */       }
/* 139 */       catch (Exception ex) {
/* 140 */         logger_.error("CAUGHT EXCEPTION with " + this.rendererClass_.getSourceDescription(), ex);
/*     */       } 
/*     */     }
/*     */     
/* 144 */     return this.renderer_;
/*     */   }
/*     */   
/*     */   public int getStart() {
/* 148 */     return ConfigUtils.asInt(this.start_);
/*     */   }
/*     */   
/*     */   public AlignmentType getVAlignment() {
/* 152 */     if (this.vAlignment_ == null) {
/* 153 */       this.vAlignment_ = AlignmentType.CENTER;
/*     */     }
/* 155 */     return this.vAlignment_;
/*     */   }
/*     */   
/*     */   public boolean isSearchedOn() {
/* 159 */     return this.searchOn_;
/*     */   }
/*     */   
/*     */   public boolean isTextWrapped() {
/* 163 */     return this.wrapText_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 169 */     if (argKey.equalsIgnoreCase("Start")) {
/* 170 */       setStart(Integer.valueOf(ConfigUtils.toInt(argValue)));
/*     */     }
/* 172 */     else if (argKey.equalsIgnoreCase("RendererClass") && argValue instanceof ClassConfig) {
/* 173 */       setRenderer((ClassConfig)argValue);
/*     */     }
/* 175 */     else if (argValue instanceof IFormattableConfig) {
/* 176 */       setAttributeConfig((IFormattableConfig)argValue);
/*     */     }
/* 178 */     else if (argKey.equalsIgnoreCase("Alignment")) {
/* 179 */       setAlignment(AlignmentType.forName(argValue.toString()));
/*     */     }
/* 181 */     else if (argKey.equalsIgnoreCase("VAlignment")) {
/* 182 */       setVAlignment(AlignmentType.forName(argValue.toString()));
/*     */     }
/* 184 */     else if (argKey.equalsIgnoreCase("CellDataHandlerFactoryClass") && argValue instanceof ClassConfig) {
/* 185 */       this.cellDataHandlerFactoryClass_ = ((ClassConfig)argValue).getValue();
/*     */     }
/* 187 */     else if (argKey.equalsIgnoreCase("SecuredObject")) {
/* 188 */       this.securedObjectIds_.add(SecuredObjectID.forName(argValue));
/*     */     }
/* 190 */     else if (argKey.equalsIgnoreCase("Icon")) {
/* 191 */       if (argValue instanceof IconConfig) {
/* 192 */         this.icon_ = ((IconConfig)argValue).getIcon();
/*     */       } else {
/*     */         
/* 195 */         this.icon_ = (new IconRefConfig(argValue.toString())).getIcon();
/*     */       }
/*     */     
/* 198 */     } else if (argKey.equalsIgnoreCase("SearchOn")) {
/* 199 */       this.searchOn_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 201 */     else if (argKey.equalsIgnoreCase("WrapText")) {
/* 202 */       this.wrapText_ = ConfigUtils.toBoolean(argValue);
/*     */     }
/* 204 */     else if (argKey.equalsIgnoreCase("Parameter") && argValue instanceof ParameterConfig) {
/* 205 */       this.params_.add((ParameterConfig)argValue);
/*     */     }
/* 207 */     else if (argKey.equalsIgnoreCase("Translatable")) {
/* 208 */       setAttributeConfig((IFormattableConfig)new TranslatableConfig(argValue.toString()));
/*     */     }
/* 210 */     else if (argKey.equalsIgnoreCase("Literal")) {
/* 211 */       setAttributeConfig((IFormattableConfig)new LiteralConfig(argValue.toString()));
/*     */     }
/* 213 */     else if (argKey.equalsIgnoreCase("Method")) {
/* 214 */       EvaluatedFormattableConfig efc = (this.attributeConfig_ == null) ? new EvaluatedFormattableConfig() : (EvaluatedFormattableConfig)this.attributeConfig_;
/*     */       
/* 216 */       efc.setConfigObject("Method", argValue);
/* 217 */       setAttributeConfig((IFormattableConfig)efc);
/*     */     }
/* 219 */     else if (argKey.equalsIgnoreCase("Method2")) {
/* 220 */       EvaluatedFormattableConfig efc = (this.attributeConfig2_ == null) ? new EvaluatedFormattableConfig() : (EvaluatedFormattableConfig)this.attributeConfig2_;
/*     */       
/* 222 */       efc.setConfigObject("Method2", argValue);
/* 223 */       setAttributeConfig2((IFormattableConfig)efc);
/*     */     }
/* 225 */     else if (argKey.equalsIgnoreCase("Formatter")) {
/* 226 */       EvaluatedFormattableConfig efc = (this.attributeConfig_ == null) ? new EvaluatedFormattableConfig() : (EvaluatedFormattableConfig)this.attributeConfig_;
/*     */       
/* 228 */       efc.setConfigObject("Formatter", argValue);
/* 229 */       setAttributeConfig((IFormattableConfig)efc);
/*     */     } else {
/*     */       
/* 232 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean validateSecurity() {
/* 237 */     if (this.securedObjectIds_.size() == 0) {
/* 238 */       return true;
/*     */     }
/*     */     
/* 241 */     SecuredObjectID[] acls = this.securedObjectIds_.<SecuredObjectID>toArray(new SecuredObjectID[this.securedObjectIds_.size()]);
/* 242 */     for (SecuredObjectID element : acls) {
/*     */       
/* 244 */       if (!this._securityUtil.getAcl((ISecuredObjectID)element).getAccessLevel(AccessType.READ, this._stationState.getSystemUser()).isGranted()) {
/* 245 */         return false;
/*     */       }
/*     */     } 
/* 248 */     return true;
/*     */   }
/*     */   
/*     */   private ICellDataHandler createCellDataHandler() {
/*     */     ICellDataHandler iCellDataHandler;
/* 253 */     DefaultCellDataHandler defaultCellDataHandler = new DefaultCellDataHandler();
/*     */     
/* 255 */     if (this.cellDataHandlerFactoryClass_ != null) {
/*     */       try {
/* 257 */         iCellDataHandler = this.cellDataHandlerFactoryClass_.newInstance();
/*     */       }
/* 259 */       catch (Exception ex) {
/* 260 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/*     */     
/* 264 */     for (ParameterConfig element : this.params_) {
/* 265 */       ParameterConfig param = element;
/* 266 */       iCellDataHandler.setParameter(param.getName(), param.getValue());
/*     */     } 
/*     */     
/* 269 */     return iCellDataHandler;
/*     */   }
/*     */   
/*     */   private void setAlignment(AlignmentType alignment) {
/* 273 */     this.alignment_ = alignment;
/*     */   }
/*     */   
/*     */   private void setAttributeConfig(IFormattableConfig attributeConfig) {
/* 277 */     this.attributeConfig_ = attributeConfig;
/*     */   }
/*     */   
/*     */   private void setAttributeConfig2(IFormattableConfig attributeConfig) {
/* 281 */     this.attributeConfig2_ = attributeConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRenderer(ClassConfig<?> newValue) {
/* 286 */     this.rendererClass_ = (ClassConfig)newValue;
/*     */   }
/*     */   
/*     */   private void setStart(Integer start) {
/* 290 */     this.start_ = start;
/*     */   }
/*     */   
/*     */   private void setVAlignment(AlignmentType alignment) {
/* 294 */     this.vAlignment_ = alignment;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewColumnConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */