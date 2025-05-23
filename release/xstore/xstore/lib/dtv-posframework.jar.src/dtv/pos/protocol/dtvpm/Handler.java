/*    */ package dtv.pos.protocol.dtvpm;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */   extends URLStreamHandler
/*    */ {
/*    */   public static final String PROTOCOL = "dtvpm";
/*    */   
/*    */   protected URLConnection openConnection(URL u) throws IOException {
/* 36 */     return (URLConnection)new DtvPmURLConnection(u);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\dtvpm\Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */