/*    */ package dtv.pos.protocol.dtx;
/*    */ 
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.util.StringUtils;
/*    */ import java.io.IOException;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import java.net.URLStreamHandler;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */   extends URLStreamHandler
/*    */ {
/*    */   public static final String PROTOCOL = "dtx";
/*    */   
/*    */   public static URL make(IObjectId id, String argMethod) {
/* 33 */     String file = "/" + id.toString();
/* 34 */     if (!StringUtils.isEmpty(argMethod)) {
/* 35 */       file = file + "#" + argMethod;
/*    */     }
/*    */     
/*    */     try {
/* 39 */       return new URL("dtx", id.getClass().getName(), -1, file, new Handler());
/*    */     }
/* 41 */     catch (MalformedURLException ex) {
/*    */       
/* 43 */       throw new RuntimeException(ex);
/*    */     } 
/*    */   }
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
/*    */   
/*    */   protected URLConnection openConnection(URL u) throws IOException {
/* 58 */     return (URLConnection)new DtxURLConnection(u);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\dtx\Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */