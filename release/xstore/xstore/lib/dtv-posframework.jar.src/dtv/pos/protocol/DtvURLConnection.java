/*    */ package dtv.pos.protocol;
/*    */ 
/*    */ import dtv.util.temp.InjectionHammer;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
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
/*    */ public abstract class DtvURLConnection
/*    */   extends URLConnection
/*    */ {
/*    */   public DtvURLConnection(URL argURL) {
/* 23 */     super(argURL);
/* 24 */     InjectionHammer.forceAtInjectProcessing(this);
/*    */   }
/*    */   
/*    */   public abstract void cancelGetContents();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\protocol\DtvURLConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */