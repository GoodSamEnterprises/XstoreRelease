/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IColorConfig;
/*     */ import dtv.util.config.PrimitiveConfig;
/*     */ import java.awt.Color;
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
/*     */ public class ColorRefConfig
/*     */   extends PrimitiveConfig
/*     */   implements IColorConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String key_;
/*     */   private Color color_;
/*     */   
/*     */   public ColorRefConfig() {}
/*     */   
/*     */   public ColorRefConfig(String key) {
/*  39 */     setValue(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  44 */     if (obj == this) {
/*  45 */       return true;
/*     */     }
/*  47 */     if (!(obj instanceof ColorRefConfig)) {
/*  48 */       return false;
/*     */     }
/*  50 */     return ObjectUtils.equivalent(this.key_, ((ColorRefConfig)obj).key_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/*  56 */     return this.color_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  62 */     return "ColorRef";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigValue() {
/*  68 */     return this.key_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<Color> getParamDataType() {
/*  74 */     return Color.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getParamValue() {
/*  80 */     return this.color_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  85 */     return this.key_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String argValue) {
/*  91 */     if (!ObjectUtils.equivalent(argValue, this.key_)) {
/*  92 */       this.key_ = argValue;
/*  93 */       this.color_ = UIResourceManager.getInstance().getRGBColor(argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     return this.key_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ColorRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */