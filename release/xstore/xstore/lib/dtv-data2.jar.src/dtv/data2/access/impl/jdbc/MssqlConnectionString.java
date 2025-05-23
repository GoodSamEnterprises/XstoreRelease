/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.util.StringUtils;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MssqlConnectionString
/*    */ {
/*    */   private static final String PREFIX = "jdbc:sqlserver://";
/* 20 */   private static final int PREFIX_LENGTH = "jdbc:sqlserver://".length();
/*    */ 
/*    */   
/*    */   private final String _host;
/*    */ 
/*    */   
/*    */   private final int _port;
/*    */ 
/*    */   
/*    */   private final Map<String, String> _params;
/*    */ 
/*    */   
/*    */   public MssqlConnectionString(String argConnectionString) {
/* 33 */     if (!argConnectionString.startsWith("jdbc:sqlserver://")) {
/* 34 */       throw new IllegalArgumentException();
/*    */     }
/*    */     
/* 37 */     int indexOfPropertiesSeparator = argConnectionString.indexOf(";");
/*    */     
/* 39 */     String hostAndPort = argConnectionString.substring(0, indexOfPropertiesSeparator).substring(PREFIX_LENGTH);
/*    */     
/* 41 */     if (hostAndPort.indexOf(":") != -1) {
/* 42 */       int indexOfPortSeparator = hostAndPort.indexOf(":");
/* 43 */       this._host = hostAndPort.substring(0, indexOfPortSeparator);
/* 44 */       this._port = Integer.parseInt(hostAndPort.substring(indexOfPortSeparator + 1));
/*    */     }
/*    */     else {
/*    */       
/* 48 */       this._host = hostAndPort;
/* 49 */       this._port = -1;
/*    */     } 
/*    */     
/* 52 */     Map<String, String> params = new HashMap<>();
/* 53 */     for (String p : StringUtils.split(argConnectionString.substring(indexOfPropertiesSeparator + 1), ';')) {
/* 54 */       String[] split = StringUtils.split(p, '=');
/* 55 */       params.put(split[0].toLowerCase(), split[1]);
/*    */     } 
/* 57 */     this._params = Collections.unmodifiableMap(params);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getHost() {
/* 67 */     return this._host;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getParameter(String argString) {
/* 77 */     return this._params.get(argString.toLowerCase());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPort() {
/* 86 */     return this._port;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\MssqlConnectionString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */