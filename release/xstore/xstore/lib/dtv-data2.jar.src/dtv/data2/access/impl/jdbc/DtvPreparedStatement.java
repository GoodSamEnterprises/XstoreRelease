/*     */ package dtv.data2.access.impl.jdbc;
/*     */ 
/*     */ import dtv.data2.security.DtvSecurityManager;
/*     */ import dtv.util.StringUtils;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ final class DtvPreparedStatement
/*     */   implements InvocationHandler
/*     */ {
/*  29 */   private static final Logger DEFAULT_LOG = Logger.getLogger(DtvPreparedStatement.class);
/*  30 */   private static final Logger INSERT_LOG = Logger.getLogger(DtvPreparedStatement.class.getName() + ".INSERT");
/*  31 */   private static final Logger UPDATE_LOG = Logger.getLogger(DtvPreparedStatement.class.getName() + ".UPDATE");
/*  32 */   private static final Logger SELECT_LOG = Logger.getLogger(DtvPreparedStatement.class.getName() + ".SELECT");
/*  33 */   private static final Logger DELETE_LOG = Logger.getLogger(DtvPreparedStatement.class.getName() + ".DELETE");
/*     */ 
/*     */   
/*     */   private static final String DEBUG_INCLUDES_STACKS_PROP = "dtv.data2.access.impl.jdbc.DtvPreparedStatement.StackTrace";
/*     */   
/*  38 */   private static final boolean REPORT_ILLEGAL_ACCESS = Boolean.getBoolean(DtvPreparedStatement.class.getName() + ".ReportIllegalAccess");
/*     */   private final Logger _logger;
/*     */   private final Statement _statement;
/*     */   private final String _datasourceName;
/*     */   
/*     */   public static <T extends Statement> T adapt(T argStatement, String argSql, String argDatasourceName) {
/*  44 */     return (T)Proxy.newProxyInstance(DtvPreparedStatement.class
/*  45 */         .getClassLoader(), argStatement
/*  46 */         .getClass().getInterfaces(), new DtvPreparedStatement((Statement)argStatement, argSql, argDatasourceName));
/*     */   }
/*     */ 
/*     */   
/*     */   private static Logger getLogger(String argSql) {
/*     */     try {
/*  52 */       switch (argSql.charAt(0)) {
/*     */         case 'I':
/*     */         case 'i':
/*  55 */           return INSERT_LOG;
/*     */         case 'U':
/*     */         case 'u':
/*  58 */           return UPDATE_LOG;
/*     */         case 'D':
/*     */         case 'd':
/*  61 */           return DELETE_LOG;
/*     */         case 'S':
/*     */         case 's':
/*  64 */           return SELECT_LOG;
/*     */       } 
/*     */     
/*  67 */     } catch (Exception ex) {
/*  68 */       DEFAULT_LOG.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*  70 */     return DEFAULT_LOG;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private String _sql = "";
/*  77 */   private List<Object> _parameters = new ArrayList(6);
/*  78 */   private long _startTimeNanos = 0L;
/*     */   private boolean _cancelApplicable = false;
/*     */   private final Level _logAtLevel;
/*     */   
/*     */   private DtvPreparedStatement(Statement argStatement, String argSql, String argDatasourceName) {
/*  83 */     if (StringUtils.isEmpty(argSql)) {
/*  84 */       throw new IllegalArgumentException("SQL is required");
/*     */     }
/*  86 */     this._logger = getLogger(argSql);
/*  87 */     this._statement = argStatement;
/*  88 */     this._datasourceName = argDatasourceName;
/*  89 */     this._sql = argSql;
/*     */     
/*  91 */     this._logAtLevel = logAtLevel();
/*  92 */     this._parameters = Level.OFF.equals(this._logAtLevel) ? null : new ArrayList(6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invoke(Object argProxy, Method argMethod, Object[] argArgs) throws Throwable {
/*     */     try {
/* 100 */       String methodName = argMethod.getName();
/* 101 */       if (methodName.startsWith("set")) {
/* 102 */         _set(argMethod, argArgs, methodName);
/*     */       } else {
/*     */         
/* 105 */         switch (methodName) {
/*     */           case "cancel":
/* 107 */             if (!this._cancelApplicable) {
/* 108 */               return null;
/*     */             }
/* 110 */             this._cancelApplicable = false;
/*     */             break;
/*     */           case "clearParameters":
/* 113 */             _clearParameters();
/*     */             break;
/*     */           case "execute":
/*     */           case "executeQuery":
/*     */           case "executeUpdate":
/*     */           case "executeBatch":
/* 119 */             _execute(argArgs);
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/*     */       try {
/* 127 */         return argMethod.invoke(this._statement, argArgs);
/*     */       } finally {
/*     */         
/* 130 */         if (this._cancelApplicable) {
/* 131 */           log(methodName);
/* 132 */           this._cancelApplicable = false;
/*     */         }
/*     */       
/*     */       } 
/* 136 */     } catch (InvocationTargetException ex) {
/* 137 */       throw ex.getTargetException();
/*     */     }
/* 139 */     catch (AbstractMethodError er) {
/* 140 */       throw new UnsupportedOperationException(argMethod + " is not supported for " + this._statement
/* 141 */           .getClass().getName(), er);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 147 */     ToStringBuilder tsb = new ToStringBuilder(this);
/* 148 */     tsb.append("sql", "\"" + getPrettySql() + "\"");
/* 149 */     return tsb.build();
/*     */   }
/*     */   
/*     */   private void _clearParameters() {
/* 153 */     if (this._parameters != null) {
/* 154 */       this._parameters.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private void _execute(Object[] argArgs) {
/* 159 */     this._cancelApplicable = true;
/* 160 */     if (argArgs != null && argArgs.length > 0 && argArgs[0] == String.class) {
/* 161 */       this._sql = argArgs[0].toString();
/*     */     }
/* 163 */     if (this._logger.isDebugEnabled()) {
/* 164 */       this._startTimeNanos = System.nanoTime();
/*     */     }
/*     */   }
/*     */   
/*     */   private void _set(Method argMethod, Object[] argArgs, String methodName) {
/* 169 */     if (this._parameters != null) {
/* 170 */       if ("setNull".equals(methodName)) {
/* 171 */         this._parameters.add(null);
/*     */       }
/* 173 */       else if (argMethod.getParameterCount() > 1 && argMethod
/* 174 */         .getParameterTypes()[0] == int.class) {
/* 175 */         this._parameters.add(argArgs[1]);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private String getPrettySql() {
/* 181 */     return PreparedStatementTranslator.getPrettySql(this._sql, this._parameters);
/*     */   }
/*     */   private void log(String argDescription) {
/*     */     Throwable throwable;
/* 185 */     if (Level.OFF.equals(this._logAtLevel)) {
/*     */       return;
/*     */     }
/*     */     
/* 189 */     if (Level.DEBUG.equals(this._logAtLevel) && !Boolean.getBoolean("dtv.data2.access.impl.jdbc.DtvPreparedStatement.StackTrace")) {
/* 190 */       throwable = null;
/*     */     } else {
/*     */       
/* 193 */       throwable = new Throwable("STACK TRACE");
/*     */     } 
/*     */     
/* 196 */     double msElapsed = (System.nanoTime() - this._startTimeNanos) / 1000000.0D;
/* 197 */     String msg = String.format("%1$s [%2$7.3f ms %3$s] %4$s", new Object[] { argDescription, Double.valueOf(msElapsed), this._datasourceName, 
/* 198 */           PreparedStatementTranslator.getPrettySql(this._sql, this._parameters) });
/*     */     
/* 200 */     this._logger.log((Priority)this._logAtLevel, msg, throwable);
/*     */   }
/*     */   
/*     */   private Level logAtLevel() {
/* 204 */     if (REPORT_ILLEGAL_ACCESS && 
/* 205 */       SwingUtilities.isEventDispatchThread() && 
/* 206 */       !DtvSecurityManager.getInstance().isAllowed("DbAccessFromUiThread")) {
/* 207 */       return Level.WARN;
/*     */     }
/* 209 */     if (this._logger.isDebugEnabled()) {
/* 210 */       return Level.DEBUG;
/*     */     }
/* 212 */     return Level.OFF;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\DtvPreparedStatement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */