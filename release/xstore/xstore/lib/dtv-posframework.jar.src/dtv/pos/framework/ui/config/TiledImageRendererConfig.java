/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IRendererConfig;
/*    */ import dtv.ui.IRenderer;
/*    */ import dtv.ui.renderer.TiledImageRenderer;
/*    */ import dtv.util.config.PrimitiveConfig;
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
/*    */ public final class TiledImageRendererConfig
/*    */   extends PrimitiveConfig
/*    */   implements IRendererConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String rendererFileName_;
/*    */   
/*    */   public IRenderer getRenderer() {
/* 26 */     return (IRenderer)new TiledImageRenderer(this.rendererFileName_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String argValue) {
/* 31 */     this.rendererFileName_ = "classpath:graphics/" + argValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\TiledImageRendererConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */