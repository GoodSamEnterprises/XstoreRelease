/*     */ package dtv.pos.framework.reporting;
/*     */ 
/*     */ import dtv.hardware.config.HardwareConfigMgr;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.reporting.type.ReportSaveType;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import dtv.pos.iframework.reporting.IReportFill;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.print.attribute.AttributeSet;
/*     */ import javax.print.attribute.PrintRequestAttributeSet;
/*     */ import org.apache.pdfbox.pdmodel.PDDocument;
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
/*     */ public class ReportInfo
/*     */ {
/*     */   private PDDocument pdfPrint_;
/*     */   private IReportDefinition _reportDefinition;
/*     */   private boolean runReport_ = true;
/*  31 */   private Map<String, Object> parameterMap_ = new HashMap<>();
/*  32 */   private boolean showDialog_ = HardwareConfigMgr.getInstance().getShowPrinterDialog();
/*     */   private IReportFill reportFill_;
/*  34 */   private Integer maximumRows_ = null;
/*     */   private IFormattable reportTitle_;
/*     */   private IFormattable reportPromptMessage_;
/*     */   private String savedReportName_;
/*     */   private ReportSaveType saveType_;
/*     */   private AttributeSet printerAttributes_;
/*     */   private PrintRequestAttributeSet printerRequestAttributes_;
/*     */   private int labelPosition_;
/*     */   private int labelCount_;
/*     */   private int labelsPerSheet_;
/*     */   private Properties properties_;
/*     */   private Collection<?> dataSource_;
/*     */   
/*     */   public Collection<?> getDataSource() {
/*  48 */     return this.dataSource_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLabelCount() {
/*  53 */     return this.labelCount_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLabelPosition() {
/*  58 */     return this.labelPosition_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLabelsPerSheet() {
/*  63 */     return this.labelsPerSheet_;
/*     */   }
/*     */   
/*     */   public Integer getMaximumRows() {
/*  67 */     return this.maximumRows_;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getParameterMap() {
/*  71 */     return this.parameterMap_;
/*     */   }
/*     */   
/*     */   public PDDocument getPrint() {
/*  75 */     return this.pdfPrint_;
/*     */   }
/*     */   
/*     */   public AttributeSet getPrinterAttributes() {
/*  79 */     return this.printerAttributes_;
/*     */   }
/*     */   
/*     */   public PrintRequestAttributeSet getPrinterRequestAttributes() {
/*  83 */     return this.printerRequestAttributes_;
/*     */   }
/*     */   
/*     */   public String getProperty(String argKey, String argDefault) {
/*  87 */     if (this.properties_ == null) {
/*  88 */       return argDefault;
/*     */     }
/*  90 */     return this.properties_.getProperty(argKey, argDefault);
/*     */   }
/*     */   
/*     */   public IReportDefinition getReportDefinition() {
/*  94 */     return this._reportDefinition;
/*     */   }
/*     */   
/*     */   public IReportFill getReportFill() {
/*  98 */     return this.reportFill_;
/*     */   }
/*     */   
/*     */   public IFormattable getReportPromptMessage() {
/* 102 */     return (this.reportPromptMessage_ == null && getReportDefinition() != null) ? 
/* 103 */       getReportDefinition().getParameterPromptMessage() : this.reportPromptMessage_;
/*     */   }
/*     */   
/*     */   public IFormattable getReportTitle() {
/* 107 */     return (this.reportTitle_ == null && getReportDefinition() != null) ? getReportDefinition().getTitle() : this.reportTitle_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getRunReport() {
/* 112 */     return this.runReport_;
/*     */   }
/*     */   
/*     */   public String getSavedReportName() {
/* 116 */     return this.savedReportName_;
/*     */   }
/*     */   
/*     */   public ReportSaveType getSaveType() {
/* 120 */     return this.saveType_;
/*     */   }
/*     */   
/*     */   public boolean getShowPrintDialog() {
/* 124 */     return this.showDialog_;
/*     */   }
/*     */   
/*     */   public void setDataSource(Collection<?> argDataSource) {
/* 128 */     this.dataSource_ = argDataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelCount(int argLabelCount) {
/* 136 */     this.labelCount_ = argLabelCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelPosition(int argLabelPosition) {
/* 144 */     this.labelPosition_ = argLabelPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelsPerSheet(int argLabelsPerSheet) {
/* 152 */     this.labelsPerSheet_ = argLabelsPerSheet;
/*     */   }
/*     */   
/*     */   public void setMaximumRows(Integer newValue) {
/* 156 */     this.maximumRows_ = newValue;
/*     */   }
/*     */   
/*     */   public void setParameterMap(Map<String, Object> newValue) {
/* 160 */     this.parameterMap_ = newValue;
/*     */   }
/*     */   
/*     */   public void setPrint(PDDocument newValue) {
/* 164 */     this.pdfPrint_ = newValue;
/*     */   }
/*     */   
/*     */   public void setPrinterAttributes(AttributeSet argPrinterAttributes) {
/* 168 */     this.printerAttributes_ = argPrinterAttributes;
/*     */   }
/*     */   
/*     */   public void setPrinterRequestAttributes(PrintRequestAttributeSet argPrinterRequestAttributes) {
/* 172 */     this.printerRequestAttributes_ = argPrinterRequestAttributes;
/*     */   }
/*     */   
/*     */   public void setProperty(String argKey, String argValue) {
/* 176 */     getPropertiesImpl().setProperty(argKey, argValue);
/*     */   }
/*     */   
/*     */   public void setReportDefinition(IReportDefinition argReportDefinition) {
/* 180 */     this._reportDefinition = argReportDefinition;
/*     */   }
/*     */   
/*     */   public void setReportFill(IReportFill argReportFill) {
/* 184 */     this.reportFill_ = argReportFill;
/*     */   }
/*     */   
/*     */   public void setReportPromptMessage(IFormattable newValue) {
/* 188 */     this.reportPromptMessage_ = newValue;
/*     */   }
/*     */   
/*     */   public void setReportTitle(IFormattable newValue) {
/* 192 */     this.reportTitle_ = newValue;
/*     */   }
/*     */   
/*     */   public void setRunReport(boolean newValue) {
/* 196 */     this.runReport_ = newValue;
/*     */   }
/*     */   
/*     */   public void setSavedReportName(String newValue) {
/* 200 */     this.savedReportName_ = newValue;
/*     */   }
/*     */   
/*     */   public void setSaveType(ReportSaveType newValue) {
/* 204 */     this.saveType_ = newValue;
/*     */   }
/*     */   
/*     */   public void setShowPrintDialog(boolean newValue) {
/* 208 */     this.showDialog_ = newValue;
/*     */   }
/*     */   
/*     */   protected Properties getPropertiesImpl() {
/* 212 */     if (this.properties_ == null) {
/* 213 */       this.properties_ = new Properties();
/*     */     }
/* 215 */     return this.properties_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */