/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IInsetsConfig;
/*     */ import dtv.util.config.PrimitiveConfig;
/*     */ import java.awt.Insets;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InsetsRefConfig
/*     */   extends PrimitiveConfig
/*     */   implements IInsetsConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String key_;
/*     */   private Insets insets_;
/*     */   
/*     */   public InsetsRefConfig() {}
/*     */   
/*     */   public InsetsRefConfig(String key) {
/*  41 */     setValue(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  46 */     if (obj == this) {
/*  47 */       return true;
/*     */     }
/*  49 */     if (!(obj instanceof InsetsRefConfig)) {
/*  50 */       return false;
/*     */     }
/*  52 */     return ObjectUtils.equivalent(this.key_, ((InsetsRefConfig)obj).key_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  62 */     return "InsetsRef";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/*  72 */     return this.key_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Insets getInsets() {
/*  81 */     return this.insets_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<Insets> getParamDataType() {
/*  92 */     return Insets.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Insets getParamValue() {
/* 103 */     return this.insets_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 108 */     return this.key_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String newKey) {
/* 119 */     if (!ObjectUtils.equivalent(newKey, this.key_)) {
/* 120 */       this.key_ = newKey;
/* 121 */       this.insets_ = UIResourceManager.getInstance().getInsets(newKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 127 */     return this.key_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\InsetsRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */