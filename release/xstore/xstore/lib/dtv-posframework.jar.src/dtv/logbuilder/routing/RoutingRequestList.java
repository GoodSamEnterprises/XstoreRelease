/*    */ package dtv.logbuilder.routing;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ public class RoutingRequestList
/*    */   extends ArrayList<RoutingRequest>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String toString() {
/* 26 */     StringBuffer sb = new StringBuffer();
/* 27 */     sb.append("count=");
/* 28 */     sb.append(size());
/* 29 */     sb.append(", ");
/* 30 */     for (int i = 0; i < size(); i++) {
/* 31 */       sb.append(get(i));
/* 32 */       sb.append(", ");
/*    */     } 
/*    */     
/* 35 */     sb.setLength(sb.length() - 2);
/* 36 */     sb.append("]");
/* 37 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\routing\RoutingRequestList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */