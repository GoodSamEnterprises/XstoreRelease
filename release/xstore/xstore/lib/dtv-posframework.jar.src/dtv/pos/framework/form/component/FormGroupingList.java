/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import com.micros.xstore.config.form.field.FormParameterTypeEnumeration;
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.ui.component.XstGroupingList;
/*     */ import dtv.pos.framework.ui.config.RendererDefConfig;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.model.IGroupingListModel;
/*     */ import dtv.ui.swing.lists.grouping.DtvGroupingList;
/*     */ import dtv.util.StringUtils;
/*     */ import javax.swing.JComponent;
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
/*     */ public class FormGroupingList<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*  43 */   private final XstGroupingList list_ = new XstGroupingList(DtvGroupingList.DEFAULT);
/*     */ 
/*     */   
/*     */   private IRendererDefConfig cellDef;
/*     */ 
/*     */   
/*     */   private IRendererDefConfig columnHeaderDef;
/*     */ 
/*     */   
/*     */   private IRendererDefConfig rowHeaderDef;
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  56 */     return this.list_.getDisplayComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  62 */     return this.list_.getFocusComponent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/*  69 */     IFormViewCellConfig config = (IFormViewCellConfig)argCfg;
/*     */     
/*  71 */     this.cellDef = config.getRendererDef("Cell");
/*  72 */     this.columnHeaderDef = config.getRendererDef("ColumnHeader");
/*  73 */     this.rowHeaderDef = config.getRendererDef("RowHeader");
/*     */     
/*  75 */     super.init(argCfg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/*  83 */     String cellType = argFieldDef.getParameter(FormParameterTypeEnumeration.CELL_TYPE.value());
/*  84 */     if (!StringUtils.isEmpty(cellType)) {
/*  85 */       RendererDefConfig rendererDefConfig = new RendererDefConfig("Cell");
/*  86 */       rendererDefConfig.setSimple(false);
/*  87 */       rendererDefConfig.setType(ViewElementType.valueOf(cellType));
/*  88 */       this.cellDef = (IRendererDefConfig)rendererDefConfig;
/*     */     } 
/*     */ 
/*     */     
/*  92 */     String columnHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.COLUMN_HEADER_TYPE.value());
/*  93 */     if (!StringUtils.isEmpty(columnHeaderType)) {
/*  94 */       RendererDefConfig rendererDefConfig = new RendererDefConfig("RowHeader");
/*  95 */       rendererDefConfig.setSimple(false);
/*  96 */       rendererDefConfig.setType(ViewElementType.valueOf(columnHeaderType));
/*  97 */       this.rowHeaderDef = (IRendererDefConfig)rendererDefConfig;
/*     */     } 
/*     */ 
/*     */     
/* 101 */     String groupHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.GROUPING_HEADER_TYPE.value());
/* 102 */     if (!StringUtils.isEmpty(groupHeaderType)) {
/* 103 */       RendererDefConfig rendererDefConfig = new RendererDefConfig("ColumnHeader");
/* 104 */       rendererDefConfig.setSimple(false);
/* 105 */       rendererDefConfig.setType(ViewElementType.valueOf(groupHeaderType));
/* 106 */       this.columnHeaderDef = (IRendererDefConfig)rendererDefConfig;
/*     */     } 
/*     */     
/* 109 */     super.init(argFieldDef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 116 */     return this.list_.getModel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object argValue) {
/* 123 */     if (!(argValue instanceof IGroupingListModel)) {
/*     */       return;
/*     */     }
/*     */     
/* 127 */     IGroupingListModel model = (IGroupingListModel)argValue;
/* 128 */     model.setGroupHeaderRenderer(this.columnHeaderDef.getType().toString());
/* 129 */     model.setGroupItemRenderer(this.cellDef.getType().toString());
/* 130 */     model.setListHeaderRenderer(this.rowHeaderDef.getType().toString());
/*     */     
/* 132 */     this.list_.setModel(model);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormGroupingList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */