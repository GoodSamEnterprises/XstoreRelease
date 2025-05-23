/*    */ package dtv.pos.framework.comm;
/*    */ 
/*    */ import dtv.util.message.Message;
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
/*    */ 
/*    */ public class NoTaskMessage
/*    */   extends Message
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   private static Map<String, String> createNoTaskMap() {
/* 23 */     Map<String, String> noTaskMap = new HashMap<>();
/* 24 */     noTaskMap.put("task", "NONE");
/* 25 */     return noTaskMap;
/*    */   }
/*    */   
/*    */   public NoTaskMessage(Object argSource) {
/* 29 */     super(argSource, createNoTaskMap());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\comm\NoTaskMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */