/*    */ package dtv.pos.framework.ui;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*    */ import dtv.pos.framework.ui.config.ViewInterfaceConfig;
/*    */ import dtv.pos.framework.ui.config.ViewInterfaceSetConfig;
/*    */ import dtv.util.config.ConfigHelper;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
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
/*    */ public class UIConfigHelper
/*    */   extends ConfigHelper<ViewInterfaceSetConfig>
/*    */ {
/* 23 */   private final Map<String, ViewInterfaceConfig> _uiHash = new HashMap<>();
/*    */ 
/*    */   
/*    */   public ViewInterfaceConfig getUIConfig(String argUIName) {
/* 27 */     return this._uiHash.get(argUIName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeImpl() {
/* 33 */     super.initializeImpl();
/*    */     
/* 35 */     Collection<?> children = getRootChildren(ViewInterfaceSetConfig.class);
/* 36 */     if (children != null) {
/* 37 */       for (Object name : children) {
/* 38 */         ViewInterfaceConfig config = (ViewInterfaceConfig)name;
/* 39 */         this._uiHash.put(config.getName(), config);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getConfigFileName() {
/* 47 */     return "UIConfig";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IConfigObject getConfigObject(String argTagName, String dtype, String argSourceDescription) {
/* 54 */     if ("UISet".equalsIgnoreCase(dtype)) {
/* 55 */       return (IConfigObject)new ViewInterfaceSetConfig();
/*    */     }
/*    */     
/* 58 */     if ("UI".equalsIgnoreCase(dtype)) {
/* 59 */       return (IConfigObject)new ViewInterfaceConfig();
/*    */     }
/*    */     
/* 62 */     if ("Component".equalsIgnoreCase(dtype)) {
/* 63 */       return (IConfigObject)new ViewComponentConfig();
/*    */     }
/*    */     
/* 66 */     return super.getConfigObject(argTagName, dtype, argSourceDescription);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\UIConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */