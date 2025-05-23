/*     */ package dtv.pos.framework.ui.config;
/*     */ 
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.PrimitiveConfig;
/*     */ import java.awt.Image;
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
/*     */ public class ImageRefConfig
/*     */   extends PrimitiveConfig
/*     */   implements IReflectionParameterCapable<Image>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String key_;
/*     */   private Image image_;
/*     */   
/*     */   public ImageRefConfig() {}
/*     */   
/*     */   public ImageRefConfig(String key) {
/*  41 */     super(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  46 */     if (obj == this) {
/*  47 */       return true;
/*     */     }
/*  49 */     if (!(obj instanceof ImageRefConfig)) {
/*  50 */       return false;
/*     */     }
/*  52 */     return ObjectUtils.equivalent(this.key_, ((ImageRefConfig)obj).key_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigDataType() {
/*  62 */     return "ImageRef";
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
/*     */   public Class<Image> getParamDataType() {
/*  78 */     return Image.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Image getParamValue() {
/*  88 */     return this.image_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  93 */     return this.key_.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String newKey) {
/* 103 */     if (!ObjectUtils.equivalent(newKey, this.key_)) {
/* 104 */       this.key_ = newKey;
/* 105 */       this.image_ = UIResourceManager.getInstance().getImage(newKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     return this.key_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ImageRefConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */