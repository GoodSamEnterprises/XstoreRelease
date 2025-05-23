/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.ui.config.IActionConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import dtv.util.config.ISavableConfig;
/*    */ import dtv.util.config.IXmlWriter;
/*    */ import dtv.util.config.IntegerConfig;
/*    */ import java.io.IOException;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventActionConfig
/*    */   extends AbstractParentConfig
/*    */   implements ISavableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   private static final Logger logger_ = Logger.getLogger(EventActionConfig.class);
/*    */   
/*    */   public static final String MAIN_TAG = "EventAction";
/*    */   
/*    */   public static final String MAIN_DTYPE = "EventAction";
/*    */   
/*    */   private EventTypeConfig event_;
/*    */   private ClassConfig<? extends IXstEvent> eventClass_;
/*    */   private IActionConfig action_;
/* 34 */   private int priority_ = 0;
/*    */   
/*    */   public IXstEventMatcher getEventMatcher() {
/* 37 */     if (this.event_ != null) {
/* 38 */       return new TypeXstEventMatcher(this.priority_, this.event_.getEventType(), this.action_);
/*    */     }
/* 40 */     if (this.eventClass_ != null) {
/* 41 */       return new InterfaceXstEventMatcher(this.priority_, this.eventClass_.getValue(), this.action_);
/*    */     }
/*    */     
/* 44 */     logger_.warn("no event type configured::" + getSourceDescription());
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 52 */     if (argValue instanceof EventTypeConfig) {
/* 53 */       this.event_ = (EventTypeConfig)argValue;
/*    */     }
/* 55 */     else if (argValue instanceof IActionConfig) {
/* 56 */       this.action_ = (IActionConfig)argValue;
/*    */     }
/* 58 */     else if ("EventType".equalsIgnoreCase(argKey)) {
/* 59 */       this.eventClass_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 61 */     else if (!"name".equalsIgnoreCase(argKey)) {
/*    */ 
/*    */       
/* 64 */       if ("priority".equalsIgnoreCase(argKey)) {
/* 65 */         if (argValue instanceof IntegerConfig) {
/* 66 */           this.priority_ = ((IntegerConfig)argValue).getInteger().intValue();
/*    */         } else {
/*    */           
/*    */           try {
/* 70 */             this.priority_ = Integer.parseInt(argValue.toString());
/*    */           }
/* 72 */           catch (Exception ex) {
/* 73 */             logger_.error("CAUGHT EXCEPTION with " + argValue, ex);
/*    */           } 
/*    */         } 
/*    */       } else {
/*    */         
/* 78 */         warnUnsupported(argKey, argValue);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(IXmlWriter argWriter) throws IOException {
/* 86 */     argWriter.writeHeader("EventAction", "EventAction", "priority=\"" + this.priority_ + "\"");
/* 87 */     argWriter.writeValue(this.event_);
/* 88 */     argWriter.writeValue("EventType", (IReflectionParameterCapable)this.eventClass_);
/* 89 */     argWriter.writeValue((ISavableConfig)this.action_);
/* 90 */     argWriter.writeFooter("EventAction");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\EventActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */