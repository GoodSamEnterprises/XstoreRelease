/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventSource;
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
/*    */ public class InfoChangeDescriptor
/*    */   implements IEventSource
/*    */ {
/* 19 */   private final EventEnum contentChangedEvent = new EventEnum("contentChanged");
/*    */   
/*    */   public EventEnum getChangeEvent() {
/* 22 */     return this.contentChangedEvent;
/*    */   }
/*    */   
/*    */   public InfoChangePayload getPayload(String argInfoId, int argCount) {
/* 26 */     return new InfoChangePayload(argInfoId, argCount);
/*    */   }
/*    */   
/*    */   public static class InfoChangePayload
/*    */   {
/*    */     private String _infoId;
/*    */     private int _objectCount;
/*    */     
/*    */     private InfoChangePayload(String argInfoId, int argObjectCount) {
/* 35 */       this._infoId = argInfoId;
/* 36 */       this._objectCount = argObjectCount;
/*    */     }
/*    */     
/*    */     public int getObjectCount() {
/* 40 */       return this._objectCount;
/*    */     }
/*    */     
/*    */     public String getInfoId() {
/* 44 */       return this._infoId;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\InfoChangeDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */