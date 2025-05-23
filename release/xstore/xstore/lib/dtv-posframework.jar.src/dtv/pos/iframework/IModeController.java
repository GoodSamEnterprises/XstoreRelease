/*    */ package dtv.pos.iframework;
/*    */ 
/*    */ import dtv.event.EventDescriptor;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.constraint.Constraints;
/*    */ import dtv.event.constraint.NameConstraint;
/*    */ import dtv.event.constraint.PayloadClassConstraint;
/*    */ import dtv.pos.framework.ApplicationData;
/*    */ import dtv.pos.iframework.event.IXstEventRouter;
/*    */ import dtv.pos.iframework.ui.IUIController;
/*    */ import dtv.pos.iframework.ui.model.IStationModel;
/*    */ import dtv.ui.context.ContextManager;
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
/*    */ public interface IModeController
/*    */ {
/* 29 */   public static final EventEnum CHANGE_APPLICATION_MODE = new EventEnum("change applicationMode");
/*    */ 
/*    */   
/* 32 */   public static final IEventSource APPLICATION_MODE_DESCRIPTOR = (IEventSource)new EventDescriptor("applicationMode");
/*    */ 
/*    */ 
/*    */   
/* 36 */   public static final IEventConstraint CHANGE_MODE_CONSTRAINT = Constraints.and(new IEventConstraint[] { (IEventConstraint)new NameConstraint(CHANGE_APPLICATION_MODE), (IEventConstraint)new PayloadClassConstraint(ApplicationData.class) });
/*    */   
/*    */   void addErrorListener(IErrorListener paramIErrorListener);
/*    */   
/*    */   ContextManager getContextManager();
/*    */   
/*    */   void getDebugInfo(StringBuilder paramStringBuilder);
/*    */   
/*    */   IXstEventRouter getEventRouter();
/*    */   
/*    */   ApplicationData getModeData();
/*    */   
/*    */   IStationModel getStationModel();
/*    */   
/*    */   IUIController getUiController();
/*    */   
/*    */   void notifyErrorListeners(Throwable paramThrowable);
/*    */   
/*    */   void removeErrorListener(IErrorListener paramIErrorListener);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\IModeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */