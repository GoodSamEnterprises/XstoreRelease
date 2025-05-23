/*     */ package dtv.data2.dataserver;
/*     */ 
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Future;
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
/*     */ public class CommandAction
/*     */   extends AbstractAction
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(CommandAction.class);
/*     */   
/*     */   private static final String DATABASE_CREDENTIALS_PARAM = "DatabaseCredentials";
/*     */   
/*     */   private static final String USER_COMMAND_PARAM = "userName";
/*     */   private static final String PASSWORD_COMMAND_PARAM = "password";
/*     */   private String _databaseUserName;
/*     */   private String _databasePassword;
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  41 */       String imp = "impdp dtv/dtv directory=test_dir dumpfile=oraDbDump.dmp logfile=impdp_oraDb.log remap_schema=dtv:training table_exists_action=REPLACE";
/*     */ 
/*     */       
/*  44 */       Process p = Runtime.getRuntime().exec(imp);
/*  45 */       BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
/*  46 */       StringBuilder output = new StringBuilder();
/*     */       String line;
/*  48 */       while ((line = input.readLine()) != null) {
/*  49 */         output.append(line);
/*  50 */         System.out.println(line);
/*     */       } 
/*     */       
/*  53 */       input.close();
/*  54 */       System.out.println("process exit value = " + p.exitValue());
/*     */     }
/*  56 */     catch (Exception err) {
/*  57 */       err.printStackTrace();
/*     */     } 
/*     */     
/*  60 */     System.exit(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, Object argValue) {
/*  69 */     if ("DatabaseCredentials".equalsIgnoreCase(argName)) {
/*  70 */       String dataSource = argValue.toString();
/*  71 */       DataSourceDescriptor desc = DataSourceFactory.getInstance().getDataSourceDescriptor(dataSource);
/*  72 */       this._databaseUserName = desc.getProperties().getProperty("ConnectionUserName");
/*  73 */       this._databasePassword = desc.getProperties().getProperty("ConnectionPassword");
/*     */     } else {
/*     */       
/*  76 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object processImpl(Map<String, String> argParameters) throws Exception {
/*  85 */     boolean debugEnabled = _logger.isDebugEnabled();
/*  86 */     StringBuilder command = new StringBuilder(getValue());
/*     */ 
/*     */     
/*  89 */     argParameters.put("userName", this._databaseUserName);
/*  90 */     argParameters.put("password", this._databasePassword);
/*     */ 
/*     */     
/*  93 */     StringUtils.replaceVariables(command, argParameters);
/*     */ 
/*     */     
/*  96 */     Runtime runTime = Runtime.getRuntime();
/*  97 */     Process commandProcess = runTime.exec(command.toString());
/*  98 */     CommandStreamReader inputReader = new CommandStreamReader(commandProcess.getInputStream());
/*  99 */     CommandStreamReader errReader = new CommandStreamReader(commandProcess.getErrorStream());
/*     */     try {
/* 101 */       Future<String> input = inputReader.start();
/* 102 */       Future<String> err = errReader.start();
/*     */       try {
/* 104 */         inputReader.waitForBegin(5000L);
/* 105 */         errReader.waitForBegin(5000L);
/*     */       }
/* 107 */       catch (Exception ex) {
/* 108 */         _logger.warn("Error when starting a process input reader the exception is:", ex);
/*     */       } 
/*     */       
/* 111 */       int exitValue = commandProcess.waitFor();
/* 112 */       if (debugEnabled) {
/* 113 */         _logger.debug("Process output is:" + (String)input.get());
/* 114 */         _logger.debug("Process completed with exit value of [" + exitValue + "]");
/*     */       } 
/*     */       
/* 117 */       if (exitValue != 0)
/*     */       {
/* 119 */         throw new Exception((String)err.get());
/*     */       }
/*     */       
/* 122 */       return Integer.valueOf(exitValue);
/*     */     } finally {
/*     */       
/* 125 */       inputReader.stop();
/* 126 */       errReader.stop();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\CommandAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */