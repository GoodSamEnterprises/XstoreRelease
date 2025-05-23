/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringStyle;
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
/*     */ public class SecondaryPromptSetConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = -7986536679187573116L;
/*  30 */   private final Map<CompositeObject.TwoPiece<String, String>, SecondaryPromptConfig> children_ = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<CompositeObject.TwoPiece<String, String>, SecondaryPromptConfig> getChildren() {
/*  35 */     return Collections.unmodifiableMap(this.children_);
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
/*     */   public SecondaryPromptConfig getChild(String argName, String argLocation) {
/*  47 */     CompositeObject.TwoPiece<String, String> key = makeKey(argName, argLocation);
/*  48 */     return getChildren().get(key);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  54 */     if ("SecondaryPrompt".equals(argKey)) {
/*  55 */       SecondaryPromptConfig config = (SecondaryPromptConfig)argValue;
/*  56 */       CompositeObject.TwoPiece<String, String> key = makeKey(config);
/*  57 */       this.children_.put(key, config);
/*     */     } else {
/*     */       
/*  60 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected CompositeObject.TwoPiece<String, String> makeKey(SecondaryPromptConfig argConfig) {
/*  66 */     return makeKey(argConfig.getName(), argConfig.getLocation());
/*     */   }
/*     */ 
/*     */   
/*     */   protected CompositeObject.TwoPiece<String, String> makeKey(String argName, String argLocation) {
/*  71 */     return CompositeObject.make(argName, argLocation);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*     */     boolean result;
/*  78 */     if (this == argOther) {
/*  79 */       result = true;
/*     */     }
/*  81 */     else if (argOther == null || getClass() != argOther.getClass()) {
/*  82 */       result = false;
/*     */     } else {
/*     */       
/*  85 */       EqualsBuilder eq = new EqualsBuilder();
/*  86 */       eq.append(getChildren(), ((SecondaryPromptSetConfig)argOther).getChildren());
/*  87 */       result = eq.isEquals();
/*     */     } 
/*  89 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  95 */     HashCodeBuilder hash = new HashCodeBuilder(1663, 2837);
/*  96 */     hash.append(getChildren());
/*  97 */     return hash.toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     ToStringBuilder str = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/* 104 */     str.append("Children", getChildren());
/* 105 */     return str.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SecondaryPromptSetConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */