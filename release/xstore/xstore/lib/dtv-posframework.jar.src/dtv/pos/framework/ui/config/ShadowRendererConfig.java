/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IRendererConfig;
/*    */ import dtv.ui.IRenderer;
/*    */ import dtv.ui.renderer.ShadowRenderer;
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
/*    */ public final class ShadowRendererConfig
/*    */   extends PrimitiveConfig
/*    */   implements IRendererConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String rendererColor_;
/*    */   
/*    */   public IRenderer getRenderer() {
/* 26 */     return (IRenderer)new ShadowRenderer(this.rendererColor_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String argValue) {
/* 31 */     this.rendererColor_ = argValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\ShadowRendererConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */