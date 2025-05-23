/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
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
/*     */ public class RendererDefConfig
/*     */   extends AbstractParentConfig
/*     */   implements IRendererDefConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String MAIN_TAG = "Renderer";
/*     */   private static final String DEFAULT_ROLE = "Cell";
/*     */   private static final String ROLE_TAG = "Role";
/*     */   private static final String IS_SIMPLE_TAG = "Simple";
/*     */   private static final String RULE_SET_TAG = "RuleSet";
/*     */   private static final String TYPE_TAG = "Type";
/*     */   private IViewElementType type_;
/*     */   private String ruleSet_;
/*     */   private Boolean simple_;
/*     */   private String role_;
/*     */   
/*     */   public RendererDefConfig() {
/*  45 */     this("Cell");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RendererDefConfig(String argRole) {
/*  56 */     this.type_ = null;
/*  57 */     this.ruleSet_ = null;
/*  58 */     this.simple_ = null;
/*  59 */     this.role_ = (argRole != null) ? argRole : "Cell";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRole() {
/*  64 */     return this.role_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRuleSet() {
/*  69 */     return this.ruleSet_;
/*     */   }
/*     */ 
/*     */   
/*     */   public IViewElementType getType() {
/*  74 */     return this.type_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSimple() {
/*  79 */     return (this.simple_ == null) ? false : this.simple_.booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  84 */     String value = argValue.toString();
/*     */     
/*  86 */     if ("Role".equalsIgnoreCase(argKey)) {
/*  87 */       setRole(value);
/*     */     }
/*  89 */     else if ("Simple".equalsIgnoreCase(argKey) && argValue instanceof BooleanConfig) {
/*  90 */       setSimple(((BooleanConfig)argValue).getBoolean());
/*     */     }
/*  92 */     else if ("RuleSet".equalsIgnoreCase(argKey)) {
/*  93 */       setRuleSet(value);
/*     */     }
/*  95 */     else if ("Type".equalsIgnoreCase(argKey)) {
/*  96 */       setType(ViewElementType.valueOf(value));
/*     */     } else {
/*     */       
/*  99 */       warnUnsupported(argKey, argValue);
/*     */     } 
/* 101 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRole(String argRole) {
/* 106 */     this.role_ = (argRole != null) ? argRole : "Cell";
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRuleSet(String argRuleSet) {
/* 111 */     this.ruleSet_ = argRuleSet;
/* 112 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSimple(boolean argIsSimple) {
/* 117 */     setSimple(Boolean.valueOf(argIsSimple));
/* 118 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setType(IViewElementType argType) {
/* 123 */     this.type_ = argType;
/* 124 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public RendererDef toRendererDef() {
/* 129 */     return new RendererDef(isSimple(), getRuleSet(), getType());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuffer sb = new StringBuffer();
/* 135 */     sb.append("[role=");
/* 136 */     sb.append(this.role_);
/* 137 */     sb.append(",simple=");
/* 138 */     sb.append(this.simple_);
/* 139 */     sb.append(",ruleSet=");
/* 140 */     sb.append(this.ruleSet_);
/* 141 */     sb.append(",type=");
/* 142 */     sb.append(this.type_);
/* 143 */     sb.append("]");
/*     */     
/* 145 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 152 */     argWriter.writeHeader("Renderer", "Renderer");
/* 153 */     argWriter.writeValue("Role", "String", getRole());
/* 154 */     if (isSimpleInternal() != null) {
/* 155 */       argWriter.writeValue("Simple", "Boolean", isSimpleInternal());
/*     */     }
/* 157 */     if (getRuleSet() != null) {
/* 158 */       argWriter.writeValue("RuleSet", "String", getRuleSet());
/*     */     }
/* 160 */     if (getType() != null) {
/* 161 */       argWriter.writeValue("Type", "String", getType());
/*     */     }
/* 163 */     argWriter.writeFooter("Renderer");
/* 164 */     setClean();
/*     */   }
/*     */ 
/*     */   
/*     */   private Boolean isSimpleInternal() {
/* 169 */     return this.simple_;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setSimple(Boolean argSimple) {
/* 174 */     this.simple_ = argSimple;
/* 175 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\RendererDefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */