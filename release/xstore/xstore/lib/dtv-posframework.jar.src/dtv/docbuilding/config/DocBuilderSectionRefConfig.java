/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocSectionMap;
/*     */ import dtv.docbuilding.DocSectionRef;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections.map.CaseInsensitiveMap;
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
/*     */ public class DocBuilderSectionRefConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISectionMemberConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private String sectionName_ = null;
/*  29 */   private Map<String, String> parameters_ = null;
/*  30 */   private String toString_ = null;
/*     */   
/*     */   public String getSectionName() {
/*  33 */     return this.sectionName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocSectionRef makeSectionRef(DocSectionMap argSectionMap) {
/*  43 */     DocSectionRef ref = new DocSectionRef(this.sectionName_, argSectionMap, this.parameters_);
/*  44 */     ref.setSourceDescription(getSourceDescription());
/*  45 */     return ref;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  51 */     if ("name".equalsIgnoreCase(argKey)) {
/*  52 */       this.sectionName_ = argValue.toString();
/*     */     }
/*  54 */     else if (argValue instanceof ParameterConfig) {
/*  55 */       ParameterConfig cfg = (ParameterConfig)argValue;
/*  56 */       setParameter(cfg.getName(), cfg.getValue().toString());
/*     */     }
/*  58 */     else if (argKey.startsWith("arg")) {
/*  59 */       setParameter(argKey, argValue.toString());
/*     */     } else {
/*     */       
/*  62 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/*  68 */     if (this.parameters_ == null) {
/*  69 */       this.parameters_ = (Map<String, String>)new CaseInsensitiveMap();
/*     */     }
/*  71 */     this.parameters_.put(argName, argValue);
/*     */   }
/*     */   
/*     */   public void setSectionName(String argName) {
/*  75 */     this.sectionName_ = argName;
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
/*     */   public void setValue(String argValue) {
/*  87 */     if (!StringUtils.isEmpty(argValue)) {
/*  88 */       this.sectionName_ = argValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  95 */     if (this.toString_ == null) {
/*  96 */       StringBuffer sb = new StringBuffer();
/*  97 */       sb.append(getClass().getName());
/*  98 */       sb.append("[");
/*  99 */       sb.append(this.sectionName_);
/* 100 */       sb.append("]");
/* 101 */       this.toString_ = sb.toString();
/*     */     } 
/* 103 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderSectionRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */