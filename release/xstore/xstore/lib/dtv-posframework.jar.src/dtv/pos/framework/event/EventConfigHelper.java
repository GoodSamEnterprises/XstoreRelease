/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class EventConfigHelper
/*    */   extends ConfigHelper<EventConfigRoot>
/*    */ {
/*    */   private static final String CONFIG_FILE_NAME = "EventConfig";
/*    */   private static final String DEFAULT_MAP_ID = "DEFAULT";
/*    */   
/*    */   public EventActionMapConfig getDefaultActionMapping() {
/* 24 */     return ((EventConfigRoot)getRootConfig()).getEventMappingByMapId().get("DEFAULT");
/*    */   }
/*    */   
/*    */   public Map<String, EventActionMapConfig> getMappings() {
/* 28 */     return ((EventConfigRoot)getRootConfig()).getEventMappingByContext();
/*    */   }
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 33 */     super.initializeImpl();
/* 34 */     ((EventConfigRoot)getRootConfig()).initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 39 */     return "EventConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/* 45 */     if ("EventConfigRoot".equalsIgnoreCase(argDtype)) {
/* 46 */       return (IConfigObject)new EventConfigRoot();
/*    */     }
/* 48 */     if ("ContextEventMap".equalsIgnoreCase(argDtype) || "ContextMapping".equalsIgnoreCase(argDtype)) {
/* 49 */       return (IConfigObject)new ContextEventMapConfig();
/*    */     }
/* 51 */     if ("EventActionMap".equalsIgnoreCase(argDtype)) {
/* 52 */       return (IConfigObject)new EventActionMapConfig();
/*    */     }
/* 54 */     if ("EventAction".equalsIgnoreCase(argDtype)) {
/* 55 */       return (IConfigObject)new EventActionConfig();
/*    */     }
/* 57 */     if ("EventType".equalsIgnoreCase(argDtype) || "Event".equalsIgnoreCase(argDtype)) {
/* 58 */       return (IConfigObject)new EventTypeConfig();
/*    */     }
/*    */     
/* 61 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\EventConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */