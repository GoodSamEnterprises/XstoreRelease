/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubstituteComponentConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 9005477083973077114L;
/*    */   private String name_;
/*    */   private ViewComponentConfig componentConfig_;
/*    */   
/*    */   public boolean equals(Object argOther) {
/*    */     boolean result;
/* 34 */     if (this == argOther) {
/* 35 */       result = true;
/*    */     }
/* 37 */     else if (argOther == null || getClass() != argOther.getClass()) {
/* 38 */       result = false;
/*    */     } else {
/*    */       
/* 41 */       EqualsBuilder eq = new EqualsBuilder();
/* 42 */       eq.append(getName(), ((SubstituteComponentConfig)argOther).getName());
/* 43 */       result = eq.isEquals();
/*    */     } 
/* 45 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ViewComponentConfig getComponentConfig() {
/* 52 */     return this.componentConfig_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 59 */     return this.name_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     HashCodeBuilder hash = new HashCodeBuilder(733, 1453);
/* 66 */     hash.append(getName());
/* 67 */     return hash.toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 73 */     if ("name".equals(argKey)) {
/* 74 */       this.name_ = argValue.toString();
/*    */     }
/* 76 */     else if ("Component".equals(argKey)) {
/* 77 */       this.componentConfig_ = (ViewComponentConfig)argValue;
/*    */     } else {
/*    */       
/* 80 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 87 */     ToStringBuilder str = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
/* 88 */     str.append("Name", getName());
/* 89 */     return str.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\SubstituteComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */