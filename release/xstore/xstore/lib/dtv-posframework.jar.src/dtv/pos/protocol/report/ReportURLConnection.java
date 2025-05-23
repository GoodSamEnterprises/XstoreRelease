/*     */ package dtv.pos.protocol.report;
/*     */ 
/*     */ import com.micros.xstore.config.report.DataTemplate;
/*     */ import com.micros.xstore.config.report.ParameterType;
/*     */ import dtv.pos.framework.reporting.ReportException;
/*     */ import dtv.pos.framework.reporting.ReportUtils;
/*     */ import dtv.pos.framework.reporting.fill.DtvDateParser;
/*     */ import dtv.pos.framework.reporting.fill.ReportFill;
/*     */ import dtv.pos.framework.reporting.type.ReportOutputFormat;
/*     */ import dtv.pos.iframework.reporting.IReportDefinition;
/*     */ import dtv.pos.iframework.reporting.IReportFill;
/*     */ import dtv.pos.iframework.reporting.IReportMgr;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.iframework.type.IDtvDate;
/*     */ import dtv.pos.iframework.type.IDtvDateRange;
/*     */ import dtv.pos.protocol.DtvURLConnection;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.OutputToInputStream;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Serializable;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import javax.print.attribute.AttributeSet;
/*     */ import javax.print.attribute.PrintRequestAttributeSet;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReportURLConnection
/*     */   extends DtvURLConnection
/*     */ {
/*  43 */   private static final Logger logger_ = Logger.getLogger(ReportURLConnection.class);
/*     */   
/*     */   private final IReportDefinition reportDef_;
/*     */   
/*     */   private final String parameters_;
/*     */   
/*     */   private Object content_;
/*     */   
/*     */   private boolean loaded_ = false;
/*     */   
/*     */   private IReportFill fill_;
/*     */   
/*     */   @Inject
/*     */   private IReportMgr _reportMgr;
/*     */   
/*     */   @Inject
/*     */   private StationState _stationState;
/*     */ 
/*     */   
/*     */   public ReportURLConnection(URL argUrl) throws IOException {
/*  63 */     super(argUrl);
/*     */     
/*  65 */     this.reportDef_ = this._reportMgr.getReportDefinition(argUrl.getAuthority());
/*  66 */     if (this.reportDef_ == null) {
/*  67 */       throw new FileNotFoundException("unknown report " + argUrl
/*  68 */           .getAuthority() + " in " + argUrl.toExternalForm());
/*     */     }
/*  70 */     this.parameters_ = argUrl.getQuery();
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelGetContents() {
/*  75 */     IReportFill f = this.fill_;
/*  76 */     if (f != null) {
/*  77 */       f.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() throws IOException {
/*  85 */     this.connected = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Object getContent() throws IOException {
/*  92 */     if (!this.loaded_) {
/*  93 */       this.content_ = doGetContent();
/*  94 */       this.loaded_ = true;
/*     */     } 
/*     */     
/*  97 */     return this.content_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() throws IOException {
/*     */     try {
/* 105 */       Serializable o = (Serializable)getContent();
/* 106 */       return (InputStream)OutputToInputStream.makeForSerializable(o);
/*     */     }
/* 108 */     catch (IOException ex) {
/* 109 */       throw ex;
/*     */     }
/* 111 */     catch (Throwable ex) {
/* 112 */       IOException ioex = new IOException();
/* 113 */       ioex.initCause(ex);
/* 114 */       throw ioex;
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
/*     */   public void processAdditionalParameters(IReportDefinition argReport, Map<String, Object> argParameterMap, String argParameters) {
/* 126 */     if (StringUtils.isEmpty(argParameters)) {
/*     */       return;
/*     */     }
/*     */     
/* 130 */     DataTemplate dataTemplate = null;
/*     */     try {
/* 132 */       dataTemplate = ReportUtils.unmarshalDataTemplate(argReport);
/*     */     }
/* 134 */     catch (ReportException ex) {
/* 135 */       logger_.error("Could not unmarshal report data template", (Throwable)ex);
/*     */       
/*     */       return;
/*     */     } 
/* 139 */     String strParameters = argParameters;
/*     */     
/* 141 */     int paramStart = strParameters.indexOf("?");
/* 142 */     strParameters = strParameters.substring(paramStart + 1);
/*     */     
/* 144 */     String[] paramValuePairs = strParameters.split("&");
/* 145 */     for (int i = 0; i < paramValuePairs.length; i++) {
/* 146 */       String pv = paramValuePairs[i];
/* 147 */       int divider = pv.indexOf("=");
/* 148 */       if (divider == -1) {
/* 149 */         logger_.warn("problem parsing parameter #" + i + " in \"" + strParameters + "\"");
/*     */       } else {
/*     */         Object value;
/* 152 */         String key = pv.substring(0, divider);
/* 153 */         String valueString = pv.substring(divider + 1);
/*     */         try {
/* 155 */           valueString = URLDecoder.decode(valueString, "UTF-8");
/*     */         }
/* 157 */         catch (UnsupportedEncodingException ex) {
/* 158 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */         
/* 161 */         if (valueString.startsWith("${") && valueString.endsWith("}")) {
/* 162 */           value = getDynamicParameter(valueString.substring(2, valueString.length() - 2));
/*     */         } else {
/*     */           
/* 165 */           value = getParameterValue(dataTemplate, key, valueString);
/*     */         } 
/*     */         
/* 168 */         if (value != null) {
/* 169 */           argParameterMap.put(key, value);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Object doGetContent() throws IOException {
/*     */     try {
/* 178 */       Map<String, Object> reportParameterMap = new HashMap<>();
/*     */ 
/*     */       
/* 181 */       processAdditionalParameters(this.reportDef_, reportParameterMap, this.parameters_);
/*     */       
/* 183 */       AttributeSet printer = this._reportMgr.getPrinterServiceAttributes(this.reportDef_.getPrinter());
/* 184 */       PrintRequestAttributeSet req = this._reportMgr.getPrintRequestAttributes(this.reportDef_.getPrinterRequestType());
/*     */ 
/*     */       
/* 187 */       IReportFill fill = ReportFill.make(this.reportDef_, reportParameterMap, ReportOutputFormat.PDF, printer, req, null);
/* 188 */       fill.run();
/* 189 */       return fill.getResults();
/*     */     }
/* 191 */     catch (Throwable t) {
/* 192 */       IOException ioex = new IOException();
/* 193 */       ioex.initCause(t);
/* 194 */       throw ioex;
/*     */     } finally {
/*     */       
/* 197 */       this.fill_ = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Object getDynamicParameter(String argParamName) {
/* 202 */     if ("WorkstationId".equalsIgnoreCase(argParamName)) {
/* 203 */       return Integer.valueOf(this._stationState.getWorkstationId());
/*     */     }
/* 205 */     if ("RetailLocationId".equalsIgnoreCase(argParamName)) {
/* 206 */       return Integer.valueOf(this._stationState.getRetailLocationId());
/*     */     }
/*     */     
/* 209 */     logger_.warn("unsupported parameter ${" + argParamName + "}");
/* 210 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object getParameterValue(DataTemplate argTemplate, String argParameterName, String argValueString) {
/* 216 */     List<ParameterType> paramList = new ArrayList<>();
/* 217 */     paramList = argTemplate.getParameters().getParameters();
/*     */     
/* 219 */     for (ParameterType p : paramList) {
/* 220 */       String paramName = p.getName();
/* 221 */       if (paramName.equals(argParameterName)) {
/* 222 */         Class<?> dataType = null;
/*     */         try {
/* 224 */           dataType = Class.forName(p.getClazz());
/*     */         }
/* 226 */         catch (ClassNotFoundException ex) {
/* 227 */           logger_.warn("No class called " + p.getClazz(), ex);
/* 228 */           return null;
/*     */         } 
/* 230 */         if (dataType.getName().equals(String.class.getName())) {
/* 231 */           return argValueString;
/*     */         }
/* 233 */         if (dataType.getName().equals(BigDecimal.class.getName())) {
/* 234 */           return NumberUtils.toBigDecimal(argValueString, Handler.getDecimalFormat());
/*     */         }
/* 236 */         if (dataType.getName().equals(IDtvDate.class.getName())) {
/* 237 */           return DtvDateParser.parseDate(argValueString);
/*     */         }
/* 239 */         if (dataType.getName().equals(IDtvDateRange.class.getName())) {
/* 240 */           return DtvDateParser.parseDateRange(argValueString);
/*     */         }
/*     */ 
/*     */         
/*     */         try {
/* 245 */           Method method = dataType.getMethod("valueOf", new Class[] { String.class });
/* 246 */           return method.invoke(null, new Object[] { argValueString });
/*     */         }
/* 248 */         catch (Exception ex) {
/* 249 */           logger_.error("CAUGHT EXCEPTION", ex);
/* 250 */           return null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 255 */     logger_.warn("no parameter named '" + argParameterName + "'");
/* 256 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\report\ReportURLConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */