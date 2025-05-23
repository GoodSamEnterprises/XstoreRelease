/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.ui.component.IEvaluable;
/*     */ import dtv.pos.framework.ui.config.ColorRefConfig;
/*     */ import dtv.pos.framework.ui.config.FontRefConfig;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.config.BooleanConfig;
/*     */ import dtv.util.config.ColorConfig;
/*     */ import dtv.util.config.IntegerConfig;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Insets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.data.general.Dataset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractFormChart<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*     */   private final ChartContentPane container_;
/*     */   protected JFreeChart chart_;
/*     */   protected Dataset dataSet_;
/*     */   protected String categoryAxisLabel_;
/*     */   protected String valueAxisLabel_;
/*  46 */   protected Color backgroundColor_ = Color.WHITE;
/*  47 */   protected Color seriesColor_ = Color.BLUE;
/*  48 */   protected int seriesWidth_ = 2;
/*  49 */   protected Font titleFont_ = UIResourceManager.getInstance().getFont("_fontLabelLarge");
/*  50 */   protected Font categoryFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*  51 */   protected Font valueFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*  52 */   protected Font seriesFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*  53 */   protected Font legendFont_ = UIResourceManager.getInstance().getFont("_fontLabelSmall");
/*     */   protected boolean useLegend_;
/*     */   protected boolean showPoints_;
/*     */   protected boolean verticalTickLabels_;
/*  57 */   protected Map<Integer, Color> serieColors_ = new HashMap<>();
/*  58 */   protected List<String> leftSubtitles_ = new ArrayList<>();
/*     */   protected Insets chartPadding_;
/*  60 */   protected Type chartType_ = Type.LINE;
/*     */ 
/*     */   
/*     */   protected FormatterType _formatter;
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractFormChart() {
/*  68 */     this.container_ = new ChartContentPane();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  74 */     return this.container_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  80 */     return this.container_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  87 */     for (ParameterConfig config : argCfg.getParameters()) {
/*  88 */       String name = config.getName().toLowerCase();
/*     */       
/*  90 */       switch (name) {
/*     */         case "categoryaxislabel":
/*     */         case "category":
/*     */         case "categorylabel":
/*  94 */           this
/*  95 */             .categoryAxisLabel_ = ((IFormattableConfig)config.getValue()).getFormattable().toString(OutputContextType.VIEW);
/*     */           break;
/*     */ 
/*     */         
/*     */         case "valueaxislabel":
/*     */         case "value":
/*     */         case "valuelabel":
/* 102 */           this
/* 103 */             .valueAxisLabel_ = ((IFormattableConfig)config.getValue()).getFormattable().toString(OutputContextType.VIEW);
/*     */           break;
/*     */ 
/*     */         
/*     */         case "background":
/*     */         case "bgcolor":
/*     */         case "backgroundcolor":
/* 110 */           if (config.getValue() instanceof ColorConfig) {
/* 111 */             this.backgroundColor_ = ((ColorConfig)config.getValue()).getColor(); break;
/*     */           } 
/* 113 */           if (config.getValue() instanceof ColorRefConfig) {
/* 114 */             this.backgroundColor_ = ((ColorRefConfig)config.getValue()).getColor();
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case "linecolor":
/*     */         case "seriescolor":
/* 121 */           if (config.getValue() instanceof ColorConfig) {
/* 122 */             this.seriesColor_ = ((ColorConfig)config.getValue()).getColor();
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case "linewidth":
/*     */         case "serieswidth":
/* 129 */           if (config.getValue() instanceof IntegerConfig) {
/* 130 */             this.seriesWidth_ = ((IntegerConfig)config.getValue()).getInteger().intValue();
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case "titlefont":
/* 136 */           if (config.getValue() instanceof FontRefConfig || config.getValue() instanceof dtv.pos.framework.ui.config.FontConfig) {
/* 137 */             this.titleFont_ = ((FontRefConfig)config.getValue()).getFont();
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case "categoryfont":
/* 143 */           if (config.getValue() instanceof FontRefConfig || config.getValue() instanceof dtv.pos.framework.ui.config.FontConfig) {
/* 144 */             this.categoryFont_ = ((FontRefConfig)config.getValue()).getFont();
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         case "valuefont":
/* 150 */           if (config.getValue() instanceof FontRefConfig || config.getValue() instanceof dtv.pos.framework.ui.config.FontConfig) {
/* 151 */             this.valueFont_ = ((FontRefConfig)config.getValue()).getFont();
/*     */           }
/*     */           break;
/*     */         
/*     */         case "seriesFont":
/* 156 */           if (config.getValue() instanceof FontRefConfig || config.getValue() instanceof dtv.pos.framework.ui.config.FontConfig) {
/* 157 */             this.seriesFont_ = ((FontRefConfig)config.getValue()).getFont();
/*     */           }
/*     */           break;
/*     */         
/*     */         case "legendFont":
/* 162 */           if (config.getValue() instanceof FontRefConfig || config.getValue() instanceof dtv.pos.framework.ui.config.FontConfig) {
/* 163 */             this.legendFont_ = ((FontRefConfig)config.getValue()).getFont();
/*     */           }
/*     */           break;
/*     */         
/*     */         case "uselegend":
/* 168 */           if (config.getValue() instanceof BooleanConfig) {
/* 169 */             this.useLegend_ = ((BooleanConfig)config.getValue()).getBoolean().booleanValue();
/*     */           }
/*     */           break;
/*     */         
/*     */         case "showpoints":
/* 174 */           if (config.getValue() instanceof BooleanConfig) {
/* 175 */             this.showPoints_ = ((BooleanConfig)config.getValue()).getBoolean().booleanValue();
/*     */           }
/*     */           break;
/*     */         
/*     */         case "verticalticklabels":
/* 180 */           if (config.getValue() instanceof BooleanConfig) {
/* 181 */             this.verticalTickLabels_ = ((BooleanConfig)config.getValue()).getBoolean().booleanValue();
/*     */           }
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 189 */     super.init(argCfg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/* 195 */     super.init(argFieldDef);
/*     */     
/* 197 */     this._formatter = argFieldDef.getFormatter();
/*     */   }
/*     */   
/*     */   protected ChartContentPane getChartContentPane() {
/* 201 */     return this.container_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 207 */     return this.dataSet_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setComponentValue(Object paramObject);
/*     */ 
/*     */ 
/*     */   
/*     */   public class ChartContentPane
/*     */     extends JPanel
/*     */     implements IEvaluable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private ChartPanel chartPanel_;
/*     */     
/*     */     private String method_;
/*     */ 
/*     */     
/*     */     public ChartContentPane() {
/* 228 */       super(new BorderLayout());
/*     */     }
/*     */     
/*     */     public void addLeftSubtitle(IFormattable subtitle) {
/* 232 */       AbstractFormChart.this.leftSubtitles_.add(subtitle.toString(OutputContextType.VIEW));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void evaluate(Object source) {
/*     */       try {
/* 239 */         if (this.method_ != null) {
/* 240 */           Object obj = source.getClass().getMethod(this.method_, new Class[0]).invoke(source, new Object[0]);
/* 241 */           if (obj != null) {
/* 242 */             AbstractFormChart.this.setComponentValue(obj);
/*     */           }
/*     */         }
/*     */       
/* 246 */       } catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException illegalAccessException) {}
/*     */     }
/*     */ 
/*     */     
/*     */     public ChartPanel getChartPanel() {
/* 251 */       return this.chartPanel_;
/*     */     }
/*     */     
/*     */     public void setChartPadding(Insets insets) {
/* 255 */       AbstractFormChart.this.chartPadding_ = insets;
/*     */     }
/*     */     
/*     */     public void setChartPanel(ChartPanel chartPanel) {
/* 259 */       this.chartPanel_ = chartPanel;
/* 260 */       initChartPanel();
/*     */     }
/*     */     
/*     */     public void setChartType(String type) {
/* 264 */       AbstractFormChart.this.chartType_ = AbstractFormChart.Type.forName(type);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMethod(String argMethod) {
/* 270 */       this.method_ = argMethod;
/*     */     }
/*     */     
/*     */     public void setSerieColor(int index, Color color) {
/* 274 */       AbstractFormChart.this.serieColors_.put(Integer.valueOf(index), color);
/*     */     }
/*     */     
/*     */     public void setShowPoints(boolean showPoints) {
/* 278 */       AbstractFormChart.this.showPoints_ = showPoints;
/*     */     }
/*     */     
/*     */     public void setUseLegend(boolean useLegend) {
/* 282 */       AbstractFormChart.this.useLegend_ = useLegend;
/*     */     }
/*     */     
/*     */     public void setVerticalTickLabels(boolean verticalTickLabels) {
/* 286 */       AbstractFormChart.this.verticalTickLabels_ = verticalTickLabels;
/*     */     }
/*     */     
/*     */     private void initChartPanel() {
/* 290 */       removeAll();
/* 291 */       add((Component)this.chartPanel_, "Center");
/* 292 */       revalidate();
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface IChartModel
/*     */   {
/*     */     Dataset getDataset();
/*     */     
/*     */     String getDateFormatterType();
/*     */     
/*     */     Map<String, Object> getProperties();
/*     */     
/*     */     String getTitle();
/*     */     
/*     */     void setDataset(Dataset param1Dataset);
/*     */     
/*     */     void setDateFormatterType(String param1String);
/*     */   }
/*     */   
/*     */   public enum Type {
/* 312 */     LINE, BAR;
/*     */     
/*     */     public static Type forName(String type) {
/* 315 */       String t = type.toLowerCase();
/* 316 */       switch (t) {
/*     */         case "line":
/* 318 */           return LINE;
/*     */         
/*     */         case "bar":
/* 321 */           return BAR;
/*     */       } 
/*     */ 
/*     */       
/* 325 */       return LINE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\AbstractFormChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */