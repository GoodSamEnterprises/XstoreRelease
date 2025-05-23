/*    */ package dtv.data2.access.impl;
/*    */ 
/*    */ import java.net.DatagramSocket;
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
/*    */ public class DatagramSocketPing
/*    */   extends SocketPing
/*    */ {
/*    */   protected int getDefaultPort() {
/* 23 */     return 1434;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean pingImpl() throws Exception {
/* 31 */     DatagramSocket s = new DatagramSocket();
/* 32 */     s.setSoTimeout(getTimeout());
/* 33 */     s.connect(createSocketAddress());
/* 34 */     s.close();
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\DatagramSocketPing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */