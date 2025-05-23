/*     */ package dtv.pos.framework.form.design.model;
/*     */ 
/*     */ import dtv.pos.iframework.form.config.FormPanelType;
/*     */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*     */ import dtv.pos.iframework.form.design.model.ILayoutParameters;
/*     */ import dtv.util.StringUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class PanelEditModel
/*     */   extends AbstractDetailEditModel
/*     */ {
/*  23 */   private static final Logger logger = Logger.getLogger(PanelEditModel.class);
/*     */   
/*     */   private final IFormViewPanelConfig config;
/*     */   
/*     */   private final ILayoutParameters params;
/*     */   private static final int PANEL_TYPE = 0;
/*     */   private static final int FORM_TAB_KEY = 1;
/*     */   private static final int RESOURCE = 2;
/*     */   private static final int TEXT_KEY = 3;
/*     */   private static final int ROW_COUNT = 4;
/*     */   private static final int COLUMN_COUNT = 5;
/*     */   private static final int ROW_SIZES = 6;
/*     */   private static final int COLUMN_SIZES = 7;
/*     */   private static final int GAPS = 8;
/*     */   private static final int VERTICAL_STRETCH = 9;
/*     */   private static final int TAB_ORDER = 10;
/*     */   private static final int VISIBLE = 11;
/*     */   private static final int MODEL_ROW_COUNT = 12;
/*     */   
/*     */   public PanelEditModel(IFormViewPanelConfig argPanelConfig) {
/*  43 */     super(12, new String[] { "type", "form tab key", "resource", "textkey", "row count", "column count", "row sizes", "column sizes", "gaps", "vertical stretch", "tab order", "visible" }, new Class[] { FormPanelType.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class, Boolean.class, Integer.class, Boolean.class });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.config = argPanelConfig;
/*  51 */     this.params = this.config.getEditableLayoutParameters();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/*  56 */     if (columnIndex == 0) {
/*  57 */       return super.getValueAt(rowIndex, columnIndex);
/*     */     }
/*  59 */     switch (rowIndex) {
/*     */       case 0:
/*  61 */         return this.config.getPanelType();
/*     */       case 1:
/*  63 */         return this.config.getFormTabKey();
/*     */       case 3:
/*  65 */         return this.config.getTextKey().getUnformattedData();
/*     */       case 10:
/*  67 */         return this.config.getTabOrder();
/*     */       case 11:
/*  69 */         return Boolean.valueOf(this.config.getVisible());
/*     */     } 
/*  71 */     if (hasCustomView()) {
/*  72 */       return null;
/*     */     }
/*     */     
/*  75 */     switch (rowIndex) {
/*     */       case 2:
/*  77 */         return this.config.getResource();
/*     */       case 4:
/*  79 */         return this.params.getRowCount();
/*     */       case 5:
/*  81 */         return this.params.getColumnCount();
/*     */       case 6:
/*  83 */         return makeString(this.params.getRowSizes());
/*     */       case 7:
/*  85 */         return makeString(this.params.getColumnSizes());
/*     */       case 8:
/*  87 */         return this.params.getGaps();
/*     */       case 9:
/*  89 */         return this.params.getVerticalStretch();
/*     */     } 
/*  91 */     logger.warn("unexpected row " + rowIndex);
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/*  99 */     if (columnIndex == 1) {
/* 100 */       switch (rowIndex) {
/*     */         case 0:
/* 102 */           this.config.setPanelType((FormPanelType)aValue);
/*     */           return;
/*     */         case 1:
/* 105 */           this.config.setFormTabKey("" + aValue);
/*     */           return;
/*     */         case 3:
/* 108 */           this.config.setTextKey("" + aValue);
/*     */           return;
/*     */         case 10:
/* 111 */           this.config.setTabOrder(Integer.valueOf("" + aValue));
/*     */           return;
/*     */         case 11:
/* 114 */           this.config.setVisible((Boolean)aValue);
/*     */           return;
/*     */       } 
/* 117 */       if (!hasCustomView()) {
/* 118 */         switch (rowIndex) {
/*     */           case 2:
/* 120 */             this.config.setResource(StringUtils.nonNull(aValue));
/*     */             return;
/*     */           case 4:
/* 123 */             this.params.setRowCount(Integer.valueOf("" + aValue));
/*     */             return;
/*     */           case 5:
/* 126 */             this.params.setColumnCount(Integer.valueOf("" + aValue));
/*     */             return;
/*     */           case 6:
/* 129 */             this.params.setRowSizes(parseToDoubleArray("" + aValue));
/*     */             return;
/*     */           case 7:
/* 132 */             this.params.setColumnSizes(parseToDoubleArray("" + aValue));
/*     */             return;
/*     */           case 8:
/* 135 */             this.params.setGaps(StringUtils.nonNull(aValue));
/*     */             return;
/*     */           case 9:
/* 138 */             this.params.setVerticalStretch((Boolean)aValue);
/*     */             return;
/*     */         } 
/* 141 */         logger.warn("unexpected row " + rowIndex);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean hasCustomView() {
/* 151 */     return (this.config.getCustomViewClass() != null);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\model\PanelEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */