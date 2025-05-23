/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class SecondaryPromptConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = -7028541836423155505L;
/*    */   private String name_;
/*    */   private String location_;
/*    */   private boolean enabled_ = false;
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 32 */     if ("name".equalsIgnoreCase(argKey)) {
/* 33 */       this.name_ = argKey.toString();
/*    */     }
/* 35 */     else if ("location".equalsIgnoreCase(argKey)) {
/* 36 */       this.location_ = argKey.toString();
/*    */     }
/* 38 */     else if ("enabled".equalsIgnoreCase(argKey)) {
/* 39 */       this.enabled_ = ConfigUtils.toBoolean(argValue);
/*    */     } else {
/*    */       
/* 42 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 48 */     return this.name_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getLocation() {
/* 53 */     return this.location_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 58 */     return this.enabled_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argOther) {
/*    */     boolean result;
/* 65 */     if (this == argOther) {
/* 66 */       result = true;
/*    */     }
/* 68 */     else if (argOther == null || getClass() != argOther.getClass()) {
/* 69 */       result = false;
/*    */     } else {
/*    */       
/* 72 */       SecondaryPromptConfig other = (SecondaryPromptConfig)argOther;
/* 73 */       EqualsBuilder eq = new EqualsBuilder();
/* 74 */       eq.append(isEnabled(), other.isEnabled());
/* 75 */       eq.append(getName(), other.getName());
/* 76 */       eq.append(getLocation(), other.getLocation());
/* 77 */       result = eq.isEquals();
/*    */     } 
/* 79 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 85 */     HashCodeBuilder hash = new HashCodeBuilder(229, 3301);
/* 86 */     hash.append(getName());
/* 87 */     hash.append(getLocation());
/* 88 */     hash.append(isEnabled());
/* 89 */     return hash.toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 95 */     ToStringBuilder str = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/* 96 */     str.append("name", getName());
/* 97 */     str.append("location", getLocation());
/* 98 */     str.append("enabled", isEnabled());
/* 99 */     return str.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SecondaryPromptConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */