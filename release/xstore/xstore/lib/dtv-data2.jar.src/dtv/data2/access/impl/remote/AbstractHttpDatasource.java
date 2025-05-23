/*     */ package dtv.data2.access.impl.remote;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.impl.AbstractPersistenceStrategy;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.transaction.ITransactionalDataSource;
/*     */ import dtv.data2.security.DtvSecurityManager;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.util.Base64;
/*     */ import dtv.util.ByteArray;
/*     */ import dtv.util.EncodingHelper;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.crypto.DtvDecrypter;
/*     */ import dtv.util.crypto.DtvKeyStoreException;
/*     */ import dtv.util.crypto.IDtvDecrypter;
/*     */ import dtv.util.net.DtvHostnameVerifier;
/*     */ import dtv.util.net.SslUtils;
/*     */ import dtv.util.zip.GZipUtils;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.inject.Inject;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.HttpsURLConnection;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.Priority;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractHttpDatasource
/*     */   extends AbstractPersistenceStrategy
/*     */   implements ITransactionalDataSource
/*     */ {
/*     */   public static final String HTTP_HEADER_PROP_USER_AGENT = "User-Agent";
/*     */   public static final String GET_OBJECT_BY_ID_URN = "dtx:getObjectById";
/*     */   public static final String GET_OBJECT_BY_QUERY_URN = "dtx:getObjectByQuery";
/*     */   public static final String PROP_URL = "ConnectionURL";
/*     */   public static final String PROP_USER_NAME = "ConnectionUserName";
/*     */   public static final String PROP_PASSWORD = "ConnectionPassword";
/*     */   public static final String PROP_SOAP_ACTION = "SoapAction";
/*     */   public static final String PROP_TIMEOUT = "Timeout";
/*     */   public static final String PROP_KEYSTORE = "keystore";
/*     */   public static final String PROP_KEYSTORE_PASSWORD = "keystorePassword";
/*     */   public static final String PROP_KEY_ALIAS = "keyalias";
/*     */   public static final String PROP_TRUSTSTORE = "truststore";
/*     */   public static final String PROP_TRUSTSTORE_PASSWORD = "truststorePassword";
/*     */   public static final String RESPONSE_OBJECT_NOT_FOUND = "ObjectNotFoundException";
/*     */   public static final String PERSIST_SUCCESS = "DTX_PERSISTENCE_WAS_SUCCESSFUL";
/*     */   public static final String PERSIST_FAILURE = "FAILURE";
/*     */   public static final String TIMOUT_ELEMENT = "Timeout";
/*     */   public static final String TIMOUT_ATTRIBUTE = "t";
/*     */   public static final String TIMOUT_BEGIN = "<Timeout t=\"";
/*     */   public static final String TIMOUT_END = "\"/>";
/*     */   static final String PROP_PREFIX_URLPATH = "UrlPath:";
/*     */   static final String PROP_PREFIX_SOAP_ACTION = "SoapAction:";
/*  84 */   private static final Logger logger_ = Logger.getLogger(AbstractHttpDatasource.class);
/*     */   
/*     */   private static final String HTTP_HEADER_PROP_ACCEPT = "Accept";
/*     */   
/*     */   protected String hostUrl_;
/*     */   protected String userName_;
/*     */   protected String password_;
/*     */   protected String soapAction_;
/*  92 */   protected int timeout_ = -1;
/*     */   
/*     */   private String keystore_;
/*     */   
/*     */   private String keystorePassword_;
/*     */   
/*     */   private String keyAlias_;
/*     */   
/*     */   private String truststore_;
/*     */   
/*     */   private String truststorePassword_;
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   @Inject
/*     */   private EventManager _eventManager;
/*     */   
/*     */   public Object getObjectByRelationship(IDataModelRelationship argRel, QueryToken argQueryToken) {
/* 109 */     IObjectId id = getChildObjectIdForRelationship(argRel);
/* 110 */     if (id == null || !id.validate())
/*     */     {
/* 112 */       return null;
/*     */     }
/* 114 */     return getObjectById(id, argQueryToken);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeout() {
/* 122 */     return this.timeout_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphProvided() {
/* 128 */     return true;
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
/*     */ 
/*     */   
/*     */   public Object sendHttpRequest(String argRequest, String argContentType, String argEncodingType, String argPath, Map<String, String> argProperties) throws Exception {
/*     */     byte[] requestBytes;
/* 147 */     if (HttpContentType.BINARY.matches(argContentType)) {
/* 148 */       if (HttpEncodingType.GZIP.matches(argEncodingType)) {
/* 149 */         requestBytes = GZipUtils.zip(EncodingHelper.serialize(argRequest));
/*     */       } else {
/*     */         
/* 152 */         throw new DtxException("Unknown encoding type for binary: " + argEncodingType + " Cannot send http request with object " + argRequest);
/*     */       }
/*     */     
/*     */     }
/* 156 */     else if (HttpContentType.TEXT.matches(argContentType)) {
/* 157 */       if (HttpEncodingType.UTF8.matches(argEncodingType)) {
/* 158 */         requestBytes = StringUtils.getBytes(argRequest);
/*     */       }
/* 160 */       else if (HttpEncodingType.BASE64.matches(argEncodingType)) {
/* 161 */         requestBytes = StringUtils.getBytes(EncodingHelper.encode(argRequest, false));
/*     */       } else {
/*     */         
/* 164 */         throw new DtxException("Unknown encoding type for text: " + argEncodingType + " Cannot send http request with object " + argRequest);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 169 */       throw new DtxException("Unknown content type : " + argContentType + " Cannot send http request with object " + argRequest);
/*     */     } 
/*     */ 
/*     */     
/* 173 */     HttpURLConnection conn = null;
/* 174 */     OutputStream out = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 181 */       URL url = new URL(this.hostUrl_ + argPath);
/*     */       
/* 183 */       conn = (HttpURLConnection)url.openConnection();
/* 184 */       conn.setFixedLengthStreamingMode(requestBytes.length);
/* 185 */       conn.setDoOutput(true);
/* 186 */       conn.setDoInput(true);
/* 187 */       addAuthentication(conn);
/* 188 */       setupHttps(conn);
/* 189 */       conn.setRequestProperty("Accept", "*/*");
/* 190 */       conn.setRequestProperty("User-Agent", getUserAgent(argProperties));
/* 191 */       conn.setRequestProperty("Content-Type", argContentType);
/* 192 */       conn.setRequestProperty("Content-Encoding", argEncodingType);
/* 193 */       addRequestParams(conn);
/* 194 */       conn.setReadTimeout(this.timeout_);
/* 195 */       Map<String, List<String>> requestProps = conn.getRequestProperties();
/*     */       
/* 197 */       out = conn.getOutputStream();
/*     */       
/* 199 */       out.write(requestBytes);
/* 200 */       out.flush();
/*     */       
/* 202 */       Level level = Level.DEBUG;
/* 203 */       Throwable t = null;
/*     */       
/* 205 */       if (SwingUtilities.isEventDispatchThread())
/*     */       {
/* 207 */         DtvSecurityManager.getInstance().isAllowed("XcenterAccessFromUiThread");
/*     */       }
/*     */       
/* 210 */       if (logger_.isEnabledFor((Priority)level)) {
/* 211 */         StringBuilder msg = new StringBuilder(1024);
/* 212 */         msg.append("HTTP Request [Datasource: ");
/* 213 */         msg.append(getDataSourceName());
/* 214 */         msg.append("]\n");
/* 215 */         msg.append("URL: ");
/* 216 */         msg.append(url);
/* 217 */         msg.append("\n");
/* 218 */         msg.append("Header:\n");
/* 219 */         msg.append(formatHeader(requestProps));
/* 220 */         msg.append(argRequest);
/* 221 */         logger_.log((Priority)level, msg.toString(), t);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       return getServletResponse(conn, argPath);
/*     */     } finally {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 234 */         if (out != null) {
/* 235 */           out.close();
/* 236 */           out = null;
/*     */         }
/*     */       
/* 239 */       } catch (Exception ee) {
/* 240 */         if (logger_.isDebugEnabled()) {
/* 241 */           logger_.debug("Encountered an exception while closing our writer.", ee);
/*     */         }
/*     */       } 
/*     */       try {
/* 245 */         if (conn != null) {
/* 246 */           conn.disconnect();
/* 247 */           conn = null;
/*     */         }
/*     */       
/* 250 */       } catch (Exception ee) {
/* 251 */         logger_.debug("Encountered an exception while closing our HttpURLConnection.", ee);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProps) {
/*     */     try {
/* 260 */       super.setProperties(argProps);
/* 261 */       this.hostUrl_ = getAndValidateSet(argProps, "ConnectionURL");
/* 262 */       this.timeout_ = Integer.parseInt(getAndValidateSet(argProps, "Timeout"));
/* 263 */       this.userName_ = argProps.getProperty("ConnectionUserName");
/* 264 */       this.password_ = argProps.getProperty("ConnectionPassword");
/* 265 */       this.soapAction_ = argProps.getProperty("SoapAction");
/*     */       
/* 267 */       if (isHttps()) {
/*     */         
/*     */         try {
/*     */           
/* 271 */           this.keystore_ = getAndValidateSet(argProps, "keystore");
/*     */           
/* 273 */           this.keystorePassword_ = getProperty(argProps, "keystorePassword");
/* 274 */           this.keyAlias_ = getAndValidateSet(argProps, "keyalias");
/*     */ 
/*     */ 
/*     */           
/* 278 */           this.truststore_ = argProps.getProperty("truststore");
/*     */           
/* 280 */           this.truststorePassword_ = getProperty(argProps, "truststorePassword");
/*     */         }
/* 282 */         catch (Exception ee) {
/* 283 */           logger_.error("An exception occurred while loading properties for datasource: " + 
/* 284 */               getDataSourceName(), ee);
/*     */         }
/*     */       
/*     */       }
/* 288 */     } catch (Exception ee) {
/* 289 */       logger_.error("An exception occurred while loading properties for datasource: " + 
/* 290 */           getDataSourceName(), ee);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     if (!StringUtils.isEmpty(this.userName_) || !StringUtils.isEmpty(this.password_)) {
/* 298 */       validateSet("ConnectionUserName", this.userName_);
/* 299 */       validateSet("ConnectionPassword", this.password_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeout(int argTimeout) {
/* 308 */     this.timeout_ = argTimeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAuthentication(HttpURLConnection conn) {
/* 316 */     if (!StringUtils.isEmpty(this.userName_)) {
/* 317 */       IDtvDecrypter decrypter = DtvDecrypter.getInstance("config");
/* 318 */       String s = decrypter.decryptIfEncrypted(this.userName_) + ":" + decrypter.decryptIfEncrypted(this.password_);
/* 319 */       s = Base64.byteArrayToBase64(s.getBytes());
/* 320 */       conn.setRequestProperty("Authorization", "Basic " + s);
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
/*     */   protected void addRequestParams(HttpURLConnection argConn) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String formatHeader(Map<String, List<String>> argHeader) {
/* 340 */     StringBuilder buff = new StringBuilder(512);
/* 341 */     for (String key : argHeader.keySet()) {
/* 342 */       for (String value : argHeader.get(key)) {
/* 343 */         buff.append(key).append("=").append(value).append("\n");
/*     */       }
/*     */     } 
/* 346 */     return buff.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String getAndValidateSet(Properties argProps, String argName) {
/* 356 */     String s = argProps.getProperty(argName);
/* 357 */     validateSet(argName, s);
/* 358 */     return s;
/*     */   }
/*     */   
/*     */   protected EventManager getEventManager() {
/* 362 */     return this._eventManager;
/*     */   }
/*     */   
/*     */   protected IPersistenceDefaults getPersistenceDefaults() {
/* 366 */     return this._persistenceDefaults;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getProperty(Properties argProps, String argPropertyName) {
/* 376 */     String value = argProps.getProperty(argPropertyName);
/*     */     
/* 378 */     if (value == null) {
/* 379 */       return null;
/*     */     }
/*     */     
/* 382 */     return value;
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
/*     */   protected Object getServletResponse(HttpURLConnection argConnection, String argServletUrl) throws Exception {
/* 396 */     InputStream in = null;
/*     */     try {
/* 398 */       in = argConnection.getInputStream();
/*     */       
/* 400 */       ByteArray response = null;
/*     */       
/* 402 */       int contentLength = argConnection.getContentLength();
/* 403 */       boolean contentLengthApplicable = (contentLength != -1);
/*     */       
/* 405 */       if (contentLengthApplicable) {
/* 406 */         response = new ByteArray(contentLength);
/*     */       } else {
/*     */         
/* 409 */         response = new ByteArray(2048);
/*     */       } 
/*     */ 
/*     */       
/*     */       int read;
/*     */ 
/*     */       
/* 416 */       while ((read = in.read()) != -1) {
/* 417 */         response.append((byte)read);
/*     */       }
/*     */       
/* 420 */       if (contentLengthApplicable && response.length() < contentLength) {
/* 421 */         logger_.warn("We only read " + response.length() + " bytes,  but the content length was reported as: " + contentLength + "bytes. *BYTES MAY HAVE BEEN DROPPED!*");
/*     */       }
/*     */ 
/*     */       
/* 425 */       byte[] data = response.toArray();
/*     */       
/* 427 */       String encoding = argConnection.getContentEncoding();
/*     */       
/* 429 */       if (HttpEncodingType.GZIP.matches(encoding)) {
/* 430 */         return EncodingHelper.deserialize(GZipUtils.unzip(data));
/*     */       }
/* 432 */       if (encoding == null || HttpEncodingType.UTF8.matches(encoding)) {
/* 433 */         return StringUtils.getString(data);
/*     */       }
/*     */       
/* 436 */       String ss = StringUtils.getString(data);
/* 437 */       logger_.warn("Unrecognized content encoding type from servlet: " + encoding + " response bytes as string: " + ss);
/*     */ 
/*     */       
/* 440 */       throw FailoverException.getNewException("Unrecognized encoding type: " + encoding, 
/* 441 */           getDataSourceName());
/*     */     } finally {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */         
/* 449 */         if (in != null) {
/* 450 */           in.close();
/*     */         }
/*     */       }
/* 453 */       catch (Exception ee) {
/* 454 */         if (logger_.isDebugEnabled()) {
/* 455 */           logger_.debug("Encountered an exception while closing our reader.", ee);
/*     */         }
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
/*     */ 
/*     */   
/*     */   protected String getSoapAction(String argQueryKey, Map<String, Object> argParams) {
/* 470 */     String compositeKey = "SoapAction:" + argQueryKey;
/* 471 */     if (getProperties().containsKey(compositeKey)) {
/* 472 */       return getProperties().getProperty(compositeKey);
/*     */     }
/*     */     
/* 475 */     if (!StringUtils.isEmpty(this.soapAction_)) {
/* 476 */       return this.soapAction_;
/*     */     }
/*     */     
/* 479 */     return getUrlPath(argQueryKey, argParams);
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
/*     */   protected String getUrlPath(String argQueryKey, Map<String, Object> argParams) {
/* 493 */     String compositeKey = "UrlPath:" + argQueryKey;
/* 494 */     Properties props = getProperties();
/*     */     
/* 496 */     return props.containsKey(compositeKey) ? props.getProperty(compositeKey) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getUserAgent(Map<String, String> argProperties) {
/* 504 */     StringBuilder buff = new StringBuilder(256);
/*     */     
/* 506 */     buff.append(this._persistenceDefaults.getOrganizationId());
/* 507 */     buff.append("::");
/* 508 */     buff.append(this._persistenceDefaults.getRetailLocationId());
/* 509 */     buff.append("::");
/*     */     
/* 511 */     String explicitWorkstationId = argProperties.get("WORKSTATION_ID_PROPERTY");
/* 512 */     if (explicitWorkstationId != null) {
/* 513 */       buff.append(explicitWorkstationId);
/*     */     } else {
/*     */       
/* 516 */       buff.append(this._persistenceDefaults.getWorkstationId());
/*     */     } 
/*     */     
/* 519 */     String timestamp = argProperties.get("TIMESTAMP_PROPERTY");
/*     */     
/* 521 */     if (timestamp != null) {
/* 522 */       buff.append("::");
/* 523 */       buff.append(timestamp);
/*     */     } 
/*     */     
/* 526 */     return buff.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isHttps() {
/* 534 */     return this.hostUrl_.toLowerCase().startsWith("https");
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
/*     */   protected void setupHttps(HttpURLConnection argConn) throws KeyManagementException, DtvKeyStoreException, NoSuchAlgorithmException {
/* 549 */     if (argConn instanceof HttpsURLConnection) {
/* 550 */       HttpsURLConnection conn = (HttpsURLConnection)argConn;
/*     */       
/* 552 */       IDtvDecrypter decrypter = DtvDecrypter.getInstance("config");
/* 553 */       char[] keypass = decrypter.decryptIfEncrypted(this.keystorePassword_).toCharArray();
/* 554 */       char[] trustpass = decrypter.decryptIfEncrypted(this.truststorePassword_).toCharArray();
/*     */ 
/*     */       
/* 557 */       SSLSocketFactory socketFactory = SslUtils.getSSLSocketFactory(this.keystore_, keypass, this.keyAlias_, this.truststore_, trustpass);
/* 558 */       conn.setSSLSocketFactory(socketFactory);
/* 559 */       conn.setHostnameVerifier((HostnameVerifier)new DtvHostnameVerifier());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validateSet(String argName, String argValue) {
/* 570 */     if (StringUtils.isEmpty(argValue))
/* 571 */       throw new DtxException("Property [" + argName + "] is required for datasource [" + getDataSourceName() + "] to function. Check DataSourceConfig.xml."); 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\remote\AbstractHttpDatasource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */