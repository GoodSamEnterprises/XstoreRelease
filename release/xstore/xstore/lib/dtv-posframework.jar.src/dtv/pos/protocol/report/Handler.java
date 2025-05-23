/*    */ package dtv.pos.protocol.report;
/*    */ 
/*    */ import dtv.pos.framework.reporting.fill.CommonReportParameters;
/*    */ import dtv.pos.iframework.type.IDtvDate;
/*    */ import dtv.pos.iframework.type.IDtvDateRange;
/*    */ import java.io.IOException;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import java.net.URLEncoder;
/*    */ import java.net.URLStreamHandler;
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.DecimalFormatSymbols;
/*    */ import java.util.Iterator;
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */   extends URLStreamHandler
/*    */ {
/* 29 */   private static final Logger logger_ = Logger.getLogger(Handler.class);
/*    */   
/*    */   public static final String PROTOCOL = "report";
/*    */   
/* 33 */   private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
/*    */ 
/*    */   
/*    */   public static DecimalFormat getDecimalFormat() {
/* 37 */     return DECIMAL_FORMAT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static URL make(String argReportId, Map argParameters) throws MalformedURLException {
/* 44 */     StringBuffer paramString = new StringBuffer();
/* 45 */     paramString.append("?");
/* 46 */     Set keys = argParameters.keySet();
/* 47 */     for (Iterator<E> iter = keys.iterator(); iter.hasNext(); ) {
/* 48 */       String paramName = iter.next().toString();
/* 49 */       if (!CommonReportParameters.containsName(paramName)) {
/* 50 */         Object v = argParameters.get(paramName);
/*    */         
/* 52 */         paramString.append(paramName);
/* 53 */         paramString.append("=");
/* 54 */         paramString.append(toExternalForm(v));
/* 55 */         paramString.append("&");
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     String spec = "report://" + argReportId;
/*    */     
/* 61 */     paramString.setLength(paramString.length() - 1);
/* 62 */     return new URL(spec + paramString.toString());
/*    */   }
/*    */   
/*    */   private static String toExternalForm(Object o) {
/*    */     String unencoded;
/* 67 */     if (o instanceof IDtvDate) {
/* 68 */       unencoded = ((IDtvDate)o).toExternalForm();
/*    */     }
/* 70 */     else if (o instanceof IDtvDateRange) {
/* 71 */       unencoded = ((IDtvDateRange)o).toExternalForm();
/*    */     }
/* 73 */     else if (o instanceof Number) {
/* 74 */       unencoded = getDecimalFormat().format(o);
/*    */     }
/*    */     else {
/*    */       
/* 78 */       unencoded = o.toString();
/*    */     } 
/*    */     try {
/* 81 */       return URLEncoder.encode(unencoded, "UTF-8");
/*    */     }
/* 83 */     catch (UnsupportedEncodingException ex) {
/* 84 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 85 */       return unencoded;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected URLConnection openConnection(URL u) throws IOException {
/* 92 */     return (URLConnection)new ReportURLConnection(u);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\report\Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */