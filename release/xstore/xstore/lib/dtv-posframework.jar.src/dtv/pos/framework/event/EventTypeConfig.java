/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.pos.iframework.event.IXstEventType;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.IReflectionParameterCapable;
/*    */ import dtv.util.config.ISavableConfig;
/*    */ import dtv.util.config.IXmlWriter;
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.Method;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventTypeConfig
/*    */   extends AbstractParentConfig
/*    */   implements ISavableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   private static final Logger logger_ = Logger.getLogger(EventTypeConfig.class);
/*    */   
/*    */   public static final String MAIN_TAG = "Event";
/*    */   
/*    */   public static final String MAIN_DTYPE = "EventType";
/*    */   private static final String CLASS_TAG = "Class";
/*    */   private static final String VALUE_TAG = "Value";
/*    */   private ClassConfig eventClassConfig_;
/*    */   private String eventName_;
/*    */   
/*    */   public IXstEventType getEventType() {
/*    */     try {
/* 38 */       Method forNameMethod = null;
/*    */       try {
/* 40 */         forNameMethod = this.eventClassConfig_.getValue().getMethod("createForName", new Class[] { String.class });
/*    */       }
/* 42 */       catch (NoSuchMethodException ex) {
/* 43 */         logger_.debug("CAUGHT EXCEPTION", ex);
/*    */       } 
/* 45 */       if (forNameMethod == null) {
/* 46 */         forNameMethod = this.eventClassConfig_.getValue().getMethod("forName", new Class[] { String.class });
/*    */       }
/* 48 */       forNameMethod.getModifiers();
/* 49 */       Object o = forNameMethod.invoke(null, new Object[] { this.eventName_ });
/*    */       
/* 51 */       return (IXstEventType)o;
/*    */     }
/* 53 */     catch (Exception ex) {
/* 54 */       logger_.error("CAUGHT EXCEPTION", ex);
/* 55 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 61 */     if ("Class".equalsIgnoreCase(argKey) || argValue instanceof ClassConfig) {
/* 62 */       this.eventClassConfig_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 64 */     else if (argValue instanceof dtv.util.config.StringConfig) {
/* 65 */       this.eventName_ = argValue.toString();
/*    */     } else {
/*    */       
/* 68 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(IXmlWriter argWriter) throws IOException {
/* 76 */     argWriter.writeHeader("Event", "EventType");
/* 77 */     if (this.eventClassConfig_ != null) {
/* 78 */       argWriter.writeValue("Class", (IReflectionParameterCapable)this.eventClassConfig_);
/*    */     }
/* 80 */     argWriter.writeValue("Value", "String", this.eventName_);
/* 81 */     argWriter.writeFooter("Event");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\EventTypeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */