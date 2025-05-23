/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.i18n.FormatPatternFactory;
/*    */ import dtv.i18n.FormatterType;
/*    */ import dtv.i18n.LocaleManager;
/*    */ import dtv.i18n.OutputContextType;
/*    */ import dtv.pos.chart.util.ChartUtility;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.util.MutableString;
/*    */ import java.util.Locale;
/*    */ import org.jfree.chart.ChartPanel;
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
/*    */ 
/*    */ 
/*    */ public class FormChart<T extends IFormModel>
/*    */   extends AbstractFormChart<T>
/*    */ {
/*    */   protected void setComponentValue(Object argValue) {
/* 30 */     String datePattern = null;
/*    */     
/* 32 */     if (this._formatter != null) {
/* 33 */       Locale locView = LocaleManager.getInstance().getLocale(OutputContextType.VIEW);
/*    */       
/* 35 */       MutableString patternString = FormatPatternFactory.getInstance().getFormatPattern(FormatterType.forName(this._formatter.getTypeName()), OutputContextType.VIEW, locView);
/* 36 */       datePattern = patternString.toString();
/*    */     } 
/*    */     
/* 39 */     ChartUtility chartUtil = new ChartUtility();
/* 40 */     this.chart_ = chartUtil.createJFreeChart(argValue, datePattern);
/*    */     
/* 42 */     getChartContentPane().setChartPanel(new ChartPanel(this.chart_));
/* 43 */     getChartContentPane().getChartPanel().setPopupMenu(null);
/* 44 */     getChartContentPane().getChartPanel().setDomainZoomable(false);
/* 45 */     getChartContentPane().getChartPanel().setRangeZoomable(false);
/* 46 */     getChartContentPane().getChartPanel().setPreferredSize(getDisplayComponent().getMaximumSize());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */