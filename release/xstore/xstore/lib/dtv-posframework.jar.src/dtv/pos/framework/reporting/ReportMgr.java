/*     */ package dtv.pos.framework.reporting;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.exception.PersistenceException;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.OpExecutionException;
/*     */ import dtv.pos.framework.reporting.config.ReportGroupConfig;
/*     */ import dtv.pos.framework.reporting.config.ReportRunConfig;
/*     */ import dtv.pos.framework.reporting.config.ReportRunConfigHelper;
/*     */ import dtv.pos.framework.reporting.config.ReportingConfigException;
/*     */ import dtv.pos.framework.reporting.type.ReportOwnerType;
/*     */ import dtv.pos.framework.reporting.type.SavedReportType;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import dtv.pos.iframework.reporting.IReportFill;
/*     */ import dtv.pos.iframework.reporting.IReportMgr;
/*     */ import dtv.pos.iframework.reporting.IReportQueryParam;
/*     */ import dtv.pos.iframework.reporting.IReportRunRule;
/*     */ import dtv.util.ICodeInterface;
/*     */ import dtv.xst.dao.com.IReportData;
/*     */ import dtv.xst.dao.com.IReportLookup;
/*     */ import dtv.xst.dao.com.ReportDataId;
/*     */ import dtv.xst.dao.com.ReportLookupId;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.pdfbox.pdmodel.PDDocument;
/*     */ 
/*     */ public class ReportMgr implements IReportMgr {
/*  39 */   public static final String SYSTEM_PROPERTY = ReportMgr.class.getName();
/*     */   
/*     */   protected static final String EMPLOYEE_ID_PARAM = "argEmployeeId";
/*     */   
/*     */   protected static final String RETAIL_LOCATION_PARAM = "argRetailLocationId";
/*     */   protected static final String DELETE_FLAG = "argDeleteFlag";
/*     */   protected static final String SEQ_TYPE_SAVED_REPORT = "SAVED_REPORT";
/*  46 */   protected static final IQueryKey<IReportLookup> SAVED_REPORTS = (IQueryKey<IReportLookup>)new QueryKey("SAVED_REPORTS", IReportLookup.class);
/*     */   
/*  48 */   protected static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*  50 */   private static IReportMgr INSTANCE = null;
/*  51 */   private static final Logger logger_ = Logger.getLogger(ReportMgr.class);
/*     */   
/*     */   private Map<String, IReportDefinition> _reportCatalog;
/*     */   private Map<String, PrinterType> _reportPrinterTypes;
/*     */   private Map<String, PrintRequestType> _reportPrintRequestTypes;
/*     */   
/*     */   public static IReportMgr getInstance() {
/*  58 */     if (INSTANCE == null) {
/*  59 */       throw new IllegalStateException("not instantiated");
/*     */     }
/*  61 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Object loadObject(URL argUrl, String argSourceDescription) throws DtvReportLoadException {
/*  67 */     logReportLoad(argUrl, argSourceDescription);
/*     */     
/*  69 */     InputStream instream = null;
/*     */     try {
/*  71 */       instream = argUrl.openStream();
/*  72 */       Object o = null;
/*  73 */       ObjectInputStream ois = new ObjectInputStream(instream);
/*  74 */       o = ois.readObject();
/*  75 */       return o;
/*     */     }
/*  77 */     catch (Exception ex) {
/*  78 */       throw new DtvReportLoadException("unable to load " + argUrl, ex);
/*     */     } finally {
/*     */       
/*  81 */       if (instream != null) {
/*     */         try {
/*  83 */           instream.close();
/*     */         }
/*  85 */         catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void logReportLoad(URL argUrl, String argSourceDescription) {
/*  91 */     if (logger_.isInfoEnabled()) {
/*  92 */       StringBuilder msg = new StringBuilder("Loading Report - ");
/*  93 */       URL url = null;
/*     */       
/*  95 */       if ("classpath".equalsIgnoreCase(argUrl.getProtocol())) {
/*  96 */         url = ClassPathUtils.getResource(argUrl.getHost() + argUrl.getFile());
/*     */       }
/*     */       
/*  99 */       if (url == null) {
/* 100 */         url = argUrl;
/*     */       }
/*     */       
/* 103 */       msg.append(url.toExternalForm());
/*     */       
/* 105 */       if (argSourceDescription != null) {
/* 106 */         msg.append(" @@ ");
/* 107 */         msg.append(argSourceDescription);
/*     */       } 
/*     */       
/* 110 */       logger_.info(msg);
/*     */     } 
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
/*     */   protected ReportMgr() {
/* 123 */     if (INSTANCE != null) {
/* 124 */       throw new IllegalStateException("already instantiated");
/*     */     }
/* 126 */     INSTANCE = this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IReportQueryParam buildSqlInStatement(String argFieldName, Object[] argValues) {
/* 132 */     if (argValues.length == 0) {
/* 133 */       return null;
/*     */     }
/*     */     
/* 136 */     return isSqlInSupported() ? 
/* 137 */       buildSqlInUsingIn(argFieldName, argValues) : 
/* 138 */       buildSqlInUsingEquals(argFieldName, argValues);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelReport(IReportFill argFill) {
/* 144 */     ReportQueue.getInstance().cancelReport(argFill);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportStorage convertReportForSave(PDDocument argPrint) {
/* 150 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */     try {
/* 152 */       argPrint.save(baos);
/*     */     }
/* 154 */     catch (IOException ex) {
/* 155 */       logger_.error("ERROR saving report as output stream", ex);
/*     */     } 
/* 157 */     ReportStorage rs = new ReportStorage(baos.toByteArray());
/*     */     
/* 159 */     return rs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteSaved(IReportLookup argLookup) {
/* 166 */     ArrayList<IDataModel> persistables = new ArrayList<>();
/*     */     
/* 168 */     markAsDeletedAndAddToList(argLookup, persistables);
/*     */ 
/*     */     
/*     */     try {
/* 172 */       DataFactory.makePersistent(persistables);
/*     */     }
/* 174 */     catch (PersistenceException ex) {
/* 175 */       logger_.error("Exception caught trying to persist objects when deleting report data.", (Throwable)ex);
/* 176 */       throw new OpExecutionException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillReport(IReportFill argFill) {
/* 183 */     ReportQueue.getInstance().fillReport(argFill);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IReportDefinition[] getLabelLayouts(LabelUsage argUsage) {
/* 189 */     List<IReportDefinition> labels = new ArrayList<>();
/* 190 */     this._reportCatalog.values().stream().filter(p -> 
/* 191 */         (p.getLabelUsage() != null && p.getLabelUsage().getName().equalsIgnoreCase(argUsage.getName())))
/* 192 */       .forEach(r -> labels.add(r));
/* 193 */     return labels.<IReportDefinition>toArray(new IReportDefinition[labels.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeSet getPrinterServiceAttributes(String argPrinterName) {
/* 199 */     PrinterType printerType = this._reportPrinterTypes.get(argPrinterName);
/*     */     
/* 201 */     return (printerType == null) ? null : printerType.getAttributes();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintRequestAttributeSet getPrintRequestAttributes(String argPrintRequestType) {
/* 207 */     PrintRequestType printRequestType = this._reportPrintRequestTypes.get(argPrintRequestType);
/*     */     
/* 209 */     return (printRequestType == null) ? null : printRequestType.getAttributes();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable[] getPromptInformation(IReportLookup argLookup) {
/*     */     IFormattable ownerTypePhrase;
/*     */     
/*     */     try { IFormattable reportNamePhrase, iFormattable3, reportDatePhrase;
/* 218 */       switch (ReportOwnerType.valueOf(argLookup.getOwnerType()))
/*     */       { case EMPLOYEE:
/* 220 */           ownerTypePhrase = FF.getTranslatable("_reportDeleteConfirmOwnerTypeEmployee");
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
/* 234 */           reportNamePhrase = FF.getLiteral(argLookup.getDescription());
/*     */           
/* 236 */           reportDatePhrase = FF.getSimpleFormattable(argLookup.getRecordCreationDate(), FormatterType.DATE_MEDIUM);
/*     */           
/* 238 */           return new IFormattable[] { ownerTypePhrase, reportNamePhrase, reportDatePhrase };case RETAIL_LOCATION: ownerTypePhrase = FF.getTranslatable("_reportDeleteConfirmOwnerTypeRetailLocation"); iFormattable3 = FF.getLiteral(argLookup.getDescription()); reportDatePhrase = FF.getSimpleFormattable(argLookup.getRecordCreationDate(), FormatterType.DATE_MEDIUM); return new IFormattable[] { ownerTypePhrase, iFormattable3, reportDatePhrase }; }  ownerTypePhrase = FF.getTranslatable("_reportDeleteConfirmOwnerTypeChain"); } catch (Exception exception) { ownerTypePhrase = FF.getTranslatable("_reportDeleteConfirmOwnerTypeChain"); }  IFormattable iFormattable1 = FF.getLiteral(argLookup.getDescription()); IFormattable iFormattable2 = FF.getSimpleFormattable(argLookup.getRecordCreationDate(), FormatterType.DATE_MEDIUM); return new IFormattable[] { ownerTypePhrase, iFormattable1, iFormattable2 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IReportDefinition getReportDefinition(String argReport) {
/* 244 */     return this._reportCatalog.get(argReport);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IReportLookup[] getSavedReports(String argRetailLocationID, String argEmployeeID) {
/* 250 */     Map<String, Object> params = new HashMap<>();
/* 251 */     params.put("argRetailLocationId", argRetailLocationID);
/* 252 */     params.put("argEmployeeId", argEmployeeID);
/* 253 */     params.put("argDeleteFlag", Boolean.valueOf(false));
/*     */     
/* 255 */     IQueryResultList iQueryResultList = DataFactory.getObjectByQuery(SAVED_REPORTS, params);
/*     */     
/* 257 */     return (IReportLookup[])iQueryResultList.toArray((Object[])new IReportLookup[iQueryResultList.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PDDocument loadPrint(URL argUrl) throws DtvReportLoadException {
/* 265 */     Object o = loadObject(argUrl, null);
/*     */     
/*     */     try {
/* 268 */       ReportStorage r = (ReportStorage)o;
/* 269 */       return PDDocument.load(r.getPrint());
/*     */     }
/* 271 */     catch (ClassCastException ex) {
/* 272 */       throw new DtvReportLoadException("instead of " + PDDocument.class
/* 273 */           .getName() + " loaded a " + ObjectUtils.getClassNameFromObject(o), ex);
/*     */     
/*     */     }
/* 276 */     catch (IOException ex) {
/* 277 */       throw new DtvReportLoadException("ERROR loading " + PDDocument.class.getName(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IReportLookup makeLookup(String argName, ReportOwnerType argOwnerType, String argOwner, SavedReportType argRecordType) {
/* 285 */     ReportLookupId lookupId = new ReportLookupId();
/*     */     
/* 287 */     lookupId.setOwnerId(argOwner);
/* 288 */     lookupId.setOwnerType(argOwnerType.name());
/* 289 */     lookupId.setReportId(SequenceFactory.getNextStringValue("SAVED_REPORT", new Object[0]));
/* 290 */     IReportLookup lookup = (IReportLookup)DataFactory.createObject((IObjectId)lookupId, IReportLookup.class);
/* 291 */     lookup.setRecordCreationDate(DateUtils.getNewDate());
/* 292 */     lookup.setDescription(argName);
/* 293 */     lookup.setRecordType(argRecordType.getName());
/*     */     
/* 295 */     return lookup;
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
/*     */   public void runBackgroupReport(String argReportName) throws ReportingConfigException {
/* 309 */     ReportRunConfigHelper rrch = getReportRunConfigHelper();
/* 310 */     if (rrch != null) {
/* 311 */       ReportRunConfig run = rrch.getReportRun(argReportName);
/* 312 */       validateRunConfig(run);
/* 313 */       runBackgroupReport("", run);
/*     */     } 
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
/*     */   public void runBackgroupReportGroup(String argGroupName) throws ReportingConfigException {
/* 328 */     ReportRunConfigHelper h = getReportRunConfigHelper();
/* 329 */     ReportGroupConfig group = null;
/* 330 */     if (h != null) {
/* 331 */       group = h.getReportGroup(argGroupName);
/*     */     }
/*     */     
/* 334 */     if (group == null || !group.isEnabled()) {
/* 335 */       logger_.info("report group " + argGroupName + " is disabled");
/*     */       
/*     */       return;
/*     */     } 
/* 339 */     String[] reportNames = group.getReports();
/* 340 */     List<ReportRunConfig> validRuns = new ArrayList<>();
/*     */     
/* 342 */     for (String name : reportNames) {
/* 343 */       ReportRunConfig run = h.getReportRun(name);
/*     */       
/*     */       try {
/* 346 */         validateRunConfig(run);
/* 347 */         validRuns.add(run);
/*     */       }
/* 349 */       catch (ReportingConfigException ex) {
/* 350 */         logger_.error("CAUGHT EXCEPTION", (Throwable)ex);
/*     */       } 
/*     */     } 
/*     */     
/* 354 */     if (validRuns.isEmpty()) {
/* 355 */       throw new ReportingConfigException("no valid report runs configured in " + argGroupName);
/*     */     }
/*     */     
/* 358 */     for (ReportRunConfig validRun : validRuns) {
/* 359 */       runBackgroupReport(argGroupName, validRun);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveReport(String argName, PDDocument argPrint, String argOwner) throws IOException {
/* 366 */     saveReport(argName, argPrint, ReportOwnerType.OTHER, argOwner);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveStoreReport(String argName, PDDocument argPrint, String argRetailLocationId) throws IOException {
/* 372 */     saveReport(argName, argPrint, ReportOwnerType.RETAIL_LOCATION, argRetailLocationId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveStoreReportCriteria(String argName, URL argUrl, String argRetailLocationId) throws IOException {
/* 379 */     saveReportCriteria(argName, argUrl, ReportOwnerType.RETAIL_LOCATION, argRetailLocationId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveUserReport(String argName, PDDocument argPrint, String argEmployeeId) throws IOException {
/* 385 */     saveReport(argName, argPrint, ReportOwnerType.EMPLOYEE, argEmployeeId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveUserReportCriteria(String argName, URL argUrl, String argEmployeeId) throws IOException {
/* 392 */     saveReportCriteria(argName, argUrl, ReportOwnerType.EMPLOYEE, argEmployeeId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   public void setPrinterType(List<PrinterType> argPrinterTypes) {
/* 401 */     this._reportPrinterTypes = new HashMap<>();
/* 402 */     argPrinterTypes.forEach(printerType -> (PrinterType)this._reportPrinterTypes.put(printerType.getName(), printerType));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   public void setPrintRequestType(List<PrintRequestType> argPrintRequestTypes) {
/* 411 */     this._reportPrintRequestTypes = new HashMap<>();
/* 412 */     argPrintRequestTypes.forEach(printRequestType -> (PrintRequestType)this._reportPrintRequestTypes.put(printRequestType.getName(), printRequestType));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   public void setReportCatalog(List<IReportDefinition> argReportCatalog) {
/* 422 */     this._reportCatalog = new HashMap<>();
/* 423 */     argReportCatalog.forEach(reportDef -> (IReportDefinition)this._reportCatalog.put(reportDef.getName(), reportDef));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IReportQueryParam buildSqlInUsingEquals(String argFieldName, Object[] argValues) {
/* 433 */     StringBuilder sb = new StringBuilder();
/* 434 */     StringBuilder desc = new StringBuilder();
/* 435 */     sb.append("(");
/*     */     
/* 437 */     for (Object item : argValues) {
/* 438 */       sb.append(argFieldName);
/*     */       
/* 440 */       if (item == null) {
/* 441 */         sb.append(" is null and ");
/*     */       } else {
/*     */         
/* 444 */         sb.append(" = '");
/*     */         
/* 446 */         if (item instanceof ICodeInterface) {
/* 447 */           sb.append(((ICodeInterface)item).getCode());
/* 448 */           desc.append(((ICodeInterface)item).getDescription());
/*     */         } else {
/*     */           
/* 451 */           sb.append(item);
/* 452 */           desc.append(item);
/*     */         } 
/*     */         
/* 455 */         sb.append("' and ");
/* 456 */         desc.append(", ");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 461 */     sb.setLength(sb.length() - " and ".length());
/* 462 */     sb.append(")");
/*     */     
/* 464 */     desc.setLength(desc.length() - 2);
/* 465 */     return (IReportQueryParam)new ReportQueryParam(sb.toString(), desc.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IReportQueryParam buildSqlInUsingIn(String argFieldName, Object[] argValues) {
/* 476 */     StringBuilder sb = new StringBuilder();
/* 477 */     StringBuilder desc = new StringBuilder();
/* 478 */     sb.append(argFieldName);
/* 479 */     sb.append(" in (");
/*     */     
/* 481 */     for (Object item : argValues) {
/* 482 */       if (item == null) {
/* 483 */         sb.append("null, ");
/*     */       }
/* 485 */       sb.append("'");
/*     */       
/* 487 */       if (item instanceof ICodeInterface) {
/* 488 */         sb.append(((ICodeInterface)item).getCode());
/* 489 */         desc.append(((ICodeInterface)item).getDescription());
/*     */       } else {
/*     */         
/* 492 */         sb.append(item);
/* 493 */         desc.append(item);
/*     */       } 
/*     */       
/* 496 */       sb.append("', ");
/* 497 */       desc.append(", ");
/*     */     } 
/*     */ 
/*     */     
/* 501 */     sb.setLength(sb.length() - 2);
/* 502 */     desc.setLength(desc.length() - 2);
/* 503 */     sb.append(")");
/* 504 */     return (IReportQueryParam)new ReportQueryParam(sb.toString(), desc.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ReportRunConfigHelper getReportRunConfigHelper() {
/* 514 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSqlInSupported() {
/* 522 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void markAsDeletedAndAddToList(IReportLookup argLookup, List<IDataModel> argList) {
/* 531 */     ReportDataId dataId = new ReportDataId();
/* 532 */     ReportLookupId lookupId = (ReportLookupId)argLookup.getObjectId();
/*     */     
/* 534 */     dataId.setOrganizationId(lookupId.getOrganizationId());
/* 535 */     dataId.setOwnerId(lookupId.getOwnerId());
/* 536 */     dataId.setOwnerType(lookupId.getOwnerType());
/* 537 */     dataId.setReportId(lookupId.getReportId());
/*     */     
/* 539 */     argLookup.setDelete(true);
/* 540 */     argList.add(argLookup);
/*     */ 
/*     */     
/*     */     try {
/* 544 */       IReportData data = (IReportData)DataFactory.getObjectById((IObjectId)dataId);
/* 545 */       data.setDelete(true);
/* 546 */       argList.add(data);
/*     */     }
/* 548 */     catch (ObjectNotFoundException ex) {
/*     */       
/* 550 */       if (logger_.isDebugEnabled()) {
/* 551 */         logger_.debug("CAUGHT EXCEPTION", (Throwable)ex);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void runBackgroupReport(String argGroupName, ReportRunConfig argReportRun) {
/* 563 */     IReportRunRule[] rules = argReportRun.getRunRules();
/*     */     
/* 565 */     for (int i = 0; i < rules.length; i++) {
/* 566 */       if (!rules[i].isRuleMet(argReportRun)) {
/* 567 */         logger_.info("not running report group '" + argGroupName + " because of rule #" + i + ":" + rules[i]);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 572 */     URL reportUrl = argReportRun.getReport().getUrl();
/* 573 */     IReportFill fill = ReportFill.make(reportUrl);
/* 574 */     fill.setDescription(argGroupName + "::" + argReportRun.getName());
/* 575 */     fill.setIsBackground(true);
/*     */     
/* 577 */     RunFinishedReportListener listener = new RunFinishedReportListener(argReportRun, this);
/* 578 */     fill.addFillListener(listener);
/* 579 */     fillReport(fill);
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
/*     */   protected void saveReport(String argName, PDDocument argPrint, ReportOwnerType argOwnerType, String argOwner) throws UnsupportedOperationException {
/* 593 */     List<IDataModel> persistablesList = new ArrayList<>();
/* 594 */     IReportLookup lookup = makeLookup(argName, argOwnerType, argOwner, SavedReportType.PDF_PRINT);
/*     */     
/* 596 */     ReportStorage rs = convertReportForSave(argPrint);
/*     */ 
/*     */     
/* 599 */     ReportDataId dataId = new ReportDataId();
/* 600 */     dataId.setOrganizationId(Long.valueOf(lookup.getOrganizationId()));
/* 601 */     dataId.setOwnerId(lookup.getOwnerId());
/* 602 */     dataId.setOwnerType(lookup.getOwnerType());
/* 603 */     dataId.setReportId(lookup.getReportId());
/*     */ 
/*     */     
/* 606 */     URL dataSavedToUrl = Handler.make((IObjectId)dataId, "getReportData");
/*     */     
/* 608 */     lookup.setReportUrl(dataSavedToUrl.toExternalForm());
/*     */     
/* 610 */     IReportData data = (IReportData)DataFactory.createObject((IObjectId)dataId, IReportData.class);
/*     */     
/* 612 */     data.setReportData(rs);
/*     */     
/* 614 */     persistablesList.add(lookup);
/*     */     
/* 616 */     persistablesList.add(data);
/*     */ 
/*     */     
/*     */     try {
/* 620 */       DataFactory.makePersistent(persistablesList);
/*     */     }
/* 622 */     catch (PersistenceException ex) {
/* 623 */       logger_.error("Exception caught trying to persist report data objects.", (Throwable)ex);
/* 624 */       throw new OpExecutionException(ex);
/*     */     } 
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
/*     */   protected void saveReportCriteria(String argName, URL argUrl, ReportOwnerType argOwnerType, String argOwner) throws UnsupportedOperationException {
/* 639 */     String urlString = argUrl.toExternalForm();
/*     */     
/* 641 */     IReportLookup lookup = makeLookup(argName, argOwnerType, argOwner, SavedReportType.REPORT_CRITERIA);
/* 642 */     lookup.setReportUrl(urlString);
/*     */     
/*     */     try {
/* 645 */       DataFactory.makePersistent(lookup);
/*     */     }
/* 647 */     catch (PersistenceException ex) {
/* 648 */       logger_.error("Exception caught trying to persist report lookup criteria.", (Throwable)ex);
/* 649 */       throw new OpExecutionException(ex);
/*     */     } 
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
/*     */   protected void validateRunConfig(ReportRunConfig argRun) throws ReportingConfigException {
/*     */     try {
/* 663 */       argRun.getReport().getUrl().openConnection();
/*     */     }
/* 665 */     catch (Exception ex) {
/* 666 */       throw new ReportingConfigException(ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\ReportMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */