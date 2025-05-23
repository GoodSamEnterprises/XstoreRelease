/*     */ package dtv.data2.access.impl.remote.servlet;
/*     */ 
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.util.Base64;
/*     */ import dtv.util.ByteArray;
/*     */ import dtv.util.zip.GZipUtils;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServletTester
/*     */ {
/*  27 */   private static final Logger _logger = Logger.getLogger(ServletTester.class);
/*     */   
/*     */   private static final String ENCODING_TYPE_UTF8 = "UTF8";
/*     */   
/*     */   private static final String ENCODING_GZIP = "encoded/gzip";
/*     */   
/*     */   private static final String ENCODING_PLAIN_TEXT = "text/plain";
/*     */   
/*     */   private static final String CONTENT_TYPE_KEY = "Content-Type";
/*     */   private static final String CONTENT_ENCODING = "Content-Encoding";
/*  37 */   private static int _msgCount = 0; private static final String HTTP_HEADER_PROP_ACCEPT = "Accept"; private static final String HTTP_HEADER_PROP_USER_AGENT = "User-Agent"; private static String _server; private static String _user; private static String _password;
/*     */   
/*     */   public static void main(String[] args) {
/*  40 */     if (args.length != 4) {
/*  41 */       _logger.error("Invalid arguments.  Try: ServletTester <server> <user> <password>");
/*  42 */       System.exit(-1);
/*     */     } 
/*  44 */     _server = args[0];
/*  45 */     _user = args[1];
/*  46 */     _password = args[2];
/*     */     
/*  48 */     String query = "<QueryRequest><QueryKey>SECURITY_GROUPS</QueryKey><Params><Param name=\"argOrganizationId\" type=\"LONG\">1</Param></Params></QueryRequest>";
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  53 */       long start = System.currentTimeMillis();
/*  54 */       byte[] requestBytes = stringToBytes(query);
/*     */       
/*  56 */       boolean valid = (new ServletTester()).sendHttpRequest(requestBytes);
/*  57 */       long end = System.currentTimeMillis();
/*  58 */       _logger.debug("getObjectByQuery result: " + valid + " and time " + (end - start));
/*  59 */       if (valid) {
/*  60 */         _logger.info("SUCCESS");
/*  61 */         System.exit(0);
/*     */       }
/*     */     
/*  64 */     } catch (Exception ex) {
/*  65 */       _logger.error("Caught exception running servlet tester", ex);
/*     */     } 
/*     */     
/*  68 */     _logger.error("ERROR");
/*  69 */     System.exit(-1);
/*     */   }
/*     */   
/*     */   public static byte[] stringToBytes(String argString) {
/*     */     try {
/*  74 */       return argString.getBytes("UTF8");
/*     */     }
/*  76 */     catch (Exception ee) {
/*  77 */       _logger.error("Unexpected error while encoding string: " + argString, ee);
/*  78 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String bytesToString(byte[] argBytes) {
/*     */     try {
/*  84 */       return new String(argBytes, "UTF8");
/*     */     }
/*  86 */     catch (Exception ee) {
/*  87 */       _logger.error("Unexpected error while converting bytes to string", ee);
/*  88 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAuthentication(HttpURLConnection conn, String argUserName, String argPwd) {
/*  97 */     if (argUserName != null && !argUserName.trim().equals("")) {
/*  98 */       String s = argUserName + ":" + argPwd;
/*  99 */       s = Base64.byteArrayToBase64(s.getBytes());
/* 100 */       conn.setRequestProperty("Authorization", "Basic " + s);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String formatHeader(Map<String, List<String>> argHeader) {
/* 105 */     StringBuilder buff = new StringBuilder(512);
/* 106 */     for (String key : argHeader.keySet()) {
/* 107 */       for (String value : argHeader.get(key)) {
/* 108 */         buff.append(key).append("=").append(value).append("\n");
/*     */       }
/*     */     } 
/* 111 */     return buff.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean resendRequestAsObject() {
/*     */     try {
/* 119 */       Map<String, Object> parms = new HashMap<>();
/* 120 */       parms.put("argOrganizationId", Long.valueOf(1L));
/* 121 */       QueryRequest query = new QueryRequest("SECURITY_GROUPS", parms);
/*     */       
/* 123 */       ByteArrayOutputStream bos = new ByteArrayOutputStream();
/* 124 */       ObjectOutputStream oos = new ObjectOutputStream(bos);
/* 125 */       oos.writeObject(query);
/* 126 */       return sendHttpRequest(GZipUtils.zip(bos.toByteArray()));
/*     */     }
/* 128 */     catch (Throwable ex) {
/* 129 */       _logger.error("Exception during run ", ex);
/*     */       
/* 131 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean sendHttpRequest(byte[] argRequest) throws Exception {
/* 137 */     int readTimeout = 30000;
/*     */     
/* 139 */     HttpURLConnection conn = null;
/* 140 */     OutputStream out = null;
/*     */     
/* 142 */     _msgCount++;
/* 143 */     if (_msgCount > 3) {
/* 144 */       _logger.warn("Too many messages have been sent");
/* 145 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 151 */       URL url = new URL(_server);
/*     */       
/* 153 */       conn = (HttpURLConnection)url.openConnection();
/* 154 */       conn.setFixedLengthStreamingMode(argRequest.length);
/* 155 */       conn.setDoOutput(true);
/* 156 */       conn.setDoInput(true);
/* 157 */       addAuthentication(conn, _user, _password);
/*     */       
/* 159 */       conn.setRequestProperty("Accept", "*/*");
/* 160 */       conn.setRequestProperty("User-Agent", "1::0::0::XCENTER_STATUS_CHECKER");
/* 161 */       conn.setRequestProperty("Content-Type", "text/plain");
/* 162 */       conn.setRequestProperty("Content-Encoding", "UTF8");
/* 163 */       conn.setReadTimeout(readTimeout);
/* 164 */       Map<String, List<String>> requestProps = conn.getRequestProperties();
/*     */       
/* 166 */       out = conn.getOutputStream();
/*     */       
/* 168 */       out.write(argRequest);
/* 169 */       out.flush();
/*     */       
/* 171 */       if (_logger.isDebugEnabled()) {
/* 172 */         String content = "";
/* 173 */         if (argRequest.length > 0) {
/* 174 */           content = new String(argRequest);
/*     */         }
/*     */         
/* 177 */         _logger.debug("HTTP Request URL: " + url + "\nHeader:\n" + formatHeader(requestProps) + content);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 182 */       return validateServletResponse(conn);
/*     */     } finally {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 189 */         if (out != null) {
/* 190 */           out.close();
/* 191 */           out = null;
/*     */         }
/*     */       
/* 194 */       } catch (Exception ee) {
/* 195 */         if (_logger.isDebugEnabled()) {
/* 196 */           _logger.debug("Encountered an exception while closing our writer.", ee);
/*     */         }
/*     */       } 
/*     */       try {
/* 200 */         if (conn != null) {
/* 201 */           conn.disconnect();
/* 202 */           conn = null;
/*     */         }
/*     */       
/* 205 */       } catch (Exception ee) {
/* 206 */         _logger.debug("Encountered an exception while closing our HttpURLConnection.", ee);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean validateServletResponse(HttpURLConnection argConnection) throws Exception {
/* 214 */     InputStream in = null;
/*     */     
/*     */     try {
/* 217 */       in = argConnection.getInputStream();
/*     */       
/* 219 */       ByteArray response = null;
/*     */       
/* 221 */       int contentLength = argConnection.getContentLength();
/* 222 */       boolean contentLengthApplicable = (contentLength != -1);
/*     */       
/* 224 */       if (contentLengthApplicable) {
/* 225 */         response = new ByteArray(contentLength);
/*     */       } else {
/*     */         
/* 228 */         response = new ByteArray(2048);
/*     */       } 
/*     */ 
/*     */       
/*     */       int read;
/*     */       
/* 234 */       while ((read = in.read()) != -1) {
/* 235 */         response.append((byte)read);
/*     */       }
/*     */       
/* 238 */       if (contentLengthApplicable && response.length() < contentLength) {
/* 239 */         _logger.warn("We only read " + response.length() + " bytes,  but the content length was reported as: " + contentLength + "bytes. *BYTES MAY HAVE BEEN DROPPED!*");
/*     */       }
/*     */ 
/*     */       
/* 243 */       byte[] data = response.toArray();
/*     */       
/* 245 */       String encoding = argConnection.getContentEncoding();
/* 246 */       if ("encoded/gzip".equals(encoding))
/*     */       {
/* 248 */         return true;
/*     */       }
/* 250 */       if ("UTF8".equals(encoding) || encoding == null) {
/* 251 */         String result = bytesToString(data);
/* 252 */         if (result.contains("ObjectNotFoundException")) {
/* 253 */           result = result.toLowerCase();
/* 254 */           if (result.contains("no available datasources") || result.contains("lookup failed")) {
/* 255 */             return false;
/*     */           }
/*     */           
/* 258 */           return true;
/*     */         } 
/*     */ 
/*     */         
/* 262 */         if (result.contains("Could not deserialize or unzip request")) {
/* 263 */           return resendRequestAsObject();
/*     */         }
/*     */         
/* 266 */         _logger.info("failure response is " + result);
/* 267 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 271 */       _logger.warn("Unrecognized content encoding type from servlet: " + encoding + " response bytes as string: " + 
/* 272 */           bytesToString(data));
/* 273 */       return false;
/*     */     
/*     */     }
/* 276 */     catch (Exception ex) {
/* 277 */       _logger.warn("handling failure exception ", ex);
/* 278 */       return false;
/*     */     } finally {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 285 */         if (in != null) {
/* 286 */           in.close();
/*     */         }
/*     */       }
/* 289 */       catch (Exception ee) {
/* 290 */         if (_logger.isDebugEnabled())
/* 291 */           _logger.debug("Encountered an exception while closing our reader.", ee); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\remote\servlet\ServletTester.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */