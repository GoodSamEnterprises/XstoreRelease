/*    */ package dtv.pos.framework.ui.config;
/*    */ 
/*    */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.ui.IUIController;
/*    */ import dtv.util.ClassPathUtils;
/*    */ import dtv.util.config.reload.ConfigReloader;
/*    */ import dtv.util.config.reload.XstoreConfigResource;
/*    */ import java.net.URL;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import javax.inject.Provider;
/*    */ import org.apache.log4j.Logger;
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
/*    */ 
/*    */ 
/*    */ public class FormConfigReloader
/*    */   extends ConfigReloader
/*    */ {
/* 32 */   private static final Logger _logger = Logger.getLogger(FormConfigReloader.class);
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private FormViewConfigHelper _formConfigHelper;
/*    */   
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */ 
/*    */   
/*    */   protected List<URL> getConfigLocations() {
/* 43 */     return Arrays.asList(ClassPathUtils.getDirectoryBasedConfigFileList("form", XML_EXTENSION));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getFormName(XstoreConfigResource argResource) {
/* 53 */     String name = argResource.getConfigLocation().toString();
/* 54 */     name = name.substring(name.lastIndexOf("/") + 1);
/* 55 */     name = name.substring(0, name.length() - 4);
/* 56 */     return name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void reloadConfig() {
/* 62 */     Iterable<? extends XstoreConfigResource> modifiedResources = getModifiedResources();
/* 63 */     resetFormViewConfig();
/* 64 */     for (XstoreConfigResource configResource : modifiedResources) {
/* 65 */       resetFormComponent(getFormName(configResource));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void resetFormComponent(String argFormName) {
/*    */     try {
/* 76 */       IUIController uiController = ((IModeController)this._modeProvider.get()).getUiController();
/* 77 */       uiController.removeNamedComponent(argFormName);
/*    */     }
/* 79 */     catch (Exception ex) {
/* 80 */       _logger.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void resetFormViewConfig() {
/* 88 */     this._formConfigHelper.initialize();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\FormConfigReloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */