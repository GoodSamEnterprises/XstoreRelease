/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ public class EventConfigRoot
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "EventConfigRoot";
/*    */   public static final String MAIN_DTYPE = "EventConfigRoot";
/* 26 */   private final List<ContextEventMapConfig> contextMappingList_ = new ArrayList<>();
/* 27 */   private final List<EventActionMapConfig> eventActionMapList_ = new ArrayList<>();
/*    */   
/*    */   private Map<String, EventActionMapConfig> mapByMapId_;
/*    */   private Map<String, EventActionMapConfig> mapByContext_;
/*    */   
/*    */   public Map<String, EventActionMapConfig> getEventMappingByContext() {
/* 33 */     return this.mapByContext_;
/*    */   }
/*    */   
/*    */   public Map<String, EventActionMapConfig> getEventMappingByMapId() {
/* 37 */     return this.mapByMapId_;
/*    */   }
/*    */   
/*    */   public void initialize() {
/* 41 */     if (this.mapByContext_ == null) {
/* 42 */       this.mapByMapId_ = new HashMap<>();
/*    */       
/* 44 */       for (EventActionMapConfig actionMap : this.eventActionMapList_) {
/* 45 */         this.mapByMapId_.put(actionMap.getMapId(), actionMap);
/*    */       }
/*    */       
/* 48 */       this.mapByContext_ = new HashMap<>();
/*    */       
/* 50 */       for (ContextEventMapConfig contextMapping : this.contextMappingList_) {
/* 51 */         this.mapByContext_.put(contextMapping.getContext(), this.mapByMapId_.get(contextMapping.getMapId()));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 59 */     if (argValue instanceof ContextEventMapConfig) {
/* 60 */       this.contextMappingList_.add((ContextEventMapConfig)argValue);
/*    */     }
/* 62 */     else if (argValue instanceof EventActionMapConfig) {
/* 63 */       this.eventActionMapList_.add((EventActionMapConfig)argValue);
/*    */     } else {
/*    */       
/* 66 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\EventConfigRoot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */