/*     */ package dtv.pos.framework.event;
/*     */ 
/*     */ import dtv.pos.framework.logging.ProcessLogger;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventActionMapConfig
/*     */   extends AbstractParentConfig
/*     */   implements ISavableConfig
/*     */ {
/*     */   public static final String MAIN_TAG = "EventActionMap";
/*     */   public static final String MAIN_DTYPE = "EventActionMap";
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String EVENT_MAP_ID_TAG = "EventMapId";
/*  32 */   private final List<EventActionConfig> eventActionConfigList_ = new ArrayList<>();
/*     */   
/*     */   @Inject
/*     */   private ProcessLogger _flowLogger;
/*     */   
/*     */   private String _eventMapId;
/*     */   private List<IXstEventMatcher> _eventActionMatcherList;
/*     */   
/*     */   public IXstAction getAction(IXstEvent argEvent) {
/*  41 */     InjectionHammer.forceAtInjectProcessing(this);
/*  42 */     IXstAction action = null;
/*  43 */     initialize();
/*     */     
/*  45 */     for (int i = 0; i < this._eventActionMatcherList.size(); i++) {
/*  46 */       IXstEventMatcher matcher = this._eventActionMatcherList.get(i);
/*     */       
/*  48 */       if (matcher.matches(argEvent)) {
/*  49 */         action = matcher.getAction();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  54 */     if (action == null) {
/*  55 */       this._flowLogger.warn("Event", argEvent.getType(), (IHasSourceDescription)this, "X", " -> ???");
/*     */     } else {
/*     */       
/*  58 */       this._flowLogger.info("Event", argEvent.getType(), (IHasSourceDescription)this, " ", " -> " + action.getActionKey());
/*     */     } 
/*     */     
/*  61 */     return action;
/*     */   }
/*     */   
/*     */   public String getMapId() {
/*  65 */     return this._eventMapId;
/*     */   }
/*     */   
/*     */   public void initialize() {
/*  69 */     if (this._eventActionMatcherList == null) {
/*  70 */       this._eventActionMatcherList = new ArrayList<>();
/*     */       
/*  72 */       for (EventActionConfig c : this.eventActionConfigList_) {
/*  73 */         this._eventActionMatcherList.add(c.getEventMatcher());
/*     */       }
/*     */       
/*  76 */       Collections.sort(this._eventActionMatcherList, new XstEventMatcherComparator());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  82 */     if ("name".equalsIgnoreCase(argKey) || "EventMapId".equals(argKey)) {
/*  83 */       this._eventMapId = argValue.toString();
/*     */     }
/*  85 */     else if (argValue instanceof EventActionConfig) {
/*  86 */       this.eventActionConfigList_.add((EventActionConfig)argValue);
/*     */     } else {
/*     */       
/*  89 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/*  97 */     argWriter.writeHeader("EventActionMap", "EventActionMap", "name=\"" + this._eventMapId + "\"");
/*  98 */     argWriter.writeValue(this.eventActionConfigList_
/*  99 */         .<ISavableConfig>toArray((ISavableConfig[])new EventActionConfig[this.eventActionConfigList_.size()]));
/* 100 */     argWriter.writeFooter("EventActionMap");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\EventActionMapConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */