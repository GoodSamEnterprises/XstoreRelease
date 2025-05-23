/*     */ package dtv.pos.framework.event;
/*     */ 
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.event.IXstEventListener;
/*     */ import dtv.pos.iframework.event.IXstEventRouter;
/*     */ import dtv.pos.iframework.event.IXstEventType;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.DtvMultiStorage;
/*     */ import dtv.util.ObjectUtils;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XstEventRouter
/*     */   implements IXstEventRouter
/*     */ {
/*  25 */   private static final EventListenerKey ALL_KEY = new EventListenerKey();
/*     */   
/*  27 */   private static final Logger logger_ = Logger.getLogger(XstEventRouter.class);
/*  28 */   private static final boolean isDebugEnabled_ = logger_.isDebugEnabled();
/*     */ 
/*     */   
/*     */   private final DtvMultiStorage<EventListenerKey, IXstEventListener> evtList_;
/*     */   
/*     */   private IXstEventListener defaultHandler_;
/*     */ 
/*     */   
/*     */   private XstEventRouter() {
/*  37 */     if (isDebugEnabled_) {
/*  38 */       logger_.debug("Creating instance of event router");
/*     */     }
/*     */     
/*  41 */     this.evtList_ = new DtvMultiStorage();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(IXstEventListener argListener) {
/*  47 */     return addListener(argListener, ALL_KEY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(IXstEventListener argListener, Class<?> argEventInterface) {
/*  53 */     return addListener(argListener, new EventListenerKey(argEventInterface));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(IXstEventListener argListener, IXstEventType argType) {
/*  59 */     return addListener(argListener, new EventListenerKey(argType));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireEvent(IXstEvent argEvent) {
/*  65 */     ripHandleXstEvent(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleXstEvent(IXstEvent argEvent) {
/*  71 */     fireEvent(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeListener(IXstEventListener argListener) {
/*  77 */     return removeListener(argListener, ALL_KEY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeListener(IXstEventListener argListener, Class<?> argEventInterface) {
/*  83 */     return removeListener(argListener, new EventListenerKey(argEventInterface));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeListener(IXstEventListener argListener, IXstEventType argType) {
/*  89 */     return removeListener(argListener, new EventListenerKey(argType));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultEventHandler(IXstEventListener argListener) {
/*  95 */     this.defaultHandler_ = argListener;
/*     */   }
/*     */   
/*     */   private synchronized boolean addListener(IXstEventListener argListener, EventListenerKey key) {
/*     */     boolean added;
/* 100 */     if (!this.evtList_.containsValue(key, argListener)) {
/* 101 */       this.evtList_.put(key, argListener);
/* 102 */       added = true;
/* 103 */       if (isDebugEnabled_) {
/* 104 */         logger_.debug("Adding listener to event router " + argListener + " for " + key);
/*     */       }
/*     */     } else {
/*     */       
/* 108 */       added = false;
/* 109 */       if (isDebugEnabled_) {
/* 110 */         logger_.debug("Not adding listener to event router.  Already present " + argListener + " for " + key);
/*     */       }
/*     */     } 
/* 113 */     return added;
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized boolean notifyEventListeners(Set<IXstEventListener> argAlreadyNotified, EventListenerKey argKey, IXstEvent argEvent) {
/* 118 */     List<IXstEventListener> list = this.evtList_.getList(argKey);
/* 119 */     if (list == null || list.isEmpty()) {
/* 120 */       logger_.debug("no listeners on " + argKey);
/* 121 */       return false;
/*     */     } 
/* 123 */     if (logger_.isDebugEnabled()) {
/* 124 */       logger_.debug(list.size() + " listeners to notify");
/*     */     }
/*     */     
/* 127 */     int i = 0;
/* 128 */     for (IXstEventListener lis : list) {
/* 129 */       if (argAlreadyNotified.add(lis)) {
/* 130 */         if (isDebugEnabled_) {
/* 131 */           logger_.debug("Notifying listener #" + i++ + " (" + lis + ") of the occurrence of event " + argEvent);
/*     */         }
/*     */         
/* 134 */         lis.handleXstEvent(argEvent);
/*     */         continue;
/*     */       } 
/* 137 */       if (isDebugEnabled_) {
/* 138 */         logger_.debug("Skipping listener #" + i++ + " (" + lis + ") because already notified of " + argEvent);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized boolean notifyEventListenersByInterface(Set<IXstEventListener> argAlreadyNotified, IXstEvent argEvent) {
/* 148 */     boolean handled = false;
/* 149 */     for (Class<?> c : ObjectUtils.getClassesAndInterfaces(argEvent.getClass())) {
/* 150 */       EventListenerKey key = new EventListenerKey(c);
/* 151 */       handled = (handled || notifyEventListeners(argAlreadyNotified, key, argEvent));
/*     */     } 
/* 153 */     return handled;
/*     */   }
/*     */   
/*     */   private synchronized boolean removeListener(IXstEventListener argListener, EventListenerKey argKey) {
/* 157 */     Object result = Boolean.valueOf(this.evtList_.remove(argKey, argListener));
/* 158 */     if (isDebugEnabled_) {
/* 159 */       logger_.debug("Removing listener to event router " + argListener + " for " + argKey);
/*     */     }
/* 161 */     return (result != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ripHandleXstEvent(IXstEvent argEvent) {
/* 168 */     if (isDebugEnabled_) {
/* 169 */       logger_.debug("Notifying listeners registered explicitly for the event of type " + argEvent.getType());
/*     */     }
/* 171 */     Set<IXstEventListener> alreadyNotified = new HashSet<>();
/*     */     
/* 173 */     boolean handled = notifyEventListeners(alreadyNotified, new EventListenerKey(argEvent.getType()), argEvent);
/*     */ 
/*     */     
/* 176 */     logger_.debug("Notifying listeners registered explicitly by interface");
/*     */ 
/*     */     
/* 179 */     handled |= notifyEventListenersByInterface(alreadyNotified, argEvent);
/*     */ 
/*     */     
/* 182 */     if (!handled && this.defaultHandler_ != null) {
/* 183 */       logger_.debug("Notifying default event handler");
/* 184 */       this.defaultHandler_.handleXstEvent(argEvent);
/*     */     } 
/*     */ 
/*     */     
/* 188 */     if (isDebugEnabled_) {
/* 189 */       logger_.debug("Notifying listeners registered for all events -->> " + argEvent);
/*     */     }
/* 191 */     notifyEventListeners(alreadyNotified, ALL_KEY, argEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   static class EventListenerKey
/*     */     extends CompositeObject.ThreePiece<ListenerType, Class<?>, IXstEventType>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     EventListenerKey() {
/* 202 */       super(XstEventRouter.ListenerType.ANY, null, null);
/*     */     }
/*     */ 
/*     */     
/*     */     EventListenerKey(Class<?> c) {
/* 207 */       super(XstEventRouter.ListenerType.INTERFACE, c, null);
/*     */     }
/*     */ 
/*     */     
/*     */     EventListenerKey(IXstEventType t) {
/* 212 */       super(XstEventRouter.ListenerType.TYPE, null, t);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   enum ListenerType
/*     */   {
/* 219 */     ANY,
/*     */     
/* 221 */     INTERFACE,
/*     */     
/* 223 */     TYPE;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\XstEventRouter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */