/*     */ package dtv.data2.access.impl;
/*     */ 
/*     */ import dtv.data2.access.datasource.config.IPing;
/*     */ import dtv.util.DtvThreadFactory;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Socket;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class CachingSocketPing
/*     */   implements IPing
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(CachingSocketPing.class);
/*     */   
/*  32 */   private static Map<String, InetSocketAddress> addressCache_ = new HashMap<>(8);
/*     */   private String host_;
/*     */   private int port_;
/*  35 */   private int timeout_ = 0;
/*     */   
/*     */   private ExecutorService executor_;
/*     */   
/*     */   public InetSocketAddress getAddress(String argHost, int argPort) {
/*  40 */     StringBuilder buff = new StringBuilder(24);
/*  41 */     buff.append(argHost).append(':').append(argPort);
/*  42 */     String key = buff.toString();
/*     */     
/*  44 */     if (addressCache_.containsKey(key)) {
/*  45 */       return addressCache_.get(key);
/*     */     }
/*     */     
/*  48 */     long startTime = logger_.isInfoEnabled() ? System.currentTimeMillis() : 0L;
/*     */     try {
/*  50 */       InetSocketAddress address = new InetSocketAddress(this.host_, this.port_);
/*     */       
/*  52 */       long endTime = logger_.isInfoEnabled() ? System.currentTimeMillis() : 0L;
/*     */       
/*  54 */       if (logger_.isInfoEnabled()) {
/*  55 */         logger_.info("Time to create address [" + address + "]: " + (endTime - startTime) + " ms.");
/*     */       }
/*  57 */       addressCache_.put(key, address);
/*  58 */       return address;
/*     */     }
/*  60 */     catch (Exception ee) {
/*  61 */       logger_.warn("Failed to create InetSocketAddress for host: " + this.host_ + " port: " + this.port_, ee);
/*     */       
/*  63 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHost() {
/*  69 */     return this.host_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPort() {
/*  74 */     return this.port_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ping() {
/*  80 */     long startTime = System.currentTimeMillis();
/*     */     
/*  82 */     InetSocketAddress address = getAddress(this.host_, this.port_);
/*  83 */     if (address == null) {
/*  84 */       if (logger_.isInfoEnabled()) {
/*  85 */         logger_
/*  86 */           .info("Ping failed because we could not get an address for host: " + this.host_ + " port: " + this.port_);
/*     */       }
/*  88 */       return false;
/*     */     } 
/*     */     
/*  91 */     Future<Boolean> ping = this.executor_.submit(new PingWorker(address));
/*     */     try {
/*  93 */       return ((Boolean)ping.get(this.timeout_, TimeUnit.MILLISECONDS)).booleanValue();
/*     */     }
/*  95 */     catch (TimeoutException ex) {
/*  96 */       ping.cancel(true);
/*  97 */       if (logger_.isInfoEnabled()) {
/*  98 */         logger_.info("We forcefully aborted our ping of host: " + this.host_ + " port: " + this.port_);
/*     */       }
/*     */     }
/* 101 */     catch (Exception ex) {
/* 102 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } finally {
/*     */       
/* 105 */       if (logger_.isInfoEnabled()) {
/* 106 */         logger_.info("TIME TO PING: " + (System.currentTimeMillis() - startTime) + " host: " + this.host_ + " port: " + this.port_);
/*     */       }
/*     */     } 
/*     */     
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(Properties argProperties) {
/* 116 */     this.host_ = argProperties.getProperty("Host");
/* 117 */     if (this.host_ == null) {
/* 118 */       logger_.error("No host string specified");
/*     */     }
/*     */     
/* 121 */     String portString = argProperties.getProperty("Port");
/* 122 */     if (StringUtils.isPositiveNumber(portString)) {
/* 123 */       this.port_ = Integer.valueOf(portString).intValue();
/*     */     } else {
/*     */       
/* 126 */       logger_.error("No port configured or invalid: " + portString);
/* 127 */       this.port_ = -1;
/*     */     } 
/*     */     
/* 130 */     String timeoutString = argProperties.getProperty("Timeout");
/* 131 */     if (timeoutString != null) {
/* 132 */       if (StringUtils.isPositiveNumber(timeoutString)) {
/* 133 */         this.timeout_ = Integer.valueOf(timeoutString).intValue();
/*     */       } else {
/*     */         
/* 136 */         logger_.error("Invalid timeout specified: " + timeoutString);
/*     */       } 
/*     */     }
/* 139 */     this
/* 140 */       .executor_ = Executors.newSingleThreadExecutor((ThreadFactory)DtvThreadFactory.make("SocketPing[" + this.host_ + ":" + this.port_ + "]"));
/*     */   }
/*     */   
/*     */   private class PingWorker
/*     */     implements Callable<Boolean> {
/*     */     private final InetSocketAddress addr_;
/*     */     
/*     */     PingWorker(InetSocketAddress argAddress) {
/* 148 */       this.addr_ = argAddress;
/*     */     }
/*     */ 
/*     */     
/*     */     public Boolean call() {
/* 153 */       if (CachingSocketPing.logger_.isInfoEnabled()) {
/* 154 */         CachingSocketPing.logger_.info("ping thread for host: " + CachingSocketPing.this.host_ + " port: " + CachingSocketPing.this.port_ + " running...");
/*     */       }
/* 156 */       Socket socket = new Socket();
/*     */       try {
/* 158 */         socket.setPerformancePreferences(1, 0, 0);
/*     */         
/* 160 */         if (CachingSocketPing.logger_.isInfoEnabled()) {
/* 161 */           CachingSocketPing.logger_.info("ping of [" + this.addr_ + "] with timeout " + CachingSocketPing.this.timeout_ + "ms begun...");
/*     */         }
/*     */         
/* 164 */         socket.connect(this.addr_, CachingSocketPing.this.timeout_);
/* 165 */         if (CachingSocketPing.logger_.isInfoEnabled()) {
/* 166 */           CachingSocketPing.logger_.info("ping succeeded for [" + this.addr_ + "], host: " + CachingSocketPing.this.host_ + " port: " + CachingSocketPing.this.port_);
/*     */         }
/*     */         
/* 169 */         return Boolean.TRUE;
/*     */       }
/* 171 */       catch (Throwable ex) {
/* 172 */         if (CachingSocketPing.logger_.isInfoEnabled()) {
/* 173 */           CachingSocketPing.logger_.info("ping failed for [" + this.addr_ + "], host: " + CachingSocketPing.this.host_ + " port: " + CachingSocketPing.this.port_, ex);
/*     */         }
/* 175 */         return Boolean.FALSE;
/*     */       } finally {
/*     */         
/*     */         try {
/* 179 */           socket.close();
/*     */         }
/* 181 */         catch (IOException ex) {
/* 182 */           CachingSocketPing.logger_.warn("Error closing the socket in the ping worker.");
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\CachingSocketPing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */