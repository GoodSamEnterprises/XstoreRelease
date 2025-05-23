/*    */ package dtv.data2.access;
/*    */ 
/*    */ import dtv.event.Event;
/*    */ import dtv.event.EventDescriptor;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.EventHandler;
/*    */ import dtv.event.EventManager;
/*    */ import dtv.event.Eventor;
/*    */ import dtv.event.IEventAware;
/*    */ import dtv.event.IEventConstraint;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.constraint.NameConstraint;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelEventor
/*    */   extends Eventor
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   public static final EventDescriptor EVENT_DESCRIPTOR = new EventDescriptor(ModelEventor.class);
/*    */   
/*    */   public static final String PRIVILEGED_EVENT_DESCRIPTOR_NAME = "PrivilegedEventDescriptor";
/*    */   
/* 26 */   public static final EventEnum CLOSE_EVENT = new EventEnum("EVENT_CLOSE_MODEL_EVENTORS");
/* 27 */   public static final EventEnum OPEN_EVENT = new EventEnum("EVENT_OPEN_MODEL_EVENTORS");
/*    */   
/*    */   protected boolean passing_ = true;
/*    */   
/*    */   protected Eventor _privilegedEventor;
/*    */   
/*    */   private IDataModel _eventSource;
/*    */   
/* 35 */   protected IEventAware _closeHandler = (IEventAware)new EventHandler()
/*    */     {
/*    */       protected void handle(Event argEvent) {
/* 38 */         ModelEventor.this.passing_ = false;
/*    */       }
/*    */     };
/*    */   
/* 42 */   private IEventAware _openHandler = (IEventAware)new EventHandler()
/*    */     {
/*    */       protected void handle(Event argEvent) {
/* 45 */         ModelEventor.this.passing_ = true;
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ModelEventor(IDataModel argSource, EventManager argEventManager) {
/* 54 */     super(argSource);
/*    */     
/* 56 */     this._eventSource = argSource;
/* 57 */     EventDescriptor self = new EventDescriptor(ModelEventor.class);
/* 58 */     this._eventManager = argEventManager;
/* 59 */     EventManager em = (this._eventManager != null) ? this._eventManager : _staticEventManager;
/* 60 */     em.registerEventHandler(this._closeHandler, (IEventSource)self, (IEventConstraint)new NameConstraint(CLOSE_EVENT));
/* 61 */     em.registerEventHandler(this._openHandler, (IEventSource)self, (IEventConstraint)new NameConstraint(OPEN_EVENT));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void post(Object argEventName) {
/* 67 */     postEvent(argEventName, null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void post(Object argEventName, Object argPayload) {
/* 73 */     if (this._privilegedEventor == null) {
/* 74 */       EventDescriptor privilegedDescriptor = new EventDescriptor("PrivilegedEventDescriptor", this._eventSource);
/*    */       
/* 76 */       this._privilegedEventor = (Eventor)new DefaultEventor((IEventSource)privilegedDescriptor);
/*    */     } 
/*    */     
/* 79 */     this._privilegedEventor.post(argEventName, argPayload);
/*    */     
/* 81 */     if (this.passing_)
/* 82 */       postEvent(argEventName, argPayload); 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\ModelEventor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */