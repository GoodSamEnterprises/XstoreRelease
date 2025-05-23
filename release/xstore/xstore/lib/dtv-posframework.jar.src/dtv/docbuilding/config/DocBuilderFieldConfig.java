/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.AbstractDocBuilderField;
/*     */ import dtv.docbuilding.DocBuilderFieldFactory;
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.docbuilding.types.DocBuilderFieldType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderFieldConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  29 */   private static final Logger logger_ = Logger.getLogger(DocBuilderFieldConfig.class);
/*     */   
/*     */   private static final String TRANSLATE_IF_KEY_FORMATTER = "TranslateIfKey";
/*     */   
/*  33 */   private final List<IReflectionParameterCapable<?>> methodParams_ = new ArrayList<>();
/*     */   
/*  35 */   private final List<DocBuilderFieldConfig> memberConfigs_ = new ArrayList<>();
/*  36 */   private final List<ParameterConfig> parameters_ = new ArrayList<>();
/*     */   
/*  38 */   private DocBuilderFieldType contentsType_ = null;
/*  39 */   private Object contents_ = "";
/*  40 */   private String style_ = "";
/*  41 */   private Integer location_ = null;
/*  42 */   private DocBuilderAlignmentType alignment_ = null;
/*  43 */   private int priority_ = 0;
/*  44 */   private String formatterName_ = null;
/*  45 */   private DocBuilderFieldConfig separator_ = null;
/*  46 */   private Integer colWidth_ = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderFieldConfig() {}
/*     */ 
/*     */   
/*     */   public DocBuilderFieldConfig(int argSpaces) {
/*  54 */     this.contentsType_ = DocBuilderFieldType.TEXT;
/*  55 */     this.contents_ = StringUtils.fill(' ', argSpaces);
/*     */   }
/*     */   
/*     */   public DocBuilderAlignmentType getAlignment() {
/*  59 */     return this.alignment_;
/*     */   }
/*     */   
/*     */   public Integer getColWidth() {
/*  63 */     return this.colWidth_;
/*     */   }
/*     */   
/*     */   public Object getContent() {
/*  67 */     return this.contents_;
/*     */   }
/*     */   
/*     */   public DocBuilderFieldType getContentType() {
/*  71 */     return this.contentsType_;
/*     */   }
/*     */   
/*     */   public IOutputFormatter getFormatter(FormatterMapConfig argFormatterMap) {
/*  75 */     String formatterName = this.formatterName_;
/*     */     
/*  77 */     if (StringUtils.isEmpty(formatterName)) {
/*  78 */       switch (this.contentsType_) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case TEXT:
/*     */         case METHOD:
/*     */         case AGGREGATE:
/*  87 */           formatterName = "TranslateIfKey";
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  97 */     return argFormatterMap.getFormatter(formatterName);
/*     */   }
/*     */   
/*     */   public String getFormatterName() {
/* 101 */     return this.formatterName_;
/*     */   }
/*     */   
/*     */   public Integer getLocation() {
/* 105 */     return this.location_;
/*     */   }
/*     */   
/*     */   public List<DocBuilderFieldConfig> getMemberConfigs() {
/* 109 */     return this.memberConfigs_;
/*     */   }
/*     */   
/*     */   public List<IReflectionParameterCapable<?>> getMethodParameters() {
/* 113 */     return this.methodParams_;
/*     */   }
/*     */   
/*     */   public List<ParameterConfig> getParameterConfigs() {
/* 117 */     return this.parameters_;
/*     */   }
/*     */   
/*     */   public int getPriority() {
/* 121 */     return this.priority_;
/*     */   }
/*     */   
/*     */   public DocBuilderFieldConfig getSeparator() {
/* 125 */     return this.separator_;
/*     */   }
/*     */   
/*     */   public String getStyle() {
/* 129 */     return this.style_;
/*     */   }
/*     */   
/*     */   public boolean isSpaces() {
/* 133 */     return (this.contentsType_ == DocBuilderFieldType.TEXT && StringUtils.isEmpty(this.contents_.toString()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField makeField(FormatterMapConfig argFormatterMap) {
/*     */     Object contents;
/* 143 */     if (this.alignment_ == null) {
/* 144 */       if (this.location_ == null) {
/* 145 */         this.alignment_ = DocBuilderAlignmentType.DEFAULT;
/*     */       }
/* 147 */       else if (this.location_.intValue() < 0) {
/* 148 */         this.alignment_ = DocBuilderAlignmentType.RIGHT;
/*     */       } else {
/*     */         
/* 151 */         this.alignment_ = DocBuilderAlignmentType.LEFT;
/*     */       } 
/*     */     }
/*     */     
/* 155 */     if (this.contentsType_ == DocBuilderFieldType.ITERATOR) {
/* 156 */       Object[] oa = new Object[3];
/* 157 */       oa[0] = this.contents_;
/* 158 */       List<IDocBuilderField> fields = new ArrayList<>(this.memberConfigs_.size());
/* 159 */       for (int i = 0; i < this.memberConfigs_.size(); i++) {
/*     */         try {
/* 161 */           fields.add(((DocBuilderFieldConfig)this.memberConfigs_.get(i)).makeField(argFormatterMap));
/*     */         }
/* 163 */         catch (Exception ex) {
/* 164 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */       } 
/* 167 */       oa[1] = fields;
/* 168 */       if (this.separator_ == null) {
/* 169 */         oa[2] = null;
/*     */       } else {
/*     */         
/* 172 */         oa[2] = this.separator_.makeField(argFormatterMap);
/*     */       } 
/* 174 */       contents = oa;
/*     */     } else {
/*     */       
/* 177 */       contents = this.contents_;
/*     */     } 
/* 179 */     IDocBuilderField field = DocBuilderFieldFactory.getInstance().makeDocBuilderField(this.contentsType_, contents, this.methodParams_, this.style_, this.location_, this.alignment_, this.priority_, 
/* 180 */         getFormatter(argFormatterMap));
/*     */     
/* 182 */     field.setSourceDescription(getSourceDescription());
/*     */     
/* 184 */     if (field instanceof AbstractDocBuilderField) {
/* 185 */       ((AbstractDocBuilderField)field).setColWidth(this.colWidth_);
/*     */     }
/*     */     
/* 188 */     for (ParameterConfig param : this.parameters_) {
/* 189 */       field.setParameter(param.getName(), param.getValue());
/*     */     }
/* 191 */     return field;
/*     */   }
/*     */   
/*     */   public void setAlignment(DocBuilderAlignmentType argAlignment) {
/* 195 */     this.alignment_ = argAlignment;
/*     */   }
/*     */   
/*     */   public void setColWidth(Integer argColWidth) {
/* 199 */     this.colWidth_ = argColWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 206 */     if ("text".equalsIgnoreCase(argKey)) {
/* 207 */       this.contentsType_ = DocBuilderFieldType.TEXT;
/* 208 */       this.contents_ = argValue.toString();
/*     */     }
/* 210 */     else if ("method".equalsIgnoreCase(argKey)) {
/* 211 */       if (this.contentsType_ != DocBuilderFieldType.ITERATOR) {
/* 212 */         this.contentsType_ = DocBuilderFieldType.METHOD;
/*     */       }
/* 214 */       this.contents_ = argValue.toString();
/*     */     }
/* 216 */     else if (argValue instanceof DocBuilderFieldConfig) {
/* 217 */       if ("separator".equalsIgnoreCase(argKey)) {
/* 218 */         this.separator_ = (DocBuilderFieldConfig)argValue;
/*     */       } else {
/*     */         
/* 221 */         this.memberConfigs_.add((DocBuilderFieldConfig)argValue);
/* 222 */         this.contentsType_ = DocBuilderFieldType.ITERATOR;
/*     */       }
/*     */     
/* 225 */     } else if ("method_param".equalsIgnoreCase(argKey)) {
/* 226 */       this.methodParams_.add((IReflectionParameterCapable)argValue);
/*     */     }
/* 228 */     else if ("systemproperty".equalsIgnoreCase(argKey)) {
/* 229 */       this.contentsType_ = DocBuilderFieldType.SYSTEMPROPERTY;
/* 230 */       this.contents_ = argValue.toString();
/*     */     }
/* 232 */     else if (argValue instanceof DocBuilderAggregateConfig && "aggregate".equalsIgnoreCase(argKey)) {
/* 233 */       this.contentsType_ = DocBuilderFieldType.AGGREGATE;
/* 234 */       this.contents_ = argValue;
/*     */     }
/* 236 */     else if ("style".equalsIgnoreCase(argKey)) {
/* 237 */       this.style_ = argValue.toString();
/*     */     }
/* 239 */     else if ("location".equalsIgnoreCase(argKey) || "loc".equalsIgnoreCase(argKey)) {
/* 240 */       this.location_ = Integer.valueOf(ConfigUtils.toInt(argValue));
/*     */     }
/* 242 */     else if ("columnwidth".equalsIgnoreCase(argKey) || "colwidth".equalsIgnoreCase(argKey)) {
/* 243 */       this.colWidth_ = Integer.valueOf(ConfigUtils.toInt(argValue));
/*     */     }
/* 245 */     else if ("alignment".equalsIgnoreCase(argKey) || "align".equalsIgnoreCase(argKey)) {
/* 246 */       this.alignment_ = DocBuilderAlignmentType.forName(argValue.toString());
/*     */     }
/* 248 */     else if ("formatter".equalsIgnoreCase(argKey)) {
/* 249 */       this.formatterName_ = argValue.toString();
/*     */     }
/* 251 */     else if ("priority".equalsIgnoreCase(argKey)) {
/* 252 */       this.priority_ = ConfigUtils.toInt(argValue);
/*     */     }
/* 254 */     else if ("n".equalsIgnoreCase(argKey)) {
/* 255 */       this.contentsType_ = DocBuilderFieldType.TEXT;
/* 256 */       this.contents_ = StringUtils.fill(' ', ConfigUtils.toInt(argValue, 1));
/*     */     }
/* 258 */     else if (argValue instanceof DocBuilderFieldConfig && "separator".equalsIgnoreCase(argKey)) {
/* 259 */       this.separator_ = (DocBuilderFieldConfig)argValue;
/*     */     }
/* 261 */     else if (argValue instanceof ParameterConfig) {
/* 262 */       this.parameters_.add((ParameterConfig)argValue);
/*     */     } else {
/*     */       
/* 265 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setContent(Object argContent) {
/* 270 */     this.contents_ = argContent;
/*     */   }
/*     */   
/*     */   public void setContentType(DocBuilderFieldType argType) {
/* 274 */     this.contentsType_ = argType;
/*     */   }
/*     */   
/*     */   public void setFormatterName(String argName) {
/* 278 */     this.formatterName_ = argName;
/*     */   }
/*     */   
/*     */   public void setLocation(Integer argLocation) {
/* 282 */     this.location_ = argLocation;
/*     */   }
/*     */   
/*     */   public void setMemberConfigs(List<DocBuilderFieldConfig> argMembers) {
/* 286 */     this.memberConfigs_.clear();
/* 287 */     this.memberConfigs_.addAll(argMembers);
/*     */   }
/*     */   
/*     */   public void setMethodParameters(List<IReflectionParameterCapable<?>> argParams) {
/* 291 */     this.methodParams_.clear();
/* 292 */     this.methodParams_.addAll(argParams);
/*     */   }
/*     */   
/*     */   public void setParameterConfigs(List<ParameterConfig> argParams) {
/* 296 */     this.parameters_.clear();
/* 297 */     this.parameters_.addAll(argParams);
/*     */   }
/*     */   
/*     */   public void setPriority(int argPriority) {
/* 301 */     this.priority_ = argPriority;
/*     */   }
/*     */   
/*     */   public void setStyle(String argStyle) {
/* 305 */     this.style_ = argStyle;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */