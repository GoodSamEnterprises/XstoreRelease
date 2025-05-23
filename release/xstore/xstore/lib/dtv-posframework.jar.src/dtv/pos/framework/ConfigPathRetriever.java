/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.util.ApplicationMode;
/*     */ import dtv.util.Base64;
/*     */ import dtv.util.config.SystemPropertiesLoader;
/*     */ import dtv.util.crypto.DtvDecrypter;
/*     */ import dtv.util.crypto.IDtvDecrypter;
/*     */ import dtv.util.net.SslUtils;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.net.ConnectException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import javax.net.ssl.HttpsURLConnection;
/*     */ import javax.net.ssl.SSLSocketFactory;
/*     */ import org.apache.log4j.Logger;
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
/*     */ 
/*     */ public class ConfigPathRetriever
/*     */ {
/*     */   public static final String PARAM_ORG_ID = "ORG_ID";
/*     */   public static final String PARAM_STORE = "RETAIL_LOC_ID";
/*     */   public static final String PARAM_REGISTER = "WORKSTATION_ID";
/*     */   public static final String STORE_SPECIFIC_ELEMENT_PLACEHOLDER = "$STORE_NUMBER$";
/*     */   public static final String PROP_UPDATE_FAILED = "update.failed";
/*  52 */   private static final Logger _logger = Logger.getLogger(ConfigPathRetriever.class);
/*     */ 
/*     */   
/*     */   private static final String PROP_CONFIG_PATH_UPDATE_ENABLED = "dtv.update.configpath.from.Xcenter";
/*     */ 
/*     */   
/*     */   private static final String PROP_LAST_SUCCESSFUL_UPDATE = "last.updated.date";
/*     */ 
/*     */   
/*     */   private static final String XCENTER_DATA_SOURCE = "Xcenter";
/*     */ 
/*     */   
/*     */   private static final String PROP_SERVLET_PATH = "GetConfigPathPath";
/*     */ 
/*     */   
/*     */   private static final String FILE_COMMENTS = "The contents of this file are machine-generated. The values were retrieved from Xcenter and represent the store personality that is defined there for this store.\nNO MANUAL CHANGES SHOULD BE MADE TO THIS FILE.";
/*     */ 
/*     */   
/*     */   public boolean updateConfigPathFromServer(long argOrgId, long argStoreNumber, long argWkstnId) {
/*  71 */     return updateConfigPathFromServer(argOrgId, argStoreNumber, argWkstnId, 
/*  72 */         Boolean.getBoolean("dtv.update.configpath.from.Xcenter")).updateOccurred();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigPathRetrieverResult updateConfigPathFromServer(long argOrgId, long argStoreNumber, long argWkstnId, boolean argCheckEnabled) {
/*  83 */     if (ApplicationMode.isDevelopment()) {
/*  84 */       return ConfigPathRetrieverResult.forNoUpdate();
/*     */     }
/*     */ 
/*     */     
/*  88 */     if (!argCheckEnabled) {
/*  89 */       return ConfigPathRetrieverResult.forNoUpdate();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  94 */     DataSourceDescriptor xcenter = DataSourceFactory.getInstance().getDataSourceDescriptor("Xcenter");
/*     */     
/*  96 */     boolean pathUpdated = false;
/*  97 */     Properties xcenterProperties = xcenter.getProperties();
/*  98 */     String baseUrl = xcenterProperties.getProperty("ConnectionURL");
/*  99 */     String user = xcenterProperties.getProperty("ConnectionUserName");
/* 100 */     String password = xcenterProperties.getProperty("ConnectionPassword");
/* 101 */     String contextPath = xcenterProperties.getProperty("GetConfigPathPath");
/*     */     
/*     */     try {
/* 104 */       IDtvDecrypter decrypter = DtvDecrypter.getInstance("config");
/* 105 */       user = decrypter.decryptIfEncrypted(user);
/* 106 */       password = decrypter.decryptIfEncrypted(password);
/*     */     }
/* 108 */     catch (Exception ex) {
/* 109 */       _logger.error("EXCEPTION CAUGHT", ex);
/*     */     } 
/*     */     
/* 112 */     StringBuilder urlBuilder = new StringBuilder(baseUrl);
/* 113 */     urlBuilder.append(contextPath);
/*     */     
/* 115 */     urlBuilder.append("?");
/* 116 */     urlBuilder.append("ORG_ID");
/* 117 */     urlBuilder.append("=");
/* 118 */     urlBuilder.append(argOrgId);
/* 119 */     urlBuilder.append("&");
/* 120 */     urlBuilder.append("RETAIL_LOC_ID");
/* 121 */     urlBuilder.append("=");
/* 122 */     urlBuilder.append(argStoreNumber);
/* 123 */     urlBuilder.append("&");
/* 124 */     urlBuilder.append("WORKSTATION_ID");
/* 125 */     urlBuilder.append("=");
/* 126 */     urlBuilder.append(argWkstnId);
/*     */ 
/*     */     
/* 129 */     ObjectInputStream objectInputStream = null;
/* 130 */     Properties propsFromFile = SystemPropertiesLoader.loadConfigPathPropertiesFile();
/*     */     
/*     */     try {
/* 133 */       URL url = new URL(urlBuilder.toString());
/* 134 */       HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
/* 135 */       setSocketFactory(httpCon);
/* 136 */       String userPassword = user + ":" + password;
/* 137 */       String encoding = Base64.byteArrayToBase64(userPassword.getBytes(StandardCharsets.UTF_8));
/* 138 */       httpCon.setRequestMethod("GET");
/* 139 */       httpCon.setRequestProperty("Authorization", "Basic " + encoding);
/*     */ 
/*     */       
/* 142 */       int responseCode = httpCon.getResponseCode();
/* 143 */       if (responseCode == 200) {
/* 144 */         objectInputStream = new ObjectInputStream(httpCon.getInputStream());
/* 145 */         Properties propsFromServer = (Properties)objectInputStream.readObject();
/*     */         
/* 147 */         String basePathFromServer = propsFromServer.getProperty("dtv.base.config.path", "");
/* 148 */         String basePathFromFile = propsFromFile.getProperty("dtv.base.config.path", "");
/*     */         
/* 150 */         String pathFromServer = propsFromServer.getProperty("dtv.config.path", "");
/*     */         
/* 152 */         pathFromServer = pathFromServer.replace("$STORE_NUMBER$", String.valueOf(argStoreNumber));
/*     */         
/* 154 */         String pathFromFile = propsFromFile.getProperty("dtv.config.path", "");
/*     */ 
/*     */         
/* 157 */         propsFromFile.remove("update.failed");
/*     */ 
/*     */ 
/*     */         
/* 161 */         if (!basePathFromServer.equals(basePathFromFile) || !pathFromFile.equals(pathFromServer)) {
/* 162 */           propsFromFile.setProperty("dtv.base.config.path", basePathFromServer);
/* 163 */           propsFromFile.setProperty("dtv.config.path", pathFromServer);
/*     */           
/* 165 */           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
/* 166 */           propsFromFile.setProperty("last.updated.date", dateFormat.format(new Date()));
/* 167 */           pathUpdated = true;
/*     */         } 
/*     */       } else {
/* 170 */         if (responseCode == 501) {
/* 171 */           objectInputStream = new ObjectInputStream(httpCon.getErrorStream());
/* 172 */           String error = (String)objectInputStream.readObject();
/* 173 */           throw new ConnectException(error);
/*     */         } 
/*     */         
/* 176 */         throw new ConnectException(responseCode + " - " + httpCon.getResponseMessage());
/*     */       }
/*     */     
/* 179 */     } catch (Exception ex) {
/* 180 */       propsFromFile.setProperty("update.failed", "true");
/* 181 */       _logger.error("An exception was caught attempting to retrieve the config path properties from Xcenter at URL " + urlBuilder, ex);
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 186 */       try (FileWriter writer = new FileWriter("configPath.properties")) {
/*     */         
/* 188 */         propsFromFile.store(writer, "The contents of this file are machine-generated. The values were retrieved from Xcenter and represent the store personality that is defined there for this store.\nNO MANUAL CHANGES SHOULD BE MADE TO THIS FILE.");
/*     */         
/* 190 */         if (objectInputStream != null) {
/* 191 */           objectInputStream.close();
/*     */         }
/*     */       }
/* 194 */       catch (IOException ex) {
/* 195 */         _logger.error("An I/O exception occurred writing updates to the configPath.properties file.", ex);
/*     */       } 
/*     */     } 
/*     */     
/* 199 */     if (pathUpdated) {
/* 200 */       return ConfigPathRetrieverResult.forUpdated(propsFromFile);
/*     */     }
/* 202 */     return ConfigPathRetrieverResult.forNoUpdate();
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
/*     */   protected void setSocketFactory(HttpURLConnection argConnection) throws KeyManagementException, NoSuchAlgorithmException {
/* 215 */     if (argConnection instanceof HttpsURLConnection) {
/* 216 */       HttpsURLConnection httpsConnection = (HttpsURLConnection)argConnection;
/* 217 */       SSLSocketFactory factory = SslUtils.getSSLSocketFactory();
/* 218 */       httpsConnection.setSSLSocketFactory(factory);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class ConfigPathRetrieverResult
/*     */   {
/*     */     private final String _configPath;
/*     */     
/*     */     static ConfigPathRetrieverResult forNoUpdate() {
/* 227 */       return new ConfigPathRetrieverResult(false, null);
/*     */     }
/*     */     private final String _configPathBase; private final boolean _updateOccurred;
/*     */     static ConfigPathRetrieverResult forUpdated(Properties argProps) {
/* 231 */       return new ConfigPathRetrieverResult(true, argProps);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ConfigPathRetrieverResult(boolean argUpdated, Properties argProps) {
/* 239 */       this._updateOccurred = argUpdated;
/* 240 */       if (argProps == null) {
/* 241 */         this._configPath = this._configPathBase = null;
/*     */       } else {
/*     */         
/* 244 */         this._configPath = argProps.getProperty("dtv.config.path");
/* 245 */         this._configPathBase = argProps.getProperty("dtv.base.config.path");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getConfigPath() {
/* 253 */       return this._configPath;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getConfigPathBase() {
/* 260 */       return this._configPathBase;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean updateOccurred() {
/* 267 */       return this._updateOccurred;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\ConfigPathRetriever.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */