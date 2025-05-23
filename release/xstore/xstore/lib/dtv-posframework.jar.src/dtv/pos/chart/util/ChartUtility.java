/*     */ package dtv.pos.chart.util;
/*     */ 
/*     */ import dtv.i18n.FormatPatternFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.LocaleManager;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.form.component.AbstractFormChart;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.MutableString;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.geom.Ellipse2D;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.CategoryLabelPositions;
/*     */ import org.jfree.chart.axis.DateAxis;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.labels.StandardXYToolTipGenerator;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.title.LegendTitle;
/*     */ import org.jfree.chart.title.TextTitle;
/*     */ import org.jfree.chart.title.Title;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.general.Dataset;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.ui.RectangleEdge;
/*     */ 
/*     */ 
/*     */ public class ChartUtility
/*     */ {
/*     */   public static final String RANGE_START_DATE_PROPERTY = "RANGE_START_DATE_PROPERTY";
/*     */   public static final String RANGE_END_DATE_PROPERTY = "RANGE_START_END_PROPERTY";
/*  43 */   private Font titleFont_ = UIResourceManager.getInstance().getFont("_fontLabelLarge");
/*  44 */   private Font categoryFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*  45 */   private Font valueFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*  46 */   private Font seriesFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*  47 */   private Font legendFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*     */   
/*  49 */   private Map<Integer, Color> serieColors_ = new HashMap<>();
/*  50 */   private List<String> leftSubtitles_ = new ArrayList<>();
/*  51 */   private Color backgroundColor_ = Color.WHITE;
/*  52 */   private Color seriesColor_ = Color.BLUE;
/*  53 */   private int seriesWidth_ = 2;
/*     */   
/*     */   public JFreeChart createJFreeChart(Object argValue, String argDateFormatPattern) {
/*  56 */     if (!(argValue instanceof AbstractFormChart.IChartModel)) {
/*  57 */       throw new IllegalArgumentException("Component value should be implementing " + AbstractFormChart.IChartModel.class
/*  58 */           .getName());
/*     */     }
/*     */     
/*  61 */     AbstractFormChart.IChartModel model = (AbstractFormChart.IChartModel)argValue;
/*  62 */     boolean timeSeriesChart = model.getDataset() instanceof XYDataset;
/*  63 */     boolean categoryChart = model.getDataset() instanceof CategoryDataset;
/*  64 */     IDtvChartPlotWrapper plot = null;
/*  65 */     IDtvPlotRendererWrapper renderer = null;
/*  66 */     int seriesCount = 0;
/*  67 */     Dataset dataSet = null;
/*  68 */     JFreeChart chart = null;
/*     */     
/*  70 */     if (!timeSeriesChart && !categoryChart) {
/*  71 */       throw new IllegalArgumentException("Unsupported data set of type " + model
/*  72 */           .getDataset().getClass().getName());
/*     */     }
/*  74 */     dataSet = model.getDataset();
/*  75 */     if (timeSeriesChart) {
/*  76 */       chart = ChartFactory.createTimeSeriesChart(model.getTitle(), null, null, (XYDataset)dataSet, true, true, false);
/*     */       
/*  78 */       plot = new DtvXYPlot(chart.getXYPlot());
/*  79 */       renderer = plot.getRenderer();
/*  80 */       seriesCount = ((XYDataset)dataSet).getSeriesCount();
/*     */     }
/*  82 */     else if (categoryChart) {
/*  83 */       chart = ChartFactory.createLineChart(model.getTitle(), null, null, (CategoryDataset)dataSet, PlotOrientation.VERTICAL, true, true, false);
/*     */       
/*  85 */       plot = new DtvCategoryPlot(chart.getCategoryPlot());
/*  86 */       renderer = plot.getRenderer();
/*  87 */       seriesCount = ((CategoryDataset)dataSet).getRowCount();
/*     */     } 
/*     */     
/*  90 */     chart.getTitle().setFont(this.titleFont_);
/*     */     
/*  92 */     plot.setRangeGridlinesVisible(true);
/*  93 */     plot.setDomainGridlinePaint(Color.BLACK);
/*  94 */     plot.setRangeGridlinePaint(Color.BLACK);
/*  95 */     plot.setOutlineVisible(false);
/*  96 */     plot.getRenderer().setBaseItemLabelFont(this.valueFont_);
/*  97 */     plot.setRangeGridlineStroke(new BasicStroke(1.0F));
/*     */     
/*  99 */     NumberAxis y = (NumberAxis)plot.getRangeAxis();
/* 100 */     y.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/* 101 */     y.setAutoRangeIncludesZero(true);
/* 102 */     y.setLabelFont(this.valueFont_);
/*     */     
/* 104 */     if (timeSeriesChart) {
/* 105 */       Locale locView = LocaleManager.getInstance().getLocale(OutputContextType.VIEW);
/* 106 */       MutableString format = FormatPatternFactory.getInstance().getFormatPattern(FormatterType.DATE_LONG, OutputContextType.VIEW, locView);
/*     */       
/* 108 */       renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat(format
/*     */               
/* 110 */               .toString(), locView), new DecimalFormat()));
/*     */       
/* 112 */       DateAxis x = (DateAxis)plot.getDomainAxis();
/* 113 */       x.setLabelFont(this.categoryFont_);
/* 114 */       x.setVerticalTickLabels(false);
/*     */       
/* 116 */       if (argDateFormatPattern != null) {
/* 117 */         x.setDateFormatOverride(new SimpleDateFormat(argDateFormatPattern, locView));
/*     */       }
/*     */       
/* 120 */       if (model.getProperties() != null && model.getProperties().get("RANGE_START_DATE_PROPERTY") != null && model
/* 121 */         .getProperties().get("RANGE_START_END_PROPERTY") != null) {
/* 122 */         x.setRange((Date)model.getProperties().get("RANGE_START_DATE_PROPERTY"), (Date)model
/* 123 */             .getProperties().get("RANGE_START_END_PROPERTY"));
/*     */       }
/*     */     }
/* 126 */     else if (categoryChart) {
/* 127 */       CategoryAxis x = (CategoryAxis)plot.getDomainAxis();
/* 128 */       x.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(1.5707963267948966D));
/* 129 */       x.setLabelFont(this.categoryFont_);
/*     */     } 
/*     */     
/* 132 */     this.serieColors_.put(Integer.valueOf(0), UIResourceManager.getInstance().getRGBColor("_blue"));
/* 133 */     this.serieColors_.put(Integer.valueOf(1), UIResourceManager.getInstance().getRGBColor("_red"));
/*     */     
/* 135 */     for (int i = 0; i < seriesCount; i++) {
/* 136 */       plot.getRenderer().setSeriesShapesFilled(i, true);
/* 137 */       plot.getRenderer().setSeriesShapesVisible(i, true);
/* 138 */       plot.getRenderer().setSeriesItemLabelFont(i, this.seriesFont_);
/* 139 */       plot.getRenderer().setSeriesShape(i, new Ellipse2D.Double(-3.0D, -3.0D, 6.0D, 6.0D));
/*     */       
/* 141 */       plot.getRenderer().setSeriesStroke(i, new BasicStroke(this.seriesWidth_));
/* 142 */       if (this.serieColors_.get(Integer.valueOf(i)) != null) {
/* 143 */         plot.getRenderer().setSeriesPaint(i, this.serieColors_.get(Integer.valueOf(i)));
/*     */       } else {
/*     */         
/* 146 */         plot.getRenderer().setSeriesPaint(i, this.seriesColor_);
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     for (String s : this.leftSubtitles_) {
/* 151 */       TextTitle legendText = new TextTitle(s);
/* 152 */       legendText.setPosition(RectangleEdge.LEFT);
/* 153 */       legendText.setFont(this.legendFont_);
/* 154 */       chart.addSubtitle((Title)legendText);
/*     */     } 
/*     */     
/* 157 */     for (Object title : chart.getSubtitles()) {
/* 158 */       if (title instanceof LegendTitle) {
/* 159 */         ((LegendTitle)title).setItemFont(this.legendFont_); continue;
/*     */       } 
/* 161 */       if (title instanceof TextTitle) {
/* 162 */         ((TextTitle)title).setFont(this.legendFont_);
/*     */       }
/*     */     } 
/*     */     
/* 166 */     chart.setBackgroundPaint(this.backgroundColor_);
/* 167 */     chart.getPlot().setBackgroundPaint(this.backgroundColor_);
/* 168 */     return chart;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\char\\util\ChartUtility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */