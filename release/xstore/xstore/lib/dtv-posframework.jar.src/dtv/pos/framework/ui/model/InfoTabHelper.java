/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ import dtv.pos.framework.event.InfoChangeDescriptor;
/*    */ import javax.inject.Inject;
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
/*    */ public class InfoTabHelper
/*    */   implements IEventSource
/*    */ {
/*    */   @Inject
/*    */   private InfoChangeDescriptor _changeDescriptor;
/*    */   
/*    */   public void setTabUpdated(String argTab) {
/* 29 */     DefaultEventor defaultEventor = new DefaultEventor((IEventSource)this._changeDescriptor);
/* 30 */     InfoChangeDescriptor.InfoChangePayload payload = this._changeDescriptor.getPayload(argTab, 0);
/* 31 */     defaultEventor.post(this._changeDescriptor.getChangeEvent(), payload);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\InfoTabHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */