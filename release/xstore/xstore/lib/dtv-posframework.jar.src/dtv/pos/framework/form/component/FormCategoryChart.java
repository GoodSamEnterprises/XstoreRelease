/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.geom.Ellipse2D;
/*     */ import javax.swing.BorderFactory;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.CategoryLabelPositions;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.renderer.category.LineAndShapeRenderer;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.chart.title.Title;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.ui.RectangleEdge;
/*     */ import org.jfree.ui.RectangleInsets;
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
/*     */ public class FormCategoryChart<T extends IFormModel>
/*     */   extends AbstractFormChart<T>
/*     */ {
/*     */   protected void setComponentValue(Object argValue) {
/*  38 */     if (!(argValue instanceof AbstractFormChart.IChartModel)) {
/*  39 */       throw new IllegalArgumentException("Component value should be implementing " + AbstractFormChart.IChartModel.class
/*  40 */           .getName());
/*     */     }
/*     */     
/*  43 */     AbstractFormChart.IChartModel model = (AbstractFormChart.IChartModel)argValue;
/*  44 */     if (!(model.getDataset() instanceof CategoryDataset)) {
/*  45 */       throw new IllegalArgumentException("Component value should be implementing " + CategoryDataset.class
/*  46 */           .getName());
/*     */     }
/*     */     
/*  49 */     if (this.dataSet_ == null || !this.dataSet_.equals(argValue)) {
/*  50 */       this.dataSet_ = model.getDataset();
/*  51 */       switch (this.chartType_) {
/*     */         case BAR:
/*  53 */           this
/*  54 */             .chart_ = ChartFactory.createBarChart(model.getTitle(), this.categoryAxisLabel_, this.valueAxisLabel_, (CategoryDataset)this.dataSet_, PlotOrientation.VERTICAL, this.useLegend_, true, false);
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/*  59 */           this
/*  60 */             .chart_ = ChartFactory.createLineChart(model.getTitle(), this.categoryAxisLabel_, this.valueAxisLabel_, (CategoryDataset)this.dataSet_, PlotOrientation.VERTICAL, this.useLegend_, true, false);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/*  65 */       this.chart_.getTitle().setFont(this.titleFont_);
/*     */       
/*  67 */       getChartContentPane().setChartPanel(new ChartPanel(this.chart_));
/*  68 */       getChartContentPane().getChartPanel().setBorder(BorderFactory.createLineBorder(Color.BLACK));
/*  69 */       getChartContentPane().getChartPanel().setPopupMenu(null);
/*  70 */       getChartContentPane().getChartPanel().setDomainZoomable(false);
/*  71 */       getChartContentPane().getChartPanel().setRangeZoomable(false);
/*     */       
/*  73 */       CategoryPlot plot = (CategoryPlot)this.chart_.getPlot();
/*     */       
/*  75 */       NumberAxis y = (NumberAxis)plot.getRangeAxis();
/*  76 */       y.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/*  77 */       y.setAutoRangeIncludesZero(true);
/*  78 */       y.setLabelFont(this.valueFont_);
/*     */       
/*  80 */       CategoryAxis x = plot.getDomainAxis();
/*  81 */       x.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(1.5707963267948966D));
/*  82 */       x.setLabelFont(this.categoryFont_);
/*     */       
/*  84 */       plot.setRangeGridlinesVisible(true);
/*  85 */       plot.setDomainGridlinePaint(Color.BLACK);
/*  86 */       plot.setRangeGridlinePaint(Color.BLACK);
/*  87 */       plot.setOutlineVisible(false);
/*     */       
/*  89 */       plot.setRangeGridlineStroke(new BasicStroke(1.0F));
/*     */       
/*  91 */       for (int i = 0; i < ((CategoryDataset)this.dataSet_).getRowCount(); i++) {
/*  92 */         if (this.showPoints_) {
/*  93 */           ((LineAndShapeRenderer)plot.getRenderer()).setSeriesShapesFilled(i, true);
/*  94 */           ((LineAndShapeRenderer)plot.getRenderer()).setSeriesShapesVisible(i, true);
/*  95 */           plot.getRenderer().setSeriesShape(i, new Ellipse2D.Double(-3.0D, -3.0D, 6.0D, 6.0D));
/*     */         } 
/*     */         
/*  98 */         plot.getRenderer().setSeriesStroke(i, new BasicStroke(this.seriesWidth_));
/*  99 */         if (this.serieColors_.get(Integer.valueOf(i)) != null) {
/* 100 */           plot.getRenderer().setSeriesPaint(i, this.serieColors_.get(Integer.valueOf(i)));
/*     */         } else {
/*     */           
/* 103 */           plot.getRenderer().setSeriesPaint(i, this.seriesColor_);
/*     */         } 
/*     */       } 
/*     */       
/* 107 */       for (String s : this.leftSubtitles_) {
/* 108 */         TextTitle legendText = new TextTitle(s);
/* 109 */         legendText.setPosition(RectangleEdge.LEFT);
/* 110 */         this.chart_.addSubtitle((Title)legendText);
/*     */       } 
/*     */       
/* 113 */       this.chart_.setBackgroundPaint(this.backgroundColor_);
/* 114 */       this.chart_.getPlot().setBackgroundPaint(this.backgroundColor_);
/*     */       
/* 116 */       if (this.chartPadding_ != null)
/* 117 */         this.chart_.setPadding(new RectangleInsets(this.chartPadding_.top, this.chartPadding_.left, this.chartPadding_.bottom, this.chartPadding_.right)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormCategoryChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */