/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.crypto.DtvDecrypter;
/*     */ import dtv.util.crypto.IDtvDecrypter;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import oracle.ucp.UniversalConnectionPoolAdapter;
/*     */ import oracle.ucp.UniversalConnectionPoolException;
/*     */ import oracle.ucp.admin.UniversalConnectionPoolManager;
/*     */ import oracle.ucp.admin.UniversalConnectionPoolManagerImpl;
/*     */ import oracle.ucp.jdbc.JDBCConnectionPoolStatistics;
/*     */ import oracle.ucp.jdbc.PoolDataSource;
/*     */ import oracle.ucp.jdbc.PoolDataSourceFactory;
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
/*     */ class UcpConnectionProvider
/*     */   implements JDBCConnectionProvider
/*     */ {
/*  31 */   private static final Logger _logger = Logger.getLogger(UcpConnectionProvider.class);
/*     */   
/*     */   private static void appendProperties(StringBuilder sb, Object argTarget) {
/*  34 */     if (argTarget == null) {
/*     */       return;
/*     */     }
/*  37 */     Method[] declaredMethods = argTarget.getClass().getDeclaredMethods();
/*  38 */     for (Method method : declaredMethods) {
/*  39 */       if (method.getName().startsWith("get") && (method
/*  40 */         .getReturnType() == String.class || method.getReturnType() == int.class) && method
/*  41 */         .getParameterCount() == 0 && 
/*  42 */         !"getUser".equalsIgnoreCase(method.getName()))
/*     */       {
/*     */         
/*  45 */         if (!"getPassword".equalsIgnoreCase(method.getName())) {
/*     */           
/*     */           try {
/*     */             
/*  49 */             Object results = method.invoke(argTarget, new Object[0]);
/*  50 */             if (results != null) {
/*  51 */               sb.append("\n\t " + method.getName().substring(3) + "=" + results);
/*     */             }
/*     */           }
/*  54 */           catch (Throwable ex) {
/*  55 */             _logger.error("CAUGHT EXCEPTION", ex);
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private final String _datasourceName;
/*     */   private final PoolDataSource _pool;
/*     */   
/*     */   public UcpConnectionProvider(JDBCConnectionTemplate argTemplate) throws SQLException {
/*  67 */     PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
/*  68 */     pds.setConnectionFactoryClassName(argTemplate.getConnectionFactoryClassName());
/*     */ 
/*     */     
/*  71 */     pds.setConnectionPoolName(argTemplate.getDataSourceName());
/*  72 */     pds.setURL(argTemplate.getUrl());
/*     */     
/*  74 */     IDtvDecrypter decrypter = DtvDecrypter.getInstance("config");
/*  75 */     pds.setUser(decrypter.decryptIfEncrypted(argTemplate.getUser()));
/*  76 */     pds.setPassword(decrypter.decryptIfEncrypted(argTemplate.getPassword()));
/*     */ 
/*     */     
/*  79 */     pds.setMinPoolSize(argTemplate.getConnectionPoolMinSize());
/*  80 */     pds.setMaxPoolSize(argTemplate.getConnectionPoolMaxSize());
/*     */     
/*  82 */     boolean validateConnectionOnBorrow = argTemplate.getValidateConnectionOnBorrow();
/*  83 */     pds.setValidateConnectionOnBorrow(validateConnectionOnBorrow);
/*  84 */     String sqlForValidateConnection = argTemplate.getSqlForValidateConnection();
/*  85 */     if (validateConnectionOnBorrow && !StringUtils.isEmpty(sqlForValidateConnection)) {
/*  86 */       pds.setSQLForValidateConnection(sqlForValidateConnection);
/*     */     }
/*     */     
/*  89 */     pds.setMaxIdleTime(argTemplate.getConnectionMaxIdleTime());
/*  90 */     pds.setMaxConnectionReuseCount(argTemplate.getMaxConnectionReuseCount());
/*  91 */     pds.setMaxStatements(argTemplate.getPreparedStatementCacheMaxSize());
/*     */     
/*  93 */     pds.setConnectionWaitTimeout(argTemplate.getConnectionWaitTimeout());
/*     */ 
/*     */     
/*  96 */     int transactionIsolation = argTemplate.getTransactionIsolation();
/*  97 */     if (transactionIsolation != -1) {
/*  98 */       if (_logger.isDebugEnabled()) {
/*  99 */         _logger.debug("A transaction isolation level value of " + transactionIsolation + " was provided in DatasourceConfig for  the " + argTemplate
/* 100 */             .getDataSourceName() + " datasource.  Setting it on the pool.");
/*     */       }
/*     */ 
/*     */       
/* 104 */       pds.registerConnectionInitializationCallback(conn -> conn.setTransactionIsolation(transactionIsolation));
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 109 */       UniversalConnectionPoolManager ucpMgr = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();
/* 110 */       ucpMgr.createConnectionPool((UniversalConnectionPoolAdapter)pds);
/*     */     }
/* 112 */     catch (UniversalConnectionPoolException ex) {
/* 113 */       throw new SQLException("error registering connection pool", ex);
/*     */     } 
/*     */     
/* 116 */     this._pool = pds;
/* 117 */     this._datasourceName = argTemplate.getDataSourceName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 124 */       UniversalConnectionPoolManager ucpMgr = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();
/* 125 */       ucpMgr.stopConnectionPool(this._datasourceName);
/* 126 */       ucpMgr.destroyConnectionPool(this._datasourceName);
/*     */     }
/* 128 */     catch (UniversalConnectionPoolException ex) {
/* 129 */       _logger.error("CAUGHT EXCEPTION", (Throwable)ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 136 */     return this._pool.getConnection();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 141 */     return this._datasourceName;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPoolSize() {
/* 146 */     JDBCConnectionPoolStatistics statistics = this._pool.getStatistics();
/* 147 */     if (statistics != null) {
/* 148 */       return statistics.getTotalConnectionsCount();
/*     */     }
/*     */     try {
/* 151 */       return this._pool.getBorrowedConnectionsCount() + this._pool.getAvailableConnectionsCount();
/*     */     }
/* 153 */     catch (SQLException ex) {
/* 154 */       _logger.error("CAUGHT EXCEPTION", ex);
/* 155 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getStats() {
/* 161 */     StringBuilder sb = new StringBuilder(100);
/* 162 */     appendProperties(sb, this._pool.getStatistics());
/* 163 */     appendProperties(sb, this._pool);
/* 164 */     return sb;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\UcpConnectionProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */