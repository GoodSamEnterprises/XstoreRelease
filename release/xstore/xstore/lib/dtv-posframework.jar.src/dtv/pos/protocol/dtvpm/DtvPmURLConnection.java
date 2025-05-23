/*     */ package dtv.pos.protocol.dtvpm;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.pos.protocol.DtvURLConnection;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.OutputToInputStream;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtvPmURLConnection
/*     */   extends DtvURLConnection
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DtvPmURLConnection.class);
/*     */   
/*     */   private final String idClass_;
/*     */   
/*     */   private final String idString_;
/*     */   private final String methodOnObject_;
/*     */   private Object content_;
/*     */   
/*     */   private static String fixClass(String argOldName) {
/*  35 */     return argOldName.replaceAll("dtv\\.pos\\.dao", "dtv.xst.dao");
/*     */   }
/*     */   
/*     */   private static MalformedURLException makeMalformedURLException(String argMessage, Throwable argCause) {
/*  39 */     MalformedURLException newEx = new MalformedURLException(argMessage);
/*  40 */     if (argCause != null) {
/*  41 */       newEx.initCause(argCause);
/*     */     }
/*  43 */     return newEx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean loaded_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Thread contentGettingThread_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DtvPmURLConnection(URL argUrl) throws IOException {
/*  66 */     super(argUrl);
/*     */ 
/*     */     
/*     */     try {
/*  70 */       String[] parts = argUrl.getPath().substring(1).split("/");
/*  71 */       if (parts.length > 2) {
/*  72 */         throw makeMalformedURLException("Too many separators: " + argUrl.toExternalForm(), null);
/*     */       }
/*  74 */       this.idClass_ = fixClass(parts[0]);
/*  75 */       this.idString_ = parts[1];
/*  76 */       if (!StringUtils.isEmpty(argUrl.getRef())) {
/*  77 */         this.methodOnObject_ = argUrl.getRef();
/*     */       } else {
/*     */         
/*  80 */         this.methodOnObject_ = "getData";
/*     */       }
/*     */     
/*  83 */     } catch (Exception ex) {
/*  84 */       throw makeMalformedURLException(argUrl.toExternalForm(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelGetContents() {
/*  91 */     Thread t = this.contentGettingThread_;
/*  92 */     if (t != null) {
/*  93 */       t.interrupt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() {
/* 103 */     this.connected = true;
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
/*     */   public synchronized Object getContent() throws IOException {
/* 118 */     if (!this.loaded_) {
/* 119 */       this.content_ = doGetContent();
/* 120 */       this.loaded_ = true;
/*     */     } 
/* 122 */     return this.content_;
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
/*     */   public InputStream getInputStream() throws IOException {
/*     */     try {
/* 136 */       Serializable o = (Serializable)getContent();
/* 137 */       return (InputStream)OutputToInputStream.makeForSerializable(o);
/*     */     }
/* 139 */     catch (IOException ex) {
/* 140 */       throw ex;
/*     */     }
/* 142 */     catch (Throwable ex) {
/* 143 */       IOException ioex = new IOException();
/* 144 */       ioex.initCause(ex);
/* 145 */       throw ioex;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object doGetContent() throws IOException {
/* 152 */     this.contentGettingThread_ = Thread.currentThread(); try {
/*     */       IObjectId id; Object dao;
/*     */       Method m;
/*     */       try {
/* 156 */         id = (IObjectId)ObjectUtils.createInstance(Class.forName(this.idClass_), new Class[] { String.class }, new Object[] { this.idString_ });
/*     */       
/*     */       }
/* 159 */       catch (ClassNotFoundException ex) {
/* 160 */         MalformedURLException newEx = new MalformedURLException(getURL().toExternalForm());
/* 161 */         newEx.initCause(ex);
/* 162 */         throw newEx;
/*     */       } 
/*     */       
/*     */       try {
/* 166 */         dao = DataFactory.getObjectById(id);
/*     */       }
/* 168 */       catch (ObjectNotFoundException ex) {
/* 169 */         FileNotFoundException newEx = new FileNotFoundException(getURL().toExternalForm());
/* 170 */         newEx.initCause((Throwable)ex);
/* 171 */         throw newEx;
/*     */       } 
/*     */       
/* 174 */       Class<? extends Object> daoClass = (Class)dao.getClass();
/*     */       
/*     */       try {
/* 177 */         m = daoClass.getMethod(this.methodOnObject_, new Class[0]);
/*     */       }
/* 179 */       catch (Exception ex) {
/*     */         
/* 181 */         logger_.warn("CAUGHT EXCEPTION", ex);
/* 182 */         return dao;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 201 */     catch (IOException ex) {
/* 202 */       IObjectId id; throw id;
/*     */     }
/* 204 */     catch (Throwable t) {
/* 205 */       IOException ioex = new IOException();
/* 206 */       ioex.initCause(t);
/* 207 */       throw ioex;
/*     */     } finally {
/*     */       
/* 210 */       this.contentGettingThread_ = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\dtvpm\DtvPmURLConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */