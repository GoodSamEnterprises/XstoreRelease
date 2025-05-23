/*    */ package dtv.pos.framework.event;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ISavableConfig;
/*    */ import dtv.util.config.IXmlWriter;
/*    */ import java.io.IOException;
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
/*    */ public class ContextEventMapConfig
/*    */   extends AbstractParentConfig
/*    */   implements ISavableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public static final String MAIN_TAG = "ContextMapping";
/*    */   public static final String MAIN_DTYPE = "ContextEventMap";
/*    */   private static final String CONTEXT_TAG = "Context";
/*    */   private static final String EVENT_MAP_ID_TAG = "EventMapId";
/*    */   private String context_;
/*    */   private String eventMapId_;
/*    */   
/*    */   public String getContext() {
/* 31 */     return this.context_;
/*    */   }
/*    */   
/*    */   public String getMapId() {
/* 35 */     return this.eventMapId_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 40 */     if ("context".equalsIgnoreCase(argKey) || "name".equalsIgnoreCase(argKey) || "Context"
/* 41 */       .equalsIgnoreCase(argKey)) {
/*    */       
/* 43 */       this.context_ = argValue.toString();
/*    */     }
/* 45 */     else if ("map".equalsIgnoreCase(argKey) || "EventMapId".equalsIgnoreCase(argKey)) {
/* 46 */       this.eventMapId_ = argValue.toString();
/*    */     } else {
/*    */       
/* 49 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(IXmlWriter argWriter) throws IOException {
/* 57 */     argWriter.writeHeader("ContextMapping", "ContextEventMap", "name=\"" + this.context_.toString() + "\"");
/*    */ 
/*    */ 
/*    */     
/* 61 */     argWriter.writeValue("EventMapId", "String", this.eventMapId_);
/*    */     
/* 63 */     argWriter.writeFooter("ContextMapping");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\ContextEventMapConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */