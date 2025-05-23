/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.iframework.ui.config.IEditFormatterParams;
/*     */ import dtv.util.config.BigDecimalConfig;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EditFormatterParams
/*     */   implements IEditFormatterParams
/*     */ {
/*  24 */   private static final Logger logger_ = Logger.getLogger(EditFormatterParams.class);
/*     */   
/*     */   private Integer maxCharacters_;
/*     */   
/*     */   private String regexPolicy_;
/*     */   
/*     */   private Integer maximumIntegerDigits_;
/*     */   private Integer maximumFractionalDigits_;
/*     */   private Boolean allowNegative_;
/*     */   private Boolean allowNull_;
/*     */   private BigDecimal maximumAllowedValue_;
/*     */   private BigDecimal minimumAllowedValue_;
/*     */   
/*     */   public EditFormatterParams() {}
/*     */   
/*     */   public EditFormatterParams(ParameterConfig[] argConfigs) {
/*  40 */     for (ParameterConfig c : argConfigs) {
/*  41 */       if ("maxCharacters".equalsIgnoreCase(c.getName())) {
/*  42 */         this.maxCharacters_ = (Integer)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  44 */       else if ("regexPolicy".equalsIgnoreCase(c.getName())) {
/*  45 */         this.regexPolicy_ = (String)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  47 */       else if ("maximumIntegerDigits".equalsIgnoreCase(c.getName())) {
/*  48 */         this.maximumIntegerDigits_ = (Integer)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  50 */       else if ("maximumFractionalDigits".equalsIgnoreCase(c.getName())) {
/*  51 */         this.maximumFractionalDigits_ = (Integer)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  53 */       else if ("allowNegative".equalsIgnoreCase(c.getName())) {
/*  54 */         this.allowNegative_ = (Boolean)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  56 */       else if ("allowNull".equalsIgnoreCase(c.getName())) {
/*  57 */         this.allowNull_ = (Boolean)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  59 */       else if ("maximumAllowedValue".equalsIgnoreCase(c.getName())) {
/*  60 */         this.maximumAllowedValue_ = (BigDecimal)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       }
/*  62 */       else if ("minimumAllowedValue".equalsIgnoreCase(c.getName())) {
/*  63 */         this.minimumAllowedValue_ = (BigDecimal)((IReflectionParameterCapable)c.getValue()).getParamValue();
/*     */       } else {
/*     */         
/*  66 */         logger_.warn("unexpected param [" + c.getName() + "]");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getAllowNegative() {
/*  74 */     return this.allowNegative_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getAllowNull() {
/*  79 */     return this.allowNull_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParameterConfig[] getConfigs() {
/*  84 */     List<ParameterConfig> list = new ArrayList<>();
/*  85 */     if (this.maxCharacters_ != null) {
/*  86 */       list.add(new ParameterConfig(new StringConfig("maxCharacters"), (IConfigObject)new IntegerConfig(this.maxCharacters_)));
/*     */     }
/*  88 */     if (this.regexPolicy_ != null) {
/*  89 */       list.add(new ParameterConfig(new StringConfig("regexPolicy"), (IConfigObject)new StringConfig(this.regexPolicy_)));
/*     */     }
/*  91 */     if (this.maximumIntegerDigits_ != null) {
/*  92 */       list.add(new ParameterConfig(new StringConfig("maximumIntegerDigits"), (IConfigObject)new IntegerConfig(this.maximumIntegerDigits_)));
/*     */     }
/*  94 */     if (this.maximumFractionalDigits_ != null) {
/*  95 */       list.add(new ParameterConfig(new StringConfig("maximumFractionalDigits"), (IConfigObject)new IntegerConfig(this.maximumFractionalDigits_)));
/*     */     }
/*     */     
/*  98 */     if (this.allowNegative_ != null) {
/*  99 */       list.add(new ParameterConfig(new StringConfig("allowNegative"), (IConfigObject)new BooleanConfig(this.allowNegative_)));
/*     */     }
/* 101 */     if (this.allowNull_ != null) {
/* 102 */       list.add(new ParameterConfig(new StringConfig("allowNull"), (IConfigObject)new BooleanConfig(this.allowNull_)));
/*     */     }
/* 104 */     if (this.maximumAllowedValue_ != null) {
/* 105 */       list.add(new ParameterConfig(new StringConfig("maximumAllowedValue"), (IConfigObject)new BigDecimalConfig(this.maximumAllowedValue_)));
/*     */     }
/*     */     
/* 108 */     if (this.minimumAllowedValue_ != null) {
/* 109 */       list.add(new ParameterConfig(new StringConfig("minimumAllowedValue"), (IConfigObject)new BigDecimalConfig(this.minimumAllowedValue_)));
/*     */     }
/*     */     
/* 112 */     return list.<ParameterConfig>toArray(new ParameterConfig[list.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getMaxCharacters() {
/* 117 */     return this.maxCharacters_;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getMaximumAllowedValue() {
/* 122 */     return this.maximumAllowedValue_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getMaximumFractionalDigits() {
/* 127 */     return this.maximumFractionalDigits_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getMaximumIntegerDigits() {
/* 132 */     return this.maximumIntegerDigits_;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getMinimumAllowedValue() {
/* 137 */     return this.minimumAllowedValue_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRegexPolicy() {
/* 142 */     return this.regexPolicy_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasChanges() {
/* 147 */     return (this.maxCharacters_ != null || this.regexPolicy_ != null || this.maximumIntegerDigits_ != null || this.maximumFractionalDigits_ != null || this.allowNegative_ != null || this.allowNull_ != null || this.maximumAllowedValue_ != null || this.minimumAllowedValue_ != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllowNegative(Boolean allowNegative) {
/* 154 */     this.allowNegative_ = allowNegative;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAllowNull(Boolean allowNull) {
/* 159 */     this.allowNull_ = allowNull;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxCharacters(Integer maxCharacters) {
/* 164 */     this.maxCharacters_ = maxCharacters;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaximumAllowedValue(BigDecimal newValue) {
/* 169 */     this.maximumAllowedValue_ = newValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaximumFractionalDigits(Integer maximumFractionalDigits) {
/* 174 */     this.maximumFractionalDigits_ = maximumFractionalDigits;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaximumIntegerDigits(Integer maximumIntegerDigits) {
/* 179 */     this.maximumIntegerDigits_ = maximumIntegerDigits;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMinimumAllowedValue(BigDecimal newValue) {
/* 184 */     this.minimumAllowedValue_ = newValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegexPolicy(String newValue) {
/* 189 */     this.regexPolicy_ = newValue;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\EditFormatterParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */