/*     */ package dtv.pos.protocol.dtx;
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
/*     */ public class DtxURLConnection
/*     */   extends DtvURLConnection
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DtxURLConnection.class); private final String idClass_;
/*     */   
/*     */   private static MalformedURLException makeMalformedURLException(String argMessage, Throwable argCause) {
/*  29 */     MalformedURLException newEx = new MalformedURLException(argMessage);
/*  30 */     if (argCause != null) {
/*  31 */       newEx.initCause(argCause);
/*     */     }
/*  33 */     return newEx;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final String idString_;
/*     */ 
/*     */   
/*     */   private final String methodOnObject_;
/*     */ 
/*     */   
/*     */   private Object content_;
/*     */ 
/*     */   
/*     */   private boolean loaded_ = false;
/*     */ 
/*     */   
/*     */   private Thread contentGettingThread_;
/*     */ 
/*     */ 
/*     */   
/*     */   public DtxURLConnection(URL argUrl) throws IOException {
/*  55 */     super(argUrl);
/*     */     
/*  57 */     this.idClass_ = argUrl.getAuthority();
/*     */     
/*     */     try {
/*  60 */       this.idString_ = argUrl.getPath().substring(1);
/*  61 */       if (!StringUtils.isEmpty(argUrl.getRef())) {
/*  62 */         this.methodOnObject_ = argUrl.getRef();
/*     */       } else {
/*     */         
/*  65 */         this.methodOnObject_ = "getData";
/*     */       }
/*     */     
/*  68 */     } catch (Exception ex) {
/*  69 */       throw makeMalformedURLException(argUrl.toExternalForm(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelGetContents() {
/*  76 */     Thread t = this.contentGettingThread_;
/*  77 */     if (t != null) {
/*  78 */       t.interrupt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() {
/*  88 */     this.connected = true;
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
/*     */   public synchronized Object getContent() throws IOException {
/* 102 */     if (!this.loaded_) {
/* 103 */       this.content_ = doGetContent();
/* 104 */       this.loaded_ = true;
/*     */     } 
/*     */     
/* 107 */     return this.content_;
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
/* 121 */       Serializable o = (Serializable)getContent();
/* 122 */       return (InputStream)OutputToInputStream.makeForSerializable(o);
/*     */     }
/* 124 */     catch (IOException ex) {
/* 125 */       throw ex;
/*     */     }
/* 127 */     catch (Throwable ex) {
/* 128 */       IOException ioex = new IOException();
/* 129 */       ioex.initCause(ex);
/* 130 */       throw ioex;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object doGetContent() throws IOException {
/* 137 */     this.contentGettingThread_ = Thread.currentThread(); try {
/*     */       IObjectId id; Object dao;
/*     */       Method m;
/*     */       try {
/* 141 */         id = (IObjectId)ObjectUtils.createInstance(Class.forName(this.idClass_), new Class[] { String.class }, new Object[] { this.idString_ });
/*     */       
/*     */       }
/* 144 */       catch (ClassNotFoundException ex) {
/* 145 */         MalformedURLException newEx = new MalformedURLException(getURL().toExternalForm());
/* 146 */         newEx.initCause(ex);
/* 147 */         throw newEx;
/*     */       } 
/*     */       
/*     */       try {
/* 151 */         dao = DataFactory.getObjectById(id);
/*     */       }
/* 153 */       catch (ObjectNotFoundException ex) {
/* 154 */         FileNotFoundException newEx = new FileNotFoundException(getURL().toExternalForm());
/* 155 */         newEx.initCause((Throwable)ex);
/* 156 */         throw newEx;
/*     */       } 
/*     */       
/* 159 */       Class<? extends Object> daoClass = (Class)dao.getClass();
/*     */       
/*     */       try {
/* 162 */         m = daoClass.getMethod(this.methodOnObject_, new Class[0]);
/*     */       }
/* 164 */       catch (Exception ex) {
/*     */         
/* 166 */         logger_.warn("CAUGHT EXCEPTION", ex);
/* 167 */         return dao;
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
/* 186 */     catch (IOException ex) {
/* 187 */       IObjectId id; throw id;
/*     */     }
/* 189 */     catch (Throwable t) {
/* 190 */       IOException ioex = new IOException();
/* 191 */       ioex.initCause(t);
/* 192 */       throw ioex;
/*     */     } finally {
/*     */       
/* 195 */       this.contentGettingThread_ = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\dtx\DtxURLConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */