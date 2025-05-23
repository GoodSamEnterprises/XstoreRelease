/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
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
/*     */ public class FormViewSectionConfig
/*     */   extends AbstractFormComponentConfig
/*     */   implements IFormViewSectionConfig<IFormComponentConfig>
/*     */ {
/*     */   public static final String MAIN_TAG = "FormViewSection";
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Integer getFieldWeight() {
/*  34 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormViewPanelConfig getFormViewPanel() {
/*  40 */     return getChildren().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResource() {
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getTextKey() {
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getValue() {
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlwaysEnabled() {
/*  70 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEquivalent(Object argO) {
/*  76 */     if (!(argO instanceof FormViewSectionConfig)) {
/*  77 */       return false;
/*     */     }
/*  79 */     FormViewSectionConfig other = (FormViewSectionConfig)argO;
/*     */     
/*  81 */     return ObjectUtils.equivalent(other.getName(), getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRequired() {
/*  93 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  99 */     if (argKey.equalsIgnoreCase("FormViewPanel")) {
/* 100 */       setFormViewPanel((FormViewPanelConfig)argValue);
/*     */     } else {
/*     */       
/* 103 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/* 105 */     setClean();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormViewPanel(IFormViewPanelConfig argPanel) {
/* 111 */     getChildren().clear();
/* 112 */     addChild((IViewComponentConfig)argPanel);
/* 113 */     setDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(IXmlWriter argWriter) throws IOException {
/* 121 */     StringBuilder attr = new StringBuilder();
/* 122 */     if (!StringUtils.isEmpty(getName())) {
/* 123 */       attr.append(" name=\"").append(getName()).append("\"");
/*     */     }
/* 125 */     if (!getVisible()) {
/* 126 */       attr.append(" visible=\"false\"");
/*     */     }
/* 128 */     argWriter.writeHeader("FormViewSection", "FormViewSection", attr.toString().trim());
/* 129 */     argWriter.writeValue((ISavableConfig)getFormViewPanel());
/* 130 */     argWriter.writeFooter("FormViewSection");
/*     */     
/* 132 */     setClean();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\FormViewSectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */