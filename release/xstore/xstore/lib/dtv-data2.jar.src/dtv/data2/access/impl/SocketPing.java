/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.datasource.config.IPing;
/*     */ import dtv.util.DtvThreadFactory;
/*     */ import dtv.util.StringUtils;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Properties;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SocketPing
/*     */   implements IPing
/*     */ {
/*  30 */   private static final Logger _logger = Logger.getLogger(SocketPing.class);
/*     */   
/*  32 */   private ExecutorService _executor = null;
/*  33 */   private String _host = null;
/*  34 */   private int _port = 0;
/*  35 */   private int _timeout = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SocketPing() {
/*  42 */     this._port = getDefaultPort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHost() {
/*  51 */     return this._host;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/*  60 */     return (this._port < 0) ? getDefaultPort() : this._port;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ping() {
/*  66 */     Future<Boolean> ping = this._executor.submit(new PingWorker());
/*     */     
/*     */     try {
/*  69 */       return ((Boolean)ping.get(this._timeout, TimeUnit.MILLISECONDS)).booleanValue();
/*     */     }
/*  71 */     catch (TimeoutException ex) {
/*  72 */       ping.cancel(true);
/*  73 */       _logger.info("We forcefully aborted our ping of [" + this._host + ":" + this._port + "]");
/*     */     }
/*  75 */     catch (Exception ex) {
/*  76 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProperties) {
/*  84 */     this._host = argProperties.getProperty("Host");
/*  85 */     if (this._host == null) {
/*  86 */       _logger.error("No host string specified");
/*     */     }
/*     */     
/*  89 */     String portString = argProperties.getProperty("Port");
/*  90 */     if (StringUtils.isPositiveNumber(portString)) {
/*  91 */       this._port = Integer.valueOf(portString).intValue();
/*     */     } else {
/*     */       
/*  94 */       _logger.error("No port configured or invalid: " + portString);
/*     */     } 
/*     */     
/*  97 */     String timeoutString = argProperties.getProperty("Timeout");
/*  98 */     if (timeoutString != null) {
/*  99 */       if (StringUtils.isPositiveNumber(timeoutString)) {
/* 100 */         this._timeout = Integer.valueOf(timeoutString).intValue();
/*     */       } else {
/*     */         
/* 103 */         _logger.error("Invalid timeout specified: " + timeoutString);
/*     */       } 
/*     */     }
/* 106 */     this._executor = Executors.newSingleThreadExecutor((ThreadFactory)DtvThreadFactory.make("SocketPing[" + this._host + ":" + this._port + "]"));
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
/*     */   protected InetSocketAddress createSocketAddress() throws UnknownHostException {
/* 118 */     return new InetSocketAddress(InetAddress.getByName(getHost()), getPort());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDefaultPort() {
/* 126 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getTimeout() {
/* 134 */     return this._timeout;
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
/*     */   protected boolean pingImpl() throws Exception {
/* 146 */     Socket s = new Socket(Proxy.NO_PROXY);
/* 147 */     s.connect(createSocketAddress(), getTimeout());
/* 148 */     s.shutdownOutput();
/* 149 */     s.close();
/*     */     
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private class PingWorker
/*     */     implements Callable<Boolean>
/*     */   {
/*     */     private PingWorker() {}
/*     */     
/*     */     public Boolean call() {
/* 161 */       boolean success = false;
/* 162 */       Exception failureEx = null;
/*     */       
/* 164 */       long startTime = SocketPing._logger.isInfoEnabled() ? System.currentTimeMillis() : 0L;
/*     */       try {
/* 166 */         SocketPing._logger.info("Starting ping @ " + startTime);
/* 167 */         success = SocketPing.this.pingImpl();
/*     */       }
/* 169 */       catch (Exception ex) {
/* 170 */         success = false;
/* 171 */         failureEx = ex;
/*     */       } 
/* 173 */       SocketPing._logger.info(success ? ("Ping suceeded! Time: " + (
/* 174 */           System.currentTimeMillis() - startTime)) : ("Ping failed! Time :" + (
/* 175 */           System.currentTimeMillis() - startTime) + " -- " + failureEx));
/*     */       
/* 177 */       return Boolean.valueOf(success);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\SocketPing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */