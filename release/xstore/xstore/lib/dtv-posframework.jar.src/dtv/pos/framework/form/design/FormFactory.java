/*     */ package dtv.pos.framework.form.design;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*     */ import dtv.pos.framework.form.config.FormViewConfig;
/*     */ import dtv.pos.framework.form.config.FormViewPanelConfig;
/*     */ import dtv.pos.framework.form.config.FormViewSectionConfig;
/*     */ import dtv.pos.framework.form.config.FormViewSectionRefConfig;
/*     */ import dtv.pos.framework.ui.config.ColorGroupConfig;
/*     */ import dtv.pos.framework.ui.config.FontConfig;
/*     */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*     */ import dtv.pos.iframework.form.FormLocationType;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewSectionRefConfig;
/*     */ import dtv.pos.iframework.form.design.model.ILayoutParameters;
/*     */ import dtv.pos.iframework.form.design.type.FormComponentType;
/*     */ import dtv.pos.iframework.ui.FontStyle;
/*     */ import dtv.pos.iframework.ui.config.IColorGroupConfig;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.ui.layout.TableLayout;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import java.awt.Color;
/*     */ 
/*     */ 
/*     */ public class FormFactory
/*     */ {
/*  29 */   public static final String SYSTEM_PROPERTY = FormFactory.class.getName();
/*     */   private static FormFactory INSTANCE;
/*     */   
/*     */   static {
/*  33 */     String className = System.getProperty(SYSTEM_PROPERTY);
/*     */     try {
/*  35 */       INSTANCE = (FormFactory)Class.forName(className).newInstance();
/*     */     }
/*  37 */     catch (Exception ex) {
/*  38 */       INSTANCE = new FormFactory();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FormFactory getInstance() {
/*  49 */     return INSTANCE;
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
/*     */   
/*     */   public IFormViewCellConfig makeCell(FormComponentType argType, int argRow, int argColumn) {
/*  64 */     FormViewCellConfig formViewCellConfig = new FormViewCellConfig();
/*  65 */     if (isLabel(argType)) {
/*  66 */       formViewCellConfig.setTextKey("_formDesignerNewComponent");
/*  67 */       if (argType == FormComponentType.LABEL) {
/*  68 */         ((FontConfig)formViewCellConfig.getFontConfig()).setFontStyle(FontStyle.BOLD);
/*     */       }
/*     */     } 
/*  71 */     if (argType.equals(FormComponentType.RULE)) {
/*  72 */       formViewCellConfig.setHeight(Integer.valueOf(15));
/*  73 */       ColorGroupConfig colors = new ColorGroupConfig();
/*  74 */       colors.setFgColor(new Color(159, 45, 45));
/*  75 */       formViewCellConfig.setColorGroupConfig((IColorGroupConfig)colors);
/*     */     } 
/*  77 */     formViewCellConfig.setType(argType.toString());
/*  78 */     ((ViewComponentConfig)formViewCellConfig).setLayoutLocation(argColumn + "," + argRow + ",1,1");
/*  79 */     return (IFormViewCellConfig)formViewCellConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormViewConfig makeForm(FormKey argFormKey) {
/*  89 */     FormViewConfig config = new FormViewConfig();
/*  90 */     config.setFormKey(argFormKey);
/*  91 */     config.setFormLocation(FormLocationType.MULTI_PURPOSE_VIEW);
/*     */     
/*  93 */     IFormViewPanelConfig panelConfig = makePanel();
/*  94 */     config.addViewPanelConfig(panelConfig);
/*  95 */     return config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormViewPanelConfig makePanel() {
/* 104 */     FormViewPanelConfig formViewPanelConfig = new FormViewPanelConfig();
/* 105 */     formViewPanelConfig.setLayout(new ClassConfig(TableLayout.class));
/* 106 */     ILayoutParameters layoutParams = formViewPanelConfig.getEditableLayoutParameters();
/* 107 */     layoutParams.setRowSizes(new double[] { -2.0D, -1.0D });
/* 108 */     layoutParams.setColumnSizes(new double[] { -1.0D, -1.0D });
/* 109 */     for (int column = 0; column < 2; column++) {
/* 110 */       formViewPanelConfig.addChild((IViewComponentConfig)makeCell(FormComponentType.LABEL, 0, column));
/*     */     }
/* 112 */     return (IFormViewPanelConfig)formViewPanelConfig;
/*     */   }
/*     */   
/*     */   public IFormViewSectionConfig makeSection() {
/* 116 */     FormViewSectionConfig formViewSectionConfig = new FormViewSectionConfig();
/* 117 */     formViewSectionConfig.setFormViewPanel(makePanel());
/* 118 */     return (IFormViewSectionConfig)formViewSectionConfig;
/*     */   }
/*     */   
/*     */   public IFormViewSectionRefConfig makeSectionRef() {
/* 122 */     return (IFormViewSectionRefConfig)new FormViewSectionRefConfig();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isLabel(FormComponentType argType) {
/* 128 */     if (argType == FormComponentType.LABEL || argType == FormComponentType.LABEL_DIMINISHED || argType == FormComponentType.LABEL_WRAPPING || argType == FormComponentType.LABEL_WRAPPING_DIMINISHED)
/*     */     {
/*     */       
/* 131 */       return true;
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\FormFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */