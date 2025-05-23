/*     */ package dtv.data2;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.SQLException;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class SQLExceptionScrubber
/*     */ {
/*     */   private static final String SCRUB_POOL_STARTUP_EXPR = "(.+username = )(.+?(?=\\. ))(.*)";
/*     */   private static final String SCRUB_LOGIN_EXPR = "(?:login failed for user)";
/*     */   private static final String SCRUB_DRIVER_EXPR = "(?:No suitable driver found for)";
/*     */   private static final String SCRUB_URL_EXPR = "(?:sql exception occurred.*Url:)";
/*     */   private static final String SCRUBBED_ERROR_MSG = "[REDACTED]";
/*     */   private static final Pattern _scrubPattern;
/*     */   
/*     */   static {
/*  38 */     String scrubPhrases = "((" + "(?:login failed for user)" + "|" + "(?:No suitable driver found for)" + "|" + "(?:sql exception occurred.*Url:)" + ")\\s*)";
/*     */     
/*  40 */     _scrubPattern = Pattern.compile(scrubPhrases + ".+", 2);
/*  41 */   } private static final Pattern _poolStartupScrubPattern = Pattern.compile("(.+username = )(.+?(?=\\. ))(.*)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SQLException scrub(SQLException argEx) {
/*  52 */     return (argEx instanceof ScrubbingException) ? argEx : new ScrubbingException(argEx);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String scrub(String argMessage) {
/*  62 */     if (argMessage == null) {
/*  63 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     String message = _scrubPattern.matcher(argMessage).replaceFirst("$1[REDACTED]");
/*  73 */     message = _poolStartupScrubPattern.matcher(message).replaceAll("$1[REDACTED]$3");
/*  74 */     return message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ScrubbingException
/*     */     extends SQLException
/*     */   {
/*     */     private static final long serialVersionUID = -2424320619798452338L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     private static final Pattern _toStringPattern = Pattern.compile(ScrubbingException.class.getName(), 18);
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
/*     */     ScrubbingException(SQLException argEx) {
/* 103 */       super(SQLExceptionScrubber.scrub(argEx.getMessage()), argEx.getSQLState(), argEx.getErrorCode(), argEx.getCause());
/*     */       
/* 105 */       if (argEx.getNextException() != null) {
/* 106 */         setNextException(SQLExceptionScrubber.scrub(argEx.getNextException()));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void printStackTrace(PrintStream argStream) {
/* 114 */       super.printStackTrace(new ScrubbingStream(argStream));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void printStackTrace(PrintWriter argWriter) {
/* 121 */       super.printStackTrace(new ScrubbingWriter(argWriter));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 129 */       return _toStringPattern.matcher(super.toString()).replaceAll(SQLException.class.getName());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private class ScrubbingStream
/*     */       extends PrintStream
/*     */     {
/*     */       ScrubbingStream(PrintStream argDelegate) {
/* 141 */         super(argDelegate);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void print(String argString) {
/* 147 */         super.print(SQLExceptionScrubber.scrub(argString));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private class ScrubbingWriter
/*     */       extends PrintWriter
/*     */     {
/*     */       ScrubbingWriter(PrintWriter argDelegate) {
/* 160 */         super(argDelegate);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void print(String argString) {
/* 166 */         super.print(SQLExceptionScrubber.scrub(argString));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\SQLExceptionScrubber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */