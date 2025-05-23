/*     */ package dtv.data2.access.exception;
/*     */ 
/*     */ import dtv.data2.access.impl.jdbc.JDBCException;
/*     */ import dtv.data2.replication.ReplicationException;
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
/*     */ public class FailoverException
/*     */   extends SpecialActionException
/*     */ {
/*     */   private static final long serialVersionUID = 5650137953877738642L;
/*  19 */   private static final ExceptionApplicableRule[] rules = new ExceptionApplicableRule[] { new ExceptionApplicableRule("Unsupported SQL type", null, false), new ExceptionApplicableRule(null, DtxException.class, false), new ExceptionApplicableRule(null, JDBCException.class, false), new ExceptionApplicableRule(null, ReplicationException.class, false), new ExceptionApplicableRule(null, UpdateNotEffectiveException.class, false), new ExceptionApplicableRule("connection"), new ExceptionApplicableRule("java.net"), new ExceptionApplicableRule("i/o error"), new ExceptionApplicableRule("ioexception"), new ExceptionApplicableRule("read timed out"), new ExceptionApplicableRule("no route to host"), new ExceptionApplicableRule("time out occurred"), new ExceptionApplicableRule("cannot open database"), new ExceptionApplicableRule("java.io.FileNotFoundException: http"), new ExceptionApplicableRule("No more data to read from socket"), new ExceptionApplicableRule("ORA-01033"), new ExceptionApplicableRule("ORA-00018"), new ExceptionApplicableRule("ORA-00020"), new ExceptionApplicableRule("Timeout waiting for reply"), new ExceptionApplicableRule("ORA-01034"), new ExceptionApplicableRule("ORA-01089"), new ExceptionApplicableRule("immediate shutdown in progress"), new ExceptionApplicableRule("ORA-01013"), new ExceptionApplicableRule("user requested cancel of current operation") };
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
/*     */   public static FailoverException getNewException(String argMessage, String argDataSourceName) {
/*  52 */     return new FailoverException(argMessage, argDataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FailoverException getNewException(String argMessage, Throwable argCause, String argDataSourceName) {
/*  58 */     if (argCause instanceof FailoverException) {
/*  59 */       return (FailoverException)argCause;
/*     */     }
/*     */     
/*  62 */     return new FailoverException(argMessage, argCause, argDataSourceName);
/*     */   }
/*     */   
/*     */   public static FailoverException getNewException(Throwable argCause, String argDataSourceName) {
/*  66 */     if (argCause instanceof FailoverException) {
/*  67 */       return (FailoverException)argCause;
/*     */     }
/*     */     
/*  70 */     return new FailoverException(argCause, argDataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isFailover(Throwable ex) {
/*  81 */     return (new FailoverException()).isApplicable(ex);
/*     */   }
/*     */   
/*     */   FailoverException(String argMessage, String argDataSourceName) {
/*  85 */     super(argMessage, argDataSourceName);
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
/*     */   FailoverException(String message, Throwable argCause, String argDataSourceName) {
/* 101 */     super(message, argCause, argDataSourceName);
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
/*     */   FailoverException(Throwable argCause, String argDataSourceName) {
/* 115 */     super(argCause, argDataSourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FailoverException() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExceptionApplicableRule[] getApplicableRules() {
/* 127 */     return rules;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\FailoverException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */