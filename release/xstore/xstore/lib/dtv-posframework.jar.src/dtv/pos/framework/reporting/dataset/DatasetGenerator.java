/*      */ package dtv.pos.framework.reporting.dataset;
/*      */ import com.micros.xstore.config.impl.LocatableObject;
/*      */ import com.micros.xstore.config.report.DataSourceType;
/*      */ import com.micros.xstore.config.report.DataTemplate;
/*      */ import com.micros.xstore.config.report.ElementType;
/*      */ import com.micros.xstore.config.report.GroupType;
/*      */ import com.micros.xstore.config.report.LabelType;
/*      */ import com.micros.xstore.config.report.ParameterType;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.DefaultQueryResult;
/*      */ import dtv.data2.access.IQueryResultList;
/*      */ import dtv.data2.access.QueryKey;
/*      */ import dtv.i18n.FormatterType;
/*      */ import dtv.i18n.OutputContextType;
/*      */ import dtv.i18n.formatter.DateTimeFormatter;
/*      */ import dtv.pos.common.ConfigurationMgr;
/*      */ import dtv.pos.framework.reporting.ReportException;
/*      */ import dtv.pos.framework.reporting.dataset.function.IAggregateFunction;
/*      */ import dtv.pos.framework.reporting.fill.AbsoluteDtvDateRange;
/*      */ import dtv.pos.framework.reporting.fill.CommonReportParameters;
/*      */ import dtv.pos.framework.reporting.fill.ReportParam;
/*      */ import dtv.pos.framework.reporting.type.ReportBarcodeType;
/*      */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*      */ import dtv.pos.iframework.form.IEnumValueWrapper;
/*      */ import dtv.pos.iframework.reporting.IReportDefinition;
/*      */ import dtv.pos.iframework.reporting.IReportHelper;
/*      */ import dtv.pos.iframework.reporting.IReportParam;
/*      */ import dtv.pos.iframework.type.IDtvDate;
/*      */ import dtv.pos.iframework.type.IDtvDateRange;
/*      */ import dtv.ui.IUIResourceManager;
/*      */ import dtv.util.CalendarField;
/*      */ import dtv.util.DateUtils;
/*      */ import dtv.util.DtvDate;
/*      */ import dtv.util.ICodeInterface;
/*      */ import dtv.util.ObjectUtils;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Base64;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.stream.Collectors;
/*      */ import org.apache.commons.lang3.StringEscapeUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.commons.lang3.math.NumberUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class DatasetGenerator implements IDatasetGenerator {
/*   57 */   private static final Logger _logger = Logger.getLogger(DatasetGenerator.class); private static final String ENCODING = "UTF-8";
/*      */   private static final String LIST_XML_PREFIX = "LIST_";
/*      */   private static final String LABEL = "LABEL";
/*      */   private static final String GET_PREFIX = "get";
/*      */   private static final Map<String, Class<?>> NON_PROMPTING_DEFAULT_VALUED_PARAMETER_CLASSES;
/*      */   @Inject
/*      */   private TransDateProvider _transDateProvider;
/*      */   private Map<String, String> _images;
/*      */   private Map<String, IAggregateFunction> _functions;
/*      */   
/*      */   static {
/*   68 */     Map<String, Class<?>> m = new HashMap<>();
/*   69 */     m.put(Boolean.class.getName(), Boolean.class);
/*   70 */     m.put(Byte.class.getName(), Byte.class);
/*   71 */     m.put(Double.class.getName(), Double.class);
/*   72 */     m.put(Float.class.getName(), Float.class);
/*   73 */     m.put(Integer.class.getName(), Integer.class);
/*   74 */     m.put(Long.class.getName(), Long.class);
/*   75 */     m.put(Short.class.getName(), Short.class);
/*   76 */     m.put(BigInteger.class.getName(), BigInteger.class);
/*   77 */     m.put(BigDecimal.class.getName(), BigDecimal.class);
/*      */     
/*   79 */     NON_PROMPTING_DEFAULT_VALUED_PARAMETER_CLASSES = Collections.unmodifiableMap(m);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   91 */   private IUIResourceManager UIRM = UIResourceManager.getInstance();
/*      */   private IReportHelper _reportHelper;
/*   93 */   private Boolean _labelReport = Boolean.FALSE;
/*   94 */   private int _labelColumnCount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] generate(IReportDefinition argReportDef, Map<String, Object> argParameters, Collection<?> argDataSource) throws ReportException {
/*  102 */     this._reportHelper = (IReportHelper)argParameters.get(CommonReportParameters.REPORT_HELPER.getName());
/*      */     
/*  104 */     if (argReportDef.getLabelUsage() != null) {
/*  105 */       this._labelReport = Boolean.TRUE;
/*  106 */       this._labelColumnCount = argReportDef.getLabelColumnCount();
/*      */     } 
/*      */ 
/*      */     
/*  110 */     DataTemplate dataTemplate = ReportUtils.unmarshalDataTemplate(argReportDef);
/*      */     
/*  112 */     if (dataTemplate.getParameters() != null) {
/*  113 */       List<ParameterType> parameters = dataTemplate.getParameters().getParameters();
/*  114 */       for (ParameterType parameter : parameters) {
/*  115 */         if ("excludeReturns".equalsIgnoreCase(parameter.getName())) {
/*  116 */           argParameters.put(parameter.getName(), Boolean.valueOf(ConfigurationMgr.getHelper()
/*  117 */                 .getBoolean(new String[] { "Store", "SystemConfig", "GrossSalesOptions", "ExcludeReturns" })));
/*      */         }
/*  119 */         else if (this._images.containsKey(parameter.getName())) {
/*      */           
/*  121 */           byte[] imageBytes = this.UIRM.getImageBytes(this._images.get(parameter.getName()));
/*  122 */           if (imageBytes != null) {
/*  123 */             argParameters.put(parameter.getName(), Base64.getEncoder().encodeToString(imageBytes));
/*      */           }
/*      */         } 
/*      */         
/*  127 */         if (parameter.getClazz().equals("java.util.Map")) {
/*      */           
/*  129 */           Map<String, Object> merchLevelMap = (Map<String, Object>)argParameters.get(parameter.getName());
/*  130 */           if (merchLevelMap != null) {
/*  131 */             String merchLevel = getMerchLevelForLayout(merchLevelMap, "merchLevel1Desc", "merchLevel1Id");
/*  132 */             if (merchLevel != null && merchLevel.length() > 0) {
/*  133 */               argParameters.put("merchLevel1ForLayout", merchLevel);
/*      */             }
/*  135 */             merchLevel = getMerchLevelForLayout(merchLevelMap, "merchLevel2Desc", "merchLevel2Id");
/*  136 */             if (merchLevel != null && merchLevel.length() > 0) {
/*  137 */               argParameters.put("merchLevel2ForLayout", merchLevel);
/*      */             }
/*  139 */             merchLevel = getMerchLevelForLayout(merchLevelMap, "merchLevel3Desc", "merchLevel3Id");
/*  140 */             if (merchLevel != null && merchLevel.length() > 0) {
/*  141 */               argParameters.put("merchLevel3ForLayout", merchLevel);
/*      */             }
/*  143 */             merchLevel = getMerchLevelForLayout(merchLevelMap, "merchLevel4Desc", "merchLevel4Id");
/*  144 */             if (merchLevel != null && merchLevel.length() > 0) {
/*  145 */               argParameters.put("merchLevel4ForLayout", merchLevel);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  152 */     List<ReportResult> results = new ArrayList<>();
/*      */     
/*  154 */     if (dataTemplate.getDataSource() != null) {
/*  155 */       processQuery(results, dataTemplate, argParameters);
/*  156 */       processDataSource(results, dataTemplate, argDataSource);
/*      */     } 
/*      */ 
/*      */     
/*  160 */     String datasetXml = render(dataTemplate, results, argParameters);
/*      */ 
/*      */     
/*  163 */     _logger.debug("\n" + XmlUtils.getBeautifiedXml(datasetXml) + "\n");
/*      */     
/*      */     try {
/*  166 */       return datasetXml.getBytes("UTF-8");
/*      */     }
/*  168 */     catch (UnsupportedEncodingException e) {
/*  169 */       throw new ReportException("Unable to Render Data Set XML", e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, IAggregateFunction> getFunctions() {
/*  179 */     return this._functions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> getImages() {
/*  187 */     return this._images;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFunctions(Map<String, IAggregateFunction> argFunctions) {
/*  195 */     this._functions = argFunctions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImages(Map<String, String> argImages) {
/*  203 */     this._images = argImages;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getMerchLevelForLayout(Map<String, Object> merchLevelMap, String desc, String id) {
/*  214 */     if (merchLevelMap.get(desc) != null && merchLevelMap.get(id) != null) {
/*  215 */       return (String)merchLevelMap.get(desc) + " - " + (String)merchLevelMap.get(id);
/*      */     }
/*  217 */     if (merchLevelMap.get(desc) == null && merchLevelMap.get(id) == null) {
/*  218 */       return null;
/*      */     }
/*      */     
/*  221 */     return (merchLevelMap.get(id) == null) ? (String)merchLevelMap.get(desc) : (String)merchLevelMap
/*  222 */       .get(id);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<HashMap<String, Object>> buildRows(DataSourceType.DataReference argDataRef, Collection<?> argDataSource) {
/*  233 */     List<HashMap<String, Object>> returnList = new ArrayList<>();
/*      */     
/*  235 */     Collection<?> source = argDataSource;
/*  236 */     if (argDataRef.getKey() != null) {
/*  237 */       Collection<Object> childSource = new ArrayList();
/*  238 */       String method = "get" + argDataRef.getKey();
/*  239 */       for (Object dataSource : argDataSource) {
/*  240 */         Object obj = ObjectUtils.invokeMethodChain(method, dataSource, null);
/*      */         
/*  242 */         Collection<?> objCol = (obj instanceof Collection) ? (Collection)obj : Collections.singletonList(obj);
/*  243 */         childSource.addAll(objCol);
/*      */       } 
/*  245 */       source = childSource;
/*      */     } 
/*      */     
/*  248 */     for (Object obj : source) {
/*  249 */       HashMap<String, Object> row = new HashMap<>();
/*  250 */       argDataRef.getResultFields().getResultFields().forEach(columnName -> row.put(columnName, ObjectUtils.invokeMethodChain("get" + columnName, obj, null)));
/*      */       
/*  252 */       returnList.add(row);
/*      */     } 
/*      */     
/*  255 */     return returnList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<HashMap<String, Object>> buildRows(DataSourceType.QueryReference argQueryRef, IQueryResultList<DefaultQueryResult> argResult) {
/*  266 */     List<HashMap<String, Object>> returnList = new ArrayList<>();
/*      */ 
/*      */     
/*  269 */     for (DefaultQueryResult queryResult : argResult) {
/*  270 */       HashMap<String, Object> row = new HashMap<>();
/*  271 */       argQueryRef.getResultFields().getResultFields()
/*  272 */         .forEach(columnName -> row.put(columnName, queryResult.get(columnName)));
/*  273 */       returnList.add(row);
/*      */     } 
/*  275 */     return returnList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String createEmptyElemTag(String argTagName) {
/*  284 */     return "<" + argTagName + "/>";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String createEndTag(String argTagName) {
/*  293 */     return "</" + argTagName + ">";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String createLabelTag(String argLabelName, String argLabelValue) {
/*  303 */     return "<LABEL name=\"" + argLabelName + "\">" + StringEscapeUtils.escapeXml11(argLabelValue) + 
/*  304 */       createEndTag("LABEL");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String createStartTag(String argTagName) {
/*  313 */     return "<" + argTagName + ">";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String createStartTag(String argTagName, String argName) {
/*  323 */     return "<" + argTagName + " name=\"" + argName + "\">";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getBarcode(String argText, String argBarcodeType) {
/*  333 */     return getBarcode(argText, argBarcodeType, 200, 50);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getBarcode(String argText, String argBarcodeType, int argWidth, int argHeigth) {
/*  345 */     if (argText == null) {
/*  346 */       return null;
/*      */     }
/*      */     
/*  349 */     ReportBarcodeType barcode = ReportBarcodeType.forName(argBarcodeType);
/*  350 */     if (barcode == null) {
/*  351 */       barcode = ReportBarcodeType.CODE93;
/*      */     }
/*      */     
/*  354 */     byte[] bytes = this._reportHelper.getBarcode(argText, barcode.getBarcodeType(), barcode.getBarcodeTextType(), argWidth, argHeigth);
/*      */ 
/*      */     
/*  357 */     return Base64.getEncoder().encodeToString(bytes);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Object getDefaultValue(ParameterType argParameter) throws ReportException {
/*  363 */     Object defaultValue = null;
/*      */     
/*  365 */     if (argParameter.getParameterDescription() != null && argParameter.getDefaultValueExpression() != null) {
/*      */ 
/*      */       
/*      */       try {
/*  369 */         IReportParam param = ReportParam.make(argParameter.getName(), Class.forName(argParameter.getClazz()), argParameter
/*  370 */             .getParameterDescription());
/*      */         
/*  372 */         if (param instanceof dtv.pos.iframework.reporting.ITextReportParam)
/*      */         {
/*  374 */           defaultValue = argParameter.getDefaultValueExpression();
/*      */         
/*      */         }
/*      */       }
/*  378 */       catch (Exception ex) {
/*  379 */         throw new ReportException("Unable to interpret default value", ex);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  384 */       defaultValue = argParameter.getDefaultValueExpression();
/*      */     } 
/*      */ 
/*      */     
/*  388 */     if (defaultValue != null && !argParameter.getIsForPrompting().booleanValue() && argParameter.getClazz() != null && 
/*  389 */       !"java.lang.String".equals(argParameter.getClazz()))
/*      */     {
/*      */ 
/*      */       
/*  393 */       if (NON_PROMPTING_DEFAULT_VALUED_PARAMETER_CLASSES.containsKey(argParameter.getClazz())) {
/*      */         
/*      */         try {
/*  396 */           Class<?> cl = Class.forName(argParameter.getClazz());
/*  397 */           Constructor<?> cons = cl.getConstructor(new Class[] { String.class });
/*  398 */           defaultValue = cons.newInstance(new Object[] { defaultValue });
/*      */         }
/*  400 */         catch (Exception ex) {
/*  401 */           throw new ReportException("Failed to transform default value from a java.lang.String to designated class. Parameter=" + argParameter
/*      */               
/*  403 */               .getName() + ", class=" + argParameter.getClazz() + ", defaultValue = " + defaultValue, ex);
/*      */         }
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  409 */         _logger.warn("Unsupported class type. DefaultValue will be handled as a String. Parameter=" + argParameter
/*  410 */             .getName() + ", class=" + argParameter.getClazz() + ", defaultValue = " + defaultValue);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  416 */     return defaultValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LinkedHashMap<GroupedRowKey, List<HashMap<String, Object>>> getGroupedRows(List<ElementType> argElementTypes, List<HashMap<String, Object>> argRows) {
/*  431 */     LinkedHashMap<GroupedRowKey, List<HashMap<String, Object>>> groupedRows = new LinkedHashMap<>();
/*      */ 
/*      */     
/*  434 */     for (HashMap<String, Object> row : argRows) {
/*  435 */       GroupedRowKey key = new GroupedRowKey(argElementTypes, row);
/*      */       
/*  437 */       if (!groupedRows.containsKey(key)) {
/*  438 */         groupedRows.put(key, new ArrayList<>());
/*      */       }
/*      */       
/*  441 */       ((List<HashMap<String, Object>>)groupedRows.get(key)).add(row);
/*      */     } 
/*  443 */     return groupedRows;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private HashMap<String, String> getParameterCodeDescriptions(ParameterType argParameter) {
/*  453 */     HashMap<String, String> codeDescMap = new HashMap<>();
/*  454 */     String description = argParameter.getParameterDescription();
/*  455 */     if (StringUtils.isNotEmpty(description)) {
/*      */       try {
/*  457 */         Class<?> valueClass = Class.forName(argParameter.getClazz());
/*  458 */         IReportParam p = ReportParam.make(argParameter.getName(), valueClass, description);
/*  459 */         if (p instanceof IListReportParam) {
/*  460 */           for (Object possibleValue : ((IListReportParam)p).getPossibleValues()) {
/*  461 */             if (possibleValue instanceof ICodeInterface) {
/*  462 */               ICodeInterface code = (ICodeInterface)possibleValue;
/*  463 */               codeDescMap.put(code.getCode(), code.getDescription()); continue;
/*      */             } 
/*  465 */             if (possibleValue instanceof IEnumValueWrapper) {
/*  466 */               IEnumValueWrapper enumValue = (IEnumValueWrapper)possibleValue;
/*  467 */               codeDescMap.put(enumValue.getActualValue().toString(), enumValue.toString());
/*      */             }
/*      */           
/*      */           } 
/*      */         }
/*  472 */       } catch (Exception ex) {
/*  473 */         _logger.error("CAUGHT EXCEPTION with parameter=[" + argParameter.getName() + "] and description=[" + argParameter
/*  474 */             .getParameterDescription() + "]", ex);
/*      */       } 
/*      */     }
/*      */     
/*  478 */     return codeDescMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, Object> getParametersForQuery(DataSourceType.QueryReference.Parameters argQueryParameterNames, Map<String, Object> argQueryParameters, List<ParameterType> argDataTemplateParameters) {
/*  492 */     Map<String, Object> queryParams = new HashMap<>((argQueryParameterNames.getParameters() != null) ? argQueryParameterNames.getParameters().size() : 0);
/*      */ 
/*      */     
/*  495 */     for (String parameterName : argQueryParameterNames.getParameters()) {
/*      */ 
/*      */       
/*  498 */       Object parameterValue = argQueryParameters.get(parameterName);
/*  499 */       if (parameterValue == null)
/*      */       {
/*  501 */         for (ParameterType parameterType : argDataTemplateParameters) {
/*  502 */           if (parameterName.equals(parameterType.getName())) {
/*  503 */             parameterValue = parameterType.getDefaultValueExpression();
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  509 */       if (parameterValue != null) {
/*  510 */         queryParams.put(parameterName, parameterValue);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  515 */     if (argQueryParameters.containsKey("dateRange") && argQueryParameters
/*  516 */       .get("dateRange") instanceof IDtvDateRange) {
/*  517 */       IDtvDateRange dateRange = (IDtvDateRange)argQueryParameters.get("dateRange");
/*  518 */       queryParams.put("argBusinessDateStart", new DtvDate(dateRange.getStartDate().getTime()));
/*  519 */       queryParams.put("argBusinessDateEnd", new DtvDate(dateRange.getEndDate(true).getTime()));
/*  520 */       queryParams.remove("dateRange");
/*      */     }
/*  522 */     else if (argQueryParameters.containsKey("dtvStartDate")) {
/*  523 */       if (argQueryParameters.get("dtvStartDate") instanceof IDtvDate)
/*      */       {
/*  525 */         IDtvDate dtvStartDate = (IDtvDate)argQueryParameters.get("dtvStartDate");
/*      */         
/*  527 */         for (ParameterType parmType : argDataTemplateParameters) {
/*  528 */           if ("dtvStartDateIso".equals(parmType.getName())) {
/*  529 */             DateTimeFormatter dateIsoFormatter = new DateTimeFormatter(FormatterType.DATE_ISO);
/*  530 */             String formattedDateIso = dateIsoFormatter.format(dtvStartDate.getDate(), OutputContextType.VIEW);
/*  531 */             parmType.setDefaultValueExpression(formattedDateIso);
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */         
/*  538 */         if (argQueryParameters.containsKey("priorBusinessDaysIncluded") && 
/*      */           
/*  540 */           NumberUtils.isNumber(((String)argQueryParameters.get("priorBusinessDaysIncluded")).trim())) {
/*      */ 
/*      */           
/*  543 */           Calendar cal = Calendar.getInstance();
/*  544 */           cal.setTime(dtvStartDate.getDate());
/*      */ 
/*      */           
/*  547 */           cal.add(5, 
/*  548 */               NumberUtils.toInt(((String)argQueryParameters.get("priorBusinessDaysIncluded")).trim()) * -1);
/*      */ 
/*      */           
/*  551 */           AbsoluteDtvDateRange absoluteDtvDateRange = new AbsoluteDtvDateRange(cal.getTime(), dtvStartDate.getDate());
/*  552 */           queryParams.put("argBusinessDateStart", new DtvDate(absoluteDtvDateRange.getStartDate().getTime()));
/*  553 */           queryParams.put("argBusinessDateEnd", new DtvDate(absoluteDtvDateRange.getEndDate(true).getTime()));
/*      */         }
/*  555 */         else if (argDataTemplateParameters.stream().filter(p -> p.getName().equals("agingRangeCriteria"))
/*  556 */           .count() == 1L) {
/*      */           
/*  558 */           queryParams.put("argBusinessDateEnd", new DtvDate(DateUtils.getEndOfDay(dtvStartDate.getDate())));
/*      */           
/*  560 */           int paymentPeriods = ConfigurationMgr.getLayawayPaymentPeriods();
/*  561 */           int periodLengthInDays = ConfigurationMgr.getLayawayPaymentPeriodDaysLength();
/*  562 */           int startDay = 0;
/*  563 */           int endDay = periodLengthInDays;
/*  564 */           for (int i = 1; i <= paymentPeriods; i++) {
/*  565 */             String agePeriod = startDay + " - " + endDay;
/*  566 */             String daysIncluded = (String)argQueryParameters.get("agingRangeCriteria");
/*  567 */             if (daysIncluded != null && daysIncluded.startsWith(agePeriod)) {
/*      */ 
/*      */ 
/*      */               
/*  571 */               Calendar calendarStartDate = Calendar.getInstance();
/*  572 */               calendarStartDate.setTime(dtvStartDate.getDate());
/*  573 */               calendarStartDate.add(5, -endDay);
/*      */ 
/*      */               
/*  576 */               Calendar calendarEndDate = Calendar.getInstance();
/*  577 */               calendarEndDate.setTime(DateUtils.getEndOfDay(calendarStartDate.getTime()));
/*  578 */               calendarEndDate.add(5, endDay - startDay);
/*      */ 
/*      */ 
/*      */               
/*  582 */               AbsoluteDtvDateRange absoluteDtvDateRange = new AbsoluteDtvDateRange(calendarStartDate.getTime(), calendarEndDate.getTime());
/*  583 */               queryParams.put("argBusinessDateStart", new DtvDate(absoluteDtvDateRange.getStartDate().getTime()));
/*  584 */               queryParams.put("argBusinessDateEnd", new DtvDate(absoluteDtvDateRange.getEndDate().getTime()));
/*      */               
/*      */               break;
/*      */             } 
/*  588 */             startDay = endDay + 1;
/*  589 */             endDay = startDay + periodLengthInDays - 1;
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/*  594 */           queryParams.put("argBusinessDateStart", new DtvDate(dtvStartDate.getDate().getTime()));
/*      */         } 
/*  596 */         queryParams.remove("dtvStartDate");
/*      */       }
/*      */     
/*  599 */     } else if (argQueryParameters.containsKey("agingCriteria")) {
/*  600 */       if (argQueryParameters.get("agingCriteria") instanceof String) {
/*  601 */         String agingCriteria = (String)argQueryParameters.get("agingCriteria");
/*      */ 
/*      */         
/*  604 */         String startStr = (agingCriteria == null) ? "0" : agingCriteria.substring(0, agingCriteria.indexOf("-")).trim();
/*      */         
/*  606 */         String endStr = (agingCriteria == null) ? "9999" : agingCriteria.substring(agingCriteria.indexOf("-") + 1).trim();
/*      */         
/*  608 */         Date startDate = DateUtils.dateAdd(CalendarField.DAY, Integer.parseInt(startStr) * -1, this._transDateProvider
/*  609 */             .getDate());
/*  610 */         Date endDate = DateUtils.dateAdd(CalendarField.DAY, Integer.parseInt(endStr) * -1, this._transDateProvider
/*  611 */             .getDate());
/*      */         
/*  613 */         queryParams.put("argBusinessDateStart", new DtvDate(endDate.getTime()));
/*  614 */         queryParams.put("argBusinessDateEnd", new DtvDate(startDate.getTime()));
/*  615 */         queryParams.remove("agingCriteria");
/*      */       }
/*      */     
/*  618 */     } else if (argQueryParameters.containsKey("storeNbr")) {
/*  619 */       String storeNbr = argQueryParameters.get("storeNbr").toString();
/*  620 */       if (storeNbr.isEmpty())
/*      */       {
/*      */         
/*  623 */         queryParams.put("storeNbr", CommonReportParameters.RETAIL_LOCATION_ID.getValue());
/*      */       }
/*      */     } 
/*      */     
/*  627 */     return queryParams;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ReportResult getResult(List<ReportResult> argResults, String argName) {
/*  637 */     for (ReportResult result : argResults) {
/*  638 */       if (argName.equals(result.getName())) {
/*  639 */         return result;
/*      */       }
/*      */     } 
/*      */     
/*  643 */     _logger.warn("No query named: " + argName);
/*  644 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean hasAggregateFunction(ElementType elementType) {
/*  653 */     return getFunctions().containsKey(elementType.getFunction());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isTotalsGroup(GroupType argGroup) {
/*  662 */     return argGroup.getElementsAndGroups().stream()
/*  663 */       .filter(eAg -> (eAg instanceof ElementType && hasAggregateFunction((ElementType)eAg))).findFirst()
/*  664 */       .isPresent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processDataSource(List<ReportResult> argResults, DataTemplate argTemplate, Collection<?> argDataSource) {
/*  675 */     if (argTemplate.getDataSource().getDataReferences() != null) {
/*  676 */       for (DataSourceType.DataReference dataRef : argTemplate.getDataSource().getDataReferences()) {
/*  677 */         ReportResult result = new ReportResult();
/*  678 */         result.setName(dataRef.getName());
/*  679 */         result.setRows(buildRows(dataRef, argDataSource));
/*  680 */         argResults.add(result);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processQuery(List<ReportResult> argResults, DataTemplate argTemplate, Map<String, Object> argParameters) {
/*  693 */     if (argTemplate.getDataSource().getQueryReferences() != null) {
/*  694 */       for (DataSourceType.QueryReference queryRef : argTemplate.getDataSource().getQueryReferences()) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  699 */         Map<String, Object> params = getParametersForQuery(queryRef.getParameters(), argParameters, argTemplate
/*  700 */             .getParameters().getParameters());
/*      */         
/*  702 */         QueryKey queryKey = new QueryKey(queryRef.getKey(), DefaultQueryResult.class);
/*  703 */         IQueryResultList<DefaultQueryResult> queryResult = DataFactory.getObjectByQueryNoThrow((IQueryKey)queryKey, params);
/*  704 */         ReportResult result = new ReportResult();
/*  705 */         result.setName(queryRef.getName());
/*  706 */         result.setRows(buildRows(queryRef, queryResult));
/*  707 */         argResults.add(result);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String render(DataTemplate argDataTemplate, List<ReportResult> argResults, Map<String, Object> argParameters) throws ReportException {
/*  724 */     StringBuilder xml = new StringBuilder();
/*  725 */     xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
/*  726 */     xml.append(createStartTag(argDataTemplate.getName()));
/*      */     
/*  728 */     if (argDataTemplate.getParameters() != null) {
/*  729 */       xml.append(renderParameters(argDataTemplate.getParameters().getParameters(), argParameters));
/*      */     }
/*      */     
/*  732 */     if (argDataTemplate.getLabels() != null) {
/*  733 */       xml.append(renderLabels(argDataTemplate.getLabels().getLabels()));
/*      */     }
/*      */     
/*  736 */     if (argDataTemplate.getDataStructure() != null) {
/*  737 */       xml.append(renderGroupList(argResults, argDataTemplate.getDataStructure().getGroups()));
/*      */     } else {
/*      */       
/*  740 */       xml.append(renderUndefined(argResults));
/*      */     } 
/*      */     
/*  743 */     xml.append(createEndTag(argDataTemplate.getName()));
/*  744 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderElement(HashMap<String, Object> argRow, ElementType argType) {
/*  754 */     StringBuilder xml = new StringBuilder();
/*      */     
/*  756 */     String value = this._reportHelper.format(argRow.get(argType.getValue()), argType.getFormatter());
/*      */     
/*  758 */     if (StringUtils.isNotEmpty(value)) {
/*  759 */       xml.append(createStartTag(argType.getName()));
/*      */       
/*  761 */       if (argType.getFormatter() == null) {
/*  762 */         value = translate(argType.getTranslationDefault().booleanValue(), argType.getTranslationPrefix(), value, new String[0]);
/*      */       }
/*      */       
/*  765 */       if (argType.getBarcode() != null) {
/*  766 */         int width = (argType.getWidth() != null) ? argType.getWidth().intValue() : 200;
/*  767 */         int heigth = (argType.getHeight() != null) ? argType.getHeight().intValue() : 50;
/*  768 */         value = getBarcode(value, argType.getBarcode().value(), width, heigth);
/*      */       } 
/*      */       
/*  771 */       xml.append(StringEscapeUtils.escapeXml11(value));
/*  772 */       xml.append(createEndTag(argType.getName()));
/*      */     } 
/*      */     
/*  775 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderElement(List<HashMap<String, Object>> argRows, ElementType argType) {
/*  785 */     StringBuilder xml = new StringBuilder();
/*      */     
/*  787 */     IAggregateFunction function = getFunctions().get(argType.getFunction());
/*  788 */     Object calculatedValue = function.calculate(argRows, argType.getValue());
/*  789 */     String value = this._reportHelper.format(calculatedValue, argType.getFormatter());
/*      */     
/*  791 */     if (StringUtils.isNotEmpty(value)) {
/*  792 */       xml.append(createStartTag(argType.getName()));
/*      */       
/*  794 */       if (argType.getFormatter() == null) {
/*  795 */         value = this._reportHelper.translate(StringUtils.isNotEmpty(argType.getTranslationPrefix()) ? (argType
/*  796 */             .getTranslationPrefix() + value) : value, new String[0]);
/*      */       }
/*      */       
/*  799 */       if (argType.getBarcode() != null) {
/*  800 */         value = getBarcode(value, argType.getBarcode().value());
/*      */       }
/*      */       
/*  803 */       xml.append(StringEscapeUtils.escapeXml11(value));
/*  804 */       xml.append(createEndTag(argType.getName()));
/*      */     } 
/*      */     
/*  807 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderGroupList(List<ReportResult> argResults, List<GroupType> argGroups) {
/*  817 */     StringBuilder xml = new StringBuilder();
/*      */     
/*  819 */     for (GroupType group : argGroups) {
/*  820 */       xml.append(createStartTag("LIST_" + group.getName()));
/*  821 */       xml.append(renderGroupNode(argResults, group));
/*  822 */       xml.append(createEndTag("LIST_" + group.getName()));
/*      */     } 
/*      */     
/*  825 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderGroupNode(List<ReportResult> argResults, GroupType group) {
/*  835 */     StringBuilder xml = new StringBuilder();
/*      */     
/*  837 */     if (group.getSource() != null) {
/*  838 */       ReportResult resultSet = getResult(argResults, group.getSource());
/*  839 */       List<HashMap<String, Object>> rows = resultSet.getRows();
/*      */ 
/*      */ 
/*      */       
/*  843 */       List<ElementType> elementTypes = (List<ElementType>)group.getElementsAndGroups().stream().filter(eAg -> eAg instanceof ElementType).map(e -> (ElementType)e).collect(Collectors.toList());
/*      */       
/*  845 */       if (rows == null || elementTypes == null || elementTypes.isEmpty()) {
/*  846 */         xml.append(createEmptyElemTag(group.getName()));
/*      */ 
/*      */       
/*      */       }
/*  850 */       else if (isTotalsGroup(group)) {
/*      */ 
/*      */         
/*  853 */         Map<GroupedRowKey, List<HashMap<String, Object>>> groupedRows = getGroupedRows(elementTypes, resultSet.getRows());
/*      */ 
/*      */         
/*  856 */         groupedRows.forEach((key, rowGroup) -> xml.append(renderTotalsGroup(group.getName(), elementTypes, rowGroup)));
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  861 */         int totalCount = 0;
/*  862 */         int rowCount = 0;
/*  863 */         for (HashMap<String, Object> row : rows) {
/*  864 */           xml.append(renderNonTotalsGroup(group.getName(), elementTypes, row));
/*  865 */           totalCount++;
/*  866 */           rowCount++;
/*  867 */           if (this._labelReport.booleanValue() && this._labelColumnCount > 1 && rowCount == this._labelColumnCount && totalCount < rows
/*  868 */             .size()) {
/*  869 */             xml.append(createEndTag("LIST_" + group.getName()));
/*  870 */             xml.append(createStartTag("LIST_" + group.getName()));
/*  871 */             rowCount = 0;
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       } 
/*      */     } else {
/*      */       
/*  879 */       xml.append(renderStructuralGroup(group, argResults));
/*      */     } 
/*      */     
/*  882 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderLabels(List<LabelType> argLabels) {
/*  891 */     StringBuilder xml = new StringBuilder();
/*  892 */     xml.append(createStartTag("LIST_LABEL"));
/*      */     
/*  894 */     for (LabelType label : argLabels) {
/*  895 */       List<String> labelParameters = new ArrayList<>();
/*  896 */       if (!label.getParameters().isEmpty())
/*      */       {
/*  898 */         label.getParameters().forEach(parameter -> labelParameters.add(this._reportHelper.translate(parameter.getParameter().getValue(), new String[0])));
/*      */       }
/*      */ 
/*      */       
/*  902 */       if (label.getTranslate().booleanValue()) {
/*  903 */         xml.append(createLabelTag(label.getName(), this._reportHelper.translate(label.getValue(), labelParameters
/*  904 */                 .<String>toArray(new String[labelParameters.size()]))));
/*      */         continue;
/*      */       } 
/*  907 */       xml.append(createLabelTag(label.getName(), label.getValue()));
/*      */     } 
/*      */ 
/*      */     
/*  911 */     xml.append(createEndTag("LIST_LABEL"));
/*  912 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object renderNonTotalsGroup(String argGroupName, List<ElementType> argElementTypes, HashMap<String, Object> argRow) {
/*  925 */     StringBuilder xml = new StringBuilder();
/*      */ 
/*      */     
/*  928 */     xml.append(createStartTag(argGroupName));
/*  929 */     argElementTypes.forEach(elementType -> xml.append(renderElement(argRow, elementType)));
/*  930 */     xml.append(createEndTag(argGroupName));
/*      */     
/*  932 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderParameters(List<ParameterType> argParameters, Map<String, Object> argParamMap) throws ReportException {
/*  944 */     StringBuilder xml = new StringBuilder();
/*      */     
/*  946 */     for (ParameterType parameter : argParameters) {
/*  947 */       if (parameter.getIncludeInOutput().equalsIgnoreCase("true")) {
/*  948 */         HashMap<String, String> codeDescMap = getParameterCodeDescriptions(parameter);
/*      */         
/*  950 */         Object parameterValue = argParamMap.getOrDefault(parameter.getName(), getDefaultValue(parameter));
/*  951 */         String parameterDesc = codeDescMap.get(parameterValue);
/*      */         
/*  953 */         FormatterType formatterType = FormatterType.forName(parameter.getFormatter());
/*  954 */         String pValue = this._reportHelper.format(parameterValue, formatterType);
/*      */         
/*  956 */         if (StringUtils.isNotEmpty(parameterDesc) && StringUtils.isNotEmpty(pValue)) {
/*  957 */           xml.append(createStartTag(parameter.getName(), pValue));
/*      */         } else {
/*      */           
/*  960 */           xml.append(createStartTag(parameter.getName()));
/*      */         } 
/*      */         
/*  963 */         if (StringUtils.isNotEmpty(parameterDesc)) {
/*  964 */           pValue = parameterDesc;
/*      */         } else {
/*      */           
/*  967 */           pValue = translate(parameter.getTranslationDefault().booleanValue(), parameter.getTranslationPrefix(), pValue, new String[0]);
/*      */         } 
/*      */         
/*  970 */         xml.append(StringEscapeUtils.escapeXml11(pValue));
/*  971 */         xml.append(createEndTag(parameter.getName()));
/*      */       } 
/*      */     } 
/*      */     
/*  975 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object renderStructuralGroup(GroupType argGroup, List<ReportResult> argResults) {
/*  987 */     StringBuilder xml = new StringBuilder();
/*  988 */     xml.append(createStartTag(argGroup.getName()));
/*      */ 
/*      */ 
/*      */     
/*  992 */     List<GroupType> groupTypes = (List<GroupType>)argGroup.getElementsAndGroups().stream().filter(eAg -> eAg instanceof GroupType).map(e -> (GroupType)e).collect(Collectors.toList());
/*      */ 
/*      */     
/*  995 */     xml.append(renderGroupList(argResults, groupTypes));
/*      */     
/*  997 */     xml.append(createEndTag(argGroup.getName()));
/*  998 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderTotalsGroup(String argGroupName, List<ElementType> argElementTypes, List<HashMap<String, Object>> argGroupedRows) {
/* 1010 */     StringBuilder xml = new StringBuilder();
/* 1011 */     xml.append(createStartTag(argGroupName));
/*      */ 
/*      */     
/* 1014 */     for (ElementType elementType : argElementTypes) {
/* 1015 */       if (hasAggregateFunction(elementType)) {
/*      */         
/* 1017 */         xml.append(renderElement(argGroupedRows, elementType));
/*      */         
/*      */         continue;
/*      */       } 
/* 1021 */       xml.append(renderElement(argGroupedRows.get(0), elementType));
/*      */     } 
/*      */ 
/*      */     
/* 1025 */     xml.append(createEndTag(argGroupName));
/* 1026 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String renderUndefined(List<ReportResult> argResults) {
/* 1035 */     StringBuilder xml = new StringBuilder();
/*      */ 
/*      */     
/* 1038 */     for (ReportResult result : argResults) {
/* 1039 */       xml.append(createStartTag("LIST_" + result.getName()));
/*      */       
/* 1041 */       List<HashMap<String, Object>> rows = result.getRows();
/* 1042 */       int totalCount = 0;
/* 1043 */       int rowCount = 0;
/* 1044 */       for (HashMap<String, Object> row : rows) {
/* 1045 */         totalCount++;
/* 1046 */         rowCount++;
/* 1047 */         xml.append(createStartTag(result.getName()));
/* 1048 */         for (String key : row.keySet()) {
/* 1049 */           xml.append(createStartTag(key.toString()));
/* 1050 */           xml.append(this._reportHelper.format(row.get(key)));
/* 1051 */           xml.append(createEndTag(key.toString()));
/*      */         } 
/* 1053 */         xml.append(createEndTag(result.getName()));
/* 1054 */         if (this._labelReport.booleanValue() && this._labelColumnCount > 1 && rowCount == this._labelColumnCount && totalCount < rows
/* 1055 */           .size()) {
/* 1056 */           xml.append(createEndTag("LIST_" + result.getName()));
/* 1057 */           xml.append(createStartTag("LIST_" + result.getName()));
/* 1058 */           rowCount = 0;
/*      */         } 
/*      */       } 
/* 1061 */       xml.append(createEndTag("LIST_" + result.getName()));
/*      */     } 
/*      */     
/* 1064 */     return xml.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String translate(boolean argUseDefault, String argPrefix, String argValue, String... args) {
/* 1077 */     String key = StringUtils.isEmpty(argPrefix) ? argValue : (argPrefix + argValue);
/*      */     
/* 1079 */     if (argUseDefault) {
/* 1080 */       return this._reportHelper.translateSafe(argValue, key, args);
/*      */     }
/*      */     
/* 1083 */     return this._reportHelper.translate(key, args);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class GroupedRowKey
/*      */   {
/* 1099 */     Map<String, Object> key = new HashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public GroupedRowKey(List<ElementType> argElementTypes, HashMap<String, Object> argRow) {
/* 1108 */       for (ElementType elementType : argElementTypes) {
/* 1109 */         if (elementType.getGroupBy().booleanValue()) {
/* 1110 */           this.key.put(elementType.getName(), argRow.get(elementType.getValue()));
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/* 1119 */       if (this == obj) {
/* 1120 */         return true;
/*      */       }
/* 1122 */       if (obj == null) {
/* 1123 */         return false;
/*      */       }
/* 1125 */       if (getClass() != obj.getClass()) {
/* 1126 */         return false;
/*      */       }
/*      */       
/* 1129 */       GroupedRowKey other = (GroupedRowKey)obj;
/* 1130 */       if (this.key == null) {
/* 1131 */         if (other.key != null) {
/* 1132 */           return false;
/*      */         }
/*      */       }
/* 1135 */       else if (this.key.size() != other.key.size()) {
/* 1136 */         return false;
/*      */       } 
/*      */ 
/*      */       
/* 1140 */       for (Map.Entry<String, Object> entry : this.key.entrySet()) {
/* 1141 */         if ((((entry.getValue() == null) ? 1 : 0) & ((other.key.get(entry.getKey()) != null) ? 1 : 0)) != 0) {
/* 1142 */           return false;
/*      */         }
/* 1144 */         if (!entry.getValue().equals(other.key.get(entry.getKey()))) {
/* 1145 */           return false;
/*      */         }
/*      */       } 
/*      */       
/* 1149 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1155 */       int prime = 31;
/* 1156 */       int result = 1;
/* 1157 */       result = 31 * result + toString().hashCode();
/* 1158 */       return result;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1164 */       StringBuilder builder = new StringBuilder();
/* 1165 */       builder.append("GroupedRowKey [");
/* 1166 */       builder.append(this.key.entrySet().stream().map(k -> (String)k.getKey() + "=" + k.getValue())
/* 1167 */           .collect(Collectors.joining(", ")));
/* 1168 */       builder.append("]");
/* 1169 */       return builder.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\dataset\DatasetGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */