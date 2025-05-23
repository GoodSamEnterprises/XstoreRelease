/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import dtv.data2.SQLExceptionScrubber;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.pm.PersistenceManagerStatus;
/*     */ import dtv.data2.access.query.IQueryResource;
/*     */ import dtv.data2.access.status.StatusMgr;
/*     */ import dtv.data2.access.transaction.ITransactionalDataSource;
/*     */ import dtv.data2.access.transaction.TransactionToken;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public interface DBConnection
/*     */   extends ITransactionalDataSource, Connection, IQueryResource, IManagedConnection, ValidConnection
/*     */ {
/*     */   static DBConnection adapt(Connection argConnection, JDBCConnectionTemplate argTemplate, boolean argAutoCommit) {
/*  36 */     return _Proxy.adapt(argConnection, argTemplate, argAutoCommit);
/*     */   }
/*     */   
/*     */   public static class _Proxy
/*     */     implements InvocationHandler, ITransactionalDataSource, IQueryResource, IManagedConnection {
/*  41 */     private static final String RESOURCE_CLOSURE_DEBUG = DBConnection.class
/*  42 */       .getName() + ".ResourceClosureDebugEnabled";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     private static final boolean statementClosureDebugEnabled = Boolean.getBoolean(RESOURCE_CLOSURE_DEBUG);
/*  49 */     private static final Logger _logger = Logger.getLogger(DBConnection.class); private static final Class<?>[] DBCONN_INTERFACES; private final Connection _activeConnection;
/*     */     private final JDBCConnectionTemplate _template;
/*     */     
/*     */     static {
/*  53 */       Class<?>[] interfaces = DBConnection.class.getInterfaces();
/*  54 */       DBCONN_INTERFACES = new Class[interfaces.length + 1];
/*  55 */       DBCONN_INTERFACES[0] = DBConnection.class;
/*  56 */       System.arraycopy(interfaces, 0, DBCONN_INTERFACES, 1, interfaces.length);
/*     */     }
/*     */     private TransactionToken _associatedTransaction; private JDBCDataSourceMgr _myManager; private final int _queryTimeout;
/*     */     
/*     */     public static DBConnection adapt(Connection argConnection, JDBCConnectionTemplate argTemplate, boolean argAutoCommit) {
/*  61 */       return (DBConnection)Proxy.newProxyInstance(DBConnection.class
/*  62 */           .getClassLoader(), DBCONN_INTERFACES, new _Proxy(argConnection, argTemplate, argAutoCommit));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static void logUnclosedMessage(String argObjectType, StackTraceElement[] argStack) {
/*  68 */       StringBuilder stringBuilder = new StringBuilder();
/*  69 */       stringBuilder.append("Unclosed ").append(argObjectType).append(" detected.  This ")
/*  70 */         .append(argObjectType).append(" will be closed automatically.");
/*  71 */       if (argStack != null) {
/*  72 */         stringBuilder.append("\nCreator Stacktrace:\n");
/*  73 */         for (StackTraceElement stackElement : argStack) {
/*  74 */           stringBuilder.append("\t").append(stackElement).append("\n");
/*     */         }
/*     */       } else {
/*     */         
/*  78 */         stringBuilder
/*  79 */           .append(" Set system property " + RESOURCE_CLOSURE_DEBUG + "=true for more information.");
/*     */       } 
/*  81 */       _logger.error(stringBuilder);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean _isClosed = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     private Map<Statement, StackTraceElement[]> _openStatements = null;
/*     */     
/*     */     private final StackTraceElement[] _creationStackTrace;
/*     */     
/*     */     private _Proxy(Connection argConn, JDBCConnectionTemplate argTemplate, boolean argAutoCommit) {
/*  99 */       this._activeConnection = argConn;
/* 100 */       this._template = argTemplate;
/* 101 */       this._queryTimeout = argTemplate.getQueryTimeout();
/* 102 */       this._creationStackTrace = statementClosureDebugEnabled ? (new Throwable()).getStackTrace() : null;
/*     */       try {
/* 104 */         if (this._activeConnection.getAutoCommit() != argAutoCommit) {
/* 105 */           this._activeConnection.setAutoCommit(argAutoCommit);
/*     */         }
/*     */       }
/* 108 */       catch (SQLException ee) {
/* 109 */         throw new DBConnectionException("An exception occurred while setting JDBC connection auto commit to true for datasource: " + 
/*     */             
/* 111 */             getDataSourceName(), 
/* 112 */             SQLExceptionScrubber.scrub(ee));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void close() throws SQLException {
/* 120 */       processUnclosedStatements();
/* 121 */       completeTransaction();
/* 122 */       this._isClosed = true;
/* 123 */       this._activeConnection.close();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void commitPhase1(TransactionToken argTransToken) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void commitPhase2(TransactionToken argTransToken) {
/*     */       try {
/* 143 */         this._activeConnection.commit();
/*     */       }
/* 145 */       catch (SQLException ee) {
/* 146 */         throw new DBConnectionException("Attempt to commit database transaction failed: " + ee
/* 147 */             .getMessage() + " on: " + this, ee);
/*     */       } 
/* 149 */       completeTransaction();
/*     */     }
/*     */ 
/*     */     
/*     */     public TransactionToken getAssociatedTransaction() {
/* 154 */       return this._associatedTransaction;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDataSourceName() {
/* 160 */       return this._template.getDataSourceName();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object invoke(Object argProxy, Method argMethod, Object[] argArgs) throws Throwable {
/*     */       try {
/* 168 */         Object results = invoke(argMethod, argArgs);
/* 169 */         if (results instanceof Statement) {
/* 170 */           return adaptNewStatement(results, argMethod, argArgs);
/*     */         }
/* 172 */         return results;
/*     */       }
/* 174 */       catch (InvocationTargetException ex) {
/* 175 */         throw ex.getTargetException();
/*     */       }
/* 177 */       catch (AbstractMethodError er) {
/* 178 */         throw new UnsupportedOperationException(argMethod + " is not supported for " + this._activeConnection
/* 179 */             .getClass().getName(), er);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public synchronized void rollback(TransactionToken argToken) {
/*     */       try {
/* 190 */         this._activeConnection.rollback();
/*     */       }
/* 192 */       catch (SQLException ee) {
/*     */         
/* 194 */         if (!StatusMgr.getInstance().getDataSourceStatus(this._template.getDataSourceName()).equals(PersistenceManagerStatus.OFFLINE))
/*     */         {
/* 196 */           if (FailoverException.isFailover(ee)) {
/* 197 */             StatusMgr.getInstance().notifyOffline(this._template.getDataSourceName(), 
/* 198 */                 FailoverException.getNewException(ee, this._template.getDataSourceName()));
/*     */           } else {
/*     */             
/* 201 */             throw new DBConnectionException("Attempt to rollback database transaction failed: " + ee
/* 202 */                 .getMessage() + " on: " + this, ee);
/*     */           } 
/*     */         }
/*     */       } finally {
/*     */         
/* 207 */         completeTransaction();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void setAssociatedTransaction(TransactionToken argAssociatedTransaction) {
/* 213 */       if (this._associatedTransaction != null && argAssociatedTransaction != null && this._associatedTransaction != argAssociatedTransaction)
/*     */       {
/*     */         
/* 216 */         throw new DtxException("Class constraint of DBConnection violated. A connection cannot be associated with multiple transactions at the same time. on: " + this);
/*     */       }
/*     */ 
/*     */       
/* 220 */       this._associatedTransaction = argAssociatedTransaction;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setMyManager(JDBCDataSourceMgr argMyManager) {
/* 225 */       this._myManager = argMyManager;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 230 */       return getClass().getName() + " " + getDescription() + " @" + hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void finalize() throws Throwable {
/* 237 */       if (!_isClosed()) {
/* 238 */         logUnclosedMessage("connection", this._creationStackTrace);
/*     */         try {
/* 240 */           close();
/*     */         }
/* 242 */         catch (Throwable ex) {
/* 243 */           _logger.error("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */       } 
/*     */     }
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
/*     */     private boolean _isClosed() {
/* 267 */       return this._isClosed;
/*     */     }
/*     */     
/*     */     private Object adaptNewStatement(Object argStatement, Method argMethod, Object[] argArgs) throws SQLException {
/*     */       String sql;
/* 272 */       Statement statement = (Statement)argStatement;
/*     */       
/* 274 */       if (statement instanceof java.sql.PreparedStatement && argArgs != null && argArgs.length > 0 && argArgs[0] instanceof String) {
/*     */ 
/*     */         
/* 277 */         sql = String.valueOf(argArgs[0]);
/*     */       } else {
/*     */         
/* 280 */         sql = "null";
/*     */       } 
/* 282 */       statement.setQueryTimeout(this._queryTimeout);
/* 283 */       if (statementClosureDebugEnabled) {
/* 284 */         storeStatementDebugInfo(statement);
/*     */       }
/* 286 */       return DtvPreparedStatement.adapt(statement, sql, this._template.getDataSourceName());
/*     */     }
/*     */     
/*     */     private void completeTransaction() {
/*     */       try {
/* 291 */         if (this._myManager != null && this._associatedTransaction != null) {
/* 292 */           setAssociatedTransaction(null);
/* 293 */           setMyManager(null);
/* 294 */           this._isClosed = true;
/* 295 */           this._activeConnection.close();
/*     */         }
/*     */       
/* 298 */       } catch (SQLException e) {
/* 299 */         _logger.error("Attept to close connection failed: " + e.getMessage(), e);
/*     */       } 
/*     */     }
/*     */     
/*     */     private String getDescription() {
/* 304 */       return "Datasource: [" + this._template.getDataSourceName() + "] Driver: " + this._template
/* 305 */         .getConnectionFactoryClassName() + " Url: " + this._template.getUrl();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object invoke(Method argMethod, Object[] argArgs) throws ReflectiveOperationException {
/*     */       try {
/* 315 */         Method method = getClass().getMethod(argMethod.getName(), argMethod.getParameterTypes());
/* 316 */         if (method != null) {
/* 317 */           return method.invoke(this, argArgs);
/*     */         }
/*     */       }
/* 320 */       catch (NoSuchMethodException noSuchMethodException) {}
/* 321 */       return argMethod.invoke(this._activeConnection, argArgs);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void processUnclosedStatements() {
/* 330 */       if (statementClosureDebugEnabled && this._openStatements != null) {
/* 331 */         for (Map.Entry<Statement, StackTraceElement[]> entry : this._openStatements.entrySet()) {
/*     */           try {
/* 333 */             Statement statement = entry.getKey();
/* 334 */             if (!statement.isClosed()) {
/* 335 */               logUnclosedMessage("statement", entry.getValue());
/* 336 */               statement.close();
/*     */             }
/*     */           
/* 339 */           } catch (SQLException ex) {
/* 340 */             _logger.error("An exception occurred when asserting the state of a connection or closing it.", ex);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
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
/*     */     private void storeStatementDebugInfo(Statement argStatement) {
/* 357 */       if (statementClosureDebugEnabled) {
/* 358 */         if (this._openStatements == null) {
/* 359 */           this._openStatements = (Map)new HashMap<>();
/*     */         }
/* 361 */         this._openStatements.put(argStatement, (new Throwable()).getStackTrace());
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\DBConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */