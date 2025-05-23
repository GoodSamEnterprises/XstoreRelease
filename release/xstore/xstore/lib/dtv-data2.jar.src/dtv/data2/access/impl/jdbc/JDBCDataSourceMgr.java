/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import dtv.data2.SQLExceptionScrubber;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.query.QueryToken;
/*     */ import dtv.data2.access.status.IDataSourceStatusListener;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import oracle.ucp.jdbc.ValidConnection;
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
/*     */ public class JDBCDataSourceMgr
/*     */   implements IDataSourceStatusListener
/*     */ {
/*  37 */   private static final Logger _logger = Logger.getLogger(JDBCDataSourceMgr.class);
/*     */   
/*     */   static final String JNDI_URL_PREFIX = "jndi:";
/*     */   
/*  41 */   private static final JDBCDataSourceMgr instance_ = new JDBCDataSourceMgr();
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
/*     */   public static JDBCDataSourceMgr getInstance() {
/*  53 */     return instance_;
/*     */   }
/*     */   
/*     */   public static boolean isJDBCDataSource(DataSourceDescriptor argDataSourceDescriptor) {
/*  57 */     return argDataSourceDescriptor.getPersistenceStrategyName().toLowerCase().contains("jdbc");
/*     */   }
/*     */   
/*     */   private static void throwAwayConnection(Connection argConnection) {
/*  61 */     if (argConnection instanceof ValidConnection) {
/*     */       try {
/*  63 */         ((ValidConnection)argConnection).setInvalid();
/*     */       }
/*  65 */       catch (Throwable almostIgnored) {
/*  66 */         _logger.debug("CAUGHT EXCEPTION", almostIgnored);
/*     */       } 
/*     */     }
/*     */     try {
/*  70 */       argConnection.close();
/*     */     }
/*  72 */     catch (Throwable almostIgnored) {
/*  73 */       _logger.debug("CAUGHT EXCEPTION", almostIgnored);
/*     */     } 
/*     */   }
/*     */   
/*  77 */   private final ConcurrentMap<String, JDBCConnectionProvider> connectionPools_ = new ConcurrentHashMap<>(5, 1.0F, 1);
/*     */   
/*  79 */   private final ConcurrentMap<String, JDBCConnectionTemplate> dataSources_ = new ConcurrentHashMap<>(5, 1.0F, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JDBCDataSourceMgr() {
/*     */     try {
/*  87 */       Collection<DataSourceDescriptor> datasources = DataSourceFactory.getInstance().getDataSourceDescriptors();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  92 */       for (DataSourceDescriptor datasource : datasources) {
/*  93 */         if (datasource.isEnabled() && 
/*  94 */           isJDBCDataSource(datasource)) {
/*  95 */           registerDatasource(datasource);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       StatusMgr.getInstance().registerStatusListener(this);
/*     */     }
/* 105 */     catch (Exception ee) {
/* 106 */       _logger.fatal("An exception occurred while creating " + JDBCDataSourceMgr.class.getName() + ". There may be a fundamental configuration error with system.properties or DataSourceConfig.xml or a related config", ee);
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
/*     */   public DBConnection getConnection(String argDatasourceName) {
/* 119 */     return getConnection(argDatasourceName, true);
/*     */   }
/*     */   public DBConnection getConnection(String argDatasourceName, boolean argAutoCommit) {
/*     */     Connection connection;
/* 123 */     JDBCConnectionTemplate template = getTemplate(argDatasourceName);
/*     */ 
/*     */     
/*     */     try {
/* 127 */       JDBCConnectionProvider connectionPool = getConnectionPool(argDatasourceName);
/*     */ 
/*     */       
/* 130 */       connection = connectionPool.getConnection();
/*     */     }
/* 132 */     catch (SQLException ex) {
/* 133 */       SQLException scrubbedException = SQLExceptionScrubber.scrub(ex);
/* 134 */       if (FailoverException.isFailover(ex)) {
/* 135 */         throw FailoverException.getNewException(scrubbedException, argDatasourceName);
/*     */       }
/*     */       
/* 138 */       String message = "Could not obtain new datasource conenction for " + argDatasourceName;
/* 139 */       throw new DBConnectionException(message, scrubbedException);
/*     */     } 
/*     */     
/*     */     try {
/* 143 */       return DBConnection.adapt(connection, template, argAutoCommit);
/*     */     }
/* 145 */     catch (RuntimeException|Error ex) {
/* 146 */       throwAwayConnection(connection);
/* 147 */       throw ex;
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
/*     */   public DBConnection getConnection(TransactionToken argTransactionToken, String argDataSourceName) {
/* 160 */     DBConnection datasource = (DBConnection)argTransactionToken.getDataSource(argDataSourceName, DBConnection.class);
/*     */ 
/*     */     
/* 163 */     if (datasource == null) {
/* 164 */       datasource = getConnection(argDataSourceName, false);
/* 165 */       datasource.setAssociatedTransaction(argTransactionToken);
/* 166 */       datasource.setMyManager(this);
/* 167 */       argTransactionToken.registerDataSource(datasource);
/*     */     } 
/*     */     
/* 170 */     return datasource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentPoolSize() {
/* 179 */     int poolSize = 0;
/* 180 */     for (JDBCConnectionProvider connectionPool : this.connectionPools_.values()) {
/* 181 */       poolSize += connectionPool.getPoolSize();
/*     */     }
/* 183 */     return poolSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DBConnection getQueryConnection(String argDataSourceName, QueryToken argQueryToken) {
/* 194 */     if (argQueryToken == null) {
/* 195 */       throw new DtxException("getQueryConnection was called without a QueryToken.  This is not supported.");
/*     */     }
/*     */     
/* 198 */     DBConnection queryConnection = (DBConnection)argQueryToken.getQueryResource(argDataSourceName, DBConnection.class);
/* 199 */     if (queryConnection == null) {
/* 200 */       queryConnection = getConnection(argDataSourceName);
/* 201 */       argQueryToken.registerQueryResource(queryConnection);
/*     */     } 
/* 203 */     return queryConnection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notfiyOffline(String argDatasourceName) {
/* 214 */     closeConnectionPool(argDatasourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyOnline(String argDatasourceName) {
/* 225 */     if (this.dataSources_.containsKey(argDatasourceName) && !this.connectionPools_.containsKey(argDatasourceName)) {
/* 226 */       loadConnectionPool(argDatasourceName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerDatasource(DataSourceDescriptor dsd) {
/* 237 */     JDBCConnectionTemplate template = new JDBCConnectionTemplate(dsd);
/* 238 */     String dataSourceName = template.getDataSourceName();
/* 239 */     if (this.dataSources_.putIfAbsent(dataSourceName, template) != null) {
/* 240 */       throw new DBConnectionException("An attempt was made to re-register datasource: " + dataSourceName + " Registration should only occur once for a datasource.");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 246 */     List<String> poolKeys = new ArrayList<>(this.connectionPools_.keySet());
/* 247 */     for (String poolKey : poolKeys) {
/* 248 */       closeConnectionPool(poolKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 258 */     StringBuilder poolStats = new StringBuilder();
/* 259 */     for (Map.Entry<String, JDBCConnectionProvider> poolEntry : this.connectionPools_.entrySet()) {
/* 260 */       poolStats.append(poolEntry.getKey());
/* 261 */       poolStats.append(" [").append(((JDBCConnectionProvider)poolEntry.getValue()).getStats()).append("]");
/* 262 */       poolStats.append("\n\n");
/*     */     } 
/* 264 */     return poolStats.toString();
/*     */   }
/*     */   
/*     */   private void closeConnectionPool(String argDatasourceName) {
/* 268 */     JDBCConnectionProvider connectionPool = this.connectionPools_.remove(argDatasourceName);
/* 269 */     if (connectionPool != null) {
/*     */       try {
/* 271 */         _logger.debug("Shutting down connection pool for datasource " + argDatasourceName);
/* 272 */         connectionPool.close();
/*     */       }
/* 274 */       catch (Throwable t) {
/* 275 */         _logger.warn("Connection pool for datasource " + argDatasourceName + " could not be closed.", t);
/*     */       } 
/*     */     } else {
/*     */       
/* 279 */       _logger.debug("An attempt was made to close a connection pool for a datasource named " + argDatasourceName + " but no pool appears to exist for that datasource.");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private JDBCConnectionProvider getConnectionPool(String argDatasourceName) {
/* 286 */     JDBCConnectionProvider connectionPool = this.connectionPools_.get(argDatasourceName);
/*     */ 
/*     */     
/* 289 */     if (connectionPool == null) {
/* 290 */       connectionPool = loadConnectionPool(argDatasourceName);
/*     */     }
/*     */     
/* 293 */     return connectionPool;
/*     */   }
/*     */   
/*     */   private JDBCConnectionTemplate getTemplate(String argDatasourceName) {
/* 297 */     JDBCConnectionTemplate template = this.dataSources_.get(argDatasourceName);
/* 298 */     if (template == null) {
/* 299 */       throw new DBConnectionException("No datasource named '" + argDatasourceName + "' is registered with this manager. Available datasources are: " + this.dataSources_
/* 300 */           .keySet());
/*     */     }
/* 302 */     return template;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized JDBCConnectionProvider loadConnectionPool(String argDatasourceName) {
/* 313 */     JDBCConnectionProvider returnPool = this.connectionPools_.get(argDatasourceName);
/*     */ 
/*     */     
/* 316 */     if (returnPool == null) {
/*     */       
/* 318 */       if (_logger.isDebugEnabled()) {
/* 319 */         _logger.debug("Creating new JDBC connection for datasource name: [" + argDatasourceName + "]");
/*     */       }
/*     */ 
/*     */       
/* 323 */       JDBCConnectionTemplate template = getTemplate(argDatasourceName);
/*     */ 
/*     */       
/*     */       try {
/* 327 */         returnPool = JDBCConnectionProvider.make(template);
/* 328 */         this.connectionPools_.put(argDatasourceName, returnPool);
/*     */       }
/* 330 */       catch (Exception ee) {
/*     */ 
/*     */         
/* 333 */         Exception scrubbedException = (ee instanceof SQLException) ? SQLExceptionScrubber.scrub((SQLException)ee) : ee;
/* 334 */         if (FailoverException.isFailover(ee)) {
/* 335 */           throw FailoverException.getNewException(scrubbedException, argDatasourceName);
/*     */         }
/*     */         
/* 338 */         throw new DBConnectionException("An unexpected exception occurred while creating a jdbc connection for datasource: " + argDatasourceName + ".", scrubbedException);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     return returnPool;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCDataSourceMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */