/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import java.awt.Color;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.plot.PieLabelLinkStyle;
/*     */ import org.jfree.chart.plot.PiePlot;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.chart.title.Title;
/*     */ import org.jfree.data.general.PieDataset;
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
/*     */ 
/*     */ 
/*     */ public class FormPieChart<T extends IFormModel>
/*     */   extends AbstractFormChart<T>
/*     */ {
/*  33 */   public static final Color[] COLORS = new Color[] { new Color(147, 58, 58), new Color(28, 117, 120), new Color(231, 187, 58), new Color(143, 162, 148), new Color(163, 146, 173), new Color(22, 89, 158), new Color(163, 111, 88), new Color(118, 164, 185), new Color(122, 122, 61), new Color(160, 30, 9), new Color(177, 176, 172), new Color(228, 159, 1), new Color(126, 41, 122), new Color(89, 48, 13), new Color(55, 52, 42) };
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
/*     */   protected void setComponentValue(Object argValue) {
/*  54 */     if (!(argValue instanceof AbstractFormChart.IChartModel)) {
/*  55 */       throw new IllegalArgumentException("Component value should be implementing " + AbstractFormChart.IChartModel.class
/*  56 */           .getName());
/*     */     }
/*     */     
/*  59 */     AbstractFormChart.IChartModel model = (AbstractFormChart.IChartModel)argValue;
/*  60 */     if (!(model.getDataset() instanceof PieDataset)) {
/*  61 */       throw new IllegalArgumentException("Component value should be implementing " + PieDataset.class
/*  62 */           .getName());
/*     */     }
/*     */     
/*  65 */     if (this.dataSet_ == null || !this.dataSet_.equals(argValue)) {
/*  66 */       this.dataSet_ = model.getDataset();
/*  67 */       this.chart_ = ChartFactory.createPieChart(model.getTitle(), (PieDataset)this.dataSet_, this.useLegend_, false, false);
/*     */     } 
/*     */     
/*  70 */     if (this.chart_.getTitle() != null) {
/*  71 */       this.chart_.getTitle().setFont(this.titleFont_);
/*     */     }
/*     */     
/*  74 */     getChartContentPane().setChartPanel(new ChartPanel(this.chart_));
/*  75 */     getChartContentPane().getChartPanel().setPopupMenu(null);
/*  76 */     getChartContentPane().getChartPanel().setDomainZoomable(false);
/*  77 */     getChartContentPane().getChartPanel().setRangeZoomable(false);
/*     */     
/*  79 */     PiePlot plot = (PiePlot)this.chart_.getPlot();
/*  80 */     plot.setOutlineVisible(false);
/*  81 */     plot.setLabelBackgroundPaint(Color.WHITE);
/*     */     
/*  83 */     List<Comparable> keys = ((PieDataset)this.dataSet_).getKeys();
/*     */ 
/*     */     
/*  86 */     for (int i = 0; i < keys.size(); i++) {
/*  87 */       int aInt = i % COLORS.length;
/*  88 */       plot.setSectionPaint(keys.get(i), COLORS[aInt]);
/*     */     } 
/*     */     
/*  91 */     for (String s : this.leftSubtitles_) {
/*  92 */       TextTitle legendText = new TextTitle(s);
/*  93 */       legendText.setPosition(RectangleEdge.LEFT);
/*  94 */       this.chart_.addSubtitle((Title)legendText);
/*     */     } 
/*     */     
/*  97 */     plot.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
/*     */     
/*  99 */     getChartContentPane().setBackground(this.backgroundColor_);
/* 100 */     getChartContentPane().getChartPanel().setBackground(this.backgroundColor_);
/* 101 */     this.chart_.setBackgroundPaint(this.backgroundColor_);
/* 102 */     this.chart_.getPlot().setBackgroundPaint(this.backgroundColor_);
/*     */     
/* 104 */     if (this.chartPadding_ != null)
/* 105 */       this.chart_.setPadding(new RectangleInsets(this.chartPadding_.top, this.chartPadding_.left, this.chartPadding_.bottom, this.chartPadding_.right)); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormPieChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */