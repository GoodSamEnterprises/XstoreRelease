/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IDimensionConfig;
/*     */ import dtv.util.config.PrimitiveConfig;
/*     */ import java.awt.Dimension;
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
/*     */ public class DimensionRefConfig
/*     */   extends PrimitiveConfig
/*     */   implements IDimensionConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String key_;
/*     */   private Dimension dimension_;
/*     */   
/*     */   public DimensionRefConfig() {}
/*     */   
/*     */   public DimensionRefConfig(String key) {
/*  41 */     setValue(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  46 */     if (obj == this) {
/*  47 */       return true;
/*     */     }
/*  49 */     if (!(obj instanceof DimensionRefConfig)) {
/*  50 */       return false;
/*     */     }
/*  52 */     return ObjectUtils.equivalent(this.key_, ((DimensionRefConfig)obj).key_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  62 */     return "DimensionRef";
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
/*     */   public Dimension getDimension() {
/*  81 */     return this.dimension_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<Dimension> getParamDataType() {
/*  92 */     return Dimension.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getParamValue() {
/* 103 */     return this.dimension_;
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
/* 121 */       this.dimension_ = UIResourceManager.getInstance().getDimension(newKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 127 */     return this.key_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\DimensionRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */