/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import java.util.Properties;
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
/*     */ public class JDBCConnectionTemplate
/*     */ {
/*  25 */   private static final Logger _logger = Logger.getLogger(JDBCConnectionTemplate.class);
/*     */   
/*     */   private static final int MIN_PREPARED_STATEMENT_CACHE_SIZE = 1;
/*     */   
/*     */   private static final int DEFAULT_15_MINUTES = 900;
/*     */   
/*     */   private static final String ORACLE_DATA_SOURCE = "oracle.jdbc.pool.OracleDataSource";
/*     */   
/*     */   @Deprecated
/*     */   public static final String PROP_DRIVER = "ConnectionDriverName";
/*     */   public static final String PROP_CONNECTION_FACTORY_CLASS = "ConnectionFactoryClassName";
/*     */   public static final String PROP_URL = "ConnectionURL";
/*     */   public static final String PROP_USER = "ConnectionUserName";
/*     */   public static final String PROP_PASSWORD = "ConnectionPassword";
/*     */   private static final String PROP_TRANS_ISOLATION = "TransactionIsolation";
/*     */   private static final String PROP_USE_PREPARED_STATEMENT_CACHE = "UsePreparedStatementCache";
/*     */   private static final String PROP_PREPARED_STATEMENT_MAX_SIZE = "PreparedStatementCacheMaxSize";
/*     */   private static final String CONNECTION_POOL_MIN_SIZE = "ConnectionPoolMinSize";
/*     */   private static final String CONNECTION_POOL_MAX_SIZE = "ConnectionPoolMaxSize";
/*     */   private static final String CONNECTION_POOL_MAX_IDLE_TIME = "MaxConnectionIdleTime";
/*     */   private static final String CONNECTION_POOL_MAX_REUSE = "MaxConnectionReuseCount";
/*     */   private static final String SQL_FOR_VALIDATE_CONNECTION = "SQLForValidateConnection";
/*     */   private static final String VALIDATE_CONNECTION_ON_BORROW = "ValidateConnectionOnBorrow";
/*     */   
/*     */   private static String readConnectionFactoryClassName(Properties dsdProps) {
/*  50 */     String clz = dsdProps.getProperty("ConnectionFactoryClassName");
/*  51 */     if (!StringUtils.isEmpty(clz)) {
/*  52 */       return translateDriverClass(clz, clz);
/*     */     }
/*  54 */     return translateDriverClass(dsdProps.getProperty("ConnectionDriverName"), "oracle.jdbc.pool.OracleDataSource");
/*     */   }
/*     */   private static final String CONNECTION_WAIT_TIMEOUT = "ConnectionWaitTimeout"; private final String _dataSourceName; private final String _connectionFactoryClassName; private final boolean _isOracle; private final String _url; private final String _user; private final String _password; private final String _transactionIsolation; private final int _queryTimeout; private final int _preparedStatementCacheMaxSize; private final int _connectionPoolMinSize; private final int _connectionPoolMaxSize; private final int _connectionMaxIdleTime; private final int _connectionWaitTimeout; private final int _maxConnectionReuseCount; private final String _sqlForValidateConnection; private final boolean _validateConnectionOnBorrow;
/*     */   private static int readPreparedStatementCacheMaxSize(Properties dsdProps) {
/*  58 */     if (ConfigUtils.asBool(dsdProps.getProperty("UsePreparedStatementCache", Boolean.TRUE.toString()))) {
/*  59 */       int value = ConfigUtils.asInt(dsdProps.getProperty("PreparedStatementCacheMaxSize", "64"));
/*  60 */       if (value > 1) {
/*  61 */         return value;
/*     */       }
/*     */     } 
/*  64 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean readValidateConnectionOnBorrow(Properties dsdProps, boolean argIsOracle, String argSqlForValidateConnection) {
/*  70 */     Boolean defaultSetting = Boolean.valueOf((argIsOracle || !StringUtils.isEmpty(argSqlForValidateConnection)));
/*  71 */     return ConfigUtils.asBool(dsdProps.getProperty("ValidateConnectionOnBorrow", defaultSetting.toString()));
/*     */   }
/*     */   
/*     */   private static String translateDriverClass(String argDriver, String argDefault) {
/*  75 */     if ("com.microsoft.sqlserver.jdbc.SQLServerDriver".equals(argDriver)) {
/*  76 */       return "com.microsoft.sqlserver.jdbc.SQLServerDataSource";
/*     */     }
/*  78 */     if ("org.h2.Driver".equals(argDriver)) {
/*  79 */       return "org.h2.jdbcx.JdbcDataSource";
/*     */     }
/*  81 */     if ("oracle.jdbc.driver.OracleDriver".equals(argDriver)) {
/*  82 */       return "oracle.jdbc.pool.OracleDataSource";
/*     */     }
/*  84 */     return argDefault;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JDBCConnectionTemplate(DataSourceDescriptor argDescriptor) {
/* 106 */     this._dataSourceName = argDescriptor.getName();
/* 107 */     Properties dsdProps = argDescriptor.getProperties();
/*     */     
/* 109 */     this._connectionFactoryClassName = readConnectionFactoryClassName(dsdProps);
/* 110 */     this._isOracle = this._connectionFactoryClassName.startsWith("oracle.");
/* 111 */     this._url = dsdProps.getProperty("ConnectionURL");
/* 112 */     this._user = dsdProps.getProperty("ConnectionUserName");
/* 113 */     this._password = dsdProps.getProperty("ConnectionPassword");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (StringUtils.isEmpty(this._dataSourceName)) {
/* 120 */       throw new DBConnectionException("An attempt was made to register a datasource that does not have a name.  Each datasource must have a 'name' attribute associated with it.");
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (StringUtils.isEmpty(this._connectionFactoryClassName)) {
/* 125 */       throw new DBConnectionException("Datasource: '" + this._dataSourceName + "' does not define a driver.  Property: '" + "ConnectionFactoryClassName" + "' is required. Make sure this entry is set up properly for JDBC");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 130 */     if (StringUtils.isEmpty(this._url)) {
/* 131 */       throw new DBConnectionException("Datasource: '" + this._dataSourceName + "' does not define a jdbc url.  Property: '" + "ConnectionURL" + "' is required. Make sure this entry is set up properly for JDBC");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     this._preparedStatementCacheMaxSize = readPreparedStatementCacheMaxSize(dsdProps);
/* 140 */     this._connectionPoolMinSize = ConfigUtils.asInt(dsdProps.getProperty("ConnectionPoolMinSize"), 2);
/* 141 */     this._connectionPoolMaxSize = ConfigUtils.asInt(dsdProps.getProperty("ConnectionPoolMaxSize"), 8);
/* 142 */     this._connectionMaxIdleTime = ConfigUtils.asInt(dsdProps.getProperty("MaxConnectionIdleTime"), 900);
/* 143 */     this._connectionWaitTimeout = ConfigUtils.asInt(dsdProps.getProperty("ConnectionWaitTimeout"), 30);
/* 144 */     this._maxConnectionReuseCount = ConfigUtils.asInt(dsdProps.getProperty("MaxConnectionReuseCount"), 10);
/* 145 */     this
/* 146 */       ._sqlForValidateConnection = dsdProps.getProperty("SQLForValidateConnection", this._isOracle ? null : "SELECT 1;");
/* 147 */     this
/* 148 */       ._validateConnectionOnBorrow = readValidateConnectionOnBorrow(dsdProps, this._isOracle, this._sqlForValidateConnection);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     this._transactionIsolation = dsdProps.getProperty("TransactionIsolation");
/*     */     
/* 155 */     this._queryTimeout = ConfigUtils.asInt(dsdProps.getProperty("QueryTimeout"), 300);
/*     */   }
/*     */   
/*     */   public String getConnectionFactoryClassName() {
/* 159 */     return this._connectionFactoryClassName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConnectionMaxIdleTime() {
/* 166 */     return this._connectionMaxIdleTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConnectionPoolMaxSize() {
/* 173 */     return this._connectionPoolMaxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConnectionPoolMinSize() {
/* 180 */     return this._connectionPoolMinSize;
/*     */   }
/*     */   
/*     */   public int getConnectionWaitTimeout() {
/* 184 */     return this._connectionWaitTimeout;
/*     */   }
/*     */   
/*     */   public String getDataSourceName() {
/* 188 */     return this._dataSourceName;
/*     */   }
/*     */   
/*     */   public int getMaxConnectionReuseCount() {
/* 192 */     return this._maxConnectionReuseCount;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 196 */     return this._password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPreparedStatementCacheMaxSize() {
/* 203 */     return this._preparedStatementCacheMaxSize;
/*     */   }
/*     */   
/*     */   public int getQueryTimeout() {
/* 207 */     return this._queryTimeout;
/*     */   }
/*     */   
/*     */   public String getSqlForValidateConnection() {
/* 211 */     return this._sqlForValidateConnection;
/*     */   }
/*     */   
/*     */   public int getTransactionIsolation() {
/* 215 */     String transactionIsolation = this._transactionIsolation;
/* 216 */     if (transactionIsolation != null) {
/* 217 */       switch (transactionIsolation.toUpperCase()) {
/*     */         case "NONE":
/* 219 */           return 0;
/*     */         case "READ_COMMITTED":
/*     */         case "READ COMMITTED":
/* 222 */           return 2;
/*     */         case "REPEATABLE_READ":
/*     */         case "REPEATABLE READ":
/* 225 */           return 4;
/*     */         case "READ_UNCOMMITTED":
/*     */         case "READ UNCOMMITTED":
/* 228 */           return 1;
/*     */         case "SERIALIZABLE":
/* 230 */           return 8;
/*     */       } 
/* 232 */       _logger.warn("unexpected transaction isolation value [" + transactionIsolation + "]");
/*     */     } 
/*     */     
/* 235 */     return -1;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 239 */     return this._url;
/*     */   }
/*     */   
/*     */   public String getUser() {
/* 243 */     return this._user;
/*     */   }
/*     */   
/*     */   public boolean getValidateConnectionOnBorrow() {
/* 247 */     return this._validateConnectionOnBorrow;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCConnectionTemplate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */