/*     */ package dtv.pos.framework.ui.vk.config;
/*     */ 
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ public class KeyboardConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String ATT_KBD_NAME = "name";
/*     */   private static final String TAG_LAYOUT = "layout";
/*     */   private String name_;
/*  28 */   private Map<String, LayoutConfig> layoutsToName_ = new HashMap<>();
/*  29 */   private Map<Locale, List<LayoutConfig>> layoutsToLocale_ = new HashMap<>();
/*  30 */   private List<LayoutConfig> layouts_ = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKeyboardName() {
/*  37 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LayoutConfig getLayoutConfig(Locale argLocale) {
/*  46 */     if (this.layoutsToLocale_.get(argLocale) != null) {
/*  47 */       return ((List<LayoutConfig>)this.layoutsToLocale_.get(argLocale)).get(0);
/*     */     }
/*     */     
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LayoutConfig getLayoutConfig(String argName) {
/*  59 */     return this.layoutsToName_.get(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, LayoutConfig> getLayoutConfigsToName() {
/*  67 */     return this.layoutsToName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<LayoutConfig> getLayoutConfigurations() {
/*  75 */     return this.layouts_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  81 */     if (argKey.equalsIgnoreCase("name")) {
/*  82 */       this.name_ = OnScreenKeyboard.getTranslation(argValue.toString());
/*     */     }
/*  84 */     if (argKey.equalsIgnoreCase("layout") && argValue instanceof LayoutConfig) {
/*  85 */       LayoutConfig layout = (LayoutConfig)argValue;
/*  86 */       LayoutConfig previous = this.layoutsToName_.get(layout.getName());
/*     */       
/*  88 */       if (previous != null) {
/*  89 */         this.layouts_.remove(previous);
/*  90 */         remove(layout.getLocale(), previous);
/*     */       } 
/*     */       
/*  93 */       this.layoutsToName_.put(layout.getName(), layout);
/*  94 */       this.layouts_.add(layout);
/*  95 */       add(layout.getLocale(), layout);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void add(Locale argLocale, LayoutConfig argLayout) {
/* 105 */     List<LayoutConfig> layouts = null;
/* 106 */     if (this.layoutsToLocale_.get(argLocale) == null) {
/* 107 */       layouts = new ArrayList<>();
/* 108 */       this.layoutsToLocale_.put(argLocale, layouts);
/*     */     } else {
/*     */       
/* 111 */       layouts = this.layoutsToLocale_.get(argLocale);
/*     */     } 
/*     */     
/* 114 */     layouts.add(argLayout);
/*     */   }
/*     */   
/*     */   protected void remove(Locale argLocale, LayoutConfig argLayout) {
/* 118 */     if (argLocale != null && argLayout != null) {
/* 119 */       List<LayoutConfig> layouts = this.layoutsToLocale_.get(argLocale);
/* 120 */       if (layouts != null)
/* 121 */         layouts.remove(argLayout); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\config\KeyboardConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */