/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*     */ import dtv.util.config.ConfigHelper;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormLayoutConfigHelper
/*     */   extends ConfigHelper<FormLayoutSetConfig>
/*     */ {
/*     */   private Map<String, FormLayoutConfig> layoutMap_;
/*     */   private FormLayoutConfig defaultLayout_;
/*     */   private boolean initialized_;
/*     */   
/*     */   private FormLayoutConfigHelper() {
/*  31 */     this.defaultLayout_ = null;
/*  32 */     this.initialized_ = false;
/*  33 */     initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormLayoutConfig getFormLayout(String argLayoutName) {
/*  44 */     if (argLayoutName == null) {
/*  45 */       return this.defaultLayout_;
/*     */     }
/*     */     
/*  48 */     FormLayoutConfig layout = this.layoutMap_.get(argLayoutName.trim().toUpperCase());
/*  49 */     return (layout != null) ? layout : this.defaultLayout_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeImpl() {
/*  58 */     if (!this.initialized_) {
/*  59 */       super.initializeImpl();
/*  60 */       this.layoutMap_ = new HashMap<>();
/*     */       
/*  62 */       Collection children = getRootChildren(FormLayoutSetConfig.class);
/*  63 */       if (children != null) {
/*  64 */         for (Iterator<FormLayoutConfig> iter = children.iterator(); iter.hasNext(); ) {
/*  65 */           FormLayoutConfig config = iter.next();
/*  66 */           this.layoutMap_.put(config.getName(), config);
/*     */         } 
/*     */       }
/*  69 */       FormLayoutSetConfig root = (FormLayoutSetConfig)getRootParent(FormLayoutSetConfig.class);
/*  70 */       String defaultLayoutName = root.getDefaultLayoutName().trim().toUpperCase();
/*     */       
/*  72 */       this.defaultLayout_ = this.layoutMap_.get(defaultLayoutName);
/*  73 */       this.initialized_ = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getConfigFileName() {
/*  83 */     return "FormLayoutConfig";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IConfigObject getConfigObject(String argTagName, String argDtype, String argSourceDescription) {
/*  97 */     if ("FormLayoutSet".equalsIgnoreCase(argDtype)) {
/*  98 */       return (IConfigObject)new FormLayoutSetConfig();
/*     */     }
/* 100 */     if ("FormLayout".equalsIgnoreCase(argDtype)) {
/* 101 */       return (IConfigObject)new FormLayoutConfig();
/*     */     }
/* 103 */     if ("Component".equalsIgnoreCase(argDtype)) {
/* 104 */       return (IConfigObject)new ViewComponentConfig();
/*     */     }
/* 106 */     return super.getConfigObject(argTagName, argDtype, argSourceDescription);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormLayoutConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */