/*    */ package dtv.pos.chart.util;
/*    */ 
/*    */ import java.awt.Paint;
/*    */ import java.awt.Stroke;
/*    */ import org.jfree.chart.axis.Axis;
/*    */ import org.jfree.chart.plot.CategoryPlot;
/*    */ import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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
/*    */ public class DtvCategoryPlot
/*    */   implements IDtvChartPlotWrapper
/*    */ {
/*    */   private final CategoryPlot _plot;
/*    */   private DtvLineAndShapeRenderer _renderer;
/*    */   
/*    */   public DtvCategoryPlot(CategoryPlot argPlot) {
/* 27 */     this._plot = argPlot;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Axis getDomainAxis() {
/* 33 */     return (Axis)this._plot.getDomainAxis();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Axis getRangeAxis() {
/* 39 */     return (Axis)this._plot.getRangeAxis();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IDtvPlotRendererWrapper getRenderer() {
/* 45 */     if (this._renderer == null) {
/* 46 */       this._renderer = new DtvLineAndShapeRenderer((LineAndShapeRenderer)this._plot.getRenderer());
/*    */     }
/* 48 */     return this._renderer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDomainGridlinePaint(Paint argPaint) {
/* 54 */     this._plot.setDomainGridlinePaint(argPaint);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOutlineVisible(boolean argVisible) {
/* 60 */     this._plot.setOutlineVisible(argVisible);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRangeGridlinePaint(Paint argPaint) {
/* 66 */     this._plot.setRangeGridlinePaint(argPaint);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRangeGridlineStroke(Stroke argStroke) {
/* 72 */     this._plot.setRangeGridlineStroke(argStroke);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRangeGridlinesVisible(boolean argVisible) {
/* 78 */     this._plot.setRangeGridlinesVisible(argVisible);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\char\\util\DtvCategoryPlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */