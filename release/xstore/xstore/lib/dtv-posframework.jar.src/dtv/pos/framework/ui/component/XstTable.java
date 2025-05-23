/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.listview.config.ViewElementFactory;
/*     */ import dtv.pos.framework.ui.model.DefaultXstTableModel;
/*     */ import dtv.pos.framework.ui.vk.OnScreenKeyboard;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.ui.model.DefaultCombinedTableModel;
/*     */ import dtv.ui.swing.DtvScrollTable;
/*     */ import dtv.ui.swing.DtvTable;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JViewport;
/*     */ import javax.swing.table.TableCellRenderer;
/*     */ import javax.swing.table.TableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XstTable
/*     */   implements IXstViewComponent
/*     */ {
/*     */   private final DtvScrollTable table_;
/*     */   
/*     */   public static void main(String[] args) {
/*  34 */     XstTable table = new XstTable();
/*  35 */     JFrame jf = new JFrame();
/*  36 */     Container cp = jf.getContentPane();
/*  37 */     cp.setLayout(new BorderLayout());
/*     */     
/*  39 */     int rows = 5;
/*  40 */     int cols = 7;
/*  41 */     DefaultCombinedTableModel tableModel = new DefaultCombinedTableModel(5, 7);
/*  42 */     table.setModel((TableModel)tableModel);
/*  43 */     table.getTableComponent().setShowGrid(true);
/*  44 */     table.getTableComponent().setShowHorizontalLines(true);
/*  45 */     table.getTableComponent().setBackground(Color.lightGray);
/*  46 */     table.getTableComponent().setSelectionMode(0);
/*  47 */     table.getTableComponent().setRowSelectionAllowed(true);
/*  48 */     table.getTableComponent().setColumnSelectionAllowed(true);
/*  49 */     table.getTableComponent().setAutoResizeMode(4);
/*  50 */     table.getTableComponent().setRowHeight(80);
/*     */     
/*  52 */     table.getTableComponent().setCellRenderer((TableCellRenderer)ViewElementFactory.getInstance());
/*     */     
/*  54 */     for (int i = 0; i < 5; i++) {
/*  55 */       for (int j = 0; j < 7; j++) {
/*  56 */         tableModel.setValueAt(String.valueOf(i) + String.valueOf(j), i, j);
/*     */       }
/*     */     } 
/*  59 */     cp.add(table.getDisplayComponent(), "Center");
/*  60 */     jf.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XstTable() {
/*  66 */     this(false);
/*     */   }
/*     */   
/*     */   public XstTable(boolean useSimpleRenderer) {
/*  70 */     this((TableModel)new DefaultXstTableModel(), useSimpleRenderer);
/*     */   }
/*     */   
/*     */   public XstTable(TableModel model) {
/*  74 */     this(model, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XstTable(TableModel model, boolean useSimpleRenderer) {
/*  84 */     this.table_ = new DtvScrollTable();
/*     */     
/*  86 */     setUseSimpleRenderer(useSimpleRenderer);
/*  87 */     setModel(model);
/*     */     
/*  89 */     this.table_.getTableComponent().addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mousePressed(MouseEvent e)
/*     */           {
/*  93 */             if (XstTable.this.table_.getTableComponent().isEditing() && 
/*  94 */               ConfigurationMgr.isOnScreenKeyboardEnabled() && ConfigurationMgr.isOnScreenKeyboardAutomaticallyCalled()) {
/*  95 */               OnScreenKeyboard.ensureKeyboardIsShowing();
/*     */             }
/*     */           }
/*     */         });
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
/*     */   public JComponent getDisplayComponent() {
/* 111 */     return (JComponent)getScrollTableComponent();
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 116 */     return (JComponent)getScrollTableComponent().getTableComponent();
/*     */   }
/*     */   
/*     */   public DtvScrollTable getScrollTableComponent() {
/* 120 */     return this.table_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateCellRendererDef(RendererDef argRenderer) {
/* 130 */     getTableComponent().putClientProperty("AlternateCellRendererDef", argRenderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCellRendererDef(RendererDef argRendererDef) {
/* 139 */     getTableComponent().putClientProperty("CellRendererDef", argRendererDef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumnHeaderRendererDef(RendererDef argRendererDef) {
/* 148 */     JViewport colViewport = getScrollTableComponent().getColumnHeader();
/*     */     
/* 150 */     if (colViewport != null && colViewport.getView() instanceof JComponent) {
/* 151 */       JComponent colHeader = (JComponent)colViewport.getView();
/*     */       
/* 153 */       colHeader.putClientProperty("ColumnHeaderRendererDef", argRendererDef);
/* 154 */       colHeader.revalidate();
/* 155 */       colHeader.repaint();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     DtvTable table = getTableComponent();
/*     */     
/* 165 */     table.putClientProperty("ColumnHeaderRendererDef", argRendererDef);
/* 166 */     table.revalidate();
/* 167 */     table.repaint();
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
/*     */   public void setCornerRendererDef(String argCorner, RendererDef argRendererDef) {
/* 182 */     IViewElementType type = (argRendererDef != null) ? argRendererDef.getType() : null;
/* 183 */     getScrollTableComponent().setCorner(argCorner, ViewElementFactory.getInstance().getHeader(type, null));
/*     */   }
/*     */   
/*     */   public void setModel(TableModel argModel) {
/* 187 */     TableModel model = argModel;
/* 188 */     if (model != getTableComponent().getModel()) {
/* 189 */       DefaultXstTableModel defaultXstTableModel; if (model == null) {
/* 190 */         defaultXstTableModel = new DefaultXstTableModel();
/*     */       }
/* 192 */       getScrollTableComponent().setModel((TableModel)defaultXstTableModel);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowHeaderRendererDef(RendererDef argRendererDef) {
/* 202 */     JViewport rowViewport = getScrollTableComponent().getRowHeader();
/*     */     
/* 204 */     if (rowViewport != null && rowViewport.getView() instanceof JComponent) {
/* 205 */       JComponent rowHeader = (JComponent)rowViewport.getView();
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
/* 218 */       rowHeader.putClientProperty("CellRendererDef", argRendererDef);
/* 219 */       rowHeader.revalidate();
/* 220 */       rowHeader.repaint();
/*     */     } 
/*     */     
/* 223 */     DtvTable table = getTableComponent();
/*     */     
/* 225 */     table.putClientProperty("RowHeaderRendererDef", argRendererDef);
/* 226 */     table.revalidate();
/* 227 */     table.repaint();
/*     */   }
/*     */   
/*     */   public void setUseSimpleRenderer(boolean argUseSimpleRenderer) {
/* 231 */     setCellRendererDef(new RendererDef(argUseSimpleRenderer));
/* 232 */     setColumnHeaderRendererDef(new RendererDef(argUseSimpleRenderer));
/* 233 */     setRowHeaderRendererDef(new RendererDef(argUseSimpleRenderer));
/* 234 */     setCornerRendererDef("UPPER_LEFT_CORNER", new RendererDef(argUseSimpleRenderer));
/*     */   }
/*     */   
/*     */   protected DtvScrollTable createScrollTableComponent() {
/* 238 */     return new DtvScrollTable();
/*     */   }
/*     */   
/*     */   protected DtvTable getTableComponent() {
/* 242 */     return getScrollTableComponent().getTableComponent();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\XstTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */