/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.ui.component.XstList;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.model.DefaultListInputModel;
/*     */ import dtv.pos.iframework.form.IActivityModel;
/*     */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.pos.ui.component.PosFormPanel;
/*     */ import dtv.ui.IRenderer;
/*     */ import dtv.ui.RendererData;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.ui.renderer.WrappingTextRendererWithoutCaching;
/*     */ import dtv.ui.swing.DtvList;
/*     */ import dtv.ui.swing.DtvTouchReadyList;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Insets;
/*     */ import java.util.List;
/*     */ import javax.swing.BorderFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class FormActivityStream
/*     */   extends FormPanel
/*     */ {
/*     */   private static final double HEADER_HEIGHT_RATIO = 0.17391304347826086D;
/*     */   private static final double FOOTER_HEIGHT_RATIO = 0.06864988558352403D;
/*  40 */   private static final Image HEADER_BACKGROUND = UIRM.getImage("_imageActivityFeedHeaderBackground");
/*  41 */   protected static final Color FOOTER_BACKGROUND = UIRM
/*  42 */     .getRGBColor("_colorActivityStreamBackground", new Color(99, 99, 99));
/*  43 */   private static final String HEADER_TEXT = FF
/*  44 */     .getTranslatable("_activityStreamHeader").toString(OutputContextType.VIEW);
/*  45 */   private static final IRenderer HEADER_TEXT_RENDERER = (IRenderer)new WrappingTextRendererWithoutCaching(Color.WHITE, UIRM
/*  46 */       .getFont("_fontTitleXLargePlain"), true);
/*     */   
/*     */   private static final double HEADER_LINE_Y_RATIO = 0.6097560975609756D;
/*     */   
/*     */   private static final double HEADER_LINE_WITH_RATIO = 0.85D;
/*     */   
/*     */   private XstList activityStreamList_;
/*     */ 
/*     */   
/*     */   public FormActivityStream() {
/*  56 */     super(new ActivityStreamPanel(), false);
/*     */     
/*  58 */     this.activityStreamList_ = createActivityStreamList();
/*  59 */     getActivityStreamPanel().setActivityList((DtvTouchReadyList)this.activityStreamList_.getDisplayComponent());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argConfig) {
/*  65 */     IFormViewCellConfig config = (IFormViewCellConfig)argConfig;
/*     */     
/*  67 */     IRendererDefConfig cellDef = config.getRendererDef("Cell");
/*  68 */     IRendererDefConfig alternateCellDef = config.getRendererDef("AlternateCell");
/*  69 */     IRendererDefConfig columnHeaderDef = config.getRendererDef("ColumnHeader");
/*  70 */     IRendererDefConfig rowHeaderDef = config.getRendererDef("RowHeader");
/*  71 */     IRendererDefConfig ulCornerDef = config.getRendererDef("UpperLeft");
/*     */     
/*  73 */     if (cellDef != null) {
/*  74 */       this.activityStreamList_.setCellRendererDef(cellDef.toRendererDef());
/*     */     }
/*  76 */     if (alternateCellDef != null) {
/*  77 */       this.activityStreamList_.setAlternateCellRendererDef(alternateCellDef.toRendererDef());
/*     */     }
/*  79 */     if (columnHeaderDef != null) {
/*  80 */       this.activityStreamList_.setColumnHeaderRendererDef(columnHeaderDef.toRendererDef());
/*     */     }
/*  82 */     if (rowHeaderDef != null) {
/*  83 */       this.activityStreamList_.setRowHeaderRendererDef(rowHeaderDef.toRendererDef());
/*     */     }
/*  85 */     if (ulCornerDef != null) {
/*  86 */       this.activityStreamList_.setCornerRendererDef("UPPER_LEFT_CORNER", ulCornerDef
/*  87 */           .toRendererDef());
/*     */     }
/*     */     
/*  90 */     EnumPossibleValues ev = config.getEnumPossibleValues();
/*  91 */     if (ev != null) {
/*  92 */       DefaultListInputModel model = new DefaultListInputModel();
/*  93 */       model.getModel().setElements(ev.getValuesList());
/*  94 */       this.activityStreamList_.setModel((ICombinedListModel)model);
/*     */     } 
/*  96 */     super.init(argConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XstList createActivityStreamList() {
/* 104 */     return XstViewComponentFactory.getInstance().createList(DtvList.TOUCH_READY_ACTIVITY_LIST_ID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ActivityStreamPanel getActivityStreamPanel() {
/* 112 */     return (ActivityStreamPanel)getFormPanel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setActivityStream(List<IActivityModel> activityStream) {
/* 120 */     this.activityStreamList_.getListComponent().getListModel().setElements(activityStream);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 126 */     setActivityStream((List<IActivityModel>)value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ActivityStreamPanel
/*     */     extends PosFormPanel
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private DtvTouchReadyList activityList_;
/*     */ 
/*     */ 
/*     */     
/* 145 */     private RendererData data_ = new RendererData();
/* 146 */     private Insets margin_ = new Insets(0, 0, 0, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ActivityStreamPanel() {
/* 153 */       setLayout(null);
/* 154 */       setOpaque(false);
/* 155 */       setBorder(BorderFactory.createLineBorder(IXstViewComponent.UIRM.getRGBColor("_colorFormActivityStreamBorder")));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void paint(Graphics g) {
/* 161 */       int headerHeight = (int)Math.round(0.17391304347826086D * getHeight());
/* 162 */       int footerHeight = (int)Math.round(0.06864988558352403D * getHeight());
/*     */ 
/*     */       
/* 165 */       g.drawImage(FormActivityStream.HEADER_BACKGROUND, 0, 0, getWidth(), headerHeight, null);
/*     */ 
/*     */       
/* 168 */       g.setColor(FormActivityStream.FOOTER_BACKGROUND);
/* 169 */       g.fillRect(0, getHeight() - footerHeight, getWidth(), footerHeight);
/*     */       
/* 171 */       super.paint(g);
/*     */ 
/*     */       
/* 174 */       this.data_.setHorizontalTextPosition(0);
/* 175 */       this.data_.setHorizontalAlignment(0);
/* 176 */       this.data_.setVerticalAlignment(0);
/* 177 */       this.data_.setVerticalTextPosition(0);
/* 178 */       this.data_.setText(FormActivityStream.HEADER_TEXT);
/* 179 */       this.data_.setMargin(this.margin_);
/* 180 */       this.data_.put("useSpecifiedDimensions", Boolean.valueOf(true));
/* 181 */       FormActivityStream.HEADER_TEXT_RENDERER.paint(g, (Component)this, this.data_, 0, 0, getWidth(), headerHeight - this.activityList_
/* 182 */           .getArrowUp().getHeight(), null);
/*     */       
/* 184 */       g.setColor(Color.WHITE);
/* 185 */       int width = (int)(getWidth() * 0.85D);
/* 186 */       g.drawLine((getWidth() - width) / 2, (int)(0.6097560975609756D * headerHeight), (
/* 187 */           getWidth() + width) / 2, (int)(0.6097560975609756D * headerHeight));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setActivityList(DtvTouchReadyList argList) {
/* 195 */       this.activityList_ = argList;
/* 196 */       add((Component)this.activityList_);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setBounds(int argX, int argY, int argWidth, int argHeight) {
/* 202 */       super.setBounds(argX, argY, argWidth, argHeight);
/* 203 */       int headerHeight = (int)Math.round(0.17391304347826086D * argHeight);
/* 204 */       int footerHeight = (int)Math.round(0.06864988558352403D * argHeight);
/*     */       
/* 206 */       int activityListHeight = argHeight - headerHeight - footerHeight + this.activityList_.getArrowUp().getHeight() + this.activityList_.getArrowDown().getHeight();
/* 207 */       this.activityList_.setBounds(0, headerHeight - this.activityList_.getArrowUp().getHeight(), argWidth, activityListHeight);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormActivityStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */