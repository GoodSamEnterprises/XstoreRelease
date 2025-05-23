/*    */ package dtv.pos.chart.util;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.Paint;
/*    */ import java.awt.Shape;
/*    */ import java.awt.Stroke;
/*    */ import org.jfree.chart.labels.StandardXYToolTipGenerator;
/*    */ import org.jfree.chart.labels.XYToolTipGenerator;
/*    */ import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DtvXYLineAndShapeRenderer
/*    */   implements IDtvPlotRendererWrapper
/*    */ {
/*    */   private final XYLineAndShapeRenderer _renderer;
/*    */   
/*    */   public DtvXYLineAndShapeRenderer(XYLineAndShapeRenderer argRenderer) {
/* 25 */     this._renderer = argRenderer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setBaseItemLabelFont(Font argFont) {
/* 31 */     this._renderer.setBaseItemLabelFont(argFont);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setBaseToolTipGenerator(StandardXYToolTipGenerator argGenerator) {
/* 37 */     this._renderer.setBaseToolTipGenerator((XYToolTipGenerator)argGenerator);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSeriesItemLabelFont(int argSeries, Font argFont) {
/* 43 */     this._renderer.setSeriesItemLabelFont(argSeries, argFont);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSeriesPaint(int argSeries, Paint argPaint) {
/* 49 */     this._renderer.setSeriesPaint(argSeries, argPaint);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSeriesShape(int argSeries, Shape argShape) {
/* 55 */     this._renderer.setSeriesShape(argSeries, argShape);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSeriesShapesFilled(int argSeries, boolean argFlag) {
/* 61 */     this._renderer.setSeriesShapesFilled(argSeries, argFlag);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSeriesShapesVisible(int argSeries, boolean argFlag) {
/* 67 */     this._renderer.setSeriesShapesVisible(argSeries, argFlag);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSeriesStroke(int argSeries, Stroke argStroke) {
/* 73 */     this._renderer.setSeriesStroke(argSeries, argStroke);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\char\\util\DtvXYLineAndShapeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */