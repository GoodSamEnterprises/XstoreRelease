/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IRendererConfig;
/*    */ import dtv.ui.IRenderer;
/*    */ import dtv.ui.renderer.PaintRenderer;
/*    */ import dtv.util.config.PrimitiveConfig;
/*    */ import java.awt.Color;
/*    */ import java.util.StringTokenizer;
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
/*    */ public final class PaintRendererConfig
/*    */   extends PrimitiveConfig
/*    */   implements IRendererConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String rendererColor_;
/*    */   
/*    */   public IRenderer getRenderer() {
/* 29 */     if (this.rendererColor_ != null && this.rendererColor_.indexOf(',') > -1) {
/* 30 */       this.rendererColor_.replace(" ", "");
/*    */       
/* 32 */       StringTokenizer st = new StringTokenizer(this.rendererColor_, ",");
/*    */       
/* 34 */       int r = Integer.valueOf(st.nextToken()).intValue();
/* 35 */       int g = Integer.valueOf(st.nextToken()).intValue();
/* 36 */       int b = Integer.valueOf(st.nextToken()).intValue();
/*    */       
/* 38 */       return (IRenderer)new PaintRenderer(new Color(r, g, b));
/*    */     } 
/* 40 */     return (IRenderer)new PaintRenderer(Color.decode(this.rendererColor_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String argValue) {
/* 45 */     this.rendererColor_ = argValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\PaintRendererConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */