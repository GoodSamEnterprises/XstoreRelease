/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.pos.common.CommonHelper;
/*     */ import dtv.pos.framework.reporting.ReportFillException;
/*     */ import dtv.pos.framework.reporting.ReportFillStatus;
/*     */ import dtv.pos.framework.reporting.dataset.IDatasetGenerator;
/*     */ import dtv.pos.framework.reporting.layout.RtfLayoutTemplateTransformer;
/*     */ import dtv.pos.framework.reporting.layout.XslLayoutTemplateTransformer;
/*     */ import dtv.pos.framework.reporting.type.ReportOutputFormat;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import dtv.pos.iframework.reporting.IReportFill;
/*     */ import dtv.pos.iframework.reporting.IReportFillListener;
/*     */ import dtv.pos.iframework.reporting.IReportHelper;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import javax.print.attribute.AttributeSet;
/*     */ import javax.print.attribute.PrintRequestAttributeSet;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.pdfbox.pdmodel.PDDocument;
/*     */ 
/*     */ 
/*     */ public class ReportFill
/*     */   implements IReportFill
/*     */ {
/*  37 */   private static final Logger logger_ = Logger.getLogger(ReportFill.class);
/*     */   
/*     */   private static final String REPORT_FONT_DIR = "XDO_FONT_DIR";
/*     */   
/*  41 */   private static Object nextFillIdLock_ = new Object();
/*     */   
/*     */   private static int nextFillId_;
/*     */   protected Collection<?> dataSource_;
/*     */   protected Map<String, Object> reportParametersValues_;
/*     */   protected String description_;
/*     */   
/*     */   public static void cleanupParameters(Map<String, Object> argMap) {
/*  49 */     for (Object param : argMap.values()) {
/*     */       
/*  51 */       if (param instanceof InputStream) {
/*     */         try {
/*  53 */           ((InputStream)param).close();
/*     */         }
/*  55 */         catch (Exception ex) {
/*  56 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object results_;
/*     */   
/*     */   protected Throwable problem_;
/*     */   protected IReportDefinition _reportDef;
/*     */   protected ReportOutputFormat _outputFormat;
/*     */   protected Map<String, byte[]> _imageMap;
/*     */   
/*     */   public static Map<String, Object> copyAndExtendMap(Map<String, Object> argMap, IReportHelper argReportHelper) {
/*  71 */     Map<String, Object> map = (argMap == null) ? new HashMap<>() : new HashMap<>(argMap);
/*     */     
/*  73 */     CommonReportParameters.addAllToMap(map);
/*     */     
/*  75 */     if (argReportHelper != null) {
/*  76 */       map.put(CommonReportParameters.REPORT_HELPER.getName(), argReportHelper);
/*     */     }
/*     */     
/*  79 */     return map;
/*     */   }
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
/*     */   public static IReportFill make(IReportDefinition argReportDefinition, Map<String, Object> argParameters, ReportOutputFormat argOutputFormat, AttributeSet argPrinterAttributeSet, PrintRequestAttributeSet argPrintRequestAttributeSet, Collection<?> argDataSource) {
/*  95 */     IReportFill rf = new ReportFill(argReportDefinition, argParameters, argOutputFormat, argPrinterAttributeSet, argPrintRequestAttributeSet, argDataSource);
/*     */ 
/*     */     
/*  98 */     return rf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IReportFill make(URL argUrl) {
/* 107 */     ReportFill rf = new UrlReportFill(argUrl);
/* 108 */     rf.description_ = argUrl.toExternalForm();
/* 109 */     return rf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Map<String, Object> copyAndExtendMap(Map<String, Object> argMap) {
/* 119 */     return copyAndExtendMap(argMap, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getNextFillId() {
/* 126 */     int i = 0;
/*     */     
/* 128 */     synchronized (nextFillIdLock_) {
/* 129 */       i = ++nextFillId_;
/*     */     } 
/*     */     
/* 132 */     return i;
/*     */   }
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
/* 144 */   private final int fillId_ = getNextFillId();
/* 145 */   private final Date time_ = DateUtils.getNewDate();
/*     */   private final AttributeSet printerAttributeSet_;
/*     */   private final PrintRequestAttributeSet printRequestAttributeSet_;
/* 148 */   private final List<IReportFillListener> fillListeners_ = new ArrayList<>();
/*     */   
/*     */   private boolean isBackground_;
/* 151 */   private ReportFillStatus status_ = ReportFillStatus.NEW;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private CommonHelper _commonHelper;
/*     */   
/*     */   @Inject
/*     */   private IDatasetGenerator _xmlDatasetGenerator;
/*     */   
/*     */   @Inject
/*     */   private XslLayoutTemplateTransformer _xslTransformer;
/*     */   
/*     */   @Inject
/*     */   private RtfLayoutTemplateTransformer _rtfTransformer;
/*     */   
/*     */   private Thread _fillingThread;
/*     */ 
/*     */   
/*     */   public ReportFill(IReportDefinition argReportDefinition, Map<String, Object> argParameters, ReportOutputFormat argOutputFormat, AttributeSet argPrinterAttributeSet, PrintRequestAttributeSet argPrintRequestAttributeSet, Collection<?> argDataSource) {
/* 170 */     this(argPrinterAttributeSet, argPrintRequestAttributeSet);
/* 171 */     this._reportDef = argReportDefinition;
/* 172 */     this._outputFormat = argOutputFormat;
/* 173 */     this
/* 174 */       .reportParametersValues_ = DtvDate.ensureProperDates(copyAndExtendMap(argParameters, ReportHelper.getInstance()));
/* 175 */     this.dataSource_ = argDataSource;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ReportFill(AttributeSet argPrinterAttributeSet, PrintRequestAttributeSet argPrintRequestAttributeSet) {
/* 180 */     InjectionHammer.forceAtInjectProcessing(this);
/* 181 */     this.printerAttributeSet_ = argPrinterAttributeSet;
/* 182 */     this.printRequestAttributeSet_ = argPrintRequestAttributeSet;
/* 183 */     System.setProperty("XDO_FONT_DIR", getReportFontDir());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFillListener(IReportFillListener argListener) {
/* 189 */     this.fillListeners_.add(argListener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() {
/* 195 */     Thread t = this._fillingThread;
/* 196 */     if (t != null) {
/* 197 */       t.interrupt();
/*     */     }
/* 199 */     logger_.warn("no good way to cancel a report fill");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 205 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillId() {
/* 211 */     return this.fillId_;
/*     */   }
/*     */   
/*     */   public Map<String, byte[]> getImageMap() {
/* 215 */     return this._imageMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeSet getPrinterAttributeSet() {
/* 221 */     return this.printerAttributeSet_;
/*     */   }
/*     */ 
/*     */   
/*     */   public PrintRequestAttributeSet getPrintRequestAttributeSet() {
/* 226 */     return this.printRequestAttributeSet_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getProblem() {
/* 232 */     return this.problem_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getResults() {
/* 238 */     return this.results_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportFillStatus getStatus() {
/* 244 */     return this.status_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getTime() {
/* 250 */     return this.time_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBackground() {
/* 256 */     return this.isBackground_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCanceled() {
/* 264 */     return (this.status_ == ReportFillStatus.CANCELED);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeFillListener(IReportFillListener argListener) {
/* 270 */     this.fillListeners_.remove(argListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() throws ReportFillException {
/* 278 */     this._fillingThread = Thread.currentThread();
/*     */ 
/*     */     
/*     */     try {
/* 282 */       byte[] xslLayout = this._rtfTransformer.transform(this._reportDef);
/*     */ 
/*     */       
/* 285 */       byte[] xmlDataset = this._xmlDatasetGenerator.generate(this._reportDef, this.reportParametersValues_, this.dataSource_);
/*     */ 
/*     */       
/* 288 */       byte[] doc = this._xslTransformer.transform(this._reportDef, this._outputFormat, xslLayout, xmlDataset, this._imageMap);
/* 289 */       setReportResults(doc);
/*     */     
/*     */     }
/* 292 */     catch (Exception ex) {
/* 293 */       throw new ReportFillException("Failed to generate report", ex);
/*     */     } finally {
/*     */       
/* 296 */       this._fillingThread = null;
/* 297 */       cleanupParameters();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String newValue) {
/* 305 */     this.description_ = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsBackground(boolean newValue) {
/* 311 */     this.isBackground_ = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProblem(Throwable argProblem) {
/* 317 */     this.problem_ = argProblem;
/* 318 */     setStatus(ReportFillStatus.FAILED);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatus(ReportFillStatus argStatus) {
/* 324 */     this.status_ = argStatus;
/* 325 */     notifyListeners();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 331 */     return "ReportFill[" + getDescription() + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cleanupParameters() {
/* 338 */     cleanupParameters(this.reportParametersValues_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getReportFontDir() {
/* 346 */     String root = getRootDir();
/* 347 */     if (root != null && 
/* 348 */       !root.endsWith(File.separator)) {
/* 349 */       root = root + File.separator;
/*     */     }
/*     */     
/* 352 */     return ((root != null) ? root : "") + "res" + File.separator + "fonts" + File.separator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getReportId() {
/* 360 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getRootDir() {
/* 368 */     return this._commonHelper.getXstoreRoot();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void notifyListeners() {
/* 375 */     if (this.status_.isFinalState()) {
/* 376 */       for (IReportFillListener l : this.fillListeners_) {
/* 377 */         if (this.status_ == ReportFillStatus.SUCCESS) {
/* 378 */           l.fillFinished(this); continue;
/*     */         } 
/* 380 */         if (this.status_ == ReportFillStatus.CANCELED) {
/* 381 */           l.fillCanceled(this);
/*     */           continue;
/*     */         } 
/* 384 */         if (this.status_ != ReportFillStatus.FAILED) {
/* 385 */           logger_.warn("reporting FAILED because completed with status=" + this.status_);
/*     */         }
/* 387 */         l.fillFailed(this);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setReportResults(byte[] argResults) throws IOException {
/* 395 */     setResults(PDDocument.load(argResults));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setResults(Object argResults) {
/* 403 */     this.results_ = argResults;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\ReportFill.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */