/*     */ package dtv.pos.iframework.ui;
/*     */ 
/*     */ import dtv.util.ObjectUtils;
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
/*     */ public class RendererDef
/*     */ {
/*     */   private final IViewElementType type_;
/*     */   private final String ruleSet_;
/*     */   private final boolean simple_;
/*  22 */   private volatile int hashCode_ = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RendererDef() {
/*  28 */     this(false, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RendererDef(boolean argSimple) {
/*  39 */     this(argSimple, null, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RendererDef(boolean argSimple, String argRuleSet, IViewElementType argType) {
/*  55 */     this.simple_ = argSimple;
/*  56 */     this.ruleSet_ = argRuleSet;
/*  57 */     this.type_ = argType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RendererDef(IViewElementType argType) {
/*  67 */     this(false, null, argType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RendererDef(String argRuleSet) {
/*  77 */     this(false, argRuleSet, null);
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
/*     */   public RendererDef(String argRuleSet, IViewElementType argType) {
/*  89 */     this(false, argRuleSet, argType);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  94 */     if (argObj == this) {
/*  95 */       return true;
/*     */     }
/*  97 */     if (!(argObj instanceof RendererDef)) {
/*  98 */       return false;
/*     */     }
/* 100 */     RendererDef other = (RendererDef)argObj;
/*     */     
/* 102 */     return (this.simple_ == other.simple_ && ObjectUtils.equivalent(this.ruleSet_, other.ruleSet_) && 
/* 103 */       ObjectUtils.equivalent(this.type_, other.type_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRuleSet() {
/* 113 */     return this.ruleSet_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getType() {
/* 123 */     return this.type_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 128 */     if (this.hashCode_ == -1) {
/* 129 */       int result = 17;
/* 130 */       result = 37 * result + (this.simple_ ? 1 : 0);
/* 131 */       result = 37 * result + ObjectUtils.getHashCode(this.ruleSet_);
/* 132 */       result = 37 * result + ObjectUtils.getHashCode(this.type_);
/*     */       
/* 134 */       this.hashCode_ = result;
/*     */     } 
/* 136 */     return this.hashCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSimple() {
/* 147 */     return this.simple_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuffer sb = new StringBuffer();
/* 153 */     sb.append("[simple=");
/* 154 */     sb.append(this.simple_);
/* 155 */     sb.append(",ruleSet=");
/* 156 */     sb.append(this.ruleSet_);
/* 157 */     sb.append(",type=");
/* 158 */     sb.append(this.type_);
/* 159 */     sb.append("]");
/*     */     
/* 161 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\RendererDef.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */