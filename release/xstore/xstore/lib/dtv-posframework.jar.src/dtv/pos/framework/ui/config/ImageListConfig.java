/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import java.awt.Image;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class ImageListConfig
/*    */   extends AbstractParentConfig
/*    */ {
/* 22 */   private List<Image> images_ = new ArrayList<>();
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void addImage(Image img) {
/* 27 */     if (img != null) {
/* 28 */       this.images_.add(img);
/*    */     }
/*    */   }
/*    */   
/*    */   public List<Image> getImages() {
/* 33 */     return this.images_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 40 */     if (argValue instanceof IReflectionParameterCapable) {
/* 41 */       addImage(((IReflectionParameterCapable)argValue).getParamValue());
/*    */     }
/*    */   }
/*    */   
/*    */   private void addImage(Object obj) {
/* 46 */     if (obj instanceof Image) {
/* 47 */       addImage((Image)obj);
/*    */     } else {
/*    */       
/* 50 */       throw new IllegalArgumentException("Argument should be instance of Image");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ImageListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */