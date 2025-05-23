/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*    */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*    */ import org.apache.commons.lang3.builder.ToStringStyle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubstituteComponentsConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 8736903517893117093L;
/* 31 */   private final Map<String, SubstituteComponentConfig> children_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 37 */     if ("SubstituteComponent".equals(argKey)) {
/* 38 */       SubstituteComponentConfig config = (SubstituteComponentConfig)argValue;
/* 39 */       this.children_.put(config.getName(), config);
/*    */     } else {
/*    */       
/* 42 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, SubstituteComponentConfig> getChildren() {
/* 52 */     return this.children_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SubstituteComponentConfig getChild(String argName) {
/* 62 */     return getChildren().get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/*    */     boolean result;
/* 69 */     if (this == argOther) {
/* 70 */       result = true;
/*    */     }
/* 72 */     else if (argOther == null || getClass() != argOther.getClass()) {
/* 73 */       result = false;
/*    */     } else {
/*    */       
/* 76 */       EqualsBuilder eq = new EqualsBuilder();
/* 77 */       eq.append(getChildren(), ((SubstituteComponentsConfig)argOther).getChildren());
/* 78 */       result = eq.isEquals();
/*    */     } 
/* 80 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 86 */     HashCodeBuilder hash = new HashCodeBuilder(443, 1877);
/* 87 */     hash.append(getChildren());
/* 88 */     return hash.toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 94 */     ToStringBuilder str = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/* 95 */     str.append("ChildNames", getChildren().keySet());
/* 96 */     return str.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SubstituteComponentsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */