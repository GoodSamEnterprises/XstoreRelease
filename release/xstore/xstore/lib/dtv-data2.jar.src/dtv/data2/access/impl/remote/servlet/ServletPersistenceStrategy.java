/*     */ package dtv.data2.access.impl.remote.servlet;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryResult;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.exception.PersistenceCancelledException;
/*     */ import dtv.data2.access.exception.RetryException;
/*     */ import dtv.data2.access.exception.ServletFailoverException;
/*     */ import dtv.data2.access.impl.IDataModelImpl;
/*     */ import dtv.data2.access.impl.remote.AbstractHttpDatasource;
/*     */ import dtv.data2.access.impl.remote.HttpContentType;
/*     */ import dtv.data2.access.impl.remote.HttpEncodingType;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.transaction.DataSourceTransactionManager;
/*     */ import dtv.data2.access.transaction.ITransactionalDataSource;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import dtv.event.EventManager;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class ServletPersistenceStrategy extends AbstractHttpDatasource {
/*  37 */   private static final Logger logger_ = Logger.getLogger(ServletPersistenceStrategy.class); public static final String PROP_GET_OBJECT_BY_ID_PATH = "GetObjectByIdPath";
/*     */   public static final String PROP_GET_OBJECT_BY_QUERY_PATH = "GetObjectByQueryPath";
/*     */   public static final String PROP_MAKE_PERSISTENT_PATH = "MakePersistentPath";
/*     */   private static final String PROP_MAKE_PERSISTENT_COMM_TYPE = "MakePersistentCommType";
/*     */   private static final String HEADER_MESSAGE_TYPE = "dtv-msg-type";
/*     */   protected String getObjectByIdPath_;
/*     */   protected String getObjectByQueryPath_;
/*     */   protected String makePersistentPath_;
/*  45 */   private final Map<TransactionToken, List<IPersistable>> makePersistentTransactions_ = new HashMap<>();
/*     */   
/*     */   private MessageType messageType_;
/*     */   
/*  49 */   private MakePersistentCommunicationType makePersistentCommType_ = MakePersistentCommunicationType.GZIP;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkExistence(IObjectId argId, QueryToken argQueryToken) {
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitPhase1(TransactionToken argTransToken) {
/*     */     try {
/*  61 */       List<IPersistable> persistables = this.makePersistentTransactions_.get(argTransToken);
/*     */       
/*  63 */       StringBuilder request = new StringBuilder(persistables.size() * 4096);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  68 */       request.append("<Timeout t=\"").append(this.timeout_).append("\"/>");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  73 */       for (IPersistable persistable : persistables) {
/*  74 */         request.append(persistable.toXmlString());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  80 */       Object oo = callServlet(request.toString(), getContentType(this.makePersistentCommType_), 
/*  81 */           getEncodingType(this.makePersistentCommType_), this.makePersistentPath_, argTransToken.getProperties());
/*     */       
/*  83 */       if (!(oo instanceof String)) {
/*  84 */         throw new DtxException("Unknown response from callServlet: " + oo);
/*     */       }
/*     */       
/*  87 */       String response = (String)oo;
/*     */       
/*  89 */       if (response.indexOf("DTX_PERSISTENCE_WAS_SUCCESSFUL") != -1) {
/*     */         return;
/*     */       }
/*     */       
/*  93 */       if (FailoverException.isFailover(new Exception(response)) || response
/*  94 */         .contains("No Available Datasources") || response
/*  95 */         .contains(PersistenceCancelledException.class.getName()))
/*     */       {
/*  97 */         throw ServletFailoverException.getNewException(response, getDataSourceName());
/*     */       }
/*     */       
/* 100 */       logger_.error("Could not persist data via DTX Servlet.  THIS IS NOT A CONNECTION FAILOVER, but we will throw a failover so local sources will be tried. Servlet reports: " + response);
/*     */ 
/*     */ 
/*     */       
/* 104 */       throw ServletFailoverException.getNewException(response.toString(), getDataSourceName());
/*     */ 
/*     */     
/*     */     }
/* 108 */     catch (Exception ee) {
/* 109 */       if (RetryException.isRetryException(ee)) {
/* 110 */         throw RetryException.getNewException(ee, getDataSourceName());
/*     */       }
/* 112 */       if (FailoverException.isFailover(ee)) {
/* 113 */         throw FailoverException.getNewException(ee, getDataSourceName());
/*     */       }
/* 115 */       if (ee instanceof ServletFailoverException) {
/* 116 */         throw (ServletFailoverException)ee;
/*     */       }
/*     */       
/* 119 */       logger_.error("Could not persist data via DTX Servlet.  THIS IS NOT A CONNECTION FAILOVER, but we will throw a failover so local sources will be tried.", ee);
/*     */ 
/*     */       
/* 122 */       throw ServletFailoverException.getNewException(ee, getDataSourceName());
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 127 */       this.makePersistentTransactions_.remove(argTransToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commitPhase2(TransactionToken argTransToken) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageType getMessageType() {
/* 141 */     return this.messageType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getObjectById(IObjectId argId, QueryToken argQueryToken) {
/* 150 */     this.messageType_ = MessageType.LOOKUP;
/*     */     
/*     */     try {
/* 153 */       StringBuilder request = new StringBuilder(128);
/*     */       
/*     */       try {
/* 156 */         request.append(this.getObjectByIdPath_).append("?").append(URLEncoder.encode("ID", "UTF-8")).append("=")
/* 157 */           .append(URLEncoder.encode(argId.toString(), "UTF-8")).append("&")
/* 158 */           .append(URLEncoder.encode("NAME", "UTF-8")).append("=")
/* 159 */           .append(URLEncoder.encode(argId.getDtxTypeName(), "UTF-8"));
/*     */       }
/* 161 */       catch (Exception ee) {
/* 162 */         throw new DtxException("An unexpected exception occurred while building getObjectById servlet request for id: " + argId, ee);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       Object oo = callServlet("", HttpContentType.TEXT
/* 171 */           .toString(), HttpEncodingType.UTF8.toString(), request.toString(), new HashMap<>());
/*     */ 
/*     */       
/* 174 */       if (oo instanceof String) {
/* 175 */         if (oo.toString().indexOf("ObjectNotFoundException") != -1) {
/* 176 */           return null;
/*     */         }
/*     */         
/* 179 */         logger_.warn("Unrecognized message from servlet while exec getObjectId for id: " + argId + " Servlet message: " + oo);
/*     */         
/* 181 */         throw FailoverException.getNewException("Unrecognized message from servlet: " + oo, 
/* 182 */             getDataSourceName());
/*     */       } 
/*     */       
/* 185 */       if (oo instanceof IDataModel) {
/* 186 */         setOriginDataSource(oo);
/* 187 */         setPersistenceDefaultsOnObject(oo);
/* 188 */         return (IDataModel)oo;
/*     */       } 
/*     */       
/* 191 */       throw new DtxException("Unknown type returned from servlet call. Object toString: " + oo + " Class: " + 
/* 192 */           ObjectUtils.getClassNameFromObject(oo));
/*     */     
/*     */     }
/* 195 */     catch (Exception ee) {
/* 196 */       if (RetryException.isRetryException(ee)) {
/* 197 */         throw RetryException.getNewException(ee, getDataSourceName());
/*     */       }
/* 199 */       if (FailoverException.isFailover(ee)) {
/* 200 */         throw FailoverException.getNewException(ee, getDataSourceName());
/*     */       }
/*     */       
/* 203 */       logger_.warn("Unexpected exception during getObjectById with id: " + argId, ee);
/* 204 */       throw FailoverException.getNewException("Failing " + getDataSourceName() + " over.", ee, 
/* 205 */           getDataSourceName());
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
/*     */   
/*     */   public Object getObjectByQuery(String argKey, Map<String, Object> argParams, QueryToken argQueryToken) {
/* 221 */     this.messageType_ = MessageType.LOOKUP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 228 */       QueryRequest request = new QueryRequest(argKey, argParams);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 234 */       Object oo = callServlet(request.toXmlString(), getContentType(this.makePersistentCommType_), 
/* 235 */           getEncodingType(this.makePersistentCommType_), this.getObjectByQueryPath_, new HashMap<>());
/*     */       
/* 237 */       if (oo instanceof String) {
/* 238 */         if (oo.toString().indexOf("ObjectNotFoundException") != -1) {
/* 239 */           return null;
/*     */         }
/*     */         
/* 242 */         logger_.warn("Unrecognized message from servlet while exec query key: " + argKey + " Servlet message: " + oo);
/*     */         
/* 244 */         throw FailoverException.getNewException("Unrecognized message from servlet: " + oo, 
/* 245 */             getDataSourceName());
/*     */       } 
/*     */       
/* 248 */       if (oo instanceof RuntimeException) {
/* 249 */         throw (RuntimeException)oo;
/*     */       }
/*     */       
/* 252 */       setOriginDataSource(oo);
/* 253 */       setPersistenceDefaultsOnObject(oo);
/* 254 */       return oo;
/*     */     
/*     */     }
/* 257 */     catch (Exception ee) {
/* 258 */       if (RetryException.isRetryException(ee)) {
/* 259 */         throw RetryException.getNewException(ee, getDataSourceName());
/*     */       }
/* 261 */       if (FailoverException.isFailover(ee)) {
/* 262 */         throw FailoverException.getNewException(ee, getDataSourceName());
/*     */       }
/*     */       
/* 265 */       logger_.warn("Unexpected exception during getObjectByQuery with key: " + argKey, ee);
/* 266 */       throw FailoverException.getNewException("Failing " + getDataSourceName() + " over.", ee, 
/* 267 */           getDataSourceName());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullGraphPersisted() {
/* 275 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(TransactionToken argTransToken) {
/* 281 */     this.makePersistentTransactions_.remove(argTransToken);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageType(MessageType argMessageType) {
/* 288 */     this.messageType_ = argMessageType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProps) {
/* 294 */     this.getObjectByIdPath_ = getAndValidateSet(argProps, "GetObjectByIdPath");
/* 295 */     this.getObjectByQueryPath_ = getAndValidateSet(argProps, "GetObjectByQueryPath");
/* 296 */     this.makePersistentPath_ = getAndValidateSet(argProps, "MakePersistentPath");
/*     */     
/* 298 */     if (argProps.containsKey("MakePersistentCommType")) {
/* 299 */       this
/* 300 */         .makePersistentCommType_ = MakePersistentCommunicationType.forName(argProps.getProperty("MakePersistentCommType"));
/*     */     }
/* 302 */     super.setProperties(argProps);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addRequestParams(HttpURLConnection argConnection) {
/* 310 */     super.addRequestParams(argConnection);
/* 311 */     if (this.messageType_ == null) {
/* 312 */       this.messageType_ = MessageType.NOT_SPECIFIED;
/*     */     }
/* 314 */     argConnection.setRequestProperty("dtv-msg-type", this.messageType_.name());
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
/*     */   protected Object callServlet(String argRequest, String argContentType, String argEncodingType, String argServletUrl, Map<String, String> argProperties) {
/*     */     try {
/* 328 */       return sendHttpRequest(argRequest, argContentType, argEncodingType, argServletUrl, argProperties);
/*     */     }
/* 330 */     catch (Exception ee) {
/* 331 */       if (RetryException.isRetryException(ee)) {
/* 332 */         throw RetryException.getNewException(ee, getDataSourceName());
/*     */       }
/* 334 */       if (FailoverException.isFailover(ee)) {
/* 335 */         throw FailoverException.getNewException(ee, getDataSourceName());
/*     */       }
/*     */       
/* 338 */       logger_.warn("ServletPersistenceStrategy encountered an unexpected exception while contacting servlet at: " + argServletUrl, ee);
/*     */       
/* 340 */       throw FailoverException.getNewException("Something is wrong with the servlet, so we're failing it over.", ee, 
/* 341 */           getDataSourceName());
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
/*     */   protected String getContentType(MakePersistentCommunicationType argType) {
/* 353 */     return (MakePersistentCommunicationType.GZIP == argType) ? HttpContentType.BINARY
/* 354 */       .toString() : HttpContentType.TEXT
/* 355 */       .toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getEncodingType(MakePersistentCommunicationType argType) {
/* 365 */     if (MakePersistentCommunicationType.GZIP.equals(argType)) {
/* 366 */       return HttpEncodingType.GZIP.toString();
/*     */     }
/* 368 */     if (MakePersistentCommunicationType.TEXT.equals(argType)) {
/* 369 */       return HttpEncodingType.UTF8.toString();
/*     */     }
/* 371 */     if (MakePersistentCommunicationType.BASE64.equals(argType)) {
/* 372 */       return HttpEncodingType.BASE64.toString();
/*     */     }
/*     */     
/* 375 */     throw new DtxException("Unhandled communication type: " + argType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getUrlPath(String argQueryKey, Map<String, Object> argParams) {
/* 382 */     String urlPath = super.getUrlPath(argQueryKey, argParams);
/* 383 */     return (urlPath == null) ? this.makePersistentPath_ : urlPath;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void makePersistentImpl(TransactionToken argTransToken, IPersistable argPersistable) {
/* 389 */     if (this.messageType_ == null) {
/* 390 */       this.messageType_ = MessageType.PERSIST;
/*     */     }
/*     */     
/* 393 */     if (!(argPersistable instanceof IDataAccessObject) && !(argPersistable instanceof QueryRequest)) {
/* 394 */       throw new DtxException("ServletPersistenceStrategy only supports persisting of IDataAccessObject's & QueryRequest's currently, not " + argPersistable
/*     */           
/* 396 */           .getClass().getName() + " This is a TODO and should be implemented.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 403 */     if (this.makePersistentTransactions_.get(argTransToken) == null) {
/* 404 */       this.makePersistentTransactions_.put(argTransToken, new ArrayList<>());
/*     */       
/* 406 */       DataSourceTransactionManager.getInstance().registerDataSource(argTransToken, (ITransactionalDataSource)this);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 412 */     List<IPersistable> transaction = this.makePersistentTransactions_.get(argTransToken);
/*     */     
/* 414 */     transaction.add(argPersistable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setOriginDataSource(Object argResultObject) {
/* 424 */     String dataSourceName = getDataSourceName();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 429 */     boolean hasDataModels = argResultObject instanceof IDataModel;
/* 430 */     if (!hasDataModels && argResultObject instanceof java.util.Collection) {
/* 431 */       for (Object result : argResultObject) {
/* 432 */         if (result instanceof IDataModel) {
/* 433 */           hasDataModels = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 439 */     if (hasDataModels) {
/*     */       
/* 441 */       List<? extends IPersistable> persistables = DaoUtils.getPersistables(argResultObject);
/*     */       
/* 443 */       for (Iterator<? extends IPersistable> iter = persistables.iterator(); iter.hasNext(); ) {
/* 444 */         IPersistable nextPersistable = iter.next();
/* 445 */         if (nextPersistable instanceof IDataAccessObject) {
/* 446 */           ((IDataAccessObject)nextPersistable).setOriginDataSource(dataSourceName);
/*     */         }
/*     */         
/* 449 */         iter.remove();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 456 */     if (argResultObject instanceof IQueryResult) {
/* 457 */       ((IQueryResult)argResultObject).setDataSource(dataSourceName);
/*     */     }
/* 459 */     else if (argResultObject instanceof java.util.Collection) {
/* 460 */       for (Object result : argResultObject) {
/* 461 */         if (result instanceof IQueryResult) {
/* 462 */           ((IQueryResult)result).setDataSource(dataSourceName);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void setPersistenceDefaultsOnObject(Object argObject) {
/* 469 */     if (argObject instanceof IDataModelImpl) {
/* 470 */       IPersistenceDefaults persistenceDefaults = getPersistenceDefaults();
/* 471 */       EventManager eventManager = getEventManager();
/* 472 */       IDataModelImpl modelObject = (IDataModelImpl)argObject;
/* 473 */       modelObject.setDependencies(persistenceDefaults, eventManager);
/*     */     }
/* 475 */     else if (argObject instanceof java.util.Collection) {
/* 476 */       for (Object collectionObject : argObject) {
/* 477 */         setPersistenceDefaultsOnObject(collectionObject);
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
/*     */   public enum MakePersistentCommunicationType
/*     */   {
/* 491 */     TEXT,
/*     */     
/* 493 */     BASE64,
/*     */     
/* 495 */     GZIP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static MakePersistentCommunicationType forName(String argName) {
/* 503 */       if ("TEXT".equals(argName)) {
/* 504 */         return TEXT;
/*     */       }
/* 506 */       if ("BASE64".equals(argName)) {
/* 507 */         return BASE64;
/*     */       }
/* 509 */       if ("GZIP".equals(argName)) {
/* 510 */         return GZIP;
/*     */       }
/* 512 */       throw new DtxException("Invalid value for MakePersistentCommType: " + argName);
/*     */     }
/*     */   }
/*     */   
/*     */   public enum MessageType {
/* 517 */     NOT_SPECIFIED, LOOKUP, PERSIST, REPLICATE;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\remote\servlet\ServletPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */