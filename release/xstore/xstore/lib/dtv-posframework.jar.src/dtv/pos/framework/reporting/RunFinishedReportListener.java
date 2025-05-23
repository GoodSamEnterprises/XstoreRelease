/*     */ package dtv.pos.framework.reporting;
/*     */ 
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.action.XstChainAction;
/*     */ import dtv.pos.framework.action.type.XstChainActionType;
/*     */ import dtv.pos.framework.reporting.config.ReportActionConfig;
/*     */ import dtv.pos.framework.reporting.config.ReportRunConfig;
/*     */ import dtv.pos.framework.reporting.type.ReportSaveType;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.IXstChainActionType;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.reporting.IReportFill;
/*     */ import dtv.pos.iframework.reporting.IReportFillListener;
/*     */ import dtv.pos.iframework.reporting.IReportMgr;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.print.attribute.AttributeSet;
/*     */ import javax.print.attribute.PrintRequestAttributeSet;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.pdfbox.pdmodel.PDDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RunFinishedReportListener
/*     */   implements IReportFillListener
/*     */ {
/*  34 */   private static final Logger _logger = Logger.getLogger(RunFinishedReportListener.class);
/*     */   
/*     */   private final ReportRunConfig run_;
/*     */   
/*     */   private final IReportMgr _reportManager;
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   
/*     */   @Inject
/*     */   private StationState _stationState;
/*     */   
/*     */   public RunFinishedReportListener(ReportRunConfig argRun, IReportMgr argReportManager) {
/*  47 */     InjectionHammer.forceAtInjectProcessing(this);
/*  48 */     this.run_ = argRun;
/*  49 */     this._reportManager = argReportManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillCanceled(IReportFill argReport) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillFailed(IReportFill argReport) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillFinished(IReportFill argReport) {
/*  65 */     ReportActionConfig[] actions = this.run_.getActions();
/*     */     
/*  67 */     for (ReportActionConfig actionConfig : actions) {
/*     */       
/*  69 */       ReportInfo reportInfo = new ReportInfo();
/*     */       
/*  71 */       reportInfo.setRunReport(true);
/*  72 */       reportInfo.setShowPrintDialog(false);
/*  73 */       reportInfo.setSaveType(ReportSaveType.INCLUDE_DATA);
/*     */       
/*  75 */       reportInfo.setReportFill(argReport);
/*  76 */       reportInfo.setPrint((PDDocument)argReport.getResults());
/*  77 */       reportInfo.setSavedReportName(this.run_.getTitle());
/*     */       
/*  79 */       ParameterConfig[] params = actionConfig.getParameters();
/*     */       
/*  81 */       for (ParameterConfig p : params) {
/*  82 */         Object v = p.getValue();
/*     */         
/*  84 */         if (v != null) {
/*  85 */           reportInfo.setProperty(p.getName(), v.toString());
/*     */         }
/*     */       } 
/*     */       
/*  89 */       PDDocument print = reportInfo.getPrint();
/*     */       
/*  91 */       switch (RunFinishedAction.valueOf(actionConfig.getDataKey())) {
/*     */         case REPORT_SAVE_QUIET:
/*  93 */           if (print == null) {
/*  94 */             _logger.warn("nothing to save as " + reportInfo.getSavedReportName());
/*     */           }
/*     */           try {
/*  97 */             this._reportManager.saveStoreReport(reportInfo.getSavedReportName(), print, 
/*  98 */                 Integer.toString(this._stationState.getRetailLocationId()));
/*     */           }
/* 100 */           catch (Exception ex) {
/* 101 */             _logger.error("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */           break;
/*     */ 
/*     */         
/*     */         case REPORT_PRINT_QUIET:
/* 107 */           if (print == null || print.getNumberOfPages() == 0) {
/* 108 */             _logger.warn("nothing to print for " + reportInfo.getSavedReportName());
/*     */             break;
/*     */           } 
/*     */           try {
/* 112 */             AttributeSet printerAttribs = reportInfo.getPrinterAttributes();
/* 113 */             PrintRequestAttributeSet printRequestAttribs = reportInfo.getPrinterRequestAttributes();
/*     */             
/* 115 */             ReportUtils.printPages(print, false, printerAttribs, printRequestAttribs, 1);
/*     */           }
/* 117 */           catch (Exception ex) {
/* 118 */             _logger.error("CAUGHT EXCEPTION with " + reportInfo.getSavedReportName(), ex);
/*     */           } 
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 125 */           _logger.warn("An unknown report run action [" + actionConfig.getDataKey() + "] was specified for report run [" + this.run_
/* 126 */               .getName() + "].");
/*     */           break;
/*     */       } 
/*     */       
/* 130 */       OpChainKey chainKey = OpChainKey.valueOf(actionConfig.getDataKey());
/*     */       
/* 132 */       XstChainAction runChainAction = new XstChainAction((IXstChainActionType)XstChainActionType.SYSTEM, chainKey);
/* 133 */       ((IModeController)this._modeProvider.get()).getEventRouter().fireEvent((IXstEvent)runChainAction);
/*     */     } 
/*     */   }
/*     */   
/*     */   public enum RunFinishedAction {
/* 138 */     REPORT_SAVE_QUIET, REPORT_PRINT_QUIET;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\RunFinishedReportListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */